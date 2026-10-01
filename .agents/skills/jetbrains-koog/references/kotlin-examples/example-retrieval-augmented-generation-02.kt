// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleRetrievalAugmentedGeneration02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool
import ai.koog.agents.core.tools.reflect.asTool
import ai.koog.embeddings.local.LLMEmbedder
import ai.koog.prompt.executor.ollama.client.OllamaClient
import ai.koog.prompt.executor.ollama.client.OllamaModels
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.rag.base.storage.SearchStorage
import ai.koog.rag.base.storage.search.SimilaritySearchRequest
import ai.koog.rag.vector.embedder.JVMTextDocumentEmbedder
import ai.koog.rag.vector.backend.InMemoryVectorStorageBackend
import ai.koog.rag.vector.storage.EmbeddingStorage
import kotlinx.coroutines.runBlocking
import kotlin.io.path.readText
import kotlin.io.path.Path

// Create the RAG storage
val embedder = LLMEmbedder(OllamaClient(), OllamaModels.Embeddings.NOMIC_EMBED_TEXT)
val documentEmbedder = JVMTextDocumentEmbedder(embedder)
val ragStorage = EmbeddingStorage(documentEmbedder, InMemoryVectorStorageBackend())

const val apiKey = "apikey"

// Define a tool that searches the RAG storage
@Tool
@LLMDescription("Search the knowledge base for documents relevant to a query. Returns the content of the most relevant documents.")
suspend fun searchKnowledgeBase(
    @LLMDescription("The search query describing what information you need")
    query: String,
    @LLMDescription("Maximum number of documents to return")
    count: Int
): String {
    val results = ragStorage.search(
        SimilaritySearchRequest(
            queryText = query,
            limit = count,
            minScore = 0.5
        )
    )

    if (results.isEmpty()) {
        return "No relevant documents found for: $query"
    }

    val response = StringBuilder("Found ${results.size} relevant documents:\n\n")
    results.forEachIndexed { index, result ->
        val content = result.document.readText()
        response.append("Document ${index + 1}: ${result.document.fileName}")
        response.append(" (score: ${"%.2f".format(result.score.value)})\n")
        response.append("Content: $content\n\n")
    }
    return response.toString()
}

fun main() {
    runBlocking {
        // Register the search tool and create an agent
        val tools = ToolRegistry {
            tool(::searchKnowledgeBase.asTool())
        }

        val agent = AIAgent(
            toolRegistry = tools,
            promptExecutor = simpleOpenAIExecutor(apiKey),
            llmModel = OpenAIModels.Chat.GPT4o
        )

        val response = agent.run("What is your refund policy?")
        println("Agent response: $response")
    }
}
