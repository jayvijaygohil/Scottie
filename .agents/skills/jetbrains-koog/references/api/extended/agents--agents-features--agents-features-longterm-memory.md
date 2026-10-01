# agents / agents-features / agents-features-longterm-memory

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.longtermmemory.feature.LongTermMemoryIngestionException.LongTermMemoryIngestionException

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory-ingestion-exception/-long-term-memory-ingestion-exception.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(message: String, cause: Throwable)
```

## ai.koog.agents.longtermmemory.feature.LongTermMemoryIngestionException

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory-ingestion-exception/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class LongTermMemoryIngestionException(message: String, cause: Throwable) : Exception
```

Thrown when ingestion into the LongTermMemory storage fails and the configured FailurePolicy is FailurePolicy.FAIL_FAST.

## ai.koog.agents.longtermmemory.feature.LongTermMemoryRetrievalException.LongTermMemoryRetrievalException

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory-retrieval-exception/-long-term-memory-retrieval-exception.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(message: String, cause: Throwable)
```

## ai.koog.agents.longtermmemory.feature.LongTermMemoryRetrievalException

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory-retrieval-exception/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class LongTermMemoryRetrievalException(message: String, cause: Throwable) : Exception
```

Thrown when retrieval from the LongTermMemory storage fails and the configured FailurePolicy is FailurePolicy.FAIL_FAST.

## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor.Companion.builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor/-companion/builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun builder(): DocumentExtractorBuilder
```

Returns a builder that lets you choose a default DocumentExtractor implementation.

## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor.Companion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor/-companion/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
object Companion
```

Companion object with a builder method.

## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor.extract

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor/extract.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
abstract suspend fun extract(messages: List<Message>): List<TextDocument>
```

Transforms a list of messages into a list of TextDocuments for storage.

List of TextDocuments to be stored

- messages — The messages to transform into TextDocuments

Referenced packages: `ai.koog.prompt.message`, `ai.koog.rag.base`.

## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun interface DocumentExtractor
```

Extractor of memory records during message ingestion.

This is a functional interface (SAM) that defines how a list of messages should be transformed into a list of TextDocuments for storage. It provides flexibility in how messages are filtered, transformed, and converted into TextDocuments while maintaining type safety.

Pre-built implementations are available for common ingestion patterns:

MessagePassingDocumentExtractor - Filters messages by role

Using pre-built extractors (Kotlin):

Custom implementation as lambda (Kotlin):

- MessagePassingDocumentExtractor
## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractorBuilder.DocumentExtractorBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor-builder/-document-extractor-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractorBuilder.filtering

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor-builder/filtering.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun filtering(): MessagePassingDocumentExtractor.Builder
```

Select the MessagePassingDocumentExtractor implementation. Returns its MessagePassingDocumentExtractor.Builder for further configuration.

## ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractorBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-document-extractor-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class DocumentExtractorBuilder
```

Intermediate builder that lets callers select a DocumentExtractor implementation.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.Companion.DEFAULT_CONTEXT_PREFIX

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/-companion/-d-e-f-a-u-l-t_-c-o-n-t-e-x-t_-p-r-e-f-i-x.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
const val DEFAULT_CONTEXT_PREFIX: String
```

The prefix to add before relevant context.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.Companion.RELEVANT_CONTEXT_PLACEHOLDER

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/-companion/-r-e-l-e-v-a-n-t_-c-o-n-t-e-x-t_-p-l-a-c-e-h-o-l-d-e-r.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
const val RELEVANT_CONTEXT_PLACEHOLDER: String
```

Placeholder in prompt templates for insertion of relevant context.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.Companion.builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/-companion/builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun builder(): PromptAugmenterBuilder
```

Returns a builder that lets you choose a default PromptAugmenter implementation.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.Companion.formatContext

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/-companion/format-context.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun formatContext(relevantContext: List<SearchResult<TextDocument>>, contextPrefix: String = DEFAULT_CONTEXT_PREFIX): String
```

Formats a list of search results into a numbered text block with the given prefix.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.Companion.formatTemplate

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/-companion/format-template.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun formatTemplate(template: String, relevantContextText: String): String
```

Formats the template by replacing placeholders with actual content.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.Companion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/-companion/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
object Companion
```

Companion object with constants, static methods, and builder entry point.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter.augment

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/augment.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
abstract fun augment(originalPrompt: Prompt, relevantContext: List<SearchResult<TextDocument>>): Prompt
```

Augments the given prompt with relevant context.

A new Prompt with the context inserted, or the original prompt if no augmentation is needed.

- originalPrompt — The original prompt to augment.
- relevantContext — The list of search results containing relevant context.

Referenced packages: `ai.koog.prompt`, `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun interface PromptAugmenter
```

Interface for augmenting prompts with relevant context retrieved from memory.

Implementations define how retrieved context is inserted into the prompt. Two built-in implementations are provided:

SystemPromptAugmenter — inserts context as a system message

UserPromptAugmenter — inserts context as a user message

Can also be implemented as a lambda thanks to the fun interface declaration:

- SystemPromptAugmenter
- UserPromptAugmenter
- LongTermMemory
- SystemPromptAugmenter
- UserPromptAugmenter
## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenterBuilder.PromptAugmenterBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter-builder/-prompt-augmenter-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenterBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class PromptAugmenterBuilder
```

Intermediate builder that lets callers select a PromptAugmenter implementation.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenterBuilder.system

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter-builder/system.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun system(): SystemPromptAugmenter.Builder
```

Select the SystemPromptAugmenter implementation. Returns its SystemPromptAugmenter.Builder for further configuration.

## ai.koog.agents.longtermmemory.retrieval.augmentation.PromptAugmenterBuilder.user

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-prompt-augmenter-builder/user.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun user(): UserPromptAugmenter.Builder
```

Select the UserPromptAugmenter implementation. Returns its UserPromptAugmenter.Builder for further configuration.

## ai.koog.agents.longtermmemory.retrieval.search.SearchQueryProvider

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-query-provider/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun interface SearchQueryProvider
```

Extracts a search query string from a Prompt to be used for memory retrieval.

Implementations define how the search query is derived from the prompt messages. For example, the default LastUserMessageQueryProvider uses the content of the last user message.

- LastUserMessageQueryProvider
- LastUserMessageQueryProvider
## ai.koog.agents.longtermmemory.retrieval.search.SearchQueryProvider.provide

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-query-provider/provide.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
abstract fun provide(prompt: Prompt): String?
```

Extracts a search query string from the given prompt.

the extracted query string, or null if no query could be extracted.

- prompt — the prompt to extract the query from.

Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategyBuilder.SearchStrategyBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy-builder/-search-strategy-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategyBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class SearchStrategyBuilder
```

Intermediate builder that lets callers select a SearchStrategy implementation.

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategyBuilder.similarity

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy-builder/similarity.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun similarity(): SimilaritySearchStrategy.Builder
```

Select the SimilaritySearchStrategy implementation. Returns its SimilaritySearchStrategy.Builder for further configuration.
