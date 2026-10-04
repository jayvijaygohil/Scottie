# Research: Mock Interac Banking Tools

Verified against the Koog 1.3.0 Android source jars (`agents-tools`, `agents-core`,
`serialization-core`) in the Gradle cache and against `:app:dependencies --configuration
debugRuntimeClasspath`, which resolves `koog-agents:1.3.0`, `agents-tools:1.3.0`,
`agents-core:1.3.0`, `serialization-core:1.3.0`, `kotlin-reflect` 2.4.20, and
`koog-agents-additions:1.3.0-beta` (unused here). Tests resolve `agents-test:1.3.0`.

## R1. ToolSet package and runtime support

- **Decision**: Implement `ai.koog.agents.core.tools.reflect.ToolSet`. The input named
  `ai.koog.agents.core.tools.ToolSet`, which does not exist. Annotate methods with
  `ai.koog.agents.core.tools.annotations.Tool` and `LLMDescription`.
- **Rationale**: `ToolSet` is in `agents-tools` `jvmCommonMain`, which is included in the Android
  artifact. `kotlin-reflect` 2.4.20 is already on `debugRuntimeClasspath` through `agents-tools`.
- **1.3.0 surface**: `ToolSet` is a marker interface with member `asTools(): List<ToolFromCallable<*>>`,
  `getTool(name)` (throws `IllegalStateException` when absent), and a `name` property taken from the
  class-level `@LLMDescription`. `asTools()` requires at least one `@Tool` method. Tool names come
  from `@Tool(customName)` or else the Kotlin method name. A future agent registers the set with
  `ToolRegistry { tools(instance) }`.
- **Alternatives**: Class-based `Tool<Args, Result>`, one class per tool. That means four classes
  plus argument types for the same behavior; rejected.

## R2. Error reporting

- **Decision**: Throw `IllegalArgumentException` with `require(...)`, as the spec asks.
- **Rationale**: `ToolFromCallable.execute` unwraps `InvocationTargetException`. Then
  `GenericAgentEnvironment` catches any `Exception` and returns a `Failure` result whose output is
  `"Tool with name '<name>' failed to execute due to the error: <message>!"`. The LLM receives the
  reason (FR-013), and direct callers and tests get a plain exception.
- **Alternatives**: Koog's `fail()`/`validate()` (`ToolException.ValidationFailure`) gives a
  cleaner `ValidationError` output, but the spec explicitly requires `IllegalArgumentException`.
  Switch if the prefixed message confuses the model.

## R3. Optional arguments

- **Decision**: Use Kotlin default values (`= null`) for `query`, `securityQuestion`,
  `securityAnswer`, and `memo`.
- **Rationale**: `ToolFromCallable.decodeArgs` puts only the keys present in the JSON, and
  `callSuspendBy` fills missing parameters from their defaults. An explicit JSON `null` decodes to
  `null`, which the nullable types accept. One `asTools()` test proves the omitted-key path.
- **1.3.0 caveat**: `getToolDescriptor` puts every parameter in `requiredParameters` ("All
  parameters for function calling are considered required"); `optionalParameters` is always empty
  for reflective tools. Nullable parameters are typed as a union with `null`. The model is therefore
  told to send these four keys, using `null` when unused. The defaults remain a safety net for
  omitted keys, and the parameter descriptions must say "pass null when ..." (see contract).

## R4. In-memory balances and concurrency

- **Decision**: Keep a `MutableMap<String, Double>` seeded from the mock accounts in a `@Singleton`
  instance. `executeSendTransfer` is `@Synchronized`, so the balance check and debit are atomic.
  The debit is computed with `BigDecimal` and converted back to `Double`.
- **Rationale**:
  - The process-lifetime singleton gives "reset on restart" with no extra code.
  - Tool methods are not `suspend`, so a JVM monitor fits; a coroutine `Mutex` would need
    `suspend`.
  - `BigDecimal` subtraction stops cent drift such as `0.30000000000000004` from building up over
    repeated sends, while keeping the `Double` API the spec requires.
- **Alternatives**: `MutableStateFlow.update`, which is lock-free but retries the lambda and adds
  noise for no gain. Long cents everywhere would change the spec's `Double` contract.

## R5. Reference IDs and timestamps

- **Decision**: The prefix plus 8 characters drawn from `A-Z0-9` with `Random.Default`, and
  `Instant.now().toString()` for the ISO-8601 UTC timestamp.
- **Rationale**: Tests check format only (SC-001 exempts IDs and timestamps), so no clock or random
  injection is needed. minSdk 26 supports `java.time`.

## R6. Agent instructions placement

- **Decision**: Use a `const val` system prompt in `domain/agent/workflow/` and a class-level
  `@LLMDescription` on the ToolSet. Per-tool and per-parameter descriptions also state the
  channel and security rules.
- **Rationale**: The rules have to reach the model through both the system prompt and the tool
  schema. Putting them on the tool descriptions too means a future agent that forgets the prompt
  still sees them.
- **Deferred**: Wiring an agent or A2UI host is out of scope per the spec.

## R7. Serialization of arguments and results

- **Decision**: Mark entities and `DeliveryChannel` `@Serializable` (kotlinx). Tests decode tool
  arguments with `ai.koog.serialization.kotlinx.KotlinxSerializer()`.
- **Rationale**: In 1.3.0, tools exchange `ai.koog.serialization.JSONObject`/`JSONElement`, not
  kotlinx `JsonObject`. `ToolFromCallable` decodes each argument and encodes the result through the
  agent's `JSONSerializer`, whose default (`AIAgentConfig`, agent builders) is `KotlinxSerializer()`
  over `Json.Default`. Enum parameters become `ToolParameterType.Enum`, `Double` becomes `Float`.
- **Test call path**: `tools.getTool("executeSendTransfer")`, then
  `decodeArgs(JSONObject(mapOf("amount" to JSONPrimitive(50.0), ...)), KotlinxSerializer())`, then
  `execute(args)` inside `runTest` (it is `suspend`). `kotlinx-coroutines-test` is already a test
  dependency.
