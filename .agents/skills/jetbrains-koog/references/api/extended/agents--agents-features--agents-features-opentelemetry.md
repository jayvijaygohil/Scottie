# agents / agents-features / agents-features-opentelemetry

Additional Kotlin contracts from the supplied Dokka build. Read [API coverage](../../api-index.md) before use.

## ai.koog.agents.features.opentelemetry.attribute.Attribute.concatKey

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-attribute/concat-key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open fun String.concatKey(other: String): String
```

Joins two attribute-key segments with a . separator.

- other — Segment to append after the receiver.
## ai.koog.agents.features.opentelemetry.attribute.Attribute

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-attribute/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
interface Attribute
```

A key/value pair attached to a GenAIAgentSpan or an event ai.koog.agents.features.opentelemetry.event.GenAIAgentEvent.

- Error
- Server
- CustomAttribute
- GenAIAttribute
- Koog
- Mcp
- Network
## ai.koog.agents.features.opentelemetry.attribute.Attribute.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-attribute/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.Attribute.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-attribute/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val value: Any
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error.Type.Type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/-type/-type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(type: String)
```

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error.Type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Type(val type: String) : CommonAttributes.Error
```

error.type attribute.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error.Type.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/-type/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error.Type.type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/-type/type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val type: String
```

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error.Type.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/-type/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Error : Attribute
```

error attribute namespace.

- Type
## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Error.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-error/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Address.Address

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-address/-address.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(address: String)
```

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Address.address

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-address/address.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val address: String
```

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Address

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-address/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Address(val address: String) : CommonAttributes.Server
```

server.address attribute.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Address.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-address/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Address.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-address/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Port.Port

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-port/-port.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(port: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Port

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-port/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Port(val port: Int) : CommonAttributes.Server
```

server.port attribute.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Port.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-port/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Port.port

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-port/port.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val port: Int
```

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.Port.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/-port/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Server : Attribute
```

server attribute namespace.

- Address
- Port
## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes.Server.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/-server/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.CommonAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-common-attributes/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object CommonAttributes
```

Standard, vendor-neutral OpenTelemetry attributes used across multiple span types. Currently, covers error.type and server.* attributes per the OTel general semantic conventions.

## ai.koog.agents.features.opentelemetry.attribute.CustomAttribute.CustomAttribute

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-custom-attribute/-custom-attribute.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(key: String, value: Any)
```

- key — the attribute key
- value — the attribute value
## ai.koog.agents.features.opentelemetry.attribute.CustomAttribute

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-custom-attribute/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class CustomAttribute(val key: String, val value: Any) : Attribute
```

A custom attribute with a key-value pair.

- key — the attribute key
- value — the attribute value
## ai.koog.agents.features.opentelemetry.attribute.CustomAttribute.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-custom-attribute/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

- key — the attribute key
## ai.koog.agents.features.opentelemetry.attribute.CustomAttribute.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-custom-attribute/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Any
```

- value — the attribute value
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttribute

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attribute/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface GenAIAttribute : Attribute
```

Marker for OpenTelemetry GenAI semantic-convention attributes - root key gen_ai. Concrete subtypes live in GenAIAttributes.

- Operation
- Agent
- Provider
- Conversation
- DataSource
- Input
- Output
- Request
- Response
- Token
- Usage
- Tool
- SystemInstructions
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttribute.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attribute/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Description.Description

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-description/-description.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(description: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Description.description

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-description/description.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val description: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Description

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-description/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Description(val description: String) : GenAIAttributes.Agent
```

gen_ai.agent.description attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Description.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-description/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Description.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-description/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : GenAIAttributes.Agent
```

gen_ai.agent.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Name.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-name/-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-name/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Name(val name: String) : GenAIAttributes.Agent
```

gen_ai.agent.name attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Name.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-name/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Name.name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-name/name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val name: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.Name.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/-name/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Agent : GenAIAttribute
```

gen_ai.agent attribute namespace.

- Description
- Id
- Name
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Agent.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-agent/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : GenAIAttributes.Conversation
```

gen_ai.conversation.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Conversation : GenAIAttribute
```

gen_ai.conversation attribute namespace.

- Id
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Conversation.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-conversation/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : GenAIAttributes.DataSource
```

gen_ai.data_source.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface DataSource : GenAIAttribute
```

gen_ai.data_source attribute namespace.

- Id
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.DataSource.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-data-source/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input.Messages.Messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/-messages/-messages.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(messages: List<Message>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input.Messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/-messages/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Messages(val messages: List<Message>) : GenAIAttributes.Input
```

gen_ai.input.messages attribute.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input.Messages.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/-messages/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input.Messages.messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/-messages/messages.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val messages: List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input.Messages.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/-messages/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Input : GenAIAttribute
```

gen_ai.input attribute namespace.

- Messages
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Input.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-input/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.Name.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-name/-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(operation: GenAIAttributes.Operation.OperationNameType)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-name/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Name(val operation: GenAIAttributes.Operation.OperationNameType) : GenAIAttributes.Operation
```

