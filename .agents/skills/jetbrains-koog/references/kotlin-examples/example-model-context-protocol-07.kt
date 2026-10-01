// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelContextProtocol07

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.mcp.McpToolRegistryProvider
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import kotlinx.coroutines.runBlocking


val openAIApiToken = ""

fun main() {
    runBlocking { 

// Start the Playwright MCP server
val process = ProcessBuilder(
    "npx", "@playwright/mcp@latest", "--port", "8931"
).start()

// Create the ToolRegistry with tools from the MCP server
val toolRegistry = McpToolRegistryProvider.fromSseUrl("http://localhost:8931")

// Create and run the agent
val agent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(openAIApiToken),
    llmModel = OpenAIModels.Chat.GPT4o,
    toolRegistry = toolRegistry,
)
agent.run("Open a browser, navigate to jetbrains.com, accept all cookies, click AI in toolbar")
    }
}
