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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.segmentedcontrol.XelaSegmentedControlItem
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium

@Composable
fun XelaSegmentedControl(
  items: List<XelaSegmentedControlItem>,
  selectedItemId: Int,
  onSelectedItem: (XelaSegmentedControlItem) -> Unit,
  primaryBackground: Color = XelaColor.Blue6,
  secondaryBackground: Color = XelaColor.Gray12,
  primaryFontColor: Color = Color.White,
  secondaryFontColor: Color = XelaColor.Gray2,
  autoResize: Boolean = false,
) {
  val selectedId: MutableState<Int> = remember { mutableStateOf(selectedItemId) }
  val sizes = mutableListOf<Int>()
  val accentSize = remember {
    mutableStateOf(0)
  }

  val animateSize = remember {
    mutableStateOf(false)
  }

  val accentSizeAnimated =
    animateDpAsState(
      if (animateSize.value) with(LocalDensity.current) { accentSize.value.toDp() + 32.dp }
      else 0.dp
    )

  val offsetX = remember {
    mutableStateOf(0)
  }

  val pxValue = with(LocalDensity.current) { 16.dp.toPx() }.toInt()

  val offsetAnimated =
    animateDpAsState(
      if (animateSize.value) with(LocalDensity.current) { offsetX.value.toDp() } else 0.dp
    )

  Box(
    modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(secondaryBackground)
    // .fillMaxWidth()
  ) {
    Box(modifier = Modifier.offset(x = offsetAnimated.value)) {
      Box(
        modifier =
          Modifier
            // .animateContentSize()
            .width(accentSizeAnimated.value)
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(primaryBackground)
      )
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
      for ((index, item) in items.withIndex()) {
        val animatedColorFont =
          animateColorAsState(
            if (item.id == selectedId.value) primaryFontColor else secondaryFontColor
          )
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
              .padding(16.dp)
              .composed { if (!autoResize) Modifier.weight(1f) else Modifier }
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

                  println(newOffsetX)
                  offsetX.value = newOffsetX
                }
              },
        ) {
          if (!autoResize) {
            Spacer(modifier = Modifier.weight(1f))
          }
          if (item.icon != null) {
            Image(
              painter = painterResource(id = item.icon),
              contentDescription = "segmented control item icon",
              colorFilter = ColorFilter.tint(animatedColorFont.value),
              modifier = Modifier.size(16.dp),
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
          if (!autoResize) {
            Spacer(modifier = Modifier.weight(1f))
          }
        }
      }
    }
  }
}
