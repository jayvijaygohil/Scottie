// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization03

import ai.koog.serialization.JSONArray
import ai.koog.serialization.JSONLiteral
import ai.koog.serialization.JSONNull
import ai.koog.serialization.JSONObject
import ai.koog.serialization.JSONPrimitive

val obj = JSONObject(
    mapOf(
        "name" to JSONPrimitive("Alice"),
        "age" to JSONPrimitive(30),
        "active" to JSONPrimitive(true),
    )
)

val arr = JSONArray(listOf(JSONPrimitive(1), JSONPrimitive(2), JSONPrimitive(3)))

// Reading values from an object
val nameContent: String = (obj.entries["name"] as JSONPrimitive).content  // "Alice"
val age: Int? = (obj.entries["age"] as JSONPrimitive).intOrNull // 30
