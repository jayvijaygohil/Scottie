# Research: OpenRouter Model Picker

No Technical Context item was left as NEEDS CLARIFICATION. Decisions below come from reading the
008 code and the installed Koog 1.3.0 sources.

## R1. How to fetch the model list

- **Decision**: New `data/remote/OpenRouterModelsClient` using `java.net.HttpURLConnection` on
  `Dispatchers.IO`, sending `Authorization: Bearer <key>` only when the key is non-blank, and
  decoding with the app's existing `Json` (`ignoreUnknownKeys = true`) into private `@Serializable`
  DTOs holding only `id`, `name`, `architecture.output_modalities`, and `links.next`, all
  nullable.
- **Rationale**: No new dependency. Optional nullable fields satisfy the "missing id / missing
  name" edge cases instead of failing the whole page.
- **Alternatives considered**:
  - Koog `OpenRouterLLMClient.models()`: returns `List<LLModel>` that drops `name` and
    `output_modalities`, reads one page only, and its internal DTO requires `canonical_slug`,
    `created`, `description`, `pricing`, `tokenizer`, `top_provider`; one missing field fails
    the fetch. Rejected.
  - Ktor directly: only a transitive dependency of Koog; using it means declaring it in the
    version catalog for one GET. Rejected.

## R2. URL and paging

- **Decision**: First page is `OpenRouterTextModels.normalize(baseUrl) + "/api/v1/models"`.
  While `links.next` is non-null and non-blank, resolve it against the current page URL
  (`URI.resolve`, which covers absolute and relative values) and fetch it. Stop on null; also stop
  if a `next` URL repeats, to avoid looping on a broken server.
- **Rationale**: Reuses 008's normalization, so a pasted `.../api/v1` keeps working (FR-003).

## R3. Text filter, dedupe, order

- **Decision**: Keep an entry when `id` is non-blank and `output_modalities` contains `"text"`
  (case-insensitive) **or is absent**. Display name falls back to `id`. Dedupe by `id`, first
  occurrence wins. Sort by display name, case-insensitive, with `id` breaking ties.
- **Rationale**: OpenRouter-compatible servers often omit `architecture`; dropping those would
  show "no models available" for working servers. FR-004 targets models known not to output text
  (for example image-only).

## R4. Failure kinds

- **Decision**: `UnknownHostException`, `ConnectException`, `SocketTimeoutException`, and other
  `IOException` before a response → `NO_CONNECTION`; HTTP 401/403 → `AUTH`; any other non-2xx or
  undecodable body → `OTHER`. Logs record kind and HTTP status only, never headers or the key
  (FR-013). Timeouts are 15 s for connect and read.
- **Rationale**: Exactly the three messages FR-008 requires.

## R5. Where the selection lives

- **Decision**: The selection is `OpenRouterConfig.models`, unchanged on disk. Save keeps the
  current `models` and replaces only URL and key. Toggling calls the existing `save()` with
  `models` rebuilt in fetched-list order. After a successful fetch the repository drops ids that
  are no longer listed and reorders the rest to fetched order (FR-010, spec assumption on order).
- **Rationale**: Chat (`di/InteracModule.kt`) already maps `config.models` to remote options, so
  FR-006 needs no chat change, and 008 typed ids become the initial selection with no migration
  (FR-011). Delete already clears the file (FR-012).
- **Alternatives considered**: A separate selection file or repository. Rejected: a second source
  of truth for what chat offers.

## R6. When to fetch, and surviving rotation

- **Decision**: The presenter keeps a retained `fetchRequest` counter, incremented by Save, Retry,
  and first composition with a saved config. A `LaunchedEffect(fetchRequest)` fetches only when
  the retained result is not already for that request number, so recomposition after rotation
  does not refetch. Delete resets the result to hidden.
- **Rationale**: `StateFlow` deduplicates an equal config, so keying on the config would miss a
  Save with unchanged values (FR-002 still requires the request).

## R7. Section order and collapse

- **Decision**: In `ModelSections`, emit the OpenRouter header and card items before the catalog
  sections. Default expansion becomes `false`: `expansion[type] ?: false` in `catalogSections` and
  `rememberRetained { mutableStateOf(false) }` for OpenRouter. The search auto-expand rule is
  unchanged. The `Unavailable` branch already shows the card open with no accordion, so it stays.
- **Rationale**: `rememberRetained` lives while Settings is on the back stack: it survives
  rotation and is discarded when the user leaves, which is clarification answer A with no
  storage.

## R8. In-card search

- **Decision**: The query is retained presenter state; filtering is a pure function on the fetched
  list (case-insensitive substring of name or id). Checks are not touched by filtering (FR-007).
- **Rationale**: Survives rotation and is unit-testable without UI.
