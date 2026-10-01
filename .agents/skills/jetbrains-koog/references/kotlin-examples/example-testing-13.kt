// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting13

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.dsl.extension.ReceivedToolResults
import ai.koog.agents.core.dsl.extension.ToolCalls
import ai.koog.agents.example.exampleTesting03.mockLLMApi
import ai.koog.agents.example.exampleTesting02.toolRegistry
import ai.koog.agents.example.exampleTesting09.AnalyzeTool
import ai.koog.agents.testing.feature.testGraph
import ai.koog.agents.testing.feature.toolResult
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.message.Message
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
                val finish = assertNodeByName<String, Message.Assistant>("finish")
                val verifyResult = assertNodeByName<String, Message.Assistant>("verifyResult")

assertEdges {
    // Route to different nodes based on confidence level
    callTool withOutput ReceivedToolResults(listOf(toolResult(
        AnalyzeTool,
        AnalyzeTool.Args(query = "parameters", depth = 3),
        AnalyzeTool.Result(analysis = "Complete", confidence = 0.9)
    ))) goesTo finish

    callTool withOutput ReceivedToolResults(listOf(toolResult(
        AnalyzeTool,
        AnalyzeTool.Args(query = "parameters", depth = 3),
        AnalyzeTool.Result(analysis = "Uncertain", confidence = 0.3)
    ))) goesTo verifyResult
}
            }
        }
    }
}
