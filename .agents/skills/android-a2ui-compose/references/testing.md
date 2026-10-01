# Testing and verification

Use `androidx.a2ui.compose:compose-ui-testing:1.0.0-alpha01` in the target's test configuration with its Compose UI test setup. The supplied source examples use `androidx.compose.ui.test.v2.runComposeUiTest`, a suspending test body that lets the controller use the test scheduler. Do not substitute a synchronous test rule without adapting coroutine ownership.

## Controller lifecycle

`A2uiTestController(catalog, theme = emptyMap(), initialComponents = emptyList(), initialData = emptyMap(), componentStubs = emptyList())` returns an unstarted controller. Call suspending `start()` from `runComposeUiTest` to obtain its surface, then `setContent { A2uiTestSurface(surface) }`; wrap Material components in `MaterialTheme`. Accessing `controller.surface` before start throws.

`A2uiTestSurface` is in `androidx.a2ui.compose.ui.testing`. Its parameter is `surface`, whereas the production Material surface uses `surfaceModel`. Test callbacks are `onLoading: @Composable (Modifier) -> Unit` and `onError: @Composable (A2uiException, Modifier) -> Unit`.

| Controller API | Use |
| --- | --- |
| `updateData(path, value)` | Simulate server state change |
| `updateComponent(id, type, properties)` | Simulate component replacement |
| `updateComponent(id, properties)` | Reuse known type; still send full needed properties |
| `getRawData(path)` / imported `getData<T>(path)` | Assert state after input; typed helper checks type rather than coercing |
| `failComponent(id, exception)` | Exercise render error handling |
| `dispatchedActions` | All UI actions, including local calls |
| `outboundEvents` | Server event messages only |
| `outboundErrors` | Client error messages |
| `clearDispatchedActions`, `clearOutboundEvents`, `clearOutboundErrors` | Reset respective histories |

After mutations/actions, call suspending `controller.waitForIdle()` to settle data processing, then the Compose test's `waitForIdle()` when checking recomposition. They settle different layers. The controller has no public `close()`; its background work is owned by the test scope.

## Stubs

`A2uiComponentStub.withId(id, isReady = ..., content = ...)` or `.withType(type, ...)` can isolate children/media. Content is a composable scope-receiver lambda accepting `(properties, modifier)`. For a stub identified only by ID, the testing package provides helper `A2uiComponentPayload(id, properties = emptyMap())`; real typed components use `androidx.a2ui.model.protocol.A2uiComponentPayload(id, type, properties)`. Avoid importing both under the same unqualified name.

## Meaningful checks

[NoteEditorTest.kt](../assets/NoteEditorTest.kt) tests incoming state changes, UI writeback, and evaluated outbound action context. Adapt it with [NoteEditor.kt](../assets/NoteEditor.kt). Additional checks should match the work: delayed required data/loading, malformed schema errors, child-template scoping, literal values without writeback, or media failures.

For an app integration, also exercise the actual parser/transport path. Feed each line of [form.jsonl](../assets/form.jsonl) separately into `processInput`. Expect a `profile` surface rooted at `root`, an editable Name field, and a Submit action whose resolved context contains the current name. The last line changes the name to Grace. A real tap should emit a `submit` event through the app's outbound sender.

These assets were checked against the snapshot's public signatures and implementation; no standalone Android consumer build is bundled. Compile and run the target project's relevant tests before claiming device/runtime verification.
