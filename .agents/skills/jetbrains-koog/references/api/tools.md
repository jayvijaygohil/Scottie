# Tools, descriptors, and registries

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.agent.AIAgentTool.AIAgentTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-a-i-agent-tool.html`

### :agents:agents-core/commonMain

```kotlin
constructor(agentService: AIAgentService<Input, Output, *>, agentName: String, agentDescription: String, inputDescription: String? = null, inputType: TypeToken, outputType: TypeToken, parentAgentId: String? = null)
```

- agentService — The AI agent service to create the agent.
- agentName — A unique name for the agent.
- agentDescription — A brief description of the agent's functionality. If not specified for a primitive input type (ex: String, Int, ...), an empty input description will be sent to LLM. Does not have any effect for non-primitive Input type with @LLMDescription annotations.
- inputType — Type token representing input type.
- outputType — Type token representing output type.
- parentAgentId — Optional ID of the parent AI agent. Tool agent IDs will be generated as "parentAgentId."
- Input — The type of input expected by the AI agent.
- Output — The type of output produced by the AI agent.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.AIAgentTool.AgentToolInput.AgentToolInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-input/-agent-tool-input.html`

### :agents:agents-core/commonMain

```kotlin
constructor(input: Input)
```

- Input — The type of the input data expected by the tool.
## ai.koog.agents.core.agent.AIAgentTool.AgentToolInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-input/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentToolInput<Input>(val input: Input)
```

Represents the input for AIAgent used as Tool (see AIAgent.asTool)

- Input — The type of the input data expected by the tool.
## ai.koog.agents.core.agent.AIAgentTool.AgentToolInput.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-input/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Input
```

## ai.koog.agents.core.agent.AIAgentTool.AgentToolResult.AgentToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-result/-agent-tool-result.html`

### :agents:agents-core/commonMain

```kotlin
constructor(successful: Boolean, errorMessage: String? = null, result: Output? = null)
```

## ai.koog.agents.core.agent.AIAgentTool.AgentToolResult.errorMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-result/error-message.html`

### :agents:agents-core/commonMain

```kotlin
val errorMessage: String?
```

## ai.koog.agents.core.agent.AIAgentTool.AgentToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-result/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentToolResult<Output>(val successful: Boolean, val errorMessage: String? = null, val result: Output? = null)
```

Represents the result of executing an agent tool operation.

## ai.koog.agents.core.agent.AIAgentTool.AgentToolResult.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-result/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: Output?
```

## ai.koog.agents.core.agent.AIAgentTool.AgentToolResult.successful

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/-agent-tool-result/successful.html`

### :agents:agents-core/commonMain

```kotlin
val successful: Boolean
```

## ai.koog.agents.core.agent.AIAgentTool.decodeResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/decode-result.html`

### :agents:agents-core/commonMain

```kotlin
open override fun decodeResult(rawResult: JSONElement, serializer: JSONSerializer): AIAgentTool.AgentToolResult<Output>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.AIAgentTool.encodeResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/encode-result.html`

### :agents:agents-core/commonMain

```kotlin
open override fun encodeResult(result: AIAgentTool.AgentToolResult<Output>, serializer: JSONSerializer): JSONElement
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.AIAgentTool.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(args: AIAgentTool.AgentToolInput<Input>): AIAgentTool.AgentToolResult<Output>
```

## ai.koog.agents.core.agent.AIAgentTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-tool/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentTool<Input, Output>(agentService: AIAgentService<Input, Output, *>, agentName: String, agentDescription: String, inputDescription: String? = null, inputType: TypeToken, outputType: TypeToken, parentAgentId: String? = null) : Tool<AIAgentTool.AgentToolInput<Input>, AIAgentTool.AgentToolResult<Output>>
```

AIAgentTool is a generic tool that wraps an AI agent to facilitate integration with the context of a tool execution framework. It enables the serialization, deserialization, and execution of an AI agent's operations.

- agentService — The AI agent service to create the agent.
- agentName — A unique name for the agent.
- agentDescription — A brief description of the agent's functionality. If not specified for a primitive input type (ex: String, Int, ...), an empty input description will be sent to LLM. Does not have any effect for non-primitive Input type with @LLMDescription annotations.
- inputType — Type token representing input type.
- outputType — Type token representing output type.
- parentAgentId — Optional ID of the parent AI agent. Tool agent IDs will be generated as "parentAgentId."
- Input — The type of input expected by the AI agent.
- Output — The type of output produced by the AI agent.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.tools.AgentContextAwareTool.AgentContextAwareTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.tools/-agent-context-aware-tool/-agent-context-aware-tool.html`

### :agents:agents-core/commonMain

```kotlin
constructor(argsType: TypeToken, resultType: TypeToken, descriptor: ToolDescriptor, metadata: Map<String, String> = emptyMap())
```

- TArgs — The type of arguments the tool accepts.
- TResult — The type of result the tool returns.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
constructor(argsType: TypeToken, resultType: TypeToken, name: String, description: String, jsonSchemaConfig: JsonSchemaConfig = defaultJsonSchemaConfig)
```

Convenience constructor that generates ToolDescriptor from the provided name, description and argsType.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.tools.AgentContextAwareTool.Companion.AgentContextKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.tools/-agent-context-aware-tool/-companion/-agent-context-key.html`

### :agents:agents-core/commonMain

```kotlin
const val AgentContextKey: String
```

Reserved ToolCallMetadata key under which the framework stores the live AIAgentContext before dispatching a tool. The framework writes this entry last in the metadata merge, so caller- and feature-supplied values never override it.

## ai.koog.agents.core.agent.tools.AgentContextAwareTool.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.tools/-agent-context-aware-tool/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

## ai.koog.agents.core.agent.tools.AgentContextAwareTool.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.tools/-agent-context-aware-tool/execute.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun execute(args: TArgs, context: AIAgentContext): TResult
```

Executes the tool's logic with the provided arguments and the live AIAgentContext driving the current call.

The result of the tool's execution.

- args — The input arguments required to execute the tool.
- context — The agent context (LLM context, run id, configuration, storage, ...).

Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-core/commonMain

```kotlin
suspend override fun execute(args: TArgs, metadata: ToolCallMetadata): TResult
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.tools.AgentContextAwareTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.tools/-agent-context-aware-tool/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AgentContextAwareTool<TArgs, TResult>(argsType: TypeToken, resultType: TypeToken, descriptor: ToolDescriptor, metadata: Map<String, String> = emptyMap()) : ToolBase<TArgs, TResult>
```

A tool whose execute receives the live AIAgentContext driving the current call.

The framework injects the context under AgentContextKey in ToolCallMetadata before dispatch (see ai.koog.agents.core.environment.ContextualAgentEnvironment). This subclass reads that entry and forwards it to the user-facing overload, so implementors get a typed AIAgentContext parameter rather than a Map lookup.

Use this when a tool needs the agent's full state (LLM context, run id, configuration, storage, ...). For tools that only need the typed arguments, extend Tool instead; for tools that read raw ToolCallMetadata entries contributed by features (for example a trace span id), extend ToolBase directly.

Invoking an AgentContextAwareTool outside an agent run is a programming error: with no AgentContextKey entry in the metadata, execute throws IllegalStateException naming the tool. Tests that need to exercise such a tool can construct metadata via ToolCallMetadata.of(AgentContextAwareTool.AgentContextKey to context) or call execute(args, context) directly.

- TArgs — The type of arguments the tool accepts.
- TResult — The type of result the tool returns.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.tools.agentContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.tools/agent-context.html`

