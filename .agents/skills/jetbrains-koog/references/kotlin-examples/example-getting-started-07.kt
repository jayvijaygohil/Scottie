// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted07

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.mistralai.MistralAILLMClient
import ai.koog.prompt.executor.clients.mistralai.MistralAIModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the Mistral AI API key from the MISTRAL_API_KEY environment variable
    val apiKey = System.getenv("MISTRAL_API_KEY")
        ?: error("The API key is not set.")
    
    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(MistralAILLMClient(apiKey)),
        llmModel = MistralAIModels.Chat.MistralMedium31
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
