package com.jayvijay.scottie.feature.modeldownload.presentation

import com.jayvijay.scottie.feature.modeldownload.domain.entities.Compatibility.Shortfall
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import com.jayvijay.scottie.feature.modeldownload.domain.entities.Model
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Available
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelEntry
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType.SPEECH_RECOGNITION
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType.TEXT
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ShortfallKind.STORAGE
import com.jayvijay.scottie.feature.modeldownload.domain.repository.DownloadStart
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
    supported: Boolean = true,
    description: String? = null,
    requiresToken: Boolean = false,
  ) =
    ModelEntry(
      Model(id, "Model $id", type, SIZE, description = description, requiresToken = requiresToken),
      status,
      supported,
    )

  private fun ready(vararg entries: ModelEntry) = ModelCatalog.Ready(entries.toList())

  private fun ModelDownloadState.sections() = (content as ModelDownloadContent.Models).sections

  private fun ModelDownloadState.models() = sections().flatMap { it.models }

  /** Ids grouped by type, for compact assertions. */
  private fun ModelDownloadState.layout() =
    sections().map { section -> section.type to section.models.map { it.id } }

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
  fun tokenModelIsSupportedButCannotStart() = runTest {
    repository.catalog.value = ready(entry("t", requiresToken = true))
    presenter.test {
      val model = awaitItem().models().single()
      assertEquals(true to false, model.supported to model.canStart)
    }
  }

  @Test
  fun groupsByTypeOrderAndHidesEmpty() = runTest {
    repository.catalog.value =
      ready(entry("stt", type = SPEECH_RECOGNITION), entry("t1"), entry("t2"))
    presenter.test {
      val state = awaitItem()
      assertEquals(
        listOf(TEXT to listOf("t1", "t2"), SPEECH_RECOGNITION to listOf("stt")),
        state.layout(),
      )
      assertEquals(listOf(2, 1), state.sections().map { it.count })
      assertEquals(listOf(true, true), state.sections().map { it.expanded })

      repository.catalog.value = ready(entry("stt", type = SPEECH_RECOGNITION))
      assertEquals(listOf(SPEECH_RECOGNITION to listOf("stt")), awaitItem().layout())
    }
  }

  @Test
  fun toggleCollapsesOnlyThatSectionWithoutTouchingDownloads() = runTest {
    val downloading = ModelDownloadStatus.Downloading(DownloadProgress(1, SIZE, 0.1f))
    repository.catalog.value = ready(entry("a", downloading), entry("s", type = SPEECH_RECOGNITION))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.ToggleCategory(TEXT))
      val closed = awaitItem()
      assertEquals(listOf(false, true), closed.sections().map { it.expanded })
      assertEquals(downloading, closed.models().first().status)
      assertEquals(emptyList<String>(), repository.pauses)

      closed.eventSink(ModelDownloadAction.ToggleCategory(TEXT))
      assertEquals(listOf(true, true), awaitItem().sections().map { it.expanded })
    }
  }

  @Test
  fun searchMatchesEveryField() = runTest {
    repository.catalog.value =
      ready(
        entry("qwen3-0.6b-q4_k_m"),
        entry("whisper", type = SPEECH_RECOGNITION, description = "Robust transcription"),
        entry("big", supported = false),
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
      assertEquals(emptyList<String>(), idsFor("npu"))
      assertEquals(listOf("big"), idsFor("unsupported"))
      assertEquals(listOf("qwen3-0.6b-q4_k_m", "whisper"), idsFor("supported"))
      assertEquals(listOf("whisper"), idsFor("Model whisper"))
    }
  }

  @Test
  fun searchExpandsMatchesAndClearingRestoresToggles() = runTest {
    repository.catalog.value = ready(entry("a"), entry("b", type = SPEECH_RECOGNITION), entry("n"))
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
  fun refusedDownloadShowsShortfallUntilDismissed() = runTest {
    repository.catalog.value = ready(entry("a"))
    repository.downloadResult =
      DownloadStart.Refused(Shortfall(STORAGE, 2_600_000_000, 1_400_000_000))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.Download("a"))
      val refused = awaitItem()
      assertEquals(
        ModelDownloadError.Shortfall(STORAGE, 2_600_000_000, 1_400_000_000),
        refused.error,
      )
      refused.eventSink(ModelDownloadAction.DismissError)
      assertNull(awaitItem().error)
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
      testScheduler.runCurrent()
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
      assertEquals(ModelDownloadError.DeleteFailed("Model a"), failed.error)
      assertEquals(listOf("a"), repository.deletes)

      failed.eventSink(ModelDownloadAction.DismissError)
      assertNull(awaitItem().error)
    }
  }

  private companion object {
    const val SIZE = 100L
  }
}
