// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence06

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.snapshot.feature.Persistence
import ai.koog.agents.snapshot.providers.InMemoryPersistenceStorageProvider
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import ai.koog.agents.snapshot.feature.RollbackToolRegistry
fun createUser(name: String) {}
fun removeUser(name: String) {}
val agent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {

install(Persistence) {
    enableAutomaticPersistence = true
    rollbackToolRegistry = RollbackToolRegistry {
        // For every `createUser` tool call there will be a `removeUser` invocation in the reverse order 
        // when rolling back to the desired execution point.
        // Note: `removeUser` tool should take the same exact arguments as `createUser`. 
        // It's the developer's responsibility to make sure that `removeUser` invocation rolls back all side-effects of `createUser`:
        registerRollback(::createUser, ::removeUser)
    }
}
} 
