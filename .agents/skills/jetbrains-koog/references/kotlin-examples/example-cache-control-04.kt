// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl04

import ai.koog.agents.core.tools.ToolDescriptor
import ai.koog.agents.core.tools.ToolParameterDescriptor
import ai.koog.agents.core.tools.ToolParameterType
import ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl

val searchTool = ToolDescriptor(
    name = "web_search",
    description = "Search the web for information.",
    requiredParameters = listOf(
        ToolParameterDescriptor("query", "Search query", ToolParameterType.String)
    ),
    // Cache all tool definitions up to and including this one
    cacheControl = AnthropicCacheControl.Default
)
