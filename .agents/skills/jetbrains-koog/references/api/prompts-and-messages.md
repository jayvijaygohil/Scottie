# Prompts, messages, caching controls, and streaming

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.prompt.llm.LLMCapability.Audio

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-audio/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Audio : LLMCapability
```

Represents a specialized capability for audio-related functionalities in the context of a LLM. This capability is used in models that can involving audio processing, such as transcription, audio generation, or audio-based interactions.

## ai.koog.prompt.llm.LLMCapability.Completion

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-completion/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Completion : LLMCapability
```

Represents the "completion" capability for Language Learning Models (LLMs). This capability typically encompasses the generation of text or content based on the given input context. It belongs to the LLMCapability sealed class hierarchy and is identifiable by the completion ID.

This capability can be utilized within an LLM to perform tasks such as completing a sentence, generating suggestions, or producing content that aligns with the given input data and context.

## ai.koog.prompt.llm.LLMCapability.Document

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-document/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Document : LLMCapability
```

Represents a specific language model capability associated with handling documents.

## ai.koog.prompt.llm.LLMCapability.Embed

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-embed/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Embed : LLMCapability
```

Represents the capability of generating embeddings within the context of language models.

The Embed capability allows models to process input text and generate vector embeddings, which are numerical representations of text that enable similarity comparisons, clustering, and other forms of vector-based analysis.

This capability can be utilized in tasks like semantic search, document clustering, or other operations requiring an understanding of textual similarity.

## ai.koog.prompt.llm.LLMCapability.Moderation

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-moderation/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Moderation : LLMCapability
```

Represents a capability in the Large Language Model (LLM) for content moderation.

This capability allows the model to analyze text for potentially harmful content and classify it according to various categories such as harassment, hate speech, self-harm, sexual content, violence, etc.

## ai.koog.prompt.llm.LLMCapability.MultipleChoices

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-multiple-choices/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object MultipleChoices : LLMCapability
```

Represents an LLM capability to generate multiple independent reply choices to a single prompt.

## ai.koog.prompt.llm.LLMCapability.OpenAIEndpoint.Completions

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-open-a-i-endpoint/-completions/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Completions : LLMCapability.OpenAIEndpoint
```

Represents the chat completion endpoint capability for an OpenAI-based LLM.

This capability identifies the chat completion-based interaction capability of OpenAI-based LLM. https://platform.openai.com/docs/api-reference/chat

## ai.koog.prompt.llm.LLMCapability.OpenAIEndpoint.Responses

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-open-a-i-endpoint/-responses/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable @ApiStatus.Experimental data object Responses : LLMCapability.OpenAIEndpoint
```

Represents the responses endpoint capability for an OpenAI-based LLM.

This capability identifies the response-based interaction capability of OpenAI-based LLM. https://platform.openai.com/docs/api-reference/responses

## ai.koog.prompt.llm.LLMCapability.OpenAIEndpoint.endpoint

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-open-a-i-endpoint/endpoint.html`

### :prompt:prompt-llm/commonMain

```kotlin
val endpoint: String
```

- endpoint — A string identifier representing the OpenAI endpoint's functionality.
## ai.koog.prompt.llm.LLMCapability.OpenAIEndpoint

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-open-a-i-endpoint/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable sealed class OpenAIEndpoint : LLMCapability
```

Represents an OpenAI-related API endpoint for Large Language Model (LLM) operations.

This sealed class serves as a specific capability type for OpenAI-based LLM. It provides predefined endpoints that correspond to specific functionalities, such as generating completions or accessing responses.

- endpoint — A string identifier representing the OpenAI endpoint's functionality.
- Completions
- Responses
## ai.koog.prompt.llm.LLMCapability.PromptCaching

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-prompt-caching/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object PromptCaching : LLMCapability
```

Represents a capability in the Large Language Model (LLM) for caching.

Use this capability to represent models that support caching functionalities.

## ai.koog.prompt.llm.LLMCapability.Schema.JSON.Basic

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-schema/-j-s-o-n/-basic/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Basic : LLMCapability.Schema.JSON
```

Represents a basic JSON schema support capability. Used to specify lightweight or fundamental JSON processing capabilities. This format primarily focuses on nested data definitions without advanced JSON Schema functionalities.

## ai.koog.prompt.llm.LLMCapability.Schema.JSON.Standard

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-schema/-j-s-o-n/-standard/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Standard : LLMCapability.Schema.JSON
```

Represents a standard JSON schema support capability, according to https://json-schema.org/. This format is a proper subset of the official JSON Schema specification.

## ai.koog.prompt.llm.LLMCapability.Schema.JSON

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-schema/-j-s-o-n/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable sealed class JSON : LLMCapability.Schema
```

Represents a sealed class defining JSON schema support as a part of an AI model's capability. Each subtype of this class specifies a distinct level of JSON support.

- Basic
- Standard
## ai.koog.prompt.llm.LLMCapability.Schema.JSON.support

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-schema/-j-s-o-n/support.html`

### :prompt:prompt-llm/commonMain

```kotlin
val support: String
```

## ai.koog.prompt.llm.LLMCapability.Schema

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-schema/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable sealed class Schema : LLMCapability
```

Represents a structured schema capability for a language model. The schema defines certain characteristics or functionalities related to data interaction and encoding using specific formats.

This class is designed to encapsulate different schema configurations that the language model can support, such as JSON processing.

- JSON
## ai.koog.prompt.llm.LLMCapability.Schema.lang

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-schema/lang.html`

### :prompt:prompt-llm/commonMain

```kotlin
val lang: String
```

## ai.koog.prompt.llm.LLMCapability.Speculation

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-speculation/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Speculation : LLMCapability
```

Represents the capability of the language model to perform speculative responses. This capability allows the model to generate responses with varying degrees of likelihood, often used for exploratory or hypothetical scenarios.

Speculation may be beneficial in situations where creative or less deterministic answers are preferred, providing a broader range of potential outcomes.

## ai.koog.prompt.llm.LLMCapability.Temperature

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-temperature/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Temperature : LLMCapability
```

Represents the temperature capability of a language model.

This capability is utilized to adjust the model's response randomness or creativity levels. Higher temperature values typically produce more diverse outputs, while lower values lead to more focused and deterministic responses.

Belongs to the LLMCapability sealed class hierarchy, which defines various features and behaviors supported by language models.

## ai.koog.prompt.llm.LLMCapability.Thinking

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-thinking/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Thinking : LLMCapability
```

Represents the thinking/reasoning capability of a language model.

This capability indicates that the model supports exposing its chain-of-thought reasoning and uses thought signatures to maintain reasoning context across multi-step interactions. Models with this capability may require thought_signature in function calls.

Examples: Gemini 3.0 models, o1-series models.

## ai.koog.prompt.llm.LLMCapability.ToolChoice

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-tool-choice/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object ToolChoice : LLMCapability
```

Represents how tools calling can be configured for the LLM.

Depending on the LLM, will configure it to generate:

Automatically choose to generate either text or tool call

Generate only tool calls, never text

Generate only text, never tool calls

Force to call one specific tool among the defined tools

## ai.koog.prompt.llm.LLMCapability.Tools

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-tools/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Tools : LLMCapability
```

Represents the capability of tools within the LLM capability hierarchy.

The Tools capability is typically used to indicate support for external tool usage or interaction by a language model. This can include functionalities such as executing specific tools or integrating with external systems. It is a predefined constant within the set of capabilities available for an LLModel.

Use this capability to specify or check tool interaction abilities in a model's configuration.

## ai.koog.prompt.llm.LLMCapability.Vision.Image

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-vision/-image/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Image : LLMCapability.Vision
```

Represents a specific capability for handling image-related vision tasks within a large language model (LLM).

This class is a concrete implementation of the Vision sealed class, focusing on tasks such as image analysis, recognition, and interpretation. It is designed to enable models with the ability to process and infer insights from visual data represented as static images.

The Image capability is typically used in scenarios where the model's functionality includes understanding image content, performing image-to-text generation, or tasks that require visual comprehension.

## ai.koog.prompt.llm.LLMCapability.Vision.Video

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-vision/-video/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data object Video : LLMCapability.Vision
```

Represents the video processing capability within vision-based tasks.

This capability is used to handle video-related functionalities, including analyzing and processing video data. It is part of the sealed hierarchy for vision-based capabilities and provides a concrete implementation specific to video inputs.

## ai.koog.prompt.llm.LLMCapability.Vision

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-vision/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable sealed class Vision : LLMCapability
```

Represents a large language model (LLM) capability associated with vision-based tasks. This capability is typically used in models that can process, analyze, and infer insights from visual data or visual representations.

- Image
- Video
## ai.koog.prompt.llm.LLMCapability.Vision.visionType

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/-vision/vision-type.html`

### :prompt:prompt-llm/commonMain

```kotlin
val visionType: String
```

## ai.koog.prompt.llm.LLMCapability.id

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/id.html`

### :prompt:prompt-llm/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.llm.LLMCapability

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-capability/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable sealed class LLMCapability
```

Represents a specific capability or feature of an LLM (Large Language Model). This is a sealed class, where each capability is represented as a subclass or data object.

- Speculation
- Temperature
- Tools
- ToolChoice
- MultipleChoices
- Vision
- Audio
- Document
- Embed
- Completion
- PromptCaching
- Moderation
- Thinking
- Schema
- OpenAIEndpoint
## ai.koog.prompt.llm.LLMProvider.Companion.Alibaba

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-alibaba.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Alibaba: AlibabaLLMProvider
```

Represents the Alibaba Large Language Model (LLM) provider.

This constant is part of the available LLM providers within the system and is used to signify the selection or identification of the Alibaba LLM within model configurations or operations.

## ai.koog.prompt.llm.LLMProvider.Companion.Anthropic

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-anthropic.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Anthropic: AnthropicLLMProvider
```

Represents the Anthropic Large Language Model (LLM) provider.

This value is used to identify and work with the Anthropic LLM implementation within the system. Anthropic is one of the predefined providers for managing Large Language Models and their associated operations.

## ai.koog.prompt.llm.LLMProvider.Companion.Azure

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-azure.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Azure: AzureLLMProvider
```

Represents the Azure OpenAI provider.

## ai.koog.prompt.llm.LLMProvider.Companion.Bedrock

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-bedrock.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Bedrock: BedrockLLMProvider
```

Represents the Bedrock provider for Large Language Models (LLMs).

This constant is part of the LLMProvider enumeration and is used to specify the Bedrock LLM service. It can be utilized to identify or configure functionality specific to the Bedrock provider.

## ai.koog.prompt.llm.LLMProvider.Companion.DeepSeek

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-deep-seek.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val DeepSeek: DeepSeekLLMProvider
```

Represents the DeepSeek LLM provider, a predefined member of the LLMProvider class.

DeepSeek is a specific implementation or configuration of a large language model (LLM), designed to handle advanced queries with precision and extended capabilities. It can be used to identify, execute, or assist in tasks requiring substantial context understanding.

## ai.koog.prompt.llm.LLMProvider.Companion.Google

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-google.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Google: GoogleLLMProvider
```

Represents the Google provider for Large Language Models (LLMs).

This constant is used as a predefined identifier within the LLMProvider class to specify that the associated LLM is provided by Google. It is commonly used to differentiate between various LLM providers when configuring or selecting an LLM instance.

## ai.koog.prompt.llm.LLMProvider.Companion.HuggingFace

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-hugging-face.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val HuggingFace: HuggingFaceLLMProvider
```

Represents the Hugging Face Large Language Model provider.

## ai.koog.prompt.llm.LLMProvider.Companion.Meta

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-meta.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Meta: MetaLLMProvider
```

Represents the Meta large language model (LLM) provider.

This value is a predefined instance of LLMProvider specifically for the Meta provider. It can be used to configure or interact with Meta-based language models.

## ai.koog.prompt.llm.LLMProvider.Companion.MiniMax

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-mini-max.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val MiniMax: MiniMaxLLMProvider
```

Represents the MiniMax Large Language Model provider.

## ai.koog.prompt.llm.LLMProvider.Companion.MistralAI

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-mistral-a-i.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val MistralAI: MistralAILLMProvider
```

Represents the MistralAI Large Language Model (LLM) provider.

This constant identifies the MistralAI LLM provider, which can be used to configure and interact with instances of MistralAI language models in the system.

## ai.koog.prompt.llm.LLMProvider.Companion.OCI

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-o-c-i.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val OCI: OCILLMProvider
```

Represents the Oracle Cloud Infrastructure (OCI) Generative AI provider.

## ai.koog.prompt.llm.LLMProvider.Companion.Ollama

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-ollama.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Ollama: OllamaLLMProvider
```

Represents the Ollama provider for a Large Language Model (LLM).

