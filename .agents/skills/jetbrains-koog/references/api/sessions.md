# LLM sessions and functional context

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContext.AIAgentFunctionalContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context/-a-i-agent-functional-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(environment: AIAgentEnvironment, agentId: String, runId: String, agentInput: Any?, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, strategyName: String, pipeline: AIAgentFunctionalPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentContext? = null)
```

- environment — The AIAgentEnvironment in which the AI agent operates, facilitating interaction with the external environment for tool execution and error reporting.
- agentId — A unique identifier for the agent, used to distinguish it from other agents.
- runId — An identifier representing the execution run of the agent, useful for tracking and managing runs.
- agentInput — The input data provided to the agent, which can guide its execution or decision-making process.
- config — The AIAgentConfig object containing configuration information for the agent, such as behavior settings.
- llm — The AIAgentLLMContext providing access to the large language model interactions for generating outputs.
- stateManager — The AIAgentStateManager responsible for managing and persisting the state of the agent during its lifecycle.
- storage — The AIAgentStorage interface facilitating storage and retrieval of data in the agent's environment.
- strategyName — The name of the strategic approach or plan under which the agent is functioning.
- pipeline — The AIAgentFunctionalPipeline defining the functional execution flow of the agent's operations.
- executionInfo — The AgentExecutionInfo containing metadata and runtime information about the agent's current execution.
- parentContext — An optional reference to the parent AIAgentContext, enabling hierarchical context structure if needed.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentFunctionalContext(environment: AIAgentEnvironment, agentId: String, runId: String, agentInput: Any?, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, strategyName: String, pipeline: AIAgentFunctionalPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentContext? = null) : AIAgentFunctionalContextBase<AIAgentFunctionalPipeline>
```

Represents the context for an AI agent of FunctionalAIAgent type, serving as the execution environment and state holder while an agent operates within a predefined pipeline. It extends AIAgentFunctionalContextBase and is designed to allow configuration, state management, and storage for an agent's functional operations.

- environment — The AIAgentEnvironment in which the AI agent operates, facilitating interaction with the external environment for tool execution and error reporting.
- agentId — A unique identifier for the agent, used to distinguish it from other agents.
- runId — An identifier representing the execution run of the agent, useful for tracking and managing runs.
- agentInput — The input data provided to the agent, which can guide its execution or decision-making process.
- config — The AIAgentConfig object containing configuration information for the agent, such as behavior settings.
- llm — The AIAgentLLMContext providing access to the large language model interactions for generating outputs.
- stateManager — The AIAgentStateManager responsible for managing and persisting the state of the agent during its lifecycle.
- storage — The AIAgentStorage interface facilitating storage and retrieval of data in the agent's environment.
- strategyName — The name of the strategic approach or plan under which the agent is functioning.
- pipeline — The AIAgentFunctionalPipeline defining the functional execution flow of the agent's operations.
- executionInfo — The AgentExecutionInfo containing metadata and runtime information about the agent's current execution.
- parentContext — An optional reference to the parent AIAgentContext, enabling hierarchical context structure if needed.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/agent-id.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun agentId(): String
```

Retrieves the unique identifier for the agent.

A string representing the agent's unique identifier.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.agentInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/agent-input.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun agentInput(): Any?
```

Retrieves the current agent input.

The agent input as an Any? type, which may be null if no input is available.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/config.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun config(): AIAgentConfig
```

Provides the configuration for an AI agent.

An instance of AIAgentConfig representing the current AI agent configuration.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.environment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/environment.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun environment(): AIAgentEnvironment
```

Retrieves the current AI agent environment.

The AIAgentEnvironment instance representing the current environment.


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/execution-info.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun executionInfo(): AgentExecutionInfo
```

Retrieves the execution information of the agent.

an instance of AgentExecutionInfo containing details about the execution context.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/index.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract class AIAgentFunctionalContextBase<Pipeline : AIAgentPipeline> : AIAgentFunctionalContextBaseCommon<Pipeline>
```

Base class for functional/planner context implementations across all targets.

It inherits all shared behavior from AIAgentFunctionalContextBaseCommon.

- AIAgentFunctionalContext
- AIAgentPlannerContext

Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract class AIAgentFunctionalContextBase<Pipeline : AIAgentPipeline> : AIAgentFunctionalContextBaseCommon<Pipeline>
```

Base class for functional/planner context implementations across all targets.

It inherits all shared behavior from AIAgentFunctionalContextBaseCommon.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract class AIAgentFunctionalContextBase<Pipeline : AIAgentPipeline> : AIAgentFunctionalContextBaseCommon<Pipeline>
```

Base class for functional/planner context implementations across all targets.

It inherits all shared behavior from AIAgentFunctionalContextBaseCommon.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.llm

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/llm.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun llm(): AIAgentLLMContext
```

Returns the current instance of AIAgentLLMContext.

The AIAgentLLMContext instance.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/pipeline.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun pipeline(): Pipeline
```

Builds and returns an instance of the AIAgentFunctionalPipeline.

An instance of AIAgentFunctionalPipeline representing the constructed pipeline.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.requestLLMStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/request-l-l-m-structured.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
suspend fun <T : Any> requestLLMStructured(message: String, clazz: KClass<T>, examples: List<T> = emptyList(), fixingParser: ERROR CLASS: Symbol not found for StructureFixingParser?? = null): ERROR CLASS: Symbol not found for Result<ERROR CLASS: Symbol not found for StructuredResponse<T>>
```

Sends a structured request to the Large Language Model (LLM) and processes the response.

A Result containing a StructuredResponse of the requested type T, or an error if the request fails.

- message — The input message to be sent to the LLM.
- clazz — The Kotlin class type of the expected structured response.
- examples — An optional list of example objects used to guide the model's structured response generation.
- fixingParser — An optional parser to correct or validate the structured response.
- T — The type of the structured response required.
## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/run-id.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun runId(): String
```

Retrieves the current run identifier.

the run identifier as a string.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.stateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/state-manager.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun stateManager(): AIAgentStateManager
```

Provides an instance of AIAgentStateManager responsible for managing the state of an AI Agent. This function allows access to the state management operations for coordinating AI agent behavior.

the AIAgentStateManager instance.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/storage.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun storage(): AIAgentStorage
```

Provides access to the AIAgentStorage instance.

the AIAgentStorage instance used for managing AI agent-related data.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/strategy-name.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun strategyName(): String
```

Retrieves the name of the strategy.

the name of the strategy as a string.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBase.subtask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base/subtask.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun subtask(taskDescription: String): SubtaskBuilder
```

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentId: String
```

A unique identifier representing the current agent instance within the context.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.agentInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/agent-input.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentInput: Any?
```

Represents the input provided to the agent's execution.

This variable provides access to the agent's input, which can be used to determine the agent's intent, context, or other relevant information at any stage of agents execution.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.appendPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/append-prompt.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun appendPrompt(body: PromptBuilder.() -> Unit)
```

Appends messages to the current LLM prompt without making an LLM request. Corresponds to nodeAppendPrompt.

- body — Lambda to modify the prompt using PromptBuilder.

Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.compressHistory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/compress-history.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun compressHistory(strategy: HistoryCompressionStrategy = HistoryCompressionStrategy.WholeHistory, preserveMemory: Boolean = true)
```

Compresses the current LLM prompt (message history) into a summary, replacing messages with a TLDR.

- strategy — Determines which messages to include in compression.
- preserveMemory — Specifies whether to retain message memory after compression.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/config.html`

### :agents:agents-core/commonMain

```kotlin
open override val config: AIAgentConfig
```

Represents the configuration for an AI agent.

This configuration is used during the execution to enforce constraints such as the maximum number of iterations an agent can perform, as well as providing the agent's prompt configuration.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.environment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/environment.html`

### :agents:agents-core/commonMain

```kotlin
open override val environment: AIAgentEnvironment
```

Represents the environment in which the agent operates.

This variable provides access to essential functionalities for the agent's execution, including interaction with tools, error reporting, and sending termination signals. It is used throughout the agent's lifecycle to facilitate actions and handle outcomes.


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.executeSingleTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/execute-single-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <ToolArg, TResult> executeSingleTool(tool: Tool<ToolArg, TResult>, toolArgs: ToolArg, doUpdatePrompt: Boolean = true): SafeTool.Result<TResult>
```

Calls a specific tool directly using the provided arguments.

The result of the tool execution.

- tool — The tool to execute.
- toolArgs — The arguments to pass to the tool.
- doUpdatePrompt — Specifies whether to add tool call details to the prompt.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.executeTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/execute-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun executeTool(toolCall: MessagePart.Tool.Call): ReceivedToolResult
```

Executes a tool call and returns the result.

The result of the tool execution.

