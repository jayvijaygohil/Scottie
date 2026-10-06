package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

/**
 * Display title for a catalog row: the upstream name without quantization, precision, and runtime
 * tags, which the catalog sections and badges already convey.
 */
internal fun displayTitle(id: String, name: String): String {
  TITLE_OVERRIDES[id]?.let {
    return it
  }
  return name
    .replace(PARENTHESIZED) { match ->
      val kept = match.groupValues[1].split(',').map(String::trim).filterNot { it in RUNTIME_TAGS }
      if (kept.isEmpty()) "" else kept.joinToString(prefix = "(", postfix = ")")
    }
    .replace(QUANT_TAG, "")
    .replace(WHITESPACE, " ")
    .trim()
    .trimEnd('-', ',')
    .trim()
}

/** Family-level summary for a row's id and name; null when its family has none. */
internal fun familyDescription(idAndName: String): String? {
  val key = idAndName.lowercase().replace('-', '_').replace('.', '_')
  return FAMILY_DESCRIPTIONS.firstOrNull { (family, _) -> family in key }?.second
}

private val PARENTHESIZED = Regex("""\(([^)]*)\)""")
private val QUANT_TAG = Regex("""\b(?:UD-)?I?T?Q\d(?:_[A-Z0-9]+)+\b|\bINT8\b|-fp32\b""")
private val WHITESPACE = Regex("""\s+""")
private val RUNTIME_TAGS = setOf("CPU", "ONNX", "Sherpa-ONNX", "heavy")

private val TITLE_OVERRIDES = mapOf("sherpa-onnx-whisper-tiny.en" to "Whisper Tiny EN")

// Ordered: the first family contained in the normalized key wins, so specific keys come first.
private val FAMILY_DESCRIPTIONS =
  listOf(
    "nemotron_asr" to "Streaming speech-to-text from NVIDIA.",
    "canary" to "NVIDIA speech recognition and translation.",
    "parakeet" to "NVIDIA speech recognition; accurate transcripts with low latency.",
    "whisper" to "OpenAI speech recognition; robust across accents and noise.",
    "moonshine" to "Compact speech recognition built for on-device use.",
    "deepseek_r1" to "Reasoning model that thinks step by step before answering.",
    "functiongemma" to "Small Gemma tuned for on-device function calling.",
    "minicpm" to "OpenBMB compact chat model.",
    "qwen" to "Alibaba general-purpose chat model; strong quality for its size.",
    "gemma" to "Google general-purpose chat model.",
  )
