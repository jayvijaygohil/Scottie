// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomStrategyGraphs07

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.ToolCalls
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults

val strategy = strategy<String, String>("strategy_name") {
    val someNode by node<String, ToolCalls> { ToolCalls(emptyList()) }

val executeMultipleTools by nodeExecuteTools(parallel = true)
val processMultipleResults by nodeLLMSendToolResults()

edge(someNode forwardTo executeMultipleTools)
edge(executeMultipleTools forwardTo processMultipleResults)
}
