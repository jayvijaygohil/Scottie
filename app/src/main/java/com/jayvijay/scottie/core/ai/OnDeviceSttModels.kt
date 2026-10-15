package com.jayvijay.scottie.core.ai

import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.AudioInput
import com.runanywhere.sdk.public.api.models
import com.runanywhere.sdk.public.api.stt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

/** Loads on-device `SPEECH_RECOGNITION` models via RunAnywhere and transcribes WAV audio clips. */
object OnDeviceSttModels {
  private val mutex = Mutex()
  private var loadedModelId: String? = null

  suspend fun transcribe(modelId: String, wavBytes: ByteArray): String =
    withContext(Dispatchers.IO) {
      mutex.withLock {
        if (loadedModelId != modelId) {
          loadedModelId?.let { previous -> runCatching { RunAnywhere.models.unload(previous) } }
          RunAnywhere.models.load(modelId)
          loadedModelId = modelId
        }
        RunAnywhere.stt.transcribe(AudioInput.wav(wavBytes)).text
      }
    }
}
