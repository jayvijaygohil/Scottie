// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization04

import ai.koog.serialization.kotlinx.KotlinxSerializer
import kotlinx.serialization.json.Json

// Default instance — uses Json.Default
val defaultSerializer = KotlinxSerializer()

// Custom Json configuration
val customSerializer = KotlinxSerializer(
    json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }
)
