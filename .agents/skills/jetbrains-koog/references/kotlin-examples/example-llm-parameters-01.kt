// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters01

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.params.LLMParams

val prompt = prompt(
    id = "dev-assistant",
    params = LLMParams(
        temperature = 0.7,
        maxTokens = 500
    )
) {
    // Add a system message to set the context
    system("You are a helpful assistant.")

    // Add a user message
    user("Tell me about Kotlin")
}
