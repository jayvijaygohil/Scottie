# koog-spring-ai-v2 / koog-spring-ai-v2-starter-vector-store

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.spring.ai.vectorstore.KoogVectorStoreException.KoogVectorStoreException

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-vector-store-exception/-koog-vector-store-exception.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor(operation: String, message: String? = null, cause: Throwable? = null)
```

- operation — a short label describing the failed operation (e.g. "add", "search", "delete")
- message — human-readable description of the failure
- cause — the original exception, if any
## ai.koog.spring.ai.vectorstore.KoogVectorStoreException

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-koog-vector-store-exception/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
class KoogVectorStoreException(operation: String, message: String? = null, cause: Throwable? = null) : Exception
```

Exception thrown when a Koog vector-store operation fails.

Wraps backend provider errors and filter-expression parsing failures with operation context so that callers receive a consistent, Koog-specific exception type instead of raw backend exceptions.

- operation — a short label describing the failed operation (e.g. "add", "search", "delete")
- message — human-readable description of the failure
- cause — the original exception, if any
## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.NamedVectorStoreConfiguration.NamedVectorStoreConfiguration

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-named-vector-store-configuration/-named-vector-store-configuration.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor()
```

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.NamedVectorStoreConfiguration

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-named-vector-store-configuration/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@Configuration(proxyBeanMethods = false) open class NamedVectorStoreConfiguration
```

VectorStore configuration — activated when a bean-name selector is provided.

Resolves the VectorStore from the application context by the configured bean name.

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.NamedVectorStoreConfiguration.springAiKoogVectorStore

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-named-vector-store-configuration/spring-ai-koog-vector-store.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@Bean @ConditionalOnMissingBean(value = [KoogVectorStore::class]) open fun springAiKoogVectorStore(beanFactory: BeanFactory, properties: KoogSpringAiVectorStoreProperties, @Qualifier(value = "koogSpringAiVectorStoreDispatcher") dispatcher: CoroutineDispatcher): KoogVectorStore
```

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.SingleVectorStoreConfiguration.SingleVectorStoreConfiguration

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-single-vector-store-configuration/-single-vector-store-configuration.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor()
```

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.SingleVectorStoreConfiguration

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-single-vector-store-configuration/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@Configuration(proxyBeanMethods = false) @ConditionalOnSingleCandidate(value = VectorStore::class) open class SingleVectorStoreConfiguration
```

VectorStore configuration — activated when no bean-name selector is set and a single VectorStore candidate exists.

This is the default fallback path. It is mutually exclusive with NamedVectorStoreConfiguration for the common cases:

selector absent → ConditionalOnPropertyMissingOrEmpty activates this config; NamedVectorStoreConfiguration does not match

selector non-empty (e.g. "myBean") → NamedVectorStoreConfiguration matches; ConditionalOnPropertyMissingOrEmpty does not activate

selector set to literal "" → treated as missing/empty; ConditionalOnPropertyMissingOrEmpty activates this config; NamedVectorStoreConfiguration does not match

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.SingleVectorStoreConfiguration.springAiKoogVectorStore

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-single-vector-store-configuration/spring-ai-koog-vector-store.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@Bean @ConditionalOnMissingBean(value = [KoogVectorStore::class]) open fun springAiKoogVectorStore(vectorStore: VectorStore, @Qualifier(value = "koogSpringAiVectorStoreDispatcher") dispatcher: CoroutineDispatcher): KoogVectorStore
```

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.SpringAiVectorStoreAutoConfiguration

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/-spring-ai-vector-store-auto-configuration.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
constructor()
```

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/index.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@AutoConfiguration(afterName = ["org.springframework.ai.vectorstore.azure.autoconfigure.AzureVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.cosmosdb.autoconfigure.CosmosDBVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.cassandra.autoconfigure.CassandraVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.couchbase.autoconfigure.CouchbaseSearchVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.chroma.autoconfigure.ChromaVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.elasticsearch.autoconfigure.ElasticsearchVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.gemfire.autoconfigure.GemFireVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.milvus.autoconfigure.MilvusVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.mongodb.autoconfigure.MongoDBAtlasVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.neo4j.autoconfigure.Neo4jVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.opensearch.autoconfigure.OpenSearchVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.oracle.autoconfigure.OracleVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.pgvector.autoconfigure.PgVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.pinecone.autoconfigure.PineconeVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.qdrant.autoconfigure.QdrantVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.redis.autoconfigure.RedisVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.typesense.autoconfigure.TypesenseVectorStoreAutoConfiguration", "org.springframework.ai.vectorstore.weaviate.autoconfigure.WeaviateVectorStoreAutoConfiguration"]) @EnableConfigurationProperties(value = [KoogSpringAiVectorStoreProperties::class]) @ConditionalOnClass(value = [VectorStore::class]) @ConditionalOnProperty(prefix = "koog.spring.ai.vectorstore", name = ["enabled"], havingValue = "true", matchIfMissing = true) open class SpringAiVectorStoreAutoConfiguration
```

Auto-configuration for adapting a Spring AI VectorStore to Koog storage abstractions.

This configuration:

Binds KoogSpringAiVectorStoreProperties under koog.spring.ai.vectorstore.*.

Creates a KoogVectorStore backed by a Spring AI VectorStore when available.

Supports multi-store contexts via property-based bean-name selection.

Provides an injectable CoroutineDispatcher for blocking vector-store calls.

Gated by koog.spring.ai.vectorstore.enabled=true (default).

## ai.koog.spring.ai.vectorstore.SpringAiVectorStoreAutoConfiguration.koogSpringAiVectorStoreDispatcher

Module: `koog-spring-ai-v2-starter-vector-store`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-spring-ai-v2/koog-spring-ai-v2-starter-vector-store/ai.koog.spring.ai.vectorstore/-spring-ai-vector-store-auto-configuration/koog-spring-ai-vector-store-dispatcher.html`

### :koog-spring-ai-v2:koog-spring-ai-v2-starter-vector-store/main

```kotlin
@Bean @ConditionalOnMissingBean(name = ["koogSpringAiVectorStoreDispatcher"]) open fun koogSpringAiVectorStoreDispatcher(properties: KoogSpringAiVectorStoreProperties, @Qualifier(value = "applicationTaskExecutor") asyncTaskExecutorProvider: ObjectProvider<AsyncTaskExecutor>): CoroutineDispatcher
```

Creates a CoroutineDispatcher for blocking Spring AI vector-store calls.

Dispatcher selection is controlled by KoogSpringAiVectorStoreProperties.dispatcher:

ai.koog.spring.ai.common.DispatcherType.AUTO: uses Spring's AsyncTaskExecutor when available (e.g. virtual-thread executor with spring.threads.virtual.enabled=true), otherwise falls back to Dispatchers.IO.

ai.koog.spring.ai.common.DispatcherType.IO: always uses Dispatchers.IO, optionally limited to dispatcher.parallelism threads.
