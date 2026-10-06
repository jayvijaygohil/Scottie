package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.divider.XelaDividerOrientation
import com.jayvijay.scottie.core.ui.xelauikit.models.divider.XelaDividerStyle
import kotlin.math.roundToInt

@Composable
fun XelaDivider(
  style: XelaDividerStyle = XelaDividerStyle.SOLID,
  orientation: XelaDividerOrientation = XelaDividerOrientation.HORIZONTAL,
  color: Color = XelaColor.Gray11,
) {

  if (orientation == XelaDividerOrientation.HORIZONTAL) {
    when (style) {
      XelaDividerStyle.SOLID -> XelaSolidLine(color = color)
      XelaDividerStyle.DASHED -> XelaDashedLine(color = color)
      XelaDividerStyle.DOTTED -> XelaDottedLine(color = color)
    }
  } else {
    when (style) {
      XelaDividerStyle.SOLID -> XelaSolidLine(color = color, XelaDividerOrientation.VERTICAL)
      XelaDividerStyle.DASHED -> XelaDashedLine(color = color, XelaDividerOrientation.VERTICAL)
      XelaDividerStyle.DOTTED -> XelaDottedLine(color = color, XelaDividerOrientation.VERTICAL)
    }
  }
}

@Composable
fun XelaDashedLine(
  color: Color,
  orientation: XelaDividerOrientation = XelaDividerOrientation.HORIZONTAL,
) {
  if (orientation == XelaDividerOrientation.HORIZONTAL) {
    Canvas(
      Modifier.fillMaxWidth().height(1.dp),
      onDraw = {
        val actualWidth = 4.dp.toPx()
        val stepsCount = (size.width / actualWidth).roundToInt()

        for (i in 1 until stepsCount + 1) {
          drawLine(
            color = if (i % 3 == 0) Color.Transparent else color,
            Offset(x = actualWidth * (i - 1), y = 0f),
            Offset(x = actualWidth * (i), y = 0f),
            strokeWidth = 1.dp.toPx(),
          )
        }
      },
    )
  } else {
    Canvas(
      Modifier.fillMaxHeight().width(1.dp),
      onDraw = {
        val actualWidth = 4.dp.toPx()
        val stepsCount = (size.height / actualWidth).roundToInt()

        for (i in 1 until stepsCount + 1) {
          drawLine(
            color = if (i % 3 == 0) Color.Transparent else color,
            Offset(x = 0f, y = actualWidth * (i - 1)),
            Offset(x = 0f, y = actualWidth * (i)),
            strokeWidth = 1.dp.toPx(),
          )
        }
      },
    )
  }
}

@Composable
fun XelaDottedLine(
  color: Color,
  orientation: XelaDividerOrientation = XelaDividerOrientation.HORIZONTAL,
) {
  if (orientation == XelaDividerOrientation.HORIZONTAL) {
    Canvas(
      Modifier.fillMaxWidth().height(2.dp),
      onDraw = {
        val actualWidth = 2.dp.toPx()
        val stepsCount = (size.width / actualWidth).roundToInt()

        for (i in 0 until stepsCount) {
          drawLine(
            color = if (i % 4 == 0) color else Color.Transparent,
            Offset(x = actualWidth * i, y = 0f),
            Offset(x = actualWidth * (i + 1), y = 0f),
            strokeWidth = actualWidth,
          )
        }
      },
    )
  } else {
    Canvas(
      Modifier.fillMaxHeight().width(2.dp),
      onDraw = {
        val actualWidth = 2.dp.toPx()
        val stepsCount = (size.height / actualWidth).roundToInt()

        for (i in 0 until stepsCount) {
          drawLine(
            color = if (i % 4 == 0) color else Color.Transparent,
            Offset(x = 0f, y = actualWidth * i),
            Offset(x = 0f, y = actualWidth * (i + 1)),
            strokeWidth = actualWidth,
          )
        }
      },
    )
  }
}

@Composable
fun XelaSolidLine(
  color: Color,
  orientation: XelaDividerOrientation = XelaDividerOrientation.HORIZONTAL,
) {
  if (orientation == XelaDividerOrientation.HORIZONTAL) {
    Canvas(
      Modifier.fillMaxWidth().height(1.dp),
      onDraw = {
        val linePath = Path()
        linePath.lineTo(size.width, 0f)
        linePath.close()
        val style = Stroke(1.dp.toPx())
        drawPath(linePath, color, style = style)
      },
    )
  } else {
    Canvas(
      Modifier.fillMaxHeight().width(1.dp),
      onDraw = {
        val linePath = Path()
        linePath.lineTo(0f, size.height)
        linePath.close()
        val style = Stroke(1.dp.toPx())
        drawPath(linePath, color, style = style)
      },
    )
  }
}
