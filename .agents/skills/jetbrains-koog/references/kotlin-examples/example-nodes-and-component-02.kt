// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent02

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeDoNothing
val strategy = strategy<String, String>("strategy_name") {

val passthrough by nodeDoNothing<String>("passthrough")

edge(nodeStart forwardTo passthrough)
edge(passthrough forwardTo nodeFinish)
}
