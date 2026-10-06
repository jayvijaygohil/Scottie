package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import kotlinx.coroutines.flow.Flow

/** Seam over the on-device runtime so download logic runs in JVM tests. */
interface ModelRuntime {
  /** Initializes the SDK and registers [catalog]; returns the ids the device accepts. */
  suspend fun prepare(catalog: List<CatalogModel>): Set<String>

  suspend fun downloadedIds(): Set<String>

  fun download(modelId: String): Flow<RuntimeDownloadEvent>

  suspend fun delete(modelId: String)
}

sealed interface RuntimeDownloadEvent {
  data class Progress(val progress: DownloadProgress) : RuntimeDownloadEvent

  data object Completed : RuntimeDownloadEvent

  /** The runtime settled the transfer as cancelled; bytes are kept. */
  data object Cancelled : RuntimeDownloadEvent

  data class Failed(val reason: DownloadFailure) : RuntimeDownloadEvent
}
