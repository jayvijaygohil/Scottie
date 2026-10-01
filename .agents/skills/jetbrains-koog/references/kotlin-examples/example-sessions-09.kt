// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions09

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node


val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    // Add a user message
    appendPrompt {
        user("What's the capital of France?")
    }

    // Make a request - the response is automatically added to the history
    val response = requestLLM()

    // The prompt now includes both the user message and the model's response
}
   }
}
