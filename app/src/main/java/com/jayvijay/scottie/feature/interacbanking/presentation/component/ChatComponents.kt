package com.jayvijay.scottie.feature.interacbanking.presentation.component

import android.content.res.Configuration
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Memory
import androidx.compose.material.icons.rounded.RequestQuote
import androidx.compose.material.icons.rounded.SwapHoriz
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieButton
import kotlinx.coroutines.delay

const val TAG_USER_BUBBLE = "assistant_user_bubble"
const val TAG_REPLY = "assistant_reply"
const val TAG_COMPOSER = "assistant_composer"
const val TAG_THINKING = "chat_thinking"
const val TAG_SEND = "chat_send"
const val TAG_EMPTY_STATE = "chat_empty_state"
const val TAG_WELCOME = "chat_welcome"
const val TAG_EXAMPLE = "chat_example"

private const val REVEAL_WORD_MS = 30L
private const val DOT_COUNT = 3
private const val DOT_PERIOD_MS = 600
private const val DOT_STAGGER_MS = 150
private const val DOT_MIN_ALPHA = 0.3f
private val CardShape =
  RoundedCornerShape(topStart = 6.dp, topEnd = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp)
private val WelcomeCardShape = RoundedCornerShape(20.dp)
private val BubbleShape =
  RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomEnd = 6.dp, bottomStart = 20.dp)
private val ComposerShape = RoundedCornerShape(18.dp)
private val SendButtonShape = RoundedCornerShape(14.dp)

/** Model-side card: Stitch elevated surface card with subtle 1dp border. */
@Composable
internal fun ReplyCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
  val colors = ScottieTheme.colors
  Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
    Surface(
      modifier = modifier.testTag(TAG_REPLY),
      shape = CardShape,
      color = colors.surfaceCard,
      border = BorderStroke(1.dp, colors.borderSubtle),
      shadowElevation = 1.dp,
    ) {
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
      color = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
      shadowElevation = 1.dp,
    ) {
      Text(
        text = text,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        style = MaterialTheme.typography.bodyLarge,
      )
    }
  }
}

