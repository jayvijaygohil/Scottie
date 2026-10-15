# Implementation Plan: Speech-to-Text Voice Input for Chat Composer

**Branch**: `012-speech-to-text-input` | **Date**: 2026-10-15 | **Spec**: [spec.md](spec.md)
**Input**: Feature specification from `/scottie/specs/012-speech-to-text-input/spec.md`

## Summary

Add whole-clip (batch) speech-to-text voice input to the Chat composer supporting both downloaded on-device (Edge) speech recognition models (`RunAnywhere.stt`) and saved OpenRouter (Cloud) audio-capable models (`OpenRouterLLMClient` with `LLMCapability.Audio`), with at most one active audio model at a time. Expose a dedicated Audio model selector dropdown (defaulting and falling back to `"None"`) and per-card `"Use in chat"` action for downloaded speech models on the Model Settings screen, conditionally show the microphone record button in the Chat composer only when an audio model is selected, manage runtime `RECORD_AUDIO` permission and `AudioRecord` lifecycle (`Idle` → `Recording` → `Transcribing`), and insert non-blank transcriptions into the composer input field while preserving existing draft text across silent clips and errors.

## Technical Context

**Language/Version**: Kotlin 2.4.21, JDK 17, AGP 9.4.1, minSdk 26 / targetSdk 37
**Primary Dependencies**: Jetpack Compose + Material 3, Slack Circuit 0.39.0 (`hilt` codegen), Hilt 2.60.1, JetBrains Koog 1.3.0 (`koog-agents`), RunAnywhere SDK 0.20.27 (`runanywhere-sdk`, `runanywhere-onnx`), AndroidX A2UI 1.0.0-alpha01. No new dependencies or version upgrades.
**Storage**: App-private files in `context.filesDir`: `active_audio_model` (`@Named("activeAudioModelFile")`) for the selected audio model ID and `openrouter_config.json` (`OpenRouterConfig.audioModels`) for persisted audio-capable OpenRouter model IDs. Recorded audio clips are held in memory as 16 kHz mono 16-bit PCM WAV `ByteArray` buffers and discarded immediately after transcription or cancellation.
**Testing**: JUnit 4 host unit tests (`:app:testDebugUnitTest`), `kotlinx-coroutines-test`, Circuit `test` / Turbine, and Compose UI tests (`:app:connectedDebugAndroidTest`).
**Target Platform**: Android (minSdk 26 / targetSdk 37).
**Project Type**: Single-module Android application with feature-slice Clean Architecture.
**Performance Goals**: Immediate microphone release on Stop or screen exit (< 50 ms); responsive UI transitions (< 16 ms frame budget) across `Idle`, `Recording`, and `Transcribing` composer states.
**Constraints**: Zero cross-feature imports between `feature/interacbanking` and `feature/modeldownload`; `domain/` free of Android and AI SDK imports; all user-visible text and accessibility labels in `res/values/strings.xml`; 2-space indent, 100-char line limit, and passing `detekt` / `lintDebug`.
**Scale/Scope**: `feature/modeldownload` (domain, data, presentation), `feature/interacbanking` (domain, data, presentation), shared AI helpers in `core/ai/`, DI wiring in `di/DataModule.kt` and `di/InteracModule.kt`, string resources in `res/values/strings.xml`, and unit + UI tests.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | PASS | `feature/interacbanking` and `feature/modeldownload` do not import each other. `AudioRecorder` and `SpeechTranscriber` contracts live in `feature/interacbanking/domain/`; `AndroidAudioRecorder` lives in `feature/interacbanking/data/ai/provider/`; shared RunAnywhere/OpenRouter transcription helpers live in `core/ai/` and are wired in `di/InteracModule.kt`. |
| II. Circuit-Driven Presentation | PASS | All Settings audio model actions (`SelectAudioModel`, `UseModel`) and Chat voice actions (`ToggleRecording`, `CancelRecording`, `MicrophonePermissionDenied`, `DismissVoiceError`) flow through `CircuitUiEvent` to their `Presenter`s; UIs remain stateless renderers using `stringResource` and applying `Modifier` to root. |
| III. Bounded AI Agents | PASS | `SpeechTranscriber` is a clean domain contract in `feature/interacbanking/domain/agent/workflow/`; `RunAnywhere.stt` and Koog `OpenRouterLLMClient` calls remain isolated in `core/ai/` and `di/`. |
| IV. Verified Changes | PASS | Unit tests cover `OpenRouterModelsClient`, `ModelDownloadRepositoryImpl`, `ModelDownloadPresenter`, and `InteracAssistantPresenter` using fakes; UI tests cover `InteracAssistantUi` composer microphone visibility, recording/transcribing states, and error toasts. |
| V. Simplicity | PASS | Reuses the existing `ModelSelector` composable (parameterized for optional `"None"` item and label), existing `InferenceFailure` error classification, existing `ScottieToast`, Android's built-in `AudioRecord` with a 44-byte WAV header, `RunAnywhere.stt.transcribe`, and Koog's `AttachmentSource.Audio`. Zero new libraries. |

**Post-design re-check**: PASS. No violations or Complexity Tracking justifications needed.

