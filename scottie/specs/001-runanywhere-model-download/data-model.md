# Data Model: On-Device Model Downloads

Domain types live in `domain/entities/` and carry no SDK types. See [research.md](research.md)
R6–R9 for how they map from the SDK.

## EdgeModel

A downloadable on-device model.

| Field | Type | Rule |
|-------|------|------|
| `id` | `String` | Unique, non-blank; the SDK model id |
| `name` | `String` | Display name |
| `description` | `String` | May be blank; the UI substitutes a fallback string |
| `sizeBytes` | `Long?` | Download size; null when unknown (SDK reports 0) |
| `isDownloaded` | `Boolean` | True when the model's files are on the device |

The list order is the SDK order, which is stable.

## ModelDownloadStatus

Per-model state, owned by the repository for the app's lifetime and the single source of truth
for changes made this session. Models without an entry are idle, and their listed `isDownloaded`
decides between Available and Downloaded.

```text
Downloading(progress: DownloadProgress)
Paused(progress: DownloadProgress)
Downloaded
Failed(reason: DownloadFailure)
```

`DownloadProgress`: `fraction: Float?` (0..1, null = unknown), `bytesDone: Long?`,
`bytesTotal: Long?` (both null for multi-file models or while verifying/extracting).

`DownloadFailure`: `NoConnection | InsufficientStorage | AccessRequired | Unknown`.

## Transitions

```text
Available ──download──▶ Downloading ──completed──▶ Downloaded
                         │   ▲  │
                   pause │   │resume
                         ▼   │  └──failed──▶ Failed ──retry──▶ Downloading
                        Paused
Downloading/Paused/Downloaded ──delete──▶ Available
```

- Download, Resume, and Retry all start a new collection of the SDK flow. Partial bytes are reused.
- Completed sets the entry to `Downloaded` in one atomic update, so no intermediate Available is
  ever shown.
- Pause waits for the job to finish cancelling, then sets `Paused`, so a late progress event cannot
  overwrite it.
- Delete waits for any job to finish cancelling, deletes the files, then removes the entry. The
  holder sets `isDownloaded = false` on its listed copy.
- Status and job maps are safe to change from any thread (`MutableStateFlow.update`,
  `ConcurrentHashMap`).
- Starting a download for a model that already has an active job is a no-op.
- After process death, all status entries are gone, so models read as Available or Downloaded
  from disk.
