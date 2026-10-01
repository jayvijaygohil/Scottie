# Feature events, tracing, and telemetry

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.feature.AIAgentFeature.createInitialConfig

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-feature/create-initial-config.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun createInitialConfig(agentConfig: AIAgentConfig): TConfig
```

Creates and returns an initial configuration for the feature.

- agentConfig — The config of the agent this feature config is being created for.

Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.feature.AIAgentFeature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-feature/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentFeature<TConfig : FeatureConfig, TFeatureImpl : Any>
```

A class for Agent Feature that can be added to an agent pipeline, The feature stands for providing specific functionality and configuration capabilities.

- TConfig — The type representing the configuration for this feature.
- TFeatureImpl — The type of the feature implementation.
- AIAgentGraphFeature
- AIAgentFunctionalFeature
- AIAgentPlannerFeature

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.AIAgentFeature.key

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-feature/key.html`

### :agents:agents-core/commonMain

```kotlin
abstract val key: AIAgentStorageKey<TFeatureImpl>
```

A key used to uniquely identify a feature of type TFeatureImpl within the local agent storage.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.AIAgentFunctionalFeature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-functional-feature/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentFunctionalFeature<TConfig : FeatureConfig, TFeatureImpl : Any> : AIAgentFeature<TConfig, TFeatureImpl>
```

Represents a functional-specific AI agent feature that can be installed into an AIAgentFunctionalPipeline.

- TConfig — The type of configuration required for the feature, extending FeatureConfig.
- TFeatureImpl — The type representing the concrete implementation of the feature.
- Feature

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.AIAgentFunctionalFeature.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-functional-feature/install.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun install(config: TConfig, pipeline: AIAgentFunctionalPipeline): TFeatureImpl
```

Installs the feature into the specified pipeline.

The implementation of the feature.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.feature.AIAgentGraphFeature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-graph-feature/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentGraphFeature<TConfig : FeatureConfig, TFeatureImpl : Any> : AIAgentFeature<TConfig, TFeatureImpl>
```

Represents a graph-specific AI agent feature that can be installed into an AIAgentGraphPipeline.

- TConfig — The type of configuration required for the feature, extending FeatureConfig.
- TFeatureImpl — The type representing the concrete implementation of the feature.
- Feature

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.AIAgentGraphFeature.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-graph-feature/install.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun install(config: TConfig, pipeline: AIAgentGraphPipeline): TFeatureImpl
```

Installs the feature into the specified pipeline.

The implementation of the feature.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.feature.AIAgentPlannerFeature

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-planner-feature/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentPlannerFeature<TConfig : FeatureConfig, TFeatureImpl : Any> : AIAgentFeature<TConfig, TFeatureImpl>
```

Represents a planner-specific AI agent feature that can be installed into an ai.koog.agents.core.feature.pipeline.AIAgentPlannerPipeline.

- TConfig — The type of configuration required for the feature, extending FeatureConfig.
- TFeatureImpl — The type representing the concrete implementation of the feature.
- Feature

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.core.feature.AIAgentPlannerFeature.install

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature/-a-i-agent-planner-feature/install.html`

### :agents:agents-core/commonMain

```kotlin
abstract fun install(config: TConfig, pipeline: AIAgentPlannerPipeline): TFeatureImpl
```

Installs the feature into the specified pipeline.

The implementation of the feature.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.feature.handler.AgentLifecycleContextEventHandler.handle

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-context-event-handler/handle.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun handle(eventContext: TContext)
```

## ai.koog.agents.core.feature.handler.AgentLifecycleContextEventHandler

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-context-event-handler/index.html`

### :agents:agents-core/commonMain

```kotlin
fun interface AgentLifecycleContextEventHandler<TContext : AgentLifecycleEventContext> : AgentLifecycleEventHandler<TContext, Unit>
```

## ai.koog.agents.core.feature.handler.AgentLifecycleEventContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
abstract val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AgentLifecycleEventContext
```

Represents the context in which event handlers operate, providing a foundational interface for all event handling activities within the AI Agent framework.

- AgentEventContext
- LLMCallEventContext
- NodeExecutionEventContext
- PlannerEventContext
- StrategyEventContext
- LLMStreamingEventContext
- SubgraphExecutionEventContext
- ToolCallEventContext
## ai.koog.agents.core.feature.handler.AgentLifecycleEventHandler

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-handler/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AgentLifecycleEventHandler<TContext : AgentLifecycleEventContext, TResult : Any>
```

- AgentLifecycleContextEventHandler
- AgentLifecycleTransformEventHandler
## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.AgentClosing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-agent-closing/index.html`

### :agents:agents-core/commonMain

```kotlin
object AgentClosing : AgentLifecycleEventType
```

Represents an event triggered before an agent is closed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.AgentCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-agent-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object AgentCompleted : AgentLifecycleEventType
```

Represents an event triggered when an agent is finished.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.AgentEnvironmentTransforming

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-agent-environment-transforming/index.html`

### :agents:agents-core/commonMain

```kotlin
object AgentEnvironmentTransforming : AgentLifecycleEventType
```

Represents an event triggered when an agent is transformed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.AgentExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-agent-execution-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object AgentExecutionFailed : AgentLifecycleEventType
```

Represents an event triggered when an agent encounters an error.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.AgentStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-agent-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object AgentStarting : AgentLifecycleEventType
```

Represents an event triggered when an agent is started.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.BuildPlanCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-build-plan-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object BuildPlanCompleted : AgentLifecycleEventType
```

Represents an event triggered when building a plan completes.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.BuildPlanStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-build-plan-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object BuildPlanStarting : AgentLifecycleEventType
```

Represents an event triggered when building a plan starts.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ExecuteStepCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-execute-step-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object ExecuteStepCompleted : AgentLifecycleEventType
```

Represents an event triggered when executing a plan step completes.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ExecuteStepStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-execute-step-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object ExecuteStepStarting : AgentLifecycleEventType
```

Represents an event triggered when executing a plan step starts.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.IsPlanCompletedCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-is-plan-completed-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object IsPlanCompletedCompleted : AgentLifecycleEventType
```

Represents an event triggered when checking plan completion completes.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.IsPlanCompletedStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-is-plan-completed-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object IsPlanCompletedStarting : AgentLifecycleEventType
```

Represents an event triggered when checking plan completion starts.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-call-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMCallCompleted : AgentLifecycleEventType
```

Represents an event triggered after a language model call has completed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-call-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMCallFailed : AgentLifecycleEventType
```

Represents an event triggered when a language model call fails.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-call-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMCallStarting : AgentLifecycleEventType
```

Represents an event triggered when an error occurs during a language model call.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMStreamingCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-streaming-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMStreamingCompleted : AgentLifecycleEventType
```

Represents an event triggered after streaming from a language model completes.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMStreamingFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-streaming-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMStreamingFailed : AgentLifecycleEventType
```

Represents an event triggered when an error occurs during streaming from a language model.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMStreamingFrameReceived

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-streaming-frame-received/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMStreamingFrameReceived : AgentLifecycleEventType
```

Represents an event triggered when a streaming frame is received from a language model.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.LLMStreamingStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-l-l-m-streaming-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object LLMStreamingStarting : AgentLifecycleEventType
```

Represents an event triggered before streaming from a language model begins.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.NodeExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-node-execution-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object NodeExecutionCompleted : AgentLifecycleEventType
```

Represents an event triggered after a node has been executed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.NodeExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-node-execution-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object NodeExecutionFailed : AgentLifecycleEventType
```

Represents an event triggered when an error occurs during node execution.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.NodeExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-node-execution-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object NodeExecutionStarting : AgentLifecycleEventType
```

Represents an event triggered before a node is executed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.StrategyCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-strategy-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object StrategyCompleted : AgentLifecycleEventType
```

Represents an event triggered when a strategy is finished.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.StrategyStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-strategy-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object StrategyStarting : AgentLifecycleEventType
```

Represents an event triggered when a strategy is started.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.SubgraphExecutionCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-subgraph-execution-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object SubgraphExecutionCompleted : AgentLifecycleEventType
```

Represents an event triggered after a subgraph has been executed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.SubgraphExecutionFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-subgraph-execution-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object SubgraphExecutionFailed : AgentLifecycleEventType
```

Represents an event triggered when an error occurs during subgraph execution.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.SubgraphExecutionStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-subgraph-execution-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object SubgraphExecutionStarting : AgentLifecycleEventType
```

Represents an event triggered before a subgraph is executed.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ToolCallCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-tool-call-completed/index.html`

### :agents:agents-core/commonMain

```kotlin
object ToolCallCompleted : AgentLifecycleEventType
```

Represents an event triggered when a tool call succeeds.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ToolCallFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-tool-call-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object ToolCallFailed : AgentLifecycleEventType
```

Represents an event triggered when a tool call fails.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ToolCallMetadataContributing

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-tool-call-metadata-contributing/index.html`

### :agents:agents-core/commonMain

```kotlin
object ToolCallMetadataContributing : AgentLifecycleEventType
```

Represents the metadata-contribution event fired before a tool call to let features contribute per-call metadata (e.g. a trace span id) that is threaded into the tool's execution.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ToolCallStarting

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-tool-call-starting/index.html`

### :agents:agents-core/commonMain

```kotlin
object ToolCallStarting : AgentLifecycleEventType
```

Represents an event triggered when a tool is called.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType.ToolValidationFailed

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/-tool-validation-failed/index.html`

### :agents:agents-core/commonMain

```kotlin
object ToolValidationFailed : AgentLifecycleEventType
```

Represents an event triggered when a tool call fails validation.

## ai.koog.agents.core.feature.handler.AgentLifecycleEventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-event-type/index.html`

### :agents:agents-core/commonMain

```kotlin
sealed interface AgentLifecycleEventType
```

Represents different types of events that can occur during the execution of an agent or its related processes.

The events are categorized into several groups for better organization. Each event type is represented as an object within this interface.

