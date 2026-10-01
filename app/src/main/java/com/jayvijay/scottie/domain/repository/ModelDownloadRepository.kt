package com.jayvijay.scottie.domain.repository

import com.jayvijay.scottie.domain.entities.ModelCatalog
import kotlinx.coroutines.flow.StateFlow

interface ModelDownloadRepository {
  /** Loading until the runtime is initialized and the catalog registered. */
  val catalog: StateFlow<ModelCatalog>

  /** Starts, resumes, or retries. Ignored while another model is downloading. */
  fun download(modelId: String)

  /** Stops the active transfer, keeping bytes. No-op unless [modelId] is downloading. */
  fun pause(modelId: String)

  /** Removes a downloaded model's files. Failure leaves the entry Downloaded. */
  suspend fun delete(modelId: String): Result<Unit>
}
