// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.examplePromptExecutors06

import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.clients.anthropic.AnthropicLLMClient
import ai.koog.prompt.executor.clients.google.GoogleLLMClient
import ai.koog.prompt.executor.clients.openai.OpenAILLMClient
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import ai.koog.prompt.llm.LLMProvider
import ai.koog.prompt.dsl.prompt
import kotlinx.coroutines.runBlocking
fun main() = runBlocking {

// Create LLM clients for OpenAI, Anthropic, and Google providers
val openAIClient = OpenAILLMClient("OPENAI_API_KEY")
val anthropicClient = AnthropicLLMClient("ANTHROPIC_API_KEY")
val googleClient = GoogleLLMClient("GOOGLE_API_KEY")

// Create a MultiLLMPromptExecutor that maps LLM providers to LLM clients
val executor = MultiLLMPromptExecutor(
    LLMProvider.OpenAI to openAIClient,
    LLMProvider.Anthropic to anthropicClient,
    LLMProvider.Google to googleClient
)

// Create a prompt
val p = prompt("demo") { user("Summarize this.") }

// Run the prompt with an OpenAI model; the prompt executor automatically switches to the OpenAI client
val openAIResult = executor.execute(p, OpenAIModels.Chat.GPT4o)

// Run the prompt with an Anthropic model; the prompt executor automatically switches to the Anthropic client
val anthropicResult = executor.execute(p, AnthropicModels.Sonnet_4_5)
}
