# prompt / prompt-executor / prompt-executor-clients / prompt-executor-bedrock-client

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.clients.bedrock.BedrockAPIMethod.Converse

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-a-p-i-method/-converse/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
object Converse : BedrockAPIMethod
```

Defines /model/{modelId}/converse API method. Provides a consistent interface that works with all models that support messages. Supports custom inference parameters for models that require it.

AWS API docs

## ai.koog.prompt.executor.clients.bedrock.BedrockAPIMethod.InvokeModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-a-p-i-method/-invoke-model/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
object InvokeModel : BedrockAPIMethod
```

Defines /model/{modelId}/invoke API method. When using this method, request body is formatted manually and is specific to the invoked model.

Consider using Converse if possible, since this is a newer method aiming to provide a consistent interface for all models.

AWS API docs

## ai.koog.prompt.executor.clients.bedrock.BedrockAPIMethod

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-a-p-i-method/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
sealed interface BedrockAPIMethod
```

Defines Bedrock API methods to interact with the models that support messages.

- InvokeModel
- Converse
## ai.koog.prompt.executor.clients.bedrock.BedrockGuardrailsSettings.BedrockGuardrailsSettings

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-guardrails-settings/-bedrock-guardrails-settings.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(guardrailIdentifier: String, guardrailVersion: String)
```

## ai.koog.prompt.executor.clients.bedrock.BedrockGuardrailsSettings.guardrailIdentifier

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-guardrails-settings/guardrail-identifier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val guardrailIdentifier: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockGuardrailsSettings.guardrailVersion

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-guardrails-settings/guardrail-version.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val guardrailVersion: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockGuardrailsSettings

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-guardrails-settings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
class BedrockGuardrailsSettings(val guardrailIdentifier: String, val guardrailVersion: String)
```

Represents the settings configuration for Bedrock guardrails.

See AWS documentation for more information

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.AF

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-a-f/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AF
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.AP

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-a-p/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.CA

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-c-a/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
CA
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.EU

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-e-u/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.GLOBAL

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-g-l-o-b-a-l/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
GLOBAL
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.IL

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-i-l/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
IL
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.ME

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-m-e/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
ME
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.MX

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-m-x/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
MX
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.SA

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-s-a/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
SA
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.US

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/-u-s/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
US
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.entries

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val entries: EnumEntries<BedrockInferencePrefixes>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable enum BedrockInferencePrefixes : Enum<BedrockInferencePrefixes>
```

AWS Bedrock inference ID prefixes.

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.prefix

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/prefix.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val prefix: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.toString

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.valueOf

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
fun valueOf(value: String): BedrockInferencePrefixes
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.bedrock.BedrockInferencePrefixes.values

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-inference-prefixes/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
fun values(): Array<BedrockInferencePrefixes>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.bedrock.BedrockModel.BedrockModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/-bedrock-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(model: LLModel, modelId: String = model.id, inferenceProfilePrefix: String? = BedrockInferencePrefixes.US.prefix)
```

- model — The base LLModel to use.
- modelId — The ID of the used model. Defaults to the ID of the provided model.
- inferenceProfilePrefix — Optional prefix to prepend to the model ID. If null, no prefix is used.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModel.effectiveModelId

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/effective-model-id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val effectiveModelId: String
```

Returns the effective model ID, only adds inference profile prefix if provided.

## ai.koog.prompt.executor.clients.bedrock.BedrockModel.effectiveModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/effective-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val effectiveModel: LLModel
```

Returns the LLModel with the effective model ID.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class BedrockModel(val model: LLModel, val modelId: String = model.id, val inferenceProfilePrefix: String? = BedrockInferencePrefixes.US.prefix)
```

Represents a Bedrock model with an optional inference profile prefix.

This allows users to explicitly specify an inference profile prefix that will be prepended to the model ID when making requests to AWS Bedrock. If the prefix is null, no prefix will be added, and the model ID will be used as-is. If a value is provided, the effective model ID will be ".".

- model — The base LLModel to use.
- modelId — The ID of the used model. Defaults to the ID of the provided model.
- inferenceProfilePrefix — Optional prefix to prepend to the model ID. If null, no prefix is used.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModel.inferenceProfilePrefix

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/inference-profile-prefix.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val inferenceProfilePrefix: String?
```

- inferenceProfilePrefix — Optional prefix to prepend to the model ID. If null, no prefix is used.
## ai.koog.prompt.executor.clients.bedrock.BedrockModel.modelId

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/model-id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val modelId: String
```

- modelId — The ID of the used model. Defaults to the ID of the provided model.
## ai.koog.prompt.executor.clients.bedrock.BedrockModel.model

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val model: LLModel
```

- model — The base LLModel to use.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.AmazonNova

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-amazon-nova/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object AmazonNova : BedrockModelFamilies
```

Represents the Amazon sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.AnthropicClaude

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-anthropic-claude/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object AnthropicClaude : BedrockModelFamilies
```

Represents the Anthropic sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.Cohere

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-cohere/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object Cohere : BedrockModelFamilies
```

