package com.jayvijay.scottie.data.ai.provider

import ai.runanywhere.proto.v1.InferenceFramework
import com.jayvijay.scottie.domain.entities.HardwareTarget
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ModelCatalogTest {
  private val rows = StaticModelCatalog.all

  @Test
  fun idsAreUnique() {
    val duplicates = rows.groupBy { it.id }.filterValues { it.size > 1 }.keys
    assertEquals(emptySet<String>(), duplicates)
  }

  @Test
  fun namesAndUrlsAreNotBlank() {
    rows.forEach { row ->
      assertTrue(row.id, row.name.isNotBlank())
      val urls =
        when (row) {
          is SingleFileModel -> listOf(row.url)
          is ArchiveModel -> listOf(row.url)
          is MultiFileModel -> row.files.map { it.url }
        }
      assertTrue(row.id, urls.isNotEmpty() && urls.all { it.isNotBlank() })
    }
  }

  @Test
  fun titlesAreCleanAndUniquePerSection() {
    val models = rows.map { it.toModel() }
    models.forEach { model ->
      assertTrue(model.id, model.name.isNotBlank())
      assertFalse("${model.id}: ${model.name}", BANNED_TITLE_TOKEN.containsMatchIn(model.name))
    }
    val duplicates =
      models.groupBy { Triple(it.type, it.target, it.name) }.filterValues { it.size > 1 }.keys
    assertEquals(emptySet<Any>(), duplicates)
  }

  @Test
  fun runtimeTagsAreStrippedButMeaningfulQualifiersKept() {
    assertEquals("Qwen3.5 2B", displayTitle("x", "Qwen3.5 2B Q4_K_M"))
    assertEquals("Gemma 4 26B-A4B IT (MoE)", displayTitle("x", "Gemma 4 26B-A4B IT UD-Q4_K_XL (MoE, heavy)"))
    assertEquals("Bonsai-4B 1-bit", displayTitle("x", "Bonsai-4B 1-bit Q1_0 (CPU)"))
    assertEquals("Kitten-nano-0.8", displayTitle("x", "Kitten-nano-0.8-fp32 (HNPU)"))
    assertEquals("Gemma 4 E2B IT (Experimental)", displayTitle("x", "Gemma 4 E2B IT Q8_0 (Experimental)"))
  }

  @Test
  fun everyRowHasOneTypeAndTarget() {
    rows.forEach { row ->
      val model = row.toModel()
      val npu = row.framework == InferenceFramework.INFERENCE_FRAMEWORK_QHEXRT
      assertEquals(row.id, if (npu) HardwareTarget.NPU else HardwareTarget.CPU, model.target)
    }
  }

  @Test
  fun descriptionsComeFromTheModelFamily() {
    assertEquals(
      "Meta general-purpose chat model.",
      rows.single { it.id == "llama3_2_1b" }.toModel().description,
    )
    assertEquals(
      "Removes objects from photos by filling the gap.",
      rows.single { it.id == "lama_dilated" }.toModel().description,
    )
    assertNull(familyDescription("unknown-model"))
  }

  private companion object {
    val BANNED_TITLE_TOKEN =
      Regex("""\bQ\d_|UD-|TQ1_0|INT8|fp32|HNPU|Sherpa|ONNX|\(CPU\)|heavy|\.gguf|\.onnx|[0-9a-f]{16}""")
  }
}
