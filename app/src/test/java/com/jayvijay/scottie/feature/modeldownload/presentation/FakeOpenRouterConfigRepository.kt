package com.jayvijay.scottie.feature.modeldownload.presentation

import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.repository.OpenRouterConfigRepository
import kotlinx.coroutines.flow.MutableStateFlow

class FakeOpenRouterConfigRepository : OpenRouterConfigRepository {
  override val config = MutableStateFlow<OpenRouterConfig?>(null)
  val saves = mutableListOf<OpenRouterConfig>()
  var clears = 0

  override fun save(config: OpenRouterConfig) {
    saves += config
    this.config.value = config
  }

  override fun clear() {
    clears++
    config.value = null
  }
}
