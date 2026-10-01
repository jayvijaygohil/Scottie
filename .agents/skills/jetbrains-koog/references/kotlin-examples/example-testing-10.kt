// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting10

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.environment.ReceivedToolResult
import ai.koog.agents.core.tools.*
import ai.koog.agents.example.exampleTesting03.mockLLMApi
import ai.koog.agents.example.exampleTesting02.toolRegistry
import ai.koog.agents.example.exampleTesting03.CreateTool
import ai.koog.agents.testing.feature.assistantMessage
import ai.koog.agents.testing.feature.testGraph
import ai.koog.agents.testing.feature.toolCallMessagePart
import ai.koog.agents.core.dsl.extension.ReceivedToolResults
import ai.koog.agents.core.dsl.extension.ToolCalls
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.message.Message
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
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
                val askLLM = assertNodeByName<String, Message.Assistant>("callLLM")
                val giveFeedback = assertNodeByName<String, Message.Assistant>("giveFeedback")

assertEdges {
    // Test text message routing
    askLLM withOutput assistantMessage("Hello!") goesTo giveFeedback

    // Test tool call routing
    askLLM withOutput assistantMessage(CreateTool, CreateTool.Args("solve")) goesTo callTool
}
            }
        }
    }
}
