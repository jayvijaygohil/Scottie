package com.jayvijay.scottie.feature.modeldownload.data.repository

import com.jayvijay.scottie.feature.modeldownload.data.remote.OpenRouterModelsClient
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import java.io.File
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class OpenRouterConfigRepositoryImplTest {
  @get:Rule val folder = TemporaryFolder()

  private val file by lazy { File(folder.root, "openrouter_config.json") }
  private val config = OpenRouterConfig("https://openrouter.ai", "sk", listOf("a/b", "c/d"))

  private val json = Json { ignoreUnknownKeys = true }

  private fun TestScope.repository() =
    OpenRouterConfigRepositoryImpl(file, json, backgroundScope, OpenRouterModelsClient(json))

  @Test
  fun savedConfigSurvivesNewInstance() = runTest {
    repository().save(config)
    runCurrent()
    assertEquals(config, repository().config.value)
  }

  @Test
  fun clearEmitsNullAndDeletesFile() = runTest {
    val repo = repository()
    repo.save(config)
    runCurrent()
    repo.clear()
    runCurrent()
    assertNull(repo.config.value)
    assertFalse(file.exists())
  }

  @Test
  fun garbageFileYieldsNull() = runTest {
    file.writeText("{garbage")
    assertNull(repository().config.value)
  }

  @Test fun missingFileYieldsNull() = runTest { assertNull(repository().config.value) }
}
