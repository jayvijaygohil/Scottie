// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmClients01

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.params.LLMParams
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Create an OpenAI client
    val apiKey = System.getenv("OPENAI_API_KEY")
    val client = OpenAILLMClient(apiKey)

    // Create a prompt
    val prompt = prompt("prompt_name", LLMParams()) {
        // Add a system message to set the context
        system("You are a helpful assistant.")

        // Add a user message
        user("Tell me about Kotlin")

        // You can also add assistant messages for few-shot examples
        assistant("Kotlin is a modern programming language...")

        // Add another user message
        user("What are its key features?")
    }

    // Run the prompt
    val response = client.execute(prompt, OpenAIModels.Chat.GPT4o)
    // Print the response
    println(response)
}
