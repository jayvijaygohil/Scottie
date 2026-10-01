# agents / agents-core

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.core.agent.AIAgentServiceBuilder.functionalStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder/functional-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input, Output> functionalStrategy(name: String = "funStrategy", strategy: BiFunction<AIAgentFunctionalContext, Input, Output>): FunctionalAgentServiceBuilder<Input, Output>
```

Creates a functional agent service builder using the provided strategy.

This method allows defining a custom functional strategy for the AI agent.

A FunctionalAgentBuilder configured with the specified functional strategy.

- name — The name identifying the functional strategy. Defaults to "funStrategy".
- strategy — The implementation of the functional strategy's execution logic.
- Input — The type of the input parameter for the strategy's execution logic.
- Output — The type of the output returned by the strategy's execution logic.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.AIAgentServiceBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentServiceBuilder : AIAgentServiceBuilderCommon<AIAgentServiceBuilder>
```

Builder for creating AIAgentService instances.

Mirrors AIAgentBuilder but returns service-level objects:

GraphAIAgentService

FunctionalAIAgentService

### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentServiceBuilder : AIAgentServiceBuilderCommon<AIAgentServiceBuilder>
```

Builder for creating AIAgentService instances.

Mirrors AIAgentBuilder but returns service-level objects:

GraphAIAgentService

FunctionalAIAgentService

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentServiceBuilder : AIAgentServiceBuilderCommon<AIAgentServiceBuilder>
```

Builder for creating AIAgentService instances.

Mirrors AIAgentBuilder but returns service-level objects:

GraphAIAgentService

FunctionalAIAgentService

## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
fun agentConfig(config: AIAgentConfig): Self
```

Configures the current builder instance using the provided AIAgentConfig.

This method applies the settings from the given AIAgentConfig, such as the prompt, language model, maximum agent iterations, and strategy to handle missing tools, to the builder instance.

The current builder instance for chaining further methods.

- config — An AIAgentConfig instance containing the configuration settings to be applied.

Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentServiceBuilderBase<Self : AIAgentServiceBuilderBase<Self>>
```

Shared fluent configuration for agent service builders.

- AIAgentBuilderBase
- AIAgentServiceBuilderCommon
## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.llmModel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/llm-model.html`

### :agents:agents-core/commonMain

```kotlin
fun llmModel(model: LLModel): Self
```

Sets the LLModel instance to be used by the builder.

This method configures the builder with a specified Large Language Model (LLM), representing the model's provider, identifier, capabilities, and constraints such as context length or maximum output tokens.

The current builder instance for chaining additional configurations.

- model — The LLModel instance representing the large language model to set.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.maxIterations

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/max-iterations.html`

### :agents:agents-core/commonMain

```kotlin
fun maxIterations(maxIterations: Int): Self
```

Sets the maximum number of iterations for the builder.

The current builder instance.

- maxIterations — The maximum number of iterations to be used. Must be a positive integer.
## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.numberOfChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/number-of-choices.html`

### :agents:agents-core/commonMain

```kotlin
fun numberOfChoices(numberOfChoices: Int): Self
```

Sets the number of choices to be utilized by the builder instance.

This method configures the builder with a specified number of discrete choices, which could be utilized in the decision-making process or output generation.

The current builder instance for chaining additional configurations.

- numberOfChoices — The integer representing the number of choices to configure. Must be a positive value.
## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
fun promptExecutor(promptExecutor: PromptExecutor): Self
```

Sets the PromptExecutor to be used by the builder instance.

This method configures the builder with the provided PromptExecutor, which is responsible for executing prompts against language models, managing tool interactions, and handling output.

The current builder instance for chaining additional configurations.

- promptExecutor — An instance of PromptExecutor that will be utilized for processing prompts and interacting with language models.

Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/prompt.html`

### :agents:agents-core/commonMain

```kotlin
fun prompt(prompt: Prompt): Self
```

Sets the prompt to be used by the builder.

The current builder instance.

- prompt — The Prompt instance to set.

Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.responseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/response-processor.html`

### :agents:agents-core/commonMain

```kotlin
fun responseProcessor(responseProcessor: ResponseProcessor): Self
```

Sets the response processor for the agent.


Referenced packages: `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.systemPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/system-prompt.html`

### :agents:agents-core/commonMain

```kotlin
fun systemPrompt(systemPrompt: String): Self
```

Sets the system prompt to be used by the builder.

This method configures the prompt with a system-level message that provides instructions or context for a language model.

The current builder instance with the updated system prompt.

- systemPrompt — The content of the system message to set as the prompt.
## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.temperature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/temperature.html`

### :agents:agents-core/commonMain

```kotlin
fun temperature(temperature: Double): Self
```

Sets the temperature value for the builder.

Temperature is typically used to control the randomness of outputs in language models. Higher values result in more random outputs, while lower values make outputs more deterministic.

The current builder instance for method chaining.

- temperature — The temperature value to set. It should be a non-negative double, where common values are within the range [0.0, 1.0].
## ai.koog.agents.core.agent.AIAgentServiceBuilderBase.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-base/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
fun toolRegistry(toolRegistry: ToolRegistry): Self
```

Sets the given ToolRegistry instance to the builder configuration.

The current builder instance for chaining further configurations.

- toolRegistry — The instance of ToolRegistry to be used in the builder.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderCommon.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-common/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): GraphAIAgentService<String, String>
```

Convenience build for GraphAIAgentService using singleRunStrategy.

## ai.koog.agents.core.agent.AIAgentServiceBuilderCommon.functionalStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-common/functional-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> functionalStrategy(strategy: AIAgentFunctionalStrategy<Input, Output>): FunctionalAgentServiceBuilder<Input, Output>
```

Configure a functional strategy and continue with a functional service builder.

## ai.koog.agents.core.agent.AIAgentServiceBuilderCommon.graphStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-common/graph-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> graphStrategy(strategy: AIAgentGraphStrategy<Input, Output>): GraphAgentServiceBuilder<Input, Output>
```

Configure a graph strategy and continue with a graph service builder.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.AIAgentServiceBuilderCommon

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-builder-common/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentServiceBuilderCommon<Self : AIAgentServiceBuilderCommon<Self>> : AIAgentServiceBuilderBase<Self>
```

Common chained implementation for AIAgentServiceBuilder actual classes.

- AIAgentServiceBuilder
## ai.koog.agents.core.agent.AIAgentState.Failed.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-failed/copy.html`

### :agents:agents-core/commonMain

```kotlin
open override fun copy(): AIAgentState<Output>
```

Creates and returns a copy of the current state object.

A new instance of AIAgentState<Output> that is a copy of the current object.

## ai.koog.agents.core.agent.AIAgentState.Finished.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-finished/copy.html`

### :agents:agents-core/commonMain

```kotlin
open override fun copy(): AIAgentState<Output>
```

Creates and returns a copy of the current state object.

A new instance of AIAgentState<Output> that is a copy of the current object.

## ai.koog.agents.core.agent.AIAgentState.NotStarted.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-not-started/copy.html`

### :agents:agents-core/commonMain

```kotlin
open override fun copy(): AIAgentState<Output>
```

Creates and returns a copy of the current state object.

A new instance of AIAgentState<Output> that is a copy of the current object.

## ai.koog.agents.core.agent.AIAgentState.Running.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-running/copy.html`

### :agents:agents-core/commonMain

```kotlin
open override fun copy(): AIAgentState<Output>
```

Creates and returns a copy of the current state object.

A new instance of AIAgentState<Output> that is a copy of the current object.

## ai.koog.agents.core.agent.AIAgentState.Starting.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-starting/copy.html`

### :agents:agents-core/commonMain

```kotlin
open override fun copy(): AIAgentState<Output>
```

Creates and returns a copy of the current state object.

A new instance of AIAgentState<Output> that is a copy of the current object.

## ai.koog.agents.core.agent.AIAgentState.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/copy.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun copy(): AIAgentState<Output>
```

Creates and returns a copy of the current state object.

A new instance of AIAgentState<Output> that is a copy of the current object.

## ai.koog.agents.core.agent.DiagramGenerator.generate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-diagram-generator/generate.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun generate(graph: AIAgentGraphStrategy<*, *>): String
```

Generates a diagram representation of the provided AI agent graph strategy.

A string representation of the diagram generated from the given graph strategy.

- graph — The AI agent graph strategy to be translated into a diagram format. This strategy consists of interconnected nodes defining the workflow of an AI agent.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.DiagramGenerator

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-diagram-generator/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
interface DiagramGenerator
```

Provides functionality to generate diagram representations of AI agent strategies configured as graphs. Implementations of this interface are responsible for translating an AIAgentGraphStrategy into a textual or visual format suitable for understanding and visualization of agent workflows.

- MermaidDiagramGenerator
## ai.koog.agents.core.agent.FunctionalAIAgentService.FunctionalAIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/-functional-a-i-agent-service.html`

### :agents:agents-core/commonMain

```kotlin
constructor(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentFunctionalStrategy<Input, Output>, toolRegistry: ToolRegistry, installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit)
```

- Input — The type of input data that the functional AI agent will process.
- Output — The type of output data produced by the functional AI agent.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.FunctionalAIAgentService.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentConfig: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.FunctionalAIAgentService.createManagedAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/create-managed-agent.html`

### :agents:agents-core/commonMain

```kotlin
open override fun createManagedAgent(id: String? = null, additionalToolRegistry: ToolRegistry, agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System): FunctionalAIAgent<Input, Output>
```

Creates and returns a managed instance of FunctionalAIAgent.

A managed AI agent instance implementing the AIAgent interface.

- clock — The clock instance used for time-related operations within the agent.
- id — The identifier for the agent. Random UUID will be generated if set to null.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/index.html`

### :agents:agents-core/commonMain

```kotlin
class FunctionalAIAgentService<Input, Output>(val promptExecutor: PromptExecutor, val agentConfig: AIAgentConfig, val strategy: AIAgentFunctionalStrategy<Input, Output>, val toolRegistry: ToolRegistry, val installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit) : AIAgentServiceBase<Input, Output, FunctionalAIAgent<Input, Output>>
```

A service for managing functional AI agents that operate based on a specified execution strategy.

This class provides the infrastructure for creating and managing functional AI agents. It integrates an execution strategy with associated input and output types, a tool registry for additional functionalities, and a customizable feature installation context.

- Input — The type of input data that the functional AI agent will process.
- Output — The type of output data produced by the functional AI agent.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.FunctionalAIAgentService.installFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/install-features.html`

### :agents:agents-core/commonMain

```kotlin
val installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit
```

## ai.koog.agents.core.agent.FunctionalAIAgentService.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
open override val promptExecutor: PromptExecutor
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.FunctionalAIAgentService.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/strategy.html`

### :agents:agents-core/commonMain

```kotlin
val strategy: AIAgentFunctionalStrategy<Input, Output>
```

## ai.koog.agents.core.agent.FunctionalAIAgentService.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent-service/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolRegistry: ToolRegistry
```

Represents the central repository or registry for managing tools within the system.

This variable provides access to a tool registry that can be used to store, retrieve, and manage different tools registered in the application.

It is expected to be immutable and thread-safe, ensuring consistent behavior across the application.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.FunctionalAgentServiceBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-service-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): FunctionalAIAgentService<Input, Output>
```

Builds and returns a configured instance of FunctionalAIAgentService.

This method initializes the necessary components, including the prompt executor and language model, and uses the provided configuration parameters to construct a functional AI agent service. The service supports the execution of features and tools through the defined strategy and installed context.

A fully configured instance of FunctionalAIAgentService ready to process input and generate output using the specified execution strategy, tools, and features.

## ai.koog.agents.core.agent.FunctionalAgentServiceBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-service-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class FunctionalAgentServiceBuilder<Input, Output> : AIAgentBuilderBase<FunctionalAgentServiceBuilder<Input, Output>>
```

A builder class for constructing a FunctionalAIAgentService, enabling a fluent configuration style.

This class allows customization of various parameters and components required for the AI agent service, including strategies, prompts, models, tool registries, and other operational settings.

- Input — The type of data input to the AI agent during execution.
- Output — The type of data output by the AI agent after processing.
## ai.koog.agents.core.agent.FunctionalAgentServiceBuilder.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-service-builder/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentFunctionalFeature<TConfig, *>, configure: ConfigureAction<TConfig>): FunctionalAgentServiceBuilder<Input, Output>
```

Installs the specified feature into the functional service builder and applies the provided configuration.

The current instance of FunctionalAgentServiceBuilder with the feature installed.

- feature — The functional AI agent feature to be installed.
- configure — A configuration action used to customize the feature's settings.
- TConfig — The type of configuration required for the feature, extending FeatureConfig.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`, `ai.koog.agents.core.utils`.

## ai.koog.agents.core.agent.GraphAIAgentService.GraphAIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/-graph-a-i-agent-service.html`

### :agents:agents-core/commonMain

```kotlin
constructor(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentGraphStrategy<Input, Output>, toolRegistry: ToolRegistry, installFeatures: GraphAIAgent.FeatureContext.() -> Unit)
```

- promptExecutor — An instance of PromptExecutor, responsible for executing prompts using language models and handling responses.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.GraphAIAgentService.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentConfig: AIAgentConfig
```

Holds the configuration details for an AI agent.

This property encapsulates the settings and parameters required to initialize and operate an AI agent, such as behavior configurations, thresholds, or any specific operational constraints. It is essential for defining the agent's behavior and performance.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.GraphAIAgentService.createManagedAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/create-managed-agent.html`

### :agents:agents-core/commonMain

```kotlin
open override fun createManagedAgent(id: String? = null, additionalToolRegistry: ToolRegistry, agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System): GraphAIAgent<Input, Output>
```

Creates and registers a new managed AI agent with the specified configuration and tool registry.

A new instance of AIAgent initialized with the specified parameters.

- id — An optional unique identifier for the AI agent. If null, a default identifier will be generated.
- additionalToolRegistry — A tool registry with additional tools available to the AI agent.
- agentConfig — The configuration for the AI agent, including settings for its behavior and capabilities.
- clock — The clock instance used for managing time-related operations. Defaults to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.GraphAIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/index.html`

### :agents:agents-core/commonMain

```kotlin
class GraphAIAgentService<Input, Output>(val promptExecutor: PromptExecutor, val agentConfig: AIAgentConfig, val strategy: AIAgentGraphStrategy<Input, Output>, val toolRegistry: ToolRegistry, val installFeatures: GraphAIAgent.FeatureContext.() -> Unit) : AIAgentServiceBase<Input, Output, GraphAIAgent<Input, Output>>
```

A service class for managing graph-based AI agents, responsible for orchestrating the behavior and execution of agents within a configurable graph-based strategy.

This class extends AIAgentServiceBase and provides an implementation for creating AI agents that follow a graph-based approach. It leverages a strategy pattern defined by AIAgentGraphStrategy to handle input and output transformations.

The GraphAIAgentService is marked with the InternalAgentsApi annotation, indicating that it is intended for internal use within agent-related implementations and not guaranteed for backward compatibility.

- promptExecutor — An instance of PromptExecutor, responsible for executing prompts using language models and handling responses.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.GraphAIAgentService.installFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/install-features.html`

### :agents:agents-core/commonMain

```kotlin
val installFeatures: GraphAIAgent.FeatureContext.() -> Unit
```

## ai.koog.agents.core.agent.GraphAIAgentService.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
open override val promptExecutor: PromptExecutor
```

- promptExecutor — An instance of PromptExecutor, responsible for executing prompts using language models and handling responses.

Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.GraphAIAgentService.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/strategy.html`

### :agents:agents-core/commonMain

```kotlin
val strategy: AIAgentGraphStrategy<Input, Output>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.GraphAIAgentService.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent-service/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolRegistry: ToolRegistry
```

Represents the central repository or registry for managing tools within the system.

This variable provides access to a tool registry that can be used to store, retrieve, and manage different tools registered in the application.

It is expected to be immutable and thread-safe, ensuring consistent behavior across the application.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.GraphAgentServiceBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-service-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): GraphAIAgentService<Input, Output>
```

Builds and returns an instance of GraphAIAgentService configured with the specified parameters.

This method finalizes the construction of a GraphAIAgentService by ensuring that all required components, such as the PromptExecutor and LLModel, are provided. It sets up the configuration using the provided or defaulted prompt, language model, and other agent settings. The resulting service is ready to manage AI agents in a graph-based strategy with support for configurable features.

A configured instance of GraphAIAgentService for managing graph-based AI agents.

## ai.koog.agents.core.agent.GraphAgentServiceBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-service-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class GraphAgentServiceBuilder<Input, Output> : AIAgentBuilderBase<GraphAgentServiceBuilder<Input, Output>>
```

A builder class for constructing a GraphAIAgentService with configurable properties such as prompt executor, model, tool registry, prompts, and various other configurations.

- Input — The input type for the AI agent graph service.
- Output — The output type for the AI agent graph service.
## ai.koog.agents.core.agent.GraphAgentServiceBuilder.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-service-builder/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentGraphFeature<TConfig, *>, configure: ConfigureAction<TConfig>): GraphAgentServiceBuilder<Input, Output>
```

Installs a specified feature into the GraphServiceBuilder and applies the given configuration to it.

The current instance of GraphAgentServiceBuilder, allowing for method chaining.

- feature — An instance of AIAgentGraphFeature that represents the feature to be installed, requiring a specific type of FeatureConfig.
- configure — A ConfigureAction that applies custom configurations to the provided FeatureConfig object for the feature.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`, `ai.koog.agents.core.utils`.

## ai.koog.agents.core.agent.MermaidDiagramGenerator.generate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-mermaid-diagram-generator/generate.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open override fun generate(graph: AIAgentGraphStrategy<*, *>): String
```

Generates a diagram representation of the provided AI agent graph strategy.

A string representation of the diagram generated from the given graph strategy.

- graph — The AI agent graph strategy to be translated into a diagram format. This strategy consists of interconnected nodes defining the workflow of an AI agent.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.MermaidDiagramGenerator

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-mermaid-diagram-generator/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
object MermaidDiagramGenerator : DiagramGenerator
```

## ai.koog.agents.core.agent.OutputOption.ByClass.ByClass

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-class/-by-class.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(outputClass: Class<Output>)
```

- Output — The type of the output.
## ai.koog.agents.core.agent.OutputOption.ByClass

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-class/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class ByClass<Output : Any>(val outputClass: Class<Output>) : OutputOption<Output>
```

Represents an output option that specifies the desired output type using a Class object.

This class is a concrete implementation of the OutputOption interface and is used to define the expected type of output for a given operation.

- Output — The type of the output.
## ai.koog.agents.core.agent.OutputOption.ByClass.outputClass

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-class/output-class.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val outputClass: Class<Output>
```

## ai.koog.agents.core.agent.OutputOption.ByClass.outputTypeToken

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-class/output-type-token.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
val outputTypeToken: ERROR CLASS: Symbol not found for TypeToken
```

TypeToken corresponding to the output type defined by outputClass.

## ai.koog.agents.core.agent.OutputOption.ByFinishTool.ByFinishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-finish-tool/-by-finish-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(finishTool: ERROR CLASS: Symbol not found for Tool<*, Output>)
```

- Output — The type of output produced by the associated tool.
## ai.koog.agents.core.agent.OutputOption.ByFinishTool.finishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-finish-tool/finish-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
val finishTool: ERROR CLASS: Symbol not found for Tool<*, Output>
```

## ai.koog.agents.core.agent.OutputOption.ByFinishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-by-finish-tool/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class ByFinishTool<Output : Any>(val finishTool: ERROR CLASS: Symbol not found for Tool<*, Output>) : OutputOption<Output>
```

Represents an output option determined by a specific tool that provides the output.

- Output — The type of output produced by the associated tool.
## ai.koog.agents.core.agent.OutputOption.Verification.Verification

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-verification/-verification.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor()
```

- Input — The type of the input to be verified.
## ai.koog.agents.core.agent.OutputOption.Verification

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/-verification/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class Verification<Input> : OutputOption<CriticResult<Input>>
```

Represents a verification process applied to an input and produces a result containing feedback and a success status.

This class is a specialization of the OutputOption interface designed to encapsulate the process of critiquing or verifying an Input and providing a CriticResult as output. It can be used in scenarios where input validation or assessment is required as part of a larger workflow.

- Input — The type of the input to be verified.

Referenced packages: `ai.koog.agents.ext.agent`.

## ai.koog.agents.core.agent.OutputOption

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-output-option/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
sealed interface OutputOption<Output : Any>
```

Represents a configuration option for determining the output type in a subtask builder process. This sealed interface allows specifying the output either by its class type or by using a tool that generates the required output.

- ByClass
- ByFinishTool
- Verification
## ai.koog.agents.core.agent.PlannerAgentBuilder.PlannerAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-planner-agent-builder/-planner-agent-builder.html`

### :agents:agents-core/commonMain

```kotlin
constructor(strategy: AIAgentPlannerStrategy<Input, Output>, promptExecutor: PromptExecutor? = null, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, config: AIAgentConfig, clock: KoogClock = KoogClock.System, featureInstallers: MutableList<PlannerAIAgent.FeatureContext.() -> Unit> = mutableListOf())
```

- strategy — The planning strategy used by the agent to process and execute tasks.
- promptExecutor — The executor responsible for handling AI prompts.
- toolRegistry — The registry of tools available for use by the agent. Defaults to an empty tool registry.
- id — The optional identifier of the agent.
- config — AIAgentConfig containing initial agent configuration for the builder
- clock — The clock instance used to track time-related operations for the agent. Defaults to the system clock.
- featureInstallers — A list of feature installers that enhance the agent's behavior with additional functionality.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.planner`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.PlannerAgentBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-planner-agent-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): AIAgent<Input, Output>
```

Constructs and returns an instance of AIAgent configured with the provided parameters and features.

An instance of AIAgent that uses the specified strategy, model, prompt, tools, and other configurations defined in the builder.

## ai.koog.agents.core.agent.PlannerAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-planner-agent-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlannerAgentBuilder<Input, Output>(strategy: AIAgentPlannerStrategy<Input, Output>, promptExecutor: PromptExecutor? = null, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, config: AIAgentConfig, clock: KoogClock = KoogClock.System, featureInstallers: MutableList<PlannerAIAgent.FeatureContext.() -> Unit> = mutableListOf()) : AIAgentBuilderBase<PlannerAgentBuilder<Input, Output>>
```

Builds an AI-based planning agent by configuring various parameters and defining custom behaviors for the agent. This builder allows flexible setup of an agent's functionality and behavior based on the provided configuration and tools.

- strategy — The planning strategy used by the agent to process and execute tasks.
- promptExecutor — The executor responsible for handling AI prompts.
- toolRegistry — The registry of tools available for use by the agent. Defaults to an empty tool registry.
- id — The optional identifier of the agent.
- config — AIAgentConfig containing initial agent configuration for the builder
- clock — The clock instance used to track time-related operations for the agent. Defaults to the system clock.
- featureInstallers — A list of feature installers that enhance the agent's behavior with additional functionality.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.planner`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.PlannerAgentBuilder.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-planner-agent-builder/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentPlannerFeature<TConfig, *>, configure: ConfigureAction<TConfig>): PlannerAgentBuilder<Input, Output>
```

Installs a functional feature into the PlannerAgentBuilder with the specified configuration.

The current instance of PlannerAgentBuilder with the feature installed, enabling method chaining.

- feature — The functional feature to be installed, parameterized with a configuration type and an additional type.
- configure — A lambda or action responsible for configuring the provided feature with the appropriate settings.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`, `ai.koog.agents.core.utils`.

## ai.koog.agents.core.agent.asMermaidDiagram

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/as-mermaid-diagram.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <I : Any, O : Any> AIAgentGraphStrategy<I, O>.asMermaidDiagram(): String
```

Extension function to generate a Mermaid diagram from an agent graph strategy.

References: https://docs.koog.ai/complex-workflow-agents/


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.createAgentTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/create-agent-tool.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> AIAgentService<Input, Output, *>.createAgentTool(agentName: String, agentDescription: String, inputDescription: String? = null, inputType: TypeToken = typeToken<Input>(), outputType: TypeToken = typeToken<Output>(), parentAgentId: String? = null, clock: KoogClock = KoogClock.System): Tool<AIAgentTool.AgentToolInput<Input>, AIAgentTool.AgentToolResult<Output>>
```

Creates an AIAgent and converts it to a Tool that can be used by other AI Agents.

A special tool that wraps the agent functionality.

A tool instance configured with the provided parameters, representing the AI agent.

- agentName — Agent name that would be a tool name for this agent tool.
- agentDescription — Agent description that would be a tool description for this agent tool.
- inputType — Type token representing agent input.
- outputType — Type token representing agent output.
- parentAgentId — Optional ID of the parent AI agent. Tool agent IDs will be generated as "parentAgentId."
- clock — The clock instance used to manage time-related operations. Defaults to KoogClock.System.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.config.ToolCallDescriber.JSON.describeToolCall

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-tool-call-describer/-j-s-o-n/describe-tool-call.html`

### :agents:agents-core/commonMain

```kotlin
open override fun describeToolCall(message: MessagePart.Tool.Call): String
```

Formats a tool call message into a standardized Message.Assistant response.

a string containing the serialized JSON representation of the tool call information.

- message — the tool call message of type MessagePart.Tool.Call containing details about the tool invocation, such as tool ID, name, and arguments.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.config.ToolCallDescriber.JSON.describeToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-tool-call-describer/-j-s-o-n/describe-tool-result.html`

### :agents:agents-core/commonMain

```kotlin
open override fun describeToolResult(message: MessagePart.Tool.Result): String
```

Creates a user message containing a structured JSON representation of a tool result including its ID, tool name, and result content.

A User message with a JSON-encoded representation of the tool result.

- message — The tool result message containing the tool's ID, name, and content.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.config.ToolCallDescriber.JSON

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-tool-call-describer/-j-s-o-n/index.html`

### :agents:agents-core/commonMain

```kotlin
object JSON : ToolCallDescriber
```

JSON object implementing the ToolCallDescriber interface. This object is responsible for describing tool calls and results by converting them into a structured JSON-based format.

## ai.koog.agents.core.agent.config.ToolCallDescriber.describeToolCall

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-tool-call-describer/describe-tool-call.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun describeToolCall(message: MessagePart.Tool.Call): String
```

Composes a description of a tool call message.

A Message instance containing the description of the tool call.

- message — The tool call message to be described. Must be an instance of MessagePart.Tool.Call.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.config.ToolCallDescriber.describeToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-tool-call-describer/describe-tool-result.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun describeToolResult(message: MessagePart.Tool.Result): String
```

Describes the tool result by transforming it into a user-readable string.

A transformed message representing the description of the tool result.

- message — The tool result message to be described. It contains the tool call id, tool name, and content details.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.config.ToolCallDescriber

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-tool-call-describer/index.html`

### :agents:agents-core/commonMain

```kotlin
interface ToolCallDescriber
```

Describes the way to reformat tool call/tool result messages, in case real tool call/tool result messages cannot be used

- JSON
## ai.koog.agents.core.agent.context.AIAgentContext.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val agentId: String
```

A unique identifier representing the current agent instance within the context.

## ai.koog.agents.core.agent.context.AIAgentContext.agentInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/agent-input.html`

### :agents:agents-core/commonMain

```kotlin
abstract val agentInput: Any?
```

Represents the input provided to the agent's execution.

This variable provides access to the agent's input, which can be used to determine the agent's intent, context, or other relevant information at any stage of agents execution.

## ai.koog.agents.core.agent.context.AIAgentContext.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/config.html`

### :agents:agents-core/commonMain

```kotlin
abstract val config: AIAgentConfig
```

Represents the configuration for an AI agent.

This configuration is used during the execution to enforce constraints such as the maximum number of iterations an agent can perform, as well as providing the agent's prompt configuration.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.context.AIAgentContext.environment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/environment.html`

### :agents:agents-core/commonMain

```kotlin
abstract val environment: AIAgentEnvironment
```

Represents the environment in which the agent operates.

This variable provides access to essential functionalities for the agent's execution, including interaction with tools, error reporting, and sending termination signals. It is used throughout the agent's lifecycle to facilitate actions and handle outcomes.


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.context.AIAgentContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
abstract var executionInfo: AgentExecutionInfo
```

Represents the observability data associated with the AI Agent context.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.agent.context.AIAgentContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentContext
```

The AIAgentContext interface represents the context of an AI agent in the lifecycle. It provides access to the environment, configuration, LLM context, state management, storage, and other metadata necessary for the operation of the agent. Additionally, it supports features for custom workflows and extensibility.

- AIAgentFunctionalContextBaseCommon
- AIAgentGraphContextBase
## ai.koog.agents.core.agent.context.AIAgentContext.llm

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/llm.html`

### :agents:agents-core/commonMain

```kotlin
abstract val llm: AIAgentLLMContext
```

Represents the AI agent's LLM context, providing mechanisms for managing tools, prompts, and interaction with the execution environment. It ensures thread safety during concurrent read and write operations through the use of sessions.

This context plays a foundational role in defining and manipulating tools, prompt execution, and overall behavior the agent's lifecycle.

## ai.koog.agents.core.agent.context.AIAgentContext.parentContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/parent-context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val parentContext: AIAgentContext?
```

Represents the parent context of the AI Agent.

## ai.koog.agents.core.agent.context.AIAgentContext.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
abstract val pipeline: AIAgentPipeline
```

Represents the pipeline associated with the AI agent.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val runId: String
```

A unique identifier for the current session associated with the AI agent context. Used to track and differentiate sessions within the execution of the agent pipeline.

## ai.koog.agents.core.agent.context.AIAgentContext.stateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/state-manager.html`

### :agents:agents-core/commonMain

```kotlin
abstract val stateManager: AIAgentStateManager
```

Manages and tracks the state of an AI agent within the context of its execution.

This variable provides synchronized access to the agent's state to ensure thread safety and consistent state transitions during concurrent operations. It acts as a central mechanism for managing state updates and validations across different nodes and subgraphs of the AI agent's execution flow.

The stateManager is utilized extensively in coordinating state changes, such as tracking the number of iterations made by the agent and enforcing execution limits or conditions. This aids in maintaining predictable and controlled behavior of the agent during execution.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentContext.storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/storage.html`

### :agents:agents-core/commonMain

```kotlin
abstract val storage: AIAgentStorage
```

Concurrent-safe key-value storage for an agent, used to manage and persist data within the context of the AI agent stage execution. The storage property provides a thread-safe mechanism for sharing and storing data specific to the agent's operation.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentContext.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-context/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
abstract val strategyName: String
```

Represents the name of the strategy being used in the current AI agent context.

## ai.koog.agents.core.agent.context.AIAgentFunctionalContext.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-functional-context/copy.html`

### :agents:agents-core/commonMain

```kotlin
fun copy(environment: AIAgentEnvironment = this.environment, agentId: String = this.agentId, runId: String = this.runId, agentInput: Any? = this.agentInput, config: AIAgentConfig = this.config, llm: AIAgentLLMContext = this.llm, stateManager: AIAgentStateManager = this.stateManager, storage: AIAgentStorage = this.storage, strategyName: String = this.strategyName, pipeline: AIAgentFunctionalPipeline = this.pipeline, executionInfo: AgentExecutionInfo = this.executionInfo, parentRootContext: AIAgentContext? = this.parentContext): AIAgentFunctionalContext
```

Creates a copy of the current AIAgentFunctionalContext, allowing for selective overriding of its properties. This method is useful for creating modified contexts during agent execution without mutating the original context.

A new AIAgentFunctionalContext with the specified modifications applied.

- environment — The AIAgentEnvironment to be used in the new context, or the current one if not specified.
- agentId — The unique agent identifier, or the current one if not specified.
- runId — The run identifier, or the current run ID if not specified.
- agentInput — The input data for the agent, or the current input if not specified.
- config — The AIAgentConfig for the new context, or the current configuration if not specified.
- llm — The AIAgentLLMContext to be used, or the current LLM context if not specified.
- stateManager — The AIAgentStateManager to be used, or the current state manager if not specified.
- storage — The AIAgentStorage to be used, or the current storage if not specified.
- strategyName — The strategy name, or the current strategy name if not specified.
- pipeline — The AIAgentFunctionalPipeline to be used, or the current pipeline if not specified.
- executionInfo — The AgentExecutionInfo to be used, or the current execution info if not specified.
- parentRootContext — The parent context, or the current parent context if not specified.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.AIAgentGraphContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/-a-i-agent-graph-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(environment: AIAgentEnvironment, agentId: String, agentInputType: TypeToken, agentInput: Any?, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, runId: String, strategyName: String, pipeline: AIAgentGraphPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentGraphContextBase?)
```

Creates an instance of the context with the given parameters.

- environment — The AI agent environment responsible for tool execution and problem reporting.
- agentInput — The input message to be used for the agent's interaction with the environment.
- config — The configuration settings of the AI agent.
- llm — The contextual data and execution utilities for the AI agent's interaction with LLMs.
- stateManager — Manages the internal state of the AI agent.
- storage — Concurrent-safe storage for managing key-value data across the agent's lifecycle.
- runId — The unique identifier for the agent session.
- strategyName — The identifier for the selected strategy in the agent's lifecycle.
- pipeline — The AI agent pipeline responsible for coordinating AI agent execution and processing.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentId: String
```

A unique identifier representing the current agent instance within the context.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.agentInputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/agent-input-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentInputType: TypeToken
```

TypeToken representing the type of the agentInput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.agentInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/agent-input.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentInput: Any?
```

- agentInput — The input message to be used for the agent's interaction with the environment.
## ai.koog.agents.core.agent.context.AIAgentGraphContext.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/config.html`

### :agents:agents-core/commonMain

```kotlin
open override val config: AIAgentConfig
```

- config — The configuration settings of the AI agent.

Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.copyWithTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/copy-with-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun copyWithTools(tools: List<ToolDescriptor>): AIAgentContext
```

Creates a new instance of AIAgentContext with an updated list of tools, replacing the current tools in the LLM context with the provided list.

A new instance of AIAgentContext with the updated tools configuration.

- tools — The new list of tools to be used in the LLM context, represented as ToolDescriptor objects.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.environment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/environment.html`

### :agents:agents-core/commonMain

```kotlin
open override val environment: AIAgentEnvironment
```

Represents the environment in which the agent operates.

This variable provides access to essential functionalities for the agent's execution, including interaction with tools, error reporting, and sending termination signals. It is used throughout the agent's lifecycle to facilitate actions and handle outcomes.


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override var executionInfo: AgentExecutionInfo
```

Represents the observability data associated with the AI Agent context.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.fork

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/fork.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun fork(): AIAgentGraphContextBase
```

Creates an independent fork of this context, taking consistent snapshots of the LLM context, storage, state manager and execution info. Each copy() is performed under the corresponding lock of the source object, so the returned context is safe to mutate concurrently with the original.

Concurrency caveat: each downstream copy() acquires its own read lock (or equivalent); these locks are acquired sequentially, and the snapshot of the whole context is therefore not atomic across all four fields. Two fields may be observed at slightly different points in time if another coroutine is concurrently mutating this context.

Note also that the in-memory storeMap (populated via store) is not copied here — the returned context starts with an empty local store.

## ai.koog.agents.core.agent.context.AIAgentGraphContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentGraphContext(environment: AIAgentEnvironment, val agentId: String, val agentInputType: TypeToken, val agentInput: Any?, val config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, val runId: String, val strategyName: String, val pipeline: AIAgentGraphPipeline, executionInfo: AgentExecutionInfo, val parentContext: AIAgentGraphContextBase?) : AIAgentGraphContextBase
```

Implements the AIAgentGraphContext interface, providing the context required for an AI agent's execution. This class encapsulates configurations, the execution pipeline, agent environment, and tools for handling agent lifecycles and interactions.

- environment — The AI agent environment responsible for tool execution and problem reporting.
- agentInput — The input message to be used for the agent's interaction with the environment.
- config — The configuration settings of the AI agent.
- llm — The contextual data and execution utilities for the AI agent's interaction with LLMs.
- stateManager — Manages the internal state of the AI agent.
- storage — Concurrent-safe storage for managing key-value data across the agent's lifecycle.
- runId — The unique identifier for the agent session.
- strategyName — The identifier for the selected strategy in the agent's lifecycle.
- pipeline — The AI agent pipeline responsible for coordinating AI agent execution and processing.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.llm

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/llm.html`

### :agents:agents-core/commonMain

```kotlin
open override val llm: AIAgentLLMContext
```

Represents the AI agent's LLM context, providing mechanisms for managing tools, prompts, and interaction with the execution environment. It ensures thread safety during concurrent read and write operations through the use of sessions.

This context plays a foundational role in defining and manipulating tools, prompt execution, and overall behavior the agent's lifecycle.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.parentContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/parent-context.html`

### :agents:agents-core/commonMain

```kotlin
open override val parentContext: AIAgentGraphContextBase?
```

Represents the parent context of the AI Agent.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
open override val pipeline: AIAgentGraphPipeline
```

- pipeline — The AI agent pipeline responsible for coordinating AI agent execution and processing.

Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.replace

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/replace.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun replace(context: AIAgentContext)
```

Atomically replaces the stateful fields of this context with those of context, under the write lock of mutableAIAgentContext.

Concurrency caveats:

mutableAIAgentContext's lock is not reentrant; do not call replace from inside another operation that already holds it (e.g. from within a transformation running under MutableAIAgentContext.copy).

Consumers that read fields directly (e.g. ctx.llm, ctx.storage) without going through the MutableAIAgentContext lock may observe a non-atomic mix of old and new values while a concurrent replace is in progress.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

- runId — The unique identifier for the agent session.
## ai.koog.agents.core.agent.context.AIAgentGraphContext.stateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/state-manager.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateManager: AIAgentStateManager
```

Manages and tracks the state of an AI agent within the context of its execution.

This variable provides synchronized access to the agent's state to ensure thread safety and consistent state transitions during concurrent operations. It acts as a central mechanism for managing state updates and validations across different nodes and subgraphs of the AI agent's execution flow.

The stateManager is utilized extensively in coordinating state changes, such as tracking the number of iterations made by the agent and enforcing execution limits or conditions. This aids in maintaining predictable and controlled behavior of the agent during execution.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/storage.html`

### :agents:agents-core/commonMain

```kotlin
open override val storage: AIAgentStorage
```

Concurrent-safe key-value storage for an agent, used to manage and persist data within the context of the AI agent stage execution. The storage property provides a thread-safe mechanism for sharing and storing data specific to the agent's operation.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.AIAgentGraphContext.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategyName: String
```

- strategyName — The identifier for the selected strategy in the agent's lifecycle.
## ai.koog.agents.core.agent.context.AIAgentGraphContextBase.agentInputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context-base/agent-input-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val agentInputType: TypeToken
```

TypeToken representing the type of the agentInput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.AIAgentGraphContextBase.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context-base/copy.html`

### :agents:agents-core/commonMain

```kotlin
open fun copy(environment: AIAgentEnvironment = this.environment, agentId: String = this.agentId, agentInput: Any? = this.agentInput, agentInputType: TypeToken = this.agentInputType, config: AIAgentConfig = this.config, llm: AIAgentLLMContext = this.llm, stateManager: AIAgentStateManager = this.stateManager, storage: AIAgentStorage = this.storage, runId: String = this.runId, strategyName: String = this.strategyName, pipeline: AIAgentGraphPipeline = this.pipeline, executionInfo: AgentExecutionInfo = this.executionInfo, parentContext: AIAgentGraphContextBase? = this): AIAgentGraphContextBase
```

Creates a copy of the current AIAgentGraphContext, allowing for selective overriding of its properties.

- environment — The AIAgentEnvironment to be used in the new context, or the current one if not specified.
- agentId — The unique agent identifier, or the current one if not specified.
- agentInput — The input data for the agent, or the current input if not specified.
- agentInputType — The TypeToken representing the type of agentInput, or the current type if not specified.
- config — The AIAgentConfig for the new context, or the current configuration if not specified.
- llm — The AIAgentLLMContext to be used, or the current LLM context if not specified.
- stateManager — The AIAgentStateManager to be used, or the current state manager if not specified.
- storage — The AIAgentStorage to be used, or the current storage if not specified.
- runId — The run identifier, or the current run ID if not specified.
- strategyName — The strategy name, or the current strategy name if not specified.
- pipeline — The AIAgentGraphPipeline to be used, or the current pipeline if not specified.
- executionInfo — The AgentExecutionInfo to be used, or the current execution info if not specified.
- parentContext — The parent context, or the current instance if not specified.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.AIAgentGraphContextBase.fork

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context-base/fork.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun fork(): AIAgentGraphContextBase
```

Creates a copy of the current AIAgentGraphContext with deep copies of all mutable properties.

A new instance of AIAgentGraphContext with copies of all mutable properties.

## ai.koog.agents.core.agent.context.AIAgentGraphContextBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context-base/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentGraphContextBase : AIAgentContext
```

The AIAgentGraphContextBase interface extends the AIAgentContext interface to provide a foundational context specifically tailored for AI agents operating within a graph structure.

This interface inherits the core capabilities from AIAgentContext, including environment management, configuration access, session tracking, state management, and custom workflows. By building upon these features, it serves as a base for defining additional constructs and behaviors that facilitate the agent's execution in graph-based workflows or execution pipelines.

Implementations of this interface are expected to leverage the provided capabilities to handle graph-specific logic, such as node traversal, input/output management, and handling complex dependencies between graph nodes.

- AIAgentGraphContext
- AIAgentParallelNodesMergeContext
## ai.koog.agents.core.agent.context.AIAgentGraphContextBase.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context-base/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
abstract override val pipeline: AIAgentGraphPipeline
```

Represents the pipeline associated with the AI agent.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentGraphContextBase.replace

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-graph-context-base/replace.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun replace(context: AIAgentContext)
```

Replaces the current context with the provided context. This method is used to update the current context with values from another context, particularly useful in scenarios like parallel node execution where contexts need to be merged.

- context — The context to replace the current context with.
## ai.koog.agents.core.agent.context.AIAgentPlannerContext.AIAgentPlannerContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-planner-context/-a-i-agent-planner-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(environment: AIAgentEnvironment, agentId: String, runId: String, agentInput: Any?, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, strategyName: String, pipeline: AIAgentPlannerPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentContext? = null)
```

- environment — The AI agent's operating environment, which provides tools, error reporting, and mechanism for execution.
- agentId — A unique identifier for the agent.
- runId — A unique identifier representing the current execution run.
- agentInput — Input data provided to the agent for processing or decision-making.
- config — Configuration details for the AI agent, dictating its behavior and settings.
- llm — The context for interactions with the underlying language model.
- stateManager — Responsible for managing the state of the agent across executions.
- storage — Provides long-term memory or storage for the agent's operations.
- strategyName — Name of the strategy guiding the agent's behavior.
- pipeline — The planning pipeline that orchestrates the agent's decision-making processes.
- executionInfo — Metadata and details regarding the agent's execution, such as timestamps or states.
- parentContext — An optional parent context, allowing nested or hierarchical composition of agent contexts.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentPlannerContext.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-planner-context/copy.html`

### :agents:agents-core/commonMain

```kotlin
fun copy(environment: AIAgentEnvironment = this.environment, agentId: String = this.agentId, runId: String = this.runId, agentInput: Any? = this.agentInput, config: AIAgentConfig = this.config, llm: AIAgentLLMContext = this.llm, stateManager: AIAgentStateManager = this.stateManager, storage: AIAgentStorage = this.storage, strategyName: String = this.strategyName, pipeline: AIAgentPlannerPipeline = this.pipeline, executionInfo: AgentExecutionInfo = this.executionInfo, parentRootContext: AIAgentContext? = this.parentContext): AIAgentPlannerContext
```

Creates a copy of the current AIAgentPlannerContext, allowing for selective overriding of its properties. This method is useful for creating modified contexts during agent execution without mutating the original context.

A new AIAgentPlannerContext with the specified modifications applied.

- environment — The AIAgentEnvironment to be used in the new context, or the current one if not specified.
- agentId — The unique agent identifier, or the current one if not specified.
- runId — The run identifier, or the current run ID if not specified.
- agentInput — The input data for the agent, or the current input if not specified.
- config — The AIAgentConfig for the new context, or the current configuration if not specified.
- llm — The AIAgentLLMContext to be used, or the current LLM context if not specified.
- stateManager — The AIAgentStateManager to be used, or the current state manager if not specified.
- storage — The AIAgentStorage to be used, or the current storage if not specified.
- strategyName — The strategy name, or the current strategy name if not specified.
- pipeline — The AIAgentPlannerPipeline to be used, or the current pipeline if not specified.
- executionInfo — The AgentExecutionInfo to be used, or the current execution info if not specified.
- parentRootContext — The parent context, or the current parent context if not specified.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AIAgentPlannerContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-a-i-agent-planner-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentPlannerContext(environment: AIAgentEnvironment, agentId: String, runId: String, agentInput: Any?, config: AIAgentConfig, llm: AIAgentLLMContext, stateManager: AIAgentStateManager, storage: AIAgentStorage, strategyName: String, pipeline: AIAgentPlannerPipeline, executionInfo: AgentExecutionInfo, parentContext: AIAgentContext? = null) : AIAgentFunctionalContextBase<AIAgentPlannerPipeline>
```

Represents a context for the AI agent of PlannerAIAgent type, responsible for managing execution pipelines, configurations, and other contextual data required for agent operations.

- environment — The AI agent's operating environment, which provides tools, error reporting, and mechanism for execution.
- agentId — A unique identifier for the agent.
- runId — A unique identifier representing the current execution run.
- agentInput — Input data provided to the agent for processing or decision-making.
- config — Configuration details for the AI agent, dictating its behavior and settings.
- llm — The context for interactions with the underlying language model.
- stateManager — Responsible for managing the state of the agent across executions.
- storage — Provides long-term memory or storage for the agent's operations.
- strategyName — Name of the strategy guiding the agent's behavior.
- pipeline — The planning pipeline that orchestrates the agent's decision-making processes.
- executionInfo — Metadata and details regarding the agent's execution, such as timestamps or states.
- parentContext — An optional parent context, allowing nested or hierarchical composition of agent contexts.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.context.AgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-agent-context-data/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed class AgentContextData
```

- GraphAgentContextData
- PlannerAgentContextData
## ai.koog.agents.core.agent.context.DetachedPromptExecutorAPI

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-detached-prompt-executor-a-p-i/index.html`

### :agents:agents-core/commonMain

```kotlin
annotation class DetachedPromptExecutorAPI
```

Annotation for marking APIs as detached prompt executors within the AIAgentLLMContext.

Using APIs annotated with this requires opting in, as calls to PromptExecutor will be disconnected from the agent logic. This means these calls will not affect the agent's state or adhere to the ToolsConversionStrategy.

This API should be used with caution, as it provides functionality that operates outside the standard agent lifecycle and processing logic.

## ai.koog.agents.core.agent.context.GraphAgentContextData.GraphAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-graph-agent-context-data/-graph-agent-context-data.html`

### :agents:agents-core/commonMain

```kotlin
constructor(messageHistory: List<Message>, llmParams: LLMParams?, llmModel: LLModel?, tools: List<String>?, storage: JSONObject, agentIterations: Int, nodePath: String, lastOutput: JSONElement = JSONNull, rollbackStrategy: RollbackStrategy, additionalRollbackActions: suspend (AIAgentContext) -> Unit = {})
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.GraphAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-graph-agent-context-data/index.html`

### :agents:agents-core/commonMain

```kotlin
class GraphAgentContextData(messageHistory: List<Message>, llmParams: LLMParams?, llmModel: LLModel?, tools: List<String>?, storage: JSONObject, agentIterations: Int, nodePath: String, lastOutput: JSONElement = JSONNull, rollbackStrategy: RollbackStrategy, additionalRollbackActions: suspend (AIAgentContext) -> Unit = {}) : AgentContextData
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.PlannerAgentContextData.PlannerAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-planner-agent-context-data/-planner-agent-context-data.html`

### :agents:agents-core/commonMain

```kotlin
constructor(messageHistory: List<Message>, state: JSONElement, plan: JSONElement, llmParams: LLMParams?, llmModel: LLModel?, tools: List<String>?, storage: JSONObject, agentIterations: Int, executionPoint: PlannerAgentExecutionPoint, rollbackStrategy: RollbackStrategy, additionalRollbackActions: suspend (AIAgentContext) -> Unit = {})
```


Referenced packages: `ai.koog.agents.core.planner`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.PlannerAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-planner-agent-context-data/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlannerAgentContextData(messageHistory: List<Message>, state: JSONElement, plan: JSONElement, llmParams: LLMParams?, llmModel: LLModel?, tools: List<String>?, storage: JSONObject, agentIterations: Int, executionPoint: PlannerAgentExecutionPoint, rollbackStrategy: RollbackStrategy, additionalRollbackActions: suspend (AIAgentContext) -> Unit = {}) : AgentContextData
```


Referenced packages: `ai.koog.agents.core.planner`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.context.featureOrThrow

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/feature-or-throw.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <TFeature : Any> AIAgentContext.featureOrThrow(feature: AIAgentFeature<*, TFeature>): TFeature
```

Retrieves a feature from the AIAgentContext.pipeline associated with this context using the specified key or throws an exception if it is not available.

The feature associated with the provided key

- feature — A feature to fetch.
- IllegalStateException — if the TFeature feature does not correspond to a registered feature.
- NoSuchElementException — if the feature is not found.

Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.core.agent.context.feature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/feature.html`

### :agents:agents-core/commonMain

```kotlin
fun <TFeature : Any> AIAgentContext.feature(featureClass: KClass<TFeature>, feature: AIAgentFeature<*, TFeature>): TFeature?
```

Retrieves a feature from the AIAgentContext.pipeline associated with this context using the specified key.

The feature associated with the provided key, or null if no matching feature is found.

- feature — A feature to fetch.
- featureClass — The KClass of the feature to be retrieved.
- TFeature — A feature implementation type.
- IllegalArgumentException — if the specified featureClass does not correspond to a registered feature.

Referenced packages: `ai.koog.agents.core.feature`.

### :agents:agents-core/commonMain

```kotlin
inline fun <TFeature : Any> AIAgentContext.feature(feature: AIAgentFeature<*, TFeature>): TFeature?
```

Retrieves a feature from the AIAgentContext.pipeline associated with this context using the specified key.

The feature associated with the provided key, or null if no matching feature is found.

- feature — A feature to fetch.
- IllegalArgumentException — if the specified feature does not correspond to a registered feature.

Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.core.agent.context.getGraphAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/get-graph-agent-context-data.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun AIAgentContext.getGraphAgentContextData(): GraphAgentContextData?
```

Retrieves the agent-specific context data associated with the current instance.

This function accesses and returns the contextual information stored as part of the agent's context, or null if no such data is present.

Note: This is part of the internal agents API and should be used cautiously, understanding that it is subject to changes or removal in future updates.

The agent context data, or null if no context data is associated.

## ai.koog.agents.core.agent.context.getPlannerAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/get-planner-agent-context-data.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun AIAgentContext.getPlannerAgentContextData(): PlannerAgentContextData?
```

Retrieves the agent-specific context data associated with the current instance.

This function accesses and returns the contextual information stored as part of the agent's context, or null if no such data is present.

Note: This is part of the internal agents API and should be used cautiously, understanding that it is subject to changes or removal in future updates.

The agent context data, or null if no context data is associated.

## ai.koog.agents.core.agent.context.graphAgentContextDataAdditionalKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/graph-agent-context-data-additional-key.html`

### :agents:agents-core/commonMain

```kotlin
val graphAgentContextDataAdditionalKey: AIAgentStorageKey<GraphAgentContextData>
```

A storage key used for associating and retrieving AgentContextData within the AI agent's storage system.

This key is intended for internal use within the AI agents' infrastructure to securely store and access data related to an agent's context. The associated data includes details such as message history, node identifiers, and the last input processed by the agent, allowing seamless tracking and management of an agent's state.

The storage key is marked with the @InternalAgentsApi annotation, indicating that it is part of the internal mechanism and not meant for public or general-purpose development use. It may be subject to changes or removal without notice.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.plannerAgentContextDataAdditionalKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/planner-agent-context-data-additional-key.html`

### :agents:agents-core/commonMain

```kotlin
val plannerAgentContextDataAdditionalKey: AIAgentStorageKey<PlannerAgentContextData>
```

A storage key used for associating and retrieving AgentContextData within the AI agent's storage system.

This key is intended for internal use within the AI agents' infrastructure to securely store and access data related to an agent's context. The associated data includes details such as message history, node identifiers, and the last input processed by the agent, allowing seamless tracking and management of an agent's state.

The storage key is marked with the @InternalAgentsApi annotation, indicating that it is part of the internal mechanism and not meant for public or general-purpose development use. It may be subject to changes or removal without notice.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.context.removeGraphAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/remove-graph-agent-context-data.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun AIAgentContext.removeGraphAgentContextData(): Boolean
```

Removes the agent-specific context data associated with the current context.

This function attempts to remove the context data identified by the agentContextDataAdditionalKey.

true if the agent context data was successfully removed, or false if no data was found to remove.

## ai.koog.agents.core.agent.context.removePlannerAgentContextData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/remove-planner-agent-context-data.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun AIAgentContext.removePlannerAgentContextData(): Boolean
```

Removes the agent-specific context data associated with the current context.

This function attempts to remove the context data identified by the agentContextDataAdditionalKey.

true if the agent context data was successfully removed, or false if no data was found to remove.

## ai.koog.agents.core.agent.context.rootContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/root-context.html`

### :agents:agents-core/commonMain

```kotlin
fun AIAgentContext.rootContext(): AIAgentContext
```

Provides the root context of the current agent. If the root context is not defined, this function defaults to returning the current instance.

The root context of type AIAgentContext, or the current instance if the root context is null.

## ai.koog.agents.core.agent.entity.AIAgentEdge.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-edge/-companion/builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun builder(): AgentEdgeBuilder
```

Creates a new instance of the AgentEdgeBuilder, which is a utility class for constructing instances of AIAgentEdge.

A new instance of AgentEdgeBuilder to facilitate the creation of AIAgentEdge objects.

## ai.koog.agents.core.agent.entity.AIAgentEdge.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-edge/-companion/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
object Companion
```

Provides companion functionality for the AIAgentEdge class. This includes utility methods for constructing instances of AIAgentEdge via a builder.

The AIAgentEdge represents a directed edge in an AI agent's graph, connecting a source node to a target node and facilitating the flow of data through potential transformation or filtering.

## ai.koog.agents.core.agent.entity.AIAgentEdge.fromNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-edge/from-node.html`

### :agents:agents-core/commonMain

```kotlin
expect val fromNode: AIAgentNodeBase<*, IncomingOutput>
```

The source node in the AI agent strategy graph which this edge connects.

### :agents:agents-core/jvmCommonMain

```kotlin
actual val fromNode: AIAgentNodeBase<*, IncomingOutput>
```

The source node in the AI agent strategy graph which this edge connects.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual val fromNode: AIAgentNodeBase<*, IncomingOutput>
```

The source node in the AI agent strategy graph which this edge connects.

## ai.koog.agents.core.agent.entity.AIAgentEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-edge/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentEdge<IncomingOutput, OutgoingInput>
```

Represents a directed edge connecting two nodes in the graph of an AI agent strategy. This edge facilitates the transmission of data between a source node and a destination node, allowing transformation or filtering of output values from the source node before they reach the destination node.

- IncomingOutput — The type of output produced by the source node connected to this edge.
- OutgoingInput — The type of input accepted by the destination node connected to this edge.
### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentEdge<IncomingOutput, OutgoingInput>
```

Represents a directed edge connecting two nodes in the graph of an AI agent strategy. This edge facilitates the transmission of data between a source node and a destination node, allowing transformation or filtering of output values from the source node before they reach the destination node.

- IncomingOutput — The type of output produced by the source node connected to this edge.
- OutgoingInput — The type of input accepted by the destination node connected to this edge.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentEdge<IncomingOutput, OutgoingInput>
```

Represents a directed edge connecting two nodes in the graph of an AI agent strategy. This edge facilitates the transmission of data between a source node and a destination node, allowing transformation or filtering of output values from the source node before they reach the destination node.

- IncomingOutput — The type of output produced by the source node connected to this edge.
- OutgoingInput — The type of input accepted by the destination node connected to this edge.
## ai.koog.agents.core.agent.entity.AIAgentEdge.toNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-edge/to-node.html`

### :agents:agents-core/commonMain

```kotlin
expect val toNode: AIAgentNodeBase<OutgoingInput, *>
```

The destination node in the AI agent strategy graph to which this edge connects.

### :agents:agents-core/jvmCommonMain

```kotlin
actual val toNode: AIAgentNodeBase<OutgoingInput, *>
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual val toNode: AIAgentNodeBase<OutgoingInput, *>
```

The destination node in the AI agent strategy graph to which this edge connects.

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.AIAgentGraphStrategyBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/-a-i-agent-graph-strategy-base.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String, nodeStart: StartNode<TInput>, nodeFinish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, serializer: Json = Json { prettyPrint = true })
```

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(context: AIAgentGraphContextBase, input: TInput): TOutput?
```

Executes the AI agent's strategy using the provided context and input.

This method processes the given input data within the specified context, leveraging the AI agent's internal logic and strategy to produce an output. The concrete decision-making, stateful operations, and any execution-pipeline specifics are fully determined by the implementing strategy.

The output produced by the AI agent's strategy, or null if no output is generated. The output type is defined by the strategy's implementation.

- context — The execution context in which the AI agent operates. It provides access to the agent's configuration, pipeline, environment, and other components required for execution in a graph-based structure.
- input — The input data to be processed by the AI agent's strategy. The type of input is defined by the strategy's implementation and is used to derive the resulting output.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/index.html`

### :agents:agents-core/commonMain

```kotlin
open class AIAgentGraphStrategyBase<TInput, TOutput>(val name: String, val nodeStart: StartNode<TInput>, val nodeFinish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, serializer: Json = Json { prettyPrint = true }) : AIAgentStrategy<TInput, TOutput, AIAgentGraphContextBase> , AIAgentSubgraphBase<TInput, TOutput>
```

Base class for AIAgentGraphStrategy.

- AIAgentGraphStrategy

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.metadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/metadata.html`

### :agents:agents-core/commonMain

```kotlin
lateinit var metadata: SubgraphMetadata
```

Represents the metadata of the subgraph associated with the AI agent strategy.

This variable holds essential information about the structure and properties of the subgraph, such as the mapping of node names to their associated implementations and the uniqueness of node names within the subgraph.

The property is a lateinit var that is expected to be assigned once by the graph builder after the strategy has been constructed. Accessing it before it has been initialized will result in an UninitializedPropertyAccessException.

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/name.html`

### :agents:agents-core/commonMain

```kotlin
open override val name: String
```

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.nodeFinish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/node-finish.html`

### :agents:agents-core/commonMain

```kotlin
val nodeFinish: FinishNode<TOutput>
```

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.nodeStart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/node-start.html`

### :agents:agents-core/commonMain

```kotlin
val nodeStart: StartNode<TInput>
```

## ai.koog.agents.core.agent.entity.AIAgentGraphStrategyBase.setExecutionPointAfterNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-graph-strategy-base/set-execution-point-after-node.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun setExecutionPointAfterNode(nodePath: String, output: JSONElement, agentContext: AIAgentGraphContextBase)
```

Enforces the strategy's next execution to continue right after the node identified by nodePath, using output as that node's completed output.

nodePath is a DEFAULT_AGENT_PATH_SEPARATOR-joined path whose first segment is the agent's id and is ignored; the remaining segments identify the completed node inside this strategy's metadata. output is decoded using the completed node's AIAgentNodeBase.outputType.

Behavior:

If the completed node is a FinishNode, the subgraph containing it is resumed by re-starting the finish node with output (finish nodes have no outgoing edges and input equals output).

Otherwise, the outgoing edge of the completed node is resolved against output and the resulting next node and transformed input are set as the new execution point.

- nodePath — The path identifying the completed node within the strategy's metadata.
- output — The serialized output produced by the node at nodePath.
- agentContext — The graph context whose execution point should be enforced.
- IllegalArgumentException — if nodePath does not contain any node segment after the agent id.
- IllegalStateException — if no node corresponding to nodePath can be found in metadata, if no outgoing edge matches the produced output, or if one of the intermediate path segments is not an ExecutionPointNode.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.ResolvedEdge.ResolvedEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/-resolved-edge/-resolved-edge.html`

### :agents:agents-core/commonMain

```kotlin
constructor(edge: AIAgentEdge<*, *>, output: Any?)
```

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.ResolvedEdge.edge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/-resolved-edge/edge.html`

### :agents:agents-core/commonMain

```kotlin
val edge: AIAgentEdge<*, *>
```

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.ResolvedEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/-resolved-edge/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ResolvedEdge(val edge: AIAgentEdge<*, *>, val output: Any?)
```

Represents a resolved edge in the context of an AI agent strategy graph, combining an edge and its corresponding resolved output.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.ResolvedEdge.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/-resolved-edge/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: Any?
```

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.addEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/add-edge.html`

### :agents:agents-core/commonMain

```kotlin
open fun addEdge(edge: AIAgentEdge<TOutput, *>)
```

Adds a directed edge from the current node, enabling connections between this node and other nodes in the AI agent strategy graph.

- edge — The edge to be added, representing a connection from this node's output to another node in the strategy graph.
## ai.koog.agents.core.agent.entity.AIAgentNodeBase.edges

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/edges.html`

### :agents:agents-core/commonMain

```kotlin
var edges: List<AIAgentEdge<TOutput, *>>
```

The directed edges connecting this node to other nodes in the AI agent strategy graph. Each edge defines the flow and optional transformation of output data from this node to another.

The list starts empty and can only be extended via addEdge. Edges are evaluated in order during resolveEdge: the first edge that successfully processes the node output is selected.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.executeUnsafe

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/execute-unsafe.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun executeUnsafe(context: AIAgentGraphContextBase, input: Any?): Any?
```

Executes the node operation using the provided execution context and input, bypassing static type checks. This method internally performs an unchecked cast of input to TInput and delegates to execute. The caller is responsible for ensuring that input is actually assignable to TInput; otherwise a ClassCastException may be thrown at the call site or later during execution.

The result of the execution, which may be of any type depending on the implementation.

- context — The execution context that provides runtime information and functionality.
- input — The input data to be processed by the node, which may be of any type.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/execute.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun execute(context: AIAgentGraphContextBase, input: TInput): TOutput?
```

Executes a specific operation based on the given context and input.

Implementations may return null to indicate that no output is produced for the current invocation (for example, when the execution was interrupted and is expected to be resumed later). Plain node implementations such as SimpleAIAgentNodeImpl always return a non-null TOutput.

The result of the execution as TOutput, or null if no output is produced.

- context — The execution context that provides necessary runtime information and functionality.
- input — The input data required to perform the execution.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.forwardTo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/forward-to.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <OutgoingInput> forwardTo(otherNode: AIAgentNodeBase<OutgoingInput, *>): AIAgentEdgeBuilderIntermediate<TOutput, TOutput, OutgoingInput>
```

Creates a directed edge from this AIAgentNodeBase to another AIAgentNodeBase, allowing data to flow from the output of the current node to the input of the specified node.

An AIAgentEdgeBuilderIntermediate that allows further customization of the edge's data transformation and conditions between the nodes.

- otherNode — The destination AIAgentNodeBase to which the current node's output is forwarded.

Referenced packages: `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.id

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/id.html`

### :agents:agents-core/commonMain

```kotlin
val id: String
```

Represents the unique identifier of the AI agent node.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentNodeBase<in TInput, TOutput>
```

Represents an abstract node in an AI agent strategy graph, responsible for executing a specific operation and managing directed edges to other nodes.

- TInput — The type of input data this node processes.
- TOutput — The type of output data this node produces.
- SimpleAIAgentNodeImpl
- AIAgentSubgraphBase
## ai.koog.agents.core.agent.entity.AIAgentNodeBase.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/input-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val inputType: TypeToken
```

The TypeToken of the TInput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/name.html`

### :agents:agents-core/commonMain

```kotlin
abstract val name: String
```

The name of the AI agent node. This property serves as a unique identifier for the node within the strategy graph and is used to distinguish and reference nodes in the graph structure.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/output-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val outputType: TypeToken
```

The TypeToken of the TOutput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBase.resolveEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-base/resolve-edge.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun resolveEdge(context: AIAgentGraphContextBase, nodeOutput: TOutput): AIAgentNodeBase.ResolvedEdge?
```

Resolves the edge associated with the provided node output and execution context. Iterates through available edges and identifies the first edge that can successfully process the given node output within the provided context. If a resolvable edge is found, it returns a ResolvedEdge containing the edge and its output. Otherwise, returns null.

A ResolvedEdge containing the matched edge and its output, or null if no edge matches.

- context — The execution context in which the edge is resolved.
- nodeOutput — The output of the current node used to resolve the edge.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBuilder.AIAgentNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder/-a-i-agent-node-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(name: String?)
```

Initializes the builder with the specified name.

- name — The name of the AIAgentNode, or null if unspecified.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class AIAgentNodeBuilder(name: String?)
```

- name — The name of the AIAgentNode, or null if unspecified.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilder.withInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder/with-input.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input : Any> withInput(clazz: Class<Input>): AIAgentNodeBuilderWithInput<Input>
```

Specifies the input type for building an AIAgentNode.

an instance of AIAgentNodeBuilderWithInput configured with the specified input type.

- clazz — the Class instance representing the input type.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <Input : Any> withInput(typeToken: ERROR CLASS: Symbol not found for TypeToken): AIAgentNodeBuilderWithInput<Input>
```

Configures the builder to use the specified input type for constructing an AIAgentNode.

an AIAgentNodeBuilderWithInput instance configured with the specified input type.

- typeToken — a TypeToken representing the input type.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput.AIAgentNodeBuilderWithInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/-a-i-agent-node-builder-with-input.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken)
```

- Input — The type of input data the AIAgentNode will process.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput.appendPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/append-prompt.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun appendPrompt(promptUpdate: PromptBuilderAction): AIAgentNodeBase<Input, Input>
```

Appends a prompt to the AI agent node configuration.

The prompt is constructed using the provided body lambda, which operates on a PromptBuilder. Optionally, a name can be provided to identify the prompt configuration node.

An instance of AIAgentNodeBase configured with the specified prompt.

- name — An optional name to identify the configuration node. Defaults to null if not specified.
- body — A lambda function that defines the prompt using the PromptBuilder.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class AIAgentNodeBuilderWithInput<Input : Any>(name: String?, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken)
```

- Input — The type of input data the AIAgentNode will process.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput.llmAsAJudge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/llm-as-a-judge.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmAsAJudge(task: String, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null): AIAgentNodeBase<Input, CriticResult<Input>>
```

Configures an AI agent node to evaluate and critique input data as a simulated "judge" using a specified task and an optional Large Language Model (LLM).

An instance of AIAgentNodeBase configured to process input of type Input and generate output of type CriticResult.

- task — The task or criteria used by the AI agent to evaluate input data.
- llmModel — An optional instance of LLModel representing the Large Language Model to be used. Defaults to null.

Referenced packages: `ai.koog.agents.ext.agent`.

## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput.llmRequestStreamingAndSendResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/llm-request-streaming-and-send-results.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun llmRequestStreamingAndSendResults(structureDefinition: ERROR CLASS: Symbol not found for StructureDefinition?? = null): AIAgentNodeBase<Input, ERROR CLASS: Symbol not found for Message.Assistant>
```

Sends a streaming request to the Large Language Model (LLM), accumulates the streamed frames into a single Message.Assistant, and returns it as this node's output.

The streaming request operates on the session's current prompt; the node's own Input value is not consumed by this method.

- structureDefinition — Optional StructureDefinition that guides structured text content in the streamed response. When null, the default unstructured streaming behavior is used.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput.setStructuredOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/set-structured-output.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T> setStructuredOutput(config: ERROR CLASS: Symbol not found for StructuredRequestConfig<T>): AIAgentNodeBase<Input, Input>
```

Configures the node to produce a structured output based on the specified configuration.

This method allows setting up structured output behavior for an AI agent node by defining how content should be structured when requests are processed. The structure is determined by the specified StructuredRequestConfig, which provides options for different providers and fallback behaviors.

An instance of AIAgentNodeBase with the input type Input and output type Input, updated with the configured structured output setup.

- config — The configuration specifying how structured output should be handled, including provider-specific definitions and default fallback options.
## ai.koog.agents.core.agent.entity.AIAgentNodeBuilderWithInput.withOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-node-builder-with-input/with-output.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Output : Any> withOutput(clazz: Class<Output>): TypedAIAgentNodeBuilder<Input, Output>
```

Specifies the output type for the AIAgentNode and returns a builder for creating a typed AIAgentNode.

A builder for creating a typed AIAgentNode configured with the specified output type.

- clazz — The class representing the output type of the node.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <Output : Any> withOutput(typeToken: ERROR CLASS: Symbol not found for TypeToken): TypedAIAgentNodeBuilder<Input, Output>
```

Specifies the output type for the AI agent node and returns a builder for creating a typed AI agent node.

The output type is identified using the provided TypeToken, which allows handling generic types and preserves type information during runtime.

A TypedAIAgentNodeBuilder configured with the specified input and output types, enabling further customization and creation of the typed AI agent node.

- typeToken — The TypeToken that represents the output type of the node.
## ai.koog.agents.core.agent.entity.AIAgentState.AIAgentState

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state/-a-i-agent-state.html`

### :agents:agents-core/commonMain

```kotlin
constructor(iterations: Int = 0)
```

## ai.koog.agents.core.agent.entity.AIAgentState.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state/close.html`

### :agents:agents-core/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.core.agent.entity.AIAgentState.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state/copy.html`

### :agents:agents-core/commonMain

```kotlin
fun copy(): AIAgentState
```

Creates a copy of the current state.

## ai.koog.agents.core.agent.entity.AIAgentState

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentState(iterations: Int = 0) : AutoCloseable
```

Represents the state of an AI agent.

## ai.koog.agents.core.agent.entity.AIAgentState.iterations

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state/iterations.html`

### :agents:agents-core/commonMain

```kotlin
var iterations: Int
```

The running iteration counter of the agent's execution.

The value is seeded from the AIAgentState constructor parameter and is incremented by the framework as nodes are executed. Each call to AIAgentStateManager.withStateLock closes the current AIAgentState snapshot and creates a new one carrying the latest counter value; accessing iterations on a closed snapshot results in an IllegalStateException.

## ai.koog.agents.core.agent.entity.AIAgentStateManager.AIAgentStateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state-manager/-a-i-agent-state-manager.html`

### :agents:agents-core/commonMain

```kotlin
constructor(state: AIAgentState = AIAgentState())
```

Creates a new instance of AIAgentStateManager with the initial state, defaulting to a new AIAgentState if not provided.

## ai.koog.agents.core.agent.entity.AIAgentStateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state-manager/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentStateManager(state: AIAgentState = AIAgentState())
```

Manages the state of an AI agent by providing thread-safe access and mechanisms to update the internal state using a locking mechanism.

This class ensures consistency across state modifications by using a mutual exclusion lock, allowing only one coroutine to access or modify the state at a time.

Note: on every withStateLock invocation, a fresh AIAgentState snapshot is created that carries over the current iteration counter, and the previous snapshot is closed. Consumers must therefore not retain references to the AIAgentState instance received inside the lock across calls.

## ai.koog.agents.core.agent.entity.AIAgentStateManager.withStateLock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-state-manager/with-state-lock.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> withStateLock(block: suspend (AIAgentState) -> T): T
```

Executes the provided suspending block of code with exclusive access to the current state.

After block completes, the current AIAgentState snapshot is closed and replaced with a new snapshot carrying the updated iteration counter. The AIAgentState passed to block must not be retained outside of the block.

The result of block.

## ai.koog.agents.core.agent.entity.AIAgentStorage.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/copy.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun copy(): AIAgentStorage
```

Creates a copy of the current storage.

## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/copy.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun copy(): AIAgentStorage
```

Creates a copy of the current storage.

## ai.koog.agents.core.agent.entity.AIAgentStorageKey.equals

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/equals.html`

### :agents:agents-core/commonMain

```kotlin
open operator override fun equals(other: Any?): Boolean
```

## ai.koog.agents.core.agent.entity.AIAgentStorageKey.hashCode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/hash-code.html`

### :agents:agents-core/commonMain

```kotlin
open override fun hashCode(): Int
```

## ai.koog.agents.core.agent.entity.AIAgentStorageKey.toString

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/to-string.html`

### :agents:agents-core/commonMain

```kotlin
open override fun toString(): String
```

## ai.koog.agents.core.agent.entity.AIAgentStrategy.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-strategy/execute.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun execute(context: TContext, input: TInput): TOutput?
```

Executes the AI agent's strategy using the provided context and input.

This method processes the given input data within the specified context, leveraging the AI agent's internal logic and strategy to produce an output. The concrete decision-making, stateful operations, and any execution-pipeline specifics are fully determined by the implementing strategy.

The output produced by the AI agent's strategy, or null if no output is generated. The output type is defined by the strategy's implementation.

- context — The execution context in which the AI agent operates. It provides access to the agent's configuration, pipeline, environment, and other components required for execution in a graph-based structure.
- input — The input data to be processed by the AI agent's strategy. The type of input is defined by the strategy's implementation and is used to derive the resulting output.
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract suspend fun execute(context: TContext, input: TInput): TOutput?
```

Executes the AI agent's strategy using the provided context and input.

This method processes the given input data within the specified context, leveraging the AI agent's internal logic and strategy to produce an output. The concrete decision-making, stateful operations, and any execution-pipeline specifics are fully determined by the implementing strategy.

The output produced by the AI agent's strategy, or null if no output is generated. The output type is defined by the strategy's implementation.

- context — The execution context in which the AI agent operates. It provides access to the agent's configuration, pipeline, environment, and other components required for execution in a graph-based structure.
- input — The input data to be processed by the AI agent's strategy. The type of input is defined by the strategy's implementation and is used to derive the resulting output.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun execute(context: TContext, input: TInput): TOutput?
```

Executes the AI agent's strategy using the provided context and input.

This method processes the given input data within the specified context, leveraging the AI agent's internal logic and strategy to produce an output. The concrete decision-making, stateful operations, and any execution-pipeline specifics are fully determined by the implementing strategy.

The output produced by the AI agent's strategy, or null if no output is generated. The output type is defined by the strategy's implementation.

- context — The execution context in which the AI agent operates. It provides access to the agent's configuration, pipeline, environment, and other components required for execution in a graph-based structure.
- input — The input data to be processed by the AI agent's strategy. The type of input is defined by the strategy's implementation and is used to derive the resulting output.
## ai.koog.agents.core.agent.entity.AIAgentStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
expect interface AIAgentStrategy<TInput, TOutput, TContext : AIAgentContext>
```

An interface representing the execution strategy of an AI agent.

This strategy defines how the AI agent processes input to produce an output within the context of its operation. It serves as the primary mechanism to encapsulate various decision-making, learning, or processing approaches used by the agent in a flexible manner.

- TInput — The type of input data that the strategy will process.
- TOutput — The type of output data that the strategy will generate.
- TContext — The type of context in which the strategy is executed, extending AIAgentContext.
- AIAgentFunctionalStrategy
- AIAgentGraphStrategyBase
- AIAgentPlannerStrategy

Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual interface AIAgentStrategy<TInput, TOutput, TContext : AIAgentContext>
```

An interface representing the execution strategy of an AI agent.

This strategy defines how the AI agent processes input to produce an output within the context of its operation. It serves as the primary mechanism to encapsulate various decision-making, learning, or processing approaches used by the agent in a flexible manner.

- TInput — The type of input data that the strategy will process.
- TOutput — The type of output data that the strategy will generate.
- TContext — The type of context in which the strategy is executed, extending AIAgentContext.

Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual interface AIAgentStrategy<TInput, TOutput, TContext : AIAgentContext>
```

An interface representing the execution strategy of an AI agent.

This strategy defines how the AI agent processes input to produce an output within the context of its operation. It serves as the primary mechanism to encapsulate various decision-making, learning, or processing approaches used by the agent in a flexible manner.

- TInput — The type of input data that the strategy will process.
- TOutput — The type of output data that the strategy will generate.
- TContext — The type of context in which the strategy is executed, extending AIAgentContext.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentStrategy.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-strategy/name.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract val name: String
```

The name of the AI agent strategy.

This property provides a human-readable identifier for the strategy, which can be used for logging, debugging, or distinguishing between multiple strategies within the system.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract val name: String
```

The name of the AI agent strategy.

This property provides a human-readable identifier for the strategy, which can be used for logging, debugging, or distinguishing between multiple strategies within the system.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract val name: String
```

The name of the AI agent strategy.

This property provides a human-readable identifier for the strategy, which can be used for logging, debugging, or distinguishing between multiple strategies within the system.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.AIAgentSubgraphBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/-a-i-agent-subgraph-base.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String, start: StartNode<TInput>, finish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel? = null, llmParams: LLMParams? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false)
```

- name — The name of the subgraph.
- start — The starting node of the subgraph, which initiates the processing.
- finish — The finishing node of the subgraph, which concludes the processing.
- toolSelectionStrategy — Strategy determining which tools should be available during this subgraph's execution.
- llmModel — Optional LLModel override for the subgraph execution.
- llmParams — Optional LLMParams override for the prompt for the subgraph execution.
- responseProcessor — Optional ResponseProcessor override for the subgraph execution.
- freshHistory — When true, the subgraph starts with only the parent's system messages; user/assistant conversation turns are not inherited. The subgraph's history is discarded upon completion.
- TInput — The type of input data accepted by the subgraph.
- TOutput — The type of output data returned by the subgraph.

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.Companion.FINISH_NODE_PREFIX

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/-companion/-f-i-n-i-s-h_-n-o-d-e_-p-r-e-f-i-x.html`

### :agents:agents-core/commonMain

```kotlin
const val FINISH_NODE_PREFIX: String
```

A constant string used as a prefix to identify "finish" nodes within the AI agent subgraph. Finish nodes typically signify the conclusion of a sequence or process in the graph, and this prefix is used to mark such nodes for easier recognition and handling.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.Companion.START_NODE_PREFIX

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/-companion/-s-t-a-r-t_-n-o-d-e_-p-r-e-f-i-x.html`

### :agents:agents-core/commonMain

```kotlin
const val START_NODE_PREFIX: String
```

A constant string used as a prefix to identify the starting node in an AI agent's execution graph. This prefix is used to ensure unique identification and separation of the start node within the graph structure or during execution-related operations.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

Companion object for the AIAgentSubgraphBase class.

This companion object provides predefined constants used to denote special nodes (start and finish) within the subgraph of an AI agent strategy. It also includes utilities for internal logging.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.enforceExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/enforce-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
open override fun enforceExecutionPoint(node: AIAgentNodeBase<*, *>, input: Any? = null)
```

Enforces execution to start at the specified node with the given input, overriding the default execution flow.

- node — The node at which execution should be forced to start.
- input — The optional input data to provide to the forced node.
- IllegalStateException — if an execution point has already been set and not yet reset.
## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(context: AIAgentGraphContextBase, input: TInput): TOutput?
```

Executes the subgraph for the given input within context.

During execution this method:

Resolves the effective toolset according to the configured ToolSelectionStrategy and replaces context's LLM context with an updated one, overriding tools, and optionally model, prompt.params and responseProcessor for the duration of the subgraph execution.

Emits onSubgraphExecutionStarting, onSubgraphExecutionCompleted and onSubgraphExecutionFailed pipeline events, unless this subgraph is the strategy-level subgraph (which is reported separately).

Runs nodes starting from start (or from an enforced ExecutionPoint, if present) and follows edges until finish is reached or execution is interrupted.

Restores the original LLM context afterwards, preserving the updated message history.

The output produced by finish, or null if execution was interrupted (for example, due to a requested jump to another node or a checkpoint rollback).

- context — The graph execution context which includes all necessary resources and metadata for execution.
- input — The input data to be processed by the subgraph.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.finish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/finish.html`

### :agents:agents-core/commonMain

```kotlin
val finish: FinishNode<TOutput>
```

- finish — The finishing node of the subgraph, which concludes the processing.
## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.getExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/get-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
open override fun getExecutionPoint(): ExecutionPoint?
```

Retrieves the current execution point, which consists of a specific node in the execution graph and an optional input. If no forced node is defined, the method returns null.

The execution point containing the forced node and input, or null if no forced node is set.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/index.html`

### :agents:agents-core/commonMain

```kotlin
open class AIAgentSubgraphBase<TInput, TOutput>(val name: String, val start: StartNode<TInput>, val finish: FinishNode<TOutput>, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel? = null, llmParams: LLMParams? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false) : AIAgentNodeBase<TInput, TOutput> , ExecutionPointNode
```

Base class for AIAgentSubgraph.

- name — The name of the subgraph.
- start — The starting node of the subgraph, which initiates the processing.
- finish — The finishing node of the subgraph, which concludes the processing.
- toolSelectionStrategy — Strategy determining which tools should be available during this subgraph's execution.
- llmModel — Optional LLModel override for the subgraph execution.
- llmParams — Optional LLMParams override for the prompt for the subgraph execution.
- responseProcessor — Optional ResponseProcessor override for the subgraph execution.
- freshHistory — When true, the subgraph starts with only the parent's system messages; user/assistant conversation turns are not inherited. The subgraph's history is discarded upon completion.
- TInput — The type of input data accepted by the subgraph.
- TOutput — The type of output data returned by the subgraph.
- AIAgentGraphStrategyBase
- AIAgentSubgraph

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/input-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val inputType: TypeToken
```

The TypeToken of the TInput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/name.html`

### :agents:agents-core/commonMain

```kotlin
open override val name: String
```

- name — The name of the subgraph.
## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/output-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val outputType: TypeToken
```

The TypeToken of the TOutput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.resetExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/reset-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
open override fun resetExecutionPoint()
```

Resets the currently enforced execution point for the AI agent, including clearing any forced node and input data. Once the execution point is reset, the system will revert to its default execution behavior without targeting a specific node explicitly.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBase.start

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-base/start.html`

### :agents:agents-core/commonMain

```kotlin
val start: StartNode<TInput>
```

- start — The starting node of the subgraph, which initiates the processing.
## ai.koog.agents.core.agent.entity.AIAgentSubgraphBuilderWithInput.AIAgentSubgraphBuilderWithInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-builder-with-input/-a-i-agent-subgraph-builder-with-input.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, freshHistory: Boolean = false)
```

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBuilderWithInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-builder-with-input/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open class AIAgentSubgraphBuilderWithInput<Input : Any, SubgraphBuilder : AgentSubgraphBuilder<SubgraphBuilder>>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, freshHistory: Boolean = false) : AgentSubgraphBuilder<SubgraphBuilder>
```

A builder class for constructing AI agent subgraphs with a specified input type.

This class extends AgentSubgraphBuilder and provides additional functionality to define an input type for the subgraph, enabling the creation of typed subgraphs where the input to the graph is explicitly defined.

## ai.koog.agents.core.agent.entity.AIAgentSubgraphBuilderWithInput.withFinishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-builder-with-input/with-finish-tool.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <Output : Any, OutputTransformed : Any> withFinishTool(finishTool: ERROR CLASS: Symbol not found for Tool<Output, OutputTransformed>): SubgraphWithFinishToolBuilder<Input, Output, OutputTransformed>
```

Configures the subgraph with a specified finish tool to process the output. This allows the subgraph to conclude by transforming the output using the provided tool.

A builder instance of SubgraphWithFinishToolBuilder configured to handle the input type Input and the transformed output type OutputTransformed.

- finishTool — The tool responsible for transforming the output of type Output into a new type OutputTransformed before finalizing the subgraph processing.
## ai.koog.agents.core.agent.entity.AIAgentSubgraphBuilderWithInput.withOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-builder-with-input/with-output.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Output : Any> withOutput(outputClass: Class<Output>): TypedAIAgentSubgraphBuilder<Input, Output>
```

Specifies the output type for the subgraph and transitions to a builder capable of handling the provided input and output types. This method returns a new instance of the builder, with the output type defined as the given class.

A builder instance with the specified input and output types configured.

- outputClass — The output class type that the subgraph is expected to handle.
## ai.koog.agents.core.agent.entity.AIAgentSubgraphBuilderWithInput.withVerification

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-subgraph-builder-with-input/with-verification.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withVerification(defineVerificationTask: ContextualAction<Input, String>): SubgraphWithTaskBuilder<Input, CriticResult<Input>>
```

Responsible for building a subgraph that can perform verification tasks within the AI agent graph. Resulting subgraph woult take an instance of Input and produce an instance of CriticResult<Input>

A builder instance of SubgraphWithTaskBuilder configured to handle the input type Input and output type CriticResult, incorporating the specified verification behavior.

- defineVerificationTask — A contextual action defining the verification task. It processes the input of type Input and produces a String as output within the AI agent graph context.

Referenced packages: `ai.koog.agents.ext.agent`.

### :agents:agents-core/jvmCommonMain

```kotlin
fun withVerification(defineVerificationTask: SimpleAction<Input, String>): SubgraphWithTaskBuilder<Input, CriticResult<Input>>
```

Responsible for building a subgraph that can perform verification tasks within the AI agent graph. Resulting subgraph woult take an instance of Input and produce an instance of CriticResult<Input>

A builder instance of SubgraphWithTaskBuilder configured to handle the input type Input and output type CriticResult, incorporating the specified verification behavior.

- defineVerificationTask — An action defining the verification task. It processes the input of type Input and produces a String as output within the AI agent graph context.

Referenced packages: `ai.koog.agents.ext.agent`.

## ai.koog.agents.core.agent.entity.AgentEdgeBuilder.AgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-edge-builder/-agent-edge-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor()
```

## ai.koog.agents.core.agent.entity.AgentEdgeBuilder.from

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-edge-builder/from.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input, Output> from(node: AIAgentNodeBase<Input, Output>): PartialAgentEdgeBuilder<Input, Output>
```

Initializes the construction of a partial edge in the AI agent strategy graph, starting from the specified node. The partial edge allows further specification of the destination node and the transformation logic for data flowing between nodes.

A PartialAgentEdgeBuilder instance that provides methods to further define the edge, such as specifying the destination node and additional data transformations.

- node — The starting node for the edge being built. This node represents the source of the data that will flow through the constructed edge.
## ai.koog.agents.core.agent.entity.AgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-edge-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class AgentEdgeBuilder
```

A builder class for creating and managing edges between AI agent nodes in a graph. This class serves as an entry point to initiate the construction of directed edges by associating a starting node with subsequent interconnected nodes.

The builder facilitates a step-by-step process for defining the relationships and data flows between nodes in the agent strategy graph. Starting from a defined node, it returns a PartialAgentEdgeBuilder to further specify the destination node and finalize the edge configuration.

## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.AgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/-agent-subgraph-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, freshHistory: Boolean = false)
```

## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open class AgentSubgraphBuilder<SubgraphBuilder : AgentSubgraphBuilder<SubgraphBuilder>>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, freshHistory: Boolean = false)
```

A builder class for configuring and constructing subgraphs in an AI agent graph strategy.

This class provides methods to configure the subgraph's properties such as tool selection strategy, LLM (Language Model) parameters,

- AIAgentSubgraphBuilderWithInput
- TypedAIAgentSubgraphBuilderBase
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.limitedTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/limited-tools.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun limitedTools(tools: List<ERROR CLASS: Symbol not found for ToolBase<*, *>>): SubgraphBuilder
```

Configures the builder to use a specific list of tools for the AI agent's subgraph.

The current instance of AgentSubgraphBuilder for chaining further configurations.

- tools — A list of tools to be used, each represented by its descriptor.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun limitedTools(vararg toolSets: ERROR CLASS: Symbol not found for ToolSet): SubgraphBuilder
```

Configures the builder with a selection of tools defined by the provided tool sets. The tools will be extracted from each ToolSet and applied to the builder's tool selection strategy.

The current instance of

- toolSets — One or more ToolSet instances, each representing a collection of tools to be added to the builder's tool selection strategy.
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.usingLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/using-l-l-m.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun usingLLM(llmModel: ERROR CLASS: Symbol not found for LLModel): SubgraphBuilder
```

Sets the specified Large Language Model (LLM) for the agent subgraph builder.

The current instance of AgentSubgraphBuilder with the specified LLM model applied.

- llmModel — The LLM instance to be associated with the agent subgraph builder.
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.withFreshHistory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/with-fresh-history.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withFreshHistory(freshHistory: Boolean): SubgraphBuilder
```

Configures the subgraph to start with only the parent's system messages, discarding inherited user/assistant conversation turns. The subgraph's own history is discarded upon completion, so it does not affect the parent's conversation.

- freshHistory — When true, the subgraph starts with only inherited system messages. Defaults to false (full history inherited).
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.withInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/with-input.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input : Any> withInput(outputClass: Class<Input>): AIAgentSubgraphBuilderWithInput<Input, *>
```

Configures the builder with the specified input type and returns a new instance of AIAgentSubgraphBuilderWithInput, allowing further configuration for the specified input type.

- outputClass — the class type of the input to be used in the subgraph
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.withLLMParams

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/with-l-l-m-params.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withLLMParams(llmParams: ERROR CLASS: Symbol not found for LLMParams): SubgraphBuilder
```

Sets the parameters for the Language Learning Model (LLM) in the current builder.

The updated instance of the AIAgentSubgraphBuilder.

- llmParams — The parameters to configure the LLM behavior.
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.withResponseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/with-response-processor.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withResponseProcessor(responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor): SubgraphBuilder
```

Sets the specified response processor to handle and modify LLM responses.

- responseProcessor — the response processor to handle responses during
## ai.koog.agents.core.agent.entity.AgentSubgraphBuilder.withToolSelectionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-agent-subgraph-builder/with-tool-selection-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withToolSelectionStrategy(strategy: ToolSelectionStrategy): SubgraphBuilder
```

Sets the tool selection strategy for the subgraph builder and returns the updated builder instance.

The tool selection strategy determines how tools are selected for use in the subgraph. This method allows specifying a custom strategy to override the default behavior.

- strategy — The tool selection strategy to apply. It defines the subset of tools to be included or excluded during subgraph execution.
## ai.koog.agents.core.agent.entity.CompatibleFullAgentEdgeBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-compatible-full-agent-edge-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open override fun build(): AIAgentEdge<IncomingOutput, OutgoingInput>
```

Constructs and finalizes an AIAgentEdge connecting the specified source and destination nodes.

An instance of AIAgentEdge that represents the constructed edge between the source node and the destination node, enabling the controlled transmission of data from the source to the destination.

## ai.koog.agents.core.agent.entity.CompatibleFullAgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-compatible-full-agent-edge-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open class CompatibleFullAgentEdgeBuilder<IncomingOutput, CompatibleOutput : OutgoingInput, OutgoingInput> : FullAgentEdgeBuilder<IncomingOutput, CompatibleOutput, OutgoingInput>
```

Constructs a compatible full agent edge between two AI agent nodes, enabling the flow and transformation of data from the output of one node to the input of another.

- fromNode — The source AI agent node, which emits data that needs to be forwarded.
- toNode — The destination AI agent node, which receives the forwarded data.
- forwardOutputComposition — A transformation function that takes the graph execution context and the output from the source node, and produces an optional intermediate compatible output.
- IncomingOutput — The type of the output data produced by the source node.
- CompatibleOutput — An intermediate type ensuring compatibility between the source node and destination node, derived from the source node's output.
- OutgoingInput — The type of the input data expected by the destination node.
## ai.koog.agents.core.agent.entity.CompatibleFullAgentEdgeBuilder.onCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-compatible-full-agent-edge-builder/on-condition.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open override fun onCondition(condition: ContextualCondition<CompatibleOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, CompatibleOutput, OutgoingInput>
```

Applies a contextual condition to filter the output being processed and forwarded within the graph.

This method attaches a condition that evaluates whether a given intermediate output should be propagated to the destination node. The condition is evaluated based on the output and the current AI agent graph context.

A builder instance that allows further configuration or chaining of processing steps.

- condition — A condition to be evaluated for each intermediate output. It takes the output and the context as arguments and returns a boolean indicating whether to propagate the output (true) or filter it out (false).
### :agents:agents-core/jvmCommonMain

```kotlin
open override fun onCondition(condition: SimpleCondition<CompatibleOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, CompatibleOutput, OutgoingInput>
```

Attaches a condition that filters intermediate outputs before they are propagated to the target node within the agent's processing graph.

This method applies a simple, stateless condition to determine whether an intermediate output should be forwarded downstream. The condition is evaluated based on the output value.

A builder instance to allow further configuration or chaining of processing steps.

- condition — A simple condition to evaluate for each intermediate output. It receives an output object as input and returns true if the output should be forwarded, or false if it should be filtered out.
## ai.koog.agents.core.agent.entity.CompressHistoryNodeBuilder.CompressHistoryNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-compress-history-node-builder/-compress-history-node-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(name: String)
```

- name — The name of the node being created.
## ai.koog.agents.core.agent.entity.CompressHistoryNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-compress-history-node-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class CompressHistoryNodeBuilder(name: String)
```

Builder class for creating a compress history node in an AI agent graph strategy.

- name — The name of the node being created.
## ai.koog.agents.core.agent.entity.CompressHistoryNodeBuilder.withInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-compress-history-node-builder/with-input.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input : Any> withInput(clazz: Class<Input>): TypedCompressHistoryNodeBuilder<Input>
```

Configures the current CompressHistoryNodeBuilder with a specific input type, returning a new TypedCompressHistoryNodeBuilder specialized for the provided type.

A new instance of TypedCompressHistoryNodeBuilder configured with the specified input type.

- clazz — The Class object representing the input type to associate with the builder.
- Input — The type of input to be associated with the resulting TypedCompressHistoryNodeBuilder. It must be a non-nullable type.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <Input : Any> withInput(typeToken: ERROR CLASS: Symbol not found for TypeToken): TypedCompressHistoryNodeBuilder<Input>
```

Configures the current CompressHistoryNodeBuilder with a specific input type using a TypeToken, returning a new TypedCompressHistoryNodeBuilder specialized for the provided type.

A new instance of TypedCompressHistoryNodeBuilder configured with the specified input type.

- typeToken — The TypeToken representing the input type to associate with the builder.
- Input — The type of input to be associated with the resulting TypedCompressHistoryNodeBuilder. It must be a non-nullable type.
## ai.koog.agents.core.agent.entity.ContextualAction.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-contextual-action/execute.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun execute(input: Input, ctx: AIAgentGraphContextBase): Output
```

Executes an action within the given context using the provided input and returns the corresponding output.

The output produced as a result of executing the action.

- input — The input data required for executing the action.
- ctx — The context in which the action is performed, providing necessary resources, configurations, and state management.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.ContextualAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-contextual-action/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface ContextualAction<Input, Output>
```

Represents a functional interface that defines a contextual action for processing an input and producing an output within a specific AI agent graph context.

This functional interface is designed

## ai.koog.agents.core.agent.entity.ContextualCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-contextual-condition/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface ContextualCondition<Output>
```

ContextualCondition is a functional interface designed to evaluate a condition based on an output value and the given AI agent graph context.

- Output — The type of the output value that the condition evaluates.
## ai.koog.agents.core.agent.entity.ContextualCondition.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-contextual-condition/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract operator fun invoke(output: Output, context: AIAgentGraphContextBase): Boolean
```

Invokes the contextual condition with the given output and context to evaluate its result.

A boolean value indicating the result of the condition evaluation. Returns true if the condition is met, otherwise false.

- output — The output data passed to the condition for evaluation.
- context — The contextual information required for evaluating the condition, provided as an implementation of the AIAgentGraphContextBase interface.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.ContextualTransformation

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-contextual-transformation/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface ContextualTransformation<Output, NewOutput>
```

A functional interface representing a transformation operation that processes an input output of type Output in the context of AIAgentGraphContextBase and produces a transformed result of type NewOutput.

## ai.koog.agents.core.agent.entity.ContextualTransformation.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-contextual-transformation/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract operator fun invoke(output: Output, context: AIAgentGraphContextBase): NewOutput
```

Transforms the given output using the provided AI agent graph context and returns a new output.

A new output resulting from the transformation.

- output — The original output to be transformed.
- context — The context providing the necessary information and functionality for transformation within the AI agent graph.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.DefinedAIAgentNodeBuilder.DefinedAIAgentNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-defined-a-i-agent-node-builder/-defined-a-i-agent-node-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken, outputTypeToken: ERROR CLASS: Symbol not found for TypeToken, nodeAction: ContextualAction<Input, Output>)
```

Initializes a new instance of the builder with the specified node name, input/output type tokens, and the contextual action to execute in the node.

- Input — The type of the input data processed by the constructed AIAgentNode.
- Output — The type of the output data produced by the constructed AIAgentNode.
## ai.koog.agents.core.agent.entity.DefinedAIAgentNodeBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-defined-a-i-agent-node-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun build(): AIAgentNode<Input, Output>
```

Builds and returns an instance of AIAgentNode configured with the specified parameters. The node will execute the provided ContextualAction with the input data when invoked.

A fully configured instance of AIAgentNode parameterized with Input and Output types.

## ai.koog.agents.core.agent.entity.DefinedAIAgentNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-defined-a-i-agent-node-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class DefinedAIAgentNodeBuilder<Input : Any, Output : Any>(name: String?, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken, outputTypeToken: ERROR CLASS: Symbol not found for TypeToken, nodeAction: ContextualAction<Input, Output>)
```

A builder class responsible for constructing instances of AIAgentNode with specific input and output types, a unique node name, and a defined contextual action to be executed within an AI agent graph context.

- Input — The type of the input data processed by the constructed AIAgentNode.
- Output — The type of the output data produced by the constructed AIAgentNode.
## ai.koog.agents.core.agent.entity.DefinedAIAgentSubgraphBuilder.DefinedAIAgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-defined-a-i-agent-subgraph-builder/-defined-a-i-agent-subgraph-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputClass: Class<Output>, buildSubgraph: GraphBuilderAction<Input, Output>, freshHistory: Boolean = false)
```

Initializes the builder with a name, tool selection strategy, LLM configuration, response processor, input/output types, and a subgraph build action.

- name — The name of the subgraph.
- toolSelectionStrategy — Strategy to determine which tools are included in this subgraph. Defaults to using all tools.
- llmModel — The Large Language Model (LLM) to use for generating responses, or null if no model is provided.
- llmParams — Optional parameters for configuring the behavior of the LLM, such as temperature or context length.
- responseProcessor — A processor for handling and modifying the response after the subgraph's execution.
- inputClass — The class representing the input type for the subgraph.
- outputClass — The class representing the output type for the subgraph.
- buildSubgraph — The action that defines the logic for constructing the subgraph.
- Input — The type of the input data for the subgraph.
- Output — The type of the output data for the subgraph.
## ai.koog.agents.core.agent.entity.DefinedAIAgentSubgraphBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-defined-a-i-agent-subgraph-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun build(): AIAgentSubgraphBase<Input, Output>
```

Builds and returns an instance of AIAgentSubgraphBase configured with the specified input and output types.

The method initializes a graph strategy with a name, input class, and output class. It leverages the provided buildSubgraph to define the logic for the subgraph creation. The resulting graph is finalized and returned as an AIAgentSubgraphBase instance.

A configured instance of AIAgentSubgraphBase with the specified input and output types.

## ai.koog.agents.core.agent.entity.DefinedAIAgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-defined-a-i-agent-subgraph-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class DefinedAIAgentSubgraphBuilder<Input : Any, Output : Any>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputClass: Class<Output>, buildSubgraph: GraphBuilderAction<Input, Output>, freshHistory: Boolean = false) : TypedAIAgentSubgraphBuilderBase<Input, Output, TypedAIAgentSubgraphBuilder<Input, Output>>
```

Builder class for creating a defined AI Agent subgraph with specific input and output types.

This class allows customization of subgraph configurations, such as the selection strategy for tools, language model parameters, and response processing. The subgraph's internal logic is defined using the buildSubgraph action passed to the constructor.

- name — The name of the subgraph.
- toolSelectionStrategy — Strategy to determine which tools are included in this subgraph. Defaults to using all tools.
- llmModel — The Large Language Model (LLM) to use for generating responses, or null if no model is provided.
- llmParams — Optional parameters for configuring the behavior of the LLM, such as temperature or context length.
- responseProcessor — A processor for handling and modifying the response after the subgraph's execution.
- inputClass — The class representing the input type for the subgraph.
- outputClass — The class representing the output type for the subgraph.
- buildSubgraph — The action that defines the logic for constructing the subgraph.
- Input — The type of the input data for the subgraph.
- Output — The type of the output data for the subgraph.
## ai.koog.agents.core.agent.entity.ExecutionPoint.ExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point/-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
constructor(node: AIAgentNodeBase<*, *>, input: Any? = null)
```

## ai.koog.agents.core.agent.entity.ExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ExecutionPoint(val node: AIAgentNodeBase<*, *>, val input: Any? = null)
```

Represents a point of execution within the AI agent's strategy graph. An execution point consists of a specific node and an optional input value.

## ai.koog.agents.core.agent.entity.ExecutionPoint.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.agent.entity.ExecutionPoint.node

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point/node.html`

### :agents:agents-core/commonMain

```kotlin
val node: AIAgentNodeBase<*, *>
```

## ai.koog.agents.core.agent.entity.ExecutionPointNode.enforceExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point-node/enforce-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun enforceExecutionPoint(node: AIAgentNodeBase<*, *>, input: Any? = null)
```

Enforces execution to start at the specified node with the given input, overriding the default execution flow.

- node — The node at which execution should be forced to start.
- input — The optional input data to provide to the forced node.
- IllegalStateException — if an execution point has already been set and not yet reset.
## ai.koog.agents.core.agent.entity.ExecutionPointNode.getExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point-node/get-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun getExecutionPoint(): ExecutionPoint?
```

Retrieves the current execution point, which consists of a specific node in the execution graph and an optional input. If no forced node is defined, the method returns null.

The execution point containing the forced node and input, or null if no forced node is set.

## ai.koog.agents.core.agent.entity.ExecutionPointNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point-node/index.html`

### :agents:agents-core/commonMain

```kotlin
interface ExecutionPointNode
```

Represents a node in the execution graph of an AI agent that can explicitly enforce execution at a specified node with optional input data. This interface provides the ability to define a forced node and input, overriding default execution behavior.

- AIAgentSubgraphBase
## ai.koog.agents.core.agent.entity.ExecutionPointNode.resetExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-execution-point-node/reset-execution-point.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun resetExecutionPoint()
```

Resets the currently enforced execution point for the AI agent, including clearing any forced node and input data. Once the execution point is reset, the system will revert to its default execution behavior without targeting a specific node explicitly.

## ai.koog.agents.core.agent.entity.FinishNode.addEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-finish-node/add-edge.html`

### :agents:agents-core/commonMain

```kotlin
open override fun addEdge(edge: AIAgentEdge<TOutput, *>)
```

Adds a directed edge from the current node, enabling connections between this node and other nodes in the AI agent strategy graph.

- edge — The edge to be added, representing a connection from this node's output to another node in the strategy graph.
## ai.koog.agents.core.agent.entity.FinishNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-finish-node/index.html`

### :agents:agents-core/commonMain

```kotlin
class FinishNode<TOutput> : AIAgentNode<TOutput, TOutput>
```

Represents a specialized node within an AI agent strategy graph that marks the endpoint of a subgraph. This node serves as a "finish" node and directly passes its input to its output without modification.

This node enforces the following constraints:

It cannot have outgoing edges, meaning no further nodes can follow it in the execution graph.

It simply returns the input it receives as its output, ensuring no modification occurs at the end of execution.

The name property of the node reflects a uniquely identifiable pattern using the prefix "finish" and the optional subgraph name, enabling traceability of execution flow in multi-subgraph setups.

- subgraphName — The name of the related subgraph
- type — TypeToken representing TOutput
- TOutput — The type of data this node processes and produces.
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.asToolResultMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/as-tool-result-message.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun asToolResultMessage(condition: SimpleCondition<ReceivedToolResult> = { true }): FullAgentEdgeBuilder<IncomingOutput, ERROR CLASS: Symbol not found for Message.User, OutgoingInput>
```

Creates an edge that transforms an intermediate output into a Message.User using the provided transform.

- condition — A predicate that filters which ReceivedToolResult entries are included in the message.

Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.asUserMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/as-user-message.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun asUserMessage(transformation: SimpleTransformation<IntermediateOutput, String> = { it.toString() }): FullAgentEdgeBuilder<IncomingOutput, ERROR CLASS: Symbol not found for Message.User, OutgoingInput>
```

Creates an edge that transforms an intermediate output into a Message.User using the provided transform.

- transformation — A function that converts the intermediate output to a String for the user message.
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open fun build(): AIAgentEdge<IncomingOutput, OutgoingInput>
```

Builds the edge between the source and destination nodes.

This requires that IntermediateOutput is compatible with OutgoingInput at runtime. Prefer using CompatibleFullAgentEdgeBuilder.build when static type compatibility is known.

## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open class FullAgentEdgeBuilder<IncomingOutput, IntermediateOutput, OutgoingInput>
```

A builder class for constructing a specialized edge in an AI agent strategy graph. This edge enables data flow between two nodes while supporting a composition of the output transformation logic.

- fromNode — The source node in the strategy graph. This node produces the input data.
- toNode — The destination node in the strategy graph. This node consumes the transformed data.
- forwardOutputComposition — A suspendable function that transforms the output of the fromNode into an intermediate format before passing it to the toNode. The transformation output is represented as an Option type, allowing for optional chaining and flexibility in data flow.
- IncomingOutput — The type of input data from the fromNode.
- IntermediateOutput — The type of processed data output by the forwardOutputComposition function.
- OutgoingInput — The type of input data expected by the toNode.
- CompatibleFullAgentEdgeBuilder
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.onCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/on-condition.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open fun onCondition(condition: ContextualCondition<IntermediateOutput>): FullAgentEdgeBuilder<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Applies a contextual condition to filter the output being processed and forwarded within the graph.

This method attaches a condition that evaluates whether a given intermediate output should be propagated to the destination node. The condition is evaluated based on the output and the current AI agent graph context.

A builder instance that allows further configuration or chaining of processing steps.

- condition — A condition to be evaluated for each intermediate output. It takes the output and the context as arguments and returns a boolean indicating whether to propagate the output (true) or filter it out (false).
### :agents:agents-core/jvmCommonMain

```kotlin
open fun onCondition(condition: SimpleCondition<IntermediateOutput>): FullAgentEdgeBuilder<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Attaches a condition that filters intermediate outputs before they are propagated to the target node within the agent's processing graph.

This method applies a simple, stateless condition to determine whether an intermediate output should be forwarded downstream. The condition is evaluated based on the output value.

A builder instance to allow further configuration or chaining of processing steps.

- condition — A simple condition to evaluate for each intermediate output. It receives an output object as input and returns true if the output should be forwarded, or false if it should be filtered out.
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.onIsInstance

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/on-is-instance.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open fun <OutputSubtype : IntermediateOutput> onIsInstance(clazz: Class<OutputSubtype>): FullAgentEdgeBuilder<IncomingOutput, OutputSubtype, OutgoingInput>
```

Filters the outputs of the current processing edge based on their type, forwarding only those that are instances of the specified class.

A builder instance allowing further configuration or chaining of processing steps within the agent's processing graph.

- clazz — The class instance used to check the type of intermediate outputs. Only outputs that are instances of this class will be forwarded.
### :agents:agents-core/jvmCommonMain

```kotlin
open fun <CompatibleOutput : OutgoingInput> onIsInstance(clazz: Class<CompatibleOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, CompatibleOutput, OutgoingInput>
```

Filters intermediate outputs to only process those that are instances of the specified class type.

A builder instance configured to handle the filtered and casted outputs, enabling further processing or chaining of transformations.

- clazz — The Class object representing the type to filter by and cast to.
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.onMessageParts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/on-message-parts.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T : ERROR CLASS: Symbol not found for MessagePart> onMessageParts(clazz: Class<T>): FullAgentEdgeBuilder<IncomingOutput, List<T>, OutgoingInput>
```

Filters the intermediate output to only Message instances that contain parts of type T, and transforms the output to a list of those parts.

- clazz — The class of MessagePart subtype to filter by.
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.onTextMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/on-text-message.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun onTextMessage(): FullAgentEdgeBuilder<IncomingOutput, String, OutgoingInput>
```

Creates an edge that extracts text content from message parts.

## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.onToolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/on-tool-calls.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun onToolCalls(condition: SimpleCondition<ERROR CLASS: Symbol not found for MessagePart.Tool.Call> = { true }): FullAgentEdgeBuilder<IncomingOutput, ToolCalls, OutgoingInput>
```

Creates an edge that filters assistant messages containing tool calls matching the provided condition. The default condition onToolCalls { true } accepts any message with at least one tool call.

- condition — A predicate that determines whether a tool call should be accepted.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.transformed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/transformed.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <CompatibleOutput : OutgoingInput> transformed(transformation: ContextualTransformation<IntermediateOutput, CompatibleOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, CompatibleOutput, OutgoingInput>
```

### :agents:agents-core/jvmCommonMain

```kotlin
fun <TransformedOutput> transformed(transformation: ContextualTransformation<IntermediateOutput, TransformedOutput>): FullAgentEdgeBuilder<IncomingOutput, TransformedOutput, OutgoingInput>
```

Transforms the intermediate output of the AIAgentNode by applying a given transformation block.

A builder instance configured to handle the transformed outputs and enable further chaining or customization of the agent's graph configuration.

- transformation — A contextual transformation function that takes an intermediate output and an AI agent graph context as input, and produces a compatible output.
### :agents:agents-core/jvmCommonMain

```kotlin
fun <CompatibleOutput : OutgoingInput> transformed(transformation: SimpleTransformation<IntermediateOutput, CompatibleOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, CompatibleOutput, OutgoingInput>
```

Transforms the intermediate output of the AIAgentNode by applying a given transformation block.

A builder for configuring and chaining additional processing steps for the edge, maintaining type compatibility with the transformed output.

- transformation — A functional interface that defines how to transform intermediate outputs of type IntermediateOutput into compatible outputs of type CompatibleOutput.
### :agents:agents-core/jvmCommonMain

```kotlin
fun <TransformedOutput> transformed(transformation: SimpleTransformation<IntermediateOutput, TransformedOutput>): FullAgentEdgeBuilder<IncomingOutput, TransformedOutput, OutgoingInput>
```

Transforms the intermediate output of the AIAgentNode by applying a given transformation block.

A builder for configuring and chaining additional processing steps for the edge, maintaining type compatibility with the transformed output.

- transformation — A functional interface that defines how to transform intermediate outputs of type IntermediateOutput into compatible outputs of type CompatibleOutput.
## ai.koog.agents.core.agent.entity.FullAgentEdgeBuilder.withAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-full-agent-edge-builder/with-action.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <NewOutput : OutgoingInput> withAction(action: ContextualTransformation<IntermediateOutput, NewOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, NewOutput, OutgoingInput>
```

Transforms the intermediate output of the edge by applying the given action. This is an alias for transformed providing naming consistency with the node builder API.

A builder instance configured to handle the transformed outputs.

- action — A contextual transformation function that takes an intermediate output and an AI agent graph context as input, and produces a compatible output.
### :agents:agents-core/jvmCommonMain

```kotlin
fun <NewOutput : OutgoingInput> withAction(action: SimpleTransformation<IntermediateOutput, NewOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, NewOutput, OutgoingInput>
```

Transforms the intermediate output of the edge by applying the given action. This is an alias for transformed providing naming consistency with the node builder API.

A builder instance configured to handle the transformed outputs.

- action — A simple transformation function that takes an intermediate output and produces a compatible output.
## ai.koog.agents.core.agent.entity.GraphBuilderAction.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-builder-action/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun build(graph: TypedGraphStrategyBuilder<Input, Output>)
```

Builds and configures a graph

## ai.koog.agents.core.agent.entity.GraphBuilderAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-builder-action/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface GraphBuilderAction<Input : Any, Output : Any>
```

Functional interface representing an action that builds a graph using a provided TypedGraphStrategyBuilder. This action allows the customization and configuration of a graph strategy based on specific requirements for input and output types.

- Input — The type of the input entities for the graph strategy.
## ai.koog.agents.core.agent.entity.GraphStrategyBuilder.GraphStrategyBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-strategy-builder/-graph-strategy-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(strategyName: String)
```

- strategyName — The name of the strategy being built.
## ai.koog.agents.core.agent.entity.GraphStrategyBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-strategy-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class GraphStrategyBuilder(strategyName: String)
```

A builder class used for constructing strategies related to graph processing. This serves as the entry point for configuring a graph strategy, allowing you to define the input type for the graph.

- strategyName — The name of the strategy being built.
## ai.koog.agents.core.agent.entity.GraphStrategyBuilder.withInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-strategy-builder/with-input.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input : Any> withInput(clazz: Class<Input>): GraphStrategyBuilderWithInput<Input>
```

Configures the builder to use the specified input type for the graph strategy.

A new instance of GraphStrategyBuilderWithInput configured with the specified input type.

## ai.koog.agents.core.agent.entity.GraphStrategyBuilderWithInput.GraphStrategyBuilderWithInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-strategy-builder-with-input/-graph-strategy-builder-with-input.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(strategyName: String, inputClass: KClass<Input>)
```

- strategyName — The name of the strategy being built.
- Input — The type of the input that the graph will utilize.
## ai.koog.agents.core.agent.entity.GraphStrategyBuilderWithInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-strategy-builder-with-input/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class GraphStrategyBuilderWithInput<Input : Any>(strategyName: String, inputClass: KClass<Input>)
```

A builder class for constructing graph strategies that start with a specific input type.

This class is used to define the input type of a graph and allows chaining to specify the output type, enabling the creation of a strongly-typed graph strategy.

- strategyName — The name of the strategy being built.
- Input — The type of the input that the graph will utilize.
## ai.koog.agents.core.agent.entity.GraphStrategyBuilderWithInput.withOutput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-graph-strategy-builder-with-input/with-output.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Output : Any> withOutput(clazz: Class<Output>): TypedGraphStrategyBuilder<Input, Output>
```

Specifies the output type for the graph strategy and returns a builder configured with the input and output types.

A TypedGraphStrategyBuilder instance configured with the current input type and the specified output type.

## ai.koog.agents.core.agent.entity.PartialAgentEdgeBuilder.PartialAgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-partial-agent-edge-builder/-partial-agent-edge-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(fromNode: AIAgentNodeBase<IncomingInput, IncomingOutput>)
```

- IncomingInput — The type of input that the source node processes.
- IncomingOutput — The type of output that the source node produces.
## ai.koog.agents.core.agent.entity.PartialAgentEdgeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-partial-agent-edge-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open class PartialAgentEdgeBuilder<IncomingInput, IncomingOutput>(fromNode: AIAgentNodeBase<IncomingInput, IncomingOutput>)
```

A builder class used to define a transitional directed edge in an AI agent strategy graph.

This class allows the creation of a partial edge connection from a specified node to its target node, enabling data flow from the source node's output to the target node's input. The actual configuration of the edge (e.g., data transformations, flow conditions) is finalized using the next step in the builder chain.

- IncomingInput — The type of input that the source node processes.
- IncomingOutput — The type of output that the source node produces.
## ai.koog.agents.core.agent.entity.PartialAgentEdgeBuilder.to

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-partial-agent-edge-builder/to.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open fun <OutgoingInput, OutgoingOutput> to(toNode: AIAgentNodeBase<OutgoingInput, OutgoingOutput>): FullAgentEdgeBuilder<IncomingOutput, IncomingOutput, OutgoingInput>
```

Creates a directed edge from the current node to the specified node, enabling the flow of data between them in the AI agent strategy graph. This method connects the current node's output directly to the input of the specified node without applying transformations.

A FullAgentEdgeBuilder instance that allows further customization of the edge and its data flow properties. This builder establishes the connection between the current node's output and the specified node's input.

- toNode — The destination node to which the current node's output will be forwarded. The type of input this node processes is represented by OutgoingInput, and the type of output it produces is represented by OutgoingOutput.
### :agents:agents-core/jvmCommonMain

```kotlin
open fun <OutgoingOutput> to(toNode: AIAgentNodeBase<in IncomingOutput, OutgoingOutput>): CompatibleFullAgentEdgeBuilder<IncomingOutput, IncomingOutput, IncomingOutput>
```

Creates a directed edge from the current node to the specified node, enabling the flow of data between them in the AI agent strategy graph. This method connects the current node's output directly to the input of the specified node without applying transformations.

A CompatibleFullAgentEdgeBuilder instance that allows further customization of the edge and its data flow properties. This builder establishes the connection between the current node's output and the specified node's input.

- toNode — The destination node to which the current node's output will be forwarded. The type of input this node processes is represented by IncomingOutput, and the type of output it produces is represented by OutgoingOutput.
## ai.koog.agents.core.agent.entity.PromptBuilderAction.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-prompt-builder-action/build.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
abstract fun build(promptBuilder: ERROR CLASS: Symbol not found for PromptBuilder)
```

Executes the provided action on the given PromptBuilder instance.

- promptBuilder — The PromptBuilder instance to be configured or modified.
## ai.koog.agents.core.agent.entity.PromptBuilderAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-prompt-builder-action/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface PromptBuilderAction
```

Represents an action that defines how a PromptBuilder is configured.

This functional interface is primarily used in the context of building prompt-related configurations for AI agent nodes. Implementations of this interface customize a PromptBuilder instance, which facilitates the creation of structured or dynamic prompts.

## ai.koog.agents.core.agent.entity.SimpleAIAgentNodeImpl.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-a-i-agent-node-impl/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(context: AIAgentGraphContextBase, input: TInput): TOutput
```

Executes a specific operation based on the given context and input.

Implementations may return null to indicate that no output is produced for the current invocation (for example, when the execution was interrupted and is expected to be resumed later). Plain node implementations such as SimpleAIAgentNodeImpl always return a non-null TOutput.

The result of the execution as TOutput, or null if no output is produced.

- context — The execution context that provides necessary runtime information and functionality.
- input — The input data required to perform the execution.

Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-core/commonMain

```kotlin
val execute: suspend AIAgentGraphContextBase.(input: TInput) -> TOutput
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.entity.SimpleAIAgentNodeImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-a-i-agent-node-impl/index.html`

### :agents:agents-core/commonMain

```kotlin
open class SimpleAIAgentNodeImpl<TInput, TOutput> : AIAgentNodeBase<TInput, TOutput>
```

Represents a simple implementation of an AI agent node within a graph-based structure.

This class facilitates the execution of a computation node, receiving an input of type TInput and producing an output of type TOutput. It is designed to be used within an AI agent graph context.

- TInput — The type of the input data this node accepts.
- TOutput — The type of the output data this node produces.
- AIAgentNode
## ai.koog.agents.core.agent.entity.SimpleAIAgentNodeImpl.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-a-i-agent-node-impl/input-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.SimpleAIAgentNodeImpl.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-a-i-agent-node-impl/name.html`

### :agents:agents-core/commonMain

```kotlin
open override val name: String
```

## ai.koog.agents.core.agent.entity.SimpleAIAgentNodeImpl.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-a-i-agent-node-impl/output-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val outputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.SimpleAction.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-action/execute.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun execute(input: Input): Output
```

Executes the action with the provided input and produces an output.

the result of processing the input

- input — the input value to process
## ai.koog.agents.core.agent.entity.SimpleAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-action/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface SimpleAction<Input, Output>
```

Represents a functional interface designed for performing a simple action that takes an input of type Input and produces an output of type Output.

- Input — The type of the input parameter for the action.
- Output — The type of the output produced by the action.
## ai.koog.agents.core.agent.entity.SimpleCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-condition/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface SimpleCondition<Output>
```

- Output — The type of the input based on which the condition is evaluated.
## ai.koog.agents.core.agent.entity.SimpleCondition.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-condition/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract operator fun invoke(output: Output): Boolean
```

Invokes the condition with the given output object and evaluates whether it satisfies the condition.

true if the given output satisfies the condition, false otherwise.

- output — The output object to be evaluated against the condition.
## ai.koog.agents.core.agent.entity.SimpleTransformation

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-transformation/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface SimpleTransformation<Output, NewOutput>
```

A functional interface representing a transformation operation from a given input type to a new output type.

- Output — The type of the input that the transformation operates on.
- NewOutput — The type of the output produced by the transformation.
## ai.koog.agents.core.agent.entity.SimpleTransformation.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-simple-transformation/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract operator fun invoke(output: Output): NewOutput
```

Transforms the given input of type Output into an instance of type NewOutput.

The transformed output of type NewOutput.

- output — The input to be transformed.
## ai.koog.agents.core.agent.entity.StartNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-start-node/index.html`

### :agents:agents-core/commonMain

```kotlin
class StartNode<TInput> : AIAgentNode<TInput, TInput>
```

Represents the base node for starting a subgraph in an AI agent strategy graph. This node acts as an entry point for executing subgraphs.

This node effectively passes its input as-is to the next node in the execution pipeline, allowing downstream nodes to transform or handle the data further.

The name property of the node reflects a uniquely identifiable pattern using the prefix "start" and the optional subgraph name, enabling traceability of execution flow in multi-subgraph setups.

- subgraphName — The name of the related subgraph
- type — TypeToken representing TInput
- TInput — The type of input data this node processes and produces as output.
## ai.koog.agents.core.agent.entity.SubgraphMetadata.SubgraphMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-metadata/-subgraph-metadata.html`

### :agents:agents-core/commonMain

```kotlin
constructor(nodesMap: Map<String, AIAgentNodeBase<*, *>>, uniqueNames: Boolean = false)
```

## ai.koog.agents.core.agent.entity.SubgraphMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-metadata/index.html`

### :agents:agents-core/commonMain

```kotlin
data class SubgraphMetadata(val nodesMap: Map<String, AIAgentNodeBase<*, *>>, val uniqueNames: Boolean = false)
```

Represents metadata associated with a subgraph in an AI agent strategy graph.

This class holds information about the nodes present in the subgraph and provides insights into the structural uniqueness of node names within the graph. The subgraph is identified by a map of node names to their corresponding AIAgentNodeBase implementations.

## ai.koog.agents.core.agent.entity.SubgraphMetadata.nodesMap

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-metadata/nodes-map.html`

### :agents:agents-core/commonMain

```kotlin
val nodesMap: Map<String, AIAgentNodeBase<*, *>>
```

## ai.koog.agents.core.agent.entity.SubgraphMetadata.uniqueNames

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-metadata/unique-names.html`

### :agents:agents-core/commonMain

```kotlin
val uniqueNames: Boolean
```

## ai.koog.agents.core.agent.entity.SubgraphWithFinishToolBuilder.SubgraphWithFinishToolBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-finish-tool-builder/-subgraph-with-finish-tool-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, finishTool: ERROR CLASS: Symbol not found for Tool<Output, OutputTransformed>, freshHistory: Boolean = false)
```

- Input — The type of the input entity.
- Output — The type of the output entity before transformation.
- OutputTransformed — The type of the output entity after transformation.
## ai.koog.agents.core.agent.entity.SubgraphWithFinishToolBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-finish-tool-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class SubgraphWithFinishToolBuilder<Input : Any, Output : Any, OutputTransformed : Any>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, finishTool: ERROR CLASS: Symbol not found for Tool<Output, OutputTransformed>, freshHistory: Boolean = false)
```

Builder class for constructing a subgraph with a finish tool in a graph strategy.

- Input — The type of the input entity.
- Output — The type of the output entity before transformation.
- OutputTransformed — The type of the output entity after transformation.
## ai.koog.agents.core.agent.entity.SubgraphWithFinishToolBuilder.withTask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-finish-tool-builder/with-task.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withTask(defineTask: ContextualAction<Input, String>): SubgraphWithTaskBuilder<Input, OutputTransformed>
```

Configures a task to be executed as part of the subgraph.

A builder instance for configuring the subgraph with the defined task.

- defineTask — The task defined as a contextual action that takes an input and a graph context, and produces a string output.
### :agents:agents-core/jvmCommonMain

```kotlin
fun withTask(defineTask: SimpleAction<Input, String>): SubgraphWithTaskBuilder<Input, OutputTransformed>
```

Defines a task within the subgraph using the provided task implementation.

A SubgraphWithTaskBuilder instance configured with the specified task.

- defineTask — The task implementation represented by a SimpleAction that takes an input of type Input and returns a String output after task execution.
## ai.koog.agents.core.agent.entity.SubgraphWithTaskBuilder.SubgraphWithTaskBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-task-builder/-subgraph-with-task-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputOption: OutputOption<Output>, defineTask: ContextualAction<Input, String>, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, freshHistory: Boolean = false)
```


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.agent.entity.SubgraphWithTaskBuilder.assistantResponseRepeatMax

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-task-builder/assistant-response-repeat-max.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun assistantResponseRepeatMax(assistantResponseRepeatMax: Int): SubgraphWithTaskBuilder<Input, Output>
```

Sets the maximum number of times the assistant's response can be repeated.

The current instance of SubgraphWithTaskBuilder for method chaining.

- assistantResponseRepeatMax — The maximum number of repeats allowed for the assistant's response.
## ai.koog.agents.core.agent.entity.SubgraphWithTaskBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-task-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun build(): AIAgentSubgraph<Input, Output>
```

Builds and returns an instance of AIAgentSubgraph configured with the specified parameters.

The method creates a subgraph by

## ai.koog.agents.core.agent.entity.SubgraphWithTaskBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-task-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class SubgraphWithTaskBuilder<Input : Any, Output : Any>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputOption: OutputOption<Output>, defineTask: ContextualAction<Input, String>, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, freshHistory: Boolean = false) : TypedAIAgentSubgraphBuilderBase<Input, Output, SubgraphWithTaskBuilder<Input, Output>>
```

A builder class for creating an AI agent subgraph that incorporates task definition as part of its configuration. This builder allows customizing the construction of a subgraph while defining how tasks are specified and executed within the subgraph.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.agent.entity.SubgraphWithTaskBuilder.parallelTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-subgraph-with-task-builder/parallel-tools.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun parallelTools(parallelTools: Boolean): SubgraphWithTaskBuilder<Input, Output>
```

Configures the run mode for

## ai.koog.agents.core.agent.entity.TypedAIAgentNodeBuilder.TypedAIAgentNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-node-builder/-typed-a-i-agent-node-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken, outputTypeToken: ERROR CLASS: Symbol not found for TypeToken)
```

- Input — The type of the input data the node will process.
- Output — The type of the output data the node will produce.
## ai.koog.agents.core.agent.entity.TypedAIAgentNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-node-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class TypedAIAgentNodeBuilder<Input : Any, Output : Any>(name: String?, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken, outputTypeToken: ERROR CLASS: Symbol not found for TypeToken)
```

- Input — The type of the input data the node will process.
- Output — The type of the output data the node will produce.
## ai.koog.agents.core.agent.entity.TypedAIAgentNodeBuilder.withAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-node-builder/with-action.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withAction(nodeAction: ContextualAction<Input, Output>): DefinedAIAgentNodeBuilder<Input, Output>
```

Assigns a contextual action to the node being built, specifying the logic that should be executed when the node processes an input within the AI agent graph context.

A new instance of DefinedAIAgentNodeBuilder configured with the specified contextual action.

- nodeAction — The ContextualAction to execute. This defines how the node processes input and produces the corresponding output within the provided AIAgentGraphContextBase.
## ai.koog.agents.core.agent.entity.TypedAIAgentSubgraphBuilder.TypedAIAgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-subgraph-builder/-typed-a-i-agent-subgraph-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputClass: Class<Output>, freshHistory: Boolean = false)
```

## ai.koog.agents.core.agent.entity.TypedAIAgentSubgraphBuilder.define

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-subgraph-builder/define.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun define(buildSubgraph: GraphBuilderAction<Input, Output>): DefinedAIAgentSubgraphBuilder<Input, Output>
```

Defines an AI Agent subgraph by applying the provided graph building action.

An instance of DefinedAIAgentSubgraphBuilder configured with the specified subgraph logic and type information.

- buildSubgraph — The action that builds and configures the subgraph using a GraphBuilderAction implementation. It allows customizing the graph strategy for the specified input and output types.
## ai.koog.agents.core.agent.entity.TypedAIAgentSubgraphBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-subgraph-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class TypedAIAgentSubgraphBuilder<Input : Any, Output : Any>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputClass: Class<Output>, freshHistory: Boolean = false) : TypedAIAgentSubgraphBuilderBase<Input, Output, TypedAIAgentSubgraphBuilder<Input, Output>>
```

Builder class for creating and configuring a typed AI agent subgraph.

This class facilitates the construction of a subgraph within an AI agent graph strategy by providing methods to define graph structures,

## ai.koog.agents.core.agent.entity.TypedAIAgentSubgraphBuilder.withTask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-subgraph-builder/with-task.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withTask(defineTask: ContextualAction<Input, String>): SubgraphWithTaskBuilder<Input, Output>
```

Configures a task to be executed as part of the subgraph.

A builder instance for configuring the subgraph with the defined task.

- defineTask — The task defined as a contextual action that takes an input and a graph context, and produces a string output.
### :agents:agents-core/jvmCommonMain

```kotlin
fun withTask(defineTask: SimpleAction<Input, String>): SubgraphWithTaskBuilder<Input, Output>
```

Defines a task within the subgraph using the provided task implementation.

A SubgraphWithTaskBuilder instance configured with the specified task.

- defineTask — The task implementation represented by a SimpleAction that takes an input of type Input and returns a String output after task execution.
## ai.koog.agents.core.agent.entity.TypedAIAgentSubgraphBuilderBase.TypedAIAgentSubgraphBuilderBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-subgraph-builder-base/-typed-a-i-agent-subgraph-builder-base.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputOption: OutputOption<Output>, freshHistory: Boolean = false)
```

- Input — The type of the input data handled by the sub

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.agent.entity.TypedAIAgentSubgraphBuilderBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-a-i-agent-subgraph-builder-base/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
abstract class TypedAIAgentSubgraphBuilderBase<Input : Any, Output : Any, SubgraphBuilder : TypedAIAgentSubgraphBuilderBase<Input, Output, SubgraphBuilder>>(name: String?, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, inputClass: Class<Input>, outputOption: OutputOption<Output>, freshHistory: Boolean = false) : AgentSubgraphBuilder<SubgraphBuilder>
```

A base class for constructing a typed AI agent subgraph builder with strongly defined input and output types. This class is designed for creating subgraphs within an AI agent graph structure, enabling the configuration of node interactions, tool usage, and the integration of language models (LLMs).

- Input — The type of the input data handled by the sub
- TypedAIAgentSubgraphBuilder
- DefinedAIAgentSubgraphBuilder
- SubgraphWithTaskBuilder

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.agent.entity.TypedCompressHistoryNodeBuilder.TypedCompressHistoryNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-compress-history-node-builder/-typed-compress-history-node-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(name: String, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken, retrievalModel: ERROR CLASS: Symbol not found for LLModel?? = null, strategy: HistoryCompressionStrategy = HistoryCompressionStrategy.WholeHistory, preserveMemory: Boolean = true)
```

- Input — The type of the input data for the node.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.TypedCompressHistoryNodeBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-compress-history-node-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun build(): AIAgentNode<Input, Input>
```

Builds and returns an instance of AIAgentNodeBase configured for compressing history in the AI agent strategy graph. The resulting node is bound to the current configuration parameters, including the retrieval model, compression strategy, and memory preservation settings.

An AIAgentNodeBase instance responsible for compressing history based on the specified inputs and configuration within the strategy graph.

## ai.koog.agents.core.agent.entity.TypedCompressHistoryNodeBuilder.compressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-compress-history-node-builder/compression-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun compressionStrategy(strategy: HistoryCompressionStrategy): TypedCompressHistoryNodeBuilder<Input>
```

Sets the history compression strategy to be used for this builder.

A new instance of TypedCompressHistoryNodeBuilder with the specified compression strategy.

- strategy — The history compression strategy to apply.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.TypedCompressHistoryNodeBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-compress-history-node-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class TypedCompressHistoryNodeBuilder<Input : Any>(name: String, inputTypeToken: ERROR CLASS: Symbol not found for TypeToken, retrievalModel: ERROR CLASS: Symbol not found for LLModel?? = null, strategy: HistoryCompressionStrategy = HistoryCompressionStrategy.WholeHistory, preserveMemory: Boolean = true)
```

A builder class for configuring and creating a typed compression history node within an AI agent graph.

- Input — The type of the input data for the node.

Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.core.agent.entity.TypedCompressHistoryNodeBuilder.preserveMemory

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-compress-history-node-builder/preserve-memory.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun preserveMemory(preserveMemory: Boolean): TypedCompressHistoryNodeBuilder<Input>
```

Sets whether memory preservation is enabled for the node being built.

This builder instance with the updated memory preservation setting.

- preserveMemory — A boolean indicating whether memory should be preserved.
## ai.koog.agents.core.agent.entity.TypedCompressHistoryNodeBuilder.withRetrievalModel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-compress-history-node-builder/with-retrieval-model.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun withRetrievalModel(model: ERROR CLASS: Symbol not found for LLModel): TypedCompressHistoryNodeBuilder<Input>
```

Configures the node builder with a specific retrieval model.

A new instance of TypedCompressHistoryNodeBuilder with the specified retrieval model configured.

- model — The retrieval model to be used in the configured node. An instance of LLModel representing the model to apply.
## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder.TypedGraphStrategyBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/-typed-graph-strategy-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor(strategyName: String, inputClass: KClass<Input>, outputClass: KClass<Output>, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, builder: AIAgentGraphStrategyBuilder<Input, Output> = AIAgentGraphStrategyBuilder( strategyName, typeToken(inputClass), typeToken(outputClass), toolSelectionStrategy ), edgeBuilders: MutableList<AIAgentGraphStrategyBuilder<Input, Output>.() -> Unit> = mutableListOf())
```

- strategyName — The name of the strategy being built.
- Input — The type of the input entity.
- Output — The type of the output entity.

Referenced packages: `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun build(): AIAgentGraphStrategy<Input, Output>
```

Builds and returns an instance of AIAgentGraphStrategy configured with the specified parameters, input/output types, and edge builders.

The constructed AIAgentGraphStrategy instance.

## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder.edge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/edge.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <IncomingOutput, OutgoingInput> edge(edge: AIAgentEdge<IncomingOutput, OutgoingInput>): TypedGraphStrategyBuilder<Input, Output>
```

Adds an edge to the graph strategy using the provided AIAgentEdge.

An instance of TypedGraphStrategyBuilder with the specified edge added to the strategy.

- edge — The directed edge to be added to the graph strategy. It describes the source and destination nodes, along with the mechanism for handling data transmission between them.
### :agents:agents-core/jvmCommonMain

```kotlin
fun <OutgoingInput, CompatibleOutput : OutgoingInput> edge(from: AIAgentNodeBase<*, CompatibleOutput>, to: AIAgentNodeBase<OutgoingInput, *>): TypedGraphStrategyBuilder<Input, Output>
```

Adds an edge to the graph strategy, connecting two nodes with a compatible data flow between them.

An instance of TypedGraphStrategyBuilder with the specified edge added to the strategy.

- from — The source node of the edge. This node produces output data of a type that must be compatible with the input type expected by the destination node.
- to — The destination node of the edge. This node receives input data from the source node.
## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class TypedGraphStrategyBuilder<Input : Any, Output : Any>(strategyName: String, inputClass: KClass<Input>, outputClass: KClass<Output>, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, builder: AIAgentGraphStrategyBuilder<Input, Output> = AIAgentGraphStrategyBuilder( strategyName, typeToken(inputClass), typeToken(outputClass), toolSelectionStrategy ), edgeBuilders: MutableList<AIAgentGraphStrategyBuilder<Input, Output>.() -> Unit> = mutableListOf())
```

Builder class used for constructing and configuring an AIAgentGraphStrategy.

- strategyName — The name of the strategy being built.
- Input — The type of the input entity.
- Output — The type of the output entity.

Referenced packages: `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder.nodeFinish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/node-finish.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val nodeFinish: FinishNode<Output>
```

Provides access to the "finish" node of the strategy graph being constructed.

This property represents an instance of FinishNode, marking the endpoint of a graph or subgraph within the strategy setup. The finish node directly passes its input to its output without modification and acts as a terminal node by disallowing any outgoing edges.

The nodeFinish property is lazily retrieved from the builder and reflects the finalized configuration of the graph strategy. It serves as a key structural component for defining the completion behavior within the graph execution flow.

The FinishNode that terminates the graph or subgraph.

## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder.nodeStart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/node-start.html`

### :agents:agents-core/jvmCommonMain

```kotlin
val nodeStart: StartNode<Input>
```

Provides access to the starting node of the graph strategy being constructed.

This property represents the entry point of the graph, defined by the underlying StartNode, which serves as the initial node in the strategy. It is primarily used to begin data flow or transformations within the constructed AI agent graph.

The node automatically passes its input data as-is to subsequent nodes, making it suitable as a handoff point for initializing the graph's execution pipeline.

This property is derived from the builder and is essential for defining connections or transitions to other nodes in the graph strategy.

## ai.koog.agents.core.agent.entity.TypedGraphStrategyBuilder.withToolSelectionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-typed-graph-strategy-builder/with-tool-selection-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun withToolSelectionStrategy(strategy: ToolSelectionStrategy): TypedGraphStrategyBuilder<Input, Output>
```

Configures the strategy for selecting tools to be used in the current graph strategy builder.

A new instance of TypedGraphStrategyBuilder with the updated tool selection strategy applied.

- strategy — The tool selection strategy to apply. This specifies how tools are selected or filtered for utilization in the resulting graph strategy. Examples include using all tools, no tools, or a custom subset of tools.
## ai.koog.agents.core.agent.execution.AgentExecutionInfo.AgentExecutionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/-agent-execution-info/-agent-execution-info.html`

### :agents:agents-core/commonMain

```kotlin
constructor(parent: AgentExecutionInfo?, partName: String)
```

## ai.koog.agents.core.agent.execution.AgentExecutionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/-agent-execution-info/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentExecutionInfo(val parent: AgentExecutionInfo?, val partName: String)
```

Represents execution information for an agent, including a reference to a parent execution and a name identifying the specific part of the execution.

## ai.koog.agents.core.agent.execution.AgentExecutionInfo.parent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/-agent-execution-info/parent.html`

### :agents:agents-core/commonMain

```kotlin
val parent: AgentExecutionInfo?
```

## ai.koog.agents.core.agent.execution.AgentExecutionInfo.partName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/-agent-execution-info/part-name.html`

### :agents:agents-core/commonMain

```kotlin
val partName: String
```

## ai.koog.agents.core.agent.execution.AgentExecutionInfo.path

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/-agent-execution-info/path.html`

### :agents:agents-core/commonMain

```kotlin
fun path(separator: String? = null): String
```

Constructs a path string representing the sequence of partName values from the current AgentExecutionInfo instance to the top-most parent, joined by the specified separator.

A string representing the path constructed from partName values.

- separator — The string used to separate each part of the path. If null, a default separator is used.
## ai.koog.agents.core.agent.execution.DEFAULT_AGENT_PATH_SEPARATOR

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/-d-e-f-a-u-l-t_-a-g-e-n-t_-p-a-t-h_-s-e-p-a-r-a-t-o-r.html`

### :agents:agents-core/commonMain

```kotlin
const val DEFAULT_AGENT_PATH_SEPARATOR: String
```

The default separator used to join parts of an agent's execution path.

## ai.koog.agents.core.agent.execution.path

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.execution/path.html`

### :agents:agents-core/commonMain

```kotlin
fun path(vararg parts: String, separator: String = DEFAULT_AGENT_PATH_SEPARATOR): String
```

Joins the given parts into a single path string using the specified separator.

A string representing the joined path.

- parts — The parts to join into a path.
- separator — The separator to use between parts. Defaults to DEFAULT_AGENT_PATH_SEPARATOR.
## ai.koog.agents.core.agent.session.AIAgentRunSession.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-run-session/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun context(): TContext
```

Returns the context for the current AI agent execution session. The context provides access to essential details such as environment, input, execution state, configuration, and other metadata required for the AI agent's operations.

The AIAgentContext instance associated with the current execution session.

## ai.koog.agents.core.agent.session.AIAgentRunSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-run-session/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentRunSession<Input, Output, TContext : AIAgentContext>
```

Represents a session for running an ai.koog.agents.core.agent.AIAgent.

An AIAgentRunSession encapsulates a single execution lifecycle of an AI agent, providing a controlled environment for running the agent's strategy with specific input and context. Each session is independent and manages its own execution state, pipeline coordination, and resource lifecycle.

Sessions are typically created through ai.koog.agents.core.agent.AIAgentBase.createSession and can be reused for multiple sequential executions. The session handles:

Pipeline preparation and feature initialization

Strategy execution with proper error handling

Event notifications at each execution stage

Resource cleanup after execution completes

- Input — the type of input data required by the agent's strategy.
- Output — the type of output data produced by the agent's strategy.
- TContext — the type of context used during execution, extending AIAgentContext.
- AIAgentBase.createSession
- AIAgent

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.session.AIAgentRunSession.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-run-session/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun pipeline(): AIAgentPipeline?
```

Returns the pipeline associated with this session. The pipeline becomes available after the first call to run with a pipeline parameter.

The AI agent pipeline used by this session, or null if no pipeline has been set yet.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.session.AIAgentRunSession.run

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-a-i-agent-run-session/run.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun run(input: Input, sessionInputs: AdditionalInputs = AdditionalInputs.None): Output
```

Executes the agent pipeline with the given context and input, producing an output.

The output produced by the pipeline execution.

- input — The input provided to the pipeline during execution.
- sessionInputs — Optional additional inputs for the session execution.
## ai.koog.agents.core.agent.session.AdditionalInputs.None

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-additional-inputs/-none/index.html`

### :agents:agents-core/commonMain

```kotlin
data object None : AdditionalInputs
```

No additional inputs are provided for the session.

## ai.koog.agents.core.agent.session.AdditionalInputs.Storage.Storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-additional-inputs/-storage/-storage.html`

### :agents:agents-core/commonMain

```kotlin
constructor(storage: AIAgentStorage)
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.session.AdditionalInputs.Storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-additional-inputs/-storage/index.html`

### :agents:agents-core/commonMain

```kotlin
data class Storage(val storage: AIAgentStorage) : AdditionalInputs
```

Pre-populated storage to merge into the session's storage before execution.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.session.AdditionalInputs.Storage.storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-additional-inputs/-storage/storage.html`

### :agents:agents-core/commonMain

```kotlin
val storage: AIAgentStorage
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.session.AdditionalInputs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/-additional-inputs/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed interface AdditionalInputs
```

Additional inputs that can be provided when running an AIAgentRunSession.

This sealed hierarchy is an extensible container for optional parameters that influence session execution beyond the primary input.

- None
- Storage
## ai.koog.agents.core.agent.session.featureOrThrow

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/feature-or-throw.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output, TContext : AIAgentContext, TFeature : Any> AIAgentRunSession<Input, Output, TContext>.featureOrThrow(feature: AIAgentFeature<*, TFeature>): TFeature
```

Retrieves a feature from the AIAgentRunSession.pipeline associated with this session using the specified key or throws an exception if it is not available.

The feature associated with the provided key

- feature — A feature to fetch.
- IllegalStateException — if the TFeature feature does not correspond to a registered feature.
- NoSuchElementException — if the feature is not found.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.feature`.

## ai.koog.agents.core.agent.session.feature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/feature.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output, TContext : AIAgentContext, TFeature : Any> AIAgentRunSession<Input, Output, TContext>.feature(featureClass: KClass<TFeature>, feature: AIAgentFeature<*, TFeature>): TFeature?
```

Retrieves a feature from the AIAgentRunSession.pipeline associated with this session using the specified key.

The feature associated with the provided key, or null if no matching feature is found.

- feature — A feature to fetch.
- featureClass — The KClass of the feature to be retrieved.
- TFeature — A feature implementation type.
- IllegalArgumentException — if the specified featureClass does not correspond to a registered feature.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.feature`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output, TContext : AIAgentContext, TFeature : Any> AIAgentRunSession<Input, Output, TContext>.feature(feature: AIAgentFeature<*, TFeature>): TFeature?
```

Retrieves a feature from the AIAgentRunSession.pipeline associated with this session using the specified key.

The feature associated with the provided key, or null if no matching feature is found.

- feature — A feature to fetch.
- IllegalArgumentException — if the specified feature does not correspond to a registered feature.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.feature`.

## ai.koog.agents.core.agent.session.findToolByNameAndArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.session/find-tool-by-name-and-args.html`

### :agents:agents-core/commonMain

```kotlin
fun <TArgs, TResult> AIAgentLLMWriteSession.findToolByNameAndArgs(toolName: String): ToolBase<TArgs, TResult>
```

Finds and retrieves a tool by its name and argument/result types.

This function looks for a tool in the tool registry by its name and ensures that the tool is compatible with the specified argument and result types. If no matching tool is found, or if the specified types are incompatible, an exception is thrown.

the tool that matches the specified name and types

- toolName — the name of the tool to retrieve
- IllegalArgumentException — if the tool is not defined or the types are incompatible

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.annotation.ExperimentalAgentsApi

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.annotation/-experimental-agents-api/index.html`

### :agents:agents-core/commonMain

```kotlin
annotation class ExperimentalAgentsApi
```

Marks an API as experimental for agent-related implementations.

APIs annotated with ExperimentalAgentsApi are not considered stable and may change, be removed, or have their behavior modified in future updates. This warning is provided to indicate that the use of such APIs requires caution and acknowledgment of potential instability.

Note that no guarantees are made regarding backward compatibility of elements marked with this annotation.

## ai.koog.agents.core.annotation.InternalAgentsApi

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.annotation/-internal-agents-api/index.html`

### :agents:agents-core/commonMain

```kotlin
annotation class InternalAgentsApi
```

Indicates that the annotated API is internal to agent-related implementations and not intended for public use.

Classes, functions, or members marked with this annotation are part of the internal functionality of the AI agents infrastructure and are not guaranteed to maintain backwards compatibility. They are subject to change, removal, or modification without notice.

This annotation is primarily used to signal to developers that the API is not designed for general application development and should only be used with caution in specialized scenarios, such as extending or modifying internal agent behavior.

## ai.koog.agents.core.dsl.builder.AIAgentBuilderDslMarker

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-builder-dsl-marker/index.html`

### :agents:agents-core/commonMain

```kotlin
@DslMarker annotation class AIAgentBuilderDslMarker
```

Indicates that a class or method is part of a DSL for building AI agents.

This annotation functions as a DSL marker to ensure type-safe scoping and to prevent accidental misuse of functions outside their intended context within the AI agent builder DSL.

Applying this annotation helps reduce errors by enforcing constraints on nested DSL blocks, ensuring that certain DSL elements are used only in the correct context.

## ai.koog.agents.core.dsl.builder.AIAgentEdgeBuilderIntermediateBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-edge-builder-intermediate-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentEdgeBuilderIntermediateBase<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Base class for AIAgentEdgeBuilderIntermediate with default implementations.

- AIAgentEdgeBuilderIntermediate
## ai.koog.agents.core.dsl.builder.AIAgentEdgeBuilderIntermediateBase.onCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-edge-builder-intermediate-base/on-condition.html`

### :agents:agents-core/commonMain

```kotlin
infix fun onCondition(block: suspend AIAgentGraphContextBase.(output: IntermediateOutput) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>
```

Filters the intermediate outputs of the ai.koog.agents.core.agent.entity.AIAgentNode based on a specified condition.

A new instance of AIAgentEdgeBuilderIntermediate that includes only the filtered intermediate outputs satisfying the specified condition.

- block — A suspending lambda function that takes the AI agent's context and an intermediate output as parameters. It returns true if the given intermediate output satisfies the condition, and false otherwise.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentEdgeBuilderIntermediateBase.transformed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-edge-builder-intermediate-base/transformed.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <NewIntermediateOutput> transformed(block: suspend AIAgentGraphContextBase.(IntermediateOutput) -> NewIntermediateOutput): AIAgentEdgeBuilderIntermediate<IncomingOutput, NewIntermediateOutput, OutgoingInput>
```

Transforms the intermediate output of the ai.koog.agents.core.agent.entity.AIAgentNode by applying a given transformation block.

A new instance of AIAgentEdgeBuilderIntermediate with the transformed intermediate output type.

- block — A suspending lambda that defines the transformation to be applied to the intermediate output. It takes the AI agent's context and the intermediate output as parameters and returns a new intermediate output.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.AIAgentNodeDelegate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/-a-i-agent-node-delegate.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String?, inputType: TypeToken, outputType: TypeToken, execute: suspend AIAgentGraphContextBase.(Input) -> Output)
```

Initializes the delegate with the provided node name and builder.

- name — The optional name of the node. If not provided, the name will be derived from the property to which the delegate is applied.
- Input — The type of input data the delegated node will process.
- Output — The type of output data the delegated node will produce.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/execute.html`

### :agents:agents-core/commonMain

```kotlin
val execute: suspend AIAgentGraphContextBase.(Input) -> Output
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.getValue

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/get-value.html`

### :agents:agents-core/commonMain

```kotlin
operator fun getValue(thisRef: Any?, property: KProperty<*>): AIAgentNodeBase<Input, Output>
```

Retrieves an instance of AIAgentNodeBase associated with the given property. This operator function acts as a delegate to dynamically provide a reference to an AI agent node.

The instance of AIAgentNodeBase corresponding to the property.

- thisRef — The object on which the property is accessed. This parameter can be null.
- property — The metadata of the property for which this delegate is being used.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/index.html`

### :agents:agents-core/commonMain

```kotlin
open class AIAgentNodeDelegate<Input, Output>(val name: String?, val inputType: TypeToken, val outputType: TypeToken, val execute: suspend AIAgentGraphContextBase.(Input) -> Output)
```

A delegate for creating and managing an instance of AIAgentNodeBase.

This class simplifies the instantiation and management of AI agent nodes. It leverages property delegation to lazily initialize a node instance. The node's name can either be explicitly provided or derived from the delegated property name.

- name — The optional name of the node. If not provided, the name will be derived from the property to which the delegate is applied.
- Input — The type of input data the delegated node will process.
- Output — The type of output data the delegated node will produce.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/name.html`

### :agents:agents-core/commonMain

```kotlin
val name: String?
```

- name — The optional name of the node. If not provided, the name will be derived from the property to which the delegate is applied.
## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/output-type.html`

### :agents:agents-core/commonMain

```kotlin
val outputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate.transform

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-node-delegate/transform.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> transform(noinline transformation: suspend (Output) -> T): AIAgentNodeDelegate<Input, T>
```

Creates a transformed version of this node delegate that applies a transformation to the output.

A new AIAgentNodeDelegate with the transformed output type.

- transformation — A function that transforms the original output to the new type.
- T — The type of the transformed output.
## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.copy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/copy.html`

### :agents:agents-core/commonMain

```kotlin
open override fun copy(environment: AIAgentEnvironment = this.environment, agentId: String = this.agentId, agentInput: Any? = this.agentInput, agentInputType: TypeToken = this.agentInputType, config: AIAgentConfig = this.config, llm: AIAgentLLMContext = this.llm, stateManager: AIAgentStateManager = this.stateManager, storage: AIAgentStorage = this.storage, runId: String = this.runId, strategyName: String = this.strategyName, pipeline: AIAgentGraphPipeline = this.pipeline, executionInfo: AgentExecutionInfo = this.executionInfo, parentContext: AIAgentGraphContextBase? = this): AIAgentGraphContextBase
```

Creates a copy of the current AIAgentContextBase object with the specified parameters.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature.pipeline`, `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphDelegate.getValue

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-delegate/get-value.html`

### :agents:agents-core/commonMain

```kotlin
operator fun getValue(thisRef: Any?, property: KProperty<*>): AIAgentSubgraph<Input, Output>
```

Provides access to an instance of AIAgentSubgraph based on the specified property reference.

This operator function acts as a delegate to dynamically retrieve and return an appropriate instance of AIAgentSubgraph associated with the input and output types specified by the containing context.

An AIAgentSubgraph instance that handles the specified input and output data types.

- thisRef — The reference to the object that contains the delegated property. Can be null if the property is a top-level or package-level property.
- property — The property metadata used to identify the property for which the subgraph instance is being accessed.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphDelegate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-delegate/index.html`

### :agents:agents-core/commonMain

```kotlin
open class AIAgentSubgraphDelegate<Input, Output>
```

A delegate that provides dynamic access to an instance of AIAgentSubgraph. This class facilitates constructing and associating a subgraph with specific start and finish nodes and a defined tool selection strategy upon access.

- Input — The type of input data that the subgraph processes.
- Output — The type of output data that the subgraph produces.
## ai.koog.agents.core.dsl.builder.AIAgentSubgraphDelegate.nodeFinish

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-delegate/node-finish.html`

### :agents:agents-core/commonMain

```kotlin
val nodeFinish: FinishNode<Output>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentSubgraphDelegate.nodeStart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-subgraph-delegate/node-start.html`

### :agents:agents-core/commonMain

```kotlin
val nodeStart: StartNode<Input>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.BaseBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-base-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun build(): T
```

Builds and returns the instance of type T that has been configured using the builder.

The constructed instance of type T.

## ai.koog.agents.core.dsl.builder.BaseBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-base-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
interface BaseBuilder<T>
```

A generic base interface for builders that enables the construction of an object of type T. This interface is typically used in DSL patterns, providing a fluent and structured way to build complex objects.

- T — The type of object that the builder produces.
- AIAgentEdgeBuilder
- AIAgentGraphStrategyBuilder
- AIAgentSubgraphBuilder
## ai.koog.agents.core.dsl.builder.ContextualCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-contextual-condition/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface ContextualCondition<Output>
```

ContextualCondition is a functional interface designed to evaluate a condition based on an output value and the given AI agent graph context.

- Output — The type of the output value that the condition evaluates.
## ai.koog.agents.core.dsl.builder.ContextualCondition.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-contextual-condition/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun invoke(output: Output, context: AIAgentGraphContextBase): Boolean
```

Invokes the contextual condition with the given output and context to evaluate its result.

A boolean value indicating the result of the condition evaluation. Returns true if the condition is met, otherwise false.

- output — The output data passed to the condition for evaluation.
- context — The contextual information required for evaluating the condition, provided as an implementation of the AIAgentGraphContextBase interface.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.ContextualTransformation

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-contextual-transformation/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface ContextualTransformation<Output, NewOutput>
```

A functional interface representing a transformation operation that processes an input output of type Output in the context of AIAgentGraphContextBase and produces a transformed result of type NewOutput.

## ai.koog.agents.core.dsl.builder.ContextualTransformation.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-contextual-transformation/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun invoke(output: Output, context: AIAgentGraphContextBase): NewOutput
```

Transforms the given output using the provided AI agent graph context and returns a new output.

A new output resulting from the transformation.

- output — The original output to be transformed.
- context — The context providing the necessary information and functionality for transformation within the AI agent graph.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.EdgeTransformationDslMarker

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-edge-transformation-dsl-marker/index.html`

### :agents:agents-core/commonMain

```kotlin
@DslMarker @Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION]) annotation class EdgeTransformationDslMarker
```

Marks a function as a transformation specific to edges within the AI agent's DSL to ensure its proper highlighting.

## ai.koog.agents.core.dsl.builder.SimpleCondition

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-simple-condition/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface SimpleCondition<Output>
```

- Output — The type of the input based on which the condition is evaluated.
## ai.koog.agents.core.dsl.builder.SimpleCondition.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-simple-condition/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun invoke(output: Output): Boolean
```

Invokes the condition with the given output object and evaluates whether it satisfies the condition.

true if the given output satisfies the condition, false otherwise.

- output — The output object to be evaluated against the condition.
## ai.koog.agents.core.dsl.builder.SimpleTransformation

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-simple-transformation/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface SimpleTransformation<Output, NewOutput>
```

A functional interface representing a transformation operation from a given input type to a new output type.

- Output — The type of the input that the transformation operates on.
- NewOutput — The type of the output produced by the transformation.
## ai.koog.agents.core.dsl.builder.SimpleTransformation.invoke

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-simple-transformation/invoke.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun invoke(output: Output): NewOutput
```

Transforms the given input of type Output into an instance of type NewOutput.

The transformed output of type NewOutput.

- output — The input to be transformed.
## ai.koog.agents.core.dsl.extension.ChunkedHistoryCompressionStrategy.ChunkedHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-chunked-history-compression-strategy/-chunked-history-compression-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor(chunkSize: Int)
```

## ai.koog.agents.core.dsl.extension.ChunkedHistoryCompressionStrategy.chunkSize

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-chunked-history-compression-strategy/chunk-size.html`

### :agents:agents-core/commonMain

```kotlin
val chunkSize: Int
```

## ai.koog.agents.core.dsl.extension.ChunkedHistoryCompressionStrategy.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-chunked-history-compression-strategy/compress.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Compresses the conversation history into a summarized form (TLDR) using chunked processing.

- llmSession — The session used to interact with the LLM, which maintains the prompt and tool states.
- memoryMessages — A list of memory messages to be retained if preserveMemory is true.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ChunkedHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-chunked-history-compression-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ChunkedHistoryCompressionStrategy(val chunkSize: Int) : HistoryCompressionStrategy
```

A concrete implementation of the HistoryCompressionStrategy that splits the session's prompt into chunks of a predefined size and generates summaries (TL;DR) for each chunk.

This strategy preserves all system messages as well as the first user message (if presented) and memory messages (if provided) and then appends tldr of each chuck of messages from initial history (except trailing tool calls for each chunk).

## ai.koog.agents.core.dsl.extension.Concept.Concept

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-concept/-concept.html`

### :agents:agents-core/commonMain

```kotlin
constructor(keyword: String, description: String, factType: FactType)
```

## ai.koog.agents.core.dsl.extension.Concept.description

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-concept/description.html`

### :agents:agents-core/commonMain

```kotlin
val description: String
```

## ai.koog.agents.core.dsl.extension.Concept.factType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-concept/fact-type.html`

### :agents:agents-core/commonMain

```kotlin
val factType: FactType
```

## ai.koog.agents.core.dsl.extension.Concept

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-concept/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class Concept(val keyword: String, val description: String, val factType: FactType)
```

Represents a distinct piece of knowledge that an agent can remember and recall. Concepts are the fundamental building blocks of the agent's memory system, allowing structured storage and retrieval of information across different contexts and time periods.

Use cases:

Storing project configuration details (dependencies, build settings)

Remembering user preferences and previous interactions

Maintaining environment information (OS, tools, SDKs)

Tracking organizational knowledge and practices

## ai.koog.agents.core.dsl.extension.Concept.keyword

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-concept/keyword.html`

### :agents:agents-core/commonMain

```kotlin
val keyword: String
```

## ai.koog.agents.core.dsl.extension.Fact.concept

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact/concept.html`

### :agents:agents-core/commonMain

```kotlin
abstract val concept: Concept
```

The concept property represents the distinct piece of knowledge associated with this fact.

Each fact is linked to a specific concept, which acts as the central reference point for storing, retrieving, and managing structured information. This allows for organizing and maintaining relationships between individual data points in the memory system.

## ai.koog.agents.core.dsl.extension.Fact

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable sealed interface Fact
```

Represents stored information about a specific concept at a point in time. Facts are the actual data points stored in the memory system, always associated with their originating concept and creation timestamp for temporal reasoning.

- SingleFact
- MultipleFacts
## ai.koog.agents.core.dsl.extension.Fact.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
abstract val timestamp: Long
```

The timestamp indicating when the fact was created or stored, expressed as the number of milliseconds elapsed since the Unix epoch (January 1, 1970, 00:00:00 UTC).

This property is crucial for enabling temporal reasoning within the memory system, allowing the system to associate facts with specific moments in time. It is used for:

Ordering facts chronologically

Supporting time-based queries and operations

Tracking data validity or freshness based on creation time

This value is typically generated using a platform-specific implementation of the TimeProvider interface to ensure precision and consistency across different platforms.

## ai.koog.agents.core.dsl.extension.FactRetrievalHistoryCompressionStrategy.FactRetrievalHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-retrieval-history-compression-strategy/-fact-retrieval-history-compression-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor(concepts: List<Concept>, fallback: HistoryCompressionStrategy = NoCompression)
```

- concepts — A list of Concept objects that define the topics for which facts should be extracted.
- fallback — Strategy used when no facts are extracted for any concept. Defaults to NoCompression.
### :agents:agents-core/commonMain

```kotlin
constructor(vararg concepts: Concept)
```

Secondary constructor for FactRetrievalHistoryCompressionStrategy that initializes the instance with a variable number of Concept objects, converting them into a list.

- concepts — A variable number of Concept objects to be used for fact retrieval.
## ai.koog.agents.core.dsl.extension.FactRetrievalHistoryCompressionStrategy.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-retrieval-history-compression-strategy/compress.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Extracts facts about each configured Concept from the current conversation history and replaces the prompt with a compressed version containing those facts.

- llmSession — The LLM write session used to issue fact-extraction requests and update the prompt.
- memoryMessages — A list of memory messages to be preserved in the compressed prompt.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.FactRetrievalHistoryCompressionStrategy.concepts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-retrieval-history-compression-strategy/concepts.html`

### :agents:agents-core/commonMain

```kotlin
val concepts: List<Concept>
```

- concepts — A list of Concept objects that define the topics for which facts should be extracted.
## ai.koog.agents.core.dsl.extension.FactRetrievalHistoryCompressionStrategy.fallback

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-retrieval-history-compression-strategy/fallback.html`

### :agents:agents-core/commonMain

```kotlin
val fallback: HistoryCompressionStrategy
```

- fallback — Strategy used when no facts are extracted for any concept. Defaults to NoCompression.
## ai.koog.agents.core.dsl.extension.FactRetrievalHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-retrieval-history-compression-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
class FactRetrievalHistoryCompressionStrategy(val concepts: List<Concept>, val fallback: HistoryCompressionStrategy = NoCompression) : HistoryCompressionStrategy
```

A history compression strategy that extracts structured facts about predefined concepts from the current conversation history using an LLM, then replaces the full history with a compact assistant message containing those extracted facts.

For each Concept in concepts, the strategy issues a separate structured LLM request against a snapshot of the current conversation (wrapped in XML tags) to extract either a single fact (FactType.SINGLE) or multiple facts (FactType.MULTIPLE). The original prompt and model are restored after each extraction so that the session state is not mutated.

The resulting compressed prompt contains:

All original system messages

The first user message (if present)

Any provided memoryMessages

A single assistant message with a [CONTEXT RESTORATION] block listing the extracted facts and the approximate number of tool interactions that occurred before compression

If no facts are extracted for any concept, the strategy delegates to fallback (by default NoCompression, which leaves the prompt unchanged). Provide a different strategy (e.g. a TLDR-based one) to guarantee the history still shrinks when no configured concept matched.

- concepts — A list of Concept objects that define the topics for which facts should be extracted.
- fallback — Strategy used when no facts are extracted for any concept. Defaults to NoCompression.
## ai.koog.agents.core.dsl.extension.FactType.MULTIPLE

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-type/-m-u-l-t-i-p-l-e/index.html`

### :agents:agents-core/commonMain

```kotlin
MULTIPLE
```

Used when a concept can have multiple related pieces of information. Example: Project dependencies, coding style rules, or environment variables.

## ai.koog.agents.core.dsl.extension.FactType.SINGLE

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-type/-s-i-n-g-l-e/index.html`

### :agents:agents-core/commonMain

```kotlin
SINGLE
```

Used when a concept should store exactly one piece of information. Example: Current project's primary programming language or build system type.

## ai.koog.agents.core.dsl.extension.FactType.entries

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-type/entries.html`

### :agents:agents-core/commonMain

```kotlin
val entries: EnumEntries<FactType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.core.dsl.extension.FactType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-type/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable enum FactType : Enum<FactType>
```

Defines how information should be stored and retrieved for a concept in the memory system. This type system helps organize and structure the knowledge representation in the agent's memory.

## ai.koog.agents.core.dsl.extension.FactType.valueOf

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-type/value-of.html`

### :agents:agents-core/commonMain

```kotlin
fun valueOf(value: String): FactType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.core.dsl.extension.FactType.values

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-fact-type/values.html`

### :agents:agents-core/commonMain

```kotlin
fun values(): Array<FactType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.core.dsl.extension.FromTimestampHistoryCompressionStrategy.FromTimestampHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-timestamp-history-compression-strategy/-from-timestamp-history-compression-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor(timestamp: Instant)
```

- timestamp — The timestamp indicating the earliest point to retain messages from.
## ai.koog.agents.core.dsl.extension.FromTimestampHistoryCompressionStrategy.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-timestamp-history-compression-strategy/compress.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Compresses the conversation history by retaining the messages from the timestamp, generating a summary, and composing the resulting prompt with the necessary messages.

- llmSession — The session used for writing and managing the large language model's state.
- memoryMessages — The list of memory messages that should be used or referenced during compression.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.FromTimestampHistoryCompressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-timestamp-history-compression-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
data class FromTimestampHistoryCompressionStrategy(val timestamp: Instant) : HistoryCompressionStrategy
```

A strategy for compressing message histories using a specified timestamp as a reference point. This strategy removes messages that occurred before a given timestamp and creates a summarized context for further interactions.

This strategy preserves all system messages as well as the first user message (if presented) and memory messages (if provided) and then appends tldr of the subset of messages starting from the provided timestamp (except trailing tool calls).

- timestamp — The timestamp indicating the earliest point to retain messages from.
## ai.koog.agents.core.dsl.extension.FromTimestampHistoryCompressionStrategy.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-from-timestamp-history-compression-strategy/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
val timestamp: Instant
```

- timestamp — The timestamp indicating the earliest point to retain messages from.
## ai.koog.agents.core.dsl.extension.ModeratedMessage.ModeratedMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-moderated-message/-moderated-message.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: Message, moderationResult: ModerationResult)
```


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ModeratedMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-moderated-message/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ModeratedMessage(val message: Message, val moderationResult: ModerationResult)
```

Represents a message that has undergone moderation and the result of the moderation.


Referenced packages: `ai.koog.prompt.dsl`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ModeratedMessage.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-moderated-message/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: Message
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ModeratedMessage.moderationResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-moderated-message/moderation-result.html`

### :agents:agents-core/commonMain

```kotlin
val moderationResult: ModerationResult
```


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.core.dsl.extension.MultipleFacts.MultipleFacts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-multiple-facts/-multiple-facts.html`

### :agents:agents-core/commonMain

```kotlin
constructor(concept: Concept, timestamp: Long, values: List<String>)
```

## ai.koog.agents.core.dsl.extension.MultipleFacts.concept

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-multiple-facts/concept.html`

### :agents:agents-core/commonMain

```kotlin
open override val concept: Concept
```

The concept property represents the distinct piece of knowledge associated with this fact.

Each fact is linked to a specific concept, which acts as the central reference point for storing, retrieving, and managing structured information. This allows for organizing and maintaining relationships between individual data points in the memory system.

## ai.koog.agents.core.dsl.extension.MultipleFacts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-multiple-facts/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class MultipleFacts(val concept: Concept, val timestamp: Long, val values: List<String>) : Fact
```

Stores multiple related pieces of information about a concept. Used when the concept represents a collection of related facts that should be stored and retrieved together.

Example: List of project dependencies, coding style rules, or environment variables

## ai.koog.agents.core.dsl.extension.MultipleFacts.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-multiple-facts/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

The timestamp indicating when the fact was created or stored, expressed as the number of milliseconds elapsed since the Unix epoch (January 1, 1970, 00:00:00 UTC).

This property is crucial for enabling temporal reasoning within the memory system, allowing the system to associate facts with specific moments in time. It is used for:

Ordering facts chronologically

Supporting time-based queries and operations

Tracking data validity or freshness based on creation time

This value is typically generated using a platform-specific implementation of the TimeProvider interface to ensure precision and consistency across different platforms.

## ai.koog.agents.core.dsl.extension.MultipleFacts.values

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-multiple-facts/values.html`

### :agents:agents-core/commonMain

```kotlin
val values: List<String>
```

## ai.koog.agents.core.dsl.extension.SingleFact.SingleFact

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-single-fact/-single-fact.html`

### :agents:agents-core/commonMain

```kotlin
constructor(concept: Concept, timestamp: Long, value: String)
```

## ai.koog.agents.core.dsl.extension.SingleFact.concept

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-single-fact/concept.html`

### :agents:agents-core/commonMain

```kotlin
open override val concept: Concept
```

The concept property represents the distinct piece of knowledge associated with this fact.

Each fact is linked to a specific concept, which acts as the central reference point for storing, retrieving, and managing structured information. This allows for organizing and maintaining relationships between individual data points in the memory system.

## ai.koog.agents.core.dsl.extension.SingleFact

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-single-fact/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class SingleFact(val concept: Concept, val timestamp: Long, val value: String) : Fact
```

Stores a single piece of information about a concept. Used when the concept represents a singular, atomic piece of knowledge that doesn't need to be broken down into multiple components.

Example: "The project uses Gradle as its build system"

## ai.koog.agents.core.dsl.extension.SingleFact.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-single-fact/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

The timestamp indicating when the fact was created or stored, expressed as the number of milliseconds elapsed since the Unix epoch (January 1, 1970, 00:00:00 UTC).

This property is crucial for enabling temporal reasoning within the memory system, allowing the system to associate facts with specific moments in time. It is used for:

Ordering facts chronologically

Supporting time-based queries and operations

Tracking data validity or freshness based on creation time

This value is typically generated using a platform-specific implementation of the TimeProvider interface to ensure precision and consistency across different platforms.

## ai.koog.agents.core.dsl.extension.SingleFact.value

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-single-fact/value.html`

### :agents:agents-core/commonMain

```kotlin
val value: String
```

## ai.koog.agents.core.dsl.extension.ToolResults.ToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-tool-results/-tool-results.html`

### :agents:agents-core/commonMain

```kotlin
constructor(toolCalls: List<MessagePart.Tool.Result>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ToolResults

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-tool-results/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ToolResults(val toolCalls: List<MessagePart.Tool.Result>)
```

Wraps a list of tool results ready to be sent back to the LLM.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.ToolResults.toolCalls

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-tool-results/tool-calls.html`

### :agents:agents-core/commonMain

```kotlin
val toolCalls: List<MessagePart.Tool.Result>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.WholeCompressionStrategyWithMultipleSystemMessages.compress

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-whole-compression-strategy-with-multiple-system-messages/compress.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun compress(llmSession: AIAgentLLMWriteSession, memoryMessages: List<Message>)
```

Compresses and adjusts the prompt for the agent's write session by summarizing and incorporating memory messages optionally.

- llmSession — The current session of the agent which allows prompt manipulation and sending requests.
- memoryMessages — A list of memory messages to be optionally preserved and included in the prompt.

Referenced packages: `ai.koog.agents.core.agent.session`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.WholeCompressionStrategyWithMultipleSystemMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/-whole-compression-strategy-with-multiple-system-messages/index.html`

### :agents:agents-core/commonMain

```kotlin
object WholeCompressionStrategyWithMultipleSystemMessages : HistoryCompressionStrategy
```

WholeCompressionStrategyWithMultipleSystemMessages is a concrete implementation of the HistoryCompressionStrategy that handles scenarios where the conversation history contains multiple system messages.

This strategy:

Splits the history into blocks based on system message boundaries

Processes each block separately to generate TL;DR summaries

Maintains the chronological order of system messages while compressing the conversation

Preserves memory messages only in the first block to maintain context

System1, User1, Assistant, ToolCall, ToolResult, System2, User2, Assistant, User3, System3, Assistant, System4 ->System1, User1, Memory, TLDR(System1, User1, Assistant, ToolCall, ToolResult), System2, User2, TLDR(System2, User2, Assistant, User3), System3, Assistant, TLDR(System3, Assistant) System4, TLDR(System4)

## ai.koog.agents.core.dsl.extension.appendPromptImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/append-prompt-impl.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> AIAgentGraphContextBase.appendPromptImpl(input: T, body: PromptBuilder.() -> Unit): T
```

InternalAgentsApi method. Appends a prompt to the current LLM session.

The same input object, allowing for fluent usage patterns or further chaining.

- input — The input object to be used for the operation. It serves as both input and output of this method.
- body — A lambda to customize the construction of the prompt using the PromptBuilder.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.dsl`.

## ai.koog.agents.core.dsl.extension.asToolResultMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/as-tool-result-message.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <IncomingOutput, IntermediateOutput, OutgoingInput> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.asToolResultMessage(filter: suspend (ReceivedToolResult) -> Boolean): AIAgentEdgeBuilderIntermediate<IncomingOutput, Message.User, OutgoingInput>
```

Applies a transformation to the intermediate output of the edge builder and filters the received tool results based on the provided condition. This function is used to handle tool results as a part of the AI agent's edge flow within the DSL.

A new instance of AIAgentEdgeBuilderIntermediate with the intermediate output type set to ReceivedToolResults, representing a collection of filtered tool results.

- filter — A suspending lambda function that determines whether a given ReceivedToolResult should be included in the transformation process. The function takes a ReceivedToolResult as input and returns a Boolean indicating whether the result satisfies the filter condition.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.asUserMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/as-user-message.html`

### :agents:agents-core/commonMain

```kotlin
infix fun <IncomingOutput, IntermediateOutput, OutgoingInput> AIAgentEdgeBuilderIntermediate<IncomingOutput, IntermediateOutput, OutgoingInput>.asUserMessage(transform: suspend (IntermediateOutput) -> String): AIAgentEdgeBuilderIntermediate<IncomingOutput, Message.User, OutgoingInput>
```

Creates an edge that transforms an intermediate output into a Message.User using the provided transform.

- transform — A function that converts the intermediate output to a String for the user message.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.executeSingleToolImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/execute-single-tool-impl.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <TResult, ToolArg> AIAgentGraphContextBase.executeSingleToolImpl(tool: Tool<ToolArg, TResult>, toolArgs: ToolArg, doAppendPrompt: Boolean): SafeTool.Result<TResult>
```

InternalAgentsApi method. Executes a single tool with the provided arguments and returns the result.

A SafeTool.Result containing the result of the tool execution.

- toolArgs — The arguments to be passed to the tool during execution.
- doAppendPrompt — Indicates whether to append prompts to the LLM session for the tool call and its result.
- tool — The tool to be invoked, containing the logic for processing the input arguments and producing the result.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.environment`, `ai.koog.agents.core.tools`.

## ai.koog.agents.core.dsl.extension.llmCompressHistoryImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/llm-compress-history-impl.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> AIAgentGraphContextBase.llmCompressHistoryImpl(input: T, retrievalModel: LLModel?, strategy: HistoryCompressionStrategy, preserveMemory: Boolean): T
```

InternalAgentsApi method. Performs LLM history compression.

The input of type T, passed through without modifications.

- retrievalModel — The optional LLModel to be used temporarily for retrieval during history compression.
- strategy — The HistoryCompressionStrategy to be applied to compress the conversation history.
- preserveMemory — A flag indicating whether memory should be preserved, preventing permanent loss of history.
- input — The input of type T that will be passed through and returned unchanged by the method.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.dsl.extension.nodeLLMModerateMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-moderate-message.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMModerateMessage(name: String? = null, moderatingModel: LLModel? = null, includeCurrentPrompt: Boolean = false): AIAgentNodeDelegate<Message, ModeratedMessage>
```

A node that runs content moderation on an incoming Message using the LLM.

- name — Optional node name, defaults to delegate's property name.
- moderatingModel — An optional LLModel to use for moderation; defaults to the agent's current model.
- includeCurrentPrompt — If true, the full current prompt context is included alongside the message when running moderation; otherwise only the single message is sent.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMModerateText

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-moderate-text.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMModerateText(name: String? = null, moderatingModel: LLModel? = null, includeCurrentPrompt: Boolean = false): AIAgentNodeDelegate<String, ModeratedMessage>
```

A node that runs content moderation on an incoming text using the LLM.

- name — Optional node name, defaults to delegate's property name.
- moderatingModel — An optional LLModel to use for moderation; defaults to the agent's current model.
- includeCurrentPrompt — If true, the full current prompt context is included alongside the message when running moderation; otherwise only the single message is sent.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.dsl.extension.nodeLLMRequestMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-request-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMRequestMultipleChoices(name: String? = null): AIAgentNodeDelegate<String, LLMChoice>
```

A node that appends a user text message to the prompt and requests multiple completion choices from the LLM, returning them as an LLMChoice.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessageForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendMessageForceOneTool(name: String? = null, tool: ToolDescriptor): AIAgentNodeDelegate<Message.User, Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, forcing it to call exactly the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The descriptor of the tool the LLM must call.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessageMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendMessageMultipleChoices(name: String? = null): AIAgentNodeDelegate<Message.User, LLMChoice>
```

A node that appends a Message.User to the prompt and requests multiple completion choices from the LLM, returning them as an LLMChoice.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessageOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendMessageOnlyCallingTools(name: String? = null): AIAgentNodeDelegate<Message.User, Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, forcing it to call one of the available tools (no plain-text replies allowed).

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessageStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message-streaming.html`

### :agents:agents-core/commonMain

```kotlin
fun <T> nodeLLMSendMessageStreaming(name: String? = null, structureDefinition: StructureDefinition? = null, transformStreamData: suspend (Flow<StreamFrame>) -> Flow<T>): AIAgentNodeDelegate<Message.User, Flow<T>>
```

A node that appends a Message.User to the prompt and requests a streaming response from the LLM, applying transformStreamData to convert the raw StreamFrame flow into a flow of T.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — An optional structure definition to guide the streaming response format.
- transformStreamData — A suspend function that transforms the StreamFrame flow into a Flow of T.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`, `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendMessageStreaming(name: String? = null, structureDefinition: StructureDefinition? = null): AIAgentNodeDelegate<Message.User, Flow<StreamFrame>>
```

A node that appends a Message.User to the prompt and requests a streaming response from the LLM, returning raw StreamFrame elements.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — An optional structure definition to guide the streaming response format.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`, `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendMessageWithoutTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-message-without-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendMessageWithoutTools(name: String? = null): AIAgentNodeDelegate<Message.User, Message.Assistant>
```

A node that appends a Message.User to the prompt and requests a response from the LLM, without exposing any tools (pure text response only).

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendToolResultsForceOneTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-tool-results-force-one-tool.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendToolResultsForceOneTool(name: String? = null, tool: ToolDescriptor): AIAgentNodeDelegate<ReceivedToolResults, Message.Assistant>
```

A node that appends tool results from ReceivedToolResults to the prompt as a user message and requests a follow-up response from the LLM, forcing it to call exactly the specified tool.

- name — Optional node name, defaults to delegate's property name.
- tool — The descriptor of the tool the LLM must call.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendToolResultsMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-tool-results-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendToolResultsMultipleChoices(name: String? = null): AIAgentNodeDelegate<ReceivedToolResults, LLMChoice>
```

A node that appends tool results from ReceivedToolResults to the prompt as a user message and requests multiple completion choices from the LLM, returning them as an LLMChoice.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendToolResultsOnlyCallingTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-tool-results-only-calling-tools.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendToolResultsOnlyCallingTools(name: String? = null): AIAgentNodeDelegate<ReceivedToolResults, Message.Assistant>
```

A node that appends tool results from ReceivedToolResults to the prompt as a user message and requests a follow-up response from the LLM, forcing it to call one of the available tools.

- name — Optional node name, defaults to delegate's property name.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.

## ai.koog.agents.core.dsl.extension.nodeLLMSendToolResultsStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/node-l-l-m-send-tool-results-streaming.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendToolResultsStreaming(name: String? = null, structureDefinition: StructureDefinition? = null): AIAgentNodeDelegate<ReceivedToolResults, Flow<StreamFrame>>
```

A node that appends tool results to the prompt and requests a streaming response from the LLM, returning raw StreamFrame elements.

- name — Optional node name, defaults to delegate's property name.
- structureDefinition — An optional structure definition to guide the streaming response format.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.requestStreamingImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/request-streaming-impl.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> AIAgentGraphContextBase.requestStreamingImpl(input: String, structureDefinition: StructureDefinition? = null, transformStreamData: suspend (Flow<StreamFrame>) -> Flow<T>): Flow<T>
```

InternalAgentsApi method. Appends a Message.User with given text to the prompt and requests a streaming response from the LLM.

A Flow of T produced by the streaming LLM response after transformation.

- input — The user message to append to the prompt.
- structureDefinition — An optional structure definition to customize the streaming response.
- transformStreamData — A suspend function that transforms the incoming StreamFrame flow into a flow of type T.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.streaming`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.dsl.extension.setStructuredOutputImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.extension/set-structured-output-impl.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T, TInput> AIAgentGraphContextBase.setStructuredOutputImpl(config: StructuredRequestConfig<T>, message: TInput): TInput
```

InternalAgentsApi method. Sets up structured output for an AI agent subgraph.

The input message after processing.

- config — The configuration used to update the agent's prompt in the context.
- message — The input message to be processed and returned.
- T — The type of the structured output.
- TInput — The type of the input message.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.structure`.

## ai.koog.agents.core.environment.AIAgentEnvironment.executeTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-a-i-agent-environment/execute-tool.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun executeTool(toolCall: MessagePart.Tool.Call): ReceivedToolResult
```

Executes a tool call and returns its result.

A result corresponding to the executed tool call. The result includes details such as the tool name, identifier, response content, and associated metadata.

- toolCall — A tool call messages to be executed. A message contains details about the tool, its identifier, the request content, and associated metadata.

Referenced packages: `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
open suspend fun executeTool(toolCall: MessagePart.Tool.Call, metadata: ToolCallMetadata): ReceivedToolResult
```

Executes a tool call with caller-supplied metadata and returns its result.

metadata is an additive side channel that travels alongside the call (e.g. a trace span id, a correlation id); it is not embedded in MessagePart.Tool.Call and is not serialized to the LLM.

The default implementation delegates to the single-argument executeTool overload and discards metadata, so existing environment implementations remain source-compatible. A custom environment that overrides only that single-argument overload inherits this default and silently drops any metadata supplied here; override this overload to propagate metadata to ai.koog.agents.core.tools.Tool.execute.

A result corresponding to the executed tool call.

- toolCall — The tool call to execute.
- metadata — Caller- and feature-contributed per-call context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.environment.AIAgentEnvironment.executeTools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-a-i-agent-environment/execute-tools.html`

### :agents:agents-core/commonMain

```kotlin
open suspend fun executeTools(toolCalls: List<MessagePart.Tool.Call>): List<ReceivedToolResult>
```

Executes a batch of tool calls within the AI agent environment and processes their results.

This method takes a list of tool call messages, processes them by sending appropriate requests to the underlying environment, and returns a list of results corresponding to the tool calls.

A list of results corresponding to the executed tool calls. Each result includes details such as the tool name, identifier, response content, and metadata.

- toolCalls — A list of tool call messages to be executed. Each message contains details about the tool, its identifier, the request content, and associated metadata.

Referenced packages: `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
open suspend fun executeTools(toolCalls: List<MessagePart.Tool.Call>, metadata: ToolCallMetadata): List<ReceivedToolResult>
```

Executes a batch of tool calls with shared caller-supplied metadata and returns their results.

The same metadata is passed to every call in the batch.

A list of results corresponding to the executed tool calls.

- toolCalls — A list of tool call messages to be executed.
- metadata — Caller- and feature-contributed per-call context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.environment.AIAgentEnvironment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-a-i-agent-environment/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentEnvironment
```

AIAgentEnvironment provides a mechanism for AI agents to interface with an external environment. It offers methods for tool execution, error reporting, and sending termination messages.

- ContextualAgentEnvironment
- GenericAgentEnvironment
## ai.koog.agents.core.environment.AIAgentEnvironment.reportProblem

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-a-i-agent-environment/report-problem.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun reportProblem(exception: Throwable)
```

Reports a problem that occurred within the environment.

This method is used to handle exceptions or other issues encountered during the execution of operations within the AI agent environment. The provided exception describes the nature of the problem.

- exception — The exception representing the problem to report.
## ai.koog.agents.core.environment.ContextualAgentEnvironment.ContextualAgentEnvironment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-contextual-agent-environment/-contextual-agent-environment.html`

### :agents:agents-core/commonMain

```kotlin
constructor(environment: AIAgentEnvironment, context: AIAgentContext)
```

Constructs a new instance of ContextualAgentEnvironment with a decorated environment and a contextual context.

- environment — The underlying agent environment responsible for managing tool execution.
- context — The context that augments the environment with additional behavioral and execution information.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.environment.ContextualAgentEnvironment.executeTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-contextual-agent-environment/execute-tool.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun executeTool(toolCall: MessagePart.Tool.Call): ReceivedToolResult
```

Executes a tool call and returns its result.

A result corresponding to the executed tool call. The result includes details such as the tool name, identifier, response content, and associated metadata.

- toolCall — A tool call messages to be executed. A message contains details about the tool, its identifier, the request content, and associated metadata.

Referenced packages: `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
open suspend override fun executeTool(toolCall: MessagePart.Tool.Call, metadata: ToolCallMetadata): ReceivedToolResult
```

Executes a tool call with caller-supplied metadata and returns its result.

metadata is an additive side channel that travels alongside the call (e.g. a trace span id, a correlation id); it is not embedded in MessagePart.Tool.Call and is not serialized to the LLM.

The default implementation delegates to the single-argument executeTool overload and discards metadata, so existing environment implementations remain source-compatible. A custom environment that overrides only that single-argument overload inherits this default and silently drops any metadata supplied here; override this overload to propagate metadata to ai.koog.agents.core.tools.Tool.execute.

A result corresponding to the executed tool call.

- toolCall — The tool call to execute.
- metadata — Caller- and feature-contributed per-call context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.environment.ContextualAgentEnvironment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-contextual-agent-environment/index.html`

### :agents:agents-core/commonMain

```kotlin
class ContextualAgentEnvironment(environment: AIAgentEnvironment, context: AIAgentContext) : AIAgentEnvironment
```

Represents an AI agent environment that operates within the context of a specific agent framework.

This class acts as a decorator over an existing AIAgentEnvironment, augmenting operations with contextual processing using the provided AIAgentContext.

Metadata handling: when executeTool is called with a ToolCallMetadata argument, this environment collects metadata contributions from every feature that registered a handler via ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.provideToolCallMetadata and merges them with the caller-supplied metadata. On key collision, the caller's value wins, so an explicit call-site override is never silently replaced by a feature contribution. After the merge, the framework injects the live AIAgentContext under AgentContextAwareTool.AgentContextKey; the framework's value always wins over caller and feature entries so a tool always observes the real context driving the current call. The merged metadata is then passed to the wrapped environment, which threads it into ai.koog.agents.core.tools.ToolBase.execute.

- environment — The underlying agent environment responsible for managing tool execution.
- context — The context that augments the environment with additional behavioral and execution information.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.environment.ContextualAgentEnvironment.reportProblem

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-contextual-agent-environment/report-problem.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun reportProblem(exception: Throwable)
```

Reports a problem that occurred within the environment.

This method is used to handle exceptions or other issues encountered during the execution of operations within the AI agent environment. The provided exception describes the nature of the problem.

- exception — The exception representing the problem to report.
## ai.koog.agents.core.environment.GenericAgentEnvironment.GenericAgentEnvironment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-generic-agent-environment/-generic-agent-environment.html`

### :agents:agents-core/commonMain

```kotlin
constructor(agentId: String, logger: KLogger, toolRegistry: ToolRegistry, serializer: JSONSerializer)
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.environment.GenericAgentEnvironment.executeTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-generic-agent-environment/execute-tool.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun executeTool(toolCall: MessagePart.Tool.Call): ReceivedToolResult
```

Executes a tool call and returns its result.

A result corresponding to the executed tool call. The result includes details such as the tool name, identifier, response content, and associated metadata.

- toolCall — A tool call messages to be executed. A message contains details about the tool, its identifier, the request content, and associated metadata.

Referenced packages: `ai.koog.prompt.message`.

### :agents:agents-core/commonMain

```kotlin
open suspend override fun executeTool(toolCall: MessagePart.Tool.Call, metadata: ToolCallMetadata): ReceivedToolResult
```

Executes a tool call with caller-supplied metadata and returns its result.

metadata is an additive side channel that travels alongside the call (e.g. a trace span id, a correlation id); it is not embedded in MessagePart.Tool.Call and is not serialized to the LLM.

The default implementation delegates to the single-argument executeTool overload and discards metadata, so existing environment implementations remain source-compatible. A custom environment that overrides only that single-argument overload inherits this default and silently drops any metadata supplied here; override this overload to propagate metadata to ai.koog.agents.core.tools.Tool.execute.

A result corresponding to the executed tool call.

- toolCall — The tool call to execute.
- metadata — Caller- and feature-contributed per-call context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.message`.

## ai.koog.agents.core.environment.GenericAgentEnvironment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-generic-agent-environment/index.html`

### :agents:agents-core/commonMain

```kotlin
class GenericAgentEnvironment(agentId: String, logger: KLogger, toolRegistry: ToolRegistry, serializer: JSONSerializer) : AIAgentEnvironment
```

Represents base agent environment with generic abstractions.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.environment.GenericAgentEnvironment.reportProblem

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-generic-agent-environment/report-problem.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun reportProblem(exception: Throwable)
```

Reports a problem that occurred within the environment.

This method is used to handle exceptions or other issues encountered during the execution of operations within the AI agent environment. The provided exception describes the nature of the problem.

- exception — The exception representing the problem to report.
## ai.koog.agents.core.environment.ReceivedToolResult.ReceivedToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/-received-tool-result.html`

### :agents:agents-core/commonMain

```kotlin
constructor(id: String?, tool: String, toolArgs: JSONObject, toolDescription: String?, output: String, resultKind: ToolResultKind, result: JSONElement?, resultObject: Any? = null, parts: List<MessagePart.ContentPart>? = null)
```


Referenced packages: `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.agents.core.environment.ReceivedToolResult.id

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/id.html`

### :agents:agents-core/commonMain

```kotlin
val id: String?
```

## ai.koog.agents.core.environment.ReceivedToolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ReceivedToolResult(val id: String?, val tool: String, val toolArgs: JSONObject, val toolDescription: String?, val output: String, val resultKind: ToolResultKind, val result: JSONElement?, val resultObject: Any? = null, val parts: List<MessagePart.ContentPart>? = null)
```

Represents the result or response received from a tool operation.


Referenced packages: `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.agents.core.environment.ReceivedToolResult.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: String
```

## ai.koog.agents.core.environment.ReceivedToolResult.parts

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/parts.html`

### :agents:agents-core/commonMain

```kotlin
val parts: List<MessagePart.ContentPart>?
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.environment.ReceivedToolResult.resultKind

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/result-kind.html`

### :agents:agents-core/commonMain

```kotlin
val resultKind: ToolResultKind
```

## ai.koog.agents.core.environment.ReceivedToolResult.resultObject

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/result-object.html`

### :agents:agents-core/commonMain

```kotlin
@Transient val resultObject: Any?
```

## ai.koog.agents.core.environment.ReceivedToolResult.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.environment.ReceivedToolResult.toMessagePart

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/to-message-part.html`

### :agents:agents-core/commonMain

```kotlin
fun toMessagePart(): MessagePart.Tool.Result
```

Converts the current ReceivedToolResult instance into a MessagePart.Tool.Result object.

A MessagePart.Tool.Result instance representing the tool result with the current data and metadata.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.environment.ReceivedToolResult.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
val toolArgs: JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.environment.ReceivedToolResult.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
val toolDescription: String?
```

## ai.koog.agents.core.environment.ReceivedToolResult.tool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-received-tool-result/tool.html`

### :agents:agents-core/commonMain

```kotlin
val tool: String
```

## ai.koog.agents.core.environment.SafeTool.Result.Failure.Failure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-failure/-failure.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String)
```

- TResult — The type of the tool result.
## ai.koog.agents.core.environment.SafeTool.Result.Failure.content

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-failure/content.html`

### :agents:agents-core/commonMain

```kotlin
open override val content: String
```

Content of the result

In the Success case, this corresponds to the provided content of the successful result.

In the ]Failure] case, this corresponds to the failure message.

## ai.koog.agents.core.environment.SafeTool.Result.Failure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-failure/index.html`

### :agents:agents-core/commonMain

```kotlin
data class Failure<TResult>(val message: String) : SafeTool.Result<TResult>
```

Represents a failed result encapsulating an error message.

- TResult — The type of the tool result.
## ai.koog.agents.core.environment.SafeTool.Result.Failure.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-failure/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String
```

## ai.koog.agents.core.environment.SafeTool.Result.Success.Success

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-success/-success.html`

### :agents:agents-core/commonMain

```kotlin
constructor(result: TResult, content: String)
```

- TResult — The type of the tool result.
## ai.koog.agents.core.environment.SafeTool.Result.Success.content

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-success/content.html`

### :agents:agents-core/commonMain

```kotlin
open override val content: String
```

## ai.koog.agents.core.environment.SafeTool.Result.Success

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-success/index.html`

### :agents:agents-core/commonMain

```kotlin
data class Success<TResult>(val result: TResult, val content: String) : SafeTool.Result<TResult>
```

Represents a successful result of an operation, wrapping a specific tool result and its corresponding content.

- TResult — The type of the tool result.
## ai.koog.agents.core.environment.SafeTool.Result.Success.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/-success/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: TResult
```

## ai.koog.agents.core.environment.SafeTool.Result.asFailure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/as-failure.html`

### :agents:agents-core/commonMain

```kotlin
open fun asFailure(): SafeTool.Result.Failure<TResult>
```

Casts the current object to a Failure type.

This function assumes that the calling instance is of type Failure<TResult>. Use it to retrieve the object as a Failure and access its specific properties and behaviors.

The current instance cast to Failure<TResult>.

- IllegalStateException — if not Failure
## ai.koog.agents.core.environment.SafeTool.Result.asSuccessful

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/as-successful.html`

### :agents:agents-core/commonMain

```kotlin
open fun asSuccessful(): SafeTool.Result.Success<TResult>
```

Casts the current instance of Result to a Success type if it is a successful result.

The current instance cast to Success<TResult>.

- IllegalStateException — if not Success
## ai.koog.agents.core.environment.SafeTool.Result.content

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/content.html`

### :agents:agents-core/commonMain

```kotlin
abstract val content: String
```

Content of the result

In the Success case, this corresponds to the provided content of the successful result.

In the ]Failure] case, this corresponds to the failure message.

## ai.koog.agents.core.environment.SafeTool.Result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed interface Result<TResult>
```

Represents a sealed interface for results, which can either be a success or a failure.

- TResult — The type of the result
- Success
- Failure
## ai.koog.agents.core.environment.SafeTool.Result.isFailure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/is-failure.html`

### :agents:agents-core/commonMain

```kotlin
open fun isFailure(): Boolean
```

Determines whether the current instance represents a failure state.

true if the current instance is of type Failure, otherwise false.

## ai.koog.agents.core.environment.SafeTool.Result.isSuccessful

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-result/is-successful.html`

### :agents:agents-core/commonMain

```kotlin
open fun isSuccessful(): Boolean
```

Determines if the current result represents a successful operation.

true if the result is an instance of Success, otherwise false.

## ai.koog.agents.core.environment.SafeTool.SafeTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/-safe-tool.html`

### :agents:agents-core/commonMain

```kotlin
constructor(tool: ToolBase<TArgs, TResult>, environment: AIAgentEnvironment, clock: KoogClock)
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.environment.SafeTool.executeUnsafe

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/execute-unsafe.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun executeUnsafe(args: Any?, serializer: JSONSerializer): SafeTool.Result<TResult>
```

Executes a tool with the provided arguments in an unsafe manner. This method does not enforce type safety for the arguments provided to the tool.

A Result containing the outcome of the tool execution with TResult as the result type.

- args — The arguments to be passed to the tool.
- serializer — The JSON serializer for encoding the tool arguments.

Referenced packages: `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
suspend fun executeUnsafe(args: Any?, serializer: JSONSerializer, metadata: ToolCallMetadata): SafeTool.Result<TResult>
```

Executes the tool with the provided arguments and metadata in an unsafe manner.

A Result containing the outcome of the tool execution.

- args — The arguments to be passed to the tool.
- serializer — The JSON serializer for encoding the tool arguments.
- metadata — Caller-contributed per-call context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.environment.SafeTool.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/execute.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun execute(args: TArgs, serializer: JSONSerializer): SafeTool.Result<TResult>
```

Executes the tool with the provided arguments and returns the result.

This method constructs a MessagePart.Tool.Call with the given arguments, passes it to the environment for execution, and converts the received tool result into a safe result encapsulated in a Result type.

A Result containing the outcome of the tool execution, either a success or a failure.

- args — The arguments required for the tool execution.
- serializer — The JSON serializer for encoding the tool arguments.

Referenced packages: `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
suspend fun execute(args: TArgs, serializer: JSONSerializer, metadata: ToolCallMetadata): SafeTool.Result<TResult>
```

Executes the tool with the provided arguments and caller-supplied metadata, returning the result.

The metadata is threaded through the environment into Tool.execute as a side channel (e.g. a trace span id). When combined with metadata contributed by installed features, the caller-supplied entries take precedence on key collision.

A Result containing the outcome of the tool execution.

- args — The arguments required for the tool execution.
- serializer — The JSON serializer for encoding the tool arguments.
- metadata — Caller-contributed per-call context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.environment.SafeTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-safe-tool/index.html`

### :agents:agents-core/commonMain

```kotlin
data class SafeTool<TArgs, TResult>(tool: ToolBase<TArgs, TResult>, environment: AIAgentEnvironment, clock: KoogClock)
```

A wrapper class designed to safely execute a tool within a given AI agent environment. It provides mechanisms for handling tool execution results and differentiating between success and failure cases.


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.environment.TerminationTool.ARG

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-termination-tool/-a-r-g.html`

### :agents:agents-core/commonMain

```kotlin
const val ARG: String
```

The key name used to represent the result of an operation or tool execution in various contexts.

This constant is a simple string identifier, typically utilized to store, retrieve, or refer to the output or resulting value produced during a process.

## ai.koog.agents.core.environment.TerminationTool.NAME

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-termination-tool/-n-a-m-e.html`

### :agents:agents-core/commonMain

```kotlin
const val NAME: String
```

Represents the reserved name used to signify a termination action or signal within the application.

The variable is intended for internal use, acting as a marker or identifier for halting processes, sessions, or operations in an explicit manner.

## ai.koog.agents.core.environment.TerminationTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-termination-tool/index.html`

### :agents:agents-core/commonMain

```kotlin
object TerminationTool
```

Provides constants related to the termination tool functionality in an AI agent environment.

This object contains constants used to signal or handle the termination of operations within AI agent interactions.

## ai.koog.agents.core.environment.ToolResultKind.Failure.Failure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-failure/-failure.html`

### :agents:agents-core/commonMain

```kotlin
constructor(error: Throwable?)
```

## ai.koog.agents.core.environment.ToolResultKind.Failure.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-failure/error.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable(with = ThrowableAsAgentErrorSerializer::class) val error: Throwable?
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.environment.ToolResultKind.Failure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-failure/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class Failure(val error: Throwable?) : ToolResultKind
```

Represents a failure result in the context of a tool operation.

## ai.koog.agents.core.environment.ToolResultKind.Success

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-success/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable object Success : ToolResultKind
```

Represents a successful result in the context of a tool operation.

## ai.koog.agents.core.environment.ToolResultKind.ValidationError.ValidationError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-validation-error/-validation-error.html`

### :agents:agents-core/commonMain

```kotlin
constructor(error: Throwable)
```

## ai.koog.agents.core.environment.ToolResultKind.ValidationError.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-validation-error/error.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable(with = ThrowableAsAgentErrorSerializer::class) val error: Throwable
```


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.environment.ToolResultKind.ValidationError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/-validation-error/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ValidationError(val error: Throwable) : ToolResultKind
```

Represents a validation error result in the context of a tool operation.

## ai.koog.agents.core.environment.ToolResultKind

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/-tool-result-kind/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable sealed class ToolResultKind
```

Represents the possible result types for a tool operation.

- Success
- Failure
- ValidationError
## ai.koog.agents.core.environment.executeUnsafe

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/execute-unsafe.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
suspend fun <TResult> SafeTool<ERROR CLASS: Symbol not found for ToolFromCallable.Args, TResult>.executeUnsafe(serializer: ERROR CLASS: Symbol not found for JSONSerializer, vararg args: Any?): SafeTool.Result<TResult>
```

Helper function for SafeTool that is created from ToolFromCallable. Allows a simpler execution by passing the ToolFromCallable.callable positional arguments directly as args instead of creating ToolFromCallable.Args manually.

It is unsafe since it doesn't validate types of the args, so it can throw type mismatch related exceptions.

Example:

## ai.koog.agents.core.environment.toSafeResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.environment/to-safe-result.html`

### :agents:agents-core/commonMain

```kotlin
fun <TResult> ReceivedToolResult.toSafeResult(tool: ToolBase<*, TResult>, serializer: JSONSerializer): SafeTool.Result<TResult>
```

Converts a ReceivedToolResult instance into a SafeTool.Result for safer result handling.

A SafeTool.Result which will either be a SafeTool.Result.Failure or SafeTool.Result.Success


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.exception.AgentEngineException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-agent-engine-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed class AgentEngineException : AgentRuntimeException
```

Base class for representing an ai.koog.agents.core.model.AgentServiceError response from the server.

- UnexpectedServerException
- UnexpectedMessageTypeException
- MalformedMessageException
- AgentNotFoundException
## ai.koog.agents.core.exception.AgentNotFoundException.AgentNotFoundException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-agent-not-found-exception/-agent-not-found-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String)
```

- message — The detail message explaining the error.
## ai.koog.agents.core.exception.AgentNotFoundException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-agent-not-found-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class AgentNotFoundException(message: String) : AgentEngineException
```

Thrown to indicate that the requested agent could not be found.

This exception is used when the system cannot locate an agent that matches the provided identifier. Possible causes include the agent being unavailable, unregistered, or the identifier being incorrect. It corresponds to the AGENT_NOT_FOUND error type in the agent service error categorization.

- message — The detail message explaining the error.
## ai.koog.agents.core.exception.AgentRuntimeException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-agent-runtime-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed class AgentRuntimeException : RuntimeException
```

Base class for all agent runtime exceptions.

- ToolNotRegisteredException
- AgentEngineException
## ai.koog.agents.core.exception.MalformedMessageException.MalformedMessageException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-malformed-message-exception/-malformed-message-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.core.exception.MalformedMessageException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-malformed-message-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class MalformedMessageException(message: String) : AgentEngineException
```

Exception indicating that a received message is malformed.

## ai.koog.agents.core.exception.ToolNotRegisteredException.ToolNotRegisteredException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-tool-not-registered-exception/-tool-not-registered-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String)
```

- name — Name of the tool that was not found.
## ai.koog.agents.core.exception.ToolNotRegisteredException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-tool-not-registered-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class ToolNotRegisteredException(name: String) : AgentRuntimeException
```

Thrown when the ai.koog.agents.core.tools.ToolRegistry cannot locate the requested ai.koog.agents.core.tools.Tool for execution.

- name — Name of the tool that was not found.
## ai.koog.agents.core.exception.UnexpectedMessageTypeException.UnexpectedMessageTypeException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-unexpected-message-type-exception/-unexpected-message-type-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.core.exception.UnexpectedMessageTypeException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-unexpected-message-type-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class UnexpectedMessageTypeException(message: String) : AgentEngineException
```

Exception thrown when an unexpected type of message is encountered in the agent service.

## ai.koog.agents.core.exception.UnexpectedServerException.UnexpectedServerException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-unexpected-server-exception/-unexpected-server-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String)
```

## ai.koog.agents.core.exception.UnexpectedServerException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.exception/-unexpected-server-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class UnexpectedServerException(message: String) : AgentEngineException
```

Exception indicating that an unexpected server error occurred during an operation.

## ai.koog.agents.core.feature.ContextualPromptExecutor.ContextualPromptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/-contextual-prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
constructor(executor: PromptExecutor, context: AIAgentContext)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/close.html`

### :agents:agents-core/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.core.feature.ContextualPromptExecutor.executeMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/execute-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.executeStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/execute-streaming.html`

### :agents:agents-core/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Executes a streaming call to the language model with tool support.

This method wraps the underlying executor's streaming functionality with pipeline hooks to enable monitoring and processing of stream events. It triggers before-stream handlers before starting, stream-frame handlers for each frame received, and after-stream handlers upon completion.

A Flow of StreamFrame objects representing the streaming response

- prompt — The prompt to send to the language model
- model — The language model to use for streaming
- tools — The list of available tool descriptors for the streaming call

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.getBasicJsonSchemaGenerator

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/get-basic-json-schema-generator.html`

### :agents:agents-core/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(model: LLModel): BasicJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.getStandardJsonSchemaGenerator

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/get-standard-json-schema-generator.html`

### :agents:agents-core/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(model: LLModel): StandardJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.agents.core.feature.ContextualPromptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/index.html`

### :agents:agents-core/commonMain

```kotlin
class ContextualPromptExecutor(executor: PromptExecutor, context: AIAgentContext) : PromptExecutor
```

A wrapper around ai.koog.prompt.executor.model.PromptExecutor that allows for adding internal functionality to the executor to catch and log events related to LLM calls.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.models

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/models.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.ContextualPromptExecutor.moderate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-contextual-prompt-executor/moderate.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.config.FeatureConfig.FeatureConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-config/-feature-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

## ai.koog.agents.core.feature.config.FeatureConfig.addMessageProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-config/add-message-processor.html`

### :agents:agents-core/commonMain

```kotlin
fun addMessageProcessor(processor: FeatureMessageProcessor)
```

Adds a message processor to the configuration.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.config.FeatureConfig.eventFilter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-config/event-filter.html`

### :agents:agents-core/commonMain

```kotlin
val eventFilter: (AgentLifecycleEventContext) -> Boolean
```

A filter for events to be processed by a feature.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.config.FeatureConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-config/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class FeatureConfig
```

Abstract base class for configuring features with stream providers.

This class provides mechanisms to manage a list of FeatureMessageProcessor instances, which are responsible for handling outbound feature events or messages (e.g., node started, strategy started). Subclasses may extend this configuration class to define additional settings specific to a feature.

- DebuggerConfig
## ai.koog.agents.core.feature.config.FeatureConfig.messageProcessors

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-config/message-processors.html`

### :agents:agents-core/commonMain

```kotlin
val messageProcessors: List<FeatureMessageProcessor>
```

Provides a read-only list of FeatureMessageProcessor instances registered with the feature configuration.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.config.FeatureConfig.setEventFilter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-config/set-event-filter.html`

### :agents:agents-core/commonMain

```kotlin
open fun setEventFilter(filter: (AgentLifecycleEventContext) -> Boolean)
```

A filter for messages to be sent to the tracing message processors.

This function is called for each trace event before it's sent to the message processors. If the function returns true, the event is processed; if it returns false, the event is ignored.

By default, all messages are processed (the filter returns true for all messages).

Example:


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.config.FeatureSystemVariables.KOOG_FEATURES_ENV_VAR_NAME

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-system-variables/-k-o-o-g_-f-e-a-t-u-r-e-s_-e-n-v_-v-a-r_-n-a-m-e.html`

### :agents:agents-core/commonMain

```kotlin
const val KOOG_FEATURES_ENV_VAR_NAME: String
```

The name of the environment variable used to configure features in the system.

## ai.koog.agents.core.feature.config.FeatureSystemVariables.KOOG_FEATURES_VM_OPTION_NAME

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-system-variables/-k-o-o-g_-f-e-a-t-u-r-e-s_-v-m_-o-p-t-i-o-n_-n-a-m-e.html`

### :agents:agents-core/commonMain

```kotlin
const val KOOG_FEATURES_VM_OPTION_NAME: String
```

The name of the JVM option used to configure features in the system.

## ai.koog.agents.core.feature.config.FeatureSystemVariables

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.config/-feature-system-variables/index.html`

### :agents:agents-core/commonMain

```kotlin
object FeatureSystemVariables
```

A utility object that provides constants representing system variables related to the configuration of features in the system.

These system variables enable external configuration of features via environment variables or JVM options.

## ai.koog.agents.core.feature.debugger.Debugger.Debugger

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-debugger.html`

### :agents:agents-core/commonMain

```kotlin
constructor(port: Int, awaitInitialConnectionTimeout: Duration? = null)
```

## ai.koog.agents.core.feature.debugger.Debugger.Feature.KOOG_DEBUGGER_PORT_ENV_VAR

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/-k-o-o-g_-d-e-b-u-g-g-e-r_-p-o-r-t_-e-n-v_-v-a-r.html`

### :agents:agents-core/commonMain

```kotlin
const val KOOG_DEBUGGER_PORT_ENV_VAR: String
```

The name of the environment variable used to specify the port number for the Koog debugger.

## ai.koog.agents.core.feature.debugger.Debugger.Feature.KOOG_DEBUGGER_PORT_VM_OPTION

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/-k-o-o-g_-d-e-b-u-g-g-e-r_-p-o-r-t_-v-m_-o-p-t-i-o-n.html`

### :agents:agents-core/commonMain

```kotlin
const val KOOG_DEBUGGER_PORT_VM_OPTION: String
```

The name of the VM option used to specify the port number for the Koog debugger.

## ai.koog.agents.core.feature.debugger.Debugger.Feature.KOOG_DEBUGGER_WAIT_CONNECTION_MS_ENV_VAR

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/-k-o-o-g_-d-e-b-u-g-g-e-r_-w-a-i-t_-c-o-n-n-e-c-t-i-o-n_-m-s_-e-n-v_-v-a-r.html`

### :agents:agents-core/commonMain

```kotlin
const val KOOG_DEBUGGER_WAIT_CONNECTION_MS_ENV_VAR: String
```

Name of the environment variable used to specify the timeout duration (in milliseconds) for the debugger to wait for a connection.

## ai.koog.agents.core.feature.debugger.Debugger.Feature.KOOG_DEBUGGER_WAIT_CONNECTION_TIMEOUT_MS_VM_OPTION

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/-k-o-o-g_-d-e-b-u-g-g-e-r_-w-a-i-t_-c-o-n-n-e-c-t-i-o-n_-t-i-m-e-o-u-t_-m-s_-v-m_-o-p-t-i-o-n.html`

### :agents:agents-core/commonMain

```kotlin
const val KOOG_DEBUGGER_WAIT_CONNECTION_TIMEOUT_MS_VM_OPTION: String
```

The name of the JVM option used to configure the timeout duration (in milliseconds) for the Koog debugger to wait for a connection.

## ai.koog.agents.core.feature.debugger.Debugger.Feature.createInitialConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/create-initial-config.html`

### :agents:agents-core/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): DebuggerConfig
```

Creates and returns an initial configuration for the feature.

- agentConfig — The config of the agent this feature config is being created for.

Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.feature.debugger.Debugger.Feature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/index.html`

### :agents:agents-core/commonMain

```kotlin
object Feature : AIAgentGraphFeature<DebuggerConfig, Debugger> , AIAgentFunctionalFeature<DebuggerConfig, Debugger> , AIAgentPlannerFeature<DebuggerConfig, Debugger>
```

Companion object implementing agent feature, handling Debugger creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.core.feature.debugger.Debugger.Feature.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/install.html`

### :agents:agents-core/commonMain

```kotlin
open override fun install(config: DebuggerConfig, pipeline: AIAgentGraphPipeline): Debugger
```

Installs the feature into the specified pipeline.

The implementation of the feature.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-core/commonMain

```kotlin
open override fun install(config: DebuggerConfig, pipeline: AIAgentFunctionalPipeline): Debugger
```

Installs the feature into the specified pipeline.

The implementation of the feature.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-core/commonMain

```kotlin
open override fun install(config: DebuggerConfig, pipeline: AIAgentPlannerPipeline): Debugger
```

Installs the feature into the specified pipeline.

The implementation of the feature.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.feature.debugger.Debugger.Feature.key

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/-feature/key.html`

### :agents:agents-core/commonMain

```kotlin
open override val key: AIAgentStorageKey<Debugger>
```

A key used to uniquely identify a feature of type TFeatureImpl within the local agent storage.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.debugger.Debugger.awaitInitialConnectionTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/await-initial-connection-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val awaitInitialConnectionTimeout: Duration?
```

## ai.koog.agents.core.feature.debugger.Debugger

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/index.html`

### :agents:agents-core/commonMain

```kotlin
class Debugger(val port: Int, val awaitInitialConnectionTimeout: Duration? = null)
```

Debugger feature provides the functionality of monitoring and recording events during the operation of an AI agent. It integrates into an AI agent pipeline, allowing the collection and processing of various agent events such as start, end, errors, tool calls, and strategy executions.

This feature serves as a debugging tool for analyzing the AI agent's behavior and interactions with its components, providing insights into the execution flow and potential issues.

## ai.koog.agents.core.feature.debugger.Debugger.port

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger/port.html`

### :agents:agents-core/commonMain

```kotlin
val port: Int
```

## ai.koog.agents.core.feature.debugger.DebuggerConfig.DebuggerConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/-debugger-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor(serializer: JSONSerializer)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.debugger.DebuggerConfig.awaitInitialConnectionTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/await-initial-connection-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val awaitInitialConnectionTimeout: Duration?
```

The optional duration to wait for establishing a connection with the debugger. Use an infinite awaiting if value is not defined.

## ai.koog.agents.core.feature.debugger.DebuggerConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/index.html`

### :agents:agents-core/commonMain

```kotlin
class DebuggerConfig(serializer: JSONSerializer) : FeatureConfig
```

Configuration class for managing debugger-specific settings.

This class extends the base FeatureConfig to enable the configuration of debugger-related parameters. It allows setting and retrieving the port number used by the debugger.


Referenced packages: `ai.koog.agents.core.feature.config`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.debugger.DebuggerConfig.port

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/port.html`

### :agents:agents-core/commonMain

```kotlin
val port: Int?
```

The port number used by the debugger.

## ai.koog.agents.core.feature.debugger.DebuggerConfig.setAwaitInitialConnectionTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/set-await-initial-connection-timeout.html`

### :agents:agents-core/commonMain

```kotlin
fun setAwaitInitialConnectionTimeout(timeout: Duration)
```

Sets the duration to wait for establishing an initial connection with the debugger.

- timeout — The duration to be set for awaiting the initial connection.
## ai.koog.agents.core.feature.debugger.DebuggerConfig.setEventFilter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/set-event-filter.html`

### :agents:agents-core/commonMain

```kotlin
open override fun setEventFilter(filter: (AgentLifecycleEventContext) -> Boolean)
```

A filter for messages to be sent to the tracing message processors.

This function is called for each trace event before it's sent to the message processors. If the function returns true, the event is processed; if it returns false, the event is ignored.

By default, all messages are processed (the filter returns true for all messages).

Example:


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.debugger.DebuggerConfig.setPort

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/-debugger-config/set-port.html`

### :agents:agents-core/commonMain

```kotlin
fun setPort(port: Int)
```

Sets the port number to be used by the debugger.

- port — The port number to set.
## ai.koog.agents.core.feature.debugger.debugger

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger/debugger.html`

### :agents:agents-core/commonMain

```kotlin
fun AIAgentContext.debugger(): Debugger
```

Extension function to access the Debugger feature from an agent context.

The Debugger feature instance for this agent

- IllegalStateException — if the Debugger feature is not installed

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.debugger.writer.DebuggerFeatureMessageRemoteWriter.DebuggerFeatureMessageRemoteWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger.writer/-debugger-feature-message-remote-writer/-debugger-feature-message-remote-writer.html`

### :agents:agents-core/commonMain

```kotlin
constructor(connectionConfig: ServerConnectionConfig)
```

- connectionConfig — The configuration settings for establishing the remote server connection.

Referenced packages: `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.core.feature.debugger.writer.DebuggerFeatureMessageRemoteWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.debugger.writer/-debugger-feature-message-remote-writer/index.html`

### :agents:agents-core/commonMain

```kotlin
class DebuggerFeatureMessageRemoteWriter(connectionConfig: ServerConnectionConfig) : FeatureMessageRemoteWriter
```

Handles writing debug feature messages remotely to a server, inheriting common functionality from the FeatureMessageRemoteWriter base class.

- connectionConfig — The configuration settings for establishing the remote server connection.

Referenced packages: `ai.koog.agents.core.feature.remote.server.config`, `ai.koog.agents.core.feature.writer`.

## ai.koog.agents.core.feature.message.FeatureEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val eventId: String
```

Represents a unique identifier for the event or a group of events.

## ai.koog.agents.core.feature.message.FeatureEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-event/index.html`

### :agents:agents-core/commonMain

```kotlin
interface FeatureEvent : FeatureMessage
```

Represents a specialized type of feature message that corresponds to an event in the system. A feature event typically carries information uniquely identifying the event, alongside other data provided by the FeatureMessage interface.

Implementations of this interface are intended to detail specific events in the feature processing workflow.

- DefinedFeatureEvent
## ai.koog.agents.core.feature.message.FeatureMessage.Type.Event

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/-event/index.html`

### :agents:agents-core/commonMain

```kotlin
Event
```

Represents an event with a specific name or identifier.

This class serves as a structure to encapsulate information about a specific occurrence or action. The name of the event can be used to differentiate between various events in a system and can be used for event handling or triggering specific processes.

## ai.koog.agents.core.feature.message.FeatureMessage.Type.Message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/-message/index.html`

### :agents:agents-core/commonMain

```kotlin
Message
```

Represents a message with a text content.

The Message class encapsulates a string that represents a textual message. This can be used for various purposes such as displaying messages, sending messages over a network, logging, or any other scenario where text-based content needs to be handled.

## ai.koog.agents.core.feature.message.FeatureMessage.Type.entries

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/entries.html`

### :agents:agents-core/commonMain

```kotlin
val entries: EnumEntries<FeatureMessage.Type>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.core.feature.message.FeatureMessage.Type

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/index.html`

### :agents:agents-core/commonMain

```kotlin
enum Type : Enum<FeatureMessage.Type>
```

Represents the type of feature message or event.

This enum class is used to categorize and distinguish the kinds of messages processed within the system. It contains predefined values for message and event types.

## ai.koog.agents.core.feature.message.FeatureMessage.Type.valueOf

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/value-of.html`

### :agents:agents-core/commonMain

```kotlin
fun valueOf(value: String): FeatureMessage.Type
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.core.feature.message.FeatureMessage.Type.value

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/value.html`

### :agents:agents-core/commonMain

```kotlin
val value: String
```

## ai.koog.agents.core.feature.message.FeatureMessage.Type.values

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/-type/values.html`

### :agents:agents-core/commonMain

```kotlin
fun values(): Array<FeatureMessage.Type>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.core.feature.message.FeatureMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/index.html`

### :agents:agents-core/commonMain

```kotlin
interface FeatureMessage
```

Represents a feature message or event within the system.

This interface serves as a base contract for feature messages that encapsulate information about various system events or updates, such as status changes or interaction events.

- FeatureEvent
- FeatureStringMessage
## ai.koog.agents.core.feature.message.FeatureMessage.messageType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/message-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val messageType: FeatureMessage.Type
```

Specifies the type of feature message or event.

This property is used to categorize messages into predefined types within the system, such as Message or Event. The type determines how the message should be processed or interpreted by the underlying handlers or processors.

## ai.koog.agents.core.feature.message.FeatureMessage.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
abstract val timestamp: Long
```

n Represents the time, in milliseconds, when the feature message or event was created or occurred.

The timestamp is used to track the exact time of the message's creation or event's occurrence, facilitating temporal analysis, ordering, or correlation within the system.

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.FeatureMessageProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/-feature-message-processor.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor()
```

### :agents:agents-core/jvmCommonMain

```kotlin
actual constructor()
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor()
```

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/close.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun close()
```

Releases resources held by this processor.

### :agents:agents-core/jvmCommonMain

```kotlin
actual open suspend override fun close()
```

Releases resources held by this processor. The default implementation delegates to handleClose.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open suspend override fun close()
```

Releases resources held by this processor.

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.handleClose

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/handle-close.html`

### :agents:agents-core/jvmCommonMain

```kotlin
open fun handleClose()
```

## ai.koog.agents.core.feature.message.FeatureMessageProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/index.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract class FeatureMessageProcessor : Closeable
```

Represents a provider responsible for handling outbound feature messages or events.

Feature processors are used to encapsulate feature-related logic and provide a common interface for handling feature messages and events, such as

Node started

Node finished

Strategy started, etc.

Implementations of this interface are designed to process feature messages, which are encapsulated in the FeatureMessage type and presented as a model for an event to be sent to a target stream. These messages carry information about various events or updates related to features in the system.

- FeatureMessageFileWriter
- FeatureMessageLogWriter
- FeatureMessageRemoteWriter

Referenced packages: `ai.koog.utils.io`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual abstract class FeatureMessageProcessor : <ERROR CLASS> ERROR CLASS: Symbol not found for Closeable
```

Abstract class responsible for processing feature messages within the system.

The FeatureMessageProcessor provides functionality for filtering and handling incoming feature messages. Classes inheriting from this abstract class are expected to implement the necessary logic for processing messages.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract class FeatureMessageProcessor : Closeable
```

Abstract class responsible for processing feature messages or events within the system.

The FeatureMessageProcessor serves as a foundational interface for implementing processors that handle various feature-related messages. These messages, represented by the FeatureMessage type, encapsulate relevant information about events or updates in the system.

This class provides mechanisms to filter incoming messages, manage processing states, and ensure proper handling through a defined workflow.


Referenced packages: `ai.koog.utils.io`.

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.initialize

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/initialize.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend fun initialize()
```

Initializes the feature output stream provider to ensure it is ready for use.

### :agents:agents-core/jvmCommonMain

```kotlin
actual open suspend fun initialize()
```

Initializes the feature output stream provider to ensure it is ready for use.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open suspend fun initialize()
```

Initializes the feature output stream provider to ensure it is ready for use.

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.isOpen

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/is-open.html`

### :agents:agents-core/commonMain

```kotlin
expect open val isOpen: StateFlow<Boolean>
```

A StateFlow representing the current open state of the processor.

### :agents:agents-core/jvmCommonMain

```kotlin
actual open val isOpen: StateFlow<Boolean>
```

A StateFlow representing the current open state of the processor.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open val isOpen: StateFlow<Boolean>
```

A StateFlow representing the current open state of the processor.

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.messageFilter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/message-filter.html`

### :agents:agents-core/commonMain

```kotlin
expect var messageFilter: (FeatureMessage) -> Boolean
```

A filter for messages to be sent to message processors.

This function is called for each event before it's sent to the message processors. If the function returns true, the event is processed; if it returns false, the event is ignored.

By default, all messages are processed (the filter returns true for all messages).

### :agents:agents-core/jvmCommonMain

```kotlin
actual var messageFilter: (FeatureMessage) -> Boolean
```

A filter for messages to be sent to message processors.

This function is called for each event before it's sent to the message processors. If the function returns true, the event is processed; if it returns false, the event is ignored.

By default, all messages are processed (the filter returns true for all messages).

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual var messageFilter: (FeatureMessage) -> Boolean
```

A filter for messages to be sent to message processors.

This function is called for each event before it's sent to the message processors. If the function returns true, the event is processed; if it returns false, the event is ignored.

By default, all messages are processed (the filter returns true for all messages).

## ai.koog.agents.core.feature.message.FeatureMessageProcessor.onMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/on-message.html`

### :agents:agents-core/commonMain

```kotlin
expect suspend fun onMessage(message: FeatureMessage)
```

Receives and processes an incoming feature message.

This method evaluates the provided message using the configured message filter. If the message passes the filter, it is forwarded for further processing.

- message — The incoming feature message to be evaluated and potentially processed.
### :agents:agents-core/jvmCommonMain

```kotlin
actual suspend fun onMessage(message: FeatureMessage)
```

Receives and processes an incoming feature message.

This method evaluates the provided message using the configured message filter. If the message passes the filter, it is forwarded for further processing.

- message — The incoming feature message to be evaluated and potentially processed.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual suspend fun onMessage(message: FeatureMessage)
```

Receives and processes an incoming feature message.

This method evaluates the provided message using the configured message filter. If the message passes the filter, it is forwarded for further processing.

- message — The incoming feature message to be evaluated and potentially processed.
## ai.koog.agents.core.feature.message.FeatureMessageProcessor.setMessageFilter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor/set-message-filter.html`

### :agents:agents-core/commonMain

```kotlin
expect fun setMessageFilter(filter: (FeatureMessage) -> Boolean)
```

Sets the message filter used to determine which feature messages should be processed.

The provided filter function is invoked for each incoming feature message. If the filter function returns true, the message is deemed to meet the criteria for further processing.

- filter — A lambda function that accepts a FeatureMessage and returns a boolean indicating whether the message should be processed (true) or ignored (false).Example:processor.setMessageFilter { message -> message is LLMCallStartingEvent || message is LLMCallCompletedEvent} Content copied to clipboard
### :agents:agents-core/jvmCommonMain

```kotlin
actual fun setMessageFilter(filter: (FeatureMessage) -> Boolean)
```

Sets the message filter used to determine which feature messages should be processed.

The provided filter function is invoked for each incoming feature message. If the filter function returns true, the message is deemed to meet the criteria for further processing.

- filter — A lambda function that accepts a FeatureMessage and returns a boolean indicating whether the message should be processed (true) or ignored (false).
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun setMessageFilter(filter: (FeatureMessage) -> Boolean)
```

Sets the message filter used to determine which feature messages should be processed.

The provided filter function is invoked for each incoming feature message. If the filter function returns true, the message is deemed to meet the criteria for further processing.

- filter — A lambda function that accepts a FeatureMessage and returns a boolean indicating whether the message should be processed (true) or ignored (false).
## ai.koog.agents.core.feature.message.FeatureMessageProcessorUtil

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor-util/index.html`

### :agents:agents-core/commonMain

```kotlin
object FeatureMessageProcessorUtil
```

Utility object providing safe handling and processing of feature messages for collections and individual FeatureMessageProcessor implementations.

This utility ensures that exceptions thrown during message processing are caught and logged without interrupting the execution flow. It is particularly useful in scenarios where multiple processors are involved, and a failing processor shouldn't impact the processing of others.

## ai.koog.agents.core.feature.message.FeatureMessageProcessorUtil.onMessageForEachCatching

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.message/-feature-message-processor-util/on-message-for-each-catching.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun List<FeatureMessageProcessor>.onMessageForEachCatching(message: FeatureMessage)
```

Safely processes a given feature message using each FeatureMessageProcessor in the list.

This method iterates through each FeatureMessageProcessor in the list and calls their onMessageSafe method to process the provided FeatureMessage. Any exceptions that occur during the message processing are caught and logged, ensuring that an error in one processor does not disrupt the processing of the remaining processors.

- message — The feature message to be processed by each FeatureMessageProcessor.
## ai.koog.agents.core.feature.model.AIAgentError.AIAgentError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-a-i-agent-error/-a-i-agent-error.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String, stackTrace: String, cause: String? = null, type: String? = null)
```

### :agents:agents-core/commonMain

```kotlin
constructor(throwable: Throwable)
```

Secondary constructor that allows creating an instance of the class using a Throwable.

- throwable — The Throwable from which the error message, stack trace, and cause will be retrieved.
## ai.koog.agents.core.feature.model.AIAgentError.cause

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-a-i-agent-error/cause.html`

### :agents:agents-core/commonMain

```kotlin
val cause: String?
```

## ai.koog.agents.core.feature.model.AIAgentError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-a-i-agent-error/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AIAgentError(val message: String, val stackTrace: String, val cause: String? = null, val type: String? = null)
```

Represents an error encountered by an AI agent, encapsulating error details.

This class provides essential information to understand and debug errors occurring during the execution of AI agent strategies, tools, or nodes.

## ai.koog.agents.core.feature.model.AIAgentError.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-a-i-agent-error/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String
```

## ai.koog.agents.core.feature.model.AIAgentError.stackTrace

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-a-i-agent-error/stack-trace.html`

### :agents:agents-core/commonMain

```kotlin
val stackTrace: String
```

## ai.koog.agents.core.feature.model.AIAgentError.type

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-a-i-agent-error/type.html`

### :agents:agents-core/commonMain

```kotlin
val type: String?
```

## ai.koog.agents.core.feature.model.FeatureStringMessage.FeatureStringMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-feature-string-message/-feature-string-message.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```

## ai.koog.agents.core.feature.model.FeatureStringMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-feature-string-message/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class FeatureStringMessage(val message: String, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : FeatureMessage
```

Represents a detailed implementation of ai.koog.agents.core.feature.message.FeatureMessage that encapsulates a string message.

This class associates a string content with a specific feature-related message type, along with a timestamp indicating when the message was created.

It is primarily used for text-based feature messages and integrates with the ai.koog.agents.core.feature.message.FeatureMessage interface to define its structure.

Instances of this type are timestamped at the moment of their creation, ensuring consistent temporal tracking for feature messages.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.model.FeatureStringMessage.messageType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-feature-string-message/message-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val messageType: FeatureMessage.Type
```

Represents the type of the feature message, identifying the message's purpose or category.

In this implementation, the messageType property is set to FeatureMessage.Type.Message, which classifies the message as a standard feature-related message.

The messageType property enables proper categorization and handling of feature messages within the system, facilitating streamlined processing and functionality differentiation based on the message type.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.model.FeatureStringMessage.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-feature-string-message/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String
```

## ai.koog.agents.core.feature.model.FeatureStringMessage.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/-feature-string-message/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.toAgentError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model/to-agent-error.html`

### :agents:agents-core/commonMain

```kotlin
fun Throwable.toAgentError(): AIAgentError
```

Converts a Throwable instance to an AIAgentError.

The generated AIAgentError containing detailed information about the Throwable.

## ai.koog.agents.core.feature.model.events.AgentClosingEvent.AgentClosingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-closing-event/-agent-closing-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agentId: String, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentClosingEvent.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-closing-event/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
val agentId: String
```

## ai.koog.agents.core.feature.model.events.AgentClosingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-closing-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.AgentClosingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-closing-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentClosingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-closing-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentClosingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val agentId: String, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event that signifies the closure or termination of an AI agent identified by a unique agentId.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentClosingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-closing-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.AgentCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/-agent-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agentId: String, runId: String, result: String?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
val agentId: String
```

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val agentId: String, val runId: String, val result: String?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Event representing the completion of an AI Agent's execution.

This event is emitted when an AI Agent finishes executing a strategy, providing information about the strategy and its result. It can be used for logging, tracing, or monitoring the outcomes of agent operations.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: String?
```

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.AgentCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.AgentExecutionFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/-agent-execution-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agentId: String, runId: String, error: AIAgentError?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
val agentId: String
```

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError?
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentExecutionFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val agentId: String, val runId: String, val error: AIAgentError?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when an AI agent run encounters an error.

This event is used to capture error information during the execution of an AI agent strategy, including details of the strategy and the encountered error.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.AgentExecutionFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-execution-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.AgentStartingEvent.AgentStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/-agent-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agentId: String, runId: String, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentStartingEvent.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
val agentId: String
```

## ai.koog.agents.core.feature.model.events.AgentStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.AgentStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val agentId: String, val runId: String, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when an AI agent starts executing a strategy.

This event provides details about the agent's strategy, making it useful for monitoring, debugging, and tracking the lifecycle of AI agents within the system.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.AgentStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.AgentStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-agent-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.DefinedFeatureEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-defined-feature-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
abstract val executionInfo: AgentExecutionInfo
```

Holds the execution path information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.DefinedFeatureEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-defined-feature-event/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed class DefinedFeatureEvent : FeatureEvent
```

Represents a sealed class for defining feature-related events in the system.

This class serves as a foundational type from which specific feature events are derived. Its purpose is to encapsulate shared properties and functionality across all specialized feature events. Each subclass details a specific type of event, such as agent lifecycle updates or processing steps.

This class implements the ai.koog.agents.core.feature.message.FeatureEvent interface, ensuring compatibility with the system's feature event handling mechanisms.

- AgentStartingEvent
- AgentCompletedEvent
- AgentExecutionFailedEvent
- AgentClosingEvent
- LLMCallStartingEvent
- LLMCallCompletedEvent
- LLMCallFailedEvent
- LLMStreamingStartingEvent
- LLMStreamingFrameReceivedEvent
- LLMStreamingFailedEvent
- LLMStreamingCompletedEvent
- NodeExecutionStartingEvent
- NodeExecutionCompletedEvent
- NodeExecutionFailedEvent
- StrategyStartingEventBase
- StrategyCompletedEvent
- SubgraphExecutionStartingEvent
- SubgraphExecutionCompletedEvent
- SubgraphExecutionFailedEvent
- ToolCallStartingEvent
- ToolValidationFailedEvent
- ToolCallFailedEvent
- ToolCallCompletedEvent

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.model.events.DefinedFeatureEvent.messageType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-defined-feature-event/message-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val messageType: FeatureMessage.Type
```

Specifies the type of the feature message for this event.

This property is overridden to indicate that the message type of this feature is categorized as an Event. The Event type is used to represent occurrences or actions within the system, providing context to event-specific feature messages.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.GraphStrategyStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/-graph-strategy-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, strategyName: String, graph: StrategyEventGraph, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.graph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/graph.html`

### :agents:agents-core/commonMain

```kotlin
val graph: StrategyEventGraph
```

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class GraphStrategyStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val strategyName: String, val graph: StrategyEventGraph, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : StrategyStartingEventBase
```

Represents an event triggered at the start of an AI agent strategy execution that involves the use of a graph-based operational model.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategyName: String
```

## ai.koog.agents.core.feature.model.events.GraphStrategyStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-graph-strategy-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.LLMCallCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/-l-l-m-call-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, response: Message.Assistant?, moderationResponse: ModerationResult? = null, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMCallCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val response: Message.Assistant?, val moderationResponse: ModerationResult? = null, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event signaling the completion of an LLM (Large Language Model) call.

This event encapsulates the responses provided by the LLM during its operation. It serves as a record of the responses generated by the LLM, marking the end of a particular interaction cycle. The event is used within the system to capture relevant output data and ensure proper tracking and logging of LLM-related interactions.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.moderationResponse

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/moderation-response.html`

### :agents:agents-core/commonMain

```kotlin
val moderationResponse: ModerationResult?
```


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.response

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/response.html`

### :agents:agents-core/commonMain

```kotlin
val response: Message.Assistant?
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.LLMCallFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/-l-l-m-call-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, tools: List<String>, error: AIAgentError, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMCallFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val tools: List<String>, val error: AIAgentError, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event that occurs when a call to a large language model (LLM) fails. This event captures relevant details about the failed call, such as the prompt, model information, tools used, and the associated error.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMCallFailedEvent.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-failed-event/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<String>
```

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.LLMCallStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/-l-l-m-call-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, tools: List<String>, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMCallStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val tools: List<String>, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event indicating the start of a call to a Language Learning Model (LLM).

This event captures the details of the LLM interaction at the point of invocation, including the input prompt and any tools that will be used during the call. It extends the DefinedFeatureEvent class and serves as a specific type of event in a feature-driven framework.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMCallStartingEvent.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-call-starting-event/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<String>
```

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.LLMStreamingCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/-l-l-m-streaming-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, tools: List<String>, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMStreamingCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val tools: List<String>, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event that occurs when the streaming process of a Large Language Model (LLM) call is completed.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMStreamingCompletedEvent.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-completed-event/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<String>
```

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.LLMStreamingFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/-l-l-m-streaming-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, error: AIAgentError, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMStreamingFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val error: AIAgentError, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event indicating a failure in the streaming process of a Language Learning Model (LLM).

This event captures details of the failure encountered during the streaming operation. It includes information such as the unique identifier of the operation run, a detailed error description, and inherits common properties such as event ID and timestamp.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.LLMStreamingFrameReceivedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/-l-l-m-streaming-frame-received-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, frame: StreamFrame, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.frame

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/frame.html`

### :agents:agents-core/commonMain

```kotlin
val frame: StreamFrame
```


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMStreamingFrameReceivedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val frame: StreamFrame, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Event representing the receipt of a streaming frame from a Language Learning Model (LLM).

This event occurs as part of the streaming interaction with the LLM, where individual frames of data are sent incrementally. The event contains details about the specific frame received, as well as metadata related to the event's timing and identity.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingFrameReceivedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-frame-received-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.LLMStreamingStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/-l-l-m-streaming-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, prompt: Prompt, model: ModelInfo, tools: List<String>, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class LLMStreamingStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val prompt: Prompt, val model: ModelInfo, val tools: List<String>, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when a language model (LLM) streaming operation is starting.

This event holds metadata related to the initiation of the LLM streaming process, including details about the run, the input prompt, the model used, and the tools involved.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.utils`, `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/model.html`

### :agents:agents-core/commonMain

```kotlin
val model: ModelInfo
```


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/prompt.html`

### :agents:agents-core/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.LLMStreamingStartingEvent.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-l-l-m-streaming-starting-event/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<String>
```

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.NodeExecutionCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/-node-execution-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, nodeName: String, input: JSONElement?, output: JSONElement?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class NodeExecutionCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val nodeName: String, val input: JSONElement?, val output: JSONElement?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event indicating the completion of a node's execution within an AI agent.

This event is triggered when a specific processing node, identified by its name, concludes its execution. It encapsulates details about the node's name, the input it operated on, and the output it produced.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.nodeName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/node-name.html`

### :agents:agents-core/commonMain

```kotlin
val nodeName: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.NodeExecutionFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/-node-execution-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, nodeName: String, input: JSONElement?, error: AIAgentError, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class NodeExecutionFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val nodeName: String, val input: JSONElement?, val error: AIAgentError, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event that signifies the occurrence of an error during the execution of a specific node within an AI agent's process.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.nodeName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/node-name.html`

### :agents:agents-core/commonMain

```kotlin
val nodeName: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.NodeExecutionStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/-node-execution-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, nodeName: String, input: JSONElement?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class NodeExecutionStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val nodeName: String, val input: JSONElement?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when the execution of a specific AI agent node starts.

This event captures the initial execution context of an AI agent's processing node. It provides information about the node's name, the input being processed, and a unique identifier for the event.

Events of this kind are part of the feature event system and are primarily used for tracking and monitoring purposes, particularly in scenarios where understanding the flow of agent execution is essential.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.nodeName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/node-name.html`

### :agents:agents-core/commonMain

```kotlin
val nodeName: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-node-execution-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.StrategyCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/-strategy-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, strategyName: String, result: String?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class StrategyCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val strategyName: String, val result: String?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Event that represents the completion of an AI agent's strategy execution.

This event captures information about the strategy that was executed and the result of its execution. It is used to notify the system or consumers about the conclusion of a specific strategy.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: String?
```

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
val strategyName: String
```

## ai.koog.agents.core.feature.model.events.StrategyCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraph.StrategyEventGraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph/-strategy-event-graph.html`

### :agents:agents-core/commonMain

```kotlin
constructor(nodes: List<StrategyEventGraphNode>, edges: List<StrategyEventGraphEdge>)
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraph.edges

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph/edges.html`

### :agents:agents-core/commonMain

```kotlin
val edges: List<StrategyEventGraphEdge>
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class StrategyEventGraph(val nodes: List<StrategyEventGraphNode>, val edges: List<StrategyEventGraphEdge>)
```

Represents a graph structure used by an AI agent, consisting of a collection of nodes and directed edges connecting these nodes.

Each node encapsulates processing logic with specified input and output types. The edges define directed relationships between nodes, indicating the flow of data and execution order within the graph.

## ai.koog.agents.core.feature.model.events.StrategyEventGraph.nodes

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph/nodes.html`

### :agents:agents-core/commonMain

```kotlin
val nodes: List<StrategyEventGraphNode>
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraphEdge.StrategyEventGraphEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-edge/-strategy-event-graph-edge.html`

### :agents:agents-core/commonMain

```kotlin
constructor(sourceNode: StrategyEventGraphNode, targetNode: StrategyEventGraphNode)
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraphEdge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-edge/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class StrategyEventGraphEdge(val sourceNode: StrategyEventGraphNode, val targetNode: StrategyEventGraphNode)
```

Represents a directed edge in the AI agent graph.

## ai.koog.agents.core.feature.model.events.StrategyEventGraphEdge.sourceNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-edge/source-node.html`

### :agents:agents-core/commonMain

```kotlin
val sourceNode: StrategyEventGraphNode
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraphEdge.targetNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-edge/target-node.html`

### :agents:agents-core/commonMain

```kotlin
val targetNode: StrategyEventGraphNode
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraphNode.StrategyEventGraphNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-node/-strategy-event-graph-node.html`

### :agents:agents-core/commonMain

```kotlin
constructor(id: String, name: String)
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraphNode.id

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-node/id.html`

### :agents:agents-core/commonMain

```kotlin
val id: String
```

## ai.koog.agents.core.feature.model.events.StrategyEventGraphNode

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-node/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class StrategyEventGraphNode(val id: String, val name: String)
```

Represents a node within an AI agent's processing graph.

## ai.koog.agents.core.feature.model.events.StrategyEventGraphNode.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-event-graph-node/name.html`

### :agents:agents-core/commonMain

```kotlin
val name: String
```

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent.StrategyStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/-strategy-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, strategyName: String, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class StrategyStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val strategyName: String, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : StrategyStartingEventBase
```

Represents an event triggered at the start of executing a functional, planner, and other strategy types by an AI agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategyName: String
```

## ai.koog.agents.core.feature.model.events.StrategyStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.StrategyStartingEventBase.StrategyStartingEventBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event-base/-strategy-starting-event-base.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

## ai.koog.agents.core.feature.model.events.StrategyStartingEventBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class StrategyStartingEventBase : DefinedFeatureEvent
```

Represents an event triggered at the start of an AI agent strategy execution.

- GraphStrategyStartingEvent
- StrategyStartingEvent
## ai.koog.agents.core.feature.model.events.StrategyStartingEventBase.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event-base/run-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val runId: String
```

A unique identifier associated with a specific run.

## ai.koog.agents.core.feature.model.events.StrategyStartingEventBase.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-strategy-starting-event-base/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
abstract val strategyName: String
```

The name of the AI agent strategy being initiated.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.SubgraphExecutionCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/-subgraph-execution-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, subgraphName: String, input: JSONElement?, output: JSONElement?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class SubgraphExecutionCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val subgraphName: String, val input: JSONElement?, val output: JSONElement?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when the execution of a specific subgraph completes.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.subgraphName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/subgraph-name.html`

### :agents:agents-core/commonMain

```kotlin
val subgraphName: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.SubgraphExecutionFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/-subgraph-execution-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, subgraphName: String, input: JSONElement?, error: AIAgentError, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class SubgraphExecutionFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val subgraphName: String, val input: JSONElement?, val error: AIAgentError, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when the execution of a specific subgraph fails.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.subgraphName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/subgraph-name.html`

### :agents:agents-core/commonMain

```kotlin
val subgraphName: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.SubgraphExecutionStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/-subgraph-execution-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, subgraphName: String, input: JSONElement?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class SubgraphExecutionStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val subgraphName: String, val input: JSONElement?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when the execution of a specific subgraph starts.

This event captures the initiation of a subgraph execution, including details such as the unique run identifier, the name of the subgraph, and the input data provided to the subgraph.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.subgraphName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/subgraph-name.html`

### :agents:agents-core/commonMain

```kotlin
val subgraphName: String
```

## ai.koog.agents.core.feature.model.events.SubgraphExecutionStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-subgraph-execution-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.ToolCallCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/-tool-call-completed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolArgs: JSONObject, toolDescription: String?, result: JSONElement?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ToolCallCompletedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val toolCallId: String?, val toolName: String, val toolArgs: JSONObject, val toolDescription: String?, val result: JSONElement?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event that contains the results of a tool invocation.

This event carries information about the tool that was executed, the arguments used for its execution, and the resulting outcome. It is used to track and share the details of a tool's execution within the system's event-handling framework.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
val toolArgs: JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
val toolCallId: String?
```

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
val toolDescription: String?
```

## ai.koog.agents.core.feature.model.events.ToolCallCompletedEvent.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-completed-event/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
val toolName: String
```

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.ToolCallFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/-tool-call-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolArgs: JSONObject, toolDescription: String?, error: AIAgentError?, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError?
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ToolCallFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val toolCallId: String?, val toolName: String, val toolArgs: JSONObject, val toolDescription: String?, val error: AIAgentError?, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Captures an event where a tool call has failed during its execution.

This event is typically used to log or handle situations where a tool could not execute successfully due to an error. It includes relevant details about the failed tool call, such as the tool's name, the arguments provided, and the specific error encountered.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
val toolArgs: JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
val toolCallId: String?
```

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
val toolDescription: String?
```

## ai.koog.agents.core.feature.model.events.ToolCallFailedEvent.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-failed-event/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
val toolName: String
```

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.ToolCallStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/-tool-call-starting-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolArgs: JSONObject, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ToolCallStartingEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val toolCallId: String?, val toolName: String, val toolArgs: JSONObject, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event triggered when a tool is called within the system.

This event is used to capture and describe the invocation of a tool along with its associated arguments. It helps in tracking, logging, or processing tool calls as part of a larger feature pipeline or system workflow.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
val toolArgs: JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
val toolCallId: String?
```

## ai.koog.agents.core.feature.model.events.ToolCallStartingEvent.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-call-starting-event/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
val toolName: String
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.ToolValidationFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/-tool-validation-failed-event.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolArgs: JSONObject, toolDescription: String?, message: String?, error: AIAgentError, timestamp: Long = KoogClock.System.now().toEpochMilliseconds())
```


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: AIAgentError
```


Referenced packages: `ai.koog.agents.core.feature.model`.

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class ToolValidationFailedEvent(val eventId: String, val executionInfo: AgentExecutionInfo, val runId: String, val toolCallId: String?, val toolName: String, val toolArgs: JSONObject, val toolDescription: String?, val message: String?, val error: AIAgentError, val timestamp: Long = KoogClock.System.now().toEpochMilliseconds()) : DefinedFeatureEvent
```

Represents an event indicating that a tool encountered a validation error during its execution.

This event captures details regarding the tool that failed validation, the arguments provided to the tool, and the specific error message explaining why the validation failed.


Referenced packages: `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.feature.model`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String?
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.timestamp

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/timestamp.html`

### :agents:agents-core/commonMain

```kotlin
open override val timestamp: Long
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
val toolArgs: JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
val toolCallId: String?
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
val toolDescription: String?
```

## ai.koog.agents.core.feature.model.events.ToolValidationFailedEvent.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/-tool-validation-failed-event/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
val toolName: String
```

## ai.koog.agents.core.feature.model.events.startNodeToGraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.model.events/start-node-to-graph.html`

### :agents:agents-core/commonMain

```kotlin
fun <TInput, TOutput> AIAgentGraphStrategy<TInput, TOutput>.startNodeToGraph(): StrategyEventGraph
```

Constructs an instance of AIAgentEventGraph by converting the metadata information of the current AIAgentGraphStrategy into its graph representation. The method creates nodes and edges that define the structure and flow of execution for the underlying AI agent strategy.

The nodes and edges are derived from the registered subgraph metadata, which contains information about the connected components of the strategy.

An instance of AIAgentEventGraph representing the strategy's node-to-node connections in a graph format.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.pipeline.AIAgentFunctionalPipeline.AIAgentFunctionalPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-functional-pipeline/-a-i-agent-functional-pipeline.html`

### :agents:agents-core/commonMain

```kotlin
constructor(agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentFunctionalPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-functional-pipeline/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentFunctionalPipeline(agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System) : AIAgentPipeline
```

Represents a specific implementation of an AI agent pipeline that does not use graph-based processing. This class inherits from the base AIAgentPipeline class and may be used for handling workflows or data processing tasks that do not require graph-based data structures.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentFunctionalPipeline.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-functional-pipeline/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig, TFeature : Any> install(feature: AIAgentFunctionalFeature<TConfig, TFeature>, configure: TConfig.() -> Unit)
```

Installs a non-graph feature into the pipeline with the provided configuration.

- feature — The feature implementation to be installed;
- configure — A lambda to customize the feature configuration.
- TConfig — The type of the feature configuration;
- TFeature — The type of the feature being installed;

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.AIAgentGraphPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/-a-i-agent-graph-pipeline.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System, basePipelineDelegate: AIAgentPipelineImpl = AIAgentPipelineImpl(agentConfig, clock))
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(agentConfig: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock, basePipelineDelegate: AIAgentPipelineImpl)
```


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(agentConfig: AIAgentConfig, clock: KoogClock, basePipelineDelegate: AIAgentPipelineImpl)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/index.html`

### :agents:agents-core/commonMain

```kotlin
expect open class AIAgentGraphPipeline : AIAgentPipeline, AIAgentGraphPipelineAPI
```

Represents a pipeline for AI agent graph execution, extending the functionality of AIAgentPipeline. This class manages the execution of specific nodes in the pipeline using registered handlers.

### :agents:agents-core/jvmCommonMain

```kotlin
actual open class AIAgentGraphPipeline : AIAgentPipeline, AIAgentGraphPipelineAPI
```

Represents a pipeline for AI agent graph execution, extending the functionality of AIAgentPipeline. This class manages the execution of specific nodes in the pipeline using registered handlers.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open class AIAgentGraphPipeline : AIAgentPipeline, AIAgentGraphPipelineAPI
```

Represents a pipeline for AI agent graph execution, extending the functionality of AIAgentPipeline. This class manages the execution of specific nodes in the pipeline using registered handlers.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/install.html`

### :agents:agents-core/commonMain

```kotlin
expect fun <TConfig : FeatureConfig, TFeatureImpl : Any> install(feature: AIAgentGraphFeature<TConfig, TFeatureImpl>, configure: TConfig.() -> Unit)
```

Installs a feature into the pipeline with the provided configuration.

This method initializes the feature with a custom configuration and registers it in the pipeline. The feature's message processors are initialized during installation.

- feature — The feature implementation to be installed;
- configure — A lambda to customize the feature configuration.
- TConfig — The type of the feature configuration;
- TFeatureImpl — The type of the feature being installed;

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual fun <TConfig : FeatureConfig, TFeatureImpl : Any> install(feature: AIAgentGraphFeature<TConfig, TFeatureImpl>, configure: TConfig.() -> Unit)
```

Installs a feature into the pipeline with the provided configuration.

This method initializes the feature with a custom configuration and registers it in the pipeline. The feature's message processors are initialized during installation.

- feature — The feature implementation to be installed;
- configure — A lambda to customize the feature configuration.
- TConfig — The type of the feature configuration;
- TFeatureImpl — The type of the feature being installed;

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun <TConfig : FeatureConfig, TFeatureImpl : Any> install(feature: AIAgentGraphFeature<TConfig, TFeatureImpl>, configure: TConfig.() -> Unit)
```

Installs a feature into the pipeline with the provided configuration.

This method initializes the feature with a custom configuration and registers it in the pipeline. The feature's message processors are initialized during installation.

- feature — The feature implementation to be installed;
- configure — A lambda to customize the feature configuration.
- TConfig — The type of the feature configuration;
- TFeatureImpl — The type of the feature being installed;

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.interceptNodeExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/intercept-node-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptNodeExecutionCompleted(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: NodeExecutionCompletedContext) -> Unit)
```

Intercepts node execution after it completes.

- feature — The feature associated with this handler;
- handle — The handler that processes after-node events.Example:pipeline.interceptNodeExecutionCompleted(feature) { eventContext -> logger.info("Node ${eventContext.node.name} executed with input: ${eventContext.input} and produced output: ${eventContext.output}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.interceptNodeExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/intercept-node-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptNodeExecutionFailed(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: NodeExecutionFailedContext) -> Unit)
```

Intercepts and handles node execution errors for a given feature.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the node execution error.Example:pipeline.interceptNodeExecutionFailed(feature) { eventContext -> logger.error("Node ${eventContext.node.name} execution failed with error: ${eventContext.error}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.interceptNodeExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/intercept-node-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptNodeExecutionStarting(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: NodeExecutionStartingContext) -> Unit)
```

Intercepts node execution before it starts.

- feature — The feature associated with this handler;
- handle — The handler that processes before-node events.Example:pipeline.interceptNodeExecutionStarting(feature) { eventContext -> logger.info("Node ${eventContext.node.name} is about to execute with input: ${eventContext.input}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.interceptSubgraphExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/intercept-subgraph-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptSubgraphExecutionCompleted(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: SubgraphExecutionCompletedContext) -> Unit)
```

Intercepts the completion of a subgraph execution and allows handling of the event.

- feature — The AI agent graph feature that specifies the feature to intercept;
- handle — A suspendable function that handles the subgraph execution completion event, taking the event context as a parameter.Example:pipeline.interceptSubgraphExecutionCompleted(feature) { eventContext -> logger.info("Subgraph ${eventContext.subgraph.name} executed with input: ${eventContext.input} and produced output: ${eventContext.output}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.interceptSubgraphExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/intercept-subgraph-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptSubgraphExecutionFailed(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: SubgraphExecutionFailedContext) -> Unit)
```

Intercepts and handles subgraph execution failures for a given feature.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the subgraph execution failure event.Example:pipeline.interceptSubgraphExecutionFailed(feature) { eventContext -> logger.error("Subgraph ${eventContext.subgraph.name} execution failed with error: ${eventContext.error}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.interceptSubgraphExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/intercept-subgraph-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptSubgraphExecutionStarting(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: SubgraphExecutionStartingContext) -> Unit)
```

Intercepts the execution of a subgraph when it starts.

- feature — The graph feature associated with the AI agent for which the subgraph execution is intercepted;
- handle — A suspendable lambda that handles the subgraph execution starting event context.Example:pipeline.interceptSubgraphExecutionStarting(feature) { eventContext -> logger.info("Subgraph ${eventContext.subgraph.name} is about to execute with input: ${eventContext.input}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.onNodeExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/on-node-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onNodeExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken, output: Any?, outputType: TypeToken)
```

Notifies all registered node handlers after a node has been executed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the node execution event;
- context — The agent context in which the node was executed;
- node — The node that was executed;
- input — The input data that was provided to the node;
- inputType — The type of the input data provided to the node;
- output — The output data produced by the node execution;
- outputType — The type of the output data produced by the node execution.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.onNodeExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/on-node-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onNodeExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken, error: Throwable)
```

Handles errors occurring during the execution of a node by invoking all registered node execution error handlers.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the node execution event;
- context — The context associated with the AI agent executing the node;
- node — The instance of the node where the error occurred;
- input — The input data provided to the node;
- inputType — The type of the input data provided to the node;
- error — The exception or error that occurred during node execution.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.onNodeExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/on-node-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onNodeExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken)
```

Notifies all registered node handlers before a node is executed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the node execution event;
- context — The agent context in which the node is being executed;
- node — The node that is about to be executed;
- input — The input data for the node execution;
- inputType — The type of the input data provided to the node.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.onSubgraphExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/on-subgraph-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onSubgraphExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken, output: Any?, outputType: TypeToken)
```

Notifies all registered subgraph handlers after a subgraph has been executed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the subgraph execution event;
- context — The agent context in which the subgraph was executed;
- subgraph — The subgraph that was executed;
- input — The input data provided to the subgraph;
- inputType — The type of the input data provided to the subgraph;
- output — The output data produced by the subgraph execution;
- outputType — The type of the output data produced by the subgraph execution.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.onSubgraphExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/on-subgraph-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onSubgraphExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken, error: Throwable)
```

Notifies all registered subgraph handlers when a subgraph execution fails.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the subgraph execution event;
- context — The agent context in which the subgraph execution occurred;
- subgraph — The subgraph for which the execution failed;
- input — The input data that was provided to the subgraph when it failed;
- inputType — The type of the input data provided to the subgraph;
- error — The exception or error that caused the subgraph execution to fail.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipeline.onSubgraphExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline/on-subgraph-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onSubgraphExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken)
```

Notifies all registered subgraph handlers before a subgraph is executed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the subgraph execution event;
- context — The agent context in which the subgraph is being executed;
- subgraph — The subgraph that is about to be executed;
- input — The input data for the subgraph execution;
- inputType — The type of the input data provided to the subgraph.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentGraphPipelineAPI : AIAgentPipelineAPI
```

Public API surface for graph-specific pipeline operations (nodes and subgraphs).

Implemented by both the common expect AIAgentGraphPipeline and the concrete implementation AIAgentGraphPipelineImpl, and used by all platform actual classes via delegation.

- AIAgentGraphPipeline
## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.interceptNodeExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/intercept-node-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptNodeExecutionCompleted(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: NodeExecutionCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.interceptNodeExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/intercept-node-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptNodeExecutionFailed(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: NodeExecutionFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.interceptNodeExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/intercept-node-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptNodeExecutionStarting(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: NodeExecutionStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.interceptSubgraphExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/intercept-subgraph-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptSubgraphExecutionCompleted(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: SubgraphExecutionCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.interceptSubgraphExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/intercept-subgraph-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptSubgraphExecutionFailed(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: SubgraphExecutionFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.interceptSubgraphExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/intercept-subgraph-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptSubgraphExecutionStarting(feature: AIAgentGraphFeature<*, *>, handle: suspend (eventContext: SubgraphExecutionStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.onNodeExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/on-node-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onNodeExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken, output: Any?, outputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.onNodeExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/on-node-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onNodeExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.onNodeExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/on-node-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onNodeExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.onSubgraphExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/on-subgraph-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onSubgraphExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken, output: Any?, outputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.onSubgraphExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/on-subgraph-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onSubgraphExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentGraphPipelineAPI.onSubgraphExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-graph-pipeline-a-p-i/on-subgraph-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onSubgraphExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.AIAgentPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/-a-i-agent-pipeline.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(agentConfig: AIAgentConfig, clock: KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(agentConfig: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(agentConfig: AIAgentConfig, clock: KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/clock.html`

### :agents:agents-core/commonMain

```kotlin
expect open override val clock: KoogClock
```

Provides access to a Clock instance representing the current system time. The Clock can be used to retrieve the current time, create date-time instances, or perform operations based on a specific moment in time.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.closeAllFeaturesMessageProcessors

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/close-all-features-message-processors.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun closeAllFeaturesMessageProcessors()
```

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.collectToolCallMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/collect-tool-call-metadata.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun collectToolCallMetadata(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, context: AIAgentContext): ToolCallMetadata
```

Collects metadata contributions from every feature that registered a handler via provideToolCallMetadata and returns the combined map.

Contributions are merged in feature installation order; later contributions overwrite earlier ones on key collision. Called by ai.koog.agents.core.environment.ContextualAgentEnvironment before it delegates to the wrapped environment.

- eventId — The unique identifier for the current event;
- executionInfo — The execution information for the tool call event;
- runId — The unique identifier for the current run;
- toolCallId — The unique identifier for the current tool call;
- toolName — The tool name that is being called;
- toolDescription — The description of the tool that is being called;
- toolArgs — The arguments provided to the tool;
- context — The agent context associated with the tool call.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/config.html`

### :agents:agents-core/commonMain

```kotlin
expect open override val config: AIAgentConfig
```

Represents the configuration settings for the AI agent.

This property contains parameters and options that define the behavior and capabilities of the agent. It can be overridden to customize the configuration as needed in subclasses.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.feature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/feature.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun <TFeature : Any> feature(featureClass: KClass<TFeature>, feature: AIAgentFeature<*, TFeature>): TFeature?
```

Retrieves a feature implementation from the current pipeline using the specified feature, if it is registered.

The feature associated with the provided key, or null if no matching feature is found.

- feature — A feature to fetch.
- featureClass — The KClass of the feature to be retrieved.
- TFeature — A feature implementation type.
- IllegalArgumentException — if the specified featureClass does not correspond to a registered feature.

Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/index.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract class AIAgentPipeline : AIAgentPipelineAPI
```

Pipeline for AI agent features that provides interception points for various agent lifecycle events.

The pipeline allows features to:

Be installed into agent contexts

Intercept agent creation and environment transformation

Intercept strategy execution before and after it happens

Intercept node execution before and after it happens

Intercept LLM calls before and after they happen

Intercept tool calls before and after they happen

This pipeline serves as the central mechanism for extending and customizing agent behavior through a flexible interception system. Features can be installed with custom configurations and can hook into different stages of the agent's execution lifecycle.

- AIAgentFunctionalPipeline
- AIAgentGraphPipeline
- AIAgentPlannerPipeline
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract class AIAgentPipeline : AIAgentPipelineAPI
```

Pipeline for AI agent features that provides interception points for various agent lifecycle events.

The pipeline allows features to:

Be installed into agent contexts

Intercept agent creation and environment transformation

Intercept strategy execution before and after it happens

Intercept node execution before and after it happens

Intercept LLM calls before and after they happen

Intercept tool calls before and after they happen

This pipeline serves as the central mechanism for extending and customizing agent behavior through a flexible interception system. Features can be installed with custom configurations and can hook into different stages of the agent's execution lifecycle.

- AIAgentGraphPipeline
- AIAgentPlannerPipeline
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract class AIAgentPipeline : AIAgentPipelineAPI
```

Pipeline for AI agent features that provides interception points for various agent lifecycle events.

The pipeline allows features to:

Be installed into agent contexts

Intercept agent creation and environment transformation

Intercept strategy execution before and after it happens

Intercept node execution before and after it happens

Intercept LLM calls before and after they happen

Intercept tool calls before and after they happen

This pipeline serves as the central mechanism for extending and customizing agent behavior through a flexible interception system. Features can be installed with custom configurations and can hook into different stages of the agent's execution lifecycle.

- AIAgentGraphPipeline
- AIAgentPlannerPipeline
## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/install.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun <TConfig : FeatureConfig, TFeatureImpl : Any> install(featureKey: AIAgentStorageKey<TFeatureImpl>, featureConfig: TConfig, featureImpl: TFeatureImpl)
```

Installs a feature into the AI agent storage using the provided feature key, configuration, and implementation.

- featureKey — The unique key identifying the feature to be installed.
- featureConfig — The configuration details required to initialize the feature.
- featureImpl — The implementation instance of the feature to be installed.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptAgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-agent-closing.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptAgentClosing(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentClosingContext) -> Unit)
```

Intercepts and sets a handler to be invoked before an agent is closed.

- feature — The feature associated with this handler.
- handle — A suspendable function that is executed during the agent's pre-close phase.Example:pipeline.interceptAgentClosing(feature) { eventContext -> // Handle agent run before close event.} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptAgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-agent-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptAgentCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentCompletedContext) -> Unit)
```

Intercepts the completion of an agent's operation and assigns a custom handler to process the result.

- handle — A suspend function providing custom logic to execute when the agent completes,Example:pipeline.interceptAgentCompleted(feature) { eventContext -> // Handle the completion result here, using the strategy name and the result.} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptAgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-agent-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptAgentExecutionFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentExecutionFailedContext) -> Unit)
```

Intercepts and handles errors occurring during the execution of an AI agent's strategy.

- handle — A suspend function providing custom logic to execute when an error occurs,Example:pipeline.interceptAgentExecutionFailed(feature) { eventContext -> // Handle the error here, using the strategy name and the exception that occurred.} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptAgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-agent-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptAgentStarting(feature: AIAgentFeature<*, *>, handle: suspend (AgentStartingContext) -> Unit)
```

Intercepts on before an agent started to modify or enhance the agent.

- handle — The handler that processes agent creation eventsExample:pipeline.interceptAgentStarting(InterceptContext) { readStages { stages -> // Inspect agent stages }} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptEnvironmentCreated

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-environment-created.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptEnvironmentCreated(feature: AIAgentFeature<*, *>, handle: suspend (AgentEnvironmentTransformingContext, AIAgentEnvironment) -> AIAgentEnvironment)
```

Intercepts environment creation to allow features to modify or enhance the agent environment.

This method registers a transformer function that will be called when an agent environment is being created, allowing the feature to customize the environment based on the agent context.

- handle — A function that transforms the environment, with access to the agent creation contextExample:pipeline.interceptEnvironmentCreated(InterceptContext) { environment -> // Modify the environment based on agent context environment.copy( variables = environment.variables + mapOf("customVar" to "value") )} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMCallCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallCompletedContext) -> Unit)
```

Intercepts LLM calls after they are made to process or log the response.

- feature — The feature associated with this handler.
- handle — The handler that processes after-LLM-call eventsExample:pipeline.interceptLLMCallCompleted(feature) { eventContext -> // Process or analyze the response} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMCallFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallFailedContext) -> Unit)
```

Intercepts errors during LLM calls.

- feature — The feature associated with this handler.
- handle — The handler that processes LLM call errors.Example:pipeline.interceptLLMCallFailed(feature) { eventContext -> // Handle the error here} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMCallStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallStartingContext) -> Unit)
```

Intercepts LLM calls before they are made to modify or log the prompt.

- feature — The feature associated with this handler.
- handle — The handler that processes before-LLM-call eventsExample:pipeline.interceptLLMCallStarting(feature) { eventContext -> logger.info("About to make LLM call with prompt: ${eventContext.prompt.messages.last().content}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-streaming-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMStreamingCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingCompletedContext) -> Unit)
```

Intercepts streaming operations after they complete to perform post-processing or cleanup.

This method allows features to hook into the streaming pipeline after streaming finishes, enabling post-processing, cleanup, or final logging of the streaming session.

- feature — The feature associated with this handler.
- handle — The handler that processes after-stream eventsExample:pipeline.interceptLLMStreamingCompleted(feature) { eventContext -> logger.info("Streaming completed for run: ${eventContext.runId}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-streaming-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMStreamingFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingFailedContext) -> Unit)
```

Intercepts errors during the streaming process.

- feature — The feature associated with this handler.
- handle — The handler that processes stream errors

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-streaming-frame-received.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMStreamingFrameReceived(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingFrameReceivedContext) -> Unit)
```

Intercepts stream frames as they are received during the streaming process.

This method allows features to process individual stream frames in real-time, enabling monitoring, transformation, or aggregation of streaming content.

- feature — The feature associated with this handler.
- handle — The handler that processes stream frame eventsExample:pipeline.interceptLLMStreamingFrameReceived(feature) { eventContext -> logger.debug("Received stream frame: ${eventContext.streamFrame}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptLLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-l-l-m-streaming-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptLLMStreamingStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingStartingContext) -> Unit)
```

Intercepts streaming operations before they begin to modify or log the streaming request.

This method allows features to hook into the streaming pipeline before streaming starts, enabling preprocessing, validation, or logging of streaming requests.

- feature — The feature associated with this handler.
- handle — The handler that processes before-stream eventsExample:pipeline.interceptLLMStreamingStarting(feature) { eventContext -> logger.info("About to start streaming with prompt: ${eventContext.prompt.messages.last().content}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptStrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-strategy-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptStrategyCompleted(feature: AIAgentFeature<*, *>, handle: suspend (StrategyCompletedContext) -> Unit)
```

Sets up an interceptor to handle the completion of a strategy for the given feature.

- feature — The feature associated with this handler.
- handle — A suspend function that processes the completion of a strategy.Example:pipeline.interceptStrategyCompleted(feature) { event -> // Handle the completion of the strategy here} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptStrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-strategy-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptStrategyStarting(feature: AIAgentFeature<*, *>, handle: suspend (StrategyStartingContext) -> Unit)
```

Intercepts the strategy starting event to perform actions when an agent strategy begins execution.

- feature — The feature associated with this handler.
- handle — A suspend function that processes the start of a strategy, accepting the strategy contextExample:pipeline.interceptStrategyStarting(feature) { event -> val strategyName = event.strategy.name logger.info("Strategy $strategyName has started execution")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-tool-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptToolCallCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallCompletedContext) -> Unit)
```

Intercepts the result of a tool call with a custom handler for a specific feature.

- feature — The feature associated with this handler.
- handle — A suspending function that defines the behavior to execute when a tool call result is intercepted.Example:pipeline.interceptToolCallCompleted(feature) { eventContext -> // Handle the tool call result here} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-tool-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptToolCallFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallFailedContext) -> Unit)
```

Sets up an interception mechanism to handle tool call failures for a specific feature.

- feature — The feature associated with this handler.
- handle — A suspend function that is invoked when a tool call fails.Example:pipeline.interceptToolCallFailed(feature) { eventContext -> // Handle the tool call failure here} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-tool-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptToolCallStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallStartingContext) -> Unit)
```

Intercepts and handles tool calls for the specified feature.

- feature — The feature associated with this handler.
- handle — A suspend lambda function that processes tool calls.Example:pipeline.interceptToolCallStarting(feature) { eventContext -> // Process or log the tool call} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.interceptToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/intercept-tool-validation-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptToolValidationFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolValidationFailedContext) -> Unit)
```

Intercepts validation errors encountered during the execution of tools associated with the specified feature.

- feature — The feature associated with this handler.
- handle — A suspendable lambda function that will be invoked when a tool validation error occurs.Example:pipeline.interceptToolValidationFailed(feature) { eventContext -> // Handle the tool validation error here} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onAgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-agent-closing.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onAgentClosing(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>)
```

Invoked before an agent is closed to perform necessary pre-closure operations.

- eventId — The unique identifier for the event group.
- executionInfo — The execution information for the agent environment transformation event
- agent — The agent instance that will be closed.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onAgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-agent-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onAgentCompleted(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, result: Any?)
```

Notifies all registered handlers that an agent has finished execution.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the agent environment transformation event;
- agent — The agent instance that finished execution;
- context — The context of the strategy execution;
- runId — The unique identifier of the agent run;
- result — The result produced by the agent, or null if no result was produced.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onAgentEnvironmentTransforming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-agent-environment-transforming.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onAgentEnvironmentTransforming(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, baseEnvironment: AIAgentEnvironment): AIAgentEnvironment
```

Transforms the agent environment by applying all registered environment transformers.

This method allows features to modify or enhance the agent's environment before it starts execution. Each registered handler can apply its own transformations to the environment in sequence.

The transformed environment after all handlers have been applied

- eventId — The unique identifier for the event group.
- executionInfo — The execution information for the agent environment transformation event
- agent — The agent instance for which the environment is being transformed
- baseEnvironment — The initial environment to be transformed

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onAgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-agent-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onAgentExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, error: Throwable)
```

Notifies all registered handlers about an error that occurred during agent execution.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the agent environment transformation event;
- agent — The agent instance that encountered the error;
- context — The context of the strategy execution;
- runId — The unique identifier of the agent run;
- error — The Throwable exception instance that was thrown during agent execution.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onAgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-agent-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun <TInput, TOutput> onAgentStarting(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String)
```

Notifies all registered handlers that an agent has started execution.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the agent environment transformation event;
- agent — The agent instance for which the execution has started;
- context — The context of the agent execution, providing access to the agent environment and context features;
- runId — The unique identifier for the agent run.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMCallCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant?, moderationResponse: ModerationResult? = null)
```

Notifies all registered LLM handlers after a language model call has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM call event;
- context — The context of the LLM call execution;
- runId — Identifier for the current run;
- prompt — The prompt that was sent to the language model;
- model — The language model instance that processed the request;
- tools — The list of tool descriptors that were available for the LLM call;
- response — The response messages received from the language model;
- moderationResponse — The moderation response, if any, received from the language model.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMCallFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, error: Throwable)
```

Notifies all registered LLM handlers if a validation error occurs during a language model call.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM call event;
- context — The context of the strategy execution;
- runId — Identifier for the current run;
- prompt — The prompt that was sent to the language model;
- model — The language model instance that processed the request;
- tools — The list of tool descriptors that were available for the LLM call;
- error — The error that occurred during the LLM call.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMCallStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```

Notifies all registered LLM handlers before a language model call is made.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM call event;
- context — The context of the LLM call execution;
- runId — The unique identifier for the current run;
- prompt — The prompt that will be sent to the language model;
- model — The language model instance that will process the request;
- tools — The list of tool descriptors available for the LLM call.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-streaming-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMStreamingCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```

Invoked after streaming from a language model completes.

This method notifies all registered stream handlers that streaming has finished, allowing them to perform post-processing, cleanup, or final logging operations.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM streaming event;
- context — The context of the strategy execution;
- runId — The unique identifier for this streaming session;
- prompt — The prompt that was sent to the language model;
- model — The language model that was used for streaming;
- tools — The list of tool descriptors that were available for this streaming session.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-streaming-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMStreamingFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, error: Throwable)
```

Invoked if an error occurs during the streaming process.

This method notifies all registered stream handlers about the streaming error, allowing them to handle or log the error.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM streaming event;
- context — The context of the strategy execution;
- runId — The unique identifier for this streaming session;
- prompt — The prompt being sent to the language model;
- model — The language model being used for streaming;
- error — The exception that occurred during streaming if applicable.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-streaming-frame-received.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMStreamingFrameReceived(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, streamFrame: StreamFrame)
```

Invoked when a stream frame is received during the streaming process.

This method notifies all registered stream handlers about each incoming stream frame, allowing them to process, transform, or aggregate the streaming content in real-time.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM streaming event;
- context — The context of the strategy execution;
- runId — The unique identifier for this streaming session;
- prompt — The prompt being sent to the language model;
- model — The language model being used for streaming;
- streamFrame — The individual stream frame containing partial response data.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onLLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-l-l-m-streaming-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onLLMStreamingStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```

Invoked before streaming from a language model begins.

This method notifies all registered stream handlers that streaming is about to start, allowing them to perform preprocessing or logging operations.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the LLM streaming event;
- context — The context of the strategy execution;
- runId — The unique identifier for this streaming session;
- prompt — The prompt being sent to the language model;
- model — The language model being used for streaming;
- tools — The list of available tool descriptors for this streaming session.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onStrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-strategy-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onStrategyCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, result: Any?, resultType: TypeToken)
```

Notifies all registered strategy handlers that a strategy has finished execution.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the strategy event;
- context — The context of the strategy execution;
- strategy — The strategy that has finished execution;
- result — The result produced by the strategy execution;
- resultType — The type token of the result produced by the strategy execution.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onStrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-strategy-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onStrategyStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, input: Any?)
```

Notifies all registered strategy handlers that a strategy has started execution.

- eventId — The unique identifier for the event group.
- executionInfo — The execution information for the strategy event
- context — The context of the strategy execution
- strategy — The strategy that has started execution
- input — The input passed to the strategy

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-tool-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onToolCallCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, toolResult: JSONElement?)
```

Notifies all registered tool handlers about the result of a tool call.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the tool call agent event;
- context — The context of the strategy execution;
- runId — The unique identifier for the current run;
- toolCallId — The unique identifier for the current tool call;
- toolName — The tool name that was called;
- toolDescription — The description of the tool that was called;
- toolArgs — The arguments that were provided to the tool;
- toolResult — The result produced by the tool, or null if no result was produced.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-tool-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onToolCallFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable?)
```

Notifies all registered tool handlers when a tool call fails with an exception.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the tool call agent event;
- context — The context of the strategy execution;
- runId — The unique identifier for the current run;
- toolCallId — The unique identifier for the current tool call;
- toolName — The tool name that was called;
- toolDescription — The description of the tool that was called;
- toolArgs — The arguments provided to the tool;
- message — A message describing the failure;
- error — The exception that caused the failure, or null if no exception is available.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-tool-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onToolCallStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject)
```

Notifies all registered tool handlers when a tool is called.

- eventId — The unique identifier for the current event.
- executionInfo — The execution information for the tool call event
- runId — The unique identifier for the current run;
- toolCallId — The unique identifier for the current tool call;
- toolName — The tool name that is being called;
- toolDescription — The description of the tool that is being called;
- toolArgs — The arguments provided to the tool;
- context — The context of the strategy execution;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.onToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/on-tool-validation-failed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onToolValidationFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable)
```

Notifies all registered tool handlers when a validation error occurs during a tool call.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the tool call event;
- context — The context of the strategy execution;
- runId — The unique identifier for the current run;
- toolCallId — The unique identifier for the current tool call;
- toolName — The name of the tool for which validation failed;
- toolDescription — The description of the tool that was called;
- toolArgs — The arguments that failed validation;
- message — The validation error message;
- error — The validation error exception;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.prepareFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/prepare-features.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun prepareFeatures()
```

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.provideToolCallMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/provide-tool-call-metadata.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun provideToolCallMetadata(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallStartingContext) -> Map<String, Any?>)
```

Registers a handler that contributes per-call metadata before a tool executes.

The handler receives the same ToolCallStartingContext as interceptToolCallStarting and returns a Map<String, Any?> that is merged into the metadata passed to ai.koog.agents.core.tools.Tool.execute.

- feature — The feature associated with this handler.
- handle — A suspend function returning the metadata entries this feature wants to contribute.Example:pipeline.provideToolCallMetadata(feature) { eventContext -> mapOf("trace.span.id" to currentSpan()?.id)} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipeline.uninstall

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline/uninstall.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun uninstall(featureKey: AIAgentStorageKey<*>)
```

Uninstalls the specified feature associated with the given key from storage.

- featureKey — The key identifying the feature to be uninstalled.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/clock.html`

### :agents:agents-core/commonMain

```kotlin
abstract val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.closeAllFeaturesMessageProcessors

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/close-all-features-message-processors.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun closeAllFeaturesMessageProcessors()
```

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.collectToolCallMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/collect-tool-call-metadata.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun collectToolCallMetadata(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, context: AIAgentContext): ToolCallMetadata
```

Collects metadata contributions from every feature that registered a handler via provideToolCallMetadata and returns the combined map.

Contributions are merged in feature installation order; later contributions overwrite earlier ones on key collision. The caller of ai.koog.agents.core.environment.AIAgentEnvironment.executeTool is responsible for choosing a precedence when mixing this result with caller-supplied metadata.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/config.html`

### :agents:agents-core/commonMain

```kotlin
abstract val config: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.feature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/feature.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun <TFeature : Any> feature(featureClass: KClass<TFeature>, feature: AIAgentFeature<*, TFeature>): TFeature?
```


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentPipelineAPI
```

Platform-agnostic API for agent pipelines. Implemented by both the expect/actual AIAgentPipeline and the shared AIAgentPipelineImpl.

- AIAgentGraphPipelineAPI
- AIAgentPipelineImpl
- AIAgentPlannerPipelineAPI
- AIAgentPlannerPipelineImpl
- AIAgentPipeline
## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/install.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun <TConfig : FeatureConfig, TFeatureImpl : Any> install(featureKey: AIAgentStorageKey<TFeatureImpl>, featureConfig: TConfig, featureImpl: TFeatureImpl)
```


Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptAgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-agent-closing.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptAgentClosing(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentClosingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptAgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-agent-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptAgentCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptAgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-agent-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptAgentExecutionFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentExecutionFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptAgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-agent-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptAgentStarting(feature: AIAgentFeature<*, *>, handle: suspend (AgentStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptEnvironmentCreated

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-environment-created.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptEnvironmentCreated(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentEnvironmentTransformingContext, environment: AIAgentEnvironment) -> AIAgentEnvironment)
```


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMCallCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMCallFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMCallStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-streaming-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMStreamingCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-streaming-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMStreamingFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-streaming-frame-received.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMStreamingFrameReceived(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingFrameReceivedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptLLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-l-l-m-streaming-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptLLMStreamingStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptStrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-strategy-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptStrategyCompleted(feature: AIAgentFeature<*, *>, handle: suspend (StrategyCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptStrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-strategy-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptStrategyStarting(feature: AIAgentFeature<*, *>, handle: suspend (StrategyStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-tool-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptToolCallCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-tool-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptToolCallFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-tool-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptToolCallStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.interceptToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/intercept-tool-validation-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptToolValidationFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolValidationFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onAgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-agent-closing.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onAgentClosing(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onAgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-agent-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onAgentCompleted(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, result: Any?)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onAgentEnvironmentTransforming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-agent-environment-transforming.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onAgentEnvironmentTransforming(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, baseEnvironment: AIAgentEnvironment): AIAgentEnvironment
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onAgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-agent-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onAgentExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onAgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-agent-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun <TInput, TOutput> onAgentStarting(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMCallCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant?, moderationResponse: ModerationResult? = null)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMCallFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMCallStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-streaming-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMStreamingCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-streaming-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMStreamingFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-streaming-frame-received.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMStreamingFrameReceived(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, streamFrame: StreamFrame)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onLLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-l-l-m-streaming-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onLLMStreamingStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onStrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-strategy-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onStrategyCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, result: Any?, resultType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onStrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-strategy-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onStrategyStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, input: Any?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-tool-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onToolCallCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, toolResult: JSONElement?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-tool-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onToolCallFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-tool-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onToolCallStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.onToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/on-tool-validation-failed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onToolValidationFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.prepareFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/prepare-features.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun prepareFeatures()
```

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.provideToolCallMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/provide-tool-call-metadata.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun provideToolCallMetadata(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallStartingContext) -> Map<String, Any?>)
```

Registers a handler that contributes metadata for every tool call.

The handler fires before the tool executes, receives the same ToolCallStartingContext used by interceptToolCallStarting, and returns a Map<String, Any?> of values to merge into the metadata threaded into ai.koog.agents.core.tools.Tool.execute.

Use this to attach cross-cutting per-call context (trace span id, correlation id, feature flags) without expanding the tool's argument schema. Return an empty map to contribute nothing.

Merge precedence (documented in ai.koog.agents.core.environment.ContextualAgentEnvironment): caller-supplied metadata wins over feature contributions on key collision.


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineAPI.uninstall

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-a-p-i/uninstall.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun uninstall(featureKey: AIAgentStorageKey<*>)
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.AIAgentPipelineImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/-a-i-agent-pipeline-impl.html`

### :agents:agents-core/commonMain

```kotlin
constructor(config: AIAgentConfig, clock: KoogClock)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/clock.html`

### :agents:agents-core/commonMain

```kotlin
open override val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.closeAllFeaturesMessageProcessors

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/close-all-features-message-processors.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun closeAllFeaturesMessageProcessors()
```

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.collectToolCallMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/collect-tool-call-metadata.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun collectToolCallMetadata(eventId: String, executionInfo: AgentExecutionInfo, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, context: AIAgentContext): ToolCallMetadata
```

Collects metadata contributions from every feature that registered a handler via provideToolCallMetadata and returns the combined map.

Contributions are merged in feature installation order; later contributions overwrite earlier ones on key collision. The caller of ai.koog.agents.core.environment.AIAgentEnvironment.executeTool is responsible for choosing a precedence when mixing this result with caller-supplied metadata.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/config.html`

### :agents:agents-core/commonMain

```kotlin
open override val config: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.feature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/feature.html`

### :agents:agents-core/commonMain

```kotlin
open override fun <TFeature : Any> feature(featureClass: KClass<TFeature>, feature: AIAgentFeature<*, TFeature>): TFeature?
```


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentPipelineImpl(val config: AIAgentConfig, val clock: KoogClock) : AIAgentPipelineAPI
```

Default implementation of AIAgentPipelineAPI


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/install.html`

### :agents:agents-core/commonMain

```kotlin
open override fun <TConfig : FeatureConfig, TFeatureImpl : Any> install(featureKey: AIAgentStorageKey<TFeatureImpl>, featureConfig: TConfig, featureImpl: TFeatureImpl)
```


Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptAgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-agent-closing.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptAgentClosing(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentClosingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptAgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-agent-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptAgentCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptAgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-agent-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptAgentExecutionFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: AgentExecutionFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptAgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-agent-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptAgentStarting(feature: AIAgentFeature<*, *>, handle: suspend (AgentStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptEnvironmentCreated

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-environment-created.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptEnvironmentCreated(feature: AIAgentFeature<*, *>, handle: suspend (AgentEnvironmentTransformingContext, AIAgentEnvironment) -> AIAgentEnvironment)
```


Referenced packages: `ai.koog.agents.core.environment`, `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMCallCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMCallFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMCallStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMCallStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-streaming-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMStreamingCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-streaming-failed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMStreamingFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-streaming-frame-received.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMStreamingFrameReceived(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingFrameReceivedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptLLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-l-l-m-streaming-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptLLMStreamingStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: LLMStreamingStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptStrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-strategy-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptStrategyCompleted(feature: AIAgentFeature<*, *>, handle: suspend (StrategyCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptStrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-strategy-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptStrategyStarting(feature: AIAgentFeature<*, *>, handle: suspend (StrategyStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-tool-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptToolCallCompleted(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallCompletedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-tool-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptToolCallFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-tool-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptToolCallStarting(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallStartingContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.interceptToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/intercept-tool-validation-failed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptToolValidationFailed(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolValidationFailedContext) -> Unit)
```


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onAgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-agent-closing.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onAgentClosing(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onAgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-agent-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onAgentCompleted(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, result: Any?)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onAgentEnvironmentTransforming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-agent-environment-transforming.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onAgentEnvironmentTransforming(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, baseEnvironment: AIAgentEnvironment): AIAgentEnvironment
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.environment`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onAgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-agent-execution-failed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onAgentExecutionFailed(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onAgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-agent-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun <TInput, TOutput> onAgentStarting(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMCallCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant?, moderationResponse: ModerationResult? = null)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMCallFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMCallStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-streaming-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMStreamingCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-streaming-failed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMStreamingFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-streaming-frame-received.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMStreamingFrameReceived(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, streamFrame: StreamFrame)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onLLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-l-l-m-streaming-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onLLMStreamingStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onStrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-strategy-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onStrategyCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, result: Any?, resultType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onStrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-strategy-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onStrategyStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, input: Any?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-tool-call-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onToolCallCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, toolResult: JSONElement?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-tool-call-failed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onToolCallFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-tool-call-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onToolCallStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.onToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/on-tool-validation-failed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onToolValidationFailed(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.prepareFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/prepare-features.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun prepareFeatures()
```

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.provideToolCallMetadata

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/provide-tool-call-metadata.html`

### :agents:agents-core/commonMain

```kotlin
open override fun provideToolCallMetadata(feature: AIAgentFeature<*, *>, handle: suspend (eventContext: ToolCallStartingContext) -> Map<String, Any?>)
```

Registers a handler that contributes metadata for every tool call.

The handler fires before the tool executes, receives the same ToolCallStartingContext used by interceptToolCallStarting, and returns a Map<String, Any?> of values to merge into the metadata threaded into ai.koog.agents.core.tools.Tool.execute.

Use this to attach cross-cutting per-call context (trace span id, correlation id, feature flags) without expanding the tool's argument schema. Return an empty map to contribute nothing.

Merge precedence (documented in ai.koog.agents.core.environment.ContextualAgentEnvironment): caller-supplied metadata wins over feature contributions on key collision.


Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.core.feature.pipeline.AIAgentPipelineImpl.uninstall

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-pipeline-impl/uninstall.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun uninstall(featureKey: AIAgentStorageKey<*>)
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.AIAgentPlannerPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/-a-i-agent-planner-pipeline.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System, basePipelineDelegate: AIAgentPipelineImpl = AIAgentPipelineImpl(agentConfig, clock))
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(agentConfig: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock, basePipelineDelegate: AIAgentPipelineImpl)
```


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(agentConfig: AIAgentConfig, clock: KoogClock, basePipelineDelegate: AIAgentPipelineImpl)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/index.html`

### :agents:agents-core/commonMain

```kotlin
expect open class AIAgentPlannerPipeline : AIAgentPipeline, AIAgentPlannerPipelineAPI
```

Represents a specific implementation of an AI agent pipeline that uses a planner approach.

### :agents:agents-core/jvmCommonMain

```kotlin
actual open class AIAgentPlannerPipeline : AIAgentPipeline, AIAgentPlannerPipelineAPI
```

Represents a specific implementation of an AI agent pipeline that uses a planner approach.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open class AIAgentPlannerPipeline : AIAgentPipeline, AIAgentPlannerPipelineAPI
```

Represents a specific implementation of an AI agent pipeline that uses a planner approach.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/install.html`

### :agents:agents-core/commonMain

```kotlin
expect fun <TConfig : FeatureConfig, TFeature : Any> install(feature: AIAgentPlannerFeature<TConfig, TFeature>, configure: TConfig.() -> Unit)
```

Installs a planner feature into the pipeline with the provided configuration.

- feature — The feature implementation to be installed;
- configure — A lambda to customize the feature configuration.
- TConfig — The type of the feature configuration;
- TFeature — The type of the feature being installed;

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual fun <TConfig : FeatureConfig, TFeature : Any> install(feature: AIAgentPlannerFeature<TConfig, TFeature>, configure: TConfig.() -> Unit)
```

Installs a non-graph feature into the pipeline with the provided configuration.

- feature — The feature implementation to be installed
- configure — A lambda to customize the feature configuration
- TConfig — The type of the feature configuration
- TFeature — The type of the feature being installed

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun <TConfig : FeatureConfig, TFeature : Any> install(feature: AIAgentPlannerFeature<TConfig, TFeature>, configure: TConfig.() -> Unit)
```

Installs a non-graph feature into the pipeline with the provided configuration.

- feature — The feature implementation to be installed
- configure — A lambda to customize the feature configuration
- TConfig — The type of the feature configuration
- TFeature — The type of the feature being installed

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.interceptPlanCompletionEvaluationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/intercept-plan-completion-evaluation-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptPlanCompletionEvaluationCompleted(feature: AIAgentFeature<*, *>, handle: suspend (PlanCompletionEvaluationCompletedContext) -> Unit)
```

Intercepts plan completion evaluation completed event to perform actions when a plan is evaluated for completion.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a plan completion evaluation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.interceptPlanCompletionEvaluationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/intercept-plan-completion-evaluation-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptPlanCompletionEvaluationStarting(feature: AIAgentFeature<*, *>, handle: suspend (PlanCompletionEvaluationStartingContext) -> Unit)
```

Intercepts plan completion evaluation starting event to perform actions when a plan is about to be evaluated for completion.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a plan completion evaluation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.interceptPlanCreationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/intercept-plan-creation-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptPlanCreationCompleted(feature: AIAgentFeature<*, *>, handle: suspend (PlanCreationCompletedContext) -> Unit)
```

Intercepts plan creation completed event to perform actions when a plan completes creation.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a plan creation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.interceptPlanCreationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/intercept-plan-creation-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptPlanCreationStarting(feature: AIAgentFeature<*, *>, handle: suspend (PlanCreationStartingContext) -> Unit)
```

Intercepts plan creation starting event to perform actions when a plan begins creation.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a plan creation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.interceptStepExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/intercept-step-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptStepExecutionCompleted(feature: AIAgentFeature<*, *>, handle: suspend (StepExecutionCompletedContext) -> Unit)
```

Intercepts step execution completed event to perform actions when a plan step completes execution.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a step execution.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.interceptStepExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/intercept-step-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open override fun interceptStepExecutionStarting(feature: AIAgentFeature<*, *>, handle: suspend (StepExecutionStartingContext) -> Unit)
```

Intercepts step execution starting event to perform actions when a plan step begins execution.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a step execution.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.onPlanCompletionEvaluationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/on-plan-completion-evaluation-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onPlanCompletionEvaluationCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int, isCompleted: Boolean)
```

Notifies all registered planner handlers when a plan-completion check has been evaluated.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the evaluation event;
- context — The context of the plan execution;
- state — The current state;
- plan — The plan being evaluated for completion;
- stepIndex — The index of the step in the plan;
- isCompleted — The result of the completion check.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.onPlanCompletionEvaluationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/on-plan-completion-evaluation-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onPlanCompletionEvaluationStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers when a plan-completion check is about to be evaluated.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the evaluation event;
- context — The context of the plan execution;
- state — The current state;
- plan — The plan being evaluated for completion;
- stepIndex — The index of the step in the plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.onPlanCreationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/on-plan-creation-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onPlanCreationCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int, updatedPlan: Any)
```

Notifies all registered planner handlers that a plan creation has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the plan creation event;
- context — The context of the plan creation;
- state — The current state;
- plan — The previous plan, or null if this is the first plan;
- stepIndex — The index of the step in the plan;
- updatedPlan — The newly built plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.onPlanCreationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/on-plan-creation-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onPlanCreationStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan creation has started.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the plan creation event;
- context — The context of the plan creation;
- state — The current state;
- plan — The current plan, or null if this is the first plan;
- stepIndex — The index of the step in the plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.onStepExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/on-step-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onStepExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan step execution has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the step execution event;
- context — The context of the step execution;
- state — The state after step execution;
- plan — The plan that completed execution;
- stepIndex — The index of the step in the plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.onStepExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline/on-step-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun onStepExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan step execution has started.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the step execution event;
- context — The context of the step execution;
- state — The current state;
- plan — The plan that is starting execution;
- stepIndex — The index of the step in the plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentPlannerPipelineAPI : AIAgentPipelineAPI
```

Platform-agnostic API for planner agent pipelines, extending the base pipeline API with planner-specific functionality.

- AIAgentPlannerPipelineImpl
- AIAgentPlannerPipeline
## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.interceptPlanCompletionEvaluationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/intercept-plan-completion-evaluation-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptPlanCompletionEvaluationCompleted(feature: AIAgentFeature<*, *>, handle: suspend (PlanCompletionEvaluationCompletedContext) -> Unit)
```

Intercepts plan completion evaluation completed event to perform actions when a plan is evaluated for completion.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a plan completion evaluation.Example:pipeline.interceptPlanCompletionEvaluationCompleted(feature) { event -> logger.info("Plan completion evaluated as: ${event.isCompleted}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.interceptPlanCompletionEvaluationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/intercept-plan-completion-evaluation-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptPlanCompletionEvaluationStarting(feature: AIAgentFeature<*, *>, handle: suspend (PlanCompletionEvaluationStartingContext) -> Unit)
```

Intercepts plan completion evaluation starting event to perform actions when a plan is about to be evaluated for completion.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a plan completion evaluation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.interceptPlanCreationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/intercept-plan-creation-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptPlanCreationCompleted(feature: AIAgentFeature<*, *>, handle: suspend (PlanCreationCompletedContext) -> Unit)
```

Intercepts plan creation completed event to perform actions when a plan completes creation.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a plan creation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.interceptPlanCreationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/intercept-plan-creation-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptPlanCreationStarting(feature: AIAgentFeature<*, *>, handle: suspend (PlanCreationStartingContext) -> Unit)
```

Intercepts plan creation starting event to perform actions when a plan begins creation.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a plan creation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.interceptStepExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/intercept-step-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptStepExecutionCompleted(feature: AIAgentFeature<*, *>, handle: suspend (StepExecutionCompletedContext) -> Unit)
```

Intercepts step execution completed event to perform actions when a plan step completes execution.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a step execution.Example:pipeline.interceptStepExecutionCompleted(feature) { event -> logger.info("Step ${event.stepIndex} execution has completed")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.interceptStepExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/intercept-step-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun interceptStepExecutionStarting(feature: AIAgentFeature<*, *>, handle: suspend (StepExecutionStartingContext) -> Unit)
```

Intercepts step execution starting event to perform actions when a plan step begins execution.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a step execution.Example:pipeline.interceptStepExecutionStarting(feature) { event -> logger.info("Step ${event.stepIndex} execution has started")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.onPlanCompletionEvaluationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/on-plan-completion-evaluation-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onPlanCompletionEvaluationCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int, isCompleted: Boolean)
```

Notifies all registered planner handlers when evaluating whether a plan is completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the evaluation event;
- context — The context of the plan execution;
- state — The current state;
- plan — The plan being evaluated for completion;
- stepIndex — The index of the step in the plan;
- isCompleted — The result of the completion check.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.onPlanCompletionEvaluationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/on-plan-completion-evaluation-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onPlanCompletionEvaluationStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers when evaluating whether a plan is completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the evaluation event;
- context — The context of the plan execution;
- state — The current state;
- plan — The plan being evaluated for completion;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.onPlanCreationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/on-plan-creation-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onPlanCreationCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int, updatedPlan: Any)
```

Notifies all registered planner handlers that a plan creation has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the plan creation event;
- context — The context of the plan creation;
- state — The current state;
- plan — The previous plan, or null if this is the first plan;
- stepIndex — The index of the step in the plan;
- updatedPlan — The newly built plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.onPlanCreationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/on-plan-creation-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onPlanCreationStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan creation has started.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the plan creation event;
- context — The context of the plan creation;
- plan — The plan that is starting creation;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.onStepExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/on-step-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onStepExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan step execution has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the step execution event;
- context — The context of the step execution;
- state — The state after step execution;
- plan — The plan that completed execution;
- stepIndex — The index of the step in the plan;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineAPI.onStepExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-a-p-i/on-step-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun onStepExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan step execution has started.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the step execution event;
- context — The context of the step execution;
- state — The current state;
- plan — The plan that is starting execution;
- stepIndex — The index of the step in the plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.AIAgentPlannerPipelineImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/-a-i-agent-planner-pipeline-impl.html`

### :agents:agents-core/commonMain

```kotlin
constructor(config: AIAgentConfig, clock: KoogClock = KoogClock.System, basePipelineDelegate: AIAgentPipelineImpl)
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentPlannerPipelineImpl(config: AIAgentConfig, clock: KoogClock = KoogClock.System, basePipelineDelegate: AIAgentPipelineImpl) : AIAgentPlannerPipelineAPI, AIAgentPipelineAPI
```

Default implementation of AIAgentPlannerPipelineAPI that delegates base pipeline operations to AIAgentPipelineImpl and implements planner-specific functionality.


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.utils.time`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.interceptPlanCompletionEvaluationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/intercept-plan-completion-evaluation-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptPlanCompletionEvaluationCompleted(feature: AIAgentFeature<*, *>, handle: suspend (PlanCompletionEvaluationCompletedContext) -> Unit)
```

Intercepts plan completion evaluation completed event to perform actions when a plan is evaluated for completion.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a plan completion evaluation.Example:pipeline.interceptPlanCompletionEvaluationCompleted(feature) { event -> logger.info("Plan completion evaluated as: ${event.isCompleted}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.interceptPlanCompletionEvaluationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/intercept-plan-completion-evaluation-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptPlanCompletionEvaluationStarting(feature: AIAgentFeature<*, *>, handle: suspend (PlanCompletionEvaluationStartingContext) -> Unit)
```

Intercepts plan completion evaluation starting event to perform actions when a plan is about to be evaluated for completion.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a plan completion evaluation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.interceptPlanCreationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/intercept-plan-creation-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptPlanCreationCompleted(feature: AIAgentFeature<*, *>, handle: suspend (PlanCreationCompletedContext) -> Unit)
```

Intercepts plan creation completed event to perform actions when a plan completes creation.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a plan creation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.interceptPlanCreationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/intercept-plan-creation-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptPlanCreationStarting(feature: AIAgentFeature<*, *>, handle: suspend (PlanCreationStartingContext) -> Unit)
```

Intercepts plan creation starting event to perform actions when a plan begins creation.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a plan creation.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.interceptStepExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/intercept-step-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptStepExecutionCompleted(feature: AIAgentFeature<*, *>, handle: suspend (StepExecutionCompletedContext) -> Unit)
```

Intercepts step execution completed event to perform actions when a plan step completes execution.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the completion of a step execution.Example:pipeline.interceptStepExecutionCompleted(feature) { event -> logger.info("Step ${event.stepIndex} execution has completed")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.interceptStepExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/intercept-step-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
open override fun interceptStepExecutionStarting(feature: AIAgentFeature<*, *>, handle: suspend (StepExecutionStartingContext) -> Unit)
```

Intercepts step execution starting event to perform actions when a plan step begins execution.

- feature — The feature associated with this handler;
- handle — A suspend function that processes the start of a step execution.Example:pipeline.interceptStepExecutionStarting(feature) { event -> logger.info("Step ${event.stepIndex} execution has started")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.handler.planner`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.onPlanCompletionEvaluationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/on-plan-completion-evaluation-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onPlanCompletionEvaluationCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int, isCompleted: Boolean)
```

Notifies all registered planner handlers when evaluating whether a plan is completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the evaluation event;
- context — The context of the plan execution;
- state — The current state;
- plan — The plan being evaluated for completion;
- stepIndex — The index of the step in the plan;
- isCompleted — The result of the completion check.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.onPlanCompletionEvaluationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/on-plan-completion-evaluation-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onPlanCompletionEvaluationStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers when evaluating whether a plan is completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the evaluation event;
- context — The context of the plan execution;
- state — The current state;
- plan — The plan being evaluated for completion;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.onPlanCreationCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/on-plan-creation-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onPlanCreationCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int, updatedPlan: Any)
```

Notifies all registered planner handlers that a plan creation has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the plan creation event;
- context — The context of the plan creation;
- state — The current state;
- plan — The previous plan, or null if this is the first plan;
- stepIndex — The index of the step in the plan;
- updatedPlan — The newly built plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.onPlanCreationStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/on-plan-creation-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onPlanCreationStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan creation has started.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the plan creation event;
- context — The context of the plan creation;
- plan — The plan that is starting creation;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.onStepExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/on-step-execution-completed.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onStepExecutionCompleted(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan step execution has completed.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the step execution event;
- context — The context of the step execution;
- state — The state after step execution;
- plan — The plan that completed execution;
- stepIndex — The index of the step in the plan;

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipelineImpl.onStepExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-a-i-agent-planner-pipeline-impl/on-step-execution-starting.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun onStepExecutionStarting(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```

Notifies all registered planner handlers that a plan step execution has started.

- eventId — The unique identifier for the event group;
- executionInfo — The execution information for the step execution event;
- context — The context of the step execution;
- state — The current state;
- plan — The plan that is starting execution;
- stepIndex — The index of the step in the plan.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.pipeline.AsyncInterceptor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-async-interceptor/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface AsyncInterceptor<ContextT>
```

- ContextT — The type of the context object that the interceptor processes.
## ai.koog.agents.core.feature.pipeline.Interceptor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-interceptor/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface Interceptor<ContextT>
```

Represents an interceptor that can intercept and process a given context of type ContextT. This is a functional interface, allowing functional-style usage.

- ContextT — the type of the context to be intercepted.
## ai.koog.agents.core.feature.pipeline.Interceptor.intercept

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-interceptor/intercept.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun intercept(contextT: ContextT)
```

Intercepts the given context for custom processing or handling logic.

- contextT — the context to be intercepted.
## ai.koog.agents.core.feature.pipeline.RegisteredFeature.RegisteredFeature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-registered-feature/-registered-feature.html`

### :agents:agents-core/commonMain

```kotlin
constructor(featureImpl: Any, featureConfig: FeatureConfig)
```

- featureImpl — The feature implementation
- featureConfig — The feature configuration

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.RegisteredFeature.featureConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-registered-feature/feature-config.html`

### :agents:agents-core/commonMain

```kotlin
val featureConfig: FeatureConfig
```

- featureConfig — The feature configuration

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.RegisteredFeature.featureImpl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-registered-feature/feature-impl.html`

### :agents:agents-core/commonMain

```kotlin
val featureImpl: Any
```

- featureImpl — The feature implementation
## ai.koog.agents.core.feature.pipeline.RegisteredFeature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-registered-feature/index.html`

### :agents:agents-core/commonMain

```kotlin
class RegisteredFeature(val featureImpl: Any, val featureConfig: FeatureConfig)
```

Represents configured and installed agent feature implementation along with its configuration.

- featureImpl — The feature implementation
- featureConfig — The feature configuration

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.pipeline.TransformInterceptor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-transform-interceptor/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun interface TransformInterceptor<ContextT, DataT>
```

A functional interface designed to intercept and transform data of type DataT during processing, using a provided context of type ContextT.

Typically used in scenarios where a processing pipeline requires customizable transformations of data.

- ContextT — The type of the context passed to the transform function.
- DataT — The type of the data being transformed.
## ai.koog.agents.core.feature.pipeline.TransformInterceptor.transform

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.pipeline/-transform-interceptor/transform.html`

### :agents:agents-core/jvmCommonMain

```kotlin
abstract fun transform(contextT: ContextT, data: DataT): DataT
```

Processes and transforms the provided data within the given context.

The transformed data.

- contextT — The context in which the operation is performed.
- data — The data to be transformed.
## ai.koog.agents.core.feature.remote.ConnectionConfig.ConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote/-connection-config/-connection-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

## ai.koog.agents.core.feature.remote.ConnectionConfig.appendSerializersModule

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote/-connection-config/append-serializers-module.html`

### :agents:agents-core/commonMain

```kotlin
fun appendSerializersModule(module: SerializersModule)
```

Appends the specified serializers module to the existing JSON configuration. This method allows dynamic addition of custom serialization and deserialization logic by merging the provided module with the current serializers module.

- module — The serializers module that needs to be appended to the existing JSON configuration.
## ai.koog.agents.core.feature.remote.ConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote/-connection-config/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class ConnectionConfig
```

Represents a configuration for managing a custom JSON serialization and deserialization setup in the context of feature message handling and remote communication.

This abstract class provides mechanisms to work with a configurable Json instance and allows appending additional serializers modules dynamically.

- ClientConnectionConfig
- ServerConnectionConfig
## ai.koog.agents.core.feature.remote.ConnectionConfig.jsonConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote/-connection-config/json-config.html`

### :agents:agents-core/commonMain

```kotlin
val jsonConfig: Json
```

Provides access to the current JSON serialization and deserialization configuration.

This property is used to retrieve the configured Json instance for handling feature messages and remote communication. It incorporates custom serialization modules and settings designed for efficient processing of ai.koog.agents.core.feature.message.FeatureMessage objects.

The configuration can be modified dynamically by appending additional serializer modules to accommodate new data types or adjust serialization behavior.

This property is commonly used in contexts where the serialization or deserialization of messages, such as ai.koog.agents.core.feature.message.FeatureMessage, is required for communication between systems.

The current Json instance used for serialization and deserialization.

## ai.koog.agents.core.feature.remote.defaultFeatureMessageJsonConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote/default-feature-message-json-config.html`

### :agents:agents-core/commonMain

```kotlin
val defaultFeatureMessageJsonConfig: Json
```

Provides a preconfigured instance of Json with specific settings tailored for serializing and deserializing feature messages in a remote communication context.

This configuration includes features such as

Enabling pretty printing of JSON for readability.

Ignoring unknown keys during deserialization to support backward and forward compatibility.

Encoding default values to ensure complete serialization of data.

Allowing lenient parsing for more flexible input handling.

Disabling explicit null representation to omit null fields when serializing.

Additionally, this Json instance is configured with a default serializers module, facilitating custom serialization logic for feature messages.

## ai.koog.agents.core.feature.remote.defaultFeatureMessageSerializersModule

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote/default-feature-message-serializers-module.html`

### :agents:agents-core/commonMain

```kotlin
val defaultFeatureMessageSerializersModule: SerializersModule
```

Provides a SerializersModule that handles polymorphic serialization and deserialization for various events and messages associated with features, agents, and strategies.

This module supports polymorphic serialization for the following base classes:

FeatureMessage

FeatureEvent

DefinedFeatureEvent

It registers the concrete subclasses of these base classes for serialization and deserialization:

AgentStartingEvent - Fired when an AI agent starts execution

AgentCompletedEvent - Fired when an AI agent completes execution

AgentClosingEvent - Fired before an AI agent is closed

AgentExecutionFailedEvent - Fired when an AI agent encounters a runtime error

StrategyStartingEvent - Fired when an AI agent strategy begins

StrategyCompletedEvent - Fired when an AI agent strategy completes

NodeExecutionStartingEvent - Fired when a node execution starts

NodeExecutionCompletedEvent - Fired when a node execution ends

ToolCallStartingEvent - Fired when a tool is called

ToolValidationFailedEvent - Fired when tool validation fails

ToolCallFailedEvent - Fired when a tool call fails

ToolCallCompletedEvent - Fired when a tool call returns a result

LLMCallStartingEvent - Fired before making an LLM call

LLMCallCompletedEvent - Fired after completing an LLM call

LLMCallFailedEvent - Fired when an LLM call fails

This configuration enables proper handling of the diverse event types encountered in the system by ensuring that the polymorphic serialization framework can correctly serialize and deserialize each subclass.

## ai.koog.agents.core.feature.remote.client.FeatureMessageClient.connect

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-client/connect.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun connect()
```

Establishes a connection to the remote feature messaging service.

This method initiates communication with the remote service based on the client's configuration and prepares it for sending and receiving feature-related messages. Upon successful completion, the client transitions to a connected state and isConnected will return true.

If an attempt to connect fails (e.g., due to networking issues or authentication errors), the method will throw an appropriate exception or error indicating the failure reason.

## ai.koog.agents.core.feature.remote.client.FeatureMessageClient.healthCheck

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-client/health-check.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun healthCheck()
```

Performs a health check to verify the status of the remote feature messaging service.

This method checks the availability and responsiveness of the service the client is connected to by making a health check request. It is intended to ensure that the remote service is operational and ready to handle requests. The health check may involve a lightweight request to a designated health check endpoint.

This operation is asynchronous and may suspend until the health check completes. If the health check fails, an exception may be thrown to indicate the failure.

It is recommended to perform a health check periodically, especially in scenarios with prolonged idle connections or before critical operations, to guarantee the remote service is in a healthy state.

## ai.koog.agents.core.feature.remote.client.FeatureMessageClient

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-client/index.html`

### :agents:agents-core/commonMain

```kotlin
interface FeatureMessageClient : Closeable
```

An interface representing a client to interact with a feature messaging system.

The client is responsible for:

Connecting to a remote feature messaging service;

Sending feature-related messages;

Performing periodic health checks to ensure the connection's integrity.

A client can be used in an IDE to receive remote events from the running agents to present collected agent state traces and show them inside this IDE.

- FeatureMessageRemoteClient

Referenced packages: `ai.koog.utils.io`.

## ai.koog.agents.core.feature.remote.client.FeatureMessageClient.isConnected

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-client/is-connected.html`

### :agents:agents-core/commonMain

```kotlin
abstract val isConnected: StateFlow<Boolean>
```

Indicates whether the client is currently connected to the remote feature messaging service.

This property reflects the connection state of the client. It is true if the client has successfully established a communication link with the remote service and false otherwise.

## ai.koog.agents.core.feature.remote.client.FeatureMessageClient.send

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-client/send.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun send(message: FeatureMessage)
```

Sends a feature-related message to the remote feature messaging service.

The method facilitates communication by delivering a FeatureMessage instance containing the relevant data and metadata, such as the timestamp and type. It should only be invoked when the client is in a connected state to ensure successful delivery. Failure to send the message, due to connectivity issues or other errors, will result in an exception being thrown.

- message — The FeatureMessage instance that encapsulates the details of the message to be sent, including its timestamp and type.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.FeatureMessageRemoteClient

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/-feature-message-remote-client.html`

### :agents:agents-core/commonMain

```kotlin
constructor(connectionConfig: ClientConnectionConfig, scope: CoroutineScope, baseClient: HttpClient = HttpClient(), requestBuilder: HttpRequestBuilder.() -> Unit = {})
```


Referenced packages: `ai.koog.agents.core.feature.remote.client.config`.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/close.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun close()
```

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.connect

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/connect.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun connect()
```

Establishes a connection to the remote feature messaging service.

This method initiates communication with the remote service based on the client's configuration and prepares it for sending and receiving feature-related messages. Upon successful completion, the client transitions to a connected state and isConnected will return true.

If an attempt to connect fails (e.g., due to networking issues or authentication errors), the method will throw an appropriate exception or error indicating the failure reason.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.connectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/connection-config.html`

### :agents:agents-core/commonMain

```kotlin
val connectionConfig: ClientConnectionConfig
```


Referenced packages: `ai.koog.agents.core.feature.remote.client.config`.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.healthCheck

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/health-check.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun healthCheck()
```

Performs a health check to verify the status of the remote feature messaging service.

This method checks the availability and responsiveness of the service the client is connected to by making a health check request. It is intended to ensure that the remote service is operational and ready to handle requests. The health check may involve a lightweight request to a designated health check endpoint.

This operation is asynchronous and may suspend until the health check completes. If the health check fails, an exception may be thrown to indicate the failure.

It is recommended to perform a health check periodically, especially in scenarios with prolonged idle connections or before critical operations, to guarantee the remote service is in a healthy state.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/index.html`

### :agents:agents-core/commonMain

```kotlin
class FeatureMessageRemoteClient(val connectionConfig: ClientConnectionConfig, scope: CoroutineScope, baseClient: HttpClient = HttpClient(), requestBuilder: HttpRequestBuilder.() -> Unit = {}) : FeatureMessageClient
```

A remote client implementation for handling feature messages via HTTP and Server-Sent Events (SSE).

Note: Please make sure you call connect before starting a communication process. If the server is not available, the method will throw the IllegalStateException exception.


Referenced packages: `ai.koog.agents.core.feature.remote.client.config`.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.isConnected

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/is-connected.html`

### :agents:agents-core/commonMain

```kotlin
open override val isConnected: StateFlow<Boolean>
```

Indicates whether the client is currently connected to the remote feature messaging service.

This property reflects the connection state of the FeatureMessageRemoteClient. It is true if the client has successfully established a valid connection with the remote service, and false otherwise. The connectivity is derived from the internal initialization state of the client.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.receivedMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/received-messages.html`

### :agents:agents-core/commonMain

```kotlin
val receivedMessages: Channel<FeatureMessage>
```

A communication channel for receiving feature messages or events.

This property is an instance of a Channel configured with unlimited capacity, ensuring that it can store any number of incoming FeatureMessage instances without blocking the sender. It is used to facilitate asynchronous communication with the remote feature messaging service by receiving and managing the lifecycle of feature-related messages.

Key behaviors:

Messages received from the remote service are sent through this channel for processing.

During the lifecycle of the client, messages are collected and handled as they arrive.

Closing the channel indicates the termination of the receiving process when the client shuts down.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.send

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client/-feature-message-remote-client/send.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun send(message: FeatureMessage)
```

Sends a feature-related message to the remote feature messaging service.

The method facilitates communication by delivering a FeatureMessage instance containing the relevant data and metadata, such as the timestamp and type. It should only be invoked when the client is in a connected state to ensure successful delivery. Failure to send the message, due to connectivity issues or other errors, will result in an exception being thrown.

- message — The FeatureMessage instance that encapsulates the details of the message to be sent, including its timestamp and type.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.ClientConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/-client-connection-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor(host: String, port: Int? = null, protocol: URLProtocol? = null, headers: Map<String, List<String>>? = null, reconnectionDelay: Duration? = null, requestTimeout: Duration? = null, connectTimeout: Duration? = null)
```

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.Companion.defaultProtocol

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/-companion/default-protocol.html`

### :agents:agents-core/commonMain

```kotlin
val defaultProtocol: URLProtocol
```

The default protocol used for establishing a client connection.

This value is set to URLProtocol.HTTPS, ensuring secure communication by default. It is used in classes such as ClientConnectionConfig and its implementations for initializing the protocol property when no specific protocol is provided.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

Companion object for the ClientConnectionConfig class.

Provides default configuration settings such as the default protocol used across instances of ClientConnectionConfig or its subclasses.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.connectTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/connect-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val connectTimeout: Duration?
```

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.headers

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/headers.html`

### :agents:agents-core/commonMain

```kotlin
val headers: Map<String, List<String>>
```

A collection of headers to be applied to HTTP requests made by the client.

This map with headers can be used to provide additional metadata, authentication information, or other HTTP-specific data required by the server.

If no headers are explicitly defined, this map defaults to an empty state, ensuring that requests do not include unnecessary headers.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.healthCheckUrl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/health-check-url.html`

### :agents:agents-core/commonMain

```kotlin
val healthCheckUrl: String
```

A computed property that constructs the URL endpoint for health check requests.

This property generates the URL by appending the "health" path segment to the base URL defined by the url property within the ClientConnectionConfig class.

The generated URL is intended to be used for verifying the availability and responsiveness of the remote server or service.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.host

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/host.html`

### :agents:agents-core/commonMain

```kotlin
val host: String
```

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class ClientConnectionConfig(val host: String, port: Int? = null, protocol: URLProtocol? = null, headers: Map<String, List<String>>? = null, val reconnectionDelay: Duration? = null, val requestTimeout: Duration? = null, val connectTimeout: Duration? = null) : ConnectionConfig
```

Base configuration class for managing client-side connections in a remote communication setup.

This abstract class is designed to provide configuration settings required to establish a client connection, such as protocol, host, port, custom headers, and timeout options. It includes utility properties for constructing URL endpoints corresponding to specific functionalities like Server-Sent Events (SSE), health checks, and message handling.

Subclasses can extend this base configuration to implement more specific connection requirements or initialize predefined settings suitable for particular use cases.

- DefaultClientConnectionConfig

Referenced packages: `ai.koog.agents.core.feature.remote`.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.messageUrl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/message-url.html`

### :agents:agents-core/commonMain

```kotlin
val messageUrl: String
```

Constructs the URL endpoint for sending or receiving messages.

This property is a computed value that combines the base url of the client connection configuration with the /message path segment. It is often used as the target URL for communication with the message handling endpoint of a remote server.

Common use cases include sending feature-related messages or retrieving messages from the server as part of a feature messaging system.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.port

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/port.html`

### :agents:agents-core/commonMain

```kotlin
val port: Int
```

The port number used for establishing a client connection.

This property determines the port to be used when constructing the connection URL. If no explicit port is specified during the configuration, the default port for the specified protocol (e.g., 80 for HTTP, 443 for HTTPS) will be used.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.protocol

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/protocol.html`

### :agents:agents-core/commonMain

```kotlin
val protocol: URLProtocol
```

The protocol used for the client connection.

This property determines the URL protocol (e.g., HTTP or HTTPS) used to establish the connection. If a specific protocol is not provided during the configuration, the default protocol is used.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.reconnectionDelay

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/reconnection-delay.html`

### :agents:agents-core/commonMain

```kotlin
val reconnectionDelay: Duration?
```

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.requestTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/request-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val requestTimeout: Duration?
```

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.sseUrl

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/sse-url.html`

### :agents:agents-core/commonMain

```kotlin
val sseUrl: String
```

Constructs the URL endpoint for Server-Sent Events (SSE) communication.

This property is a computed value derived from the base url property of the connection configuration. It appends the path /sse to the base URL, forming the full URL used for establishing Server-Sent Events connections. The returned URL conforms to the protocol, host, and port settings specified in the configuration.

Typical use cases of this property include subscribing to a server's event stream to receive real-time updates or notifications using SSE.

## ai.koog.agents.core.feature.remote.client.config.ClientConnectionConfig.url

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-client-connection-config/url.html`

### :agents:agents-core/commonMain

```kotlin
val url: String
```

Provides the base URL for the current connection configuration. Constructs the URL using the protocol, host, and port specified in the connection configuration.

## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig.Companion.DEFAULT_HOST

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/-companion/-d-e-f-a-u-l-t_-h-o-s-t.html`

### :agents:agents-core/commonMain

```kotlin
const val DEFAULT_HOST: String
```

Represents the default host address used for client connections.

This constant defines the default hostname or IP address as "127.0.0.1", typically representing the local machine (localhost).

## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig.Companion.DEFAULT_PORT

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/-companion/-d-e-f-a-u-l-t_-p-o-r-t.html`

### :agents:agents-core/commonMain

```kotlin
const val DEFAULT_PORT: Int = 50881
```

Represents the default port number used for client connections.

## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig.Companion.defaultConnectionTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/-companion/default-connection-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val defaultConnectionTimeout: Duration
```

Represents the default connection timeout used for client connections.

## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig.Companion.defaultRequestTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/-companion/default-request-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val defaultRequestTimeout: Duration
```

Represents the default request timeout used for client connections.

## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

Companion object for the DefaultClientConnectionConfig class.

Provides default connection configuration values to streamline the creation of client connection configurations.

## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig.DefaultClientConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/-default-client-connection-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor(host: String = DEFAULT_HOST, port: Int? = DEFAULT_PORT, protocol: URLProtocol? = null, headers: Map<String, List<String>>? = null, reconnectionDelay: Duration? = null, requestTimeout: Duration? = defaultRequestTimeout, connectTimeout: Duration? = defaultConnectionTimeout)
```

- host — The hostname or IP address of the server to connect to. Defaults to 127.0.0.1.
- port — The port number for the connection. Defaults to 50881.
- protocol — The protocol to use for the connection (e.g., HTTP, HTTPS). Defaults to null, using the base class's default protocol instead.
- headers — Optional HTTP headers to include in the connection. Defaults to null, which is treated as empty map.
- reconnectionDelay — The delay between connection retry attempts, if applicable. Defaults to null.
- requestTimeout — The timeout duration for requests. Defaults to 5.seconds.
- connectTimeout — The timeout duration for a connection establishment. Defaults to 15.seconds.
## ai.koog.agents.core.feature.remote.client.config.DefaultClientConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.client.config/-default-client-connection-config/index.html`

### :agents:agents-core/commonMain

```kotlin
class DefaultClientConnectionConfig(host: String = DEFAULT_HOST, port: Int? = DEFAULT_PORT, protocol: URLProtocol? = null, headers: Map<String, List<String>>? = null, reconnectionDelay: Duration? = null, requestTimeout: Duration? = defaultRequestTimeout, connectTimeout: Duration? = defaultConnectionTimeout) : ClientConnectionConfig
```

Default implementation of the ClientConnectionConfig class.

This class provides a predefined set of configurations suitable for establishing client-side connections, simplifying the process of initializing connections with default values.

It extends the base functionality of ClientConnectionConfig by offering default settings such as host, port, protocol, and timeouts.

- host — The hostname or IP address of the server to connect to. Defaults to 127.0.0.1.
- port — The port number for the connection. Defaults to 50881.
- protocol — The protocol to use for the connection (e.g., HTTP, HTTPS). Defaults to null, using the base class's default protocol instead.
- headers — Optional HTTP headers to include in the connection. Defaults to null, which is treated as empty map.
- reconnectionDelay — The delay between connection retry attempts, if applicable. Defaults to null.
- requestTimeout — The timeout duration for requests. Defaults to 5.seconds.
- connectTimeout — The timeout duration for a connection establishment. Defaults to 15.seconds.
## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.FeatureMessageRemoteServer

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/-feature-message-remote-server.html`

### :agents:agents-core/commonMain

```kotlin
constructor(connectionConfig: ServerConnectionConfig)
```


Referenced packages: `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/close.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun close()
```

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.connectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/connection-config.html`

### :agents:agents-core/commonMain

```kotlin
val connectionConfig: ServerConnectionConfig
```


Referenced packages: `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/index.html`

### :agents:agents-core/commonMain

```kotlin
class FeatureMessageRemoteServer(val connectionConfig: ServerConnectionConfig) : FeatureMessageServer
```

A server for managing remote feature message communication via server-sent events (SSE) and HTTP endpoints.

Supported features:

Server-sent events (SSE) for messages from a server side;

Provides health check and message handling endpoints via HTTP;

Process messages from clients via /message POST request.

Note: Please make sure you call the start method before starting a communication process.


Referenced packages: `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.isStarted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/is-started.html`

### :agents:agents-core/commonMain

```kotlin
open override val isStarted: StateFlow<Boolean>
```

Represents the current state of the server, indicating whether it has been started and is actively running.

This state flow emits a boolean value:

true if the server is running and ready to process incoming connections or events.

false if the server is stopped or has not yet been started.

The value of isStarted is updated automatically based on the server's lifecycle transitions, such as when starting or stopping the server.

This property can be used to monitor the server's state, ensuring that its operations are executed only when it is in the appropriate running state. It is particularly useful for preventing redundant start operations or for providing feedback to the client.

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.receivedMessages

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/received-messages.html`

### :agents:agents-core/commonMain

```kotlin
val receivedMessages: Channel<FeatureMessage>
```

A channel used to receive and process incoming feature messages sent to the server.

This property acts as an endpoint for handling incoming messages of type FeatureMessage. Messages received on this channel are expected to be processed asynchronously, enabling the server to handle events such as client requests or updates in a non-blocking manner.

Key Characteristics:

The channel is configured with an unlimited capacity, allowing it to buffer incoming messages without restriction. This ensures robustness during high-message throughput scenarios.

Incoming feature messages may represent various system events, categorized by their messageType or timestamp as per the FeatureMessage interface.

Use Cases:

Accepting and handling POST requests containing feature messages from clients.

Routing received messages for further processing, storage, or broadcasting.

Supporting server functionality by integrating received messages into its workflow for tasks such as health checks, client communication, or event-driven responses.

Behavior:

The channel remains open during the server's lifecycle and is explicitly closed when the server is stopped (e.g., via the stopServer method).

Consumers of this channel are responsible for correctly processing the messages while adhering to the channel's concurrency guarantees.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.sendMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/send-message.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun sendMessage(message: FeatureMessage)
```

Sends a feature message for further processing or delivery to connected clients via server-sent events (SSE).

This method is designed to enqueue the given FeatureMessage into a channel, from which it will be serialized and sent to all subscribed clients or receivers, if applicable. The method ensures that the message conforms to the expected FeatureMessage interface.

- message — The message to be sent, implementing the FeatureMessage interface. This message includes information such as a timestamp and type, ensuring proper context for the recipient.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.start

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/start.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun start()
```

Starts the server, initializing any necessary resources, and beginning to listen for incoming client connections or events.

This method ensures that the server transitions into a running state, allowing it to process incoming messages, send SSE events FeatureMessage, and respond to health check requests from clients.

It is recommended to check the server's state using isStarted before invoking this method to prevent redundant operations.

- IllegalStateException — if the server is already running or cannot be started due to invalid configuration.
- kotlinx.io.IOException — if an error occurs while initializing the server's underlying infrastructure.
## ai.koog.agents.core.feature.remote.server.FeatureMessageRemoteServer.toServerEventData

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-remote-server/to-server-event-data.html`

### :agents:agents-core/commonMain

```kotlin
fun FeatureMessage.toServerEventData(): String
```

Serializes the current FeatureMessage instance into a JSON string format.

This method leverages the serialization configuration defined in the connectionConfig.jsonConfig property to convert the FeatureMessage object into its corresponding JSON representation. The serialization process ensures that all the necessary properties and structure of the FeatureMessage are captured for transmission or storage.

A JSON string representing the serialized form of the FeatureMessage instance.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageServer

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-server/index.html`

### :agents:agents-core/commonMain

```kotlin
interface FeatureMessageServer : Closeable
```

Represents a server responsible for managing and facilitating communication of feature messages. Typically used for sending and handling messages within a remote server context.

A server is a pat of a Kotlin AI Agent. The server is started inside the same process as the running agent. It is used to broadcast agent execution events to connected clients (e.g., a running IDE). Please see description for a client in ai.koog.agents.core.feature.remote.client.FeatureMessageRemoteClient.

Features:

Send SSE events ai.koog.agents.core.feature.message.FeatureMessage during agent execution;

Process incoming messages from a client;

Respond to client's health check requests to verify connection state.

- FeatureMessageRemoteServer

Referenced packages: `ai.koog.utils.io`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageServer.isStarted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-server/is-started.html`

### :agents:agents-core/commonMain

```kotlin
abstract val isStarted: StateFlow<Boolean>
```

Represents the current state of the server, indicating whether it has been started and is actively running.

This state flow emits a boolean value:

true if the server is running and ready to process incoming connections or events.

false if the server is stopped or has not yet been started.

The value of isStarted is updated automatically based on the server's lifecycle transitions, such as when starting or stopping the server.

This property can be used to monitor the server's state, ensuring that its operations are executed only when it is in the appropriate running state. It is particularly useful for preventing redundant start operations or for providing feedback to the client.

## ai.koog.agents.core.feature.remote.server.FeatureMessageServer.sendMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-server/send-message.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun sendMessage(message: FeatureMessage)
```

Sends a feature message for further processing or delivery to connected clients via server-sent events (SSE).

This method is designed to enqueue the given FeatureMessage into a channel, from which it will be serialized and sent to all subscribed clients or receivers, if applicable. The method ensures that the message conforms to the expected FeatureMessage interface.

- message — The message to be sent, implementing the FeatureMessage interface. This message includes information such as a timestamp and type, ensuring proper context for the recipient.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.remote.server.FeatureMessageServer.start

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server/-feature-message-server/start.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun start()
```

Starts the server, initializing any necessary resources, and beginning to listen for incoming client connections or events.

This method ensures that the server transitions into a running state, allowing it to process incoming messages, send SSE events FeatureMessage, and respond to health check requests from clients.

It is recommended to check the server's state using isStarted before invoking this method to prevent redundant operations.

- IllegalStateException — if the server is already running or cannot be started due to invalid configuration.
- kotlinx.io.IOException — if an error occurs while initializing the server's underlying infrastructure.
## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig.Companion.DEFAULT_AWAIT_INITIAL_CONNECTION

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/-companion/-d-e-f-a-u-l-t_-a-w-a-i-t_-i-n-i-t-i-a-l_-c-o-n-n-e-c-t-i-o-n.html`

### :agents:agents-core/commonMain

```kotlin
const val DEFAULT_AWAIT_INITIAL_CONNECTION: Boolean = false
```

Indicates whether the server should wait for the first incoming connection before proceeding.

This constant is set to false by default, meaning the server does not wait for an initial connection and continues with its execution. It is used as a default value for the waitConnection parameter in the DefaultServerConnectionConfig class.

## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig.Companion.DEFAULT_HOST

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/-companion/-d-e-f-a-u-l-t_-h-o-s-t.html`

### :agents:agents-core/commonMain

```kotlin
const val DEFAULT_HOST: String
```

The default hostname or IP address for the server connection.

## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig.Companion.DEFAULT_PORT

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/-companion/-d-e-f-a-u-l-t_-p-o-r-t.html`

### :agents:agents-core/commonMain

```kotlin
const val DEFAULT_PORT: Int = 50881
```

The default port number the server will listen to. Defaults to 50881.

## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig.Companion.defaultAwaitInitialConnectionTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/-companion/default-await-initial-connection-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val defaultAwaitInitialConnectionTimeout: Duration
```

The default timeout duration for waiting for the first client connection.

This value is used in DefaultServerConnectionConfig to define the timeout period within which a client connection needs to be established after the server starts. By default, it is set to 300 seconds.

## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

Contains default configurations for server connection parameters.

This companion object provides constant values used as default configurations for setting up a server connection. These defaults include the server port, host address, and a suspend flag.

These constants are used in the DefaultServerConnectionConfig class to provide an initial configuration unless explicitly overridden.

## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig.DefaultServerConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/-default-server-connection-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor(host: String? = null, port: Int? = null, awaitInitialConnection: Boolean? = null, awaitInitialConnectionTimeout: Duration? = null)
```

- host — The hostname or IP address of the server to connect to. Defaults to '127.0.0.1';
- port — The port number on which the server will listen to. Defaults to 50881;
- awaitInitialConnection — Indicates whether the server waits for a first connection before continuing. Set to 'false' by default.
- awaitInitialConnectionTimeout — The timeout duration for waiting for the first connection.
## ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-default-server-connection-config/index.html`

### :agents:agents-core/commonMain

```kotlin
class DefaultServerConnectionConfig constructor(host: String? = null, port: Int? = null, awaitInitialConnection: Boolean? = null, awaitInitialConnectionTimeout: Duration? = null) : ServerConnectionConfig
```

Default implementation of the server connection configuration.

This class provides configuration settings for setting up a server connection, extending the ServerConnectionConfig base class. It initializes the server port configuration to a default value unless explicitly specified.

- host — The hostname or IP address of the server to connect to. Defaults to '127.0.0.1';
- port — The port number on which the server will listen to. Defaults to 50881;
- awaitInitialConnection — Indicates whether the server waits for a first connection before continuing. Set to 'false' by default.
- awaitInitialConnectionTimeout — The timeout duration for waiting for the first connection.
## ai.koog.agents.core.feature.remote.server.config.ServerConnectionConfig.ServerConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-server-connection-config/-server-connection-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor(host: String, port: Int, awaitInitialConnection: Boolean, awaitInitialConnectionTimeout: Duration)
```

## ai.koog.agents.core.feature.remote.server.config.ServerConnectionConfig.awaitInitialConnectionTimeout

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-server-connection-config/await-initial-connection-timeout.html`

### :agents:agents-core/commonMain

```kotlin
val awaitInitialConnectionTimeout: Duration
```

## ai.koog.agents.core.feature.remote.server.config.ServerConnectionConfig.awaitInitialConnection

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-server-connection-config/await-initial-connection.html`

### :agents:agents-core/commonMain

```kotlin
val awaitInitialConnection: Boolean
```

## ai.koog.agents.core.feature.remote.server.config.ServerConnectionConfig.host

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-server-connection-config/host.html`

### :agents:agents-core/commonMain

```kotlin
val host: String
```

## ai.koog.agents.core.feature.remote.server.config.ServerConnectionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-server-connection-config/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class ServerConnectionConfig(val host: String, val port: Int, val awaitInitialConnection: Boolean, val awaitInitialConnectionTimeout: Duration) : ConnectionConfig
```

Configuration class for setting up a server connection.

- DefaultServerConnectionConfig

Referenced packages: `ai.koog.agents.core.feature.remote`.

## ai.koog.agents.core.feature.remote.server.config.ServerConnectionConfig.port

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.remote.server.config/-server-connection-config/port.html`

### :agents:agents-core/commonMain

```kotlin
val port: Int
```

## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter.FeatureMessageFileWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/-feature-message-file-writer.html`

### :agents:agents-core/commonMain

```kotlin
constructor(targetPath: Path, sinkOpener: (Path) -> Sink)
```

- targetPath — The file where feature messages will be written.
- sinkOpener — Returns a Sink for writing to the file, this class manages its lifecycle.
- Path — The type representing paths supported by the file system provider.
## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/close.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun close()
```

Releases resources held by this processor.

## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class FeatureMessageFileWriter<Path>(val targetPath: Path, sinkOpener: (Path) -> Sink) : FeatureMessageProcessor
```

A feature message processor responsible for writing feature messages to a file. This abstract class provides functionality to convert and write feature messages into a target file using a specified file system provider.

- targetPath — The file where feature messages will be written.
- sinkOpener — Returns a Sink for writing to the file, this class manages its lifecycle.
- Path — The type representing paths supported by the file system provider.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter.initialize

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/initialize.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun initialize()
```

Initializes the feature output stream provider to ensure it is ready for use.

## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter.isOpen

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/is-open.html`

### :agents:agents-core/commonMain

```kotlin
open override val isOpen: StateFlow<Boolean>
```

Indicates whether the writer is currently open and ready for operation.

This property reflects the state of the writer, which transitions between open and closed during its lifecycle. For instance, isOpen is set to true after the writer is successfully initialized using the initialize() method and set to false upon closure via the close() method.

The value of this property is used to enforce correct usage of the writer, ensuring that operations, such as writing or processing messages, are only permitted when the writer is open.

Accessing this property allows for thread-safe checking of the writer's state, particularly in scenarios that involve concurrent operations.

## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter.targetPath

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/target-path.html`

### :agents:agents-core/commonMain

```kotlin
val targetPath: Path
```

- targetPath — The file where feature messages will be written.
## ai.koog.agents.core.feature.writer.FeatureMessageFileWriter.toFileString

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-file-writer/to-file-string.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun FeatureMessage.toFileString(): String
```

Converts the FeatureMessage instance to its corresponding string representation suitable for writing to a file.

This method should handle the serialization or formatting of the feature message, ensuring that all the necessary attributes are represented in the output string consistently.

A string representation of the FeatureMessage formatted for file output.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.FeatureMessageLogWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-feature-message-log-writer.html`

### :agents:agents-core/commonMain

```kotlin
constructor(targetLogger: KLogger, logLevel: FeatureMessageLogWriter.LogLevel = LogLevel.INFO)
```

- targetLogger — The KLogger instance used for feature messages to be streamed into.
## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.LogLevel.DEBUG

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-log-level/-d-e-b-u-g/index.html`

### :agents:agents-core/commonMain

```kotlin
DEBUG
```

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.LogLevel.INFO

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-log-level/-i-n-f-o/index.html`

### :agents:agents-core/commonMain

```kotlin
INFO
```

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.LogLevel.entries

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-log-level/entries.html`

### :agents:agents-core/commonMain

```kotlin
val entries: EnumEntries<FeatureMessageLogWriter.LogLevel>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.LogLevel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-log-level/index.html`

### :agents:agents-core/commonMain

```kotlin
enum LogLevel : Enum<FeatureMessageLogWriter.LogLevel>
```

Defines the logging levels supported by the system.

The LogLevel enum is used to specify the level of detail to be logged. This can be useful for controlling the verbosity of log output and filtering messages based on their importance or purpose.

INFO: Represents informational messages that highlight the overall application flow, such as initialization or significant lifecycle events.

DEBUG: Represents detailed debugging messages used for diagnosing issues or understanding the internal state and behavior of the application.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.LogLevel.valueOf

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-log-level/value-of.html`

### :agents:agents-core/commonMain

```kotlin
fun valueOf(value: String): FeatureMessageLogWriter.LogLevel
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.LogLevel.values

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/-log-level/values.html`

### :agents:agents-core/commonMain

```kotlin
fun values(): Array<FeatureMessageLogWriter.LogLevel>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/close.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun close()
```

Releases resources held by this processor.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class FeatureMessageLogWriter constructor(targetLogger: KLogger, logLevel: FeatureMessageLogWriter.LogLevel = LogLevel.INFO) : FeatureMessageProcessor
```

An abstract base class for implementing a stream feature provider that logs incoming feature messages into a provided logger instance.

- targetLogger — The KLogger instance used for feature messages to be streamed into.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.isOpen

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/is-open.html`

### :agents:agents-core/commonMain

```kotlin
open override val isOpen: StateFlow<Boolean>
```

A StateFlow representing the current open state of the processor.

## ai.koog.agents.core.feature.writer.FeatureMessageLogWriter.toLoggerMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-log-writer/to-logger-message.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun FeatureMessage.toLoggerMessage(): String
```

Converts the incoming ai.koog.agents.core.feature.message.FeatureMessage into a target logger message.


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.core.feature.writer.FeatureMessageRemoteWriter.FeatureMessageRemoteWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-remote-writer/-feature-message-remote-writer.html`

### :agents:agents-core/commonMain

```kotlin
constructor(connectionConfig: ServerConnectionConfig? = null)
```

- connectionConfig — Configuration for the server connection. If not provided, a default configuration using port 50881 will be used.

Referenced packages: `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.core.feature.writer.FeatureMessageRemoteWriter.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-remote-writer/close.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun close()
```

Releases resources held by this processor.

## ai.koog.agents.core.feature.writer.FeatureMessageRemoteWriter

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-remote-writer/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class FeatureMessageRemoteWriter constructor(connectionConfig: ServerConnectionConfig? = null) : FeatureMessageProcessor
```

An abstract class that facilitates writing feature messages to a remote server.

- connectionConfig — Configuration for the server connection. If not provided, a default configuration using port 50881 will be used.
- DebuggerFeatureMessageRemoteWriter

Referenced packages: `ai.koog.agents.core.feature.message`, `ai.koog.agents.core.feature.remote.server.config`.

## ai.koog.agents.core.feature.writer.FeatureMessageRemoteWriter.initialize

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-remote-writer/initialize.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun initialize()
```

Initializes the feature output stream provider to ensure it is ready for use.

## ai.koog.agents.core.feature.writer.FeatureMessageRemoteWriter.isOpen

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.writer/-feature-message-remote-writer/is-open.html`

### :agents:agents-core/commonMain

```kotlin
open override val isOpen: StateFlow<Boolean>
```

Indicates whether the writer is currently open and initialized.

A value of true means the writer is open and ready to process messages, while false indicates the writer is either not initialized or has been closed.

This property reflects the internal _isOpen state and ensures thread-safe access.

## ai.koog.agents.core.model.AgentServiceError.AgentServiceError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error/-agent-service-error.html`

### :agents:agents-core/commonMain

```kotlin
constructor(type: AgentServiceErrorType, message: String)
```

## ai.koog.agents.core.model.AgentServiceError.asException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error/as-exception.html`

### :agents:agents-core/commonMain

```kotlin
fun asException(): AgentEngineException
```

Converts the current AgentServiceError instance into a corresponding AgentEngineException instance.

This function maps the type property of the AgentServiceError to a specific subclass of AgentEngineException based on the error type. Each error type corresponds to a specific exception:

UNEXPECTED_ERROR maps to UnexpectedServerException.

UNEXPECTED_MESSAGE_TYPE maps to UnexpectedMessageTypeException.

MALFORMED_MESSAGE maps to MalformedMessageException.

AGENT_NOT_FOUND maps to AgentNotFoundException.

The message property of the AgentServiceError is passed as the exception's message.

An AgentEngineException instance that corresponds to the current error type.


Referenced packages: `ai.koog.agents.core.exception`.

## ai.koog.agents.core.model.AgentServiceError

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class AgentServiceError(val type: AgentServiceErrorType, val message: String)
```

Represents an error response from the agent service.

This class encapsulates details about errors that may occur during interactions with the agent service. Each error is characterized by a specific type and an associated human-readable message providing additional context about the error.

The error type is defined using the AgentServiceErrorType enum, which categorizes errors into different types such as unexpected errors, malformed messages, or agent not found scenarios.

## ai.koog.agents.core.model.AgentServiceError.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String
```

## ai.koog.agents.core.model.AgentServiceError.type

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error/type.html`

### :agents:agents-core/commonMain

```kotlin
val type: AgentServiceErrorType
```

## ai.koog.agents.core.model.AgentServiceErrorType.AGENT_NOT_FOUND

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/-a-g-e-n-t_-n-o-t_-f-o-u-n-d/index.html`

### :agents:agents-core/commonMain

```kotlin
AGENT_NOT_FOUND
```

Represents a specific error type indicating that the requested agent could not be found. This error may occur if the agent is unavailable, unregistered, or the identifier provided does not correspond to any existing agent in the system.

## ai.koog.agents.core.model.AgentServiceErrorType.MALFORMED_MESSAGE

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/-m-a-l-f-o-r-m-e-d_-m-e-s-s-a-g-e/index.html`

### :agents:agents-core/commonMain

```kotlin
MALFORMED_MESSAGE
```

Indicates that a received message is malformed. This can occur when the message does not adhere to the expected format, structure, or content requirements.

Common scenarios include missing required fields, incorrect data types, or invalid values in the message body.

Errors of this type usually require client-side corrections to the message before resending.

## ai.koog.agents.core.model.AgentServiceErrorType.UNEXPECTED_ERROR

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/-u-n-e-x-p-e-c-t-e-d_-e-r-r-o-r/index.html`

### :agents:agents-core/commonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
UNEXPECTED_ERROR
```

Represents an unexpected error encountered by the AI Agent.

This error type is used to categorize issues that cannot be classified into other predefined error types such as malformed message, agent not found, etc. It typically serves as a fallback for unanticipated scenarios or server-related failures.

## ai.koog.agents.core.model.AgentServiceErrorType.UNEXPECTED_MESSAGE_TYPE

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/-u-n-e-x-p-e-c-t-e-d_-m-e-s-s-a-g-e_-t-y-p-e/index.html`

### :agents:agents-core/commonMain

```kotlin
UNEXPECTED_MESSAGE_TYPE
```

Indicates that an unexpected type of message was sent to the agent service.

This error type is used when the agent encounters a message that does not conform to the expected structure, format, or type, making it unprocessable within the service.

Typically, this may occur if the message type is unsupported or improperly defined in the communication protocol.

## ai.koog.agents.core.model.AgentServiceErrorType.entries

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/entries.html`

### :agents:agents-core/commonMain

```kotlin
val entries: EnumEntries<AgentServiceErrorType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.core.model.AgentServiceErrorType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable enum AgentServiceErrorType : Enum<AgentServiceErrorType>
```

Represents different types of service errors that can occur in the context of an agent. This enum is used to categorize the errors for better error handling and reporting.

## ai.koog.agents.core.model.AgentServiceErrorType.valueOf

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/value-of.html`

### :agents:agents-core/commonMain

```kotlin
fun valueOf(value: String): AgentServiceErrorType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.core.model.AgentServiceErrorType.values

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.model/-agent-service-error-type/values.html`

### :agents:agents-core/commonMain

```kotlin
fun values(): Array<AgentServiceErrorType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint.Dummy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/-dummy/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable object Dummy : PlannerAgentExecutionPoint
```

Dummy execution point.

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint.PlanCompletionEvaluated.PlanCompletionEvaluated

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/-plan-completion-evaluated/-plan-completion-evaluated.html`

### :agents:agents-core/commonMain

```kotlin
constructor(isCompleted: Boolean)
```

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint.PlanCompletionEvaluated

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/-plan-completion-evaluated/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class PlanCompletionEvaluated(val isCompleted: Boolean) : PlannerAgentExecutionPoint
```

Execution point immediately after the plan completion is evaluated.

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint.PlanCompletionEvaluated.isCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/-plan-completion-evaluated/is-completed.html`

### :agents:agents-core/commonMain

```kotlin
val isCompleted: Boolean
```

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint.PlanCreated

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/-plan-created/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable object PlanCreated : PlannerAgentExecutionPoint
```

Execution point immediately after the plan is created.

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint.StepExecuted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/-step-executed/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable object StepExecuted : PlannerAgentExecutionPoint
```

Execution point immediately after a step is executed.

## ai.koog.agents.core.planner.PlannerAgentExecutionPoint

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-agent-execution-point/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable sealed interface PlannerAgentExecutionPoint
```

Represents the execution point of the planner agent.

- Dummy
- PlanCreated
- StepExecuted
- PlanCompletionEvaluated
## ai.koog.agents.core.system.getEnvironmentVariableOrNull

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.system/get-environment-variable-or-null.html`

### :agents:agents-core/commonMain

```kotlin
fun getEnvironmentVariableOrNull(name: String): String?
```

Reads the value of a specified environment variable.

The value of the specified environment variable as a String, or null if the variable is not set or cannot be read.

- name — The name of the environment variable to retrieve.
## ai.koog.agents.core.system.getVMOptionOrNull

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.system/get-v-m-option-or-null.html`

### :agents:agents-core/commonMain

```kotlin
fun getVMOptionOrNull(name: String): String?
```

Reads the value of a specified virtual machine (VM) option.

The value of the specified VM option as a String, or null if the option is not set or cannot be read.

- name — The name of the VM option to retrieve.
## ai.koog.agents.core.utils.BuilderChainAction.configure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.utils/-builder-chain-action/configure.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun configure(builder: Builder): ResultingBuilder
```

Configures the current builder with the specified configuration settings.

The resulting builder after the configuration has been applied.

- builder — The builder instance containing the configuration settings to apply.
## ai.koog.agents.core.utils.BuilderChainAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.utils/-builder-chain-action/index.html`

### :agents:agents-core/commonMain

```kotlin
fun interface BuilderChainAction<Builder, ResultingBuilder>
```

A functional interface representing an action that can be performed on a builder in a chainable manner. It defines a transformation from one builder type to another, allowing the construction process to be extended or modified incrementally.

- Builder — The type of the input builder that will be configured.
- ResultingBuilder — The type of the resulting builder produced after configuration.
## ai.koog.agents.core.utils.ConfigureAction.configure

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.utils/-configure-action/configure.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun configure(config: T)
```

Configures the provided configuration object.

- config — The configuration object to be modified or customized.
## ai.koog.agents.core.utils.ConfigureAction

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.utils/-configure-action/index.html`

### :agents:agents-core/commonMain

```kotlin
fun interface ConfigureAction<T>
```

Represents a functional interface designed to apply configurations of type T. This interface allows for standardized handling of configuration operations across various implementations or systems.

- T — The type of object that this configuration action will operate on.
## ai.koog.agents.core.utils.runBlockingOnLLMDispatcher

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.utils/run-blocking-on-l-l-m-dispatcher.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <T> AIAgentConfig.runBlockingOnLLMDispatcher(block: suspend () -> T): T
```

Executes the given block on the llmRequestDispatcher.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.utils.runBlockingOnStrategyDispatcher

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.utils/run-blocking-on-strategy-dispatcher.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <T> AIAgentConfig.runBlockingOnStrategyDispatcher(block: suspend () -> T): T
```

Executes the given block on the strategyDispatcher.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.ext.agent.ConditionResult.Approve

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-condition-result/-approve/index.html`

### :agents:agents-core/commonMain

```kotlin
object Approve : ConditionResult
```

Object representing an approved condition result.

This implementation of the ConditionResult interface indicates that a retry condition has succeeded.

## ai.koog.agents.ext.agent.ConditionResult.Reject.Reject

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-condition-result/-reject/-reject.html`

### :agents:agents-core/commonMain

```kotlin
constructor(feedback: String? = null)
```

## ai.koog.agents.ext.agent.ConditionResult.Reject.feedback

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-condition-result/-reject/feedback.html`

### :agents:agents-core/commonMain

```kotlin
val feedback: String?
```

## ai.koog.agents.ext.agent.ConditionResult.Reject

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-condition-result/-reject/index.html`

### :agents:agents-core/commonMain

```kotlin
class Reject(val feedback: String? = null) : ConditionResult
```

Represents a condition result indicating rejection, optionally with feedback.

This implementation of the ConditionResult interface indicates that a retry condition has failed. It can contain optional feedback parameter which will be passed to the llm for the next retries.

## ai.koog.agents.ext.agent.ConditionResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-condition-result/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed interface ConditionResult
```

Represents the result of evaluating a specific condition in a system or workflow. This sealed interface allows for expressing various outcomes of a condition check.

Implementations:

Approve: Indicates that the condition was approved.

Reject: Indicates that the condition was rejected, optionally with feedback.

- Approve
- Reject
## ai.koog.agents.ext.agent.ConditionResult.isSuccess

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-condition-result/is-success.html`

### :agents:agents-core/commonMain

```kotlin
open val isSuccess: Boolean
```

Indicates whether the current instance of ConditionResult represents a successful state. Returns true if the instance is of type Approve, signifying success. Otherwise, returns false.

## ai.koog.agents.ext.agent.CriticResult.CriticResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result/-critic-result.html`

### :agents:agents-core/commonMain

```kotlin
constructor(successful: Boolean, feedback: String, input: T)
```

## ai.koog.agents.ext.agent.CriticResult.feedback

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result/feedback.html`

### :agents:agents-core/commonMain

```kotlin
val feedback: String
```

A textual message providing details about the critique or feedback process.

Represents additional information such as observations, suggestions, or results generated during the evaluation of an input.

## ai.koog.agents.ext.agent.CriticResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result/index.html`

### :agents:agents-core/commonMain

```kotlin
class CriticResult<T>(successful: Boolean, feedback: String, input: T)
```

Represents the result of a critique or feedback process.

## ai.koog.agents.ext.agent.CriticResult.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: T
```

The original input of the critic. Represents the subject or content evaluated during the critique process.

## ai.koog.agents.ext.agent.CriticResultFromLLM.CriticResultFromLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result-from-l-l-m/-critic-result-from-l-l-m.html`

### :agents:agents-core/commonMain

```kotlin
constructor(isCorrect: Boolean, feedback: String = "")
```

## ai.koog.agents.ext.agent.CriticResultFromLLM.feedback

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result-from-l-l-m/feedback.html`

### :agents:agents-core/commonMain

```kotlin
val feedback: String
```

## ai.koog.agents.ext.agent.CriticResultFromLLM

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result-from-l-l-m/index.html`

### :agents:agents-core/commonMain

```kotlin
@Serializable data class CriticResultFromLLM(val isCorrect: Boolean, val feedback: String = "")
```

Represents the result of a plan evaluation performed by an LLM (Large Language Model).

This class is primarily used within internal agent-related implementations where an LLM evaluates the correctness of a plan and optionally provides feedback for improvements.

## ai.koog.agents.ext.agent.CriticResultFromLLM.isCorrect

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-critic-result-from-l-l-m/is-correct.html`

### :agents:agents-core/commonMain

```kotlin
val isCorrect: Boolean
```

## ai.koog.agents.ext.agent.FinishTool.FinishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/-finish-tool.html`

### :agents:agents-core/commonMain

```kotlin
constructor(outputType: TypeToken)
```

A pass-through tool used with subgraphWithTask to signal task completion and return a structured result. Wraps outputs in FinishResult to support primitive outputTypes, which base Tool cannot handle directly.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.agent.FinishTool.decodeArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/decode-args.html`

### :agents:agents-core/commonMain

```kotlin
open override fun decodeArgs(rawArgs: JSONObject, serializer: JSONSerializer): Output
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.agent.FinishTool.decodeResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/decode-result.html`

### :agents:agents-core/commonMain

```kotlin
open override fun decodeResult(rawResult: JSONElement, serializer: JSONSerializer): Output
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.agent.FinishTool.encodeArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/encode-args.html`

### :agents:agents-core/commonMain

```kotlin
open override fun encodeArgs(args: Output, serializer: JSONSerializer): JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.agent.FinishTool.encodeResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/encode-result.html`

### :agents:agents-core/commonMain

```kotlin
open override fun encodeResult(result: Output, serializer: JSONSerializer): JSONElement
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.ext.agent.FinishTool.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(args: Output): Output
```

## ai.koog.agents.ext.agent.FinishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-finish-tool/index.html`

### :agents:agents-core/commonMain

```kotlin
class FinishTool<Output> : Tool<Output, Output>
```

A pass-through tool used with subgraphWithTask to signal task completion and return a structured result. Wraps outputs in FinishResult to support primitive outputTypes, which base Tool cannot handle directly.

- outputType — Type of the Output
- customSerializer — Optional serializer override to use instead of the one that is passed to encode/decode tool methods. This is useful for certain internal implementations, such as some built-in subgraphs and subtasks, when the output is our own class and we don't want to rely on user-configured JSONSerializer.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.agent.HistoryCompressionConfig.HistoryCompressionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-history-compression-config/-history-compression-config.html`

### :agents:agents-core/commonMain

```kotlin
constructor(isHistoryTooBig: (Prompt) -> Boolean, compressionStrategy: HistoryCompressionStrategy, retrievalModel: LLModel? = null)
```


Referenced packages: `ai.koog.agents.core.dsl.extension`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.ext.agent.HistoryCompressionConfig.compressionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-history-compression-config/compression-strategy.html`

### :agents:agents-core/commonMain

```kotlin
val compressionStrategy: HistoryCompressionStrategy
```


Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.ext.agent.HistoryCompressionConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-history-compression-config/index.html`

### :agents:agents-core/commonMain

```kotlin
data class HistoryCompressionConfig(val isHistoryTooBig: (Prompt) -> Boolean, val compressionStrategy: HistoryCompressionStrategy, val retrievalModel: LLModel? = null)
```

Configuration for conversation history compression in a single-run strategy.


Referenced packages: `ai.koog.agents.core.dsl.extension`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.ext.agent.HistoryCompressionConfig.isHistoryTooBig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-history-compression-config/is-history-too-big.html`

### :agents:agents-core/commonMain

```kotlin
val isHistoryTooBig: (Prompt) -> Boolean
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.ext.agent.HistoryCompressionConfig.retrievalModel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-history-compression-config/retrieval-model.html`

### :agents:agents-core/commonMain

```kotlin
val retrievalModel: LLModel?
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.ext.agent.RetrySubgraphResult.RetrySubgraphResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-retry-subgraph-result/-retry-subgraph-result.html`

### :agents:agents-core/commonMain

```kotlin
constructor(output: Output, success: Boolean, retryCount: Int)
```

- output — The result of the subgraph operation.
- success — A boolean indicating whether the action was successful.
- retryCount — The number of retries attempted.
## ai.koog.agents.ext.agent.RetrySubgraphResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-retry-subgraph-result/index.html`

### :agents:agents-core/commonMain

```kotlin
data class RetrySubgraphResult<Output>(val output: Output, val success: Boolean, val retryCount: Int)
```

Represents the result of subgraphWithRetry.

- output — The result of the subgraph operation.
- success — A boolean indicating whether the action was successful.
- retryCount — The number of retries attempted.
## ai.koog.agents.ext.agent.RetrySubgraphResult.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-retry-subgraph-result/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: Output
```

- output — The result of the subgraph operation.
## ai.koog.agents.ext.agent.RetrySubgraphResult.retryCount

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-retry-subgraph-result/retry-count.html`

### :agents:agents-core/commonMain

```kotlin
val retryCount: Int
```

- retryCount — The number of retries attempted.
## ai.koog.agents.ext.agent.RetrySubgraphResult.success

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-retry-subgraph-result/success.html`

### :agents:agents-core/commonMain

```kotlin
val success: Boolean
```

- success — A boolean indicating whether the action was successful.
## ai.koog.agents.ext.agent.SubgraphWithTaskUtils.ASSISTANT_RESPONSE_REPEAT_MAX

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-subgraph-with-task-utils/-a-s-s-i-s-t-a-n-t_-r-e-s-p-o-n-s-e_-r-e-p-e-a-t_-m-a-x.html`

### :agents:agents-core/commonMain

```kotlin
const val ASSISTANT_RESPONSE_REPEAT_MAX: Int = 3
```

The maximum number of times an assistant is allowed to repeat responses within an interaction session, up to a maximum of 3 times, by default.

This constant serves as a limit to control the repetition of responses provided by an assistant within interaction sessions. It can be used to prevent redundancy in responses and ensure conciseness in communication.

## ai.koog.agents.ext.agent.SubgraphWithTaskUtils.FINALIZE_SUBGRAPH_TOOL_DESCRIPTION

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-subgraph-with-task-utils/-f-i-n-a-l-i-z-e_-s-u-b-g-r-a-p-h_-t-o-o-l_-d-e-s-c-r-i-p-t-i-o-n.html`

### :agents:agents-core/commonMain

```kotlin
const val FINALIZE_SUBGRAPH_TOOL_DESCRIPTION: String
```

A constant string describing the purpose and usage of a tool within the agent framework.

This constant is intended to represent the action of finalizing a subgraph process and providing the final result. It is specifically used internally to indicate when a process is considered complete and the output of that process should be returned.

Marked with @InternalAgentToolsApi, this value is primarily designed for internal use within the agent tools API and subject to change in future releases. Its usage in external implementations should be approached with caution.

## ai.koog.agents.ext.agent.SubgraphWithTaskUtils.FINALIZE_SUBGRAPH_TOOL_NAME

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-subgraph-with-task-utils/-f-i-n-a-l-i-z-e_-s-u-b-g-r-a-p-h_-t-o-o-l_-n-a-m-e.html`

### :agents:agents-core/commonMain

```kotlin
const val FINALIZE_SUBGRAPH_TOOL_NAME: String
```

Represents the name of the internal tool used for finalizing subgraph task results within an AI agent's execution flow. This constant is primarily intended for internal use in the implementation of tools and agents.

Usage of this tool name is subject to the constraints and opt-in requirements specified by the InternalAgentToolsApi annotation, indicating potential instability and the possibility of breaking changes in future updates.

Value: "finalize_task_result".

## ai.koog.agents.ext.agent.SubgraphWithTaskUtils.finishTool

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-subgraph-with-task-utils/finish-tool.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> finishTool(): Tool<T, T>
```

Creates an instance of FinishTool for output type T


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.agent.SubgraphWithTaskUtils

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/-subgraph-with-task-utils/index.html`

### :agents:agents-core/commonMain

```kotlin
object SubgraphWithTaskUtils
```

Utility object providing tools and methods for working with subgraphs and tasks in a controlled and structured way. These utilities are designed to help finalize subgraph-related tasks and encapsulate result handling within tool constructs.

## ai.koog.agents.ext.agent.asConditionResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/as-condition-result.html`

### :agents:agents-core/commonMain

```kotlin
val Boolean.asConditionResult: ConditionResult
```

Extension property that converts a Boolean to a ConditionResult.

true is converted to ConditionResult.Approve

false is converted to ConditionResult.Reject

This allows for explicit conversion from Boolean to ConditionResult.

## ai.koog.agents.ext.agent.chatAgentStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/chat-agent-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun chatAgentStrategy(): AIAgentGraphStrategy<String, String>
```

Creates and configures a ai.koog.agents.core.agent.entity.AIAgentGraphStrategy for executing a chat interaction process. The agent orchestrates interactions between different stages, nodes, and tools to handle user input, execute tools, and provide responses. Allows the agent to interact with the user in a chat-like manner.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.ext.agent.llmAsAJudge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/llm-as-a-judge.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> llmAsAJudge(llmModel: LLModel? = null, task: String): AIAgentNodeDelegate<T, CriticResult<T>>
```

A method to utilize LLM as a critic or judge for evaluating tasks with context-aware feedback. This method processes a given task and the interaction history to provide structured feedback on the task's correctness.

- llmModel — The optional language model to override the default model during the session. If null, the default model will be used.
- task — The task or instruction to be presented to the language model for critical evaluation.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`.

## ai.koog.agents.ext.agent.reActStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/re-act-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun reActStrategy(reasoningInterval: Int = 1, name: String = "re_act", reasoningPrompt: String = "Please give your thoughts about the task and plan the next steps."): AIAgentGraphStrategy<String, String>
```

Creates a ReAct AI agent strategy that alternates between reasoning and execution stages to dynamically process tasks and request outputs from an LLM.

An instance of AIAgentGraphStrategy that defines the ReAct strategy.

+-------+ +---------------+ +---------------+ +--------+ | Start | ----------> | CallLLMReason | ----------> | CallLLMAction | ----------> | Finish | +-------+ +---------------+ +---------------+ +--------+ ^ | Finished? Yes | | No | v +-----------------------+ | ExecuteTool | +-----------------------+

Example execution flow of a banking agent with ReAct strategy:

Start: User asks "How much did I spend last month?"

Reasoning Phase: CallLLMReason: "I need to follow these steps:

Get all transactions from last month

Filter out deposits (positive amounts)

Calculate total spending"

Action & Execution Phase 1: CallLLMAction: {tool: "get_transactions", args: {startDate: "2025-05-19", endDate: "2025-06-18"}} ExecuteTool Result: {date: "2025-05-25", amount: -100.00, description: "Grocery Store"}, {date: "2025-05-31", amount: +1000.00, description: "Salary Deposit"}, {date: "2025-06-10", amount: -500.00, description: "Rent Payment"}, {date: "2025-06-13", amount: -200.00, description: "Utilities"}

Reasoning Phase: CallLLMReason: "I have the transactions. Now I need to:

Remove the salary deposit of +1000.00

Sum up the remaining transactions"

Action & Execution Phase 2: CallLLMAction: {tool: "calculate_sum", args: {amounts: -100.00, -500.00, -200.00}} ExecuteTool Result: -800.00

Final Response: Assistant: "You spent $800.00 last month on groceries, rent, and utilities."

Finish: Execution complete

- reasoningInterval — Specifies the interval for reasoning steps.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.ext.agent.setupLLMAsAJudge

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/setup-l-l-m-as-a-judge.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T> AIAgentGraphContextBase.setupLLMAsAJudge(task: String, llmModel: LLModel?, nodeInput: T): CriticResult<T>
```

InternalAgentsApi method. Configures llmAsAJudge

A result of type CriticResult containing the evaluation outcome, feedback generated by the LLM, and a reference to the original input.

- task — A description of the evaluation task that the LLM will perform. This task defines the scope and criteria for judging the input.
- llmModel — The LLM model to use for the evaluation. If null, the default model will be used.
- nodeInput — The input data to be evaluated by the LLM according to the specified task.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.llm`.

## ai.koog.agents.ext.agent.setupSubgraphWithTask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/setup-subgraph-with-task.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output, OutputTransformed> AIAgentSubgraphBuilderBase<Input, OutputTransformed>.setupSubgraphWithTask(finishTool: Tool<Output, OutputTransformed>, inputType: TypeToken, outputTransformedType: TypeToken, parallelTools: Boolean, assistantResponseRepeatMax: Int? = null, defineTask: suspend AIAgentGraphContextBase.(Input) -> String)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output, OutputTransformed> AIAgentSubgraphBuilderBase<Input, OutputTransformed>.setupSubgraphWithTask(finishTool: Tool<Output, OutputTransformed>, parallelTools: Boolean, assistantResponseRepeatMax: Int? = null, noinline defineTask: suspend AIAgentGraphContextBase.(Input) -> String)
```

Configures and sets up a subgraph with task handling, including tool execution operations, assistant response management, and task finalization logic.

- finishTool — the tool used to signify task completion and process task finalization.
- parallelTools — the mode in which tools are executed, e.g., parallel or sequential execution.
- assistantResponseRepeatMax — the maximum number of assistant responses allowed before determining that the task cannot be completed. If not provided, a default is used.
- defineTask — a suspend function defining the task description, executed within the context of an AI agent graph and based on the given input data.
- Input — the type of input data for the subgraph.
- Output — the type of output data from the finish tool.
- OutputTransformed — the transformed type of the output data after processing by the finish tool.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`.

## ai.koog.agents.ext.agent.singleRunStrategyWithHistoryCompression

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/single-run-strategy-with-history-compression.html`

### :agents:agents-core/commonMain

```kotlin
fun singleRunStrategyWithHistoryCompression(config: HistoryCompressionConfig, parallelTools: Boolean = false): AIAgentGraphStrategy<String, String>
```

Creates a single-run agent strategy with automatic conversation history compression.

Works like ai.koog.agents.core.agent.singleRunStrategy but adds a compression step after each tool execution: if the conversation history becomes too large (based on HistoryCompressionConfig.isHistoryTooBig), it compresses the message list to essential facts before continuing.

AIAgentGraphStrategy that compresses conversation history when needed

- config — specifies when to trigger compression (size threshold), how to compress (fact extraction strategy), and optionally which model to use for compression
- parallelTools — (multiple tools per call, executed concurrently)

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.ext.agent.structuredOutputWithToolsStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/structured-output-with-tools-strategy.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Output> structuredOutputWithToolsStrategy(config: StructuredRequestConfig<Output>, fixingParser: StructureFixingParser? = null, parallelTools: Boolean = false): AIAgentGraphStrategy<String, Output>
```

Defines a strategy for handling structured output with tools integration using specified configuration and execution logic.

This strategy facilitates a structured pipeline for generating outputs using tools and large language models (LLMs), enabling transformations between input, intermediate results, and structured output based on the provided configuration and execution behavior.

- config — The configuration for structured output processing, specifying schema, providers, and optional error handling mechanisms.
- Output — The type of the structured output generated by the strategy.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> structuredOutputWithToolsStrategy(config: StructuredRequestConfig<Output>, fixingParser: StructureFixingParser? = null, parallelTools: Boolean = false, noinline transform: suspend (input: Input) -> String): AIAgentGraphStrategy<Input, Output>
```

Defines a strategy for handling structured output with tools integration using specified configuration and execution logic.

This strategy facilitates a structured pipeline for generating outputs using tools and large language models (LLMs), enabling transformations between input, intermediate results, and structured output based on the provided configuration and execution behavior.

- config — The configuration for structured output processing, specifying schema, providers, and optional error handling mechanisms.
- transform — A suspendable function that accepts the input of type Input and produces a string output that serves as the input for further processing in the structured output pipeline.
- Input — The type of the input to be processed by the strategy.
- Output — The type of the structured output generated by the strategy.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.structure`.

## ai.koog.agents.ext.agent.subgraphWithRetrySimple

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/subgraph-with-retry-simple.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input : Any, Output> subgraphWithRetrySimple(noinline condition: suspend AIAgentGraphContextBase.(Output) -> ConditionResult, maxRetries: Int, conditionDescription: String? = null, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, strict: Boolean = true, name: String? = null, noinline defineAction: AIAgentSubgraphBuilderBase<Input, Output>.() -> Unit): AIAgentSubgraphDelegate<Input, Output>
```

Creates a subgraph that includes retry functionality based on a given condition and a maximum number of retries. If the condition is not met after the specified retries and strict mode is enabled, an exception is thrown. Unlike subgraphWithRetry, this function directly returns the output value instead of a RetrySubgraphResult.

- condition — A suspendable function that determines whether the condition is met, based on the output.
- maxRetries — The maximum number of retries allowed if the condition is not met.
- conditionDescription — A message which explains the condition constraints to the model
- toolSelectionStrategy — The strategy used to select tools for this subgraph.
- strict — If true, an exception is thrown if the condition is not met after the maximum retries.
- name — An optional name for the subgraph.
- defineAction — A lambda defining the actions within the subgraph.Example usage:val subgraphRetryCallLLM by subgraphWithRetrySimple( condition = { (it is MessagePart.Tool.Call).asConditionResult }, maxRetries = 2,) { val nodeCallLLM by nodeLLMRequest("sendInput") nodeStart then nodeCallLLM then nodeFinish}val nodeExecuteTool by nodeExecuteTool("nodeExecuteTool")edge(subgraphRetryCallLLM forwardTo nodeExecuteTool onToolCall { true }) Content copied to clipboard

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.ext.agent.subgraphWithRetry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/subgraph-with-retry.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input : Any, Output> subgraphWithRetry(noinline condition: suspend AIAgentGraphContextBase.(Output) -> ConditionResult, maxRetries: Int, conditionDescription: String? = null, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, name: String? = null, noinline defineAction: AIAgentSubgraphBuilderBase<Input, Output>.() -> Unit): AIAgentSubgraphDelegate<Input, RetrySubgraphResult<Output>>
```

Creates a subgraph with retry mechanism, allowing a specified action subgraph to be retried multiple times until a given condition is met or the maximum number of retries is reached.

- condition — A function that evaluates whether the output meets the desired condition.
- maxRetries — The maximum number of allowed retries. Must be greater than 0.
- conditionDescription — A message which explains the condition constraints to the model
- toolSelectionStrategy — The strategy used to select a tool for executing the action.
- name — The optional name of the subgraph.
- defineAction — A lambda defining the action subgraph to perform within the retry subgraph.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.ext.agent.subgraphWithTask

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/subgraph-with-task.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> subgraphWithTask(name: String? = null, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, Output>
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
fun <Input : Any, Output : Any> subgraphWithTask(name: String? = null, inputType: TypeToken, outputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy = ToolSelectionStrategy.ALL, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, Output>
```

Creates a subgraph, which performs one specific task, defined by defineTask, using the tools defined by toolSelectionStrategy.

Use this function if you need the agent to perform a single task which outputs a structured result.

A delegate that represents the created subgraph, allowing input and output operations.

- toolSelectionStrategy — The strategy used to select tools for the subgraph operations.
- name — An optional name for the subgraph. Defaults to null if not provided.
- llmModel — Optional language model to be used within the subgraph. Defaults to null.
- llmParams — Optional parameters for configuring the language model behavior. Defaults to null.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspending lambda function that defines the task for the subgraph, taking the input as a parameter.
- Input — The input type for the task to be defined in the subgraph.
- Output — The output type for the subgraph's finalized result.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output> subgraphWithTask(tools: List<ToolBase<*, *>>, name: String? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, Output>
```

Creates a subgraph with a task definition and specified tools. The subgraph uses the provided tools to process input and execute the defined task, eventually producing a result through the provided finish tool.

A delegate representing the subgraph that processes the input and produces a result through the finish tool.

- tools — The list of tools that are available for use within the subgraph.
- name — An optional name for the subgraph. Defaults to null if not provided.
- llmModel — An optional language model to be used in the subgraph. If not specified, a default model may be used.
- llmParams — Optional parameters to customize the behavior of the language model in the subgraph.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspend function that defines the task to be executed by the subgraph based on the given input.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
fun <Input : Any, OutputTransformed : Any> subgraphWithTask(inputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy, finishTool: Tool<*, OutputTransformed>, name: String? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, OutputTransformed>
```

Defines a subgraph with a specific task to be performed by an AI agent.

A delegate object representing the constructed subgraph for the specified task.

- toolSelectionStrategy — The strategy to be used for selecting tools within the subgraph.
- finishTool — The tool responsible for finalizing the task and producing the transformed output.
- name — An optional name for the subgraph. Defaults to null if not provided.
- llmModel — The optional language model to be used in the subgraph for processing requests.
- llmParams — The optional parameters to customize the behavior of the language model.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A lambda function to define the task logic, which accepts the input and returns a task description.
- Input — The input type provided to the subgraph.
- OutputTransformed — The transformed output type after finishing the task.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output, OutputTransformed> subgraphWithTask(toolSelectionStrategy: ToolSelectionStrategy, finishTool: Tool<Output, OutputTransformed>, name: String? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, OutputTransformed>
```

Defines a subgraph with a specific task to be performed by an AI agent.

A delegate object representing the constructed subgraph for the specified task.

- toolSelectionStrategy — The strategy to be used for selecting tools within the subgraph.
- finishTool — The tool responsible for finalizing the task and producing the transformed output.
- name — An optional name for the subgraph. Defaults to null if not provided.
- llmModel — The optional language model to be used in the subgraph for processing requests.
- llmParams — The optional parameters to customize the behavior of the language model.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A lambda function to define the task logic, which accepts the input and returns a task description.
- Input — The input type provided to the subgraph.
- Output — The output type returned by the subgraph.
- OutputTransformed — The transformed output type after finishing the task.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input, Output, OutputTransformed> subgraphWithTask(tools: List<ToolBase<*, *>>, finishTool: Tool<Output, OutputTransformed>, name: String? = null, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, freshHistory: Boolean = false, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, OutputTransformed>
```

Creates a subgraph with a specified task definition, a list of tools, and a finish tool to transform output.

A subgraph delegate that handles the input and produces the transformed output for the defined task.

- tools — A list of tools to be used within the subgraph.
- finishTool — The tool responsible for transforming the output of the subgraph.
- name — An optional name for the subgraph. Defaults to null if not provided.
- llmModel — The language model to be used within the subgraph. Defaults to null if not provided.
- llmParams — Optional parameters to customize the behavior of the language model. Defaults to null if not provided.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspend function that defines the task to be executed in the subgraph, based on the provided input.
- Input — The type of the input for the subgraph task.
- Output — The type of the raw output produced by the finish tool.
- OutputTransformed — The transformed type of the output after applying the finish tool.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
inline fun <Input, Output> subgraphWithTask(toolSelectionStrategy: ToolSelectionStrategy, finishToolFunction: KFunction<Output>, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, freshHistory: Boolean = false, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, Output>
```

Creates a subgraph within an AI agent graph using a defined task, a tool selection strategy, and a finish tool function. This method provides the capability to integrate task-specific logic and tool selection into the AI agent's subgraph.

An AIAgentSubgraphDelegate representing the constructed subgraph with the specified configuration.

- toolSelectionStrategy — The strategy to be used for selecting tools within the subgraph.
- finishToolFunction — The function to finalize the task execution, providing the result as Output.
- llmModel — The language model to be used within the subgraph, if specified.
- llmParams — Parameters to configure the language model's behavior, if specified.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspend function defining the task logic for the subgraph.
- Input — The input type to the task defined in the subgraph.
- Output — The output type produced by the task and the finish tool.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
inline fun <Input, Output> subgraphWithTask(tools: List<ERROR CLASS: Symbol not found for ToolBase<*, *>>, finishToolFunction: KFunction<Output>, llmModel: ERROR CLASS: Symbol not found for LLModel?? = null, llmParams: ERROR CLASS: Symbol not found for LLMParams?? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, freshHistory: Boolean = false, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, Output>
```

Defines a subgraph with a specific task in an AI agent graph, enabling the coordination of tools, task definitions, and execution logic.

An instance of AIAgentSubgraphDelegate that represents the defined subgraph with input and output types.

- tools — A list of tools available for the subgraph task to utilize.
- finishToolFunction — The function that represents the tool used to finish the task, producing the output.
- llmModel — An optional LLModel to use within the subgraph for task execution. Defaults to null.
- llmParams — Optional parameters for configuring the behavior of the LLModel. Defaults to null.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspend lambda function that defines the task, taking an input of type Input and returning a task description as a String.
- Input — The input type expected for the subgraph task.
- Output — The output type expected from the subgraph task.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`.

## ai.koog.agents.ext.agent.subgraphWithVerification

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.agent/subgraph-with-verification.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input : Any> subgraphWithVerification(name: String? = null, inputType: TypeToken, toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, CriticResult<Input>>
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input : Any> subgraphWithVerification(toolSelectionStrategy: ToolSelectionStrategy, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, CriticResult<Input>>
```

subgraphWithTask with CriticResult result. It verifies if the task was performed correctly or not, and describes the problems if any.

A delegate representing the constructed subgraph with verification result.

- toolSelectionStrategy — The strategy used to select tools for the subgraph operations.
- llmModel — Optional language model to be used within the subgraph. Defaults to null.
- llmParams — Optional parameters for configuring the language model behavior. Defaults to null.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspending lambda function that defines the task for the subgraph, taking the input as a parameter.
- Input — The input type accepted by the subgraph.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
inline fun <Input : Any> subgraphWithVerification(tools: List<ToolBase<*, *>>, llmModel: LLModel? = null, llmParams: LLMParams? = null, parallelTools: Boolean = false, assistantResponseRepeatMax: Int? = null, responseProcessor: ResponseProcessor? = null, noinline defineTask: suspend AIAgentGraphContextBase.(input: Input) -> String): AIAgentSubgraphDelegate<Input, CriticResult<Input>>
```

Constructs a subgraph within an AI agent's strategy graph with additional verification capabilities.

This method defines a subgraph using a given list of tools, an optional language model, and optional language model parameters. It also allows specifying whether to summarize the interaction history and defines the task to be executed in the subgraph.

A delegate representing the constructed subgraph with input type Input and output type as a verified subgraph result CriticResult.

- tools — A list of tools available to the subgraph.
- llmModel — Optional language model to be used within the subgraph.
- llmParams — Optional parameters to configure the language model's behavior.
- parallelTools — The mode in which tools are executed. Defaults to sequential execution.
- assistantResponseRepeatMax — The maximum number of assistant responses allowed before determining that the task cannot be completed.
- responseProcessor — An optional processor defining the post-processing of messages returned from the LLM.
- defineTask — A suspendable function defining the task that the subgraph will execute, which takes an input and produces a string-based task description.
- Input — The input type accepted by the subgraph.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.tools`, `ai.koog.prompt.llm`, `ai.koog.prompt.params`, `ai.koog.prompt.processor`.

## ai.koog.agents.ext.llm.choice.ChoiceSelectionStrategy.Default.choose

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-choice-selection-strategy/-default/choose.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun choose(prompt: Prompt, choices: LLMChoice): Message.Assistant
```

Selects one choice from a list of available Message.Response in LLMChoice options based on a given prompt.

The selected Message.Response from the provided list based on the implemented strategy.

- prompt — The Prompt containing the context or query for which a choice should be selected.
- choices — A LLMChoice options from which one will be chosen.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.message`.

## ai.koog.agents.ext.llm.choice.ChoiceSelectionStrategy.Default

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-choice-selection-strategy/-default/index.html`

### :agents:agents-core/commonMain

```kotlin
object Default : ChoiceSelectionStrategy
```

Represents the default implementation of the ChoiceSelectionStrategy interface.

This implementation selects the first available choice from the provided LLMChoice options in response to the given Prompt. It is intended to serve as a simple, deterministic strategy for use cases where no specific selection logic is required.

## ai.koog.agents.ext.llm.choice.ChoiceSelectionStrategy.choose

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-choice-selection-strategy/choose.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun choose(prompt: Prompt, choices: LLMChoice): Message.Assistant
```

Selects one choice from a list of available Message.Response in LLMChoice options based on a given prompt.

The selected Message.Response from the provided list based on the implemented strategy.

- prompt — The Prompt containing the context or query for which a choice should be selected.
- choices — A LLMChoice options from which one will be chosen.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.message`.

## ai.koog.agents.ext.llm.choice.ChoiceSelectionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-choice-selection-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
interface ChoiceSelectionStrategy
```

Represents a strategy for selecting a choice from a list of available options for a given prompt.

- Default
## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.PromptExecutorWithChoiceSelection

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/-prompt-executor-with-choice-selection.html`

### :agents:agents-core/commonMain

```kotlin
constructor(executor: PromptExecutor, choiceSelectionStrategy: ChoiceSelectionStrategy)
```

- executor — The underlying PromptExecutor responsible for performing the prompt execution and generating multiple response choices.
- choiceSelectionStrategy — The strategy implementation that defines the logic for selecting and filtering the generated response choices.

Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/close.html`

### :agents:agents-core/commonMain

```kotlin
open override fun close()
```

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.executeMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/execute-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): LLMChoice
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.executeStreaming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/execute-streaming.html`

### :agents:agents-core/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/index.html`

### :agents:agents-core/commonMain

```kotlin
class PromptExecutorWithChoiceSelection(executor: PromptExecutor, choiceSelectionStrategy: ChoiceSelectionStrategy) : PromptExecutor
```

A specialized implementation of PromptExecutor that enhances the standard execution process by introducing a choice selection mechanism. This class acts as a proxy that intercepts the standard execute method, generates multiple response choices, and applies a selection strategy to filter and choose the most appropriate responses.

The execution process involves two main steps:

Generating multiple response choices using the underlying executor

Applying the specified selection strategy to choose the most suitable responses

- executor — The underlying PromptExecutor responsible for performing the prompt execution and generating multiple response choices.
- choiceSelectionStrategy — The strategy implementation that defines the logic for selecting and filtering the generated response choices.

Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.models

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/models.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.ext.llm.choice.PromptExecutorWithChoiceSelection.moderate

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/-prompt-executor-with-choice-selection/moderate.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.agents.ext.llm.choice.nodeLLMSendResultsMultipleChoices

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/node-l-l-m-send-results-multiple-choices.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeLLMSendResultsMultipleChoices(name: String? = null): AIAgentNodeDelegate<List<ReceivedToolResult>, LLMChoice>
```

A node that sends multiple tool execution results to the LLM and gets multiple LLM choices.

- name — Optional name for the node.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.agents.core.environment`, `ai.koog.prompt.message`.

## ai.koog.agents.ext.llm.choice.nodeSelectLLMChoice

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.ext.llm.choice/node-select-l-l-m-choice.html`

### :agents:agents-core/commonMain

```kotlin
fun nodeSelectLLMChoice(choiceSelectionStrategy: ChoiceSelectionStrategy, name: String? = null): AIAgentNodeDelegate<LLMChoice, Message.Assistant>
```

A node that chooses an LLM choice based on the given strategy.

- choiceSelectionStrategy — The strategy used to choose an LLM choice.
- name — Optional name for the node.

Referenced packages: `ai.koog.agents.core.dsl.builder`, `ai.koog.prompt.message`.
