---

description: "Task list for Offline Model Download"
---

# Tasks: Offline Model Download

**Input**: Design documents from `/specs/001-offline-model-download/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/model-download-contracts.md,
quickstart.md

**Tests**: Requested (spec FR-015). All tests are JVM unit tests using hand-written fakes; no test may
call the RunAnywhere SDK, the network, or touch model files.

**Organization**: Tasks are grouped by user story to enable independent implementation and testing.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (US1–US4)

## Path Conventions

All paths are relative to the repository root `Scottie/`. `PKG` =
`app/src/main/java/com/jayvijay/scottie`, `TEST` = `app/src/test/java/com/jayvijay/scottie`.
Read the root and layer `AGENTS.md` files and `.specify/memory/constitution.md` before editing a layer.

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Manifest and resource groundwork shared by all stories

- [X] T001 Add permissions `ACCESS_NETWORK_STATE`, `FOREGROUND_SERVICE`, `FOREGROUND_SERVICE_DATA_SYNC`,
  `POST_NOTIFICATIONS`, `WAKE_LOCK` and declare `<service android:name=".feature.modeldownload.data.ai.provider.ModelDownloadService"
  android:exported="false" android:foregroundServiceType="dataSync" />` in `app/src/main/AndroidManifest.xml`
  (research R6)
- [X] T002 [P] Fix `model_download_title` to "Download models" and add string resources for model type
  labels (one per `ModelType`), loading, unavailable, status lines (available size, downloading
  percent/bytes, checking, unpacking, paused bytes kept, failed + reason, downloaded size), Retry, the
  five `DownloadFailure` reasons with fallback "Download failed", delete error, and notification
  channel/title/Cancel/ready/paused/failed copy in `app/src/main/res/values/strings.xml`. Use format
  arguments, not concatenation.

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Domain types, seams, catalog, SDK wrapper, DI, and test fakes used by every story

**⚠️ CRITICAL**: No user story work can begin until this phase is complete

- [X] T003 [P] Create domain entities `Model`, `ModelType`, `DownloadProgress`, `DownloadPhase`,
  `ModelDownloadStatus`, `DownloadFailure`, `ModelEntry`, `ModelCatalog` in `PKG/feature/modeldownload/domain/entities/ModelDownload.kt`
  exactly per data-model.md: `fraction` is "0..1; null → indeterminate", `bytesTotal` "0 when unknown",
  `downloadBytes` "null when unknown"; no Android/SDK imports
- [X] T004 [P] Create `ModelDownloadRepository` interface (declarations only) in
  `PKG/feature/modeldownload/domain/repository/ModelDownloadRepository.kt` per contracts
- [X] T005 [P] Create `ModelRuntime` interface and `RuntimeDownloadEvent` in `PKG/feature/modeldownload/data/ai/provider/ModelRuntime.kt`
  per contracts
- [X] T006 [P] Create `DownloadForegroundHost` interface in `PKG/feature/modeldownload/data/ai/provider/DownloadForegroundHost.kt` per
  contracts (production impl added in US1)
- [X] T007 Port the static catalog to `PKG/feature/modeldownload/data/ai/provider/ModelCatalog.kt`. Source (reference only; do not copy
  unrelated features): `reference/main/java/com/runanywhere/runanywhereai/data/ModelCatalog.kt`,
  `.../data/CatalogModel.kt` (`SingleFileModel`, `MultiFileModel`, `ArchiveModel`, `ModelFile`), and the NPU
  registration path in `.../data/ModelBootstrap.kt`. Rules: keep all categories (language, multimodal, vision,
  embedding, STT, TTS, VAD, segmentation, image generation) for llama.cpp/ONNX/Sherpa rows and the QHexRT NPU
  rows; drop rows that require a Hugging Face token (`QHexRT.modelRequiresHfAuth` / `requiresHfAuth`); drop
  LoRA, cloud, CUA profile usage. Each `CatalogModel` exposes `id`, `name`, `category`, `framework`,
  `downloadBytes` and its registration shape. Ids MUST be unique.
- [X] T008 Implement `RunAnywhereModelRuntime` in `PKG/feature/modeldownload/data/ai/provider/RunAnywhereModelRuntime.kt`:
  `prepare` = `LlamaCPP.register()` → `ONNX.register()` (each try/catch) → `RunAnywhere.initialize(context = app)`
  (throws on failure) → `QHexRT.register()` → register every row (`ModelRegistration.url|multiFile|archive`;
  NPU rows via `QHexRT.registerModelForDevice`, null = rejected) on `Dispatchers.IO`, per-row try/catch
  rethrowing `CancellationException`; returns accepted ids. `downloadedIds` from `models.list()` +
  `isDownloadedOnDisk`. `download` maps `DownloadEvent` → `RuntimeDownloadEvent` (drop `Started`;
  `Verifying`/`Extracting` → progress with phase and `fraction = 1f`, carrying last bytes; `Failed` with
  `ErrorCode.ERROR_CODE_CANCELLED` → `Cancelled`; other `Failed` → reason per research R4; import
  `ai.runanywhere.proto.v1.ErrorCode`). `delete` → `RunAnywhere.models.delete(id)`. Map `ModelCategory` →
  `ModelType`. Verify every signature against the installed SDK (research R1–R5).
- [X] T009 Provide an application `CoroutineScope` (`SupervisorJob() + Dispatchers.Default`, qualified) and bind
  `ModelRuntime` → `RunAnywhereModelRuntime` in `PKG/di/DataModule.kt` (add an abstract `@Binds` module beside
  the existing object module)
- [X] T010 [P] Create `FakeModelRuntime` (scriptable `prepare` result/throw, downloaded ids, per-id
  `MutableSharedFlow`/channel of `RuntimeDownloadEvent`, records cancellation and delete calls, delete
  can throw) in `TEST/feature/modeldownload/data/ai/provider/FakeModelRuntime.kt`
- [X] T011 [P] Create `FakeDownloadForegroundHost` (configurable start result, start count) in
  `TEST/feature/modeldownload/data/ai/provider/FakeDownloadForegroundHost.kt`
- [X] T012 [P] Add `ModelCatalogTest` asserting unique ids and non-blank names/urls in
  `TEST/feature/modeldownload/data/ai/provider/ModelCatalogTest.kt`

**Checkpoint**: Foundation ready — user story implementation can begin

---

## Phase 3: User Story 1 - Download a model for offline use (Priority: P1) 🎯 MVP

**Goal**: List models, download one with live progress (also in a background notification), show it
downloaded and keep it across restarts.

**Independent Test**: Unit tests below pass; on device, download a small model, leave the app, return,
restart in airplane mode — row reads Downloaded (quickstart manual steps 1–4, 7–8).

### Tests for User Story 1 ⚠️

> Write these tests FIRST and ensure they FAIL before implementation.

- [X] T013 [P] [US1] In `TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt` (kotlinx-coroutines-test +
  Turbine): catalog `Loading` → `Ready` with downloaded ids applied; `prepare` throws → `Unavailable`; NPU row
  not accepted by device hidden unless already downloaded; download → `Downloading(progress)` → `Completed` →
  `Downloaded`; verifying/extracting phases keep `fraction = 1f`; second `download` while one active is
  ignored; foreground host started once per download
- [X] T014 [P] [US1] Create `FakeModelDownloadRepository` in
  `TEST/feature/modeldownload/presentation/FakeModelDownloadRepository.kt` and `ModelDownloadPresenterTest`
  in `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt` (circuit-test `FakeNavigator`,
  `presenterTestOf`): loading/unavailable/models content mapping; `canStart = false` on other rows while one
  downloads; `Download` forwards to repository; `Back` pops navigator

### Implementation for User Story 1

- [X] T015 [US1] Implement `ModelDownloadRepositoryImpl` (`@Singleton`) in
  `PKG/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`: launch `prepare` on the app scope on first creation,
  build `catalog` StateFlow; `download(id)` ignored if any entry is `Downloading`, else start foreground host
  then collect `runtime.download(id)` in one tracked `Job`, updating status; on `Completed` set `Downloaded`
  (FR-009). Bind it to `ModelDownloadRepository` in `PKG/di/DataModule.kt`.
- [X] T016 [US1] Implement `ServiceDownloadForegroundHost` (`ContextCompat.startForegroundService` with
  `@ApplicationContext`, returns false on exception) in `PKG/feature/modeldownload/data/ai/provider/DownloadForegroundHost.kt` and bind
  it in `PKG/di/DataModule.kt`
- [X] T017 [US1] Implement `ModelDownloadService` (`@AndroidEntryPoint`, `START_NOT_STICKY`) in
  `PKG/feature/modeldownload/data/ai/provider/ModelDownloadService.kt`: `startForeground` immediately with type `DATA_SYNC`
  (`ServiceCompat`), low-importance channel, observe repository `catalog` for the `Downloading` entry, update
  progress notification at most once per second (content intent opens `MainActivity`), post a separate
  "ready" outcome notification on completion, partial wake lock with timeout released on stop/destroy,
  `stopForeground(REMOVE)` + `stopSelf` when nothing is downloading. Skip notifications when not permitted.
- [X] T018 [US1] Update `PKG/feature/modeldownload/presentation/ModelDownloadScreen.kt` to the contract state
  (`ModelDownloadContent`, `ModelDownloadModel` with `type`, `downloadBytes`, `status`, `canStart`;
  actions `Back`, `Download`, `Pause`, `Delete`, `DismissError`; drop `statusText` and `Resume`)
- [X] T019 [US1] Create `ModelDownloadPresenter` with `@AssistedInject` `Navigator`, `@AssistedFactory`, and
  `@CircuitInject(ModelDownloadScreen::class, SingletonComponent::class)` in
  `PKG/feature/modeldownload/presentation/ModelDownloadPresenter.kt`
- [X] T020 [US1] Adapt `PKG/feature/modeldownload/presentation/component/ModelDownloadCard.kt`: render from
  structured status (type label as description, size via `android.text.format.Formatter`, percent/bytes,
  checking/unpacking line, indeterminate bar when `fraction` null); Downloading row shows Pause only;
  Download disabled via `XelaButtonState` when `canStart` is false; update previews
- [X] T021 [US1] Update `PKG/feature/modeldownload/presentation/ModelDownloadUi.kt`: loading and unavailable
  states, list of rows, request `POST_NOTIFICATIONS` just-in-time on first Download tap on API 33+ and
  dispatch `Download` regardless of result; previews with representative state
- [X] T022 [US1] Make `ModelDownloadScreen` the back-stack root and remove placeholder `StaticScreen` in
  `PKG/MainActivity.kt`

**Checkpoint**: US1 functional — models download, show progress, persist

---

## Phase 4: User Story 2 - Recover from a failed download (Priority: P2)

**Goal**: Failures show a readable reason and Retry continues from retained bytes.

**Independent Test**: Unit tests below pass; on device, toggle airplane mode mid-download → Failed
(network) → Retry resumes (quickstart manual step 6).

### Tests for User Story 2 ⚠️

- [X] T023 [P] [US2] Extend `TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt`: `Failed(STORAGE)` and
  other reasons → `Failed` with reason and bytes kept; unexpected exception → `Failed(UNKNOWN)`; foreground
  host returns false → `Failed(BACKGROUND_REFUSED)` and runtime download not started; Retry (`download`)
  from `Failed` → `Downloading`
- [X] T024 [P] [US2] Extend `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`: failed
  entry maps to failed row; Retry dispatches `Download`

### Implementation for User Story 2

- [X] T025 [US2] Handle `RuntimeDownloadEvent.Failed`, non-cancellation exceptions, and refused foreground
  start in `PKG/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`, keeping last `bytesDone` as `bytesKept`
- [X] T026 [US2] Post a "failed" outcome notification in `PKG/feature/modeldownload/data/ai/provider/ModelDownloadService.kt`
- [X] T027 [US2] Add `FAILED` row state with reason line and Retry (primary) in
  `PKG/feature/modeldownload/presentation/component/ModelDownloadCard.kt`, styled distinctly from paused;
  add a preview

**Checkpoint**: US1 + US2 work independently

---

## Phase 5: User Story 3 - Pause and resume a download (Priority: P2)

**Goal**: Pause keeps bytes, reads as paused (not failed), and Resume continues.

**Independent Test**: Unit tests below pass; on device, Cancel from the notification → Paused with bytes
kept → Resume continues (quickstart manual step 5).

### Tests for User Story 3 ⚠️

- [X] T028 [P] [US3] Extend `TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt`: `pause` cancels the
  runtime flow and yields `Paused(bytesKept)`; `Cancelled` event → `Paused`; flow completing without
  `Completed` → `Paused`, never `Downloaded`; `pause` on non-downloading id is a no-op; Resume from `Paused`
  → `Downloading`
- [X] T029 [P] [US3] Extend `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`: `Pause`
  forwards to repository; paused entry maps to paused row

### Implementation for User Story 3

- [X] T030 [US3] Implement `pause`, `Cancelled` handling, and premature flow completion → `Paused` in
  `PKG/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`
- [X] T031 [US3] Add notification Cancel action (service intent → `repository.pause`), `onTimeout` → pause,
  and "paused" outcome notification in `PKG/feature/modeldownload/data/ai/provider/ModelDownloadService.kt`
- [X] T032 [US3] Render paused row (bytes kept line, Resume primary, neutral styling) in
  `PKG/feature/modeldownload/presentation/component/ModelDownloadCard.kt`

**Checkpoint**: US1–US3 work independently

---

## Phase 6: User Story 4 - Delete a downloaded model (Priority: P3)

**Goal**: Remove a downloaded model and free storage; failures are reported.

**Independent Test**: Unit tests below pass; on device, Delete → row Available (quickstart manual step 9).

### Tests for User Story 4 ⚠️

- [X] T033 [P] [US4] Extend `TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt`: delete success →
  `Available`; delete throws → stays `Downloaded` and returns failure
- [X] T034 [P] [US4] Extend `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`: delete
  failure sets `deleteFailedModelName`; `DismissError` clears it

### Implementation for User Story 4

- [X] T035 [US4] Implement `delete` in `PKG/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`
- [X] T036 [US4] Handle `Delete`/`DismissError` and the one-shot error in
  `PKG/feature/modeldownload/presentation/ModelDownloadPresenter.kt`
- [X] T037 [US4] Show delete error with `XelaToast` in `PKG/feature/modeldownload/presentation/ModelDownloadUi.kt`

**Checkpoint**: All user stories functional

---

## Phase 7: Polish & Cross-Cutting Concerns

- [X] T038 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug` and fix
  findings in touched files
