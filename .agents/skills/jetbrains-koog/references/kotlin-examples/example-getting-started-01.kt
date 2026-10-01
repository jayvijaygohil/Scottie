// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Get the OpenAI API key from the OPENAI_API_KEY environment variable
    val apiKey = System.getenv("OPENAI_API_KEY")
        ?: error("The API key is not set.")

    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(OpenAILLMClient(apiKey)),
        llmModel = OpenAIModels.Chat.GPT4o
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
