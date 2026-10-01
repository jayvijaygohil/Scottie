// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions06

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.example.exampleParallelNodeExecution07.JokeRating


val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    // Make a structured request
    val structuredResponse = requestLLMStructured<JokeRating>()

    // Make a streaming request
    val responseStream = requestLLMStreaming()
    responseStream.collect { chunk ->
        // Process each chunk as it arrives
    }
}
   }
}
