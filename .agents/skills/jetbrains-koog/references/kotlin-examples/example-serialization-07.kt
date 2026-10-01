// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization07

import ai.koog.serialization.JSONElement
import ai.koog.serialization.JSONObject
import ai.koog.serialization.JSONPrimitive
import ai.koog.serialization.jackson.toJacksonJsonNode
import ai.koog.serialization.jackson.toKoogJSONElement
import com.fasterxml.jackson.databind.JsonNode

val koogJson: JSONElement = JSONObject(
    mapOf(
        "key" to JSONPrimitive("value")
    )
)

// Convert to Jackson dynamic JSON instance
val jacksonJson: JsonNode = koogJson.toJacksonJsonNode()

// Convert to Koog dynamic JSON instance
val koogJsonConverted: JSONElement = jacksonJson.toKoogJSONElement()
