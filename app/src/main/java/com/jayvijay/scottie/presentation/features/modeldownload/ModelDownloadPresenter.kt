package com.jayvijay.scottie.presentation.features.modeldownload

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jayvijay.scottie.domain.entities.HardwareTarget
import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelType
import com.jayvijay.scottie.domain.repository.ModelDownloadRepository
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.retained.rememberRetained
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.launch

class ModelDownloadPresenter
@AssistedInject
constructor(
  @Assisted private val navigator: Navigator,
  private val repository: ModelDownloadRepository,
) : Presenter<ModelDownloadState> {

  @Composable
  override fun present(): ModelDownloadState {
    val catalog by repository.catalog.collectAsState()
    var deleteFailedModelName by rememberRetained { mutableStateOf<String?>(null) }
    var query by rememberRetained { mutableStateOf("") }
    // User toggles only; sections without one use their default.
    var expansion by rememberRetained { mutableStateOf(emptyMap<SectionKey, Boolean>()) }
    val scope = rememberCoroutineScope()

    val models = (catalog as? ModelCatalog.Ready)?.toModels().orEmpty()
    val defaults = SectionDefaults(npuUsable = models.any { it.target.isNpu && it.supported })
    val content = catalog.toContent { catalogSections(models, query, expansion, defaults) }

    fun toggle(key: SectionKey) {
      if (query.isBlank()) {
        expansion = expansion + (key to !(expansion[key] ?: defaults.expanded(key)))
      }
    }

    return ModelDownloadState(content, query, deleteFailedModelName) { action ->
      when (action) {
        ModelDownloadAction.Back -> navigator.pop()
        is ModelDownloadAction.Download -> repository.download(action.modelId)
        is ModelDownloadAction.Pause -> repository.pause(action.modelId)
        is ModelDownloadAction.Delete ->
          scope.launch {
            repository.delete(action.modelId).onFailure {
              deleteFailedModelName =
                models.find { it.id == action.modelId }?.name ?: action.modelId
            }
          }
        ModelDownloadAction.DismissError -> deleteFailedModelName = null
        is ModelDownloadAction.Search -> query = action.query
        is ModelDownloadAction.ToggleCategory -> toggle(SectionKey(action.type, target = null))
        is ModelDownloadAction.ToggleGroup -> toggle(SectionKey(action.type, action.target))
      }
    }
  }

  @CircuitInject(ModelDownloadScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): ModelDownloadPresenter
  }
}

/** A category when [target] is null, otherwise one of its hardware groups. */
internal data class SectionKey(val type: ModelType, val target: HardwareTarget?)

/** Categories and CPU groups start open; NPU groups only when the device can run one. */
internal data class SectionDefaults(val npuUsable: Boolean) {
  fun expanded(key: SectionKey): Boolean = key.target?.isNpu != true || npuUsable
}

private val HardwareTarget.isNpu: Boolean
  get() = this == HardwareTarget.NPU

private fun ModelCatalog.toContent(sections: () -> List<ModelSection>): ModelDownloadContent =
  when (this) {
    ModelCatalog.Loading -> ModelDownloadContent.Loading
    ModelCatalog.Unavailable -> ModelDownloadContent.Unavailable
    is ModelCatalog.Ready -> ModelDownloadContent.Models(sections())
  }

private fun ModelCatalog.Ready.toModels(): List<ModelDownloadModel> {
  val busy = entries.any { it.status is ModelDownloadStatus.Downloading }
  return entries.map { (model, status, supported) ->
    ModelDownloadModel(
      id = model.id,
      name = model.name,
      description = model.description,
      type = model.type,
      target = model.target,
      downloadBytes = model.downloadBytes,
      status = status,
      supported = supported,
      canStart = supported && !busy,
    )
  }
}

/**
 * Groups [models] by type then hardware target. A non-blank [query] keeps only matching models and
 * shows every remaining section expanded without touching [expansion], so clearing the search
 * restores the user's toggles.
 */
internal fun catalogSections(
  models: List<ModelDownloadModel>,
  query: String,
  expansion: Map<SectionKey, Boolean>,
  defaults: SectionDefaults,
): List<ModelSection> {
  val term = query.trim()
  val searching = term.isNotEmpty()
  val visible = if (searching) models.filter { it.matches(term) } else models
  fun expanded(key: SectionKey) = searching || (expansion[key] ?: defaults.expanded(key))

  val byType = visible.groupBy { it.type }
  return ModelType.entries.mapNotNull { type ->
    val ofType = byType[type] ?: return@mapNotNull null
    val byTarget = ofType.groupBy { it.target }
    ModelSection(
      type = type,
      count = ofType.size,
      expanded = expanded(SectionKey(type, target = null)),
      groups =
        HardwareTarget.entries.mapNotNull { target ->
          byTarget[target]?.let { ModelGroup(target, expanded(SectionKey(type, target)), it) }
        },
    )
  }
}

// ponytail: category, target, and status keywords are English; match localized labels if the
// app gains translations.
private fun ModelDownloadModel.matches(term: String): Boolean {
  val status = if (supported) "supported" else "unsupported"
  return listOfNotNull(name, id, description, type.name.replace('_', ' '), target.name).any {
    it.contains(term, ignoreCase = true)
  } || status.startsWith(term, ignoreCase = true) // "supported" must not match "unsupported".
}
