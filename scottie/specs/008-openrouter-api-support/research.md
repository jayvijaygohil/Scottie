# Research: OpenRouter API Support

All decisions verified against the current source and the resolved dependency graph
(`./gradlew :app:dependencies --configuration debugRuntimeClasspath`) and the Koog 1.3.0 sources
jars in the Gradle cache.

## R1 — Is the OpenRouter client already available?

- **Decision**: Yes. `ai.koog:prompt-executor-openrouter-client:1.3.0` (and its `-android`
  variant) is on `debugRuntimeClasspath`, pulled by `koog-agents-additions:1.3.0-beta` →
  `prompt-executor-llms-all:1.3.0-beta`. The `koog-agents` aggregate alone does not include it
  (its POM lists OpenAI, Anthropic, Bedrock, Ollama only), so the dependency on
  `koog-agents-additions` must stay. No catalog change.
- **API** (from sources): `OpenRouterLLMClient(apiKey: String, settings: OpenRouterClientSettings
  = OpenRouterClientSettings())` top-level factory function (`OpenRouterClientFactory.kt`) resolves
  the HTTP factory via `HttpClientFactoryResolver`. `OpenRouterClientSettings(baseUrl =
  "https://openrouter.ai", chatCompletionsPath = "api/v1/chat/completions", ...)`. The client
  reports `LLMProvider.OpenRouter`. `MultiLLMPromptExecutor` and `SingleLLMPromptExecutor` are
  already used/available.
- **Alternatives rejected**: adding `prompt-executor-openrouter-client` explicitly to the catalog
  (redundant; violates "no speculative dependencies"); any other HTTP/LLM library.

## R2 — Base URL semantics

- **Decision**: The Settings field holds the server origin, prefilled with
  `https://openrouter.ai`. Before constructing the client, `core/ai/OpenRouterTextModels`
  normalises the saved value: trim, strip trailing `/`, and strip a trailing `/api/v1` (OpenRouter's
  documented base URL), because Koog appends `api/v1/chat/completions` itself. The value is saved as
  typed (spec edge case) and only normalised at use.
- **Rationale**: users copy `https://openrouter.ai/api/v1` from OpenRouter docs; double-prefixing
  would fail every request with a confusing 404.
- **Validation** (domain, `OpenRouterDraft.validate()`): `java.net.URI` parses, scheme is `http`
  or `https` (clarified 2026-10-10: both accepted, any host), host non-blank. JVM stdlib only, so
  it stays in `domain/`.
- **Cleartext**: Android 9+ blocks plain `http` by default and the manifest sets no cleartext
  policy today, so `http` URLs would fail with an I/O error (shown as "No connection"). Decision:
  add `app/src/main/res/xml/network_security_config.xml` with
  `<base-config cleartextTrafficPermitted="true">` and reference it from the manifest
  `<application android:networkSecurityConfig=...>`. The user's clarification allows any host, so
  a per-domain allow-list is not possible. Marked `// ponytail: cleartext allowed app-wide; tighten
  to domain-config entries if the gateway hosts become known`.
