# Planner strategies, GOAP, and LLM planning

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.planner.AIAgentPlanner.AIAgentPlanner

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner/-a-i-agent-planner.html`

### :agents:agents-core/commonMain

```kotlin
constructor(stateType: TypeToken? = null, planType: TypeToken? = null)
```

- stateType — TypeToken of the State.
- planType — TypeToken of the Plan.stateType and planType are required for features which require serialization, e.g. persistence. if you use such features, you should provide the type tokens for the state and plan types. otherwise these parameters can be omitted.
- Input — The type of input provided to the planner.
- Output — The type of output produced by the planner.
- State — The internal state type managed by the planner.
- Plan — The type of plan produced by buildPlan.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.planner.AIAgentPlanner

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner/index.html`

### :agents:agents-core/commonMain

```kotlin
abstract class AIAgentPlanner<Input, Output, State : Any, Plan : Any>(val stateType: TypeToken? = null, val planType: TypeToken? = null)
```

An abstract base planner component, which can be used to implement different types of AI agent planner execution flows.

An entry point is an execute method, which accepts an Input and returns the Output after the execution.

Planner flow works as follows:

Initialize state from input: initializeState

Build a plan: buildPlan

Execute a step in the plan: executeStep

Repeat steps 2 and 3 until the plan is considered completed.

Extract output from the final state: provideOutput

- stateType — TypeToken of the State.
- planType — TypeToken of the Plan.stateType and planType are required for features which require serialization, e.g. persistence. if you use such features, you should provide the type tokens for the state and plan types. otherwise these parameters can be omitted.
- Input — The type of input provided to the planner.
- Output — The type of output produced by the planner.
- State — The internal state type managed by the planner.
- Plan — The type of plan produced by buildPlan.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.planner.AIAgentPlanner.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
val planType: TypeToken?
```

- planType — TypeToken of the Plan.stateType and planType are required for features which require serialization, e.g. persistence. if you use such features, you should provide the type tokens for the state and plan types. otherwise these parameters can be omitted.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.planner.AIAgentPlanner.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner/state-type.html`

### :agents:agents-core/commonMain

```kotlin
val stateType: TypeToken?
```

- stateType — TypeToken of the State.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.planner.AIAgentPlannerStrategy.AIAgentPlannerStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/-a-i-agent-planner-strategy.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String, planner: AIAgentPlanner<Input, Output, *, *>)
```

- Input — The type of input data required as the starting point for the strategy execution.
- Output — The type of output data produced as the result of the strategy execution.
## ai.koog.agents.core.planner.AIAgentPlannerStrategy.Companion.create

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/-companion/create.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> create(name: String, planner: AIAgentPlanner<Input, Output, *, *>): AIAgentPlannerStrategy<Input, Output>
```

Creates a new AIAgentPlannerStrategy instance with the specified name and planner.

## ai.koog.agents.core.planner.AIAgentPlannerStrategy.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/-companion/index.html`

### :agents:agents-core/commonMain

```kotlin
object Companion
```

Companion object for AIAgentPlannerStrategy with factory method create.

## ai.koog.agents.core.planner.AIAgentPlannerStrategy.execute

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/execute.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun execute(context: AIAgentPlannerContext, input: Input): Output
```

Executes the AI agent's strategy using the provided context and input.

This method processes the given input data within the specified context, leveraging the AI agent's internal logic and strategy to produce an output. The concrete decision-making, stateful operations, and any execution-pipeline specifics are fully determined by the implementing strategy.

The output produced by the AI agent's strategy, or null if no output is generated. The output type is defined by the strategy's implementation.

- context — The execution context in which the AI agent operates. It provides access to the agent's configuration, pipeline, environment, and other components required for execution in a graph-based structure.
- input — The input data to be processed by the AI agent's strategy. The type of input is defined by the strategy's implementation and is used to derive the resulting output.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.planner.AIAgentPlannerStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentPlannerStrategy<Input, Output>(val name: String, val planner: AIAgentPlanner<Input, Output, *, *>) : AIAgentStrategy<Input, Output, AIAgentPlannerContext>
```

A strategy implementation that utilizes a planner to manage and execute AI agent workflows.

