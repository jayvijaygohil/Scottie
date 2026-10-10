package com.jayvijay.scottie.feature.interacbanking.presentation

import android.content.pm.ApplicationInfo
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.a2ui.A2uiSurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieToolbar
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TextModelOption
import com.jayvijay.scottie.feature.interacbanking.presentation.component.Composer
import com.jayvijay.scottie.feature.interacbanking.presentation.component.EmptyState
import com.jayvijay.scottie.feature.interacbanking.presentation.component.ModelSelector
import com.jayvijay.scottie.feature.interacbanking.presentation.component.ReplyCard
import com.jayvijay.scottie.feature.interacbanking.presentation.component.RevealText
import com.jayvijay.scottie.feature.interacbanking.presentation.component.ThinkingDots
import com.jayvijay.scottie.feature.interacbanking.presentation.component.UserBubble
import com.jayvijay.scottie.feature.interacbanking.presentation.component.Welcome
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.ui.Ui
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

const val TAG_SETTINGS = "chat_settings"

@CircuitInject(InteracAssistantScreen::class, SingletonComponent::class)
class InteracAssistantUi @Inject constructor() : Ui<InteracAssistantState> {

  @Composable
  override fun Content(state: InteracAssistantState, modifier: Modifier) {
    Column(
      modifier =
        modifier
          .fillMaxSize()
          .background(MaterialTheme.colorScheme.background)
          .safeDrawingPadding()
          .imePadding()
    ) {
      ScottieToolbar(
        title = stringResource(R.string.app_name),
        titleContent = {
          ModelSelector(
            models = state.models,
            activeId = state.activeModelId,
            enabled = !state.busy && state.models.isNotEmpty(),
            onSelect = { state.eventSink(InteracAssistantAction.SelectModel(it)) },
          )
        },
        actions = {
          IconButton(
            onClick = { state.eventSink(InteracAssistantAction.OpenSettings) },
            modifier = Modifier.testTag(TAG_SETTINGS),
          ) {
            Icon(
              Icons.Rounded.Settings,
              contentDescription = stringResource(R.string.chat_settings),
            )
          }
        },
      )
      if (state.missingModel) {
        EmptyState(
          onDownload = { state.eventSink(InteracAssistantAction.OpenSettings) },
          modifier = Modifier.padding(16.dp),
        )
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
      val haptic = LocalHapticFeedback.current
      Composer(
        value = state.input,
        enabled = !state.busy && state.input.isNotBlank(),
        onValueChange = { state.eventSink(InteracAssistantAction.InputChanged(it)) },
        onSend = {
          haptic.performHapticFeedback(HapticFeedbackType.Confirm)
          state.eventSink(InteracAssistantAction.Send)
        },
        modifier = Modifier.padding(16.dp),
      )
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
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    verticalArrangement = Arrangement.spacedBy(20.dp),
  ) {
    items(state.turns.asReversed(), key = { it.id }) { turn -> Turn(turn, state) }
  }
}

@Composable
private fun Turn(turn: AssistantTurn, state: InteracAssistantState) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
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
        stringResource(R.string.assistant_latency_debug, turn.firstCardMs),
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
  }
}

private fun InferenceFailure.message(): Int =
  when (this) {
    InferenceFailure.OFFLINE -> R.string.chat_reply_offline
    InferenceFailure.UNAUTHORIZED -> R.string.chat_reply_unauthorized
    InferenceFailure.MODEL_UNAVAILABLE -> R.string.chat_reply_model_unavailable
    InferenceFailure.UNKNOWN -> R.string.chat_reply_failed
  }

@Composable
private fun ReplyText(resId: Int) {
  Text(stringResource(resId), style = MaterialTheme.typography.bodyLarge)
}

private fun previewState(
  turns: List<AssistantTurn>,
  activeModelId: String? = "gemma-4-E2B-it.litertlm",
) =
  InteracAssistantState(
    models =
      listOf(
        TextModelOption("gemma-4-E2B-it.litertlm", "Gemma 4 E2B"),
        TextModelOption("qwen.litertlm", "Qwen"),
      ),
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
