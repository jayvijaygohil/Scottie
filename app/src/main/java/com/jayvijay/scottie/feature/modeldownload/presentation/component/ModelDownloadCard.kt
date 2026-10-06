package com.jayvijay.scottie.feature.modeldownload.presentation.component

import android.content.res.Configuration
import android.text.format.Formatter
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.xelauikit.XelaBadge
import com.jayvijay.scottie.core.ui.xelauikit.XelaButton
import com.jayvijay.scottie.core.ui.xelauikit.models.button.XelaButtonState
import com.jayvijay.scottie.core.ui.xelauikit.models.button.XelaButtonType
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadPhase
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus

/**
 * Renders a model's download status without owning the download. [onDownload] also resumes and
 * retries. [canStart] is false for unsupported models and while another model downloads; Delete
 * stays available either way.
 */
@Composable
fun ModelDownloadUiItem(
  name: String,
  description: String?,
  supported: Boolean,
  downloadBytes: Long?,
  status: ModelDownloadStatus,
  canStart: Boolean,
  onDownload: () -> Unit,
  onPause: () -> Unit,
  onDelete: () -> Unit,
  modifier: Modifier = Modifier,
  /** Shown for downloaded text models; null hides the button. */
  onUse: (() -> Unit)? = null,
) {
  val downloadLabel = stringResource(R.string.model_download_download)
  val density = LocalDensity.current
  val textMeasurer = rememberTextMeasurer()
  val downloadTextLayout =
    remember(downloadLabel, density) {
      textMeasurer.measure(text = downloadLabel, style = xelaButtonMedium)
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
        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.Top,
        ) {
          Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            lineHeight = 24.sp,
            modifier = Modifier.weight(1f),
          )
          SupportBadge(supported)
        }
        if (description != null) {
          Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
          )
        }
      }

      Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
          text = statusText(status, downloadBytes),
          style = MaterialTheme.typography.bodyMedium,
          lineHeight = 16.sp,
          color =
            if (status is ModelDownloadStatus.Failed) {
              MaterialTheme.colorScheme.error
            } else {
              MaterialTheme.colorScheme.onSurfaceVariant
            },
        )
        if (status is ModelDownloadStatus.Downloading) {
          ModelDownloadProgress(fraction = status.progress.fraction)
        }
      }

      FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        val buttonModifier = Modifier.defaultMinSize(minWidth = buttonWidth)
        val start: @Composable (Int) -> Unit = { label ->
          ModelDownloadButton(
            text = stringResource(label),
            onClick = onDownload,
            filled = true,
            enabled = canStart,
            modifier = buttonModifier,
          )
        }
        when (status) {
          ModelDownloadStatus.Available -> start(R.string.model_download_download)
          is ModelDownloadStatus.Paused -> start(R.string.model_download_resume)
          is ModelDownloadStatus.Failed -> start(R.string.model_download_retry)
          is ModelDownloadStatus.Downloading ->
            ModelDownloadButton(
              text = stringResource(R.string.model_download_pause),
              onClick = onPause,
              modifier = buttonModifier,
            )
          ModelDownloadStatus.Downloaded -> {
            if (onUse != null) {
              ModelDownloadButton(
                text = stringResource(R.string.assistant_use_model),
                onClick = onUse,
                filled = true,
                modifier = buttonModifier,
              )
            }
            ModelDownloadButton(
              text = stringResource(R.string.model_download_delete),
              onClick = onDelete,
              modifier = buttonModifier,
            )
          }
        }
      }
    }
  }
}

@Composable
private fun SupportBadge(supported: Boolean) {
  XelaBadge(
    text =
      stringResource(
        if (supported) R.string.model_support_supported else R.string.model_support_unsupported
      ),
    backgroundColor =
      if (supported) MaterialTheme.colorScheme.primaryContainer
      else MaterialTheme.colorScheme.errorContainer,
    textColor =
      if (supported) MaterialTheme.colorScheme.onPrimaryContainer
      else MaterialTheme.colorScheme.onErrorContainer,
  )
}

@Composable
private fun statusText(status: ModelDownloadStatus, downloadBytes: Long?): String {
  val context = LocalContext.current
  fun size(bytes: Long) = Formatter.formatShortFileSize(context, bytes)
  return when (status) {
    ModelDownloadStatus.Available ->
      downloadBytes?.let { stringResource(R.string.model_download_status_available, size(it)) }
        ?: stringResource(R.string.model_download_status_size_unknown)
    is ModelDownloadStatus.Downloading -> downloadingText(status.progress, ::size)
    is ModelDownloadStatus.Paused ->
      stringResource(R.string.model_download_status_paused, size(status.bytesKept))
    is ModelDownloadStatus.Failed -> {
      val reason = stringResource(status.reason.label())
      if (status.bytesKept > 0) {
        stringResource(R.string.model_download_status_failed, reason, size(status.bytesKept))
      } else {
        reason
      }
    }
    ModelDownloadStatus.Downloaded ->
      if (downloadBytes != null) {
        stringResource(R.string.model_download_status_downloaded_size, size(downloadBytes))
      } else {
        stringResource(R.string.model_download_status_downloaded)
      }
  }
}

