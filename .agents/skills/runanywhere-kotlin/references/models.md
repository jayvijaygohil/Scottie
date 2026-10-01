# Models

> Find, download, load, switch, and remove models

`RunAnywhere.models` is the model catalog and its residency. Everything about getting a model
onto the device and into memory lives here.

```kotlin theme={null}
import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.*
```

## The short version

You often do not need this page. Generation loads what it needs and downloads when
`options.model` names a model that is not on disk:

```kotlin theme={null}
val result = RunAnywhere.llm.generate("Hello", LlmOptions(model = "qwen3-0.6b"))
```

Reach for the `models` namespace when you want to control **when** that cost is paid, show
download progress, or let a person choose.

## What is available

```kotlin theme={null}
val models = RunAnywhere.models.list()
val language =
    RunAnywhere.models.list(ModelFilter(category = ModelCategory.MODEL_CATEGORY_LANGUAGE))
val model = RunAnywhere.models.get("qwen3-0.6b")
```

## Downloading, with progress

`download` returns a `Flow<DownloadEvent>`. Models are hundreds of megabytes to several
gigabytes, so show this rather than a spinner.

```kotlin theme={null}
RunAnywhere.models.download("qwen3-0.6b").collect { event ->
    when (event) {
        is DownloadEvent.Progress -> {
            _fraction.value = event.fraction ?: 0f
            _speed.value = event.bytesPerSecond
        }
        is DownloadEvent.Completed -> _ready.value = true
        else -> {}
    }
}
```

`DownloadEvent.Progress` carries `bytesDone`, `bytesTotal`, `fraction`, `percent`,
`bytesPerSecond`, `etaSeconds`, `retryAttempt`, `currentFileIndex`, `totalFiles`, and
`overallProgress`. A multi-file model reports both the current file and the overall figure.

Collect this in a scope that outlives the screen if you want the download to survive
navigation, or in `viewModelScope` if it should be cancelled with the screen.

## Loading

Downloading puts the model on disk. Loading puts it in memory.

```kotlin theme={null}
val loaded = RunAnywhere.models.load("qwen3-0.6b")
```

With options:

```kotlin theme={null}
val loaded = RunAnywhere.models.load(
    "qwen3-0.6b",
    LoadOptions(contextLength = 4096, threads = 4)
)
```

| Field                | Meaning                                  |
|----------------------|------------------------------------------|
| `backendPreferences` | Ordered preference; each can be required |
| `accelerator`        | Accelerator policy                       |
| `contextLength`      | Context window to allocate               |
| `threads`            | CPU threads                              |
| `forceReload`        | Reload even if already resident          |
| `framework`          | Pin to one backend                       |
| `useGpu`             | Request GPU execution                    |

`contextLength` is the one that matters most. A larger window costs memory whether you use it
or not, so allocate what your longest conversation actually needs.

### Forcing the NPU

On Snapdragon hardware, pin the backend to compare against CPU:

```kotlin theme={null}
LoadOptions(framework = InferenceFramework.INFERENCE_FRAMEWORK_QHEXRT)
```

QHexRT is arm64 only and rejects parts outside the validated V75, V79, and V81 set, so this
throws on an emulator or an unsupported chip rather than silently falling back.

## Switching models

```kotlin theme={null}
class ModelSwitcher : ViewModel() {
    private var current: String? = null

    suspend fun use(id: String) {
        current?.takeIf { it != id }?.let { RunAnywhere.models.unload(it) }
        RunAnywhere.models.load(id)
        current = id
    }
}
```

On a phone, unload before loading rather than after. Holding two language models at once is
how you get `ERROR_CODE_INSUFFICIENT_MEMORY`.

You can also switch per call, without touching residency:

```kotlin theme={null}
RunAnywhere.llm.generate(prompt, LlmOptions(model = "qwen3-0.6b"))
RunAnywhere.llm.generate(prompt, LlmOptions(model = "llama-3.2-1b"))
```

Simpler, and slower when you alternate.

## Unloading

```kotlin theme={null}
RunAnywhere.models.unload("qwen3-0.6b")
RunAnywhere.models.unloadAll(ModelCategory.MODEL_CATEGORY_LANGUAGE)
RunAnywhere.models.unloadAll()
```

