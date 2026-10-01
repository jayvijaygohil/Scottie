# agents / agents-features / agents-features-snapshot

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.snapshot.feature.AgentCheckpointDataSerializer

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data-serializer/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
object AgentCheckpointDataSerializer : JsonTransformingSerializer<AgentCheckpointData>
```

Custom serializer for AgentCheckpointData that adds backward compatibility with the pre-refactoring format, where AgentCheckpointData.nodePath, AgentCheckpointData.lastInput, and AgentCheckpointData.lastOutput were top-level fields instead of entries in AgentCheckpointData.properties.

Old format: { "checkpointId": ..., "nodePath": "x", "lastOutput": "y", "messageHistory": [...], ... } New format: { "checkpointId": ..., "messageHistory": [...], "properties": { "nodePath": "x", "lastOutput": "y", ... }, ... }

## ai.koog.agents.snapshot.feature.AgentCheckpointDataSerializer.isOldFormat

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-agent-checkpoint-data-serializer/is-old-format.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun isOldFormat(jsonString: String): Boolean
```

Returns true if jsonString was produced by the old AgentCheckpointData format, where nodePath, lastInput, and lastOutput appeared as top-level JSON fields.

## ai.koog.agents.snapshot.feature.Reverts

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-reverts/index.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
annotation class Reverts
```

Annotation used to mark a method that serves as a rollback or revert tool for a specified primary tool. This annotation provides a mapping between a primary tool name and its corresponding rollback tool. The annotated method can be retrieved dynamically at runtime for performing rollback operations associated with tools defined in a specified ToolSet.

## ai.koog.agents.snapshot.feature.Reverts.toolName

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-reverts/tool-name.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
abstract fun toolName(): String
```

## ai.koog.agents.snapshot.feature.Reverts.toolSet

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-reverts/tool-set.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
abstract fun toolSet(): Class<out ToolSet>
```


Referenced packages: `ai.koog.agents.core.tools.reflect`.

## ai.koog.agents.snapshot.feature.RollbackToolRegistry.Companion.EMPTY

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/-companion/-e-m-p-t-y.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val EMPTY: RollbackToolRegistry
```

Represents an empty instance of the RollbackToolRegistry.

This constant provides a default, immutable RollbackToolRegistry with no registered tools. It can be used as a placeholder or a base instance when no rollback tools are required.

## ai.koog.agents.snapshot.feature.RollbackToolRegistry.Companion.builder

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/-companion/builder.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun builder(): RollbackToolRegistryBuilder
```

Returns a RollbackToolRegistryBuilder for ai.koog.agents.snapshot.feature.RollbackToolRegistry

## ai.koog.agents.snapshot.feature.RollbackToolRegistry.Companion

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/-companion/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
object Companion
```

Companion object for the RollbackToolRegistry class. Provides utility methods and predefined registry instances.

## ai.koog.agents.snapshot.feature.RollbackToolRegistry.RollbackToolRegistry

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/-rollback-tool-registry.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor(init: RollbackToolRegistryBuilder.() -> Unit)
```

Creates a new RollbackToolRegistry using the provided builder initialization block.

- init — A lambda that configures the registry by adding rollback tools
## ai.koog.agents.snapshot.feature.RollbackToolRegistry.add

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/add.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun <TArgs> add(tool: Tool<TArgs, *>, rollbackTool: Tool<TArgs, *>)
```

Adds a tool and its corresponding rollback tool to the registry. If the tool is already present in the registry, the method does nothing.

- tool — the tool to add to the registry
- rollbackTool — the rollback tool associated with the specified tool

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.snapshot.feature.RollbackToolRegistry.getRollbackTool

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/get-rollback-tool.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun getRollbackTool(toolName: String): Tool<*, *>?
```

Retrieves a rollback tool by its name.

The rollback tool associated with the given name.

- toolName — The name of the tool to retrieve.
- IllegalArgumentException — If no tool with the specified name is defined.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.snapshot.feature.RollbackToolRegistry

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
class RollbackToolRegistry
```