@Composable
internal fun ThinkingDots(modifier: Modifier = Modifier) {
  val description = stringResource(R.string.chat_thinking)
  val transition = rememberInfiniteTransition(label = "thinking")
  Row(
    modifier =
      modifier
        .padding(horizontal = 4.dp, vertical = 2.dp)
        .semantics { contentDescription = description }
        .testTag(TAG_THINKING),
    horizontalArrangement = Arrangement.spacedBy(6.dp),
    verticalAlignment = Alignment.CenterVertically,
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
          Modifier.size(7.dp)
            .alpha(alpha)
            .background(MaterialTheme.colorScheme.primary, CircleShape)
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
  Text(
    text = text.take(shown),
    modifier = modifier,
    style = MaterialTheme.typography.bodyLarge,
    color = ScottieTheme.colors.textPrimary,
  )
}

@Composable
internal fun Composer(
  value: String,
  enabled: Boolean,
  onValueChange: (String) -> Unit,
  onSend: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val colors = ScottieTheme.colors
  val textStyle = MaterialTheme.typography.bodyLarge.copy(color = colors.textPrimary)
  Row(
    modifier = modifier.fillMaxWidth().testTag(TAG_COMPOSER),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.Bottom,
  ) {
    Surface(
      modifier = Modifier.weight(1f).border(1.dp, colors.borderSubtle, ComposerShape),
      shape = ComposerShape,
      color = colors.surfaceCard,
      shadowElevation = 2.dp,
    ) {
      BasicTextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = 4,
        textStyle = textStyle,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        decorationBox = { field ->
          Box(
            modifier = Modifier.heightIn(min = 46.dp).padding(horizontal = 16.dp, vertical = 12.dp),
            contentAlignment = Alignment.CenterStart,
          ) {
            if (value.isEmpty()) {
              Text(
                text = stringResource(R.string.assistant_composer_hint),
                style = textStyle,
                color = colors.textTertiary,
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
      modifier = Modifier.size(46.dp).testTag(TAG_SEND),
      shape = SendButtonShape,
      colors =
        IconButtonDefaults.filledIconButtonColors(
          containerColor = MaterialTheme.colorScheme.primary,
          contentColor = MaterialTheme.colorScheme.onPrimary,
          disabledContainerColor = colors.surfaceCard,
          disabledContentColor = colors.textTertiary,
        ),
    ) {
      Icon(
        Icons.AutoMirrored.Rounded.Send,
        contentDescription = stringResource(R.string.chat_send),
        modifier = Modifier.size(20.dp),
      )
    }
  }
}

@Composable
internal fun EmptyState(onDownload: () -> Unit, modifier: Modifier = Modifier) {
  val colors = ScottieTheme.colors
  Surface(
    modifier = modifier.fillMaxWidth().testTag(TAG_EMPTY_STATE),
    shape = WelcomeCardShape,
    color = colors.surfaceCard,
    border = BorderStroke(1.dp, colors.borderSubtle),
  ) {
    Column(
      modifier = Modifier.padding(24.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Surface(
        modifier = Modifier.size(48.dp),
        shape = RoundedCornerShape(14.dp),
        color = colors.scotiaRedSubtle,
      ) {
        Box(contentAlignment = Alignment.Center) {
          Icon(
            imageVector = Icons.Rounded.Memory,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp),
          )
        }
      }
      Text(
        text = stringResource(R.string.chat_empty_title),
        style = MaterialTheme.typography.bodyLarge,
        color = colors.textPrimary,
        textAlign = TextAlign.Center,
      )
      ScottieButton(
        text = stringResource(R.string.chat_empty_action),
        onClick = onDownload,
      )
    }
  }
}

/** Welcome card with one example prompt per capability; tapping one fills the composer. */
@Composable
internal fun Welcome(onExample: (String) -> Unit, modifier: Modifier = Modifier) {
  val colors = ScottieTheme.colors
  val balancePrompt = stringResource(R.string.chat_example_balance)
  val sendPrompt = stringResource(R.string.chat_example_send)
  val requestPrompt = stringResource(R.string.chat_example_request)
  val examples =
    listOf(
      balancePrompt to Icons.Rounded.AccountBalanceWallet,
      sendPrompt to Icons.Rounded.SwapHoriz,
      requestPrompt to Icons.Rounded.RequestQuote,
    )

  Column(
    modifier = modifier.fillMaxWidth().testTag(TAG_WELCOME),
    verticalArrangement = Arrangement.spacedBy(14.dp),
  ) {
    Surface(
      modifier = Modifier.fillMaxWidth(),
      shape = WelcomeCardShape,
      color = colors.surfaceCard,
      border = BorderStroke(1.dp, colors.borderSubtle),
    ) {
      Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top,
      ) {
        Surface(
          modifier = Modifier.size(36.dp),
          shape = RoundedCornerShape(12.dp),
          color = colors.scotiaRedDeep,
        ) {
          Box(contentAlignment = Alignment.Center) {
            Icon(
              imageVector = Icons.Rounded.AutoAwesome,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.onPrimary,
              modifier = Modifier.size(18.dp),
            )
          }
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary,
          )
          Text(
            text = stringResource(R.string.chat_welcome_title),
            style = MaterialTheme.typography.bodyLarge,
            color = colors.textPrimary,
          )
        }
      }
    }

    FlowRow(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      examples.forEach { (example, icon) ->
        SuggestionChip(
          onClick = { onExample(example) },
          label = {
            Text(
              text = example,
              style = MaterialTheme.typography.labelLarge,
            )
          },
          icon = {
            Icon(
              imageVector = icon,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(16.dp),
            )
          },
          shape = RoundedCornerShape(999.dp),
          colors =
            SuggestionChipDefaults.suggestionChipColors(
              containerColor = colors.surfaceCard,
              labelColor = colors.textPrimary,
            ),
          border = BorderStroke(1.dp, colors.borderSubtle),
          modifier = Modifier.testTag(TAG_EXAMPLE),
        )
      }
    }
  }
}

@Preview(name = "Chat components", widthDp = 390)
@Preview(name = "Chat components dark", widthDp = 390, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ChatComponentsPreview() {
  ScottieTheme {
    Column(
      modifier = Modifier.background(ScottieTheme.colors.surfaceCanvas).padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
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
