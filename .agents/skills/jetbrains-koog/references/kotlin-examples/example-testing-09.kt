// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting09

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.environment.ReceivedToolResult
import ai.koog.agents.core.tools.*
import ai.koog.agents.example.exampleTesting03.mockLLMApi
import ai.koog.agents.example.exampleTesting02.toolRegistry
import ai.koog.agents.testing.feature.testGraph
import ai.koog.agents.testing.feature.assistantMessage
import ai.koog.agents.testing.feature.toolCallMessagePart
import ai.koog.agents.core.dsl.extension.ReceivedToolResults
import ai.koog.agents.core.dsl.extension.ToolCalls
import ai.koog.agents.testing.feature.toolResult
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.message.Message
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable
object AnalyzeTool : Tool<AnalyzeTool.Args, AnalyzeTool.Result>(
    argsType = typeToken<Args>(),
    resultType = typeToken<Result>(),
    name = "message",
    description = "Service tool, used by the agent to talk with user"
) {
    @Serializable
    data class Args(
        val query: String,
        val depth: Int
    )
    @Serializable
    data class Result(
        val analysis: String,
        val confidence: Double,
        val metadata: Map<String, String> = mapOf()
    )
    override suspend fun execute(args: Args): Result {
        return Result(
            args.query, 0.95,
            mapOf("source" to "mock", "timestamp" to "2023-06-15")
        )
    }
}
val llmModel = OpenAIModels.Chat.GPT4o
fun main() {
    AIAgent(
        // Constructor arguments
        promptExecutor = mockLLMApi,
        toolRegistry = toolRegistry,
        llmModel = llmModel
    ) {
        testGraph<String, String>("test") {
            assertNodes {
                val callTool = assertNodeByName<ToolCalls, ReceivedToolResults>("executeTool")

assertNodes {
    // Test a complex tool call with a structured result
    callTool withInput ToolCalls(listOf(toolCallMessagePart(
        AnalyzeTool,
        AnalyzeTool.Args(query = "complex", depth = 5)
    ))) outputs ReceivedToolResults(listOf(toolResult(AnalyzeTool, AnalyzeTool.Args(query = "complex", depth = 5), AnalyzeTool.Result(
        analysis = "Detailed analysis",
        confidence = 0.95,
        metadata = mapOf("source" to "database", "timestamp" to "2023-06-15")
    ))))
}
            }
        }
    }
}
