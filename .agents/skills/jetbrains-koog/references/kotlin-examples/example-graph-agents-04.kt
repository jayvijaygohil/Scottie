// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGraphAgents04

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.extension.*
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking

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

val mathAgent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
    strategy = calculatorAgentStrategy
)

fun main() = runBlocking {
    val result = mathAgent.run("Multiply 3 by 4, then multiply the result by 5, then add 10, then add 123.")
    println(result)
}
