package com.jayvijay.scottie.presentation.features.modeldownload

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.presentation.features.modeldownload.component.ModelDownloadItemLabels
import com.jayvijay.scottie.presentation.features.modeldownload.component.ModelDownloadItemState
import com.jayvijay.scottie.presentation.features.modeldownload.component.ModelDownloadUiItem
import com.jayvijay.scottie.presentation.ui.ScottieTheme
import com.jayvijay.scottie.presentation.ui.components.ScottieToolbar
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.ui.Ui
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@CircuitInject(ModelDownloadScreen::class, SingletonComponent::class)
class ModelDownloadUi @Inject constructor() : Ui<ModelDownloadState> {

  @Composable
  override fun Content(state: ModelDownloadState, modifier: Modifier) {
    val labels =
      ModelDownloadItemLabels(
        download = stringResource(R.string.model_download_download),
        pause = stringResource(R.string.model_download_pause),
        delete = stringResource(R.string.model_download_delete),
        resume = stringResource(R.string.model_download_resume),
      )

    Column(
      modifier =
        modifier
          .fillMaxSize()
          .background(MaterialTheme.colorScheme.background)
          .safeDrawingPadding()
          .padding(top = 12.dp)
    ) {
      ScottieToolbar(
        title = stringResource(R.string.model_download_title),
        subtitle = stringResource(R.string.model_download_intro),
        backLabel = stringResource(R.string.back),
        onBack = { state.eventSink(ModelDownloadAction.Back) },
      )

      LazyColumn(
        modifier = Modifier.weight(1f),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        items(state.models, key = { it.id }) { model ->
          ModelDownloadUiItem(
            name = model.name,
            description = model.description,
            state = model.state,
            statusText = model.statusText,
            progress = model.progress,
            labels = labels,
            onDownload = { state.eventSink(ModelDownloadAction.Download(model.id)) },
            onPause = { state.eventSink(ModelDownloadAction.Pause(model.id)) },
            onResume = { state.eventSink(ModelDownloadAction.Resume(model.id)) },
            onDelete = { state.eventSink(ModelDownloadAction.Delete(model.id)) },
          )
        }
      }
    }
  }
}

@Preview(name = "Download Modals", widthDp = 390, heightDp = 844)
@Preview(
  name = "Download Modals dark",
  widthDp = 390,
  heightDp = 844,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(name = "Download Modals large text", widthDp = 320, heightDp = 720, fontScale = 2f)
@Composable
private fun ModelDownloadPreview() {
  ScottieTheme {
    ModelDownloadUi()
      .Content(
        state =
          ModelDownloadState(
            models =
              listOf(
                ModelDownloadModel(
                  id = "qwen",
                  name = "Qwen 2.5 · 1.5B",
                  description = "Everyday writing, answers, and summaries.",
                  state = ModelDownloadItemState.DOWNLOADING,
                  statusText = "Downloading · 50% · 0.5 / 1.0 GB",
                  progress = 0.5f,
                ),
                ModelDownloadModel(
                  id = "gemma3",
                  name = "Gemma 3 · 1B",
                  description = "A compact model for quick, simple tasks.",
                  state = ModelDownloadItemState.DOWNLOADED,
                  statusText = "Downloaded · 0.8 GB",
                ),
                ModelDownloadModel(
                  id = "llama",
                  name = "Llama 3.2 · 1B",
                  description = "Lightweight help with ideas and conversation.",
                  state = ModelDownloadItemState.AVAILABLE,
                  statusText = "0.9 GB download",
                ),
                ModelDownloadModel(
                  id = "gemma4",
                  name = "Gemma 4 · 1B",
                  description = "A compact model for quick, simple tasks.",
                  state = ModelDownloadItemState.DOWNLOADED,
                  statusText = "Downloaded · 0.8 GB",
                ),
              ),
            eventSink = {},
          ),
        modifier = Modifier,
      )
  }
}
