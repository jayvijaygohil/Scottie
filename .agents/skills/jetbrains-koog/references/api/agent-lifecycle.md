# Agent construction and lifecycle

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.agent.AIAgent.AIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/-a-i-agent.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor()
```

### :agents:agents-core/jvmCommonMain

```kotlin
constructor()
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
constructor()
```

## ai.koog.agents.core.agent.AIAgent.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/-companion/builder.html`

### :agents:agents-core/commonMain

```kotlin
expect fun builder(): AIAgentBuilder
```

Creates and returns a new instance of the AIAgentBuilder class to configure and construct an AI agent.

An instance of AIAgentBuilder for configuring an AI agent.

### :agents:agents-core/jvmCommonMain

```kotlin
actual fun builder(): AIAgentBuilder
```

Creates and returns a new instance of the AIAgentBuilder class to configure and construct an AI agent.

An instance of AIAgentBuilder for configuring an AI agent.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun builder(): AIAgentBuilder
```

Creates and returns a new instance of the AIAgentBuilder class to configure and construct an AI agent.

An instance of AIAgentBuilder for configuring an AI agent.

## ai.koog.agents.core.agent.AIAgent.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
expect object Companion
```

Companion object with builder for AIAgent

### :agents:agents-core/jvmCommonMain

```kotlin
actual object Companion
```

Companion object with builder for AIAgent

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual object Companion
```

Companion object with builder for AIAgent

## ai.koog.agents.core.agent.AIAgent.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract val agentConfig: AIAgentConfig
```

The configuration for the AI agent.


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract val agentConfig: AIAgentConfig
```

The configuration for the AI agent.


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract val agentConfig: AIAgentConfig
```

The configuration for the AI agent.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.AIAgent.createSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/create-session.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract fun createSession(sessionId: String? = null): AIAgentRunSession<Input, Output, out AIAgentContext>
```

Creates a new session for executing the agent with the given input.

This method provides a way to get a session object that can be used to execute the agent independently. The session manages the complete execution lifecycle, including state tracking, pipeline coordination, and strategy execution.

A session instance that can be used to run the agent with specific input and context.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.session`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract fun createSession(sessionId: String?): AIAgentRunSession<Input, Output, out AIAgentContext>
```

Creates a new session for executing the agent with the given input.

This method provides a way to get a session object that can be used to execute the agent independently. The session manages the complete execution lifecycle, including state tracking, pipeline coordination, and strategy execution.

A session instance that can be used to run the agent with specific input and context.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.session`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract fun createSession(sessionId: String?): AIAgentRunSession<Input, Output, out AIAgentContext>
```

Creates a new session for executing the agent with the given input.

This method provides a way to get a session object that can be used to execute the agent independently. The session manages the complete execution lifecycle, including state tracking, pipeline coordination, and strategy execution.

A session instance that can be used to run the agent with specific input and context.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.session`.

## ai.koog.agents.core.agent.AIAgent.id

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/id.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract val id: String
```

Represents the unique identifier for the AI agent.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract val id: String
```

Represents the unique identifier for the AI agent.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract val id: String
```

Represents the unique identifier for the AI agent.

## ai.koog.agents.core.agent.AIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/index.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract class AIAgent<Input, Output> : Closeable
```

Represents a basic interface for AI agent.

- AIAgentBase

Referenced packages: `ai.koog.utils.io`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual abstract class AIAgent<Input, Output> : <ERROR CLASS> ERROR CLASS: Symbol not found for Closeable
```

Represents a basic interface for AI agent.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract class AIAgent<Input, Output> : Closeable
```

Represents a basic interface for AI agent.


Referenced packages: `ai.koog.utils.io`.

## ai.koog.agents.core.agent.AIAgent.run

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent/run.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun run(agentInput: Input, sessionId: String? = null): Output
```

Executes the AI agent with the given input and retrieves the resulting output.

The output produced by the agent.

- agentInput — The input for the agent.
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract suspend fun run(agentInput: Input, sessionId: String?): Output
```

Executes the AI agent with the given input and retrieves the resulting output.

The output produced by the agent.

- agentInput — The input for the agent.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun run(agentInput: Input, sessionId: String?): Output
```

Executes the AI agent with the given input and retrieves the resulting output.

The output produced by the agent.

- agentInput — The input for the agent.
## ai.koog.agents.core.agent.AIAgentBase.AIAgentBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/-a-i-agent-base.html`

### :agents:agents-core/commonMain

```kotlin
constructor(logger: KLogger, id: String? = null)
```

- id — the unique identifier for the agent. Random UUID will be generated if set to null.
- Input — the type of the input accepted by the agent.
- Output — the type of the output produced by the agent.
- TContext — the type of the context used during the agent's execution, extending AIAgentContext.
## ai.koog.agents.core.agent.AIAgentBase.close

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/close.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun close()
```

Closes the AI Agent and performs necessary cleanup operations.

This method is a suspending function that ensures that the AI Agent's resources are released when it is no longer needed. It notifies the pipeline of the agent's closure and ensures that any associated features or stream providers are properly closed.

Overrides the close method to implement agent-specific shutdown logic.

## ai.koog.agents.core.agent.AIAgentBase.createSession

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/create-session.html`

### :agents:agents-core/commonMain

```kotlin
open override fun createSession(sessionId: String? = null): AIAgentRunSession<Input, Output, TContext>
```

Creates a new AIAgentRunSession for executing the agent with the given input.

This method provides a way to obtain a session object that can be used to execute the agent independently. The session manages the complete execution lifecycle including state tracking, pipeline coordination, and strategy execution.

A new AIAgentRunSession instance configured with this agent's logger, strategy, and identifier. The session can be used to run the agent with specific input and context.


Referenced packages: `ai.koog.agents.core.agent.session`.

## ai.koog.agents.core.agent.AIAgentBase.id

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/id.html`

### :agents:agents-core/commonMain

```kotlin
override val id: String
```

Represents the unique identifier for the AI agent.

## ai.koog.agents.core.agent.AIAgentBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentBase<Input, Output, TContext : AIAgentContext>(logger: KLogger, id: String? = null) : AIAgent<Input, Output>
```

Abstract base class representing a single-use AI agent with state.

This AI agent is designed to execute a specific long-running strategy only once, and provides API to monitor and manage it's state.

It maintains internal states including its running status, whether it was started, its result (if available), and the root context associated with its execution. The class enforces safe state transitions and provides thread-safe operations via a mutex.

- id — the unique identifier for the agent. Random UUID will be generated if set to null.
- Input — the type of the input accepted by the agent.
- Output — the type of the output produced by the agent.
- TContext — the type of the context used during the agent's execution, extending AIAgentContext.
- FunctionalAIAgent
- GraphAIAgent
- PlannerAIAgent

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.AIAgentBase.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
abstract val pipeline: AIAgentPipeline
```

Represents the pipeline used by the AI agent for processing tasks or data.

This abstract property defines the structure or sequence of operations within the AI agent's pipeline. It serves as the core mechanism for executing workflows, handling inputs, and generating outputs in the AI agent's functionality.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.AIAgentBase.prepareContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/prepare-context.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun prepareContext(agentInput: Input, runId: String, eventId: String): TContext
```

Prepares and initializes the agent context required to handle the given input and run ID.

the initialized context specific to the agent setup for the provided input and run ID.

- agentInput — the input provided to the agent for processing.
- runId — a unique identifier representing the current execution or operation run.
- eventId — a unique identifier for agent-related events.
## ai.koog.agents.core.agent.AIAgentBase.run

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/run.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun run(agentInput: Input, sessionId: String? = null): Output
```

Executes the agent's main functionality, coordinating with various components such as pipelines and strategies. Ensures the agent is run in a thread-safe manner using locking mechanisms.

The output generated by the agent's execution, produced as a result of applying the strategy to the provided input.

- agentInput — The input required to execute the agent's strategy. This includes any data necessary for processing.
- IllegalStateException — if the agent was already started.
- Throwable — if any exception occurs during the execution process.
## ai.koog.agents.core.agent.AIAgentBase.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-base/strategy.html`

### :agents:agents-core/commonMain

```kotlin
abstract val strategy: AIAgentStrategy<Input, Output, TContext>
```

The execution strategy defining how the agent processes input and produces output.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.AIAgentBuilder.functionalStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder/functional-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input, Output> functionalStrategy(name: String = "funStrategy", strategy: BiFunction<AIAgentFunctionalContext, Input, Output>): FunctionalAgentBuilder<Input, Output>
```

Creates a functional agent builder using the provided strategy configuration.

This method allows defining a custom functional strategy for the AI agent.

A FunctionalAgentBuilder configured with the specified functional strategy.

- name — The name identifying the functional strategy. Defaults to "funStrategy".
- strategy — The implementation of the functional strategy's execution logic.
- Input — The type of the input parameter for the strategy's execution logic.
- Output — The type of the output returned by the strategy's execution logic.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.AIAgentBuilder.graphStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder/graph-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun <Input, Output> graphStrategy(name: String = "graphStrategy", build: BuilderChainAction<GraphStrategyBuilder, AIAgentGraphStrategy<Input, Output>>): GraphAgentBuilder<Input, Output>
```

Creates a graph agent builder using the provided strategy configuration.

This method allows defining a custom graph strategy for the AI agent.

A GraphAgentBuilder configured with the specified graph strategy.

- name — The name identifying the functional strategy. Defaults to "funStrategy".
- build — The configuration of the graph strategy.
- Input — The type of the input parameter for the strategy's execution logic.
- Output — The type of the output returned by the strategy's execution logic.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.utils`.

## ai.koog.agents.core.agent.AIAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentBuilder : AIAgentBuilderCommon<AIAgentBuilder>
```

Represents a configurational builder for setting up and customizing the execution parameters and components of an AI agent. This builder enables fine-grained control over tools, strategies, and prompts utilized by an AI agent during its execution.

### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentBuilder : AIAgentBuilderCommon<AIAgentBuilder>
```

Represents a configurational builder for setting up and customizing the execution parameters and components of an AI agent. This builder enables fine-grained control over tools, strategies, and prompts utilized by an AI agent during its execution.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentBuilder : AIAgentBuilderCommon<AIAgentBuilder>
```

Represents a configurational builder for setting up and customizing the execution parameters and components of an AI agent. This builder enables fine-grained control over tools, strategies, and prompts utilized by an AI agent during its execution.

## ai.koog.agents.core.agent.AIAgentBuilderBase.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-base/clock.html`

### :agents:agents-core/commonMain

```kotlin
fun clock(clock: KoogClock): Self
```

