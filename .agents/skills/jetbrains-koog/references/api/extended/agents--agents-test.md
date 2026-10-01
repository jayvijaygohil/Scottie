# agents / agents-test

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.testing.agent.agentExecutionInfo

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.agent/agent-execution-info.html`

### :agents:agents-test/commonMain

```kotlin
fun agentExecutionInfo(vararg parts: String): AgentExecutionInfo
```

Constructs an AgentExecutionInfo instance from the provided path components.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.testing.agent.agentExecutionPath

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.agent/agent-execution-path.html`

### :agents:agents-test/commonMain

```kotlin
fun agentExecutionPath(vararg parts: String): String
```

Constructs an execution path for an agent by joining the provided path components using the default path separator.

A string representing the fully constructed execution path.

- parts — A variable number of path components that should be joined to create the execution path.
## ai.koog.agents.testing.feature.AssertionResult.False.False

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-false/-false.html`

### :agents:agents-test/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.testing.feature.AssertionResult.False

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-false/index.html`

### :agents:agents-test/commonMain

```kotlin
class False(val message: String) : AssertionResult
```

Represents an assertion result indicating a failed assertion due to a false condition.

This class is used when a boolean condition evaluates to false during an assertion. It encapsulates an error message describing the failure.

## ai.koog.agents.testing.feature.AssertionResult.False.message

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-false/message.html`

### :agents:agents-test/commonMain

```kotlin
val message: String
```

## ai.koog.agents.testing.feature.AssertionResult.NotEqual.NotEqual

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-not-equal/-not-equal.html`

### :agents:agents-test/commonMain

```kotlin
constructor(expected: Any?, actual: Any?, message: String)
```

- expected — The expected value in the comparison.
- actual — The actual value found during the comparison.
- message — A custom message explaining why the assertion failed.
## ai.koog.agents.testing.feature.AssertionResult.NotEqual.actual

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-not-equal/actual.html`

### :agents:agents-test/commonMain

```kotlin
val actual: Any?
```

- actual — The actual value found during the comparison.
## ai.koog.agents.testing.feature.AssertionResult.NotEqual.expected

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-not-equal/expected.html`

### :agents:agents-test/commonMain

```kotlin
val expected: Any?
```

- expected — The expected value in the comparison.
## ai.koog.agents.testing.feature.AssertionResult.NotEqual

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-not-equal/index.html`

### :agents:agents-test/commonMain

```kotlin
class NotEqual(val expected: Any?, val actual: Any?, val message: String) : AssertionResult
```

Represents the result of a failed equality assertion.

This class is used to specify details about the expected and actual values when an equality assertion fails. The failure may include an optional message providing additional context.

- expected — The expected value in the comparison.
- actual — The actual value found during the comparison.
- message — A custom message explaining why the assertion failed.
## ai.koog.agents.testing.feature.AssertionResult.NotEqual.message

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/-not-equal/message.html`

### :agents:agents-test/commonMain

```kotlin
val message: String
```

- message — A custom message explaining why the assertion failed.
## ai.koog.agents.testing.feature.AssertionResult

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-assertion-result/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly sealed interface AssertionResult
```

Represents the result of an assertion used within the testing framework.

This sealed interface allows defining various outcomes of assertions, such as inequality or false conditions.

- NotEqual
- False
## ai.koog.agents.testing.feature.EdgeAssertion.EdgeAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-edge-assertion/-edge-assertion.html`

### :agents:agents-test/commonMain

```kotlin
constructor(node: NodeReference<Input, Output>, context: AIAgentGraphContextBase, output: Output, expectedNode: NodeReference<*, *>)
```

- Input — The type of the input parameter for the node.
- Output — The type of the output parameter for the node.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.feature.EdgeAssertion.context

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-edge-assertion/context.html`

### :agents:agents-test/commonMain

```kotlin
val context: AIAgentGraphContextBase
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.feature.EdgeAssertion.expectedNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-edge-assertion/expected-node.html`

### :agents:agents-test/commonMain

```kotlin
val expectedNode: NodeReference<*, *>
```

## ai.koog.agents.testing.feature.EdgeAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-edge-assertion/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly data class EdgeAssertion<Input, Output>(val node: NodeReference<Input, Output>, val context: AIAgentGraphContextBase, val output: Output, val expectedNode: NodeReference<*, *>)
```

Represents the assertion of an edge in a graph structure related to AI agent operations.

- Input — The type of the input parameter for the node.
- Output — The type of the output parameter for the node.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.feature.EdgeAssertion.node

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-edge-assertion/node.html`

### :agents:agents-test/commonMain

```kotlin
val node: NodeReference<Input, Output>
```

## ai.koog.agents.testing.feature.EdgeAssertion.output

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-edge-assertion/output.html`

### :agents:agents-test/commonMain

```kotlin
val output: Output
```

## ai.koog.agents.testing.feature.NodeOutputAssertion.NodeOutputAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-output-assertion/-node-output-assertion.html`

### :agents:agents-test/commonMain

```kotlin
constructor(node: NodeReference<Input, Output>, context: DummyAIAgentContext, input: Input, expectedOutput: Output)
```

- Input — The type of the input data that the node processes.
- Output — The type of the output data produced by the node.

Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.NodeOutputAssertion.context

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-output-assertion/context.html`

### :agents:agents-test/commonMain

```kotlin
val context: DummyAIAgentContext
```


Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.NodeOutputAssertion.expectedOutput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-output-assertion/expected-output.html`

### :agents:agents-test/commonMain

```kotlin
val expectedOutput: Output
```

## ai.koog.agents.testing.feature.NodeOutputAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-output-assertion/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly data class NodeOutputAssertion<Input, Output>(val node: NodeReference<Input, Output>, val context: DummyAIAgentContext, val input: Input, val expectedOutput: Output)
```

Represents an assertion for testing the output of a specific node within an AI agent's subgraph.

This class is intended to be used for verifying that a node, when executed in a specific agent context with a given input, produces the expected output.

- Input — The type of the input data that the node processes.
- Output — The type of the output data produced by the node.

Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.NodeOutputAssertion.input

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-output-assertion/input.html`

### :agents:agents-test/commonMain

```kotlin
val input: Input
```

## ai.koog.agents.testing.feature.NodeOutputAssertion.node

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-output-assertion/node.html`

### :agents:agents-test/commonMain

```kotlin
val node: NodeReference<Input, Output>
```

## ai.koog.agents.testing.feature.NodeReference.Finish.Finish

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-finish/-finish.html`

