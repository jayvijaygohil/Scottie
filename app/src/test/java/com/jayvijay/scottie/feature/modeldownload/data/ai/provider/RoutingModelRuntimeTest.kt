package com.jayvijay.scottie.feature.modeldownload.data.ai.provider

import ai.runanywhere.proto.v1.InferenceFramework
import ai.runanywhere.proto.v1.ModelCategory
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class RoutingModelRuntimeTest {
  private val liteRt = FakeModelRuntime()
  private val runAnywhere = FakeModelRuntime()
  private val router = RoutingModelRuntime(liteRt, runAnywhere)

  private val lite = LiteRtModel("m.litertlm", "M", "u", 1, 1, false)
  private val stt =
    MultiFileModel(
      "stt",
      "S",
      InferenceFramework.INFERENCE_FRAMEWORK_SHERPA,
      ModelCategory.MODEL_CATEGORY_SPEECH_RECOGNITION,
      1,
      files = emptyList(),
    )

  @Test
  fun prepareSplitsRowsAndUnionsAcceptedIds() = runTest {
    assertEquals(setOf(lite.id, stt.id), router.prepare(listOf(lite, stt)))
    assertEquals(listOf(lite.id), liteRt.prepared)
    assertEquals(listOf(stt.id), runAnywhere.prepared)
  }

  @Test
  fun downloadedIdsAreTheUnion() = runTest {
    liteRt.downloaded += lite.id
    runAnywhere.downloaded += stt.id
    assertEquals(setOf(lite.id, stt.id), router.downloadedIds())
  }

  @Test
  fun downloadAndDeleteReachTheOwner() = runTest {
    router.prepare(listOf(lite, stt))
    listOf(lite.id, stt.id).forEach { id ->
      val job = launch { router.download(id).first() }
      runCurrent()
      job.cancel()
      router.delete(id)
    }
    assertEquals(listOf(lite.id), liteRt.downloadCalls)
    assertEquals(listOf(stt.id), runAnywhere.downloadCalls)
    assertEquals(listOf(lite.id), liteRt.deleted)
    assertEquals(listOf(stt.id), runAnywhere.deleted)
  }
}
