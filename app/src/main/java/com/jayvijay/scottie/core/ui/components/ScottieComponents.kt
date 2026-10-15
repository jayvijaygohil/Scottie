package com.jayvijay.scottie.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.ScottieTheme

enum class ScottieBadgeTone {
  Brand,
  Success,
  Warning,
  Error,
  Neutral,
}

@Composable
fun ScottieBadgeTone.colors(): Pair<Color, Color> {
  val extended = ScottieTheme.colors
  val scheme = MaterialTheme.colorScheme
  return when (this) {
    ScottieBadgeTone.Brand -> extended.scotiaRedSubtle to extended.scotiaRedDeep
    ScottieBadgeTone.Success -> extended.statusSuccessSubtle to extended.statusSuccess
    ScottieBadgeTone.Warning -> extended.interacGoldSubtle to scheme.onPrimaryFixed
    ScottieBadgeTone.Error -> scheme.errorContainer to scheme.onErrorContainer
    ScottieBadgeTone.Neutral -> scheme.surfaceContainerHigh to extended.textSecondary
  }
}

/** Pill/tag badge styled according to the Stitch Autonomous Banking Experience specification. */
@Composable
fun ScottieBadge(
  text: String,
  modifier: Modifier = Modifier,
  tone: ScottieBadgeTone = ScottieBadgeTone.Brand,
  leadingDot: Boolean = false,
  shape: Shape = CircleShape,
) {
  val (containerColor, contentColor) = tone.colors()
  ScottieBadge(
    text = text,
    containerColor = containerColor,
    contentColor = contentColor,
    modifier = modifier,
    leadingDot = leadingDot,
    shape = shape,
  )
}

@Composable
fun ScottieBadge(
  text: String,
  containerColor: Color,
  contentColor: Color,
  modifier: Modifier = Modifier,
  leadingDot: Boolean = false,
  shape: Shape = CircleShape,
) {
  Surface(
    modifier = modifier,
    shape = shape,
    color = containerColor,
    contentColor = contentColor,
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
      if (leadingDot) {
        Box(modifier = Modifier.size(6.dp).background(contentColor, CircleShape))
      }
      Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = contentColor,
      )
    }
  }
}

enum class ScottieButtonStyle {
  Primary,
  Secondary,
  SubtleDestructive,
}

/**
 * Banking-grade Material 3 action button with 48.dp minimum touch target height and Stitch radii.
 */
@Composable
fun ScottieButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  style: ScottieButtonStyle = ScottieButtonStyle.Primary,
  leadingIcon: ImageVector? = null,
) {
  val shape = MaterialTheme.shapes.medium
  val minSizeModifier = modifier.defaultMinSize(minHeight = 44.dp)
  val contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)

  when (style) {
    ScottieButtonStyle.Primary -> {
      Button(
        onClick = onClick,
        enabled = enabled,
        modifier = minSizeModifier,
        shape = shape,
        contentPadding = contentPadding,
        colors =
          ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            disabledContentColor = ScottieTheme.colors.textTertiary,
          ),
      ) {
        ButtonContent(text = text, leadingIcon = leadingIcon)
      }
    }
    ScottieButtonStyle.Secondary -> {
      OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = minSizeModifier,
        shape = shape,
        contentPadding = contentPadding,
        border = BorderStroke(1.dp, ScottieTheme.colors.borderSubtle),
        colors =
          ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = ScottieTheme.colors.textPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            disabledContentColor = ScottieTheme.colors.textTertiary,
          ),
      ) {
        ButtonContent(text = text, leadingIcon = leadingIcon)
      }
    }
    ScottieButtonStyle.SubtleDestructive -> {
      Button(
        onClick = onClick,
        enabled = enabled,
        modifier = minSizeModifier,
        shape = shape,
        contentPadding = contentPadding,
        colors =
          ButtonDefaults.buttonColors(
            containerColor = ScottieTheme.colors.scotiaRedSubtle,
            contentColor = ScottieTheme.colors.scotiaRedDeep,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            disabledContentColor = ScottieTheme.colors.textTertiary,
          ),
      ) {
        ButtonContent(text = text, leadingIcon = leadingIcon)
      }
    }
  }
}

