# Executor response caches

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.prompt.cache.files.FilePromptCache.Factory.Factory

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/-factory/-factory.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
constructor(default: Path)
```

Initializes the factory with a default Path to be used when specific configurations are not provided.

- default — The default Path for the file cache if none is specified in the configuration.
## ai.koog.prompt.cache.files.FilePromptCache.Factory.create

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/-factory/create.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
open override fun create(config: String): PromptCache
```


Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.files.FilePromptCache.Factory

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/-factory/index.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
class Factory(default: Path) : PromptCache.Factory.Named
```

Factory implementation for creating FilePromptCache instances based on the provided configuration.

This class inherits from PromptCache.Factory.Named and is used to build a file-based cache for storing prompt execution results. The cache location and optional configurations are derived from the input configuration string.

- default — The default Path for the file cache if none is specified in the configuration.

Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.files.FilePromptCache.FilePromptCache

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/-file-prompt-cache.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
constructor(storage: Path, maxFiles: Int? = 3000)
```

- storage — The directory where cache files will be stored
- maxFiles — The maximum number of files to store in the cache (default: 3000). When this limit is reached, the least recently accessed files will be removed.
## ai.koog.prompt.cache.files.FilePromptCache.get

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/get.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
open suspend override fun get(request: PromptCache.Request): Message.Assistant?
```


Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.cache.files.FilePromptCache

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/index.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
class FilePromptCache(storage: Path, maxFiles: Int? = 3000) : PromptCache
```

File-based implementation of PromptCache. This implementation stores cache entries in files on the file system.

- storage — The directory where cache files will be stored
- maxFiles — The maximum number of files to store in the cache (default: 3000). When this limit is reached, the least recently accessed files will be removed.

Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.files.FilePromptCache.put

Module: `prompt-cache-files`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-files/ai.koog.prompt.cache.files/-file-prompt-cache/put.html`

### :prompt:prompt-cache:prompt-cache-files/jvmMain

```kotlin
open suspend override fun put(request: PromptCache.Request, response: Message.Assistant)
```


Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.cache.memory.InMemoryPromptCache.Companion.create

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.memory/-in-memory-prompt-cache/-companion/create.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
open override fun create(config: String): PromptCache
```

Creates a new instance of PromptCache based on the provided configuration string.

An instance of PromptCache tailored to the provided configuration.

- config — The configuration string used to determine how the PromptCache instance is created.

Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.memory.InMemoryPromptCache.Companion

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.memory/-in-memory-prompt-cache/-companion/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
object Companion : PromptCache.Factory.Named
```

A companion object implementation of the PromptCache.Factory.Named specialized for an in-memory prompt cache. This factory is responsible for creating instances of InMemoryPromptCache based on a specific configuration string.

The factory expects the configuration string to begin with "memory", followed by an optional size limit. The size limit may either be omitted, set to "unlimited", or represented as a numeric value indicating the maximum number of entries in the cache.


Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.memory.InMemoryPromptCache.InMemoryPromptCache

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.memory/-in-memory-prompt-cache/-in-memory-prompt-cache.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
constructor(maxEntries: Int?)
```

## ai.koog.prompt.cache.memory.InMemoryPromptCache.get

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.memory/-in-memory-prompt-cache/get.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
open suspend override fun get(request: PromptCache.Request): Message.Assistant?
```

Get a cached response for a request, or null if not cached.

The cached response, or null if not cached

- request — The request to get the cached response for

Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.cache.memory.InMemoryPromptCache

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.memory/-in-memory-prompt-cache/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
class InMemoryPromptCache(maxEntries: Int?) : PromptCache
```

In-memory implementation of PromptCache. This implementation stores cache entries in memory.


Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.memory.InMemoryPromptCache.put

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.memory/-in-memory-prompt-cache/put.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
open suspend override fun put(request: PromptCache.Request, response: Message.Assistant)
```

Put a response in the cache for a request.

- request — The request to cache the response for
- response — The response to cache

Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.cache.model.PromptCache.Factory.Aggregated.Aggregated

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-aggregated/-aggregated.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
constructor(factories: List<PromptCache.Factory.Named>)
```

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
constructor(vararg factories: PromptCache.Factory.Named)
```

Secondary constructor for the Aggregated class.

This constructor allows the creation of an Aggregated instance using a variable number of Factory.Named objects. Internally, the provided objects are converted into a list and passed to the primary constructor.

- factories — A variable number of Factory.Named instances to be included in the Aggregated instance.
## ai.koog.prompt.cache.model.PromptCache.Factory.Aggregated.create

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-aggregated/create.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
open override fun create(config: String): PromptCache
```

Creates a new instance of PromptCache based on the provided configuration string.

An instance of PromptCache tailored to the provided configuration.

