package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.chip.XelaChipSize
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaCaption

private const val DISABLED_ALPHA = 0.48f

@Composable
fun XelaChip(
  text: String,
  size: XelaChipSize = XelaChipSize.LARGE,
  leftIcon: Int? = null,
  rightButtonIcon: Int? = null,
  disabled: Boolean = false,
  selected: Boolean = false,
  borderWidth: Dp = 2.dp,
  defaultBorderColor: Color = XelaColor.Blue3,
  selectedBorderColor: Color = XelaColor.Blue3,
  defaultBackgroundColor: Color = Color.White,
  selectedBackgroundColor: Color = XelaColor.Blue3,
  defaultContentColor: Color = XelaColor.Blue3,
  selectedContentColor: Color = Color.White,
  onRightIconAction: (() -> Unit)? = null,
  onChangeSelectChipAction: ((Boolean) -> Unit)? = null,
) {
  val selectedChip = remember {
    mutableStateOf(selected)
  }
  Box(
    modifier =
      Modifier.clip(RoundedCornerShape(99.dp))
        .background(if (selectedChip.value) selectedBackgroundColor else defaultBackgroundColor)
        .alpha(if (disabled) DISABLED_ALPHA else 1f)
        .border(
          borderWidth,
          if (selectedChip.value) selectedBorderColor else defaultBorderColor,
          RoundedCornerShape(99.dp),
        )
        .clickable(
          enabled = !disabled,
          indication = null,
          interactionSource = remember { MutableInteractionSource() },
        ) {
          selectedChip.value = !selectedChip.value
          if (onChangeSelectChipAction != null) {
            onChangeSelectChipAction(selectedChip.value)
          }
        },
    contentAlignment = Alignment.Center,
  ) {
    Row(
      modifier =
        Modifier.padding(
            vertical =
              if (size == XelaChipSize.LARGE) 12.dp
              else {
                if (size == XelaChipSize.MEDIUM) 8.dp else 4.dp
              }
          )
          .padding(
            start =
              if (leftIcon != null && size == XelaChipSize.MEDIUM || size == XelaChipSize.SMALL)
                8.dp
              else 12.dp,
            end =
              if (rightButtonIcon != null && size != XelaChipSize.LARGE) {
                if (size == XelaChipSize.MEDIUM) 8.dp else 4.dp
              } else 12.dp,
          ),
      horizontalArrangement = Arrangement.spacedBy(10.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      if (leftIcon != null) {
        Image(
          painter = painterResource(id = leftIcon),
          contentDescription = "Chip left icon",
          colorFilter =
            ColorFilter.tint(if (selectedChip.value) selectedContentColor else defaultContentColor),
          modifier = Modifier.size(16.dp),
        )
      }
      Text(
        text,
        style = xelaCaption,
        color = if (selectedChip.value) selectedContentColor else defaultContentColor,
      )
      if (rightButtonIcon != null) {
        Image(
          painter = painterResource(id = rightButtonIcon),
          contentDescription = "Chip right icon",
          colorFilter =
            ColorFilter.tint(if (selectedChip.value) selectedContentColor else defaultContentColor),
          modifier =
            Modifier.size(16.dp).clickable(
              enabled = !disabled,
              indication = null,
              interactionSource = remember { MutableInteractionSource() },
            ) {
              if (onRightIconAction != null) {
                onRightIconAction()
              }
            },
        )
      }
    }
  }
}