Sets the clock for the agent.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.agent.AIAgentBuilderBase.id

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-base/id.html`

### :agents:agents-core/commonMain

```kotlin
fun id(id: String?): Self
```

Sets the identifier for the builder configuration.

The current builder instance for chaining method calls.

- id — The identifier string to be set. Can be null.
## ai.koog.agents.core.agent.AIAgentBuilderBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentBuilderBase<Self : AIAgentBuilderBase<Self>> : AIAgentServiceBuilderBase<Self>
```

Shared fluent configuration for agent builders.

- GraphAgentBuilder
- FunctionalAgentBuilder
- PlannerAgentBuilder
- AIAgentBuilderCommon
- GraphAgentServiceBuilder
- FunctionalAgentServiceBuilder
## ai.koog.agents.core.agent.AIAgentBuilderCommon.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-common/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): AIAgent<String, String>
```

Builds and returns an instance of AIAgent configured according to the builder's settings.

This method finalizes the current configuration and constructs an AI agent. The agent is equipped with the specified execution strategy, tool registry, identifier, prompt, language model, and other optional configurations.

An instance of AIAgent with the configured input and output types as String.

## ai.koog.agents.core.agent.AIAgentBuilderCommon.functionalStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-common/functional-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> functionalStrategy(strategy: AIAgentFunctionalStrategy<Input, Output>): FunctionalAgentBuilder<Input, Output>
```

Sets the functional strategy to be used by the agent builder.

The provided strategy defines the behavior and processing logic for the AI agent in a loop-based execution model. This method configures the builder to utilize the specified strategy and returns an instance of FunctionalAgentBuilder for further configuration.

An instance of FunctionalAgentBuilder configured with the provided functional strategy.

- strategy — An instance of AIAgentFunctionalStrategy that contains the custom logic used by the AI agent for decision-making or execution processes.
## ai.koog.agents.core.agent.AIAgentBuilderCommon.graphStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-common/graph-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> graphStrategy(strategy: AIAgentGraphStrategy<Input, Output>): GraphAgentBuilder<Input, Output>
```

Configures and returns a GraphAgentBuilder instance using the specified AIAgentGraphStrategy.

The method allows associating an AI agent with a specific graph-based strategy for managing and executing workflows. It provides flexibility to define input and output types specific to the desired strategy.

An instance of GraphAgentBuilder configured with the specified strategy.

- strategy — The AIAgentGraphStrategy instance defining the workflow, including the start and finish nodes as well as the tool selection strategy.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.AIAgentBuilderCommon

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-common/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentBuilderCommon<Self : AIAgentBuilderCommon<Self>> : AIAgentBuilderBase<Self>
```

Common chained implementation for AIAgentBuilder actual classes.

- AIAgentBuilder
## ai.koog.agents.core.agent.AIAgentBuilderCommon.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-common/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentGraphFeature<TConfig, *>, configure: ConfigureAction<TConfig>): GraphAgentBuilder<String, String>
```

Installs a graph-specific AI agent feature into the builder with its provided configuration.

This method allows the integration of an AIAgentGraphFeature into the builder and its configuration using a lambda function.

An instance of GraphAgentBuilder configured with the installed feature.

- feature — The AIAgentGraphFeature to be installed into the builder.
- configure — A lambda function to configure the feature's properties and behavior.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`, `ai.koog.agents.core.utils`.

## ai.koog.agents.core.agent.AIAgentBuilderCommon.plannerStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-builder-common/planner-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> plannerStrategy(strategy: AIAgentPlannerStrategy<Input, Output>): PlannerAgentBuilder<Input, Output>
```

Configures the planner strategy to be used by an AI agent planner.

An instance of PlannerAgentBuilder configured with the specified planning strategy.

- strategy — The planning strategy to define how the AI agent should plan actions.

Referenced packages: `ai.koog.agents.core.planner`.

## ai.koog.agents.core.agent.AIAgentFunctionalStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-functional-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentFunctionalStrategy<TInput, TOutput> : AIAgentStrategy<TInput, TOutput, AIAgentFunctionalContext>
```

A strategy for implementing AI agent behavior that operates in a loop-based manner.

The AIAgentFunctionalStrategy class allows for the definition of a custom looping logic that processes input and produces output by utilizing an ai.koog.agents.core.agent.context.AIAgentFunctionalContext. This strategy can be used to define iterative decision-making or execution processes for AI agents.

- TInput — The type of input data processed by the strategy.
- TOutput — The type of output data produced by the strategy.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.AIAgentService.AIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/-a-i-agent-service.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor()
```

- Input — Type parameter for the input data for the agents.
- Output — Type parameter for the output data generated by the agents.
### :agents:agents-core/jvmCommonMain

```kotlin
constructor()
```

- Input — Type parameter for the input data for the agents.
- Output — Type parameter for the output data generated by the agents.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor()
```

- Input — Type parameter for the input data for the agents.
- Output — Type parameter for the output data generated by the agents.
## ai.koog.agents.core.agent.AIAgentService.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/-companion/builder.html`

### :agents:agents-core/commonMain

```kotlin
expect fun builder(): AIAgentServiceBuilder
```

Provides a builder for constructing an instance of the AIAgentService.

The returned builder allows for configuring and creating an instance of AIAgentService, enabling the user to customize the service's settings and properties as necessary.

An instance of AIAgentServiceBuilder that facilitates the construction of AIAgentService.

### :agents:agents-core/jvmCommonMain

```kotlin
actual fun builder(): AIAgentServiceBuilder
```

Provides a builder for constructing an instance of the AIAgentService.

The returned builder allows for configuring and creating an instance of AIAgentService, enabling the user to customize the service's settings and properties as necessary.

An instance of AIAgentServiceBuilder that facilitates the construction of AIAgentService.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun builder(): AIAgentServiceBuilder
```

Provides a builder for constructing an instance of the AIAgentService.

The returned builder allows for configuring and creating an instance of AIAgentService, enabling the user to customize the service's settings and properties as necessary.

An instance of AIAgentServiceBuilder that facilitates the construction of AIAgentService.

## ai.koog.agents.core.agent.AIAgentService.Companion.fromAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/-companion/from-agent.html`

### :agents:agents-core/commonMain

```kotlin
expect inline fun <Input, Output> fromAgent(agent: GraphAIAgent<Input, Output>): AIAgentService<Input, Output, GraphAIAgent<Input, Output>>
```

Converts a given GraphAIAgent instance into an AIAgentService instance.

An AIAgentService instance constructed from the provided GraphAIAgent.

- agent — The GraphAIAgent to be converted into a service instance.
- Input — The input type that the agent processes.
- Output — The output type that the agent produces.
### :agents:agents-core/commonMain

```kotlin
expect fun <Input, Output> fromAgent(agent: FunctionalAIAgent<Input, Output>): AIAgentService<Input, Output, FunctionalAIAgent<Input, Output>>
```

Creates a new instance of AIAgentService by transforming a given FunctionalAIAgent.

A new AIAgentService instance configured with the parameters of the provided agent.

- agent — The FunctionalAIAgent to be transformed into an AIAgentService.
- Input — The type of input data expected by the agent.
- Output — The type of output data produced by the agent.
### :agents:agents-core/jvmCommonMain

```kotlin
actual inline fun <Input, Output> fromAgent(agent: GraphAIAgent<Input, Output>): AIAgentService<Input, Output, GraphAIAgent<Input, Output>>
```

Converts a given GraphAIAgent instance into an AIAgentService instance.

An AIAgentService instance constructed from the provided GraphAIAgent.

- agent — The GraphAIAgent to be converted into a service instance.
- Input — The input type that the agent processes.
- Output — The output type that the agent produces.
### :agents:agents-core/jvmCommonMain

```kotlin
actual fun <Input, Output> fromAgent(agent: FunctionalAIAgent<Input, Output>): AIAgentService<Input, Output, FunctionalAIAgent<Input, Output>>
```

Creates a new instance of AIAgentService by transforming a given FunctionalAIAgent.

A new AIAgentService instance configured with the parameters of the provided agent.

- agent — The FunctionalAIAgent to be transformed into an AIAgentService.
- Input — The type of input data expected by the agent.
- Output — The type of output data produced by the agent.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual inline fun <Input, Output> fromAgent(agent: GraphAIAgent<Input, Output>): AIAgentService<Input, Output, GraphAIAgent<Input, Output>>
```

Converts a given GraphAIAgent instance into an AIAgentService instance.

An AIAgentService instance constructed from the provided GraphAIAgent.

- agent — The GraphAIAgent to be converted into a service instance.
- Input — The input type that the agent processes.
- Output — The output type that the agent produces.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun <Input, Output> fromAgent(agent: FunctionalAIAgent<Input, Output>): AIAgentService<Input, Output, FunctionalAIAgent<Input, Output>>
```

Creates a new instance of AIAgentService by transforming a given FunctionalAIAgent.

A new AIAgentService instance configured with the parameters of the provided agent.

- agent — The FunctionalAIAgent to be transformed into an AIAgentService.
- Input — The type of input data expected by the agent.
- Output — The type of output data produced by the agent.
## ai.koog.agents.core.agent.AIAgentService.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
expect object Companion
```

Companion object that provides factory methods for creating instances of GraphAIAgentService with various configurations.

### :agents:agents-core/jvmCommonMain

```kotlin
actual object Companion
```

Companion object that provides factory methods for creating instances of GraphAIAgentService with various configurations.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual object Companion
```

Companion object that provides factory methods for creating instances of GraphAIAgentService with various configurations.

## ai.koog.agents.core.agent.AIAgentService.agentById

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/agent-by-id.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun agentById(id: String): TAgent?
```

Retrieves an AI agent based on its unique identifier.

The AI agent associated with the specified ID, or null if no agent is found.

- id — The unique identifier of the AI agent to retrieve.
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract suspend fun agentById(id: String): TAgent?
```

Retrieves an AI agent based on its unique identifier.

The AI agent associated with the specified ID, or null if no agent is found.

- id — The unique identifier of the AI agent to retrieve.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun agentById(id: String): TAgent?
```

Retrieves an AI agent based on its unique identifier.

The AI agent associated with the specified ID, or null if no agent is found.

- id — The unique identifier of the AI agent to retrieve.
## ai.koog.agents.core.agent.AIAgentService.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract val agentConfig: AIAgentConfig
```

Holds the configuration details for an AI agent.

This property encapsulates the settings and parameters required to initialize and operate an AI agent, such as behavior configurations, thresholds, or any specific operational constraints. It is essential for defining the agent's behavior and performance.


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract val agentConfig: AIAgentConfig
```

Holds the configuration details for an AI agent.

This property encapsulates the settings and parameters required to initialize and operate an AI agent, such as behavior configurations, thresholds, or any specific operational constraints. It is essential for defining the agent's behavior and performance.


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract val agentConfig: AIAgentConfig
```

