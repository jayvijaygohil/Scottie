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
   * Stored id if that entry is `TEXT` and `Downloaded`; else first such entry in catalog order;
   * else null.
   */
  val activeTextModel: StateFlow<String?>

  /** Persists the choice. Ignored unless [modelId] is a downloaded text model. */
  fun selectTextModel(modelId: String)
}

sealed interface DownloadStart {
  data object Started : DownloadStart

  data object Ignored : DownloadStart

  data class Refused(val shortfall: Shortfall) : DownloadStart
}
