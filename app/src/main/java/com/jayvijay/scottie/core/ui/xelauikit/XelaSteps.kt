package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.steps.XelaStepItem
import com.jayvijay.scottie.core.ui.xelauikit.models.steps.XelaStepsOrientation
import com.jayvijay.scottie.core.ui.xelauikit.models.steps.XelaStepsState
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaCaption

@Composable
fun XelaSteps(
  steps: MutableList<XelaStepItem>,
  orientation: XelaStepsOrientation = XelaStepsOrientation.VERTICAL,
  primaryTextColor: Color = XelaColor.Gray3,
  secondaryTextColor: Color = XelaColor.Gray7,
  primaryAccentColor: Color = XelaColor.Blue3,
  secondaryAccentColor: Color = XelaColor.Blue11,
  secondaryColor: Color = XelaColor.Gray11,
  errorColor: Color = XelaColor.Red3,
  iconColor: Color = Color.White,
  lines: Boolean = true,
) {

  if (orientation == XelaStepsOrientation.VERTICAL) {
    Column(
      horizontalAlignment = Alignment.Start,
      modifier = Modifier,
    ) {
      steps.forEach {
        val step = it
        println(steps.size)
        Row(
          horizontalArrangement = Arrangement.Start,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (steps.first().id != step.id) {
              Box(
                modifier =
                  Modifier.size(width = 2.dp, height = 12.dp)
                    .padding(bottom = 4.dp)
                    .alpha(if (lines) 1f else 0f)
                    .background(
                      if (
                        step.state == XelaStepsState.ACTIVE ||
                          step.state == XelaStepsState.COMPLETED
                      ) {
                        primaryAccentColor
                      } else {
                        if (step.state == XelaStepsState.ERROR) {
                          errorColor
                        } else {
                          secondaryColor
                        }
                      }
                    )
              )
            }

            Box(
              contentAlignment = Alignment.Center,
              modifier =
                Modifier.clip(RoundedCornerShape(12.dp))
                  .size(32.dp)
                  .background(
                    if (step.state == XelaStepsState.DEFAULT) secondaryColor
                    else {
                      if (step.state == XelaStepsState.ACTIVE) secondaryAccentColor
                      else {
                        if (step.state == XelaStepsState.COMPLETED) primaryAccentColor
                        else errorColor
                      }
                    }
                  ),
            ) {
              when (step.state) {
                XelaStepsState.COMPLETED -> {
                  XelaIconTick(color = iconColor)
                }
                XelaStepsState.ERROR -> {
                  XelaIconXmark(color = iconColor, size = 15.dp)
                }
                else -> {
                  Text(
                    step.id.toString(),
                    style = xelaButtonMedium,
                    modifier = Modifier.padding(8.dp).offset(y = (-2).dp),
                    color =
                      if (step.state == XelaStepsState.ACTIVE) primaryAccentColor
                      else primaryTextColor,
                  )
                }
              }
            }
            if (steps.last().id != step.id) {
              Box(
                modifier =
                  Modifier.size(width = 2.dp, height = 12.dp)
                    .padding(top = 4.dp)
                    .alpha(if (lines) 1f else 0f)
                    .background(
                      if (
                        step.state == XelaStepsState.ACTIVE ||
                          step.state == XelaStepsState.COMPLETED
                      ) {
                        primaryAccentColor
                      } else {
                        if (step.state == XelaStepsState.ERROR) {
                          errorColor
                        } else {
                          secondaryColor
                        }
                      }
                    )
              )
            }
          }
          Column(
            modifier =
              Modifier.weight(1f)
                .padding(start = 12.dp)
                .padding(top = if (steps.last().id != step.id) 0.dp else 9.dp)
                .padding(bottom = if (steps.first().id != step.id) 0.dp else (9).dp)
          ) {
            if (step.title.isNotEmpty()) {
              Text(
                step.title,
                style = xelaButtonMedium,
                color =
                  if (step.state == XelaStepsState.ACTIVE) primaryAccentColor else primaryTextColor,
              )
            }
            if (step.caption.isNotEmpty()) {
              Text(step.caption, style = xelaCaption, color = secondaryTextColor)
            }
          }
        }
      }
    }
  } else {
    Row(modifier = Modifier.fillMaxWidth()) {
      for (step in steps) {
        Column(
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier.weight(1f),
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier =
                Modifier.weight(1f)
                  .height(2.dp)
                  .fillMaxWidth()
                  .padding(end = 4.dp)
                  .alpha(if (lines && steps.first().id != step.id) 1f else 0f)
                  .background(
                    if (
                      step.state == XelaStepsState.ACTIVE || step.state == XelaStepsState.COMPLETED
                    ) {
                      primaryAccentColor
                    } else {
                      if (step.state == XelaStepsState.ERROR) {
                        errorColor
                      } else {
                        secondaryColor
                      }
                    }
                  )
            )

            Box(
              contentAlignment = Alignment.Center,
              modifier =
                Modifier
                  // .weight(1f)
                  .clip(RoundedCornerShape(12.dp))
                  .size(32.dp)
                  .background(
                    if (step.state == XelaStepsState.DEFAULT) secondaryColor
                    else {
                      if (step.state == XelaStepsState.ACTIVE) secondaryAccentColor
                      else {
                        if (step.state == XelaStepsState.COMPLETED) primaryAccentColor
                        else errorColor
                      }
                    }
                  ),
            ) {
              when (step.state) {
                XelaStepsState.COMPLETED -> {
                  XelaIconTick(color = iconColor)
                }
                XelaStepsState.ERROR -> {
                  XelaIconXmark(color = iconColor, size = 15.dp)
                }
                else -> {
                  Text(
                    step.id.toString(),
                    style = xelaButtonMedium,
                    modifier = Modifier.padding(8.dp).offset(y = (-2).dp),
                    color =
                      if (step.state == XelaStepsState.ACTIVE) primaryAccentColor
                      else primaryTextColor,
                  )
                }
              }
            }

            Box(
              modifier =
                Modifier.weight(1f)
                  .fillMaxWidth()
                  .height(2.dp)
                  .padding(start = 4.dp)
                  .alpha(if (lines && steps.last().id != step.id) 1f else 0f)
                  .background(
                    if (
                      step.state == XelaStepsState.ACTIVE || step.state == XelaStepsState.COMPLETED
                    ) {
                      primaryAccentColor
                    } else {
                      if (step.state == XelaStepsState.ERROR) {
                        errorColor
                      } else {
                        secondaryColor
                      }
                    }
                  )
            )
          }
          Column(
            modifier = Modifier.padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            if (step.title.isNotEmpty()) {
              Text(
                step.title,
                style = xelaButtonMedium,
                color =
                  if (step.state == XelaStepsState.ACTIVE) primaryAccentColor else primaryTextColor,
                textAlign = TextAlign.Center,
              )
            }
            if (step.caption.isNotEmpty()) {
              Text(
                step.caption,
                style = xelaCaption,
                color = secondaryTextColor,
                textAlign = TextAlign.Center,
              )
            }
          }
        }
      }
    }
  }
}

