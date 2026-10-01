// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes09

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
val strategy = strategy<String, String>("strategy_name") {

val upperCaseNode by node<String, String>("node_name") { input ->
    println("Processing input: $input")
    input.uppercase() // Transform the input to uppercase
}
}
