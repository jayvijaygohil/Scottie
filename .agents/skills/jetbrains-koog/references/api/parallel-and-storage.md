# Parallel branches and agent storage

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.core.agent.context.agentInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/agent-input.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> AIAgentContext.agentInput(): T
```

Utility function to get AIAgentContext.agentInput and try to cast it to some expected type.

- ClassCastException — If agent input can't be cast to T
## ai.koog.agents.core.agent.context.store

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/store.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun AIAgentContext.store(data: AgentContextData)
```

Stores the given agent context data within the current AI agent context.

- data — The context-specific data to be stored for later retrieval or use within the agent context.
## ai.koog.agents.core.agent.context.with

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.context/with.html`

### :agents:agents-core/commonMain

```kotlin
inline fun <T> AIAgentContext.with(executionInfo: AgentExecutionInfo, block: (executionInfo: AgentExecutionInfo, eventId: String) -> T): T
```

Executes a block of code with a modified execution context.

The result of executing the provided block.

- executionInfo — The execution info to be set for the context.
- block — The suspend function to execute with the modified execution context.
- T — The return type of the block being executed.

Referenced packages: `ai.koog.agents.core.agent.execution`.

### :agents:agents-core/commonMain

```kotlin
inline fun <T> AIAgentContext.with(partName: String, block: (executionInfo: AgentExecutionInfo, eventId: String) -> T): T
```

Executes a block of code with a modified execution context, creating a parent-child relationship between execution contexts for tracing purposes.

The result of executing the provided block.

- partName — The name of the execution part to append to the execution path.
- block — The suspend function to execute with the modified execution context.
- T — The return type of the block being executed.

Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.agent.entity.AIAgentStorage.AIAgentStorage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/-a-i-agent-storage.html`

### :agents:agents-core/commonMain

```kotlin
expect constructor(serializer: JSONSerializer)
```

Creates an instance of AIAgentStorage.

- serializer — The JSONSerializer used to handle serialization and deserialization of stored values.

Referenced packages: `ai.koog.serialization`.

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
actual constructor(serializer: ERROR CLASS: Symbol not found for JSONSerializer)
```

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual constructor(serializer: JSONSerializer)
```

Creates an instance of AIAgentStorage.

- serializer — The JSONSerializer used to handle serialization and deserialization of stored values.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorage.Companion.createStorageKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/-companion/create-storage-key.html`

### :agents:agents-core/jvmCommonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
fun <T : Any> createStorageKey(name: String, typeToken: ERROR CLASS: Symbol not found for TypeToken): AIAgentStorageKey<T>
```

Creates a storage key for a specific type, allowing identification and retrieval of values associated with it.

- name — The name of the storage key, used to uniquely identify it.
- typeToken — Type of the value stored under this key.
## ai.koog.agents.core.agent.entity.AIAgentStorage.Companion

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/-companion/index.html`

### :agents:agents-core/jvmCommonMain

```kotlin
object Companion
```

## ai.koog.agents.core.agent.entity.AIAgentStorage.clear

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/clear.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun clear()
```

Clears all data from the storage.

## ai.koog.agents.core.agent.entity.AIAgentStorage.getValue

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/get-value.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun <T : Any> getValue(key: AIAgentStorageKey<T>): T
```

Retrieves the non-null value associated with the given key from the storage. If the key does not exist in the storage, a NoSuchElementException is thrown.

The value associated with the key, of type T.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
- NoSuchElementException — if the key does not exist in the storage.
## ai.koog.agents.core.agent.entity.AIAgentStorage.get

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/get.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun <T : Any> get(key: AIAgentStorageKey<T>): T?
```

Retrieves the value associated with the given key from the storage.

The value associated with the key, cast to type T, or null if the key does not exist.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
## ai.koog.agents.core.agent.entity.AIAgentStorage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/index.html`

### :agents:agents-core/commonMain

```kotlin
expect class AIAgentStorage : AIAgentStorageAPI
```

Concurrent-safe key-value storage for an agent. You can create typed keys for your data using the createStorageKey function and set and retrieve data using it by calling set and get.

### :agents:agents-core/jvmCommonMain

```kotlin
actual class AIAgentStorage : AIAgentStorageAPI
```

Concurrent-safe key-value storage for an agent. You can create typed keys for your data using the createStorageKey function and set and retrieve data using it by calling set and get.

