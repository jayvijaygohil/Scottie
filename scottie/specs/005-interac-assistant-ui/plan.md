# Implementation Plan: Conversational Interac e-Transfer Assistant with AI-Generated UI

**Branch**: `005-interac-assistant-ui` | **Date**: 2026-10-06 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `specs/005-interac-assistant-ui/spec.md` plus the user's
planning constraints (installed stack, gaps 1–7, conventions, deliverables).

## Summary

A new Circuit screen in `feature/interacbanking` takes a typed request, runs a Koog agent on the
downloaded LiteRT model (Koog's own `LiteRTLLMClient`, already pulled in by
`koog-agents-additions`), and gets back a tiny structured `AssistantIntent`. The presenter resolves
recipients/accounts deterministically from the mock banking singleton, builds A2UI surfaces from
templates, renders them with `A2uiSurface`, and handles the surface's events: autocomplete
(`findContacts`, no model) and submit (direct `executeSendTransfer`/`executeRequestMoney`, so the
security answer never touches the model). Option **(b)** from research R4.

## Technical Context

**Language/Version**: Kotlin 2.4.20, JDK 17, AGP 9.4.1, minSdk 26 / targetSdk 37

**Primary Dependencies** (installed; none added, none upgraded): Compose 1.13.0-alpha03 + Material 3
1.5.0-alpha29; Slack Circuit 0.39.0 (codegen `hilt` mode); Hilt 2.60.1; Koog `koog-agents` 1.3.0 +
`koog-agents-additions` 1.3.0-beta (brings `prompt-executor-litert-client` → `litertlm-android`
0.11.0); AndroidX A2UI 1.0.0-alpha01 (`material3-a2ui`, `compose-runtime`, `compose-ui`, `engine`,
`model`, test: `compose-ui-testing`); RunAnywhere 0.20.27 (STT only, untouched)

**Storage**: none; in-memory mock banking singleton (resets on restart); model files on disk via the
existing download feature

**Testing**: JUnit 4, `kotlinx-coroutines-test`, Turbine, `circuit-test` (`FakeNavigator`,
`presenter.test`), Koog `agents-test` (`getMockExecutor`, `mockLLMAnswer`, `mockLLMToolCall`), A2UI
`compose-ui-testing` (`A2uiTestController`, androidTest), manual device run with network off

**Target Platform**: physical Android phone, offline; reference model Gemma 4 E2B
(`gemma-4-E2B-it.litertlm`), low-RAM alternative Qwen3 0.6B

**Project Type**: single-module Android app, feature-slice layout

**Performance Goals**: SC-002 first interactive card ≤ 8 s worst / ≤ 5 s median (warm) across the 11
example prompts; SC-003 autocomplete ≤ 200 ms per keystroke; cold engine init reported separately

**Constraints**: all inference on device; no banking data leaves the phone; security answer never
in model context, logs, or results; presenter/UI enforce channel, security, and submit rules
regardless of model output; no new third-party dependencies

**Scale/Scope**: 1 new screen, 1 cross-feature navigation seam (`TextModelDestination`), 1 `core/ai`
seam, ~6 custom A2UI components, 4 accounts, 6 contacts, 14 acceptance scenarios

## Constitution Check

*GATE: passes before Phase 0; re-checked after Phase 1 design (below).*

| Principle | Check | Status |
|---|---|---|
| I. Layered Clean Architecture | New code in `feature/interacbanking/{domain,data,presentation}`; the only shared seam is `core/ai/` (text generation, needed by two features); `domain/` imports Koog agent DSL only (allowed by III), no Android/Compose/runtime; `presentation/` imports `core/ui` and A2UI Compose libs, never `data/` (the insufficient-balance message comes from the domain interface); features do not import each other: `modeldownload` navigates through its own `TextModelDestination` seam, bound in `di/` to `InteracAssistantScreen` | PASS |
| II. Circuit-Driven Presentation | `InteracAssistantScreen` key + `InteracAssistantPresenter` (`@AssistedInject` Navigator, `@CircuitInject`) + `InteracAssistantUi`; business ops and navigation in presenter; all user-visible copy resolved by components via `stringResource` — A2UI JSON carries values and codes only; `Modifier` on root | PASS |
| III. Bounded AI Agents | Agent + instructions + fallback in `domain/agent/workflow/`; tools typed; `PromptExecutor` built in `core/ai` + `di/`, injected; no inference imports in domain | PASS |
| IV. Verified Changes | Presenter tests with fakes; agent tests with mock executor; banking tests; androidTest for form rules; device checklist; completion report must name evidence per layer | PASS (planned) |
| V. Simplicity | No new deps; one form component instead of function-expression validation; download runtimes not moved (R2); no model picker (id travels in the key); blocking banking calls kept with `withContext` wrapper (R8) | PASS |
| Tech constraints | Versions untouched; catalog aliases only; `.editorconfig`/detekt | PASS |

