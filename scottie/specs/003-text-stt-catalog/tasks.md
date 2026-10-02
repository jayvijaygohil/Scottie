---

description: "Task list for 003 Text and Speech-to-Text Catalog"
---

# Tasks: Text and Speech-to-Text Catalog

**Input**: Design documents from `/specs/003-text-stt-catalog/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/model-runtime-contracts.md, quickstart.md, references/runanywhere-gating.md

**Tests**: Required. FR-010 calls for automated tests, and constitution IV requires presenter tests.
Every test runs on the JVM with fakes and needs no device or network.

**Organization**:
- **Phases 1–2** delete what this feature drops. They also add the RunAnywhere-matched
  compatibility rule and the start-time check, which both model types need. At the end of Phase 2
  the app compiles with a Sherpa-only catalog.
- **US1** adds LiteRT text models with chip-matched builds.
- **US2** confirms speech-to-text.
- **US3** locks the catalog to two flat sections.

## Format: `[ID] [P?] [Story] Description`

- `[P]` means the task can run in parallel: it touches different files and does not depend on
  incomplete tasks.
- `APP` is `app/src/main/java/com/jayvijay/scottie` and `TEST` is
  `app/src/test/java/com/jayvijay/scottie`. All paths are relative to the repository root.

---

## Phase 1: Setup (Dependency removal)

**Purpose**: Drop the llama.cpp and QHexRT runtimes (research R8).

- [X] T001 Remove the following:
  - In `gradle/libs.versions.toml`, the `runanywhere-llamacpp` and `runanywhere-qhexrt-android` aliases and the `runanywhereQherxrt` version.
  - In `app/build.gradle.kts`, `implementation(libs.runanywhere.llamacpp)` and `implementation(libs.runanywhere.qhexrt.android)`.
- [X] T002 In `APP/data/ai/provider/RunAnywhereModelRuntime.kt`:
  - Remove the `LlamaCPP`/`QHexRT` imports and their `registerBackend` calls, the `SingleFileModel` branch of `register`, `toQHexRTRequest()`, `HNPU_DESCRIPTION`, and `totalMemoryBytes()`. Also remove the imports that become unused, such as `ActivityManager`.
  - Keep `ONNX.register()`, `RunAnywhere.initialize`, and the `ArchiveModel`/`MultiFileModel` branches.

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**:
- Shrink the domain and catalog to TEXT and SPEECH_RECOGNITION.
- Flatten the presentation layer.
- Add the compatibility rule (FR-013), the probes, and the start-time check (FR-014).

These cover both model types, so every story depends on this phase.

### Tests (write first)

- [X] T003 [P] Create `TEST/domain/entities/ModelCompatibilityTest.kt` covering every row of the `checkCompatibility` table in `scottie/specs/003-text-stt-catalog/contracts/model-runtime-contracts.md`:
  - Unknown values (`null` or `≤ 0`) pass on either side.
  - "available ≥ required" passes when the two are equal.
  - A memory shortfall is returned before a storage shortfall.
  - The `Shortfall` carries the required and available bytes.
- [X] T004 [P] Create `TEST/data/ai/provider/FakeDeviceResources.kt` with mutable `var availableMemory: Long?` and `var availableStorage: Long?`. In `TEST/data/ai/provider/FakeModelRuntime.kt`, remove `totalMemoryBytes`.
- [X] T005 [P] Update `TEST/data/repository/ModelDownloadRepositoryImplTest.kt`:
  - Inject `FakeDeviceResources`, and replace the `SingleFileModel` and NPU fixtures with `MultiFileModel` rows.
  - Rows missing from `accepted` are not listed.
  - `supported` follows `checkCompatibility`.
  - `download` returns `Refused(Shortfall(MEMORY, …))` when the fake memory drops below the row's `memoryBytes` after load. It returns `Refused(Shortfall(STORAGE, …))` when free storage is below `downloadBytes`. In both cases the status is unchanged and `runtime.download` is never called (SC-006).
  - `download` returns `Ignored` while another download is active.
  - The existing 001/002 scenarios still pass (SC-005). Because `download` is now `suspend`, wrap calls in `runTest`.
- [X] T006 [P] Update `TEST/presentation/features/modeldownload/FakeModelDownloadRepository.kt` so that `suspend fun download(id): DownloadStart` returns a configurable result.
- [X] T007 [P] Update `TEST/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`:
  - Remove the `HardwareTarget`, `ModelGroup`, and `ToggleGroup` usages.
  - A `Refused(Shortfall(STORAGE, 2_600_000_000, 1_400_000_000))` result sets `state.error == ModelDownloadError.Shortfall(STORAGE, 2_600_000_000, 1_400_000_000)`.
  - `DismissError` clears it.
  - A delete failure sets `ModelDownloadError.DeleteFailed(name)`.

### Implementation

- [X] T008 In `APP/domain/entities/ModelDownload.kt`:
  - Reduce `ModelType` to `TEXT, SPEECH_RECOGNITION`.
  - Delete `HardwareTarget` and `Model.target`.
  - Add `val requiresToken: Boolean = false` to `Model`, with the KDoc "True when the source needs a Hugging Face account token; such models cannot be downloaded."
  - Change the `ModelEntry` KDoc to "`supported` is the catalog-load compatibility verdict (memory and storage)."
- [X] T009 [P] Create `APP/domain/entities/ModelCompatibility.kt` with:
  - `enum class ShortfallKind { MEMORY, STORAGE }`.
  - `sealed interface Compatibility`, with `data object Compatible` and `data class Shortfall(val kind: ShortfallKind, val requiredBytes: Long, val availableBytes: Long)`.
  - `fun checkCompatibility(memoryNeed: Long?, downloadBytes: Long?, availableMemory: Long?, availableStorage: Long?): Compatibility`, implementing the `model_compatibility.cpp` rule: "a check passes when the requirement is unknown (null or ≤ 0), the available value is unknown (null or ≤ 0), or available ≥ required", with no headroom. Check memory first.
  - The file must not import any Android class.
- [X] T010 In `APP/domain/repository/ModelDownloadRepository.kt`:
  - Add `sealed interface DownloadStart`, with `data object Started`, `data object Ignored`, and `data class Refused(val shortfall: Shortfall)`.
  - Change `download` to `suspend fun download(modelId: String): DownloadStart`.
  - The KDoc says `download` is ignored while another download is active, for unknown ids, for `requiresToken`, or for statuses that cannot start, and that it is refused, with the status unchanged, when the start-time compatibility check fails.
- [X] T011 [P] Create `APP/data/ai/provider/DeviceResources.kt`:
  - `interface DeviceResources { suspend fun availableMemoryBytes(): Long?; suspend fun availableStorageBytes(): Long? }`.
  - `@Singleton class AndroidDeviceResources @Inject constructor(@ApplicationContext context)`, with both methods on `Dispatchers.IO`:
    - **Memory** copies `PhysicalMemoryProbe.availablePhysicalMemoryBytes`: `ActivityManager.MemoryInfo.availMem` if it is above 0, else the `/proc/meminfo` `MemAvailable:` kB × 1024 if above 0, else null.
    - **Storage**: `StatFs(context.filesDir.path).availableBytes`, or null on exception.
- [X] T012 In `APP/data/ai/provider/ModelRuntime.kt`, remove `totalMemoryBytes()`.
- [X] T013 In `APP/data/ai/provider/ModelCatalog.kt`:
  - `CatalogModel` gets the common fields `id`, `name`, `memoryBytes`, `downloadBytes`, and `type: ModelType`.
  - `framework` and `category` move onto `ArchiveModel` and `MultiFileModel`, each with `type = SPEECH_RECOGNITION` for STT rows.
  - Delete `SingleFileModel`, `ModelCategory.toModelType()`, `npuCatalog`, `llm`, `vlm`, `misc`, every TTS row, and the unused constants. Keep only the `// --- STT (Sherpa-ONNX)` rows.
  - Replace `val all` with `fun forDevice(soc: String?): List<CatalogModel>`, which for now returns only the STT rows.
  - `toModel()` stops setting `target`.
