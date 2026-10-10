package com.jayvijay.scottie.feature.modeldownload.data.remote

import android.util.Log
import com.jayvijay.scottie.feature.modeldownload.domain.entities.AvailableModel
import com.jayvijay.scottie.feature.modeldownload.domain.entities.FetchFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelsFetch
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URI
import java.net.URISyntaxException
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/** Reads every page of `<baseUrl>/models`; logs only the failure kind and HTTP status. */
@Singleton
class OpenRouterModelsClient @Inject constructor(private val json: Json) {

  suspend fun fetch(baseUrl: String, apiKey: String): ModelsFetch =
    withContext(Dispatchers.IO) {
      try {
        val first = baseUrl.removeSuffix("/") + PATH
        ModelsFetch.Loaded(toAvailable(entries(first, apiKey)))
      } catch (e: Failure) {
        ModelsFetch.Failed(e.reason)
      } catch (e: MalformedURLException) {
        failed(FetchFailure.OTHER, e)
      } catch (e: IOException) {
        failed(FetchFailure.NO_CONNECTION, e)
      } catch (e: URISyntaxException) {
        failed(FetchFailure.OTHER, e)
      } catch (e: IllegalArgumentException) { // Undecodable body or unusable next link.
        failed(FetchFailure.OTHER, e)
      }
    }

  /** Follows `links.next` until it is absent or repeats. */
  private fun entries(first: String, apiKey: String): List<Entry> {
    val entries = mutableListOf<Entry>()
    val visited = mutableSetOf<String>()
    var next: String? = first
    while (next != null && visited.add(next)) {
      val current: String = next
      val page = parsePage(get(current, apiKey))
      entries += page.data.orEmpty()
      next = page.links?.next?.takeIf { it.isNotBlank() }?.let(URI(current)::resolve)?.toString()
    }
    return entries
  }

  private fun get(url: String, apiKey: String): String {
    val connection = URI(url).toURL().openConnection() as HttpURLConnection
    try {
      connection.connectTimeout = TIMEOUT_MS
      connection.readTimeout = TIMEOUT_MS
      connection.setRequestProperty("Accept", "application/json")
      if (apiKey.isNotBlank()) connection.setRequestProperty("Authorization", "Bearer $apiKey")
      val status = connection.responseCode
      if (status !in HTTP_OK) {
        Log.w(TAG, "models listing failed: HTTP $status")
        throw Failure(if (status in HTTP_AUTH) FetchFailure.AUTH else FetchFailure.OTHER)
      }
      return connection.inputStream.bufferedReader().use { it.readText() }
    } finally {
      connection.disconnect()
    }
  }

  private fun failed(reason: FetchFailure, e: Exception): ModelsFetch {
    Log.w(TAG, "models listing failed: $reason (${e.javaClass.simpleName})")
    return ModelsFetch.Failed(reason)
  }

  internal fun parsePage(body: String): Page = json.decodeFromString(body)

  private class Failure(val reason: FetchFailure) : Exception()

  @Serializable internal data class Page(val data: List<Entry>? = null, val links: Links? = null)

  @Serializable
  internal data class Entry(
    val id: String? = null,
    val name: String? = null,
    val architecture: Architecture? = null,
  )

  @Serializable
  internal data class Architecture(
    @SerialName("output_modalities") val outputModalities: List<String>? = null
  )

  @Serializable internal data class Links(val next: String? = null)

  private companion object {
    const val TAG = "OpenRouterModels"
    const val PATH = "/models"
    const val TIMEOUT_MS = 15_000
    val HTTP_OK = 200..299
    val HTTP_AUTH = setOf(401, 403)
  }
}

/**
 * Text-capable entries (missing modalities count as text) with a non-blank id, first occurrence of
 * each id, sorted by name then id.
 */
internal fun toAvailable(entries: List<OpenRouterModelsClient.Entry>): List<AvailableModel> =
  entries
    .mapNotNull { entry ->
      val id = entry.id?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
      val outputs = entry.architecture?.outputModalities
      if (outputs != null && outputs.none { it.equals("text", ignoreCase = true) }) {
        return@mapNotNull null
      }
      AvailableModel(id, entry.name?.takeIf { it.isNotBlank() } ?: id)
    }
    .distinctBy { it.id }
    .sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER, AvailableModel::name).thenBy { it.id })
