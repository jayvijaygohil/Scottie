# Data Model: Model Catalog Enhancements

Changes are additive to `domain/entities/ModelDownload.kt` and the presentation contract.

## Domain (`domain/entities/`)

### Model (changed)

| Field | Type | Notes |
|---|---|---|
| id | String | Technical identifier; searchable. Unchanged. |
| name | String | Now the sanitized display title (R3). Non-blank. |
| type | ModelType | Primary category. Unchanged. |
| downloadBytes | Long? | Unchanged. |
| **description** | String? | New. Null → no description shown. |
| **target** | HardwareTarget | New. `NPU` for QHexRT rows, else `CPU`. |
| **memoryBytes** | Long? | New. Required RAM; null when unknown. |

### HardwareTarget (new enum)

`CPU`, `NPU`.

### ModelEntry (changed)

| Field | Type | Notes |
|---|---|---|
| model | Model | |
| status | ModelDownloadStatus | Unchanged. |
| **supported** | Boolean | New. Fixed per catalog load (R1). |

Validation: `supported == false` ⇒ repository ignores `download(id)`; `Downloaded` +
unsupported still allows `delete(id)`.

`ModelCatalog`, `ModelDownloadStatus`, `DownloadProgress` are unchanged.

## Data (`data/ai/provider/`)

- `CatalogModel` interface gains `memoryBytes: Long` (already on all subtypes).
- `ModelRuntime` gains `suspend fun totalMemoryBytes(): Long?`.
- `CatalogModel.toModel()` fills `name` via the title sanitizer, `description` via the family map,
  `target` from `framework`, `memoryBytes` from the row (≤ 0 → null).

## Presentation (`features/modeldownload/`)

### ModelDownloadModel (changed)

Adds `description: String?`, `target: HardwareTarget`, `supported: Boolean`.
`canStart = supported && no active download`.

### ModelDownloadContent.Models (changed)

`Models(sections: List<ModelSection>, query: String)`; empty `sections` with non-blank `query` ⇒
empty-results message.

### ModelSection (new)

| Field | Type | Notes |
|---|---|---|
| type | ModelType | Category; title from `model_type_*` resources. |
| count | Int | Models in this category after filtering. |
| expanded | Boolean | Effective state (forced true while searching with matches). |
| groups | List\<ModelGroup\> | Non-empty groups only, CPU before NPU. |

### ModelGroup (new)

| Field | Type | Notes |
|---|---|---|
| target | HardwareTarget | Subsection. |
| models | List\<ModelDownloadModel\> | Catalog order. Count = `models.size`. |
| expanded | Boolean | Effective state. |

### Presenter-retained state

- `query: String` (default "").
- `expansion: Map<SectionKey, Boolean>` — user overrides only. Defaults: category expanded; CPU
  group expanded; NPU group expanded iff any NPU entry is supported.
- While `query.isNotBlank()`, effective `expanded = true` for every shown section; overrides are kept
  untouched so clearing restores them (FR-012).

`SectionKey` = `ModelType` for categories, `ModelType` + `HardwareTarget` for groups.

## State transitions

Download status transitions are unchanged from 001. New transitions are UI-only:

- Search(query) → recompute sections; no repository call.
- ToggleSection(key) → flip override; ignored while searching.