A registry for managing and retrieving rollback tools associated with specific tools. This class allows for the association of tools that have rollback counterparts and provides mechanisms for retrieval and addition of such tools.

This class is immutable from an external perspective, ensuring thread safety.

## ai.koog.agents.snapshot.feature.RollbackToolRegistry.plus

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/plus.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
operator fun plus(rollbackToolRegistry: RollbackToolRegistry): RollbackToolRegistry
```

Combines the rollback tools from the current RollbackToolRegistry instance and the specified rollbackToolRegistry into a new RollbackToolRegistry.

A new RollbackToolRegistry containing the combined rollback tools from both instances.

- rollbackToolRegistry — The other RollbackToolRegistry whose rollback tools will be combined with the current instance.
## ai.koog.agents.snapshot.feature.RollbackToolRegistry.rollbackToolsMap

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry/rollback-tools-map.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val rollbackToolsMap: Map<Tool<*, *>, Tool<*, *>>
```

A public property representing a map of tools and their corresponding rollback tools.

This property provides a read-only view of the internal rollback tools mapping, allowing retrieval of paired tools that facilitate rollback operations. The keys in this map are tools, and the values are their associated rollback tools.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilder.RollbackToolRegistryBuilder

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder/-rollback-tool-registry-builder.html`

### :agents:agents-features:agents-features-snapshot/androidMain

```kotlin
actual constructor()
```

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
expect constructor()
```

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
actual constructor()
```

### :agents:agents-features:agents-features-snapshot/nonJvmCommonMain

```kotlin
actual constructor()
```

## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilder

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder/index.html`

### :agents:agents-features:agents-features-snapshot/androidMain

```kotlin
actual open class RollbackToolRegistryBuilder : RollbackToolRegistryBuilderCommon<RollbackToolRegistryBuilder>
```

A builder class responsible for creating a RollbackToolRegistry while managing associations between tools and their corresponding rollback tools.

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
expect open class RollbackToolRegistryBuilder : RollbackToolRegistryBuilderCommon<RollbackToolRegistryBuilder>
```

A builder class responsible for creating a RollbackToolRegistry while managing associations between tools and their corresponding rollback tools.

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
actual open class RollbackToolRegistryBuilder : RollbackToolRegistryBuilderCommon<RollbackToolRegistryBuilder>
```

A builder class responsible for creating a RollbackToolRegistry while managing associations between tools and their corresponding rollback tools.

### :agents:agents-features:agents-features-snapshot/nonJvmCommonMain

```kotlin
actual open class RollbackToolRegistryBuilder : RollbackToolRegistryBuilderCommon<RollbackToolRegistryBuilder>
```

A builder class responsible for creating a RollbackToolRegistry while managing associations between tools and their corresponding rollback tools.

## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilder.registerRollback

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder/register-rollback.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
fun registerRollback(toolFunction: KFunction<*>, rollbackToolFunction: KFunction<*>): RollbackToolRegistryBuilder
```

Registers a relationship between a tool and its corresponding rollback tool using the specified functions.

- toolFunction — The function representing the primary tool to register.
- rollbackToolFunction — The function representing the rollback counterpart to the primary tool.
## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilder.registerRollbacks

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder/register-rollbacks.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
fun registerRollbacks(toolSet: ToolSet, rollbackToolSet: RollbackToolSet): RollbackToolRegistryBuilder
```

Registers relationships between tools in the given tool set and their corresponding rollback tools in the rollback tool set.

- toolSet — The set of tools to register, each of which represents a primary tool.
- rollbackToolSet — The set of rollback tools that correspond to the tools in the provided tool set.

Referenced packages: `ai.koog.agents.core.tools.reflect`.

## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilderCommon.build

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder-common/build.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open fun build(): RollbackToolRegistry
```

Builds and returns an instance of RollbackToolRegistry initialized with the registered rollback tools.

A RollbackToolRegistry instance containing the registered tools and their corresponding rollback tools.

## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilderCommon

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder-common/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
abstract class RollbackToolRegistryBuilderCommon<Self : RollbackToolRegistryBuilderCommon<Self>>
```

