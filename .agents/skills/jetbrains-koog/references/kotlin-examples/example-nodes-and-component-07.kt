// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent07

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.onToolCalls
val strategy = strategy<String, String>("strategy_name") {

val requestLLM by nodeLLMRequest()
val executeTool by nodeExecuteTools()
edge(requestLLM forwardTo executeTool onToolCalls { true })
}
