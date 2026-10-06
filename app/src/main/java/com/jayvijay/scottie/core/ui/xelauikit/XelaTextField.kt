package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.textfield.XelaTextFieldState
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaCaption
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSmallBody

@Composable
fun XelaTextField(
  placeholder: String,
  textState: MutableState<TextFieldValue>,
  state: MutableState<XelaTextFieldState>,
  helperText: String? = null,
  leftIcon: Int? = null,
  rightIcon: Int? = null,
  disableAutoCorrection: Boolean = true,
  secureField: Boolean = false,
  background: Color = Color.White,
  disabledBackground: Color = XelaColor.Gray12,
  placeholderColor: Color = XelaColor.Gray8,
  textfieldColor: Color = XelaColor.Gray,
  disabledTextfieldColor: Color = XelaColor.Gray8,
  borderDefaultColor: Color = XelaColor.Gray11,
  borderDisabledColor: Color = XelaColor.Gray8,
  borderErrorColor: Color = XelaColor.Red3,
  borderSuccessColor: Color = XelaColor.Green1,
  borderFocusColor: Color = XelaColor.Blue5,
  iconDefaultColor: Color? = null,
  iconDisabledColor: Color = XelaColor.Gray8,
  iconErrorColor: Color = XelaColor.Red3,
  iconSuccessColor: Color = XelaColor.Green1,
  defaultHelperTextColor: Color = XelaColor.Gray8,
  disabledHelperTextColor: Color = XelaColor.Gray8,
  errorHelperTextColor: Color = XelaColor.Red3,
  successHelperTextColor: Color = XelaColor.Green1,
  keyboardType: KeyboardType = KeyboardType.Text,
) {
  val focusRequester = remember {
    FocusRequester()
  }
  val focusManager = LocalFocusManager.current
  Column {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier =
        Modifier.border(
          width = if (state.value == XelaTextFieldState.FOCUS) 2.dp else 1.dp,
          color =
            if (state.value == XelaTextFieldState.DEFAULT) borderDefaultColor
            else {
              if (state.value == XelaTextFieldState.FOCUS) {
                borderFocusColor
              } else {
                if (state.value == XelaTextFieldState.ERROR) {
                  borderErrorColor
                } else {
                  if (state.value == XelaTextFieldState.SUCCESS) {
                    borderSuccessColor
                  } else {
                    borderDisabledColor
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
              if (state.value == XelaTextFieldState.DISABLED) disabledBackground else background
          ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
              ) {
                focusRequester.requestFocus()
              }
              .height(56.dp)
              .fillMaxWidth()
              .padding(vertical = 8.dp)
              .padding(start = if (leftIcon == null) 24.dp else 16.dp)
              .padding(end = if (rightIcon == null) 24.dp else 16.dp),
        ) {
          if (leftIcon != null) {
            Image(
              painter = painterResource(id = leftIcon),
              contentDescription = "xela textfield left icon",
              colorFilter =
                (if (state.value == XelaTextFieldState.SUCCESS) {
                  ColorFilter.tint(iconSuccessColor)
                } else {
                  if (state.value == XelaTextFieldState.ERROR) {
                    ColorFilter.tint(iconErrorColor)
                  } else {
                    if (state.value == XelaTextFieldState.DISABLED) {
                      ColorFilter.tint(iconDisabledColor)
                    } else {
                      if (iconDefaultColor != null) {
                        ColorFilter.tint(iconDefaultColor)
                      } else {
                        null
                      }
                    }
                  }
                }),
              modifier = Modifier.padding(end = 16.dp).size(15.dp),
            )
          }

          Box(modifier = Modifier.weight(1f)) {
            Text(
              placeholder,
              style = xelaSmallBody,
              color = placeholderColor,
              modifier =
                Modifier.offset(y = if (textState.value.text.isNotEmpty()) (0).dp else 10.dp),
            )

            BasicTextField(
              value = textState.value,
              onValueChange = { textState.value = it },
              keyboardOptions =
                KeyboardOptions(
                  keyboardType = if (secureField) KeyboardType.Password else keyboardType,
                  imeAction = ImeAction.Done,
                  autoCorrect = !disableAutoCorrection,
                ),
              keyboardActions =
                KeyboardActions(
                  onDone = {
                    focusManager.clearFocus()
                    if (state.value == XelaTextFieldState.FOCUS) {
                      state.value = XelaTextFieldState.DEFAULT
                    }
                  }
                ),
              visualTransformation =
                if (secureField) PasswordVisualTransformation() else VisualTransformation.None,
              singleLine = true,
              maxLines = 1,
              textStyle =
                xelaButtonMedium.plus(
                  TextStyle(
                    color =
                      if (state.value == XelaTextFieldState.DISABLED) disabledTextfieldColor
                      else textfieldColor
                  )
                ),
              enabled = state.value != XelaTextFieldState.DISABLED,
              modifier =
                Modifier.focusRequester(focusRequester)
                  .onFocusChanged {
                    if (it.isFocused) {
                      state.value = XelaTextFieldState.FOCUS
                    } else {
                      if (state.value == XelaTextFieldState.FOCUS)
                        state.value = XelaTextFieldState.DEFAULT
                    }
                  }
                  .height(40.dp)
                  .offset(y = if (textState.value.text.isNotEmpty()) 20.dp else 10.dp),
            )
          }

          if (rightIcon != null) {
            Image(
              painter = painterResource(id = rightIcon),
              contentDescription = "xela textfield right icon",
              colorFilter =
                (if (state.value == XelaTextFieldState.SUCCESS) {
                  ColorFilter.tint(iconSuccessColor)
                } else {
                  if (state.value == XelaTextFieldState.ERROR) {
                    ColorFilter.tint(iconErrorColor)
                  } else {
                    if (state.value == XelaTextFieldState.DISABLED) {
                      ColorFilter.tint(iconDisabledColor)
                    } else {
                      if (iconDefaultColor != null) {
                        ColorFilter.tint(iconDefaultColor)
                      } else {
                        null
                      }
                    }
                  }
                }),
              modifier = Modifier.padding(start = 16.dp).size(15.dp),
            )
          }
        }
      }
    }

    if (helperText != null) {
      Text(
        helperText,
        style = xelaCaption,
        color =
          if (state.value == XelaTextFieldState.DEFAULT) defaultHelperTextColor
          else {
            if (state.value == XelaTextFieldState.DISABLED) {
              disabledHelperTextColor
            } else {
              if (state.value == XelaTextFieldState.ERROR) {
                errorHelperTextColor
              } else {
                if (state.value == XelaTextFieldState.SUCCESS) successHelperTextColor
                else defaultHelperTextColor
              }
            }
          },
        modifier = Modifier.padding(top = 8.dp),
      )
    }
  }
}
