# koog-spring-ai / koog-spring-ai-starter-model-chat

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.spring.ai.chat.ChatOptionsCustomizer.Companion.NOOP

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-chat-options-customizer/-companion/-n-o-o-p.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@JvmField val NOOP: ChatOptionsCustomizer
```

No-op customizer that returns options unchanged.

## ai.koog.spring.ai.chat.ChatOptionsCustomizer.Companion

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-chat-options-customizer/-companion/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
object Companion
```

A companion object for ChatOptionsCustomizer

## ai.koog.spring.ai.chat.ChatOptionsCustomizer.customize

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-chat-options-customizer/customize.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
abstract fun customize(options: ChatOptions, params: LLMParams, model: LLModel): ChatOptions
```

Customize the given options based on the original Koog params and model.

the customized (or original) org.springframework.ai.chat.prompt.ChatOptions


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.params`.

## ai.koog.spring.ai.chat.ChatOptionsCustomizer

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-chat-options-customizer/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun interface ChatOptionsCustomizer
```

Extension point for provider-specific org.springframework.ai.chat.prompt.ChatOptions customization.

Implement this interface and register it as a Spring bean to apply provider-specific option tuning on top of the default mapping.

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.NamedChatModelConfiguration.NamedChatModelConfiguration

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-named-chat-model-configuration/-named-chat-model-configuration.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
constructor()
```

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.NamedChatModelConfiguration

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-named-chat-model-configuration/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@Configuration(proxyBeanMethods = false) open class NamedChatModelConfiguration
```

Chat model configuration — activated when a bean-name selector property is provided.

Resolves the ChatModel from the application context by the configured bean name.

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.NamedChatModelConfiguration.springAiChatModelLLMClient

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-named-chat-model-configuration/spring-ai-chat-model-l-l-m-client.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@Bean @ConditionalOnMissingBean(name = ["springAiChatModelLLMClient"]) open fun springAiChatModelLLMClient(beanFactory: BeanFactory, properties: KoogSpringAiChatProperties, @Qualifier(value = "koogSpringAiChatDispatcher") dispatcher: CoroutineDispatcher, chatOptionsCustomizerProvider: ObjectProvider<ChatOptionsCustomizer>, llmProviderProvider: ObjectProvider<LLMProvider>, moderationModelProvider: ObjectProvider<ModerationModel>): LLMClient
```


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.SingleChatModelConfiguration.SingleChatModelConfiguration

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-single-chat-model-configuration/-single-chat-model-configuration.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
constructor()
```

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.SingleChatModelConfiguration

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-single-chat-model-configuration/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@Configuration(proxyBeanMethods = false) @ConditionalOnSingleCandidate(value = ChatModel::class) open class SingleChatModelConfiguration
```

Chat model configuration — activated when no bean-name selector is set and a single ChatModel candidate exists.

This is the default fallback path. It is mutually exclusive with NamedChatModelConfiguration for the common cases:

selector absent → ConditionalOnPropertyMissingOrEmpty activates this config; NamedChatModelConfiguration does not match

selector non-empty (e.g. "myBean") → NamedChatModelConfiguration matches; ConditionalOnPropertyMissingOrEmpty does not activate

selector set to literal "" → treated as missing/empty; ConditionalOnPropertyMissingOrEmpty activates this config; NamedChatModelConfiguration does not match

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.SingleChatModelConfiguration.springAiChatModelLLMClient

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-single-chat-model-configuration/spring-ai-chat-model-l-l-m-client.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@Bean @ConditionalOnMissingBean(name = ["springAiChatModelLLMClient"]) open fun springAiChatModelLLMClient(chatModel: ChatModel, beanFactory: BeanFactory, properties: KoogSpringAiChatProperties, @Qualifier(value = "koogSpringAiChatDispatcher") dispatcher: CoroutineDispatcher, chatOptionsCustomizerProvider: ObjectProvider<ChatOptionsCustomizer>, llmProviderProvider: ObjectProvider<LLMProvider>, moderationModelProvider: ObjectProvider<ModerationModel>): LLMClient
```


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.SpringAiChatAutoConfiguration

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/-spring-ai-chat-auto-configuration.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
constructor()
```

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@AutoConfiguration(afterName = ["org.springframework.ai.model.anthropic.autoconfigure.AnthropicChatAutoConfiguration", "org.springframework.ai.model.azure.openai.autoconfigure.AzureOpenAiChatAutoConfiguration", "org.springframework.ai.model.bedrock.converse.autoconfigure.BedrockConverseProxyChatAutoConfiguration", "org.springframework.ai.model.deepseek.autoconfigure.DeepSeekChatAutoConfiguration", "org.springframework.ai.model.google.genai.autoconfigure.chat.GoogleGenAiChatAutoConfiguration", "org.springframework.ai.model.huggingface.autoconfigure.HuggingfaceChatAutoConfiguration", "org.springframework.ai.model.minimax.autoconfigure.MiniMaxChatAutoConfiguration", "org.springframework.ai.model.mistralai.autoconfigure.MistralAiChatAutoConfiguration", "org.springframework.ai.model.oci.genai.autoconfigure.OCIGenAiChatAutoConfiguration", "org.springframework.ai.model.ollama.autoconfigure.OllamaChatAutoConfiguration", "org.springframework.ai.model.openai.autoconfigure.OpenAiChatAutoConfiguration", "org.springframework.ai.model.openaisdk.autoconfigure.OpenAiSdkChatAutoConfiguration", "org.springframework.ai.model.vertexai.autoconfigure.gemini.VertexAiGeminiChatAutoConfiguration", "org.springframework.ai.model.zhipuai.autoconfigure.ZhiPuAiChatAutoConfiguration"]) @EnableConfigurationProperties(value = [KoogSpringAiChatProperties::class]) @ConditionalOnClass(value = [ChatModel::class]) @ConditionalOnProperty(prefix = "koog.spring.ai.chat", name = ["enabled"], havingValue = "true", matchIfMissing = true) open class SpringAiChatAutoConfiguration
```

Auto-configuration for the Koog Spring AI Chat Model adapter.

This configuration:

Binds KoogSpringAiChatProperties under koog.spring.ai.chat.*.

Creates an LLMClient backed by a Spring AI ChatModel when available.

Creates a PromptExecutor when an LLMClient is available.

Supports multi-model contexts via property-based bean-name selection.

Provides an injectable CoroutineDispatcher for blocking model calls.

Optionally injects ModerationModel into the LLMClient bean.

Gated by koog.spring.ai.chat.enabled=true (default).

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.koogPromptExecutor

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/koog-prompt-executor.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@Bean @ConditionalOnBean(value = [LLMClient::class]) @ConditionalOnMissingBean(value = [PromptExecutor::class]) open fun koogPromptExecutor(llmClientsProvider: ObjectProvider<LLMClient>): PromptExecutor
```

