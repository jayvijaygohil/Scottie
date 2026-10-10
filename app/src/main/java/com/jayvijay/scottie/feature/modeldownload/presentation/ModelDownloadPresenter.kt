package com.jayvijay.scottie.feature.modeldownload.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jayvijay.scottie.feature.modeldownload.domain.entities.AvailableModel
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelsFetch
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterDraft
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterValidation
import com.jayvijay.scottie.feature.modeldownload.domain.repository.DownloadStart
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
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
  private val openRouter: OpenRouterConfigRepository,
) : Presenter<ModelDownloadState> {

  @Composable
  override fun present(): ModelDownloadState {
    val catalog by repository.catalog.collectAsState()
    var error by rememberRetained { mutableStateOf<ModelDownloadError?>(null) }
    var query by rememberRetained { mutableStateOf("") }
    // User toggles only; sections without one are collapsed.
    var expansion by rememberRetained { mutableStateOf(emptyMap<ModelType, Boolean>()) }
    val scope = rememberCoroutineScope()

    val models = (catalog as? ModelCatalog.Ready)?.toModels().orEmpty()
    val content = catalog.toContent { catalogSections(models, query, expansion) }
    val (section, onOpenRouter) = presentOpenRouter()

    return ModelDownloadState(content, query, error, section) { action ->
      when (action) {
        is ModelDownloadAction.OpenRouter -> onOpenRouter(action)
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
            expansion = expansion + (action.type to !(expansion[action.type] ?: false))
          }
        is ModelDownloadAction.UseModel -> {
          repository.selectTextModel(action.modelId)
          navigator.pop()
        }
      }
    }
  }

  /**
   * Drafts reset whenever the saved URL or key changes: save, delete, or relaunch. The model list
   * is fetched once per request (open with a saved config, Save, Retry), so rotation does not
   * refetch.
   */
  @Composable
  private fun presentOpenRouter():
    Pair<OpenRouterSection, (ModelDownloadAction.OpenRouter) -> Unit> {
    val config by openRouter.config.collectAsState()
    val savedUrl = config?.baseUrl
    val savedKey = config?.apiKey
    var baseUrl by rememberRetained(savedUrl, savedKey) {
      mutableStateOf(savedUrl ?: OpenRouterConfig.DEFAULT_BASE_URL)
    }
    var apiKey by rememberRetained(savedUrl, savedKey) { mutableStateOf(savedKey.orEmpty()) }
    var errors by rememberRetained(savedUrl, savedKey) {
      mutableStateOf(emptySet<OpenRouterField>())
    }
    var confirmingDelete by rememberRetained { mutableStateOf(false) }
    var expanded by rememberRetained { mutableStateOf(false) }
    var fetchRequest by rememberRetained { mutableIntStateOf(if (config != null) 1 else 0) }
    var fetchedFor by rememberRetained { mutableIntStateOf(0) }
    var result by rememberRetained { mutableStateOf<ModelsFetch?>(null) }
    var query by rememberRetained { mutableStateOf("") }

    LaunchedEffect(fetchRequest) {
      if (openRouter.config.value != null && fetchedFor != fetchRequest) {
        result = openRouter.fetchAvailableModels()
        fetchedFor = fetchRequest
      }
    }

    val saved = config
    val fetched = result
    val list =
      when {
        saved == null -> RemoteModels.Hidden
        fetchedFor != fetchRequest || fetched == null -> RemoteModels.Loading
        else ->
          when (fetched) {
            is ModelsFetch.Failed -> RemoteModels.Failed(fetched.reason)
            is ModelsFetch.Loaded ->
              RemoteModels.Loaded(
                filterRemote(fetched.models, query),
                fetched.models.size,
                saved.models.toSet(),
              )
          }
      }
    val section =
      OpenRouterSection(
        baseUrl = baseUrl,
        apiKey = apiKey,
        errors = errors,
        savedModelCount = saved?.models?.size ?: 0,
        confirmingDelete = confirmingDelete,
        expanded = expanded,
        list = list,
        query = query,
      )
    return section to { action ->
      when (action) {
        is ModelDownloadAction.EditOpenRouterBaseUrl -> {
          errors -= OpenRouterField.BASE_URL
          baseUrl = action.value
        }
        is ModelDownloadAction.EditOpenRouterApiKey -> apiKey = action.value
        ModelDownloadAction.SaveOpenRouter ->
          when (val draft = OpenRouterDraft(baseUrl, apiKey, saved?.models.orEmpty()).validate()) {
            is OpenRouterValidation.Valid -> {
              openRouter.save(draft.config)
              fetchRequest++
            }
            is OpenRouterValidation.Invalid -> errors = draft.fields
          }
        is ModelDownloadAction.ToggleRemoteModel -> {
          val models = (fetched as? ModelsFetch.Loaded)?.models
          if (saved != null && models != null) {
            val selected = saved.models.toMutableSet()
            if (!selected.remove(action.id)) selected += action.id
            openRouter.save(saved.copy(models = models.map { it.id }.filter { it in selected }))
          }
        }
        is ModelDownloadAction.SearchRemoteModels -> query = action.query
        ModelDownloadAction.RetryRemoteModels -> fetchRequest++
        ModelDownloadAction.ToggleOpenRouter -> expanded = !expanded
        ModelDownloadAction.DeleteOpenRouter -> confirmingDelete = saved != null
        ModelDownloadAction.ConfirmDeleteOpenRouter -> {
          openRouter.clear()
          result = null
          query = ""
          confirmingDelete = false
        }
        ModelDownloadAction.CancelDeleteOpenRouter -> confirmingDelete = false
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
 * Groups [models] by type; sections are collapsed unless toggled open. A non-blank [query] keeps
 * only matching models and shows every remaining section expanded without touching [expansion], so
 * clearing the search restores the user's toggles.
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
      ModelSection(type, ofType.size, searching || expansion[type] ?: false, ofType)
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

/** Case-insensitive match on name or id; a blank [query] keeps everything. */
internal fun filterRemote(models: List<AvailableModel>, query: String): List<AvailableModel> {
  val term = query.trim()
  return if (term.isEmpty()) {
    models
  } else {
    models.filter { it.name.contains(term, ignoreCase = true) || it.id.contains(term, true) }
  }
}
