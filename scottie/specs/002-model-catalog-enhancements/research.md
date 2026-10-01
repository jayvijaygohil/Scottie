# Research: Model Catalog Enhancements

All Technical Context unknowns are resolved below. Sources: current `:app` source, the
`runanywhere-kotlin` skill, and `reference/` (read only; nothing is linked from it).

## R1. Deciding whether the device can run a model

- **Decision**: A model is Supported when the runtime accepted its registration on this device
  **and** its memory requirement fits the device's total RAM (or either value is unknown):
  `supported = id in accepted && (memoryBytes == null || totalMem == null || memoryBytes <= totalMem)`.
  The verdict is computed once in `ModelDownloadRepositoryImpl.load()` and stored on each
  `ModelEntry`.
- **Rationale**: `RunAnywhereModelRuntime.prepare()` already returns the accepted id set.
  For NPU rows, `QHexRT.registerModelForDevice()` returns null when the bundle does not match the
  device's Snapdragon/Hexagon part, so acceptance is the per-bundle hardware check the spec calls
  "supported Snapdragon device". Today non-accepted rows are filtered out; they will now be kept and
  marked Unsupported (FR-009).
- **Alternatives considered**: `QHexRT.probeNpu().supported` (used by the reference app's device
  card). Rejected as the gate: it only says *an* NPU exists, while bundles target specific Hexagon
  architectures; registration is the precise check and is already performed. Rows needing a
  Hugging Face token (`QHexRT.modelRequiresHfAuth`) remain non-accepted and therefore Unsupported;
  token entry is out of scope.
- **Known ceiling**: NPU re-registration can consult a remote policy, so offline launches may mark
  NPU rows Unsupported on a supported device. Already-downloaded rows still show Delete (FR-010).

## R2. Device memory

- **Decision**: Add `suspend fun totalMemoryBytes(): Long?` to the existing `ModelRuntime` seam;
  the SDK-backed implementation reads `ActivityManager.MemoryInfo.totalMem` (null on failure or 0).
- **Rationale**: Total RAM keeps badges stable (spec Assumptions). Putting it on the existing seam
  keeps the repository testable with `FakeModelRuntime` and avoids a second single-method
  abstraction.
- **Alternatives considered**: `/proc/meminfo` parsing (reference app) — more code, same value.
  `availMem` — fluctuates, rejected by spec.
- **Per-model requirement**: `memoryBytes` already exists on every `CatalogModel` subtype; promote
  it to the `CatalogModel` interface and carry it into the domain `Model`.

## R3. Human-readable titles

- **Decision**: Derive the display title in the data layer with a small sanitizer applied in
  `CatalogModel.toModel()`: strip quantization tags (`Q4_K_M`, `UD-Q4_K_XL`, `Q8_0`, `TQ1_0`,
  `Q1_0`), precision tags (`INT8`, `fp32`), runtime tags (`(HNPU…)`, `(CPU)`, `(ONNX)`,
  `(Sherpa-ONNX)`, `(heavy)`), then collapse whitespace and dangling separators. An explicit
  id→title override map covers rows the rules cannot fix (e.g.
  `sherpa-nemo-parakeet-tdt-ctc-0.6b-ja-int8`).
- **Rationale**: The catalog is kept in lockstep with other SDK example apps; editing 100+ name
  literals would break that. A rule plus a few overrides is short and is verified against every row
  by a unit test (no banned tokens, unique within category + hardware target, non-blank).
- **Alternatives considered**: Hand-editing all names (drift from upstream); a per-row title field
  (100+ edits).

## R4. Descriptions

- **Decision**: Curated, family-level English descriptions in a data-layer map keyed by model-id
  prefix (e.g. `qwen` → "General-purpose chat model from Alibaba; good quality for its size."),
  surfaced as nullable `Model.description`. Rows without a family entry show none (FR-005).
- **Rationale**: Neither the SDK catalog nor the reference app ships per-model descriptions. Family
  level gives useful coverage with ~20 strings instead of 100+. Descriptions are catalog data like
  model names, so they are not string resources.
- **Alternatives considered**: Per-row descriptions (high upkeep); string resources (data layer
  would need `Context`; names are already not localized).

## R5. Categories and order

- **Decision**: Primary category = `ModelType`, in enum declaration order (Text, Multimodal, Vision,
  Image Generation, Embedding, Speech Recognition, Speech Synthesis, Voice Activity Detection,
  Segmentation, Other), matching the spec. Hardware target = `NPU` for QHexRT rows, `CPU`
  otherwise. Existing `model_type_*` string resources are the section titles.
- **Rationale**: Enum order already matches the clarified order; no new mapping table.

## R6. Collapsible list structure

- **Decision**: One `LazyColumn` flattened into category-header, subsection-header, and model items.
  Headers render a new shared `ScottieAccordionHeader` (title, count, expanded, nesting level,
  `onToggle`) in `presentation/ui/components/`. Expansion state lives in the presenter.
- **Rationale**: ~115 rows with live progress need lazy composition. The vendored `XelaAccordion`
  owns its own `MutableState`, is not lazy, takes no `Modifier`, and renders its content twice when
  open, so it cannot be nested inside a `LazyColumn` or driven by presenter state.
- **Alternatives considered**: Nesting `XelaAccordion` (non-lazy, duplicate content); fixing
  `XelaAccordion` in place (vendored kit; still non-lazy).

## R7. Toolbar search and badges

- **Decision**: New shared `ScottieSearchField` (theme-colored `BasicTextField` with search and
  clear icons, `value`/`onValueChange`) in `ui/components/`. `ScottieToolbar` gains an optional
  trailing `search` slot rendered below the title row. Supported/Unsupported badges reuse the
  existing `XelaBadge` with theme colors (primary container / error container).
- **Rationale**: `XelaTextField` needs `MutableState<TextFieldValue>` and its own field state,
  which conflicts with presenter-owned query; its defaults are hard-coded light colors.
  `XelaBadge` already does the job, so no new badge component (FR-015 only requires missing ones).

## R8. Search matching

- **Decision**: Presenter filters on each `Search` action: case-insensitive, trimmed substring
  match over title, id, description, a category keyword (enum name, lowercase, `_`→space),
  hardware target (`cpu`/`npu`), and `supported`/`unsupported`.
- **Rationale**: Pure and JVM-testable; ~115 rows filter in well under 200 ms.
- **Known ceiling**: Category and status keywords are English; localized section titles would not
  match in other locales. Mark with a `ponytail:` comment; resolve labels via resources if the app
  is localized.

## R9. Gating

- **Decision**: `canStart = supported && !busy` in the presenter; the repository's `download()` also
  ignores unsupported ids. Delete stays enabled for downloaded rows regardless.
- **Rationale**: SC-001 needs zero downloads for Unsupported models even if the UI misfires.

## R10. NPU usability (FR-020)

- **Decision**: No new runtime work. The QHexRT backend is already registered in `prepare()`, and
  accepted NPU rows already download through the same path. Loading/inference remains a later
  feature (per 001).
