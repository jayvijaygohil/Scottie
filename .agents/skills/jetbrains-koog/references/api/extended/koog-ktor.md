# koog-ktor

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.ktor.BedrockClientConfig.BedrockClientConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-bedrock-client-config/-bedrock-client-config.html`

### :koog-ktor/jvmMain

```kotlin
constructor()
```

## ai.koog.ktor.BedrockClientConfig.clock

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-bedrock-client-config/clock.html`

### :koog-ktor/jvmMain

```kotlin
var clock: KoogClock
```

Override the clock used for time-based operations.


Referenced packages: `ai.koog.utils.time`.

## ai.koog.ktor.BedrockClientConfig.configure

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-bedrock-client-config/configure.html`

### :koog-ktor/jvmMain

```kotlin
var configure: BedrockRuntimeClient.Config.Builder.() -> Unit
```

Configure the underlying BedrockRuntimeClient from the AWS SDK.

## ai.koog.ktor.BedrockClientConfig

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-bedrock-client-config/index.html`

### :koog-ktor/jvmMain

```kotlin
class BedrockClientConfig
```

Configuration to create a new Bedrock LLM client configured with the specified identity provider and settings.

## ai.koog.ktor.BedrockClientConfig.moderationGuardrailsSettings

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/-bedrock-client-config/moderation-guardrails-settings.html`

### :koog-ktor/jvmMain

```kotlin
var moderationGuardrailsSettings: BedrockGuardrailsSettings?
```

Set moderation guardrails settings for Bedrock.


Referenced packages: `ai.koog.prompt.executor.clients.bedrock`.

## ai.koog.ktor.bedrock

Module: `koog-ktor`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `koog-ktor/ai.koog.ktor/bedrock.html`

### :koog-ktor/jvmMain

```kotlin
fun KoogAgentsConfig.bedrock(apiKey: String, clock: KoogClock = KoogClock.System, moderationGuardrailsSettings: BedrockGuardrailsSettings? = null, configure: BedrockRuntimeClient.Config.Builder.() -> Unit = {})
```

Configures and initializes a Bedrock LLM client with optional configuration.

- apiKey — The API key used for authenticating with the Bedrock API.
- clock — A clock used for time-based operations
- moderationGuardrailsSettings — Optional settings of the AWS bedrock Guardrails (see AWS documentation ) that would be used for the LLMClient.moderate request
- configure — A lambda receiver to customize the OpenAI configuration such as base URL, timeout settings, and paths.

Referenced packages: `ai.koog.prompt.executor.clients.bedrock`, `ai.koog.utils.time`.

### :koog-ktor/jvmMain

```kotlin
fun KoogAgentsConfig.bedrock(clock: KoogClock = KoogClock.System, moderationGuardrailsSettings: BedrockGuardrailsSettings? = null, configure: BedrockRuntimeClient.Config.Builder.() -> Unit)
```

Configures and initializes a Bedrock LLM client with AWS SDK builder

- clock — A clock used for time-based operations
- moderationGuardrailsSettings — Optional settings of the AWS bedrock Guardrails (see AWS documentation ) that would be used for the LLMClient.moderate request
- configure — A lambda receiver to customize the OpenAI configuration such as base URL, timeout settings, and paths.

Referenced packages: `ai.koog.prompt.executor.clients.bedrock`, `ai.koog.utils.time`.
