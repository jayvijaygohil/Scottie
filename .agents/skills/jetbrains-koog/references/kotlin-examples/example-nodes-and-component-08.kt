// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent08

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
val strategy = strategy<String, String>("strategy_name") {

val executeTool by nodeExecuteTools()
val sendToolResultToLLM by nodeLLMSendToolResults()
edge(executeTool forwardTo sendToolResultToLLM)
}
