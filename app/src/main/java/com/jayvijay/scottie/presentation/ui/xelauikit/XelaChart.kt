package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.chart.XelaBarChartDataset
import com.jayvijay.scottie.presentation.ui.xelauikit.models.chart.XelaChartType
import com.jayvijay.scottie.presentation.ui.xelauikit.models.chart.XelaDoughnutDataset
import com.jayvijay.scottie.presentation.ui.xelauikit.models.chart.XelaLineChartDataset
import com.jayvijay.scottie.presentation.ui.xelauikit.models.chart.XelaPieChartDataset
import com.jayvijay.scottie.presentation.ui.xelauikit.models.divider.XelaDividerOrientation
import com.jayvijay.scottie.presentation.ui.xelauikit.models.divider.XelaDividerStyle
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption
import kotlin.math.roundToInt

@Composable
fun XelaChart(
  type: XelaChartType,
  labels: List<String> = arrayListOf(),
  datasetsLineChart: List<XelaLineChartDataset>? = null,
  datasetsBarChart: List<XelaBarChartDataset>? = null,
  datasetPieChart: XelaPieChartDataset? = null,
  datasetsDoughnutChart: List<XelaDoughnutDataset>? = null,
  labelsColor: Color = XelaColor.Gray6,
  chartBorderColor: Color = XelaColor.Gray12,
  pieBackgroundColor: Color = XelaColor.Gray11,
  dataStep: Float = 10f,
  doughnutStrokeWidth: Dp = 12.dp,
  labelsFormat: String = "%.0f",
  beforeLabel: String = "",
  afterLabel: String = "",
) {

  if (type == XelaChartType.LINE && datasetsLineChart != null) {
    XelaLineChartBody(
      labels = labels,
      datasets = datasetsLineChart,
      labelsColor = labelsColor,
      chartBorderColor = chartBorderColor,
      dataStep = dataStep,
      labelsFormat = labelsFormat,
      beforeLabel = beforeLabel,
      afterLabel = afterLabel,
    )
  }
  if (type == XelaChartType.BAR && datasetsBarChart != null) {
    XelaBarChartBody(
      labels = labels,
      datasets = datasetsBarChart,
      labelsColor = labelsColor,
      chartBorderColor = chartBorderColor,
      dataStep = dataStep,
      labelsFormat = labelsFormat,
      beforeLabel = beforeLabel,
      afterLabel = afterLabel,
    )
  }
  if (type == XelaChartType.PIE && datasetPieChart != null) {
    XelaPieChartBody(dataset = datasetPieChart, background = pieBackgroundColor)
  }
  if (type == XelaChartType.DOUGHNUT && datasetsDoughnutChart != null) {
    XelaDoughnutChartBody(
      datasets = datasetsDoughnutChart,
      doughnutStrokeWidth = doughnutStrokeWidth,
    )
  }
}

@Composable
fun XelaDoughnutChartBody(
  datasets: List<XelaDoughnutDataset>,
  doughnutStrokeWidth: Dp,
) {

  val size = remember { mutableStateOf(IntSize.Zero) }
  Box(
    modifier =
      Modifier.fillMaxSize()
        .padding(vertical = doughnutStrokeWidth / 2)
        .padding(horizontal = doughnutStrokeWidth)
        .onSizeChanged { size.value = it },
    contentAlignment = Alignment.Center,
  ) {
    Canvas(
      modifier = Modifier.fillMaxSize()
      // .width(with(LocalDensity.current){size.value.width.toDp() - 16.dp})
      // .height(with(LocalDensity.current){size.value.height.toDp() - 16.dp})
      ,
      onDraw = {
        // drawCircle(background, radius = size.value.width.toFloat()/2f)
        for (datasetIndex in datasets.indices) {
          val dataset = datasets[datasetIndex]
          val sum = dataset.data.sum()
          var tempEndDegrees = -90f
          for (index in dataset.data.indices) {
            val data = dataset.data[index]
            val temp = data * 360f / sum
            val startDegrees = tempEndDegrees
            tempEndDegrees += temp
            drawArc(
              dataset.fillColors[index],
              topLeft =
                Offset(
                  x = (doughnutStrokeWidth * 2).toPx() * datasetIndex,
                  y = (doughnutStrokeWidth * 2).toPx() * datasetIndex,
                ),
              startAngle = startDegrees,
              sweepAngle = temp,
              useCenter = false,
              style = Stroke(doughnutStrokeWidth.toPx()),
              size =
                Size(
                  size.value.width.toFloat() -
                    0.dp.toPx() -
                    (doughnutStrokeWidth * 4).toPx() * datasetIndex,
                  size.value.height.toFloat() -
                    0.dp.toPx() -
                    (doughnutStrokeWidth * 4).toPx() * datasetIndex,
                ),
            )
          }
        }
        // drawArc(Color.Red, 0f, 90f, false, style = Stroke(12.dp.toPx()))
        // drawArc(Color.Green, 90f, 90f, false, style = Stroke(12.dp.toPx()))
      },
    )
  }
}

