# Long-term memory ingestion and retrieval

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.longtermmemory.feature.FailurePolicy.FAIL_FAST

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-failure-policy/-f-a-i-l_-f-a-s-t/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
FAIL_FAST
```

Re-throw the underlying error wrapped into a dedicated LongTermMemory exception (either LongTermMemoryRetrievalException or LongTermMemoryIngestionException).

For retrieval, this stops the LLM call before it is executed, which is usually safer than answering without the required memory context.

For ingestion, this aborts the agent run instead of silently dropping memory records, which is useful for durable audit/logging use cases where losing memory is worse than failing the run.

## ai.koog.agents.longtermmemory.feature.FailurePolicy.LOG_AND_CONTINUE

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-failure-policy/-l-o-g_-a-n-d_-c-o-n-t-i-n-u-e/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
LOG_AND_CONTINUE
```

Log the error and continue. For retrieval this means proceeding to the LLM call with no augmentation (treated as "no relevant memories"). For ingestion this means the records are dropped.

## ai.koog.agents.longtermmemory.feature.FailurePolicy.entries

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-failure-policy/entries.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val entries: EnumEntries<FailurePolicy>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.longtermmemory.feature.FailurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-failure-policy/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
enum FailurePolicy : Enum<FailurePolicy>
```

Policy controlling how failures from the underlying memory storage are handled by the LongTermMemory feature.

Failures caused by kotlin.coroutines.cancellation.CancellationException are always propagated regardless of the selected policy.

## ai.koog.agents.longtermmemory.feature.FailurePolicy.valueOf

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-failure-policy/value-of.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun valueOf(value: String): FailurePolicy
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.longtermmemory.feature.FailurePolicy.values

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-failure-policy/values.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun values(): Array<FailurePolicy>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Config.Config

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-config/-config.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Config

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-config/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class Config : FeatureConfig
```

Configuration for the LongTermMemory feature.

This class allows configuring:

Retrieval settings for RAG (prompt augmentation with context from the repository)

Ingestion settings for persisting messages to the repository

Both retrievalSettings and ingestionSettings are null by default, meaning neither retrieval nor ingestion is active unless explicitly configured.


Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Config.ingestionSettings

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-config/ingestion-settings.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var ingestionSettings: IngestionSettings?
```

Settings for ingesting (persisting) messages into the memory record repository. When null (default), no messages are persisted.

Can be set directly or configured via the ingestion DSL block.


Referenced packages: `ai.koog.agents.longtermmemory.ingestion`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Config.ingestion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-config/ingestion.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun ingestion(block: LongTermMemory.IngestionSettingsBuilder.() -> Unit)
```

Configure ingestion settings via DSL block.

Example usage:

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun ingestion(settings: IngestionSettings)
```

Set pre-built ingestion settings directly.


Referenced packages: `ai.koog.agents.longtermmemory.ingestion`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Config.retrievalSettings

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-config/retrieval-settings.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var retrievalSettings: RetrievalSettings?
```

Settings for retrieval-augmented generation (RAG). When null (default), no context augmentation from the memory record repository is performed.

Can be set directly or configured via the retrieval DSL block.


Referenced packages: `ai.koog.agents.longtermmemory.retrieval`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Config.retrieval

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-config/retrieval.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun retrieval(block: LongTermMemory.RetrievalSettingsBuilder.() -> Unit)
```

Configure retrieval (RAG) settings via DSL block.

Example usage:

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun retrieval(settings: RetrievalSettings)
```

Set pre-built retrieval settings directly.


Referenced packages: `ai.koog.agents.longtermmemory.retrieval`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Feature.createInitialConfig

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): LongTermMemory.Config
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Feature

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-feature/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
object Feature : AIAgentGraphFeature<LongTermMemory.Config, LongTermMemory> , AIAgentFunctionalFeature<LongTermMemory.Config, LongTermMemory> , AIAgentPlannerFeature<LongTermMemory.Config, LongTermMemory>
```

Companion object implementing agent feature, handling LongTermMemory creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Feature.install

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-feature/install.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun install(config: LongTermMemory.Config, pipeline: AIAgentGraphPipeline): LongTermMemory
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun install(config: LongTermMemory.Config, pipeline: AIAgentFunctionalPipeline): LongTermMemory
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun install(config: LongTermMemory.Config, pipeline: AIAgentPlannerPipeline): LongTermMemory
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.Feature.key

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-feature/key.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override val key: AIAgentStorageKey<LongTermMemory>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.IngestionSettingsBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/-ingestion-settings-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.build

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/build.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun build(): IngestionSettings
```

IngestionSettings builder.


