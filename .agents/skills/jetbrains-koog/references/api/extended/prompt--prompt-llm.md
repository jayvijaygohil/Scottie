# prompt / prompt-llm

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.llm.AlibabaLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-alibaba-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object AlibabaLLMProvider : LLMProvider
```

Represents Alibaba as a specific provider of Large Language Models (LLMs).

This class is a subclass of the LLMProvider sealed class, and it defines Alibaba's unique identifier and display name. It is used in configurations or model selections to specify Alibaba as the chosen provider.

## ai.koog.prompt.llm.AnthropicLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-anthropic-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object AnthropicLLMProvider : LLMProvider
```

Represents the Anthropic LLM provider.

This class is a concrete instance of the LLMProvider sealed class, specifically for Anthropic. It defines the unique identifier and display name associated with Anthropic as a provider of large language models.

Use this object to reference or configure language models provided by Anthropic in the context of an LLM system.

## ai.koog.prompt.llm.AzureLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-azure-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object AzureLLMProvider : LLMProvider
```

Represents the Azure OpenAI provider.

ElevenLabs is identified by its unique ID ("azure") and display name ("Azure OpenAI").

## ai.koog.prompt.llm.BedrockLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-bedrock-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object BedrockLLMProvider : LLMProvider
```

Represents the AWS Bedrock provider within the available set of large language model providers.

Bedrock is identified by its unique ID ("bedrock") and display name ("AWS Bedrock"). It extends the LLMProvider sealed class, which serves as a base class for all supported language model providers.

This class adheres to the structure and serialization requirements defined by the parent class. It is part of the available LLM provider hierarchy, which is used to configure and identify specific providers for large language model functionalities and capabilities.

## ai.koog.prompt.llm.DeepSeekLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-deep-seek-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object DeepSeekLLMProvider : LLMProvider
```

Represents the DeepSeek provider within the available set of large language model providers.

DeepSeek is identified by its unique ID ("deepseek") and display name ("DeepSeek"). It extends the LLMProvider sealed class, which serves as a base class for all supported language model providers.

This class adheres to the structure and serialization requirements defined by the parent class. It is part of the available LLM provider hierarchy, which is used to configure and identify specific providers for large language model functionalities and capabilities.

## ai.koog.prompt.llm.GoogleLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-google-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object GoogleLLMProvider : LLMProvider
```

Represents a specialized implementation of the LLMProvider class corresponding to the Google provider.

The Google object is a predefined instance of LLMProvider, with its id and display properties set to "google" and "Google" respectively. It serves as an enumeration-like representation to identify and work with the Google Large Language Model provider in the system.

This object can be used in situations where the provider-specific attributes or operations related to Google's language model are required.

## ai.koog.prompt.llm.HuggingFaceLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-hugging-face-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object HuggingFaceLLMProvider : LLMProvider
```

Represents the Hugging Face Large Language Model provider.

HuggingFace is identified by its unique ID ("huggingface") and display name ("Hugging Face").

## ai.koog.prompt.llm.LLMProvider.equals

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/equals.html`

### :prompt:prompt-llm/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.llm.LLMProvider.hashCode

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-l-l-m-provider/hash-code.html`

### :prompt:prompt-llm/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.llm.MetaLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-meta-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object MetaLLMProvider : LLMProvider
```

Represents the "Meta" large language model provider in the system.

The Meta object is a concrete implementation of the LLMProvider class, identifying the Meta provider with a predefined id and display name. It is used to associate models and capabilities specific to the Meta platform across the application.

## ai.koog.prompt.llm.MiniMaxLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-mini-max-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object MiniMaxLLMProvider : LLMProvider
```

Represents the MiniMax Large Language Model provider.

MiniMax is identified by its unique ID ("minimax") and display name ("MiniMax").

## ai.koog.prompt.llm.MistralAILLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-mistral-a-i-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object MistralAILLMProvider : LLMProvider
```

Represents the Mistral AI provider within the available set of large language model providers.

MistralAI is identified by its unique ID ("mistralai") and display name ("MistralAI"). It extends the LLMProvider sealed class, which serves as a base class for all supported language model providers.

This class adheres to the structure and serialization requirements defined by the parent class. It is part of the available LLM provider hierarchy, which is used to configure and identify specific providers for large language model functionalities and capabilities.

## ai.koog.prompt.llm.OCILLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-o-c-i-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object OCILLMProvider : LLMProvider
```

Represents the Oracle Cloud Infrastructure (OCI) Generative AI provider.

Oracle is identified by its unique ID ("oci") and display name ("OCI").

## ai.koog.prompt.llm.OllamaLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-ollama-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object OllamaLLMProvider : LLMProvider
```

Represents the Ollama provider within the available set of large language model providers.

Ollama is identified by its unique ID ("ollama") and display name ("Ollama"). It extends the LLMProvider sealed class, which serves as a base class for all supported language model providers.

This class adheres to the structure and serialization requirements defined by the parent class. It is part of the available LLM provider hierarchy, which is used to configure and identify specific providers for large language model functionalities and capabilities.

## ai.koog.prompt.llm.OpenAILLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-open-a-i-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object OpenAILLMProvider : LLMProvider
```

Represents the OpenAI provider in the Large Language Model (LLM) ecosystem.

OpenAI, identified by the id value "openai", is a specific implementation of the LLMProvider sealed class. This class is used to define and distinguish the OpenAI provider as part of the supported LLM providers.

This provider can be utilized to configure LLM-based models, allowing developers to leverage OpenAI's capabilities within various applications or systems.

## ai.koog.prompt.llm.OpenRouterLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-open-router-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object OpenRouterLLMProvider : LLMProvider
```

Represents the OpenRouter provider within the available set of large language model providers.

OpenRouter is identified by its unique ID ("openrouter") and display name ("OpenRouter"). It extends the LLMProvider sealed class, which serves as a base class for all supported language model providers.

This class adheres to the structure and serialization requirements defined by the parent class. It is part of the available LLM provider hierarchy, which is used to configure and identify specific providers for large language model functionalities and capabilities.

## ai.koog.prompt.llm.VertexLLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-vertex-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object VertexLLMProvider : LLMProvider
```

Represents the Google VertexAI provider.

StabilityAI is identified by its unique ID ("vertex") and display name ("Google VertexAI").

## ai.koog.prompt.llm.ZhipuAILLMProvider

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/-zhipu-a-i-l-l-m-provider/index.html`

### :prompt:prompt-llm/commonMain

```kotlin
@Serializable object ZhipuAILLMProvider : LLMProvider
```

Represents the ZhipuAI (智谱AI) Large Language Model provider.

ZhipuAI is identified by its unique ID ("zhipuai") and display name ("ZhipuAI").

## ai.koog.prompt.llm.toModelInfo

Module: `prompt-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-llm/ai.koog.prompt.llm/to-model-info.html`

### :prompt:prompt-llm/commonMain

```kotlin
fun LLModel.toModelInfo(): ModelInfo
```

Converts this LLModel to a ModelInfo instance


Referenced packages: `ai.koog.agents.utils`.
