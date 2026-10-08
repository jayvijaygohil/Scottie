package com.jayvijay.scottie.feature.interacbanking.presentation

import android.content.pm.ApplicationInfo
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.a2ui.A2uiSurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieToolbar
import com.jayvijay.scottie.core.ui.xelauikit.XelaButton
import com.jayvijay.scottie.core.ui.xelauikit.models.button.XelaButtonState
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.ui.Ui
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

const val TAG_USER_BUBBLE = "assistant_user_bubble"
const val TAG_REPLY = "assistant_reply"
const val TAG_COMPOSER = "assistant_composer"

@CircuitInject(InteracAssistantScreen::class, SingletonComponent::class)
class InteracAssistantUi @Inject constructor() : Ui<InteracAssistantState> {

  @Composable
  override fun Content(state: InteracAssistantState, modifier: Modifier) {
    Column(
      modifier =
        modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).safeDrawingPadding()
    ) {
      ScottieToolbar(
        title = stringResource(R.string.assistant_title),
        subtitle = state.modelName,
        backLabel = stringResource(R.string.back),
        onBack = { state.eventSink(InteracAssistantAction.Back) },
      )
      if (state.missingModel) {
        Box(modifier = Modifier.fillMaxSize().padding(32.dp), contentAlignment = Alignment.Center) {
          Text(
            stringResource(R.string.assistant_model_missing),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
          )
        }
        return@Column
      }
      LazyColumn(
        modifier = Modifier.weight(1f).fillMaxWidth(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
      ) {
        items(state.turns, key = { it.id }) { turn -> Turn(turn, state) }
      }
      Composer(state)
    }
  }
}

@Composable
private fun Turn(turn: AssistantTurn, state: InteracAssistantState) {
  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
      Surface(
        modifier = Modifier.widthIn(max = 300.dp).testTag(TAG_USER_BUBBLE),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
      ) {
        Text(
          turn.userText,
          modifier = Modifier.padding(12.dp),
          color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
      }
    }
    when (val reply = turn.reply) {
      TurnReply.Thinking -> ReplyText(stringResource(R.string.assistant_thinking))
      is TurnReply.Text -> ReplyText(reply.message ?: stringResource(R.string.assistant_off_topic))
      TurnReply.Fallback -> ReplyText(stringResource(R.string.assistant_fallback))
      is TurnReply.Surface ->
        state.surfaces
          .firstOrNull { it.id == reply.surfaceId }
          ?.let { surface ->
            key(surface.id) {
              A2uiSurface(surfaceModel = surface, modifier = Modifier.fillMaxWidth())
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

@Composable
private fun ReplyText(text: String) {
  Text(
    text,
    modifier = Modifier.fillMaxWidth().testTag(TAG_REPLY),
    style = MaterialTheme.typography.bodyLarge,
  )
}

@Composable
private fun Composer(state: InteracAssistantState) {
  Row(
    modifier = Modifier.fillMaxWidth().padding(16.dp).testTag(TAG_COMPOSER),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    OutlinedTextField(
      value = state.input,
      onValueChange = { state.eventSink(InteracAssistantAction.InputChanged(it)) },
      modifier = Modifier.weight(1f),
      placeholder = { Text(stringResource(R.string.assistant_composer_hint)) },
      maxLines = 3,
    )
    XelaButton(
      text = stringResource(R.string.assistant_send),
      onClick = { state.eventSink(InteracAssistantAction.Send) },
      state =
        if (state.busy || state.input.isBlank()) XelaButtonState.DISABLED
        else XelaButtonState.DEFAULT,
      background = MaterialTheme.colorScheme.primary,
      foregroundColor = MaterialTheme.colorScheme.onPrimary,
    )
  }
}

private fun previewState(turns: List<AssistantTurn>, missingModel: Boolean = false) =
  InteracAssistantState(
    modelName = "gemma-4-E2B-it",
    turns = turns,
    input = "",
    busy = false,
    missingModel = missingModel,
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

@Preview(name = "Fallback", widthDp = 390, heightDp = 844)
@Composable
private fun InteracAssistantFallbackPreview() {
  ScottieTheme {
    InteracAssistantUi()
      .Content(previewState(listOf(AssistantTurn(1, "Send money", TurnReply.Fallback))), Modifier)
  }
}

@Preview(name = "Missing model", widthDp = 390, heightDp = 844)
@Composable
private fun InteracAssistantMissingModelPreview() {
  ScottieTheme {
    InteracAssistantUi().Content(previewState(emptyList(), missingModel = true), Modifier)
  }
}