This constant is a predefined instance of LLMProvider representing the Ollama provider. It can be used to specify or identify the provider associated with an LLM instance.

## ai.koog.prompt.llm.LLMProvider.Companion.OpenAI

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-open-a-i.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val OpenAI: OpenAILLMProvider
```

Represents the OpenAI provider instance of the Large Language Model (LLM).

This constant identifies the provider as OpenAI and is used to distinguish between different LLM providers within the system.

## ai.koog.prompt.llm.LLMProvider.Companion.OpenRouter

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-open-router.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val OpenRouter: OpenRouterLLMProvider
```

Represents the OpenRouter provider for large language models (LLMs). This constant is part of the available LLM providers within the LLMProvider enumeration.

## ai.koog.prompt.llm.LLMProvider.Companion.Vertex

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-vertex.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val Vertex: VertexLLMProvider
```

Represents the Google VertexAI provider.

## ai.koog.prompt.llm.LLMProvider.Companion.ZhipuAI

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/-zhipu-a-i.html`

### :prompt:prompt-llm/commonMain

```kotlin
@JvmField val ZhipuAI: ZhipuAILLMProvider
```

Represents the ZhipuAI (智谱AI) Large Language Model provider.

## ai.koog.prompt.llm.LLMProvider.Companion

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-companion/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
object Companion
```

Companion object for the LLMProvider class, providing predefined instances of large language model providers.

The companion object acts as a container for multiple constant providers, allowing standardized access to specific implementations of LLM providers.

## ai.koog.prompt.llm.LLMProvider.LLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/-l-l-m-provider.html`

### :prompt:prompt-llm/commonMain

```kotlin
constructor(id: String, display: String)
```

## ai.koog.prompt.llm.LLMProvider.display

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/display.html`

### :prompt:prompt-llm/commonMain

```kotlin
val display: String
```

## ai.koog.prompt.llm.LLMProvider.id

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/id.html`

### :prompt:prompt-llm/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.llm.LLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable open class LLMProvider(val id: String, val display: String)
```

Represents a sealed hierarchy for defining Large Language Model (LLM) providers. Each LLM provider is uniquely identified by an id and a display name.

This sealed class allows enumeration of specific providers like Google, OpenAI, Meta, etc., and serves as a common base type for handling providers within the system.

- GoogleLLMProvider
- OpenAILLMProvider
- AnthropicLLMProvider
- MetaLLMProvider
- AlibabaLLMProvider
- OpenRouterLLMProvider
- OllamaLLMProvider
- BedrockLLMProvider
- DeepSeekLLMProvider
- MistralAILLMProvider
- OCILLMProvider
- MiniMaxLLMProvider
- ZhipuAILLMProvider
- HuggingFaceLLMProvider
- AzureLLMProvider
- VertexLLMProvider
## ai.koog.prompt.llm.LLModel.LLModel

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/-l-l-model.html`

### :prompt:prompt-llm/commonMain

```kotlin
constructor(provider: LLMProvider, id: String, capabilities: List<LLMCapability>? = null, contextLength: Long? = null, maxOutputTokens: Long? = null)
```

## ai.koog.prompt.llm.LLModel.capabilities

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/capabilities.html`

### :prompt:prompt-llm/commonMain

```kotlin
val capabilities: List<LLMCapability>?
```

## ai.koog.prompt.llm.LLModel.contextLength

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/context-length.html`

### :prompt:prompt-llm/commonMain

```kotlin
val contextLength: Long?
```

## ai.koog.prompt.llm.LLModel.id

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/id.html`

### :prompt:prompt-llm/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.llm.LLModel

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable data class LLModel constructor(val provider: LLMProvider, val id: String, val capabilities: List<LLMCapability>? = null, val contextLength: Long? = null, val maxOutputTokens: Long? = null)
```

Represents a Large Language Model (LLM) with a specific provider, identifier, and a set of capabilities.

## ai.koog.prompt.llm.LLModel.maxOutputTokens

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/max-output-tokens.html`

### :prompt:prompt-llm/commonMain

```kotlin
val maxOutputTokens: Long?
```

## ai.koog.prompt.llm.LLModel.provider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/provider.html`

### :prompt:prompt-llm/commonMain

```kotlin
val provider: LLMProvider
```

## ai.koog.prompt.llm.LLModel.supports

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-model/supports.html`

### :prompt:prompt-llm/commonMain

```kotlin
fun supports(capability: LLMCapability): Boolean
```

Checks if the Large Language Model (LLM) supports a specific capability.

true if the LLM supports the given capability, otherwise false.

- capability — The capability to check for, represented by an instance of LLMCapability.
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.LineContext

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/-line-context.html`

### :prompt:prompt-markdown/commonMain

```kotlin
constructor(builder: TextContentBuilder = TextContentBuilder())
```


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.bold

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/bold.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun bold(text: String): MarkdownContentBuilder.LineContext
```

Adds bold text (text) to the line.

This context for method chaining

- text — The text to make bold
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.code

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/code.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun code(code: String): MarkdownContentBuilder.LineContext
```

Adds a code span (code) to the line.

This context for method chaining

- code — The code to add
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.image

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/image.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun image(alt: String, url: String): MarkdownContentBuilder.LineContext
```

Adds an image () to the line.

This context for method chaining

- alt — The image alt text
- url — The image URL
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/index.html`

### :prompt:prompt-markdown/commonMain

```kotlin
class LineContext(builder: TextContentBuilder = TextContentBuilder())
```

Context for building a single line of markdown with mixed formatting elements. Used within the line method to create complex inline formatting.

All methods return the context itself to allow for method chaining.


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.italic

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/italic.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun italic(text: String): MarkdownContentBuilder.LineContext
```

Adds italic text (text) to the line.

This context for method chaining

- text — The text to make italic
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.link

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/link.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun link(text: String, url: String): MarkdownContentBuilder.LineContext
```

Adds a link (text) to the line.

This context for method chaining

- text — The link text
- url — The link URL
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.space

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/space.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun space(): MarkdownContentBuilder.LineContext
```

Adds a space to the line.

This context for method chaining

## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.strikethrough

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/strikethrough.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun strikethrough(text: String): MarkdownContentBuilder.LineContext
```

Adds strikethrough text (text) to the line.

This context for method chaining

- text — The text to strikethrough
## ai.koog.prompt.markdown.MarkdownContentBuilder.LineContext.text

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-line-context/text.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun text(text: String): MarkdownContentBuilder.LineContext
```

Adds plain text to the line.

This context for method chaining

- text — The text to add
## ai.koog.prompt.markdown.MarkdownContentBuilder.ListContext.ListContext

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-list-context/-list-context.html`

### :prompt:prompt-markdown/commonMain

```kotlin
constructor(bullet: (counter: Int) -> String)
```

## ai.koog.prompt.markdown.MarkdownContentBuilder.ListContext

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-list-context/index.html`

### :prompt:prompt-markdown/commonMain

```kotlin
inner class ListContext(bullet: (counter: Int) -> String)
```

Context for building structured lists (bulleted, numbered).

This class provides methods for adding list items with various content types, including plain text, nested content, and titled content with nested elements.

## ai.koog.prompt.markdown.MarkdownContentBuilder.ListContext.item

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-list-context/item.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun item(text: String)
```

Adds a list item with the given text.

Handles multiline text by properly indenting continuation lines.

- text — The text content of the list item
### :prompt:prompt-markdown/commonMain

```kotlin
fun item(block: MarkdownContentBuilder.() -> Unit)
```

Adds a list item with content generated from a block.

Useful for creating list items with complex content or nested elements.

Example:

- block — The content builder for the list item
### :prompt:prompt-markdown/commonMain

```kotlin
fun item(title: String, block: MarkdownContentBuilder.() -> Unit)
```

Adds a list item with a title and nested content.

The title appears on the first line, and the nested content follows on subsequent lines.

Example:

- title — The title text for the list item
- block — The content builder for the nested content
## ai.koog.prompt.markdown.MarkdownContentBuilder.MarkdownContentBuilder

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/-markdown-content-builder.html`

### :prompt:prompt-markdown/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.markdown.MarkdownContentBuilder.blockquote

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/blockquote.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun blockquote(text: String)
```

Adds a blockquote to the content.

- text — The text to quote
## ai.koog.prompt.markdown.MarkdownContentBuilder.bold

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/bold.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun bold(text: String)
```

Adds a bold text (text) to the content.

- text — The text to make bold
## ai.koog.prompt.markdown.MarkdownContentBuilder.bulleted

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/bulleted.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun bulleted(block: MarkdownContentBuilder.ListContext.() -> Unit)
```

Adds a bulleted list with a block structure.

Creates an unordered list with bullet points (-).

Example:

- block — The list content builder
## ai.koog.prompt.markdown.MarkdownContentBuilder.code

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/code.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun code(code: String)
```

Adds a code span (code) to the content.

- code — The code to add
## ai.koog.prompt.markdown.MarkdownContentBuilder.codeblock

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/codeblock.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun codeblock(code: String, language: String = "")
```

Adds a code block with optional language specification to the content.

- code — The code to add
- language — The language for syntax highlighting (optional)
## ai.koog.prompt.markdown.MarkdownContentBuilder.h1

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/h1.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun h1(text: String)
```

Adds a level 1 header (# Header) to the content.

- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.h2

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/h2.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun h2(text: String)
```

