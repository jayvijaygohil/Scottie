package com.jayvijay.scottie.feature.modeldownload.domain.repository

import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelsFetch
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import kotlinx.coroutines.flow.StateFlow

interface OpenRouterConfigRepository {
  /** Null when nothing saved. */
  val config: StateFlow<OpenRouterConfig?>

  /** Replaces the single configuration and persists it. */
  fun save(config: OpenRouterConfig)

  /** Removes the configuration and persists the removal. */
  fun clear()

  /**
   * Lists the saved service's text models; `Failed(OTHER)` when nothing is saved. On `Loaded` the
   * saved selection is pruned to listed ids in listed order; on `Failed` nothing changes.
   */
  suspend fun fetchAvailableModels(): ModelsFetch
}
