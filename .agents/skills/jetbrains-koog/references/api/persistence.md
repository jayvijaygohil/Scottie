# Checkpoints, restore, and rollback

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.agent.context.RollbackStrategy.Default

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-rollback-strategy/-default/index.html`

### :agents:agents-core/commonMain

```kotlin
Default
```

Rollback state of the agent to the last saved state in full. Meaning restore the entire context, including message history and any other stateful data.

## ai.koog.agents.core.agent.context.RollbackStrategy.MessageHistoryOnly

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-rollback-strategy/-message-history-only/index.html`

### :agents:agents-core/commonMain

```kotlin
MessageHistoryOnly
```

Rollback only the message history to the last saved state. Agent starts from the first node with saved message history.

## ai.koog.agents.core.agent.context.RollbackStrategy.entries

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-rollback-strategy/entries.html`

### :agents:agents-core/commonMain

```kotlin
val entries: EnumEntries<RollbackStrategy>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.core.agent.context.RollbackStrategy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-rollback-strategy/index.html`

### :agents:agents-core/commonMain

```kotlin
enum RollbackStrategy : Enum<RollbackStrategy>
```

## ai.koog.agents.core.agent.context.RollbackStrategy.valueOf

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-rollback-strategy/value-of.html`

### :agents:agents-core/commonMain

```kotlin
fun valueOf(value: String): RollbackStrategy
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.core.agent.context.RollbackStrategy.values

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/-rollback-strategy/values.html`

### :agents:agents-core/commonMain

```kotlin
fun values(): Array<RollbackStrategy>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.AgentCheckpointData

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/-agent-checkpoint-data.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(checkpointId: String, createdAt: Instant, messageHistory: List<Message>, llmParams: LLMParams? = null, version: Long, graphProperties: GraphCheckpointProperties, properties: JSONObject? = null, llmModel: LLModel? = null, tools: List<String>? = null, storage: JSONObject? = null, agentIterations: Int = 0)
```

Creates an instance of AgentCheckpointData with graph properties.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.serialization`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(checkpointId: String, createdAt: Instant, messageHistory: List<Message>, llmParams: LLMParams? = null, version: Long, plannerProperties: PlannerCheckpointProperties, properties: JSONObject? = null, llmModel: LLModel? = null, tools: List<String>? = null, storage: JSONObject? = null, agentIterations: Int = 0)
```

Creates an instance of AgentCheckpointData with planner properties.


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.message`, `ai.koog.prompt.params`, `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.agentIterations

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/agent-iterations.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val agentIterations: Int
```

## ai.koog.agents.snapshot.feature.AgentCheckpointData.checkpointId

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/checkpoint-id.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val checkpointId: String
```

## ai.koog.agents.snapshot.feature.AgentCheckpointData.createdAt

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/created-at.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val createdAt: Instant
```

## ai.koog.agents.snapshot.feature.AgentCheckpointData.graphProperties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/graph-properties.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val graphProperties: GraphCheckpointProperties?
```

## ai.koog.agents.snapshot.feature.AgentCheckpointData

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
@Serializable(with = AgentCheckpointDataSerializer::class) data class AgentCheckpointData
```

Represents the checkpoint data for an agent's state during a session.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.llmModel

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/llm-model.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val llmModel: LLModel?
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.llmParams

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/llm-params.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val llmParams: LLMParams?
```


Referenced packages: `ai.koog.prompt.params`.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.messageHistory

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/message-history.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val messageHistory: List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.plannerProperties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/planner-properties.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val plannerProperties: PlannerCheckpointProperties?
```

## ai.koog.agents.snapshot.feature.AgentCheckpointData.properties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/properties.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val properties: JSONObject?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.storage

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/storage.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val storage: JSONObject?
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.AgentCheckpointData.tools

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/tools.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val tools: List<String>?
```

## ai.koog.agents.snapshot.feature.AgentCheckpointData.version

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data/version.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val version: Long
```

## ai.koog.agents.snapshot.feature.Persistence.Feature.createInitialConfig

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): PersistenceFeatureConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.snapshot.feature.Persistence.Feature

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/-feature/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
object Feature : AIAgentGraphFeature<PersistenceFeatureConfig, Persistence> , AIAgentPlannerFeature<PersistenceFeatureConfig, Persistence>
```

