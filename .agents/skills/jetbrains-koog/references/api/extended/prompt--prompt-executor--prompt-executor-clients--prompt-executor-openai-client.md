# prompt / prompt-executor / prompt-executor-clients / prompt-executor-openai-client

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.OpenAIChatParams

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/-open-a-i-chat-params.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, frequencyPenalty: Double? = null, presencePenalty: Double? = null, parallelToolCalls: Boolean? = null, promptCacheKey: String? = null, safetyIdentifier: String? = null, serviceTier: ServiceTier? = null, store: Boolean? = null, audio: OpenAIAudioConfig? = null, logprobs: Boolean? = null, reasoningEffort: ReasoningEffort? = null, stop: List<String>? = null, topLogprobs: Int? = null, topP: Double? = null, webSearchOptions: OpenAIWebSearchOptions? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.audio

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val audio: OpenAIAudioConfig?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.copy

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/copy.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun copy(temperature: Double?, maxTokens: Int?, numberOfChoices: Int?, speculation: String?, schema: LLMParams.Schema?, toolChoice: LLMParams.ToolChoice?, user: String?, additionalProperties: Map<String, JsonElement>?): OpenAIChatParams
```


Referenced packages: `ai.koog.prompt.params`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun copy(temperature: Double? = this.temperature, maxTokens: Int? = this.maxTokens, numberOfChoices: Int? = this.numberOfChoices, speculation: String? = this.speculation, schema: LLMParams.Schema? = this.schema, toolChoice: LLMParams.ToolChoice? = this.toolChoice, user: String? = this.user, additionalProperties: Map<String, JsonElement>? = this.additionalProperties, frequencyPenalty: Double? = this.frequencyPenalty, presencePenalty: Double? = this.presencePenalty, parallelToolCalls: Boolean? = this.parallelToolCalls, promptCacheKey: String? = this.promptCacheKey, safetyIdentifier: String? = this.safetyIdentifier, serviceTier: ServiceTier? = this.serviceTier, store: Boolean? = this.store, audio: OpenAIAudioConfig? = this.audio, logprobs: Boolean? = this.logprobs, reasoningEffort: ReasoningEffort? = this.reasoningEffort, stop: List<String>? = this.stop, topLogprobs: Int? = this.topLogprobs, topP: Double? = this.topP, webSearchOptions: OpenAIWebSearchOptions? = this.webSearchOptions): OpenAIChatParams
```

Creates a copy of this instance with the ability to modify any of its properties.


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.equals

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/equals.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.frequencyPenalty

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/frequency-penalty.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val frequencyPenalty: Double?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.hashCode

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/hash-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
class OpenAIChatParams(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, val frequencyPenalty: Double? = null, val presencePenalty: Double? = null, val parallelToolCalls: Boolean? = null, val promptCacheKey: String? = null, val safetyIdentifier: String? = null, val serviceTier: ServiceTier? = null, val store: Boolean? = null, val audio: OpenAIAudioConfig? = null, val logprobs: Boolean? = null, val reasoningEffort: ReasoningEffort? = null, val stop: List<String>? = null, val topLogprobs: Int? = null, val topP: Double? = null, val webSearchOptions: OpenAIWebSearchOptions? = null) : LLMParams, OpenAIParams
```

OpenAI chat/completions parameters layered on top of LLMParams.

These options mirror the fields commonly used with OpenAI’s Chat Completions / Responses APIs and add OpenAI-specific controls (audio, logprobs, reasoning effort, response formatting, service tiers, etc.). All parameters are optional; when unset, provider/model defaults apply.


Referenced packages: `ai.koog.prompt.executor.clients.openai`, `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.logprobs

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val logprobs: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.parallelToolCalls

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/parallel-tool-calls.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val parallelToolCalls: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.presencePenalty

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/presence-penalty.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val presencePenalty: Double?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.promptCacheKey

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/prompt-cache-key.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val promptCacheKey: String?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.reasoningEffort

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/reasoning-effort.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val reasoningEffort: ReasoningEffort?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.safetyIdentifier

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/safety-identifier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val safetyIdentifier: String?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.serviceTier

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/service-tier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val serviceTier: ServiceTier?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.stop

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/stop.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val stop: List<String>?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.store

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/store.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val store: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.toString

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.topLogprobs

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/top-logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val topLogprobs: Int?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.topP

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/top-p.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val topP: Double?
```

## ai.koog.prompt.executor.clients.openai.OpenAIChatParams.webSearchOptions

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-chat-params/web-search-options.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val webSearchOptions: OpenAIWebSearchOptions?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Audio.GPT4oAudio

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-audio/-g-p-t4o-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4oAudio: LLModel
```

GPT-4o Audio is a model designed to input audio or create audio outputs.

