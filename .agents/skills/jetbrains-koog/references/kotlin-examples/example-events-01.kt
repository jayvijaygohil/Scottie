// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleEvents01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent
import ai.koog.agents.core.feature.model.events.LLMCallStartingEvent
import ai.koog.agents.example.exampleTracing01.outputPath
import ai.koog.agents.features.tracing.feature.Tracing
import ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking
const val input = "What's the weather like in New York?"
fun main() {
runBlocking {
// Creating an agent
val agent = AIAgent(
promptExecutor = simpleOllamaAIExecutor(),
llmModel = OllamaModels.Meta.LLAMA_3_2,
) {

install(Tracing) {
    val fileWriter = TraceFeatureMessageFileWriter.create(outputPath)
    addMessageProcessor(fileWriter)
    
    // Only trace LLM calls
    fileWriter.setMessageFilter { message ->
        message is LLMCallStartingEvent || message is LLMCallCompletedEvent
    }
}
        }
    }
}
