# Tasks: Conversational Interac e-Transfer Assistant with AI-Generated UI

**Input**: Design documents from `specs/005-interac-assistant-ui/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/, quickstart.md

**Tests**: Requested by the feature owner ("add tests for every new behaviour"; plan test strategy).
Test tasks are included and should be written before or alongside the code they cover.

**Organization**: Phases 1–2 build shared infrastructure (model → agent → text reply round trip).
Phases 3–6 map to spec user stories US1 (send, P1), US2 (balances, P2), US3 (request, P3), US4
(errors/fallback, P3). Phase 7 is device verification and polish.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: parallelizable (different files, no dependency on an incomplete task)
- **[Story]**: US1–US4 from spec.md
- Paths are relative to the repository root. Source root: `app/src/main/java/com/jayvijay/scottie/`
  (abbreviated `SRC/` below); tests: `app/src/test/java/com/jayvijay/scottie/` (`TEST/`);
  instrumented: `app/src/androidTest/java/com/jayvijay/scottie/` (`ATEST/`).

## Conventions that apply to every task

- Kotlin, two-space indent, 100-char lines, detekt clean. User-visible copy in
  `app/src/main/res/values/strings.xml` with the `assistant_` prefix; ids, service messages, names
  stay runtime data.
- Verify A2UI/Koog signatures against `.agents/skills/android-a2ui-compose` and
  `.agents/skills/jetbrains-koog` (installed A2UI 1.0.0-alpha01, Koog 1.3.0 / 1.3.0-beta). No
  dependency upgrades.
- Do not log `FormDraft`, security answers, or prompts containing them.

---

## Phase 1: Setup (shared infrastructure)

**Purpose**: Confirm the inference client is available and create the two shared seams.

- [X] T001 Verify the LiteRT client is on the classpath: run `./gradlew :app:dependencies --configuration debugRuntimeClasspath | grep -E "litert|litertlm"` from the repo root and record the result in `specs/005-interac-assistant-ui/quickstart.md` §0. If `prompt-executor-litert-client-android:1.3.0-beta` is missing, add alias `koog-prompt-executor-litert = { group = "ai.koog", name = "prompt-executor-litert-client", version.ref = "koogAdditions" }` to `gradle/libs.versions.toml` and `implementation(libs.koog.prompt.executor.litert)` to `app/build.gradle.kts`.
- [X] T002 [P] Create `SRC/core/ai/OnDeviceTextModels.kt`: `object OnDeviceTextModels { fun dir(context: Context): File = File(context.filesDir, "models/litert"); fun llModel(fileName: String): LLModel }` where `llModel` returns the matching entry from `LiteRTLLModels.models` by `id`, else `LLModel(provider = LiteRTLLMProvider, id = fileName, capabilities = listOf(LLMCapability.Tools, LLMCapability.Completion), contextLength = 32_000, maxOutputTokens = 1_024)`; add `val BACKEND: Backend = Backend.CPU()` with a `// ponytail: CPU until measured; GPU()/NPU(nativeLibraryDir) are the levers` comment.
- [X] T003 [P] Create `SRC/feature/interacbanking/presentation/InteracAssistantScreen.kt`: `@Parcelize data class InteracAssistantScreen(val modelId: String) : ParcelableScreen` with KDoc "modelId is the `.litertlm` file name from the model catalog". Also create `SRC/feature/modeldownload/presentation/TextModelDestination.kt`: `fun interface TextModelDestination { fun screen(modelId: String): Screen }` with KDoc "Where a downloaded text model is used; bound in `di/` so this feature never imports the feature that owns that screen".
- [X] T004 Replace the hard-coded directory in `SRC/feature/modeldownload/data/ai/provider/LiteRtModelRuntime.kt` `@Inject constructor` with `OnDeviceTextModels.dir(context)`; keep `LiteRtModelRuntimeTest` green.
- [X] T005 [P] Create `SRC/di/AiModule.kt` (`@Module @InstallIn(SingletonComponent::class) object AiModule`) providing `@Singleton PromptExecutor` = `MultiLLMPromptExecutor(LiteRTLLMClient(LiteRTClientConfig(defaultModel = LiteRTLLModels.Gemma4E2B, modelsPath = OnDeviceTextModels.dir(context).path, backend = OnDeviceTextModels.BACKEND)))`; KDoc: singleton keeps the LiteRT engine warm across screens; `close()` uses `runBlocking` so never call it on main. Also `@Provides @Named("liteRtModelsDir") fun modelsDir(@ApplicationContext context: Context): File = OnDeviceTextModels.dir(context)`.
- [X] T006 [P] Add string resources to `app/src/main/res/values/strings.xml`: `assistant_title` ("Interac assistant"), `assistant_composer_hint`, `assistant_send`, `assistant_thinking`, `assistant_fallback` ("I couldn't build that form. Please try again."), `assistant_model_missing` ("Download a text model first, then open the assistant from its card."), `assistant_off_topic` ("I can check your balances, send an Interac e-Transfer, or request money."), `assistant_use_model` ("Use with Interac assistant"), form labels (`assistant_form_send_title`, `assistant_form_request_title`, `assistant_field_amount`, `assistant_field_recipient`, `assistant_field_manual_email`, `assistant_field_manual_phone`, `assistant_save_contact`, `assistant_field_account_source`, `assistant_field_account_deposit`, `assistant_channel`, `assistant_channel_email`, `assistant_channel_sms`, `assistant_field_security_question`, `assistant_field_security_answer`, `assistant_field_memo`, `assistant_submit_send`, `assistant_submit_request`, `assistant_badge_autodeposit` ("Autodeposit Active")), account types (`assistant_account_type_chequing`, `assistant_account_type_savings`, `assistant_account_type_credit`, `assistant_account_type_loc`), statuses (`assistant_status_sent`, `assistant_status_pending` ("Pending security answer"), `assistant_status_request_sent`), confirmation labels (`assistant_conf_reference`, `assistant_conf_amount`, `assistant_conf_recipient`, `assistant_conf_requestee`, `assistant_conf_channel`, `assistant_conf_account_source`, `assistant_conf_account_deposit`, `assistant_conf_memo`, `assistant_conf_time`), `assistant_account_not_found` ("I couldn't find an account matching \"%1$s\". Here are all your accounts."), `assistant_no_account_covers` ("None of your accounts can cover %1$s."), `assistant_alert_title_error` ("Couldn't complete that"), `assistant_alert_title_info` ("Heads up"), `assistant_latency_debug` ("first card %1$d ms").

