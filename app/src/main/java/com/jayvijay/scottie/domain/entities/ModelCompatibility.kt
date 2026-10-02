package com.jayvijay.scottie.domain.entities

enum class ShortfallKind {
  MEMORY,
  STORAGE,
}

sealed interface Compatibility {
  data object Compatible : Compatibility

  data class Shortfall(val kind: ShortfallKind, val requiredBytes: Long, val availableBytes: Long) :
    Compatibility
}

/**
 * RunAnywhere's `model_compatibility.cpp` rule: each check passes when the requirement or the
 * available amount is unknown (null or ≤ 0), or when available ≥ required. Memory is reported
 * before storage.
 */
fun checkCompatibility(
  memoryNeed: Long?,
  downloadBytes: Long?,
  availableMemory: Long?,
  availableStorage: Long?,
): Compatibility =
  shortfall(ShortfallKind.MEMORY, memoryNeed, availableMemory)
    ?: shortfall(ShortfallKind.STORAGE, downloadBytes, availableStorage)
    ?: Compatibility.Compatible

private fun shortfall(kind: ShortfallKind, required: Long?, available: Long?) =
  if (required != null && available != null && available in 1 until required) {
    Compatibility.Shortfall(kind, required, available)
  } else {
    null
  }
