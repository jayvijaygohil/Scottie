# Graph strategies, nodes, and subgraphs

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategy.AIAgentGraphStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy/-a-i-agent-graph-strategy.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(name: String, nodeStart: StartNode<TInput>, nodeFinish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, serializer: Json = Json { prettyPrint = true })
```

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(name: String, nodeStart: StartNode<TInput>, nodeFinish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, serializer: ERROR CLASS: Symbol not found for Json)
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(name: String, nodeStart: StartNode<TInput>, nodeFinish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, serializer: Json)
```

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategy.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy/-companion/builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun builder(strategyName: String = "graphStrategy"): GraphStrategyBuilder
```

Creates a new instance of the GraphStrategyBuilder for constructing graph processing strategies.

This builder serves as the entry point for configuring a graph strategy with an optional strategy name. It allows for detailed customization of the graph processing logic, including specifying the input type of the graph when chaining additional configurations.

A new instance of GraphStrategyBuilder initialized with the specified or default strategy name.

- strategyName — The name of the graph strategy being constructed. Defaults to "graphStrategy".
## ai.koog.agents.core.agent.entity.AIAgentGraphStrategy.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy/-companion/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
object Companion
```

Companion object for the AIAgentGraphStrategy class.

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentGraphStrategy<TInput, TOutput> : AIAgentGraphStrategyBase<TInput, TOutput>
```

Represents a strategy for managing and executing AI agent workflows built as subgraphs of interconnected nodes.

### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentGraphStrategy<TInput, TOutput> : AIAgentGraphStrategyBase<TInput, TOutput>
```

Represents a strategy for managing and executing AI agent workflows built as subgraphs of interconnected nodes.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentGraphStrategy<TInput, TOutput> : AIAgentGraphStrategyBase<TInput, TOutput>
```

Represents a strategy for managing and executing AI agent workflows built as subgraphs of interconnected nodes.

## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun builder(name: String? = null): AIAgentNodeBuilder
```

Creates and returns a new instance of AIAgentNodeBuilder, used for constructing and configuring instances of AIAgentNode.

A new AIAgentNodeBuilder instance.

## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.executeTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/execute-tools.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun executeTools(name: String? = null): AIAgentNodeBase<ToolCalls, ReceivedToolResults>
```

A node that executes all tool calls in the assistant message and appends results as a user message.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.AIAgentNode.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
object Companion
```

Companion object for the AIAgentNode class.

## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmCompressHistory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-compress-history.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun llmCompressHistory(name: String? = null): CompressHistoryNodeBuilder
```

Creates a new instance of CompressHistoryNodeBuilder with an optional custom name.

A new instance of CompressHistoryNodeBuilder initialized with the provided or generated name.

- name — An optional string to specify a custom name for the CompressHistoryNodeBuilder.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmModerateMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-moderate-message.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmModerateMessage(name: String? = null, moderatingModel: ERROR CLASS: Symbol not found for LLModel??, includeCurrentPrompt: Boolean): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message, ModeratedMessage>
```

A node that moderates a message using the LLM.

- name — Optional node name, defaults to delegate's property name.
- moderatingModel — Optional LLModel to use for moderation. If null, uses the agent's current model.
- includeCurrentPrompt — If true, includes the current prompt in the moderation request.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmRequestForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-request-force-one-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequestForceOneTool(name: String? = null, tool: ERROR CLASS: Symbol not found for ToolDescriptor): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that sends a user message and requests a response from the LLM, forcing the LLM to call the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The ToolDescriptor of the tool to force the LLM to use.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequestForceOneTool(name: String? = null, tool: ERROR CLASS: Symbol not found for Tool<*, *>): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that sends a user message and requests a response from the LLM, forcing the LLM to call the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The Tool to force the LLM to use.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmRequestOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-request-only-calling-tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequestOnlyCallingTools(name: String? = null): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that sends a user message and requests a response from the LLM, where only tool calls are allowed.

- name — Optional node name, defaults to delegate's property name.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmRequestStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-request-streaming.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T : Any> llmRequestStreaming(transformStreamData: (Flow.Publisher<ERROR CLASS: Symbol not found for StreamFrame>) -> Flow.Publisher<T>, outputClass: Class<T>, structureDefinition: ERROR CLASS: Symbol not found for StructureDefinition?? = null, name: String? = null): AIAgentNodeBase<String, Flow.Publisher<T>>
```

An instance of AIAgentNodeBase with a message input and a publisher output.

- transformStreamData — A function that processes the incoming stream of StreamFrame objects and transforms them into a publisher.
- outputClass — The class type of the transformed output data.
- structureDefinition — An optional definition of structured data.
- name — An optional name for the node being created.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequestStreaming(name: String? = null, structureDefinition: ERROR CLASS: Symbol not found for StructureDefinition??): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Flow<ERROR CLASS: Symbol not found for StreamFrame>>
```

