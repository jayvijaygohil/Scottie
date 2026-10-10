package com.jayvijay.scottie.core.ui

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.jayvijay.scottie.core.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaBody
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaBodyBold
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonLarge
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaButtonSmall
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaCaption
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaHeadline
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSmallBody
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSmallBodyBold
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaSubheadline
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaTitle1
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaTitle2
import com.jayvijay.scottie.core.ui.xelauikit.models.xelaTitle3

val XelaTypography =
  Typography(
    displayLarge = xelaTitle1,
    displayMedium = xelaTitle2,
    displaySmall = xelaTitle3,
    headlineLarge = xelaHeadline,
    headlineMedium = xelaHeadline,
    headlineSmall = xelaSubheadline,
    titleLarge = xelaSubheadline,
    titleMedium = xelaBodyBold,
    titleSmall = xelaSmallBodyBold,
    bodyLarge = xelaBody,
    bodyMedium = xelaSmallBody,
    bodySmall = xelaCaption,
    labelLarge = xelaButtonLarge,
    labelMedium = xelaButtonMedium,
    labelSmall = xelaButtonSmall,
  )

val XelaDarkColorScheme =
  darkColorScheme(
    primary = XelaColor.Red6,
    onPrimary = Color.White,
    primaryContainer = XelaColor.Red1,
    onPrimaryContainer = XelaColor.Red11,
    secondary = XelaColor.Purple6,
    onSecondary = XelaColor.Gray1,
    secondaryContainer = XelaColor.Purple1,
    onSecondaryContainer = XelaColor.Purple11,
    tertiary = XelaColor.Pink6,
    onTertiary = Color.White,
    tertiaryContainer = XelaColor.Pink1,
    onTertiaryContainer = XelaColor.Pink11,
    background = XelaColor.Gray1,
    onBackground = XelaColor.Gray12,
    surface = XelaColor.Gray2,
    onSurface = XelaColor.Gray12,
    surfaceVariant = XelaColor.Gray3,
    onSurfaceVariant = XelaColor.Gray8,
    outline = XelaColor.Gray5,
    outlineVariant = XelaColor.Gray4,
    error = XelaColor.Orange6,
    onError = XelaColor.Gray1,
    errorContainer = XelaColor.Orange1,
    onErrorContainer = XelaColor.Orange11,
  )

val XelaLightColorScheme =
  lightColorScheme(
    primary = XelaColor.Red3,
    onPrimary = Color.White,
    primaryContainer = XelaColor.Red12,
    onPrimaryContainer = XelaColor.Red1,
    secondary = XelaColor.Purple3,
    onSecondary = Color.White,
    secondaryContainer = XelaColor.Purple12,
    onSecondaryContainer = XelaColor.Purple1,
    tertiary = XelaColor.Pink3,
    onTertiary = Color.White,
    tertiaryContainer = XelaColor.Pink12,
    onTertiaryContainer = XelaColor.Pink1,
    background = XelaColor.Gray12,
    onBackground = XelaColor.Gray2,
    surface = Color.White,
    onSurface = XelaColor.Gray2,
    surfaceVariant = XelaColor.Gray11,
    onSurfaceVariant = XelaColor.Gray5,
    outline = XelaColor.Gray10,
    outlineVariant = XelaColor.Gray11,
    error = XelaColor.Orange2,
    onError = Color.White,
    errorContainer = XelaColor.Orange12,
    onErrorContainer = XelaColor.Orange1,
  )

@Composable
fun ScottieTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> XelaDarkColorScheme
      else -> XelaLightColorScheme
    }

  MaterialTheme(
    colorScheme = colorScheme,
    motionScheme = MotionScheme.expressive(),
    typography = XelaTypography,
    content = content,
  )
}
