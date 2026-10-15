# Bug Assessment: Vertically center Send button and top-align 2-line minimum Composer text field

- **Slug**: `composer-send-centered`
- **Created**: 2026-10-14
- **Source**: pasted text
- **Verdict**: valid
- **Severity**: low

## Report (verbatim or summarized)

> I want the send icon to be centered to top and bottom of the chat edit text so that when its size increases, the button still stays centered.
> Can we keep the min to two lines for edit text and not vertically center the text because maybe that's causing the cursor to be in the center when there's a hint that's two lines.

## Symptom

1. When the Chat composer input expands across multiple lines (up to `maxLines = 4`), the Send button (`TAG_SEND`) stays pinned to the bottom edge of the composer row instead of remaining vertically centered between the top and bottom of the chat text field.
2. When the composer is empty, the 2-line hint (`assistant_composer_hint`) expands the `decorationBox` `Box` to 2 lines while `field()` remains 1 line tall; `contentAlignment = Alignment.CenterStart` vertically centers the 1-line `field()`, causing the cursor to float between lines 1 and 2 of the hint and the box height to shrink to 1 line when typing starts.

## Reproduction

1. Open the Chat screen (`InteracAssistantScreen`) with an active model loaded so the `Composer` is visible.
2. Focus the empty composer input field: observe the cursor floating vertically centered between the two lines of the hint text, and the box shrinking when typing the first character.
3. Enter multi-line text into the composer input field (`BasicTextField`) so its height increases: observe the Send button (`FilledIconButton` with tag `TAG_SEND`) aligning with the bottom of the expanded text field rather than the vertical center.

## Suspected Code Paths

- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/component/ChatComponents.kt:195-227` — `Composer` uses `Row(..., verticalAlignment = Alignment.Bottom)` which pins the Send button to the bottom of the row, and `BasicTextField` lacks `minLines = 2` while its `decorationBox` `Box` uses `contentAlignment = Alignment.CenterStart`.

## Root Cause Hypothesis

High confidence:
1. `Composer` in `ChatComponents.kt` sets `verticalAlignment = Alignment.Bottom` on the outer `Row` (line 198), anchoring the `46.dp` `FilledIconButton` to the bottom edge instead of `Alignment.CenterVertically`.
2. `BasicTextField` in `Composer` does not set `minLines = 2` and its `decorationBox` `Box` uses `contentAlignment = Alignment.CenterStart`, which vertically centers the 1-line empty `field()` (and its cursor) inside the 2-line hint box.

## Proposed Remediation

**Preferred**:
1. Change `verticalAlignment = Alignment.Bottom` to `verticalAlignment = Alignment.CenterVertically` on the outer `Row` in `Composer` (`ChatComponents.kt:198`).
2. Add `minLines = 2` (alongside `maxLines = 4`) on `BasicTextField` in `Composer` and change `contentAlignment = Alignment.CenterStart` to `contentAlignment = Alignment.TopStart` on the `decorationBox` `Box`.

**Files likely to change**:
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/component/ChatComponents.kt`
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt`

**Tests to add or update**:
- Add a UI test in `InteracAssistantUiTest.kt` verifying that when multi-line input expands the composer, the vertical center of `TAG_SEND` remains aligned with the vertical center of `TAG_COMPOSER`.

## Risks & Considerations

- Minimal blast radius: only affects `Composer` in `ChatComponents.kt`.
- Keeping `minLines = 2` with `Alignment.TopStart` prevents height jitter between empty hint state (2 lines) and 1-line typed text while positioning the cursor at the top-start of line 1.

## Open Questions

- None.
