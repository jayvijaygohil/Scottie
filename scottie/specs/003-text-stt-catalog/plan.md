# Implementation Plan: Text and Speech-to-Text Catalog

**Branch**: `003-text-stt-catalog` | **Date**: 2026-10-02 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/003-text-stt-catalog/spec.md`

## Summary

Cut the catalog to two model types and adopt RunAnywhere's gating
([references/runanywhere-gating.md](references/runanywhere-gating.md)).

- **Text models**: LiteRT `.litertlm` rows with per-chip builds. A pure function resolves each row
  to one build:
  - the chip's NPU build when the chip is SM8650, SM8750, SM8850, Tensor G5, or Tensor G6;
  - the general build otherwise.
  The chip comes from `Build.SOC_MODEL`, falling back to the board platform names `sun` and
  `pineapple`. The build is fetched over HTTP into `<filesDir>/models/litert/<fileName>`, where
  `fileName` is the Koog `LLModel.id`.
- **Token rows**: listed but never downloadable.
- **Speech-to-text**: keeps the Sherpa-ONNX rows on RunAnywhere. `RoutingModelRuntime` sends each
  row to the right runtime.
- **Compatibility**: a model is Supported when available RAM ≥ its memory need and free storage ≥
  its download size; unknown values pass. This is evaluated at catalog load. `download()` checks it
  again and returns a shortfall, which the presenter shows in the existing toast.
- **Removed**: llama.cpp, QHexRT, all other model types, `HardwareTarget`, and the CPU/NPU
  subsections. See [research.md](research.md).

## Technical Context

**Language/Version**: Kotlin 2.4.20, Java 17 target, AGP 9.4.1

**Primary Dependencies**:
- RunAnywhere SDK 0.20.27 with runanywhere-onnx, used for Sherpa STT only.
- Slack Circuit 0.39.0, Hilt 2.60.1 (KSP), and Compose Material 3.
- **Removed**: runanywhere-llamacpp and runanywhere-qhexrt-android.
- **Not added**: the Koog LiteRT client and any HTTP library.

**Storage**: LiteRT files live in `<filesDir>/models/litert/`, with partial files as `.part`.
Sherpa files stay in RunAnywhere's store.

**Testing**:
- JUnit 4, kotlinx-coroutines-test, Turbine, and circuit-test.
- Pure JVM tests for build resolution, the compatibility rule, routing, the repository preflight,
  and the presenter error mapping.
- The file runtime uses a temp dir and a fake connection.

**Target Platform**: Android, minSdk 26, target 37.

**Project Type**: Single-module Android app (`:app`).

**Performance Goals**: Progress cadence matches 001. Paused downloads resume with a Range request.
The preflight runs two quick probes (one `ActivityManager` call and one `StatFs`) on
`Dispatchers.IO`.

**Constraints**:
- Network is used only for catalog files.
- Token rows are never fetched.
- No inference and no load-time preflight.
- Unknown device values never block a download.

**Scale/Scope**: About 10 text rows (3 need a token) plus the existing Sherpa STT rows. One screen
is simplified, and about 1,000 catalog lines are deleted.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | Pass | The compatibility rule (`checkCompatibility`, `Shortfall`) is pure domain code. Probes, chip identity, build resolution, and the file download are in `feature/modeldownload/data/ai/provider`. No use case is needed because there is a single repository. |
| II. Circuit-Driven Presentation | Pass | The presenter launches `download` and maps a `Refused` result to state. The UI renders the toast from string resources. |
| III. Bounded AI Agents | N/A | No agent or inference work. |
| IV. Verified Changes | Pass | Unit tests cover the rule, resolution, routing, file runtime, repository preflight, and presenter. Device steps (API 26 and current) are in quickstart; any skip is reported. |
| V. Simplicity | Pass | Net deletion: 2 dependencies, about 1,000 catalog lines, QHexRT, hardware groups, and `totalMemoryBytes`. New code is a router, a file runtime, `DeviceResources` (a test seam over two Android probes, the same pattern as `ModelRuntime`), and a 10-line rule. The existing toast is reused. |

Post-design re-check: unchanged, Pass.

## Project Structure

### Documentation (this feature)

```text
specs/003-text-stt-catalog/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/model-runtime-contracts.md
├── references/{runanywhere-gating.md,specify-prompt.md}
├── checklists/requirements.md
└── tasks.md             # /speckit-tasks
```

### Source Code (repository root)

```text
gradle/libs.versions.toml                       # − llamacpp, qhexrt aliases, runanywhereQherxrt
app/build.gradle.kts                            # − llamacpp, qhexrt deps
app/src/main/java/com/jayvijay/scottie/
├── feature/modeldownload/domain/entities/
│   ├── ModelDownload.kt                        # ModelType {TEXT, SPEECH_RECOGNITION}; − HardwareTarget/target; + requiresToken
│   └── ModelCompatibility.kt                   # NEW: checkCompatibility, Compatibility, Shortfall, ShortfallKind
├── feature/modeldownload/domain/repository/ModelDownloadRepository.kt # download(): suspend → DownloadStart {Started, Ignored, Refused}
├── feature/modeldownload/data/ai/provider/
│   ├── ModelCatalog.kt                         # LiteRtModel/LiteRtSpec/LiteRtBuild; − SingleFileModel & non-text/STT rows; forDevice(soc)
│   ├── DeviceChip.kt                           # NEW: socModel(), normalizeSoc, BOARD_PLATFORMS, NPU_ELIGIBLE
│   ├── DeviceResources.kt                      # NEW: interface + AndroidDeviceResources (availMem/MemAvailable, StatFs)
│   ├── LiteRtModelRuntime.kt                   # NEW: Range download into filesDir/models/litert
│   ├── RoutingModelRuntime.kt                  # NEW
│   ├── ModelRuntime.kt                         # − totalMemoryBytes
│   ├── RunAnywhereModelRuntime.kt              # − LlamaCPP, QHexRT, SingleFileModel branch, totalMemoryBytes
│   └── ModelPresentation.kt                    # prune descriptions
├── feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt  # accepted-only rows; supported via rule; preflight in download()
├── di/DataModule.kt                            # forDevice(socModel()); bind router + DeviceResources
└── feature/modeldownload/presentation/
    ├── ModelDownloadScreen.kt                  # − ModelGroup/ToggleGroup/target; error: ModelDownloadError?
    ├── ModelDownloadPresenter.kt               # flat sections; canStart excludes requiresToken; launch download → error
    ├── ModelDownloadUi.kt                      # toast renders either error
    └── component/ModelSections.kt              # one header + rows per section
app/src/main/res/values/strings.xml             # − removed type/target labels; + model_type_speech, shortfall messages
app/src/test/java/com/jayvijay/scottie/
├── feature/modeldownload/domain/entities/ModelCompatibilityTest.kt
├── feature/modeldownload/data/ai/provider/{ModelCatalogTest,DeviceChipTest,LiteRtModelRuntimeTest,RoutingModelRuntimeTest,FakeModelRuntime,FakeDeviceResources}.kt
├── feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt
└── feature/modeldownload/presentation/{ModelDownloadPresenterTest,FakeModelDownloadRepository}.kt
```

**Structure Decision**:
- **Build resolution** runs once in DI, so no other layer needs to know about chips.
- **The compatibility rule** is domain policy, while the device probes are data-layer
  infrastructure behind an interface the tests can fake.
- **The repository** remains the single owner of download start and its invariants, so it also runs
  the start-time check.

## Complexity Tracking

No constitution violations.
