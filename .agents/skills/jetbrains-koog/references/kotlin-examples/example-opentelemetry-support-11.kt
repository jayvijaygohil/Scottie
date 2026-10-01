// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleOpentelemetrySupport11

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.utils.io.use
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import io.opentelemetry.exporter.logging.LoggingSpanExporter
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter
import kotlinx.coroutines.runBlocking
val promptExecutor = simpleOpenAIExecutor("openai-api-key")

fun main() = runBlocking {
    val agent = AIAgent(
        promptExecutor = promptExecutor,
        llmModel = OpenAIModels.Chat.O4Mini,
        systemPrompt = "You are a code assistant. Provide concise code examples."
    ) {
        install(OpenTelemetry) {
            // Add a console logger for local debugging
            addSpanExporter(LoggingSpanExporter.create())

            // Send traces to OpenTelemetry collector
            addSpanExporter(
                OtlpGrpcSpanExporter.builder()
                    .setEndpoint("http://localhost:4317")
                    .build()
            )
        }
    }

    agent.use { agent ->
        println("Running the agent with OpenTelemetry tracing...")

        val result = agent.run("Tell me a joke about programming")

        println("Agent run completed with result: '$result'." +
                "\nCheck Jaeger UI at http://localhost:16686 to view traces")
    }
}
