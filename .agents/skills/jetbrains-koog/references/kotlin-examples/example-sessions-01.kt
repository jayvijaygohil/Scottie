// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions01

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node

val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

// Creating a write session
llm.writeSession {
    // Session code here
}

// Creating a read session
llm.readSession {
    // Session code here
}
   }
}
