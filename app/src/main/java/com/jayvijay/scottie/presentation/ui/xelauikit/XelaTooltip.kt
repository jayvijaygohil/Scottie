package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.tooltip.XelaTooltipAlign
import com.jayvijay.scottie.presentation.ui.xelauikit.models.tooltip.XelaTooltipArrowAlign
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption

@Composable
fun XelaTooltip(
  text: String,
  tooltipAlign: XelaTooltipAlign = XelaTooltipAlign.TOP,
  arrowAlign: XelaTooltipArrowAlign = XelaTooltipArrowAlign.START,
  textColor: Color = Color.White,
  backgroundColor: Color = XelaColor.Gray3,
) {

  if (tooltipAlign == XelaTooltipAlign.RIGHT) {
    Row(
      verticalAlignment =
        if (arrowAlign == XelaTooltipArrowAlign.START) Alignment.Top
        else {
          if (arrowAlign == XelaTooltipArrowAlign.CENTER) Alignment.CenterVertically
          else Alignment.Bottom
        }
    ) {
      Box(
        modifier =
          Modifier.offset(
            y =
              if (arrowAlign == XelaTooltipArrowAlign.START) 8.dp
              else {
                if (arrowAlign == XelaTooltipArrowAlign.CENTER) 0.dp else (-8).dp
              }
          )
      ) {
        XelaTooltipTriangle(
          modifier = Modifier.width(8.dp).height(14.dp),
          color = backgroundColor,
          tooltipAlign = tooltipAlign,
        )
      }

      Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(backgroundColor)) {
        Text(
          text,
          style = xelaCaption,
          color = textColor,
          modifier = Modifier.padding(horizontal = 16.dp).padding(vertical = 8.dp),
          textAlign = TextAlign.Center,
        )
      }
    }
  }

  if (tooltipAlign == XelaTooltipAlign.LEFT) {
    Row(
      verticalAlignment =
        if (arrowAlign == XelaTooltipArrowAlign.START) Alignment.Top
        else {
          if (arrowAlign == XelaTooltipArrowAlign.CENTER) Alignment.CenterVertically
          else Alignment.Bottom
        }
    ) {
      Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(backgroundColor)) {
        Text(
          text,
          style = xelaCaption,
          color = textColor,
          modifier = Modifier.padding(horizontal = 16.dp).padding(vertical = 8.dp),
          textAlign = TextAlign.Center,
        )
      }

      Box(
        modifier =
          Modifier.offset(
            y =
              if (arrowAlign == XelaTooltipArrowAlign.START) 8.dp
              else {
                if (arrowAlign == XelaTooltipArrowAlign.CENTER) 0.dp else (-8).dp
              }
          )
      ) {
        XelaTooltipTriangle(
          modifier = Modifier.width(8.dp).height(14.dp),
          color = backgroundColor,
          tooltipAlign = tooltipAlign,
        )
      }
    }
  }

  if (tooltipAlign == XelaTooltipAlign.BOTTOM) {
    Column(
      horizontalAlignment =
        if (arrowAlign == XelaTooltipArrowAlign.START) Alignment.Start
        else {
          if (arrowAlign == XelaTooltipArrowAlign.CENTER) Alignment.CenterHorizontally
          else Alignment.End
        }
    ) {
      Box(
        modifier =
          Modifier.offset(
            x =
              if (arrowAlign == XelaTooltipArrowAlign.START) 8.dp
              else {
                if (arrowAlign == XelaTooltipArrowAlign.CENTER) 0.dp else (-8).dp
              }
          )
      ) {
        XelaTooltipTriangle(
          modifier = Modifier.width(14.dp).height(8.dp),
          color = backgroundColor,
          tooltipAlign = tooltipAlign,
        )
      }

      Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(backgroundColor)) {
        Text(
          text,
          style = xelaCaption,
          color = textColor,
          modifier = Modifier.padding(horizontal = 16.dp).padding(vertical = 8.dp),
          textAlign = TextAlign.Center,
        )
      }
    }
  }

  if (tooltipAlign == XelaTooltipAlign.TOP) {
    Column(
      horizontalAlignment =
        if (arrowAlign == XelaTooltipArrowAlign.START) Alignment.Start
        else {
          if (arrowAlign == XelaTooltipArrowAlign.CENTER) Alignment.CenterHorizontally
          else Alignment.End
        }
    ) {
      Box(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(backgroundColor)) {
        Text(
          text,
          style = xelaCaption,
          color = textColor,
          modifier = Modifier.padding(horizontal = 16.dp).padding(vertical = 8.dp),
          textAlign = TextAlign.Center,
        )
      }

      Box(
        modifier =
          Modifier.offset(
            x =
              if (arrowAlign == XelaTooltipArrowAlign.START) 8.dp
              else {
                if (arrowAlign == XelaTooltipArrowAlign.CENTER) 0.dp else (-8).dp
              }
          )
      ) {
        XelaTooltipTriangle(
          modifier = Modifier.width(14.dp).height(8.dp),
          color = backgroundColor,
          tooltipAlign = tooltipAlign,
        )
      }
    }
  }
}

@Composable
fun XelaTooltipTriangle(
  modifier: Modifier = Modifier,
  color: Color,
  tooltipAlign: XelaTooltipAlign,
) {
  Canvas(
    modifier = Modifier.composed { modifier },
    onDraw = {
      val width = 14.dp.toPx()
      val height = 8.dp.toPx()
      var trianglePath =
        Path().apply {
          moveTo(0f, width / 2)
          // Add line to bottom right corner
          lineTo(height, width)
          // Add line to bottom left corner
          lineTo(height, 0f)
        }

      if (tooltipAlign == XelaTooltipAlign.RIGHT) {
        trianglePath =
          Path().apply {
            moveTo(0f, width / 2)
            // Add line to bottom right corner
            lineTo(height, width)
            // Add line to bottom left corner
            lineTo(height, 0f)
          }
      }

      if (tooltipAlign == XelaTooltipAlign.LEFT) {
        trianglePath =
          Path().apply {
            moveTo(height, width / 2)
            // Add line to bottom right corner
            lineTo(0f, width)
            // Add line to bottom left corner
            lineTo(0f, 0f)
          }
      }

      if (tooltipAlign == XelaTooltipAlign.BOTTOM) {
        trianglePath =
          Path().apply {
            moveTo(width / 2, 0f)
            // Add line to bottom right corner
            lineTo(width, height)
            // Add line to bottom left corner
            lineTo(0f, height)
          }
      }

      if (tooltipAlign == XelaTooltipAlign.TOP) {
        trianglePath =
          Path().apply {
            moveTo(width / 2, height)
            // Add line to bottom right corner
            lineTo(width, 0f)
            // Add line to bottom left corner
            lineTo(0f, 0f)
          }
      }

      drawPath(
        color = color,
        path = trianglePath,
      )
    },
  )
}
