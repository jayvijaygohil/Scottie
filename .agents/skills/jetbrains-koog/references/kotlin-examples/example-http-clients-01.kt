// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHttpClients01

import ai.koog.http.client.ktor.KtorKoogHttpClient
import ai.koog.prompt.executor.clients.anthropic.AnthropicClientSettings
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIClientSettings
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient

fun main() {
    val factory = KtorKoogHttpClient.Factory()

    val openai = OpenAILLMClient(
        apiKey = System.getenv("OPENAI_API_KEY"),
        settings = OpenAIClientSettings(),
        httpClientFactory = factory,
    )

    val anthropic = AnthropicLLMClient(
        apiKey = System.getenv("ANTHROPIC_API_KEY"),
        settings = AnthropicClientSettings(),
        httpClientFactory = factory,
    )
}
