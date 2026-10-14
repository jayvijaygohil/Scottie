# Bug Verification: Pre-existing Interac Compose Instrumented Test Failures

- **Slug**: interac-androidtest-failures
- **Tested**: 2026-10-13
- **Assessment**: ./assessment.md
- **Fix**: ./fix.md
- **Result**: verified

## Summary

All 3 previously failing Compose `androidTest` cases (`InteracFormTest#typingQueriesAndSuggestionsRenderAsChips`, `InteracFormTest#submitStaysDisabledUntilChannelAndSecurityAreValid`, and `InteracAssistantUiTest#textTurnShowsBubbleAndReplyCard`) now pass on the connected Android device (`25010PN30G`), bringing the full instrumentation suite to `17/17` passing (`OK (17 tests)` in `18.993s`) with zero unit test, `detekt`, or `lintDebug` regressions.

## Checks Performed

| Check | Command / Action | Result | Notes |
|-------|------------------|--------|-------|
| Reproduction (post-fix) | `adb -s adb-84f8a7c1-zM5y8q._adb-tls-connect._tcp shell am instrument -w -e class com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest,com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantUiTest com.jayvijay.scottie.test/androidx.test.runner.AndroidJUnitRunner` | pass | `OK (16 tests)` in `18.359s`; all 5 tests in `InteracFormTest` and all 11 tests in `InteracAssistantUiTest` passed |
| New / updated tests | `adb -s adb-84f8a7c1-zM5y8q._adb-tls-connect._tcp shell am instrument -w com.jayvijay.scottie.test/androidx.test.runner.AndroidJUnitRunner` | pass | Full `androidTest` suite (`ExampleInstrumentedTest`, `InteracAssistantUiTest`, `InteracFormTest`) passed (`OK (17 tests)` in `18.993s`) |
| Regression suite | `./gradlew :app:testDebugUnitTest` | pass | All JVM unit tests passed |
| Lint / type-check | `./gradlew :app:detekt :app:lintDebug` | pass | Both `detekt` and Android `lintDebug` passed with 0 errors |

## Output Excerpts

```text
> Task :app:detekt UP-TO-DATE
> Task :app:testDebugUnitTest UP-TO-DATE
> Task :app:lintDebug
BUILD SUCCESSFUL in 3s

com.jayvijay.scottie.ExampleInstrumentedTest:.
com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantUiTest:...........
com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest:.....

Time: 18.993

OK (17 tests)
```

## Residual Risks

- On the connected Xiaomi device (`25010PN30G`), Gradle's `:app:connectedDebugAndroidTest` task passes `-g` (`INSTALL_GRANT_ALL_REQUESTED_PERMISSIONS`), which Xiaomi blocks unless "USB debugging (Security settings)" is enabled; installing the built APKs with `adb install -r` and running `adb shell am instrument` bypasses `-g`.

## Recommendation

Close the bug — verified end-to-end on the connected device (`OK (17 tests)`).
