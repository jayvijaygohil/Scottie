# koog-spring-ai-v2 / koog-spring-ai-v2-starter-chat-memory

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.NamedChatMemoryRepositoryConfiguration.NamedChatMemoryRepositoryConfiguration

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-named-chat-memory-repository-configuration/-named-chat-memory-repository-configuration.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
constructor()
```

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.NamedChatMemoryRepositoryConfiguration

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-named-chat-memory-repository-configuration/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@Configuration(proxyBeanMethods = false) open class NamedChatMemoryRepositoryConfiguration
```

Chat memory repository configuration — activated when a bean-name selector property is provided.

Resolves the ChatMemoryRepository from the application context by the configured bean name.

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.NamedChatMemoryRepositoryConfiguration.springAiChatHistoryProvider

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-named-chat-memory-repository-configuration/spring-ai-chat-history-provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@Bean @ConditionalOnMissingBean(value = [ChatHistoryProvider::class]) open fun springAiChatHistoryProvider(beanFactory: BeanFactory, properties: KoogSpringAiChatMemoryProperties, @Qualifier(value = "koogSpringAiChatMemoryDispatcher") dispatcher: CoroutineDispatcher): ChatHistoryProvider
```


Referenced packages: `ai.koog.agents.chat-memory.feature`.

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.SingleChatMemoryRepositoryConfiguration.SingleChatMemoryRepositoryConfiguration

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-single-chat-memory-repository-configuration/-single-chat-memory-repository-configuration.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
constructor()
```

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.SingleChatMemoryRepositoryConfiguration

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-single-chat-memory-repository-configuration/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@Configuration(proxyBeanMethods = false) @ConditionalOnSingleCandidate(value = ChatMemoryRepository::class) open class SingleChatMemoryRepositoryConfiguration
```

Chat memory repository configuration — activated when no bean-name selector is set and a single ChatMemoryRepository candidate exists.

This is the default fallback path. It is mutually exclusive with NamedChatMemoryRepositoryConfiguration for the common cases:

selector absent → ConditionalOnPropertyMissingOrEmpty activates this config; NamedChatMemoryRepositoryConfiguration does not match

selector non-empty (e.g. "myBean") → NamedChatMemoryRepositoryConfiguration matches; ConditionalOnPropertyMissingOrEmpty does not activate

selector set to literal "" → treated as missing/empty; ConditionalOnPropertyMissingOrEmpty activates this config; NamedChatMemoryRepositoryConfiguration does not match

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.SingleChatMemoryRepositoryConfiguration.springAiChatHistoryProvider

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-single-chat-memory-repository-configuration/spring-ai-chat-history-provider.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@Bean @ConditionalOnMissingBean(value = [ChatHistoryProvider::class]) open fun springAiChatHistoryProvider(repository: ChatMemoryRepository, @Qualifier(value = "koogSpringAiChatMemoryDispatcher") dispatcher: CoroutineDispatcher): ChatHistoryProvider
```


Referenced packages: `ai.koog.agents.chat-memory.feature`.

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.SpringAiChatMemoryAutoConfiguration

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/-spring-ai-chat-memory-auto-configuration.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
constructor()
```

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@AutoConfiguration(afterName = ["org.springframework.ai.model.chat.memory.repository.cassandra.autoconfigure.CassandraChatMemoryRepositoryAutoConfiguration", "org.springframework.ai.model.chat.memory.repository.cosmosdb.autoconfigure.CosmosDBChatMemoryRepositoryAutoConfiguration", "org.springframework.ai.model.chat.memory.repository.jdbc.autoconfigure.JdbcChatMemoryRepositoryAutoConfiguration", "org.springframework.ai.model.chat.memory.repository.neo4j.autoconfigure.Neo4jChatMemoryRepositoryAutoConfiguration", "org.springframework.ai.model.chat.memory.repository.mongo.autoconfigure.MongoChatMemoryAutoConfiguration"]) @EnableConfigurationProperties(value = [KoogSpringAiChatMemoryProperties::class]) @ConditionalOnClass(value = [ChatMemoryRepository::class]) @ConditionalOnProperty(prefix = "koog.spring.ai.chat-memory", name = ["enabled"], havingValue = "true", matchIfMissing = true) open class SpringAiChatMemoryAutoConfiguration
```

Auto-configuration for the Koog Spring AI Chat Memory adapter.

This configuration:

Binds KoogSpringAiChatMemoryProperties under koog.spring.ai.chat-memory.*.

Creates a ChatHistoryProvider backed by a Spring AI ChatMemoryRepository when available.

Supports multi-repository contexts via property-based bean-name selection.

Provides an injectable CoroutineDispatcher for blocking repository calls.

Gated by koog.spring.ai.chat-memory.enabled=true (default).

## ai.koog.spring.ai.memory.SpringAiChatMemoryAutoConfiguration.koogSpringAiChatMemoryDispatcher

Module: `koog-spring-ai-v2-starter-chat-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-chat-memory/ai.koog.spring.ai.memory/-spring-ai-chat-memory-auto-configuration/koog-spring-ai-chat-memory-dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-chat-memory/main

```kotlin
@Bean @ConditionalOnMissingBean(name = ["koogSpringAiChatMemoryDispatcher"]) open fun koogSpringAiChatMemoryDispatcher(properties: KoogSpringAiChatMemoryProperties, @Qualifier(value = "applicationTaskExecutor") asyncTaskExecutorProvider: ObjectProvider<AsyncTaskExecutor>): CoroutineDispatcher
```

Creates a CoroutineDispatcher for blocking Spring AI chat memory repository calls.