Represents the Cohere sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.GoogleGemma

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-google-gemma/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object GoogleGemma : BedrockModelFamilies
```

Represents the Google sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.Meta

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-meta/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object Meta : BedrockModelFamilies
```

Represents the Meta sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.MiniMax

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-mini-max/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object MiniMax : BedrockModelFamilies
```

Represents the MiniMax sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.MoonshotKimi

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-moonshot-kimi/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object MoonshotKimi : BedrockModelFamilies
```

Represents the Moonshot AI (Kimi) sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.OpenAI

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-open-a-i/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object OpenAI : BedrockModelFamilies
```

Represents the OpenAI sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.TitanEmbedding

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/-titan-embedding/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data object TitanEmbedding : BedrockModelFamilies
```

Represents the Amazon Titan sub-provider under AWS Bedrock.

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.display

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/display.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val display: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies.id

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val id: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockModelFamilies

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-model-families/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable sealed class BedrockModelFamilies
```

Represents a sealed class for AWS Bedrock model families.

This class serves as a hierarchy for different sub-providers under the AWS Bedrock ecosystem. Each sub-provider is represented as a specific sealed data object with an associated unique identifier and display name.

- AnthropicClaude
- AmazonNova
- Meta
- TitanEmbedding
- Cohere
- MoonshotKimi
- GoogleGemma
- MiniMax
- OpenAI
## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AmazonNovaLite

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-amazon-nova-lite.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonNovaLite: LLModel
```

Amazon Nova Lite - Balanced performance and cost

Optimized for:

General text tasks

Moderate complexity reasoning

Cost-sensitive applications

Good balance of speed and quality


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AmazonNovaMicro

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-amazon-nova-micro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonNovaMicro: LLModel
```

Amazon Nova Micro - Ultra-fast, low-cost model for simple tasks

Amazon's most cost-effective model for:

Simple text generation

Basic Q&A tasks

High-volume applications

Quick responses


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AmazonNovaPremier

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-amazon-nova-premier.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonNovaPremier: LLModel
```

Amazon Nova Premier - Amazon's most capable model

Amazon's flagship model for:

Most complex reasoning tasks

Highest quality outputs

Enterprise applications

Mission-critical use cases


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AmazonNovaPro

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-amazon-nova-pro.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonNovaPro: LLModel
```

Amazon Nova Pro - High-performance model for complex tasks

Amazon's advanced model for:

Complex reasoning

Long-form content generation

Advanced text understanding

Professional use cases


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AmazonNova2Lite

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-amazon-nova2-lite.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonNova2Lite: LLModel
```

Amazon Nova 2 Lite - Fast, cost-effective reasoning model for everyday workloads

Part of the Amazon Nova 2 family announced at re:Invent 2025:

Extended thinking with three intensity levels (low, medium, high)

1M token context window

Multimodal understanding (text, image, video)

Tool/function calling support


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaudeFable5

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude-fable5.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaudeFable5: LLModel
```

Claude Fable 5 is Anthropic's most capable widely released model, built for the most demanding reasoning and long-horizon agentic work.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude4Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude4-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude4Opus: LLModel
```

Claude 4 Opus - Anthropic's previous flagship model

This model sets new standards in:

Complex reasoning and advanced coding

Autonomous management of complex, multi-step tasks

Extended thinking for deeper reasoning

AI agent capabilities for orchestrating workflows

Multimodal understanding (text and images)

Tool/function calling with parallel execution

Memory capabilities for maintaining continuity


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude4Sonnet

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude4-sonnet.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude4Sonnet: LLModel
```

Claude 4 Sonnet - High-performance model with exceptional reasoning and efficiency

This model offers:

Superior coding and reasoning capabilities

High-volume use case optimization

Extended thinking mode for complex problems

Task-specific sub-agent functionality

Multimodal understanding (text and images)

Tool/function calling with parallel execution

Precise instruction following


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude41Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude41-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude41Opus: LLModel
```

Claude 4.1 Opus sets new standards in:

Complex reasoning and advanced coding

Autonomous management of complex, multi-step tasks

Extended thinking for deeper reasoning

AI agent capabilities for orchestrating workflows

Multimodal understanding (text and images)

Tool/function calling with parallel execution

Memory capabilities for maintaining continuity


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude45Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude45-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude45Opus: LLModel
```

Claude 4.5 Opus - Anthropic's intelligent, efficient, and the best model in the world for coding, agents, and computer use. It’s also meaningfully better at everyday tasks like deep research and working with slides and spreadsheets. Opus 4.5 is a step forward in what AI systems can do, and a preview of larger changes to how work gets done.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude46Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude46-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude46Opus: LLModel
```

Claude Opus 4.6 is a frontier model with strong capabilities in software engineering, agentic tasks, and long context reasoning, as well as in knowledge work—including financial analysis, document creation, and multi-step research workflows.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude47Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude47-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude47Opus: LLModel
```

Claude Opus 4.7 is Anthropic's latest generally available Opus model for advanced coding, long-running agents, knowledge work, and higher-resolution vision tasks.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude48Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude48-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude48Opus: LLModel
```

