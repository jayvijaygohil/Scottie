# prompt / prompt-structure

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.structure.StructuredOutputPrompts.examplesPrompt

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-output-prompts/examples-prompt.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun <T> examplesPrompt(builder: TextContentBuilderBase<*>, structure: Structure<T, *>): TextContentBuilderBase<*>
```

Formats and appends structure examples, if they are present in the provided structure, to the provided text builder, to show an LLM expected output format. If Structure.examples is empty, nothing is appended.


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.StructuredOutputPrompts

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-output-prompts/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object StructuredOutputPrompts
```

An object that provides utilities for formatting structured output prompts.

## ai.koog.prompt.structure.StructuredOutputPrompts.outputInstructionPrompt

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure/-structured-output-prompts/output-instruction-prompt.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun outputInstructionPrompt(builder: TextContentBuilderBase<*>, structure: Structure<*, *>): TextContentBuilderBase<*>
```

Formats and appends the structured data output to the provided text builder.


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.annotations.InternalStructuredOutputApi

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.annotations/-internal-structured-output-api/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
annotation class InternalStructuredOutputApi
```

Indicates that the annotated API is internal to structured output related implementations and not intended for public use. Symbols marked with this annotation are not guaranteed to maintain backwards compatibility.

## ai.koog.prompt.structure.json.generator.GenericJsonSchemaGenerator.GenericJsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-generic-json-schema-generator/-generic-json-schema-generator.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.structure.json.generator.GenericJsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-generic-json-schema-generator/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract class GenericJsonSchemaGenerator : JsonSchemaGenerator
```

Generic extensions of JsonSchemaGenerator that provides some common base implementations of visit methods. This class can be used as a base to implement custom generators that share generic schema generation logic.

Note: it does not handle nullability because these might be different in different schema specs. Implementations must handle these themselves.

- BasicJsonSchemaGenerator
- StandardJsonSchemaGenerator
## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ADDITIONAL_PROPERTIES

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-a-d-d-i-t-i-o-n-a-l_-p-r-o-p-e-r-t-i-e-s.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ADDITIONAL_PROPERTIES: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ALL_OF

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-a-l-l_-o-f.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ALL_OF: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ANY_OF

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-a-n-y_-o-f.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ANY_OF: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.CONST

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-c-o-n-s-t.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val CONST: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.DEFS

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-d-e-f-s.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val DEFS: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.DESCRIPTION

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-d-e-s-c-r-i-p-t-i-o-n.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val DESCRIPTION: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ENUM

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-e-n-u-m.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ENUM: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ID

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-i-d.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ID: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ITEMS

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-i-t-e-m-s.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ITEMS: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.NULLABLE

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-n-u-l-l-a-b-l-e.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val NULLABLE: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.ONE_OF

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-o-n-e_-o-f.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ONE_OF: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.PATTERN

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-p-a-t-t-e-r-n.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val PATTERN: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.PROPERTIES

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-p-r-o-p-e-r-t-i-e-s.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val PROPERTIES: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.REF

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-r-e-f.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val REF: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.REF_PREFIX

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-r-e-f_-p-r-e-f-i-x.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val REF_PREFIX: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.REQUIRED

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-r-e-q-u-i-r-e-d.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val REQUIRED: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.SCHEMA

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-s-c-h-e-m-a.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val SCHEMA: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys.TYPE

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/-t-y-p-e.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val TYPE: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Keys

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-keys/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object Keys
```

JSON Schema keys.

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.ARRAY

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-a-r-r-a-y.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val ARRAY: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.BOOLEAN

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-b-o-o-l-e-a-n.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val BOOLEAN: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.INTEGER

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-i-n-t-e-g-e-r.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val INTEGER: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.NULL

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-n-u-l-l.html`

### :prompt:prompt-structure/commonMain

```kotlin
@ObjCName(name = "JSON_NULL") const val NULL: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.NUMBER

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-n-u-m-b-e-r.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val NUMBER: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.OBJECT

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-o-b-j-e-c-t.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val OBJECT: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types.STRING

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/-s-t-r-i-n-g.html`

### :prompt:prompt-structure/commonMain

```kotlin
const val STRING: String
```

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts.Types

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/-types/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object Types
```

JSON Schema types.

## ai.koog.prompt.structure.json.generator.JsonSchemaConsts

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-consts/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object JsonSchemaConsts
```

Collection of special constants, such as keys and data types, from JSON schema definition.

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.GenerationContext

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/-generation-context.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(json: Json, descriptor: SerialDescriptor, processedTypeDefs: MutableMap<SerialDescriptor, JsonObject>, currentDefPath: List<SerialDescriptor>, descriptionOverrides: Map<String, String>, excludedProperties: Set<String>, currentDescription: String?)
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.currentDefPath

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/current-def-path.html`

### :prompt:prompt-structure/commonMain

```kotlin
val currentDefPath: List<SerialDescriptor>
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.currentDescription

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/current-description.html`

### :prompt:prompt-structure/commonMain

```kotlin
val currentDescription: String?
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.descriptionOverrides

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/description-overrides.html`

### :prompt:prompt-structure/commonMain

