// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes10

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.message.MessagePart
val strategy = strategy<String, String>("strategy_name") {

val summarizeTextNode by node<String, String>("node_name") { input ->
    llm.writeSession {
        appendPrompt {
            user("Please summarize the following text: $input")
        }

        val response = requestLLMWithoutTools()
        response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
    }
}
}
