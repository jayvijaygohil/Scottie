# prompt / prompt-executor / prompt-executor-clients / prompt-executor-ollama-client

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt.FitPrompt

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/-fit-prompt.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
constructor(promptTokenizer: PromptTokenizer? = null, contextChunkSize: Long = 2048, minimumChunkCount: Long? = null, maximumChunkCount: Long? = null)
```

- promptTokenizer — The PromptTokenizer to use for computing the prompt length, or null to use the last reported token usage.
- contextChunkSize — The granularity to use for computing the context window length. Defaults to 2048.
- minimumChunkCount — The minimum number of context chunks in the context.
- maximumChunkCount — The maximum number of context chunks in the context.Example: contextChunkSize = 512, minimumChunkCount = 2, maximumChunkCount = 4, then minimumContextLength = 1024 and maximumContextLength = 2048

Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt.computeContextLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/compute-context-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun computeContextLength(prompt: Prompt, model: LLModel): Long?
```

Computes the context length for a given prompt and language model. This may involve calculating the number of tokens used in the prompt and determining if it fits within the model's context length constraints.

The context length as a Long, indicating the number of tokens used in the prompt, or null if it cannot be calculated.

- prompt — The Prompt containing the list of messages, unique identifier, and language model parameters that describe the input for the LLM.
- model — The LLModel representing the language model used to process the prompt, which includes its provider, identifier, capabilities, and context length.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt.contextChunkSize

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/context-chunk-size.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val contextChunkSize: Long
```

- contextChunkSize — The granularity to use for computing the context window length. Defaults to 2048.
## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
data class FitPrompt(val promptTokenizer: PromptTokenizer? = null, val contextChunkSize: Long = 2048, val minimumChunkCount: Long? = null, val maximumChunkCount: Long? = null) : ContextWindowStrategy
```

A strategy for computing the context window length based on the prompt length.

- promptTokenizer — The PromptTokenizer to use for computing the prompt length, or null to use the last reported token usage.
- contextChunkSize — The granularity to use for computing the context window length. Defaults to 2048.
- minimumChunkCount — The minimum number of context chunks in the context.
- maximumChunkCount — The maximum number of context chunks in the context.Example: contextChunkSize = 512, minimumChunkCount = 2, maximumChunkCount = 4, then minimumContextLength = 1024 and maximumContextLength = 2048

Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt.maximumChunkCount

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/maximum-chunk-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val maximumChunkCount: Long?
```

- maximumChunkCount — The maximum number of context chunks in the context.Example: contextChunkSize = 512, minimumChunkCount = 2, maximumChunkCount = 4, then minimumContextLength = 1024 and maximumContextLength = 2048
## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt.minimumChunkCount

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/minimum-chunk-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val minimumChunkCount: Long?
```

- minimumChunkCount — The minimum number of context chunks in the context.
## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.FitPrompt.promptTokenizer

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fit-prompt/prompt-tokenizer.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val promptTokenizer: PromptTokenizer?
```

- promptTokenizer — The PromptTokenizer to use for computing the prompt length, or null to use the last reported token usage.

Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.Fixed.Fixed

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fixed/-fixed.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
constructor(contextLength: Long)
```

- contextLength — The context window length to use.
## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.Fixed.computeContextLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fixed/compute-context-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun computeContextLength(prompt: Prompt, model: LLModel): Long
```

Computes the context length for a given prompt and language model. This may involve calculating the number of tokens used in the prompt and determining if it fits within the model's context length constraints.

The context length as a Long, indicating the number of tokens used in the prompt, or null if it cannot be calculated.

- prompt — The Prompt containing the list of messages, unique identifier, and language model parameters that describe the input for the LLM.
- model — The LLModel representing the language model used to process the prompt, which includes its provider, identifier, capabilities, and context length.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.Fixed.contextLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fixed/context-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val contextLength: Long
```

- contextLength — The context window length to use.
## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.Fixed

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-fixed/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
data class Fixed(val contextLength: Long) : ContextWindowStrategy
```

A strategy for specifying a fixed context window length. If the given contextLength is more than the maximum context window length supported by the model, the context window length will be set to the maximum context window length supported by the model.

- contextLength — The context window length to use.
## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.None.computeContextLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-none/compute-context-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun computeContextLength(prompt: Prompt, model: LLModel): Long?
```

Computes the context length for a given prompt and language model. This may involve calculating the number of tokens used in the prompt and determining if it fits within the model's context length constraints.

The context length as a Long, indicating the number of tokens used in the prompt, or null if it cannot be calculated.