private const val TICK_X_MID_FACTOR = 0.4f
private const val TICK_Y_END_FACTOR = 0.8f

@Composable
fun XelaIconTick(
  color: Color = Color.White,
  size: Dp = 16.dp,
  strokeWidth: Dp = 1.dp,
  modifier: Modifier = Modifier,
) {
  Canvas(
    modifier = Modifier.size(size = size).composed { modifier },
    onDraw = {
      val width = size.toPx()
      val height = size.toPx()
      drawLine(
        color,
        Offset(x = 0f, y = height * 0.5f),
        Offset(x = width * TICK_X_MID_FACTOR, height * TICK_Y_END_FACTOR),
        strokeWidth = strokeWidth.toPx(),
      )
      drawLine(
        color,
        Offset(x = width * TICK_X_MID_FACTOR, height * TICK_Y_END_FACTOR),
        Offset(x = width, y = height * 0.2f),
        strokeWidth = strokeWidth.toPx(),
      )
    },
  )
}

@Composable
fun XelaIconXmark(
  color: Color = Color.White,
  size: Dp = 16.dp,
  strokeWidth: Dp = 1.dp,
  modifier: Modifier = Modifier,
) {
  Canvas(
    modifier = Modifier.size(size = size).composed { modifier },
    onDraw = {
      val width = size.toPx()
      val height = size.toPx()
      drawLine(
        color,
        Offset(x = 0f, y = 0f),
        Offset(x = width, height),
        strokeWidth = strokeWidth.toPx(),
      )
      drawLine(
        color,
        Offset(x = width, 0f),
        Offset(x = 0f, y = height),
        strokeWidth = strokeWidth.toPx(),
      )
    },
  )
}
