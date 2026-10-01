# Spring Boot and Spring AI integrations

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.KoogSpringAiChatMemoryProperties

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/-koog-spring-ai-chat-memory-properties.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
constructor(enabled: Boolean = true, chatMemoryRepositoryBeanName: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.chatMemoryRepositoryBeanName

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/chat-memory-repository-bean-name.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
val chatMemoryRepositoryBeanName: String?
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.dispatcher

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.enabled

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/enabled.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/index.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.chat-memory") data class KoogSpringAiChatMemoryProperties(val enabled: Boolean = true, val chatMemoryRepositoryBeanName: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI Chat Memory adapter.

## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider.SpringAiChatHistoryProvider

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/-spring-ai-chat-history-provider.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
constructor(repository: ChatMemoryRepository, dispatcher: CoroutineDispatcher)
```

- repository — the Spring AI ChatMemoryRepository to delegate to
- dispatcher — the CoroutineDispatcher used for blocking repository calls
## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/index.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
class SpringAiChatHistoryProvider(repository: ChatMemoryRepository, dispatcher: CoroutineDispatcher) : ChatHistoryProvider
```

A conversation text memory bridge between a Spring AI ChatMemoryRepository and a Koog ChatHistoryProvider.

This adapter targets repositories that persist only Spring AI messageType and text (e.g., JdbcChatMemoryRepository). It is not a lossless Koog persistence adapter — only plain-text conversational messages survive the round-trip.

Message.System

Message.User (without attachments)

Message.Assistant (without attachments)

The following Koog message types are non-persistable transport/runtime events and are filtered out before delegation to the underlying ChatMemoryRepository:

Message.Tool.Call

Message.Tool.Result

Message.Reasoning

Any message carrying attachments (images, audio, video, files)

Spring AI TOOL rows (e.g., from JDBC repositories that previously stored tool traffic) are skipped rather than causing an error, since they cannot be meaningfully mapped back to Koog messages.

Metadata fields such as timestamps, token counts, finish reasons, and custom metadata are not preserved through the round-trip.

- repository — the Spring AI ChatMemoryRepository to delegate to
- dispatcher — the CoroutineDispatcher used for blocking repository calls

Referenced packages: `ai.koog.agents.chat-memory.feature`.

## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider.load

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/load.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
open suspend override fun load(conversationId: String): List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider.store

Module: `koog-spring-ai-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/store.html`

### :koog-spring-ai:koog-spring-ai-starter-chat-memory/main

```kotlin
open suspend override fun store(conversationId: String, messages: List<Message>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.KoogSpringAiChatProperties

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/-koog-spring-ai-chat-properties.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
constructor(enabled: Boolean = true, chatModelBeanName: String? = null, moderationModelBeanName: String? = null, provider: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.chatModelBeanName

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/chat-model-bean-name.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
val chatModelBeanName: String?
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.dispatcher

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.enabled

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/enabled.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.chat") data class KoogSpringAiChatProperties(val enabled: Boolean = true, val chatModelBeanName: String? = null, val moderationModelBeanName: String? = null, val provider: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI Chat Model adapter.

Prefix: koog.spring.ai.chat

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.moderationModelBeanName

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/moderation-model-bean-name.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
val moderationModelBeanName: String?
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.provider

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/provider.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
val provider: String?
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.Builder

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/-builder.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
constructor()
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.build

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/build.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun build(): SpringAiLLMClient
```

Builds a new SpringAiLLMClient instance.

- IllegalStateException — if chatModel has not been set
## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.chatModel

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/chat-model.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun chatModel(chatModel: ChatModel): SpringAiLLMClient.Builder
```

Sets the Spring AI ChatModel to delegate to. Required.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.chatOptionsCustomizer

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/chat-options-customizer.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun chatOptionsCustomizer(chatOptionsCustomizer: ChatOptionsCustomizer): SpringAiLLMClient.Builder
```

Sets the customizer for provider-specific ChatOptions tuning. Default is ChatOptionsCustomizer.NOOP.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.clock

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/clock.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun clock(clock: KoogClock): SpringAiLLMClient.Builder
```

Sets the clock used for creating response metadata timestamps. Default is KoogClock.System.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.dispatcher

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun dispatcher(dispatcher: CoroutineDispatcher): SpringAiLLMClient.Builder
```

Sets the CoroutineDispatcher used for blocking model calls. Default is Dispatchers.IO.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
class Builder
```

The only required property is chatModel; all others have sensible defaults.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.moderationModel

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/moderation-model.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun moderationModel(moderationModel: ModerationModel?): SpringAiLLMClient.Builder
```

Sets the optional Spring AI ModerationModel for content moderation. Default is null.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.provider

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/provider.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun provider(provider: LLMProvider): SpringAiLLMClient.Builder
```

Sets the LLMProvider to report for this client. Default is SpringAiLLMProvider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Companion.builder

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-companion/builder.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun builder(): SpringAiLLMClient.Builder
```

Usage:

## ai.koog.spring.ai.chat.SpringAiLLMClient.Companion

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-companion/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
object Companion
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.SpringAiLLMClient

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-spring-ai-l-l-m-client.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
constructor(chatModel: ChatModel, provider: LLMProvider, clock: KoogClock, dispatcher: CoroutineDispatcher, chatOptionsCustomizer: ChatOptionsCustomizer, moderationModel: ModerationModel?)
```

- chatModel — the Spring AI chat model to delegate to
- provider — the LLMProvider to report for this client
- clock — the clock used for creating response metadata timestamps
- dispatcher — the CoroutineDispatcher used for blocking model calls
- chatOptionsCustomizer — optional customizer for provider-specific ChatOptions tuning
- moderationModel — optional Spring AI ModerationModel for content moderation; if null, moderate throws UnsupportedOperationException

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.close

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/close.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open override fun close()
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.embed

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/embed.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embedding via SpringAiLLMClient is not supported. Use SpringAiLLMEmbeddingProvider for embedding with Spring AI.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding via SpringAiLLMClient is not supported. Use SpringAiLLMEmbeddingProvider for embedding with Spring AI.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.executeStreaming

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/execute-streaming.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Streams LLM responses by subscribing to ChatModel.stream and converting each chunk into Koog StreamFrame events.

Text content is emitted as StreamFrame.TextDelta frames immediately. Tool calls are handled by a SpringAiToolCallAssembler whose mode depends on the detected LLMProvider:

Anthropic / Google (SpringAiToolStreamingMode.EMIT_IMMEDIATELY): tool calls arrive fully formed in each chunk and are emitted immediately.

OpenAI and unknown providers (SpringAiToolStreamingMode.BUFFER_UNTIL_END): tool call fragments are buffered across chunks and emitted as complete tool calls after the stream ends.

The resulting flow uses ai.koog.prompt.streaming.StreamFrameFlowBuilder which automatically pairs each StreamFrame.ToolCallDelta with a corresponding StreamFrame.ToolCallComplete and emits StreamFrame.TextComplete / StreamFrame.ReasoningComplete boundaries.

All blocking I/O runs on the configured dispatcher (default Dispatchers.IO).


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.execute

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/execute.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.spring.ai.chat.SpringAiLLMClient

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
class SpringAiLLMClient(chatModel: ChatModel, provider: LLMProvider, clock: KoogClock, dispatcher: CoroutineDispatcher, chatOptionsCustomizer: ChatOptionsCustomizer, moderationModel: ModerationModel?) : LLMClient
```

An LLMClient implementation that delegates to a Spring AI ChatModel.

This adapter allows Koog agents to use any Spring AI chat model provider (Anthropic, OpenAI, Google, Ollama, etc.) as their underlying LLM backend.

Tool execution is always owned by the Koog agent framework. Spring AI receives only tool definitions (via org.springframework.ai.tool.ToolCallback with a throwing call()) and internalToolExecutionEnabled=false, so Spring never attempts to execute tools.

- chatModel — the Spring AI chat model to delegate to
- provider — the LLMProvider to report for this client
- clock — the clock used for creating response metadata timestamps
- dispatcher — the CoroutineDispatcher used for blocking model calls
- chatOptionsCustomizer — optional customizer for provider-specific ChatOptions tuning
- moderationModel — optional Spring AI ModerationModel for content moderation; if null, moderate throws UnsupportedOperationException

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.llmProvider

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/llm-provider.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.models

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/models.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open suspend override fun models(): List<LLModel>
```

Returns the list with one model based on the configured LLMProvider and ChatModel without capabilities or parameters.

The model id is extracted from ChatModel.getDefaultOptions at runtime, reflecting whatever model the Spring AI provider has been configured with. If the underlying ChatModel does not expose a model name via its default options, an empty list is returned.

a list containing the configured LLModel, or an empty list if the model name is unavailable.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.moderate

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/moderate.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMProvider

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-provider/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
object SpringAiLLMProvider : LLMProvider
```

An ai.koog.prompt.llm.LLMProvider representing a Spring AI-backed provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.KoogSpringAiEmbeddingProperties

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/-koog-spring-ai-embedding-properties.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
constructor(enabled: Boolean = true, embeddingModelBeanName: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.dispatcher

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.embeddingModelBeanName

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/embedding-model-bean-name.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
val embeddingModelBeanName: String?
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.enabled

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/enabled.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.embedding") data class KoogSpringAiEmbeddingProperties(val enabled: Boolean = true, val embeddingModelBeanName: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI Embedding Model adapter.

Prefix: koog.spring.ai.embedding

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.Builder

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/-builder.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
constructor()
```

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.build

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/build.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
fun build(): SpringAiLLMEmbeddingProvider
```

Builds a new SpringAiLLMEmbeddingProvider instance.

- IllegalStateException — if embeddingModel has not been set
## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.dispatcher

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
fun dispatcher(dispatcher: CoroutineDispatcher): SpringAiLLMEmbeddingProvider.Builder
```

Sets the CoroutineDispatcher used for blocking embedding calls. Default is Dispatchers.IO.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.embeddingModel

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/embedding-model.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
fun embeddingModel(embeddingModel: EmbeddingModel): SpringAiLLMEmbeddingProvider.Builder
```

Sets the Spring AI EmbeddingModel to delegate to. Required.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
class Builder
```

The only required property is embeddingModel; all others have sensible defaults.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Companion.builder

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-companion/builder.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
fun builder(): SpringAiLLMEmbeddingProvider.Builder
```

Usage:

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Companion

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-companion/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
object Companion
```

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.SpringAiLLMEmbeddingProvider

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-spring-ai-l-l-m-embedding-provider.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
constructor(embeddingModel: EmbeddingModel, dispatcher: CoroutineDispatcher)
```

- embeddingModel — the Spring AI embedding model to delegate to
- dispatcher — the CoroutineDispatcher used for blocking embedding calls
## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.embed

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/embed.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the configured Spring AI EmbeddingModel.

The LLModel.id is forwarded to the underlying model via EmbeddingOptions so that backends supporting runtime model selection can honour it.

A list of floating-point values representing the embedding vector.

- text — The text to embed.
- model — The model to use for embedding; its LLModel.id is passed as an embedding option.
- LLMClientException — if the underlying Spring AI call fails.

Referenced packages: `ai.koog.prompt.llm`.

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given inputs using the configured Spring AI EmbeddingModel.

The LLModel.id is forwarded to the underlying model via EmbeddingOptions so that backends supporting runtime model selection can honour it.

A list of embedding vectors, one per input string.

- inputs — The list of texts to embed.
- model — The model to use for embedding; its LLModel.id is passed as an embedding option.
- LLMClientException — if the underlying Spring AI call fails.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
class SpringAiLLMEmbeddingProvider(embeddingModel: EmbeddingModel, dispatcher: CoroutineDispatcher) : LLMEmbeddingProvider
```

An LLMEmbeddingProvider implementation that delegates to a Spring AI EmbeddingModel.

When multiple embedding models are registered in the Spring context, use the koog.spring.ai.embedding.embedding-model-bean-name property to select the desired bean. The LLModel.id is forwarded to the underlying Spring AI model via EmbeddingOptions so that backends which support runtime model selection (e.g. OpenAI-compatible endpoints) can honour it; backends that ignore the option will simply use their pre-configured model.

- embeddingModel — the Spring AI embedding model to delegate to
- dispatcher — the CoroutineDispatcher used for blocking embedding calls

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.Builder

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/-builder.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
constructor(content: String)
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.build

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/build.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
fun build(): DocumentWithMetadata
```

Builds the DocumentWithMetadata instance.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.id

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/id.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
fun id(id: String?): DocumentWithMetadata.Builder
```

Sets the document id.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/index.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
class Builder(content: String)
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.metadata

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/metadata.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
fun metadata(key: String, value: Any): DocumentWithMetadata.Builder
```

Adds a single metadata entry.

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
fun metadata(map: Map<String, Any>): DocumentWithMetadata.Builder
```

Replaces all metadata with the given map.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.DocumentWithMetadata

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-document-with-metadata.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
constructor(content: String, metadata: Map<String, Any> = emptyMap(), id: String? = null)
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.content

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/content.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open override val content: String
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.id

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/id.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open override val id: String?
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/index.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
data class DocumentWithMetadata constructor(val content: String, val metadata: Map<String, Any> = emptyMap(), val id: String? = null) : TextDocument
```

Vector-store document model used by this starter.

Metadata values are restricted to primitive types (String, Number, Boolean) to match Spring AI org.springframework.ai.document.Document metadata constraints.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.metadata

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/metadata.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open override val metadata: Map<String, Any>
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.KoogSpringAiVectorStoreProperties

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/-koog-spring-ai-vector-store-properties.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
constructor(enabled: Boolean = true, vectorStoreBeanName: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.dispatcher

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.enabled

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/enabled.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/index.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.vectorstore") data class KoogSpringAiVectorStoreProperties(val enabled: Boolean = true, val vectorStoreBeanName: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI vector-store adapter.

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.vectorStoreBeanName

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/vector-store-bean-name.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
val vectorStoreBeanName: String?
```

## ai.koog.spring.ai.vectorstore.KoogVectorStore

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-vector-store/index.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
interface KoogVectorStore : WriteStorage<TextDocument> , SearchStorage<TextDocument, SearchRequest> , FilteringDeletionStorage
```

A unified storage interface that combines WriteStorage, SearchStorage, and FilteringDeletionStorage for use with Spring AI vector stores.

Users can inject this single interface as a Spring Bean to access all storage capabilities (ingestion, retrieval, deletion) through one dependency.

- SpringAiKoogVectorStore

Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.SpringAiKoogVectorStore

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/-spring-ai-koog-vector-store.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
constructor(vectorStore: VectorStore, dispatcher: CoroutineDispatcher)
```

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.add

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/add.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open suspend override fun add(documents: List<TextDocument>, namespace: String?): List<String>
```

It adds documents with randomly generated ids for null ids, otherwise it adds documents with specified ids.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.delete

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/delete.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open suspend override fun delete(ids: List<String>, namespace: String?): List<String>
```

It deletes documents by ids, but returns specified ids, because Spring AI VectorStore does not return deleted ids.

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open suspend override fun delete(filterExpression: String, namespace: String?): List<String>
```

It deletes documents by filterExpression, but returns an empty list, because VectorStore does not return deleted ids.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/index.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
class SpringAiKoogVectorStore(vectorStore: VectorStore, dispatcher: CoroutineDispatcher) : KoogVectorStore
```

Adapts a Spring AI VectorStore to Koog storage abstractions.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.search

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/search.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open suspend override fun search(request: SearchRequest, namespace: String?): List<SearchResult<TextDocument>>
```

Does similarity search, because Spring AI VectorStore currently supports only similaritySearch.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.update

Module: `koog-spring-ai-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/update.html`

### :koog-spring-ai:koog-spring-ai-starter-vector-store/main

```kotlin
open suspend override fun update(documents: Map<String, TextDocument>, namespace: String?): List<String>
```

It deletes old documents by their ids and adds new documents. Spring AI VectorStore does not support transactional update.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.KoogSpringAiChatMemoryProperties

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/-koog-spring-ai-chat-memory-properties.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
constructor(enabled: Boolean = true, chatMemoryRepositoryBeanName: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.chatMemoryRepositoryBeanName

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/chat-memory-repository-bean-name.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
val chatMemoryRepositoryBeanName: String?
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.dispatcher

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties.enabled

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/enabled.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.memory.KoogSpringAiChatMemoryProperties

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-koog-spring-ai-chat-memory-properties/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.chat-memory") data class KoogSpringAiChatMemoryProperties(val enabled: Boolean = true, val chatMemoryRepositoryBeanName: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI Chat Memory adapter.

## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider.SpringAiChatHistoryProvider

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/-spring-ai-chat-history-provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
constructor(repository: ChatMemoryRepository, dispatcher: CoroutineDispatcher)
```

- repository — the Spring AI ChatMemoryRepository to delegate to
- dispatcher — the CoroutineDispatcher used for blocking repository calls
## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
class SpringAiChatHistoryProvider(repository: ChatMemoryRepository, dispatcher: CoroutineDispatcher) : ChatHistoryProvider
```

A conversation text memory bridge between a Spring AI ChatMemoryRepository and a Koog ChatHistoryProvider.

This adapter targets repositories that persist only Spring AI messageType and text (e.g., JdbcChatMemoryRepository). It is not a lossless Koog persistence adapter — only plain-text conversational messages survive the round-trip.

Message.System

Message.User (without attachments)

Message.Assistant (without attachments)

The following Koog message types are non-persistable transport/runtime events and are filtered out before delegation to the underlying ChatMemoryRepository:

Message.Tool.Call

Message.Tool.Result

Message.Reasoning

Any message carrying attachments (images, audio, video, files)

Spring AI TOOL rows (e.g., from JDBC repositories that previously stored tool traffic) are skipped rather than causing an error, since they cannot be meaningfully mapped back to Koog messages.

Metadata fields such as timestamps, token counts, finish reasons, and custom metadata are not preserved through the round-trip.

- repository — the Spring AI ChatMemoryRepository to delegate to
- dispatcher — the CoroutineDispatcher used for blocking repository calls

Referenced packages: `ai.koog.agents.chat-memory.feature`.

## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider.load

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/load.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
open suspend override fun load(conversationId: String): List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.spring.ai.memory.SpringAiChatHistoryProvider.store

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-history-provider/store.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
open suspend override fun store(conversationId: String, messages: List<Message>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.KoogSpringAiChatProperties

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/-koog-spring-ai-chat-properties.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
constructor(enabled: Boolean = true, chatModelBeanName: String? = null, moderationModelBeanName: String? = null, provider: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.chatModelBeanName

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/chat-model-bean-name.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
val chatModelBeanName: String?
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.dispatcher

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.enabled

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/enabled.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.chat") data class KoogSpringAiChatProperties(val enabled: Boolean = true, val chatModelBeanName: String? = null, val moderationModelBeanName: String? = null, val provider: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI Chat Model adapter.

Prefix: koog.spring.ai.chat

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.moderationModelBeanName

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/moderation-model-bean-name.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
val moderationModelBeanName: String?
```

## ai.koog.spring.ai.chat.KoogSpringAiChatProperties.provider

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-koog-spring-ai-chat-properties/provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
val provider: String?
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.Builder

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/-builder.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
constructor()
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.build

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/build.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun build(): SpringAiLLMClient
```

Builds a new SpringAiLLMClient instance.

- IllegalStateException — if chatModel has not been set
## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.chatModel

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/chat-model.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun chatModel(chatModel: ChatModel): SpringAiLLMClient.Builder
```

Sets the Spring AI ChatModel to delegate to. Required.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.chatOptionsCustomizer

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/chat-options-customizer.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun chatOptionsCustomizer(chatOptionsCustomizer: ChatOptionsCustomizer): SpringAiLLMClient.Builder
```

Sets the customizer for provider-specific ChatOptions tuning. Default is ChatOptionsCustomizer.NOOP.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.clock

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/clock.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun clock(clock: KoogClock): SpringAiLLMClient.Builder
```

Sets the clock used for creating response metadata timestamps. Default is KoogClock.System.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.dispatcher

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun dispatcher(dispatcher: CoroutineDispatcher): SpringAiLLMClient.Builder
```

Sets the CoroutineDispatcher used for blocking model calls. Default is Dispatchers.IO.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
class Builder
```

The only required property is chatModel; all others have sensible defaults.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.moderationModel

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/moderation-model.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun moderationModel(moderationModel: ModerationModel?): SpringAiLLMClient.Builder
```

Sets the optional Spring AI ModerationModel for content moderation. Default is null.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Builder.provider

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-builder/provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun provider(provider: LLMProvider): SpringAiLLMClient.Builder
```

Sets the LLMProvider to report for this client. Default is SpringAiLLMProvider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.Companion.builder

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-companion/builder.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
fun builder(): SpringAiLLMClient.Builder
```

Usage:

## ai.koog.spring.ai.chat.SpringAiLLMClient.Companion

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-companion/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
object Companion
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.SpringAiLLMClient

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/-spring-ai-l-l-m-client.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
constructor(chatModel: ChatModel, provider: LLMProvider, clock: KoogClock, dispatcher: CoroutineDispatcher, chatOptionsCustomizer: ChatOptionsCustomizer, moderationModel: ModerationModel?)
```

- chatModel — the Spring AI chat model to delegate to
- provider — the LLMProvider to report for this client
- clock — the clock used for creating response metadata timestamps
- dispatcher — the CoroutineDispatcher used for blocking model calls
- chatOptionsCustomizer — optional customizer for provider-specific ChatOptions tuning
- moderationModel — optional Spring AI ModerationModel for content moderation; if null, moderate throws UnsupportedOperationException

Referenced packages: `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.close

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/close.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open override fun close()
```

## ai.koog.spring.ai.chat.SpringAiLLMClient.embed

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/embed.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embedding via SpringAiLLMClient is not supported. Use SpringAiLLMEmbeddingProvider for embedding with Spring AI.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Batch embedding via SpringAiLLMClient is not supported. Use SpringAiLLMEmbeddingProvider for embedding with Spring AI.

- UnsupportedOperationException — Always thrown.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.executeStreaming

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/execute-streaming.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Streams LLM responses by subscribing to ChatModel.stream and converting each chunk into Koog StreamFrame events.

Text content is emitted as StreamFrame.TextDelta frames immediately. Tool calls are handled by a SpringAiToolCallAssembler whose mode depends on the detected LLMProvider:

Anthropic / Google (SpringAiToolStreamingMode.EMIT_IMMEDIATELY): tool calls arrive fully formed in each chunk and are emitted immediately.

OpenAI and unknown providers (SpringAiToolStreamingMode.BUFFER_UNTIL_END): tool call fragments are buffered across chunks and emitted as complete tool calls after the stream ends.

The resulting flow uses ai.koog.prompt.streaming.StreamFrameFlowBuilder which automatically pairs each StreamFrame.ToolCallDelta with a corresponding StreamFrame.ToolCallComplete and emits StreamFrame.TextComplete / StreamFrame.ReasoningComplete boundaries.

All blocking I/O runs on the configured dispatcher (default Dispatchers.IO).


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.execute

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/execute.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.spring.ai.chat.SpringAiLLMClient

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
class SpringAiLLMClient(chatModel: ChatModel, provider: LLMProvider, clock: KoogClock, dispatcher: CoroutineDispatcher, chatOptionsCustomizer: ChatOptionsCustomizer, moderationModel: ModerationModel?) : LLMClient
```

An LLMClient implementation that delegates to a Spring AI ChatModel.

This adapter allows Koog agents to use any Spring AI chat model provider (Anthropic, OpenAI, Google, Ollama, etc.) as their underlying LLM backend.

Tool execution is always owned by the Koog agent framework. Spring AI receives only tool definitions (via org.springframework.ai.tool.ToolCallback with a throwing call()). Because the ChatModel is invoked directly (without a ToolCallingAdvisor), Spring AI never attempts to execute tools and simply returns the requested tool calls in the response.

- chatModel — the Spring AI chat model to delegate to
- provider — the LLMProvider to report for this client
- clock — the clock used for creating response metadata timestamps
- dispatcher — the CoroutineDispatcher used for blocking model calls
- chatOptionsCustomizer — optional customizer for provider-specific ChatOptions tuning
- moderationModel — optional Spring AI ModerationModel for content moderation; if null, moderate throws UnsupportedOperationException

Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`, `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.llmProvider

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/llm-provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open override fun llmProvider(): LLMProvider
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.models

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/models.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open suspend override fun models(): List<LLModel>
```

Returns the list with one model based on the configured LLMProvider and ChatModel without capabilities or parameters.

The model id is extracted from ChatModel.getOptions at runtime, reflecting whatever model the Spring AI provider has been configured with. If the underlying ChatModel does not expose a model name via its default options, an empty list is returned.

a list containing the configured LLModel, or an empty list if the model name is unavailable.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMClient.moderate

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-client/moderate.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiLLMProvider

Module: `koog-spring-ai-v2-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-l-l-m-provider/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-chat/main

```kotlin
object SpringAiLLMProvider : LLMProvider
```

An ai.koog.prompt.llm.LLMProvider representing a Spring AI-backed provider.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.KoogSpringAiEmbeddingProperties

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/-koog-spring-ai-embedding-properties.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
constructor(enabled: Boolean = true, embeddingModelBeanName: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.dispatcher

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.embeddingModelBeanName

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/embedding-model-bean-name.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
val embeddingModelBeanName: String?
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties.enabled

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/enabled.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.embedding.KoogSpringAiEmbeddingProperties

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-koog-spring-ai-embedding-properties/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.embedding") data class KoogSpringAiEmbeddingProperties(val enabled: Boolean = true, val embeddingModelBeanName: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI Embedding Model adapter.

Prefix: koog.spring.ai.embedding

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.Builder

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/-builder.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
constructor()
```

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.build

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/build.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
fun build(): SpringAiLLMEmbeddingProvider
```

Builds a new SpringAiLLMEmbeddingProvider instance.

- IllegalStateException — if embeddingModel has not been set
## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.dispatcher

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
fun dispatcher(dispatcher: CoroutineDispatcher): SpringAiLLMEmbeddingProvider.Builder
```

Sets the CoroutineDispatcher used for blocking embedding calls. Default is Dispatchers.IO.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder.embeddingModel

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/embedding-model.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
fun embeddingModel(embeddingModel: EmbeddingModel): SpringAiLLMEmbeddingProvider.Builder
```

Sets the Spring AI EmbeddingModel to delegate to. Required.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Builder

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-builder/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
class Builder
```

The only required property is embeddingModel; all others have sensible defaults.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Companion.builder

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-companion/builder.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
fun builder(): SpringAiLLMEmbeddingProvider.Builder
```

Usage:

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.Companion

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-companion/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
object Companion
```

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.SpringAiLLMEmbeddingProvider

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/-spring-ai-l-l-m-embedding-provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
constructor(embeddingModel: EmbeddingModel, dispatcher: CoroutineDispatcher)
```

- embeddingModel — the Spring AI embedding model to delegate to
- dispatcher — the CoroutineDispatcher used for blocking embedding calls
## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider.embed

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/embed.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the configured Spring AI EmbeddingModel.

The LLModel.id is forwarded to the underlying model via EmbeddingOptions so that backends supporting runtime model selection can honour it.

A list of floating-point values representing the embedding vector.

- text — The text to embed.
- model — The model to use for embedding; its LLModel.id is passed as an embedding option.
- LLMClientException — if the underlying Spring AI call fails.

Referenced packages: `ai.koog.prompt.llm`.

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given inputs using the configured Spring AI EmbeddingModel.

The LLModel.id is forwarded to the underlying model via EmbeddingOptions so that backends supporting runtime model selection can honour it.

A list of embedding vectors, one per input string.

- inputs — The list of texts to embed.
- model — The model to use for embedding; its LLModel.id is passed as an embedding option.
- LLMClientException — if the underlying Spring AI call fails.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.spring.ai.embedding.SpringAiLLMEmbeddingProvider

Module: `koog-spring-ai-v2-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-l-l-m-embedding-provider/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-model-embedding/main

```kotlin
class SpringAiLLMEmbeddingProvider(embeddingModel: EmbeddingModel, dispatcher: CoroutineDispatcher) : LLMEmbeddingProvider
```

An LLMEmbeddingProvider implementation that delegates to a Spring AI EmbeddingModel.

When multiple embedding models are registered in the Spring context, use the koog.spring.ai.embedding.embedding-model-bean-name property to select the desired bean. The LLModel.id is forwarded to the underlying Spring AI model via EmbeddingOptions so that backends which support runtime model selection (e.g. OpenAI-compatible endpoints) can honour it; backends that ignore the option will simply use their pre-configured model.

- embeddingModel — the Spring AI embedding model to delegate to
- dispatcher — the CoroutineDispatcher used for blocking embedding calls

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.Builder

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/-builder.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor(content: String)
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.build

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/build.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
fun build(): DocumentWithMetadata
```

Builds the DocumentWithMetadata instance.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.id

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/id.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
fun id(id: String?): DocumentWithMetadata.Builder
```

Sets the document id.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
class Builder(content: String)
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.Builder.metadata

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-builder/metadata.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
fun metadata(key: String, value: Any): DocumentWithMetadata.Builder
```

Adds a single metadata entry.

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
fun metadata(map: Map<String, Any>): DocumentWithMetadata.Builder
```

Replaces all metadata with the given map.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.DocumentWithMetadata

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/-document-with-metadata.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor(content: String, metadata: Map<String, Any> = emptyMap(), id: String? = null)
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.content

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/content.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open override val content: String
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.id

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/id.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open override val id: String?
```

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
data class DocumentWithMetadata constructor(val content: String, val metadata: Map<String, Any> = emptyMap(), val id: String? = null) : TextDocument
```

Vector-store document model used by this starter.

Metadata values are restricted to primitive types (String, Number, Boolean) to match Spring AI org.springframework.ai.document.Document metadata constraints.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.spring.ai.vectorstore.DocumentWithMetadata.metadata

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-document-with-metadata/metadata.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open override val metadata: Map<String, Any>
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.KoogSpringAiVectorStoreProperties

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/-koog-spring-ai-vector-store-properties.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor(enabled: Boolean = true, vectorStoreBeanName: String? = null, dispatcher: DispatcherConfig = DispatcherConfig())
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.dispatcher

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
val dispatcher: DispatcherConfig
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.enabled

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/enabled.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@ConfigurationProperties(prefix = "koog.spring.ai.vectorstore") data class KoogSpringAiVectorStoreProperties(val enabled: Boolean = true, val vectorStoreBeanName: String? = null, val dispatcher: DispatcherConfig = DispatcherConfig())
```

Configuration properties for the Koog Spring AI vector-store adapter.

## ai.koog.spring.ai.vectorstore.KoogSpringAiVectorStoreProperties.vectorStoreBeanName

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-spring-ai-vector-store-properties/vector-store-bean-name.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
val vectorStoreBeanName: String?
```

## ai.koog.spring.ai.vectorstore.KoogVectorStore

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-vector-store/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
interface KoogVectorStore : WriteStorage<TextDocument> , SearchStorage<TextDocument, SearchRequest> , FilteringDeletionStorage
```

A unified storage interface that combines WriteStorage, SearchStorage, and FilteringDeletionStorage for use with Spring AI vector stores.

Users can inject this single interface as a Spring Bean to access all storage capabilities (ingestion, retrieval, deletion) through one dependency.

- SpringAiKoogVectorStore

Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.SpringAiKoogVectorStore

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/-spring-ai-koog-vector-store.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor(vectorStore: VectorStore, dispatcher: CoroutineDispatcher)
```

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.add

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/add.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open suspend override fun add(documents: List<TextDocument>, namespace: String?): List<String>
```

It adds documents with randomly generated ids for null ids, otherwise it adds documents with specified ids.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.delete

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/delete.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open suspend override fun delete(ids: List<String>, namespace: String?): List<String>
```

It deletes documents by ids, but returns specified ids, because Spring AI VectorStore does not return deleted ids.

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open suspend override fun delete(filterExpression: String, namespace: String?): List<String>
```

It deletes documents by filterExpression, but returns an empty list, because VectorStore does not return deleted ids.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
class SpringAiKoogVectorStore(vectorStore: VectorStore, dispatcher: CoroutineDispatcher) : KoogVectorStore
```

Adapts a Spring AI VectorStore to Koog storage abstractions.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.search

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/search.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open suspend override fun search(request: SearchRequest, namespace: String?): List<SearchResult<TextDocument>>
```

Does similarity search, because Spring AI VectorStore currently supports only similaritySearch.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.spring.ai.vectorstore.SpringAiKoogVectorStore.update

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-koog-vector-store/update.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
open suspend override fun update(documents: Map<String, TextDocument>, namespace: String?): List<String>
```

It deletes old documents by their ids and adds new documents. Spring AI VectorStore does not support transactional update.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.spring.RetryConfigKoogProperties.Companion.builder

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-companion/builder.html`

### :koog-spring-boot-starter/main

```kotlin
fun builder(): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Creates a new RetryConfigKoogPropertiesBuilder for constructing RetryConfigKoogProperties instances.

a new builder instance.

## ai.koog.spring.RetryConfigKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for RetryConfigKoogProperties, providing a builder for constructing instances.

## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.RetryConfigKoogPropertiesBuilder

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/-retry-config-koog-properties-builder.html`

### :koog-spring-boot-starter/main

```kotlin
constructor()
```

## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.backoffMultiplier

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/backoff-multiplier.html`

### :koog-spring-boot-starter/main

```kotlin
fun backoffMultiplier(backoffMultiplier: Double): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Sets the backoff multiplier for subsequent retry attempts.

the updated builder instance.

- backoffMultiplier — the multiplier to apply to the delay for each subsequent retry.
## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.build

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/build.html`

### :koog-spring-boot-starter/main

```kotlin
fun build(): RetryConfigKoogProperties
```

Builds a new RetryConfigKoogProperties instance with the configured values.

a new RetryConfigKoogProperties instance.

## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
fun enabled(enabled: Boolean): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Sets whether retries are enabled.

the updated builder instance.

- enabled — true to enable retries, false to disable.
## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/index.html`

### :koog-spring-boot-starter/main

```kotlin
class RetryConfigKoogPropertiesBuilder
```

## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.initialDelay

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/initial-delay.html`

### :koog-spring-boot-starter/main

```kotlin
fun initialDelay(initialDelay: Duration): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Sets the initial delay before the first retry attempt.

the updated builder instance.

- initialDelay — the initial delay duration.
## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.jitterFactor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/jitter-factor.html`

### :koog-spring-boot-starter/main

```kotlin
fun jitterFactor(jitterFactor: Double): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Sets the jitter factor to introduce randomness in delay calculations.

the updated builder instance.

- jitterFactor — the factor for randomness in delays.
## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.maxAttempts

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/max-attempts.html`

### :koog-spring-boot-starter/main

```kotlin
fun maxAttempts(maxAttempts: Int): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Sets the maximum number of retry attempts.

the updated builder instance.

- maxAttempts — the maximum number of retry attempts.
## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder.maxDelay

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties-builder/max-delay.html`

### :koog-spring-boot-starter/main

```kotlin
fun maxDelay(maxDelay: Duration): RetryConfigKoogProperties.RetryConfigKoogPropertiesBuilder
```

Sets the maximum delay allowed between retry attempts.

the updated builder instance.

- maxDelay — the maximum delay duration.
## ai.koog.spring.RetryConfigKoogProperties.RetryConfigKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/-retry-config-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean = false, maxAttempts: Int? = null, @DurationUnit(value = ChronoUnit.SECONDS) initialDelay: Duration? = null, @DurationUnit(value = ChronoUnit.SECONDS) maxDelay: Duration? = null, backoffMultiplier: Double? = null, jitterFactor: Double? = null)
```

## ai.koog.spring.RetryConfigKoogProperties.backoffMultiplier

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/backoff-multiplier.html`

### :koog-spring-boot-starter/main

```kotlin
val backoffMultiplier: Double?
```

## ai.koog.spring.RetryConfigKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
val enabled: Boolean
```

## ai.koog.spring.RetryConfigKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
class RetryConfigKoogProperties(val enabled: Boolean = false, val maxAttempts: Int? = null, @DurationUnit(value = ChronoUnit.SECONDS) val initialDelay: Duration? = null, @DurationUnit(value = ChronoUnit.SECONDS) val maxDelay: Duration? = null, val backoffMultiplier: Double? = null, val jitterFactor: Double? = null)
```

Represents configuration properties for retry mechanisms associated with clients.

This class is used to define retry behavior, including specifications such as the number of retry attempts, delay between attempts, and mechanisms to control backoff strategy and randomness in delays.

## ai.koog.spring.RetryConfigKoogProperties.initialDelay

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/initial-delay.html`

### :koog-spring-boot-starter/main

```kotlin
val initialDelay: Duration?
```

## ai.koog.spring.RetryConfigKoogProperties.jitterFactor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/jitter-factor.html`

### :koog-spring-boot-starter/main

```kotlin
val jitterFactor: Double?
```

## ai.koog.spring.RetryConfigKoogProperties.maxAttempts

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/max-attempts.html`

### :koog-spring-boot-starter/main

```kotlin
val maxAttempts: Int?
```

## ai.koog.spring.RetryConfigKoogProperties.maxDelay

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring/-retry-config-koog-properties/max-delay.html`

### :koog-spring-boot-starter/main

```kotlin
val maxDelay: Duration?
```

## ai.koog.spring.conditions.ConditionalOnPropertyNotEmpty

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.conditions/-conditional-on-property-not-empty/index.html`

### :koog-spring-boot-starter/main

```kotlin
@Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION]) @Conditional(value = [OnPropertyNotEmptyCondition::class]) annotation class ConditionalOnPropertyNotEmpty(val prefix: String = "", val name: String)
```

## ai.koog.spring.conditions.ConditionalOnPropertyNotEmpty.name

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.conditions/-conditional-on-property-not-empty/name.html`

### :koog-spring-boot-starter/main

```kotlin
val name: String
```

## ai.koog.spring.conditions.ConditionalOnPropertyNotEmpty.prefix

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.conditions/-conditional-on-property-not-empty/prefix.html`

### :koog-spring-boot-starter/main

```kotlin
val prefix: String
```

## ai.koog.spring.conditions.OnPropertyNotEmptyCondition.OnPropertyNotEmptyCondition

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.conditions/-on-property-not-empty-condition/-on-property-not-empty-condition.html`

### :koog-spring-boot-starter/main

```kotlin
constructor()
```

## ai.koog.spring.conditions.OnPropertyNotEmptyCondition.getMatchOutcome

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.conditions/-on-property-not-empty-condition/get-match-outcome.html`

### :koog-spring-boot-starter/main

```kotlin
open override fun getMatchOutcome(context: ConditionContext, metadata: AnnotatedTypeMetadata): ConditionOutcome
```

## ai.koog.spring.conditions.OnPropertyNotEmptyCondition

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.conditions/-on-property-not-empty-condition/index.html`

### :koog-spring-boot-starter/main

```kotlin
class OnPropertyNotEmptyCondition : SpringBootCondition
```

## ai.koog.spring.prompt.executor.MultiLLMAutoConfiguration.MultiLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor/-multi-l-l-m-auto-configuration/-multi-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor()
```

## ai.koog.spring.prompt.executor.MultiLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor/-multi-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration class MultiLLMAutoConfiguration
```

## ai.koog.spring.prompt.executor.MultiLLMAutoConfiguration.multiLLMPromptExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor/-multi-l-l-m-auto-configuration/multi-l-l-m-prompt-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean fun multiLLMPromptExecutor(@Autowired llmClients: List<LLMClient>): MultiLLMPromptExecutor
```


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.llms`.

## ai.koog.spring.prompt.executor.clients.KoogLlmClientProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients/-koog-llm-client-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
abstract val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.KoogLlmClientProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients/-koog-llm-client-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
abstract val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.KoogLlmClientProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients/-koog-llm-client-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
interface KoogLlmClientProperties
```

Interface representing configuration properties for a Koog LLM Client.

This interface is intended to provide the necessary configuration required to set up a LLM Client. It includes options for enabling the client, specifying the base URL, and defining retry configurations.

- enabled — Indicates whether the LLM client is enabled.
- baseUrl — Specifies the base URL for the LLM client.
- retry — Defines the retry configuration for the LLM client using RetryConfigKoogProperties.
- AnthropicKoogProperties
- DeepSeekKoogProperties
- GoogleKoogProperties
- MistralAIKoogProperties
- OllamaKoogProperties
- OpenAIKoogProperties
- OpenRouterKoogProperties
## ai.koog.spring.prompt.executor.clients.KoogLlmClientProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients/-koog-llm-client-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
abstract val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.AnthropicKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/-anthropic-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, apiKey: String, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration Anthropic-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object providing constant value associated with the configuration of Anthropic-related properties.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.apiKey

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/api-key.html`

### :koog-spring-boot-starter/main

```kotlin
val apiKey: String
```

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.anthropic", ignoreUnknownFields = true) class AnthropicKoogProperties(val enabled: Boolean, val apiKey: String, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration properties for configuring Anthropic-related clients in the Koog framework.

This class allows defining settings necessary for integrating with the Anthropic LLM (Large Language Model) client. It implements KoogLlmClientProperties and includes common LLM client configurations such as enabled, baseUrl, and retry options. Additionally, it includes the apiKey property specific to the Anthropic client.

The properties are bound to the configuration prefix defined by AnthropicKoogProperties.PREFIX, which is ai.koog.anthropic. This allows configuring the client via property files in a Spring Boot application.


Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicLLMAutoConfiguration.AnthropicLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-l-l-m-auto-configuration/-anthropic-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: AnthropicKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicLLMAutoConfiguration.anthropicExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-l-l-m-auto-configuration/anthropic-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [AnthropicLLMClient::class]) fun anthropicExecutor(client: AnthropicLLMClient): PromptExecutor
```

Creates and initializes a SingleLLMPromptExecutor instance using an AnthropicLLMClient. The executor is configured with a retrying client derived from the provided AnthropicLLMClient.

An instance of SingleLLMPromptExecutor for sending prompts to the Anthropic LLM API.

- client — An instance of AnthropicLLMClient used to communicate with the Anthropic LLM API.

Referenced packages: `ai.koog.prompt.executor.clients.anthropic`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicLLMAutoConfiguration.anthropicLLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-l-l-m-auto-configuration/anthropic-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.anthropic", name = ["enabled"], havingValue = "true") fun anthropicLLMClient(): AnthropicLLMClient
```

Creates an AnthropicLLMClient bean configured with application properties.

This method initializes a AnthropicLLMClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.anthropic.api-key property is defined and koog.ai.anthropic.enabled property is set to true in the application configuration.

An AnthropicLLMClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.clients.anthropic`.

## ai.koog.spring.prompt.executor.clients.anthropic.AnthropicLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.anthropic/-anthropic-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/anthropic-llm.properties"]) @EnableConfigurationProperties(value = [AnthropicKoogProperties::class]) class AnthropicLLMAutoConfiguration(properties: AnthropicKoogProperties)
```

Auto-configuration class for Anthropic LLM integration in a Spring Boot application.

This class automatically configures the required beans for interacting with the Anthropic LLM when the appropriate configuration properties are set in the application. It specifically checks for the presence of the ai.koog.anthropic.enabled and ai.koog.anthropic.api-key properties.

Beans provided by this configuration:

AnthropicLLMClient: Configured client for interacting with the Anthropic API.

SingleLLMPromptExecutor: Prompt executor that utilizes the configured Anthropic client.

To enable this configuration, the ai.koog.anthropic.enabled property must be set to true and a valid ai.koog.anthropic.api-key must be provided in the application's property files.

This configuration reads additional properties imported via spring.config.import from the starter's application.properties file and binds them to the AnthropicKoogProperties.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration DeepSeek-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for the DeepSeekKoogProperties class, providing constant values and utilities associated with the configuration of DeepSeek-related properties.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.DeepSeekKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/-deep-seek-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, apiKey: String, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.apiKey

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/api-key.html`

### :koog-spring-boot-starter/main

```kotlin
val apiKey: String
```

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.deepseek", ignoreUnknownFields = true) class DeepSeekKoogProperties(val enabled: Boolean, val apiKey: String, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration properties class for DeepSeek LLM provider integration within the Koog framework.

This class is used to define and manage application-level configuration parameters for connecting to the DeepSeek provider. It includes properties such as API key, base URL, and optional retry settings.

The properties are auto-configured via Spring Boot's @ConfigurationProperties using the ai.koog.deepseek prefix.

Implements the KoogLlmClientProperties interface, which provides base attributes for all LLM client property configurations.

Properties from this class are typically consumed by auto-configuration classes, such as DeepSeekLLMAutoConfiguration, to initialize and configure the necessary beans for working with the DeepSeek API.


Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekLLMAutoConfiguration.DeepSeekLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-l-l-m-auto-configuration/-deep-seek-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: DeepSeekKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekLLMAutoConfiguration.deepSeekExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-l-l-m-auto-configuration/deep-seek-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [DeepSeekLLMClient::class]) fun deepSeekExecutor(client: DeepSeekLLMClient): PromptExecutor
```

Creates a SingleLLMPromptExecutor bean configured to use the DeepSeek LLM client.

This method is only executed if the deepseek.api-key property is defined in the application's configuration. It initializes the DeepSeek client using the provided API key and base URL from the application's properties.

A SingleLLMPromptExecutor initialized with an DeepSeek LLM client.

- properties — The configuration properties for the application, including the DeepSeek client settings.

Referenced packages: `ai.koog.prompt.executor.clients.deepseek`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekLLMAutoConfiguration.deepSeekLLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-l-l-m-auto-configuration/deep-seek-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.deepseek", name = ["enabled"], havingValue = "true") fun deepSeekLLMClient(): DeepSeekLLMClient
```

Creates a DeepSeekLLMClient bean configured with application properties.

This method initializes a DeepSeekLLMClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.deepseek.api-key property is defined and koog.ai.deepseek.enabled property is set to true in the application configuration.

A DeepSeekLLMClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.clients.deepseek`.

## ai.koog.spring.prompt.executor.clients.deepseek.DeepSeekLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.deepseek/-deep-seek-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/deepseek-llm.properties"]) @EnableConfigurationProperties(value = [DeepSeekKoogProperties::class]) class DeepSeekLLMAutoConfiguration(properties: DeepSeekKoogProperties)
```

Auto-configuration class for integrating with the DeepSeek LLM provider within a Spring Boot application.

This configuration enables the auto-wiring of required beans when the appropriate application properties are set. The configuration ensures that the DeepSeekLLMClient is properly initialized and available for usage in the application.

The following conditions must be met for this configuration to be activated:

The property ai.koog.deepseek.api-key must be defined in the application configuration.

The property ai.koog.deepseek.enabled must have a value of true.

Properties used:

ai.koog.deepseek.api-key: API key required to authenticate requests to the DeepSeek API.

ai.koog.deepseek.base-url: Base URL of the DeepSeek API, with a default value of https://api.deepseek.com.

ai.koog.deepseek.retry: Retry configuration settings for failed requests.

Beans provided:

DeepSeekLLMClient: A client for interacting with the DeepSeek API.

SingleLLMPromptExecutor: A bean for executing single-step LLM prompts using the DeepSeek client.

- DeepSeekKoogProperties
- DeepSeekLLMClient
- SingleLLMPromptExecutor
## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration Google-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for the GoogleKoogProperties class, providing constant values and utilities associated with the configuration of Google-related properties.

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.GoogleKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/-google-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, apiKey: String, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```

- enabled — Indicates whether the Google LLM integration is enabled.
- apiKey — The API key used for authenticating requests to Google's services.
- baseUrl — The base URL of the Google LLM API.
- retry — Optional configuration for retrying failed API calls.Usage: These properties are automatically bound to the Spring environment when specified in application configuration (e.g., application.yml or application.properties).Example configuration snippet in application.yml or application.properties:ai.koog.google.enabled=trueai.koog.google.api-key=your-google-api-keyai.koog.google.base-url=https://api.google.com/llmai.koog.google.retry.enabled=trueai.koog.google.retry.max-attempts=3ai.koog.google.retry.initial-delay=2sai.koog.google.retry.max-delay=10sai.koog.google.retry.backoff-multiplier=2.0ai.koog.google.retry.jitter-factor=0.5 Content copied to clipboardAdvanced Features:The retry configuration supports customizable retries for handling transient failures.Dedicated masking utility ensures that sensitive information, such as the API key, is not exposed when serialized or logged.This class is primarily used in conjunction with the GoogleLLMAutoConfiguration auto-configuration class to initialize and configure the necessary beans for interacting with Google's LLM API.For more details on retry behavior, refer to the RetryConfigKoogProperties class. For shared configuration attributes, see the KoogLlmClientProperties interface.

Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.apiKey

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/api-key.html`

### :koog-spring-boot-starter/main

```kotlin
val apiKey: String
```

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.google", ignoreUnknownFields = true) class GoogleKoogProperties(val enabled: Boolean, val apiKey: String, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration properties for integrating with Google's LLM services in the Koog framework.

This class provides the necessary settings for enabling and configuring access to Google's LLM API, including authentication and retry behavior. The configuration is mapped using the prefix ai.koog.google.

Parameters:

- enabled — Indicates whether the Google LLM integration is enabled.
- apiKey — The API key used for authenticating requests to Google's services.
- baseUrl — The base URL of the Google LLM API.
- retry — Optional configuration for retrying failed API calls.Usage: These properties are automatically bound to the Spring environment when specified in application configuration (e.g., application.yml or application.properties).Example configuration snippet in application.yml or application.properties:ai.koog.google.enabled=trueai.koog.google.api-key=your-google-api-keyai.koog.google.base-url=https://api.google.com/llmai.koog.google.retry.enabled=trueai.koog.google.retry.max-attempts=3ai.koog.google.retry.initial-delay=2sai.koog.google.retry.max-delay=10sai.koog.google.retry.backoff-multiplier=2.0ai.koog.google.retry.jitter-factor=0.5 Content copied to clipboardAdvanced Features:The retry configuration supports customizable retries for handling transient failures.Dedicated masking utility ensures that sensitive information, such as the API key, is not exposed when serialized or logged.This class is primarily used in conjunction with the GoogleLLMAutoConfiguration auto-configuration class to initialize and configure the necessary beans for interacting with Google's LLM API.For more details on retry behavior, refer to the RetryConfigKoogProperties class. For shared configuration attributes, see the KoogLlmClientProperties interface.

Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.google.GoogleKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.google.GoogleLLMAutoConfiguration.GoogleLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-l-l-m-auto-configuration/-google-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: GoogleKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.google.GoogleLLMAutoConfiguration.googleExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-l-l-m-auto-configuration/google-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [GoogleLLMClient::class]) fun googleExecutor(client: GoogleLLMClient): PromptExecutor
```

Creates and configures a SingleLLMPromptExecutor instance using GoogleLLMClient properties.

The method initializes an GoogleLLMClient with the base URL derived from the provided OllamaKoogProperties and uses it to construct the SingleLLMPromptExecutor.

a SingleLLMPromptExecutor configured to use the Ollama client.

- properties — the configuration properties containing Ollama client settings such as the base URL.

Referenced packages: `ai.koog.prompt.executor.clients.google`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.prompt.executor.clients.google.GoogleLLMAutoConfiguration.googleLLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-l-l-m-auto-configuration/google-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.google", name = ["enabled"], havingValue = "true") fun googleLLMClient(): GoogleLLMClient
```

Creates a GoogleLLMClient bean configured with application properties.

This method initializes a GoogleLLMClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.google.api-key property is defined and koog.ai.google.enabled property is set to true in the application configuration.

A GoogleLLMClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.clients.google`.

## ai.koog.spring.prompt.executor.clients.google.GoogleLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.google/-google-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/google-llm.properties"]) @EnableConfigurationProperties(value = [GoogleKoogProperties::class]) class GoogleLLMAutoConfiguration(properties: GoogleKoogProperties)
```

Provides the auto-configuration for integrating with Google LLM via the Koog framework. This class is responsible for initializing and configuring the necessary beans for interacting with Google's APIs, based on the configurations supplied via GoogleKoogProperties.

The configuration is activated only when the property ai.koog.google.enabled is set to true, and an api-key is provided.

Beans configured by this class:

GoogleLLMClient: A client for interacting with Google's LLM API, using the specified API key and settings.

SingleLLMPromptExecutor: An executor capable of handling and retrying LLM prompts, using the initialized client.

An external configuration file at classpath:/META-INF/config/koog/google-llm.properties is leveraged for managing default settings.

- GoogleKoogProperties
- GoogleLLMClient
- SingleLLMPromptExecutor
## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration MistralAI-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for the MistralAIKoogProperties class, providing constant values and utilities associated with the configuration of MistralAI-related properties.

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.MistralAIKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/-mistral-a-i-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, apiKey: String, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.apiKey

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/api-key.html`

### :koog-spring-boot-starter/main

```kotlin
val apiKey: String
```

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.mistral", ignoreUnknownFields = true) class MistralAIKoogProperties(val enabled: Boolean, val apiKey: String, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration class for MistralAI settings in the Koog framework. This class defines properties required to configure and use MistralAI-related services, such as API keys, base URLs for the services, and optional retry configurations.

The class is annotated with @ConfigurationProperties to bind its fields to configuration file properties prefixed with ai.koog.mistral.


Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAIKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAILLMAutoConfiguration.MistralAILLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-auto-configuration/-mistral-a-i-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: MistralAIKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAILLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/mistral-llm.properties"]) @EnableConfigurationProperties(value = [MistralAIKoogProperties::class]) class MistralAILLMAutoConfiguration(properties: MistralAIKoogProperties)
```

Auto-configuration class for setting up MistralAI LLM client and related beans. This class utilizes the properties defined in MistralAIKoogProperties to configure and initialize MistralAI-related components, including the client and executor.

The configuration is conditionally applied if the property ai.koog.mistral.api-key is set to true. It reads additional configuration from the properties file located at classpath:/META-INF/config/koog/mistral-llm.properties.

Key Features:

Sets up the MistralAILLMClient bean with API key and base URL from the provided properties.

Configures a SingleLLMPromptExecutor bean using the configured MistralAI client with retry capabilities.

Usage Notes:

To activate, ensure the ai.koog.mistral.api-key property is defined in your application configuration.

Customize behavior and settings using the ai.koog.mistral.* configuration properties.

- MistralAIKoogProperties
- MistralAILLMClient
- SingleLLMPromptExecutor
## ai.koog.spring.prompt.executor.clients.mistralai.MistralAILLMAutoConfiguration.mistralAIExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-auto-configuration/mistral-a-i-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [MistralAILLMClient::class]) fun mistralAIExecutor(client: MistralAILLMClient): PromptExecutor
```

Creates and returns a SingleLLMPromptExecutor bean configured with the given MistralAILLMClient. This bean is conditionally initialized only when an MistralAILLMClient bean is present in the application context.

a configured instance of SingleLLMPromptExecutor.

- client — the MistralAILLMClient used to create a retry-capable client for executing LLM prompts.

Referenced packages: `ai.koog.prompt.executor.clients.mistralai`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.prompt.executor.clients.mistralai.MistralAILLMAutoConfiguration.mistralAILLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.mistralai/-mistral-a-i-l-l-m-auto-configuration/mistral-a-i-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.mistral", name = ["enabled"], havingValue = "true") fun mistralAILLMClient(): MistralAILLMClient
```

Creates an MistralAILLMClient bean configured with application properties.

This method initializes a MistralAILLMClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.mistral.api-key property is defined and koog.ai.mistral.enabled property is set to true in the application configuration.

An MistralAILLMClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.clients.mistralai`.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration Ollama-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for the OllamaKoogProperties class, providing constant values and utilities associated with the configuration of Ollama-related properties.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties.OllamaKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/-ollama-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.ollama", ignoreUnknownFields = true) class OllamaKoogProperties(val enabled: Boolean, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration properties for the Ollama integration in the Koog framework.

This class defines properties that control the connection and behavior when interacting with the Ollama Large Language Model (LLM) service.

These properties are typically configured in the application properties or YAML file.

The configuration prefix for these properties is defined as ai.koog.ollama. It is used to map these properties in the application configuration file.

This class is designed to work along with the OllamaLLMAutoConfiguration class to automatically initialize and configure the required beans for the Ollama client and executor.


Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaLLMAutoConfiguration.OllamaLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-l-l-m-auto-configuration/-ollama-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: OllamaKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.ollama.OllamaLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/ollama-llm.properties"]) @EnableConfigurationProperties(value = [OllamaKoogProperties::class]) class OllamaLLMAutoConfiguration(properties: OllamaKoogProperties)
```

Auto-configuration class for integrating the Ollama Large Language Model (LLM) service into applications.

This configuration initializes and provides the necessary beans to enable interaction with the Ollama LLM API. It relies on properties defined in the OllamaKoogProperties class to set up the service.

The configuration is conditional and will only be initialized if:

OllamaKoogProperties.enabled is set to true.

The required OllamaKoogProperties are provided in the application configuration.

Initializes the following beans:

OllamaClient: A client for interacting with the Ollama LLM service.

SingleLLMPromptExecutor: Executes single-prompt interactions with Ollama, utilizing the client.

This configuration allows seamless integration with the Ollama API while enabling properties-based customization.

- OllamaKoogProperties
- OllamaClient
- SingleLLMPromptExecutor
## ai.koog.spring.prompt.executor.clients.ollama.OllamaLLMAutoConfiguration.ollamaExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-l-l-m-auto-configuration/ollama-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [OllamaClient::class]) fun ollamaExecutor(client: OllamaClient): PromptExecutor
```

Creates and configures an instance of SingleLLMPromptExecutor that wraps the provided OllamaClient. The configured executor includes retry capabilities based on the application's properties.

a SingleLLMPromptExecutor configured to execute LLM prompts with the provided client.

- client — the OllamaClient instance used for communicating with the Ollama LLM service.

Referenced packages: `ai.koog.prompt.executor.model`, `ai.koog.prompt.executor.ollama.client`.

## ai.koog.spring.prompt.executor.clients.ollama.OllamaLLMAutoConfiguration.ollamaLLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.ollama/-ollama-l-l-m-auto-configuration/ollama-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.ollama", name = ["enabled"], havingValue = "true") fun ollamaLLMClient(): OllamaClient
```

Creates an OllamaClient bean configured with application properties.

This method initializes a OllamaClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.ollama.enabled property is set to true in the application configuration.

An OllamaClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.ollama.client`.

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration OpenAI-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for the OpenAIKoogProperties class, providing constant values and utilities associated with the configuration of OpenAI-related properties.

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.OpenAIKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/-open-a-i-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, apiKey: String, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.apiKey

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/api-key.html`

### :koog-spring-boot-starter/main

```kotlin
val apiKey: String
```

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.openai", ignoreUnknownFields = true) class OpenAIKoogProperties(val enabled: Boolean, val apiKey: String, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration class for OpenAI settings in the Koog framework. This class defines properties required to configure and use OpenAI-related services, such as API keys, base URLs for the services, and optional retry configurations.

The class is annotated with @ConfigurationProperties to bind its fields to configuration file properties prefixed with ai.koog.openai.


Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.openai.OpenAIKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.openai.OpenAILLMAutoConfiguration.OpenAILLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-l-l-m-auto-configuration/-open-a-i-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: OpenAIKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.openai.OpenAILLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/openai-llm.properties"]) @EnableConfigurationProperties(value = [OpenAIKoogProperties::class]) class OpenAILLMAutoConfiguration(properties: OpenAIKoogProperties)
```

Auto-configuration class for setting up OpenAI LLM client and related beans. This class utilizes the properties defined in OpenAIKoogProperties to configure and initialize OpenAI-related components, including the client and executor.

The configuration is conditionally applied if the property ai.koog.openai.api-key is set to true. It reads additional configuration from the properties file located at classpath:/META-INF/config/koog/openai-llm.properties.

Key Features:

Sets up the OpenAILLMClient bean with API key and base URL from the provided properties.

Configures a SingleLLMPromptExecutor bean using the configured OpenAI client with retry capabilities.

Usage Notes:

To activate, ensure the ai.koog.openai.api-key property is defined in your application configuration.

Customize behavior and settings using the ai.koog.openai.* configuration properties.

- OpenAIKoogProperties
- OpenAILLMClient
- SingleLLMPromptExecutor
## ai.koog.spring.prompt.executor.clients.openai.OpenAILLMAutoConfiguration.openAIExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-l-l-m-auto-configuration/open-a-i-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [OpenAILLMClient::class]) fun openAIExecutor(client: OpenAILLMClient): PromptExecutor
```

Creates and returns a SingleLLMPromptExecutor bean configured with the given OpenAILLMClient. This bean is conditionally initialized only when an OpenAILLMClient bean is present in the application context.

a configured instance of SingleLLMPromptExecutor.

- client — the OpenAILLMClient used to create a retry-capable client for executing LLM prompts.

Referenced packages: `ai.koog.prompt.executor.clients.openai`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.prompt.executor.clients.openai.OpenAILLMAutoConfiguration.openAILLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openai/-open-a-i-l-l-m-auto-configuration/open-a-i-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.openai", name = ["enabled"], havingValue = "true") fun openAILLMClient(): OpenAILLMClient
```

Creates an OpenAILLMClient bean configured with application properties.

This method initializes a OpenAILLMClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.openai.api-key property is defined and koog.ai.openai.enabled property is set to true in the application configuration.

An OpenAILLMClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.clients.openai`.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.Companion.PREFIX

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/-companion/-p-r-e-f-i-x.html`

### :koog-spring-boot-starter/main

```kotlin
const val PREFIX: String
```

Prefix constant used for configuration OpenRouter-related properties in the Koog framework.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.Companion

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/-companion/index.html`

### :koog-spring-boot-starter/main

```kotlin
object Companion
```

Companion object for the OpenRouterKoogProperties class, providing constant values and utilities associated with the configuration of OpenRouter-related properties.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.OpenRouterKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/-open-router-koog-properties.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(enabled: Boolean, apiKey: String, baseUrl: String, retry: RetryConfigKoogProperties? = null)
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.apiKey

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/api-key.html`

### :koog-spring-boot-starter/main

```kotlin
val apiKey: String
```

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.baseUrl

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/base-url.html`

### :koog-spring-boot-starter/main

```kotlin
open override val baseUrl: String
```

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.enabled

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/enabled.html`

### :koog-spring-boot-starter/main

```kotlin
open override val enabled: Boolean
```

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/index.html`

### :koog-spring-boot-starter/main

```kotlin
@ConfigurationProperties(prefix = "ai.koog.openrouter", ignoreUnknownFields = true) class OpenRouterKoogProperties(val enabled: Boolean, val apiKey: String, val baseUrl: String, val retry: RetryConfigKoogProperties? = null) : KoogLlmClientProperties
```

Configuration properties class for OpenRouter integration within the Koog framework.

This class defines configuration options required for connecting to the OpenRouter service via the Koog framework. It includes parameters such as API key, base URL, enabling or disabling the integration, and retry configuration for handling API requests.

When properly configured in the application properties using the defined prefix, this class allows seamless integration with OpenRouter's LLM services.

Configuration prefix: ai.koog.openrouter


Referenced packages: `ai.koog.spring`, `ai.koog.spring.prompt.executor.clients`.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterKoogProperties.retry

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-koog-properties/retry.html`

### :koog-spring-boot-starter/main

```kotlin
open override val retry: RetryConfigKoogProperties?
```


Referenced packages: `ai.koog.spring`.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterLLMAutoConfiguration.OpenRouterLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-l-l-m-auto-configuration/-open-router-l-l-m-auto-configuration.html`

### :koog-spring-boot-starter/main

```kotlin
constructor(properties: OpenRouterKoogProperties)
```

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterLLMAutoConfiguration

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-l-l-m-auto-configuration/index.html`

### :koog-spring-boot-starter/main

```kotlin
@AutoConfiguration @PropertySource(value = ["classpath:/META-INF/config/koog/openrouter-llm.properties"]) @EnableConfigurationProperties(value = [OpenRouterKoogProperties::class]) class OpenRouterLLMAutoConfiguration(properties: OpenRouterKoogProperties)
```

Auto-configuration class for integrating OpenRouter with Koog framework.

This class enables the automatic configuration of beans and properties to work with OpenRouter's LLM services, provided the application properties have been set with the required prefix and fields.

The configuration is activated only when both ai.koog.openrouter.enabled is set to true and ai.koog.openrouter.api-key is provided in the application properties.

- OpenRouterKoogProperties
- OpenRouterLLMClient
- SingleLLMPromptExecutor
## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterLLMAutoConfiguration.openRouterExecutor

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-l-l-m-auto-configuration/open-router-executor.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnBean(value = [OpenRouterLLMClient::class]) fun openRouterExecutor(client: OpenRouterLLMClient): PromptExecutor
```

Provides a SingleLLMPromptExecutor bean configured with an OpenRouterLLMClient.

The method uses the provided OpenRouterLLMClient to create a retrying client instance based on the configuration in the properties.retry parameter.

- client — The OpenRouterLLMClient instance used to configure the SingleLLMPromptExecutor

Referenced packages: `ai.koog.prompt.executor.clients.openrouter`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.prompt.executor.clients.openrouter.OpenRouterLLMAutoConfiguration.openRouterLLMClient

Module: `koog-spring-boot-starter`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-boot-starter/ai.koog.spring.prompt.executor.clients.openrouter/-open-router-l-l-m-auto-configuration/open-router-l-l-m-client.html`

### :koog-spring-boot-starter/main

```kotlin
@Bean @ConditionalOnProperty(prefix = "ai.koog.openrouter", name = ["enabled"], havingValue = "true") fun openRouterLLMClient(): OpenRouterLLMClient
```

Creates an OpenRouterLLMClient bean configured with application properties.

This method initializes a OpenRouterLLMClient using the API key and base URL specified in the application's configuration. It is only executed if the koog.ai.openrouter.api-key property is defined and koog.ai.openrouter.enabled property is set to true in the application configuration.

An OpenRouterLLMClient instance configured with the provided settings.


Referenced packages: `ai.koog.prompt.executor.clients.openrouter`.
