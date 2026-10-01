# Mock executors and graph assertions

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.testing.client.CapturingLLMClient.CapturingLLMClient

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/-capturing-l-l-m-client.html`

### :agents:agents-test/commonMain

```kotlin
constructor(executeResponse: Message.Assistant? = null, streamingChunks: List<StreamFrame> = emptyList(), choices: LLMChoice? = null, moderationResult: ModerationResult = ModerationResult(isHarmful = false, categories = emptyMap()), embedResult: List<Double> = emptyList(), batchEmbedResult: List<List<Double>> = emptyList(), llmProvider: LLMProvider = LLMProvider.OpenAI)
```


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.client.CapturingLLMClient.close

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/close.html`

### :agents:agents-test/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.testing.client.CapturingLLMClient.embed

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/embed.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Simulates an embedding call. Captures input parameters and returns the predefined embedResult.


Referenced packages: `ai.koog.prompt.llm`.

### :agents:agents-test/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Simulates a batch embedding call. Captures input parameters and returns the predefined batchEmbedResult.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.executeMultipleChoices

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/execute-multiple-choices.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```

Simulates an LLM call that returns multiple choices. Captures input parameters and returns the predefined choices.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.client.CapturingLLMClient.executeStreaming

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/execute-streaming.html`

### :agents:agents-test/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Simulates a streaming LLM execution. Captures input parameters and emits the predefined streamingChunks.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.client.CapturingLLMClient.execute

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/execute.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```

Simulates a non-streaming LLM execution. Captures input parameters and returns the predefined executeResponse.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.client.CapturingLLMClient

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/index.html`

### :agents:agents-test/commonMain

```kotlin
class CapturingLLMClient constructor(executeResponse: Message.Assistant? = null, streamingChunks: List<StreamFrame> = emptyList(), choices: LLMChoice? = null, moderationResult: ModerationResult = ModerationResult(isHarmful = false, categories = emptyMap()), embedResult: List<Double> = emptyList(), batchEmbedResult: List<List<Double>> = emptyList(), llmProvider: LLMProvider = LLMProvider.OpenAI) : LLMClient
```

A test double implementation of LLMClient that captures the last inputs provided to each API and returns predefined responses. This is useful in unit and integration tests to assert that a component under test interacts with an LLM client as expected without making real network calls.

Constructor parameters allow you to predefine what each method should return.


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastBatchEmbeddingInput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-batch-embedding-input.html`

### :agents:agents-test/commonMain

```kotlin
var lastBatchEmbeddingInput: List<String>?
```

The last batched input passed to embed, or null if it hasn't been called yet.

## ai.koog.agents.testing.client.CapturingLLMClient.lastBatchEmbeddingModel

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-batch-embedding-model.html`

### :agents:agents-test/commonMain

```kotlin
var lastBatchEmbeddingModel: LLModel?
```

The last LLModel passed to embed, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastChoicesModel

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-choices-model.html`

### :agents:agents-test/commonMain

```kotlin
var lastChoicesModel: LLModel?
```

The last LLModel passed to executeMultipleChoices, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastChoicesPrompt

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-choices-prompt.html`

### :agents:agents-test/commonMain

```kotlin
var lastChoicesPrompt: Prompt?
```

The last Prompt passed to executeMultipleChoices, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastChoicesTools

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-choices-tools.html`

### :agents:agents-test/commonMain

```kotlin
var lastChoicesTools: List<ToolDescriptor>?
```

The last list of tools passed to executeMultipleChoices, or null if it hasn't been called yet.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastEmbeddingModel

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-embedding-model.html`

### :agents:agents-test/commonMain

```kotlin
var lastEmbeddingModel: LLModel?
```

The last LLModel passed to embed, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastEmbeddingText

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-embedding-text.html`

### :agents:agents-test/commonMain

```kotlin
var lastEmbeddingText: String?
```

The last text passed to embed, or null if it hasn't been called yet.

## ai.koog.agents.testing.client.CapturingLLMClient.lastExecutedModel

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-executed-model.html`

### :agents:agents-test/commonMain

```kotlin
var lastExecutedModel: LLModel?
```

The last LLModel passed to execute, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastExecutedPrompt

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-executed-prompt.html`

### :agents:agents-test/commonMain

```kotlin
var lastExecutedPrompt: Prompt?
```

The last Prompt passed to execute, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastExecutedTools

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-executed-tools.html`

### :agents:agents-test/commonMain

```kotlin
var lastExecutedTools: List<ToolDescriptor>?
```

The last list of tools passed to execute, or null if it hasn't been called yet.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastModerationModel

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-moderation-model.html`

### :agents:agents-test/commonMain

```kotlin
var lastModerationModel: LLModel?
```

The last LLModel passed to moderate, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastModerationPrompt

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-moderation-prompt.html`

### :agents:agents-test/commonMain

```kotlin
var lastModerationPrompt: Prompt?
```

The last Prompt passed to moderate, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastStreamingModel

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-streaming-model.html`

### :agents:agents-test/commonMain

```kotlin
var lastStreamingModel: LLModel?
```

The last LLModel passed to executeStreaming, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.lastStreamingPrompt

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/last-streaming-prompt.html`

### :agents:agents-test/commonMain

```kotlin
var lastStreamingPrompt: Prompt?
```

The last Prompt passed to executeStreaming, or null if it hasn't been called yet.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.testing.client.CapturingLLMClient.llmProvider

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/llm-provider.html`

### :agents:agents-test/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.testing.client.CapturingLLMClient.moderate

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.client/-capturing-l-l-m-client/moderate.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Simulates a content moderation call. Captures input parameters and returns the predefined moderationResult.


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.agents.testing.feature.GraphAssertions.GraphAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/-graph-assertions.html`

### :agents:agents-test/commonMain

```kotlin
constructor(name: String, start: NodeReference.Start<*>, finish: NodeReference.Finish<*>, nodes: Map<String, NodeReference<*, *>>, nodeOutputAssertions: List<NodeOutputAssertion<*, *>>, edgeAssertions: List<EdgeAssertion<*, *>>, unconditionalEdgeAssertions: List<UnconditionalEdgeAssertion>, reachabilityAssertions: List<ReachabilityAssertion>, subgraphAssertions: MutableList<SubGraphAssertions>)
```

## ai.koog.agents.testing.feature.GraphAssertions.edgeAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/edge-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val edgeAssertions: List<EdgeAssertion<*, *>>
```

## ai.koog.agents.testing.feature.GraphAssertions.finish

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/finish.html`

### :agents:agents-test/commonMain

```kotlin
val finish: NodeReference.Finish<*>
```

## ai.koog.agents.testing.feature.GraphAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly data class GraphAssertions(val name: String, val start: NodeReference.Start<*>, val finish: NodeReference.Finish<*>, val nodes: Map<String, NodeReference<*, *>>, val nodeOutputAssertions: List<NodeOutputAssertion<*, *>>, val edgeAssertions: List<EdgeAssertion<*, *>>, val unconditionalEdgeAssertions: List<UnconditionalEdgeAssertion>, val reachabilityAssertions: List<ReachabilityAssertion>, val subgraphAssertions: MutableList<SubGraphAssertions>)
```

Represents a set of assertions for validating the structure and behavior of a graph-based system.

## ai.koog.agents.testing.feature.GraphAssertions.name

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/name.html`

### :agents:agents-test/commonMain

```kotlin
val name: String
```

## ai.koog.agents.testing.feature.GraphAssertions.nodeOutputAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/node-output-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val nodeOutputAssertions: List<NodeOutputAssertion<*, *>>
```

## ai.koog.agents.testing.feature.GraphAssertions.nodes

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/nodes.html`

### :agents:agents-test/commonMain

```kotlin
val nodes: Map<String, NodeReference<*, *>>
```

## ai.koog.agents.testing.feature.GraphAssertions.reachabilityAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/reachability-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val reachabilityAssertions: List<ReachabilityAssertion>
```

## ai.koog.agents.testing.feature.GraphAssertions.start

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/start.html`

### :agents:agents-test/commonMain

```kotlin
val start: NodeReference.Start<*>
```

## ai.koog.agents.testing.feature.GraphAssertions.subgraphAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/subgraph-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val subgraphAssertions: MutableList<SubGraphAssertions>
```

## ai.koog.agents.testing.feature.GraphAssertions.unconditionalEdgeAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-graph-assertions/unconditional-edge-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val unconditionalEdgeAssertions: List<UnconditionalEdgeAssertion>
```