A node that sends a user message and requests a streaming response from the LLM.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — Optional structure definition to customize the streaming response.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmRequestStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-request-structured.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T : Any> llmRequestStructured(name: String? = null, config: ERROR CLASS: Symbol not found for StructuredRequestConfig<T>, fixingParser: ERROR CLASS: Symbol not found for StructureFixingParser??): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Result<ERROR CLASS: Symbol not found for StructuredResponse<T>>>
```

A node that sends a user message and requests a structured response from the LLM.

- name — Optional node name, defaults to delegate's property name.
- config — The StructuredRequestConfig defining the expected output type.
- fixingParser — Optional StructureFixingParser for correcting malformed responses.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmRequestWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-request-without-tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequestWithoutTools(name: String? = null): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that sends a user message and requests a response from the LLM without allowing tool calls.

- name — Optional node name, defaults to delegate's property name.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmRequest

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-request.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequest(name: String? = null): AIAgentNodeBase<String, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that sends a user message and requests a response from the LLM.

- name — Optional node name, defaults to delegate's property name.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessageForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message-force-one-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessageForceOneTool(name: String? = null, tool: ERROR CLASS: Symbol not found for ToolDescriptor): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, forcing it to call exactly the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The ToolDescriptor of the tool the LLM must call.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessageForceOneTool(name: String? = null, tool: ERROR CLASS: Symbol not found for Tool<*, *>): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, forcing it to call exactly the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The Tool the LLM must call.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessageMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message-multiple-choices.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessageMultipleChoices(name: String? = null): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for LLMChoice>
```

A node that appends a Message.User to the prompt and requests multiple completion choices from the LLM, returning them as an LLMChoice.

- name — Optional node name, defaults to delegate's property name.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessageOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message-only-calling-tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessageOnlyCallingTools(name: String? = null): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, forcing it to call one of the available tools (no plain-text replies allowed).

- name — Optional node name, defaults to delegate's property name.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessageStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message-streaming.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T : Any> llmSendMessageStreaming(transformStreamData: (Flow.Publisher<ERROR CLASS: Symbol not found for StreamFrame>) -> Flow.Publisher<T>, outputClass: Class<T>, structureDefinition: ERROR CLASS: Symbol not found for StructureDefinition?? = null, name: String? = null): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, Flow.Publisher<T>>
```

An instance of AIAgentNodeBase with a Message.User input and a Publisher output.

- transformStreamData — A function that processes the incoming stream of StreamFrame objects and transforms them into a publisher.
- outputClass — The class type of the transformed output data.
- structureDefinition — An optional definition of structured data.
- name — An optional name for the node being created.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessageStreaming(name: String? = null, structureDefinition: ERROR CLASS: Symbol not found for StructureDefinition??): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Flow<ERROR CLASS: Symbol not found for StreamFrame>>
```

A node that appends a Message.User to the prompt and requests a streaming response from the LLM, returning raw StreamFrame elements.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — Optional structure definition to customize the streaming response.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessageStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message-structured.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T> llmSendMessageStructured(name: String? = null, config: ERROR CLASS: Symbol not found for StructuredRequestConfig<T>, fixingParser: ERROR CLASS: Symbol not found for StructureFixingParser??): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Result<ERROR CLASS: Symbol not found for StructuredResponse<T>>>
```

A node that appends a Message.User to the prompt and requests a structured response from the LLM.

- name — Optional node name, defaults to delegate's property name.
- config — The StructuredRequestConfig defining the expected output type.
- fixingParser — Optional StructureFixingParser for correcting malformed responses.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessageWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message-without-tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessageWithoutTools(name: String? = null): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, without exposing any tools (pure text response only).

- name — Optional node name, defaults to delegate's property name.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-message.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendMessage(name: String? = null): AIAgentNodeBase<ERROR CLASS: Symbol not found for Message.User, ERROR CLASS: Symbol not found for Message.Assistant>
```

Creates and returns a node for the AI agent strategy graph that is responsible for sending a message.

An instance of AIAgentNodeBase that represents the message-sending operation. The node processes input of type Message.User and produces output of type Message.Assistant.

- name — An optional name for the node. If null, a default name is assigned.
## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.llmSendToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/llm-send-tool-results.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmSendToolResults(name: String? = null): AIAgentNodeBase<ReceivedToolResults, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that sends tool results as a message to the LLM.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.AIAgentNode.Companion.selectLLMChoice

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/-companion/select-l-l-m-choice.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun selectLLMChoice(choiceSelectionStrategy: ChoiceSelectionStrategy, name: String? = null): AIAgentNodeBase<ERROR CLASS: Symbol not found for LLMChoice, ERROR CLASS: Symbol not found for Message.Assistant>
```

A node that chooses an LLM choice based on the given strategy.

- choiceSelectionStrategy — The strategy used to choose an LLM choice.
- name — Optional name for the node.

Referenced packages: `ai.koog.agents.ext.llm.choice`.

## ai.koog.agents.core.agent.entity.AIAgentNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node/index.html`

### :agents:agents-core/commonMain

```kotlin
expect open class AIAgentNode<TInput, TOutput> : SimpleAIAgentNodeImpl<TInput, TOutput>
```

Platform-specific expect/actual declaration of SimpleAIAgentNodeImpl.

- TInput — The type of input data this node processes.
- TOutput — The type of output data this node produces.
- SimpleAIAgentNodeImpl
- StartNode
- FinishNode
### :agents:agents-core/jvmCommonMain

```kotlin
actual open class AIAgentNode<TInput, TOutput> : SimpleAIAgentNodeImpl<TInput, TOutput>
```

Represents a simple implementation of an AI agent node, encapsulating a specific execution logic that processes the input data and produces an output.

- TInput — The type of input data this node processes.
- TOutput — The type of output data this node produces.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open class AIAgentNode<TInput, TOutput> : SimpleAIAgentNodeImpl<TInput, TOutput>
```

Represents a simple implementation of an AI agent node, encapsulating a specific execution logic that processes the input data and produces an output.

- TInput — The type of input data this node processes.
- TOutput — The type of output data this node produces.
## ai.koog.agents.core.agent.entity.AIAgentSubgraph.AIAgentSubgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph/-a-i-agent-subgraph.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(name: String, start: StartNode<TInput>, finish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel? = null, llmParams: LLMParams? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false)
```