- toolCall — The tool call to execute.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.executeTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/execute-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun executeTools(toolCalls: List<MessagePart.Tool.Call>, parallelTools: Boolean = false): List<ReceivedToolResult>
```

Executes multiple tool calls and returns their results. These calls can optionally be executed in parallel.

A list of results from the executed tool calls.

- toolCalls — The list of tool calls to execute.
- parallelTools — Specifies whether tools should be executed in parallel.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
suspend fun executeTools(message: Message.Assistant, parallelTools: Boolean = false): List<ReceivedToolResult>
```

Executes all tool calls from a Message.Assistant and returns their results. Corresponds to nodeExecuteToolsAndGetReceivedResults.

- message — The assistant message containing tool calls to execute.
- parallelTools — Whether to execute tools in parallel.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override var executionInfo: AgentExecutionInfo
```

Represents the observability data associated with the AI Agent context.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.getTextParts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/get-text-parts.html`

### :agents:agents-core/commonMain

```kotlin
fun getTextParts(response: Message.Assistant): List<MessagePart.Text>
```

Extracts a list of tool call messages from a given list of response messages.

A list of messages specifically representing tool calls, which are instances of MessagePart.Tool.Call.

- response — A list of response messages to filter, potentially containing various types of responses.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.getToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/get-tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
fun getToolCalls(response: Message.Assistant): List<MessagePart.Tool.Call>
```

Extracts a list of tool call messages from a given list of response messages.

A list of messages specifically representing tool calls, which are instances of MessagePart.Tool.Call.

- response — A list of response messages to filter, potentially containing various types of responses.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/index.html`

### :agents:agents-core/commonMain

```kotlin
open class AIAgentFunctionalContextBaseCommon<Pipeline : AIAgentPipeline> : AIAgentContext
```

Base AIAgentContext implementation providing functionality common across platforms

- AIAgentFunctionalContextBase

Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.latestTokenUsage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/latest-token-usage.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun latestTokenUsage(): Int
```

Retrieves the latest token usage from the prompt within the LLM session.

The latest token usage information as an integer.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.llm

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/llm.html`

### :agents:agents-core/commonMain

```kotlin
open override val llm: AIAgentLLMContext
```

Represents the AI agent's LLM context, providing mechanisms for managing tools, prompts, and interaction with the execution environment. It ensures thread safety during concurrent read and write operations through the use of sessions.

This context plays a foundational role in defining and manipulating tools, prompt execution, and overall behavior the agent's lifecycle.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.moderateMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/moderate-message.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun moderateMessage(message: Message, moderatingModel: LLModel? = null, includeCurrentPrompt: Boolean = false): ModerationResult
```

Moderates a message using the LLM. Corresponds to nodeLLMModerateMessage.

- message — The message to moderate.
- moderatingModel — Optional model to use for moderation instead of the current one.
- includeCurrentPrompt — Whether to include the current conversation prompt in the moderation context.

Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.onTextMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/on-text-message.html`

### :agents:agents-core/commonMain

```kotlin
fun onTextMessage(response: Message.Assistant, action: (List<MessagePart.Text>) -> Unit)
```

Executes the provided action if the given response is of type Message.Assistant.

- response — The response message to evaluate, which may or may not be of type Message.Assistant.
- action — A lambda function to execute if the response is an instance of Message.Assistant.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.onToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/on-tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
fun onToolCalls(response: Message.Assistant, action: (List<MessagePart.Tool.Call>) -> Unit)
```

Invokes the provided action when multiple tool call messages are found within a given list of response messages. Filters the list of responses to include only instances of MessagePart.Tool.Call and executes the action on the filtered list if it is not empty.

- response — A list of response messages to be checked for tool call messages.
- action — A lambda function to be executed with the list of filtered tool call messages, if any exist.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.parentContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/parent-context.html`

### :agents:agents-core/commonMain

```kotlin
open override val parentContext: AIAgentContext?
```

Represents the parent context of the AI Agent.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
open override val pipeline: Pipeline
```

Represents the pipeline associated with the AI agent.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLMForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMForceOneTool(message: String, tool: ToolDescriptor): Message.Assistant
```

Sends a message to a Large Language Model (LLM) and forces it to use a specific tool. The message becomes part of the current prompt, and the LLM is instructed to use only the specified tool.

The LLM response containing the tool call.

- message — The content of the message to be sent to the LLM.
- tool — The tool descriptor that the LLM must use.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMForceOneTool(message: String, tool: Tool<*, *>): Message.Assistant
```

Sends a message to a Large Language Model (LLM) and forces it to use a specific tool. The message becomes part of the current prompt, and the LLM is instructed to use only the specified tool.

The LLM response containing the tool call.

- message — The content of the message to be sent to the LLM.
- tool — The tool that the LLM must use.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLMMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMMultipleChoices(message: String): LLMChoice
```

Sends a string message to the LLM and returns multiple response choices. Corresponds to nodeLLMRequestMultipleChoicesWithUserText.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLMOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMOnlyCallingTools(message: String): Message.Assistant
```

Sends a string message to the LLM without tool calls. Corresponds to nodeLLMRequestOnlyCallingToolsWithUserText.

- message — The content of the message to be sent to the LLM.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLMStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m-streaming.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMStreaming(message: String, structureDefinition: StructureDefinition? = null): Flow<StreamFrame>
```

Sends a message to a Large Language Model (LLM) and streams the LLM response. The message becomes part of the current prompt, and the LLM's response is streamed as it's generated.

A flow of StreamFrame objects from the LLM response.

- message — The content of the message to be sent to the LLM.
- structureDefinition — Optional structure to guide the LLM response.

Referenced packages: `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLMStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m-structured.html`

### :agents:agents-core/commonMain

```kotlin
inline suspend fun <T> requestLLMStructured(message: String, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Sends a structured request to the Large Language Model (LLM) and processes the response.

A Result containing a StructuredResponse of the requested type.

- message — The input message to be sent to the LLM.
- examples — An optional list of example objects used to guide the model's structured response generation.
- fixingParser — An optional parser to correct or validate the structured response.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> requestLLMStructured(message: String, config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Sends a string message to the LLM and returns a structured response using a StructuredRequestConfig. Corresponds to nodeLLMRequestStructuredWithUserText.


Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLMWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMWithoutTools(message: String): Message.Assistant
```

Sends a string message to the LLM without tool calls. Corresponds to nodeLLMRequestWithoutToolsWithUserText.

- message — The content of the message to be sent to the LLM.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.requestLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/request-l-l-m.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLM(message: String): Message.Assistant
```

Sends a message to a Large Language Model (LLM) and optionally allows the use of tools during the LLM interaction. The message becomes part of the current prompt, and the LLM's response is processed accordingly, either with or without tool integrations based on the provided parameters. Corresponds to nodeLLMRequestWithUserText.

- message — The content of the message to be sent to the LLM.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

A unique identifier for the current session associated with the AI agent context. Used to track and differentiate sessions within the execution of the agent pipeline.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.sendToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/send-tool-result.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun sendToolResult(toolResult: ReceivedToolResult): Message.Assistant
```

Adds a tool result to the prompt and requests an LLM response.

The LLM response.

- toolResult — The tool result to add to the prompt.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.sendToolResultsForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/send-tool-results-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun sendToolResultsForceOneTool(results: List<ReceivedToolResult>, tool: ToolDescriptor): Message.Assistant
```

Sends tool results to the LLM and forces it to use a specific tool. Corresponds to nodeSendToolReceivedResultsForceOneTool.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.sendToolResultsMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/send-tool-results-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun sendToolResultsMultipleChoices(results: List<ReceivedToolResult>): LLMChoice
```

Sends tool results to the LLM and returns multiple response choices. Corresponds to nodeSendToolReceivedResultsMultipleChoices.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.sendToolResultsOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/send-tool-results-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun sendToolResultsOnlyCallingTools(results: List<ReceivedToolResult>): Message.Assistant
```

Sends tool results to the LLM, restricting it to only calling tools. Corresponds to nodeSendToolReceivedResultsOnlyCallingTools.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.sendToolResultsWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/send-tool-results-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun sendToolResultsWithoutTools(results: List<ReceivedToolResult>): Message.Assistant
```

Sends tool results to the LLM without allowing further tool calls. Corresponds to nodeSendToolReceivedResultsWithoutTools.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.sendToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/send-tool-results.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun sendToolResults(results: List<ReceivedToolResult>): Message.Assistant
```

Adds multiple tool results to the prompt and gets multiple LLM responses.

A list of LLM responses.

- results — The list of tool results to add to the prompt.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.stateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/state-manager.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateManager: AIAgentStateManager
```

Manages and tracks the state of an AI agent within the context of its execution.

This variable provides synchronized access to the agent's state to ensure thread safety and consistent state transitions during concurrent operations. It acts as a central mechanism for managing state updates and validations across different nodes and subgraphs of the AI agent's execution flow.

