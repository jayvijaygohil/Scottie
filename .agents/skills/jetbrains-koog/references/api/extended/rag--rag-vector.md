# rag / rag-vector

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.rag.vector.backend.FileVectorStorageBackend.FileVectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/-file-vector-storage-backend.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(documentReader: DocumentProvider<Path, Document>, fs: FileSystemProvider.ReadWrite<Path>, root: Path)
```

- documentReader — A provider responsible for handling document serialization and deserialization.
- fs — A file system provider enabling read and write operations for file storage.
- root — Root file path where the storage system will organize data.
- Document — Type representing the document to be stored.
- Path — Type representing the file path in the storage system.

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.vector.backend.FileVectorStorageBackend.allDocumentsWithPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/all-documents-with-payload.html`

### :rag:rag-vector/commonMain

```kotlin
open override fun allDocumentsWithPayload(): Flow<DocumentWithPayload<Document, Vector>>
```

Retrieves a flow of all documents with their vector embeddings.

A flow of DocumentWithPayload items.


Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base`.

## ai.koog.rag.vector.backend.FileVectorStorageBackend.allDocuments

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/all-documents.html`

### :rag:rag-vector/commonMain

```kotlin
open override fun allDocuments(): Flow<Document>
```

Retrieves a flow of all documents.

A flow of documents.

## ai.koog.rag.vector.backend.FileVectorStorageBackend.delete

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/delete.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun delete(documentId: String): Boolean
```

Deletes the document with the specified ID.

true if the document was successfully deleted, false otherwise.

- documentId — The unique identifier of the document to delete.
## ai.koog.rag.vector.backend.FileVectorStorageBackend.getPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/get-payload.html`

### :rag:rag-vector/commonMain

```kotlin
suspend fun getPayload(documentId: String): Vector?
```

Retrieves the vector payload associated with the document identified by the given document ID.

The vector associated with the document, or null if no such document exists.

- documentId — The unique identifier of the document whose vector is being retrieved.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.backend.FileVectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/index.html`

### :rag:rag-vector/commonMain

```kotlin
open class FileVectorStorageBackend<Document, Path>(documentReader: DocumentProvider<Path, Document>, fs: FileSystemProvider.ReadWrite<Path>, root: Path) : VectorStorageBackend<Document>
```

A file-system-based implementation of VectorStorageBackend that manages the storage and retrieval of documents and their corresponding vector embeddings within a file system.

Documents and vectors are stored in separate subdirectories under the root path.

- documentReader — A provider responsible for handling document serialization and deserialization.
- fs — A file system provider enabling read and write operations for file storage.
- root — Root file path where the storage system will organize data.
- Document — Type representing the document to be stored.
- Path — Type representing the file path in the storage system.
- JVMFileVectorStorageBackend

Referenced packages: `ai.koog.rag.base.files`.

## ai.koog.rag.vector.backend.FileVectorStorageBackend.readWithPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/read-with-payload.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun readWithPayload(documentId: String): DocumentWithPayload<Document, Vector>?
```

Reads a document along with its vector embedding by document ID.

A DocumentWithPayload containing the document and its vector, or null if not found.

- documentId — The unique identifier of the document to read.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base`.

## ai.koog.rag.vector.backend.FileVectorStorageBackend.read

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/read.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun read(documentId: String): Document?
```

Reads a document by its unique identifier.

The document, or null if not found.

- documentId — The unique identifier of the document to read.
## ai.koog.rag.vector.backend.FileVectorStorageBackend.store

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-file-vector-storage-backend/store.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun store(document: Document, vector: Vector): String
```

Stores a document along with its pre-computed vector embedding.

A unique string identifier for the stored document.

- document — The document to store.
- vector — The pre-computed vector embedding for the document.

Referenced packages: `ai.koog.embeddings.base`.

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun store(id: String, document: Document, vector: Vector): Boolean
```

Updates a document along with its pre-computed vector embedding under the specified ID. Only updates if a document with the given ID already exists.