### :agents:agents-core/nonJvmCommonMain

```kotlin
actual class AIAgentStorage : AIAgentStorageAPI
```

Concurrent-safe key-value storage for an agent. You can create typed keys for your data using the createStorageKey function and set and retrieve data using it by calling set and get.

## ai.koog.agents.core.agent.entity.AIAgentStorage.putAllSerialized

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/put-all-serialized.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun putAllSerialized(map: Map<String, JSONElement>)
```

Adds serialized storage entries from the given map.

Each map key is treated as an AIAgentStorageKey.name. Later calls to methods like get will match entries by that key name.

- map — serialized values keyed by storage key name.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorage.putAll

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/put-all.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun putAll(map: Map<AIAgentStorageKey<*>, Any>)
```

Adds all key-value pairs from the given map to the storage.

- map — A map containing keys of type AIAgentStorageKey and their associated values of type Any. The keys and values in the provided map will be added to the storage.
### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun putAll(other: AIAgentStorage)
```

Puts the contents of the other storage instance into the current storage. This method combines key-value pairs from the specified storage with the current one. If a key exists in both storages, the value from the given storage will overwrite the existing value.

- other — The AIAgentStorage instance whose key-value pairs should be merged into the current storage.
## ai.koog.agents.core.agent.entity.AIAgentStorage.remove

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/remove.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun <T : Any> remove(key: AIAgentStorageKey<T>): T?
```

Removes the value associated with the given key from the storage.

The value associated with the key, cast to type T, or null if the key does not exist.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
## ai.koog.agents.core.agent.entity.AIAgentStorage.set

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/set.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun <T : Any> set(key: AIAgentStorageKey<T>, value: T)
```

Sets the value associated with the given key in the storage.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
- value — The value to be associated with the key.
## ai.koog.agents.core.agent.entity.AIAgentStorage.toSerializedMap

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage/to-serialized-map.html`

### :agents:agents-core/commonMain

```kotlin
expect open suspend override fun toSerializedMap(): Map<String, JSONElement>
```

Returns serialized storage entries keyed by AIAgentStorageKey.name.

Entries whose values cannot be serialized are omitted.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.clear

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/clear.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun clear()
```

Clears all data from the storage.

## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.getValue

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/get-value.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun <T : Any> getValue(key: AIAgentStorageKey<T>): T
```

Retrieves the non-null value associated with the given key from the storage. If the key does not exist in the storage, a NoSuchElementException is thrown.

The value associated with the key, of type T.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
- NoSuchElementException — if the key does not exist in the storage.
## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.get

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/get.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun <T : Any> get(key: AIAgentStorageKey<T>): T?
```

Retrieves the value associated with the given key from the storage.

The value associated with the key, cast to type T, or null if the key does not exist.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
## ai.koog.agents.core.agent.entity.AIAgentStorageAPI

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/index.html`

### :agents:agents-core/commonMain

```kotlin
interface AIAgentStorageAPI
```

API for AIAgentStorage

- AIAgentStorage
## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.putAllSerialized

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/put-all-serialized.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun putAllSerialized(map: Map<String, JSONElement>)
```

Adds serialized storage entries from the given map.

Each map key is treated as an AIAgentStorageKey.name. Later calls to methods like get will match entries by that key name.

- map — serialized values keyed by storage key name.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.putAll

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/put-all.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun putAll(map: Map<AIAgentStorageKey<*>, Any>)
```

Adds all key-value pairs from the given map to the storage.

- map — A map containing keys of type AIAgentStorageKey and their associated values of type Any. The keys and values in the provided map will be added to the storage.
### :agents:agents-core/commonMain

```kotlin
abstract suspend fun putAll(other: AIAgentStorage)
```

Puts the contents of the other storage instance into the current storage. This method combines key-value pairs from the specified storage with the current one. If a key exists in both storages, the value from the given storage will overwrite the existing value.

- other — The AIAgentStorage instance whose key-value pairs should be merged into the current storage.
## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.remove

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/remove.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun <T : Any> remove(key: AIAgentStorageKey<T>): T?
```

Removes the value associated with the given key from the storage.

The value associated with the key, cast to type T, or null if the key does not exist.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.set

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/set.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun <T : Any> set(key: AIAgentStorageKey<T>, value: T)
```

