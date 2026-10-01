// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelCapabilities02

import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLMProvider
import ai.koog.prompt.llm.LLModel

val visionModel = LLModel(
    provider = LLMProvider.OpenAI,
    id = "gpt-4-vision",
    capabilities = listOf(
        LLMCapability.Temperature,
        LLMCapability.Vision.Image,
        LLMCapability.MultipleChoices
    ),
    contextLength = 1_047_576,
    maxOutputTokens = 32_768
)