Companion object implementing agent feature, handling Persistence creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.snapshot.feature.Persistence.Feature.install

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/-feature/install.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open override fun install(config: PersistenceFeatureConfig, pipeline: AIAgentGraphPipeline): Persistence
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open override fun install(config: PersistenceFeatureConfig, pipeline: AIAgentPlannerPipeline): Persistence
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.snapshot.feature.Persistence.Feature.key

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/-feature/key.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open override val key: AIAgentStorageKey<Persistence>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.snapshot.feature.Persistence.Feature.runFromCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/-feature/run-from-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun <Input, Output> runFromCheckpoint(agent: AIAgent<Input, Output>, input: Input, checkpoint: AgentCheckpointData, rollbackStrategy: RollbackStrategy = RollbackStrategy.Default, sessionId: String? = null): Output
```

Runs the agent from a previously saved checkpoint.

Creates a new session and injects the checkpoint data into the session's storage so that the agent's graph strategy restores execution from the checkpoint's position. The Persistence feature does not need to be installed on the agent for this to work.

The output produced by the agent after resuming from the checkpoint.

- agent — The agent to run.
- input — The input to provide to the agent.
- checkpoint — The checkpoint data to restore from.
- rollbackStrategy — The strategy to use when restoring state. Defaults to RollbackStrategy.Default.
- sessionId — Optional session identifier. A random UUID is generated if not provided.

Referenced packages: `ai.koog.agents.core.agent`, `ai.koog.agents.core.agent.context`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun <Input, Output, TContext : AIAgentContext> runFromCheckpoint(session: AIAgentRunSession<Input, Output, TContext>, input: Input, checkpoint: AgentCheckpointData, rollbackStrategy: RollbackStrategy = RollbackStrategy.Default): Output
```

Runs the session from a previously saved checkpoint.

Injects the checkpoint data into the session's storage so that the agent's graph strategy restores execution from the checkpoint's position. The Persistence feature does not need to be installed on the agent for this to work.

The output produced by the session after resuming from the checkpoint.

- session — The session to run.
- input — The input to provide to the session.
- checkpoint — The checkpoint data to restore from.
- rollbackStrategy — The strategy to use when restoring state. Defaults to RollbackStrategy.Default.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.session`.

## ai.koog.agents.snapshot.feature.Persistence.Persistence

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/-persistence.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(persistenceStorageProvider: PersistenceStorageProvider<*>, serializer: JSONSerializer, clock: KoogClock = KoogClock.System)
```


Referenced packages: `ai.koog.agents.snapshot.providers`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.snapshot.feature.Persistence.createCheckpointAfterNode

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/create-checkpoint-after-node.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun createCheckpointAfterNode(agentContext: AIAgentContext, nodePath: String, lastOutput: Any?, lastOutputType: TypeToken, version: Long, checkpointId: String? = null): AgentCheckpointData?
```

Creates a checkpoint of the agent's current state.

This method captures the agent's message history, current node, and input data and stores it as a checkpoint using the configured storage provider.

The created checkpoint data

- agentContext — The context of the agent containing the state to checkpoint
- nodePath — The path to the node where the checkpoint is created
- lastOutput — The latest node output data to include in the checkpoint
- checkpointId — Optional ID for the checkpoint; a random UUID is generated if not provided

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.Persistence.createPlannerCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/create-planner-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun createPlannerCheckpoint(agentContext: AIAgentContext, state: Any, stateType: TypeToken, plan: Any, planType: TypeToken, executionPoint: PlannerAgentExecutionPoint, version: Long, checkpointId: String? = null): AgentCheckpointData?
```

Creates a checkpoint of the agent's current state.

This method captures the agent's message history, current state, and plan.

- agentContext — The context of the agent to checkpoint.
- state — The current state of the agent.
- plan — The current plan of the agent.
- executionPoint — The execution point of the planner agent.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.planner`, `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.Persistence.createTombstoneCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/create-tombstone-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun createTombstoneCheckpoint(runId: String, time: Instant, parentId: Long): AgentCheckpointData
```

Creates and saves a tombstone checkpoint for an agent's session.

A tombstone checkpoint represents a placeholder state with no interactions or messages, marking a terminated or invalid session. The method generates the tombstone checkpoint and persists it using the appropriate storage mechanism.

The created tombstone checkpoint data.

## ai.koog.agents.snapshot.feature.Persistence.getCheckpointById

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/get-checkpoint-by-id.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun getCheckpointById(runId: String, checkpointId: String): AgentCheckpointData?
```