### :agents:agents-test/commonMain

```kotlin
constructor()
```

- Output — The type of output data produced by this finish node.
## ai.koog.agents.testing.feature.NodeReference.Finish

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-finish/index.html`

### :agents:agents-test/commonMain

```kotlin
class Finish<Output> : NodeReference<Output, Output>
```

Represents the final node in an AI agent subgraph workflow. The Finish node signifies the end of the processing within the subgraph and provides the result of the subgraph's operations.

- Output — The type of output data produced by this finish node.
## ai.koog.agents.testing.feature.NodeReference.Finish.resolve

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-finish/resolve.html`

### :agents:agents-test/commonMain

```kotlin
open override fun resolve(subgraph: AIAgentSubgraphBase<*, *>): AIAgentNodeBase<Output, Output>
```

Resolves and returns the finishing node of the given AI agent subgraph.

The finishing node of the subgraph, cast to the expected type AIAgentNodeBase<Output, Output>.

- subgraph — The AI agent subgraph from which the finishing node is resolved.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.NodeReference.NamedNode.NamedNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-named-node/-named-node.html`

### :agents:agents-test/commonMain

```kotlin
constructor(name: String)
```

- Input — The type of input accepted by the node.
- Output — The type of output produced by the node.
## ai.koog.agents.testing.feature.NodeReference.NamedNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-named-node/index.html`

### :agents:agents-test/commonMain

```kotlin
open class NamedNode<Input, Output>(val name: String) : NodeReference<Input, Output>
```

NamedNode is a class that references a specific node within a subgraph by name. This class allows resolving a node instance by its unique name within a given subgraph.

- Input — The type of input accepted by the node.
- Output — The type of output produced by the node.
- SubgraphNode
## ai.koog.agents.testing.feature.NodeReference.NamedNode.name

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-named-node/name.html`

### :agents:agents-test/commonMain

```kotlin
val name: String
```

## ai.koog.agents.testing.feature.NodeReference.NamedNode.resolve

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-named-node/resolve.html`

### :agents:agents-test/commonMain

```kotlin
open override fun resolve(subgraph: AIAgentSubgraphBase<*, *>): AIAgentNodeBase<Input, Output>
```

Resolves a node within the given AI Agent subgraph by searching for a node that matches the current node's name. The method performs a depth-first traversal starting from the subgraph's start node.

The resolved node that matches the current node's name of a type AIAgentNodeBase.

- subgraph — The AI Agent subgraph to traverse in search of the matching node.
- IllegalArgumentException — If no node with the specified name is found within the subgraph.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.NodeReference.Start.Start

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-start/-start.html`

### :agents:agents-test/commonMain

```kotlin
constructor()
```

- Input — The type of input data that this node reference accepts and processes.
## ai.koog.agents.testing.feature.NodeReference.Start

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-start/index.html`

### :agents:agents-test/commonMain

```kotlin
class Start<Input> : NodeReference<Input, Input>
```

The Start class is a specialized type of NodeReference that serves as a reference to the starting node of an AIAgentSubgraph. This node initiates the processing of the subgraph by resolving and returning the subgraph's starting node.

- Input — The type of input data that this node reference accepts and processes.
## ai.koog.agents.testing.feature.NodeReference.Start.resolve

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-start/resolve.html`

### :agents:agents-test/commonMain

```kotlin
open override fun resolve(subgraph: AIAgentSubgraphBase<*, *>): AIAgentNodeBase<Input, Input>
```

Resolves the starting node of the given subgraph and casts it to the appropriate type.

The starting node of the subgraph cast to AIAgentNodeBase.

- subgraph — The subgraph from which the starting node will be resolved.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.NodeReference.Strategy.Strategy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-strategy/-strategy.html`

### :agents:agents-test/commonMain

```kotlin
constructor(name: String)
```

- name — The unique identifier for the strategy.
## ai.koog.agents.testing.feature.NodeReference.Strategy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-strategy/index.html`

### :agents:agents-test/commonMain

```kotlin
class Strategy<Input, Output>(name: String) : NodeReference.SubgraphNode<Input, Output>
```

Represents a specific strategy within an AI agent subgraph.

The Strategy class is a specialization of the SubgraphNode class designed to focus on resolving and managing AIAgentStrategy instances. It provides a mechanism to ensure the resolution process evaluates to the expected strategy type, preserving type safety and logical consistency within the graph-based AI workflow.

- name — The unique identifier for the strategy.
## ai.koog.agents.testing.feature.NodeReference.Strategy.resolve

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-strategy/resolve.html`

### :agents:agents-test/commonMain

```kotlin
open override fun resolve(subgraph: AIAgentSubgraphBase<*, *>): AIAgentGraphStrategyBase<Input, Output>
```

Resolves the given subgraph into an AIAgentStrategy instance to ensure that the resolved object matches the expected strategy name and type.

The resolved subgraph as an instance of AIAgentStrategy.

- subgraph — The subgraph to be resolved. It must have the same name as the current strategy instance and must also be of type AIAgentStrategy.
- IllegalArgumentException — If the subgraph's name does not match the name of the current strategy.
- IllegalStateException — If the subgraph is not of type AIAgentStrategy.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.NodeReference.SubgraphNode.SubgraphNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-subgraph-node/-subgraph-node.html`

### :agents:agents-test/commonMain

```kotlin
constructor(name: String)
```

- name — The name of the node, inherited from the parent class, which serves as its identifier within the graph.
- Input — The input type that this node expects.
- Output — The output type that this node produces.
## ai.koog.agents.testing.feature.NodeReference.SubgraphNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-subgraph-node/index.html`

### :agents:agents-test/commonMain

```kotlin
open class SubgraphNode<Input, Output>(name: String) : NodeReference.NamedNode<Input, Output>
```

Represents a specialized type of node used in the context of AI agent subgraphs. This class extends the functionality of a named node by providing specific behavior to resolve itself as a valid subgraph within the overarching system.

- name — The name of the node, inherited from the parent class, which serves as its identifier within the graph.
- Input — The input type that this node expects.
- Output — The output type that this node produces.
- Strategy
## ai.koog.agents.testing.feature.NodeReference.SubgraphNode.resolve

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/-subgraph-node/resolve.html`

### :agents:agents-test/commonMain

```kotlin
open override fun resolve(subgraph: AIAgentSubgraphBase<*, *>): AIAgentSubgraphBase<Input, Output>
```

Resolves the specified subgraph into a strongly typed subgraph of the expected input and output types. This method ensures the resolved subgraph matches the type constraints of the current node.

The resolved subgraph of type AIAgentSubgraph<Input, Output>.

- subgraph — The subgraph to resolve. This represents a structured portion of an AI agent workflow.
- IllegalArgumentException — If the resolved subgraph does not match the expected type constraints.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.NodeReference

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly sealed class NodeReference<Input, Output>
```

