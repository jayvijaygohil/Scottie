# prompt / prompt-executor / prompt-executor-clients / prompt-executor-openai-client-base

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.AbstractOpenAILLMClient

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/-abstract-open-a-i-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(settings: OpenAIBaseSettings, httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, logger: KLogger, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator)
```

- settings — Configuration settings including base URL, API paths, and timeout configuration.
- httpClient — A fully configured KoogHttpClient for making API requests. Must have authentication and other request defaults (base URL, timeouts, headers) already embedded. To use a factory-backed client with standard OpenAI-compatible defaults, use the secondary constructor that accepts a KoogHttpClient.Factory and an API key.
- clock — KoogClock used for tracking response metadata timestamps. Defaults to KoogClock.System.

Referenced packages: `ai.koog.http.client`, `ai.koog.utils.time`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(apiKey: String, settings: OpenAIBaseSettings, httpClientFactory: KoogHttpClient.Factory, clientName: String, clock: KoogClock = KoogClock.System, logger: KLogger, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator)
```

Secondary constructor for creating a client backed by a KoogHttpClient.Factory. Configures authentication, base URL, timeouts, and JSON serialization automatically from apiKey and settings.


Referenced packages: `ai.koog.http.client`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.Companion.createConfiguredHttpClient

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/-companion/create-configured-http-client.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun createConfiguredHttpClient(apiKey: String, settings: OpenAIBaseSettings, httpClientFactory: KoogHttpClient.Factory, clientName: String): KoogHttpClient
```

Creates a configured HTTP client for OpenAI-compatible provider client constructors.


Referenced packages: `ai.koog.http.client`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.Companion

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
object Companion
```

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.close

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.executeMultipleChoices

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): List<Message.Assistant>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.executeStreaming

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.execute

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.getBasicJsonSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(): OpenAIBasicJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.structure`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient.getStandardJsonSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(): OpenAIStandardJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.structure`.

