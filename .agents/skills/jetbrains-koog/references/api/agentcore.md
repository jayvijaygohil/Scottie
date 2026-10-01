# Bedrock AgentCore Runtime

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agentcore.runtime.AgentCoreContext.AgentCoreContext

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-context/-agent-core-context.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(headers: Headers, taskTracker: AgentCoreTaskTracker)
```

## ai.koog.agentcore.runtime.AgentCoreContext.getHeader

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-context/get-header.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun getHeader(headerName: String): String?
```

Returns the value of a specific header, or null if not present.

## ai.koog.agentcore.runtime.AgentCoreContext.getHeaders

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-context/get-headers.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun getHeaders(): Headers
```

Returns all headers from the invocation request.

## ai.koog.agentcore.runtime.AgentCoreContext

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-context/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class AgentCoreContext(headers: Headers, val taskTracker: AgentCoreTaskTracker)
```

Context object containing HTTP headers from AgentCore invocation requests.

Provides access to all headers sent by the AgentCore Runtime, including session IDs, user IDs, authentication tokens, and custom headers.

## ai.koog.agentcore.runtime.AgentCoreContext.taskTracker

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-context/task-tracker.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val taskTracker: AgentCoreTaskTracker
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.AUTHORIZATION

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-a-u-t-h-o-r-i-z-a-t-i-o-n.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val AUTHORIZATION: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.BAGGAGE

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-b-a-g-g-a-g-e.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val BAGGAGE: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.CUSTOM_HEADER_PREFIX

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-c-u-s-t-o-m_-h-e-a-d-e-r_-p-r-e-f-i-x.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val CUSTOM_HEADER_PREFIX: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.GUEST_AUTH

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-g-u-e-s-t_-a-u-t-h.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val GUEST_AUTH: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.PROXY_IP

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-p-r-o-x-y_-i-p.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val PROXY_IP: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.PROXY_PORT

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-p-r-o-x-y_-p-o-r-t.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val PROXY_PORT: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.REQUEST_ID

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-r-e-q-u-e-s-t_-i-d.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val REQUEST_ID: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.SESSION_ID

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-s-e-s-s-i-o-n_-i-d.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val SESSION_ID: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.TRACE_ID

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-t-r-a-c-e_-i-d.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val TRACE_ID: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.USER_ID

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-u-s-e-r_-i-d.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val USER_ID: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.WORKLOAD_ACCESS_TOKEN

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-w-o-r-k-l-o-a-d_-a-c-c-e-s-s_-t-o-k-e-n.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val WORKLOAD_ACCESS_TOKEN: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders.WORKLOAD_ACCESS_TOKEN_RUNTIME

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/-w-o-r-k-l-o-a-d_-a-c-c-e-s-s_-t-o-k-e-n_-r-u-n-t-i-m-e.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
const val WORKLOAD_ACCESS_TOKEN_RUNTIME: String
```

## ai.koog.agentcore.runtime.AgentCoreHeaders

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-headers/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
object AgentCoreHeaders
```

Well-known AgentCore HTTP headers used by Amazon Bedrock AgentCore Runtime.

## ai.koog.agentcore.runtime.AgentCoreInvocationException.AgentCoreInvocationException

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-invocation-exception/-agent-core-invocation-exception.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(message: String, cause: Throwable? = null)
```

## ai.koog.agentcore.runtime.AgentCoreInvocationException

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-invocation-exception/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class AgentCoreInvocationException(message: String, cause: Throwable? = null) : RuntimeException
```

Exception thrown when there are issues with AgentCore invocation.

## ai.koog.agentcore.runtime.AgentCorePingResponse.AgentCorePingResponse

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-response/-agent-core-ping-response.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(status: PingStatus, httpStatus: HttpStatusCode, timeOfLastUpdate: Long)
```

## ai.koog.agentcore.runtime.AgentCorePingResponse.httpStatus

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-response/http-status.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val httpStatus: HttpStatusCode
```

