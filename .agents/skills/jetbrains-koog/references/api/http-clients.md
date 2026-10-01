# HTTP contracts and Ktor backend

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.http.client.HttpClientFactoryResolver

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-http-client-factory-resolver/index.html`

### :http-client:http-client-core/jvmCommonMain

```kotlin
object HttpClientFactoryResolver
```

Resolver for the default KoogHttpClient.Factory discovered on the JVM runtime classpath via ServiceLoader.

For customization (custom HTTP engine, non-default timeouts, etc.) or to disambiguate when multiple providers are on the classpath, pass a KoogHttpClient.Factory directly to the relevant LLM client constructor or builder method instead of relying on the discovered default.

## ai.koog.http.client.HttpClientFactoryResolver.resolve

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-http-client-factory-resolver/resolve.html`

### :http-client:http-client-core/jvmCommonMain

```kotlin
fun resolve(): KoogHttpClient.Factory
```

Returns the single KoogHttpClient.Factory discovered on the runtime classpath via ServiceLoader. The resolved factory is cached on first successful access; the ServiceLoader lookup and reflective instantiation are paid once per process.

Throws IllegalStateException when zero or more than one provider is found.

## ai.koog.http.client.KoogHttpClient.Companion

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-companion/index.html`

### :http-client:http-client-core/commonMain

```kotlin
object Companion
```

Easter egg companion object. Guess why it's here.

Hint: it was created in order to not bring Ktor and other dependencies to the interface declaration

## ai.koog.http.client.KoogHttpClient.Factory.Companion.DEFAULT_CONNECT_TIMEOUT_MS

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-factory/-companion/-d-e-f-a-u-l-t_-c-o-n-n-e-c-t_-t-i-m-e-o-u-t_-m-s.html`

### :http-client:http-client-core/commonMain

```kotlin
val DEFAULT_CONNECT_TIMEOUT_MS: Long
```

## ai.koog.http.client.KoogHttpClient.Factory.Companion.DEFAULT_REQUEST_TIMEOUT_MS

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-factory/-companion/-d-e-f-a-u-l-t_-r-e-q-u-e-s-t_-t-i-m-e-o-u-t_-m-s.html`

### :http-client:http-client-core/commonMain

```kotlin
val DEFAULT_REQUEST_TIMEOUT_MS: Long
```

## ai.koog.http.client.KoogHttpClient.Factory.Companion.DEFAULT_SOCKET_TIMEOUT_MS

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-factory/-companion/-d-e-f-a-u-l-t_-s-o-c-k-e-t_-t-i-m-e-o-u-t_-m-s.html`

### :http-client:http-client-core/commonMain

```kotlin
val DEFAULT_SOCKET_TIMEOUT_MS: Long
```

## ai.koog.http.client.KoogHttpClient.Factory.Companion

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-factory/-companion/index.html`

### :http-client:http-client-core/commonMain

```kotlin
object Companion
```

## ai.koog.http.client.KoogHttpClient.Factory.create

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-factory/create.html`

### :http-client:http-client-core/commonMain

```kotlin
abstract fun create(clientName: String, baseUrl: String = "", headers: Map<String, String> = emptyMap(), queryParameters: Map<String, String> = emptyMap(), requestTimeoutMillis: Long = DEFAULT_REQUEST_TIMEOUT_MS, connectTimeoutMillis: Long = DEFAULT_CONNECT_TIMEOUT_MS, socketTimeoutMillis: Long = DEFAULT_SOCKET_TIMEOUT_MS, json: Json = Json): KoogHttpClient
```

Creates a configured KoogHttpClient.

- clientName — The name used for logging and traceability.
- baseUrl — Base URL prepended to relative request paths.
- headers — Default headers applied to every request.
- queryParameters — Default query parameters applied to every request.
- requestTimeoutMillis — Maximum time in milliseconds allowed for a request to complete.
- connectTimeoutMillis — Maximum time in milliseconds allowed for establishing a connection.
- socketTimeoutMillis — Maximum time in milliseconds allowed for waiting on socket reads and writes.
- json — JSON instance used for request and response serialization.
## ai.koog.http.client.KoogHttpClient.Factory

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/-factory/index.html`

### :http-client:http-client-core/commonMain

```kotlin
interface Factory
```

## ai.koog.http.client.KoogHttpClient.clientName

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/client-name.html`

