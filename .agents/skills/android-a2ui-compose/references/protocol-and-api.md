# Protocol and API behavior

## Data flow and entry points

`complete JSON → parser → queued processor → surface data/component state → Compose renderer`

`user input → bindUpdater or dispatchAction → local function / outbound event → app transport`

| API | Import/package | Contract |
| --- | --- | --- |
| `A2uiMessageParser()` | `androidx.a2ui.compose.runtime` | Returns `androidx.a2ui.model.processor.A2uiMessageParser<String>`; `parse(input)` returns a typed message |
| `A2uiMessageProcessor(catalogs, interceptors = emptyList())` | `androidx.a2ui.compose.ui` | Returns `androidx.a2ui.model.processor.A2uiMessageProcessor` |
| `processInput(parser, input)` | Extension in `androidx.a2ui.model.processor` | Parses/queues; converts `A2uiException` into a client error; unexpected runtime exceptions are not caught by this extension |
| `processMessage(message)` | Processor member | Thread-safe enqueue only |
| `collectMessages()` | Processor member | Suspending processing loop, tied to caller lifecycle |
| `activeSurfaces` | Processor member | `StateFlow<List<A2uiSurfaceModel>>`; model interface exposes `id` |
| `outboundEvents` | Processor member | `Flow<A2uiClientToServerMessage>` for events and errors |
| `processError(error)` | Processor member | Queues a client error |
| `A2uiComponent(component, modifier)` | `androidx.a2ui.compose.ui` | Renders a resolved `A2uiComponentModel`, e.g. inside custom containers |

## Incoming wire format

Each parser input is one object with `"version":"v0.9"` or `"version":"v0.9.1"` and one operation. `A2uiProtocolConstants.PROTOCOL_VERSION` is `v0.9`; the basic catalog URI separately contains `v0_9_1`.

| Operation | Fields | Kotlin model in `androidx.a2ui.model.protocol` |
| --- | --- | --- |
| `createSurface` | Required `surfaceId`, `catalogId`; optional `theme` and `sendDataModel` (false) | `A2uiCreateSurfaceMessage`; Kotlin Boolean is named `shouldSendDataModel` |
| `updateComponents` | `surfaceId`, `components` array; each entry has `id`, `component`, and flattened properties | `A2uiUpdateComponentsMessage` with `List<A2uiComponentPayload>` |
| `updateDataModel` | Required `surfaceId`; `path` defaults to `/`, `value` to null | `A2uiUpdateDataModelMessage` |
| `deleteSurface` | Required `surfaceId` | `A2uiDeleteSurfaceMessage` |

Create a surface before updating it. Component ID `root` is the renderer's entry point. There is no `beginRendering` operation in this parser.

```json
{"version":"v0.9","updateComponents":{"surfaceId":"s1","components":[{"id":"root","component":"Text","text":{"path":"/greeting"},"variant":"h2"}]}}
```

That entry corresponds to `A2uiComponentPayload(id = "root", type = "Text", properties = mapOf("text" to mapOf("path" to "/greeting"), "variant" to "h2"))`. Do not put a `properties` wrapper or `{"Text": {...}}` object on the wire.

Updates replace the properties for each included component ID; omitted IDs remain registered. Repeated valid IDs in a batch resolve to the last payload. Resend complete required fields for updated components.

Data update paths are absolute JSON Pointers; escape `~` as `~0` and `/` within a key as `~1`. `/` replaces the root with an object or clears it with null. A nested update writes that value; null removes a map key or stores null at an array position. Do not assume root updates deep-merge existing state.

## Bindings, templates, functions

- Dynamic values support literals, bindings (`{"path":"/user/name"}`), or registered calls (`{"call":"required","args":{"value":{"path":"/user/name"}},"returnType":"boolean"}`). Property schemas constrain forms and result types.
- Absolute binding paths start at the surface data root. Relative paths resolve against the component's base data path, particularly in repeated children.
- Children use `["title","submit"]` or `{"componentId":"rowTemplate","path":"/items"}`. A template produces one reference per array item. Preserve each reference's `baseDataPath` when observing/rendering it.
- A schema-required binding may exist while its data remains unresolved. `isReady` governs loading in that case.

## Actions and outbound models

Server action (a Button's `action`, or passed to `dispatchAction`):

```json
{"event":{"name":"submit","context":{"name":{"path":"/form/name"},"itemId":"fixed-id"}}}
```

Client function action:

```json
{"functionCall":{"call":"openUrl","args":{"url":"https://example.com"},"returnType":"void"}}
```

The schema accepts event `wantResponse`/`responsePath`, but the snapshot's action model/handler does not implement response routing from them. Do not promise automatic response writeback.

`A2uiClientEventMessage` has `type` (event name), `surfaceId`, `componentId`, `timestamp: Long`, resolved `context`, and optional `clientDataModel`. `sendDataModel: true` requests data-model attachment; choose deliberately what state the app transmits. `A2uiClientErrorMessage` has `code`, `surfaceId`, `message`, and `context`. For `VALIDATION_FAILED`, context must contain exactly `path: String`. Use an explicit backend serializer; `toString()` is not a wire format.

Processor-level `A2uiActionInterceptor` is suspending, runs in registration order, returns an action to continue or null to consume, and blocks that surface's action pipeline while running. Scope-level `ProvideActionInterceptor(onIntercept, content)` is synchronous: true consumes, false continues to its parent.

## Capabilities and schemas

`A2uiCatalog` exposes `id`, `components`, `functions`, `themeSchema`, and `isInline` (default false). Factories reject duplicate component/function names. Import `toJsonSchemaMap` or `toJsonSchemaString` from `androidx.a2ui.compose.ui` to export a custom contract.

`A2uiClientCapabilities(supportedCatalogIds, inlineCatalogs = emptyList()).toPayloadMap()` returns `{"a2uiClientCapabilities":{"v0.9":{"supportedCatalogIds":[...]}}}` plus optional inline schemas. The host sends it through its negotiation transport; `isInline` does not send anything by itself.

`inlineCatalogs` expects `A2uiInlineCatalog` objects, whereas the public `A2uiCatalog` type does not extend that interface. For an adapter, implement `val id: String = catalog.id`, `toJsonSchemaMap(): Map<String, Any?>`, and `toJsonSchemaString(): String`, delegating the methods to the catalog's corresponding extensions. Include the adapter when the catalog's `isInline` is true. This avoids depending on the factory's internal implementation type.

## Layer boundaries

`a2ui-model` defines protocol/schema contracts. `a2ui-engine` implements validation, evaluation, and orchestration via platform interfaces. `compose-runtime` adds snapshot observation, `compose-ui` composable implementations, and Material styling/surface rendering. Ordinary apps use the high-level factories; the minimal `A2uiSurfaceModel` is not a mutable UI store.