Claude Opus 4.8 is the most capable model in the Opus 4 series — highly autonomous, with state-of-the-art long-horizon agentic execution, knowledge work, and memory.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude4_5Haiku

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude4_5-haiku.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude4_5Haiku: LLModel
```

Claude Haiku 4.5 - Anthropic's most powerful model for powering real-world agents, with industry-leading capabilities around coding, and computer use.

It delivers near-frontier performance for a wide range of use cases, and stands out as one of the best coding and agent models – with the right speed and cost to power free products and high-volume user experiences.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude4_5Sonnet

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude4_5-sonnet.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude4_5Sonnet: LLModel
```

Claude 4.5 Sonnet - High-performance model with enhanced capabilities

This model offers:

Superior coding and agentic capabilities

Enhanced performance on complex tasks

Improved instruction following

Advanced multimodal understanding (text and images)

Tool/function calling with parallel execution

Optimized for both quality and efficiency


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude4_6Sonnet

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude4_6-sonnet.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude4_6Sonnet: LLModel
```

Claude 4.6 Sonnet laude Sonnet 4.6 suggests the best combination of speed and intelligence. It’s a full upgrade of the model’s skills across coding, computer use, long-context reasoning, agent planning, knowledge work, and design.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude5Opus

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude5-opus.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude5Opus: LLModel
```

Claude Opus 5 is the first Opus model of Anthropic's fifth generation — a step-change over Opus 4.8 for complex agentic coding and enterprise work, strongest on deep reasoning and long-horizon tasks. Thinking is enabled by default on this model.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.AnthropicClaude5Sonnet

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-anthropic-claude5-sonnet.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AnthropicClaude5Sonnet: LLModel
```

Claude Sonnet 5 is the first Sonnet model of Anthropic's fifth generation, delivering near-Opus quality on coding and agentic work at Sonnet pricing. Adaptive thinking is enabled by default on this model.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.Embeddings.AmazonTitanEmbedTextV2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-embeddings/-amazon-titan-embed-text-v2.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonTitanEmbedTextV2: LLModel
```

Amazon Titan Text Embeddings V2 Input: Text Output: Embedding


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.Embeddings.AmazonTitanEmbedText

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-embeddings/-amazon-titan-embed-text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val AmazonTitanEmbedText: LLModel
```

Amazon Titan Embeddings G1 - Text Input: Text Output: Embedding


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.Embeddings.CohereEmbedEnglishV3

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-embeddings/-cohere-embed-english-v3.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val CohereEmbedEnglishV3: LLModel
```

Cohere Embed English v3 Input: Text Output: Embedding


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.Embeddings.CohereEmbedMultilingualV3

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-embeddings/-cohere-embed-multilingual-v3.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val CohereEmbedMultilingualV3: LLModel
```

Cohere Embed Multilingual v3 Input: Text Output: Embedding


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.Embeddings.CohereEmbedV4

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-embeddings/-cohere-embed-v4.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val CohereEmbedV4: LLModel
```

Cohere Embed v4 Multimodal embedding model supporting text, images, and complex documents. Input: Text (image/document embedding not yet supported by this client) Output: Embedding (1536 dimensions by default, configurable: 256, 512, 1024, 1536)


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.Embeddings

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-embeddings/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
object Embeddings
```

Embedding models available through the AWS Bedrock API.

Note: Multimodality (image, audio, video) embeddings are currently not supported by the Bedrock client. Only embedding models that take textual input and return embeddings are included in this object.

For up-to-date information on available models, see: https://docs.aws.amazon.com/bedrock/latest/userguide/models-supported.html

If multimodal support is added to the Bedrock client in the future, embedding models with image/audio/video inputs should be added here and their capabilities extended accordingly.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.GoogleGemma3_12BIt

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-google-gemma3_12-b-it.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val GoogleGemma3_12BIt: LLModel
```

Google Gemma 3 12B IT - Instruction-tuned model with multimodal and structured output support

Features:

128K context window

12 billion parameters

Multimodal: text and image inputs

Structured output support

Tool calling support

Multilingual support (140+ languages)

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.GoogleGemma3_27BIt

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-google-gemma3_27-b-it.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val GoogleGemma3_27BIt: LLModel
```

Google Gemma 3 27B IT - Largest Gemma 3 model with full multimodal and structured output support

Features:

128K context window

27 billion parameters

Multimodal: text and image inputs

Structured output support

Tool calling support

Multilingual support (140+ languages)

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.GoogleGemma3_4BIt

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-google-gemma3_4-b-it.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val GoogleGemma3_4BIt: LLModel
```

Google Gemma 3 4B IT - Compact instruction-tuned model for on-device and edge deployment

Features:

128K context window

4 billion parameters

Multimodal: text and image inputs

Tool calling support