Referenced packages: `ai.koog.agents.longtermmemory.ingestion`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.documentExtractor

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/document-extractor.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var documentExtractor: DocumentExtractor
```

The extractor that defines how to transform messages into memory records.

Pre-built ingesters are available:

ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor - Filters messages by role

Example usage:


Referenced packages: `ai.koog.agents.longtermmemory.ingestion.extraction`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.enableAutomaticIngestion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/enable-automatic-ingestion.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var enableAutomaticIngestion: Boolean
```

When true (default), ingestion happens automatically on agent completion. When false, the storage is still accessible for manual use inside graph strategy nodes.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.failurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/failure-policy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var failurePolicy: FailurePolicy
```

How to react to ingestion failures (e.g. storage outage).

Defaults to FailurePolicy.LOG_AND_CONTINUE so transient ingestion errors do not abort the agent run. Switch to FailurePolicy.FAIL_FAST for durable audit/logging use cases where losing memory records is worse than failing the run.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class IngestionSettingsBuilder
```

Builder for IngestionSettings used in the Config.ingestion DSL block.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.namespace

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/namespace.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var namespace: String?
```

Namespace (table/collection name) for a request.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.storage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var storage: WriteStorage<TextDocument>?
```

The ingestion storage where memory records will be persisted. Must be set explicitly in the ingestion { } block.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.withDocumentExtractor

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/with-document-extractor.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withDocumentExtractor(documentExtractor: DocumentExtractor): LongTermMemory.IngestionSettingsBuilder
```

Fluent setter for documentExtractor.


Referenced packages: `ai.koog.agents.longtermmemory.ingestion.extraction`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.withEnableAutomaticIngestion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/with-enable-automatic-ingestion.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withEnableAutomaticIngestion(enable: Boolean): LongTermMemory.IngestionSettingsBuilder
```

Fluent setter for enableAutomaticIngestion.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.withFailurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/with-failure-policy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withFailurePolicy(failurePolicy: FailurePolicy): LongTermMemory.IngestionSettingsBuilder
```

Fluent setter for failurePolicy.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.withNamespace

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/with-namespace.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withNamespace(namespace: String): LongTermMemory.IngestionSettingsBuilder
```

Fluent setter for namespace.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.IngestionSettingsBuilder.withStorage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-ingestion-settings-builder/with-storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withStorage(storage: WriteStorage<TextDocument>): LongTermMemory.IngestionSettingsBuilder
```

Fluent setter for storage.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.LongTermMemory

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-long-term-memory.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(retrievalSettings: RetrievalSettings? = null, ingestionSettings: IngestionSettings? = null)
```


Referenced packages: `ai.koog.agents.longtermmemory.ingestion`, `ai.koog.agents.longtermmemory.retrieval`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.RetrievalSettingsBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/-retrieval-settings-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.build

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/build.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun build(): RetrievalSettings
```

RetrievalSettings builder.


Referenced packages: `ai.koog.agents.longtermmemory.retrieval`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.enableAutomaticRetrieval

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/enable-automatic-retrieval.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var enableAutomaticRetrieval: Boolean
```

When true (default), retrieval and prompt augmentation happen automatically before each LLM call. When false, the storage and strategy are still accessible for manual use inside graph strategy nodes.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.failurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/failure-policy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var failurePolicy: FailurePolicy
```

How to react to retrieval failures (e.g. storage outage, invalid search request).

Defaults to FailurePolicy.FAIL_FAST so a retrieval error stops the LLM call instead of silently producing an answer without the required memory context. Switch to FailurePolicy.LOG_AND_CONTINUE to fall back to a non-augmented LLM call.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class RetrievalSettingsBuilder
```

Builder for RetrievalSettings used in the Config.retrieval DSL block.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.namespace

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/namespace.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var namespace: String?
```

Namespace (table/collection name) for a request.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.promptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/prompt-augmenter.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var promptAugmenter: PromptAugmenter
```

The augmenter that defines how retrieved context is inserted into the prompt. Defaults to SystemPromptAugmenter.

- SystemPromptAugmenter
- UserPromptAugmenter

Referenced packages: `ai.koog.agents.longtermmemory.retrieval.augmentation`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.searchQueryProvider

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/search-query-provider.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var searchQueryProvider: SearchQueryProvider
```

The extractor that defines how to derive the search query from the prompt. Defaults to LastUserMessageQueryProvider.

- SearchQueryProvider
- LastUserMessageQueryProvider

Referenced packages: `ai.koog.agents.longtermmemory.retrieval.search`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.searchStrategy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/search-strategy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var searchStrategy: SearchStrategy
```

The search strategy that defines how to search the retrieval storage.

- SearchStrategy

