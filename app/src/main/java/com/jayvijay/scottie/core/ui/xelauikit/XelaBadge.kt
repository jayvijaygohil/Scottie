package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaCaption

@Composable
fun XelaBadge(
  text: String,
  backgroundColor: Color = XelaColor.Blue3,
  textColor: Color = Color.White,
) {
  Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(backgroundColor)) {
    Text(
      text,
      style = xelaCaption,
      color = textColor,
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
    )
  }
}
