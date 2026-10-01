# Installation

> Add the RunAnywhere Kotlin SDK to your Android project

## Gradle

Artifacts come from Maven Central under `io.github.sanchitmonga22`.

```kotlin build.gradle.kts (Module: app) theme={null}
dependencies {
    // Core SDK, required
    implementation("io.github.sanchitmonga22:runanywhere-sdk:0.20.27")

    // LLM and VLM through llama.cpp
    implementation("io.github.sanchitmonga22:runanywhere-llamacpp:0.20.27")

    // STT, TTS, VAD, embeddings through ONNX and Sherpa-ONNX
    implementation("io.github.sanchitmonga22:runanywhere-onnx:0.20.27")

    // Qualcomm Hexagon NPU, arm64-v8a only
    implementation("io.github.sanchitmonga22:runanywhere-qhexrt-android:0.20.19")
}
```

Using a version catalog:

```toml gradle/libs.versions.toml theme={null}
[versions]
runanywhere = "0.20.27"
runanywhereQhexrt = "0.20.19"

[libraries]
runanywhere-sdk = { group = "io.github.sanchitmonga22", name = "runanywhere-sdk", version.ref = "runanywhere" }
runanywhere-llamacpp = { group = "io.github.sanchitmonga22", name = "runanywhere-llamacpp", version.ref = "runanywhere" }
runanywhere-onnx = { group = "io.github.sanchitmonga22", name = "runanywhere-onnx", version.ref = "runanywhere" }
runanywhere-qhexrt = { group = "io.github.sanchitmonga22", name = "runanywhere-qhexrt-android", version.ref = "runanywhereQhexrt" }
```

No NDK, CMake, or native toolchain is needed. Each AAR ships prebuilt native libraries.

## Build configuration

```kotlin build.gradle.kts (Module: app) theme={null}
android {
    compileSdk = 37
    defaultConfig {
        minSdk = 24
        targetSdk = 37
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
```

## The import that makes it compile

The namespaces are extension properties. This import is not optional:

```kotlin theme={null}
import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.*
```

Without the second line, `RunAnywhere.llm` is an unresolved reference.

## Module sizes

Sizes are the published `.aar` on Maven Central, measured at 0.20.27 for the first three and
0.20.19 for QHexRT. They are larger than the eventual APK contribution, because each `.aar`
ships native libraries for every supported ABI and the Android build drops the ones your
`abiFilters` exclude.

| Module                       | Size  | ABIs      | Features                           |
|------------------------------|-------|-----------|------------------------------------|
| `runanywhere-sdk`            | 101MB | all       | Core SDK, model management, events |
| `runanywhere-llamacpp`       | 64MB  | all       | LLM and VLM on GGUF                |
| `runanywhere-onnx`           | 49MB  | all       | STT, TTS, VAD                      |
| `runanywhere-qhexrt-android` | 58MB  | arm64-v8a | Qualcomm Hexagon NPU               |

Include only the backends you need.

## Permissions

```xml AndroidManifest.xml theme={null}
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
```

`INTERNET` is for model downloads. `RECORD_AUDIO` is only needed if you use speech input.

## Emulators

The NPU backend is arm64 only and is unavailable on x86\_64 emulators. Test inference on a
physical ARM64 device.

# Configuration

> Initialization, models, storage, and events

## Initializing

```kotlin theme={null}
RunAnywhere.initialize(apiKey = "", baseUrl = "")
```

Overloads:

```kotlin theme={null}
fun initialize(apiKey: String? = null, baseUrl: String? = null,
               environment: Environment = Environment.SDK_ENVIRONMENT_PRODUCTION)
fun initialize(apiKey: String, baseUrl: URL,
               environment: Environment = Environment.SDK_ENVIRONMENT_PRODUCTION)
suspend fun completeServicesInitialization()
```

Initialization is two-phase. Phase 1 is the `initialize()` call and is all local inference
needs. Phase 2 handles authentication, device registration, and telemetry in the background;
`completeServicesInitialization()` awaits it when you need to be sure it finished.

Call it from `Application.onCreate()`.

## Reading state

| Property          | Type              | Meaning                             |
|-------------------|-------------------|-------------------------------------|
| `isReady`         | `Boolean`         | Local inference is usable           |
| `version`         | `String`          | SDK version                         |
| `environment`     | `SDKEnvironment?` | Configured environment              |
| `isAuthenticated` | `Boolean`         | Control-plane credentials are valid |
| `events`          | `Flow<SdkEvent>`  | Lifecycle and error breadcrumbs     |
| `eventBus`        | `EventBus`        | Category-filtered events            |

`getUserId()` and `getOrganizationId()` return `String?`.

<Note>`isInitialized`, `areServicesReady`, and `isActive` are deprecated. Use `isReady`.</Note>

## Capabilities

```kotlin theme={null}
val capabilities = RunAnywhere.capabilities()
```

Reports the modalities, backends, and audio formats this build can run, plus an `unavailable`
list explaining anything missing.

## Models

```kotlin theme={null}
// What is available
val models = RunAnywhere.models.list()
val model = RunAnywhere.models.get("qwen3-0.6b")

// Get one onto the device
RunAnywhere.models.download("qwen3-0.6b").collect { event ->
    if (event is DownloadEvent.Progress) progress = event.fraction ?: 0f
}

// Load and unload
val loaded = RunAnywhere.models.load("qwen3-0.6b")
RunAnywhere.models.unload("qwen3-0.6b")
RunAnywhere.models.unloadAll(ModelCategory.MODEL_CATEGORY_LANGUAGE)

// Housekeeping
RunAnywhere.models.delete("qwen3-0.6b")
val state = RunAnywhere.models.state()
RunAnywhere.models.refresh()
```

You rarely need `load` directly. Generation auto-loads what it needs and downloads when
`options.model` names a model that is absent.

## LoadOptions

```kotlin theme={null}
val loaded = RunAnywhere.models.load(
    "qwen3-0.6b",
    LoadOptions(contextLength = 4096, threads = 4)
)
```

| Field                | Meaning                    |
|----------------------|----------------------------|
| `backendPreferences` | Ordered backend preference |
| `contextLength`      | Context window to allocate |
| `threads`            | CPU threads                |
| `forceReload`        | Reload even if resident    |
| `framework`          | Pin to one backend         |
| `useGpu`             | Request GPU execution      |

## Registering your own model

```kotlin theme={null}
val info = RunAnywhere.models.register(
    ModelRegistration.url(
        name = "My model",
        url = "https://example.com/model.gguf",
        framework = InferenceFramework.INFERENCE_FRAMEWORK_LLAMA_CPP,
        category = ModelCategory.MODEL_CATEGORY_LANGUAGE
    )
)
```

Three builders exist:

```kotlin theme={null}
ModelRegistration.url(name, url, framework, category)
ModelRegistration.archive(name, url, framework, structure, archiveType)
ModelRegistration.multiFile(id, name, framework, files, category)
```

## Hugging Face token

```kotlin theme={null}
RunAnywhere.setHfToken(token)
```

Needed for gated or private repositories. Hold it in encrypted storage, not in source.

## Events

```kotlin theme={null}
RunAnywhere.events.collect { event ->
    // lifecycle, download, and error breadcrumbs
}
```

## Resetting

```kotlin theme={null}
RunAnywhere.reset()
```

Unloads models, closes sessions, and clears state.