## ai.koog.agents.testing.feature.SubGraphAssertions.SubGraphAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-sub-graph-assertions/-sub-graph-assertions.html`

### :agents:agents-test/commonMain

```kotlin
constructor(subgraphRef: NodeReference.SubgraphNode<*, *>, graphAssertions: GraphAssertions)
```

## ai.koog.agents.testing.feature.SubGraphAssertions.graphAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-sub-graph-assertions/graph-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val graphAssertions: GraphAssertions
```

## ai.koog.agents.testing.feature.SubGraphAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-sub-graph-assertions/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly data class SubGraphAssertions(val subgraphRef: NodeReference.SubgraphNode<*, *>, val graphAssertions: GraphAssertions)
```

Encapsulates assertions for a subgraph within a graph testing framework.

This class links a specific subgraph, represented by a SubgraphNode, with its corresponding graph-wide assertions. It is intended to facilitate hierarchical testing and validation of graph components in isolation or as part of a larger graph structure.

## ai.koog.agents.testing.feature.SubGraphAssertions.subgraphRef

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-sub-graph-assertions/subgraph-ref.html`

### :agents:agents-test/commonMain

```kotlin
val subgraphRef: NodeReference.SubgraphNode<*, *>
```

## ai.koog.agents.testing.feature.Testing.Config.Config

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-config.html`

### :agents:agents-test/commonMain

```kotlin
constructor(serializer: JSONSerializer)
```

- serializer — JSON serializer configured in the AIAgentConfig for this agent instance

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeAssertionsBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/-edge-assertions-builder.html`

### :agents:agents-test/commonMain

```kotlin
constructor(stageBuilder: Testing.Config.SubgraphAssertionsBuilder<*, *>, context: AIAgentContextMockBuilder = stageBuilder.context.copy())
```


Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeOutputPair.EdgeOutputPair

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/-edge-output-pair/-edge-output-pair.html`

### :agents:agents-test/commonMain

```kotlin
constructor(node: NodeReference<I, O>, output: O)
```

- I — the type of the input expected by the node.
- O — the type of the output produced by the node.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeOutputPair.goesTo

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/-edge-output-pair/goes-to.html`

### :agents:agents-test/commonMain

```kotlin
infix fun goesTo(targetNode: NodeReference<*, *>)
```

Creates an assertion to verify that a specific output from the current node leads to the given target node.

- targetNode — The target node that the current node output is expected to connect to.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeOutputPair

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/-edge-output-pair/index.html`

### :agents:agents-test/commonMain

```kotlin
inner class EdgeOutputPair<I, O>(val node: NodeReference<I, O>, val output: O)
```

Represents a pair consisting of a node and its corresponding output within an edge assertion context. This is used to define expected edge behavior in a graph of nodes.

- I — the type of the input expected by the node.
- O — the type of the output produced by the node.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeOutputPair.node

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/-edge-output-pair/node.html`

### :agents:agents-test/commonMain

```kotlin
val node: NodeReference<I, O>
```

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeOutputPair.output

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/-edge-output-pair/output.html`

### :agents:agents-test/commonMain

```kotlin
val output: O
```

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.alwaysGoesTo

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/always-goes-to.html`

### :agents:agents-test/commonMain

```kotlin
infix fun NodeReference<*, *>.alwaysGoesTo(targetNode: NodeReference<*, *>)
```

Creates an assertion to verify that the current node always leads to the given target node.

- targetNode — The target node that the current node output is expected to connect to.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.assertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/assertions.html`

### :agents:agents-test/commonMain

```kotlin
val assertions: MutableList<EdgeAssertion<*, *>>
```

A mutable list that holds all the defined EdgeAssertion instances for the current context.

EdgeAssertion represents the relationship between nodes in a graph-like structure, detailing the output of a source node and its expected connection to a target node. These assertions are used to validate the behavior and flow of nodes within an agent's stage context.

This list is populated during the execution of the EdgeAssertionsBuilder block in methods that build or define edge assertions. Each assertion is added via the respective fluent APIs provided within the builder.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class EdgeAssertionsBuilder(stageBuilder: Testing.Config.SubgraphAssertionsBuilder<*, *>, context: AIAgentContextMockBuilder = stageBuilder.context.copy()) : AIAgentContextMockBuilderBase
```

A builder class used to facilitate the creation and management of edge assertions in a stage context. Delegates functionality to a local agent stage context mock builder for shared behaviors.


Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.unconditionalEdgeAssertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/unconditional-edge-assertions.html`

### :agents:agents-test/commonMain

```kotlin
val unconditionalEdgeAssertions: MutableList<UnconditionalEdgeAssertion>
```

A collection that stores assertions ensuring an unconditional connection between nodes in a graph testing context. Each assertion represents a defined relationship where a node always leads to a specified target node.

This list is populated by adding instances of UnconditionalEdgeAssertion through relevant methods, such as when defining relationships or validating graph behavior.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.withContext

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/with-context.html`

### :agents:agents-test/commonMain

```kotlin
fun withContext(block: Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.() -> Unit)
```

Executes a given block of logic within the context of a copied instance of the current EdgeAssertionsBuilder.

- block — The block of code to execute within the context of the copied EdgeAssertionsBuilder instance.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.withOutput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-edge-assertions-builder/with-output.html`

### :agents:agents-test/commonMain

```kotlin
infix fun <I, O> NodeReference<I, O>.withOutput(output: O): Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.EdgeOutputPair<I, O>
```

Associates the given output with the current node reference, creating a pair that represents the node and its corresponding output.

an instance of EdgeOutputPair containing the current node reference and the associated output

- output — the output value to associate with the current node reference
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputAssertionsBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/-node-output-assertions-builder.html`

### :agents:agents-test/commonMain

```kotlin
constructor(stageBuilder: Testing.Config.SubgraphAssertionsBuilder<*, *>, context: AIAgentContextMockBuilder = stageBuilder.context.copy())
```


Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputPair.NodeOutputPair

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/-node-output-pair/-node-output-pair.html`

### :agents:agents-test/commonMain

```kotlin
constructor(node: NodeReference<I, O>, input: I)
```

- I — The type of the input for the node.
- O — The type of the output for the node.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputPair

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/-node-output-pair/index.html`

### :agents:agents-test/commonMain

```kotlin
inner class NodeOutputPair<I, O>(val node: NodeReference<I, O>, val input: I)
```

Represents a pairing of a specific node reference and its corresponding input. This is used to define the expected output for a given input within the context of a specific node.

- I — The type of the input for the node.
- O — The type of the output for the node.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputPair.input

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/-node-output-pair/input.html`

### :agents:agents-test/commonMain

```kotlin
val input: I
```

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputPair.node

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/-node-output-pair/node.html`

### :agents:agents-test/commonMain

```kotlin
val node: NodeReference<I, O>
```

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputPair.outputs

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/-node-output-pair/outputs.html`

### :agents:agents-test/commonMain

```kotlin
infix fun outputs(output: O)
```

Asserts that the output of the current node given the specified input matches the expected output.

- output — The expected output to validate against the current node's actual output.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.assertions

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/assertions.html`

### :agents:agents-test/commonMain

```kotlin
val assertions: MutableList<NodeOutputAssertion<*, *>>
```

A mutable list that stores assertions representing the expected behavior and output of nodes in the context of a specific staging environment for testing purposes.

Each assertion is an instance of NodeOutputAssertion, which encapsulates information such as the node reference, the input provided, the expected output, and the context in which the node operates.

These assertions are used to verify the correctness of node operations within the local agent stage context during testing.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class NodeOutputAssertionsBuilder(stageBuilder: Testing.Config.SubgraphAssertionsBuilder<*, *>, context: AIAgentContextMockBuilder = stageBuilder.context.copy()) : AIAgentContextMockBuilderBase
```

A builder class for constructing and managing assertions related to the outputs of nodes within a stage. This class provides functionality to define and evaluate assertions for node outputs in a local agent's stage.


Referenced packages: `ai.koog.agents.testing.tools`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.withContext

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/with-context.html`

### :agents:agents-test/commonMain

```kotlin
fun withContext(block: Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.() -> Unit)
```

Executes the specified block of code within a duplicate context of the current NodeOutputAssertionsBuilder.

- block — The block of code to be executed within the duplicated context of NodeOutputAssertionsBuilder.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.withInput

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-node-output-assertions-builder/with-input.html`

