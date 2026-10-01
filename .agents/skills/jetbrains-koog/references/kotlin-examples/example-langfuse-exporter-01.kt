// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLangfuseExporter01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.agents.features.opentelemetry.integration.langfuse.addLangfuseExporter
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import kotlinx.coroutines.runBlocking
val promptExecutor = simpleOpenAIExecutor("openai-api-key")

fun main() = runBlocking {
    val agent = AIAgent(
        promptExecutor = promptExecutor,
        llmModel = OpenAIModels.Chat.GPT4oMini,
        systemPrompt = "You are a code assistant. Provide concise code examples."
    ) {
        install(OpenTelemetry) {
            addLangfuseExporter()
        }
    }

    println("Running agent with Langfuse tracing")

    val result = agent.run("Tell me a joke about programming")
    println("Result: $result\nSee traces on the Langfuse instance")
}
