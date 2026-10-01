# Error Handling

> SDKException, codes, and recovery

Everything the SDK throws is an `SDKException`. It wraps a proto-backed error, so the same code
and category cross every language binding.

```kotlin theme={null}
try {
    val result = RunAnywhere.llm.generate(prompt)
} catch (e: SDKException) {
    println(e.code)
    println(e.errorDescription)
    println(e.recoverySuggestion)
}
```

## SDKException

| Member                | Type                  | Meaning                       |
|-----------------------|-----------------------|-------------------------------|
| `code`                | `ProtoErrorCode`      | What went wrong               |
| `category`            | `ProtoErrorCategory`  | Which layer it came from      |
| `errorDescription`    | `String?`             | Human-readable description    |
| `failureReason`       | `String`              | Why it failed                 |
| `recoverySuggestion`  | `String?`             | What the user can do          |
| `fieldPath`           | `String?`             | Which input failed validation |
| `cAbiCode`            | `Int?`                | Underlying C ABI code         |
| `nestedMessage`       | `String?`             | Message from a wrapped error  |
| `stackTraceSnapshot`  | `List<String>`        | Capture site                  |
| `telemetryProperties` | `Map<String, String>` | Ready-made reporting payload  |

## Codes worth handling

| Code                                      | Meaning                      | What to do                               |
|-------------------------------------------|------------------------------|------------------------------------------|
| `ERROR_CODE_NOT_INITIALIZED`              | Called before `initialize()` | Initialize first                         |
| `ERROR_CODE_MODEL_NOT_FOUND`              | No such model                | Check the id, or register it             |
| `ERROR_CODE_NETWORK_UNAVAILABLE`          | Download needs a connection  | Retry when online                        |
| `ERROR_CODE_INSUFFICIENT_STORAGE`         | Not enough disk              | Free space or use a smaller model        |
| `ERROR_CODE_INSUFFICIENT_MEMORY`          | Model will not fit in RAM    | Unload something, or use a smaller model |
| `ERROR_CODE_MICROPHONE_PERMISSION_DENIED` | No mic access                | Send the user to Settings                |
| `ERROR_CODE_TIMEOUT`                      | Took too long                | Retry                                    |
| `ERROR_CODE_INVALID_API_KEY`              | Credentials rejected         | Check the key                            |
| `ERROR_CODE_CANCELLED`                    | The caller cancelled         | Usually ignore                           |
| `ERROR_CODE_INVALID_ARGUMENT`             | An input was rejected        | Read `fieldPath`                         |

## Factory methods

The companion object builds typed exceptions, which is what the SDK itself throws and what you
can throw from your own tool executors:

```kotlin theme={null}
SDKException.notInitialized(component)
SDKException.invalidConfiguration(message)
SDKException.unsupportedCapability(name, reason)
SDKException.invalidApiKey()
SDKException.invalidArgument(message)
SDKException.validationFailed(message)
SDKException.modelNotFound(modelId)
```

`unsupportedCapability` is the one you will meet in practice: it is what
`generateStructured(mode = CONSTRAINED)` throws.

## Reacting to specific codes

```kotlin theme={null}
try {
    val result = RunAnywhere.llm.generate(prompt)
} catch (e: SDKException) {
    when (e.code) {
        ProtoErrorCode.ERROR_CODE_NOT_INITIALIZED ->
            RunAnywhere.initialize(apiKey = "", baseUrl = "")
        ProtoErrorCode.ERROR_CODE_INSUFFICIENT_MEMORY ->
            RunAnywhere.models.unloadAll()
        ProtoErrorCode.ERROR_CODE_CANCELLED -> Unit
        else -> show(e.errorDescription ?: e.failureReason)
    }
}
```

## Errors from a Flow

Failures surface at the collector, so wrap the collection:

```kotlin theme={null}
try {
    RunAnywhere.llm.generateStream(prompt).collect { event ->
        if (event is GenerationEvent.Token) text += event.text
    }
} catch (e: SDKException) {
    show(e)
}
```

