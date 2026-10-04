package com.jayvijay.scottie.data.ai.provider

import com.jayvijay.scottie.domain.entities.ModelType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ModelCatalogTest {
  private fun liteRt(soc: String?) =
    StaticModelCatalog.forDevice(soc).filterIsInstance<LiteRtModel>()

  private fun urlOf(soc: String?, fileName: String) = liteRt(soc).single { it.id == fileName }.url

  @Test
  fun containsOnlyTextAndSpeechRowsWithUniqueIds() {
    SOCS.forEach { soc ->
      val rows = StaticModelCatalog.forDevice(soc)
      assertTrue(rows.all { it.type == ModelType.TEXT || it.type == ModelType.SPEECH_RECOGNITION })
      assertEquals(rows.size, rows.map { it.id }.toSet().size)
      assertTrue(rows.any { it.type == ModelType.SPEECH_RECOGNITION })
    }
  }

  @Test
  fun liteRtIdsAreStableFileNames() {
    val general = liteRt(null).map { it.id }
    SOCS.forEach { soc ->
      val rows = liteRt(soc)
      assertEquals(general, rows.map { it.id })
      rows.forEach { assertTrue(it.id, it.id.endsWith(".litertlm")) }
    }
  }

  @Test
  fun gemma4E2bResolvesToTheChipBuild() {
    val id = "gemma-4-E2B-it.litertlm"
    assertTrue(urlOf("SM8750", id).endsWith("/gemma-4-E2B-it_qualcomm_sm8750.litertlm"))
    assertTrue(urlOf("TENSOR_G5", id).endsWith("/gemma-4-E2B-it_Google_Tensor_G5.litertlm"))
    assertTrue(urlOf("TENSOR_G6", id).endsWith("/gemma-4-E2B-it_Google_Tensor_G6.litertlm"))
    listOf("SM8550", "SM8650", "TENSOR_G4", null).forEach { soc ->
      assertTrue("$soc", urlOf(soc, id).endsWith("/gemma-4-E2B-it.litertlm"))
    }
  }

  @Test
  fun gemma3ResolvesPerQualcommChip() {
    val id = "gemma3-1b-it-int4.litertlm"
    assertTrue(urlOf("SM8650", id).endsWith("_q4_ekv1280_sm8650.litertlm"))
    assertTrue(urlOf("SM8850", id).endsWith("_q4_ekv1280_sm8850.litertlm"))
  }

  @Test
  fun buildSizesAndMemoryFollowTheResolvedBuild() {
    val general = liteRt(null).single { it.id == "gemma-4-E2B-it.litertlm" }
    val npu = liteRt("SM8750").single { it.id == "gemma-4-E2B-it.litertlm" }
    assertEquals(2_588_147_712, general.downloadBytes)
    assertEquals(3_016_294_400, npu.downloadBytes)
    assertEquals(npu.downloadBytes * 13 / 10, npu.memoryBytes)
  }

  @Test
  fun onlyGatedReposRequireATokenAndUrlsArePinned() {
    val gated = liteRt(null).filter { it.requiresToken }.mapTo(mutableSetOf()) { it.id }
    assertEquals(
      setOf(
        "gemma3-1b-it-int4.litertlm",
        "gemma3-270m-it-q8.litertlm",
        "mobile_actions_q8_ekv1024.litertlm",
      ),
      gated,
    )
    SOCS.flatMap(::liteRt).forEach { row ->
      assertTrue(row.url, PINNED_URL.matches(row.url))
    }
  }

  @Test
  fun npuBuildsOnlyForEligibleChips() {
    val spec =
      LiteRtSpec(
        name = "X",
        fileName = "x.litertlm",
        general = null,
        npu = mapOf("SM8550" to LiteRtBuild("u", 1, 1), "SM8750" to LiteRtBuild("v", 1, 1)),
      )
    assertNull(spec.resolve("SM8550"))
    assertNull(spec.resolve(null))
    assertEquals("v", spec.resolve("SM8750")?.url)
  }

  @Test
  fun noRemovedModelTypesRemain() {
    SOCS.flatMap { StaticModelCatalog.forDevice(it) }
      .forEach { row ->
        val text = "${row.id} ${row.name}".lowercase()
        assertFalse(text, REMOVED.any { it in text })
      }
  }

  @Test
  fun titlesAreClean() {
    StaticModelCatalog.forDevice(null)
      .map { it.toModel() }
      .forEach { model ->
        assertTrue(model.id, model.name.isNotBlank())
        assertFalse("${model.id}: ${model.name}", BANNED_TITLE_TOKEN.containsMatchIn(model.name))
      }
  }

  @Test
  fun descriptionsComeFromTheModelFamily() {
    val models = StaticModelCatalog.forDevice(null).associate { it.id to it.toModel() }
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
    val SOCS = listOf("SM8750", "TENSOR_G5", "TENSOR_G6", "SM8650", "SM8850", "SM8550", null)
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
