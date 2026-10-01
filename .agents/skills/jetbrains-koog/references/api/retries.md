# Client retries and backoff

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.prompt.executor.clients.retry.DefaultRetryAfterExtractor.extract

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-default-retry-after-extractor/extract.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun extract(message: String): Duration?
```

Extracts a retry-after duration from the provided error message.

The extracted retry-after duration, or null if no valid duration could be determined.

- message — The error message from which to extract the retry-after duration.
## ai.koog.prompt.executor.clients.retry.DefaultRetryAfterExtractor

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-default-retry-after-extractor/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
object DefaultRetryAfterExtractor : RetryAfterExtractor
```

Default implementation that extracts common retry-after patterns.

## ai.koog.prompt.executor.clients.retry.RetryAfterExtractor.extract

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-after-extractor/extract.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract fun extract(message: String): Duration?
```

Extracts a retry-after duration from the provided error message.

The extracted retry-after duration, or null if no valid duration could be determined.

- message — The error message from which to extract the retry-after duration.
## ai.koog.prompt.executor.clients.retry.RetryAfterExtractor

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-after-extractor/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
fun interface RetryAfterExtractor
```

Extracts retry-after hints from error messages.

- DefaultRetryAfterExtractor
## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion.AGGRESSIVE

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/-a-g-g-r-e-s-s-i-v-e.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@JvmField val AGGRESSIVE: RetryConfig
```

Aggressive configuration - more retries, shorter delays.

## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion.CONSERVATIVE

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/-c-o-n-s-e-r-v-a-t-i-v-e.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@JvmField val CONSERVATIVE: RetryConfig
```

Conservative configuration - fewer retries, longer delays.

## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion.DEFAULT

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/-d-e-f-a-u-l-t.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@JvmField val DEFAULT: RetryConfig
```

The default retry configuration used by clients implementing retry logic.

Suitable for general-purpose use cases where standard retry behavior is required.

## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion.DEFAULT_PATTERNS

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/-d-e-f-a-u-l-t_-p-a-t-t-e-r-n-s.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@JvmField val DEFAULT_PATTERNS: List<RetryablePattern>
```

Default retry patterns that work across all providers.

## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion.DISABLED

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/-d-i-s-a-b-l-e-d.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@JvmField val DISABLED: RetryConfig
```

No retry - effectively disables retry logic.

## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion.PRODUCTION

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/-p-r-o-d-u-c-t-i-o-n.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
@JvmField val PRODUCTION: RetryConfig
```

Production configuration - balanced for production use.

## ai.koog.prompt.executor.clients.retry.RetryConfig.Companion

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-companion/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
object Companion
```

Companion object for providing predefined retry configurations and patterns. Contains default retry logic settings that can be used across different use cases, along with scoped configurations for conservative, aggressive, and production environments.

## ai.koog.prompt.executor.clients.retry.RetryConfig.RetryConfig

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/-retry-config.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(maxAttempts: Int = 3, initialDelay: Duration = 1.seconds, maxDelay: Duration = 30.seconds, backoffMultiplier: Double = 2.0, jitterFactor: Double = 0.1, retryablePatterns: List<RetryablePattern> = DEFAULT_PATTERNS, retryAfterExtractor: RetryAfterExtractor? = DefaultRetryAfterExtractor)
```

## ai.koog.prompt.executor.clients.retry.RetryConfig.backoffMultiplier

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/backoff-multiplier.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val backoffMultiplier: Double
```

## ai.koog.prompt.executor.clients.retry.RetryConfig

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
data class RetryConfig constructor(val maxAttempts: Int = 3, val initialDelay: Duration = 1.seconds, val maxDelay: Duration = 30.seconds, val backoffMultiplier: Double = 2.0, val jitterFactor: Double = 0.1, val retryablePatterns: List<RetryablePattern> = DEFAULT_PATTERNS, val retryAfterExtractor: RetryAfterExtractor? = DefaultRetryAfterExtractor)
```

