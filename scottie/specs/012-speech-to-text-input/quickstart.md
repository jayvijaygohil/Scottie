# Quickstart Validation Guide: Speech-to-Text Voice Input for Chat Composer

**Feature**: `012-speech-to-text-input`
**Date**: 2026-10-15

## Prerequisites

- JDK 17 configured for Gradle
- Android SDK installed (compileSdk / targetSdk 37, minSdk 26)
- Connected Android device or running emulator with microphone support (only required for `:app:connectedDebugAndroidTest` and manual voice recording checks)

## Automated Validation Commands

Run from the repository root (`/Users/jayvijay/Documents/AndroidStudioProjects/Scottie`):

```sh
# 1. Compile debug APK
./gradlew :app:assembleDebug

# 2. Run JVM unit tests (includes ModelDownloadRepositoryImplTest, ModelDownloadPresenterTest, OpenRouterModelsClientTest, InteracAssistantPresenterTest)
./gradlew :app:testDebugUnitTest

# 3. Run static analysis and Android lint
./gradlew :app:detekt :app:lintDebug

# 4. Run instrumented Compose UI tests (when a device/emulator is connected)
./gradlew :app:connectedDebugAndroidTest
```

## Manual Verification Scenarios

1. **Select Active Speech-to-Text Model in Settings (US1)**:
   - Open Settings (`Download models` screen) by long-pressing the `'Scottie'` header logo on the Chat screen.
   - Verify two model selector pills appear at the top of Settings: one for the Text model and one for the Audio (Speech-to-Text) model, with the Audio selector defaulting to `None`.
   - Download an on-device Speech model (e.g., `Sherpa Whisper Tiny (ONNX)`) and/or save an OpenRouter configuration with an audio-capable model checked.
   - Open the Audio model dropdown and verify it lists `None`, downloaded on-device speech models, and saved audio-capable OpenRouter models (badged `Remote`), excluding text-only OpenRouter models.
   - Also verify that downloaded Speech model cards show the `Use in chat` button, which sets that speech model as the active audio model and navigates back to Chat.
2. **Composer Microphone Button Visibility (US2)**:
   - With the Audio model set to `None`, return to the Chat screen and confirm the microphone button is hidden in the composer.
   - Select an on-device or OpenRouter audio model in Settings, return to Chat, and confirm the microphone button appears next to the Send button.
3. **Whole-Clip Recording & Transcription Flow (US3 & US4)**:
   - Tap the microphone button in the chat composer and grant runtime microphone permission when prompted (or deny first to verify the dismissible permission error toast).
   - Confirm the button switches to the Stop state and that Send and Clear Chat are disabled while recording.
   - Speak a short phrase (e.g., `"What is my balance"`) and tap Stop.
   - Confirm the composer shows a transcribing busy indicator with Record, Send, and Clear Chat disabled, then inserts the transcribed text into the composer input field (appending after a single space if draft text was already present).
   - Review or edit the transcribed text and tap Send.
