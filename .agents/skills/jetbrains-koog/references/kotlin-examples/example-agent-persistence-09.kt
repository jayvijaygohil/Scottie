// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentPersistence09

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.snapshot.feature.AgentCheckpointData
import ai.koog.agents.snapshot.feature.Persistence
import ai.koog.agents.snapshot.providers.PersistenceStorageProvider
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
class MyCustomStorageProvider<MyFilterType> : PersistenceStorageProvider<MyFilterType> {
    override suspend fun getCheckpoints(sessionId: String, filter: MyFilterType?): List<AgentCheckpointData> {
        TODO("Not yet implemented")
    }
    override suspend fun saveCheckpoint(sessionId: String, agentCheckpointData: AgentCheckpointData) {
        TODO("Not yet implemented")
    }
    override suspend fun getLatestCheckpoint(sessionId: String, filter: MyFilterType?): AgentCheckpointData? {
        TODO("Not yet implemented")
    }
}
val agent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {

install(Persistence) {
    storage = MyCustomStorageProvider<Any>()
}
} 