### :agents:agents-core/commonMain

```kotlin
val ToolCallMetadata.agentContext: AIAgentContext?
```

The AIAgentContext of the agent run that is invoking this tool, or null if the metadata was not produced by the framework (for example when ToolBase.execute is called directly outside an agent run, such as from a unit test).

The framework injects the live agent context under AgentContextAwareTool.AgentContextKey after merging caller- and feature-supplied entries, so the value here is always the real context driving the current tool call. Tools that extend AgentContextAwareTool receive that context as a typed parameter; this extension is the ergonomic accessor for tools that extend ToolBase directly and want both the raw metadata bag and the context.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.SimpleTool.SimpleTool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-simple-tool/-simple-tool.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(argsType: TypeToken, name: String, description: String)
```

- TArgs — The type of arguments the tool accepts.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.SimpleTool.encodeResultToString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-simple-tool/encode-result-to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open override fun encodeResultToString(result: String, serializer: JSONSerializer): String
```

Encodes the given result of type TResult to its string representation. This is used to provide the LLM with the result of the tool execution. It can be overridden to customize the string representation the LLM will see.

- result — The result object of type TResult to be encoded into a string.
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.SimpleTool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-simple-tool/index.html`

### :agents:agents-tools/commonMain

```kotlin
abstract class SimpleTool<TArgs>(argsType: TypeToken, name: String, description: String) : Tool<TArgs, String>
```

Represents a simplified tool base class that processes specific arguments and produces a textual result.

- TArgs — The type of arguments the tool accepts.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.Tool.Tool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool/-tool.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(argsType: TypeToken, resultType: TypeToken, descriptor: ToolDescriptor, metadata: Map<String, String> = emptyMap())
```

- TArgs — The type of arguments the tool accepts.
- TResult — The type of result the tool returns.

Referenced packages: `ai.koog.serialization`.

### :agents:agents-tools/commonMain

```kotlin
constructor(argsType: TypeToken, resultType: TypeToken, name: String, description: String, jsonSchemaConfig: JsonSchemaConfig = defaultJsonSchemaConfig)
```

Convenience constructor that generates ToolDescriptor from the provided name, description and argsType.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.Tool.execute

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool/execute.html`

### :agents:agents-tools/commonMain

```kotlin
abstract suspend fun execute(args: TArgs): TResult
```

Executes the tool's logic with the provided arguments.

In the actual agent implementation, it is not recommended to call tools directly as this might cause issues, such as:

Bugs with feature pipelines

Inability to test/mock

Consider using methods like findTool(tool: Class) or similar, to retrieve a SafeTool, and then call execute on it. This ensures that the tool call is delegated properly to the underlying environment object.

The result of the tool's execution.

- args — The input arguments required to execute the tool.
### :agents:agents-tools/commonMain

```kotlin
suspend override fun execute(args: TArgs, metadata: ToolCallMetadata): TResult
```

Executes the tool's logic with the provided arguments and per-call metadata.

This is the single dispatch entry point used by the agent runtime. metadata is an additive side channel for cross-cutting context (for example a tracing span id or a correlation id); it is not part of the argument schema and is not exposed to the LLM.

Most tools should extend Tool (which provides a no-metadata execute(args) shape) or ai.koog.agents.core.tools.AgentContextAwareTool (which provides typed access to the live AIAgentContext) rather than overriding this overload directly. Override here only when you need to read raw ToolCallMetadata entries.

In the actual agent implementation, it is not recommended to call tools directly as this might cause issues, such as:

Bugs with feature pipelines

Inability to test/mock

Consider using methods like findTool(tool: Class) or similar, to retrieve a SafeTool, and then call execute on it. This ensures that the tool call is delegated properly to the underlying environment object.

The result of the tool's execution.

- args — The input arguments required to execute the tool.
- metadata — Caller- and feature-contributed per-call context. ToolCallMetadata.EMPTY when absent.
## ai.koog.agents.core.tools.Tool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool/index.html`

### :agents:agents-tools/commonMain

```kotlin
abstract class Tool<TArgs, TResult>(argsType: TypeToken, resultType: TypeToken, descriptor: ToolDescriptor, metadata: Map<String, String> = emptyMap()) : ToolBase<TArgs, TResult>
```

A tool with a no-metadata execute shape. The runtime dispatches it through ToolBase.execute; this subclass's final override forwards to execute and discards any per-call ToolCallMetadata supplied by the caller or contributed by features.

Existing tool implementations subclass this type. Implementations that need typed access to the live AIAgentContext should extend ai.koog.agents.core.agent.tools.AgentContextAwareTool (in agents-core) instead; implementations that need raw ToolCallMetadata entries (for example a tracing span id contributed by a feature) should extend ToolBase directly.

- TArgs — The type of arguments the tool accepts.
- TResult — The type of result the tool returns.
- SimpleTool
- ToolFromCallable

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.ToolBase

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/-tool-base.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(argsType: TypeToken, resultType: TypeToken, descriptor: ToolDescriptor, metadata: Map<String, String> = emptyMap())
```

- TArgs — The type of arguments the tool accepts.
- TResult — The type of result the tool returns.

Referenced packages: `ai.koog.serialization`.

### :agents:agents-tools/commonMain

```kotlin
constructor(argsType: TypeToken, resultType: TypeToken, name: String, description: String, jsonSchemaConfig: JsonSchemaConfig = defaultJsonSchemaConfig)
```

Convenience constructor that generates ToolDescriptor from the provided name, description and argsType.

- argsType — Type token representing arguments type TArgs.
- resultType — Type token representing result type TResult.
- name — The name of the tool.
- description — Textual explanation of what the tool does and how it can be used (for the LLM).
- jsonSchemaConfig — Optional custom JsonSchemaConfig for the tool schema generation.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.argsType

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/args-type.html`

### :agents:agents-tools/commonMain

