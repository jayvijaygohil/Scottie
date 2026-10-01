---
name: jetbrains-koog
description: Build, explain, migrate, and debug Kotlin AI agents using JetBrains Koog. Use for Koog strategies, tools, prompt executors, structured output, memory, integrations, and tests, with local 1.3.0 and 1.3.0-beta documentation.
---

# JetBrains Koog

Implement Koog agents exclusively in Kotlin, including Gradle Kotlin DSL examples. Use the bundled references and documentation without installing a documentation service or changing global configuration.

## Establish the API context

Inspect Gradle configuration, version catalogs, source sets, and existing imports. Preserve the project's provider, model, and dependency versions unless the task calls for changing them.

The supplied guides target stable `1.3.0` and beta `1.3.0-beta`; their accompanying Dokka build identifies itself as `1.3.0-SNAPSHOT`. Keep those labels distinct. Read [version selection and migration](references/version-and-migration.md) for upgrades or dependency setup, and [API coverage](references/api-index.md) for exact contracts. Preserve `suspend`, receiver types, generics, defaults, and source-set labels. An incomplete Dokka signature is evidence of a documentation gap, not usable Kotlin.

## Implement

- For a new agent, dependency setup, tools, or graph routing, read [agent and tool guidance](references/agents-and-tools.md).
- For sessions, structured output, memory, persistence, or tests, read [state and testing guidance](references/state-and-testing.md).
- For code patterns with imports, read [implementation examples](references/examples.md). For any supplied Kotlin sample and its peer dependencies, use the [complete Kotlin example index](references/kotlin-examples.md).
- For provider construction, HTTP factories, retries, caching, or model fallback, read [providers and prompts](references/providers-and-prompts.md).
- For skill discovery, GOAP, protocol bridges, server integrations, or observability, read [integrations](references/integrations.md).
- For exact API contracts, follow the topical links in [the API index](references/api-index.md). Search qualified names within `references/api/` instead of loading the whole collection.
- For type tokens, JSON trees, and serializer configuration, read [serialization](references/serialization.md).
- For additional guide behavior and Kotlin snippets, use [documentation lookup](references/documentation.md). The read-only `scripts/lookup.py` helper reads retained APIs, guides, and Kotlin examples under `references/`. Its API lookup also covers the [additional modules](references/api/extended-index.md). The skill is self-contained; the temporary documentation drop is not required.

Choose basic agents for ordinary tool loops, functional strategies for procedural logic, graphs for explicit routing/checkpoints, and planners when planning is required. Keep the application's coroutine scope, resource ownership, and platform constraints intact.

If a guide and declaration disagree, prefer a complete declaration for the target platform and verify against the application's dependency sources. State remaining gaps; do not invent signatures or silently upgrade to match the snapshot. The bundled sources do not prove publication status or compatibility with an arbitrary installed version.

## Verify

Compile changed code with the target application's build. For behavior changes, use focused Koog mocks and assertions on routing, tools, outputs, or state restoration. Distinguish compilation, deterministic tests, and live-provider verification in the result.
