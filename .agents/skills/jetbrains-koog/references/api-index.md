# Bundled API references

Use these Kotlin contracts with the [version and migration guidance](version-and-migration.md). The guides target `1.3.0` / `1.3.0-beta`; the supplied Dokka modules display `1.3.0-SNAPSHOT`. Do not relabel snapshot declarations as verified released binaries.

## Find a contract

Select a topic and search its exact qualified symbol heading. Read each applicable overload, including its platform label, documentation, and Dokka ID. Repeated names can represent constructors, factories, overload pages, or different module variants.

```sh
rg -n '^## .*ToolRegistryBuilder' references/api/tools.md
rg -n '^## .*requestLLMStructured$' references/api/sessions.md
rg -n '^## .*discoverSkills$' references/api/skills.md
```

For a symbol outside these curated files, use the local reader from the skill directory:

```sh
python3 scripts/lookup.py api 'clients/google/-google-l-l-m-client' --limit 4
```

See [documentation lookup](documentation.md) for guide routing, exact-path lookups, and helper limitations. Read only the relevant sections.

| Topic | Kotlin symbol pages |
| --- | ---: |
| [Retrieval and embeddings](api/retrieval.md) | 83 |
| [Spring Boot and Spring AI integrations](api/spring.md) | 263 |
| [Agent construction and lifecycle](api/agent-lifecycle.md) | 151 |
| [MCP tools and metadata](api/mcp.md) | 45 |
| [Graph strategies, nodes, and subgraphs](api/graph-dsl.md) | 91 |
| [Prompts, messages, caching controls, and streaming](api/prompts-and-messages.md) | 409 |
| [Planner strategies, GOAP, and LLM planning](api/planners.md) | 113 |
| [Ktor integration](api/ktor.md) | 99 |
| [Mock executors and graph assertions](api/testing.md) | 180 |
| [Checkpoints, restore, and rollback](api/persistence.md) | 71 |
| [Structured requests and schema generation](api/structured-output.md) | 60 |
| [Chat history and preprocessing](api/chat-memory.md) | 30 |
| [Prompt executors and provider clients](api/executors-and-clients.md) | 256 |
| [LLM sessions and functional context](api/sessions.md) | 168 |
| [Feature events, tracing, and telemetry](api/events-and-tracing.md) | 488 |
| [Parallel branches and agent storage](api/parallel-and-storage.md) | 61 |
| [Long-term memory ingestion and retrieval](api/long-term-memory.md) | 136 |
| [Tools, descriptors, and registries](api/tools.md) | 134 |
| [Built-in interaction, file, search, and shell tools](api/builtin-tools.md) | 122 |
| [Token counting and tokenization](api/tokenization.md) | 37 |
| [HTTP contracts and Ktor backend](api/http-clients.md) | 43 |
| [Bedrock AgentCore Runtime](api/agentcore.md) | 84 |
| [Executor response caches](api/caching.md) | 52 |
| [Client retries and backoff](api/retries.md) | 61 |
| [Response processing and tool-call repair](api/response-processing.md) | 31 |
| [Serialization and Kotlin type tokens](api/serialization.md) | 93 |
| [Skill discovery and prompt generation](api/skills.md) | 18 |

## Coverage and provenance

The update scanned all 8,016 HTML pages under the supplied Dokka root and all 92 Markdown pages under its general guide root, including snippet sources and worked examples. The 27 topical files retain 3,379 application-facing symbol pages; [44 additional module files](api/extended-index.md) retain the rest, for 7,529 Kotlin symbol pages in total. The local reader searches these retained Markdown files. Content is attributed to JetBrains/Koog and was extracted on 2026-09-26. Each symbol retains its original Dokka ID as plain provenance metadata; no HTML files are required. All 92 guides and [340 Kotlin source examples](kotlin-examples.md) are also retained independently.

Covered areas include agent factories/lifecycle, graph and functional strategies, sessions, typed/reflection tools, built-in tools, prompt/message/streaming types, executors and provider settings, HTTP contracts, retries, response caching, tool-call repair, serialization, structured output, tokenization, memory, checkpoints, tests, GOAP/LLM planning, skill discovery, MCP metadata, Ktor, AgentCore Runtime, Spring Boot/Spring AI, retrieval, and observability. Additional module files retain the Kotlin contracts outside the topical subset, including model catalogs, provider DTOs, CLI details, and generated members; use local lookup as needed.

All retained guidance, examples, and extracted contracts target Kotlin. Interop-only wrappers and non-Kotlin language sections were excluded during extraction. The original documentation drop can be removed without affecting this skill. JVM and Android source sets remain relevant to Kotlin; they must not be treated as common-platform APIs.

## Source gaps and disagreements

| Area | Available evidence |
| --- | --- |
| Serialization, concrete GOAP/LLM planners | API modules now present; earlier coverage gaps are closed. |
| A2A and ACP | Guides and Kotlin examples present; corresponding Dokka modules absent. |
| AWS chat history and long-term memory | AgentCore guide present; adapter API modules absent. Runtime API is present separately. |
| JDBC/SQL memory and persistence | Artifact names appear in versioning guidance; dedicated module APIs absent. |
| HTTP backends | Core and Ktor APIs present. Other backend descriptions do not establish their exact constructors. |
| Spring AI variants | Both original and v2 modules present with overlapping qualified names. Select by module/source path. |
| Skills and some standalone modules | API pages present, but version table omits their artifact version. Verify target dependency metadata. |

Dokka fails to resolve some platform types. These declarations are retained in `text` fences with **Incomplete source signature** notices. Do not repair unresolved types, nullability, or generics by guessing. Complete common declarations and incomplete platform wrappers may coexist. Preserve the separation between `expect`, `actual`, and source sets.

The [migration reference](version-and-migration.md#known-source-disagreements) identifies concrete guide/API inconsistencies. Dokka IDs and extraction checks establish provenance, not compilation or runtime compatibility. Verify implementation changes with the target application's build and focused tests.

The example bundle also retains [12 Kotlin fragments](kotlin-fragments.md) originally stored as `.txt` files.
