// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts03

import ai.koog.prompt.dsl.prompt

val prompt = prompt("system_message") {
    system("You are a helpful assistant that explains technical concepts.")
}
