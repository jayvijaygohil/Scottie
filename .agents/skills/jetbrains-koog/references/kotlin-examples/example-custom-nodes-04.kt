// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes04

import ai.koog.agents.core.dsl.builder.AIAgentNodeDelegate
import ai.koog.agents.core.dsl.builder.AIAgentSubgraphBuilderBase
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
typealias Input = String
typealias Output = String
val strategy = strategy<String, String>("strategy_name") {

    fun AIAgentSubgraphBuilderBase<*, *>.myNodeWithArguments(
    name: String? = null,
    arg1: String,
    arg2: Int
): AIAgentNodeDelegate<Input, Output> = node(name) { input ->
    // Use arg1 and arg2 in your custom logic
    input // Return the input as the output
}

val myCustomNode by myNodeWithArguments("node_name", arg1 = "value1", arg2 = 42)
}
