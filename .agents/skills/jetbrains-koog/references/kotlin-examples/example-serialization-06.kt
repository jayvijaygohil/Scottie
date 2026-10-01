// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization06

import ai.koog.serialization.jackson.JacksonSerializer
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

// Default instance — uses a fresh ObjectMapper with JSONElementModule pre-registered
val defaultSerializer = JacksonSerializer()

// Custom ObjectMapper configuration
val customSerializer = JacksonSerializer(
    objectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
)
