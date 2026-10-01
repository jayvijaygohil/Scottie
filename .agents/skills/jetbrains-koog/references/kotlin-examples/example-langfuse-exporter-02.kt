// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
@file:OptIn(kotlin.uuid.ExperimentalUuidApi::class)

package ai.koog.agents.example.exampleLangfuseExporter02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.attribute.CustomAttribute
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.agents.features.opentelemetry.integration.langfuse.addLangfuseExporter
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import kotlinx.coroutines.runBlocking
import kotlin.uuid.Uuid
val promptExecutor = simpleOpenAIExecutor("openai-api-key")

fun main() = runBlocking {
    val sessionId = Uuid.random().toString()

    val agent = AIAgent(
        promptExecutor = promptExecutor,
        llmModel = OpenAIModels.Chat.GPT4oMini,
        systemPrompt = "You are a helpful assistant."
    ) {
        install(OpenTelemetry) {
            addLangfuseExporter(
                traceAttributes = listOf(
                    CustomAttribute("langfuse.session.id", sessionId),
                    CustomAttribute("langfuse.trace.tags", listOf("chat", "kotlin", "production"))
                )
            )
        }
    }

    println("Running agent with Langfuse tracing")

    // Multiple runs with the same session ID will be grouped in Langfuse
    agent.run("What is Kotlin?")
    agent.run("Show me a coroutine example")
}