```kotlin
val argsType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.decodeArgs

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/decode-args.html`

### :agents:agents-tools/commonMain

```kotlin
open fun decodeArgs(rawArgs: JSONObject, serializer: JSONSerializer): TArgs
```

Decodes the provided raw JSON arguments into an instance of the specified arguments type.

- rawArgs — The raw JSON object that contains the encoded arguments
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.decodeResult

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/decode-result.html`

### :agents:agents-tools/commonMain

```kotlin
open fun decodeResult(rawResult: JSONElement, serializer: JSONSerializer): TResult
```

Decodes the provided raw JSON element into an instance of the specified result type.

- rawResult — The raw JSON element that contains the encoded result.
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.descriptor

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/descriptor.html`

### :agents:agents-tools/commonMain

```kotlin
val descriptor: ToolDescriptor
```

## ai.koog.agents.core.tools.ToolBase.encodeArgsToStringUnsafe

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-args-to-string-unsafe.html`

### :agents:agents-tools/commonMain

```kotlin
fun encodeArgsToStringUnsafe(args: Any?, serializer: JSONSerializer): String
```

Encodes the provided arguments into a JSON string representation without type safety checks.

- ClassCastException — If the provided arguments cannot be cast to the expected type TArgs.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeArgsToString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-args-to-string.html`

### :agents:agents-tools/commonMain

```kotlin
fun encodeArgsToString(args: TArgs, serializer: JSONSerializer): String
```

Encodes the provided arguments into a JSON string representation.

- args — the arguments to be encoded into a JSON string
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeArgsUnsafe

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-args-unsafe.html`

### :agents:agents-tools/commonMain

```kotlin
fun encodeArgsUnsafe(args: Any?, serializer: JSONSerializer): JSONObject
```

Encodes the given arguments into a JSON representation without type safety checks.

- ClassCastException — If the provided arguments cannot be cast to the expected type.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeArgs

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-args.html`

### :agents:agents-tools/commonMain

```kotlin
open fun encodeArgs(args: TArgs, serializer: JSONSerializer): JSONObject
```

Encodes the given arguments into a JSON representation.

- args — The arguments to be encoded.
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeResultToPartsUnsafe

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-result-to-parts-unsafe.html`

### :agents:agents-tools/commonMain

```kotlin
fun encodeResultToPartsUnsafe(result: Any?, serializer: JSONSerializer): List<MessagePart.ContentPart>
```

Encodes the given result as content parts without type safety checks.

- ClassCastException — If the provided result cannot be cast to the expected type TResult.

Referenced packages: `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeResultToParts

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-result-to-parts.html`

### :agents:agents-tools/commonMain

```kotlin
open fun encodeResultToParts(result: TResult, serializer: JSONSerializer): List<MessagePart.ContentPart>
```

Encodes the given result as a list of MessagePart.ContentPart to be sent to the LLM.

Override this to return non-text content (images, files, etc.) alongside or instead of the default text representation. The default wraps encodeResultToString in a single MessagePart.Text.

Note: not all LLM providers support non-text content in tool results. Clients will log a warning and fall back gracefully when an unsupported part type is encountered.

A list of content parts representing the tool result.

- result — The result returned by execute.
- serializer — The JSON serializer available for encoding structured data.

Referenced packages: `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeResultToStringUnsafe

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-result-to-string-unsafe.html`

### :agents:agents-tools/commonMain

```kotlin
fun encodeResultToStringUnsafe(result: Any?, serializer: JSONSerializer): String
```

Encodes the provided result object into a JSON string representation without type safety checks.

- ClassCastException — If the provided result cannot be cast to the expected type TResult.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeResultToString

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-result-to-string.html`

### :agents:agents-tools/commonMain

```kotlin
open fun encodeResultToString(result: TResult, serializer: JSONSerializer): String
```

Encodes the given result of type TResult to its string representation. This is used to provide the LLM with the result of the tool execution. It can be overridden to customize the string representation the LLM will see.

- result — The result object of type TResult to be encoded into a string.
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeResultUnsafe

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-result-unsafe.html`

### :agents:agents-tools/commonMain

```kotlin
fun encodeResultUnsafe(result: Any?, serializer: JSONSerializer): JSONElement
```

Encodes the given result object into a JSON representation without type safety checks.

- ClassCastException — If the provided result cannot be cast to the expected type TResult.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.encodeResult

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/encode-result.html`

### :agents:agents-tools/commonMain

```kotlin
open fun encodeResult(result: TResult, serializer: JSONSerializer): JSONElement
```

Encodes the given result into a JSON representation.

- result — The result object of type TResult to be encoded.
- serializer — The JSON serializer to use.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.executeUnsafe

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/execute-unsafe.html`

### :agents:agents-tools/commonMain

```kotlin
suspend fun executeUnsafe(args: Any?): TResult
```

Executes the tool with the provided arguments without type safety checks.

- ClassCastException — if the provided arguments cannot be cast to the expected type TArgs.
### :agents:agents-tools/commonMain

```kotlin
suspend fun executeUnsafe(args: Any?, metadata: ToolCallMetadata): TResult
```

Executes the tool with the provided arguments and metadata without type safety checks.

- ClassCastException — if the provided arguments cannot be cast to the expected type TArgs.
## ai.koog.agents.core.tools.ToolBase.execute

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/execute.html`

### :agents:agents-tools/commonMain

```kotlin
abstract suspend fun execute(args: TArgs, metadata: ToolCallMetadata): TResult
```

Executes the tool's logic with the provided arguments and per-call metadata.

This is the single dispatch entry point used by the agent runtime. metadata is an additive side channel for cross-cutting context (for example a tracing span id or a correlation id); it is not part of the argument schema and is not exposed to the LLM.

Most tools should extend Tool (which provides a no-metadata execute(args) shape) or ai.koog.agents.core.tools.AgentContextAwareTool (which provides typed access to the live AIAgentContext) rather than overriding this overload directly. Override here only when you need to read raw ToolCallMetadata entries.

In the actual agent implementation, it is not recommended to call tools directly as this might cause issues, such as:

Bugs with feature pipelines

Inability to test/mock

Consider using methods like findTool(tool: Class) or similar, to retrieve a SafeTool, and then call execute on it. This ensures that the tool call is delegated properly to the underlying environment object.

The result of the tool's execution.