- name — The name of the subgraph.
- start — The starting node of the subgraph, which initiates the processing.
- finish — The finishing node of the subgraph, which concludes the processing.
- toolSelectionStrategy — Strategy determining which tools should be available during this subgraph's execution.
- llmModel — Optional LLModel override for the subgraph execution.
- llmParams — Optional LLMParams override for the prompt for the subgraph execution.
- responseProcessor — Optional ResponseProcessor override for the subgraph execution.
- TInput — The type of input data accepted by the subgraph.
- TOutput — The type of output data returned by the subgraph.

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(name: String, start: StartNode<TInput>, finish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, llmModel: ERROR CLASS: Symbol not found for LLModel??, llmParams: ERROR CLASS: Symbol not found for LLMParams??, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, freshHistory: Boolean)
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(name: String, start: StartNode<TInput>, finish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel?, llmParams: LLMParams?, responseProcessor: ResponseProcessor?, freshHistory: Boolean)
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.entity.AIAgentSubgraph.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph/-companion/builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun builder(name: String? = null): AgentSubgraphBuilder<*>
```

Creates and returns a new AgentSubgraphBuilder for constructing a subgraph with the specified name in the context of the current graph strategy builder.

A new instance of AgentSubgraphBuilder for further configuration of the subgraph.

- name — The name of the subgraph to create, or null if unspecified.
## ai.koog.agents.core.agent.entity.AIAgentSubgraph.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph/-companion/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
object Companion
```

Companion object for AIAgentSubgraph.

## ai.koog.agents.core.agent.entity.AIAgentSubgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentSubgraph<TInput, TOutput> : AIAgentSubgraphBase<TInput, TOutput>
```

Represents a subgraph within an AI agent execution strategy capable of processing input and producing output.

A subgraph is a modular component of a larger execution graph, defined by a StartNode as the entry point and a FinishNode as the exit point. The subgraph may implement tool selection strategies, incorporate language model support, and apply custom response processing to tailor its behavior within the broader agent workflow.

- name — The name of the subgraph.
- start — The starting node of the subgraph, which initiates the processing.
- finish — The finishing node of the subgraph, which concludes the processing.
- toolSelectionStrategy — Strategy determining which tools should be available during this subgraph's execution.
- llmModel — Optional LLModel override for the subgraph execution.
- llmParams — Optional LLMParams override for the prompt for the subgraph execution.
- responseProcessor — Optional ResponseProcessor override for the subgraph execution.
- TInput — The type of input data accepted by the subgraph.
- TOutput — The type of output data returned by the subgraph.
### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentSubgraph<TInput, TOutput> : AIAgentSubgraphBase<TInput, TOutput>
```

Represents a subgraph within an AI agent execution strategy capable of processing input and producing output.

A subgraph is a modular component of a larger execution graph, defined by a StartNode as the entry point and a FinishNode as the exit point. The subgraph may implement tool selection strategies, incorporate language model support, and apply

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentSubgraph<TInput, TOutput> : AIAgentSubgraphBase<TInput, TOutput>
```

Represents a subgraph within an AI agent execution strategy capable of processing input and producing output.

A subgraph is a modular component of a larger execution graph, defined by a StartNode as the entry point and a FinishNode as the exit point. The subgraph may implement tool selection strategies, incorporate language model support, and apply

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.ALL

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-a-l-l/index.html`

### :agents:agents-core/commonMain

```kotlin
data object ALL : ToolSelectionStrategy
```

Represents the inclusion of all available tools in a given subgraph or process.

This object signifies that no filtering or selection is applied to the set of tools being used, and every tool is considered relevant for execution.

Used in contexts where all tools should be provided or included without constraint, such as within a AIAgentSubgraph or similar constructs.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.AutoSelectForTask.AutoSelectForTask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-auto-select-for-task/-auto-select-for-task.html`

### :agents:agents-core/commonMain

```kotlin
constructor(subtaskDescription: String, fixingParser: StructureFixingParser? = null)
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.AutoSelectForTask.fixingParser

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-auto-select-for-task/fixing-parser.html`

### :agents:agents-core/commonMain

```kotlin
val fixingParser: StructureFixingParser?
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.AutoSelectForTask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-auto-select-for-task/index.html`

### :agents:agents-core/commonMain

```kotlin
data class AutoSelectForTask(val subtaskDescription: String, val fixingParser: StructureFixingParser? = null) : ToolSelectionStrategy
```

Represents a subset of tools tailored to the specific requirements of a subtask.

The purpose of this class is to dynamically select and include only the tools that are directly relevant to the provided subtask description by asking the LLM, using a structured request, which tools from the currently available toolset are relevant to subtaskDescription. This ensures that unnecessary tools are excluded, optimizing the toolset for the specific use case.


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.AutoSelectForTask.subtaskDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-auto-select-for-task/subtask-description.html`

### :agents:agents-core/commonMain

```kotlin
val subtaskDescription: String
```

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.NONE

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-n-o-n-e/index.html`

### :agents:agents-core/commonMain

```kotlin
data object NONE : ToolSelectionStrategy
```

Represents a specific subset of tools used within a subgraph configuration where no tools are selected.

This object, when used, implies that the subgraph should operate without any tools available. It can be used in scenarios where tool functionality is not required or should be explicitly restricted.

Part of the sealed interface ToolSelectionStrategy which defines various tool subset configurations for subgraph behaviors.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.Tools.Tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-tools/-tools.html`