The stateManager is utilized extensively in coordinating state changes, such as tracking the number of iterations made by the agent and enforcing execution limits or conditions. This aids in maintaining predictable and controlled behavior of the agent during execution.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/storage.html`

### :agents:agents-core/commonMain

```kotlin
open override val storage: AIAgentStorage
```

Concurrent-safe key-value storage for an agent, used to manage and persist data within the context of the AI agent stage execution. The storage property provides a thread-safe mechanism for sharing and storing data specific to the agent's operation.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategyName: String
```

Represents the name of the strategy being used in the current AI agent context.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.subtaskWithVerification

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/subtask-with-verification.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun subtaskWithVerification(taskDescription: String, tools: List<ToolBase<*, *>>? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null): CriticResult<String>
```

Executes a subtask with validation and verification of the results. The method defines a subtask for the AI agent using the provided input and additional parameters and ensures that the output is evaluated based on its correctness and feedback.

A CriticResult object containing the verification status, feedback, and the original input for the subtask.

- taskDescription — The subtask to be executed by AIAgent.
- tools — An optional list of tools that can be used during the execution of the subtask.
- llmModel — An optional parameter specifying the LLM model to be used for the subtask.
- llmParams — Optional configuration parameters for the LLM, such as temperature and token limits.
- parallelTools — The mode in which tools should be executed, either sequentially or in parallel.
- assistantResponseRepeatMax — An optional parameter specifying the maximum number of retries for getting valid assistant responses.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.agents.ext.agent`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContextBaseCommon.subtask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context-base-common/subtask.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <Output : Any> subtask(taskDescription: String, outputClass: KClass<Output>, tools: List<ToolBase<*, *>>? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null): Output
```

Executes a subtask within the larger context of an AI agent's functional operation. This method allows defining a specific task to be performed with the given input, tools, and optional configuration.

The result of the subtask execution.

- taskDescription — The subtask to be executed by AIAgent.
- outputClass — The output type expected from the subtask.
- tools — A list of tools available for use within the subtask.
- llmModel — The optional large language model to be used during the subtask, if different from the default one.
- llmParams — The configuration parameters for the large language model, such as temperature.
- parallelTools — The mode in which tools should be executed, either sequentially or in parallel.
- assistantResponseRepeatMax — The maximum number of times the assistant response can repeat.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
suspend fun <OutputTransformed> subtask(taskDescription: String, tools: List<ToolBase<*, *>>? = null, finishTool: Tool<*, OutputTransformed>, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null): OutputTransformed
```

Executes a subtask within the AI agent's functional context. This method enables the use of tools to achieve a specific task based on the input provided.

The transformed final result of executing the finishing tool to complete the subtask.

- taskDescription — The subtask to be executed by AIAgent.
- tools — An optional list of tools that can be used to achieve the task, excluding the finishing tool.
- finishTool — A mandatory tool that determines the final result of the subtask by producing and transforming output.
- llmModel — An optional specific LLM to use for executing the subtask.
- llmParams — Optional parameters for configuring the behavior of the LLM during subtask execution.
- parallelTools — The mode in which tools should be executed, either sequentially or in parallel.
- assistantResponseRepeatMax — The maximum number of feedback attempts allowed from the language model if the subtask is not completed.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
inline suspend fun <Output : Any> subtask(taskDescription: String, tools: List<ToolBase<*, *>>? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null): Output
```

Executes a subtask within the larger context of an AI agent's functional operation. This method allows defining a specific task to be performed with the given input, tools, and optional configuration.

The result of the subtask execution.

- taskDescription — The subtask to be executed by AIAgent.
- tools — A list of tools available for use within the subtask.
- llmModel — The optional large language model to be used during the subtask, if different from the default one.
- llmParams — The configuration parameters for the large language model, such as temperature.
- parallelTools — The mode in which tools should be executed, either sequentially or in parallel.
- assistantResponseRepeatMax — The maximum number of times the assistant response can repeat.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.context.AIAgentLLMContext.AIAgentLLMContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context/-a-i-agent-l-l-m-context.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(tools: List<ToolDescriptor>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, prompt: Prompt, model: LLModel, responseProcessor: ResponseProcessor?, promptExecutor: PromptExecutor, environment: AIAgentEnvironment, config: AIAgentConfig, clock: KoogClock)
```

