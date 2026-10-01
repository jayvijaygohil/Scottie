// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleDatadogExporter02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.agents.features.opentelemetry.integration.datadog.addDatadogExporter
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import kotlinx.coroutines.runBlocking
val promptExecutor = simpleOpenAIExecutor("openai-api-key")

fun main() = runBlocking {
    val agent = AIAgent(
        promptExecutor = promptExecutor,
        llmModel = OpenAIModels.Chat.GPT4oMini,
        systemPrompt = "You are a helpful assistant."
    ) {
        install(OpenTelemetry) {
            addDatadogExporter(
                url = "datadoghq.eu",  // Use EU region
                resourceAttributes = mapOf(
                    "env" to "production",
                    "service.name" to "my-agent",
                    "version" to "1.0.0"
                )
            )
        }
    }

    println("Running agent with Datadog tracing")

    agent.run("What is Kotlin?")
}
