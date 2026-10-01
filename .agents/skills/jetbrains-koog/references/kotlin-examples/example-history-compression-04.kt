// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHistoryCompression04

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy
import ai.koog.agents.core.dsl.extension.nodeLLMCompressHistory
typealias ProcessedInput = String
val strategy = strategy<String, String>("strategy_name") {
    val node by node<Unit, Unit> {

val compressHistory by nodeLLMCompressHistory<ProcessedInput>(
    strategy = HistoryCompressionStrategy.WholeHistory
)
    }
}