128,000 context window 16,384 max output tokens Oct 01, 2023 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Audio.GPT4oMiniAudio

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-audio/-g-p-t4o-mini-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4oMiniAudio: LLModel
```

GPT-4o mini Audio is a smaller, more affordable version of GPT-4o Audio that maintains high quality while being more cost-effective. It's designed to input audio or create audio outputs.

128,000 context window 16,384 max output tokens Oct 01, 2023 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Audio.GptAudio

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-audio/-gpt-audio.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GptAudio: LLModel
```

GPT Audio is a model for audio inputs and outputs.

128,000 context window 16,384 max output tokens Oct 01, 2023 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Audio

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-audio/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
object Audio
```

The Audio object provides access to preconfigured audio-enabled Large Language Models (LLMs). These models support both audio input and output functionalities, making them suitable for various audio-centric applications.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT4_1Mini

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t4_1-mini.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4_1Mini: LLModel
```

GPT-4.1 mini provides a balance between intelligence, speed, and cost that makes it an attractive model for many use cases.

1,047,576 context window 32,768 max output tokens Jun 01, 2024 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT4_1Nano

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t4_1-nano.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4_1Nano: LLModel
```

GPT-4.1-nano is the smallest and most affordable model in the GPT-4.1 family. It's designed for tasks that require basic capabilities at the lowest possible cost.

1,047,576 context window 32,768 max output tokens Jun 01, 2024 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT4_1

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t4_1.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4_1: LLModel
```

GPT-4.1 is a model for complex tasks. It is well suited for problem solving across domains.

1,047,576 context window 32,768 max output tokens Jun 01, 2024 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT4oMini

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t4o-mini.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4oMini: LLModel
```

GPT-4o mini is a smaller, more affordable version of GPT-4o that maintains high quality while being more cost-effective. It's designed for tasks that don't require the full capabilities of GPT-4o.

128K context window. 16,384 max output tokens Oct 01, 2023 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT4o

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t4o.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT4o: LLModel
```

GGPT-4o (“o” for “omni”) is a versatile, high-intelligence flagship model. It accepts both text and image inputs, and produces text outputs (including Structured Outputs). It is the best model for most tasks, and is currently the most capable model outside of the o-series models.

128,000 context window 16,384 max output tokens Oct 01, 2023 knowledge cutoff

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5Codex

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5-codex.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5Codex: LLModel
```

GPT-5-Codex is a version of GPT-5 optimized for agentic coding tasks in agents. It's available in the Responses API only, and the underlying model snapshot will be regularly updated.

400,000 context window 128,000 max output tokens Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5Mini

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5-mini.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5Mini: LLModel
```

GPT-5 mini is a faster, cost-efficient version of GPT-5 for well-defined tasks.

400,000 context window 128,000 max output tokens May 31, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5Nano

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5-nano.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5Nano: LLModel
```

GPT-5 nano is the fastest, most cost-efficient version of GPT-5. Great for summarization and classification tasks.

400,000 context window 128,000 max output tokens May 31, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5Pro

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5-pro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5Pro: LLModel
```

GPT-5 pro uses more compute to think harder and provide consistently better answers. GPT-5 pro is available in the Responses API only to enable support for multi-turn model interactions before responding to API requests, and other advanced API features in the future. As the most advanced reasoning model, GPT-5 pro defaults to (and only supports) reasoning.effort: high. GPT-5 pro does not support code interpreter.

400,000 context window 272,000 max output tokens Sep 30, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5: LLModel
```

GPT-5 is a flagship model for coding, reasoning, and agentic tasks across domains.

400,000 context window 128,000 max output tokens Sep 30, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_1CodexMax

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_1-codex-max.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_1CodexMax: LLModel
```

GPT-5.1-Codex-Max GPT‑5.1-Codex-Max is purpose-built for agentic coding. It's only available in the Responses API.

400,000 context window 128,000 max output tokens Sep 30, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_1Codex

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_1-codex.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_1Codex: LLModel
```

GPT-5.1-Codex is a version of GPT-5 optimized for agentic coding tasks in Codex or similar environments. It's available in the Responses API only, and the underlying model snapshot will be regularly updated.

400,000 context window 128,000 max output tokens Sep 30, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_1

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_1.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_1: LLModel
```

GPT-5.1 is a flagship model for coding and agentic tasks with configurable reasoning and non-reasoning effort.

400,000 context window 128,000 max output tokens Sep 30, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_2Codex

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_2-codex.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_2Codex: LLModel
```

GPT-5.2-Codex is an upgraded version of GPT-5.2 optimized for agentic coding tasks in Codex or similar environments. GPT-5.2-Codex supports low, medium, high, and xhigh reasoning effort settings.

400,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_2Pro

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_2-pro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_2Pro: LLModel
```

