// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmClients02

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.streaming.StreamFrame
import kotlinx.coroutines.runBlocking
fun main() = runBlocking {

// Set up the OpenAI client with your API key
val token = System.getenv("OPENAI_API_KEY")
val client = OpenAILLMClient(token)

val response = client.executeStreaming(
    prompt = prompt("stream_demo") { user("Stream this response in short chunks.") },
    model = OpenAIModels.Chat.GPT4_1
)

response.collect { frame ->
    when (frame) {
        is StreamFrame.TextDelta -> print(frame.text)
        is StreamFrame.ReasoningDelta -> print("[Reasoning] ${frame.text}")
        is StreamFrame.ToolCallComplete -> println("\nTool call: ${frame.name}")
        is StreamFrame.End -> println("\n[done] Reason: ${frame.finishReason}")
        else -> {} // Handle other frame types if needed
    }
}
}
