// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions05

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.message.MessagePart

val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    val response = requestLLM()

    // The response might contain tool calls and/or text
    val toolCalls = response.parts.filterIsInstance<MessagePart.Tool.Call>()
    if (toolCalls.isNotEmpty()) {
        // Handle tool calls
    } else {
        // Handle text response
    }
}
   }
}
