package com.jayvijay.scottie.core.ai

import ai.koog.prompt.executor.clients.openrouter.OpenRouterModels
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLMProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class OpenRouterTextModelsTest {
  /** The Android Ktor AAR has no ServiceLoader registration, so discovery finds no factory. */
  @Test
  fun executorBuildsWithoutServiceLoaderDiscovery() {
    OpenRouterTextModels.executor("https://openrouter.ai", "k").close()
  }

  @Test
  fun knownIdUsesKoogDefinition() {
    val known = OpenRouterModels.models.first()
    assertSame(known, OpenRouterTextModels.llModel(known.id))
  }

  @Test
  fun unknownIdGetsToolCapableOpenRouterModel() {
    val model = OpenRouterTextModels.llModel("acme/unknown")
    assertEquals(LLMProvider.OpenRouter, model.provider)
    assertEquals("acme/unknown", model.id)
    assertTrue(LLMCapability.Tools in model.capabilities.orEmpty())
  }
}