`catch` from the Flow API works too:

```kotlin theme={null}
RunAnywhere.llm.generateStream(prompt)
    .catch { e -> if (e is SDKException) show(e) }
    .collect { event -> /* … */ }
```

## Cancellation

Cancelling the coroutine cancels the generation. That arrives as `CancellationException`, which
you must not swallow: rethrow it, or use `catch` from the Flow API, which already lets it
through.

```kotlin theme={null}
try {
    RunAnywhere.llm.generateStream(prompt).collect { /* … */ }
} catch (e: CancellationException) {
    throw e
} catch (e: SDKException) {
    show(e)
}
```

## Reporting

```kotlin theme={null}
catch(e: SDKException) {
    analytics.log("sdk_error", e.telemetryProperties)
}
```

`telemetryProperties` is already shaped for a reporting call, with the code, category, and
context attached.

# Best Practices

> Getting good behaviour out of on-device models

## Import the api package

```kotlin theme={null}
import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.*
```

The namespaces are extension properties. Without the second import, `RunAnywhere.llm` does not
resolve, and the error message points at the property rather than the missing import.

## Initialize in Application.onCreate

```kotlin theme={null}
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        RunAnywhere.initialize(apiKey = "", baseUrl = "")
    }
}
```

Phase 2 runs in the background, so initializing at launch gives it time to finish before
anything needs it.

## Let generation load the model

```kotlin theme={null}
val result = RunAnywhere.llm.generate(prompt, LlmOptions(model = "qwen3-0.6b"))
```

Generation auto-loads and downloads when needed. Reach for `models.load` when you want to
control *when* the cost is paid, such as warming a model behind a splash screen.

## Collect in viewModelScope

```kotlin theme={null}
viewModelScope.launch {
    RunAnywhere.llm.generateStream(prompt).collect { /* … */ }
}
```

The flow is cancelled when the ViewModel clears, so a generation cannot outlive the screen it
belongs to.

## Stream anything a person waits for

A 200-token reply takes seconds. Streaming turns that into words appearing immediately.

## Cap output length

`maxOutputTokens` is the biggest lever on latency and battery.

| Use                        | Reasonable cap |
|----------------------------|----------------|
| Classification, extraction | 20 to 50       |
| Chat reply                 | 150 to 300     |
| Spoken reply               | 100            |
| Summary                    | 150            |

## Unload what you are not using

```kotlin theme={null}
RunAnywhere.models.unload("qwen3-0.6b")
RunAnywhere.models.unloadAll(ModelCategory.MODEL_CATEGORY_LANGUAGE)
```

Holding a language model, a speech model, and a vision model at once on a phone is how you get
`ERROR_CODE_INSUFFICIENT_MEMORY`.

## Trim conversations

History grows until it exceeds the context window. Keep the system message and the recent
turns.

## Never swallow CancellationException

```kotlin theme={null}
catch(e: CancellationException) {
    throw e
}
```

Catching it breaks structured concurrency: the coroutine keeps running after its scope is
gone.

## Close what holds hardware

Voice sessions hold the microphone; `AudioRecord` and `AudioTrack` hold audio devices. Close
them in `onCleared`, or in a `finally`.

## Use structured output rather than asking nicely

Asking for JSON in a system prompt works most of the time, which is the problem.

```kotlin theme={null}
RunAnywhere.llm.generateStructured(prompt, schema, StructuredOutputMode.REPAIR)
```

`CONSTRAINED` is not implemented and throws.

## Test on an ARM64 device

The NPU backend is arm64 only and absent from x86\_64 emulators. Performance measured on an
emulator means nothing.

## Keep the Hugging Face token out of source

```kotlin theme={null}
RunAnywhere.setHfToken(tokenFromEncryptedPrefs)
```

Hold it in `EncryptedSharedPreferences` or the Keystore, never in code, assets, or logs.
