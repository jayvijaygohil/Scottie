---

description: "Tasks for On-Device Model Downloads"
---

# Tasks: On-Device Model Downloads

**Input**: Design documents from `specs/001-runanywhere-model-download/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/model-download-contracts.md,
quickstart.md

**Tests**: Included. Constitution IV requires presenter tests, and quickstart.md lists the
scenarios. All tests use `FakeModelRepository`.

**HARD RULE (FR-014)**: No task may download a real model, contact the live RunAnywhere catalog,
or install/launch the app on a device or emulator. Do not run `:app:connectedDebugAndroidTest`.
That skip is allowed by constitution IV v1.1.0 and MUST be stated in the completion report.

**Paths**: All paths are relative to the Git repository root (`Scottie/`). `<pkg>` means
`app/src/main/java/com/jayvijay/scottie` and `<test>` means
`app/src/test/java/com/jayvijay/scottie`.

**SDK facts** (verified in research.md):

- Imports are `com.runanywhere.sdk.public.RunAnywhere` plus `com.runanywhere.sdk.public.api.*`.
- `RunAnywhere.models.download(id)` returns `Flow<DownloadEvent>` (not suspend). Its events are
  `Started`, `Progress(bytesDone, bytesTotal, fraction, totalFiles…)`, `Verifying`,
  `Extracting`, `Completed(model)`, `Failed(error: SDKException)`.
- Cancelling the collection keeps partial bytes, and calling `download` again resumes from them.
- `ModelInfo` fields: `id`, `name`, `metadata?.description`, `download_size_bytes`,
  `local_path`.
- `SDKException.code` is `ProtoErrorCode`.

## Format: `[ID] [P?] [Story] Description`

## Phase 1: Setup

- [ ] T001 Add to `gradle/libs.versions.toml`: under `[versions]` add `runanywhere = "0.20.27"`, and under `[libraries]` add `runanywhere-sdk = { group = "io.github.sanchitmonga22", name = "runanywhere-sdk", version.ref = "runanywhere" }` and `runanywhere-llamacpp = { group = "io.github.sanchitmonga22", name = "runanywhere-llamacpp", version.ref = "runanywhere" }`
- [ ] T002 In `app/build.gradle.kts`, add `implementation(libs.runanywhere.sdk)` and `implementation(libs.runanywhere.llamacpp)`, and change `compileOptions` source/target compatibility from `JavaVersion.VERSION_11` to `JavaVersion.VERSION_17`
- [ ] T003 Run `./gradlew :app:assembleDebug`. If the merge fails on a duplicate native `.so` against `app/src/main/jniLibs`, add `packaging.jniLibs.pickFirsts += "**/<that-file>.so"` for that file only in `app/build.gradle.kts`, then rebuild until it succeeds

---

## Phase 2: Foundational (blocks all stories)

- [ ] T004 Call `RunAnywhere.initialize(context = this)` in an `onCreate()` override in `<pkg>/ScottieApplication.kt`, after `super.onCreate()`
- [ ] T005 [P] Create `<pkg>/domain/entities/EdgeModel.kt` with these declarations: `data class EdgeModel(val id: String, val name: String, val description: String, val sizeBytes: Long?, val isDownloaded: Boolean)`; `data class DownloadProgress(val fraction: Float?, val bytesDone: Long?, val bytesTotal: Long?)`, where fraction is 0..1 and null means unknown; `enum class DownloadFailure { NO_CONNECTION, INSUFFICIENT_STORAGE, ACCESS_REQUIRED, UNKNOWN }`; and `sealed interface ModelDownloadStatus` with `Downloading(progress)`, `Paused(progress)`, `data object Downloaded`, and `Failed(reason: DownloadFailure)`. Add `class ModelRepositoryException(cause: Throwable) : Exception(cause)`. Use no SDK imports
- [ ] T006 [P] Create `<pkg>/domain/repository/ModelRepository.kt` with the interface from `contracts/model-download-contracts.md`: `suspend fun models(): List<EdgeModel>`, `val downloads: StateFlow<Map<String, ModelDownloadStatus>>`, `fun download(id: String)`, `suspend fun pause(id: String)`, `suspend fun delete(id: String)`. Declarations only, with KDoc copied from the contract
- [ ] T007 Create `<pkg>/data/repository/RunAnywhereModelRepository.kt`: `@Singleton class RunAnywhereModelRepository @Inject constructor(@ApplicationScope private val scope: CoroutineScope) : ModelRepository`. Give it a private `MutableStateFlow<Map<String, ModelDownloadStatus>>(emptyMap())` exposed as `downloads` and changed only through `update {}`, a private `ConcurrentHashMap<String, Job>` of active jobs, and `TODO()` bodies for the other members
- [ ] T008 In `<pkg>/di/DataModule.kt`, add an `@ApplicationScope` qualifier annotation (declared in the same file) and `@Provides @Singleton @ApplicationScope fun provideApplicationScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)`. Add a separate `@Module @InstallIn(SingletonComponent::class) interface RepositoryModule` with `@Binds abstract fun bindModelRepository(impl: RunAnywhereModelRepository): ModelRepository`
- [ ] T009 [P] Create `<test>/presentation/features/modeldownload/FakeModelRepository.kt`: a `ModelRepository` with a public `var models: List<EdgeModel>`, a `var listError: Throwable?` (thrown by `models()` when set), a public `MutableStateFlow` behind `downloads`, a `var deleteError: Throwable?`, and recorded calls (`downloadCalls`, `pauseCalls`, `deleteCalls`: `MutableList<String>`). `delete` records the call, throws `deleteError` when set, and otherwise removes the status entry and sets the matching model's `isDownloaded = false`
- [ ] T010 Rewrite the contract types in `<pkg>/presentation/features/modeldownload/ModelDownloadScreen.kt` to match `contracts/model-download-contracts.md`:
  - `sealed interface ModelDownloadState : CircuitUiState { val eventSink }` with `Loading`, `Error`, and `Loaded(models)` data classes.
  - `data class ModelDownloadModel(id, name, description, sizeBytes: Long?, status: ModelDownloadItemStatus)`.
  - `sealed interface ModelDownloadItemStatus` with `Available`, `Downloaded` (data objects), `Downloading(progress: DownloadProgress)`, `Paused(progress: DownloadProgress)`, and `Failed(reason: DownloadFailure)`.
  - Add `data object RetryList` to `ModelDownloadAction` and keep the existing actions.
- [ ] T011 Create `<pkg>/presentation/features/modeldownload/ModelDownloadPresenter.kt` with this skeleton:
  - `class ModelDownloadPresenter @AssistedInject constructor(@Assisted private val navigator: Navigator, private val repository: ModelRepository) : Presenter<ModelDownloadState>`.
  - An `@CircuitInject(ModelDownloadScreen::class, SingletonComponent::class) @AssistedFactory fun interface Factory { fun create(navigator: Navigator): ModelDownloadPresenter }`.
  - `present()` returns `Loading` and handles `Back` with `navigator.pop()`.
- [ ] T012 In `<pkg>/presentation/MainActivity.kt`, delete `StaticScreen` and set `rememberSaveableBackStack(root = ModelDownloadScreen)`
- [ ] T013 Update `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt` so it compiles against the new sealed state: `Loading` shows a centered `CircularProgressIndicator`, and `Loaded` maps each model to `ModelDownloadUiItem`. For now, map only `Available` and `Downloaded` statuses and render the rest as `AVAILABLE`, to be replaced in later stories. Add the strings `model_download_available` ("%1$s download"), `model_download_size_unknown` ("Size unknown"), and `model_download_downloaded` ("Downloaded · %1$s") to `app/src/main/res/values/strings.xml`, and format sizes with `android.text.format.Formatter.formatShortFileSize(LocalContext.current, bytes)`. Update the previews to the new state types
- [ ] T014 Run `./gradlew :app:assembleDebug` and confirm it succeeds

**Checkpoint**: The app builds with the SDK, and the download screen is the root screen.

---

## Phase 3: User Story 1 - Browse supported models (P1) 🎯 MVP

**Goal**: The list shows every supported model with name, description, size, and Available or
Downloaded status, plus Loading, Error, and Empty states.

**Independent Test**: Presenter tests with a fake repository show Loading, then Loaded with mixed
statuses, Error then Retry, and Empty.

- [ ] T015 [P] [US1] In `<test>/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, using `com.slack.circuit.test.test`, `FakeNavigator(ModelDownloadScreen)`, and `FakeModelRepository`, test these cases:
  - The first state is `Loading`, followed by `Loaded` whose models map `isDownloaded` to `Downloaded`/`Available`, with order preserved.
  - `listError = ModelRepositoryException(RuntimeException())` gives `Error`; after clearing it, `RetryList` gives `Loaded`.
  - An empty list gives `Loaded(emptyList())`.
  - `Back` pops the navigator.
