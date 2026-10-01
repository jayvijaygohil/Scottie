// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi05

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val title: String,
    val author: String,
    val description: String
)
