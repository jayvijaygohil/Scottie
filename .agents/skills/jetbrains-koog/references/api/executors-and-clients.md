# Prompt executors and provider clients

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.prompt.executor.clients.LLMClient.LLMClient

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client/-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients/androidMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/appleMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
expect constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/jsMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/wasmJsMain

```kotlin
actual constructor()
```

## ai.koog.prompt.executor.clients.LLMClient

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients/androidMain

```kotlin
actual abstract class LLMClient : LLMClientAPI, LLMEmbeddingProviderAPI
```

Common interface for direct communication with LLM providers. This interface defines methods for executing prompts and streaming responses.

Implements AutoCloseable as LLM clients typically work with IO resources. Always close it when finished.

### :prompt:prompt-executor:prompt-executor-clients/appleMain

```kotlin
actual abstract class LLMClient : LLMClientAPI, LLMEmbeddingProviderAPI
```

Common interface for direct communication with LLM providers. This interface defines methods for executing prompts and streaming responses.

Implements AutoCloseable as LLM clients typically work with IO resources. Always close it when finished.


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
expect abstract class LLMClient : LLMClientAPI, LLMEmbeddingProviderAPI
```

Common interface for direct communication with LLM providers. This interface defines methods for executing prompts and streaming responses.

Implements AutoCloseable as LLM clients typically work with IO resources. Always close it when finished.

- RetryingLLMClient
### :prompt:prompt-executor:prompt-executor-clients/jsMain

```kotlin
actual abstract class LLMClient : LLMClientAPI, LLMEmbeddingProviderAPI
```

Common interface for direct communication with LLM providers. This interface defines methods for executing prompts and streaming responses.

Implements AutoCloseable as LLM clients typically work with IO resources. Always close it when finished.


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
actual abstract class LLMClient : LLMClientAPI, LLMEmbeddingProvider
```

Common interface for direct communication with LLM providers. This interface defines methods for executing prompts and streaming responses.

Implements AutoCloseable as LLM clients typically work with IO resources. Always close it when finished.

### :prompt:prompt-executor:prompt-executor-clients/wasmJsMain

```kotlin
actual abstract class LLMClient : LLMClientAPI, LLMEmbeddingProviderAPI
```

Common interface for direct communication with LLM providers. This interface defines methods for executing prompts and streaming responses.

Implements AutoCloseable as LLM clients typically work with IO resources. Always close it when finished.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.LLMClientException.LLMClientException

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-exception/-l-l-m-client-exception.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(clientName: String, message: String? = null, cause: Throwable? = null)
```

## ai.koog.prompt.executor.clients.LLMClientException

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-exception/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
class LLMClientException(clientName: String, message: String? = null, cause: Throwable? = null) : Exception
```

Exception for Koog LLM clients

## ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl.Default

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-cache-control/-default/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
@Serializable data object Default : AnthropicCacheControl
```

Cache with the default TTL (no explicit TTL sent to Anthropic, caches for 5 minutes by default).

## ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl.OneHour

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-cache-control/-one-hour/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
@Serializable data object OneHour : AnthropicCacheControl
```

Cache for 1 hour.

## ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-cache-control/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
@Serializable sealed interface AnthropicCacheControl : CacheControl
```

Represents caching strategies specific to Anthropic's LLM provider.

- Default
- OneHour

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.AnthropicClientSettings

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/-anthropic-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
constructor(modelVersionsMap: Map<LLModel, String> = DEFAULT_ANTHROPIC_MODEL_VERSIONS_MAP, baseUrl: String = "https://api.anthropic.com", apiVersion: String = "2023-06-01", messagesPath: String = "v1/messages", modelsPath: String = "v1/models", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.apiVersion

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/api-version.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
val apiVersion: String
```

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.baseUrl

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/base-url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
val baseUrl: String
```

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
class AnthropicClientSettings(val modelVersionsMap: Map<LLModel, String> = DEFAULT_ANTHROPIC_MODEL_VERSIONS_MAP, val baseUrl: String = "https://api.anthropic.com", val apiVersion: String = "2023-06-01", val messagesPath: String = "v1/messages", val modelsPath: String = "v1/models", val timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```

Represents the settings for configuring an Anthropic client, including model mapping, base URL, and API version.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.messagesPath

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/messages-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
val messagesPath: String
```

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.modelVersionsMap

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/model-versions-map.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
val modelVersionsMap: Map<LLModel, String>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.modelsPath

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/models-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
val modelsPath: String
```

## ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings.timeoutConfig

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-client-settings/timeout-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
val timeoutConfig: ConnectionTimeoutConfig
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.AnthropicLLMClient

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/-anthropic-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
constructor(settings: AnthropicClientSettings = AnthropicClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System)
```

- settings — Configurable settings for the Anthropic client, which include the base URL and other options.
- httpClient — A preconfigured Koog HTTP client used for API calls. Must have authentication and other request defaults already embedded. To create a client with standard defaults, use the secondary constructor that accepts an API key and a KoogHttpClient.Factory.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
constructor(apiKey: String, settings: AnthropicClientSettings = AnthropicClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System)
```

Secondary constructor for creating an Anthropic client from an HTTP client factory.


Referenced packages: `ai.koog.http.client`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.clientName

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open override val clientName: String
```

Provides the specific Large Language Model (LLM) provider used by the client.

This method returns the LLM provider that the client is configured to use, allowing identification and configuration of provider-specific features.

The LLM provider associated with this client, specifically LLMProvider.Anthropic.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.close

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.embed

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embedding is not supported by the Anthropic API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding is not supported by the Anthropic API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.executeStreaming

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.execute

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.getBasicJsonSchemaGenerator

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(): AnthropicBasicJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.executor.clients.anthropic.structure`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.getStandardJsonSchemaGenerator

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(): AnthropicStandardJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.executor.clients.anthropic.structure`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open class AnthropicLLMClient constructor(settings: AnthropicClientSettings = AnthropicClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System) : LLMClient
```

A client implementation for interacting with Anthropic's API in a suspendable and direct manner.

This class supports functionalities for executing text prompts and streaming interactions with the Anthropic API. It leverages Kotlin Coroutines to handle asynchronous operations and provides full support for configuring HTTP requests, including timeout handling and JSON serialization.

- settings — Configurable settings for the Anthropic client, which include the base URL and other options.
- httpClient — A preconfigured Koog HTTP client used for API calls. Must have authentication and other request defaults already embedded. To create a client with standard defaults, use the secondary constructor that accepts an API key and a KoogHttpClient.Factory.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.llmProvider

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.models

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient.moderate

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderation is not supported by the Anthropic API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient

Module: `prompt-executor-anthropic-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-anthropic-client/ai.koog.prompt.executor.clients.anthropic/-anthropic-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-anthropic-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun AnthropicLLMClient(apiKey: String, settings: AnthropicClientSettings = AnthropicClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System): AnthropicLLMClient
```

JVM convenience for constructing AnthropicLLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.clients.bedrock.BedrockCacheControl.Default

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-cache-control/-default/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object Default : BedrockCacheControl
```

Cache with the default TTL (no explicit TTL sent to Bedrock).

## ai.koog.prompt.executor.clients.bedrock.BedrockCacheControl.FiveMinutes

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-cache-control/-five-minutes/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object FiveMinutes : BedrockCacheControl
```

Cache for 5 minutes.

## ai.koog.prompt.executor.clients.bedrock.BedrockCacheControl.OneHour

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-cache-control/-one-hour/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object OneHour : BedrockCacheControl
```

Cache for 1 hour.

## ai.koog.prompt.executor.clients.bedrock.BedrockCacheControl

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-cache-control/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable sealed interface BedrockCacheControl : CacheControl
```

Bedrock-specific cache control options. Bedrock supports only two TTL values: 5 minutes and 1 hour.

- Default
- FiveMinutes
- OneHour

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.BedrockClientSettings

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/-bedrock-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(region: String = BedrockRegions.US_WEST_2.regionCode, timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), endpointUrl: String? = null, apiMethod: BedrockAPIMethod = BedrockAPIMethod.InvokeModel, maxRetries: Int = 3, enableLogging: Boolean = false, moderationGuardrailsSettings: BedrockGuardrailsSettings? = null, fallbackModelFamily: BedrockModelFamilies? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.apiMethod

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/api-method.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val apiMethod: BedrockAPIMethod
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.enableLogging

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/enable-logging.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val enableLogging: Boolean
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.endpointUrl

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/endpoint-url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val endpointUrl: String?
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.fallbackModelFamily

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/fallback-model-family.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val fallbackModelFamily: BedrockModelFamilies?
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
class BedrockClientSettings(val region: String = BedrockRegions.US_WEST_2.regionCode, val timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), val endpointUrl: String? = null, val apiMethod: BedrockAPIMethod = BedrockAPIMethod.InvokeModel, val maxRetries: Int = 3, val enableLogging: Boolean = false, val moderationGuardrailsSettings: BedrockGuardrailsSettings? = null, val fallbackModelFamily: BedrockModelFamilies? = null)
```

Configuration settings for connecting to the AWS Bedrock API.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.maxRetries

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/max-retries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val maxRetries: Int
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.moderationGuardrailsSettings

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/moderation-guardrails-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val moderationGuardrailsSettings: BedrockGuardrailsSettings?
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.region

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/region.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val region: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings.timeoutConfig

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-client-settings/timeout-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val timeoutConfig: ConnectionTimeoutConfig
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.BedrockLLMClient

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/-bedrock-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(bedrockClient: BedrockRuntimeClient, apiMethod: BedrockAPIMethod = BedrockAPIMethod.InvokeModel, moderationGuardrailsSettings: BedrockGuardrailsSettings? = null, fallbackModelFamily: BedrockModelFamilies? = null, clock: KoogClock = KoogClock.System)
```

