# Data Model: Chat Window as Home Screen

Only additions and changes; feature 005 banking entities are unchanged.

## modeldownload (owner of model state)

### `ModelDownloadRepository` (domain/repository) — additions

| Member | Type | Rule |
|---|---|---|
| `activeTextModel` | `StateFlow<String?>` | Stored id if that entry is `TEXT` and `Downloaded`; else first such entry in catalog order; else null. Recomputed whenever `catalog` or the stored id changes. |
| `selectTextModel(id)` | `fun(String)` | Persists `id` (SharedPreferences key `active_text_model`). Ignored unless `id` is a downloaded text model. |

Persistence: one string in the app's private `SharedPreferences`, written in
`ModelDownloadRepositoryImpl`. A deleted model is not cleared from storage; resolution simply skips
it, so re-downloading restores the choice.

## interacbanking (consumer)

### `TextModelOption` (domain/entities)

| Field | Type | Notes |
|---|---|---|
| `id` | `String` | `.litertlm` file name; passed to `IntentExtractor.extract`. |
| `name` | `String` | Catalog display name. |

### `TextModelSource` (domain/repository)

| Member | Type | Notes |
|---|---|---|
| `models` | `Flow<List<TextModelOption>>` | Downloaded text models, catalog order. |
| `active` | `Flow<String?>` | Active id; null → empty state. |
| `select(id)` | `fun(String)` | Delegates to `ModelDownloadRepository.selectTextModel`. |

Implemented as an object in `di/InteracModule` mapping `ModelDownloadRepository.catalog`
(filter `type == TEXT && status == Downloaded`) and `activeTextModel`.

### `InteracAssistantScreen` (presentation) — changed

`data class InteracAssistantScreen(modelId)` → `data object InteracAssistantScreen` (root, no
arguments).

### `InteracAssistantState` (presentation) — changed

| Field | Change |
|---|---|
| `modelName: String` | removed → `models: List<TextModelOption>`, `activeModelId: String?` |
| `missingModel: Boolean` | now `activeModelId == null` (derived in presenter; field kept) |
| others | unchanged (`turns`, `input`, `busy`, `surfaces`, `eventSink`) |

### `AssistantTurn` / `TurnReply` — unchanged

`TurnReply.Text` is revealed progressively by the UI; the reveal is not state (re-running it on
recreation is harmless and is skipped once completed via a `rememberSaveable` flag per turn id).

### `InteracAssistantAction` — changed

| Action | Change | Presenter behaviour |
|---|---|---|
| `Back` | removed | — (root; system back exits) |
| `InputChanged(text)` | unchanged | also used by welcome example chips |
| `Send` | unchanged | uses the active model id; no-op when null or busy |
| `SelectModel(id)` | new | ignored while `busy`; `TextModelSource.select(id)` |
| `OpenSettings` | new | `navigator.goTo(settingsDestination.screen())` |

### State transitions

```text
activeModelId == null ──(model downloaded)──▶ ready ──(last model deleted)──▶ activeModelId == null
ready: idle ──Send──▶ busy (Thinking) ──reply──▶ idle (Text revealed | Surface | Fallback)
busy blocks Send and SelectModel
```

## modeldownload presentation — changed

| Item | Change |
|---|---|
| `ModelDownloadAction.UseModel(id)` | `repository.selectTextModel(id)` then `navigator.pop()` |
| `TextModelDestination` | deleted (and its `di` provider) |
