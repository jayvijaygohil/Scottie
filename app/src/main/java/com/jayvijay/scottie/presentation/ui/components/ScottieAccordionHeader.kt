package com.jayvijay.scottie.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
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
import com.jayvijay.scottie.presentation.ui.ScottieTheme

private const val CHEVRON_EXPANDED_DEGREES = 180f

/**
 * Header row of a collapsible section. Nest sections by passing a higher [level]; content is
 * rendered by the caller so long sections can stay lazy.
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

  Row(
    modifier =
      modifier
        .fillMaxWidth()
        .heightIn(min = 48.dp)
        .clickable(role = Role.Button, onClick = onToggle)
        .semantics(mergeDescendants = true) {
          heading()
          stateDescription = state
        }
        .padding(start = (level * 12).dp, top = 8.dp, bottom = 8.dp, end = 4.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = title,
        style =
          if (topLevel) MaterialTheme.typography.titleMedium
          else MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onBackground,
      )
      Text(
        text = countLabel,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
    Icon(
      painter = painterResource(R.drawable.ic_chevron_down),
      contentDescription = null,
      modifier = Modifier.size(if (topLevel) 20.dp else 16.dp).rotate(rotation),
      tint = MaterialTheme.colorScheme.onSurfaceVariant,
    )
  }
}

@Preview(name = "Accordion headers")
@Preview(name = "Accordion headers dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScottieAccordionHeaderPreview() {
  ScottieTheme {
    Column {
      ScottieAccordionHeader(
        title = "Text",
        countLabel = "42 models",
        expanded = true,
        onToggle = {},
      )
      ScottieAccordionHeader(
        title = "CPU Models",
        countLabel = "1 model",
        expanded = false,
        onToggle = {},
        level = 1,
      )
    }
  }
}
