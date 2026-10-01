// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomStrategyGraphs03

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel
import ai.koog.agents.core.dsl.builder.subgraph
typealias Input = String
typealias Output = Int
typealias FirstInput = String
typealias FirstOutput = Int
typealias SecondInput = String
typealias SecondOutput = Int

val strategy = strategy<Input, Output>("strategy-name") {
    val firstSubgraph by subgraph<FirstInput, FirstOutput>("first") {
        // Define nodes and edges for this subgraph
    }
    val secondSubgraph by subgraph<SecondInput, SecondOutput>("second") {
        // Define nodes and edges for this subgraph
    }
}
