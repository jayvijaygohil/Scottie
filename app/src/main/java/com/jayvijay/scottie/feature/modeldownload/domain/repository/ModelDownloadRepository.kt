package com.jayvijay.scottie.feature.modeldownload.domain.repository

import com.jayvijay.scottie.feature.modeldownload.domain.entities.Compatibility.Shortfall
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import kotlinx.coroutines.flow.StateFlow

interface ModelDownloadRepository {
  /** Loading until the runtime is initialized and the catalog registered. */
  val catalog: StateFlow<ModelCatalog>

  /**
   * Starts, resumes, or retries. [DownloadStart.Ignored] while another model is downloading, for
   * unknown ids, for models that require a token, or for statuses that cannot start.
   * [DownloadStart.Refused], with the status unchanged, when the start-time compatibility check
   * fails.
   */
  suspend fun download(modelId: String): DownloadStart

  /** Stops the active transfer, keeping bytes. No-op unless [modelId] is downloading. */
  fun pause(modelId: String)

  /** Removes a downloaded model's files, supported or not. Failure leaves the entry Downloaded. */
  suspend fun delete(modelId: String): Result<Unit>

  /**
   * Stored id if it is a downloaded `TEXT` model or a configured remote id; else first downloaded
   * text model in catalog order; else first configured remote id; else null.
   */
  val activeTextModel: StateFlow<String?>

  /**
   * Persists the choice. Ignored unless [modelId] is a downloaded text model or a configured remote
   * id.
   */
  fun selectTextModel(modelId: String)

  /**
   * Stored id if it is a downloaded `SPEECH_RECOGNITION` model or a configured remote audio id;
   * else null ("None").
   */
  val activeAudioModel: StateFlow<String?>

  /**
   * Persists the choice, or clears it when [modelId] is null. Ignored unless [modelId] is null, a
   * downloaded speech recognition model, or a configured remote audio id.
   */
  fun selectAudioModel(modelId: String?)
}

sealed interface DownloadStart {
  data object Started : DownloadStart

  data object Ignored : DownloadStart

  data class Refused(val shortfall: Shortfall) : DownloadStart
}