### :agents:agents-core/commonMain

```kotlin
constructor(tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.Tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-tools/index.html`

### :agents:agents-core/commonMain

```kotlin
data class Tools(val tools: List<ToolDescriptor>) : ToolSelectionStrategy
```

Represents a subset of tools to be used within a subgraph or task.

The Tools class allows for specifying a custom selection of tools that are relevant to a specific operation or task. It forms a part of the ToolSelectionStrategy interface hierarchy for flexible and dynamic tool configurations.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy.Tools.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/-tools/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<ToolDescriptor>
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.entity.ToolSelectionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-tool-selection-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed interface ToolSelectionStrategy
```

Represents a strategy to select a subset of tools to be used in a subgraph during its execution.

This interface provides different configurations for tool selection, ranging from using all available tools to a specific subset determined by the context or explicitly provided.

- ALL
- NONE
- AutoSelectForTask
- Tools
## ai.koog.agents.core.dsl.builder.AIAgentEdgeBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-edge-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
open override fun build(): AIAgentEdge<IncomingOutput, OutgoingInput>
```

Builds and returns the instance of type T that has been configured using the builder.

The constructed instance of type T.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-edge-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentEdgeBuilder<IncomingOutput, OutgoingInput, CompatibleOutput : OutgoingInput> : BaseBuilder<AIAgentEdge<IncomingOutput, OutgoingInput>>
```

A builder class for constructing an AIAgentEdge instance, which represents a directed edge connecting two nodes in a graph of an AI agent's processing pipeline. This edge defines the flow of data from a source node to a target node, enabling transformation or filtering of the source node's output before passing it to the target node.

- IncomingOutput — The type of output produced by the source node connected to this edge.
- OutgoingInput — The type of input accepted by the target node connected to this edge.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentEdgeBuilderIntermediate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-edge-builder-intermediate/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput> : AIAgentEdgeBuilderIntermediateBase<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Represents an intermediate stage in the construction of a directed edge between two nodes in an AI agent strategy graph. This class provides mechanisms to define conditions and transformations that dictate how data flows and is processed between the nodes.

- IncomingOutput — The type of the output data produced by the originating node.
- IntermediateOutput — The type of intermediate data produced after transformation or filtering.
- OutgoingInput — The type of input data that the destination node expects.
### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput> : AIAgentEdgeBuilderIntermediateBase<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Represents an intermediate stage in the construction of a directed edge between two nodes in an AI agent strategy graph. This class provides mechanisms to define conditions and transformations that dictate how data flows and is processed between the nodes.

- IncomingOutput — The type of the output data produced by the originating node.
- IntermediateOutput — The type of intermediate data produced after transformation or filtering.
- OutgoingInput — The type of input data that the destination node expects.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open class AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput> : AIAgentEdgeBuilderIntermediateBase<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Represents an intermediate stage in the construction of a directed edge between two nodes in an AI agent strategy graph. This class provides mechanisms to define conditions and transformations that dictate how data flows and is processed between the nodes.

- IncomingOutput — The type of the output data produced by the originating node.
- IntermediateOutput — The type of intermediate data produced after transformation or filtering.
- OutgoingInput — The type of input data that the destination node expects.
## ai.koog.agents.core.dsl.builder.AIAgentGraphStrategyBuilder.AIAgentGraphStrategyBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-graph-strategy-builder/-a-i-agent-graph-strategy-builder.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String, inputType: TypeToken, outputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy)
```

- name — The name of the strategy being built, serving as a unique identifier.
- toolSelectionStrategy — The strategy used to determine the subset of tools available during subgraph execution.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentGraphStrategyBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-graph-strategy-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
open override fun build(): AIAgentGraphStrategy<TInput, TOutput>
```

Builds and returns the instance of type T that has been configured using the builder.

The constructed instance of type T.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentGraphStrategyBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-graph-strategy-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentGraphStrategyBuilder<TInput, TOutput>(name: String, inputType: TypeToken, outputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy) : AIAgentSubgraphBuilderBase<TInput, TOutput> , BaseBuilder<AIAgentGraphStrategy<TInput, TOutput>>
```

A builder class responsible for constructing an instance of AIAgentGraphStrategy. The AIAgentGraphStrategyBuilder serves as a specific configuration for creating AI agent strategies with a defined start and finish node, along with a designated tool selection strategy.

- name — The name of the strategy being built, serving as a unique identifier.
- toolSelectionStrategy — The strategy used to determine the subset of tools available during subgraph execution.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentGraphStrategyBuilder.nodeFinish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-graph-strategy-builder/node-finish.html`

### :agents:agents-core/commonMain

```kotlin
open override val nodeFinish: FinishNode<TOutput>
```

Represents the "finish" node in the AI agent's subgraph structure. This node indicates the endpoint of the subgraph and acts as a terminal stage where the workflow stops.

The nodeFinish property is an abstract member that subclasses must define. It is of type FinishAIAgentNodeBase, which is a specialized node that directly passes its input to its output without modification as part of an identity operation.

This node does not allow outgoing edges and cannot be linked further in the graph. It serves as the final node responsible for receiving and producing data of the defined output type.

- Output — The type of data processed and produced by this node.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentGraphStrategyBuilder.nodeStart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-graph-strategy-builder/node-start.html`

