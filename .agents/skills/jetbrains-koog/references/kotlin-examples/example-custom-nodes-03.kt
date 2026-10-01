// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes03

import ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate
import ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
typealias Input = String
typealias Output = String
val strategy = strategy<String, String>("strategy_name") {

fun AIAgentSubgraphBuilderBase<*, *>.myCustomNode(
    name: String? = null
): AIAgentNodeDelegate<Input, Output> = node(name) { input ->
    // Custom logic
    input // Return the input as output (pass-through)
}

val myCustomNode by myCustomNode("node_name")
}
