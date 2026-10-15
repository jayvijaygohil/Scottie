package com.jayvijay.scottie.core.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.R

val ScottieSansFontFamily =
  FontFamily(
    Font(R.font.nunitosansextralight, FontWeight.ExtraLight),
    Font(R.font.nunitosansextralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.nunitosanslight, FontWeight.Light),
    Font(R.font.nunitosanslightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.nunitosansregular, FontWeight.Normal),
    Font(R.font.nunitosansitalic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nunitosanssemibold, FontWeight.SemiBold),
    Font(R.font.nunitosanssemibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.nunitosansbold, FontWeight.Bold),
    Font(R.font.nunitosansbolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.nunitosansextrabold, FontWeight.ExtraBold),
    Font(R.font.nunitosansextrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.nunitosansblack, FontWeight.Black),
    Font(R.font.nunitosansblackitalic, FontWeight.Black, FontStyle.Italic),
  )

val ScottieMonoFontFamily = FontFamily.Monospace

private const val TABULAR_FIGURES = "tnum"

/**
 * Standalone Material 3 typography scale aligned with the Stitch Autonomous Banking Experience:
 * - headline-lg: 32sp / 40sp Bold (tabular figures)
 * - headline-lg-mobile: 26sp / 34sp Bold (tabular figures)
 * - headline-md: 22sp / 28sp SemiBold (tabular figures)
 * - headline-sm: 18sp / 24sp SemiBold
 * - title-lg: 16sp / 22sp SemiBold
 * - title-md: 14sp / 20sp SemiBold
 * - body-lg: 15sp / 22sp Normal
 * - body-md: 13sp / 18sp Normal
 * - label-md: 12sp / 16sp Medium
 * - label-mono: 11sp / 14sp Medium Monospace
 * - code-sm: 12sp / 16sp Normal Monospace
 */
val ScottieTypography =
  Typography(
    displayLarge =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontFeatureSettings = TABULAR_FIGURES,
      ),
    displayMedium =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 34.sp,
        fontFeatureSettings = TABULAR_FIGURES,
      ),
    displaySmall =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontFeatureSettings = TABULAR_FIGURES,
      ),
    headlineLarge =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 34.sp,
        fontFeatureSettings = TABULAR_FIGURES,
      ),
    headlineMedium =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontFeatureSettings = TABULAR_FIGURES,
      ),
    headlineSmall =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
      ),
    titleLarge =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 22.sp,
      ),
    titleMedium =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
      ),
    titleSmall =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 18.sp,
      ),
    bodyLarge =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 22.sp,
      ),
    bodyMedium =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 18.sp,
      ),
    bodySmall =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
      ),
    labelLarge =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
      ),
    labelMedium =
      TextStyle(
        fontFamily = ScottieSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
      ),
    labelSmall =
      TextStyle(
        fontFamily = ScottieMonoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        fontFeatureSettings = TABULAR_FIGURES,
      ),
  )

/** Monospace style for technical specs, endpoints, and quantization tags (`code-sm`). */
val ScottieCodeSmall =
  TextStyle(
    fontFamily = ScottieMonoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFeatureSettings = TABULAR_FIGURES,
  )
