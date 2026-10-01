# Integration and snapshot provenance

## Library selection

All coordinates below use version `1.0.0-alpha01` in the supplied POMs.

| Coordinate | Responsibility | When directly useful |
| --- | --- | --- |
| `androidx.a2ui:a2ui-model` | Protocol messages, schemas, functions, processor interfaces | Protocol adapters and custom functions |
| `androidx.a2ui:a2ui-engine` | Validation, evaluation, surface actors, platform abstractions | Building a renderer/runtime adapter |
| `androidx.a2ui.compose:compose-runtime` | Android JSON parser, snapshot-backed data and components, bindings | Custom reactive components |
| `androidx.a2ui.compose:compose-ui` | Compose catalog/processor factories and component rendering | Compose integration and catalog authoring |
| `androidx.compose.material3:material3-a2ui` | Material catalog implementations and `A2uiSurface` | Material app integration |
| `androidx.a2ui.compose:compose-ui-testing` | Test controller, surface, component stubs | Tests only |

With `google()` and `mavenCentral()` in the project's dependency repositories, a typical Material integration declares:

```kotlin
dependencies {
    implementation("androidx.compose.material3:material3-a2ui:1.0.0-alpha01")
    androidTestImplementation("androidx.a2ui.compose:compose-ui-testing:1.0.0-alpha01")
}
```

The Material artifact brings the model, engine, runtime, and UI layers transitively. Follow the app's convention for explicit dependencies on APIs used directly. A custom renderer can use `compose-ui` without the Material catalog.

The supplied Material POM references Compose animation/UI/foundation/runtime `1.13.0-alpha03`, Material3 **`[1.5.0-alpha28]`** (a strict Maven range), and Kotlin stdlib `2.2.20`. These describe this artifact; do not overwrite the app's entire toolchain with them. Check resolution conflicts, Compose BOM/constraints, and AAR/AGP SDK requirements. Do not assume an older stable Compose stack is compatible. The extracted Gradle files use AndroidX repository build plugins and are not standalone app builds. No complete consumer build, wrapper, or authoritative consumer SDK matrix is supplied here.

## Wiring an app

1. Create a catalog. Use the Material factory for the entire basic contract; see [material-catalog.md](material-catalog.md). For a limited/custom contract, use `A2uiCatalog(catalogId, components, functions, themeSchema, isInline)` with an app-owned ID.
2. Create the processor with `androidx.a2ui.compose.ui.A2uiMessageProcessor(catalogs, interceptors)` and the String parser with `androidx.a2ui.compose.runtime.A2uiMessageParser()`.
3. Keep those objects in a session/ViewModel scope. Start one `collectMessages()` job per processor on a background dispatcher and a separate collector for `outboundEvents`. Avoid recreating processors on recomposition or treating `collectMessages()` as a one-shot drain.
4. Frame transport into complete JSON objects, in order, then call `processor.processInput(parser, json)`. SSE framing, JSONL line splitting, networking, retries, and authentication belong to the app. Arbitrary byte chunks and arrays of envelopes are not single parser inputs.
5. Observe `processor.activeSurfaces` using the app's state collection convention. Pass each chosen model to `androidx.compose.material3.a2ui.A2uiSurface(surfaceModel = model)` inside the app's theme/layout. Use stable surface IDs for collections.
6. Serialize/send outbound messages using the backend's agreed envelope. The model classes are not annotated kotlinx-serialization DTOs and `toString()` is not JSON. No network client is automatically attached.

[A2uiSession.kt](../assets/A2uiSession.kt) accepts a real outbound sender and a lifecycle-owned coroutine scope. With a ViewModel, construct it once with `viewModelScope`; call `close()` if ending the session earlier. Transport failure/reconnection policy remains with the app.

`A2uiSurface` handles loading, error, and success. Customize `loadingContent: @Composable () -> Unit`, `errorContent: @Composable (A2uiException) -> Unit`, or `transitionSpec`; null disables animations. Data-only changes do not trigger structural transitions. This surface requires Compose-backed catalog/processor models; an arbitrary implementation of the minimal `A2uiSurfaceModel` interface is insufficient.

## Diagnosis

| Symptom | Check |
| --- | --- |
| No active surface | Processing loop; accepted create message; registered catalog ID; outbound errors |
| Surface remains loading | Component ID `root`; required dynamic paths; custom `isReady` |
| Parser validation error | Version, exactly one operation, flattened component properties, field types |
| Form control disabled | Value needs a path binding for `bindUpdater`; literals/functions are not writable |
| Action never reaches backend | UI dispatch, interceptor consumption, outbound collector, serializer; local calls do not produce server events |
| Updated component loses fields | Updates replace that component's property map; resend all needed properties |
| Surface/catalog cast failure | Use Compose UI factories and their emitted models |

## Provenance

Derived from the six local alpha01 packages: POM/module metadata, `source/api/current.txt`, implementation, tests, and samples. In `platform/frameworks/support`, the five `a2ui` packages record revision `cfb70ae8ae08b31bdb9fceb2c501806b9a72b70a`; Material3 A2UI records `4655a1cce41f181b9bbdb8f0a963f20b1f020101`. These are the individual revisions recorded in their `SOURCE_REVISION.txt` files, not a single shared checkout revision.

Recorded upstream roots: [a2ui](https://android.googlesource.com/platform/frameworks/support/+/cfb70ae8ae08b31bdb9fceb2c501806b9a72b70a/a2ui/) and [Material3 A2UI](https://android.googlesource.com/platform/frameworks/support/+/4655a1cce41f181b9bbdb8f0a963f20b1f020101/compose/material3/material3-a2ui/). These links provide provenance; using the skill does not require fetching them. Availability of these revisions and current Maven publication were not independently verified. The supplied integration-test app has an empty Activity, not an end-to-end sample.