## ai.koog.agentcore.runtime.AgentCorePingResponse

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-response/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
data class AgentCorePingResponse(val status: PingStatus, val httpStatus: HttpStatusCode, val timeOfLastUpdate: Long)
```

Ping response data returned by AgentCorePingService.

## ai.koog.agentcore.runtime.AgentCorePingResponse.status

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-response/status.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val status: PingStatus
```

## ai.koog.agentcore.runtime.AgentCorePingResponse.timeOfLastUpdate

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-response/time-of-last-update.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val timeOfLastUpdate: Long
```

## ai.koog.agentcore.runtime.AgentCorePingService.getPingStatus

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-service/get-ping-status.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
abstract fun getPingStatus(): AgentCorePingResponse
```

## ai.koog.agentcore.runtime.AgentCorePingService

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-ping-service/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun interface AgentCorePingService
```

Interface for providing ping status.

- StaticAgentCorePingService
## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.AgentCoreRuntimeConfig

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/-agent-core-runtime-config.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor()
```

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.binaryStreamThresholdBytes

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/binary-stream-threshold-bytes.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
var binaryStreamThresholdBytes: Long
```

Threshold (in bytes) above which an inbound request body is exposed as InvocationInput.Stream rather than InvocationInput.Binary. Requests with no Content-Length header are also exposed as InvocationInput.Stream.

Default: 1 MiB.

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.handlerTimeoutMillis

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/handler-timeout-millis.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
var handlerTimeoutMillis: Long
```

Per-request handler timeout, in milliseconds. When > 0, the unified handler / typed handler is wrapped in a withTimeout(...) block. On timeout the request fails with HTTP 504 Gateway Timeout and a structured JSON error body.

Default: 0 — no timeout.

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.handler

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/handler.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
var handler: UnifiedInvocationHandler?
```

Single handler covering all input/output shapes. Required unless a typed handler is registered via handle.

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class AgentCoreRuntimeConfig
```

Configuration for the agentCoreRuntime route installer.

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.maxRequestBytes

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/max-request-bytes.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
var maxRequestBytes: Long
```

Maximum allowed request body size, in bytes. Requests whose Content-Length exceeds this value are rejected with HTTP 413 Payload Too Large before the handler is invoked. Requests with no Content-Length header are not pre-checked (the underlying engine's limits still apply).

Default: 100 MiB — matches AgentCore Runtime's documented payload cap.

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.pingService

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/ping-service.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
var pingService: AgentCorePingService?
```

Custom ping service. Defaults to StaticAgentCorePingService.

## ai.koog.agentcore.runtime.AgentCoreRuntimeConfig.taskTracker

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-runtime-config/task-tracker.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
var taskTracker: AgentCoreTaskTracker
```

Task tracker used to report PingStatus.HEALTHY_BUSY while long-running background work is in progress. Exposed to the handler via AgentCoreContext.taskTracker.

## ai.koog.agentcore.runtime.AgentCoreTaskTracker.AgentCoreTaskTracker

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-task-tracker/-agent-core-task-tracker.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor()
```

## ai.koog.agentcore.runtime.AgentCoreTaskTracker.decrement

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-task-tracker/decrement.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun decrement()
```

## ai.koog.agentcore.runtime.AgentCoreTaskTracker.getCount

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-task-tracker/get-count.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun getCount(): Long
```

## ai.koog.agentcore.runtime.AgentCoreTaskTracker.increment

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-task-tracker/increment.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun increment()
```

## ai.koog.agentcore.runtime.AgentCoreTaskTracker

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-agent-core-task-tracker/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class AgentCoreTaskTracker
```

Tracks active background tasks so the /ping endpoint can report PingStatus.HEALTHY_BUSY instead of PingStatus.HEALTHY, preventing the runtime from scaling the agent down while long-running work is in progress.

