// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters06

import ai.koog.prompt.params.LLMParams

val specificToolParams = LLMParams(
    toolChoice = LLMParams.ToolChoice.Named(name = "calculator")
)
