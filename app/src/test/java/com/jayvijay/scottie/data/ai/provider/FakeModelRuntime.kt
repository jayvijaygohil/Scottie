package com.jayvijay.scottie.data.ai.provider

import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/** Scriptable runtime: each download streams whatever [send] pushes until [finish]. */
class FakeModelRuntime : ModelRuntime {
  var prepareError: Exception? = null
  /** Ids the device accepts; null accepts every row. */
  var accepted: Set<String>? = null
  val downloaded = mutableSetOf<String>()
  /** Device RAM; null when unknown. */
  var totalMemory: Long? = null
  var downloadError: Exception? = null
  var deleteError: Exception? = null

  val downloadCalls = mutableListOf<String>()
  val cancelled = mutableListOf<String>()
  val deleted = mutableListOf<String>()
  private val channels = mutableMapOf<String, Channel<RuntimeDownloadEvent>>()

  override suspend fun prepare(catalog: List<CatalogModel>): Set<String> {
    prepareError?.let { throw it }
    return accepted ?: catalog.mapTo(mutableSetOf()) { it.id }
  }

  override suspend fun downloadedIds(): Set<String> = downloaded.toSet()

  override suspend fun totalMemoryBytes(): Long? = totalMemory

  override fun download(modelId: String): Flow<RuntimeDownloadEvent> = flow {
    downloadCalls += modelId
    downloadError?.let { throw it }
    val channel = Channel<RuntimeDownloadEvent>(Channel.UNLIMITED).also { channels[modelId] = it }
    try {
      for (event in channel) emit(event)
    } catch (e: CancellationException) {
      cancelled += modelId
      throw e
    }
  }

  fun send(modelId: String, event: RuntimeDownloadEvent) {
    channels.getValue(modelId).trySend(event)
  }

  /** Ends the download flow normally. */
  fun finish(modelId: String) {
    channels.getValue(modelId).close()
  }

  override suspend fun delete(modelId: String) {
    deleteError?.let { throw it }
    deleted += modelId
  }
}
