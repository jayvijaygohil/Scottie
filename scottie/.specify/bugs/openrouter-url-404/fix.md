# Bug Fix: OpenRouter save returns 404; drop base-URL normalization

- **Slug**: openrouter-url-404
- **Fixed**: 2026-10-10
- **Assessment**: ./assessment.md
- **Status**: applied

## Summary

Removed `OpenRouterTextModels.normalize()`. The base URL now reaches Koog unchanged, and the models
fetch joins it the same way Koog does. Validation now accepts only a bare http(s) origin (the format
Koog expects, e.g. `https://openrouter.ai`), so URLs that include a path are rejected at save
instead of producing a 404.

## Changes

| File | Change | Notes |
|------|--------|-------|
| `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt` | modified | `normalize()` removed; `baseUrl` passed to `OpenRouterClientSettings` unchanged |
| `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/data/remote/OpenRouterModelsClient.kt` | modified | `baseUrl.removeSuffix("/") + "/api/v1/models"`, which matches Koog's slash join |
| `app/src/main/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfig.kt` | modified | `isWebAddress` also requires the path to be empty or `/`, with no query and no fragment |
| `app/src/main/res/values/strings.xml` | modified | Error text: "Enter the server address only, like https://openrouter.ai" |
| `app/src/test/java/com/jayvijay/scottie/core/ai/OpenRouterTextModelsTest.kt` | removed test | `normalizeStripsApiPathAndSlashes` |
| `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/domain/entities/OpenRouterConfigTest.kt` | updated test | Renamed to `baseUrlMustBeBareHttpOrigin`; adds path, query, and fragment cases and a valid trailing `/` |
| `app/src/test/java/com/jayvijay/scottie/feature/modeldownload/presentation/ModelDownloadPresenterTest.kt` | updated test | Adds `$URL/api/v1` to `invalidBaseUrlReportsErrorWithoutSaving` |

## Diff Highlights

```kotlin
return (scheme == "http" || scheme == "https") &&
  !uri.host.isNullOrBlank() &&
  uri.rawPath.orEmpty() in setOf("", "/") &&
  uri.rawQuery == null &&
  uri.rawFragment == null
```

## Tests Added or Updated

- `OpenRouterConfigTest::baseUrlMustBeBareHttpOrigin`: `/api/v1`, `/api`, `/api/v1/models`, `?q=1`,
  and `#x` are rejected; `https://openrouter.ai/` and `http://192.168.1.20:8080` are accepted.
- `ModelDownloadPresenterTest::invalidBaseUrlReportsErrorWithoutSaving`: `/api/v1` shows the field
  error and nothing is saved.

## Local Verification

- `./gradlew :app:testDebugUnitTest :app:detekt` → passed.
- Manual checks: none. The original 404 has not been reproduced on a device.

## Deviations from Assessment

**Revised after device report (2026-10-10).** The base URL `https://routellm.abacus.ai` still
returned 404. RouteLLM is OpenAI-compatible but serves `/v1/models`, not OpenRouter's
`/api/v1/models`. Probed without a key: `/api/v1/models` returns 404 and `/v1/models` returns 200.
The real root cause was the hardcoded `api/v1` path, not normalization.

- The base URL now includes the API version path (`https://openrouter.ai/api/v1`,
  `https://routellm.abacus.ai/v1`). The models client appends `/models`, and Koog gets
  `chatCompletionsPath = "chat/completions"` and `modelsPath = "models"`.
- `DEFAULT_BASE_URL` is now `https://openrouter.ai/api/v1`. Paths are allowed again; only queries
  and fragments are rejected.
- The error copy now reads "Enter the API base URL, like https://openrouter.ai/api/v1".
- Tests: the RouteLLM URL is valid; `?q=1` is the presenter's invalid case.
- Re-ran `./gradlew :app:testDebugUnitTest :app:detekt` → passed.

## Follow-ups

- A config saved as a bare origin (`https://openrouter.ai`) now 404s until it is re-entered with
  the version path.
- Verify on a device: save `https://openrouter.ai` with a real key and confirm the model list loads
  and chat works.