true if the document was successfully updated, false if no document with the given id exists.

- id — The unique identifier of the document to update.
- document — The updated document.
- vector — The pre-computed vector embedding for the document.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.InMemoryVectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/-in-memory-vector-storage-backend.html`

### :rag:rag-vector/commonMain

```kotlin
constructor()
```

- Document — The type of document managed by this storage.
## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.allDocumentsWithPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/all-documents-with-payload.html`

### :rag:rag-vector/commonMain

```kotlin
open override fun allDocumentsWithPayload(): Flow<DocumentWithPayload<Document, Vector>>
```

Retrieves a flow of all documents with their vector embeddings.

A flow of DocumentWithPayload items.


Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base`.

## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.allDocuments

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/all-documents.html`

### :rag:rag-vector/commonMain

```kotlin
open override fun allDocuments(): Flow<Document>
```

Retrieves a flow of all documents.

A flow of documents.

## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.delete

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/delete.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun delete(documentId: String): Boolean
```

Deletes the document with the specified ID.

true if the document was successfully deleted, false otherwise.

- documentId — The unique identifier of the document to delete.
## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/index.html`

### :rag:rag-vector/commonMain

```kotlin
class InMemoryVectorStorageBackend<Document> : VectorStorageBackend<Document>
```

A concrete implementation of VectorStorageBackend that stores documents and their associated vector embeddings in memory.

Use this class to manage the storage and retrieval of documents and their vector-based data without relying on any external persistent storage. This is suitable for in-memory operations and testing environments where persistent storage is not required.

- Document — The type of document managed by this storage.
## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.readWithPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/read-with-payload.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun readWithPayload(documentId: String): DocumentWithPayload<Document, Vector>?
```

Reads a document along with its vector embedding by document ID.

A DocumentWithPayload containing the document and its vector, or null if not found.

- documentId — The unique identifier of the document to read.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base`.

## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.read

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/read.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun read(documentId: String): Document?
```

Reads a document by its unique identifier.

The document, or null if not found.

- documentId — The unique identifier of the document to read.
## ai.koog.rag.vector.backend.InMemoryVectorStorageBackend.store

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-in-memory-vector-storage-backend/store.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun store(document: Document, vector: Vector): String
```

Stores a document along with its pre-computed vector embedding.

A unique string identifier for the stored document.

- document — The document to store.
- vector — The pre-computed vector embedding for the document.

Referenced packages: `ai.koog.embeddings.base`.

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun store(id: String, document: Document, vector: Vector): Boolean
```

Updates a document along with its pre-computed vector embedding under the specified ID. Only updates if a document with the given ID already exists.

true if the document was successfully updated, false if no document with the given id exists.

- id — The unique identifier of the document to update.
- document — The updated document.
- vector — The pre-computed vector embedding for the document.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.backend.JVMFileVectorStorageBackend.JVMFileVectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-j-v-m-file-vector-storage-backend/-j-v-m-file-vector-storage-backend.html`

### :rag:rag-vector/jvmMain

```kotlin
constructor(root: Path)
```

Initializes the JVMFileVectorStorageBackend with a specified root directory root.

- root — The root directory where all documents and vector embeddings will be stored.
## ai.koog.rag.vector.backend.JVMFileVectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-j-v-m-file-vector-storage-backend/index.html`

### :rag:rag-vector/jvmMain

```kotlin
class JVMFileVectorStorageBackend(root: Path) : FileVectorStorageBackend<Path, Path>
```

A JVM-specific implementation of FileVectorStorageBackend for managing the storage of documents and associated vector embeddings on a file system.

This class utilizes a ai.koog.rag.base.files.JVMDocumentProvider along with a JVM-compatible ai.koog.rag.base.files.FileSystemProvider.ReadWrite to handle document operations and vector storage in a structured directory format. It uses a root directory as the base for storing documents and their associated embeddings in separate directories.

Use this class to persistently store and retrieve documents and their vector payloads to and from a file-based system in JVM environments.

