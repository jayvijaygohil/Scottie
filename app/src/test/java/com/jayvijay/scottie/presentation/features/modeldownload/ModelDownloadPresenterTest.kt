package com.jayvijay.scottie.presentation.features.modeldownload

import com.jayvijay.scottie.domain.entities.DownloadFailure
import com.jayvijay.scottie.domain.entities.DownloadProgress
import com.jayvijay.scottie.domain.entities.Model
import com.jayvijay.scottie.domain.entities.ModelCatalog
import com.jayvijay.scottie.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.domain.entities.ModelEntry
import com.jayvijay.scottie.domain.entities.ModelType
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

  private fun ready(vararg statuses: Pair<String, ModelDownloadStatus>) =
    ModelCatalog.Ready(
      statuses.map { (id, status) ->
        ModelEntry(Model(id, "Model $id", ModelType.TEXT, SIZE), status)
      }
    )

  private fun ModelDownloadState.models() = (content as ModelDownloadContent.Models).models

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
    repository.catalog.value = ready("a" to downloading, "b" to ModelDownloadStatus.Available)
    presenter.test {
      val models = awaitItem().models()
      assertEquals(
        ModelDownloadModel("a", "Model a", ModelType.TEXT, SIZE, downloading, canStart = false),
        models[0],
      )
      assertEquals(false, models[1].canStart)

      repository.catalog.value = ready("a" to ModelDownloadStatus.Downloaded)
      assertEquals(true, awaitItem().models().single().canStart)
    }
  }

  @Test
  fun mapsFailedAndPausedRows() = runTest {
    val failed = ModelDownloadStatus.Failed(DownloadFailure.NETWORK, 5)
    val paused = ModelDownloadStatus.Paused(7)
    repository.catalog.value = ready("a" to failed, "b" to paused)
    presenter.test {
      assertEquals(listOf(failed, paused), awaitItem().models().map { it.status })
    }
  }

  @Test
  fun forwardsDownloadRetryAndPause() = runTest {
    repository.catalog.value = ready("a" to ModelDownloadStatus.Available)
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
    repository.catalog.value = ready("a" to ModelDownloadStatus.Downloaded)
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
