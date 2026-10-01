# Serialization and Kotlin type tokens

Kotlin contracts extracted from the supplied Dokka build. Read [coverage and compatibility](../api-index.md) first. Read individual symbols as needed; source labels and incomplete declarations are preserved.

## ai.koog.serialization.JSONArray.JSONArray

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-array/-j-s-o-n-array.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(elements: List<JSONElement>)
```

## ai.koog.serialization.JSONArray.elements

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-array/elements.html`

### :serialization:serialization-core/commonMain

```kotlin
val elements: List<JSONElement>
```

## ai.koog.serialization.JSONArray

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-array/index.html`

### :serialization:serialization-core/commonMain

```kotlin
@Serializable(with = JSONArraySerializer::class) data class JSONArray(val elements: List<JSONElement>) : JSONElement
```

JSON array containing an ordered list of elements.


Referenced packages: `ai.koog.serialization.kotlinx`.

## ai.koog.serialization.JSONElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-element/index.html`

### :serialization:serialization-core/commonMain

```kotlin
@Serializable(with = JSONElementSerializer::class) sealed interface JSONElement
```

Serialization-library agnostic representation of a JSON element.

This sealed hierarchy provides a dynamic JSON model that can be constructed and manipulated independently of any specific JSON serialization library.

- JSONObject
- JSONArray
- JSONPrimitive

Referenced packages: `ai.koog.serialization.kotlinx`.

## ai.koog.serialization.JSONLiteral.JSONLiteral

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-literal/-j-s-o-n-literal.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(content: String, isString: Boolean)
```

## ai.koog.serialization.JSONLiteral.content

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-literal/content.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val content: String
```

## ai.koog.serialization.JSONLiteral

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-literal/index.html`

### :serialization:serialization-core/commonMain

```kotlin
@Serializable(with = JSONLiteralSerializer::class) data class JSONLiteral(val content: String, val isString: Boolean) : JSONPrimitive
```

JSON literal value (string, number, or boolean).


Referenced packages: `ai.koog.serialization.kotlinx`.

## ai.koog.serialization.JSONLiteral.isString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-literal/is-string.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val isString: Boolean
```

## ai.koog.serialization.JSONNull.content

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-null/content.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val content: String
```

Raw string content of this primitive.

## ai.koog.serialization.JSONNull

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-null/index.html`

### :serialization:serialization-core/commonMain

```kotlin
@Serializable(with = JSONNullSerializer::class) data object JSONNull : JSONPrimitive
```

JSON null value.


Referenced packages: `ai.koog.serialization.kotlinx`.

## ai.koog.serialization.JSONNull.isString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-null/is-string.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val isString: Boolean = false
```

Whether this primitive is a JSON string type, i.e., is quoted, or not.

## ai.koog.serialization.JSONObject.JSONObject

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-object/-j-s-o-n-object.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(entries: Map<String, JSONElement>)
```

## ai.koog.serialization.JSONObject

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-object/index.html`

### :serialization:serialization-core/commonMain

```kotlin
@Serializable(with = JSONObjectSerializer::class) data class JSONObject(val entries: Map<String, JSONElement>) : JSONElement
```

JSON object with key-value pairs.


Referenced packages: `ai.koog.serialization.kotlinx`.

## ai.koog.serialization.JSONPrimitive.Companion

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/-companion/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object Companion
```

Factory methods for creating JSON primitives.

## ai.koog.serialization.JSONPrimitive.Companion.ofUnquoted

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/-companion/of-unquoted.html`

### :serialization:serialization-core/commonMain

```kotlin
fun ofUnquoted(value: String?): JSONPrimitive
```

Creates an unquoted JSON literal for raw JSON encoding.

- JSONUnquotedPrimitive
## ai.koog.serialization.JSONPrimitive.Companion.of

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/-companion/of.html`

### :serialization:serialization-core/commonMain

```kotlin
fun of(value: String?): JSONPrimitive
```

Creates a JSON string primitive.

### :serialization:serialization-core/commonMain

```kotlin
fun of(value: Int?): JSONPrimitive
```

Creates a JSON number primitive from an Int.

### :serialization:serialization-core/commonMain

```kotlin
fun of(value: Long?): JSONPrimitive
```

Creates a JSON number primitive from a Long.

### :serialization:serialization-core/commonMain

```kotlin
fun of(value: Double?): JSONPrimitive
```

Creates a JSON number primitive from a Double.

### :serialization:serialization-core/commonMain

