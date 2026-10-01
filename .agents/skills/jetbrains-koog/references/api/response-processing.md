# Response processing and tool-call repair

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.prompt.processor.LLMBasedToolCallFixProcessor.LLMBasedToolCallFixProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-l-l-m-based-tool-call-fix-processor/-l-l-m-based-tool-call-fix-processor.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor(toolRegistry: ToolRegistry, toolCallJsonConfig: ToolCallJsonConfig = ToolCallJsonConfig(), preprocessor: ResponseProcessor = ManualToolCallFixProcessor(toolRegistry, toolCallJsonConfig), assessToolCallIntentSystemMessage: String = Prompts.assessToolCallIntent, fixToolCallSystemMessage: String = Prompts.fixToolCall, invalidJsonFeedback: (List<ToolDescriptor>) -> String = Prompts::invalidJsonFeedback, invalidNameFeedback: (String, List<ToolDescriptor>) -> String = Prompts::invalidNameFeedback, invalidArgumentsFeedback: (String, ToolDescriptor) -> String = Prompts::invalidArgumentsFeedback, maxRetries: Int = 3)
```

- toolRegistry — The tool registry with available tools
- toolCallJsonConfig — Configuration for parsing and fixing tool call json
- preprocessor — A processor applied to all responses from the LLM. Defaults to ManualToolCallFixProcessor
- assessToolCallIntentSystemMessage — The system message to ask LLM if a tool call was intended
- fixToolCallSystemMessage — The system message to ask LLM to fix a tool call
- invalidJsonFeedback — The message sent to the LLM when tool call json is invalid
- invalidNameFeedback — The message sent to the LLM when the tool name is invalid
- invalidArgumentsFeedback — The message sent to the LLM when tool arguments are invalid Defaults to null, meaning that the original message is returned if the LLM fails to fix a tool call.
- maxRetries — The maximum number of iterations in the main loop

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.processor.LLMBasedToolCallFixProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-l-l-m-based-tool-call-fix-processor/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
class LLMBasedToolCallFixProcessor constructor(toolRegistry: ToolRegistry, toolCallJsonConfig: ToolCallJsonConfig = ToolCallJsonConfig(), preprocessor: ResponseProcessor = ManualToolCallFixProcessor(toolRegistry, toolCallJsonConfig), assessToolCallIntentSystemMessage: String = Prompts.assessToolCallIntent, fixToolCallSystemMessage: String = Prompts.fixToolCall, invalidJsonFeedback: (List<ToolDescriptor>) -> String = Prompts::invalidJsonFeedback, invalidNameFeedback: (String, List<ToolDescriptor>) -> String = Prompts::invalidNameFeedback, invalidArgumentsFeedback: (String, ToolDescriptor) -> String = Prompts::invalidArgumentsFeedback, maxRetries: Int = 3) : ToolJsonFixProcessor
```

A response processor that fixes incorrectly communicated tool calls.

Applies an LLM-based approach to fix incorrectly generated tool calls. Iteratively asks the LLM to update a message until it is a correct tool call.

The first step is to identify if the corrections are needed. It is done by (a) Asking the LLM if the message intends to call a tool if the message is Message.Assistant (b) Trying to parse the name and parameters if the message is MessagePart.Tool.Call

The main step is to fix the message (if needed). The processor runs a loop asking the LLM to fix the message. On every iteration, the processor provides the LLM with the current message and the feedback on it. If the LLM fails to return a correct tool call message in maxRetries iterations, the fallback processor is used. If no fallback processor is provided, the original message is returned.

Some use-cases:

Simple usage:

Customizing the json keys:

Using a fallback processor. Here the fallback processor calls another (e.g. better but more expensive) LLM to fix the message:

