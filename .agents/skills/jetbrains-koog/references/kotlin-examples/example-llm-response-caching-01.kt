// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmResponseCaching01

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.cached.CachedPromptExecutor
import ai.koog.prompt.cache.files.FilePromptCache
import ai.koog.prompt.message.MessagePart
import kotlin.system.measureTimeMillis
import ai.koog.prompt.dsl.prompt
import kotlin.io.path.Path
import kotlinx.coroutines.runBlocking
fun main() {
    runBlocking {
        val prompt = prompt("test") {
            user("Hello")
        }

// Create a prompt executor
val client = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
val promptExecutor = MultiLLMPromptExecutor(client)

// Create a cached prompt executor
val cachedExecutor = CachedPromptExecutor(
    cache = FilePromptCache(Path("path/to/your/cache/directory")),
    nested = promptExecutor
)

// Run cached prompt executor for the first time
// This will perform an actual LLM request
val firstTime = measureTimeMillis {
    val firstResponse = cachedExecutor.execute(prompt, OpenAIModels.Chat.GPT4o)
    val text = firstResponse.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
    println("First response: $text")
}
println("First execution took: ${firstTime}ms")

// Run cached prompt executor for the second time
// This will return the result immediately from the cache
val secondTime = measureTimeMillis {
    val secondResponse = cachedExecutor.execute(prompt, OpenAIModels.Chat.GPT4o)
    val text = secondResponse.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
    println("Second response: $text")
}
println("Second execution took: ${secondTime}ms")
    }
}
