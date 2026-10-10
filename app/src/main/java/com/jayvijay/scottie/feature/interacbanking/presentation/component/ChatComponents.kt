package com.jayvijay.scottie.feature.interacbanking.presentation.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.xelauikit.XelaButton
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSubheadline
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TextModelOption
import kotlinx.coroutines.delay

const val TAG_USER_BUBBLE = "assistant_user_bubble"
const val TAG_REPLY = "assistant_reply"
const val TAG_COMPOSER = "assistant_composer"
const val TAG_THINKING = "chat_thinking"
const val TAG_SEND = "chat_send"
const val TAG_MODEL_SELECTOR = "chat_model_selector"
const val TAG_MODEL_OPTION = "chat_model_option"
const val TAG_EMPTY_STATE = "chat_empty_state"
const val TAG_WELCOME = "chat_welcome"
const val TAG_EXAMPLE = "chat_example"

private const val REVEAL_WORD_MS = 30L
private const val DOT_COUNT = 3
private const val DOT_PERIOD_MS = 600
private const val DOT_STAGGER_MS = 150
private const val DOT_MIN_ALPHA = 0.3f
private val CardShape = RoundedCornerShape(16.dp)
private val BubbleShape = RoundedCornerShape(16.dp, 16.dp, 4.dp, 16.dp)
private val ComposerShape = RoundedCornerShape(12.dp)

/** Model-side card: same surface, radius, and inner spacing as the Settings model cards. */
@Composable
internal fun ReplyCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
  Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
    Surface(modifier = modifier.testTag(TAG_REPLY), shape = CardShape) {
      Box(modifier = Modifier.padding(16.dp)) { content() }
    }
  }
}

@Composable
internal fun UserBubble(text: String, modifier: Modifier = Modifier) {
  Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
    Surface(
      modifier = Modifier.widthIn(max = 300.dp).testTag(TAG_USER_BUBBLE),
      shape = BubbleShape,
      color = MaterialTheme.colorScheme.primary,
      contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
      Text(text, modifier = Modifier.padding(12.dp), style = MaterialTheme.typography.bodyLarge)
    }
  }
}

@Composable
internal fun ThinkingDots(modifier: Modifier = Modifier) {
  val description = stringResource(R.string.chat_thinking)
  val transition = rememberInfiniteTransition(label = "thinking")
  Row(
    modifier = modifier.semantics { contentDescription = description }.testTag(TAG_THINKING),
    horizontalArrangement = Arrangement.spacedBy(4.dp),
  ) {
    repeat(DOT_COUNT) { index ->
      val alpha by
        transition.animateFloat(
          initialValue = DOT_MIN_ALPHA,
          targetValue = 1f,
          animationSpec =
            infiniteRepeatable(
              tween(DOT_PERIOD_MS, delayMillis = index * DOT_STAGGER_MS),
              RepeatMode.Reverse,
            ),
          label = "dot",
        )
      Box(
        modifier =
          Modifier.size(6.dp)
            .alpha(alpha)
            .background(MaterialTheme.colorScheme.onSurfaceVariant, CircleShape)
      )
    }
  }
}

/**
 * Reveals [text] word by word once per [turnId]; recreation after the reveal completed shows the
 * full text at once. Previews always show the full text.
 */
@Composable
internal fun RevealText(text: String, turnId: Int, modifier: Modifier = Modifier) {
  val inspecting = LocalInspectionMode.current
  var done by rememberSaveable(turnId) { mutableStateOf(inspecting) }
  var shown by remember(turnId) { mutableIntStateOf(if (done) text.length else 0) }
  LaunchedEffect(turnId) {
    if (done) return@LaunchedEffect
    for (match in Regex("\\S+").findAll(text)) {
      shown = match.range.last + 1
      delay(REVEAL_WORD_MS)
    }
    shown = text.length
    done = true
  }
  Text(text.take(shown), modifier = modifier, style = MaterialTheme.typography.bodyLarge)
}

