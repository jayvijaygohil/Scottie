package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

import ai.koog.prompt.executor.model.PromptExecutor
import ai.koog.prompt.llm.LLModel

/**
 * Turns typed text into an [AssistantIntent]; throws [InferenceException] on inference failure and
 * falls back to OTHER on unparseable output.
 */
fun interface IntentExtractor {
  suspend fun extract(text: String, modelId: String): AssistantIntent
}

data class ResolvedModel(val executor: PromptExecutor, val model: LLModel)

/** Maps a model id to the Koog executor and model that run it. */
fun interface ModelResolver {
  fun resolve(modelId: String): ResolvedModel
}