- config — The configuration string used to determine how the PromptCache instance is created.
## ai.koog.prompt.cache.model.PromptCache.Factory.Aggregated

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-aggregated/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
class Aggregated(factories: List<PromptCache.Factory.Named>) : PromptCache.Factory
```

A PromptCache.Factory implementation that aggregates multiple Factory.Named instances.

The Aggregated class provides a way to combine multiple named factories and attempts to create a PromptCache using the first factory that supports a given configuration.

## ai.koog.prompt.cache.model.PromptCache.Factory.Named.Named

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-named/-named.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.prompt.cache.model.PromptCache.Factory.Named

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-named/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
abstract class Named(val name: String) : PromptCache.Factory
```

Represents an abstract factory with a specific name for creating PromptCache instances.

This class is designed to be extended by concrete implementations that register themselves with a unique name, allowing them to support specific configurations. It provides a utility method to determine if the factory can handle a given configuration string based on its name.

- Companion
## ai.koog.prompt.cache.model.PromptCache.Factory.Named.name

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-named/name.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
val name: String
```

## ai.koog.prompt.cache.model.PromptCache.Factory.Named.supports

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/-named/supports.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
fun supports(config: String): Boolean
```

Determines if the current factory instance can support the provided configuration string.

The method checks if the factory's name matches the first element of the parsed configuration string.

true if the factory supports the configuration, otherwise false.

- config — The configuration string to be evaluated.
## ai.koog.prompt.cache.model.PromptCache.Factory.create

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/create.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
abstract fun create(config: String): PromptCache
```

Creates a new instance of PromptCache based on the provided configuration string.

An instance of PromptCache tailored to the provided configuration.

- config — The configuration string used to determine how the PromptCache instance is created.
## ai.koog.prompt.cache.model.PromptCache.Factory.elements

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/elements.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
open fun elements(config: String): List<String>
```

Splits the given configuration string into a list of elements using ':' as the primary delimiter, while correctly handling nested structures indicated by curly braces '{' and '}'.

A list of strings representing the parsed elements in the configuration, preserving nested structures as single elements.

- config — The configuration string to be parsed. This string may include nested structures enclosed in braces.
## ai.koog.prompt.cache.model.PromptCache.Factory

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-factory/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
interface Factory
```

Represents a factory interface for creating instances of PromptCache. Factories implementing this interface are designed to construct specific types of prompt caches based on a provided configuration string.

- Aggregated
- Named
## ai.koog.prompt.cache.model.PromptCache.Request.Companion.create

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-request/-companion/create.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
fun create(prompt: Prompt, tools: List<ToolDescriptor>): PromptCache.Request
```

Creates a new Request instance with the provided prompt and a list of tools.

A new Request instance initialized with the given prompt and tool data.

- prompt — The Prompt object containing the messages, ID, and parameters to construct the request.
- tools — A list of ToolDescriptor objects to be included in the request. Each tool is converted to a JSON representation.

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`.

## ai.koog.prompt.cache.model.PromptCache.Request.Companion

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-request/-companion/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
object Companion
```

Companion object for the Request class, providing factory functions and utility methods.

## ai.koog.prompt.cache.model.PromptCache.Request.asCacheKey

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-request/as-cache-key.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
val asCacheKey: String
```

A unique identifier for the cache entry derived from the request's prompt and tools. This value is used by caching mechanisms to store and retrieve cached responses.

## ai.koog.prompt.cache.model.PromptCache.Request

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-request/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
@Serializable class Request
```

Represents a request to be cached, consisting of a prompt and optional tools. This class is used by PromptCache implementations to store and retrieve cached responses.

## ai.koog.prompt.cache.model.PromptCache.Request.prompt

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-request/prompt.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
val prompt: Prompt
```


Referenced packages: `ai.koog.prompt`.

## ai.koog.prompt.cache.model.PromptCache.Request.toolJsons

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/-request/tool-jsons.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
val toolJsons: List<JsonObject>
```

## ai.koog.prompt.cache.model.PromptCache.get

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/get.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
abstract suspend fun get(request: PromptCache.Request): Message.Assistant?
```

Get a cached response for a request, or null if not cached.

The cached response, or null if not cached

- request — The request to get the cached response for

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.cache.model.PromptCache

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/index.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
interface PromptCache
```

Interface for caching prompt execution results. Implementations should provide a way to store and retrieve prompt execution results.

- InMemoryPromptCache
## ai.koog.prompt.cache.model.PromptCache.put

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/-prompt-cache/put.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
abstract suspend fun put(request: PromptCache.Request, response: Message.Assistant)
```

Put a response in the cache for a request.

- request — The request to cache the response for
- response — The response to cache

Referenced packages: `ai.koog.prompt.message`.

## ai.koog.prompt.cache.model.get

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/get.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
suspend fun PromptCache.get(prompt: Prompt, tools: List<ToolDescriptor>, clock: KoogClock = KoogClock.System): Message.Assistant?
```

Get a cached response for a prompt with tools, or null if not cached.

The cached response, or null if not cached

