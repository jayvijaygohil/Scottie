# Retrieval and embeddings

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.embeddings.base.Embedder.diff

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-embedder/diff.html`

### :embeddings:embeddings-base/commonMain

```kotlin
abstract fun diff(embedding1: Vector, embedding2: Vector): Double
```

Calculates the difference between two embeddings. Lower values indicate more similar embeddings.

A measure of difference between the embeddings.

- embedding1 — The first embedding.
- embedding2 — The second embedding.
## ai.koog.embeddings.base.Embedder.embed

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-embedder/embed.html`

### :embeddings:embeddings-base/commonMain

```kotlin
abstract suspend fun embed(text: String): Vector
```

Embeds the given text into a vector representation.

A vector representation of the text.

- text — The text to embed.
## ai.koog.embeddings.base.Embedder

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-embedder/index.html`

### :embeddings:embeddings-base/commonMain

```kotlin
interface Embedder
```

Interface for text embedding operations. Implementations of this interface can convert text into vector representations (embeddings) and calculate the difference between two embeddings.

## ai.koog.embeddings.base.Vector.Vector

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/-vector.html`

### :embeddings:embeddings-base/commonMain

```kotlin
constructor(values: List<Double>)
```

## ai.koog.embeddings.base.Vector.cosineSimilarity

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/cosine-similarity.html`

### :embeddings:embeddings-base/commonMain

```kotlin
fun cosineSimilarity(other: Vector): Double
```

Calculates the cosine similarity between this vector and another vector. The result is a value between -1 and 1, where 1 means the vectors are identical, 0 means they are orthogonal, and -1 means they are completely opposite.

The cosine similarity between the two vectors.

- other — The other vector to compare with.
- IllegalArgumentException — if the vectors have different dimensions.
## ai.koog.embeddings.base.Vector.dimension

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/dimension.html`

### :embeddings:embeddings-base/commonMain

```kotlin
val dimension: Int
```

Returns the dimension (size) of the vector.

## ai.koog.embeddings.base.Vector.dotProduct

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/dot-product.html`

### :embeddings:embeddings-base/commonMain

```kotlin
infix fun dotProduct(other: Vector): Double
```

Calculates the dot product of this vector and the given vector. The dot product is the sum of the products of the corresponding elements of the two vectors.

The dot product of the two vectors as a double.

- other — The vector to compute the dot product with. It must have the same dimension as this vector.
- IllegalArgumentException — if the vectors have different dimensions.
## ai.koog.embeddings.base.Vector.euclideanDistance

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/euclidean-distance.html`

### :embeddings:embeddings-base/commonMain

```kotlin
fun euclideanDistance(other: Vector): Double
```

Calculates the Euclidean distance between this vector and another vector. The result is a non-negative value, where 0 means the vectors are identical.

The Euclidean distance between the two vectors.

- other — The other vector to compare with.
- IllegalArgumentException — if the vectors have different dimensions.
## ai.koog.embeddings.base.Vector

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/index.html`

### :embeddings:embeddings-base/commonMain

```kotlin
@Serializable data class Vector(val values: List<Double>)
```

Represents a vector of floating-point values. Used for storing embeddings of text.

## ai.koog.embeddings.base.Vector.isNull

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/is-null.html`

### :embeddings:embeddings-base/commonMain

```kotlin
fun isNull(): Boolean
```

Checks if the vector is a null vector, i.e., all its components are equal to 0.0.

True if all components of the vector are 0.0, false otherwise.

## ai.koog.embeddings.base.Vector.magnitude

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/magnitude.html`

### :embeddings:embeddings-base/commonMain

```kotlin
fun magnitude(): Double
```

Computes the magnitude (Euclidean norm) of the vector. The magnitude is calculated as the square root of the sum of the squares of the vector's elements.

The magnitude of the vector as a non-negative Double.

## ai.koog.embeddings.base.Vector.values

Module: `embeddings-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-base/ai.koog.embeddings.base/-vector/values.html`

### :embeddings:embeddings-base/commonMain

```kotlin
val values: List<Double>
```

## ai.koog.embeddings.local.LLMEmbedder.LLMEmbedder

Module: `embeddings-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-llm/ai.koog.embeddings.local/-l-l-m-embedder/-l-l-m-embedder.html`

### :embeddings:embeddings-llm/commonMain

```kotlin
constructor(client: LLMEmbeddingProvider, model: LLModel)
```


Referenced packages: `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.embeddings.local.LLMEmbedder.diff

