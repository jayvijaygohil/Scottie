// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.examplePromptExecutors03

import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.llms.RoundRobinRouter
import ai.koog.prompt.executor.llms.RoutingLLMPromptExecutor

// Create multiple client instances
val openAI1 = OpenAILLMClient(apiKey = "openai-key-1")
val openAI2 = OpenAILLMClient(apiKey = "openai-key-2")
val anthropic = AnthropicLLMClient(apiKey = "anthropic-key")

// Create router with round-robin strategy
val router = RoundRobinRouter(openAI1, openAI2, anthropic)

// Create routing executor
val routingExecutor = RoutingLLMPromptExecutor(router)