- toolRegistry — The tool registry with available tools
- toolCallJsonConfig — Configuration for parsing and fixing tool call json
- preprocessor — A processor applied to all responses from the LLM. Defaults to ManualToolCallFixProcessor
- assessToolCallIntentSystemMessage — The system message to ask LLM if a tool call was intended
- fixToolCallSystemMessage — The system message to ask LLM to fix a tool call
- invalidJsonFeedback — The message sent to the LLM when tool call json is invalid
- invalidNameFeedback — The message sent to the LLM when the tool name is invalid
- invalidArgumentsFeedback — The message sent to the LLM when tool arguments are invalid Defaults to null, meaning that the original message is returned if the LLM fails to fix a tool call.
- maxRetries — The maximum number of iterations in the main loop

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.processor.LLMBasedToolCallFixProcessor.process

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-l-l-m-based-tool-call-fix-processor/process.html`

### :prompt:prompt-processor/commonMain

```kotlin
open suspend override fun process(executor: PromptExecutor, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant, serializer: JSONSerializer): Message.Assistant
```

Processes a single LLM response.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.prompt.processor.ManualToolCallFixProcessor.ManualToolCallFixProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-manual-tool-call-fix-processor/-manual-tool-call-fix-processor.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor(toolRegistry: ToolRegistry, toolCallJsonConfig: ToolCallJsonConfig = ToolCallJsonConfig())
```

- toolRegistry — The tool registry with available tools
- toolCallJsonConfig — Configuration for parsing and fixing tool call json

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.processor.ManualToolCallFixProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-manual-tool-call-fix-processor/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
class ManualToolCallFixProcessor constructor(toolRegistry: ToolRegistry, toolCallJsonConfig: ToolCallJsonConfig = ToolCallJsonConfig()) : ToolJsonFixProcessor
```

A response processor that fixes invalid tool call jsons. Fixes incorrectly formatted jsons, e.g.

incorrect tool id / name / arguments keys

missing escapes in strings

- toolRegistry — The tool registry with available tools
- toolCallJsonConfig — Configuration for parsing and fixing tool call json

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.processor.ManualToolCallFixProcessor.process

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-manual-tool-call-fix-processor/process.html`

### :prompt:prompt-processor/commonMain

```kotlin
open suspend override fun process(executor: PromptExecutor, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant, serializer: JSONSerializer): Message.Assistant
```

Processes a single LLM response.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.prompt.processor.ResponseProcessor.Chain.Chain

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/-chain/-chain.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor(vararg processors: ResponseProcessor)
```

## ai.koog.prompt.processor.ResponseProcessor.Chain

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/-chain/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
class Chain(processors: ResponseProcessor) : ResponseProcessor
```

Chains multiple response processors together.

## ai.koog.prompt.processor.ResponseProcessor.Chain.process

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/-chain/process.html`

### :prompt:prompt-processor/commonMain

```kotlin
open suspend override fun process(executor: PromptExecutor, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant, serializer: JSONSerializer): Message.Assistant
```

Processes a single LLM response.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.prompt.processor.ResponseProcessor.ResponseProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/-response-processor.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.processor.ResponseProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
abstract class ResponseProcessor
```

A processor for handling and modifying LLM responses.

- Chain
- ToolJsonFixProcessor
## ai.koog.prompt.processor.ResponseProcessor.plus

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/plus.html`

### :prompt:prompt-processor/commonMain

```kotlin
operator fun plus(other: ResponseProcessor): ResponseProcessor
```

Chains two processors together.

## ai.koog.prompt.processor.ResponseProcessor.process

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor/process.html`

### :prompt:prompt-processor/commonMain

```kotlin
abstract suspend fun process(executor: PromptExecutor, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant, serializer: JSONSerializer): Message.Assistant
```

Processes a single LLM response.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.prompt.processor.ResponseProcessorConfig.ResponseProcessorConfig

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor-config/-response-processor-config.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor(responseProcessor: ResponseProcessor, serializer: JSONSerializer)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.prompt.processor.ResponseProcessorConfig

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor-config/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
class ResponseProcessorConfig(val responseProcessor: ResponseProcessor, val serializer: JSONSerializer)
```

Configuration for a ResponseProcessor process request.


Referenced packages: `ai.koog.serialization`.

## ai.koog.prompt.processor.ResponseProcessorConfig.responseProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor-config/response-processor.html`

### :prompt:prompt-processor/commonMain

```kotlin
val responseProcessor: ResponseProcessor
```

