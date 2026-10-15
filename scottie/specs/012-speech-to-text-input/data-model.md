# Data Model: Speech-to-Text Voice Input for Chat Composer

**Feature**: `012-speech-to-text-input`
**Date**: 2026-10-15

## 1. Domain & Data Models (`feature/modeldownload`)

### `AvailableModel` (`feature/modeldownload/domain/entities/OpenRouterConfig.kt`)

| Field | Type | Description |
|---|---|---|
| `id` | `String` | OpenRouter model identifier (e.g., `"openai/gpt-4o-audio-preview"`). |
| `name` | `String` | Display name from OpenRouter (falls back to `id`). |
| `audioInput` | `Boolean` | `true` when OpenRouter's `architecture.input_modalities` includes `"audio"` (case-insensitive); defaults to `false`. |

### `OpenRouterConfig` (`feature/modeldownload/domain/entities/OpenRouterConfig.kt`)

| Field | Type | Description |
|---|---|---|
| `baseUrl` | `String` | Saved OpenRouter-compatible API root URL. |
| `apiKey` | `String` | Saved API key. |
| `models` | `List<String>` | Checked OpenRouter model IDs in fetched-list order. |
| `audioModels` | `List<String>` | Subset of `models` that support audio input, persisted so audio capability is known across app restarts before refetching; defaults to `emptyList()`. |
| `modelIds` | `List<String>` | Computed: `models.map(::remoteId)`. |
| `audioModelIds` | `List<String>` | Computed: `audioModels.filter { it in models }.map(::remoteId)`. |

### `ModelDownloadRepository` Additions (`feature/modeldownload/domain/repository/ModelDownloadRepository.kt`)

| Member | Signature | Behavior |
|---|---|---|
| `activeAudioModel` | `val activeAudioModel: StateFlow<String?>` | Stored audio model ID if it is a downloaded `SPEECH_RECOGNITION` model or in `openRouter.config.value?.audioModelIds`; otherwise `null` (`"None"`). |
| `selectAudioModel` | `fun selectAudioModel(modelId: String?)` | When `modelId == null`, clears the active audio model and deletes `active_audio_model`. When non-null, validates that `modelId` is a downloaded `SPEECH_RECOGNITION` model or a saved OpenRouter audio model ID, updates state, and writes `active_audio_model`. |

---

## 2. Presentation State & Action Models (`feature/modeldownload/presentation`)

### `ModelDownloadState` Additions (`ModelDownloadScreen.kt`)

| Field | Type | Description |
|---|---|---|
| `models` | `List<TextModelOption>` | Available text models (downloaded `TEXT` models, then saved OpenRouter models). |
| `activeModelId` | `String?` | Currently active text model ID. |
| `audioModels` | `List<TextModelOption>` | Available audio models: downloaded `SPEECH_RECOGNITION` models in catalog order, followed by saved audio-capable OpenRouter models (`remote = true`). `"None"` is rendered as the leading option in the Audio `ModelSelector`. |
| `activeAudioModelId` | `String?` | Currently active audio model ID (`null` when `"None"` is active). |

### `ModelDownloadAction` Additions (`ModelDownloadScreen.kt`)

| Action | Payload | Behavior |
|---|---|---|
| `SelectAudioModel` | `modelId: String?` | Calls `repository.selectAudioModel(modelId)` (`null` selects `"None"`). |
| `UseModel` | `modelId: String` | For a downloaded `TEXT` model, calls `repository.selectTextModel(modelId)` and pops to Chat; for a downloaded `SPEECH_RECOGNITION` model, calls `repository.selectAudioModel(modelId)` and pops to Chat. |

---

## 3. Domain & Presentation Models (`feature/interacbanking`)

### `TextModelSource` (`feature/interacbanking/domain/repository/TextModelSource.kt`)

| Member | Type | Description |
|---|---|---|
| `active` | `Flow<String?>` | Currently active text model ID (`null` when none available). |
| `activeAudio` | `Flow<String?>` | Currently active audio model ID (`null` when `"None"` is selected); defaults to `emptyFlow()` or `flowOf(null)` for existing test fakes. |

### `AudioRecorder` (`feature/interacbanking/domain/repository/AudioRecorder.kt`)

