// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleOpentelemetrySupport12

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.agents.mcp.McpToolRegistryProvider
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.utils.io.use
import io.opentelemetry.exporter.logging.LoggingSpanExporter
import kotlinx.coroutines.runBlocking
fun main() {
    runBlocking {
        val promptExecutor = simpleOpenAIExecutor("openai-api-key")

// Create MCP tools registry
val toolRegistry = McpToolRegistryProvider.fromSseUrl("http://localhost:3000")

// Create agent with OpenTelemetry enabled and pass the tool registry
val agent = AIAgent(
    promptExecutor = promptExecutor,
    llmModel = OpenAIModels.Chat.GPT4o,
    systemPrompt = "You are a helpful assistant.",
    toolRegistry = toolRegistry
) {
    install(OpenTelemetry) {
        setServiceInfo("mcp-agent-service", "1.0.0")
        addSpanExporter(LoggingSpanExporter.create())
    }
}

// Run agent - MCP tool calls will be automatically instrumented
agent.use {
    it.run("Use the search tool to find information")
}
    }
}
