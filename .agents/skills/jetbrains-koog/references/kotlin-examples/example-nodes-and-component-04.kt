// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent04

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeDoNothing
val strategy = strategy<String, String>("strategy_name") {
    val getUserQuestion by nodeDoNothing<String>()

val requestLLM by nodeLLMRequest("requestLLM")
edge(getUserQuestion forwardTo requestLLM)
}
