# Feature Specification: Model Catalog Enhancements

**Feature Branch**: `002-model-catalog-enhancements`

**Created**: 2026-10-01

**Status**: Draft

**Input**: User description: "Model downloading is functional. Refine the catalog UI/UX with
multi-level categorization (Text / Speech / Vision, each split into CPU Models and NPU Models in
nested collapsible sections), human-readable model titles and descriptions, hardware compatibility
badges (CPU vs. NPU, required vs. available RAM) that disable downloads for unsupported models with
an explanation, real-time search in the app toolbar across names, identifiers, descriptions,
categories, hardware targets, and support status, strict adherence to the app theme with missing
building blocks (badge, nested collapsible container, toolbar search) added as reusable design-system
components, and no runtime dependency on the temporary `reference/` folder."

## Clarifications

### Session 2026-10-01

- Q: Should model types outside Text, Speech, and Vision be merged into those three categories? → A: No. List one primary category per model type present in the catalog (e.g. Text, Multimodal, Image Generation, Embedding, Speech Recognition, Speech Synthesis, Voice Activity Detection, Segmentation) instead of merging.
- Q: Should NPU models be offered? → A: Yes. Users must be able to download and use NPU models on supported Snapdragon devices; on other devices they are listed but marked Unsupported.
- Q: Should Unsupported models explain the unmet requirement? → A: No. Show the Supported/Unsupported badge and disable download; no reason text.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Know before downloading whether a model will run (Priority: P1)

A user browsing the catalog sees, on every model, whether this device can run it. Models the device
cannot run are clearly marked Unsupported and their Download action is disabled. On supported
Snapdragon devices, NPU models are marked Supported and can be downloaded like any other model.

**Why this priority**: Downloads are large and slow; letting a user spend gigabytes on a model that
cannot run on their device is the most costly failure the catalog can cause.

**Independent Test**: On a device without a supported NPU and with known RAM, open the catalog and
confirm every NPU model and every model needing more memory than the device has is marked
Unsupported and cannot be downloaded, while all other models remain downloadable; then, on a
supported Snapdragon device, confirm NPU models are Supported and downloadable.

**Acceptance Scenarios**:

1. **Given** a model whose execution target and memory needs the device meets, **When** the catalog
   shows it, **Then** it carries a Supported badge and its Download action is enabled.
2. **Given** an NPU model on a supported Snapdragon device with enough memory, **When** the catalog
   shows it, **Then** it carries a Supported badge and can be downloaded.
3. **Given** an NPU model on a device without a compatible NPU, **When** the catalog shows it,
   **Then** it carries an Unsupported badge and Download is disabled.
4. **Given** a model needing more memory than the device has, **When** the catalog shows it, **Then**
   it carries an Unsupported badge and Download is disabled.
5. **Given** an Unsupported model, **When** it is shown, **Then** no reason text is displayed; the
   badge alone conveys the status.
6. **Given** an unsupported model that was already downloaded earlier, **When** the catalog shows it,
   **Then** it stays marked Unsupported and Delete remains available so the user can reclaim storage.

---

### User Story 2 - Browse the catalog by category and hardware (Priority: P2)

A user opens the catalog and sees one collapsible category per model type in the catalog (for
example Text, Multimodal, Image Generation, Embedding, Speech Recognition, Speech Synthesis, Voice
Activity Detection, Segmentation). Expanding a category reveals two collapsible subsections, CPU
Models and NPU Models, each listing its models.

**Why this priority**: The catalog holds dozens of models; grouping by what the model does and where
it runs makes it scannable. It builds on the compatibility information from P1.

**Independent Test**: Open the catalog, expand each category and subsection, and confirm every model
appears exactly once under the correct category and hardware subsection.

**Acceptance Scenarios**:

1. **Given** the catalog has loaded, **When** the user opens the screen, **Then** one category per
   model type present is shown, in the order of Assumptions, each collapsed or expanded per the
   default there.
2. **Given** a collapsed category, **When** the user taps its header, **Then** it expands to show its
   CPU Models and NPU Models subsections; tapping again collapses it.
3. **Given** a subsection, **When** the user taps its header, **Then** its model list expands or
   collapses independently of sibling subsections.
