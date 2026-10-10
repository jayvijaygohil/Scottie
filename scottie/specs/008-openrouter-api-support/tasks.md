---

description: "Task list for 008 OpenRouter API Support"
---

# Tasks: OpenRouter API Support

**Input**: Design documents from `/specs/008-openrouter-api-support/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md,
contracts/openrouter-settings-ui.md, quickstart.md

**Tests**: Included — constitution IV requires presenter and repository tests; quickstart lists the
coverage.

**Organization**: Grouped by user story (spec priorities: US1 P1, US2 P1, US3 P2, US4 P2).

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: US1–US4
- Paths: `APP` = `app/src/main/java/com/jayvijay/scottie/`, `TEST` =
  `app/src/test/java/com/jayvijay/scottie/`, `RES` = `app/src/main/res/`. All Gradle commands run
  from the repository root with `./gradlew`.

---

## Phase 1: Setup

- [X] T001 [P] Add the strings from `contracts/openrouter-settings-ui.md` to
  `RES/values/strings.xml` under new comments `<!-- OpenRouter settings -->` and after the existing
  `<!-- Chat home screen -->` block: `model_download_openrouter_title`,
  `model_download_openrouter_base_url`, `model_download_openrouter_api_key`,
  `model_download_openrouter_api_key_hint`, `model_download_openrouter_show_key`,
  `model_download_openrouter_hide_key`, `model_download_openrouter_models`,
  `model_download_openrouter_models_hint`, `model_download_openrouter_error_base_url` ("Enter a
  full web address starting with http:// or https://"), `model_download_openrouter_error_models`,
  `model_download_openrouter_save`, `model_download_openrouter_cancel`,
  `model_download_openrouter_delete_title`, `model_download_openrouter_delete_text`, plural
  `model_download_openrouter_saved` ("Saved · %1$d model" / "Saved · %1$d models"),
  `chat_model_remote` ("Remote"), `chat_reply_offline`, `chat_reply_unauthorized`,
  `chat_reply_model_unavailable`. Copy the exact text from the contract.
- [X] T002 [P] Create `RES/xml/network_security_config.xml` with
  `<network-security-config><base-config cleartextTrafficPermitted="true" /></network-security-config>`
  and a comment `<!-- ponytail: cleartext allowed app-wide (FR-006a); tighten to domain-config
  entries if the gateway hosts become known -->`; add
  `android:networkSecurityConfig="@xml/network_security_config"` to `<application>` in
  `app/src/main/AndroidManifest.xml`.

---

## Phase 2: Foundational (blocks all stories)

**Purpose**: configuration entity and persistence (research R3/R4), remote ids in the active-model
policy, the Koog OpenRouter seam (R1/R2/R6).

- [X] T003 Create `APP/feature/modeldownload/domain/entities/OpenRouterConfig.kt`:
  `@Serializable data class OpenRouterConfig(val baseUrl: String, val apiKey: String, val models:
  List<String>)` with `override fun toString()` that redacts `apiKey` (print `apiKey=***`);
  companion `const val DEFAULT_BASE_URL = "https://openrouter.ai"`, `const val ID_PREFIX =
  "openrouter:"`, `fun remoteId(model: String) = ID_PREFIX + model`; property `val modelIds:
  List<String> get() = models.map(::remoteId)`. In the same file: `enum class OpenRouterField {
  BASE_URL, MODELS }`, `sealed interface OpenRouterValidation { data class Valid(val config:
  OpenRouterConfig); data class Invalid(val fields: Set<OpenRouterField>) }`, and `data class
  OpenRouterDraft(val baseUrl: String, val apiKey: String, val modelsText: String)` with
  `fun validate(): OpenRouterValidation`: models = `modelsText.split(';').map { it.trim()
  }.filter { it.isNotEmpty() }.distinct()`; base URL valid when `baseUrl.trim()` parses via
  `java.net.URI` without exception, `scheme` is `http` or `https` (case-insensitive), and `host`
  is non-null/non-blank; `Invalid` lists every failing field; `Valid` carries `baseUrl.trim()`,
  `apiKey.trim()`, parsed models. No Android imports.
- [X] T004 [P] Create `APP/feature/modeldownload/domain/repository/OpenRouterConfigRepository.kt`
  (declarations only): `val config: StateFlow<OpenRouterConfig?>` (KDoc: "Null when nothing
  saved"), `fun save(config: OpenRouterConfig)` (KDoc: "Replaces the single configuration and
  persists it"), `fun clear()` (KDoc: "Removes the configuration and persists the removal").
- [X] T005 [P] Tests in `TEST/feature/modeldownload/domain/entities/OpenRouterConfigTest.kt`
  (JUnit4): `"a/b ; c/d;"` → models `["a/b","c/d"]`; `"a/b;a/b"` → one model; `"; ;"` → `Invalid`
  containing `MODELS`; base URL `""`, `"openrouter.ai/api/v1"`, `"ftp://x"`, `"not a url"` →
  `Invalid` containing `BASE_URL`; `"http://192.168.1.20:8080"` and `"https://openrouter.ai"` →
  `Valid`; empty key → `Valid` with `apiKey == ""`; both fields bad → both in `fields`;
  `toString()` does not contain the key.
- [X] T006 Create `APP/feature/modeldownload/data/repository/OpenRouterConfigRepositoryImpl.kt`:
  `@Singleton class OpenRouterConfigRepositoryImpl @Inject constructor(@Named("openRouterConfigFile")
  private val file: File, private val json: Json, @ApplicationScope private val scope:
  CoroutineScope) : OpenRouterConfigRepository`. `config` = `MutableStateFlow` initialised by
  reading the file if it exists and decoding `OpenRouterConfig`; on any decode/IO exception log
  `Log.w(TAG, "config unreadable", e)` (never the contents) and start with null. `save` sets the
  flow then `scope.launch { runCatching { file.writeText(json.encodeToString(config)) }.onFailure {
  Log.w(TAG, "config not saved", it) } }`; `clear` sets null and deletes the file on `scope`.
  `TAG = "OpenRouterConfig"`. Comment: `// ponytail: plaintext app-private file; EncryptedFile if
  the key must survive a rooted-device threat model`.
- [X] T007 Wire in `APP/di/DataModule.kt`: `@Provides @Named("openRouterConfigFile") fun
  openRouterConfigFile(@ApplicationContext context: Context): File = File(context.filesDir,
  "openrouter_config.json")`; in `DataBindingsModule` add `@Binds fun openRouterConfigRepository(
  impl: OpenRouterConfigRepositoryImpl): OpenRouterConfigRepository`.
- [X] T008 [P] Create `TEST/feature/modeldownload/presentation/FakeOpenRouterConfigRepository.kt`:
  `override val config = MutableStateFlow<OpenRouterConfig?>(null)`, `val saves =
  mutableListOf<OpenRouterConfig>()`, `var clears = 0`; `save` records and sets the flow; `clear`
  increments and sets null.
- [X] T009 Tests in `TEST/feature/modeldownload/data/repository/OpenRouterConfigRepositoryImplTest.kt`
  (`TemporaryFolder`, `runTest` + `backgroundScope`, `Json { ignoreUnknownKeys = true }`): save
  then `runCurrent()` writes the file and a new instance over the same file emits an equal config;
  `clear` emits null and deletes the file; a file containing `"{garbage"` yields null without
  throwing; a missing file yields null.
- [X] T010 Update `APP/feature/modeldownload/domain/repository/ModelDownloadRepository.kt` KDoc only:
  `activeTextModel` → "Stored id if it is a downloaded `TEXT` model or a configured remote id; else
  first downloaded text model in catalog order; else first configured remote id; else null";
  `selectTextModel` → "Persists the choice. Ignored unless [modelId] is a downloaded text model or a
  configured remote id".
- [X] T011 Implement T010 in `APP/feature/modeldownload/data/repository/ModelDownloadRepositoryImpl.kt`:
  add constructor parameter `private val openRouter: OpenRouterConfigRepository`; replace the
  `activeTextModel` combine with `combine(state, stored, openRouter.config) { catalog, id, config ->
  val local = catalog.downloadedTextIds(); val remote = config?.modelIds.orEmpty();
  id?.takeIf { it in local || it in remote } ?: local.firstOrNull() ?: remote.firstOrNull() }`;
  in `selectTextModel` replace the guard with `if (modelId !in state.value.downloadedTextIds() &&
  modelId !in openRouter.config.value?.modelIds.orEmpty()) return`.
- [X] T012 Update `TEST/feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt`:
  add a `FakeOpenRouterConfigRepository` field and pass it in every constructor call (including
  `repository()`); new tests: no downloaded text model + config `["x/y","z/w"]` → active
  `"openrouter:x/y"`; downloaded `A` + config → active `A`; stored `"openrouter:z/w"` while
  configured → stays active after a new instance; `selectTextModel("openrouter:z/w")` accepted and
  written; `selectTextModel("openrouter:nope")` ignored; active remote then `config.value = null`
  → active falls back to `A` or null.
- [X] T013 [P] Create `APP/core/ai/OpenRouterTextModels.kt`: `object OpenRouterTextModels` with
  `fun normalize(baseUrl: String): String` (trim; `removeSuffix("/")`; `removeSuffix("/api/v1")`;
  `removeSuffix("/")` again); `fun llModel(modelId: String): LLModel =
  OpenRouterModels.models.find { it.id == modelId } ?: LLModel(provider = LLMProvider.OpenRouter,
  id = modelId, capabilities = listOf(LLMCapability.Temperature, LLMCapability.Tools,
  LLMCapability.Completion), contextLength = 128_000L, maxOutputTokens = 4_096L)`;
  `fun executor(baseUrl: String, apiKey: String): PromptExecutor =
  SingleLLMPromptExecutor(OpenRouterLLMClient(apiKey, OpenRouterClientSettings(baseUrl =
  normalize(baseUrl))))` using the top-level `OpenRouterLLMClient(apiKey, settings)` factory from
  `ai.koog.prompt.executor.clients.openrouter`. KDoc mirrors `OnDeviceTextModels`.
- [X] T014 [P] Tests in `TEST/core/ai/OpenRouterTextModelsTest.kt`: `normalize` maps
  `"https://openrouter.ai/api/v1/"`, `"https://openrouter.ai/api/v1"`, `"https://openrouter.ai/"`,
  `" https://openrouter.ai "` all to `"https://openrouter.ai"` and leaves
  `"http://10.0.2.2:8080"` unchanged; `llModel("microsoft/phi-4-reasoning:free")` returns the Koog
  definition (same instance id/provider); `llModel("acme/unknown")` has `provider ==
  LLMProvider.OpenRouter`, id `"acme/unknown"`, and `LLMCapability.Tools`.

**Checkpoint**: `./gradlew :app:testDebugUnitTest` green with the new tests; configuration can be
saved and read programmatically; active model resolves remote ids.

---

## Phase 3: User Story 1 - Configure OpenRouter from the Download screen (Priority: P1) 🎯 MVP

**Goal**: the Settings screen gains an OpenRouter section; Save persists offline; values survive
relaunch with the key masked.

**Independent Test**: quickstart scenario 1 (network off, save, relaunch, reopen, eye icon).

- [X] T015 [US1] Extend `APP/feature/modeldownload/presentation/ModelDownloadScreen.kt`: add
  `data class OpenRouterSection(val baseUrl: String, val apiKey: String, val modelsText: String,
  val errors: Set<OpenRouterField>, val savedModelCount: Int, val confirmingDelete: Boolean, val
  expanded: Boolean)`; add `val openRouter: OpenRouterSection` to `ModelDownloadState` (after
  `error`); add actions `data class EditOpenRouterBaseUrl(val value: String)`, `data class
  EditOpenRouterApiKey(val value: String)`, `data class EditOpenRouterModels(val value: String)`,
  `data object SaveOpenRouter`, `data object ToggleOpenRouter` (US3 adds the delete actions).
- [X] T016 [US1] Update `APP/feature/modeldownload/presentation/ModelDownloadPresenter.kt`: inject
  `OpenRouterConfigRepository`; `val config by openRouter.config.collectAsState()`; draft fields
  `baseUrl`, `apiKey`, `modelsText` in `rememberRetained { mutableStateOf(...) }` initialised from
  `config` (or `OpenRouterConfig.DEFAULT_BASE_URL`, `""`, `""`); `errors` (`emptySet()`),
  `openRouterExpanded` (`true`) likewise; `LaunchedEffect(config) { reset the three drafts from
  config }`; build `OpenRouterSection(savedModelCount = config?.models?.size ?: 0,
  confirmingDelete = false, ...)`; handle `EditOpenRouter*` (set draft, `errors -= field` for the
  matching field), `ToggleOpenRouter`, and `SaveOpenRouter`: `when (val v = OpenRouterDraft(baseUrl,
  apiKey, modelsText).validate()) { is Valid -> { openRouter.save(v.config); errors = emptySet() }
  is Invalid -> errors = v.fields }`. Update all `ModelDownloadState(...)` constructions.
- [X] T017 [P] [US1] Create `APP/feature/modeldownload/presentation/component/OpenRouterCard.kt`:
  `@Composable fun OpenRouterCard(section: OpenRouterSection, onEvent: (ModelDownloadAction) ->
  Unit, modifier: Modifier = Modifier)` inside a `Surface` matching `ModelDownloadCard` (surface
  color, 16 dp radius, 16 dp padding); three Material3 `OutlinedTextField`s with
  `shape = RoundedCornerShape(12.dp)` and `OutlinedTextFieldDefaults.colors(focusedBorderColor =
  primary, unfocusedBorderColor = outlineVariant, focusedContainerColor = surface,
  unfocusedContainerColor = surface)`: Base URL (`singleLine`, `KeyboardType.Uri`, label
  `model_download_openrouter_base_url`, `isError = BASE_URL in errors`, `supportingText` error
  string when so, `testTag(OpenRouterCardTags.BASE_URL)`); API key (`singleLine`,
  `KeyboardType.Password`, `visualTransformation = if (visible) None else
  PasswordVisualTransformation()`, `visible` in `rememberSaveable`, trailing `IconButton` toggling
  it with `Icons.Rounded.Visibility`/`VisibilityOff` and the show/hide content descriptions,
  `supportingText` = `model_download_openrouter_api_key_hint`); Models (`minLines = 1, maxLines =
  4`, placeholder `model_download_openrouter_models_hint`, `isError = MODELS in errors`); a
  `Text` summary `pluralStringResource(R.plurals.model_download_openrouter_saved, n, n)` when
  `savedModelCount > 0` (`testTag(OpenRouterCardTags.SAVED)`); a `Row` with `XelaButton(text =
  model_download_openrouter_save, type = PRIMARY, onClick = { onEvent(SaveOpenRouter) })` tagged
  `SAVE`. `object OpenRouterCardTags { const val HEADER = "openrouter_header"; BASE_URL =
  "openrouter_base_url"; API_KEY = "openrouter_api_key"; MODELS = "openrouter_models"; SAVED =
  "openrouter_saved"; SAVE = "openrouter_save"; DELETE = "openrouter_delete"; DELETE_DIALOG =
  "openrouter_delete_dialog" }`. Add `@Preview` (light/dark) inside `ScottieTheme` with an
  unsaved and a saved section and `onEvent = {}`.
- [X] T018 [US1] Update `APP/feature/modeldownload/presentation/component/ModelSections.kt`: add
  parameter `openRouter: OpenRouterSection`; after the sections loop add `item(key = "openrouter",
  contentType = "openrouter") { ScottieAccordionHeader(title = stringResource(
  R.string.model_download_openrouter_title), countLabel = countLabel(openRouter.savedModelCount),
  expanded = openRouter.expanded, onToggle = { onEvent(ModelDownloadAction.ToggleOpenRouter) },
  modifier = Modifier.animateItem().testTag(OpenRouterCardTags.HEADER)) }` and, when
  `openRouter.expanded`, `item(key = "openrouter-card") { OpenRouterCard(openRouter, onEvent,
  Modifier.animateItem()) }`.
- [X] T019 [US1] Update `APP/feature/modeldownload/presentation/ModelDownloadUi.kt`: pass
  `state.openRouter` to `ModelSections`; in the `ModelDownloadContent.Unavailable` branch render a
  scrollable `Column` with `Message(...)` followed by `OpenRouterCard(state.openRouter,
  state.eventSink, Modifier.padding(horizontal = 16.dp))` (FR-015); also show the card when
  `content.sections.isEmpty() && state.query.isNotBlank()` is false but sections are empty.
  Update `previewState` to include a default `OpenRouterSection(baseUrl =
  OpenRouterConfig.DEFAULT_BASE_URL, apiKey = "", modelsText = "", errors = emptySet(),
  savedModelCount = 0, confirmingDelete = false, expanded = true)`.
- [X] T020 [US1] Update `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`:
  construct the presenter with `FakeOpenRouterConfigRepository`; tests: initial section has
  `baseUrl == DEFAULT_BASE_URL`, empty key/models, `savedModelCount == 0`; `EditOpenRouterApiKey`
  + `EditOpenRouterModels("a/b;c/d")` then `SaveOpenRouter` → `saves.single() ==
  OpenRouterConfig("https://openrouter.ai", key, listOf("a/b","c/d"))`, `errors` empty,
  `savedModelCount == 2`; empty key saves; existing config in the fake → drafts prefilled and
  `savedModelCount` matches; `ToggleOpenRouter` flips `expanded`.

**Checkpoint**: Settings shows the section; Save persists; relaunch restores (device: quickstart 1).

---

## Phase 4: User Story 2 - Chat with an OpenRouter model (Priority: P1)

**Goal**: remote models appear in the chat selector (marked), requests route to OpenRouter with the
saved key, failures show distinct messages.

**Independent Test**: quickstart scenarios 3, 4, 5.

- [X] T021 [P] [US2] Update `APP/feature/interacbanking/domain/entities/TextModelOption.kt`: add
  `val remote: Boolean = false` (KDoc: "True for an OpenRouter model; `name` is then the raw model
  id").
- [X] T022 [P] [US2] Create `APP/feature/interacbanking/domain/agent/workflow/InferenceFailure.kt`:
  `enum class InferenceFailure { OFFLINE, UNAUTHORIZED, MODEL_UNAVAILABLE, UNKNOWN }`; `class
  InferenceException(val failure: InferenceFailure, cause: Throwable) :
  RuntimeException(failure.name, cause)`; `fun interface FailureClassifier { fun classify(error:
  Throwable): InferenceFailure }`. No Koog, ktor, or Android imports.
- [X] T023 [US2] Update `APP/feature/interacbanking/domain/agent/workflow/IntentExtractor.kt`:
  `data class ResolvedModel(val executor: PromptExecutor, val model: LLModel)`; `ModelResolver`
  becomes `fun resolve(modelId: String): ResolvedModel` (KDoc: "Maps a model id to the Koog
  executor and model that run it"); `IntentExtractor` KDoc: "throws [InferenceException] on
  inference failure".
- [X] T024 [US2] Update `APP/feature/interacbanking/domain/agent/workflow/InteracAssistantAgent.kt`:
  constructor `(toolRegistry: ToolRegistry, models: ModelResolver, classifier:
  FailureClassifier)` (drop `executor`); in `extract`, `val (executor, model) =
  models.resolve(modelId)`, pass `executor` to `AIAgent`; wrap `agent.run(text)` in `try { }
  catch (e: CancellationException) { throw e } catch (@Suppress("TooGenericExceptionCaught") e:
  Exception) { throw InferenceException(classifier.classify(e), e) }`.
- [X] T025 [US2] Update `APP/di/InteracModule.kt`: (a) `textModelSource(repository,
  openRouter: OpenRouterConfigRepository)` → `models = combine(repository.catalog,
  openRouter.config) { catalog, config -> local options (unchanged) + config?.models.orEmpty().map
  { TextModelOption(OpenRouterConfig.remoteId(it), it, remote = true) } }`; (b) replace
  `modelResolver()` with `@Provides @Singleton fun modelResolver(onDevice: PromptExecutor,
  openRouter: OpenRouterConfigRepository): ModelResolver` holding a private
  `RemoteExecutorCache`-style closure: `var cached: Triple<String, String, PromptExecutor>?`;
  resolve = if `modelId.startsWith(OpenRouterConfig.ID_PREFIX)` → `config =
  openRouter.config.value ?: error("OpenRouter not configured")`; reuse the cached executor when
  `(baseUrl, apiKey)` match, else build `OpenRouterTextModels.executor(baseUrl, apiKey)` and
  cache (`@Synchronized` helper); return `ResolvedModel(executor,
  OpenRouterTextModels.llModel(modelId.removePrefix(ID_PREFIX)))`; otherwise
  `ResolvedModel(onDevice, OnDeviceTextModels.llModel(modelId))`; (c) `@Provides fun
  failureClassifier(): FailureClassifier = FailureClassifier(::classifyInference)` where
  `internal fun classifyInference(error: Throwable): InferenceFailure` walks
  `generateSequence(error) { it.cause }` and returns the first match: `KoogHttpClientException` with
  `statusCode` 401/403 → `UNAUTHORIZED`, 400/404 → `MODEL_UNAVAILABLE`; any `java.io.IOException`
  → `OFFLINE`; else `UNKNOWN`. Comment `// ponytail: 400 treated as bad model id; OpenRouter also
  uses 400 for malformed requests`; (d) `intentExtractor(registry, resolver, classifier)` →
  `InteracAssistantAgent(registry, resolver, classifier)`.
- [X] T026 [P] [US2] Tests in `TEST/di/InferenceFailureClassifierTest.kt`:
  `LLMClientException("c", cause = KoogHttpClientException(statusCode = 401))` → UNAUTHORIZED; 403
  → UNAUTHORIZED; 404 → MODEL_UNAVAILABLE; 400 → MODEL_UNAVAILABLE; `LLMClientException("c", cause
  = UnknownHostException())` → OFFLINE; `SocketTimeoutException` → OFFLINE; `IllegalStateException`
  → UNKNOWN; a 500 status → UNKNOWN.
- [X] T027 [US2] Update `APP/feature/interacbanking/presentation/InteracAssistantContract.kt`:
  `TurnReply.Failed` → `data class Failed(val failure: InferenceFailure)` (KDoc: "Inference failed;
  [failure] selects the message").
- [X] T028 [US2] Update `APP/feature/interacbanking/presentation/InteracAssistantPresenter.kt`:
  `extractOrNull` returns `Result`-like: change `respond` to call `runCatching {
  extractor.extract(text, modelId) }.getOrElse { if (it is CancellationException) throw it;
  Log.w(TAG, "inference failed", it); return TurnReply.Failed((it as?
  InferenceException)?.failure ?: InferenceFailure.UNKNOWN) }`; remove `extractOrNull`.
- [X] T029 [US2] Update `APP/feature/interacbanking/presentation/InteracAssistantUi.kt`: render
  `is TurnReply.Failed -> ReplyCard(textCard) { ReplyText(when (reply.failure) { OFFLINE ->
  R.string.chat_reply_offline; UNAUTHORIZED -> R.string.chat_reply_unauthorized;
  MODEL_UNAVAILABLE -> R.string.chat_reply_model_unavailable; UNKNOWN ->
  R.string.chat_reply_failed }) }`; update the failed preview to
  `TurnReply.Failed(InferenceFailure.UNKNOWN)` and add one with `OFFLINE`.
- [X] T030 [US2] Update `ModelSelector` in
  `APP/feature/interacbanking/presentation/component/ChatComponents.kt`: `DropdownMenuItem(text =
  { Row(horizontalArrangement = spacedBy(8.dp), verticalAlignment = CenterVertically) {
  Text(model.name); if (model.remote) Text(stringResource(R.string.chat_model_remote), style =
  MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant) } })`;
  extend the preview list with `TextModelOption("openrouter:openai/gpt-4o", "openai/gpt-4o", remote
  = true)`.
- [X] T031 [US2] Update `TEST/feature/interacbanking/domain/agent/workflow/InteracAssistantAgentTest.kt`:
  `agent(executor, registry)` → `InteracAssistantAgent(registry, { ResolvedModel(executor, model) },
  { InferenceFailure.UNKNOWN })`; change `modelLoadFailurePropagates` to assert an
  `InferenceException` with `failure == UNKNOWN` and the original cause; new test: resolver returns
  a `getMockExecutor` that throws `IllegalStateException("boom")` on any request → extract throws
  `InferenceException(OFFLINE)` when the fake classifier returns OFFLINE (proves the classifier is
  consulted).
- [X] T032 [US2] Update `TEST/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`:
  existing failure test asserts `TurnReply.Failed(InferenceFailure.UNKNOWN)`; new test:
  `extractor.enqueueFailure(InferenceException(InferenceFailure.OFFLINE,
  java.io.IOException()))` → last reply `Failed(OFFLINE)`, `busy == false`, user turn kept, Send
  works again; new test: `FakeTextModelSource` (or the existing fake) emitting a remote option
  `TextModelOption("openrouter:x/y", "x/y", remote = true)` as active → `Send` passes
  `"openrouter:x/y"` to the extractor.

**Checkpoint**: with a saved config and a valid key, the chat answers through OpenRouter; airplane
mode shows "No connection"; a bad key shows the authorization message (device: quickstart 3–5).

---

## Phase 5: User Story 3 - Remove the OpenRouter configuration (Priority: P2)

**Goal**: Delete with confirmation clears everything and resets the section; remote models vanish
from the selector and the active model falls back.

**Independent Test**: quickstart scenario 6.

- [X] T033 [US3] Add to `ModelDownloadAction` in
  `APP/feature/modeldownload/presentation/ModelDownloadScreen.kt`: `data object DeleteOpenRouter`
  (KDoc: "Opens the confirmation; ignored when nothing is saved"), `data object
  ConfirmDeleteOpenRouter`, `data object CancelDeleteOpenRouter`.
- [X] T034 [US3] Update `APP/feature/modeldownload/presentation/ModelDownloadPresenter.kt`:
  `confirmingDelete` in `rememberRetained { mutableStateOf(false) }`; `DeleteOpenRouter` → `if
  (config != null) confirmingDelete = true`; `ConfirmDeleteOpenRouter` → `openRouter.clear();
  confirmingDelete = false; errors = emptySet()` (the `LaunchedEffect(config)` from T016 resets the
  drafts to defaults); `CancelDeleteOpenRouter` → `confirmingDelete = false`; pass
  `confirmingDelete` into `OpenRouterSection`.
- [X] T035 [US3] Update `APP/feature/modeldownload/presentation/component/OpenRouterCard.kt`: when
  `section.savedModelCount > 0` add `XelaButton(text = stringResource(R.string.model_download_delete),
  type = XelaButtonType.SECONDARY, onClick = { onEvent(ModelDownloadAction.DeleteOpenRouter) })`
  tagged `OpenRouterCardTags.DELETE` beside Save.
- [X] T036 [US3] Update `APP/feature/modeldownload/presentation/ModelDownloadUi.kt`: when
  `state.openRouter.confirmingDelete` show Material3 `AlertDialog(onDismissRequest = {
  eventSink(CancelDeleteOpenRouter) }, title = model_download_openrouter_delete_title, text =
  model_download_openrouter_delete_text, confirmButton = TextButton(ConfirmDeleteOpenRouter,
  text model_download_delete), dismissButton = TextButton(CancelDeleteOpenRouter, text
  model_download_openrouter_cancel), modifier = Modifier.testTag(OpenRouterCardTags.DELETE_DIALOG))`
  with `containerColor = MaterialTheme.colorScheme.surface`.
- [X] T037 [US3] Tests in `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`:
  with a saved config, `DeleteOpenRouter` → `confirmingDelete == true`; `CancelDeleteOpenRouter`
  → false and `clears == 0`; `ConfirmDeleteOpenRouter` → `clears == 1`, `savedModelCount == 0`,
  drafts back to `DEFAULT_BASE_URL`/`""`/`""`; with no saved config `DeleteOpenRouter` is ignored.

**Checkpoint**: Delete → confirm → fields reset, selector shows only local models, chat falls back
or shows the empty state (device: quickstart 6).

---

## Phase 6: User Story 4 - Validation guides the user (Priority: P2)

**Goal**: field-level errors on Save for bad URL or empty models; errors clear on edit; lenient
parsing of separators and duplicates.

**Independent Test**: quickstart scenario 2.

- [X] T038 [US4] Verify and, where missing, complete error rendering in
  `APP/feature/modeldownload/presentation/component/OpenRouterCard.kt`: Base URL `supportingText`
  shows `model_download_openrouter_error_base_url` in `MaterialTheme.colorScheme.error` when
  `OpenRouterField.BASE_URL in section.errors`; Models shows
  `model_download_openrouter_error_models` when `MODELS in section.errors`; both fields set
  `isError`; the API key hint stays visible. Add a preview with both errors set.
- [X] T039 [US4] Tests in `TEST/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`:
  `EditOpenRouterBaseUrl("")` + `SaveOpenRouter` → `errors == setOf(BASE_URL)`, `saves` empty;
  `EditOpenRouterBaseUrl("openrouter.ai/api/v1")` → same; valid URL but
  `EditOpenRouterModels(" ; ")` → `errors == setOf(MODELS)`; both bad → both errors;
  `EditOpenRouterModels("a/b")` after a MODELS error clears only that error; `"a/b ; c/d;"` → saved
  models `["a/b","c/d"]`; `"a/b;a/b"` → `["a/b"]`; `EditOpenRouterBaseUrl("http://10.0.2.2:8080")`
  saves.

**Checkpoint**: invalid input never reaches the repository; error text appears under the right
field and disappears on edit (device: quickstart 2).

---

## Phase 7: Polish & Cross-Cutting

- [ ] T040 Review `APP/feature/modeldownload/presentation/ModelDownloadUi.kt` and
  `OpenRouterCard.kt` previews in light and dark (`uiMode = UI_MODE_NIGHT_YES`) and large font
  (`fontScale = 2f`); fix any clipped error text or button wrapping.
- [X] T041 Run `./gradlew :app:testDebugUnitTest :app:detekt :app:lintDebug :app:assembleDebug` from
  the repository root and fix findings (detekt: `LongParameterList` 10, `LongMethod` 100 lines;
  keep `OpenRouterCard` under the limit by extracting a private `OpenRouterField` composable if
  needed).
- [ ] T042 Run `./gradlew :app:connectedDebugAndroidTest` on a connected device or emulator
  (constitution IV: Settings and chat behaviour change); report the result, or the skip and its
  reason if no device is available.
- [ ] T043 Device walk-through per `specs/008-openrouter-api-support/quickstart.md` scenarios 1–9
  (offline save, validation incl. `http://10.0.2.2:8080`, remote chat, failure messages,
  remote-only, delete, selection persistence, logcat key check, light/dark); record which were
  observed vs not run.

