---

description: "Task list for Model Catalog Enhancements"
---

# Tasks: Model Catalog Enhancements

**Input**: Design documents from `/specs/002-model-catalog-enhancements/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/model-catalog-contracts.md

**Tests**: Required by FR-018 (JVM tests with fakes; no device hardware or network). Test tasks
precede implementation within each story.

**Organization**: Tasks are grouped by user story so each can be implemented and tested
independently.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: US1–US4 from spec.md

## Path Conventions

Single-module Android app. Main source: `app/src/main/java/com/jayvijay/scottie/`. Host tests:
`app/src/test/java/com/jayvijay/scottie/`. Resources: `app/src/main/res/`.

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Resources every story uses

- [X] T001 [P] Add vector drawables `ic_search.xml`, `ic_close.xml`, `ic_chevron_down.xml` in app/src/main/res/drawable/
- [X] T002 [P] Add strings `model_download_search_placeholder`, `model_download_search_clear`, `model_download_search_empty`, `model_target_cpu` ("CPU Models"), `model_target_npu` ("NPU Models"), `model_support_supported`, `model_support_unsupported`, `model_section_expanded`, `model_section_collapsed`, and plural `model_section_count` in app/src/main/res/values/strings.xml

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Domain and data fields all stories read

**⚠️ CRITICAL**: No user story work can begin until this phase is complete

- [X] T003 Add `enum class HardwareTarget { CPU, NPU }`; add to `Model` the fields `description: String?` ("Null → no description shown"), `target: HardwareTarget` ("NPU for QHexRT rows, else CPU"), `memoryBytes: Long?` ("Required RAM; null when unknown"); add `supported: Boolean` to `ModelEntry` in app/src/main/java/com/jayvijay/scottie/domain/entities/ModelDownload.kt
- [X] T004 Promote `memoryBytes: Long` to the `CatalogModel` interface and make `CatalogModel.toModel()` set `target` from `framework` (QHexRT → NPU) and `memoryBytes` (≤ 0 → null), `description = null` for now, in app/src/main/java/com/jayvijay/scottie/data/ai/provider/ModelCatalog.kt
- [X] T005 Add `description: String?`, `target: HardwareTarget`, `supported: Boolean` to `ModelDownloadModel` in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadScreen.kt, map them in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadPresenter.kt, and update previews in ModelDownloadUi.kt
- [X] T006 Construct `ModelEntry(..., supported = true)` temporarily in app/src/main/java/com/jayvijay/scottie/data/repository/ModelDownloadRepositoryImpl.kt and update test fakes/fixtures in app/src/test/java/com/jayvijay/scottie/presentation/features/modeldownload/FakeModelDownloadRepository.kt and ModelDownloadPresenterTest.kt so `./gradlew :app:testDebugUnitTest` compiles and passes

**Checkpoint**: Build and existing 001 tests green; behavior unchanged

---

## Phase 3: User Story 1 - Know before downloading whether a model will run (Priority: P1) 🎯 MVP

**Goal**: Every row shows Supported/Unsupported; Unsupported rows cannot be downloaded; NPU rows are
listed and downloadable on supported Snapdragon devices.

**Independent Test**: With fake runtime accepting a subset and a fixed total RAM, unsupported rows are
listed, badged Unsupported, and `download()` is a no-op for them; others download as before.

### Tests for User Story 1

- [X] T007 [P] [US1] Add `totalMemory: Long?` knob to app/src/test/java/com/jayvijay/scottie/data/ai/provider/FakeModelRuntime.kt
- [X] T008 [US1] Repository tests in app/src/test/java/com/jayvijay/scottie/data/repository/ModelDownloadRepositoryImplTest.kt: non-accepted row listed with `supported = false`; row with `memoryBytes > totalMem` unsupported; unknown total RAM does not block; `download()` on unsupported id leaves status `Available` and never calls runtime; downloaded unsupported row still deletes
- [X] T009 [P] [US1] Presenter tests in app/src/test/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadPresenterTest.kt: unsupported entry → `supported = false`, `canStart = false`; supported entry with no active download → `canStart = true`

### Implementation for User Story 1

- [X] T010 [US1] Add `suspend fun totalMemoryBytes(): Long?` to app/src/main/java/com/jayvijay/scottie/data/ai/provider/ModelRuntime.kt and implement via `ActivityManager.MemoryInfo.totalMem` (null on failure or 0) in RunAnywhereModelRuntime.kt
- [X] T011 [US1] In app/src/main/java/com/jayvijay/scottie/data/repository/ModelDownloadRepositoryImpl.kt `load()`: keep all rows, set `supported = id in accepted && (memoryBytes == null || totalMem == null || memoryBytes <= totalMem)`; make `download()` ignore unsupported ids; leave `delete()` ungated (FR-010); update the repository KDoc in domain/repository/ModelDownloadRepository.kt
- [X] T012 [US1] Set `canStart = supported && !busy` in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadPresenter.kt
- [X] T013 [US1] Render the support badge with `XelaBadge` using theme colors (primary/error containers) and `contentDescription`-friendly text, no reason text, and disable Download/Resume/Retry when unsupported while keeping Delete, in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/component/ModelDownloadCard.kt; add Supported/Unsupported previews (light + dark)

**Checkpoint**: US1 tests pass; NPU rows appear (flat list) with correct badges

---

## Phase 4: User Story 2 - Browse the catalog by category and hardware (Priority: P2)

**Goal**: Collapsible category (per `ModelType`) → CPU/NPU subsection → models, with counts and
sensible defaults.

**Independent Test**: Presenter emits sections in enum order, hides empty ones, counts match, NPU
groups collapsed when no NPU row is supported, toggles flip state without touching downloads.

### Tests for User Story 2

- [X] T014 [US2] Presenter tests in app/src/test/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadPresenterTest.kt: sections in `ModelType` order, empty categories/groups hidden, CPU before NPU, counts; default expansion (NPU group collapsed iff no supported NPU entry); `ToggleCategory`/`ToggleGroup` flip state; toggling during a download leaves its status/progress unchanged

### Implementation for User Story 2

- [X] T015 [P] [US2] Create `ScottieAccordionHeader(title, count, expanded, onToggle, modifier, level = 0)` with chevron rotation, theme typography/colors, `Modifier` on root, `stateDescription` + plural count for accessibility, and light/dark previews in app/src/main/java/com/jayvijay/scottie/presentation/ui/components/ScottieAccordionHeader.kt
- [X] T016 [US2] Add `ModelSection`, `ModelGroup`, change `ModelDownloadContent.Models` to `Models(sections, query)`, and add `ToggleCategory(type)` / `ToggleGroup(type, target)` actions in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadScreen.kt
- [X] T017 [US2] In app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadPresenter.kt retain expansion overrides (`rememberRetained`), group entries into sections via a pure function, apply defaults, and handle toggle actions
- [X] T018 [US2] Render a single flattened `LazyColumn` (category header items, group header items, model items with stable keys) using `ScottieAccordionHeader` and `model_type_*` / `model_target_*` titles in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadUi.kt; update previews

**Checkpoint**: US1 + US2 work together; downloads continue when sections collapse

---

## Phase 5: User Story 3 - Understand what each model is (Priority: P2)

**Goal**: Readable titles and family descriptions.

**Independent Test**: Catalog test over every row proves titles are clean, non-blank, unique per
type + target; descriptions appear only where mapped.

### Tests for User Story 3

- [X] T019 [P] [US3] Catalog tests in app/src/test/java/com/jayvijay/scottie/data/ai/provider/ModelCatalogTest.kt: every `toModel().name` non-blank, free of `Q\d`, `UD-`, `TQ1_0`, `INT8`, `fp32`, `HNPU`, `Sherpa`, `ONNX`, `(CPU)`, `(heavy)`, file extensions and hashes; unique within (`type`, `target`); every row maps to exactly one type and target; sample rows get expected descriptions and an unmapped id gets null

### Implementation for User Story 3

- [X] T020 [US3] Create title sanitizer (tag-stripping rules + id→title overrides) and family description map keyed by id prefix in app/src/main/java/com/jayvijay/scottie/data/ai/provider/ModelPresentation.kt; source wording may be informed by reference/ but must be copied in, not linked
- [X] T021 [US3] Use them in `CatalogModel.toModel()` for `name` and `description` in app/src/main/java/com/jayvijay/scottie/data/ai/provider/ModelCatalog.kt
- [X] T022 [US3] Show the description (max 2 lines, ellipsis) under the title and omit the space when null, replacing the type label line, in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/component/ModelDownloadCard.kt and its call site in ModelDownloadUi.kt

**Checkpoint**: Titles/descriptions visible across all sections

---

## Phase 6: User Story 4 - Find a model by searching (Priority: P3)

**Goal**: Toolbar search filters live across title, id, description, category, target, status.

**Independent Test**: Presenter tests for each searchable field, trimming/case, forced expansion,
empty results, and restore-on-clear.

**Depends on**: US2 (sections)

### Tests for User Story 4

- [X] T023 [US4] Presenter tests in app/src/test/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadPresenterTest.kt: match by id-only, description, category keyword, `npu`, `unsupported`; `"  QWEN "` matches; matched sections forced expanded and unmatched hidden; no match → empty `sections` with query; clearing restores prior overrides; search during download leaves status unchanged

### Implementation for User Story 4

- [X] T024 [P] [US4] Create `ScottieSearchField(value, onValueChange, placeholder, clearLabel, modifier)` on `BasicTextField` with search/clear icons, theme colors and typography, single line, IME search action, and light/dark previews in app/src/main/java/com/jayvijay/scottie/presentation/ui/components/ScottieSearchField.kt
- [X] T025 [P] [US4] Add optional `search: (@Composable () -> Unit)? = null` slot rendered below the title row to app/src/main/java/com/jayvijay/scottie/presentation/ui/components/ScottieToolbar.kt with a preview
- [X] T026 [US4] Add `Search(query)` action in ModelDownloadScreen.kt; in ModelDownloadPresenter.kt retain query, filter with trimmed case-insensitive substring over title, id, description, category keyword (enum name lowercased, `_`→space), `cpu`/`npu`, `supported`/`unsupported`, force-expand while searching, ignore toggles while searching; add `// ponytail: English keywords only…` ceiling comment (both in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/)
- [X] T027 [US4] Wire `ScottieSearchField` into the toolbar slot and render `model_download_search_empty` when filtered sections are empty in app/src/main/java/com/jayvijay/scottie/presentation/features/modeldownload/ModelDownloadUi.kt; add a search preview

