// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted06

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.bedrock.BedrockClientSettings
import ai.koog.prompt.executor.clients.bedrock.BedrockLLMClient
import ai.koog.prompt.executor.clients.bedrock.BedrockModels
import ai.koog.prompt.executor.clients.bedrock.StaticBearerTokenProvider
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the Bedrock API key from the BEDROCK_API_KEY environment variable
    val apiKey = System.getenv("BEDROCK_API_KEY")
        ?: error("The API key is not set.")
    
    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(
            BedrockLLMClient(
                StaticBearerTokenProvider(apiKey),
                BedrockClientSettings()
            )
        ),
        llmModel = BedrockModels.AnthropicClaude4_5Sonnet
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