@Composable
private fun downloadingText(progress: DownloadProgress, size: (Long) -> String): String {
  val fraction = progress.fraction
  return when {
    progress.phase == DownloadPhase.VERIFYING ->
      stringResource(R.string.model_download_status_checking)
    progress.phase == DownloadPhase.EXTRACTING ->
      stringResource(R.string.model_download_status_unpacking)
    fraction != null && progress.bytesTotal > 0 ->
      stringResource(
        R.string.model_download_status_downloading,
        (fraction * PERCENT).toInt(),
        size(progress.bytesDone),
        size(progress.bytesTotal),
      )
    else ->
      stringResource(R.string.model_download_status_downloading_bytes, size(progress.bytesDone))
  }
}

private fun DownloadFailure.label(): Int =
  when (this) {
    DownloadFailure.NETWORK -> R.string.model_download_failure_network
    DownloadFailure.STORAGE -> R.string.model_download_failure_storage
    DownloadFailure.CORRUPTED -> R.string.model_download_failure_corrupted
    DownloadFailure.BACKGROUND_REFUSED -> R.string.model_download_failure_background_refused
    DownloadFailure.UNKNOWN -> R.string.model_download_failure_unknown
  }

private const val PERCENT = 100

@Composable
private fun ModelDownloadProgress(fraction: Float?) {
  val animatedProgress by
    animateFloatAsState(
      targetValue = fraction ?: 0f,
      animationSpec = MotionScheme.expressive().fastEffectsSpec(),
      label = "Model download progress",
    )
  val modifier = Modifier.fillMaxWidth().height(4.dp)

  if (fraction == null) {
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
  enabled: Boolean = true,
) {
  XelaButton(
    text = text,
    onClick = onClick,
    state = if (enabled) XelaButtonState.DEFAULT else XelaButtonState.DISABLED,
    type = if (filled) XelaButtonType.PRIMARY else XelaButtonType.SECONDARY,
    background = if (filled) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.surface,
    foregroundColor =
      if (filled) MaterialTheme.colorScheme.onError else MaterialTheme.colorScheme.error,
    defaultBorderColor = MaterialTheme.colorScheme.outlineVariant,
    modifier = modifier,
  )
}

private const val PREVIEW_TOTAL = 1_000_000_000L
private const val PREVIEW_HALF = 500_000_000L

@Preview(name = "States", widthDp = 358, heightDp = 1400)
@Preview(
  name = "States dark",
  widthDp = 358,
  heightDp = 1400,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(name = "States large text", widthDp = 320, heightDp = 2400, fontScale = 2f)
@Composable
private fun PreviewModelDownloadUiItemStates() {
  val states =
    listOf(
      ModelDownloadStatus.Available to true,
      ModelDownloadStatus.Available to false,
      ModelDownloadStatus.Downloaded to false,
      ModelDownloadStatus.Downloading(
        DownloadProgress(PREVIEW_HALF, PREVIEW_TOTAL, fraction = 0.5f)
      ) to false,
      ModelDownloadStatus.Downloading(
        DownloadProgress(PREVIEW_TOTAL, PREVIEW_TOTAL, fraction = 1f, DownloadPhase.EXTRACTING)
      ) to false,
      ModelDownloadStatus.Paused(bytesKept = PREVIEW_HALF) to true,
      ModelDownloadStatus.Failed(DownloadFailure.NETWORK, bytesKept = PREVIEW_HALF) to true,
      ModelDownloadStatus.Downloaded to true,
    )
  ScottieTheme {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      states.forEachIndexed { index, (status, canStart) ->
        ModelDownloadUiItem(
          name = "Qwen3.5 2B",
          description =
            "Alibaba general-purpose chat model; strong quality for its size."
              .takeIf {
                index != 1
              },
          // The third row is downloaded on a device that cannot run it.
          supported = index != 2,
          downloadBytes = PREVIEW_TOTAL,
          status = status,
          canStart = canStart,
          onDownload = {},
          onPause = {},
          onDelete = {},
        )
      }
    }
  }
}