Referenced packages: `ai.koog.agents.longtermmemory.retrieval.search`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.storage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var storage: SearchStorage<TextDocument, SearchRequest>?
```

The retrieval storage to search for relevant memory records. Must be set explicitly in the retrieval { } block.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withEnableAutomaticRetrieval

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-enable-automatic-retrieval.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withEnableAutomaticRetrieval(enable: Boolean): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for enableAutomaticRetrieval.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withFailurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-failure-policy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withFailurePolicy(failurePolicy: FailurePolicy): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for failurePolicy.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withNamespace

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-namespace.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withNamespace(namespace: String): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for namespace.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withPromptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-prompt-augmenter.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withPromptAugmenter(augmenter: PromptAugmenter): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for promptAugmenter.


Referenced packages: `ai.koog.agents.longtermmemory.retrieval.augmentation`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withSearchQueryProvider

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-search-query-provider.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withSearchQueryProvider(searchQueryProvider: SearchQueryProvider): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for searchQueryProvider.


Referenced packages: `ai.koog.agents.longtermmemory.retrieval.search`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withSearchStrategy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-search-strategy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withSearchStrategy(searchStrategy: SearchStrategy): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for searchStrategy.


Referenced packages: `ai.koog.agents.longtermmemory.retrieval.search`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.RetrievalSettingsBuilder.withStorage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/-retrieval-settings-builder/with-storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withStorage(storage: SearchStorage<TextDocument, SearchRequest>): LongTermMemory.RetrievalSettingsBuilder
```

Fluent setter for storage.


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class LongTermMemory(retrievalSettings: RetrievalSettings? = null, ingestionSettings: IngestionSettings? = null)
```

Memory feature that incorporates persistent storage of memory records (documents) in vector databases.

This feature provides two main capabilities that can be configured independently:

Retrieval (RAG): Retrieves relevant context from the memory record repository using a configured search request builder and inserts it into the prompt before sending to the LLM. Configured via retrievalSettings. When null, no retrieval/augmentation is performed.

Ingestion: Saves messages to the memory record repository for future retrieval. Configured via ingestionSettings. When null, no messages are persisted.

- RetrievalSettings
- IngestionSettings

Referenced packages: `ai.koog.agents.longtermmemory.ingestion`, `ai.koog.agents.longtermmemory.retrieval`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.ingestionStorage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/ingestion-storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val ingestionStorage: WriteStorage<TextDocument>?
```

Property getter for WriteStorage for usage inside strategy nodes


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`.

## ai.koog.agents.longtermmemory.feature.LongTermMemory.retrievalStorage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/-long-term-memory/retrieval-storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val retrievalStorage: SearchStorage<TextDocument, SearchRequest>?
```

Property getter for SearchStorage for usage inside strategy nodes


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.feature.longTermMemory

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/long-term-memory.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun AIAgentContext.longTermMemory(): LongTermMemory
```

Returns the LongTermMemory feature instance installed on this agent.

- withLongTermMemory
- IllegalStateException — if the LongTermMemory feature is not installed.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.longtermmemory.feature.withLongTermMemory

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.feature/with-long-term-memory.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
suspend fun <T> AIAgentContext.withLongTermMemory(action: suspend LongTermMemory.() -> T): T
```

Executes the given action in the context of the LongTermMemory feature installed on this agent.

This is the primary way to access long-term memory storages from within strategy nodes. Inside the action block, you can use LongTermMemory.retrievalStorage and LongTermMemory.ingestionStorage to search and add memory records.

Example usage:

the result of the action block.

- action — the block to execute with LongTermMemory as the receiver.
- longTermMemory
- IllegalStateException — if the LongTermMemory feature is not installed.

Referenced packages: `ai.koog.agents.core.agent.context`.

## ai.koog.agents.longtermmemory.ingestion.IngestionSettings.IngestionSettings

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/-ingestion-settings.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(storage: WriteStorage<TextDocument>, documentExtractor: DocumentExtractor = MessagePassingDocumentExtractor(), enableAutomaticIngestion: Boolean = true, namespace: String? = null, failurePolicy: FailurePolicy = FailurePolicy.LOG_AND_CONTINUE)
```

- storage — The ingestion storage where memory records will be persisted.
- documentExtractor — The extractor that defines how to transform messages into memory records. Pre-built ingesters are available:ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor - Filters messages by role Custom ingesters can be provided as lambdas via the ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor SAM interface.
- enableAutomaticIngestion — When true (default), ingestion happens automatically on agent completion. When false, the storage is still accessible for manual use inside graph strategy nodes via ai.koog.agents.longtermmemory.feature.withLongTermMemory.
- namespace — Namespace (table/collection name) for a request
- failurePolicy — How to react to failures from storage when persisting records. Defaults to FailurePolicy.LOG_AND_CONTINUE so transient ingestion errors do not abort the agent run. Set to FailurePolicy.FAIL_FAST for durable audit/logging use cases where losing memory records is worse than failing the run.

Referenced packages: `ai.koog.agents.longtermmemory.feature`, `ai.koog.agents.longtermmemory.ingestion.extraction`, `ai.koog.rag.base`, `ai.koog.rag.base.storage`.

## ai.koog.agents.longtermmemory.ingestion.IngestionSettings.documentExtractor

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/document-extractor.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val documentExtractor: DocumentExtractor
```

