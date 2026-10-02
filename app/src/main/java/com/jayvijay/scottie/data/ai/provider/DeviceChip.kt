package com.jayvijay.scottie.data.ai.provider

import android.os.Build

/** Chips whose LiteRT NPU builds Scottie offers; other chips get the general build. */
val NPU_ELIGIBLE = setOf("SM8650", "SM8750", "SM8850", "TENSOR_G5", "TENSOR_G6")

private val BOARD_PLATFORMS = mapOf("SUN" to "SM8750", "PINEAPPLE" to "SM8650")

private val SEPARATORS = Regex("""[\s-]+""")

/** `"Tensor G5"` → `"TENSOR_G5"`; null when blank or unknown. */
internal fun normalizeSoc(raw: String?): String? =
  raw?.trim()?.uppercase()?.replace(SEPARATORS, "_")?.takeUnless {
    it.isEmpty() || it == "UNKNOWN"
  }

internal fun boardSoc(board: String?): String? = BOARD_PLATFORMS[board?.trim()?.uppercase()]

internal fun chipOf(socModel: String?, board: String?): String? =
  normalizeSoc(socModel) ?: boardSoc(board)

// ponytail: Build.BOARD stands in for ro.board.platform, which needs hidden SystemProperties;
// switch to it if a vendor board name breaks the mapping.
fun socModel(): String? =
  chipOf(
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) Build.SOC_MODEL else null,
    Build.BOARD,
  )