- AgentStarting
- AgentCompleted
- AgentExecutionFailed
- AgentClosing
- AgentEnvironmentTransforming
- StrategyStarting
- StrategyCompleted
- NodeExecutionStarting
- NodeExecutionCompleted
- NodeExecutionFailed
- SubgraphExecutionStarting
- SubgraphExecutionCompleted
- SubgraphExecutionFailed
- LLMCallStarting
- LLMCallCompleted
- LLMCallFailed
- ToolCallStarting
- ToolCallMetadataContributing
- ToolValidationFailed
- ToolCallFailed
- ToolCallCompleted
- LLMStreamingStarting
- LLMStreamingFrameReceived
- LLMStreamingFailed
- LLMStreamingCompleted
- BuildPlanStarting
- BuildPlanCompleted
- ExecuteStepStarting
- ExecuteStepCompleted
- IsPlanCompletedStarting
- IsPlanCompletedCompleted
## ai.koog.agents.core.feature.handler.AgentLifecycleTransformEventHandler.handle

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-transform-event-handler/handle.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun handle(eventContext: TContext, entity: TResult): TResult
```

## ai.koog.agents.core.feature.handler.AgentLifecycleTransformEventHandler

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler/-agent-lifecycle-transform-event-handler/index.html`

### :agents:agents-core/commonMain

```kotlin
fun interface AgentLifecycleTransformEventHandler<TContext : AgentLifecycleEventContext, TResult : Any> : AgentLifecycleEventHandler<TContext, TResult>
```

## ai.koog.agents.core.feature.handler.agent.AgentClosingContext.AgentClosingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-closing-context/-agent-closing-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentClosingContext.agent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-closing-context/agent.html`

### :agents:agents-core/commonMain

```kotlin
open override val agent: AIAgent<*, *>
```

The AI agent associated with this context.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.feature.handler.agent.AgentClosingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-closing-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.agent.AgentClosingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-closing-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.agent.AgentClosingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-closing-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentClosingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-closing-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class AgentClosingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val agent: AIAgent<*, *>) : AgentEventContext
```

Represents the context passed to the handler that is executed before an agent is closed.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.AgentCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/-agent-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, result: Any?)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.agent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/agent.html`

### :agents:agents-core/commonMain

```kotlin
open override val agent: AIAgent<*, *>
```

The AI agent associated with this context.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
val context: AIAgentContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class AgentCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val agent: AIAgent<*, *>, val context: AIAgentContext, val runId: String, val result: Any?) : AgentEventContext
```

Represents the context for handling the completion of an agent's execution.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: Any?
```

## ai.koog.agents.core.feature.handler.agent.AgentCompletedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-completed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.handler.agent.AgentEnvironmentTransformingContext.AgentEnvironmentTransformingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-environment-transforming-context/-agent-environment-transforming-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentEnvironmentTransformingContext.agent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-environment-transforming-context/agent.html`

### :agents:agents-core/commonMain

```kotlin
open override val agent: AIAgent<*, *>
```

The AI agent associated with this context.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.feature.handler.agent.AgentEnvironmentTransformingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-environment-transforming-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.agent.AgentEnvironmentTransformingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-environment-transforming-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.agent.AgentEnvironmentTransformingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-environment-transforming-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentEnvironmentTransformingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-environment-transforming-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class AgentEnvironmentTransformingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val agent: AIAgent<*, *>) : AgentEventContext
```

Provides a context for executing transformations and operations within an AI agent's environment.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentEventContext.agent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-event-context/agent.html`

### :agents:agents-core/commonMain

```kotlin
abstract val agent: AIAgent<*, *>
```

The AI agent associated with this context.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.feature.handler.agent.AgentEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AgentEventContext : AgentLifecycleEventContext
```

Provides the context for handling events specific to AI agents. This interface extends the foundational event handling context, EventHandlerContext, and is specialized for scenarios involving agents and their associated workflows or features.

The AgentEventHandlerContext enables implementation of event-driven systems within the AI Agent framework by offering hooks for custom event handling logic tailored to agent operations.

- AgentStartingContext
- AgentCompletedContext
- AgentExecutionFailedContext
- AgentClosingContext
- AgentEnvironmentTransformingContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.AgentExecutionFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/-agent-execution-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.agent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/agent.html`

### :agents:agents-core/commonMain

```kotlin
open override val agent: AIAgent<*, *>
```

The AI agent associated with this context.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
val context: AIAgentContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable
```

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class AgentExecutionFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val agent: AIAgent<*, *>, val context: AIAgentContext, val runId: String, val error: Throwable) : AgentEventContext
```

Represents the context for handling errors that occur during the execution of an agent run.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentExecutionFailedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-execution-failed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.AgentStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/-agent-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, agent: AIAgent<*, *>, context: AIAgentContext, runId: String)
```


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.agent

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/agent.html`

### :agents:agents-core/commonMain

```kotlin
open override val agent: AIAgent<*, *>
```

The AI agent associated with this context.


Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
val context: AIAgentContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class AgentStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val agent: AIAgent<*, *>, val context: AIAgentContext, val runId: String) : AgentEventContext
```

Represents the context available during the start of an AI agent.


Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.agent.AgentStartingContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.agent/-agent-starting-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
val runId: String
```

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.LLMCallCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/-l-l-m-call-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, response: Message.Assistant?, moderationResponse: ModerationResult?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMCallCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val tools: List<ToolDescriptor>, val response: Message.Assistant?, val moderationResponse: ModerationResult?) : LLMCallEventContext
```

Represents the context for handling an after LLM call event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.moderationResponse

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/moderation-response.html`

### :agents:agents-core/commonMain

```kotlin
val moderationResponse: ModerationResult?
```


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.response

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/response.html`

### :agents:agents-core/commonMain

```kotlin
val response: Message.Assistant?
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this LLM call session.

## ai.koog.agents.core.feature.handler.llm.LLMCallCompletedContext.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-completed-context/tools.html`

### :agents:agents-core/commonMain

```kotlin
open override val tools: List<ToolDescriptor>
```

The list of tool descriptors available for the LLM call.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.feature.handler.llm.LLMCallEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.llm.LLMCallEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface LLMCallEventContext : AgentLifecycleEventContext
```

Represents the context for handling LLM-specific events within the framework.

- LLMCallStartingContext
- LLMCallFailedContext
- LLMCallCompletedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.llm.LLMCallEventContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-event-context/model.html`

### :agents:agents-core/commonMain

```kotlin
abstract val model: LLModel
```

The language model instance being used.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallEventContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-event-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
abstract val prompt: Prompt
```

The prompt that will be sent to the language model.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.llm.LLMCallEventContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-event-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val runId: String
```

The unique identifier for this LLM call session.

## ai.koog.agents.core.feature.handler.llm.LLMCallEventContext.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-event-context/tools.html`

### :agents:agents-core/commonMain

```kotlin
abstract val tools: List<ToolDescriptor>
```

The list of tool descriptors available for the LLM call.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.LLMCallFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/-l-l-m-call-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable
```

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMCallFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val tools: List<ToolDescriptor>, val error: Throwable) : LLMCallEventContext
```

Represents the context for handling an after LLM call failed.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this LLM call session.

## ai.koog.agents.core.feature.handler.llm.LLMCallFailedContext.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-failed-context/tools.html`

### :agents:agents-core/commonMain

```kotlin
open override val tools: List<ToolDescriptor>
```

The list of tool descriptors available for the LLM call.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.LLMCallStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/-l-l-m-call-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMCallStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val tools: List<ToolDescriptor>) : LLMCallEventContext
```

Represents the context for handling a before LLM call event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this LLM call session.

## ai.koog.agents.core.feature.handler.llm.LLMCallStartingContext.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.llm/-l-l-m-call-starting-context/tools.html`

### :agents:agents-core/commonMain

```kotlin
open override val tools: List<ToolDescriptor>
```

The list of tool descriptors available for the LLM call.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.NodeExecutionCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/-node-execution-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken, output: Any?, outputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentGraphContextBase
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class NodeExecutionCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentGraphContextBase, val node: AIAgentNodeBase<*, *>, val input: Any?, val inputType: TypeToken, val output: Any?, val outputType: TypeToken) : NodeExecutionEventContext
```

Represents the context for handling an after node execution event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.node

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/node.html`

### :agents:agents-core/commonMain

```kotlin
open override val node: AIAgentNodeBase<*, *>
```

The AI Agent node instance.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/output-type.html`

### :agents:agents-core/commonMain

```kotlin
val outputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionCompletedContext.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-completed-context/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: Any?
```

## ai.koog.agents.core.feature.handler.node.NodeExecutionEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentGraphContextBase
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface NodeExecutionEventContext : AgentLifecycleEventContext
```

Represents the context for handling node-specific events within the framework.

- NodeExecutionStartingContext
- NodeExecutionCompletedContext
- NodeExecutionFailedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionEventContext.node

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-event-context/node.html`

### :agents:agents-core/commonMain

```kotlin
abstract val node: AIAgentNodeBase<*, *>
```

The AI Agent node instance.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.NodeExecutionFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/-node-execution-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentGraphContextBase
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable
```

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class NodeExecutionFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentGraphContextBase, val node: AIAgentNodeBase<*, *>, val input: Any?, val inputType: TypeToken, val error: Throwable) : NodeExecutionEventContext
```

Represents the context for handling errors during the execution of a node.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.node.NodeExecutionFailedContext.node

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-failed-context/node.html`

### :agents:agents-core/commonMain

```kotlin
open override val node: AIAgentNodeBase<*, *>
```

The AI Agent node instance.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.NodeExecutionStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/-node-execution-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentGraphContextBase, node: AIAgentNodeBase<*, *>, input: Any?, inputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentGraphContextBase
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class NodeExecutionStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentGraphContextBase, val node: AIAgentNodeBase<*, *>, val input: Any?, val inputType: TypeToken) : NodeExecutionEventContext
```

Represents the context for handling a before node execution event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.node.NodeExecutionStartingContext.node

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.node/-node-execution-starting-context/node.html`

### :agents:agents-core/commonMain

```kotlin
open override val node: AIAgentNodeBase<*, *>
```