- root — The root directory where all documents and vector embeddings will be stored.
## ai.koog.rag.vector.backend.VectorStorageBackend.allDocumentsWithPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/all-documents-with-payload.html`

### :rag:rag-vector/commonMain

```kotlin
abstract fun allDocumentsWithPayload(): Flow<DocumentWithPayload<Document, Vector>>
```

Retrieves a flow of all documents with their vector embeddings.

A flow of DocumentWithPayload items.


Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base`.

## ai.koog.rag.vector.backend.VectorStorageBackend.allDocuments

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/all-documents.html`

### :rag:rag-vector/commonMain

```kotlin
abstract fun allDocuments(): Flow<Document>
```

Retrieves a flow of all documents.

A flow of documents.

## ai.koog.rag.vector.backend.VectorStorageBackend.delete

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/delete.html`

### :rag:rag-vector/commonMain

```kotlin
abstract suspend fun delete(documentId: String): Boolean
```

Deletes the document with the specified ID.

true if the document was successfully deleted, false otherwise.

- documentId — The unique identifier of the document to delete.
## ai.koog.rag.vector.backend.VectorStorageBackend

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/index.html`

### :rag:rag-vector/commonMain

```kotlin
interface VectorStorageBackend<Document>
```

Low-level storage interface for documents and their pre-computed vector embeddings.

Implementations handle only persistence — no embedding logic. The embedding step is handled by ai.koog.rag.vector.storage.EmbeddingStorage which composes an embedder with a VectorStorageBackend.

- Document — The type of the document being stored.
- FileVectorStorageBackend
- InMemoryVectorStorageBackend
## ai.koog.rag.vector.backend.VectorStorageBackend.readWithPayload

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/read-with-payload.html`

### :rag:rag-vector/commonMain

```kotlin
abstract suspend fun readWithPayload(documentId: String): DocumentWithPayload<Document, Vector>?
```

Reads a document along with its vector embedding by document ID.

A DocumentWithPayload containing the document and its vector, or null if not found.

- documentId — The unique identifier of the document to read.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base`.

## ai.koog.rag.vector.backend.VectorStorageBackend.read

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/read.html`

### :rag:rag-vector/commonMain

```kotlin
abstract suspend fun read(documentId: String): Document?
```

Reads a document by its unique identifier.

The document, or null if not found.

- documentId — The unique identifier of the document to read.
## ai.koog.rag.vector.backend.VectorStorageBackend.store

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.backend/-vector-storage-backend/store.html`

### :rag:rag-vector/commonMain

```kotlin
abstract suspend fun store(document: Document, vector: Vector): String
```

Stores a document along with its pre-computed vector embedding.

A unique string identifier for the stored document.

- document — The document to store.
- vector — The pre-computed vector embedding for the document.

Referenced packages: `ai.koog.embeddings.base`.

### :rag:rag-vector/commonMain

```kotlin
abstract suspend fun store(id: String, document: Document, vector: Vector): Boolean
```

Updates a document along with its pre-computed vector embedding under the specified ID. Only updates if a document with the given ID already exists.

true if the document was successfully updated, false if no document with the given id exists.

- id — The unique identifier of the document to update.
- document — The updated document.
- vector — The pre-computed vector embedding for the document.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.DocumentEmbedder.embed

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-document-embedder/embed.html`

### :rag:rag-vector/commonMain

```kotlin
abstract suspend fun embed(document: Document): Vector
```

Converts the provided document into its vector representation.

A vector representing the embedded form of the provided document.

- document — The document to be embedded into a vector representation.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.DocumentEmbedder

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-document-embedder/index.html`

### :rag:rag-vector/commonMain

```kotlin
interface DocumentEmbedder<Document> : Embedder
```

Represents an interface for embedding documents into vector representations. Implementations of this interface should define how specific document types are processed and converted into embeddings for downstream applications.

