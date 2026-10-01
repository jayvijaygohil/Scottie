# prompt / prompt-executor / prompt-executor-clients

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.clients.InternalLLMClientApi

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-internal-l-l-m-client-api/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_SETTER]) annotation class InternalLLMClientApi
```

Marks APIs as internal to the koog library's LLM clients and not intended for public use.

APIs annotated with this annotation are liable to removal or modification without prior notice and should not be used in external code. Such APIs are designed solely for internal purposes.

Utilization of this annotation will result in a compiler error unless explicitly opted-in.

Use cases include:

Restricting certain experimental or implementation-specific features from unintended usage.

Marking APIs intended exclusively for internal consumption within the koog library.

## ai.koog.prompt.executor.clients.LLMClientAPI.clientName

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/client-name.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open val clientName: String
```

The name of the client.

## ai.koog.prompt.executor.clients.LLMClientAPI.executeMultipleChoices

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): LLMChoice
```

Executes a prompt and returns a list of LLM choices.

List of LLM choices

- prompt — The prompt to execute
- tools — Optional list of tools that can be used by the LLM
- model — The LLM model to use

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.LLMClientAPI.executeStreaming

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open fun executeStreaming(prompt: Prompt, model: LLModel): Flow<StreamFrame>
```

Executes a prompt and returns a streaming flow of response chunks.

Flow of response chunks

- prompt — The prompt to execute
- model — The LLM model to use

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Executes a prompt and returns a streaming flow of response chunks.

Flow of response chunks

- prompt — The prompt to execute
- model — The LLM model to use
- tools — Optional list of tools that can be used by the LLM

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.LLMClientAPI.execute

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/execute.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract suspend fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a prompt and returns a list of response messages.

List of response messages

- prompt — The prompt to execute
- model — The LLM model to use
- tools — Optional list of tools that can be used by the LLM

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.LLMClientAPI.getBasicJsonSchemaGenerator

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open fun getBasicJsonSchemaGenerator(): BasicJsonSchemaGenerator
```

Basic JSON schema generator supported by the LLMClient. Return BasicJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.clients.LLMClientAPI.getStandardJsonSchemaGenerator

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open fun getStandardJsonSchemaGenerator(): StandardJsonSchemaGenerator
```

Standard JSON schema generator supported by the LLMClient. Return StandardJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.clients.LLMClientAPI

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
interface LLMClientAPI : AutoCloseable
```

API for LLMClient

- LLMClient
## ai.koog.prompt.executor.clients.LLMClientAPI.llmProvider

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract fun llmProvider(): LLMProvider
```

Retrieves the LLMProvider instance associated with this client.

The LLMProvider instance used for executing prompts and managing LLM operations.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.LLMClientAPI.models

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/models.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend fun models(): List<LLModel>
```

Retrieves a list of ids of available Large Language Models (LLMs) supported by the client.

A list of model ids instances representing the available LLMs.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.LLMClientAPI.moderate

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-client-a-p-i/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract suspend fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Analyzes the provided prompt for violations of content policies or other moderation criteria.

The result of the moderation analysis, encapsulated in a ModerationResult object.

- prompt — The input prompt to be analyzed for moderation.
- model — The language model to be used for conducting the moderation analysis.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.LLModelDefinitions.addCustomModel

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-model-definitions/add-custom-model.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract fun addCustomModel(model: LLModel)
```

Adds a custom model to this definition

- model — The model to add

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.LLModelDefinitions

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-model-definitions/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
interface LLModelDefinitions
```

Interface defining and managing configurations or metadata for supported Large Language Models (LLMs). This serves as a contract for providing LLM-specific definitions, capabilities, and configurations that are needed during interactions with LLM providers. Typically, implementations of this interface represent contextual information about various LLMs.

## ai.koog.prompt.executor.clients.LLModelDefinitions.models

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-model-definitions/models.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract val models: List<LLModel>
```

Lists all (both declared and custom) models under this definition


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.allModelsIn

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/all-models-in.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
@VisibleForTesting fun allModelsIn(obj: Any): List<LLModel>
```

Retrieves all public properties of the specified object and nested objects that are of type LLModel and returns them as a list.

A list of LLModel instances extracted from the public properties of the provided object and its nested objects.

- obj — The object to inspect for properties of type LLModel.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.list

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/list.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
@VisibleForTesting fun LLModelDefinitions.list(customModels: List<LLModel> = emptyList()): List<LLModel>
```

Retrieves a list of all LLModel instances defined within the current LLModelDefinitions.

The method scans for all publicly visible properties of the LLModelDefinitions instance, identifies those which return an LLModel, and compiles them into a list. This allows easy access to all available model definitions in a given context.

A list of LLModel instances representing all models defined in this LLModelDefinitions.

- customModels — A list of additional LLModel instances to include in the list.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.modelsById

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/models-by-id.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
fun LLModelDefinitions.modelsById(): Map<String, LLModel>
```

Maps the model IDs to models under this definition


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.serialization.AdditionalPropertiesFlatteningSerializer.AdditionalPropertiesFlatteningSerializer

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.serialization/-additional-properties-flattening-serializer/-additional-properties-flattening-serializer.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(tSerializer: KSerializer<T>, additionalPropertiesField: String = "additionalProperties")
```

- tSerializer — Underlying serializer for type T.
- additionalPropertiesField — The name of the field to use for additional properties, defaults to "additionalProperties".
## ai.koog.prompt.executor.clients.serialization.AdditionalPropertiesFlatteningSerializer

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.serialization/-additional-properties-flattening-serializer/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract class AdditionalPropertiesFlatteningSerializer<T>(tSerializer: KSerializer<T>, additionalPropertiesField: String = "additionalProperties") : JsonTransformingSerializer<T>
```

JSON serializer that handles additional properties in objects.

On serialization: flattens additionalProperties to root level. On deserialization: collects unknown properties into additionalProperties field.

Compatible with JsonNamingStrategy.SnakeCase: field names are matched against both their declared form and their snake_case form, and the additional-properties key is emitted in the form that matches the payload's naming so the inner serializer can read it back.

- tSerializer — Underlying serializer for type T.
- additionalPropertiesField — The name of the field to use for additional properties, defaults to "additionalProperties".