The AI Agent node instance.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.PlanCompletionEvaluationCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/-plan-completion-evaluation-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int, isCompleted: Boolean)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlanCompletionEvaluationCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val state: Any, val stateType: TypeToken?, val plan: Any, val planType: TypeToken?, val stepIndex: Int, val isCompleted: Boolean) : PlannerEventContext
```

Represents the context for an isPlanCompleted check completed event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.isCompleted

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/is-completed.html`

### :agents:agents-core/commonMain

```kotlin
val isCompleted: Boolean
```

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
open override val plan: Any
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/state.html`

### :agents:agents-core/commonMain

```kotlin
open override val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationCompletedContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-completed-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
open override val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.PlanCompletionEvaluationStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/-plan-completion-evaluation-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlanCompletionEvaluationStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val state: Any, val stateType: TypeToken?, val plan: Any, val planType: TypeToken?, val stepIndex: Int) : PlannerEventContext
```

Represents the context for an isPlanCompleted check starting event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
open override val plan: Any
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/state.html`

### :agents:agents-core/commonMain

```kotlin
open override val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.PlanCompletionEvaluationStartingContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-completion-evaluation-starting-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
open override val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.PlanCreationCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/-plan-creation-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int, updatedPlan: Any)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlanCreationCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val state: Any, val stateType: TypeToken?, val plan: Any?, val planType: TypeToken?, val stepIndex: Int, val updatedPlan: Any) : PlannerEventContext
```

Represents the context for a buildPlan operation completed event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
open override val plan: Any?
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/state.html`

### :agents:agents-core/commonMain

```kotlin
open override val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
open override val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.planner.PlanCreationCompletedContext.updatedPlan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-completed-context/updated-plan.html`

### :agents:agents-core/commonMain

```kotlin
val updatedPlan: Any
```

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.PlanCreationStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/-plan-creation-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any?, planType: TypeToken?, stepIndex: Int)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class PlanCreationStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val state: Any, val stateType: TypeToken?, val plan: Any?, val planType: TypeToken?, val stepIndex: Int) : PlannerEventContext
```

Represents the context for a buildPlan operation starting event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
open override val plan: Any?
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/state.html`

### :agents:agents-core/commonMain

```kotlin
open override val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.PlanCreationStartingContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-plan-creation-starting-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
open override val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface PlannerEventContext : AgentLifecycleEventContext
```

Defines the context specifically for handling planner-related events within the AI agent framework. Extends the base event handler context to include functionality and behavior dedicated to managing the lifecycle and operations of planner agents.

- PlanCreationStartingContext
- PlanCreationCompletedContext
- StepExecutionStartingContext
- StepExecutionCompletedContext
- PlanCompletionEvaluationStartingContext
- PlanCompletionEvaluationCompletedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
abstract val plan: Any?
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
abstract val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/state.html`

### :agents:agents-core/commonMain

```kotlin
abstract val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.PlannerEventContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-planner-event-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
abstract val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.StepExecutionCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/-step-execution-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class StepExecutionCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val state: Any, val stateType: TypeToken?, val plan: Any, val planType: TypeToken?, val stepIndex: Int) : PlannerEventContext
```

Represents the context for an executeStep operation completed event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
open override val plan: Any
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/state.html`

### :agents:agents-core/commonMain

```kotlin
open override val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.StepExecutionCompletedContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-completed-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
open override val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.StepExecutionStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/-step-execution-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, state: Any, stateType: TypeToken?, plan: Any, planType: TypeToken?, stepIndex: Int)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The Agent context associated with the planner execution.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class StepExecutionStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val state: Any, val stateType: TypeToken?, val plan: Any, val planType: TypeToken?, val stepIndex: Int) : PlannerEventContext
```

Represents the context for an executeStep operation starting event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.planType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/plan-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val planType: TypeToken?
```

The TypeToken of the plan


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.plan

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/plan.html`

### :agents:agents-core/commonMain

```kotlin
open override val plan: Any
```

The current plan being executed or planned.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.stateType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/state-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateType: TypeToken?
```

The TypeToken of the state


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.state

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/state.html`

### :agents:agents-core/commonMain

```kotlin
open override val state: Any
```

The current state of the planner execution.

## ai.koog.agents.core.feature.handler.planner.StepExecutionStartingContext.stepIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.planner/-step-execution-starting-context/step-index.html`

### :agents:agents-core/commonMain

```kotlin
open override val stepIndex: Int
```

The index of the current step within the plan.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.StrategyCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/-strategy-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, result: Any?, resultType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class StrategyCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val strategy: AIAgentStrategy<*, *, *>, val result: Any?, val resultType: TypeToken) : StrategyEventContext
```

Represents the context associated with the completion of an AI agent strategy execution.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.resultType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/result-type.html`

### :agents:agents-core/commonMain

```kotlin
val resultType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.result

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/result.html`

### :agents:agents-core/commonMain

```kotlin
val result: Any?
```

## ai.koog.agents.core.feature.handler.strategy.StrategyCompletedContext.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-completed-context/strategy.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategy: AIAgentStrategy<*, *, *>
```

The strategy being handled or updated, encapsulating the AI agent's workflow logic.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.strategy.StrategyEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.strategy.StrategyEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface StrategyEventContext : AgentLifecycleEventContext
```

Defines the context specifically for handling strategy-related events within the AI agent framework. Extends the base event handler context to include functionality and behavior dedicated to managing the lifecycle and operations of strategies associated with AI agents.

- StrategyStartingContext
- StrategyCompletedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.strategy.StrategyEventContext.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-event-context/strategy.html`

### :agents:agents-core/commonMain

```kotlin
abstract val strategy: AIAgentStrategy<*, *, *>
```

The strategy being handled or updated, encapsulating the AI agent's workflow logic.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.StrategyStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/-strategy-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, strategy: AIAgentStrategy<*, *, *>, input: Any?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The AI agent context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class StrategyStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val strategy: AIAgentStrategy<*, *, *>, val input: Any?) : StrategyEventContext
```

Represents the context for updating AI agent strategies during execution.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.strategy.StrategyStartingContext.strategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.strategy/-strategy-starting-context/strategy.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategy: AIAgentStrategy<*, *, *>
```

The strategy being handled or updated, encapsulating the AI agent's workflow logic.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.LLMStreamingCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/-l-l-m-streaming-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The agent context associated with the streaming event.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMStreamingCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val tools: List<ToolDescriptor>) : LLMStreamingEventContext
```

Represents the context for handling an after-stream event. This context is provided when streaming is complete.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used for streaming.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model for streaming.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this streaming session.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingCompletedContext.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-completed-context/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<ToolDescriptor>
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentContext
```

The agent context associated with the streaming event.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface LLMStreamingEventContext : AgentLifecycleEventContext
```

Represents the context for handling streaming-specific events within the framework.

- LLMStreamingStartingContext
- LLMStreamingFrameReceivedContext
- LLMStreamingFailedContext
- LLMStreamingCompletedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingEventContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-event-context/model.html`

### :agents:agents-core/commonMain

```kotlin
abstract val model: LLModel
```

The language model instance being used for streaming.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingEventContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-event-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
abstract val prompt: Prompt
```

The prompt that will be sent to the language model for streaming.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingEventContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-event-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val runId: String
```

The unique identifier for this streaming session.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.LLMStreamingFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/-l-l-m-streaming-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The agent context associated with the streaming event.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable
```

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMStreamingFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val error: Throwable) : LLMStreamingEventContext
```

Represents the context for handling an error event during streaming. This context is provided when an error occurs during streaming.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used for streaming.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model for streaming.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFailedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-failed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this streaming session.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.LLMStreamingFrameReceivedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/-l-l-m-streaming-frame-received-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, streamFrame: StreamFrame)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The agent context associated with the streaming event.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMStreamingFrameReceivedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val streamFrame: StreamFrame) : LLMStreamingEventContext
```

Represents the context for handling individual stream frame events. This context is provided when stream frames are sent out during the streaming process.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used for streaming.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model for streaming.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this streaming session.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingFrameReceivedContext.streamFrame

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-frame-received-context/stream-frame.html`

### :agents:agents-core/commonMain

```kotlin
val streamFrame: StreamFrame
```


Referenced packages: `ai.koog.prompt.streaming`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.LLMStreamingStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/-l-l-m-streaming-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The agent context associated with the streaming event.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class LLMStreamingStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val prompt: Prompt, val model: LLModel, val tools: List<ToolDescriptor>) : LLMStreamingEventContext
```

Represents the context for handling a before-stream event. This context is provided when streaming is about to begin.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.model

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/model.html`

### :agents:agents-core/commonMain

```kotlin
open override val model: LLModel
```

The language model instance being used for streaming.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.prompt

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/prompt.html`

### :agents:agents-core/commonMain

```kotlin
open override val prompt: Prompt
```

The prompt that will be sent to the language model for streaming.


Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

The unique identifier for this streaming session.

## ai.koog.agents.core.feature.handler.streaming.LLMStreamingStartingContext.tools

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.streaming/-l-l-m-streaming-starting-context/tools.html`

### :agents:agents-core/commonMain

```kotlin
val tools: List<ToolDescriptor>
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.SubgraphExecutionCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/-subgraph-execution-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken, output: Any?, outputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The context in which the subgraph is being executed.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class SubgraphExecutionCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val subgraph: AIAgentSubgraphBase<*, *>, val input: Any?, val inputType: TypeToken, val output: Any?, val outputType: TypeToken) : SubgraphExecutionEventContext
```

The context for handling a subgraph execution completed event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.outputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/output-type.html`

### :agents:agents-core/commonMain

```kotlin
val outputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: Any?
```

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionCompletedContext.subgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-completed-context/subgraph.html`

### :agents:agents-core/commonMain

```kotlin
open override val subgraph: AIAgentSubgraphBase<*, *>
```

The subgraph instance that is being executed.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentContext
```

