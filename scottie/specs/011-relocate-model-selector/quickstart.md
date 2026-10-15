# Quickstart Validation Guide: Relocate Model Selection & Update Chat Header Actions

**Feature**: `011-relocate-model-selector`
**Date**: 2026-10-14

## Prerequisites

- JDK 17 configured for Gradle
- Android SDK installed (compileSdk / targetSdk 37, minSdk 26)
- Connected Android device or running emulator (only required for `:app:connectedDebugAndroidTest`)

## Automated Validation Commands

Run from the repository root (`/Users/jayvijay/Documents/AndroidStudioProjects/Scottie`):

```sh
# 1. Compile debug APK
./gradlew :app:assembleDebug

# 2. Run JVM unit tests (includes InteracAssistantPresenterTest and ModelDownloadPresenterTest)
./gradlew :app:testDebugUnitTest

# 3. Run static analysis and Android lint
./gradlew :app:detekt :app:lintDebug

# 4. Run instrumented Compose UI tests (when a device/emulator is connected)
./gradlew :app:connectedDebugAndroidTest
```

## Manual Verification Scenarios

1. **Chat Header Logo & Long-Press to Settings (US2)**:
   - Launch the app onto the Chat screen.
   - Confirm the top bar shows the `'Scootie'` logo text instead of the model selector dropdown.
   - Single-tap `'Scootie'` and confirm nothing opens or navigates.
   - Long-press `'Scootie'` and confirm haptic feedback fires and the app navigates to the Settings (`Download models`) screen.
2. **Active Model Selection in Settings (US1)**:
   - On the Settings screen, locate the active model selector.
   - With at least one downloaded local text model and/or checked OpenRouter remote model, open the selector dropdown, verify local models appear before remote models (badged `Remote`), and select a different model.
   - Navigate back to Chat, send a message, and confirm the newly selected model responds.
3. **Clear Chat / Context Action (US3)**:
   - On the Chat screen prior to sending any message (with empty input), confirm the top-right Clear Chat/Context button is disabled.
   - Send a prompt (e.g., `"What's my balance?"` or `"What's the weather?"`) and wait for the reply card/surface to appear.
   - Tap the top-right Clear Chat/Context button and confirm all turns, rendered A2UI cards, and any draft composer text are cleared, returning the screen to the Welcome card.