- [X] T014 [P] In `APP/data/ai/provider/ModelPresentation.kt`:
  - Prune `FAMILY_DESCRIPTIONS` to gemma, qwen, deepseek_r1, nemotron_asr, canary, parakeet, whisper, and moonshine.
  - Add `"functiongemma"` → "Small Gemma tuned for on-device function calling." and `"minicpm"` → "OpenBMB compact chat model."
  - Remove `"HNPU"` and `"fully-on-NPU"` from `RUNTIME_TAGS`.
- [X] T015 Update `APP/data/repository/ModelDownloadRepositoryImpl.kt`:
  - **Constructor**: inject `DeviceResources`.
  - **`load()`**: probe `availableMemoryBytes()` and `availableStorageBytes()` once. List only the rows whose id is in `accepted`, with `supported = checkCompatibility(model.memoryBytes, model.downloadBytes, mem, storage) is Compatible`. Delete `fitsIn`.
  - **`download()`** becomes `suspend` and returns `DownloadStart`:
    1. Under the existing `state.update`, decide startability (busy, unknown id, `requiresToken`, or a status not in Available/Paused/Failed); if it cannot start, return `Ignored`.
    2. Re-probe, then run `checkCompatibility`. On a `Shortfall`, return `Refused(it)` without touching state.
    3. Otherwise set `Downloading`, start the foreground host and the collector as today, and return `Started`.
    Remove the `entry.supported` gate in favor of the re-probe, since the start-time check decides.
