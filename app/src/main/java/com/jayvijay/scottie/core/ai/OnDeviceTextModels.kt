package com.jayvijay.scottie.core.ai

import ai.koog.prompt.executor.clients.litert.LiteRTLLMProvider
import ai.koog.prompt.executor.clients.litert.LiteRTLLModels
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLModel
import android.content.Context
import com.google.ai.edge.litertlm.Backend
import java.io.File

/** Where downloaded `.litertlm` text models live and how Koog addresses them. */
object OnDeviceTextModels {
  // ponytail: CPU until measured; GPU()/NPU(nativeLibraryDir) are the levers
  val BACKEND: Backend = Backend.CPU()

  fun dir(context: Context): File = File(context.filesDir, "models/litert")

  /** Koog model for a catalog file name; unknown files get a generic tool-capable definition. */
  fun llModel(fileName: String): LLModel =
    LiteRTLLModels.models.find { it.id == fileName }
      ?: LLModel(
        provider = LiteRTLLMProvider,
        id = fileName,
        capabilities = listOf(LLMCapability.Tools, LLMCapability.Completion),
        contextLength = CONTEXT_LENGTH,
        maxOutputTokens = MAX_OUTPUT_TOKENS,
      )

  private const val CONTEXT_LENGTH = 32_000L
  private const val MAX_OUTPUT_TOKENS = 1_024L
}
