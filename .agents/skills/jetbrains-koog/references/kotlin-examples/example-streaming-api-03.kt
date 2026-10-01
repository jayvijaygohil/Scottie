// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi03

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.streaming.filterTextOnly
import ai.koog.prompt.streaming.collectText
val strategy = strategy<String, String>("strategy_name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    val frames = requestLLMStreaming()

    // Stream text chunks as they come:
    frames.filterTextOnly().collect { chunk -> print(chunk) }

    // Or, gather all text into one String after End:
    val fullText = frames.collectText()
    println("\n---\n$fullText")
}
   }
}
