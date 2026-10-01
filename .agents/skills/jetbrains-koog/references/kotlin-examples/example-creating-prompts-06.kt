// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts06

import ai.koog.prompt.dsl.prompt

val prompt = prompt("calculator_example") {
    system("You are a helpful assistant with access to tools.")
    user("What is 5 + 3?")
    // Tool call
    toolCall(
        id = "calculator_tool_id",
        tool = "calculator",
        args = """{"operation": "add", "a": 5, "b": 3}"""
    )
    // Tool result
    toolResult(
        id = "calculator_tool_id",
        tool = "calculator",
        output = "8"
    )

    // LLM response based on tool result
    assistant("The result of 5 + 3 is 8.")
    user("What is 4 + 5?")
}
