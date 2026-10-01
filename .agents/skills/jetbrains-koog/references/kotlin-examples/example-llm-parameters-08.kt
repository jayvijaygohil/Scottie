// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters08

import ai.koog.prompt.params.LLMParams

// A basic set of parameters with limited length
val basicParams = LLMParams(
    temperature = 0.7,
    maxTokens = 150,
    toolChoice = LLMParams.ToolChoice.Auto
)