Module: `embeddings-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-llm/ai.koog.embeddings.local/-l-l-m-embedder/diff.html`

### :embeddings:embeddings-llm/commonMain

```kotlin
open override fun diff(embedding1: Vector, embedding2: Vector): Double
```

Calculates the difference between two embeddings using cosine distance. Cosine distance is defined as 1 - cosine similarity. The result is a value between 0 and 1, where 0 means the embeddings are identical.

The cosine distance between the embeddings.

- embedding1 — The first embedding.
- embedding2 — The second embedding.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.embeddings.local.LLMEmbedder.embed

Module: `embeddings-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-llm/ai.koog.embeddings.local/-l-l-m-embedder/embed.html`

### :embeddings:embeddings-llm/commonMain

```kotlin
open suspend override fun embed(text: String): Vector
```

Embeds the given text using the Ollama model.

A vector representation of the text.

- text — The text to embed.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.embeddings.local.LLMEmbedder

Module: `embeddings-llm`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `embeddings/embeddings-llm/ai.koog.embeddings.local/-l-l-m-embedder/index.html`

### :embeddings:embeddings-llm/commonMain

```kotlin
class LLMEmbedder(client: LLMEmbeddingProvider, model: LLModel) : Embedder
```

Implementation of the Embedder interface that uses Ollama models for embedding text.


Referenced packages: `ai.koog.embeddings.base`, `ai.koog.prompt.executor.clients`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.LLMEmbeddingProvider.LLMEmbeddingProvider

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-embedding-provider/-l-l-m-embedding-provider.html`

### :prompt:prompt-executor:prompt-executor-clients/androidMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/appleMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
expect constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/jsMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
actual constructor()
```

### :prompt:prompt-executor:prompt-executor-clients/wasmJsMain

```kotlin
actual constructor()
```

## ai.koog.prompt.executor.clients.LLMEmbeddingProvider

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-embedding-provider/index.html`

### :prompt:prompt-executor:prompt-executor-clients/androidMain

```kotlin
actual abstract class LLMEmbeddingProvider : LLMEmbeddingProviderAPI
```

Abstract base class for LLM embedding providers on Android.

Implements LLMEmbeddingProviderAPI. Platform-specific blocking wrappers are not available on this target; use the suspending embed methods from LLMEmbeddingProviderAPI directly.

### :prompt:prompt-executor:prompt-executor-clients/appleMain

```kotlin
actual abstract class LLMEmbeddingProvider : LLMEmbeddingProviderAPI
```

Abstract base class for LLM embedding providers on Apple platforms.

Implements LLMEmbeddingProviderAPI. Platform-specific blocking wrappers are not available on this target; use the suspending embed methods from LLMEmbeddingProviderAPI directly.


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
expect abstract class LLMEmbeddingProvider : LLMEmbeddingProviderAPI
```

Abstract base class for LLM embedding providers.

### :prompt:prompt-executor:prompt-executor-clients/jsMain

```kotlin
actual abstract class LLMEmbeddingProvider : LLMEmbeddingProviderAPI
```

Implements LLMEmbeddingProviderAPI. Platform-specific blocking wrappers are not available on this target; use the suspending embed methods from LLMEmbeddingProviderAPI directly.


Referenced packages: `ai.koog.prompt.executor.clients`.

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
actual abstract class LLMEmbeddingProvider : LLMEmbeddingProviderAPI
```

JVM-specific abstract base class for LLM embedding providers.

- LLMClient
### :prompt:prompt-executor:prompt-executor-clients/wasmJsMain

```kotlin
actual abstract class LLMEmbeddingProvider : LLMEmbeddingProviderAPI
```

Abstract base class for LLM embedding providers on Wasm/JS.

Implements LLMEmbeddingProviderAPI. Platform-specific blocking wrappers are not available on this target; use the suspending embed methods from LLMEmbeddingProviderAPI directly.


Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.LLMEmbeddingProviderAPI.embed

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-embedding-provider-a-p-i/embed.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text using the given model into a vector of double-precision numbers.

A list of floating-point values representing the embedding.

- text — The text to embed.
- model — The model to use for embedding. Must have the Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given input using the given model into a vector of double-precision numbers.

A list of lists of floating-point values representing the embedding. Each inner list represents a single input embedding.

- inputs — The input to embed.
- model — The model to use for embedding. Must have the Embed capability.
- IllegalArgumentException — if the model does not have the Embed capability.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.LLMEmbeddingProviderAPI

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients/-l-l-m-embedding-provider-a-p-i/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
interface LLMEmbeddingProviderAPI
```

