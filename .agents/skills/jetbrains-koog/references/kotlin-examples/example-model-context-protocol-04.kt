// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelContextProtocol04

import ai.koog.agents.mcp.metadata.McpServerInfo
import ai.koog.agents.mcp.McpToolRegistryProvider
import io.modelcontextprotocol.kotlin.sdk.types.Implementation
import io.modelcontextprotocol.kotlin.sdk.client.Client
import kotlinx.coroutines.runBlocking

val existingMcpClient = Client(clientInfo = Implementation(name = "mcpClient", version = "dev"))

fun main() {
    runBlocking {

// Create a tool registry from an existing MCP client
val toolRegistry = McpToolRegistryProvider.fromClient(
    mcpClient = existingMcpClient,
    serverInfo = McpServerInfo(url = "http://localhost:8931")
)
    }
}