Frees memory and leaves the file on disk, so the next load is fast. Do this in `onCleared`,
and when the app backgrounds if you hold several models.

## What is resident right now

```kotlin theme={null}
val state = RunAnywhere.models.state()
```

## Deleting

```kotlin theme={null}
RunAnywhere.models.delete("qwen3-0.6b")
```

Removes the file from disk, unloading first if it is resident.

## Registering your own model

Three builders on `ModelRegistration`:

```kotlin theme={null}
// A single file by URL
RunAnywhere.models.register(
    ModelRegistration.url(
        name = "My model",
        url = "https://example.com/model.gguf",
        framework = InferenceFramework.INFERENCE_FRAMEWORK_LLAMA_CPP,
        category = ModelCategory.MODEL_CATEGORY_LANGUAGE
    )
)

// An archive, with the structure inside declared
RunAnywhere.models.register(
    ModelRegistration.archive(
        name = "My model",
        url = "https://example.com/model.tar.gz",
        framework = InferenceFramework.INFERENCE_FRAMEWORK_ONNX,
        structure = structure,
        archiveType = archiveType
    )
)

// A multi-file model
RunAnywhere.models.register(
    ModelRegistration.multiFile(
        id = "my-vlm",
        name = "My VLM",
        framework = InferenceFramework.INFERENCE_FRAMEWORK_LLAMA_CPP,
        files = descriptors,
        category = ModelCategory.MODEL_CATEGORY_VISION
    )
)
```

A vision model with a separate projector, or a speech model with encoder and decoder files, is
the multi-file case.

### Gated repositories

```kotlin theme={null}
RunAnywhere.setHfToken(token)
```

Needed for private or gated Hugging Face repos, including the `runanywhere/*_HNPU` NPU
bundles. Hold it in `EncryptedSharedPreferences` or the Keystore, never in source, assets, or
logs.

## Refreshing the registry

```kotlin theme={null}
RunAnywhere.models.refresh()
```

Reconciles the catalog against the bytes actually on disk.

## A complete picker

```kotlin theme={null}
class ModelPickerViewModel : ViewModel() {
    private val _models = MutableStateFlow<List<ModelInfo>>(emptyList())
    val models = _models.asStateFlow()

    private val _downloading = MutableStateFlow<String?>(null)
    val downloading = _downloading.asStateFlow()

    private val _fraction = MutableStateFlow(0f)
    val fraction = _fraction.asStateFlow()

    fun refresh() {
        viewModelScope.launch {
            _models.value = RunAnywhere.models.list(
                ModelFilter(category = ModelCategory.MODEL_CATEGORY_LANGUAGE)
            )
        }
    }

    fun download(id: String) {
        viewModelScope.launch {
            _downloading.value = id
            _fraction.value = 0f
            try {
                RunAnywhere.models.download(id).collect { event ->
                    if (event is DownloadEvent.Progress) {
                        _fraction.value = event.fraction ?: 0f
                    }
                }
                refresh()
            } finally {
                _downloading.value = null
            }
        }
    }

    fun use(id: String) {
        viewModelScope.launch {
            RunAnywhere.models.unloadAll(ModelCategory.MODEL_CATEGORY_LANGUAGE)
            RunAnywhere.models.load(id)
        }
    }

    fun delete(id: String) {
        viewModelScope.launch {
            RunAnywhere.models.delete(id)
            refresh()
        }
    }
}
```

## Errors worth handling

| Code                              | Cause                            |
|-----------------------------------|----------------------------------|
| `ERROR_CODE_MODEL_NOT_FOUND`      | The id is not in the registry    |
| `ERROR_CODE_INSUFFICIENT_STORAGE` | Not enough disk for the download |
| `ERROR_CODE_INSUFFICIENT_MEMORY`  | The model will not fit in RAM    |
| `ERROR_CODE_NETWORK_UNAVAILABLE`  | A download needs a connection    |

`ERROR_CODE_INSUFFICIENT_MEMORY` on load usually means something else is still resident.
Unload first.