This class integrates an AI planning component (AIAgentPlanner) with a defined execution mechanism, creating a customizable strategy for AI agents.

- Input — The type of input data required as the starting point for the strategy execution.
- Output — The type of output data produced as the result of the strategy execution.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.planner.AIAgentPlannerStrategy.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/name.html`

### :agents:agents-core/commonMain

```kotlin
open override val name: String
```

## ai.koog.agents.core.planner.AIAgentPlannerStrategy.planner

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-a-i-agent-planner-strategy/planner.html`

### :agents:agents-core/commonMain

```kotlin
val planner: AIAgentPlanner<Input, Output, *, *>
```

## ai.koog.agents.core.planner.PlannerAIAgent.FeatureContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/-feature-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class FeatureContext
```

Represents a context for managing and configuring features in an AI agent. Provides functionality to install and configure features into a specific instance of an AI agent.

## ai.koog.agents.core.planner.PlannerAIAgent.FeatureContext.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/-feature-context/install.html`

### :agents:agents-core/commonMain

```kotlin
fun <Config : FeatureConfig, Feature : Any> install(feature: AIAgentPlannerFeature<Config, Feature>, configure: Config.() -> Unit = {})
```

Installs and configures a feature into the current AI agent context.

- feature — the feature to be added, defined by an implementation of AIAgentFeature, which provides specific functionality
- configure — an optional lambda to customize the configuration of the feature, where the provided Config can be modified

Referenced packages: `ai.koog.agents.core.feature`, `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.planner.PlannerAIAgent.PlannerAIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/-planner-a-i-agent.html`

### :agents:agents-core/commonMain

```kotlin
constructor(promptExecutor: PromptExecutor, agentConfig: AIAgentConfig, strategy: AIAgentPlannerStrategy<Input, Output>, toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, clock: KoogClock = KoogClock.System, installFeatures: PlannerAIAgent.FeatureContext.() -> Unit = {})
```


Referenced packages: `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.planner.PlannerAIAgent.agentConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/agent-config.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentConfig: AIAgentConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.planner.PlannerAIAgent.clock

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/clock.html`

### :agents:agents-core/commonMain

```kotlin
val clock: KoogClock
```


Referenced packages: `ai.koog.utils.time`.

## ai.koog.agents.core.planner.PlannerAIAgent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlannerAIAgent<Input, Output>(val promptExecutor: PromptExecutor, val agentConfig: AIAgentConfig, val strategy: AIAgentPlannerStrategy<Input, Output>, val toolRegistry: ToolRegistry = ToolRegistry.EMPTY, id: String? = null, val clock: KoogClock = KoogClock.System, val installFeatures: PlannerAIAgent.FeatureContext.() -> Unit = {}) : AIAgentBase<Input, Output, AIAgentPlannerContext>
```

Represents an instance of planner agent using AIAgentPlannerStrategy.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.config`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.tools`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.agents.core.planner.PlannerAIAgent.installFeatures

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/install-features.html`

### :agents:agents-core/commonMain

```kotlin
val installFeatures: PlannerAIAgent.FeatureContext.() -> Unit
```

## ai.koog.agents.core.planner.PlannerAIAgent.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
open override val pipeline: AIAgentPlannerPipeline
```

Represents the pipeline used by the AI agent for processing tasks or data.

This abstract property defines the structure or sequence of operations within the AI agent's pipeline. It serves as the core mechanism for executing workflows, handling inputs, and generating outputs in the AI agent's functionality.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.planner.PlannerAIAgent.prepareContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/prepare-context.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun prepareContext(agentInput: Input, runId: String, eventId: String): AIAgentPlannerContext
```

Prepares and initializes the agent context required to handle the given input and run ID.

the initialized context specific to the agent setup for the provided input and run ID.

- agentInput — the input provided to the agent for processing.
- runId — a unique identifier representing the current execution or operation run.
- eventId — a unique identifier for agent-related events.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.planner.PlannerAIAgent.promptExecutor

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/prompt-executor.html`

### :agents:agents-core/commonMain

```kotlin
val promptExecutor: PromptExecutor
```


Referenced packages: `ai.koog.prompt.executor.model`.

## ai.koog.agents.core.planner.PlannerAIAgent.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/strategy.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategy: AIAgentPlannerStrategy<Input, Output>
```

