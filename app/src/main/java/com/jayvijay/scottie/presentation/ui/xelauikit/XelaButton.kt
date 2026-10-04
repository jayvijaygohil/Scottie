package com.jayvijay.scottie.presentation.ui.xelauikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.button.XelaButtonSize
import com.jayvijay.scottie.presentation.ui.xelauikit.models.button.XelaButtonState
import com.jayvijay.scottie.presentation.ui.xelauikit.models.button.XelaButtonType
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonLarge
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonSmall

private const val DISABLED_ALPHA = 0.48f

@Composable
fun XelaButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  leftIcon: Int? = null,
  rightIcon: Int? = null,
  size: XelaButtonSize = XelaButtonSize.MEDIUM,
  state: XelaButtonState = XelaButtonState.DEFAULT,
  type: XelaButtonType = XelaButtonType.PRIMARY,
  background: Color = XelaColor.Blue,
  foregroundColor: Color = Color.White,
  defaultBorderColor: Color = XelaColor.Gray11,
  autoResize: Boolean = true,
  borderLineWidth: Dp = 1.dp,
  removePaddings: Boolean = false,
  alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
) {
  val shape =
    if (!removePaddings) {
      RoundedCornerShape(
        if (size == XelaButtonSize.LARGE || size == XelaButtonSize.MEDIUM) 16.dp else 12.dp
      )
    } else RectangleShape

  val borderModifier =
    if (type == XelaButtonType.PRIMARY) Modifier
    else {
      Modifier.border(
        width = borderLineWidth,
        color = defaultBorderColor,
        shape = shape,
      )
    }

  val startPadding =
    calculateHorizontalPadding(
      removePaddings = removePaddings,
      hasIcon = leftIcon != null,
      size = size,
      textIsEmpty = text.isEmpty(),
    )
  val endPadding =
    calculateHorizontalPadding(
      removePaddings = removePaddings,
      hasIcon = rightIcon != null,
      size = size,
      textIsEmpty = text.isEmpty(),
    )
  val verticalPadding =
    calculateVerticalPadding(
      removePaddings = removePaddings,
      size = size,
    )

  Box(
    modifier =
      modifier
        .alpha(if (state == XelaButtonState.DISABLED) DISABLED_ALPHA else 1f)
        .then(borderModifier)
        .clip(shape)
        .background(background)
        .clickable(
          enabled = state != XelaButtonState.DISABLED,
          role = Role.Button,
          onClick = onClick,
        ),
    contentAlignment = Alignment.Center,
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
      modifier =
        Modifier.padding(
          start = startPadding,
          end = endPadding,
          top = verticalPadding,
          bottom = verticalPadding,
        ),
    ) {
      if (
        !autoResize && (alignment == Alignment.CenterHorizontally || alignment == Alignment.End)
      ) {
        Spacer(modifier = Modifier.weight(1.0f))
      }
      if (leftIcon != null) {
        val leftIconEndPadding =
          calculateIconPadding(
            textIsEmpty = text.isEmpty(),
            otherIconIsNull = rightIcon == null,
            size = size,
          )
        Image(
          painter = painterResource(id = leftIcon),
          contentDescription = "xela button left icon",
          colorFilter = ColorFilter.tint(foregroundColor),
          modifier = Modifier.padding(end = leftIconEndPadding).size(getIconSize(size = size)),
        )
      }

      if (text.isNotEmpty()) {
        Text(
          text = text,
          style =
            when (size) {
              XelaButtonSize.LARGE -> xelaButtonLarge
              XelaButtonSize.MEDIUM -> xelaButtonMedium
              XelaButtonSize.SMALL -> xelaButtonSmall
            },
          color = foregroundColor,
          lineHeight = with(LocalDensity.current) { getIconSize(size = size).toSp() },
        )
      }

      if (rightIcon != null) {
        val rightIconStartPadding =
          calculateIconPadding(
            textIsEmpty = text.isEmpty(),
            otherIconIsNull = leftIcon == null,
            size = size,
          )
        Image(
          painter = painterResource(id = rightIcon),
          contentDescription = "xela button right icon",
          colorFilter = ColorFilter.tint(foregroundColor),
          modifier = Modifier.padding(start = rightIconStartPadding).size(getIconSize(size = size)),
        )
      }
      if (
        !autoResize && (alignment == Alignment.CenterHorizontally || alignment == Alignment.Start)
      ) {
        Spacer(modifier = Modifier.weight(1.0f))
      }
    }
  }
}

private fun calculateHorizontalPadding(
  removePaddings: Boolean,
  hasIcon: Boolean,
  size: XelaButtonSize,
  textIsEmpty: Boolean,
): Dp = when {
  removePaddings -> 0.dp
  hasIcon -> when (size) {
    XelaButtonSize.MEDIUM -> 16.dp
    XelaButtonSize.SMALL -> 8.dp
    XelaButtonSize.LARGE -> 24.dp
  }
  else -> when (size) {
    XelaButtonSize.SMALL -> if (textIsEmpty) 8.dp else 16.dp
    XelaButtonSize.MEDIUM -> 16.dp
    XelaButtonSize.LARGE -> 24.dp
  }
}

private fun calculateVerticalPadding(
  removePaddings: Boolean,
  size: XelaButtonSize,
): Dp = when {
  removePaddings -> 0.dp
  else -> when (size) {
    XelaButtonSize.LARGE,
    XelaButtonSize.MEDIUM -> 16.dp
    XelaButtonSize.SMALL -> 8.dp
  }
}

private fun calculateIconPadding(
  textIsEmpty: Boolean,
  otherIconIsNull: Boolean,
  size: XelaButtonSize,
): Dp = when {
  !textIsEmpty -> when (size) {
    XelaButtonSize.LARGE -> 18.dp
    XelaButtonSize.MEDIUM -> 14.dp
    XelaButtonSize.SMALL -> 9.dp
  }
  otherIconIsNull -> 0.dp
  else -> when (size) {
    XelaButtonSize.LARGE,
    XelaButtonSize.MEDIUM -> 10.dp
    XelaButtonSize.SMALL -> 5.dp
  }
}

fun getIconSize(size: XelaButtonSize): Dp {
  if (size == XelaButtonSize.LARGE || size == XelaButtonSize.MEDIUM) {
    return 20.dp
  }

  return 15.dp
}