### :agents:agents-core/commonMain

```kotlin
open override val nodeStart: StartNode<TInput>
```

Represents the starting node of the subgraph in the AI agent's strategy graph.

This property holds a reference to a StartAIAgentNodeBase instance, which acts as the entry point for the subgraph. It is used to define the initial step in the processing pipeline for input data and is integral to the construction of the subgraph.

- Input — The type of input data that this starting node processes.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilder.AIAgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder/-a-i-agent-subgraph-builder.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String? = null, inputType: TypeToken, outputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel?, llmParams: LLMParams?, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false)
```

- llmModel — Initial LLM model used in this subgraph
- llmParams — Initial LLM prompt parameters used in this subgraph
- responseProcessor — Initial optional processor defining the post-processing of messages returned from the LLM.
- Input — The input type expected by the starting node of the subgraph.
- Output — The output type produced by the finishing node of the subgraph.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
open override fun build(): AIAgentSubgraphDelegate<Input, Output>
```

Builds and returns the instance of type T that has been configured using the builder.

The constructed instance of type T.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentSubgraphBuilder<Input, Output>(val name: String? = null, inputType: TypeToken, outputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel?, llmParams: LLMParams?, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false) : AIAgentSubgraphBuilderBase<Input, Output> , BaseBuilder<AIAgentSubgraphDelegate<Input, Output>>
```

Builder class for creating AI agent subgraphs with a defined tool selection strategy.

This class facilitates the construction of customized subgraphs in an AI agent's execution pipeline. It provides methods for defining start and finish nodes and ensuring the connectivity between them. The subgraph can be configured with a tool selection strategy to control the tools available during its execution.

- llmModel — Initial LLM model used in this subgraph
- llmParams — Initial LLM prompt parameters used in this subgraph
- responseProcessor — Initial optional processor defining the post-processing of messages returned from the LLM.
- Input — The input type expected by the starting node of the subgraph.
- Output — The output type produced by the finishing node of the subgraph.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilder.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder/name.html`

### :agents:agents-core/commonMain

```kotlin
val name: String?
```

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilder.nodeFinish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder/node-finish.html`

### :agents:agents-core/commonMain

```kotlin
open override val nodeFinish: FinishNode<Output>
```

Represents the "finish" node in the AI agent's subgraph structure. This node indicates the endpoint of the subgraph and acts as a terminal stage where the workflow stops.

The nodeFinish property is an abstract member that subclasses must define. It is of type FinishAIAgentNodeBase, which is a specialized node that directly passes its input to its output without modification as part of an identity operation.

This node does not allow outgoing edges and cannot be linked further in the graph. It serves as the final node responsible for receiving and producing data of the defined output type.

- Output — The type of data processed and produced by this node.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilder.nodeStart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder/node-start.html`

### :agents:agents-core/commonMain

```kotlin
open override val nodeStart: StartNode<Input>
```

Represents the starting node of the subgraph in the AI agent's strategy graph.

This property holds a reference to a StartAIAgentNodeBase instance, which acts as the entry point for the subgraph. It is used to define the initial step in the processing pipeline for input data and is integral to the construction of the subgraph.

- Input — The type of input data that this starting node processes.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase.AIAgentSubgraphBuilderBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder-base/-a-i-agent-subgraph-builder-base.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

- Input — The input type expected by the starting node of the subgraph.
- Output — The output type produced by the finishing node of the subgraph.
## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase.edge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder-base/edge.html`

### :agents:agents-core/commonMain

```kotlin
fun <IncomingOutput, OutgoingInput, CompatibleOutput : OutgoingInput> edge(edgeIntermediate: AIAgentEdgeBuilderIntermediate<IncomingOutput, CompatibleOutput, OutgoingInput>)
```

Creates an edge between nodes.

- edgeIntermediate — Intermediate edge builder
## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentSubgraphBuilderBase<Input, Output>
```

Abstract base class for building AI agent subgraphs.

This class provides utilities for defining and connecting nodes within a subgraph, constructing custom subgraphs with specified tools or tool selection strategies, and managing the structural relationships between subgraph nodes.

- Input — The input type expected by the starting node of the subgraph.
- Output — The output type produced by the finishing node of the subgraph.
- AIAgentGraphStrategyBuilder
- AIAgentSubgraphBuilder
## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase.nodeFinish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder-base/node-finish.html`

### :agents:agents-core/commonMain

```kotlin
abstract val nodeFinish: FinishNode<Output>
```

Represents the "finish" node in the AI agent's subgraph structure. This node indicates the endpoint of the subgraph and acts as a terminal stage where the workflow stops.

The nodeFinish property is an abstract member that subclasses must define. It is of type FinishAIAgentNodeBase, which is a specialized node that directly passes its input to its output without modification as part of an identity operation.

This node does not allow outgoing edges and cannot be linked further in the graph. It serves as the final node responsible for receiving and producing data of the defined output type.

- Output — The type of data processed and produced by this node.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase.nodeStart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder-base/node-start.html`

### :agents:agents-core/commonMain

```kotlin
abstract val nodeStart: StartNode<Input>
```

Represents the starting node of the subgraph in the AI agent's strategy graph.

This property holds a reference to a StartAIAgentNodeBase instance, which acts as the entry point for the subgraph. It is used to define the initial step in the processing pipeline for input data and is integral to the construction of the subgraph.

- Input — The type of input data that this starting node processes.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase.then

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-builder-base/then.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <IncomingOutput, OutgoingInput, OutgoingOutput> AIAgentNodeBase<IncomingOutput, OutgoingInput>.then(nextNode: AIAgentNodeBase<OutgoingInput, OutgoingOutput>): AIAgentNodeBase<OutgoingInput, OutgoingOutput>
```

