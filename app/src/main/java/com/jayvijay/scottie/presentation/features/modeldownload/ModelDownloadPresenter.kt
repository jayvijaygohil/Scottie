package com.jayvijay.scottie.presentation.features.modeldownload

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
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
    val scope = rememberCoroutineScope()

    val content =
      when (val current = catalog) {
        ModelCatalog.Loading -> ModelDownloadContent.Loading
        ModelCatalog.Unavailable -> ModelDownloadContent.Unavailable
        is ModelCatalog.Ready -> {
          val busy = current.entries.any { it.status is ModelDownloadStatus.Downloading }
          ModelDownloadContent.Models(
            current.entries.map { (model, status) ->
              ModelDownloadModel(
                id = model.id,
                name = model.name,
                type = model.type,
                downloadBytes = model.downloadBytes,
                status = status,
                canStart = !busy,
              )
            }
          )
        }
      }

    return ModelDownloadState(content, deleteFailedModelName) { action ->
      when (action) {
        ModelDownloadAction.Back -> navigator.pop()
        is ModelDownloadAction.Download -> repository.download(action.modelId)
        is ModelDownloadAction.Pause -> repository.pause(action.modelId)
        is ModelDownloadAction.Delete ->
          scope.launch {
            repository.delete(action.modelId).onFailure {
              deleteFailedModelName =
                (content as? ModelDownloadContent.Models)
                  ?.models
                  ?.find { it.id == action.modelId }
                  ?.name ?: action.modelId
            }
          }
        ModelDownloadAction.DismissError -> deleteFailedModelName = null
      }
    }
  }

  @CircuitInject(ModelDownloadScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): ModelDownloadPresenter
  }
}