- [X] T016 In `APP/di/DataModule.kt`:
  - `provideModelCatalog()` returns `StaticModelCatalog.forDevice(soc = null)`. T027 replaces `null` with `socModel()`.
  - Add `@Binds fun deviceResources(impl: AndroidDeviceResources): DeviceResources`.
- [X] T017 In `APP/presentation/features/modeldownload/ModelDownloadScreen.kt`:
  - Delete `ModelGroup`, `ModelDownloadAction.ToggleGroup`, and `ModelDownloadModel.target`.
  - `ModelSection` becomes `(type, count, expanded, models: List<ModelDownloadModel>)`.
  - Add `sealed interface ModelDownloadError`, with `data class DeleteFailed(val modelName: String)` and `data class Shortfall(val kind: ShortfallKind, val requiredBytes: Long, val availableBytes: Long)`.
  - Replace `deleteFailedModelName` with `val error: ModelDownloadError?`.
  - Set the `canStart` KDoc to "False when unsupported, token-required, or while another model downloads."
- [X] T018 In `APP/presentation/features/modeldownload/ModelDownloadPresenter.kt`:
  - Delete `SectionKey`, `SectionDefaults`, and `isNpu`. `expansion` becomes a `Map<ModelType, Boolean>`, with every section expanded by default.
  - `catalogSections` groups in `ModelType.entries` order and hides empty sections.
  - `toModels()` sets `canStart = supported && !model.requiresToken && !busy`, and drops `target` from `matches`.
  - `Download` launches `repository.download(id)` in `scope`. A `Refused(s)` result sets `error = ModelDownloadError.Shortfall(s.kind, s.requiredBytes, s.availableBytes)`.
  - A delete failure sets `error = DeleteFailed(name)`, and `DismissError` clears `error`.
- [X] T019 [P] In `APP/presentation/features/modeldownload/component/ModelSections.kt`:
  - Render one `ScottieAccordionHeader` per section, followed by its models, with no group headers.
  - Delete `HardwareTarget.label()`.
  - `ModelType.label()` maps TEXT → `R.string.model_type_text` and SPEECH_RECOGNITION → `R.string.model_type_speech`.