### :http-client:http-client-core/commonMain

```kotlin
abstract val clientName: String
```

The name of the client.

## ai.koog.http.client.KoogHttpClient.get

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/get.html`

### :http-client:http-client-core/commonMain

```kotlin
abstract suspend fun <R : Any> get(path: String, responseType: KClass<R>, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): R
```

Sends an HTTP GET request to the specified path. The expected response type must be explicitly specified using responseType.

The response payload, deserialized into the specified type.

- path — The endpoint path to which the HTTP GET request is sent.
- responseType — The Kotlin class reference representing the expected type of the response.
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved.
- Exception — if the request fails or the response cannot be deserialized.
## ai.koog.http.client.KoogHttpClient

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/index.html`

### :http-client:http-client-core/commonMain

```kotlin
interface KoogHttpClient : AutoCloseable
```

Abstract interfaces defining a contract for HTTP client implementations. Provides methods for making HTTP POST requests and handling Server-Sent Events (SSE) streams.

Implementations are supposed to use a particular library or framework.

## ai.koog.http.client.KoogHttpClient.lines

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/lines.html`

### :http-client:http-client-core/commonMain

```kotlin
abstract fun <T : Any> lines(path: String, requestBody: T, requestBodyType: KClass<T>, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): Flow<String>
```

Sends an HTTP POST request and emits each non-blank UTF-8 line of the response body as it arrives.

A Flow emitting each non-blank line of the response body as it arrives.

- path — The endpoint path to which the HTTP POST request is sent.
- requestBody — The request body to be sent in the POST request.
- requestBodyType — The Kotlin class reference representing the type of the request body.
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved.
- KoogHttpClientException — if the server returns a non-success status.
## ai.koog.http.client.KoogHttpClient.post

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/post.html`

### :http-client:http-client-core/commonMain

```kotlin
abstract suspend fun <T : Any, R : Any> post(path: String, requestBody: T, requestBodyType: KClass<T>, responseType: KClass<R>, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): R
```

Sends an HTTP POST request to the specified path with the provided request body. The type of the request body and the expected response must be explicitly specified using requestBodyType and responseType, respectively.

The response payload, deserialized into the specified type.

- path — The endpoint path to which the HTTP POST request is sent.
- requestBody — The request body to be sent in the POST request.
- requestBodyType — The Kotlin class reference representing the type of the request body.
- responseType — The Kotlin class reference representing the expected type of the response.
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved.
- Exception — if the request fails or the response cannot be deserialized.
## ai.koog.http.client.KoogHttpClient.sse

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client/sse.html`

### :http-client:http-client-core/commonMain

```kotlin
abstract fun <T : Any, R : Any, O : Any> sse(path: String, requestBody: T, requestBodyType: KClass<T>, dataFilter: (String?) -> Boolean = { true }, decodeStreamingResponse: (String) -> R, processStreamingChunk: (R) -> O?, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): Flow<O>
```

Initiates a Server-Sent Events (SSE) streaming operation over an HTTP POST request.

This function sends a request to the specified path with the given request body, processes the streamed chunks of data from the server, and emits the processed results as a flow of strings.

A Flow emitting processed strings derived from the streamed chunks of data.

- path — The endpoint path to which the SSE POST request is sent.
- requestBody — The request body to be sent in the POST request.
- requestBodyType — The Kotlin class reference representing the type of the request body.
- dataFilter — A lambda function that determines whether a received streaming data chunk should be processed. It takes the raw data as a string and returns true if the data should be included, or false otherwise. Defaults to accepting all non-null chunks.
- decodeStreamingResponse — A lambda function used to decode the raw streaming response data into the target type. It takes a raw string and converts it into an object of type R.
- processStreamingChunk — A lambda function that processes the decoded streaming chunk and returns
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved. a string result. If the returned value is null, the chunk will not be emitted to the resulting flow.
## ai.koog.http.client.KoogHttpClientException.KoogHttpClientException

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client-exception/-koog-http-client-exception.html`

