package com.jayvijay.scottie.feature.modeldownload.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.repository.DownloadStart
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
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
    var error by rememberRetained { mutableStateOf<ModelDownloadError?>(null) }
    var query by rememberRetained { mutableStateOf("") }
    // User toggles only; sections without one are expanded.
    var expansion by rememberRetained { mutableStateOf(emptyMap<ModelType, Boolean>()) }
    val scope = rememberCoroutineScope()

    val models = (catalog as? ModelCatalog.Ready)?.toModels().orEmpty()
    val content = catalog.toContent { catalogSections(models, query, expansion) }

    return ModelDownloadState(content, query, error) { action ->
      when (action) {
        ModelDownloadAction.Back -> navigator.pop()
        is ModelDownloadAction.Download ->
          scope.launch {
            val start = repository.download(action.modelId)
            if (start is DownloadStart.Refused) {
              val (kind, required, available) = start.shortfall
              error = ModelDownloadError.Shortfall(kind, required, available)
            }
          }
        is ModelDownloadAction.Pause -> repository.pause(action.modelId)
        is ModelDownloadAction.Delete ->
          scope.launch {
            repository.delete(action.modelId).onFailure {
              val name = models.find { it.id == action.modelId }?.name ?: action.modelId
              error = ModelDownloadError.DeleteFailed(name)
            }
          }
        ModelDownloadAction.DismissError -> error = null
        is ModelDownloadAction.Search -> query = action.query
        is ModelDownloadAction.ToggleCategory ->
          if (query.isBlank()) {
            expansion = expansion + (action.type to !(expansion[action.type] ?: true))
          }
        is ModelDownloadAction.UseModel -> {
          repository.selectTextModel(action.modelId)
          navigator.pop()
        }
      }
    }
  }

  @CircuitInject(ModelDownloadScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): ModelDownloadPresenter
  }
}

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
      downloadBytes = model.downloadBytes,
      status = status,
      supported = supported,
      canStart = supported && !model.requiresToken && !busy,
    )
  }
}

/**
 * Groups [models] by type. A non-blank [query] keeps only matching models and shows every remaining
 * section expanded without touching [expansion], so clearing the search restores the user's
 * toggles.
 */
internal fun catalogSections(
  models: List<ModelDownloadModel>,
  query: String,
  expansion: Map<ModelType, Boolean>,
): List<ModelSection> {
  val term = query.trim()
  val searching = term.isNotEmpty()
  val visible = if (searching) models.filter { it.matches(term) } else models
  val byType = visible.groupBy { it.type }
  return ModelType.entries.mapNotNull { type ->
    byType[type]?.let { ofType ->
      ModelSection(type, ofType.size, searching || expansion[type] ?: true, ofType)
    }
  }
}

// ponytail: category and status keywords are English; match localized labels if the app gains
// translations.
private fun ModelDownloadModel.matches(term: String): Boolean {
  val status = if (supported) "supported" else "unsupported"
  return listOfNotNull(name, id, description, type.name.replace('_', ' ')).any {
    it.contains(term, ignoreCase = true)
  } || status.startsWith(term, ignoreCase = true) // "supported" must not match "unsupported".
}
