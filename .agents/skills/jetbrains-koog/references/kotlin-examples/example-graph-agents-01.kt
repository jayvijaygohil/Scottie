// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGraphAgents01

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.extension.*

val calculatorAgentStrategy = strategy<String, String>("Simple calculator") {
    val nodeSendInput by nodeLLMRequest()
    val nodeExecuteTool by nodeExecuteTools()
    val nodeSendToolResult by nodeLLMSendToolResults()
    
    edge(nodeStart forwardTo nodeSendInput)
    edge(nodeSendInput forwardTo nodeFinish onTextMessage { true })
    edge(nodeSendInput forwardTo nodeExecuteTool onToolCalls { true })
    edge(nodeExecuteTool forwardTo nodeSendToolResult)
    edge(nodeSendToolResult forwardTo nodeFinish onTextMessage { true })
    edge(nodeSendToolResult forwardTo nodeExecuteTool onToolCalls { true })
}
