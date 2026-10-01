# Structured requests and schema generation

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.prompt.executor.model.StructureFixingParser.Companion.defaultFixingPrompt

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/-companion/default-fixing-prompt.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
fun defaultFixingPrompt(builder: PromptBuilder, content: String, structure: Structure<*, *>, exception: SerializationException): PromptBuilder
```

Default prompt explaining how to fix a malformed structure.


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.structure`.

## ai.koog.prompt.executor.model.StructureFixingParser.Companion

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
object Companion
```

Companion object providing some utility functions.

## ai.koog.prompt.executor.model.StructureFixingParser.StructureFixingParser

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/-structure-fixing-parser.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
constructor(model: LLModel, retries: Int, prompt: (builder: PromptBuilder, content: String, structure: Structure<*, *>, exception: SerializationException) -> PromptBuilder = ::defaultFixingPrompt)
```


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.structure`.

## ai.koog.prompt.executor.model.StructureFixingParser

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
class StructureFixingParser(val model: LLModel, val retries: Int, prompt: (builder: PromptBuilder, content: String, structure: Structure<*, *>, exception: SerializationException) -> PromptBuilder = ::defaultFixingPrompt)
```

Helper fixing parser for handling malformed structured data that uses LLMs to attempt to correct any errors in the provided content to produce valid structured outputs.


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.structure`.

## ai.koog.prompt.executor.model.StructureFixingParser.model

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/model.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val model: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.model.StructureFixingParser.parse

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/parse.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend fun <T> parse(executor: PromptExecutor, structure: Structure<T, *>, content: String): T
```

Parses the given content string into an instance of the specified type using the provided structured data schema. If the initial parsing fails, attempts to fix the content based on the error and retries parsing.

- executor — Executor to preform requests to model
- structure — The structured data schema and serializer to use for parsing the content.
- content — The string content to parse into the structured data type.
- SerializationException — If parsing fails both initially and after attempting to fix the content.

Referenced packages: `ai.koog.prompt.structure`.

