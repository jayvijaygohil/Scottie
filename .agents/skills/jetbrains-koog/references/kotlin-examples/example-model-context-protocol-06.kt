// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelContextProtocol06

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.mcp.McpToolRegistryProvider
import ai.koog.agents.mcp.fromProcess
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import kotlinx.coroutines.runBlocking

const val googleMapsApiKey = ""
const val openAIApiToken = ""
fun main() {
    runBlocking { 

// Start the Docker container with the Google Maps MCP server
val process = ProcessBuilder(
    "docker", "run", "-i",
    "-e", "GOOGLE_MAPS_API_KEY=$googleMapsApiKey",
    "mcp/google-maps"
).start()

// Create the ToolRegistry with tools from the MCP server
val toolRegistry = McpToolRegistryProvider.fromProcess(process = process)

// Create and run the agent
val agent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(openAIApiToken),
    llmModel = OpenAIModels.Chat.GPT4o,
    toolRegistry = toolRegistry,
)
agent.run("Get elevation of the Jetbrains Office in Munich, Germany?")
    }
}
