package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.tabs.XelaTabItem
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium

@Composable
fun XelaTabs(
  items: List<XelaTabItem>,
  selectedItemId: Int,
  onSelectedItem: (XelaTabItem) -> Unit,
  primaryColor: Color = XelaColor.Blue6,
  secondaryColor: Color = XelaColor.Gray6,
  bottomLineColor: Color = XelaColor.Gray10,
  defaultBadgeBackground: Color = XelaColor.Orange3,
  defaultBadgeTextColor: Color = Color.White,
  selectedBadgeBackground: Color = XelaColor.Orange3,
  selectedBadgeTextColor: Color = Color.White,
) {
  val selectedId = remember { mutableStateOf(selectedItemId) }
  val sizes = mutableListOf<Int>()
  val accentSize = remember {
    mutableStateOf(0)
  }

  val animateSize = remember {
    mutableStateOf(false)
  }

  val accentSizeAnimated =
    animateDpAsState(
      if (animateSize.value) with(LocalDensity.current) { accentSize.value.toDp() + 16.dp }
      else 0.dp
    )

  val offsetX = remember {
    mutableStateOf(0)
  }

  val pxValue = with(LocalDensity.current) { 8.dp.toPx() }.toInt()

  val offsetAnimated =
    animateDpAsState(
      if (animateSize.value) with(LocalDensity.current) { offsetX.value.toDp() } else 0.dp
    )

  Box(
    modifier = Modifier,
    contentAlignment = Alignment.BottomStart,
  ) {
    Box(modifier = Modifier.height(1.dp).fillMaxWidth().background(bottomLineColor))

    Box(modifier = Modifier.offset(x = offsetAnimated.value)) {
      Box(
        modifier =
          Modifier.width(accentSizeAnimated.value)
            .height(3.dp)
            .clip(RectangleShape)
            .background(primaryColor)
      )
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
      for ((index, item) in items.withIndex()) {
        val animatedColorFont =
          animateColorAsState(if (item.id == selectedId.value) primaryColor else secondaryColor)
        Row(
          // horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.height(48.dp)
              .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
              ) {
                selectedId.value = item.id
                onSelectedItem(item)
                accentSize.value = sizes[item.id]
                animateSize.value = true
                var newOffsetX = 0
                for (sizeIndex in 0 until index) {
                  newOffsetX += sizes[sizeIndex]
                  newOffsetX += (pxValue * 2)
                }

                // println(newOffsetX)
                offsetX.value = newOffsetX
              }
              // .background(Color.Red)
              .padding(horizontal = 8.dp, vertical = 16.dp)
              .composed { Modifier.weight(1f) }
              .onSizeChanged {
                sizes.add(item.id, it.width)
                if (accentSize.value == 0 && selectedId.value == item.id) {
                  accentSize.value = sizes[item.id]
                  animateSize.value = true
                  var newOffsetX = 0
                  for (sizeIndex in 0 until index) {
                    newOffsetX += sizes[sizeIndex]
                    newOffsetX += (pxValue * 2)
                  }

                  // println(newOffsetX)
                  offsetX.value = newOffsetX
                }
              },
        ) {
          Spacer(modifier = Modifier.weight(1f))
          if (item.icon != null) {
            Image(
              painter = painterResource(id = item.icon),
              contentDescription = "segmented control item icon",
              colorFilter = ColorFilter.tint(animatedColorFont.value),
              modifier = Modifier.size(15.dp),
            )
          }
          if (item.label.isNotEmpty()) {
            Text(
              item.label,
              style = xelaButtonMedium,
              color = animatedColorFont.value,
              maxLines = 1,
              modifier =
                Modifier.offset(y = (-2).dp).padding(start = if (item.icon != null) 8.dp else 0.dp),
            )
          }
          if (item.badge.isNotEmpty()) {
            Box(
              contentAlignment = Alignment.Center,
              modifier =
                Modifier.size(24.dp)
                  .padding(start = 8.dp)
                  .clip(RoundedCornerShape(6.dp))
                  .background(
                    if (selectedId.value == item.id) selectedBadgeBackground
                    else defaultBadgeBackground
                  ),
            ) {
              Text(
                item.badge,
                color =
                  if (selectedId.value == item.id) selectedBadgeTextColor
                  else defaultBadgeTextColor,
                maxLines = 1,
                modifier = Modifier,
                // .offset(y = (-2).dp),
                // .padding(4.dp),
                fontSize = 10.sp,
              )
            }
          }
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }
  }
}