Sets the value associated with the given key in the storage.

- key — The key of type AIAgentStorageKey used to identify the value in the storage.
- value — The value to be associated with the key.
## ai.koog.agents.core.agent.entity.AIAgentStorageAPI.toSerializedMap

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-a-p-i/to-serialized-map.html`

### :agents:agents-core/commonMain

```kotlin
abstract suspend fun toSerializedMap(): Map<String, JSONElement>
```

Returns serialized storage entries keyed by AIAgentStorageKey.name.

Entries whose values cannot be serialized are omitted.


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorageKey.AIAgentStorageKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/-a-i-agent-storage-key.html`

### :agents:agents-core/commonMain

```kotlin
constructor(name: String, typeToken: TypeToken)
```

- name — String key.
- typeToken — Type of the value stored under this key.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorageKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/index.html`

### :agents:agents-core/commonMain

```kotlin
data class AIAgentStorageKey<T : Any>(val name: String, val typeToken: TypeToken)
```

Represents a storage key used for AIAgentStorage. Equality is based on the name.

- name — String key.
- typeToken — Type of the value stored under this key.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.AIAgentStorageKey.name

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/name.html`

### :agents:agents-core/commonMain

```kotlin
val name: String
```

- name — String key.
## ai.koog.agents.core.agent.entity.AIAgentStorageKey.typeToken

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/-a-i-agent-storage-key/type-token.html`

### :agents:agents-core/commonMain

```kotlin
val typeToken: TypeToken
```

- typeToken — Type of the value stored under this key.

Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.agent.entity.createStorageKey

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.agent.entity/create-storage-key.html`

### :agents:agents-core/commonMain

```kotlin
fun <T : Any> createStorageKey(name: String, typeToken: TypeToken): AIAgentStorageKey<T>
```

Creates a AIAgentStorageKey.

- name — String key.
- typeToken — Type of the value stored under this key.

Referenced packages: `ai.koog.serialization`.

### :agents:agents-core/commonMain

```kotlin
inline fun <T : Any> createStorageKey(name: String): AIAgentStorageKey<T>
```

Creates a AIAgentStorageKey.

- name — String key.
- T — Type of the value stored under this key.
## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.AIAgentParallelNodesMergeContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/-a-i-agent-parallel-nodes-merge-context.html`

### :agents:agents-core/commonMain

```kotlin
constructor(underlyingContextBase: AIAgentGraphContextBase, results: List<ParallelResult<Input, Output>>)
```

- Input — The input type of the parallel nodes
- Output — The output type of the parallel nodes

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.agentId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/agent-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentId: String
```

A unique identifier representing the current agent instance within the context.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.agentInputType

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/agent-input-type.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentInputType: TypeToken
```

TypeToken representing the type of the agentInput


Referenced packages: `ai.koog.serialization`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.agentInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/agent-input.html`

### :agents:agents-core/commonMain

```kotlin
open override val agentInput: Any?
```

Represents the input provided to the agent's execution.

This variable provides access to the agent's input, which can be used to determine the agent's intent, context, or other relevant information at any stage of agents execution.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.config

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/config.html`

### :agents:agents-core/commonMain

```kotlin
open override val config: AIAgentConfig
```

Represents the configuration for an AI agent.

This configuration is used during the execution to enforce constraints such as the maximum number of iterations an agent can perform, as well as providing the agent's prompt configuration.


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.environment

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/environment.html`

### :agents:agents-core/commonMain

```kotlin
open override val environment: AIAgentEnvironment
```

Represents the environment in which the agent operates.

This variable provides access to essential functionalities for the agent's execution, including interaction with tools, error reporting, and sending termination signals. It is used throughout the agent's lifecycle to facilitate actions and handle outcomes.


Referenced packages: `ai.koog.agents.core.environment`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.executionInfo

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/execution-info.html`

### :agents:agents-core/commonMain

```kotlin
open override var executionInfo: AgentExecutionInfo
```

Represents the observability data associated with the AI Agent context.


Referenced packages: `ai.koog.agents.core.agent.execution`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.fold

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/fold.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <R> fold(initial: R, operation: suspend (acc: R, result: Output) -> R): ParallelNodeExecutionResult<R>
```

Folds the result output into a single value and leaves the base context.

The NodeExecutionResult with the folded output and the context from the first result

- initial — The initial value for the fold operation
- operation — The operation to apply to each result
- NoSuchElementException — if the results list is empty
## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.fork

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/fork.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun fork(): AIAgentGraphContextBase
```

