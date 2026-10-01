# Research: On-Device Model Downloads

Source of truth: `runanywhere-sdk-0.20.27-sources.jar` from Maven Central (library sources only, no
models), read alongside the `runanywhere-kotlin` skill. Verified symbols are named exactly.

## R1. SDK version and modules

- **Decision**: `io.github.sanchitmonga22:runanywhere-sdk:0.20.27` plus
  `runanywhere-llamacpp:0.20.27`, added through `gradle/libs.versions.toml`.
- **Rationale**: 0.20.27 is the latest release on Maven Central. The feature is about LLMs, which
  the llama.cpp backend runs (GGUF). The core SDK owns model management.
- **Alternatives**: `runanywhere-onnx` (speech/embeddings, +49 MB) and `runanywhere-qhexrt-android`
  (NPU, +58 MB). Rejected because no speech or NPU feature exists yet; add them when one does.

## R2. Build configuration impact

- **Decision**: Raise `compileOptions` source/target from Java 11 to 17.
- **Rationale**: The SDK requires JDK 17 bytecode. Kotlin inline functions from a 17-target AAR
  cannot be inlined into an 11-target module. minSdk 26, compile/target SDK 37 and Kotlin 2.4.20
  already meet the SDK minimums (24 / 37 / 2.4).
- **Risk**: The SDK's native libraries may collide with the LiteRT/QNN `.so` files already in
  `app/src/main/jniLibs` (for example `libc++_shared.so`). If the merge fails, resolve it with
  `packaging.jniLibs.pickFirsts` for the duplicated file only.

## R3. Initialization

- **Decision**: `RunAnywhere.initialize(context = this)` in `ScottieApplication.onCreate()`
  (keyless local mode).
- **Rationale**: This is the documented overload that wires the Android context into storage and
  model paths. Keyless mode needs no credentials in source.

## R4. Which models count as "supported"

- **Decision**: On screen open, `RunAnywhere.models.refresh(includeRemoteCatalog = true)`, then
  `RunAnywhere.models.list(ModelFilter(framework = InferenceFramework.INFERENCE_FRAMEWORK_LLAMA_CPP))`.
  If refresh fails (offline), still call `list()` so on-device models appear.
- **Rationale**: `ModelFilter.framework` restricts the list to models the bundled backend can run.
  `refresh(rescanLocal = true)` (the default) reconciles the registry with files on disk (FR-009).
- **Risk (unverified)**: The catalog is populated in native code. Whether keyless mode returns
  any remote entries could not be checked without contacting the live catalog, which the spec's
  clarifications forbid. If the list comes back empty, the screen shows its empty state. The fix
  would then be registering a curated set with `ModelRegistration.url(...)`, but that is not
  built now (YAGNI).

## R5. Pause / Resume

- **Decision**: Keep Pause and Resume. Pause cancels the collecting coroutine; Resume calls
  `models.download(id)` again.
- **Rationale**: The `ModelsNamespace.download` KDoc says "Cancelling the flow stops the transfer
  and preserves resume bytes". `RunAnywhereDownload.kt` cancels with
  `delete_partial_bytes = false`, and resume is planner-driven. This supersedes the spec
  assumption that Pause/Resume would become Cancel (spec updated). Delete on a paused model calls
  `models.delete(id)`.
- **Note**: `DownloadEvent.Cancelled` exists but `download()` never emits it, because coroutine
  cancellation ends the flow instead. The app tracks the paused state itself.

## R6. Download event mapping

`download(id): Flow<DownloadEvent>` (not suspending) emits these events:

| SDK event | App status |
|-----------|------------|
| `Started` | Downloading, progress unknown |
| `Progress` | Downloading. `fraction` (= `overallProgress`, null until known) gives the progress; `bytesDone`/`bytesTotal` are shown only when `totalFiles == 1`, because for multi-file models they are per-file figures |
| `Verifying`, `Extracting` | Finishing, progress unknown |
| `Completed` | Downloaded |
| `Failed(error: SDKException)` | Failed(reason) |

An `SDKException` thrown at collection time (for example `modelNotFound`) maps to Failed.
`CancellationException` is rethrown, never mapped.

## R7. Failure reasons

Map `SDKException.code` (`ProtoErrorCode`) to the following reasons:

- `ERROR_CODE_NETWORK_UNAVAILABLE`, `ERROR_CODE_NETWORK_ERROR` → NoConnection
- `ERROR_CODE_INSUFFICIENT_STORAGE` → InsufficientStorage
- `ERROR_CODE_UNAUTHORIZED`, `ERROR_CODE_FORBIDDEN`, `ERROR_CODE_AUTHENTICATION_FAILED` →
  AccessRequired
- anything else → Unknown

## R8. Gated models

- **Decision**: Gated models are detected on failure (AccessRequired), not up front.
- **Rationale**: `ModelInfo` has no gating or access field. Hiding Download up front (spec FR-012)
  is impossible, so FR-012 is amended to "explain access is required when a download is refused".

## R9. Model display fields

`ModelInfo.id`, `name`, `metadata?.description` (fallback string resource when blank),
`download_size_bytes` (0 → size unknown), and `local_path.isNotEmpty()` → downloaded.
`registry_status` is optional, so the app relies on `local_path`, which `unregister()` also uses.

## R10. Download lifetime and ownership

- **Decision**: An `@Singleton` repository owns an application `CoroutineScope`
  (`SupervisorJob() + Dispatchers.IO`), with one `Job` per model id in a `ConcurrentHashMap`, and a
  `MutableStateFlow<Map<String, ModelDownloadStatus>>` changed only through `update {}`. `pause`
  and `delete` use `cancelAndJoin()` before writing status, so a late progress event cannot
  overwrite Paused. A cancelled job's `finally` never writes status.
- **Rationale**: FR-005 requires downloads to survive navigation, and presenter scopes end with
  the screen. After process death, partial bytes stay on disk and the model reads as available; the
  next Download resumes them (edge case satisfied).

## R11. Verification without real downloads (FR-014)

- **Decision**: Presenter tests (Circuit `test {}` + Turbine) against a fake `ModelRepository`
  that emits scripted progress. Failure mapping is tested as a pure function over `ProtoErrorCode`
  so it needs no SDK runtime. Compose previews cover every card state. No instrumented test
  launches the app, because `Application.onCreate` would start the SDK's background catalog
  fetch.
- **Alternatives**: Robolectric or device tests with the real SDK were rejected because they would
  contact the live catalog.

## R12. Screen reachability

- **Decision**: Make `ModelDownloadScreen` the back-stack root and remove the unused
  `StaticScreen`, which has no registered UI.
- **Rationale**: Nothing else navigates to the download screen. Back on the root finishes the
  activity through the existing `onRootPop`.
