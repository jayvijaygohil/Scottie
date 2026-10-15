# Tasks: Speech-to-Text Voice Input for Chat Composer

**Input**: Design documents from `/scottie/specs/012-speech-to-text-input/`

**Prerequisites**: [plan.md](plan.md), [spec.md](spec.md), [research.md](research.md),
[data-model.md](data-model.md), [contracts/ui-contracts.md](contracts/ui-contracts.md),
[quickstart.md](quickstart.md)

**Tests**: Included per Constitution Principle IV (Verified Changes: unit tests for repositories,
clients, and presenters using fakes, plus Compose UI tests for screen actions).

**Organization**: Tasks are grouped by user story (`US1`–`US4`) so each increment can be implemented
and verified independently.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies on incomplete tasks)
- **[Story]**: `[US1]`, `[US2]`, `[US3]`, `[US4]` from [spec.md](spec.md)

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Add localized string resources and persistence file provider needed across Settings and
Chat voice input.

- [X] T001 [P] Add string resources `audio_model_none` (`None`), `audio_model_selector` (`Choose speech model, current: %1$s`), `model_selector_text_label` (`Text`), `model_selector_audio_label` (`Audio`), `chat_record_voice` (`Record voice input`), `chat_stop_recording` (`Stop recording`), `chat_transcribing` (`Transcribing voice input`), `chat_mic_permission_denied` (`Microphone permission is required for voice input.`), and `chat_voice_failed` (`Couldn\'t transcribe audio. Please try again.`) in `app/src/main/res/values/strings.xml`
- [X] T002 [P] Provide `@Named("activeAudioModelFile") fun activeAudioModelFile(@ApplicationContext context: Context): File = File(context.filesDir, "active_audio_model")` in `app/src/main/java/com/jayvijay/scottie/di/DataModule.kt`

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Define cross-feature and domain contracts for active audio model state, whole-clip audio
recording, and speech-to-text transcription before user story implementation.

**⚠️ CRITICAL**: Complete this phase before starting User Stories 1–4.

