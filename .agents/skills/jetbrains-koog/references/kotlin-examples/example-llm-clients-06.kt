// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmClients06

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val apiKey = System.getenv("OPENAI_API_KEY")
    val client = OpenAILLMClient(apiKey)

    val result = client.moderate(
        prompt = prompt("moderation") {
            user("This is a test message that may contain offensive content.")
        },
        model = OpenAIModels.Moderation.Omni
    )

    println(result)
}