### :agents:agents-test/commonMain

```kotlin
infix fun <I, O> NodeReference<I, O>.withInput(input: I): Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.NodeOutputPair<I, O>
```

Associates the provided input with the current node reference, creating a pair that links the node to its corresponding input.

A NodeOutputPair containing the node reference and the provided input.

- input — The input value to associate with the node reference.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.SubgraphAssertionsBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/-subgraph-assertions-builder.html`

### :agents:agents-test/commonMain

```kotlin
constructor(subgraphRef: NodeReference.SubgraphNode<Input, Output>, clock: KoogClock, tokenizer: Tokenizer?, serializer: JSONSerializer)
```

- subgraphRef — : A NodeReference.SubgraphNode reference to a subgraph of the agent's graph strategy
- clock — : A clock that is used for mock message timestamps
- tokenizer — Tokenizer that will be used to estimate token counts in mock messages
- serializer — JSON serializer

Referenced packages: `ai.koog.prompt.tokenizer`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.assertEdges

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/assert-edges.html`

### :agents:agents-test/commonMain

```kotlin
fun assertEdges(block: Testing.Config.SubgraphAssertionsBuilder.EdgeAssertionsBuilder.() -> Unit)
```

Asserts the edges in the context of a graph by applying a set of edge assertions built using the provided block.

- block — A lambda function that operates on an instance of EdgeAssertionsBuilder to define specific edge assertions.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.assertNodeByName

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/assert-node-by-name.html`

### :agents:agents-test/commonMain

```kotlin
fun <I, O> assertNodeByName(name: String): NodeReference.NamedNode<I, O>
```

Asserts the existence of a node by its name within the stage structure and returns a reference to it. If the node with the given name has not been asserted previously, it creates a new NamedNode reference and records it in the nodes map for tracking.

a NodeReference for the node identified by the given name.

- name — the name of the node to assert or retrieve.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.assertNodes

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/assert-nodes.html`

### :agents:agents-test/commonMain

```kotlin
fun assertNodes(block: Testing.Config.SubgraphAssertionsBuilder.NodeOutputAssertionsBuilder.() -> Unit)
```

Asserts the state of nodes in the stage using a provided block to define the desired assertions. The block operates on a NodeOutputAssertionsBuilder to specify expectations for node inputs and outputs.

- block — A lambda receiver operating on a NodeOutputAssertionsBuilder that defines the assertions to be applied to the nodes in the stage.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.assertReachable

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/assert-reachable.html`

### :agents:agents-test/commonMain

```kotlin
fun assertReachable(from: NodeReference<*, *>, to: NodeReference<*, *>)
```

Asserts that there is a reachable path between two specified nodes within a stage.

- from — The starting node reference from where the reachability is checked.
- to — The target node reference to which the reachability is checked.
## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.assertSubgraphByName

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/assert-subgraph-by-name.html`

### :agents:agents-test/commonMain

```kotlin
fun <I, O> assertSubgraphByName(name: String): NodeReference.SubgraphNode<I, O>
```

Asserts the existence of a subgraph by its name

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.finishNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/finish-node.html`

### :agents:agents-test/commonMain

```kotlin
fun finishNode(): NodeReference.Finish<Output>
```

Retrieves a reference to the finish node of the current stage in the graph.

a NodeReference.Finish representing the terminal node of the stage.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class SubgraphAssertionsBuilder<Input, Output>(subgraphRef: NodeReference.SubgraphNode<Input, Output>, clock: KoogClock, tokenizer: Tokenizer?, serializer: JSONSerializer)
```

Builder class for constructing subgraph-level assertions. This includes setup for nodes, edges, reachability assertions, and context-related mock setups.

- subgraphRef — : A NodeReference.SubgraphNode reference to a subgraph of the agent's graph strategy
- clock — : A clock that is used for mock message timestamps
- tokenizer — Tokenizer that will be used to estimate token counts in mock messages
- serializer — JSON serializer

Referenced packages: `ai.koog.prompt.tokenizer`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.startNode

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/start-node.html`

### :agents:agents-test/commonMain

```kotlin
fun startNode(): NodeReference.Start<Input>
```

Retrieves the starting node reference of the stage.

The starting node reference of type NodeReference.Start, representing the entry point of the stage.

## ai.koog.agents.testing.feature.Testing.Config.SubgraphAssertionsBuilder.verifySubgraph

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/-subgraph-assertions-builder/verify-subgraph.html`

### :agents:agents-test/commonMain

```kotlin
fun <I, O> verifySubgraph(subgraph: NodeReference.SubgraphNode<I, O>, checkSubgraph: Testing.Config.SubgraphAssertionsBuilder<I, O>.() -> Unit = {})
```

Verifies a given subgraph by applying a set of assertions to it using a provided configuration block.

- subgraph — the subgraph to verify, represented as a NodeReference.SubgraphNode of input and output types I and O.
- checkSubgraph — a lambda receiver operating on a SubgraphAssertionsBuilder that defines the assertions to be applied to the subgraph.
## ai.koog.agents.testing.feature.Testing.Config.clock

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/clock.html`

### :agents:agents-test/commonMain

```kotlin
var clock: KoogClock
```

A clock instance used for managing timestamps within the configuration, primarily for mock message timestamping purposes.

This enables test scenarios that require precise control over time by allowing the use of custom clock instances, such as mock or fixed clocks.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.testing.feature.Testing.Config.enableGraphTesting

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/enable-graph-testing.html`

### :agents:agents-test/commonMain

```kotlin
var enableGraphTesting: Boolean
```

A configuration flag that determines whether graph-related testing features are enabled.

When set to true, additional testing mechanisms related to graph validation, assertions, or structure evaluation may be activated within the system. Default value is false, which disables graph testing functionalities.

## ai.koog.agents.testing.feature.Testing.Config.handleAssertion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/handle-assertion.html`

### :agents:agents-test/commonMain

```kotlin
fun handleAssertion(block: (AssertionResult) -> Unit)
```

Sets a custom handler for processing assertion results.

- block — A lambda that takes an AssertionResult as input and processes it. This allows customization of how assertion results are handled, such as logging or throwing custom exceptions.
## ai.koog.agents.testing.feature.Testing.Config

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/index.html`

### :agents:agents-test/commonMain

```kotlin
class Config(serializer: JSONSerializer) : FeatureConfig
```

Represents a configuration class responsible for managing assertion handlers and stage configurations. It includes methods for registering custom assertion handling, managing stages and their order, and defining stage-specific assertions.

- serializer — JSON serializer configured in the AIAgentConfig for this agent instance

Referenced packages: `ai.koog.agents.core.feature.config`, `ai.koog.serialization`.

## ai.koog.agents.testing.feature.Testing.Config.tokenizer

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/tokenizer.html`

### :agents:agents-test/commonMain

```kotlin
var tokenizer: Tokenizer?
```

Defines the tokenizer to be used for estimating token counts in text strings.

Tokenizers are critical for features or applications requiring token-level control or analysis, such as evaluating text input size relative to limits or optimizing messages for LLM prompts. By default, this is set to null, which disables token counting, but it can be replaced with a custom implementation of the Tokenizer interface.

Assigning a different tokenizer allows for customizable token estimation strategies with varying levels of accuracy and performance depending on the use case.


Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.agents.testing.feature.Testing.Config.verifyStrategy

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-config/verify-strategy.html`

### :agents:agents-test/commonMain

```kotlin
fun <Input, Output> verifyStrategy(name: String, buildAssertions: Testing.Config.SubgraphAssertionsBuilder<Input, Output>.() -> Unit)
```

Configures and adds a verification strategy using the provided name and assertions.

- name — The name of the strategy to be verified.
- buildAssertions — A lambda defining the assertions to be built for the strategy.
## ai.koog.agents.testing.feature.Testing.Feature.createInitialConfig

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-feature/create-initial-config.html`

### :agents:agents-test/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): Testing.Config
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.testing.feature.Testing.Feature

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-feature/index.html`

### :agents:agents-test/commonMain

```kotlin
object Feature : AIAgentGraphFeature<Testing.Config, Testing>
```

Companion object implementing agent feature, handling Testing creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.testing.feature.Testing.Feature.install

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-feature/install.html`