- [X] T020 In `APP/presentation/features/modeldownload/ModelDownloadUi.kt`:
  - The toast renders `state.error`. `DeleteFailed` uses `model_download_delete_failed`.
  - `Shortfall` uses `model_download_shortfall_memory` or `model_download_shortfall_storage`, with both amounts formatted by `Formatter.formatShortFileSize(LocalContext.current, bytes)`.
  - Rewrite the preview state with flat Text and Speech sections, one token row (`canStart = false`), and a storage-shortfall preview.
- [X] T021 [P] In `app/src/main/res/values/strings.xml`:
  - Remove `model_type_multimodal`, `model_type_vision`, `model_type_image_generation`, `model_type_embedding`, `model_type_speech_recognition`, `model_type_speech_synthesis`, `model_type_voice_activity`, `model_type_segmentation`, `model_type_other`, `model_target_cpu`, and `model_target_npu`.
  - Add `model_type_speech` = "Speech".
  - Add `model_download_shortfall_memory` = "Needs at least %1$s of available memory; %2$s is available. Close other apps or choose a smaller model."
  - Add `model_download_shortfall_storage` = "Needs %1$s of free storage; %2$s is available. Free up storage or choose a smaller model."

**Checkpoint**: `./gradlew :app:assembleDebug :app:testDebugUnitTest` passes. The screen shows a
Speech section. A download with too little storage shows the storage toast and does not start.

---

## Phase 3: User Story 1 — Right text-generation model for this device (Priority: P1) 🎯 MVP

**Goal**: LiteRT text models get one row each.
- Each row resolves to the NPU build only on SM8650, SM8750, SM8850, Tensor G5, or Tensor G6 (with
  the board fallbacks `sun` and `pineapple`); every other device gets the general build.
- Token rows are listed but cannot be downloaded.
- Files go to `<filesDir>/models/litert/<fileName>`.

**Independent Test**:
- `DeviceChipTest` and `ModelCatalogTest` pass with SoC inputs `"SM8750"`, `"TENSOR_G5"`, `"SM8550"`,
  and `null`, and with the board inputs `"sun"` and `"kalama"`.
- `LiteRtModelRuntimeTest` passes.
- On a device, quickstart step 4 passes.

### Tests for User Story 1 (write before T028–T031)

- [X] T022 [P] [US1] Create `TEST/data/ai/provider/DeviceChipTest.kt` for the pure helpers from T027:
  - `normalizeSoc`: `"Tensor G5"` → `"TENSOR_G5"`, `" sm8750 "` → `"SM8750"`, and `""`, `"unknown"`, `null` → null.
  - `boardSoc`: `"sun"` → `"SM8750"`, `"PINEAPPLE"` → `"SM8650"`, and `"kalama"` → null.
  - `chipOf(socModel = null, board = "sun") == "SM8750"`.
  - `chipOf(socModel = "SM8550", board = "kalama") == "SM8550"`.
- [X] T023 [P] [US1] Rewrite `TEST/data/ai/provider/ModelCatalogTest.kt`:
  - **Contents**: `forDevice(any)` contains only TEXT or SPEECH_RECOGNITION rows (SC-001), and ids are unique.
  - **File names**: each LiteRT id ends in `.litertlm` and equals its spec's `fileName` for every soc input.
  - **Gemma 4 E2B builds**:
    - `"SM8750"` → the `_qualcomm_sm8750` build;
    - `"TENSOR_G5"` → the `_Google_Tensor_G5` build;
    - `"TENSOR_G6"` → the `_Google_Tensor_G6` build;
    - `"SM8550"`, `"SM8650"`, `"TENSOR_G4"`, and `null` → the general `gemma-4-E2B-it.litertlm` build (SC-002, SC-007).
  - **Gemma 3 1B builds**: `"SM8650"` → `_q4_ekv1280_sm8650`, and `"SM8850"` → `_q4_ekv1280_sm8850`.
  - **Invariants**: every NPU key in the catalog is in `NPU_ELIGIBLE`; exactly Gemma 3 1B, Gemma 3 270M, and FunctionGemma have `requiresToken`; a spec with no general build and no eligible NPU build is dropped.
