// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHttpClients02

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor

fun main() {
    val apiKey = System.getenv("OPENAI_API_KEY")

    val client = OpenAILLMClient(apiKey)
    val executor = simpleOpenAIExecutor(apiKey)
}
