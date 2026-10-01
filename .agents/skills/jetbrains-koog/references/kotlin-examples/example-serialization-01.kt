// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization01

import ai.koog.serialization.JSONElement
import ai.koog.serialization.JSONSerializer
import ai.koog.serialization.kotlinx.KotlinxSerializer
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

@Serializable
data class User(val name: String, val age: Int)

val serializer: JSONSerializer = KotlinxSerializer()

// Encode a data class to a JSON string
val json: String = serializer.encodeToString(User("Alice", 30), typeToken<User>())

// Decode a JSON string back to a data class
val user: User = serializer.decodeFromString(json, typeToken<User>())

// Encode to a JSONElement tree
val element: JSONElement = serializer.encodeToJSONElement(user, typeToken<User>())

// Decode from a JSONElement tree
val userFromElement: User = serializer.decodeFromJSONElement(element, typeToken<User>())

// Convert between JSONElement and a raw JSON string
val jsonString = """{"key": "value"}"""
val jsonElement: JSONElement = serializer.decodeJSONElementFromString(jsonString)
val backToString: String = serializer.encodeJSONElementToString(jsonElement)
