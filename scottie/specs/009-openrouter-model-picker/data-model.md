# Data Model: OpenRouter Model Picker

All types live in `feature/modeldownload/domain/entities/` unless noted.

## OpenRouterConfig (changed meaning, same shape)

| Field | Type | Rule |
|-------|------|------|
| baseUrl | String | http/https with host (unchanged validation) |
| apiKey | String | may be empty; never in `toString`, logs, or error text |
| models | List<String> | **The Model Selection**: checked OpenRouter ids, in fetched-list order; may be empty |

- The persisted JSON is unchanged, so 008 files load as-is (FR-011).
- `remoteId()` / `modelIds` are unchanged; chat keeps using them.

## OpenRouterDraft (changed)

- `modelsText` removed. `validate()` checks only the base URL and returns
  `OpenRouterConfig(url, key, models = <current selection>)`; the caller passes the current
  selection.
- `OpenRouterField.MODELS` removed; `BASE_URL` remains.

## AvailableModel (new)

| Field | Type | Rule |
|-------|------|------|
| id | String | non-blank; unique within one fetch |
| name | String | service name, or `id` when missing |

Not persisted. A list is sorted by `name` (case-insensitive), then `id`.

## ModelsFetch (new, result of one fetch)

```text
ModelsFetch
├── Loaded(models: List<AvailableModel>)   // may be empty → "no models available"
└── Failed(reason: FetchFailure)           // NO_CONNECTION | AUTH | OTHER
```

## Repository contract (changed)

`OpenRouterConfigRepository` gains:

- `suspend fun fetchAvailableModels(): ModelsFetch`: uses the saved config and returns
  `Failed(OTHER)` if none is saved. On `Loaded` it also saves the config with `models` pruned to
  listed ids in fetched order (FR-010). On `Failed` it changes nothing (FR-009).

## Presentation state (in `presentation/ModelDownloadScreen.kt`)

`OpenRouterSection` drops `modelsText` and adds:

| Field | Type | Meaning |
|-------|------|---------|
| list | `RemoteModels` | `Hidden` (nothing saved) / `Loading` / `Loaded(visible, selected)` / `Failed(reason)` |
| query | String | in-card search text |

`savedModelCount` stays as the header count (number checked). `expanded` defaults to `false`.

New actions under `ModelDownloadAction.OpenRouter`: `ToggleRemoteModel(id)`,
`SearchRemoteModels(query)`, `RetryRemoteModels`. `EditOpenRouterModels` is removed.

## State transitions

```text
Hidden ──Save valid──▶ Loading ──ok──▶ Loaded ──toggle/search──▶ Loaded
   ▲                     │  ▲                │
   │                     │  └──Retry/Save────┤
   │                     └──error──▶ Failed ─┘
   └──────────── Delete (from any state) ────
Settings opens with saved config ─▶ Loading
```
