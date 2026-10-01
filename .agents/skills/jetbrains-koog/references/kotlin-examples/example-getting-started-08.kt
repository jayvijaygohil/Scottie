// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGettingStarted08

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.ollama.client.OllamaClient
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Create an agent
    val agent = AIAgent(
        promptExecutor = MultiLLMPromptExecutor(OllamaClient()),
        llmModel = OllamaModels.Meta.LLAMA_3_2
    )

    // Run the agent
    val result = agent.run("Hello! How can you help me?")
    println(result)
}