The context in which the subgraph is being executed.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface SubgraphExecutionEventContext : AgentLifecycleEventContext
```

Represents the context for handling subgraph-specific events for graph strategies within the framework.

- SubgraphExecutionStartingContext
- SubgraphExecutionCompletedContext
- SubgraphExecutionFailedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionEventContext.subgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-event-context/subgraph.html`

### :agents:agents-core/commonMain

```kotlin
abstract val subgraph: AIAgentSubgraphBase<*, *>
```

The subgraph instance that is being executed.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.SubgraphExecutionFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/-subgraph-execution-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The context in which the subgraph is being executed.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable
```

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class SubgraphExecutionFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val subgraph: AIAgentSubgraphBase<*, *>, val input: Any?, val inputType: TypeToken, val error: Throwable) : SubgraphExecutionEventContext
```

The context for handling a subgraph execution failed event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionFailedContext.subgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-failed-context/subgraph.html`

### :agents:agents-core/commonMain

```kotlin
open override val subgraph: AIAgentSubgraphBase<*, *>
```

The subgraph instance that is being executed.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.SubgraphExecutionStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/-subgraph-execution-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, subgraph: AIAgentSubgraphBase<*, *>, input: Any?, inputType: TypeToken)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

The context in which the subgraph is being executed.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```

Holds execution-specific context information to support observability and tracing during the lifecycle of an agent.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class SubgraphExecutionStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val subgraph: AIAgentSubgraphBase<*, *>, val input: Any?, val inputType: TypeToken) : SubgraphExecutionEventContext
```

The context for handling a subgraph execution starting event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.entity`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.inputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/input-type.html`

### :agents:agents-core/commonMain

```kotlin
val inputType: TypeToken
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.input

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/input.html`

### :agents:agents-core/commonMain

```kotlin
val input: Any?
```

## ai.koog.agents.core.feature.handler.subgraph.SubgraphExecutionStartingContext.subgraph

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.subgraph/-subgraph-execution-starting-context/subgraph.html`

### :agents:agents-core/commonMain

```kotlin
open override val subgraph: AIAgentSubgraphBase<*, *>
```

The subgraph instance that is being executed.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.ToolCallCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/-tool-call-completed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, toolResult: JSONElement?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

context The agent context associated with the tool call.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ToolCallCompletedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val toolCallId: String?, val toolName: String, val toolDescription: String?, val toolArgs: JSONObject, val toolResult: JSONElement?) : ToolCallEventContext
```

Represents the context used when handling the result of a tool call.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

runId The unique identifier for this tool call session.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolArgs: JSONObject
```

toolArgs The arguments provided for the tool execution, adhering to the tool's expected input structure.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolCallId: String?
```

toolCallId The unique identifier for this tool call.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolDescription: String?
```

toolDescription A description of the tool being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolName: String
```

toolName The tool name that is being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallCompletedContext.toolResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-completed-context/tool-result.html`

### :agents:agents-core/commonMain

```kotlin
val toolResult: JSONElement?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/context.html`

### :agents:agents-core/commonMain

```kotlin
abstract val context: AIAgentContext
```

context The agent context associated with the tool call.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/index.html`

### :agents:agents-core/commonMain

```kotlin
interface ToolCallEventContext : AgentLifecycleEventContext
```

Represents the context for handling tool call events.

- ToolCallStartingContext
- ToolValidationFailedContext
- ToolCallFailedContext
- ToolCallCompletedContext

Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val runId: String
```

runId The unique identifier for this tool call session.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
abstract val toolArgs: JSONObject
```

toolArgs The arguments provided for the tool execution, adhering to the tool's expected input structure.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
abstract val toolCallId: String?
```

toolCallId The unique identifier for this tool call.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
abstract val toolDescription: String?
```

toolDescription A description of the tool being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallEventContext.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-event-context/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
abstract val toolName: String
```

toolName The tool name that is being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.ToolCallFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/-tool-call-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable?)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

context The agent context associated with the tool call.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable?
```

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ToolCallFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val toolCallId: String?, val toolName: String, val toolDescription: String?, val toolArgs: JSONObject, val message: String, val error: Throwable?) : ToolCallEventContext
```

Represents the context provided to handle a failure during the execution of a tool.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String
```

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

runId The unique identifier for this tool call session.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolArgs: JSONObject
```

toolArgs The arguments provided for the tool execution, adhering to the tool's expected input structure.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolCallId: String?
```

toolCallId The unique identifier for this tool call.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolDescription: String?
```

toolDescription A description of the tool being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallFailedContext.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-failed-context/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolName: String
```

toolName The tool name that is being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.ToolCallStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/-tool-call-starting-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

context The agent context associated with the tool call.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ToolCallStartingContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val toolCallId: String?, val toolName: String, val toolDescription: String?, val toolArgs: JSONObject) : ToolCallEventContext
```

Represents the context for handling a tool call event.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

runId The unique identifier for this tool call session.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolArgs: JSONObject
```

toolArgs The arguments provided for the tool execution, adhering to the tool's expected input structure.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolCallId: String?
```

toolCallId The unique identifier for this tool call.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolDescription: String?
```

toolDescription A description of the tool being executed.

## ai.koog.agents.core.feature.handler.tool.ToolCallStartingContext.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-call-starting-context/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolName: String
```

toolName The tool name that is being executed.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.ToolValidationFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/-tool-validation-failed-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(eventId: String, executionInfo: AgentExecutionInfo, context: AIAgentContext, runId: String, toolCallId: String?, toolName: String, toolDescription: String?, toolArgs: JSONObject, message: String, error: Throwable)
```


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/context.html`

### :agents:agents-core/commonMain

```kotlin
open override val context: AIAgentContext
```

context The agent context associated with the tool call.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.error

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/error.html`

### :agents:agents-core/commonMain

```kotlin
val error: Throwable
```

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.eventId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/event-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventId: String
```

The unique identifier for the event.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.eventType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/event-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val eventType: AgentLifecycleEventType
```

Represents the specific type of event handled within the event handler context, categorizing the nature of agent-related or strategy-related events.


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override val executionInfo: AgentExecutionInfo
```


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ToolValidationFailedContext(val eventId: String, val executionInfo: AgentExecutionInfo, val context: AIAgentContext, val runId: String, val toolCallId: String?, val toolName: String, val toolDescription: String?, val toolArgs: JSONObject, val message: String, val error: Throwable) : ToolCallEventContext
```

Represents the context for handling validation errors that occur during the execution of a tool.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.execution`, `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.message

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/message.html`

### :agents:agents-core/commonMain

```kotlin
val message: String
```

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

runId The unique identifier for this tool call session.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.toolArgs

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/tool-args.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolArgs: JSONObject
```

toolArgs The arguments provided for the tool execution, adhering to the tool's expected input structure.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.toolCallId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/tool-call-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolCallId: String?
```

toolCallId The unique identifier for this tool call.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.toolDescription

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/tool-description.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolDescription: String?
```

toolDescription A description of the tool being executed.

## ai.koog.agents.core.feature.handler.tool.ToolValidationFailedContext.toolName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.feature.handler.tool/-tool-validation-failed-context/tool-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val toolName: String
```

toolName The tool name that is being executed.

## ai.koog.agents.features.eventHandler.feature.EventHandler.EventHandler

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler/-event-handler.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.eventHandler.feature.EventHandler.Feature.createInitialConfig

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): EventHandlerConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.features.eventHandler.feature.EventHandler.Feature

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler/-feature/index.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
object Feature : AIAgentGraphFeature<EventHandlerConfig, EventHandler> , AIAgentFunctionalFeature<EventHandlerConfig, EventHandler> , AIAgentPlannerFeature<EventHandlerConfig, EventHandler>
```

Companion object implementing agent feature, handling EventHandler creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.features.eventHandler.feature.EventHandler.Feature.install

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler/-feature/install.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
open override fun install(config: EventHandlerConfig, pipeline: AIAgentGraphPipeline): EventHandler
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
open override fun install(config: EventHandlerConfig, pipeline: AIAgentFunctionalPipeline): EventHandler
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
open override fun install(config: EventHandlerConfig, pipeline: AIAgentPlannerPipeline): EventHandler
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.features.eventHandler.feature.EventHandler.Feature.key

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler/-feature/key.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
open override val key: AIAgentStorageKey<EventHandler>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.features.eventHandler.feature.EventHandler

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler/index.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
class EventHandler
```

A feature that allows hooking into various events in the agent's lifecycle.

The EventHandler provides a way to register callbacks for different events that occur during the execution of an agent, such as agent lifecycle events, strategy events, node events, LLM call events, and tool call events.

Example usage:

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfig.EventHandlerConfig

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config/-event-handler-config.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
expect constructor()
```

### :agents:agents-features:agents-features-event-handler/jvmCommonMain

```kotlin
actual constructor()
```

### :agents:agents-features:agents-features-event-handler/nonJvmCommonMain

```kotlin
actual constructor()
```

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfig

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config/index.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
expect open class EventHandlerConfig : EventHandlerConfigCommon
```

Configuration class for the EventHandler feature.

This class provides a way to configure handlers for various events that occur during the execution of an agent. These events include agent lifecycle events, strategy events, node events, LLM call events, and tool call events.

Each handler is a property that can be assigned a lambda function to be executed when the corresponding event occurs.

Example usage:

### :agents:agents-features:agents-features-event-handler/jvmCommonMain

```kotlin
actual open class EventHandlerConfig : EventHandlerConfigCommon
```

### :agents:agents-features:agents-features-event-handler/nonJvmCommonMain

```kotlin
actual open class EventHandlerConfig : EventHandlerConfigCommon
```

Configuration class for the EventHandler feature.

This class provides a way to configure handlers for various events that occur during the execution of an agent. These events include agent lifecycle events, strategy events, node events, LLM call events, and tool call events.

Each handler is a property that can be assigned a lambda function to be executed when the corresponding event occurs.

Example usage:

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.EventHandlerConfigCommon

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/-event-handler-config-common.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/index.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
open class EventHandlerConfigCommon : FeatureConfig
```

API for the EventHandlerConfig

- EventHandlerConfig

Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onAgentClosing

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-agent-closing.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onAgentClosing(handler: suspend (eventContext: AgentClosingContext) -> Unit)
```

