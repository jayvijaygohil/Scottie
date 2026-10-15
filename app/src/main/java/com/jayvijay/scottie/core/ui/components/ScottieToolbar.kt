package com.jayvijay.scottie.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SmartToy
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScottieToolbar(
  title: String,
  modifier: Modifier = Modifier,
  /** Back arrow description; the arrow is shown only when [onBack] is set. */
  backLabel: String? = null,
  onBack: (() -> Unit)? = null,
  subtitle: String? = null,
  /** Replaces the [title] text in the bar, e.g. a selector. */
  titleContent: (@Composable () -> Unit)? = null,
  actions: @Composable RowScope.() -> Unit = {},
  /** Optional search input shown below the title, e.g. [ScottieSearchField]. */
  search: (@Composable () -> Unit)? = null,
) {
  Column(
    modifier = modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background),
  ) {
    TopAppBar(
      title = {
        if (titleContent != null) {
          titleContent()
        } else {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
          ) {
            if (onBack == null) {
              Surface(
                shape = MaterialTheme.shapes.small,
                color = ScottieTheme.colors.scotiaRedDeep,
                modifier = Modifier.size(32.dp),
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = Icons.Rounded.SmartToy,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(18.dp),
                  )
                }
              }
            }
            Column {
              Text(
                text = title,
                modifier = Modifier.semantics { heading() },
                style = MaterialTheme.typography.headlineSmall,
                color = ScottieTheme.colors.textPrimary,
              )
              Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp),
              ) {
                Box(
                  modifier =
                    Modifier.size(6.dp).background(ScottieTheme.colors.statusSuccess, CircleShape),
                )
                Text(
                  text = "SANDBOX READY",
                  style = MaterialTheme.typography.labelSmall,
                  color = ScottieTheme.colors.statusSuccess,
                )
              }
            }
          }
        }
      },
      navigationIcon = {
        if (onBack != null) {
          IconButton(
            onClick = onBack,
            modifier = Modifier.padding(start = 4.dp).size(48.dp),
          ) {
            Surface(
              shape = MaterialTheme.shapes.medium,
              color = ScottieTheme.colors.surfaceCard,
              border = BorderStroke(1.dp, ScottieTheme.colors.borderSubtle),
              modifier = Modifier.size(36.dp),
            ) {
              Box(contentAlignment = Alignment.Center) {
                Icon(
                  painter = painterResource(R.drawable.ic_arrow_left),
                  contentDescription = backLabel,
                  modifier = Modifier.size(18.dp),
                  tint = ScottieTheme.colors.textPrimary,
                )
              }
            }
          }
        }
      },
      actions = actions,
      colors =
        TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.background,
          titleContentColor = ScottieTheme.colors.textPrimary,
          actionIconContentColor = ScottieTheme.colors.textPrimary,
        ),
    )

    if (!subtitle.isNullOrBlank()) {
      Text(
        text = subtitle,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
        style = MaterialTheme.typography.bodyMedium,
        color = ScottieTheme.colors.textSecondary,
      )
    }

    if (search != null) {
      Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)) { search() }
    }

    HorizontalDivider(
      thickness = 1.dp,
      color = ScottieTheme.colors.borderSubtle,
    )
  }
}

@Preview(name = "Normal Toolbar")
@Preview(name = "Normal Toolbar Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScottieToolbarPreview() {
  ScottieTheme {
    ScottieToolbar(
      title = "Settings & Models",
      backLabel = "Back",
      onBack = {},
    )
  }
}

@Preview(name = "Toolbar with Subtitle")
@Composable
private fun ScottieToolbarWithSubtitlePreview() {
  ScottieTheme {
    ScottieToolbar(
      title = "Download models",
      subtitle = "Download models to use in Scottie and run them on your device.",
      backLabel = "Back",
      onBack = {},
    )
  }
}

@Preview(name = "Toolbar with Search")
@Composable
private fun ScottieToolbarWithSearchPreview() {
  ScottieTheme {
    ScottieToolbar(
      title = "Download models",
      backLabel = "Back",
      onBack = {},
      search = {
        ScottieSearchField(
          value = "",
          onValueChange = {},
          placeholder = "Search models",
          clearLabel = "Clear",
        )
      },
    )
  }
}

@Preview(name = "Root toolbar with title slot and action")
@Composable
private fun ScottieToolbarRootPreview() {
  ScottieTheme {
    ScottieToolbar(
      title = "Chat",
      titleContent = {
        Text(
          text = "gemma-4-E2B-it",
          style = MaterialTheme.typography.titleLarge,
        )
      },
      actions = {
        IconButton(onClick = {}) { Icon(Icons.Rounded.Settings, contentDescription = "Settings") }
      },
    )
  }
}
