# Research: Speech-to-Text Voice Input for Chat Composer

**Feature**: `012-speech-to-text-input`
**Date**: 2026-10-15

## R1. Identifying & Persisting Audio-Capable OpenRouter Models

- **Decision**: Parse `architecture.input_modalities` in `OpenRouterModelsClient.Architecture` (`@SerialName("input_modalities") val inputModalities: List<String>? = null`) and set `AvailableModel.audioInput = inputModalities?.any { it.equals("audio", ignoreCase = true) } == true`. Persist the audio-capable subset of checked OpenRouter model IDs on `OpenRouterConfig` via `val audioModels: List<String> = emptyList()` (with `val audioModelIds: List<String> get() = audioModels.filter { it in models }.map(::remoteId)`), updated in `OpenRouterConfig.prunedTo(available)` and when toggling remote models in `ModelDownloadPresenter`.
- **Rationale**:
  - OpenRouter's `/api/v1/models` endpoint exposes `architecture.input_modalities` (e.g., `["text", "audio"]`).
  - Persisting `audioModels` with a default `emptyList()` in `OpenRouterConfig` preserves backward compatibility with existing `openrouter_config.json` files and ensures `ModelDownloadRepository.activeAudioModel` can validate a persisted remote audio model ID immediately on app launch (even on the Chat screen before Settings is opened or when offline).
- **Alternatives considered**:
  - *Keep `audioInput` only in transient UI state inside `ModelDownloadPresenter`*: Rejected because launching the app directly into the Chat screen would have no knowledge of which saved OpenRouter models support audio input without a network fetch, breaking persistence across app restarts.

## R2. Single Active Audio Model Selection & Fallback to `"None"`

- **Decision**: Add `val activeAudioModel: StateFlow<String?>` and `fun selectAudioModel(modelId: String?)` to `ModelDownloadRepository` (`ModelDownloadRepositoryImpl`), backed by `@Named("activeAudioModelFile") File(context.filesDir, "active_audio_model")`. Combine `catalog`, `storedAudio`, and `openRouter.config` so `activeAudioModel` emits `storedId?.takeIf { it in catalog.downloadedSpeechIds() || it in config?.audioModelIds.orEmpty() }`.
- **Rationale**:
  - Unlike `activeTextModel` (which auto-selects the first available model), the specification requires `"None"` (`null`) as the default when no audio model has been chosen and as the automatic fallback whenever the selected on-device speech model is deleted or the selected OpenRouter audio model is unchecked/removed.
  - Representing `"None"` as `null` in `activeAudioModel: StateFlow<String?>` and using the existing `openrouter:<id>` prefix convention guarantees that at most one audio model (either one Edge speech recognition model OR one Cloud OpenRouter model) is active at any time.
- **Alternatives considered**:
  - *Separate state flows for local vs. cloud audio models*: Rejected because a single `StateFlow<String?>` enforces mutual exclusion by construction and matches `activeTextModel`.

## R3. Whole-Clip Audio Capture & Immediate Hardware Release

- **Decision**: Define `AudioRecorder` in `feature/interacbanking/domain/repository/` with `suspend fun start()`, `suspend fun stop(): ByteArray`, and `fun cancel()`, implemented by `AndroidAudioRecorder` in `feature/interacbanking/data/ai/provider/` using Android `AudioRecord` (`MediaRecorder.AudioSource.MIC`, 16 kHz, `CHANNEL_IN_MONO`, `ENCODING_PCM_16BIT`). `stop()` stops the read loop, releases `AudioRecord` in `finally` before returning, and wraps the recorded PCM16 samples in a standard 44-byte RIFF/WAV header. `cancel()` stops and releases `AudioRecord` immediately and discards the buffer, invoked both on screen disposal (`DisposableEffect`) and when recording is cancelled.
- **Rationale**:
  - Both `RunAnywhere.stt.transcribe(AudioInput.wav(bytes))` and OpenRouter `/chat/completions` (`AttachmentSource.Audio` with `format = "wav"`) accept 16 kHz mono 16-bit PCM WAV bytes directly, avoiding temporary files on disk or duplicate audio encoders.
  - Releasing `AudioRecord` inside `stop()`'s `finally` block before `transcribe()` begins satisfies FR-012 and FR-013 (microphone hardware is released immediately when stopping or exiting the screen).
- **Alternatives considered**:
  - *`MediaRecorder` writing compressed AAC/M4A files to cache*: Rejected because `RunAnywhere.stt` (`AudioInput`) expects PCM16/Float32/WAV rather than AAC/MP4 containers, whereas 16 kHz mono WAV works identically for both Edge and Cloud.

## R4. Routing Speech-to-Text Transcription Across Edge (RunAnywhere) and Cloud (OpenRouter/Koog)

- **Decision**: Define `fun interface SpeechTranscriber` (`suspend fun transcribe(wavBytes: ByteArray, modelId: String): String`) in `feature/interacbanking/domain/agent/workflow/`. Implement routing in `di/InteracModule.kt` + `core/ai/`:
  - **Edge (`!modelId.startsWith(OpenRouterConfig.ID_PREFIX)`)**: Delegate to `OnDeviceSttModels` in `core/ai/`, which unloads any previously loaded speech model if different, calls `RunAnywhere.models.load(modelId)`, and calls `RunAnywhere.stt.transcribe(AudioInput.wav(wavBytes)).text`.
  - **Cloud (`modelId.startsWith(OpenRouterConfig.ID_PREFIX)`)**: Delegate to `OpenRouterTextModels` + the cached OpenRouter `PromptExecutor`, executing a Koog `prompt("stt")` that attaches `AttachmentSource.Audio(AttachmentContent.Binary.Bytes(wavBytes), format = "wav", mimeType = "audio/wav", fileName = "speech.wav")` with `LLMCapability.Audio` enabled on the `LLModel` and a verbatim plain-text transcription instruction. Classify exceptions via the existing `FailureClassifier` (`classifyInference`).
- **Rationale**:
  - Reuses the existing `RunAnywhere` ONNX/Sherpa runtime and the existing Koog `OpenRouterLLMClient` (`OpenAIContentPart.Audio` / `input_audio`) without adding any new dependencies or raw HTTP clients.
  - Reusing `InferenceException` and `InferenceFailure` (`OFFLINE`, `UNAUTHORIZED`, `MODEL_UNAVAILABLE`, `UNKNOWN`) provides consistent error messages across chat and voice transcription.
- **Alternatives considered**:
  - *Separate custom HTTP client for OpenRouter `/chat/completions` audio*: Rejected because Koog's `OpenRouterLLMClient` (via `AbstractOpenAILLMClient`) already serializes `AttachmentSource.Audio` into OpenAI/OpenRouter `input_audio` content parts.