## ai.koog.prompt.executor.clients.openai.base.AbstractOpenAILLMClient

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-abstract-open-a-i-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract class AbstractOpenAILLMClient<TResponse : OpenAIBaseLLMResponse, TStreamResponse : OpenAIBaseLLMStreamResponse>(settings: OpenAIBaseSettings, httpClient: KoogHttpClient, clock: KoogClock = KoogClock.System, logger: KLogger, toolsConverter: OpenAICompatibleToolDescriptorSchemaGenerator) : LLMClient
```

Abstract base class for OpenAI-compatible LLM clients. Provides common functionality for communicating with OpenAI and OpenAI-compatible APIs.

- settings — Configuration settings including base URL, API paths, and timeout configuration.
- httpClient — A fully configured KoogHttpClient for making API requests. Must have authentication and other request defaults (base URL, timeouts, headers) already embedded. To use a factory-backed client with standard OpenAI-compatible defaults, use the secondary constructor that accepts a KoogHttpClient.Factory and an API key.
- clock — KoogClock used for tracking response metadata timestamps. Defaults to KoogClock.System.

Referenced packages: `ai.koog.http.client`, `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.clients.openai.base.OpenAIBaseSettings.OpenAIBaseSettings

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-base-settings/-open-a-i-base-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(baseUrl: String, chatCompletionsPath: String, timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.openai.base.OpenAIBaseSettings.baseUrl

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-base-settings/base-url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val baseUrl: String
```

## ai.koog.prompt.executor.clients.openai.base.OpenAIBaseSettings.chatCompletionsPath

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-base-settings/chat-completions-path.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val chatCompletionsPath: String
```

## ai.koog.prompt.executor.clients.openai.base.OpenAIBaseSettings

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-base-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract class OpenAIBaseSettings(val baseUrl: String, val chatCompletionsPath: String, val timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig())
```

Base settings class for OpenAI-based API clients.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.openai.base.OpenAIBaseSettings.timeoutConfig

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-base-settings/timeout-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val timeoutConfig: ConnectionTimeoutConfig
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.openai.base.OpenAICompatibleToolDescriptorSchemaGenerator.OpenAICompatibleToolDescriptorSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-compatible-tool-descriptor-schema-generator/-open-a-i-compatible-tool-descriptor-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.clients.openai.base.OpenAICompatibleToolDescriptorSchemaGenerator.generate

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-compatible-tool-descriptor-schema-generator/generate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun generate(toolDescriptor: ToolDescriptor): JsonObject
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.executor.clients.openai.base.OpenAICompatibleToolDescriptorSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base/-open-a-i-compatible-tool-descriptor-schema-generator/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open class OpenAICompatibleToolDescriptorSchemaGenerator : ToolDescriptorSchemaGenerator
```

Implementation of the ToolDescriptorSchemaGenerator for OpenAI tools.


Referenced packages: `ai.koog.agents.core.tools.serialization`.

## ai.koog.prompt.executor.clients.openai.base.models.CompletionTokensDetails.CompletionTokensDetails

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-completion-tokens-details/-completion-tokens-details.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(acceptedPredictionTokens: Int? = null, audioTokens: Int? = null, reasoningTokens: Int? = null, rejectedPredictionTokens: Int? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.CompletionTokensDetails.acceptedPredictionTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-completion-tokens-details/accepted-prediction-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val acceptedPredictionTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.CompletionTokensDetails.audioTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-completion-tokens-details/audio-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val audioTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.CompletionTokensDetails

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-completion-tokens-details/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class CompletionTokensDetails(val acceptedPredictionTokens: Int? = null, val audioTokens: Int? = null, val reasoningTokens: Int? = null, val rejectedPredictionTokens: Int? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.CompletionTokensDetails.reasoningTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-completion-tokens-details/reasoning-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val reasoningTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.CompletionTokensDetails.rejectedPredictionTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-completion-tokens-details/rejected-prediction-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val rejectedPredictionTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.Content.Parts.Parts

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-parts/-parts.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(value: List<OpenAIContentPart>)
```

## ai.koog.prompt.executor.clients.openai.base.models.Content.Parts

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-parts/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @JvmInline value class Parts(val value: List<OpenAIContentPart>) : Content
```

An array of content parts with a defined type. Supported options differ based on the model being used to generate the response. Can contain text, image or audio inputs.

## ai.koog.prompt.executor.clients.openai.base.models.Content.Parts.text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-parts/text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun text(): String
```

The simple text content of the message.

## ai.koog.prompt.executor.clients.openai.base.models.Content.Parts.value

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-parts/value.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val value: List<OpenAIContentPart>
```

## ai.koog.prompt.executor.clients.openai.base.models.Content.Text.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-text/-text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(value: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.Content.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-text/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @JvmInline value class Text(val value: String) : Content
```

The contents of the message.

## ai.koog.prompt.executor.clients.openai.base.models.Content.Text.text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-text/text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun text(): String
```

The simple text content of the message.

## ai.koog.prompt.executor.clients.openai.base.models.Content.Text.value

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/-text/value.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val value: String
```

## ai.koog.prompt.executor.clients.openai.base.models.Content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable(with = ContentSerializer::class) sealed interface Content
```

Represents the content of a message in the OpenAI chat completion API. Can be either a simple text message or a complex content consisting of multiple parts.

This sealed interface has two implementations:

Text - For simple text content

Parts - For complex content containing multiple parts (text, images, audio, files)

- Text
- Parts

Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.base.models.Content.text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-content/text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract fun text(): String
```

The simple text content of the message.

## ai.koog.prompt.executor.clients.openai.base.models.JsonSchemaObject.JsonSchemaObject

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-json-schema-object/-json-schema-object.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(name: String, description: String? = null, schema: JsonObject? = null, strict: Boolean? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.JsonSchemaObject.description

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-json-schema-object/description.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val description: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.JsonSchemaObject

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-json-schema-object/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class JsonSchemaObject(val name: String, val description: String? = null, val schema: JsonObject? = null, val strict: Boolean? = null)
```

Structured Outputs configuration options, including a JSON Schema.

## ai.koog.prompt.executor.clients.openai.base.models.JsonSchemaObject.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-json-schema-object/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.clients.openai.base.models.JsonSchemaObject.schema

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-json-schema-object/schema.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val schema: JsonObject?
```

## ai.koog.prompt.executor.clients.openai.base.models.JsonSchemaObject.strict

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-json-schema-object/strict.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val strict: Boolean?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudio.OpenAIAudio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio/-open-a-i-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(data: String? = null, expiresAt: Long? = null, id: String, transcript: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudio.data

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio/data.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val data: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudio.expiresAt

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio/expires-at.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val expiresAt: Long?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudio.id

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIAudio(val data: String? = null, val expiresAt: Long? = null, val id: String, val transcript: String? = null)
```

Data about a previous audio response from the model.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudio.transcript

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio/transcript.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val transcript: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioConfig.OpenAIAudioConfig

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-config/-open-a-i-audio-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(format: OpenAIAudioFormat, voice: OpenAIAudioVoice)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioConfig.format

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-config/format.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val format: OpenAIAudioFormat
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioConfig

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-config/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIAudioConfig(val format: OpenAIAudioFormat, val voice: OpenAIAudioVoice)
```

Parameters for audio output.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioConfig.voice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-config/voice.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val voice: OpenAIAudioVoice
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.FLAC

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/-f-l-a-c/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "flac") FLAC
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.MP3

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/-m-p3/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "mp3") MP3
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.OPUS

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/-o-p-u-s/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "opus") OPUS
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.PCM16

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/-p-c-m16/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "pcm16") PCM16
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.WAV

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/-w-a-v/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "wav") WAV
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.entries

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val entries: EnumEntries<OpenAIAudioFormat>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable enum OpenAIAudioFormat : Enum<OpenAIAudioFormat>
```

Represents the supported audio output formats.

This enum is used to specify the format of the audio output. It contains several standard audio formats which are widely compatible with various audio players and systems.

See audio/format

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.valueOf

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun valueOf(value: String): OpenAIAudioFormat
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioFormat.values

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-format/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun values(): Array<OpenAIAudioFormat>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Alloy

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-alloy/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "alloy") Alloy
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Ash

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-ash/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "ash") Ash
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Ballad

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-ballad/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "ballad") Ballad
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Coral

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-coral/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "coral") Coral
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Echo

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-echo/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "echo") Echo
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Fable

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-fable/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "fable") Fable
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Nova

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-nova/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "nova") Nova
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Onyx

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-onyx/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "onyx") Onyx
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Sage

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-sage/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "sage") Sage
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.Shimmer

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/-shimmer/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "shimmer") Shimmer
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.entries

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val entries: EnumEntries<OpenAIAudioVoice>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable enum OpenAIAudioVoice : Enum<OpenAIAudioVoice>
```

Represents the available voice options for audio output in OpenAI's system.

This enum defines a list of predefined voices that can be used to synthesize audio responses.

See audio/voice

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.valueOf

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun valueOf(value: String): OpenAIAudioVoice
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIAudioVoice.values

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-audio-voice/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun values(): Array<OpenAIAudioVoice>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMRequest

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-request/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
interface OpenAIBaseLLMRequest
```

