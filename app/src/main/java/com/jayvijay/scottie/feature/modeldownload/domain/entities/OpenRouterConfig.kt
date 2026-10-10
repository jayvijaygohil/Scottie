package com.jayvijay.scottie.feature.modeldownload.domain.entities

import java.net.URI
import java.net.URISyntaxException
import kotlinx.serialization.Serializable

/**
 * The single saved OpenRouter connection; [models] are the checked OpenRouter ids, in fetched-list
 * order; may be empty.
 */
@Serializable
data class OpenRouterConfig(val baseUrl: String, val apiKey: String, val models: List<String>) {
  /** Ids shared with on-device models in the active-model slot. */
  val modelIds: List<String>
    get() = models.map(::remoteId)

  override fun toString() = "OpenRouterConfig(baseUrl=$baseUrl, apiKey=***, models=$models)"

  companion object {
    const val DEFAULT_BASE_URL = "https://openrouter.ai/api/v1"
    const val ID_PREFIX = "openrouter:"

    fun remoteId(model: String) = ID_PREFIX + model
  }
}

/** Keeps only selected ids still in [available], in [available]'s order. */
fun OpenRouterConfig.prunedTo(available: List<AvailableModel>): OpenRouterConfig {
  val selected = models.toSet()
  return copy(models = available.map { it.id }.filter { it in selected })
}

/** One entry of the service's model list; [name] falls back to [id]. */
data class AvailableModel(val id: String, val name: String)

enum class FetchFailure {
  NO_CONNECTION,
  AUTH,
  OTHER,
}

sealed interface ModelsFetch {
  data class Loaded(val models: List<AvailableModel>) : ModelsFetch

  data class Failed(val reason: FetchFailure) : ModelsFetch
}

enum class OpenRouterField {
  BASE_URL
}

sealed interface OpenRouterValidation {
  data class Valid(val config: OpenRouterConfig) : OpenRouterValidation

  data class Invalid(val fields: Set<OpenRouterField>) : OpenRouterValidation
}

/**
 * Unsaved Settings input; [selection] is carried through unchanged. [baseUrl] is the API root that
 * `/models` and `/chat/completions` hang off, e.g. `https://openrouter.ai/api/v1`.
 */
data class OpenRouterDraft(val baseUrl: String, val apiKey: String, val selection: List<String>) {
  fun validate(): OpenRouterValidation {
    val url = baseUrl.trim()
    return if (isWebAddress(url)) {
      OpenRouterValidation.Valid(OpenRouterConfig(url, apiKey.trim(), selection))
    } else {
      OpenRouterValidation.Invalid(setOf(OpenRouterField.BASE_URL))
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
    return (scheme == "http" || scheme == "https") &&
      !uri.host.isNullOrBlank() &&
      uri.rawQuery == null &&
      uri.rawFragment == null
  }
}
