package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaCaption

@Composable
fun XelaAlert(
  title: String,
  text: String,
  leftIcon: Int? = null,
  rightIcon: Int? = null,
  primaryColor: Color = XelaColor.Blue6,
  secondaryColor: Color = XelaColor.Gray7,
  background: Color = Color.White,
  rightIconColor: Color = XelaColor.Gray6,
) {
  val size = remember { mutableStateOf(IntSize.Zero) }
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier =
      Modifier.clip(RoundedCornerShape(16.dp))
        .background(background)
        .onSizeChanged { size.value = it }
        .fillMaxWidth(),
  ) {
    Box(
      modifier =
        Modifier.clip(RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp))
          .background(primaryColor)
          // .padding(vertical = 16.dp)
          .width(4.dp)
          .height(with(LocalDensity.current) { size.value.height.toDp() - 32.dp })
    )

    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(16.dp),
    ) {
      if (leftIcon != null) {
        Image(
          painter = painterResource(id = leftIcon),
          colorFilter = ColorFilter.tint(primaryColor),
          contentDescription = "Alert Left Icon",
          modifier = Modifier.size(15.dp),
        )
      }

      Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier =
          Modifier.padding(
              start = if (leftIcon != null) 16.dp else 0.dp,
              end = if (rightIcon != null) 16.dp else 0.dp,
            )
            .weight(1f),
      ) {
        if (title.isNotEmpty()) {
          Text(title, style = xelaButtonMedium, color = primaryColor)
        }

        if (text.isNotEmpty()) {
          Text(text, style = xelaCaption, color = secondaryColor)
        }
      }

      if (rightIcon != null) {
        Image(
          painter = painterResource(id = rightIcon),
          colorFilter = ColorFilter.tint(rightIconColor),
          contentDescription = "Alert Right Icon",
          modifier = Modifier.size(15.dp),
        )
      }
    }
  }
}
