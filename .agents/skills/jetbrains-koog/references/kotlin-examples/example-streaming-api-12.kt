// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi12

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.example.exampleStreamingApi10.BookTool
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor

val toolRegistry = ToolRegistry {
    tool(BookTool())
}

val runner = AIAgent(
    promptExecutor = simpleOpenAIExecutor("OPENAI_API_KEY"),
    llmModel = OpenAIModels.Chat.GPT4o,
    toolRegistry = toolRegistry
)
