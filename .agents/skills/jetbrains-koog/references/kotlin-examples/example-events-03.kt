// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleEvents03

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.feature.model.events.NodeExecutionStartingEvent
import ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent
import ai.koog.agents.core.feature.message.FeatureMessage
import ai.koog.agents.core.feature.message.FeatureMessageProcessor
import ai.koog.agents.features.tracing.feature.Tracing
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
fun main() {
runBlocking {

class CustomTraceProcessor : FeatureMessageProcessor() {

    override suspend fun processMessage(message: FeatureMessage) {
        // Custom processing logic
        if (message is NodeExecutionStartingEvent) {
            // Process node start event
        } else if (message is LLMCallCompletedEvent) {
            // Process LLM call end event
        } else {
            // Handle other event types
        }
    }

    override suspend fun close() {
        // Close connections if established
    }
}

val agent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {
    install(Tracing) {
        // Use your custom processor
        addMessageProcessor(CustomTraceProcessor())
    }
}
    }
}