Appends a handler called before an agent is closed. This allows for additional behavior to be executed prior to the agent being closed.


Referenced packages: `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onAgentCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-agent-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onAgentCompleted(handler: suspend (eventContext: AgentCompletedContext) -> Unit)
```

Append handler called when an agent finishes execution.


Referenced packages: `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onAgentExecutionFailed

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-agent-execution-failed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onAgentExecutionFailed(handler: suspend (eventContext: AgentExecutionFailedContext) -> Unit)
```

Append handler called when an error occurs during agent execution.


Referenced packages: `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onAgentStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-agent-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onAgentStarting(handler: suspend (eventContext: AgentStartingContext) -> Unit)
```

Append handler called when an agent is started.


Referenced packages: `ai.koog.agents.core.feature.handler.agent`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onLLMCallCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-l-l-m-call-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onLLMCallCompleted(handler: suspend (eventContext: LLMCallCompletedContext) -> Unit)
```

Append handler called after a response is received from the language model.


Referenced packages: `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onLLMCallStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-l-l-m-call-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onLLMCallStarting(handler: suspend (eventContext: LLMCallStartingContext) -> Unit)
```

Append handler called before a call is made to the language model.


Referenced packages: `ai.koog.agents.core.feature.handler.llm`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onLLMStreamingCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-l-l-m-streaming-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onLLMStreamingCompleted(handler: suspend (eventContext: LLMStreamingCompletedContext) -> Unit)
```

Registers a handler to be invoked after streaming from a language model completes.

This handler is called when the streaming operation finishes, allowing you to perform post-processing, cleanup, or final logging operations.

