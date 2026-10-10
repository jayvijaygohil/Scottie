package com.jayvijay.scottie.feature.modeldownload.domain.entities

import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField.BASE_URL
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField.MODELS
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OpenRouterConfigTest {
  private fun validate(baseUrl: String = URL, apiKey: String = "k", models: String = "a/b") =
    OpenRouterDraft(baseUrl, apiKey, models).validate()

  private fun valid(baseUrl: String = URL, apiKey: String = "k", models: String = "a/b") =
    (validate(baseUrl, apiKey, models) as OpenRouterValidation.Valid).config

  private fun invalidFields(baseUrl: String = URL, models: String = "a/b") =
    (validate(baseUrl = baseUrl, models = models) as OpenRouterValidation.Invalid).fields

  @Test
  fun modelsAreTrimmedSplitAndDeduplicated() {
    assertEquals(listOf("a/b", "c/d"), valid(models = "a/b ; c/d;").models)
    assertEquals(listOf("a/b"), valid(models = "a/b;a/b").models)
  }

  @Test
  fun blankModelListIsInvalid() {
    assertEquals(setOf(MODELS), invalidFields(models = "; ;"))
  }

  @Test
  fun baseUrlNeedsHttpSchemeAndHost() {
    listOf("", "openrouter.ai/api/v1", "ftp://x", "not a url").forEach {
      assertEquals(it, setOf(BASE_URL), invalidFields(baseUrl = it))
    }
    assertEquals("http://192.168.1.20:8080", valid(baseUrl = "http://192.168.1.20:8080").baseUrl)
    assertEquals(URL, valid(baseUrl = " $URL ").baseUrl)
  }

  @Test
  fun emptyKeyIsAllowed() {
    assertEquals("", valid(apiKey = " ").apiKey)
  }

  @Test
  fun everyFailingFieldIsReported() {
    assertEquals(setOf(BASE_URL, MODELS), invalidFields(baseUrl = "x", models = ""))
  }

  @Test
  fun toStringRedactsKey() {
    val text = OpenRouterConfig(URL, "sk-secret", listOf("a/b")).toString()
    assertFalse(text.contains("sk-secret"))
    assertTrue(text.contains("a/b"))
  }

  @Test
  fun modelIdsArePrefixed() {
    assertEquals(listOf("openrouter:a/b"), OpenRouterConfig(URL, "", listOf("a/b")).modelIds)
  }

  private companion object {
    const val URL = "https://openrouter.ai"
  }
}
