package com.jayvijay.scottie.core.ai

import ai.koog.http.client.KoogHttpClient
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openrouter.OpenRouterModels
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLMProvider
import ai.koog.prompt.message.MessagePart
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
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

  @Test
  fun normalizesObjectAndNullToolCallArguments() {
    val rawObject =
      """{"choices":[{"message":{"role":"assistant","tool_calls":[""" +
        """{"id":"c1","type":"function","function":{"name":"getAccountBalances",""" +
        """"arguments":{}}}]}}]}"""
    val normalizedObject = OpenRouterTextModels.normalizeToolCallArguments(rawObject)
    assertTrue("\"arguments\":\"{}\"" in normalizedObject)

    val rawNested =
      """{"choices":[{"message":{"role":"assistant","tool_calls":[""" +
        """{"id":"c2","type":"function","function":{"name":"findContacts",""" +
        """"arguments":{"query":"alice"}}}]}}]}"""
    val normalizedNested = OpenRouterTextModels.normalizeToolCallArguments(rawNested)
    assertTrue("\"arguments\":\"{\\\"query\\\":\\\"alice\\\"}\"" in normalizedNested)

    val rawString =
      """{"choices":[{"message":{"role":"assistant","tool_calls":[""" +
        """{"id":"c3","type":"function","function":{"name":"getAccountBalances",""" +
        """"arguments":"{}"}}]}}]}"""
    assertSame(rawString, OpenRouterTextModels.normalizeToolCallArguments(rawString))
  }

  @Test
  fun executorDecodesZeroArgToolCallWhenGatewayReturnsObjectArguments() = runTest {
    val gatewayPayload =
      """
      {
        "id": "gen-1",
        "created": 1700000000,
        "model": "route-llm",
        "choices": [
          {
            "index": 0,
            "message": {
              "role": "assistant",
              "tool_calls": [
                {
                  "id": "call_1",
                  "type": "function",
                  "function": {
                    "name": "getAccountBalances",
                    "arguments": {}
                  }
                }
              ]
            },
            "finish_reason": "tool_calls"
          }
        ]
      }
      """
        .trimIndent()

    val fakeFactory =
      object : KoogHttpClient.Factory {
        override fun create(
          clientName: String,
          baseUrl: String,
          headers: Map<String, String>,
          queryParameters: Map<String, String>,
          requestTimeoutMillis: Long,
          connectTimeoutMillis: Long,
          socketTimeoutMillis: Long,
          json: Json,
        ): KoogHttpClient =
          object : KoogHttpClient {
            override val clientName: String = clientName

            override suspend fun <R : Any> get(
              path: String,
              responseType: KClass<R>,
              parameters: Map<String, String>,
              headers: Map<String, String>,
            ): R = error("unused")

            @Suppress("UNCHECKED_CAST")
            override suspend fun <T : Any, R : Any> post(
              path: String,
              requestBody: T,
              requestBodyType: KClass<T>,
              responseType: KClass<R>,
              parameters: Map<String, String>,
              headers: Map<String, String>,
            ): R = gatewayPayload as R

            override fun <T : Any> lines(
              path: String,
              requestBody: T,
              requestBodyType: KClass<T>,
              parameters: Map<String, String>,
              headers: Map<String, String>,
            ): Flow<String> = emptyFlow()

            override fun <T : Any, R : Any, O : Any> sse(
              path: String,
              requestBody: T,
              requestBodyType: KClass<T>,
              dataFilter: (String?) -> Boolean,
              decodeStreamingResponse: (String) -> R,
              processStreamingChunk: (R) -> O?,
              parameters: Map<String, String>,
              headers: Map<String, String>,
            ): Flow<O> = emptyFlow()

            override fun close() = Unit
          }
      }

    val executor = OpenRouterTextModels.executor("https://routellm.abacus.ai/v1", "k", fakeFactory)
    val response =
      executor.execute(
        prompt = prompt("test") { user("What's my balance?") },
        model = OpenRouterTextModels.llModel("route-llm"),
      )
    executor.close()

    val call = response.parts.filterIsInstance<MessagePart.Tool.Call>().single()
    assertEquals("getAccountBalances", call.tool)
    assertEquals("{}", call.args)
  }
}