@Composable
fun XelaPieChartBody(
  dataset: XelaPieChartDataset,
  background: Color,
) {
  val size = remember { mutableStateOf(IntSize.Zero) }
  val sum = dataset.data.sum()
  Box(modifier = Modifier.fillMaxSize().onSizeChanged { size.value = it }) {
    Canvas(
      modifier = Modifier.fillMaxSize(),
      onDraw = {
        drawCircle(background, radius = size.value.width.toFloat() / 2f)
        var tempEndDegrees = -90f
        for (index in dataset.data.indices) {
          val data = dataset.data[index]
          val temp = data * 360f / sum
          val startDegrees = tempEndDegrees
          tempEndDegrees += temp
          drawArc(dataset.fillColors[index], startAngle = startDegrees, sweepAngle = temp, true)
        }
      },
    )
  }
}

@Composable
fun XelaBarChartBody(
  labels: List<String>,
  datasets: List<XelaBarChartDataset>,
  labelsColor: Color,
  chartBorderColor: Color,
  dataStep: Float,
  labelsFormat: String,
  beforeLabel: String,
  afterLabel: String,
) {
  val size = remember { mutableStateOf(IntSize.Zero) }

  Box(modifier = Modifier.fillMaxSize().onSizeChanged { size.value = it }) {
    val steps: MutableList<Float> = arrayListOf()
    var minData: Float = 0f
    var maxData: Float = Float.NaN
    for (dataset in datasets) {
      for (dataValue in dataset.data) {
        if (minData.isNaN()) {
          minData = dataValue
        } else {
          if (minData > dataValue) {
            minData = dataValue
          }
        }

        if (maxData.isNaN()) {
          maxData = dataValue
        } else {
          if (maxData < dataValue) {
            maxData = dataValue
          }
        }
      }
    }

    var fromStep = maxData + (dataStep - (maxData % dataStep))
    val toStep = minData - (dataStep - (minData % dataStep))
    val stepsCountFloat = (fromStep - toStep) / dataStep
    var stepsCount = stepsCountFloat.roundToInt()

    repeat(stepsCount) {
      steps.add(fromStep)
      fromStep -= dataStep
    }

    val labelHeight = size.value.height / steps.size - steps.size * 0.25f

    Column(modifier = Modifier) {
      for (step in steps) {
        Row(
          modifier =
            Modifier.height(with(LocalDensity.current) { labelHeight.toDp() }).fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
            // step.toString(),
            beforeLabel + labelsFormat.format(step) + afterLabel,
            style = xelaCaption,
            color = labelsColor,
            modifier = Modifier.width(32.dp),
          )
          Box(modifier = Modifier.weight(1f)) {
            XelaDivider(
              style = XelaDividerStyle.SOLID,
              orientation = XelaDividerOrientation.HORIZONTAL,
              color = chartBorderColor,
            )
          }
        }
      }
    }

    val labelWidth = (size.value.width - with(LocalDensity.current) { 24.dp.toPx() }) / labels.size

    Row(modifier = Modifier.padding(start = 24.dp)) {
      for (index in labels.indices) {
        val label = labels[index]
        Column(
          modifier = Modifier.fillMaxHeight(),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Row(
            modifier =
              Modifier.width(with(LocalDensity.current) { labelWidth.toDp() })
                .padding(horizontal = 4.dp)
                .padding(bottom = 8.dp)
          ) {
            for (dataset in datasets) {
              Box(
                modifier =
                  Modifier.weight(1f)
                    .width(
                      with(LocalDensity.current) {
                        ((labelWidth - 4.dp.toPx()) / datasets.size).toDp()
                      }
                    )
                    .padding(horizontal = 2.dp)
                    .clip(
                      RoundedCornerShape(
                        if (datasets.size > 2) 4.dp else (14 - (datasets.size * 4)).dp
                      )
                    )
                    .background(chartBorderColor)
                    .height(
                      with(LocalDensity.current) { (size.value.height - 24.dp.toPx()).toDp() }
                    ),
                contentAlignment = Alignment.BottomCenter,
              ) {
                Box(
                  modifier =
                    Modifier.clip(
                        RoundedCornerShape(
                          if (datasets.size > 2) 4.dp else (14 - (datasets.size * 4)).dp
                        )
                      )
                      .background(dataset.fillColor)
                      .fillMaxWidth()
                      .height(
                        with(LocalDensity.current) {
                          (dataset.data[index] * (labelHeight / dataStep)).toDp() + 4.dp
                        }
                      )
                )
              }
            }
          }

          Text(
            label,
            style = xelaCaption,
            color = labelsColor,
            textAlign = TextAlign.Center,
            modifier =
              Modifier.width(with(LocalDensity.current) { labelWidth.toDp() }).height(16.dp),
          )
        }
      }
    }
  }
}

