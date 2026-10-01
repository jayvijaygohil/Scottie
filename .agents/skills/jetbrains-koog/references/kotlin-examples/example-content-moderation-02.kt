// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleContentModeration02

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.ollama.client.OllamaClient
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

// Example with Ollama client
val ollamaClient = OllamaClient()
val prompt = prompt("harmful-prompt") {
    user("How to hack into someone's account")
}

// Moderate with Llama Guard 3
val result = ollamaClient.moderate(prompt, OllamaModels.Meta.LLAMA_GUARD_3)

if (result.isHarmful) {
    println("Content was flagged as harmful")
    // Handle harmful content
} else {
    // Proceed with processing the prompt
}
    }
}