- [X] T003 [P] Add `val activeAudio: Flow<String?>` (defaulting to `emptyFlow()` so existing single-expression `TextModelSource` fakes stay source-compatible) to `TextModelSource` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/repository/TextModelSource.kt`
- [X] T004 [P] Create `AudioRecorder` domain interface with `suspend fun start()`, `suspend fun stop(): ByteArray` (returns 16 kHz mono 16-bit PCM WAV bytes after immediately releasing microphone hardware), and `fun cancel()` (immediately stops capture, discards buffered audio, and releases microphone hardware) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/repository/AudioRecorder.kt`
- [X] T005 [P] Create `fun interface SpeechTranscriber { suspend fun transcribe(wavBytes: ByteArray, modelId: String): String }` domain contract in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/agent/workflow/SpeechTranscriber.kt`

**Checkpoint**: Foundational contracts ready.

---

## Phase 3: User Story 1 - Select and Persist an Active Speech-to-Text Model in Settings (Priority: P1) 🎯 MVP

**Goal**: Users can select and persist a single active Speech-to-Text (Audio) model on the Model
Settings screen from `"None"` (default), downloaded on-device speech recognition models, and saved
audio-capable OpenRouter models (badged `Remote`), or tap `"Use in chat"` on a downloaded speech
model card, with automatic fallback to `"None"` if the chosen model is deleted or unselected.

**Independent Test**: Open Model Settings with downloaded speech models and saved OpenRouter models
(both audio-capable and text-only), verify the Audio selector defaults to `"None"` and lists only
`"None"`, downloaded speech models, and audio-capable OpenRouter models (`Remote`), switch models or
tap `"Use in chat"` on a speech card, and verify persistence and fallback to `"None"` on deletion.

### Implementation & Tests for User Story 1

- [X] T006 [P] [US1] Add `val audioInput: Boolean = false` (`true` when `architecture.input_modalities` includes `"audio"` case-insensitively) to `AvailableModel`, add `val audioModels: List<String> = emptyList()` and computed `val audioModelIds: List<String> get() = audioModels.filter { it in models }.map(::remoteId)` to `OpenRouterConfig`, and update `OpenRouterConfig.prunedTo(available: List<AvailableModel>)` to retain `audioModels = available.filter { it.id in selected && it.audioInput }.map { it.id }` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfig.kt`
- [X] T007 [US1] Update `OpenRouterModelsClient.Architecture` with `@SerialName("input_modalities") val inputModalities: List<String>? = null` and set `AvailableModel.audioInput = entry.architecture?.inputModalities?.any { it.equals("audio", ignoreCase = true) } == true` in `toAvailable` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/data/remote/OpenRouterModelsClient.kt`
- [X] T008 [US1] Add `val activeAudioModel: StateFlow<String?>` and `fun selectAudioModel(modelId: String?)` to `ModelDownloadRepository` and implement them in `ModelDownloadRepositoryImpl` using `@Named("activeAudioModelFile") private val activeAudioFile: File` (`activeAudioModel` emits stored ID only when `it in catalog.downloadedSpeechIds() || it in config?.audioModelIds.orEmpty()`, else `null`; `selectAudioModel(null)` clears state and deletes `activeAudioFile`) in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/domain/repository/ModelDownloadRepository.kt` and `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`
- [X] T009 [US1] Add `val audioModels: List<TextModelOption> = emptyList()` and `val activeAudioModelId: String? = null` to `ModelDownloadState`, plus `data class SelectAudioModel(val modelId: String?) : ModelDownloadAction` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadScreen.kt`
- [X] T010 [US1] Update `ModelDownloadPresenter` to collect `repository.activeAudioModel`, build `audioModels` (downloaded `ModelType.SPEECH_RECOGNITION` models in catalog order, followed by saved audio-capable OpenRouter models `savedConfig.audioModels.filter { it in savedConfig.models }` with `OpenRouterConfig.remoteId(it)` and `remote = true`), handle `ModelDownloadAction.SelectAudioModel(id)` via `repository.selectAudioModel(id)`, route `ModelDownloadAction.UseModel(id)` to `repository.selectAudioModel(id)` when the model is `ModelType.SPEECH_RECOGNITION` (and `selectTextModel(id)` when `TEXT`) before `navigator.pop()`, and update `ToggleRemoteModel` to persist `audioModels` via `prunedTo(models)` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadPresenter.kt`
- [X] T011 [US1] Update `ModelSelector` in `ModelSections.kt` to support an optional `"None"` leading option (`noneLabel: String? = null`, `onSelectNone: (() -> Unit)? = null`), customizable test tags (`TAG_AUDIO_MODEL_SELECTOR = "audio_model_selector"`, `TAG_AUDIO_MODEL_OPTION = "audio_model_option"`), and prefix label, enable `onUse` on downloaded `ModelType.SPEECH_RECOGNITION` cards in `ModelSections`, and render both Text and Audio `ModelSelector`s on `ModelDownloadUi` in `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/component/ModelSections.kt` and `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadUi.kt`
- [X] T012 [P] [US1] Add unit tests in `OpenRouterModelsClientTest` and `OpenRouterConfigTest` verifying `input_modalities` `"audio"` parsing into `AvailableModel.audioInput` and `OpenRouterConfig.prunedTo` / `audioModelIds` persistence in `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/data/remote/OpenRouterModelsClientTest.kt` and `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfigTest.kt`
- [X] T013 [P] [US1] Add unit tests in `ModelDownloadRepositoryImplTest` (and update `FakeModelDownloadRepository`) verifying `activeAudioModel` defaults to `null`, persists local speech and remote audio model selections to `activeAudioFile`, clears on `selectAudioModel(null)`, and automatically falls back to `null` when the active speech model is deleted or removed from `OpenRouterConfig.audioModels` in `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt` and `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/presentation/FakeModelDownloadRepository.kt`
- [X] T014 [P] [US1] Add unit tests in `ModelDownloadPresenterTest` verifying `audioModels` ordering (downloaded `SPEECH_RECOGNITION` models then audio-capable OpenRouter models, excluding text-only OpenRouter models), `SelectAudioModel` switching/clearing to `null`, and `UseModel` on a downloaded speech model selecting `activeAudioModel` and popping navigation in `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`

