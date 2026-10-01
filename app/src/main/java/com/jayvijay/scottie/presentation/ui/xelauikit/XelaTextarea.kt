package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.textarea.XelaTextareaState
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSmallBody

@Composable
fun XelaTextarea(
  value: MutableState<TextFieldValue>,
  helperText: String? = null,
  placeholder: String,
  state: MutableState<XelaTextareaState>,
  disableAutoCorrection: Boolean = true,
  counter: Boolean = false,
  maxSymbols: Int = 200,
  placeholderColor: Color = XelaColor.Gray8,
  counterColor: Color = XelaColor.Gray8,
  disabledTextareaColor: Color = XelaColor.Gray8,
  defaultTextareaColor: Color = XelaColor.Gray2,
  errorTextareaColor: Color = XelaColor.Red3,
  borderDefaultColor: Color = XelaColor.Gray11,
  borderDisabledColor: Color = XelaColor.Gray8,
  borderErrorColor: Color = XelaColor.Red3,
  borderSuccessColor: Color = XelaColor.Green1,
  borderFocusColor: Color = XelaColor.Blue5,
  background: Color = Color.White,
  disabledBackground: Color = XelaColor.Gray12,
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
          width = if (state.value == XelaTextareaState.FOCUS) 2.dp else 1.dp,
          color =
            if (state.value == XelaTextareaState.DEFAULT) borderDefaultColor
            else {
              if (state.value == XelaTextareaState.FOCUS) {
                borderFocusColor
              } else {
                if (state.value == XelaTextareaState.ERROR) {
                  borderErrorColor
                } else {
                  if (state.value == XelaTextareaState.SUCCESS) {
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
              if (state.value == XelaTextareaState.DISABLED) disabledBackground else background
          ),
      ) {
        Column(
          modifier =
            Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
              ) {
                focusRequester.requestFocus()
              }
              .height(200.dp)
              .fillMaxWidth()
              .padding(16.dp)
        ) {
          Row {
            Text(
              placeholder,
              style = xelaSmallBody,
              color = placeholderColor,
              modifier = Modifier,
            )
            Spacer(modifier = Modifier.weight(1f))
            if (counter) {
              Text(
                (value.value.text.length.toString()) + "/" + (maxSymbols.toString()),
                style = xelaSmallBody,
                color = counterColor,
              )
              if (value.value.text.length > maxSymbols) {
                state.value = XelaTextareaState.ERROR
              } else if (state.value != XelaTextareaState.DEFAULT) {
                state.value = XelaTextareaState.FOCUS
              } else {
                state.value = XelaTextareaState.DEFAULT
              }
            }
          }

          BasicTextField(
            value = value.value,
            onValueChange = { value.value = it },
            keyboardOptions =
              KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Done,
                autoCorrect = !disableAutoCorrection,
              ),
            keyboardActions =
              KeyboardActions(
                onDone = {
                  focusManager.clearFocus()
                  if (state.value == XelaTextareaState.FOCUS) {
                    state.value = XelaTextareaState.DEFAULT
                  }
                }
              ),
            textStyle =
              xelaButtonMedium.plus(
                TextStyle(
                  color =
                    if (state.value == XelaTextareaState.DISABLED) disabledTextareaColor
                    else {
                      if (state.value == XelaTextareaState.ERROR) errorTextareaColor
                      else defaultTextareaColor
                    }
                )
              ),
            enabled = state.value != XelaTextareaState.DISABLED,
            modifier =
              Modifier.weight(1f)
                .focusRequester(focusRequester)
                .onFocusChanged {
                  if (it.isFocused) {
                    state.value = XelaTextareaState.FOCUS
                  } else {
                    if (state.value == XelaTextareaState.FOCUS)
                      state.value = XelaTextareaState.DEFAULT
                  }
                }
                .height(168.dp),
          )
        }
      }
    }

    if (helperText != null) {
      Text(
        helperText,
        style = xelaCaption,
        color =
          if (state.value == XelaTextareaState.DEFAULT) defaultHelperTextColor
          else {
            if (state.value == XelaTextareaState.DISABLED) {
              disabledHelperTextColor
            } else {
              if (state.value == XelaTextareaState.ERROR) {
                errorHelperTextColor
              } else {
                if (state.value == XelaTextareaState.SUCCESS) successHelperTextColor
                else defaultHelperTextColor
              }
            }
          },
        modifier = Modifier.padding(top = 8.dp),
      )
    }
  }
}
