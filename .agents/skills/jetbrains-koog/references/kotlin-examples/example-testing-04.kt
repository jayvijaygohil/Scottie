// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting04

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.example.exampleTesting03.mockLLMApi
import ai.koog.agents.example.exampleTesting02.toolRegistry
import ai.koog.agents.testing.feature.withTesting
import ai.koog.prompt.executor.clients.openai.OpenAIModels
val llmModel = OpenAIModels.Chat.GPT4o
// Create the agent with testing enabled
fun main() {

// Create the agent with testing enabled
AIAgent(
    promptExecutor = mockLLMApi,
    toolRegistry = toolRegistry,
    llmModel = llmModel
) {
    // Enable testing mode
    withTesting()
}
}
