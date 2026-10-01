// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentClientProtocol02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.config.AIAgentConfig
import ai.koog.agents.features.acp.AcpAgent
import ai.koog.agents.features.acp.toKoogMessage
import ai.koog.prompt.Prompt
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.model.PromptExecutor
import com.agentclientprotocol.agent.AgentSession
import com.agentclientprotocol.common.Event
import com.agentclientprotocol.model.ContentBlock
import com.agentclientprotocol.model.SessionId
import com.agentclientprotocol.protocol.Protocol
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import ai.koog.utils.time.KoogClock
import kotlinx.serialization.json.JsonElement

class MyAgentSession(
    override val sessionId: SessionId,
    private val promptExecutor: PromptExecutor,
    private val protocol: Protocol,
    private val clock: KoogClock
) : AgentSession {

    private var agentJob: Deferred<Unit>? = null
    private val agentMutex = Mutex()

    override suspend fun prompt(
        content: List<ContentBlock>,
        _meta: JsonElement?
    ): Flow<Event> = channelFlow {
        val agentConfig = AIAgentConfig(
            prompt = prompt("acp") {
                system("You are a helpful assistant.")
            }.appendPrompt(content),
            model = OpenAIModels.Chat.GPT4o,
            maxAgentIterations = 1000
        )

        // Ensure only one agent session runs at a time
        agentMutex.withLock {
            val agent = AIAgent(
                promptExecutor = promptExecutor,
                agentConfig = agentConfig
            ) {
                install(AcpAgent) {
                    this.sessionId = this@MyAgentSession.sessionId.value
                    this.protocol = this@MyAgentSession.protocol
                    this.eventsProducer = this@channelFlow
                    this.setDefaultNotifications = true
                }
            }

            agentJob = async { agent.run("Hello. How can you help me?") }
            agentJob?.await()
        }
    }

    private fun Prompt.appendPrompt(content: List<ContentBlock>): Prompt {
        return withMessages { messages ->
            messages + listOf(content.toKoogMessage(clock))
        }
    }

    override suspend fun cancel() {
        agentJob?.cancel()
    }
}
