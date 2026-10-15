package com.jayvijay.scottie.feature.interacbanking.domain.repository

/** Whole-clip microphone capture producing 16 kHz mono 16-bit PCM WAV bytes. */
interface AudioRecorder {
  /** Begins capturing microphone audio. */
  suspend fun start()

  /** Stops capture, immediately releases the microphone hardware, and returns WAV bytes. */
  suspend fun stop(): ByteArray

  /** Immediately stops capture, discards buffered audio, and releases the microphone hardware. */
  fun cancel()
}