- prompt — The Prompt containing the list of messages, unique identifier, and language model parameters that describe the input for the LLM.
- model — The LLModel representing the language model used to process the prompt, which includes its provider, identifier, capabilities, and context length.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion.None

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/-none/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
data object None : ContextWindowStrategy
```

A strategy for letting the Ollama server decide the context window length. To decide the context window length, Ollama proceeds as follows:

If the model definition contains a num_ctx parameter, the context window length is set to that value.

If an OLLAMA_CONTEXT_LENGTH environment variable is set, the context window length is set to that value.

Otherwise, the context window length is set to the default value of 2048.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.Companion

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Companion
```

Provides companion object-related strategies for determining the context window length. It contains multiple strategies that are implemented as subtypes of ContextWindowStrategy.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy.computeContextLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/compute-context-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
abstract fun computeContextLength(prompt: Prompt, model: LLModel): Long?
```

Computes the context length for a given prompt and language model. This may involve calculating the number of tokens used in the prompt and determining if it fits within the model's context length constraints.

The context length as a Long, indicating the number of tokens used in the prompt, or null if it cannot be calculated.

- prompt — The Prompt containing the list of messages, unique identifier, and language model parameters that describe the input for the LLM.
- model — The LLModel representing the language model used to process the prompt, which includes its provider, identifier, capabilities, and context length.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.ContextWindowStrategy

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-context-window-strategy/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
interface ContextWindowStrategy
```

Represents a strategy for computing the context window length for OllamaClient. Different implementations define specific approaches to computing the context window length. Based on the context window length computed by this strategy, Ollama will truncate the context window accordingly.

To decide the context window length, Ollama proceeds as follows:

If a num_ctx parameter is specified in the chat request, the context window length is set to that value.

If the model definition contains a num_ctx parameter, the context window length is set to that value.

If an OLLAMA_CONTEXT_LENGTH environment variable is set, the context window length is set to that value.

Otherwise, the context window length is set to the default value of 2048.

Effectively, this strategy allows you to specify what num_ctx value will be set in chat requests sent to Ollama, for a given prompt and model.

Important: You will want to have a context window length that does not change often for a specific model. Indeed, Ollama will reload the model every time the context window length changes.

Example implementations:

ContextWindowStrategy.None

ContextWindowStrategy.Fixed

ContextWindowStrategy.FitPrompt

- None
- Fixed
- FitPrompt
## ai.koog.prompt.executor.ollama.client.OllamaCustomModelConverters

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-custom-model-converters/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object OllamaCustomModelConverters
```

Custom converters for specific Ollama models.

## ai.koog.prompt.executor.ollama.client.OllamaCustomModelConverters.qwq

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-custom-model-converters/qwq.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
fun qwq(response: String): String
```

Processes responses from the QWQ model by removing any content between and tags.

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.capabilities

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/capabilities.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val capabilities: List<LLMCapability>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.contextLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/context-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val contextLength: Long?
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.embeddingLength

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/embedding-length.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val embeddingLength: Long?
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.families

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/families.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val families: List<String>?
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.family

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/family.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val family: String
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
class OllamaModelCard
```

Represents metadata and configuration details about an Ollama model card. This class contains descriptive properties about the model, such as its name, family of models it belongs to, capabilities it supports, and specific technical attributes like parameter count and size.

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.name

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.parameterCount

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/parameter-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val parameterCount: Long?
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.quantizationLevel

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/quantization-level.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val quantizationLevel: String?
```

## ai.koog.prompt.executor.ollama.client.OllamaModelCard.size

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-model-card/size.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val size: Long
```

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWEN_CODER_2_5_32B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-e-n_-c-o-d-e-r_2_5_32-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWEN_CODER_2_5_32B: LLModel
```

Represents the Alibaba Qwen-Coder model version 2.5 with 32 billion parameters.

This predefined instance of LLModel is provided by Alibaba and supports the following capabilities:

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Schema.JSON.Basic: Supports tasks requiring JSON schema validation and handling in a simplified manner.

Tools: Enables interaction with external tools or functionalities within the model's ecosystem.

The model is identified by the unique ID "qwen2.5-coder:32b" and categorized under the Ollama provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWEN_2_5_05B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-e-n_2_5_05-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWEN_2_5_05B: LLModel
```

Represents the Qwen-2.5 model with 0.5 billion parameters.

This predefined instance of LLModel is provided by Alibaba and supports the following capabilities:

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Schema.JSON.Basic: Supports tasks requiring JSON schema validation and handling in a simplified manner.

Tools: Enables interaction with external tools or functionalities within the model's ecosystem.

The model is identified by the unique ID "qwen2.5:0.5b" and categorized under the Ollama provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWEN_3_06B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-e-n_3_06-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWEN_3_06B: LLModel
```

