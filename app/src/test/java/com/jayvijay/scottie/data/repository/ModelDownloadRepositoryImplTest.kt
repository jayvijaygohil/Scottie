package com.jayvijay.scottie.data.repository

import ai.runanywhere.proto.v1.ArchiveStructure
import ai.runanywhere.proto.v1.ArchiveType
import ai.runanywhere.proto.v1.InferenceFramework
import ai.runanywhere.proto.v1.ModelCategory
import com.jayvijay.scottie.data.ai.provider.ArchiveModel
import com.jayvijay.scottie.data.ai.provider.CatalogModel
import com.jayvijay.scottie.data.ai.provider.FakeDeviceResources
import com.jayvijay.scottie.data.ai.provider.FakeDownloadForegroundHost
import com.jayvijay.scottie.data.ai.provider.FakeModelRuntime
import com.jayvijay.scottie.data.ai.provider.LiteRtModel
import com.jayvijay.scottie.data.ai.provider.MultiFileModel
import com.jayvijay.scottie.data.ai.provider.RuntimeDownloadEvent
import com.jayvijay.scottie.domain.entities.Compatibility.Shortfall
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
import com.jayvijay.scottie.domain.entities.ShortfallKind
import com.jayvijay.scottie.domain.repository.DownloadStart
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
  private val resources = FakeDeviceResources()

  private fun TestScope.repository(rows: List<CatalogModel> = ROWS): ModelDownloadRepositoryImpl =
    ModelDownloadRepositoryImpl(runtime, host, resources, rows, backgroundScope).also {
      runCurrent()
    }

  private fun ModelDownloadRepositoryImpl.entries() = (catalog.value as ModelCatalog.Ready).entries

  private fun ModelDownloadRepositoryImpl.status(id: String): ModelDownloadStatus =
    (catalog.value as ModelCatalog.Ready).entries.single { it.model.id == id }.status

  private fun progress(done: Long, fraction: Float? = done / TOTAL.toFloat()) =
    DownloadProgress(done, TOTAL, fraction)

  @Test
  fun catalogLoadsWithDownloadedIdsApplied() = runTest {
    runtime.downloaded += B
    val repo = ModelDownloadRepositoryImpl(runtime, host, resources, ROWS, backgroundScope)
    assertEquals(ModelCatalog.Loading, repo.catalog.value)
    runCurrent()

    val entries = repo.entries()
    assertEquals(listOf(A, B, TOKEN), entries.map { it.model.id })
    assertEquals(listOf(Available, Downloaded, Available), entries.map { it.status })
    assertEquals(
      listOf(ModelType.SPEECH_RECOGNITION, ModelType.SPEECH_RECOGNITION, ModelType.TEXT),
      entries.map { it.model.type },
    )
    assertEquals(listOf(false, false, true), entries.map { it.model.requiresToken })
  }

  @Test
  fun prepareFailureMakesCatalogUnavailable() = runTest {
    runtime.prepareError = IllegalStateException("init")
    assertEquals(ModelCatalog.Unavailable, repository().catalog.value)
  }

  @Test
  fun rowsTheRuntimeRejectsAreNotListed() = runTest {
    runtime.accepted = setOf(A, B)
    assertEquals(listOf(A, B), repository().entries().map { it.model.id })
  }

  @Test
  fun supportedFollowsTheCompatibilityRule() = runTest {
    resources.availableMemory = TOTAL - 1
    assertEquals(listOf(false, false, false), repository().entries().map { it.supported })
  }

  @Test
  fun storageShortfallAtLoadIsUnsupported() = runTest {
    resources.availableStorage = TOTAL - 1
    assertEquals(listOf(false, false, false), repository().entries().map { it.supported })
  }

  @Test
  fun unknownDeviceValuesDoNotBlock() = runTest {
    assertTrue(repository().entries().all { it.supported })
  }

  @Test
  fun unknownDownloadSizePassesTheStorageCheck() = runTest {
    resources.availableStorage = 1
    val repo = repository(listOf(ARCHIVE))
    assertTrue(repo.entries().single().supported)
    assertEquals(DownloadStart.Started, repo.download(ARCHIVE.id))
  }

  @Test
  fun memoryShortfallAtStartRefusesWithoutDownloading() = runTest {
    val repo = repository()
    resources.availableMemory = TOTAL - 1
    assertEquals(
      DownloadStart.Refused(Shortfall(ShortfallKind.MEMORY, TOTAL, TOTAL - 1)),
      repo.download(A),
    )
    runCurrent()
    assertEquals(Available, repo.status(A))
    assertEquals(emptyList<String>(), runtime.downloadCalls)
    assertEquals(0, host.startCount)
  }

  @Test
  fun storageShortfallAtStartRefusesWithoutDownloading() = runTest {
    val repo = repository()
    repo.download(A)
    runCurrent()
    repo.pause(A)
    runCurrent()
    resources.availableStorage = TOTAL - 1
    assertEquals(
      DownloadStart.Refused(Shortfall(ShortfallKind.STORAGE, TOTAL, TOTAL - 1)),
      repo.download(A),
    )
    assertEquals(Paused(0), repo.status(A))
    assertEquals(listOf(A), runtime.downloadCalls)
  }

  @Test
  fun startTimeCheckOverridesLoadVerdict() = runTest {
    resources.availableMemory = TOTAL - 1
    val repo = repository()
    resources.availableMemory = TOTAL
    assertEquals(DownloadStart.Started, repo.download(A))
  }

  @Test
  fun tokenRowIsIgnoredWithoutProbing() = runTest {
    val repo = repository()
    val probes = resources.probes
    assertEquals(DownloadStart.Ignored, repo.download(TOKEN))
    runCurrent()
    assertEquals(probes, resources.probes)
    assertEquals(Available, repo.status(TOKEN))
    assertEquals(emptyList<String>(), runtime.downloadCalls)
  }

  @Test
  fun unknownIdIsIgnored() = runTest {
    assertEquals(DownloadStart.Ignored, repository().download("missing"))
  }

  @Test
  fun downloadedModelCanBeDeleted() = runTest {
    runtime.downloaded += A
    val repo = repository()
    assertEquals(DownloadStart.Ignored, repo.download(A))
    assertTrue(repo.delete(A).isSuccess)
    assertEquals(Available, repo.status(A))
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
    assertEquals(DownloadStart.Started, repo.download(A))
    assertEquals(DownloadStart.Ignored, repo.download(B))
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
    const val TOKEN = "token.litertlm"
    const val TOTAL = 100L

    val ARCHIVE =
      ArchiveModel(
        "archive",
        "Archive",
        "https://example.com/archive.tar.gz",
        InferenceFramework.INFERENCE_FRAMEWORK_SHERPA,
        ModelCategory.MODEL_CATEGORY_SPEECH_RECOGNITION,
        TOTAL,
        ArchiveType.ARCHIVE_TYPE_TAR_GZ,
        ArchiveStructure.ARCHIVE_STRUCTURE_NESTED_DIRECTORY,
      )

    val ROWS: List<CatalogModel> =
      listOf(
        stt(A),
        stt(B),
        LiteRtModel(TOKEN, "Token", "https://example.com/t", TOTAL, TOTAL, true),
      )

    fun stt(id: String) =
      MultiFileModel(
        id,
        "Model $id",
        InferenceFramework.INFERENCE_FRAMEWORK_SHERPA,
        ModelCategory.MODEL_CATEGORY_SPEECH_RECOGNITION,
        TOTAL,
        files = emptyList(),
      )
  }
}
