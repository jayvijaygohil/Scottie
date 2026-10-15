# Implementation Plan: Relocate Model Selection & Update Chat Header Actions

**Branch**: `011-relocate-model-selector` | **Date**: 2026-10-14 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/011-relocate-model-selector/spec.md`

## Summary

Relocate active model selection from the Chat screen (`feature/interacbanking`) to the Settings screen (`feature/modeldownload`), replace the Chat header's model selector with the `'Scootie'` logo text configured with a long-press gesture (`combinedClickable`) to navigate to Settings, and replace the Chat header's Settings icon button with a Clear Chat/Context action button (`InteracAssistantAction.ClearChat`) that deletes active A2UI surfaces and resets conversation turns and composer input to the Welcome state.

## Technical Context

**Language/Version**: Kotlin 2.4.20, JDK 17, AGP 9.4.1, minSdk 26 / targetSdk 37

**Primary Dependencies**: Jetpack Compose + Material 3, Slack Circuit 0.39.0 (`hilt` codegen), Hilt 2.60.1, AndroidX A2UI 1.0.0-alpha01. No new dependencies or version upgrades.

**Storage**: Existing `activeTextModelFile` in `ModelDownloadRepositoryImpl` and `OpenRouterConfigRepositoryImpl` preferences; in-memory conversation state (`turns`, `input`, `surfaces`) in `InteracAssistantPresenter`.

**Testing**: JUnit 4 host unit tests (`:app:testDebugUnitTest`), `kotlinx-coroutines-test`, Circuit `test` / Turbine, and Compose UI tests (`:app:connectedDebugAndroidTest`).

**Target Platform**: Android (minSdk 26 / targetSdk 37).

**Project Type**: Single-module Android application with feature-slice Clean Architecture.

**Performance Goals**: Instant UI state transitions (< 16 ms frame budget) for clearing chat turns/surfaces and switching the active model.

**Constraints**: Zero cross-feature imports between `feature/interacbanking` and `feature/modeldownload`; `core/ui` remains independent of `feature/`; all user-visible text and accessibility labels in `res/values/strings.xml`; 2-space indent, 100-char line limit, and passing `detekt` / `lintDebug`.

**Scale/Scope**: Two existing presentation slices (`feature/interacbanking/presentation` and `feature/modeldownload/presentation`), DI wiring in `di/InteracModule.kt`, string resources in `res/values/strings.xml`, and presenter + Compose UI tests.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | PASS | `feature/interacbanking` and `feature/modeldownload` do not import each other. `ModelDownloadPresenter` already owns `ModelDownloadRepository` and `OpenRouterConfigRepository`, so moving `ModelSelector` to `feature/modeldownload` eliminates cross-feature model-list plumbing from `InteracModule`. |
| II. Circuit-Driven Presentation | PASS | Long-press Settings navigation (`OpenSettings`), Clear Chat (`ClearChat`), and Settings model selection (`SelectModel`) are all dispatched as `CircuitUiEvent` actions to their respective `Presenter`s; UIs remain stateless renderers using `stringResource` and applying `Modifier` to root. |
| III. Bounded AI Agents | PASS | No changes to `domain/agent/workflow/` or AI client boundaries; each turn continues to resolve the active model ID via `ModelResolver`. |
| IV. Verified Changes | PASS | Unit tests in `InteracAssistantPresenterTest` and `ModelDownloadPresenterTest` plus UI tests in `InteracAssistantUiTest`, verified with `:app:assembleDebug`, `:app:testDebugUnitTest`, `:app:detekt`, and `:app:lintDebug`. |
| V. Simplicity | PASS | Reuses the existing `ModelSelector` composable (moved to `feature/modeldownload`), simplifies `TextModelSource` by removing unused `models` and `select`, and adds zero new libraries, screens, or abstractions. |

**Post-design re-check**: PASS. No violations or Complexity Tracking justifications needed.

## Project Structure

### Documentation (this feature)

```text
scottie/specs/011-relocate-model-selector/
├── plan.md              # This file (/speckit-plan command output)
├── research.md          # Phase 0 output (/speckit-plan command)
├── data-model.md        # Phase 1 output (/speckit-plan command)
├── quickstart.md        # Phase 1 output (/speckit-plan command)
├── contracts/           # Phase 1 output (/speckit-plan command)
│   └── ui-contracts.md
└── tasks.md             # Phase 2 output (/speckit-tasks command - NOT created by /speckit-plan)
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
├── di/
│   └── InteracModule.kt                           # Simplify TextModelSource provider to expose active flow only
├── feature/
│   ├── interacbanking/
│   │   ├── domain/
│   │   │   └── repository/
│   │   │       └── TextModelSource.kt             # Trim to active: Flow<String?> (remove models & select)
│   │   └── presentation/
│   │       ├── InteracAssistantContract.kt        # Remove models & SelectModel; add ClearChat action
│   │       ├── InteracAssistantPresenter.kt       # Handle ClearChat (delete surfaces, clear turns/input); drop SelectModel
│   │       ├── InteracAssistantUi.kt              # Render 'Scootie' logo with long-press -> OpenSettings; replace Tune button with ClearChat button
│   │       └── component/
│   │           └── ChatComponents.kt              # Move ModelSelector out to feature/modeldownload; add ScootieHeaderLogo
│   └── modeldownload/
│       └── presentation/
│           ├── ModelDownloadScreen.kt             # Add TextModelOption, models, activeModelId to state; add SelectModel action
│           ├── ModelDownloadPresenter.kt          # Expose available local+remote TextModelOptions and activeModelId; handle SelectModel
│           ├── ModelDownloadUi.kt                 # Render ModelSelector in Settings header/top area
│           └── component/
│               └── ModelSections.kt               # Host relocated ModelSelector component (or in ModelDownloadCard.kt)
└── app/src/main/res/values/
    └── strings.xml                                # Add chat_header_logo ("Scootie") and chat_clear ("Clear chat")

app/src/test/java/com/jayvijay/scottie/feature/
├── interacbanking/presentation/
│   └── InteracAssistantPresenterTest.kt           # Update for ClearChat action & simplified TextModelSource
└── modeldownload/presentation/
    └── ModelDownloadPresenterTest.kt              # Add tests for models list (local + remote), activeModelId, and SelectModel action

app/src/androidTest/java/com/jayvijay/scottie/feature/
└── interacbanking/presentation/
    └── InteracAssistantUiTest.kt                  # Test 'Scootie' logo single-tap no-op, long-press OpenSettings, and ClearChat button state/dispatch
```

**Structure Decision**: Modify `feature/interacbanking` and `feature/modeldownload` presentation layers in-place. Moving `ModelSelector` and `TextModelOption` from `feature/interacbanking` to `feature/modeldownload` keeps each component inside the single feature slice that renders it and removes dead cross-feature wiring.

## Complexity Tracking

None.