- [X] T024 [P] [US1] Create `TEST/data/ai/provider/LiteRtModelRuntimeTest.kt` using a JUnit `TemporaryFolder` and a fake `open: (URL) -> HttpURLConnection` that serves byte arrays and honors or ignores `Range`. Cover:
  - A fresh download emits `Progress` then `Completed`; the final file exists and no `.part` remains.
  - Resume sends `Range: bytes=<partLen>-` and accepts 206.
  - When the server returns 200 to a Range request, the download restarts from 0.
  - A size mismatch gives `Failed(CORRUPTED)`, and `.part` is deleted.
  - A write throwing `IOException("ENOSPC")` gives `Failed(STORAGE)`.
  - An HTTP 404 gives `Failed(NETWORK)`.
  - Cancelling the collector keeps `.part`.
  - `delete` removes both files.
  - `downloadedIds` lists only complete files.
- [X] T025 [P] [US1] Create `TEST/data/ai/provider/RoutingModelRuntimeTest.kt` with two `FakeModelRuntime` instances:
  - `prepare` partitions rows by `is LiteRtModel` and returns the union.
  - `downloadedIds` is the union.
  - `download` and `delete` reach the owning fake.
- [X] T026 [P] [US1] In `TEST/data/repository/ModelDownloadRepositoryImplTest.kt`, add a `LiteRtModel` row with `requiresToken = true`. `download` must return `Ignored` without probing and without calling the runtime. In `TEST/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, assert that such a row has `canStart == false` while `supported == true`.

### Implementation for User Story 1

- [X] T027 [P] [US1] Create `APP/data/ai/provider/DeviceChip.kt` with:
  - `val NPU_ELIGIBLE = setOf("SM8650", "SM8750", "SM8850", "TENSOR_G5", "TENSOR_G6")`.
  - `private val BOARD_PLATFORMS = mapOf("SUN" to "SM8750", "PINEAPPLE" to "SM8650")`.
  - `internal fun normalizeSoc(raw: String?): String?`, which trims, uppercases, and replaces spaces and hyphens with `_`, and returns null for blank or `UNKNOWN`.
  - `internal fun boardSoc(board: String?): String?`, which returns `BOARD_PLATFORMS[board?.trim()?.uppercase()]`.
  - `internal fun chipOf(socModel: String?, board: String?): String? = normalizeSoc(socModel) ?: boardSoc(board)`.
  - `fun socModel(): String?`, which returns `chipOf(if (SDK_INT >= S) Build.SOC_MODEL else null, Build.BOARD)`.
  - A ponytail comment noting that `Build.BOARD` stands in for `ro.board.platform`, which is a hidden API; switch to it if a vendor board name breaks the mapping.
  - Then, in `APP/di/DataModule.kt`, change `provideModelCatalog()` to `StaticModelCatalog.forDevice(socModel())`.
- [X] T028 [US1] In `APP/data/ai/provider/ModelCatalog.kt`:
  - Add `data class LiteRtModel(override val id: String, override val name: String, val url: String, override val downloadBytes: Long, override val memoryBytes: Long, val requiresToken: Boolean) : CatalogModel`, with `type = TEXT` and the KDoc "`id` is the local file name and the Koog `LLModel.id`."
  - Add `data class LiteRtBuild(val url: String, val sizeBytes: Long, val memoryBytes: Long)`.
  - Add `data class LiteRtSpec(val name: String, val fileName: String, val requiresToken: Boolean = false, val general: LiteRtBuild?, val npu: Map<String, LiteRtBuild> = emptyMap())`. Its `fun resolve(soc: String?): LiteRtModel?` picks `(soc?.takeIf { it in NPU_ELIGIBLE }?.let(npu::get) ?: general)` and maps it to a `LiteRtModel`.
  - `toModel()` copies `requiresToken` for `LiteRtModel` and uses false otherwise.
- [X] T029 [US1] In `StaticModelCatalog` (`APP/data/ai/provider/ModelCatalog.kt`), add `private val litert: List<LiteRtSpec>` with the ten rows of research R1:
  - **NPU keys** come only from `NPU_ELIGIBLE`; omit the SM8550 and MediaTek builds.
  - **URLs** take the form `https://huggingface.co/litert-community/<repo>/resolve/<commit>/<file>`, with `<commit>` and each file's `lfs.size` taken from `https://huggingface.co/api/models/litert-community/<repo>`.
  - **Memory**: `memoryBytes = (sizeBytes * 13) / 10`, with the comment `// ponytail: heuristic until LiteRT publishes RAM needs`.
  - **Token rows**: Gemma 3 1B, Gemma 3 270M, and FunctionGemma set `requiresToken = true`.
  - **FunctionGemma** uses `fileName = "mobile_actions_q8_ekv1024.litertlm"`.
  - **`forDevice(soc)`** returns `litert.mapNotNull { it.resolve(soc) } + stt`.