## Project Structure

### Documentation (this feature)

```text
scottie/specs/012-speech-to-text-input/
├── plan.md              # This file (/speckit-plan command output)
├── research.md          # Phase 0 output (/speckit-plan command)
├── data-model.md        # Phase 1 output (/speckit-plan command)
├── quickstart.md        # Phase 1 output (/speckit-plan command)
├── contracts/           # Phase 1 output (/speckit-plan command)
│   └── ui-contracts.md
└── tasks.md             # Phase 2 output (/speckit-tasks command - NOT created by /speckit-plan)
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
├── core/
│   └── ai/
│       ├── OnDeviceSttModels.kt                   # RunAnywhere STT model load/unload & WAV transcription helper
│       └── OpenRouterTextModels.kt                # Add LLMCapability.Audio support & verbatim audio transcription helper
├── di/
│   ├── DataModule.kt                              # Provide @Named("activeAudioModelFile") File
│   └── InteracModule.kt                           # Wire activeAudio on TextModelSource, AudioRecorder, and routing SpeechTranscriber
├── feature/
│   ├── interacbanking/
│   │   ├── data/
│   │   │   └── ai/provider/
│   │   │       └── AndroidAudioRecorder.kt        # AudioRecord 16kHz mono PCM16 capture + 44-byte WAV builder + immediate release
│   │   ├── domain/
│   │   │   ├── agent/workflow/
│   │   │   │   └── SpeechTranscriber.kt           # Domain interface for whole-clip audio transcription
│   │   │   └── repository/
│   │   │       ├── AudioRecorder.kt               # Domain interface for whole-clip audio capture (start, stop, cancel)
│   │   │       └── TextModelSource.kt             # Add activeAudio: Flow<String?>
│   │   └── presentation/
│   │       ├── InteracAssistantContract.kt        # Add VoiceState, VoiceError, activeAudioModelId, voiceState, voiceError, and voice actions
│   │       ├── InteracAssistantPresenter.kt       # Manage recording/transcription lifecycle, draft text insertion, error handling, and disposal cleanup
│   │       ├── InteracAssistantUi.kt              # Runtime RECORD_AUDIO permission gate, Composer voice props, and voiceError ScottieToast
│   │       └── component/
│   │           └── ChatComponents.kt              # Update Composer with microphone/stop/transcribing button next to Send
│   └── modeldownload/
│       ├── data/
│       │   ├── remote/
│       │   │   └── OpenRouterModelsClient.kt      # Parse architecture.input_modalities for "audio" into AvailableModel.audioInput
│       │   └── repository/
│       │       └── ModelDownloadRepositoryImpl.kt # Persist activeAudioModel with automatic fallback to null ("None")
│       ├── domain/
│       │   ├── entities/
│       │   │   └── OpenRouterConfig.kt            # Add audioInput to AvailableModel; add audioModels/audioModelIds to OpenRouterConfig
│       │   └── repository/
│       │       └── ModelDownloadRepository.kt     # Add activeAudioModel: StateFlow<String?> and selectAudioModel(modelId: String?)
│       └── presentation/
│           ├── ModelDownloadScreen.kt             # Add audioModels, activeAudioModelId to state; add SelectAudioModel action
│           ├── ModelDownloadPresenter.kt          # Populate audioModels, activeAudioModelId; handle SelectAudioModel and speech UseModel
│           ├── ModelDownloadUi.kt                 # Render Text and Audio ModelSelectors in Settings
│           └── component/
│               └── ModelSections.kt               # Support optional "None" item in ModelSelector and enable "Use in chat" on speech model cards
└── app/src/main/res/
    ├── values/
    │   └── strings.xml                            # Add audio selector and voice recording/transcription strings
    └── xml/
        ├── backup_rules.xml                       # Keep backup rules aligned if needed
        └── data_extraction_rules.xml

app/src/test/java/com/jayvijay/scottie/feature/
├── interacbanking/presentation/
│   └── InteracAssistantPresenterTest.kt           # Test mic visibility state, recording/transcribing transitions, draft append, silence, cancellation, errors
└── modeldownload/
    ├── data/
    │   ├── remote/
    │   │   └── OpenRouterModelsClientTest.kt      # Test input_modalities audio detection
    │   └── repository/
    │       └── ModelDownloadRepositoryImplTest.kt # Test activeAudioModel persistence and fallback to null ("None")
    └── presentation/
        └── ModelDownloadPresenterTest.kt          # Test audioModels dropdown list, SelectAudioModel, and speech card UseModel

app/src/androidTest/java/com/jayvijay/scottie/feature/
├── interacbanking/presentation/
│   └── InteracAssistantUiTest.kt                  # Test mic button hidden when None, visible when audio model active, recording/transcribing UI states
└── modeldownload/presentation/
    └── ModelDownloadUiTest.kt                     # Test Text and Audio model selectors and "None" option in Settings
```

**Structure Decision**: Extend the existing `feature/modeldownload` and `feature/interacbanking` slices in-place, using `core/ai/` and `di/InteracModule.kt` as the composition seam between model state/runtimes and the chat assistant.

## Complexity Tracking

None.