- [ ] T016 [US1] Implement `models()` in `<pkg>/data/repository/RunAnywhereModelRepository.kt`:
  1. `runCatching { RunAnywhere.models.refresh(includeRemoteCatalog = true) }`, ignoring failure but rethrowing `CancellationException`.
  2. `RunAnywhere.models.list(ModelFilter(framework = InferenceFramework.INFERENCE_FRAMEWORK_LLAMA_CPP))`.
  3. Map each result to `EdgeModel(id, name, metadata?.description.orEmpty(), download_size_bytes.takeIf { it > 0 }, local_path.isNotEmpty())`.
  4. Wrap `SDKException` from `list` in `ModelRepositoryException`.
  5. Run on `Dispatchers.IO`.
- [ ] T017 [US1] In `<pkg>/presentation/features/modeldownload/ModelDownloadPresenter.kt`, implement listing:
  - Hold `var models by remember { mutableStateOf<List<EdgeModel>?>(null) }`, a `loadError` flag, and a `reloadKey`.
  - `LaunchedEffect(reloadKey)` calls `repository.models()`, catching `ModelRepositoryException` to set `loadError`.
  - Collect `repository.downloads.collectAsState()`.
  - Emit `Loading`, `Error`, or `Loaded`, mapping each model to `ModelDownloadModel`. Status comes from the downloads entry if present (`Downloaded` maps to `ModelDownloadItemStatus.Downloaded`) and otherwise from `isDownloaded`.
  - `RetryList` increments `reloadKey`.
