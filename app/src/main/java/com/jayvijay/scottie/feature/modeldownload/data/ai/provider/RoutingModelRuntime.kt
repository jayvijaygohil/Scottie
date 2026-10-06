package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import kotlinx.coroutines.flow.Flow

/** Sends LiteRT rows to [liteRt] and every other row to [runAnywhere]. */
class RoutingModelRuntime(
  private val liteRt: ModelRuntime,
  private val runAnywhere: ModelRuntime,
) : ModelRuntime {

  @Volatile private var liteRtIds = emptySet<String>()

  override suspend fun prepare(catalog: List<CatalogModel>): Set<String> {
    val (lite, rest) = catalog.partition { it is LiteRtModel }
    liteRtIds = lite.mapTo(mutableSetOf()) { it.id }
    return liteRt.prepare(lite) + runAnywhere.prepare(rest)
  }

  override suspend fun downloadedIds(): Set<String> =
    liteRt.downloadedIds() + runAnywhere.downloadedIds()

  override fun download(modelId: String): Flow<RuntimeDownloadEvent> =
    owner(modelId).download(modelId)

  override suspend fun delete(modelId: String) = owner(modelId).delete(modelId)

  private fun owner(modelId: String) = if (modelId in liteRtIds) liteRt else runAnywhere
}
