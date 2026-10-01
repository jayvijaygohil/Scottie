# Planning, skills, and integrations

Source guides named below are available through [documentation lookup](documentation.md). Add only the integration needed by the application; [version selection](version-and-migration.md) distinguishes stable and beta artifacts.

## Planning

Read [planner APIs](api/planners.md) and `agents/planner-agents/` guides. `SimpleLLMPlanner` makes an initial plan; `SimpleLLMWithCriticPlanner` uses an LLM to assess it. Custom replanning extends the relevant planner's assessment behavior.

For GOAP, import `ai.koog.agents.planner.goap` and subclass `ai.koog.agents.planner.goap.GoapAgentState<Input, Output>`. The state supplies `agentInput` and `provideOutput()`. `goap(name, initializeState) { action(...); goal(...) }` returns `AIAgentPlannerStrategy<Input, Output>` directly for `AIAgent(strategy = ...)`. Keep action preconditions, predicted `belief`, actual execution, and cost functions separate. Beliefs model expected outcomes; execution returns the actual state. The planner package is beta.

## Koog skills

Read [skill APIs](api/skills.md) and `skills.md`. `discoverSkills(fs, directoriesToSearch, ...)` performs bounded breadth-first discovery of `SKILL.md`, validates required name/description metadata, and returns descriptors. Defaults include depth 4, 2,000 directories, and `SkillCollisionPrecedence.LAST_FOUND`. Configure precedence and limits deliberately when merging roots; malformed definitions are skipped with warnings.

`generateSkillsPrompt(skills, SkillsPromptFormat.XML)` generates prompt text, with optional metadata inclusion. Add it to the system prompt and register the file-reading or execution tools the workflow needs. Discovery and prompt generation do not execute scripts or grant capabilities. Read-only discovery can use `JVMFileSystemProvider.ReadOnly`; [built-in tool contracts](api/builtin-tools.md) cover list/read/write/edit/search/shell operations. Keep execution tools scoped to the application's authorized resources. The supplied version table omits the `skills` artifact, so verify its dependency before adding it.

## MCP, ACP, and A2A

| Integration | Purpose | Evidence |
| --- | --- | --- |
| MCP | Connect an MCP client, discover tools, build a Koog registry, then pass it to the agent | [MCP APIs](api/mcp.md), `model-context-protocol.md` |
| ACP | Bridge an agent to a client/IDE session and emit lifecycle/tool/response updates | `agent-client-protocol.md`; module API absent |
| A2A | Expose an agent server or connect to remote agents with agent-card and task/event handling | `a2a/` guides; module APIs absent |

For MCP, use `McpToolRegistryProvider` and the relevant transport/client overload. Retain transport, server, and request metadata when enabling tracing. Close the owned client/transport and any process launched by the application.

ACP is JVM-specific in the supplied guide and requires `agents-features-acp:1.3.0-beta`. Install `AcpAgent` with session ID, protocol, and event producer within the ACP session lifecycle. `AgentSupport` manages session creation/loading; `AgentSession.prompt` owns execution/cancellation. Default notifications already send tool states, responses, and completion/failure events; turning them off makes the application responsible for those events. Do not duplicate them in custom handlers.

A2A separates core client/server, Koog feature, and transport modules, all beta in the version table. Server setup associates agent cards, request contexts, and event processors; client setup resolves cards and checks streaming capability before choosing streaming/non-streaming requests. Because the API pages are missing and some examples contain stale message accessors, verify protocol code against the installed dependency. Do not reconstruct exact signatures from prose alone.

## Ktor and AgentCore

Use [Ktor contracts](api/ktor.md) and `ktor-plugin.md` for application plugin configuration, injected executors, and routing helpers.

Read [AgentCore Runtime APIs](api/agentcore.md) and `amazon-bedrock-agentcore.md` when serving AgentCore. `agentCoreRuntime` installs `POST /invocations` and `GET /ping` relative to its route. Typed `handle<I, O>` needs the application's content-negotiation converter; the unified handler supports text, binary, multipart, and streaming input/output. Streaming output is written directly and does not require Ktor's SSE plugin. The application owns the engine, port, rate limits, and lifecycle.

`maxRequestBytes` pre-checks declared `Content-Length`; absent lengths are not covered by that check. `handlerTimeoutMillis <= 0` disables its timeout. Use `AgentCoreTaskTracker` for background work so health can report `HealthyBusy` appropriately.

The AgentCore guide also describes AWS chat-history and long-term-memory modules whose Dokka declarations are absent. History uses `actorId:sessionId` IDs (or a default session) and persists plain text user/assistant messages; unsupported content is skipped by default or rejected with `ignoreUnsupportedValues = false`. Retrieval supports semantic, preference, summary, episodic, and reflection strategies with namespace scopes. Long-term records appear asynchronously after history writes. Verify adapter constructors and `run` argument names against dependency sources before implementing.

## Spring and retrieval

Read [Spring contracts](api/spring.md), `spring-boot.md`, and `spring-ai-integration.md`.

- `koog-spring-boot-starter` configures Koog model clients through `ai.koog.*` properties.
- Spring AI adapter starters reuse `ChatModel`, `EmbeddingModel`, `ChatMemoryRepository`, or `VectorStore` beans through `koog.spring.ai.*` properties. Select a bean by name when more than one candidate exists. Koog still executes tools.
- `AUTO` dispatching uses a Spring executor if available, otherwise `Dispatchers.IO`; `IO` supports configured parallelism. Keep this distinct from agent coroutine ownership.
- Spring AI chat history stores only plain-text system/user/assistant messages and drops tools, reasoning, attachments, and metadata. It is unsuitable for lossless checkpoints.
- The vector adapter offers similarity search; updates are delete-then-add and not transactional. There is no portable lookup-by-ID or namespace support. Deletion return values do not prove which records existed or were removed.

The source includes both Spring AI and Spring AI v2 modules with identical qualified names. Use the module label/source path matching the application's Spring version; do not combine their declarations.

Read [retrieval](api/retrieval.md) and `retrieval-augmented-generation.md` for `rag-base` interfaces and beta `rag-vector` implementations. `EmbeddingStorage` composes a document embedder with a vector backend. Local backends support similarity search and lack a built-in chunking pipeline or production database adapters. Use custom storage or the relevant Spring adapter when the task requires those features. Long-term memory has separate [ingestion/retrieval APIs](api/long-term-memory.md).

## Events and telemetry

Read [events/tracing APIs](api/events-and-tracing.md), `features/custom-features.md`, and `features/open-telemetry/` guides. Use typed lifecycle contexts and event handlers for the event of interest; custom features install interceptors through the applicable feature interface.

OpenTelemetry includes spans, metrics, message-content controls, provider/error attributes, tool-name cardinality controls, MCP metadata, and Datadog/Langfuse/Weave exporters. Match recording content and export destinations to the application's configuration. The supplied guide notes that multiple span adapters can override one another; do not assume configuring several vendor adapters composes correctly. Use the exporter lifecycle to flush/close owned telemetry resources.