**Checkpoint**: User Story 1 (MVP) is complete and independently verifiable.

---

## Phase 4: User Story 2 - Show or Hide the Chat Composer Microphone Button Based on Audio Model Selection (Priority: P1)

**Goal**: The Chat screen composer hides the microphone record button when `activeAudioModelId` is
`null` (`"None"`) and displays it next to the Send button whenever an on-device or OpenRouter audio
model is active.

**Independent Test**: Render `InteracAssistantUi` with `activeAudioModelId = null` and confirm
`TAG_RECORD` is absent; render with `activeAudioModelId = "sherpa-onnx-whisper-tiny.en"` or
`"openrouter:openai/gpt-4o-audio-preview"` and confirm `TAG_RECORD` is displayed next to `TAG_SEND`.

### Implementation & Tests for User Story 2

- [X] T015 [US2] Add `enum class VoiceState { Idle, Recording, Transcribing }`, `sealed interface VoiceError { data object PermissionDenied : VoiceError; data class Failed(val failure: InferenceFailure) : VoiceError }`, `val activeAudioModelId: String? = null`, `val voiceState: VoiceState = VoiceState.Idle`, and `val voiceError: VoiceError? = null` to `InteracAssistantState`, plus `ToggleRecording`, `CancelRecording`, `MicrophonePermissionDenied`, and `DismissVoiceError` to `InteracAssistantAction` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantContract.kt`
- [X] T016 [US2] Wire `override val activeAudio: Flow<String?> = repository.activeAudioModel` in `InteracModule.textModelSource(...)` and collect `source.activeAudio` into `InteracAssistantState.activeAudioModelId` in `app/src/main/java/com/jayvijay/scottie/di/InteracModule.kt` and `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt`
- [X] T017 [US2] Update `Composer` in `ChatComponents.kt` (`TAG_RECORD = "chat_record"`) and `InteracAssistantUi.kt` so the microphone record button is rendered next to `TAG_SEND` only when `state.activeAudioModelId != null` and hidden when `state.activeAudioModelId == null` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/component/ChatComponents.kt` and `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt`

**Checkpoint**: User Stories 1 and 2 work independently.

---

## Phase 5: User Story 3 - Record a Voice Clip and Transcribe It into the Chat Composer (Priority: P1)

**Goal**: Users tap the microphone button to start recording (requesting `RECORD_AUDIO` permission
if needed), tap again to stop and immediately release the microphone, see a transcribing busy state
with Record, Send, and Clear Chat disabled, and have non-blank transcriptions from the active Edge
(`RunAnywhere.stt`) or Cloud (`OpenRouter`) audio model inserted into the composer input field.

**Independent Test**: With an active audio model, trigger `ToggleRecording` to start and stop
recording in `InteracAssistantPresenter`, verify `recorder.stop()` releases the microphone before
`transcriber.transcribe(...)` runs, and confirm the transcribed text is inserted (or appended after
a single space) into `state.input`.

### Implementation & Tests for User Story 3