### :http-client:http-client-core/commonMain

```kotlin
constructor(clientName: String? = null, statusCode: Int? = null, errorBody: String? = null, message: String? = null, cause: Throwable? = null)
```

## ai.koog.http.client.KoogHttpClientException.clientName

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client-exception/client-name.html`

### :http-client:http-client-core/commonMain

```kotlin
val clientName: String?
```

## ai.koog.http.client.KoogHttpClientException.errorBody

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client-exception/error-body.html`

### :http-client:http-client-core/commonMain

```kotlin
val errorBody: String?
```

## ai.koog.http.client.KoogHttpClientException

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client-exception/index.html`

### :http-client:http-client-core/commonMain

```kotlin
class KoogHttpClientException(val clientName: String? = null, val statusCode: Int? = null, val errorBody: String? = null, message: String? = null, cause: Throwable? = null) : Exception
```

Base exception class for HTTP clients in koog

## ai.koog.http.client.KoogHttpClientException.statusCode

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/-koog-http-client-exception/status-code.html`

### :http-client:http-client-core/commonMain

```kotlin
val statusCode: Int?
```

## ai.koog.http.client.get

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/get.html`

### :http-client:http-client-core/commonMain

```kotlin
inline suspend fun <R : Any> KoogHttpClient.get(path: String, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): R
```

Sends an HTTP GET request to the specified path with the provided parameters.

The response payload, deserialized into the specified type.

- path — The endpoint path to which the HTTP GET request is sent.
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved.
- Exception — if the request fails or the response cannot be deserialized.
## ai.koog.http.client.lines

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/lines.html`

### :http-client:http-client-core/commonMain

```kotlin
inline fun <T : Any> KoogHttpClient.lines(path: String, requestBody: T, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): Flow<String>
```

Sends an HTTP POST request and emits each non-blank UTF-8 line of the response body as it arrives.

A Flow emitting each non-blank line of the response body as it arrives.

- path — The endpoint path to which the HTTP POST request is sent.
- requestBody — The request body to be sent in the POST request.
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved.
- KoogHttpClientException — if the server returns a non-success status.
## ai.koog.http.client.mergeHeaders

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/merge-headers.html`

### :http-client:http-client-core/commonMain

```kotlin
fun mergeHeaders(vararg headerGroups: Map<String, String>): Map<String, String>
```

Merges header groups into a single map.

Header names are matched case-insensitively. If the same header name appears more than once, the value from the later group replaces the earlier one while unrelated headers are preserved.

Pass groups in ascending precedence order, for example: mergeHeaders(defaultHeaders, inferredHeaders, requestHeaders).

- headerGroups — Header maps ordered from lowest to highest precedence.
## ai.koog.http.client.post

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/post.html`

### :http-client:http-client-core/commonMain

```kotlin
inline suspend fun <T : Any, R : Any> KoogHttpClient.post(path: String, requestBody: T, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): R
```

Sends an HTTP POST request to the specified path with the provided request body.

The response payload, deserialized into the specified type.

- path — The endpoint path to which the HTTP POST request is sent.
- requestBody — The request body to be sent in the POST request.
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved.
- Exception — if the request fails or the response cannot be deserialized.
## ai.koog.http.client.sse

Module: `http-client-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-core/ai.koog.http.client/sse.html`

### :http-client:http-client-core/commonMain

```kotlin
inline fun <T : Any, R : Any, O : Any> KoogHttpClient.sse(path: String, requestBody: T, noinline dataFilter: (String?) -> Boolean = { true }, noinline decodeStreamingResponse: (String) -> R, noinline processStreamingChunk: (R) -> O?, parameters: Map<String, String> = emptyMap(), headers: Map<String, String> = emptyMap()): Flow<O>
```