Represents a reference to a specific type of node within an AI agent subgraph. This sealed class provides a way to resolve and identify nodes for various processing operations in the context of a subgraph.

- Input — The input data type handled by the related node.
- Output — The output data type produced by the related node.
- Start
- Finish
- NamedNode
## ai.koog.agents.testing.feature.NodeReference.resolve

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-node-reference/resolve.html`

### :agents:agents-test/commonMain

```kotlin
abstract fun resolve(subgraph: AIAgentSubgraphBase<*, *>): AIAgentNodeBase<Input, Output>
```

Resolves the current node reference within the context of the provided AI agent subgraph.

An instance of AIAgentNodeBase, representing the resolved node within the subgraph that corresponds to the current node reference.

- subgraph — An instance of AIAgentSubgraph, representing the structured subgraph within the AI agent workflow. It contains the logical segment of processing, including the starting and finishing nodes.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.ReachabilityAssertion.ReachabilityAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-reachability-assertion/-reachability-assertion.html`

### :agents:agents-test/commonMain

```kotlin
constructor(from: NodeReference<*, *>, to: NodeReference<*, *>)
```

## ai.koog.agents.testing.feature.ReachabilityAssertion.from

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-reachability-assertion/from.html`

### :agents:agents-test/commonMain

```kotlin
val from: NodeReference<*, *>
```

## ai.koog.agents.testing.feature.ReachabilityAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-reachability-assertion/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly data class ReachabilityAssertion(val from: NodeReference<*, *>, val to: NodeReference<*, *>)
```

Represents an assertion for testing the reachability between two specific nodes in a graph.

This class is primarily used in graph-based testing contexts to verify that a directed path exists from a starting node (from) to a target node (to) within an agent graph.

## ai.koog.agents.testing.feature.ReachabilityAssertion.to

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-reachability-assertion/to.html`

### :agents:agents-test/commonMain

```kotlin
val to: NodeReference<*, *>
```

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.copy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/copy.html`

### :agents:agents-test/commonMain

```kotlin
open override fun copy(environment: AIAgentEnvironment? = this.environment, agentInput: Any? = this.agentInput, agentInputType: TypeToken? = this.agentInputType, config: AIAgentConfig? = this.config, llm: AIAgentLLMContext? = this.llm, stateManager: AIAgentStateManager? = this.stateManager, storage: AIAgentStorage? = this.storage, runId: String? = this.runId, strategyName: String? = this.strategyName, executionInfo: AgentExecutionInfo? = this.executionInfo): Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder
```

Creates a deep copy of the current EdgeAssertionsBuilder instance, duplicating its state and context.

A new EdgeAssertionsBuilder instance with the same stageBuilder and a copied context.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.serialization`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.copy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/copy.html`

### :agents:agents-test/commonMain

```kotlin
open override fun copy(environment: AIAgentEnvironment? = this.environment, agentInput: Any? = this.agentInput, agentInputType: TypeToken? = this.agentInputType, config: AIAgentConfig? = this.config, llm: AIAgentLLMContext? = this.llm, stateManager: AIAgentStateManager? = this.stateManager, storage: AIAgentStorage? = this.storage, runId: String? = this.runId, strategyName: String? = this.strategyName, executionInfo: AgentExecutionInfo? = this.executionInfo): Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder
```

Creates and returns a new copy of the NodeOutputAssertionsBuilder instance.

a new NodeOutputAssertionsBuilder that contains a copy of the current stageBuilder and a copied context.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.serialization`.

## ai.koog.agents.testing.feature.UnconditionalEdgeAssertion.UnconditionalEdgeAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-unconditional-edge-assertion/-unconditional-edge-assertion.html`

### :agents:agents-test/commonMain

```kotlin
constructor(node: NodeReference<*, *>, expectedNode: NodeReference<*, *>)
```

## ai.koog.agents.testing.feature.UnconditionalEdgeAssertion.expectedNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-unconditional-edge-assertion/expected-node.html`

### :agents:agents-test/commonMain

```kotlin
val expectedNode: NodeReference<*, *>
```

## ai.koog.agents.testing.feature.UnconditionalEdgeAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-unconditional-edge-assertion/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly data class UnconditionalEdgeAssertion(val node: NodeReference<*, *>, val expectedNode: NodeReference<*, *>)
```

Represents an assertion for an unconditional edge in a graph structure.

This data class is used to verify the existence of a direct connection from the node to the expectedNode in a graph during tests. Such connections are evaluated without considering any specific conditions or outputs, ensuring that the edge is universally established.

## ai.koog.agents.testing.feature.UnconditionalEdgeAssertion.node

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-unconditional-edge-assertion/node.html`

### :agents:agents-test/commonMain

```kotlin
val node: NodeReference<*, *>
```

## ai.koog.agents.testing.feature.message.findEvents

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature.message/find-events.html`

### :agents:agents-test/commonMain

```kotlin
inline fun <TEvent : FeatureMessage> List<FeatureMessage>.findEvents(): List<TEvent>
```

Filters the list of FeatureMessage for events of the specified type TEvent.

This method filters the invoking list to include only elements that are instances of the specified type TEvent, which must be a subclass of FeatureMessage. An assertion is performed to ensure that at least one event of the specified type is present. If no such event exists, an assertion error is thrown.

A list of events of type TEvent extracted from the invoking list.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.testing.feature.message.findNodeEvents

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature.message/find-node-events.html`

### :agents:agents-test/commonMain

```kotlin
fun List<FeatureMessage>.findNodeEvents(nodeName: String): List<NodeExecutionStartingEvent>
```

Filters a list of FeatureMessage instances to find events of type NodeExecutionStartingEvent associated with a specific node name.

This function ensures that at least one event of the desired type exists in the list and further ensures that events with the specified node name are found. Assertions will be triggered if the conditions are not met.

A list of NodeExecutionStartingEvent instances that match the provided node name.

- nodeName — The name of the node for which NodeExecutionStartingEvent instances are being searched.
- AssertionError — If no NodeExecutionStartingEvent is present in the list or if no event matches the specified node name.