- args — The input arguments required to execute the tool.
- metadata — Caller- and feature-contributed per-call context. ToolCallMetadata.EMPTY when absent.
## ai.koog.agents.core.tools.ToolBase

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/index.html`

### :agents:agents-tools/commonMain

```kotlin
abstract class ToolBase<TArgs, TResult>(val argsType: TypeToken, val resultType: TypeToken, val descriptor: ToolDescriptor, val metadata: Map<String, String> = emptyMap())
```

The runtime contract that every tool dispatched by the agent satisfies.

The agent runtime invokes execute uniformly, threading caller- and feature-supplied ToolCallMetadata alongside the typed TArgs. Subclasses define what that overload means:

Tool is the conventional shape with an Tool.execute taking only the arguments. Existing subclasses keep working unchanged.

ai.koog.agents.core.agent.tools.AgentContextAwareTool (in agents-core) gives the implementation typed access to the live AIAgentContext driving the current call.

A subclass that needs raw ToolCallMetadata (for example to read a trace span id contributed by a feature) can extend ToolBase directly and override execute. Splitting that concern from the agent-context concern keeps agents-tools free of any agents-core dependency.

- TArgs — The type of arguments the tool accepts.
- TResult — The type of result the tool returns.
- Tool

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolBase.metadata

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/metadata.html`

### :agents:agents-tools/commonMain

```kotlin
val metadata: Map<String, String>
```

## ai.koog.agents.core.tools.ToolBase.name

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/name.html`

### :agents:agents-tools/commonMain

```kotlin
val name: String
```

The name of the tool from the descriptor.

## ai.koog.agents.core.tools.ToolBase.resultType

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-base/result-type.html`

### :agents:agents-tools/commonMain

```kotlin
val resultType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.ToolCallMetadata.Companion.EMPTY

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/-companion/-e-m-p-t-y.html`

### :agents:agents-tools/commonMain

```kotlin
val EMPTY: ToolCallMetadata
```

A shared empty ToolCallMetadata instance used as the default throughout the framework.

## ai.koog.agents.core.tools.ToolCallMetadata.Companion

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/-companion/index.html`

### :agents:agents-tools/commonMain

```kotlin
object Companion
```

## ai.koog.agents.core.tools.ToolCallMetadata.Companion.of

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/-companion/of.html`

### :agents:agents-tools/commonMain

```kotlin
fun of(vararg pairs: Pair<String, Any?>): ToolCallMetadata
```

Creates a ToolCallMetadata from the given pairs. Returns EMPTY if no pairs are supplied.

## ai.koog.agents.core.tools.ToolCallMetadata.ToolCallMetadata

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/-tool-call-metadata.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(content: Map<String, Any?>)
```

## ai.koog.agents.core.tools.ToolCallMetadata

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/index.html`

### :agents:agents-tools/commonMain

```kotlin
class ToolCallMetadata(content: Map<String, Any?>) : Map<String, Any?>
```

Immutable, caller-contributed context threaded into Tool.execute alongside the typed arguments.

This is a strictly additive side channel: values are not part of the tool's argument schema, are not serialized to or from the LLM, and must not be relied on for routing or tool selection. Typical use cases are cross-cutting concerns such as a distributed-tracing span identifier, a run-scoped correlation id, or a per-call feature flag contributed by an installed feature.

The class implements Map over String keys to Any? values by delegating to the underlying map, so all standard read-only map operations (get, containsKey, isEmpty, keys, the in operator, and so on) are available directly on the instance without bespoke wrappers.

Instances can be constructed from a Map, built via of, or combined with plus. The EMPTY singleton represents the absence of metadata and is the default passed through the framework.

## ai.koog.agents.core.tools.ToolCallMetadata.plus

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-call-metadata/plus.html`

### :agents:agents-tools/commonMain

```kotlin
operator fun plus(other: ToolCallMetadata): ToolCallMetadata
```

### :agents:agents-tools/commonMain

```kotlin
operator fun plus(other: Map<String, Any?>): ToolCallMetadata
```

Returns a new ToolCallMetadata containing entries from this instance plus other. Entries in other overwrite entries with the same key in this instance.

## ai.koog.agents.core.tools.ToolDescriptor.ToolDescriptor

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/-tool-descriptor.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(name: String, description: String, requiredParameters: List<ToolParameterDescriptor> = emptyList(), optionalParameters: List<ToolParameterDescriptor> = emptyList(), cacheControl: CacheControl? = null)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.tools.ToolDescriptor.cacheControl

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/cache-control.html`

### :agents:agents-tools/commonMain

```kotlin
val cacheControl: CacheControl?
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.tools.ToolDescriptor.description

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/description.html`

### :agents:agents-tools/commonMain

```kotlin
val description: String
```

## ai.koog.agents.core.tools.ToolDescriptor

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/index.html`

### :agents:agents-tools/commonMain

```kotlin
open class ToolDescriptor(val name: String, val description: String, val requiredParameters: List<ToolParameterDescriptor> = emptyList(), val optionalParameters: List<ToolParameterDescriptor> = emptyList(), val cacheControl: CacheControl? = null)
```

Represents a descriptor for a tool that contains information about the tool's name, description, required parameters, and optional parameters.

This class is annotated with @Serializable to support serialization/deserialization using kotlinx.serialization.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.tools.ToolDescriptor.name

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/name.html`

### :agents:agents-tools/commonMain

```kotlin
val name: String
```

## ai.koog.agents.core.tools.ToolDescriptor.optionalParameters

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/optional-parameters.html`

### :agents:agents-tools/commonMain

```kotlin
val optionalParameters: List<ToolParameterDescriptor>
```

## ai.koog.agents.core.tools.ToolDescriptor.requiredParameters

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/required-parameters.html`

### :agents:agents-tools/commonMain

```kotlin
val requiredParameters: List<ToolParameterDescriptor>
```

## ai.koog.agents.core.tools.ToolDescriptor.withCacheControl

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-descriptor/with-cache-control.html`

### :agents:agents-tools/commonMain

```kotlin
fun withCacheControl(cacheControl: CacheControl): ToolDescriptor
```

Returns a copy of this tool descriptor with cache control enabled.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.tools.ToolException.ValidationFailure.ValidationFailure

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-exception/-validation-failure/-validation-failure.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(message: String)
```

Creates a ValidationFailure instance with the given message.

- message — The detail message describing the validation error.
## ai.koog.agents.core.tools.ToolException.ValidationFailure

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-exception/-validation-failure/index.html`

### :agents:agents-tools/commonMain

```kotlin
class ValidationFailure(message: String) : ToolException
```

Represents a failure that occurs during validation processes.

This exception is a specific type of ToolException used to indicate that validation of some input or process has failed. It typically contains a message that provides more details about the validation failure.

- message — The detail message describing the validation error.
## ai.koog.agents.core.tools.ToolException

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-exception/index.html`

### :agents:agents-tools/commonMain

```kotlin
@Serializable sealed class ToolException : Exception
```

A base sealed class representing exceptions specific to tools. This class provides a structure for exceptions with a custom message.

