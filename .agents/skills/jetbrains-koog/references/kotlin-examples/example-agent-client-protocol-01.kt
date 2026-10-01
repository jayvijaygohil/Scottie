// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentClientProtocol01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.features.acp.AcpAgent
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor

val agent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_API_KEY")),
    llmModel = OpenAIModels.Chat.GPT4o
) {
    install(AcpAgent) {
        this.sessionId = sessionId
        this.protocol = protocol
        this.eventsProducer = eventsProducer
        this.setDefaultNotifications = true
    }
}