Represents the Qwen-3.06b model with 0.6 billion parameters.

This predefined instance of LLModel is provided by Alibaba and supports the following capabilities:

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Schema.JSON.Basic: Supports tasks requiring JSON schema validation and handling in a simplified manner.

Tools: Enables interaction with external tools or functionalities within the model's ecosystem.

The model is identified by the unique ID "qwen3:0.6b" and categorized under the Ollama provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWEN_3_5_9B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-e-n_3_5_9-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWEN_3_5_9B: LLModel
```

Represents the Alibaba Qwen 3.5 open-source multimodal model with 9 billion parameters.

This predefined instance of LLModel is provided by Alibaba and supports the following capabilities:

Schema.JSON.Basic: Supports tasks requiring JSON schema validation and handling in a simplified manner.

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Thinking: Represents the thinking/reasoning capability of a language model.

ToolChoice: Represents how tools calling can be configured for the LLM.

Tools: Enables interaction with external tools or functionalities within the model's ecosystem.

Vision.Image: Enables processing and understanding of image inputs alongside text.

The model is identified by the unique ID "qwen3.5:9b" and categorized under the Ollama provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWEN_3_6_27B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-e-n_3_6_27-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWEN_3_6_27B: LLModel
```

Represents the Alibaba Qwen 3.6 dense model with 27 billion parameters.

A strong single-GPU model for agentic coding and general work, outperforming much larger MoE models on agentic coding benchmarks.

Supported capabilities:

Schema.JSON.Basic: Supports JSON schema-based tasks.

Temperature: Allows adjustment of the temperature setting.

Thinking: Represents the thinking/reasoning capability of the model.

ToolChoice: Represents how tools calling can be configured for the LLM.

Tools: Enables interaction with external tools.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWEN_3_8_27B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-e-n_3_8_27-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWEN_3_8_27B: LLModel
```

Represents the Alibaba Qwen 3.8 open-weight multimodal model with 27 billion parameters.

Supported capabilities:

Schema.JSON.Basic: Supports JSON schema-based tasks.

Temperature: Allows adjustment of the temperature setting.

Thinking: Represents the thinking/reasoning capability of the model.

ToolChoice: Represents how tools calling can be configured for the LLM.

Tools: Enables interaction with external tools.

Vision.Image: Enables processing and understanding of image inputs alongside text.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWQ

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-q.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWQ: LLModel
```

Represents the QWQ language model instance provided by Alibaba with specific capabilities.

The model is identified by its unique id "qwq". It belongs to the Ollama provider and supports multiple advanced capabilities:

Temperature Adjustment: Enables control over the randomness of the model's output.

JSON Schema (Basic): Supports tasks structured through basic JSON schemas.

Tools Usage: Allows the model to interact with external tools for extended functionality.

Use this configuration to interact with the Alibaba QWQ model in applications that require these capabilities for varied and advanced tasks.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba.QWQ_32B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/-q-w-q_32-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val QWQ_32B: LLModel
```

Represents the QWQ model with 32 billion parameters.

This predefined instance of LLModel is provided by Alibaba and supports the following capabilities:

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Schema.JSON.Basic: Supports tasks requiring JSON schema validation and handling in a simplified manner.

Tools: Enables interaction with external tools or functionalities within the model's ecosystem.

The model is identified by the unique ID "qwq:32b" and categorized under the Ollama provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Alibaba

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-alibaba/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Alibaba
```

Represents an object that contains predefined Large Language Models (LLMs) made by Alibaba.

The Alibaba object provides access to multiple LLM instances, each with specific identifiers and capabilities. These models are configured with Ollama as the provider and are characterized by their unique capabilities.

## ai.koog.prompt.executor.ollama.client.OllamaModels.DeepSeek.DEEPSEEK_R1_DISTILL_LLAMA_1_5B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-deep-seek/-d-e-e-p-s-e-e-k_-r1_-d-i-s-t-i-l-l_-l-l-a-m-a_1_5-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val DEEPSEEK_R1_DISTILL_LLAMA_1_5B: LLModel
```

Represents the DeepSeek-R1-Distill-Llama-1.5B model.

This is a distilled version of DeepSeek-R1 based on Llama with 1.5B parameters. The model supports thinking/reasoning capability, which allows it to generate internal reasoning traces before providing the final answer through the thinking field in responses.

Supported capabilities:

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Schema.JSON.Basic: Supports JSON schema-based tasks.

Tools: Enables interaction with external tools.

- DeepSeek-R1 on Ollama

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.DeepSeek

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-deep-seek/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object DeepSeek
```