Multilingual support (140+ languages)

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_0_70BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_0_70-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_0_70BInstruct: LLModel
```

Meta's Llama 3 70B Instruct

Features:

70 billion parameters

Llama 3 architecture

Superior instruction following

Advanced reasoning


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_0_8BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_0_8-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_0_8BInstruct: LLModel
```

Meta's Llama 3 8B Instruct

Features:

8 billion parameters

Llama 3 architecture

Strong instruction following

Efficient performance


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_1_405BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_1_405-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_1_405BInstruct: LLModel
```

Meta's Llama 3.1 405B Instruct

Features:

405 billion parameters

Llama 3.1 architecture

Superior instruction following

Advanced reasoning


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_1_70BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_1_70-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_1_70BInstruct: LLModel
```

Meta's Llama 3.1 70B Instruct

Features:

70 billion parameters

Llama 3.1 architecture

Superior instruction following

Advanced reasoning


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_1_8BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_1_8-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_1_8BInstruct: LLModel
```

Meta's Llama 3.1 8B Instruct

Features:

8 billion parameters

Llama 3.1 architecture

Strong instruction following

Efficient performance


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_2_1BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_2_1-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_2_1BInstruct: LLModel
```

Meta's Llama 3.2 1B Instruct

Features:

1 billion parameters

Llama 3.2 architecture

Strong instruction following

Efficient performance


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_2_11BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_2_11-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_2_11BInstruct: LLModel
```

Meta's Llama 3.2 11B Instruct

Features:

11 billion parameters

Llama 3.2 architecture

Strong instruction following

Efficient performance


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_2_3BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_2_3-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_2_3BInstruct: LLModel
```

Meta's Llama 3.2 3B Instruct

Features:

3 billion parameters

Llama 3.2 architecture

Strong instruction following

Efficient performance


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_2_90BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_2_90-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_2_90BInstruct: LLModel
```

Meta's Llama 3.2 90B Instruct

Features:

90 billion parameters

Llama 3.2 architecture

Superior instruction following

Advanced reasoning


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MetaLlama3_3_70BInstruct

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-meta-llama3_3_70-b-instruct.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MetaLlama3_3_70BInstruct: LLModel
```

Meta's Llama 3.3 70B Instruct

Features:

70 billion parameters

Llama 3.3 architecture

Superior instruction following

Advanced reasoning


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MiniMaxM2_5

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-mini-max-m2_5.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MiniMaxM2_5: LLModel
```

MiniMax M2.5 - Agent-native frontier model optimized for efficient reasoning and task decomposition

Features:

1M token context window

Trained for efficient reasoning and optimal task decomposition

Strong tool calling (76.9% on Berkeley Function Calling Leaderboard)

High inference throughput with token-efficient reasoning

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MoonshotKimiK2Thinking

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-moonshot-kimi-k2-thinking.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MoonshotKimiK2Thinking: LLModel
```

Moonshot Kimi K2 Thinking - Advanced reasoning model with extended thinking capabilities

Kimi K2 Thinking is a sparse Mixture-of-Experts model with one trillion total parameters, with only 32 billion parameters activating per inference.

Features:

256K context window

Deep reasoning with interleaved chain-of-thought

Robust tool calling (supports 200-300 sequential tool calls)

Native INT4 quantization for 2x speed-up

Strong performance on research-heavy, multistep workflows

Enhanced Chinese language reasoning capabilities

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse). When using this model, ensure you configure BedrockClientSettings with BedrockAPIMethod.Converse.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.MoonshotKimiK2_5

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-moonshot-kimi-k2_5.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val MoonshotKimiK2_5: LLModel
```

Moonshot Kimi K2.5 - Multimodal model with improved reasoning, coding, and multilingual capabilities

Features:

256K context window

Multimodal: text and image inputs

Tool calling with dual-mode reasoning

Strong multilingual capabilities

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.OpenAIGptOss120B

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-open-a-i-gpt-oss120-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val OpenAIGptOss120B: LLModel
```

OpenAI GPT-OSS 120B - Mixture-of-Experts model for complex reasoning tasks

Features:

128K context window

MoE architecture: 117B total params, 5.1B active per token

Strong at coding, mathematics, and agentic tool use

Structured output support

Adjustable reasoning levels (low/medium/high)

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.OpenAIGptOss20B

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/-open-a-i-gpt-oss20-b.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val OpenAIGptOss20B: LLModel
```

OpenAI GPT-OSS 20B - Efficient Mixture-of-Experts model for speed-sensitive applications

Features:

128K context window

MoE architecture: 21B total params, 3.6B active per token

Runs on edge devices with 16 GB memory

Structured output support

Matches o3-mini performance

Important: This model requires the Bedrock Converse API (apiMethod = BedrockAPIMethod.Converse).


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.addCustomModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/add-custom-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun addCustomModel(model: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
object BedrockModels : LLModelDefinitions
```

