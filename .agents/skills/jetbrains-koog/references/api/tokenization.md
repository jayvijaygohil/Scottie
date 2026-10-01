# Token counting and tokenization

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer.Feature.createInitialConfig

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/-feature/create-initial-config.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
open override fun createInitialConfig(agentConfig: AIAgentConfig): MessageTokenizerConfig
```


Referenced packages: `ai.koog.agents.core.agent.config`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer.Feature

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/-feature/index.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
object Feature : AIAgentGraphFeature<MessageTokenizerConfig, MessageTokenizer> , AIAgentFunctionalFeature<MessageTokenizerConfig, MessageTokenizer> , AIAgentPlannerFeature<MessageTokenizerConfig, MessageTokenizer>
```

Companion object implementing agent feature, handling MessageTokenizer creation and installation.


Referenced packages: `ai.koog.agents.core.feature`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer.Feature.install

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/-feature/install.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
open override fun install(config: MessageTokenizerConfig, pipeline: AIAgentGraphPipeline): MessageTokenizer
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
open override fun install(config: MessageTokenizerConfig, pipeline: AIAgentFunctionalPipeline): MessageTokenizer
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
open override fun install(config: MessageTokenizerConfig, pipeline: AIAgentPlannerPipeline): MessageTokenizer
```


Referenced packages: `ai.koog.agents.core.feature.pipeline`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer.Feature.key

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/-feature/key.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
open override val key: AIAgentStorageKey<MessageTokenizer>
```


Referenced packages: `ai.koog.agents.core.agent.entity`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer.MessageTokenizer

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/-message-tokenizer.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
constructor(promptTokenizer: PromptTokenizer)
```


Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/index.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
class MessageTokenizer(val promptTokenizer: PromptTokenizer)
```

The MessageTokenizer feature is responsible for handling tokenization of messages using a provided Tokenizer implementation.


Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizer.promptTokenizer

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer/prompt-tokenizer.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
val promptTokenizer: PromptTokenizer
```


Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizerConfig.MessageTokenizerConfig

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer-config/-message-tokenizer-config.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.tokenizer.feature.MessageTokenizerConfig.enableCaching

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer-config/enable-caching.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
var enableCaching: Boolean
```

Indicates whether caching is enabled for tokenization processes.

When set to true, a caching tokenizer will be used to optimize performance by caching tokenization results. If false, an on-demand tokenizer will be utilized, which performs tokenization as needed without caching.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizerConfig

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer-config/index.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
class MessageTokenizerConfig : FeatureConfig
```

Configuration class for message tokenization settings.


Referenced packages: `ai.koog.agents.core.feature.config`.

## ai.koog.agents.features.tokenizer.feature.MessageTokenizerConfig.tokenizer

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/-message-tokenizer-config/tokenizer.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
var tokenizer: Tokenizer
```

The tokenizer property determines the strategy used for tokenizing text and estimating token counts within a message-processing feature.


Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.agents.features.tokenizer.feature.tokenizer

Module: `agents-features-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-tokenizer/ai.koog.agents.features.tokenizer.feature/tokenizer.html`

### :agents:agents-features:agents-features-tokenizer/commonMain

```kotlin
fun AIAgentContext.tokenizer(): PromptTokenizer
```

Provides access to the PromptTokenizer instance provided by the MessageTokenizer.Feature and used within the AI agent's context.


Referenced packages: `ai.koog.agents.core.agent.context`, `ai.koog.prompt.tokenizer`.

## ai.koog.prompt.tokenizer.CachingTokenizer.CachingTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-caching-tokenizer/-caching-tokenizer.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
constructor(tokenizer: Tokenizer)
```

Creates an instance of CachingTokenizer with a provided Tokenizer instance that performs the actual token counting.

## ai.koog.prompt.tokenizer.CachingTokenizer.clearCache

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-caching-tokenizer/clear-cache.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
fun clearCache()
```

Clears all cached token counts from the internal cache.

This method is useful when the state of the cached data becomes invalid or needs resetting. After calling this, any subsequent token count calculations will be recomputed rather than retrieved from the cache.

## ai.koog.prompt.tokenizer.CachingTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-caching-tokenizer/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
class CachingTokenizer(tokenizer: Tokenizer) : PromptTokenizer
```

A caching implementation of the PromptTokenizer interface that optimizes token counting by storing previously computed token counts for messages. This reduces redundant computations when the same message is processed multiple times.

## ai.koog.prompt.tokenizer.CachingTokenizer.tokenCountFor

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-caching-tokenizer/token-count-for.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun tokenCountFor(message: Message): Int
```

