# Bug Verification: OpenRouter save returns 404; drop base-URL normalization

- **Slug**: openrouter-url-404
- **Tested**: 2026-10-13
- **Assessment**: ./assessment.md
- **Fix**: ./fix.md
- **Result**: partial

## Summary

All unit and presenter tests added or updated in `fix.md` pass (`OpenRouterConfigTest` 6/6, `OpenRouterTextModelsTest` 3/3, `OpenRouterModelsClientTest` 5/5, `OpenRouterConfigRepositoryImplTest` 8/8, `ModelDownloadPresenterTest` 40/40), and `detekt` / `lintDebug` pass with 0 errors. Marked `partial` per guardrail because live network reproduction (saving `https://openrouter.ai/api/v1` or `https://routellm.abacus.ai/v1` with an API key on a device) is network-dependent and was skipped.

## Checks Performed

| Check | Command / Action | Result | Notes |
|-------|------------------|--------|-------|
| Reproduction (post-fix, live network save) | Save `https://openrouter.ai/api/v1` / `https://routellm.abacus.ai/v1` with API key in Settings | skipped | Network-dependent check requiring external API endpoint / credentials |
| New / updated tests | `./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.core.ai.OpenRouterTextModelsTest" --tests "com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfigTest" --tests "com.jayvijay.scottie.feature.modeldownload.data.remote.OpenRouterModelsClientTest" --tests "com.jayvijay.scottie.feature.modeldownload.data.repository.OpenRouterConfigRepositoryImplTest" --tests "com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadPresenterTest" --rerun-tasks` | pass | 62/62 tests passed across all 5 test classes (`baseUrlNeedsHttpSchemeAndHost` accepts `https://openrouter.ai/api/v1` and `https://routellm.abacus.ai/v1`, rejects `?q=1` and `#x`; `invalidBaseUrlReportsErrorWithoutSaving` passes) |
| Regression suite | `./gradlew :app:testDebugUnitTest` | pass | Full debug unit test suite passed |
| Lint / type-check | `./gradlew :app:detekt :app:lintDebug` | pass | Both `detekt` and Android `lintDebug` passed with 0 errors |

## Output Excerpts

```text
<testsuite name="com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfigTest" tests="6" skipped="0" failures="0" errors="0" time="0.004">
  <testcase name="baseUrlNeedsHttpSchemeAndHost" classname="com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfigTest" time="0.001"/>
  <testcase name="validationChecksOnlyBaseUrlAndKeepsSelection" classname="com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfigTest" time="0.0"/>
</testsuite>

<testsuite name="com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadPresenterTest" tests="40" skipped="0" failures="0" errors="0" time="0.215">
  <testcase name="invalidBaseUrlReportsErrorWithoutSaving" classname="com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadPresenterTest" time="0.017"/>
  <testcase name="saveKeepsSelectionAndFetches" classname="com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadPresenterTest" time="0.007"/>
</testsuite>

<testsuite name="com.jayvijay.scottie.core.ai.OpenRouterTextModelsTest" tests="3" skipped="0" failures="0" errors="0" time="0.126">
  <testcase name="executorBuildsWithoutServiceLoaderDiscovery" classname="com.jayvijay.scottie.core.ai.OpenRouterTextModelsTest" time="0.108"/>
</testsuite>
```

## Residual Risks

- Existing saved configs that stored a bare origin (`https://openrouter.ai`) without `/api/v1` will receive HTTP 404 on `/models` until re-saved with the versioned base URL (`https://openrouter.ai/api/v1` or `https://routellm.abacus.ai/v1`).
- Live network fetch and chat completion against OpenRouter / RouteLLM have not been exercised in automated offline checks.

## Recommendation

Hold for quick manual confirmation in Settings with a live OpenRouter or RouteLLM API key, or close if already confirmed during the 2026-10-10 device revision noted in `fix.md`.
