package com.jayvijay.scottie.feature.interacbanking.presentation

import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.IntentExtractor

/** Replays queued intents (or failures) and records every call. */
class FakeIntentExtractor : IntentExtractor {
  val calls = mutableListOf<String>()
  val queue = ArrayDeque<Result<AssistantIntent>>()

  fun enqueue(intent: AssistantIntent) = queue.addLast(Result.success(intent))

  fun enqueueFailure(error: Throwable) = queue.addLast(Result.failure(error))

  override suspend fun extract(text: String, modelId: String): AssistantIntent {
    calls += text
    return queue.removeFirst().getOrThrow()
  }
}
