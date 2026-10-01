# Chat history and preprocessing

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.chatMemory.feature.ChatHistoryProvider

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-history-provider/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
interface ChatHistoryProvider
```

Provider interface for storing and loading conversation history.

- InMemoryChatHistoryProvider
## ai.koog.agents.chatMemory.feature.ChatHistoryProvider.load

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-history-provider/load.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
abstract suspend fun load(conversationId: String): List<Message>
```

Load previously stored conversation history.

The stored messages, or an empty list if no history exists.

- conversationId — Unique identifier for the conversation.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.ChatHistoryProvider.store

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-history-provider/store.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
abstract suspend fun store(conversationId: String, messages: List<Message>)
```

Store a list of messages as conversation history.

- conversationId — Unique identifier for the conversation.
- messages — The messages to store.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.ChatMemory.ChatMemory

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory/-chat-memory.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.chatMemory.feature.ChatMemory.Feature.createInitialConfig

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): ChatMemoryConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.chatMemory.feature.ChatMemory.Feature

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory/-feature/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
object Feature : AIAgentGraphFeature<ChatMemoryConfig, ChatMemory> , AIAgentFunctionalFeature<ChatMemoryConfig, ChatMemory> , AIAgentPlannerFeature<ChatMemoryConfig, ChatMemory>
```

Companion object implementing agent feature, handling ChatMemory creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.chatMemory.feature.ChatMemory.Feature.install

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory/-feature/install.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override fun install(config: ChatMemoryConfig, pipeline: AIAgentGraphPipeline): ChatMemory
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override fun install(config: ChatMemoryConfig, pipeline: AIAgentFunctionalPipeline): ChatMemory
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override fun install(config: ChatMemoryConfig, pipeline: AIAgentPlannerPipeline): ChatMemory
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.chatMemory.feature.ChatMemory.Feature.key

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory/-feature/key.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override val key: AIAgentStorageKey<ChatMemory>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.chatMemory.feature.ChatMemory

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
class ChatMemory
```

A feature that allows storing and loading conversation history between an agent and a user.

ChatMemory enables agents to persist and retrieve past conversations, allowing for continuity across multiple agent sessions.

Example usage:

Example with a sliding window to limit the number of stored messages:

## ai.koog.agents.chatMemory.feature.ChatMemoryConfig.ChatMemoryConfig

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/-chat-memory-config.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.chatMemory.feature.ChatMemoryConfig.addPreProcessor

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/add-pre-processor.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
fun addPreProcessor(preProcessor: ChatMemoryPreProcessor): ChatMemoryConfig
```

Adds a ChatMemoryPreProcessor to the preprocessing chain.

Preprocessors are applied in the order they are added, both when loading messages from history and when storing them.

Example:

This ChatMemoryConfig instance for fluent chaining.

- preProcessor — The preprocessor to add.
## ai.koog.agents.chatMemory.feature.ChatMemoryConfig.chatHistoryProvider

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/chat-history-provider.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
fun chatHistoryProvider(provider: ChatHistoryProvider): ChatMemoryConfig
```

Sets the ChatHistoryProvider and returns this config for fluent chaining.

This ChatMemoryConfig instance for fluent chaining.

- provider — The provider responsible for persisting and retrieving conversation history.
### :agents:agents-features:agents-features-memory/commonMain

```kotlin
var chatHistoryProvider: ChatHistoryProvider
```

A provider responsible for persisting and retrieving conversation history.

Defaults to InMemoryChatHistoryProvider.

## ai.koog.agents.chatMemory.feature.ChatMemoryConfig.filterMessages

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/filter-messages.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
fun filterMessages(predicate: MessageFilter): ChatMemoryConfig
```

Adds a FilterMessagesPreProcessor that keeps only messages matching the given predicate.

The order in which filterMessages is called relative to other preprocessors matters:

This ChatMemoryConfig instance for fluent chaining.

- predicate — A MessageFilter that returns true for messages to keep.
## ai.koog.agents.chatMemory.feature.ChatMemoryConfig

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
class ChatMemoryConfig : FeatureConfig
```

Configuration for the ChatMemory feature.

Allows configuring how conversation history is stored and loaded for agent-user interactions.


Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.chatMemory.feature.ChatMemoryConfig.preprocessors

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/preprocessors.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
val preprocessors: MutableList<ChatMemoryPreProcessor>
```

Ordered list of preprocessors applied to messages when loading from and storing to history.

Preprocessors are applied sequentially in the order they were added.