- documentExtractor — The extractor that defines how to transform messages into memory records. Pre-built ingesters are available:ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor - Filters messages by role Custom ingesters can be provided as lambdas via the ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor SAM interface.

Referenced packages: `ai.koog.agents.longtermmemory.ingestion.extraction`.

## ai.koog.agents.longtermmemory.ingestion.IngestionSettings.enableAutomaticIngestion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/enable-automatic-ingestion.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val enableAutomaticIngestion: Boolean
```

- enableAutomaticIngestion — When true (default), ingestion happens automatically on agent completion. When false, the storage is still accessible for manual use inside graph strategy nodes via ai.koog.agents.longtermmemory.feature.withLongTermMemory.
## ai.koog.agents.longtermmemory.ingestion.IngestionSettings.failurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/failure-policy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val failurePolicy: FailurePolicy
```

- failurePolicy — How to react to failures from storage when persisting records. Defaults to FailurePolicy.LOG_AND_CONTINUE so transient ingestion errors do not abort the agent run. Set to FailurePolicy.FAIL_FAST for durable audit/logging use cases where losing memory records is worse than failing the run.

Referenced packages: `ai.koog.agents.longtermmemory.feature`.

## ai.koog.agents.longtermmemory.ingestion.IngestionSettings

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
data class IngestionSettings(val storage: WriteStorage<TextDocument>, val documentExtractor: DocumentExtractor = MessagePassingDocumentExtractor(), val enableAutomaticIngestion: Boolean = true, val namespace: String? = null, val failurePolicy: FailurePolicy = FailurePolicy.LOG_AND_CONTINUE)
```

Settings controlling how messages are persisted (ingested) into the memory repository.

Ingestion happens once at agent completion: the final accumulated session prompt/history is passed to the configured documentExtractor as a single batch.

- storage — The ingestion storage where memory records will be persisted.
- documentExtractor — The extractor that defines how to transform messages into memory records. Pre-built ingesters are available:ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor - Filters messages by role Custom ingesters can be provided as lambdas via the ai.koog.agents.longtermmemory.ingestion.extraction.DocumentExtractor SAM interface.
- enableAutomaticIngestion — When true (default), ingestion happens automatically on agent completion. When false, the storage is still accessible for manual use inside graph strategy nodes via ai.koog.agents.longtermmemory.feature.withLongTermMemory.
- namespace — Namespace (table/collection name) for a request
- failurePolicy — How to react to failures from storage when persisting records. Defaults to FailurePolicy.LOG_AND_CONTINUE so transient ingestion errors do not abort the agent run. Set to FailurePolicy.FAIL_FAST for durable audit/logging use cases where losing memory records is worse than failing the run.

Referenced packages: `ai.koog.agents.longtermmemory.feature`, `ai.koog.agents.longtermmemory.ingestion.extraction`, `ai.koog.rag.base`, `ai.koog.rag.base.storage`.

## ai.koog.agents.longtermmemory.ingestion.IngestionSettings.namespace

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/namespace.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val namespace: String?
```

- namespace — Namespace (table/collection name) for a request
## ai.koog.agents.longtermmemory.ingestion.IngestionSettings.storage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion/-ingestion-settings/storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val storage: WriteStorage<TextDocument>
```

- storage — The ingestion storage where memory records will be persisted.

Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.Builder.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/-builder/-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.Builder.build

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/-builder/build.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun build(): MessagePassingDocumentExtractor
```

Builds a MessagePassingDocumentExtractor from the current settings.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.Builder.extractRoles

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/-builder/extract-roles.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var extractRoles: Set<Message.Role>
```

The set of message roles to extract. Defaults to User and Assistant.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class Builder
```

Builder for MessagePassingDocumentExtractor.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.Builder.withExtractRoles

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/-builder/with-extract-roles.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withExtractRoles(roles: Set<Message.Role>): MessagePassingDocumentExtractor.Builder
```

Fluent setter for extractRoles.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.MessagePassingDocumentExtractor

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/-message-passing-document-extractor.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(messageRolesToExtract: Set<Message.Role> = setOf(Message.Role.User, Message.Role.Assistant))
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.extract

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/extract.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open suspend override fun extract(messages: List<Message>): List<TextDocument>
```

Transforms a list of messages into a list of TextDocuments for storage.

List of TextDocuments to be stored

- messages — The messages to transform into TextDocuments

