# Bug Assessment: Chat Header Title, Logo Removal, and Clear Chat Button Styling

- **Slug**: chat-header-polish
- **Created**: 2026-10-14
- **Source**: pasted text
- **Verdict**: valid
- **Severity**: low

## Report (verbatim or summarized)

> For the chat screen, The title name should be Scottie and not Scootie. Also, can you remove the logo and just keep the text? Also there is not enough spacing for the delete chat and the end of the screen. Also, remove the square border from the delete chat icon.

## Symptom

On the Chat screen (`InteracAssistantUi`), the top bar header displays `"Scootie"` instead of `"Scottie"` alongside a robot icon badge (`Icons.Rounded.SmartToy`), and the trailing Clear Chat (`DeleteSweep`) button is enclosed in a 1dp rounded-square bordered `Surface` placed too close to the right edge of the screen. It should display only the `"Scottie"` text (without the icon badge) and render a borderless Clear Chat `IconButton` with comfortable end spacing from the screen edge.

## Reproduction

1. Launch the app onto the Chat screen (`InteracAssistantScreen`).
2. Observe the top app bar title area: it displays a red square robot icon and the text `"Scootie"`.
3. Observe the top-right Clear Chat action button: it has a 1dp square border (`RoundedCornerShape(10.dp)`) and sits tight against the right edge of the toolbar.

## Suspected Code Paths

- `app/src/main/res/values/strings.xml:104` — `chat_header_logo` is set to `"Scootie"` instead of `"Scottie"` (or `R.string.app_name` `"Scottie"` can be used).
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt:71-108` — `ScottieToolbar`'s `titleContent` renders a `Row` with a `32.dp` red `Surface` + `Icons.Rounded.SmartToy` icon before the title `Text`.
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt:110-128` — `ScottieToolbar`'s `actions` wraps the `TAG_CLEAR_CHAT` `IconButton` inside a bordered `Surface(shape = RoundedCornerShape(10.dp), border = BorderStroke(1.dp, colors.borderSubtle))` with no end padding.
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt:131-135` — UI test asserts `"Scootie"` text on `TAG_LOGO`.

## Root Cause Hypothesis

Confidence: high. Feature `011-relocate-model-selector` followed the literal typo `"Scootie"` from the initial prompt, kept the `SmartToy` brand icon badge from `ScottieToolbar`, and reused the previous `Surface` border wrapper without end margin for the trailing action `IconButton`.

## Proposed Remediation

**Preferred**:
1. Update `chat_header_logo` in `app/src/main/res/values/strings.xml` from `"Scootie"` to `"Scottie"` (or use `R.string.app_name` / keep `chat_header_logo` as `"Scottie"`).
2. In `InteracAssistantUi.kt`, simplify `titleContent` to render only the `Text` composable (removing the `Row`, `Surface`, and `Icons.Rounded.SmartToy` logo icon) with `Modifier.combinedClickable(...)`, `Modifier.semantics { heading() }`, and `Modifier.testTag(TAG_LOGO)`.
3. In `InteracAssistantUi.kt`, remove the wrapping `Surface` (and its `BorderStroke`) around the Clear Chat `IconButton`, and add end spacing (e.g., `Modifier.padding(end = 8.dp).size(36.dp).testTag(TAG_CLEAR_CHAT)`) so the icon is borderless and properly spaced from the end of the screen.
4. Update `InteracAssistantUiTest.kt` to assert `"Scottie"` instead of `"Scootie"`.

**Files likely to change**:
- `app/src/main/res/values/strings.xml`
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUi.kt`
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt`

**Tests to add or update**:
- Update `InteracAssistantUiTest.logoShowsScootieWithoutModelSelectorIgnoresSingleTapAndOpensSettingsOnLongPress` (and rename appropriately) to verify `"Scottie"` is displayed on `TAG_LOGO`.

## Risks & Considerations

- Low risk: UI-only change confined to the Chat screen header and its UI test. Long-press navigation (`TAG_LOGO`) and Clear Chat (`TAG_CLEAR_CHAT`) semantics and test tags remain intact.

## Open Questions

- None.