GPT-5.2 pro is available in the Responses API only to enable support for multi-turn model interactions before responding to API requests, and other advanced API features in the future. Supports reasoning.effort: medium, high, xhigh.

400,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_2

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_2.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_2: LLModel
```

GPT-5.2 is OpenAI's flagship model for coding and agentic tasks across industries. Supports both reasoning and chat completions endpoints.

400,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_3Codex

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_3-codex.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_3Codex: LLModel
```

GPT-5.3-Codex is optimized for agentic coding tasks in Codex or similar environments. GPT-5.3-Codex supports low, medium, high, and xhigh reasoning effort settings.

400,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_4Mini

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_4-mini.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_4Mini: LLModel
```

GPT-5.4 mini brings the strengths of GPT-5.4 to a faster, more efficient model designed for high-volume workloads.

400,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_4Nano

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_4-nano.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_4Nano: LLModel
```

GPT-5.4 nano is designed for tasks where speed and cost matter most like classification, data extraction, ranking, and sub-agents.

400,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_4Pro

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_4-pro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_4Pro: LLModel
```

GPT-5.4 pro uses more compute to think harder and provide consistently better answers. GPT-5.4 pro is available in the Responses API only to enable support for multi-turn model interactions before responding to API requests, and other advanced API features in the future. Since GPT-5.4 pro is designed to tackle tough problems, some requests may take several minutes to finish. To avoid timeouts, try using background mode. GPT-5.4 pro supports reasoning.effort: medium, high, xhigh.

1,050,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_4

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_4.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_4: LLModel
```

GPT-5.4 is OpenAI's frontier model for complex professional work. Reasoning.effort supports: none (default), low, medium, high and xhigh.

1,050,000 context window 128,000 max output tokens Aug 31, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_5Pro

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_5-pro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_5Pro: LLModel
```

GPT-5.5 pro uses more compute to think harder and provide consistently better answers. OpenAI's model page text says GPT-5.5 pro is for Responses API requests, while the endpoint table on the same page also lists chat completions. Koog follows the textual model description and treats GPT-5.5 pro as Responses-only.

1,050,000 context window 128,000 max output tokens Dec 01, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_5

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_5.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_5: LLModel
```

GPT-5.5 is OpenAI's newest frontier model for the most complex professional work. Reasoning.effort supports: none, low, medium (default), high and xhigh.

1,050,000 context window 128,000 max output tokens Dec 01, 2025 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_6Luna

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_6-luna.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_6Luna: LLModel
```

GPT-5.6 Luna is the fastest, most cost-efficient model of the GPT-5.6 family, designed for high-volume tasks like classification, extraction, and sub-agents.

1,050,000 context window 128,000 max output tokens Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_6Sol

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_6-sol.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_6Sol: LLModel
```

GPT-5.6 Sol is the flagship model of the GPT-5.6 family, setting a new standard for both intelligence and efficiency across coding, knowledge work, cybersecurity, and science. The gpt-5.6 API alias points to this model.

1,050,000 context window 128,000 max output tokens Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.GPT5_6Terra

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-g-p-t5_6-terra.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val GPT5_6Terra: LLModel
```

GPT-5.6 Terra is the balanced model of the GPT-5.6 family for everyday work, matching GPT-5.5 quality at a lower price point.

1,050,000 context window 128,000 max output tokens Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.O1

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-o1.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val O1: LLModel
```

The o1 series of models are trained with reinforcement learning to perform complex reasoning. o1 models think before they answer, producing a long internal chain of thought before responding to the user.

200,000 context window 100,000 max output tokens Oct 01, 2023 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.O3Mini

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-o3-mini.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val O3Mini: LLModel
```

o3-mini is a smaller, more affordable version of o3. It's a small reasoning model, providing high intelligence at the same cost and latency targets of o1-mini. o3-mini supports key developer features, like Structured Outputs, function calling, and Batch API.

200,000 context window 100,000 max output tokens Oct 01, 2023 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.O3

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-o3.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val O3: LLModel
```

o3 is a well-rounded and powerful model across domains. It is capable of math, science, coding, and visual reasoning tasks. It also excels at technical writing and instruction-following. Use it to think through multi-step problems that involve analysis across text, code, and images.

200,000 context window 100,000 max output tokens Jun 01, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat.O4Mini

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/-o4-mini.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val O4Mini: LLModel
```

o4-mini is a smaller, more affordable version of o4 that maintains high quality while being more cost-effective. It's optimized for fast, effective reasoning with exceptionally efficient performance in coding and visual tasks.

200,000 context window 100,000 max output tokens Jun 01, 2024 knowledge cutoff Reasoning token support

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Chat

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-chat/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
object Chat
```

