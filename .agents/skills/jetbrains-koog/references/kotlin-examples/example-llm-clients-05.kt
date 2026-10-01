// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmClients05

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val apiKey = System.getenv("OPENAI_API_KEY")
    val client = OpenAILLMClient(apiKey)

    val embedding = client.embed(
        text = "This is a sample text for embedding",
        model = OpenAIModels.Embeddings.TextEmbedding3Large
    )

    println("Embedding size: ${embedding.size}")
}
