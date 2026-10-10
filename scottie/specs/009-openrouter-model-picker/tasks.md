# Tasks: OpenRouter Model Picker

**Input**: Design documents from `specs/009-openrouter-model-picker/`

**Prerequisites**: [plan.md](plan.md), [spec.md](spec.md), [research.md](research.md),
[data-model.md](data-model.md), [contracts/](contracts/), [quickstart.md](quickstart.md)

**Tests**: Included. Constitution IV requires presenter tests with fakes for actions, state
transitions, and failures.

**Paths**: `MAIN` = `app/src/main/java/com/jayvijay/scottie/feature/modeldownload`,
`TEST` = `app/src/test/java/com/jayvijay/scottie/feature/modeldownload`,
`RES` = `app/src/main/res/values/strings.xml`.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependency on an incomplete task)
- **[Story]**: US1, US2, US3 from spec.md

## Phase 1: Setup

None. No new module, dependency, or permission (`INTERNET` is already declared).

---

## Phase 2: Foundational (blocks all stories)

**Purpose**: Domain types, the fetch contract, and the network client every story uses.

- [X] T001 In `MAIN/domain/entities/OpenRouterConfig.kt` add
  `data class AvailableModel(val id: String, val name: String)`,
  `enum class FetchFailure { NO_CONNECTION, AUTH, OTHER }`, and
  `sealed interface ModelsFetch { data class Loaded(val models: List<AvailableModel>); data class
  Failed(val reason: FetchFailure) }`. Add
  `fun OpenRouterConfig.prunedTo(models: List<AvailableModel>): OpenRouterConfig` returning a copy
  whose `models` keeps only ids present in `models`, in the order of `models` (FR-010). Update the
  `OpenRouterConfig` KDoc: `models` is "checked OpenRouter ids, in fetched-list order; may be
  empty".
- [X] T002 In `MAIN/domain/entities/OpenRouterConfig.kt` remove `OpenRouterField.MODELS`, remove
  `modelsText` from `OpenRouterDraft`, and change it to
  `OpenRouterDraft(baseUrl, apiKey, selection: List<String>)`. `validate()` checks only the base
  URL ("http/https with host (unchanged validation)") and returns
  `OpenRouterConfig(url.trim(), apiKey.trim(), selection)` (FR-001, FR-011).
- [X] T003 In `MAIN/domain/repository/OpenRouterConfigRepository.kt` add
  `suspend fun fetchAvailableModels(): ModelsFetch` with KDoc: uses the saved config; returns
  `Failed(OTHER)` when nothing is saved; on `Loaded` also saves the config pruned with `prunedTo`;
  on `Failed` changes nothing.
- [X] T004 [P] Create `MAIN/data/remote/OpenRouterModelsClient.kt`, a `@Singleton` class with an
  `@Inject` constructor taking the app `Json`, per `contracts/models-listing.md` and research
  R1–R4:
  - `suspend fun fetch(baseUrl: String, apiKey: String): ModelsFetch` on `Dispatchers.IO` with
    `HttpURLConnection`, 15 s connect and read timeouts, `Accept: application/json`, and
    `Authorization: Bearer <key>` only when the key is non-blank. The first URL is
    `OpenRouterTextModels.normalize(baseUrl) + "/api/v1/models"` (from `core/ai`). Follow
    `links.next` resolved with `URI.resolve` against the current page until null or blank or a
    repeated URL.
  - Map no response (`IOException`) to `NO_CONNECTION`, HTTP 401/403 to `AUTH`, and other non-2xx
    or a decode failure to `OTHER`. Any failed page fails the whole fetch. Rethrow
    `CancellationException`.
  - `internal fun parsePage(body: String): Page` using private `@Serializable` DTOs whose fields
    are all nullable: `data[].id`, `data[].name`, `data[].architecture.output_modalities`,
    `links.next`.
  - `internal fun toAvailable(entries): List<AvailableModel>`: skip blank or missing `id`; keep an
    entry when `output_modalities` contains `text` (case-insensitive) or is missing; `name` falls
    back to `id`; dedupe by `id` keeping the first; sort by `name` case-insensitively, then `id`.
  - Log only the failure kind and HTTP status with `Log.w`; never log headers, the key, or the URL
    query (FR-013).
