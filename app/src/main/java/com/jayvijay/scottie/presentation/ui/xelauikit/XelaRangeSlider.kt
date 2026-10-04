package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

private const val DEFAULT_MAX_RANGE = 100f
private const val DISABLED_ALPHA = 0.48f

@Composable
fun XelaRangeSlider(
  valueLeft: Float,
  valueRight: Float,
  onValueLeftChange: (Float) -> Unit,
  onValueRightChange: (Float) -> Unit,
  range: ClosedFloatingPointRange<Float> = 0f..DEFAULT_MAX_RANGE,
  step: Float = 0.1f,
  primaryColor: Color = XelaColor.Blue3,
  secondaryColor: Color = XelaColor.Gray11,
  disabled: Boolean = false,
  controlIcon: Int? = null,
  controlBackground: Color = Color.White,
) {

  val isDrag = remember {
    mutableStateOf(false)
  }

  val currentValueLeft = remember {
    mutableStateOf(valueLeft)
  }

  if (valueLeft < range.start) {
    currentValueLeft.value = range.start
  }

  val currentValueRight = remember {
    mutableStateOf(valueRight)
  }

  if (valueRight < range.start) {
    currentValueRight.value = range.start
  }

  val size = remember { mutableStateOf(IntSize.Zero) }
  val animatedControllSize = animateDpAsState(if (isDrag.value) 32.dp else 24.dp)

  val animatedActiveLineSize = animateDpAsState(if (isDrag.value) 8.dp else 4.dp)
  val animatedControlRadius = animateDpAsState(if (isDrag.value) 12.dp else 8.dp)
  val animatedColorIcon = animateColorAsState(if (isDrag.value) primaryColor else secondaryColor)
  val animatedColorBorder =
    animateColorAsState(if (isDrag.value) primaryColor else Color.Transparent)
  val offsetXLeft = remember { mutableStateOf(0f) }
  val offsetXRight = remember { mutableStateOf(0f) }

  val minValue = with(LocalDensity.current) { -12.dp.toPx() }

  Box(
    contentAlignment = Alignment.CenterStart,
    modifier =
      Modifier.padding(horizontal = 16.dp)
        .height(32.dp)
        .fillMaxWidth()
        .alpha(if (disabled) DISABLED_ALPHA else 1f),
  ) {
    Box(
      modifier =
        Modifier.fillMaxWidth()
          .onSizeChanged {
            size.value = it

            val maxValue = size.value.width.toFloat() - abs(minValue)
            val beginLeftOffset =
              (maxValue - (minValue)) / (range.endInclusive - (range.start)) *
                (valueLeft - (range.start)) + minValue

            offsetXLeft.value = beginLeftOffset

            val beginRightOffset =
              (maxValue - (minValue)) / (range.endInclusive - (range.start)) *
                (valueRight - (range.start)) + minValue

            offsetXRight.value = beginRightOffset
          }
          .height(4.dp)
          .clip(RoundedCornerShape(100.dp))
          .background(secondaryColor)
    )

    //        Box(
    //            modifier = Modifier
    //                .height(4.dp)
    //                .width(with(LocalDensity.current) { minValue.toDp() + offsetXLeft.value.toDp()
    // + 24.dp })
    //                .clip(RoundedCornerShape(100.dp))
    //                .background(secondaryColor)
    //        )
    //
    //        Box(
    //            modifier = Modifier
    //                .height(4.dp)
    //                .width(with(LocalDensity.current) { (size.value.width.toFloat() -
    // abs(minValue) - minValue + offsetXRight.value).toDp() + 24.dp })
    //                .clip(RoundedCornerShape(100.dp))
    //                .offset { IntOffset(offsetXRight.value.roundToInt(), 0) }
    //                .background(secondaryColor)
    //        )

    Box(
      modifier =
        Modifier.height(animatedActiveLineSize.value)
          .width(with(LocalDensity.current) { abs((offsetXRight.value)).toDp() + 24.dp })
          .clip(RoundedCornerShape(100.dp))
          .offset(x = with(LocalDensity.current) { offsetXLeft.value.toDp() })
          .background(primaryColor)
    )

    Surface(
      shadowElevation = 4.dp,
      shape = RoundedCornerShape(animatedControlRadius.value),
      modifier =
        Modifier
          // .weight(1f)
          .offset { IntOffset(offsetXLeft.value.roundToInt(), 0) }
          .pointerInput(Unit) {
            if (!disabled) {
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
            if (!disabled) {
              detectDragGestures(
                onDragStart = {
                  isDrag.value = true
                },
                onDrag = { change, dragAmount ->
                  change.consumeAllChanges()

                  val maxVal = size.value.width.toFloat() - abs(minValue)
                  offsetXLeft.value =
                    (offsetXLeft.value + dragAmount.x).coerceIn(
                      minValue,
                      offsetXRight.value.toFloat() - abs(minValue * 2),
                    )

                  val result =
                    (offsetXLeft.value - minValue) / (maxVal - minValue) *
                      (range.endInclusive - range.start) + range.start

                  currentValueLeft.value = result
                  onValueLeftChange(currentValueLeft.value)
                },
                onDragCancel = {
                  isDrag.value = false
                },
                onDragEnd = {
                  isDrag.value = false
                  val newVal = (currentValueLeft.value / step).roundToInt().toFloat() * step
                  currentValueLeft.value = newVal
                  onValueLeftChange(currentValueLeft.value)
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

    Surface(
      shadowElevation = 4.dp,
      shape = RoundedCornerShape(animatedControlRadius.value),
      modifier =
        Modifier
          // .weight(1f)
          .offset { IntOffset(offsetXRight.value.roundToInt(), 0) }
          .pointerInput(Unit) {
            if (!disabled) {
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
            if (!disabled) {
              detectDragGestures(
                onDragStart = {
                  isDrag.value = true
                },
                onDrag = { change, dragAmount ->
                  change.consumeAllChanges()

                  val maxVal = size.value.width.toFloat() - abs(minValue)
                  offsetXRight.value =
                    (offsetXRight.value + dragAmount.x).coerceIn(
                      offsetXLeft.value + abs(minValue * 2),
                      maxVal,
                    )

                  val result =
                    (offsetXRight.value - minValue) / (maxVal - minValue) *
                      (range.endInclusive - range.start) + range.start

                  currentValueRight.value = result
                  onValueRightChange(currentValueRight.value)
                },
                onDragCancel = {
                  isDrag.value = false
                },
                onDragEnd = {
                  isDrag.value = false
                  val newVal = (currentValueRight.value / step).roundToInt().toFloat() * step
                  currentValueRight.value = newVal
                  onValueRightChange(currentValueRight.value)
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
}