Connects the sequence of nodes with edges between them.

The next node

- nextNode — Node to connect to

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.node

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/node.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> node(name: String? = null, noinline execute: suspend AIAgentGraphContextBase.(input: Input) -> Output): AIAgentNodeDelegate<Input, Output>
```


Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> node(name: String? = null, inputType: TypeToken, outputType: TypeToken, execute: suspend AIAgentGraphContextBase.(input: Input) -> Output): AIAgentNodeDelegate<Input, Output>
```

Defines a new node in the agent's stage, representing a unit of execution that takes an input and produces an output.

- name — An optional name for the node. If not provided, the property name of the delegate will be used.
- execute — A suspendable function that defines the node's execution logic.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/strategy.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> strategy(name: String, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, init: AIAgentGraphStrategyBuilder<Input, Output>.() -> Unit): AIAgentGraphStrategy<Input, Output>
```

Builds a local AI agent that processes user input through a sequence of stages.

The agent executes a series of stages in sequence, with each stage receiving the output of the previous stage as its input.

- init — Lambda that defines stages and nodes of this agent

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.subgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/subgraph.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> subgraph(name: String? = null, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: LLModel? = null, llmParams: LLMParams? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, define: AIAgentSubgraphBuilderBase<Input, Output>.() -> Unit): AIAgentSubgraphDelegate<Input, Output>
```


Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
fun <Input : Any, Output : Any> subgraph(name: String? = null, inputType: TypeToken, outputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: LLModel? = null, llmParams: LLMParams? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, define: AIAgentSubgraphBuilderBase<Input, Output>.() -> Unit): AIAgentSubgraphDelegate<Input, Output>
```

Creates a subgraph with a specified tool selection strategy.

- name — Optional subgraph name
- toolSelectionStrategy — Strategy for tool selection
- llmModel — Initial LLM model used in this subgraph
- llmParams — Initial LLM prompt parameters used in this subgraph
- responseProcessor — Initial optional processor defining the post-processing of messages returned from the LLM.
- define — Subgraph definition function

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> subgraph(name: String? = null, tools: List<ToolBase<*, *>>, llmModel: LLModel? = null, llmParams: LLMParams? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, define: AIAgentSubgraphBuilderBase<Input, Output>.() -> Unit): AIAgentSubgraphDelegate<Input, Output>
```

Creates a subgraph with specified tools.

- name — Optional subgraph name
- tools — List of tools available to the subgraph
- llmModel — Initial LLM model used in this subgraph
- llmParams — Initial LLM prompt parameters used in this subgraph
- responseProcessor — Initial optional processor defining the post-processing of messages returned from the LLM.
- define — Subgraph definition function

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.dsl.extension.ReceivedToolResults.ReceivedToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-received-tool-results/-received-tool-results.html`

### :agents:agents-core/commonMain

```kotlin
constructor(toolResults: List<ReceivedToolResult>)
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.extension.ReceivedToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-received-tool-results/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ReceivedToolResults(val toolResults: List<ReceivedToolResult>)
```

Wraps a list of ReceivedToolResult values returned by the agent environment after tool execution.


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.extension.ReceivedToolResults.toolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-received-tool-results/tool-results.html`

### :agents:agents-core/commonMain

```kotlin
val toolResults: List<ReceivedToolResult>
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.extension.ToolCalls.ToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-tool-calls/-tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
constructor(toolCalls: List<MessagePart.Tool.Call>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-tool-calls/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ToolCalls(val toolCalls: List<MessagePart.Tool.Call>)
```

Wraps a list of pending tool calls produced by an LLM response.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ToolCalls.toolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-tool-calls/tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
val toolCalls: List<MessagePart.Tool.Call>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeAppendPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-append-prompt.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> nodeAppendPrompt(name: String? = null, noinline body: PromptBuilder.() -> Unit): AIAgentNodeDelegate<T, T>
```

A node that adds messages to the LLM prompt using the provided prompt builder. The input is passed as it is to the output.

- name — Optional node name, defaults to delegate's property name.
- body — Lambda to modify the prompt using PromptBuilder.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.dsl`.

## ai.koog.agents.core.dsl.extension.nodeDoNothing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-do-nothing.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> nodeDoNothing(name: String? = null): AIAgentNodeDelegate<T, T>
```

A pass-through node that does nothing and returns input as output

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.core.dsl.extension.nodeExecuteSingleTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-execute-single-tool.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeExecuteSingleTool(name: String? = null, parallel: Boolean = false): AIAgentNodeDelegate<MessagePart.Tool.Call, ReceivedToolResult>
```

A node that executes a single MessagePart.Tool.Call and returns the ReceivedToolResult without writing anything into the LLM session.

- name — Optional node name, defaults to delegate's property name.
- parallel — Unused in the single-tool variant; kept for API consistency.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
inline fun <ToolArg, TResult> nodeExecuteSingleTool(name: String? = null, tool: Tool<ToolArg, TResult>, doAppendPrompt: Boolean = true): AIAgentNodeDelegate<ToolArg, SafeTool.Result<TResult>>
```

A node that calls a specific tool directly using the provided arguments.

- name — Optional node name.
- tool — The tool to execute.
- doAppendPrompt — Specifies whether to add tool call details to the prompt.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

## ai.koog.agents.core.dsl.extension.nodeExecuteTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-execute-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeExecuteTools(name: String? = null, parallel: Boolean = false): AIAgentNodeDelegate<ToolCalls, ReceivedToolResults>
```