---

## Dependencies

```text
T001, T002 [P]
T003 → T005
T004 → T006 → T007 → T009
T004 → T008
T010 → T011 → T012 (needs T008)
T013 → T014
Phase 2 done → US1 (T015 → T016 → T017/T018 → T019 → T020)
            → US2 (T021, T022 → T023 → T024 → T025 → T026; T027 → T028 → T029; T030; T031, T032)
US1 done → US3 (T033 → T034 → T035 → T036 → T037)
US1 done → US4 (T038 → T039)
All stories → Polish (T040 → T041 → T042 → T043)
```

- US1 and US2 touch disjoint files (modeldownload presentation vs interacbanking + di) and can run
  in parallel once Phase 2 is done.
- US3 and US4 both edit `ModelDownloadPresenter.kt`, `OpenRouterCard.kt`, and the presenter test;
  run them sequentially after US1.
- T025 depends on T011 (remote ids in `activeTextModel`) and T013 (`OpenRouterTextModels`).

## Parallel examples

- Phase 1: T001 + T002.
- Phase 2: T003 + T004 + T013 together; then T005 + T008 + T014; T006 → T007 → T009 alongside
  T010 → T011 → T012.
- US1: T017 alongside T015/T016; then T018 → T019 → T020.
- US2: T021 + T022 together; T026 alongside T027–T030; T031 + T032 together at the end.
- Across stories: all of US2 while US1 is in progress.

## Implementation Strategy

1. MVP = Phase 1 + Phase 2 + US1 + US2: the user can save a configuration and chat through a
   remote model with meaningful failure messages.
2. Add US3 (delete with confirmation), then US4 (error display and parsing edge cases; the entity
   validation already exists from Phase 2).
3. Polish: previews, full Gradle checks, instrumentation, device walk-through with logcat key check.