Referenced packages: `ai.koog.agents.core.feature.message`, `ai.koog.agents.core.feature.model.events`.

## ai.koog.agents.testing.feature.message.singleEvent

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature.message/single-event.html`

### :agents:agents-test/commonMain

```kotlin
inline fun <TEvent : FeatureMessage> List<FeatureMessage>.singleEvent(): TEvent
```

Retrieves a single event of the specified type TEvent from a list of FeatureMessage.

This method ensures that there is exactly one event of the specified type TEvent present in the invoking list. If no event of the specified type exists, or if more than one such event is found, an assertion error is thrown. The method makes use of findEvents to filter the list for events of the given type and then asserts that the resulting list contains exactly one item.

The single event of type TEvent.

- AssertionError — if there are zero or more than one event of the specified type TEvent.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.testing.feature.message.singleNodeEvent

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature.message/single-node-event.html`

### :agents:agents-test/commonMain

```kotlin
fun List<FeatureMessage>.singleNodeEvent(nodeName: String): NodeExecutionStartingEvent
```

Returns a single NodeExecutionStartingEvent from the list of FeatureMessage instances for the specified node name.

This function filters the list to find events of type NodeExecutionStartingEvent matching the given node name and ensures that exactly one such event exists. If no event or more than one event matches the criteria, an exception is thrown.

The single NodeExecutionStartingEvent associated with the specified node name.

- nodeName — The name of the node for which a single NodeExecutionStartingEvent is required.
- AssertionError — If no event or multiple events matching the specified node name are found.

Referenced packages: `ai.koog.agents.core.feature.message`, `ai.koog.agents.core.feature.model.events`.

## ai.koog.agents.testing.network.NetUtil.findAvailablePort

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.network/-net-util/find-available-port.html`

### :agents:agents-test/jvmMain

```kotlin
fun findAvailablePort(): Int
```

Finds and returns an available port on the local machine.

This method opens a temporary server socket to identify an unused port and ensures that the port is released immediately after identification.

an integer representing an available port number on the local machine

## ai.koog.agents.testing.network.NetUtil

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.network/-net-util/index.html`

### :agents:agents-test/jvmMain

```kotlin
object NetUtil
```

Utility object providing network-related utility functions.

## ai.koog.agents.testing.network.NetUtil.isPortAvailable

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.network/-net-util/is-port-available.html`

### :agents:agents-test/jvmMain

```kotlin
fun isPortAvailable(port: Int): Boolean
```

Check if a specified port is available.

Throwable instance received from ServerSocket when try to bind the port, or NULL otherwise if port is free.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.AIAgentContextMockBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/-a-i-agent-context-mock-builder.html`

### :agents:agents-test/commonMain

```kotlin
constructor()
```

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.ProxyHandler.ProxyHandler

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/-proxy-handler/-proxy-handler.html`

### :agents:agents-test/commonMain

```kotlin
constructor(name: String)
```

- name — A string identifier associated with the proxy. This is used in placeholder implementation to display information about the proxy.
- T — The type of the proxy object to be created. Must be a non-abstract class.
## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.ProxyHandler.createProxy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/-proxy-handler/create-proxy.html`

### :agents:agents-test/commonMain

```kotlin
fun createProxy(): T
```

Creates a proxy instance of type T. The proxy is a dummy implementation that provides default behavior for overridden methods such as toString, equals, and unimplemented operations.

A proxy instance of type T with default, unimplemented functionality.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.ProxyHandler

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/-proxy-handler/index.html`

### :agents:agents-test/commonMain

```kotlin
class ProxyHandler<T : Any>(name: String)
```

ProxyHandler is a utility class that dynamically creates a proxy object of a specified type. The proxy implements default behavior for methods such as toString, equals, property access, and method invocation, providing a placeholder implementation.

This class is typically used to generate mock or dummy objects for testing or prototyping purposes.

- name — A string identifier associated with the proxy. This is used in placeholder implementation to display information about the proxy.
- T — The type of the proxy object to be created. Must be a non-abstract class.
## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.agentInputType

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/agent-input-type.html`

### :agents:agents-test/commonMain

```kotlin
open override var agentInputType: TypeToken?
```

Represents the TypeToken of the agentInput.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.agentInput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/agent-input.html`

### :agents:agents-test/commonMain

```kotlin
open override var agentInput: Any?
```

Represents the agent's input data used in constructing or testing the agent's context.

This property is optional and can be null, indicating that no specific input is provided for the agent. It is used during the construction or copying of an agent's context to define the data the agent operates on.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.build

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/build.html`

### :agents:agents-test/commonMain

```kotlin
open override fun build(): DummyAIAgentContext
```

Builds and returns an instance of DummyAgentContext.

This method finalizes the current configuration of the AIAgentContextMockBuilder instance by creating a copy of its current state and passing it to the constructor of DummyAgentContext.

A DummyAgentContext instance initialized with the current state of the builder.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.config

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/config.html`

### :agents:agents-test/commonMain

```kotlin
open override var config: AIAgentConfig?
```

Represents the AI agent configuration used in the mock builder.

This property holds the agent's configuration, which may include the parameters for prompts, the language model to be used, iteration limits, and strategies for handling missing tools. It is used in constructing or copying an AI agent context during testing or mock setup.

The configuration, represented by AIAgentConfig, can be modified or replaced depending on the requirements of the mock or testing scenario. A null value indicates the absence of a specific configuration.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.copy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/copy.html`

### :agents:agents-test/commonMain

```kotlin
open override fun copy(environment: AIAgentEnvironment? = this.environment, agentInput: Any? = this.agentInput, agentInputType: TypeToken? = this.agentInputType, config: AIAgentConfig? = this.config, llm: AIAgentLLMContext? = this.llm, stateManager: AIAgentStateManager? = this.stateManager, storage: AIAgentStorage? = this.storage, runId: String? = this.runId, strategyName: String? = this.strategyName, executionInfo: AgentExecutionInfo? = this.executionInfo): AIAgentContextMockBuilder
```

Creates and returns a new copy of the current AIAgentContextMockBuilder instance. The copied instance contains the same state and configuration as the original.

a new AIAgentContextMockBuilder instance with the same properties as the original.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.environment

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/environment.html`

### :agents:agents-test/commonMain

```kotlin
open override var environment: AIAgentEnvironment?
```

Represents the AI agent's environment in which the context is being executed.

This property allows setting or retrieving the AIAgentEnvironment instance associated with the builder, enabling the integration of external environments. The environment provides mechanisms for tool execution, error reporting, and communication of termination signals.

It is nullable, as the environment may not always be defined during initialization.

- AIAgentEnvironment

Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.executionInfo

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/execution-info.html`