Retrieves a specific checkpoint by ID for the specified agent.

The checkpoint data with the specified ID, or null if not found

- checkpointId — The ID of the checkpoint to retrieve
## ai.koog.agents.snapshot.feature.Persistence.getLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/get-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun getLatestCheckpoint(runId: String): AgentCheckpointData?
```

Retrieves the latest checkpoint for the specified agent.

The latest checkpoint data, or null if no checkpoint exists

## ai.koog.agents.snapshot.feature.Persistence

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
class Persistence(persistenceStorageProvider: PersistenceStorageProvider<*>, serializer: JSONSerializer, clock: KoogClock = KoogClock.System)
```

A feature that provides checkpoint functionality for AI agents.

This class allows saving and restoring the state of an agent at specific points during execution. Checkpoints capture the agent's message history, current node, and input data, enabling:

Resuming agent execution from a specific point

Rolling back to previous states

Persisting agent state across sessions

The feature can be configured to automatically create checkpoints after each node execution using the PersistenceFeatureConfig.enableAutomaticPersistence option.


Referenced packages: `ai.koog.agents.snapshot.providers`, `ai.koog.serialization`, `ai.koog.utils.time`.

## ai.koog.agents.snapshot.feature.Persistence.rollbackStrategy

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/rollback-strategy.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
var rollbackStrategy: RollbackStrategy
```

Determines the strategy to use during rollback operations for the agent's state.

The rollbackStrategy defines the extent of state restoration when rolling back to a previous checkpoint. It impacts which parts of the agent's session data (e.g., message history, context) are restored during a rollback. Available strategies include restoring the full state or limiting restoration to specific parts.

By default, the strategy is set to RollbackStrategy.Default, which restores the entire context of the agent, including message history and other stateful data. Alternative strategies, such as MessageHistoryOnly, can be used for partial rollbacks.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.snapshot.feature.Persistence.rollbackToCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/rollback-to-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun rollbackToCheckpoint(checkpointId: String, agentContext: AIAgentContext): AgentCheckpointData?
```

Rolls back an agent's state to a specific checkpoint.

This method retrieves the checkpoint with the specified ID and, if found, sets the agent's context to the state captured in that checkpoint.

Note: If some of your tools had side-effects and you need to roll back to some older state, please consider providing RollbackToolRegistry. This would only work if you are always trying to rollback BACKWARDS in time!

The checkpoint data that was restored or null if the checkpoint was not found

- checkpointId — The ID of the checkpoint to roll back to
- agentContext — The context of the agent to roll back

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.snapshot.feature.Persistence.rollbackToLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/rollback-to-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun rollbackToLatestCheckpoint(agentContext: AIAgentContext): AgentCheckpointData?
```

Rolls back an agent's state to the latest checkpoint.

This method retrieves the most recent checkpoint for the agent and, if found, sets the agent's context to the state captured in that checkpoint.

The checkpoint data that was restored or null if no checkpoint was found

- agentContext — The context of the agent to roll back

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.snapshot.feature.Persistence.rollbackToolRegistry

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/rollback-tool-registry.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
var rollbackToolRegistry: RollbackToolRegistry
```

A registry for managing rollback tools within the persistence system.

The rollbackToolRegistry plays a key role in supporting the rollback mechanism in the persistence operations, allowing seamless state restoration for tools with side-effects to specified or latest checkpoints as needed.

## ai.koog.agents.snapshot.feature.Persistence.saveCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/save-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun saveCheckpoint(runId: String, checkpointData: AgentCheckpointData)
```

Saves a checkpoint using the configured storage provider.

- checkpointData — The checkpoint data to save
## ai.koog.agents.snapshot.feature.Persistence.setExecutionPointAfterNode

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence/set-execution-point-after-node.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun setExecutionPointAfterNode(agentContext: AIAgentContext, nodePath: String, messageHistory: List<Message>, output: JSONElement)
```

Sets the execution point of an agent to a specified state.

This method updates the agent's context to start execution from a specific point in its graph, using the provided message history and finished node output data.