Base interface for LLM OpenAI API requests. Contains properties that are common across all supported LLM providers.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMRequest.model

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-request/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val model: String?
```

The model to use for generating a response.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMRequest.stream

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-request/stream.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val stream: Boolean?
```

The stream output enabler.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMRequest.temperature

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-request/temperature.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val temperature: Double?
```

The temperature parameter for controlling randomness in the output.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMRequest.topLogprobs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-request/top-logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val topLogprobs: Int?
```

The number of alternatives per position.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMRequest.topP

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-request/top-p.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val topP: Double?
```

The top probability threshold.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMResponse.created

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-response/created.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val created: Long
```

The Unix timestamp (in seconds) of when the chat completion was created.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMResponse.id

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-response/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val id: String
```

The response id.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMResponse

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
interface OpenAIBaseLLMResponse
```

Base interface for all LLM OpenAI API responses. Contains properties that are common across different response types.

- OpenAIBaseLLMStreamResponse
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMResponse.model

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-response/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val model: String
```

The response model.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIBaseLLMStreamResponse

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-base-l-l-m-stream-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
interface OpenAIBaseLLMStreamResponse : OpenAIBaseLLMResponse
```

Represents a base interface for handling real-time streaming responses from OpenAI's LLM API. Provides a structure extending from the common attributes defined in OpenAIBaseLLMResponse. Used as a foundation for streaming response data models in OpenAI integrations.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoice.index

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice/--index--.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val index: Int
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoice.OpenAIChoice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice/-open-a-i-choice.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(finishReason: String, index: Int, logprobs: OpenAIChoiceLogProbs? = null, message: OpenAIMessage)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoice.finishReason

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice/finish-reason.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val finishReason: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIChoice(val finishReason: String, val index: Int, val logprobs: OpenAIChoiceLogProbs? = null, val message: OpenAIMessage)
```

Chat completion choice

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoice.logprobs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice/logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val logprobs: OpenAIChoiceLogProbs?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoice.message

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice/message.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val message: OpenAIMessage
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentLogProbs.ContentLogProbs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-log-probs/-content-log-probs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(bytes: List<Int>? = null, logprob: Double, token: String, topLogprobs: List<OpenAIChoiceLogProbs.ContentTopLogProbs>)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentLogProbs.bytes

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-log-probs/bytes.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val bytes: List<Int>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentLogProbs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-log-probs/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class ContentLogProbs(val bytes: List<Int>? = null, val logprob: Double, val token: String, val topLogprobs: List<OpenAIChoiceLogProbs.ContentTopLogProbs>)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentLogProbs.logprob

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-log-probs/logprob.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val logprob: Double
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentLogProbs.token

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-log-probs/token.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val token: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentLogProbs.topLogprobs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-log-probs/top-logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val topLogprobs: List<OpenAIChoiceLogProbs.ContentTopLogProbs>
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentTopLogProbs.ContentTopLogProbs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-top-log-probs/-content-top-log-probs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(bytes: List<Int>? = null, logprob: Double, token: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentTopLogProbs.bytes

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-top-log-probs/bytes.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val bytes: List<Int>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentTopLogProbs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-top-log-probs/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class ContentTopLogProbs(val bytes: List<Int>? = null, val logprob: Double, val token: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentTopLogProbs.logprob

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-top-log-probs/logprob.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val logprob: Double
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.ContentTopLogProbs.token

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-content-top-log-probs/token.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val token: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.OpenAIChoiceLogProbs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/-open-a-i-choice-log-probs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: List<OpenAIChoiceLogProbs.ContentLogProbs>? = null, refusal: List<OpenAIChoiceLogProbs.ContentLogProbs>? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val content: List<OpenAIChoiceLogProbs.ContentLogProbs>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIChoiceLogProbs(val content: List<OpenAIChoiceLogProbs.ContentLogProbs>? = null, val refusal: List<OpenAIChoiceLogProbs.ContentLogProbs>? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIChoiceLogProbs.refusal

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-choice-log-probs/refusal.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val refusal: List<OpenAIChoiceLogProbs.ContentLogProbs>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Audio.Audio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-audio/-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(inputAudio: OpenAIContentPart.InputAudio)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Audio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-audio/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "input_audio") class Audio(val inputAudio: OpenAIContentPart.InputAudio) : OpenAIContentPart
```

