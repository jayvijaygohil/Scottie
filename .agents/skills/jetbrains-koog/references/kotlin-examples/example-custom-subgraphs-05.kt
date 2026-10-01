// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomSubgraphs05

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.tools.ToolRegistry
val toolRegistry = ToolRegistry.EMPTY
val strategy = strategy<String, String>("my-strategy") {

val mySubgraph by subgraph<String, String>(
    tools = listOf(toolRegistry.getTool("AskUser"))
) {
    // Subgraph definition
}
}