### :agents:agents-test/commonMain

```kotlin
open override var executionInfo: AgentExecutionInfo?
```

Represents execution-specific context information for the mock AI agent builder. This variable allows tracking and observability of the agent's execution flow.

By leveraging the properties defined in AgentExecutionInfo, this information aids in linking, tracing, and managing execution paths throughout the agent's lifecycle.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly class AIAgentContextMockBuilder : AIAgentContextMockBuilderBase
```

AIAgentContextMockBuilder is a builder class for constructing a mock implementation of an AI agent context. It provides mechanisms to configure various components of the AI agent context before constructing it. This class is intended for use in testing scenarios and extends AIAgentContextMockBuilderBase.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.llm

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/llm.html`

### :agents:agents-test/commonMain

```kotlin
open override var llm: AIAgentLLMContext?
```

Represents the context for accessing and managing an AI agent's LLM (Large Language Model) configuration and behavior. The llm property allows you to define or override the LLM context for the agent, including tools, prompt handling, and interaction with external dependencies.

Can be used for dependency injection, mock testing, or modifying the LLM behavior dynamically during runtime. If set to null, it indicates that no specific LLM context is defined, and defaults or fallback mechanisms may be used by the containing class.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.runId

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/run-id.html`

### :agents:agents-test/commonMain

```kotlin
open override var runId: String?
```

Defines the unique identifier for the session context within the agent's lifecycle. This property can be used to correlate and differentiate multiple sessions for the same agent or across different agents.

The runId can be null, indicating that the session has not been associated with an identifier.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.stateManager

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/state-manager.html`

### :agents:agents-test/commonMain

```kotlin
open override var stateManager: AIAgentStateManager?
```

An overrideable property for managing the agent's state using an instance of AIAgentStateManager.

The stateManager provides thread-safe mechanisms to update, lock, and access the internal state of the AI agent. It ensures the consistency of state modifications and employs a mutual exclusion mechanism to synchronize coroutines accessing the state.

This property can be used for customizing state management within the context of the AIAgentContextMockBuilder and its associated operations such as copying or building mock agent contexts.

By default, it is initialized to null and can be set or overridden to integrate a specific AIAgentStateManager instance for managing agent state in custom scenarios.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.storage

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/storage.html`

### :agents:agents-test/commonMain

```kotlin
open override var storage: AIAgentStorage?
```

Represents a concurrent-safe key-value storage instance for an AI agent.

This property holds a reference to an optional AIAgentStorage implementation, which enables the handling of typed keys and respective values in a thread-safe manner within the agent context. The storage can be used to store, retrieve, or manage custom data uniquely identified by specific keys.

It can be configured or overridden during the agent context setup or through later modifications to the context builder. If not provided, the default value remains null.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilder.strategyName

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder/strategy-name.html`

### :agents:agents-test/commonMain

```kotlin
open override var strategyName: String?
```

Represents the identifier for the strategy to be used in the agent context.

This property is used to distinguish and configure different strategies within an AI agent's workflow. It may determine how the agent processes inputs, selects methodologies, or executes tasks, depending on the applied strategy.

Can be null if a strategy is not explicitly defined or required.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.agentInputType

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/agent-input-type.html`

### :agents:agents-test/commonMain

```kotlin
abstract var agentInputType: TypeToken?
```

Represents the TypeToken of the agentInput.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.agentInput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/agent-input.html`

### :agents:agents-test/commonMain

```kotlin
abstract var agentInput: Any?
```

Represents the input to be used by the AI agent during its execution. This variable can be set to define specific data or context relevant to the agent's task. It is nullable, indicating that the agent may operate without an explicitly defined input.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.build

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/build.html`

### :agents:agents-test/commonMain

```kotlin
abstract override fun build(): AIAgentContext
```

Builds and returns an instance of AIAgentContext based on the current properties of the builder. This method creates a finalized AI agent context, integrating all the specified configurations, environment settings, and components into a coherent context object ready for use.

A fully constructed AIAgentContext instance representing the configured agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.config

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/config.html`

### :agents:agents-test/commonMain

```kotlin
abstract var config: AIAgentConfig?
```

Specifies the configuration for the AI agent.

This property allows setting an instance of AIAgentConfig, which defines various parameters and settings for the AI agent, such as the model, prompt structure, execution strategies, and constraints. It provides the core configuration required for the agent's setup and behavior.

If null, the configuration will not be explicitly defined, and the agent may rely on default or externally supplied configurations.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.copy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/copy.html`

### :agents:agents-test/commonMain

```kotlin
abstract fun copy(environment: AIAgentEnvironment? = this.environment, agentInput: Any? = this.agentInput, agentInputType: TypeToken? = this.agentInputType, config: AIAgentConfig? = this.config, llm: AIAgentLLMContext? = this.llm, stateManager: AIAgentStateManager? = this.stateManager, storage: AIAgentStorage? = this.storage, runId: String? = this.runId, strategyName: String? = this.strategyName, executionInfo: AgentExecutionInfo? = this.executionInfo): AIAgentContextMockBuilderBase
```

Creates and returns a copy of the current instance of AIAgentContextMockBuilderBase.

A new instance of AIAgentContextMockBuilderBase with the same properties as the original.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.environment

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/environment.html`

### :agents:agents-test/commonMain

```kotlin
abstract var environment: AIAgentEnvironment?
```

Represents the environment used by the AI agent to interact with external systems.

This variable enables the association of an AI agent's context with a specific instance of AIAgentEnvironment. The AIAgentEnvironment interface provides mechanisms for tool execution, problem reporting, and termination signaling, serving as the bridge between the agent and its surrounding environment.

When set, this variable allows the agent to execute tools through the connected environment, as well as handle exceptions and send termination messages as needed during operation.

The value can be null, indicating that no environment is currently associated with the context.

- AIAgentEnvironment

Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.executionInfo

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/execution-info.html`

### :agents:agents-test/commonMain

```kotlin
abstract var executionInfo: AgentExecutionInfo?
```

Represents execution-specific context information for the mock AI agent builder. This variable allows tracking and observability of the agent's execution flow.

By leveraging the properties defined in AgentExecutionInfo, this information aids in linking, tracing, and managing execution paths throughout the agent's lifecycle.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly interface AIAgentContextMockBuilderBase : BaseBuilder<AIAgentContext>
```

