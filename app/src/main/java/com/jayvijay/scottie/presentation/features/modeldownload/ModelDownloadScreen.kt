package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.presentation.features.modeldownload.component.ModelDownloadItemState
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.ParcelableScreen
import kotlinx.parcelize.Parcelize

@Parcelize data object ModelDownloadScreen : ParcelableScreen

/** Display snapshots supplied by the download owner, in display order. IDs must be unique. */
data class ModelDownloadState(
  val models: List<ModelDownloadModel>,
  val eventSink: (ModelDownloadAction) -> Unit,
) : CircuitUiState

data class ModelDownloadModel(
  val id: String,
  val name: String,
  val description: String,
  val state: ModelDownloadItemState,
  val statusText: String,
  val progress: Float? = null,
)

sealed interface ModelDownloadAction : CircuitUiEvent {

  data object Back : ModelDownloadAction

  data class Download(val modelId: String) : ModelDownloadAction

  data class Pause(val modelId: String) : ModelDownloadAction

  data class Resume(val modelId: String) : ModelDownloadAction

  data class Delete(val modelId: String) : ModelDownloadAction
}
