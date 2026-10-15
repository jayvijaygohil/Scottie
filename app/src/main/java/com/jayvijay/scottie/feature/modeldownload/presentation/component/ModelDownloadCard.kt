package com.jayvijay.scottie.feature.modeldownload.presentation.component

import android.content.res.Configuration
import android.text.format.Formatter
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieCodeSmall
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieBadge
import com.jayvijay.scottie.core.ui.components.ScottieBadgeTone
import com.jayvijay.scottie.core.ui.components.ScottieButton
import com.jayvijay.scottie.core.ui.components.ScottieButtonStyle
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
  val colors = ScottieTheme.colors
  val downloadLabel = stringResource(R.string.model_download_download)
  val density = LocalDensity.current
  val textMeasurer = rememberTextMeasurer()
  val labelStyle = MaterialTheme.typography.labelLarge
  val downloadTextLayout =
    remember(downloadLabel, density, labelStyle) {
      textMeasurer.measure(text = downloadLabel, style = labelStyle)
    }
  val buttonWidth = with(density) { downloadTextLayout.size.width.toDp() } + 36.dp
  val isDownloading = status is ModelDownloadStatus.Downloading

  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    color = colors.surfaceCard,
    border =
      BorderStroke(
        width = 1.dp,
        color =
          if (isDownloading) {
            MaterialTheme.colorScheme.primary.copy(alpha = ACTIVE_BORDER_ALPHA)
          } else {
            colors.borderSubtle
          },
      ),
  ) {
    Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
      if (isDownloading) {
        Box(
          modifier =
            Modifier.width(3.dp).fillMaxHeight().background(MaterialTheme.colorScheme.primary)
        )
      }
      Column(
        modifier =
          Modifier.weight(1f)
            .animateContentSize(MotionScheme.expressive().fastSpatialSpec())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
      ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            Text(
              text = name,
              style = MaterialTheme.typography.titleMedium,
              color = colors.textPrimary,
              lineHeight = 22.sp,
              modifier = Modifier.weight(1f),
            )
            SupportBadge(supported = supported)
          }
          if (description != null) {
            Text(
              text = description,
              style = MaterialTheme.typography.bodyMedium,
              lineHeight = 18.sp,
              color = colors.textSecondary,
              maxLines = 2,
              overflow = TextOverflow.Ellipsis,
            )
          }
        }

        Surface(
          color = colors.surfaceCanvas,
          shape = RoundedCornerShape(10.dp),
          border = BorderStroke(1.dp, colors.borderSubtle),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
              StatusDot(status = status)
              Text(
                text = statusText(status, downloadBytes),
                style = ScottieCodeSmall.copy(fontWeight = FontWeight.Medium),
                color =
                  when (status) {
                    is ModelDownloadStatus.Failed -> MaterialTheme.colorScheme.error
                    is ModelDownloadStatus.Downloading -> MaterialTheme.colorScheme.primary
                    ModelDownloadStatus.Downloaded -> colors.statusSuccess
                    else -> colors.textSecondary
                  },
              )
            }
            if (status is ModelDownloadStatus.Downloading) {
              ModelDownloadProgress(fraction = status.progress.fraction)
            }
          }
        }

        FlowRow(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
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
                destructive = true,
                modifier = buttonModifier,
              )
            }
          }
        }
      }
    }
  }
}

@Composable
private fun StatusDot(status: ModelDownloadStatus) {
  val colors = ScottieTheme.colors
  val dotColor =
    when (status) {
      ModelDownloadStatus.Downloaded -> colors.statusSuccess
      is ModelDownloadStatus.Downloading -> MaterialTheme.colorScheme.primary
      is ModelDownloadStatus.Paused -> colors.interacGold
      is ModelDownloadStatus.Failed -> MaterialTheme.colorScheme.error
      ModelDownloadStatus.Available -> colors.textTertiary
    }
  Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(dotColor))
}

@Composable
private fun SupportBadge(supported: Boolean) {
  ScottieBadge(
    text =
      stringResource(
        if (supported) R.string.model_support_supported else R.string.model_support_unsupported
      ),
    tone = if (supported) ScottieBadgeTone.Success else ScottieBadgeTone.Error,
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
private const val ACTIVE_BORDER_ALPHA = 0.35f

@Composable
private fun ModelDownloadProgress(fraction: Float?) {
  val colors = ScottieTheme.colors
  val animatedProgress by
    animateFloatAsState(
      targetValue = fraction ?: 0f,
      animationSpec = MotionScheme.expressive().fastEffectsSpec(),
      label = "Model download progress",
    )
  val modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp))

  if (fraction == null) {
    LinearProgressIndicator(
      modifier = modifier,
      color = MaterialTheme.colorScheme.primary,
      trackColor = colors.borderSubtle,
    )
  } else {
    LinearProgressIndicator(
      progress = { animatedProgress },
      modifier = modifier,
      color = MaterialTheme.colorScheme.primary,
      trackColor = colors.borderSubtle,
      gapSize = 0.dp,
      drawStopIndicator = {},
    )
  }
}

@Composable
internal fun ModelDownloadButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  filled: Boolean = false,
  destructive: Boolean = false,
  enabled: Boolean = true,
) {
  ScottieButton(
    text = text,
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    style =
      when {
        filled -> ScottieButtonStyle.Primary
        destructive -> ScottieButtonStyle.SubtleDestructive
        else -> ScottieButtonStyle.Secondary
      },
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
              .takeIf { index != 1 },
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
