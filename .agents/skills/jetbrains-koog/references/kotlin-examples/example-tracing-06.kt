// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTracing06

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.feature.remote.server.config.DefaultServerConnectionConfig
import ai.koog.agents.features.tracing.feature.Tracing
import ai.koog.agents.features.tracing.writer.TraceFeatureMessageRemoteWriter
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking
const val input = "What's the weather like in New York?"
const val port = 4991
const val host = "localhost"
fun main() {
   runBlocking {

val connectionConfig = DefaultServerConnectionConfig(host = host, port = port)
val writer = TraceFeatureMessageRemoteWriter(connectionConfig)

// Creating an agent
val agent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {
    install(Tracing) {
        addMessageProcessor(writer)
    }
}

// Run the agent
agent.run(input)

// Writer will be automatically closed when the block exits
   }
}
