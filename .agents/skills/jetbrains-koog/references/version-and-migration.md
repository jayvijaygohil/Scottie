# Version selection and migration

The retained source set is [guides](documentation.md), [Kotlin examples](kotlin-examples.md), and [API contracts](api-index.md). Guides name `1.3.0` and `1.3.0-beta`; every scanned Dokka module reports `1.3.0-SNAPSHOT`. Use the guides for dependency families and complete Dokka declarations for callable contracts, then compile against the selected dependency. The snapshot label does not establish that a declaration shipped unchanged in a release.

## Dependencies

For a project adopting this version family, the supplied `module-versioning.md` and `snippets/quickstart-snippets.md` give:

```kotlin
dependencies {
    implementation("ai.koog:koog-agents:1.3.0")
    // Add when the feature requires beta modules:
    implementation("ai.koog:koog-agents-additions:1.3.0-beta")
    testImplementation("ai.koog:agents-test:1.3.0")
}
```

The versioning guide explicitly supports pairing stable `X.Y.Z` with beta `X.Y.Z-beta`. Most beta modules are included by the additions umbrella; standalone external integrations can require explicit dependencies. Avoid applying a single unsuffixed version variable to every artifact.

| Family used by this skill | Guide version |
| --- | --- |
| Core, tools, tests, chat memory, snapshots, tracing, OpenTelemetry | `1.3.0` |
| HTTP core/Ktor/OkHttp, serialization, prompt model/structure/cache files, embeddings, `rag-base` | `1.3.0` |
| OpenAI, Anthropic, Bedrock, Ollama, OpenRouter clients | `1.3.0` |
| Google, DeepSeek, DashScope, MistralAI, LiteRT, `prompt-executor-llms-all` | `1.3.0-beta` |
| `agents-ext`, `agents-planner`, long-term memory, `rag-vector`, Redis cache | `1.3.0-beta` |
| MCP, A2A, ACP, Ktor integration, Spring Boot and Spring AI adapter starters, AWS memory integrations | `1.3.0-beta` |

The supplied module table does not list every Dokka module. In particular, `skills`, `agents-cli`, `koog-bedrock-agentcore-runtime`, and Spring AI v2 module versions are not established by that table. AgentCore's guide marks its feature beta but uses `$koogVersion` in the dependency snippet. Verify omitted artifact coordinates/version from the target project's dependency metadata before adding them; do not assume the snapshot suffix is publishable. The grouping artifact `koog-spring-ai` is listed stable while its adapter starters are beta.

For the complete table through the Kotlin reader:

```sh
python3 scripts/lookup.py guide module-versioning.md --section 'Module Versions'
```

## Review existing implementations

These are differences from the previous skill's bundled snapshot, not a claim that every item was introduced in a published 1.3.0 release.

| Area | Current contract or migration check |
| --- | --- |
| Provider construction | Accepts `KoogHttpClient` or `KoogHttpClient.Factory`; pass a factory explicitly in common code. Convenience factory discovery needs exactly one runtime backend. |
| Basic strategy | `singleRunStrategy(parallelTools: Boolean = false)`. Review assumptions about concurrent tools. |
| LLM context | Mutable context fields are accessed through sessions. Suspending `copy(..., toolRegistry, ...)` locks for a consistent snapshot; nested writer access can deadlock. |
| Prompt | Constructor is `Prompt(messages, id, params)`; older `Prompt.latestTokenUsage` and `Prompt.totalTimeSpent` pages are absent. Use available response metadata or session metrics, not invented replacements. |
| Model | `LLModel.capabilities`, `contextLength`, and `maxOutputTokens` are nullable with `null` defaults. Do not treat unknown capability metadata as proof of support. |
| Message metadata | Message IDs, request/response custom metadata, and provider cache controls appear in constructors/DSL overloads. Preserve them through application transformations. |
| Checkpoints | Separate graph/planner properties, `agentIterations`, and configurable file-provider checkpoint `Json`. |
| Executors | Use actual `ResolvedModel`, `PromptExecutorOperation`, and fallback overloads when implementing custom executors; don't infer them from older examples. |
| Tools | Declared schema API is `ToolDescriptorSchemaGenerator`; provider implementations use `...SchemaGenerator`, despite older guide headings. |
| Serialization | The JSON/type-token contracts and Kotlinx implementation are now bundled in [serialization APIs](api/serialization.md). |
| Planning | Concrete GOAP/LLM planner declarations are now bundled; `ai.koog.agents.planner.goap(...)` already returns a strategy. |

Load the corresponding topic from [the API index](api-index.md), including each overload's platform and unresolved-type notice. Keep older working project versions unless the user's task calls for an upgrade.

## Known source disagreements

- The GOAP guide introduction links older planner package names and suggests wrapping a planner. Its Kotlin example and current declarations use `ai.koog.agents.planner.goap` returning the strategy directly. Core planner types live in `ai.koog.agents.core.planner`.
- The AgentCore memory guide calls `run(..., conversationId = ...)`; bundled `AIAgent.run` names the parameter `sessionId`. Use the declared name for this build and verify the AWS adapter against the installed dependency.
- The retry guide says streaming retries are optional, but its shown `RetryConfig` constructor has no enable-streaming flag. Do not invent one. Check the actual client implementation for retry behavior; the guide limits retries to failures before the first token.
- Some protocol and streaming examples still use `Message.Response` or old content helpers. Consult the message/streaming contracts rather than copying those names into current code.
- Dokka contains unresolved `ERROR CLASS` types, especially in platform wrappers. Preserve those as explicitly incomplete text, use a complete applicable overload when available, and report remaining gaps.
