// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent06

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMCompressHistory
import ai.koog.agents.core.dsl.extension.nodeDoNothing
import ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy
val strategy = strategy<String, String>("strategy_name") {
    val generateHugeHistory by nodeDoNothing<String>()

val compressHistory by nodeLLMCompressHistory<String>(
    "compressHistory",
    strategy = HistoryCompressionStrategy.FromLastNMessages(10),
    preserveMemory = true
)
edge(generateHugeHistory forwardTo compressHistory)
}