Bedrock models available through the AWS Bedrock API


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.bedrock.BedrockModels.models

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-models/models.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override val models: List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AF_SOUTH_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-f_-s-o-u-t-h_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AF_SOUTH_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_EAST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-e-a-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_EAST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_EAST_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-e-a-s-t_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_EAST_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_NORTHEAST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-n-o-r-t-h-e-a-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_NORTHEAST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_NORTHEAST_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-n-o-r-t-h-e-a-s-t_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_NORTHEAST_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_NORTHEAST_3

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-n-o-r-t-h-e-a-s-t_3/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_NORTHEAST_3
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTHEAST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h-e-a-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTHEAST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTHEAST_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h-e-a-s-t_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTHEAST_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTHEAST_3

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h-e-a-s-t_3/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTHEAST_3
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTHEAST_4

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h-e-a-s-t_4/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTHEAST_4
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTHEAST_5

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h-e-a-s-t_5/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTHEAST_5
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTHEAST_7

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h-e-a-s-t_7/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTHEAST_7
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTH_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTH_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.AP_SOUTH_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-a-p_-s-o-u-t-h_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
AP_SOUTH_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.CA_CENTRAL_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-c-a_-c-e-n-t-r-a-l_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
CA_CENTRAL_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.CA_WEST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-c-a_-w-e-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
CA_WEST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_CENTRAL_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-c-e-n-t-r-a-l_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_CENTRAL_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_CENTRAL_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-c-e-n-t-r-a-l_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_CENTRAL_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_NORTH_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-n-o-r-t-h_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_NORTH_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_NORTH_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-n-o-r-t-h_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_NORTH_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_WEST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-w-e-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_WEST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_WEST_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-w-e-s-t_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_WEST_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.EU_WEST_3

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-e-u_-w-e-s-t_3/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
EU_WEST_3
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.IL_CENTRAL_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-i-l_-c-e-n-t-r-a-l_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
IL_CENTRAL_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.ME_CENTRAL_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-m-e_-c-e-n-t-r-a-l_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
ME_CENTRAL_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.ME_SOUTH_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-m-e_-s-o-u-t-h_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
ME_SOUTH_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.MX_CENTRAL_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-m-x_-c-e-n-t-r-a-l_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
MX_CENTRAL_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.SA_EAST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-s-a_-e-a-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
SA_EAST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.US_EAST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-u-s_-e-a-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
US_EAST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.US_EAST_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-u-s_-e-a-s-t_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
US_EAST_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.US_WEST_1

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-u-s_-w-e-s-t_1/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
US_WEST_1
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.US_WEST_2

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/-u-s_-w-e-s-t_2/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
US_WEST_2
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.entries

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/entries.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val entries: EnumEntries<BedrockRegions>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable enum BedrockRegions : Enum<BedrockRegions>
```

AWS Bedrock regions.

Represents all available AWS regions where Bedrock service is supported.

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.regionCode

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/region-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val regionCode: String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.toString

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.valueOf

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/value-of.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
fun valueOf(value: String): BedrockRegions
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.clients.bedrock.BedrockRegions.values

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-bedrock-regions/values.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
fun values(): Array<BedrockRegions>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.prompt.executor.clients.bedrock.StaticBearerTokenProvider.StaticBearerTokenProvider

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-static-bearer-token-provider/-static-bearer-token-provider.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(token: String)
```

- token — The Bedrock API key token value
## ai.koog.prompt.executor.clients.bedrock.StaticBearerTokenProvider

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-static-bearer-token-provider/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
class StaticBearerTokenProvider(token: String) : BearerTokenProvider
```

A BearerTokenProvider for a fixed Bedrock API key token.

- token — The Bedrock API key token value
## ai.koog.prompt.executor.clients.bedrock.StaticBearerTokenProvider.resolve

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/-static-bearer-token-provider/resolve.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open suspend override fun resolve(attributes: Attributes): BearerToken
```

## ai.koog.prompt.executor.clients.bedrock.withInferenceProfile

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock/with-inference-profile.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
fun LLModel.withInferenceProfile(inferencePrefix: String): LLModel
```

Extension method to create a new LLModel with a different inference profile prefix. This allows you to easily switch inference profiles for predefined Bedrock models.

A new LLModel with the specified inference profile prefix

Example usage:

- inferencePrefix — The inference profile prefix to use (e.g., "eu", "us", "ap")

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.BedrockConverseParams

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/-bedrock-converse-params.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, topP: Double? = null, stopSequences: List<String>? = null, performanceConfig: PerformanceConfiguration? = null, promptVariables: Map<String, PromptVariableValues>? = null, requestMetadata: Map<String, String>? = null)
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.copy

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/copy.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun copy(temperature: Double?, maxTokens: Int?, numberOfChoices: Int?, speculation: String?, schema: LLMParams.Schema?, toolChoice: LLMParams.ToolChoice?, user: String?, additionalProperties: Map<String, JsonElement>?): BedrockConverseParams
```


