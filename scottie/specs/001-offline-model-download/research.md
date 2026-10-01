# Research: Offline Model Download

Sources: installed SDK binaries (`runanywhere-sdk`/`llamacpp`/`onnx` 0.20.27, `qhexrt-android`
0.20.19, verified with `javap` and sources jars), `.agents/skills/runanywhere-kotlin`, and the
`reference/` app (pattern source only; deleted after implementation).

## R1. SDK initialization order

- **Decision**: On first use, on an IO dispatcher: `LlamaCPP.register()` → `ONNX.register()` →
  `RunAnywhere.initialize(context = app)` → `QHexRT.register()`. Each backend register is wrapped in
  try/catch; a failed `initialize` puts the catalog in an unavailable state.
- **Rationale**: CPU backends must be registered before `initialize` (otherwise -422 on load); QHexRT
  needs the SDK-held context so it comes after. The context overload is required so model files live
  under `Context.filesDir`. `initialize` is synchronous and throws `SDKException`.
- **Alternatives**: `initialize(apiKey = "", baseUrl = "")` as the skill shows — rejected, it never
  installs an Android context (storage falls back to JVM paths, QHexRT cannot extract skels).
  `completeServicesInitialization()` — deprecated.

## R2. Catalog source and registration

- **Decision**: Port the reference catalog (all categories) as a static Kotlin list in `data/`,
  dropping rows that need a Hugging Face token. Register every row on each launch, sequentially, on
  IO, after first frame; the screen shows a loading state meanwhile. Llama.cpp/ONNX/Sherpa rows use
  `ModelRegistration.url|multiFile|archive`; NPU rows use `QHexRT.registerModelForDevice(...)`, which
  returns `null` on unsupported devices.
- **Rationale**: Spec FR-001 (reference catalog, all types, hide what the device cannot run).
  Registration is merge-safe (keeps downloaded state via the `.rac-manifest` sidecar). ~13 s for ~105
  rows in the reference, so it must not block startup.
- **Alternatives**: `RunAnywhere.models.list()` alone as the catalog — rejected, nothing is listed
  until registered. Remote catalog — out of scope (spec assumption).
- **Model description**: The reference catalog has no per-model descriptions. Each row shows its
  type ("Speech recognition", "Text", …) from a string resource as the short description.

## R3. Download, pause, resume, retry

- **Decision**: `RunAnywhere.models.download(id): Flow<DownloadEvent>` collected in a coroutine owned
  by the repository. Pause = cancel that coroutine. Resume and Retry = call `download(id)` again.
- **Rationale**: No public pause/resume API exists. On cancellation the SDK calls native cancel with
  `delete_partial_bytes = false`; a later `download(id)` revalidates and reuses partial bytes.
- **Event semantics** (binary, differs from skill doc):
  - `Started` → ignore; `Progress(bytesDone, bytesTotal, fraction?, …)` → transferring;
    `Verifying` / `Extracting` → post-transfer phase; `Completed` → downloaded.
  - `Failed(SDKException)` is **emitted, not thrown**, then the flow completes normally.
    `Failed` with `ErrorCode.ERROR_CODE_CANCELLED` is a pause, not a failure.
  - `Cancelled` is never emitted by `download`; local cancel surfaces as `CancellationException`.
  - Unknown id throws `SDKException(MODEL_NOT_FOUND)` from collect.
  - Flow ending without `Completed` → treated as paused (resumable), never downloaded (FR-009).
- **Alternatives**: WorkManager — rejected; the SDK owns transfer, retries and resume, and an
  expedited/long-running worker still needs a foreground notification; adds a dependency for no gain.

## R4. Failure reasons

- **Decision**: Map `SDKException.code` to a small domain enum rendered from string resources:
  network (`NETWORK_UNAVAILABLE`, `NETWORK_ERROR`, `TIMEOUT`, `DOWNLOAD_FAILED`), storage
  (`INSUFFICIENT_STORAGE`, `STORAGE_FULL`, `STORAGE_ERROR`, `FILE_WRITE_FAILED`), corrupted
  (`CHECKSUM_MISMATCH`, `EXTRACTION_FAILED`, `UNSUPPORTED_ARCHIVE`, `PARTIAL_DOWNLOAD`),
  background-start refused, and unknown (fallback "Download failed").