Holds the configuration details for an AI agent.

This property encapsulates the settings and parameters required to initialize and operate an AI agent, such as behavior configurations, thresholds, or any specific operational constraints. It is essential for defining the agent's behavior and performance.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.AIAgentService.createAgentAndRun

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/create-agent-and-run.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun createAgentAndRun(agentInput: Input, id: String? = null, additionalToolRegistry: ToolRegistry = this.toolRegistry, agentConfig: AIAgentConfig = this.agentConfig, clock: KoogClock = KoogClock.System): Output
```

Creates an AI agent with the specified configuration and runs it using the provided input.

The output generated by the agent after processing the input.

- agentInput — The input data to be processed by the agent.
- id — An optional unique identifier for the agent. If null, a default identifier will be generated.
- additionalToolRegistry — The tool registry to be used by the agent. Defaults to the service's tool registry.
- agentConfig — The configuration parameters for the AI agent. Defaults to the service's agent configuration.
- clock — The clock instance used for managing time-related operations. Defaults to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual abstract suspend fun createAgentAndRun(agentInput: Input, id: String?, additionalToolRegistry: ERROR CLASS: Symbol not found for ToolRegistry, agentConfig: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock): Output
```


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun createAgentAndRun(agentInput: Input, id: String?, additionalToolRegistry: ToolRegistry, agentConfig: AIAgentConfig, clock: KoogClock): Output
```

Creates an AI agent with the specified configuration and runs it using the provided input.

The output generated by the agent after processing the input.

- agentInput — The input data to be processed by the agent.
- id — An optional unique identifier for the agent. If null, a default identifier will be generated.
- additionalToolRegistry — The tool registry to be used by the agent. Defaults to the service's tool registry.
- agentConfig — The configuration parameters for the AI agent. Defaults to the service's agent configuration.
- clock — The clock instance used for managing time-related operations. Defaults to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.AIAgentService.createAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/create-agent.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun createAgent(id: String? = null, additionalToolRegistry: ToolRegistry = ToolRegistry.EMPTY, agentConfig: AIAgentConfig = this.agentConfig, clock: KoogClock = KoogClock.System): TAgent
```

Creates a new AI agent with the specified configuration, tool registry, and optional parameters.

The newly created AI agent.

- id — An optional unique identifier for the agent. If null, a default identifier will be generated.
- additionalToolRegistry — The registry of tools to be used by the agent. Defaults to an empty registry.
- agentConfig — The configuration settings for the AI agent. Defaults to the service's agent configuration.
- clock — The clock instance to manage time-related operations, defaulting to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual abstract suspend fun createAgent(id: String?, additionalToolRegistry: ERROR CLASS: Symbol not found for ToolRegistry, agentConfig: AIAgentConfig, clock: ERROR CLASS: Symbol not found for KoogClock): TAgent
```


Referenced packages: `ai.koog.agents.core.agent.config`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun createAgent(id: String?, additionalToolRegistry: ToolRegistry, agentConfig: AIAgentConfig, clock: KoogClock): TAgent
```

Creates a new AI agent with the specified configuration, tool registry, and optional parameters.

The newly created AI agent.

- id — An optional unique identifier for the agent. If null, a default identifier will be generated.
- additionalToolRegistry — The registry of tools to be used by the agent. Defaults to an empty registry.
- agentConfig — The configuration settings for the AI agent. Defaults to the service's agent configuration.
- clock — The clock instance to manage time-related operations, defaulting to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.AIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/index.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract class AIAgentService<Input, Output, TAgent : AIAgent<Input, Output>>
```

AIAgentService is a core interface for managing AI agents. The service allows creation, removal, and management of AI agents and provides functionalities to list agents based on their statuses.

A single instance of AIAgentService manages one kind of uniform AI Agents serving same purpose and solving the same type of user task. It's useful to create, manage, and track the progress of running agents solving similar user tasks in parallel.

- Input — Type parameter for the input data for the agents.
- Output — Type parameter for the output data generated by the agents.
- AIAgentServiceBase
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract class AIAgentService<Input, Output, TAgent : AIAgent<Input, Output>>
```

AIAgentService is a core interface for managing AI agents. The service allows creation, removal, and management of AI agents and provides functionalities to list agents based on their statuses.

A single instance of AIAgentService manages one kind of uniform AI Agents serving same purpose and solving the same type of user task. It's useful to create, manage, and track the progress of running agents solving similar user tasks in parallel.

- Input — Type parameter for the input data for the agents.
- Output — Type parameter for the output data generated by the agents.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract class AIAgentService<Input, Output, TAgent : AIAgent<Input, Output>>
```

AIAgentService is a core interface for managing AI agents. The service allows creation, removal, and management of AI agents and provides functionalities to list agents based on their statuses.

A single instance of AIAgentService manages one kind of uniform AI Agents serving same purpose and solving the same type of user task. It's useful to create, manage, and track the progress of running agents solving similar user tasks in parallel.

- Input — Type parameter for the input data for the agents.
- Output — Type parameter for the output data generated by the agents.
## ai.koog.agents.core.agent.AIAgentService.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract val promptExecutor: PromptExecutor
```

Represents an instance of PromptExecutor responsible for executing prompt-based operations.

This variable is used to handle interactions and executions related to prompts, providing a centralized mechanism to manage user inputs or automated instructions.


Referenced packages: `ai.koog.prompt.executor.model`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract val promptExecutor: PromptExecutor
```

Represents an instance of PromptExecutor responsible for executing prompt-based operations.

This variable is used to handle interactions and executions related to prompts, providing a centralized mechanism to manage user inputs or automated instructions.


Referenced packages: `ai.koog.prompt.executor.model`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract val promptExecutor: PromptExecutor
```

Represents an instance of PromptExecutor responsible for executing prompt-based operations.

This variable is used to handle interactions and executions related to prompts, providing a centralized mechanism to manage user inputs or automated instructions.


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.AIAgentService.removeAgentWithId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/remove-agent-with-id.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun removeAgentWithId(id: String): Boolean
```

Removes an AI agent based on its unique identifier.

True if the agent with the specified ID was successfully removed, or false if no such agent was found.

- id — The unique identifier of the AI agent to be removed.
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract suspend fun removeAgentWithId(id: String): Boolean
```

Removes an AI agent based on its unique identifier.

True if the agent with the specified ID was successfully removed, or false if no such agent was found.

- id — The unique identifier of the AI agent to be removed.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun removeAgentWithId(id: String): Boolean
```

Removes an AI agent based on its unique identifier.

True if the agent with the specified ID was successfully removed, or false if no such agent was found.

- id — The unique identifier of the AI agent to be removed.
## ai.koog.agents.core.agent.AIAgentService.removeAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/remove-agent.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract suspend fun removeAgent(agent: TAgent): Boolean
```

Removes the specified AI agent from the service.

True if the agent was successfully removed, or false if the agent was not found.

- agent — The AI agent to be removed.
### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract suspend fun removeAgent(agent: TAgent): Boolean
```

Removes the specified AI agent from the service.

True if the agent was successfully removed, or false if the agent was not found.

- agent — The AI agent to be removed.
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract suspend fun removeAgent(agent: TAgent): Boolean
```

Removes the specified AI agent from the service.

True if the agent was successfully removed, or false if the agent was not found.

- agent — The AI agent to be removed.
## ai.koog.agents.core.agent.AIAgentService.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
expect abstract val toolRegistry: ToolRegistry
```

Represents the central repository or registry for managing tools within the system.

This variable provides access to a tool registry that can be used to store, retrieve, and manage different tools registered in the application.

It is expected to be immutable and thread-safe, ensuring consistent behavior across the application.


Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-core/jvmCommonMain

```kotlin
actual abstract val toolRegistry: ToolRegistry
```

Represents the central repository or registry for managing tools within the system.

This variable provides access to a tool registry that can be used to store, retrieve, and manage different tools registered in the application.

It is expected to be immutable and thread-safe, ensuring consistent behavior across the application.


Referenced packages: `ai.koog.agents.core.tools`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual abstract val toolRegistry: ToolRegistry
```

Represents the central repository or registry for managing tools within the system.

This variable provides access to a tool registry that can be used to store, retrieve, and manage different tools registered in the application.

It is expected to be immutable and thread-safe, ensuring consistent behavior across the application.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.AIAgentServiceBase.AIAgentServiceBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/-a-i-agent-service-base.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

- Input — the input type expected by the AI agents.
- Output — the output type expected from the AI agents.
## ai.koog.agents.core.agent.AIAgentServiceBase.agentById

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/agent-by-id.html`

### :agents:agents-core/commonMain

```kotlin
suspend override fun agentById(id: String): TAgent?
```

Retrieves an AI agent managed by this service based on the provided unique identifier.

The AI agent corresponding to the given identifier, or null if no agent with the specified ID exists.

- id — The unique identifier of the AI agent to be retrieved.
## ai.koog.agents.core.agent.AIAgentServiceBase.createAgentAndRun

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/create-agent-and-run.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun createAgentAndRun(agentInput: Input, id: String? = null, additionalToolRegistry: ToolRegistry = this.toolRegistry, agentConfig: AIAgentConfig = this.agentConfig, clock: KoogClock = KoogClock.System): Output
```

Creates an AI agent with the specified configuration and runs it using the provided input.

The output generated by the agent after processing the input.

- agentInput — The input data to be processed by the agent.
- id — An optional unique identifier for the agent. If null, a default identifier will be generated.
- additionalToolRegistry — The tool registry to be used by the agent. Defaults to the service's tool registry.
- agentConfig — The configuration parameters for the AI agent. Defaults to the service's agent configuration.
- clock — The clock instance used for managing time-related operations. Defaults to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.AIAgentServiceBase.createAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/create-agent.html`

### :agents:agents-core/commonMain

```kotlin
suspend override fun createAgent(id: String? = null, additionalToolRegistry: ToolRegistry = ToolRegistry.EMPTY, agentConfig: AIAgentConfig = this.agentConfig, clock: KoogClock = KoogClock.System): TAgent
```

Creates and registers a new managed AI agent with the specified configuration and tool registry.

A new instance of AIAgent initialized with the specified parameters.

- id — An optional unique identifier for the AI agent. If null, a default identifier will be generated.
- additionalToolRegistry — A tool registry with additional tools available to the AI agent.
- agentConfig — The configuration for the AI agent, including settings for its behavior and capabilities.
- clock — The clock instance used for managing time-related operations.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.AIAgentServiceBase.createManagedAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/create-managed-agent.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun createManagedAgent(id: String? = null, additionalToolRegistry: ToolRegistry, agentConfig: AIAgentConfig, clock: KoogClock = KoogClock.System): TAgent
```