## ai.koog.agents.core.planner.PlannerAIAgent.toolRegistry

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.planner/-planner-a-i-agent/tool-registry.html`

### :agents:agents-core/commonMain

```kotlin
val toolRegistry: ToolRegistry
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.planner.Planners.goap

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner/-planners/goap.html`

### :agents:agents-planner/commonMain

```kotlin
fun <Input, Output, State : GoapAgentState<Input, Output>> goap(name: String, initializeState: (Input) -> State): GOAPPlannerBuilder<Input, Output, State>
```

Returns a GOAPPlannerBuilder for a Goal-Oriented Action Planning strategy.

Call .action to add an action Call .goal to add a goal


Referenced packages: `ai.koog.agents.planner.goap`.

## ai.koog.agents.planner.Planners

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner/-planners/index.html`

### :agents:agents-planner/commonMain

```kotlin
object Planners
```

Primary entry point for creating planner strategies.

Kotlin example:

## ai.koog.agents.planner.Planners.llmBasedWithCritic

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner/-planners/llm-based-with-critic.html`

### :agents:agents-planner/commonMain

```kotlin
fun llmBasedWithCritic(name: String): SimpleLLMPlannerBuilder
```

Returns a SimpleLLMPlannerBuilder pre-configured with the LLM critic enabled.


Referenced packages: `ai.koog.agents.planner.llm`.

## ai.koog.agents.planner.Planners.llmBased

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner/-planners/llm-based.html`

### :agents:agents-planner/commonMain

```kotlin
fun llmBased(name: String): SimpleLLMPlannerBuilder
```

Returns a SimpleLLMPlannerBuilder for an LLM-based string-in/string-out planner.


Referenced packages: `ai.koog.agents.planner.llm`.

## ai.koog.agents.planner.goap

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner/goap.html`

### :agents:agents-planner/commonMain

```kotlin
inline fun <Input, Output, State : GoapAgentState<Input, Output>> goap(name: String, noinline initializeState: (Input) -> State, configure: GOAPPlannerBuilder<Input, Output, State>.() -> Unit): AIAgentPlannerStrategy<Input, Output>
```

Creates a GOAP strategy using a Kotlin DSL block.


Referenced packages: `ai.koog.agents.core.planner`, `ai.koog.agents.planner.goap`.

## ai.koog.agents.planner.goap.Action.Action

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/-action.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(name: String, description: String?, precondition: Condition<State>, belief: Belief<State>, cost: Cost<State>, execute: Execute<State>)
```

## ai.koog.agents.planner.goap.Action.Companion.builder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/-companion/builder.html`

### :agents:agents-planner/commonMain

```kotlin
fun <State> builder(): ActionBuilder<State>
```

Returns a new ActionBuilder.

## ai.koog.agents.planner.goap.Action.Companion

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/-companion/index.html`

### :agents:agents-planner/commonMain

```kotlin
object Companion
```

Companion object for builder api.

## ai.koog.agents.planner.goap.Action.belief

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/belief.html`

### :agents:agents-planner/commonMain

```kotlin
val belief: Belief<State>
```

## ai.koog.agents.planner.goap.Action.cost

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/cost.html`

### :agents:agents-planner/commonMain

```kotlin
val cost: Cost<State>
```

## ai.koog.agents.planner.goap.Action.description

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/description.html`

### :agents:agents-planner/commonMain

```kotlin
val description: String?
```

## ai.koog.agents.planner.goap.Action.execute

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/execute.html`

### :agents:agents-planner/commonMain

```kotlin
val execute: Execute<State>
```

## ai.koog.agents.planner.goap.Action

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/index.html`

### :agents:agents-planner/commonMain

```kotlin
class Action<State>(val name: String, val description: String?, val precondition: Condition<State>, val belief: Belief<State>, val cost: Cost<State>, val execute: Execute<State>)
```

Represents an action that can be performed by the agent.

## ai.koog.agents.planner.goap.Action.name

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/name.html`

### :agents:agents-planner/commonMain

```kotlin
val name: String
```

## ai.koog.agents.planner.goap.Action.precondition

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action/precondition.html`

### :agents:agents-planner/commonMain

```kotlin
val precondition: Condition<State>
```

