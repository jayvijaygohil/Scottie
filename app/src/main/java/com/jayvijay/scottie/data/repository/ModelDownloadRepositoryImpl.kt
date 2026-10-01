package com.jayvijay.scottie.data.repository

import android.util.Log
import com.jayvijay.scottie.data.ai.provider.CatalogModel
import com.jayvijay.scottie.data.ai.provider.DownloadForegroundHost
import com.jayvijay.scottie.data.ai.provider.ModelRuntime
import com.jayvijay.scottie.data.ai.provider.RuntimeDownloadEvent
import com.jayvijay.scottie.data.ai.provider.toModel
import com.jayvijay.scottie.di.ApplicationScope
import com.jayvijay.scottie.domain.entities.DownloadFailure
import com.jayvijay.scottie.domain.entities.DownloadProgress
import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Available
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Downloaded
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Downloading
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Failed
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Paused
import com.jayvijay.scottie.domain.entities.ModelEntry
import com.jayvijay.scottie.domain.repository.ModelDownloadRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/** Owns catalog registration and the single active download. */
@Singleton
class ModelDownloadRepositoryImpl
@Inject
constructor(
  private val runtime: ModelRuntime,
  private val foregroundHost: DownloadForegroundHost,
  private val rows: List<@JvmSuppressWildcards CatalogModel>,
  @ApplicationScope private val scope: CoroutineScope,
) : ModelDownloadRepository {

  private val state = MutableStateFlow<ModelCatalog>(ModelCatalog.Loading)
  override val catalog: StateFlow<ModelCatalog> = state.asStateFlow()

  @Volatile private var active: Job? = null

  init {
    scope.launch { load() }
  }

  private suspend fun load() {
    state.value =
      try {
        val accepted = runtime.prepare(rows)
        val downloaded = runtime.downloadedIds()
        ModelCatalog.Ready(
          rows
            // Rejected rows (e.g. NPU bundles for other chips) stay visible once on disk.
            .filter { it.id in accepted || it.id in downloaded }
            .map { ModelEntry(it.toModel(), if (it.id in downloaded) Downloaded else Available) }
        )
      } catch (e: CancellationException) {
        throw e
      } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
        Log.e(TAG, "model runtime unavailable", e)
        ModelCatalog.Unavailable
      }
  }

  override fun download(modelId: String) {
    var kept = -1L
    state.update { catalog ->
      kept = -1L
      val entries = (catalog as? ModelCatalog.Ready)?.entries ?: return@update catalog
      if (entries.any { it.status is Downloading }) return@update catalog
      kept =
        when (val status = entries.find { it.model.id == modelId }?.status) {
          Available -> 0
          is Paused -> status.bytesKept
          is Failed -> status.bytesKept
          else -> return@update catalog
        }
      catalog.withStatus(modelId, Downloading(DownloadProgress(kept, 0, null)))
    }
    if (kept < 0) return

    if (!foregroundHost.start()) {
      setStatus(modelId, Failed(DownloadFailure.BACKGROUND_REFUSED, kept))
      return
    }
    active = scope.launch { collect(modelId, kept) }
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

  private fun setStatus(modelId: String, status: ModelDownloadStatus) {
    state.update { (it as? ModelCatalog.Ready)?.withStatus(modelId, status) ?: it }
  }

  private fun ModelCatalog.Ready.withStatus(modelId: String, status: ModelDownloadStatus) =
    copy(entries = entries.map { if (it.model.id == modelId) it.copy(status = status) else it })

  private companion object {
    const val TAG = "ModelDownload"
  }
}