- bedrockClient — The runtime client for interacting with Bedrock, highly configurable
- apiMethod — The API method to use for interacting with Bedrock models that support messages, defaults to BedrockAPIMethod.InvokeModel.
- moderationGuardrailsSettings — Optional settings of the AWS bedrock Guardrails (see AWS documentation ) that would be used for the LLMClient.moderate request
- fallbackModelFamily — Optional fallback model family to use for unsupported models. If not provided, unsupported models will throw an exception.
- clock — A clock used for time-based operations

Referenced packages: `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(identityProvider: IdentityProvider, settings: BedrockClientSettings = BedrockClientSettings(), clock: KoogClock = KoogClock.System)
```

Creates a new Bedrock LLM client configured with the specified identity provider and settings.

A configured LLMClient instance for Bedrock

- identityProvider — Supplies authentication to AWS Bedrock, supporting both CredentialsProvider for AWS credentials and BearerTokenProvider for API key-based access.
- settings — Configuration settings for the Bedrock client, such as region and endpoint
- clock — A clock used for time-based operations

Referenced packages: `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.close

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.embed

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the AWS Bedrock InvokeModel API.

Supports Amazon Titan Embed (v1 and v2) and Cohere embedding model families.

A list of floating-point values representing the embedding vector.

- text — The text to embed.
- model — The model to use for embedding. Must have the LLMCapability.Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.
- LLMClientException — if the model family does not support embeddings.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding is not currently supported by the Bedrock client.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.executeStreaming

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.execute

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
class BedrockLLMClient constructor(bedrockClient: BedrockRuntimeClient, apiMethod: BedrockAPIMethod = BedrockAPIMethod.InvokeModel, moderationGuardrailsSettings: BedrockGuardrailsSettings? = null, fallbackModelFamily: BedrockModelFamilies? = null, clock: KoogClock = KoogClock.System) : LLMClient
```

Creates a new Bedrock LLM client configured with the specified AWS credentials and settings.

A configured LLMClient instance for Bedrock

- bedrockClient — The runtime client for interacting with Bedrock, highly configurable
- apiMethod — The API method to use for interacting with Bedrock models that support messages, defaults to BedrockAPIMethod.InvokeModel.
- moderationGuardrailsSettings — Optional settings of the AWS bedrock Guardrails (see AWS documentation ) that would be used for the LLMClient.moderate request
- fallbackModelFamily — Optional fallback model family to use for unsupported models. If not provided, unsupported models will throw an exception.
- clock — A clock used for time-based operations

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.llmProvider

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient.moderate

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates the provided prompt using AWS Bedrock Guardrails.

Unlike other LLM operations, moderation in Bedrock uses the Guardrails API which is model-independent. The guardrails are configured at the client level via moderationGuardrailsSettings and evaluate content based on those guardrail rules, not based on any specific model's capabilities.

This means:

The model parameter is not used in this implementation

Any Bedrock model can be passed, but it won't affect the moderation result

The moderation behavior is determined entirely by the guardrail configuration

The method evaluates both input (user messages) and output (assistant responses) against the configured guardrails and determines if either is harmful.

Requires moderationGuardrailsSettings to be configured when creating this BedrockLLMClient.

A ModerationResult indicating whether the content is harmful and a map of categorized moderation results based on the guardrail filters.