**Post-design re-check**: unchanged. Two placement choices are recorded in Complexity Tracking for
transparency; neither violates a principle.

## Architecture and data flow

```
user types "Send $20 to bob from my savings"  ──▶ InteracAssistantUi ──Action.Send──▶ Presenter
                                                                                        │
          ┌─────────────────────────────────────────────────────────────────────────────┘
          ▼
 IntentExtractor.extract(text)  = InteracAssistantAgent (domain/agent/workflow)
   AIAgent(promptExecutor ← core/ai LiteRTLLMClient, llmModel(modelId), functionalStrategy,
           toolRegistry ← {getAccountBalances, findContacts} same singleton as the service)
   ├─ requestLLM → (optional tool calls, ≤3 rounds, executed by Koog) → requestLLMStructured
   └─ AssistantIntent{SEND, 20.0, "bob", "savings"}            ◀── parse failure → OTHER + fallback
          │
          ▼  (Dispatchers.Default)
 Presenter resolution (domain/usecase/InteracResolution + InteracBankingTools)
   recipients = findContacts("bob")  → [Bob Vance 100]  → clear single → preselect
   accounts   = matchAccounts("savings") → [High-Interest Savings] → preselect
   eligible   = eligibleSources(all, 20.0) → Everyday, Joint, Savings (credit excluded)
   channelLocked = Bob has phone only → channel="PHONE", locked; securityRequired = true
          │
          ▼
 InteracSurfaceTemplates.sendForm(...) → 3 JSON lines  ──▶ A2uiBridge.accept(json) ──▶ processor
                                                                                        │
 A2uiSurface(surfaceModel) renders Column[Text, InteracForm]  ◀── activeSurfaces ◀──────┘
          │ user edits (bindUpdater → /form/*), types in recipient field
          ├─ action recipientQuery ──▶ outboundEvents ──▶ Presenter ──▶ findContacts ──▶ updateDataModel(/suggestions)
          └─ action submit (context = /form/*) ──▶ Presenter.validate(FormDraft)
                 ├─ invalid → updateDataModel(/form/valid=false) (component already disabled)
                 └─ valid → banking { executeSendTransfer(acc, Recipient.Saved("ct_bob"), 20.0, PHONE, q, a) }
                        ├─ TransferResult → deleteSurface(form) + Confirmation surface; balances already debited
                        └─ IllegalArgumentException → Alert component appended with message verbatim; /form/busy=false
```

Threading: agent call and banking calls run on `Dispatchers.Default` via `rememberCoroutineScope`
launches in the presenter; `collectMessages()` on `Dispatchers.Default` owned by the bridge, whose
lifetime is the presenter's retained scope; UI only renders state.

Error handling: `IllegalArgumentException` from the service → verbatim `Alert`; any other agent or
A2UI exception → turn reply `Fallback(string.assistant_fallback)` and no surface; parser/processor
errors arrive on `outboundEvents` as `A2uiClientErrorMessage` → same fallback, surface deleted. The
screen never shows an empty surface because a surface is created only after all three messages are
built successfully.

Model availability: the key carries `modelId`; the presenter checks the file exists under
`OnDeviceTextModels.dir`; if not → state `missingModel` and the UI shows
`assistant_model_missing` with a Back action (FR-027).

## Project Structure

### Documentation (this feature)