```kotlin
fun of(value: Boolean?): JSONPrimitive
```

Creates a JSON boolean primitive.

## ai.koog.serialization.JSONPrimitive.booleanOrNull

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/boolean-or-null.html`

### :serialization:serialization-core/commonMain

```kotlin
val booleanOrNull: Boolean?
```

Attempts to parse content as Boolean, returns null on failure.

## ai.koog.serialization.JSONPrimitive.contentOrNull

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/content-or-null.html`

### :serialization:serialization-core/commonMain

```kotlin
val contentOrNull: String?
```

Returns content as string, or null if this is JSONNull.

## ai.koog.serialization.JSONPrimitive.content

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/content.html`

### :serialization:serialization-core/commonMain

```kotlin
abstract val content: String
```

Raw string content of this primitive.

## ai.koog.serialization.JSONPrimitive.doubleOrNull

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/double-or-null.html`

### :serialization:serialization-core/commonMain

```kotlin
val doubleOrNull: Double?
```

Attempts to parse content as Double, returns null on failure.

## ai.koog.serialization.JSONPrimitive

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/index.html`

### :serialization:serialization-core/commonMain

```kotlin
@Serializable(with = JSONPrimitiveSerializer::class) sealed class JSONPrimitive : JSONElement
```

JSON primitive value (string, number, boolean, or null).

- JSONLiteral
- JSONNull

Referenced packages: `ai.koog.serialization.kotlinx`.

## ai.koog.serialization.JSONPrimitive.intOrNull

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/int-or-null.html`

### :serialization:serialization-core/commonMain

```kotlin
val intOrNull: Int?
```

Attempts to parse content as Int, returns null on failure.

## ai.koog.serialization.JSONPrimitive.isString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/is-string.html`

### :serialization:serialization-core/commonMain

```kotlin
abstract val isString: Boolean
```

Whether this primitive is a JSON string type, i.e., is quoted, or not.

## ai.koog.serialization.JSONPrimitive.longOrNull

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive/long-or-null.html`

### :serialization:serialization-core/commonMain

```kotlin
val longOrNull: Long?
```

Attempts to parse content as Long, returns null on failure.

## ai.koog.serialization.JSONPrimitive

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-primitive.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JSONPrimitive(value: String?): JSONPrimitive
```

Factory function for creating a JSON string primitive.

### :serialization:serialization-core/commonMain

```kotlin
fun JSONPrimitive(value: Int?): JSONPrimitive
```

Factory function for creating a JSON number primitive from an Int.

### :serialization:serialization-core/commonMain

```kotlin
fun JSONPrimitive(value: Long?): JSONPrimitive
```

Factory function for creating a JSON number primitive from a Long.

### :serialization:serialization-core/commonMain

```kotlin
fun JSONPrimitive(value: Double?): JSONPrimitive
```

Factory function for creating a JSON number primitive from a Double.

### :serialization:serialization-core/commonMain

```kotlin
fun JSONPrimitive(value: Boolean?): JSONPrimitive
```

Factory function for creating a JSON boolean primitive.

## ai.koog.serialization.JSONSerializer.decodeFromJSONElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/decode-from-j-s-o-n-element.html`

### :serialization:serialization-core/commonMain

```kotlin
abstract fun <T> decodeFromJSONElement(value: JSONElement, typeToken: TypeToken): T
```

Deserializes JSONElement to a value of type T.

deserialized value of type T

- value — JSONElement to deserialize.
- typeToken — token capturing type information of T
## ai.koog.serialization.JSONSerializer.decodeFromString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/decode-from-string.html`

### :serialization:serialization-core/commonMain

```kotlin
abstract fun <T> decodeFromString(value: String, typeToken: TypeToken): T
```

Deserializes a JSON string to a value of type T.

deserialized value of type T

- value — JSON string to deserialize
- typeToken — token capturing type information of T
## ai.koog.serialization.JSONSerializer.decodeJSONElementFromString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/decode-j-s-o-n-element-from-string.html`

### :serialization:serialization-core/commonMain

```kotlin
open fun decodeJSONElementFromString(value: String): JSONElement
```

Deserializes a JSON string to a JSONElement.

deserialized JSONElement

- value — JSON string to deserialize
## ai.koog.serialization.JSONSerializer.encodeJSONElementToString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/encode-j-s-o-n-element-to-string.html`

### :serialization:serialization-core/commonMain

```kotlin
open fun encodeJSONElementToString(value: JSONElement): String
```

