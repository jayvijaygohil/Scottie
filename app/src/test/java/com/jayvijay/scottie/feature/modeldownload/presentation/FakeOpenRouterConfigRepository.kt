package com.jayvijay.scottie.feature.modeldownload.presentation

import com.jayvijay.scottie.feature.modeldownload.domain.entities.FetchFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelsFetch
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.entities.prunedTo
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.MutableStateFlow

class FakeOpenRouterConfigRepository : OpenRouterConfigRepository {
  override val config = MutableStateFlow<OpenRouterConfig?>(null)
  val saves = mutableListOf<OpenRouterConfig>()
  var clears = 0
  var nextFetch: ModelsFetch = ModelsFetch.Loaded(emptyList())
  var fetches = 0

  /** When set, each fetch waits for it, so tests can observe Loading. */
  var gate: CompletableDeferred<Unit>? = null

  override fun save(config: OpenRouterConfig) {
    saves += config
    this.config.value = config
  }

  override fun clear() {
    clears++
    config.value = null
  }

  override suspend fun fetchAvailableModels(): ModelsFetch {
    fetches++
    gate?.await()
    val current = config.value ?: return ModelsFetch.Failed(FetchFailure.OTHER)
    val result = nextFetch
    if (result is ModelsFetch.Loaded) config.value = current.prunedTo(result.models)
    return result
  }
}
