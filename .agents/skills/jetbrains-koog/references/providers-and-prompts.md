# Providers and prompts

Read [provider/executor contracts](api/executors-and-clients.md) and [HTTP contracts](api/http-clients.md) for construction. Source guides are `prompts/http-clients.md`, `prompts/prompt-executors.md`, and `prompts/llm-clients.md`; use the [Kotlin documentation reader](documentation.md).

## HTTP factory selection

The provider-aware constructor accepts a `KoogHttpClient.Factory`, which receives provider-specific URLs, headers, timeouts, and streaming settings. The lower-level constructor accepts a preconfigured `KoogHttpClient`. An older Ktor `HttpClient` parameter is not interchangeable with either.

```kotlin
import ai.koog.http.client.ktor.KtorKoogHttpClient
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.model.PromptExecutor

fun createExecutor(apiKey: String): PromptExecutor {
    val client = OpenAILLMClient(
        apiKey = apiKey,
        httpClientFactory = KtorKoogHttpClient.Factory()
    )
    return MultiLLMPromptExecutor(client)
}
```

Explicit use of `KtorKoogHttpClient` requires a compile dependency on `ai.koog:http-client-ktor:1.3.0`. According to the guide, `prompt-executor-llms-all` brings that backend at runtime only. The caller owns and closes the returned executor according to its target lifecycle contract.

On JVM/Android, convenience constructors and `simple<Provider>Executor` resolve exactly one backend through `HttpClientFactoryResolver`. Zero or multiple factories cause `IllegalStateException`; fix dependencies or pass the factory explicitly. Common multiplatform code must use an explicit factory. The guide identifies Ktor as the non-JVM backend; OkHttp is an Android-friendly option, but its declarations are absent from this Dokka build.

## Routing and capabilities

`MultiLLMPromptExecutor` selects by provider. `RoutingLLMPromptExecutor` supports multiple client instances and routing policies, with `ExperimentalRoutingApi` opt-in. Read `FallbackPromptExecutorSettings`, `resolveModel`, and `ResolvedModel.effectiveModel` when enabling fallback. Do not assume an execution error will automatically trigger a retry or provider switch: fallback model resolution and transport retries are different mechanisms.

Match provider/model and check required capabilities: tools, structured schemas, images/audio, streaming, embeddings, or moderation. The supplied model lists are a snapshot. `LLModel` permits unknown capability and token-limit metadata; verify actual support when it matters. For model constants or provider-specific `LLMParams` outside the curated subset, use `lookup.py api` with the provider package/path.

LiteRT uses `prompt-executor-litert-client` in the beta version family. The bundled declarations are `androidMain`, use `LiteRTClientConfig`, `LiteRTLLMClient`, and `LiteRTLLModels`, and expose a cache directory as well as model path/backend. Do not place this client in common source sets.

## Retry, timeout, and repair

Read [retry contracts](api/retries.md) and the `prompts/handling-failures.md` guide. `RetryingLLMClient(delegate, config)` wraps a client. `RetryConfig` provides bounded attempts, backoff, jitter, error patterns, and a retry-after extractor. `maxAttempts = 1` disables retries. Set limits according to the operation and avoid multiplying retries around a provider SDK that already retries, such as Bedrock.

Streaming can fail after output has already reached the caller. The guide limits retries to failures before the first token; do not replay emitted content blindly or invent an enable-streaming constructor parameter. Preserve coroutine cancellation in application recovery handlers.

`ConnectionTimeoutConfig` distinguishes connection, whole-request, and socket timeouts. A larger retry budget does not extend the application's overall deadline automatically. For malformed tool arguments, inspect [response processing](api/response-processing.md): `ToolJsonFixProcessor`, `ManualToolCallFixProcessor`, and `LLMBasedToolCallFixProcessor`. Repair involving an LLM can add requests; it is separate from network retry and structured-output parsing.

## Two caching layers

| Need | Mechanism | Contract |
| --- | --- | --- |
| Reuse an entire previous response | `CachedPromptExecutor(cache, nested)` with in-memory, file, or Redis storage | [Executor caches](api/caching.md) |
| Reuse a prompt prefix at the provider | Provider cache-control values attached to request/message parts/tool descriptors | [Messages](api/prompts-and-messages.md); provider lookup |

The first is an application cache. The second still calls the provider and is provider/model-specific. Do not assume enabling one enables the other.

The `prompts/prompt-creation/cache-control.md` guide covers `AnthropicCacheControl.Default`/`OneHour`, request-level automatic caching, block-level boundaries, and Bedrock caching of system/message/tool content. Check the exact `cache` versus `cacheControl` parameter of the chosen DSL overload. There are similarly named wire DTOs in `.models`; use the public client cache-control type in application code. Preserve cache metadata when rewriting message parts, and inspect response usage metadata to evaluate caching.

## Prompt and stream shape

Build prompts with the Kotlin DSL, `MessagePart` values, and `LLMParams`. Use [Markdown/XML and messages](api/prompts-and-messages.md), [tokenization](api/tokenization.md), and [structured output](api/structured-output.md) as needed. Message identifiers, custom metadata, attachments, reasoning, and tool parts are not interchangeable with a single string. Read [state and testing](state-and-testing.md) for safe session/history updates and delta/complete frame handling.
