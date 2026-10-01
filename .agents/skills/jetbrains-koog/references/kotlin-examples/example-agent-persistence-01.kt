// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.snapshot.feature.Persistence
import ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import ai.koog.agents.core.agent.context.RollbackStrategy
val executor = simpleOllamaAIExecutor()

val agent = AIAgent(
    promptExecutor = executor,
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {
    install(Persistence) {
        // Use in-memory storage for snapshots
        storage = InMemoryPersistenceStorageProvider()
    }
}
