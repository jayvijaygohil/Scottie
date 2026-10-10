# Implementation Plan: Chat Window as Home Screen

**Branch**: `007-chat-home-screen` | **Date**: 2026-10-10 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/007-chat-home-screen/spec.md`

## Summary

Make the existing Interac assistant the back-stack root and restyle it to match the model download
(Settings) screen. The download repository becomes the single owner of "downloaded text models"
and the persisted active model; the assistant reads both through a small domain contract adapted in
`di/`. The toolbar gains a model selector and a gear; the chat gains reply cards, a primary-colored
user bubble, a styled composer with a send icon, a dots thinking indicator, progressive text
reveal, bottom-follow scrolling, a welcome card with example prompts, an empty state, and haptics.
Transitions reuse the already-installed gesture navigation decoration. No new dependencies.

## Technical Context

**Language/Version**: Kotlin (as configured), Android

**Primary Dependencies**: Jetpack Compose 1.13.0-beta01, Material3 1.5.0-beta01, Slack Circuit +
circuitx (gesture navigation), Hilt/KSP, Koog 1.3.0, AndroidX A2UI — all already installed

**Storage**: `SharedPreferences` for one string (active model id); conversation in memory
(`rememberRetained`)

**Testing**: JUnit + Circuit test (`FakeNavigator`, presenter tests), Turbine, Robolectric Compose
UI tests in `app/src/test`; device checks per quickstart

**Target Platform**: Android phone (existing min/target SDK)

**Project Type**: mobile-app (single `:app` module)

**Performance Goals**: thinking indicator within 200 ms of Send; 60 fps scrolling while revealing

**Constraints**: fully on-device/offline; no new libraries; feature slices must not import each
other

**Scale/Scope**: 2 screens touched (chat, settings), 1 shared toolbar component, ~12 files

## Constitution Check

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | PASS | Active-model policy lives in `modeldownload` data; Interac sees it via `domain/repository/TextModelSource` (declarations only), adapted in `di/`. No cross-feature imports; `TextModelDestination` replaced by `ModelSettingsDestination` bound in `di/`. |
| II. Circuit-Driven Presentation | PASS | Navigation (`OpenSettings`, `UseModel` → pop) and selection happen in presenters. UI only renders, dispatches actions, and plays haptics/animations. Strings in resources. |
| III. Bounded AI Agents | PASS | Agent unchanged; only the model id it receives changes source. |
| IV. Verified Changes | PASS (planned) | Presenter + repository + UI tests listed in quickstart; `:app:connectedDebugAndroidTest` runs because launch screen and device behaviour change; manual device checks for haptics, transitions, reveal. |
| V. Simplicity | PASS | No new dependency, no shared-element setup, no token streaming, no conversation persistence. `ScottieToolbar` extended rather than duplicated (real reuse by two screens). |

Post-design re-check: PASS — design artifacts introduce one domain interface (repository contract,
explicitly allowed), one entity, two repository members, and one `fun interface` destination
(existing pattern).

## Project Structure

### Documentation (this feature)

```text
specs/007-chat-home-screen/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/chat-ui.md
└── tasks.md            # /speckit-tasks
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
├── MainActivity.kt                                   # root = InteracAssistantScreen
├── core/ui/components/ScottieToolbar.kt              # nullable onBack, titleContent, actions
├── di/InteracModule.kt                               # TextModelSource adapter, ModelSettingsDestination
├── feature/modeldownload/
│   ├── domain/repository/ModelDownloadRepository.kt  # + activeTextModel, selectTextModel
│   ├── data/repository/ModelDownloadRepositoryImpl.kt# resolution + SharedPreferences
│   └── presentation/
│       ├── ModelDownloadPresenter.kt                 # UseModel → select + pop
│       └── TextModelDestination.kt                   # deleted
└── feature/interacbanking/
    ├── domain/entities/TextModelOption.kt            # new
    ├── domain/agent/workflow/InteracAssistantAgent.kt # rethrow inference failures (FR-015)
    ├── domain/repository/TextModelSource.kt          # new
    └── presentation/
        ├── InteracAssistantScreen.kt                 # data object
        ├── InteracAssistantContract.kt               # state/actions per data-model
        ├── InteracAssistantPresenter.kt              # models, selection, settings nav
        ├── ModelSettingsDestination.kt               # new fun interface
        ├── InteracAssistantUi.kt                     # restyle per research R7
        ├── component/ChatComponents.kt               # ReplyCard, UserBubble, ThinkingDots,
        │                                             #   Composer, ModelSelector, Welcome, EmptyState
        └── a2ui/components/Badge.kt                  # palette alignment (FR-027)
app/src/main/res/values/strings.xml                   # strings per contract
app/src/test/.../feature/{modeldownload,interacbanking}/...   # tests per quickstart
```

**Structure Decision**: existing single-module feature-slice layout; new chat-only composables go
in `feature/interacbanking/presentation/component/` (not `core/`, no second user).

## Complexity Tracking

None — no constitution violations.
