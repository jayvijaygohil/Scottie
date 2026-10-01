// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleClassBasedToolsMetadata02

import ai.koog.agents.core.tools.ToolBase
import ai.koog.agents.core.tools.ToolCallMetadata
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

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
