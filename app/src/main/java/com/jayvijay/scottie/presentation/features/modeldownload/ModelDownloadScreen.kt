package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelType
import com.jayvijay.scottie.domain.entities.ShortfallKind
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.ParcelableScreen
import kotlinx.parcelize.Parcelize

@Parcelize data object ModelDownloadScreen : ParcelableScreen

data class ModelDownloadState(
  val content: ModelDownloadContent,
  /** Current search text; blank shows the whole catalog. */
  val query: String,
  /** Shown as a toast until [ModelDownloadAction.DismissError]. */
  val error: ModelDownloadError?,
  val eventSink: (ModelDownloadAction) -> Unit,
) : CircuitUiState

sealed interface ModelDownloadContent {
  data object Loading : ModelDownloadContent

  data object Unavailable : ModelDownloadContent

  /** Non-empty sections in display order; empty while searching means nothing matched. */
  data class Models(val sections: List<ModelSection>) : ModelDownloadContent
}

/** One model type with its models in catalog order. */
data class ModelSection(
  val type: ModelType,
  val count: Int,
  val expanded: Boolean,
  val models: List<ModelDownloadModel>,
)

sealed interface ModelDownloadError {
  data class DeleteFailed(val modelName: String) : ModelDownloadError

  /** The device lacked [requiredBytes] of [kind] when the download was about to start. */
  data class Shortfall(val kind: ShortfallKind, val requiredBytes: Long, val availableBytes: Long) :
    ModelDownloadError
}

data class ModelDownloadModel(
  val id: String,
  val name: String,
  val description: String?,
  val type: ModelType,
  val downloadBytes: Long?,
  val status: ModelDownloadStatus,
  /** False when this device cannot run the model. */
  val supported: Boolean,
  /** False when unsupported, token-required, or while another model downloads. */
  val canStart: Boolean,
)

sealed interface ModelDownloadAction : CircuitUiEvent {
  data object Back : ModelDownloadAction

  /** Also resumes a paused download and retries a failed one. */
  data class Download(val modelId: String) : ModelDownloadAction

  data class Pause(val modelId: String) : ModelDownloadAction

  data class Delete(val modelId: String) : ModelDownloadAction

  data object DismissError : ModelDownloadAction

  data class Search(val query: String) : ModelDownloadAction

  /** Ignored while searching, when every matching section is shown expanded. */
  data class ToggleCategory(val type: ModelType) : ModelDownloadAction
}
