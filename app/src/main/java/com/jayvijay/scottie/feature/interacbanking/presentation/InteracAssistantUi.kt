package com.jayvijay.scottie.feature.interacbanking.presentation

import android.Manifest
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DeleteSweep
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.a2ui.A2uiSurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieCodeSmall
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieToast
import com.jayvijay.scottie.core.ui.components.ScottieToolbar
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.presentation.component.Composer
import com.jayvijay.scottie.feature.interacbanking.presentation.component.EmptyState
import com.jayvijay.scottie.feature.interacbanking.presentation.component.ReplyCard
import com.jayvijay.scottie.feature.interacbanking.presentation.component.RevealText
import com.jayvijay.scottie.feature.interacbanking.presentation.component.ThinkingDots
import com.jayvijay.scottie.feature.interacbanking.presentation.component.UserBubble
import com.jayvijay.scottie.feature.interacbanking.presentation.component.Welcome
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.ui.Ui
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

const val TAG_LOGO = "chat_logo"
const val TAG_CLEAR_CHAT = "chat_clear"
const val TAG_VOICE_ERROR = "chat_voice_error"

@CircuitInject(InteracAssistantScreen::class, SingletonComponent::class)
class InteracAssistantUi @Inject constructor() : Ui<InteracAssistantState> {

  @OptIn(ExperimentalFoundationApi::class)
  @Composable
  override fun Content(state: InteracAssistantState, modifier: Modifier) {
    val colors = ScottieTheme.colors
    val haptic = LocalHapticFeedback.current
    val voiceIdle = state.voiceState == VoiceState.Idle
    val canClear =
      !state.busy && voiceIdle && (state.turns.isNotEmpty() || state.input.isNotBlank())
    val requestOrStartRecord =
      rememberRecordAudioPermissionGate(
        onGranted = { state.eventSink(InteracAssistantAction.ToggleRecording) },
        onDenied = { state.eventSink(InteracAssistantAction.MicrophonePermissionDenied) },
      )

    DisposableEffect(Unit) {
      onDispose { state.eventSink(InteracAssistantAction.CancelRecording) }
    }

    Box(
      modifier =
        modifier.fillMaxSize().background(colors.surfaceCanvas).safeDrawingPadding().imePadding()
    ) {
      Column(modifier = Modifier.fillMaxSize()) {
        ScottieToolbar(
          title = stringResource(R.string.chat_header_logo),
          titleContent = {
            Text(
              text = stringResource(R.string.chat_header_logo),
              modifier =
                Modifier.combinedClickable(
                    onClick = {},
                    onLongClickLabel = stringResource(R.string.chat_settings),
                    onLongClick = {
                      haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                      state.eventSink(InteracAssistantAction.OpenSettings)
                    },
                  )
                  .semantics { heading() }
                  .testTag(TAG_LOGO),
              style = MaterialTheme.typography.headlineSmall,
              color = colors.textPrimary,
            )
          },
          actions = {
            IconButton(
              onClick = { state.eventSink(InteracAssistantAction.ClearChat) },
              enabled = canClear,
              modifier = Modifier.padding(end = 8.dp).size(36.dp).testTag(TAG_CLEAR_CHAT),
            ) {
              Icon(
                imageVector = Icons.Rounded.DeleteSweep,
                contentDescription = stringResource(R.string.chat_clear),
                tint = if (canClear) colors.textSecondary else colors.textTertiary,
                modifier = Modifier.size(18.dp),
              )
            }
          },
        )
        if (state.missingModel) {
          Box(
            modifier = Modifier.weight(1f).fillMaxWidth().padding(16.dp),
            contentAlignment = Alignment.Center,
          ) {
            EmptyState(onDownload = { state.eventSink(InteracAssistantAction.OpenSettings) })
          }
          return@Column
        }
        if (state.turns.isEmpty()) {
          Welcome(
            onExample = { state.eventSink(InteracAssistantAction.InputChanged(it)) },
            modifier = Modifier.weight(1f).padding(16.dp),
          )
        } else {
          Turns(state, modifier = Modifier.weight(1f).fillMaxWidth())
        }
        Composer(
          value = state.input,
          enabled = !state.busy && voiceIdle && state.input.isNotBlank(),
          onValueChange = { state.eventSink(InteracAssistantAction.InputChanged(it)) },
          onSend = {
            haptic.performHapticFeedback(HapticFeedbackType.Confirm)
            state.eventSink(InteracAssistantAction.Send)
          },
          modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
          showRecord = state.activeAudioModelId != null,
          voiceState = state.voiceState,
          recordEnabled = !state.busy && state.voiceState != VoiceState.Transcribing,
          onToggleRecord = {
            haptic.performHapticFeedback(HapticFeedbackType.Confirm)
            if (state.voiceState == VoiceState.Recording) {
              state.eventSink(InteracAssistantAction.ToggleRecording)
            } else {
              requestOrStartRecord()
            }
          },
        )
      }

      state.voiceError?.let { error ->
        val messageRes =
          when (error) {
            VoiceError.PermissionDenied -> R.string.chat_mic_permission_denied
            is VoiceError.Failed -> error.failure.message(R.string.chat_voice_failed)
          }
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)) {
          ScottieToast(
            message = stringResource(messageRes),
            actionLabel = stringResource(R.string.model_download_dismiss),
            onAction = { state.eventSink(InteracAssistantAction.DismissVoiceError) },
            modifier = Modifier.testTag(TAG_VOICE_ERROR),
          )
        }
      }
    }
  }
}

