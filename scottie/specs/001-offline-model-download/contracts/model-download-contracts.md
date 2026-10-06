# Contracts: Offline Model Download

Signatures are design intent; types are defined in [data-model.md](../data-model.md).

## Domain: `ModelDownloadRepository` (`feature/modeldownload/domain/repository/`)

```kotlin
interface ModelDownloadRepository {
  /** Loading until the runtime is initialized and the catalog registered. */
  val catalog: StateFlow<ModelCatalog>
  /** Starts, resumes, or retries. Ignored while another model is downloading. */
  fun download(modelId: String)
  /** Stops the active transfer, keeping bytes. No-op unless [modelId] is downloading. */
  fun pause(modelId: String)
  /** Removes a downloaded model's files. Failure leaves the entry Downloaded. */
  suspend fun delete(modelId: String): Result<Unit>
}
```

Implementation `ModelDownloadRepositoryImpl` (`feature/modeldownload/data/repository/`), `@Singleton`, owns the download
coroutine in an injected application scope.

## Data seam: `ModelRuntime` (`feature/modeldownload/data/ai/provider/`)

```kotlin
interface ModelRuntime {
  /** Registers backends, initializes the SDK, registers [catalog]; returns ids the device accepts. */
  suspend fun prepare(catalog: List<CatalogModel>): Set<String>
  suspend fun downloadedIds(): Set<String>
  fun download(modelId: String): Flow<RuntimeDownloadEvent>
  suspend fun delete(modelId: String)
}

sealed interface RuntimeDownloadEvent {
  data class Progress(val progress: DownloadProgress) : RuntimeDownloadEvent
  data object Completed : RuntimeDownloadEvent
  data object Cancelled : RuntimeDownloadEvent           // Failed(ERROR_CODE_CANCELLED)
  data class Failed(val reason: DownloadFailure) : RuntimeDownloadEvent
}
```

Production: `RunAnywhereModelRuntime`. `Started` is dropped; verifying/extracting become `Progress`
with the matching phase. Throws on `prepare` failure.

## Data seam: `DownloadForegroundHost` (`feature/modeldownload/data/ai/provider/`)

```kotlin
interface DownloadForegroundHost {
  /** Starts the foreground download service; false if the system refused. */
  fun start(): Boolean
}
```

Production: `ServiceDownloadForegroundHost` → `ContextCompat.startForegroundService`.
`ModelDownloadService` observes `catalog` for the `Downloading` entry and calls `pause` from its
notification Cancel action and `onTimeout`.

## Presentation: Circuit contract (`feature/modeldownload/presentation/`)

```kotlin
@Parcelize data object ModelDownloadScreen : ParcelableScreen   // navigation root

data class ModelDownloadState(
  val content: ModelDownloadContent,      // Loading | Unavailable | Models(List<ModelDownloadModel>)
  val deleteFailedModelName: String?,     // one-shot error
  val eventSink: (ModelDownloadAction) -> Unit,
) : CircuitUiState

data class ModelDownloadModel(
  val id: String,
  val name: String,
  val type: ModelType,
  val downloadBytes: Long?,
  val status: ModelDownloadStatus,
  val canStart: Boolean,                   // false while another model downloads
)

sealed interface ModelDownloadAction : CircuitUiEvent {
  data object Back
  data class Download(val modelId: String)  // also Resume and Retry
  data class Pause(val modelId: String)
  data class Delete(val modelId: String)
  data object DismissError
}
```

`ModelDownloadPresenter` (`@AssistedInject` with `Navigator`): maps the repository catalog to state;
`Back` → `navigator.pop()`; delete failures set `deleteFailedModelName`.