Object that provides pre-configured instances of advanced GPT models for different use cases. These instances represent versatile and high-performance large language models capable of handling various tasks like text completion, image input processing, structured outputs, and interfacing with tools.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Embeddings.TextEmbeddingAda002

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-embeddings/-text-embedding-ada002.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val TextEmbeddingAda002: LLModel
```

text-embedding-ada-002 is more performant version of the initial ada embedding model. But it's an older model compared to TextEmbedding3Small and TextEmbedding3Large.

Fast, cheap, good for many general tasks

Outputs: 1536-dimensional vectors Max input tokens: 8191 Released: Dec 2022

Embeddings are a numerical representation of text that can be used to measure the relatedness between two pieces of text. Embeddings are useful for search, clustering, recommendations, anomaly detection, and classification tasks.

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Embeddings.TextEmbedding3Large

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-embeddings/-text-embedding3-large.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val TextEmbedding3Large: LLModel
```

text-embedding-3-large is currently the most capable embedding model for both english and non-english tasks.

Currently provides best embedding quality; supports multiple dimensions for flexibility and cost tradeoff.

Outputs: 3072-dimensional vectors (or 256-/512-/1024-dimensional vectors, optionally) Max input tokens: 8191 Released: Jan 2024

Embeddings are a numerical representation of text that can be used to measure the relatedness between two pieces of text. Embeddings are useful for search, clustering, recommendations, anomaly detection, and classification tasks.

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Embeddings.TextEmbedding3Small

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-embeddings/-text-embedding3-small.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val TextEmbedding3Small: LLModel
```

text-embedding-3-small is an improved, more performant version of the ada embedding model.

Smaller, faster, and more cost-effective than ada-002, with better quality.

Outputs: 1536-dimensional vectors (or 512-dimensional vectors, optionally) Max input tokens: 8191 Released: Jan 2024

Embeddings are a numerical representation of text that can be used to measure the relatedness between two pieces of text. Embeddings are useful for search, clustering, recommendations, anomaly detection, and classification tasks.

- Model page

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Embeddings

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-embeddings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
object Embeddings
```

Embeddings are useful for search, clustering, recommendations, anomaly detection, and classification tasks.

It is NOT recommended to use these models for other tasks other than for computing embeddings.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Moderation.Omni

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-moderation/-omni.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@JvmField val Omni: LLModel
```

Omni-moderation is the most capable moderation model, accepting both text and images as input. It can identify potentially harmful content across multiple categories.

Performance: High Speed: Medium Input: Text, image Output: Text


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.Moderation

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/-moderation/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
object Moderation
```