- [X] T018 [P] [US3] Implement `AndroidAudioRecorder` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/data/ai/provider/AndroidAudioRecorder.kt` using `AudioRecord` (`MediaRecorder.AudioSource.MIC`, `16_000` Hz, `CHANNEL_IN_MONO`, `ENCODING_PCM_16BIT`), releasing `AudioRecord` in `finally` on `stop()` and `cancel()` and wrapping recorded PCM16 bytes in a 44-byte RIFF/WAV header
- [X] T019 [P] [US3] Create `OnDeviceSttModels` in `app/src/main/java/com/jayvijay/scottie/core/ai/OnDeviceSttModels.kt` to load the selected `SPEECH_RECOGNITION` model via `RunAnywhere.models` (unloading any different previously loaded speech model first) and transcribe WAV bytes via `RunAnywhere.stt.transcribe(AudioInput.wav(wavBytes)).text`
- [X] T020 [P] [US3] Update `OpenRouterTextModels` in `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt` to include `LLMCapability.Audio` on resolved `LLModel` instances and add `suspend fun transcribeAudio(executor: PromptExecutor, modelId: String, wavBytes: ByteArray): String` sending a `prompt("stt")` with `AttachmentSource.Audio(AttachmentContent.Binary.Bytes(wavBytes), format = "wav", mimeType = "audio/wav", fileName = "speech.wav")` and a verbatim plain-text transcription instruction
- [X] T021 [US3] Wire `AudioRecorder` (`AndroidAudioRecorder`) and routing `SpeechTranscriber` (routing non-prefixed model IDs to `OnDeviceSttModels` and `openrouter:` IDs to `OpenRouterTextModels.transcribeAudio`, classifying failures via `FailureClassifier`) in `app/src/main/java/com/jayvijay/scottie/di/InteracModule.kt`
- [X] T022 [US3] Update `InteracAssistantPresenter` to inject `AudioRecorder` and `SpeechTranscriber`, implement `InteracAssistantAction.ToggleRecording` (`Idle` → `Recording` via `recorder.start()`; `Recording` → `recorder.stop()` → `Transcribing` → `transcriber.transcribe(wavBytes, audioModelId)` → append non-blank transcript to `input` with a single separating space when `input` is non-empty and does not end in whitespace → `Idle`), and block `Send` and `ClearChat` while `voiceState != VoiceState.Idle` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt`
- [X] T023 [US3] Update `InteracAssistantUi` and `Composer` (`ChatComponents.kt`) with `rememberRecordAudioPermissionGate` (requesting `Manifest.permission.RECORD_AUDIO` when not granted and dispatching `ToggleRecording` on grant or `MicrophonePermissionDenied` on denial), distinct `Idle` / `Recording` / `Transcribing` visuals and accessibility descriptions on `TAG_RECORD`, and disabling `TAG_SEND` and `TAG_CLEAR_CHAT` when `state.voiceState != VoiceState.Idle` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt` and `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/component/ChatComponents.kt`

**Checkpoint**: Whole-clip recording and Edge/Cloud transcription flow is complete.

---

## Phase 6: User Story 4 - Handle Silent Recordings, Errors, and Screen Cancellation Gracefully (Priority: P2)

**Goal**: Silent/blank transcripts leave existing draft text untouched, screen disposal or
cancellation while recording immediately stops and discards the clip and releases the microphone,
and permission denials or transcription failures preserve existing draft text and surface a
dismissible error toast (`TAG_VOICE_ERROR`).

**Independent Test**: In `InteracAssistantPresenterTest` and `InteracAssistantUiTest`, verify (a)
blank/whitespace transcripts preserve `input`, (b) `CancelRecording` / screen disposal during
`Recording` calls `recorder.cancel()` without calling `transcriber`, and (c) permission denial and
`InferenceException` failures preserve `input`, return `voiceState` to `Idle`, and show a
dismissible `ScottieToast`.

### Implementation & Tests for User Story 4

- [X] T024 [US4] Handle `CancelRecording`, `MicrophonePermissionDenied`, `DismissVoiceError`, `DisposableEffect` disposal cleanup (`recorder.cancel()`), active-audio-model removal while recording, silent/blank transcript preservation, and `InferenceException` mapping to `VoiceError.Failed` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt` and render the dismissible `ScottieToast` (`TAG_VOICE_ERROR = "chat_voice_error"`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt`
- [X] T025 [P] [US4] Add unit tests in `InteracAssistantPresenterTest` covering `activeAudioModelId` propagation, `Idle` → `Recording` → `Transcribing` → `Idle` state transitions, draft text insertion and single-space appending, silent/blank transcript preservation, `CancelRecording` / disposal hardware release without transcription, `MicrophonePermissionDenied`, and `InferenceFailure` error recovery in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`
- [X] T026 [P] [US4] Add Compose UI tests in `InteracAssistantUiTest` verifying `TAG_RECORD` visibility when `activeAudioModelId` is null vs. non-null, `Recording` and `Transcribing` button states and `TAG_SEND` / `TAG_CLEAR_CHAT` disablement, and `TAG_VOICE_ERROR` toast display and dismissal in `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt`

**Checkpoint**: All 4 user stories are functional and covered by unit and UI tests.

---

## Phase 7: Polish & Cross-Cutting Concerns

**Purpose**: Run full build, unit test, static analysis, and lint gates.

- [X] T027 Run validation suite (`./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug`) per `scottie/specs/012-speech-to-text-input/quickstart.md`

---

## Dependencies & Execution Order

### Phase Dependencies

- **Phase 1 (Setup: `T001`–`T002`)**: No dependencies — starts immediately in parallel.
- **Phase 2 (Foundational: `T003`–`T005`)**: Depends on Phase 1 — defines cross-feature and domain contracts in parallel.
- **Phase 3 (US1 - Audio Model Selection in Settings: `T006`–`T014`)**: Depends on Phase 1–2 — touches `feature/modeldownload` only.
- **Phase 4 (US2 - Composer Mic Button Visibility: `T015`–`T017`)**: Depends on Phase 2 (`T003`) and `T008`.
- **Phase 5 (US3 - Whole-Clip Recording & Transcription: `T018`–`T023`)**: Depends on Phase 2 (`T004`, `T005`) and Phase 4 (`T015`–`T017`).
- **Phase 6 (US4 - Silent Clips, Cancellation & Error Recovery: `T024`–`T026`)**: Depends on Phase 5.
- **Phase 7 (Polish: `T027`)**: Depends on Phases 3–6.

### Parallel Opportunities

- `T001` and `T002` (Setup) touch different files and run in parallel.
- `T003`, `T004`, and `T005` (Foundational domain contracts) touch different files and run in parallel.
- `T018` (`AndroidAudioRecorder`), `T019` (`OnDeviceSttModels`), and `T020` (`OpenRouterTextModels`) touch completely separate packages and run in parallel with Phase 3 (`feature/modeldownload`).
- Test tasks `T012`, `T013`, `T014`, `T025`, and `T026` touch separate test files and run in parallel once their targets compile.

---

## Parallel Example

```bash
# Launch Foundational contracts in parallel:
Task T003: "Update TextModelSource in feature/interacbanking/domain/repository/TextModelSource.kt"
Task T004: "Create AudioRecorder in feature/interacbanking/domain/repository/AudioRecorder.kt"
Task T005: "Create SpeechTranscriber in feature/interacbanking/domain/agent/workflow/SpeechTranscriber.kt"

# Launch Audio Recorder and AI Transcription adapters in parallel with US1 Settings work:
Task T018: "Implement AndroidAudioRecorder in feature/interacbanking/data/ai/provider/AndroidAudioRecorder.kt"
Task T019: "Create OnDeviceSttModels in core/ai/OnDeviceSttModels.kt"
Task T020: "Update OpenRouterTextModels in core/ai/OpenRouterTextModels.kt"
```

---

## Implementation Strategy

### MVP First (User Story 1)

1. Complete Phase 1 (`T001`–`T002`) and Phase 2 (`T003`–`T005`).
2. Complete Phase 3 (`T006`–`T014`) to deliver and verify active Speech-to-Text model selection and persistence in Model Settings.
3. Complete Phase 4 (`T015`–`T017`) to wire composer microphone visibility to the active audio model.
4. Complete Phase 5 (`T018`–`T023`) and Phase 6 (`T024`–`T026`) to deliver whole-clip recording, Edge/Cloud transcription, and error/cancellation handling.
5. Run Phase 7 (`T027`) verification gates.
