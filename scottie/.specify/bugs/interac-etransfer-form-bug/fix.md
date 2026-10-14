# Bug Fix: Interac e-Transfer & Money Request Form Render Failure and Request Submit Mismatch

- **Slug**: interac-etransfer-form-bug
- **Fixed**: 2026-10-13
- **Assessment**: ./assessment.md
- **Status**: applied

## Summary

Updated `InteracForm.options(key)` to wrap its array schema in `A2uiSchemaKeyword.OneOf` alongside `A2uiDataBindingSchema.DEFAULT_INSTANCE` so JSON Pointer data-binding objects (`{"path": "/suggestions"}`, `{"path": "/options/recipients"}`, `{"path": "/options/accounts"}`) pass `A2uiCoreSchemaValidator`, and added `"mode"` (`{"path": "/form/mode"}`) to the `onSubmit` event context in `InteracSurfaceTemplates.form` so money-request submissions preserve `mode = "request"`.

## Changes

| File | Change | Notes |
|------|--------|-------|
| `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/components/InteracForm.kt` | modified | Wrapped `options(key)` `A2uiProperty.dynamicCustom` schema in `A2uiAnySchema` with `OneOf(A2uiDataBindingSchema.DEFAULT_INSTANCE, A2uiArraySchema(...))` |
| `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt` | modified | Included `"mode"` in `onSubmit` event context mapping (`(FORM_FIELDS + "mode").associateWith { "/form/$it" }`) |
| `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/FakeA2uiBridge.kt` | modified | Resolved `submitContext` from the form component's `onSubmit.event.context` path bindings instead of returning raw `form()` data; scoped `components()` to merge `updateComponents` envelopes for the latest surface |
| `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt` | modified | Added `submit` assertion on a money-request turn (`turn-3`) in `requestFlow` to verify `banking.requests` increments and `banking.sends` remains `0` |
| `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt` | modified | Asserted `/form/mode` in `onSubmit.event.context` and added `templatesPassCatalogValidationInProcessor` validating send/request/balance/confirmation templates against `A2uiMessageProcessor(listOf(interacCatalog()))` |
| `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt` | modified | Updated `requestModeShowsMemoAndNoSecurity` to tap `"Send request"` and assert `submit.context["mode"] == "request"` with 0 `outboundErrors` |
| `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantUiTest.kt` | modified | Passed `InferenceFailure.UNKNOWN` to `TurnReply.Failed(...)` so `:app:compileDebugAndroidTestKotlin` compiles cleanly |

## Diff Highlights (optional)

```kotlin
// InteracForm.kt
private fun options(key: String) =
  A2uiProperty.dynamicCustom(
    name = key,
    isRequired = true,
    schema =
      A2uiAnySchema(
        keywords =
          listOf(
            A2uiSchemaKeyword.OneOf(
              listOf(
                A2uiDataBindingSchema.DEFAULT_INSTANCE,
                A2uiArraySchema(
                  items =
                    A2uiObjectSchema(
                      properties =
                        mapOf(
                          "id" to A2uiStringSchema.DEFAULT_INSTANCE,
                          "label" to A2uiStringSchema.DEFAULT_INSTANCE,
                          "detail" to A2uiStringSchema.DEFAULT_INSTANCE,
                          "autodeposit" to A2uiBooleanSchema.DEFAULT_INSTANCE,
                        ),
                      required = setOf("id", "label", "detail"),
                    )
                ),
              )
            )
          )
      ),
  )
```

```kotlin
// InteracSurfaceTemplates.kt
put("onSubmit", event("submit", (FORM_FIELDS + "mode").associateWith { "/form/$it" }))
```

## Tests Added or Updated

- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt::formEmitsThreeEnvelopesWithEveryWritableFieldBound` — pins `/form/mode` binding in `onSubmit.event.context`.
- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt::templatesPassCatalogValidationInProcessor` — feeds send form, request form, balance cards, and confirmation templates through `A2uiMessageProcessor(listOf(interacCatalog()))` and asserts all 4 surfaces activate with zero `A2uiClientErrorMessage`s.
- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt::requestFlow` — submits a money request form using `bridge.submitContext(...)` (resolved from `onSubmit.event.context`) and verifies `banking.requests` increments without triggering `banking.sends`.
- `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt::requestModeShowsMemoAndNoSecurity` — clicks `"Send request"` in `A2uiTestSurface` and asserts `submit.context["mode"] == "request"` with empty `outboundErrors`.

## Local Verification

- Commands run:
  - `./gradlew :app:compileDebugAndroidTestKotlin :app:testDebugUnitTest :app:detekt` → `BUILD SUCCESSFUL`
  - `./gradlew :app:assembleDebug` → `BUILD SUCCESSFUL`
- Manual checks: Inspected `git diff` across modified production and test files.

## Deviations from Assessment

- In `InteracSurfaceTemplatesTest`, `A2uiMessageProcessor(listOf(interacCatalog()))` is fed via `processMessage(...)` rather than `ProcessorA2uiBridge.accept(...)` because `A2uiMessageParser` in `androidx.a2ui.compose.runtime` delegates to `android.util.JsonReader`, which returns stub defaults (`null`/`false`) in uninstrumented JVM unit tests. `processMessage` exercises the identical `A2uiCoreSurfaceActor`, `A2uiCoreSurfaceModel.validateComponent`, and `A2uiCoreSchemaValidator` pipeline on the JVM.
- Scope expanded by 1 line in `InteracAssistantUiTest.kt:76` (`TurnReply.Failed(InferenceFailure.UNKNOWN)`) to unblock `:app:compileDebugAndroidTestKotlin`.

## Follow-ups

- Run `/speckit-bug-test slug=interac-etransfer-form-bug` (and `:app:connectedDebugAndroidTest` if a device or emulator is connected).
