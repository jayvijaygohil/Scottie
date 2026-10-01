# Serialization

The supplied 1.3.0 Dokka build includes `serialization-core`, its JSON tree, Kotlin type tokens, and Kotlinx implementation. Read [serialization contracts](api/serialization.md) for exact overloads. These Kotlin patterns are also backed by the supplied serialization guide.

Koog uses a library-independent `JSONSerializer` for tool arguments/results and feature state. The default implementation is `ai.koog.serialization.kotlinx.KotlinxSerializer`. Configure `AIAgentConfig.serializer` when changing its serialization behavior.

## Kotlin operations

Enable the Kotlin serialization compiler plugin compatible with the project's Kotlin version when using generated serializers.

```kotlin
import ai.koog.serialization.JSONElement
import ai.koog.serialization.JSONSerializer
import ai.koog.serialization.kotlinx.KotlinxSerializer
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

@Serializable
data class User(val name: String, val age: Int)

val serializer: JSONSerializer = KotlinxSerializer()
val json: String = serializer.encodeToString(User("Alice", 30), typeToken<User>())
val user: User = serializer.decodeFromString(json, typeToken<User>())
val element: JSONElement = serializer.encodeToJSONElement(user, typeToken<User>())
val restored: User = serializer.decodeFromJSONElement(element, typeToken<User>())
val encodedElement: String = serializer.encodeJSONElementToString(element)
val decodedElement: JSONElement = serializer.decodeJSONElementFromString(encodedElement)
```

`typeToken<T>()` supplies runtime type information to Koog. It is distinct from directly calling a kotlinx `KSerializer<T>`, which some structured-output APIs take explicitly.

## JSON trees and state

Koog's `JSONElement`, `JSONObject`, `JSONArray`, and `JSONPrimitive` are distinct from kotlinx `JsonElement` types. Use the `toKoogJSONElement` and `toKotlinxJsonElement` conversions from `ai.koog.serialization.kotlinx` when crossing that boundary. Preserve generic element types with `typeToken<List<User>>()`; do not erase them to a raw collection type.

Use the constructors and serializer fields in [tools](api/tools.md), [agent configuration](api/agent-lifecycle.md), and [persistence](api/persistence.md) with this layer. An object that works in memory is not automatically persistable: round-trip the relevant custom values with the configured serializer.
