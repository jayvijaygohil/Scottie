# Bug Assessment: OpenRouter client finds no HTTP client factory on Android

- **Slug**: openrouter-http-factory
- **Created**: 2026-10-10
- **Source**: pasted text (logcat)
- **Verdict**: valid
- **Severity**: high

## Report (verbatim or summarized)

> When using Openrouter API, I see this error in the log:

```
W  InteracAssistant  inference failed
com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceException: UNKNOWN
  at ...InteracAssistantAgent$extract$2.invokeSuspend(InteracAssistantAgent.kt:34)
Caused by: java.lang.IllegalStateException: No KoogHttpClient.Factory provider found on the runtime
classpath. Add a module that publishes a Factory provider (e.g. http-client-ktor) to the runtime
classpath, or pass a KoogHttpClient.Factory explicitly.
  at ai.koog.http.client.HttpClientFactoryResolver.resolveFactoryFromProviders(HttpClientFactoryResolver.kt:33)
  at ai.koog.http.client.HttpClientFactoryResolver.resolve(HttpClientFactoryResolver.kt:26)
  at ai.koog.prompt.executor.clients.openrouter.OpenRouterClientFactory.openRouterClient(OpenRouterLLMClient.jvmCommon.kt:28)
  at com.jayvijay.scottie.core.ai.OpenRouterTextModels.executor(OpenRouterTextModels.kt:34)
  at com.jayvijay.scottie.di.RoutingModelResolver.remoteExecutor(InteracModule.kt:128)
  at com.jayvijay.scottie.di.RoutingModelResolver.resolve(InteracModule.kt:118)
  at ...InteracAssistantAgent.run(InteracAssistantAgent.kt:39)
```

No URL was supplied, so the URL trust policy did not apply.

## Symptom

Every chat request sent to an OpenRouter model fails before any network call, and the chat shows
the generic "Something went wrong" reply. Expected: the request reaches the configured OpenRouter
server and the reply renders.

## Reproduction

1. On a device, open Model settings and save an OpenRouter configuration with at least one model
   id.
2. In the chat, select the remote model and send any message.
3. The reply card shows the generic failure, and logcat shows the `IllegalStateException` above.

It fails every time, whatever the key, URL, or network state: it happens while the client is being
built, before any request is sent.

## Suspected Code Paths

- `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt:34` (`executor()`): calls
  the top-level `OpenRouterLLMClient(apiKey, settings)` factory function. That function resolves
  its HTTP client through `HttpClientFactoryResolver.resolve()`, which uses `ServiceLoader`.
- `app/src/main/java/com/jayvijay/scottie/di/InteracModule.kt:118,128`
  (`RoutingModelResolver.resolve` / `remoteExecutor`): the only caller. It is correct as written and
  only surfaces the failure.
- Koog `ai.koog:http-client-ktor-android:1.3.0` (`http-client-ktor-release.aar`): its `classes.jar`
  contains `ai/koog/http/client/ktor/KtorKoogHttpClient$Factory.class` but has no
  `META-INF/services/ai.koog.http.client.KoogHttpClient$Factory` entry. On Android, `ServiceLoader`
  therefore finds zero providers. Verified by listing the AAR and its `classes.jar`.

## Root Cause Hypothesis

`HttpClientFactoryResolver` discovers the HTTP factory with
`ServiceLoader.load(KoogHttpClient.Factory::class.java)`. Koog's Android build of `http-client-ktor`
ships the factory class without the service registration file, so the lookup is empty and
`resolveFactoryFromProviders` throws. The module is on both the compile and runtime classpaths, so
the dependency is present; only discovery fails. The top-level `OpenRouterLLMClient(apiKey,
settings)` relies on that discovery, which is why our call breaks. Research note R1 in feature 008
verified that the module was on the classpath, but not that `ServiceLoader` discovery works on
Android. Confidence: **high**. The stack trace, the resolver source, and the AAR contents agree.

## Proposed Remediation

**Preferred**: in `OpenRouterTextModels.executor`, use `OpenRouterLLMClient`'s secondary
constructor, which takes an explicit factory: `OpenRouterLLMClient(apiKey = apiKey, settings =
OpenRouterClientSettings(baseUrl = normalize(baseUrl)), httpClientFactory =
KtorKoogHttpClient.Factory())`. This is what the error message suggests ("or pass a
KoogHttpClient.Factory explicitly"). `KtorKoogHttpClient` (`ai.koog.http.client.ktor`) is already
on `debugCompileClasspath`, so no catalog or build change is needed. `KtorKoogHttpClient.Factory()`
defaults to `HttpClient()`, which picks the Ktor engine already on the classpath (OkHttp). Add a
one-line comment saying why the factory is explicit (the Android AAR lacks the `ServiceLoader`
registration).

**Alternatives**:
- Add our own `META-INF/services/ai.koog.http.client.KoogHttpClient$Factory` resource that names
  `ai.koog.http.client.ktor.KtorKoogHttpClient$Factory`. This also fixes any future Koog client
  built through discovery, but the dependency on Koog's internal provider name is hidden in a
  resource file, and R8 could still strip the class unless it is kept.
- Pass `KtorKoogHttpClient.Factory(HttpClient(OkHttp))` to pin the engine. This is more explicit,
  but `HttpClient()` already finds the single engine.

**Files likely to change**:
- `app/src/main/java/com/jayvijay/scottie/core/ai/OpenRouterTextModels.kt`
- `app/src/test/java/com/jayvijay/scottie/core/ai/OpenRouterTextModelsTest.kt`

**Tests to add or update**:
- `OpenRouterTextModelsTest`: building `OpenRouterTextModels.executor("https://openrouter.ai",
  "k")` does not throw, then the executor is closed. Android unit tests resolve the `-android` AAR
  variant, whose `classes.jar` has no service file, so this test should fail before the fix.
  [NEEDS CLARIFICATION: confirm the test fails before the fix; if the unit-test classpath gets the
  JVM jar with a service file instead, the test cannot catch the regression and device verification
  is the only proof.]
- Device check: quickstart scenario 3 (remote chat answers) after the fix.

## Risks & Considerations

- Each executor rebuild creates a new Ktor `HttpClient`. `RoutingModelResolver` already caches the
  executor per `(baseUrl, apiKey)` and closes the replaced one, so clients do not leak.
- Release builds with R8: an explicit constructor reference keeps the factory class reachable,
  which is safer than relying on `ServiceLoader`.
- Classification is correct as it stands: an `IllegalStateException` maps to `UNKNOWN`. No change
  is needed there.
- Other Koog clients built by top-level factory functions would fail the same way on Android. The
  app has none today; LiteRT does not use HTTP.

## Open Questions

- [NEEDS CLARIFICATION: does the Android unit-test runtime reproduce the missing provider, so a JVM
  test can lock the fix in?]