Configuration for retry behavior in LLM client operations.

## ai.koog.prompt.executor.clients.retry.RetryConfig.initialDelay

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/initial-delay.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val initialDelay: Duration
```

## ai.koog.prompt.executor.clients.retry.RetryConfig.jitterFactor

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/jitter-factor.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val jitterFactor: Double
```

## ai.koog.prompt.executor.clients.retry.RetryConfig.maxAttempts

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/max-attempts.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val maxAttempts: Int
```

## ai.koog.prompt.executor.clients.retry.RetryConfig.maxDelay

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/max-delay.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val maxDelay: Duration
```

## ai.koog.prompt.executor.clients.retry.RetryConfig.retryAfterExtractor

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/retry-after-extractor.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val retryAfterExtractor: RetryAfterExtractor?
```

## ai.koog.prompt.executor.clients.retry.RetryConfig.retryablePatterns

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config/retryable-patterns.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val retryablePatterns: List<RetryablePattern>
```

## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.RetryConfigBuilder

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/-retry-config-builder.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
constructor()
```

## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.backoffMultiplier

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/backoff-multiplier.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun backoffMultiplier(backoffMultiplier: Double): RetryConfigBuilder
```

Sets the backoff multiplier for subsequent retry attempts.

the updated builder instance.

- backoffMultiplier — the multiplier to apply to the delay for each subsequent retry.
## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.build

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/build.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun build(): RetryConfig
```

Builds a new RetryConfig instance with the configured values. Any unset values will use RetryConfig defaults.

a new RetryConfig instance.

## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/index.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
class RetryConfigBuilder
```

Creates a new RetryConfigBuilder for constructing RetryConfig instances.

## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.initialDelay

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/initial-delay.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun initialDelay(initialDelay: Duration): RetryConfigBuilder
```

the updated builder instance.

- initialDelay — the initial delay duration.
### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun initialDelay(initialDelay: Duration): RetryConfigBuilder
```

Sets the initial delay before the first retry attempt using kotlin.time.Duration.

the updated builder instance.

- initialDelay — the initial delay duration.
## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.jitterFactor

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/jitter-factor.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun jitterFactor(jitterFactor: Double): RetryConfigBuilder
```

Sets the jitter factor to introduce randomness in delay calculations.

the updated builder instance.

- jitterFactor — the factor for randomness in delays (0.0 to 1.0).
## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.maxAttempts

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/max-attempts.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun maxAttempts(maxAttempts: Int): RetryConfigBuilder
```

Sets the maximum number of attempts (including initial).

the updated builder instance.

- maxAttempts — the maximum number of attempts.
## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.maxDelay

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/max-delay.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun maxDelay(maxDelay: Duration): RetryConfigBuilder
```

the updated builder instance.

- maxDelay — the maximum delay duration.
### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun maxDelay(maxDelay: Duration): RetryConfigBuilder
```

Sets the maximum delay allowed between retry attempts using kotlin.time.Duration.

the updated builder instance.

- maxDelay — the maximum delay duration.
## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.retryAfterExtractor

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/retry-after-extractor.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun retryAfterExtractor(retryAfterExtractor: RetryAfterExtractor?): RetryConfigBuilder
```

Sets the retry-after extractor for extracting retry-after hints from error messages.

the updated builder instance.

- retryAfterExtractor — the extractor, or null to disable.
## ai.koog.prompt.executor.clients.retry.RetryConfigBuilder.retryablePatterns

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retry-config-builder/retryable-patterns.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun retryablePatterns(retryablePatterns: List<RetryablePattern>): RetryConfigBuilder
```

Sets the retryable patterns for identifying retryable errors.

the updated builder instance.