- **Rationale**: FR-008 requires human-readable, localizable reasons; raw SDK messages are English
  fragments. Import `ai.runanywhere.proto.v1.ErrorCode` (skill's `ProtoErrorCode` is a private alias).

## R5. Downloaded state and delete

- **Decision**: Downloaded = `ModelInfo.isDownloadedOnDisk` (extension in
  `com.runanywhere.sdk.public.extensions.Models`), read via `models.list()` after registration and
  re-read after each completion or delete. Delete = `RunAnywhere.models.delete(id)` (throws
  `SDKException` on failure; keeps registration). Delete is offered only for downloaded models.
- **Rationale**: `local_path` may remain after deletion, so it is not trusted alone. Discarding
  partial bytes of paused/failed downloads is not required by the spec.

## R6. Background execution

- **Decision**: Downloads run in the repository's application-lifetime coroutine scope. A
  `dataSync` foreground service (`ModelDownloadService`, `@AndroidEntryPoint`) only keeps the process
  alive and renders the notification: it observes the repository, shows progress (≤ 1 update/s) with
  a Cancel action (→ pause), posts an outcome notification (ready / paused / failed), holds a partial
  wake lock with a timeout, and stops itself when no download is active. `onTimeout` (Android 15
  dataSync limit) pauses the download. `START_NOT_STICKY`.
- **Rationale**: Spec FR-012a. Keeping the transfer out of the service means one owner of download
  state, testable on the JVM; the reference's static companion state, generation stamps,
  pending-model map, and ContextProvider are unnecessary with a Hilt singleton and one download at a
  time.
- **Start failure**: `ContextCompat.startForegroundService` can throw
  (`ForegroundServiceStartNotAllowedException`); the repository then marks the model failed with the
  "background refused" reason (spec edge case).
- **Permissions**: `FOREGROUND_SERVICE`, `FOREGROUND_SERVICE_DATA_SYNC`, `POST_NOTIFICATIONS`,
  `WAKE_LOCK`, `ACCESS_NETWORK_STATE`. `POST_NOTIFICATIONS` is requested just-in-time on the first
  Download tap on Android 13+; the download proceeds whether granted or denied.
- **Process death**: In-memory paused/failed records are lost; the row reads Available and Download
  resumes from the SDK's partial bytes. Acceptable per spec edge case.

## R7. Testability

- **Decision**: Two seams with fakes in tests (no mocking library is installed; none added):
  - `ModelRuntime` (data): wraps all `RunAnywhere.*`/`QHexRT.*` calls and maps SDK types to
    data-layer types. Production impl `RunAnywhereModelRuntime`.
  - `DownloadForegroundHost` (data): starts the foreground service; returns whether it started.
  The SDK is a JNI-backed `object` with a final internal-constructor namespace and needs a `Context`,
  so it cannot run in JVM tests.
- **Rationale**: Constitution IV (fakes, no live infrastructure); spec FR-015 (no real downloads).
- **SDK event mapping** is a pure function over `DownloadEvent`; its unit test constructs SDK event
  and `SDKException` instances (plain JVM classes) — if class loading fails on the JVM, the mapping
  is covered through the repository tests via the fake instead.

## R8. Presentation

- **Decision**: Add `ModelDownloadPresenter` (assisted `Navigator`). State carries structured status
  (no preformatted strings); the UI formats sizes with `android.text.format.Formatter` and copy from
  string resources. Add `FAILED` row state with Retry; remove Delete from downloading/paused rows;
  disable Download on other rows while one is active (`XelaButtonState`); show the loading,
  unavailable, and delete-error states (delete error via `XelaToast`). Make `ModelDownloadScreen`
  the navigation root, replacing the placeholder `StaticScreen`. Fix title typo "Download Modals".
- **Rationale**: Constitution II (presenter owns actions; string resources), spec FR-007/FR-012/FR-013.
