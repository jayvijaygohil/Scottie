// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting05

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.dsl.extension.ReceivedToolResults
import ai.koog.agents.core.dsl.extension.ToolCalls
import ai.koog.agents.example.exampleTesting03.mockLLMApi
import ai.koog.agents.example.exampleTesting02.toolRegistry
import ai.koog.agents.testing.feature.testGraph
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
        val firstSubgraph = assertSubgraphByName<String, String>("first")
        val secondSubgraph = assertSubgraphByName<String, String>("second")

        // Assert subgraph connections
        assertEdges {
            startNode() alwaysGoesTo firstSubgraph
            firstSubgraph alwaysGoesTo secondSubgraph
            secondSubgraph alwaysGoesTo finishNode()
        }

        // Verify the first subgraph
        verifySubgraph(firstSubgraph) {
            val start = startNode()
            val finish = finishNode()

            // Assert nodes by name
            val askLLM = assertNodeByName<String, Message.Assistant>("callLLM")
            val callTool = assertNodeByName<ToolCalls, ReceivedToolResults>("executeTool")

            // Assert node reachability
            assertReachable(start, askLLM)
            assertReachable(askLLM, callTool)
        }
    }
}
}