## ai.koog.agents.planner.goap.ActionBuilder.ActionBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder/-action-builder.html`

### :agents:agents-planner/commonMain

```kotlin
expect constructor()
```

### :agents:agents-planner/jvmCommonMain

```kotlin
constructor()
```

### :agents:agents-planner/nonJvmCommonMain

```kotlin
constructor()
```

## ai.koog.agents.planner.goap.ActionBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder/index.html`

### :agents:agents-planner/commonMain

```kotlin
expect class ActionBuilder<State> : ActionBuilderCommon<State, ActionBuilder<State>>
```

Builder for Action instances.

### :agents:agents-planner/jvmCommonMain

```kotlin
actual class ActionBuilder<State> : ActionBuilderCommon<State, ActionBuilder<State>>
```

Builder for Action instances.

### :agents:agents-planner/nonJvmCommonMain

```kotlin
actual class ActionBuilder<State> : ActionBuilderCommon<State, ActionBuilder<State>>
```

Builder for Action instances.

## ai.koog.agents.planner.goap.ActionBuilderCommon.belief

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/belief.html`

### :agents:agents-planner/commonMain

```kotlin
fun belief(belief: Belief<State>): Self
```

Sets the belief for the action.

## ai.koog.agents.planner.goap.ActionBuilderCommon.build

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/build.html`

### :agents:agents-planner/commonMain

```kotlin
fun build(): Action<State>
```

Builds the Action.

## ai.koog.agents.planner.goap.ActionBuilderCommon.cost

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/cost.html`

### :agents:agents-planner/commonMain

```kotlin
fun cost(cost: Cost<State>): Self
```

Sets the cost function for the action.

## ai.koog.agents.planner.goap.ActionBuilderCommon.description

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/description.html`

### :agents:agents-planner/commonMain

```kotlin
fun description(description: String?): Self
```

Sets the description of the action.

## ai.koog.agents.planner.goap.ActionBuilderCommon.execute

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/execute.html`

### :agents:agents-planner/commonMain

```kotlin
fun execute(execute: Execute<State>): Self
```

Sets the execute function for the action.

## ai.koog.agents.planner.goap.ActionBuilderCommon

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/index.html`

### :agents:agents-planner/commonMain

```kotlin
abstract class ActionBuilderCommon<State, Self : ActionBuilderCommon<State, Self>>
```

Action builder configuration common to all platforms.

- ActionBuilder
## ai.koog.agents.planner.goap.ActionBuilderCommon.name

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/name.html`

### :agents:agents-planner/commonMain

```kotlin
fun name(name: String): Self
```

Sets the name of the action.

## ai.koog.agents.planner.goap.ActionBuilderCommon.precondition

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-action-builder-common/precondition.html`

### :agents:agents-planner/commonMain

```kotlin
fun precondition(precondition: Condition<State>): Self
```

Sets the precondition for the action.

## ai.koog.agents.planner.goap.Belief

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-belief/index.html`

### :agents:agents-planner/commonMain

```kotlin
typealias Belief<State> = (State) -> State
```

## ai.koog.agents.planner.goap.Condition

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-condition/index.html`

### :agents:agents-planner/commonMain

```kotlin
typealias Condition<State> = (State) -> Boolean
```

## ai.koog.agents.planner.goap.Cost

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-cost/index.html`

### :agents:agents-planner/commonMain

```kotlin
typealias Cost<State> = (State) -> Double
```

## ai.koog.agents.planner.goap.Execute

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-execute/index.html`

### :agents:agents-planner/commonMain

```kotlin
typealias Execute<State> = suspend (AIAgentPlannerContext, State) -> State
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.planner.goap.GOAPPlan.GOAPPlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-plan/-g-o-a-p-plan.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(goal: Goal<State>, actions: List<Action<State>>, value: Double)
```

## ai.koog.agents.planner.goap.GOAPPlan.actions

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-plan/actions.html`

### :agents:agents-planner/commonMain

```kotlin
val actions: List<Action<State>>
```

## ai.koog.agents.planner.goap.GOAPPlan.goal

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-plan/goal.html`

### :agents:agents-planner/commonMain

```kotlin
val goal: Goal<State>
```

## ai.koog.agents.planner.goap.GOAPPlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-plan/index.html`