@Composable
private fun ButtonContent(text: String, leadingIcon: ImageVector?) {
  if (leadingIcon != null) {
    Icon(
      imageVector = leadingIcon,
      contentDescription = null,
      modifier = Modifier.size(18.dp),
    )
    Spacer(modifier = Modifier.width(6.dp))
  }
  Text(
    text = text,
    style = MaterialTheme.typography.titleMedium,
  )
}

/** Structured inline banking alert banner for error, warning, or informational notices. */
@Composable
fun ScottieAlertBanner(
  title: String,
  message: String,
  modifier: Modifier = Modifier,
  isError: Boolean = false,
) {
  val containerColor =
    if (isError) {
      MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.55f)
    } else {
      ScottieTheme.colors.scotiaRedSubtle
    }
  val accentColor =
    if (isError) {
      MaterialTheme.colorScheme.error
    } else {
      MaterialTheme.colorScheme.primary
    }

  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = MaterialTheme.shapes.medium,
    color = containerColor,
    border = BorderStroke(1.dp, accentColor.copy(alpha = 0.25f)),
  ) {
    Row(
      modifier = Modifier.padding(12.dp),
      horizontalArrangement = Arrangement.spacedBy(10.dp),
      verticalAlignment = Alignment.Top,
    ) {
      Icon(
        imageVector = if (isError) Icons.Rounded.ErrorOutline else Icons.Rounded.Info,
        contentDescription = null,
        tint = accentColor,
        modifier = Modifier.size(18.dp).padding(top = 2.dp),
      )
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(2.dp),
      ) {
        Text(
          text = title,
          style = MaterialTheme.typography.titleSmall,
          color = accentColor,
        )
        Text(
          text = message,
          style = MaterialTheme.typography.bodyMedium,
          color = ScottieTheme.colors.textPrimary,
        )
      }
    }
  }
}

/** Floating charcoal toast bar inspired by the Stitch Model Hub notification banner. */
@Composable
fun ScottieToast(
  message: String,
  actionLabel: String,
  onAction: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = MaterialTheme.shapes.large,
    color = ScottieTheme.colors.surfaceCharcoal,
    contentColor = MaterialTheme.colorScheme.onPrimary,
    shadowElevation = 6.dp,
  ) {
    Row(
      modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Icon(
        imageVector = Icons.Rounded.ErrorOutline,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.inversePrimary,
        modifier = Modifier.size(20.dp),
      )
      Text(
        text = message,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.weight(1f),
      )
      TextButton(onClick = onAction) {
        Text(
          text = actionLabel,
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.inversePrimary,
        )
      }
    }
  }
}

@Preview(name = "Scottie Components Light", widthDp = 390)
@Preview(
  name = "Scottie Components Dark",
  widthDp = 390,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ScottieComponentsPreview() {
  ScottieTheme {
    Surface(color = MaterialTheme.colorScheme.background) {
      Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
      ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          ScottieBadge("Autodeposit Verified", tone = ScottieBadgeTone.Success, leadingDot = true)
          ScottieBadge("Active in Chat", tone = ScottieBadgeTone.Brand)
          ScottieBadge("VIP CLIENT", tone = ScottieBadgeTone.Warning)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          ScottieButton(
            text = "Authorize & Send",
            onClick = {},
            leadingIcon = Icons.AutoMirrored.Rounded.Send,
            modifier = Modifier.weight(1f),
          )
          ScottieButton(
            text = "Cancel",
            onClick = {},
            style = ScottieButtonStyle.Secondary,
          )
        }
        ScottieButton(
          text = "Remove Configuration",
          onClick = {},
          style = ScottieButtonStyle.SubtleDestructive,
          leadingIcon = Icons.Rounded.CheckCircle,
        )
        ScottieAlertBanner(
          title = "Couldn't complete that",
          message = "Insufficient balance in Everyday Chequing.",
          isError = true,
        )
        ScottieToast(
          message = "Needs 2.6 GB of free storage; 1.4 GB is available.",
          actionLabel = "Dismiss",
          onAction = {},
        )
      }
    }
  }
}
