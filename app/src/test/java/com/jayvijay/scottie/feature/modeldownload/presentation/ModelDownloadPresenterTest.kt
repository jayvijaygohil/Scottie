package com.jayvijay.scottie.feature.modeldownload.presentation

import app.cash.turbine.ReceiveTurbine
import com.jayvijay.scottie.feature.modeldownload.domain.entities.AvailableModel
import com.jayvijay.scottie.feature.modeldownload.domain.entities.Compatibility.Shortfall
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.DownloadProgress
import com.jayvijay.scottie.feature.modeldownload.domain.entities.FetchFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.Model
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelCatalog
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus.Available
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelEntry
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType.SPEECH_RECOGNITION
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType.TEXT
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelsFetch
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ShortfallKind.STORAGE
import com.jayvijay.scottie.feature.modeldownload.domain.repository.DownloadStart
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction.EditOpenRouterApiKey
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction.EditOpenRouterBaseUrl
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction.SaveOpenRouter
import com.slack.circuit.test.FakeNavigator
import com.slack.circuit.test.test
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

@Suppress("LargeClass")
class ModelDownloadPresenterTest {
  private val repository = FakeModelDownloadRepository()
  private val navigator = FakeNavigator(ModelDownloadScreen)
  private val openRouter = FakeOpenRouterConfigRepository()
  private val presenter = ModelDownloadPresenter(navigator, repository, openRouter)

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
      assertEquals(listOf(false, false), state.sections().map { it.expanded })