```text
specs/005-interac-assistant-ui/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/
│   ├── banking-tools.md
│   ├── assistant-intent.schema.json
│   └── a2ui-catalog.md
└── tasks.md              # /speckit-tasks output (not created here)
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
├── core/
│   └── ai/
│       └── OnDeviceTextModels.kt          # dir(context) = <filesDir>/models/litert; llModel(fileName): LLModel (LiteRTLLMProvider, Tools+Completion); BACKEND constant
├── di/
│   ├── AiModule.kt                        # @Provides @Singleton PromptExecutor = MultiLLMPromptExecutor(LiteRTLLMClient(LiteRTClientConfig(modelsPath, backend))); @Named("liteRtModelsDir") File
│   └── InteracModule.kt                   # object: @Provides ToolRegistry { tools(mock) }, ModelResolver, IntentExtractor = InteracAssistantAgent(...) (domain class has no DI annotations), TextModelDestination { InteracAssistantScreen(it) }; InteracBindingsModule interface: @Binds InteracBankingTools←Mock
├── feature/modeldownload/
│   ├── data/ai/provider/LiteRtModelRuntime.kt   # dir ← OnDeviceTextModels.dir(context)
│   └── presentation/
│       ├── TextModelDestination.kt        # fun interface TextModelDestination { fun screen(modelId: String): Screen } — this feature's only knowledge of "where a text model is used"
│       └── {ModelDownloadScreen,Presenter,Ui,component/ModelDownloadCard}.kt
│                                          # Action.UseModel(modelId) → navigator.goTo(destination.screen(modelId)); button on Downloaded TEXT cards
└── feature/interacbanking/
    ├── domain/
    │   ├── entities/InteracBanking.kt     # + Recipient, MoneyRequestResult.memo
    │   ├── agent/tools/InteracBankingTools.kt      # + saveContact, insufficientBalanceMessage; Recipient params; send/request not @Tool
    │   ├── agent/workflow/
    │   │   ├── AssistantIntent.kt         # @Serializable contract
    │   │   ├── IntentExtractor.kt         # fun interface IntentExtractor { suspend fun extract(text, modelId): AssistantIntent }; fun interface ModelResolver { fun resolve(modelId): LLModel }
    │   │   ├── InteracAssistantAgent.kt   # Koog AIAgent + functionalStrategy; OTHER on failure
    │   │   └── InteracAgentInstructions.kt         # rewritten (below)
    │   └── usecase/InteracResolution.kt   # matchAccounts, eligibleSources, eligibleDeposits, validateAmount, clearMatch
    ├── data/ai/tools/
    │   ├── MockInteracBankingTools.kt     # new rows, Recipient, saveContact, memo, credit rejection
    │   └── ContactMatcher.kt              # ranked fuzzy scorer (R6)
    └── presentation/
        ├── InteracAssistantScreen.kt      # @Parcelize data class InteracAssistantScreen(val modelId: String) : ParcelableScreen
        ├── InteracAssistantContract.kt    # State, AssistantTurn, TurnReply, Notice, Action
        ├── InteracAssistantPresenter.kt
        ├── InteracAssistantUi.kt          # ScottieToolbar + turns LazyColumn + A2uiSurface per surface + composer (ScottieSearchField-like input + XelaButton Send)
        └── a2ui/
            ├── A2uiBridge.kt              # interface + ProcessorA2uiBridge (parser, processor, collect loops, outbound flow)
            ├── InteracCatalog.kt          # catalog assembly
            ├── components/{InteracForm,BalanceCard,Badge,Alert,Confirmation}.kt
            └── InteracSurfaceTemplates.kt # pure functions → List<String> JSON

app/src/main/res/values/strings.xml      # assistant_* copy (title, composer hint, send, fallback, model_missing, off_topic, labels for form fields, badge text, statuses)

app/src/test/java/com/jayvijay/scottie/
├── feature/interacbanking/data/ai/tools/{MockInteracBankingToolsTest,ContactMatcherTest}.kt
├── feature/interacbanking/domain/usecase/InteracResolutionTest.kt
├── feature/interacbanking/domain/agent/workflow/InteracAssistantAgentTest.kt
├── feature/interacbanking/presentation/{InteracAssistantPresenterTest,FakeIntentExtractor,FakeA2uiBridge}.kt
└── feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt

app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt
```

**Structure Decision**: feature slice `interacbanking` gains `presentation/` and `domain/usecase/`;
the screen key stays inside that slice. The only shared code is the text-generation seam
(`core/ai`); the model-download feature reaches the assistant through its own `TextModelDestination`
interface, which `di/` binds to `InteracAssistantScreen`. The download runtimes stay put
(research R2).

## Phase 0 — Research

Complete: [research.md](research.md). Resolved: inference path (R1), `core/ai` scope (R2), agent
shape and tool fallback (R3), output channel (R4), A2UI facts and catalog shape (R5), fuzzy search
(R6), resolution rules (R7), threading (R8), DI (R9), navigation (R10), latency target (R11), test
strategy (R12). No `NEEDS CLARIFICATION` remains.

