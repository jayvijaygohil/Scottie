package com.jayvijay.scottie.feature.modeldownload.domain.entities

import java.net.URI
import java.net.URISyntaxException
import kotlinx.serialization.Serializable

/** The single saved OpenRouter connection; [models] are raw OpenRouter ids. */
@Serializable
data class OpenRouterConfig(val baseUrl: String, val apiKey: String, val models: List<String>) {
  /** Ids shared with on-device models in the active-model slot. */
  val modelIds: List<String>
    get() = models.map(::remoteId)

  override fun toString() = "OpenRouterConfig(baseUrl=$baseUrl, apiKey=***, models=$models)"

  companion object {
    const val DEFAULT_BASE_URL = "https://openrouter.ai"
    const val ID_PREFIX = "openrouter:"

    fun remoteId(model: String) = ID_PREFIX + model
  }
}

enum class OpenRouterField {
  BASE_URL,
  MODELS,
}

sealed interface OpenRouterValidation {
  data class Valid(val config: OpenRouterConfig) : OpenRouterValidation

  data class Invalid(val fields: Set<OpenRouterField>) : OpenRouterValidation
}

/** Unsaved Settings input; [modelsText] separates ids with semicolons. */
data class OpenRouterDraft(val baseUrl: String, val apiKey: String, val modelsText: String) {
  fun validate(): OpenRouterValidation {
    val models = modelsText.split(';').map { it.trim() }.filter { it.isNotEmpty() }.distinct()
    val url = baseUrl.trim()
    val invalid = buildSet {
      if (!isWebAddress(url)) add(OpenRouterField.BASE_URL)
      if (models.isEmpty()) add(OpenRouterField.MODELS)
    }
    return if (invalid.isEmpty()) {
      OpenRouterValidation.Valid(OpenRouterConfig(url, apiKey.trim(), models))
    } else {
      OpenRouterValidation.Invalid(invalid)
    }
  }

  private fun isWebAddress(url: String): Boolean {
    val uri =
      try {
        URI(url)
      } catch (_: URISyntaxException) {
        return false
      }
    val scheme = uri.scheme?.lowercase()
    return (scheme == "http" || scheme == "https") && !uri.host.isNullOrBlank()
  }
}
