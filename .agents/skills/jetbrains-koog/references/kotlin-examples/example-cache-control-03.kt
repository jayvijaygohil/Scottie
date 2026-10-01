// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl03

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import ai.koog.prompt.message.MessagePart
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = AnthropicLLMClient(System.getenv("ANTHROPIC_API_KEY"))

val prompt = prompt("conversation") {
    system("You are a helpful assistant.")
    // Cache after a large user message (e.g. document content)
    user(listOf(MessagePart.Text("Here is a long document: ...", cacheControl = AnthropicCacheControl.Default)))
    assistant(listOf(MessagePart.Text("I have read the document.")))
    user("Summarize it.")
}

val response = client.execute(prompt, AnthropicModels.Sonnet_4)
println(response)
}
