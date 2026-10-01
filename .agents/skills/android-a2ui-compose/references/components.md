# Custom components, catalogs, and functions

## Select the extension point

For a visual replacement of an existing basic component, implement its typed interface, such as `A2uiBasicCatalogV1.Text`, and pass it as the corresponding Material factory argument. This inherits standard properties, readiness, and dynamic resolution. Its exact text callback is:

```kotlin
@Composable
override fun A2uiComponentScope.TypedContent(
    text: String,
    variant: A2uiBasicCatalogV1.Text.Variant,
    accessibility: A2uiBasicCatalogV1.AccessibilityAttributes?,
    modifier: Modifier,
)
```

`A2uiBasicCatalogV1` is in `androidx.a2ui.compose.ui.catalog`; scope is in `androidx.a2ui.compose.runtime`. Preserve modifier and accessibility behavior in the replacement. This changes rendering without changing the standard wire contract.

For a new contract, implement `androidx.a2ui.compose.ui.A2uiComponent`:

```kotlin
val name: String
val description: String
val properties: List<A2uiProperty<*>>
@Composable fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean
@Composable fun A2uiComponentScope.Content(properties: A2uiComponentProperties, modifier: Modifier)
```

These functions are member extension overrides, not ordinary composables accepting an unrelated scope parameter. Default `isReady` is true. Keep property objects stable, e.g. fields on an object. The catalog builds property schema from those objects, including `isRequired`.

## Property APIs

All types below are in `androidx.a2ui.compose.runtime`.

| Declaration | Read within component scope | Purpose |
| --- | --- | --- |
| `A2uiProperty.string(key, required = false, description = null)` | `properties[token]` | Static string |
| `number`, `boolean`, `enum`, `custom` | `properties[token]` | Static values; choose the appropriate overload/schema |
| `dynamicString`, `dynamicNumber`, `dynamicBoolean`, `dynamicStringList`, `dynamicValue` | `properties.bind(token)` | Composable reactive evaluation, nullable result |
| `dynamicCustom(key, schema, safeCast, required = false)` | `properties.bind(token)` | Dynamic value with a custom cast and explicit schema |
| `componentId(key, required = false)` | `properties[token]` | A single referenced child |
| `childList(key, required = false)` | `properties.bindChildReferences(token)` | Static child IDs or a repeated template |
| `action(key, required = false)` | `properties[token]` | Action map; invoke `dispatchAction(map)` on interaction |
| `nested`, `nestedList` | `properties[token]`, then typed nested reads | Structured static containers with declared properties |

Most factory overloads also accept descriptions; consult the project's version for overload details outside these examples. `A2uiComponentProperties` has an internal constructor/raw map; app components should not construct it or read arbitrary keys. Static reads return nullable values, throw for missing required keys/type mismatches, and do not resolve paths. Define optional fallbacks explicitly; a schema default is not evidence that a getter synthesizes that value.

For required dynamic properties, readiness should check successful resolution. Content can render only when ready, with a defensive nullable fallback where useful. Do not retain the first resolved value with unkeyed `remember`; that disconnects future data updates.

`properties.bindUpdater(dynamicToken)` returns `((T?) -> Unit)?`. A callback exists only for a path binding and updates the resolved data path. Call `bind`/`bindUpdater` during composition; invoke the resulting callback from UI events. Literals/function results have no writable path. Use an explicit read-only/disabled presentation when appropriate.

[NoteEditor.kt](../assets/NoteEditor.kt) is a complete custom component with required label/value, optional action, readiness, writeback, and a uniquely identified inline catalog. Its matching [test](../assets/NoteEditorTest.kt) exercises the contract.

## Rendering children

For a child ID call `observeA2uiComponentState(id)` inside the supplied scope. For repeated children import extension `androidx.a2ui.compose.runtime.observeA2uiComponentState` and pass the whole `A2uiComponentReference`. It includes `id` and `baseDataPath`; both contribute to instance identity.

Handle `A2uiComponentState.Loading`, `Error(exception)`, and `Success(component)` explicitly. In success, call `androidx.a2ui.compose.ui.A2uiComponent(state.component, modifier)`. Key repeated items using both component ID and base data path, not component ID alone. `reportError(A2uiException)` feeds the error pipeline; report failures from callbacks/effects rather than unconditionally during composition.

## Catalog registration

```kotlin
import androidx.a2ui.compose.ui.A2uiCatalog

// base is an existing A2uiCatalog; NoteEditor comes from the asset.
fun addNotes(base: A2uiCatalog): A2uiCatalog = A2uiCatalog(
    catalogId = "https://example.com/a2ui/catalog/notes/v1",
    components = base.components.filterNot { it.name == NoteEditor.name } + NoteEditor,
    functions = base.functions,
    themeSchema = base.themeSchema,
    isInline = true,
)
```

Use an application-owned URI for a real app. Remove an old definition when replacing by name; duplicate names are rejected. Register the resulting catalog with the processor and communicate its ID/schema to the backend. A constructor parameter named `catalogId` produces a catalog property named `id`. See [protocol-and-api.md](protocol-and-api.md) for capability advertisement.

## Custom functions

Implement `androidx.a2ui.model.catalog.A2uiFunction` with:

- `definition: A2uiFunctionDefinition` containing `name`, `description`, `argumentSchema: A2uiSchema`, and `returnType: A2uiFunctionReturnType`.
- `execute(args: Map<String, Any>, executionContext: A2uiExecutionContext): Any?`.

Use schemas such as `A2uiObjectSchema(properties = ..., required = setOf(...))` from `androidx.a2ui.model.schema`. Return types are `STRING`, `NUMBER`, `BOOLEAN`, `ARRAY`, `OBJECT`, `ANY`, `VOID`. `acceptsUnresolvedArguments` defaults to false; enable it only when implementing evaluation of raw arguments intentionally.

The execution context provides `dataPath`, `evaluatePayload`, `executeFunction`, `getFunctionDefinition`, `resolveValue(A2uiDataPath)`, and `getOrCreateFunctionScopedCache(definition, factory)`. `execute` is synchronous, so avoid blocking network work. Value functions can re-evaluate as bindings change; use them for computation, and route user side effects through explicit actions. Add the function to the custom catalog's `functions` list so validation and evaluation share the same contract.