@Composable
fun XelaLineChartBody(
  labels: List<String>,
  datasets: List<XelaLineChartDataset>,
  labelsColor: Color,
  chartBorderColor: Color,
  dataStep: Float,
  labelsFormat: String,
  beforeLabel: String,
  afterLabel: String,
) {

  val size = remember { mutableStateOf(IntSize.Zero) }
  Box(modifier = Modifier.fillMaxSize().onSizeChanged { size.value = it }) {
    val steps: MutableList<Float> = arrayListOf()
    var minData: Float = Float.NaN
    var maxData: Float = Float.NaN
    for (dataset in datasets) {
      for (dataValue in dataset.data) {
        if (minData.isNaN()) {
          minData = dataValue
        } else {
          if (minData > dataValue) {
            minData = dataValue
          }
        }

        if (maxData.isNaN()) {
          maxData = dataValue
        } else {
          if (maxData < dataValue) {
            maxData = dataValue
          }
        }
      }
    }

    var fromStep = maxData + (dataStep - (maxData % dataStep))
    val toStep = minData - (dataStep - (minData % dataStep))
    val stepsCountFloat = (fromStep - toStep) / dataStep
    var stepsCount = stepsCountFloat.toInt()
    if ((stepsCountFloat - stepsCount.toFloat()) > 0) {
      stepsCount += 1
    }

    repeat(stepsCount) {
      steps.add(fromStep)
      fromStep -= dataStep
    }

    val labelHeight = size.value.height / steps.size

    Column(modifier = Modifier) {
      for (step in steps) {
        Row(
          modifier =
            Modifier.height(with(LocalDensity.current) { labelHeight.toDp() }).fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
            // step.toString(),
            beforeLabel + labelsFormat.format(step) + afterLabel,
            style = xelaCaption,
            color = labelsColor,
            modifier = Modifier.width(32.dp),
          )
          Box(modifier = Modifier.weight(1f)) {
            XelaDivider(
              style = XelaDividerStyle.SOLID,
              orientation = XelaDividerOrientation.HORIZONTAL,
              color = chartBorderColor,
            )
          }
        }
      }
    }

    val labelWidth = size.value.width / labels.size

    Row(modifier = Modifier) {
      for (label in labels) {
        Column(
          modifier = Modifier.fillMaxHeight(),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Box(modifier = Modifier.weight(1f)) {
            XelaDivider(
              style = XelaDividerStyle.SOLID,
              orientation = XelaDividerOrientation.VERTICAL,
              color = chartBorderColor,
            )
          }

          Text(
            label,
            style = xelaCaption,
            color = labelsColor,
            textAlign = TextAlign.Center,
            modifier =
              Modifier.width(with(LocalDensity.current) { labelWidth.toDp() }).height(16.dp),
          )
        }
      }
    }

    Canvas(
      modifier = Modifier.fillMaxSize(),
      onDraw = {
        val offsetY = labelHeight / dataStep
        for (dataset in datasets) {
          val path = Path()
          val pathLine = Path()
          var prevPoint: Offset = Offset(0f, 0f)
          for (index in dataset.data.indices) {
            val data = dataset.data[index]
            val offset =
              Offset(
                x = index.toFloat() * labelWidth + labelWidth / 2,
                y = size.value.height.toFloat() - (data * offsetY) - labelHeight / 2,
              )

            if (index == 0) {
              path.moveTo(offset.x, size.value.height.toFloat() - labelHeight / 2)
              path.lineTo(offset.x, offset.y)
              pathLine.moveTo(offset.x, offset.y)
              prevPoint = offset
            } else {

              val deltaX = offset.x - prevPoint.x
              val curveXOffset = deltaX * dataset.tension

              pathLine.cubicTo(
                prevPoint.x + curveXOffset,
                prevPoint.y,
                offset.x - curveXOffset,
                offset.y,
                offset.x,
                offset.y,
              )
              path.cubicTo(
                prevPoint.x + curveXOffset,
                prevPoint.y,
                offset.x - curveXOffset,
                offset.y,
                offset.x,
                offset.y,
              )
              prevPoint = offset
            }

            if (index == dataset.data.lastIndex) {
              path.lineTo(offset.x, size.value.height.toFloat() - labelHeight / 2)
            }
          }

          drawPath(path = path, dataset.fillColor, alpha = 0.24f)
          drawPath(path = pathLine, dataset.lineColor, style = Stroke(2.dp.toPx()))

          if (dataset.pointColor != Color.Transparent) {
            for (index in dataset.data.indices) {
              val data = dataset.data[index]
              val offset =
                Offset(
                  x = index.toFloat() * labelWidth + labelWidth / 2,
                  y = size.value.height.toFloat() - (data * offsetY) - labelHeight / 2,
                )

              drawCircle(dataset.pointColorBackground, 4.dp.toPx(), center = offset)
              drawCircle(
                dataset.pointColor,
                4.dp.toPx(),
                center = offset,
                style = Stroke(2.dp.toPx()),
              )
            }
          }
        }
      },
    )
  }
}