- handler — The handler function that receives an LLMStreamingCompletedContext containing the run ID, prompt, model, and tools that were used for the streaming session.Example:onLLMStreamingCompleted { eventContext -> logger.info("Stream completed for run: ${eventContext.runId}") // Perform any cleanup or aggregation of collected stream data} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onLLMStreamingFailed

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-l-l-m-streaming-failed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onLLMStreamingFailed(handler: suspend (eventContext: LLMStreamingFailedContext) -> Unit)
```

Registers a handler to be invoked when an error occurs during streaming.

This handler is called when an error occurs during streaming, allowing you to perform error handling or logging.

- handler — The handler function that receives a LLMStreamingFailedContext containing the run ID, prompt, model, and tools that were used for the streaming session.Example:onLLMStreamingFailed { eventContext -> logger.error("Stream error for run: ${eventContext.runId}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onLLMStreamingFrameReceived

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-l-l-m-streaming-frame-received.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onLLMStreamingFrameReceived(handler: suspend (eventContext: LLMStreamingFrameReceivedContext) -> Unit)
```

Registers a handler to be invoked when stream frames are received during streaming.

This handler is called for each stream frame as it arrives from the language model, enabling real-time processing, monitoring, or aggregation of streaming content.

- handler — The handler function that receives a LLMStreamingFrameReceivedContext containing the run ID and the stream frame with partial response data.Example:onLLMStreamingFrameReceived { eventContext -> when (val frame = eventContext.streamFrame) { is StreamFrame.Append -> processText(frame.text) is StreamFrame.ToolCall -> processTool(frame) }} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onLLMStreamingStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-l-l-m-streaming-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onLLMStreamingStarting(handler: suspend (eventContext: LLMStreamingStartingContext) -> Unit)
```

Registers a handler to be invoked before streaming from a language model begins.

This handler is called immediately before starting a streaming operation, allowing you to perform preprocessing, validation, or logging of the streaming request.

- handler — The handler function that receives a LLMStreamingStartingContext containing the run ID, prompt, model, and available tools for the streaming session.Example:onLLMStreamingStarting { eventContext -> logger.info("Starting stream for run: ${eventContext.runId}") logger.debug("Prompt: ${eventContext.prompt}")} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.feature.handler.streaming`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onNodeExecutionCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-node-execution-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onNodeExecutionCompleted(handler: suspend (eventContext: NodeExecutionCompletedContext) -> Unit)
```

Append handler called after a node in the agent's execution graph has been processed.


Referenced packages: `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onNodeExecutionFailed

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-node-execution-failed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onNodeExecutionFailed(handler: suspend (eventContext: NodeExecutionFailedContext) -> Unit)
```

Append handler called when an error occurs during the execution of a node.


Referenced packages: `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onNodeExecutionStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-node-execution-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onNodeExecutionStarting(handler: suspend (eventContext: NodeExecutionStartingContext) -> Unit)
```

Append handler called before a node in the agent's execution graph is processed.


Referenced packages: `ai.koog.agents.core.feature.handler.node`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onStrategyCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-strategy-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onStrategyCompleted(handler: suspend (eventContext: StrategyCompletedContext) -> Unit)
```

Append handler called when a strategy finishes execution.


Referenced packages: `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onStrategyStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-strategy-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onStrategyStarting(handler: suspend (eventContext: StrategyStartingContext) -> Unit)
```

Append handler called when a strategy starts execution.


Referenced packages: `ai.koog.agents.core.feature.handler.strategy`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onSubgraphExecutionCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-subgraph-execution-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onSubgraphExecutionCompleted(handler: suspend (eventContext: SubgraphExecutionCompletedContext) -> Unit)
```

Append handler called after a subgraph in the agent's execution graph has been processed.


Referenced packages: `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onSubgraphExecutionFailed

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-subgraph-execution-failed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onSubgraphExecutionFailed(handler: suspend (eventContext: SubgraphExecutionFailedContext) -> Unit)
```

Append handler called when an error occurs during the execution of a subgraph.


Referenced packages: `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onSubgraphExecutionStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-subgraph-execution-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onSubgraphExecutionStarting(handler: suspend (eventContext: SubgraphExecutionStartingContext) -> Unit)
```

Append handler called before a subgraph in the agent's execution graph is processed.


Referenced packages: `ai.koog.agents.core.feature.handler.subgraph`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onToolCallCompleted

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-tool-call-completed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onToolCallCompleted(handler: suspend (eventContext: ToolCallCompletedContext) -> Unit)
```

Append handler called when a tool call completes successfully.


Referenced packages: `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onToolCallFailed

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-tool-call-failed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onToolCallFailed(handler: suspend (eventContext: ToolCallFailedContext) -> Unit)
```

Append handler called when a tool call fails with an exception.


Referenced packages: `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onToolCallStarting

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-tool-call-starting.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onToolCallStarting(handler: suspend (eventContext: ToolCallStartingContext) -> Unit)
```

Append handler called when a tool is about to be called.


Referenced packages: `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.features.eventHandler.feature.EventHandlerConfigCommon.onToolValidationFailed

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/-event-handler-config-common/on-tool-validation-failed.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun onToolValidationFailed(handler: suspend (eventContext: ToolValidationFailedContext) -> Unit)
```

Append handler called when a validation error occurs during a tool call.


Referenced packages: `ai.koog.agents.core.feature.handler.tool`.

## ai.koog.agents.features.eventHandler.feature.handleEvents

Module: `agents-features-event-handler`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-event-handler/ai.koog.agents.features.eventHandler.feature/handle-events.html`

### :agents:agents-features:agents-features-event-handler/commonMain

```kotlin
fun GraphAIAgent.FeatureContext.handleEvents(configure: EventHandlerConfig.() -> Unit)
```

Installs the EventHandler feature and configures event handlers for an agent.

This extension function provides a convenient way to install the EventHandler feature and configure various event handlers for an agent. It allows you to define custom behavior for different events that occur during the agent's execution.

- configure — A lambda with a receiver that configures the EventHandlerConfig. Use this to set up handlers for specific events.Example:handleEvents { // Log when tools are called onToolCallStarting { eventContext -> println("Tool called: ${eventContext.toolName} with args: ${eventContext.toolArgs}") } // Handle errors onAgentExecutionFailed { eventContext -> logger.error("Agent error: ${eventContext.error.message}") }} Content copied to clipboard

Referenced packages: `ai.koog.agents.core.agent`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetry.Feature.createInitialConfig

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): OpenTelemetryConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetry.Feature

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry/-feature/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object Feature : AIAgentGraphFeature<OpenTelemetryConfig, OpenTelemetry> , AIAgentFunctionalFeature<OpenTelemetryConfig, OpenTelemetry> , AIAgentPlannerFeature<OpenTelemetryConfig, OpenTelemetry>
```

Companion object implementing agent feature, handling OpenTelemetry creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetry.Feature.install

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry/-feature/install.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override fun install(config: OpenTelemetryConfig, pipeline: AIAgentGraphPipeline): OpenTelemetry
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override fun install(config: OpenTelemetryConfig, pipeline: AIAgentFunctionalPipeline): OpenTelemetry
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override fun install(config: OpenTelemetryConfig, pipeline: AIAgentPlannerPipeline): OpenTelemetry
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetry.Feature.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry/-feature/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: AIAgentStorageKey<OpenTelemetry>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetry.OpenTelemetry

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry/-open-telemetry.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetry

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
class OpenTelemetry
```

Represents the OpenTelemetry integration feature for tracking and managing spans and contexts within the AI Agent framework. This class manages the lifecycle of spans for various operations, including agent executions, node processing, LLM calls, and tool calls.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.OpenTelemetryConfig

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/-open-telemetry-config.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect constructor()
```

Constructs a new OpenTelemetryConfig with default service information.

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
actual constructor()
```

Constructs a new OpenTelemetryConfig with default service information.

### :agents:agents-features:agents-features-opentelemetry/nonJvmCommonMain

```kotlin
actual constructor()
```

Constructs a new OpenTelemetryConfig with default service information.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addDatadogExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-datadog-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun addDatadogExporter(datadogApiKey: String? = null, url: String? = null, timeout: Duration? = null, resourceAttributes: Map<String, String>? = null)
```

- addDatadogExporter
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addLangfuseExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-langfuse-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun addLangfuseExporter(langfuseUrl: String? = null, langfusePublicKey: String? = null, langfuseSecretKey: String? = null, timeout: Duration? = null, traceAttributes: List<CustomAttribute>? = null)
```

- addLangfuseExporter

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addMetricExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-metric-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun addMetricExporter(exporter: MetricExporter, meterInterval: ERROR CLASS: Symbol not found for Duration = defaultMeterInterval)
```

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun addMetricExporter(exporter: MetricExporter, meterInterval: Duration)
```

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addMetricFilter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-metric-filter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun addMetricFilter(metricName: String, keysToRetain: Set<String>)
```

Registers a filter that restricts the attribute keys retained on a given metric during aggregation.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addResourceAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-resource-attributes.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun addResourceAttributes(attributes: Map<String, Any>)
```

Adds resource attributes reported alongside every exported span.

- attributes — key/value pairs; supported value types are String, Long, Double, Boolean.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addSpanAdapter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-span-adapter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun addSpanAdapter(adapter: SpanAdapter)
```

Installs a SpanAdapter that post-processes every GenAI span. Replaces any previously installed adapter.

- adapter — Adapter to install.

Referenced packages: `ai.koog.agents.features.opentelemetry.integration`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addSpanExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-span-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun addSpanExporter(exporter: SpanExporter)
```

Registers exporter wrapped in a batchSpanProcessor - the OTel-recommended default for production deployments. Spans are buffered and flushed on a worker so the agent never blocks on network I/O at the span end.

For full control over the processor (custom batching parameters, custom processor implementations) use addSpanProcessor instead.

- exporter — The Kotlin OTel SDK SpanExporter to register.
### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun addSpanExporter(exporter: SpanExporter)
```

For full control over the processor (custom batching parameters, simple/composite processors) use addSpanProcessor { batchSpanProcessor(exporter.toOtelKotlinSpanExporter()) } directly.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addSpanProcessor

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-span-processor.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun addSpanProcessor(factory: TraceExportConfigDsl.() -> SpanProcessor)
```

Registers a SpanProcessor produced by a factory invoked inside the SDK's TraceExportConfigDsl scope. Use this when the convenience addSpanExporter (which always wraps in batchSpanProcessor) doesn't fit - e.g., custom batching parameters, custom processor implementations, or a compositeSpanProcessor over several inner processors.

Example:

- factory — Lambda that returns the SpanProcessor when invoked inside the SDK's export-config DSL.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.addWeaveExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/add-weave-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun addWeaveExporter(weaveOtelBaseUrl: String? = null, weaveEntity: String? = null, weaveProjectName: String? = null, weaveApiKey: String? = null, timeout: Duration? = null)
```

- addWeaveExporter
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect class OpenTelemetryConfig : FeatureConfig, OpenTelemetryConfigAPI
```

Configuration class for the OpenTelemetry integration.

Tracing is backed by the Kotlin Multiplatform OpenTelemetry SDK - the tracing surface defined here (span processors, resource attributes, verbose mode, service info) is available on every target.

Tracing-side integrations (Langfuse, W&B Weave, Datadog) ship as commonMain extensions on top of an OTLP/JSON exporter, so they work on every target. The Kotlin SDK ships no metrics module, so metrics still live behind JVM-only extension functions declared in jvmMain (addMetricExporter, addMetricFilter, meter).

Power users who need full control over the SDK (custom samplers, custom span processors, span limits, etc.) can construct their own OpenTelemetry via createOpenTelemetry and inject it via setSdk - in that case the other configuration setters become inert.


Referenced packages: `ai.koog.agents.core.feature.config`.

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual class OpenTelemetryConfig : <ERROR CLASS> ERROR CLASS: Symbol not found for FeatureConfig, OpenTelemetryConfigAPI
```

Configuration class for the OpenTelemetry feature, providing integration and export mechanisms for traces, metrics, and other telemetry data. This class abstracts the underlying implementation and offers convenient methods for setup and configuration within the Kotlin Multiplatform SDK.

### :agents:agents-features:agents-features-opentelemetry/nonJvmCommonMain

```kotlin
actual class OpenTelemetryConfig : FeatureConfig, OpenTelemetryConfigAPI
```

Configuration class for the OpenTelemetry integration.

Tracing is backed by the Kotlin Multiplatform OpenTelemetry SDK - the tracing surface defined here (span processors, resource attributes, verbose mode, service info) is available on every target.

Tracing-side integrations (Langfuse, W&B Weave, Datadog) ship as commonMain extensions on top of an OTLP/JSON exporter, so they work on every target. The Kotlin SDK ships no metrics module, so metrics still live behind JVM-only extension functions declared in jvmMain (addMetricExporter, addMetricFilter, meter).

Power users who need full control over the SDK (custom samplers, custom span processors, span limits, etc.) can construct their own OpenTelemetry via createOpenTelemetry and inject it via setSdk - in that case the other configuration setters become inert.


Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.isShutdownOnAgentClose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/is-shutdown-on-agent-close.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override val isShutdownOnAgentClose: Boolean
```

Indicates whether OpenTelemetry resources should be shut down when the agent closes.

Defaults to false. When true, the feature's agent-close handler calls the internal SDK-shutdown routine, which shuts down every registered span processor (which in turn shuts down its wrapped exporter) and on JVM also closes the metrics SdkMeterProvider. On non-JVM targets the metrics path is a no-op; only span processors are shut down.

Note: if multiple agents share the same OpenTelemetryConfig, enabling this causes shutdown to happen when the first agent closes, which may affect the remaining agents.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.isVerbose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/is-verbose.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override val isVerbose: Boolean
```

Indicates whether verbose telemetry data is enabled.

When true, more detailed span attributes and events are recorded (e.g., full message contents instead of placeholders). Useful for debugging; may increase volume significantly.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.meter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/meter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
val meter: Meter
```

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.serviceName

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/service-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override val serviceName: String
```

The service name reported in resource attributes.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.serviceNamespace

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/service-namespace.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override val serviceNamespace: String?
```

The service namespace reported in resource attributes, or null if not set.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.serviceVersion

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/service-version.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override val serviceVersion: String
```

The service version reported in resource attributes.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.setEventFilter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/set-event-filter.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
open override fun setEventFilter(filter: (ERROR CLASS: Symbol not found for AgentLifecycleEventContext) -> Boolean)
```

### :agents:agents-features:agents-features-opentelemetry/nonJvmCommonMain

```kotlin
open override fun setEventFilter(filter: (AgentLifecycleEventContext) -> Boolean)
```


Referenced packages: `ai.koog.agents.core.feature.handler`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.setSdk

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/set-sdk.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun setSdk(openTelemetry: OpenTelemetry)
```

Injects a pre-built Kotlin OpenTelemetry SDK to use for tracing.

When set, the feature uses openTelemetry as-is and skips internal SDK construction - meaning addSpanProcessor, addResourceAttributes, setServiceInfo, and the addLangfuseExporter / addWeaveExporter / addDatadogExporter integration helpers all become inert. Use this escape hatch when you need full control over the SDK: custom samplers, custom span processors, custom span limits, resource detectors, etc.

Build the SDK with io.opentelemetry.kotlin.createOpenTelemetry { … } and hand it off:

The instrumentation scope name/version reported by tracer still come from setServiceInfo (or the defaults). If you need them inside the SDK's resource attributes, set them in the resource(...) block of your createOpenTelemetry { } call.

- openTelemetry — Pre-built SDK instance to use.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.setServiceInfo

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/set-service-info.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun setServiceInfo(serviceName: String, serviceVersion: String, serviceNamespace: String? = null)
```

Sets the service information reported in resource attributes.

- serviceName — Value for the service.name resource attribute.
- serviceVersion — Value for the service.version resource attribute.
- serviceNamespace — Value for the service.namespace resource attribute, or null to omit it.
### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun setServiceInfo(serviceName: String, serviceVersion: String)
```

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.setShutdownOnAgentClose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/set-shutdown-on-agent-close.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun setShutdownOnAgentClose(shutdownOnAgentClose: Boolean)
```

Toggles whether OpenTelemetryPlatform.shutdown runs when the agent closes. See isShutdownOnAgentClose.

- shutdownOnAgentClose — When true, the feature shuts down its SDK when the agent closes.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.setVerbose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/set-verbose.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override fun setVerbose(verbose: Boolean)
```

Toggles verbose telemetry capture. See isVerbose.

- verbose — When true, sensitive payloads are emitted unmasked.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfig.tracer

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config/tracer.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
expect open override val tracer: Tracer
```

The Kotlin Multiplatform OpenTelemetry SDK Tracer used by the feature.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.addResourceAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/add-resource-attributes.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun addResourceAttributes(attributes: Map<String, Any>)
```

Adds resource attributes reported alongside every exported span.

- attributes — key/value pairs; supported value types are String, Long, Double, Boolean.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.addSpanAdapter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/add-span-adapter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun addSpanAdapter(adapter: SpanAdapter)
```

Installs a SpanAdapter that post-processes every GenAI span. Replaces any previously installed adapter.

- adapter — Adapter to install.

Referenced packages: `ai.koog.agents.features.opentelemetry.integration`.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.addSpanExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/add-span-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun addSpanExporter(exporter: SpanExporter)
```

Registers exporter wrapped in a batchSpanProcessor - the OTel-recommended default for production deployments. Spans are buffered and flushed on a worker so the agent never blocks on network I/O at the span end.

For full control over the processor (custom batching parameters, custom processor implementations) use addSpanProcessor instead.

- exporter — The Kotlin OTel SDK SpanExporter to register.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.addSpanProcessor

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/add-span-processor.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun addSpanProcessor(factory: TraceExportConfigDsl.() -> SpanProcessor)
```

Registers a SpanProcessor produced by a factory invoked inside the SDK's TraceExportConfigDsl scope. Use this when the convenience addSpanExporter (which always wraps in batchSpanProcessor) doesn't fit - e.g., custom batching parameters, custom processor implementations, or a compositeSpanProcessor over several inner processors.

Example:

- factory — Lambda that returns the SpanProcessor when invoked inside the SDK's export-config DSL.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
interface OpenTelemetryConfigAPI
```

API for OpenTelemetryConfig.

- OpenTelemetryConfig
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.isShutdownOnAgentClose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/is-shutdown-on-agent-close.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val isShutdownOnAgentClose: Boolean
```

Indicates whether OpenTelemetry resources should be shut down when the agent closes.

Defaults to false. When true, the feature's agent-close handler calls the internal SDK-shutdown routine, which shuts down every registered span processor (which in turn shuts down its wrapped exporter) and on JVM also closes the metrics SdkMeterProvider. On non-JVM targets the metrics path is a no-op; only span processors are shut down.

Note: if multiple agents share the same OpenTelemetryConfig, enabling this causes shutdown to happen when the first agent closes, which may affect the remaining agents.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.isVerbose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/is-verbose.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val isVerbose: Boolean
```

Indicates whether verbose telemetry data is enabled.

When true, more detailed span attributes and events are recorded (e.g., full message contents instead of placeholders). Useful for debugging; may increase volume significantly.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.serviceName

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/service-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val serviceName: String
```

The service name reported in resource attributes.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.serviceNamespace

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/service-namespace.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val serviceNamespace: String?
```

The service namespace reported in resource attributes, or null if not set.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.serviceVersion

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/service-version.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val serviceVersion: String
```

The service version reported in resource attributes.

## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.setSdk

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/set-sdk.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun setSdk(openTelemetry: OpenTelemetry)
```

Injects a pre-built Kotlin OpenTelemetry SDK to use for tracing.

When set, the feature uses openTelemetry as-is and skips internal SDK construction - meaning addSpanProcessor, addResourceAttributes, setServiceInfo, and the addLangfuseExporter / addWeaveExporter / addDatadogExporter integration helpers all become inert. Use this escape hatch when you need full control over the SDK: custom samplers, custom span processors, custom span limits, resource detectors, etc.

Build the SDK with io.opentelemetry.kotlin.createOpenTelemetry { … } and hand it off:

The instrumentation scope name/version reported by tracer still come from setServiceInfo (or the defaults). If you need them inside the SDK's resource attributes, set them in the resource(...) block of your createOpenTelemetry { } call.

- openTelemetry — Pre-built SDK instance to use.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.setServiceInfo

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/set-service-info.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun setServiceInfo(serviceName: String, serviceVersion: String, serviceNamespace: String? = null)
```

Sets the service information reported in resource attributes.

- serviceName — Value for the service.name resource attribute.
- serviceVersion — Value for the service.version resource attribute.
- serviceNamespace — Value for the service.namespace resource attribute, or null to omit it.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.setShutdownOnAgentClose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/set-shutdown-on-agent-close.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun setShutdownOnAgentClose(shutdownOnAgentClose: Boolean)
```

Toggles whether OpenTelemetryPlatform.shutdown runs when the agent closes. See isShutdownOnAgentClose.

- shutdownOnAgentClose — When true, the feature shuts down its SDK when the agent closes.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.setVerbose

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/set-verbose.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract fun setVerbose(verbose: Boolean)
```

Toggles verbose telemetry capture. See isVerbose.

- verbose — When true, sensitive payloads are emitted unmasked.
## ai.koog.agents.features.opentelemetry.feature.OpenTelemetryConfigAPI.tracer

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.feature/-open-telemetry-config-a-p-i/tracer.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val tracer: Tracer
```

The Kotlin Multiplatform OpenTelemetry SDK Tracer used by the feature.

## ai.koog.agents.features.opentelemetry.integration.langfuse.addLangfuseExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.langfuse/add-langfuse-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun OpenTelemetryConfig.addLangfuseExporter(langfuseUrl: String? = null, langfusePublicKey: String? = null, langfuseSecretKey: String? = null, timeout: Duration? = null, traceAttributes: List<CustomAttribute>? = null)
```

Configures a span exporter that sends data to Langfuse and installs the Langfuse SpanAdapter that reshapes spans to the Langfuse-recommended attribute layout.

Uses the Kotlin Multiplatform OTLP/JSON exporter - works on every target supported by the OpenTelemetry feature. Authenticates via HTTP Basic with LANGFUSE_PUBLIC_KEY and LANGFUSE_SECRET_KEY (passed in or read from environment variables).

Registered via addSpanExporter, which wraps the exporter in a batch span processor - the cloud HTTP round-trip happens on a worker thread instead of blocking the agent on each span end.

For test or non-cloud setups that need only the span transformations, see addLangfuseSpanAdapter.

- langfuseUrl — base Langfuse URL;
- langfusePublicKey — Langfuse public key. Defaults to LANGFUSE_PUBLIC_KEY env var;
- langfuseSecretKey — Langfuse secret key. Defaults to LANGFUSE_SECRET_KEY env var;
- timeout — request timeout (10 seconds by default);
- traceAttributes — list of trace-level Langfuse attributes (see https://langfuse.com/integrations/native/opentelemetry#propagating-attributes).

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`, `ai.koog.agents.features.opentelemetry.feature`.

## ai.koog.agents.features.opentelemetry.integration.weave.addWeaveExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.weave/add-weave-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun OpenTelemetryConfig.addWeaveExporter(weaveOtelBaseUrl: String? = null, weaveEntity: String? = null, weaveProjectName: String? = null, weaveApiKey: String? = null, timeout: Duration? = null)
```

Configures a span exporter that sends data to W&B Weave and installs the Weave SpanAdapter that reshapes spans to the Weave-recommended attribute layout.

Uses the Kotlin Multiplatform OTLP/JSON exporter - works on every target supported by the OpenTelemetry feature. Authenticates via HTTP Basic with the W&B API key.

Registered via addSpanExporter, which wraps the exporter in a batch span processor - the cloud HTTP round-trip happens on a worker thread instead of blocking the agent on each span end.

For test or non-cloud setups that need only the span transformations, see addWeaveSpanAdapter.

- weaveOtelBaseUrl — base Weave URL;
- weaveEntity — W&B Weave entity (org/team);
- weaveProjectName — W&B Weave project name;
- weaveApiKey — W&B API key;
- timeout — request timeout (10 seconds by default).

Referenced packages: `ai.koog.agents.features.opentelemetry.feature`.

## ai.koog.agents.features.tracing.feature.TraceFeatureConfig.TraceFeatureConfig

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-trace-feature-config/-trace-feature-config.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.tracing.feature.TraceFeatureConfig

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-trace-feature-config/index.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
class TraceFeatureConfig : FeatureConfig
```

Configuration for the tracing feature.

This class allows you to configure how the tracing feature behaves, including

Which message processors receive trace events

Example usage:


Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.features.tracing.feature.Tracing.Feature.createInitialConfig

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-tracing/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): TraceFeatureConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.features.tracing.feature.Tracing.Feature

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-tracing/-feature/index.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
object Feature : AIAgentGraphFeature<TraceFeatureConfig, Tracing>
```

Companion object implementing agent feature, handling Tracing creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.features.tracing.feature.Tracing.Feature.install

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-tracing/-feature/install.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
open override fun install(config: TraceFeatureConfig, pipeline: AIAgentGraphPipeline): Tracing
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.features.tracing.feature.Tracing.Feature.key

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-tracing/-feature/key.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
open override val key: AIAgentStorageKey<Tracing>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.features.tracing.feature.Tracing.Tracing

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-tracing/-tracing.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.tracing.feature.Tracing

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.feature/-tracing/index.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
class Tracing
```