Creates a forked instance of the underlying agent context, resulting in a new independent copy of the AIAgentContextBase. This can be used to create isolated contexts for parallel or independent operations.

A new instance of AIAgentContextBase that is a fork of the current context.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/index.html`

### :agents:agents-core/commonMain

```kotlin
class AIAgentParallelNodesMergeContext<Input, Output>(underlyingContextBase: AIAgentGraphContextBase, val results: List<ParallelResult<Input, Output>>) : AIAgentGraphContextBase
```

Context for merging parallel node execution results.

This class provides DSL methods for selecting and folding results from parallel node executions. It delegates all AIAgentContextBase methods and properties to the underlying context.

- Input — The input type of the parallel nodes
- Output — The output type of the parallel nodes

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.llm

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/llm.html`

### :agents:agents-core/commonMain

```kotlin
open override val llm: AIAgentLLMContext
```

Represents the AI agent's LLM context, providing mechanisms for managing tools, prompts, and interaction with the execution environment. It ensures thread safety during concurrent read and write operations through the use of sessions.

This context plays a foundational role in defining and manipulating tools, prompt execution, and overall behavior the agent's lifecycle.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.parentContext

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/parent-context.html`

### :agents:agents-core/commonMain

```kotlin
open override val parentContext: AIAgentGraphContextBase
```

Represents the parent context of the AI Agent.


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.pipeline

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/pipeline.html`

### :agents:agents-core/commonMain

```kotlin
open override val pipeline: AIAgentGraphPipeline
```

Represents the pipeline associated with the AI agent.


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.replace

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/replace.html`

### :agents:agents-core/commonMain

```kotlin
open suspend override fun replace(context: AIAgentContext)
```

Replaces the current context with the specified context in the underlying context base.

Unit

- context — The new context to replace the current one in the underlying context base.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.results

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/results.html`

### :agents:agents-core/commonMain

```kotlin
val results: List<ParallelResult<Input, Output>>
```

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.runId

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/run-id.html`

### :agents:agents-core/commonMain

```kotlin
open override val runId: String
```

A unique identifier for the current session associated with the AI agent context. Used to track and differentiate sessions within the execution of the agent pipeline.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.selectByIndex

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/select-by-index.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun selectByIndex(selectIndex: suspend (List<Output>) -> Int): ParallelNodeExecutionResult<Output>
```

Selects a result from a list of outputs based on a provided selection function.

The NodeExecutionResult containing the output and context at the selected index.

- selectIndex — A lambda function that takes a list of outputs and returns the index of the desired output.
- IndexOutOfBoundsException — if the index returned by the selectIndex function is out of bounds.
## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.selectByMax

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/select-by-max.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun <T : Comparable<T>> selectByMax(function: suspend (Output) -> T): ParallelNodeExecutionResult<Output>
```

Selects the maximum result based on a given comparison function and returns the corresponding NodeExecutionResult containing the selected output and its associated context.

The NodeExecutionResult containing the output and context of the result with the maximum value as determined by the comparison function.

- function — A lambda function to extract a comparable value from the Output object for determining the maximum result.
- NoSuchElementException — if the results list is empty.
## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.selectBy

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/select-by.html`

### :agents:agents-core/commonMain

```kotlin
suspend fun selectBy(predicate: suspend (Output) -> Boolean): ParallelNodeExecutionResult<Output>
```

Selects a result based on a predicate.

The NodeExecutionResult with the selected output and context

- predicate — The predicate to use for selection
- NoSuchElementException — if no result matches the predicate
## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.stateManager

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/state-manager.html`

### :agents:agents-core/commonMain

```kotlin
open override val stateManager: AIAgentStateManager
```

Manages and tracks the state of an AI agent within the context of its execution.

This variable provides synchronized access to the agent's state to ensure thread safety and consistent state transitions during concurrent operations. It acts as a central mechanism for managing state updates and validations across different nodes and subgraphs of the AI agent's execution flow.

The stateManager is utilized extensively in coordinating state changes, such as tracking the number of iterations made by the agent and enforcing execution limits or conditions. This aids in maintaining predictable and controlled behavior of the agent during execution.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.storage

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/storage.html`

