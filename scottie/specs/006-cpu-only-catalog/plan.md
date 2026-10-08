# Implementation Plan: CPU-Only Model Catalog

**Branch**: `006-cpu-only-catalog` | **Date**: 2026-10-08 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/006-cpu-only-catalog/spec.md`

## Summary

Text models run on `Backend.CPU()` (`core/ai/OnDeviceTextModels.kt`), but the catalog swaps in
per-chip NPU builds on five chips. This plan deletes that resolution path:

- Every LiteRT row becomes one fixed `LiteRtModel` that points at its general build.
- `LiteRtSpec`, `LiteRtBuild`, the `npu` maps, and `DeviceChip.kt` are deleted.
- The Edge TPU `<uses-native-library>` and the unused `model_allow_lists.json` asset are
  removed.
- The catalog becomes a constant list, and the DI provider stops passing a chip.

This is a deletion-only change. No new types are added.

## Technical Context

**Language/Version**: Kotlin (as configured in `app/build.gradle.kts`)

**Primary Dependencies**: Hilt, Koog LiteRT client, LiteRT-LM, and RunAnywhere for
speech-to-text. None of them change.

**Storage**: Model files in `filesDir/models/litert/<file name>`. File names don't change.

**Testing**: JUnit host tests (`:app:testDebugUnitTest`)

**Target Platform**: Android (app min/target SDK unchanged)

**Project Type**: Mobile app, single `:app` module

**Performance Goals**: N/A. Download sizes become the general builds' sizes.

**Constraints**: The app is unreleased, so no migration is needed (spec Clarifications).

**Scale/Scope**: About 4 source files changed, 3 files deleted, and 1 test file rewritten.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | Pass | Changes stay in `feature/modeldownload/data/ai/provider/` and `di/`. Domain is untouched. |
| II. Circuit-Driven Presentation | Pass | No presentation change. |
| III. Bounded AI Agents | Pass | No agent change. |
| IV. Verified Changes | Pass | `assembleDebug`, `testDebugUnitTest`, `detekt`, and `lintDebug` must run. The catalog's display behavior is unchanged, so no device test is needed. A manual device download check is in the quickstart. |
| V. Simplicity | Pass | Removes an abstraction (`LiteRtSpec.resolve`) and unused data. Nothing is added. |

Post-design re-check: Pass. No violations, so Complexity Tracking is empty.

## Project Structure

### Documentation (this feature)

```text
specs/006-cpu-only-catalog/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
└── tasks.md             # /speckit-tasks
```

There is no `contracts/` folder because the catalog is internal to the app and exposes no
external interface.

### Source Code (repository root)

```text
app/src/main/
├── AndroidManifest.xml                         # remove libedgetpu_litert.so declaration
├── assets/model_allow_lists.json               # delete (unreferenced)
└── java/com/jayvijay/scottie/
    ├── di/DataModule.kt                        # provide StaticModelCatalog.models
    └── feature/modeldownload/data/ai/provider/
        ├── DeviceChip.kt                       # delete
        └── ModelCatalog.kt                     # LiteRtSpec/LiteRtBuild → LiteRtModel rows
app/src/test/java/com/jayvijay/scottie/feature/modeldownload/data/ai/provider/
├── DeviceChipTest.kt                           # delete
└── ModelCatalogTest.kt                         # drop chip cases; keep catalog invariants
```

**Structure Decision**: Existing feature slice `feature/modeldownload/`. No new packages.

## Complexity Tracking

None.