### :agents:agents-planner/commonMain

```kotlin
class GOAPPlan<State>(val goal: Goal<State>, val actions: List<Action<State>>, val value: Double)
```

A GOAP plan.

## ai.koog.agents.planner.goap.GOAPPlan.value

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-plan/value.html`

### :agents:agents-planner/commonMain

```kotlin
val value: Double
```

## ai.koog.agents.planner.goap.GOAPPlanner

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner/index.html`

### :agents:agents-planner/commonMain

```kotlin
open class GOAPPlanner<Input, Output, State : GoapAgentState<Input, Output>> : AIAgentPlanner<Input, Output, State, List<String>>
```

Goal-Oriented Action Planning (GOAP) planner implementation.

GOAP is a planning system that uses goals, actions with preconditions and effects, and a search algorithm to find the optimal sequence of actions to achieve a goal.

- stateInitializer — A function to initialize State from Input.
- actions — The list of defined actions.
- goals — The list of defined goals.
- Input — The type of input provided to the agent.
- Output — The type of output produced by the agent.
- State — The type of the state.

Referenced packages: `ai.koog.agents.core.planner`.

## ai.koog.agents.planner.goap.GOAPPlannerBuilder.GOAPPlannerBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner-builder/-g-o-a-p-planner-builder.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(name: String, initializeState: (Input) -> State)
```

## ai.koog.agents.planner.goap.GOAPPlannerBuilder.action

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner-builder/action.html`

### :agents:agents-planner/commonMain

```kotlin
fun action(action: Action<State>): GOAPPlannerBuilder<Input, Output, State>
```

Adds an action to the planner.

### :agents:agents-planner/commonMain

```kotlin
fun action(name: String, configure: ConfigureAction<ActionBuilder<State>>): GOAPPlannerBuilder<Input, Output, State>
```

Adds an action to the planner with the provided configuration lambda.


Referenced packages: `ai.koog.agents.core.utils`.

### :agents:agents-planner/commonMain

```kotlin
fun action(name: String, description: String? = null, precondition: Condition<State>, belief: Belief<State>, cost: Cost<State> = { 1.0 }, execute: Execute<State>): GOAPPlannerBuilder<Input, Output, State>
```

Adds an action to the planner with provided parameters.

## ai.koog.agents.planner.goap.GOAPPlannerBuilder.build

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner-builder/build.html`

### :agents:agents-planner/commonMain

```kotlin
fun build(): AIAgentPlannerStrategy<Input, Output>
```

Builds the planner.


Referenced packages: `ai.koog.agents.core.planner`.

## ai.koog.agents.planner.goap.GOAPPlannerBuilder.goal

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner-builder/goal.html`

### :agents:agents-planner/commonMain

```kotlin
fun goal(goal: Goal<State>): GOAPPlannerBuilder<Input, Output, State>
```

Adds a goal to the planner.

### :agents:agents-planner/commonMain

```kotlin
fun goal(name: String, configure: ConfigureAction<GoalBuilder<State>>): GOAPPlannerBuilder<Input, Output, State>
```

Adds a goal to the planner with the provided configuration lambda.


Referenced packages: `ai.koog.agents.core.utils`.

### :agents:agents-planner/commonMain

```kotlin
fun goal(name: String, description: String? = null, value: (Double) -> Double = { cost -> exp(-cost) }, cost: Cost<State> = { 1.0 }, condition: Condition<State>): GOAPPlannerBuilder<Input, Output, State>
```

Adds a goal to the planner with provided parameters.

## ai.koog.agents.planner.goap.GOAPPlannerBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner-builder/index.html`

### :agents:agents-planner/commonMain

```kotlin
class GOAPPlannerBuilder<Input, Output, State : GoapAgentState<Input, Output>>(name: String, initializeState: (Input) -> State)
```

Builder for GOAP-based AIAgentPlannerStrategy.

Obtain via ai.koog.agents.planner.Planners.goap.

## ai.koog.agents.planner.goap.GOAPPlannerBuilder.stateType

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-g-o-a-p-planner-builder/state-type.html`

### :agents:agents-planner/commonMain

```kotlin
fun stateType(typeToken: TypeToken): GOAPPlannerBuilder<Input, Output, State>
```

Defines the type of the state.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.planner.goap.Goal.Companion.builder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/-companion/builder.html`