```kotlin
val descriptionOverrides: Map<String, String>
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.descriptor

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/descriptor.html`

### :prompt:prompt-structure/commonMain

```kotlin
val descriptor: SerialDescriptor
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.excludedProperties

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/excluded-properties.html`

### :prompt:prompt-structure/commonMain

```kotlin
val excludedProperties: Set<String>
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.getElementDescription

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/get-element-description.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun getElementDescription(index: Int): String?
```

Helper method that gets description for an element in descriptor from descriptionOverrides map or LLMDescription annotation.

Description or null if no description is specified.

- index — Index of the element in descriptor
## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.getTypeDescription

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/get-type-description.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun getTypeDescription(): String?
```

Helper method that gets description for descriptor type from descriptionOverrides map or LLMDescription annotation.

Description or null if no description is specified.

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
data class GenerationContext(val json: Json, val descriptor: SerialDescriptor, val processedTypeDefs: MutableMap<SerialDescriptor, JsonObject>, val currentDefPath: List<SerialDescriptor>, val descriptionOverrides: Map<String, String>, val excludedProperties: Set<String>, val currentDescription: String?)
```

Holds intermediate and stateful information about the current schema generation process.

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.json

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/json.html`

### :prompt:prompt-structure/commonMain

```kotlin
val json: Json
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.GenerationContext.processedTypeDefs

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-generation-context/processed-type-defs.html`

### :prompt:prompt-structure/commonMain

```kotlin
val processedTypeDefs: MutableMap<SerialDescriptor, JsonObject>
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.JsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/-json-schema-generator.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator.generate

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/generate.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract fun generate(json: Json, name: String, serializer: KSerializer<*>, descriptionOverrides: Map<String, String>, excludedProperties: Set<String> = emptySet()): LLMParams.Schema.JSON
```

Generates a JSON schema representation based on the provided input parameters. Should call process to process the schema tree.

- json — Json instance used for serialization, provides required meta info needed for schema generation that is not available in SerialDescriptor
- name — The name of the schema.
- serializer — The serializer for the type for which the schema has to be generated.
- descriptionOverrides — A map containing overrides for LLMDescription.
- excludedProperties — A set of property names to exclude from the schema generation.

Referenced packages: `ai.koog.prompt.params`.

## ai.koog.prompt.structure.json.generator.JsonSchemaGenerator

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/-json-schema-generator/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
abstract class JsonSchemaGenerator
```

JSON schema generator from Kotlin serializable classes, to be used with LLM structured output functionality. This generator creates JSON schemas that can be included in LLM prompts to encourage structured outputs that match your Kotlin data models. The generated schemas help LLMs understand the expected response format.

- GenericJsonSchemaGenerator
## ai.koog.prompt.structure.json.generator.countElements

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/count-elements.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun JsonElement.countElements(value: JsonElement): Int
```

Recursively counts the number of occurrences of the specified JsonElement within this JsonElement.

- this — The JsonElement to search within.
- value — The JsonElement to search for.
## ai.koog.prompt.structure.json.generator.getPolymorphicDescriptors

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.json.generator/get-polymorphic-descriptors.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun SerialDescriptor.getPolymorphicDescriptors(json: Json): List<SerialDescriptor>
```

Utility function to get all subtype serial descriptors from a given polymorphic serial descriptor, that can handle both PolymorphicKind.OPEN and PolymorphicKind.SEALED kinds.

- this — Serial descriptor of a polymorphic type.
- json — Json instance
## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.MarkdownParserBuilder

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/-markdown-parser-builder.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.MarkdownStreamingParser.MarkdownStreamingParser

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/-markdown-streaming-parser/-markdown-streaming-parser.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(parser: suspend (String) -> Unit)
```

## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.MarkdownStreamingParser

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/-markdown-streaming-parser/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
inner class MarkdownStreamingParser(parser: suspend (String) -> Unit)
```

A class for streaming markdown parsing to process and handle markdown content incrementally. This class provides functionality to parse markdown content received as a flow of strings and invoke the given parser function for each processed segment.

## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.MarkdownStreamingParser.parseStream

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/-markdown-streaming-parser/parse-stream.html`

### :prompt:prompt-structure/commonMain

```kotlin
suspend fun parseStream(markdownStream: Flow<String>)
```

Processes a stream of Markdown content provided as a flow of strings.

Concatenates chunks of the incoming flow and parses complete sections of Markdown content based on the presence of header or line separators. Each section is then passed to the parser function for processing. Any remaining content in the buffer after all chunks are collected is also processed. Once processing is complete, a handler is invoked to signify the end of parsing.

- markdownStream — A flow of strings representing chunks of Markdown content to be parsed. These chunks are concatenated and processed into complete sections for handling.
## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.buildStreaming

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/build-streaming.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun buildStreaming(): MarkdownParserBuilder.MarkdownStreamingParser
```

Builds and returns a streaming markdown parser.

This method constructs a MarkdownStreamingParser instance using the configuration setup in the current MarkdownParserBuilder. The streaming parser processes markdown text by consuming chunks of input and invoking the appropriate registered handlers for headers, bullet points, code blocks, and other elements, as defined in the builder.

