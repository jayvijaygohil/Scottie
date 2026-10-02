# Contracts: Model Download (internal)

## `ModelDownloadRepository`

| Member | Contract |
|---|---|
| `catalog` | Lists only the rows the runtime accepted. `supported = checkCompatibility(memoryNeed, downloadBytes, availableMemory, availableStorage) is Compatible`, probed once per load. |
| `suspend download(id): DownloadStart` | Returns `Ignored` when another download is active, the id is unknown, the model `requiresToken`, or the status is not Available, Paused, or Failed. Otherwise it probes again and returns `Refused(shortfall)` with the status unchanged when the check fails. Otherwise it starts the download as in 001 and returns `Started`. |
| `pause(id)`, `delete(id)` | Unchanged. |

## `checkCompatibility` (domain, pure)

| memory need | available memory | download bytes | free storage | Result |
|---|---|---|---|---|
| null or ≤ 0 | any | null or ≤ 0 | any | `Compatible` |
| 3.2 GB | null or ≤ 0 | 2 GB | null | `Compatible` |
| 3.2 GB | 2.1 GB | any | any | `Shortfall(MEMORY, 3.2 GB, 2.1 GB)` |
| 1 GB | 2 GB | 2.6 GB | 1.4 GB | `Shortfall(STORAGE, 2.6 GB, 1.4 GB)` |
| 1 GB | 1 GB | 1 GB | 1 GB | `Compatible` (the comparison is `≥`) |

## `ModelRuntime` (`totalMemoryBytes` removed)

| Member | `RoutingModelRuntime` | `LiteRtModelRuntime` | `RunAnywhereModelRuntime` |
|---|---|---|---|
| `prepare(rows)` | Splits rows by type and unions the accepted ids | Accepts every `LiteRtModel` and creates `models/litert/` | Sherpa rows only |
| `downloadedIds()` | Union of both | Ids whose final file exists | Unchanged |
| `download(id)` | Routes by owner | Range-resumed GET, then size check, then rename | Unchanged |
| `delete(id)` | Routes by owner | Deletes the final and `.part` files | Unchanged |

## `LiteRtModelRuntime.download(id)` events

1. Emits `Progress` as bytes arrive. `bytesDone` includes bytes from earlier attempts.
2. Emits `Completed` only after the size matches and the rename succeeds.
3. Emits `Failed(CORRUPTED)` on a size mismatch, after deleting `.part`. Emits `Failed(STORAGE)` when
   a write fails for lack of space (ENOSPC). Emits `Failed(NETWORK)` for other I/O or an HTTP status
   other than 200 or 206.
4. Collector cancellation keeps `.part`, and the repository maps it to `Paused`.
5. Makes no network call other than the GET to the row's `url`.

## `DeviceResources`

- `availableMemoryBytes(): Long?` and `availableStorageBytes(): Long?` return null when unknown.
- Both are called on `Dispatchers.IO`.

## Chip identity

- `socModel(): String?` uses the normalized `SOC_MODEL` on API 31+, falls back to
  `BOARD_PLATFORMS[Build.BOARD]`, and is otherwise null.
- `LiteRtSpec.resolve(soc)` uses an NPU build only when `soc in NPU_ELIGIBLE`.

## Shortfall message

The presenter maps `Refused(Shortfall)` to `error = Shortfall(...)`. The UI shows the toast with
`model_download_shortfall_memory` or `model_download_shortfall_storage`, with both amounts formatted
by `Formatter.formatShortFileSize`.