### :agents:agents-planner/commonMain

```kotlin
fun <State> builder(): GoalBuilder<State>
```

Returns a new GoalBuilder.

## ai.koog.agents.planner.goap.Goal.Companion

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/-companion/index.html`

### :agents:agents-planner/commonMain

```kotlin
object Companion
```

Companion object for builder api.

## ai.koog.agents.planner.goap.Goal.Goal

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/-goal.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(name: String, description: String?, value: GoalValue, cost: Cost<State>, condition: Condition<State>)
```

## ai.koog.agents.planner.goap.Goal.condition

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/condition.html`

### :agents:agents-planner/commonMain

```kotlin
val condition: Condition<State>
```

## ai.koog.agents.planner.goap.Goal.cost

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/cost.html`

### :agents:agents-planner/commonMain

```kotlin
val cost: Cost<State>
```

## ai.koog.agents.planner.goap.Goal.description

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/description.html`

### :agents:agents-planner/commonMain

```kotlin
val description: String?
```

## ai.koog.agents.planner.goap.Goal

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/index.html`

### :agents:agents-planner/commonMain

```kotlin
class Goal<State>(val name: String, val description: String?, val value: GoalValue, val cost: Cost<State>, val condition: Condition<State>)
```

Represents a goal that the agent wants to achieve.

## ai.koog.agents.planner.goap.Goal.name

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/name.html`

### :agents:agents-planner/commonMain

```kotlin
val name: String
```

## ai.koog.agents.planner.goap.Goal.value

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal/value.html`

### :agents:agents-planner/commonMain

```kotlin
val value: GoalValue
```

## ai.koog.agents.planner.goap.GoalBuilder.GoalBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/-goal-builder.html`

### :agents:agents-planner/commonMain

```kotlin
constructor()
```

## ai.koog.agents.planner.goap.GoalBuilder.build

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/build.html`

### :agents:agents-planner/commonMain

```kotlin
fun build(): Goal<State>
```

Creates an instance of Goal based on the builder's configuration.

## ai.koog.agents.planner.goap.GoalBuilder.condition

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/condition.html`

### :agents:agents-planner/commonMain

```kotlin
fun condition(condition: Condition<State>): GoalBuilder<State>
```

Sets the condition function for the goal.

## ai.koog.agents.planner.goap.GoalBuilder.cost

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/cost.html`

### :agents:agents-planner/commonMain

```kotlin
fun cost(cost: Cost<State>): GoalBuilder<State>
```

Sets the cost function for the goal.

## ai.koog.agents.planner.goap.GoalBuilder.description

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/description.html`

### :agents:agents-planner/commonMain

```kotlin
fun description(description: String?): GoalBuilder<State>
```

Sets the description of the goal.

## ai.koog.agents.planner.goap.GoalBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/index.html`

### :agents:agents-planner/commonMain

```kotlin
class GoalBuilder<State>
```

Builder for Goal instances.

## ai.koog.agents.planner.goap.GoalBuilder.name

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/name.html`

### :agents:agents-planner/commonMain

```kotlin
fun name(name: String): GoalBuilder<State>
```

Sets the name of the goal.

## ai.koog.agents.planner.goap.GoalBuilder.value

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-builder/value.html`

### :agents:agents-planner/commonMain

```kotlin
fun value(value: (Double) -> Double): GoalBuilder<State>
```

Sets the value function for the goal.

## ai.koog.agents.planner.goap.GoalValue

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goal-value/index.html`

### :agents:agents-planner/commonMain

```kotlin
typealias GoalValue = (Double) -> Double
```

## ai.koog.agents.planner.goap.GoapAgentState.GoapAgentState

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goap-agent-state/-goap-agent-state.html`

### :agents:agents-planner/commonMain

```kotlin
constructor()
```

- Input — The type of the input data for the agent.
- Output — The type of the output data produced by the agent.
## ai.koog.agents.planner.goap.GoapAgentState.agentInput

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goap-agent-state/agent-input.html`

### :agents:agents-planner/commonMain

```kotlin
abstract val agentInput: Input
```

The initial input provided to the agent.

## ai.koog.agents.planner.goap.GoapAgentState

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goap-agent-state/index.html`

