# koog-spring-ai / koog-spring-ai-starter-model-embedding

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.NamedEmbeddingModelConfiguration.NamedEmbeddingModelConfiguration

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-named-embedding-model-configuration/-named-embedding-model-configuration.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
constructor()
```

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.NamedEmbeddingModelConfiguration

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-named-embedding-model-configuration/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@Configuration(proxyBeanMethods = false) open class NamedEmbeddingModelConfiguration
```

Embedding model configuration — activated when a bean-name selector is provided.

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.NamedEmbeddingModelConfiguration.springAiEmbeddingModelLLMEmbeddingProvider

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-named-embedding-model-configuration/spring-ai-embedding-model-l-l-m-embedding-provider.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@Bean @ConditionalOnMissingBean(value = [LLMEmbeddingProvider::class]) open fun springAiEmbeddingModelLLMEmbeddingProvider(beanFactory: BeanFactory, properties: KoogSpringAiEmbeddingProperties, @Qualifier(value = "koogSpringAiEmbeddingDispatcher") dispatcher: CoroutineDispatcher): LLMEmbeddingProvider
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.SingleEmbeddingModelConfiguration.SingleEmbeddingModelConfiguration

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-single-embedding-model-configuration/-single-embedding-model-configuration.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
constructor()
```

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.SingleEmbeddingModelConfiguration

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-single-embedding-model-configuration/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@Configuration(proxyBeanMethods = false) @ConditionalOnSingleCandidate(value = EmbeddingModel::class) open class SingleEmbeddingModelConfiguration
```

Embedding model configuration — activated when no bean-name selector is set and a single EmbeddingModel candidate exists.

This is the default fallback path. It is mutually exclusive with NamedEmbeddingModelConfiguration for the common cases:

selector absent → ConditionalOnPropertyMissingOrEmpty activates this config; NamedEmbeddingModelConfiguration does not match

selector non-empty (e.g. "myBean") → NamedEmbeddingModelConfiguration matches; ConditionalOnPropertyMissingOrEmpty does not activate

selector set to literal "" → treated as missing/empty; ConditionalOnPropertyMissingOrEmpty activates this config; NamedEmbeddingModelConfiguration does not match

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.SingleEmbeddingModelConfiguration.springAiEmbeddingModelLLMEmbeddingProvider

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-single-embedding-model-configuration/spring-ai-embedding-model-l-l-m-embedding-provider.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@Bean @ConditionalOnMissingBean(value = [LLMEmbeddingProvider::class]) open fun springAiEmbeddingModelLLMEmbeddingProvider(embeddingModel: EmbeddingModel, @Qualifier(value = "koogSpringAiEmbeddingDispatcher") dispatcher: CoroutineDispatcher): LLMEmbeddingProvider
```


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.SpringAiEmbeddingAutoConfiguration

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/-spring-ai-embedding-auto-configuration.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
constructor()
```

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/index.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@AutoConfiguration(afterName = ["org.springframework.ai.model.anthropic.autoconfigure.AnthropicEmbeddingAutoConfiguration", "org.springframework.ai.model.azure.openai.autoconfigure.AzureOpenAiEmbeddingAutoConfiguration", "org.springframework.ai.model.bedrock.cohere.autoconfigure.BedrockCohereEmbeddingAutoConfiguration", "org.springframework.ai.model.bedrock.titan.autoconfigure.BedrockTitanEmbeddingAutoConfiguration", "org.springframework.ai.model.google.genai.autoconfigure.embedding.GoogleGenAiTextEmbeddingAutoConfiguration", "org.springframework.ai.model.huggingface.autoconfigure.HuggingfaceEmbeddingAutoConfiguration", "org.springframework.ai.model.mistralai.autoconfigure.MistralAiEmbeddingAutoConfiguration", "org.springframework.ai.model.oci.genai.autoconfigure.OCIGenAiEmbeddingAutoConfiguration", "org.springframework.ai.model.ollama.autoconfigure.OllamaEmbeddingAutoConfiguration", "org.springframework.ai.model.openai.autoconfigure.OpenAiEmbeddingAutoConfiguration", "org.springframework.ai.model.transformers.autoconfigure.TransformersEmbeddingModelAutoConfiguration", "org.springframework.ai.model.vertexai.autoconfigure.embedding.VertexAiTextEmbeddingAutoConfiguration", "org.springframework.ai.model.zhipuai.autoconfigure.ZhiPuAiEmbeddingAutoConfiguration"]) @EnableConfigurationProperties(value = [KoogSpringAiEmbeddingProperties::class]) @ConditionalOnClass(value = [EmbeddingModel::class]) @ConditionalOnProperty(prefix = "koog.spring.ai.embedding", name = ["enabled"], havingValue = "true", matchIfMissing = true) open class SpringAiEmbeddingAutoConfiguration
```

Auto-configuration for the Koog Spring AI Embedding Model adapter.

This configuration:

Binds KoogSpringAiEmbeddingProperties under koog.spring.ai.embedding.*.

Creates an LLMEmbeddingProvider backed by a Spring AI EmbeddingModel when available.

Supports multi-model contexts via property-based bean-name selection.

Provides an injectable CoroutineDispatcher for blocking model calls.

Gated by koog.spring.ai.embedding.enabled=true (default).

## ai.koog.spring.ai.embedding.SpringAiEmbeddingAutoConfiguration.koogSpringAiEmbeddingDispatcher

Module: `koog-spring-ai-starter-model-embedding`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai/koog-spring-ai-starter-model-embedding/ai.koog.spring.ai.embedding/-spring-ai-embedding-auto-configuration/koog-spring-ai-embedding-dispatcher.html`

### :koog-spring-ai:koog-spring-ai-starter-model-embedding/main

```kotlin
@Bean @ConditionalOnMissingBean(name = ["koogSpringAiEmbeddingDispatcher"]) open fun koogSpringAiEmbeddingDispatcher(properties: KoogSpringAiEmbeddingProperties, @Qualifier(value = "applicationTaskExecutor") asyncTaskExecutorProvider: ObjectProvider<AsyncTaskExecutor>): CoroutineDispatcher
```

Creates a CoroutineDispatcher for blocking Spring AI embedding model calls.
