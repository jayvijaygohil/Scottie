package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.checkbox.XelaCheckboxSize
import com.jayvijay.scottie.presentation.ui.xelauikit.models.checkbox.XelaCheckboxState
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonSmall
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption

private const val DISABLED_ALPHA = 0.4f

@Composable
fun XelaCheckbox(
  checkboxIcon: Int,
  label: String = "",
  caption: String = "",
  value: String = "",
  onCheckedChange: (item: Boolean) -> Unit = {},
  selectedColor: Color = XelaColor.Blue3,
  iconColor: Color = Color.White,
  defaultColor: Color = XelaColor.Gray11,
  valueColor: Color = XelaColor.Red3,
  size: XelaCheckboxSize = XelaCheckboxSize.LARGE,
  state: XelaCheckboxState = XelaCheckboxState.DEFAULT,
  disabled: Boolean = false,
  labelColor: Color = XelaColor.Gray2,
  captionColor: Color = XelaColor.Gray8,
  border: Boolean = true,
) {
  val isChecked = remember {
    mutableStateOf(state == XelaCheckboxState.SELECTED)
  }

  Row(
    modifier =
      Modifier.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
      ) {
        if (!disabled) {
          isChecked.value = !isChecked.value
          onCheckedChange(isChecked.value)
        }
      }
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier =
        Modifier.composed {
            if (label.isNotEmpty() || caption.isNotEmpty() || value.isNotEmpty()) {
              Modifier.fillMaxWidth()
            } else {
              Modifier
            }
          }
          .alpha(if (disabled) DISABLED_ALPHA else 1f),
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
          Modifier.composed {
            if (label.isNotEmpty() || caption.isNotEmpty() || value.isNotEmpty()) {
              Modifier.padding(top = 8.dp).padding(bottom = 8.dp)
            } else {
              Modifier
            }
          },
      ) {
        Box(
          modifier =
            Modifier.wrapContentSize(Alignment.Center).composed {
              if (label.isNotEmpty() || caption.isNotEmpty() || value.isNotEmpty()) {
                Modifier.padding(end = 16.dp)
              } else {
                Modifier
              }
            }
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
              Modifier.size(
                  if (size == XelaCheckboxSize.LARGE) 32.dp
                  else {
                    if (size == XelaCheckboxSize.MEDIUM) 24.dp else 20.dp
                  }
                )
                .clip(
                  RoundedCornerShape(
                    if (size == XelaCheckboxSize.LARGE) 12.dp
                    else {
                      if (size == XelaCheckboxSize.MEDIUM) 9.dp else 8.dp
                    }
                  )
                )
                .background(if (isChecked.value) selectedColor else Color.Transparent)
                .composed {
                  if (border) {
                    Modifier.border(
                      2.dp,
                      if (isChecked.value) selectedColor else defaultColor,
                      RoundedCornerShape(
                        if (size == XelaCheckboxSize.LARGE) 12.dp
                        else {
                          if (size == XelaCheckboxSize.MEDIUM) 9.dp else 8.dp
                        }
                      ),
                    )
                  } else {
                    Modifier
                  }
                },
          ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
              painter = painterResource(id = checkboxIcon),
              contentDescription = "Checkbox Icon",
              colorFilter = ColorFilter.tint(iconColor),
              modifier =
                Modifier.size(if (size == XelaCheckboxSize.SMALL) 12.dp else 15.dp)
                  .alpha(if (isChecked.value) 1f else 0f),
            )
            Spacer(modifier = Modifier.weight(1f))
          }
        }

        if (label.isNotEmpty() || caption.isNotEmpty() || value.isNotEmpty()) {
          Column {
            if (label.isNotEmpty()) {
              Text(label, style = xelaButtonMedium, color = labelColor)
            }
            if (caption.isNotEmpty()) {
              Text(caption, style = xelaCaption, color = captionColor)
            }
          }
          Spacer(modifier = Modifier.weight(1f))
          if (value.isNotEmpty()) {
            Text(value, style = xelaButtonSmall, color = valueColor)
          }
        }
      }
    }
  }
}