## ai.koog.agentcore.runtime.InvocationInput.Binary.Binary

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-binary/-binary.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(bytes: ByteArray, contentType: ContentType)
```

## ai.koog.agentcore.runtime.InvocationInput.Binary.bytes

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-binary/bytes.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val bytes: ByteArray
```

## ai.koog.agentcore.runtime.InvocationInput.Binary.contentType

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-binary/content-type.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val contentType: ContentType
```

## ai.koog.agentcore.runtime.InvocationInput.Binary

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-binary/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class Binary(val bytes: ByteArray, val contentType: ContentType) : InvocationInput
```

Request body materialised as raw bytes plus the original Content-Type.

## ai.koog.agentcore.runtime.InvocationInput.Multipart.Multipart

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-multipart/-multipart.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(parts: MultiPartData)
```

## ai.koog.agentcore.runtime.InvocationInput.Multipart

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-multipart/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class Multipart(val parts: MultiPartData) : InvocationInput
```

multipart/form-data request — handler iterates over MultiPartData to read individual file/field parts (PartData.FormItem, PartData.FileItem, etc.). Useful for file uploads where metadata fields accompany binary blobs.

## ai.koog.agentcore.runtime.InvocationInput.Multipart.parts

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-multipart/parts.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val parts: MultiPartData
```

## ai.koog.agentcore.runtime.InvocationInput.Stream.Stream

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-stream/-stream.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(channel: ByteReadChannel, contentType: ContentType)
```

## ai.koog.agentcore.runtime.InvocationInput.Stream.channel

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-stream/channel.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val channel: ByteReadChannel
```

## ai.koog.agentcore.runtime.InvocationInput.Stream.contentType

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-stream/content-type.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val contentType: ContentType
```

## ai.koog.agentcore.runtime.InvocationInput.Stream

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-stream/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class Stream(val channel: ByteReadChannel, val contentType: ContentType) : InvocationInput
```

Request body as a ByteReadChannel for incremental reads. Use this for large uploads (audio/video/large PDF) where allocating the full payload as a ByteArray is undesirable.

## ai.koog.agentcore.runtime.InvocationInput.Text.Text

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-text/-text.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(body: String)
```

## ai.koog.agentcore.runtime.InvocationInput.Text.body

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-text/body.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val body: String
```

## ai.koog.agentcore.runtime.InvocationInput.Text

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/-text/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
data class Text(val body: String) : InvocationInput
```

Request body decoded as a UTF-8 string (used for JSON/text content types).

## ai.koog.agentcore.runtime.InvocationInput

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-input/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
sealed interface InvocationInput
```

Structured input handed to the unified invocation handler.

The plugin auto-dispatches based on the request's Content-Type and Content-Length:

application/json, text/... → Text (UTF-8 string)

multipart/... → Multipart (MultiPartData)

any other type within binaryStreamThresholdBytes → Binary (full bytes)

any other type beyond the threshold or unknown length → Stream (ByteReadChannel)

Handlers pattern-match on the variant they expect; raise an AgentCoreInvocationException for unsupported shapes.

- Text
- Binary
- Stream
- Multipart
## ai.koog.agentcore.runtime.InvocationResult.Binary.Binary

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary/-binary.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(bytes: ByteArray, contentType: ContentType)
```

## ai.koog.agentcore.runtime.InvocationResult.Binary.bytes

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary/bytes.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val bytes: ByteArray
```

## ai.koog.agentcore.runtime.InvocationResult.Binary.contentType

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary/content-type.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val contentType: ContentType
```

## ai.koog.agentcore.runtime.InvocationResult.Binary

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
data class Binary(val bytes: ByteArray, val contentType: ContentType) : InvocationResult
```

## ai.koog.agentcore.runtime.InvocationResult.BinaryStream.BinaryStream

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary-stream/-binary-stream.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(chunks: Flow<ByteArray>, contentType: ContentType)
```