A base interface for building mock implementations of the AIAgentContext interface.

This interface provides configurable properties and methods for creating a mock AI agent context, enabling the customization of its environment, input, configuration, state management, and more. It is intended for use in testing scenarios and allows for the creation of testable mock instances of AI agent contexts.

Extends the BaseBuilder interface for constructing instances of type AIAgentContext.

- NodeOutputAssertionsBuilder
- EdgeAssertionsBuilder
- AIAgentContextMockBuilder

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.llm

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/llm.html`

### :agents:agents-test/commonMain

```kotlin
abstract var llm: AIAgentLLMContext?
```

Represents the LLM context associated with an AI agent during testing scenarios. This variable is used to configure and manage the context for an AI agent's large language model (LLM) interactions, including tools, prompt handling, and model-specific attributes.

This is part of the mock building process to facilitate controlled testing of agent behaviors and interactions with LLMs.

- AIAgentLLMContext

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.runId

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/run-id.html`

### :agents:agents-test/commonMain

```kotlin
abstract var runId: String?
```

Represents the unique identifier associated with the session in the mock builder context.

This property is optional and may be used to specify or retrieve the id that ties the run to a specific context or operation.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.stateManager

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/state-manager.html`

### :agents:agents-test/commonMain

```kotlin
abstract var stateManager: AIAgentStateManager?
```

Represents an optional state manager for an AI agent in the context of building its mock environment. The stateManager is responsible for maintaining and managing the internal state of the agent in a thread-safe manner, ensuring consistency during state modifications.

This property can be used to define a customized or mocked state management behavior when setting up the test environment for the AI agent. If left unset, no state management behavior is applied in the mock context.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.storage

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/storage.html`

### :agents:agents-test/commonMain

```kotlin
abstract var storage: AIAgentStorage?
```

Represents a concurrent-safe key-value storage used for managing data within the context of mock AI agent construction. This property typically holds an optional instance of AIAgentStorage, which provides methods to store, retrieve, and manage typed key-value pairs in a thread-safe manner.

The storage is designed to facilitate the sharing of structured and unstructured data within different components of the AI agent during the testing and building phase.

The storage can be configured or accessed to simulate various testing scenarios or to mock internal states of the agent.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.tools.AIAgentContextMockBuilderBase.strategyName

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-a-i-agent-context-mock-builder-base/strategy-name.html`

### :agents:agents-test/commonMain

```kotlin
abstract var strategyName: String?
```

Represents the identifier of a strategy to be used within the context of an AI agent.

This variable allows specifying or retrieving the unique identifier associated with a particular strategy. It can be null if no strategy is defined or required.

## ai.koog.agents.testing.tools.DummyAIAgentContext.DummyAIAgentContext

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/-dummy-a-i-agent-context.html`

### :agents:agents-test/commonMain

```kotlin
constructor(builder: AIAgentContextMockBuilder, agentId: String = "DummyAgentId")
```

Creates a new instance of DummyAIAgentContext using a predefined AIAgentContextMockBuilder.

- builder — A builder object used to initialize the mock properties of the context.
## ai.koog.agents.testing.tools.DummyAIAgentContext.agentId

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/agent-id.html`

### :agents:agents-test/commonMain

```kotlin
open override val agentId: String
```

## ai.koog.agents.testing.tools.DummyAIAgentContext.agentInputType

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/agent-input-type.html`

### :agents:agents-test/commonMain

```kotlin
open override val agentInputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.agentInput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/agent-input.html`

### :agents:agents-test/commonMain

```kotlin
open override val agentInput: Any
```

## ai.koog.agents.testing.tools.DummyAIAgentContext.config

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/config.html`

### :agents:agents-test/commonMain

```kotlin
open override val config: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.copy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/copy.html`

### :agents:agents-test/commonMain

```kotlin
open override fun copy(environment: AIAgentEnvironment, agentId: String, agentInput: Any?, agentInputType: TypeToken, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, runId: String, strategyName: String, pipeline: AIAgentGraphPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentGraphContextBase?): AIAgentGraphContextBase
```

Creates a new instance of AIAgentContextBase with the specified parameters, copying the properties from the current instance with the provided updates.

An instance of AIAgentContextBase with the updated parameters and copied configurations.

- environment — The environment in which the AI agent operates, allowing interaction with external systems.
- agentInput — The input object provided to the AI agent, representing data or context for the agent to process.
- agentInputType — The type of the agent input, used to interpret the structure or nature of the input.
- config — The configuration settings for the AI agent, such as model specifics and operational limits.
- llm — The language model context used by the AI agent for generating responses or processing input.
- stateManager — The state management associated with the AI agent, responsible for tracking execution state and history.
- storage — A storage mechanism for the AI agent, enabling persistence of key-value information.
- runId — A unique identifier for the current execution or operational instance of the AI agent.
- strategyName — The name of the strategy used during the AI agent's execution cycle.
- pipeline — The pipeline configuration used by the AI agent to define the processing steps.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.environment

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/environment.html`

### :agents:agents-test/commonMain

```kotlin
open override val environment: AIAgentEnvironment
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.executionInfo

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/execution-info.html`

### :agents:agents-test/commonMain

```kotlin
open override var executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.fork

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/fork.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun fork(): AIAgentGraphContextBase
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.DummyAIAgentContext

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly class DummyAIAgentContext(builder: AIAgentContextMockBuilder, val agentId: String = "DummyAgentId") : AIAgentGraphContextBase
```

A mock implementation of the AIAgentContext interface, used for testing purposes.

- builder — A builder object used to initialize the mock properties of the context.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.isEnvironmentDefined

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/is-environment-defined.html`

### :agents:agents-test/commonMain

```kotlin
val isEnvironmentDefined: Boolean
```

Indicates whether the environment for the agent context is defined.

This property evaluates to true if the environment property in the builder is not null, meaning that a specific environment has been explicitly set for the agent context. If false, it implies that no environment has been defined and a default or mock environment may be used in its place.

## ai.koog.agents.testing.tools.DummyAIAgentContext.isLLMDefined

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/is-l-l-m-defined.html`

### :agents:agents-test/commonMain

```kotlin
val isLLMDefined: Boolean
```

Indicates whether a Language Learning Model (LLM) is defined in the current context.

This property is true if the LLM context (llm) has been initialized, providing functionality for handling LLM-related operations within the agent context. It can be used for conditional logic to verify if LLM-specific capabilities are available.