gen_ai.operation.name attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.Name.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-name/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.Name.operation

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-name/operation.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val operation: GenAIAttributes.Operation.OperationNameType
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.Name.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-name/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.CHAT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-c-h-a-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
CHAT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.CREATE_AGENT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-c-r-e-a-t-e_-a-g-e-n-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
CREATE_AGENT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.EMBEDDINGS

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-e-m-b-e-d-d-i-n-g-s/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
EMBEDDINGS
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.EXECUTE_TOOL

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-e-x-e-c-u-t-e_-t-o-o-l/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
EXECUTE_TOOL
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.GENERATE_CONTENT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-g-e-n-e-r-a-t-e_-c-o-n-t-e-n-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
GENERATE_CONTENT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.INVOKE_AGENT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-i-n-v-o-k-e_-a-g-e-n-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
INVOKE_AGENT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.TEXT_COMPLETION

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/-t-e-x-t_-c-o-m-p-l-e-t-i-o-n/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
TEXT_COMPLETION
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.entries

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/entries.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val entries: EnumEntries<GenAIAttributes.Operation.OperationNameType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
enum OperationNameType : Enum<GenAIAttributes.Operation.OperationNameType>
```

Allowed values for gen_ai.operation.name per the OTel GenAI semantic conventions.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.valueOf

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/value-of.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun valueOf(value: String): GenAIAttributes.Operation.OperationNameType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.OperationNameType.values

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/-operation-name-type/values.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun values(): Array<GenAIAttributes.Operation.OperationNameType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Operation : GenAIAttribute
```

gen_ai.operation attribute namespace.

