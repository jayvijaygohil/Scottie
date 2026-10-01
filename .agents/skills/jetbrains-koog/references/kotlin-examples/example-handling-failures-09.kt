// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures09

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.clients.retry.RetryingLLMClient
import ai.koog.prompt.executor.clients.retry.RetryConfig
import ai.koog.prompt.dsl.prompt
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
fun main() {
    runBlocking {

val logger = LoggerFactory.getLogger("Example")
val resilientClient = RetryingLLMClient(
    OpenAILLMClient(System.getenv("OPENAI_API_KEY")),
    RetryConfig.PRODUCTION
)
val prompt = prompt("test") { user("Hello") }
val model = OpenAIModels.Chat.GPT4o

fun processResponse(response: Any) { /* implmenentation */ }
fun scheduleRetryLater() { /* implmenentation */ }
fun notifyAdministrator() { /* implmenentation */ }
fun useDefaultResponse() { /* implmenentation */ }

try {
    val response = resilientClient.execute(prompt, model)
    processResponse(response)
} catch (e: Exception) {
    logger.error("LLM operation failed", e)

    when {
        e.message?.contains("rate limit") == true -> {
            // Handle rate limiting specifically
            scheduleRetryLater()
        }
        e.message?.contains("invalid api key") == true -> {
            // Handle authentication errors
            notifyAdministrator()
        }
        else -> {
            // Fall back to an alternative solution
            useDefaultResponse()
        }
    }
}
    }
}