- [ ] T018 [US1] In `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt`, render `Error` with the message `model_download_list_error` ("Couldn't load models.") and a Retry button that dispatches `RetryList`, and render `Loaded` with an empty list as the message `model_download_empty` ("No models are available for this device yet."). Add both strings plus `model_download_retry` ("Retry") and `model_download_description_fallback` ("On-device language model"), the latter used when `description` is blank, to `app/src/main/res/values/strings.xml`. Add `Error` and `Empty` previews
- [ ] T019 [US1] Run `./gradlew :app:testDebugUnitTest` and confirm the US1 tests pass

**Checkpoint**: The supported models list is complete and tested.

---

## Phase 4: User Story 2 - Download with live progress (P1)

**Goal**: Download shows a live percentage and bytes, then ends as Downloaded, and keeps running
across navigation.

**Independent Test**: The fake emits `Downloading(0.5)`, then the model becomes downloaded; the
presenter state follows.

- [ ] T020 [P] [US2] In `<test>/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, add tests:
  - The `Download(id)` action records `downloadCalls == [id]`.
  - Setting the fake's downloads to `Downloading(DownloadProgress(0.5f, 500, 1000))` gives a `Downloading` item.
  - Setting the entry to `ModelDownloadStatus.Downloaded` gives a `Downloaded` item immediately, with no re-listing and no intermediate `Available`.
- [ ] T021 [US2] Implement `download(id)` in `<pkg>/data/repository/RunAnywhereModelRepository.kt`. If `jobs[id]?.isActive` is true, return. Otherwise launch in `scope` and collect `RunAnywhere.models.download(id)`:
  - `Started`: `Downloading(previous progress or DownloadProgress(null, null, null))`.
  - `Progress`: `Downloading(DownloadProgress(e.fraction, e.bytesDone.takeIf { e.totalFiles == 1 }, e.bytesTotal.takeIf { e.totalFiles == 1 && it > 0 }))`.
  - `Verifying`/`Extracting`: `Downloading(DownloadProgress(null, null, null))`.
  - `Completed`: set `ModelDownloadStatus.Downloaded` in one `update {}`.
  - `Failed`: `Failed(DownloadFailure.UNKNOWN)`, refined in US5.

  Write every status through `update {}`. Wrap the collection in `try/catch (e: SDKException)` that sets `Failed(UNKNOWN)`. Never catch `CancellationException`, and never write status from `finally`. In `finally`, call `jobs.remove(id, coroutineContext.job)` so a newer job for the same id is not removed.
- [ ] T022 [US2] In `<pkg>/presentation/features/modeldownload/ModelDownloadPresenter.kt`, dispatch `Download(id)` to `repository.download(id)`
- [ ] T023 [US2] In `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt`, map `Downloading` to `ModelDownloadItemState.DOWNLOADING` with `progress = fraction` and the status text:
  - When `bytesDone`/`bytesTotal` are present: `model_download_downloading_bytes` ("Downloading · %1$d%% · %2$s / %3$s").
  - When only the fraction is known: `model_download_downloading_percent` ("Downloading · %1$d%%").
  - When the fraction is null: `model_download_preparing` ("Preparing…").

  Add the strings to `app/src/main/res/values/strings.xml`.
- [ ] T024 [US2] Run `./gradlew :app:testDebugUnitTest` and confirm it passes

**Checkpoint**: Downloading works end to end against the fake.

---

## Phase 5: User Story 3 - Pause, resume, or abandon (P2)

**Goal**: Pause keeps progress, Resume continues from it, and Delete on an in-progress or paused
model returns it to Available.

**Independent Test**: In presenter tests, Pause records the call and a `Paused(0.5)` status
renders as Paused with 0.5; Resume calls `download`; Delete calls `delete`.

- [ ] T025 [P] [US3] In `<test>/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, add tests:
  - `Pause(id)` records `pauseCalls`, and a `Paused(DownloadProgress(0.5f, …))` status gives a `Paused` item with fraction 0.5.
  - `Resume(id)` records `downloadCalls`.
  - `Delete(id)` on a Downloading or Paused item records `deleteCalls`, and the item becomes `Available`.