A node that executes the tool calls in a ToolCalls input and returns the raw ReceivedToolResults without writing them into the LLM session.

- name — Optional node name, defaults to delegate's property name.
- parallel — If true, all tool calls are executed concurrently; otherwise they run sequentially.

Referenced packages: `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.core.dsl.extension.nodeLLMCompressHistory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-compress-history.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> nodeLLMCompressHistory(name: String? = null, strategy: HistoryCompressionStrategy = HistoryCompressionStrategy.WholeHistory, retrievalModel: LLModel? = null, preserveMemory: Boolean = true): AIAgentNodeDelegate<T, T>
```

A node that compresses the current LLM prompt (message history) into a summary, replacing messages with a TLDR.

- name — Optional node name.
- strategy — Determines which messages to include in compression.
- retrievalModel — An optional LLModel that will be used for retrieval of the facts from memory. By default, the same model will be used as the current one in the agent's strategy.
- preserveMemory — Specifies whether to retain message memory after compression.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequestForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMRequestForceOneTool(name: String? = null, tool: ToolDescriptor): AIAgentNodeDelegate<String, Message.Assistant>
```

A node that appends a user text message to the prompt and requests a response from the LLM, forcing it to call exactly the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The descriptor of the tool the LLM must call.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequestOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMRequestOnlyCallingTools(name: String? = null): AIAgentNodeDelegate<String, Message.Assistant>
```

A node that appends a user text message to the prompt and requests a response from the LLM, forcing it to call one of the available tools (no plain-text replies allowed).

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequestStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request-streaming.html`

### :agents:agents-core/commonMain

```kotlin
fun <T> nodeLLMRequestStreaming(name: String? = null, structureDefinition: StructureDefinition? = null, transformStreamData: suspend (Flow<StreamFrame>) -> Flow<T>): AIAgentNodeDelegate<String, Flow<T>>
```

A node that appends a user text message to the prompt and requests a streaming response from the LLM, applying transformStreamData to convert the raw StreamFrame flow into a flow of T.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — An optional structure definition to guide the streaming response format.
- transformStreamData — A suspend function that transforms the StreamFrame flow into a Flow of T.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMRequestStreaming(name: String? = null, structureDefinition: StructureDefinition? = null): AIAgentNodeDelegate<String, Flow<StreamFrame>>
```

A node that appends a user text message to the prompt and requests a streaming response from the LLM, returning raw StreamFrame elements.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — An optional structure definition to guide the streaming response format.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequestStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request-structured.html`

### :agents:agents-core/commonMain

```kotlin
fun <T> nodeLLMRequestStructured(name: String? = null, config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): AIAgentNodeDelegate<String, Result<StructuredResponse<T>>>
```

A node that appends a user text message to the prompt and requests a structured response from the LLM using the provided config.

- name — Optional node name, defaults to delegate's property name.
- config — Configuration describing the expected structured output format.
- fixingParser — An optional parser used to attempt recovery if the LLM returns malformed structured output.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
inline fun <T> nodeLLMRequestStructured(name: String? = null, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): AIAgentNodeDelegate<String, Result<StructuredResponse<T>>>
```

A node that appends a user text message to the prompt and requests a structured response from the LLM, inferring the output schema from the reified type T.

- name — Optional node name, defaults to delegate's property name.
- examples — Optional list of example values of type T to guide the LLM's output.
- fixingParser — An optional parser used to attempt recovery if the LLM returns malformed structured output.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequestWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMRequestWithoutTools(name: String? = null): AIAgentNodeDelegate<String, Message.Assistant>
```

A node that appends a user text message to the prompt and requests a response from the LLM, without exposing any tools (pure text response only).

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequest

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMRequest(name: String? = null): AIAgentNodeDelegate<String, Message.Assistant>
```

A node that appends a user text message to the prompt and requests a response from the LLM.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessageStructured

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message-structured.html`

### :agents:agents-core/commonMain

```kotlin
fun <T> nodeLLMSendMessageStructured(name: String? = null, config: StructuredRequestConfig<T>, fixingParser: StructureFixingParser? = null): AIAgentNodeDelegate<Message.User, Result<StructuredResponse<T>>>
```

A node that appends a Message.User to the prompt and requests a structured response from the LLM using the provided config.

- name — Optional node name, defaults to delegate's property name.
- config — Configuration describing the expected structured output format.
- fixingParser — An optional parser used to attempt recovery if the LLM returns malformed structured output.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
inline fun <T> nodeLLMSendMessageStructured(name: String? = null, examples: List<T> = emptyList(), fixingParser: StructureFixingParser? = null): AIAgentNodeDelegate<Message.User, Result<StructuredResponse<T>>>
```

A node that appends a Message.User to the prompt and requests a structured response from the LLM, inferring the output schema from the reified type T.

- name — Optional node name, defaults to delegate's property name.
- examples — Optional list of example values of type T to guide the LLM's output.
- fixingParser — An optional parser used to attempt recovery if the LLM returns malformed structured output.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.message`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendMessage(name: String? = null): AIAgentNodeDelegate<Message.User, Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendToolResultsWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-tool-results-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendToolResultsWithoutTools(name: String? = null): AIAgentNodeDelegate<ReceivedToolResults, Message.Assistant>
```

