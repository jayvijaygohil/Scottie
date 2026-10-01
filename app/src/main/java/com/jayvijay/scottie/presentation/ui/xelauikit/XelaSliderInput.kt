package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import kotlin.math.abs
import kotlin.math.roundToInt

@Composable
fun XelaSliderInput(
  value: Float,
  onValueChange: (Float) -> Unit,
  range: ClosedFloatingPointRange<Float> = 0f..100f,
  step: Float = 0.1f,
  vertical: Boolean = false,
  primaryColor: Color = XelaColor.Blue3,
  secondaryColor: Color = XelaColor.Gray11,
  disabled: MutableState<Boolean> = remember { mutableStateOf(false) },
  controlIcon: Int? = null,
  controlBackground: Color = Color.White,
) {
  val isDrag = remember {
    mutableStateOf(false)
  }

  val currentValue = remember {
    mutableStateOf(value)
  }

  if (value < range.start) {
    currentValue.value = range.start
  }

  val size = remember { mutableStateOf(IntSize.Zero) }
  val animatedControllSize = animateDpAsState(if (isDrag.value) 32.dp else 24.dp)

  val animatedActiveLineSize = animateDpAsState(if (isDrag.value) 8.dp else 4.dp)
  val animatedControlRadius = animateDpAsState(if (isDrag.value) 12.dp else 8.dp)
  val animatedColorIcon = animateColorAsState(if (isDrag.value) primaryColor else secondaryColor)
  val animatedColorBorder =
    animateColorAsState(if (isDrag.value) primaryColor else Color.Transparent)
  val offsetX = remember { mutableStateOf(0f) }

  val minValue = with(LocalDensity.current) { -12.dp.toPx() }

  if (vertical) {
    Box(
      contentAlignment = Alignment.BottomCenter,
      modifier =
        Modifier.padding(vertical = 16.dp)
          .width(32.dp)
          .fillMaxHeight()
          .alpha(if (disabled.value) 0.48f else 1f),
    ) {
      Box(
        modifier =
          Modifier.fillMaxHeight()
            .onSizeChanged {
              size.value = it

              val maxValue = size.value.height.toFloat() - abs(minValue)
              val beginOffset =
                (maxValue - (minValue)) / (range.endInclusive - (range.start)) *
                  (value - (range.start)) + minValue

              offsetX.value = beginOffset
            }
            .width(4.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(secondaryColor)
      )

      Box(
        modifier =
          Modifier.width(animatedActiveLineSize.value)
            .height(with(LocalDensity.current) { minValue.toDp() + offsetX.value.toDp() + 24.dp })
            .clip(RoundedCornerShape(100.dp))
            .background(primaryColor)
      )

      Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(animatedControlRadius.value),
        modifier =
          Modifier
            // .weight(1f)
            .offset { IntOffset(0, -offsetX.value.roundToInt()) }
            .pointerInput(Unit) {
              if (!disabled.value) {
                detectTapGestures(
                  onPress = {
                    isDrag.value = true
                    if (tryAwaitRelease()) {
                      isDrag.value = false
                    }
                  }
                )
              }
            }
            .pointerInput(Unit) {
              if (!disabled.value) {
                detectDragGestures(
                  onDragStart = {
                    isDrag.value = true
                  },
                  onDrag = { change, dragAmount ->
                    change.consumeAllChanges()

                    val maxVal = size.value.height.toFloat() - abs(minValue)
                    offsetX.value = (offsetX.value - dragAmount.y).coerceIn(minValue, maxVal)

                    val result =
                      (offsetX.value - minValue) / (maxVal - minValue) *
                        (range.endInclusive - range.start) + range.start

                    currentValue.value = result
                    onValueChange(currentValue.value)
                  },
                  onDragCancel = {
                    isDrag.value = false
                  },
                  onDragEnd = {
                    isDrag.value = false
                    val newVal = (currentValue.value / step).roundToInt().toFloat() * step
                    currentValue.value = newVal
                    onValueChange(currentValue.value)
                  },
                )
              }
            },
      ) {
        Box(
          contentAlignment = Alignment.Center,
          modifier =
            Modifier.size(animatedControllSize.value)
              .clip(RoundedCornerShape(animatedControlRadius.value))
              .border(
                2.dp,
                animatedColorBorder.value,
                RoundedCornerShape(animatedControlRadius.value),
              )
              .background(controlBackground),
        ) {
          if (controlIcon != null) {
            Image(
              painter = painterResource(id = controlIcon),
              contentDescription = "Slider control icon",
              colorFilter = ColorFilter.tint(animatedColorIcon.value),
              modifier = Modifier.size(14.dp),
            )
          }
        }
      }
    }
  } else {
    Box(
      contentAlignment = Alignment.CenterStart,
      modifier =
        Modifier.padding(horizontal = 16.dp)
          .height(32.dp)
          .fillMaxWidth()
          .alpha(if (disabled.value) 0.48f else 1f),
    ) {
      Box(
        modifier =
          Modifier.fillMaxWidth()
            .onSizeChanged {
              size.value = it

              val maxValue = size.value.width.toFloat() - abs(minValue)
              val beginOffset =
                (maxValue - (minValue)) / (range.endInclusive - (range.start)) *
                  (value - (range.start)) + minValue

              offsetX.value = beginOffset
            }
            .height(4.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(secondaryColor)
      )

      Box(
        modifier =
          Modifier.height(animatedActiveLineSize.value)
            .width(with(LocalDensity.current) { minValue.toDp() + offsetX.value.toDp() + 24.dp })
            .clip(RoundedCornerShape(100.dp))
            .background(primaryColor)
      )

      Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(animatedControlRadius.value),
        modifier =
          Modifier
            // .weight(1f)
            .offset { IntOffset(offsetX.value.roundToInt(), 0) }
            .composed {
              if (!disabled.value) {
                Modifier.pointerInput(Unit) {
                    detectTapGestures(
                      onPress = {
                        isDrag.value = true
                        if (tryAwaitRelease()) {
                          isDrag.value = false
                        }
                      }
                    )
                  }
                  .pointerInput(Unit) {
                    detectDragGestures(
                      onDragStart = {
                        isDrag.value = true
                      },
                      onDrag = { change, dragAmount ->
                        change.consumeAllChanges()

                        val maxVal = size.value.width.toFloat() - abs(minValue)
                        offsetX.value = (offsetX.value + dragAmount.x).coerceIn(minValue, maxVal)

                        val result =
                          (offsetX.value - minValue) / (maxVal - minValue) *
                            (range.endInclusive - range.start) + range.start

                        currentValue.value = result
                        onValueChange(currentValue.value)
                      },
                      onDragCancel = {
                        isDrag.value = false
                      },
                      onDragEnd = {
                        isDrag.value = false
                        val newVal = (currentValue.value / step).roundToInt().toFloat() * step
                        currentValue.value = newVal
                        onValueChange(currentValue.value)
                      },
                    )
                  }
              } else {
                Modifier
              }
            },
      ) {
        Box(
          contentAlignment = Alignment.Center,
          modifier =
            Modifier.size(animatedControllSize.value)
              .clip(RoundedCornerShape(animatedControlRadius.value))
              .border(
                2.dp,
                animatedColorBorder.value,
                RoundedCornerShape(animatedControlRadius.value),
              )
              .background(Color.White),
        ) {
          if (controlIcon != null) {
            Image(
              painter = painterResource(id = controlIcon),
              contentDescription = "Slider control icon",
              colorFilter = ColorFilter.tint(animatedColorIcon.value),
              modifier = Modifier.size(14.dp),
            )
          }
        }
      }
    }
  }
}
