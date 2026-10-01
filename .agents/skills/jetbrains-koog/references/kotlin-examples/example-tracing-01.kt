// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTracing01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.feature.model.events.LLMCallCompletedEvent
import ai.koog.agents.core.feature.model.events.ToolCallStartingEvent
import ai.koog.agents.features.tracing.feature.Tracing
import ai.koog.agents.features.tracing.writer.TraceFeatureMessageFileWriter;
import ai.koog.agents.features.tracing.writer.TraceFeatureMessageLogWriter
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

// Defining a logger/file that will be used as a destination of trace messages 
val logger = KotlinLogging.logger { }
val outputPath = Path("/path/to/trace.log")

// Creating an agent
val agent = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
) {
    install(Tracing) {
        // Configure message processors to handle trace events
        addMessageProcessor(TraceFeatureMessageLogWriter(logger))
        addMessageProcessor(TraceFeatureMessageFileWriter.create(outputPath))
    }
}