Adds a level 2 header (## Header) to the content.

- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.h3

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/h3.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun h3(text: String)
```

Adds a level 3 header (### Header) to the content.

- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.h4

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/h4.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun h4(text: String)
```

Adds a level 4 header (#### Header) to the content.

- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.h5

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/h5.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun h5(text: String)
```

Adds a level 5 header (##### Header) to the content.

- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.h6

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/h6.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun h6(text: String)
```

Adds a level 6 header (###### Header) to the content.

- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.header

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/header.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun header(level: Int, text: String)
```

Adds a markdown header to the content.

- level — The header level (1-6)
- text — The header text
## ai.koog.prompt.markdown.MarkdownContentBuilder.horizontalRule

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/horizontal-rule.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun horizontalRule()
```

Adds a horizontal rule (---) to the content.

## ai.koog.prompt.markdown.MarkdownContentBuilder.image

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/image.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun image(alt: String, url: String)
```

Adds an image () to the content.

- alt — The image alt text
- url — The image URL
## ai.koog.prompt.markdown.MarkdownContentBuilder

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/index.html`

### :prompt:prompt-markdown/commonMain

```kotlin
class MarkdownContentBuilder : TextContentBuilder
```

A dedicated builder for creating markdown content. Wraps TextContentBuilder and provides markdown-specific functionality for generating well-formatted Markdown documents programmatically.

Example usage:


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.markdown.MarkdownContentBuilder.italic

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/italic.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun italic(text: String)
```

Adds an italic text (text) to the content.

- text — The text to make italic
## ai.koog.prompt.markdown.MarkdownContentBuilder.line

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/line.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun line(block: MarkdownContentBuilder.LineContext.() -> Unit)
```

Creates a single line of markdown content with mixed formatting. Useful for creating complex inline formatting combinations.

Example:

- block — The line content builder
## ai.koog.prompt.markdown.MarkdownContentBuilder.link

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/link.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun link(text: String, url: String)
```

Adds a link (text) to the content.

- text — The link text
- url — The link URL
## ai.koog.prompt.markdown.MarkdownContentBuilder.numbered

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/numbered.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun numbered(block: MarkdownContentBuilder.ListContext.() -> Unit)
```

Adds a numbered list with a block structure.

Creates an ordered list with sequential numbers (1., 2., etc.).

Example:

- block — The list content builder
## ai.koog.prompt.markdown.MarkdownContentBuilder.strikethrough

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/strikethrough.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun strikethrough(text: String)
```

Adds a strikethrough text (text) to the content.

- text — The text to strikethrough
## ai.koog.prompt.markdown.MarkdownContentBuilder.table

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/-markdown-content-builder/table.html`

### :prompt:prompt-markdown/commonMain

```kotlin
fun table(headers: List<String>, rows: List<List<String>>, alignments: List<TableAlignment> = List(headers.size) { TableAlignment.LEFT })
```

Adds a table to the content.

- headers — The table headers
- rows — The table rows, each row is a list of cells
- alignments — The column alignments (optional)
## ai.koog.prompt.markdown.markdown

Module: `prompt-markdown`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-markdown/ai.koog.prompt.markdown/markdown.html`

### :prompt:prompt-markdown/commonMain

```kotlin
inline fun StringBuilder.markdown(init: MarkdownContentBuilder.() -> Unit)
```

Extension function to append markdown content to a StringBuilder.

Example:

- init — The markdown content builder
### :prompt:prompt-markdown/commonMain

```kotlin
inline fun TextContentBuilderBase<*>.markdown(init: MarkdownContentBuilder.() -> Unit)
```

Extension function to add markdown content to a TextContentBuilder.

Useful for embedding markdown content within other text content.

Example:

- init — The markdown content builder

Referenced packages: `ai.koog.prompt.text`.

### :prompt:prompt-markdown/commonMain

```kotlin
fun markdown(init: MarkdownContentBuilder.() -> Unit): String
```

Creates a markdown document with the given content.

The markdown document as a string

- init — The content builder
## ai.koog.prompt.Prompt.Companion.Empty

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-companion/-empty.html`

### :prompt:prompt-model/commonMain

```kotlin
@JvmField val Empty: Prompt
```

Represents an empty state for a Prompt object. This variable is initialized with an empty list for the prompt's options and an empty string as the prompt's message.

The Empty value can be used as a default or placeholder for scenarios where no meaningful data or prompt has been provided.

## ai.koog.prompt.Prompt.Companion.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-companion/build.html`

### :prompt:prompt-model/commonMain

```kotlin
fun build(id: String, params: LLMParams = LLMParams(), clock: KoogClock = KoogClock.System, init: PromptBuilder.() -> Unit): Prompt
```

Builds a Prompt object using the specified identifier, parameters, and initialization logic.

The constructed Prompt object.

- id — The unique identifier for the Prompt being built.
- params — The configuration parameters for the Prompt with a default value of LLMParams().
- clock — The clock to use for generating timestamps, defaults to KoogClock.Companion.System.
- init — The initialization logic applied to the PromptBuilder.

Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.params`, `ai.koog.utils.time`.

### :prompt:prompt-model/commonMain

```kotlin
fun build(prompt: Prompt, clock: KoogClock = KoogClock.System, init: PromptBuilder.() -> Unit): Prompt
```

Constructs a new Prompt instance by applying the provided initialization logic to a PromptBuilder.

A new Prompt instance configured with the specified initialization logic.

- prompt — The base Prompt used for initializing the PromptBuilder.
- clock — The clock to use for generating timestamps, defaults to KoogClock.Companion.System.
- init — The initialization block applied to configure the PromptBuilder.

Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.utils.time`.

## ai.koog.prompt.Prompt.Companion.builder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-companion/builder.html`

### :prompt:prompt-model/commonMain

```kotlin
fun builder(id: String, clock: KoogClock = KoogClock.System): PromptBuilder
```

Constructs a new PromptBuilder instance for creating and configuring a Prompt.

A new instance of PromptBuilder with the specified ID and clock.

- id — The unique identifier for the prompt.
- clock — The clock used for timestamping or time-related operations. Defaults to ai.koog.utils.time.KoogClock.Companion.System if not provided.

Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.utils.time`.

## ai.koog.prompt.Prompt.Companion

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-companion/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Companion
```

Companion object for the Prompt class, providing utilities and constants for creating instances of Prompt.

## ai.koog.prompt.Prompt.LLMParamsUpdateContext

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class LLMParamsUpdateContext
```

Represents a mutable context for updating the parameters of an LLM (Language Learning Model). The class is used internally to facilitate changes to various configurations, such as temperature, speculation, schema, and tool choice, before converting back to an immutable LLMParams instance.

## ai.koog.prompt.Prompt.LLMParamsUpdateContext.schema

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/schema.html`

### :prompt:prompt-model/commonMain

```kotlin
var schema: LLMParams.Schema?
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.LLMParamsUpdateContext.speculation

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/speculation.html`

### :prompt:prompt-model/commonMain

```kotlin
var speculation: String?
```

## ai.koog.prompt.Prompt.LLMParamsUpdateContext.temperature

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/temperature.html`

### :prompt:prompt-model/commonMain

```kotlin
var temperature: Double?
```

## ai.koog.prompt.Prompt.LLMParamsUpdateContext.toParams

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/to-params.html`

### :prompt:prompt-model/commonMain

```kotlin
fun toParams(): LLMParams
```

Converts the current context of parameters into an instance of LLMParams.

A new instance of LLMParams populated with the values of the current context, including temperature, speculation, schema, and toolChoice options.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.LLMParamsUpdateContext.toolChoice

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/tool-choice.html`

### :prompt:prompt-model/commonMain

```kotlin
var toolChoice: LLMParams.ToolChoice?
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.LLMParamsUpdateContext.user

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-l-l-m-params-update-context/user.html`

### :prompt:prompt-model/commonMain

```kotlin
var user: String?
```

## ai.koog.prompt.Prompt.Prompt

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/-prompt.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(messages: List<Message>, id: String, params: LLMParams = LLMParams())
```


Referenced packages: `ai.koog.prompt.message`, `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.Prompt

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Prompt constructor(val messages: List<Message>, val id: String, val params: LLMParams = LLMParams())
```

Represents a data structure for a prompt, consisting of a list of messages, a unique identifier, and optional parameters for language model settings.


Referenced packages: `ai.koog.prompt.message`, `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.messages

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/messages.html`

### :prompt:prompt-model/commonMain

```kotlin
val messages: List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.Prompt.params

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/params.html`

### :prompt:prompt-model/commonMain

```kotlin
val params: LLMParams
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.withMessages

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/with-messages.html`

### :prompt:prompt-model/commonMain

```kotlin
fun withMessages(update: (List<Message>) -> List<Message>): Prompt
```

Creates a copy of the Prompt with updated messages, allowing to modify the existing list of messages or provide a new one.

A new Prompt instance with the modified list of messages.

- update — A lambda function that returns the new list of messages.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.Prompt.withParams

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/with-params.html`

### :prompt:prompt-model/commonMain

```kotlin
fun withParams(newParams: LLMParams): Prompt
```

Returns a new instance of the Prompt class with updated language model parameters.

a new Prompt instance with the specified parameters applied.

- newParams — the new LLMParams to use for the updated prompt.

Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.Prompt.withUpdatedParams

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt/-prompt/with-updated-params.html`

### :prompt:prompt-model/commonMain

```kotlin
fun withUpdatedParams(update: Prompt.LLMParamsUpdateContext.() -> Unit): Prompt
```

Creates a new instance of Prompt with updated parameters based on the modifications provided in the given update lambda. The update is applied to a mutable context representing the current LLM parameters, allowing selective modifications, which are then returned as a new set of parameters.

A new Prompt instance with the updated parameters.

- update — A lambda function that receives an instance of LLMParamsUpdateContext, allowing modification of the current parameters such as temperature, speculation, schema, and tool choice.
## ai.koog.prompt.dsl.ContentMessagePartsBuilder.ContentMessagePartsBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-message-parts-builder/-content-message-parts-builder.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.dsl.ContentMessagePartsBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-message-parts-builder/build.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun build(): List<MessagePart.ContentPart>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentMessagePartsBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-message-parts-builder/index.html`

### :prompt:prompt-model/commonMain

```kotlin
open class ContentMessagePartsBuilder : ContentPartsBuilderBase<List<MessagePart.ContentPart>>
```

A builder for constructing parts for prompt messages. All parts are added to a list in declaration order and can be retrieved through the build method.

Example usage:

- MessagePart.ContentPart

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.ContentPartsBuilderBase

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/-content-parts-builder-base.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.dsl.ContentPartsBuilderBase.attachment

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/attachment.html`

### :prompt:prompt-model/commonMain

```kotlin
fun attachment(attachment: AttachmentSource, cacheControl: CacheControl? = null)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.audio

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/audio.html`

### :prompt:prompt-model/commonMain

```kotlin
fun audio(audio: AttachmentSource.Audio, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Audio to the list of parts.


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun audio(url: String, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Audio with AttachmentContent.URL content from the provided URL.

- url — Audio URL
- IllegalArgumentException — if the URL is not valid or no file in the URL was found.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun audio(path: Path, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Audio with AttachmentContent.Binary.Bytes content from the provided local file path.

- path — Path to local audio file
- IllegalArgumentException — if the path is not valid, the file does not exist, or is not a regular file.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.binaryFile

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/binary-file.html`

### :prompt:prompt-model/commonMain

```kotlin
fun binaryFile(path: Path, mimeType: String, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.File with AttachmentContent.Binary.Bytes content from the provided local file path.

- path — Path to local file
- mimeType — MIME type of the file (e.g., "application/pdf", "text/plain")
- IllegalArgumentException — if the path is not valid, the file does not exist, or is not a regular file.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.file

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/file.html`

### :prompt:prompt-model/commonMain

```kotlin
fun file(file: AttachmentSource.File, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.File to the list of parts.


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun file(url: String, mimeType: String, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.File with AttachmentContent.URL content from the provided URL.

- url — File URL
- mimeType — MIME type of the file (e.g., "application/pdf", "text/plain")
- IllegalArgumentException — if the URL is not valid or no file in the URL was found.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.image

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/image.html`

### :prompt:prompt-model/commonMain

```kotlin
fun image(image: AttachmentSource.Image, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Image to the list of parts.


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun image(url: String, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Image with AttachmentContent.URL content from the provided URL.

- url — Image URL
- IllegalArgumentException — if the URL is not valid or no file in the URL was found.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun image(path: Path, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Image with AttachmentContent.Binary.Bytes content from the provided local file path.

- path — Path to local image file
- IllegalArgumentException — if the path is not valid, the file does not exist, or is not a regular file.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/index.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract class ContentPartsBuilderBase<T> : TextContentBuilderBase<T>
```

A base utility class for building and manipulating content based on the text. This class can be extended to support more types of text-based content, e.g. text with attachments or some metadata.

Provides methods for constructing formatted strings with features such as inserting text, adding new lines, and applying padding. The builder pattern supports a fluent and convenient approach to managing text content.

- ContentMessagePartsBuilder
- RequestMessagePartsBuilder

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.part

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/part.html`

### :prompt:prompt-model/commonMain

```kotlin
fun part(part: MessagePart.ContentPart)
```

Adds MessagePart to the list of parts.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.textFile

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/text-file.html`

### :prompt:prompt-model/commonMain

```kotlin
fun textFile(path: Path, mimeType: String, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.File with AttachmentContent.PlainText content from the provided local file path.

- path — Path to local file
- mimeType — MIME type of the file (e.g., "application/pdf", "text/plain")
- IllegalArgumentException — if the path is not valid, the file does not exist, or is not a regular file.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/text.html`

### :prompt:prompt-model/commonMain

```kotlin
fun text(text: String, cacheControl: CacheControl)
```

Adds MessagePart.Text to the list of parts.


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun text(cacheControl: CacheControl? = null, init: TextContentBuilder.() -> Unit)
```


Referenced packages: `ai.koog.prompt.message`, `ai.koog.prompt.text`.

## ai.koog.prompt.dsl.ContentPartsBuilderBase.video

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-content-parts-builder-base/video.html`

### :prompt:prompt-model/commonMain

```kotlin
fun video(video: AttachmentSource.Video, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Video to the list of parts.


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun video(url: String, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Video with AttachmentContent.URL content from the provided URL.

- url — Video URL
- IllegalArgumentException — if the URL is not valid or no file in the URL was found.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun video(path: Path, cacheControl: CacheControl? = null)
```

Adds AttachmentSource.Video with AttachmentContent.Binary.Bytes content from the provided local file path.

- path — Path to local video file
- IllegalArgumentException — if the path is not valid, the file does not exist, or is not a regular file.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.PromptBuilder.assistant

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/assistant.html`

### :prompt:prompt-model/commonMain

```kotlin
fun assistant(content: String): PromptBuilder
```

Adds an assistant message to the prompt.

Assistant messages represent responses from the language model.

Example:

- content — The content of the assistant message
### :prompt:prompt-model/commonMain

```kotlin
fun assistant(parts: List<MessagePart.ResponsePart>, finishReason: String? = null, rawResponse: JsonObject? = null, id: String? = null): PromptBuilder
```

Adds an assistant message to the prompt.

Assistant messages represent responses from the language model.

Example:

- id — Optional unique identifier for the message.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun assistant(finishReason: String? = null, rawResponse: JsonObject? = null, id: String? = null, init: ResponseMessagePartsBuilder.() -> Unit): PromptBuilder
```

### :prompt:prompt-model/commonMain

```kotlin
fun assistant(init: ResponseMessagePartsBuilder.() -> Unit): PromptBuilder
```

Adds an assistant message to the prompt using a TextContentBuilder.

- init — The initialization block for the TextContentBuilder
## ai.koog.prompt.dsl.PromptBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/build.html`

### :prompt:prompt-model/commonMain

```kotlin
fun build(): Prompt
```

Builds and returns a Prompt object from the current state of the builder.

A new Prompt object


Referenced packages: `ai.koog.prompt`.

## ai.koog.prompt.dsl.PromptBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class PromptBuilder
```

A builder class for creating prompts using a DSL approach.

PromptBuilder allows constructing prompts by adding different types of messages (system, user, assistant, tool) in a structured way.

Example usage:

## ai.koog.prompt.dsl.PromptBuilder.message

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/message.html`

### :prompt:prompt-model/commonMain

```kotlin
fun message(message: Message): PromptBuilder
```

Adds a generic message to the prompt.

This method allows adding any type of Message object.

Example:

- message — The message to add

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.PromptBuilder.messages

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/messages.html`

### :prompt:prompt-model/commonMain

```kotlin
fun messages(messages: List<Message>): PromptBuilder
```

Adds multiple messages to the prompt.

This method allows adding a list of Message objects.

Example:

- messages — The list of messages to add

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.PromptBuilder.reasoning

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/reasoning.html`

### :prompt:prompt-model/commonMain

```kotlin
fun reasoning(part: MessagePart.Reasoning): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun reasoning(content: String, id: String? = null, summary: String? = null, encrypted: String? = null, cacheControl: CacheControl? = null): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.PromptBuilder.system

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/system.html`

### :prompt:prompt-model/commonMain

```kotlin
fun system(content: String, cache: CacheControl? = null): PromptBuilder
```

Adds a system message to the prompt.

System messages provide instructions or context to the language model.

Example:

- content — The content of the system message
- cache — Optional cache control to apply after this tool definition.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun system(cache: CacheControl? = null, init: TextContentBuilder.() -> Unit): PromptBuilder
```

Adds a system message to the prompt using a TextContentBuilder.

- cache — Optional cache control to apply after this tool definition.
- init — The initialization block for the TextContentBuilder

Referenced packages: `ai.koog.prompt.message`, `ai.koog.prompt.text`.

### :prompt:prompt-model/commonMain

```kotlin
fun system(init: TextContentBuilder.() -> Unit): PromptBuilder
```

Adds a system message to the prompt using a TextContentBuilder.

This allows for more complex message construction.

Example:

- init — The initialization block for the TextContentBuilder

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.dsl.PromptBuilder.toolCall

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/tool-call.html`

### :prompt:prompt-model/commonMain

```kotlin
fun toolCall(part: MessagePart.Tool.Call): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun toolCall(tool: String, args: String, id: String? = null, cacheControl: CacheControl? = null): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun toolCall(tool: String, args: JsonObject, id: String? = null, cacheControl: CacheControl? = null): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.PromptBuilder.toolResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/tool-result.html`

### :prompt:prompt-model/commonMain

```kotlin
fun toolResult(part: MessagePart.Tool.Result): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun toolResult(tool: String, output: String, id: String? = null, isError: Boolean = false, cacheControl: CacheControl? = null): PromptBuilder
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.PromptBuilder.user

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-builder/user.html`

### :prompt:prompt-model/commonMain

```kotlin
fun user(parts: List<MessagePart.RequestPart>): PromptBuilder
```

Adds a user message to the prompt with optional attachments.

User messages represent input from the user to the language model. This method supports adding parts of the message such as text content or attachments.

- parts — Parts of the user message

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun user(content: String, cache: CacheControl? = null): PromptBuilder
```

Adds a user message to the prompt.

User messages represent input from the user to the language model. This method supports adding text content.

- content — Content of the user message

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun user(block: RequestMessagePartsBuilder.() -> Unit): PromptBuilder
```

Adds a user message to the prompt with attachments.

User messages represent input from the user to the language model. This method allows adding parts of the message such as text content or attachments using a RequestMessagePartsBuilder.

Example:``` user { test("Image 1:") image("photo1.jpg") test("Image 2:") image("photo3.jpg") }

- block — Lambda to configure attachments using ContentMessagePartsBuilder
## ai.koog.prompt.dsl.PromptDSL

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-prompt-d-s-l/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@DslMarker annotation class PromptDSL
```

Marker annotation for the Prompt DSL.

This annotation is used to create a DSL scope for building prompts.

## ai.koog.prompt.dsl.RequestMessagePartsBuilder.RequestMessagePartsBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-request-message-parts-builder/-request-message-parts-builder.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.dsl.RequestMessagePartsBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-request-message-parts-builder/build.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun build(): List<MessagePart.RequestPart>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.RequestMessagePartsBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-request-message-parts-builder/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class RequestMessagePartsBuilder : ContentPartsBuilderBase<List<MessagePart.RequestPart>>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.RequestMessagePartsBuilder.toolResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-request-message-parts-builder/tool-result.html`

### :prompt:prompt-model/commonMain

```kotlin
fun toolResult(result: MessagePart.Tool.Result)
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun toolResult(id: String? = null, tool: String, output: String, isError: Boolean = false, cacheControl: CacheControl? = null)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ResponseMessagePartsBuilder.ResponseMessagePartsBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-response-message-parts-builder/-response-message-parts-builder.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.dsl.ResponseMessagePartsBuilder.build

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-response-message-parts-builder/build.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun build(): List<MessagePart.ResponsePart>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ResponseMessagePartsBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-response-message-parts-builder/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class ResponseMessagePartsBuilder : TextContentBuilderBase<List<MessagePart.ResponsePart>>
```


Referenced packages: `ai.koog.prompt.message`, `ai.koog.prompt.text`.

## ai.koog.prompt.dsl.ResponseMessagePartsBuilder.reasoning

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-response-message-parts-builder/reasoning.html`

### :prompt:prompt-model/commonMain

```kotlin
fun reasoning(thought: MessagePart.Reasoning)
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun reasoning(id: String? = null, content: String, summary: String? = null, encrypted: String? = null, cacheControl: CacheControl? = null)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.ResponseMessagePartsBuilder.toolCall

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/-response-message-parts-builder/tool-call.html`

### :prompt:prompt-model/commonMain

```kotlin
fun toolCall(call: MessagePart.Tool.Call)
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun toolCall(id: String? = null, tool: String, args: String, cacheControl: CacheControl? = null)
```


Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-model/commonMain

```kotlin
fun toolCall(id: String? = null, tool: String, args: JsonObject, cacheControl: CacheControl? = null)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.dsl.emptyPrompt

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/empty-prompt.html`

### :prompt:prompt-model/commonMain

```kotlin
fun emptyPrompt(): Prompt
```

Constructs an empty instance of the Prompt class with no messages, default parameters, and an empty identifier. This empty prompt can be used as a default or placeholder.

A new Prompt instance with no messages, an empty identifier, and default parameters.


Referenced packages: `ai.koog.prompt`.

## ai.koog.prompt.dsl.prompt

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.dsl/prompt.html`

### :prompt:prompt-model/commonMain

```kotlin
fun prompt(id: String, params: LLMParams = LLMParams(), clock: KoogClock = KoogClock.System, build: PromptBuilder.() -> Unit): Prompt
```

Creates a new prompt using the Prompt DSL.

This function allows creating a prompt with a specific ID and parameters.

Example:

A new Prompt object

- id — The identifier for the prompt
- params — The parameters for the language model
- clock — The clock to use for generating timestamps, defaults to KoogClock.System
- build — The initialization block for the PromptBuilder

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.params`, `ai.koog.utils.time`.

### :prompt:prompt-model/commonMain

```kotlin
fun prompt(existing: Prompt, clock: KoogClock = KoogClock.System, build: PromptBuilder.() -> Unit): Prompt
```

Extends an existing prompt using the Prompt DSL.

This function allows adding more messages to an existing prompt.

Example:

A new Prompt object based on the existing one

- existing — The existing prompt to extend
- clock — The clock to use for generating timestamps, defaults to KoogClock.System
- build — The initialization block for the PromptBuilder

Referenced packages: `ai.koog.prompt`, `ai.koog.utils.time`.

## ai.koog.prompt.message.AttachmentContent.Binary.Base64.Base64

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-base64/-base64.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(base64: String)
```

## ai.koog.prompt.message.AttachmentContent.Binary.Base64.asBase64

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-base64/as-base64.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun asBase64(): String
```

Base64 representation of the binary content

## ai.koog.prompt.message.AttachmentContent.Binary.Base64.asBytes

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-base64/as-bytes.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun asBytes(): ByteArray
```

Decodes the Base64 encoded string to its corresponding byte array.

a ByteArray representation of the decoded Base64 string.

## ai.koog.prompt.message.AttachmentContent.Binary.Base64.base64

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-base64/base64.html`

### :prompt:prompt-model/commonMain

```kotlin
val base64: String
```

## ai.koog.prompt.message.AttachmentContent.Binary.Base64

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-base64/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Base64(val base64: String) : AttachmentContent.Binary
```

Binary content represented as Base64 encoded string.

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.Bytes

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/-bytes.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(data: ByteArray)
```

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.asBase64

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/as-base64.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun asBase64(): String
```

Base64 representation of the binary content

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.asBytes

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/as-bytes.html`

### :prompt:prompt-model/commonMain

```kotlin
open override fun asBytes(): ByteArray
```

Returns the binary content as a byte array.

a ByteArray representing the binary content.

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes.data

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/data.html`

### :prompt:prompt-model/commonMain

```kotlin
@SerialName(value = "base64") @Serializable(with = ByteArrayAsBase64Serializer::class) val data: ByteArray
```


Referenced packages: `ai.koog.utils.serializers`.

## ai.koog.prompt.message.AttachmentContent.Binary.Bytes

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/-bytes/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Bytes(val data: ByteArray) : AttachmentContent.Binary
```

Binary content represented as byte array.

## ai.koog.prompt.message.AttachmentContent.Binary.asBase64

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/as-base64.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract fun asBase64(): String
```

Base64 representation of the binary content

## ai.koog.prompt.message.AttachmentContent.Binary.asBytes

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/as-bytes.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract fun asBytes(): ByteArray
```

Returns the binary content as a byte array.

a ByteArray representing the binary content.

## ai.koog.prompt.message.AttachmentContent.Binary

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-binary/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface Binary : AttachmentContent
```

Binary content.

- Bytes
- Base64
## ai.koog.prompt.message.AttachmentContent.PlainText.PlainText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-plain-text/-plain-text.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(text: String)
```

## ai.koog.prompt.message.AttachmentContent.PlainText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-plain-text/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class PlainText(val text: String) : AttachmentContent
```

Plain text content.

## ai.koog.prompt.message.AttachmentContent.PlainText.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-plain-text/text.html`

### :prompt:prompt-model/commonMain

```kotlin
val text: String
```

## ai.koog.prompt.message.AttachmentContent.URL.URL

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-u-r-l/-u-r-l.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(url: String)
```

## ai.koog.prompt.message.AttachmentContent.URL

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-u-r-l/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class URL(val url: String) : AttachmentContent
```

URL of the content (e.g. image or a document).

## ai.koog.prompt.message.AttachmentContent.URL.url

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/-u-r-l/url.html`

### :prompt:prompt-model/commonMain

```kotlin
val url: String
```

## ai.koog.prompt.message.AttachmentContent

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-content/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface AttachmentContent
```

Content of the attachment, check implementation nested classes for supported content types.

- PlainText
- URL
- Binary
## ai.koog.prompt.message.AttachmentSource.Audio.Audio

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-audio/-audio.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: AttachmentContent, format: String, mimeType: String = "audio/", fileName: String? = null)
```

## ai.koog.prompt.message.AttachmentSource.Audio.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-audio/content.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val content: AttachmentContent
```

Content of the attachment.

## ai.koog.prompt.message.AttachmentSource.Audio.fileName

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-audio/file-name.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val fileName: String?
```

Optional file name of the attachment file.

## ai.koog.prompt.message.AttachmentSource.Audio.format

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-audio/format.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val format: String
```

File format (usually file extension) of the attachment file. E.g. jpg, png, mp4, pdf.

## ai.koog.prompt.message.AttachmentSource.Audio

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-audio/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Audio(val content: AttachmentContent, val format: String, val mimeType: String = "audio/", val fileName: String? = null) : AttachmentSource
```

Audio attachment (mp3, wav, etc.).

## ai.koog.prompt.message.AttachmentSource.Audio.mimeType

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-audio/mime-type.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val mimeType: String
```

MIME type of the attachment E.g. image/jpg, video/mp4

## ai.koog.prompt.message.AttachmentSource.File.File

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-file/-file.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: AttachmentContent, format: String, mimeType: String, fileName: String? = null)
```

## ai.koog.prompt.message.AttachmentSource.File.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-file/content.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val content: AttachmentContent
```

Content of the attachment.

## ai.koog.prompt.message.AttachmentSource.File.fileName

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-file/file-name.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val fileName: String?
```

Optional file name of the attachment file.

## ai.koog.prompt.message.AttachmentSource.File.format

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-file/format.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val format: String
```

File format (usually file extension) of the attachment file. E.g. jpg, png, mp4, pdf.

## ai.koog.prompt.message.AttachmentSource.File

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-file/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class File(val content: AttachmentContent, val format: String, val mimeType: String, val fileName: String? = null) : AttachmentSource
```

Other types of file attachments. E.g. pdf, md, txt.

## ai.koog.prompt.message.AttachmentSource.File.mimeType

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-file/mime-type.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val mimeType: String
```

MIME type of the attachment E.g. image/jpg, video/mp4

## ai.koog.prompt.message.AttachmentSource.Image.Image

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-image/-image.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: AttachmentContent, format: String, mimeType: String = "image/", fileName: String? = null)
```

## ai.koog.prompt.message.AttachmentSource.Image.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-image/content.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val content: AttachmentContent
```

Content of the attachment.

## ai.koog.prompt.message.AttachmentSource.Image.fileName

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-image/file-name.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val fileName: String?
```

Optional file name of the attachment file.

## ai.koog.prompt.message.AttachmentSource.Image.format

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-image/format.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val format: String
```

File format (usually file extension) of the attachment file. E.g. jpg, png, mp4, pdf.

## ai.koog.prompt.message.AttachmentSource.Image

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-image/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Image(val content: AttachmentContent, val format: String, val mimeType: String = "image/", val fileName: String? = null) : AttachmentSource
```

Image attachment (jpg, png, gif, etc.).

## ai.koog.prompt.message.AttachmentSource.Image.mimeType

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-image/mime-type.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val mimeType: String
```

MIME type of the attachment E.g. image/jpg, video/mp4

## ai.koog.prompt.message.AttachmentSource.Video.Video

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-video/-video.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: AttachmentContent, format: String, mimeType: String = "video/", fileName: String? = null)
```

## ai.koog.prompt.message.AttachmentSource.Video.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-video/content.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val content: AttachmentContent
```

Content of the attachment.

## ai.koog.prompt.message.AttachmentSource.Video.fileName

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-video/file-name.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val fileName: String?
```

Optional file name of the attachment file.

## ai.koog.prompt.message.AttachmentSource.Video.format

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-video/format.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val format: String
```

File format (usually file extension) of the attachment file. E.g. jpg, png, mp4, pdf.

## ai.koog.prompt.message.AttachmentSource.Video

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-video/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Video(val content: AttachmentContent, val format: String, val mimeType: String = "video/", val fileName: String? = null) : AttachmentSource
```

Video attachment (mp4, avi, etc.).

## ai.koog.prompt.message.AttachmentSource.Video.mimeType

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/-video/mime-type.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val mimeType: String
```

MIME type of the attachment E.g. image/jpg, video/mp4

## ai.koog.prompt.message.AttachmentSource.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/content.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val content: AttachmentContent
```

Content of the attachment.

## ai.koog.prompt.message.AttachmentSource.fileName

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/file-name.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val fileName: String?
```

Optional file name of the attachment file.

## ai.koog.prompt.message.AttachmentSource.format

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/format.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val format: String
```

File format (usually file extension) of the attachment file. E.g. jpg, png, mp4, pdf.

## ai.koog.prompt.message.AttachmentSource

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface AttachmentSource
```

Source of the attachment.

- Image
- Video
- Audio
- File
## ai.koog.prompt.message.AttachmentSource.mimeType

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-attachment-source/mime-type.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val mimeType: String
```

MIME type of the attachment E.g. image/jpg, video/mp4

## ai.koog.prompt.message.CacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-cache-control/index.html`

### :prompt:prompt-model/commonMain

```kotlin
interface CacheControl
```

Cache control configuration for prompt caching. Indicates that the LLM provider should cache content up to and including the element this is attached to.

Each LLM provider defines its own supported cache control options as nested sealed interfaces.

## ai.koog.prompt.message.LLMChoice

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-l-l-m-choice/index.html`

### :prompt:prompt-model/commonMain

```kotlin
typealias LLMChoice = List<Message.Assistant>
```

A list of Message.Assistant responses representing multiple completion choices from the LLM.

## ai.koog.prompt.message.Message.Assistant.Assistant

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/-assistant.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(parts: List<MessagePart.ResponsePart>, metaInfo: ResponseMetaInfo, finishReason: String? = null, rawResponse: JsonObject? = null, id: String? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
constructor(part: MessagePart.ResponsePart, metaInfo: ResponseMetaInfo, finishReason: String? = null, rawResponse: JsonObject? = null, id: String? = null)
```

Convenience constructor that wraps a single MessagePart.ResponsePart in a list.

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: String, metaInfo: ResponseMetaInfo, finishReason: String? = null, rawResponse: JsonObject? = null, id: String? = null)
```

Convenience constructor that creates a MessagePart.Text from a raw string.

- content — The plain-text content of the assistant message.
## ai.koog.prompt.message.Message.Assistant.finishReason

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/finish-reason.html`

### :prompt:prompt-model/commonMain

```kotlin
val finishReason: String?
```

## ai.koog.prompt.message.Message.Assistant.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/id.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val id: String?
```

## ai.koog.prompt.message.Message.Assistant

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Assistant constructor(val parts: List<MessagePart.ResponsePart>, val metaInfo: ResponseMetaInfo, val finishReason: String? = null, val rawResponse: JsonObject? = null, val id: String? = null) : Message
```

An assistant-role message returned by the LLM. May contain text, reasoning, and/or tool calls.

## ai.koog.prompt.message.Message.Assistant.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val metaInfo: ResponseMetaInfo
```

## ai.koog.prompt.message.Message.Assistant.parts

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/parts.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val parts: List<MessagePart.ResponsePart>
```

## ai.koog.prompt.message.Message.Assistant.rawResponse

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/raw-response.html`

### :prompt:prompt-model/commonMain

```kotlin
val rawResponse: JsonObject?
```

## ai.koog.prompt.message.Message.Assistant.role

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-assistant/role.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val role: Message.Role
```

The role associated with the message.

## ai.koog.prompt.message.Message.Role.Assistant

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/-assistant/index.html`

### :prompt:prompt-model/commonMain

```kotlin
Assistant
```

Role for messages generated by an assistant (e.g., an AI assistant).

## ai.koog.prompt.message.Message.Role.System

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/-system/index.html`

### :prompt:prompt-model/commonMain

```kotlin
System
```

Role indicating a system message.

## ai.koog.prompt.message.Message.Role.User

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/-user/index.html`

### :prompt:prompt-model/commonMain

```kotlin
User
```

Role for messages generated by the user.

## ai.koog.prompt.message.Message.Role.entries

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/entries.html`

### :prompt:prompt-model/commonMain

```kotlin
val entries: EnumEntries<Message.Role>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.message.Message.Role

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable enum Role : Enum<Message.Role>
```

Defines the role of the message in the chat (e.g., system, user, assistant).

## ai.koog.prompt.message.Message.Role.valueOf

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/value-of.html`

### :prompt:prompt-model/commonMain

```kotlin
fun valueOf(value: String): Message.Role
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.message.Message.Role.values

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-role/values.html`

### :prompt:prompt-model/commonMain

```kotlin
fun values(): Array<Message.Role>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.message.Message.System.System

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-system/-system.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(parts: List<MessagePart.Text>, metaInfo: RequestMetaInfo, id: String? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
constructor(part: MessagePart.Text, metaInfo: RequestMetaInfo, id: String? = null)
```

Convenience constructor that wraps a single MessagePart.Text in a list.

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: String, metaInfo: RequestMetaInfo, cache: CacheControl? = null, id: String? = null)
```

Convenience constructor that creates a MessagePart.Text from a raw string.

- content — The plain-text content of the system message.
- cache — Optional cache-control directive for the message part.
## ai.koog.prompt.message.Message.System.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-system/id.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val id: String?
```

## ai.koog.prompt.message.Message.System

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-system/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class System constructor(val parts: List<MessagePart.Text>, val metaInfo: RequestMetaInfo, val id: String? = null) : Message
```

A system-role message used to set the behaviour or persona of the assistant. Only MessagePart.Text parts are supported.

## ai.koog.prompt.message.Message.System.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-system/meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val metaInfo: RequestMetaInfo
```

## ai.koog.prompt.message.Message.System.parts

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-system/parts.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val parts: List<MessagePart.Text>
```

## ai.koog.prompt.message.Message.System.role

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-system/role.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val role: Message.Role
```

The role associated with the message.

## ai.koog.prompt.message.Message.User.User

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-user/-user.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(parts: List<MessagePart.RequestPart>, metaInfo: RequestMetaInfo, id: String? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
constructor(part: MessagePart.RequestPart, metaInfo: RequestMetaInfo, id: String? = null)
```

Convenience constructor that wraps a single MessagePart.RequestPart in a list.

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: String, metaInfo: RequestMetaInfo, cache: CacheControl? = null, id: String? = null)
```

Convenience constructor that creates a MessagePart.Text from a raw string.

- content — The plain-text content of the user message.
- cache — Optional cache-control directive for the message part.
## ai.koog.prompt.message.Message.User.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-user/id.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val id: String?
```

## ai.koog.prompt.message.Message.User

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-user/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class User constructor(val parts: List<MessagePart.RequestPart>, val metaInfo: RequestMetaInfo, val id: String? = null) : Message
```

A user-role message sent to the LLM. May contain text, attachments, or tool results.

## ai.koog.prompt.message.Message.User.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-user/meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val metaInfo: RequestMetaInfo
```

## ai.koog.prompt.message.Message.User.parts

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-user/parts.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val parts: List<MessagePart.RequestPart>
```

## ai.koog.prompt.message.Message.User.role

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/-user/role.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val role: Message.Role
```

The role associated with the message.

## ai.koog.prompt.message.Message.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/id.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val id: String?
```

The unique identifier of the message.

## ai.koog.prompt.message.Message

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface Message
```

Represents a message exchanged in a chat with LLM. Messages can be categorized by their type and role, denoting the purpose and source of the message.

Represents both a message from LLM and a message to LLM from user or environment.

- System
- User
- Assistant
## ai.koog.prompt.message.Message.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val metaInfo: MessageMetaInfo
```

Stores metadata information for the current message instance, such as token count and timestamp.

## ai.koog.prompt.message.Message.parts

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/parts.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val parts: List<MessagePart>
```

The list of message parts: text, reasoning, tool calls and results

## ai.koog.prompt.message.Message.role

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/role.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val role: Message.Role
```

The role associated with the message.

## ai.koog.prompt.message.Message.textContent

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message/text-content.html`

### :prompt:prompt-model/commonMain

```kotlin
open fun textContent(separator: String): String
```

Extracts and concatenates the textual content from all MessagePart.Text elements in the message.

A single string with the concatenated text content of all MessagePart.Text elements, separated by the specified delimiter.

- separator — The delimiter used to join the text content of the parts. Default is "\n".
### :prompt:prompt-model/commonMain

```kotlin
open fun textContent(): String
```

Extracts and concatenates the textual content from all MessagePart.Text elements in the message. Messages are joined by a newline character ("\n").

A single string with the concatenated text content of all MessagePart.Text elements, separated by a newline character.

## ai.koog.prompt.message.MessageMetaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-meta-info/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface MessageMetaInfo
```

Meta-information associated with a message in a chat system.

- RequestMetaInfo
- ResponseMetaInfo
## ai.koog.prompt.message.MessageMetaInfo.metadata

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-meta-info/metadata.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val metadata: JsonObject?
```

Free-form information associated with a message. Can be used to store custom metadata that doesn't fit into the standard fields.

## ai.koog.prompt.message.MessageMetaInfo.timestamp

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-meta-info/timestamp.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val timestamp: Instant
```

Represents the timestamp of a message

This property indicates the precise time when a message was created. It defaults to the current system time if not explicitly set.

## ai.koog.prompt.message.MessagePart.Attachment.Attachment

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-attachment/-attachment.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(source: AttachmentSource, cacheControl: CacheControl? = null)
```

## ai.koog.prompt.message.MessagePart.Attachment.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-attachment/cache-control.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val cacheControl: CacheControl?
```

Optional cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.MessagePart.Attachment

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-attachment/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Attachment constructor(val source: AttachmentSource, val cacheControl: CacheControl? = null) : MessagePart.ContentPart
```

Attachment content part of the message.

## ai.koog.prompt.message.MessagePart.Attachment.source

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-attachment/source.html`

### :prompt:prompt-model/commonMain

```kotlin
val source: AttachmentSource
```

## ai.koog.prompt.message.MessagePart.ContentPart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-content-part/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface ContentPart : MessagePart.RequestPart, MessagePart.ResponsePart
```

Represents a part of a message that can be used in both request and response contexts. Parts can be text MessagePart.Text or attachments MessagePart.Attachment.

- Text
- Attachment
## ai.koog.prompt.message.MessagePart.Reasoning.Reasoning

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/-reasoning.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: List<String>, summary: List<String>? = null, encrypted: String? = null, id: String? = null, cacheControl: CacheControl? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
constructor(content: String, summary: List<String>? = null, encrypted: String? = null, id: String? = null, cacheControl: CacheControl? = null)
```

Convenience constructor for a single reasoning string.

- content — The reasoning text, wrapped in a single-element list.
## ai.koog.prompt.message.MessagePart.Reasoning.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/cache-control.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val cacheControl: CacheControl?
```

Optional cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.MessagePart.Reasoning.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/content.html`

### :prompt:prompt-model/commonMain

```kotlin
val content: List<String>
```

## ai.koog.prompt.message.MessagePart.Reasoning.encrypted

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/encrypted.html`

### :prompt:prompt-model/commonMain

```kotlin
val encrypted: String?
```

## ai.koog.prompt.message.MessagePart.Reasoning.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.message.MessagePart.Reasoning

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Reasoning constructor(val content: List<String>, val summary: List<String>? = null, val encrypted: String? = null, val id: String? = null, val cacheControl: CacheControl? = null) : MessagePart.ResponsePart
```

Represents a reasoning message exchanged in a chat system, encapsulating the content, role, and associated metadata, with an optional reference to the original thinking process.

## ai.koog.prompt.message.MessagePart.Reasoning.summary

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-reasoning/summary.html`

### :prompt:prompt-model/commonMain

```kotlin
val summary: List<String>?
```

## ai.koog.prompt.message.MessagePart.RequestPart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-request-part/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface RequestPart : MessagePart
```

A part that can appear in a request sent to the LLM. All request parts carry an optional cacheControl directive.

- ContentPart
- Result
## ai.koog.prompt.message.MessagePart.ResponsePart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-response-part/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface ResponsePart : MessagePart
```

A part that can appear in a response received from the LLM (e.g. text, reasoning, or tool calls).

- ContentPart
- Reasoning
- Call
## ai.koog.prompt.message.MessagePart.Text.Text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-text/-text.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(text: String, cacheControl: CacheControl? = null)
```

## ai.koog.prompt.message.MessagePart.Text.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-text/cache-control.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val cacheControl: CacheControl?
```

Optional cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.MessagePart.Text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-text/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Text constructor(val text: String, val cacheControl: CacheControl? = null) : MessagePart.ContentPart
```

Text content part of the message.

## ai.koog.prompt.message.MessagePart.Text.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-text/text.html`

### :prompt:prompt-model/commonMain

```kotlin
val text: String
```

## ai.koog.prompt.message.MessagePart.Tool.Call.Call

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/-call.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String? = null, tool: String, args: String, cacheControl: CacheControl? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String? = null, tool: String, args: JsonObject, cacheControl: CacheControl? = null)
```

Convenience constructor that accepts a JsonObject and serialises it to args.

- args — The tool arguments as a JsonObject.
## ai.koog.prompt.message.MessagePart.Tool.Call.argsJson

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/args-json.html`

### :prompt:prompt-model/commonMain

```kotlin
val argsJson: JsonObject
```

Lazily parsed JsonObject view of args.

## ai.koog.prompt.message.MessagePart.Tool.Call.args

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/args.html`

### :prompt:prompt-model/commonMain

```kotlin
val args: String
```

## ai.koog.prompt.message.MessagePart.Tool.Call.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/cache-control.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val cacheControl: CacheControl?
```

Optional cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.MessagePart.Tool.Call.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.message.MessagePart.Tool.Call

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Call constructor(val id: String? = null, val tool: String, val args: String, val cacheControl: CacheControl? = null) : MessagePart.Tool, MessagePart.ResponsePart
```

Represents a tool call message sent as a response.

## ai.koog.prompt.message.MessagePart.Tool.Call.tool

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-call/tool.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val tool: String
```

## ai.koog.prompt.message.MessagePart.Tool.Result.Result

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/-result.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String? = null, tool: String, parts: List<MessagePart.ContentPart>, isError: Boolean = false, cacheControl: CacheControl? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String? = null, tool: String, output: String, isError: Boolean = false, cacheControl: CacheControl? = null)
```

Convenience constructor for a single text output.

## ai.koog.prompt.message.MessagePart.Tool.Result.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/cache-control.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val cacheControl: CacheControl?
```

## ai.koog.prompt.message.MessagePart.Tool.Result.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.message.MessagePart.Tool.Result

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Result constructor(val id: String? = null, val tool: String, val parts: List<MessagePart.ContentPart>, val isError: Boolean = false, val cacheControl: CacheControl? = null) : MessagePart.Tool, MessagePart.RequestPart
```

Represents the result of a tool call sent as a request.

## ai.koog.prompt.message.MessagePart.Tool.Result.isError

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/is-error.html`

### :prompt:prompt-model/commonMain

```kotlin
val isError: Boolean
```

## ai.koog.prompt.message.MessagePart.Tool.Result.output

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/output.html`

### :prompt:prompt-model/commonMain

```kotlin
val output: String
```

Returns the concatenated text content of all text parts.

## ai.koog.prompt.message.MessagePart.Tool.Result.parts

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/parts.html`

### :prompt:prompt-model/commonMain

```kotlin
val parts: List<MessagePart.ContentPart>
```

## ai.koog.prompt.message.MessagePart.Tool.Result.tool

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/-result/tool.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val tool: String
```

## ai.koog.prompt.message.MessagePart.Tool

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface Tool : MessagePart
```

Represents messages exchanged with tools, either as calls or results.

- Call
- Result
## ai.koog.prompt.message.MessagePart.Tool.tool

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/-tool/tool.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val tool: String
```

The name of the tool used.

## ai.koog.prompt.message.MessagePart.cacheControl

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/cache-control.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val cacheControl: CacheControl?
```

Optional cache-control directive for the provider's prompt-caching feature.

## ai.koog.prompt.message.MessagePart

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-message-part/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface MessagePart
```

A discrete piece of content within a Message. Parts are typed by their direction and purpose: RequestPart parts go to the LLM, ResponsePart parts come from the LLM, and ContentPart parts (text, attachments) are valid in both directions.

- RequestPart
- ResponsePart
- Tool
## ai.koog.prompt.message.RequestMetaInfo.Companion.Empty

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/-companion/-empty.html`

### :prompt:prompt-model/commonMain

```kotlin
val Empty: RequestMetaInfo
```

An empty instance of RequestMetaInfo with the timestamp set to a distant past.

## ai.koog.prompt.message.RequestMetaInfo.Companion.create

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/-companion/create.html`

### :prompt:prompt-model/commonMain

```kotlin
fun create(clock: KoogClock): RequestMetaInfo
```

Creates a RequestMetadata instance with a timestamp from the provided clock.

A new RequestMetadata instance with the timestamp from the provided clock.

- clock — The clock to use for generating the timestamp.

Referenced packages: `ai.koog.utils.time`.

## ai.koog.prompt.message.RequestMetaInfo.Companion

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/-companion/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Companion
```

Companion object for RequestMetaInfo that provides factory methods and utilities related to creating instances.

## ai.koog.prompt.message.RequestMetaInfo.RequestMetaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/-request-meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(timestamp: Instant, metadata: JsonObject? = null)
```

## ai.koog.prompt.message.RequestMetaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class RequestMetaInfo constructor(val timestamp: Instant, val metadata: JsonObject? = null) : MessageMetaInfo
```

Represents MessageMetaInfo specific to a request within the system.

This class is an implementation of the MessageMetaInfo interface and provides timestamp information for a request.

## ai.koog.prompt.message.RequestMetaInfo.metadata

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/metadata.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val metadata: JsonObject?
```

Free-form information associated with a message. Can be used to store custom metadata that doesn't fit into the standard fields.

## ai.koog.prompt.message.RequestMetaInfo.timestamp

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-request-meta-info/timestamp.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val timestamp: Instant
```

## ai.koog.prompt.message.ResponseMetaInfo.Companion.Empty

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/-companion/-empty.html`

### :prompt:prompt-model/commonMain

```kotlin
val Empty: ResponseMetaInfo
```

An empty instance of the ResponseMetaInfo with the timestamp set to a distant past.

## ai.koog.prompt.message.ResponseMetaInfo.Companion.create

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/-companion/create.html`

### :prompt:prompt-model/commonMain

```kotlin
fun create(clock: KoogClock, totalTokensCount: Int? = null, inputTokensCount: Int? = null, outputTokensCount: Int? = null, modelId: String? = null, metadata: JsonObject? = null): ResponseMetaInfo
```

Creates a ResponseMetadata instance with a timestamp from the provided clock.

A new ResponseMetadata instance with the timestamp from the provided clock.

- clock — The clock to use for generating the timestamp.
- totalTokensCount — The total number of tokens involved in the response, including both input and output tokens.
- inputTokensCount — The number of tokens used in the input.
- outputTokensCount — The number of tokens generated in the output.
- modelId — The ID of the model used for generating the response, or null if not available.
- metadata — Additional metadata as a JSON object.

Referenced packages: `ai.koog.utils.time`.

## ai.koog.prompt.message.ResponseMetaInfo.Companion

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/-companion/index.html`

### :prompt:prompt-model/commonMain

```kotlin
object Companion
```

Companion object for the ResponseMetaInfo class. Provides utility methods to create ResponseMetaInfo instances.

## ai.koog.prompt.message.ResponseMetaInfo.ResponseMetaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/-response-meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(timestamp: Instant, totalTokensCount: Int? = null, inputTokensCount: Int? = null, outputTokensCount: Int? = null, modelId: String? = null, metadata: JsonObject? = null)
```

## ai.koog.prompt.message.ResponseMetaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ResponseMetaInfo constructor(val timestamp: Instant, val totalTokensCount: Int? = null, val inputTokensCount: Int? = null, val outputTokensCount: Int? = null, val modelId: String? = null, val metadata: JsonObject? = null) : MessageMetaInfo
```

Represents metadata associated with a response message in a chat system.

This class provides details about the response, including the count of tokens used in the response and the timestamp of when the response was created. It implements the MessageMetadata interface, inheriting the timestamp property.

Example:

Message 1: "Hello" (3 tokens) → tokensCount = 3

Message 2: "How are you?" (4 tokens) → tokensCount = 3 + 4 = 7

Message 3: "I am fine, thank you." (6 tokens) → tokensCount = 7 + 6 = 13

## ai.koog.prompt.message.ResponseMetaInfo.inputTokensCount

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/input-tokens-count.html`

### :prompt:prompt-model/commonMain

```kotlin
val inputTokensCount: Int?
```

## ai.koog.prompt.message.ResponseMetaInfo.metadata

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/metadata.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val metadata: JsonObject?
```

## ai.koog.prompt.message.ResponseMetaInfo.modelId

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/model-id.html`

### :prompt:prompt-model/commonMain

```kotlin
val modelId: String?
```

## ai.koog.prompt.message.ResponseMetaInfo.outputTokensCount

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/output-tokens-count.html`

### :prompt:prompt-model/commonMain

```kotlin
val outputTokensCount: Int?
```

## ai.koog.prompt.message.ResponseMetaInfo.timestamp

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/timestamp.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val timestamp: Instant
```

## ai.koog.prompt.message.ResponseMetaInfo.totalTokensCount

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.message/-response-meta-info/total-tokens-count.html`

### :prompt:prompt-model/commonMain

```kotlin
val totalTokensCount: Int?
```

## ai.koog.prompt.params.LLMParams.LLMParams

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-l-l-m-params.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null)
```

## ai.koog.prompt.params.LLMParams.Schema.JSON.Basic.Basic

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-basic/-basic.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(name: String, schema: JsonObject)
```

## ai.koog.prompt.params.LLMParams.Schema.JSON.Basic.capability

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-basic/capability.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val capability: LLMCapability.Schema
```

Related LLM capability that has to be supported for a particular schema type.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.params.LLMParams.Schema.JSON.Basic

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-basic/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Basic(val name: String, val schema: JsonObject) : LLMParams.Schema.JSON
```

Represents a basic JSON schema. Used to specify lightweight or fundamental JSON processing capabilities. This format primarily focuses on nested data definitions without advanced JSON Schema functionalities.

- LLMCapability.Schema.JSON.Basic
## ai.koog.prompt.params.LLMParams.Schema.JSON.Basic.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-basic/name.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val name: String
```

## ai.koog.prompt.params.LLMParams.Schema.JSON.Basic.schema

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-basic/schema.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val schema: JsonObject
```

## ai.koog.prompt.params.LLMParams.Schema.JSON.Standard.Standard

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-standard/-standard.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(name: String, schema: JsonObject)
```

## ai.koog.prompt.params.LLMParams.Schema.JSON.Standard.capability

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-standard/capability.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val capability: LLMCapability.Schema
```

Related LLM capability that has to be supported for a particular schema type.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.params.LLMParams.Schema.JSON.Standard

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-standard/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Standard(val name: String, val schema: JsonObject) : LLMParams.Schema.JSON
```

Represents a standard JSON schema, according to https://json-schema.org/. This format is a proper subset of the official JSON Schema specification.

Note: the flavor across different LLM providers might vary, since not all of them support full JSON schemas.

- LLMCapability.Schema.JSON.Standard
## ai.koog.prompt.params.LLMParams.Schema.JSON.Standard.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-standard/name.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val name: String
```

## ai.koog.prompt.params.LLMParams.Schema.JSON.Standard.schema

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/-standard/schema.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val schema: JsonObject
```

## ai.koog.prompt.params.LLMParams.Schema.JSON

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface JSON : LLMParams.Schema
```

Represents a schema in JSON format.

- Basic
- Standard
## ai.koog.prompt.params.LLMParams.Schema.JSON.schema

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/-j-s-o-n/schema.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val schema: JsonObject
```

JSON schema definition as JsonObject.

## ai.koog.prompt.params.LLMParams.Schema.capability

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/capability.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val capability: LLMCapability.Schema
```

Related LLM capability that has to be supported for a particular schema type.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.params.LLMParams.Schema

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface Schema
```

Represents a schema for the structured response.

- JSON
## ai.koog.prompt.params.LLMParams.Schema.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-schema/name.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val name: String
```

Name identifier of the schema.

## ai.koog.prompt.params.LLMParams.ToolChoice.Auto

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/-auto/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable object Auto : LLMParams.ToolChoice
```

LLM will automatically decide whether to call tools or to generate text

## ai.koog.prompt.params.LLMParams.ToolChoice.Named.Named

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/-named/-named.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.prompt.params.LLMParams.ToolChoice.Named

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/-named/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class Named(val name: String) : LLMParams.ToolChoice
```

LLM will call the tool name as a response

## ai.koog.prompt.params.LLMParams.ToolChoice.Named.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/-named/name.html`

### :prompt:prompt-model/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.params.LLMParams.ToolChoice.None

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/-none/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable object None : LLMParams.ToolChoice
```

LLM will not call tools at all, and only generate text

## ai.koog.prompt.params.LLMParams.ToolChoice.Required

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/-required/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable object Required : LLMParams.ToolChoice
```

LLM will only call tools

## ai.koog.prompt.params.LLMParams.ToolChoice

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/-tool-choice/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed class ToolChoice
```

Used to switch tool calling behavior of LLM

- Named
- None
- Auto
- Required
## ai.koog.prompt.params.LLMParams.additionalProperties

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/additional-properties.html`

### :prompt:prompt-model/commonMain

```kotlin
val additionalProperties: Map<String, JsonElement>?
```

## ai.koog.prompt.params.LLMParams.default

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/default.html`

### :prompt:prompt-model/commonMain

```kotlin
fun default(default: LLMParams): LLMParams
```

Combines the parameters of the current LLMParams instance with the provided default LLMParams to produce a new instance. Fields that are null in the current instance are replaced by the corresponding fields from the default instance.

A new LLMParams instance with missing fields replaced by corresponding fields from the default instance.

- default — The default LLMParams instance used to fill in missing values in the current instance.
## ai.koog.prompt.params.LLMParams

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable open class LLMParams(val temperature: Double? = null, val maxTokens: Int? = null, val numberOfChoices: Int? = null, val speculation: String? = null, val schema: LLMParams.Schema? = null, val toolChoice: LLMParams.ToolChoice? = null, val user: String? = null, val additionalProperties: Map<String, JsonElement>? = null)
```

Represents configuration parameters for controlling the behavior of a language model.

## ai.koog.prompt.params.LLMParams.maxTokens

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/max-tokens.html`

### :prompt:prompt-model/commonMain

```kotlin
val maxTokens: Int?
```

## ai.koog.prompt.params.LLMParams.numberOfChoices

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/number-of-choices.html`

### :prompt:prompt-model/commonMain

```kotlin
val numberOfChoices: Int?
```

## ai.koog.prompt.params.LLMParams.schema

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/schema.html`

### :prompt:prompt-model/commonMain

```kotlin
val schema: LLMParams.Schema?
```

## ai.koog.prompt.params.LLMParams.speculation

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/speculation.html`

### :prompt:prompt-model/commonMain

```kotlin
val speculation: String?
```

## ai.koog.prompt.params.LLMParams.temperature

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/temperature.html`

### :prompt:prompt-model/commonMain

```kotlin
val temperature: Double?
```

## ai.koog.prompt.params.LLMParams.toolChoice

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/tool-choice.html`

### :prompt:prompt-model/commonMain

```kotlin
val toolChoice: LLMParams.ToolChoice?
```

## ai.koog.prompt.params.LLMParams.user

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.params/-l-l-m-params/user.html`

### :prompt:prompt-model/commonMain

```kotlin
val user: String?
```

## ai.koog.prompt.streaming.IncompleteStreamException.IncompleteStreamException

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-incomplete-stream-exception/-incomplete-stream-exception.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(message: String = "Stream completed without receiving an End frame", cause: Throwable? = null)
```

## ai.koog.prompt.streaming.IncompleteStreamException

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-incomplete-stream-exception/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class IncompleteStreamException(message: String = "Stream completed without receiving an End frame", cause: Throwable? = null) : Exception
```

Signals that a streaming response terminated without receiving a StreamFrame.End frame.

This typically indicates a dropped network connection during SSE streaming, where the underlying transport (e.g., Ktor SSE) completes the flow normally instead of propagating an error.

## ai.koog.prompt.streaming.StreamFrame.CompleteFrame.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-complete-frame/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.CompleteFrame

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-complete-frame/index.html`

### :prompt:prompt-model/commonMain

```kotlin
sealed interface CompleteFrame : StreamFrame
```

The interface representing a complete frame of a streaming response from a LLM.

- TextComplete
- ReasoningComplete
- ToolCallComplete
## ai.koog.prompt.streaming.StreamFrame.DeltaFrame.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-delta-frame/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
abstract val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.DeltaFrame

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-delta-frame/index.html`

### :prompt:prompt-model/commonMain

```kotlin
sealed interface DeltaFrame : StreamFrame
```

The interface representing a delta or partial frame of a streaming response from a LLM.

- TextDelta
- ReasoningDelta
- ToolCallDelta
## ai.koog.prompt.streaming.StreamFrame.End.End

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-end/-end.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(finishReason: String? = null, metaInfo: ResponseMetaInfo = ResponseMetaInfo.Empty)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.streaming.StreamFrame.End.finishReason

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-end/finish-reason.html`

### :prompt:prompt-model/commonMain

```kotlin
val finishReason: String?
```

## ai.koog.prompt.streaming.StreamFrame.End

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-end/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class End(val finishReason: String? = null, val metaInfo: ResponseMetaInfo = ResponseMetaInfo.Empty) : StreamFrame
```

Represents a frame of a streaming response from a LLM that signals the end of the stream.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.streaming.StreamFrame.End.metaInfo

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-end/meta-info.html`

### :prompt:prompt-model/commonMain

```kotlin
val metaInfo: ResponseMetaInfo
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete.ReasoningComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/-reasoning-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String?, content: List<String>, summary: List<String>? = null, encrypted: String? = null, index: Int? = null)
```

- encrypted — The encrypted text of the reasoning text.
## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/content.html`

### :prompt:prompt-model/commonMain

```kotlin
val content: List<String>
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete.encrypted

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/encrypted.html`

### :prompt:prompt-model/commonMain

```kotlin
val encrypted: String?
```

- encrypted — The encrypted text of the reasoning text.
## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ReasoningComplete(val id: String?, val content: List<String>, val summary: List<String>? = null, val encrypted: String? = null, val index: Int? = null) : StreamFrame.CompleteFrame, StreamFrame
```

Represents a frame of a streaming response from a LLM with reasoning text delta.

- encrypted — The encrypted text of the reasoning text.
## ai.koog.prompt.streaming.StreamFrame.ReasoningComplete.summary

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-complete/summary.html`

### :prompt:prompt-model/commonMain

```kotlin
val summary: List<String>?
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningDelta.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-delta/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningDelta.ReasoningDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-delta/-reasoning-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String? = null, text: String? = null, summary: String? = null, index: Int? = null)
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningDelta.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-delta/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-delta/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ReasoningDelta(val id: String? = null, val text: String? = null, val summary: String? = null, val index: Int? = null) : StreamFrame.DeltaFrame, StreamFrame
```

Represents a frame of a streaming response from a LLM with reasoning text delta.

## ai.koog.prompt.streaming.StreamFrame.ReasoningDelta.summary

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-delta/summary.html`

### :prompt:prompt-model/commonMain

```kotlin
val summary: String?
```

## ai.koog.prompt.streaming.StreamFrame.ReasoningDelta.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-reasoning-delta/text.html`

### :prompt:prompt-model/commonMain

```kotlin
val text: String?
```

## ai.koog.prompt.streaming.StreamFrame.TextComplete.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-complete/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.TextComplete.TextComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-complete/-text-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(text: String, index: Int? = null)
```

## ai.koog.prompt.streaming.StreamFrame.TextComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-complete/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class TextComplete(val text: String, val index: Int? = null) : StreamFrame.CompleteFrame, StreamFrame
```

Represents a completion of a streaming response text part.

## ai.koog.prompt.streaming.StreamFrame.TextComplete.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-complete/text.html`

### :prompt:prompt-model/commonMain

```kotlin
val text: String
```

## ai.koog.prompt.streaming.StreamFrame.TextDelta.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-delta/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.TextDelta.TextDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-delta/-text-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(text: String, index: Int? = null)
```

## ai.koog.prompt.streaming.StreamFrame.TextDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-delta/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class TextDelta(val text: String, val index: Int? = null) : StreamFrame.DeltaFrame, StreamFrame
```

Represents a frame of a streaming response from a LLM with text delta.

## ai.koog.prompt.streaming.StreamFrame.TextDelta.text

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-text-delta/text.html`

### :prompt:prompt-model/commonMain

```kotlin
val text: String
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.ToolCallComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/-tool-call-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String?, name: String, content: String, index: Int? = null)
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.contentJsonResult

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/content-json-result.html`

### :prompt:prompt-model/commonMain

```kotlin
val contentJsonResult: Result<JsonObject>
```

Lazily parses and caches the result of parsing content as a JSON object.

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.contentJson

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/content-json.html`

### :prompt:prompt-model/commonMain

```kotlin
val contentJson: JsonObject
```

Lazily parses the content of the tool call as a JSON object. Can throw an exception when parsing fails.

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/content.html`

### :prompt:prompt-model/commonMain

```kotlin
val content: String
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ToolCallComplete(val id: String?, val name: String, val content: String, val index: Int? = null) : StreamFrame.CompleteFrame, StreamFrame
```

Represents a frame of a streaming response from a LLM that contains a tool call.

## ai.koog.prompt.streaming.StreamFrame.ToolCallComplete.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-complete/name.html`

### :prompt:prompt-model/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallDelta.index

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-delta/--index--.html`

### :prompt:prompt-model/commonMain

```kotlin
open override val index: Int?
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallDelta.ToolCallDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-delta/-tool-call-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(id: String?, name: String?, content: String?, index: Int? = null)
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallDelta.content

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-delta/content.html`

### :prompt:prompt-model/commonMain

```kotlin
val content: String?
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallDelta.id

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-delta/id.html`

### :prompt:prompt-model/commonMain

```kotlin
val id: String?
```

## ai.koog.prompt.streaming.StreamFrame.ToolCallDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-delta/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable data class ToolCallDelta(val id: String?, val name: String?, val content: String?, val index: Int? = null) : StreamFrame.DeltaFrame, StreamFrame
```

Represents a frame of a streaming response from a LLM that contains a tool call.

## ai.koog.prompt.streaming.StreamFrame.ToolCallDelta.name

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/-tool-call-delta/name.html`

### :prompt:prompt-model/commonMain

```kotlin
val name: String?
```

## ai.koog.prompt.streaming.StreamFrame

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame/index.html`

### :prompt:prompt-model/commonMain

```kotlin
@Serializable sealed interface StreamFrame
```

Represents a frame of a streaming response from a LLM.

- CompleteFrame
- DeltaFrame
- TextDelta
- TextComplete
- ReasoningDelta
- ReasoningComplete
- ToolCallDelta
- ToolCallComplete
- End
## ai.koog.prompt.streaming.StreamFrameFlowBuilder.StreamFrameFlowBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/-stream-frame-flow-builder.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(flowCollector: FlowCollector<StreamFrame>)
```

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.emitEnd

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/emit-end.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun emitEnd(finishReason: String? = null, metaInfo: ResponseMetaInfo? = null)
```

Emits a StreamFrame.End with the given finishReason.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.emitReasoningDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/emit-reasoning-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun emitReasoningDelta(id: String? = null, text: String? = null, summary: String? = null, index: Int? = null)
```

Emits a StreamFrame.ReasoningDelta with the given text.

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.emitTextDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/emit-text-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun emitTextDelta(text: String, index: Int? = null)
```

Emits a StreamFrame.TextDelta with the given text.

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.emitToolCallDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/emit-tool-call-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun emitToolCallDelta(id: String? = null, name: String? = null, args: String? = null, index: Int? = null)
```

Updates the coroutine context to signal we're currently combining a tool call, this does not emit anything yet, that happens only in tryEmitPendingToolCall.

- StreamFrameFlowBuilderError — if there is
## ai.koog.prompt.streaming.StreamFrameFlowBuilder

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class StreamFrameFlowBuilder(flowCollector: FlowCollector<StreamFrame>)
```

Represents a wrapper around a FlowCollector that provides methods for emitting StreamFrame objects.

This is mainly used for combining chunked tool calls and only emit completed tool calls.

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.tryEmitPendingReasoning

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/try-emit-pending-reasoning.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun tryEmitPendingReasoning()
```

Emits a pendingReasoningRef if it exists and then clears it.

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.tryEmitPendingText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/try-emit-pending-text.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun tryEmitPendingText()
```

Emits a pendingTextRef if it exists and then clears it.

## ai.koog.prompt.streaming.StreamFrameFlowBuilder.tryEmitPendingToolCall

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder/try-emit-pending-tool-call.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun tryEmitPendingToolCall()
```

Emits a pendingToolCallRef if it exists and then clears it.

## ai.koog.prompt.streaming.StreamFrameFlowBuilderError.NoPartialToolCallToComplete.NoPartialToolCallToComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder-error/-no-partial-tool-call-to-complete/-no-partial-tool-call-to-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.streaming.StreamFrameFlowBuilderError.NoPartialToolCallToComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder-error/-no-partial-tool-call-to-complete/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class NoPartialToolCallToComplete : StreamFrameFlowBuilderError
```

Occurs when trying to upsert partial tool call data (e.g., parts of the tool arguments contents) when there is no pre-existing partial tool call data to append to.

The first partial tool call data for a new tool call should always include the id.

## ai.koog.prompt.streaming.StreamFrameFlowBuilderError.UnexpectedPartialToolCallIndex.UnexpectedPartialToolCallIndex

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder-error/-unexpected-partial-tool-call-index/-unexpected-partial-tool-call-index.html`

### :prompt:prompt-model/commonMain

```kotlin
constructor(expectedIndex: Int?, actualIndex: Int?)
```

## ai.koog.prompt.streaming.StreamFrameFlowBuilderError.UnexpectedPartialToolCallIndex

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder-error/-unexpected-partial-tool-call-index/index.html`

### :prompt:prompt-model/commonMain

```kotlin
class UnexpectedPartialToolCallIndex(expectedIndex: Int?, actualIndex: Int?) : StreamFrameFlowBuilderError
```

Occurs when the index of a partial tool call that lacks an id does not match the to-be completed tool call's index.

## ai.koog.prompt.streaming.StreamFrameFlowBuilderError

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/-stream-frame-flow-builder-error/index.html`

### :prompt:prompt-model/commonMain

```kotlin
sealed class StreamFrameFlowBuilderError : Throwable
```

Represents an error that can occur during buildStreamFrameFlow operations.

- NoPartialToolCallToComplete
- UnexpectedPartialToolCallIndex
## ai.koog.prompt.streaming.buildStreamFrameFlow

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/build-stream-frame-flow.html`

### :prompt:prompt-model/commonMain

```kotlin
fun buildStreamFrameFlow(block: suspend StreamFrameFlowBuilder.() -> Unit): Flow<StreamFrame>
```

Builds a Flow of StreamFrame objects. Should be used only in case model does not produce completion events.

## ai.koog.prompt.streaming.collectText

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/collect-text.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun Flow<StreamFrame>.collectText(): String
```

Collects the textual content of a Flow of StreamFrame objects and returns it as a single string.

## ai.koog.prompt.streaming.emitEnd

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-end.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitEnd(finishReason: String? = null, metaInfo: ResponseMetaInfo? = null)
```

Emits a StreamFrame.End with the given finishReason.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.streaming.emitReasoningComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-reasoning-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitReasoningComplete(id: String? = null, text: String, summary: String? = null, encrypted: String? = null, index: Int? = null)
```

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitReasoningComplete(id: String? = null, text: List<String>, summary: List<String>? = null, encrypted: String? = null, index: Int? = null)
```

Emits a StreamFrame.ReasoningComplete with the given text.

## ai.koog.prompt.streaming.emitReasoningDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-reasoning-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitReasoningDelta(id: String? = null, text: String? = null, summary: String? = null, index: Int? = null)
```

Emits a StreamFrame.ReasoningDelta with the given text and summary.

## ai.koog.prompt.streaming.emitTextComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-text-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitTextComplete(text: String, index: Int? = null)
```

Emits a StreamFrame.TextComplete with the given text.

## ai.koog.prompt.streaming.emitTextDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-text-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitTextDelta(text: String, index: Int? = null)
```

Emits a StreamFrame.TextDelta with the given text.

## ai.koog.prompt.streaming.emitToolCallComplete

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-tool-call-complete.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitToolCallComplete(id: String?, name: String, content: String, index: Int? = null)
```

Emits a StreamFrame.ToolCallComplete with the given id, name and content.

## ai.koog.prompt.streaming.emitToolCallDelta

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/emit-tool-call-delta.html`

### :prompt:prompt-model/commonMain

```kotlin
suspend fun FlowCollector<StreamFrame>.emitToolCallDelta(id: String?, name: String?, content: String?, index: Int? = null)
```

Emits a StreamFrame.ToolCallDelta with the given id, name and content.

## ai.koog.prompt.streaming.filterTextOnly

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/filter-text-only.html`

### :prompt:prompt-model/commonMain

```kotlin
fun Flow<StreamFrame>.filterTextOnly(): Flow<String>
```

Returns a transformed flow of StreamFrame.TextDelta objects that contains only the textual content.

## ai.koog.prompt.streaming.requireEndFrame

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/require-end-frame.html`

### :prompt:prompt-model/commonMain

```kotlin
fun Flow<StreamFrame>.requireEndFrame(): Flow<StreamFrame>
```

Ensures that the stream contains a StreamFrame.End frame before completing.

If the flow completes normally without emitting a StreamFrame.End frame, an IncompleteStreamException is thrown. This detects dropped connections during SSE streaming where the transport silently completes the flow.

If the flow already terminates with an exception, that exception is propagated without additionally throwing IncompleteStreamException.

## ai.koog.prompt.streaming.streamFrameFlowOf

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/stream-frame-flow-of.html`

### :prompt:prompt-model/commonMain

```kotlin
fun streamFrameFlowOf(vararg content: String): Flow<StreamFrame.TextDelta>
```

Create a Flow of StreamFrame.TextDelta objects from a list of String content.

## ai.koog.prompt.streaming.streamFrameFlow

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/stream-frame-flow.html`

### :prompt:prompt-model/commonMain

```kotlin
fun streamFrameFlow(block: suspend FlowCollector<StreamFrame>.() -> Unit): Flow<StreamFrame>
```

Builds a Flow of StreamFrame objects.

- emitTextDelta — for emitting a StreamFrame.TextDelta object.
- emitTextComplete — for emitting a StreamFrame.TextComplete object.
- emitReasoningDelta — for emitting a StreamFrame.ReasoningDelta object.
- emitReasoningComplete — for emitting a StreamFrame.ReasoningComplete object.
- emitToolCallDelta — for emitting a StreamFrame.ToolCallDelta object.
- emitToolCallComplete — for emitting a StreamFrame.ToolCallComplete object.
- emitEnd — for emitting a StreamFrame.End object.
## ai.koog.prompt.streaming.toMessageResponse

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/to-message-response.html`

### :prompt:prompt-model/commonMain

```kotlin
fun Iterable<StreamFrame>.toMessageResponse(): Message.Assistant
```

Converts frames into Message.Assistant objects.

Collects all complete frames into one Message.Assistant objects.

A list of Message.Assistant objects.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.streaming.toStreamFrames

Module: `prompt-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-model/ai.koog.prompt.streaming/to-stream-frames.html`

### :prompt:prompt-model/commonMain

```kotlin
fun Message.Assistant.toStreamFrames(): List<StreamFrame>
```

Converts a Message.Assistant to a list of StreamFrame. First it emits the delta frames for each content part for each message, then complete frame with the full message content.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.xml.XmlContentBuilder.XmlContentBuilder

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/-xml-content-builder.html`

### :prompt:prompt-xml/commonMain

```kotlin
constructor(indented: Boolean)
```

## ai.koog.prompt.xml.XmlContentBuilder.cdata

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/cdata.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun cdata(content: String)
```

Adds a CDATA section to the content.

- content — The content to be wrapped in CDATA
## ai.koog.prompt.xml.XmlContentBuilder.comment

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/comment.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun comment(comment: String)
```

Adds an XML comment to the content.

- comment — The comment text
## ai.koog.prompt.xml.XmlContentBuilder.doctype

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/doctype.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun doctype(rootElement: String, publicId: String? = null, systemId: String? = null)
```

Adds a DOCTYPE declaration to the content.

- rootElement — The root element name
- publicId — The public identifier (optional)
- systemId — The system identifier (optional)
## ai.koog.prompt.xml.XmlContentBuilder

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/index.html`

### :prompt:prompt-xml/commonMain

```kotlin
class XmlContentBuilder(indented: Boolean) : TextContentBuilder
```

A dedicated builder for creating XML content. Wraps TextContentBuilder and provides XML-specific functionality.


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.xml.XmlContentBuilder.processingInstruction

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/processing-instruction.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun processingInstruction(target: String, data: String)
```

Adds a processing instruction to the content.

- target — The processing instruction target
- data — The processing instruction data
## ai.koog.prompt.xml.XmlContentBuilder.selfClosingTag

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/self-closing-tag.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun selfClosingTag(name: String, attributes: LinkedHashMap<String, String> = linkedMapOf())
```

Creates a self-closing XML tag with the given name and attributes.

- name — The tag name
- attributes — The tag attributes as key-value pairs
## ai.koog.prompt.xml.XmlContentBuilder.tag

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/tag.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun tag(name: String, attributes: LinkedHashMap<String, String> = linkedMapOf(), block: XmlContentBuilder.() -> Unit = {})
```

Creates an XML tag with the given name, attributes, and content.

- name — The tag name
- attributes — The tag attributes as key-value pairs
- block — The content builder
## ai.koog.prompt.xml.XmlContentBuilder.unaryPlus

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/unary-plus.html`

### :prompt:prompt-xml/commonMain

```kotlin
open operator override fun String.unaryPlus()
```

## ai.koog.prompt.xml.XmlContentBuilder.xmlDeclaration

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/-xml-content-builder/xml-declaration.html`

### :prompt:prompt-xml/commonMain

```kotlin
fun xmlDeclaration(version: String = "1.0", encoding: String = "UTF-8", standalone: Boolean? = null)
```

Adds an XML declaration to the document.

- version — The XML version (default is "1.0")
- encoding — The character encoding (default is "UTF-8")
- standalone — Whether the document is standalone (default is null, which means the attribute is not included)
## ai.koog.prompt.xml.xml

Module: `prompt-xml`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-xml/ai.koog.prompt.xml/xml.html`

### :prompt:prompt-xml/commonMain

```kotlin
inline fun StringBuilder.xml(indented: Boolean = true, init: XmlContentBuilder.() -> Unit)
```

Extension function to add XML content to a StringBuilder.

- init — The XML content builder
### :prompt:prompt-xml/commonMain

```kotlin
inline fun TextContentBuilderBase<*>.xml(indented: Boolean = true, init: XmlContentBuilder.() -> Unit)
```

Extension function to add XML content to a TextContentBuilder.

- init — The XML content builder

Referenced packages: `ai.koog.prompt.text`.

### :prompt:prompt-xml/commonMain

```kotlin
fun xml(indented: Boolean = true, init: XmlContentBuilder.() -> Unit): String
```

Creates an XML document with the given content.

The XML document as a string

- init — The content builder