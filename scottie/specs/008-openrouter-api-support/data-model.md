# Data Model: OpenRouter API Support

Only additions and changes; feature 005/007 banking and chat entities are otherwise unchanged.

## modeldownload (owner of the configuration)

### `OpenRouterConfig` (domain/entities) — new, `@Serializable`

| Field | Type | Rule |
|---|---|---|
| `baseUrl` | `String` | As typed; non-blank; parses as `http`/`https` URI with a host. |
| `apiKey` | `String` | May be empty. Redacted in `toString()`. |
| `models` | `List<String>` | Non-empty; trimmed, no blanks, no duplicates, first-seen order. |

Companion: `DEFAULT_BASE_URL = "https://openrouter.ai"`, `ID_PREFIX = "openrouter:"`,
`fun remoteId(model) = ID_PREFIX + model`, `val modelIds: List<String>` (prefixed).

### `OpenRouterDraft` (domain/entities) — new

| Field | Type |
|---|---|
| `baseUrl`, `apiKey`, `modelsText` | `String` |

`fun validate(): OpenRouterValidation` →
`Valid(config)` or `Invalid(fields: Set<OpenRouterField>)` where
`enum OpenRouterField { BASE_URL, MODELS }`. Parsing: split on `;`, trim, drop empty, distinct.

### `OpenRouterConfigRepository` (domain/repository) — new, declarations only

| Member | Type | Notes |
|---|---|---|
| `config` | `StateFlow<OpenRouterConfig?>` | Null when nothing saved. |
| `save(config)` | `fun(OpenRouterConfig)` | Replaces the single configuration; persists. |
| `clear()` | `fun()` | Removes it; persists the removal. |

Impl `OpenRouterConfigRepositoryImpl(file: @Named("openRouterConfigFile") File, json: Json,
scope: @ApplicationScope CoroutineScope)`: reads the file at construction (malformed → null and
`Log.w` without contents), writes/deletes on `scope`.

### `ModelDownloadRepository` (domain/repository) — contract wording changed

| Member | New rule |
|---|---|
| `activeTextModel` | Stored id if it is a downloaded `TEXT` model **or a configured remote id**; else first downloaded text model in catalog order; else first configured remote id; else null. Recomputed when catalog, stored id, or OpenRouter config changes. |
| `selectTextModel(id)` | Persists `id`; ignored unless it is a downloaded text model **or a configured remote id**. |

Impl gains an `OpenRouterConfigRepository` constructor dependency and combines its `config` flow.

## core/ai

### `OpenRouterTextModels` — new `object`

| Member | Notes |
|---|---|
| `llModel(modelId: String): LLModel` | Known `OpenRouterModels` entry or generic (Temperature, Tools, Completion; 128k context; 4k output). |
| `executor(baseUrl: String, apiKey: String): PromptExecutor` | `SingleLLMPromptExecutor(OpenRouterLLMClient(apiKey, OpenRouterClientSettings(normalize(baseUrl))))`. |
| `normalize(baseUrl: String): String` | trim; strip trailing `/`; strip trailing `/api/v1`. |

## interacbanking (consumer)

### `TextModelOption` (domain/entities) — changed

| Field | Type | Notes |
|---|---|---|
| `id` | `String` | `.litertlm` file name, or `openrouter:<model>`. |
| `name` | `String` | Catalog name, or the raw OpenRouter model id. |
| `remote` | `Boolean` | New, default `false`; drives the selector marker. |

### `ModelResolver` (domain/agent/workflow) — changed

`fun resolve(modelId: String): ResolvedModel` with
`data class ResolvedModel(val executor: PromptExecutor, val model: LLModel)`.

### `InferenceFailure`, `InferenceException`, `FailureClassifier` (domain/agent/workflow) — new

| Item | Definition |
|---|---|
| `enum InferenceFailure` | `OFFLINE`, `UNAUTHORIZED`, `MODEL_UNAVAILABLE`, `UNKNOWN` |
| `class InferenceException(val failure: InferenceFailure, cause: Throwable)` | Thrown by `IntentExtractor.extract` on inference failure. |
| `fun interface FailureClassifier { fun classify(error: Throwable): InferenceFailure }` | Implemented in `di/`. |

`InteracAssistantAgent(executor removed; models: ModelResolver, toolRegistry, classifier)`.

### `TurnReply` (presentation) — changed

`data object Failed` → `data class Failed(val failure: InferenceFailure)`.

## modeldownload presentation — changed

### `ModelDownloadState` — addition

| Field | Type |
|---|---|
| `openRouter` | `OpenRouterSection` |

```kotlin
data class OpenRouterSection(
  val baseUrl: String,          // draft
  val apiKey: String,           // draft
  val modelsText: String,       // draft
  val errors: Set<OpenRouterField>,
  val savedModelCount: Int,     // 0 → nothing saved → no Delete button, no summary
  val confirmingDelete: Boolean,
  val expanded: Boolean,
)
```

### `ModelDownloadAction` — additions

| Action | Presenter behaviour |
|---|---|
| `EditOpenRouter(field: OpenRouterField or API_KEY, value)` → modelled as three data classes `EditBaseUrl(value)`, `EditApiKey(value)`, `EditModels(value)` | Updates the draft; clears that field's error. |
| `SaveOpenRouter` | `draft.validate()`: `Valid` → `repository.save(config)`, errors cleared; `Invalid` → `errors = fields`, nothing stored. |
| `DeleteOpenRouter` | `confirmingDelete = true` (only when saved). |
| `ConfirmDeleteOpenRouter` | `repository.clear()`; draft reset to defaults; `confirmingDelete = false`. |
| `CancelDeleteOpenRouter` | `confirmingDelete = false`. |
| `ToggleOpenRouter` | Flips `expanded` (independent of catalog section expansion). |

### State transitions

```text
unsaved ──Save(valid)──▶ saved(N) ──Delete──▶ confirming ──Confirm──▶ unsaved
   ▲                        │                     │
   └──Save(invalid): errors shown, stays──┘       └──Cancel──▶ saved(N)
active model: stored id ∈ local ∪ remote ? stored : local.first ?: remote.first ?: null
```
