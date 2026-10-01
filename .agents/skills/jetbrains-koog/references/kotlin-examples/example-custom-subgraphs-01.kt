// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomSubgraphs01

import ai.koog.agents.core.agent.entity.ToolSelectionStrategy
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
typealias StrategyInput = Unit
typealias StrategyOutput = Unit
typealias Input = Unit
typealias Output = Unit
val strategy =

strategy<StrategyInput, StrategyOutput>("strategy-name") {
    val subgraphIdentifier by subgraph<Input, Output>(
        name = "subgraph-name",
        toolSelectionStrategy = ToolSelectionStrategy.ALL
    ) {
        // Define nodes and edges for this subgraph
    }

    nodeStart then subgraphIdentifier then nodeFinish
}
