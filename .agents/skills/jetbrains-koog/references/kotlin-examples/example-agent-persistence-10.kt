// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence10

import ai.koog.agents.core.agent.context.AIAgentContext
import ai.koog.agents.snapshot.feature.persistence
import ai.koog.prompt.message.Message.User
import ai.koog.serialization.JSONPrimitive
val customOutput = JSONPrimitive("custom-output")
val customMessageHistory = emptyList<User>()

suspend fun example(context: AIAgentContext) {
    // You can set the execution point after some node and provide an output from the node:
    context.persistence().setExecutionPointAfterNode(
        agentContext = context,
        nodePath = context.executionInfo.path(),
        messageHistory = customMessageHistory,
        output = customOutput
    )
}