Audio content part in the OpenAI chat completion API.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Audio.inputAudio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-audio/input-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val inputAudio: OpenAIContentPart.InputAudio
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.File.File

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file/-file.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(file: OpenAIContentPart.FileData)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.File.file

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file/file.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val file: OpenAIContentPart.FileData
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.File

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "file") class File(val file: OpenAIContentPart.FileData) : OpenAIContentPart
```

File content part in the OpenAI chat completion API.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.FileData.FileData

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file-data/-file-data.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(fileData: String? = null, fileId: String? = null, filename: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.FileData.fileData

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file-data/file-data.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val fileData: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.FileData.fileId

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file-data/file-id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val fileId: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.FileData.filename

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file-data/filename.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val filename: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.FileData

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-file-data/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class FileData(val fileData: String? = null, val fileId: String? = null, val filename: String? = null)
```

File data containing optional file content, ID and filename information. Used to pass file data to OpenAI APIs requiring file handling capabilities.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Image.Image

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image/-image.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(imageUrl: OpenAIContentPart.ImageUrl)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Image.imageUrl

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image/image-url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val imageUrl: OpenAIContentPart.ImageUrl
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Image

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "image_url") class Image(val imageUrl: OpenAIContentPart.ImageUrl) : OpenAIContentPart
```

Image content part in the OpenAI chat completion API.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.ImageUrl.ImageUrl

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image-url/-image-url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(url: String, detail: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.ImageUrl.detail

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image-url/detail.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val detail: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.ImageUrl

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image-url/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class ImageUrl(val url: String, val detail: String? = null)
```

An image URL configuration for image content in the OpenAI chat completion API.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.ImageUrl.url

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-image-url/url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val url: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.InputAudio.InputAudio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-input-audio/-input-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(data: String, format: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.InputAudio.data

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-input-audio/data.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val data: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.InputAudio.format

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-input-audio/format.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val format: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.InputAudio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-input-audio/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class InputAudio(val data: String, val format: String)
```

Represents the audio data and format configuration for audio content in the OpenAI chat completion API.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Text.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-text/-text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(text: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-text/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "text") class Text(val text: String) : OpenAIContentPart
```

Text content part in the OpenAI chat completion API.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart.Text.text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/-text/text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val text: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIContentPart

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-content-part/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable sealed interface OpenAIContentPart
```

Represents a content part that can be used within OpenAI chat completion APIs. This is a sealed interface that defines various types of content components, like text, images, audio, and files, enabling diverse inputs and outputs in the API.

- Text
- Image
- Audio
- File
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIFunction.OpenAIFunction

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-function/-open-a-i-function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(name: String, arguments: String = "")
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIFunction.arguments

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-function/arguments.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val arguments: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIFunction

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-function/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIFunction(val name: String, val arguments: String = "")
```

Function call from an OpenAI model, containing the function name and arguments.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIFunction.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-function/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.Assistant

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/-assistant.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: Content? = null, reasoningContent: String? = null, audio: OpenAIAudio? = null, name: String? = null, refusal: String? = null, toolCalls: List<OpenAIToolCall>? = null, annotations: List<OpenAIWebUrlCitation>? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.annotations

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/annotations.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val annotations: List<OpenAIWebUrlCitation>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.audio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val audio: OpenAIAudio?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override val content: Content?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "assistant") class Assistant(val content: Content? = null, val reasoningContent: String? = null, val audio: OpenAIAudio? = null, val name: String? = null, val refusal: String? = null, val toolCalls: List<OpenAIToolCall>? = null, val annotations: List<OpenAIWebUrlCitation>? = null) : OpenAIMessage
```

Messages sent by the model in response to user messages.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.reasoningContent

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/reasoning-content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val reasoningContent: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.refusal

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/refusal.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val refusal: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Assistant.toolCalls

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-assistant/tool-calls.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val toolCalls: List<OpenAIToolCall>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Developer.Developer

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-developer/-developer.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: Content, name: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Developer.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-developer/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override val content: Content
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Developer

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-developer/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "developer") class Developer(val content: Content, val name: String? = null) : OpenAIMessage
```

