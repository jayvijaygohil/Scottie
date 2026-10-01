// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent10

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
val strategy = strategy<String, String>("strategy_name") {

val executeTools by nodeExecuteTools(parallel = true)
val sendToolResultsToLLM by nodeLLMSendToolResults()
edge(executeTools forwardTo sendToolResultsToLLM)
}
