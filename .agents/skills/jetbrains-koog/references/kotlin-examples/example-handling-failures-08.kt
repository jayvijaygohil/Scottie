// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleHandlingFailures08

import ai.koog.prompt.executor.clients.ConnectionTimeoutConfig
import ai.koog.prompt.executor.clients.openai.OpenAIClientSettings
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
val apiKey = System.getenv("OPENAI_API_KEY")    

val client = OpenAILLMClient(
    apiKey = apiKey,
    settings = OpenAIClientSettings(
        timeoutConfig = ConnectionTimeoutConfig(
            connectTimeoutMillis = 5000,    // 5 seconds to establish connection
            requestTimeoutMillis = 60000,    // 60 seconds for the entire request
            socketTimeoutMillis = 120000   // 120 seconds for data on the socket
        )
    )
)
