// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted03

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.google.GoogleLLMClient
import ai.koog.prompt.executor.clients.google.GoogleModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the Gemini API key from the GOOGLE_API_KEY environment variable
    val apiKey = System.getenv("GOOGLE_API_KEY")
        ?: error("The API key is not set.")

    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(GoogleLLMClient(apiKey)),
        llmModel = GoogleModels.Gemini2_5Pro
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