@Composable
private fun rememberRecordAudioPermissionGate(
  onGranted: () -> Unit,
  onDenied: () -> Unit,
): () -> Unit {
  val context = LocalContext.current
  val launcher =
    rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
      if (granted) onGranted() else onDenied()
    }
  return {
    val granted =
      ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) ==
        PackageManager.PERMISSION_GRANTED
    if (granted) {
      onGranted()
    } else {
      launcher.launch(Manifest.permission.RECORD_AUDIO)
    }
  }
}

/**
 * Newest turn first in a reversed list: the bottom stays pinned while the last reply grows, and a
 * reader who scrolled up is not pulled back (FR-013). A new turn jumps to the bottom.
 */
@Composable
private fun Turns(state: InteracAssistantState, modifier: Modifier = Modifier) {
  val listState = rememberLazyListState()
  LaunchedEffect(state.turns.size) { listState.scrollToItem(0) }
  LazyColumn(
    state = listState,
    modifier = modifier,
    reverseLayout = true,
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    verticalArrangement = Arrangement.spacedBy(20.dp),
  ) {
    items(state.turns.asReversed(), key = { it.id }) { turn -> Turn(turn, state) }
  }
}

@Composable
private fun Turn(turn: AssistantTurn, state: InteracAssistantState) {
  Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
    UserBubble(turn.userText)
    val textCard = Modifier.widthIn(max = 340.dp)
    when (val reply = turn.reply) {
      TurnReply.Thinking -> ReplyCard { ThinkingDots() }
      is TurnReply.Text ->
        ReplyCard(textCard) {
          RevealText(reply.message ?: stringResource(R.string.assistant_off_topic), turn.id)
        }
      TurnReply.Fallback -> ReplyCard(textCard) { ReplyText(R.string.assistant_fallback) }
      is TurnReply.Failed -> ReplyCard(textCard) { ReplyText(reply.failure.message()) }
      is TurnReply.Surface ->
        state.surfaces
          .firstOrNull { it.id == reply.surfaceId }
          ?.let { surface ->
            ReplyCard(Modifier.fillMaxWidth()) {
              key(surface.id) {
                A2uiSurface(surfaceModel = surface, modifier = Modifier.fillMaxWidth())
              }
            }
          }
    }
    val flags = LocalContext.current.applicationInfo.flags
    val debuggable = flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    if (debuggable && turn.firstCardMs != null) {
      Text(
        text = stringResource(R.string.assistant_latency_debug, turn.firstCardMs),
        style = ScottieCodeSmall,
        color = ScottieTheme.colors.textTertiary,
      )
    }
  }
}

private fun InferenceFailure.message(unknownRes: Int = R.string.chat_reply_failed): Int =
  when (this) {
    InferenceFailure.OFFLINE -> R.string.chat_reply_offline
    InferenceFailure.UNAUTHORIZED -> R.string.chat_reply_unauthorized
    InferenceFailure.MODEL_UNAVAILABLE -> R.string.chat_reply_model_unavailable
    InferenceFailure.UNKNOWN -> unknownRes
  }

@Composable
private fun ReplyText(resId: Int) {
  Text(
    text = stringResource(resId),
    style = MaterialTheme.typography.bodyLarge,
    color = ScottieTheme.colors.textPrimary,
  )
}

private fun previewState(
  turns: List<AssistantTurn>,
  activeModelId: String? = "gemma-4-E2B-it.litertlm",
) =
  InteracAssistantState(
    activeModelId = activeModelId,
    turns = turns,
    input = "",
    busy = false,
    missingModel = activeModelId == null,
    surfaces = emptyList(),
    eventSink = {},
  )

@Preview(name = "Turns", widthDp = 390, heightDp = 844)
@Preview(
  name = "Turns dark",
  widthDp = 390,
  heightDp = 844,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun InteracAssistantPreview() {
  ScottieTheme {
    InteracAssistantUi()
      .Content(
        previewState(
          listOf(
            AssistantTurn(1, "What's the weather?", TurnReply.Text(null)),
            AssistantTurn(2, "Send $50 to Alice", TurnReply.Thinking),
          )
        ),
        Modifier,
      )
  }
}

@Preview(name = "Failed reply", widthDp = 390, heightDp = 844)
@Composable
private fun InteracAssistantFailedPreview() {
  ScottieTheme {
    InteracAssistantUi()
      .Content(
        previewState(
          listOf(
            AssistantTurn(1, "Send money", TurnReply.Failed(InferenceFailure.UNKNOWN)),
            AssistantTurn(2, "What's my balance?", TurnReply.Failed(InferenceFailure.OFFLINE)),
          )
        ),
        Modifier,
      )
  }
}

@Preview(name = "Welcome", widthDp = 390, heightDp = 844)
@Composable
private fun InteracAssistantWelcomePreview() {
  ScottieTheme { InteracAssistantUi().Content(previewState(emptyList()), Modifier) }
}

@Preview(name = "Empty state", widthDp = 390, heightDp = 844)
@Composable
private fun InteracAssistantEmptyStatePreview() {
  ScottieTheme {
    InteracAssistantUi().Content(previewState(emptyList(), activeModelId = null), Modifier)
  }
}