| Method | Signature | Description |
|---|---|---|
| `start` | `suspend fun start()` | Begins capturing 16 kHz mono PCM16 microphone audio. Throws on hardware initialization failure. |
| `stop` | `suspend fun stop(): ByteArray` | Stops capture, immediately releases the microphone hardware, and returns the recorded clip as a 16 kHz mono 16-bit PCM WAV `ByteArray`. |
| `cancel` | `fun cancel()` | Immediately stops capture, discards any buffered audio, and releases the microphone hardware. Safe to call when idle. |

### `SpeechTranscriber` (`feature/interacbanking/domain/agent/workflow/SpeechTranscriber.kt`)

| Method | Signature | Description |
|---|---|---|
| `transcribe` | `suspend fun transcribe(wavBytes: ByteArray, modelId: String): String` | Transcribes `wavBytes` using the active `modelId` (on-device `RunAnywhere.stt` or remote OpenRouter audio model) and returns plain text, or throws `InferenceException`. |

### `VoiceState` & `VoiceError` (`feature/interacbanking/presentation/InteracAssistantContract.kt`)

```kotlin
enum class VoiceState {
  Idle,
  Recording,
  Transcribing,
}

sealed interface VoiceError {
  data object PermissionDenied : VoiceError
  data class Failed(val failure: InferenceFailure) : VoiceError
}
```

### `InteracAssistantState` Additions (`InteracAssistantContract.kt`)

| Field | Type | Description |
|---|---|---|
| `activeAudioModelId` | `String?` | Active speech-to-text model ID (`null` hides the composer microphone button). |
| `voiceState` | `VoiceState` | Current voice input state (`Idle`, `Recording`, or `Transcribing`). |
| `voiceError` | `VoiceError?` | Dismissible voice input error notice (`PermissionDenied` or `Failed(InferenceFailure)`). |

### `InteracAssistantAction` Additions (`InteracAssistantContract.kt`)

| Action | Payload | Behavior |
|---|---|---|
| `ToggleRecording` | none (`data object`) | When `Idle` (and `!busy` and `activeAudioModelId != null`), starts recording (`VoiceState.Recording`). When `Recording`, stops recording, releases mic, enters `VoiceState.Transcribing`, transcribes via `SpeechTranscriber`, and appends non-blank text to `input` (or surfaces `VoiceError.Failed`). |
| `CancelRecording` | none (`data object`) | Stops and discards any active recording via `recorder.cancel()` and returns `voiceState` to `Idle`. |
| `MicrophonePermissionDenied` | none (`data object`) | Records runtime microphone permission denial by setting `voiceError = VoiceError.PermissionDenied` without starting recording. |
| `DismissVoiceError` | none (`data object`) | Clears `voiceError = null`. |

---

## 4. State Transitions

### Voice Recording & Transcription State Machine (`InteracAssistantPresenter`)

```text
[Idle: voiceState = Idle, activeAudioModelId != null, busy = false]
   │
   ├── User taps Record without RECORD_AUDIO permission & denies dialog
   │      └── InteracAssistantAction.MicrophonePermissionDenied
   │          -> voiceState = Idle, voiceError = PermissionDenied (input preserved)
   │
   ├── User taps Record with RECORD_AUDIO permission
   │      └── InteracAssistantAction.ToggleRecording
   │          -> recorder.start()
   │          -> [Recording: voiceState = Recording, Send & ClearChat disabled]
   │                │
   │                ├── Screen exited / disposed or CancelRecording
   │                │      └── recorder.cancel() (mic released, clip discarded)
   │                │          -> [Idle]
   │                │
   │                └── User taps Stop (ToggleRecording)
   │                       └── wavBytes = recorder.stop() (mic released immediately)
   │                       └── [Transcribing: voiceState = Transcribing, Record/Send/ClearChat disabled]
   │                              │
   │                              ├── transcriber.transcribe(wavBytes, modelId) succeeds:
   │                              │      ├── non-blank transcript -> append to input (with single space if needed), voiceState = Idle
   │                              │      └── blank/silent transcript -> input unchanged, voiceState = Idle
   │                              │
   │                              └── transcriber.transcribe(wavBytes, modelId) fails:
   │                                     └── input preserved, voiceError = Failed(failure), voiceState = Idle
```