## Phase 1 — Design

- [data-model.md](data-model.md): entities, `Recipient`, `AssistantIntent`, presentation state,
  A2UI data paths, screen key.
- [contracts/banking-tools.md](contracts/banking-tools.md): updated tool contract, which methods the
  model sees, exact rejection strings, invariants.
- [contracts/assistant-intent.schema.json](contracts/assistant-intent.schema.json): the model's
  output schema with the 11 example prompts as examples (feeds the agent tests).
- [contracts/a2ui-catalog.md](contracts/a2ui-catalog.md): the catalog the presenter may emit,
  `InteracForm` bindings/actions, message sequence, rule → enforcement mapping.
- [quickstart.md](quickstart.md): classpath check, test commands, device script, latency table.

### Agent instructions (rewritten `INTERAC_AGENT_INSTRUCTIONS`)

```text
You are the Interac e-Transfer assistant inside a banking app. You only classify the user's request
and extract what they said. The app resolves contacts, accounts, channels, and performs actions.

Return exactly one JSON object with these fields and nothing else:
intent (BALANCE | SEND | REQUEST | OTHER), amount (number or null), recipientQuery (string or
null), accountHint (string or null), memo (string or null), channelHint (EMAIL | SMS | null),
reply (string or null).

Rules:
1. Copy values from the user's words. Never invent an amount, a recipient, or an account. If the
   user did not say it, use null.
2. recipientQuery is the raw name, email, or phone fragment ("bob", "Charly", "416-555-0143"). Never
   an id, never a corrected spelling.
3. accountHint is the raw account phrase ("savings", "my visa", "ending 4821", "TFSA"), even if no
   such account exists.
4. channelHint only when the user explicitly said email or text/SMS. Never guess a channel.
5. "Ask X for N", "request N from X", "get N from X" → REQUEST. "Send", "e-Transfer", "pay" → SEND.
   Balance, "how much", "what's in" → BALANCE.
6. You may call findContacts or getAccountBalances to check whether a name or account exists, but
   still return the user's raw words. Never attempt to send or request money.
7. Anything outside balances, sending, or requesting → intent OTHER with a one-sentence reply
   saying you can check balances, send an Interac e-Transfer, or request money.
```

Kept out of the prompt on purpose: channel/security/badge rules — those are presenter/template
rules now (FR-017/018), not model behaviour.

### Koog agent (domain/agent/workflow/InteracAssistantAgent.kt)

- `AIAgent(promptExecutor, llmModel = OnDeviceTextModels.llModel(modelId) /* via a domain-safe
  LLModel parameter */, strategy, toolRegistry, systemPrompt = INTERAC_AGENT_INSTRUCTIONS,
  temperature = 0.0, maxIterations = 6)`.
- `functionalStrategy<String, AssistantIntent>("interac-intent")`: `requestLLM(input)`; up to 3×
  `if (response has Tool.Call parts) executeTools + sendToolResults`; then
  `requestLLMStructured<AssistantIntent>()` with `StructureFixingParser(model, retries = 1)`;
  `.getOrNull()?.data ?: AssistantIntent(OTHER, reply = null)`.
- Agent created per request and `close()`d in `finally` (cheap; the executor/engine is the
  singleton). Run on `Dispatchers.Default`.
- Domain purity: `InteracAssistantAgent` has a plain constructor (no `javax.inject`) and no Android
  imports — it is constructed by `di/InteracModule` and does not log; the data-layer mock logs tool
  invocations for the device check.
- `IntentExtractor` is the domain seam the presenter and its tests use.

### Presenter behaviour (per FR)

| Action | Behaviour |
|---|---|
| `Send(text)` | `busy = true`; `extract(text)`; `when (intent)` → BALANCE: `matchAccounts(hint)` → cards (all + not-found Alert when empty hint match and hint non-null); SEND/REQUEST: resolve → templates → bridge; OTHER: text turn; exception → Fallback turn. Record `firstCardMs` when `surfaces` first contains the new surface id |
| `A2uiEvent(recipientQuery)` | `findContacts(q)` → `updateDataModel("/suggestions")` |
| `A2uiEvent(selectRecipient)` | recompute `channelLocked`, `securityRequired`, `channel=""` → `updateDataModel("/form", …)` |
| `A2uiEvent(submit)` | build `FormDraft` from context; `validate`; `banking { send/request }`; success → delete form surface + Confirmation surface; failure → Alert appended, `/form/busy=false` |
| `Back` | `navigator.pop()` |