### :agents:agents-planner/commonMain

```kotlin
abstract class GoapAgentState<Input, Output>
```

Represents the state of a Goal-Oriented Action Planning (GOAP) agent during its operation.

This abstract class provides a base for GOAP (Goal-Oriented Action Planning) agent states, capturing the initial input and defining how to produce the final output.

- Input — The type of the input data for the agent.
- Output — The type of the output data produced by the agent.
## ai.koog.agents.planner.goap.GoapAgentState.provideOutput

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.goap/-goap-agent-state/provide-output.html`

### :agents:agents-planner/commonMain

```kotlin
abstract fun provideOutput(): Output
```

Provides an output based on the current state of the implementing class.

An instance of the Output type, representing the result of the operation.

## ai.koog.agents.planner.llm.PlanStep.PlanStep

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-plan-step/-plan-step.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(description: String, isCompleted: Boolean = false)
```

## ai.koog.agents.planner.llm.PlanStep.description

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-plan-step/description.html`

### :agents:agents-planner/commonMain

```kotlin
val description: String
```

## ai.koog.agents.planner.llm.PlanStep

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-plan-step/index.html`

### :agents:agents-planner/commonMain

```kotlin
@Serializable data class PlanStep(val description: String, val isCompleted: Boolean = false)
```

Represents a step in the plan.

## ai.koog.agents.planner.llm.PlanStep.isCompleted

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-plan-step/is-completed.html`

### :agents:agents-planner/commonMain

```kotlin
@EncodeDefault val isCompleted: Boolean
```

## ai.koog.agents.planner.llm.SimpleLLMPlanner.SimpleLLMPlanner

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner/-simple-l-l-m-planner.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(historyCompressionStrategy: HistoryCompressionStrategy = HistoryCompressionStrategy.NoCompression)
```


Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.planner.llm.SimpleLLMPlanner

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner/index.html`

### :agents:agents-planner/commonMain

```kotlin
open class SimpleLLMPlanner constructor(historyCompressionStrategy: HistoryCompressionStrategy = HistoryCompressionStrategy.NoCompression) : AIAgentPlanner<String, String, String, SimplePlan>
```

A simple planning strategy that uses LLM requests to build and execute a plan. In addition, it performs another LLM call to assess each generated plan and ask for a replanning. It operates on a String state, meaning it would accept an initial state string and then return the final state string as a result. It is limited to string-only operations and does not perform tool calling or other advanced logic.

- SimpleLLMWithCriticPlanner

Referenced packages: `ai.koog.agents.core.dsl.extension`, `ai.koog.agents.core.planner`.

## ai.koog.agents.planner.llm.SimpleLLMPlannerBuilder.SimpleLLMPlannerBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner-builder/-simple-l-l-m-planner-builder.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.agents.planner.llm.SimpleLLMPlannerBuilder.build

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner-builder/build.html`

### :agents:agents-planner/commonMain

```kotlin
fun build(): AIAgentPlannerStrategy<String, String>
```

Builds the AIAgentPlannerStrategy with the specified configuration.


Referenced packages: `ai.koog.agents.core.planner`.

## ai.koog.agents.planner.llm.SimpleLLMPlannerBuilder

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner-builder/index.html`

### :agents:agents-planner/commonMain

```kotlin
class SimpleLLMPlannerBuilder(name: String)
```

Builder for LLM-based AIAgentPlannerStrategy operating on a String state.

Obtain via ai.koog.agents.planner.Planners.llmBased.

## ai.koog.agents.planner.llm.SimpleLLMPlannerBuilder.withCritic

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner-builder/with-critic.html`

### :agents:agents-planner/commonMain

```kotlin
fun withCritic(): SimpleLLMPlannerBuilder
```

Enables the critic for the planner.

