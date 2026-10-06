package com.jayvijay.scottie.core.ui.xelauikit.models.chart

import androidx.compose.ui.graphics.Color
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor

class XelaBarChartDataset(
  val label: String,
  val data: List<Float>,
  val fillColor: Color = XelaColor.Blue3,
)