Referenced packages: `ai.koog.prompt.params`.

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
fun copy(temperature: Double? = this.temperature, maxTokens: Int? = this.maxTokens, numberOfChoices: Int? = this.numberOfChoices, speculation: String? = this.speculation, schema: LLMParams.Schema? = this.schema, toolChoice: LLMParams.ToolChoice? = this.toolChoice, user: String? = this.user, additionalProperties: Map<String, JsonElement>? = this.additionalProperties, topP: Double? = this.topP, stopSequences: List<String>? = this.stopSequences, performanceConfig: PerformanceConfiguration? = this.performanceConfig, promptVariables: Map<String, PromptVariableValues>? = this.promptVariables, requestMetadata: Map<String, String>? = this.requestMetadata): BedrockConverseParams
```

Creates a copy of this instance with the ability to modify any of its properties.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.equals

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/equals.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.hashCode

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/hash-code.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
class BedrockConverseParams(temperature: Double? = null, maxTokens: Int? = null, numberOfChoices: Int? = null, speculation: String? = null, schema: LLMParams.Schema? = null, toolChoice: LLMParams.ToolChoice? = null, user: String? = null, additionalProperties: Map<String, JsonElement>? = null, val topP: Double? = null, val stopSequences: List<String>? = null, val performanceConfig: PerformanceConfiguration? = null, val promptVariables: Map<String, PromptVariableValues>? = null, val requestMetadata: Map<String, String>? = null) : LLMParams
```

Bedrock Converse API parameters layered on top of LLMParams.

AWS docs


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.performanceConfig

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/performance-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val performanceConfig: PerformanceConfiguration?
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.promptVariables

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/prompt-variables.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val promptVariables: Map<String, PromptVariableValues>?
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.requestMetadata

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/request-metadata.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val requestMetadata: Map<String, String>?
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.stopSequences

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/stop-sequences.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val stopSequences: List<String>?
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.toString

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/to-string.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override fun toString(): String
```

## ai.koog.prompt.executor.clients.bedrock.converse.BedrockConverseParams.topP

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.converse/-bedrock-converse-params/top-p.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val topP: Double?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.BedrockAnthropicInvokeModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/-bedrock-anthropic-invoke-model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(anthropicVersion: String = "bedrock-2023-05-31", maxTokens: Int = MAX_TOKENS_DEFAULT, system: String = "", temperature: Double? = 1.0, messages: List<BedrockAnthropicInvokeModelMessage> = emptyList(), tools: List<BedrockAnthropicInvokeModelTool>? = null, toolChoice: BedrockAnthropicToolChoice? = null, outputConfig: JsonObject? = null)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.Companion.MAX_TOKENS_DEFAULT

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/-companion/-m-a-x_-t-o-k-e-n-s_-d-e-f-a-u-l-t.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
const val MAX_TOKENS_DEFAULT: Int = 4000
```

The maximum number of tokens to generate in the response. default to 4k tokens because of Claude Haiku 3, refer to https://docs.anthropic.com/en/docs/about-claude/models/overview#model-comparison

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.Companion

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
object Companion
```

Provides shared logic and utility functions for managing and interacting with the Bedrock Anthropic service model. This companion object includes methods and constants that are central to constructing and handling request payloads, ensuring adherence to Bedrock-specific requirements for the Anthropic Claude model family.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.anthropicVersion

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/anthropic-version.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "anthropic_version") val anthropicVersion: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class BedrockAnthropicInvokeModel(val anthropicVersion: String = "bedrock-2023-05-31", val maxTokens: Int = MAX_TOKENS_DEFAULT, val system: String = "", val temperature: Double? = 1.0, val messages: List<BedrockAnthropicInvokeModelMessage> = emptyList(), val tools: List<BedrockAnthropicInvokeModelTool>? = null, val toolChoice: BedrockAnthropicToolChoice? = null, val outputConfig: JsonObject? = null)
```

Represents the model to invoke an Anthropic service using Bedrock. refer to https://docs.aws.amazon.com/bedrock/latest/userguide/model-parameters-anthropic-claude-messages-request-response.html

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.maxTokens

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/max-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "max_tokens") val maxTokens: Int
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.messages

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/messages.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val messages: List<BedrockAnthropicInvokeModelMessage>
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.outputConfig

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/output-config.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "output_config") val outputConfig: JsonObject?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.system

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/system.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val system: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.temperature

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/temperature.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val temperature: Double?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.toolChoice

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/tool-choice.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "tool_choice") val toolChoice: BedrockAnthropicToolChoice?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModel.tools

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model/tools.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val tools: List<BedrockAnthropicInvokeModelTool>?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Text.Text

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-text/-text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(text: String)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Text

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-text/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable @SerialName(value = "text") class Text(val text: String) : BedrockAnthropicInvokeModelContent
```

Represents the text content in a model invocation for the Bedrock Anthropic API.

This class extends the BedrockAnthropicInvokeModelContent and is used to encapsulate the text response or content associated with the invocation process.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Text.text

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-text/text.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val text: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Thinking.Thinking

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-thinking/-thinking.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(signature: String, thinking: String)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Thinking

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-thinking/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable @SerialName(value = "thinking") data class Thinking(val signature: String, val thinking: String) : BedrockAnthropicInvokeModelContent
```

Represents a thinking process.

