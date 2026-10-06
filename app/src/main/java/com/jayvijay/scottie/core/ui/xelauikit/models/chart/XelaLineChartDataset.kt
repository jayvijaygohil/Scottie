package com.jayvijay.scottie.core.ui.xelauikit.models.chart

import androidx.compose.ui.graphics.Color
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor

class XelaLineChartDataset(
  val label: String,
  val data: List<Float>,
  val lineColor: Color = XelaColor.Gray11,
  val pointColor: Color = XelaColor.Gray11,
  val fillColor: Color = Color.Transparent,
  val tension: Float = 0.1f,
  val pointColorBackground: Color = Color.White,
)
