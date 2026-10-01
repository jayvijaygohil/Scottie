// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHistoryCompression01

import ai.koog.agents.core.agent.context.AIAgentContext
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMCompressHistory
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
import ai.koog.agents.core.dsl.extension.onTextMessage
import ai.koog.agents.core.dsl.extension.onToolCalls
import ai.koog.agents.core.dsl.extension.ReceivedToolResults

// Define that the history is too long if there are more than 100 messages
private suspend fun AIAgentContext.historyIsTooLong(): Boolean = llm.readSession { prompt.messages.size > 100 }

val strategy = strategy<String, String>("execute-with-history-compression") {
    val callLLM by nodeLLMRequest()
    val executeTool by nodeExecuteTools()
    val sendToolResult by nodeLLMSendToolResults()

    // Compress the LLM history and keep the current ReceivedToolResults for the next node
    val compressHistory by nodeLLMCompressHistory<ReceivedToolResults>()

    edge(nodeStart forwardTo callLLM)
    edge(callLLM forwardTo nodeFinish onTextMessage { true })
    edge(callLLM forwardTo executeTool onToolCalls { true })

    // Compress history after executing any tool if the history is too long 
    edge(executeTool forwardTo compressHistory onCondition { historyIsTooLong() })
    edge(compressHistory forwardTo sendToolResult)
    // Otherwise, proceed to the next LLM request
    edge(executeTool forwardTo sendToolResult onCondition { !historyIsTooLong() })

    edge(sendToolResult forwardTo executeTool onToolCalls { true })
    edge(sendToolResult forwardTo nodeFinish onTextMessage { true })
}
