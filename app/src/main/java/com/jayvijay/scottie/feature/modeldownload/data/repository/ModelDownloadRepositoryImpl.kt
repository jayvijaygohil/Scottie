package com.jayvijay.scottie.feature.modeldownload.data.repository

import android.util.Log
import com.jayvijay.scottie.di.ApplicationScope
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.CatalogModel
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.DeviceResources
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.DownloadForegroundHost
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.ModelRuntime
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.RuntimeDownloadEvent
import com.jayvijay.scottie.feature.modeldownload.data.ai.provider.toModel
import com.jayvijay.scottie.feature.modeldownload.domain.entities.Compatibility
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Available
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Downloaded
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Downloading
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Failed
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Paused
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelEntry
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.checkCompatibility
import com.jayvijay.scottie.feature.modeldownload.domain.repository.DownloadStart
import com.jayvijay.scottie.feature.modeldownload.domain.repository.ModelDownloadRepository
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
import java.io.File
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/** Owns catalog registration, the single active download, and the active text model. */
@Singleton
class ModelDownloadRepositoryImpl
@Inject
constructor(
  private val runtime: ModelRuntime,
  private val foregroundHost: DownloadForegroundHost,
  private val resources: DeviceResources,
  private val rows: List<@JvmSuppressWildcards CatalogModel>,
  @ApplicationScope private val scope: CoroutineScope,
  /** Holds the chosen text model id; absent until the user picks one. */
  @Named("activeTextModelFile") private val activeFile: File,
  private val openRouter: OpenRouterConfigRepository,
) : ModelDownloadRepository {

  private val state = MutableStateFlow<ModelCatalog>(ModelCatalog.Loading)
  override val catalog: StateFlow<ModelCatalog> = state.asStateFlow()

  private val stored = MutableStateFlow(activeFile.takeIf { it.exists() }?.readText())
  override val activeTextModel: StateFlow<String?> =
    combine(state, stored, openRouter.config) { catalog, id, config ->
        val local = catalog.downloadedTextIds()
        val remote = config?.modelIds.orEmpty()
        id?.takeIf { it in local || it in remote } ?: local.firstOrNull() ?: remote.firstOrNull()
      }
      .stateIn(scope, SharingStarted.Eagerly, null)

  @Volatile private var active: Job? = null

  init {
    scope.launch { load() }
  }

  private suspend fun load() {
    state.value =
      try {
        val accepted = runtime.prepare(rows)
        val downloaded = runtime.downloadedIds()
        val memory = resources.availableMemoryBytes()
        val storage = resources.availableStorageBytes()
        ModelCatalog.Ready(
          rows
            .filter { it.id in accepted }
            .map { row ->
              val model = row.toModel()
              ModelEntry(
                model = model,
                status = if (row.id in downloaded) Downloaded else Available,
                supported =
                  checkCompatibility(model.memoryBytes, model.downloadBytes, memory, storage) ==
                    Compatibility.Compatible,
              )
            }
        )
      } catch (e: CancellationException) {
        throw e
      } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
        Log.e(TAG, "model runtime unavailable", e)
        ModelCatalog.Unavailable
      }
  }

  override suspend fun download(modelId: String): DownloadStart {
    val model =
      (state.value as? ModelCatalog.Ready)
        ?.takeIf { it.bytesToKeep(modelId) != null }
        ?.entries
        ?.first { it.model.id == modelId }
        ?.model ?: return DownloadStart.Ignored
    val verdict =
      checkCompatibility(
        model.memoryBytes,
        model.downloadBytes,
        resources.availableMemoryBytes(),
        resources.availableStorageBytes(),
      )
    return if (verdict is Compatibility.Shortfall) DownloadStart.Refused(verdict)
    else start(modelId)
  }

  private fun start(modelId: String): DownloadStart {
    // Re-checked atomically: another download may have started while probing.
    var kept: Long? = null
    state.update { catalog ->
      val current = catalog as? ModelCatalog.Ready
      kept = current?.bytesToKeep(modelId)
      kept?.let { current?.withStatus(modelId, Downloading(DownloadProgress(it, 0, null))) }
        ?: catalog
    }
    val from = kept ?: return DownloadStart.Ignored

    if (foregroundHost.start()) {
      active = scope.launch { collect(modelId, from) }
    } else {
      setStatus(modelId, Failed(DownloadFailure.BACKGROUND_REFUSED, from))
    }
    return DownloadStart.Started
  }

  /** Bytes a start would resume from; null when [modelId] cannot start now. */
  private fun ModelCatalog.Ready.bytesToKeep(modelId: String): Long? {
    val busy = entries.any { it.status is Downloading }
    val entry =
      entries.find { it.model.id == modelId }?.takeUnless { busy || it.model.requiresToken }
    return when (val status = entry?.status) {
      Available -> 0
      is Paused -> status.bytesKept
      is Failed -> status.bytesKept
      else -> null
    }
  }

  private suspend fun collect(modelId: String, kept: Long) {
    var bytes = kept
    val outcome: ModelDownloadStatus =
      try {
        var result: ModelDownloadStatus? = null
        runtime.download(modelId).collect { event ->
          when (event) {
            is RuntimeDownloadEvent.Progress -> {
              bytes = event.progress.bytesDone
              setStatus(modelId, Downloading(event.progress))
            }
            RuntimeDownloadEvent.Completed -> result = Downloaded
            RuntimeDownloadEvent.Cancelled -> result = Paused(bytes)
            is RuntimeDownloadEvent.Failed -> result = Failed(event.reason, bytes)
          }
        }
        // Ending without Completed is an interruption, never a download (FR-009).
        result ?: Paused(bytes)
      } catch (e: CancellationException) {
        setStatus(modelId, Paused(bytes))
        throw e
      } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
        Log.w(TAG, "download $modelId failed", e)
        Failed(DownloadFailure.UNKNOWN, bytes)
      }
    setStatus(modelId, outcome)
  }

  override fun pause(modelId: String) {
    val entry = (state.value as? ModelCatalog.Ready)?.entries?.find { it.model.id == modelId }
    val status = entry?.status as? Downloading ?: return
    setStatus(modelId, Paused(status.progress.bytesDone))
    active?.cancel()
  }

  override suspend fun delete(modelId: String): Result<Unit> =
    try {
      runtime.delete(modelId)
      setStatus(modelId, Available)
      Result.success(Unit)
    } catch (e: CancellationException) {
      throw e
    } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
      Result.failure(e)
    }

  override fun selectTextModel(modelId: String) {
    val remote = openRouter.config.value?.modelIds.orEmpty()
    if (modelId !in state.value.downloadedTextIds() && modelId !in remote) return
    stored.value = modelId
    scope.launch {
      runCatching { activeFile.writeText(modelId) }
        .onFailure { Log.w(TAG, "active model not saved", it) }
    }
  }

  private fun setStatus(modelId: String, status: ModelDownloadStatus) {
    state.update { (it as? ModelCatalog.Ready)?.withStatus(modelId, status) ?: it }
  }

  private fun ModelCatalog.Ready.withStatus(modelId: String, status: ModelDownloadStatus) =
    copy(entries = entries.map { if (it.model.id == modelId) it.copy(status = status) else it })

  private companion object {
    const val TAG = "ModelDownload"
  }
}

private fun ModelCatalog.downloadedTextIds(): List<String> =
  (this as? ModelCatalog.Ready)
    ?.entries
    ?.filter { it.model.type == ModelType.TEXT && it.status == Downloaded }
    ?.map { it.model.id }
    .orEmpty()