### :agents:agents-core/commonMain

```kotlin
open override val storage: AIAgentStorage
```

Concurrent-safe key-value storage for an agent, used to manage and persist data within the context of the AI agent stage execution. The storage property provides a thread-safe mechanism for sharing and storing data specific to the agent's operation.


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.core.dsl.builder.AIAgentParallelNodesMergeContext.strategyName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-a-i-agent-parallel-nodes-merge-context/strategy-name.html`

### :agents:agents-core/commonMain

```kotlin
open override val strategyName: String
```

Represents the name of the strategy being used in the current AI agent context.

## ai.koog.agents.core.dsl.builder.ParallelNodeExecutionResult.ParallelNodeExecutionResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-node-execution-result/-parallel-node-execution-result.html`

### :agents:agents-core/commonMain

```kotlin
constructor(output: Output, context: AIAgentContext)
```

- Output — The type of the output value produced by the node execution.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.ParallelNodeExecutionResult.context

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-node-execution-result/context.html`

### :agents:agents-core/commonMain

```kotlin
val context: AIAgentContext
```


Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.ParallelNodeExecutionResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-node-execution-result/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ParallelNodeExecutionResult<Output>(val output: Output, val context: AIAgentContext)
```

Represents the result of a parallel node execution, containing both the output value and the execution context.

This class is used to capture the complete state of a node's execution, including both the produced output value and the context in which it was executed. This allows for both the result and any side effects or state changes to be preserved and utilized in subsequent operations.

- Output — The type of the output value produced by the node execution.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.core.dsl.builder.ParallelNodeExecutionResult.output

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-node-execution-result/output.html`

### :agents:agents-core/commonMain

```kotlin
val output: Output
```

## ai.koog.agents.core.dsl.builder.ParallelResult.ParallelResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-result/-parallel-result.html`

### :agents:agents-core/commonMain

```kotlin
constructor(nodeName: String, nodeInput: Input, nodeResult: ParallelNodeExecutionResult<Output>)
```

- Input — The type of input that was provided to the node.
- Output — The type of output produced by the node.
## ai.koog.agents.core.dsl.builder.ParallelResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-result/index.html`

### :agents:agents-core/commonMain

```kotlin
data class ParallelResult<Input, Output>(val nodeName: String, val nodeInput: Input, val nodeResult: ParallelNodeExecutionResult<Output>)
```

Represents the completed result of a parallel node execution.

This class encapsulates the final state of a node that was executed as part of a parallel execution strategy. It contains the node's name, the input that was provided to it, and the final execution result including both output and context.

- Input — The type of input that was provided to the node.
- Output — The type of output produced by the node.
## ai.koog.agents.core.dsl.builder.ParallelResult.nodeInput

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-result/node-input.html`

### :agents:agents-core/commonMain

```kotlin
val nodeInput: Input
```

## ai.koog.agents.core.dsl.builder.ParallelResult.nodeName

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-result/node-name.html`

### :agents:agents-core/commonMain

```kotlin
val nodeName: String
```

## ai.koog.agents.core.dsl.builder.ParallelResult.nodeResult

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/-parallel-result/node-result.html`

### :agents:agents-core/commonMain

```kotlin
val nodeResult: ParallelNodeExecutionResult<Output>
```

## ai.koog.agents.core.dsl.builder.parallel

Module: `agents-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-core/ai.koog.agents.core.dsl.builder/parallel.html`

### :agents:agents-core/commonMain

```kotlin
fun <Input, Output> parallel(vararg nodes: AIAgentNodeBase<Input, Output>, dispatcher: CoroutineDispatcher = Dispatchers.Default, name: String? = null, merge: suspend AIAgentParallelNodesMergeContext<Input, Output>.() -> ParallelNodeExecutionResult<Output>): AIAgentNodeDelegate<Input, Output>
```

Creates a node that executes multiple nodes in parallel.

- nodes — List of nodes to execute in parallel
- dispatcher — Coroutine dispatcher to use for parallel execution
- name — Optional node name
- merge — A suspendable lambda that defines how the outputs from the parallel nodes should be merged

Referenced packages: `ai.koog.agents.core.agent.entity`.
