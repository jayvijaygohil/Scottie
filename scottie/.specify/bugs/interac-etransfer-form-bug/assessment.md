# Bug Assessment: Interac e-Transfer & Money Request Form Render Failure and Request Submit Mismatch

- **Slug**: interac-etransfer-form-bug
- **Created**: 2026-10-13
- **Source**: pasted text
- **Verdict**: valid
- **Severity**: high

## Report (verbatim or summarized)

> In the Interac banking assistant, checking account balances works and renders the balance cards as expected. However, whenever I ask the assistant to send an Interac e-Transfer or request money (for example, "Send $50 to Alice" or "Request $30 from Jane for dinner"), the form fails to render and the chat replies with "I couldn't build that form. Please try again." In addition, submitting a money request form does not complete a request flow as expected.

## Symptom

1. **Form render failure**: Asking the assistant to send an Interac e-Transfer (e.g., `"Send $50 to Alice"`) or request money (e.g., `"Request $30 from Jane for dinner"`) fails A2UI component schema validation during `updateComponents`, causing the processor to emit an `A2uiClientErrorMessage` (`VALIDATION_FAILED`) and the presenter to replace the turn with `TurnReply.Fallback` (`"I couldn't build that form. Please try again."`) instead of rendering `InteracForm`.
2. **Money request submission failure**: Submitting `InteracForm` in `"request"` mode omits `"mode"` from the `onSubmit` event context, causing `InteracAssistantPresenter.FormDraft.from` to default `mode` to `"send"` (`InteracForm.MODE_SEND`). Depending on whether the recipient has Autodeposit enabled, submission either silently aborts (missing security question/answer required only for send) or executes `executeSendTransfer` instead of `executeRequestMoney`.

## Reproduction

1. Open the Interac assistant screen with an active text model configured.
2. Send `"What's my balance?"` — observe that `BalanceCard` surfaces render as expected.
3. Send `"Send $50 to Alice"` or `"Request $30 from Jane for dinner"` — observe that the form fails to render and the reply card displays `"I couldn't build that form. Please try again."`.
4. Once `InteracForm` rendering is restored, open a money request form (e.g., `"Request $30 from Jane for dinner"`), select a deposit account and delivery channel if needed, and tap `"Send request"` — observe that `submit` dispatches without `"mode"` in `event.context`, so `FormDraft.from` treats the submission as `"send"` (`MODE_SEND`) rather than `"request"` (`MODE_REQUEST`).

## Suspected Code Paths

- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/components/InteracForm.kt:80-82` — Declares `Suggestions`, `Recipients`, and `Accounts` using `options(key)`.
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/components/InteracForm.kt:367-395` — `options(key)` calls `A2uiProperty.dynamicCustom(key = key, schema = A2uiArraySchema(...), safeCast = ...)`. Unlike `A2uiProperty.dynamicString`/`dynamicBoolean`, `dynamicCustom` uses the supplied `schema` directly without wrapping it in a `OneOf` that allows `A2uiDataBindingSchema` (`{"path": "..."}`).
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt:160-170` — `InteracSurfaceTemplates.form` binds `suggestions`, `recipients`, and `accounts` to data-model paths (`{"path": "/suggestions"}`, `{"path": "/options/recipients"}`, `{"path": "/options/accounts"}`) and constructs `onSubmit` with `FORM_FIELDS.associateWith { "/form/$it" }`.
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt:261-278` — `FORM_FIELDS` lists the path-bound form fields but omits `"mode"` (which is passed as a static `stringEnum` property on `InteracForm` at line 162, even though `/form/mode` is seeded in the data model at line 126).
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt:86-94` — Collects `A2uiClientErrorMessage` from `bridge.events`, deletes the surface, and sets the turn reply to `TurnReply.Fallback` (`R.string.assistant_fallback`: `"I couldn't build that form. Please try again."`).
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt:351-404, 447-480` — `FormDraft.from(context)` reads `val mode = text("mode").ifEmpty { InteracForm.MODE_SEND }`. When `"mode"` is absent from `event.context`, `mode` defaults to `"send"`, causing `FormDraft.from` to enforce send-only security question/answer checks (line 465) and `perform(draft)` to call `banking.executeSendTransfer(...)` instead of `banking.executeRequestMoney(...)` (lines 356-386).
- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/FakeA2uiBridge.kt:82-84` — `FakeA2uiBridge.submitContext()` reads all keys from `/form` in `rootData()` (which includes `"mode"`) instead of the `onSubmit` action's bound `context`, masking the missing `"mode"` binding in unit tests.

## Root Cause Hypothesis

**High confidence.** Two bugs in the A2UI form contract and template wiring explain both symptoms:
1. In `InteracForm.options(key)` (`InteracForm.kt:367-384`), `A2uiProperty.dynamicCustom` is given a bare `A2uiArraySchema(...)` instead of a schema that also permits data-model path bindings (`A2uiDataBindingSchema`). When `ProcessorA2uiBridge` feeds `InteracSurfaceTemplates.form(...)` into `A2uiMessageProcessor`, `A2uiCoreSurfaceModel.validateComponent` validates the raw component properties before data evaluation. Because `"suggestions"`, `"recipients"`, and `"accounts"` are JSON Pointer binding maps (`{"path": "..."}`), `A2uiCoreSchemaValidator.validateArray` rejects them with `A2uiValidationException("Expected an array, but instead got: {path=/suggestions}")`, emitting `A2uiClientErrorMessage(code = "VALIDATION_FAILED")` and triggering `TurnReply.Fallback`. `BalanceCard` succeeds because all of its properties use `dynamicString`/`dynamicBoolean`, whose built-in schemas allow `A2uiDataBindingSchema`.
2. In `InteracSurfaceTemplates.form` (`InteracSurfaceTemplates.kt:169, 261-278`), `onSubmit` builds its event context from `FORM_FIELDS.associateWith { "/form/$it" }`, but `FORM_FIELDS` omits `"mode"`. Consequently, the `submit` client event never includes `"mode"` in `event.context` (which `InteracFormTest.submitCarriesEveryFormValue` at `InteracFormTest.kt:187` explicitly expects). In `InteracAssistantPresenter.FormDraft.from` (`InteracAssistantPresenter.kt:449`), `text("mode").ifEmpty { InteracForm.MODE_SEND }` falls back to `"send"`, so submitting a money request either fails validation on missing security question/answer (for non-autodeposit or manual requestees) or executes a send transfer instead of a money request (for autodeposit requestees).

## Proposed Remediation

**Preferred**:
1. In `InteracForm.kt` (`options(key)`), update the `A2uiProperty.dynamicCustom` schema so it accepts either a data-binding object (`A2uiDataBindingSchema.DEFAULT_INSTANCE`) or the literal `A2uiArraySchema(...)` (using `A2uiAnySchema(keywords = listOf(A2uiSchemaKeyword.OneOf(listOf(A2uiDataBindingSchema.DEFAULT_INSTANCE, A2uiArraySchema(...)))))`).
2. In `InteracSurfaceTemplates.kt` (`form`), include `"mode" to "/form/mode"` in the `onSubmit` event context map (e.g., `(FORM_FIELDS + "mode").associateWith { "/form/$it" }`) so the submitted event context always carries the form's `mode` (`"send"` or `"request"`), matching `/form/mode` in the data model and `InteracFormTest.submitCarriesEveryFormValue`.
3. Update `FakeA2uiBridge.submitContext()` in unit tests to resolve keys from the `onSubmit` event context bindings on the `form` component (or verify the real `ProcessorA2uiBridge` / `onSubmit` bindings in unit tests) so tests catch any mismatch between `onSubmit` context bindings and `/form` data.

**Alternatives** (optional):
- Use `A2uiDynamicValueSchema.DEFAULT_INSTANCE` for `options(key)` in `InteracForm.kt`: simpler schema declaration, but loses the itemized object schema documentation for inline catalog export (`toJsonSchemaString()`). Keeping `OneOf(A2uiDataBindingSchema.DEFAULT_INSTANCE, A2uiArraySchema(...))` preserves the exact item schema while permitting path bindings.
- Bind `mode` as a dynamic property in `FORM_FIELDS`: unnecessary because `mode` never changes after surface creation and `InteracForm` intentionally declares `Mode` as a static `stringEnum`.

**Files likely to change**:
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/components/InteracForm.kt`
- `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt`
- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/FakeA2uiBridge.kt`
- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt`
- `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`

**Tests to add or update**:
- `InteracSurfaceTemplatesTest`: Assert that `onSubmit` event context binds `/form/mode` in addition to `FORM_FIELDS`, and validate `InteracSurfaceTemplates.form`, `balanceCards`, and `confirmation` envelopes against `ProcessorA2uiBridge` / `interacCatalog()` with zero `A2uiClientErrorMessage` emissions.
- `FakeA2uiBridge` / `InteracAssistantPresenterTest`: Derive `submitContext` from the `form` component's `onSubmit` event context bindings so request-flow submission tests exercise the actual bound keys.
- `InteracFormTest` (androidTest): Run on a connected device/emulator to verify `A2uiTestController` schema validation and `submitCarriesEveryFormValue` pass end-to-end.

## Risks & Considerations

- **Catalog schema export**: `InteracCatalog` has `isInline = true`. Wrapping the array schema in `OneOf` with `A2uiDataBindingSchema.DEFAULT_INSTANCE` matches how A2UI's built-in dynamic schemas (`createDynamicTypeSchema`) are structured.
- **No migration or API breakage**: Changes are internal to `feature/interacbanking/presentation/a2ui/`.

## Open Questions

- None.