A MarkdownStreamingParser instance capable of handling streaming markdown input.

## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.build

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/build.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun build(): suspend (String) -> Unit
```

Creates a parser function that processes markdown text and returns a list of result objects.

A function that takes markdown text and returns a list of result objects

## ai.koog.prompt.structure.markdown.MarkdownParserBuilder

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
class MarkdownParserBuilder
```

A builder for creating markdown parsers with event-based handlers.

## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.onBullet

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/on-bullet.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun onBullet(handler: suspend (String) -> Unit)
```

Registers a handler for bullet points.

- handler — The handler function that receives the bullet point text
## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.onCodeBlock

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/on-code-block.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun onCodeBlock(handler: suspend (String) -> Unit)
```

Registers a handler for code blocks.

- handler — The handler function that receives the code block content and optional language identifier
## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.onFinishStream

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/on-finish-stream.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun onFinishStream(handler: suspend (String) -> Unit)
```

Registers a handler that is triggered when the stream processing is finished.

- handler — The function to handle the final output, receiving the remaining text as a parameter.
## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.onHeader

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/on-header.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun onHeader(level: Int, handler: suspend (String) -> Unit)
```

Registers a handler for headers of the specified level.

- level — The header level (1-6)
- handler — The handler function that receives the header text
## ai.koog.prompt.structure.markdown.MarkdownParserBuilder.onLineMatching

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-parser-builder/on-line-matching.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun onLineMatching(regex: Regex?, handler: suspend (String) -> Unit)
```

Registers a handler that is triggered when a line matches the specified regex pattern. If no regex is provided, the handler will be called for every line.

- regex — The regex pattern to match against each line, or null to match any line
- handler — The function to handle the matched line
## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.Companion.defaultDefinitionPrompt

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/-companion/default-definition-prompt.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun defaultDefinitionPrompt(builder: TextContentBuilderBase<*>, structureDefinition: MarkdownStructureDefinition): TextContentBuilderBase<*>
```

Default prompt explaining the structure definition of MarkdownStructureDefinition to the LLM.


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.Companion

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/-companion/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
object Companion
```

Companion object for MarkdownStructureDefinition class, providing utility methods.

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.MarkdownStructureDefinition

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/-markdown-structure-definition.html`

### :prompt:prompt-structure/commonMain

```kotlin
constructor(id: String, schema: TextContentBuilder.() -> Unit, examples: TextContentBuilder.() -> Unit? = null, definitionPrompt: (builder: TextContentBuilderBase<*>, structureDefinition: MarkdownStructureDefinition) -> TextContentBuilderBase<*> = ::defaultDefinitionPrompt)
```


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.definition

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/definition.html`

### :prompt:prompt-structure/commonMain

```kotlin
open override fun definition(builder: TextContentBuilderBase<*>): TextContentBuilderBase<*>
```

Defines the structure of textual content using the provided TextContentBuilder.

The modified TextContentBuilderBase containing the structured content.

- builder — The TextContentBuilderBase instance for constructing textual content.

Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.examples

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/examples.html`

### :prompt:prompt-structure/commonMain

```kotlin
val examples: TextContentBuilder.() -> Unit?
```


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.id

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/id.html`

### :prompt:prompt-structure/commonMain

```kotlin
val id: String
```

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/index.html`

### :prompt:prompt-structure/commonMain

```kotlin
class MarkdownStructureDefinition(val id: String, val schema: TextContentBuilder.() -> Unit, val examples: TextContentBuilder.() -> Unit? = null, definitionPrompt: (builder: TextContentBuilderBase<*>, structureDefinition: MarkdownStructureDefinition) -> TextContentBuilderBase<*> = ::defaultDefinitionPrompt) : StructureDefinition
```

Represents a specific definition of structured data that uses Markdown for its schema and example formatting. This class is part of a framework for constructing and handling structured data definitions through textual builders.


Referenced packages: `ai.koog.prompt.structure`, `ai.koog.prompt.text`.

## ai.koog.prompt.structure.markdown.MarkdownStructureDefinition.schema

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/-markdown-structure-definition/schema.html`

### :prompt:prompt-structure/commonMain

```kotlin
val schema: TextContentBuilder.() -> Unit
```


Referenced packages: `ai.koog.prompt.text`.

## ai.koog.prompt.structure.markdown.markdownParser

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/markdown-parser.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun markdownParser(config: MarkdownParserBuilder.() -> Unit): suspend (String) -> Unit
```

Creates a markdown parser with the given configuration.

A function that takes markdown text and returns a list of result objects

- config — The configuration function for the parser builder
## ai.koog.prompt.structure.markdown.markdownStreamingParser

Module: `prompt-structure`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-structure/ai.koog.prompt.structure.markdown/markdown-streaming-parser.html`

### :prompt:prompt-structure/commonMain

```kotlin
fun markdownStreamingParser(collector: MarkdownParserBuilder.() -> Unit): MarkdownParserBuilder.MarkdownStreamingParser
```

Creates a streaming markdown parser with the given configuration.

A function that takes a flow of markdown chunks and returns a flow of result objects

- collector — The configuration function for the parser builder