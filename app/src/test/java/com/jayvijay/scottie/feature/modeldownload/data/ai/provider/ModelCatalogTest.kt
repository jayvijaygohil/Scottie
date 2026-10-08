package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ModelCatalogTest {
  private val liteRt = StaticModelCatalog.models.filterIsInstance<LiteRtModel>()

  @Test
  fun containsOnlyTextAndSpeechRowsWithUniqueIds() {
    val rows = StaticModelCatalog.models
    assertTrue(rows.all { it.type == ModelType.TEXT || it.type == ModelType.SPEECH_RECOGNITION })
    assertEquals(rows.size, rows.map { it.id }.toSet().size)
    assertTrue(rows.any { it.type == ModelType.SPEECH_RECOGNITION })
  }

  @Test
  fun liteRtIdsAreFileNames() {
    liteRt.forEach { row ->
      assertTrue(row.id, row.id.endsWith(".litertlm") && row.url.endsWith("/${row.id}"))
    }
  }

  @Test
  fun sizesAndMemoryAreTheGeneralBuild() {
    val gemma = liteRt.single { it.id == "gemma-4-E2B-it.litertlm" }
    assertEquals(2_588_147_712, gemma.downloadBytes)
    assertEquals(gemma.downloadBytes * 13 / 10, gemma.memoryBytes)
  }

  @Test
  fun urlsNameNoChip() {
    liteRt.forEach { assertFalse(it.url, CHIP.containsMatchIn(it.url)) }
  }

  @Test
  fun onlyGatedReposRequireATokenAndUrlsArePinned() {
    val gated = liteRt.filter { it.requiresToken }.mapTo(mutableSetOf()) { it.id }
    assertEquals(
      setOf(
        "gemma3-1b-it-int4.litertlm",
        "gemma3-270m-it-q8.litertlm",
        "mobile_actions_q8_ekv1024.litertlm",
      ),
      gated,
    )
    liteRt.forEach { row -> assertTrue(row.url, PINNED_URL.matches(row.url)) }
  }

  @Test
  fun noRemovedModelTypesRemain() {
    StaticModelCatalog.models.forEach { row ->
      val text = "${row.id} ${row.name}".lowercase()
      assertFalse(text, REMOVED.any { it in text })
    }
  }

  @Test
  fun titlesAreClean() {
    StaticModelCatalog.models
      .map { it.toModel() }
      .forEach { model ->
        assertTrue(model.id, model.name.isNotBlank())
        assertFalse("${model.id}: ${model.name}", BANNED_TITLE_TOKEN.containsMatchIn(model.name))
      }
  }

  @Test
  fun descriptionsComeFromTheModelFamily() {
    val models = StaticModelCatalog.models.associate { it.id to it.toModel() }
    assertEquals(
      "Small Gemma tuned for on-device function calling.",
      models.getValue("mobile_actions_q8_ekv1024.litertlm").description,
    )
    assertEquals(
      "OpenBMB compact chat model.",
      models.getValue("MiniCPM5-2B_int4.litertlm").description,
    )
    assertNull(familyDescription("unknown-model"))
  }

  @Test
  fun runtimeTagsAreStripped() {
    assertEquals("Qwen3.5 2B", displayTitle("x", "Qwen3.5 2B Q4_K_M"))
    assertEquals("Whisper Tiny EN", displayTitle("sherpa-onnx-whisper-tiny.en", "Sherpa Whisper"))
  }

  private companion object {
    val CHIP = Regex("""qualcomm|sm\d{4}|Tensor_G""", RegexOption.IGNORE_CASE)
    val PINNED_URL =
      Regex(
        """https://huggingface\.co/litert-community/[^/]+/resolve/[0-9a-f]{40}/[^/]+\.litertlm"""
      )
    val REMOVED =
      listOf(
        "vision",
        "vlm",
        "embed",
        "rerank",
        "segformer",
        "vad",
        "tts",
        "piper",
        "kokoro",
        "diffusion",
      )
    val BANNED_TITLE_TOKEN =
      Regex("""\bQ\d_|UD-|INT8|fp32|HNPU|Sherpa|ONNX|\(CPU\)|heavy|\.litertlm|\.onnx""")
  }
}