Referenced packages: `ai.koog.prompt.message`, `ai.koog.rag.base`.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class MessagePassingDocumentExtractor(val messageRolesToExtract: Set<Message.Role> = setOf(Message.Role.User, Message.Role.Assistant)) : DocumentExtractor
```

Default extractor that filters messages by role.

This extractor filters messages to only include those with roles in messageRolesToExtract, then converts each message's content into TextDocuments.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.longtermmemory.ingestion.extraction.MessagePassingDocumentExtractor.messageRolesToExtract

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.ingestion.extraction/-message-passing-document-extractor/message-roles-to-extract.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val messageRolesToExtract: Set<Message.Role>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.longtermmemory.model.MemoryRecord.MemoryRecord

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.model/-memory-record/-memory-record.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(content: String, id: String? = null, metadata: Map<String, Any> = emptyMap())
```

## ai.koog.agents.longtermmemory.model.MemoryRecord.content

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.model/-memory-record/content.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override val content: String
```

The main textual content to be embedded and searched

## ai.koog.agents.longtermmemory.model.MemoryRecord.id

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.model/-memory-record/id.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override val id: String?
```

Unique identifier for the record

## ai.koog.agents.longtermmemory.model.MemoryRecord

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.model/-memory-record/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
data class MemoryRecord(val content: String, val id: String? = null, val metadata: Map<String, Any> = emptyMap()) : TextDocument
```

Represents a memory record that can be stored in a vector database.


Referenced packages: `ai.koog.rag.base`.

## ai.koog.agents.longtermmemory.model.MemoryRecord.metadata

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.model/-memory-record/metadata.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override val metadata: Map<String, Any>
```

Flexible key-value metadata for filtering and custom fields

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.RetrievalSettings

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/-retrieval-settings.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(storage: SearchStorage<TextDocument, SearchRequest>, searchQueryProvider: SearchQueryProvider = LastUserMessageQueryProvider(), searchStrategy: SearchStrategy = SimilaritySearchStrategy(), promptAugmenter: PromptAugmenter = SystemPromptAugmenter(), enableAutomaticRetrieval: Boolean = true, namespace: String? = null, failurePolicy: FailurePolicy = FailurePolicy.FAIL_FAST)
```

- storage — The retrieval storage to search for relevant memory records.
- searchQueryProvider — The provider that defines how to derive the search query from the prompt. Defaults to ai.koog.agents.longtermmemory.retrieval.search.LastUserMessageQueryProvider, which uses the last user message content.
- searchStrategy — The strategy that defines how to search the retrieval store.
- promptAugmenter — The augmenter that defines how retrieved context is inserted into the prompt.
- enableAutomaticRetrieval — When true (default), retrieval and prompt augmentation happen automatically before each LLM call. When false, the storage and strategy are still accessible for manual use inside graph strategy nodes via ai.koog.agents.longtermmemory.feature.withLongTermMemory.
- namespace — Namespace (table/collection name) for a request.
- failurePolicy — How to react to failures from storage or searchStrategy. Defaults to FailurePolicy.FAIL_FAST so that retrieval errors stop the LLM call instead of silently producing an answer without the required memory context.

Referenced packages: `ai.koog.agents.longtermmemory.feature`, `ai.koog.agents.longtermmemory.retrieval.augmentation`, `ai.koog.agents.longtermmemory.retrieval.search`, `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.enableAutomaticRetrieval

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/enable-automatic-retrieval.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val enableAutomaticRetrieval: Boolean
```

- enableAutomaticRetrieval — When true (default), retrieval and prompt augmentation happen automatically before each LLM call. When false, the storage and strategy are still accessible for manual use inside graph strategy nodes via ai.koog.agents.longtermmemory.feature.withLongTermMemory.
## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.failurePolicy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/failure-policy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val failurePolicy: FailurePolicy
```

- failurePolicy — How to react to failures from storage or searchStrategy. Defaults to FailurePolicy.FAIL_FAST so that retrieval errors stop the LLM call instead of silently producing an answer without the required memory context.

Referenced packages: `ai.koog.agents.longtermmemory.feature`.

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
data class RetrievalSettings(val storage: SearchStorage<TextDocument, SearchRequest>, val searchQueryProvider: SearchQueryProvider = LastUserMessageQueryProvider(), val searchStrategy: SearchStrategy = SimilaritySearchStrategy(), val promptAugmenter: PromptAugmenter = SystemPromptAugmenter(), val enableAutomaticRetrieval: Boolean = true, val namespace: String? = null, val failurePolicy: FailurePolicy = FailurePolicy.FAIL_FAST)
```

Settings controlling how memory records are retrieved and injected into prompts (RAG).

- storage — The retrieval storage to search for relevant memory records.
- searchQueryProvider — The provider that defines how to derive the search query from the prompt. Defaults to ai.koog.agents.longtermmemory.retrieval.search.LastUserMessageQueryProvider, which uses the last user message content.
- searchStrategy — The strategy that defines how to search the retrieval store.
- promptAugmenter — The augmenter that defines how retrieved context is inserted into the prompt.
- enableAutomaticRetrieval — When true (default), retrieval and prompt augmentation happen automatically before each LLM call. When false, the storage and strategy are still accessible for manual use inside graph strategy nodes via ai.koog.agents.longtermmemory.feature.withLongTermMemory.
- namespace — Namespace (table/collection name) for a request.
- failurePolicy — How to react to failures from storage or searchStrategy. Defaults to FailurePolicy.FAIL_FAST so that retrieval errors stop the LLM call instead of silently producing an answer without the required memory context.

Referenced packages: `ai.koog.agents.longtermmemory.feature`, `ai.koog.agents.longtermmemory.retrieval.augmentation`, `ai.koog.agents.longtermmemory.retrieval.search`, `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.namespace

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/namespace.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val namespace: String?
```

- namespace — Namespace (table/collection name) for a request.
## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.promptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/prompt-augmenter.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val promptAugmenter: PromptAugmenter
```

