// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleClassBasedToolsMetadata01

import ai.koog.agents.core.agent.context.AIAgentContext
import ai.koog.agents.core.agent.tools.AgentContextAwareTool
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

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
