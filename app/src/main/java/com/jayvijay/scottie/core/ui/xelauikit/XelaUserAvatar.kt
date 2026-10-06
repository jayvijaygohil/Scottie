package com.jayvijay.scottie.core.ui.xelauikit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.useravatar.XelaUserAvatarDecoration
import com.jayvijay.scottie.core.ui.xelauikit.models.useravatar.XelaUserAvatarDecorationPosition
import com.jayvijay.scottie.core.ui.xelauikit.models.useravatar.XelaUserAvatarSize
import com.jayvijay.scottie.core.ui.xelauikit.models.useravatar.XelaUserAvatarStyle
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaHeadline
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSubheadline

@Composable
fun XelaUserAvatar(
  size: XelaUserAvatarSize,
  style: XelaUserAvatarStyle,
  initials: String? = null,
  icon: Int? = null,
  image: Int? = null,
  count: Int = 0,
  decoration: XelaUserAvatarDecoration? = null,
  decorationPosition: XelaUserAvatarDecorationPosition = XelaUserAvatarDecorationPosition.TOPRIGHT,
  background: Color = XelaColor.Blue7,
  foreground: Color = Color.White,
  plusIcon: Int? = null,
  decorationBorderColor: Color = Color.White,
  counterBackground: Color = XelaColor.Red3,
) {
  Box(
    modifier =
      Modifier.size(
        if (size == XelaUserAvatarSize.LARGE) 64.dp
        else {
          if (size == XelaUserAvatarSize.MEDIUM) 48.dp else 32.dp
        }
      )
  ) {
    Box(
      modifier =
        Modifier.clip(
            if (style == XelaUserAvatarStyle.CIRCLE) CircleShape
            else
              RoundedCornerShape(
                if (size == XelaUserAvatarSize.LARGE) 24.dp
                else {
                  if (size == XelaUserAvatarSize.MEDIUM) 18.dp else 12.dp
                }
              )
          )
          .background(background)
    ) {
      if (initials != null) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
          Spacer(modifier = Modifier.weight(1f))
          Text(
            initials,
            style =
              if (size == XelaUserAvatarSize.LARGE) xelaHeadline
              else {
                if (size == XelaUserAvatarSize.MEDIUM) xelaSubheadline else xelaButtonMedium
              },
            color = foreground,
          )
          Spacer(modifier = Modifier.weight(1f))
        }
      } else if (icon != null) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
          Spacer(modifier = Modifier.weight(1f))
          Image(
            painter = painterResource(id = icon),
            contentDescription = "Xela User avatar icon",
            colorFilter = ColorFilter.tint(foreground),
            modifier =
              Modifier.size(
                if (size == XelaUserAvatarSize.LARGE) 32.dp
                else {
                  if (size == XelaUserAvatarSize.MEDIUM) 24.dp else 16.dp
                }
              ),
          )
          Spacer(modifier = Modifier.weight(1f))
        }
      } else if (image != null) {
        Image(
          painter = painterResource(id = image),
          contentDescription = "Xela User avatar image",
          modifier = Modifier.fillMaxSize(),
        )
      }
    }

    if (decoration == XelaUserAvatarDecoration.COUNTER) {
      Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize()) {
        if (decorationPosition == XelaUserAvatarDecorationPosition.BOTTOMRIGHT) {
          Spacer(modifier = Modifier.weight(1f))
        }
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.clip(CircleShape)
              .background(counterBackground)
              .size(
                if (size == XelaUserAvatarSize.LARGE) 18.dp
                else {
                  if (size == XelaUserAvatarSize.MEDIUM) 16.dp else 12.dp
                }
              ),
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
              count.toString(),
              style = TextStyle(fontSize = if (size == XelaUserAvatarSize.LARGE) 10.sp else 8.sp),
              color = Color.White,
            )
            Spacer(modifier = Modifier.weight(1f))
          }
        }
        if (decorationPosition == XelaUserAvatarDecorationPosition.TOPRIGHT) {
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }

    if (decoration == XelaUserAvatarDecoration.INDICATOR) {
      Column(
        horizontalAlignment = Alignment.End,
        modifier =
          Modifier.fillMaxSize()
            .offset(
              x =
                if (size == XelaUserAvatarSize.LARGE && style == XelaUserAvatarStyle.CIRCLE) (-4).dp
                else 0.dp
            ),
      ) {
        if (decorationPosition == XelaUserAvatarDecorationPosition.BOTTOMRIGHT) {
          Spacer(modifier = Modifier.weight(1f))
        }
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.size(
                if (size == XelaUserAvatarSize.LARGE) 12.dp
                else {
                  if (size == XelaUserAvatarSize.MEDIUM) 10.dp else 8.dp
                }
              )
              .clip(CircleShape)
              .border(
                BorderStroke(
                  if (size == XelaUserAvatarSize.SMALL) 1.dp
                  else {
                    if (size == XelaUserAvatarSize.MEDIUM) 2.dp else 3.dp
                  },
                  SolidColor(decorationBorderColor),
                ),
                CircleShape,
              ),
        ) {
          Row(
            modifier =
              Modifier.background(XelaColor.Green2)
                .size(
                  if (size == XelaUserAvatarSize.LARGE) 9.dp
                  else {
                    if (size == XelaUserAvatarSize.MEDIUM) 8.dp else 7.dp
                  }
                )
          ) {}
        }
        if (decorationPosition == XelaUserAvatarDecorationPosition.TOPRIGHT) {
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }

    if (decoration == XelaUserAvatarDecoration.PLUS) {
      Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize()) {
        if (decorationPosition == XelaUserAvatarDecorationPosition.BOTTOMRIGHT) {
          Spacer(modifier = Modifier.weight(1f))
        }
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.size(
                if (size == XelaUserAvatarSize.LARGE) 18.dp
                else {
                  if (size == XelaUserAvatarSize.MEDIUM) 16.dp else 12.dp
                }
              )
              .clip(CircleShape)
              .border(
                BorderStroke(
                  if (size == XelaUserAvatarSize.SMALL) 1.dp
                  else {
                    if (size == XelaUserAvatarSize.MEDIUM) 2.dp else 3.dp
                  },
                  SolidColor(decorationBorderColor),
                ),
                CircleShape,
              ),
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier =
              Modifier.background(XelaColor.Blue5)
                .size(
                  if (size == XelaUserAvatarSize.LARGE) 15.dp
                  else {
                    if (size == XelaUserAvatarSize.MEDIUM) 14.dp else 11.dp
                  }
                )
                .offset(
                  x =
                    if (size == XelaUserAvatarSize.SMALL) (0.25).dp
                    else {
                      if (size == XelaUserAvatarSize.MEDIUM) (0.75).dp else 1.dp
                    }
                ),
          ) {
            Box(
              modifier = Modifier.fillMaxSize(),
              contentAlignment = Alignment.Center,
            ) {
              if (plusIcon != null) {
                Image(
                  painter = painterResource(id = plusIcon),
                  contentDescription = "Plus",
                  colorFilter = ColorFilter.tint(Color.White),
                  modifier = Modifier.size(7.dp),
                )
              }
            }
          }
        }
        if (decorationPosition == XelaUserAvatarDecorationPosition.TOPRIGHT) {
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }
  }
}
