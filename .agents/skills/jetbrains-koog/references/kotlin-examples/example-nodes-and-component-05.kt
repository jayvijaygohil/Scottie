// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent05

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeDoNothing
val strategy = strategy<String, String>("strategy_name") {
    val getComplexUserQuestion by nodeDoNothing<String>()

val requestLLMMultipleTools by nodeLLMRequest()
edge(getComplexUserQuestion forwardTo requestLLMMultipleTools)
}
