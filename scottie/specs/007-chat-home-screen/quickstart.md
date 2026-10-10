# Quickstart: validate the chat home screen

## Automated (from repository root)

```sh
./gradlew :app:testDebugUnitTest      # presenter + repository + Compose UI (Robolectric) tests
./gradlew :app:detekt :app:lintDebug
./gradlew :app:assembleDebug
./gradlew :app:connectedDebugAndroidTest   # device/emulator required (constitution IV)
```

Expected new/updated coverage:

- `ModelDownloadRepositoryImplTest`: active model resolution (stored + downloaded → stored;
  stored deleted → first downloaded text model in catalog order; none → null; speech models
  ignored; `selectTextModel` persists).
- `ModelDownloadPresenterTest`: `UseModel` selects and pops.
- `InteracAssistantPresenterTest`: null active model → `missingModel`, Send no-op; `SelectModel`
  ignored while busy; Send passes the active id to the extractor; `OpenSettings` goes to the
  settings destination.
- `InteracAssistantUiTest`: empty state button dispatches `OpenSettings`; example chip fills
  input; selector lists models and dispatches `SelectModel`; Send disabled when blank or busy.

## Manual on device (network off after download)

1. Fresh install → launch: chat with empty state. Tap "Download a Model to Get Started" → Settings
   slides in.
2. Download Gemma 4 E2B. Back gesture → chat slides back, welcome card shown, top bar names the
   model.
3. Tap "What's my balance?" chip, Send → haptic tick, user bubble, dots, then balance cards in a
   card.
4. Type "What's the weather?" → reply text reveals word by word; list follows the text.
5. Download a second text model; open selector → both listed, active checked; pick the other →
   tick, title changes, earlier turns remain.
6. Kill and relaunch → last chosen model is active.
7. In Settings delete the active model → back to chat: the other model becomes active; delete all
   → empty state.
8. Run feature 005 quickstart scenarios from the chat (SC-008).
9. Compare chat and Settings side by side in light and dark mode (SC-007).
