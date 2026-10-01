# Agent and tool decisions

## Setup and version boundaries

The supplied Kotlin quickstart specifies JDK 17+, Kotlin 2.2.0+, and Gradle 8.0+. Inspect the project's dependency version and source sets before changing its toolchain.

The stable umbrella is `ai.koog:koog-agents:1.3.0`; optional beta functionality uses `ai.koog:koog-agents-additions:1.3.0-beta`. Standalone integrations can need their own artifacts. See [version selection](version-and-migration.md); do not infer artifact stability from the Dokka snapshot label.

Read [executors and clients](api/executors-and-clients.md) for provider setup and [prompts and messages](api/prompts-and-messages.md) for `LLModel`/`LLMCapability`. Match model and executor provider, preserve credentials in application configuration, and check support for tools, structured output, or streaming.

Provider constructors now accept `KoogHttpClient` or `KoogHttpClient.Factory`. Read [providers and prompts](providers-and-prompts.md) before adapting older Ktor-client constructor examples.

## Agent shape

| Need | API starting point | Bundled contract |
| --- | --- | --- |
| Standard LLM/tool loop | `AIAgent` default strategy | [Agent lifecycle](api/agent-lifecycle.md) |
| Custom sequential logic | `functionalStrategy<Input, Output>` | [Agent lifecycle](api/agent-lifecycle.md), [sessions](api/sessions.md) |
| Explicit routing and checkpoints | `strategy<Input, Output>` | [Graph DSL](api/graph-dsl.md), [persistence](api/persistence.md) |
| Autonomous planning | `AIAgentPlannerStrategy` | [Planners](api/planners.md) |

`AIAgent` is both a type and the name of Kotlin factory functions. Read the factory overloads, not just the abstract class declaration. The simple factories use `llmModel` and `maxIterations`; `AIAgentConfig` uses `model` and `maxAgentIterations`. Functional strategies in the supplied guide do not support state persistence. Use a graph for checkpointed workflows unless the target version establishes otherwise.

`singleRunStrategy(parallelTools = false)` executes tools sequentially by default in this build. Make parallel execution explicit when tools are safe to run concurrently. The concrete `goap(...)` DSL returns an `AIAgentPlannerStrategy`; see [planner guidance](integrations.md#planning) before wrapping a planner a second time.

## Graph tool loop

```text
nodeStart → nodeLLMRequest
  text → nodeFinish
  tool calls → nodeExecuteTools → nodeLLMSendToolResults
    text → nodeFinish
    tool calls → nodeExecuteTools
```

Both response nodes need text and tool-call routing. Executing a tool alone does not send its result back to the model. Match node input/output types and edge transformations. Read [parallel branches and storage](api/parallel-and-storage.md) for branch results, merging, and shared values. Keep typed storage distinct from LLM conversation history.

Assistant responses contain `MessagePart` values. Route or extract actual text/tool parts instead of assuming a universal `content: String` accessor. Graph routing and a complete tool example are in [implementation examples](examples.md).

## Tools

Read [tools and registries](api/tools.md) for exact constructors and callable contracts.

- JVM Kotlin: expose annotated methods from a `ToolSet` with `@Tool` and `@LLMDescription`. The registry builder supports `tools(instance: ToolSet)` on JVM; reflection is not a common-platform API. Callable references can use the `asTool` extension.
- Multiplatform Kotlin: use class-based tools with explicit argument/result type tokens. `Tool<Args, Result>` accepts typed values; `SimpleTool` returns text.
- Choose `Tool` for ordinary `execute(args)` implementations, `ToolBase` when raw `ToolCallMetadata` is needed, and `AgentContextAwareTool` for a typed live `AIAgentContext`. The context-aware form requires an agent context at invocation; isolated tests may pass it explicitly.
- For agent delegation, check `AIAgentTool` and `asTool` contracts. For file, search, shell, and user-interaction tools, consult [built-in tools](api/builtin-tools.md); give them only the filesystem provider and execution capabilities required by the task.

The agent must receive the registry containing the advertised tools. Match names, schemas, required arguments, and serialized results. Investigate registry construction before prompt changes when a tool cannot be found. Use [serialization](serialization.md) for `typeToken` and Kotlinx conventions. The custom-schema guide retains older “Schemer” wording: the declared interface is `ToolDescriptorSchemaGenerator` with `generate(ToolDescriptor): JsonObject`.

## Optional integrations

Load only what the task uses: [MCP](api/mcp.md), [Ktor](api/ktor.md), [Spring AI](api/spring.md), [retrieval](api/retrieval.md), or [events and tracing](api/events-and-tracing.md). Module labels identify the source API module; they do not by themselves prove dependency coordinates or inclusion in an umbrella artifact. Spring AI and Spring AI v2 contracts are labeled separately in the reference; do not mix them.
