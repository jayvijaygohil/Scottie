# Research: Conversational Interac e-Transfer Assistant

**Feature**: `005-interac-assistant-ui` | **Date**: 2026-10-06

Every API claim below was checked against the `jetbrains-koog` and `android-a2ui-compose` skills
and, where the skills were silent, against the sources resolved in the Gradle cache for the
installed versions. "Verified: source" means the cached sources jar was read.

## R1. On-device text generation path

**Decision**: Use Koog's own LiteRT client — `ai.koog.prompt.executor.clients.litert.LiteRTLLMClient`
from `ai.koog:prompt-executor-litert-client:1.3.0-beta` — wrapped in `MultiLLMPromptExecutor`.
Point `LiteRTClientConfig.modelsPath` at the directory `LiteRtModelRuntime` already writes to
(`<filesDir>/models/litert`). The Koog `LLModel.id` is the `.litertlm` file name, which is exactly
what `CatalogModel.id` already is (`LiteRtModel` KDoc: "[id] is the local file name and the Koog
`LLModel.id`").

**Rationale**:
- No new dependency. `koog-agents-additions:1.3.0-beta` (already in `app/build.gradle.kts`) lists
  `prompt-executor-litert-client@1.3.0-beta` as a dependency (verified: `.module` metadata), and the
  Gradle cache holds `prompt-executor-litert-client-android-1.3.0-beta` plus its transitive
  `com.google.ai.edge.litertlm:litertlm-android:0.11.0`. Implementation task 0 confirms it is on
  `debugRuntimeClasspath`.
- The client manages `Engine`/`Conversation` lifecycle, serialises calls with a mutex, runs native
  work on `Dispatchers.IO`, and reuses the conversation when only the last message is new
  (verified: source `LiteRTLLMSession.kt`).
- Verified contracts (source, `androidMain`):
  - `LiteRTClientConfig(defaultModel: LLModel = LiteRTLLModels.FunctionGemma, modelsPath: String =
    "/data/local/tmp/llm", cacheDir: String? = null, backend: Backend = Backend.CPU(), clock)`.
  - `LiteRTLLMClient(config)` overrides `execute(prompt, model, tools)`, `moderate` (throws),
    `llmProvider()`, `close()` (uses `runBlocking` → call off the main thread).
  - `LiteRTLLModels.FunctionGemma`, `Gemma4E2B` (`gemma-4-E2B-it.litertlm`), `Gemma4E4B`, all with
    `LLMCapability.Tools` + `Completion`; `addCustomModel(LLModel)` requires provider
    `LiteRTLLMProvider`. Other catalog files (Qwen3 0.6B, Gemma 3 1B, …) need a custom
    `LLModel(provider = LiteRTLLMProvider, id = fileName, capabilities = listOf(Tools, Completion))`;
    the client does not consult the registry, it only uses `model.id` for the path.
  - `AndroidLocalLLMParams(temperature, topK, topP, seed)` — no max-output-tokens knob.
  - Streaming is not overridden by the client; the agent uses non-streaming `execute`.
- Backend: `Backend.CPU()` for the POC. `Backend.GPU()`/`NPU(nativeLibraryDir)` exist in LiteRT-LM
  0.11 and the manifest already declares the Edge TPU native library; left as a single constant to
  flip after measurement (`ponytail:` comment).

**Alternatives considered**:
- RunAnywhere `RunAnywhere.llm.*` — installed, but only the `onnx` backend is present; text models
  in the catalog are `.litertlm`, which RunAnywhere does not run. Would need `runanywhere-llamacpp`
  + GGUF re-catalogue. Rejected.
- Direct `com.google.ai.edge.litertlm` `Engine`/`Conversation` behind a hand-written `LLMClient`.
  Duplicates what Koog's client already does. Rejected.

**Limitation found**: `LiteRTLLMClient.execute` KDoc says tools "are currently not forwarded" but
`LiteRTLLMSession` does forward them (`ConversationConfig(tools = …, automaticToolCalling = false)`)
and `LiteRTMessageConverters` parses native `toolCalls` into `MessagePart.Tool.Call` with synthetic
ids; tool results are correlated **by name** on the next turn. Treat the KDoc as stale; verify on
device (quickstart step 3).

## R2. Where the shared AI code lives (`core/ai`)

**Decision**: Create `core/ai/` holding only the text-generation seam both features now share:
`OnDeviceTextModels` (models directory + `LLModel` factory for a `.litertlm` file name) and the
Hilt provider for the Koog `PromptExecutor`. `LiteRtModelRuntime` switches to `OnDeviceTextModels.dir`
for its directory. Download runtimes (`ModelRuntime`, `LiteRtModelRuntime`, `RunAnywhereModelRuntime`,
`RoutingModelRuntime`, `CatalogModel`) stay in `feature/modeldownload/data/ai/provider/`.

**Rationale**: The second feature needs "run this downloaded file", not download plumbing.
`CatalogModel` and the runtimes import `modeldownload.domain.entities` (`Model`, `ModelType`,
`DownloadFailure`); moving them to `core/` would force `core/` to import `feature/` (forbidden) or
drag those entities along for no behavioural gain. `core/AGENTS.md` scopes `core/ai/` to code a
second feature actually needs — this is the minimal such set. If the full move is still wanted it is
a follow-up refactor with no functional change.

## R3. Agent shape and tool calling

**Decision**: One Koog `AIAgent` with a `functionalStrategy<String, AssistantIntent>` and a tool
registry containing **only the read-only banking tools** (`getAccountBalances`, `findContacts`).
Flow: `requestLLM(input)` → while the response has tool calls (max 3 rounds) execute them and send
results → final `requestLLMStructured<AssistantIntent>()`. The model's job is intent + slot
extraction; it never resolves IDs, picks channels, or calls send/request.

**Verified contracts** (skill `api/agent-lifecycle.md`, `api/tools.md`, `api/sessions.md`):
- `AIAgent(promptExecutor, llmModel, strategy: AIAgentFunctionalStrategy<Input, Output>,
  toolRegistry, systemPrompt, temperature, maxIterations, …): FunctionalAIAgent<Input, Output>`.
- `functionalStrategy(name, func: suspend AIAgentFunctionalContext.(Input) -> Output)`.
- `ToolRegistry { tools(instance: ToolSet) }` on JVM/Android; `@Tool`/`@LLMDescription` already used
  by `MockInteracBankingTools`.
- `requestLLMStructured` returns `Result<StructuredResponse<T>>`; handle failure before `.data`.
  LiteRT models have no `LLMCapability.Schema.JSON`, so Koog must use its manual (prompt-embedded
  schema) path; `StructureFixingParser(model, retries)` can repair but costs extra inferences —
  set `retries = 1`. If the manual path proves unavailable for this provider at implementation,
  fall back to `requestLLMWithoutTools()` + lenient `Json.decodeFromString<AssistantIntent>` after
  stripping code fences; a parse failure yields `intent = OTHER` → spec fallback message.

**Verified at implementation (Koog 1.3.0 sources, `AIAgentFunctionalContextBaseCommon.kt`)**:
the functional context exposes `requestLLM(message)`, `executeTools(message: Message.Assistant)`
→ `List<ReceivedToolResult>`, `sendToolResults(results)` → `Message.Assistant`, and
`requestLLMStructured<T>(message, examples = emptyList(), fixingParser: StructureFixingParser? =
null)`; `StructureFixingParser(model, retries)`. `executeStructured` picks `StructuredRequest.Manual`
for models without `LLMCapability.Schema.JSON`, i.e. every LiteRT model. The implemented strategy
is `requestLLM` → ≤3 × (`executeTools` + `sendToolResults`) → parse the assistant text leniently
(code fences stripped) → only if that fails, `requestLLMStructured(...)` with
`StructureFixingParser(model, retries = 1)`; any failure → `AssistantIntent.FALLBACK`. The
structured request is therefore a repair path, not a second inference on the happy path. Observed
tool-calling behaviour on device: **not yet measured** (no device attached during implementation).

**Fallback if tool calling is unreliable on the chosen model**: set the registry to
`ToolRegistry.EMPTY` (single constant). Nothing downstream depends on the tools: the presenter
re-resolves recipients and accounts deterministically from the banking service anyway. Tools exist
to let the model ground ambiguous names; losing them costs nothing in correctness, only in
conversational flavour.

**Alternatives considered**: graph strategy (`nodeLLMRequest` → `nodeExecuteTools` →
`nodeLLMSendToolResults`) — same behaviour, more ceremony, only pays off with checkpoints. Planner
(GOAP) — no planning problem here.

## R4. A2UI output channel (a / b / c)

| Criterion | (a) agent emits A2UI | (b) agent → intent+slots, presenter templates A2UI | (c) hybrid: agent layout, presenter patches |
|---|---|---|---|
| Reliability on a 0.6–2.6 B model | Low: long JSON, exact component ids/paths, one bad key = broken surface | High: ~60-token JSON with 6 fields, lenient parse | Medium: still long JSON; patching logic must handle every malformed shape |
| Latency (decode tokens) | 400–900 tokens per form | 40–80 tokens | 400–900 tokens |
| Enforcing spec rules (channel, security fields, submit gating) | Must validate every emitted form anyway | Rules live once, in templates + component | Rules duplicated: patch + validate |
| What of the POC it demonstrates | Agent + A2UI protocol end to end | Agent (intent, tools) **and** A2UI (surface, data model, bindings, writeback, actions, round-trip autocomplete) — the model does not author layout | Everything in (a) plus patching |
| Testability | Needs golden A2UI JSON from a stochastic model | Templates are pure functions → JSON assertions; agent tests are one-field assertions | Hardest: two sources of truth |

**Decision**: **(b)**. The model decides *what* (intent, amount, who, which account hint, memo); the
presenter decides *how* (which surface, which components, which bindings) from deterministic
templates fed by the banking service. (c) remains a cheap upgrade later: add an optional
`layoutHint` field to `AssistantIntent` once (b) is stable on device.

## R5. A2UI integration facts used by the design

Verified against the `android-a2ui-compose` skill (alpha01):

- Wire: one JSON object per `processInput(parser, json)`, `"version":"v0.9"`, exactly one operation
  (`createSurface` → `updateDataModel` → `updateComponents`), root component id `root`, component
  properties flattened on the payload. `updateComponents` replaces a component's whole property map.
- Runtime: `A2uiMessageProcessor(catalogs)` + `A2uiMessageParser()`; one `collectMessages()` job on
  `Dispatchers.Default` owned by the screen's lifecycle; `outboundEvents: Flow<A2uiClientToServerMessage>`
  collected separately; `activeSurfaces: StateFlow<List<A2uiSurfaceModel>>` rendered with
  `androidx.compose.material3.a2ui.A2uiSurface(surfaceModel = …)` inside the app theme.
- Writable inputs need a **path binding** (`{"path":"/form/amount"}`); literals are read-only.
  `bindUpdater` gives the writeback callback. Actions:
  `{"event":{"name":"submit","context":{"amount":{"path":"/form/amount"}, …}}}` resolve the context
  at dispatch time and arrive as `A2uiClientEventMessage(type, surfaceId, componentId, context, …)`.
- Custom components implement `androidx.a2ui.compose.ui.A2uiComponent` (`name`, `description`,
  `properties`, member-extension `isReady`/`Content`) with `A2uiProperty.dynamicString|dynamicBoolean|
  dynamicStringList|dynamicCustom|action|childList`. Catalog via `A2uiCatalog(catalogId, components,
  functions, themeSchema, isInline = true)`; duplicate names rejected.
- `materialA2uiBasicCatalogV1(...)` has six parameters without defaults (image, video, audioPlayer,
  urlOpener, messageFormatter, localeProvider). Basic `Button` has no enabled/disabled property;
  basic `ChoicePicker` takes a value **list**; `TextField` has `obscured` and `number` variants.
- Testing: `androidx.a2ui.compose:compose-ui-testing` (already `androidTestImplementation`) gives
  `A2uiTestController(catalog, …).start()`, `A2uiTestSurface(surface)`, `updateData`, `dispatchedActions`,
  `outboundEvents`, `getData<T>(path)`, `waitForIdle()`. Uses `runComposeUiTest` (suspending body).

**Catalog decision**: an app-owned inline catalog
`com.jayvijay.scottie/a2ui/interac/v1` = Material basics for layout/text (`Text`, `Column`, `Row`,
`Card`, `Divider`) **+ Xela-backed custom components** for everything interactive or branded:
`InteracForm`, `BalanceCard`, `Badge`, `Alert`, `Confirmation`. Build it from
`materialA2uiBasicCatalogV1(...)` with failing media adapters, then `filterNot` the media components
(`Image`, `Video`, `AudioPlayer`) and the basic inputs we replace, and add ours — so the advertised
catalog never claims media we cannot render (skill: "do not advertise functioning media while
providing silent no-op adapters").

**Why one `InteracForm` component instead of composing basic inputs**: submit gating, masked
answer, "no channel preselected", and the Autodeposit/security switch are spec rules the UI must
enforce "regardless of what the model produces". Basic `Button` cannot be disabled and validation
via catalog functions needs function names/arguments from the exported schema (skill warns against
inferring them). One Kotlin component with path-bound fields keeps the rules in testable Kotlin and
still exercises A2UI bindings, writeback, dynamic data updates, and actions. Fewer moving parts.

**Autocomplete decision**: `InteracForm` dispatches a `recipientQuery` action (debounced 150 ms) on
every edit; the presenter answers with `updateDataModel("/suggestions", [...])` from
`findContacts`. The language model is never on this path (SC-003); it is measurable in tests via
`outboundEvents` + `getData("/suggestions")`.

## R6. Fuzzy, ranked contact search

**Decision**: Pure Kotlin scorer in `data/ai/tools/ContactMatcher.kt`; no library.

Normalisation: lowercase, trim; phone digits only (strip `+ - ( ) space`); query digits-only when
it has ≥ 4 digits and no letters. Per contact take the max over fields:

| Match | Score |
|---|---|
| exact first name / full name / email / phone digits | 100 |
| prefix of a name token or email local part, or phone digits suffix | 80 |
| substring of name/email/phone digits | 60 |
| Damerau-Levenshtein distance ≤ 2 to a name token (query ≥ 4 chars) | 40 |
| otherwise | 0 (excluded) |

Return contacts with score > 0 sorted by score desc then name. **Clear single match** (presenter
rule for preselect) = top score ≥ 80 and (only one result or top − second ≥ 30).

Checks against the spec: "Charly"→Charlie (distance 2 → 40, sole result → preselect); "Ali" →
Alice 80, Alicia 80 → both, none preselected; "Bob" → Bob Vance 100, Robert 0 → clear;
"Rob" → Robert 80, Bob 40 → Robert preselected, Bob still listed; "4165550143" → Bob 100;
"charlie.c@example.ca" → 100; "sam@example.com" → none → manual mode.

*Implementation notes*: the fuzzy rule needed two adjustments to satisfy its own table — minimum
query length 3 (not 4) so "Rob" reaches Bob, with distance ≤ 1 for 3-char queries (≤ 2 from 4
chars) so "Bob" does not reach "Doe"; phone digits compare on the last 10 digits so "4165550143"
equals "+1-416-555-0143". The scorer lives in `domain/usecase/ContactMatcher.kt` (not
`data/ai/tools/`) because the presenter needs the scores for `clearMatch` and may not import
`data/`. "Clear single match" is a single candidate of any score, or top ≥ 80 with a gap ≥ 30.

**Alternatives**: substring only (current) fails "Charly"; a fuzzy-search library adds a dependency
for ~40 lines.

## R7. Account resolution and eligibility (deterministic, domain)

Pure functions in `domain/usecase/InteracResolution.kt`:
- `matchAccounts(hint, accounts)`: `savings`→SAVINGS; `chequing|checking`→CHEQUING; `visa|credit|
  card`→CREDIT; `ending NNNN` or 4 digits → mask suffix; otherwise case-insensitive name substring;
  empty list for "TFSA".
- `eligibleSources(accounts, amount?)`: non-credit, balance ≥ amount (when given), CHEQUING first
  then SAVINGS, catalog order within type.
- `eligibleDeposits(accounts)`: non-credit, same ordering.
- `validateAmount(text)`: `> 0`, ≤ 2 decimals, `BigDecimal` parse.

## R8. Threading

Banking calls are in-memory `@Synchronized` map operations. **Decision**: keep them blocking;
presenter wraps every call in one `suspend fun <T> banking(block: () -> T) = withContext(Dispatchers.Default) { block() }`.
Making the interface `suspend` would force the Koog `ToolSet` methods to be suspend too, for no
measurable benefit (`ponytail:` comment: switch to suspend if a real backend arrives).

## R9. Hilt wiring

- `@Binds InteracBankingTools ← MockInteracBankingTools` (already `@Singleton`) so the presenter and
  the Koog registry hit the same balances.
- `@Provides @Singleton ToolRegistry = ToolRegistry { tools(mock) }` — the `ToolSet` is the same
  singleton instance.
- `@Provides @Singleton PromptExecutor = MultiLLMPromptExecutor(LiteRTLLMClient(LiteRTClientConfig(
  defaultModel = <first catalog model>, modelsPath = OnDeviceTextModels.dir(context).path)))` in a new
  `di/AiModule.kt`. Singleton so the LiteRT engine stays warm across screen visits (engine init can
  take up to ~10 s per Google's LiteRT-LM docs).
- `IntentExtractor` (domain interface) ← `InteracAssistantAgent` (domain/agent/workflow), which
  receives `PromptExecutor`, `ToolRegistry`, and the `LLModel` built from the screen's `modelId`.

## R10. Cross-feature navigation

`feature/modeldownload` must open the assistant without importing `feature/interacbanking`, and
screen keys stay inside their feature's presentation boundary.
**Decision**: `InteracAssistantScreen(val modelId: String) : ParcelableScreen` lives in
`feature/interacbanking/presentation/`. `feature/modeldownload/presentation/` declares
`fun interface TextModelDestination { fun screen(modelId: String): Screen }`; `di/InteracModule`
provides it as `TextModelDestination { InteracAssistantScreen(it) }`. The model-download presenter
calls `navigator.goTo(destination.screen(modelId))`. Entry point: a "Use with Interac assistant"
button on each **downloaded TEXT** model card; the chosen model id travels in the key, so no model
picker is needed on the assistant screen.

**Alternative rejected**: a shared key in `core/navigation/` — extends the `core/` layout for one
consumer and moves a feature's screen identity out of its slice.

## R11. Latency target and measurement

- **Target (SC-002)**: warm turn (engine already initialised) ≤ 8 s worst case, ≤ 5 s median across
  the 11 example prompts, from Send tap to first interactive element rendered. Cold first turn adds
  LiteRT engine initialisation (documented up to ~10 s); report it separately.
- **Reference model**: Gemma 4 E2B (`gemma-4-E2B-it.litertlm`, in `LiteRTLLModels`, tool-capable,
  2.6 GB) on the developer's phone. Low-RAM alternative: Qwen3 0.6B as a custom `LLModel`.
- **Measurement**: `SystemClock.elapsedRealtime()` captured at `Send`, compared when the presenter
  receives the first non-empty `activeSurfaces` emission; logged as
  `Log.i("InteracAssistant", "first_card_ms=…")` and shown as a small debug caption under the turn in
  debug builds only. Quickstart has the table to fill.
- **Levers if over target**: shorten the system prompt (tool schemas are the bulk), `Backend.GPU()`,
  `ToolRegistry.EMPTY`, smaller model.

## R12. Test strategy (summary; detail in plan)

| Layer | Harness | What |
|---|---|---|
| Banking service | JUnit (existing `MockInteracBankingToolsTest` style) | new data, fuzzy ranking cases, saveContact, manual recipients, memo, credit rejection, balance invariants |
| Agent | `agents-test` `getMockExecutor { mockLLMAnswer(json) onRequestContains …; mockLLMToolCall(::findContacts, "Ali") … }` | one test per example prompt → `AssistantIntent`; tool round-trip; malformed JSON → `OTHER` |
| Templates | JUnit + kotlinx JSON | per scenario: surface messages contain expected components/data (channel unset for Charlie/Jane, security fields present/absent, account ordering, prefilled values) |
| Presenter | `circuit-test` `presenter.test {}` + Turbine, fake `IntentExtractor`, fake `A2uiBridge`, real `MockInteracBankingTools` | state transitions, submit → tool call with security answer and without any model call, rejection shown verbatim, no-model state, fallback on `OTHER`/exception |
| A2UI component | androidTest `A2uiTestController` + `runComposeUiTest` | submit disabled until valid, whitespace = empty, masked answer, channel not preselected, security fields toggle with Autodeposit, writeback paths, `submit` context |
| Device | manual, network off | 14 acceptance scenarios + latency table |
