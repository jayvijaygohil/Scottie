// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization05

import ai.koog.serialization.JSONElement
import ai.koog.serialization.JSONObject
import ai.koog.serialization.JSONPrimitive
import ai.koog.serialization.kotlinx.toKoogJSONElement
import ai.koog.serialization.kotlinx.toKotlinxJsonElement
import kotlinx.serialization.json.JsonElement

val koogJson: JSONElement = JSONObject(
    mapOf(
        "key" to JSONPrimitive("value")
    )
)

// Convert to kotlinx-serialization dynamic JSON instance
val kotlinxJson: JsonElement = koogJson.toKotlinxJsonElement()

// Convert to Koog dynamic JSON instance
val koogJsonConverted: JSONElement = kotlinxJson.toKoogJSONElement()
