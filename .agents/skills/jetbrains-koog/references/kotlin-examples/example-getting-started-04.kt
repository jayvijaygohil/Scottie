// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted04

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.deepseek.DeepSeekLLMClient
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.clients.deepseek.DeepSeekModels
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the DeepSeek API key from the DEEPSEEK_API_KEY environment variable
    val apiKey = System.getenv("DEEPSEEK_API_KEY")
        ?: error("The API key is not set.")

    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(DeepSeekLLMClient(apiKey)),
        llmModel = DeepSeekModels.DeepSeekV4Flash
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
