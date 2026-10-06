package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui

import androidx.a2ui.compose.runtime.A2uiMessageParser
import androidx.a2ui.compose.ui.A2uiCatalog
import androidx.a2ui.compose.ui.A2uiMessageProcessor
import androidx.a2ui.model.processor.A2uiSurfaceModel
import androidx.a2ui.model.processor.processInput
import androidx.a2ui.model.protocol.A2uiClientToServerMessage
import androidx.compose.runtime.retain.RetainObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/** One A2UI processor per assistant screen: JSON in, surfaces and client events out. */
interface A2uiBridge {
  val surfaces: StateFlow<List<A2uiSurfaceModel>>
  val events: Flow<A2uiClientToServerMessage>

  /** One complete JSON envelope. */
  fun accept(json: String)

  fun close()
}

fun interface A2uiBridgeFactory {
  fun create(): A2uiBridge
}

/** Owns its processing loop; retained by the presenter and closed when the screen is retired. */
class ProcessorA2uiBridge(catalog: A2uiCatalog) : A2uiBridge, RetainObserver {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
  private val parser = A2uiMessageParser()
  private val processor = A2uiMessageProcessor(catalogs = listOf(catalog))

  override val surfaces: StateFlow<List<A2uiSurfaceModel>> = processor.activeSurfaces
  override val events: Flow<A2uiClientToServerMessage> = processor.outboundEvents

  init {
    scope.launch { processor.collectMessages() }
  }

  override fun accept(json: String) = processor.processInput(parser, json)

  override fun close() = scope.cancel()

  override fun onRetained() = Unit

  override fun onEnteredComposition() = Unit

  override fun onExitedComposition() = Unit

  override fun onRetired() = close()

  override fun onUnused() = close()
}
