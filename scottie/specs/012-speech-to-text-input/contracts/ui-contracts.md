# UI & Presentation Contracts: Speech-to-Text Voice Input for Chat Composer

**Feature**: `012-speech-to-text-input`
**Date**: 2026-10-15

## 1. Settings Screen Audio Model Selector Contract (`feature/modeldownload/presentation`)

### Test Tags & Semantics

| Constant | Value | Element | Behavior |
|---|---|---|---|
| `TAG_MODEL_SELECTOR` | `"chat_model_selector"` | Active Text model selector pill on `ModelDownloadUi` | Existing selector for `state.models` / `state.activeModelId`. |
| `TAG_AUDIO_MODEL_SELECTOR` | `"audio_model_selector"` | Active Speech-to-Text (Audio) model selector pill on `ModelDownloadUi` | Always enabled (lists `"None"` plus `state.audioModels`). Displays active audio model name or `stringResource(R.string.audio_model_none)` when `state.activeAudioModelId == null`, plus `Remote` badge when the active audio model is an OpenRouter model. Content description: `stringResource(R.string.audio_model_selector, activeAudioName)`. |
| `TAG_AUDIO_MODEL_OPTION` | `"audio_model_option"` | `DropdownMenuItem` for `"None"` and each `TextModelOption` in the Audio dropdown | First item is `"None"` (`id = null`), followed by downloaded `SPEECH_RECOGNITION` models, followed by saved audio-capable OpenRouter models (`Remote` badge). Selecting an item triggers `HapticFeedbackType.SegmentTick` and dispatches `ModelDownloadAction.SelectAudioModel(optionId)`. |

### Downloaded Speech Recognition Model Cards (`ModelSections.kt`)

- Downloaded `ModelType.SPEECH_RECOGNITION` cards pass `onUse = { onEvent(ModelDownloadAction.UseModel(model.id)) }` to `ModelDownloadUiItem`, exposing the `"Use in chat"` button alongside `ModelType.TEXT` cards.
- In `ModelDownloadPresenter`, `UseModel(modelId)` checks the model's `ModelType`: if `SPEECH_RECOGNITION`, it calls `repository.selectAudioModel(modelId)` and `navigator.pop()`.

---

## 2. Chat Screen Composer & Voice Input Contract (`feature/interacbanking/presentation`)

### Test Tags & Semantics

| Constant | Value | Element | Behavior |
|---|---|---|---|
| `TAG_RECORD` | `"chat_record"` | Microphone / Stop / Transcribing button in `Composer` (`ChatComponents.kt`) | Hidden when `state.activeAudioModelId == null`. Visible next to `TAG_SEND` when `state.activeAudioModelId != null`. Enabled when `!state.busy && state.voiceState != VoiceState.Transcribing`. When `Idle`, shows microphone icon (`contentDescription = stringResource(R.string.chat_record_voice)`). When `Recording`, shows stop icon (`contentDescription = stringResource(R.string.chat_stop_recording)`). When `Transcribing`, shows a progress indicator (`contentDescription = stringResource(R.string.chat_transcribing)`). |
| `TAG_SEND` | `"chat_send"` | Send `FilledIconButton` in `Composer` | Enabled only when `!state.busy && state.voiceState == VoiceState.Idle && state.input.isNotBlank()`. |
| `TAG_CLEAR_CHAT` | `"chat_clear"` | Clear Chat `IconButton` in `ScottieToolbar` | Enabled only when `!state.busy && state.voiceState == VoiceState.Idle && (state.turns.isNotEmpty() || state.input.isNotBlank())`. |
| `TAG_VOICE_ERROR` | `"chat_voice_error"` | Dismissible `ScottieToast` overlay on `InteracAssistantUi` | Rendered when `state.voiceError != null`; action button dispatches `InteracAssistantAction.DismissVoiceError`. |

### String Resources (`res/values/strings.xml`)

| Resource Name | Value | Usage |
|---|---|---|
| `audio_model_none` | `None` | Label for no active audio model in the Audio model selector. |
| `audio_model_selector` | `Choose speech model, current: %1$s` | Accessibility `contentDescription` for the Audio model selector pill. |
| `model_selector_text_label` | `Text` | Short label/prefix distinguishing the Text model selector. |
| `model_selector_audio_label` | `Audio` | Short label/prefix distinguishing the Speech-to-Text (Audio) model selector. |
| `chat_record_voice` | `Record voice input` | Accessibility `contentDescription` for the microphone button when `Idle`. |
| `chat_stop_recording` | `Stop recording` | Accessibility `contentDescription` for the microphone button when `Recording`. |
| `chat_transcribing` | `Transcribing voice input` | Accessibility `contentDescription` for the microphone button when `Transcribing`. |
| `chat_mic_permission_denied` | `Microphone permission is required for voice input.` | Error toast message when `RECORD_AUDIO` permission is denied. |
| `chat_voice_failed` | `Couldn\'t transcribe audio. Please try again.` | Error toast message when transcription fails with `InferenceFailure.UNKNOWN`. |
