# UI & Presentation Contracts: Relocate Model Selection & Update Chat Header Actions

**Feature**: `011-relocate-model-selector`
**Date**: 2026-10-14

## 1. Chat Screen Header Contract (`feature/interacbanking/presentation`)

### Test Tags & Semantics

| Constant | Value | Element | Gesture / Behavior |
|---|---|---|---|
| `TAG_LOGO` | `"chat_logo"` | `'Scootie'` brand logo row in `ScottieToolbar` `titleContent` | Single tap: no-op. Long-press: `HapticFeedbackType.LongPress` + `InteracAssistantAction.OpenSettings`. Accessibility `onLongClickLabel = stringResource(R.string.chat_settings)`. |
| `TAG_CLEAR_CHAT` | `"chat_clear"` | Clear Chat/Context `IconButton` in `ScottieToolbar` `actions` | Enabled when `!state.busy && (state.turns.isNotEmpty() || state.input.isNotBlank())`. Click dispatches `InteracAssistantAction.ClearChat`. Content description: `stringResource(R.string.chat_clear)`. |

*(Removed from Chat screen: `TAG_SETTINGS` and `ModelSelector`.)*

### String Resources (`res/values/strings.xml`)

| Resource Name | Value | Usage |
|---|---|---|
| `chat_header_logo` | `Scootie` | Brand logo text rendered in the Chat screen header. |
| `chat_clear` | `Clear chat` | Accessibility `contentDescription` for the Clear Chat/Context button. |
| `chat_settings` | `Model settings` | Accessibility `onLongClickLabel` on the `'Scootie'` header logo. |

---

## 2. Settings Screen Model Selector Contract (`feature/modeldownload/presentation`)

### Test Tags & Semantics

| Constant | Value | Element | Behavior |
|---|---|---|---|
| `TAG_MODEL_SELECTOR` | `"chat_model_selector"` | Active model selector pill on `ModelDownloadUi` | Enabled when `state.models.isNotEmpty()`. Shows active model name (or `stringResource(R.string.chat_empty_title)` when `activeModelId == null`), `Remote` badge when `activeModel.remote == true`, and opens dropdown menu on click. Content description: `stringResource(R.string.chat_model_selector, activeName)`. |
| `TAG_MODEL_OPTION` | `"chat_model_option"` | `DropdownMenuItem` for each `TextModelOption` | Displays `model.name`, optional `Remote` badge, and trailing check icon when `model.id == state.activeModelId`. Clicking a non-active option triggers `HapticFeedbackType.SegmentTick` and dispatches `ModelDownloadAction.SelectModel(model.id)`. |

---

## 3. Cross-Feature Seam (`feature/interacbanking/domain/repository/TextModelSource.kt`)

```kotlin
fun interface TextModelSource {
  /** Currently chosen text model id, or null when no text model is available. */
  val active: Flow<String?>
}
```
