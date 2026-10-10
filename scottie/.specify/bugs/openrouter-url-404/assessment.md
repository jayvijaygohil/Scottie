# Bug Assessment: OpenRouter save returns 404; drop base-URL normalization

- **Slug**: openrouter-url-404
- **Created**: 2026-10-10
- **Source**: pasted text
- **Verdict**: likely valid, needs reproduction
- **Severity**: medium

## Report (verbatim)

> When saving the Openrouter supported API + API Key, I see a 404. When manually running a curl
> command, the models are fetched just fine. Can we see what Koog is expecting as the URL and just
> ask user to put in the same format instead of trying to normalize various edge cases? So,
> basically remove the normalization completely.

## Symptom

Saving the OpenRouter base URL and key in Settings triggers a models fetch, and the server returns
HTTP 404. A manual `curl` of the models endpoint with the same key succeeds. Expected: the fetch
succeeds and the model list loads.

## Reproduction

1. Open Settings → OpenRouter card.
2. Enter a base URL [NEEDS CLARIFICATION: the exact string entered] and a valid API key.
3. Tap Save. The fetch fails, and logcat shows `OpenRouterModels: models listing failed: HTTP 404`.

## What Koog expects (verified against Koog 1.3.0 sources in the Gradle cache)

- `OpenRouterClientSettings(baseUrl = "https://openrouter.ai", chatCompletionsPath =
  "api/v1/chat/completions", modelsPath = "api/v1/models", ...)`
- `KtorKoogHttpClient` appends a trailing `/` to `baseUrl` when it is missing, then uses it as
  Ktor's `defaultRequest` base. The relative paths above resolve against it.
- **Format to require: the scheme and host only, e.g. `https://openrouter.ai`.** Koog adds the
  `api/v1/...` paths itself, and a trailing slash is harmless.

## Suspected Code Paths

- `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt:16`: `normalize()`
  only strips a trailing `/api/v1` and slashes. Any other path survives and gets `/api/v1/...`
  appended. For example, `.../api/v1/models` becomes `.../api/v1/models/api/v1/models` and
  `.../api` becomes `.../api/api/v1/models`. Both return 404.
- `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/data/remote/OpenRouterModelsClient.kt:28`:
  the hand-built models URL (`normalize(baseUrl) + "/api/v1/models"`). This is the path the save
  flow hits, and it is separate from Koog's URL construction.
- `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt:41`: Koog receives the
  normalized URL.
- `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfig.kt:59`:
  `OpenRouterDraft.validate()` accepts any http(s) URL with any path, so bad shapes pass validation
  and reach the network.

## Root Cause Hypothesis

Validation accepts URLs that have arbitrary paths. A best-effort normalizer then rewrites only one
of those shapes (`/api/v1`), and every other path gets `/api/v1/models` appended, which produces a
404. curl works because the user types the full endpoint URL by hand. Confidence: medium. The
mechanism is verified, but the exact string the user entered is unknown.

## Proposed Remediation

**Preferred**: delete the normalization and enforce Koog's format at the trust boundary.

1. Delete `OpenRouterTextModels.normalize()`. Pass `baseUrl` to `OpenRouterClientSettings`
   verbatim.
2. In `OpenRouterModelsClient`, build the URL the way Koog does:
   `baseUrl.removeSuffix("/") + "/" + modelsPath`. Read `modelsPath` from
   `OpenRouterClientSettings().modelsPath` or keep the local `PATH` constant. This matches Koog's
   "append `/` if missing" rule and is not a rewrite.
3. Make `OpenRouterDraft.validate()` reject any URL that has a path other than empty or `/`, a
   query, or a fragment. Keep the existing whitespace trim.
4. Update `model_download_openrouter_error_base_url` (and add field supporting text if the card
   has room) to name the format: "Enter the server address only, e.g. https://openrouter.ai".

**Alternatives**:
- Accept a path prefix (Koog supports `https://proxy/prefix` + `api/v1/...`) and validate only the
  scheme and host. This is more flexible for proxies, but users can still paste `/api/v1` and get
  a 404, which is the confusion this report wants gone.
- Keep `normalize()` and add more suffixes. The user rejected this.

**Files likely to change**:
- `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt`
- `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/data/remote/OpenRouterModelsClient.kt`
- `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfig.kt`
- `app/src/main/res/values/strings.xml`
- `app/src/test/java/com/jayvijay/scottie/core/ai/OpenRouterTextModelsTest.kt`
- `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfigTest.kt`
- `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt`

**Tests to add or update**:
- Delete `normalizeStripsApiPathAndSlashes`.
- `OpenRouterConfigTest`: `https://openrouter.ai/api/v1`, `https://openrouter.ai/api`,
  `https://openrouter.ai/api/v1/models`, and `https://x?q=1` are invalid.
  `https://openrouter.ai`, `https://openrouter.ai/`, and `http://10.0.2.2:8080` are valid.
- `ModelDownloadPresenterTest.invalidBaseUrlReportsErrorWithoutSaving`: add an `/api/v1` case.

## Risks & Considerations

- **Saved configs containing `/api/v1`**: `validate()` previously stored the trimmed URL verbatim,
  and the normalizer fixed it at use time. After the fix, these configs build 404 URLs until the
  user edits them, and the next Save flags the field. A one-line note in the fix is enough. A data
  migration is not justified for a single-user dev app. [NEEDS CLARIFICATION: confirm.]
- Self-hosted proxies that need a path prefix are rejected under the preferred fix.
- The chat path (Koog) and the models path (custom client) still build URLs separately. They must
  follow the same rule, and step 2 covers that.

## Open Questions

- [NEEDS CLARIFICATION: Exact base URL string entered when the 404 occurred.]
- [NEEDS CLARIFICATION: Should path prefixes (proxies) be rejected (preferred) or allowed?]