## ai.koog.prompt.executor.model.StructureFixingParser.retries

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-structure-fixing-parser/retries.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val retries: Int
```

## ai.koog.prompt.executor.model.executeStructured

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/execute-structured.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend fun <T> PromptExecutor.executeStructured(prompt: Prompt, model: LLModel, config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Executes a prompt with structured output, enhancing it with schema instructions or native structured output parameter, and parses the response into the defined structure.

Note: While many language models advertise support for structured output via JSON schema, the actual level of support varies between models and even between versions of the same model. Some models may produce malformed outputs or deviate from the schema in subtle ways, especially with complex structures like polymorphic types.

kotlin.Result with parsed StructuredResponse or error.

- prompt — The prompt to be executed.
- model — LLM to execute requests.
- config — A configuration defining structures and behavior.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.structure`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend fun <T> PromptExecutor.executeStructured(prompt: Prompt, model: LLModel, serializer: KSerializer<T>, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Executes a prompt with structured output, enhancing it with schema instructions or native structured output parameter, and parses the response into the defined structure.

This is a simple version of the full executeStructured. Unlike the full version, it does not require specifying struct definitions and structured output modes manually. It attempts to find the best approach to provide a structured output based on the defined model capabilities.

For example, it chooses which JSON schema to use (simple or full) and with which mode (native or manual).

Result with parsed ai.koog.prompt.structure.StructuredResponse or error.

- prompt — The prompt to be executed.
- model — LLM to execute requests.
- serializer — Serializer for the requested structure type.
- examples — Optional list of examples in case manual mode will be used. These examples might help the model to understand the format better.
- fixingParser — Optional parser that handles malformed responses by using an auxiliary LLM to intelligently fix parsing errors. When specified, parsing errors trigger additional LLM calls with error context to attempt correction of the structure format.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.structure`.

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
inline suspend fun <T> PromptExecutor.executeStructured(prompt: Prompt, model: LLModel, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Executes a prompt with structured output, enhancing it with schema instructions or native structured output parameter, and parses the response into the defined structure.

This is a simple version of the full executeStructured. Unlike the full version, it does not require specifying struct definitions and structured output modes manually. It attempts to find the best approach to provide a structured output based on the defined model capabilities.

For example, it chooses which JSON schema to use (simple or full) and with which mode (native or manual).

kotlin.Result with parsed StructuredResponse or error.

- prompt — The prompt to be executed.
- model — LLM to execute requests.
- examples — Optional list of examples in case manual mode will be used. These examples might help the model to understand the format better.
- fixingParser — Optional parser that handles malformed responses by using an auxiliary LLM to intelligently fix parsing errors. When specified, parsing errors trigger additional LLM calls with error context to attempt correction of the structure format.
- T — The structure to request.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.structure`.

## ai.koog.prompt.executor.model.parseResponseToStructuredResponse

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/parse-response-to-structured-response.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
suspend fun <T> PromptExecutor.parseResponseToStructuredResponse(response: Message.Assistant, config: StructuredRequestConfig<T>, model: LLModel, fixingParser: StructureFixingParser? = null): StructuredResponse<T>
```

Parses a structured response from the assistant message using the provided structured output configuration and language model. If a fixing parser is specified in the configuration, it will be used; otherwise, the structure will be parsed directly.

A StructuredResponse<T> containing the parsed structure and the original assistant message.

- response — The assistant's response message to be parsed.
- config — The structured output configuration defining how the response should be parsed.
- model — The language model to be used for parsing the structured output.
- T — The type of the structured output.

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.structure`.

## ai.koog.prompt.structure.LLMStructuredParsingError.LLMStructuredParsingError

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-l-l-m-structured-parsing-error/-l-l-m-structured-parsing-error.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(message: String, cause: SerializationException?)
```

Creates a new instance of LLMStructuredParsingError.

- message — A detailed message describing the cause of the parsing error.
- cause — SerializationException that caused parsing exception.
## ai.koog.prompt.structure.LLMStructuredParsingError

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-l-l-m-structured-parsing-error/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
class LLMStructuredParsingError(message: String, cause: SerializationException?) : Exception
```

Exception indicating an error during the parsing of structured output from a language model.

This exception is thrown when the structured parsing of a language model's response fails, often due to malformed or unexpected data not conforming to the expected schema.

- message — A detailed message describing the cause of the parsing error.
- cause — SerializationException that caused parsing exception.
## ai.koog.prompt.structure.Structure.Structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/-structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(id: String, schema: TSchema, examples: List<TStruct>)
```

- TStruct — The type of the structured data that this class handles.
## ai.koog.prompt.structure.Structure.examples

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/examples.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract fun examples(builder: TextContentBuilderBase<*>): TextContentBuilderBase<*>
```

Defines formatted examples using the provided TextContentBuilderBase.

The modified TextContentBuilderBase containing formatted examples.

- builder — The TextContentBuilderBase instance for constructing textual content.

Referenced packages: `ai.koog.prompt.text`.

### :prompt:prompt-structure/commonMain

```kotlin
val examples: List<TStruct>
```

## ai.koog.prompt.structure.Structure.id

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/id.html`

### :prompt:prompt-structure/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.structure.Structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract class Structure<TStruct, TSchema : LLMParams.Schema>(val id: String, val schema: TSchema, val examples: List<TStruct>) : StructureDefinition
```

Represents a generic structure for handling data with a specific schema.

This abstract class provides a base for defining structured data entities that are identified by a unique id, involve a list of examples of a specific type TStruct, and adhere to a given schema.

- TStruct — The type of the structured data that this class handles.
- JsonStructure

Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.structure.Structure.parse

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/parse.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract fun parse(text: String): TStruct
```

Parses the given text into a structured data representation.

The structured data representation of type TStruct derived from the input text.

- text — The raw input text to be parsed into a structured format.
## ai.koog.prompt.structure.Structure.pretty

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/pretty.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract fun pretty(value: TStruct): String
```

Formats the given structured data into a human-readable string representation.

A string representing the pretty-printed version of the input structured data.

- value — The structured data of type TStruct to be formatted.
## ai.koog.prompt.structure.Structure.schema

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure/schema.html`

### :prompt:prompt-structure/commonMain

```kotlin
val schema: TSchema
```

## ai.koog.prompt.structure.StructureDefinition.definition

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure-definition/definition.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract fun definition(builder: TextContentBuilderBase<*>): TextContentBuilderBase<*>
```

Defines the structure of textual content using the provided TextContentBuilder.

The modified TextContentBuilderBase containing the structured content.

- builder — The TextContentBuilderBase instance for constructing textual content.

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.StructureDefinition

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structure-definition/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
interface StructureDefinition
```

Represents the definition of structured data, enabling content construction and customization.

This interface provides a contract for defining structured data using a TextContentBuilder, which facilitates the creation and management of text content. Implementations of this interface can define how structured content should be constructed, supporting a fluent API for content generation.

- Structure
- MarkdownStructureDefinition
## ai.koog.prompt.structure.StructuredRequest.Manual.Manual

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/-manual/-manual.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(structure: Structure<T, *>)
```

## ai.koog.prompt.structure.StructuredRequest.Manual

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/-manual/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
data class Manual<T>(val structure: Structure<T, *>) : StructuredRequest<T>
```

Instructs the model to produce structured output through explicit prompting.

Uses an additional user message containing Structure.definition to guide the model in generating correctly formatted responses.

## ai.koog.prompt.structure.StructuredRequest.Manual.structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/-manual/structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override val structure: Structure<T, *>
```

## ai.koog.prompt.structure.StructuredRequest.Native.Native

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/-native/-native.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(structure: Structure<T, *>)
```

## ai.koog.prompt.structure.StructuredRequest.Native

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/-native/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
data class Native<T>(val structure: Structure<T, *>) : StructuredRequest<T>
```

Leverages a model's built-in structured output capabilities.

Uses Structure.schema to define the expected response format through the model's native structured output functionality.

Note: Structure.examples are not used with this mode, only the schema is sent via parameters.

## ai.koog.prompt.structure.StructuredRequest.Native.structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/-native/structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override val structure: Structure<T, *>
```

## ai.koog.prompt.structure.StructuredRequest

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
sealed interface StructuredRequest<T>
```

Defines how structured outputs should be generated.

Can be StructuredRequest.Manual or StructuredRequest.Native

- T — The type of structured data.
- Manual
- Native
## ai.koog.prompt.structure.StructuredRequest.structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request/structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract val structure: Structure<T, *>
```

The definition of a structure.

## ai.koog.prompt.structure.StructuredRequestConfig.StructuredRequestConfig

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request-config/-structured-request-config.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(default: StructuredRequest<T>? = null, byProvider: Map<LLMProvider, StructuredRequest<T>> = emptyMap())
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.structure.StructuredRequestConfig.byProvider

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request-config/by-provider.html`

### :prompt:prompt-structure/commonMain

```kotlin
val byProvider: Map<LLMProvider, StructuredRequest<T>>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.structure.StructuredRequestConfig.default

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request-config/default.html`

### :prompt:prompt-structure/commonMain

```kotlin
val default: StructuredRequest<T>?
```

## ai.koog.prompt.structure.StructuredRequestConfig

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request-config/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
data class StructuredRequestConfig<T>(val default: StructuredRequest<T>? = null, val byProvider: Map<LLMProvider, StructuredRequest<T>> = emptyMap())
```

Configures structured output behavior. Defines which structures in which modes should be used for each provider when requesting a structured output.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.structure.StructuredRequestConfig.structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request-config/structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun structure(model: LLModel): Structure<T, *>
```

Retrieves the structured data configuration for a specific large language model (LLM).

The method determines the appropriate structured data setup based on the given LLM instance, ensuring compatibility with the model's provider and capabilities.

The structured data configuration represented as a StructuredData instance.

- model — The large language model (LLM) instance used to identify the structured data configuration.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.structure.StructuredRequestConfig.updatePrompt

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-request-config/update-prompt.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun updatePrompt(model: LLModel, prompt: Prompt): Prompt
```

Updates a given prompt to configure structured output using the specified large language model (LLM). Depending on the model's support for structured outputs, the prompt is updated either manually or natively.

A new prompt reflecting the updated structured output configuration.

- model — The large language model (LLModel) used to determine the structured output configuration.
- prompt — The original prompt to be updated with the structured output configuration.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.prompt.structure.StructuredResponse.StructuredResponse

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-response/-structured-response.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(data: T, structure: Structure<T, *>, message: Message.Assistant)
```

- T — The type of the structured data contained within this response.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.structure.StructuredResponse.data

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-response/data.html`

### :prompt:prompt-structure/commonMain

```kotlin
val data: T
```

## ai.koog.prompt.structure.StructuredResponse

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-response/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
data class StructuredResponse<T>(val data: T, val structure: Structure<T, *>, val message: Message.Assistant)
```

Represents a container for structured data parsed from a response message.

This class is designed to encapsulate both the parsed structured output and the original raw text as returned from a processing step, such as a language model execution.

- T — The type of the structured data contained within this response.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.structure.StructuredResponse.message

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-response/message.html`

### :prompt:prompt-structure/commonMain

```kotlin
val message: Message.Assistant
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.structure.StructuredResponse.structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-response/structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
val structure: Structure<T, *>
```

## ai.koog.prompt.structure.structure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun <T> TextContentBuilderBase<*>.structure(structure: Structure<T, *>, value: T)
```

Adds a structured representation of the given value to the TextContentBuilderBase.

- structure — The structure definition
- value — The value to be serialized and added to the builder.

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure.Companion.create

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/-companion/create.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun <TStruct> create(id: String? = null, serializer: KSerializer<TStruct>, json: Json = defaultJson, schemaGenerator: JsonSchemaGenerator = StandardJsonSchemaGenerator.Default, descriptionOverrides: Map<String, String> = emptyMap(), excludedProperties: Set<String> = emptySet(), examples: List<TStruct> = emptyList(), definitionPrompt: (builder: TextContentBuilderBase<*>, structuredData: JsonStructure<TStruct>) -> TextContentBuilderBase<*> = ::defaultDefinitionPrompt): JsonStructure<TStruct>
```

Factory method to create JSON structure with auto-generated JSON schema.

Example usage:

- id — Unique identifier for the structure.
- serializer — Serializer used for converting the data to and from JSON.
- json — JSON configuration instance used for serialization.
- schemaGenerator — JSON schema generator
- descriptionOverrides — Optional map of serial class names and property names to descriptions. If a property/type is already described with ai.koog.agents.core.tools.annotations.LLMDescription annotation, value from the map will override this description.
- excludedProperties — Optional set of property names to exclude from the schema generation.
- examples — List of example data items that conform to the structure, used for demonstrating valid formats.
- definitionPrompt — Prompt with definition, explaining the structure to the LLM when the manual mode for structured output is used. Default is JsonStructure.defaultDefinitionPrompt

Referenced packages: `ai.koog.prompt.structure.json.generator`, `ai.koog.prompt.text`.

### :prompt:prompt-structure/commonMain

```kotlin
inline fun <TStruct> create(json: Json = defaultJson, schemaGenerator: JsonSchemaGenerator = StandardJsonSchemaGenerator.Default, descriptionOverrides: Map<String, String> = emptyMap(), excludedProperties: Set<String> = emptySet(), examples: List<TStruct> = emptyList(), noinline definitionPrompt: (builder: TextContentBuilderBase<*>, structuredData: JsonStructure<TStruct>) -> TextContentBuilderBase<*> = ::defaultDefinitionPrompt): JsonStructure<TStruct>
```

Factory method to create JSON structure with auto-generated JSON schema.

This is a convenience inline overload that automatically deduces id and serializer from passed type. Check non-inline version of createJsonStructure for detailed information.

- json — JSON configuration instance used for serialization.
- schemaGenerator — JSON schema generator. Make sure to select the correct one for the LLM you are using this structure with, since different models have slightly different formats.
- descriptionOverrides — Optional map of serial class names and property names to descriptions. If a property/type is already described with ai.koog.agents.core.tools.annotations.LLMDescription annotation, value from the map will override this description.
- excludedProperties — Optional set of property names to exclude from the schema generation.
- examples — List of example data items that conform to the structure, used for demonstrating valid formats.
- definitionPrompt — Prompt with definition, explaining the structure to the LLM when the manual mode for structured output is used. Default is JsonStructure.defaultDefinitionPrompt

Referenced packages: `ai.koog.prompt.structure.json.generator`, `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure.Companion.defaultDefinitionPrompt

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/-companion/default-definition-prompt.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun <TStruct> defaultDefinitionPrompt(builder: TextContentBuilderBase<*>, structuredData: JsonStructure<TStruct>): TextContentBuilderBase<*>
```

Default prompt explaining the structure of JsonStructure to the LLM.


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure.Companion.defaultJson

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/-companion/default-json.html`

### :prompt:prompt-structure/commonMain

```kotlin
val defaultJson: Json
```

Default Json instance for JsonStructure.json

## ai.koog.prompt.structure.json.JsonStructure.Companion

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/-companion/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object Companion
```

Companion object for the JsonStructure class, providing utility methods to facilitate the creation of JSON structures with associated schema generation.

## ai.koog.prompt.structure.json.JsonStructure.JsonStructure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/-json-structure.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(id: String, schema: LLMParams.Schema.JSON, examples: List<TStruct>, serializer: KSerializer<TStruct>, json: Json, definitionPrompt: (builder: TextContentBuilderBase<*>, structure: JsonStructure<TStruct>) -> TextContentBuilderBase<*> = ::defaultDefinitionPrompt, examplesPrompt: (builder: TextContentBuilderBase<*>, structure: JsonStructure<TStruct>) -> TextContentBuilderBase<*> = StructuredOutputPrompts::examplesPrompt)
```

- definitionPrompt — Prompt with definition, explaining the structure to the LLM. Default is JsonStructure.defaultDefinitionPrompt
- examplesPrompt — Prompt with examples of valid formats for the structured data. Default is StructuredOutputPrompts.examplesPrompt
- TStruct — The type of data to be structured.

Referenced packages: `ai.koog.prompt.params`, `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure.definition

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/definition.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun definition(builder: TextContentBuilderBase<*>): TextContentBuilderBase<*>
```

Defines the structure of textual content using the provided TextContentBuilder.

The modified TextContentBuilderBase containing the structured content.

- builder — The TextContentBuilderBase instance for constructing textual content.

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure.examples

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/examples.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun examples(builder: TextContentBuilderBase<*>): TextContentBuilderBase<*>
```

Defines formatted examples using the provided TextContentBuilderBase.

The modified TextContentBuilderBase containing formatted examples.

- builder — The TextContentBuilderBase instance for constructing textual content.

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
class JsonStructure<TStruct>(id: String, schema: LLMParams.Schema.JSON, examples: List<TStruct>, val serializer: KSerializer<TStruct>, val json: Json, definitionPrompt: (builder: TextContentBuilderBase<*>, structure: JsonStructure<TStruct>) -> TextContentBuilderBase<*> = ::defaultDefinitionPrompt, examplesPrompt: (builder: TextContentBuilderBase<*>, structure: JsonStructure<TStruct>) -> TextContentBuilderBase<*> = StructuredOutputPrompts::examplesPrompt) : Structure<TStruct, LLMParams.Schema.JSON>
```

Represents a structure for handling and interacting with structured data of a specified type.

- definitionPrompt — Prompt with definition, explaining the structure to the LLM. Default is JsonStructure.defaultDefinitionPrompt
- examplesPrompt — Prompt with examples of valid formats for the structured data. Default is StructuredOutputPrompts.examplesPrompt
- TStruct — The type of data to be structured.

Referenced packages: `ai.koog.prompt.params`, `ai.koog.prompt.structure`, `ai.koog.prompt.text`.

## ai.koog.prompt.structure.json.JsonStructure.json

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/json.html`

### :prompt:prompt-structure/commonMain

```kotlin
val json: Json
```

## ai.koog.prompt.structure.json.JsonStructure.parse

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/parse.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun parse(text: String): TStruct
```

Parses the given text into a structured data representation.

The structured data representation of type TStruct derived from the input text.

- text — The raw input text to be parsed into a structured format.
## ai.koog.prompt.structure.json.JsonStructure.pretty

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/pretty.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun pretty(value: TStruct): String
```

Formats the given structured data into a human-readable string representation.

A string representing the pretty-printed version of the input structured data.

- value — The structured data of type TStruct to be formatted.
## ai.koog.prompt.structure.json.JsonStructure.serializer

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json/-json-structure/serializer.html`

### :prompt:prompt-structure/commonMain

```kotlin
val serializer: KSerializer<TStruct>
```

## ai.koog.prompt.structure.json.generator.BasicJsonSchemaGenerator.BasicJsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-basic-json-schema-generator/-basic-json-schema-generator.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.structure.json.generator.BasicJsonSchemaGenerator.Default

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-basic-json-schema-generator/-default/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object Default : BasicJsonSchemaGenerator
```

Default instance of BasicJsonSchemaGenerator. Prefer to use it instead of creating new instates manually.

- BasicJsonSchemaGenerator
## ai.koog.prompt.structure.json.generator.BasicJsonSchemaGenerator.generate

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-basic-json-schema-generator/generate.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun generate(json: Json, name: String, serializer: KSerializer<*>, descriptionOverrides: Map<String, String>, excludedProperties: Set<String> = emptySet()): LLMParams.Schema.JSON.Basic
```

Generates generic LLMParams.Schema.JSON.Basic


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.structure.json.generator.BasicJsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-basic-json-schema-generator/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
open class BasicJsonSchemaGenerator : GenericJsonSchemaGenerator
```

Simple implementation of GenericJsonSchemaGenerator that produces LLMParams.Schema.JSON.Basic. Generates LLM-agnostic schema not tied to any specific provider format. For LLMs requiring custom formats when using native structured output, consider provider-specific generators instead.

It is recommended to use BasicJsonSchemaGenerator.Default companion object, which provides a default instance, instead of creating new instances manually.

- Default
## ai.koog.prompt.structure.json.generator.StandardJsonSchemaGenerator.Default

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-standard-json-schema-generator/-default/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object Default : StandardJsonSchemaGenerator
```

Default instance of StandardJsonSchemaGenerator. Prefer to use it instead of creating new instates manually.

- StandardJsonSchemaGenerator
## ai.koog.prompt.structure.json.generator.StandardJsonSchemaGenerator.StandardJsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-standard-json-schema-generator/-standard-json-schema-generator.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.structure.json.generator.StandardJsonSchemaGenerator.generate

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-standard-json-schema-generator/generate.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun generate(json: Json, name: String, serializer: KSerializer<*>, descriptionOverrides: Map<String, String>, excludedProperties: Set<String> = emptySet()): LLMParams.Schema.JSON.Standard
```

Generates generic LLMParams.Schema.JSON.Standard


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.structure.json.generator.StandardJsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-standard-json-schema-generator/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
open class StandardJsonSchemaGenerator : GenericJsonSchemaGenerator
```

Full implementation of GenericJsonSchemaGenerator to generate advanced generic LLMParams.Schema.JSON.Standard. Generates LLM-agnostic schema not tied to any specific provider format. For LLMs requiring custom formats when using native structured output, consider provider-specific generators instead.

It is recommended to use StandardJsonSchemaGenerator.Default companion object, which provides a default instance, instead of creating new instances manually.

- Default