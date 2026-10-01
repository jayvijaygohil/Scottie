// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl06

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.bedrock.BedrockCacheControl
import ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings
import ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient
import ai.koog.prompt.executor.clients.bedrock.BedrockModels
import ai.koog.prompt.executor.clients.bedrock.BedrockRegions
import ai.koog.prompt.executor.clients.bedrock.StaticBearerTokenProvider
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = BedrockLLMClient(
        identityProvider = StaticBearerTokenProvider(token = "test-token"),
        settings = BedrockClientSettings(region = BedrockRegions.US_EAST_1.regionCode),
    )

val prompt = prompt("assistant") {
    // Cache the system prompt using the default TTL
    system("You are a knowledgeable assistant...", BedrockCacheControl.Default)
    user("What is prompt caching?")
}

val response = client.execute(prompt, BedrockModels.AnthropicClaude4Sonnet)
println(response)
}
