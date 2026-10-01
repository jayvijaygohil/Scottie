// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters10

import ai.koog.prompt.executor.clients.openai.OpenAIResponsesParams
import ai.koog.prompt.executor.clients.openai.models.OpenAIInclude

val openAIStatelessReasoningParams = OpenAIResponsesParams(
    include = listOf(OpenAIInclude.REASONING_ENCRYPTED_CONTENT)
)
