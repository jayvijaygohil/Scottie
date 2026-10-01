package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.domain.entities.DownloadFailure
import com.jayvijay.scottie.domain.entities.DownloadProgress
import com.jayvijay.scottie.domain.entities.HardwareTarget
import com.jayvijay.scottie.domain.entities.HardwareTarget.CPU
import com.jayvijay.scottie.domain.entities.HardwareTarget.NPU
import com.jayvijay.scottie.domain.entities.Model
import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus.Available
import com.jayvijay.scottie.domain.entities.ModelEntry
import com.jayvijay.scottie.domain.entities.ModelType
import com.jayvijay.scottie.domain.entities.ModelType.SPEECH_RECOGNITION
import com.jayvijay.scottie.domain.entities.ModelType.TEXT
import com.slack.circuit.test.FakeNavigator
import com.slack.circuit.test.test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ModelDownloadPresenterTest {
  private val repository = FakeModelDownloadRepository()
  private val navigator = FakeNavigator(ModelDownloadScreen)
  private val presenter = ModelDownloadPresenter(navigator, repository)

  private fun entry(
    id: String,
    status: ModelDownloadStatus = Available,
    type: ModelType = TEXT,
    target: HardwareTarget = CPU,
    supported: Boolean = true,
    description: String? = null,
  ) =
    ModelEntry(
      Model(id, "Model $id", type, SIZE, description = description, target = target),
      status,
      supported,
    )

  private fun ready(vararg entries: ModelEntry) = ModelCatalog.Ready(entries.toList())

  private fun ModelDownloadState.sections() = (content as ModelDownloadContent.Models).sections

  private fun ModelDownloadState.models() =
    sections().flatMap { section -> section.groups.flatMap { it.models } }

  /** Ids grouped as type → target → ids, for compact assertions. */
  private fun ModelDownloadState.layout() =
    sections().map { section ->
      section.type to section.groups.map { group -> group.target to group.models.map { it.id } }
    }

  @Test
  fun mapsLoadingAndUnavailable() = runTest {
    presenter.test {
      assertEquals(ModelDownloadContent.Loading, awaitItem().content)
      repository.catalog.value = ModelCatalog.Unavailable
      assertEquals(ModelDownloadContent.Unavailable, awaitItem().content)
    }
  }

  @Test
  fun mapsEntriesAndDisablesStartWhileDownloading() = runTest {
    val downloading = ModelDownloadStatus.Downloading(DownloadProgress(1, SIZE, 0.1f))
    repository.catalog.value = ready(entry("a", downloading, description = "Chat"), entry("b"))
    presenter.test {
      val models = awaitItem().models()
      assertEquals(
        ModelDownloadModel(
          id = "a",
          name = "Model a",
          description = "Chat",
          type = TEXT,
          target = CPU,
          downloadBytes = SIZE,
          status = downloading,
          supported = true,
          canStart = false,
        ),
        models[0],
      )
      assertEquals(false, models[1].canStart)

      repository.catalog.value = ready(entry("a", ModelDownloadStatus.Downloaded))
      assertEquals(true, awaitItem().models().single().canStart)
    }
  }

  @Test
  fun unsupportedModelCannotStart() = runTest {
    repository.catalog.value = ready(entry("a", supported = false), entry("b"))
    presenter.test {
      val (a, b) = awaitItem().models()
      assertEquals(false to false, a.supported to a.canStart)
      assertEquals(true to true, b.supported to b.canStart)
    }
  }

  @Test
  fun mapsFailedAndPausedRows() = runTest {
    val failed = ModelDownloadStatus.Failed(DownloadFailure.NETWORK, 5)
    val paused = ModelDownloadStatus.Paused(7)
    repository.catalog.value = ready(entry("a", failed), entry("b", paused))
    presenter.test {
      assertEquals(listOf(failed, paused), awaitItem().models().map { it.status })
    }
  }

  @Test
  fun groupsByTypeOrderThenCpuBeforeNpuAndHidesEmpty() = runTest {
    repository.catalog.value =
      ready(
        entry("stt", type = SPEECH_RECOGNITION, target = NPU),
        entry("npu", target = NPU),
        entry("cpu1"),
        entry("cpu2"),
      )
    presenter.test {
      val state = awaitItem()
      assertEquals(
        listOf(
          TEXT to listOf(CPU to listOf("cpu1", "cpu2"), NPU to listOf("npu")),
          SPEECH_RECOGNITION to listOf(NPU to listOf("stt")),
        ),
        state.layout(),
      )
      assertEquals(listOf(3, 1), state.sections().map { it.count })
    }
  }

  @Test
  fun npuGroupsStartCollapsedUnlessDeviceCanRunOne() = runTest {
    repository.catalog.value = ready(entry("cpu"), entry("npu", target = NPU, supported = false))
    presenter.test {
      val section = awaitItem().sections().single()
      assertEquals(true, section.expanded)
      assertEquals(listOf(true, false), section.groups.map { it.expanded })

      repository.catalog.value = ready(entry("cpu"), entry("npu", target = NPU))
      assertEquals(listOf(true, true), awaitItem().sections().single().groups.map { it.expanded })
    }
  }

  @Test
  fun togglesFlipSectionsWithoutTouchingDownloads() = runTest {
    val downloading = ModelDownloadStatus.Downloading(DownloadProgress(1, SIZE, 0.1f))
    repository.catalog.value = ready(entry("a", downloading))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.ToggleGroup(TEXT, CPU))
      val groupClosed = awaitItem()
      assertEquals(false, groupClosed.sections().single().groups.single().expanded)

      groupClosed.eventSink(ModelDownloadAction.ToggleCategory(TEXT))
      val categoryClosed = awaitItem()
      assertEquals(false, categoryClosed.sections().single().expanded)
      assertEquals(downloading, categoryClosed.models().single().status)
      assertEquals(emptyList<String>(), repository.pauses)
    }
  }

  @Test
  fun searchMatchesEveryField() = runTest {
    repository.catalog.value =
      ready(
        entry("qwen3-0.6b-q4_k_m"),
        entry("whisper", type = SPEECH_RECOGNITION, description = "Robust transcription"),
        entry("npu", target = NPU, supported = false),
      )
    presenter.test {
      val state = awaitItem()
      suspend fun idsFor(query: String): List<String> {
        state.eventSink(ModelDownloadAction.Search(query))
        return awaitItem().models().map { it.id }
      }
      assertEquals(listOf("qwen3-0.6b-q4_k_m"), idsFor("  Q4_K "))
      assertEquals(listOf("whisper"), idsFor("transcription"))
      assertEquals(listOf("whisper"), idsFor("speech recognition"))
      assertEquals(listOf("npu"), idsFor("NPU"))
      assertEquals(listOf("npu"), idsFor("unsupported"))
      assertEquals(listOf("qwen3-0.6b-q4_k_m", "whisper"), idsFor("supported"))
      assertEquals(listOf("whisper"), idsFor("Model whisper"))
    }
  }

  @Test
  fun searchExpandsMatchesAndClearingRestoresToggles() = runTest {
    repository.catalog.value =
      ready(entry("a"), entry("b", type = SPEECH_RECOGNITION), entry("n", target = NPU))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.ToggleCategory(TEXT))
      val collapsed = awaitItem()
      assertEquals(listOf(false, true), collapsed.sections().map { it.expanded })

      collapsed.eventSink(ModelDownloadAction.Search("model"))
      val searching = awaitItem()
      assertEquals(listOf(true, true), searching.sections().map { it.expanded })
      // Toggles are ignored while searching.
      searching.eventSink(ModelDownloadAction.ToggleCategory(SPEECH_RECOGNITION))

      searching.eventSink(ModelDownloadAction.Search(" "))
      val cleared = awaitItem()
      assertEquals(listOf(false, true), cleared.sections().map { it.expanded })
      assertEquals(listOf("a", "n", "b"), cleared.models().map { it.id })
    }
  }

  @Test
  fun searchWithoutMatchesHasNoSections() = runTest {
    repository.catalog.value = ready(entry("a"))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.Search("zzz"))
      val state = awaitItem()
      assertEquals("zzz", state.query)
      assertEquals(emptyList<ModelSection>(), state.sections())
    }
  }

  @Test
  fun forwardsDownloadRetryAndPause() = runTest {
    repository.catalog.value = ready(entry("a"))
    presenter.test {
      val state = awaitItem()
      state.eventSink(ModelDownloadAction.Download("a"))
      state.eventSink(ModelDownloadAction.Pause("a"))
      state.eventSink(ModelDownloadAction.Download("a")) // Resume / Retry
      assertEquals(listOf("a", "a"), repository.downloads)
      assertEquals(listOf("a"), repository.pauses)
    }
  }

  @Test
  fun backPopsNavigator() = runTest {
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.Back)
      navigator.awaitPop()
    }
  }

  @Test
  fun deleteFailureShowsErrorUntilDismissed() = runTest {
    repository.catalog.value = ready(entry("a", ModelDownloadStatus.Downloaded))
    repository.deleteResult = Result.failure(IllegalStateException("locked"))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.Delete("a"))
      val failed = awaitItem()
      assertEquals("Model a", failed.deleteFailedModelName)
      assertEquals(listOf("a"), repository.deletes)

      failed.eventSink(ModelDownloadAction.DismissError)
      assertNull(awaitItem().deleteFailedModelName)
    }
  }

  private companion object {
    const val SIZE = 100L
  }
}
