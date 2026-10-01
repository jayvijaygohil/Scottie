// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelContextProtocol02

import ai.koog.agents.mcp.McpToolRegistryProvider

// Create the SSE transport
val transport = McpToolRegistryProvider.defaultSseTransport("http://localhost:8931")
