# Implementation Plan: OpenRouter Model Picker

**Branch**: `009-openrouter-model-picker` | **Date**: 2026-10-10 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `specs/009-openrouter-model-picker/spec.md`

## Summary

Replace feature 008's typed Models field with a checkable list fetched from the service's models
listing after Save and on Settings open. The checked identifiers are stored in the existing
`OpenRouterConfig.models` field, so chat (`di/InteracModule.kt`) and 008 configurations work
unchanged. The list is fetched with `HttpURLConnection` and parsed with the app's existing `Json`;
no dependency is added. Settings also moves the OpenRouter section to the top and starts every
section collapsed on each visit (FR-015, FR-016).

## Technical Context

**Language/Version**: Kotlin (version from `gradle/libs.versions.toml`), Android app module `:app`

**Primary Dependencies**: Jetpack Compose Material 3, Slack Circuit 0.39.0, Hilt + KSP,
kotlinx.serialization (installed). No new dependencies.

**Storage**: Existing app-private JSON file `openRouterConfigFile` via
`OpenRouterConfigRepositoryImpl`; the selection reuses its `models` list. The fetched list is not
stored.

**Testing**: JUnit host tests (`:app:testDebugUnitTest`) with Circuit `presenterTestOf`, the
existing `FakeOpenRouterConfigRepository`, and a JSON-fixture parser test

**Target Platform**: Android (minSdk from `app/build.gradle.kts`); `INTERNET` permission already
declared

**Project Type**: Single-module mobile app

**Performance Goals**: List shown within 3 s of Save on a typical connection (SC-002); filtering
300+ entries without visible delay (SC-004)

**Constraints**: API Key never logged or shown (FR-013); Save works offline (FR-009); 100-column
Kotlin lines

**Scale/Scope**: About 300–400 models over one or a few pages; one Settings screen changed

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|-----------|--------|-------|
| I. Layered architecture | Pass | Entities and contract in `feature/modeldownload/domain/`; HTTP client in `data/remote/`; presenter depends on domain only. No cross-feature import added; chat already reads `OpenRouterConfig` through `di/`. |
| II. Circuit presentation | Pass | Fetch, retry, toggle, and search are presenter actions; UI renders state. Existing factories unchanged. |
| III. Bounded AI agents | N/A | No agent change. |
| IV. Verified changes | Pass | Presenter tests for fetch/retry/toggle/prune/order/collapse; parser fixture test; assemble, unit tests, detekt, lint. No device test exists for this screen; device verification is a quickstart manual step. |
| V. Simplicity | Pass | No new library: `HttpURLConnection` + installed `Json`. Koog `models()` rejected (research R1). Selection reuses `OpenRouterConfig.models`; no migration. |

Post-design re-check: Pass. Design adds one domain method, one data/remote class, and one value
type; no Complexity Tracking entries.

## Project Structure

### Documentation (this feature)

```text
specs/009-openrouter-model-picker/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/
│   ├── models-listing.md          # consumed service response subset
│   └── openrouter-settings-ui.md  # Settings section states and actions
└── tasks.md                       # /speckit-tasks output
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
└── feature/modeldownload/
    ├── domain/entities/OpenRouterConfig.kt            # drop MODELS field + modelsText; add AvailableModel, ModelsFetch
    ├── domain/repository/OpenRouterConfigRepository.kt  # + fetchAvailableModels()
    ├── data/remote/OpenRouterModelsClient.kt          # NEW, @Inject: GET + pages + parse + error kind
    ├── data/repository/OpenRouterConfigRepositoryImpl.kt  # fetch, prune selection on success
    └── presentation/
        ├── ModelDownloadScreen.kt                     # OpenRouterSection: list state, query; new actions
        ├── ModelDownloadPresenter.kt                  # fetch trigger, toggle, search; default collapsed
        └── component/
            ├── ModelSections.kt                       # OpenRouter first
            └── OpenRouterCard.kt                      # list, search, loading/error/Retry; no Models field
app/src/main/res/values/strings.xml                    # new copy
app/src/test/java/com/jayvijay/scottie/feature/modeldownload/
├── data/remote/OpenRouterModelsClientTest.kt          # NEW: fixture parsing, text filter, dedupe
├── domain/entities/OpenRouterConfigTest.kt            # validation without models
└── presentation/ModelDownloadPresenterTest.kt         # + fake fetch results
```

**Structure Decision**: Everything stays in the `modeldownload` feature slice that already owns
the OpenRouter settings; `core/ai/OpenRouterTextModels.normalize` is reused for the base URL.

## Complexity Tracking

None.
