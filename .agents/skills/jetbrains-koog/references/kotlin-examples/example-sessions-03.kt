// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSessions03

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.tools.ToolDescriptor

val newTools = listOf<ToolDescriptor>()

val strategy = strategy<Unit, Unit>("strategy-name") {
    val node by node<Unit, Unit> {

llm.writeSession {
    // Modify the prompt
    appendPrompt {
        user("New user message")
    }

    // Modify the tools
    tools = newTools
}
   }
}