- promptAugmenter — The augmenter that defines how retrieved context is inserted into the prompt.

Referenced packages: `ai.koog.agents.longtermmemory.retrieval.augmentation`.

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.searchQueryProvider

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/search-query-provider.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val searchQueryProvider: SearchQueryProvider
```

- searchQueryProvider — The provider that defines how to derive the search query from the prompt. Defaults to ai.koog.agents.longtermmemory.retrieval.search.LastUserMessageQueryProvider, which uses the last user message content.

Referenced packages: `ai.koog.agents.longtermmemory.retrieval.search`.

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.searchStrategy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/search-strategy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val searchStrategy: SearchStrategy
```

- searchStrategy — The strategy that defines how to search the retrieval store.

Referenced packages: `ai.koog.agents.longtermmemory.retrieval.search`.

## ai.koog.agents.longtermmemory.retrieval.RetrievalSettings.storage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval/-retrieval-settings/storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val storage: SearchStorage<TextDocument, SearchRequest>
```

- storage — The retrieval storage to search for relevant memory records.

Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder.build

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/build.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun build(): SystemPromptAugmenter
```

Builds a SystemPromptAugmenter from the current settings.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder.contextPrefix

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/context-prefix.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var contextPrefix: String
```

The prefix to add before relevant context.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class Builder
```

Builder for SystemPromptAugmenter.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder.template

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/template.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var template: String
```

The template for the system message.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder.withContextPrefix

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/with-context-prefix.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withContextPrefix(contextPrefix: String): SystemPromptAugmenter.Builder
```

Fluent setter for contextPrefix.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Builder.withTemplate

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-builder/with-template.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withTemplate(template: String): SystemPromptAugmenter.Builder
```

Fluent setter for template.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Companion.DEFAULT_SYSTEM_PROMPT_TEMPLATE

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-companion/-d-e-f-a-u-l-t_-s-y-s-t-e-m_-p-r-o-m-p-t_-t-e-m-p-l-a-t-e.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val DEFAULT_SYSTEM_PROMPT_TEMPLATE: String
```

Default template for the system message. Use PromptAugmenter.RELEVANT_CONTEXT_PLACEHOLDER placeholder.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.Companion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-companion/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
object Companion
```

Companion object with default templates.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.SystemPromptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/-system-prompt-augmenter.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(template: String = DEFAULT_SYSTEM_PROMPT_TEMPLATE, contextPrefix: String = PromptAugmenter.DEFAULT_CONTEXT_PREFIX)
```

- template — The template for the system message. Use PromptAugmenter.RELEVANT_CONTEXT_PLACEHOLDER placeholder.
- contextPrefix — The prefix to add before relevant context.
## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter.augment

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/augment.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun augment(originalPrompt: Prompt, relevantContext: List<SearchResult<TextDocument>>): Prompt
```

Augments the given prompt with relevant context.

A new Prompt with the context inserted, or the original prompt if no augmentation is needed.

- originalPrompt — The original prompt to augment.
- relevantContext — The list of search results containing relevant context.

Referenced packages: `ai.koog.prompt`, `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.augmentation.SystemPromptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-system-prompt-augmenter/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class SystemPromptAugmenter(template: String = DEFAULT_SYSTEM_PROMPT_TEMPLATE, contextPrefix: String = PromptAugmenter.DEFAULT_CONTEXT_PREFIX) : PromptAugmenter
```

A PromptAugmenter that injects retrieved context into the first Message.System of the prompt.

The retrieved context is rendered through template and added as an additional MessagePart.Text appended to the existing parts of the first system message. The original system message is replaced with a copy that:

preserves its Message.metaInfo and Message.id,

preserves all existing parts (text, attachments, etc.),

gains an extra MessagePart.Text entry at the end with formatted context.

If the prompt contains no Message.System, or the formatted context is blank, or the relevant context list is empty, the original prompt is returned unchanged.

- template — The template for the system message. Use PromptAugmenter.RELEVANT_CONTEXT_PLACEHOLDER placeholder.
- contextPrefix — The prefix to add before relevant context.
- PromptAugmenter
## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder.build

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/build.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun build(): UserPromptAugmenter
```