- [X] T005 [P] Create `TEST/data/remote/OpenRouterModelsClientTest.kt` covering `parsePage` +
  `toAvailable` with inline JSON fixtures: the spec example entry; an image-only entry dropped; a
  missing-`architecture` entry kept; a missing `name` shown as id; a missing `id` skipped; a
  duplicate id across two pages shown once; sorted by name; `links.next` null and blank are both
  the last page.
- [X] T006 Update `MAIN/data/repository/OpenRouterConfigRepositoryImpl.kt`: inject
  `OpenRouterModelsClient`; implement `fetchAvailableModels()` by reading `state.value` (return
  `Failed(OTHER)` when null), calling `client.fetch`, and on `Loaded` calling
  `save(current.prunedTo(result.models))` only if the config is still the one fetched for (a Delete
  or new Save during the fetch wins). Depends on T001, T003, T004.
- [X] T007 [P] Update `TEST/data/repository/OpenRouterConfigRepositoryImplTest.kt` to construct
  the repository with `OpenRouterModelsClient(json)`; existing persistence tests stay unchanged.
- [X] T008 [P] Update `TEST/domain/entities/OpenRouterConfigTest.kt`: remove the models-text cases;
  add a base-URL-only validation case that keeps the passed `selection`; add `prunedTo` cases
  (drops unlisted ids, reorders to the fetched order, empty list → empty selection).
- [X] T009 Update `TEST/presentation/FakeOpenRouterConfigRepository.kt`: add
  `var nextFetch: ModelsFetch = ModelsFetch.Loaded(emptyList())`, a `fetches` counter, and an
  optional `CompletableDeferred` gate so tests can observe Loading. `fetchAvailableModels()`
  applies `prunedTo` on `Loaded`, mirroring the real repository.

**Checkpoint**: `./gradlew :app:testDebugUnitTest --tests '*OpenRouter*'` passes; the app may not
compile until US1 replaces the Models field (T010–T013).

---

## Phase 3: User Story 1: Pick remote models from the fetched list (P1) 🎯 MVP

**Goal**: Save URL/key → list loads → checks become chat's remote models. Settings shows
OpenRouter first, and every section starts collapsed on each visit.

**Independent Test**: Save with a reachable service, check two models, open chat: exactly those
two are listed as remote and answer messages (quickstart steps 1–4, 8).

- [X] T010 [US1] In `MAIN/presentation/ModelDownloadScreen.kt`: remove `modelsText` from
  `OpenRouterSection`; add `val list: RemoteModels`, where `sealed interface RemoteModels` is
  `Hidden`, `Loading`, `Loaded(val visible: List<AvailableModel>, val total: Int, val selected:
  Set<String>)` (`visible` is the full list until US2 adds filtering), or
  `Failed(val reason: FetchFailure)`. In `ModelDownloadAction` remove `EditOpenRouterModels` and
  add `data class ToggleRemoteModel(val id: String) : OpenRouter`. Update the `ToggleCategory`
  KDoc to say sections start collapsed.
- [X] T011 [US1] In `MAIN/presentation/ModelDownloadPresenter.kt` `presentOpenRouter()` (research
  R5, R6):
  - Remove `modelsText`. Save builds `OpenRouterDraft(baseUrl, apiKey, config?.models.orEmpty())`
    and, on `Valid`, calls `openRouter.save(...)` and increments a retained `fetchRequest`.
  - Retained `fetchRequest` starts at 1 when a config is saved; retained `fetchedFor` and
    `result: ModelsFetch?`. `LaunchedEffect(fetchRequest)`: if a config exists and
    `fetchedFor != fetchRequest`, set the list to Loading, call
    `openRouter.fetchAvailableModels()`, store the result, and set `fetchedFor = fetchRequest`.
    Recomposition after rotation must not refetch.
  - `list` = `Hidden` when `config == null`; `Loading` while a fetch runs; otherwise
    `Loaded(models, models.size, config.models.toSet())` or `Failed(reason)`.
  - `ToggleRemoteModel(id)`: flip the id in the selection and save
    `config.copy(models = fetched.map { it.id }.filter { it in newSelection })`, where `fetched` is
    the full list held in `result`, so the
    stored order follows the fetched list (FR-005, FR-006).
  - `ConfirmDeleteOpenRouter` also clears `result` (FR-012).
  - Change OpenRouter `expanded` to `rememberRetained { mutableStateOf(false) }` (FR-016).