Serializes a JSONElement to its JSON string representation.

JSON string representation of the value

- value — JSONElement to serialize
## ai.koog.serialization.JSONSerializer.encodeToJSONElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/encode-to-j-s-o-n-element.html`

### :serialization:serialization-core/commonMain

```kotlin
abstract fun <T> encodeToJSONElement(value: T, typeToken: TypeToken): JSONElement
```

Serializes a value to its JSONElement representation.

JSONElement representation of the value

- value — value to serialize
- typeToken — token capturing type information of T
## ai.koog.serialization.JSONSerializer.encodeToString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/encode-to-string.html`

### :serialization:serialization-core/commonMain

```kotlin
abstract fun <T> encodeToString(value: T, typeToken: TypeToken): String
```

Serializes a value to its JSON representation.

JSON string representation of the value

- value — value to serialize
- typeToken — token capturing type information of T
## ai.koog.serialization.JSONSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
interface JSONSerializer
```

Serializer for converting values to and from JSON.

This is the core abstraction for JSON serialization/deserialization operations in Koog. It provides a library-agnostic API that can be backed by different serialization libraries, such as kotlinx-serialization or Jackson.

All methods use TypeToken to capture runtime type information. Use the typeToken factory functions to create tokens easily.

- TypeToken — for runtime type representation used by all methods
- JSONElement — for the library-agnostic JSON tree model
- KotlinxSerializer
## ai.koog.serialization.JSONUnquotedPrimitive

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-j-s-o-n-unquoted-primitive.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JSONUnquotedPrimitive(value: String?): JSONPrimitive
```

Creates an unquoted JSON literal for raw JSON encoding.

Use this for encoding values that cannot be represented using standard JSONPrimitive functions:

Precise numeric values (avoiding floating-point precision errors)

Large numbers beyond standard numeric types

Raw JSON fragments

Modeled after JsonUnquotedLiteral from kotlinx-serialization.

## ai.koog.serialization.KSerializerTypeToken.KSerializerTypeToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-k-serializer-type-token/-k-serializer-type-token.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(serializer: KSerializer<T>)
```

## ai.koog.serialization.KSerializerTypeToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-k-serializer-type-token/index.html`

### :serialization:serialization-core/commonMain

```kotlin
class KSerializerTypeToken<T>(val serializer: KSerializer<T>) : TypeToken
```

Temporary used during migration from kotlinx.serialization.KSerializer to TypeToken in public APIs.

## ai.koog.serialization.KSerializerTypeToken.serializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-k-serializer-type-token/serializer.html`

### :serialization:serialization-core/commonMain

```kotlin
val serializer: KSerializer<T>
```

## ai.koog.serialization.KotlinClassToken.KotlinClassToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-class-token/-kotlin-class-token.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(klass: KClass<*>, typeArguments: List<TypeToken> = emptyList())
```

## ai.koog.serialization.KotlinClassToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-class-token/index.html`

### :serialization:serialization-core/commonMain

```kotlin
class KotlinClassToken(val klass: KClass<*>, val typeArguments: List<TypeToken> = emptyList()) : TypeToken
```

Type token implementation based on KClass with generic type arguments information.

## ai.koog.serialization.KotlinClassToken.klass

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-class-token/klass.html`

### :serialization:serialization-core/commonMain

```kotlin
val klass: KClass<*>
```

## ai.koog.serialization.KotlinClassToken.typeArguments

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-class-token/type-arguments.html`

### :serialization:serialization-core/commonMain

```kotlin
val typeArguments: List<TypeToken>
```

## ai.koog.serialization.KotlinTypeToken.KotlinTypeToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-type-token/-kotlin-type-token.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(type: KType)
```

## ai.koog.serialization.KotlinTypeToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-type-token/index.html`

### :serialization:serialization-core/commonMain

```kotlin
class KotlinTypeToken(val type: KType) : TypeToken
```

Type token based on KType.

## ai.koog.serialization.KotlinTypeToken.type

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-kotlin-type-token/type.html`

### :serialization:serialization-core/commonMain

```kotlin
val type: KType
```

## ai.koog.serialization.TypeCapture.TypeCapture

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-type-capture/-type-capture.html`

### :serialization:serialization-core/jvmCommonMain

```kotlin
constructor()
```

## ai.koog.serialization.TypeCapture

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-type-capture/index.html`

### :serialization:serialization-core/jvmCommonMain

```kotlin
abstract class TypeCapture<T>
```

## ai.koog.serialization.TypeToken.Companion

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-type-token/-companion/index.html`