- [X] T030 [US1] Create `APP/data/ai/provider/LiteRtModelRuntime.kt`, a `@Singleton class LiteRtModelRuntime` implementing `ModelRuntime` per the contracts:
  - **Constructor**: `@Inject constructor(@ApplicationContext context: Context)`, delegating to an `internal constructor(dir: File, open: (URL) -> HttpURLConnection = { it.openConnection() as HttpURLConnection })`. `dir` is `File(context.filesDir, "models/litert")`.
  - **`prepare`**: creates `dir`, records each `LiteRtModel`'s url and size, and returns their ids.
  - **`downloadedIds`**: the ids whose final file exists.
  - **`download`**:
    1. Send a GET, with `Range: bytes=<partLen>-` when `partLen > 0`. On 200, truncate `.part`. On anything other than 200 or 206, emit `Failed(NETWORK)`.
    2. Copy in 256 KiB chunks, emitting `Progress(bytesDone, sizeBytes, bytesDone / sizeBytes)`.
    3. If the final length differs from `sizeBytes`, delete `.part` and emit `Failed(CORRUPTED)`. Otherwise rename `.part` to the final file and emit `Completed`.
    4. An `IOException` whose message contains `ENOSPC` emits `STORAGE`; any other `IOException` emits `NETWORK`.
    5. Cancellation closes the stream and keeps `.part`.
    6. Run the flow with `flowOn(Dispatchers.IO)`.
  - **`delete`**: removes both files.
- [X] T031 [US1] Create `APP/data/ai/provider/RoutingModelRuntime.kt`, `class RoutingModelRuntime(private val liteRt: ModelRuntime, private val runAnywhere: ModelRuntime) : ModelRuntime`:
  - `prepare` partitions by `is LiteRtModel` and records the LiteRT ids.
  - `downloadedIds` is the union of both runtimes.
  - `download` and `delete` route by the recorded LiteRT ids.
  - In `APP/di/DataModule.kt`, provide `ModelRuntime` with `@Provides @Singleton fun modelRuntime(liteRt: LiteRtModelRuntime, runAnywhere: RunAnywhereModelRuntime): ModelRuntime = RoutingModelRuntime(liteRt, runAnywhere)`, and remove the `@Binds modelRuntime`.

**Checkpoint**:
- The Text section lists the LiteRT rows.
- The token rows show Download disabled.
- Other rows download into `files/models/litert/`.
- A download with too little memory or storage shows the toast and does not start.

---

## Phase 4: User Story 2 — Speech-to-text on every supported Android version (Priority: P1)

**Goal**: Sherpa STT rows download, cancel, and delete on API 26+, subject to the same compatibility
check.

**Independent Test**:
- The repository tests with STT `MultiFileModel` rows pass.
- Quickstart step 3 passes for a Speech row on an API 26 emulator and on a current device.