This class captures the model's reasoning and thought process during its operation. It is serialized with the discriminator "thinking" for polymorphic serialization.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Thinking.signature

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-thinking/signature.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val signature: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.Thinking.thinking

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-thinking/thinking.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val thinking: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolCall.ToolCall

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-call/-tool-call.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(id: String, name: String, input: JsonElement)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolCall.id

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-call/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val id: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolCall

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-call/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable @SerialName(value = "tool_use") class ToolCall(val id: String, val name: String, val input: JsonElement) : BedrockAnthropicInvokeModelContent
```

Represents a tool call instruction which is part of the model invocation content.

This class is designed to capture the details of a tool usage scenario during the communication or execution process. A ToolCall includes an identifier, the name of the tool being invoked, and the specific input provided to the tool in the form of JSON objects.

The class is serializable using kotlinx.serialization and uses a custom serial name tool_use.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolCall.input

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-call/input.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val input: JsonElement
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolCall.name

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-call/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolResult.ToolResult

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-result/-tool-result.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(toolUseId: String, content: List<BedrockAnthropicInvokeModelContent>, isError: Boolean)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolResult.content

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-result/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val content: List<BedrockAnthropicInvokeModelContent>
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolResult

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-result/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable @SerialName(value = "tool_result") class ToolResult(val toolUseId: String, val content: List<BedrockAnthropicInvokeModelContent>, val isError: Boolean) : BedrockAnthropicInvokeModelContent
```

Represents the result of a tool invocation in the context of Bedrock's Anthropic API.

This class is a specialized type of BedrockAnthropicInvokeModelContent, intended to encapsulate the response from a tool invoked as part of the model's execution. It contains metadata about the tool's usage and the returned content.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolResult.isError

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-result/is-error.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "is_error") val isError: Boolean
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent.ToolResult.toolUseId

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/-tool-result/tool-use-id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "tool_use_id") val toolUseId: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelContent

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-content/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable sealed interface BedrockAnthropicInvokeModelContent
```

Represents a class for constructing various types of content used in invoking models via the Bedrock Anthropic API.

This sealed class acts as the base type for different kinds of invocation-related content such as textual responses, tool results, and tool call instructions. It enables a structured approach to managing the diverse data types utilized in interactions with the Bedrock Anthropic API.

- Text
- Thinking
- ToolResult
- ToolCall
## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.Assistant.Assistant

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/-assistant/-assistant.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(content: List<BedrockAnthropicInvokeModelContent>)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.Assistant.content

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/-assistant/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override val content: List<BedrockAnthropicInvokeModelContent>
```

A list of content elements that form the message, where each content can be of varying types like text, image, document, tool usage, or tool result.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.Assistant

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/-assistant/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable @SerialName(value = "assistant") data class Assistant(val content: List<BedrockAnthropicInvokeModelContent>) : BedrockAnthropicInvokeModelMessage
```

Assistant BedrockAnthropic message.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.User.User

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/-user/-user.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(content: List<BedrockAnthropicInvokeModelContent>)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.User.content

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/-user/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
open override val content: List<BedrockAnthropicInvokeModelContent>
```

A list of content elements that form the message, where each content can be of varying types like text, image, document, tool usage, or tool result.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.User

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/-user/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable @SerialName(value = "user") data class User(val content: List<BedrockAnthropicInvokeModelContent>) : BedrockAnthropicInvokeModelMessage
```

User BedrockAnthropic message.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage.content

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
abstract val content: List<BedrockAnthropicInvokeModelContent>
```

A list of content elements that form the message, where each content can be of varying types like text, image, document, tool usage, or tool result.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelMessage

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-message/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable sealed interface BedrockAnthropicInvokeModelMessage
```

Data class representing a message used to invoke a model in the Bedrock Anthropic API.

- User
- Assistant
## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelTool.BedrockAnthropicInvokeModelTool

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool/-bedrock-anthropic-invoke-model-tool.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(type: String = "custom", name: String, description: String? = null, inputSchema: JsonObject? = null)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelTool.description

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool/description.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val description: String?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelTool

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class BedrockAnthropicInvokeModelTool(val type: String = "custom", val name: String, val description: String? = null, val inputSchema: JsonObject? = null)
```

Represents a tool used to interact with the Bedrock Anthropic model.

This data class is used to describe a tool with specific properties such as type, name, description, and input schema.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelTool.inputSchema

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool/input-schema.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "input_schema") val inputSchema: JsonObject?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelTool.name

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val name: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelTool.type

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val type: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelToolResultContent.BedrockAnthropicInvokeModelToolResultContent

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool-result-content/-bedrock-anthropic-invoke-model-tool-result-content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(type: String = "tool_result", toolUseId: String, content: String)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelToolResultContent.content

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool-result-content/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val content: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelToolResultContent

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool-result-content/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
data class BedrockAnthropicInvokeModelToolResultContent(val type: String = "tool_result", val toolUseId: String, val content: String)
```

Represents the result of invoking a Bedrock Anthropic model tool.

This data class contains the essential information returned by the tool invocation process.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelToolResultContent.toolUseId

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool-result-content/tool-use-id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "tool_use_id") val toolUseId: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicInvokeModelToolResultContent.type

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-invoke-model-tool-result-content/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val type: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.BedrockAnthropicResponse

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/-bedrock-anthropic-response.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(id: String, type: String, role: String, content: List<AnthropicContent>, model: String, stopReason: String? = null, usage: BedrockAnthropicUsage? = null)
```


