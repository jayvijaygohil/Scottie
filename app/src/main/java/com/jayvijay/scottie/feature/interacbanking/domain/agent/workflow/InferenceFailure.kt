package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

/** Why inference failed, as far as the user can act on it. */
enum class InferenceFailure {
  OFFLINE,
  UNAUTHORIZED,
  MODEL_UNAVAILABLE,
  UNKNOWN,
}

class InferenceException(val failure: InferenceFailure, cause: Throwable) :
  RuntimeException(failure.name, cause)

/** Maps a transport or client error to an [InferenceFailure]; implemented where Koog lives. */
fun interface FailureClassifier {
  fun classify(error: Throwable): InferenceFailure
}
