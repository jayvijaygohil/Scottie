// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl01

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import ai.koog.prompt.executor.clients.anthropic.AnthropicParams
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = AnthropicLLMClient(System.getenv("ANTHROPIC_API_KEY"))

// Enable automatic caching with the default 5-minute TTL
val params = AnthropicParams(cacheControl = AnthropicCacheControl.Default)

val prompt = prompt("assistant", params = params) {
    system("You are a helpful assistant with a very long system prompt...")
    user("What can you help me with?")
}

val response = client.execute(prompt, AnthropicModels.Sonnet_4)
println(response)
}
