package com.jayvijay.scottie.core.ui.components

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme

private const val CHEVRON_EXPANDED_DEGREES = 180f

/**
 * Header row of a collapsible section styled with Stitch card tokens and count badge.
 */
@Composable
fun ScottieAccordionHeader(
  title: String,
  countLabel: String,
  expanded: Boolean,
  onToggle: () -> Unit,
  modifier: Modifier = Modifier,
  level: Int = 0,
) {
  val state =
    stringResource(if (expanded) R.string.section_expanded else R.string.section_collapsed)
  val rotation by
    animateFloatAsState(
      targetValue = if (expanded) CHEVRON_EXPANDED_DEGREES else 0f,
      animationSpec = MotionScheme.expressive().fastSpatialSpec(),
      label = "Accordion chevron",
    )
  val topLevel = level == 0

  Surface(
    modifier = modifier.fillMaxWidth().padding(start = (level * 12).dp),
    shape = MaterialTheme.shapes.large,
    color = ScottieTheme.colors.surfaceCard,
    border =
      BorderStroke(
        width = 1.dp,
        color =
          if (expanded) MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)
          else ScottieTheme.colors.borderSubtle,
      ),
  ) {
    Row(
      modifier =
        Modifier.fillMaxWidth()
          .heightIn(min = 56.dp)
          .clickable(role = Role.Button, onClick = onToggle)
          .semantics(mergeDescendants = true) {
            heading()
            stateDescription = state
          }
          .padding(horizontal = 16.dp, vertical = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(2.dp),
      ) {
        Text(
          text = title,
          style =
            if (topLevel) MaterialTheme.typography.titleLarge
            else MaterialTheme.typography.titleMedium,
          color = ScottieTheme.colors.textPrimary,
        )
        Text(
          text = countLabel,
          style = MaterialTheme.typography.labelSmall,
          color =
            if (expanded) MaterialTheme.colorScheme.primary
            else ScottieTheme.colors.textSecondary,
        )
      }
      Surface(
        shape = MaterialTheme.shapes.small,
        color =
          if (expanded) ScottieTheme.colors.scotiaRedSubtle
          else ScottieTheme.colors.surfaceCanvas,
        modifier = Modifier.size(32.dp),
      ) {
        Box(contentAlignment = Alignment.Center) {
          Icon(
            painter = painterResource(R.drawable.ic_chevron_down),
            contentDescription = null,
            modifier = Modifier.size(if (topLevel) 18.dp else 16.dp).rotate(rotation),
            tint =
              if (expanded) MaterialTheme.colorScheme.primary
              else ScottieTheme.colors.textSecondary,
          )
        }
      }
    }
  }
}

@Preview(name = "Accordion headers")
@Preview(name = "Accordion headers dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScottieAccordionHeaderPreview() {
  ScottieTheme {
    Column(
      modifier = Modifier.padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      ScottieAccordionHeader(
        title = "Text",
        countLabel = "42 models",
        expanded = true,
        onToggle = {},
      )
      ScottieAccordionHeader(
        title = "Speech",
        countLabel = "1 model",
        expanded = false,
        onToggle = {},
        level = 1,
      )
    }
  }
}
