package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.divider.XelaDividerStyle
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaHeadline
import java.text.DateFormatSymbols
import java.time.LocalDate
import java.time.format.TextStyle

private const val DAYS_PER_WEEK = 7
private const val HEIGHT_RATIO = 0.75f

private fun isDateSelected(
  dayDate: LocalDate,
  selectedDate: LocalDate?,
  selectedDates: List<LocalDate>,
  startDate: LocalDate?,
  endDate: LocalDate?,
): Boolean {
  val isSingleSelected = dayDate == selectedDate || selectedDates.contains(dayDate)
  val isRangeEndpoint = dayDate == startDate || dayDate == endDate
  return isSingleSelected || isRangeEndpoint
}

private fun isBetweenStartAndEnd(
  dayDate: LocalDate,
  startDate: LocalDate?,
  endDate: LocalDate?,
): Boolean = if (startDate != null && endDate != null) {
  dayDate.isAfter(startDate) && dayDate.isBefore(endDate)
} else {
  false
}

@Composable
fun XelaDatePicker(
  minDate: LocalDate = LocalDate.now(),
  maxDate: LocalDate = LocalDate.now().plusYears(1),
  disabledDates: List<LocalDate> = arrayListOf(),
  selectedDates: MutableList<LocalDate> = remember { mutableStateListOf<LocalDate>() },
  selectedDate: MutableState<LocalDate?> = remember { mutableStateOf(null) },
  startDate: MutableState<LocalDate?> = remember { mutableStateOf(null) },
  endDate: MutableState<LocalDate?> = remember { mutableStateOf(null) },
  mode: Int = 0,
  monthOffset: Int = 0,
  textColor: Color = XelaColor.Gray3,
  todayColor: Color = XelaColor.Blue3,
  selectedColor: Color = Color.White,
  disabledColor: Color = XelaColor.Gray9,
  betweenStartAndEndColor: Color = XelaColor.Gray3,
  textBackground: Color = Color.Transparent,
  todayBackground: Color = Color.White,
  selectedBackground: Color = XelaColor.Blue3,
  disabledBackground: Color = Color.Transparent,
  betweenStartAndEndBackground: Color = XelaColor.Blue8,
  weekdayHeaderColor: Color = XelaColor.Gray7,
  monthHeaderColor: Color = XelaColor.Gray2,
  yearHeaderColor: Color = XelaColor.Gray9,
  changeMonthForeground: Color = XelaColor.Gray3,
  changeMonthBackground: Color = Color.White,
  changeMonthBorderColor: Color = XelaColor.Gray11,
  dividerColor: Color = XelaColor.Gray9,
  prevMonthIcon: Int? = null,
  nextMonthIcon: Int? = null,
  onTapDateAction: ((LocalDate) -> Unit)? = null,
) {
  val daysPerWeek = DAYS_PER_WEEK

  val weekdays: MutableList<String> = arrayListOf()

  for (weekday in DateFormatSymbols().shortWeekdays) {
    if (weekday.isNotEmpty()) {
      weekdays.add(weekday)
    }
  }
  val sunday = weekdays[0]
  weekdays.removeAt(0)
  weekdays.add(weekdays.size, sunday)

  val currentYearMonth = remember { mutableStateOf(minDate.plusMonths(monthOffset.toLong())) }

  Box(modifier = Modifier) {
    Column(
      modifier =
        Modifier
          // .padding(32.dp)
          .fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        Text(
          currentYearMonth.value.year.toString(),
          style = xelaHeadline,
          color = yearHeaderColor,
        )
        Text(
          currentYearMonth.value.month
            .getDisplayName(TextStyle.SHORT, LocalLocale.current.platformLocale)
            .replaceFirstChar {
              if (it.isLowerCase()) it.titlecase(LocalLocale.current.platformLocale)
              else it.toString()
            },
          style = xelaHeadline,
          color = monthHeaderColor,
          modifier = Modifier.weight(1f),
        )
        if (prevMonthIcon != null) {
          Box(
            modifier =
              Modifier.clip(RoundedCornerShape(12.dp))
                .size(32.dp)
                .background(changeMonthBackground)
                .border(1.dp, changeMonthBorderColor, RoundedCornerShape(12.dp))
                .clickable {
                  currentYearMonth.value = currentYearMonth.value.minusMonths(1)
                },
            contentAlignment = Alignment.Center,
          ) {
            Image(
              painter = painterResource(id = prevMonthIcon),
              contentDescription = "DatePicker prev month button icon",
              colorFilter = ColorFilter.tint(changeMonthForeground),
              modifier = Modifier.size(16.dp),
              // .padding(8.dp)
            )
          }
        }

        if (nextMonthIcon != null) {
          Box(
            modifier =
              Modifier.clip(RoundedCornerShape(12.dp))
                .size(32.dp)
                .background(changeMonthBackground)
                .border(1.dp, changeMonthBorderColor, RoundedCornerShape(12.dp))
                .clickable {
                  currentYearMonth.value = currentYearMonth.value.plusMonths(1)
                },
            contentAlignment = Alignment.Center,
          ) {
            Image(
              painter = painterResource(id = nextMonthIcon),
              contentDescription = "DatePicker next month button icon",
              colorFilter = ColorFilter.tint(changeMonthForeground),
              modifier = Modifier.size(16.dp),
              // .padding(8.dp)
            )
          }
        }
      }

      XelaDivider(style = XelaDividerStyle.DOTTED, color = dividerColor)

      Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).padding(top = 8.dp)) {
        for (weekday in weekdays) {
          if (weekday.isNotEmpty()) {
            Text(
              weekday.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(LocalLocale.current.platformLocale)
                else it.toString()
              },
              style = xelaCaption,
              textAlign = TextAlign.Center,
              color = weekdayHeaderColor,
              modifier = Modifier.weight(1f),
            )
          }
        }
      }

      val lastMonthDay = currentYearMonth.value.month.length(currentYearMonth.value.isLeapYear)
      val firstDayOfWeek =
        LocalDate.of(currentYearMonth.value.year, currentYearMonth.value.monthValue, 1).dayOfWeek
      val rows =
        ((lastMonthDay + (firstDayOfWeek.value)) / (daysPerWeek)) +
          (if ((lastMonthDay + firstDayOfWeek.value) % (daysPerWeek) > 0) 1 else 0)
      val days: MutableList<LocalDate> = arrayListOf()

      val prevMonth = currentYearMonth.value.minusMonths(1)
      val nextMonth = currentYearMonth.value.plusMonths(1)
      var day: Int
      var i: Int
      for (r in 0 until rows) {
        for (cell in 1..daysPerWeek) {
          i = ((r) * (daysPerWeek)) + (cell) + 1
          if (firstDayOfWeek.value >= i) {
            day = prevMonth.month.length(prevMonth.isLeapYear) - (firstDayOfWeek.value - i)
            days.add(LocalDate.of(prevMonth.year, prevMonth.monthValue, day))
          } else {
            day = i - firstDayOfWeek.value

            if (lastMonthDay < day) {
              day -= lastMonthDay
              days.add(LocalDate.of(nextMonth.year, nextMonth.monthValue, day))
            } else {
              days.add(
                LocalDate.of(currentYearMonth.value.year, currentYearMonth.value.monthValue, day)
              )
            }
          }
        }
      }

      val dateCellWidth = remember { mutableStateOf(0) }

      Column(modifier = Modifier.padding(top = 4.dp)) {
        for (r in 0 until rows) {
          Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
            for (cell in 0 until daysPerWeek) {
              val index = (r * (daysPerWeek)) + (cell)
              val dayDate = days[index]
              val isEnabledDate =
                (dayDate.month == currentYearMonth.value.month &&
                  !disabledDates.contains(dayDate) &&
                  dayDate.isAfter(minDate.minusDays(1)) &&
                  dayDate.isBefore(maxDate))
              Box(
                modifier =
                  Modifier.composed {
                      if (isEnabledDate && dayDate == LocalDate.now()) {
                        Modifier.border(
                          2.dp,
                          todayColor,
                          RoundedCornerShape(8.dp),
                        )
                      } else {
                        Modifier
                      }
                    }
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .onSizeChanged {
                      if (dateCellWidth.value == 0) dateCellWidth.value = it.width
                    }
                    .background(
                      if (isEnabledDate) {
                        if (
                          isDateSelected(
                            dayDate,
                            selectedDate.value,
                            selectedDates,
                            startDate.value,
                            endDate.value,
                          )
                        ) {
                          selectedBackground
                        } else if (
                          isBetweenStartAndEnd(
                            dayDate,
                            startDate.value,
                            endDate.value,
                          )
                        ) {
                          Color.Transparent
                        } else if (dayDate == LocalDate.now()) {
                          todayBackground
                        } else {
                          textBackground
                        }
                      } else {
                        disabledBackground
                      }
                    )
                    .height(with(LocalDensity.current) { dateCellWidth.value.toDp() })
                    .clickable(isEnabledDate) {
                      if (mode == 0) {
                        if (selectedDate.value == dayDate) {
                          selectedDate.value = null
                        } else {
                          selectedDate.value = dayDate
                        }
                      } else if (mode == 1) {
                        if (startDate.value == null) {
                          startDate.value = dayDate
                        } else if (startDate.value == dayDate) {
                          startDate.value = null
                          if (endDate.value != null) {
                            startDate.value = endDate.value
                            endDate.value = null
                          }
                        } else if (endDate.value == null && dayDate.isAfter(startDate.value)) {
                          endDate.value = dayDate
                        } else if (endDate.value == dayDate) {
                          endDate.value = null
                        } else {
                          startDate.value = null
                          endDate.value = null
                        }
                      } else if (mode == 2) {
                        if (selectedDates.contains(dayDate)) {
                          selectedDates.remove(dayDate)
                        } else {
                          selectedDates.add(dayDate)
                        }
                      }

                      if (onTapDateAction != null) {
                        onTapDateAction(dayDate)
                      }
                    },
                contentAlignment = Alignment.Center,
              ) {
                Box(
                  modifier =
                    Modifier.width(
                        with(LocalDensity.current) {
                          dateCellWidth.value.toDp()
                        }
                      )
                      .height(
                        with(LocalDensity.current) {
                          (dateCellWidth.value.toFloat() * HEIGHT_RATIO).toDp()
                        }
                      )
                      .background(
                        if (
                          isEnabledDate &&
                            isBetweenStartAndEnd(
                              dayDate,
                              startDate.value,
                              endDate.value,
                            )
                        ) {
                          betweenStartAndEndBackground
                        } else {
                          Color.Transparent
                        }
                      )
                )
                Text(
                  dayDate.dayOfMonth.toString(),
                  style = xelaButtonMedium,
                  textAlign = TextAlign.Center,
                  color =
                    if (isEnabledDate) {
                      if (
                        isDateSelected(
                          dayDate,
                          selectedDate.value,
                          selectedDates,
                          startDate.value,
                          endDate.value,
                        )
                      ) {
                        selectedColor
                      } else if (
                        isBetweenStartAndEnd(
                          dayDate,
                          startDate.value,
                          endDate.value,
                        )
                      ) {
                        betweenStartAndEndColor
                      } else if (dayDate == LocalDate.now()) {
                        todayColor
                      } else {
                        textColor
                      }
                    } else {
                      disabledColor
                    },
                )
              }
            }
          }
        }
      }
    }
  }
}
