// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleWeaveExporter01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.agents.features.opentelemetry.integration.weave.addWeaveExporter
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import kotlinx.coroutines.runBlocking
val promptExecutor = simpleOpenAIExecutor("openai-api-key")

fun main() = runBlocking {
    val entity = System.getenv()["WEAVE_ENTITY"] 
        ?: throw IllegalArgumentException("WEAVE_ENTITY is not set")
    
    val projectName = System.getenv()["WEAVE_PROJECT_NAME"] 
        ?: "koog-tracing"
    
    val agent = AIAgent(
        promptExecutor = promptExecutor,
        llmModel = OpenAIModels.Chat.GPT4oMini,
        systemPrompt = "You are a code assistant. Provide concise code examples."
    ) {
        install(OpenTelemetry) {
            addWeaveExporter()
        }
    }

    println("Running agent with Weave tracing")

    val result = agent.run("Tell me a joke about programming")
    println("Result: $result\nSee traces on https://wandb.ai/$entity/$projectName/weave/traces")
}
