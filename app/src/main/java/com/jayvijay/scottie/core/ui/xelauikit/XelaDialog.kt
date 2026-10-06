package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaBody
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaHeadline

@Composable
fun XelaDialog(
  icon: Int? = null,
  title: String = "",
  description: String = "",
  primaryButton: (@Composable () -> Unit)? = null,
  secondaryButton: (@Composable () -> Unit)? = null,
  closeButtonIcon: Int? = null,
  buttonHorizontal: Boolean = true,
  background: Color = Color.White,
  titleColor: Color = XelaColor.Gray3,
  descriptionColor: Color = XelaColor.Gray3,
  iconColor: Color = XelaColor.Gray3,
  onCloseButtonAction: (() -> Unit)? = null,
  closeButtonIconColor: Color = XelaColor.Gray3,
) {
  Box(modifier = Modifier.clip(RoundedCornerShape(24.dp)).fillMaxWidth().background(background)) {
    if (closeButtonIcon != null) {
      Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd,
      ) {
        Box(
          modifier =
            Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
              ) {
                if (onCloseButtonAction != null) {
                  onCloseButtonAction()
                }
              }
              .padding(32.dp)
        ) {
          Image(
            painter = painterResource(id = closeButtonIcon),
            colorFilter = ColorFilter.tint(closeButtonIconColor),
            contentDescription = "Dialog close button icon",
            modifier = Modifier.size(16.dp),
          )
        }
      }
    }

    Column(
      modifier = Modifier.fillMaxWidth().padding(32.dp),
      verticalArrangement = Arrangement.spacedBy(24.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      if (icon != null) {
        Image(
          painter = painterResource(id = icon),
          contentDescription = "Dialog icon",
          colorFilter = ColorFilter.tint(iconColor),
          modifier = Modifier.size(40.dp),
        )
      }
      if (title.isNotEmpty() || description.isNotEmpty()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          if (title.isNotEmpty())
            Text(title, style = xelaHeadline, color = titleColor, textAlign = TextAlign.Center)
          if (description.isNotEmpty())
            Text(
              text = description,
              style = xelaBody,
              color = descriptionColor,
              textAlign = TextAlign.Center,
              modifier = Modifier.padding(top = 8.dp),
            )
        }
      }
      if (primaryButton != null || secondaryButton != null) {
        if (buttonHorizontal) {
          Row {
            if (primaryButton == null) {
              Spacer(modifier = Modifier.weight(1f))
            }
            if (secondaryButton != null) {
              secondaryButton()
            }
            Spacer(modifier = Modifier.weight(1f))
            if (primaryButton != null) {
              primaryButton()
            }
            if (secondaryButton == null) {
              Spacer(modifier = Modifier.weight(1f))
            }
          }
        } else {
          Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            if (primaryButton != null) {
              primaryButton()
            }
            if (secondaryButton != null) {
              secondaryButton()
            }
          }
        }
      }
    }
  }
}