### :agents:agents-test/commonMain

```kotlin
open override fun install(config: Testing.Config, pipeline: AIAgentGraphPipeline): Testing
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.testing.feature.Testing.Feature.key

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-feature/key.html`

### :agents:agents-test/commonMain

```kotlin
open override val key: AIAgentStorageKey<Testing>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.testing.feature.Testing.Testing

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/-testing.html`

### :agents:agents-test/commonMain

```kotlin
constructor()
```

## ai.koog.agents.testing.feature.Testing

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/-testing/index.html`

### :agents:agents-test/commonMain

```kotlin
@TestOnly class Testing
```

Provides functionality for testing graph-related stages in an AI agent pipeline.

This feature allows you to configure and validate the relationships between nodes, their outputs, and the overall graph structure within different stages of an agent. It can validate:

Stage order

Node existence and reachability

Node input/output behavior

Edge connections between nodes

The Testing feature is designed to be used with the testGraph function, which provides a clean API for defining and executing graph tests.

Example usage:

- testGraph
- Testing.Config
## ai.koog.agents.testing.feature.assistantMessage

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/assistant-message.html`

### :agents:agents-test/commonMain

```kotlin
fun Testing.Config.SubgraphAssertionsBuilder<*, *>.assistantMessage(text: String, finishReason: String? = null): Message.Assistant
```

Creates an assistant message with the provided text and finish reason.

A new instance of Message.Assistant containing the provided content, finish reason, and associated metadata.

- text — The content of the assistant message.
- finishReason — The reason indicating why the message was concluded. Defaults to null.

Referenced packages: `ai.koog.prompt.message`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> Testing.Config.SubgraphAssertionsBuilder<*, *>.assistantMessage(tool: Tool<Args, *>, args: Args, finishReason: String? = null): Message.Assistant
```

Creates an assistant message with the provided text and finish reason.

A new instance of Message.Assistant containing the provided content, finish reason, and associated metadata.

- tool — The tool used to generate the message content.
- args — The arguments passed to the tool.
- finishReason — The reason indicating why the message was concluded. Defaults to null.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.feature.graph

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/graph.html`

### :agents:agents-test/commonMain

```kotlin
fun Testing.Config.graph(test: Testing.Config.() -> Unit)
```

Configures the Testing feature for graph testing.

This function enables graph testing and sets up assertion handling to integrate with the standard Kotlin test framework. It allows you to define graph structure tests, node behavior tests, and edge connection tests within the provided test block.

- test — A lambda with receiver that configures the testing environment with assertions.
- Testing.Config
## ai.koog.agents.testing.feature.testGraph

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/test-graph.html`

### :agents:agents-test/commonMain

```kotlin
fun <Input, Output> GraphAIAgent.FeatureContext.testGraph(name: String, test: Testing.Config.SubgraphAssertionsBuilder<Input, Output>.() -> Unit)
```

Installs the Testing feature with graph testing enabled and executes the provided test block.

This is a convenience function that combines withTesting and graph to provide a clean API for testing agent graph structures. It allows you to define and validate the structure, behavior, and connections of nodes within an agent's graph.

- test — A lambda with receiver that configures the testing environment with assertions.
- Testing.Config
- withTesting — Example usage:// Create an agent with testing enabledAIAgent( promptExecutor = mockLLMApi, toolRegistry = toolRegistry, strategy = strategy, eventHandler = eventHandler, agentConfig = agentConfig,) { // Test the agent's graph structure testGraph { // Assert the order of stages assertStagesOrder("first", "second") // Test the first stage stage("first") { val start = startNode() val finish = finishNode() // Assert nodes by name val askLLM = assertNodeByName<String, Message.Response>("callLLM") val callTool = assertNodeByName<ToolCall.Signature, ToolCall.Result>("executeTool") // Assert node reachability assertReachable(start, askLLM) assertReachable(askLLM, callTool) // Test node behavior assertNodes { askLLM withInput "Hello" outputs Message.Assistant("Hello!") askLLM withInput "Solve task" outputs toolCallMessage(CreateTool, CreateTool.Args("solve")) } // Test edge connections assertEdges { askLLM withOutput Message.Assistant("Hello!") goesTo giveFeedback askLLM withOutput toolCallMessage(CreateTool, CreateTool.Args("solve")) goesTo callTool } } }} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.testing.feature.toolCallMessagePart

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/tool-call-message-part.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args> Testing.Config.SubgraphAssertionsBuilder<*, *>.toolCallMessagePart(tool: Tool<Args, *>, args: Args): MessagePart.Tool.Call
```

Creates a MessagePart.Tool.Call instance for the given tool and its arguments.

This utility function simplifies the creation of tool call messages for testing purposes. It automatically handles the encoding of arguments into the appropriate string format.

A MessagePart.Tool.Call object representing a call to the specified tool with the encoded arguments.

Example usage:

- tool — The tool to be represented in the call message. The Tool instance contains metadata such as the tool's name and utility methods for encoding/decoding arguments.
- args — The arguments to be passed to the tool. Must match the type Args defined by the tool.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.feature.toolResult

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/tool-result.html`

### :agents:agents-test/commonMain

```kotlin
fun <TArgs, TResult> Testing.Config.SubgraphAssertionsBuilder<*, *>.toolResult(tool: Tool<TArgs, TResult>, args: TArgs, result: TResult): ReceivedToolResult
```

Converts a tool and its corresponding result into a ReceivedToolResult object.

This utility function simplifies the creation of tool results for testing purposes. It automatically handles the encoding of the result into the appropriate string format.

A ReceivedToolResult instance containing the tool's name and the encoded string representation of the result.

Example usage:

- tool — The tool whose result is being processed. The tool provides context for the result.
- result — The result produced by the tool, which will be encoded into a string representation.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <TArgs> Testing.Config.SubgraphAssertionsBuilder<*, *>.toolResult(tool: SimpleTool<TArgs>, args: TArgs, result: String): ReceivedToolResult
```

Constructs a ReceivedToolResult object using the provided tool and result string.

This is a convenience function for simple tools that return text results. It wraps the string result in a ToolResult.Text object.

An instance of ReceivedToolResult containing the tool's name and the result string.

Example usage:

- tool — The tool for which the result is being created, of type SimpleTool.
- result — The result content generated by the tool execution as a string.

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.feature.withTesting

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.feature/with-testing.html`

### :agents:agents-test/commonMain

```kotlin
fun GraphAIAgent.FeatureContext.withTesting(config: Testing.Config.() -> Unit = {})
```

Enables and configures the Testing feature for a Kotlin AI Agent instance.

This function installs the Testing feature with the specified configuration. It's typically used within the agent constructor block to enable testing capabilities.

- config — A lambda function to configure the Testing feature. The default is an empty configuration.Example usage:// Create an agent with testing enabledAIAgent( promptExecutor = mockLLMApi, toolRegistry = toolRegistry, strategy = strategy, eventHandler = eventHandler, agentConfig = agentConfig,) { // Enable testing with custom configuration withTesting { enableGraphTesting = true handleAssertion { assertionResult -> // Custom assertion handling } }} Content copied to clipboard
- Testing
- Testing.Config

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.testing.tools.DefaultResponseReceiver.DefaultResponseReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-default-response-receiver/-default-response-receiver.html`

### :agents:agents-test/commonMain

```kotlin
constructor(response: String, builder: MockExecutorDSLBuilder)
```

## ai.koog.agents.testing.tools.DefaultResponseReceiver.asDefaultResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-default-response-receiver/as-default-response.html`

### :agents:agents-test/commonMain

```kotlin
val asDefaultResponse: String
```

Sets this response as the default response to be returned when no other response matches.

The response string for method chaining

## ai.koog.agents.testing.tools.DefaultResponseReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-default-response-receiver/index.html`

### :agents:agents-test/commonMain

```kotlin
open class DefaultResponseReceiver(response: String, builder: MockExecutorDSLBuilder)
```

Receiver class for configuring text responses from the LLM.

This class is part of the fluent API for configuring how the LLM should respond with text when it receives specific inputs.