**Checkpoint**: `./gradlew :app:assembleDebug` passes; T001 result recorded.

---

## Phase 2: Foundational (blocking prerequisites)

**Purpose**: Banking data/capabilities per contract, deterministic resolution, the Koog agent, DI,
the A2UI bridge/catalog shell, and a screen that turns typed text into a text reply. After this
phase, "What's the weather?" yields the off-topic reply on device; no forms yet.

### Domain entities and tool contract

- [X] T007 Update `SRC/feature/interacbanking/domain/entities/InteracBanking.kt`: add `sealed interface Recipient { data class Saved(val contactId: String) : Recipient; data class Manual(val email: String?, val phoneNumber: String?) : Recipient }` (Manual requires ≥ 1 non-null, enforced in the service), add `val memo: String?` to `MoneyRequestResult` (last parameter, default `null`), keep all existing types.
- [X] T008 Update `SRC/feature/interacbanking/domain/agent/tools/InteracBankingTools.kt` per `contracts/banking-tools.md`: `executeSendTransfer(fromAccountId: String, recipient: Recipient, amount: Double, deliveryChannel: DeliveryChannel, securityQuestion: String? = null, securityAnswer: String? = null)`, `executeRequestMoney(recipient: Recipient, depositAccountId: String, amount: Double, deliveryChannel: DeliveryChannel, memo: String? = null)`, new `saveContact(name: String, email: String?, phoneNumber: String?): InteracContact`, and new `fun insufficientBalanceMessage(account: Account, amount: Double): String` (pure formatter; the presenter uses it for the FR-016 pre-check so the text matches the service rejection verbatim without importing `data/`); KDoc states send/request/saveContact are not model tools.

### Banking service