- ValidationFailure
## ai.koog.agents.core.tools.ToolException.message

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-exception/message.html`

### :agents:agents-tools/commonMain

```kotlin
open override val message: String
```

## ai.koog.agents.core.tools.ToolParameterDescriptor.ToolParameterDescriptor

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-descriptor/-tool-parameter-descriptor.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(name: String, description: String, type: ToolParameterType)
```

## ai.koog.agents.core.tools.ToolParameterDescriptor.description

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-descriptor/description.html`

### :agents:agents-tools/commonMain

```kotlin
val description: String
```

## ai.koog.agents.core.tools.ToolParameterDescriptor

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-descriptor/index.html`

### :agents:agents-tools/commonMain

```kotlin
data class ToolParameterDescriptor(val name: String, val description: String, val type: ToolParameterType)
```

Represents a descriptor for a tool parameter. A tool parameter descriptor contains information about a specific tool parameter, such as its name, description, data type, and default value.

Note that parameters are deserialized using CamelCase to snake_case conversion, so use snake_case names

This class is annotated with @Serializable to support serialization/deserialization using kotlinx.serialization.

## ai.koog.agents.core.tools.ToolParameterDescriptor.name

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-descriptor/name.html`

### :agents:agents-tools/commonMain

```kotlin
val name: String
```

## ai.koog.agents.core.tools.ToolParameterDescriptor.type

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-descriptor/type.html`

### :agents:agents-tools/commonMain

```kotlin
val type: ToolParameterType
```

## ai.koog.agents.core.tools.ToolParameterType.AnyOf.AnyOf

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/-any-of.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(types: Array<ToolParameterDescriptor>)
```

## ai.koog.agents.core.tools.ToolParameterType.AnyOf.hackRepresentAnyOfWithNullAsTypeUnionWithNull

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/hack-represent-any-of-with-null-as-type-union-with-null.html`

### :agents:agents-tools/commonMain

```kotlin
fun hackRepresentAnyOfWithNullAsTypeUnionWithNull(getTypeDefinition: (ToolParameterType) -> JsonObject): JsonObject?
```

Our API doesn't support proper nullability yet via type unions, such as "type": ["string", "null"]. Instead, we rely on anyOf with "null" type. However, not all LLM providers support anyOf in their tool schemas, Anthropic being one of them. This is a hack that tries to detect such anyOf's and generate a proper JsonObject with type union on "null" instead.

JsonObject with generated tool schema, or null if the type is not AnyOf with "null" type.

- getTypeDefinition — The function that generates the type definition for a given type.
## ai.koog.agents.core.tools.ToolParameterType.AnyOf

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/index.html`

### :agents:agents-tools/commonMain

```kotlin
data class AnyOf(val types: Array<ToolParameterDescriptor>) : ToolParameterType
```

Represents an anyOf type parameter.

## ai.koog.agents.core.tools.ToolParameterType.AnyOf.types

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-any-of/types.html`

### :agents:agents-tools/commonMain

```kotlin
val types: Array<ToolParameterDescriptor>
```

## ai.koog.agents.core.tools.ToolParameterType.Boolean

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-boolean/index.html`

### :agents:agents-tools/commonMain

```kotlin
data object Boolean : ToolParameterType
```

Represents a boolean type parameter.

## ai.koog.agents.core.tools.ToolParameterType.Companion.Enum

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-companion/-enum.html`

### :agents:agents-tools/commonMain

```kotlin
fun Enum(entries: EnumEntries<*>): ToolParameterType.Enum
```

Creates an Enum instance using the provided EnumEntries.

A new Enum instance populated with the names of the provided entries.

- entries — The EnumEntries to initialize the Enum instance. The names of the entries will be used.
### :agents:agents-tools/commonMain

```kotlin
fun Enum(entries: Array<Enum<*>>): ToolParameterType.Enum
```

Constructs an Enum parameter type from an array of Enum entries.

An instance of Enum containing the names of the provided Enum entries.

- entries — An array of Enum entries from which the parameter type is constructed. Each entry's name is extracted to define the enumeration values.
## ai.koog.agents.core.tools.ToolParameterType.Companion

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-companion/index.html`

### :agents:agents-tools/commonMain

```kotlin
object Companion
```

Companion object for the enclosing class. Provides utility functions for creating instances of the Enum type parameter from different kinds of inputs.

## ai.koog.agents.core.tools.ToolParameterType.Enum.Enum

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-enum/-enum.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(entries: Array<String>)
```

## ai.koog.agents.core.tools.ToolParameterType.Enum.entries

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-enum/entries.html`

### :agents:agents-tools/commonMain

```kotlin
val entries: Array<String>
```

## ai.koog.agents.core.tools.ToolParameterType.Enum

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-enum/index.html`

### :agents:agents-tools/commonMain

```kotlin
data class Enum(val entries: Array<String>) : ToolParameterType
```

Represents an enum type parameter.

## ai.koog.agents.core.tools.ToolParameterType.Float

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-float/index.html`

### :agents:agents-tools/commonMain

```kotlin
data object Float : ToolParameterType
```

Represents a float type parameter.

## ai.koog.agents.core.tools.ToolParameterType.Integer

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-integer/index.html`

### :agents:agents-tools/commonMain

```kotlin
data object Integer : ToolParameterType
```

Represents an integer type parameter.

## ai.koog.agents.core.tools.ToolParameterType.List.List

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-list/-list.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(itemsType: ToolParameterType)
```

## ai.koog.agents.core.tools.ToolParameterType.List

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-list/index.html`

### :agents:agents-tools/commonMain

```kotlin
data class List(val itemsType: ToolParameterType) : ToolParameterType
```

Represents an array type parameter.

## ai.koog.agents.core.tools.ToolParameterType.List.itemsType

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-list/items-type.html`

### :agents:agents-tools/commonMain

```kotlin
val itemsType: ToolParameterType
```

## ai.koog.agents.core.tools.ToolParameterType.Null

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-null/index.html`

### :agents:agents-tools/commonMain

```kotlin
data object Null : ToolParameterType
```

## ai.koog.agents.core.tools.ToolParameterType.Object.Object

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/-object.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(properties: List<ToolParameterDescriptor>, requiredProperties: List<String> = listOf(), additionalProperties: Boolean? = null, additionalPropertiesType: ToolParameterType? = null)
```

## ai.koog.agents.core.tools.ToolParameterType.Object.additionalPropertiesType

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/additional-properties-type.html`

### :agents:agents-tools/commonMain

```kotlin
val additionalPropertiesType: ToolParameterType?
```

## ai.koog.agents.core.tools.ToolParameterType.Object.additionalProperties

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/additional-properties.html`

### :agents:agents-tools/commonMain

```kotlin
val additionalProperties: Boolean?
```

## ai.koog.agents.core.tools.ToolParameterType.Object

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/index.html`

