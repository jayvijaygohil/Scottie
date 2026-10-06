package com.jayvijay.scottie.feature.modeldownload.domain.entities

data class Model(
  val id: String,
  val name: String,
  val type: ModelType,
  /** Null when unknown. */
  val downloadBytes: Long?,
  /** Null when the catalog has none. */
  val description: String? = null,
  /** RAM needed to run the model; null when unknown. */
  val memoryBytes: Long? = null,
  /** True when the source needs a Hugging Face account token; such models cannot be downloaded. */
  val requiresToken: Boolean = false,
)

enum class ModelType {
  TEXT,
  SPEECH_RECOGNITION,
}

data class DownloadProgress(
  val bytesDone: Long,
  /** 0 when unknown. */
  val bytesTotal: Long,
  /** 0..1; null → indeterminate. */
  val fraction: Float?,
  val phase: DownloadPhase = DownloadPhase.TRANSFERRING,
)

enum class DownloadPhase {
  TRANSFERRING,
  VERIFYING,
  EXTRACTING,
}

sealed interface ModelDownloadStatus {
  data object Available : ModelDownloadStatus

  data class Downloading(val progress: DownloadProgress) : ModelDownloadStatus

  data class Paused(val bytesKept: Long) : ModelDownloadStatus

  data class Failed(val reason: DownloadFailure, val bytesKept: Long) : ModelDownloadStatus

  data object Downloaded : ModelDownloadStatus
}

enum class DownloadFailure {
  NETWORK,
  STORAGE,
  CORRUPTED,
  BACKGROUND_REFUSED,
  UNKNOWN,
}

/** [supported] is the catalog-load compatibility verdict (memory and storage). */
data class ModelEntry(val model: Model, val status: ModelDownloadStatus, val supported: Boolean)

sealed interface ModelCatalog {
  data object Loading : ModelCatalog

  /** Entries in catalog order. */
  data class Ready(val entries: List<ModelEntry>) : ModelCatalog

  /** The runtime failed to initialize. */
  data object Unavailable : ModelCatalog
}