The DeepSeek object represents the configuration for DeepSeek large language models (LLMs). It contains the predefined model specifications for DeepSeek's LLMs, including their identifiers and supported capabilities.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Embeddings.ALL_MINI_LM

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-embeddings/-a-l-l_-m-i-n-i_-l-m.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val ALL_MINI_LM: LLModel
```

All MiniLM embedding model, a lightweight and efficient model.

Parameters: 33M Dimensions: 384 Context Length: 512 Performance: Fast inference with good quality for general text embeddings Tradeoffs: Smaller model size with reduced context length, but very efficient


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Embeddings.BGE_LARGE

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-embeddings/-b-g-e_-l-a-r-g-e.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val BGE_LARGE: LLModel
```

BGE Large embedding model, optimized for English text.

Parameters: 335M Dimensions: 1024 Context Length: 512 Performance: Excellent for English text retrieval and semantic search Tradeoffs: Larger model size but provides high-quality embeddings


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Embeddings.MULTILINGUAL_E5

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-embeddings/-m-u-l-t-i-l-i-n-g-u-a-l_-e5.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val MULTILINGUAL_E5: LLModel
```

Multilingual E5 embedding model, supports multiple languages.

Parameters: 300M Dimensions: 768 Context Length: 512 Performance: Strong performance across 100+ languages Tradeoffs: Larger model size but provides excellent multilingual capabilities


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Embeddings.MXBAI_EMBED_LARGE

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-embeddings/-m-x-b-a-i_-e-m-b-e-d_-l-a-r-g-e.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val MXBAI_EMBED_LARGE: LLModel
```

Represents the model ID for the MXBAI Embed Large model.

This model ID identifies the "mxbai-embed-large" embedding configuration within the Ollama framework, which is designed for creating high-dimensional embeddings of textual data.

It can be used in components that require referencing or interacting with this specific model configuration.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Embeddings.NOMIC_EMBED_TEXT

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-embeddings/-n-o-m-i-c_-e-m-b-e-d_-t-e-x-t.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val NOMIC_EMBED_TEXT: LLModel
```

Nomic's text embedding model, optimized for text embeddings. A good general-purpose embedding model.

Parameters: 137M Dimensions: 768 Context Length: 8192 Performance: High-quality embeddings for semantic search and text similarity tasks Tradeoffs: Balanced between quality and efficiency


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Embeddings

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-embeddings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Embeddings
```

Ollama embedding models.

Models are sourced from https://ollama.com/blog/embedding-models and other official Ollama resources. Each model has a specific purpose and performance characteristics.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Granite.GRANITE_3_2_VISION

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-granite/-g-r-a-n-i-t-e_3_2_-v-i-s-i-o-n.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val GRANITE_3_2_VISION: LLModel
```

Represents the Granite 3.2 Vision model.

This predefined instance of LLModel is provided by Granite and supports the following capabilities:

Temperature: Allows adjustment of the temperature setting for controlling the randomness in responses.

Schema.JSON.Basic: Supports tasks requiring JSON schema validation and handling in a simplified manner.

Tools: Enables interaction with external tools or functionalities within the model's ecosystem.

Vision.Image: Enables processing and understanding of image inputs alongside text.

The model is identified by the unique ID "granite3.2-vision" and categorized under the Ollama provider. It is designed to handle both text and visual inputs for multimodal tasks.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Granite

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-granite/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Granite
```

The Granite object represents the configuration for Granite large language models (LLMs). It contains the predefined model specifications for Granite LLMs, including their identifiers and supported capabilities.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Groq.LLAMA_3_GROK_TOOL_USE_70B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-groq/-l-l-a-m-a_3_-g-r-o-k_-t-o-o-l_-u-s-e_70-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val LLAMA_3_GROK_TOOL_USE_70B: LLModel
```

Represents the LLAMA version 3.0 model provided by Groq with 70B parameters.

This variable defines an instance of the LLModel class with the Ollama provider, a unique identifier "llama3", and a set of capabilities. The supported capabilities include:

Temperature adjustment.

JSON Schema-based tasks (Not very clear).

Tool utilization.

LLAMA 3 is designed to support these specified features, enabling developers to utilize the model for tasks that require dynamic behavior adjustments, schema adherence, and tool-based interactions.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Groq.LLAMA_3_GROK_TOOL_USE_8B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-groq/-l-l-a-m-a_3_-g-r-o-k_-t-o-o-l_-u-s-e_8-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val LLAMA_3_GROK_TOOL_USE_8B: LLModel
```