- Document — The type of the document to be embedded.
- TextDocumentEmbedder

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.JVMTextDocumentEmbedder.JVMTextDocumentEmbedder

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-j-v-m-text-document-embedder/-j-v-m-text-document-embedder.html`

### :rag:rag-vector/jvmMain

```kotlin
constructor(embedder: Embedder)
```

Creates a JVMTextDocumentEmbedder with the specified embedder.

- embedder — The ai.koog.embeddings.base.Embedder used for generating vector embeddings and comparing embeddings.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.JVMTextDocumentEmbedder

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-j-v-m-text-document-embedder/index.html`

### :rag:rag-vector/jvmMain

```kotlin
class JVMTextDocumentEmbedder(embedder: Embedder) : TextDocumentEmbedder<Path, Path>
```

A specialization of TextDocumentEmbedder designed for embedding and processing text documents in JVM-based file systems. It leverages a ai.koog.rag.base.files.JVMDocumentProvider to read content from Path objects and uses an Embedder for generating and comparing vector embeddings of the text content.

This class enables the transformation of text documents into vector representations and provides utilities for measuring the similarity or difference between the embeddings of different documents.

- embedder — The ai.koog.embeddings.base.Embedder used for generating vector embeddings and comparing embeddings.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.TextDocumentEmbedder.TextDocumentEmbedder

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-text-document-embedder/-text-document-embedder.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(documentReader: DocumentProvider<Path, Document>, embedder: Embedder)
```

- Document — The type representing the document to be processed.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base.files`.

## ai.koog.rag.vector.embedder.TextDocumentEmbedder.diff

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-text-document-embedder/diff.html`

### :rag:rag-vector/commonMain

```kotlin
open override fun diff(embedding1: Vector, embedding2: Vector): Double
```

Calculates the difference between two embeddings using the underlying embedder. Lower values indicate more similarity between the embeddings.

A double value representing the difference between the two embeddings.

- embedding1 — The first embedding to compare.
- embedding2 — The second embedding to compare.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.TextDocumentEmbedder.embed

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-text-document-embedder/embed.html`

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun embed(document: Document): Vector
```

Converts the given document into its vector representation.

A vector representation of the document.

- document — The document to be embedded.

Referenced packages: `ai.koog.embeddings.base`.

### :rag:rag-vector/commonMain

```kotlin
open suspend override fun embed(text: String): Vector
```

Embeds the given text into a vector representation.

A vector representation of the provided text.

- text — The text to embed.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.embedder.TextDocumentEmbedder

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.embedder/-text-document-embedder/index.html`

### :rag:rag-vector/commonMain

```kotlin
open class TextDocumentEmbedder<Document, Path>(documentReader: DocumentProvider<Path, Document>, embedder: Embedder) : DocumentEmbedder<Document>
```

A class that provides functionality for embedding text documents and comparing their embeddings.

This class uses a DocumentProvider to extract textual content from a generic document type, and then utilizes an Embedder to convert the text into vector representations (embeddings). The embeddings can be used to analyze or compare the documents.

- Document — The type representing the document to be processed.
- JVMTextDocumentEmbedder

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base.files`.

## ai.koog.rag.vector.storage.FileDocumentEmbeddingStorage.FileDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-file-document-embedding-storage/-file-document-embedding-storage.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(embedder: DocumentEmbedder<Document>, documentProvider: DocumentProvider<Path, Document>, fs: FileSystemProvider.ReadWrite<Path>, root: Path)
```

- embedder — A mechanism responsible for embedding the documents into vector representations.
- documentProvider — Provider for reading/writing documents.
- fs — Platform-specific file system provider for path manipulations.
- root — Root directory where all vector storage will be located.
- Document — The type of the documents being stored.

Referenced packages: `ai.koog.rag.base.files`, `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.FileDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-file-document-embedding-storage/index.html`

### :rag:rag-vector/commonMain

```kotlin
open class FileDocumentEmbeddingStorage<Document, Path>(embedder: DocumentEmbedder<Document>, documentProvider: DocumentProvider<Path, Document>, fs: FileSystemProvider.ReadWrite<Path>, root: Path) : EmbeddingStorage<Document>
```

