package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.domain.entities.HardwareTarget
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelType
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.ParcelableScreen
import kotlinx.parcelize.Parcelize

@Parcelize data object ModelDownloadScreen : ParcelableScreen

data class ModelDownloadState(
  val content: ModelDownloadContent,
  /** Current search text; blank shows the whole catalog. */
  val query: String,
  /** Model whose deletion just failed; cleared by [ModelDownloadAction.DismissError]. */
  val deleteFailedModelName: String?,
  val eventSink: (ModelDownloadAction) -> Unit,
) : CircuitUiState

sealed interface ModelDownloadContent {
  data object Loading : ModelDownloadContent

  data object Unavailable : ModelDownloadContent

  /** Non-empty sections in display order; empty while searching means nothing matched. */
  data class Models(val sections: List<ModelSection>) : ModelDownloadContent
}

/** One model type with its non-empty hardware groups, CPU before NPU. */
data class ModelSection(
  val type: ModelType,
  val count: Int,
  val expanded: Boolean,
  val groups: List<ModelGroup>,
)

/** Models of one type that run on [target], in catalog order. */
data class ModelGroup(
  val target: HardwareTarget,
  val expanded: Boolean,
  val models: List<ModelDownloadModel>,
)

data class ModelDownloadModel(
  val id: String,
  val name: String,
  val description: String?,
  val type: ModelType,
  val target: HardwareTarget,
  val downloadBytes: Long?,
  val status: ModelDownloadStatus,
  /** False when this device cannot run the model. */
  val supported: Boolean,
  /** False when unsupported or while another model downloads. */
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

  /** Ignored while searching, when every matching section is shown expanded. */
  data class ToggleGroup(val type: ModelType, val target: HardwareTarget) : ModelDownloadAction
}
