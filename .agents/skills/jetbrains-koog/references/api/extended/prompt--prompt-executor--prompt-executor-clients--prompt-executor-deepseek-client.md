# prompt / prompt-executor / prompt-executor-clients / prompt-executor-deepseek-client

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekModels.DeepSeekV4FlashVisionExp

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-models/-deep-seek-v4-flash-vision-exp.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@JvmField val DeepSeekV4FlashVisionExp: LLModel
```

DeepSeek V4 Flash Vision (experimental) is a multimodal vision understanding model with stronger visual agent performance, staying on par with DeepSeekV4Flash for pure text tasks. Supports both thinking and non-thinking modes in the DeepSeek API.

- Chat Completion API

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekModels.DeepSeekV4Flash

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-models/-deep-seek-v4-flash.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@JvmField val DeepSeekV4Flash: LLModel
```

DeepSeek V4 Flash model optimized for fast, cost-effective generation. Supports both thinking and non-thinking modes in the DeepSeek API.

- Chat Completion API

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekModels.DeepSeekV4Pro

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-models/-deep-seek-v4-pro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@JvmField val DeepSeekV4Pro: LLModel
```

DeepSeek V4 Pro model optimized for advanced reasoning and agentic tasks. Supports both thinking and non-thinking modes in the DeepSeek API.

- Chat Completion API

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekModels.addCustomModel

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-models/add-custom-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override fun addCustomModel(model: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekModels

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-models/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
object DeepSeekModels : LLModelDefinitions
```

Object containing a collection of predefined DeepSeek model configurations.

DeepSeek provides powerful language models with competitive pricing and advanced reasoning capabilities. All models support JSON output, function calling, and chat prefix completion features.

$0.44 / $

$1.74 / $

- DeepSeek Pricing Documentation

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekModels.models

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-models/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val models: List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.DeepSeekParams

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/-deep-seek-params.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
constructor(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, frequencyPenalty: Double? = null, presencePenalty: Double? = null, logprobs: Boolean? = null, stop: List<String>? = null, topLogprobs: Int? = null, topP: Double? = null)
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.copy

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/copy.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override fun copy(temperature: Double?, maxTokens: Int?, numberOfChoices: Int?, speculation: String?, schema: LLMParams.Schema?, toolChoice: LLMParams.ToolChoice?, user: String?, additionalProperties: Map<String, JsonElement>?): DeepSeekParams
```


Referenced packages: `ai.koog.prompt.params`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
fun copy(temperature: Double? = this.temperature, maxTokens: Int? = this.maxTokens, numberOfChoices: Int? = this.numberOfChoices, speculation: String? = this.speculation, schema: LLMParams.Schema? = this.schema, toolChoice: LLMParams.ToolChoice? = this.toolChoice, user: String? = this.user, additionalProperties: Map<String, JsonElement>? = this.additionalProperties, frequencyPenalty: Double? = this.frequencyPenalty, presencePenalty: Double? = this.presencePenalty, logprobs: Boolean? = this.logprobs, stop: List<String>? = this.stop, topLogprobs: Int? = this.topLogprobs, topP: Double? = this.topP): DeepSeekParams
```

Creates a copy of this instance with the ability to modify any of its properties.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.equals

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/equals.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.frequencyPenalty

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/frequency-penalty.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val frequencyPenalty: Double?
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.hashCode

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/hash-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
class DeepSeekParams(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, val frequencyPenalty: Double? = null, val presencePenalty: Double? = null, val logprobs: Boolean? = null, val stop: List<String>? = null, val topLogprobs: Int? = null, val topP: Double? = null) : LLMParams
```

DeepSeek chat-completions parameters layered on top of LLMParams.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.logprobs

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val logprobs: Boolean?
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.presencePenalty

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/presence-penalty.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val presencePenalty: Double?
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.stop

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/stop.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val stop: List<String>?
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.toString

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.topLogprobs

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/top-logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val topLogprobs: Int?
```

## ai.koog.prompt.executor.clients.deepseek.DeepSeekParams.topP

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek/-deep-seek-params/top-p.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val topP: Double?
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.DeepSeekChatCompletionResponse

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/-deep-seek-chat-completion-response.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
constructor(choices: List<OpenAIChoice>, created: Long, id: String, model: String, systemFingerprint: String, objectType: String = "chat.completion", usage: OpenAIUsage? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.choices

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val choices: List<OpenAIChoice>
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.created

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/created.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val created: Long
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.id

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val id: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@Serializable class DeepSeekChatCompletionResponse(val choices: List<OpenAIChoice>, val created: Long, val id: String, val model: String, val systemFingerprint: String, val objectType: String = "chat.completion", val usage: OpenAIUsage? = null) : OpenAIBaseLLMResponse
```

DeepSeek Chat Completion Response https://api-docs.deepseek.com/


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.model

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val model: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.objectType

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/object-type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@SerialName(value = "object") val objectType: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.systemFingerprint

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/system-fingerprint.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val systemFingerprint: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionResponse.usage

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-response/usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val usage: OpenAIUsage?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.DeepSeekChatCompletionStreamResponse

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/-deep-seek-chat-completion-stream-response.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
constructor(choices: List<OpenAIStreamChoice>, created: Long, id: String, model: String, systemFingerprint: String, objectType: String = "chat.completion.chunk", usage: OpenAIUsage? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.choices

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val choices: List<OpenAIStreamChoice>
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.created

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/created.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val created: Long
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.id

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val id: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@Serializable class DeepSeekChatCompletionStreamResponse(val choices: List<OpenAIStreamChoice>, val created: Long, val id: String, val model: String, val systemFingerprint: String, val objectType: String = "chat.completion.chunk", val usage: OpenAIUsage? = null) : OpenAIBaseLLMStreamResponse
```

DeepSeek Chat Completion Streaming Response


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.model

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
open override val model: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.objectType

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/object-type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
@SerialName(value = "object") val objectType: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.systemFingerprint

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/system-fingerprint.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val systemFingerprint: String
```

## ai.koog.prompt.executor.clients.deepseek.models.DeepSeekChatCompletionStreamResponse.usage

Module: `prompt-executor-deepseek-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-deepseek-client/ai.koog.prompt.executor.clients.deepseek.models/-deep-seek-chat-completion-stream-response/usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-deepseek-client/commonMain

```kotlin
val usage: OpenAIUsage?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.