### :agents:agents-tools/commonMain

```kotlin
data class Object(val properties: List<ToolParameterDescriptor>, val requiredProperties: List<String> = listOf(), val additionalProperties: Boolean? = null, val additionalPropertiesType: ToolParameterType? = null) : ToolParameterType
```

Represents an object-type parameter used in the tool's parameter schema. This class is a specialization of ToolParameterType with the parameter type set to "OBJECT".

## ai.koog.agents.core.tools.ToolParameterType.Object.properties

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/properties.html`

### :agents:agents-tools/commonMain

```kotlin
val properties: List<ToolParameterDescriptor>
```

## ai.koog.agents.core.tools.ToolParameterType.Object.requiredProperties

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-object/required-properties.html`

### :agents:agents-tools/commonMain

```kotlin
val requiredProperties: List<String>
```

## ai.koog.agents.core.tools.ToolParameterType.String

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/-string/index.html`

### :agents:agents-tools/commonMain

```kotlin
data object String : ToolParameterType
```

Represents a string type parameter.

## ai.koog.agents.core.tools.ToolParameterType

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/index.html`

### :agents:agents-tools/commonMain

```kotlin
sealed class ToolParameterType
```

Sealed class representing different types of tool parameters.

Each subclass of ToolParameterType denotes a specific data type that a tool parameter can have.

- T — The type of data that the tool parameter represents.
- String
- Null
- Integer
- Float
- Boolean
- Enum
- List
- AnyOf
- Object
## ai.koog.agents.core.tools.ToolParameterType.name

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-parameter-type/name.html`

### :agents:agents-tools/commonMain

```kotlin
val name: String
```

## ai.koog.agents.core.tools.ToolRegistry.Companion.EMPTY

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/-companion/-e-m-p-t-y.html`

### :agents:agents-tools/commonMain

```kotlin
val EMPTY: ToolRegistry
```

A constant representing an empty registry with no tools. TODO(KG-676): ToolRegistry is mutable but stored as an immutable object.

## ai.koog.agents.core.tools.ToolRegistry.Companion.builder

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/-companion/builder.html`

### :agents:agents-tools/commonMain

```kotlin
fun builder(): ToolRegistryBuilder
```

Creates a new instance of the Builder class, which is used to construct and manage a registry of tools.

The Builder provides methods to add tools to the registry and ensures that each tool has a unique name.

A new instance of the Builder class for constructing a ToolRegistry.

## ai.koog.agents.core.tools.ToolRegistry.Companion

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/-companion/index.html`

### :agents:agents-tools/commonMain

```kotlin
object Companion
```

Companion object providing factory methods and constants for ToolRegistry.

## ai.koog.agents.core.tools.ToolRegistry.ToolRegistry

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/-tool-registry.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(init: ToolRegistryBuilder.() -> Unit)
```

Creates a new ToolRegistry using the provided builder initialization block.

- init — A lambda that configures the registry by adding tools
## ai.koog.agents.core.tools.ToolRegistry.addAll

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/add-all.html`

### :agents:agents-tools/commonMain

```kotlin
fun addAll(vararg tools: ToolBase<*, *>)
```

Adds multiple tools to the registry.

This method accepts a variable number of tools and adds each of them to the registry.

- tools — The tools to be added to the registry.
## ai.koog.agents.core.tools.ToolRegistry.add

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/add.html`

### :agents:agents-tools/commonMain

```kotlin
fun add(tool: ToolBase<*, *>)
```

Adds a tool to the registry if it is not already present.

- tool — The tool to be added to the registry.
## ai.koog.agents.core.tools.ToolRegistry.getToolOrNull

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/get-tool-or-null.html`

### :agents:agents-tools/commonMain

```kotlin
fun getToolOrNull(toolName: String): ToolBase<*, *>?
```

Retrieves a tool by its name from the registry, or null if not found.

This method searches for a tool with the specified name and returns null if no matching tool is found.

The tool with the specified name, or null if not found

- toolName — The name of the tool to retrieve
## ai.koog.agents.core.tools.ToolRegistry.getTool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/get-tool.html`

### :agents:agents-tools/commonMain

```kotlin
fun getTool(toolName: String): ToolBase<*, *>
```

Retrieves a tool by its name from the registry.

This method searches for a tool with the specified name.

The tool with the specified name

- toolName — The name of the tool to retrieve
- IllegalArgumentException — if no tool with the specified name is found
### :agents:agents-tools/commonMain

```kotlin
inline fun <T : ToolBase<*, *>> getTool(): T
```

Retrieves a tool by its type from registry.

This method searches for a tool of the specified type.

The tool of the specified type

- T — The type of tool to retrieve
- IllegalArgumentException — if no tool of the specified type is found
## ai.koog.agents.core.tools.ToolRegistry

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/index.html`

### :agents:agents-tools/commonMain

```kotlin
class ToolRegistry
```

A registry that manages a collection of tools for use by agents.

ToolRegistry serves as a central repository for all tools available to an agent. It provides functionality to register tools and retrieve them by name or type.

Key features:

Maintains a unique collection of named tools

Provides methods to retrieve tools by name or type

Supports merging multiple registries

Usage examples:

Creating a registry:

Merging registries:

## ai.koog.agents.core.tools.ToolRegistry.plus

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/plus.html`

### :agents:agents-tools/commonMain

```kotlin
operator fun plus(toolRegistry: ToolRegistry): ToolRegistry
```

Combines the tools from this registry and the provided registry into a new ToolRegistry.

This method merges the tools from both registries, ensuring that each tool is included only once, based on its name.

A new ToolRegistry containing the combined list of tools from both registries.

- toolRegistry — The other ToolRegistry whose tools will be merged with the current registry.
## ai.koog.agents.core.tools.ToolRegistry.tools

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry/tools.html`

### :agents:agents-tools/commonMain

```kotlin
val tools: List<ToolBase<*, *>>
```

Provides an immutable list of tools currently available in the registry.

The tools are sourced from the internal backing collection and returned as a read-only list to prevent external modification of the registry state.

## ai.koog.agents.core.tools.ToolRegistryBuilder.ToolRegistryBuilder

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry-builder/-tool-registry-builder.html`

### :agents:agents-tools/commonMain

```kotlin
expect constructor()
```

### :agents:agents-tools/jvmCommonMain

```kotlin
constructor()
```

### :agents:agents-tools/nonJvmCommonMain

```kotlin
constructor()
```

