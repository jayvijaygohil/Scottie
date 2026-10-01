// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures02

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.retry.RetryConfig
import ai.koog.prompt.executor.clients.retry.RetryingLLMClient
val apiKey = System.getenv("OPENAI_API_KEY")
val client = OpenAILLMClient(apiKey)

// Use the predefined configuration
val conservativeClient = RetryingLLMClient(
    delegate = client,
    config = RetryConfig.CONSERVATIVE
)
