package example.a2ui

import androidx.a2ui.compose.runtime.A2uiMessageParser
import androidx.a2ui.compose.ui.A2uiCatalog
import androidx.a2ui.compose.ui.A2uiMessageProcessor
import androidx.a2ui.model.processor.processInput
import androidx.a2ui.model.protocol.A2uiClientToServerMessage
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.a2ui.A2uiSurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/** Create once per session, e.g. with a ViewModel's scope. */
class A2uiSession(
    scope: CoroutineScope,
    catalogs: List<A2uiCatalog>,
    sendOutbound: suspend (A2uiClientToServerMessage) -> Unit,
) {
    private val parser = A2uiMessageParser()
    private val processor = A2uiMessageProcessor(catalogs = catalogs)
    val activeSurfaces = processor.activeSurfaces

    // The parent owns both loops. A failure cancels the session and propagates to scope;
    // choose transport error/reconnection handling in the consuming app.
    private val sessionJob = scope.launch(start = CoroutineStart.UNDISPATCHED) {
        launch(start = CoroutineStart.UNDISPATCHED) {
            processor.outboundEvents.collect { sendOutbound(it) }
        }
        launch(Dispatchers.Default) { processor.collectMessages() }
    }

    /** Pass one complete JSON envelope; frame SSE/JSONL in the transport first. */
    fun acceptJson(json: String) {
        check(sessionJob.isActive) { "A2UI session is not active" }
        processor.processInput(parser, json)
    }

    fun close() {
        sessionJob.cancel()
    }
}

/** Call under the app's MaterialTheme. Adapt layout/collection to the host screen. */
@Composable
fun SessionSurfaces(session: A2uiSession, modifier: Modifier = Modifier) {
    val surfaces by session.activeSurfaces.collectAsState()
    Column(modifier = modifier) {
        for (surface in surfaces) {
            key(surface.id) { A2uiSurface(surfaceModel = surface) }
        }
    }
}