- agentContext — The context of the agent to modify.
- nodePath — The path to the node inside the agent's graph where execution will begin.
- messageHistory — The sequence of messages representing the agent's prior interactions.
- output — The output data to associate with the specified execution point.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.message`, `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.PersistenceFeatureConfig.PersistenceFeatureConfig

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence-feature-config/-persistence-feature-config.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor()
```

## ai.koog.agents.snapshot.feature.PersistenceFeatureConfig.enableAutomaticPersistence

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence-feature-config/enable-automatic-persistence.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
var enableAutomaticPersistence: Boolean
```

Controls whether the feature's state should be automatically persisted. When enabled, changes to the checkpoint are saved after each node execution through the assigned PersistenceStorageProvider, ensuring the state can be restored later.

Set this property to true to turn on automatic state persistence, or false to disable it.

## ai.koog.agents.snapshot.feature.PersistenceFeatureConfig

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence-feature-config/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
class PersistenceFeatureConfig : FeatureConfig
```

Configuration class for the Snapshot feature.


Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.snapshot.feature.PersistenceFeatureConfig.rollbackToolRegistry

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence-feature-config/rollback-tool-registry.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
var rollbackToolRegistry: RollbackToolRegistry
```

Registry for rollback tools used when rolling back to checkpoints. Configure it during Persistence installation. Do not mutate later in withPersistence.

## ai.koog.agents.snapshot.feature.PersistenceFeatureConfig.storage

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-persistence-feature-config/storage.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
var storage: PersistenceStorageProvider<*>
```

Defines the storage mechanism for persisting snapshots in the feature. This property accepts implementations of PersistenceStorageProvider, which manage how snapshots are stored and retrieved.

By default, the storage is set to NoPersistencyStorageProvider, a no-op implementation that does not persist any data. To enable actual state persistence, assign a custom implementation of PersistenceStorageProvider to this property.


Referenced packages: `ai.koog.agents.snapshot.providers`.

## ai.koog.agents.snapshot.feature.persistence

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/persistence.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun AIAgentContext.persistence(): Persistence
```

Extension function to access the checkpoint feature from an agent context.

The Persistence feature instance for this agent

- IllegalStateException — if the checkpoint feature is not installed

Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun <Input, Output, TContext : AIAgentContext> AIAgentRunSession<Input, Output, TContext>.persistence(): Persistence
```

Extension function to access the checkpoint feature from a session.

The Persistence feature instance for this session

- IllegalStateException — if the checkpoint feature is not installed

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.session`.

## ai.koog.agents.snapshot.feature.withPersistence

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/with-persistence.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun <T> AIAgentContext.withPersistence(action: suspend Persistence.(AIAgentContext) -> T): T
```

Executes the provided action within the context of the AI agent's persistence layer.

This function enhances agents with persistent state management capabilities by leveraging the [Persistence component within the current AIAgentContext. The supplied action is executed with the persistence layer, enabling operations that require consistent and reliable state management across the lifecycle of the agent.

A result of type T produced by the execution of the provided action.

- action — A suspendable lambda function that receives the Persistence instance and the current AIAgentContext as its parameters. This allows custom logic that interacts with the persistence layer to be executed.

Referenced packages: `ai.koog.agents.core.agent.context`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun <Input, Output, TContext : AIAgentContext, T> AIAgentRunSession<Input, Output, TContext>.withPersistence(action: suspend Persistence.(AIAgentContext) -> T): T
```

Executes the provided action within the context of the session's persistence layer if the session is in a running state.

This function allows interaction with the persistence mechanism associated with the session, ensuring that the operation is carried out in the correct execution context.

The result of the execution of the provided action.

- action — A suspending function defining operations to perform using the session's persistence mechanism and the current agent context.
- IllegalStateException — If the session is not in a running state when this function is called.

Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.agents.core.agent.session`.

## ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider.InMemoryPersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-in-memory-persistence-storage-provider/-in-memory-persistence-storage-provider.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor()
```

## ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider.getCheckpoints

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-in-memory-persistence-storage-provider/get-checkpoints.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun getCheckpoints(sessionId: String, filter: AgentCheckpointPredicateFilter?): List<AgentCheckpointData>
```

Retrieves the list of checkpoints of the AI agent with the given sessionId that match the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`, `ai.koog.agents.snapshot.providers.filters`.

## ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider.getLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-in-memory-persistence-storage-provider/get-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun getLatestCheckpoint(sessionId: String, filter: AgentCheckpointPredicateFilter?): AgentCheckpointData?
```

Retrieves the latest checkpoint of the AI agent with sessionId matching the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`, `ai.koog.agents.snapshot.providers.filters`.

## ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-in-memory-persistence-storage-provider/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
class InMemoryPersistenceStorageProvider : PersistenceStorageProvider<AgentCheckpointPredicateFilter>
```

In-memory implementation of PersistenceStorageProvider. This provider stores snapshots in a mutable map.


Referenced packages: `ai.koog.agents.snapshot.providers.filters`.

## ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider.removeCheckpoints

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-in-memory-persistence-storage-provider/remove-checkpoints.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
suspend fun removeCheckpoints(filter: AgentCheckpointPredicateFilter? = null)
```

Removes all stored checkpoints from the in-memory storage. If a filter is provided, this method will determine which checkpoints to remove based on the filter's logic.

- filter — Optional filter to determine whether any checkpoints should be removed conditionally. If null, all checkpoints will be removed unconditionally.

Referenced packages: `ai.koog.agents.snapshot.providers.filters`.

## ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider.saveCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-in-memory-persistence-storage-provider/save-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun saveCheckpoint(sessionId: String, agentCheckpointData: AgentCheckpointData)
```

Saves provided checkpoint (agentCheckpointData) of the agent with sessionId to the storage (ex: database, S3, file)


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.PersistenceStorageProvider.getCheckpoints

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-storage-provider/get-checkpoints.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend fun getCheckpoints(sessionId: String): List<AgentCheckpointData>
```

Retrieves the list of checkpoints of the AI agent with the given sessionId


Referenced packages: `ai.koog.agents.snapshot.feature`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
abstract suspend fun getCheckpoints(sessionId: String, filter: Filter?): List<AgentCheckpointData>
```

Retrieves the list of checkpoints of the AI agent with the given sessionId that match the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.PersistenceStorageProvider.getLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-storage-provider/get-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend fun getLatestCheckpoint(sessionId: String): AgentCheckpointData?
```

Retrieves the latest checkpoint of the AI agent with sessionId


Referenced packages: `ai.koog.agents.snapshot.feature`.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
abstract suspend fun getLatestCheckpoint(sessionId: String, filter: Filter?): AgentCheckpointData?
```

Retrieves the latest checkpoint of the AI agent with sessionId matching the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.PersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-storage-provider/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
interface PersistenceStorageProvider<Filter>
```

Storage provider (ex: database, S3, file) to be used in ai.koog.agents.snapshot.feature.Persistence feature.

- InMemoryPersistenceStorageProvider
- NoPersistencyStorageProvider
- FilePersistenceStorageProvider
- AsyncPersistenceStorageProvider
## ai.koog.agents.snapshot.providers.PersistenceStorageProvider.saveCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-storage-provider/save-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
abstract suspend fun saveCheckpoint(sessionId: String, agentCheckpointData: AgentCheckpointData)
```

Saves provided checkpoint (agentCheckpointData) of the agent with sessionId to the storage (ex: database, S3, file)


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.file.FilePersistenceStorageProvider.FilePersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-file-persistence-storage-provider/-file-persistence-storage-provider.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(fs: FileSystemProvider.ReadWrite<Path>, root: Path, json: Json = PersistenceUtils.defaultCheckpointJson)
```

- fs — A file system provider enabling read and write operations for file storage.
- root — Root file path where the checkpoint storage will organize data.
- Path — Type representing the file path in the storage system.

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.agents.snapshot.providers.file.FilePersistenceStorageProvider.getCheckpoints

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-file-persistence-storage-provider/get-checkpoints.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun getCheckpoints(sessionId: String, filter: AgentCheckpointPredicateFilter?): List<AgentCheckpointData>
```

Retrieves the list of checkpoints of the AI agent with the given sessionId that match the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`, `ai.koog.agents.snapshot.providers.filters`.

## ai.koog.agents.snapshot.providers.file.FilePersistenceStorageProvider.getLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-file-persistence-storage-provider/get-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun getLatestCheckpoint(sessionId: String, filter: AgentCheckpointPredicateFilter?): AgentCheckpointData?
```

Retrieves the latest checkpoint of the AI agent with sessionId matching the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`, `ai.koog.agents.snapshot.providers.filters`.