Insufficient-balance pre-check (FR-016): when the user named an account and `amount >
balance`, the presenter does **not** show a form; it shows an Alert with the rejection text, that
account's `BalanceCard` (highlighted), and the eligible accounts that can cover the amount. The text
comes from `InteracBankingTools.insufficientBalanceMessage(account, amount)` on the **domain
interface**, which the service also uses in its `require(...)`, so presenter and service share one
string without the presenter importing `data/`.

Copy and codes (Constitution II): templates never embed user-visible text. The data model carries
values and codes (`mode`, `typeCode`, `statusCode`, `channelCode`, `noticeKind`/`noticeArg`); the
custom components resolve labels with `stringResource`. Verbatim service messages are the one kind
of runtime text that travels as data (`Alert.text`).

`channelHint` mapping: `SMS → DeliveryChannel.PHONE`, `EMAIL → EMAIL`; applied as the initial
`/form/channel` only when the preselected recipient has that channel and it is not locked;
otherwise ignored (FR-017). When the hinted channel is unavailable for the contact (Alice + SMS),
the presenter makes one service call with that channel inside `runCatching` — the service rejects
it at `destinationFor` before any state change — shows the verbatim message as an `Alert`, and
renders the form with the contact's single channel locked (FR-017 intact, scenario 12 satisfied,
one source of truth for the text).

### UI

`InteracAssistantUi`: `ScottieToolbar(title = assistant_title, subtitle = modelName)`; `LazyColumn`
of turns (user bubble text; reply = `Text`, `A2uiSurface(surfaceModel)` keyed by surface id, or
fallback text); bottom composer with `XelaTextField`-styled input and `XelaButton(Send, state =
if (busy) DISABLED else DEFAULT)`. Previews use `InteracAssistantState` with static turns and no
surfaces (A2UI models need a processor; the custom components get their own previews with literal
properties via `A2uiTestController` in androidTest, not `@Preview`).

### Model download entry point

`ModelDownloadCard` gains a secondary `XelaButton("Use with Interac assistant")` visible when
`status == Downloaded && type == TEXT`; `ModelDownloadAction.UseModel(modelId)` → presenter
`navigator.goTo(destination.screen(modelId))` where `destination: TextModelDestination` is injected.
`TextModelDestination` is a one-method `fun interface` declared in
`feature/modeldownload/presentation/`; `di/InteracModule` binds it to `{ InteracAssistantScreen(it) }`.
Neither feature imports the other; `di/` is the layer that wires concrete implementations. The
presenter test supplies a fake destination and asserts the navigated screen.

## Test strategy

| Suite | Scenario coverage |
|---|---|
| `MockInteracBankingToolsTest` (+) | FR-001..010; R6 ranking table; scenario 7 balance sequence; scenario 12 message; credit messages |
| `ContactMatcherTest` | each row of R6 incl. "zzz" → empty, phone formatting variants |
| `InteracResolutionTest` | FR-016 ordering (scenario 6), "TFSA" empty, "chequing" → 2, "ending 4821", amount validation (2 decimals, 0, negative, "abc") |
| `InteracAssistantAgentTest` | 11 example prompts → expected `AssistantIntent` (schema examples); `mockLLMToolCall(tools::findContacts, "Ali")` then answer; garbage answer → OTHER; captured prompts never contain `securityAnswer` |
| `InteracSurfaceTemplatesTest` | scenarios 1–6, 8–11: component presence, `/form/channel == ""` for Charlie/Jane, `channelLocked` for Alice/Bob, `securityRequired` truth table, account option order, prefilled values, manual mode for `sam@example.com` |
| `InteracAssistantPresenterTest` | busy flag; BALANCE → cards; SEND → one surface; submit → service called once with the answer and `FakeIntentExtractor` never called again; rejection → Alert text verbatim; OTHER → reply text; exception → fallback; missing model → `missingModel`; autocomplete event → `/suggestions` update without extractor call; scenario 14 single submit |
| `InteracFormTest` (androidTest) | submit disabled until valid; whitespace Q/A; masked answer (`password` semantics); no channel preselected; security fields toggle; writeback to paths; `submit` context contains all `/form/*`; `recipientQuery` event emitted |
| Device (quickstart §2–5) | all 14 acceptance scenarios, latency table, tool-call presence, leak grep |

