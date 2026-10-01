// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts07

import ai.koog.prompt.dsl.prompt

val prompt = prompt("text_example") {
    user {
        +"Review the following code snippet:"
        +"fun greet(name: String) = println(\"Hello, \$name!\")"

        // Paragraph break
        br()
        text("Please include in your explanation:")

        // Indent content
        padding("  ") {
            +"1. What the function does."
            +"2. How string interpolation works."
        }
    }
}
