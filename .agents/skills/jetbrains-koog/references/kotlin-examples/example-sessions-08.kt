// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions08

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.message.Message

val filteredMessages = emptyList<Message>()

val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    // Create a new prompt based on the old one
    prompt = prompt.copy(messages = filteredMessages)
}
   }
}
