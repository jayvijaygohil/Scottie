# Data Model: Relocate Model Selection & Update Chat Header Actions

**Feature**: `011-relocate-model-selector`
**Date**: 2026-10-14

## 1. Presentation State & Action Models (`feature/interacbanking/presentation`)

### `InteracAssistantState`

| Field | Type | Description |
|---|---|---|
| `activeModelId` | `String?` | Currently selected text model ID (`null` when no local or remote text model is available). |
| `turns` | `List<AssistantTurn>` | Conversation turns in chronological order (oldest first); empty on launch and after `ClearChat`. |
| `input` | `String` | Current unsent text in the message composer; reset to `""` on `Send` or `ClearChat`. |
| `busy` | `Boolean` | `true` while inference or A2UI form submission is in progress. |
| `missingModel` | `Boolean` | `true` when `activeModelId == null`; renders the empty-state onboarding card. |
| `surfaces` | `List<A2uiSurfaceModel>` | Active A2UI surfaces owned by `A2uiBridge`; cleared when `ClearChat` deletes all surfaces. |
| `eventSink` | `(InteracAssistantAction) -> Unit` | Callback dispatching user actions to `InteracAssistantPresenter`. |

*(Note: `models: List<TextModelOption>` is removed from `InteracAssistantState` because the Chat screen no longer renders the model selector.)*

### `InteracAssistantAction`

| Action | Payload | Behavior |
|---|---|---|
| `InputChanged` | `text: String` | Updates `input` draft text. |
| `Send` | none (`data object`) | Trims `input`, appends a `Thinking` turn, and launches inference using `activeModelId` (ignored if blank, `busy`, or `activeModelId == null`). |
| `ClearChat` | none (`data object`) | When `!busy`, deletes all active A2UI surfaces from `bridge`, resets `turns = emptyList()`, `input = ""`, and clears `startedAt`. |
| `OpenSettings` | none (`data object`) | Navigates to `ModelDownloadScreen` (triggered by long-pressing the `'Scootie'` header logo or tapping the empty-state onboarding button). |

*(Note: `SelectModel` is removed from `InteracAssistantAction`.)*

---

## 2. Presentation State & Action Models (`feature/modeldownload/presentation`)

### `TextModelOption`

| Field | Type | Description |
|---|---|---|
| `id` | `String` | Model identifier (catalog ID for on-device text models; `openrouter:<id>` for remote models). |
| `name` | `String` | Display name shown in the model selector pill and dropdown menu. |
| `remote` | `Boolean` | `true` for OpenRouter models (renders the `Remote` badge); `false` for on-device models. |

### `ModelDownloadState` Additions

| Field | Type | Description |
|---|---|---|
| `models` | `List<TextModelOption>` | Available text models in selector order: downloaded `ModelType.TEXT` catalog models first, followed by saved OpenRouter model IDs marked `remote = true`. |
| `activeModelId` | `String?` | Currently active text model ID from `ModelDownloadRepository.activeTextModel`. |

### `ModelDownloadAction` Additions

| Action | Payload | Behavior |
|---|---|---|
| `SelectModel` | `modelId: String` | Calls `repository.selectTextModel(modelId)` to update and persist the active model in-place on the Settings screen without popping navigation. |
| `UseModel` | `modelId: String` | Existing card-level convenience action: calls `repository.selectTextModel(modelId)` and pops back to Chat. |

---

## 3. State Transitions

### Clear Chat / Context Transition (`InteracAssistantPresenter`)

```text
[Active Conversation: turns.isNotEmpty() || input.isNotBlank(), busy = false]
   │
   ├── User taps Clear Chat/Context button -> InteracAssistantAction.ClearChat
   │
   ▼
1. For each surface in bridge.surfaces (and each turn.surfaceId):
   bridge.accept(InteracSurfaceTemplates.deleteSurface(id))
2. turns = emptyList()
3. input = ""
4. startedAt.clear()
   │
   ▼
[Welcome State: turns = emptyList(), surfaces = emptyList(), input = "", busy = false]
```

### Active Model Selection Transition (`ModelDownloadPresenter`)

```text
[Settings Screen: models = localDownloadedText + remoteChecked, activeModelId = current]
   │
   ├── User opens ModelSelector dropdown and taps option -> ModelDownloadAction.SelectModel(newId)
   │
   ▼
1. repository.selectTextModel(newId) validates newId in localDownloadedText || remoteChecked
2. Updates stored StateFlow and writes newId to activeTextModelFile
3. Both ModelDownloadPresenter.activeModelId and InteracAssistantPresenter.activeModelId emit newId
```