Creates a MultiLLMPromptExecutor from all available LLMClient beans.


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.executor.model`.

## ai.koog.spring.ai.chat.SpringAiChatAutoConfiguration.koogSpringAiChatDispatcher

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/-spring-ai-chat-auto-configuration/koog-spring-ai-chat-dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
@Bean @ConditionalOnMissingBean(name = ["koogSpringAiChatDispatcher"]) open fun koogSpringAiChatDispatcher(properties: KoogSpringAiChatProperties, @Qualifier(value = "applicationTaskExecutor") asyncTaskExecutorProvider: ObjectProvider<AsyncTaskExecutor>): CoroutineDispatcher
```

Creates a CoroutineDispatcher for blocking Spring AI chat model calls.

## ai.koog.spring.ai.chat.koogMessageToSpringMessage

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/koog-message-to-spring-message.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun koogMessageToSpringMessage(messages: List<Message>): List<Message>
```

Converts a list of Koog Messages to a list of Spring AI SpringMessages.

the corresponding Spring AI messages

- messages — the Koog messages to convert
- IllegalArgumentException — if a message type is not supported

Referenced packages: `ai.koog.prompt.message`.

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun koogMessageToSpringMessage(message: Message): Message
```

Converts a single Koog Message to a Spring AI SpringMessage.

the corresponding Spring AI message

- message — the Koog message to convert
- NoSuchElementException — if the message produces no Spring AI output (e.g. a Message.User containing only tool results with no text or media content)

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.spring.ai.chat.koogToolDescriptorToToolCallback

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/koog-tool-descriptor-to-tool-callback.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun koogToolDescriptorToToolCallback(descriptor: ToolDescriptor): ToolCallback
```

Converts a Koog ToolDescriptor to a Spring AI ToolCallback.

The returned callback carries the tool definition (name, description, JSON schema) but its ToolCallback.call method always throws IllegalStateException. This is by design: in KOOG execution mode, tools are executed by the Koog agent framework, not by Spring AI. The internalToolExecutionEnabled=false option prevents Spring from ever calling this method. If it is called anyway, the error message provides clear guidance on the misconfiguration.

the corresponding Spring AI tool callback (definition-only, non-executable)

- descriptor — the Koog tool descriptor to convert

Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.spring.ai.chat.springGenerationToKoogResponses

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/spring-generation-to-koog-responses.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun springGenerationToKoogResponses(generation: Generation, clock: KoogClock = KoogClock.System, usage: Usage? = null): Message.Assistant
```

Converts a Spring AI Generation (from a org.springframework.ai.chat.model.ChatResponse) to a Koog Message.Assistant.

If the generation contains tool calls, each tool call is converted to a MessagePart.Tool.Call. Otherwise, the text content is converted to a MessagePart.Text.

a Koog Message.Assistant

- generation — the Spring AI generation to convert
- clock — the clock to use for creating response metadata timestamps
- usage — optional token usage information from the chat response metadata

Referenced packages: `ai.koog.prompt.message`, `ai.koog.utils.time`.

## ai.koog.spring.ai.chat.springModerationResultToKoogModerationResult

Module: `koog-spring-ai-starter-model-chat`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-chat/ai.koog.spring.ai.chat/spring-moderation-result-to-koog-moderation-result.html`

### :koog-spring-ai:koog-spring-ai-starter-model-chat/main

```kotlin
fun springModerationResultToKoogModerationResult(springResult: Moderation): ModerationResult
```

Converts a Spring AI SpringModeration to a Koog ModerationResult.

Maps all 11 Spring AI moderation categories to their Koog counterparts, carrying both the detected flag and the confidence score.

If the Spring AI result contains no individual results, returns a non-harmful ModerationResult with an empty category map.

the corresponding Koog moderation result

- springResult — the Spring AI moderation result to convert

Referenced packages: `ai.koog.prompt.dsl`.
