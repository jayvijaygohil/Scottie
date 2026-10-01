package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.toggle.XelaToggleSize

@Composable
fun XelaToggle(
  icon: Int? = null,
  onToggleChange: (item: Boolean) -> Unit = {},
  size: XelaToggleSize = XelaToggleSize.LARGE,
  onBackground: Color = XelaColor.Blue3,
  offBackground: Color = XelaColor.Gray11,
  iconOnColor: Color = XelaColor.Blue3,
  iconOffColor: Color = XelaColor.Gray8,
  circleOnColor: Color = Color.White,
  circleOffColor: Color = Color.White,
  selected: Boolean = false,
  content: (@Composable RowScope.() -> Unit)? = null,
) {

  val isChecked = remember {
    mutableStateOf(selected)
  }

  val animatedBackground = animateColorAsState(if (isChecked.value) onBackground else offBackground)
  val animatedCircleBg = animateColorAsState(if (isChecked.value) circleOnColor else circleOffColor)
  val animatedIconColor = animateColorAsState(if (isChecked.value) iconOnColor else iconOffColor)
  val offsetAnimation =
    animateDpAsState(
      if (isChecked.value) {
        (if (size == XelaToggleSize.LARGE) 56.dp
        else {
          if (size == XelaToggleSize.MEDIUM) 48.dp else 32.dp
        }) -
          (if (size == XelaToggleSize.LARGE) 24.dp
          else {
            if (size == XelaToggleSize.MEDIUM) 20.dp else 14.dp
          }) -
          (if (size == XelaToggleSize.LARGE) 4.dp
          else {
            if (size == XelaToggleSize.MEDIUM) 2.dp else 1.dp
          })
      } else {
        if (size == XelaToggleSize.LARGE) 4.dp
        else {
          if (size == XelaToggleSize.MEDIUM) 2.dp else 1.dp
        }
      }
    )
  Row(
    verticalAlignment = CenterVertically,
    modifier =
      Modifier.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
      ) {
        isChecked.value = !isChecked.value
        onToggleChange(isChecked.value)
      },
  ) {
    Row(
      verticalAlignment = CenterVertically,
      modifier = Modifier.padding(top = 8.dp).padding(bottom = 8.dp),
    ) {
      if (content != null) {
        content()

        Spacer(modifier = Modifier.weight(1f).padding(start = 16.dp))
      }

      Row(
        verticalAlignment = CenterVertically,
        modifier =
          Modifier.size(
              width =
                if (size == XelaToggleSize.LARGE) 56.dp
                else {
                  if (size == XelaToggleSize.MEDIUM) 48.dp else 32.dp
                },
              height =
                if (size == XelaToggleSize.LARGE) 32.dp
                else {
                  if (size == XelaToggleSize.MEDIUM) 24.dp else 16.dp
                },
            )
            .clip(RoundedCornerShape(100.dp))
            .background(animatedBackground.value),
      ) {
        Surface(
          shadowElevation = 2.dp,
          color = animatedCircleBg.value,
          modifier =
            Modifier.offset(x = offsetAnimation.value)
              .clip(CircleShape)
              .background(animatedCircleBg.value)
              .size(
                if (size == XelaToggleSize.LARGE) 24.dp
                else {
                  if (size == XelaToggleSize.MEDIUM) 20.dp else 14.dp
                }
              ),
        ) {
          if (icon != null) {
            Row(
              verticalAlignment = CenterVertically,
              modifier = Modifier.fillMaxWidth(),
            ) {
              Spacer(modifier = Modifier.weight(1f))
              Image(
                painter = painterResource(id = icon),
                contentDescription = "Toggle icon",
                colorFilter = ColorFilter.tint(animatedIconColor.value),
                modifier =
                  Modifier.size(if (size == XelaToggleSize.SMALL) 14.dp else 16.dp).padding(2.dp),
              )
              Spacer(modifier = Modifier.weight(1f))
            }
          }
        }
      }
    }
  }
}
