// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleFunctionalAgent01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.functionalStrategy
import ai.koog.prompt.message.MessagePart
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking

val strategy = functionalStrategy<String, String> { input ->
    val response = requestLLM(input)
    response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
}

val mathAgent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
    strategy = strategy
)

fun main() = runBlocking {
    val result = mathAgent.run("What is 12 × 9?")
    println(result)
}
