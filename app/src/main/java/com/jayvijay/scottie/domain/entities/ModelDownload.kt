package com.jayvijay.scottie.domain.entities

data class Model(
  val id: String,
  val name: String,
  val type: ModelType,
  /** Null when unknown. */
  val downloadBytes: Long?,
  /** Null when the catalog has none. */
  val description: String? = null,
  val target: HardwareTarget = HardwareTarget.CPU,
  /** RAM needed to run the model; null when unknown. */
  val memoryBytes: Long? = null,
)

/** Where a model executes. */
enum class HardwareTarget {
  CPU,
  NPU,
}

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

/** [supported] is false when this device cannot run [model]; such entries cannot be downloaded. */
data class ModelEntry(val model: Model, val status: ModelDownloadStatus, val supported: Boolean)

sealed interface ModelCatalog {
  data object Loading : ModelCatalog

  /** Entries in catalog order. */
  data class Ready(val entries: List<ModelEntry>) : ModelCatalog

  /** The runtime failed to initialize. */
  data object Unavailable : ModelCatalog
}