## ai.koog.agents.core.tools.ToolRegistryBuilder.build

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry-builder/build.html`

### :agents:agents-tools/commonMain

```kotlin
expect fun build(): ToolRegistry
```

Builds a ToolRegistry instance containing the tools added to the builder.

### :agents:agents-tools/jvmCommonMain

```kotlin
actual fun build(): ToolRegistry
```

Builds a ToolRegistry instance containing the tools added to the builder.

### :agents:agents-tools/nonJvmCommonMain

```kotlin
actual fun build(): ToolRegistry
```

Builds a ToolRegistry instance containing the tools added to the builder.

## ai.koog.agents.core.tools.ToolRegistryBuilder

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry-builder/index.html`

### :agents:agents-tools/commonMain

```kotlin
expect class ToolRegistryBuilder
```

A builder class for creating a ToolRegistry instance. This class provides methods to configure and register tools, either individually or as a list, and then constructs a registry containing the defined tools.

### :agents:agents-tools/jvmCommonMain

```kotlin
actual class ToolRegistryBuilder
```

A builder class for creating a ToolRegistry instance. This class provides methods to configure and register tools, either individually or as a list, and then constructs a registry containing the defined tools.

### :agents:agents-tools/nonJvmCommonMain

```kotlin
actual class ToolRegistryBuilder
```

A builder class for creating a ToolRegistry instance. This class provides methods to configure and register tools, either individually or as a list, and then constructs a registry containing the defined tools.

## ai.koog.agents.core.tools.ToolRegistryBuilder.tool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry-builder/tool.html`

### :agents:agents-tools/commonMain

```kotlin
expect fun tool(tool: ToolBase<*, *>): ToolRegistryBuilder
```

Add a tool to the registry

### :agents:agents-tools/jvmCommonMain

```kotlin
fun tool(toolFunction: KFunction<*>, thisRef: Any? = null, name: String? = null, description: String? = null): ToolRegistryBuilder
```

### :agents:agents-tools/jvmCommonMain

```kotlin
fun tool(toolFunction: Method, thisRef: Any? = null, name: String? = null, description: String? = null): ToolRegistryBuilder
```

Registers toolFunction as a tool in the ToolRegistry.

- asTool
### :agents:agents-tools/jvmCommonMain

```kotlin
actual fun tool(tool: ToolBase<*, *>): ToolRegistryBuilder
```

Add a tool to the registry

### :agents:agents-tools/nonJvmCommonMain

```kotlin
actual fun tool(tool: ToolBase<*, *>): ToolRegistryBuilder
```

Add a tool to the registry

## ai.koog.agents.core.tools.ToolRegistryBuilder.tools

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/-tool-registry-builder/tools.html`

### :agents:agents-tools/commonMain

```kotlin
expect fun tools(toolsList: List<ToolBase<*, *>>): ToolRegistryBuilder
```

Add multiple tools to the registry

### :agents:agents-tools/jvmCommonMain

```kotlin
fun tools(instance: ToolSet): ToolRegistryBuilder
```

Registers a set of tools from the instance in the ToolRegistry .


Referenced packages: `ai.koog.agents.core.tools.reflect`.

### :agents:agents-tools/jvmCommonMain

```kotlin
actual fun tools(toolsList: List<ToolBase<*, *>>): ToolRegistryBuilder
```

Add multiple tools to the registry

### :agents:agents-tools/nonJvmCommonMain

```kotlin
actual fun tools(toolsList: List<ToolBase<*, *>>): ToolRegistryBuilder
```

Add multiple tools to the registry

## ai.koog.agents.core.tools.fail

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/fail.html`

### :agents:agents-tools/commonMain

```kotlin
fun fail(message: String): Nothing
```

Throws a ToolException.ValidationFailure exception with the specified error message.

Nothing, as this function always throws an exception.

- message — The error message to include in the exception.
## ai.koog.agents.core.tools.validateNotNull

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/validate-not-null.html`

### :agents:agents-tools/commonMain

```kotlin
fun <T : Any> validateNotNull(value: T?, message: () -> String): T
```

Validates that the provided value is not null. If the value is null, a ToolException.ValidationFailure exception is thrown with the provided error message.

The same non-null value that was provided as input.

- value — The value to be validated as not null.
- message — A lambda that provides the error message in case the value is null.
- ToolException.ValidationFailure — if the value is null.
## ai.koog.agents.core.tools.validate

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools/validate.html`

### :agents:agents-tools/commonMain

```kotlin
fun validate(expectation: Boolean, message: () -> String)
```

Validates a given condition and throws a ToolException.ValidationFailure exception if the condition is not met.

- expectation — The condition that is expected to be true.
- message — A lambda function to generate the exception message if the condition is not met.
## ai.koog.agents.core.tools.annotations.LLMDescription

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.annotations/-l-l-m-description/index.html`

### :agents:agents-tools/commonMain

```kotlin
@SerialInfo @Target(allowedTargets = [AnnotationTarget.PROPERTY, AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION]) annotation class LLMDescription(val value: String)
```

Description for an entity that can be provided to LLMs. You may use it to annotate properties, functions, parameters, classes, return types, etc.

## ai.koog.agents.core.tools.annotations.LLMDescription.value

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.annotations/-l-l-m-description/value.html`

### :agents:agents-tools/commonMain

```kotlin
val value: String
```

## ai.koog.agents.core.tools.annotations.Tool.customName

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.annotations/-tool/custom-name.html`

### :agents:agents-tools/commonMain

```kotlin
val customName: String
```

## ai.koog.agents.core.tools.annotations.Tool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.annotations/-tool/index.html`

### :agents:agents-tools/commonMain

```kotlin
@Target(allowedTargets = [AnnotationTarget.FUNCTION]) annotation class Tool(val customName: String = "")
```

Annotation for tools to be collected by reflection from an object.

## ai.koog.agents.core.tools.reflect.ToolSet.asTools

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-set/as-tools.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
open fun asTools(): List<ToolFromCallable<*>>
```

Converts all instance methods marked as Tool to a list of tools.

See asTool for detailed description.

## ai.koog.agents.core.tools.reflect.ToolSet.getTool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-set/get-tool.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
open fun getTool(name: String): ToolFromCallable<*>
```

Retrieves a tool by its name from the toolset. If the tool is not found, an exception is thrown.

- name — The name of the tool to retrieve.
- IllegalStateException — If no tool with the specified name is found.
## ai.koog.agents.core.tools.reflect.ToolSet

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-set/index.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
interface ToolSet
```

A marker interface for a set of tools that can be converted to a list of tools via reflection.

## ai.koog.agents.core.tools.reflect.ToolSet.name

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/-tool-set/name.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
open val name: String
```

Retrieves the description of the current class or object from the LLMDescription annotation. If the annotation is not present, defaults to the JVM name of the class.

This property is typically used to provide human-readable descriptions of toolsets or entities for integration with large language models (LLMs).

