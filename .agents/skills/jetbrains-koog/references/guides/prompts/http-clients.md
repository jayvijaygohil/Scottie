> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# HTTP clients

Every LLM client in Koog expects a [`KoogHttpClient`](../../api/http-clients.md#aikooghttpclientkooghttpclient) — the abstract HTTP contract the framework uses to talk to providers. You hand one in at construction.

You can build that `KoogHttpClient` yourself, but it's real work: each provider has its own base URL, auth header shape, content-type, and SSE conventions. Getting all of that right per provider is exactly what [`KoogHttpClient.Factory`](../../api/http-clients.md#aikooghttpclientkooghttpclientfactory) exists to spare you. You pass in a `Factory` and the provider client calls `Factory.create(...)` with the parameters that fit its API.

Four backend factories ship out of the box — Ktor, the JDK `HttpClient`, OkHttp, and Spring's `WebClient` — and you can implement your own.

## How it works

One factory works for any provider: pick a backend once and use it across clients.

=== "Kotlin"

    
    ```kotlin
    fun main() {
        val factory = KtorKoogHttpClient.Factory()

        val openai = OpenAILLMClient(
            apiKey = System.getenv("OPENAI_API_KEY"),
            settings = OpenAIClientSettings(),
            httpClientFactory = factory,
        )

        val anthropic = AnthropicLLMClient(
            apiKey = System.getenv("ANTHROPIC_API_KEY"),
            settings = AnthropicClientSettings(),
            httpClientFactory = factory,
        )
    }
    ```
    

## Supported HTTP client flavors

| Module                                                                  | Notes                                              |
|-------------------------------------------------------------------------|----------------------------------------------------|
| `http-client-ktor`                            | The only backend usable from non-JVM targets.      |
| `http-client-okhttp`                        | Backed by OkHttp. Android-friendly.                |
| `http-client-spring-webclient`    | Backed by Spring `WebClient`.                      |

## Convenience APIs and factory auto-discovery

On JVM and Android, you can construct each LLM client without passing a factory explicitly.

- Every backend module provides a `ServiceLoader` registration.
- Resolution succeeds only when exactly one factory is visible on the runtime classpath.
- `prompt-executor-llms-all` declares `http-client-ktor` as a `runtimeOnly` dependency, so you get Ktor by default without compile-time exposure to that module.
- `simple<Provider>Executor(apiKey)` and `PromptExecutorBuilder.<provider>(apiKey)` use the same resolution path.

=== "Kotlin"

    
    ```kotlin
    fun main() {
        val apiKey = System.getenv("OPENAI_API_KEY")

        val client = OpenAILLMClient(apiKey)
        val executor = simpleOpenAIExecutor(apiKey)
    }
    ```
    

Auto-discovery is not supported on KMP at the moment, so the convenience methods are not available outside the JVM either. From `commonMain`, pass a `Factory` explicitly.

### Auto-discovery gotchas

- **Zero backends on the runtime classpath** → `IllegalStateException` on first resolution. Add a backend module to the runtime classpath, or pass a `Factory` explicitly.
- **Two or more backends** → same exception; the message names the providers it found. Exclude all but one with Gradle (`exclude(module = "http-client-ktor")` on the offending dependency) or pass a `Factory` explicitly at the call site.

## Custom backends

Any class implementing `KoogHttpClient.Factory` works. To make it auto-discoverable on the JVM, register it as a `ServiceLoader` provider:

```
src/main/resources/META-INF/services/ai.koog.http.client.KoogHttpClient$Factory
```

The file contains a single line: the fully qualified name of your factory class. The literal `$` (separator for the nested `Factory` class) is correct — the file is `KoogHttpClient$Factory`, not `KoogHttpClient.Factory`.

If you don't want auto-discovery, skip the registration and pass your factory explicitly everywhere.

## Complete Kotlin examples

- [example-http-clients-01.kt](../../kotlin-examples/example-http-clients-01.kt)
- [example-http-clients-02.kt](../../kotlin-examples/example-http-clients-02.kt)