## ai.koog.agentcore.runtime.InvocationResult.BinaryStream.chunks

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary-stream/chunks.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val chunks: Flow<ByteArray>
```

## ai.koog.agentcore.runtime.InvocationResult.BinaryStream.contentType

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary-stream/content-type.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val contentType: ContentType
```

## ai.koog.agentcore.runtime.InvocationResult.BinaryStream

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-binary-stream/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class BinaryStream(val chunks: Flow<ByteArray>, val contentType: ContentType) : InvocationResult
```

Streaming binary result (HTTP chunked transfer-encoding).

## ai.koog.agentcore.runtime.InvocationResult.Text.Text

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-text/-text.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(value: String)
```

## ai.koog.agentcore.runtime.InvocationResult.Text

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-text/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
data class Text(val value: String) : InvocationResult
```

## ai.koog.agentcore.runtime.InvocationResult.Text.value

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-text/value.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val value: String
```

## ai.koog.agentcore.runtime.InvocationResult.TextStream.TextStream

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-text-stream/-text-stream.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(chunks: Flow<String>)
```

## ai.koog.agentcore.runtime.InvocationResult.TextStream.chunks

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-text-stream/chunks.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
val chunks: Flow<String>
```

## ai.koog.agentcore.runtime.InvocationResult.TextStream

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/-text-stream/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class TextStream(val chunks: Flow<String>) : InvocationResult
```

Streaming text result (SSE data: events per chunk).

## ai.koog.agentcore.runtime.InvocationResult

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-invocation-result/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
sealed interface InvocationResult
```

Structured result of an invocation. Each variant maps to a specific HTTP response shape.

Text → plain text / JSON / single-event SSE depending on Accept.

Binary → raw bytes with the supplied Content-Type and known length.

TextStream → text/event-stream with each chunk written as its own data: event.

BinaryStream → chunked binary with the supplied Content-Type.

- Text
- Binary
- TextStream
- BinaryStream
## ai.koog.agentcore.runtime.PingStatus.HEALTHY

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-ping-status/-h-e-a-l-t-h-y/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
HEALTHY
```

## ai.koog.agentcore.runtime.PingStatus.HEALTHY_BUSY

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-ping-status/-h-e-a-l-t-h-y_-b-u-s-y/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
HEALTHY_BUSY
```

## ai.koog.agentcore.runtime.PingStatus.UNHEALTHY

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-ping-status/-u-n-h-e-a-l-t-h-y/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
UNHEALTHY
```

## ai.koog.agentcore.runtime.PingStatus

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-ping-status/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
enum PingStatus : Enum<PingStatus>
```

Health status for AgentCore ping responses.

HEALTHY — Agent is ready, no background tasks. Runtime may scale down if idle.

HEALTHY_BUSY — Agent is healthy but actively processing. Runtime keeps agent alive.

UNHEALTHY — Agent has issues. Runtime may restart or replace agent.

## ai.koog.agentcore.runtime.StaticAgentCorePingService.StaticAgentCorePingService

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-static-agent-core-ping-service/-static-agent-core-ping-service.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
constructor(taskTracker: AgentCoreTaskTracker)
```

## ai.koog.agentcore.runtime.StaticAgentCorePingService.getPingStatus

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-static-agent-core-ping-service/get-ping-status.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
open override fun getPingStatus(): AgentCorePingResponse
```

## ai.koog.agentcore.runtime.StaticAgentCorePingService

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-static-agent-core-ping-service/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
class StaticAgentCorePingService(taskTracker: AgentCoreTaskTracker) : AgentCorePingService
```

Default ping service that uses AgentCoreTaskTracker for busy detection.

Returns PingStatus.HEALTHY (no active tasks), PingStatus.HEALTHY_BUSY (active tasks), or PingStatus.UNHEALTHY (any exception).

## ai.koog.agentcore.runtime.TypedInvocationHandler

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-typed-invocation-handler/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
typealias TypedInvocationHandler<I, O> = suspend RoutingContext.(input: I, context: AgentCoreContext) -> O
```

Typed handler for invocation requests — convenience for the common JSON-in / JSON-out case.

