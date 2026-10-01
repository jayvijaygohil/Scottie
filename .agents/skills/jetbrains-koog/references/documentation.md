# Local documentation lookup

The skill retains its Kotlin API declarations, all 92 guides, and all 340 Kotlin source examples under `references/`. It does not read or require the temporary documentation drop. Original Dokka IDs are search/provenance labels, not filesystem dependencies.

Also retained: [12 additional Kotlin fragments](kotlin-fragments.md) supplied as `.txt` files, including Spring services and Gradle Kotlin DSL.

Commands below run from the skill directory. The helper uses Python's standard library, reads only retained references, and installs or writes nothing.

```sh
# List guides or read a section.
python3 scripts/lookup.py guide
python3 scripts/lookup.py guide prompts/http-clients.md
python3 scripts/lookup.py guide features/chat-memory/index.md --section 'Session IDs'

# Search embedded contracts, including additional modules and provider catalogs.
python3 scripts/lookup.py api discoverSkills
python3 scripts/lookup.py api LiteRTLLMClient
python3 scripts/lookup.py api SpringAiLLMClient --module koog-spring-ai-v2 --limit 4

# Find complete Kotlin source and its peer-example dependencies.
python3 scripts/lookup.py example structured-data
python3 scripts/lookup.py example example-structured-data-07.kt
```

API output preserves versions, source sets, overloads, parameter/return prose, and incomplete-signature notices. Exact qualified names or original Dokka IDs select a declaration page; `--module` disambiguates overlapping module variants. Search defaults to eight pages; narrow the query or raise `--limit` as needed.

Guides link to retained snippet sections and complete Kotlin examples; no MkDocs includes or original source tree are needed. Full examples include their imports, packages, and setup scaffolding. Use the [example index](kotlin-examples.md) and [manifest](example-manifest.json) to find peer files, adaptations, and known documentation gaps. The source examples are reference material and may contain application placeholders or source-version mismatches; they are not presented as a compiled application.

For regression checks after moving the skill or deleting the temporary documentation drop:

```sh
python3 scripts/validate_bundle.py
```

The validator checks local resources, example coverage/digests and peer imports, index counts, prohibited language content, and lookup behavior. It does not compile Kotlin or contact providers.

## Guide routing

Paths in this table are relative to `references/guides/` and are arguments to `lookup.py guide`.

| Task | Relevant guide paths |
| --- | --- |
| Version/dependency setup | `module-versioning.md`, `quickstart.md`, `snippets/quickstart-snippets.md` |
| Select agent shape | `agents/index.md`, `agents/basic-agents.md`, `agents/graph-based-agents.md`, `agents/functional-agents.md` |
| Planning | `agents/planner-agents/index.md`, `agents/planner-agents/llm-based-planners.md`, `agents/planner-agents/goap-agents.md` |
| Graph routing/subtasks | `nodes-and-components.md`, `predefined-agent-strategies.md`, `custom-strategy-graphs.md`, `custom-nodes.md`, `custom-subgraphs.md`, `subgraphs-overview.md` |
| Parallelism/shared data | `parallel-node-execution.md`, `data-transfer-between-nodes.md` |
| Tool creation and schemas | `tools/index.md`, `tools/annotation-based-tools.md`, `tools/class-based-tools.md`, `tools/tool-descriptor-schemer.md`, `tools/built-in-tools.md` |
| Provider/transport/fallback | `llm-providers.md`, `prompts/http-clients.md`, `prompts/llm-clients.md`, `prompts/prompt-executors.md`, `prompts/handling-failures.md` |
| Prompt/media/parameters | `prompts/prompt-creation/index.md`, `prompts/prompt-creation/multimodal-content.md`, `llm-parameters.md`, `model-capabilities.md`, `content-moderation.md` |
| Caching | `prompts/llm-response-caching.md`, `prompts/prompt-creation/cache-control.md` |
| Structured/streamed output | `structured-output.md`, `streaming-api.md` |
| Sessions and memory | `sessions.md`, `history-compression.md`, `features/chat-memory/index.md`, `features/long-term-memory.md` |
| Chat applications | `features/chat-memory/chat-agent-with-memory.md`, `features/chat-memory/chat-backend-with-memory.md` |
| Persistence and serialization | `features/agent-persistence.md`, `serialization.md` |
| Skills | `skills.md` |
| Protocols | `model-context-protocol.md`, `agent-client-protocol.md`, `a2a/index.md`, `a2a/a2a-client.md`, `a2a/a2a-server.md`, `a2a/a2a-koog-integration.md` |
| Server/integration adapters | `ktor-plugin.md`, `spring-boot.md`, `spring-ai-integration.md`, `amazon-bedrock-agentcore.md` |
| RAG and embeddings | `embeddings.md`, `retrieval-augmented-generation.md` |
| Features and events | `features/index.md`, `features/custom-features.md`, `features/agent-event-handlers.md`, `agent-events.md` |
| Observability | `features/tracing.md`, `features/open-telemetry/index.md`, exporter guides in `features/open-telemetry/` |
| Testing | `testing.md` |
| Worked applications | `examples.md`, topic-specific files in `examples/` |

## Maintaining the bundle

When updating from a new local documentation drop, scan both guide navigation and Dokka modules; compare signatures, defaults, source sets, and return types, not just version labels. Refresh the affected curated contracts, examples, coverage gaps, and behavior guidance together. Preserve source provenance. The lookup helper can expose contracts omitted from the curated subset, including provider models/parameters and CLI APIs. Do not interpret omission from that subset as absence from Koog.
