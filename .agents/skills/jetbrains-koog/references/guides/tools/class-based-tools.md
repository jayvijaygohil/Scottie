> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# Class-based tools

This section explains the API designed for scenarios that require enhanced flexibility and customized behavior.

This level of control is ideal for creating sophisticated tools that extend basic use cases, enabling seamless integration into agent sessions and workflows.

!!! note

## Tool implementation

The Koog framework provides the following approaches for implementing tools:

For Kotlin:

* Using the base class `Tool` for all tools. You should use this class when you need to return non-text results or require complete control over the tool behavior.
* Using the `SimpleTool` class that extends the base `Tool` class and simplifies the creation of tools that return text results. You should use this approach for scenarios where the 
  tool only needs to return a text.

Both approaches use the same core components but differ in implementation and the results they return.

### Tool class (Kotlin)

The [`Tool<Args, Result>`](../../api/tools.md#aikoogagentscoretoolstool) abstract class is the base class for creating tools in Kotlin.
It lets you create tools that accept specific argument types (`Args`) and return results of various types (`Result`).

Each tool consists of the following components:

| <div style="width:110px">Component</div> | Description                                                                                                                                                                                                                                                                                                                                                                                                                           |
|------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Args`                                   | The serializable data class that defines arguments required for the tool.                                                                                                                                                                                                                                                                                                                                                             |
| `Result`                                 | The serializable type of result that the tool returns. If you want to present tool results in a custom format, please inherit ToolResult.TextSerializable class and implement `textForLLM(): String` method                                                                                                           |
| `argsSerializer`                         | The overridden variable that defines how the arguments for the tool are deserialized. See also argsSerializer.                                                                                                                                                                                                                        |
| `resultSerializer`                       | The overridden variable that defines how the result of the tool is deserialized. See also resultSerializer. If you chose to inherit ToolResult.TextSerializable consider using `ToolResultUtils.toTextSerializer()` |
| `descriptor`                             | The overridden variable that specifies tool metadata:<br/>- `name`<br/>- `description`<br/>- `requiredParameters` (empty by default)<br/>- `optionalParameters` (empty by default)<br/>See also descriptor.                                                                                                                                |
| `execute()`                              | The function that implements the logic of the tool. It takes arguments of type `Args` and returns a result of type `Result`. See also execute().                                                                                                                                                                                                                                                                                  |

!!! tip

#### Usage example

Here is an example of a custom tool implementation using the `Tool` class that returns a numeric result:

=== "Kotlin"

    
    ```kotlin
    // Implement a simple calculator tool that adds two digits
    object CalculatorTool : Tool<CalculatorTool.Args, Int>(
        argsType = typeToken<Args>(),
        resultType = typeToken<Int>(),
        name = "calculator",
        description = "A simple calculator that can add two digits (0-9)."
    ) {

        // Arguments for the calculator tool
        @Serializable
        data class Args(
            @property:LLMDescription("The first digit to add (0-9)")
            val digit1: Int,
            @property:LLMDescription("The second digit to add (0-9)")
            val digit2: Int
        ) {
            init {
                require(digit1 in 0..9) { "digit1 must be a single digit (0-9)" }
                require(digit2 in 0..9) { "digit2 must be a single digit (0-9)" }
            }
        }

        // Function to add two digits
        override suspend fun execute(args: Args): Int = args.digit1 + args.digit2
    }
    ```
    

After implementing your tool, you need to add it to a tool registry and then use it with an agent. For details, see [Tool registry](index.md#tool-registry).

For more details, see [API reference](../../api/tools.md#aikoogagentscoretoolstool).

#### Reading the agent context from a tool

Tools that need the agent's full state (LLM context, run id, configuration, storage, ...) extend `AgentContextAwareTool<Args, Result>` instead of `Tool<Args, Result>`. The framework injects the live `AIAgentContext` driving the call, and the tool receives it as a typed parameter rather than reading it out of the argument schema.

=== "Kotlin"

    
    ```kotlin
    // A tool that reads the live AIAgentContext driving the call.
    object TracingCalculatorTool : AgentContextAwareTool<TracingCalculatorTool.Args, Int>(
        argsType = typeToken<Args>(),
        resultType = typeToken<Int>(),
        name = "tracing_calculator",
        description = "Adds two digits and emits a log line tagged with the agent run id."
    ) {
        @Serializable
        data class Args(
            @property:LLMDescription("The first digit to add (0-9)")
            val digit1: Int,
            @property:LLMDescription("The second digit to add (0-9)")
            val digit2: Int
        )

        override suspend fun execute(args: Args, context: AIAgentContext): Int {
            val runId = context.runId
            // ... use runId for cross-cutting context (logging, tracing, correlation)
            return args.digit1 + args.digit2
        }
    }
    ```
    

`AgentContextAwareTool` is dispatched by the framework via a per-call `ToolCallMetadata` side channel that the framework manages on the tool's behalf. Invoking such a tool outside an agent run throws `IllegalStateException` because no `AIAgentContext` was injected; production code should always go through `ContextualAgentEnvironment`, and unit tests can supply the context explicitly via `ToolCallMetadata.of(AgentContextAwareTool.AgentContextKey to context)`.

#### Reading raw per-call metadata

A small number of tools want to read caller- or feature-contributed entries that are *not* the agent context (for example a distributed-tracing span id contributed by an observability feature). These tools extend `ToolBase<Args, Result>` directly, which exposes the full `ToolCallMetadata` bag:

=== "Kotlin"

    
    ```kotlin
    object SpanAwareCalculatorTool : ToolBase<SpanAwareCalculatorTool.Args, Int>(
        argsType = typeToken<Args>(),
        resultType = typeToken<Int>(),
        name = "span_aware_calculator",
        description = "Adds two digits, propagating a tracing span id from caller or feature metadata."
    ) {
        @Serializable
        data class Args(
            @property:LLMDescription("The first digit to add (0-9)")
            val digit1: Int,
            @property:LLMDescription("The second digit to add (0-9)")
            val digit2: Int
        )

        override suspend fun execute(args: Args, metadata: ToolCallMetadata): Int {
            val traceSpanId = metadata["trace.span.id"] as? String
            // ... use traceSpanId for cross-cutting context (logging, tracing, correlation)
            return args.digit1 + args.digit2
        }
    }
    ```
    

Callers can pass metadata through `SafeTool.execute(args, serializer, metadata)` or directly through `AIAgentEnvironment.executeTool(toolCall, metadata)`. Features can contribute metadata for every tool call during installation by calling `pipeline.provideToolCallMetadata(this) { eventContext -> mapOf(...) }`. Caller-supplied metadata always wins over feature contributions on key collision.

Existing tools that extend `Tool<Args, Result>` and override `execute(args)` continue to work unchanged: the framework dispatches them through the same path and discards any `ToolCallMetadata`. To opt in to metadata, switch to `AgentContextAwareTool` (typed context access) or `ToolBase` (raw bag access).

### SimpleTool class (Kotlin)

The [`SimpleTool<Args>`](../../api/tools.md#aikoogagentscoretoolssimpletool) abstract class extends `Tool<Args, ToolResult.Text>` and simplifies the creation of tools that return text results.

Each simple tool consists of the following components:

| <div style="width:110px">Component</div> | Description                                                                                                                                                                                                                                                                                              |
|------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Args`                                   | The serializable data class that defines arguments required for the custom tool.                                                                                                                                                                                                                         |
| `argsSerializer`                         | The overridden variable that defines how the arguments for the tool are serialized. See also argsSerializer.                                                                                             |
| `descriptor`                             | The overridden variable that specifies tool metadata:<br/>- `name`<br/>- `description`<br/>- `requiredParameters` (empty by default)<br/> - `optionalParameters` (empty by default)<br/> See also descriptor. |
| `doExecute()`                            | The overridden function that describes the main action performed by the tool. It takes arguments of type `Args` and returns a `String`. See also doExecute().                                          |

!!! tip

#### Usage example 

Here is an example of a custom tool implementation using `SimpleTool` in Kotlin:

=== "Kotlin"

    
    ```kotlin
    // Create a tool that casts a string expression to a double value
    object CastToDoubleTool : SimpleTool<CastToDoubleTool.Args>(
        argsType = typeToken<Args>(),
        name = "cast_to_double",
        description = "casts the passed expression to double or returns 0.0 if the expression is not castable"
    ) {
        // Define tool arguments
        @Serializable
        data class Args(
            @property:LLMDescription("An expression to case to double")
            val expression: String,
            @property:LLMDescription("A comment on how to process the expression")
            val comment: String
        )

        // Function that executes the tool with the provided arguments
        override suspend fun execute(args: Args): String {
            return "Result: ${castToDouble(args.expression)}, " + "the comment was: ${args.comment}"
        }

        // Function to cast a string expression to a double value
        private fun castToDouble(expression: String): Double {
            return expression.toDoubleOrNull() ?: 0.0
        }
    }
    ```
    

`@LLMDescription`. Koog handles serialization and registration automatically through reflection. To learn more about the

#### Usage examples

implements a simple tool that returns a text result.

### Sending tool result to LLM in custom format

For Kotlin:

If you are not happy with JSON results sent to LLM (in some cases, LLMs can work better if tool output is structured as Markdown, for instance), you have to follow the following steps:

1. Implement `ToolResult.TextSerializable` interface, and override `textForLLM()` method
2. Override `resultSerializer` using `ToolResultUtils.toTextSerializer<T>()`

Return formatted text (such as Markdown) directly as a `String` from your annotated method. The framework handles this automatically.

#### Example

=== "Kotlin"

    
    ```kotlin
    // A tool that edits file
    object EditFile : Tool<EditFile.Args, EditFile.Result>(
        argsType = typeToken<Args>(),
        resultType = typeToken<Result>(),
        name = "edit_file",
        description = "Edits the given file"
    ) {
        // Define tool arguments
        @Serializable
        public data class Args(
            val path: String,
            val original: String,
            val replacement: String
        )

        @Serializable
        public data class Result(
            private val patchApplyResult: PatchApplyResult
        ) {

            @Serializable
            public sealed interface PatchApplyResult {
                @Serializable
                public data class Success(val updatedContent: String) : PatchApplyResult

                @Serializable
                public sealed class Failure(public val reason: String) : PatchApplyResult
            }

            // Textual output (in Markdown format) that will be visible to the LLM after the tool finishes.
            fun textForLLM(): String = markdown {
                if (patchApplyResult is PatchApplyResult.Success) {
                    line {
                        bold("Successfully").text(" edited file (patch applied)")
                    }
                } else {
                    line {
                        text("File was ")
                            .bold("not")
                            .text(" modified (patch application failed: ${(patchApplyResult as PatchApplyResult.Failure).reason})")
                    }
                }
            }

            override fun toString(): String = textForLLM()
        }

        // Function that executes the tool with the provided arguments
        override suspend fun execute(args: Args): Result {
            return TODO("Implement file edit")
        }
    }
    ```
    

For details, see Tool registry.

## Complete Kotlin examples

- [example-class-based-tools-01.kt](../../kotlin-examples/example-class-based-tools-01.kt)
- [example-class-based-tools-metadata-01.kt](../../kotlin-examples/example-class-based-tools-metadata-01.kt)
- [example-class-based-tools-metadata-02.kt](../../kotlin-examples/example-class-based-tools-metadata-02.kt)
- [example-class-based-tools-02.kt](../../kotlin-examples/example-class-based-tools-02.kt)
- [example-class-based-tools-03.kt](../../kotlin-examples/example-class-based-tools-03.kt)