Feature that collects comprehensive tracing data during agent execution and sends it to configured feature message processors.

Tracing is crucial for evaluation and analysis of the working agent, as it captures detailed information about:

All LLM calls and their responses

Prompts sent to LLMs

Tool calls, arguments, and results

Graph node visits and execution flow

Agent lifecycle events (creation, start, finish, errors)

Strategy execution events

This data can be used for debugging, performance analysis, auditing, and improving agent behavior.

Example of installing tracing to an agent:

Example of logs produced by tracing:

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter.Companion.create

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-file-writer/-companion/create.html`

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun create(targetPath: ERROR CLASS: Symbol not found for KotlinPath, sinkOpener: (@R|kotlin/ParameterName|(name = String(path)) ERROR CLASS: Symbol not found for KotlinPath) -> ERROR CLASS: Symbol not found for Sink? = null, format: (ERROR CLASS: Symbol not found for FeatureMessage) -> String? = null): TraceFeatureMessageFileWriter<ERROR CLASS: Symbol not found for KotlinPath>
```

Creates an instance of TraceFeatureMessageFileWriter for writing feature messages to a file.

A new instance of TraceFeatureMessageFileWriter configured with the specified parameters.

- targetPath — The path where feature messages will be written.
- sinkOpener — A lambda function that opens a Sink for writing files, managing its lifecycle. If not provided, a default sink opener using the system file system will be used.
- format — Optional lambda function for custom formatting of FeatureMessage instances. If not provided, a default formatting strategy will be used.
### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun create(targetPath: Path, streamOpener: (path: Path) -> OutputStream? = null, format: (ERROR CLASS: Symbol not found for FeatureMessage) -> String? = null): TraceFeatureMessageFileWriter<Path>
```

A new TraceFeatureMessageFileWriter instance.

- targetPath — The file path where trace events will be written.
- streamOpener — A function that opens an OutputStream for the given path. Defaults to Files.newOutputStream.
- format — Optional custom formatter for trace events.
## ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter.Companion

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-file-writer/-companion/index.html`

### :agents:agents-features:agents-features-trace/jvmCommonMain

```kotlin
object Companion
```

Companion object with factories for TraceFeatureMessageFileWriter

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter.TraceFeatureMessageFileWriter

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-file-writer/-trace-feature-message-file-writer.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
expect constructor(targetPath: Path, sinkOpener: (Path) -> Sink, format: (FeatureMessage) -> String? = null)
```

- targetPath — The path where feature messages will be written.
- sinkOpener — Returns a Sink for writing to the file, this class manages its lifecycle.
- format — Optional custom formatter for trace events
- Path — The type representing file paths in the file system

Referenced packages: `ai.koog.agents.core.feature.message`.

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(targetPath: Path, sinkOpener: (Path) -> ERROR CLASS: Symbol not found for Sink, format: (ERROR CLASS: Symbol not found for FeatureMessage) -> String?)
```

