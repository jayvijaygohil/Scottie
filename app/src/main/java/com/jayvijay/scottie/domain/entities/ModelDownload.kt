package com.jayvijay.scottie.domain.entities

data class Model(
  val id: String,
  val name: String,
  val type: ModelType,
  /** Null when unknown. */
  val downloadBytes: Long?,
)

enum class ModelType {
  TEXT,
  MULTIMODAL,
  VISION,
  IMAGE_GENERATION,
  EMBEDDING,
  SPEECH_RECOGNITION,
  SPEECH_SYNTHESIS,
  VOICE_ACTIVITY,
  SEGMENTATION,
  OTHER,
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

data class ModelEntry(val model: Model, val status: ModelDownloadStatus)

sealed interface ModelCatalog {
  data object Loading : ModelCatalog

  /** Entries in catalog order. */
  data class Ready(val entries: List<ModelEntry>) : ModelCatalog

  /** The runtime failed to initialize. */
  data object Unavailable : ModelCatalog
}
