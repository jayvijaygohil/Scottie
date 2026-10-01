// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleModelCapabilities05

import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.executor.ollama.client.OllamaModels

val basicModel = OllamaModels.Meta.LLAMA_3_2
val visionModel = OllamaModels.Meta.LLAMA_3_2

// Check if models support specific capabilities
val supportsTools = basicModel.supports(LLMCapability.Tools) // true
val supportsVideo = visionModel.supports(LLMCapability.Vision.Video) // false

// Check for schema capabilities
val jsonCapability = basicModel.capabilities?.filterIsInstance<LLMCapability.Schema.JSON>()?.firstOrNull()
val hasFullJsonSupport = jsonCapability is LLMCapability.Schema.JSON.Standard // true
