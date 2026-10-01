# prompt / prompt-executor / prompt-executor-model

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.prompt.executor.llms.ExperimentalRoutingApi

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.llms/-experimental-routing-api/index.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
annotation class ExperimentalRoutingApi
```

Marks an API as part of the experimental routing and load balancing layer for LLM clients.

APIs annotated with ExperimentalRoutingApi are not considered stable. Routing strategies, client selection interfaces, and related executor behaviour may change, be redesigned, or be removed in future releases without prior notice or a deprecation cycle.

To use an annotated API, opt in explicitly at the call site or on the enclosing declaration:

## ai.koog.prompt.executor.model.PromptExecutorOperation.entries

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/entries.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
val entries: EnumEntries<PromptExecutorOperation>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.prompt.executor.model.PromptExecutorOperation.valueOf

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/value-of.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
fun valueOf(value: String): PromptExecutorOperation
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.prompt.executor.model.PromptExecutorOperation.values

Module: `prompt-executor-model`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `prompt/prompt-executor/prompt-executor-model/ai.koog.prompt.executor.model/-prompt-executor-operation/values.html`

### :prompt:prompt-executor:prompt-executor-model/commonMain

```kotlin
fun values(): Array<PromptExecutorOperation>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.