API for RollbackToolRegistryBuilder

- RollbackToolRegistryBuilder
## ai.koog.agents.snapshot.feature.RollbackToolRegistryBuilderCommon.registerRollback

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-registry-builder-common/register-rollback.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open fun <TArgs> registerRollback(tool: Tool<TArgs, *>, rollbackTool: Tool<TArgs, *>): Self
```

Registers a rollback relationship between the provided tool and its corresponding rollback tool. Ensures that the tool is not already defined in the rollback tools map.

- tool — The primary tool to register.
- rollbackTool — The tool that acts as the rollback counterpart to the provided tool.
- IllegalArgumentException — If the tool is already defined in the rollbackToolsMap.

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.snapshot.feature.RollbackToolSet

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-set/index.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
interface RollbackToolSet
```

Represents a set of tools that can perform rollback or reversal operations for a given tool and toolset. This interface provides a mechanism to locate and retrieve tools that revert specific operations.

## ai.koog.agents.snapshot.feature.RollbackToolSet.revertToolFor

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/-rollback-tool-set/revert-tool-for.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
open fun revertToolFor(toolName: String, toolSet: ToolSet): ToolFromCallable<*>?
```

A tool that reverts the specified tool if found, or null if no matching tool is located.

- toolName — The name of the tool to be reverted.
- toolSet — The toolset associated with the tool to be reverted.

Referenced packages: `ai.koog.agents.core.tools.reflect`.

## ai.koog.agents.snapshot.feature.add

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/add.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
fun RollbackToolRegistry.add(toolFunction: KFunction<*>, rollbackToolFunction: KFunction<*>)
```

Adds a tool and its corresponding rollback tool to the registry. This convenience method converts both toolFunction and rollbackToolFunction into Tool objects before adding them.

- toolFunction — The Kotlin function representing the primary tool to add.
- rollbackToolFunction — The Kotlin function representing the rollback tool associated with the primary tool.
## ai.koog.agents.snapshot.feature.isTombstone

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/is-tombstone.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun AgentCheckpointData.isTombstone(): Boolean
```

Checks whether the AgentCheckpointData instance is marked as a tombstone.

## ai.koog.agents.snapshot.feature.serializeInput

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/serialize-input.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
inline fun <T> serializeInput(input: T?): String?
```

## ai.koog.agents.snapshot.feature.toAgentContextData

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/to-agent-context-data.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun AgentCheckpointData.toAgentContextData(rollbackStrategy: RollbackStrategy, additionalRollbackActions: suspend (AIAgentContext) -> Unit = {}): AgentContextData?
```

Converts an instance of AgentCheckpointData to AgentContextData.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.snapshot.feature.tombstoneCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.feature/tombstone-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
fun tombstoneCheckpoint(createdAt: Instant, version: Long): AgentCheckpointData
```

Creates a tombstone checkpoint for an agent's session.

## ai.koog.agents.snapshot.providers.AsyncPersistenceStorageProvider.AsyncPersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-async-persistence-storage-provider/-async-persistence-storage-provider.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
constructor()
```

## ai.koog.agents.snapshot.providers.AsyncPersistenceStorageProvider.getCheckpoints

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-async-persistence-storage-provider/get-checkpoints.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
suspend override fun getCheckpoints(sessionId: String, filter: Filter?): List<AgentCheckpointData>
```

Retrieves the list of checkpoints of the AI agent with the given sessionId that match the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.AsyncPersistenceStorageProvider.getLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-async-persistence-storage-provider/get-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
suspend override fun getLatestCheckpoint(sessionId: String, filter: Filter?): AgentCheckpointData?
```

Retrieves the latest checkpoint of the AI agent with sessionId matching the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.AsyncPersistenceStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-async-persistence-storage-provider/index.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
abstract class AsyncPersistenceStorageProvider<Filter> : PersistenceStorageProvider<Filter>
```

Storage provider (ex: database, S3, file) to be used in ai.koog.agents.snapshot.feature.Persistence feature.

## ai.koog.agents.snapshot.providers.AsyncPersistenceStorageProvider.saveCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-async-persistence-storage-provider/save-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/jvmMain

