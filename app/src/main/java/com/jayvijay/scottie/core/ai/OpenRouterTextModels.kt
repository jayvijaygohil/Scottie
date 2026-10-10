package com.jayvijay.scottie.core.ai

import ai.koog.http.client.ktor.KtorKoogHttpClient
import ai.koog.prompt.executor.clients.openrouter.OpenRouterClientSettings
import ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient
import ai.koog.prompt.executor.clients.openrouter.OpenRouterModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.model.PromptExecutor
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLMProvider
import ai.koog.prompt.llm.LLModel

/** How Koog reaches an OpenRouter-compatible server and addresses its models. */
object OpenRouterTextModels {
  /** Koog appends `api/v1/...` itself, so a pasted `https://openrouter.ai/api/v1` is trimmed. */
  fun normalize(baseUrl: String): String =
    baseUrl.trim().removeSuffix("/").removeSuffix("/api/v1").removeSuffix("/")

  /** Koog model for an OpenRouter id; unknown ids get a generic tool-capable definition. */
  fun llModel(modelId: String): LLModel =
    OpenRouterModels.models.find { it.id == modelId }
      ?: LLModel(
        provider = LLMProvider.OpenRouter,
        id = modelId,
        capabilities =
          listOf(LLMCapability.Temperature, LLMCapability.Tools, LLMCapability.Completion),
        contextLength = CONTEXT_LENGTH,
        maxOutputTokens = MAX_OUTPUT_TOKENS,
      )

  /**
   * The HTTP factory is explicit: Koog's Android Ktor AAR lacks the ServiceLoader registration that
   * the `OpenRouterLLMClient(apiKey, settings)` overload relies on.
   */
  fun executor(baseUrl: String, apiKey: String): PromptExecutor =
    MultiLLMPromptExecutor(
      mapOf(
        LLMProvider.OpenRouter to
          OpenRouterLLMClient(
            apiKey = apiKey,
            settings = OpenRouterClientSettings(baseUrl = normalize(baseUrl)),
            httpClientFactory = KtorKoogHttpClient.Factory(),
          )
      )
    )

  private const val CONTEXT_LENGTH = 128_000L
  private const val MAX_OUTPUT_TOKENS = 4_096L
}
