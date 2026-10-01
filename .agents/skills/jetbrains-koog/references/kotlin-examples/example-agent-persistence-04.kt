// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence04

import ai.koog.agents.core.agent.context.AIAgentContext
import ai.koog.agents.snapshot.feature.persistence
import ai.koog.serialization.typeToken
const val outputData = "some-output-data"
val outputType = typeToken<String>()

suspend fun example(context: AIAgentContext) {
    // Create a checkpoint with the current state
    val checkpoint = context.persistence().createCheckpointAfterNode(
        agentContext = context,
        nodePath = context.executionInfo.path(),
        lastOutput = outputData,
        lastOutputType = outputType,
        checkpointId = context.runId,
        version = 0L
    )

    // The checkpoint ID can be stored for later use
    val checkpointId = checkpoint?.checkpointId
}