A file-based VectorStorage implementation.

This class facilitates the storage and retrieval of documents and their corresponding vector embeddings in a file system. It utilizes a FileVectorStorageBackend for managing the document embeddings and extends EmbeddingStorage, inheriting capabilities such as ranking, storing, and deleting documents based on their embeddings.

- embedder — A mechanism responsible for embedding the documents into vector representations.
- documentProvider — Provider for reading/writing documents.
- fs — Platform-specific file system provider for path manipulations.
- root — Root directory where all vector storage will be located.
- Document — The type of the documents being stored.
- TextFileDocumentEmbeddingStorage
- JVMFileDocumentEmbeddingStorage

Referenced packages: `ai.koog.rag.base.files`, `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.InMemoryDocumentEmbeddingStorage.InMemoryDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-in-memory-document-embedding-storage/-in-memory-document-embedding-storage.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(embedder: DocumentEmbedder<Document>)
```

- embedder — A mechanism responsible for embedding the documents into vector representations.
- Document — The type of the documents being stored.

Referenced packages: `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.InMemoryDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-in-memory-document-embedding-storage/index.html`

### :rag:rag-vector/commonMain

```kotlin
open class InMemoryDocumentEmbeddingStorage<Document>(embedder: DocumentEmbedder<Document>) : EmbeddingStorage<Document>
```

An in-memory VectorStorage implementation.

This class facilitates the storage and retrieval of documents and their corresponding vector embeddings entirely in memory. It utilizes an InMemoryVectorStorageBackend for managing the document embeddings and extends EmbeddingStorage, inheriting capabilities such as ranking, storing, and deleting documents based on their embeddings.

- embedder — A mechanism responsible for embedding the documents into vector representations.
- Document — The type of the documents being stored.
- InMemoryTextDocumentEmbeddingStorage

Referenced packages: `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.InMemoryTextDocumentEmbeddingStorage.InMemoryTextDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-in-memory-text-document-embedding-storage/-in-memory-text-document-embedding-storage.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(embedder: Embedder, documentReader: DocumentProvider<Path, Document>)
```

- embedder — The embedder used for generating vectorized representations of text.
- documentReader — The document provider facilitating access to document contents.
- Document — The type representing the document being managed.
- Path — The type representing the path or identifier for locating documents.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base.files`.

## ai.koog.rag.vector.storage.InMemoryTextDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-in-memory-text-document-embedding-storage/index.html`

### :rag:rag-vector/commonMain

```kotlin
class InMemoryTextDocumentEmbeddingStorage<Document, Path>(embedder: Embedder, documentReader: DocumentProvider<Path, Document>) : InMemoryDocumentEmbeddingStorage<Document>
```

Implementation of an in-memory storage solution for text document embeddings.

This class leverages the functionality of an embedder and a document provider to compute embeddings for text documents and store them in memory for efficient retrieval.

- embedder — The embedder used for generating vectorized representations of text.
- documentReader — The document provider facilitating access to document contents.
- Document — The type representing the document being managed.
- Path — The type representing the path or identifier for locating documents.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base.files`.

## ai.koog.rag.vector.storage.JVMFileDocumentEmbeddingStorage.JVMFileDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-j-v-m-file-document-embedding-storage/-j-v-m-file-document-embedding-storage.html`

### :rag:rag-vector/jvmMain

```kotlin
constructor(embedder: DocumentEmbedder<Path>, root: Path)
```

Creates an instance of JVMFileDocumentEmbeddingStorage.

- embedder — The embedder responsible for generating vector representations of file-based documents.
- root — The root directory path used as the base for file-based vector storage.

Referenced packages: `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.JVMFileDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-j-v-m-file-document-embedding-storage/index.html`

### :rag:rag-vector/jvmMain

```kotlin
class JVMFileDocumentEmbeddingStorage(embedder: DocumentEmbedder<Path>, root: Path) : FileDocumentEmbeddingStorage<Path, Path>
```