4. **Given** a category or subsection with no models, **When** the catalog is shown, **Then** that
   section is hidden rather than shown empty.
5. **Given** a section header, **When** it is shown, **Then** it displays how many models it contains.
6. **Given** a download is in progress in a section, **When** the user collapses that section,
   **Then** the download continues and its progress is visible again on expanding.

---

### User Story 3 - Understand what each model is (Priority: P2)

Each model shows a readable title instead of a raw technical identifier, and a short description of
what it does, its main use case, or its key trade-off.

**Why this priority**: Raw file slugs and quantization tags are unreadable to most users; clear names
and descriptions are needed to choose between models.

**Independent Test**: Open the catalog and confirm no title shows file extensions, quantization tags,
or hashes, and that models with a description show it.

**Acceptance Scenarios**:

1. **Given** a model with a technical identifier, **When** it is listed, **Then** its title is a
   human-readable name free of file extensions, quantization tags, and hashes, while still
   distinguishing it from sibling models (e.g. by size or variant).
2. **Given** a model with a description, **When** it is listed, **Then** a concise description of at
   most two lines is shown under the title.
3. **Given** a model with no description, **When** it is listed, **Then** no empty description space
   is shown.

---

### User Story 4 - Find a model by searching (Priority: P3)

A user types in a search field in the screen's toolbar and the catalog narrows as they type to models
whose title, technical identifier, description, category, hardware target, or support status matches.

**Why this priority**: Useful once the catalog is large and organized, but browsing (P2) already
makes every model reachable.

**Independent Test**: Type a query matching one model's identifier only, then a category name, then
"unsupported", and confirm each time only matching models remain.

**Acceptance Scenarios**:

1. **Given** the catalog, **When** the user types a query, **Then** the visible models update with
   each keystroke to those matching any searchable field, case-insensitively.
2. **Given** a search with matches, **When** results are shown, **Then** sections containing matches
   are expanded and sections without matches are hidden.
3. **Given** a search with no matches, **When** results are shown, **Then** an empty-results message
   is shown.
4. **Given** an active search, **When** the user clears it, **Then** the full catalog returns with the
   sections' previous expanded/collapsed state.
5. **Given** a download in progress, **When** the user searches, **Then** the download is unaffected
   and its row shows current progress whenever it is visible.

---

### Edge Cases

- The device's memory cannot be determined: models are not blocked on memory.
- NPU detection fails or is inconclusive: NPU models are treated as Unsupported.
- A model has no stated memory requirement: it is judged on execution target only.
- A model's type is not recognised: it is placed in an "Other" category so every model has exactly one
  home.
- Search text has leading/trailing spaces or mixed case: matching ignores both.
- The catalog fails to load: the existing error state is shown and search has nothing to filter.
- A download is active for a model whose support status would change (e.g. memory reading changes):
  the active download is never cancelled by the catalog; status is re-evaluated only for new actions.
- Only one download may run at a time (existing rule): a Supported model's Download stays disabled
  while another download is active, with the existing behavior unchanged.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The catalog MUST group models into one primary category per model type present in the
  catalog (no merging of types), shown in a fixed order, each as a collapsible section.
- **FR-002**: Each primary category MUST contain collapsible subsections CPU Models and NPU Models;
  every model MUST appear in exactly one category and one subsection.
- **FR-003**: Empty categories and subsections MUST be hidden; section headers MUST show their model
  count.
- **FR-004**: Every model MUST display a human-readable title without file extensions, quantization
  tags, or hashes, unique among models in its subsection.
- **FR-005**: Models with a description MUST show it (at most two lines); models without one MUST show
  none.
- **FR-006**: The catalog MUST determine, per model, whether the device meets its execution target
  (CPU or NPU) and its memory requirement.
- **FR-007**: Every model MUST show a Supported or Unsupported badge.
- **FR-008**: Unsupported models MUST have Download (and Resume/Retry) disabled; no unmet-requirement
  reason text is shown.
- **FR-009**: NPU models MUST be listed under NPU Models on every device. On supported Snapdragon
  devices they MUST be downloadable (subject to the memory check); elsewhere they are Unsupported.
  This replaces the previous behavior of hiding them.
