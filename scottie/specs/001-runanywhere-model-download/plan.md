# Implementation Plan: On-Device Model Downloads

**Branch**: `001-runanywhere-model-download` | **Date**: 2026-10-01 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `specs/001-runanywhere-model-download/spec.md`

## Summary

Connect the existing `ModelDownloadScreen` to the RunAnywhere Kotlin SDK. A singleton repository
in the data layer lists llama.cpp-runnable models from the SDK registry and owns app-lifetime
download jobs. Pause cancels the job (the SDK keeps partial bytes) and Resume restarts the job
from them. The repository exposes per-model status as a `StateFlow`. A new presenter combines the
model list with that flow. The UI formats status text from typed state and gains Failed, Loading,
Error, and Empty states. All verification is simulated; no model is downloaded (FR-014).

## Technical Context

**Language/Version**: Kotlin 2.4.20, Java 17 bytecode (raised from 11, research R2)

**Primary Dependencies**: RunAnywhere `runanywhere-sdk` + `runanywhere-llamacpp` 0.20.27; Circuit
0.39.0; Hilt 2.60.1; Compose Material 3

**Storage**: Model files are managed by the SDK. The app persists nothing itself.

**Testing**: JUnit 4, `circuit-test`, Turbine, `kotlinx-coroutines-test`, all with fake
repositories

**Target Platform**: Android, minSdk 26, target/compile SDK 37

**Project Type**: Single-module Android app (`:app`)

**Performance Goals**: List shown within 2 s (SC-001); progress updates at least 1/s (SC-002)

**Constraints**: Downloads survive navigation, not process death. No real downloads or live catalog
calls during verification.

**Scale/Scope**: One screen, a catalog of tens of models, concurrent downloads allowed

## Constitution Check

| Principle | Status |
|-----------|--------|
| I. Layered Clean Architecture | Pass. Entities, `ModelRepository`, and `ModelRepositoryException` live in `domain/` with no SDK imports. The SDK appears only in `data/repository/` and `ScottieApplication`, and SDK exceptions are wrapped before leaving `data/`. No use case is added, because the presenter calls one repository. |
| II. Circuit-Driven Presentation | Pass. A new class-based `ModelDownloadPresenter` with `@AssistedInject Navigator` and `@CircuitInject`. The UI renders state and dispatches actions, and all strings are resources. |
| III. Bounded AI Agents | N/A. No agent work. Downloads are model infrastructure, not inference, so they sit in `data/repository/`, not `data/ai/provider/`. |
| IV. Verified Changes | Pass. Presenter tests use fakes, and the build, unit, detekt, and lint checks run. Device tests are skipped under the v1.1.0 exception, because FR-014 forbids device execution. The completion report must state this. |
| V. Simplicity | Pass. Only two SDK modules are added. There is no use case and no extra SDK wrapper interface, because the repository is the only seam and the fake implements the domain interface. Formatting moves into the UI rather than a new formatter class. |

Post-design re-check: unchanged, all pass.

## Project Structure

### Documentation (this feature)

```text
specs/001-runanywhere-model-download/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/model-download-contracts.md
└── tasks.md            # /speckit-tasks
```

### Source Code (repository root)

```text
gradle/libs.versions.toml                       # + runanywhere version, sdk + llamacpp
app/build.gradle.kts                            # + deps; Java 11 → 17
app/src/main/java/com/jayvijay/scottie/
├── ScottieApplication.kt                       # RunAnywhere.initialize(this)
├── domain/
│   ├── entities/EdgeModel.kt                   # EdgeModel, ModelDownloadStatus, DownloadProgress, DownloadFailure
│   └── repository/ModelRepository.kt
├── data/repository/RunAnywhereModelRepository.kt   # SDK calls, job map, event + error mapping
├── di/DataModule.kt                            # @Binds ModelRepository, app CoroutineScope
└── presentation/
    ├── MainActivity.kt                         # root = ModelDownloadScreen; drop StaticScreen
    └── features/modeldownload/
        ├── ModelDownloadScreen.kt              # state/actions per contract
        ├── ModelDownloadPresenter.kt           # new
        ├── ModelDownloadUi.kt                  # loading/error/empty, status formatting
        └── component/ModelDownloadCard.kt      # + FAILED, Retry label
app/src/main/res/values/strings.xml             # status, failure, empty, error strings
app/src/test/java/com/jayvijay/scottie/
├── presentation/features/modeldownload/ModelDownloadPresenterTest.kt
├── presentation/features/modeldownload/FakeModelRepository.kt
└── data/repository/DownloadFailureMappingTest.kt
```

**Structure Decision**: Use the existing single `:app` module and its layer packages per
`AGENTS.md`. The `di/DomainModule.kt` file is empty and stays untouched.

## Complexity Tracking

No violations.

## Risks

- **Empty catalog** (research R4): keyless mode may list no remote models. It can't be verified
  under FR-014. If it happens, the empty state shows and curated `ModelRegistration`s become a
  follow-up.
- **Native library collision** with the existing LiteRT/QNN jniLibs (research R2). The build step
  catches it.
- **Untested repository**: `RunAnywhereModelRepository` calls the SDK directly, so its offline
  listing and restart behavior (SC-003, SC-004) are checked by inspection, not by tests.
- **Partial-byte delete**: whether `models.delete` removes partial bytes of a never-completed model
  is not documented. The app clears its status regardless.
