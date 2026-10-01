// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomSubgraphs06

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
val strategy = strategy<String, String>("my-strategy") {
    val node by node<Unit, Unit>("node_name") {

// Make a set of tools
this.llm.writeSession {
    tools = tools.filter { it.name in listOf("first_tool_name", "second_tool_name") }
}
    }
}