## ai.koog.prompt.processor.ResponseProcessorConfig.serializer

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-response-processor-config/serializer.html`

### :prompt:prompt-processor/commonMain

```kotlin
val serializer: JSONSerializer
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.prompt.processor.ToolCallJsonConfig.Companion.defaultArgsJsonKeys

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/-companion/default-args-json-keys.html`

### :prompt:prompt-processor/commonMain

```kotlin
val defaultArgsJsonKeys: List<String>
```

Keys used by various models for tool arguments in tool call json

## ai.koog.prompt.processor.ToolCallJsonConfig.Companion.defaultIdJsonKeys

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/-companion/default-id-json-keys.html`

### :prompt:prompt-processor/commonMain

```kotlin
val defaultIdJsonKeys: List<String>
```

Keys used by various models for tool ID in tool call json

## ai.koog.prompt.processor.ToolCallJsonConfig.Companion.defaultJson

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/-companion/default-json.html`

### :prompt:prompt-processor/commonMain

```kotlin
val defaultJson: Json
```

Default json configuration used to parse tool call json

## ai.koog.prompt.processor.ToolCallJsonConfig.Companion.defaultNameJsonKeys

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/-companion/default-name-json-keys.html`

### :prompt:prompt-processor/commonMain

```kotlin
val defaultNameJsonKeys: List<String>
```

Keys used by various models for tool name in tool call json

## ai.koog.prompt.processor.ToolCallJsonConfig.Companion

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/-companion/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
object Companion
```

Companion object with defaults for json configurations of ToolCallJsonConfig

## ai.koog.prompt.processor.ToolCallJsonConfig.ToolCallJsonConfig

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/-tool-call-json-config.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor(json: Json = defaultJson, idJsonKeys: List<String> = defaultIdJsonKeys, nameJsonKeys: List<String> = defaultNameJsonKeys, argsJsonKeys: List<String> = defaultArgsJsonKeys)
```

## ai.koog.prompt.processor.ToolCallJsonConfig.argsJsonKeys

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/args-json-keys.html`

### :prompt:prompt-processor/commonMain

```kotlin
val argsJsonKeys: List<String>
```

## ai.koog.prompt.processor.ToolCallJsonConfig.idJsonKeys

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/id-json-keys.html`

### :prompt:prompt-processor/commonMain

```kotlin
val idJsonKeys: List<String>
```

## ai.koog.prompt.processor.ToolCallJsonConfig

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
class ToolCallJsonConfig(val json: Json = defaultJson, val idJsonKeys: List<String> = defaultIdJsonKeys, val nameJsonKeys: List<String> = defaultNameJsonKeys, val argsJsonKeys: List<String> = defaultArgsJsonKeys)
```

Configuration for parsing and fixing tool call json

## ai.koog.prompt.processor.ToolCallJsonConfig.json

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/json.html`

### :prompt:prompt-processor/commonMain

```kotlin
val json: Json
```

## ai.koog.prompt.processor.ToolCallJsonConfig.nameJsonKeys

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-call-json-config/name-json-keys.html`

### :prompt:prompt-processor/commonMain

```kotlin
val nameJsonKeys: List<String>
```

## ai.koog.prompt.processor.ToolJsonFixProcessor.ToolJsonFixProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-json-fix-processor/-tool-json-fix-processor.html`

### :prompt:prompt-processor/commonMain

```kotlin
constructor(toolRegistry: ToolRegistry, toolCallJsonConfig: ToolCallJsonConfig = ToolCallJsonConfig())
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.processor.ToolJsonFixProcessor

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/-tool-json-fix-processor/index.html`

### :prompt:prompt-processor/commonMain

```kotlin
abstract class ToolJsonFixProcessor(toolRegistry: ToolRegistry, toolCallJsonConfig: ToolCallJsonConfig = ToolCallJsonConfig()) : ResponseProcessor
```

Abstract class for processors that fix tool call json messages. Contains common logic for extracting relevant information from (possibly malformed) tool call json messages.

- LLMBasedToolCallFixProcessor
- ManualToolCallFixProcessor

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.prompt.processor.executeProcessed

Module: `prompt-processor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-processor/ai.koog.prompt.processor/execute-processed.html`

### :prompt:prompt-processor/commonMain

```kotlin
suspend fun PromptExecutor.executeProcessed(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, processorConfig: ResponseProcessorConfig? = null): Message.Assistant
```

Executes the given prompt and processes responses using the given processorConfig.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.