- [X] T012 [US1] In `MAIN/presentation/ModelDownloadPresenter.kt` `catalogSections()`, change the
  default from `expansion[type] ?: true` to `?: false`, keeping `searching ||` first; update its
  KDoc and the `// User toggles only; sections without one are expanded.` comment to say
  collapsed (FR-016). In `present()`, `ToggleCategory` flips with `!(expansion[type] ?: false)`.
- [X] T013 [US1] In `MAIN/presentation/component/ModelSections.kt`, move the `"openrouter"` header
  item and the `"openrouter-card"` item above `sections.forEach` (FR-015). Leave the `Unavailable`
  branch in `ModelDownloadUi.kt` unchanged (the card is shown open).
- [X] T014 [US1] In `MAIN/presentation/component/OpenRouterCard.kt`: remove the Models
  `SettingsField`, `MODELS_MAX_LINES`, and the `OpenRouterCardTags.MODELS` tag. Below Save/Delete,
  render `section.list`: `Hidden` → nothing; `Loading` → a `CircularProgressIndicator` with the
  "Loading models" text (tag `MODELS_LOADING`); `Loaded` with `total == 0` → "No models
  available"; `Loaded` → one `Row` per `visible` entry with `Modifier.toggleable(value = id in selected,
  role = Role.Checkbox)`, a `Checkbox(onCheckedChange = null)`, the name, and the id in a
  secondary style (tag `MODEL_ROW_PREFIX + id`, list tag `MODEL_LIST`). The rows are plain
  `Column` children inside the existing `LazyColumn` item, so they use no nested lazy list. Add
  the tags to `OpenRouterCardTags`. Update the previews to a `Loaded` section with three models.
- [X] T015 [P] [US1] In `RES` remove `model_download_openrouter_models`,
  `model_download_openrouter_models_hint`, and `model_download_openrouter_error_models`; add
  `model_download_openrouter_models_loading` ("Loading models…") and
  `model_download_openrouter_models_empty` ("No models available"). Change
  `model_download_openrouter_delete_text` to "The API key and selected models will be deleted
  from this device."
- [X] T016 [US1] In `TEST/presentation/ModelDownloadPresenterTest.kt` update existing tests for
  the new defaults: `toggleCollapsesOnlyThatSectionWithoutTouchingDownloads` and
  `searchExpandsMatchesAndClearingRestoresToggles` start collapsed; `toggleOpenRouterFlipsExpansion`
  starts `false`; remove the Models-field cases from `saveStoresParsedConfigAndResetsDraftFromIt`,
  `invalidDraftReportsFieldsWithoutSaving`, `editingAFieldClearsOnlyItsError`, and
  `lenientModelsAndHttpUrlsSave`.
- [X] T017 [US1] Add presenter tests to `TEST/presentation/ModelDownloadPresenterTest.kt`:
  `sectionsAndOpenRouterStartCollapsed`; `saveKeepsSelectionAndFetches` (list goes Loading →
  Loaded, `fetches == 1`); `openingWithSavedConfigFetchesOnce`; `toggleSavesInFetchedOrder`
  (check C then A → saved `[A, C]`); `untoggleRemovesFromSelection`; `fetchPrunesUnlistedSelection`;
  `deleteHidesList`; `savingSameValuesRefetches` (`fetches == 2`).

**Checkpoint**: `./gradlew :app:assembleDebug :app:testDebugUnitTest` passes; US1 works end to
end.

---

## Phase 4: User Story 2: Find a model in a long list (P2)

**Goal**: A search field filters the fetched list without changing checks.

**Independent Test**: Type part of an id, see only matches, check one, clear the search: it is
still checked (quickstart step 3).

- [X] T018 [US2] In `MAIN/presentation/ModelDownloadScreen.kt` add `val query: String` to
  `OpenRouterSection` and `data class SearchRemoteModels(val query: String) : OpenRouter`.
  `RemoteModels.Loaded.visible` now carries the filtered list; `total` stays the full count.
- [X] T019 [US2] In `MAIN/presentation/ModelDownloadPresenter.kt` add a retained `remoteQuery`,
  handle `SearchRemoteModels`, and add an `internal fun filterRemote(models:
  List<AvailableModel>, query: String)` that does a case-insensitive substring match on `name` or
  `id` over the trimmed query (blank → all) (FR-007). Toggling still saves in full fetched order,
  not visible order. Delete clears `remoteQuery`.
- [X] T020 [US2] In `MAIN/presentation/component/OpenRouterCard.kt`, when `Loaded` and
  `total > 0`, render `ScottieSearchField` (from `core/ui/components`) above the rows with tag
  `MODEL_SEARCH`; when `visible` is empty and `total > 0`, show "No models match". Add the tag to
  `OpenRouterCardTags`.
- [X] T021 [P] [US2] In `RES` add `model_download_openrouter_models_search` ("Search models"),
  `model_download_openrouter_models_search_clear` ("Clear model search"), and
  `model_download_openrouter_models_no_match` ("No models match \"%1$s\"").
- [X] T022 [US2] Add presenter tests to `TEST/presentation/ModelDownloadPresenterTest.kt`:
  `remoteSearchMatchesNameOrIdIgnoringCase`, `remoteSearchKeepsHiddenChecks`,
  `remoteSearchWithoutMatchesIsEmptyButTotalKept`.

**Checkpoint**: US1 + US2 pass independently.

---

## Phase 5: User Story 3: Recover when the list cannot be fetched (P2)

**Goal**: Saves work offline; failures show a specific message with Retry; selections survive.

**Independent Test**: Network off → Save → error + Retry; network on → Retry → list (quickstart
steps 5–6).

- [X] T023 [US3] In `MAIN/presentation/ModelDownloadScreen.kt` add
  `data object RetryRemoteModels : OpenRouter`. In `MAIN/presentation/ModelDownloadPresenter.kt`
  handle it by incrementing `fetchRequest`. Confirm that a `Failed` result leaves
  `config.models` untouched (FR-009); chat keeps the stored models.
- [X] T024 [US3] In `MAIN/presentation/component/OpenRouterCard.kt`, render `Failed(reason)` as a
  message keyed by reason plus a `TextButton` Retry (tags `MODELS_ERROR`, `MODELS_RETRY`). For
  `AUTH` the message names the API Key field. The message never includes server text or the key
  (FR-013).
- [X] T025 [P] [US3] In `RES` add `model_download_openrouter_models_offline` ("Couldn't reach the
  service. Check your connection."), `model_download_openrouter_models_auth` ("The service
  rejected the API key. Check the API key field."), `model_download_openrouter_models_failed`
  ("Couldn't load models."), and `model_download_openrouter_models_retry` ("Retry").
- [X] T026 [US3] Add presenter tests to `TEST/presentation/ModelDownloadPresenterTest.kt`:
  `fetchFailureKindsMapToFailedState` (all three reasons); `retryRefetchesAndRecovers`;
  `failedFetchKeepsConfigAndSelection`; `reopeningSettingsRefetchesWithSelectionPrechecked`.

**Checkpoint**: All stories pass independently.

---

## Phase 6: Polish & Cross-Cutting

- [X] T027 Search for leftover references with
  `ide_search_text` on `EditOpenRouterModels`, `OpenRouterField.MODELS`, `modelsText`, and
  `model_download_openrouter_models_hint`; nothing may remain in `app/src`.
- [X] T028 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug`
  from the repository root and fix findings.