- targetPath — The path where feature messages will be written.
- sinkOpener — A function responsible for opening a Sink for file writing. This function ensures the lifecycle of the sink is properly managed. A default sink opener is available if not provided.
- format — An optional lambda function for customizing the formatting of FeatureMessage instances before writing them to the file. If not provided, a default formatting strategy is used.
### :agents:agents-features:agents-features-trace/nonJvmCommonMain

```kotlin
actual constructor(targetPath: Path, sinkOpener: (Path) -> Sink, format: (FeatureMessage) -> String?)
```

- targetPath — The file where feature messages will be written.
- sinkOpener — A lambda function that returns a Sink for writing to the file. The lifecycle of the sink is managed by this class.
- format — An optional lambda function for custom formatting of FeatureMessage instances into their string representations. This can be used to apply specific serialization logic if required. If not provided, the default message trace representation is used.
- Path — The type representing the file path supported by the file system provider.

Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-file-writer/index.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
expect class TraceFeatureMessageFileWriter<Path> : FeatureMessageFileWriter<Path>
```

A message processor that writes trace events to a file.

This writer captures all trace events and writes them to a specified file using the provided file system. It formats each event type differently to provide clear and readable logs.

Tracing to files is particularly useful for:

Persistent logging that survives application restarts

Detailed analysis of agent behavior after execution

Sharing trace logs with other developers or systems

Example usage:

- targetPath — The path where feature messages will be written.
- sinkOpener — Returns a Sink for writing to the file, this class manages its lifecycle.
- format — Optional custom formatter for trace events
- Path — The type representing file paths in the file system

Referenced packages: `ai.koog.agents.core.feature.writer`.

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual class TraceFeatureMessageFileWriter<Path> : <ERROR CLASS> ERROR CLASS: Symbol not found for FeatureMessageFileWriter<Path>
```

A specialized implementation of FeatureMessageFileWriter for tracing and writing feature messages to a target file, with customizable formatting and sink handling.

This class supports writing feature messages to a file using a specified sink opener and an optional formatting function. It serves as an adapter for delegating the core functionality to TraceFeatureMessageFileWriterImpl.

- targetPath — The path where feature messages will be written.
- sinkOpener — A function responsible for opening a Sink for file writing. This function ensures the lifecycle of the sink is properly managed. A default sink opener is available if not provided.
- format — An optional lambda function for customizing the formatting of FeatureMessage instances before writing them to the file. If not provided, a default formatting strategy is used.
### :agents:agents-features:agents-features-trace/nonJvmCommonMain

```kotlin
actual class TraceFeatureMessageFileWriter<Path> : FeatureMessageFileWriter<Path>
```

A specialized implementation of FeatureMessageFileWriter designed for handling trace-related feature messages. This class facilitates writing trace-specific feature messages to a file, supporting custom formatting logic if needed.

- targetPath — The file where feature messages will be written.
- sinkOpener — A lambda function that returns a Sink for writing to the file. The lifecycle of the sink is managed by this class.
- format — An optional lambda function for custom formatting of FeatureMessage instances into their string representations. This can be used to apply specific serialization logic if required. If not provided, the default message trace representation is used.
- Path — The type representing the file path supported by the file system provider.

Referenced packages: `ai.koog.agents.core.feature.writer`.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter.toFileString

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-file-writer/to-file-string.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
expect open override fun FeatureMessage.toFileString(): String
```


Referenced packages: `ai.koog.agents.core.feature.message`.

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual open override fun ERROR CLASS: Symbol not found for FeatureMessage.toFileString(): String
```

### :agents:agents-features:agents-features-trace/nonJvmCommonMain

```kotlin
actual open override fun FeatureMessage.toFileString(): String
```


Referenced packages: `ai.koog.agents.core.feature.message`.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageLogWriter.Companion.create

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-log-writer/-companion/create.html`

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun create(logger: ERROR CLASS: Symbol not found for KLogger, logLevel: ERROR CLASS: Symbol not found for LogLevel = LogLevel.INFO, format: (ERROR CLASS: Symbol not found for FeatureMessage) -> String? = null): TraceFeatureMessageLogWriter
```

Creates a new instance of TraceFeatureMessageLogWriter for handling trace events.

A new instance of TraceFeatureMessageLogWriter.

- logger — The SLF4J-compatible logger (KLogger) used to log trace events.
- logLevel — The logging level to apply for trace events. Defaults to LogLevel.INFO.
- format — An optional custom formatter for converting FeatureMessage objects to log messages. If null, a default formatting strategy is used.
### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun create(logger: ERROR CLASS: Symbol not found for Logger, logLevel: ERROR CLASS: Symbol not found for LogLevel = LogLevel.INFO, format: (ERROR CLASS: Symbol not found for FeatureMessage) -> String? = null): TraceFeatureMessageLogWriter
```

Creates a TraceFeatureMessageLogWriter that writes trace events to the given SLF4J Logger.

A new TraceFeatureMessageLogWriter instance.

- logger — The SLF4J logger to write trace events to.
- logLevel — The log level to use for trace events (default: INFO).
- format — Optional custom formatter for trace events.
## ai.koog.agents.features.tracing.writer.TraceFeatureMessageLogWriter.Companion

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-log-writer/-companion/index.html`

### :agents:agents-features:agents-features-trace/jvmCommonMain

```kotlin
object Companion
```

Companion object with factories for TraceFeatureMessageLogWriter

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageLogWriter.TraceFeatureMessageLogWriter

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-log-writer/-trace-feature-message-log-writer.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
expect constructor(targetLogger: KLogger, logLevel: FeatureMessageLogWriter.LogLevel = LogLevel.INFO, format: (FeatureMessage) -> String? = null)
```

- targetLogger — The logger to write trace events to
- logLevel — The log level to use for trace events (default: INFO)
- format — Optional custom formatter for trace events

Referenced packages: `ai.koog.agents.core.feature.message`, `ai.koog.agents.core.feature.writer`.

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(targetLogger: ERROR CLASS: Symbol not found for KLogger, logLevel: ERROR CLASS: Symbol not found for LogLevel, format: (ERROR CLASS: Symbol not found for FeatureMessage) -> String?)
```

Initializes an instance of TraceFeatureMessageLogWriter.

- targetLogger — The KLogger instance to output trace logs.
- logLevel — The log level used for trace events. Defaults to LogLevel.INFO.
- format — A lambda function for custom formatting of FeatureMessage into a loggable string, or null to use a default format.
### :agents:agents-features:agents-features-trace/nonJvmCommonMain

```kotlin
actual constructor(targetLogger: KLogger, logLevel: FeatureMessageLogWriter.LogLevel, format: (FeatureMessage) -> String?)
```

Creates an instance with the specified logger, log level, and optional message formatter.

- targetLogger — The KLogger instance used for logging feature messages.
- logLevel — The level at which messages will be logged. Defaults to LogLevel.INFO.
- format — An optional lambda used to format FeatureMessage instances into strings for logging. If not provided, a default implementation will be used.

Referenced packages: `ai.koog.agents.core.feature.message`, `ai.koog.agents.core.feature.writer`.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageLogWriter

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-log-writer/index.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
expect class TraceFeatureMessageLogWriter : FeatureMessageLogWriter
```

A message processor that writes trace events to a logger.

This writer captures all trace events and writes them to the specified logger at the configured log level. It formats each event type differently to provide clear and readable logs.

Tracing to logs is particularly useful for:

Integration with existing logging infrastructure

Real-time monitoring of agent behavior

Filtering and searching trace events using log management tools

Example usage:

- targetLogger — The logger to write trace events to
- logLevel — The log level to use for trace events (default: INFO)
- format — Optional custom formatter for trace events

Referenced packages: `ai.koog.agents.core.feature.writer`.

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual class TraceFeatureMessageLogWriter : <ERROR CLASS> ERROR CLASS: Symbol not found for FeatureMessageLogWriter
```

Implementation of FeatureMessageLogWriter that handles logging of feature messages with trace-level detail using a standardized or custom log message format.

- targetLogger — The KLogger instance to output trace logs.
- logLevel — The log level used for trace events. Defaults to LogLevel.INFO.
- format — A lambda function for custom formatting of FeatureMessage into a loggable string, or null to use a default format.
### :agents:agents-features:agents-features-trace/nonJvmCommonMain

```kotlin
actual class TraceFeatureMessageLogWriter : FeatureMessageLogWriter
```

A concrete implementation of FeatureMessageLogWriter that handles logging of feature messages specifically for trace-level operations.

This class utilizes a delegate implementation, TraceFeatureMessageLogWriterImpl, to handle the formatting and processing of messages while maintaining a consistent API.

- targetLogger — The KLogger instance used for logging feature messages.
- logLevel — The level at which messages will be logged. Defaults to LogLevel.INFO.
- format — An optional lambda used to format FeatureMessage instances into strings for logging. If not provided, a default implementation will be used.

Referenced packages: `ai.koog.agents.core.feature.writer`.

## ai.koog.agents.features.tracing.writer.TraceFeatureMessageLogWriter.toLoggerMessage

Module: `agents-features-trace`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-trace/ai.koog.agents.features.tracing.writer/-trace-feature-message-log-writer/to-logger-message.html`

### :agents:agents-features:agents-features-trace/commonMain

```kotlin
expect open override fun FeatureMessage.toLoggerMessage(): String
```


Referenced packages: `ai.koog.agents.core.feature.message`.

### :agents:agents-features:agents-features-trace/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual open override fun ERROR CLASS: Symbol not found for FeatureMessage.toLoggerMessage(): String
```

### :agents:agents-features:agents-features-trace/nonJvmCommonMain

```kotlin
actual open override fun FeatureMessage.toLoggerMessage(): String
```


Referenced packages: `ai.koog.agents.core.feature.message`.
