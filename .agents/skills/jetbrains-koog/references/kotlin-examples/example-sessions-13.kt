// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions13

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.HistoryCompressionStrategy

val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    replaceHistoryWithTLDR(HistoryCompressionStrategy.FromLastNMessages(10), preserveMemory = true)
}
   }
}