Represents the LLAMA version 3.0 model provided by Groq with 8B parameters.

This variable defines an instance of the LLModel class with the Ollama provider, a unique identifier "llama3", and a set of capabilities. The supported capabilities include:

Temperature adjustment.

JSON Schema-based tasks (Not very clear).

Tool utilization.

LLAMA 3 is designed to support these specified features, enabling developers to utilize the model for tasks that require dynamic behavior adjustments, schema adherence, and tool-based interactions.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Groq

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-groq/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Groq
```

The Groq object represents the configuration for the Groq large language model (LLM). It contains the predefined model specifications for Groq's LLMs, including their identifiers and supported capabilities.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta.LLAMA_GUARD_3

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/-l-l-a-m-a_-g-u-a-r-d_3.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val LLAMA_GUARD_3: LLModel
```

Represents the llama-guard model version3 provided by Meta.

The llama-guard collection of models is natively multimodal AI models that enable text and multimodal experiences. These two models leverage a mixture-of-experts (MoE) architecture and support native multimodality (image input).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta.LLAMA_3_2

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/-l-l-a-m-a_3_2.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val LLAMA_3_2: LLModel
```

Represents the latest LLAMA version 3.2 model provided by Meta.

This variable defines an instance of the LLModel class with the Ollama provider, a unique identifier "llama3.2", and a set of capabilities. The supported capabilities include:

Temperature adjustment.

JSON Schema-based tasks (Basic Schema).

Tool utilization.

LLAMA 3.2 is designed to support these specified features, enabling developers to utilize the model for tasks that require dynamic behavior adjustments, schema adherence, and tool-based interactions.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta.LLAMA_3_2_3B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/-l-l-a-m-a_3_2_3-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val LLAMA_3_2_3B: LLModel
```

Represents the LLAMA version 3.2.3b model provided by Meta.

This variable defines an instance of the LLModel class with the Ollama provider, a unique identifier "llama3.2:3b", and a set of capabilities. The supported capabilities include:

Temperature adjustment.

JSON Schema-based tasks (Basic Schema).

Tool utilization.

LLAMA 3.2.3b is designed to support these specified features, enabling developers to utilize the model for tasks that require dynamic behavior adjustments, schema adherence, and tool-based interactions.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta.LLAMA_4

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/-l-l-a-m-a_4.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val LLAMA_4: LLModel
```

Represents the LLAMA version 4 model provided by Meta.

The LLAMA 4 collection of models is natively multimodal AI models that enable text and multimodal experiences. These two models leverage a mixture-of-experts (MoE) architecture and support native multimodality (image input).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta.LLAMA_4_LATEST

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/-l-l-a-m-a_4_-l-a-t-e-s-t.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val LLAMA_4_LATEST: LLModel
```

Represents the LLAMA version 4 model provided by Meta.

The LLAMA 4 collection of models is natively multimodal AI models that enable text and multimodal experiences. These two models leverage a mixture-of-experts (MoE) architecture and support native multimodality (image input).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta.LLAMA_4_SCOUT

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/-l-l-a-m-a_4_-s-c-o-u-t.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val LLAMA_4_SCOUT: LLModel
```

Represents the LLAMA version 4 model provided by Meta.

The LLAMA 4 collection of models is natively multimodal AI models that enable text and multimodal experiences. These two models leverage a mixture-of-experts (MoE) architecture and support native multimodality (image input).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.Meta

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-meta/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object Meta
```

The Meta object represents the configuration for the Meta large language models (LLMs). It contains the predefined model specifications for Meta's LLMs, including their identifiers and supported capabilities.

## ai.koog.prompt.executor.ollama.client.OllamaModels.OpenAI.GPT_OSS_20B

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-open-a-i/-g-p-t_-o-s-s_20-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
@JvmField val GPT_OSS_20B: LLModel
```

Represents the OpenAI gpt-oss model with 20 billion parameters.

It leverages a standard set of capabilities for interaction.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.OpenAI

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/-open-a-i/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object OpenAI
```

