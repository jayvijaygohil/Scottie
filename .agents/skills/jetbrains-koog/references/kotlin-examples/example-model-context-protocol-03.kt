// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelContextProtocol03

import ai.koog.agents.example.exampleModelContextProtocol01.transport
import ai.koog.agents.mcp.metadata.McpServerInfo
import ai.koog.agents.mcp.McpToolRegistryProvider
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

// Create a tool registry with tools from the MCP server
val toolRegistry = McpToolRegistryProvider.fromTransport(
    transport = transport,
    serverInfo = McpServerInfo(url = "http://localhost:8931", command = "path/to/mcp/server"),
    name = "my-client",
    version = "1.0.0"
)
    }
}
