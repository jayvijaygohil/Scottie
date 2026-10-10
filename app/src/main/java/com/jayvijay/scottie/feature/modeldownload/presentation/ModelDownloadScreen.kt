package com.jayvijay.scottie.feature.modeldownload.presentation

import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ShortfallKind
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
  val openRouter: OpenRouterSection,
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

/** Draft OpenRouter input; edits stay local until Save. */
data class OpenRouterSection(
  val baseUrl: String,
  val apiKey: String,
  val modelsText: String,
  /** Fields that failed the last Save; a field's error clears when it is edited. */
  val errors: Set<OpenRouterField>,
  /** Models in the saved configuration; 0 when nothing is saved. */
  val savedModelCount: Int,
  val confirmingDelete: Boolean,
  val expanded: Boolean,
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

  /** Opens the screen that runs a downloaded text model. */
  data class UseModel(val modelId: String) : ModelDownloadAction

  /** Settings actions for the OpenRouter section. */
  sealed interface OpenRouter : ModelDownloadAction

  data class EditOpenRouterBaseUrl(val value: String) : OpenRouter

  data class EditOpenRouterApiKey(val value: String) : OpenRouter

  data class EditOpenRouterModels(val value: String) : OpenRouter

  /** Validates the draft; saves it or reports the failing fields. */
  data object SaveOpenRouter : OpenRouter

  data object ToggleOpenRouter : OpenRouter

  /** Opens the confirmation; ignored when nothing is saved. */
  data object DeleteOpenRouter : OpenRouter

  data object ConfirmDeleteOpenRouter : OpenRouter

  data object CancelDeleteOpenRouter : OpenRouter
}
