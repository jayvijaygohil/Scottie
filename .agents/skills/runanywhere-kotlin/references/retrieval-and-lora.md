# RAG

> Answer questions over your own documents

Open a session with an embedding model, add documents, and ask questions.

```kotlin theme={null}
val session = RunAnywhere.rag.open(
    embeddingModel = ModelRef("all-minilm-l6-v2"),
    llmModel = ModelRef("qwen3-0.6b")
)

session.ingest(RagDocument.file(path))

val answer = session.query("What is the refund window?")
println(answer.text)

session.close()
```

## Opening a session

```kotlin theme={null}
suspend fun open(
    embeddingModel: ModelRef,
    llmModel: ModelRef? = null,
    config: RagConfig? = null
): RagSession
```

Omit `llmModel` for a retrieval-only session: `search` works, `query` does not.

## RagSession

```kotlin theme={null}
suspend fun ingest(document: RagDocument)
suspend fun ingest(documents: List<RagDocument>)
suspend fun search(query: String, topK: Int? = null): List<Match>
suspend fun query(question: String, options: RagQueryOptions? = null): RagResult
fun queryStream(question: String, options: RagQueryOptions? = null): Flow<RagEvent>
suspend fun stats(): RagStats
suspend fun clear()
suspend fun close()
```

## Ingesting

```kotlin theme={null}
session.ingest(RagDocument.file(path))
session.ingest(listOf(doc1, doc2, doc3))
```

Ingestion chunks the text, embeds each chunk, and indexes it. It is the slow part, so do it
once and keep the session, rather than re-ingesting per question.

## Retrieval without generation

```kotlin theme={null}
val matches = session.search("refund policy", topK = 5)
```

Useful when you want to show sources, or to feed the matches into your own prompt.

## Streaming an answer

```kotlin theme={null}
session.queryStream("What is the refund window?").collect { event ->
    when (event) {
        is RagEvent.Token -> answer += event.text
        is RagEvent.Sources -> sources = event.matches
        else -> {}
    }
}
```

## Configuration

```kotlin theme={null}
val session = RunAnywhere.rag.open(
    embeddingModel = ModelRef("all-minilm-l6-v2"),
    llmModel = ModelRef("qwen3-0.6b"),
    config = RagConfig(
        retrievalTopK = 5,
        chunkSize = 512,
        chunkOverlap = 64
    )
)
```

| Field                 | Meaning                                          |
|-----------------------|--------------------------------------------------|
| `retrievalTopK`       | Chunks retrieved per question                    |
| `chunkSize`           | Characters per chunk                             |
| `chunkOverlap`        | Overlap between neighbouring chunks              |
| `similarityThreshold` | Drop matches below this score                    |
| `persistPath`         | Where the index lives, for reuse across launches |

Overlap matters more than it looks. Without it, a sentence split across a chunk boundary is
retrievable from neither half.

## Closing

```kotlin theme={null}
session.close()
```

Sessions hold the index and the loaded models. Close them when the screen goes away.

## Housekeeping

```kotlin theme={null}
val stats = session.stats()
session.clear()
```

# Embeddings & Reranking

> Turn text into vectors, and reorder results against a query

Two namespaces that work together. `embeddings` turns text into vectors you can compare.
`rerank` takes a query and a list of candidates and reorders them by relevance.

## Embedding text

```kotlin theme={null}
val vectors = RunAnywhere.embeddings.embed(listOf("hello", "world"))
println(vectors[0].vector.size)
```

Vectors come back in input order, so index `i` of the result matches index `i` of the input.
Batch rather than looping: one call with fifty strings is far cheaper than fifty calls.

## Options

| Field       | Default | Meaning                                                    |
|-------------|---------|------------------------------------------------------------|
| `normalize` | `true`  | Unit-length vectors, so cosine similarity is a dot product |
| `pooling`   | `mean`  | How token vectors collapse into one                        |

Leave `normalize` on unless you have a reason. With it off, similarity scores are not
comparable across texts of different lengths.

## Reranking

```kotlin theme={null}
val ranked = RunAnywhere.rerank.rerank(
    query = "refund policy",
    documents = candidates,
    topN = 5
)
```

Reranking is a different model from embedding. An embedding model encodes each text once and
compares vectors, which is fast and approximate. A reranker reads the query and the candidate
together, which is slower and much more accurate.

The usual shape is both: retrieve widely with embeddings, then rerank the top handful.

## Where this fits

Most people reach for these through [RAG](/kotlin/rag), which does retrieval, reranking, and
generation in one session. Use the namespaces directly when you want the pieces separately:
semantic search with no generation, deduplication, clustering, or classification by nearest
neighbour.

## Models

Embedding and reranking models are small, often tens of megabytes rather than gigabytes. That
makes them cheap to keep resident alongside a language model.

# LoRA Adapters

> Layer an adapter onto the loaded base model

A LoRA adapter specialises a base model without swapping it out. Apply one, generate, remove
it.

```kotlin theme={null}
RunAnywhere.lora.apply("legal-summarizer")

val result = RunAnywhere.llm.generate("Summarize this contract clause: …")

RunAnywhere.lora.remove("legal-summarizer")
```

## The namespace

```kotlin theme={null}
suspend fun apply(adapterId: String, scale: Float? = null)
suspend fun remove(adapterId: String)
suspend fun removeAll()
suspend fun list(): LoraState
```

## Scale

`scale` controls how strongly the adapter pulls the base model. Leave it unset for the
adapter's own default.

```kotlin theme={null}
RunAnywhere.lora.apply("legal-summarizer", scale = 0.8f)
```

Lower values blend the adapter with the base behaviour; higher values commit to it. If output
degrades after applying an adapter, scale is the first thing to turn down.

## What is applied right now

```kotlin theme={null}
val state = RunAnywhere.lora.list()
```

## Removing

```kotlin theme={null}
RunAnywhere.lora.remove("legal-summarizer")
RunAnywhere.lora.removeAll()
```

Removal is keyed by adapter id.

## Switching between adapters

```kotlin theme={null}
suspend fun useAdapter(id: String) {
    RunAnywhere.lora.removeAll()
    RunAnywhere.lora.apply(id)
}
```

Adapters stack, so removing first is what keeps two of them from fighting.

## The base model has to support it

An adapter is trained against a specific base model. Applying one to a different base either
fails or produces nonsense. Check the model's `supportsLora` flag before offering adapters in
your interface.

<Note>
  Kotlin exposes the short form only: apply, remove, removeAll, list. Catalog management
  (registering adapters, querying a catalog, checking compatibility) is available on the Swift and
  Electron SDKs.
</Note>