**Checkpoint**: All stories functional

---

## Phase 7: Polish & Cross-Cutting Concerns

- [X] T028 Confirm no source references `reference/` (`grep -rn "reference/" app/src/main` returns nothing relevant) (FR-017)
- [X] T029 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug` and fix findings
- [ ] T030 Run quickstart.md manual checks on a device if available (dark mode, 2× font, supported/unsupported NPU device); otherwise report the instrumented/device skip per constitution IV
- [X] T031 Inspect final diff for scope; update CLAUDE.md "Current state" if `ModelDownloadScreen` description changed materially

---

## Dependencies & Execution Order

### Phase Dependencies

- Setup (Phase 1) → Foundational (Phase 2) → user stories.
- US1 (P1) and US3 (P2) are independent after Phase 2.
- US2 (P2) is independent after Phase 2 but shares ModelDownloadPresenter/Ui/Screen files with US1;
  run sequentially after US1 to avoid conflicts.
- US4 (P3) depends on US2 sections.
- Polish after all desired stories.

### Within Each Story

Tests first (expect failures), then data → presenter → UI.

### Parallel Opportunities

- T001 ‖ T002.
- US1: T007 ‖ T009.
- US3 (T019–T021) can run in parallel with US1/US2 (different files) until T022 touches the card.
- US2: T015 ‖ T016.
- US4: T024 ‖ T025.

## Parallel Example: User Story 4

```text
Task: "Create ScottieSearchField in presentation/ui/components/ScottieSearchField.kt"
Task: "Add search slot to presentation/ui/components/ScottieToolbar.kt"
```

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Phases 1–2.
2. Phase 3 (US1): gating + badges, NPU rows listed.
3. **Stop and validate**: run US1 tests; check badges on device.

### Incremental Delivery

US1 → US2 (structure) → US3 (titles/descriptions) → US4 (search) → Polish. Each step keeps 001
download tests green.
