---
name: android-a2ui-compose
description: Integrate Google's AndroidX A2UI libraries into Android Jetpack Compose apps, explain their protocol and APIs, and implement or test custom components and catalogs. Use for androidx.a2ui and androidx.compose.material3.a2ui work; not for unrelated Compose UI or web A2UI renderers.
---

# Android A2UI with Jetpack Compose

This skill documents the supplied AndroidX **1.0.0-alpha01** snapshot. All guidance and examples are inside this folder; the original library checkout is not required. Library dependencies still come from the consuming Android project. Provenance and dependency versions are in [references/integration.md](references/integration.md).

## Choose the relevant guide

- **Integrate or troubleshoot an app:** read [references/integration.md](references/integration.md); adapt [assets/A2uiSession.kt](assets/A2uiSession.kt) for lifecycle, transport, and surface rendering.
- **Explain APIs or generate server payloads:** read [references/protocol-and-api.md](references/protocol-and-api.md). For standard component fields and factory setup, use [references/material-catalog.md](references/material-catalog.md). [assets/form.jsonl](assets/form.jsonl) is a complete standard-catalog message sequence.
- **Build or customize components/catalogs:** read [references/components.md](references/components.md); adapt [assets/NoteEditor.kt](assets/NoteEditor.kt) for reactive state, writeback, and actions.
- **Verify component behavior:** read [references/testing.md](references/testing.md); adapt [assets/NoteEditorTest.kt](assets/NoteEditorTest.kt).

Load only the guides needed for the task. API explanations can be answered directly without changing the app. For implementation, inspect the target app's dependencies and state ownership first, then fit these examples into its architecture.

## Snapshot constraints

1. Check the project's resolved A2UI version. These examples target alpha01; do not silently replace a newer or different version. Confirm changed signatures from that version's sources or official documentation before adapting.
2. Keep three version identifiers distinct: Maven `1.0.0-alpha01`, supported JSON envelopes `v0.9` / `v0.9.1`, and the basic catalog URI `https://a2ui.org/specification/v0_9_1/catalogs/basic/catalog.json`.
3. Construct catalogs and the processor with `androidx.a2ui.compose.ui` factories. Start `collectMessages()` in a lifecycle-owned coroutine; `processMessage()` only queues work. Wire outbound events to the app's transport separately.
4. Use component ID `root` for a surface's visual root. `A2uiSurface` renders a model from `activeSurfaces`, not a JSON string.
5. Required dynamic data and readiness are separate from structural schema validation. Read dynamic properties with `bind`; use `bindUpdater` for writable path bindings. A literal value does not provide writeback.
6. Use the standard catalog URI only for the standard contract. Give added/removed components, changed schemas, or changed functions an application catalog ID and advertise that contract to the server.

## Complete the requested work

For integration, verify dependency resolution, processing-loop ownership, a visible root, and the outbound event path. For custom components, verify readiness, data updates, user writeback, and action behavior where applicable. Use the target project's existing build and test setup. The bundled examples were reviewed against the supplied source; they are adaptation assets, not a compiled Android sample project. State which checks actually ran and any unresolved compatibility issues.