Referenced packages: `ai.koog.prompt.executor.clients.anthropic.models`.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.content

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/content.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val content: List<AnthropicContent>
```


Referenced packages: `ai.koog.prompt.executor.clients.anthropic.models`.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.id

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/id.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val id: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class BedrockAnthropicResponse(val id: String, val type: String, val role: String, val content: List<AnthropicContent>, val model: String, val stopReason: String? = null, val usage: BedrockAnthropicUsage? = null)
```

Represents a response from Anthropic's API as processed by Bedrock.


Referenced packages: `ai.koog.prompt.executor.clients.anthropic.models`.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.model

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/model.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val model: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.role

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/role.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val role: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.stopReason

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/stop-reason.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val stopReason: String?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.type

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val type: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicResponse.usage

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-response/usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val usage: BedrockAnthropicUsage?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicToolChoice.BedrockAnthropicToolChoice

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-tool-choice/-bedrock-anthropic-tool-choice.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(type: String, name: String? = null)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicToolChoice

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-tool-choice/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class BedrockAnthropicToolChoice(val type: String, val name: String? = null)
```

Represents the tool choice configuration for Anthropic via Bedrock.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicToolChoice.name

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-tool-choice/name.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val name: String?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicToolChoice.type

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-tool-choice/type.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val type: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicUsage.BedrockAnthropicUsage

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-usage/-bedrock-anthropic-usage.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(inputTokens: Int, outputTokens: Int)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicUsage

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-usage/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class BedrockAnthropicUsage(val inputTokens: Int, val outputTokens: Int)
```

Represents the token usage data for a request or transaction in the BedrockAnthropic API.

This class is serialized using kotlinx.serialization and contains information about the number of tokens processed in both directions: input and output.

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicUsage.inputTokens

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-usage/input-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val inputTokens: Int
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.BedrockAnthropicUsage.outputTokens

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies/-bedrock-anthropic-usage/output-tokens.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
val outputTokens: Int
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaRequest.LlamaRequest

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-request/-llama-request.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(prompt: String, maxGenLen: Int = 2048, temperature: Double? = null)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaRequest

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-request/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class LlamaRequest(val prompt: String, val maxGenLen: Int = 2048, val temperature: Double? = null)
```

Request structure for Meta Llama models

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaRequest.maxGenLen

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-request/max-gen-len.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "max_gen_len") val maxGenLen: Int
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaRequest.prompt

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-request/prompt.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "prompt") val prompt: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaRequest.temperature

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-request/temperature.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "temperature") val temperature: Double?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaResponse.LlamaResponse

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-response/-llama-response.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(generation: String, promptTokenCount: Int? = null, generationTokenCount: Int? = null, stopReason: String? = null)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaResponse.generationTokenCount

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-response/generation-token-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "generation_token_count") val generationTokenCount: Int?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaResponse.generation

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-response/generation.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "generation") val generation: String
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaResponse

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-response/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class LlamaResponse(val generation: String, val promptTokenCount: Int? = null, val generationTokenCount: Int? = null, val stopReason: String? = null)
```

Response structure for Meta Llama models

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaResponse.promptTokenCount

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-response/prompt-token-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "prompt_token_count") val promptTokenCount: Int?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaResponse.stopReason

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-response/stop-reason.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "stop_reason") val stopReason: String?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaStreamChunk.LlamaStreamChunk

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-stream-chunk/-llama-stream-chunk.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
constructor(generation: String? = null, promptTokenCount: Int? = null, generationTokenCount: Int? = null, stopReason: String? = null)
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaStreamChunk.generationTokenCount

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-stream-chunk/generation-token-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "generation_token_count") val generationTokenCount: Int?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaStreamChunk.generation

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-stream-chunk/generation.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "generation") val generation: String?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaStreamChunk

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-stream-chunk/index.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@Serializable data class LlamaStreamChunk(val generation: String? = null, val promptTokenCount: Int? = null, val generationTokenCount: Int? = null, val stopReason: String? = null)
```

Streaming chunk structure for Meta Llama models

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaStreamChunk.promptTokenCount

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-stream-chunk/prompt-token-count.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "prompt_token_count") val promptTokenCount: Int?
```

## ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta.LlamaStreamChunk.stopReason

Module: `prompt-executor-bedrock-client`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/prompt-executor-bedrock-client/ai.koog.prompt.executor.clients.bedrock.modelfamilies.meta/-llama-stream-chunk/stop-reason.html`

### :prompt:prompt-executor:prompt-executor-clients:prompt-executor-bedrock-client/jvmMain

```kotlin
@SerialName(value = "stop_reason") val stopReason: String?
```
