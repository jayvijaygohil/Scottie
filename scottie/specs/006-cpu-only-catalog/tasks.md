---

description: "Task list for CPU-Only Model Catalog"
---

# Tasks: CPU-Only Model Catalog

**Input**: Design documents from `/specs/006-cpu-only-catalog/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, quickstart.md

**Tests**: FR-008 requires updating `ModelCatalogTest` and deleting `DeviceChipTest`. No new
test files are added.

**Organization**: Grouped by user story. US1 and US2 share one file (`ModelCatalog.kt`), so a
single catalog rewrite covers both.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (e.g., US1, US2, US3)

## Path Conventions

Paths are relative to the repository root.
- `PROVIDER` = `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/data/ai/provider`
- `PROVIDER_TEST` = `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/data/ai/provider`

## Phase 1: Setup

None. No new dependencies or structure are needed.

## Phase 2: Foundational

None. Every story edits existing files.

---

## Phase 3: User Story 1 + 2 - Same CPU builds on every device; one build per model (P1/P2) 🎯 MVP

**Goal**: Each text model is one fixed general (CPU) build, the same on every device, with no
chip-specific entries.

**Independent Test**: Run `./gradlew :app:testDebugUnitTest --tests '*ModelCatalogTest'`. It
passes, and every LiteRT URL is a general build.

### Implementation

- [X] T001 [US1] In `PROVIDER/ModelCatalog.kt`:
  - Delete `LiteRtBuild` and `LiteRtSpec`, including `resolve(soc)` and the `npu` maps.
  - Change the private `hf(...)` helper to
    `hf(name: String, repo: String, commit: String, file: String, sizeBytes: Long, requiresToken: Boolean = false): LiteRtModel`.
    It returns `LiteRtModel(id = file, name, url = "https://huggingface.co/litert-community/$repo/resolve/$commit/$file", downloadBytes = sizeBytes, memoryBytes = (sizeBytes * 13) / 10, requiresToken)`.
  - Keep the `// ponytail: heuristic until LiteRT publishes RAM needs` comment.
  - Rewrite `litert` as `List<LiteRtModel>` with exactly the ten rows from
    `specs/006-cpu-only-catalog/data-model.md`, in order. Use each spec's existing `general`
    repo, commit, file, and size.
  - Set `requiresToken = true` only for Gemma 3 1B, Gemma 3 270M, and FunctionGemma 270M.
  - Inline or delete the `GEMMA4_E2B`, `GEMMA3_1B`, `GEMMA3_270M`, and `FUNCTION_GEMMA`
    repo/SHA constants. Each is now used once.
  - Update the `LiteRtModel` KDoc to "A LiteRT general (CPU) build. [id] is the local file name
    and the Koog `LLModel.id`."
- [X] T002 [US1] In `PROVIDER/ModelCatalog.kt`, replace `fun forDevice(soc: String?)` with
  `val models: List<CatalogModel> = litert + stt`. Declare `models` after `litert` and `stt`, or
  make it a `get()`, so initialization order is safe. KDoc: "LiteRT text rows, then the
  speech-to-text rows."
- [X] T003 [US1] In `app/src/main/java/com/jayvijay/scottie/di/DataModule.kt`, change
  `provideModelCatalog()` to return `StaticModelCatalog.models` and delete the `socModel`
  import. Depends on T002.

### Tests

- [X] T004 [US1] In `PROVIDER_TEST/ModelCatalogTest.kt`:
  - Replace `liteRt(soc)` with
    `private val liteRt = StaticModelCatalog.models.filterIsInstance<LiteRtModel>()`.
  - Delete `urlOf`, `SOCS`, and the tests `gemma4E2bResolvesToTheChipBuild`,
    `gemma3ResolvesPerQualcommChip`, and `npuBuildsOnlyForEligibleChips`.
  - Replace every `SOCS` loop and `forDevice(...)` call with the single
    `StaticModelCatalog.models` list.
  - Rename `buildSizesAndMemoryFollowTheResolvedBuild` to `sizesAndMemoryAreTheGeneralBuild`.
    Assert Gemma 4 E2B `downloadBytes == 2_588_147_712` and
    `memoryBytes == downloadBytes * 13 / 10`.
  - Add `urlsNameNoChip`: no LiteRT URL matches
    `Regex("""qualcomm|sm\d{4}|Tensor_G""", RegexOption.IGNORE_CASE)`.
  - Drop the now-unused imports.
  - Depends on T001 and T002.

**Checkpoint**: The catalog is CPU-only and constant. US1 and US2 are done.

---

## Phase 4: User Story 3 - No chip detection runs (P3)

**Goal**: No chip or board identification, and no NPU runtime library declaration.

**Independent Test**: The quickstart §1 grep returns nothing, and the merged manifest has no
`uses-native-library`.

- [X] T005 [US3] Delete `PROVIDER/DeviceChip.kt`. Depends on T003, its only caller.
- [X] T006 [P] [US3] Delete `PROVIDER_TEST/DeviceChipTest.kt`.
- [X] T007 [P] [US3] In `app/src/main/AndroidManifest.xml`, remove the
  `<uses-native-library android:name="libedgetpu_litert.so" android:required="false" />` element
  and the XML comment above it about the Google Tensor NPU dispatch library.
- [X] T008 [P] [US3] Delete the unreferenced asset `app/src/main/assets/model_allow_lists.json`
  (FR-006). If `app/src/main/assets/` is then empty, delete the folder too.

**Checkpoint**: All stories are complete.

---

## Phase 5: Polish & Verification

- [X] T009 Run quickstart §1 from the repository root:
  `grep -rnE 'LiteRtSpec|LiteRtBuild|forDevice|NPU_ELIGIBLE|socModel|chipOf|libedgetpu|model_allow_lists' app/src`.
  It must print nothing. Fix any hits.
- [X] T010 Run
  `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug` and fix any
  failures, including detekt unused-member and line-length warnings in `ModelCatalog.kt`.
- [X] T011 Inspect `git diff --stat`. Only the files in plan.md's Source Code tree should
  change.

---

## Dependencies & Execution Order

- T001 → T002 → T003 → T005
- T004 needs T001 and T002.
- T006, T007, and T008 are independent of everything else.
- T009, T010, and T011 run last.

### Parallel Opportunities

- T006, T007, and T008 can run alongside T001 through T004.

```text
Batch A: T001 → T002 → T003 → T004 → T005
Batch B (parallel with A): T006, T007, T008
Then: T009 → T010 → T011
```

## Implementation Strategy

MVP is Phase 3 (T001–T004). It alone makes every device download CPU builds. Phase 4 removes the
dead code and declarations. Do everything in one pass: there are 11 small tasks and the work is
deletion-only.
