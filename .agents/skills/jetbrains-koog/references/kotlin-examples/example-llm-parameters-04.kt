// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters04

import ai.koog.prompt.params.LLMParams
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive

// Create parameters with a basic JSON schema
val jsonParams = LLMParams(
    temperature = 0.2,
    schema = LLMParams.Schema.JSON.Basic(
        name = "PersonInfo",
        schema = JsonObject(mapOf(
            "type" to JsonPrimitive("object"),
            "properties" to JsonObject(
                mapOf(
                    "name" to JsonObject(mapOf("type" to JsonPrimitive("string"))),
                    "age" to JsonObject(mapOf("type" to JsonPrimitive("number"))),
                    "skills" to JsonObject(
                        mapOf(
                            "type" to JsonPrimitive("array"),
                            "items" to JsonObject(mapOf("type" to JsonPrimitive("string")))
                        )
                    )
                )
            ),
            "additionalProperties" to JsonPrimitive(false),
            "required" to JsonArray(listOf(JsonPrimitive("name"), JsonPrimitive("age"), JsonPrimitive("skills")))
        ))
    )
)