Retrieves the number of tokens contained in the content of the given message. This method utilizes caching to improve performance, storing previously computed token counts and reusing them for identical messages.

The number of tokens in the content of the message

- message — The message whose content's token count is to be retrieved

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun tokenCountFor(prompt: Prompt): Int
```

Calculates the total number of tokens spent on the given prompt by summing the token usage of all messages associated with the prompt.

The total number of tokens spent across all messages in the provided prompt.

- prompt — The prompt containing the list of messages whose token usage will be calculated.

Referenced packages: `ai.koog.prompt`.

## ai.koog.prompt.tokenizer.NoTokenizer.NoTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-no-tokenizer/-no-tokenizer.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.tokenizer.NoTokenizer.countTokens

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-no-tokenizer/count-tokens.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun countTokens(text: String): Int
```

Always returns 0, regardless of the input text.

Always returns 0

- text — The text to tokenize (ignored)
## ai.koog.prompt.tokenizer.NoTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-no-tokenizer/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
class NoTokenizer : Tokenizer
```

A tokenizer implementation that always returns 0.

This is useful when token counting is not needed or when you want to save computational resources by skipping token counting.

## ai.koog.prompt.tokenizer.OnDemandTokenizer.OnDemandTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-on-demand-tokenizer/-on-demand-tokenizer.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
constructor(tokenizer: Tokenizer)
```

## ai.koog.prompt.tokenizer.OnDemandTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-on-demand-tokenizer/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
class OnDemandTokenizer(tokenizer: Tokenizer) : PromptTokenizer
```

An implementation of the PromptTokenizer interface that delegates token counting to an instance of the Tokenizer interface. The class provides methods to estimate the token count for individual messages and for the entirety of a prompt.

This is useful in contexts where token-based costs or limitations are significant, such as when interacting with large language models (LLMs).

## ai.koog.prompt.tokenizer.OnDemandTokenizer.tokenCountFor

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-on-demand-tokenizer/token-count-for.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun tokenCountFor(message: Message): Int
```

Computes the number of tokens in a given message.

The estimated number of tokens in the message content.

- message — The message for which the token count needs to be calculated. The content of the message is analyzed to estimate the token count.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun tokenCountFor(prompt: Prompt): Int
```

Calculates the total number of tokens spent for the given prompt based on its messages.

The total number of tokens across all messages in the prompt.

- prompt — The Prompt instance containing the list of messages for which the total token count will be calculated.

Referenced packages: `ai.koog.prompt`.

## ai.koog.prompt.tokenizer.PromptTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-prompt-tokenizer/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
interface PromptTokenizer
```

An interface that provides utilities for tokenizing and calculating token usage in messages and prompts.

- OnDemandTokenizer
- CachingTokenizer
## ai.koog.prompt.tokenizer.PromptTokenizer.tokenCountFor

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-prompt-tokenizer/token-count-for.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
abstract fun tokenCountFor(message: Message): Int
```

Calculates the number of tokens required for a given message.

The number of tokens required to encode the message.

- message — The message for which the token count should be determined.

Referenced packages: `ai.koog.prompt.message`.

### :prompt:prompt-tokenizer/commonMain

```kotlin
abstract fun tokenCountFor(prompt: Prompt): Int
```

Calculates the total number of tokens spent in a given prompt.

The total number of tokens spent as an integer.

- prompt — The prompt for which the total tokens spent need to be calculated.

Referenced packages: `ai.koog.prompt`.

## ai.koog.prompt.tokenizer.SimpleRegexBasedTokenizer.SimpleRegexBasedTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-simple-regex-based-tokenizer/-simple-regex-based-tokenizer.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
constructor()
```

## ai.koog.prompt.tokenizer.SimpleRegexBasedTokenizer.countTokens

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-simple-regex-based-tokenizer/count-tokens.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun countTokens(text: String): Int
```

Counts tokens by splitting on whitespace and common punctuation.

The implementation adds a small overhead factor (1.1x) to account for special tokens and tokenization differences in actual LLM tokenizers.

The estimated number of tokens in the text

- text — The text to tokenize
## ai.koog.prompt.tokenizer.SimpleRegexBasedTokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-simple-regex-based-tokenizer/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
class SimpleRegexBasedTokenizer : Tokenizer
```

A simple regex-based tokenizer that splits text on whitespace and common punctuation.

This tokenizer provides a reasonable approximation of token counts for most LLMs, though it's not as accurate as model-specific tokenizers. It's efficient and doesn't require any external dependencies.

Note: Ollama does not provide tokens in responses, so this client-side estimation is necessary for token counting.

