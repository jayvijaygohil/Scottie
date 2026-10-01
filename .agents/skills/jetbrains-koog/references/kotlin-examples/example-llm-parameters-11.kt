// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters11

import ai.koog.prompt.params.LLMParams
import ai.koog.prompt.params.additionalPropertiesOf

// Add custom parameters for specific model providers
val customParams = LLMParams(
    additionalProperties = additionalPropertiesOf(
        "top_p" to 0.95,
        "frequency_penalty" to 0.5,
        "presence_penalty" to 0.5
    )
)
