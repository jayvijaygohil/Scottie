package com.jayvijay.scottie.core.ai

import ai.koog.http.client.KoogHttpClient
import ai.koog.http.client.ktor.KtorKoogHttpClient
import ai.koog.prompt.executor.clients.openrouter.OpenRouterClientSettings
import ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient
import ai.koog.prompt.executor.clients.openrouter.OpenRouterModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.model.PromptExecutor
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLMProvider
import ai.koog.prompt.llm.LLModel
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

/** How Koog reaches an OpenRouter-compatible server and addresses its models. */
object OpenRouterTextModels {
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
   * [baseUrl] already carries the API version path (`https://openrouter.ai/api/v1`), so other
   * OpenAI-compatible servers (`https://routellm.abacus.ai/v1`) work; Koog adds only the endpoint.
   *
   * The HTTP factory is explicit: Koog's Android Ktor AAR lacks the ServiceLoader registration that
   * the `OpenRouterLLMClient(apiKey, settings)` overload relies on.
   */
  fun executor(
    baseUrl: String,
    apiKey: String,
    httpClientFactory: KoogHttpClient.Factory = KtorKoogHttpClient.Factory(),
  ): PromptExecutor =
    MultiLLMPromptExecutor(
      mapOf(
        LLMProvider.OpenRouter to
          OpenRouterLLMClient(
            apiKey = apiKey,
            settings =
              OpenRouterClientSettings(
                baseUrl = baseUrl,
                chatCompletionsPath = "chat/completions",
                modelsPath = "models",
              ),
            httpClientFactory = NormalizingHttpClientFactory(httpClientFactory),
          )
      )
    )

  /**
   * Some OpenAI-compatible gateways serialize tool `function.arguments` as a JSON object (`{}`)
   * rather than an escaped JSON string (`"{}"`), notably for zero-parameter tools. Koog's
   * `OpenAIFunction` requires a string token.
   */
  internal fun normalizeToolCallArguments(rawJson: String): String {
    val root =
      if ("\"arguments\"" in rawJson) {
        runCatching { Json.parseToJsonElement(rawJson) }.getOrNull()
      } else {
        null
      } ?: return rawJson

    var changed = false

    fun transform(element: JsonElement, parentKey: String? = null): JsonElement =
      when (element) {
        is JsonObject ->
          JsonObject(
            element.mapValues { (key, value) ->
              if (isNonStringFunctionArguments(parentKey, key, value)) {
                changed = true
                JsonPrimitive(if (value is JsonNull) "{}" else value.toString())
              } else {
                transform(value, key)
              }
            }
          )
        is JsonArray -> JsonArray(element.map { transform(it) })
        else -> element
      }

    val normalized = transform(root)
    return if (changed) Json.encodeToString(JsonElement.serializer(), normalized) else rawJson
  }

  private fun isNonStringFunctionArguments(
    parentKey: String?,
    key: String,
    value: JsonElement,
  ): Boolean = parentKey == "function" && key == "arguments" && !value.isStringPrimitive()

  private fun JsonElement.isStringPrimitive(): Boolean = this is JsonPrimitive && isString

  private class NormalizingHttpClientFactory(private val delegate: KoogHttpClient.Factory) :
    KoogHttpClient.Factory {
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
      NormalizingKoogHttpClient(
        delegate.create(
          clientName = clientName,
          baseUrl = baseUrl,
          headers = headers,
          queryParameters = queryParameters,
          requestTimeoutMillis = requestTimeoutMillis,
          connectTimeoutMillis = connectTimeoutMillis,
          socketTimeoutMillis = socketTimeoutMillis,
          json = json,
        )
      )
  }

  private class NormalizingKoogHttpClient(private val delegate: KoogHttpClient) :
    KoogHttpClient by delegate {
    override suspend fun <T : Any, R : Any> post(
      path: String,
      requestBody: T,
      requestBodyType: KClass<T>,
      responseType: KClass<R>,
      parameters: Map<String, String>,
      headers: Map<String, String>,
    ): R {
      val response =
        delegate.post(path, requestBody, requestBodyType, responseType, parameters, headers)
      @Suppress("UNCHECKED_CAST")
      return if (response is String) normalizeToolCallArguments(response) as R else response
    }

    override fun <T : Any, R : Any, O : Any> sse(
      path: String,
      requestBody: T,
      requestBodyType: KClass<T>,
      dataFilter: (String?) -> Boolean,
      decodeStreamingResponse: (String) -> R,
      processStreamingChunk: (R) -> O?,
      parameters: Map<String, String>,
      headers: Map<String, String>,
    ): Flow<O> =
      delegate.sse(
        path = path,
        requestBody = requestBody,
        requestBodyType = requestBodyType,
        dataFilter = dataFilter,
        decodeStreamingResponse = { raw ->
          decodeStreamingResponse(normalizeToolCallArguments(raw))
        },
        processStreamingChunk = processStreamingChunk,
        parameters = parameters,
        headers = headers,
      )
  }

  private const val CONTEXT_LENGTH = 128_000L
  private const val MAX_OUTPUT_TOKENS = 4_096L
}