## Risks and mitigations

| Risk | Likelihood / impact | Mitigation |
|---|---|---|
| Small model returns non-JSON or wrong fields | Med / Med | `temperature = 0`; schema + examples in prompt; `StructureFixingParser(retries = 1)`; lenient parse; failure → OTHER fallback (FR-024). Presenter never trusts ids/channels from the model anyway |
| LiteRT tool calling flaky or slow on the chosen model (Koog KDoc contradiction, R1) | Med / Low | Tools are read-only and optional; one constant flips `ToolRegistry.EMPTY`; correctness unaffected |
| A2UI alpha01 API drift / processor quirks (literal values not writable, `root` missing → surface stuck loading) | Med / Med | All messages from one template module with tests; every writable field is a path binding with initial data; `A2uiTestController` tests; client errors on `outboundEvents` → fallback + delete surface |
| `requestLLMStructured` has no manual-mode path for `LiteRTLLMProvider` | Low / Med | Fallback already specified: `requestLLMWithoutTools()` + `Json.decodeFromString` after fence stripping |
| Latency over target | Med / Med | Levers in order: shorten system prompt, drop tool schemas (`EMPTY`), `Backend.GPU()`, Qwen3 0.6B; cold init reported separately; engine kept warm via singleton executor |
| Engine init blocks or OOMs on low-RAM device | Low / High | Model compatibility already gated by download feature; executor singleton created lazily on first turn on `Dispatchers.Default`; exceptions → fallback turn |
| `litertlm-android` native libs / 16 KB page or ABI issues | Low / High | Already resolved in cache; `packaging.jniLibs.useLegacyPackaging = true` present; verify on device in quickstart §0/§2 |
| `AIAgentConfig` default serializer is Jackson on some variants | Low / Low | Use the simple `AIAgent(promptExecutor, llmModel, …)` factory; if serialization errors appear, pass `KotlinxSerializer()` as the existing test already does |
| Security answer leaks via logs | Low / High | Never log `FormDraft`; the only log lines are latency and tool names; quickstart §5 grep |
| Robert/Bob ambiguity misjudged | Low / Low | Threshold table in R6 with unit tests for the four named cases |

**Measured outcomes (2026-10-06)**: automated layers verified (126 unit tests, detekt, lint,
assembleDebug, androidTest compilation). Not measured: on-device inference, tool-calling behaviour,
latency (SC-002), autocomplete timing on device (SC-003), instrumented `InteracFormTest` /
`InteracAssistantUiTest` — no device or emulator was attached. Deviations from this plan: the
contact scorer lives in `domain/usecase/` (presenter needs scores; cannot import `data/`); form
text fields use Material 3 `OutlinedTextField` because `XelaTextField` owns its text in a
`MutableState` and cannot be driven by A2UI path bindings without a sync shim (the repo's own
`ScottieSearchField` already avoids it for the same reason); `litertlm-android:0.11.0` is declared
directly because Koog pulls it as a runtime-only transitive and `Backend` must compile; a manual
recipient is saved as a contact only after the service accepts the transfer, so a rejected submit
never leaves a stray contact; an invalid `submit` context (unreachable through the gated button)
is ignored and `/form/busy` reset rather than alerting; `firstCardMs` uses `System.currentTimeMillis`.

## Complexity Tracking

| Choice | Why | Simpler alternative rejected because |
|---|---|---|
| `TextModelDestination` fun interface in `feature/modeldownload/presentation/` + one `@Provides` in `di/` | `feature/modeldownload` must open the assistant without importing `feature/interacbanking`, and screen keys stay inside their feature's presentation boundary | Placing the key in `core/` would extend the `core/` layout for a single consumer and move a feature's screen identity outside its slice |
| `core/ai/` holds only the text-generation seam, not the download runtimes | Second feature needs "run this file", not download plumbing; runtimes depend on `modeldownload.domain.entities` | Full move would force `core/` → `feature/` imports or a large entity relocation with zero behaviour change (R2) |
| One `InteracForm` component rather than composing basic inputs | Spec rules must hold regardless of model output; basic `Button` cannot be disabled; function-expression validation needs unverified function names | Composition would duplicate validation in templates and functions and still need a custom submit button |