Builds a UserPromptAugmenter from the current settings.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder.contextPrefix

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/context-prefix.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var contextPrefix: String
```

The prefix to add before relevant context.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class Builder
```

Builder for UserPromptAugmenter.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder.template

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/template.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var template: String
```

The template for user context insertion.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder.withContextPrefix

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/with-context-prefix.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withContextPrefix(contextPrefix: String): UserPromptAugmenter.Builder
```

Fluent setter for contextPrefix.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Builder.withTemplate

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-builder/with-template.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withTemplate(template: String): UserPromptAugmenter.Builder
```

Fluent setter for template.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Companion.DEFAULT_USER_PROMPT_TEMPLATE

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-companion/-d-e-f-a-u-l-t_-u-s-e-r_-p-r-o-m-p-t_-t-e-m-p-l-a-t-e.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val DEFAULT_USER_PROMPT_TEMPLATE: String
```

Default template for user context insertion. Use PromptAugmenter.RELEVANT_CONTEXT_PLACEHOLDER placeholder.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.Companion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-companion/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
object Companion
```

Companion object with default templates.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.UserPromptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/-user-prompt-augmenter.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(template: String = DEFAULT_USER_PROMPT_TEMPLATE, contextPrefix: String = PromptAugmenter.DEFAULT_CONTEXT_PREFIX)
```

- template — The template for user context insertion. Use PromptAugmenter.RELEVANT_CONTEXT_PLACEHOLDER placeholder.
- contextPrefix — The prefix to add before relevant context.
## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter.augment

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/augment.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun augment(originalPrompt: Prompt, relevantContext: List<SearchResult<TextDocument>>): Prompt
```

Augments the given prompt with relevant context.

A new Prompt with the context inserted, or the original prompt if no augmentation is needed.

- originalPrompt — The original prompt to augment.
- relevantContext — The list of search results containing relevant context.

Referenced packages: `ai.koog.prompt`, `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.augmentation.UserPromptAugmenter

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.augmentation/-user-prompt-augmenter/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class UserPromptAugmenter(template: String = DEFAULT_USER_PROMPT_TEMPLATE, contextPrefix: String = PromptAugmenter.DEFAULT_CONTEXT_PREFIX) : PromptAugmenter
```

A PromptAugmenter that injects retrieved context into the last Message.User of the prompt.

The retrieved context is rendered through template and added as an additional MessagePart.Text appended to the existing parts of the last user message. The original user message is replaced with a copy that:

preserves its Message.metaInfo and Message.id,

preserves all existing parts (text, attachments, tool results, etc.),

gains one extra MessagePart.Text at the end carrying the formatted context.

If the prompt contains no Message.User, or the formatted context is blank, or the relevant context list is empty, the original prompt is returned unchanged.

- template — The template for user context insertion. Use PromptAugmenter.RELEVANT_CONTEXT_PLACEHOLDER placeholder.
- contextPrefix — The prefix to add before relevant context.
- PromptAugmenter
## ai.koog.agents.longtermmemory.retrieval.search.LastUserMessageQueryProvider.LastUserMessageQueryProvider

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-last-user-message-query-provider/-last-user-message-query-provider.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.retrieval.search.LastUserMessageQueryProvider

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-last-user-message-query-provider/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class LastUserMessageQueryProvider : SearchQueryProvider
```

Default SearchQueryProvider implementation that extracts the content of the last user message from the prompt.

## ai.koog.agents.longtermmemory.retrieval.search.LastUserMessageQueryProvider.provide

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-last-user-message-query-provider/provide.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun provide(prompt: Prompt): String?
```

Extracts a search query string from the given prompt.

the extracted query string, or null if no query could be extracted.

- prompt — the prompt to extract the query from.

Referenced packages: `ai.koog.prompt`.

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategy.Companion.builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy/-companion/builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun builder(): SearchStrategyBuilder
```

Returns a builder that lets you choose a default SearchStrategy implementation.

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategy.Companion

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy/-companion/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
object Companion
```

Companion object with a builder method.

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategy.create

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy/create.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
abstract fun create(query: String): SearchRequest
```

Maps a query string into a SearchRequest for retrieval.

The search request to be executed

- query — The user's query string (typically the last user message content)

Referenced packages: `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.search.SearchStrategy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-search-strategy/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun interface SearchStrategy
```

Search strategy for creating search requests during prompt augmentation.

This is a functional interface (SAM) that defines how a user query string should be transformed into a SearchRequest for retrieval.

SimilaritySearchStrategy is the default implementation. It uses vector embeddings for semantic search and works with all supported vector backends.

