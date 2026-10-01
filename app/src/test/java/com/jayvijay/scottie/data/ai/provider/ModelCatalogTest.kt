package com.jayvijay.scottie.data.ai.provider

import org.junit.Assert.assertEquals
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
}