- **FR-010**: Delete MUST remain available for downloaded models regardless of support status.
- **FR-011**: The screen toolbar MUST contain a search field that filters the catalog on every
  keystroke, case-insensitively and ignoring surrounding whitespace, across title, technical
  identifier, description, primary category, hardware target, and support status.
- **FR-012**: While a search is active, sections with matches MUST be expanded and sections without
  matches hidden; with no matches, an empty-results message MUST be shown; clearing the search MUST
  restore the full catalog and prior section states.
- **FR-013**: Searching, collapsing, and expanding MUST NOT interrupt or alter any download.
- **FR-014**: All new visual elements (badges, collapsible sections, search field, helper text) MUST
  use the application's theme and design tokens and support light and dark themes.
- **FR-015**: Badge, nested collapsible section, and toolbar search building blocks that do not
  already exist in the shared component library MUST be added there as reusable components before this
  screen uses them.
- **FR-016**: All new user-visible text, including category names and accessibility labels for badges
  and section toggles, MUST be localizable and use quantity-aware wording where
  counts appear.
- **FR-017**: The feature MUST NOT depend at build or run time on the `reference/` folder.
- **FR-018**: Categorization, compatibility evaluation, title/description display, and search
  filtering MUST be covered by automated tests that need no real device hardware or network.
- **FR-019**: Existing download behavior (progress, pause, resume, retry, delete, single active
  download, background continuation) MUST be unchanged.
- **FR-020**: A downloaded NPU model MUST be usable by the app on supported Snapdragon devices like
  any other downloaded model; the runtime's NPU support MUST be enabled where the device supports it.

### Key Entities

- **Catalog model**: An offered model with technical identifier, display title, optional description,
  primary category (its model type), hardware target (CPU or NPU), required memory (may be
  unknown), download size, and download status.
- **Device capabilities**: The device's total memory (may be unknown) and whether it is a supported
  Snapdragon device with a compatible NPU.
- **Compatibility**: Per-model verdict — Supported or Unsupported.
- **Catalog section**: A primary category containing hardware subsections, each with its models and an
  expanded/collapsed state.
- **Search query**: The current toolbar text; empty means no filtering.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: 0 downloads can be started for models marked Unsupported.
- **SC-002**: On a supported Snapdragon device, 100% of NPU models within the device's memory are
  marked Supported and can be downloaded.
- **SC-003**: A user can locate any named model in under 10 seconds, by browsing or by searching.
- **SC-004**: Search results update within 200 ms of each keystroke on a catalog of at least 100
  models.
- **SC-005**: 0 model titles display file extensions, quantization tags, or hashes.
- **SC-006**: Every catalog model appears in exactly one category/subsection, verified by automated
  tests.
- **SC-007**: All existing download acceptance scenarios from feature 001 still pass.

## Assumptions

- Category order: Text, Multimodal, Vision, Image Generation, Embedding, Speech Recognition, Speech
  Synthesis, Voice Activity Detection, Segmentation, Other; categories with no models are hidden.
- Hardware target is CPU for all non-NPU runtimes (GPU-accelerated rows included under CPU Models);
  NPU for NPU-specific bundles.
- "Available RAM" means the device's total physical memory, not momentary free memory, so badges stay
  stable between sessions; required memory comes from each model's catalog metadata.
- "Supported Snapdragon device" is decided by the runtime's own NPU support check (the one that
  currently filters NPU rows); it is evaluated once per catalog load.
- Default section state: all primary categories expanded; within each, the CPU Models subsection is
  expanded and NPU Models is collapsed on devices without a compatible NPU (expanded otherwise).
  Section state is kept while the screen is open and is not persisted across app restarts.
- Titles and descriptions are curated in the app's fixed catalog; models lacking a curated title
  fall back to an automatically cleaned identifier.
- The toolbar search is only shown on the model download screen.
- `reference/` may inform names, descriptions, and patterns, but anything needed is copied into the
  app; the folder will be deleted after verification.
- Device-level (instrumented) tests are not required; behavior is verified with simulated device
  capabilities.