### :serialization:serialization-core/jvmCommonMain

```kotlin
object Companion
```

Factory functions to create TypeToken

## ai.koog.serialization.TypeToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/-type-token/index.html`

### :serialization:serialization-core/commonMain

```kotlin
expect sealed interface TypeToken
```

Platform-agnostic type token for runtime type representation.

Sealed interface with platform-specific implementations to enable exhaustive when expressions.

- KotlinTypeToken
- KotlinClassToken
- KSerializerTypeToken
### :serialization:serialization-core/jvmCommonMain

```kotlin
actual interface TypeToken
```

Platform-agnostic type token for runtime type representation.

Sealed interface with platform-specific implementations to enable exhaustive when expressions.

### :serialization:serialization-core/nonJvmCommonMain

```kotlin
actual interface TypeToken
```

Platform-agnostic type token for runtime type representation.

Sealed interface with platform-specific implementations to enable exhaustive when expressions.

## ai.koog.serialization.typeToken

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization/type-token.html`

### :serialization:serialization-core/commonMain

```kotlin
fun typeToken(type: KType): KotlinTypeToken
```

Creates a KotlinTypeToken from a Kotlin KType.

### :serialization:serialization-core/commonMain

```kotlin
inline fun <T> typeToken(): KotlinTypeToken
```

Creates a KotlinTypeToken from T

### :serialization:serialization-core/commonMain

```kotlin
fun typeToken(klass: KClass<*>, typeArguments: List<TypeToken> = emptyList()): KotlinClassToken
```

Creates a KotlinClassToken from a Kotlin KClass and optional generic type arguments.

## ai.koog.serialization.annotations.InternalKoogSerializationApi

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.annotations/-internal-koog-serialization-api/index.html`

### :serialization:serialization-core/commonMain

```kotlin
annotation class InternalKoogSerializationApi
```

Indicates that the annotated API is internal to serialization implementations and is not intended for public use. Symbols marked with this annotation are not guaranteed to maintain backwards compatibility.

## ai.koog.serialization.kotlinx.JSONArraySerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-array-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.JSONArraySerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-array-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): JSONArray
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONArraySerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-array-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object JSONArraySerializer : KSerializer<JSONArray>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONArraySerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-array-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: JSONArray)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONElementSerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-element-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.JSONElementSerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-element-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): JSONElement
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONElementSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-element-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object JSONElementSerializer : KSerializer<JSONElement>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONElementSerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-element-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: JSONElement)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONLiteralSerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-literal-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.JSONLiteralSerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-literal-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): JSONLiteral
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONLiteralSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-literal-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object JSONLiteralSerializer : KSerializer<JSONLiteral>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONLiteralSerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-literal-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: JSONLiteral)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONNullSerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-null-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.JSONNullSerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-null-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): JSONNull
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONNullSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-null-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object JSONNullSerializer : KSerializer<JSONNull>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONNullSerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-null-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: JSONNull)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONObjectSerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-object-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.JSONObjectSerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-object-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): JSONObject
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONObjectSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-object-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object JSONObjectSerializer : KSerializer<JSONObject>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONObjectSerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-object-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: JSONObject)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONPrimitiveSerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-primitive-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.JSONPrimitiveSerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-primitive-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): JSONPrimitive
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONPrimitiveSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-primitive-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
object JSONPrimitiveSerializer : KSerializer<JSONPrimitive>
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.JSONPrimitiveSerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-j-s-o-n-primitive-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: JSONPrimitive)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxDelegateSerializer.KotlinxDelegateSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-delegate-serializer/-kotlinx-delegate-serializer.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(delegate: JSONSerializer, typeToken: TypeToken)
```


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxDelegateSerializer.descriptor

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-delegate-serializer/descriptor.html`

### :serialization:serialization-core/commonMain

```kotlin
open override val descriptor: SerialDescriptor
```

## ai.koog.serialization.kotlinx.KotlinxDelegateSerializer.deserialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-delegate-serializer/deserialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun deserialize(decoder: Decoder): T
```

## ai.koog.serialization.kotlinx.KotlinxDelegateSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-delegate-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
class KotlinxDelegateSerializer<T>(delegate: JSONSerializer, typeToken: TypeToken) : KSerializer<T>
```

This is a bridge between library-agnostic JSONSerializer and implementations that use kotlinx-serialization.

