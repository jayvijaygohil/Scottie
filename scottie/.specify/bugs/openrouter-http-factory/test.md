# Bug Verification: OpenRouter client finds no HTTP client factory on Android

- **Slug**: openrouter-http-factory
- **Tested**: 2026-10-10
- **Assessment**: ./assessment.md
- **Fix**: ./fix.md
- **Result**: partial

## Summary

On the JVM, the failure no longer happens: the regression test that reproduced the exact
`No KoogHttpClient.Factory provider found` error before the fix now passes. No regressions were
found in the unit suite, detekt, lint, or the debug build. The device reproduction from the
assessment (sending a chat message to a remote model) was not run, so the result is `partial`
rather than `verified`.

## Checks Performed

| Check | Command / Action | Result | Notes |
|-------|------------------|--------|-------|
| Reproduction, automated equivalent | `./gradlew :app:testDebugUnitTest --rerun-tasks --tests '*OpenRouterTextModelsTest'` | pass | `executorBuildsWithoutServiceLoaderDiscovery` builds and closes the executor on the same `-android` AAR variant that failed before the fix |
| Reproduction on device (assessment steps 1–3) | Save the OpenRouter config, pick the remote model, send a message | not-run | Needs the user's API key and a live, possibly billed, network call through the UI |
| New / updated tests | same as the first row | pass | 4/4 in `OpenRouterTextModelsTest` |
| Regression suite | `./gradlew :app:testDebugUnitTest` | pass | 165 tests, 0 failures, 0 errors |
| Lint / static analysis / build | `./gradlew :app:detekt :app:lintDebug :app:assembleDebug` | pass | `BUILD SUCCESSFUL` |

## Output Excerpts

```
OpenRouterTextModelsTest tests="4" failures="0" errors="0"
  executorBuildsWithoutServiceLoaderDiscovery, normalizeStripsApiPathAndSlashes,
  knownIdUsesKoogDefinition, unknownIdGetsToolCapableOpenRouterModel
Full suite: tests 165 failures 0 errors 0
BUILD SUCCESSFUL in 30s
```

Before the fix, as recorded in fix.md:
`IllegalStateException: No KoogHttpClient.Factory provider found on the runtime classpath.`

## Residual Risks

- The JVM test proves the client can be built. It does not prove that a live HTTP request
  succeeds on ART with the Ktor OkHttp engine (TLS, cleartext policy for `http://` hosts).
- The failure classification (401/403 → unauthorized, 400/404 → model unavailable, I/O → offline)
  has only been tested with synthetic exceptions, never with real OpenRouter responses.
- Release builds with R8 have not been exercised. The explicit constructor reference should keep
  the factory class reachable.

## Recommendation

Hold. The root cause is fixed and pinned by a regression test. Close the bug once a device run
shows a remote model answering a chat message. Ideally also try a bad key (expect the
authorization message) and airplane mode (expect "No connection"), per quickstart scenarios 3–5.