A file-system-based VectorStorage implementation for managing and embedding documents represented by file paths.

- embedder — The embedder responsible for generating vector representations of file-based documents.
- root — The root directory path used as the base for file-based vector storage.

Referenced packages: `ai.koog.rag.vector.embedder`.

## ai.koog.rag.vector.storage.JVMFileEmbeddingStorage.JVMFileEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-j-v-m-file-embedding-storage/-j-v-m-file-embedding-storage.html`

### :rag:rag-vector/jvmMain

```kotlin
constructor(embedder: Embedder, root: Path)
```

Creates an instance of JVMFileEmbeddingStorage.

- embedder — The embedding implementation used to generate and compare vector embeddings.
- root — The root directory where the document storage system is initialized.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.storage.JVMFileEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-j-v-m-file-embedding-storage/index.html`

### :rag:rag-vector/jvmMain

```kotlin
class JVMFileEmbeddingStorage(embedder: Embedder, root: Path) : TextFileDocumentEmbeddingStorage<Path, Path>
```

A JVM-specific implementation of TextFileDocumentEmbeddingStorage tailored for text document embedding and storage within a file system. This class utilizes a ai.koog.rag.base.files.JVMDocumentProvider to handle document reading and manages embeddings using a provided ai.koog.embeddings.base.Embedder.

- embedder — The embedding implementation used to generate and compare vector embeddings.
- root — The root directory where the document storage system is initialized.

Referenced packages: `ai.koog.embeddings.base`.

## ai.koog.rag.vector.storage.TextFileDocumentEmbeddingStorage.TextFileDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-text-file-document-embedding-storage/-text-file-document-embedding-storage.html`

### :rag:rag-vector/commonMain

```kotlin
constructor(embedder: Embedder, documentProvider: DocumentProvider<Path, Document>, fs: FileSystemProvider.ReadWrite<Path>, root: Path)
```

- embedder — Converts text into vector embeddings and calculates similarity between embeddings.
- documentProvider — Provider for reading/writing documents.
- fs — Platform-specific file system provider for path manipulations.
- root — Root directory where all vector storage will be located.
- Document — The type of document to be stored and processed.

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base.files`.

## ai.koog.rag.vector.storage.TextFileDocumentEmbeddingStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-text-file-document-embedding-storage/index.html`

### :rag:rag-vector/commonMain

```kotlin
open class TextFileDocumentEmbeddingStorage<Document, Path>(embedder: Embedder, documentProvider: DocumentProvider<Path, Document>, fs: FileSystemProvider.ReadWrite<Path>, root: Path) : FileDocumentEmbeddingStorage<Document, Path>
```

A file-based VectorStorage implementation for text documents.

This class specializes in storing and ranking text documents in a file system using embeddings derived from their textual content.

- embedder — Converts text into vector embeddings and calculates similarity between embeddings.
- documentProvider — Provider for reading/writing documents.
- fs — Platform-specific file system provider for path manipulations.
- root — Root directory where all vector storage will be located.
- Document — The type of document to be stored and processed.
- JVMFileEmbeddingStorage

Referenced packages: `ai.koog.embeddings.base`, `ai.koog.rag.base.files`.

## ai.koog.rag.vector.storage.VectorStorage

Module: `rag-vector`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `rag/rag-vector/ai.koog.rag.vector.storage/-vector-storage/index.html`

### :rag:rag-vector/commonMain

```kotlin
interface VectorStorage<Document, in Request : SearchRequest> : WriteStorage<Document> , LookupStorage<Document> , SearchStorage<Document, Request> , DeletionStorage
```

Interface for a vector storage that combines document ingestion and retrieval.

This is the primary user-facing abstraction for working with vector-based document storage. Implementations handle embedding documents into vectors and storing them for similarity-based retrieval.

- Document — The type representing the document being stored.
- Request — The type of search requests accepted by this storage.
- EmbeddingStorage

Referenced packages: `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.
