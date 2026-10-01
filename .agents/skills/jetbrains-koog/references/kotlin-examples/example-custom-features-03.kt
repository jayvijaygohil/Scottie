// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomFeatures03

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.feature.handler.AgentLifecycleEventType
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.agents.features.tracing.feature.Tracing

typealias MyFeature = Tracing

suspend fun main() {
    val agent = AIAgent(
        promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_API_KEY")),
        systemPrompt = "You are a helpful assistant. Answer user questions concisely.",
        llmModel = OpenAIModels.Chat.GPT4o
    ) {
        install(Tracing) {

install(MyFeature) {
    setEventFilter { context ->
        context.eventType is AgentLifecycleEventType.LLMCallStarting ||
            context.eventType is AgentLifecycleEventType.LLMCallCompleted
    }
}
        }
    }
}
