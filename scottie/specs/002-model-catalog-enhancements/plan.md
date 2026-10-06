# Implementation Plan: Model Catalog Enhancements

**Branch**: `002-model-catalog-enhancements` | **Date**: 2026-10-01 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/002-model-catalog-enhancements/spec.md`

## Summary

Turn the flat model download list into a searchable, nested catalog: one collapsible category per
`ModelType`, each split into CPU and NPU subsections, with readable titles, family descriptions, and
a Supported/Unsupported badge that gates downloads. The repository stops hiding rows the runtime
rejects and instead marks each entry `supported` (runtime accepted the row **and** its RAM need fits
device total RAM). Titles are sanitized and descriptions mapped in the data layer. The presenter
owns search query and section expansion and emits grouped sections; the UI renders one flattened
`LazyColumn` with two new shared components (`ScottieAccordionHeader`, `ScottieSearchField`) and the
existing `XelaBadge`. NPU models already download through the existing QHexRT path on supported
Snapdragon devices. See [research.md](research.md).

## Technical Context

**Language/Version**: Kotlin 2.4.20, Java 17 target, AGP 9.4.1

**Primary Dependencies**: RunAnywhere SDK 0.20.27 (+ llamacpp, onnx; qhexrt-android 0.20.19),
Slack Circuit 0.39.0, Hilt 2.60.1 (KSP), Jetpack Compose Material 3, vendored Xela UI kit. No new
dependencies.

**Storage**: None new. Support verdict, search query, and section state are in memory.

**Testing**: JUnit 4, kotlinx-coroutines-test, Turbine, circuit-test; existing `FakeModelRuntime`
and `FakeModelDownloadRepository` extended.

**Target Platform**: Android, minSdk 26, target/compile SDK 37.

**Project Type**: Single-module Android app (`:app`).

**Performance Goals**: Search results within 200 ms per keystroke over ~115 rows (SC-004);
download progress keeps 001 cadence while sections are collapsed or filtered.

**Constraints**: Support evaluated once per catalog load; download behavior from 001 unchanged; no
runtime dependency on `reference/`; tests need no device hardware or network.

**Scale/Scope**: ~115 catalog rows across 8 model types (CPU + NPU), one screen, two new shared
components, one extended toolbar.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | Pass | New domain fields/enum are plain Kotlin. RAM and NPU acceptance stay in `feature/modeldownload/data/ai/provider`; repository computes `supported`. No new use case (no multi-repository policy). |
| II. Circuit-Driven Presentation | Pass | Search/toggle are presenter actions; state carries sections; UI renders and dispatches only; strings in resources; theme only. |
| III. Bounded AI Agents | N/A | No agent work. |
| IV. Verified Changes | Pass | Catalog, repository, and presenter tests with fakes; assemble/test/detekt/lint. Instrumented tests not required by spec (Assumptions); skip will be reported. |
| V. Simplicity | Pass | One method added to the existing runtime seam; two shared components required by FR-015 and justified in R6/R7; `XelaBadge` reused; no new dependencies. |

Post-design re-check: unchanged — Pass.

## Project Structure

### Documentation (this feature)

```text
specs/002-model-catalog-enhancements/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/model-catalog-contracts.md
├── checklists/requirements.md
└── tasks.md             # /speckit-tasks
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
├── feature/modeldownload/domain/entities/ModelDownload.kt            # + HardwareTarget, Model fields, ModelEntry.supported
├── feature/modeldownload/data/ai/provider/
│   ├── ModelCatalog.kt                         # memoryBytes on CatalogModel; toModel() fills new fields
│   ├── ModelPresentation.kt                    # NEW: title sanitizer + overrides, family descriptions
│   ├── ModelRuntime.kt                         # + totalMemoryBytes()
│   └── RunAnywhereModelRuntime.kt              # ActivityManager total RAM
├── feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt  # keep all rows, compute supported, gate download
├── core/ui/components/
│   ├── ScottieToolbar.kt                       # + optional search slot
│   ├── ScottieSearchField.kt                   # NEW
│   └── ScottieAccordionHeader.kt               # NEW
└── feature/modeldownload/presentation/
    ├── ModelDownloadScreen.kt              # sections, new actions
    ├── ModelDownloadPresenter.kt           # query, expansion, grouping/filtering
    ├── ModelDownloadUi.kt                  # flattened LazyColumn, search, empty state
    └── component/ModelDownloadCard.kt      # description + support badge, gating
app/src/main/res/values/strings.xml             # new strings + plural
app/src/main/res/drawable/                      # ic_search, ic_close, ic_chevron_down (vector)
app/src/test/java/com/jayvijay/scottie/
├── feature/modeldownload/data/ai/provider/{ModelCatalogTest,FakeModelRuntime}.kt
├── feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt
└── feature/modeldownload/presentation/{ModelDownloadPresenterTest,FakeModelDownloadRepository}.kt
```

**Structure Decision**: Existing single-module layout. Title/description mapping is catalog data, so
it lives beside `ModelCatalog.kt` in `feature/modeldownload/data/ai/provider`. Grouping and search are presentation
concerns kept in the presenter file as pure functions. Shared components go to `ui/components/`
because FR-015 requires reusable design-system components.

## Complexity Tracking

No constitution violations.
