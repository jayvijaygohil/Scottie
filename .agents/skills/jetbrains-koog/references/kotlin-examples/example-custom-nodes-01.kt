// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes01

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
typealias Input = String
typealias Output = Int
val returnValue = 42
val str = strategy<Input, Output>("my-strategy") {

val myNode by node<Input, Output>("node_name") { input ->
    // Processing
    returnValue
}
}
