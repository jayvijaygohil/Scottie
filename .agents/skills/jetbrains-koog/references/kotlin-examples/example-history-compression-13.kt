// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHistoryCompression13

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.nodeLLMCompressHistory
import ai.koog.agents.example.exampleHistoryCompression12.MyCustomCompressionStrategy
typealias ProcessedInput = String
val strategy = strategy<String, String>("strategy_name") {

val compressHistory by nodeLLMCompressHistory<ProcessedInput>(
    strategy = MyCustomCompressionStrategy()
)
}