Developer-provided instructions that the model should follow, regardless of messages sent by the user. With o1 models and newer, developer messages replace the previous system messages.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Developer.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-developer/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.System.System

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-system/-system.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: Content, name: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.System.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-system/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override val content: Content
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.System

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-system/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "system") class System(val content: Content, val name: String? = null) : OpenAIMessage
```

Developer-provided instructions that the model should follow, regardless of messages sent by the user. With o1 models and newer, use developer messages for this purpose instead.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.System.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-system/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Tool.Tool

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-tool/-tool.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: Content, toolCallId: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Tool.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-tool/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override val content: Content
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Tool

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-tool/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "tool") class Tool(val content: Content, val toolCallId: String) : OpenAIMessage
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.Tool.toolCallId

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-tool/tool-call-id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val toolCallId: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.User.User

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-user/-user.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: Content, name: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.User.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-user/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override val content: Content
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.User

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-user/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "user") class User(val content: Content, val name: String? = null) : OpenAIMessage
```

Messages sent by an end user, containing prompts or additional context information.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.User.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/-user/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
abstract val content: Content?
```

The content of the message.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIMessage

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-message/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable sealed interface OpenAIMessage
```

Represents a message in the OpenAI chat completion API.

Each message type has specific roles and capabilities:

Developer

System

User

Assistant

Tool

- Developer
- System
- User
- Assistant
- Tool
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIModalities.Audio

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-modalities/-audio/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "audio") Audio
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIModalities.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-modalities/-text/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "text") Text
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIModalities.entries

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-modalities/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val entries: EnumEntries<OpenAIModalities>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIModalities

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-modalities/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable enum OpenAIModalities : Enum<OpenAIModalities>
```

Specifies the supported modalities for OpenAI API operations.

This enumeration lists the types of content that can be processed by certain OpenAI API requests.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIModalities.valueOf

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-modalities/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun valueOf(value: String): OpenAIModalities
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIModalities.values

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-modalities/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun values(): Array<OpenAIModalities>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.JsonObject.JsonObject

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-json-object/-json-object.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.JsonObject

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-json-object/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "json_object") class JsonObject : OpenAIResponseFormat
```

JSON object response format. An older method of generating JSON responses. Using json_schema is recommended for models that support it. Note that the model will not generate JSON without a system or user message instructing it to do so.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.JsonSchema.JsonSchema

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-json-schema/-json-schema.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(jsonSchema: JsonSchemaObject)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.JsonSchema

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-json-schema/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "json_schema") class JsonSchema(val jsonSchema: JsonSchemaObject) : OpenAIResponseFormat
```

JSON Schema response format. Used to generate structured JSON responses.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.JsonSchema.jsonSchema

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-json-schema/json-schema.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val jsonSchema: JsonSchemaObject
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.Text.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-text/-text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat.Text

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/-text/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable @SerialName(value = "text") class Text : OpenAIResponseFormat
```

Default response format. Used to generate text responses.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIResponseFormat

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-response-format/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable sealed interface OpenAIResponseFormat
```

Expected response format from OpenAI's chat completion API. This interface defines different types of response formats that can be requested:

Text - Response in plain text format

JsonSchema - Response conforming to a specified JSON schema

JsonObject - Response as a JSON object

- Text
- JsonSchema
- JsonObject
## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStaticContent.OpenAIStaticContent

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-static-content/-open-a-i-static-content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: Content)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStaticContent.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-static-content/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val content: Content
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStaticContent

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-static-content/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIStaticContent(val content: Content)
```

Static predicted output content, such as the content of a text file that is being regenerated.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStaticContent.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-static-content/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String
```

The type of the predicted content you want to provide. This type is currently always content.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamChoice.index

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-choice/--index--.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val index: Int
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamChoice.OpenAIStreamChoice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-choice/-open-a-i-stream-choice.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(delta: OpenAIStreamDelta, finishReason: String? = null, index: Int, logprobs: OpenAIChoiceLogProbs? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamChoice.delta

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-choice/delta.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val delta: OpenAIStreamDelta
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamChoice.finishReason

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-choice/finish-reason.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val finishReason: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamChoice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-choice/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIStreamChoice(val delta: OpenAIStreamDelta, val finishReason: String? = null, val index: Int, val logprobs: OpenAIChoiceLogProbs? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamChoice.logprobs

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-choice/logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val logprobs: OpenAIChoiceLogProbs?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta.OpenAIStreamDelta

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/-open-a-i-stream-delta.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(content: String? = null, refusal: String? = null, role: String? = null, toolCalls: List<OpenAIStreamToolCall>? = null, reasoningContent: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta.content

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val content: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIStreamDelta(val content: String? = null, val refusal: String? = null, val role: String? = null, val toolCalls: List<OpenAIStreamToolCall>? = null, val reasoningContent: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta.reasoningContent

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/reasoning-content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val reasoningContent: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta.refusal

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/refusal.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val refusal: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta.role

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/role.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val role: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamDelta.toolCalls

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-delta/tool-calls.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val toolCalls: List<OpenAIStreamToolCall>?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamFunction.OpenAIStreamFunction

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-function/-open-a-i-stream-function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(name: String?, arguments: String?)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamFunction.arguments

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-function/arguments.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val arguments: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamFunction

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-function/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIStreamFunction(val name: String?, val arguments: String?)
```