## ai.koog.agents.core.tools.reflect.asTool

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/as-tool.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
fun <R> KFunction<R>.asTool(thisRef: Any? = null, name: String? = null, description: String? = null): ToolFromCallable<R>
```

Converts KFunction to ToolFromCallable.

The function can be annotated with Tool annotation where the name of the tool can be overridden. If the custom name is not provided, the name of the function is used.

The function can be annotated with LLMDescription annotation to provide a description of the tool. If not provided, the name of the function is used as a description.

The callable parameters can be annotated with LLMDescription annotation to provide a description of the parameter. If not provided, the name of the parameter is used.

If the function is a method that overrides or implements another method from a base class or an interface, Tool annotation can be extracted from one of the base methods in the case when it's missing on this method. In this case LLMDescription` annotation will be also extracted from the base method where Tool annotation was found.

Both suspend and non-suspend functions are supported

Default parameters are supported (calling site can omit them in the argument Json)

- thisRef — The object instance to use as the 'this' object for the callable.
- name — The name of the tool. If not provided, the name will be obtained from Tool.customName property. In the case of the missing attribute or empty name the name of the function is used.
- description — The description of the tool. If not provided, the description will be obtained from LLMDescription.description property. In the case of the missing attribute or empty description the name of the function is used as a description.
## ai.koog.agents.core.tools.reflect.asToolsByClass

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/as-tools-by-class.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
inline fun <T : Any> T.asToolsByClass(): List<ToolFromCallable<*>>
```

Converts all instance methods of class/interface T marked as Tool to a list of tools that will be called on object this.

See asTool for detailed description.

## ai.koog.agents.core.tools.reflect.asTools

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.reflect/as-tools.html`

### :agents:agents-tools/jvmCommonMain

```kotlin
fun <T : Any> KClass<out T>.asTools(thisRef: T? = null): List<ToolFromCallable<*>>
```

Converts all functions of this class marked with Tool annotation to a list of tools.

- thisRef — an instance of this class to be used as the 'this' object for the callable in the case of instance methods.
- asTool
## ai.koog.agents.core.tools.schema.ToolParameterInfo.ToolParameterInfo

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/-tool-parameter-info/-tool-parameter-info.html`

### :agents:agents-tools/commonMain

```kotlin
constructor(type: ToolParameterType, description: String)
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.schema.ToolParameterInfo.description

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/-tool-parameter-info/description.html`

### :agents:agents-tools/commonMain

```kotlin
val description: String
```

## ai.koog.agents.core.tools.schema.ToolParameterInfo

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/-tool-parameter-info/index.html`

### :agents:agents-tools/commonMain

```kotlin
class ToolParameterInfo(val type: ToolParameterType, val description: String)
```

Helper class holding information about the ToolParameterType along with its optional description.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.schema.ToolParameterInfo.type

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/-tool-parameter-info/type.html`

### :agents:agents-tools/commonMain

```kotlin
val type: ToolParameterType
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.schema.defaultJsonSchemaConfig

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/default-json-schema-config.html`

### :agents:agents-tools/commonMain

```kotlin
val defaultJsonSchemaConfig: JsonSchemaConfig
```

## ai.koog.agents.core.tools.schema.getJsonSchema

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/get-json-schema.html`

### :agents:agents-tools/commonMain

```kotlin
expect fun getJsonSchema(typeToken: TypeToken, jsonSchemaConfig: JsonSchemaConfig = defaultJsonSchemaConfig): JsonSchema
```


Referenced packages: `ai.koog.serialization`.

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual fun getJsonSchema(typeToken: ERROR CLASS: Symbol not found for TypeToken, jsonSchemaConfig: ERROR CLASS: Symbol not found for JsonSchemaConfig): ERROR CLASS: Symbol not found for JsonSchema
```

### :agents:agents-tools/nonJvmCommonMain

```kotlin
actual fun getJsonSchema(typeToken: TypeToken, jsonSchemaConfig: JsonSchemaConfig): JsonSchema
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.tools.schema.getToolDescriptor

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/get-tool-descriptor.html`

### :agents:agents-tools/commonMain

```kotlin
fun getToolDescriptor(argsType: TypeToken, toolName: String, toolDescription: String? = null, jsonSchemaConfig: JsonSchemaConfig = defaultJsonSchemaConfig): ToolDescriptor
```

Generates a ToolDescriptor by generating and converting the JSON schema for the type defined by the provided argsType

- argsType — Type token representing arguments type.
- toolName — Name of the tool.
- toolDescription — Optional custom description. If not provided, the description will be obtained from the generated JSON schema for the argsType
- jsonSchemaConfig — Optional custom JsonSchemaConfig for the JSON schema generation.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

### :agents:agents-tools/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun getToolDescriptor(callable: KCallable<*>, toolName: String? = null, toolDescription: String? = null, jsonSchemaConfig: ERROR CLASS: Symbol not found for JsonSchemaConfig = defaultJsonSchemaConfig): ToolDescriptor
```

Generates a ToolDescriptor by generating and converting the function calling schema for the provided callable

- callable — The callable to generate the schema for.
- toolName — Optional custom name. If not provided, KCallable.name will be used.
- toolDescription — Optional custom description. If not provided, ai.koog.agents.core.tools.annotations.LLMDescription.description will be used if the callable is annotated with it.
- jsonSchemaConfig — Optional custom JsonSchemaConfig for the JSON schema generation.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.schema.toToolParameter

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.schema/to-tool-parameter.html`

### :agents:agents-tools/commonMain

```kotlin
fun PropertyDefinition.toToolParameter(defs: Map<String, PropertyDefinition>?): ToolParameterInfo
```

Converts a JSON schema property representation PropertyDefinition to ToolParameterInfo, containing our tool parameter representation ToolParameterType along with its optional description.

- defs — JSON schema definitions map for resolving references.
## ai.koog.agents.core.tools.serialization.ToolDescriptorSchemaGenerator.generate

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.serialization/-tool-descriptor-schema-generator/generate.html`

### :agents:agents-tools/commonMain

```kotlin
abstract fun generate(toolDescriptor: ToolDescriptor): JsonObject
```

Converts a list of ToolDescriptor objects into a JSON object representation.

A JsonObject containing the JSON representation of the provided list of ToolDescriptor objects.

- toolDescriptor — The ToolDescriptor to convert.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.tools.serialization.ToolDescriptorSchemaGenerator

Module: `agents-tools`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-tools/ai.koog.agents.core.tools.serialization/-tool-descriptor-schema-generator/index.html`

### :agents:agents-tools/commonMain

```kotlin
interface ToolDescriptorSchemaGenerator
```

Interface for converting a list of ToolDescriptor objects to a JSON schema representation.
