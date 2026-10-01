package com.jayvijay.scottie.data.repository

import ai.runanywhere.proto.v1.InferenceFramework
import ai.runanywhere.proto.v1.ModelCategory
import com.jayvijay.scottie.data.ai.provider.FakeDownloadForegroundHost
import com.jayvijay.scottie.data.ai.provider.FakeModelRuntime
import com.jayvijay.scottie.data.ai.provider.RuntimeDownloadEvent
import com.jayvijay.scottie.data.ai.provider.SingleFileModel
import com.jayvijay.scottie.domain.entities.DownloadFailure
import com.jayvijay.scottie.domain.entities.DownloadPhase
import com.jayvijay.scottie.domain.entities.DownloadProgress
import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Available
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Downloaded
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Downloading
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Failed
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Paused
import com.jayvijay.scottie.domain.entities.ModelType
import java.io.IOException
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ModelDownloadRepositoryImplTest {
  private val runtime = FakeModelRuntime()
  private val host = FakeDownloadForegroundHost()

  private fun TestScope.repository(): ModelDownloadRepositoryImpl =
    ModelDownloadRepositoryImpl(runtime, host, ROWS, backgroundScope).also { runCurrent() }

  private fun ModelDownloadRepositoryImpl.status(id: String): ModelDownloadStatus =
    (catalog.value as ModelCatalog.Ready).entries.single { it.model.id == id }.status

  private fun progress(done: Long, fraction: Float? = done / TOTAL.toFloat()) =
    DownloadProgress(done, TOTAL, fraction)

  @Test
  fun catalogLoadsWithDownloadedIdsApplied() = runTest {
    runtime.downloaded += B
    val repo = ModelDownloadRepositoryImpl(runtime, host, ROWS, backgroundScope)
    assertEquals(ModelCatalog.Loading, repo.catalog.value)
    runCurrent()

    val entries = (repo.catalog.value as ModelCatalog.Ready).entries
    assertEquals(listOf(A, B, NPU), entries.map { it.model.id })
    assertEquals(listOf(Available, Downloaded, Available), entries.map { it.status })
    assertEquals(ModelType.TEXT, entries.first().model.type)
  }

  @Test
  fun prepareFailureMakesCatalogUnavailable() = runTest {
    runtime.prepareError = IllegalStateException("init")
    assertEquals(ModelCatalog.Unavailable, repository().catalog.value)
  }

  @Test
  fun rejectedRowIsHiddenUnlessDownloaded() = runTest {
    runtime.accepted = setOf(A, B)
    val hidden = (repository().catalog.value as ModelCatalog.Ready).entries.map { it.model.id }
    assertEquals(listOf(A, B), hidden)

    runtime.downloaded += NPU
    val shown = (repository().catalog.value as ModelCatalog.Ready).entries.map { it.model.id }
    assertEquals(listOf(A, B, NPU), shown)
  }

  @Test
  fun downloadProgressesToDownloaded() = runTest {
    val repo = repository()
    repo.download(A)
    assertEquals(Downloading(DownloadProgress(0, 0, null)), repo.status(A))
    runCurrent()

    runtime.send(A, RuntimeDownloadEvent.Progress(progress(50)))
    runCurrent()
    assertEquals(Downloading(progress(50)), repo.status(A))

    runtime.send(A, RuntimeDownloadEvent.Completed)
    runtime.finish(A)
    runCurrent()
    assertEquals(Downloaded, repo.status(A))
    assertEquals(1, host.startCount)
  }

  @Test
  fun verifyingAndExtractingKeepFullFraction() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    val verifying = progress(TOTAL).copy(fraction = 1f, phase = DownloadPhase.VERIFYING)
    runtime.send(A, RuntimeDownloadEvent.Progress(verifying))
    runCurrent()
    assertEquals(Downloading(verifying), repo.status(A))

    val extracting = verifying.copy(phase = DownloadPhase.EXTRACTING)
    runtime.send(A, RuntimeDownloadEvent.Progress(extracting))
    runCurrent()
    assertEquals(Downloading(extracting), repo.status(A))
  }

  @Test
  fun secondDownloadWhileActiveIsIgnored() = runTest {
    val repo = repository()
    repo.download(A)
    repo.download(B)
    runCurrent()
    assertEquals(Available, repo.status(B))
    assertEquals(listOf(A), runtime.downloadCalls)
    assertEquals(1, host.startCount)
  }

  @Test
  fun runtimeFailureKeepsReasonAndBytes() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(30)))
    runtime.send(A, RuntimeDownloadEvent.Failed(DownloadFailure.STORAGE))
    runtime.finish(A)
    runCurrent()
    assertEquals(Failed(DownloadFailure.STORAGE, 30), repo.status(A))
  }

  @Test
  fun unexpectedExceptionFailsAsUnknown() = runTest {
    runtime.downloadError = IOException("boom")
    val repo = repository()
    repo.download(A)
    runCurrent()
    assertEquals(Failed(DownloadFailure.UNKNOWN, 0), repo.status(A))
  }

  @Test
  fun refusedForegroundStartFailsWithoutDownloading() = runTest {
    host.startResult = false
    val repo = repository()
    repo.download(A)
    runCurrent()
    assertEquals(Failed(DownloadFailure.BACKGROUND_REFUSED, 0), repo.status(A))
    assertTrue(runtime.downloadCalls.isEmpty())
  }

  @Test
  fun retryFromFailedResumesFromKeptBytes() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(30)))
    runtime.send(A, RuntimeDownloadEvent.Failed(DownloadFailure.NETWORK))
    runtime.finish(A)
    runCurrent()

    repo.download(A)
    assertEquals(Downloading(DownloadProgress(30, 0, null)), repo.status(A))
    runCurrent()
    assertEquals(listOf(A, A), runtime.downloadCalls)
  }

  @Test
  fun pauseCancelsTransferAndKeepsBytes() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(40)))
    runCurrent()

    repo.pause(A)
    runCurrent()
    assertEquals(Paused(40), repo.status(A))
    assertEquals(listOf(A), runtime.cancelled)
  }

  @Test
  fun cancelledEventIsPause() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(40)))
    runtime.send(A, RuntimeDownloadEvent.Cancelled)
    runtime.finish(A)
    runCurrent()
    assertEquals(Paused(40), repo.status(A))
  }

  @Test
  fun flowEndingWithoutCompletedIsPausedNeverDownloaded() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(TOTAL)))
    runtime.finish(A)
    runCurrent()
    assertEquals(Paused(TOTAL), repo.status(A))
  }

  @Test
  fun pauseOnIdleModelIsNoOp() = runTest {
    val repo = repository()
    repo.pause(A)
    assertEquals(Available, repo.status(A))
  }

  @Test
  fun resumeFromPausedDownloadsAgain() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(40)))
    runCurrent()
    repo.pause(A)
    runCurrent()

    repo.download(A)
    runCurrent()
    runtime.send(A, RuntimeDownloadEvent.Progress(progress(60)))
    runCurrent()
    assertEquals(Downloading(progress(60)), repo.status(A))
  }

  @Test
  fun deleteSuccessMakesModelAvailable() = runTest {
    runtime.downloaded += B
    val repo = repository()
    assertTrue(repo.delete(B).isSuccess)
    assertEquals(Available, repo.status(B))
    assertEquals(listOf(B), runtime.deleted)
  }

  @Test
  fun deleteFailureKeepsModelDownloaded() = runTest {
    runtime.downloaded += B
    runtime.deleteError = IOException("locked")
    val repo = repository()
    assertTrue(repo.delete(B).isFailure)
    assertEquals(Downloaded, repo.status(B))
  }

  private companion object {
    const val A = "a"
    const val B = "b"
    const val NPU = "npu"
    const val TOTAL = 100L

    val ROWS =
      listOf(
        row(A, InferenceFramework.INFERENCE_FRAMEWORK_LLAMA_CPP),
        row(B, InferenceFramework.INFERENCE_FRAMEWORK_ONNX),
        row(NPU, InferenceFramework.INFERENCE_FRAMEWORK_QHEXRT),
      )

    fun row(id: String, framework: InferenceFramework) =
      SingleFileModel(
        id,
        "Model $id",
        "https://example.com/$id",
        framework,
        ModelCategory.MODEL_CATEGORY_LANGUAGE,
        TOTAL,
      )
  }
}
