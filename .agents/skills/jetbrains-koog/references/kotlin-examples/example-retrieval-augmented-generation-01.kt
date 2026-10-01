// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleRetrievalAugmentedGeneration01

import ai.koog.embeddings.local.LLMEmbedder
import ai.koog.prompt.executor.ollama.client.OllamaClient
import ai.koog.prompt.executor.ollama.client.OllamaModels
import ai.koog.rag.base.storage.search.SimilaritySearchRequest
import ai.koog.rag.vector.embedder.JVMTextDocumentEmbedder
import ai.koog.rag.vector.backend.InMemoryVectorStorageBackend
import ai.koog.rag.vector.storage.EmbeddingStorage
import kotlinx.coroutines.runBlocking
import kotlin.io.path.Path

fun main() {
    runBlocking {

// 1. Create an embedder backed by a local Ollama model
val embedder = LLMEmbedder(
    client = OllamaClient(),
    model = OllamaModels.Embeddings.NOMIC_EMBED_TEXT
)

// 2. Create a JVM document embedder that reads files and embeds their text
val documentEmbedder = JVMTextDocumentEmbedder(embedder)

// 3. Create an EmbeddingStorage with an in-memory backend
val storage = EmbeddingStorage(
    embedder = documentEmbedder,
    storage = InMemoryVectorStorageBackend()
)

// 4. Add documents to the storage
storage.add(
    listOf(
        Path("./docs/faq.txt"),
        Path("./docs/pricing.txt"),
        Path("./docs/getting-started.txt")
    )
)

// 5. Search for the most relevant documents
val results = storage.search(
    SimilaritySearchRequest(
        queryText = "How do I reset my password?",
        limit = 3,
        minScore = 0.5
    )
)

results.forEach { result ->
    println("${result.document} (score: ${result.score.value})")
}
    }
}
