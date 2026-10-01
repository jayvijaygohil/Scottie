package com.jayvijay.scottie.data.ai.provider

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

/** Family-level summary for a catalog row; null when its family has none. */
internal fun familyDescription(id: String): String? {
  val key = id.lowercase().replace('-', '_').replace('.', '_')
  return FAMILY_DESCRIPTIONS.firstOrNull { (family, _) -> family in key }?.second
}

private val PARENTHESIZED = Regex("""\(([^)]*)\)""")
private val QUANT_TAG = Regex("""\b(?:UD-)?I?T?Q\d(?:_[A-Z0-9]+)+\b|\bINT8\b|-fp32\b""")
private val WHITESPACE = Regex("""\s+""")
private val RUNTIME_TAGS = setOf("HNPU", "fully-on-NPU", "CPU", "ONNX", "Sherpa-ONNX", "heavy")

private val TITLE_OVERRIDES = mapOf("sherpa-onnx-whisper-tiny.en" to "Whisper Tiny EN")

// Ordered: the first family contained in the normalized id wins, so specific keys come first.
private val FAMILY_DESCRIPTIONS =
  listOf(
    "nemoguard_content" to "Safety classifier that flags unsafe content in prompts and replies.",
    "nemoguard_topic" to "Guardrail that keeps conversations on approved topics.",
    "nemotron_ocr" to "Reads printed text from images and documents.",
    "nemotron_parse" to "Extracts structured text and layout from documents.",
    "embed" to "Turns text into vectors for search and retrieval.",
    "rerank" to "Re-orders search results by relevance to a query.",
    "all_minilm" to "Small, fast text embedder for search and similarity.",
    "nemotron_asr" to "Streaming speech-to-text from NVIDIA.",
    "canary" to "NVIDIA speech recognition and translation.",
    "parakeet" to "NVIDIA speech recognition; accurate transcripts with low latency.",
    "whisper" to "OpenAI speech recognition; robust across accents and noise.",
    "moonshine" to "Compact speech recognition built for on-device use.",
    "kitten" to "Tiny text-to-speech voice for low-resource devices.",
    "kokoro" to "Natural-sounding English text-to-speech.",
    "magpie" to "Multilingual text-to-speech from NVIDIA.",
    "melotts" to "Lightweight English text-to-speech.",
    "piper" to "Fast, lightweight text-to-speech voice.",
    "supertonic" to "Fast on-device text-to-speech.",
    "silero_vad" to "Detects when someone is speaking in audio.",
    "segformer" to "Labels every pixel of an image by scene category.",
    "lama_dilated" to "Removes objects from photos by filling the gap.",
    "diffusion" to "Generates images from text prompts.",
    "siglip" to "Matches images with text for search and tagging.",
    "smolvlm" to "Very small vision-language model that describes images and video.",
    "internvl" to "Vision-language model that answers questions about images.",
    "vl_2b_text" to "Text-only build of Qwen3-VL for fast chat.",
    "_vl" to "Vision-language model that understands images and text.",
    "vlm" to "Vision-language model that understands images and text.",
    "deepseek_r1" to "Reasoning model that thinks step by step before answering.",
    "fara" to "Agent model that operates computer interfaces from screenshots.",
    "bonsai" to "1-bit model; very small download and memory use.",
    "maple" to "Ternary mixture-of-experts model; large capacity, low memory.",
    "nemotron" to "NVIDIA model tuned for reasoning and instruction following.",
    "qwen" to "Alibaba general-purpose chat model; strong quality for its size.",
    "lfm" to "Liquid AI model built for fast, efficient on-device chat.",
    "llama" to "Meta general-purpose chat model.",
    "gemma" to "Google general-purpose chat model.",
    "phi" to "Microsoft compact model with strong reasoning for its size.",
    "granite" to "IBM model for business and coding tasks.",
    "cosmos" to "NVIDIA compact general-purpose model.",
    "muse_glimmer" to "Large Meta multimodal model; needs a high-memory device.",
  )
