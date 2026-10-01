// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts10

import ai.koog.prompt.dsl.prompt

val basePrompt = prompt("base") {
    system("You are a helpful assistant.")
    user("Hello!")
    assistant("Hi! How can I help you?")
}

val extendedPrompt = prompt(basePrompt) {
    user("What's the weather like?")
}