It is convenient to use one particular serialization library, but sometimes external user inputs have to be mixed into internal data structures. This delegate addresses the problem, allowing us to continue using kotlinx-serialization while delegating serialization of user defined data to the provided JSONSerializer.

Example:


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxDelegateSerializer.serialize

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-delegate-serializer/serialize.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun serialize(encoder: Encoder, value: T)
```

## ai.koog.serialization.kotlinx.KotlinxSerializer.KotlinxSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/-kotlinx-serializer.html`

### :serialization:serialization-core/commonMain

```kotlin
constructor(json: Json = Json.Default)
```

## ai.koog.serialization.kotlinx.KotlinxSerializer.decodeFromJSONElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/decode-from-j-s-o-n-element.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun <T> decodeFromJSONElement(value: JSONElement, typeToken: TypeToken): T
```

Deserializes JSONElement to a value of type T.

deserialized value of type T

- value — JSONElement to deserialize.
- typeToken — token capturing type information of T

Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxSerializer.decodeFromString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/decode-from-string.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun <T> decodeFromString(value: String, typeToken: TypeToken): T
```

Deserializes a JSON string to a value of type T.

deserialized value of type T

- value — JSON string to deserialize
- typeToken — token capturing type information of T

Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxSerializer.encodeToJSONElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/encode-to-j-s-o-n-element.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun <T> encodeToJSONElement(value: T, typeToken: TypeToken): JSONElement
```

Serializes a value to its JSONElement representation.

JSONElement representation of the value

- value — value to serialize
- typeToken — token capturing type information of T

Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxSerializer.encodeToString

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/encode-to-string.html`

### :serialization:serialization-core/commonMain

```kotlin
open override fun <T> encodeToString(value: T, typeToken: TypeToken): String
```

Serializes a value to its JSON representation.

JSON string representation of the value

- value — value to serialize
- typeToken — token capturing type information of T

Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxSerializer

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/index.html`

### :serialization:serialization-core/commonMain

```kotlin
class KotlinxSerializer(val json: Json = Json.Default) : JSONSerializer
```

Serializer that uses kotlinx-serialization


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.KotlinxSerializer.json

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/-kotlinx-serializer/json.html`

### :serialization:serialization-core/commonMain

```kotlin
val json: Json
```

## ai.koog.serialization.kotlinx.toKoogJSONArray

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-koog-j-s-o-n-array.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JsonArray.toKoogJSONArray(): JSONArray
```

Converts kotlinx-serialization JsonArray to ai.koog.serialization.JSONArray.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKoogJSONElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-koog-j-s-o-n-element.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JsonElement.toKoogJSONElement(): JSONElement
```

Converts kotlinx-serialization JsonElement to ai.koog.serialization.JSONElement.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKoogJSONObject

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-koog-j-s-o-n-object.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JsonObject.toKoogJSONObject(): JSONObject
```

Converts kotlinx-serialization JsonObject to ai.koog.serialization.JSONObject.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKoogJSONPrimitive

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-koog-j-s-o-n-primitive.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JsonPrimitive.toKoogJSONPrimitive(): JSONPrimitive
```

Converts kotlinx-serialization JsonPrimitive to ai.koog.serialization.JSONPrimitive.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKotlinxJsonArray

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-kotlinx-json-array.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JSONArray.toKotlinxJsonArray(): JsonArray
```

Converts JSONArray to kotlinx-serialization JsonArray.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKotlinxJsonElement

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-kotlinx-json-element.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JSONElement.toKotlinxJsonElement(): JsonElement
```

Converts JSONElement to kotlinx-serialization JsonElement.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKotlinxJsonObject

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-kotlinx-json-object.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JSONObject.toKotlinxJsonObject(): JsonObject
```

Converts JSONObject to kotlinx-serialization JsonObject.


Referenced packages: `ai.koog.serialization`.

## ai.koog.serialization.kotlinx.toKotlinxJsonPrimitive

Module: `serialization-core`. Source version: `1.3.0-SNAPSHOT`.

Dokka ID: `serialization/serialization-core/ai.koog.serialization.kotlinx/to-kotlinx-json-primitive.html`

### :serialization:serialization-core/commonMain

```kotlin
fun JSONPrimitive.toKotlinxJsonPrimitive(): JsonPrimitive
```

Converts JSONPrimitive to kotlinx-serialization JsonPrimitive.


Referenced packages: `ai.koog.serialization`.