- Name
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Operation.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-operation/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Messages.Messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-messages/-messages.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(messages: List<Message>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-messages/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Messages(val messages: List<Message>) : GenAIAttributes.Output
```

gen_ai.output.messages attribute.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Messages.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-messages/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Messages.messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-messages/messages.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val messages: List<Message>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Messages.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-messages/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.IMAGE

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/-i-m-a-g-e/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
IMAGE
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.JSON

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/-j-s-o-n/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
JSON
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.TEXT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/-t-e-x-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
TEXT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.entries

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/entries.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val entries: EnumEntries<GenAIAttributes.Output.OutputType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
enum OutputType : Enum<GenAIAttributes.Output.OutputType>
```

Allowed values for gen_ai.output.type per the OTel GenAI semantic conventions.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.valueOf

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/value-of.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun valueOf(value: String): GenAIAttributes.Output.OutputType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.OutputType.values

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-output-type/values.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun values(): Array<GenAIAttributes.Output.OutputType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Type.Type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-type/-type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(type: GenAIAttributes.Output.OutputType)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Type(val type: GenAIAttributes.Output.OutputType) : GenAIAttributes.Output
```

gen_ai.output.type attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Type.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-type/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Type.type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-type/type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val type: GenAIAttributes.Output.OutputType
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.Type.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/-type/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Output : GenAIAttribute
```

gen_ai.output attribute namespace.

- Type
- Messages
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Output.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-output/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Provider.Name.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-provider/-name/-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(value: String)
```

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(provider: LLMProvider)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Provider.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-provider/-name/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Name(val value: String) : GenAIAttributes.Provider
```

gen_ai.provider.name attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Provider.Name.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-provider/-name/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Provider.Name.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-provider/-name/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Provider

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-provider/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Provider : GenAIAttribute
```

gen_ai.provider attribute namespace.

- Name
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Provider.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-provider/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice.Count.Count

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/-count/-count.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(count: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice.Count.count

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/-count/count.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val count: Int
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice.Count

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/-count/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Count(val count: Int) : GenAIAttributes.Request.Choice
```

gen_ai.request.choice.count attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice.Count.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/-count/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice.Count.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/-count/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Choice : GenAIAttributes.Request
```

gen_ai.request.choice attribute namespace.

- Count
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Choice.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-choice/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.FrequencyPenalty.FrequencyPenalty

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-frequency-penalty/-frequency-penalty.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(frequencyPenalty: Double)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.FrequencyPenalty.frequencyPenalty

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-frequency-penalty/frequency-penalty.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val frequencyPenalty: Double
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.FrequencyPenalty

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-frequency-penalty/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class FrequencyPenalty(val frequencyPenalty: Double) : GenAIAttributes.Request
```

gen_ai.request.frequency_penalty attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.FrequencyPenalty.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-frequency-penalty/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.FrequencyPenalty.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-frequency-penalty/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Double
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.MaxTokens.MaxTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-max-tokens/-max-tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(maxTokens: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.MaxTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-max-tokens/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class MaxTokens(val maxTokens: Int) : GenAIAttributes.Request
```

gen_ai.request.max_tokens attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.MaxTokens.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-max-tokens/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.MaxTokens.maxTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-max-tokens/max-tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val maxTokens: Int
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.MaxTokens.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-max-tokens/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Model.Model

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-model/-model.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(model: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Model

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-model/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Model(val model: LLModel) : GenAIAttributes.Request
```

gen_ai.request.model attribute.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Model.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-model/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Model.model

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-model/model.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val model: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Model.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-model/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.PresencePenalty.PresencePenalty

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-presence-penalty/-presence-penalty.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(presencePenalty: Double)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.PresencePenalty

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-presence-penalty/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class PresencePenalty(val presencePenalty: Double) : GenAIAttributes.Request
```

gen_ai.request.presence_penalty attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.PresencePenalty.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-presence-penalty/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.PresencePenalty.presencePenalty

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-presence-penalty/presence-penalty.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val presencePenalty: Double
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.PresencePenalty.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-presence-penalty/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Double
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Seed.Seed

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-seed/-seed.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(seed: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Seed

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-seed/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Seed(val seed: Int) : GenAIAttributes.Request
```

gen_ai.request.seed attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Seed.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-seed/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Seed.seed

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-seed/seed.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val seed: Int
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Seed.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-seed/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.StopSequences.StopSequences

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-stop-sequences/-stop-sequences.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(stopSequences: List<String>)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.StopSequences

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-stop-sequences/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class StopSequences(val stopSequences: List<String>) : GenAIAttributes.Request
```

gen_ai.request.stop_sequences attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.StopSequences.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-stop-sequences/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.StopSequences.stopSequences

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-stop-sequences/stop-sequences.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val stopSequences: List<String>
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.StopSequences.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-stop-sequences/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: List<String>
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Temperature.Temperature

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-temperature/-temperature.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(temperature: Double)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Temperature

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-temperature/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Temperature(val temperature: Double) : GenAIAttributes.Request
```

gen_ai.request.temperature attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Temperature.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-temperature/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Temperature.temperature

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-temperature/temperature.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val temperature: Double
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.Temperature.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-temperature/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Double
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.TopP.TopP

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-top-p/-top-p.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(topP: Double)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.TopP

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-top-p/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class TopP(val topP: Double) : GenAIAttributes.Request
```

gen_ai.request.top_p attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.TopP.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-top-p/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.TopP.topP

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-top-p/top-p.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val topP: Double
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.TopP.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/-top-p/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Double
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Request : GenAIAttribute
```

gen_ai.request attribute namespace.

- Choice
- Model
- Seed
- FrequencyPenalty
- MaxTokens
- PresencePenalty
- StopSequences
- Temperature
- TopP
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Request.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-request/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.ContentFilter.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-content-filter/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val id: String
```

Wire identifier emitted on the span attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.ContentFilter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-content-filter/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object ContentFilter : GenAIAttributes.Response.FinishReasonType
```

Generation stopped because content was filtered.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Custom.Custom

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-custom/-custom.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Custom.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-custom/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val id: String
```

Wire identifier emitted on the span attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Custom

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-custom/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Custom(val id: String) : GenAIAttributes.Response.FinishReasonType
```

Vendor-specific finish reason carried as a verbatim string.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Length.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-length/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val id: String
```

Wire identifier emitted on the span attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Length

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-length/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object Length : GenAIAttributes.Response.FinishReasonType
```

Generation stopped because the maximum length was reached.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Stop.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-stop/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val id: String
```

Wire identifier emitted on the span attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.Stop

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-stop/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object Stop : GenAIAttributes.Response.FinishReasonType
```

Generation stopped naturally (end of response).

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.ToolCalls.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-tool-calls/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val id: String
```

Wire identifier emitted on the span attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.ToolCalls

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/-tool-calls/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object ToolCalls : GenAIAttributes.Response.FinishReasonType
```

Generation stopped because the model emitted tool calls.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract val id: String
```

Wire identifier emitted on the span attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasonType

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reason-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface FinishReasonType
```

Allowed values for gen_ai.response.finish_reasons. The standard set covers content_filter, length, stop, and tool_calls; use Custom for vendor-specific reasons.

- ContentFilter
- Length
- Stop
- ToolCalls
- Custom
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasons.FinishReasons

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reasons/-finish-reasons.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(reasons: List<GenAIAttributes.Response.FinishReasonType>)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasons

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reasons/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class FinishReasons(val reasons: List<GenAIAttributes.Response.FinishReasonType>) : GenAIAttributes.Response
```

gen_ai.response.finish_reasons attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasons.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reasons/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasons.reasons

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reasons/reasons.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val reasons: List<GenAIAttributes.Response.FinishReasonType>
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.FinishReasons.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-finish-reasons/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: List<String>
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : GenAIAttributes.Response
```

gen_ai.response.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Metadata.Metadata

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-metadata/-metadata.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(metadata: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Metadata

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-metadata/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Metadata(val metadata: String) : GenAIAttributes.Response
```

gen_ai.response.metadata attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Metadata.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-metadata/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Metadata.metadata

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-metadata/metadata.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val metadata: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Metadata.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-metadata/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Model.Model

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-model/-model.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(model: LLModel)
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Model

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-model/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Model(val model: LLModel) : GenAIAttributes.Response
```

gen_ai.response.model attribute.


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Model.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-model/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Model.model

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-model/model.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val model: LLModel
```


Referenced packages: `ai.koog.prompt.llm`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.Model.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/-model/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Response : GenAIAttribute
```

gen_ai.response attribute namespace.

- FinishReasons
- Id
- Model
- Metadata
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Response.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-response/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.SystemInstructions.SystemInstructions

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-system-instructions/-system-instructions.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(messages: List<Message.System>)
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.SystemInstructions

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-system-instructions/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class SystemInstructions(val messages: List<Message.System>) : GenAIAttribute
```

gen_ai.system_instructions attribute.


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.SystemInstructions.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-system-instructions/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.SystemInstructions.messages

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-system-instructions/messages.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val messages: List<Message.System>
```


Referenced packages: `ai.koog.prompt.message`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.SystemInstructions.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-system-instructions/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType.INPUT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/-i-n-p-u-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
INPUT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType.OUTPUT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/-o-u-t-p-u-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
OUTPUT
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType.entries

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/entries.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val entries: EnumEntries<GenAIAttributes.Token.TokenType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
enum TokenType : Enum<GenAIAttributes.Token.TokenType>
```

Allowed values for gen_ai.token.type per the OTel GenAI semantic conventions.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType.str

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/str.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val str: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType.valueOf

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/value-of.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun valueOf(value: String): GenAIAttributes.Token.TokenType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.TokenType.values

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-token-type/values.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun values(): Array<GenAIAttributes.Token.TokenType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.Type.Type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-type/-type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(type: GenAIAttributes.Token.TokenType)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.Type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Type(val type: GenAIAttributes.Token.TokenType) : GenAIAttributes.Token
```

gen_ai.token.type attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.Type.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-type/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.Type.type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-type/type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val type: GenAIAttributes.Token.TokenType
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.Type.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/-type/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Token : GenAIAttribute
```

gen_ai.token attribute namespace.

- Type
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Token.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-token/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Arguments.Arguments

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-arguments/-arguments.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(arguments: JsonObject)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Arguments.arguments

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-arguments/arguments.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val arguments: JsonObject
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Arguments

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-arguments/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Arguments(val arguments: JsonObject) : GenAIAttributes.Tool.Call
```

gen_ai.tool.call.arguments attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Arguments.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-arguments/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Arguments.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-arguments/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : GenAIAttributes.Tool.Call
```

gen_ai.tool.call.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Result.Result

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-result/-result.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(result: JsonElement)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Result

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-result/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Result(val result: JsonElement) : GenAIAttributes.Tool.Call
```

gen_ai.tool.call.result attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Result.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-result/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Result.result

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-result/result.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val result: JsonElement
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.Result.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/-result/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Call : GenAIAttributes.Tool
```

gen_ai.tool.call attribute namespace.

- Id
- Arguments
- Result
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Call.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-call/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Definitions.Definitions

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-definitions/-definitions.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(tools: List<ToolDescriptor>)
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Definitions

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-definitions/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Definitions(val tools: List<ToolDescriptor>) : GenAIAttributes.Tool
```

gen_ai.tool.definitions attribute.


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Definitions.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-definitions/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Definitions.tools

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-definitions/tools.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val tools: List<ToolDescriptor>
```


Referenced packages: `ai.koog.agents.core.tools`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Definitions.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-definitions/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Description.Description

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-description/-description.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(description: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Description.description

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-description/description.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val description: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Description

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-description/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Description(val description: String) : GenAIAttributes.Tool
```

gen_ai.tool.description attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Description.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-description/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Description.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-description/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Name.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-name/-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-name/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Name(val name: String) : GenAIAttributes.Tool
```

gen_ai.tool.name attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Name.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-name/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Name.name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-name/name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val name: String
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.Name.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/-name/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Tool : GenAIAttribute
```

gen_ai.tool attribute namespace.

- Call
- Description
- Name
- Definitions
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Tool.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-tool/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.InputTokens.InputTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-input-tokens/-input-tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(tokens: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.InputTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-input-tokens/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class InputTokens(val tokens: Int) : GenAIAttributes.Usage
```

gen_ai.usage.input_tokens attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.InputTokens.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-input-tokens/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.InputTokens.tokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-input-tokens/tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val tokens: Int
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.InputTokens.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-input-tokens/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.OutputTokens.OutputTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-output-tokens/-output-tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(tokens: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.OutputTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-output-tokens/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class OutputTokens(val tokens: Int) : GenAIAttributes.Usage
```

gen_ai.usage.output_tokens attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.OutputTokens.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-output-tokens/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.OutputTokens.tokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-output-tokens/tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val tokens: Int
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.OutputTokens.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-output-tokens/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.TotalTokens.TotalTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-total-tokens/-total-tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(tokens: Int)
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.TotalTokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-total-tokens/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class TotalTokens(val tokens: Int) : GenAIAttributes.Usage
```

gen_ai.usage.total_tokens attribute.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.TotalTokens.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-total-tokens/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.TotalTokens.tokens

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-total-tokens/tokens.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val tokens: Int
```

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.TotalTokens.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/-total-tokens/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: Int
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Usage : GenAIAttribute
```

gen_ai.usage attribute namespace.

- InputTokens
- OutputTokens
- TotalTokens
## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes.Usage.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/-usage/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.GenAIAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-gen-a-i-attributes/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object GenAIAttributes
```

This class describes attributes in the GenAI system.

The list of supported attributes according to OpenTelemetry Semantic Convention (https://opentelemetry.io/docs/specs/semconv/gen-ai/gen-ai-agent-spans/)

Note: Some shared attributes are located in CommonAttributes class.

List of attributes:

gen_ai.operation.name (required)

gen_ai.agent.description (conditional)

gen_ai.agent.id (conditional)

gen_ai.agent.name (conditional)

gen_ai.provider.name (conditional)

gen_ai.conversation.id (conditional)

gen_ai.data_source.id (conditional)

gen_ai.input.messages (recommended)

gen_ai.output.type (conditional/required)

gen_ai.output.messages (recommended)

gen_ai.request.choice.count (conditional/required)

gen_ai.request.model (conditional/required)

gen_ai.request.seed (conditional/required)

gen_ai.request.frequency_penalty (recommended)

gen_ai.request.max_tokens (recommended)

gen_ai.request.presence_penalty (recommended)

gen_ai.request.stop_sequences (recommended)

gen_ai.request.temperature (recommended)

gen_ai.request.top_p (recommended)

gen_ai.response.finish_reasons (recommended)

gen_ai.response.id (recommended)

gen_ai.response.model (recommended)

gen_ai.token.type (required)

gen_ai.usage.input_tokens (recommended)

gen_ai.usage.output_tokens (recommended)

gen_ai.usage.total_tokens (non-semantic)

gen_ai.tool.call.id (recommended)

gen_ai.tool.call.arguments (recommended)

gen_ai.tool.call.result (recommended)

gen_ai.tool.description (recommended)

gen_ai.tool.name (recommended)

gen_ai.tool.definitions (recommended)

gen_ai.system_instructions (recommended)

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : KoogAttributes.Koog.Event
```

koog.event.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Event : KoogAttributes.Koog
```

koog.event attribute namespace.

- Id
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Event.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-event/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation.Result.Result

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/-result/-result.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(moderationResult: ModerationResult)
```


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation.Result

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/-result/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Result(val moderationResult: ModerationResult) : KoogAttributes.Koog.Moderation
```

koog.moderation.result attribute.

The OpenTelemetry GenAI semantic conventions do not define a moderation outcome attribute, so Koog publishes this as a Koog-namespaced attribute on the inference span when moderationResponse is present.


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation.Result.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/-result/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation.Result.moderationResult

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/-result/moderation-result.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val moderationResult: ModerationResult
```


Referenced packages: `ai.koog.prompt.dsl`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation.Result.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/-result/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Moderation : KoogAttributes.Koog
```

koog.moderation attribute namespace.

- Result
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Moderation.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-moderation/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : KoogAttributes.Koog.Node
```

koog.node.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Input.Input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-input/-input.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(input: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-input/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Input(val input: String) : KoogAttributes.Koog.Node
```

koog.node.input attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Input.input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-input/input.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val input: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Input.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-input/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Input.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-input/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Output.Output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-output/-output.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(output: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-output/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Output(val output: String) : KoogAttributes.Koog.Node
```

koog.node.output attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Output.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-output/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Output.output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-output/output.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val output: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.Output.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/-output/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Node : KoogAttributes.Koog
```

koog.node attribute namespace.

- Id
- Input
- Output
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Node.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-node/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy.Name.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/-name/-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/-name/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Name(val name: String) : KoogAttributes.Koog.Strategy
```

koog.strategy.name attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy.Name.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/-name/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy.Name.name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/-name/name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val name: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy.Name.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/-name/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Strategy : KoogAttributes.Koog
```

koog.strategy attribute namespace.

- Name
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Strategy.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-strategy/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : KoogAttributes.Koog.Subgraph
```

koog.subgraph.id attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Input.Input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-input/-input.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(input: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-input/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Input(val input: String) : KoogAttributes.Koog.Subgraph
```

koog.subgraph.input attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Input.input

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-input/input.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val input: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Input.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-input/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Input.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-input/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Output.Output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-output/-output.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(output: String)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-output/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Output(val output: String) : KoogAttributes.Koog.Subgraph
```

koog.subgraph.output attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Output.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-output/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Output.output

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-output/output.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val output: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.Output.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/-output/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: HiddenString
```

Attribute value.


Referenced packages: `ai.koog.agents.utils`.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Subgraph : KoogAttributes.Koog
```

koog.subgraph attribute namespace.

- Id
- Input
- Output
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Subgraph.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-subgraph/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.Status.Status

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status/-status.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(status: KoogAttributes.Koog.Tool.Call.StatusType)
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.Status

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Status(val status: KoogAttributes.Koog.Tool.Call.StatusType) : KoogAttributes.Koog.Tool.Call
```

koog.tool.call.status attribute.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.Status.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.Status.status

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status/status.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val status: KoogAttributes.Koog.Tool.Call.StatusType
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.Status.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.ERROR

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/-e-r-r-o-r/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

**Incomplete source signature.** Verify against the target dependency; do not copy as Kotlin.

```text
ERROR
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.SUCCESS

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/-s-u-c-c-e-s-s/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
SUCCESS
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.VALIDATION_FAILED

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/-v-a-l-i-d-a-t-i-o-n_-f-a-i-l-e-d/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
VALIDATION_FAILED
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.entries

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/entries.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val entries: EnumEntries<KoogAttributes.Koog.Tool.Call.StatusType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
enum StatusType : Enum<KoogAttributes.Koog.Tool.Call.StatusType>
```

koog.tool.call.status allowed values.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.valueOf

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/value-of.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun valueOf(value: String): KoogAttributes.Koog.Tool.Call.StatusType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val value: String
```

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.StatusType.values

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/-status-type/values.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun values(): Array<KoogAttributes.Koog.Tool.Call.StatusType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Call : KoogAttributes.Koog.Tool
```

koog.tool.call attribute namespace.

- Status
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.Call.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/-call/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Tool : KoogAttributes.Koog
```

koog.tool attribute namespace.

- Call
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.Tool.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/-tool/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Koog : Attribute
```

koog attribute namespace.

- Event
- Strategy
- Node
- Subgraph
- Moderation
- Tool
## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.Koog.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-koog/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes.PROVIDER_NAME

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/-p-r-o-v-i-d-e-r_-n-a-m-e.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
const val PROVIDER_NAME: String
```

Value set on gen_ai.provider.name for execute_tool metrics and spans. LLM operations use the actual LLM provider id instead.

## ai.koog.agents.features.opentelemetry.attribute.KoogAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-koog-attributes/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object KoogAttributes
```

Koog-specific attribute hierarchy for spans and events emitted by the OpenTelemetry feature.

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method.Name.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/-name/-name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(name: String)
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method.Name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/-name/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Name(val name: String) : McpAttributes.Mcp.Method
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method.Name.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/-name/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method.Name.name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/-name/name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val name: String
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method.Name.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/-name/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Method : McpAttributes.Mcp
```

The name of the request or notification method. This is a REQUIRED attribute for all MCP operations.

- Name
## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Method.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-method/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol.Version.Version

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/-version/-version.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(version: String)
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol.Version

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/-version/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Version(val version: String) : McpAttributes.Mcp.Protocol
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol.Version.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/-version/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol.Version.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/-version/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol.Version.version

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/-version/version.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val version: String
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Protocol : McpAttributes.Mcp
```

The version of the Model Context Protocol in use. This is a RECOMMENDED attribute.

Example: "2025-06-18"

- Version
## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Protocol.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-protocol/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session.Id.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/-id/-id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(id: String)
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session.Id.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/-id/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session.Id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/-id/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Id(val id: String) : McpAttributes.Mcp.Session
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session.Id.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/-id/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session.Id.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/-id/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Session : McpAttributes.Mcp
```

Identifies the MCP session. This is a RECOMMENDED attribute when the request is part of a session.

Example: "191c4850af6c49e08843a3f6c80e5046"

- Id
## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.Session.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/-session/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Mcp : Attribute
```

- Method
- Session
- Protocol
## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Mcp.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-mcp/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network.Transport.Transport

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/-transport/-transport.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(transport: String)
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network.Transport

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/-transport/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
data class Transport(val transport: String) : McpAttributes.Network
```

The transport protocol used for the MCP session. This is RECOMMENDED.

https://github.com/open-telemetry/semantic-conventions/blob/main/model/mcp/common.yaml

Valid values:

"pipe" for stdio transport

"tcp" for HTTP transport

"quic" for HTTP/3 transport

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network.Transport.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/-transport/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network.Transport.transport

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/-transport/transport.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val transport: String
```

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network.Transport.value

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/-transport/value.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val value: String
```

Attribute value.

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
sealed interface Network : Attribute
```

Network transport and protocol attributes for MCP operations.

- Transport
## ai.koog.agents.features.opentelemetry.attribute.McpAttributes.Network.key

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/-network/key.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open override val key: String
```

Attribute key

## ai.koog.agents.features.opentelemetry.attribute.McpAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.attribute/-mcp-attributes/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object McpAttributes
```

MCP (Model Context Protocol) specific attributes following OpenTelemetry semantic conventions. Based on: https://github.com/open-telemetry/semantic-conventions/blob/main/docs/registry/attributes/mcp.md https://github.com/open-telemetry/semantic-conventions/blob/main/model/mcp/common.yaml

These attributes are used for instrumenting MCP client operations including:

Tools operations

Session management

Protocol version information

TODO: Resources and prompts operations

## ai.koog.agents.features.opentelemetry.integration.SpanAdapter.SpanAdapter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration/-span-adapter/-span-adapter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor()
```

## ai.koog.agents.features.opentelemetry.integration.SpanAdapter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration/-span-adapter/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
abstract class SpanAdapter
```

Adapter for post-processing GenAI agent spans.

## ai.koog.agents.features.opentelemetry.integration.SpanAdapter.onBeforeSpanFinished

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration/-span-adapter/on-before-span-finished.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open fun onBeforeSpanFinished(span: GenAIAgentSpan)
```

Invoked before span is finished.

- span — Span about to be finished.

Referenced packages: `ai.koog.agents.features.opentelemetry.span`.

## ai.koog.agents.features.opentelemetry.integration.SpanAdapter.onBeforeSpanStarted

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration/-span-adapter/on-before-span-started.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open fun onBeforeSpanStarted(span: GenAIAgentSpan)
```

Invoked before span is started.

- span — Span about to be started.

Referenced packages: `ai.koog.agents.features.opentelemetry.span`.

## ai.koog.agents.features.opentelemetry.integration.isSdkArrayPrimitive

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration/is-sdk-array-primitive.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val Any.isSdkArrayPrimitive: Boolean
```

true if this value is a primitive the OpenTelemetry SDK can store directly in an attribute array.

## ai.koog.agents.features.opentelemetry.integration.replaceAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration/replace-attributes.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
inline fun <TAttribute : Attribute> GenAIAgentSpan.replaceAttributes(processAttributeAction: GenAIAgentSpan.(TAttribute) -> Attribute)
```

Replaces every attribute of type TAttribute on this span with the result of processAttributeAction. No-op if none are present.

- processAttributeAction — Maps an existing attribute to its replacement.

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`, `ai.koog.agents.features.opentelemetry.span`.

## ai.koog.agents.features.opentelemetry.integration.datadog.addDatadogExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.datadog/add-datadog-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun OpenTelemetryConfig.addDatadogExporter(datadogApiKey: String? = null, url: String? = null, timeout: Duration? = null, resourceAttributes: Map<String, String>? = null)
```

Configure an OpenTelemetry span exporter that sends data to Datadog via direct OTLP intake.

Registered via addSpanExporter, which wraps the exporter in a batch span processor - the cloud HTTP round-trip happens on a worker thread instead of blocking the agent on each span end.

- datadogApiKey — Datadog API key. If not set, is retrieved from DD_API_KEY environment variable;
- url — Datadog site. If not set, is retrieved from DD_SITE environment variable. Defaults to datadoghq.com;
- timeout — request timeout (10 seconds by default);
- resourceAttributes — resource-level attributes to add to all exported spans.
- Datadog LLM Observability

Referenced packages: `ai.koog.agents.features.opentelemetry.feature`.

## ai.koog.agents.features.opentelemetry.integration.langfuse.addLangfuseSpanAdapter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.langfuse/add-langfuse-span-adapter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun OpenTelemetryConfig.addLangfuseSpanAdapter(traceAttributes: List<CustomAttribute>? = null)
```

Installs the Langfuse SpanAdapter without registering the Langfuse cloud exporter. Spans are reshaped to the Langfuse-recommended attribute layout but are emitted only through whatever exporters the caller registers separately.

Useful for tests that want to assert on Langfuse-shaped spans without performing a real HTTP round-trip and for integrators who want the Langfuse transformations applied to spans they ship to a different backend.

- traceAttributes — list of trace-level Langfuse attributes (see https://langfuse.com/integrations/native/opentelemetry#propagating-attributes).

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`, `ai.koog.agents.features.opentelemetry.feature`.

## ai.koog.agents.features.opentelemetry.integration.otlp.OtlpJsonSpanExporter.OtlpJsonSpanExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.otlp/-otlp-json-span-exporter/-otlp-json-span-exporter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
constructor(endpoint: String, headers: Map<String, String> = emptyMap(), timeout: Duration? = null, baseClient: HttpClient? = null)
```

- endpoint — full OTLP/JSON URL, e.g. https://cloud.langfuse.com/api/public/otel/v1/traces.
- headers — extra HTTP headers (typically Authorization);
- timeout — request timeout, by default, set to 10 seconds;
- baseClient — optional HttpClient. When provided, the exporter uses it as-is and skips the default ContentNegotiation install - the caller must provide a JSON serializer.
## ai.koog.agents.features.opentelemetry.integration.otlp.OtlpJsonSpanExporter.export

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.otlp/-otlp-json-span-exporter/export.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open suspend override fun export(telemetry: List<SpanData>): OperationResultCode
```

## ai.koog.agents.features.opentelemetry.integration.otlp.OtlpJsonSpanExporter.forceFlush

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.otlp/-otlp-json-span-exporter/force-flush.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open suspend override fun forceFlush(): OperationResultCode
```

## ai.koog.agents.features.opentelemetry.integration.otlp.OtlpJsonSpanExporter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.otlp/-otlp-json-span-exporter/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
class OtlpJsonSpanExporter(endpoint: String, headers: Map<String, String> = emptyMap(), timeout: Duration? = null, baseClient: HttpClient? = null) : SpanExporter
```

Kotlin Multiplatform OTLP/JSON SpanExporter implementation.

Sends spans over HTTP to any OTLP/JSON-compatible receiver (Langfuse, W&B Weave, generic collectors). The wire format follows https://opentelemetry.io/docs/specs/otlp/#json-protobuf-encoding with Content-Type: application/json and the JSON-encoded ExportTraceServiceRequest.

On non-2xx responses or transport errors, returns OperationResultCode.Failure; the configured span processor (typically BatchSpanProcessor) drops the failed batch.

Note: There is no built-in retry / back-off.

- endpoint — full OTLP/JSON URL, e.g. https://cloud.langfuse.com/api/public/otel/v1/traces.
- headers — extra HTTP headers (typically Authorization);
- timeout — request timeout, by default, set to 10 seconds;
- baseClient — optional HttpClient. When provided, the exporter uses it as-is and skips the default ContentNegotiation install - the caller must provide a JSON serializer.
## ai.koog.agents.features.opentelemetry.integration.otlp.OtlpJsonSpanExporter.shutdown

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.otlp/-otlp-json-span-exporter/shutdown.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
open suspend override fun shutdown(): OperationResultCode
```

## ai.koog.agents.features.opentelemetry.integration.otlp.OtlpSpanDataMapper

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.otlp/-otlp-span-data-mapper/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
object OtlpSpanDataMapper
```

Provides utility functions to map SpanData objects to their OTLP (OpenTelemetry Protocol) representations.

## ai.koog.agents.features.opentelemetry.integration.weave.addWeaveSpanAdapter

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.integration.weave/add-weave-span-adapter.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun OpenTelemetryConfig.addWeaveSpanAdapter()
```

Installs the W&B Weave SpanAdapter without registering the Weave cloud exporter. Spans are reshaped to the Weave-recommended attribute layout but are emitted only through whatever exporters the caller registers separately.

Useful for tests that want to assert on Weave-shaped spans without performing a real HTTP round-trip and for integrators who want the Weave transformations applied to spans they ship to a different backend.


Referenced packages: `ai.koog.agents.features.opentelemetry.feature`.

## ai.koog.agents.features.opentelemetry.metric.adapter.restrictToolNameCardinality

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.metric.adapter/restrict-tool-name-cardinality.html`

### :agents:agents-features:agents-features-opentelemetry/jvmCommonMain

```kotlin
fun OpenTelemetryConfig.restrictToolNameCardinality(allowedToolNames: Set<String>, fallbackToolName: String = FALLBACK_TOOL_NAME)
```

Restricts tool names in the attributes' metric and sets the fallback tool name when a tool is not allowed. Helps to manage cardinality of the metric.

- allowedToolNames — A set of allowed tool names
- fallbackToolName — The fallback / default tool name if not in the allowed set

Referenced packages: `ai.koog.agents.features.opentelemetry.feature`.

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.addAttribute

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/add-attribute.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun addAttribute(attribute: Attribute)
```

Adds attribute to the span. Existing attribute with the same key is replaced.

- attribute — Attribute to add.

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`.

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.addAttributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/add-attributes.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun addAttributes(attributes: List<Attribute>)
```

Adds all attributes to the span.

- attributes — Attributes to add.

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`.

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.attributes

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/attributes.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val attributes: List<Attribute>
```

Attributes attached to this span.


Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`.

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.id

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/id.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val id: String
```

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
class GenAIAgentSpan
```

A GenAI agent span emitted by the OpenTelemetry feature.

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.kind

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/kind.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val kind: SpanKind
```

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.name

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/name.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val name: String
```

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.removeAttribute

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/remove-attribute.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun removeAttribute(attribute: Attribute): Boolean
```

Removes attribute from the span. Returns true if it was present.

- attribute — Attribute to remove.

Referenced packages: `ai.koog.agents.features.opentelemetry.attribute`.

## ai.koog.agents.features.opentelemetry.span.GenAIAgentSpan.type

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-gen-a-i-agent-span/type.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val type: SpanType
```

## ai.koog.agents.features.opentelemetry.span.SpanType.CREATE_AGENT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-c-r-e-a-t-e_-a-g-e-n-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
CREATE_AGENT
```

Agent construction.

## ai.koog.agents.features.opentelemetry.span.SpanType.EXECUTE_TOOL

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-e-x-e-c-u-t-e_-t-o-o-l/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
EXECUTE_TOOL
```

One tool call invocation.

## ai.koog.agents.features.opentelemetry.span.SpanType.INFERENCE

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-i-n-f-e-r-e-n-c-e/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
INFERENCE
```

One LLM inference call.

## ai.koog.agents.features.opentelemetry.span.SpanType.INVOKE_AGENT

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-i-n-v-o-k-e_-a-g-e-n-t/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
INVOKE_AGENT
```

One full agent run.

## ai.koog.agents.features.opentelemetry.span.SpanType.NODE

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-n-o-d-e/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
NODE
```

Single graph node execution.

## ai.koog.agents.features.opentelemetry.span.SpanType.STRATEGY

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-s-t-r-a-t-e-g-y/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
STRATEGY
```

Strategy graph execution.

## ai.koog.agents.features.opentelemetry.span.SpanType.SUBGRAPH

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/-s-u-b-g-r-a-p-h/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
SUBGRAPH
```

Subgraph execution.

## ai.koog.agents.features.opentelemetry.span.SpanType.entries

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/entries.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
val entries: EnumEntries<SpanType>
```

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

## ai.koog.agents.features.opentelemetry.span.SpanType

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/index.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
enum SpanType : Enum<SpanType>
```

Type tag for a GenAIAgentSpan.

## ai.koog.agents.features.opentelemetry.span.SpanType.valueOf

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/value-of.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun valueOf(value: String): SpanType
```

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

- kotlin.IllegalArgumentException — if this enum type has no constant with the specified name
## ai.koog.agents.features.opentelemetry.span.SpanType.values

Module: `agents-features-opentelemetry`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `agents/agents-features/agents-features-opentelemetry/ai.koog.agents.features.opentelemetry.span/-span-type/values.html`

### :agents:agents-features:agents-features-opentelemetry/commonMain

```kotlin
fun values(): Array<SpanType>
```

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.
