# Data Model: Text and Speech-to-Text Catalog

## Domain

### `feature/modeldownload/domain/entities/ModelDownload.kt`

- `ModelType`: `TEXT`, `SPEECH_RECOGNITION`. Every other value is removed.
- `Model`: drops `target` and adds `requiresToken: Boolean`, which is true when the source needs a
  Hugging Face account token. `memoryBytes` and `downloadBytes` describe the resolved build and may
  be null when unknown.
- `HardwareTarget`: removed.
- `ModelEntry.supported`: true when `checkCompatibility(...)` returned `Compatible` at catalog load
  (FR-013).
- `ModelCatalog`, `ModelDownloadStatus`, `DownloadProgress`, `DownloadFailure`: unchanged.

### `feature/modeldownload/domain/entities/ModelCompatibility.kt` (new)

```text
enum ShortfallKind            MEMORY, STORAGE
sealed Compatibility
├── Compatible
└── Shortfall                 kind, requiredBytes: Long, availableBytes: Long

checkCompatibility(memoryNeed: Long?, downloadBytes: Long?,
                   availableMemory: Long?, availableStorage: Long?): Compatibility
```

- **Rule** (copied from `model_compatibility.cpp`): a check passes when the requirement is
  unknown (`null` or ≤ 0), the available value is unknown (`null` or ≤ 0), or
  `available ≥ required`. No headroom is added.
- **Order**: memory is checked first, then storage. The first failure is returned.

### `feature/modeldownload/domain/repository/ModelDownloadRepository.kt`

```text
sealed DownloadStart
├── Started
├── Ignored                   another download active, unknown id, requiresToken, or status not startable
└── Refused(shortfall)        start-time compatibility failed; status unchanged

suspend fun download(modelId): DownloadStart
```

## Data

### `feature/modeldownload/data/ai/provider/ModelCatalog.kt`

```text
CatalogModel (sealed)          id, name, memoryBytes, downloadBytes, type: ModelType
├── LiteRtModel                url, requiresToken; id == fileName == Koog LLModel.id   ← resolved row
├── ArchiveModel               + framework, category, archiveType, structure  (Sherpa)
└── MultiFileModel             + framework, category, files                   (Sherpa)

LiteRtSpec                     name, fileName, requiresToken, general: LiteRtBuild?, npu: Map<String, LiteRtBuild>
LiteRtBuild                    url, sizeBytes, memoryBytes
```

- **Resolution**: `LiteRtSpec.resolve(soc)` returns the build `npu[soc]` when `soc in NPU_ELIGIBLE`,
  otherwise `general`. That build becomes a `LiteRtModel`, or the result is null when there is no
  build. `StaticModelCatalog.forDevice(soc)` returns the resolved LiteRT rows followed by the STT
  rows.
- **Invariants**:
  - `fileName` is unique, ends in `.litertlm`, and is the same for every build of a spec.
  - NPU keys are a subset of `NPU_ELIGIBLE`.
  - `SingleFileModel` is removed.
- **Local layout**: `<filesDir>/models/litert/<fileName>` is the complete file and `.part` the
  partial one. A row counts as downloaded only when the complete file exists.

### `feature/modeldownload/data/ai/provider/DeviceChip.kt`

- `NPU_ELIGIBLE = {"SM8650", "SM8750", "SM8850", "TENSOR_G5", "TENSOR_G6"}`.
- `BOARD_PLATFORMS = {"SUN" → "SM8750", "PINEAPPLE" → "SM8650"}`.
- `socModel()` returns the normalized `Build.SOC_MODEL` on API 31+, else `BOARD_PLATFORMS[Build.BOARD]`,
  else null.

### `feature/modeldownload/data/ai/provider/DeviceResources.kt`

- `availableMemoryBytes(): Long?` tries `availMem`, then `MemAvailable` × 1024, then returns null.
- `availableStorageBytes(): Long?` returns `StatFs(filesDir).availableBytes`, or null on error.

## Presentation

- `ModelSection`: `type`, `count`, `expanded`, `models`. `ModelGroup` is removed.
- `ModelDownloadModel`: drops `target`. `canStart = supported && !requiresToken && !busy`.
- `ModelDownloadState.error: ModelDownloadError?` replaces `deleteFailedModelName`.
  `ModelDownloadError` is either `DeleteFailed(name)` or
  `Shortfall(kind, requiredBytes, availableBytes)`.
- `ModelDownloadAction`: drops `ToggleGroup`. `DismissError` clears `error`.
- Sections appear in Text, Speech order, both expanded by default; empty sections are hidden.

## State transitions

These are unchanged from 001, except:
- `Available`, `Paused`, or `Failed` stay as they are when `download` returns `Refused`; the screen
  only shows the toast.
- For LiteRT, cancelling moves `Downloading` to `Paused(bytesKept = .part length)`.
- For LiteRT, the rename moves `Downloading` to `Downloaded`.
- For LiteRT, delete removes both files.