## ai.koog.agents.testing.tools.DefaultResponseReceiver.onCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-default-response-receiver/on-condition.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onCondition(condition: (String) -> Boolean): String
```

Configures the LLM to respond with this string when the user request satisfies the specified condition.

The response string for method chaining

- condition — A function that evaluates the user request and returns true if it matches
## ai.koog.agents.testing.tools.DefaultResponseReceiver.onRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-default-response-receiver/on-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestContains(pattern: String): String
```

Configures the LLM to respond with this string when the user request contains the specified pattern.

The response string for method chaining

- pattern — The substring to look for in the user request
## ai.koog.agents.testing.tools.DefaultResponseReceiver.onRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-default-response-receiver/on-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestEquals(pattern: String): String
```

Configures the LLM to respond with this string when the user request exactly matches the specified pattern.

The response string for method chaining

- pattern — The exact string to match in the user request
## ai.koog.agents.testing.tools.MockExecutorBuilder.MockLLMAnswerBuilder.asDefaultResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/-mock-l-l-m-answer-builder/as-default-response.html`

### :agents:agents-test/commonMain

```kotlin
fun asDefaultResponse(): MockExecutorBuilder
```

Sets this response as the default response to be returned when no other response matches.

The updated MockLLMAnswerBuilder instance for method chaining.

## ai.koog.agents.testing.tools.MockExecutorBuilder.MockLLMAnswerBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/-mock-l-l-m-answer-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockLLMAnswerBuilder
```

A builder class for configuring and managing mocked LLM responses within a MockExecutorBuilder context.

- mockExecutorBuilder — The parent builder for configuring the mock executor.
- response — The mock response to provide based on specified conditions.
## ai.koog.agents.testing.tools.MockExecutorBuilder.MockLLMAnswerBuilder.onCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/-mock-l-l-m-answer-builder/on-condition.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onCondition(condition: (String) -> Boolean): MockExecutorBuilder
```

Configures the LLM to respond with this string when the user request satisfies the specified condition.

The updated MockLLMAnswerBuilder instance for method chaining.

- condition — A function that evaluates the user request and returns true if it matches
## ai.koog.agents.testing.tools.MockExecutorBuilder.MockLLMAnswerBuilder.onRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/-mock-l-l-m-answer-builder/on-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestContains(pattern: String): MockExecutorBuilder
```

Configures the LLM to respond with this string when the user request contains the specified pattern.

The updated MockLLMAnswerBuilder instance for method chaining.

- pattern — The substring to look for in the user request
## ai.koog.agents.testing.tools.MockExecutorBuilder.MockLLMAnswerBuilder.onRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/-mock-l-l-m-answer-builder/on-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestEquals(pattern: String): MockExecutorBuilder
```

Configures the LLM to respond with this string when the user request exactly matches the specified pattern.

The updated MockLLMAnswerBuilder instance for method chaining.

- pattern — The exact string to match in the user request
## ai.koog.agents.testing.tools.MockExecutorBuilder.build

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/build.html`

### :agents:agents-test/commonMain

```kotlin
fun build(): PromptExecutor
```

Builds and returns a configured instance of ai.koog.prompt.executor.model.PromptExecutor using the current state of the MockExecutorBuilder


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.testing.tools.MockExecutorBuilder.clock

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/clock.html`

### :agents:agents-test/commonMain

```kotlin
fun clock(clock: KoogClock): MockExecutorBuilder
```

Sets the clock instance.

The updated MockExecutorBuilder instance for method chaining.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.testing.tools.MockExecutorBuilder.handleLastAssistantMessage

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/handle-last-assistant-message.html`

### :agents:agents-test/commonMain

```kotlin
fun handleLastAssistantMessage(handleLastAssistantMessage: Boolean): MockExecutorBuilder
```

Configures whether the executor should handle the last assistant message during execution.

The updated MockExecutorBuilder instance for method chaining.

## ai.koog.agents.testing.tools.MockExecutorBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockExecutorBuilder
```

Fluent-style builder class for creating a mock prompt executor with configurable tools and behaviors.

## ai.koog.agents.testing.tools.MockExecutorBuilder.mockLLMAnswer

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/mock-l-l-m-answer.html`

### :agents:agents-test/commonMain

```kotlin
fun mockLLMAnswer(text: String): MockExecutorBuilder.MockLLMAnswerBuilder
```

Configures a mock response for a LLM.

The updated MockExecutorBuilder instance for method chaining.

## ai.koog.agents.testing.tools.MockExecutorBuilder.tokenizer

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-builder/tokenizer.html`

### :agents:agents-test/commonMain

```kotlin
fun tokenizer(tokenizer: Tokenizer): MockExecutorBuilder
```

Sets the tokenizer.

The updated MockExecutorBuilder instance for method chaining.


Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MixedResultsReceiver.MixedResultsReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mixed-results-receiver/-mixed-results-receiver.html`

### :agents:agents-test/commonMain

```kotlin
constructor(toolCalls: List<Pair<Tool<Args, *>, Args>>, responses: List<String>, builder: MockExecutorDSLBuilder)
```

- Args — The type of tool arguments.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MixedResultsReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mixed-results-receiver/index.html`

### :agents:agents-test/commonMain

```kotlin
class MixedResultsReceiver<Args>(toolCalls: List<Pair<Tool<Args, *>, Args>>, responses: List<String>, builder: MockExecutorDSLBuilder)
```

Represents a class responsible for handling and managing mixed tool call results based on mock responses and predefined configurations.

- Args — The type of tool arguments.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MixedResultsReceiver.onCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mixed-results-receiver/on-condition.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onCondition(condition: (String) -> Boolean)
```

Configures a conditional response or tool call based on a custom condition provided as a lambda. The condition evaluates user input, and if the condition is satisfied, the associated responses or tool calls are utilized.

- condition — A lambda function that takes a user input string and returns a boolean. If the lambda returns true, the predefined responses or tool calls associated with this condition will be triggered.
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MixedResultsReceiver.onRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mixed-results-receiver/on-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestContains(pattern: String): String
```

Configures the system to partially match user requests containing the specified pattern. If the pattern is found within a user request, the associated tool call response will be triggered.

The pattern string for method chaining

- pattern — The substring pattern to match within user requests.
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MixedResultsReceiver.onRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mixed-results-receiver/on-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestEquals(pattern: String): String
```

Configures the LLM to respond with a tool call when the user request exactly matches the specified pattern.

The pattern string for method chaining

- pattern — The exact string to match in the user request
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockExecutorDSLBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-executor-d-s-l-builder.html`

### :agents:agents-test/commonMain

```kotlin
constructor(clock: KoogClock, serializer: JSONSerializer, tokenizer: Tokenizer? = null)
```

- clock — A clock that is used for mock message timestamps
- serializer — Serializer used to serialize and deserialize tool arguments and results
- tokenizer — Optional tokenizer that will be used to estimate token counts in mock messages

Referenced packages: `ai.koog.prompt.tokenizer`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.MockToolReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/-mock-tool-receiver.html`

### :agents:agents-test/commonMain

```kotlin
constructor(tool: Tool<Args, Result>, builder: MockExecutorDSLBuilder)
```

- Args — The type of arguments the tool accepts
- Result — The type of result the tool produces

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder.MockToolResponseBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/-mock-tool-response-builder/-mock-tool-response-builder.html`

### :agents:agents-test/commonMain

```kotlin
constructor(tool: Tool<Args, Result>, action: suspend () -> Result, builder: MockExecutorDSLBuilder)
```

- Args — The type of arguments the tool accepts
- Result — The type of result the tool produces

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/-mock-tool-response-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockToolResponseBuilder<Args, Result>(tool: Tool<Args, Result>, action: suspend () -> Result, builder: MockExecutorDSLBuilder)
```

Builder class for configuring conditional tool responses.

This class allows you to specify when a tool should return a particular result based on the arguments it receives.

- Args — The type of arguments the tool accepts
- Result — The type of result the tool produces

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder.onArgumentsMatching

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/-mock-tool-response-builder/on-arguments-matching.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onArgumentsMatching(condition: suspend (Args) -> Boolean)
```

Configures the tool to return the specified result when it receives arguments that satisfy the specified condition.

- condition — A function that evaluates the arguments and returns true if they match
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder.onArguments

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/-mock-tool-response-builder/on-arguments.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onArguments(args: Args)
```

Configures the tool to return the specified result when it receives exactly the specified arguments.

- args — The exact arguments to match
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.alwaysDoes

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/always-does.html`

