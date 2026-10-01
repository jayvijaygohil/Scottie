package com.jayvijay.scottie.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.presentation.ui.ScottieTheme
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSmallBody
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSubheadline

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScottieToolbar(
  title: String,
  backLabel: String,
  onBack: () -> Unit,
  modifier: Modifier = Modifier,
  subtitle: String? = null,
  /** Optional search input shown below the title, e.g. [ScottieSearchField]. */
  search: (@Composable () -> Unit)? = null,
) {
  Column(modifier = modifier) {
    TopAppBar(
      title = {
        Text(
          text = title,
          modifier = Modifier.semantics { heading() },
          style = xelaSubheadline,
        )
      },
      navigationIcon = {
        IconButton(
          onClick = onBack,
          modifier = Modifier.size(48.dp),
          colors =
            IconButtonDefaults.iconButtonColors(
              containerColor = Color.Transparent,
              contentColor = MaterialTheme.colorScheme.onBackground,
              disabledContainerColor = Color.Transparent,
            ),
          shape = MaterialTheme.shapes.small,
        ) {
          Icon(
            painter = painterResource(R.drawable.ic_arrow_left),
            contentDescription = backLabel,
            modifier = Modifier.size(20.dp),
          )
        }
      },
      colors =
        TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.background,
          titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
    )

    if (!subtitle.isNullOrBlank()) {
      Text(
        text = subtitle,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
        style = xelaSmallBody,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }

    if (search != null) {
      Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)) { search() }
    }
  }
}

@Preview(name = "Normal Toolbar")
@Composable
private fun ScottieToolbarPreview() {
  ScottieTheme {
    ScottieToolbar(
      title = "Download Modals",
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
      title = "Download Modals",
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
      title = "Download Models",
      backLabel = "Back",
      onBack = {},
      search = {
        ScottieSearchField(
          value = "",
          onValueChange = {},
          placeholder = "Search",
          clearLabel = "Clear",
        )
      },
    )
  }
}
