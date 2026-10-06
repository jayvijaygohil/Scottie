package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

import ai.koog.prompt.llm.LLModel

/** Turns typed text into an [AssistantIntent]; never throws, falls back to OTHER. */
fun interface IntentExtractor {
  suspend fun extract(text: String, modelId: String): AssistantIntent
}

/** Maps a downloaded model file name to the Koog model that runs it. */
fun interface ModelResolver {
  fun resolve(modelId: String): LLModel
}
