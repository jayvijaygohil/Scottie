# Bug Assessment: Pre-existing Interac Compose Instrumented Test Failures

- **Slug**: interac-androidtest-failures
- **Created**: 2026-10-13
- **Source**: pasted text
- **Verdict**: valid
- **Severity**: medium

## Report (verbatim or summarized)

> Three `androidTest` cases fail on device during `InteracFormTest` and `InteracAssistantUiTest` instrumentation runs:
> 1. `InteracFormTest#typingQueriesAndSuggestionsRenderAsChips`: `Failed to perform text input. Expected exactly '1' node but found '2' nodes that satisfy: (Text + InputText + EditableText contains 'Alice Martin')`.
> 2. `InteracFormTest#submitStaysDisabledUntilChannelAndSecurityAreValid`: `Failed to assert count of nodes. Did not expect any node but found '1' node that satisfies: (Text + InputText + EditableText contains 'Rex')` where `EditableText = '•••'`, `InputText = 'Rex'`, and `IsPasswordObfuscated = 'true'`.
> 3. `InteracAssistantUiTest#textTurnShowsBubbleAndReplyCard`: `Assert failed: The component with Text + InputText + EditableText contains 'Hello there' is not displayed!`

## Symptom

Running the `InteracFormTest` and `InteracAssistantUiTest` Compose instrumentation suite on an Android device fails on 3 out of 16 tests due to overly broad Compose semantics matchers (`hasText` matching both a chip and a text input, and `hasText` matching raw `InputText` on an obfuscated password field) and asserting full text before `RevealText` finishes its word-by-word `delay(30L)` reveal coroutine.

## Reproduction

1. Build and install debug and androidTest APKs (`./gradlew :app:assembleDebug :app:assembleDebugAndroidTest` and `adb install -r`).
2. Run `adb shell am instrument -w -e class com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracFormTest,com.jayvijay.scottie.feature.interacbanking.presentation.InteracAssistantUiTest com.jayvijay.scottie.test/androidx.test.runner.AndroidJUnitRunner`.
3. Observe 3 failures:
   - `InteracFormTest#typingQueriesAndSuggestionsRenderAsChips` at `InteracFormTest.kt:156`
   - `InteracFormTest#submitStaysDisabledUntilChannelAndSecurityAreValid` at `InteracFormTest.kt:135`
   - `InteracAssistantUiTest#textTurnShowsBubbleAndReplyCard` at `InteracAssistantUiTest.kt:69`

## Suspected Code Paths

- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt:156` — `onNodeWithText("Alice Martin").performTextReplacement("Ali")` matches both the editable `Recipient` `OutlinedTextField` (`EditableText = 'Alice Martin'`) and the selected `"Alice Martin"` recipient chip (`Text = '[Alice Martin]'`) rendered in `InteracForm.kt:190-221`.
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt:135` — `onAllNodesWithText("Rex").assertCountEquals(0)` uses `hasText("Rex")`, which checks `Text + InputText + EditableText`. Even though `InteracForm.kt:308` applies `PasswordVisualTransformation()` (`EditableText = '•••'`, `IsPasswordObfuscated = 'true'`), Compose populates `SemanticsProperties.InputText` with `"Rex"` for autofill/IME semantics.
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt:69` — `rule.onNodeWithText("Hello there").assertIsDisplayed()` runs immediately after `setContent`, while `RevealText` (`ChatComponents.kt:142-156`) reveals `"Hello there"` word-by-word in a `LaunchedEffect` with `delay(30L)` per word (`"Hello"` on initial frame, `"Hello there"` after 30ms).

## Root Cause Hypothesis

**High confidence.** All three failures are test-side Compose semantics/clock issues rather than production bugs:
1. In `InteracFormTest.typingQueriesAndSuggestionsRenderAsChips`, `aliceSeed` pre-selects `ct_alice` (`"Alice Martin"`), so both the `Recipient` text field and the `"Alice Martin"` `FilterChip` display `"Alice Martin"`. Calling `onNodeWithText("Alice Martin")` without `hasSetTextAction()` matches 2 nodes.
2. In `InteracFormTest.submitStaysDisabledUntilChannelAndSecurityAreValid`, Compose's `hasText` matcher inspects `SemanticsProperties.InputText` in addition to `SemanticsProperties.EditableText` and `SemanticsProperties.Text`. For a password-transformed `OutlinedTextField`, `EditableText` is masked (`"•••"`) and `IsPasswordObfuscated` is `true`, but `InputText` retains `"Rex"`, causing `onAllNodesWithText("Rex").assertCountEquals(0)` to fail.
3. In `InteracAssistantUiTest.textTurnShowsBubbleAndReplyCard`, `RevealText` steps through words with `delay(REVEAL_WORD_MS)` (`30L` ms per word). Because `"Hello there"` has two words, the first composition only renders `"Hello"` until the coroutine delay advances past the first word.

## Proposed Remediation

**Preferred**:
1. In `InteracFormTest.kt:156` (`typingQueriesAndSuggestionsRenderAsChips`), constrain the node matcher to the editable text input: `onNode(hasText("Alice Martin") and hasSetTextAction()).performTextReplacement("Ali")`.
2. In `InteracFormTest.kt:135` (`submitStaysDisabledUntilChannelAndSecurityAreValid`), verify password masking by asserting the password field's `EditableText` is `"•••"` (e.g., `onNode(SemanticsMatcher.expectValue(SemanticsProperties.EditableText, AnnotatedString("•••"))).assertIsDisplayed()`), rather than `onAllNodesWithText("Rex").assertCountEquals(0)`.
3. In `InteracAssistantUiTest.kt:65-69` (`textTurnShowsBubbleAndReplyCard`), wait for `RevealText` to finish revealing `"Hello there"` (e.g., `rule.waitUntil { rule.onAllNodesWithText("Hello there").fetchSemanticsNodes().isNotEmpty() }` or advancing the clock) before asserting `rule.onNodeWithText("Hello there").assertIsDisplayed()`.

**Alternatives** (optional):
- Skip `RevealText` animation in tests via a composition local: unnecessary when `waitUntil` or clock advancement in `InteracAssistantUiTest` exercises the real `RevealText` completion path.

**Files likely to change**:
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt`
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt`

**Tests to add or update**:
- `InteracFormTest#typingQueriesAndSuggestionsRenderAsChips`: Use `hasText("Alice Martin") and hasSetTextAction()`.
- `InteracFormTest#submitStaysDisabledUntilChannelAndSecurityAreValid`: Assert `SemanticsProperties.EditableText` is `AnnotatedString("•••")` on the password field.
- `InteracAssistantUiTest#textTurnShowsBubbleAndReplyCard`: Wait until `"Hello there"` is revealed before `assertIsDisplayed()`.

## Risks & Considerations

- **Test-only scope**: Only `app/src/androidTest/` files are touched; zero production code impact.

## Open Questions

- None.