```kotlin
suspend override fun saveCheckpoint(sessionId: String, agentCheckpointData: AgentCheckpointData)
```

Saves provided checkpoint (agentCheckpointData) of the agent with sessionId to the storage (ex: database, S3, file)


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.NoPersistencyStorageProvider.NoPersistencyStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-no-persistency-storage-provider/-no-persistency-storage-provider.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
constructor()
```

## ai.koog.agents.snapshot.providers.NoPersistencyStorageProvider.getCheckpoints

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-no-persistency-storage-provider/get-checkpoints.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun getCheckpoints(sessionId: String, filter: Unit?): List<AgentCheckpointData>
```

Retrieves the list of checkpoints of the AI agent with the given sessionId that match the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.NoPersistencyStorageProvider.getLatestCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-no-persistency-storage-provider/get-latest-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun getLatestCheckpoint(sessionId: String, filter: Unit?): AgentCheckpointData?
```

Retrieves the latest checkpoint of the AI agent with sessionId matching the provided filter


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.NoPersistencyStorageProvider

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-no-persistency-storage-provider/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
class NoPersistencyStorageProvider : PersistenceStorageProvider<Unit>
```

No-op implementation of PersistenceStorageProvider.

## ai.koog.agents.snapshot.providers.NoPersistencyStorageProvider.saveCheckpoint

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-no-persistency-storage-provider/save-checkpoint.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
open suspend override fun saveCheckpoint(sessionId: String, agentCheckpointData: AgentCheckpointData)
```

Saves provided checkpoint (agentCheckpointData) of the agent with sessionId to the storage (ex: database, S3, file)


Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.PersistenceUtils.TOMBSTONE_CHECKPOINT_NAME

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-utils/-t-o-m-b-s-t-o-n-e_-c-h-e-c-k-p-o-i-n-t_-n-a-m-e.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
const val TOMBSTONE_CHECKPOINT_NAME: String
```

The name used to identify tombstone checkpoints.

Tombstone checkpoints are special markers indicating that an agent's session has been terminated or is no longer valid. This constant helps in recognizing such checkpoints during retrieval and processing.

## ai.koog.agents.snapshot.providers.PersistenceUtils.defaultCheckpointJson

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-utils/default-checkpoint-json.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
val defaultCheckpointJson: Json
```

A preconfigured JSON instance for handling serialization and deserialization of checkpoint data.

This configuration aims to provide flexibility and readability by:

Enabling pretty printing of JSON for easier debugging and inspection.

Permitting deserialization of JSON with unknown keys, ensuring compatibility with extended or updated data structures.

Disabling explicit null representation in serialized JSON, resulting in more concise outputs.

## ai.koog.agents.snapshot.providers.PersistenceUtils

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers/-persistence-utils/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
object PersistenceUtils
```

Utility object containing configurations and utilities for handling persistence-related operations.

## ai.koog.agents.snapshot.providers.filters.AgentCheckpointPredicateFilter.check

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.filters/-agent-checkpoint-predicate-filter/check.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
abstract fun check(checkpointData: AgentCheckpointData): Boolean
```

Evaluates whether the provided agent checkpoint data meets the defined conditions.

true if the checkpoint data satisfies the conditions, false otherwise.

- checkpointData — The data associated with the agent's checkpoint, which includes state information such as message history, node details, and properties.

Referenced packages: `ai.koog.agents.snapshot.feature`.

## ai.koog.agents.snapshot.providers.filters.AgentCheckpointPredicateFilter

Module: `agents-features-snapshot`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-snapshot/ai.koog.agents.snapshot.providers.filters/-agent-checkpoint-predicate-filter/index.html`

### :agents:agents-features:agents-features-snapshot/commonMain

```kotlin
interface AgentCheckpointPredicateFilter
```

Interface for defining predicates to filter agent checkpoint data.

Implementations of this interface are utilized in storage providers to determine whether specific agent checkpoints meet given conditions. This allows for selective retrieval and processing of checkpoints based on custom logic, such as filtering by node, time, or specific checkpoint properties.
