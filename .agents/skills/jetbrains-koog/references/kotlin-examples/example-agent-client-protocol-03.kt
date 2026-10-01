// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentClientProtocol03

import ai.koog.prompt.executor.model.PromptExecutor
import com.agentclientprotocol.agent.AgentInfo
import com.agentclientprotocol.agent.AgentSession
import com.agentclientprotocol.agent.AgentSupport
import com.agentclientprotocol.client.ClientInfo
import com.agentclientprotocol.common.Event
import com.agentclientprotocol.common.SessionCreationParameters
import com.agentclientprotocol.model.AgentCapabilities
import com.agentclientprotocol.model.ContentBlock
import com.agentclientprotocol.model.LATEST_PROTOCOL_VERSION
import com.agentclientprotocol.model.PromptCapabilities
import com.agentclientprotocol.model.SessionId
import com.agentclientprotocol.protocol.Protocol
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.JsonElement
import ai.koog.utils.time.KoogClock
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
class MyAgentSession(
    override val sessionId: SessionId,
    private val promptExecutor: PromptExecutor,
    private val protocol: Protocol,
    private val clock: KoogClock
): AgentSession {
    override suspend fun prompt(
        content: List<ContentBlock>,
        _meta: JsonElement?
    ): Flow<Event> {
        TODO("Not yet implemented")
    }
}

class MyAgentSupport(
    private val promptExecutor: PromptExecutor,
    private val clock: KoogClock,
    private val protocol: Protocol,
) : AgentSupport {

    override suspend fun initialize(clientInfo: ClientInfo): AgentInfo {
        return AgentInfo(
            protocolVersion = LATEST_PROTOCOL_VERSION,
            capabilities = AgentCapabilities(
                loadSession = false, // Set to true if you implement session persistence
                promptCapabilities = PromptCapabilities(
                    audio = false,
                    image = false,
                    embeddedContext = true
                )
            )
        )
    }

    @OptIn(ExperimentalUuidApi::class)
    override suspend fun createSession(sessionParameters: SessionCreationParameters): AgentSession {
        val sessionId = SessionId(Uuid.random().toString())
        return MyAgentSession(sessionId, promptExecutor, protocol, clock)
    }

    override suspend fun loadSession(sessionId: SessionId, sessionParameters: SessionCreationParameters): AgentSession {
        throw UnsupportedOperationException("Session loading not implemented")
    }
}
