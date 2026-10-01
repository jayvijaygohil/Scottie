package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.radiobutton.XelaRadioButtonItem
import com.jayvijay.scottie.presentation.ui.xelauikit.models.radiobutton.XelaRadioButtonSize
import com.jayvijay.scottie.presentation.ui.xelauikit.models.radiobutton.XelaRadioButtonState
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonLarge
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption

@Composable
fun XelaRadioButtonGroup(
  items: List<XelaRadioButtonItem>,
  onSelectedChange: (item: XelaRadioButtonItem) -> Unit,
  itemBorder: Boolean = false,
  size: XelaRadioButtonSize,
  selectedColor: Color = XelaColor.Blue3,
  defaultColor: Color = XelaColor.Gray11,
  labelColor: Color = XelaColor.Gray2,
  captionColor: Color = XelaColor.Gray8,
  valueColor: Color = XelaColor.Gray2,
  selectedItemID: String = "",
) {
  val selectedId = remember {
    mutableStateOf(selectedItemID)
  }

  Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
    for (item in items) {

      Row(
        modifier =
          Modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
          ) {
            if (item.state != XelaRadioButtonState.DISABLED) {
              selectedId.value = item.id
              onSelectedChange(item)
            }
          }
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.border(
                1.dp,
                if (itemBorder) {
                  if (item.id == selectedId.value) selectedColor else defaultColor
                } else Color.Transparent,
                RoundedCornerShape(18.dp),
              )
              .fillMaxWidth()
              .padding(if (itemBorder) 16.dp else 0.dp)
              .alpha(if (item.state == XelaRadioButtonState.DISABLED) 0.4f else 1f),
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically
            //                            modifier = Modifier
            //                                .padding(top = if (items.first().id == item.id) 0.dp
            // else 8.dp)
            //                                .padding(bottom = if (items.last().id == item.id) 0.dp
            // else 8.dp)
          ) {
            Box(modifier = Modifier.wrapContentSize(Alignment.Center).padding(end = 16.dp)) {
              Box(
                modifier =
                  Modifier.size(
                      if (size == XelaRadioButtonSize.LARGE) 32.dp
                      else {
                        if (size == XelaRadioButtonSize.MEDIUM) 24.dp else 20.dp
                      }
                    )
                    .background(Color.Transparent)
                    .border(
                      if (item.id == selectedId.value) {
                        if (size == XelaRadioButtonSize.LARGE) 8.dp
                        else {
                          if (size == XelaRadioButtonSize.MEDIUM) 6.dp else 5.dp
                        }
                      } else 2.dp,
                      if (item.id == selectedId.value) selectedColor else defaultColor,
                      CircleShape,
                    )
              )
            }

            Column {
              if (item.label.isNotEmpty()) {
                Text(item.label, style = xelaButtonMedium, color = labelColor)
              }
              if (item.caption.isNotEmpty()) {
                Text(item.caption, style = xelaCaption, color = captionColor)
              }
            }
            Spacer(modifier = Modifier.weight(1f))
            if (item.value.isNotEmpty()) {
              Text(item.value, style = xelaButtonLarge, color = valueColor)
            }
          }
        }
      }
    }
  }
}
