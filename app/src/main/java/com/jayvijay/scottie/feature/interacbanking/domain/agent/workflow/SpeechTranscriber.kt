package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

/** Transcribes a whole WAV audio clip using [modelId]; throws [InferenceException] on failure. */
fun interface SpeechTranscriber {
  suspend fun transcribe(wavBytes: ByteArray, modelId: String): String
}