Pre-built implementations are available for common search types:

SimilaritySearchStrategy - Vector similarity search (semantic search)

Using pre-built strategies (Kotlin):

- SimilaritySearchStrategy
## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/-builder.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor()
```

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.build

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/build.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun build(): SimilaritySearchStrategy
```

Builds a SimilaritySearchStrategy from the current settings.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.filterExpression

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/filter-expression.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var filterExpression: String?
```

Optional metadata filter expression for pre-filtering.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class Builder
```

Builder for SimilaritySearchStrategy.

- SimilaritySearchStrategy
## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.similarityThreshold

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/similarity-threshold.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var similarityThreshold: Double
```

Minimum similarity score (0.0 to 1.0).

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.topK

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/top-k.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
var topK: Int
```

Maximum number of results to return.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.withFilterExpression

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/with-filter-expression.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withFilterExpression(filterExpression: String?): SimilaritySearchStrategy.Builder
```

Fluent setter for filterExpression.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.withSimilarityThreshold

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/with-similarity-threshold.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withSimilarityThreshold(similarityThreshold: Double): SimilaritySearchStrategy.Builder
```

Fluent setter for similarityThreshold.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.Builder.withTopK

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-builder/with-top-k.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
fun withTopK(topK: Int): SimilaritySearchStrategy.Builder
```

Fluent setter for topK.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.SimilaritySearchStrategy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/-similarity-search-strategy.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(topK: Int = 10, similarityThreshold: Double = 0.0, filterExpression: String? = null)
```

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.create

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/create.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open override fun create(query: String): SimilaritySearchRequest
```

Maps a query string into a SearchRequest for retrieval.

The search request to be executed

- query — The user's query string (typically the last user message content)

Referenced packages: `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.filterExpression

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/filter-expression.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val filterExpression: String?
```

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
class SimilaritySearchStrategy(val topK: Int = 10, val similarityThreshold: Double = 0.0, val filterExpression: String? = null) : SearchStrategy
```

Similarity search mode using vector embeddings for semantic search.

This mode converts the query to a vector embedding and finds records with similar embeddings in the vector database.

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.similarityThreshold

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/similarity-threshold.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val similarityThreshold: Double
```

## ai.koog.agents.longtermmemory.retrieval.search.SimilaritySearchStrategy.topK

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.retrieval.search/-similarity-search-strategy/top-k.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
val topK: Int
```

## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.InMemoryRecordStorage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/-in-memory-record-storage.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
constructor(defaultNamespace: String = "default")
```

- defaultNamespace — The default namespace to use when none is specified in method calls. Defaults to "default".
## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.add

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/add.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open suspend override fun add(documents: List<TextDocument>, namespace: String?): List<String>
```


Referenced packages: `ai.koog.rag.base`.

## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.delete

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/delete.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open suspend override fun delete(ids: List<String>, namespace: String?): List<String>
```

## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.get

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/get.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open suspend override fun get(ids: List<String>, namespace: String?): List<TextDocument>
```


Referenced packages: `ai.koog.rag.base`.

## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/index.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open class InMemoryRecordStorage(defaultNamespace: String = "default") : SearchStorage<TextDocument, SearchRequest> , WriteStorage<TextDocument> , LookupStorage<TextDocument> , DeletionStorage
```

In-memory implementation of SearchStorage, WriteStorage, LookupStorage, and DeletionStorage that stores records in a map.

This implementation is useful for testing, development, and scenarios where persistence is not required. All data is stored in memory and will be lost when the application stops.

Data is not persisted and will be lost on application restart

ai.koog.rag.base.storage.search.KeywordSearchRequest is implemented as a simple case-insensitive substring match.

ai.koog.rag.base.storage.search.SimilaritySearchRequest is implemented as a Jaccard coefficient over case-insensitive word sets; no vector embeddings are used.

Filter expressions are ignored

- defaultNamespace — The default namespace to use when none is specified in method calls. Defaults to "default".

Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.search

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/search.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open suspend override fun search(request: SearchRequest, namespace: String?): List<SearchResult<TextDocument>>
```


Referenced packages: `ai.koog.rag.base`, `ai.koog.rag.base.storage.search`.

## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.size

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/size.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
suspend fun size(namespace: String? = null): Int
```

Returns the number of records in the repository for the specified namespace.

- namespace — Optional namespace to count records for. If null, counts the default namespace.
## ai.koog.agents.longtermmemory.storage.InMemoryRecordStorage.update

Module: `agents-features-longterm-memory`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-longterm-memory/ai.koog.agents.longtermmemory.storage/-in-memory-record-storage/update.html`

### :agents:agents-features:agents-features-longterm-memory/commonMain

```kotlin
open suspend override fun update(documents: Map<String, TextDocument>, namespace: String?): List<String>
```


Referenced packages: `ai.koog.rag.base`.
