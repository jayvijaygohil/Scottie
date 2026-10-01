package com.jayvijay.scottie.presentation.ui

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
import com.jayvijay.scottie.presentation.ui.xelauikit.models.XelaColor
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaBody
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaBodyBold
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonLarge
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonMedium
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaButtonSmall
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaCaption
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaHeadline
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSmallBody
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSmallBodyBold
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaSubheadline
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaTitle1
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaTitle2
import com.jayvijay.scottie.presentation.ui.xelauikit.models.xelaTitle3

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
    primary = XelaColor.Blue6,
    onPrimary = Color.White,
    primaryContainer = XelaColor.Blue1,
    onPrimaryContainer = XelaColor.Blue11,
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
    error = XelaColor.Red6,
    onError = Color.White,
    errorContainer = XelaColor.Red1,
    onErrorContainer = XelaColor.Red11,
  )

val XelaLightColorScheme =
  lightColorScheme(
    primary = XelaColor.Blue3,
    onPrimary = Color.White,
    primaryContainer = XelaColor.Blue12,
    onPrimaryContainer = XelaColor.Blue1,
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
    error = XelaColor.Red3,
    onError = Color.White,
    errorContainer = XelaColor.Red12,
    onErrorContainer = XelaColor.Red1,
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
