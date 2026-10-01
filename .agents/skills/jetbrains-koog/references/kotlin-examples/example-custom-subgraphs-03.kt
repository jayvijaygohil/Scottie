// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomSubgraphs03

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.*
import ai.koog.agents.ext.tool.AskUser
import ai.koog.agents.ext.tool.SayToUser
val firstTool = SayToUser
val secondTool = AskUser
val strategy =

strategy<String, String>("my-strategy") {
   val mySubgraph by subgraph<String, String>(
      tools = listOf(firstTool, secondTool)
   ) {
        // Define nodes and edges for this subgraph
        val sendInput by nodeLLMRequest()
        val executeToolCall by nodeExecuteTools()
        val sendToolResult by nodeLLMSendToolResults()

        edge(nodeStart forwardTo sendInput)
        edge(sendInput forwardTo executeToolCall onToolCalls { true })
        edge(executeToolCall forwardTo sendToolResult)
        edge(sendToolResult forwardTo nodeFinish onTextMessage { true })
    }
}