- [ ] T026 [US3] Implement `suspend fun pause(id)` in `<pkg>/data/repository/RunAnywhereModelRepository.kt`. Call `jobs.remove(id)?.cancelAndJoin()`, then read the current progress and set `Paused(progress)` (or `Paused(DownloadProgress(null, null, null))`) with `update {}`. Because the job has fully stopped first, no late progress event can overwrite Paused
- [ ] T027 [US3] Implement `delete(id)` in `<pkg>/data/repository/RunAnywhereModelRepository.kt`: `jobs.remove(id)?.cancelAndJoin()`, then `withContext(Dispatchers.IO) { RunAnywhere.models.delete(id) }`, then remove the status entry with `update {}`. Wrap `SDKException` in `ModelRepositoryException`
- [ ] T028 [US3] In `<pkg>/presentation/features/modeldownload/ModelDownloadPresenter.kt`, dispatch `Pause` to a launched `repository.pause`, `Resume` to `repository.download`, and `Delete` to a launched `repository.delete`, both launched in a `rememberCoroutineScope`. On delete success, set that model's `isDownloaded = false` in the held list; on `ModelRepositoryException`, leave the state unchanged. Import no SDK types
- [ ] T029 [US3] In `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt`, map `Paused` to `PAUSED` with `progress = fraction` and the text `model_download_paused` ("Paused · %1$d%%"), or `model_download_paused_unknown` ("Paused") when the fraction is null. Add both strings to `app/src/main/res/values/strings.xml`
- [ ] T030 [US3] Run `./gradlew :app:testDebugUnitTest` and confirm it passes

---

## Phase 6: User Story 4 - Delete a downloaded model (P2)

**Goal**: Delete on a downloaded model frees it and shows Available.

**Independent Test**: In a presenter test, `Delete` on a `Downloaded` item records `deleteCalls`,
and the item becomes `Available`.

