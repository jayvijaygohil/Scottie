// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl02

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = AnthropicLLMClient(System.getenv("ANTHROPIC_API_KEY"))

val prompt = prompt("assistant") {
    // Cache the system prompt for 1 hour
    system("You are a knowledgeable assistant...", AnthropicCacheControl.OneHour)
    user("Summarize the latest AI research.")
}

val response = client.execute(prompt, AnthropicModels.Sonnet_4)
println(response)
}