      repository.catalog.value = ready(entry("stt", type = SPEECH_RECOGNITION))
      assertEquals(listOf(SPEECH_RECOGNITION to listOf("stt")), awaitItem().layout())
    }
  }

  @Test
  fun toggleOpensOnlyThatSectionWithoutTouchingDownloads() = runTest {
    val downloading = ModelDownloadStatus.Downloading(DownloadProgress(1, SIZE, 0.1f))
    repository.catalog.value = ready(entry("a", downloading), entry("s", type = SPEECH_RECOGNITION))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.ToggleCategory(TEXT))
      val open = awaitItem()
      assertEquals(listOf(true, false), open.sections().map { it.expanded })
      assertEquals(downloading, open.models().first().status)
      assertEquals(emptyList<String>(), repository.pauses)

      open.eventSink(ModelDownloadAction.ToggleCategory(TEXT))
      assertEquals(listOf(false, false), awaitItem().sections().map { it.expanded })
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
      val toggled = awaitItem()
      assertEquals(listOf(true, false), toggled.sections().map { it.expanded })

      toggled.eventSink(ModelDownloadAction.Search("model"))
      val searching = awaitItem()
      assertEquals(listOf(true, true), searching.sections().map { it.expanded })
      // Toggles are ignored while searching.
      searching.eventSink(ModelDownloadAction.ToggleCategory(SPEECH_RECOGNITION))

      searching.eventSink(ModelDownloadAction.Search(" "))
      val cleared = awaitItem()
      assertEquals(listOf(true, false), cleared.sections().map { it.expanded })
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
  fun useModelSelectsItAndReturnsToTheChat() = runTest {
    repository.catalog.value = ready(entry("a", ModelDownloadStatus.Downloaded))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.UseModel("a"))
      assertEquals("a", awaitItem().activeModelId)
      assertEquals(listOf("a"), repository.selections)
      navigator.awaitPop()
    }
  }

  @Test
  fun useSpeechModelSelectsAudioModelAndReturnsToTheChat() = runTest {
    repository.catalog.value =
      ready(entry("stt", ModelDownloadStatus.Downloaded, type = SPEECH_RECOGNITION))
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.UseModel("stt"))
      assertEquals("stt", awaitItem().activeAudioModelId)
      assertEquals(listOf("stt"), repository.audioSelections)
      assertTrue(repository.selections.isEmpty())
      navigator.awaitPop()
    }
  }

  @Test
  fun selectAudioModelListsDownloadedSpeechThenAudioRemoteAndAllowsClearingToNone() = runTest {
    repository.catalog.value =
      ready(
        entry("a", ModelDownloadStatus.Downloaded),
        entry("stt1", ModelDownloadStatus.Downloaded, type = SPEECH_RECOGNITION),
        entry("stt2", Available, type = SPEECH_RECOGNITION),
        entry("stt3", ModelDownloadStatus.Downloaded, type = SPEECH_RECOGNITION),
      )
    openRouter.config.value =
      OpenRouterConfig(
        URL,
        "sk",
        listOf("openai/gpt-4o", "openai/gpt-4o-audio"),
        audioModels = listOf("openai/gpt-4o-audio"),
      )
    openRouter.nextFetch =
      ModelsFetch.Loaded(
        listOf(
          AvailableModel("openai/gpt-4o", "GPT-4o", audioInput = false),
          AvailableModel("openai/gpt-4o-audio", "GPT-4o Audio", audioInput = true),
        )
      )
    presenter.test {
      val initial = awaitItem()
      assertEquals(
        listOf(
          TextModelOption("stt1", "Model stt1"),
          TextModelOption("stt3", "Model stt3"),
          TextModelOption("openrouter:openai/gpt-4o-audio", "openai/gpt-4o-audio", remote = true),
        ),
        initial.audioModels,
      )
      assertNull(initial.activeAudioModelId)

      initial.eventSink(ModelDownloadAction.SelectAudioModel("openrouter:openai/gpt-4o-audio"))
      var state = awaitItem()
      while (state.activeAudioModelId != "openrouter:openai/gpt-4o-audio") state = awaitItem()
      assertEquals("openrouter:openai/gpt-4o-audio", state.activeAudioModelId)

      state.eventSink(ModelDownloadAction.SelectAudioModel(null))
      while (state.activeAudioModelId != null) state = awaitItem()
      assertNull(state.activeAudioModelId)
      assertEquals(listOf("openrouter:openai/gpt-4o-audio", null), repository.audioSelections)
      navigator.expectNoGoToEvents()
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun toggleRemoteAudioModelPersistsAudioModelsInConfig() = runTest {
    saved()
    openRouter.nextFetch =
      ModelsFetch.Loaded(
        listOf(
          AvailableModel("text-only", "Text Only", audioInput = false),
          AvailableModel("audio-capable", "Audio Capable", audioInput = true),
        )
      )
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.ToggleRemoteModel("audio-capable"))
      awaitUntil { it.savedModelCount == 1 }
        .eventSink(ModelDownloadAction.ToggleRemoteModel("text-only"))
      awaitUntil { it.savedModelCount == 2 }
      assertEquals(listOf("text-only", "audio-capable"), openRouter.config.value?.models)
      assertEquals(listOf("audio-capable"), openRouter.config.value?.audioModels)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun selectModelListsDownloadedLocalThenRemoteAndUpdatesActiveWithoutPopping() = runTest {
    repository.catalog.value =
      ready(
        entry("a", ModelDownloadStatus.Downloaded),
        entry("b", Available),
        entry("stt", ModelDownloadStatus.Downloaded, type = SPEECH_RECOGNITION),
        entry("c", ModelDownloadStatus.Downloaded),
      )
    repository.activeTextModel.value = "a"
    saved("openai/gpt-4o", "qwen/qwen-max")
    fetches("openai/gpt-4o", "qwen/qwen-max")
    presenter.test {
      val initial = awaitItem()
      assertEquals(
        listOf(
          TextModelOption("a", "Model a"),
          TextModelOption("c", "Model c"),
          TextModelOption("openrouter:openai/gpt-4o", "openai/gpt-4o", remote = true),
          TextModelOption("openrouter:qwen/qwen-max", "qwen/qwen-max", remote = true),
        ),
        initial.models,
      )
      assertEquals("a", initial.activeModelId)

      initial.eventSink(ModelDownloadAction.SelectModel("openrouter:openai/gpt-4o"))
      var state = awaitItem()
      while (state.activeModelId != "openrouter:openai/gpt-4o") state = awaitItem()
      assertEquals("openrouter:openai/gpt-4o", state.activeModelId)
      assertEquals(listOf("openrouter:openai/gpt-4o"), repository.selections)
      navigator.expectNoGoToEvents()
      cancelAndIgnoreRemainingEvents()
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

  private suspend fun ReceiveTurbine<ModelDownloadState>.awaitUntil(
    done: (OpenRouterSection) -> Boolean
  ): ModelDownloadState {
    var state = awaitItem()
    while (!done(state.openRouter)) state = awaitItem()
    return state
  }

  private suspend fun ReceiveTurbine<ModelDownloadState>.awaitLoaded(): ModelDownloadState =
    awaitUntil {
      it.list is RemoteModels.Loaded
    }

  private suspend fun ReceiveTurbine<ModelDownloadState>.awaitList(): RemoteModels.Loaded =
    awaitLoaded().openRouter.list as RemoteModels.Loaded

  /** Edits only fields that differ, since an unchanged value emits no new state. */
  private suspend fun ReceiveTurbine<ModelDownloadState>.edit(
    state: ModelDownloadState,
    baseUrl: String = state.openRouter.baseUrl,
    apiKey: String = state.openRouter.apiKey,
  ): ModelDownloadState {
    var current = state
    if (baseUrl != current.openRouter.baseUrl) {
      current.eventSink(EditOpenRouterBaseUrl(baseUrl))
      current = awaitUntil { it.baseUrl == baseUrl }
    }
    if (apiKey != current.openRouter.apiKey) {
      current.eventSink(EditOpenRouterApiKey(apiKey))
      current = awaitUntil { it.apiKey == apiKey }
    }
    return current
  }

  /** Saves the draft and returns the first state showing either the save or errors. */
  private suspend fun ReceiveTurbine<ModelDownloadState>.saveDraft(
    baseUrl: String = URL,
    apiKey: String = "",
  ): ModelDownloadState {
    val saves = openRouter.saves.size
    edit(awaitItem(), baseUrl = baseUrl, apiKey = apiKey).eventSink(SaveOpenRouter)
    return awaitUntil { it.errors.isNotEmpty() || openRouter.saves.size > saves }
  }

  private fun saved(vararg models: String) {
    openRouter.config.value = OpenRouterConfig(URL, "sk", models.toList())
  }

  private fun fetches(vararg ids: String) {
    openRouter.nextFetch = ModelsFetch.Loaded(ids.map { AvailableModel(it, "Model $it") })
  }

  @Test
  fun openRouterSectionStartsWithDefaults() = runTest {
    presenter.test {
      val section = awaitItem().openRouter
      assertEquals(URL, section.baseUrl)
      assertEquals("", section.apiKey)
      assertEquals(0, section.savedModelCount)
      assertEquals(RemoteModels.Hidden, section.list)
      assertFalse(section.expanded)
    }
    assertEquals(0, openRouter.fetches)
  }

  @Test
  fun sectionsAndOpenRouterStartCollapsed() = runTest {
    repository.catalog.value = ready(entry("a"), entry("s", type = SPEECH_RECOGNITION))
    presenter.test {
      val state = awaitItem()
      assertEquals(listOf(false, false), state.sections().map { it.expanded })
      assertFalse(state.openRouter.expanded)
    }
  }

  @Test
  fun saveStoresConfigAndResetsDraftFromIt() = runTest {
    presenter.test {
      saveDraft(apiKey = "sk")
      assertEquals(OpenRouterConfig(URL, "sk", emptyList()), openRouter.saves.single())
      val section = awaitUntil { it.list is RemoteModels.Loaded }.openRouter
      assertEquals(emptySet<OpenRouterField>(), section.errors)
      assertEquals("sk", section.apiKey)
    }
  }

  @Test
  fun saveKeepsSelectionAndFetches() = runTest {
    saved("a")
    fetches("a", "b")
    presenter.test {
      val loaded = awaitLoaded()
      val gate = CompletableDeferred<Unit>().also { openRouter.gate = it }
      loaded.eventSink(EditOpenRouterApiKey("new"))
      awaitUntil { it.apiKey == "new" }.eventSink(SaveOpenRouter)
      awaitUntil { it.list == RemoteModels.Loading }
      assertEquals(OpenRouterConfig(URL, "new", listOf("a")), openRouter.saves.last())
      gate.complete(Unit)
      assertEquals(setOf("a"), awaitList().selected)
      assertEquals(2, openRouter.fetches)
    }
  }

  @Test
  fun openingWithSavedConfigFetchesOnce() = runTest {
    saved("a")
    fetches("a", "b")
    presenter.test {
      val list = awaitList()
      assertEquals(listOf("a", "b"), list.visible.map { it.id })
      assertEquals(2, list.total)
      assertEquals(setOf("a"), list.selected)
      testScheduler.runCurrent()
      assertEquals(1, openRouter.fetches)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun toggleSavesInFetchedOrder() = runTest {
    saved()
    fetches("a", "b", "c")
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.ToggleRemoteModel("c"))
      awaitUntil { (it.list as? RemoteModels.Loaded)?.selected == setOf("c") }
        .eventSink(ModelDownloadAction.ToggleRemoteModel("a"))
      awaitUntil { it.savedModelCount == 2 }
      assertEquals(listOf("a", "c"), openRouter.config.value?.models)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun untoggleRemovesFromSelection() = runTest {
    saved("a", "b")
    fetches("a", "b")
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.ToggleRemoteModel("a"))
      assertEquals(setOf("b"), awaitUntil { it.savedModelCount == 1 }.openRouter.selected())
      assertEquals(listOf("b"), openRouter.config.value?.models)
    }
  }

  @Test
  fun fetchPrunesUnlistedSelection() = runTest {
    saved("gone", "b", "a")
    fetches("a", "b")
    presenter.test {
      assertEquals(setOf("a", "b"), awaitUntil { it.savedModelCount == 2 }.openRouter.selected())
      assertEquals(listOf("a", "b"), openRouter.config.value?.models)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun deleteHidesList() = runTest {
    saved("a")
    fetches("a")
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.DeleteOpenRouter)
      awaitUntil { it.confirmingDelete }.eventSink(ModelDownloadAction.ConfirmDeleteOpenRouter)
      awaitUntil { it.list == RemoteModels.Hidden }
      assertEquals(1, openRouter.clears)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun savingSameValuesRefetches() = runTest {
    openRouter.config.value = OpenRouterConfig(URL, "", emptyList())
    presenter.test {
      awaitLoaded().eventSink(SaveOpenRouter)
      awaitUntil { openRouter.fetches == 2 && it.list is RemoteModels.Loaded }
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun emptyKeySaves() = runTest {
    presenter.test {
      saveDraft()
      assertEquals("", openRouter.saves.single().apiKey)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun savedConfigPrefillsDraft() = runTest {
    openRouter.config.value = OpenRouterConfig("http://10.0.2.2:8080", "sk", listOf("x/y"))
    fetches("x/y")
    presenter.test {
      val section = awaitItem().openRouter
      assertEquals("http://10.0.2.2:8080", section.baseUrl)
      assertEquals("sk", section.apiKey)
      assertEquals(1, section.savedModelCount)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun toggleOpenRouterFlipsExpansion() = runTest {
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.ToggleOpenRouter)
      assertTrue(awaitItem().openRouter.expanded)
    }
  }

  @Test
  fun deleteAsksThenClearsAndResetsDraft() = runTest {
    saved("x/y")
    fetches("x/y")
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.DeleteOpenRouter)
      awaitUntil { it.confirmingDelete }.eventSink(ModelDownloadAction.CancelDeleteOpenRouter)
      val cancelled = awaitUntil { !it.confirmingDelete }
      assertEquals(0, openRouter.clears)

      cancelled.eventSink(ModelDownloadAction.DeleteOpenRouter)
      awaitUntil { it.confirmingDelete }.eventSink(ModelDownloadAction.ConfirmDeleteOpenRouter)
      val confirmed = awaitUntil { !it.confirmingDelete && it.savedModelCount == 0 }.openRouter
      assertEquals(1, openRouter.clears)
      assertEquals(URL to "", confirmed.baseUrl to confirmed.apiKey)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun deleteWithoutSavedConfigIsIgnored() = runTest {
    presenter.test {
      awaitItem().eventSink(ModelDownloadAction.DeleteOpenRouter)
      expectNoEvents()
      assertEquals(0, openRouter.clears)
    }
  }

  @Test
  fun invalidBaseUrlReportsErrorWithoutSaving() = runTest {
    listOf("", "openrouter.ai/api/v1", "x", "$URL?q=1").forEach { baseUrl ->
      ModelDownloadPresenter(navigator, repository, openRouter).test {
        assertEquals(baseUrl, setOf(OpenRouterField.BASE_URL), saveDraft(baseUrl).openRouter.errors)
      }
    }
    assertTrue(openRouter.saves.isEmpty())
  }

  @Test
  fun editingBaseUrlClearsItsError() = runTest {
    presenter.test {
      saveDraft(baseUrl = "x").eventSink(EditOpenRouterBaseUrl(URL))
      assertEquals(emptySet<OpenRouterField>(), awaitUntil { it.baseUrl == URL }.openRouter.errors)
    }
  }

  @Test
  fun httpUrlSaves() = runTest {
    presenter.test {
      saveDraft(baseUrl = "http://10.0.2.2:8080")
      cancelAndIgnoreRemainingEvents()
    }
    assertEquals("http://10.0.2.2:8080", openRouter.saves.single().baseUrl)
  }

  @Test
  fun filterRemoteMatchesNameOrIdIgnoringCase() {
    val models = listOf(AvailableModel("openai/gpt-4o", "GPT-4o"), AvailableModel("q/x", "Qwen"))
    assertEquals(models, filterRemote(models, " "))
    assertEquals(listOf(models[0]), filterRemote(models, " OPENAI "))
    assertEquals(listOf(models[1]), filterRemote(models, "qwe"))
  }

  @Test
  fun remoteSearchKeepsHiddenChecks() = runTest {
    saved("a")
    fetches("a", "b")
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.SearchRemoteModels("model b"))
      val searching = awaitUntil { it.query == "model b" }
      val list = searching.openRouter.list as RemoteModels.Loaded
      assertEquals(listOf("b"), list.visible.map { it.id })
      searching.eventSink(ModelDownloadAction.ToggleRemoteModel("b"))
      awaitUntil { it.savedModelCount == 2 }
      assertEquals(listOf("a", "b"), openRouter.config.value?.models)
    }
  }

  @Test
  fun remoteSearchWithoutMatchesIsEmptyButTotalKept() = runTest {
    saved()
    fetches("a", "b")
    presenter.test {
      awaitLoaded().eventSink(ModelDownloadAction.SearchRemoteModels("zzz"))
      val list = awaitUntil { it.query == "zzz" }.openRouter.list as RemoteModels.Loaded
      assertEquals(emptyList<AvailableModel>() to 2, list.visible to list.total)
    }
  }

  @Test
  fun fetchFailureKindsMapToFailedState() = runTest {
    saved("a")
    FetchFailure.entries.forEach { reason ->
      openRouter.nextFetch = ModelsFetch.Failed(reason)
      ModelDownloadPresenter(navigator, repository, openRouter).test {
        assertEquals(
          RemoteModels.Failed(reason),
          awaitUntil { it.list is RemoteModels.Failed }.openRouter.list,
        )
      }
    }
  }

  @Test
  fun retryRefetchesAndRecovers() = runTest {
    saved("a")
    openRouter.nextFetch = ModelsFetch.Failed(FetchFailure.NO_CONNECTION)
    presenter.test {
      val failed = awaitUntil { it.list is RemoteModels.Failed }
      fetches("a")
      failed.eventSink(ModelDownloadAction.RetryRemoteModels)
      assertEquals(setOf("a"), awaitList().selected)
      assertEquals(2, openRouter.fetches)
    }
  }

  @Test
  fun failedFetchKeepsConfigAndSelection() = runTest {
    saved("a", "b")
    openRouter.nextFetch = ModelsFetch.Failed(FetchFailure.AUTH)
    presenter.test {
      awaitUntil { it.list is RemoteModels.Failed }
      assertEquals(listOf("a", "b"), openRouter.config.value?.models)
      assertTrue(openRouter.saves.isEmpty())
    }
  }

  @Test
  fun reopeningSettingsRefetchesWithSelectionPrechecked() = runTest {
    saved("a")
    fetches("a", "b")
    presenter.test { awaitList() }
    ModelDownloadPresenter(navigator, repository, openRouter).test {
      assertEquals(setOf("a"), awaitList().selected)
    }
    assertEquals(2, openRouter.fetches)
  }

  private fun OpenRouterSection.selected() = (list as RemoteModels.Loaded).selected

  private companion object {
    const val SIZE = 100L
    const val URL = OpenRouterConfig.DEFAULT_BASE_URL
  }
}
