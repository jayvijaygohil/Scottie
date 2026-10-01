// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomNodes02

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
val str = strategy<String, Int>("my-strategy") {

val myNode by node<String, Int>("node_name") { input ->
    // Processing
    input.length
}
}
