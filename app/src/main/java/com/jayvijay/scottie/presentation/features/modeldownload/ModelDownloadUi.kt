package com.jayvijay.scottie.presentation.features.modeldownload

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.jayvijay.scottie.R
import com.jayvijay.scottie.domain.entities.DownloadFailure
import com.jayvijay.scottie.domain.entities.DownloadProgress
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelType
import com.jayvijay.scottie.presentation.features.modeldownload.component.ModelDownloadUiItem
import com.jayvijay.scottie.presentation.ui.ScottieTheme
import com.jayvijay.scottie.presentation.ui.components.ScottieToolbar
import com.jayvijay.scottie.presentation.ui.xelauikit.XelaToast
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.ui.Ui
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@CircuitInject(ModelDownloadScreen::class, SingletonComponent::class)
class ModelDownloadUi @Inject constructor() : Ui<ModelDownloadState> {

  @Composable
  override fun Content(state: ModelDownloadState, modifier: Modifier) {
    val onDownload = rememberNotificationPermissionGate { id ->
      state.eventSink(ModelDownloadAction.Download(id))
    }

    Box(
      modifier =
        modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).safeDrawingPadding()
    ) {
      Column(modifier = Modifier.fillMaxSize().padding(top = 12.dp)) {
        ScottieToolbar(
          title = stringResource(R.string.model_download_title),
          subtitle = stringResource(R.string.model_download_intro),
          backLabel = stringResource(R.string.back),
          onBack = { state.eventSink(ModelDownloadAction.Back) },
        )

        when (val content = state.content) {
          ModelDownloadContent.Loading ->
            Message(stringResource(R.string.model_download_loading), loading = true)
          ModelDownloadContent.Unavailable ->
            Message(stringResource(R.string.model_download_unavailable))
          is ModelDownloadContent.Models ->
            LazyColumn(
              modifier = Modifier.weight(1f),
              contentPadding = PaddingValues(16.dp),
              verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
              items(content.models, key = { it.id }) { model ->
                ModelDownloadUiItem(
                  name = model.name,
                  description = stringResource(model.type.label()),
                  downloadBytes = model.downloadBytes,
                  status = model.status,
                  canStart = model.canStart,
                  onDownload = { onDownload(model.id) },
                  onPause = { state.eventSink(ModelDownloadAction.Pause(model.id)) },
                  onDelete = { state.eventSink(ModelDownloadAction.Delete(model.id)) },
                )
              }
            }
        }
      }

      state.deleteFailedModelName?.let { name ->
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)) {
          XelaToast(
            title = stringResource(R.string.model_download_delete_failed, name),
            firstActionButtonText = stringResource(R.string.model_download_dismiss),
            onFirstButtonAction = { state.eventSink(ModelDownloadAction.DismissError) },
            background = MaterialTheme.colorScheme.surface,
            titleColor = MaterialTheme.colorScheme.onSurface,
            firstActionButtonColor = MaterialTheme.colorScheme.error,
          )
        }
      }
    }
  }
}

/**
 * Asks for notification permission on the first download tap (API 33+). The download proceeds
 * whatever the answer; only its notification depends on it.
 */
@Composable
private fun rememberNotificationPermissionGate(onDownload: (String) -> Unit): (String) -> Unit {
  val context = LocalContext.current
  var asked by rememberSaveable { mutableStateOf(false) }
  val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {}
  return { id ->
    if (
      !asked &&
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
        ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) !=
          PackageManager.PERMISSION_GRANTED
    ) {
      asked = true
      launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
    }
    onDownload(id)
  }
}

@Composable
private fun Message(text: String, loading: Boolean = false) {
  Column(
    modifier = Modifier.fillMaxSize().padding(32.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    if (loading) CircularProgressIndicator(color = MaterialTheme.colorScheme.error)
    Text(
      text = text,
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      textAlign = TextAlign.Center,
    )
  }
}

private fun ModelType.label(): Int =
  when (this) {
    ModelType.TEXT -> R.string.model_type_text
    ModelType.MULTIMODAL -> R.string.model_type_multimodal
    ModelType.VISION -> R.string.model_type_vision
    ModelType.IMAGE_GENERATION -> R.string.model_type_image_generation
    ModelType.EMBEDDING -> R.string.model_type_embedding
    ModelType.SPEECH_RECOGNITION -> R.string.model_type_speech_recognition
    ModelType.SPEECH_SYNTHESIS -> R.string.model_type_speech_synthesis
    ModelType.VOICE_ACTIVITY -> R.string.model_type_voice_activity
    ModelType.SEGMENTATION -> R.string.model_type_segmentation
    ModelType.OTHER -> R.string.model_type_other
  }

private fun previewState(content: ModelDownloadContent, deleteFailed: String? = null) =
  ModelDownloadState(content = content, deleteFailedModelName = deleteFailed, eventSink = {})

private val previewModels =
  ModelDownloadContent.Models(
    listOf(
      ModelDownloadModel(
        id = "qwen",
        name = "Qwen 2.5 · 1.5B",
        type = ModelType.TEXT,
        downloadBytes = 1_000_000_000,
        status =
          ModelDownloadStatus.Downloading(DownloadProgress(500_000_000, 1_000_000_000, 0.5f)),
        canStart = false,
      ),
      ModelDownloadModel(
        id = "whisper",
        name = "Whisper Tiny",
        type = ModelType.SPEECH_RECOGNITION,
        downloadBytes = 75_000_000,
        status = ModelDownloadStatus.Failed(DownloadFailure.STORAGE, 12_000_000),
        canStart = false,
      ),
      ModelDownloadModel(
        id = "gemma3",
        name = "Gemma 3 · 1B",
        type = ModelType.MULTIMODAL,
        downloadBytes = 800_000_000,
        status = ModelDownloadStatus.Downloaded,
        canStart = false,
      ),
      ModelDownloadModel(
        id = "llama",
        name = "Llama 3.2 · 1B",
        type = ModelType.TEXT,
        downloadBytes = null,
        status = ModelDownloadStatus.Available,
        canStart = false,
      ),
    )
  )

@Preview(name = "Download models", widthDp = 390, heightDp = 844)
@Preview(
  name = "Download models dark",
  widthDp = 390,
  heightDp = 844,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(name = "Download models large text", widthDp = 320, heightDp = 720, fontScale = 2f)
@Composable
private fun ModelDownloadPreview() {
  ScottieTheme { ModelDownloadUi().Content(previewState(previewModels), Modifier) }
}

@Preview(name = "Delete failed", widthDp = 390, heightDp = 844)
@Composable
private fun ModelDownloadDeleteFailedPreview() {
  ScottieTheme {
    ModelDownloadUi().Content(previewState(previewModels, deleteFailed = "Gemma 3 · 1B"), Modifier)
  }
}

@Preview(name = "Loading", widthDp = 390, heightDp = 844)
@Composable
private fun ModelDownloadLoadingPreview() {
  ScottieTheme { ModelDownloadUi().Content(previewState(ModelDownloadContent.Loading), Modifier) }
}

@Preview(name = "Unavailable", widthDp = 390, heightDp = 844)
@Composable
private fun ModelDownloadUnavailablePreview() {
  ScottieTheme {
    ModelDownloadUi().Content(previewState(ModelDownloadContent.Unavailable), Modifier)
  }
}