- prompt — The prompt to get the cached response for
- tools — The tools used with the prompt

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.message`, `ai.koog.utils.time`.

## ai.koog.prompt.cache.model.put

Module: `prompt-cache-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-model/ai.koog.prompt.cache.model/put.html`

### :prompt:prompt-cache:prompt-cache-model/commonMain

```kotlin
suspend fun PromptCache.put(prompt: Prompt, tools: List<ToolDescriptor>, response: Message.Assistant)
```

Put a response in the cache for a prompt with tools.

- prompt — The prompt to cache the response for
- tools — The tools used with the prompt
- response — The response to cache

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.message`.

## ai.koog.prompt.cache.redis.RedisCacheException.RedisCacheException

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-cache-exception/-redis-cache-exception.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
constructor(message: String, cause: Throwable? = null)
```

## ai.koog.prompt.cache.redis.RedisCacheException

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-cache-exception/index.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
class RedisCacheException(message: String, cause: Throwable? = null) : Exception
```

Exception thrown when there is an error with Redis cache operations.

## ai.koog.prompt.cache.redis.RedisPromptCache.Companion.create

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/-companion/create.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
open override fun create(config: String): PromptCache
```


Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.redis.RedisPromptCache.Companion

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/-companion/index.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
object Companion : PromptCache.Factory.Named
```

Companion object for the RedisPromptCache class, functioning as a factory for creating Redis-backed implementations of the PromptCache interface.

This factory is identified by the name "redis" and is responsible for parsing a configuration string to initialize a RedisPromptCache instance with the specified properties such as Redis URI, cache key prefix, and cache expiration time-to-live (TTL).

The companion object extends the PromptCache.Factory.Named class to associate the factory with the specific name "redis" and implements the create method to generate instances of RedisPromptCache.

Constants:

DEFAULT_URI: Default URI for connecting to Redis, used if no URI is provided in the configuration.

CACHE_KEY_PREFIX: Default prefix for cache keys, used if no prefix is specified in the configuration.

Properties:

logger: Logger instance for logging operations related to the RedisPromptCache.

Methods:

create(config: String): Parses the provided configuration string to extract Redis URI, cache key prefix, and TTL, and returns a new RedisPromptCache instance initialized with these properties. Throws an exception if the cache type is not "redis".


Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.redis.RedisPromptCache.RedisPromptCache

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/-redis-prompt-cache.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
constructor(client: RedisClient, prefix: String, ttl: Duration)
```

- client — The Redis client to use for connecting to Redis
### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
constructor(client: RedisClient, prefix: String, ttl: Duration)
```

- client — The Redis client to use for connecting to Redis
- prefix — The prefix for cache keys
## ai.koog.prompt.cache.redis.RedisPromptCache.close

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/close.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
fun close()
```

Closes the Redis connection. This method should be called when the cache is no longer needed.

## ai.koog.prompt.cache.redis.RedisPromptCache.get

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/get.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
open suspend override fun get(request: PromptCache.Request): Message.Assistant?
```


Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.cache.redis.RedisPromptCache

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/index.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
class RedisPromptCache(client: RedisClient, prefix: String, ttl: Duration) : PromptCache
```

Redis-based implementation of PromptCache. This implementation stores cache entries in a Redis database.

- client — The Redis client to use for connecting to Redis

Referenced packages: `ai.koog.prompt.cache.model`.

## ai.koog.prompt.cache.redis.RedisPromptCache.put

Module: `prompt-cache-redis`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-cache/prompt-cache-redis/ai.koog.prompt.cache.redis/-redis-prompt-cache/put.html`

### :prompt:prompt-cache:prompt-cache-redis/jvmMain

```kotlin
open suspend override fun put(request: PromptCache.Request, response: Message.Assistant)
```


Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.CachedPromptExecutor

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/-cached-prompt-executor.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
constructor(cache: PromptCache, nested: PromptExecutor, clock: KoogClock = KoogClock.System)
```

- cache — The cache implementation to use
- nested — The nested executor to use for cache misses

Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.close

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/close.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.cached.CachedPromptExecutor.executeStreaming

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.execute

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/execute.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Message.Assistant
```


Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.getBasicJsonSchemaGenerator

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(model: LLModel): BasicJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.getStandardJsonSchemaGenerator

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(model: LLModel): StandardJsonSchemaGenerator
```


Referenced packages: `ai.koog.prompt.llm`, `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/index.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
class CachedPromptExecutor(cache: PromptCache, nested: PromptExecutor, clock: KoogClock = KoogClock.System) : PromptExecutor
```

A CodePromptExecutor that caches responses from a nested executor.

- cache — The cache implementation to use
- nested — The nested executor to use for cache misses

Referenced packages: `ai.koog.prompt.cache.model`, `ai.koog.prompt.executor.model`, `ai.koog.utils.time`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.models

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/models.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.cached.CachedPromptExecutor.moderate

Module: `prompt-executor-cached`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-cached/ai.koog.prompt.executor.cached/-cached-prompt-executor/moderate.html`

### :prompt:prompt-executor:prompt-executor-cached/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```


Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.
