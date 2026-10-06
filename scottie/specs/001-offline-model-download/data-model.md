# Data Model: Offline Model Download

Domain types live in `feature/modeldownload/domain/entities/` and import no Android, Compose, or SDK types.

## Model

| Field | Type | Notes |
|-------|------|-------|
| `id` | `String` | Unique catalog id; equals the SDK registration id. |
| `name` | `String` | Display name from the catalog. |
| `type` | `ModelType` | Drives the row's short description. |
| `downloadBytes` | `Long?` | Download size; null when unknown. |

Validation: ids unique across the catalog (catalog unit test).

## ModelType

`TEXT`, `MULTIMODAL`, `VISION`, `IMAGE_GENERATION`, `EMBEDDING`, `SPEECH_RECOGNITION`,
`SPEECH_SYNTHESIS`, `VOICE_ACTIVITY`, `SEGMENTATION`, `OTHER`. Mapped from the SDK `ModelCategory`
in `data/`.

## DownloadProgress

| Field | Type | Notes |
|-------|------|-------|
| `bytesDone` | `Long` | ≥ 0. |
| `bytesTotal` | `Long` | 0 when unknown. |
| `fraction` | `Float?` | 0..1; null → indeterminate. |
| `phase` | `DownloadPhase` | `TRANSFERRING`, `VERIFYING`, `EXTRACTING`. |

Verifying/extracting carry the last byte counts forward with `fraction = 1f`.

## ModelDownloadStatus (sealed)

| Variant | Payload | Row actions |
|---------|---------|-------------|
| `Available` | — | Download (disabled while another download is active) |
| `Downloading` | `progress: DownloadProgress` | Pause |
| `Paused` | `bytesKept: Long` | Resume |
| `Failed` | `reason: DownloadFailure`, `bytesKept: Long` | Retry |
| `Downloaded` | — | Delete |

## DownloadFailure

`NETWORK`, `STORAGE`, `CORRUPTED`, `BACKGROUND_REFUSED`, `UNKNOWN` (see research R4 for mapping).

## ModelCatalog (sealed)

| Variant | Payload |
|---------|---------|
| `Loading` | — |
| `Ready` | `entries: List<ModelEntry>` in catalog order |
| `Unavailable` | — (runtime failed to initialize) |

`ModelEntry(model: Model, status: ModelDownloadStatus)`.

## State transitions

```text
Available  --download-->  Downloading
Downloading --progress--> Downloading (progress updated)
Downloading --Completed--> Downloaded
Downloading --pause / Failed(CANCELLED) / flow ends without Completed--> Paused
Downloading --Failed(other) / unexpected exception--> Failed
Available  --foreground start refused--> Failed(BACKGROUND_REFUSED)
Paused     --resume--> Downloading
Failed     --retry--> Downloading
Downloaded --delete ok--> Available
Downloaded --delete error--> Downloaded (+ one-shot delete error)
```

Invariants:

- At most one entry is `Downloading` (FR-012); `download` while another is active is ignored.
- `Downloaded` only after `Completed` or the SDK reports the model on disk (FR-009).
- `pause` on a non-downloading id is a no-op.
