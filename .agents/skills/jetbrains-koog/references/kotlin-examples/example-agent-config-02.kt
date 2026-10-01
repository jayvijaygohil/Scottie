// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentConfig02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.config.AIAgentConfig
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.prompt.params.LLMParams

val agentConfig = AIAgentConfig(
    prompt = prompt(
        id = "assistant",
        params = LLMParams(
            temperature = 0.7
        )
    ) {
        system("You are a helpful assistant.")
    },
    model = OpenAIModels.Chat.GPT4o,
    maxAgentIterations = 10
)

val agent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_API_KEY")),
    agentConfig = agentConfig
)
