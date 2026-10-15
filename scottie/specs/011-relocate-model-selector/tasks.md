# Tasks: Relocate Model Selection & Update Chat Header Actions

**Input**: Design documents from `/scottie/specs/011-relocate-model-selector/`

**Prerequisites**: [plan.md](plan.md), [spec.md](spec.md), [research.md](research.md),
[data-model.md](data-model.md), [contracts/ui-contracts.md](contracts/ui-contracts.md),
[quickstart.md](quickstart.md)

**Tests**: Included per Constitution Principle IV (Verified Changes: unit tests for presenters using
fakes and Compose UI tests for screen actions).

**Organization**: Tasks are grouped by user story so each capability can be implemented and verified
incrementally.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies on incomplete tasks)
- **[Story]**: `[US1]`, `[US2]`, `[US3]` from [spec.md](spec.md)

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Add localized string resources required by the updated Chat header and relocated model
selector.

- [X] T001 Add string resources `chat_header_logo` (`Scootie`) and `chat_clear` (`Clear chat`) in `app/src/main/res/values/strings.xml`

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Update cross-feature and Chat screen contracts before wiring the individual user
stories.

**⚠️ CRITICAL**: Complete this phase before starting User Stories 1–3.

- [X] T002 Simplify `TextModelSource` to `fun interface TextModelSource { val active: Flow<String?> }` (`active` nullable `String?`, `null` when no text model is available), delete unused `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/entities/TextModelOption.kt`, and update `InteracModule.textModelSource(...)` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/repository/TextModelSource.kt` and `app/src/main/java/com/jayvijay/scottie/di/InteracModule.kt`
- [X] T003 Update `InteracAssistantState` (remove `models: List<TextModelOption>`) and `InteracAssistantAction` (remove `SelectModel`, add `data object ClearChat : InteracAssistantAction`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantContract.kt`

**Checkpoint**: Cross-feature seam and Chat contract updated.

---

## Phase 3: User Story 1 - Select the active chat model from the Settings page (Priority: P1) 🎯 MVP

**Goal**: Users can view the currently active text model and switch between downloaded on-device
text models and checked OpenRouter remote models directly on the Settings (`ModelDownloadScreen`)
page.

**Independent Test**: Open Settings with downloaded local and/or checked remote text models, select
a different model in the Settings model selector, and verify `ModelDownloadRepository.activeTextModel`
updates and persists.

### Implementation & Tests for User Story 1

- [X] T004 [US1] Add `data class TextModelOption(val id: String, val name: String, val remote: Boolean = false)` (`id` non-blank model identifier, `name` display name, `remote = true` for `openrouter:` models), `val models: List<TextModelOption> = emptyList()`, and `val activeModelId: String? = null` to `ModelDownloadState`, plus `data class SelectModel(val modelId: String) : ModelDownloadAction` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadScreen.kt`
- [X] T005 [US1] Update `ModelDownloadPresenter` to collect `repository.activeTextModel`, build `models: List<TextModelOption>` (downloaded `ModelType.TEXT` catalog entries first, followed by saved OpenRouter model IDs mapped with `OpenRouterConfig.remoteId(id)` and `remote = true`), populate `models` and `activeModelId` on `ModelDownloadState`, and handle `ModelDownloadAction.SelectModel` via `repository.selectTextModel(action.modelId)` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadPresenter.kt`
- [X] T006 [US1] Move `ModelSelector` (`TAG_MODEL_SELECTOR = "chat_model_selector"`, `TAG_MODEL_OPTION = "chat_model_option"`, showing `stringResource(R.string.chat_empty_title)` when `activeModel == null` and `enabled = state.models.isNotEmpty()`) to `feature/modeldownload/presentation` and render it in `ModelDownloadUi` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadUi.kt` and `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/component/ModelSections.kt`
- [X] T007 [P] [US1] Add unit tests in `ModelDownloadPresenterTest` verifying `models` ordering (local downloaded text models before remote OpenRouter models), `activeModelId` state emission, and `ModelDownloadAction.SelectModel` updating the active model without popping navigation in `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`

**Checkpoint**: User Story 1 (MVP) is complete and verifiable via `ModelDownloadPresenterTest`.

---

## Phase 4: User Story 2 - Navigate to Settings via long-press on the 'Scootie' header logo (Priority: P1)

**Goal**: The Chat page header replaces the model selector with the `'Scootie'` brand logo text,
ignores single taps, and navigates to Settings with haptic feedback on a long-press gesture.

**Independent Test**: Render `InteracAssistantUi`, verify `'Scootie'` logo text (`TAG_LOGO`) is
shown without `TAG_MODEL_SELECTOR`, single-tap `TAG_LOGO` (no action emitted), and long-press
`TAG_LOGO` (`InteracAssistantAction.OpenSettings` emitted).

### Implementation & Tests for User Story 2

- [X] T008 [US2] Remove `ModelSelector` from `ChatComponents.kt`, add `TAG_LOGO = "chat_logo"`, and update `InteracAssistantUi`'s `ScottieToolbar` `titleContent` to render the `'Scootie'` logo (`R.string.chat_header_logo`) with `Modifier.combinedClickable(onClick = {}, onLongClickLabel = stringResource(R.string.chat_settings), onLongClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); state.eventSink(InteracAssistantAction.OpenSettings) })` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt` and `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/component/ChatComponents.kt`
- [X] T009 [P] [US2] Update `InteracAssistantUiTest` to verify `TAG_LOGO` displays `"Scootie"`, `TAG_MODEL_SELECTOR` is absent from the Chat screen, single-clicking `TAG_LOGO` dispatches no action, and long-clicking `TAG_LOGO` dispatches `InteracAssistantAction.OpenSettings` in `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt`

