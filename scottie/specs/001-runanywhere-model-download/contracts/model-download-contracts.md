# Contracts: On-Device Model Downloads

## Repository contract (`domain/repository/ModelRepository.kt`)

```kotlin
interface ModelRepository {
  /** Reconciles with disk (and the remote catalog when reachable), then lists supported models. */
  suspend fun models(): List<EdgeModel>

  /** Live per-model download status; models without an entry are idle. */
  val downloads: StateFlow<Map<String, ModelDownloadStatus>>

  /** Starts or resumes a download; no-op if one is active for [id]. */
  fun download(id: String)

  /** Stops the transfer and waits for it to end, keeping partial bytes; status becomes Paused. */
  suspend fun pause(id: String)

  /** Cancels any transfer, removes files, clears status. Throws ModelRepositoryException. */
  suspend fun delete(id: String)
}
```

- `models()` and `delete()` throw `ModelRepositoryException` (domain type) on SDK failure. SDK
  exception types never leave `data/`.
- Download failures never throw. They surface as `ModelDownloadStatus.Failed`.
- Completion sets `ModelDownloadStatus.Downloaded` in `downloads`; there is no separate completion
  stream.
- Implementation: `data/repository/RunAnywhereModelRepository` (`@Singleton`, bound in `di/`).

## Screen contract (`presentation/features/modeldownload/ModelDownloadScreen.kt`)

```kotlin
sealed interface ModelDownloadState : CircuitUiState {
  val eventSink: (ModelDownloadAction) -> Unit
  data class Loading(...) : ModelDownloadState
  data class Error(...) : ModelDownloadState            // list failed; offers Retry
  data class Loaded(val models: List<ModelDownloadModel>, ...) : ModelDownloadState
}

data class ModelDownloadModel(
  val id: String,
  val name: String,
  val description: String,
  val sizeBytes: Long?,
  val status: ModelDownloadItemStatus,  // Available | Downloading | Paused | Downloaded | Failed
)

sealed interface ModelDownloadAction : CircuitUiEvent {
  data object Back                     // existing
  data object RetryList                // new
  data class Download(val modelId)     // existing; also used for Retry on a failed card
  data class Pause(val modelId)        // existing
  data class Resume(val modelId)       // existing
  data class Delete(val modelId)       // existing
}
```

Presentation changes, as the user allowed:

- `statusText` and `progress` are no longer computed by the presenter. The `Ui` formats them
  from `status` and `sizeBytes` using string resources and `Formatter.formatShortFileSize`, so
  every visible string is localizable (FR-013).
- `ModelDownloadItemState` gains `FAILED`, rendered with a filled **Retry** button.
  `ModelDownloadItemLabels` gains `retry`.
- `Loaded` with an empty list renders an empty-state message (FR-015).

| Status | Card state | Status text | Progress | Buttons |
|--------|-----------|-------------|----------|---------|
| Available | AVAILABLE | "{size} download" / "Size unknown" | none | Download |
| Downloading | DOWNLOADING | "Downloading · {pct}% · {done} / {total}" (bytes omitted for multi-file); "Preparing…" when fraction unknown | fraction or indeterminate | Pause, Delete |
| Paused | PAUSED | "Paused · {pct}%" | fraction | Resume, Delete |
| Downloaded | DOWNLOADED | "Downloaded · {size}" | none | Delete |
| Failed | FAILED | reason message | none | Retry |