- tools — A list of tools described by ToolDescriptor that the agent can interact with.
- toolRegistry — A registry of available tools, defaulting to an empty ToolRegistry.
- prompt — The initial prompt used in the context, represented by a Prompt instance.
- model — The language model used for processing prompts and generating responses.
- responseProcessor — An optional ResponseProcessor for handling and processing model responses.
- promptExecutor — Responsible for executing the logic for prompt processing in the context.
- environment — The operational environment of the AI agent, represented by an AIAgentEnvironment.
- config — Configuration settings for the AI agent, encapsulated in an AIAgentConfig.
- clock — A clock instance for managing time-related operations within the context.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(tools: List<ERROR CLASS: Symbol not found for ToolDescriptor>, toolRegistry: ERROR CLASS: Symbol not found for ToolRegistry, prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, promptExecutor: ERROR CLASS: Symbol not found for PromptExecutor, environment: AIAgentEnvironment, config: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(tools: List<ToolDescriptor>, toolRegistry: ToolRegistry, prompt: Prompt, model: LLModel, responseProcessor: ResponseProcessor?, promptExecutor: PromptExecutor, environment: AIAgentEnvironment, config: AIAgentConfig, clock: KoogClock)
```

- tools — A list of tools described by ToolDescriptor that the agent can interact with.
- toolRegistry — A registry of available tools, defaulting to an empty ToolRegistry.
- prompt — The initial prompt used in the context, represented by a Prompt instance.
- model — The language model used for processing prompts and generating responses.
- responseProcessor — An optional ResponseProcessor for handling and processing model responses.
- promptExecutor — Responsible for executing the logic for prompt processing in the context.
- environment — The operational environment of the AI agent, represented by an AIAgentEnvironment.
- config — Configuration settings for the AI agent, encapsulated in an AIAgentConfig.
- clock — A clock instance for managing time-related operations within the context.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.context.AIAgentLLMContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context/index.html`

### :agents:agents-core/commonMain

```kotlin
expect open class AIAgentLLMContext : AIAgentLLMContextCommon
```

Represents the context for an AI agent LLM, managing tools, prompt handling, and interaction with the environment and execution layers. It provides mechanisms for concurrent read and write operations through sessions, ensuring thread safety.

It inherits all shared behavior from AIAgentLLMContextCommon.

Constructs a new instance of AIAgentLLMContext with the provided parameters.

- tools — A list of tools described by ToolDescriptor that the agent can interact with.
- toolRegistry — A registry of available tools, defaulting to an empty ToolRegistry.
- prompt — The initial prompt used in the context, represented by a Prompt instance.
- model — The language model used for processing prompts and generating responses.
- responseProcessor — An optional ResponseProcessor for handling and processing model responses.
- promptExecutor — Responsible for executing the logic for prompt processing in the context.
- environment — The operational environment of the AI agent, represented by an AIAgentEnvironment.
- config — Configuration settings for the AI agent, encapsulated in an AIAgentConfig.
- clock — A clock instance for managing time-related operations within the context.
### :agents:agents-core/jvmCommonMain

```kotlin
actual open class AIAgentLLMContext : AIAgentLLMContextCommon
```

Represents the context for an AI agent LLM, managing tools, prompt handling, and interaction with the environment and execution layers. It provides mechanisms for concurrent read and write operations through sessions, ensuring thread safety.

It inherits all shared behavior from AIAgentLLMContextCommon.

Constructs a new instance of AIAgentLLMContext with the provided parameters.

- tools — A list of tools described by ToolDescriptor that the agent can interact with.
- toolRegistry — A registry of available tools, defaulting to an empty ToolRegistry.
- prompt — The initial prompt used in the context, represented by a Prompt instance.
- model — The language model used for processing prompts and generating responses.
- responseProcessor — An optional ResponseProcessor for handling and processing model responses.
- promptExecutor — Responsible for executing the logic for prompt processing in the context.
- environment — The operational environment of the AI agent, represented by an AIAgentEnvironment.
- config — Configuration settings for the AI agent, encapsulated in an AIAgentConfig.
- clock — A clock instance for managing time-related operations within the context.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open class AIAgentLLMContext : AIAgentLLMContextCommon
```

Represents the context for an AI agent LLM, managing tools, prompt handling, and interaction with the environment and execution layers. It provides mechanisms for concurrent read and write operations through sessions, ensuring thread safety.

It inherits all shared behavior from AIAgentLLMContextCommon.

Constructs a new instance of AIAgentLLMContext with the provided parameters.

- tools — A list of tools described by ToolDescriptor that the agent can interact with.
- toolRegistry — A registry of available tools, defaulting to an empty ToolRegistry.
- prompt — The initial prompt used in the context, represented by a Prompt instance.
- model — The language model used for processing prompts and generating responses.
- responseProcessor — An optional ResponseProcessor for handling and processing model responses.
- promptExecutor — Responsible for executing the logic for prompt processing in the context.
- environment — The operational environment of the AI agent, represented by an AIAgentEnvironment.
- config — Configuration settings for the AI agent, encapsulated in an AIAgentConfig.
- clock — A clock instance for managing time-related operations within the context.
## ai.koog.agents.core.agent.context.AIAgentLLMContext.readSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context/read-session.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <T> readSession(block: Function<AIAgentLLMReadSession, T>): T
```

Executes a read-only session within the context of AIAgentLLMReadSession and returns the result of the provided block.

The result of executing the provided block within the AIAgentLLMReadSession context.

- block — A function that performs actions within the AIAgentLLMReadSession and computes a result of type T.

Referenced packages: `ai.koog.agents.core.agent.session`.

## ai.koog.agents.core.agent.context.AIAgentLLMContext.writeSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context/write-session.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <T> writeSession(block: Function<AIAgentLLMWriteSession, T>): T
```

Executes a block of code within a write session for the AI Agent LLM context.

This function provides a mechanism to modify or interact with the AI Agent's state in a mutable manner, ensuring proper synchronization and execution within the main dispatcher.

The result produced by the provided block of code.

- block — A function that takes an instance of AIAgentLLMWriteSession as its receiver and performs operations on it. The result of this block is the return value of the enclosing function.
- T — The return type of the operation performed within the write session.

Referenced packages: `ai.koog.agents.core.agent.session`.

## ai.koog.agents.core.agent.context.AIAgentLLMContextCommon

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context-common/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentLLMContextCommon
```

Common AIAgentLLMContext implementation shared across platforms.

- AIAgentLLMContext
## ai.koog.agents.core.agent.context.AIAgentLLMContextCommon.readSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context-common/read-session.html`

### :agents:agents-core/commonMain

```kotlin
open suspend fun <T> readSession(block: suspend AIAgentLLMReadSession.() -> T): T
```

Executes a read session on the AIAgentLLMContext. Multiple read sessions may run concurrently, while any concurrent writeSession or withPrompt is serialized against them.

Concurrency caveats:

The underlying lock is not reentrant for writers: nested readSession calls from the same coroutine are safe, but calling writeSession or withPrompt from inside a readSession will deadlock (see RWLock).

Mutations performed on fields exposed through the session are not persisted back to this context (unlike writeSession).


Referenced packages: `ai.koog.agents.core.agent.session`.

## ai.koog.agents.core.agent.context.AIAgentLLMContextCommon.withPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context-common/with-prompt.html`

### :agents:agents-core/commonMain

```kotlin
open suspend fun withPrompt(block: Prompt.() -> Prompt)
```

Atomically replaces prompt with the result of applying block to the current prompt while holding the internal write lock. Callers waiting for read or write access will be suspended until the transformation completes.

Concurrency warnings:

Must not be invoked from inside another withPrompt, writeSession, or readSession on the same context — the underlying lock is not reentrant and doing so will deadlock (see RWLock).

block should be a pure, fast transformation; it runs while holding the write lock and will block all concurrent readers and writers until it returns.

- block — transformation to produce the next Prompt.

Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.context.AIAgentLLMContextCommon.writeSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context-common/write-session.html`

### :agents:agents-core/commonMain

```kotlin
open suspend fun <T> writeSession(block: suspend AIAgentLLMWriteSession.() -> T): T
```

Executes a write session on the AIAgentLLMContext, suspending until all other active write and read sessions on this context complete, then running block under exclusive access. At the end of the session, prompt, tools and model are overwritten with the values mutated inside the session.

Concurrency caveats:

The underlying lock is not reentrant. Do not call writeSession, readSession, withPrompt or copy on the same context from inside block — doing so will deadlock (see RWLock).

block runs while holding the write lock; keep it as short as possible and avoid launching long-running child coroutines that need to re-acquire this lock.

Cancellation inside block is propagated; partial mutations made on the session before cancellation will not be committed to the outer context.


Referenced packages: `ai.koog.agents.core.agent.session`.

## ai.koog.agents.core.agent.context.SubtaskBuilder.SubtaskBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/-subtask-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(context: AIAgentFunctionalContextBase<*>, taskDescription: String)
```

Initializes the SubtaskBuilder with a specific AI agent functional context and a description of the task.

- context — The functional context associated with the AI agent, providing the necessary environment for the subtask.
- taskDescription — A textual description of the task to be handled by the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilder.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/context.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val context: AIAgentFunctionalContextBase<*>
```

- context — The functional context associated with the AI agent, providing the necessary environment for the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class SubtaskBuilder(val context: AIAgentFunctionalContextBase<*>, val taskDescription: String)
```

A builder class responsible for creating and managing subtasks within the context of an AI agent's functional operations.

- context — The functional context associated with the AI agent, providing the necessary environment for the subtask.
- taskDescription — A textual description of the task to be handled by the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilder.taskDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/task-description.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val taskDescription: String
```

- taskDescription — A textual description of the task to be handled by the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilder.withFinishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/with-finish-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <Output : Any> withFinishTool(finishTool: ERROR CLASS: Symbol not found for Tool<*, Output>): SubtaskBuilderWithOutput<Output>
```

Associates a finishing tool with the subtask builder, allowing the subtask to produce an output of the specified type.

- finishTool — The tool that defines how the subtask's output will be produced and processed.
## ai.koog.agents.core.agent.context.SubtaskBuilder.withOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/with-output.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Output : Any> withOutput(outputClass: Class<Output>): SubtaskBuilderWithOutput<Output>
```

Specifies the output type for a subtask to be built.

- outputClass — The class representing the type of the output for the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilder.withVerification

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder/with-verification.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withVerification(): SubtaskBuilderWithOutput<CriticResult<String>>
```

Configures the subtask builder to include a verification step in the task pipeline.


Referenced packages: `ai.koog.agents.ext.agent`.

## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.SubtaskBuilderWithOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/-subtask-builder-with-output.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(context: AIAgentFunctionalContextBase<*>, taskDescription: String, output: OutputOption<Output>, tools: List<ERROR CLASS: Symbol not found for ToolBase<*, *>>? = null, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null)
```

- context — The functional context associated with the AI agent.
- taskDescription — The description of the task that this subtask represents.
- output — Specifies the output of the subtask either by its class or through a finish tool.
- tools — Optional list of tools that can be used during the subtask execution.
- llmModel — Optional language model to be used for the subtask.
- llmParams — Optional parameters for the language model configuration.
- responseProcessor — Optional processor for post-processing LLM responses.
- parallelTools — Specifies the mode in which tools should be called (e.g., sequentially).
- assistantResponseRepeatMax — Optional maximum number of response repetitions allowed for the assistant.
- Output — The type of the output produced by the subtask.

Referenced packages: `ai.koog.agents.core.agent`.

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(context: AIAgentFunctionalContextBase<*>, taskDescription: String, outputClass: Class<Output>)
```

Constructs a new instance of SubtaskBuilderWithInputAndOutput. This constructor allows specifying the context, task description, input, and the output class type, which will be used to configure the subtask builder for tasks requiring both input and output processing.

- context — The functional context required to set up the subtask builder.
- taskDescription — A textual description of the task being built.
- outputClass — The class type of the output expected from the task execution.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(context: AIAgentFunctionalContextBase<*>, taskDescription: String, finishTool: ERROR CLASS: Symbol not found for Tool<*, Output>)
```

Secondary constructor for initializing an instance of SubtaskBuilderWithInputAndOutput with a specific context, task description, input, and a finalizing tool for output processing.

- context — The functional context in which the subtask is executed.
- taskDescription — Description of the task being performed by the subtask.
- finishTool — A tool used to produce the final output for the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.assistantResponseRepeatMax

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/assistant-response-repeat-max.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun assistantResponseRepeatMax(max: Int): SubtaskBuilderWithOutput<Output>
```

Sets the maximum number of times the assistant's response can be repeated.

- max — The maximum number of repetitions allowed for the assistant's response. Must be a non-negative integer.
### :agents:agents-core/jvmCommonMain

```kotlin
var assistantResponseRepeatMax: Int?
```

- assistantResponseRepeatMax — Optional maximum number of response repetitions allowed for the assistant.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/context.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val context: AIAgentFunctionalContextBase<*>
```

- context — The functional context associated with the AI agent.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class SubtaskBuilderWithOutput<Output : Any>(val context: AIAgentFunctionalContextBase<*>, val taskDescription: String, val output: OutputOption<Output>, var tools: List<ERROR CLASS: Symbol not found for ToolBase<*, *>>? = null, var llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, var llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, var responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, var parallelTools: Boolean = false, var assistantResponseRepeatMax: Int? = null)
```

Builder class to create and configure a subtask with specified input and output types.

- context — The functional context associated with the AI agent.
- taskDescription — The description of the task that this subtask represents.
- output — Specifies the output of the subtask either by its class or through a finish tool.
- tools — Optional list of tools that can be used during the subtask execution.
- llmModel — Optional language model to be used for the subtask.
- llmParams — Optional parameters for the language model configuration.
- responseProcessor — Optional processor for post-processing LLM responses.
- parallelTools — Specifies the mode in which tools should be called (e.g., sequentially).
- assistantResponseRepeatMax — Optional maximum number of response repetitions allowed for the assistant.
- Output — The type of the output produced by the subtask.

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.llmModel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/llm-model.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var llmModel: ERROR CLASS: Symbol not found for LLModel??
```

- llmModel — Optional language model to be used for the subtask.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.llmParams

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/llm-params.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var llmParams: ERROR CLASS: Symbol not found for LLMParams??
```

- llmParams — Optional parameters for the language model configuration.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/output.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val output: OutputOption<Output>
```

- output — Specifies the output of the subtask either by its class or through a finish tool.

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.parallelTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/parallel-tools.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun parallelTools(parallelTools: Boolean): SubtaskBuilderWithOutput<Output>
```

Sets the execution mode for the AI agent's task execution.

- parallelTools — Specifies the mode in which tool calls are executed. The available modes are:
### :agents:agents-core/jvmCommonMain

```kotlin
var parallelTools: Boolean
```

- parallelTools — Specifies the mode in which tools should be called (e.g., sequentially).
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.responseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/response-processor.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??
```

- responseProcessor — Optional processor for post-processing LLM responses.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.run

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/run.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun run(): Output
```

Executes the defined task within the configured context and returns the output. The method handles different output options (OutputOption.ByClass and OutputOption.ByFinishTool) and executes subtasks using the provided input, tools, and configuration parameters.

## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.taskDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/task-description.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val taskDescription: String
```

- taskDescription — The description of the task that this subtask represents.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var tools: List<ERROR CLASS: Symbol not found for ToolBase<*, *>>?
```

- tools — Optional list of tools that can be used during the subtask execution.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.useLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/use-l-l-m.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun useLLM(llmModel: ERROR CLASS: Symbol not found for LLModel): SubtaskBuilderWithOutput<Output>
```

Configures the builder to use the specified Large Language Model (LLM) for subsequent tasks.

- llmModel — The Large Language Model (LLM) to be used, represented as an instance of LLModel.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.withParams

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/with-params.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withParams(llmParams: ERROR CLASS: Symbol not found for LLMParams): SubtaskBuilderWithOutput<Output>
```

Sets the parameters for the language model (LLM) to be used in the subtask.

- llmParams — The parameters to configure the behavior of the language model.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.withResponseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/with-response-processor.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withResponseProcessor(responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor): SubtaskBuilderWithOutput<Output>
```

Sets the response processor to be used for post-processing LLM responses during task execution.

- responseProcessor — The instance of ResponseProcessor to handle and modify LLM responses during task execution.
## ai.koog.agents.core.agent.context.SubtaskBuilderWithOutput.withTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-subtask-builder-with-output/with-tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withTools(tools: List<ERROR CLASS: Symbol not found for ToolBase<*, *>>): SubtaskBuilderWithOutput<Output>
```

Sets the tools to be used for the subtask configuration.

- tools — A list of tools, each represented as an instance of Tool<*, *>, to be utilized for the execution of the subtask.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withTools(vararg toolSets: ERROR CLASS: Symbol not found for ToolSet): SubtaskBuilderWithOutput<Output>
```

Adds the specified sets of tools to the subtask configuration.

- toolSets — A variable number of instances of ToolSet, each representing a group of tools that can be used for the execution of the subtask. Each ToolSet will be converted into a list of tools using its asTools method.
## ai.koog.agents.core.agent.session.AIAgentLLMReadSession.AIAgentLLMReadSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session/-a-i-agent-l-l-m-read-session.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(tools: List<ERROR CLASS: Symbol not found for ToolDescriptor>, executor: ERROR CLASS: Symbol not found for PromptExecutor, prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, config: AIAgentConfig)
```


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(tools: List<ToolDescriptor>, executor: PromptExecutor, prompt: Prompt, model: LLModel, responseProcessor: ResponseProcessor?, config: AIAgentConfig)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentLLMReadSession : AIAgentLLMReadSessionCommon
```

Represents a session for interacting with a language model (LLM) in a read-only context within an AI agent setup.

### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentLLMReadSession : AIAgentLLMReadSessionCommon
```

JVM actual implementation of a read-only LLM session.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentLLMReadSession : AIAgentLLMReadSessionCommon
```

Represents a session for interacting with a language model (LLM) in a read-only context within an AI agent setup.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/close.html`

### :agents:agents-core/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/config.html`

### :agents:agents-core/commonMain

```kotlin
val config: AIAgentConfig
```

Config of the agent running the session.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentLLMReadSessionCommon : AutoCloseable
```

Common base implementation for read-only LLM sessions shared across platform-specific actual classes.

- AIAgentLLMReadSession
## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: LLModel
```

Represents the active language model used within the session.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.parseResponseToStructuredResponse

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/parse-response-to-structured-response.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> parseResponseToStructuredResponse(response: Message.Assistant, config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): StructuredResponse<T>
```

Parses a structured response from a language model message using the specified configuration.

- response — Assistant message to parse.
- config — Configuration describing the expected structure.
- fixingParser — Optional parser for malformed structured responses.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```

Represents the current prompt associated with the LLM session. The prompt contains the input messages, model configuration, and parameters.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLMForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMForceOneTool(tool: ToolDescriptor): Message.Assistant
```

Sends a request to the language model while enforcing the use of a specific tool.

The response from the language model.

- tool — The tool descriptor to force in the request.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMForceOneTool(tool: ToolBase<*, *>): Message.Assistant
```

Sends a request to the language model while enforcing the use of a specific tool.

The response from the language model.

- tool — The tool to force in the request.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLMMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMMultipleChoices(): LLMChoice
```

Sends a request to the language model and returns all available response choices.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLMOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMOnlyCallingTools(): Message.Assistant
```

Sends a request to the language model that enforces the usage of tools and retrieves all responses.

A list of responses from the language model.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLMStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m-streaming.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMStreaming(): Flow<StreamFrame>
```

Sends a streaming request to the underlying LLM and returns the streamed response.

A flow of streamed response frames.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLMStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m-structured.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> requestLLMStructured(config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Sends a request to LLM and gets a structured response.

- config — A configuration defining structures and behavior.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> requestLLMStructured(serializer: KSerializer<T>, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Sends a request to LLM and gets a structured response.

- serializer — Serializer for the requested structure type.
- examples — Optional examples that help the model follow the target format.
- fixingParser — Optional parser for malformed structured responses.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
inline suspend fun <T> requestLLMStructured(examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Requests a structured response from the language model using a reified serializer.

- examples — Optional examples that help the model follow the target format.
- fixingParser — Optional parser for malformed structured responses.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLMWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMWithoutTools(): Message.Assistant
```

Sends a request to the language model without utilizing any tools and returns multiple responses.

A list of response messages from the language model.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-l-l-m.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLM(): Message.Assistant
```

Sends a request to the underlying LLM and returns the first non-reasoning response.

The first response message from the LLM after executing the request.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.requestModeration

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/request-moderation.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestModeration(moderatingModel: LLModel? = null): ModerationResult
```

Sends a moderation request to the specified or default model.

Moderation result for the current prompt.

- moderatingModel — Optional model used for moderation.

Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.responseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/response-processor.html`

### :agents:agents-core/commonMain

```kotlin
val responseProcessor: ResponseProcessor?
```

Represents the active response processor within the session.


Referenced packages: `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.session.AIAgentLLMReadSessionCommon.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-read-session-common/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<ToolDescriptor>
```

Provides a list of available tools in the session.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSession.AIAgentLLMWriteSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session/-a-i-agent-l-l-m-write-session.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(environment: AIAgentEnvironment, executor: ERROR CLASS: Symbol not found for PromptExecutor, tools: List<ERROR CLASS: Symbol not found for ToolDescriptor>, toolRegistry: ERROR CLASS: Symbol not found for ToolRegistry, prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, config: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(environment: AIAgentEnvironment, executor: PromptExecutor, tools: List<ToolDescriptor>, toolRegistry: ToolRegistry, prompt: Prompt, model: LLModel, responseProcessor: ResponseProcessor?, config: AIAgentConfig, clock: KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentLLMWriteSession : AIAgentLLMWriteSessionCommon
```

A session for managing interactions with a language learning model (LLM) and tools in an agent environment. This class provides functionality for executing LLM requests, managing tools, and customizing prompts dynamically within a specific session context.

### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentLLMWriteSession : AIAgentLLMWriteSessionCommon
```

JVM actual implementation of a mutable LLM session.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentLLMWriteSession : AIAgentLLMWriteSessionCommon
```

A session for managing interactions with a language learning model (LLM) and tools in an agent environment. This class provides functionality for executing LLM requests, managing tools, and customizing prompts dynamically within a specific session context.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.appendPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/append-prompt.html`

### :agents:agents-core/commonMain

```kotlin
fun appendPrompt(body: PromptBuilder.() -> Unit)
```

Appends messages to the current prompt using PromptBuilder.


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.changeLLMParams

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/change-l-l-m-params.html`

### :agents:agents-core/commonMain

```kotlin
fun changeLLMParams(newParams: LLMParams)
```

Updates LLM parameters on the current prompt.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.changeModel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/change-model.html`

### :agents:agents-core/commonMain

```kotlin
fun changeModel(newModel: LLModel)
```

Updates the active model in this session.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.clearHistory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/clear-history.html`

### :agents:agents-core/commonMain

```kotlin
fun clearHistory()
```

Clears the history of messages in the current AI Agent LLM Write Session.

This method resets the message history by setting it to an empty list. It is useful when you want to start a new conversation or reset the session's context.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/clock.html`

### :agents:agents-core/commonMain

```kotlin
val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/close.html`

### :agents:agents-core/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/config.html`

### :agents:agents-core/commonMain

```kotlin
val config: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.dropLastNMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/drop-last-n-messages.html`

### :agents:agents-core/commonMain

```kotlin
fun dropLastNMessages(n: Int, preserveSystemMessages: Boolean = true)
```

Removes the last n messages from the current prompt in the write session.

- n — The number of messages to remove from the end of the current message list.
## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.dropTrailingToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/drop-trailing-tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
fun dropTrailingToolCalls()
```

Drops all trailing tool call messages from the current prompt

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.environment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/environment.html`

### :agents:agents-core/commonMain

```kotlin
val environment: AIAgentEnvironment
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.findTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/find-tool.html`

### :agents:agents-core/commonMain

```kotlin
fun <TArgs, TResult> findTool(tool: ToolBase<TArgs, TResult>): SafeTool<TArgs, TResult>
```

Finds a specific tool instance from the tool registry by a tool instance type.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

### :agents:agents-core/commonMain

```kotlin
fun <TArgs, TResult> findTool(toolClass: KClass<out ToolBase<TArgs, TResult>>): SafeTool<TArgs, TResult>
```

Finds a specific tool instance from the tool registry by tool class.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentLLMWriteSessionCommon : AutoCloseable
```

Common base implementation for mutable LLM sessions shared across platform-specific actual classes.

- AIAgentLLMWriteSession
## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.leaveLastNMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/leave-last-n-messages.html`

### :agents:agents-core/commonMain

```kotlin
fun leaveLastNMessages(n: Int, preserveSystemMessages: Boolean = true)
```

Keeps only the last N messages in the session's prompt by removing all earlier messages.

- n — The number of most recent messages to retain in the session's prompt.
## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.leaveMessagesFromTimestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/leave-messages-from-timestamp.html`

### :agents:agents-core/commonMain

```kotlin
fun leaveMessagesFromTimestamp(timestamp: Instant, preserveSystemMessages: Boolean = true)
```

Removes all messages from the current session's prompt that have a timestamp earlier than the specified timestamp.

- timestamp — The threshold timestamp. Messages with a timestamp earlier than this will be removed.
## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/model.html`

### :agents:agents-core/commonMain

```kotlin
var model: LLModel
```

Represents the active language model used within the session.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.parseResponseToStructuredResponse

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/parse-response-to-structured-response.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> parseResponseToStructuredResponse(response: Message.Assistant, config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): StructuredResponse<T>
```

Parses a structured response from an assistant message using the specified configuration.


Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/prompt.html`

### :agents:agents-core/commonMain

```kotlin
var prompt: Prompt
```

Represents the current prompt associated with the LLM session.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.replaceHistoryWithTLDR

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/replace-history-with-t-l-d-r.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun replaceHistoryWithTLDR(strategy: HistoryCompressionStrategy = HistoryCompressionStrategy.WholeHistory, preserveMemory: Boolean = true)
```

Rewrites LLM message history, leaving only user message and resulting TLDR.

Default is null, which means entire history will be used.

- preserveMemory — Whether to preserve memory-related messages in the history.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLMForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMForceOneTool(tool: ToolBase<*, *>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMForceOneTool(tool: ToolDescriptor): Message.Assistant
```

Sends a request while forcing a specific tool and appends the response to the prompt.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLMMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMMultipleChoices(): LLMChoice
```

Sends a request to LLM and returns all available response choices.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLMOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMOnlyCallingTools(): Message.Assistant
```

Sends a request that enforces tool calling and appends all received responses to the prompt.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLMStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m-streaming.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMStreaming(): Flow<StreamFrame>
```

Sends a streaming request to LLM.


Referenced packages: `ai.koog.prompt.streaming`.

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMStreaming(definition: StructureDefinition? = null): Flow<StreamFrame>
```

Streams a response from LLM, optionally adding a structure definition to the prompt beforehand.


Referenced packages: `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLMStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m-structured.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> requestLLMStructured(config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```


Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> requestLLMStructured(serializer: KSerializer<T>, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Sends a request to LLM and gets a structured response, appending the assistant message on success.


Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
inline suspend fun <T> requestLLMStructured(examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): Result<StructuredResponse<T>>
```

Requests a structured response from the language model using a reified serializer.


Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLMWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLMWithoutTools(): Message.Assistant
```

Sends a request without tool usage and appends all received responses to the prompt.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-l-l-m.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestLLM(): Message.Assistant
```

Sends a request to LLM and appends the response to the prompt.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestModeration

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-moderation.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun requestModeration(moderatingModel: LLModel? = null): ModerationResult
```

Sends a moderation request using the specified moderating model or the session model.


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.requestStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/request-streaming.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> requestStreaming(definition: StructureDefinition? = null, transformStreamData: suspend (Flow<StreamFrame>) -> Flow<T>): Flow<T>
```


Referenced packages: `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.responseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/response-processor.html`

### :agents:agents-core/commonMain

```kotlin
var responseProcessor: ResponseProcessor?
```

Represents the active response processor within the session.


Referenced packages: `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.rewritePrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/rewrite-prompt.html`

### :agents:agents-core/commonMain

```kotlin
fun rewritePrompt(body: (prompt: Prompt) -> Prompt)
```

Rewrites the current prompt by applying a transformation function.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.setToolChoiceAuto

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/set-tool-choice-auto.html`

### :agents:agents-core/commonMain

```kotlin
fun setToolChoiceAuto()
```

Set the ai.koog.prompt.params.LLMParams.ToolChoice to ai.koog.prompt.params.LLMParams.ToolChoice.Auto to make LLM automatically decide between calling tools and generating text

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.setToolChoiceNamed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/set-tool-choice-named.html`

### :agents:agents-core/commonMain

```kotlin
fun setToolChoiceNamed(toolName: String)
```

Set the ai.koog.prompt.params.LLMParams.ToolChoice to ai.koog.prompt.params.LLMParams.ToolChoice.None to make LLM call one specific tool toolName

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.setToolChoiceNone

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/set-tool-choice-none.html`

### :agents:agents-core/commonMain

```kotlin
fun setToolChoiceNone()
```

Set the ai.koog.prompt.params.LLMParams.ToolChoice to ai.koog.prompt.params.LLMParams.ToolChoice.None to make LLM never call tools

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.setToolChoiceRequired

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/set-tool-choice-required.html`

### :agents:agents-core/commonMain

```kotlin
fun setToolChoiceRequired()
```

Set the ai.koog.prompt.params.LLMParams.ToolChoice to ai.koog.prompt.params.LLMParams.ToolChoice.Required to make LLM always call tools

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.setToolChoice

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/set-tool-choice.html`

### :agents:agents-core/commonMain

```kotlin
fun setToolChoice(toolChoice: LLMParams.ToolChoice?)
```

Sets the ai.koog.prompt.params.LLMParams.ToolChoice for this LLM session.


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.toParallelToolCallsRaw

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/to-parallel-tool-calls-raw.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <TArgs, TResult> Flow<TArgs>.toParallelToolCallsRaw(safeTool: SafeTool<TArgs, TResult>, concurrency: Int = 16): Flow<String>
```

Converts each flow item into a parallel tool call and emits only raw string content.


Referenced packages: `ai.koog.agents.core.environment`.

### :agents:agents-core/commonMain

```kotlin
inline fun <TArgs, TResult> Flow<TArgs>.toParallelToolCallsRaw(toolClass: KClass<out ToolBase<TArgs, TResult>>, concurrency: Int = 16): Flow<String>
```

Converts each flow item into a parallel tool call using a tool class and emits raw string content.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.toParallelToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/to-parallel-tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <TArgs, TResult> Flow<TArgs>.toParallelToolCalls(safeTool: SafeTool<TArgs, TResult>, concurrency: Int = 16): Flow<SafeTool.Result<TResult>>
```

Converts each flow item into a parallel tool call using an already resolved SafeTool.


Referenced packages: `ai.koog.agents.core.environment`.

### :agents:agents-core/commonMain

```kotlin
inline fun <TArgs, TResult> Flow<TArgs>.toParallelToolCalls(tool: ToolBase<TArgs, TResult>, concurrency: Int = 16): Flow<SafeTool.Result<TResult>>
```

Converts each flow item into a parallel tool call using a tool instance.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

### :agents:agents-core/commonMain

```kotlin
inline fun <TArgs, TResult> Flow<TArgs>.toParallelToolCalls(toolClass: KClass<out ToolBase<TArgs, TResult>>, concurrency: Int = 16): Flow<SafeTool.Result<TResult>>
```

Converts each flow item into a parallel tool call using a tool class.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
val toolRegistry: ToolRegistry
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/tools.html`

### :agents:agents-core/commonMain

```kotlin
var tools: List<ToolDescriptor>
```

Provides a list of available tools in the session.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.session.AIAgentLLMWriteSessionCommon.unsetToolChoice

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-l-l-m-write-session-common/unset-tool-choice.html`

### :agents:agents-core/commonMain

```kotlin
fun unsetToolChoice()
```

Unset the ai.koog.prompt.params.LLMParams.ToolChoice. Mostly, if left unspecified, the default value of this parameter is ai.koog.prompt.params.LLMParams.ToolChoice.Auto

## ai.koog.agents.core.agent.session.callToolRaw

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/call-tool-raw.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <TArgs> AIAgentLLMWriteSession.callToolRaw(toolName: String, args: TArgs): String
```

Executes a tool identified by its name with the provided arguments and returns the raw string result.

The raw result of the tool's execution as a String.

- toolName — The name of the tool to be executed.
- args — The arguments to be passed to the tool.
## ai.koog.agents.core.agent.session.callTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/call-tool.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <TArgs, TResult> AIAgentLLMWriteSession.callTool(tool: ToolBase<TArgs, TResult>, args: TArgs): SafeTool.Result<TResult>
```

Executes the specified tool with the given arguments and returns the result within a SafeTool.Result wrapper.

a SafeTool.Result containing the tool's execution result of type TResult.

- tool — the tool to be executed.
- args — the arguments required to execute the tool.
- TArgs — the type of arguments required by the tool.
- TResult — the type of result returned by the tool, implementing ToolResult.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

### :agents:agents-core/commonMain

```kotlin
suspend fun <TArgs> AIAgentLLMWriteSession.callTool(toolName: String, args: TArgs): SafeTool.Result<out Any?>
```

Executes a tool by its name with the provided arguments.

A SafeTool.Result containing the result of the tool execution, which is a subtype of ai.koog.agents.core.tools.ToolResult.

- toolName — The name of the tool to be executed.
- args — The arguments required to execute the tool.

Referenced packages: `ai.koog.agents.core.environment`.

### :agents:agents-core/commonMain

```kotlin
suspend fun <TArgs, TResult> AIAgentLLMWriteSession.callTool(toolClass: KClass<out ToolBase<TArgs, TResult>>, args: TArgs): SafeTool.Result<TResult>
```

Executes a tool operation based on the provided tool class and arguments.

A result wrapper containing either the successful result of the tool's execution or an error.

- toolClass — The class of the tool to be executed.
- args — The arguments to be passed to the tool for its execution.
- TArgs — The type of arguments required by the tool.
- TResult — The type of result produced by the tool.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

### :agents:agents-core/commonMain

```kotlin
inline suspend fun <ToolT : ToolBase<Any?, Any?>> AIAgentLLMWriteSession.callTool(args: Any?): SafeTool.Result<out Any?>
```

Invokes a tool of the specified type with the provided arguments.

A SafeTool.Result containing the outcome of the tool's execution, which may be of any type that extends ToolResult.

- args — The input arguments required for the tool execution.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

### :agents:agents-core/jvmCommonMain

```kotlin
inline suspend fun <TResult> AIAgentLLMWriteSession.callTool(toolFunction: KFunction<TResult>, vararg args: Any?): SafeTool.Result<TResult>
```

Invokes a specified tool function within the AI Agent's write session context.

The result of executing the specified tool function.

- toolFunction — The tool function to be executed.
- args — The arguments to pass to the tool function.
- IllegalArgumentException — If the tool corresponding to the given function is not found in the tool registry.

Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.session.findToolByName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/find-tool-by-name.html`

### :agents:agents-core/commonMain

```kotlin
fun <TArgs> AIAgentLLMWriteSession.findToolByName(toolName: String): SafeTool<TArgs, *>
```

Finds a tool by its name and ensures its arguments are compatible with the specified type.

A SafeTool instance wrapping the tool with the specified argument type.

- toolName — The name of the tool to be retrieved.
- IllegalArgumentException — If the tool with the specified name is not defined or its arguments are incompatible with the expected type.

Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.session.findTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/find-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
inline fun <TResult> AIAgentLLMWriteSession.findTool(toolFunction: KFunction<TResult>): SafeTool<ERROR CLASS: Symbol not found for ToolFromCallable.Args, TResult>
```

Finds a specific tool within the tool registry using the given tool function and returns it as a safe tool.

A safe representation of the tool associated with the provided function.

- toolFunction — The reference to the function defining the tool to be located.
- IllegalArgumentException — If the tool corresponding to the given function is not found in the tool registry.

Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.extension.FromLastNMessagesHistoryCompressionStrategy.FromLastNMessagesHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-last-n-messages-history-compression-strategy/-from-last-n-messages-history-compression-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor(n: Int)
```

## ai.koog.agents.core.dsl.extension.FromLastNMessagesHistoryCompressionStrategy.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-last-n-messages-history-compression-strategy/compress.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Compresses the conversation history by retaining the last N messages, generating a summary, and composing the resulting prompt with the necessary messages.

- llmSession — the session in which the language model operates, providing functionalities to manage prompts and request responses.
- memoryMessages — a list of messages representing historical memory to be optionally retained if preserveMemory is true.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.FromLastNMessagesHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-last-n-messages-history-compression-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
data class FromLastNMessagesHistoryCompressionStrategy(val n: Int) : HistoryCompressionStrategy
```

A strategy for compressing history by retaining only the last n messages in a session.

This class removes all but the last n messages from the current prompt history and then compresses the retained messages into a summary (TL;DR). It also allows integration of specific memory messages back into the prompt if needed.

## ai.koog.agents.core.dsl.extension.FromLastNMessagesHistoryCompressionStrategy.n

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-last-n-messages-history-compression-strategy/n.html`

### :agents:agents-core/commonMain

```kotlin
val n: Int
```

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.Chunked

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-chunked.html`

### :agents:agents-core/commonMain

```kotlin
fun Chunked(chunkSize: Int): HistoryCompressionStrategy
```

A concrete implementation of the HistoryCompressionStrategy that splits the session's prompt into chunks of a predefined size and generates summaries (TL;DR) for each chunk.

This strategy preserves all system messages as well as the first user message (if presented) and memory messages (if provided) and then appends tldr of each chuck of messages from initial history (except trailing tool calls for each chunk).

- chunkSize — The size of chunks into which the prompt messages are divided.
## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.FactRetrieval

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-fact-retrieval.html`

### :agents:agents-core/commonMain

```kotlin
fun FactRetrieval(concepts: List<Concept>): HistoryCompressionStrategy
```

A strategy for compressing history by extracting structured facts about predefined concepts from the current conversation history using an LLM, then replacing the full history with a compact assistant message that contains those extracted facts.

This strategy preserves all system messages as well as the first user message (if present) and memory messages (if provided), then appends a single assistant message summarising the extracted facts and the approximate number of tool interactions that occurred.

System, User, Assistant, ToolCall, ToolResult, Assistant -> [System, User, Memory, Assistant(CONTEXT RESTORATION facts about configured concepts)]

- concepts — The list of Concept objects that define which topics to extract facts about.
### :agents:agents-core/commonMain

```kotlin
fun FactRetrieval(vararg concepts: Concept): HistoryCompressionStrategy
```

A strategy for compressing history by extracting structured facts about predefined concepts fro m the current conversation history using an LLM, then replacing the full history with a compact assistant message that contains those extracted facts.

This strategy preserves all system messages as well as the first user message (if present) and memory messages (if provided), then appends a single assistant message summarising the extracted facts and the approximate number of tool interactions that occurred.

System, User, Assistant, ToolCall, ToolResult, Assistant -> [System, User, Memory, Assistant(CONTEXT RESTORATION facts about configured concepts)]

A HistoryCompressionStrategy configured for fact-based history compression.

- concepts — A variable number of Concept objects that define the topics for which facts are to be extracted from the conversation history.
## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.FromLastNMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-from-last-n-messages.html`

### :agents:agents-core/commonMain

```kotlin
fun FromLastNMessages(n: Int): HistoryCompressionStrategy
```

A strategy for compressing history by retaining only the last n messages in a session.

This class removes all but the last n messages from the current prompt history and then compresses the retained messages into a summary (TL;DR). It also allows integration of specific memory messages back into the prompt if needed.

- n — The number of most recent messages to retain during compression.
## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.FromTimestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-from-timestamp.html`

### :agents:agents-core/commonMain

```kotlin
fun FromTimestamp(timestamp: Instant): HistoryCompressionStrategy
```

A strategy for compressing message histories using a specified timestamp as a reference point. This strategy removes messages that occurred before a given timestamp and creates a summarized context for further interactions.

This strategy preserves all system messages as well as the first user message (if presented) and memory messages (if provided) and then appends tldr of the subset of messages starting from the provided timestamp (except trailing tool calls).

- timestamp — The timestamp indicating the earliest point to retain messages from.
## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.NoCompression

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-no-compression.html`

### :agents:agents-core/commonMain

```kotlin
@JvmField val NoCompression: HistoryCompressionStrategy
```

Represents a no-operation strategy for memory message compression within the history of a conversation.

This strategy does not apply any compression to the provided messages, leaving them unchanged. It is useful when compression is not required or when all messages should remain unaltered.

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.WholeHistoryMultipleSystemMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-whole-history-multiple-system-messages.html`

### :agents:agents-core/commonMain

```kotlin
@JvmField val WholeHistoryMultipleSystemMessages: HistoryCompressionStrategy
```

WholeHistoryMultipleSystemMessages is a concrete implementation of the HistoryCompressionStrategy that handles scenarios where the conversation history contains multiple system messages.

This strategy:

Splits the history into blocks based on system message boundaries

Processes each block separately to generate TL;DR summaries

Maintains the chronological order of system messages while compressing the conversation

Preserves memory messages only in the first block to maintain context

System1, User1, Assistant, ToolCall, ToolResult, System2, User2, Assistant, User3, System3, Assistant, System4 ->System1, User1, Memory, TLDR(System1, User1, Assistant, ToolCall, ToolResult), System2, User2, TLDR(System2, User2, Assistant, User3), System3, Assistant, TLDR(System3, Assistant) System4, TLDR(System4)

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion.WholeHistory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/-whole-history.html`

### :agents:agents-core/commonMain

```kotlin
@JvmField val WholeHistory: HistoryCompressionStrategy
```

WholeHistory is a concrete implementation of the HistoryCompressionStrategy that encapsulates the logic for compressing entire conversation history into a succinct summary (TL;DR) and composing the necessary messages to create a streamlined prompt suitable for language model interactions.

This strategy preserves all system messages as well as the first user message (if presented) and memory messages (if provided) and then appends tldr of the whole original history (except trailing tool calls).

System, User, Assistant, ToolCall1, ToolResult, ToolCall2 ->System, User, Memory, TLDR(System, User, Assistant, ToolCall1, ToolResult)

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

Companion object for HistoryCompressionStrategy with easy access to default implementations.

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.HistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/-history-compression-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/compress.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Compresses a given collection of memory messages using a specified strategy.

- llmSession — The current LLM session used for processing during compression.
- memoryMessages — A list of messages representing the memory to be compressed.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-history-compression-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class HistoryCompressionStrategy
```

Represents an abstract strategy for compressing the history of messages in a AIAgentLLMWriteSession. Different implementations define specific approaches to reducing the context size while maintaining key information.

Example implementations:

HistoryCompressionStrategy.WholeHistory

HistoryCompressionStrategy.FromLastNMessages

HistoryCompressionStrategy.FromTimestamp

HistoryCompressionStrategy.Chunked

HistoryCompressionStrategy.FactRetrieval

- WholeHistoryCompressionStrategy
- WholeCompressionStrategyWithMultipleSystemMessages
- FromLastNMessagesHistoryCompressionStrategy
- FromTimestampHistoryCompressionStrategy
- ChunkedHistoryCompressionStrategy
- FactRetrievalHistoryCompressionStrategy
## ai.koog.agents.core.dsl.extension.WholeHistoryCompressionStrategy.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-whole-history-compression-strategy/compress.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Compresses and adjusts the prompt for the agent's writing session by summarizing and incorporating memory messages optionally.

- llmSession — The current session of the agent which allows prompt manipulation and sending requests.
- memoryMessages — A list of memory messages to be optionally preserved and included in the prompt.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.WholeHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-whole-history-compression-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
object WholeHistoryCompressionStrategy : HistoryCompressionStrategy
```

WholeHistory is a concrete implementation of the HistoryCompressionStrategy that encapsulates the logic for compressing entire conversation history into a succinct summary (TL;DR) and composing the necessary messages to create a streamlined prompt suitable for language model interactions.

This strategy preserves all system messages as well as the first user message (if presented) and memory messages (if provided) and then appends tldr of the whole original history (except trailing tool calls).

System, User, Assistant, ToolCall1, ToolResult, ToolCall2 ->System, User, Memory, TLDR(System, User, Assistant, ToolCall1, ToolResult)

## ai.koog.agents.core.agent.context.AIAgentLLMContext.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context/copy.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open suspend override fun copy(tools: List<ERROR CLASS: Symbol not found for ToolDescriptor>, toolRegistry: ERROR CLASS: Symbol not found for ToolRegistry, prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, promptExecutor: ERROR CLASS: Symbol not found for PromptExecutor, environment: AIAgentEnvironment, config: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock): AIAgentLLMContext
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun copy(tools: List<ERROR CLASS: Symbol not found for ToolDescriptor>, prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, promptExecutor: ERROR CLASS: Symbol not found for PromptExecutor, environment: AIAgentEnvironment, config: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock): AIAgentLLMContext
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.context.AIAgentLLMContextCommon.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-l-l-m-context-common/copy.html`

### :agents:agents-core/commonMain

```kotlin
open suspend fun copy(tools: List<ToolDescriptor> = this.tools, toolRegistry: ToolRegistry = this.toolRegistry, prompt: Prompt = this.prompt, model: LLModel = this.model, responseProcessor: ResponseProcessor? = this.responseProcessor, promptExecutor: PromptExecutor = this.promptExecutor, environment: AIAgentEnvironment = this.environment, config: AIAgentConfig = this.config, clock: KoogClock = this.clock): AIAgentLLMContext
```

Creates a copy of this LLM context, taking a consistent snapshot of its mutable fields under the internal read lock. Multiple concurrent copy / readSession calls may proceed in parallel, but any concurrent writeSession / withPrompt will serialize against them.

Concurrency caveat: must not be invoked from inside a writeSession or withPrompt on the same context — the underlying lock is not reentrant (see RWLock).

A new instance of AIAgentLLMContext with deep copies of mutable properties.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
open fun copy(tools: List<ToolDescriptor> = this.tools, prompt: Prompt = this.prompt, model: LLModel = this.model, responseProcessor: ResponseProcessor? = this.responseProcessor, promptExecutor: PromptExecutor = this.promptExecutor, environment: AIAgentEnvironment = this.environment, config: AIAgentConfig = this.config, clock: KoogClock = this.clock): AIAgentLLMContext
```

Creates a non-suspending copy of this LLM context with the given overrides. Unlike the suspending copy overload, this variant does not acquire the internal read lock and therefore does not guarantee a consistent snapshot if another coroutine is concurrently mutating this context.

A new AIAgentLLMContext instance with the specified overrides applied.

- tools — The list of ToolDescriptor tools to use, or the current tools if not specified.
- prompt — The Prompt to use, or the current prompt if not specified.
- model — The LLModel to use, or the current model if not specified.
- responseProcessor — The ResponseProcessor to use, or the current one if not specified.
- promptExecutor — The PromptExecutor to use, or the current one if not specified.
- environment — The AIAgentEnvironment to use, or the current one if not specified.
- config — The AIAgentConfig to use, or the current configuration if not specified.
- clock — The Clock to use, or the current clock if not specified.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.
