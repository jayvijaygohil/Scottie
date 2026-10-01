// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleOpentelemetrySupport04

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.opentelemetry.feature.OpenTelemetry
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
val promptExecutor = simpleOpenAIExecutor("openai-api-key")
val agent = AIAgent(
    promptExecutor = promptExecutor,
    llmModel = OpenAIModels.Chat.GPT4o,
    systemPrompt = "You are a helpful assistant.",
    installFeatures = {
        install(OpenTelemetry) {

addResourceAttributes(mapOf(
    "custom.attribute" to "custom-value")
)
        }
    }
)
