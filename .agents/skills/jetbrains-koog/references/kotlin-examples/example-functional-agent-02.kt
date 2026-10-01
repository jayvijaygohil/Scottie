// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleFunctionalAgent02

import ai.koog.agents.core.agent.functionalStrategy
import ai.koog.prompt.message.Message
import ai.koog.prompt.message.MessagePart

fun Message.Assistant.text(): String =
    parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }

val strategy = functionalStrategy<String, String> { input ->
    // The first LLM call produces an initial draft based on the user input
    val draft = requestLLM("Draft: $input").text()
    // The second LLM call improves the initial draft
    val improved = requestLLM("Improve and clarify.").text()
    // The final LLM call formats the improved text and returns the result
    requestLLM("Format the result as bold.").text()
}
