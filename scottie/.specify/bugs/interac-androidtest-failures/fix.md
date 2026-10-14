# Bug Fix: Pre-existing Interac Compose Instrumented Test Failures

- **Slug**: interac-androidtest-failures
- **Fixed**: 2026-10-13
- **Assessment**: ./assessment.md
- **Status**: applied

## Summary

Fixed the three Compose `androidTest` failures in `InteracFormTest` and `InteracAssistantUiTest` by narrowing the `"Alice Martin"` text field selector with `hasSetTextAction()` and advancing `mainClock` past `QUERY_DEBOUNCE_MS` (`200L` ms) before settling `A2uiTestController`, asserting password obfuscation via `SemanticsProperties.EditableText == AnnotatedString("•••")`, and waiting for `RevealText` to finish revealing `"Hello there"` in `InteracAssistantUiTest`.

## Changes

| File | Change | Notes |
|------|--------|-------|
| `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt` | modified | Used `SemanticsProperties.EditableText == AnnotatedString("•••")` for password masking; used `hasText("Alice Martin") and hasSetTextAction()` plus `mainClock.advanceTimeBy(300)` + `settle(controller)` for debounced `recipientQuery` dispatch |
| `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt` | modified | Added `rule.waitUntil` for `"Hello there"` in `textTurnShowsBubbleAndReplyCard` before `assertIsDisplayed()` |

## Diff Highlights (optional)

```kotlin
// InteracFormTest.kt
onNode(SemanticsMatcher.expectValue(SemanticsProperties.EditableText, AnnotatedString("•••")))
  .assertIsDisplayed()
```

```kotlin
// InteracFormTest.kt
onNode(hasText("Alice Martin") and hasSetTextAction()).performTextReplacement("Ali")
settle(controller)
mainClock.advanceTimeBy(300)
settle(controller)
```

```kotlin
// InteracAssistantUiTest.kt
rule.waitUntil { rule.onAllNodesWithText("Hello there").fetchSemanticsNodes().isNotEmpty() }
rule.onNodeWithText("Hello there").assertIsDisplayed()
```

## Tests Added or Updated

- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt::submitStaysDisabledUntilChannelAndSecurityAreValid` — asserts password field `EditableText` is masked as `"•••"`.
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt::typingQueriesAndSuggestionsRenderAsChips` — targets the editable `Recipient` input and advances virtual time past `QUERY_DEBOUNCE_MS` before settling `A2uiTestController`.
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt::textTurnShowsBubbleAndReplyCard` — waits for `RevealText` word-by-word reveal before asserting `"Hello there"` is displayed.

## Local Verification

- Commands run:
  - `./gradlew :app:assembleDebugAndroidTest :app:detekt` → `BUILD SUCCESSFUL`
  - `adb install -r app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk && adb shell am instrument -w -e class com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest,com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantUiTest com.jayvijay.scottie.test/androidx.test.runner.AndroidJUnitRunner` → `OK (16 tests)` in `18.359s`
- Manual checks: Inspected `git diff` across both test files.

## Deviations from Assessment

- In `InteracFormTest.typingQueriesAndSuggestionsRenderAsChips`, in addition to `hasText("Alice Martin") and hasSetTextAction()`, added `mainClock.advanceTimeBy(300)` followed by `settle(controller)` because `runComposeUiTest` (v2) uses `StandardTestDispatcher`: `LaunchedEffect(query)` waits `QUERY_DEBOUNCE_MS` (`200L` ms) on the Compose clock before calling `dispatchAction(onQuery)`, and `controller.waitForIdle()` is then required to flush the action to `controller.outboundEvents`.

## Follow-ups

- Run `/speckit-bug-test slug=interac-androidtest-failures`.