- ChatMemoryPreProcessor
- addPreProcessor
- windowSize
## ai.koog.agents.chatMemory.feature.ChatMemoryConfig.windowSize

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-config/window-size.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
fun windowSize(size: Int): ChatMemoryConfig
```

Adds a WindowSizePreProcessor that limits messages to the most recent size entries.

This prevents unbounded prompt growth in long conversations by keeping only a sliding window of messages.

Example:

This ChatMemoryConfig instance for fluent chaining.

- size — The maximum number of recent messages to keep.
## ai.koog.agents.chatMemory.feature.ChatMemoryPreProcessor

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-pre-processor/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
interface ChatMemoryPreProcessor
```

An interface for pre-processing messages before they are stored or loaded in the chat memory.

Preprocessors are applied in order when messages are loaded from or stored to the history provider. They allow transforming the message list at each stage, enabling use cases such as sliding window truncation, message filtering, summarization, etc.

Note that the order of preprocessors matters. For example:

- WindowSizePreProcessor
- FilterMessagesPreProcessor
- WindowSizePreProcessor
- FilterMessagesPreProcessor
## ai.koog.agents.chatMemory.feature.ChatMemoryPreProcessor.preprocess

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-chat-memory-pre-processor/preprocess.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
abstract fun preprocess(messages: List<Message>): List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.FilterMessagesPreProcessor.FilterMessagesPreProcessor

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-filter-messages-pre-processor/-filter-messages-pre-processor.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
constructor(filter: MessageFilter)
```

- filter — The predicate that decides which messages to keep.
## ai.koog.agents.chatMemory.feature.FilterMessagesPreProcessor

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-filter-messages-pre-processor/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
class FilterMessagesPreProcessor(filter: MessageFilter) : ChatMemoryPreProcessor
```

A ChatMemoryPreProcessor that filters messages using a MessageFilter predicate.

Only messages for which filter returns true are kept.

Example usage:

- filter — The predicate that decides which messages to keep.
- MessageFilter
## ai.koog.agents.chatMemory.feature.FilterMessagesPreProcessor.preprocess

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-filter-messages-pre-processor/preprocess.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override fun preprocess(messages: List<Message>): List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.InMemoryChatHistoryProvider.InMemoryChatHistoryProvider

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-in-memory-chat-history-provider/-in-memory-chat-history-provider.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.chatMemory.feature.InMemoryChatHistoryProvider

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-in-memory-chat-history-provider/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
class InMemoryChatHistoryProvider : ChatHistoryProvider
```

A simple in-memory implementation of ChatHistoryProvider.

Stores conversation histories in a map keyed by conversation ID. Thread-safe via a coroutine Mutex. Useful for testing, prototyping, and short-lived applications where persistence across process restarts is not required.

## ai.koog.agents.chatMemory.feature.InMemoryChatHistoryProvider.load

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-in-memory-chat-history-provider/load.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open suspend override fun load(conversationId: String): List<Message>
```

Load previously stored conversation history.

The stored messages, or an empty list if no history exists.

- conversationId — Unique identifier for the conversation.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.InMemoryChatHistoryProvider.store

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-in-memory-chat-history-provider/store.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open suspend override fun store(conversationId: String, messages: List<Message>)
```

Store a list of messages as conversation history.

- conversationId — Unique identifier for the conversation.
- messages — The messages to store.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.MessageFilter

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-message-filter/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
fun interface MessageFilter
```

A predicate for filtering messages in FilterMessagesPreProcessor.

## ai.koog.agents.chatMemory.feature.MessageFilter.test

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-message-filter/test.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
abstract fun test(message: Message): Boolean
```

Tests whether the given message should be kept.

true to keep the message, false to discard it.

- message — The message to test.

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.chatMemory.feature.WindowSizePreProcessor.WindowSizePreProcessor

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-window-size-pre-processor/-window-size-pre-processor.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
constructor(windowSize: Int)
```

- windowSize — The maximum number of recent messages to keep.
## ai.koog.agents.chatMemory.feature.WindowSizePreProcessor

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-window-size-pre-processor/index.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
class WindowSizePreProcessor(windowSize: Int) : ChatMemoryPreProcessor
```

A ChatMemoryPreProcessor that limits the number of messages to a sliding window of the most recent windowSize messages.

Example usage:

- windowSize — The maximum number of recent messages to keep.
## ai.koog.agents.chatMemory.feature.WindowSizePreProcessor.preprocess

Module: `agents-features-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-memory/ai.koog.agents.chatMemory.feature/-window-size-pre-processor/preprocess.html`

### :agents:agents-features:agents-features-memory/commonMain

```kotlin
open override fun preprocess(messages: List<Message>): List<Message>
```


Referenced packages: `ai.koog.prompt.message`.