Object containing moderation models designed to detect harmful content in text and images. These models are free to use and can identify various categories of potentially harmful content.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.addCustomModel

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/add-custom-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun addCustomModel(model: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
object OpenAIModels : LLModelDefinitions
```

Object containing a collection of predefined OpenAI model configurations. These models span various use cases, including reasoning, chat, and cost-optimized tasks.

Note: All models with vision (image) capabilities also support sending PDF files.

- Models listNameSpeedPriceInputOutputChat.GPT4oMedium$2.5-$10Text, Image, Tools, DocumentText, ToolsChat.GPT4oMiniFast$0.15-$0.6Text, Image, ToolsText, ToolsChat.GPT4_1Medium$2-$8Text, Image, Tools, DocumentText, ToolsChat.GPT4_1NanoVery fast$0.1-$0.4Text, Image, Tools, DocumentText, ToolsChat.GPT4_1MiniFast$0.4-$1.6Text, Image, Tools, DocumentText, ToolsChat.O1Slowest$15-$60Text, Image, Tools, DocumentText, ToolsChat.O3Slowest$10-$40Text, Image, Tools, DocumentText, ToolsChat.O3MiniMedium$1.1-$4.4Text, ToolsText, ToolsChat.O4MiniMedium$1.1-$4.4Text, Image, Tools, DocumentText, ToolsChat.GPT5Medium$1.25-$10Text, Image, Tools, DocumentText, ToolsChat.GPT5MiniFast$0.25-$2Text, Image, Tools, DocumentText, ToolsChat.GPT5NanoVery fast$0.05-$0.4Text, Image, Tools, DocumentText, ToolsChat.GPT5CodexMedium$1.25-$10Text, Image, Tools, DocumentText, ToolsChat.GPT5ProSlowest$15-$120Text, Image, Tools, DocumentText, ToolsChat.GPT5_1Fast$1.25-$10Text, Image, Tools, DocumentText, Image, Tools, DocumentChat.GPT5_1CodexMedium$1.25-$10Text, Image, Tools, DocumentText, Image, Tools, DocumentChat.GPT5_1CodexMaxFast$1.25-$10Text, Image, Tools, DocumentText, ToolsChat.GPT5_2Fast$1.75-$14Text, Image, Tools, DocumentText, ToolsChat.GPT5_2ProSlowest$21-$168Text, Image, Tools, DocumentText, ToolsChat.GPT5_2CodexMedium$1.75-$14Text, Image, Tools, DocumentText, ToolsChat.GPT5_3CodexMedium$1.75-$14Text, Image, Tools, DocumentText, ToolsChat.GPT5_4Medium$2.5-$15Text, Image, Tools, DocumentText, ToolsChat.GPT5_4MiniFast$0.75-$4.5Text, Image, Tools, DocumentText, ToolsChat.GPT5_4NanoFast$0.2-$1.25Text, Image, Tools, DocumentText, ToolsChat.GPT5_4ProSlowest$30-$180Text, Image, Tools, DocumentText, ToolsChat.GPT5_5Fast$5-$30Text, Image, Tools, DocumentText, ToolsChat.GPT5_5ProSlowest$30-$180Text, Image, Tools, DocumentText, ToolsChat.GPT5_6SolMedium$5-$30Text, Image, Tools, DocumentText, ToolsChat.GPT5_6TerraFast$2-$12Text, Image, Tools, DocumentText, ToolsChat.GPT5_6LunaVery fast$0.2-$1.2Text, Image, Tools, DocumentText, ToolsAudio.GptAudioFast$2.5-$10Text, Audio, ToolsText, Audio, ToolsAudio.GPT4oMiniAudioFast$0.15-$0.6/$10-$20Text, Audio, ToolsText, Audio, ToolsAudio.GPT4oAudioMedium$2.5-$10/$40-$80Text, Audio, ToolsText, Audio, ToolsEmbeddings.TextEmbedding3SmallMedium$0.02TextTextEmbeddings.TextEmbedding3LargeSlow$0.13TextTextEmbeddings.TextEmbeddingAda002Slow$0.1TextTextModeration.OmniMedium$4.40TextModeration Result

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.openai.OpenAIModels.models

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-models/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val models: List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.OpenAIResponsesParams

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/-open-a-i-responses-params.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, background: Boolean? = null, include: List<OpenAIInclude>? = null, maxToolCalls: Int? = null, parallelToolCalls: Boolean? = null, reasoning: ReasoningConfig? = null, truncation: Truncation? = null, promptCacheKey: String? = null, safetyIdentifier: String? = null, serviceTier: ServiceTier? = null, store: Boolean? = null, logprobs: Boolean? = null, topLogprobs: Int? = null, topP: Double? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.prompt.executor.clients.openai.models`, `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.background

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/background.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val background: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.copy

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/copy.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun copy(temperature: Double?, maxTokens: Int?, numberOfChoices: Int?, speculation: String?, schema: LLMParams.Schema?, toolChoice: LLMParams.ToolChoice?, user: String?, additionalProperties: Map<String, JsonElement>?): OpenAIResponsesParams
```


Referenced packages: `ai.koog.prompt.params`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun copy(temperature: Double? = this.temperature, maxTokens: Int? = this.maxTokens, numberOfChoices: Int? = this.numberOfChoices, speculation: String? = this.speculation, schema: LLMParams.Schema? = this.schema, toolChoice: LLMParams.ToolChoice? = this.toolChoice, user: String? = this.user, additionalProperties: Map<String, JsonElement>? = this.additionalProperties, background: Boolean? = this.background, include: List<OpenAIInclude>? = this.include, maxToolCalls: Int? = this.maxToolCalls, parallelToolCalls: Boolean? = this.parallelToolCalls, reasoning: ReasoningConfig? = this.reasoning, truncation: Truncation? = this.truncation, promptCacheKey: String? = this.promptCacheKey, safetyIdentifier: String? = this.safetyIdentifier, serviceTier: ServiceTier? = this.serviceTier, store: Boolean? = this.store, logprobs: Boolean? = this.logprobs, topLogprobs: Int? = this.topLogprobs, topP: Double? = this.topP): OpenAIResponsesParams
```

Creates a copy of this instance with the ability to modify any of its properties.


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.prompt.executor.clients.openai.models`, `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.equals

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/equals.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.hashCode

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/hash-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.include

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/include.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val include: List<OpenAIInclude>?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@ApiStatus.Experimental class OpenAIResponsesParams(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, val background: Boolean? = null, val include: List<OpenAIInclude>? = null, val maxToolCalls: Int? = null, val parallelToolCalls: Boolean? = null, val reasoning: ReasoningConfig? = null, val truncation: Truncation? = null, val promptCacheKey: String? = null, val safetyIdentifier: String? = null, val serviceTier: ServiceTier? = null, val store: Boolean? = null, val logprobs: Boolean? = null, val topLogprobs: Int? = null, val topP: Double? = null) : LLMParams, OpenAIParams
```

OpenAI Responses API parameters layered on top of LLMParams.

Use these options to generate text or JSON, call built-in tools (e.g., web/file search) or your own functions, enable background processing, include auxiliary outputs, and tune sampling, reasoning, and truncation behavior. All parameters are optional; when unset, provider/model defaults apply.


Referenced packages: `ai.koog.prompt.executor.clients.openai`, `ai.koog.prompt.executor.clients.openai.base.models`, `ai.koog.prompt.executor.clients.openai.models`, `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.logprobs

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val logprobs: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.maxToolCalls

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/max-tool-calls.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val maxToolCalls: Int?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.parallelToolCalls

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/parallel-tool-calls.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val parallelToolCalls: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.promptCacheKey

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/prompt-cache-key.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val promptCacheKey: String?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.reasoning

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/reasoning.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val reasoning: ReasoningConfig?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.safetyIdentifier

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/safety-identifier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val safetyIdentifier: String?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.serviceTier

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/service-tier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val serviceTier: ServiceTier?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.store

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/store.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val store: Boolean?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.toString

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.topLogprobs

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/top-logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val topLogprobs: Int?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.topP

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/top-p.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val topP: Double?
```

## ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams.truncation

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai/-open-a-i-responses-params/truncation.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val truncation: Truncation?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.models`.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIClientSettings

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-client-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun AzureOpenAIClientSettings(resourceName: String, deploymentName: String, version: AzureOpenAIServiceVersion, timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig()): OpenAIClientSettings
```

Creates an instance of OpenAIClientSettings for Azure OpenAI client configuration.

- resourceName — The name of the Azure OpenAI resource.
- deploymentName — The name of the deployment within the Azure OpenAI resource.
- version — The version of the Azure OpenAI Service to use.
- timeoutConfig — Configuration for connection timeouts, including request, connect, and socket timeouts.

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun AzureOpenAIClientSettings(baseUrl: String, version: AzureOpenAIServiceVersion, timeoutConfig: ConnectionTimeoutConfig = ConnectionTimeoutConfig()): OpenAIClientSettings
```

Creates an instance of OpenAIClientSettings for Azure OpenAI client configuration.

This function is a convenience method that allows you to specify the base URL directly, along with the Azure OpenAI service version and connection timeout configuration.

- baseUrl — The base URL for the Azure OpenAI service.
- version — The version of the Azure OpenAI Service to use.
- timeoutConfig — Configuration for connection timeouts, including request, connect, and socket timeouts.

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.clients.openai`.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2022_12_01

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2022_12_01.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2022_12_01: AzureOpenAIServiceVersion
```

Version 2022-12-01 of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2023_05_15

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2023_05_15.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2023_05_15: AzureOpenAIServiceVersion
```

Version 2023-05-15 of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2023_06_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2023_06_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2023_06_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2023-06-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2023_07_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2023_07_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2023_07_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2023-07-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_02_01

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_02_01.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_02_01: AzureOpenAIServiceVersion
```

Version 2024-02-01 of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_02_15_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_02_15_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_02_15_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-02-15-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_03_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_03_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_03_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-03-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_04_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_04_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_04_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-04-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_05_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_05_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_05_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-05-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_06_01

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_06_01.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_06_01: AzureOpenAIServiceVersion
```

Version 2024-06-01 of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_07_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_07_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_07_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-07-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_08_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_08_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_08_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-08-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_09_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_09_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_09_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-09-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_10_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_10_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_10_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-10-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_10_21

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_10_21.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_10_21: AzureOpenAIServiceVersion
```

Version 2024-10-21 of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2024_12_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2024_12_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2024_12_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2024-12-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2025_01_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2025_01_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2025_01_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2025-01-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2025_02_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2025_02_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2025_02_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2025-02-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.V2025_03_01_PREVIEW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/-v2025_03_01_-p-r-e-v-i-e-w.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val V2025_03_01_PREVIEW: AzureOpenAIServiceVersion
```

Version 2025-03-01-preview of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.fromString

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/from-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun fromString(version: String): AzureOpenAIServiceVersion
```

Creates an instance of AzureOpenAIServiceVersion from a version string.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
object Companion
```

Companion object to hold predefined versions and utility methods.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.latestPreviewVersion

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/latest-preview-version.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun latestPreviewVersion(): AzureOpenAIServiceVersion
```

Returns the latest preview version of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.Companion.latestStableVersion

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/-companion/latest-stable-version.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun latestStableVersion(): AzureOpenAIServiceVersion
```

Returns the latest stable version of the Azure OpenAI Service.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.equals

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/equals.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.hashCode

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/hash-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
class AzureOpenAIServiceVersion
```

Represents the version of the Azure OpenAI Service.

This class encapsulates the version string and provides a way to access predefined versions. It also allows for easy comparison and retrieval of the latest stable and preview versions.

## ai.koog.prompt.executor.clients.openai.azure.AzureOpenAIServiceVersion.toString

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.azure/-azure-open-a-i-service-version/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.OpenAIChatCompletionResponse

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/-open-a-i-chat-completion-response.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(choices: List<OpenAIChoice>, created: Long, id: String, model: String, serviceTier: String? = null, systemFingerprint: String? = null, objectType: String, usage: OpenAIUsage? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.choices

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val choices: List<OpenAIChoice>
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.created

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/created.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val created: Long
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.id

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val id: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable class OpenAIChatCompletionResponse(val choices: List<OpenAIChoice>, val created: Long, val id: String, val model: String, val serviceTier: String? = null, val systemFingerprint: String? = null, val objectType: String, val usage: OpenAIUsage? = null) : OpenAIBaseLLMResponse
```

Represents the response from the OpenAI chat completion API.


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.model

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val model: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.objectType

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/object-type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "object") val objectType: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.serviceTier

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/service-tier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val serviceTier: String?
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.systemFingerprint

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/system-fingerprint.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val systemFingerprint: String?
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionResponse.usage

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-response/usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val usage: OpenAIUsage?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.OpenAIChatCompletionStreamResponse

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/-open-a-i-chat-completion-stream-response.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(choices: List<OpenAIStreamChoice>, created: Long, id: String, model: String, serviceTier: String? = null, systemFingerprint: String? = null, objectType: String, usage: OpenAIUsage? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.choices

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/choices.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val choices: List<OpenAIStreamChoice>
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.created

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/created.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val created: Long
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.id

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val id: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable class OpenAIChatCompletionStreamResponse(val choices: List<OpenAIStreamChoice>, val created: Long, val id: String, val model: String, val serviceTier: String? = null, val systemFingerprint: String? = null, val objectType: String, val usage: OpenAIUsage? = null) : OpenAIBaseLLMStreamResponse
```

Represents the stream response from the OpenAI chat completion API.


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.model

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
open override val model: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.objectType

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/object-type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "object") val objectType: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.serviceTier

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/service-tier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val serviceTier: String?
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.systemFingerprint

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/system-fingerprint.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val systemFingerprint: String?
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChatCompletionStreamResponse.usage

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-chat-completion-stream-response/usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val usage: OpenAIUsage?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChoice.index

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-choice/--index--.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val index: Int
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChoice.OpenAIChoice

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-choice/-open-a-i-choice.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(finishReason: String, index: Int, logprobs: OpenAIChoiceLogProbs? = null, message: OpenAIMessage)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChoice.finishReason

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-choice/finish-reason.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val finishReason: String
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIChoice

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-choice/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable class OpenAIChoice(val finishReason: String, val index: Int, val logprobs: OpenAIChoiceLogProbs? = null, val message: OpenAIMessage)
```

Chat completion choice


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChoice.logprobs

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-choice/logprobs.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val logprobs: OpenAIChoiceLogProbs?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIChoice.message

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-choice/message.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val message: OpenAIMessage
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.CODE_INTERPRETER_CALL_OUTPUTS

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-c-o-d-e_-i-n-t-e-r-p-r-e-t-e-r_-c-a-l-l_-o-u-t-p-u-t-s/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "code_interpreter_call.outputs") CODE_INTERPRETER_CALL_OUTPUTS
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.COMPUTER_CALL_OUTPUT_IMAGE_URL

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-c-o-m-p-u-t-e-r_-c-a-l-l_-o-u-t-p-u-t_-i-m-a-g-e_-u-r-l/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "computer_call_output.output.image_url") COMPUTER_CALL_OUTPUT_IMAGE_URL
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.FILE_SEARCH_CALL_RESULTS

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-f-i-l-e_-s-e-a-r-c-h_-c-a-l-l_-r-e-s-u-l-t-s/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "file_search_call.results") FILE_SEARCH_CALL_RESULTS
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.INPUT_IMAGE_URL

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-i-n-p-u-t_-i-m-a-g-e_-u-r-l/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "message.input_image.image_url") INPUT_IMAGE_URL
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.OUTPUT_TEXT_LOGPROBS

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-o-u-t-p-u-t_-t-e-x-t_-l-o-g-p-r-o-b-s/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "message.output_text.logprobs") OUTPUT_TEXT_LOGPROBS
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.REASONING_ENCRYPTED_CONTENT

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-r-e-a-s-o-n-i-n-g_-e-n-c-r-y-p-t-e-d_-c-o-n-t-e-n-t/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "reasoning.encrypted_content") REASONING_ENCRYPTED_CONTENT
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.WEB_SEARCH_CALL_ACTION_SOURCES

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/-w-e-b_-s-e-a-r-c-h_-c-a-l-l_-a-c-t-i-o-n_-s-o-u-r-c-e-s/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "web_search_call.action.sources") WEB_SEARCH_CALL_ACTION_SOURCES
```

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.entries

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val entries: EnumEntries<OpenAIInclude>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable enum OpenAIInclude : Enum<OpenAIInclude>
```

