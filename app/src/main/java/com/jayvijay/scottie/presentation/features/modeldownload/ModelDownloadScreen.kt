package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelType
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.ParcelableScreen
import kotlinx.parcelize.Parcelize

@Parcelize data object ModelDownloadScreen : ParcelableScreen

data class ModelDownloadState(
  val content: ModelDownloadContent,
  /** Model whose deletion just failed; cleared by [ModelDownloadAction.DismissError]. */
  val deleteFailedModelName: String?,
  val eventSink: (ModelDownloadAction) -> Unit,
) : CircuitUiState

sealed interface ModelDownloadContent {
  data object Loading : ModelDownloadContent

  data object Unavailable : ModelDownloadContent

  /** Rows in display order. IDs are unique. */
  data class Models(val models: List<ModelDownloadModel>) : ModelDownloadContent
}

data class ModelDownloadModel(
  val id: String,
  val name: String,
  val type: ModelType,
  val downloadBytes: Long?,
  val status: ModelDownloadStatus,
  /** False while another model downloads. */
  val canStart: Boolean,
)

sealed interface ModelDownloadAction : CircuitUiEvent {
  data object Back : ModelDownloadAction

  /** Also resumes a paused download and retries a failed one. */
  data class Download(val modelId: String) : ModelDownloadAction

  data class Pause(val modelId: String) : ModelDownloadAction

  data class Delete(val modelId: String) : ModelDownloadAction

  data object DismissError : ModelDownloadAction
}
