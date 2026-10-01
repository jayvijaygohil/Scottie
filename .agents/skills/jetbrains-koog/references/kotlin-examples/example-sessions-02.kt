// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions02

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node


val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.readSession {
    val messageCount = prompt.messages.size
    val availableTools = tools.map { it.name }
}
   }
}
