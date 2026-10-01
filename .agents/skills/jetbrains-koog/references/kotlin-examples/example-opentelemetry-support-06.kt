// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleOpentelemetrySupport06

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter
val promptExecutor = simpleOpenAIExecutor("openai-api-key")
const val AUTH_STRING = ""
val agent = AIAgent(
    promptExecutor = promptExecutor,
    llmModel = OpenAIModels.Chat.GPT4o,
    systemPrompt = "You are a helpful assistant."
) {

install(OpenTelemetry) {
    // Add OpenTelemetry HTTP exporter 
    addSpanExporter(
        OtlpHttpSpanExporter.builder()
            // Set the maximum time to wait for the collector to process an exported batch of spans 
            .setTimeout(30, enumValueOf("SECONDS"))
            // Set the OpenTelemetry endpoint to connect to
            .setEndpoint("http://localhost:3000/api/public/otel/v1/traces")
            // Add the authorization header
            .addHeader("Authorization", "Basic $AUTH_STRING")
            .build()
    )
}
}