- [X] T009 [P] *(placed in `SRC/feature/interacbanking/domain/usecase/ContactMatcher.kt` — the presenter needs the scores and may not import `data/`)* Create `SRC/feature/interacbanking/data/ai/tools/ContactMatcher.kt`: `internal fun rankContacts(query: String, contacts: List<InteracContact>): List<InteracContact>` implementing research R6 exactly — normalise lowercase/trim, phone to digits, digit-only query when ≥ 4 digits and no letters; scores exact 100 / prefix 80 / substring 60 / Damerau-Levenshtein ≤ 2 on a name token with query ≥ 4 chars → 40 / else excluded; sort by score desc then name; also `internal fun contactScore(query, contact): Int` for tests.
- [X] T010 [P] *(at `TEST/feature/interacbanking/domain/usecase/ContactMatcherTest.kt`)* Create `TEST/feature/interacbanking/data/ai/tools/ContactMatcherTest.kt` covering the R6 table: "Charly"→[Charlie]; "Ali"→[Alice, Alicia] both 80; "Bob"→Bob 100 and Robert excluded; "Rob"→Robert 80 then Bob 40; "4165550143" and "416-555-0143"→Bob 100; "charlie.c@example.ca"→100; "EXAMPLE.CA"→Charlie 60; "zzz"→empty; blank→all.
- [X] T011 Update `SRC/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt`: accounts add `Account("acc_chk_303", "Joint Chequing", CHEQUING, "**** 1177", 85.40)` and `Account("acc_cc_404", "Rewards Visa", CREDIT, "**** 3092", 2500.00)`; contacts add `ct_jane` Jane Doe (jane.doe@example.com, +1-905-555-0122, autodeposit true), `ct_alicia` Alicia Moreno (alicia.moreno@example.com, null, false), `ct_robert` Robert Singh (null, +1-289-555-0177, true); make `contacts` a synchronized `MutableList`; `findContacts` → `rankContacts`; implement `saveContact` (`"ct_" + 8 alphanumerics`, autodeposit false, rejects blank name with "Enter a name for the contact." and no destination with "Enter an email or a phone number for the recipient."); `resolve(recipient: Recipient): InteracContact` (Saved → lookup or "Contact <id> not found."; Manual → transient contact named by email ?: phone, autodeposit false, same no-destination message); send rejects CREDIT source with "<name> is a credit card and can't be used to send money."; request rejects CREDIT deposit with "<name> is a credit card and can't receive a money request."; request result carries `memo`; implement `insufficientBalanceMessage(account, amount)` returning `"Insufficient balance in <name>: available <balance>, requested <amount>."` and use it in the send path's `require(...)`; remove `@Tool`/`@LLMDescription` from `executeSendTransfer` and `executeRequestMoney` (keep them on `getAccountBalances`, `findContacts`); in `findContacts` add `Log.d("InteracBanking", "tool=findContacts q=<query>")` so the device tool-call check (T054) has a logcat signal — the data layer may use Android.
- [X] T012 Extend `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt`: keep the existing 16 tests passing (update constructor calls to `Recipient.Saved`); add tests for 4 accounts / 6 contacts listed; credit send and request rejections with exact messages; manual recipient send → PENDING to the typed email with security Q/A, rejected without; manual recipient with neither → exact message; `saveContact` appears in `findContacts` with autodeposit false; request memo echoed; scenario 7 sequence ($1,500 twice → second rejected; fresh instance resets); scenario 12 message `"Alice Martin has no phone number for PHONE delivery."`; a send or request with a channel the contact lacks is rejected with the exact `destinationFor` message and leaves balances unchanged (guards the presenter's explicit-channel pre-check in T038/T045); result objects never contain the answer.

### Deterministic resolution (domain)

- [X] T013 [P] Create `SRC/feature/interacbanking/domain/usecase/InteracResolution.kt` with pure functions per research R7: `matchAccounts(hint: String?, accounts: List<Account>): List<Account>` (null/blank → all; `savings`→SAVINGS; `chequing|checking`→CHEQUING; `visa|credit|card`→CREDIT; `ending NNNN` or bare 4 digits → mask suffix; else case-insensitive name substring; none → empty), `eligibleSources(accounts, amount: Double?)` (non-CREDIT, balance ≥ amount when given, CHEQUING before SAVINGS, stable), `eligibleDeposits(accounts)` (non-CREDIT, same order), `validateAmount(text: String): Double?` (`BigDecimal`, > 0, scale ≤ 2, else null), `clearMatch(ranked: List<Pair<InteracContact, Int>>): InteracContact?` (top ≥ 80 and (single or top − second ≥ 30)).
- [X] T014 [P] Create `TEST/feature/interacbanking/domain/usecase/InteracResolutionTest.kt`: "savings"→[High-Interest Savings]; "my chequing"→[Everyday, Joint]; "ending 4821"/"4821"→[Everyday]; "my visa"→[Rewards Visa]; "TFSA"→empty; null→all 4; `eligibleSources(all, 100.0)`→[Everyday, Savings] (scenario 6); `eligibleSources(all, 2000.0)`→[Savings]; `eligibleSources(all, null)`→[Everyday, Joint, Savings]; `eligibleDeposits`→[Everyday, Joint, Savings]; amounts "50", "50.5", "50.25" valid, "50.255", "0", "-1", "abc", "" invalid; `clearMatch` for Ali/Bob/Rob/Charly cases.

### Agent

- [X] T015 [P] Create `SRC/feature/interacbanking/domain/agent/workflow/AssistantIntent.kt`: `@Serializable data class AssistantIntent(val intent: Intent, val amount: Double? = null, val recipientQuery: String? = null, val accountHint: String? = null, val memo: String? = null, val channelHint: ChannelHint? = null, val reply: String? = null)` with `enum class Intent { BALANCE, SEND, REQUEST, OTHER }`, `enum class ChannelHint { EMAIL, SMS }`, each property annotated `@property:LLMDescription(...)` using the descriptions from `contracts/assistant-intent.schema.json`; companion `val FALLBACK = AssistantIntent(Intent.OTHER)`.
- [X] T016 [P] Create `SRC/feature/interacbanking/domain/agent/workflow/IntentExtractor.kt`: `fun interface IntentExtractor { suspend fun extract(text: String, modelId: String): AssistantIntent }` and, in the same file, `fun interface ModelResolver { fun resolve(modelId: String): LLModel }` (Koog `LLModel` is a prompt-model type, allowed in `domain/agent/`).
- [X] T017 [P] Rewrite `SRC/feature/interacbanking/domain/agent/workflow/InteracAgentInstructions.kt` with the exact instruction text from plan.md "Agent instructions (rewritten)" (7 rules, JSON-only output, never invent, raw recipient/account phrases, channelHint only when explicit, may call `findContacts`/`getAccountBalances`, never send/request, OTHER with one-sentence reply).
- [X] T018 Step 0: run `python3 .agents/skills/jetbrains-koog/scripts/lookup.py api AIAgentFunctionalContext` and `... api requestLLMStructured`; record in `specs/005-interac-assistant-ui/research.md` R3 the exact names of the functional-context tool-execution helper(s) and the structured-request overload (incl. the fixing-parser parameter). If 1.3.0 has no functional-context tool-execution helper, implement the strategy as the verified graph form instead (`nodeLLMRequest → nodeExecuteTools → nodeLLMSendToolResults`, `research.md`/skill `examples.md`) ending in a structured-request node, and use the `AIAgentGraphStrategy` factory overload. Then create `SRC/feature/interacbanking/domain/agent/workflow/InteracAssistantAgent.kt` (`class InteracAssistantAgent(private val executor: PromptExecutor, private val toolRegistry: ToolRegistry, private val models: ModelResolver) : IntentExtractor` — plain constructor, no `javax.inject`; constructed in `di/`): per request build `AIAgent(promptExecutor = executor, llmModel = models.resolve(modelId), strategy = INTENT_STRATEGY, toolRegistry = toolRegistry, systemPrompt = INTERAC_AGENT_INSTRUCTIONS, temperature = 0.0, maxIterations = 6)`; `INTENT_STRATEGY = functionalStrategy<String, AssistantIntent>("interac-intent") { input -> var r = requestLLM(input); repeat(3) { if (r has MessagePart.Tool.Call) r = <tool-execution helper from Step 0>(r) else return@repeat }; requestLLMStructured<AssistantIntent>(<fixing-parser parameter from Step 0> = StructureFixingParser(model, retries = 1)).getOrNull()?.data ?: AssistantIntent.FALLBACK }`; on any exception return `FALLBACK`; `close()` the agent in `finally`; run under `withContext(Dispatchers.Default)`; no logging in this domain file (no Android imports). `ModelResolver` is bound in DI to `OnDeviceTextModels::llModel` so the domain file does not import `core/ai`.
- [X] T019 Create `TEST/feature/interacbanking/domain/agent/workflow/InteracAssistantAgentTest.kt` using `getMockExecutor { mockLLMAnswer(json) onRequestContains prompt }` for each of the 13 `examples` in `contracts/assistant-intent.schema.json` (assert the decoded `AssistantIntent`); a tool round-trip case `mockLLMToolCall(tools::findContacts, "Ali")` then `mockLLMAnswer(sendJson)`; a garbage answer (`"sure thing"`) → `FALLBACK`; a JSON answer wrapped in ```json fences → parsed; assert no captured prompt contains `securityAnswer`. Use `MockInteracBankingTools` as the `ToolSet` and `KotlinxSerializer`.

### DI and bridge

- [X] T020 Create `SRC/di/InteracModule.kt`: `@Binds InteracBankingTools` ← `MockInteracBankingTools`; `@Provides @Singleton ToolRegistry` = `ToolRegistry { tools(mock) }` (same singleton instance; add `// ponytail: set to ToolRegistry.EMPTY if on-device tool calls are flaky`); `@Provides ModelResolver` = `ModelResolver(OnDeviceTextModels::llModel)`; `@Provides @Singleton fun intentExtractor(executor: PromptExecutor, registry: ToolRegistry, resolver: ModelResolver): IntentExtractor = InteracAssistantAgent(executor, registry, resolver)` (follow the existing `DataModule` object + `DataBindingsModule` interface split: `InteracModule` object for `@Provides`, `InteracBindingsModule` interface for `@Binds`); `@Provides TextModelDestination` = `TextModelDestination { InteracAssistantScreen(it) }` (the only place both features' presentation types meet — `di/` wires concrete implementations).
- [X] T021 [P] Create `SRC/feature/interacbanking/presentation/a2ui/A2uiBridge.kt`: `interface A2uiBridge { val surfaces: StateFlow<List<A2uiSurfaceModel>>; val events: Flow<A2uiClientToServerMessage>; fun accept(json: String); fun close() }` and `class ProcessorA2uiBridge(scope: CoroutineScope, catalog: A2uiCatalog) : A2uiBridge` adapted from the skill asset `A2uiSession.kt` (parser `A2uiMessageParser()`, `A2uiMessageProcessor(listOf(catalog))`, `collectMessages()` on `Dispatchers.Default`, `outboundEvents` exposed as `events`, `processInput(parser, json)` in `accept`).
- [X] T022 [P] Create `SRC/feature/interacbanking/presentation/a2ui/components/Badge.kt` (`object Badge : A2uiComponent`, props `text` dynamicString required, `tone` enum `success|info|warning` default info → `XelaBadge` colours) and `SRC/feature/interacbanking/presentation/a2ui/components/Alert.kt` (`object Alert : A2uiComponent`, props `text` dynamicString optional (verbatim service messages), `noticeKind` static enum `accountNotFound|noAccountCovers` optional, `noticeArg` dynamicString optional, `tone` enum `error|info` → `XelaAlert`; the component renders `text` when present, else `stringResource(assistant_account_not_found | assistant_no_account_covers, noticeArg)`; title from `assistant_alert_title_error|info` resources (add to T006)); `isReady` = `text` or `noticeArg` resolved.
- [X] T023 Create `SRC/feature/interacbanking/presentation/a2ui/InteracCatalog.kt`: `const val INTERAC_CATALOG_ID = "com.jayvijay.scottie/a2ui/interac/v1"`; `fun interacCatalog(context: Context): A2uiCatalog` = `materialA2uiBasicCatalogV1(image = <renderer that calls onError(UnsupportedOperationException())>, video = same, audioPlayer = same, urlOpener = { }, messageFormatter = android.icu MessageFormat adapter, localeProvider = A2uiLocaleProvider.Default)` then `A2uiCatalog(catalogId = INTERAC_CATALOG_ID, components = base.components.filterNot { it.name in REMOVED } + listOf(Badge, Alert /* + later components */), functions = base.functions, themeSchema = base.themeSchema, isInline = true)` with `REMOVED = setOf("Image","Video","AudioPlayer","TextField","CheckBox","ChoicePicker","Slider","DateTimeInput","Button","Tabs","Modal")`.
- [X] T024 [P] Create `SRC/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt` skeleton: `object InteracSurfaceTemplates` with private helpers `createSurface(id)`, `updateData(id, path, value: JsonElement)`, `updateComponents(id, components: List<JsonObject>)` producing `"version":"v0.9"` envelopes exactly as in `contracts/a2ui-catalog.md`; public `fun alert(surfaceId, text: String?, notice: Notice?, tone): List<String>` (root Column → Alert with `text` or `noticeKind`/`noticeArg`). Serialise with `kotlinx.serialization.json.Json`.
- [X] T024a [P] Create `SRC/feature/interacbanking/presentation/a2ui/components/BalanceCard.kt` (`object BalanceCard : A2uiComponent`; dynamic strings `name`, `typeCode` (`CHEQUING|SAVINGS|CREDIT|LINE_OF_CREDIT`, mapped to `assistant_account_type_*` by the component), `mask`, `balance`, `currency` required; dynamic boolean `highlight`; Xela layout: name + `XelaBadge(type label)`, mask caption, balance + currency, `XelaDivider`) and register it in `InteracCatalog.kt` (T023).
- [X] T024b Add `fun balanceCards(surfaceId, accounts: List<Account>, notice: Notice? = null, noticeText: String? = null, highlightId: String? = null): List<String>` to `SRC/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt`: data `/accounts/<i>/{name,typeCode,mask,balance,currency,highlight}` with balance formatted `"1,540.25"` and `typeCode = account.type.name`; root Column → optional Alert (`text = noticeText` or `noticeKind`/`noticeArg` from `notice`) + one `BalanceCard` per account bound to `/accounts/<i>/…` (children listed explicitly, not a template); add template tests to `TEST/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt` for 1 card, 2 cards, 4 cards + notice, highlight flag; no user-visible copy in the JSON.

### Screen skeleton

- [X] T025 Create `SRC/feature/interacbanking/presentation/InteracAssistantContract.kt` per data-model.md: `InteracAssistantState(modelName, turns: List<AssistantTurn>, input, busy, missingModel: Boolean, surfaces: List<A2uiSurfaceModel>, eventSink)`, `AssistantTurn(id: Int, userText: String, reply: TurnReply, firstCardMs: Long?)`, `sealed interface TurnReply { Text(message: String); Surface(surfaceId: String); Fallback }`, `sealed interface Notice { data class AccountNotFound(val hint: String); data class NoAccountCovers(val amount: String) }` (resolved to copy by the `Alert` component, never by the presenter), `sealed interface InteracAssistantAction : CircuitUiEvent { Back; InputChanged(text); Send; A2uiEvent(message: A2uiClientToServerMessage) }`.
- [X] T026 Create `SRC/feature/interacbanking/presentation/InteracAssistantPresenter.kt` (`@AssistedInject` `navigator`, `screen: InteracAssistantScreen`, `extractor: IntentExtractor`, `banking: InteracBankingTools`, `bridgeFactory: (CoroutineScope) -> A2uiBridge`, `@Named("liteRtModelsDir") modelsDir: File`, `@CircuitInject(InteracAssistantScreen::class, SingletonComponent::class) @AssistedFactory`): `rememberRetained` turns/input/busy; bridge created once via `rememberRetained`; `missingModel = !File(modelsDir, screen.modelId).exists()`; `Send` → `busy = true`, `extractor.extract(text, modelId)`, `when (intent)`: OTHER → `TurnReply.Text(reply ?: string placeholder resolved in UI via `null` sentinel)`, others → `TurnReply.Text("…")` placeholder for now; exceptions → `TurnReply.Fallback`; collect `bridge.events` and forward as `A2uiEvent` to a `handleEvent` stub; `Back` → `navigator.pop()`; private `suspend fun <T> banking(block: () -> T) = withContext(Dispatchers.Default) { block() }` with `// ponytail: blocking in-memory calls; make the interface suspend if a real backend arrives`.
- [X] T027 Create `SRC/feature/interacbanking/presentation/InteracAssistantUi.kt` (`@CircuitInject(InteracAssistantScreen::class, SingletonComponent::class) class InteracAssistantUi @Inject constructor() : Ui<InteracAssistantState>`): root `Box(modifier.fillMaxSize().background(...).safeDrawingPadding())`; `ScottieToolbar(title = assistant_title, subtitle = modelName, backLabel = back, onBack)`; `missingModel` → centred `assistant_model_missing`; else `LazyColumn` of turns (user text bubble; `TurnReply.Text` → `Text`; `TurnReply.Surface(id)` → `key(id) { A2uiSurface(surfaceModel = state.surfaces.first { it.id == id }) }` when present; `Fallback` → `assistant_fallback`; debug-only latency caption when `firstCardMs != null`) and a bottom composer (`OutlinedTextField`-based input bound to `InputChanged`, `XelaButton(assistant_send, state = if (busy || input.isBlank()) DISABLED else DEFAULT)`); `@Preview` with two static turns and no surfaces inside `ScottieTheme`.
- [X] T028 Add presentation test doubles `TEST/feature/interacbanking/presentation/FakeIntentExtractor.kt` (queue of `AssistantIntent`/exceptions, records calls) and `TEST/feature/interacbanking/presentation/FakeA2uiBridge.kt` (`accepted: MutableList<String>`, `surfaces: MutableStateFlow`, `events: MutableSharedFlow`, helper `emitEvent(type, surfaceId, context)` building `A2uiClientEventMessage`).
- [X] T029 Create `TEST/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt` (circuit-test `presenter.test {}` + `FakeNavigator(InteracAssistantScreen("m.litertlm"))`): initial state; `missingModel` when file absent; `Send` sets `busy` then appends a turn; OTHER → `TurnReply.Text(reply)`; extractor exception → `Fallback`; `Back` pops.
- [X] T030 Model download entry point: add `data class UseModel(val modelId: String) : ModelDownloadAction` to `SRC/feature/modeldownload/presentation/ModelDownloadScreen.kt`; inject `destination: TextModelDestination` into `SRC/feature/modeldownload/presentation/ModelDownloadPresenter.kt` and handle it with `navigator.goTo(destination.screen(action.modelId))` (no import of `feature/interacbanking`); in `SRC/feature/modeldownload/presentation/component/ModelDownloadCard.kt` show a secondary `XelaButton(stringResource(R.string.assistant_use_model))` when `status == Downloaded && type == TEXT`; add a test to `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt` constructing the presenter with `TextModelDestination { FakeTextModelScreen(it) }` (a `@Parcelize data class` declared in the test file) and asserting `navigator.awaitNextScreen() == FakeTextModelScreen("a")`.

**Checkpoint**: `assembleDebug`, `testDebugUnitTest`, `detekt`, `lintDebug` pass. On device with
network off: open a downloaded text model → assistant → "What's the weather?" → off-topic reply;
"Send $50 to Alice" → placeholder text (forms arrive in Phase 3).

---

## Phase 3: User Story 1 — Send an Interac e-Transfer (Priority: P1) 🎯 MVP

**Goal**: One prefilled, rule-enforcing transfer form per send request; autocomplete; single
submit; confirmation; immediate balance debit.

**Independent Test**: Spec US1 scenarios 1–14 on device (network off) and the automated suites
below. Delivers an end-to-end send with no further chat turns.

### A2UI form component

- [X] T031 [US1] Create `SRC/feature/interacbanking/presentation/a2ui/components/InteracForm.kt` (`object InteracForm : A2uiComponent`, name "InteracForm") declaring every property in `contracts/a2ui-catalog.md` "InteracForm properties": `mode` static enum `send|request`; writable dynamic strings `amount`, `recipientQuery`, `recipientId`, `manualEmail`, `manualPhone`, `accountId`, `channel`, `securityQuestion`, `securityAnswer`, `memo`; dynamic booleans `saveContact` (writable), `channelLocked`, `securityRequired`, `valid` (writable), `busy`; `suggestions`, `recipients` as `dynamicCustom` lists of `{id,label,detail,autodeposit}`; `accounts` as `dynamicCustom` list of `{id,label,detail}`; actions `onQuery`, `onSelectRecipient`, `onSubmit`. `isReady` = `mode`, `amount`, `channel`, `accountId`, `valid` bindings resolved.
- [X] T032 [US1] Implement `InteracForm.Content` in `SRC/feature/interacbanking/presentation/a2ui/components/InteracForm.kt` with Xela components. All fixed copy (form title by `mode`, field labels, channel names, badge text, submit label) comes from `stringResource(R.string.assistant_*)` inside the component; the data model carries only values and codes. Layout: `XelaTextField` for amount (`keyboardType = Number`), security question, memo; `XelaTextField(secureField = true)` for the answer; recipient `XelaTextField` whose edits call `bindUpdater(recipientQuery)` and, debounced 150 ms via `LaunchedEffect`, `dispatchAction(onQuery)`; suggestion/recipient rows as `XelaChip`s that set `recipientId` and dispatch `onSelectRecipient`; manual email/phone fields + `XelaCheckbox` (save contact) shown when `recipientId` is blank and `recipients` is empty or the user typed an email/phone; account `XelaRadioButtonGroup` from `accounts`; channel: when `channelLocked` a read-only `Text` row, else `XelaRadioButtonGroup` with two items and `selectedItemID = ""` when `channel == ""` (never default); security fields only when `securityRequired`; `Badge("Autodeposit Active", success)` when `!securityRequired && mode == send`; memo only in request mode; compute `valid` on every change per the contract rule list (amount via `validateAmount`, recipient resolved or ≥ 1 manual destination, channel chosen or locked, account chosen, security both `trim().isNotEmpty()` when required, `!busy`) and write it through `bindUpdater(valid)`; `XelaButton(submit label by mode, state = if (valid && !busy) DEFAULT else DISABLED, onClick = dispatchAction(onSubmit))`. Never render the answer text anywhere but the masked field.
- [X] T033 [US1] Register `InteracForm` in `SRC/feature/interacbanking/presentation/a2ui/InteracCatalog.kt` component list.
- [X] T034 [P] [US1] *(written and compiled; not executed — no device)* Create `ATEST/feature/interacbanking/presentation/a2ui/InteracFormTest.kt` with `A2uiTestController(interacCatalog(context), initialComponents = <root Column + InteracForm payload>, initialData = <send form data>)` under `runComposeUiTest`: submit disabled until amount/recipient/channel/account/security valid; whitespace-only Q/A keeps it disabled; answer field has password semantics and never shows typed text; Charlie data (`channel == ""`, `channelLocked false`) shows two unselected radios; Alice data (`securityRequired false`) hides security fields and shows the badge; `updateData("/form/securityRequired", true)` reveals them; typing in recipient emits a `recipientQuery` outbound event and `updateData("/suggestions", [...])` renders chips; tapping submit dispatches `submit` whose context contains every `/form/*` value; request mode shows memo and no security fields.

### Templates

- [X] T035 [US1] Add to `SRC/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt`: `data class FormSeed(mode, amount: String, recipientQuery: String, recipientId: String?, manualEmail: String?, manualPhone: String?, recipients: List<RecipientOption>, accounts: List<AccountOption>, accountId: String?, channel: String, channelLocked: Boolean, securityRequired: Boolean, memo: String?)` and `fun form(surfaceId: String, seed: FormSeed): List<String>` emitting createSurface → updateDataModel(`/`, `{form:{...all paths with initial values, valid:false, busy:false}, options:{recipients, accounts}, suggestions:[]}`) → updateComponents(root Column[InteracForm with every property path-bound per contract, actions with the contract's exact event names and contexts]). No user-visible copy in the JSON; the component renders its own title from `mode`.
- [X] T036 [US1] Add `fun confirmation(surfaceId, result: ConfirmationData): List<String>` (root Column → Confirmation component, data under `/result/*`) and `fun deleteSurface(surfaceId): String` to `InteracSurfaceTemplates.kt`; create `SRC/feature/interacbanking/presentation/a2ui/components/Confirmation.kt` (`object Confirmation : A2uiComponent`; dynamic strings `statusCode` (`SENT|PENDING_SECURITY_ANSWER|REQUEST_SENT`, mapped to `assistant_status_*` by the component), `reference`, `amount`, `party`, `channelCode` (`EMAIL|PHONE`, mapped to `assistant_channel_email|sms`), `destination`, `account`, `time`, optional `memo`; static `kind` enum `send|request` to pick recipient/requestee and source/deposit labels from `assistant_conf_*` resources; Xela `XelaBadge` for status + label/value rows with `XelaDivider`) and register it in `InteracCatalog.kt`.
- [X] T037 [P] [US1] Create `TEST/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt`: parse emitted JSON with kotlinx; assert three envelopes with `"version":"v0.9"`, surface id, catalog id; root id `root`; for seeds mirroring spec scenarios 1 (Alice: `channel="EMAIL"`, `channelLocked=true`, `securityRequired=false`), 2 (Bob: `PHONE`, locked, required), 3/4 (Charlie/Jane: `channel=""`, not locked), 6 (accounts exactly `[acc_chk_101, acc_sav_202]`), 9 (manual `sam@example.com` prefilled, `recipients` empty, `securityRequired=true`), 14 (prefilled amount "20.00" and `accountId=acc_sav_202`); every writable property is a `{"path":…}` object; `confirmation()` includes memo only when non-null.

### Presenter: send flow

- [X] T038 [US1] Implement send resolution in `SRC/feature/interacbanking/presentation/InteracAssistantPresenter.kt`: for `Intent.SEND` → `banking { getAccountBalances() }`, `banking { findContacts(recipientQuery) }` + `contactScore` ranking → `clearMatch` preselect; recipients empty and query looks like email/phone (`@` or ≥ 7 digits) → manual seed with the value prefilled; no query → all contacts; accounts: `matchAccounts(accountHint)` single → preselect; if preselected and `amount > balance` → emit `balanceCards(surfaceId, listOf(that account) + eligibleSources(all, amount), notice = Alert text = banking.insufficientBalanceMessage(account, amount))` with the named account `highlight=true` (T024b template); else `/options/accounts = eligibleSources(all, amount)`; none can cover → `balanceCards(all non-credit + credit, notice = Notice.NoAccountCovers(formattedAmount))`; `channelHint` mapping: `SMS → DeliveryChannel.PHONE`, `EMAIL → EMAIL`, applied as the initial `/form/channel` only when the preselected recipient has that channel and is not `channelLocked`, otherwise ignored (FR-017: never guess); channel/lock/security from the preselected contact (one channel → locked; both → `""`; autodeposit → `securityRequired=false`; manual → true); amount formatted with two decimals or `""`; same explicit-but-unavailable-channel handling as T045 (Bob + "email"): call `executeSendTransfer` once with the hinted channel inside `runCatching` (rejected at `destinationFor` before the debit — T012 verifies the balance is unchanged), prepend the verbatim `Alert`, and lock the single available channel; send `form(...)` lines to the bridge; set the turn to `TurnReply.Surface(id)`; record `firstCardMs` when `bridge.surfaces` first contains the id.
- [X] T039 [US1] Implement A2UI event handling in `SRC/feature/interacbanking/presentation/InteracAssistantPresenter.kt`: `recipientQuery` → `banking { findContacts(query) }` → `updateData(surfaceId, "/suggestions", …)`, logging `Log.i(TAG, "suggest_ms=<elapsed>")` around that path (SC-003); `selectRecipient` → look up contact → `updateData("/form", merged form with channel reset to `""` unless single channel, `channelLocked`, `securityRequired`)`; `submit` → build `FormDraft` from `context`, re-validate with `InteracResolution` rules (if invalid — should be unreachable — append `Alert(text = assistant_fallback resolved by the component via noticeKind=fallback)` and write `/form/valid=false`), `updateData("/form/busy", true)`, then `banking { if (saveContact && manual) saveContact(...) ; executeSendTransfer(accountId, Recipient.Saved(id) or Manual(email, phone), amount, channel, q, a) }`; success → `accept(deleteSurface(id))`, `accept(confirmation(...))` with `statusCode = result.status.name` and `channelCode = result.deliveryChannel.name`, keep `TurnReply.Surface(id)`; `IllegalArgumentException` → `accept(updateComponents(root children + Alert(message verbatim)))` and `/form/busy=false`; never retry; never log the draft.
- [X] T040 [US1] Extend `TEST/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt` with the real `MockInteracBankingTools`: SEND Alice → exactly one `form` sequence accepted whose seed has `channelLocked=true`, `securityRequired=false`; SEND Charlie → `channel=""`; "Ali" → two recipients, none preselected; `sam@example.com` → manual seed; $2,000 from Everyday → alert + card + Savings suggested, no form; $100 no account → accounts `[Everyday, Savings]`; `recipientQuery` event → `/suggestions` update and extractor call count unchanged; `submit` event with Bob + Q/A → one `executeSendTransfer`, PENDING confirmation accepted, Everyday balance debited, extractor not called again (scenario 14); submit with insufficient funds → Alert text equals service message verbatim; `saveContact=true` manual → contact saved.

**Checkpoint**: US1 acceptance scenarios 1–14 pass on device; all suites green.

---

## Phase 4: User Story 2 — Check account balances (Priority: P2)

**Goal**: Balance cards for the matching accounts; not-found message + all cards; general query →
all four.

**Independent Test**: Spec US2 scenarios 1–5 on device; template and presenter tests.

- [X] T043 [US2] Implement `Intent.BALANCE` in `SRC/feature/interacbanking/presentation/InteracAssistantPresenter.kt`: `matchAccounts(accountHint, all)`; non-empty → `balanceCards(matches)`; empty with non-blank hint → `balanceCards(all four, notice = Notice.AccountNotFound(hint))`; blank hint → all four; emit via bridge, `TurnReply.Surface`, record `firstCardMs`. (`BalanceCard` component and `balanceCards()` template are foundational: T024a/T024b.)
- [X] T044 [US2] Add presenter tests to `InteracAssistantPresenterTest.kt`: "savings" → 1 card; "chequing" → 2; "4821" → 1; "visa" → Rewards Visa with balance 2,500.00; "TFSA" → alert + 4 cards; null hint → 4 cards; cards reflect a debited balance after a send (scenario 7, $40.25).

**Checkpoint**: US2 scenarios 1–5 pass on device.

---

## Phase 5: User Story 3 — Request money via Interac (Priority: P3)

**Goal**: Request form mirroring the send form with deposit account, memo, no security fields, no
balance check; confirmation with `REQ-` reference and memo; balances unchanged.

**Independent Test**: Spec US3 scenarios 1–4 on device; presenter/template tests.

- [X] T045 [US3] Implement `Intent.REQUEST` resolution in `InteracAssistantPresenter.kt`: same recipient logic as send; accounts = `eligibleDeposits(all)` with `matchAccounts(accountHint)` preselect; `securityRequired=false` always; `memo` from intent; `channelHint` mapping as in T038 (`SMS → PHONE`). When the hinted channel is one the preselected contact lacks (Alice + SMS): run `banking { runCatching { executeRequestMoney(Recipient.Saved(id), depositAccountId ?: eligibleDeposits(all).first().accountId, amount ?: 0.01, hintedChannel, memo) } }`, which the service rejects at `destinationFor` with `"Alice Martin has no phone number for PHONE delivery."` before creating any result; then emit the form via `form(seed)` with the contact's single channel locked per FR-017 **and** prepend an `Alert(text = rejection message)` component to the surface root. Never preselect a channel the contact lacks. The component renders the request title from `mode`.
- [X] T046 [US3] Extend `submit` handling in `SRC/feature/interacbanking/presentation/InteracAssistantPresenter.kt` for `mode == request`: `executeRequestMoney(recipient, accountId, amount, channel, memo)`; confirmation with `kind=request`, status `assistant_status_request_sent`, memo row; rejection → Alert verbatim.
- [X] T047 [P] [US3] Template tests in `InteracSurfaceTemplatesTest.kt`: request seed → `mode="request"`, `securityRequired=false`, accounts `[Everyday, Joint, Savings]`, memo `"dinner"`; confirmation with memo.
- [X] T048 [US3] Presenter tests in `InteracAssistantPresenterTest.kt`: "Request $30 from Alice into savings for dinner" → deposit `acc_sav_202`, memo dinner, no security; submit → `REQ-` confirmation, balances unchanged; "Request $30 from Alice by text" (`channelHint = SMS`) → exactly one `executeRequestMoney` call that throws, Alert text exactly `"Alice Martin has no phone number for PHONE delivery."`, a form surface whose seed has `channel="EMAIL"` and `channelLocked=true`, no `REQ-` confirmation, balances unchanged; "Ask Alicia for 25 bucks" → Alicia preselected, Email locked.

**Checkpoint**: US3 scenarios 1–4 pass on device.

---

## Phase 6: User Story 4 — Errors, off-topic, fallbacks (Priority: P3)

**Goal**: Verbatim service messages, polite off-topic reply, readable fallback instead of a broken
surface, no automatic retries.

**Independent Test**: Spec US4 scenarios 1–3 plus the client-error path.

- [X] T049 [US4] In `InteracAssistantPresenter.kt`, collect `A2uiClientErrorMessage` from `bridge.events`: on any client error for a turn's surface → `accept(deleteSurface(id))`, set the turn to `TurnReply.Fallback`, `busy=false`; wrap every `bridge.accept` and template build in `runCatching` → `Fallback`; ensure `Intent.OTHER` uses `reply` or `assistant_off_topic` (UI resolves the resource when `reply == null`).
- [X] T050 [US4] Presenter tests in `InteracAssistantPresenterTest.kt`: `FakeA2uiBridge.emitError(surfaceId)` → surface deleted and `Fallback`; bridge `accept` throwing → `Fallback` with no surface; OTHER with null reply → UI resource path (state carries `null`); rejected submit never triggers a second `executeSendTransfer` (count == 1).
- [X] T051 [P] [US4] *(written and compiled; not executed — no device)* Create `ATEST/feature/interacbanking/presentation/InteracAssistantUiTest.kt` (`createComposeRule`, content wrapped in `ScottieTheme`): render `InteracAssistantUi` with a state whose turn is `TurnReply.Surface("missing")` and `surfaces = emptyList()` → only the user bubble node exists (no card, no empty container); `TurnReply.Fallback` → `assistant_fallback` text shown; `missingModel = true` → `assistant_model_missing` text shown and no composer. Also add `@Preview`s for the Fallback and missingModel states in `SRC/feature/interacbanking/presentation/InteracAssistantUi.kt`.

**Checkpoint**: US4 scenarios pass; no empty or partially rendered surface is observable.

---

## Phase 7: Device verification & polish

- [X] T052 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug` and fix findings (compose-rules detekt included); confirm the existing `MockInteracBankingToolsTest`, `ModelDownloadPresenterTest`, `LiteRtModelRuntimeTest` still pass.
- [ ] T053 Run `./gradlew :app:connectedDebugAndroidTest --tests "com.jayvijay.scottie.feature.interacbanking.*"` on the reference phone; record results in `specs/005-interac-assistant-ui/quickstart.md` §1. *(2026-10-06: not run — no device/emulator attached; `compileDebugAndroidTestKotlin` passes.)*
- [ ] T054 Execute quickstart §2 (network off, Gemma 4 E2B): all 14 acceptance scenarios, scenario 7 restart, tool-call presence check: logcat tag `InteracBanking` shows `tool=findContacts` during the model's turn (before the form appears) for "Send 40 to Ali"; if tool calls are absent/garbage, flip `ToolRegistry.EMPTY` in `SRC/di/InteracModule.kt` and re-run scenario 8. *(2026-10-06: pending device.)*
- [ ] T055 Fill the §3 latency table in `specs/005-interac-assistant-ui/quickstart.md` from `first_card_ms` logcat lines; if warm max > 8000 ms or median > 5000 ms apply research R11 levers in order (shorter system prompt → `ToolRegistry.EMPTY` → `Backend.GPU()` in `OnDeviceTextModels.BACKEND` → Qwen3 0.6B) and re-measure; record device, SoC, model file. *(2026-10-06: pending device.)*
- [ ] T056 [P] Execute `specs/005-interac-assistant-ui/quickstart.md` §4–§5: autocomplete while busy; verbose logcat grep for the typed security answer returns nothing; confirm `InteracAssistantAgentTest` prompt-capture assertion; record the max `suggest_ms` from logcat (must be ≤ 200) in quickstart §4. *(2026-10-06: pending device; the `InteracAssistantAgentTest` prompt-capture assertion is green.)*
- [X] T057 [P] Update `specs/005-interac-assistant-ui/plan.md` risks with measured outcomes and `research.md` R1 with the observed tool-calling behaviour; add one line to `app/src/main/java/com/jayvijay/scottie/core/AGENTS.md` noting `core/ai/` now holds the on-device text-generation seam (`OnDeviceTextModels`).
- [X] T058 Inspect the final diff (`git diff --stat` at the repo root; files under `app/src/` and `specs/005-interac-assistant-ui/`) for scope (no unrelated edits, no credentials, no generated sources), then write the completion report distinguishing inspection / compilation / unit tests / instrumented tests / observed device behaviour, and listing any skipped check with its reason.

---

## Dependencies & Execution Order

### Phase dependencies

- **Phase 1** → no dependencies (T002, T003, T005, T006 in parallel; T004 after T002; T005 after T002).
- **Phase 2** → after Phase 1. Internal order: T007 → T008 → T011 → T012; T009/T010 parallel with T007; T013/T014 parallel; T015–T017 parallel, then T018 (Step 0 first) → T019; T020 after T011, T018, T003; T021/T022/T024/T024a parallel, T023 after T022 and T024a, T024b after T024 and T024a; T025 → T026 → T027; T028 → T029; T030 after T003 and T020.
- **Phase 3 (US1)** → after Phase 2. T031 → T032 → T033; T034 after T033; T035 → T036; T037 after T036; T038 after T035 and T024b; T039 after T036; T040 after T039.
- **Phase 4 (US2)** → after Phase 2 (T024a/T024b supply the card and template); independent of US1.
- **Phase 5 (US3)** → after Phase 3 (reuses `InteracForm`, `form()`, `confirmation()`, submit handling).
- **Phase 6 (US4)** → after Phase 2; T049/T050 touch the presenter, so sequence after T039 if US1 is in progress.
- **Phase 7** → after all desired stories.

### User story dependencies

- **US1**: Foundational only (`BalanceCard`/`balanceCards()` are foundational T024a/T024b).
- **US2**: Foundational only.
- **US3**: US1 (form component and submit path).
- **US4**: Foundational; integrates with whichever stories exist.

### Parallel opportunities

- Phase 1: T002 ‖ T003 ‖ T006; then T004 ‖ T005.
- Phase 2: {T009, T010} ‖ {T013, T014} ‖ {T015, T016, T017} ‖ {T021, T022, T024, T024a}; T030 after T020.
- Phase 3: T034 ‖ T037 (tests) while T038/T039 proceed; T036 ‖ T038.
- Phase 4 can run alongside Phase 3 by a second developer (coordinate edits to
  `InteracSurfaceTemplates.kt`, `InteracCatalog.kt`, and the presenter).
- Phase 7: T056 ‖ T057.

## Parallel example: Phase 2 kickoff

```text
Task: "T009 ContactMatcher.kt — ranked fuzzy scorer per research R6"
Task: "T013 InteracResolution.kt — matchAccounts / eligibleSources / validateAmount / clearMatch"
Task: "T015 AssistantIntent.kt — @Serializable contract with @property:LLMDescription"
Task: "T017 InteracAgentInstructions.kt — rewritten 7-rule prompt"
Task: "T021 A2uiBridge.kt — processor/parser wrapper from the skill asset"
Task: "T022 Badge.kt + Alert.kt — Xela-backed A2UI components"
```

## Parallel example: User Story 1

```text
Task: "T034 InteracFormTest.kt (androidTest) — submit gating, masking, channel unset, writeback"
Task: "T037 InteracSurfaceTemplatesTest.kt — JSON assertions for scenarios 1,2,3,4,6,9,14"
# while:
Task: "T038 presenter send resolution"  →  "T039 presenter A2UI events + submit"
```

## Implementation strategy

### MVP first (Phases 1–3)

1. Phase 1 — classpath proof + seams (half a day).
2. Phase 2 — banking data, agent, bridge, text-only screen; verify the off-topic reply on device
   with the network off. This is the first evidence inference works through Koog's LiteRT client.
3. Phase 3 — the send form; **stop and run spec US1 scenarios 1–14 on device**. Demo-able POC.

### Incremental delivery

4. Phase 4 balances (small; BalanceCard + one presenter branch).
5. Phase 5 requests (reuses the form).
6. Phase 6 hardening, then Phase 7 measurement and report.

### Notes

- Commit per task or logical group only when asked; no branch operations unless requested.
- Any API mismatch with the skills (e.g. structured-output manual mode for `LiteRTLLMProvider`)
  is handled by the fallbacks named in research R3 — do not invent signatures.
- Deliberate corners cut are marked with `// ponytail:` comments (backend constant, blocking
  banking calls, tool-registry flag) so `/ponytail-debt` can harvest them.
