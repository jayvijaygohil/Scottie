// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the Anthropic API key from the ANTHROPIC_API_KEY environment variable
    val apiKey = System.getenv("ANTHROPIC_API_KEY")
        ?: error("The API key is not set.")

    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(AnthropicLLMClient(apiKey)),
        llmModel = AnthropicModels.Opus_4_1
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