## ai.koog.prompt.tokenizer.Tokenizer.countTokens

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-tokenizer/count-tokens.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
abstract fun countTokens(text: String): Int
```

Counts the number of tokens in the given text.

The estimated number of tokens in the text

- text — The text to tokenize and count
## ai.koog.prompt.tokenizer.Tokenizer

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer/-tokenizer/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
interface Tokenizer
```

Interface for tokenizing text and counting tokens.

Tokenizers are used to estimate the number of tokens in a text string. This is particularly useful for LLMs that don't provide token counts in their responses, requiring client-side estimation, or if you want to have more fine-grained tokens estimation for each request message in the prompt.

Different implementations can provide varying levels of accuracy and performance. You can implement your own tokenizer and easily integrate it with Koog.

- NoTokenizer
- SimpleRegexBasedTokenizer
- TiktokenEncoder
## ai.koog.prompt.tokenizer.tiktoken.ByteArrayKey.ByteArrayKey

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-byte-array-key/-byte-array-key.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
constructor(bytes: ByteArray)
```

Creates a ByteArrayKey instance from the given byte array.

- bytes — The byte array that forms the basis of the key.
## ai.koog.prompt.tokenizer.tiktoken.ByteArrayKey

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-byte-array-key/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
class ByteArrayKey(bytes: ByteArray)
```

Represents a key based on a byte array. This class is primarily designed to be used as a key in collections such as Maps due to the proper implementation of equals and hashCode methods based on the byte array's content.

- bytes — The byte array that forms the basis of the key.
## ai.koog.prompt.tokenizer.tiktoken.ByteArrayKey.range

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-byte-array-key/range.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
fun range(start: Int, end: Int): ByteArrayKey
```

Creates a new ByteArrayKey object containing a subrange of bytes from the current ByteArrayKey.

A new ByteArrayKey object with the specified range of bytes.

- start — The starting index (inclusive) of the range to extract.
- end — The ending index (exclusive) of the range to extract.
## ai.koog.prompt.tokenizer.tiktoken.ByteArrayKey.size

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-byte-array-key/size.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
val size: Int
```

Represents the size of the byte array encapsulated by the ByteArrayKey instance.

This property provides the number of bytes contained in the underlying byte array.

It is calculated by retrieving the size of the ByteArray instance.

## ai.koog.prompt.tokenizer.tiktoken.TiktokenEncoder.TiktokenEncoder

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-tiktoken-encoder/-tiktoken-encoder.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
constructor(vocabulary: Map<ByteArrayKey, Int>, pattern: Regex, unkTokenId: Int)
```

Initializes the TiktokenEncoder with the specified vocabulary, regex pattern for matching tokens, and a token ID for unknown tokens.

- vocabulary — A mapping of ByteArrayKey to token ID that represents the token encoding vocabulary.
- pattern — A regular expression used to match text patterns for initial token matching.
- unkTokenId — The token ID used for unknown tokens not present in the vocabulary.
## ai.koog.prompt.tokenizer.tiktoken.TiktokenEncoder.countTokens

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-tiktoken-encoder/count-tokens.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
open override fun countTokens(text: String): Int
```

Counts the number of tokens in the given text.

The method utilizes the encodeAsIds function to tokenize the input string and determines the number of resulting tokens.

The total number of tokens in the input text.

- text — The input text to be tokenized and counted.
## ai.koog.prompt.tokenizer.tiktoken.TiktokenEncoder

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/-tiktoken-encoder/index.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
open class TiktokenEncoder(vocabulary: Map<ByteArrayKey, Int>, pattern: Regex, unkTokenId: Int) : Tokenizer
```

A tokenizer implementation that uses a token encoding vocabulary and a regex pattern to tokenize text into a series of token IDs. The tokenization process utilizes byte pair encoding (BPE) for segments of text not directly found in the vocabulary.

This implementation is based on the reference Rust implementation from https://github.com/openai/tiktoken/blob/main/src/lib.rs.

- vocabulary — A mapping of ByteArrayKey to token ID that represents the token encoding vocabulary.
- pattern — A regular expression used to match text patterns for initial token matching.
- unkTokenId — The token ID used for unknown tokens not present in the vocabulary.

Referenced packages: `ai.koog.prompt.tokenizer`.

## ai.koog.prompt.tokenizer.tiktoken.toByteArrayKey

Module: `prompt-tokenizer`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-tokenizer/ai.koog.prompt.tokenizer.tiktoken/to-byte-array-key.html`

### :prompt:prompt-tokenizer/commonMain

```kotlin
fun String.toByteArrayKey(): ByteArrayKey
```

Converts the current string into a ByteArrayKey by encoding the string into a UTF-8 byte array.

A ByteArrayKey containing the UTF-8 bytes of the string.
