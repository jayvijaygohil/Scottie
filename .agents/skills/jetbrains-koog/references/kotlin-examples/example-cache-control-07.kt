// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl07

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.bedrock.BedrockCacheControl
import ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings
import ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient
import ai.koog.prompt.executor.clients.bedrock.BedrockModels
import ai.koog.prompt.executor.clients.bedrock.BedrockRegions
import ai.koog.prompt.executor.clients.bedrock.StaticBearerTokenProvider
import ai.koog.prompt.message.MessagePart
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = BedrockLLMClient(
        identityProvider = StaticBearerTokenProvider(token = "test-token"),
        settings = BedrockClientSettings(region = BedrockRegions.US_EAST_1.regionCode),
    )

val prompt = prompt("conversation") {
    system("You are a helpful assistant.")
    // Cache after the large context message
    user("Here is the document: ...", BedrockCacheControl.FiveMinutes)
    assistant(listOf(MessagePart.Text("I have read the document.")))
    user("Summarize it.")
}

val response = client.execute(prompt, BedrockModels.AnthropicClaude4Sonnet)
println(response)
}