Creates and registers a new managed AI agent with the specified configuration and tool registry.

A new instance of AIAgent initialized with the specified parameters.

- id — An optional unique identifier for the AI agent. If null, a default identifier will be generated.
- additionalToolRegistry — A tool registry with additional tools available to the AI agent.
- agentConfig — The configuration for the AI agent, including settings for its behavior and capabilities.
- clock — The clock instance used for managing time-related operations. Defaults to the system clock.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.AIAgentServiceBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentServiceBase<Input, Output, TAgent : AIAgent<Input, Output>> : AIAgentService<Input, Output, TAgent>
```

Abstract base class for implementing an AI Agent Service. This class provides foundational functionality for managing and interacting with AI agents.

The class maintains a list of AI agents under its management and defines common operations, such as creation, removal, querying, and shutting down agents. Concrete implementations are expected to define the behavior for creating managed agents.

- Input — the input type expected by the AI agents.
- Output — the output type expected from the AI agents.
- GraphAIAgentService
- FunctionalAIAgentService
## ai.koog.agents.core.agent.AIAgentServiceBase.removeAgentWithId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/remove-agent-with-id.html`

### :agents:agents-core/commonMain

```kotlin
suspend override fun removeAgentWithId(id: String): Boolean
```

Removes a managed AI agent identified by the specified unique identifier.

true if the agent was successfully removed, false if no agent with the given ID exists.

- id — The unique identifier of the AI agent to be removed.
## ai.koog.agents.core.agent.AIAgentServiceBase.removeAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service-base/remove-agent.html`

### :agents:agents-core/commonMain

```kotlin
suspend override fun removeAgent(agent: TAgent): Boolean
```

Removes the specified AI agent from the managed collection.

true if the agent was successfully removed, or false if the agent was not found or could not be removed.

