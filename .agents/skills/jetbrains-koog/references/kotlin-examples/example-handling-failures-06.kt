// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures06

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.clients.retry.RetryConfig
import ai.koog.prompt.executor.clients.retry.RetryingLLMClient
import ai.koog.prompt.dsl.prompt
import kotlinx.coroutines.runBlocking
fun main() {
    runBlocking {
        val baseClient = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
        val prompt = prompt("test") {
            user("Generate a story")
        }

val config = RetryConfig(
    maxAttempts = 3
)

val client = RetryingLLMClient(baseClient, config)
val stream = client.executeStreaming(prompt, OpenAIModels.Chat.GPT4o)
    }
}
