// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence05

import ai.koog.agents.core.agent.context.AIAgentContext
import ai.koog.agents.snapshot.feature.persistence

suspend fun example(context: AIAgentContext, checkpointId: String) {
    // Roll back to a specific checkpoint
    context.persistence().rollbackToCheckpoint(checkpointId, context)

    // Or roll back to the latest checkpoint
    context.persistence().rollbackToLatestCheckpoint(context)
}
