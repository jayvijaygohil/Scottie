// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.examplePromptExecutors01

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor

val openAIClient = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
val promptExecutor = MultiLLMPromptExecutor(openAIClient)
