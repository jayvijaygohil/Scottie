package com.jayvijay.scottie.feature.interacbanking.presentation

import androidx.a2ui.model.processor.A2uiSurfaceModel
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState

data class InteracAssistantState(
  val activeModelId: String?,
  /** Oldest first. */
  val turns: List<AssistantTurn>,
  val input: String,
  /** Inference or submission in flight. */
  val busy: Boolean,
  /** No downloaded text model; the empty state replaces the chat. */
  val missingModel: Boolean,
  /** Live A2UI surfaces; a turn renders the one whose id matches. */
  val surfaces: List<A2uiSurfaceModel>,
  val activeAudioModelId: String? = null,
  val voiceState: VoiceState = VoiceState.Idle,
  val voiceError: VoiceError? = null,
  val eventSink: (InteracAssistantAction) -> Unit,
) : CircuitUiState

enum class VoiceState {
  Idle,
  Recording,
  Transcribing,
}

sealed interface VoiceError {
  data object PermissionDenied : VoiceError

  data class Failed(val failure: InferenceFailure) : VoiceError
}

data class AssistantTurn(
  val id: Int,
  val userText: String,
  val reply: TurnReply,
  /** Debug latency from Send to the first rendered surface; null until measured. */
  val firstCardMs: Long? = null,
)

sealed interface TurnReply {
  data object Thinking : TurnReply

  /** Null message → the UI shows the off-topic resource. */
  data class Text(val message: String?) : TurnReply

  data class Surface(val surfaceId: String) : TurnReply

  /** The form or cards could not be built. */
  data object Fallback : TurnReply

  /** Inference failed; [failure] selects the message. */
  data class Failed(val failure: InferenceFailure) : TurnReply
}

/** App notices travel as codes; the `Alert` component resolves the copy. */
sealed interface Notice {
  data class AccountNotFound(val hint: String) : Notice

  data class NoAccountCovers(val amount: String) : Notice
}

sealed interface InteracAssistantAction : CircuitUiEvent {
  data class InputChanged(val text: String) : InteracAssistantAction

  data object Send : InteracAssistantAction

  /** Clears conversation turns, active surfaces, and unsent input when not busy. */
  data object ClearChat : InteracAssistantAction

  data object OpenSettings : InteracAssistantAction

  data object ToggleRecording : InteracAssistantAction

  data object CancelRecording : InteracAssistantAction

  data object MicrophonePermissionDenied : InteracAssistantAction

  data object DismissVoiceError : InteracAssistantAction
}
