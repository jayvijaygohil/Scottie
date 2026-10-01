// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent13

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.prompt.message.MessagePart
val strategy = strategy<String, Int>("strategy_name") {

val lengthNode by nodeLLMRequest("llmRequest").transform<Int> { assistantMessage ->
    assistantMessage.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }.length
}

edge(nodeStart forwardTo lengthNode)
edge(lengthNode forwardTo nodeFinish)
}
