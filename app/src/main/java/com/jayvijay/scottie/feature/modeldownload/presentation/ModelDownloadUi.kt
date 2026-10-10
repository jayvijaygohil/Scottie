package com.jayvijay.scottie.feature.modeldownload.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import android.text.format.Formatter
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
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
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieSearchField
import com.jayvijay.scottie.core.ui.components.ScottieToolbar
import com.jayvijay.scottie.core.ui.xelauikit.XelaToast
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ShortfallKind
import com.jayvijay.scottie.feature.modeldownload.presentation.component.ModelSections
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
          search =
            if (state.content is ModelDownloadContent.Models) {
              {
                ScottieSearchField(
                  value = state.query,
                  onValueChange = { state.eventSink(ModelDownloadAction.Search(it)) },
                  placeholder = stringResource(R.string.model_download_search_placeholder),
                  clearLabel = stringResource(R.string.model_download_search_clear),
                )
              }
            } else {
              null
            },
        )

        when (val content = state.content) {
          ModelDownloadContent.Loading ->
            Message(stringResource(R.string.model_download_loading), loading = true)
          ModelDownloadContent.Unavailable ->
            Message(stringResource(R.string.model_download_unavailable))
          is ModelDownloadContent.Models ->
            if (content.sections.isEmpty() && state.query.isNotBlank()) {
              Message(stringResource(R.string.model_download_search_empty, state.query.trim()))
            } else {
              ModelSections(
                sections = content.sections,
                onEvent = state.eventSink,
                onDownload = onDownload,
                modifier = Modifier.weight(1f),
              )
            }
        }
      }

      state.error?.let { error ->
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)) {
          XelaToast(
            title = errorMessage(error),
            firstActionButtonText = stringResource(R.string.model_download_dismiss),
            onFirstButtonAction = { state.eventSink(ModelDownloadAction.DismissError) },
            background = MaterialTheme.colorScheme.surface,
            titleColor = MaterialTheme.colorScheme.onSurface,
            firstActionButtonColor = MaterialTheme.colorScheme.primary,
          )
        }
      }
    }
  }
}

@Composable
private fun errorMessage(error: ModelDownloadError): String =
  when (error) {
    is ModelDownloadError.DeleteFailed ->
      stringResource(R.string.model_download_delete_failed, error.modelName)
    is ModelDownloadError.Shortfall -> {
      val context = LocalContext.current
      stringResource(
        when (error.kind) {
          ShortfallKind.MEMORY -> R.string.model_download_shortfall_memory
          ShortfallKind.STORAGE -> R.string.model_download_shortfall_storage
        },
        Formatter.formatShortFileSize(context, error.requiredBytes),
        Formatter.formatShortFileSize(context, error.availableBytes),
      )
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
    if (loading) CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
    Text(
      text = text,
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      textAlign = TextAlign.Center,
    )
  }
}

private fun previewState(
  content: ModelDownloadContent,
  query: String = "",
  error: ModelDownloadError? = null,
) = ModelDownloadState(content = content, query = query, error = error, eventSink = {})

private fun previewModel(
  id: String,
  name: String,
  type: ModelType,
  status: ModelDownloadStatus,
  supported: Boolean = true,
) =
  ModelDownloadModel(
    id = id,
    name = name,
    description = "Google general-purpose chat model.",
    type = type,
    downloadBytes = 1_000_000_000,
    status = status,
    supported = supported,
    canStart = false,
  )

private val previewModels =
  ModelDownloadContent.Models(
    listOf(
      ModelSection(
        type = ModelType.TEXT,
        count = 3,
        expanded = true,
        models =
          listOf(
            previewModel(
              "qwen",
              "Qwen3.5 2B",
              ModelType.TEXT,
              ModelDownloadStatus.Downloading(DownloadProgress(500_000_000, 1_000_000_000, 0.5f)),
            ),
            previewModel(
              "gemma4",
              "Gemma 4 12B",
              ModelType.TEXT,
              ModelDownloadStatus.Available,
              supported = false,
            ),
            // Token-required: supported, but Download stays disabled.
            previewModel("gemma3", "Gemma 3 1B", ModelType.TEXT, ModelDownloadStatus.Available),
          ),
      ),
      ModelSection(
        type = ModelType.SPEECH_RECOGNITION,
        count = 1,
        expanded = true,
        models =
          listOf(
            previewModel(
              "whisper",
              "Whisper Tiny EN",
              ModelType.SPEECH_RECOGNITION,
              ModelDownloadStatus.Failed(DownloadFailure.STORAGE, 12_000_000),
            )
          ),
      ),
    )
  )

private val previewShortfall =
  ModelDownloadError.Shortfall(ShortfallKind.STORAGE, 2_600_000_000, 1_400_000_000)

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

@Preview(name = "Storage shortfall", widthDp = 390, heightDp = 844)
@Composable
private fun ModelDownloadShortfallPreview() {
  ScottieTheme {
    ModelDownloadUi()
      .Content(
        previewState(previewModels, error = previewShortfall),
        Modifier,
      )
  }
}

@Preview(name = "No search results", widthDp = 390, heightDp = 844)
@Composable
private fun ModelDownloadNoResultsPreview() {
  ScottieTheme {
    ModelDownloadUi()
      .Content(previewState(ModelDownloadContent.Models(emptyList()), query = "llava"), Modifier)
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
