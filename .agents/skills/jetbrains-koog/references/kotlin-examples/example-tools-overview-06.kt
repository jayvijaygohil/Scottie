// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleToolsOverview06

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.example.exampleToolsOverview05.analysisAgentTool
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
const val apiKey = ""

// Create a coordinator agent that can use specialized agents as tools
val coordinatorAgent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(apiKey),
    llmModel = OpenAIModels.Chat.GPT4o,
    systemPrompt = "You coordinate different specialized services.",
    toolRegistry = ToolRegistry {
        tool(analysisAgentTool)
        // Add other tools as needed
    }
)
