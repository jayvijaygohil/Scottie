// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence07

import ai.koog.agents.core.agent.context.AIAgentContext
import ai.koog.agents.example.exampleAgentPersistence04.outputData
import ai.koog.agents.example.exampleAgentPersistence04.outputType
import ai.koog.agents.snapshot.feature.persistence
import ai.koog.agents.snapshot.feature.withPersistence

suspend fun example(context: AIAgentContext) {
    // Access the checkpoint feature
    val checkpointFeature = context.persistence()

    // Or perform an action with the checkpoint feature
    context.withPersistence { ctx ->
        // 'this' is the checkpoint feature
        createCheckpointAfterNode(
            agentContext = ctx,
            nodePath = ctx.executionInfo.path(),
            lastOutput = outputData,
            lastOutputType = outputType,
            checkpointId = ctx.runId,
            version = 0L
        )
    }
}