### :agents:agents-test/commonMain

```kotlin
infix fun alwaysDoes(action: suspend () -> Result)
```

Configures the tool to always execute the specified action, regardless of the arguments it receives.

- action — A function that produces the result
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.alwaysReturns

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/always-returns.html`

### :agents:agents-test/commonMain

```kotlin
infix fun alwaysReturns(response: Result)
```

Configures the tool to always return the specified result, regardless of the arguments it receives.

- response — The result to return
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.does

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/does.html`

### :agents:agents-test/commonMain

```kotlin
infix fun does(action: suspend () -> Result): MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder<Args, Result>
```

Configures the tool to execute the specified action when it receives matching arguments.

A MockToolResponseBuilder for further configuration

- action — A function that produces the result
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockToolReceiver<Args, Result>(tool: Tool<Args, Result>, builder: MockExecutorDSLBuilder)
```

Receiver class for configuring tool behavior during testing.

This class is part of the fluent API for configuring how tools should behave when they are called during testing.

- Args — The type of arguments the tool accepts
- Result — The type of result the tool produces

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MockToolReceiver.returns

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-mock-tool-receiver/returns.html`

### :agents:agents-test/commonMain

```kotlin
infix fun returns(result: Result): MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder<Args, Result>
```

Configures the tool to return the specified result when it receives matching arguments.

A MockToolResponseBuilder for further configuration

- result — The result to return
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MultiToolCallReceiver.MultiToolCallReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-multi-tool-call-receiver/-multi-tool-call-receiver.html`

### :agents:agents-test/commonMain

```kotlin
constructor(toolCalls: List<Pair<Tool<Args, *>, Args>>, builder: MockExecutorDSLBuilder)
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MultiToolCallReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-multi-tool-call-receiver/index.html`

### :agents:agents-test/commonMain

```kotlin
class MultiToolCallReceiver<Args>(toolCalls: List<Pair<Tool<Args, *>, Args>>, builder: MockExecutorDSLBuilder)
```

Receiver class for configuring tool call responses from the LLM. This class is part of the fluent API for configuring how the LLM should respond with tool calls when it receives specific inputs.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MultiToolCallReceiver.onRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-multi-tool-call-receiver/on-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestContains(pattern: String): String
```

Configures the system to partially match user requests containing the specified pattern. If the pattern is found within a user request, the associated tool call response will be triggered.

The pattern string for method chaining

- pattern — The substring pattern to match within user requests.
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.MultiToolCallReceiver.onRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-multi-tool-call-receiver/on-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestEquals(pattern: String): String
```

Configures the LLM to respond with a tool call when the user request exactly matches the specified pattern.

The pattern string for method chaining

- pattern — The exact string to match in the user request
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.TextToolResult.TextToolResult

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-text-tool-result/-text-tool-result.html`

### :agents:agents-test/commonMain

```kotlin
constructor(text: String)
```

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.TextToolResult

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-text-tool-result/index.html`

### :agents:agents-test/commonMain

```kotlin
@Serializable data class TextToolResult(val text: String)
```

A data class representing the tool result that is just text (String).

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.TextToolResult.text

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-text-tool-result/text.html`

### :agents:agents-test/commonMain

```kotlin
val text: String
```

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.ToolCallReceiver.ToolCallReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-tool-call-receiver/-tool-call-receiver.html`

### :agents:agents-test/commonMain

```kotlin
constructor(tool: Tool<Args, *>, args: Args, toolCallId: String?, builder: MockExecutorDSLBuilder)
```

- Args — The type of arguments the tool accepts

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.ToolCallReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-tool-call-receiver/index.html`

### :agents:agents-test/commonMain

```kotlin
class ToolCallReceiver<Args>(tool: Tool<Args, *>, args: Args, toolCallId: String?, builder: MockExecutorDSLBuilder)
```

Receiver class for configuring tool call responses from the LLM.

This class is part of the fluent API for configuring how the LLM should respond with tool calls when it receives specific inputs.

- Args — The type of arguments the tool accepts

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.ToolCallReceiver.onCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-tool-call-receiver/on-condition.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onCondition(condition: (String) -> Boolean)
```

Configures the LLM to respond with a tool call based on a custom condition.

- condition — A predicate function that takes a string input and returns a Boolean. The condition determines whether the associated tool call should be triggered.
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.ToolCallReceiver.onRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-tool-call-receiver/on-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestContains(pattern: String): String
```

Configures the system to partially match user requests containing the specified pattern. If the pattern is found within a user request, the associated tool call response will be triggered.

The pattern string for method chaining

- pattern — The substring pattern to match within user requests.
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.ToolCallReceiver.onRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/-tool-call-receiver/on-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestEquals(pattern: String): String
```

Configures the LLM to respond with a tool call when the user request exactly matches the specified pattern.

The pattern string for method chaining

- pattern — The exact string to match in the user request
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.addLLMAnswerConditionalMatches

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/add-l-l-m-answer-conditional-matches.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerConditionalMatches(condition: (String) -> Boolean, tool: Tool<Args, *>, args: Args)
```

Adds a conditional match for a tool call to the LLM answer processing system. This method associates a condition with a tool and its arguments, allowing conditional execution of the tool when the specified condition matches.

- condition — A predicate function that takes a string input and returns a Boolean, indicating whether the condition is met.
- tool — The tool object to be called if the condition is satisfied.
- args — The arguments to be passed to the tool, which will be encoded to a string for the tool call.

Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerConditionalMatches(condition: (String) -> Boolean, toolCalls: List<Pair<Tool<Args, *>, Args>>, responses: List<String>)
```

Registers conditional matches linking logical conditions to tool calls and corresponding responses.

- condition — A predicate function that takes a String and returns a Boolean indicating whether the condition is satisfied.
- toolCalls — A list of tool calls represented as pairs where the first element is the tool reference and the second is its arguments.
- responses — A list of response strings to be associated with the condition.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.addLLMAnswerExactPattern

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/add-l-l-m-answer-exact-pattern.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerExactPattern(pattern: String, tool: Tool<Args, *>, args: Args, toolCallId: String?)
```

Adds an exact pattern match for an LLM answer that triggers a tool call.

- pattern — The exact input string to match
- tool — The tool to be called when the input matches
- args — The arguments to pass to the tool

Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerExactPattern(pattern: String, toolCalls: List<Pair<Tool<Args, *>, Args>>)
```

Adds an exact pattern match for an LLM answer that triggers a set of tool calls.

- pattern — The exact input string to match
- toolCalls — Tool calls with args

Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerExactPattern(pattern: String, toolCalls: List<Pair<Tool<Args, *>, Args>>, responses: List<String>)
```

Adds an exact pattern match for an LLM answer that triggers a set of tool calls with predefined responses.

- pattern — The exact input string to match.
- toolCalls — A list of tool call and argument pairs to be triggered when the input matches.
- responses — A list of response strings corresponding to each tool call.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.addLLMAnswerPartialPattern

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/add-l-l-m-answer-partial-pattern.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerPartialPattern(pattern: String, tool: Tool<Args, *>, args: Args)
```

Adds a partial pattern match for an LLM answer that triggers a tool call.

- pattern — The exact input string to match
- tool — The tool to be called when the input matches
- args — The arguments to pass to the tool

Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerPartialPattern(pattern: String, toolCalls: List<Pair<Tool<Args, *>, Args>>)
```

Adds a partial pattern match for an LLM answer that triggers a set of tool calls.

- pattern — The substring pattern to partially match in the user request.
- toolCalls — A list of pairs, where each pair consists of a tool and the arguments to pass to the tool. These tool calls will be triggered when the input matches the pattern.

Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> addLLMAnswerPartialPattern(pattern: String, toolCalls: List<Pair<Tool<Args, *>, Args>>, responses: List<String>)
```

Adds a partial pattern match for an LLM answer that triggers a set of tool calls with predefined responses.

- pattern — The substring pattern to partially match in the user request.
- toolCalls — A list of tool call and argument pairs to be triggered when the input matches.
- responses — A list of response strings corresponding to each tool call.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.addModerationResponseExactPattern

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/add-moderation-response-exact-pattern.html`

### :agents:agents-test/commonMain

```kotlin
fun addModerationResponseExactPattern(pattern: String, response: ModerationResult)
```

Adds a specific moderation response for an exact pattern match.