## ai.koog.agents.planner.llm.SimpleLLMPlannerBuilder.withHistoryCompression

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-planner-builder/with-history-compression.html`

### :agents:agents-planner/commonMain

```kotlin
fun withHistoryCompression(historyCompressionStrategy: HistoryCompressionStrategy): SimpleLLMPlannerBuilder
```

Configures the history compression strategy for the planner.


Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.planner.llm.SimpleLLMWithCriticPlanner.SimpleLLMWithCriticPlanner

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-with-critic-planner/-simple-l-l-m-with-critic-planner.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(historyCompressionStrategy: HistoryCompressionStrategy = HistoryCompressionStrategy.NoCompression)
```


Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.planner.llm.SimpleLLMWithCriticPlanner

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-l-l-m-with-critic-planner/index.html`

### :agents:agents-planner/commonMain

```kotlin
class SimpleLLMWithCriticPlanner(historyCompressionStrategy: HistoryCompressionStrategy = HistoryCompressionStrategy.NoCompression) : SimpleLLMPlanner
```

A simple planning strategy that uses LLM requests to build and execute a plan. It operates on a String state, meaning it would accept an initial state string and then return the final state string as a result. It is limited to string-only operations and does not perform tool calling or other advanced logic.


Referenced packages: `ai.koog.agents.core.dsl.extension`.

## ai.koog.agents.planner.llm.SimplePlan.SimplePlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan/-simple-plan.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(goal: String, steps: MutableList<PlanStep>)
```

## ai.koog.agents.planner.llm.SimplePlan.goal

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan/goal.html`

### :agents:agents-planner/commonMain

```kotlin
val goal: String
```

## ai.koog.agents.planner.llm.SimplePlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan/index.html`

### :agents:agents-planner/commonMain

```kotlin
@Serializable data class SimplePlan(val goal: String, val steps: MutableList<PlanStep>)
```

Represents a structured plan with steps.

## ai.koog.agents.planner.llm.SimplePlan.steps

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan/steps.html`

### :agents:agents-planner/commonMain

```kotlin
val steps: MutableList<PlanStep>
```

## ai.koog.agents.planner.llm.SimplePlanAssessment.Continue.Continue

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-continue/-continue.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(currentPlan: Plan)
```

## ai.koog.agents.planner.llm.SimplePlanAssessment.Continue.currentPlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-continue/current-plan.html`

### :agents:agents-planner/commonMain

```kotlin
val currentPlan: Plan
```

## ai.koog.agents.planner.llm.SimplePlanAssessment.Continue

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-continue/index.html`

### :agents:agents-planner/commonMain

```kotlin
class Continue<Plan>(val currentPlan: Plan) : SimplePlanAssessment<Plan>
```

Indicates that the plan should continue execution without replanning.

## ai.koog.agents.planner.llm.SimplePlanAssessment.NoPlan.NoPlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-no-plan/-no-plan.html`

### :agents:agents-planner/commonMain

```kotlin
constructor()
```

## ai.koog.agents.planner.llm.SimplePlanAssessment.NoPlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-no-plan/index.html`

### :agents:agents-planner/commonMain

```kotlin
class NoPlan<Plan> : SimplePlanAssessment<Plan>
```

Indicates that there is no plan to execute.

## ai.koog.agents.planner.llm.SimplePlanAssessment.Replan.Replan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-replan/-replan.html`

### :agents:agents-planner/commonMain

```kotlin
constructor(currentPlan: Plan, reason: String)
```

## ai.koog.agents.planner.llm.SimplePlanAssessment.Replan.currentPlan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-replan/current-plan.html`

### :agents:agents-planner/commonMain

```kotlin
val currentPlan: Plan
```

## ai.koog.agents.planner.llm.SimplePlanAssessment.Replan

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-replan/index.html`

### :agents:agents-planner/commonMain

```kotlin
class Replan<Plan>(val currentPlan: Plan, val reason: String) : SimplePlanAssessment<Plan>
```

Indicates that the plan should be replanned based on the current state.

## ai.koog.agents.planner.llm.SimplePlanAssessment.Replan.reason

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/-replan/reason.html`

### :agents:agents-planner/commonMain

```kotlin
val reason: String
```

## ai.koog.agents.planner.llm.SimplePlanAssessment

Module: `agents-planner`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-planner/ai.koog.agents.planner.llm/-simple-plan-assessment/index.html`

### :agents:agents-planner/commonMain

```kotlin
sealed interface SimplePlanAssessment<Plan>
```

Represents an assessment of a plan's execution, indicating whether to continue with the current plan or replan.

- Replan
- Continue
- NoPlan