---

description: "Task list for 007 Chat Window as Home Screen"
---

# Tasks: Chat Window as Home Screen

**Input**: Design documents from `/specs/007-chat-home-screen/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/chat-ui.md, quickstart.md

**Tests**: Included — constitution IV requires presenter tests; quickstart lists the coverage.

**Organization**: Grouped by user story (spec priorities: US1 P1, US2 P1, US3 P2, US4 P3).

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: US1–US4
- Paths: `APP` = `app/src/main/java/com/jayvijay/scottie/`, `TEST` =
  `app/src/test/java/com/jayvijay/scottie/`, `RES` = `app/src/main/res/`

---

## Phase 1: Setup

- [X] T001 Add strings from contracts/chat-ui.md to `RES/values/strings.xml`: `chat_empty_title`
  ("No model downloaded yet"), `chat_empty_action` ("Download a Model to Get Started"),
  `chat_settings` ("Model settings"), `chat_model_selector` ("Choose model, current: %1$s"),
  `chat_thinking` ("Assistant is thinking"), `chat_send` ("Send message"), `chat_welcome_title`
  ("Hi! I can help with Interac e-Transfers."), `chat_example_balance` ("What\'s my balance?"),
  `chat_example_send` ("Send $50 to Alice"), `chat_example_request` ("Request $30 from Jane for
  dinner"); change `assistant_use_model` to "Use in chat". Leave `assistant_send`,
  `assistant_thinking`, `assistant_model_missing` for removal in T035.

---

## Phase 2: Foundational (blocks all stories)

**Purpose**: active-model ownership (research R1), root screen, toolbar slots.

- [X] T002 Add to `APP/feature/modeldownload/domain/repository/ModelDownloadRepository.kt`:
  `val activeTextModel: StateFlow<String?>` (KDoc: "Stored id if that entry is `TEXT` and
  `Downloaded`; else first such entry in catalog order; else null") and
  `fun selectTextModel(modelId: String)` (KDoc: "Ignored unless `id` is a downloaded text model").
- [X] T003 Provide `@Named("activeTextModelPrefs") SharedPreferences` (`context.getSharedPreferences(
  "active_text_model", MODE_PRIVATE)`) in `APP/di/DataModule.kt`.
- [X] T004 Implement T002 in `APP/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`:
  inject the prefs from T003; keep `MutableStateFlow<String?>` of the stored id (read key
  `active_text_model` at construction); `activeTextModel = combine(catalog, stored)` resolved per
  data-model.md, `stateIn(scope, Eagerly, null)`; `selectTextModel` writes with `edit { putString }`
  only when the id is a `TEXT` entry with status `Downloaded`, then updates the stored flow.
- [X] T005 Update `TEST/feature/modeldownload/presentation/FakeModelDownloadRepository.kt` with
  `activeTextModel` (MutableStateFlow) and a recorded `selectTextModel`.
- [X] T006 Tests in `TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt`
  (Robolectric prefs via `ApplicationProvider`): stored + downloaded → stored; stored not
  downloaded → first downloaded TEXT in catalog order; none → null; SPEECH_RECOGNITION ignored;
  `selectTextModel` persists across a new instance; non-downloaded id ignored. Update existing
  constructor calls for the new parameter.
- [X] T007 [P] Create `APP/feature/interacbanking/domain/entities/TextModelOption.kt`:
  `data class TextModelOption(val id: String, val name: String)` (`id` = `.litertlm` file name).
- [X] T008 [P] Create `APP/feature/interacbanking/domain/repository/TextModelSource.kt`: interface
  with `val models: Flow<List<TextModelOption>>` ("Downloaded text models, catalog order"),
  `val active: Flow<String?>` ("null → empty state"), `fun select(id: String)`; declarations only.
- [X] T009 [P] Create `APP/feature/interacbanking/presentation/ModelSettingsDestination.kt`:
  `fun interface ModelSettingsDestination { fun screen(): Screen }` with KDoc mirroring the deleted
  `TextModelDestination` (bound in `di/` so features don't import each other).
- [X] T010 In `APP/di/InteracModule.kt`: provide `TextModelSource` as an object over
  `ModelDownloadRepository` (`models` = `catalog` mapped from `ModelCatalog.Ready` entries filtered
  `model.type == TEXT && status == Downloaded` → `TextModelOption(model.id, model.name)`, empty
  otherwise; `active` = `activeTextModel`; `select` = `selectTextModel`); provide
  `ModelSettingsDestination { ModelDownloadScreen }`; remove the `TextModelDestination` provider.
- [X] T011 Change `APP/feature/interacbanking/presentation/InteracAssistantScreen.kt` to
  `@Parcelize data object InteracAssistantScreen : ParcelableScreen` and set it as
  `rememberSaveableBackStack(root = InteracAssistantScreen)` in `APP/MainActivity.kt`.
- [X] T012 Update `APP/feature/interacbanking/presentation/InteracAssistantContract.kt` per
  data-model.md: replace `modelName` with `models: List<TextModelOption>` and
  `activeModelId: String?`; keep `missingModel`; remove `Back`; add `data class SelectModel(val id:
  String)` and `data object OpenSettings`.
- [X] T013 Update `APP/feature/interacbanking/presentation/InteracAssistantPresenter.kt`: drop
  `screen` and `@Named("liteRtModelsDir")` params; inject `TextModelSource` and
  `ModelSettingsDestination`; collect `models`/`active` with `collectAsState(initial = …)`;
  `missingModel = active == null`; `Send` no-op when `active == null || busy`; pass `active` to
  `extractor.extract`; `SelectModel` ignored while `busy` else `source.select(id)`;
  `OpenSettings` → `navigator.goTo(destination.screen())`; update the assisted factory signature.
- [X] T014 Extend `APP/core/ui/components/ScottieToolbar.kt`: `onBack: (() -> Unit)?` (no
  navigation icon when null; `backLabel` becomes `String?`), optional
  `titleContent: (@Composable () -> Unit)?` replacing the text title when set, and
  `actions: @Composable RowScope.() -> Unit = {}`; add a preview with title slot + action. Existing
  call sites unchanged.
- [X] T015 Update `TEST/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt` and
  `FakeIntentExtractor.kt` for the new constructor (fake `TextModelSource` with MutableStateFlows,
  `FakeNavigator(InteracAssistantScreen)`); remove the models-dir setup; existing feature 005
  scenarios must still pass.

**Checkpoint**: app builds and launches into the (unstyled) assistant; `./gradlew
:app:testDebugUnitTest` green.

---

## Phase 3: User Story 1 — Chat with the assistant from the first screen (P1) 🎯 MVP

**Goal**: restyled chat with reply cards, user bubbles, dots, reveal, auto-scroll, composer,
haptic on send (research R2, R4, R5, R7).

**Independent Test**: one text model downloaded, network off: launch, send "What's the weather?"
and "Send $50 to Alice"; bubbles, dots, word reveal, cards, auto-scroll, tick.

### Tests

- [X] T016 [P] [US1] Presenter tests in `TEST/feature/interacbanking/presentation/
  InteracAssistantPresenterTest.kt`: Send passes the active id to the extractor; Send ignored when
  busy; Thinking turn appended before the reply.
- [X] T017 [P] [US1] UI tests in `TEST/feature/interacbanking/presentation/InteracAssistantUiTest.kt`:
  `chat_send` disabled when input blank or busy; `chat_thinking` shown for `TurnReply.Thinking`;
  user bubble and reply card present for a text turn.

### Implementation

- [X] T018 [P] [US1] Create `APP/feature/interacbanking/presentation/component/ChatComponents.kt`
  with internal composables: `ReplyCard` (`Surface`, `colorScheme.surface`, 16 dp radius, 16 dp
  padding, start-aligned, max width 340 dp, test tag `assistant_reply`), `UserBubble`
  (`colorScheme.primary`/`onPrimary`, `RoundedCornerShape(16,16,4,16 dp)`, end-aligned, max width
  300 dp, tag `assistant_user_bubble`), `ThinkingDots` (three 6 dp dots with staggered
  `rememberInfiniteTransition` alpha, `contentDescription = stringResource(chat_thinking)`, tag
  `chat_thinking`), `RevealText(text, turnId, onProgress: () -> Unit)` (word-by-word reveal ~30 ms/word via
  `LaunchedEffect(turnId)`, `rememberSaveable(turnId)` done flag so recreation shows full text; calls `onProgress` after each
  word so the list can follow),
  `Composer(value, enabled, onValueChange, onSend)` (styled like `ScottieSearchField`: `surface`,
  1 dp `outlineVariant` border, 12 dp radius, `BasicTextField` max 4 lines, placeholder
  `assistant_composer_hint`; round 44 dp `primary` `IconButton` with
  `Icons.AutoMirrored.Rounded.Send`, description `chat_send`, tag `chat_send`; tag
  `assistant_composer` on the row). Each with a `ScottieTheme` preview.
- [X] T019 [US1] Rework `Turn()` and layout in `APP/feature/interacbanking/presentation/
  InteracAssistantUi.kt`: `UserBubble`, then `ReplyCard` containing `ThinkingDots` | `RevealText`
  (text or `assistant_off_topic`) | fallback text | `A2uiSurface`; 8 dp within a turn, 20 dp
  between turns, 16 dp horizontal padding (FR-029); keep the debug latency line; use `Composer`.
- [X] T020 [US1] Auto-scroll in `InteracAssistantUi.kt`: hoist `rememberLazyListState()`; a
  `LaunchedEffect(turns.size, turns.lastOrNull()?.reply)` plus `RevealText`'s `onProgress` scroll to
  the last item when the list was at the bottom (`!canScrollForward`) before the change or the last
  turn is new; use `Modifier.imePadding()` so the composer and newest message stay above the
  keyboard.
- [X] T021 [US1] Haptic on Send in `Composer` callback in `InteracAssistantUi.kt`:
  `LocalHapticFeedback.current.performHapticFeedback(HapticFeedbackType.Confirm)` only when the
  send is enabled, then dispatch `Send`.
- [X] T022 [P] [US1] Align badge palette in `APP/feature/interacbanking/presentation/a2ui/
  components/Badge.kt`: `"success"` → `primaryContainer`/`onPrimaryContainer` (FR-027); verify
  `Alert.kt`, `BalanceCard.kt`, `Confirmation.kt`, `InteracForm.kt` use only `primary`, `error`,
  `onSurfaceVariant`, `outlineVariant`, `surface` roles and fix any other role.

- [X] T023 [P] [US1] In `APP/feature/interacbanking/domain/agent/workflow/InteracAssistantAgent.kt`
  stop swallowing exceptions from `agent.run` (model load or inference failure): let them propagate
  (keep `finally { agent.close() }`); unparseable output still returns `AssistantIntent.FALLBACK`.
  Update the `IntentExtractor` KDoc in `IntentExtractor.kt` ("throws on inference failure; falls back
  to OTHER on unparseable output"). Add a test in `TEST/feature/interacbanking/domain/agent/workflow/
  InteracAssistantAgentTest.kt` where the executor throws and `extract` throws.
- [X] T024 [US1] Add `data object Failed : TurnReply` to `InteracAssistantContract.kt`; in
  `InteracAssistantPresenter.kt` map a thrown extraction (`runCatching` around `respond`, rethrowing
  `CancellationException`) to `TurnReply.Failed` instead of `Fallback`; render it in the `ReplyCard`
  with new string `chat_reply_failed` ("Something went wrong. Please try again.") in
  `RES/values/strings.xml`; presenter test in `InteracAssistantPresenterTest.kt`: extractor throws →
  turn reply `Failed`, `busy` false, user turn kept (FR-015).

**Checkpoint**: US1 independently demoable with a model already active.

---

## Phase 4: User Story 2 — Get started when no model is downloaded (P1)

**Goal**: empty state → Settings → back to a ready chat; welcome card with examples (FR-018,
FR-019, FR-028).

**Independent Test**: fresh install: launch, tap the button, download, go back, send.

### Tests

- [X] T025 [P] [US2] Presenter tests in `InteracAssistantPresenterTest.kt`: `active == null` →
  `missingModel` true and Send no-op; `OpenSettings` → `FakeNavigator` receives the destination
  screen; `active` flips non-null → `missingModel` false.
- [X] T026 [P] [US2] UI tests in `InteracAssistantUiTest.kt`: `chat_empty_state` shown and composer
  absent when `missingModel`; its button dispatches `OpenSettings`; `chat_welcome` shown when ready
  with no turns; tapping a `chat_example` dispatches `InputChanged(example text)`.

### Implementation

- [X] T027 [P] [US2] Add `EmptyState(onDownload)` (card with `chat_empty_title` and a primary
  `XelaButton` `chat_empty_action`, tag `chat_empty_state`) and `Welcome(onExample)` (card with
  `chat_welcome_title` and three `XelaChip`/outlined chips for the example strings, tags
  `chat_welcome`/`chat_example`) to `component/ChatComponents.kt`.
- [X] T028 [US2] In `InteracAssistantUi.kt`: when `missingModel` render `EmptyState` (dispatch
  `OpenSettings`) and no composer; when ready with empty `turns` render `Welcome` (dispatch
  `InputChanged(text)`); replace the missing-model preview with an empty-state preview and add a
  welcome preview.

**Checkpoint**: US1 + US2 = shippable MVP.

---

## Phase 5: User Story 3 — Switch the active model on the fly (P2)

**Goal**: selector in the top bar, haptic tick, persisted choice (FR-006–FR-009, FR-021, FR-023).

**Independent Test**: two models downloaded: switch, send after each, relaunch keeps choice.

### Tests

- [X] T029 [P] [US3] Presenter tests in `InteracAssistantPresenterTest.kt`: `SelectModel(id)` calls
  `source.select(id)`; ignored while busy; turns unchanged after a switch.
- [X] T030 [P] [US3] UI test in `InteracAssistantUiTest.kt`: clicking `chat_model_selector` shows one
  `chat_model_option` per model with the active one marked; clicking another dispatches
  `SelectModel`; selector disabled while busy.

### Implementation

- [X] T031 [US3] Add `ModelSelector(models, activeId, enabled, onSelect)` to
  `component/ChatComponents.kt` (active name + `R.drawable.ic_chevron_down`, Material3
  `DropdownMenu` with `DropdownMenuItem` per model and a check `Icons.Rounded.Check` on the active
  one; `SegmentTick` haptic only when a different id is chosen; description `chat_model_selector`;
  tags per contract) and wire the top bar in `InteracAssistantUi.kt`: `ScottieToolbar(onBack =
  null, titleContent = { ModelSelector(...) }, actions = { gear IconButton
  (Icons.Rounded.Settings, description chat_settings, tag chat_settings) → OpenSettings })`;
  remove `assistant_title`/subtitle usage.

---

## Phase 6: User Story 4 — Move between Chat and Settings smoothly (P3)

**Goal**: "Use" selects and returns; slide + predictive back via the existing decoration (R3).

**Independent Test**: gear → Settings → back button and back gesture → chat intact; "Use" on a
model returns with it active.

- [X] T032 [US4] In `APP/feature/modeldownload/presentation/ModelDownloadPresenter.kt`: remove
  `TextModelDestination`; `UseModel(id)` → `repository.selectTextModel(id); navigator.pop()`.
  Delete `APP/feature/modeldownload/presentation/TextModelDestination.kt`.
- [X] T033 [US4] Update `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`:
  `UseModel` records `selectTextModel(id)` on the fake and pops (`FakeNavigator.awaitPop()`); drop
  the destination fake.
- [X] T034 [US4] Verify (no code unless broken) that `GestureNavigationDecorationFactory` in
  `APP/MainActivity.kt` animates push/pop between chat and Settings and that back from the chat
  root finishes the activity.

---

## Phase 7: Polish & Cross-Cutting

- [X] T035 Remove strings left unused after US1–US3 from `RES/values/strings.xml`:
  `assistant_send`, `assistant_thinking`, `assistant_model_missing`, `assistant_title` (only those
  with no remaining references).
- [X] T036 Run `./gradlew :app:testDebugUnitTest :app:detekt :app:lintDebug :app:assembleDebug`
  from the repository root and fix findings.
- [ ] T037 (skipped 2026-10-10: no device/emulator attached) Run `./gradlew :app:connectedDebugAndroidTest` on a connected device or emulator
  (constitution IV: launch screen and device behaviour change); report the result, or the skip and
  its reason if no device is available.
- [ ] T038 (not run 2026-10-10: no device attached) Device walk-through per `specs/007-chat-home-screen/quickstart.md` steps 1–9 (haptics,
  transitions, reveal, keyboard, light/dark side-by-side, feature 005 regression); record which
  steps were observed vs not run.

---

## Dependencies

```text
T001 ─┐
T002 → T003 → T004 → T005 → T006
T007, T008, T009 [P] → T010
T011, T012 → T013 → T015
T014
Phase 2 done → US1 (T016–T024) → US2 (T025–T028) → US3 (T029–T031) → US4 (T032–T034) → Polish
```

- US1 and US2 both edit `InteracAssistantUi.kt` and `ChatComponents.kt`; run sequentially.
- US3 needs T014 (toolbar slots). US4 needs T004/T005 (`selectTextModel`).
- US4's presenter work (T032–T033) touches only `modeldownload` and can run in parallel with US1–US3
  (string removal is deferred to Polish so nothing US1–US3 uses disappears early)
  once Phase 2 is done.

## Parallel examples

- Phase 2: T007, T008, T009 together; T014 alongside any of them.
- US1: T016, T017, T018, T022, T023 together, then T019 → T020 → T021 → T024.
- US2: T025, T026, T027 together, then T028.
- Across stories: T032 + T033 (modeldownload) while US1 is in progress.

## Implementation Strategy

1. MVP = Phase 1 + 2 + US1 + US2: chat is home, restyled, empty state routes to downloads.
2. Add US3 (selector), then US4 (Use → back, transition check).
3. Polish: full gradle checks, device walk-through.
