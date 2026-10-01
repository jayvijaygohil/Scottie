// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting08

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.*
import ai.koog.agents.example.exampleTesting03.mockLLMApi
import ai.koog.agents.example.exampleTesting02.toolRegistry
import ai.koog.agents.ext.tool.AskUser
import ai.koog.agents.testing.feature.assistantMessage
import ai.koog.agents.testing.feature.testGraph
import ai.koog.agents.testing.feature.toolCallMessagePart
import ai.koog.agents.core.dsl.extension.ReceivedToolResults
import ai.koog.agents.core.dsl.extension.ToolCalls
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.message.Message
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable
import ai.koog.agents.core.tools.annotations.LLMDescription
object AnalyzeTool : Tool<AnalyzeTool.Args, String>(
    argsType = typeToken<Args>(),
    resultType = typeToken<String>(),
    name = "message",
    description = "Service tool, used by the agent to talk with user"
) {
    @Serializable
    data class Args(
        @property:LLMDescription("Message from the agent")
        val query: String,
        val depth: Int
    )
    override suspend fun execute(args: Args): String = args.query
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
                val askLLM = assertNodeByName<String, Message.Assistant>("callLLM")

assertNodes {
    // Test with different inputs to the same node
    askLLM withInput "Simple query" outputs assistantMessage("Simple response")

    // Test with complex parameters
    askLLM withInput "Complex query with parameters" outputs assistantMessage(
        AnalyzeTool,
        AnalyzeTool.Args(query = "parameters", depth = 3)
    )
}
            }
        }
    }
}
