// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi02

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.structure.markdown.MarkdownStructureDefinition
val strategy = strategy<String, String>("strategy_name") {
    val node by node<Unit, Unit> {

fun markdownBookDefinition(): MarkdownStructureDefinition {
    return MarkdownStructureDefinition("name", schema = { /*...*/ })
}

val mdDefinition = markdownBookDefinition()

llm.writeSession {
    val stream = requestLLMStreaming(mdDefinition)
    // Access the raw string chunks directly
    stream.collect { chunk ->
        // Process each chunk of text as it arrives
        println("Received chunk: $chunk") // The chunks together will be structured as a text following the mdDefinition schema
    }
}
   }
}