Initiates a Server-Sent Events (SSE) streaming operation over an HTTP POST request.

This function sends a request to the specified path with the given request body, processes the streamed chunks of data from the server, and emits the processed results as a flow of strings.

A Flow emitting processed strings derived from the streamed chunks of data.

- path — The endpoint path to which the SSE POST request is sent.
- requestBody — The request body to be sent in the POST request.
- dataFilter — A lambda function that determines whether a received streaming data chunk should be processed. It takes the raw data as a string and returns true if the data should be included, or false otherwise. Defaults to accepting all non-null chunks.
- decodeStreamingResponse — A lambda function used to decode the raw streaming response data into the target type. It takes a raw string and converts it into an object of type R.
- processStreamingChunk — A lambda function that processes the decoded streaming chunk and returns
- parameters — Optional query parameters merged with default query parameters configured on the client.
- headers — Optional request headers merged with headers configured on the client. Headers with the same name replace configured or inferred header values; other configured headers are preserved. a string result. If the returned value is null, the chunk will not be emitted to the resulting flow.
## ai.koog.http.client.ktor.KtorKoogHttpClient.Factory.Factory

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/-factory/-factory.html`

### :http-client:http-client-ktor/commonMain

```kotlin
constructor(baseClient: HttpClient = HttpClient(), withSse: Boolean = true, logger: KLogger = KotlinLogging.logger {})
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.Factory.create

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/-factory/create.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open override fun create(clientName: String, baseUrl: String, headers: Map<String, String>, queryParameters: Map<String, String>, requestTimeoutMillis: Long, connectTimeoutMillis: Long, socketTimeoutMillis: Long, json: Json): KtorKoogHttpClient
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.Factory

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/-factory/index.html`

### :http-client:http-client-ktor/commonMain

```kotlin
class Factory constructor(baseClient: HttpClient = HttpClient(), withSse: Boolean = true, logger: KLogger = KotlinLogging.logger {}) : KoogHttpClient.Factory
```

KoogHttpClient.Factory implementation backed by Ktor HttpClient.


Referenced packages: `ai.koog.http.client`.

## ai.koog.http.client.ktor.KtorKoogHttpClient.KtorKoogHttpClient

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/-ktor-koog-http-client.html`

### :http-client:http-client-ktor/commonMain

```kotlin
constructor(clientName: String, logger: KLogger, baseClient: HttpClient = HttpClient(), configurer: HttpClientConfig<out HttpClientEngineConfig>.() -> Unit)
```

Secondary constructor for creating a KtorKoogHttpClient with a base Ktor HttpClient and a configurer function.

- clientName — The name of the client, used for logging and traceability.
- logger — A logging instance of type KLogger for recording client-related events and errors.
- baseClient — The base Ktor HttpClient instance used as base to construct ktorClient via applying configurer
- configurer — A lambda function to configure the base Ktor HttpClient instance.
## ai.koog.http.client.ktor.KtorKoogHttpClient.clientName

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/client-name.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open override val clientName: String
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.close

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/close.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open override fun close()
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.get

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/get.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open suspend override fun <R : Any> get(path: String, responseType: KClass<R>, parameters: Map<String, String>, headers: Map<String, String>): R
```

## ai.koog.http.client.ktor.KtorKoogHttpClient

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/index.html`

### :http-client:http-client-ktor/commonMain

```kotlin
class KtorKoogHttpClient : KoogHttpClient
```

KtorHttpClient is an implementation of the KoogHttpClient interface, utilizing Ktor's HttpClient to perform HTTP operations, including GET, POST requests and Server-Sent Events (SSE) streaming.

This client provides enhanced logging, flexible request and response handling, and supports configurability for underlying Ktor HttpClient instances.


Referenced packages: `ai.koog.http.client`.

