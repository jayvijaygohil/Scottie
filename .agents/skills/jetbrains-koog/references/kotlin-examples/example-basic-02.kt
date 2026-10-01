// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleBasic02

import ai.koog.agents.core.agent.AIAgent
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor

val agent = AIAgent(
    promptExecutor = simpleOpenAIExecutor(System.getenv("YOUR_API_KEY")),
    systemPrompt = "You are an expert in internet memes. Be helpful, friendly, and answer user questions concisely, showing your knowledge of memes.",
    llmModel = OpenAIModels.Chat.GPT4o
)
