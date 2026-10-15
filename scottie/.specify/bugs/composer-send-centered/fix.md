# Bug Fix: Vertically center Send button and top-align 2-line minimum Composer text field

- **Slug**: `composer-send-centered`
- **Fixed**: 2026-10-15
- **Assessment**: ./assessment.md
- **Status**: applied

## Summary

Changed the `Composer` outer `Row` vertical alignment from `Alignment.Bottom` to `Alignment.CenterVertically` so the Send button stays vertically centered with the text field, set `minLines = 2` on `BasicTextField`, and changed the `decorationBox` `Box` `contentAlignment` from `Alignment.CenterStart` to `Alignment.TopStart` so the cursor aligns with the top line of the 2-line hint and height stays stable at 2–4 lines.

## Changes

| File | Change | Notes |
|------|--------|-------|
| `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/component/ChatComponents.kt` | modified | Set `Composer` `Row` `verticalAlignment = Alignment.CenterVertically`, added `minLines = 2` to `BasicTextField`, and changed `decorationBox` `Box` `contentAlignment` to `Alignment.TopStart`. |
| `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt` | added test | Added `sendButtonStaysVerticallyCenteredWhenComposerExpandsMultiline` asserting vertical center alignment of `TAG_SEND` with `TAG_COMPOSER`. |

## Diff Highlights (optional)

```kotlin
  Row(
    modifier = modifier.fillMaxWidth().testTag(TAG_COMPOSER),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Surface(
      modifier = Modifier.weight(1f).border(1.dp, colors.borderSubtle, ComposerShape),
      shape = ComposerShape,
      color = colors.surfaceCard,
      shadowElevation = 2.dp,
    ) {
      BasicTextField(
        value = value,
        onValueChange = onValueChange,
        minLines = 2,
        maxLines = 4,
        textStyle = textStyle,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        decorationBox = { field ->
          Box(
            modifier = Modifier.heightIn(min = 46.dp).padding(horizontal = 16.dp, vertical = 12.dp),
            contentAlignment = Alignment.TopStart,
          ) {
```

## Tests Added or Updated

- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt::sendButtonStaysVerticallyCenteredWhenComposerExpandsMultiline` — verifies `TAG_SEND` vertical center matches `TAG_COMPOSER` vertical center when multi-line text expands the composer.

## Local Verification

- Commands run: `./gradlew :app:assembleDebug :app:compileDebugAndroidTestKotlin :app:testDebugUnitTest :app:detekt :app:lintDebug` → PASS (BUILD SUCCESSFUL)
- Manual checks: Verified source diff and Compose layout hierarchy in `Composer`.

## Deviations from Assessment

None.

## Follow-ups

- Execute `/speckit-bug-test slug=composer-send-centered` (or run `InteracAssistantUiTest` on an emulator/device without Xiaomi ADB install restrictions).