@Composable
internal fun Composer(
  value: String,
  enabled: Boolean,
  onValueChange: (String) -> Unit,
  onSend: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val textStyle =
    MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface)
  Row(
    modifier = modifier.fillMaxWidth().testTag(TAG_COMPOSER),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.Bottom,
  ) {
    Surface(
      modifier =
        Modifier.weight(1f).border(1.dp, MaterialTheme.colorScheme.outlineVariant, ComposerShape),
      shape = ComposerShape,
      color = MaterialTheme.colorScheme.surface,
    ) {
      BasicTextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = 4,
        textStyle = textStyle,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        decorationBox = { field ->
          Box(
            modifier = Modifier.heightIn(min = 44.dp).padding(horizontal = 12.dp, vertical = 10.dp),
            contentAlignment = Alignment.CenterStart,
          ) {
            if (value.isEmpty()) {
              Text(
                text = stringResource(R.string.assistant_composer_hint),
                style = textStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
            field()
          }
        },
      )
    }
    FilledIconButton(
      onClick = onSend,
      enabled = enabled,
      modifier = Modifier.size(44.dp).testTag(TAG_SEND),
      shape = CircleShape,
    ) {
      Icon(
        Icons.AutoMirrored.Rounded.Send,
        contentDescription = stringResource(R.string.chat_send),
        modifier = Modifier.size(20.dp),
      )
    }
  }
}

/** Active model name with a dropdown of every downloaded text model; haptic tick on a change. */
@Composable
internal fun ModelSelector(
  models: List<TextModelOption>,
  activeId: String?,
  enabled: Boolean,
  onSelect: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  var expanded by remember { mutableStateOf(false) }
  val haptic = LocalHapticFeedback.current
  val activeName = models.firstOrNull { it.id == activeId }?.name.orEmpty()
  val description = stringResource(R.string.chat_model_selector, activeName)
  Box(modifier = modifier) {
    Row(
      modifier =
        Modifier.clickable(enabled = enabled) { expanded = true }
          .semantics { contentDescription = description }
          .testTag(TAG_MODEL_SELECTOR)
          .padding(vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
      Text(activeName, style = xelaSubheadline)
      Icon(
        painter = painterResource(R.drawable.ic_chevron_down),
        contentDescription = null,
        modifier = Modifier.size(16.dp),
      )
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
      models.forEach { model ->
        DropdownMenuItem(
          text = { Text(model.name) },
          onClick = {
            expanded = false
            if (model.id != activeId) {
              haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelect(model.id)
            }
          },
          modifier = Modifier.testTag(TAG_MODEL_OPTION),
          trailingIcon = {
            if (model.id == activeId) Icon(Icons.Rounded.Check, contentDescription = null)
          },
        )
      }
    }
  }
}

@Composable
internal fun EmptyState(onDownload: () -> Unit, modifier: Modifier = Modifier) {
  Surface(modifier = modifier.fillMaxWidth().testTag(TAG_EMPTY_STATE), shape = CardShape) {
    Column(
      modifier = Modifier.padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(stringResource(R.string.chat_empty_title), style = MaterialTheme.typography.bodyLarge)
      XelaButton(
        text = stringResource(R.string.chat_empty_action),
        onClick = onDownload,
        background = MaterialTheme.colorScheme.primary,
        foregroundColor = MaterialTheme.colorScheme.onPrimary,
      )
    }
  }
}

/** Welcome card with one example prompt per capability; tapping one fills the composer. */
@Composable
internal fun Welcome(onExample: (String) -> Unit, modifier: Modifier = Modifier) {
  val examples =
    listOf(
      stringResource(R.string.chat_example_balance),
      stringResource(R.string.chat_example_send),
      stringResource(R.string.chat_example_request),
    )
  Surface(modifier = modifier.fillMaxWidth().testTag(TAG_WELCOME), shape = CardShape) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
      Text(stringResource(R.string.chat_welcome_title), style = MaterialTheme.typography.bodyLarge)
      examples.forEach { example ->
        SuggestionChip(
          onClick = { onExample(example) },
          label = { Text(example) },
          modifier = Modifier.testTag(TAG_EXAMPLE),
        )
      }
    }
  }
}

@Preview(name = "Chat components", widthDp = 390)
@Composable
private fun ChatComponentsPreview() {
  ScottieTheme {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
      ModelSelector(
        models = listOf(TextModelOption("a", "Gemma 4 E2B"), TextModelOption("b", "Qwen")),
        activeId = "a",
        enabled = true,
        onSelect = {},
      )
      UserBubble("Send $50 to Alice")
      ReplyCard { ThinkingDots() }
      ReplyCard(Modifier.widthIn(max = 340.dp)) { RevealText("I can help with that.", 1) }
      Welcome(onExample = {})
      EmptyState(onDownload = {})
      Composer(value = "", enabled = false, onValueChange = {}, onSend = {})
      Composer(value = "Hello", enabled = true, onValueChange = {}, onSend = {})
    }
  }
}
