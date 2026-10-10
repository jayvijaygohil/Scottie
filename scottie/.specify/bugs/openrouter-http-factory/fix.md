# Bug Fix: OpenRouter client finds no HTTP client factory on Android

- **Slug**: openrouter-http-factory
- **Fixed**: 2026-10-10
- **Assessment**: ./assessment.md
- **Status**: applied

## Summary

`OpenRouterTextModels.executor` now passes `KtorKoogHttpClient.Factory()` to
`OpenRouterLLMClient` explicitly. It no longer relies on Koog's `ServiceLoader` discovery, which
finds nothing on Android because the `http-client-ktor-android` AAR has no service registration.

## Changes

| File | Change | Notes |
|------|--------|-------|
| `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt` | modified | Uses the constructor that takes `httpClientFactory`; KDoc says why |
| `app/src/test/java/com/jayvijay/scottie/core/ai/OpenRouterTextModelsTest.kt` | added test | Builds and closes the executor |

## Diff Highlights

```kotlin
OpenRouterLLMClient(
  apiKey = apiKey,
  settings = OpenRouterClientSettings(baseUrl = normalize(baseUrl)),
  httpClientFactory = KtorKoogHttpClient.Factory(),
)
```

## Tests Added or Updated

- `OpenRouterTextModelsTest.executorBuildsWithoutServiceLoaderDiscovery`: building the executor
  must not throw. Before the fix it failed with the device's exact error, `IllegalStateException: No
  KoogHttpClient.Factory provider found on the runtime classpath`. Android unit tests resolve the
  same AAR variant, so the bug can be reproduced on the JVM.

## Local Verification

- `./gradlew :app:testDebugUnitTest --tests '*OpenRouterTextModelsTest'` before the fix: the new
  test failed with the reported exception.
- `./gradlew :app:testDebugUnitTest :app:detekt :app:assembleDebug` after the fix: passed, 165
  tests, 0 failures.
- Manual checks: none. Device verification (quickstart scenario 3, a remote chat answers) is
  pending.

## Deviations from Assessment

None. The assessment's open question is resolved: the JVM unit-test runtime does reproduce the
missing provider, so the regression test locks the fix in.

## Follow-ups

- On a device, send a chat message through an OpenRouter model and confirm a real reply. Then use a
  bad key (expect the authorization message) and airplane mode (expect "No connection") to confirm
  the failure classification against live HTTP errors.
