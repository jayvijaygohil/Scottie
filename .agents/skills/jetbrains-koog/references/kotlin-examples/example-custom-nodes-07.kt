// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes07

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
val strategy = strategy<String, String>("strategy_name") {

val stringToIntNode by node<String, Int>("node_name") { input: String ->
    // Processing
    input.toInt() // Convert string to integer
}
}
