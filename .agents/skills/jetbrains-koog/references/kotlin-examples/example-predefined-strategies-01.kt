// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.examplePredefinedStrategies01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.agents.ext.agent.chatAgentStrategy
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.prompt.executor.clients.openai.OpenAIModels

val apiKey = System.getenv("OPENAI_API_KEY") ?: error("Please set OPENAI_API_KEY environment variable")
val promptExecutor =simpleOpenAIExecutor(apiKey)
val toolRegistry = ToolRegistry.EMPTY
val model =  OpenAIModels.Chat.O4Mini

val chatAgent = AIAgent(
    promptExecutor = promptExecutor,
    toolRegistry = toolRegistry,
    llmModel = model,
    // Set chatAgentStrategy as the agent strategy
    strategy = chatAgentStrategy()
)