- agent — The AI agent to be removed. This agent must be part of the managed agents' collection.
## ai.koog.agents.core.agent.AIAgentService

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-service.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgentService(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentGraphStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgentService<Input, Output>
```

Creates a GraphAIAgentService instance with the provided configuration, strategy, tool registry, and optional feature installation logic.

A GraphAIAgentService instance configured with the provided parameters.

- promptExecutor — The executor responsible for processing AI prompts and responses.
- agentConfig — Configuration parameters for the AI agent.
- strategy — A strategy defining the graph structure for AI agent interactions and processing.
- toolRegistry — The registry of tools available to the agent. Defaults to an empty registry.
- installFeatures — A lambda expression to install additional features in the agent's feature context.
- Input — The input type that the service processes.
- Output — The output type that the service produces.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgentService(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentFunctionalStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit = {}): FunctionalAIAgentService<Input, Output>
```

Creates a FunctionalAIAgentService instance with the provided parameters.

A FunctionalAIAgentService instance initialized with the given parameters.

- promptExecutor — The executor responsible for handling prompts and managing their execution.
- agentConfig — The configuration parameters for the AI agent.
- strategy — The functional strategy that defines the behavior and capabilities of the AI agent.
- toolRegistry — The registry containing tools that can be used by the agent. Defaults to an empty registry.
- installFeatures — A lambda expression to configure and install additional features to the AI agent context.
- Input — The type of input data expected by the service.
- Output — The type of output data produced by the service.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

### :agents:agents-core/commonMain

```kotlin
fun AIAgentService(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgentService<String, String>
```

Invokes the process to create and return an instance of GraphAIAgentService.

- promptExecutor — The executor responsible for handling prompts during the agent's operation.
- agentConfig — The configuration object for the AI agent.
- toolRegistry — The registry containing tools available for the agent to use. Defaults to an empty tool registry.
- installFeatures — A lambda function to install additional features into the agent's feature context.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgentService(promptExecutor: PromptExecutor, llmModel: LLModel, strategy: AIAgentGraphStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, systemPrompt: String? = null, temperature: Double? = null, maxIterations: Int = 50, responseProcessor: ResponseProcessor? = null, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgentService<Input, Output>
```

Creates a GraphAIAgentService with the default singleRunStrategy and the given model parameters.

A GraphAIAgentService instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- llmModel — Language model to use.
- strategy — Graph strategy defining the agent's workflow.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- systemPrompt — Optional system prompt for the agent.
- temperature — Optional sampling temperature for the model, typically between 0.0 and 1.0.
- maxIterations — Maximum number of agent iterations. Defaults to 50.
- responseProcessor — Optional processor for the model's responses.
- installFeatures — Lambda to install additional features into the agent's feature context.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`.

### :agents:agents-core/commonMain

```kotlin
fun AIAgentService(promptExecutor: PromptExecutor, llmModel: LLModel, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, systemPrompt: String? = null, temperature: Double? = null, maxIterations: Int = 50, responseProcessor: ResponseProcessor? = null, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgentService<String, String>
```

Creates a GraphAIAgentService with the default singleRunStrategy and the given model parameters.

A GraphAIAgentService instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- llmModel — Language model to use.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- systemPrompt — Optional system prompt for the agent.
- temperature — Optional sampling temperature for the model, typically between 0.0 and 1.0.
- maxIterations — Maximum number of agent iterations. Defaults to 50.
- responseProcessor — Optional processor for the model's responses.
- installFeatures — Lambda to install additional features into the agent's feature context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.AIAgentState.Failed.Failed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-failed/-failed.html`

### :agents:agents-core/commonMain

```kotlin
constructor(exception: Throwable)
```

## ai.koog.agents.core.agent.AIAgentState.Failed.exception

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-failed/exception.html`

### :agents:agents-core/commonMain

```kotlin
val exception: Throwable
```

## ai.koog.agents.core.agent.AIAgentState.Failed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
class Failed<Output>(val exception: Throwable) : AIAgentState<Output>
```

Represents a state indicating an operation has failed.

## ai.koog.agents.core.agent.AIAgentState.Finished.Finished

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-finished/-finished.html`

### :agents:agents-core/commonMain

```kotlin
constructor(result: Output)
```

- Output — The type of the result produced by the finished computation or process.
## ai.koog.agents.core.agent.AIAgentState.Finished

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-finished/index.html`

### :agents:agents-core/commonMain

```kotlin
class Finished<Output>(val result: Output) : AIAgentState<Output>
```

Represents the final state of a computation or process with its resulting output.

- Output — The type of the result produced by the finished computation or process.
## ai.koog.agents.core.agent.AIAgentState.Finished.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-finished/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: Output
```

## ai.koog.agents.core.agent.AIAgentState.NotStarted.NotStarted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-not-started/-not-started.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

## ai.koog.agents.core.agent.AIAgentState.NotStarted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-not-started/index.html`

### :agents:agents-core/commonMain

```kotlin
class NotStarted<Output> : AIAgentState<Output>
```

Represents a state that indicates an action or process has not yet started.

This class is part of the State sealed interface and is used to define a specific state where no progress, execution, or processing has occurred.

## ai.koog.agents.core.agent.AIAgentState.Running.Running

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-running/-running.html`

### :agents:agents-core/commonMain

```kotlin
constructor(rootContext: AIAgentContext)
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.AIAgentState.Running

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-running/index.html`

### :agents:agents-core/commonMain

```kotlin
class Running<Output>(val rootContext: AIAgentContext) : AIAgentState<Output>
```

Represents the Running state of an AI agent, indicating that the agent is actively executing its tasks.

This state provides access to the root context of the agent via the rootContext property, allowing interaction with the overall execution environment, configuration, and state management facilities.

The rootContext is marked with the @InternalAgentsApi annotation, meaning its usage is intended for internal agent-related implementations and may not maintain backwards compatibility.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.AIAgentState.Running.rootContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-running/root-context.html`

### :agents:agents-core/commonMain

```kotlin
val rootContext: AIAgentContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.AIAgentState.Starting.Starting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-starting/-starting.html`

### :agents:agents-core/commonMain

```kotlin
constructor()
```

- Output — The type of output associated with the state.
## ai.koog.agents.core.agent.AIAgentState.Starting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
class Starting<Output> : AIAgentState<Output>
```

Represents the starting state of an operation or process.

This class is a specialization of the State class, indicating the initial state prior to progression or change. It overrides the copy method to return a new instance of the same starting state.

- Output — The type of output associated with the state.
## ai.koog.agents.core.agent.AIAgentState

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent-state/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed interface AIAgentState<Output>
```

Represents the state of an AI agent during its lifecycle.

This sealed interface provides different states to reflect whether the agent has not started, is currently running, has completed its task successfully with a result, or has failed with an exception.

- NotStarted
- Starting
- Running
- Finished
- Failed
## ai.koog.agents.core.agent.AIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-a-i-agent.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgent(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentGraphStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgent<Input, Output>
```

Creates a GraphAIAgent with the given graph strategy and configuration.

A GraphAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- agentConfig — Configuration for the agent, including the prompt, model, and other parameters.
- strategy — Graph strategy defining the agent's workflow.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.
- Input — The type of input the agent processes.
- Output — The type of output the agent produces.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun AIAgent(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgent<String, String>
```

Creates a GraphAIAgent with the default singleRunStrategy and the given configuration.

A GraphAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- agentConfig — Configuration for the agent, including the prompt, model, and other parameters.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgent(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentFunctionalStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit = {}): FunctionalAIAgent<Input, Output>
```

Creates a FunctionalAIAgent with the given functional strategy and configuration.

A FunctionalAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- agentConfig — Configuration for the agent, including the prompt, model, and other parameters.
- strategy — Functional strategy defining the agent's execution logic.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.
- Input — The type of input the agent processes.
- Output — The type of output the agent produces.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgent(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentPlannerStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: PlannerAIAgent.FeatureContext.() -> Unit = {}): PlannerAIAgent<Input, Output>
```

Creates a PlannerAIAgent with the given planner strategy and configuration.

A PlannerAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- agentConfig — Configuration for the agent, including the prompt, model, and other parameters.
- strategy — Planner strategy defining the agent's workflow.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.
- Input — The type of input the agent processes.
- Output — The type of output the agent produces.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.planner`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgent(promptExecutor: PromptExecutor, llmModel: LLModel, strategy: AIAgentGraphStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, systemPrompt: String? = null, temperature: Double? = null, maxIterations: Int = 50, responseProcessor: ResponseProcessor? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgent<Input, Output>
```

Creates a GraphAIAgent with the given graph strategy and model parameters.

A GraphAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- llmModel — Language model to use.
- strategy — Graph strategy defining the agent's workflow.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- systemPrompt — Optional system prompt for the agent.
- temperature — Optional sampling temperature for the model, typically between 0.0 and 1.0.
- maxIterations — Maximum number of agent iterations. Defaults to 50.
- responseProcessor — Optional processor for the model's responses.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.
- Input — The type of input the agent processes.
- Output — The type of output the agent produces.

Referenced packages: `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun AIAgent(promptExecutor: PromptExecutor, llmModel: LLModel, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, systemPrompt: String? = null, temperature: Double? = null, maxIterations: Int = 50, responseProcessor: ResponseProcessor? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}): GraphAIAgent<String, String>
```

Creates a GraphAIAgent with the default singleRunStrategy and the given model parameters.

A GraphAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- llmModel — Language model to use.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- systemPrompt — Optional system prompt for the agent.
- temperature — Optional sampling temperature for the model, typically between 0.0 and 1.0.
- maxIterations — Maximum number of agent iterations. Defaults to 50.
- responseProcessor — Optional processor for the model's responses.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgent(promptExecutor: PromptExecutor, llmModel: LLModel, strategy: AIAgentFunctionalStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, systemPrompt: String? = null, temperature: Double? = null, maxIterations: Int = 50, responseProcessor: ResponseProcessor? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit = {}): FunctionalAIAgent<Input, Output>
```

Creates a FunctionalAIAgent with the given functional strategy and model parameters.

A FunctionalAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- llmModel — Language model to use.
- strategy — Functional strategy defining the agent's execution logic.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- systemPrompt — Optional system prompt for the agent.
- temperature — Optional sampling temperature for the model, typically between 0.0 and 1.0.
- maxIterations — Maximum number of agent iterations. Defaults to 50.
- responseProcessor — Optional processor for the model's responses.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.
- Input — The type of input the agent processes.
- Output — The type of output the agent produces.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> AIAgent(promptExecutor: PromptExecutor, llmModel: LLModel, strategy: AIAgentPlannerStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, systemPrompt: String? = null, temperature: Double? = null, maxIterations: Int = 50, responseProcessor: ResponseProcessor? = null, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: PlannerAIAgent.FeatureContext.() -> Unit = {}): PlannerAIAgent<Input, Output>
```

Creates a PlannerAIAgent with the given planner strategy and model parameters.

A PlannerAIAgent instance configured with the provided parameters.

- promptExecutor — Executor responsible for processing prompts and interacting with the language model.
- llmModel — Language model to use.
- strategy — Planner strategy defining the agent's workflow.
- toolRegistry — Registry of tools available to the agent. Defaults to an empty registry.
- systemPrompt — Optional system prompt for the agent.
- temperature — Optional sampling temperature for the model, typically between 0.0 and 1.0.
- maxIterations — Maximum number of agent iterations. Defaults to 50.
- responseProcessor — Optional processor for the model's responses.
- id — Unique identifier for the agent. A random UUID is used if null.
- clock — Clock for time-related operations. Defaults to KoogClock.System.
- installFeatures — Lambda to install additional features into the agent's feature context.
- Input — The type of input the agent processes.
- Output — The type of output the agent produces.

Referenced packages: `ai.koog.agents.core.planner`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAIAgent.FeatureContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/-feature-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class FeatureContext
```

Represents a context for managing and configuring features in an AI agent. Provides functionality to install and configure features into a specific instance of an AI agent.

## ai.koog.agents.core.agent.FunctionalAIAgent.FeatureContext.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/-feature-context/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <Config : FeatureConfig, Feature : Any> install(feature: AIAgentFunctionalFeature<Config, Feature>, configure: Config.() -> Unit = {})
```

Installs and configures a feature into the current AI agent context.

- feature — the feature to be added, defined by an implementation of AIAgentFeature, which provides specific functionality
- configure — an optional lambda to customize the configuration of the feature, where the provided Config can be modified

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.agent.FunctionalAIAgent.FunctionalAIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/-functional-a-i-agent.html`

### :agents:agents-core/commonMain

```kotlin
constructor(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentFunctionalStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit = {})
```

- id — Unique identifier for the agent. Random UUID will be generated if set to null.
- Input — The type of input data expected by the agent.
- Output — The type of output data produced by the agent.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAIAgent.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentConfig: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.FunctionalAIAgent.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/clock.html`

### :agents:agents-core/commonMain

```kotlin
val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/index.html`

### :agents:agents-core/commonMain

```kotlin
class FunctionalAIAgent<Input, Output>(val promptExecutor: PromptExecutor, val agentConfig: AIAgentConfig, val strategy: AIAgentFunctionalStrategy<Input, Output>, val toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, val clock: KoogClock = KoogClock.System, val installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit = {}) : AIAgentBase<Input, Output, AIAgentFunctionalContext>
```

Represents the core AI agent for processing input and generating output using a defined configuration, toolset, and prompt execution pipeline.

- id — Unique identifier for the agent. Random UUID will be generated if set to null.
- Input — The type of input data expected by the agent.
- Output — The type of output data produced by the agent.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAIAgent.installFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/install-features.html`

### :agents:agents-core/commonMain

```kotlin
val installFeatures: FunctionalAIAgent.FeatureContext.() -> Unit
```

## ai.koog.agents.core.agent.FunctionalAIAgent.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
open override val pipeline: AIAgentFunctionalPipeline
```

Represents the pipeline used by the AI agent for processing tasks or data.

This abstract property defines the structure or sequence of operations within the AI agent's pipeline. It serves as the core mechanism for executing workflows, handling inputs, and generating outputs in the AI agent's functionality.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.FunctionalAIAgent.prepareContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/prepare-context.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun prepareContext(agentInput: Input, runId: String, eventId: String): AIAgentFunctionalContext
```

Prepares and initializes the agent context required to handle the given input and run ID.

the initialized context specific to the agent setup for the provided input and run ID.

- agentInput — the input provided to the agent for processing.
- runId — a unique identifier representing the current execution or operation run.
- eventId — a unique identifier for agent-related events.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.FunctionalAIAgent.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
val promptExecutor: PromptExecutor
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.FunctionalAIAgent.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/strategy.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategy: AIAgentFunctionalStrategy<Input, Output>
```

## ai.koog.agents.core.agent.FunctionalAIAgent.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-a-i-agent/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
val toolRegistry: ToolRegistry
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.FunctionalAgentBuilder.FunctionalAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-builder/-functional-agent-builder.html`

### :agents:agents-core/commonMain

```kotlin
constructor(strategy: AIAgentFunctionalStrategy<Input, Output>, promptExecutor: PromptExecutor? = null, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, config: AIAgentConfig, clock: KoogClock = KoogClock.System, featureInstallers: MutableList<FunctionalAIAgent.FeatureContext.() -> Unit> = mutableListOf())
```

- Input — The type of input that the resulting AI agent will process.
- Output — The type of output that the resulting AI agent will produce.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAgentBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): AIAgent<Input, Output>
```

Builds and returns an instance of AIAgent<Input, Output> based on the current configuration of the FunctionalAgentBuilder. This method ensures that all required fields are set, and applies any configured feature installers to the agent.

an instance of AIAgent<Input, Output> created using the provided configuration.

- IllegalArgumentException — if required fields, such as promptExecutor or llmModel, are not set.
## ai.koog.agents.core.agent.FunctionalAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class FunctionalAgentBuilder<Input, Output>(strategy: AIAgentFunctionalStrategy<Input, Output>, promptExecutor: PromptExecutor? = null, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, config: AIAgentConfig, clock: KoogClock = KoogClock.System, featureInstallers: MutableList<FunctionalAIAgent.FeatureContext.() -> Unit> = mutableListOf()) : AIAgentBuilderBase<FunctionalAgentBuilder<Input, Output>>
```

A builder class for constructing instances of FunctionalAIAgent with customizable configuration.

This builder simplifies the configuration process by providing a fluent API to set various parameters for the FunctionalAIAgent, including its behavior strategy, prompt details, model settings, tool registry, and additional features. The builder enforces the presence of required configurations and allows the addition of optional parameters to tailor the agent's functionality.

- Input — The type of input that the resulting AI agent will process.
- Output — The type of output that the resulting AI agent will produce.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.FunctionalAgentBuilder.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-functional-agent-builder/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentFunctionalFeature<TConfig, *>, configure: ConfigureAction<TConfig>): FunctionalAgentBuilder<Input, Output>
```

Installs and configures a given feature into the functional agent builder.

the current FunctionalAgentBuilder instance for chaining further configurations.

- feature — the feature to be installed, represented by an implementation of AIAgentFunctionalFeature.
- configure — a lambda function to customize the configuration of the feature, where the provided TConfig can be modified.
- TConfig — the type of the feature configuration, which extends FeatureConfig.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`, `ai.koog.agents.core.utils`.

## ai.koog.agents.core.agent.GraphAIAgent.FeatureContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/-feature-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class FeatureContext
```

The context for adding and configuring features in a Kotlin AI Agent instance.

Note: The method is used to hide internal install() method from a public API to prevent calls in an AIAgent instance, like agent.install(MyFeature) { ... }. This makes the API a bit stricter and clear.

## ai.koog.agents.core.agent.GraphAIAgent.FeatureContext.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/-feature-context/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <Config : FeatureConfig, Feature : Any> install(feature: AIAgentGraphFeature<Config, Feature>, configure: Config.() -> Unit = {})
```

Installs and configures a feature into the current AI agent context.

- feature — the feature to be added, defined by an implementation of AIAgentFeature, which provides specific functionality
- configure — an optional lambda to customize the configuration of the feature, where the provided Config can be modified

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.agent.GraphAIAgent.GraphAIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/-graph-a-i-agent.html`

### :agents:agents-core/commonMain

```kotlin
constructor(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentGraphStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {})
```

Initializes the AI agent instance and prepares the feature context and pipeline for use.

- id — Unique identifier for the agent. Random UUID will be generated if set to null.
- Input — Type of agent input.
- Output — Type of agent output.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.GraphAIAgent.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentConfig: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.agent.GraphAIAgent.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/clock.html`

### :agents:agents-core/commonMain

```kotlin
val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.agent.GraphAIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/index.html`

### :agents:agents-core/commonMain

```kotlin
open class GraphAIAgent<Input, Output>(val promptExecutor: PromptExecutor, val agentConfig: AIAgentConfig, val strategy: AIAgentGraphStrategy<Input, Output>, val toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, val clock: KoogClock = KoogClock.System, val installFeatures: GraphAIAgent.FeatureContext.() -> Unit = {}) : AIAgentBase<Input, Output, AIAgentGraphContextBase>
```

Represents an implementation of an AI agent that provides functionalities to execute prompts, manage tools, handle agent pipelines, and interact with various configurable strategies and features.

The agent operates within a coroutine scope and leverages a tool registry and feature context to enable dynamic additions or configurations during its lifecycle. Its behavior is driven by a local agent strategy and executed via a prompt executor.

- id — Unique identifier for the agent. Random UUID will be generated if set to null.
- Input — Type of agent input.
- Output — Type of agent output.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.GraphAIAgent.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```

TypeToken representing Input - agent input.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.GraphAIAgent.installFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/install-features.html`

### :agents:agents-core/commonMain

```kotlin
val installFeatures: GraphAIAgent.FeatureContext.() -> Unit
```

## ai.koog.agents.core.agent.GraphAIAgent.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/output-type.html`

### :agents:agents-core/commonMain

```kotlin
val outputType: TypeToken
```

TypeToken representing Output - agent output.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.GraphAIAgent.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
open override val pipeline: AIAgentGraphPipeline
```

Represents the pipeline used by the AI agent for processing tasks or data.

This abstract property defines the structure or sequence of operations within the AI agent's pipeline. It serves as the core mechanism for executing workflows, handling inputs, and generating outputs in the AI agent's functionality.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.agent.GraphAIAgent.prepareContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/prepare-context.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun prepareContext(agentInput: Input, runId: String, eventId: String): AIAgentGraphContextBase
```

Prepares and initializes the agent context required to handle the given input and run ID.

the initialized context specific to the agent setup for the provided input and run ID.

- agentInput — the input provided to the agent for processing.
- runId — a unique identifier representing the current execution or operation run.
- eventId — a unique identifier for agent-related events.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.GraphAIAgent.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
val promptExecutor: PromptExecutor
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.agent.GraphAIAgent.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/strategy.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategy: AIAgentGraphStrategy<Input, Output>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.GraphAIAgent.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-a-i-agent/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
val toolRegistry: ToolRegistry
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.agent.GraphAgentBuilder.GraphAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-builder/-graph-agent-builder.html`

### :agents:agents-core/commonMain

```kotlin
constructor(strategy: AIAgentGraphStrategy<Input, Output>, promptExecutor: PromptExecutor? = null, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, config: AIAgentConfig, clock: KoogClock = KoogClock.System, featureInstallers: MutableList<GraphAIAgent.FeatureContext.() -> Unit> = mutableListOf())
```

- strategy — The execution strategy used by the agent for processing input and generating results.
- promptExecutor — PromptExecutor for the agent
- id — id of the agent
- config — AIAgentConfig containing initial agent configuration for the builder
- clock — optional KoogClock to be used in the agent for calculating timestamps
- Input — The input type that the agent processes.
- Output — The output type that the agent produces.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.GraphAgentBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-builder/build.html`

### :agents:agents-core/commonMain

```kotlin
fun build(): AIAgent<Input, Output>
```

Builds and returns an instance of AIAgent configured using the parameters provided to the GraphAgentBuilder.

an instance of AIAgent initialized with the specified input and output types, strategy, tool registry, prompt executor, model configuration, and other optional settings.

## ai.koog.agents.core.agent.GraphAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-builder/index.html`

### :agents:agents-core/commonMain

```kotlin
class GraphAgentBuilder<Input, Output>(strategy: AIAgentGraphStrategy<Input, Output>, promptExecutor: PromptExecutor? = null, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, config: AIAgentConfig, clock: KoogClock = KoogClock.System, featureInstallers: MutableList<GraphAIAgent.FeatureContext.() -> Unit> = mutableListOf()) : AIAgentBuilderBase<GraphAgentBuilder<Input, Output>>
```

A builder class for creating instances of AIAgent. This builder provides a fluent interface to configure various parameters and components required to construct an AI agent with a specific set of features, tools, and execution strategies.

- strategy — The execution strategy used by the agent for processing input and generating results.
- promptExecutor — PromptExecutor for the agent
- id — id of the agent
- config — AIAgentConfig containing initial agent configuration for the builder
- clock — optional KoogClock to be used in the agent for calculating timestamps
- Input — The input type that the agent processes.
- Output — The output type that the agent produces.

Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.agent.GraphAgentBuilder.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/-graph-agent-builder/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <TConfig : FeatureConfig> install(feature: AIAgentGraphFeature<TConfig, *>, configure: ConfigureAction<TConfig>): GraphAgentBuilder<Input, Output>
```

Installs a specified feature into the current context and applies its configuration.

The current GraphAgentBuilder instance, enabling further configurations.

- feature — The feature to install, represented by an implementation of AIAgentGraphFeature.
- configure — A lambda used to customize the configuration of the feature.
- TConfig — The type of configuration required by the feature, extending FeatureConfig.

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`, `ai.koog.agents.core.utils`.

### :agents:agents-core/commonMain

```kotlin
fun install(featureInstaller: GraphAIAgent.FeatureContext.() -> Unit): GraphAgentBuilder<Input, Output>
```

Installs a new feature into the GraphAgentBuilder.

The updated instance of GraphAgentBuilder with the newly added feature.

- featureInstaller — A lambda function that utilizes the FeatureContext to define the feature to be installed.
## ai.koog.agents.core.agent.functionalStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/functional-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> functionalStrategy(name: String = "funStrategy", func: suspend AIAgentFunctionalContext.(input: Input) -> Output): AIAgentFunctionalStrategy<Input, Output>
```

Creates an AIAgentFunctionalStrategy with the specified loop logic and name.

This function allows the definition of custom looping strategies for AI agents, where the provided logic defines how the agent processes input and produces output within its execution context.

An instance of AIAgentFunctionalStrategy configured with the given loop logic and name.

- name — The name of the strategy, used to identify and describe the strategy. Defaults to "funStrategy".
- func — A suspending function representing the loop logic of the strategy. It accepts an input of type Input and is executed within an AIAgentFunctionalContext, producing an output of type Output.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.agent.singleRunStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent/single-run-strategy.html`

### :agents:agents-core/commonMain

```kotlin
fun singleRunStrategy(parallelTools: Boolean = false): AIAgentGraphStrategy<String, String>
```

Creates a single-run strategy for an AI agent. This strategy defines a simple execution flow where the agent processes input, calls tools, and sends results back to the agent. The flow consists of the following steps:

Start the agent.

Call the LLM with the input.

Execute a tool based on the LLM's response.

Send the tool result back to the LLM.

Repeat until LLM indicates no further tool calls are needed or the agent finishes.

An instance of AIAgentStrategy configured according to the specified run mode.

- parallelTools — if true, tools will be executed in parallel, otherwise sequentially

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.config.AIAgentConfig.AIAgentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-a-i-agent-config.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(prompt: Prompt, model: LLModel, maxAgentIterations: Int, missingToolsConversionStrategy: MissingToolsConversionStrategy = MissingToolsConversionStrategy.Missing(ToolCallDescriber.JSON), responseProcessor: ResponseProcessor? = null, serializer: JSONSerializer = KotlinxSerializer())
```

- prompt — The initial prompt configuration for the agent, encapsulating messages, model, and parameters.
- model — The model to use for the agent's prompt execution
- maxAgentIterations — The maximum number of iterations allowed for an agent during its execution to prevent infinite loops.
- missingToolsConversionStrategy — Strategy used to determine how tool calls, present in the prompt but lacking definitions, are handled during agent execution. This property provides a mechanism to convert or format missing tool calls and result messages when they occur, typically due to differences in tool sets between steps or subgraphs while the same history is reused. This ensures the prompt remains consistent and readable for the model, even with undefined tools.
- responseProcessor — Optional processor for the agent's responses. If specified, will modify the responses from the llm.
- serializer — Optional serializer to (de)serialize tool arguments and results. Defaults to KotlinxSerializer

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, maxAgentIterations: Int, strategyExecutor: Executor?, llmRequestExecutor: Executor? = null, missingToolsConversionStrategy: MissingToolsConversionStrategy = MissingToolsConversionStrategy.Missing(ToolCallDescriber.JSON), responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, serializer: ERROR CLASS: Symbol not found for JSONSerializer = JacksonSerializer())
```

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(prompt: ERROR CLASS: Symbol not found for Prompt, model: ERROR CLASS: Symbol not found for LLModel, maxAgentIterations: Int, missingToolsConversionStrategy: MissingToolsConversionStrategy, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??, serializer: ERROR CLASS: Symbol not found for JSONSerializer)
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(prompt: Prompt, model: LLModel, maxAgentIterations: Int, missingToolsConversionStrategy: MissingToolsConversionStrategy, responseProcessor: ResponseProcessor?, serializer: JSONSerializer)
```

- prompt — The initial prompt configuration for the agent, encapsulating messages, model, and parameters.
- model — The model to use for the agent's prompt execution
- maxAgentIterations — The maximum number of iterations allowed for an agent during its execution to prevent infinite loops.
- missingToolsConversionStrategy — Strategy used to determine how tool calls, present in the prompt but lacking definitions, are handled during agent execution. This property provides a mechanism to convert or format missing tool calls and result messages when they occur, typically due to differences in tool sets between steps or subgraphs while the same history is reused. This ensures the prompt remains consistent and readable for the model, even with undefined tools.
- responseProcessor — Optional processor for the agent's responses. If specified, will modify the responses from the llm.
- serializer — Optional serializer to (de)serialize tool arguments and results. Defaults to KotlinxSerializer

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.processor`, `ai.koog.serialization`.

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.AIAgentConfigBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/-a-i-agent-config-builder.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
constructor(model: ERROR CLASS: Symbol not found for LLModel, prompt: ERROR CLASS: Symbol not found for Prompt?? = null, maxAgentIterations: Int? = null, missingToolsConversionStrategy: MissingToolsConversionStrategy? = null, responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, strategyExecutor: Executor? = null, llmRequestExecutor: Executor? = null, serializer: ERROR CLASS: Symbol not found for JSONSerializer = JacksonSerializer())
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.build

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/build.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun build(): AIAgentConfig
```

Constructs and returns an instance of AIAgentConfig using the values configured in the builder. The method validates that all required fields are provided and assigns default values to optional fields if they are not explicitly set.

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/index.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
class AIAgentConfigBuilder(val model: ERROR CLASS: Symbol not found for LLModel, var prompt: ERROR CLASS: Symbol not found for Prompt?? = null, var maxAgentIterations: Int? = null, var missingToolsConversionStrategy: MissingToolsConversionStrategy? = null, var responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor?? = null, strategyExecutor: Executor? = null, llmRequestExecutor: Executor? = null, serializer: ERROR CLASS: Symbol not found for JSONSerializer = JacksonSerializer())
```

A builder class for constructing an instance of AIAgentConfig with customizable configuration options.

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.llmRequestExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/llm-request-executor.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun llmRequestExecutor(executor: Executor?): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Sets the executor for handling LLM requests.

- executor — The executor to be used for executing LLM-related tasks. If null, no specific executor will be set.
## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.maxAgentIterations

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/max-agent-iterations.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun maxAgentIterations(maxAgentIterations: Int): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Sets the maximum number of iterations allowed for the AI agent during its execution.

- maxAgentIterations — The maximum number of iterations to be configured for the AI agent.
### :agents:agents-core/jvmCommonMain

```kotlin
var maxAgentIterations: Int?
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.missingToolsConversionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/missing-tools-conversion-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun missingToolsConversionStrategy(strategy: MissingToolsConversionStrategy): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Configures the strategy to handle missing tool definitions in prompts.

- strategy — The strategy defining how missing tools in prompt history are to be converted when sending prompts to the model.
### :agents:agents-core/jvmCommonMain

```kotlin
var missingToolsConversionStrategy: MissingToolsConversionStrategy?
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/model.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
val model: ERROR CLASS: Symbol not found for LLModel
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/prompt.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun prompt(prompt: ERROR CLASS: Symbol not found for Prompt): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Sets the prompt configuration for the AI agent.

- prompt — The prompt to configure the AI agent with.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var prompt: ERROR CLASS: Symbol not found for Prompt??
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.responseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/response-processor.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun responseProcessor(processor: ERROR CLASS: Symbol not found for ResponseProcessor??): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Assigns a custom response processor to the configuration builder. The response processor is responsible for processing and transforming the responses generated by the language model.

- processor — an instance of ResponseProcessor to handle the processing of LLM responses, or null to remove the existing processor.
### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var responseProcessor: ERROR CLASS: Symbol not found for ResponseProcessor??
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.serializer

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/serializer.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun serializer(serializer: ERROR CLASS: Symbol not found for JSONSerializer): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Sets serializer for underlying tool calls and LLM requests

- serializer — The JSON serializer to configure the AI agent with.
## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.AIAgentConfigBuilder.strategyExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-a-i-agent-config-builder/strategy-executor.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun strategyExecutor(executor: Executor?): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Sets the executor to be used for executing strategies within the agent configuration.

- executor — The executor to manage the execution of strategies. Can be null.
## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.InitialAIAgentBuilder.InitialAIAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-initial-a-i-agent-builder/-initial-a-i-agent-builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
constructor()
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.InitialAIAgentBuilder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-initial-a-i-agent-builder/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
class InitialAIAgentBuilder
```

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.InitialAIAgentBuilder.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/-initial-a-i-agent-builder/model.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun model(model: ERROR CLASS: Symbol not found for LLModel): AIAgentConfig.Companion.AIAgentConfigBuilder
```

Sets the Large Language Model (LLM) to be used for the agent's configuration.

- model — The instance of LLModel that represents the desired language model, including its provider, identifier, and capabilities.
## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.builder

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/builder.html`

### :agents:agents-core/jvmCommonMain

```kotlin
fun builder(): AIAgentConfig.Companion.InitialAIAgentBuilder
```

Provides a builder for constructing instances of AIAgentConfig.

This method returns an instance of InitialAIAgentBuilder, which allows the configuration of various properties and dependencies required to build an AIAgentConfig instance.

The builder pattern offers a flexible way to set optional parameters and ensures that mandatory properties are properly initialized during the construction of the configuration object.

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
expect object Companion
```

Companion object for providing utility methods related to AIAgentConfig.

### :agents:agents-core/jvmCommonMain

```kotlin
actual object Companion
```

Companion object for providing utility methods related to AIAgentConfig.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual object Companion
```

Companion object for providing utility methods related to AIAgentConfig.

## ai.koog.agents.core.agent.config.AIAgentConfig.Companion.withSystemPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/-companion/with-system-prompt.html`

### :agents:agents-core/commonMain

```kotlin
expect fun withSystemPrompt(prompt: String, llm: LLModel = OpenAIModels.Chat.GPT4o, id: String = "koog-agents", maxAgentIterations: Int = 3): AIAgentConfig
```

Creates an AI agent configuration with a specified system prompt.

This function initializes an instance of AIAgentConfig using the provided system-level prompt and other optional parameters, such as the language model, configuration ID, and maximum agent iterations.

An instance of AIAgentConfig representing the AI agent configuration with the specified parameters.

- prompt — The content of the system prompts to define the context and instructions for the AI agent.
- llm — The Large Language Model (LLM) to be used for the AI agent. Defaults to OpenAIModels.Chat.GPT4o.
- id — The identifier for the agent configuration. Defaults to "koog-agents".
- maxAgentIterations — The maximum number of iterations the agent can perform to avoid infinite loops. Defaults to 3.

Referenced packages: `ai.koog.prompt.llm`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual fun withSystemPrompt(prompt: String, llm: ERROR CLASS: Symbol not found for LLModel, id: String, maxAgentIterations: Int): AIAgentConfig
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual fun withSystemPrompt(prompt: String, llm: LLModel, id: String, maxAgentIterations: Int): AIAgentConfig
```

Creates an AI agent configuration with a specified system prompt.

This function initializes an instance of AIAgentConfig using the provided system-level prompt and other optional parameters, such as the language model, configuration ID, and maximum agent iterations.

An instance of AIAgentConfig representing the AI agent configuration with the specified parameters.

- prompt — The content of the system prompts to define the context and instructions for the AI agent.
- llm — The Large Language Model (LLM) to be used for the AI agent. Defaults to OpenAIModels.Chat.GPT4o.
- id — The identifier for the agent configuration. Defaults to "koog-agents".
- maxAgentIterations — The maximum number of iterations the agent can perform to avoid infinite loops. Defaults to 3.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.config.AIAgentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentConfig : AIAgentConfigBase
```

Configuration class for an AI agent that specifies the prompt, execution parameters, and behavior.

This class is responsible for defining the various settings and components required for an AI agent to operate. It includes the prompt configuration, iteration limits, and strategies for handling missing tools during execution.

- prompt — The initial prompt configuration for the agent, encapsulating messages, model, and parameters.
- model — The model to use for the agent's prompt execution
- maxAgentIterations — The maximum number of iterations allowed for an agent during its execution to prevent infinite loops.
- missingToolsConversionStrategy — Strategy used to determine how tool calls, present in the prompt but lacking definitions, are handled during agent execution. This property provides a mechanism to convert or format missing tool calls and result messages when they occur, typically due to differences in tool sets between steps or subgraphs while the same history is reused. This ensures the prompt remains consistent and readable for the model, even with undefined tools.
- responseProcessor — Optional processor for the agent's responses. If specified, will modify the responses from the llm.
- serializer — Optional serializer to (de)serialize tool arguments and results. Defaults to KotlinxSerializer
### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentConfig : AIAgentConfigBase
```

Configuration class for an AI agent that specifies the prompt, execution parameters, and behavior.

This class is responsible for defining the various settings and components required for an AI agent to operate. It includes the prompt configuration, iteration limits, and strategies for handling missing tools during execution.

- prompt — The initial prompt configuration for the agent, encapsulating messages, model, and parameters.
- model — The model to use for the agent's prompt execution
- maxAgentIterations — The maximum number of iterations allowed for an agent during its execution to prevent infinite loops.
- missingToolsConversionStrategy — Strategy used to determine how tool calls, present in the prompt but lacking definitions, are handled during agent execution. This property provides a mechanism to convert or format missing tool calls and result messages when they occur, typically due to differences in tool sets between steps or subgraphs while the same history is reused. This ensures the prompt remains consistent and readable for the model, even with undefined tools.
- responseProcessor — Optional processor for the agent's responses. If specified, will modify the responses from the llm.
- serializer — Optional serializer to (de)serialize tool arguments and results. Defaults to KotlinxSerializer
### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentConfig : AIAgentConfigBase
```

Configuration class for an AI agent that specifies the prompt, execution parameters, and behavior.

This class is responsible for defining the various settings and components required for an AI agent to operate. It includes the prompt configuration, iteration limits, and strategies for handling missing tools during execution.

- prompt — The initial prompt configuration for the agent, encapsulating messages, model, and parameters.
- model — The model to use for the agent's prompt execution
- maxAgentIterations — The maximum number of iterations allowed for an agent during its execution to prevent infinite loops.
- missingToolsConversionStrategy — Strategy used to determine how tool calls, present in the prompt but lacking definitions, are handled during agent execution. This property provides a mechanism to convert or format missing tool calls and result messages when they occur, typically due to differences in tool sets between steps or subgraphs while the same history is reused. This ensures the prompt remains consistent and readable for the model, even with undefined tools.
- responseProcessor — Optional processor for the agent's responses. If specified, will modify the responses from the llm.
- serializer — Optional serializer to (de)serialize tool arguments and results. Defaults to KotlinxSerializer
## ai.koog.agents.core.agent.config.AIAgentConfig.llmRequestDispatcher

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/llm-request-dispatcher.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var llmRequestDispatcher: ERROR CLASS: Symbol not found for CoroutineDispatcher
```

IO-bounded CoroutineDispatcher for performing LLM communications

By default, all IO/LLM operations will be performed on Dispatchers.IO

## ai.koog.agents.core.agent.config.AIAgentConfig.maxAgentIterations

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/max-agent-iterations.html`

### :agents:agents-core/jvmCommonMain

```kotlin
actual val maxAgentIterations: Int
```

Specifies the maximum number of iterations an AI agent is allowed to execute.

This property defines the upper limit on the number of cycles the AI agent can perform during its

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual val maxAgentIterations: Int
```

Specifies the maximum number of iterations an AI agent is allowed to execute.

This property defines the upper limit on the number of cycles the AI agent can perform during its

## ai.koog.agents.core.agent.config.AIAgentConfig.missingToolsConversionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/missing-tools-conversion-strategy.html`

### :agents:agents-core/jvmCommonMain

```kotlin
actual val missingToolsConversionStrategy: MissingToolsConversionStrategy
```

Defines the strategy for converting tool calls in the prompt when some tool definitions are missing in the request. This is particularly relevant when managing multi-stage processing or subgraphs where tools used in different

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual val missingToolsConversionStrategy: MissingToolsConversionStrategy
```

Defines the strategy for converting tool calls in the prompt when some tool definitions are missing in the request. This is particularly relevant when managing multi-stage processing or subgraphs where tools used in different

## ai.koog.agents.core.agent.config.AIAgentConfig.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/model.html`

### :agents:agents-core/jvmCommonMain

```kotlin
actual open override val model: LLModel
```

Specifies the Large Language Model (LLM) used by the AI agent for generating responses.

The model defines configurations such as the specific LLM provider, its identifier, and supported capabilities (e.g., temperature control, tool usage). It plays a vital role in determining how the AI agent processes and generates outputs in response to user prompts and tasks.


Referenced packages: `ai.koog.prompt.llm`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open override val model: LLModel
```

Specifies the Large Language Model (LLM) used by the AI agent for generating responses.

The model defines configurations such as the specific LLM provider, its identifier, and supported capabilities (e.g., temperature control, tool usage). It plays a vital role in determining how the AI agent processes and generates outputs in response to user prompts and tasks.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.config.AIAgentConfig.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/prompt.html`

### :agents:agents-core/jvmCommonMain

```kotlin
actual open override val prompt: Prompt
```

Defines the Prompt to be used in the AI agent's configuration.

The prompt serves as the input structure for generating outputs from the language model and consists of a list of messages, a unique identifier, and optional parameters. This property plays a role in managing conversational state, input prompts, and configurations for the language model.


Referenced packages: `ai.koog.prompt`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual open override val prompt: Prompt
```

Defines the Prompt to be used in the AI agent's configuration.

The prompt serves as the input structure for generating outputs from the language model and consists of a list of messages, a unique identifier, and optional parameters. This property plays a role in managing conversational state, input prompts, and configurations for the language model.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.config.AIAgentConfig.responseProcessor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/response-processor.html`

### :agents:agents-core/jvmCommonMain

```kotlin
actual val responseProcessor: ResponseProcessor?
```

The response processor used for handling and modifying responses generated by LLM.

This optional property allows customization of response processing logic. A ResponseProcessor can perform tasks such as filtering, enriching, or otherwise transforming generated responses before they are returned or utilized.

Tipical usecase for ResponseProcessor is to extract tool calls from plasin textual responses (sometimes small models return tool calls as part of the textual assistant message instead of using tools API).


Referenced packages: `ai.koog.prompt.processor`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual val responseProcessor: ResponseProcessor?
```

The response processor used for handling and modifying responses generated by LLM.

This optional property allows customization of response processing logic. A ResponseProcessor can perform tasks such as filtering, enriching, or otherwise transforming generated responses before they are returned or utilized.

Tipical usecase for ResponseProcessor is to extract tool calls from plasin textual responses (sometimes small models return tool calls as part of the textual assistant message instead of using tools API).


Referenced packages: `ai.koog.prompt.processor`.

## ai.koog.agents.core.agent.config.AIAgentConfig.serializer

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/serializer.html`

### :agents:agents-core/jvmCommonMain

```kotlin
actual val serializer: JSONSerializer
```

Serializer to (de)serialize tool arguments and results.


Referenced packages: `ai.koog.serialization`.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual val serializer: JSONSerializer
```

Serializer to (de)serialize tool arguments and results.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.config.AIAgentConfig.strategyDispatcher

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config/strategy-dispatcher.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
var strategyDispatcher: ERROR CLASS: Symbol not found for CoroutineDispatcher
```

CoroutineDispatcher for running agent strategy logic

By default, all agent operations will be performed on Dispatchers.Default

## ai.koog.agents.core.agent.config.AIAgentConfigBase

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config-base/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentConfigBase
```

Base interface for AI agent configs.

- AIAgentConfig
## ai.koog.agents.core.agent.config.AIAgentConfigBase.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config-base/model.html`

### :agents:agents-core/commonMain

```kotlin
abstract val model: LLModel
```

Specifies the Large Language Model (LLM) used by the AI agent for generating responses.

The model defines configurations such as the specific LLM provider, its identifier, and supported capabilities (e.g., temperature control, tool usage). It plays a vital role in determining how the AI agent processes and generates outputs in response to user prompts and tasks.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.agent.config.AIAgentConfigBase.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-a-i-agent-config-base/prompt.html`

### :agents:agents-core/commonMain

```kotlin
abstract val prompt: Prompt
```

Defines the Prompt to be used in the AI agent's configuration.

The prompt serves as the input structure for generating outputs from the language model and consists of a list of messages, a unique identifier, and optional parameters. This property plays a role in managing conversational state, input prompts, and configurations for the language model.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.All.All

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-all/-all.html`

### :agents:agents-core/commonMain

```kotlin
constructor(format: ToolCallDescriber)
```

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.All.convertPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-all/convert-prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override fun convertPrompt(prompt: Prompt, tools: List<ToolDescriptor>): Prompt
```

Converts a given Prompt by applying modifications based on the provided list of ToolDescriptor.

A new Prompt instance with applied changes based on the provided tools.

- prompt — The original Prompt to be converted.
- tools — The list of ToolDescriptor used to modify or adapt the Prompt.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.All

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-all/index.html`

### :agents:agents-core/commonMain

```kotlin
class All(format: ToolCallDescriber) : MissingToolsConversionStrategy
```

Replace all real tool call and response messages with their dumps to the specified format, and use them as plaintext messages.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.Missing.Missing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-missing/-missing.html`

### :agents:agents-core/commonMain

```kotlin
constructor(format: ToolCallDescriber)
```

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.Missing.convertPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-missing/convert-prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override fun convertPrompt(prompt: Prompt, tools: List<ToolDescriptor>): Prompt
```

Converts a given Prompt by applying modifications based on the provided list of ToolDescriptor.

A new Prompt instance with applied changes based on the provided tools.

- prompt — The original Prompt to be converted.
- tools — The list of ToolDescriptor used to modify or adapt the Prompt.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.Missing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-missing/index.html`

### :agents:agents-core/commonMain

```kotlin
class Missing(format: ToolCallDescriber) : MissingToolsConversionStrategy
```

Replace only missing real tool call and response messages with their dumps to the specified format, and use them as plaintext messages. The tool calls whose definitions are not missing, will be left as real tool calls and responses.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.MissingToolsConversionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/-missing-tools-conversion-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor(format: ToolCallDescriber)
```

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.convertMessage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/convert-message.html`

### :agents:agents-core/commonMain

```kotlin
fun convertMessage(message: Message, toolNames: List<String>): Message
```

Converts the given message by formatting specific types of tool-related messages (e.g., MessagePart.Tool.Call and MessagePart.Tool.Result) into descriptive messages. If the message is not a tool-related message, it remains unchanged.

The converted message, either modified if it's a tool-related message, or unchanged otherwise.

- message — The input message to be converted.
- toolNames — The list of tool names used to determine which tools are present in the call. If not, the message part should be converted.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy.convertPrompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/convert-prompt.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun convertPrompt(prompt: Prompt, tools: List<ToolDescriptor>): Prompt
```

Converts a given Prompt by applying modifications based on the provided list of ToolDescriptor.

A new Prompt instance with applied changes based on the provided tools.

- prompt — The original Prompt to be converted.
- tools — The list of ToolDescriptor used to modify or adapt the Prompt.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`.

## ai.koog.agents.core.agent.config.MissingToolsConversionStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.config/-missing-tools-conversion-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class MissingToolsConversionStrategy(format: ToolCallDescriber)
```

Determines how the tool calls which are present in the prompt, but whose definitions are not present in the request, are converted when sending to the Model.

Missing tool definitions usually occur when different sets of tools are used between stages/subgraphs, and the same prompt history is used without compression.

- All
- Missing
## ai.koog.agents.core.agent.exception.AIAgentException.AIAgentException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-exception/-a-i-agent-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(problem: String, throwable: Throwable? = null)
```

Creates an instance of AgentException.

- problem — Description of the problem encountered by the AI Agent.
- throwable — Optional cause of the exception, which can provide additional context about the error.
## ai.koog.agents.core.agent.exception.AIAgentException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
open class AIAgentException(problem: String, throwable: Throwable? = null) : Exception
```

Represents a custom exception class for use in AI Agent-related processes.

This exception is thrown when the AI Agent encounters a specific problem that requires handling or reporting. It extends the base Exception class and provides a detailed message for easier identification of the issue.

- problem — Description of the problem encountered by the AI Agent.
- throwable — Optional cause of the exception, which can provide additional context about the error.
- AIAgentStuckInTheNodeException
- AIAgentMaxNumberOfIterationsReachedException
- AIAgentTerminationByClientException
## ai.koog.agents.core.agent.exception.AIAgentMaxNumberOfIterationsReachedException.AIAgentMaxNumberOfIterationsReachedException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-max-number-of-iterations-reached-exception/-a-i-agent-max-number-of-iterations-reached-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(maxNumberOfIterations: Int)
```

Creates an instance of this exception with the specified maximum number of iterations.

- maxNumberOfIterations — The maximum number of iterations allowed for the agent before the exception is triggered.
## ai.koog.agents.core.agent.exception.AIAgentMaxNumberOfIterationsReachedException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-max-number-of-iterations-reached-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentMaxNumberOfIterationsReachedException(maxNumberOfIterations: Int) : AIAgentException
```

Exception thrown when an agent exceeds the maximum allowed number of iterations during execution.

This exception indicates that the agent could not complete its task within the specified number of steps, as defined by the maxAgentIterations parameter in the agent's configuration. To resolve this, consider increasing the value of maxAgentIterations to accommodate more iterations for the agent's task completion.

- maxNumberOfIterations — The maximum number of iterations allowed for the agent before the exception is triggered.
## ai.koog.agents.core.agent.exception.AIAgentStuckInTheNodeException.AIAgentStuckInTheNodeException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-stuck-in-the-node-exception/-a-i-agent-stuck-in-the-node-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(node: AIAgentNodeBase<*, *>, output: Any?)
```

- node — The node in which the agent becomes stuck.
- output — The output produced by the node that doesn't match any edge conditions.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.exception.AIAgentStuckInTheNodeException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-stuck-in-the-node-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentStuckInTheNodeException(node: AIAgentNodeBase<*, *>, output: Any?) : AIAgentException
```

Exception thrown when an agent becomes stuck in a specific node during the execution of the agent graph. This typically occurs when the output produced by the node does not match any conditions on the available edges, preventing further progress in the graph execution.

- node — The node in which the agent becomes stuck.
- output — The output produced by the node that doesn't match any edge conditions.

Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.agent.exception.AIAgentTerminationByClientException.AIAgentTerminationByClientException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-termination-by-client-exception/-a-i-agent-termination-by-client-exception.html`

### :agents:agents-core/commonMain

```kotlin
constructor(message: String)
```

- message — A descriptive message explaining the reason for termination.
## ai.koog.agents.core.agent.exception.AIAgentTerminationByClientException

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.exception/-a-i-agent-termination-by-client-exception/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentTerminationByClientException(message: String) : AIAgentException
```

This exception is thrown when an agent is terminated by a client request. It extends the AIAgentException class, providing a specific message indicating that the agent's operation was canceled by the client.

- message — A descriptive message explaining the reason for termination.