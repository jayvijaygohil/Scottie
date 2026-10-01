// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleBasic03

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool

@Tool
@LLMDescription("Ask the user a question by sending it to stdout and return the answer from stdin")
fun askUser(
    @LLMDescription("Question from the agent")
    question: String
): String {
    println(question)
    return readln()
}

val agent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(System.getenv("YOUR_API_KEY")),
    systemPrompt = "You are an expert in internet memes. Be helpful, friendly, and answer user questions concisely, showing your knowledge of memes.",
    llmModel = OpenAIModels.Chat.GPT4o,
    temperature = 0.7,
    toolRegistry = ToolRegistry {
        tool(::askUser)
    }
)
