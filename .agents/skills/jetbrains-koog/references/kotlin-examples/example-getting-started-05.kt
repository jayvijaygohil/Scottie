// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted05

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.openrouter.OpenRouterLLMClient
import ai.koog.prompt.executor.clients.openrouter.OpenRouterModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the OpenRouter API key from the OPENROUTER_API_KEY environment variable
    val apiKey = System.getenv("OPENROUTER_API_KEY")
        ?: error("The API key is not set.")
    
    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(OpenRouterLLMClient(apiKey)),
        llmModel = OpenRouterModels.GPT4o
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
