// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleToolsOverview05

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.AIAgentService
import ai.koog.agents.core.agent.createAgentTool
import ai.koog.agents.core.tools.ToolParameterDescriptor
import ai.koog.agents.core.tools.ToolParameterType
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.serialization.typeToken
const val apiKey = ""
val analysisToolRegistry = ToolRegistry {}

// Create a specialized agent service, responsible for creating financial analysis agents.
val analysisAgentService = AIAgentService(
    promptExecutor = simpleOpenAIExecutor(apiKey),
    llmModel = OpenAIModels.Chat.GPT4o,
    systemPrompt = "You are a financial analysis specialist.",
    toolRegistry = analysisToolRegistry
)

// Create a tool that would run financial analysis agent once called.
val analysisAgentTool = analysisAgentService.createAgentTool(
    agentName = "analyzeTransactions",
    agentDescription = "Performs financial transaction analysis",
    inputDescription = "Transaction analysis request",
    inputType = typeToken<String>(),
)
