package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaBodyBold
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSmallBody

@Composable
fun XelaToast(
  title: String,
  description: String = "",
  icon: Int? = null,
  avatar: (@Composable () -> Unit)? = null,
  rightButtonIcon: Int? = null,
  firstActionButtonText: String? = null,
  secondActionButtonText: String? = null,
  onRightButtonAction: (() -> Unit)? = null,
  onFirstButtonAction: (() -> Unit)? = null,
  onSecondButtonAction: (() -> Unit)? = null,
  autoresize: Boolean = false,
  background: Color = Color.White,
  firstActionButtonColor: Color = XelaColor.Blue3,
  secondActionButtonColor: Color = XelaColor.Blue3,
  titleColor: Color = XelaColor.Gray2,
  descriptionColor: Color = XelaColor.Gray6,
  iconColor: Color = XelaColor.Blue3,
  rightButtonIconColor: Color = XelaColor.Gray2,
) {
  val size = remember { mutableStateOf(IntSize.Zero) }
  Row(modifier = Modifier.clip(RoundedCornerShape(18.dp)).background(background)) {
    Row(
      modifier = Modifier.padding(start = 16.dp).padding(vertical = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      if (avatar != null || icon != null) {

        Column(
          modifier =
            Modifier.composed {
                if (icon != null)
                  Modifier.height(with(LocalDensity.current) { size.value.height.toDp() })
                else Modifier
              }
              .padding(end = 16.dp),
          verticalArrangement = Arrangement.Top,
        ) {
          if (avatar != null) {
            avatar()
          }
          if (icon != null) {
            Image(
              painter = painterResource(id = icon),
              colorFilter = ColorFilter.tint(iconColor),
              contentDescription = "Toast icon",
              modifier = Modifier.size(24.dp),
            )
          }
        }
      }

      Column(
        modifier =
          Modifier.onSizeChanged { size.value = it }
            .composed {
              if (!autoresize) Modifier.weight(1f) else Modifier
            }
      ) {
        Text(title, style = xelaBodyBold, color = titleColor)
        if (description.isNotEmpty())
          Text(description, style = xelaSmallBody, color = descriptionColor)
        if (firstActionButtonText != null && secondActionButtonText != null) {
          Row(modifier = Modifier.padding(top = 8.dp)) {
            Text(
              text = firstActionButtonText,
              style = xelaButtonMedium,
              color = firstActionButtonColor,
              modifier =
                Modifier.padding(end = 18.dp).clickable(
                  indication = null,
                  interactionSource = remember { MutableInteractionSource() },
                ) {
                  if (onFirstButtonAction != null) onFirstButtonAction()
                },
            )

            Text(
              text = secondActionButtonText,
              style = xelaButtonMedium,
              color = secondActionButtonColor,
              modifier =
                Modifier.padding(end = 18.dp).clickable(
                  indication = null,
                  interactionSource = remember { MutableInteractionSource() },
                ) {
                  if (onSecondButtonAction != null) onSecondButtonAction()
                },
            )
          }
        }
      }

      val hasFirstAction = firstActionButtonText != null
      val hasSecondAction = secondActionButtonText != null
      if (hasFirstAction != hasSecondAction) {
        if (firstActionButtonText != null) {
          Text(
            text = firstActionButtonText,
            style = xelaButtonMedium,
            color = firstActionButtonColor,
            modifier =
              Modifier.padding(horizontal = 16.dp).clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
              ) {
                if (onFirstButtonAction != null) onFirstButtonAction()
              },
          )
        }

        if (secondActionButtonText != null) {
          Text(
            text = secondActionButtonText,
            style = xelaButtonMedium,
            color = secondActionButtonColor,
            modifier =
              Modifier.padding(end = 18.dp).clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
              ) {
                if (onSecondButtonAction != null) onSecondButtonAction()
              },
          )
        }
      }

      if (rightButtonIcon != null) {
        Box(
          modifier =
            Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
              ) {
                if (onRightButtonAction != null) onRightButtonAction()
              }
              .padding(end = 16.dp)
        ) {
          Image(
            painter = painterResource(id = rightButtonIcon),
            colorFilter = ColorFilter.tint(rightButtonIconColor),
            contentDescription = "Toast right button icon",
            modifier = Modifier.size(16.dp),
          )
        }
      }
    }
  }
}
