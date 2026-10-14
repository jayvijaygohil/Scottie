# Bug Verification: Interac e-Transfer & Money Request Form Render Failure and Request Submit Mismatch

- **Slug**: interac-etransfer-form-bug
- **Tested**: 2026-10-13
- **Assessment**: ./assessment.md
- **Fix**: ./fix.md
- **Result**: verified

## Summary

Both bugs no longer reproduce: `InteracSurfaceTemplates.form` (send and request modes) passes `A2uiCoreSchemaValidator` and renders `InteracForm` on-device without falling back to `"I couldn't build that form. Please try again."`, and tapping `"Send request"` emits `submit` with `mode = "request"` in `event.context`, completing the money-request flow (`executeRequestMoney`) instead of misrouting to send.

## Checks Performed

| Check | Command / Action | Result | Notes |
|-------|------------------|--------|-------|
| Reproduction (post-fix, on-device Compose + A2UI) | `adb shell am instrument -w -e class ...InteracFormTest#submitCarriesEveryFormValue,...InteracFormTest#requestModeShowsMemoAndNoSecurity,...InteracFormTest#autodepositHidesSecurityUntilServerSaysOtherwise com.jayvijay.scottie.test/androidx.test.runner.AndroidJUnitRunner` | pass | `OK (3 tests)` in 3.126s on device `25010PN30G`; send & request forms render via `InteracSurfaceTemplates.form`, and clicking `"Send request"` emits `submit` with `context["mode"] == "request"` and 0 `outboundErrors` |
| Reproduction (post-fix, JVM processor & presenter) | `./gradlew :app:testDebugUnitTest --tests "*.InteracSurfaceTemplatesTest" --tests "*.InteracAssistantPresenterTest" --rerun-tasks` | pass | `templatesPassCatalogValidationInProcessor` activates `send-1`, `req-1`, `bal-1`, `conf-1` surfaces with 0 client errors; `requestFlow` submits via `onSubmit` bindings and increments `banking.requests` (`3`) with `banking.sends == 0` |
| New / updated tests | `./gradlew :app:compileDebugAndroidTestKotlin :app:testDebugUnitTest` | pass | All 7 tests in `InteracSurfaceTemplatesTest`, all 13 tests in `InteracAssistantPresenterTest`, and the updated `InteracFormTest#requestModeShowsMemoAndNoSecurity` on-device passed |
| Regression suite | `./gradlew :app:testDebugUnitTest :app:assembleDebug` + full `am instrument` run | pass | All JVM unit tests passed; 13/16 connected `androidTest` cases passed (3 pre-existing unrelated Compose selector/animation failures in untouched tests noted below) |
| Lint / type-check | `./gradlew :app:detekt :app:lintDebug` | pass | 0 detekt or Android Lint issues |

## Output Excerpts

```text
$ adb -s adb-84f8a7c1-zM5y8q._adb-tls-connect._tcp shell am instrument -w \
  -e class com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest#submitCarriesEveryFormValue,com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest#requestModeShowsMemoAndNoSecurity,com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest#autodepositHidesSecurityUntilServerSaysOtherwise \
  com.jayvijay.scottie.test/androidx.test.runner.AndroidJUnitRunner

com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest:...

Time: 3.126

OK (3 tests)
```

```text
<testsuite name="com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplatesTest" tests="7" skipped="0" failures="0" errors="0" time="0.074">
  <testcase name="templatesPassCatalogValidationInProcessor" classname="com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplatesTest" time="0.071"/>
  <testcase name="formEmitsThreeEnvelopesWithEveryWritableFieldBound" classname="com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplatesTest" time="0.001"/>
</testsuite>

<testsuite name="com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantPresenterTest" tests="13" skipped="0" failures="0" errors="0" time="0.377">
  <testcase name="requestFlow" classname="com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantPresenterTest" time="0.013"/>
</testsuite>
```

```text
> Task :app:detekt UP-TO-DATE
> Task :app:testDebugUnitTest
> Task :app:assembleDebug
> Task :app:lintDebug
BUILD SUCCESSFUL in 49s
```

## Residual Risks

- On the connected Xiaomi device (`25010PN30G`), Gradle's `:app:connectedDebugAndroidTest` installer task fails with `SecurityException: You need the android.permission.INSTALL_GRANT_RUNTIME_PERMISSIONS permission` because AGP passes `-g` on install; installing the built APKs with `adb install -r` (without `-g`) and running `adb shell am instrument` works around the device restriction.
- Three pre-existing unrelated `androidTest` assertions in untouched tests failed on device:
  1. `InteracFormTest#typingQueriesAndSuggestionsRenderAsChips`: `onNodeWithText("Alice Martin")` matches both the editable `Recipient` field and the selected `"Alice Martin"` chip (needs `hasSetTextAction()`).
  2. `InteracFormTest#submitStaysDisabledUntilChannelAndSecurityAreValid`: `onAllNodesWithText("Rex").assertCountEquals(0)` matches `InputText = 'Rex'` even when `EditableText = '•••'` and `IsPasswordObfuscated = 'true'`.
  3. `InteracAssistantUiTest#textTurnShowsBubbleAndReplyCard`: `RevealText` typewriter animation is still in progress when `onNodeWithText("Hello there").assertIsDisplayed()` runs.

## Recommendation

Close the bug — verified end-to-end across JVM unit tests (`A2uiMessageProcessor`, `InteracAssistantPresenter`) and on-device Compose UI instrumentation (`InteracFormTest`).
