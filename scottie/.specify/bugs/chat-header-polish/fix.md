# Fix Report: Chat header title, logo badge removal, and Clear Chat button polish

**Slug**: `chat-header-polish`
**Assessment**: `.specify/bugs/chat-header-polish/assessment.md`
**Fixed**: 2026-10-14
**Option Applied**: Option A: Direct UI + string resource cleanup
**Status**: applied

## Summary of Changes

Updated the Chat screen header string resource to `"Scottie"`, removed the robot icon badge from the Chat header `titleContent` while preserving long-press navigation to Settings and `TAG_LOGO`, removed the 1dp rounded-square `Surface` border around the Clear Chat (`DeleteSweep`) `IconButton`, added `8.dp` end padding to the Clear Chat button, and updated the UI test assertion in `InteracAssistantUiTest.kt`.

## Files Modified

| File | Change Type | Description |
|------|-------------|-------------|
| `app/src/main/res/values/strings.xml` | modified | Changed `chat_header_logo` string value from `"Scootie"` to `"Scottie"`. |
| `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt` | modified | Replaced `Row` + `Surface` + `SmartToy` icon badge in `ScottieToolbar(titleContent = ...)` with text-only `"Scottie"` heading retaining `combinedClickable` long-press and `TAG_LOGO`; removed bordered `Surface` wrapper around Clear Chat `IconButton` and added `Modifier.padding(end = 8.dp)`; removed unused imports. |
| `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt` | modified | Renamed `logoShowsScootieWithoutModelSelectorIgnoresSingleTapAndOpensSettingsOnLongPress` to `logoShowsScottieWithoutModelSelectorIgnoresSingleTapAndOpensSettingsOnLongPress` and updated text assertion to `"Scottie"`. |

## Deviations from Assessment

None — applied as assessed.

## Smoke Check Results

- Build/compile: PASS (`./gradlew :app:assembleDebug :app:compileDebugAndroidTestKotlin`)
- Linter/type check: PASS (`./gradlew :app:detekt :app:lintDebug`)
- Affected tests: PASS (`./gradlew :app:testDebugUnitTest`; `InteracAssistantUiTest` compiled via `:app:compileDebugAndroidTestKotlin`)

## Notes for Testing

- Verify on a device or emulator without ADB `INSTALL_GRANT_RUNTIME_PERMISSIONS` restriction by running `./gradlew :app:connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantUiTest`.
- Visually inspect the Chat header in light and dark themes to confirm `"Scottie"` text-only title alignment, long-press to Settings, and borderless Clear Chat icon with `8.dp` trailing spacing.