Represents a function object used in OpenAI stream tool calls.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamFunction.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-function/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamOptions.OpenAIStreamOptions

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-options/-open-a-i-stream-options.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(includeUsage: Boolean? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamOptions.includeUsage

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-options/include-usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val includeUsage: Boolean?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamOptions

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-options/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIStreamOptions(val includeUsage: Boolean? = null)
```

Options for streaming response.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamToolCall.index

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-tool-call/--index--.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val index: Int
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamToolCall.OpenAIStreamToolCall

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-tool-call/-open-a-i-stream-tool-call.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(index: Int, id: String?, function: OpenAIStreamFunction?, type: String? = "function")
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamToolCall.function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-tool-call/function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val function: OpenAIStreamFunction?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamToolCall.id

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-tool-call/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamToolCall

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-tool-call/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIStreamToolCall(val index: Int, val id: String?, val function: OpenAIStreamFunction?, val type: String? = "function")
```

Represents a tool call in the OpenAI stream, specifying the function invoked and its related metadata.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIStreamToolCall.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-stream-tool-call/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAITool.OpenAITool

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool/-open-a-i-tool.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(function: OpenAIToolFunction)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAITool.function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool/function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val function: OpenAIToolFunction
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAITool

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAITool(val function: OpenAIToolFunction)
```

Tool the model may call.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAITool.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String
```

Type of the tool.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolCall.OpenAIToolCall

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-call/-open-a-i-tool-call.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(id: String, function: OpenAIFunction)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolCall.function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-call/function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val function: OpenAIFunction
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolCall.id

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-call/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolCall

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-call/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIToolCall(val id: String, val function: OpenAIFunction)
```

Tool call generated by the OpenAI model.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolCall.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-call/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String
```

The type of the tool. Currently, only function is supported.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Companion.Auto

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-companion/-auto.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val Auto: OpenAIToolChoice.Mode
```

Represents the auto mode for invoking tools in the OpenAI system.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Companion.None

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-companion/-none.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val None: OpenAIToolChoice.Mode
```

Represents the none mode for invoking tools in the OpenAI system.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Companion.Required

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-companion/-required.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val Required: OpenAIToolChoice.Mode
```

Represents the required mode for invoking tools in the OpenAI system.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Companion.function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-companion/function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun function(name: String): OpenAIToolChoice.Function
```

Creates a function tool with the specified name.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Companion

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
object Companion
```

none means the model will not call any tool and instead generates a message.

auto means the model can pick between generating a message or calling one or more tools.

required means the model must call one or more tools.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Function.Function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function/-function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(function: OpenAIToolChoice.FunctionName)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Function.function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function/function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val function: OpenAIToolChoice.FunctionName
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Function

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class Function(val function: OpenAIToolChoice.FunctionName) : OpenAIToolChoice
```

Specifies a tool the model should use. Use to force the model to call a specific function.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Function.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String
```

Specifies the type of the tool being used.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.FunctionName.FunctionName

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function-name/-function-name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.FunctionName

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function-name/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class FunctionName(val name: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.FunctionName.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-function-name/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Mode

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-mode/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@JvmInline @Serializable value class Mode : OpenAIToolChoice
```

Represents the mode in which a tool can be invoked by the model.

Modes:

none: The model will not invoke any tool and will generate a message instead.

auto: The model chooses between generating a message or invoking one or more tools.

required: The model must invoke one or more tools.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice.Mode.value

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/-mode/value.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val value: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolChoice

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-choice/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable(with = OpenAIToolChoiceSerializer::class) sealed interface OpenAIToolChoice
```

Controls which (if any) tool is called by the model.

- Mode
- Function

Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolFunction.OpenAIToolFunction

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-function/-open-a-i-tool-function.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(name: String, description: String? = null, parameters: JsonObject? = null, strict: Boolean? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolFunction.description

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-function/description.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val description: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolFunction

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-function/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIToolFunction(val name: String, val description: String? = null, val parameters: JsonObject? = null, val strict: Boolean? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolFunction.name

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-function/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolFunction.parameters

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-function/parameters.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val parameters: JsonObject?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIToolFunction.strict

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-tool-function/strict.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val strict: Boolean?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage.OpenAIUsage

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/-open-a-i-usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(promptTokens: Int? = null, completionTokens: Int? = null, totalTokens: Int? = null, completionTokensDetails: CompletionTokensDetails? = null, promptTokensDetails: PromptTokensDetails? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage.completionTokensDetails

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/completion-tokens-details.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val completionTokensDetails: CompletionTokensDetails?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage.completionTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/completion-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val completionTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIUsage(val promptTokens: Int? = null, val completionTokens: Int? = null, val totalTokens: Int? = null, val completionTokensDetails: CompletionTokensDetails? = null, val promptTokensDetails: PromptTokensDetails? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage.promptTokensDetails

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/prompt-tokens-details.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val promptTokensDetails: PromptTokensDetails?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage.promptTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/prompt-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val promptTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUsage.totalTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-usage/total-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val totalTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.ApproximateLocation.ApproximateLocation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-approximate-location/-approximate-location.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(city: String? = null, country: String? = null, region: String? = null, timezone: String? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.ApproximateLocation.city

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-approximate-location/city.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val city: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.ApproximateLocation.country

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-approximate-location/country.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val country: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.ApproximateLocation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-approximate-location/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class ApproximateLocation(val city: String? = null, val country: String? = null, val region: String? = null, val timezone: String? = null)
```

Approximate location parameters for the search.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.ApproximateLocation.region

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-approximate-location/region.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val region: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.ApproximateLocation.timezone

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-approximate-location/timezone.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val timezone: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.OpenAIUserLocation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/-open-a-i-user-location.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(approximate: OpenAIUserLocation.ApproximateLocation)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.approximate

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/approximate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val approximate: OpenAIUserLocation.ApproximateLocation
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIUserLocation(val approximate: OpenAIUserLocation.ApproximateLocation)
```

Approximate location parameters for the search.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIUserLocation.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-user-location/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String
```

Approximate location parameters for the search.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebSearchOptions.OpenAIWebSearchOptions

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-search-options/-open-a-i-web-search-options.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(searchContextSize: String? = null, userLocation: OpenAIUserLocation? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebSearchOptions

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-search-options/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIWebSearchOptions(val searchContextSize: String? = null, val userLocation: OpenAIUserLocation? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebSearchOptions.searchContextSize

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-search-options/search-context-size.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val searchContextSize: String?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebSearchOptions.userLocation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-search-options/user-location.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val userLocation: OpenAIUserLocation?
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.Citation.Citation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-citation/-citation.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(endIndex: Int, startIndex: Int, title: String, url: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.Citation.endIndex

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-citation/end-index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val endIndex: Int
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.Citation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-citation/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class Citation(val endIndex: Int, val startIndex: Int, val title: String, val url: String)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.Citation.startIndex

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-citation/start-index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val startIndex: Int
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.Citation.title

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-citation/title.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val title: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.Citation.url

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-citation/url.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val url: String
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.OpenAIWebUrlCitation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/-open-a-i-web-url-citation.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(urlCitation: OpenAIWebUrlCitation.Citation)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class OpenAIWebUrlCitation(val urlCitation: OpenAIWebUrlCitation.Citation)
```

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.type

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val type: String
```

The type of the URL citation.

## ai.koog.prompt.executor.clients.openai.base.models.OpenAIWebUrlCitation.urlCitation

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-open-a-i-web-url-citation/url-citation.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val urlCitation: OpenAIWebUrlCitation.Citation
```

## ai.koog.prompt.executor.clients.openai.base.models.PromptTokensDetails.PromptTokensDetails

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-prompt-tokens-details/-prompt-tokens-details.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor(audioTokens: Int? = null, cachedTokens: Int? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.PromptTokensDetails.audioTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-prompt-tokens-details/audio-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val audioTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.PromptTokensDetails.cachedTokens

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-prompt-tokens-details/cached-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val cachedTokens: Int?
```

## ai.koog.prompt.executor.clients.openai.base.models.PromptTokensDetails

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-prompt-tokens-details/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable class PromptTokensDetails(val audioTokens: Int? = null, val cachedTokens: Int? = null)
```

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.HIGH

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/-h-i-g-h/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "high") HIGH
```

Maximizes the model’s reasoning depth for complex or ambiguous problems. Expect higher latency and token usage. Serialized as "high".

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.LOW

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/-l-o-w/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "low") LOW
```

Allows a small amount of reasoning while prioritizing speed and efficiency. Suitable for straightforward prompts with occasional light chaining. Serialized as "low".

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.MEDIUM

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/-m-e-d-i-u-m/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "medium") MEDIUM
```

Balanced allowance for reasoning to handle typical multi-step tasks without excessive overhead. Serialized as "medium".

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.MINIMAL

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/-m-i-n-i-m-a-l/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "minimal") MINIMAL
```

Allows very limited reasoning while strongly prioritizing speed and cost. Serialized as "minimal".

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.NONE

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/-n-o-n-e/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "none") NONE
```

Disables reasoning. Is not supported by models before gpt-5.1! Serialized as "none".

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.entries

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val entries: EnumEntries<ReasoningEffort>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@Serializable enum ReasoningEffort : Enum<ReasoningEffort>
```

Constrains the amount of effort a reasoning-capable model spends on internal reasoning.

Lower settings can yield faster responses and fewer reasoning tokens; higher settings may improve performance on multistep or complex tasks at the cost of additional latency and token usage. Exact effects are model-dependent. If not set, the model/provider default applies.

Serialized as "none" | "minimal" | "low" | "medium" | "high".

See reasoning_effort

## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.valueOf

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun valueOf(value: String): ReasoningEffort
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort.values

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-reasoning-effort/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun values(): Array<ReasoningEffort>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.AUTO

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/-a-u-t-o/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "auto") AUTO
```

Defer to the Project’s configured service tier (defaults to DEFAULT unless overridden at the Project level). Serialized as "auto".

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.DEFAULT

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/-d-e-f-a-u-l-t/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "default") DEFAULT
```

Use the standard pricing and performance for the selected model. Serialized as "default".

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.FLEX

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/-f-l-e-x/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "flex") FLEX
```

Lower-cost, opportunistic processing that may be slower and occasionally unavailable; ideal for non-production or background workloads. Tokens are priced similarly to Batch API with additional savings from prompt caching. Serialized as "flex".

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.PRIORITY

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/-p-r-i-o-r-i-t-y/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
@SerialName(value = "priority") PRIORITY
```

High-speed, reliable processing with predictably low latency, including during peak demand; available pay-as-you-go without pre-provisioning. Serialized as "priority".

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.entries

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
val entries: EnumEntries<ServiceTier>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
enum ServiceTier : Enum<ServiceTier>
```

Service tier used to process a request.

Behavior overview:

AUTO — Defers to the Project’s configured service tier (which, unless changed, is DEFAULT).

DEFAULT — Standard pricing and performance for the selected model.

FLEX — Lower cost in exchange for slower responses and occasional resource unavailability; suited for non-production / lower-priority tasks such as evaluations, data enrichment, and asynchronous workloads. Tokens are billed at Batch-API-like rates and can benefit from prompt-cache discounts.

PRIORITY — Reliable, high-speed processing with predictably low latency, even during peak demand; available on a flexible, pay-as-you-go basis without advance provisioning.

Note: When a tier is requested, the response payload includes the service_tier actually used to serve the request. This value may differ from the one provided in the request.

See service_tier

## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.valueOf

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun valueOf(value: String): ServiceTier
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.base.models.ServiceTier.values

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.models/-service-tier/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
fun values(): Array<ServiceTier>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIBasicJsonSchemaGenerator.Default

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-basic-json-schema-generator/-default/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
object Default : OpenAIBasicJsonSchemaGenerator
```

Default instance of OpenAIBasicJsonSchemaGenerator. Prefer to use it instead of creating new instates manually.

- OpenAIBasicJsonSchemaGenerator
## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIBasicJsonSchemaGenerator.OpenAIBasicJsonSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-basic-json-schema-generator/-open-a-i-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIBasicJsonSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-basic-json-schema-generator/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open class OpenAIBasicJsonSchemaGenerator : BasicJsonSchemaGenerator
```

Extends BasicJsonSchemaGenerator to generate LLMParams.Schema.JSON.Basic in custom OpenAI format.

- Default

Referenced packages: `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIStandardJsonSchemaGenerator.Companion

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-standard-json-schema-generator/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
object Companion : OpenAIStandardJsonSchemaGenerator
```

Default instance of OpenAIStandardJsonSchemaGenerator. Prefer to use it instead of creating new instates manually.

- OpenAIStandardJsonSchemaGenerator
## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIStandardJsonSchemaGenerator.OpenAIStandardJsonSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-standard-json-schema-generator/-open-a-i-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIStandardJsonSchemaGenerator.generate

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-standard-json-schema-generator/generate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open override fun generate(json: Json, name: String, serializer: KSerializer<*>, descriptionOverrides: Map<String, String>, excludedProperties: Set<String>): LLMParams.Schema.JSON.Standard
```

Generates LLMParams.Schema.JSON.Standard in custom OpenAI format.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.base.structure.OpenAIStandardJsonSchemaGenerator

Module: `prompt-executor-openai-client-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client-base/ai.koog.prompt.executor.clients.openai.base.structure/-open-a-i-standard-json-schema-generator/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client-base/commonMain

```kotlin
open class OpenAIStandardJsonSchemaGenerator : StandardJsonSchemaGenerator
```

Extends StandardJsonSchemaGenerator to generate LLMParams.Schema.JSON.Standard in custom OpenAI format.

- Companion

Referenced packages: `ai.koog.prompt.structure.json.generator`.