**Checkpoint**: User Stories 1 and 2 work independently.

---

## Phase 5: User Story 3 - Clear chat history and conversation context from the Chat header (Priority: P1)

**Goal**: The Chat header's trailing action button clears all conversation turns, rendered A2UI
surfaces, and unsent composer text when tapped, returning the screen to the Welcome state.

**Independent Test**: Send a turn in `InteracAssistantPresenter`, dispatch
`InteracAssistantAction.ClearChat`, and verify `turns` is empty, `input` is `""`, and `deleteSurface`
envelopes are sent to `A2uiBridge`.

### Implementation & Tests for User Story 3

- [X] T010 [US3] Update `InteracAssistantPresenter` to remove `SelectModel` handling and implement `InteracAssistantAction.ClearChat` (ignored when `busy` or when `turns.isEmpty() && input.isBlank()`; deletes all active turn/bridge surfaces via `InteracSurfaceTemplates.deleteSurface`, sets `turns = emptyList()`, `input = ""`, and clears `startedAt`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt`
- [X] T011 [US3] Replace the Settings `IconButton` (`TAG_SETTINGS`, `Icons.Rounded.Tune`) in `InteracAssistantUi` with the Clear Chat/Context `IconButton` (`TAG_CLEAR_CHAT = "chat_clear"`, `Icons.Rounded.DeleteSweep`, `contentDescription = stringResource(R.string.chat_clear)`), enabled when `!state.busy && (state.turns.isNotEmpty() || state.input.isNotBlank())` and dispatching `InteracAssistantAction.ClearChat` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt`
- [X] T012 [P] [US3] Update `InteracAssistantPresenterTest` for the simplified `TextModelSource` contract and add unit tests verifying `InteracAssistantAction.ClearChat` resets `turns`, `input`, and `bridge` surfaces when idle and is ignored while `busy` in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`
- [X] T013 [P] [US3] Update `InteracAssistantUiTest` to verify `TAG_CLEAR_CHAT` is disabled when `turns.isEmpty() && input.isBlank()` or when `busy = true`, and enabled + dispatches `InteracAssistantAction.ClearChat` when turns or input exist in `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt`

**Checkpoint**: All 3 user stories are functional and covered by unit and UI tests.

---

## Phase 6: Polish & Cross-Cutting Concerns

**Purpose**: Run full build, unit test, static analysis, and lint gates.

- [X] T014 Run validation suite (`./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug`) per `scottie/specs/011-relocate-model-selector/quickstart.md`

---

## Dependencies & Execution Order

### Phase Dependencies

- **Phase 1 (Setup)**: No dependencies — starts immediately.
- **Phase 2 (Foundational)**: Depends on Phase 1 — updates shared contracts (`TextModelSource`, `InteracAssistantContract`).
- **Phase 3 (US1 - Settings Model Selection)**: Depends on Phase 2 — touches `feature/modeldownload` files only.
- **Phase 4 (US2 - 'Scootie' Header Logo & Long-Press)** & **Phase 5 (US3 - Clear Chat/Context Button)**: Depend on Phase 2 — touch `feature/interacbanking` files.
- **Phase 6 (Polish)**: Depends on Phases 3–5.

### Parallel Opportunities

- Once Phase 2 finishes, **Phase 3 (`feature/modeldownload`: `T004`–`T007`)** and **Phases 4–5 (`feature/interacbanking`: `T008`–`T013`)** touch completely disjoint feature packages and can run in parallel.
- Test tasks `T007`, `T009`, `T012`, and `T013` touch separate test files and can run in parallel once their respective production classes compile.

---

## Parallel Example

```bash
# After Phase 2 (T002, T003), run Settings and Chat tracks in parallel:
Track A (US1 - feature/modeldownload): T004 -> T005 -> T006 -> T007
Track B (US2 & US3 - feature/interacbanking): T008 -> T010 -> T011 -> T009 & T012 & T013
```

---

## Implementation Strategy

### MVP First (User Story 1)

1. Complete Phase 1 (`T001`) and Phase 2 (`T002`–`T003`).
2. Complete Phase 3 (`T004`–`T007`) so active model selection is live and tested on the Settings screen.
3. Complete Phase 4 (`T008`–`T009`) and Phase 5 (`T010`–`T013`) to update the Chat header (`'Scootie'` long-press + Clear Chat/Context action).
4. Run Phase 6 (`T014`) verification gates.