API for LLMEmbeddingProvider

- LLMClient
- LLMEmbeddingProvider
## ai.koog.rag.base.DocumentWithPayload.DocumentWithPayload

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-document-with-payload/-document-with-payload.html`

### :rag:rag-base/commonMain

```kotlin
constructor(document: Document, payload: Payload)
```

- Document — The type of the document being stored or processed.
- Payload — The type of the payload associated with the document.
## ai.koog.rag.base.DocumentWithPayload.document

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-document-with-payload/document.html`

### :rag:rag-base/commonMain

```kotlin
val document: Document
```

## ai.koog.rag.base.DocumentWithPayload

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-document-with-payload/index.html`

### :rag:rag-base/commonMain

```kotlin
data class DocumentWithPayload<Document, Payload>(val document: Document, val payload: Payload)
```

Represents a document accompanied by its associated payload.

This data class ties a document of type Document to its corresponding payload of type Payload. It is commonly used in contexts where both the document and its additional metadata or associated data (the payload) need to be stored, retrieved, or manipulated together.

- Document — The type of the document being stored or processed.
- Payload — The type of the payload associated with the document.
## ai.koog.rag.base.DocumentWithPayload.payload

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-document-with-payload/payload.html`

### :rag:rag-base/commonMain

```kotlin
val payload: Payload
```

## ai.koog.rag.base.TextDocument.content

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-text-document/content.html`

### :rag:rag-base/commonMain

```kotlin
abstract val content: String
```

The main textual content of the document.

## ai.koog.rag.base.TextDocument.id

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-text-document/id.html`

### :rag:rag-base/commonMain

```kotlin
abstract val id: String?
```

Optional unique identifier for the document.

## ai.koog.rag.base.TextDocument

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-text-document/index.html`

### :rag:rag-base/commonMain

```kotlin
interface TextDocument
```

A document with textual content, an optional identifier, and optional metadata.

This interface is the common abstraction for any text-bearing document that can be stored in or retrieved from a ai.koog.rag.base.storage.SearchStorage or ai.koog.rag.base.storage.WriteStorage.

## ai.koog.rag.base.TextDocument.metadata

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base/-text-document/metadata.html`

### :rag:rag-base/commonMain

```kotlin
abstract val metadata: Map<String, Any>
```

Optional key-value metadata associated with the document.

## ai.koog.rag.base.storage.DeletionStorage.delete

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-deletion-storage/delete.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun delete(ids: List<String>, namespace: String? = null): List<String>
```

Deletes documents with the specified identifiers from the storage.

The list of identifiers that were successfully deleted.

- ids — The list of document identifiers to delete.
- namespace — An optional namespace to scope the deletion. If null, the default namespace is used.
## ai.koog.rag.base.storage.DeletionStorage

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-deletion-storage/index.html`

### :rag:rag-base/commonMain

```kotlin
interface DeletionStorage
```

Storage interface that provides the ability to delete documents by their identifiers.

- FilteringDeletionStorage
## ai.koog.rag.base.storage.LookupStorage.get

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-lookup-storage/get.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun get(ids: List<String>, namespace: String? = null): List<Document>
```

Gets documents by their identifiers.

The list of documents matching the given identifiers.

- ids — The list of document identifiers to get.
- namespace — An optional namespace to scope. If null, the default namespace is used.
## ai.koog.rag.base.storage.LookupStorage

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-lookup-storage/index.html`

### :rag:rag-base/commonMain

```kotlin
interface LookupStorage<Document>
```

Storage interface that provides the ability to look up documents by their identifiers.

- Document — The type of the documents being read.
## ai.koog.rag.base.storage.SearchStorage

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-search-storage/index.html`

### :rag:rag-base/commonMain

```kotlin
interface SearchStorage<Document, in Request : SearchRequest>
```

Represents a specialization of the DocumentStorage interface that handles ranking documents based on their relevance to a given query. The ranking process returns documents along with a similarity score, enabling the filtering and sorting of documents by relevance.

- Document — The type of the documents being processed and stored.
- Request — The type of search requests accepted by this storage.

Referenced packages: `ai.koog.rag.base.storage.search`.

## ai.koog.rag.base.storage.SearchStorage.search

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-search-storage/search.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun search(request: Request, namespace: String? = null): List<SearchResult<Document>>
```

