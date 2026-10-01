# State, output, and verification

## Sessions and structured responses

Read [session contracts](api/sessions.md) for `AIAgentLLMContext`, read/write sessions, and functional context operations. Keep use within the session lambda. Write sessions mutate history and block other sessions, so keep their scope focused. Read-session APIs also expose request operations in this snapshot; do not equate a read session with a write-session history update.

The context lock is not reentrant for writers. Inside `writeSession`, do not call `readSession`, `writeSession`, `withPrompt`, or the suspending `copy` on the same context. Inside `readSession`, do not acquire a write session or call `withPrompt`. Use the active session directly. The suspending `copy` takes a consistent snapshot under a read lock; it is distinct from the older non-suspending overload. Do not read context fields that are no longer public; inspect them through a session.

The supplied guide states that write-session LLM requests append their responses to history automatically. Avoid adding a second copy. Distinguish user input, assistant text/tool parts, and tool results. A manual history rewrite must preserve the protocol's tool-call/result relationships.

Use [structured-output contracts](api/structured-output.md) for `StructuredRequest`, `StructuredRequestConfig`, `JsonStructure`, `StructureFixingParser`, and `StructuredResponse`. The session `requestLLMStructured` returns `Result<StructuredResponse<T>>`, not `T`. Handle the failure result before reading `.data`. Fixing-parser retries differ from one-shot parsing and can add LLM calls. Field descriptions use `@property:LLMDescription`; serialized data classes require their serialization setup.

Use [prompts and streaming](api/prompts-and-messages.md) for `MessagePart` and `StreamFrame` types. Not every frame is text. Complete/cancel stream collection under its owning lifecycle rather than leaking a session beyond its scope.

Use delta frames for incremental display and complete frames for final text, reasoning, or tool-call processing. Do not concatenate both forms of the same content, or execute a tool on a partial argument fragment. Preserve frame indices and tool-call IDs. `StreamFrame.End` carries finish and usage metadata. Guide references to `Message.Response` can be stale; use the declared `Message.Assistant` and actual conversion return types.

## Memory lifetimes

| Requirement | Mechanism | Contract |
| --- | --- | --- |
| Current conversation | Session prompt/history | [Sessions](api/sessions.md) |
| Chat across agent runs | `ChatMemory`, conversation/session ID, `ChatHistoryProvider` | [Chat memory](api/chat-memory.md) |
| Reduce prompt size | History compression strategy | [Sessions](api/sessions.md), [graph nodes](api/graph-dsl.md) |
| Longer-lived facts | Ingestion/retrieval storage and augmentation | [Long-term memory](api/long-term-memory.md) |
| Resume execution | `Persistence` checkpoints | [Persistence](api/persistence.md) |

The guide adds `ai.koog:agents-features-memory` for chat memory and uses `agent.run(input, sessionId)`. `ChatMemory` defaults to an in-memory provider; choose storage for the required lifetime and use separate IDs for separate conversations. Windowing/compression controls prompt size, not process durability.

Checkpoints retain history, last node/output, model/parameters, selected tools, and serializable agent storage. The supplied guide says non-serializable `AIAgentStorage` values are silently skipped. Investigate serialization when restored values disappear. An in-memory checkpoint provider does not survive a process restart. See [serialization](serialization.md) for configuring compatible serializers.

The updated `AgentCheckpointData` constructors distinguish `graphProperties` and `plannerProperties` and retain `agentIterations`. Use the correct form for the strategy and preserve the iteration count when restoring. File providers accept a checkpoint `Json` configuration. The default `NoPersistenceStorageProvider` stores nothing; installing the feature alone is insufficient for durability.

Spring AI chat history stores only plain text and drops tool calls/results, reasoning, attachments, and metadata. AgentCore history has a different supported-message contract. See [integrations](integrations.md); neither adapter should be treated as lossless execution persistence.

## Testing

The guide uses `testImplementation("ai.koog:agents-test:<matching-version>")` and Kotlin test. Read [testing APIs](api/testing.md) for `getMockExecutor`, `mockLLMAnswer`, `mockLLMToolCall`, `mockTool`, request conditions, and graph assertions. A minimal mock-driven invocation with imports is in [examples](examples.md).

Test the changed behavior:

- Tool loop: tool request followed by assistant answer; verify arguments, result handling, and termination.
- Branches: mock responses selecting the relevant edges; assert outputs/actions.
- Structured output: successful data and the application's failure path.
- Memory/checkpoints: conversation separation and values needed after restore, including custom serialized state.

Use existing test/coroutine conventions. A passing mock does not establish live provider compatibility or model quality. Close owned agents/executors using the target version's lifecycle API; Kotlin `close` can be suspending in this snapshot.
