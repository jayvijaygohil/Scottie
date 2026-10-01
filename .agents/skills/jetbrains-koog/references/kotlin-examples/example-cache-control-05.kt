// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCacheControl05

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.anthropic.AnthropicCacheControl
import ai.koog.prompt.executor.clients.anthropic.AnthropicParams

// Block-level: pin the system prompt in the 1-hour cache tier
// Automatic: let Anthropic manage breakpoints for the conversation tail
val params = AnthropicParams(cacheControl = AnthropicCacheControl.Default)

val prompt = prompt("combined", params = params) {
    system("You are a helpful assistant...", AnthropicCacheControl.OneHour)
    user("Hello!")
}