## ai.koog.http.client.ktor.KtorKoogHttpClient.ktorClient

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/ktor-client.html`

### :http-client:http-client-ktor/commonMain

```kotlin
val ktorClient: HttpClient
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.lines

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/lines.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open override fun <T : Any> lines(path: String, requestBody: T, requestBodyType: KClass<T>, parameters: Map<String, String>, headers: Map<String, String>): Flow<String>
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.post

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/post.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open suspend override fun <T : Any, R : Any> post(path: String, requestBody: T, requestBodyType: KClass<T>, responseType: KClass<R>, parameters: Map<String, String>, headers: Map<String, String>): R
```

## ai.koog.http.client.ktor.KtorKoogHttpClient.sse

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/-ktor-koog-http-client/sse.html`

### :http-client:http-client-ktor/commonMain

```kotlin
open override fun <T : Any, R : Any, O : Any> sse(path: String, requestBody: T, requestBodyType: KClass<T>, dataFilter: (String?) -> Boolean, decodeStreamingResponse: (String) -> R, processStreamingChunk: (R) -> O?, parameters: Map<String, String>, headers: Map<String, String>): Flow<O>
```

## ai.koog.http.client.ktor.fromKtorClient

Module: `http-client-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `http-client/http-client-ktor/ai.koog.http.client.ktor/from-ktor-client.html`

### :http-client:http-client-ktor/commonMain

```kotlin
fun KoogHttpClient.Companion.fromKtorClient(clientName: String, logger: KLogger, baseClient: HttpClient = HttpClient(), configurer: HttpClientConfig<out HttpClientEngineConfig>.() -> Unit = {}): KoogHttpClient
```

Creates a new instance of KoogHttpClient using a Ktor-based HTTP client for performing HTTP operations.

This function allows configuring the underlying Ktor HttpClient through the provided configuration lambda and enables enhanced logging, flexibility, and customization in HTTP interactions.

An instance of KoogHttpClient configured with the provided parameters.

- clientName — The name of the client instance, used for identifying or logging client operations.
- logger — A KLogger instance used for logging client events and errors.
- baseClient — The base Ktor HttpClient instance to be used. Defaults to a new Ktor HttpClient instance.
- configurer — A lambda function to configure the base Ktor HttpClient instance. It is applied using Ktor’s HttpClientConfig.

Referenced packages: `ai.koog.http.client`.

## ai.koog.prompt.executor.clients.ConnectionTimeoutConfig.ConnectionTimeoutConfig

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-connection-timeout-config/-connection-timeout-config.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(requestTimeoutMillis: Long = DEFAULT_TIMEOUT_MS, connectTimeoutMillis: Long = DEFAULT_CONNECT_TIMEOUT_MS, socketTimeoutMillis: Long = DEFAULT_TIMEOUT_MS)
```

## ai.koog.prompt.executor.clients.ConnectionTimeoutConfig.connectTimeoutMillis

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-connection-timeout-config/connect-timeout-millis.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val connectTimeoutMillis: Long
```

## ai.koog.prompt.executor.clients.ConnectionTimeoutConfig

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-connection-timeout-config/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
data class ConnectionTimeoutConfig(val requestTimeoutMillis: Long = DEFAULT_TIMEOUT_MS, val connectTimeoutMillis: Long = DEFAULT_CONNECT_TIMEOUT_MS, val socketTimeoutMillis: Long = DEFAULT_TIMEOUT_MS)
```

ConnectionTimeoutConfig is a configuration class for specifying timeout values for network connections in milliseconds. It includes configurable timeouts for requests, connection establishment, and socket operations.

## ai.koog.prompt.executor.clients.ConnectionTimeoutConfig.requestTimeoutMillis

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-connection-timeout-config/request-timeout-millis.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val requestTimeoutMillis: Long
```

## ai.koog.prompt.executor.clients.ConnectionTimeoutConfig.socketTimeoutMillis

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-connection-timeout-config/socket-timeout-millis.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val socketTimeoutMillis: Long
```
