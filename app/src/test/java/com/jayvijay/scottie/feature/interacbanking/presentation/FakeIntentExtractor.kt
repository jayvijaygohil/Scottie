package com.jayvijay.scottie.feature.interacbanking.presentation

import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.IntentExtractor
import kotlinx.coroutines.CompletableDeferred

/** Replays queued intents (or failures) and records every call. */
class FakeIntentExtractor : IntentExtractor {
  val calls = mutableListOf<String>()
  val modelIds = mutableListOf<String>()
  val queue = ArrayDeque<Result<AssistantIntent>>()

  /** When set, every call waits for it so tests can observe the in-flight state. */
  var gate: CompletableDeferred<Unit>? = null

  fun enqueue(intent: AssistantIntent) = queue.addLast(Result.success(intent))

  fun enqueueFailure(error: Throwable) = queue.addLast(Result.failure(error))

  override suspend fun extract(text: String, modelId: String): AssistantIntent {
    calls += text
    modelIds += modelId
    gate?.await()
    return queue.removeFirst().getOrThrow()
  }
}