- [ ] T031 [P] [US4] In `<test>/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, add two tests. First, Delete on a Downloaded model records `deleteCalls`, and the item becomes `Available`. Second, with `deleteError = ModelRepositoryException(RuntimeException())`, Delete leaves the item `Downloaded` and does not crash. The T027/T028 implementation already covers this. If the test fails, fix it in `<pkg>/presentation/features/modeldownload/ModelDownloadPresenter.kt`
- [ ] T032 [US4] In `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt`, confirm `Downloaded` maps to `DOWNLOADED` with `model_download_downloaded`, or `model_download_downloaded_unknown` ("Downloaded") when `sizeBytes` is null. Add the string to `app/src/main/res/values/strings.xml`

---

## Phase 7: User Story 5 - Failures and retry (P3)

**Goal**: A failure shows a specific reason and a Retry action.

**Independent Test**: A pure mapping test plus a presenter test where a `Failed(NO_CONNECTION)`
status renders as Failed and Retry calls `download`.

- [ ] T033 [P] [US5] Create `<test>/data/repository/DownloadFailureMappingTest.kt`. It asserts that `toDownloadFailure(ProtoErrorCode)` maps:
  - `ERROR_CODE_NETWORK_UNAVAILABLE` and `ERROR_CODE_NETWORK_ERROR` → `NO_CONNECTION`
  - `ERROR_CODE_INSUFFICIENT_STORAGE` → `INSUFFICIENT_STORAGE`
  - `ERROR_CODE_UNAUTHORIZED`, `ERROR_CODE_FORBIDDEN`, and `ERROR_CODE_AUTHENTICATION_FAILED` → `ACCESS_REQUIRED`
  - `ERROR_CODE_MODEL_NOT_FOUND` → `UNKNOWN`
- [ ] T034 [P] [US5] In `<test>/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, add a test: a `Failed(DownloadFailure.NO_CONNECTION)` status gives a `Failed(NO_CONNECTION)` item, and `Download(id)` (Retry) records `downloadCalls`
- [ ] T035 [US5] In `<pkg>/data/repository/RunAnywhereModelRepository.kt`, add `internal fun ProtoErrorCode.toDownloadFailure(): DownloadFailure` with the T033 mapping, and use `error.code.toDownloadFailure()` for both `DownloadEvent.Failed` and the caught `SDKException`
- [ ] T036 [US5] In `<pkg>/presentation/features/modeldownload/component/ModelDownloadCard.kt`, add `FAILED` to `ModelDownloadItemState` and `retry` to `ModelDownloadItemLabels`, and render `FAILED` as a single filled `ModelDownloadButton(labels.retry, onDownload)`. Add a Failed preview
- [ ] T037 [US5] In `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt`, map `Failed` to `FAILED` with this text per reason: `model_download_failed_connection` ("Download failed · Connect to the internet and retry"), `model_download_failed_storage` ("Download failed · Not enough storage"), `model_download_failed_access` ("Download failed · This model requires access approval"), and `model_download_failed_unknown` ("Download failed · Try again"). Pass `retry = stringResource(R.string.model_download_retry)`. Add the strings to `app/src/main/res/values/strings.xml`
- [ ] T038 [US5] Run `./gradlew :app:testDebugUnitTest` and confirm it passes

---

## Phase 8: Polish

- [ ] T039 [P] Update the previews in `<pkg>/presentation/features/modeldownload/ModelDownloadUi.kt` to cover Loading, Error, Empty, and Loaded with one model in each status (Available, Downloading, Paused, Downloaded, Failed), in light, dark, and 2× font
- [ ] T040 Run `./gradlew :app:detekt :app:lintDebug` and fix any findings in the touched files
- [ ] T041 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest` for final confirmation, then inspect `git diff` for scope. Confirm no `connectedDebugAndroidTest` run, app launch, or real model download happened (FR-014). The completion report must state that device tests were skipped under constitution IV v1.1.0, and list the items in quickstart.md "Not validated here"

---

## Dependencies

- Setup (T001–T003) comes before Foundational (T004–T014), which comes before all stories.
- Story order: US1 (T015–T019) → US2 (T020–T024) → US3 (T025–T030) → US4 (T031–T032) → US5 (T033–T038) → Polish.
- The stories share the presenter, repository, and UI files, so their implementation tasks run sequentially. US4 reuses US3's delete path.

## Parallel opportunities

- T005, T006, and T009 touch separate new files.
- Each story's test task ([P]) can be written alongside the preceding story's implementation.
- T033 (pure mapping test) can be written at any point after T005.

## Implementation strategy

- **MVP**: Phases 1–3 (US1). Shows the real supported-model list with correct on-device status.
- Then US2 (the core download), US3/US4 (control), US5 (failures), and Polish. Each phase ends
  with a passing test run.
