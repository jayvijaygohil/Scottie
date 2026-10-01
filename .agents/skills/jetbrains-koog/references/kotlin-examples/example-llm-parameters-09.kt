// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters09

import ai.koog.prompt.executor.clients.openai.OpenAIChatParams
import ai.koog.prompt.executor.clients.openai.base.models.ReasoningEffort

val openAIReasoningEffortParams = OpenAIChatParams(
    reasoningEffort = ReasoningEffort.MEDIUM
)