Searches for documents matching the given request and returns them ranked by relevance.

A list of search results, each containing a document and its score.

- request — The search request containing the query, result limit, and other search parameters.
- namespace — An optional namespace to scope the search. If null, the default namespace is used.

Referenced packages: `ai.koog.rag.base.storage.search`.

## ai.koog.rag.base.storage.WriteStorage.add

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-write-storage/add.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun add(documents: List<Document>, namespace: String? = null): List<String>
```

Adds new documents to the storage.

The list of identifiers assigned to the newly added documents.

- documents — The list of documents to add.
- namespace — An optional namespace to scope the storage. If null, the default namespace is used.
## ai.koog.rag.base.storage.WriteStorage

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-write-storage/index.html`

### :rag:rag-base/commonMain

```kotlin
interface WriteStorage<Document>
```

Storage interface that provides the ability to write (add and update) documents.

- Document — The type of the documents being stored.
## ai.koog.rag.base.storage.WriteStorage.update

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/-write-storage/update.html`

### :rag:rag-base/commonMain

```kotlin
abstract suspend fun update(documents: Map<String, Document>, namespace: String? = null): List<String>
```

Updates existing documents in the storage.

The list of identifiers of the successfully updated documents.

- documents — A map of document identifiers to their updated document content.
- namespace — An optional namespace to scope the storage. If null, the default namespace is used.
## ai.koog.rag.base.storage.searchAsFlow

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage/search-as-flow.html`

### :rag:rag-base/commonMain

```kotlin
fun <Document, Request : SearchRequest> SearchStorage<Document, Request>.searchAsFlow(request: Request, namespace: String? = null): Flow<SearchResult<Document>>
```

Returns the results of SearchStorage.search as a Flow instead of a list.

A Flow emitting search results, each containing a document and its score.

- request — The search request containing the query, result limit, and other search parameters.
- namespace — An optional namespace to scope the search. If null, the default namespace is used.

Referenced packages: `ai.koog.rag.base.storage.search`.

## ai.koog.rag.base.storage.search.HybridSearchRequest.HybridSearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/-hybrid-search-request.html`

### :rag:rag-base/commonMain

```kotlin
constructor(queryText: String, alpha: Double = 0.5, limit: Int = 10, offset: Int = 0, minScore: Double? = null, filterExpression: String? = null)
```

## ai.koog.rag.base.storage.search.HybridSearchRequest.alpha

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/alpha.html`

### :rag:rag-base/commonMain

```kotlin
val alpha: Double
```

## ai.koog.rag.base.storage.search.HybridSearchRequest.filterExpression

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/filter-expression.html`

### :rag:rag-base/commonMain

```kotlin
open override val filterExpression: String?
```

## ai.koog.rag.base.storage.search.HybridSearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/index.html`

### :rag:rag-base/commonMain

```kotlin
data class HybridSearchRequest(val queryText: String, val alpha: Double = 0.5, val limit: Int = 10, val offset: Int = 0, val minScore: Double? = null, val filterExpression: String? = null) : SearchRequest, HasTextQuery, HasScoreThreshold, HasFilterExpression
```

A search request that combines similarity (vector) and keyword (lexical) search strategies.

The alpha parameter controls the balance between the two strategies:

0.0 uses vector search only

1.0 uses keyword search only

0.5 (default) gives equal weight to both strategies

- IllegalArgumentException — if alpha is not in [0.0, 1.0]
## ai.koog.rag.base.storage.search.HybridSearchRequest.limit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/limit.html`

### :rag:rag-base/commonMain

```kotlin
open override val limit: Int
```

## ai.koog.rag.base.storage.search.HybridSearchRequest.minScore

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/min-score.html`

### :rag:rag-base/commonMain

```kotlin
open override val minScore: Double?
```

## ai.koog.rag.base.storage.search.HybridSearchRequest.offset

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/offset.html`

### :rag:rag-base/commonMain

```kotlin
open override val offset: Int
```

## ai.koog.rag.base.storage.search.HybridSearchRequest.queryText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-hybrid-search-request/query-text.html`

### :rag:rag-base/commonMain

```kotlin
open override val queryText: String
```

## ai.koog.rag.base.storage.search.KeywordSearchRequest.KeywordSearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/-keyword-search-request.html`

### :rag:rag-base/commonMain

```kotlin
constructor(queryText: String, limit: Int = 10, offset: Int = 0, minScore: Double? = null, filterExpression: String? = null)
```