- retryablePatterns — the list of patterns.
## ai.koog.prompt.executor.clients.retry.RetryablePattern.Custom.Custom

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-custom/-custom.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(matcher: (String) -> Boolean)
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Custom

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-custom/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
class Custom(matcher: (String) -> Boolean) : RetryablePattern
```

Custom matching logic.

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Custom.matches

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-custom/matches.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun matches(message: String): Boolean
```

Evaluates whether the given message matches the criteria defined by the implementing class.

true if the message matches the criteria, otherwise false.

- message — The message to evaluate against the matching criteria.
## ai.koog.prompt.executor.clients.retry.RetryablePattern.Keyword.Keyword

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-keyword/-keyword.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(keyword: String)
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Keyword

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-keyword/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
data class Keyword(val keyword: String) : RetryablePattern
```

Matches keywords in error messages.

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Keyword.keyword

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-keyword/keyword.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val keyword: String
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Keyword.matches

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-keyword/matches.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun matches(message: String): Boolean
```

Evaluates whether the given message matches the criteria defined by the implementing class.

true if the message matches the criteria, otherwise false.

- message — The message to evaluate against the matching criteria.
## ai.koog.prompt.executor.clients.retry.RetryablePattern.Regex.Regex

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-regex/-regex.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(pattern: Regex)
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Regex

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-regex/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
data class Regex(val pattern: Regex) : RetryablePattern
```

Matches using a custom regex.

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Regex.matches

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-regex/matches.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun matches(message: String): Boolean
```

Evaluates whether the given message matches the criteria defined by the implementing class.

true if the message matches the criteria, otherwise false.

- message — The message to evaluate against the matching criteria.
## ai.koog.prompt.executor.clients.retry.RetryablePattern.Regex.pattern

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-regex/pattern.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val pattern: Regex
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Status.Status

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-status/-status.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(code: Int)
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Status.code

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-status/code.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
val code: Int
```

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Status

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-status/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
data class Status(val code: Int) : RetryablePattern
```

Matches HTTP status codes in error messages.

## ai.koog.prompt.executor.clients.retry.RetryablePattern.Status.matches

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/-status/matches.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun matches(message: String): Boolean
```

Evaluates whether the given message matches the criteria defined by the implementing class.

true if the message matches the criteria, otherwise false.

- message — The message to evaluate against the matching criteria.
## ai.koog.prompt.executor.clients.retry.RetryablePattern

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
sealed class RetryablePattern
```

Pattern for identifying retryable errors.

- Status
- Keyword
- Regex
- Custom
## ai.koog.prompt.executor.clients.retry.RetryablePattern.matches

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retryable-pattern/matches.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
abstract fun matches(message: String): Boolean
```

Evaluates whether the given message matches the criteria defined by the implementing class.

true if the message matches the criteria, otherwise false.

- message — The message to evaluate against the matching criteria.
## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.RetryingLLMClient

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/-retrying-l-l-m-client.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
constructor(delegate: LLMClient, config: RetryConfig = RetryConfig())
```

- delegate — The LLMClient to wrap with retry logic
- config — Configuration for retry behavior

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.close

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/close.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun close()
```

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.embed

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/embed.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend override fun embed(text: String, model: LLModel): List<Double>
```

Embeds the given text, retrying on transient failures according to config.

A list of floating-point values representing the embedding vector.

- text — The text to embed.
- model — The model to use for embedding.

Referenced packages: `ai.koog.prompt.llm`.

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend override fun embed(inputs: List<String>, model: LLModel): List<List<Double>>
```

Embeds the given inputs, retrying on transient failures according to config.

A list of embedding vectors, one per input string.

- inputs — The list of texts to embed.
- model — The model to use for embedding.

Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.executeMultipleChoices

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/execute-multiple-choices.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend override fun executeMultipleChoices(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): LLMChoice
```

Executes a prompt and returns a list of LLM choices.

List of LLM choices