- [X] T029 Inspect the final diff for scope (preserve the staged spec files) and record which
  evidence exists: compilation, host tests, device not run.
- [ ] T030 Manual device check per `quickstart.md` steps 1–9 (needs a device and an OpenRouter
  key; don't run `connectedDebugAndroidTest` without asking).

---

## Dependencies & Execution Order

- **Foundational (T001–T009)** blocks every story. T001 → T002 → T003 → T006; T004 can run beside
  T001–T003; T005, T007, T008 after their targets; T009 after T001 and T003.
- **US1 (T010–T017)** after Foundational. T010 → T011 → T012 → T013 → T014; T015 any time; T016
  and T017 after T012.
- **US2 (T018–T022)** after T011 and T014 (same files).
- **US3 (T023–T026)** after T011 and T014; independent of US2 except the shared files, so run
  US2 and US3 one after the other, not in parallel.
- **Polish (T027–T030)** last.

## Parallel Examples

- Foundational: T004 (client) beside T001–T003 (domain); then T005, T007, T008 together.
- US1: T015 (strings) beside T010–T014.
- US2: T021 (strings) beside T018–T020.
- US3: T025 (strings) beside T023–T024.

## Implementation Strategy

1. **MVP**: Foundational + US1 → checkpoint → manual quickstart steps 1–4 and 8.
2. Add US2 (search) → checkpoint.
3. Add US3 (failures and Retry) → checkpoint.
4. Polish: full checks, diff review, device run.