- [X] T039 Run quickstart.md manual validation on a physical arm64 device (if available) and record results
  - 2026-10-01, Pixel 11 (Tensor G6, API 37): all nine steps pass. Agent-run: list load, live progress,
    ready notification, delete, in-app Pause → "Paused · 125 MB kept" → Resume from kept bytes,
    notification Cancel → "Paused · 1.1 GB kept" + paused notification, service stops. User-run:
    airplane mode → Failed + Retry resumes; offline relaunch keeps Downloaded; permission prompt on
    first tap, download proceeds either way.
  - Findings: (1) SDK refuses models exceeding free RAM (`ERROR_CODE_INSUFFICIENT_MEMORY`), shown as
    generic "Download failed" and still offered (FR-001/FR-008 gap). (2) Per-app firewall block
    (`cmd connectivity` chain3) never surfaced a failure in ~2 min; real airplane mode does.
    (3) Reported total for Bonsai-27B 1-bit drifted 3.8 → 3.9 → 4.9 GB during one download.
- [X] T040 Inspect final diff for scope; confirm no file under `reference/` is referenced from `app/`; report
  that `connectedDebugAndroidTest` adds no tests because the spec forbids real downloads in tests
  (constitution IV)

---

## Dependencies & Execution Order

### Phase Dependencies

- **Setup (Phase 1)**: none
- **Foundational (Phase 2)**: after Setup — blocks all stories
- **US1 (Phase 3)**: after Foundational
- **US2, US3, US4 (Phases 4–6)**: after US1 (they extend `ModelDownloadRepositoryImpl`, the presenter, the card,
  and the service created in US1); independent of each other in behavior but share files, so run sequentially
- **Polish (Phase 7)**: after desired stories

### Within Each User Story

- Tests first (must fail), then repository → service → screen contract → presenter → UI

### Parallel Opportunities

- T002 alongside T001
- T003–T006 together; T010–T012 together after T005/T006/T007
- Test tasks marked [P] within a story (repository test and presenter test files differ)

---

## Parallel Example: User Story 1

```bash
Task: "Repository download tests in TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt"
Task: "Presenter tests in TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt"
```

---

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Phase 1 + Phase 2
2. Phase 3 (US1) → run unit tests → manual download on device
3. Stop and validate

### Incremental Delivery

US1 → US2 (failure/retry) → US3 (pause/resume) → US4 (delete), validating each with its tests.

---

## Notes

- `reference/` is a pattern source only and is untracked; T007 must complete before it is deleted.
- Commit only when explicitly asked.