## ai.koog.agents.testing.tools.DummyAIAgentContext.llm

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/llm.html`

### :agents:agents-test/commonMain

```kotlin
open override val llm: AIAgentLLMContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.parentContext

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/parent-context.html`

### :agents:agents-test/commonMain

```kotlin
open override val parentContext: AIAgentGraphContextBase? = null
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.pipeline

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/pipeline.html`

### :agents:agents-test/commonMain

```kotlin
open override val pipeline: AIAgentGraphPipeline
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.replace

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/replace.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun replace(context: AIAgentContext)
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.runId

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/run-id.html`

### :agents:agents-test/commonMain

```kotlin
open override val runId: String
```

## ai.koog.agents.testing.tools.DummyAIAgentContext.stateManager

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/state-manager.html`

### :agents:agents-test/commonMain

```kotlin
open override val stateManager: AIAgentStateManager
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.storage

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/storage.html`

### :agents:agents-test/commonMain

```kotlin
open override val storage: AIAgentStorage
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.tools.DummyAIAgentContext.strategyName

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-a-i-agent-context/strategy-name.html`

### :agents:agents-test/commonMain

```kotlin
open override val strategyName: String
```

## ai.koog.agents.testing.tools.DummyTool.Args.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/-args/-args.html`

### :agents:agents-test/commonMain

```kotlin
constructor(dummy: String = "")
```

## ai.koog.agents.testing.tools.DummyTool.Args.dummy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/-args/dummy.html`

### :agents:agents-test/commonMain

```kotlin
val dummy: String
```

## ai.koog.agents.testing.tools.DummyTool.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/-args/index.html`

### :agents:agents-test/commonMain

```kotlin
@Serializable data class Args(val dummy: String = "")
```

Represents the arguments for the DummyTool.

## ai.koog.agents.testing.tools.DummyTool.DummyTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/-dummy-tool.html`

### :agents:agents-test/commonMain

```kotlin
constructor()
```

## ai.koog.agents.testing.tools.DummyTool.execute

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/execute.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun execute(args: DummyTool.Args): String
```

## ai.koog.agents.testing.tools.DummyTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/index.html`

### :agents:agents-test/commonMain

```kotlin
class DummyTool : SimpleTool<DummyTool.Args>
```

Simple tool implementation for testing purposes. This tool accepts a placeholder parameter and returns a constant result.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.DummyTool.result

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-dummy-tool/result.html`

### :agents:agents-test/commonMain

```kotlin
val result: String
```

A constant value representing the default result returned by the DummyTool.

## ai.koog.agents.testing.tools.MockEnvironment.MockEnvironment

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-environment/-mock-environment.html`

### :agents:agents-test/commonMain

```kotlin
constructor(toolRegistry: ToolRegistry, promptExecutor: PromptExecutor, serializer: JSONSerializer, baseEnvironment: AIAgentEnvironment? = null)
```


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.MockEnvironment.executeTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-environment/execute-tool.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun executeTool(toolCall: MessagePart.Tool.Call): ReceivedToolResult
```

Executes a single tool call and returns its result.

The execution follows this process:

If the prompt executor is a MockPromptExecutor, check for matching mocked tool actions

If a matching mock is found, use it to generate the result

Otherwise, retrieve the actual tool from the registry and execute it

A ReceivedToolResult containing the result of the tool call

- toolCall — The tool call to execute

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.tools.MockEnvironment.executeTools

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-environment/execute-tools.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun executeTools(toolCalls: List<MessagePart.Tool.Call>): List<ReceivedToolResult>
```

Executes a list of tool calls and returns their results.

This method processes each tool call individually by:

First, checking if there are any mocked responses for the tool call

If no mocks are found, execute the actual tool implementation

A list of ReceivedToolResult objects containing the results of the tool calls

- toolCalls — The list of tool calls to execute

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.tools.MockEnvironment

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-environment/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockEnvironment(toolRegistry: ToolRegistry, promptExecutor: PromptExecutor, serializer: JSONSerializer, baseEnvironment: AIAgentEnvironment? = null) : AIAgentEnvironment
```

A mock implementation of AIAgentEnvironment used for testing agent behavior.

This class provides a controlled environment for testing agents by:

Executing tool calls using either mocked responses or actual tool implementations

Handling exceptions by re-throwing them for test visibility

Optionally delegating termination signals to a base environment

It works in conjunction with MockPromptExecutor to provide a complete testing framework for agent interactions.


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.MockEnvironment.reportProblem

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-environment/report-problem.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun reportProblem(exception: Throwable)
```

Reports a problem by throwing the exception.

In a testing environment, this behavior makes exceptions visible to the test framework, allowing tests to catch and verify expected exceptions.

- exception — The exception to the report
- Throwable — The same exception that was passed in
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.MockToolFromCallableReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/-mock-tool-from-callable-receiver.html`

### :agents:agents-test/jvmMain

```kotlin
constructor(callable: KFunction<Result>, builder: MockExecutorDSLBuilder)
```

- Result — The type of result produced by the callable
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.MockToolFromCallableResponseBuilder.MockToolFromCallableResponseBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/-mock-tool-from-callable-response-builder/-mock-tool-from-callable-response-builder.html`

### :agents:agents-test/jvmMain

```kotlin
constructor(callable: KFunction<Result>, action: suspend () -> Result, builder: MockExecutorDSLBuilder)
```

- callable — The callable (function or method) that the mock tool corresponds to.
- action — The action to execute when the mock tool is invoked.
- builder — The MockExecutorDSLBuilder used to configure and manage the mock tool's behavior.
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.MockToolFromCallableResponseBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/-mock-tool-from-callable-response-builder/index.html`

### :agents:agents-test/jvmMain

```kotlin
class MockToolFromCallableResponseBuilder<Result>(callable: KFunction<Result>, action: suspend () -> Result, builder: MockExecutorDSLBuilder)
```

A builder class for setting up mock tool responses based on a callable's behavior.

- callable — The callable (function or method) that the mock tool corresponds to.
- action — The action to execute when the mock tool is invoked.
- builder — The MockExecutorDSLBuilder used to configure and manage the mock tool's behavior.
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.MockToolFromCallableResponseBuilder.onArgumentsMatching

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/-mock-tool-from-callable-response-builder/on-arguments-matching.html`

### :agents:agents-test/jvmMain

```kotlin
fun onArgumentsMatching(condition: suspend (ToolFromCallable.Args) -> Boolean)
```

