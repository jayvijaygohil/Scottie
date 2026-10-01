// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleSerialization08

import ai.koog.agents.core.agent.config.AIAgentConfig
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.serialization.jackson.JacksonSerializer

val agentConfig = AIAgentConfig(
    prompt = prompt("assistant") {
        system("You are a helpful assistant.")
    },
    model = OpenAIModels.Chat.GPT4o,
    maxAgentIterations = 10,
    serializer = JacksonSerializer()
)
