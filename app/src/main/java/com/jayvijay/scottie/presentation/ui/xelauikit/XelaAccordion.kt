package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.divider.XelaDividerStyle
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaBodyBold

@Composable
fun XelaAccordion(
  title: String,
  isOpen: MutableState<Boolean> = remember { mutableStateOf(false) },
  leftIconOpen: Int? = null,
  leftIconClose: Int? = null,
  rightIconOpen: Int? = null,
  rightIconClose: Int? = null,
  backgroundOpen: Color = XelaColor.Gray12,
  backgroundClose: Color = XelaColor.Gray12,
  titleColorOpen: Color = XelaColor.Gray2,
  titleColorClose: Color = XelaColor.Gray2,
  dividerColor: Color = XelaColor.Gray11,
  iconSize: Dp = 24.dp,
  content: @Composable () -> Unit,
) {

  Column(
    modifier =
      Modifier.clip(RoundedCornerShape(12.dp))
        .background(if (isOpen.value) backgroundOpen else backgroundClose)
  ) {
    Column(
      modifier =
        Modifier.padding(16.dp).clickable(
          indication = null,
          interactionSource =
            remember {
              MutableInteractionSource()
            },
        ) {
          isOpen.value = !isOpen.value
        }
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        if (leftIconOpen != null && leftIconClose != null) {
          Image(
            painter = painterResource(id = if (isOpen.value) leftIconClose else leftIconOpen),
            contentDescription = "Accordion left icon",
            colorFilter =
              ColorFilter.tint(color = if (isOpen.value) titleColorOpen else titleColorClose),
            modifier = Modifier.size(iconSize),
          )
        }
        Text(
          title,
          style = xelaBodyBold,
          color = if (isOpen.value) titleColorOpen else titleColorClose,
          modifier = Modifier.weight(1f),
        )
        if (rightIconClose != null && rightIconOpen != null) {
          Image(
            painter = painterResource(id = if (isOpen.value) rightIconClose else rightIconOpen),
            contentDescription = "Accordion right icon",
            colorFilter =
              ColorFilter.tint(color = if (isOpen.value) titleColorOpen else titleColorClose),
            modifier = Modifier.size(iconSize),
          )
        }
      }

      AnimatedVisibility(visible = isOpen.value) {
        Box(modifier = Modifier.padding(top = 16.dp)) {
          XelaDivider(style = XelaDividerStyle.DOTTED, color = dividerColor)
        }

        Column(modifier = Modifier.padding(top = 16.dp)) {
          content()
        }
      }

      if (isOpen.value) {
        Box(modifier = Modifier.padding(top = 16.dp)) {
          XelaDivider(style = XelaDividerStyle.DOTTED, color = dividerColor)
        }

        Column(modifier = Modifier.padding(top = 16.dp)) {
          content()
        }
      }
    }
  }
}
