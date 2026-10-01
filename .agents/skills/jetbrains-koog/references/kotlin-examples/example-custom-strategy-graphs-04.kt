// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomStrategyGraphs04

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.ext.tool.SayToUser
typealias Input = String
typealias Output = Int
typealias FirstInput = String
typealias FirstOutput = Int
val someTool = SayToUser

val strategy = strategy<Input, Output>("strategy-name") {
    val firstSubgraph by subgraph<FirstInput, FirstOutput>(
        name = "first",
        tools = listOf(someTool)
    ) {
        // Define nodes and edges for this subgraph
    }
   // Define other subgraphs
}
