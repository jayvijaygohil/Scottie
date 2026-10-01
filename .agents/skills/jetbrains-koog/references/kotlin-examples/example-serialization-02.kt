// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization02

import ai.koog.serialization.typeToken

data class MyClass(val value: String)

// Inline reified — preferred in Kotlin
val tokenReified = typeToken<MyClass>()

// From a KClass (when no reified type parameter is available)
val tokenKClass = typeToken(MyClass::class)

// Generic type — preserves type arguments at runtime
val tokenGeneric = typeToken<List<String>>()
