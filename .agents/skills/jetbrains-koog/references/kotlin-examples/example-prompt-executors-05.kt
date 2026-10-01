// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.examplePromptExecutors05

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import kotlinx.coroutines.runBlocking
fun main() {
    runBlocking {

// Create an OpenAI executor
val promptExecutor = simpleOpenAIExecutor("OPENAI_API_KEY")

// Execute a prompt
val response = promptExecutor.execute(
    prompt = prompt("demo") { user("Summarize this.") },
    model = OpenAIModels.Chat.GPT4o
)
    }
}