Receives the request body already deserialized into I and returns a value of type O that is serialized back to the client. Both directions are handled by Ktor's ContentNegotiation plugin, so the request Content-Type (e.g. application/json) and the response Accept header drive the conversion. Requires ContentNegotiation (e.g. json()) to be installed.

Registered via handle.

## ai.koog.agentcore.runtime.UnifiedInvocationHandler

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/-unified-invocation-handler/index.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
typealias UnifiedInvocationHandler = suspend RoutingContext.(input: InvocationInput, context: AgentCoreContext) -> InvocationResult
```

Unified handler for invocation requests — single entry point for all input/output shapes.

The plugin auto-dispatches the request body into an InvocationInput variant by Content-Type and size. The handler returns an InvocationResult variant which the plugin maps to the correct HTTP response (text, binary, SSE stream, or chunked binary).

Coroutine context warning for streaming results: when constructing InvocationResult.TextStream / InvocationResult.BinaryStream from a callback-style SDK (e.g. AWS Bedrock's converseStream, whose collector runs in its own coroutine context), use streamingFlow / streamingBytesFlow rather than flow { emit() } — the strict flow {} builder will throw IllegalStateException: Flow invariant is violated when emit and collect happen in different contexts.

## ai.koog.agentcore.runtime.agentCoreRuntime

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/agent-core-runtime.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun Route.agentCoreRuntime(configure: AgentCoreRuntimeConfig.() -> Unit): Route
```

Installs routes implementing the Amazon Bedrock AgentCore Runtime contract:

GET /ping — health check with task-aware status reporting.

POST /invocations — invocation endpoint backed by a single unified handler.

Quick start:

Application plugins such as ContentNegotiation and RateLimit remain owned by the host application and can be applied to these routes through normal Ktor route composition.

## ai.koog.agentcore.runtime.handle

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/handle.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
inline fun <I : Any, O> AgentCoreRuntimeConfig.handle(crossinline handler: TypedInvocationHandler<I, O>)
```

Registers a typed invocation handler — convenience for JSON-in / JSON-out flows.

When set, the unified AgentCoreRuntimeConfig.handler is ignored. Requires ContentNegotiation (e.g. json()) to be installed on the application.

Example:

## ai.koog.agentcore.runtime.streamingBytesFlow

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/streaming-bytes-flow.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun streamingBytesFlow(producer: suspend SendChannel<ByteArray>.() -> Unit): Flow<ByteArray>
```

Symmetric helper for binary streams used with InvocationResult.BinaryStream.

## ai.koog.agentcore.runtime.streamingFlow

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/streaming-flow.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun streamingFlow(producer: suspend SendChannel<String>.() -> Unit): Flow<String>
```

Helper that builds a context-safe Flow<String> suitable for InvocationResult.TextStream.

Use this when emitting items from a callback whose execution context differs from the Flow collector's context (typical for AWS SDK streaming callbacks). Internally a channelFlow is used so send calls cross coroutine contexts safely.

## ai.koog.agentcore.runtime.toInvocationResult

Module: `koog-bedrock-agentcore-runtime`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-bedrock-agentcore-runtime/ai.koog.agentcore.runtime/to-invocation-result.html`

### :koog-bedrock-agentcore-runtime/main

```kotlin
fun ContentBlock.toInvocationResult(): InvocationResult
```

Converts a Bedrock ContentBlock (typically from a Converse/ConverseStream output message) into an InvocationResult suitable for an HTTP response.

ContentBlock.Text becomes InvocationResult.Text.

ContentBlock.Image, ContentBlock.Audio, ContentBlock.Video and ContentBlock.Document become InvocationResult.Binary with a content type derived from the block's format, provided the block carries inline bytes (an S3Location source is not proxied).

- AgentCoreInvocationException — for blocks that cannot be represented as a single HTTP body (e.g. tool use/result, reasoning, or a binary block backed only by an S3Location).