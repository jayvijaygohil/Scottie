package com.jayvijay.scottie.feature.modeldownload.data.repository

import android.util.Log
import com.jayvijay.scottie.di.ApplicationScope
import com.jayvijay.scottie.feature.modeldownload.data.remote.OpenRouterModelsClient
import com.jayvijay.scottie.feature.modeldownload.domain.entities.FetchFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelsFetch
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.entities.prunedTo
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
import java.io.File
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.json.Json

/** One JSON file; never logs its contents. */
// ponytail: plaintext app-private file; EncryptedFile if the key must survive a rooted-device
// threat model
@Singleton
class OpenRouterConfigRepositoryImpl
@Inject
constructor(
  @Named("openRouterConfigFile") private val file: File,
  private val json: Json,
  @ApplicationScope private val scope: CoroutineScope,
  private val client: OpenRouterModelsClient,
) : OpenRouterConfigRepository {

  private val state = MutableStateFlow(read())
  override val config: StateFlow<OpenRouterConfig?> = state.asStateFlow()

  private val writes = Mutex()

  private fun read(): OpenRouterConfig? =
    runCatching {
        if (file.exists()) json.decodeFromString<OpenRouterConfig>(file.readText()) else null
      }
      .onFailure { Log.w(TAG, "config unreadable", it) }
      .getOrNull()

  override fun save(config: OpenRouterConfig) {
    state.value = config
    persist()
  }

  override fun clear() {
    state.value = null
    persist()
  }

  override suspend fun fetchAvailableModels(): ModelsFetch {
    val fetchedFor = state.value ?: return ModelsFetch.Failed(FetchFailure.OTHER)
    val result = client.fetch(fetchedFor.baseUrl, fetchedFor.apiKey)
    // A Save or Delete during the fetch wins over pruning.
    if (
      result is ModelsFetch.Loaded &&
        state.compareAndSet(fetchedFor, fetchedFor.prunedTo(result.models))
    ) {
      persist()
    }
    return result
  }

  /** Writes the latest state, so out-of-order launches cannot resurrect a cleared key. */
  private fun persist() {
    scope.launch {
      writes.withLock {
        runCatching {
          val current = state.value
          if (current == null) file.delete() else file.writeText(json.encodeToString(current))
        }
          .onFailure { Log.w(TAG, "config not persisted", it) }
      }
    }
  }

  private companion object {
    const val TAG = "OpenRouterConfig"
  }
}
