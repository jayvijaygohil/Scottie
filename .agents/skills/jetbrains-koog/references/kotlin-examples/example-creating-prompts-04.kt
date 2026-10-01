// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts04

import ai.koog.prompt.dsl.prompt

val prompt = prompt("user_message") {
    system("You are a helpful assistant.")
    user("What is Koog?")
}