Configures a mock behavior for the associated callable to be triggered when the supplied condition is satisfied based on the provided arguments.

- condition — A suspendable condition function that takes an instance of ToolFromCallable.Args and evaluates to true if the action should be executed for the given arguments.

Referenced packages: `ai.koog.agents.core.tools.reflect`.

## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.MockToolFromCallableResponseBuilder.onArguments

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/-mock-tool-from-callable-response-builder/on-arguments.html`

### :agents:agents-test/jvmMain

```kotlin
fun onArguments(vararg args: Any?)
```

Configures the mock tool to respond when it is called with the specified arguments.

- args — The arguments to match for the callable. These are matched against the callable's parameters and are associated with them to form a mapping of parameter names to argument values.
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.alwaysDoes

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/always-does.html`

### :agents:agents-test/jvmMain

```kotlin
infix fun alwaysDoes(action: suspend () -> Result)
```

Configures a tool to always execute the provided action whenever it is invoked.

- action — A suspendable function that returns a Result. The provided action is executed every time the tool is called.
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.alwaysReturns

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/always-returns.html`

### :agents:agents-test/jvmMain

```kotlin
infix fun alwaysReturns(response: Result)
```

Configures the tool to always return the specified result when called.

- response — The result to always return when the tool is invoked.
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.does

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/does.html`

### :agents:agents-test/jvmMain

```kotlin
infix fun does(action: suspend () -> Result): MockToolFromCallableReceiver.MockToolFromCallableResponseBuilder<Result>
```

Configures a tool to execute the provided suspendable action whenever it is invoked.

A MockToolFromCallableResponseBuilder instance for additional configuration of the mock tool's behavior.

- action — A suspendable function that returns a Result. The action is executed each time the tool is called.
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/index.html`

### :agents:agents-test/jvmMain

```kotlin
class MockToolFromCallableReceiver<Result>(callable: KFunction<Result>, builder: MockExecutorDSLBuilder)
```

A class that facilitates mocking of callable tools by defining their behavior based on the received arguments.

- Result — The type of result produced by the callable
## ai.koog.agents.testing.tools.MockToolFromCallableReceiver.returns

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-tool-from-callable-receiver/returns.html`

### :agents:agents-test/jvmMain

```kotlin
infix fun returns(result: Result): MockToolFromCallableReceiver.MockToolFromCallableResponseBuilder<Result>
```

Configures the tool to return the specified result when it is invoked.

A MockToolFromCallableResponseBuilder instance for further configuration.

- result — The result that the tool should return upon invocation.
## ai.koog.agents.testing.tools.RandomNumberTool.Args.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/-args/-args.html`

### :agents:agents-test/commonMain

```kotlin
constructor(seed: Int? = null)
```

## ai.koog.agents.testing.tools.RandomNumberTool.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/-args/index.html`

### :agents:agents-test/commonMain

```kotlin
@Serializable data class Args(val seed: Int? = null)
```

Represents the arguments for the RandomNumberTool.

## ai.koog.agents.testing.tools.RandomNumberTool.Args.seed

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/-args/seed.html`

### :agents:agents-test/commonMain

```kotlin
val seed: Int?
```

## ai.koog.agents.testing.tools.RandomNumberTool.RandomNumberTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/-random-number-tool.html`

### :agents:agents-test/commonMain

```kotlin
constructor()
```

## ai.koog.agents.testing.tools.RandomNumberTool.execute

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/execute.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun execute(args: RandomNumberTool.Args): Int
```

## ai.koog.agents.testing.tools.RandomNumberTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/index.html`

### :agents:agents-test/commonMain

```kotlin
class RandomNumberTool : Tool<RandomNumberTool.Args, Int>
```

A tool that provides a random number using the passed seed.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.RandomNumberTool.last

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-random-number-tool/last.html`

### :agents:agents-test/commonMain

```kotlin
var last: Int?
```

The last generated random number.

## ai.koog.agents.testing.tools.TestBlankTool.Args.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-blank-tool/-args/-args.html`

### :agents:agents-test/commonMain

```kotlin
constructor(args: String = "")
```

## ai.koog.agents.testing.tools.TestBlankTool.Args.args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-blank-tool/-args/args.html`

### :agents:agents-test/commonMain

```kotlin
val args: String
```

## ai.koog.agents.testing.tools.TestBlankTool.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-blank-tool/-args/index.html`

### :agents:agents-test/commonMain

```kotlin
@Serializable data class Args(val args: String = "")
```

Represents the arguments for the TestBlankTool.

## ai.koog.agents.testing.tools.TestBlankTool.TestBlankTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-blank-tool/-test-blank-tool.html`

### :agents:agents-test/commonMain

```kotlin
constructor(name: String? = null)
```

- name — An optional name for the tool. If not provided, it defaults to "blank-tool".
## ai.koog.agents.testing.tools.TestBlankTool.execute

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-blank-tool/execute.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun execute(args: TestBlankTool.Args): String
```

## ai.koog.agents.testing.tools.TestBlankTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-blank-tool/index.html`

### :agents:agents-test/commonMain

```kotlin
class TestBlankTool(name: String? = null) : Tool<TestBlankTool.Args, String>
```

A simple implementation of the Tool class that returns the input string argument as the result. This tool is used for testing purposes only.

- name — An optional name for the tool. If not provided, it defaults to "blank-tool".

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.TestFinishTool.Args.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-finish-tool/-args/-args.html`

### :agents:agents-test/commonMain

```kotlin
constructor(output: String = "")
```

## ai.koog.agents.testing.tools.TestFinishTool.Args

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-finish-tool/-args/index.html`

### :agents:agents-test/commonMain

```kotlin
@Serializable data class Args(val output: String = "")
```

Represents the arguments for a tool or function, typically used in serialization and description contexts.

## ai.koog.agents.testing.tools.TestFinishTool.Args.output

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-finish-tool/-args/output.html`

### :agents:agents-test/commonMain

```kotlin
val output: String
```

## ai.koog.agents.testing.tools.TestFinishTool.execute

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-finish-tool/execute.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun execute(args: TestFinishTool.Args): String
```

## ai.koog.agents.testing.tools.TestFinishTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-test-finish-tool/index.html`

### :agents:agents-test/commonMain

```kotlin
object TestFinishTool : Tool<TestFinishTool.Args, String>
```

A simple implementation of the Tool class designed to handle string arguments and return string results. The tool is used for testing purposes only.


Referenced packages: `ai.koog.agents.core.tools`.