- prompt — The prompt containing messages to be evaluated for harmful content.
- model — The language model (unused in Bedrock - moderation is model-independent).
- AWS Bedrock Guardrails Documentation
- IllegalArgumentException — if moderation guardrails settings are not provided or if the prompt is empty.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeClientSettings.DashscopeClientSettings

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-client-settings/-dashscope-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
constructor(baseUrl: String = "https://dashscope-intl.aliyuncs.com/", chatCompletionsPath: String = "compatible-mode/v1/chat/completions", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeClientSettings

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
class DashscopeClientSettings(baseUrl: String = "https://dashscope-intl.aliyuncs.com/", chatCompletionsPath: String = "compatible-mode/v1/chat/completions", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig()) : OpenAIBaseSettings
```

Configuration settings for connecting to the DashScope API using OpenAI-compatible endpoints.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai.base`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient.DashscopeLLMClient

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client/-dashscope-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
constructor(settings: DashscopeClientSettings = DashscopeClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```

- settings — The base URL, chat completion path, and timeouts for the DashScope API, defaults to "https://dashscope-intl.aliyuncs.com/compatible-mode/v1" and 900s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
constructor(apiKey: String, settings: DashscopeClientSettings = DashscopeClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient.clientName

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
open override val clientName: String
```

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient.embed

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embedding is not supported by the DashScope API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding is not supported by the DashScope API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
class DashscopeLLMClient constructor(settings: DashscopeClientSettings = DashscopeClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()) : AbstractOpenAILLMClient<DashscopeChatCompletionResponse, DashscopeChatCompletionStreamResponse>
```

Implementation of AbstractOpenAILLMClient for DashScope API using OpenAI-compatible endpoints.

- settings — The base URL, chat completion path, and timeouts for the DashScope API, defaults to "https://dashscope-intl.aliyuncs.com/compatible-mode/v1" and 900s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.dashscope.models`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient.llmProvider

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient.moderate

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.dashscope.DashscopeLLMClient

Module: `prompt-executor-dashscope-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-dashscope-client/ai.koog.prompt.executor.clients.dashscope/-dashscope-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-dashscope-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun DashscopeLLMClient(apiKey: String, settings: DashscopeClientSettings = DashscopeClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System, toolsConverter: ERROR CLASS: Symbol not found for OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()): DashscopeLLMClient
```

JVM convenience for constructing DashscopeLLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekClientSettings.DeepSeekClientSettings

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-client-settings/-deep-seek-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
constructor(baseUrl: String = "https://api.deepseek.com", chatCompletionsPath: String = "chat/completions", modelsPath: String = "models", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekClientSettings

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
class DeepSeekClientSettings(baseUrl: String = "https://api.deepseek.com", chatCompletionsPath: String = "chat/completions", val modelsPath: String = "models", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig()) : OpenAIBaseSettings
```

Configuration settings for connecting to the DeepSeek API.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai.base`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekClientSettings.modelsPath

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-client-settings/models-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val modelsPath: String
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient.DeepSeekLLMClient

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/-deep-seek-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
constructor(settings: DeepSeekClientSettings = DeepSeekClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```

- settings — The base URL, chat completion path, and timeouts for the DeepSeek API, defaults to "https://api.deepseek.com" and 900s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
constructor(apiKey: String, settings: DeepSeekClientSettings = DeepSeekClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient.clientName

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val clientName: String
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient.embed

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embedding is not supported by the DeepSeek API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding is not supported by the DeepSeek API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
class DeepSeekLLMClient constructor(settings: DeepSeekClientSettings = DeepSeekClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()) : AbstractOpenAILLMClient<DeepSeekChatCompletionResponse, DeepSeekChatCompletionStreamResponse>
```

Implementation of LLMClient for DeepSeek API.

- settings — The base URL, chat completion path, and timeouts for the DeepSeek API, defaults to "https://api.deepseek.com" and 900s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.deepseek.models`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient.llmProvider

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Returns the specific implementation of the LLMProvider associated with this client.

In this case, it identifies the DeepSeek provider as the designated LLM provider for the client.

The LLMProvider instance representing DeepSeek.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient.models

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Fetches a list of available model identifiers from the DeepSeek service. https://api-docs.deepseek.com/api/list-models

A list of string identifiers representing the available models.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient.moderate

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun DeepSeekLLMClient(apiKey: String, settings: DeepSeekClientSettings = DeepSeekClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System, toolsConverter: ERROR CLASS: Symbol not found for OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()): DeepSeekLLMClient
```

JVM convenience for constructing DeepSeekLLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.GoogleClientSettings

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/-google-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
constructor(baseUrl: String = "https://generativelanguage.googleapis.com", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), defaultPath: String = "v1beta/models", generateContentMethod: String = "generateContent", streamGenerateContentMethod: String = "streamGenerateContent", embedContentMethod: String = "embedContent", batchEmbedContentsMethod: String = "batchEmbedContents", fallbackThoughtSignature: String = "context_engineering_is_the_way_to_go")
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.baseUrl

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/base-url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val baseUrl: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.batchEmbedContentsMethod

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/batch-embed-contents-method.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val batchEmbedContentsMethod: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.defaultPath

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/default-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val defaultPath: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.embedContentMethod

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/embed-content-method.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val embedContentMethod: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.fallbackThoughtSignature

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/fallback-thought-signature.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val fallbackThoughtSignature: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.generateContentMethod

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/generate-content-method.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val generateContentMethod: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
class GoogleClientSettings(val baseUrl: String = "https://generativelanguage.googleapis.com", val timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), val defaultPath: String = "v1beta/models", val generateContentMethod: String = "generateContent", val streamGenerateContentMethod: String = "streamGenerateContent", val embedContentMethod: String = "embedContent", val batchEmbedContentsMethod: String = "batchEmbedContents", val fallbackThoughtSignature: String = "context_engineering_is_the_way_to_go")
```

Configuration settings for the Google AI client.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.streamGenerateContentMethod

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/stream-generate-content-method.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val streamGenerateContentMethod: String
```

## ai.koog.prompt.executor.clients.google.GoogleClientSettings.timeoutConfig

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-client-settings/timeout-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
val timeoutConfig: ConnectionTimeoutConfig
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.GoogleLLMClient

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/-google-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
constructor(settings: GoogleClientSettings = GoogleClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System)
```

- settings — Custom client settings, defaults to standard API endpoint and timeouts
- httpClient — A preconfigured Koog HTTP client used for API calls. Must have authentication and other request defaults already embedded. To create a client with standard defaults, use the secondary constructor that accepts an API key and a KoogHttpClient.Factory.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
constructor(apiKey: String, settings: GoogleClientSettings = GoogleClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System)
```

Secondary constructor for creating a GoogleLLMClient backed by an HTTP client factory.

- apiKey — The API key for the Google AI API
- settings — Custom client settings, defaults to standard API endpoint and timeouts
- httpClientFactory — Factory used to create an HTTP client for making API requests.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.clientName

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open override val clientName: String
```

Provides the Large Language Model (LLM) provider associated with this client.

The LLM provider, which is Google for this implementation.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.close

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.embed

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the Google AI embeddings API.

A list of floating-point values representing the embedding vector.

- text — The text to embed.
- model — The model to use for embedding. Must have the LLMCapability.Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given inputs using the Google AI batch embeddings API.

A list of embedding vectors, one per input string.

- inputs — The list of texts to embed.
- model — The model to use for embedding. Must have the LLMCapability.Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.executeMultipleChoices

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.executeStreaming

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.execute

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.getBasicJsonSchemaGenerator

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(): GoogleBasicJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.executor.clients.google.structure`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.getStandardJsonSchemaGenerator

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(): GoogleStandardJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.executor.clients.google.structure`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open class GoogleLLMClient constructor(settings: GoogleClientSettings = GoogleClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System) : LLMClient
```

Implementation of LLMClient for Google's Gemini API.

This client supports both standard and streaming text generation with optional tool calling capabilities.

- settings — Custom client settings, defaults to standard API endpoint and timeouts
- httpClient — A preconfigured Koog HTTP client used for API calls. Must have authentication and other request defaults already embedded. To create a client with standard defaults, use the secondary constructor that accepts an API key and a KoogHttpClient.Factory.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.llmProvider

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.models

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Retrieves a list of available language models supported by the Google LLM client. https://ai.google.dev/api/models#method:-models.list

A list of strings, each representing a model identifier available for use.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient.moderate

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates the given prompt using the specified language model. This method is not supported by the Google API and will throw an exception when invoked.

This method does not return a result as moderation is not supported by the Google API.

- prompt — The prompt to be evaluated for moderation.
- model — The language model to use for moderation.
- UnsupportedOperationException — Always thrown since moderation is not supported.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.google.GoogleLLMClient

Module: `prompt-executor-google-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-google-client/ai.koog.prompt.executor.clients.google/-google-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-google-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun GoogleLLMClient(apiKey: String, settings: GoogleClientSettings = GoogleClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System): GoogleLLMClient
```

JVM convenience for constructing GoogleLLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.clients.litert.AndroidLocalLLMParams.AndroidLocalLLMParams

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-android-local-l-l-m-params/-android-local-l-l-m-params.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
constructor(temperature: Double?, topK: Int?, topP: Double?, seed: Int? = null)
```

Creates AndroidLocalLLMParams applying defaults for any null argument.

- temperature — Sampling temperature; defaults to DEFAULT_TEMPERATURE when null.
- topK — Top-K value; defaults to DEFAULT_TOP_K when null.
- topP — Nucleus-sampling threshold; defaults to DEFAULT_TOP_P when null.
- seed — Optional random seed for reproducible generation.
## ai.koog.prompt.executor.clients.litert.AndroidLocalLLMParams.exactTemperature

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-android-local-l-l-m-params/exact-temperature.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val exactTemperature: Double
```

## ai.koog.prompt.executor.clients.litert.AndroidLocalLLMParams

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-android-local-l-l-m-params/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
class AndroidLocalLLMParams : LLMParams
```

LLM sampling parameters for on-device Android inference via LiteRT.

Extends LLMParams with LiteRT-specific sampling controls and serializes topK and topP into LLMParams.additionalProperties so they are forwarded to the underlying engine.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.litert.AndroidLocalLLMParams.seed

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-android-local-l-l-m-params/seed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val seed: Int?
```

## ai.koog.prompt.executor.clients.litert.AndroidLocalLLMParams.topK

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-android-local-l-l-m-params/top-k.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val topK: Int
```

## ai.koog.prompt.executor.clients.litert.AndroidLocalLLMParams.topP

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-android-local-l-l-m-params/top-p.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val topP: Double
```

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig.LiteRTClientConfig

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/-lite-r-t-client-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
constructor(defaultModel: LLModel = LiteRTLLModels.FunctionGemma, modelsPath: String = "/data/local/tmp/llm", cacheDir: String? = null, backend: Backend = Backend.CPU(), clock: KoogClock = KoogClock.System)
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig.backend

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/backend.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val backend: Backend
```

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig.cacheDir

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/cache-dir.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val cacheDir: String?
```

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig.clock

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/clock.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig.defaultModel

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/default-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val defaultModel: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
data class LiteRTClientConfig(val defaultModel: LLModel = LiteRTLLModels.FunctionGemma, val modelsPath: String = "/data/local/tmp/llm", val cacheDir: String? = null, val backend: Backend = Backend.CPU(), val clock: KoogClock = KoogClock.System)
```

Configuration for LiteRTLLMClient.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.litert.LiteRTClientConfig.modelsPath

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-client-config/models-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val modelsPath: String
```

## ai.koog.prompt.executor.clients.litert.LiteRTLLMClient.LiteRTLLMClient

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-client/-lite-r-t-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
constructor(config: LiteRTClientConfig)
```

- config — Configuration specifying model paths, backend, and runtime options.
## ai.koog.prompt.executor.clients.litert.LiteRTLLMClient.close

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
open override fun close()
```

Closes the underlying LiteRTLLMSession and releases all LiteRT resources.

## ai.koog.prompt.executor.clients.litert.LiteRTLLMClient.execute

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```

Runs inference for prompt using model and returns the model's response messages.

Note: tools are currently not forwarded to the underlying LiteRT session.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLMClient

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
class LiteRTLLMClient(config: LiteRTClientConfig) : LLMClient
```

LLMClient implementation that runs inference on-device using the LiteRT runtime.

Delegates to an internal LiteRTLLMSession which manages the LiteRT Engine and Conversation lifecycle. Tools are forwarded to LiteRT as part of the Conversation configuration; tool execution itself is performed by the koog agent framework, not by LiteRT (automaticToolCalling = false).

- config — Configuration specifying model paths, backend, and runtime options.

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLMClient.llmProvider

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Returns LiteRTLLMProvider as the provider for all models served by this client.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLMClient.moderate

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Not supported — content moderation is unavailable for on-device models.

- UnsupportedOperationException — always.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLMProvider

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-m-provider/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
data object LiteRTLLMProvider : LLMProvider
```

LLM provider identifier for on-device Android inference via the LiteRT runtime.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLModels.FunctionGemma

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-models/-function-gemma.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val FunctionGemma: LLModel
```

A fine-tuned Gemma variant optimized for function-calling on device.

Model file: mobile_actions_q8_ekv1024.litertlm Source: https://huggingface.co/litert-community/functiongemma-270m-ft-mobile-actions


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLModels.Gemma4E2B

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-models/-gemma4-e2-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val Gemma4E2B: LLModel
```

https://huggingface.co/litert-community/gemma-4-E2B-it-litert-lm


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLModels.Gemma4E4B

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-models/-gemma4-e4-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
val Gemma4E4B: LLModel
```

https://huggingface.co/litert-community/gemma-4-E4B-it-litert-lm


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLModels.addCustomModel

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-models/add-custom-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
open override fun addCustomModel(model: LLModel)
```

Registers model as an additional on-device model available for inference.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLModels

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-models/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
object LiteRTLLModels : LLModelDefinitions
```

Catalog of LLModel definitions available for on-device Android inference via LiteRT.

Implements LLModelDefinitions so models registered here are discoverable by the koog executor infrastructure. Custom models can be added at runtime via addCustomModel.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.litert.LiteRTLLModels.models

Module: `prompt-executor-litert-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-litert-client/ai.koog.prompt.executor.clients.litert/-lite-r-t-l-l-models/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-litert-client/androidMain

```kotlin
open override val models: List<LLModel>
```

All available models, combining the built-in FunctionGemma with any custom models.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.mistralai.MistralAIClientSettings.MistralAIClientSettings

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-client-settings/-mistral-a-i-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
constructor(baseUrl: String = "https://api.mistral.ai", chatCompletionsPath: String = "v1/chat/completions", embeddingsPath: String = "v1/embeddings", moderationPath: String = "v1/moderations", modelsPath: String = "v1/models", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.mistralai.MistralAIClientSettings.embeddingsPath

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-client-settings/embeddings-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
val embeddingsPath: String
```

## ai.koog.prompt.executor.clients.mistralai.MistralAIClientSettings

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
class MistralAIClientSettings(baseUrl: String = "https://api.mistral.ai", chatCompletionsPath: String = "v1/chat/completions", val embeddingsPath: String = "v1/embeddings", val moderationPath: String = "v1/moderations", val modelsPath: String = "v1/models", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig()) : OpenAIBaseSettings
```

Represents the settings for configuring a Mistral AI client.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai.base`.

## ai.koog.prompt.executor.clients.mistralai.MistralAIClientSettings.modelsPath

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-client-settings/models-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
val modelsPath: String
```

## ai.koog.prompt.executor.clients.mistralai.MistralAIClientSettings.moderationPath

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-client-settings/moderation-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
val moderationPath: String
```

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient.MistralAILLMClient

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/-mistral-a-i-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
constructor(settings: MistralAIClientSettings = MistralAIClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```

- settings — The base URL, chat completion path, and timeouts for the Mistral AI
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
constructor(apiKey: String, settings: MistralAIClientSettings = MistralAIClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient.clientName

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open override val clientName: String
```

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient.embed

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the MistralAI embeddings API.

A list of floating-point values representing the embedding.

- text — The text to embed.
- model — The model to use for embedding. Must have the Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given inputs using the MistralAI embeddings API.

A list of embedding vectors, one per input string.

- inputs — The list of texts to embed.
- model — The model to use for embedding. Must have the LLMCapability.Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open class MistralAILLMClient constructor(settings: MistralAIClientSettings = MistralAIClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()) : AbstractOpenAILLMClient<MistralAIChatCompletionResponse, MistralAIChatCompletionStreamResponse>
```

Implementation of LLMClient for Mistral AI.

- settings — The base URL, chat completion path, and timeouts for the Mistral AI
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.mistralai.models`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient.llmProvider

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Returns the specific implementation of the LLMProvider associated with this client

In this case, it identifies the MistralAI provider as the designated LLM provider for the client.

the LLMProvider instance representing MistralAI


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient.models

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Fetches the list of available model IDs from the MistralAI service. https://docs.mistral.ai/api/endpoint/models

A list of model IDs as strings.

- Exception — if the HTTP request fails or the response cannot be processed.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient.moderate

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates text and image content based on the provided model's capabilities.

The moderation result, including flagged content, categories, scores, and associated metadata.

- prompt — The prompt containing text messages and optional attachments to be moderated.
- model — The language model to use for moderation. Must have the Moderation capability.
- IllegalArgumentException — If the specified model does not support moderation.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient

Module: `prompt-executor-mistralai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-mistralai-client/ai.koog.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-mistralai-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun MistralAILLMClient(apiKey: String, settings: MistralAIClientSettings = MistralAIClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System, toolsConverter: ERROR CLASS: Symbol not found for OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()): MistralAILLMClient
```

JVM convenience for constructing MistralAILLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.ollama.client.OllamaClient.Companion.DEFAULT_BASE_URL

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/-companion/-d-e-f-a-u-l-t_-b-a-s-e_-u-r-l.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
const val DEFAULT_BASE_URL: String
```

## ai.koog.prompt.executor.ollama.client.OllamaClient.Companion

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Companion
```

## ai.koog.prompt.executor.ollama.client.OllamaClient.OllamaClient

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/-ollama-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
constructor(httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, contextWindowStrategy: ContextWindowStrategy = ContextWindowStrategy.Companion.None, toolDescriptorConverter: ToolDescriptorSchemaGenerator = OllamaToolDescriptorSchemaGenerator())
```

- httpClient — A preconfigured Koog HTTP client used for API calls. Must have the Ollama base URL and timeouts already embedded. To create a client with standard defaults, use the secondary constructor that accepts a base URL and a KoogHttpClient.Factory.
- clock — Clock instance used for tracking response metadata timestamps.
- contextWindowStrategy — The ContextWindowStrategy to use for computing context window lengths. Defaults to ContextWindowStrategy.None.
- toolDescriptorConverter — Generates JSON schemas for tool descriptors sent to the model.

Referenced packages: `ai.koog.agents.core.tools.serialization`, `ai.koog.http.client`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
constructor(httpClientFactory: KoogHttpClient.Factory, baseUrl: String = DEFAULT_BASE_URL, headers: Map<String, String> = emptyMap(), queryParameters: Map<String, String> = emptyMap(), timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), clock: KoogClock = KoogClock.System, contextWindowStrategy: ContextWindowStrategy = ContextWindowStrategy.Companion.None, toolDescriptorConverter: ToolDescriptorSchemaGenerator = OllamaToolDescriptorSchemaGenerator())
```

Secondary constructor that builds the underlying KoogHttpClient from a KoogHttpClient.Factory.


Referenced packages: `ai.koog.agents.core.tools.serialization`, `ai.koog.http.client`, `ai.koog.prompt.executor.clients`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.ollama.client.OllamaClient.close

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.ollama.client.OllamaClient.embed

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the Ollama model.

A vector representation of the text.

- text — The text to embed.
- model — The model to use for embedding. Must have the Embed capability.
- LLMClientException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given inputs using the Ollama embeddings API.

A list of embedding vectors, one per input string.

- inputs — The list of texts to embed.
- model — The model to use for embedding. Must have the LLMCapability.Embed capability and belong to LLMProvider.Ollama.
- LLMClientException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaClient.executeStreaming

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.ollama.client.OllamaClient.execute

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.ollama.client.OllamaClient.getModelOrNull

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/get-model-or-null.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
suspend fun getModelOrNull(name: String, pullIfMissing: Boolean = false): OllamaModelCard?
```

Returns a model card by its model name, on null if no such model exists on the server.

- name — the name of the model to get the model card for
- pullIfMissing — true if you want to pull the model from the Ollama registry, false otherwise
## ai.koog.prompt.executor.ollama.client.OllamaClient.getModels

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/get-models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
suspend fun getModels(): List<OllamaModelCard>
```

Returns the model cards for all the available models on the server.

## ai.koog.prompt.executor.ollama.client.OllamaClient

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
class OllamaClient constructor(httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, contextWindowStrategy: ContextWindowStrategy = ContextWindowStrategy.Companion.None, toolDescriptorConverter: ToolDescriptorSchemaGenerator = OllamaToolDescriptorSchemaGenerator()) : LLMClient
```

Client for interacting with the Ollama API with comprehensive model support.

Implements:

LLMClient for executing prompts and streaming responses.

LLMEmbeddingProvider for generating embeddings from input text.

- httpClient — A preconfigured Koog HTTP client used for API calls. Must have the Ollama base URL and timeouts already embedded. To create a client with standard defaults, use the secondary constructor that accepts a base URL and a KoogHttpClient.Factory.
- clock — Clock instance used for tracking response metadata timestamps.
- contextWindowStrategy — The ContextWindowStrategy to use for computing context window lengths. Defaults to ContextWindowStrategy.None.
- toolDescriptorConverter — Generates JSON schemas for tool descriptors sent to the model.

Referenced packages: `ai.koog.agents.core.tools.serialization`, `ai.koog.http.client`, `ai.koog.prompt.executor.clients`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.ollama.client.OllamaClient.llmProvider

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Provides the type of Language Learning Model (LLM) provider used by the client.

The specific LLMProvider implementation, which is of type LLMProvider.Ollama.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaClient.moderate

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaClient

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun OllamaClient(baseUrl: String = OllamaClient.DEFAULT_BASE_URL, headers: Map<String, String> = emptyMap(), queryParameters: Map<String, String> = emptyMap(), timeoutConfig: ERROR CLASS: Symbol not found for ConnectionTimeoutConfig = ConnectionTimeoutConfig(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System, contextWindowStrategy: ContextWindowStrategy = ContextWindowStrategy.Companion.None, toolDescriptorConverter: ERROR CLASS: Symbol not found for ToolDescriptorSchemaGenerator = OllamaToolDescriptorSchemaGenerator()): OllamaClient
```

JVM convenience for constructing OllamaClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.clients.openai.OpenAIClientSettings.OpenAIClientSettings

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-client-settings/-open-a-i-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(baseUrl: String = "https://api.openai.com", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), chatCompletionsPath: String = "v1/chat/completions", responsesAPIPath: String = "v1/responses", embeddingsPath: String = "v1/embeddings", moderationsPath: String = "v1/moderations", modelsPath: String = "v1/models")
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.openai.OpenAIClientSettings.embeddingsPath

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-client-settings/embeddings-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val embeddingsPath: String
```

## ai.koog.prompt.executor.clients.openai.OpenAIClientSettings

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
class OpenAIClientSettings(baseUrl: String = "https://api.openai.com", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), chatCompletionsPath: String = "v1/chat/completions", val responsesAPIPath: String = "v1/responses", val embeddingsPath: String = "v1/embeddings", val moderationsPath: String = "v1/moderations", val modelsPath: String = "v1/models") : OpenAIBaseSettings
```

Represents the settings for configuring an OpenAI client.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai.base`.

## ai.koog.prompt.executor.clients.openai.OpenAIClientSettings.modelsPath

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-client-settings/models-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val modelsPath: String
```

## ai.koog.prompt.executor.clients.openai.OpenAIClientSettings.moderationsPath

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-client-settings/moderations-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val moderationsPath: String
```

## ai.koog.prompt.executor.clients.openai.OpenAIClientSettings.responsesAPIPath

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-client-settings/responses-a-p-i-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val responsesAPIPath: String
```

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.OpenAILLMClient

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/-open-a-i-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(settings: OpenAIClientSettings = OpenAIClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```

- settings — The base URL and timeouts for the OpenAI API, defaults to "https://api.openai.com" and 900 s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(apiKey: String, settings: OpenAIClientSettings = OpenAIClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.clientName

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val clientName: String
```

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.embed

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the OpenAI embeddings API.

A list of floating-point values representing the embedding.

- text — The text to embed.
- model — The model to use for embedding. Must have the Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding is not supported by the OpenAI API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.executeMultipleChoices

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): List<Message.Assistant>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.executeStreaming

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.execute

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open class OpenAILLMClient constructor(settings: OpenAIClientSettings = OpenAIClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()) : AbstractOpenAILLMClient<OpenAIChatCompletionResponse, OpenAIChatCompletionStreamResponse>
```

Implementation of LLMClient for OpenAI API.

- settings — The base URL and timeouts for the OpenAI API, defaults to "https://api.openai.com" and 900 s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.prompt.executor.clients.openai.models`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.llmProvider

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Returns the specific implementation of the LLMProvider associated with this client.

In this case, it identifies the OpenAI provider as the designated LLM provider for the client.

The LLMProvider instance representing OpenAI.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.models

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Retrieves the list of available models from OpenAI. https://platform.openai.com/docs/api-reference/models/list

A list of model identifiers available from OpenAI.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient.moderate

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates text and image content based on the provided model's capabilities.

The moderation result, including flagged content, categories, scores, and associated metadata.

- prompt — The prompt containing text messages and optional attachments to be moderated.
- model — The language model to use for moderation. Must have the Moderation capability.
- IllegalArgumentException — If the specified model does not support moderation.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAILLMClient

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun OpenAILLMClient(apiKey: String, settings: OpenAIClientSettings = OpenAIClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System, toolsConverter: ERROR CLASS: Symbol not found for OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()): OpenAILLMClient
```

JVM convenience for constructing OpenAILLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterClientSettings.OpenRouterClientSettings

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-client-settings/-open-router-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
constructor(baseUrl: String = "https://openrouter.ai", chatCompletionsPath: String = "api/v1/chat/completions", modelsPath: String = "api/v1/models", embeddingsPath: String = "api/v1/embeddings", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterClientSettings.embeddingsPath

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-client-settings/embeddings-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
val embeddingsPath: String
```

## ai.koog.prompt.executor.clients.openrouter.OpenRouterClientSettings

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-client-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
class OpenRouterClientSettings(baseUrl: String = "https://openrouter.ai", chatCompletionsPath: String = "api/v1/chat/completions", val modelsPath: String = "api/v1/models", val embeddingsPath: String = "api/v1/embeddings", timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig()) : OpenAIBaseSettings
```

Configuration settings for connecting to the OpenRouter API.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai.base`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterClientSettings.modelsPath

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-client-settings/models-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
val modelsPath: String
```

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient.OpenRouterLLMClient

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/-open-router-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
constructor(settings: OpenRouterClientSettings = OpenRouterClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```

- settings — The base URL and timeouts for the OpenRouter API, defaults to "https://openrouter.ai" and 900s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
constructor(apiKey: String, settings: OpenRouterClientSettings = OpenRouterClientSettings(), httpClientFactory: KoogHttpClient.Factory, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator())
```


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient.clientName

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
open override val clientName: String
```

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient.embed

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the OpenRouter embeddings API.

A list of floating-point values representing the embedding vector.

- text — The text to embed.
- model — The model to use for embedding. Must have the LLMCapability.Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding is not supported by the OpenRouter API.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
class OpenRouterLLMClient constructor(settings: OpenRouterClientSettings = OpenRouterClientSettings(), httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()) : AbstractOpenAILLMClient<OpenRouterChatCompletionResponse, OpenRouterChatCompletionStreamResponse>
```

Implementation of LLMClient for OpenRouter API. OpenRouter is an API that routes requests to multiple LLM providers.

- settings — The base URL and timeouts for the OpenRouter API, defaults to "https://openrouter.ai" and 900s
- httpClient — A fully configured KoogHttpClient for making API requests. Use the secondary constructor that accepts an API key and a KoogHttpClient.Factory to create a client with standard defaults.
- clock — Clock instance used for tracking response metadata timestamps.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.prompt.executor.clients.openrouter.models`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient.llmProvider

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Returns the specific implementation of the LLMProvider associated with this client.

In this case, it identifies the OpenRouter provider as the designated LLM provider for the client.

The LLMProvider instance representing OpenRouter.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient.models

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Fetches the list of available models from the OpenRouter service. https://openrouter.ai/docs/api/api-reference/models/get-models

A list of model IDs available from OpenRouter.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient.moderate

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient

Module: `prompt-executor-openrouter-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openrouter-client/ai.koog.prompt.executor.clients.openrouter/-open-router-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openrouter-client/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun OpenRouterLLMClient(apiKey: String, settings: OpenRouterClientSettings = OpenRouterClientSettings(), clock: ERROR CLASS: Symbol not found for KoogClock = KoogClock.System, toolsConverter: ERROR CLASS: Symbol not found for OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()): OpenRouterLLMClient
```

JVM convenience for constructing OpenRouterLLMClient without an explicit ai.koog.http.client.KoogHttpClient.Factory: the default factory is resolved at call time from HttpClientFactoryResolver.

Non-JVM targets must use the primary constructor and pass a factory explicitly.

## ai.koog.prompt.executor.llms.all.simpleAnthropicExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-anthropic-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleAnthropicExecutor(apiKey: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with an AnthropicLLMClient.

- apiKey — The API token used for authentication with the Anthropic LLM client.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleAnthropicExecutor(apiKey: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleAnthropicExecutor
## ai.koog.prompt.executor.llms.all.simpleAzureOpenAIExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-azure-open-a-i-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleAzureOpenAIExecutor(resourceName: String, deploymentName: String, version: AzureOpenAIServiceVersion, apiToken: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with an OpenAILLMClient configured for Azure OpenAI.

A new instance of MultiLLMPromptExecutor configured with the OpenAILLMClient for Azure OpenAI.

- resourceName — The name of the Azure OpenAI resource.
- deploymentName — The name of the deployment within the Azure OpenAI resource.
- version — The version of the Azure OpenAI Service to use.
- apiToken — The API token used for authentication with the Azure OpenAI service.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.azure`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleAzureOpenAIExecutor(baseUrl: String, version: AzureOpenAIServiceVersion, apiToken: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with an OpenAILLMClient configured for Azure OpenAI.

A new instance of MultiLLMPromptExecutor configured with the OpenAILLMClient for Azure OpenAI.

- baseUrl — The base URL for the Azure OpenAI service.
- version — The version of the Azure OpenAI Service to use.
- apiToken — The API token used for authentication with the Azure OpenAI service.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai.azure`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleAzureOpenAIExecutor(resourceName: String, deploymentName: String, version: ERROR CLASS: Symbol not found for AzureOpenAIServiceVersion, apiToken: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleAzureOpenAIExecutor(baseUrl: String, version: ERROR CLASS: Symbol not found for AzureOpenAIServiceVersion, apiToken: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleAzureOpenAIExecutor
## ai.koog.prompt.executor.llms.all.simpleBedrockExecutorWithBearerToken

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-bedrock-executor-with-bearer-token.html`

### :prompt:prompt-executor:prompt-executor-llms-all/jvmMain

```kotlin
fun simpleBedrockExecutorWithBearerToken(bedrockApiKey: String, settings: BedrockClientSettings = BedrockClientSettings()): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with a BedrockLLMClient. Uses the provided Bedrock API key to create a aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider.

See AWS documentation for more information about Bedrock API keys.

- bedrockApiKey — Your Bedrock API key (bearer token).
- settings — Custom client settings for region and timeouts.

Referenced packages: `ai.koog.prompt.executor.clients.bedrock`, `ai.koog.prompt.executor.llms`.

## ai.koog.prompt.executor.llms.all.simpleBedrockExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-bedrock-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/jvmMain

```kotlin
fun simpleBedrockExecutor(awsAccessKeyId: String, awsSecretAccessKey: String, awsSessionToken: String? = null, settings: BedrockClientSettings = BedrockClientSettings()): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with a BedrockLLMClient.

- awsAccessKeyId — Your AWS Access Key ID.
- awsSecretAccessKey — Your AWS Secret Access Key.
- awsSessionToken — Optional AWS session token for temporary security credentials (required if using temporary credentials, such as those from STS).
- settings — Custom client settings for region and timeouts.

Referenced packages: `ai.koog.prompt.executor.clients.bedrock`, `ai.koog.prompt.executor.llms`.

## ai.koog.prompt.executor.llms.all.simpleGoogleAIExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-google-a-i-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleGoogleAIExecutor(apiKey: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with an GoogleLLMClient.

- apiKey — The API token used for authentication with the Google AI service.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleGoogleAIExecutor(apiKey: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleGoogleAIExecutor
## ai.koog.prompt.executor.llms.all.simpleMistralAIExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-mistral-a-i-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleMistralAIExecutor(apiKey: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with a MistralAILLMClient.

- apiKey — The API token used for authentication with the Mistral AI provider.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleMistralAIExecutor(apiKey: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleMistralAIExecutor
## ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-ollama-a-i-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleOllamaAIExecutor(baseUrl: String = "http://localhost:11434", httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with an OllamaClient.

- baseUrl — url used to access Ollama server.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleOllamaAIExecutor(baseUrl: String = "http://localhost:11434"): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleOllamaAIExecutor
## ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-open-a-i-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleOpenAIExecutor(apiToken: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates a MultiLLMPromptExecutor instance configured to use the OpenAI client.

A new instance of MultiLLMPromptExecutor configured with the OpenAILLMClient.

- apiToken — The API token used for authentication with the OpenAI API.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleOpenAIExecutor(apiToken: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleOpenAIExecutor
## ai.koog.prompt.executor.llms.all.simpleOpenRouterExecutor

Module: `prompt-executor-llms-all`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-llms-all/ai.koog.prompt.executor.llms.all/simple-open-router-executor.html`

### :prompt:prompt-executor:prompt-executor-llms-all/commonMain

```kotlin
fun simpleOpenRouterExecutor(apiKey: String, httpClientFactory: KoogHttpClient.Factory): MultiLLMPromptExecutor
```

Creates an instance of MultiLLMPromptExecutor with an OpenRouterLLMClient.

- apiKey — The API token used for authentication with the OpenRouter API.
- httpClientFactory — Factory used to create the underlying HTTP client.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.llms`.

### :prompt:prompt-executor:prompt-executor-llms-all/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun simpleOpenRouterExecutor(apiKey: String): ERROR CLASS: Symbol not found for MultiLLMPromptExecutor
```

Convenience overload that constructs the underlying client via its JVM no-factory entry point (resolves the default ai.koog.http.client.KoogHttpClient.Factory at call time). JVM and Android only.

- simpleOpenRouterExecutor
## ai.koog.prompt.executor.llms.LLMClientRouter.clientFor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-l-l-m-client-router/client-for.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract fun clientFor(model: LLModel): LLMClient?
```

Selects a client to handle the given model.

A client capable of serving the model, or null if none available

- model — The model to route

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.LLMClientRouter.clients

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-l-l-m-client-router/clients.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract val clients: List<LLMClient>
```

All clients that this router can use


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.llms.LLMClientRouter

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-l-l-m-client-router/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
interface LLMClientRouter
```

Routes requests to available LLM clients.

Responsible for selecting which client should handle a request for a given model, based on factors like load distribution, availability, or health.

- RoundRobinRouter
## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.FallbackPromptExecutorSettings.FallbackPromptExecutorSettings

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/-fallback-prompt-executor-settings/-fallback-prompt-executor-settings.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(fallbackProvider: LLMProvider, fallbackModel: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.FallbackPromptExecutorSettings.fallbackModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/-fallback-prompt-executor-settings/fallback-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val fallbackModel: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.FallbackPromptExecutorSettings.fallbackProvider

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/-fallback-prompt-executor-settings/fallback-provider.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val fallbackProvider: LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.FallbackPromptExecutorSettings

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/-fallback-prompt-executor-settings/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
data class FallbackPromptExecutorSettings(val fallbackProvider: LLMProvider, val fallbackModel: LLModel)
```

Represents configuration for a fallback large language model (LLM) execution strategy.

This class is used to specify a fallback LLM provider and model that can be utilized when the primary LLM execution fails. It ensures that the fallback model is associated with the specified fallback provider.

- IllegalArgumentException — If the provider of the fallback model does not match the fallback provider.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.MultiLLMPromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/-multi-l-l-m-prompt-executor.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(llmClients: Map<LLMProvider, LLMClient>, fallback: MultiLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```

Constructs an executor instance with a map of LLM providers associated with their respective clients.

- llmClients — A map containing LLM providers associated with their respective LLMClients.
- fallback — Optional settings to configure the fallback mechanism in case a specific provider is not directly available.This class remains open for source and binary compatibility with existing subclasses. For new custom prompt executors, prefer extending ai.koog.prompt.executor.model.DynamicPromptExecutor. If you subclass this class, prefer overriding the ResolvedModel-based overloads. Override the LLModel-based overloads only when you intentionally take over the full model-resolution and execution flow.

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(vararg llmClients: Pair<LLMProvider, LLMClient>, fallback: MultiLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```

Initializes a new instance of the MultiLLMPromptExecutor class with multiple LLM clients.

Allows specifying a variable number of client-provider pairs, where each pair links a specific LLMProvider with a corresponding implementation of LLMClient. All provided pairs are internally converted into a map for efficient access and management of clients by their associated providers.

- llmClients — Variable number of pairs, where each pair consists of an LLMProvider representing the provider and a LLMClient for communication with that provider.

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(llmClients: List<LLMClient>, fallback: MultiLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```

Secondary constructor for MultiLLMPromptExecutor that accepts a list of LLMClient instances. The provided clients are processed to create a mapping of LLMProvider to their respective LLMClient.

- llmClients — Vararg parameter of LLMClient instances used to construct the executor.

Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(vararg llmClients: LLMClient)
```

Secondary constructor for MultiLLMPromptExecutor that accepts a variable number of LLMClient instances. The provided clients are processed to create a mapping of LLMProvider to their respective LLMClient.

- llmClients — Vararg parameter of LLMClient instances used to construct the executor.

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.close

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/close.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.executeMultipleChoices

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```

Executes a given prompt using the specified tools and model and returns a list of model choices.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor>): LLMChoice
```

Executes a given prompt using the specified tools and model and returns a list of model choices.

A list of LLMChoice objects containing the choices generated based on the prompt.

- prompt — The Prompt to be executed, containing the input messages and parameters.
- tools — A list of ToolDescriptor objects representing external tools available for use during execution.
- resolvedModel — The resolved LLM model to use for execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.executeStreaming

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Executes the given prompt with the specified model and streams the response in chunks as a flow.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Executes the given prompt with the specified model and streams the response in chunks as a flow.

- prompt — The prompt to execute, containing the messages and parameters.
- model — The resolved LLM model to use for execution.
- tools — A list of ToolDescriptor objects representing external tools available for use during execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.execute

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/execute.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a given prompt using the specified tools and model, and returns the assistant response.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a given prompt using the specified tools and resolved model, and returns the assistant response.

A Message.Assistant containing the response generated based on the prompt.

- prompt — The Prompt to be executed, containing the input messages and parameters.
- resolvedModel — The resolved LLM model to use for execution.
- tools — A list of ToolDescriptor objects representing external tools available for use during execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.getBasicJsonSchemaGenerator

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(model: LLModel): BasicJsonSchemaGenerator
```

Basic JSON schema generator required for the given model. Return BasicJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.getStandardJsonSchemaGenerator

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(model: LLModel): StandardJsonSchemaGenerator
```

Standard JSON schema generator required for the given model. Return StandardJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open class MultiLLMPromptExecutor constructor(llmClients: Map<LLMProvider, LLMClient>, fallback: MultiLLMPromptExecutor.FallbackPromptExecutorSettings? = null) : PromptExecutor
```

MultiLLMPromptExecutor is a class responsible for executing prompts across multiple Large Language Models (LLMs). This implementation supports direct execution with specific LLM clients or utilizes a fallback strategy if no primary LLM client is available for the requested provider.

- llmClients — A map containing LLM providers associated with their respective LLMClients.
- fallback — Optional settings to configure the fallback mechanism in case a specific provider is not directly available.This class remains open for source and binary compatibility with existing subclasses. For new custom prompt executors, prefer extending ai.koog.prompt.executor.model.DynamicPromptExecutor. If you subclass this class, prefer overriding the ResolvedModel-based overloads. Override the LLModel-based overloads only when you intentionally take over the full model-resolution and execution flow.

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.models

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/models.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Retrieves a list of available models from all LLM clients managed by this executor.

This method aggregates models from all configured LLM providers and clients, returning a comprehensive list of available language models that can be used with this executor.

A list of LLModel instances representing all available models.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.moderate

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/moderate.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates the provided multi-modal content using the specified model.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: ResolvedModel): ModerationResult
```

Moderates the provided multi-modal content using the specified resolved model.

A ModerationResult representing the result of the moderation process.

- prompt — The Prompt containing the content to be moderated.
- model — The resolved LLModel to use for moderation.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.executor.model`.

## ai.koog.prompt.executor.llms.MultiLLMPromptExecutor.resolveModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-multi-l-l-m-prompt-executor/resolve-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun resolveModel(model: LLModel, promptExecutorOperation: PromptExecutorOperation): ResolvedModel
```

Resolves the LLModel to use for the given promptExecutorOperation by selecting a known client for the model's provider, falling back to FallbackPromptExecutorSettings.fallbackModel when no direct client matches.

- ModelResolutionException — If no client is found for the model's provider and no fallback settings are configured.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoundRobinRouter.RoundRobinRouter

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-round-robin-router/-round-robin-router.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(clientsPerProvider: Map<LLMProvider, List<LLMClient>>)
```

- clientsPerProvider — Map of providers to their available clients

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(clients: List<LLMClient>)
```

Creates router from a flat list of clients, grouping by provider automatically.


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(vararg clients: LLMClient)
```

Creates router from vararg clients, grouping by provider automatically.


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(vararg llmClients: Pair<LLMProvider, LLMClient>)
```

Creates router from provider-client pairs, grouping by provider automatically.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoundRobinRouter.clientFor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-round-robin-router/client-for.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun clientFor(model: LLModel): LLMClient?
```

Selects a client to handle the given model.

A client capable of serving the model, or null if none available

- model — The model to route

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoundRobinRouter.clients

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-round-robin-router/clients.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override val clients: List<LLMClient>
```

All clients that this router can use


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.llms.RoundRobinRouter

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-round-robin-router/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
class RoundRobinRouter(clientsPerProvider: Map<LLMProvider, List<LLMClient>>) : LLMClientRouter
```

Distributes requests across clients in sequential rotation, ensuring even load distribution.

When multiple clients serve the same provider, cycles through them using an atomic counter. Thread-safe for concurrent access.

- clientsPerProvider — Map of providers to their available clients

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.FallbackPromptExecutorSettings.FallbackPromptExecutorSettings

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/-fallback-prompt-executor-settings/-fallback-prompt-executor-settings.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(fallbackModel: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.FallbackPromptExecutorSettings.fallbackModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/-fallback-prompt-executor-settings/fallback-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val fallbackModel: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.FallbackPromptExecutorSettings

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/-fallback-prompt-executor-settings/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
data class FallbackPromptExecutorSettings(val fallbackModel: LLModel)
```

Represents configuration for a fallback large language model (LLM) execution strategy.

This class is used to specify a fallback LLM model that can be utilized when the primary LLM execution fails. It ensures that the fallback model is associated with the specified fallback provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.RoutingLLMPromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/-routing-l-l-m-prompt-executor.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(clientRouter: LLMClientRouter, fallback: RoutingLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```

- clientRouter — Router responsible for selecting appropriate clients for each request
- fallback — Optional fallback configuration when no client is available for the requested modelThis class remains open for source and binary compatibility with existing subclasses. For new custom prompt executors, prefer extending ai.koog.prompt.executor.model.DynamicPromptExecutor. If you subclass this class, prefer overriding the ResolvedModel-based overloads. Override the LLModel-based overloads only when you intentionally take over the full model-resolution and execution flow.
### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(llmClients: Map<LLMProvider, List<LLMClient>>, fallback: RoutingLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```

Creates executor with a map of providers to their client lists. Uses RoundRobinRouter for load distribution.

- llmClients — Map of providers to lists of clients for each provider
- fallback — Optional fallback configuration

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(llmClients: List<LLMClient>, fallback: RoutingLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(vararg llmClients: LLMClient, fallback: RoutingLLMPromptExecutor.FallbackPromptExecutorSettings? = null)
```

Creates executor with a list of clients. Clients are grouped by provider and routed using RoundRobinRouter.

- llmClients — Vararg clients to use
- fallback — Optional fallback configuration

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.close

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/close.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.executeMultipleChoices

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```

Executes a given prompt using the specified tools and model and returns the model choices.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor>): LLMChoice
```

Executes a given prompt using the specified tools and resolved model and returns the model choices. Preferred extension point for subclasses that want to preserve this executor's model-resolution flow.

An LLMChoice containing the choices generated based on the prompt.

- prompt — The Prompt to be executed, containing the input messages and parameters.
- resolvedModel — The resolved LLM model to use for execution.
- tools — A list of ToolDescriptor objects representing external tools available for use during execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.executeStreaming

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Executes the given prompt with the specified model and streams the response in chunks as a flow.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Executes the given prompt with the specified resolved model and streams the response in chunks as a flow. Preferred extension point for subclasses that want to preserve this executor's model-resolution flow.

- prompt — The prompt to execute, containing the messages and parameters.
- model — The resolved LLM model to use for execution.
- tools — A list of ToolDescriptor objects representing external tools available for use during execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.execute

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/execute.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a given prompt using the specified tools and model, and returns the assistant response.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a given prompt using the specified tools and resolved model, and returns the assistant response. Preferred extension point for subclasses that want to preserve this executor's model-resolution flow.

A Message.Assistant containing the response generated based on the prompt.

- prompt — The Prompt to be executed, containing the input messages and parameters.
- resolvedModel — The resolved LLM model to use for execution.
- tools — A list of ToolDescriptor objects representing external tools available for use during execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open class RoutingLLMPromptExecutor constructor(clientRouter: LLMClientRouter, fallback: RoutingLLMPromptExecutor.FallbackPromptExecutorSettings? = null) : PromptExecutor
```

Executes prompts with load balancing across multiple LLM clients.

Delegates client selection to LLMClientRouter, which determines which client should handle each request based on the requested model. This enables load distribution strategies like round-robin, weighted routing, or health-based selection.

- clientRouter — Router responsible for selecting appropriate clients for each request
- fallback — Optional fallback configuration when no client is available for the requested modelThis class remains open for source and binary compatibility with existing subclasses. For new custom prompt executors, prefer extending ai.koog.prompt.executor.model.DynamicPromptExecutor. If you subclass this class, prefer overriding the ResolvedModel-based overloads. Override the LLModel-based overloads only when you intentionally take over the full model-resolution and execution flow.

Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.models

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/models.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Retrieves a list of available models from all LLM clients managed by this executor.

This method aggregates models from all configured LLM providers and clients, returning a comprehensive list of available language models that can be used with this executor.

A list of LLModel instances representing all available models.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.moderate

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/moderate.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates the provided multi-modal content using the specified model.

This legacy extension point is kept open for existing subclasses. New subclasses should prefer overriding the ResolvedModel-based overload. If this method is overridden without calling super, resolveModel is bypassed.


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: ResolvedModel): ModerationResult
```

Moderates the provided multi-modal content using the specified resolved model. Preferred extension point for subclasses that want to preserve this executor's model-resolution flow.

A ModerationResult representing the result of the moderation process.

- prompt — The Prompt containing the content to be moderated.
- model — The resolved LLModel to use for moderation.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.executor.model`.

## ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor.resolveModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-routing-l-l-m-prompt-executor/resolve-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend override fun resolveModel(model: LLModel, promptExecutorOperation: PromptExecutorOperation): ResolvedModel
```

Resolves the LLModel to use for the given promptExecutorOperation by checking whether the router has a client for the model's provider, falling back to FallbackPromptExecutorSettings.fallbackModel when no direct client matches.

- ModelResolutionException — If no client is found for the model's provider and no fallback is configured.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.DynamicPromptExecutor.DynamicPromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/-dynamic-prompt-executor.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.model.DynamicPromptExecutor.executeMultipleChoices

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract suspend override fun executeMultipleChoices(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor>): LLMChoice
```

Returns multiple independent choices from an already-resolved resolvedModel.

This is the actual extension point for subclasses; the LLModel overload of executeMultipleChoices is finalized and routes here after calling resolveModel.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```

Finalized to enforce that every call resolves through resolveModel before dispatch. Subclasses customize behavior by overriding the ResolvedModel-based executeMultipleChoices overload.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.model.DynamicPromptExecutor.executeStreaming

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract override fun executeStreaming(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Streams the response for prompt against an already-resolved resolvedModel.

This is the actual extension point for subclasses; the LLModel overload of executeStreaming is finalized and routes here after calling resolveModel.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.streaming`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Finalized to enforce that every call resolves through resolveModel before dispatch. Subclasses customize behavior by overriding the ResolvedModel-based executeStreaming overload.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.model.DynamicPromptExecutor.execute

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/execute.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract suspend override fun execute(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes prompt against an already-resolved resolvedModel.

This is the actual extension point for subclasses; the LLModel overload of execute is finalized and routes here after calling resolveModel.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Finalized to enforce that every call resolves through resolveModel before dispatch. Subclasses customize behavior by overriding the ResolvedModel-based execute overload.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.model.DynamicPromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract class DynamicPromptExecutor : PromptExecutor
```

A PromptExecutor that introduces an explicit resolveModel step before every LLM operation.

Prefer this base class for new custom prompt executors that need fallback, routing, model substitution, or any other model-resolution policy.

Subclasses use resolveModel to translate a caller-requested LLModel into a ResolvedModel — for example, to swap in a fallback model when the requested one is not directly available. Each PromptExecutor entry point taking a plain LLModel is finalized here and delegates to the matching ResolvedModel-based overload, so model resolution always happens exactly once per call and subclasses cannot bypass it.

Subclasses must implement resolveModel together with the ResolvedModel-based execute, executeStreaming, executeMultipleChoices, and moderate overloads.

Inside those overrides, do not delegate to the LLModel-based overloads. They are finalized to re-enter model resolution and will recurse.

## ai.koog.prompt.executor.model.DynamicPromptExecutor.moderate

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/moderate.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract suspend override fun moderate(prompt: Prompt, model: ResolvedModel): ModerationResult
```

Moderates prompt against an already-resolved model.

This is the actual extension point for subclasses; the LLModel overload of moderate is finalized and routes here after calling resolveModel.


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Finalized to enforce that every call resolves through resolveModel before dispatch. Subclasses customize behavior by overriding the ResolvedModel-based moderate overload.


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.DynamicPromptExecutor.resolveModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-dynamic-prompt-executor/resolve-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract suspend override fun resolveModel(model: LLModel, promptExecutorOperation: PromptExecutorOperation): ResolvedModel
```

Resolves model into the ResolvedModel to actually use for the given promptExecutorOperation.

This is the single hook for model-resolution policy (e.g. fallback selection). Every entry point of this executor flows through this method exactly once per call.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.ModelResolutionException.ModelResolutionException

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-model-resolution-exception/-model-resolution-exception.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(requestedModel: LLModel, detailedMsg: String? = null, cause: Throwable? = null)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.ModelResolutionException

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-model-resolution-exception/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
class ModelResolutionException(requestedModel: LLModel, detailedMsg: String? = null, cause: Throwable? = null) : Exception
```

Exception thrown when model resolution (PromptExecutorAPI.resolveModel) fails for a requested model.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.PromptExecutor.Companion.builder

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor/-companion/builder.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun builder(): PromptExecutorBuilder
```

Creates an PromptExecutorBuilder for constructing a PromptExecutor.

The concrete executor implementation is chosen automatically at build time based on the registered clients — see PromptExecutorBuilder.build for the selection heuristic.

A new PromptExecutorBuilder instance.

## ai.koog.prompt.executor.model.PromptExecutor.Companion

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
object Companion
```

Companion object for PromptExecutor.

## ai.koog.prompt.executor.model.PromptExecutor.PromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor/-prompt-executor.html`

### :prompt:prompt-executor:prompt-executor-model/androidMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-model/appleMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
expect constructor()
```

### :prompt:prompt-executor:prompt-executor-model/jsMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-model/wasmJsMain

```kotlin
actual constructor()
```

## ai.koog.prompt.executor.model.PromptExecutor

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor/index.html`

### :prompt:prompt-executor:prompt-executor-model/androidMain

```kotlin
actual abstract class PromptExecutor : PromptExecutorAPI
```

An interface representing an executor for processing LLM prompts. This defines methods for executing prompts against models with or without tool assistance, as well as for streaming responses.

Implements AutoCloseable as prompt executors typically work with LLM clients. Always close it when finished.

Note: a single PromptExecutor might embed multiple LLM clients for different LLM providers supporting different models.

### :prompt:prompt-executor:prompt-executor-model/appleMain

```kotlin
actual abstract class PromptExecutor : PromptExecutorAPI
```

An interface representing an executor for processing LLM prompts. This defines methods for executing prompts against models with or without tool assistance, as well as for streaming responses.

Implements AutoCloseable as prompt executors typically work with LLM clients. Always close it when finished.

Note: a single PromptExecutor might embed multiple LLM clients for different LLM providers supporting different models.


Referenced packages: `ai.koog.prompt.executor.model`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
expect abstract class PromptExecutor : PromptExecutorAPI
```

An interface representing an executor for processing LLM prompts. This defines methods for executing prompts against models with or without tool assistance, as well as for streaming responses.

Implements AutoCloseable as prompt executors typically work with LLM clients. Always close it when finished.

Note: a single PromptExecutor might embed multiple LLM clients for different LLM providers supporting different models.

- DynamicPromptExecutor
- MultiLLMPromptExecutor
- RoutingLLMPromptExecutor
### :prompt:prompt-executor:prompt-executor-model/jsMain

```kotlin
actual abstract class PromptExecutor : PromptExecutorAPI
```

An interface representing an executor for processing LLM prompts. This defines methods for executing prompts against models with or without tool assistance, as well as for streaming responses.

Implements AutoCloseable as prompt executors typically work with LLM clients. Always close it when finished.

Note: a single PromptExecutor might embed multiple LLM clients for different LLM providers supporting different models.


Referenced packages: `ai.koog.prompt.executor.model`.

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
actual abstract class PromptExecutor : PromptExecutorAPI
```

An interface representing an executor for processing LLM prompts. This defines methods for executing prompts against models with or without tool assistance, as well as for streaming responses.

Implements AutoCloseable as prompt executors typically work with LLM clients. Always close it when finished.

Note: a single PromptExecutor might embed multiple LLM clients for different LLM providers supporting different models.

### :prompt:prompt-executor:prompt-executor-model/wasmJsMain

```kotlin
actual abstract class PromptExecutor : PromptExecutorAPI
```

An interface representing an executor for processing LLM prompts. This defines methods for executing prompts against models with or without tool assistance, as well as for streaming responses.

Implements AutoCloseable as prompt executors typically work with LLM clients. Always close it when finished.

Note: a single PromptExecutor might embed multiple LLM clients for different LLM providers supporting different models.


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.executeMultipleChoices

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```

Receives multiple independent choices from the LLM. The method is implemented only for some specific providers which support multiple LLM choices.

A list of LLMChoice objects representing the responses generated by the LLM.

- prompt — The prompt containing input messages and parameters to guide the LLM execution.
- model — The LLM to be used for processing the prompt.
- tools — A list of ToolDescriptor objects that define the tools available for the execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend fun executeMultipleChoices(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor>): LLMChoice
```

Receives multiple independent choices from an already-resolved model.

An LLMChoice representing the responses generated by the LLM.

- prompt — The prompt containing input messages and parameters to guide the LLM execution.
- resolvedModel — The ResolvedModel returned by resolveModel.
- tools — A list of ToolDescriptor objects available during the execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.executeStreaming

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Executes a given prompt using the specified LLM and returns a stream of output as a flow of StreamFrame objects.

A flow emitting StreamFrame objects that represent the streaming output of the LLM.

- prompt — The prompt containing input messages and parameters to guide the LLM execution.
- model — The LLM to be used for processing the prompt.
- tools — An optional list of ToolDescriptor objects that define the tools available for the execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open fun executeStreaming(prompt: Prompt, resolvedModel: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Flow<StreamFrame>
```

Executes a given prompt against an already-resolved model and returns its response as a stream.

A flow emitting StreamFrame objects representing the streaming output of the LLM.

- prompt — The prompt containing input messages and parameters to guide the LLM execution.
- resolvedModel — The ResolvedModel returned by resolveModel.
- tools — An optional list of ToolDescriptor objects available during the execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.execute

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/execute.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract suspend fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a given prompt using the specified LLM and tools, returning a list of responses from the model.

A list of Message.Response objects representing the responses generated by the LLM.

- prompt — The Prompt object containing the messages to be used in the execution.
- model — The instance of LLModel that specifies the LLM to be used.
- tools — An optional list of ToolDescriptor objects that define the tools available for the execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend fun execute(prompt: Prompt, model: ResolvedModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a given prompt against an already-resolved model and returns the assistant response.

A Message.Assistant containing the response generated by the LLM.

- prompt — The Prompt containing the messages to be used in the execution.
- model — The ResolvedModel returned by resolveModel.
- tools — An optional list of ToolDescriptor objects available during the execution.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.getBasicJsonSchemaGenerator

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open fun getBasicJsonSchemaGenerator(model: LLModel): BasicJsonSchemaGenerator
```

Basic JSON schema generator required for the given model. Return BasicJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.getStandardJsonSchemaGenerator

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open fun getStandardJsonSchemaGenerator(model: LLModel): StandardJsonSchemaGenerator
```

Standard JSON schema generator required for the given model. Return StandardJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.model.PromptExecutorAPI

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
interface PromptExecutorAPI : AutoCloseable
```

API for PromptExecutor

- PromptExecutor
## ai.koog.prompt.executor.model.PromptExecutorAPI.models

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/models.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend fun models(): List<LLModel>
```

Retrieves a list of available models from all LLM clients managed by this executor.

This method aggregates models from all configured LLM providers and clients, returning a comprehensive list of available language models that can be used with this executor.

A list of LLModel instances representing all available models.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.moderate

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/moderate.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
abstract suspend fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Moderates the content of a given message with attachments using a specified LLM.

This method evaluates the content of the message and its attachments to determine if it complies with content guidelines. The moderation is performed using the provided LLM, which analyzes the content and returns a detailed moderation result.

A ModerationResult containing information about the moderation outcome, including flagged categories, scores, and whether the content is classified as harmful.

- model — The LLM that will be used to perform the moderation.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend fun moderate(prompt: Prompt, model: ResolvedModel): ModerationResult
```

Moderates the content of a prompt using an already-resolved model.

A ModerationResult describing the moderation outcome.

- prompt — The prompt whose content is to be moderated.
- model — The ResolvedModel returned by resolveModel.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`.

## ai.koog.prompt.executor.model.PromptExecutorAPI.resolveModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-a-p-i/resolve-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
open suspend fun resolveModel(model: LLModel, promptExecutorOperation: PromptExecutorOperation): ResolvedModel
```

Resolves the requested model to a ResolvedModel to actually use for the given promptExecutorOperation.

Implementations may swap the requested model for a different one (e.g. a fallback) based on availability. The default implementation returns the requested model unchanged.

A ResolvedModel wrapping the effective model to use.

- model — The requested LLModel to resolve.
- promptExecutorOperation — The operation the resolved model will be used for.
- ModelResolutionException — If the requested model cannot be resolved.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.PromptExecutorBuilder.PromptExecutorBuilder

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/-prompt-executor-builder.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.model.PromptExecutorBuilder.addClient

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/add-client.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun addClient(client: LLMClient): PromptExecutorBuilder
```

Registers an additional LLMClient.

Multiple clients for the same provider are allowed. When more than one client is registered for the same provider, build will create a RoutingLLMPromptExecutor that load-balances across them.

This builder instance for chaining.

- client — The LLM client to add.

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.model.PromptExecutorBuilder.anthropic

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/anthropic.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun anthropic(apiKey: String, settings: AnthropicClientSettings = AnthropicClientSettings(), httpClientFactory: KoogHttpClient.Factory = HttpClientFactoryResolver.resolve(), clock: KoogClock = KoogClock.System): PromptExecutorBuilder
```

Adds an Anthropic client. httpClientFactory defaults to HttpClientFactoryResolver.resolve.


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.anthropic`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.model.PromptExecutorBuilder.build

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/build.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun build(): PromptExecutor
```

Constructs a PromptExecutor from the registered clients.

The concrete implementation is chosen automatically:

MultiLLMPromptExecutor when each provider appears at most once.

RoutingLLMPromptExecutor when any provider has two or more clients (enables load balancing).

A configured PromptExecutor instance.

- IllegalArgumentException — if a fallback model was configured but its provider has no registered client.
## ai.koog.prompt.executor.model.PromptExecutorBuilder.fallback

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/fallback.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun fallback(model: LLModel): PromptExecutorBuilder
```

Configures a fallback model to use when no client is registered for the requested model's provider.

The fallback model's provider must already be registered via addClient; otherwise build will throw.

This builder instance for chaining.

- model — The model to use as a fallback.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.PromptExecutorBuilder

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/index.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
class PromptExecutorBuilder
```

Builder for constructing a PromptExecutor that automatically selects the appropriate executor implementation based on the registered clients.

Executor selection heuristic (determined at build time):

If every registered provider appears exactly once, a MultiLLMPromptExecutor is created. It dispatches each request to the single client registered for the requested model's provider.

If any provider has more than one client registered, a RoutingLLMPromptExecutor is created. It load-balances requests across all clients for the same provider.

Obtain an instance through PromptExecutor.builder.

- PromptExecutor.builder
- MultiLLMPromptExecutor
- RoutingLLMPromptExecutor
## ai.koog.prompt.executor.model.PromptExecutorBuilder.ollama

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/ollama.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun ollama(baseUrl: String = "http://localhost:11434", httpClientFactory: KoogHttpClient.Factory = HttpClientFactoryResolver.resolve(), timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig(), clock: KoogClock = KoogClock.System, contextWindowStrategy: ContextWindowStrategy = ContextWindowStrategy.Companion.None, toolDescriptorConverter: ToolDescriptorSchemaGenerator = OllamaToolDescriptorSchemaGenerator()): PromptExecutorBuilder
```

Adds an Ollama client. httpClientFactory defaults to HttpClientFactoryResolver.resolve.


Referenced packages: `ai.koog.agents.core.tools.serialization`, `ai.koog.http.client`, `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.ollama.client`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.model.PromptExecutorBuilder.openAI

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-builder/open-a-i.html`

### :prompt:prompt-executor:prompt-executor-model/jvmMain

```kotlin
fun openAI(apiKey: String, settings: OpenAIClientSettings = OpenAIClientSettings(), httpClientFactory: KoogHttpClient.Factory = HttpClientFactoryResolver.resolve(), clock: KoogClock = KoogClock.System, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator = OpenAICompatibleToolDescriptorSchemaGenerator()): PromptExecutorBuilder
```

Adds an OpenAI client. httpClientFactory defaults to HttpClientFactoryResolver.resolve.


Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients.openai`, `ai.koog.prompt.executor.clients.openai.base`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.model.PromptExecutorOperation.Execute

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/-execute/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
Execute
```

Represents PromptExecutorAPI.execute operation

## ai.koog.prompt.executor.model.PromptExecutorOperation.Moderate

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/-moderate/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
Moderate
```

Represents PromptExecutorAPI.moderate operation

## ai.koog.prompt.executor.model.PromptExecutorOperation.MultipleChoices

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/-multiple-choices/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
MultipleChoices
```

Represents PromptExecutorAPI.executeMultipleChoices operation

## ai.koog.prompt.executor.model.PromptExecutorOperation.Streaming

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/-streaming/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
Streaming
```

Represents PromptExecutorAPI.executeStreaming operation

## ai.koog.prompt.executor.model.PromptExecutorOperation

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
enum PromptExecutorOperation : Enum<PromptExecutorOperation>
```

Enum representing different operations that can be performed by the prompt executor.

## ai.koog.prompt.executor.model.ResolvedModel.ResolvedModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-resolved-model/-resolved-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(effectiveModel: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.ResolvedModel.effectiveModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-resolved-model/effective-model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val effectiveModel: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.ResolvedModel

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-resolved-model/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
data class ResolvedModel(val effectiveModel: LLModel)
```

Represents a resolved model for use by PromptExecutorAPI. Outcome of PromptExecutorAPI.resolveModel


Referenced packages: `ai.koog.prompt.llm`.