- **Alternatives rejected**: storing the normalised URL (loses the user's text); accepting
  scheme-less input (spec says invalid, with a hint to add `http://` or `https://`);
  `android:usesCleartextTraffic="true"` on `<application>` (equivalent effect, but the XML config
  is the documented place to narrow it later).

## R3 — Storage of the configuration and the API key

- **Decision**: `OpenRouterConfigRepositoryImpl` writes one JSON file
  (`filesDir/openrouter_config.json`) with kotlinx serialization using the `Json` already provided
  in `di/DataModule`; read once at construction into a `MutableStateFlow`, written on the
  application scope. Same pattern as `active_text_model`. Plain text in app-private storage.
- **Rationale**: no `androidx.security:security-crypto` or DataStore in the catalog; constitution
  forbids new libraries without an explicit requirement; the spec only requires the key never to
  appear in logs or error text. The field is masked and `toString` of the config redacts the key.
- **Marked**: `// ponytail: plaintext app-private file; EncryptedFile if the key must survive a
  rooted-device threat model`.
- **Alternatives rejected**: `SharedPreferences` (same security, less structured for a list);
  Android Keystore wrapping (new code for a threat the spec does not require).

## R4 — Where the configuration lives and how the chat sees remote models

- **Decision**: `feature/modeldownload` owns `OpenRouterConfig`, its validation, and
  `OpenRouterConfigRepository`. Remote model ids are namespaced as
  `OpenRouterConfig.ID_PREFIX + modelId` (`openrouter:openai/gpt-4o`) so they can share the single
  `activeTextModel` string with `.litertlm` file names. `ModelDownloadRepositoryImpl` combines
  catalog, stored id, and `openRouter.config` to resolve the active model (stored id if local
  downloaded or remote configured; else first downloaded text model; else first remote; else null)
  and `selectTextModel` accepts either kind. The `di/InteracModule` `TextModelSource` adapter emits
  local options first, then remote options with `remote = true` and `name = modelId`.
- **Rationale**: one owner of "which models exist and which is active" (feature 007 R1), reactive
  updates when the configuration changes, and no feature-to-feature import.
- **Alternatives rejected**: a separate `activeRemoteModel` (two actives, ambiguous UI); putting
  the config in `core/ai` (would make core own persistence and a feature-facing contract).

## R5 — Routing inference to the right executor

- **Decision**: `ModelResolver.resolve(modelId)` returns `ResolvedModel(executor: PromptExecutor,
  model: LLModel)`. `InteracAssistantAgent` passes both to the per-request `AIAgent`. In
  `di/InteracModule`: ids with the prefix resolve to `OpenRouterTextModels.llModel(raw)` and a
  cached `SingleLLMPromptExecutor(OpenRouterLLMClient(apiKey, settings))` rebuilt when
  `(baseUrl, apiKey)` changes (previous client closed); other ids resolve to the existing LiteRT
  `PromptExecutor` and `OnDeviceTextModels.llModel`.
- **Rationale**: the agent already constructs one `AIAgent` per request from an executor and a
  model, so swapping both per model is the smallest change. It avoids implementing Koog's
  multi-method `LLMClient` interface as a switching wrapper and avoids a mutable
  `MultiLLMPromptExecutor`.
- **Alternatives rejected**: a delegating `LLMClient` for `LLMProvider.OpenRouter` inside the
  existing `MultiLLMPromptExecutor` (more surface, same behaviour); rebuilding the whole executor
  on config change (would recreate the warm LiteRT engine).

## R6 — `LLModel` for an arbitrary OpenRouter id

- **Decision**: `OpenRouterTextModels.llModel(id)` = `OpenRouterModels.models.find { it.id == id }`
  or `LLModel(provider = LLMProvider.OpenRouter, id, capabilities = [Temperature, Tools,
  Completion], contextLength = 128_000, maxOutputTokens = 4_096)`, mirroring
  `OnDeviceTextModels.llModel` and Koog's `standardCapabilities` (minus `Speculation`, unused).
- **Rationale**: the agent uses tools and plain completion; structured repair uses
  `StructureFixingParser` which needs only completion. Unknown ids must still work (spec: ids are
  not validated against the remote catalog).

## R7 — Failure classification (FR-021)

- **Decision**: domain `enum InferenceFailure { OFFLINE, UNAUTHORIZED, MODEL_UNAVAILABLE,
  UNKNOWN }`, `class InferenceException(val failure, cause)`, and `fun interface
  FailureClassifier { fun classify(error: Throwable): InferenceFailure }` in
  `interacbanking/domain/agent/workflow/`. The agent wraps any non-cancellation failure of
  `agent.run` in `InferenceException(classifier.classify(e), e)`. The classifier implementation in
  `di/InteracModule` walks the cause chain: `KoogHttpClientException.statusCode` 401/403 →
  UNAUTHORIZED, 400/404 → MODEL_UNAVAILABLE; any `java.io.IOException` (UnknownHost, Connect,
  SocketTimeout) → OFFLINE; else UNKNOWN. Koog wraps transport errors in `LLMClientException(cause)`
  and the HTTP layer raises `KoogHttpClientException(statusCode, errorBody)`, both verified in
  sources.
- **Marked**: `// ponytail: 400 treated as bad model id; OpenRouter also uses 400 for malformed
  requests`.
- **Presenter/UI**: `TurnReply.Failed(failure)`; UI maps to `chat_reply_offline`,
  `chat_reply_unauthorized`, `chat_reply_model_unavailable`, `chat_reply_failed`. The key never
  appears: only the enum reaches presentation, and the presenter's existing `Log.w` logs the
  exception message, which Koog builds from client name, status, and body — the request headers are
  not included. The errorBody could echo user text but never the key.
- **Alternatives rejected**: classifying in the presenter (would import ktor/Koog exception types
  into presentation); string-matching messages (fragile).

## R8 — Settings section rendering

- **Decision**: a trailing `item(key = "openrouter")` in `ModelSections`' `LazyColumn` with
  `ScottieAccordionHeader` ("OpenRouter", count label from `model_section_count` plural using the
  saved model count) and an `OpenRouterCard` composable: three Material3 `OutlinedTextField`s
  (12 dp shape, `surface`/`outlineVariant` colors matching `ScottieSearchField`; key field uses
  `PasswordVisualTransformation` with a show/hide icon button; `isError` + `supportingText` for
  field errors), a saved summary line, and `XelaButton` Save (PRIMARY) / Delete (SECONDARY, only
  when saved). Delete confirmation is a Material3 `AlertDialog`. When the catalog is `Unavailable`,
  `ModelDownloadUi` shows the message and the card so remote use remains possible (FR-015).
- **Rationale**: `XelaTextField` requires `MutableState` ownership, which conflicts with
  unidirectional Circuit state; `OutlinedTextField` with theme colors is the smaller path.
- **Alternatives rejected**: a new screen (spec says Download screen); `XelaTextField`
  (state-ownership mismatch); `XelaDialog` (unused in the app today, `AlertDialog` is standard).

## R9 — Draft state and "saved" feedback

- **Decision**: the presenter holds `rememberRetained` draft fields initialised from the current
  config and re-initialised on save, delete, or an external config change (`LaunchedEffect` on the
  config flow). Validation runs on Save only; a field's error clears when it is edited. Feedback is
  an inline summary under the fields ("Saved · N models" plural) rather than a toast, which also
  satisfies the "short confirmation" without changing the existing error-toast type.
- **Alternatives rejected**: toast via `ModelDownloadError` (misnamed slot, test churn).