- prompt — The prompt to execute
- tools — Optional list of tools that can be used by the LLM
- model — The LLM model to use

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.executeStreaming

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/execute-streaming.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun executeStreaming(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor>): Flow<StreamFrame>
```

Executes a prompt and returns a streaming flow of response chunks.

Flow of response chunks

- prompt — The prompt to execute
- model — The LLM model to use
- tools — Optional list of tools that can be used by the LLM

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.streaming`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.execute

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/execute.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend override fun execute(prompt: Prompt, model: LLModel, tools: List<ToolDescriptor> = emptyList()): Message.Assistant
```

Executes a prompt and returns a list of response messages.

List of response messages

- prompt — The prompt to execute
- model — The LLM model to use
- tools — Optional list of tools that can be used by the LLM

Referenced packages: `ai.koog.agents.core.tools`, `ai.koog.prompt`, `ai.koog.prompt.llm`, `ai.koog.prompt.message`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.getBasicJsonSchemaGenerator

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/get-basic-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun getBasicJsonSchemaGenerator(): BasicJsonSchemaGenerator
```

Basic JSON schema generator supported by the LLMClient. Return BasicJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.getStandardJsonSchemaGenerator

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/get-standard-json-schema-generator.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun getStandardJsonSchemaGenerator(): StandardJsonSchemaGenerator
```

Standard JSON schema generator supported by the LLMClient. Return StandardJsonSchemaGenerator by default.


Referenced packages: `ai.koog.prompt.structure.json.generator`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/index.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
class RetryingLLMClient constructor(delegate: LLMClient, config: RetryConfig = RetryConfig()) : LLMClient
```

A decorator that adds retry capabilities to any LLMClient implementation.

This is a pure decorator - it has no knowledge of specific providers or implementations. It simply wraps any LLMClient and retries operations based on configurable policies.

Example usage:

- delegate — The LLMClient to wrap with retry logic
- config — Configuration for retry behavior

Referenced packages: `ai.koog.prompt.executor.clients`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.llmProvider

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/llm-provider.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open override fun llmProvider(): LLMProvider
```

Retrieves the configured instance of the LLMProvider in use.

This method returns the LLMProvider instance associated with the client, facilitating identification or interaction with the specific provider of large language models (e.g., Google, OpenAI, Meta, etc.).

the current LLMProvider associated with this client.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.models

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/models.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend override fun models(): List<LLModel>
```

Retrieves a list of ids of available Large Language Models (LLMs) supported by the client.

A list of model ids instances representing the available LLMs.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.retry.RetryingLLMClient.moderate

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/-retrying-l-l-m-client/moderate.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
open suspend override fun moderate(prompt: Prompt, model: LLModel): ModerationResult
```

Analyzes the provided prompt for violations of content policies or other moderation criteria.

The result of the moderation analysis, encapsulated in a ModerationResult object.

- prompt — The input prompt to be analyzed for moderation.
- model — The language model to be used for conducting the moderation analysis.

Referenced packages: `ai.koog.prompt`, `ai.koog.prompt.dsl`, `ai.koog.prompt.llm`.

## ai.koog.prompt.executor.clients.retry.builder

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/builder.html`

### :prompt:prompt-executor:prompt-executor-clients/jvmMain

```kotlin
fun RetryConfig.Companion.builder(): RetryConfigBuilder
```

Creates a new RetryConfigBuilder for constructing RetryConfig instances.

## ai.koog.prompt.executor.clients.retry.toRetryingClient

Module: `prompt-executor-clients`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-clients/ai.koog.prompt.executor.clients.retry/to-retrying-client.html`

### :prompt:prompt-executor:prompt-executor-clients/commonMain

```kotlin
fun LLMClient.toRetryingClient(retryConfig: RetryConfig = RetryConfig.DEFAULT): RetryingLLMClient
```

Converts an instance of LLMClient into a retrying client with customizable retry behavior.

A new instance of RetryingLLMClient that adds retry logic to the provided client.

- retryConfig — Configuration for retry behavior. Defaults to RetryConfig.DEFAULT.

Referenced packages: `ai.koog.prompt.executor.clients`.