Specify additional output data to include in the model response. Currently supported values are:

web_search_call.action.sources: Include the sources of the web search tool call. code_interpreter_call.outputs: Includes the outputs of python code execution in code interpreter tool call items. computer_call_output.output.image_url: Include image urls from the computer call output. file_search_call.results: Include the search results of the file search tool call. message.input_image.image_url: Include image urls from the input message. message.output_text.logprobs: Include logprobs with assistant messages. reasoning.encrypted_content: Includes an encrypted version of reasoning tokens in reasoning item outputs. This enables reasoning items to be used in multi-turn conversations when using the Responses API statelessly (like when the store parameter is set to false, or when an organization is enrolled in the zero data retention program).

## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.valueOf

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun valueOf(value: String): OpenAIInclude
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.models.OpenAIInclude.values

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-open-a-i-include/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun values(): Array<OpenAIInclude>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.models.ReasoningConfig.ReasoningConfig

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-config/-reasoning-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
constructor(effort: ReasoningEffort? = null, summary: ReasoningSummary? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.ReasoningConfig.effort

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-config/effort.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val effort: ReasoningEffort?
```


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.ReasoningConfig

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-config/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable class ReasoningConfig(val effort: ReasoningEffort? = null, val summary: ReasoningSummary? = null)
```

Configuration options for reasoning models.


Referenced packages: `ai.koog.prompt.executor.clients.openai.base.models`.

## ai.koog.prompt.executor.clients.openai.models.ReasoningConfig.summary

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-config/summary.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val summary: ReasoningSummary?
```

## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary.AUTO

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/-a-u-t-o/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "auto") AUTO
```

## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary.CONCISE

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/-c-o-n-c-i-s-e/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "concise") CONCISE
```

## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary.DETAILED

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/-d-e-t-a-i-l-e-d/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "detailed") DETAILED
```

## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary.entries

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val entries: EnumEntries<ReasoningSummary>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable enum ReasoningSummary : Enum<ReasoningSummary>
```

Represents different levels of reasoning summary that can be used to specify the desired detail in responses.

The levels include:

AUTO: Automatically determines the level of reasoning detail.

CONCISE: Provides a brief and to-the-point reasoning.

DETAILED: Provides extensive and thorough reasoning.

## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary.valueOf

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun valueOf(value: String): ReasoningSummary
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.models.ReasoningSummary.values

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-reasoning-summary/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun values(): Array<ReasoningSummary>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.models.TextVerbosity.HIGH

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/-h-i-g-h/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "high") HIGH
```

## ai.koog.prompt.executor.clients.openai.models.TextVerbosity.LOW

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/-l-o-w/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "low") LOW
```

## ai.koog.prompt.executor.clients.openai.models.TextVerbosity.MEDIUM

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/-m-e-d-i-u-m/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "medium") MEDIUM
```

## ai.koog.prompt.executor.clients.openai.models.TextVerbosity.entries

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val entries: EnumEntries<TextVerbosity>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.models.TextVerbosity

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable enum TextVerbosity : Enum<TextVerbosity>
```

Represents the verbosity level for text output.

The verbosity levels determine the amount of detail included in the text.

## ai.koog.prompt.executor.clients.openai.models.TextVerbosity.valueOf

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun valueOf(value: String): TextVerbosity
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.models.TextVerbosity.values

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-text-verbosity/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun values(): Array<TextVerbosity>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.openai.models.Truncation.AUTO

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-truncation/-a-u-t-o/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "auto") AUTO
```

## ai.koog.prompt.executor.clients.openai.models.Truncation.DISABLED

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-truncation/-d-i-s-a-b-l-e-d/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@SerialName(value = "disabled") DISABLED
```

## ai.koog.prompt.executor.clients.openai.models.Truncation.entries

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-truncation/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
val entries: EnumEntries<Truncation>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.openai.models.Truncation

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-truncation/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
@Serializable enum Truncation : Enum<Truncation>
```

Represents the truncation behavior for processing inputs.

This enum defines the following modes:

AUTO: Automatically handles truncation of inputs based on predefined logic.

DISABLED: Disables truncation, requiring inputs to fit within allowed limits.

## ai.koog.prompt.executor.clients.openai.models.Truncation.valueOf

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-truncation/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun valueOf(value: String): Truncation
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.openai.models.Truncation.values

Module: `prompt-executor-openai-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-openai-client/ai.koog.prompt.executor.clients.openai.models/-truncation/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-openai-client/commonMain

```kotlin
fun values(): Array<Truncation>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.