## ai.koog.agents.snapshot.providers.file.FilePersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-file-persistence-storage-provider/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open class FilePersistenceStorageProvider<Path> constructor(fs: FileSystemProvider.ReadWrite<Path>, root: Path, json: Json = PersistenceUtils.defaultCheckpointJson) : PersistenceStorageProvider<AgentCheckpointPredicateFilter>
```

A file-based implementation of PersistenceStorageProvider that stores agent checkpoints in a file system.

This implementation organizes checkpoints by agent ID and uses JSON serialization for storing and retrieving checkpoint data. It relies on FileSystemProvider.ReadWrite for file system operations.

- fs — A file system provider enabling read and write operations for file storage.
- root — Root file path where the checkpoint storage will organize data.
- Path — Type representing the file path in the storage system.
- JVMFilePersistenceStorageProvider

Referenced packages: `ai.koog.agents.snapshot.providers`, `ai.koog.agents.snapshot.providers.filters`, `ai.koog.rag.base.files`.

## ai.koog.agents.snapshot.providers.file.FilePersistenceStorageProvider.saveCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-file-persistence-storage-provider/save-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun saveCheckpoint(sessionId: String, agentCheckpointData: AgentCheckpointData)
```

Saves provided checkpoint (agentCheckpointData) of the agent with sessionId to the storage (ex: database, S3, file)


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.file.JVMFilePersistenceStorageProvider.JVMFilePersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-j-v-m-file-persistence-storage-provider/-j-v-m-file-persistence-storage-provider.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
constructor(root: Path, json: Json = PersistenceUtils.defaultCheckpointJson)
```

Initializes the JVMFilePersistenceStorageProvider with a specified root directory root.

- root — The root directory where all agent checkpoints will be stored.
## ai.koog.agents.snapshot.providers.file.JVMFilePersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.file/-j-v-m-file-persistence-storage-provider/index.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
class JVMFilePersistenceStorageProvider constructor(root: Path, json: Json = PersistenceUtils.defaultCheckpointJson) : FilePersistenceStorageProvider<Path>
```

A JVM-specific implementation of FilePersistenceStorageProvider for managing agent checkpoints in a file system.

This class utilizes JVM's Path for file system operations and JVMFileSystemProvider.ReadWrite for file system access. It organizes checkpoints by agent ID in a structured directory format under the specified root directory.

Use this class to persistently store and retrieve agent checkpoints to and from a file-based system in JVM environments.

- root — The root directory where all agent checkpoints will be stored.
## ai.koog.agents.snapshot.feature.GraphCheckpointProperties.GraphCheckpointProperties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-graph-checkpoint-properties/-graph-checkpoint-properties.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(nodePath: String, lastOutput: JSONElement = JSONNull)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.GraphCheckpointProperties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-graph-checkpoint-properties/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
@Serializable data class GraphCheckpointProperties(val nodePath: String, val lastOutput: JSONElement = JSONNull)
```

Specialized data for graph-based agents, including execution path and output state.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.GraphCheckpointProperties.lastOutput

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-graph-checkpoint-properties/last-output.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val lastOutput: JSONElement
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.GraphCheckpointProperties.nodePath

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-graph-checkpoint-properties/node-path.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val nodePath: String
```

## ai.koog.agents.snapshot.feature.PlannerCheckpointProperties.PlannerCheckpointProperties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-planner-checkpoint-properties/-planner-checkpoint-properties.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(executionPoint: PlannerAgentExecutionPoint, state: JSONElement, plan: JSONElement)
```


Referenced packages: `ai.koog.agents.core.planner`, `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.PlannerCheckpointProperties.executionPoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-planner-checkpoint-properties/execution-point.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val executionPoint: PlannerAgentExecutionPoint
```


Referenced packages: `ai.koog.agents.core.planner`.

## ai.koog.agents.snapshot.feature.PlannerCheckpointProperties

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-planner-checkpoint-properties/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
@Serializable data class PlannerCheckpointProperties(val executionPoint: PlannerAgentExecutionPoint, val state: JSONElement, val plan: JSONElement)
```

Specialized data for planner agents, capturing state, plan, and current execution point.


Referenced packages: `ai.koog.agents.core.planner`, `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.PlannerCheckpointProperties.plan

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-planner-checkpoint-properties/plan.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val plan: JSONElement
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.snapshot.feature.PlannerCheckpointProperties.state

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-planner-checkpoint-properties/state.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val state: JSONElement
```


Referenced packages: `ai.koog.serialization`.
