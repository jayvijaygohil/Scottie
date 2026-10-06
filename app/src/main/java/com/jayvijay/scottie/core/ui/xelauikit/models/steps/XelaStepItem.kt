package com.jayvijay.scottie.core.ui.xelauikit.models.steps

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class XelaStepItem(
  val id: Int,
  val title: String = "",
  val caption: String = "",
  initialState: XelaStepsState = XelaStepsState.DEFAULT,
) {
  var state by mutableStateOf(initialState)
}
