package com.jayvijay.scottie.domain.entities

import com.jayvijay.scottie.domain.entities.Compatibility.Compatible
import com.jayvijay.scottie.domain.entities.Compatibility.Shortfall
import org.junit.Assert.assertEquals
import org.junit.Test

class ModelCompatibilityTest {
  @Test
  fun unknownRequirementsPass() {
    for (unknown in listOf(null, 0L, -1L)) {
      assertEquals(Compatible, checkCompatibility(unknown, unknown, 1, 1))
    }
  }

  @Test
  fun unknownAvailabilityPasses() {
    for (unknown in listOf(null, 0L, -1L)) {
      assertEquals(Compatible, checkCompatibility(3_200, 2_000, unknown, unknown))
    }
  }

  @Test
  fun memoryShortfallCarriesBytes() {
    assertEquals(
      Shortfall(ShortfallKind.MEMORY, 3_200, 2_100),
      checkCompatibility(3_200, null, 2_100, null),
    )
  }

  @Test
  fun memoryIsReportedBeforeStorage() {
    assertEquals(
      Shortfall(ShortfallKind.MEMORY, 3_200, 2_100),
      checkCompatibility(3_200, 2_600, 2_100, 1_400),
    )
  }

  @Test
  fun storageShortfallCarriesBytes() {
    assertEquals(
      Shortfall(ShortfallKind.STORAGE, 2_600, 1_400),
      checkCompatibility(1_000, 2_600, 2_000, 1_400),
    )
  }

  @Test
  fun equalAmountsPass() {
    assertEquals(Compatible, checkCompatibility(1_000, 1_000, 1_000, 1_000))
  }
}
