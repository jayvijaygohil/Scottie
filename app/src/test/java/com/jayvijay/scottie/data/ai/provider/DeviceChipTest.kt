package com.jayvijay.scottie.data.ai.provider

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DeviceChipTest {
  @Test
  fun normalizesSocNames() {
    assertEquals("TENSOR_G5", normalizeSoc("Tensor G5"))
    assertEquals("SM8750", normalizeSoc(" sm8750 "))
    assertNull(normalizeSoc(""))
    assertNull(normalizeSoc("unknown"))
    assertNull(normalizeSoc(null))
  }

  @Test
  fun mapsKnownBoardPlatforms() {
    assertEquals("SM8750", boardSoc("sun"))
    assertEquals("SM8650", boardSoc("PINEAPPLE"))
    assertNull(boardSoc("kalama"))
  }

  @Test
  fun socModelWinsOverBoard() {
    assertEquals("SM8750", chipOf(socModel = null, board = "sun"))
    assertEquals("SM8550", chipOf(socModel = "SM8550", board = "kalama"))
  }
}
