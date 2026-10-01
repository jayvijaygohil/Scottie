# Implementation Plan: Offline Model Download

**Branch**: `001-offline-model-download` | **Date**: 2026-10-01 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/001-offline-model-download/spec.md`

## Summary

Wire the existing model download screen to the RunAnywhere SDK. A singleton repository owns
catalog registration and the single active download (collecting `RunAnywhere.models.download`),
mapping SDK events to domain statuses (available, downloading, paused, failed, downloaded). Pause is
coroutine cancellation (SDK keeps partial bytes); resume/retry re-issue the download. A `dataSync`
foreground service keeps the process alive and shows progress/outcome notifications. A new Circuit
presenter maps repository state to the adapted Xela-based UI. SDK and service start are behind two
thin seams so all logic is tested with fakes. See [research.md](research.md).

## Technical Context

**Language/Version**: Kotlin 2.4.20, Java 17 target, AGP 9.4.1

**Primary Dependencies**: RunAnywhere SDK 0.20.27 (+ llamacpp, onnx; qhexrt-android 0.20.19),
Slack Circuit 0.39.0, Hilt 2.60.1 (KSP), Jetpack Compose Material 3, vendored Xela UI kit. No new
dependencies.

**Storage**: SDK-managed model files under app-private `filesDir`; download state in memory.

**Testing**: JUnit 4, kotlinx-coroutines-test, Turbine, circuit-test; hand-written fakes.

**Target Platform**: Android, minSdk 26, target/compile SDK 37.

**Project Type**: Single-module Android app (`:app`).

**Performance Goals**: Row reacts to actions < 1 s; progress refresh ≤ 2 s (SDK polls 250 ms);
notification updates ≤ 1/s.

**Constraints**: One download at a time; no network in tests; catalog registration (~13 s) off the
main thread after first frame; Android 15 `dataSync` time limit handled via `onTimeout` → pause.

**Scale/Scope**: ~100 catalog rows (all model types, NPU rows device-filtered), one screen, one
service.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Evidence |
|-----------|--------|----------|
| I. Layered architecture | PASS | Domain entities/repository contract are SDK-free; SDK, catalog, service in `data/`; bindings in `di/`. No use case (no multi-repository policy). |
| II. Circuit presentation | PASS | `ModelDownloadPresenter` with assisted `Navigator`; `@CircuitInject` factories; UI renders state, strings from resources, Xela components. |
| III. Bounded AI agents | N/A | No agents; inference client wrapper lives in `data/ai/provider/`. |
| IV. Verified changes | PASS | Repository and presenter tests with fakes; assemble/test/detekt/lint gates. Device tests: spec forbids real downloads in tests, so `connectedDebugAndroidTest` adds none; manual device check in quickstart. Skip must be reported at completion. |
| V. Simplicity | PASS (see tracking) | Two seam interfaces justified for testability; no WorkManager, no mocking library, no persistence of paused state. |

**Post-design re-check**: PASS — design artifacts introduce no further layers or dependencies.

## Project Structure

### Documentation (this feature)

```text
specs/001-offline-model-download/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/model-download-contracts.md
└── tasks.md             # /speckit-tasks
```

### Source Code (repository root `Scottie/`)

```text
app/src/main/AndroidManifest.xml                 # permissions + ModelDownloadService
app/src/main/res/values/strings.xml              # statuses, types, failures, notification copy
app/src/main/java/com/jayvijay/scottie/
├── domain/
│   ├── entities/ModelDownload.kt                # Model, ModelType, DownloadProgress, statuses, catalog
│   └── repository/ModelDownloadRepository.kt
├── data/
│   ├── ai/provider/
│   │   ├── ModelCatalog.kt                       # ported static catalog (CatalogModel rows)
│   │   ├── ModelRuntime.kt                       # seam + RuntimeDownloadEvent
│   │   ├── RunAnywhereModelRuntime.kt            # SDK init, registration, event/error mapping
│   │   ├── DownloadForegroundHost.kt             # seam + ServiceDownloadForegroundHost
│   │   └── ModelDownloadService.kt               # dataSync FGS: notifications, wake lock, cancel
│   └── repository/ModelDownloadRepositoryImpl.kt
├── di/DataModule.kt                              # bindings, application CoroutineScope
└── presentation/
    ├── MainActivity.kt                           # root = ModelDownloadScreen; drop StaticScreen
    └── features/modeldownload/
        ├── ModelDownloadScreen.kt                # state/actions per contract
        ├── ModelDownloadPresenter.kt
        ├── ModelDownloadUi.kt                    # loading/unavailable/list, toast, notif permission
        └── component/ModelDownloadCard.kt        # + FAILED/Retry, phase, disabled start

app/src/test/java/com/jayvijay/scottie/
├── data/repository/ModelDownloadRepositoryImplTest.kt
├── data/ai/provider/FakeModelRuntime.kt, FakeDownloadForegroundHost.kt, ModelCatalogTest.kt
└── presentation/features/modeldownload/ModelDownloadPresenterTest.kt (+ FakeModelDownloadRepository)
```

**Structure Decision**: Existing single `:app` module and layer packages. Service and SDK wrapper sit
in `data/ai/provider/` (inference provider infrastructure per data `AGENTS.md`). Placeholder
`StaticScreen` is removed in favor of the real root screen.

## Complexity Tracking

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|-------------------------------------|
| `ModelRuntime` interface with one production impl | SDK is a JNI-backed `object` needing a `Context`; JVM tests need a fake (FR-015) | Calling `RunAnywhere` directly from the repository makes download logic untestable without a device and real network |
| `DownloadForegroundHost` interface with one production impl | Repository must react to a refused foreground start without Android in tests | Starting the service from the repository via `Context` ties repository tests to Robolectric/device |
