package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.numberinput.XelaNumberInputControls
import com.jayvijay.scottie.presentation.ui.xelauikit.models.numberinput.XelaNumberInputState
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSmallBody

private const val PRESSED_ALPHA = 0.5f

@Composable
fun XelaNumberInput(
  value: MutableState<Int>,
  state: MutableState<XelaNumberInputState>,
  decreaseIcon: Int,
  increaseIcon: Int,
  helperText: String? = null,
  label: String? = null,
  controls: XelaNumberInputControls = XelaNumberInputControls.LEFTRIGHT,
  labelColor: Color = XelaColor.Gray8,
  valueColor: Color = XelaColor.Gray2,
  helperTextColor: Color = XelaColor.Gray8,
  controlsColor: Color = XelaColor.Gray2,
  defaultBackground: Color = Color.White,
  disabledBackground: Color = XelaColor.Gray12,
  defaultBorderColor: Color = XelaColor.Gray11,
  focusBorderColor: Color = XelaColor.Blue5,
  errorBorderColor: Color = XelaColor.Red3,
  successBorderColor: Color = XelaColor.Green1,
  disabledBorderColor: Color = XelaColor.Gray8,
) {
  Column {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier =
        Modifier.border(
          width = if (state.value == XelaNumberInputState.FOCUS) 2.dp else 1.dp,
          color =
            if (state.value == XelaNumberInputState.DEFAULT) defaultBorderColor
            else {
              if (state.value == XelaNumberInputState.FOCUS) {
                focusBorderColor
              } else {
                if (state.value == XelaNumberInputState.ERROR) {
                  errorBorderColor
                } else {
                  if (state.value == XelaNumberInputState.SUCCESS) {
                    successBorderColor
                  } else {
                    disabledBorderColor
                  }
                }
              }
            },
          shape = RoundedCornerShape(18.dp),
        ),
    ) {
      Card(
        shape = RoundedCornerShape(18.dp),
        colors =
          CardDefaults.cardColors(
            containerColor =
              if (state.value == XelaNumberInputState.DISABLED) disabledBackground
              else defaultBackground
          ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.height(56.dp).width(160.dp),
          // .padding(horizontal = 16.dp)
          // .padding(top = 8.dp)
          // .padding(bottom = 8.dp)

        ) {
          if (controls == XelaNumberInputControls.LEFTRIGHT) {
            decreaseNumberInputBtn(
              decreaseIcon = decreaseIcon,
              value = value,
              controlsColor = controlsColor,
              controls = controls,
            )
          }

          if (controls == XelaNumberInputControls.LEFT) {
            Column {
              increaseNumberInputBtn(
                increaseIcon = increaseIcon,
                value = value,
                controlsColor = controlsColor,
                controls = controls,
              )
              Spacer(modifier = Modifier.weight(1.0f))
              decreaseNumberInputBtn(
                decreaseIcon = decreaseIcon,
                value = value,
                controlsColor = controlsColor,
                controls = controls,
              )
            }
          }

          Column(
            horizontalAlignment =
              if (controls == XelaNumberInputControls.LEFTRIGHT) Alignment.CenterHorizontally
              else {
                if (controls == XelaNumberInputControls.LEFT) Alignment.End else Alignment.Start
              },
            modifier =
              Modifier.padding(
                  horizontal = if (controls == XelaNumberInputControls.LEFTRIGHT) 0.dp else 16.dp
                )
                .weight(1f),
          ) {
            if (label != null) {
              Text(label, style = xelaSmallBody, color = labelColor)
            }
            Text(
              value.value.toString(),
              style = xelaButtonMedium,
              color = valueColor,
              modifier = Modifier,
              // .fillMaxWidth()
            )
          }
          if (controls == XelaNumberInputControls.LEFTRIGHT) {
            increaseNumberInputBtn(
              increaseIcon = increaseIcon,
              value = value,
              controlsColor = controlsColor,
              controls = controls,
            )
          }

          if (controls == XelaNumberInputControls.RIGHT) {
            Column {
              increaseNumberInputBtn(
                increaseIcon = increaseIcon,
                value = value,
                controlsColor = controlsColor,
                controls = controls,
              )
              Spacer(modifier = Modifier.weight(1.0f))
              decreaseNumberInputBtn(
                decreaseIcon = decreaseIcon,
                value = value,
                controlsColor = controlsColor,
                controls = controls,
              )
            }
          }
        }
      }
    }

    if (helperText != null) {
      Text(
        helperText,
        style = xelaCaption,
        color = helperTextColor,
        modifier = Modifier.padding(top = 8.dp),
      )
    }
  }
}

@Composable
fun decreaseNumberInputBtn(
  decreaseIcon: Int,
  value: MutableState<Int>,
  controlsColor: Color,
  controls: XelaNumberInputControls,
) {
  var isPressed by remember { mutableStateOf(false) }
  Box(
    modifier =
      Modifier.pointerInput(Unit) {
        detectTapGestures(
          onPress = {
            isPressed = true
            value.value -= 1
            val success = tryAwaitRelease()
            isPressed = !success
          }
        )
      }
  ) {
    Image(
      painter = painterResource(id = decreaseIcon),
      contentDescription = "xela number input decrease icon",
      colorFilter = ColorFilter.tint(controlsColor),
      modifier =
        Modifier.padding(horizontal = 16.dp)
          .padding(vertical = if (controls == XelaNumberInputControls.LEFTRIGHT) 16.dp else 6.dp)
          .size(15.dp)
          .offset(y = if (controls == XelaNumberInputControls.LEFTRIGHT) 0.dp else (-4).dp)
          .alpha(if (isPressed) PRESSED_ALPHA else 1f),
    )
  }
}

@Composable
fun increaseNumberInputBtn(
  increaseIcon: Int,
  value: MutableState<Int>,
  controlsColor: Color,
  controls: XelaNumberInputControls,
) {
  var isPressed by remember { mutableStateOf(false) }
  Box(
    modifier =
      Modifier.pointerInput(Unit) {
        detectTapGestures(
          onPress = {
            isPressed = true
            value.value += 1
            val success = tryAwaitRelease()
            isPressed = !success
          }
        )
      }
  ) {
    Image(
      painter = painterResource(id = increaseIcon),
      contentDescription = "xela number input increase icon",
      colorFilter = ColorFilter.tint(controlsColor),
      modifier =
        Modifier.padding(horizontal = 16.dp)
          .padding(vertical = if (controls == XelaNumberInputControls.LEFTRIGHT) 16.dp else 6.dp)
          .size(15.dp)
          .offset(y = if (controls == XelaNumberInputControls.LEFTRIGHT) 0.dp else 4.dp)
          .alpha(if (isPressed) PRESSED_ALPHA else 1f),
    )
  }
}
