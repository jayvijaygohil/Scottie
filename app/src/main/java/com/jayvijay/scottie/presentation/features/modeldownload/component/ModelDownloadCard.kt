package com.jayvijay.scottie.presentation.features.modeldownload.component

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.presentation.ui.ScottieTheme
import com.jayvijay.scottie.presentation.ui.xelauikit.XelaButton
import com.jayvijay.scottie.presentation.ui.xelauikit.models.button.XelaButtonType
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium

enum class ModelDownloadItemState {
  DOWNLOADING,
  PAUSED,
  DOWNLOADED,
  AVAILABLE,
}

/** Localized action labels, supplied by the screen alongside its formatted status text. */
data class ModelDownloadItemLabels(
  val download: String,
  val pause: String,
  val delete: String,
  val resume: String,
)

/**
 * Renders a download snapshot without owning the download operation.
 *
 * [statusText] includes the formatted size and, while downloading, percentage and byte counts.
 * [progress] is a fraction in 0..1; null means the total size is not yet known. Callbacks report
 * intent; the caller owns confirmation, failures, and subsequent state changes.
 */
@Composable
fun ModelDownloadUiItem(
  name: String,
  description: String,
  state: ModelDownloadItemState,
  statusText: String,
  labels: ModelDownloadItemLabels,
  onDownload: () -> Unit,
  onPause: () -> Unit,
  onDelete: () -> Unit,
  onResume: () -> Unit,
  modifier: Modifier = Modifier,
  progress: Float? = null,
) {
  require(progress == null || progress in 0f..1f) { "Progress must be null or in 0..1" }

  val density = LocalDensity.current
  val textMeasurer = rememberTextMeasurer()
  val downloadTextLayout =
    remember(labels.download, density) {
      textMeasurer.measure(
        text = labels.download,
        style = xelaButtonMedium,
      )
    }
  val buttonWidth = with(density) { downloadTextLayout.size.width.toDp() } + 32.dp

  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    color = MaterialTheme.colorScheme.surface,
  ) {
    Column(
      modifier =
        Modifier.animateContentSize(MotionScheme.expressive().fastSpatialSpec()).padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
          text = name,
          style = MaterialTheme.typography.titleMedium,
          lineHeight = 24.sp,
        )

        Text(
          text = description,
          style = MaterialTheme.typography.bodyMedium,
          lineHeight = 16.sp,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }

      Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
          text = statusText,
          style = MaterialTheme.typography.bodyMedium,
          lineHeight = 16.sp,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        if (state == ModelDownloadItemState.DOWNLOADING || state == ModelDownloadItemState.PAUSED) {
          ModelDownloadProgress(progress = progress)
        }
      }

      FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        val buttonModifier = Modifier.defaultMinSize(minWidth = buttonWidth)
        when (state) {
          ModelDownloadItemState.AVAILABLE ->
            ModelDownloadButton(
              text = labels.download,
              onClick = onDownload,
              filled = true,
              modifier = buttonModifier,
            )

          ModelDownloadItemState.DOWNLOADING -> {
            ModelDownloadButton(
              text = labels.pause,
              onClick = onPause,
              modifier = buttonModifier,
            )
            ModelDownloadButton(
              text = labels.delete,
              onClick = onDelete,
              modifier = buttonModifier,
            )
          }

          ModelDownloadItemState.PAUSED -> {
            ModelDownloadButton(
              text = labels.resume,
              onClick = onResume,
              filled = true,
              modifier = buttonModifier,
            )
            ModelDownloadButton(
              text = labels.delete,
              onClick = onDelete,
              modifier = buttonModifier,
            )
          }

          ModelDownloadItemState.DOWNLOADED ->
            ModelDownloadButton(
              text = labels.delete,
              onClick = onDelete,
              modifier = buttonModifier,
            )
        }
      }
    }
  }
}

@Composable
private fun ModelDownloadProgress(progress: Float?) {
  val animatedProgress by
    animateFloatAsState(
      targetValue = progress ?: 0f,
      animationSpec = MotionScheme.expressive().fastEffectsSpec(),
      label = "Model download progress",
    )

  val modifier = Modifier.fillMaxWidth().height(4.dp)

  if (progress == null) {
    LinearProgressIndicator(
      modifier = modifier,
      color = MaterialTheme.colorScheme.error,
      trackColor = MaterialTheme.colorScheme.outlineVariant,
    )
  } else {
    LinearProgressIndicator(
      progress = { animatedProgress },
      modifier = modifier,
      color = MaterialTheme.colorScheme.error,
      trackColor = MaterialTheme.colorScheme.outlineVariant,
      gapSize = 0.dp,
      drawStopIndicator = {},
    )
  }
}

@Composable
private fun ModelDownloadButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  filled: Boolean = false,
) {
  XelaButton(
    text = text,
    onClick = onClick,
    type = if (filled) XelaButtonType.PRIMARY else XelaButtonType.SECONDARY,
    background = if (filled) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.surface,
    foregroundColor =
      if (filled) MaterialTheme.colorScheme.onError else MaterialTheme.colorScheme.error,
    defaultBorderColor = MaterialTheme.colorScheme.outlineVariant,
    modifier = modifier,
  )
}

@Preview(name = "Available", widthDp = 358)
@Preview(name = "Available dark", widthDp = 358, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewAvailableModelDownloadUiItem() {
  ScottieTheme {
    ModelDownloadUiItem(
      name = "Llama 3.2 · 1B",
      description = "Lightweight help with ideas and conversation.",
      state = ModelDownloadItemState.AVAILABLE,
      statusText = "0.9 GB download",
      labels = PreviewLabels,
      onDownload = {},
      onPause = {},
      onDelete = {},
      onResume = {},
    )
  }
}

@Preview(name = "Downloading", widthDp = 358)
@Preview(name = "Downloading dark", widthDp = 358, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Downloading large text", widthDp = 320, fontScale = 2f)
@Composable
private fun PreviewDownloadingModelDownloadUiItem() {
  ScottieTheme {
    ModelDownloadUiItem(
      name = "Qwen 2.5 · 1.5B",
      description = "Everyday writing, answers, and summaries.",
      state = ModelDownloadItemState.DOWNLOADING,
      statusText = "Downloading · 50% · 0.5 / 1.0 GB",
      progress = 0.5f,
      labels = PreviewLabels,
      onDownload = {},
      onPause = {},
      onDelete = {},
      onResume = {},
    )
  }
}

@Preview(name = "Downloaded", widthDp = 358)
@Preview(name = "Downloaded dark", widthDp = 358, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Downloaded large text", widthDp = 320, fontScale = 2f)
@Composable
private fun PreviewDownloadedModelDownloadUiItem() {
  ScottieTheme {
    ModelDownloadUiItem(
      name = "Gemma 3 · 1B",
      description = "A compact model for quick, simple tasks.",
      state = ModelDownloadItemState.DOWNLOADED,
      statusText = "Downloaded · 0.8 GB",
      labels = PreviewLabels,
      onDownload = {},
      onPause = {},
      onDelete = {},
      onResume = {},
    )
  }
}

private val PreviewLabels =
  ModelDownloadItemLabels(
    download = "Download",
    pause = "Pause",
    delete = "Delete",
    resume = "Resume",
  )
