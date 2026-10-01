// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions07

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.message.MessagePart

val myToolResult = MessagePart.Tool.Result(
    id = "",
    tool = "",
    output = "",
)

val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    appendPrompt {
        // Add a system message
        system("You are a helpful assistant.")

        // Add a user message
        user("Hello, can you help me with a coding question?")

        // Add an assistant message
        assistant("Of course! What's your question?")

        // Add a tool result
        toolResult(myToolResult)
    }
}
   }
}
