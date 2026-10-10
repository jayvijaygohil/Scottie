package com.jayvijay.scottie.feature.modeldownload.data.remote

import com.jayvijay.scottie.feature.modeldownload.domain.entities.AvailableModel
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class OpenRouterModelsClientTest {
  private val client = OpenRouterModelsClient(Json { ignoreUnknownKeys = true })

  private fun available(vararg pages: String) =
    toAvailable(pages.flatMap { client.parsePage(it).data.orEmpty() })

  @Test
  fun specExampleEntryIsListed() {
    val page =
      """
      {"data":[{"id":"anthropic/claude-haiku-5.5","name":"Anthropic: Claude Haiku 5.5",
        "pricing":{"prompt":"0.000001"},
        "architecture":{"output_modalities":["text"]}}],"links":{"next":null}}
      """
    assertEquals(
      listOf(AvailableModel("anthropic/claude-haiku-5.5", "Anthropic: Claude Haiku 5.5")),
      available(page),
    )
    assertNull(client.parsePage(page).links?.next)
  }

  @Test
  fun keepsTextAndUnknownModalitiesOnly() {
    val page =
      """
      {"data":[
        {"id":"img","name":"Image","architecture":{"output_modalities":["image"]}},
        {"id":"mixed","name":"Mixed","architecture":{"output_modalities":["image","TEXT"]}},
        {"id":"bare","name":"Bare"},
        {"id":"partial","name":"Partial","architecture":{}}
      ]}
      """
    assertEquals(listOf("bare", "mixed", "partial"), available(page).map { it.id })
  }

  @Test
  fun missingNameShowsIdAndMissingIdIsSkipped() {
    val page = """{"data":[{"id":"a/b"},{"name":"No id"},{"id":" ","name":"Blank"}]}"""
    assertEquals(listOf(AvailableModel("a/b", "a/b")), available(page))
  }

  @Test
  fun duplicatesAcrossPagesShowOnceAndSortByNameThenId() {
    val first = """{"data":[{"id":"z","name":"beta"},{"id":"y","name":"Alpha"}]}"""
    val second = """{"data":[{"id":"z","name":"Beta again"},{"id":"x","name":"alpha"}]}"""
    assertEquals(
      listOf(
        AvailableModel("x", "alpha"),
        AvailableModel("y", "Alpha"),
        AvailableModel("z", "beta"),
      ),
      available(first, second),
    )
  }

  @Test
  fun blankOrMissingNextEndsPaging() {
    assertEquals(" ", client.parsePage("""{"links":{"next":" "}}""").links?.next)
    assertNull(client.parsePage("""{"data":[]}""").links)
    assertEquals("/p2", client.parsePage("""{"links":{"next":"/p2"}}""").links?.next)
  }
}