The OpenAI object represents the configuration for OpenAI large language models (LLMs). It contains the predefined model specifications for OpenAI LLMs, including their identifiers and supported capabilities.

## ai.koog.prompt.executor.ollama.client.OllamaModels.addCustomModel

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/add-custom-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun addCustomModel(model: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaModels

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
object OllamaModels : LLModelDefinitions
```

Represents a collection of predefined Large Language Models (LLM) categorized by makers. Each maker contains specific models with configurations such as unique identifiers and capabilities.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.ollama.client.OllamaModels.models

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-models/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override val models: List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.OllamaParams.OllamaParams

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/-ollama-params.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
constructor(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, think: Boolean? = null)
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.ollama.client.OllamaParams.copy

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/copy.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
fun copy(temperature: Double? = this.temperature, maxTokens: Int? = this.maxTokens, numberOfChoices: Int? = this.numberOfChoices, speculation: String? = this.speculation, schema: LLMParams.Schema? = this.schema, toolChoice: LLMParams.ToolChoice? = this.toolChoice, user: String? = this.user, additionalProperties: Map<String, JsonElement>? = this.additionalProperties, think: Boolean? = this.think): OllamaParams
```

Creates a copy of this instance with the ability to modify any of its properties.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.ollama.client.OllamaParams.equals

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/equals.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.executor.ollama.client.OllamaParams.hashCode

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/hash-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.executor.ollama.client.OllamaParams

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
class OllamaParams(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, val think: Boolean? = null) : LLMParams
```

Represents the parameters for configuring an Ollama Chat interaction with an LLM.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.ollama.client.OllamaParams.think

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/think.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val think: Boolean?
```

## ai.koog.prompt.executor.ollama.client.OllamaParams.toString

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/-ollama-params/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.ollama.client.findBestSuitedModels

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/find-best-suited-models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
fun List<OllamaModelCard>.findBestSuitedModels(family: String? = null, maxSize: Long? = null, minParameterCount: Long? = null, minContextLength: Long? = null, minEmbeddingLength: Long? = null, requiredCapabilities: List<LLMCapability>? = null): List<OllamaModelCard>
```

Filters a list of model cards by the given criteria.

- family — the family, or null if you don't want to filter by family
- maxSize — the maximum size, or null if you don't want to filter by size
- minParameterCount — the minimum parameter count, or null if you don't want to filter by parameter count
- minContextLength — the minimum context length, or null if you don't want to filter by context length
- minEmbeddingLength — the minimum embedding length, or null if you don't want to filter by embedding length
- requiredCapabilities — the required capabilities, or null if you don't want to filter by capabilities

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.client.findByNameOrNull

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/find-by-name-or-null.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
fun List<OllamaModelCard>.findByNameOrNull(name: String): OllamaModelCard?
```

Finds a model card by name.

## ai.koog.prompt.executor.ollama.client.nameWithoutTag

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/name-without-tag.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
val OllamaModelCard.nameWithoutTag: String
```

Returns the model name without any associated tags. This property extracts and provides a clean version of the name property from the OllamaModelCard by removing any tags or additional decorations.

## ai.koog.prompt.executor.ollama.client.toLLModel

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.client/to-l-l-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
fun OllamaModelCard.toLLModel(): LLModel
```

Converts an instance of OllamaModelCard to an LLModel representation.

This method maps the properties of the OllamaModelCard object to create a corresponding LLModel instance. It designates the provider as Ollama, sets the identifier as the model's name, and assigns the list of capabilities directly from the source model card.

A new LLModel instance based on the properties of the OllamaModelCard.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.ollama.tools.json.OllamaToolDescriptorSchemaGenerator.OllamaToolDescriptorSchemaGenerator

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.tools.json/-ollama-tool-descriptor-schema-generator/-ollama-tool-descriptor-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.ollama.tools.json.OllamaToolDescriptorSchemaGenerator.generate

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.tools.json/-ollama-tool-descriptor-schema-generator/generate.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
open override fun generate(toolDescriptor: ToolDescriptor): JsonObject
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.executor.ollama.tools.json.OllamaToolDescriptorSchemaGenerator

Module: `prompt-executor-ollama-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-ollama-client/ai.koog.prompt.executor.ollama.tools.json/-ollama-tool-descriptor-schema-generator/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-ollama-client/commonMain

```kotlin
class OllamaToolDescriptorSchemaGenerator : ToolDescriptorSchemaGenerator
```

Converts a list of ToolDescriptor objects into a JSON schema representation for Ollama.


Referenced packages: `ai.koog.agents.core.tools.serialization`.