- pattern — The exact string pattern that should be matched.
- response

Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.addModerationResponsePartialPattern

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/add-moderation-response-partial-pattern.html`

### :agents:agents-test/commonMain

```kotlin
fun addModerationResponsePartialPattern(pattern: String, response: ModerationResult)
```

Associates a given moderation response with a specific partial pattern.

- pattern — The string pattern to be used as a key for the moderation response.
- response — The ModerationResult object that corresponds to the given pattern.

Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.addToolAction

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/add-tool-action.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args, Result> addToolAction(tool: Tool<Args, Result>, argsCondition: suspend (Args) -> Boolean = { true }, action: suspend (Args) -> Result)
```

Adds a tool action to be executed when a tool call matches the specified condition.

- tool — The tool to be mocked
- argsCondition — A function that determines if the tool call arguments match this action
- action — A function that produces the result when the condition is satisfied

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.alwaysReturns

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/always-returns.html`

### :agents:agents-test/commonMain

```kotlin
infix fun <Args> MockExecutorDSLBuilder.MockToolReceiver<Args, String>.alwaysReturns(response: String)
```

Convenience extension function for configuring a text tool to always return the specified string.

The result of the alwaysReturns call

- response — The string to return
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.alwaysTells

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/always-tells.html`

### :agents:agents-test/commonMain

```kotlin
infix fun <Args> MockExecutorDSLBuilder.MockToolReceiver<Args, String>.alwaysTells(action: suspend () -> String)
```

### :agents:agents-test/commonMain

```kotlin
infix fun <Args> MockExecutorDSLBuilder.MockToolReceiver<Args, MockExecutorDSLBuilder.TextToolResult>.alwaysTells(action: suspend () -> String)
```

Convenience extension function for configuring a text tool to always execute the specified action and return its string result.

The result of the alwaysDoes call

- action — A function that produces the string result
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.build

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/build.html`

### :agents:agents-test/commonMain

```kotlin
fun build(): PromptExecutor
```

Builds and returns a PromptExecutor configured with the mock responses and tool actions.

This method combines all the configured responses and tool actions into a MockLLMExecutor that can be used for testing.

A configured MockLLMExecutor instance


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.doesStr

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/does-str.html`

### :agents:agents-test/commonMain

```kotlin
infix fun <Args> MockExecutorDSLBuilder.MockToolReceiver<Args, MockExecutorDSLBuilder.TextToolResult>.doesStr(action: suspend () -> String): MockExecutorDSLBuilder.MockToolReceiver.MockToolResponseBuilder<Args, MockExecutorDSLBuilder.TextToolResult>
```

Convenience extension function for configuring a text tool to execute the specified action and return its string result when it receives matching arguments.

The result of the does call

- action — A function that produces the string result
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.handleLastAssistantMessage

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/handle-last-assistant-message.html`

### :agents:agents-test/commonMain

```kotlin
var handleLastAssistantMessage: Boolean
```

Determines whether the last message handled in a sequence should focus specifically on the most recent message categorized as Message.Assistant when resolving mock responses.

Useful in scenarios where the mock response handling involves mixed results from the LLM, and there is a need to differentiate between handling the general last message vs. the last assistant-specific message.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockExecutorDSLBuilder(clock: KoogClock, serializer: JSONSerializer, tokenizer: Tokenizer? = null)
```

Builder class for creating mock LLM executors for testing.

This class provides a fluent API for configuring mock responses for LLM requests and tool calls. It allows you to define how the LLM should respond to different inputs and how tools should behave when called during testing.

- clock — A clock that is used for mock message timestamps
- serializer — Serializer used to serialize and deserialize tool arguments and results
- tokenizer — Optional tokenizer that will be used to estimate token counts in mock messages
- getMockExecutor — Prefer it for creating and configuring mock LLM executors.

Referenced packages: `ai.koog.prompt.tokenizer`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.mockLLMAnswer

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/mock-l-l-m-answer.html`

### :agents:agents-test/commonMain

```kotlin
fun mockLLMAnswer(response: String): DefaultResponseReceiver
```

Creates a mock LLM text response.

This function is the entry point for configuring how the LLM should respond with text when it receives specific inputs.

A DefaultResponseReceiver for further configuration

Example usage:

- response — The text response to return
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.mockLLMMixedResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/mock-l-l-m-mixed-response.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args> mockLLMMixedResponse(toolCalls: List<Pair<Tool<Args, *>, Args>>, responses: List<String>): MockExecutorDSLBuilder.MixedResultsReceiver<Args>
```

Creates a mock response with a combination of tool calls and predefined string responses.

This method is used to define a mixed behavior where the LLM produces a sequence of tool calls along with corresponding responses for testing purposes.

A MixedResultsReceiver to configure further mock behavior for the provided tool calls and responses.

- toolCalls — A list of pairs, where each pair consists of a tool and the corresponding arguments.
- responses — A list of response strings corresponding to the provided tool calls. These define what the LLM should output for each tool call.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.mockLLMStream

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/mock-l-l-m-stream.html`

### :agents:agents-test/commonMain

```kotlin
fun mockLLMStream(stream: Flow<StreamFrame>): StreamResponseReceiver
```

Creates a mock LLM streaming response.

This function is the entry point for configuring how the LLM should respond with stream frames when it receives specific inputs.

A StreamResponseReceiver for further configuration

- stream — The stream response to return

Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.mockLLMToolCall

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/mock-l-l-m-tool-call.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args> mockLLMToolCall(tool: Tool<Args, *>, args: Args, toolCallId: String? = null): MockExecutorDSLBuilder.ToolCallReceiver<Args>
```

Creates a mock for an LLM tool call.

This method is used to define how the LLM should respond with a tool call when it receives a specific input.

A ToolCallReceiver for further configuration

- tool — The tool to be called
- args — The arguments to pass to the tool

Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-test/commonMain

```kotlin
fun <Args> mockLLMToolCall(toolCalls: List<Pair<Tool<Args, *>, Args>>): MockExecutorDSLBuilder.MultiToolCallReceiver<Args>
```

Creates a mock for a list of LLM tool calls.

This method is used to define how the LLM should respond with multiple tool calls when specific inputs or conditions are encountered during testing.

A MultiToolCallReceiver to configure further mock behavior for the provided tool calls.

- toolCalls — A list of pairs, where each pair consists of a tool and corresponding arguments. These define the mock calls to be returned by the LLM.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.mockTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/mock-tool.html`

### :agents:agents-test/commonMain

```kotlin
fun <Args, Result> mockTool(tool: Tool<Args, Result>): MockExecutorDSLBuilder.MockToolReceiver<Args, Result>
```

Creates a mock for a tool.

This method is used to define how a tool should behave when it is called during testing.

A MockToolReceiver for further configuration

- tool — The tool to be mocked

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.onCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/on-condition.html`

### :agents:agents-test/commonMain

```kotlin
infix fun String.onCondition(condition: (String) -> Boolean): MockExecutorDSLBuilder
```

Configures the LLM to respond with this string when the user request satisfies the specified condition.

The MockLLMBuilder instance for method chaining

- condition — A function that evaluates the user request and returns true if it matches
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.onUserRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/on-user-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun String.onUserRequestContains(pattern: String): MockExecutorDSLBuilder
```

Configures the LLM to respond with this string when the user request contains the specified pattern.

The MockLLMBuilder instance for method chaining

- pattern — The substring to look for in the user request
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.onUserRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/on-user-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun String.onUserRequestEquals(pattern: String): MockExecutorDSLBuilder
```

Configures the LLM to respond with this string when the user request exactly matches the specified pattern.

The MockLLMBuilder instance for method chaining

- pattern — The exact string to match in the user request
## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.setDefaultModerationResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/set-default-moderation-response.html`

### :agents:agents-test/commonMain

```kotlin
fun setDefaultModerationResponse(result: ModerationResult)
```

Sets the default moderation response to the provided result.


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.setDefaultResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/set-default-response.html`

### :agents:agents-test/commonMain

```kotlin
fun setDefaultResponse(response: String)
```

Sets the default response to be returned when no other response matches.

## ai.koog.agents.testing.tools.MockExecutorDSLBuilder.setDefaultStreamResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-executor-d-s-l-builder/set-default-stream-response.html`

### :agents:agents-test/commonMain

```kotlin
fun setDefaultStreamResponse(stream: Flow<StreamFrame>)
```