## ai.koog.rag.base.storage.search.KeywordSearchRequest.filterExpression

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/filter-expression.html`

### :rag:rag-base/commonMain

```kotlin
open override val filterExpression: String?
```

## ai.koog.rag.base.storage.search.KeywordSearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/index.html`

### :rag:rag-base/commonMain

```kotlin
data class KeywordSearchRequest(val queryText: String, val limit: Int = 10, val offset: Int = 0, val minScore: Double? = null, val filterExpression: String? = null) : SearchRequest, HasTextQuery, HasScoreThreshold, HasFilterExpression
```

A search request that performs keyword-based (lexical) search using the provided query text.

## ai.koog.rag.base.storage.search.KeywordSearchRequest.limit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/limit.html`

### :rag:rag-base/commonMain

```kotlin
open override val limit: Int
```

## ai.koog.rag.base.storage.search.KeywordSearchRequest.minScore

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/min-score.html`

### :rag:rag-base/commonMain

```kotlin
open override val minScore: Double?
```

## ai.koog.rag.base.storage.search.KeywordSearchRequest.offset

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/offset.html`

### :rag:rag-base/commonMain

```kotlin
open override val offset: Int
```

## ai.koog.rag.base.storage.search.KeywordSearchRequest.queryText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-keyword-search-request/query-text.html`

### :rag:rag-base/commonMain

```kotlin
open override val queryText: String
```

## ai.koog.rag.base.storage.search.Score.Score

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score/-score.html`

### :rag:rag-base/commonMain

```kotlin
constructor(value: Double, metric: ScoreMetric)
```

## ai.koog.rag.base.storage.search.Score

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score/index.html`

### :rag:rag-base/commonMain

```kotlin
data class Score(val value: Double, val metric: ScoreMetric)
```

Represents a relevance score for a search result.

## ai.koog.rag.base.storage.search.Score.metric

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score/metric.html`

### :rag:rag-base/commonMain

```kotlin
val metric: ScoreMetric
```

## ai.koog.rag.base.storage.search.Score.value

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-score/value.html`

### :rag:rag-base/commonMain

```kotlin
val value: Double
```

## ai.koog.rag.base.storage.search.SearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-request/index.html`

### :rag:rag-base/commonMain

```kotlin
interface SearchRequest
```

Base interface for all search requests against a storage backend.

- SimilaritySearchRequest
- KeywordSearchRequest
- HybridSearchRequest
## ai.koog.rag.base.storage.search.SearchRequest.limit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-request/limit.html`

### :rag:rag-base/commonMain

```kotlin
abstract val limit: Int
```

maximum number of results to return

## ai.koog.rag.base.storage.search.SearchRequest.offset

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-request/offset.html`

### :rag:rag-base/commonMain

```kotlin
abstract val offset: Int
```

number of results to skip for pagination

## ai.koog.rag.base.storage.search.SearchResult.SearchResult

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/-search-result.html`

### :rag:rag-base/commonMain

```kotlin
constructor(document: Document, score: Score, id: String? = null, metadata: JsonObject? = null, namespace: String? = null)
```

- Document — the type of the stored document
## ai.koog.rag.base.storage.search.SearchResult.document

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/document.html`

### :rag:rag-base/commonMain

```kotlin
val document: Document
```

## ai.koog.rag.base.storage.search.SearchResult.id

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/id.html`

### :rag:rag-base/commonMain

```kotlin
val id: String?
```

## ai.koog.rag.base.storage.search.SearchResult

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/index.html`

### :rag:rag-base/commonMain

```kotlin
data class SearchResult<Document>(val document: Document, val score: Score, val id: String? = null, val metadata: JsonObject? = null, val namespace: String? = null)
```

Represents a single result returned from a storage search operation.

- Document — the type of the stored document
## ai.koog.rag.base.storage.search.SearchResult.metadata

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/metadata.html`

### :rag:rag-base/commonMain

```kotlin
val metadata: JsonObject?
```

## ai.koog.rag.base.storage.search.SearchResult.namespace

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/namespace.html`

### :rag:rag-base/commonMain

```kotlin
val namespace: String?
```

## ai.koog.rag.base.storage.search.SearchResult.score

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-search-result/score.html`

### :rag:rag-base/commonMain

```kotlin
val score: Score
```

## ai.koog.rag.base.storage.search.SimilaritySearchRequest.SimilaritySearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/-similarity-search-request.html`

### :rag:rag-base/commonMain