- [X] T032 [P] [US2] In `TEST/data/repository/ModelDownloadRepositoryImplTest.kt`, add STT (`MultiFileModel`, `type = SPEECH_RECOGNITION`) scenarios:
  - download → `Downloaded`;
  - pause → `Paused(bytes)`;
  - delete → `Available`;
  - with `downloadBytes = null`, the storage check passes even when free storage is 0, because the value is unknown.
- [X] T033 [US2] Check that every remaining row in `APP/data/ai/provider/ModelCatalog.kt` uses `INFERENCE_FRAMEWORK_SHERPA` or `INFERENCE_FRAMEWORK_ONNX`, and that `minSdk = 26` still builds with runanywhere-onnx 0.20.27 (its AAR declares minSdk 24). Note the result in the PR description.

**Checkpoint**: The Speech section works on its own.

---

## Phase 5: User Story 3 — Catalog contains only what Scottie runs (Priority: P2)

**Goal**: Two flat sections, Text then Speech. Search and toggles still work, and no removed types
appear.

**Independent Test**:
- `ModelDownloadPresenterTest` passes.
- Searching "vision", "embedding", and "tts" each shows the empty-results message.

- [X] T034 [P] [US3] In `TEST/presentation/features/modeldownload/ModelDownloadPresenterTest.kt`, check that:
  - the sections equal `[TEXT, SPEECH_RECOGNITION]` when both have models, and an empty section is hidden;
  - `ToggleCategory(TEXT)` collapses only Text;
  - search filters across both sections, expands the matches, and restores the toggles when cleared;
  - "npu" no longer matches by hardware.
- [X] T035 [US3] In `TEST/data/ai/provider/ModelCatalogTest.kt`, assert that no row's name or id from `forDevice(any)` contains vision, vlm, embed, rerank, segformer, vad, tts, piper, kokoro, or diffusion.

---

## Phase 6: Polish & Cross-Cutting Concerns

- [X] T036 [P] Search `app/src` for the removed symbols `HardwareTarget`, `SingleFileModel`, `QHexRT`, `LlamaCPP`, `npuCatalog`, `model_target_`, `totalMemoryBytes`, and `deleteFailedModelName`, and fix any leftovers.
- [X] T037 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug` and fix the findings, including `LargeClass`, `MagicNumber`, and `TooGenericExceptionCaught` in the new files.
- [ ] T038 Run the manual steps in `scottie/specs/003-text-stt-catalog/quickstart.md`. If an API 26 device, an NPU device, or a current device is missing, report each skipped step and why (constitution IV).
- [X] T039 Review the final `git diff` for scope: no `reference/` edits and no generated sources.

---

## Dependencies & Execution Order

- **Setup (T001–T002)** → **Foundational (T003–T021)** → the stories.
- **Inside Foundational**:
  1. The tests T003–T007 come first.
  2. Then T008 → T009, T010 → T011, T012, T013, T014 → T015 → T016.
  3. Then T017 → T018 → T019, T020, T021.
- **US1 (T022–T031)**: tests T022–T026 first, then T027 → T028 → T029 → T030 → T031.
- **US2 (T032–T033)** depends only on Foundational and can run alongside US1.
- **US3 (T034–T035)** depends on Foundational; T035 is only meaningful after T029.
- **Polish** comes last.

## Parallel Examples

- **Foundational tests**: T003, T004, T005, T006, and T007 together.
- **Foundational implementation**: T009, T011, and T014 together after T008; T019 and T021 together after T018.
- **US1 tests**: T022, T023, T024, T025, and T026 together.
- **Across stories**: T032 (US2) and T034 (US3) alongside the US1 implementation.

## Implementation Strategy

1. **MVP**: Setup, Foundational, and US1. This delivers the text catalog with chip-matched builds
   and RunAnywhere-equivalent gating.
2. **Add US2**: confirm STT, which is mostly verification.
3. **Add US3**: add the guard tests for the two-section catalog.
4. **Polish**: run the full checks, then validate on devices.