Sets the default stream response to be returned when no other stream response matches.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.MockPromptExecutor.Companion.builder

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/-companion/builder.html`

### :agents:agents-test/commonMain

```kotlin
fun builder(serializer: JSONSerializer): MockExecutorBuilder
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.testing.tools.MockPromptExecutor.Companion

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/-companion/index.html`

### :agents:agents-test/commonMain

```kotlin
object Companion
```

## ai.koog.agents.testing.tools.MockPromptExecutor.close

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/close.html`

### :agents:agents-test/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.testing.tools.MockPromptExecutor.executeStreaming

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/execute-streaming.html`

### :agents:agents-test/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Executes a prompt and returns a flow of string responses.

This implementation simply wraps the result of execute in a flow.

A flow containing a single string response

- prompt — The prompt to execute
- model — The LLM model to use (ignored in mock implementation)
- tools — The list of tools available for the execution

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.MockPromptExecutor.execute

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/execute.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```

Executes a prompt with tools and returns a list of responses.

A list containing a single response

- prompt — The prompt to execute
- model — The LLM model to use (ignored in mock implementation)
- tools — The list of tools available for the execution

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.testing.tools.MockPromptExecutor

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/index.html`

### :agents:agents-test/commonMain

```kotlin
class MockPromptExecutor : PromptExecutor
```

A mock implementation of PromptExecutor used for testing.

This class simulates an LLM by returning predefined responses based on the input prompt. It supports different types of matching:

Exact matching - Returns a response when the input exactly matches pattern

Partial matching - Returns a response when the input contains a pattern

Conditional matching - Returns a response when the input satisfies condition

Default response - Returns a default response when no other matches are found

It also supports tool calls and can be configured to return specific tool results.


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.testing.tools.MockPromptExecutor.moderate

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-mock-prompt-executor/moderate.html`

### :agents:agents-test/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Processes a given prompt to determine if it adheres to moderation rules and returns a moderation result.

The method evaluates the last message in the prompt for exact and partial matches against predefined moderation rules. If no matches are found, it returns a default moderation response.

The result of the moderation, based on matches or default rules.

- prompt — The prompt containing the message to be moderated.
- model — The LLM model used for processing (ignored in this implementation).

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.agents.testing.tools.StreamResponseReceiver.StreamResponseReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-stream-response-receiver/-stream-response-receiver.html`

### :agents:agents-test/commonMain

```kotlin
constructor(stream: Flow<StreamFrame>, builder: MockExecutorDSLBuilder)
```


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.StreamResponseReceiver.asDefaultResponse

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-stream-response-receiver/as-default-response.html`

### :agents:agents-test/commonMain

```kotlin
val asDefaultResponse: Flow<StreamFrame>
```

Sets this stream as the default response to be returned when no other response matches.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.StreamResponseReceiver

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-stream-response-receiver/index.html`

### :agents:agents-test/commonMain

```kotlin
class StreamResponseReceiver(stream: Flow<StreamFrame>, builder: MockExecutorDSLBuilder)
```

Receiver class for configuring streaming responses from the LLM.

This class is part of the fluent API for configuring how the LLM should respond with stream frames when it receives specific inputs.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.StreamResponseReceiver.onRequestContains

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-stream-response-receiver/on-request-contains.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestContains(pattern: String): Flow<StreamFrame>
```

Configures the LLM to respond with this stream when the user request contains the specified pattern.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.StreamResponseReceiver.onRequestEquals

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-stream-response-receiver/on-request-equals.html`

### :agents:agents-test/commonMain

```kotlin
infix fun onRequestEquals(pattern: String): Flow<StreamFrame>
```

Configures the LLM to respond with this stream when the user request exactly matches the specified pattern.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.ToolCondition.ToolCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-tool-condition/-tool-condition.html`

### :agents:agents-test/commonMain

```kotlin
constructor(tool: Tool<Args, Result>, serializer: JSONSerializer, argsCondition: suspend (Args) -> Boolean, produceResult: suspend (Args) -> Result)
```

- Args — The type of arguments the tool accepts
- Result — The type of result the tool produces

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.ToolCondition.argsCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-tool-condition/args-condition.html`

### :agents:agents-test/commonMain

```kotlin
val argsCondition: suspend (Args) -> Boolean
```

## ai.koog.agents.testing.tools.ToolCondition

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-tool-condition/index.html`

### :agents:agents-test/commonMain

```kotlin
class ToolCondition<Args, Result>(val tool: Tool<Args, Result>, val serializer: JSONSerializer, val argsCondition: suspend (Args) -> Boolean, val produceResult: suspend (Args) -> Result)
```

Represents a condition for a tool call and its corresponding result.

This class is used to define how a tool should respond to specific inputs during testing. It encapsulates the tool, a condition to check if the tool call matches, and a function to produce the result when the condition is satisfied.

- Args — The type of arguments the tool accepts
- Result — The type of result the tool produces

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.testing.tools.ToolCondition.produceResult

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-tool-condition/produce-result.html`

### :agents:agents-test/commonMain

```kotlin
val produceResult: suspend (Args) -> Result
```

## ai.koog.agents.testing.tools.ToolCondition.serializer

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-tool-condition/serializer.html`

### :agents:agents-test/commonMain

```kotlin
val serializer: JSONSerializer
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.testing.tools.ToolCondition.tool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/-tool-condition/tool.html`

### :agents:agents-test/commonMain

```kotlin
val tool: Tool<Args, Result>
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.testing.tools.getMockExecutor

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/get-mock-executor.html`

### :agents:agents-test/commonMain

```kotlin
fun getMockExecutor(serializer: JSONSerializer = KotlinxSerializer(), clock: KoogClock = KoogClock.System, tokenizer: Tokenizer? = null, handleLastAssistantMessage: Boolean = false, init: MockExecutorDSLBuilder.() -> Unit): PromptExecutor
```

Creates a mock LLM executor for testing.

This function provides a convenient way to create a mock LLM executor with the specified tool registry and configuration. It handles the setup of the MockLLMBuilder and applies all the configured responses and tool actions.

Сonfigured PromptExecutor for testing

Example usage:

- serializer — Serializer used to serialize and deserialize tool arguments and results
- clock — : A clock that is used for mock message timestamps
- tokenizer — : Tokenizer that will be used to estimate token counts in mock messages
- init — A lambda with receiver that configures the mock LLM executor

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.tokenizer`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.testing.tools.mockLLMAnswer

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/mock-l-l-m-answer.html`

### :agents:agents-test/commonMain

```kotlin
fun MockExecutorDSLBuilder.mockLLMAnswer(response: String): DefaultResponseReceiver
```

Top-level wrapper for importing mockLLMAnswer into DSL-based tests.

## ai.koog.agents.testing.tools.mockLLMStream

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/mock-l-l-m-stream.html`

### :agents:agents-test/commonMain

```kotlin
fun MockExecutorDSLBuilder.mockLLMStream(stream: Flow<StreamFrame>): StreamResponseReceiver
```

Top-level wrapper for importing mockLLMStream into DSL-based tests.


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.testing.tools.mockLLMToolCall

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/mock-l-l-m-tool-call.html`

### :agents:agents-test/jvmMain

```kotlin
fun MockExecutorDSLBuilder.mockLLMToolCall(tool: KFunction<*>, vararg args: Any?, toolCallId: String? = null): MockExecutorDSLBuilder.ToolCallReceiver<ToolFromCallable.Args>
```

Mocks a tool call for the provided tool function and arguments.

A ToolCallReceiver instance configured with the tool and its arguments.

- tool — The function representing the tool to be mocked.
- args — The arguments to be passed to the tool function.

Referenced packages: `ai.koog.agents.core.tools.reflect`.

## ai.koog.agents.testing.tools.mockTool

Module: `agents-test`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-test/ai.koog.agents.testing.tools/mock-tool.html`

### :agents:agents-test/jvmMain

```kotlin
infix fun <Result> MockExecutorDSLBuilder.mockTool(tool: KFunction<Result>): MockToolFromCallableReceiver<Result>
```

Associates a tool function with the MockLLMBuilder to create a MockToolFromCallableReceiver instance.

A MockToolFromCallableReceiver instance configured with the provided tool function and the current MockLLMBuilder.

- tool — The function to be used as the tool in the mock setup.