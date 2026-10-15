package com.jayvijay.scottie.feature.modeldownload.domain.entities

import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField.BASE_URL
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OpenRouterConfigTest {
  private fun validate(baseUrl: String = URL, apiKey: String = "k", selection: List<String> = SEL) =
    OpenRouterDraft(baseUrl, apiKey, selection).validate()

  private fun valid(baseUrl: String = URL, apiKey: String = "k", selection: List<String> = SEL) =
    (validate(baseUrl, apiKey, selection) as OpenRouterValidation.Valid).config

  private fun invalidFields(baseUrl: String) =
    (validate(baseUrl = baseUrl) as OpenRouterValidation.Invalid).fields

  @Test
  fun validationChecksOnlyBaseUrlAndKeepsSelection() {
    assertEquals(OpenRouterConfig(URL, "k", SEL), valid())
    assertEquals(emptyList<String>(), valid(selection = emptyList()).models)
  }

  @Test
  fun baseUrlNeedsHttpSchemeAndHost() {
    listOf(
        "",
        "openrouter.ai/api/v1",
        "ftp://x",
        "not a url",
        "$URL?q=1",
        "$URL#x",
      )
      .forEach { assertEquals(it, setOf(BASE_URL), invalidFields(baseUrl = it)) }
    assertEquals("http://192.168.1.20:8080", valid(baseUrl = "http://192.168.1.20:8080").baseUrl)
    assertEquals(URL, valid(baseUrl = " $URL ").baseUrl)
    val routeLlm = "https://routellm.abacus.ai/v1"
    assertEquals(routeLlm, valid(baseUrl = routeLlm).baseUrl)
  }

  @Test
  fun emptyKeyIsAllowed() {
    assertEquals("", valid(apiKey = " ").apiKey)
  }

  @Test
  fun prunedToDropsUnlistedFollowsFetchedOrderAndTracksAudioModels() {
    val config = OpenRouterConfig(URL, "", listOf("c", "gone", "a"))
    val fetched =
      listOf(
        AvailableModel("a", "a", audioInput = true),
        AvailableModel("b", "b", audioInput = true),
        AvailableModel("c", "c", audioInput = false),
      )
    val pruned = config.prunedTo(fetched)
    assertEquals(listOf("a", "c"), pruned.models)
    assertEquals(listOf("a"), pruned.audioModels)
    assertEquals(listOf("openrouter:a"), pruned.audioModelIds)
    assertEquals(emptyList<String>(), config.prunedTo(emptyList()).models)
    assertEquals(emptyList<String>(), config.prunedTo(emptyList()).audioModels)
  }

  @Test
  fun toStringRedactsKey() {
    val text = OpenRouterConfig(URL, "sk-secret", listOf("a/b")).toString()
    assertFalse(text.contains("sk-secret"))
    assertTrue(text.contains("a/b"))
  }

  @Test
  fun modelIdsAndAudioModelIdsArePrefixed() {
    val cfg = OpenRouterConfig(URL, "", listOf("a/b", "c/d"), audioModels = listOf("c/d", "stale"))
    assertEquals(listOf("openrouter:a/b", "openrouter:c/d"), cfg.modelIds)
    assertEquals(listOf("openrouter:c/d"), cfg.audioModelIds)
  }

  private companion object {
    const val URL = OpenRouterConfig.DEFAULT_BASE_URL
    val SEL = listOf("a/b")
  }
}