```kotlin
constructor(queryText: String, limit: Int = 10, offset: Int = 0, minScore: Double? = null, filterExpression: String? = null)
```

## ai.koog.rag.base.storage.search.SimilaritySearchRequest.filterExpression

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/filter-expression.html`

### :rag:rag-base/commonMain

```kotlin
open override val filterExpression: String?
```

## ai.koog.rag.base.storage.search.SimilaritySearchRequest

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/index.html`

### :rag:rag-base/commonMain

```kotlin
data class SimilaritySearchRequest(val queryText: String, val limit: Int = 10, val offset: Int = 0, val minScore: Double? = null, val filterExpression: String? = null) : SearchRequest, HasTextQuery, HasScoreThreshold, HasFilterExpression
```

A search request that performs similarity (vector) search using the provided query text.

The query text is typically converted into an embedding vector by the storage backend and compared against stored document vectors.

## ai.koog.rag.base.storage.search.SimilaritySearchRequest.limit

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/limit.html`

### :rag:rag-base/commonMain

```kotlin
open override val limit: Int
```

## ai.koog.rag.base.storage.search.SimilaritySearchRequest.minScore

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/min-score.html`

### :rag:rag-base/commonMain

```kotlin
open override val minScore: Double?
```

## ai.koog.rag.base.storage.search.SimilaritySearchRequest.offset

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/offset.html`

### :rag:rag-base/commonMain

```kotlin
open override val offset: Int
```

## ai.koog.rag.base.storage.search.SimilaritySearchRequest.queryText

Module: `rag-base`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-base/ai.koog.rag.base.storage.search/-similarity-search-request/query-text.html`

### :rag:rag-base/commonMain

```kotlin
open override val queryText: String
```

## ai.koog.rag.vector.storage.EmbeddingStorage.EmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/-embedding-storage.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(embedder: DocumentEmbedder<Document>, storage: VectorStorageBackend<Document>)
```

- Document — The type of the document being stored and ranked.

Referenced packages: `ai.koog.rag.vector.backend`, `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.EmbeddingStorage.add

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/add.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun add(documents: List<Document>, namespace: String?): List<String>
```

## ai.koog.rag.vector.storage.EmbeddingStorage.allDocuments

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/all-documents.html`

### :rag:rag-vector/commonMain

```kotlin
open fun allDocuments(): Flow<Document>
```

Retrieves a flow of all documents stored in the system.

A flow emitting each document individually.

## ai.koog.rag.vector.storage.EmbeddingStorage.capabilities

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/capabilities.html`

### :rag:rag-vector/commonMain

```kotlin
open override val capabilities: Set<StorageCapability>
```


Referenced packages: `ai.koog.rag.base.storage.capability`.

## ai.koog.rag.vector.storage.EmbeddingStorage.delete

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/delete.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun delete(ids: List<String>, namespace: String?): List<String>
```

## ai.koog.rag.vector.storage.EmbeddingStorage.get

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/get.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun get(ids: List<String>, namespace: String?): List<Document>
```

## ai.koog.rag.vector.storage.EmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/index.html`

### :rag:rag-vector/commonMain

```kotlin
open class EmbeddingStorage<Document>(embedder: DocumentEmbedder<Document>, storage: VectorStorageBackend<Document>) : VectorStorage<Document, SimilaritySearchRequest> , CapabilityAwareStorage
```

A VectorStorage naive implementation that composes a DocumentEmbedder with a VectorStorageBackend.

The embedding step is handled by this class, while the actual persistence is delegated to the provided VectorStorageBackend. This separation allows swapping backends (in-memory, file-based, real vector database) independently from the embedding model.

Subclasses can customize embedding, scoring, or request handling by overriding the protected template methods embedDocument, embedQuery, and score, without rewriting entire storage operations.

- Document — The type of the document being stored and ranked.
- FileDocumentEmbeddingStorage
- InMemoryDocumentEmbeddingStorage

Referenced packages: `ai.koog.rag.base.storage.capability`, `ai.koog.rag.base.storage.search`, `ai.koog.rag.vector.backend`, `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.EmbeddingStorage.search

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/search.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun search(request: SimilaritySearchRequest, namespace: String?): List<SearchResult<Document>>
```


Referenced packages: `ai.koog.rag.base.storage.search`.

## ai.koog.rag.vector.storage.EmbeddingStorage.update

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-embedding-storage/update.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun update(documents: Map<String, Document>, namespace: String?): List<String>
```
