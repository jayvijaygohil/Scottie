// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomStrategyGraphs06

import ai.koog.agents.core.agent.asMermaidDiagram
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
import ai.koog.agents.core.dsl.extension.onTextMessage
import ai.koog.agents.core.dsl.extension.onToolCalls
fun main() {
    val myStrategy = strategy<String, String>("my-strategy") {
        val nodeCallLLM by nodeLLMRequest()
        val executeToolCall by nodeExecuteTools()
        val sendToolResult by nodeLLMSendToolResults()
        edge(nodeStart forwardTo nodeCallLLM)
        edge(nodeCallLLM forwardTo nodeFinish onTextMessage { true })
        edge(nodeCallLLM forwardTo executeToolCall onToolCalls { true })
        edge(executeToolCall forwardTo sendToolResult)
        edge(sendToolResult forwardTo nodeFinish onTextMessage { true })
        edge(sendToolResult forwardTo executeToolCall onToolCalls { true })
    }

val mermaidDiagram: String = myStrategy.asMermaidDiagram()

println(mermaidDiagram)
}