A node that appends tool results from ReceivedToolResults to the prompt as a user message and requests a follow-up response from the LLM, without exposing any tools (pure text response only).

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-tool-results.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendToolResults(name: String? = null): AIAgentNodeDelegate<ReceivedToolResults, Message.Assistant>
```

A node that appends tool results from ReceivedToolResults to the prompt as a user message and requests a follow-up response from the LLM.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeSetStructuredOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-set-structured-output.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <TInput, T> nodeSetStructuredOutput(name: String? = null, config: StructuredRequestConfig<T>): AIAgentNodeDelegate<TInput, TInput>
```

Creates a node that sets up a structured output for an AI agent subgraph.

The method defines a new node with a configurable structured output schema that will be applied during the AI agent's message processing. The schema is determined by the given configuration.

An instance of AIAgentNodeDelegate representing the constructed node.

- name — An optional name for the node. If null, a default name will be assigned.
- config — The configuration that defines the structured output format and schema.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.onFailure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-failure.html`

### :agents:agents-core/commonMain

```kotlin
infix inline fun <IncomingOutput, OutgoingInput, TResult> AIAgentEdgeBuilderIntermediate<IncomingOutput, SafeTool.Result<TResult>, OutgoingInput>.onFailure(crossinline condition: suspend (error: String) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, SafeTool.Result.Failure<TResult>, OutgoingInput>
```

Defines a handler to process failure cases in a directed edge strategy by applying a condition to filter intermediate results of type SafeTool.Result.Failure. This method is used to specialize processing for failure results and to propagate or transform them based on the provided condition.

A new instance of AIAgentEdgeBuilderIntermediate, where the intermediate output type is restricted to SafeTool.Result.Failure containing the specified TResult for failure results that match the condition.

- condition — A suspending lambda function that takes an error message string as input and returns a boolean. It specifies whether the error should be further processed based on the condition provided.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.extension.onIsInstance

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-is-instance.html`

### :agents:agents-core/commonMain

```kotlin
infix inline fun <IncomingOutput, IntermediateOutput, OutgoingInput, T : Any> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.onIsInstance(klass: KClass<T>): AIAgentEdgeBuilderIntermediate<IncomingOutput, T, OutgoingInput>
```

Creates an edge that filters outputs based on their type.

- klass — The class to check instance against (not actually used, see implementation comment)

Referenced packages: `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.core.dsl.extension.onMessageParts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-message-parts.html`

### :agents:agents-core/commonMain

```kotlin
infix inline fun <IncomingOutput, IntermediateOutput, OutgoingInput, T : MessagePart> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.onMessageParts(klass: KClass<T>): AIAgentEdgeBuilderIntermediate<IncomingOutput, List<T>, OutgoingInput>
```

Creates an edge that filters outputs based on their MessagePart subtype.

- klass — The MessagePart subclass to filter against

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.onSuccessful

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-successful.html`

### :agents:agents-core/commonMain

```kotlin
infix inline fun <IncomingOutput, OutgoingInput, TResult> AIAgentEdgeBuilderIntermediate<IncomingOutput, SafeTool.Result<TResult>, OutgoingInput>.onSuccessful(crossinline condition: suspend (TResult) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, SafeTool.Result.Success<TResult>, OutgoingInput>
```

Filters and transforms the intermediate outputs of the AI agent node based on the success results of a tool operation.

This method is used to create a conditional path in the agent's execution by selecting only the successful results of type SafeTool.Result.Success and evaluating them against a provided condition.

An instance of AIAgentEdgeBuilderIntermediate configured to handle only successful tool results that satisfy the specified condition, with output type adjusted to SafeTool.Result.Success.

- condition — A suspending lambda function that accepts a result of type TResult and evaluates it to a Boolean value. Returns true if the condition is satisfied, and false otherwise.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.extension.onTextMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-text-message.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <IncomingOutput, IntermediateOutput, OutgoingInput> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.onTextMessage(block: suspend (MessagePart.Text) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, String, OutgoingInput>
```

Creates an edge that transforms an intermediate output into a Message.User using the provided transform.

- block — A function that converts the intermediate output to a String for the user message.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.onToolCall

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-tool-call.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <IncomingOutput, IntermediateOutput, OutgoingInput, Args> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.onToolCall(tool: Tool<Args, *>, crossinline block: suspend (Args) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, MessagePart.Tool.Call, OutgoingInput>
```

Creates an edge that filters tool call messages for a specific tool and arguments condition.

- tool — The tool to match against
- block — A function that evaluates the tool arguments to determine if the edge should accept the message

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
infix fun <IncomingOutput, IntermediateOutput, OutgoingInput> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.onToolCall(tool: Tool<*, *>): AIAgentEdgeBuilderIntermediate<IncomingOutput, MessagePart.Tool.Call, OutgoingInput>
```

Creates an edge that filters tool call messages for a specific tool.

- tool — The tool to match against

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.onToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/on-tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <IncomingOutput, IntermediateOutput, OutgoingInput> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.onToolCalls(block: suspend (MessagePart.Tool.Call) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, ToolCalls, OutgoingInput>
```

Creates an edge that filters assistant messages containing tool calls, based on a custom condition. The default condition onToolCalls { true } will create a conditional edge checking that there at list one tool call The custom condition onToolCalls { it.tool == "exit" } will create a conditional edge checking that there is tool call with the name "exit"

- block — A function that evaluates whether to accept the tool call

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.
