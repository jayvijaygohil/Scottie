package com.jayvijay.scottie.core.ui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Exact Material 3 & Extended Tokens extracted from ./stitch_scotia_agentic_banking_app
val StitchSurface = Color(0xFFFBF9F8)
val StitchSurfaceDim = Color(0xFFDBDAD9)
val StitchSurfaceBright = Color(0xFFFBF9F8)
val StitchSurfaceContainerLowest = Color(0xFFFFFFFF)
val StitchSurfaceContainerLow = Color(0xFFF5F3F3)
val StitchSurfaceContainer = Color(0xFFEFEDED)
val StitchSurfaceContainerHigh = Color(0xFFEAE8E7)
val StitchSurfaceContainerHighest = Color(0xFFE4E2E2)
val StitchOnSurface = Color(0xFF1B1C1C)
val StitchOnSurfaceVariant = Color(0xFF5E3F3B)
val StitchInverseSurface = Color(0xFF303030)
val StitchInverseOnSurface = Color(0xFFF2F0F0)
val StitchOutline = Color(0xFF936E69)
val StitchOutlineVariant = Color(0xFFE9BCB6)
val StitchSurfaceTint = Color(0xFFC0000F)

val StitchPrimary = Color(0xFFBF000F)
val StitchOnPrimary = Color(0xFFFFFFFF)
val StitchPrimaryContainer = Color(0xFFEC111A)
val StitchOnPrimaryContainer = Color(0xFFFFFFFF)
val StitchInversePrimary = Color(0xFFFFB4AA)

val StitchSecondary = Color(0xFF5F5E5E)
val StitchOnSecondary = Color(0xFFFFFFFF)
val StitchSecondaryContainer = Color(0xFFE5E2E1)
val StitchOnSecondaryContainer = Color(0xFF656464)

val StitchTertiary = Color(0xFF006C47)
val StitchOnTertiary = Color(0xFFFFFFFF)
val StitchTertiaryContainer = Color(0xFF03885B)
val StitchOnTertiaryContainer = Color(0xFF000703)

val StitchError = Color(0xFFBA1A1A)
val StitchOnError = Color(0xFFFFFFFF)
val StitchErrorContainer = Color(0xFFFFDAD6)
val StitchOnErrorContainer = Color(0xFF93000A)

val StitchPrimaryFixed = Color(0xFFFFDAD5)
val StitchPrimaryFixedDim = Color(0xFFFFB4AA)
val StitchOnPrimaryFixed = Color(0xFF410001)
val StitchOnPrimaryFixedVariant = Color(0xFF930008)

val StitchSecondaryFixed = Color(0xFFE5E2E1)
val StitchSecondaryFixedDim = Color(0xFFC8C6C5)
val StitchOnSecondaryFixed = Color(0xFF1C1B1B)
val StitchOnSecondaryFixedVariant = Color(0xFF474646)

val StitchTertiaryFixed = Color(0xFF8DF7C1)
val StitchTertiaryFixedDim = Color(0xFF71DBA6)
val StitchOnTertiaryFixed = Color(0xFF002113)
val StitchOnTertiaryFixedVariant = Color(0xFF005235)

val StitchBackground = Color(0xFFFBF9F8)
val StitchOnBackground = Color(0xFF1B1C1C)
val StitchSurfaceVariant = Color(0xFFE4E2E2)

// Extended Banking & Semantic Brand Tokens from Stitch DESIGN.md
val ScotiaRedDeep = Color(0xFFC70A12)
val ScotiaRedSubtle = Color(0xFFFDE8E9)
val SurfaceCanvas = Color(0xFFF4F5F7)
val SurfaceCard = Color(0xFFFFFFFF)
val SurfaceCharcoal = Color(0xFF1E1E1E)
val InteracGold = Color(0xFFFFA800)
val InteracGoldSubtle = Color(0xFFFFF5E0)
val StatusSuccess = Color(0xFF00875A)
val StatusSuccessSubtle = Color(0xFFE6F5F0)
val TextPrimary = Color(0xFF121212)
val TextSecondary = Color(0xFF595959)
val TextTertiary = Color(0xFF8C8C8C)
val BorderSubtle = Color(0xFFE5E7EB)
val GlowBrandRed = Color(0x26EC111A)

val ScottieLightColorScheme =
  lightColorScheme(
    primary = StitchPrimary,
    onPrimary = StitchOnPrimary,
    primaryContainer = StitchPrimaryContainer,
    onPrimaryContainer = StitchOnPrimaryContainer,
    inversePrimary = StitchInversePrimary,
    secondary = StitchSecondary,
    onSecondary = StitchOnSecondary,
    secondaryContainer = StitchSecondaryContainer,
    onSecondaryContainer = StitchOnSecondaryContainer,
    tertiary = StitchTertiary,
    onTertiary = StitchOnTertiary,
    tertiaryContainer = StitchTertiaryContainer,
    onTertiaryContainer = StitchOnTertiaryContainer,
    background = StitchBackground,
    onBackground = StitchOnBackground,
    surface = StitchSurface,
    onSurface = StitchOnSurface,
    surfaceVariant = StitchSurfaceVariant,
    onSurfaceVariant = StitchOnSurfaceVariant,
    surfaceTint = StitchSurfaceTint,
    inverseSurface = StitchInverseSurface,
    inverseOnSurface = StitchInverseOnSurface,
    error = StitchError,
    onError = StitchOnError,
    errorContainer = StitchErrorContainer,
    onErrorContainer = StitchOnErrorContainer,
    outline = StitchOutline,
    outlineVariant = StitchOutlineVariant,
    surfaceBright = StitchSurfaceBright,
    surfaceDim = StitchSurfaceDim,
    surfaceContainer = StitchSurfaceContainer,
    surfaceContainerHigh = StitchSurfaceContainerHigh,
    surfaceContainerHighest = StitchSurfaceContainerHighest,
    surfaceContainerLow = StitchSurfaceContainerLow,
    surfaceContainerLowest = StitchSurfaceContainerLowest,
    primaryFixed = StitchPrimaryFixed,
    primaryFixedDim = StitchPrimaryFixedDim,
    onPrimaryFixed = StitchOnPrimaryFixed,
    onPrimaryFixedVariant = StitchOnPrimaryFixedVariant,
    secondaryFixed = StitchSecondaryFixed,
    secondaryFixedDim = StitchSecondaryFixedDim,
    onSecondaryFixed = StitchOnSecondaryFixed,
    onSecondaryFixedVariant = StitchOnSecondaryFixedVariant,
    tertiaryFixed = StitchTertiaryFixed,
    tertiaryFixedDim = StitchTertiaryFixedDim,
    onTertiaryFixed = StitchOnTertiaryFixed,
    onTertiaryFixedVariant = StitchOnTertiaryFixedVariant,
  )

val ScottieDarkColorScheme =
  darkColorScheme(
    primary = StitchPrimaryContainer,
    onPrimary = StitchOnPrimary,
    primaryContainer = ScotiaRedDeep,
    onPrimaryContainer = StitchPrimaryFixed,
    inversePrimary = StitchPrimary,
    secondary = StitchSecondaryFixedDim,
    onSecondary = StitchOnSecondaryFixed,
    secondaryContainer = StitchOnSecondaryFixedVariant,
    onSecondaryContainer = StitchSecondaryFixed,
    tertiary = StitchTertiaryFixedDim,
    onTertiary = StitchOnTertiaryFixed,
    tertiaryContainer = StitchOnTertiaryFixedVariant,
    onTertiaryContainer = StitchTertiaryFixed,
    background = TextPrimary,
    onBackground = StitchInverseOnSurface,
    surface = SurfaceCharcoal,
    onSurface = StitchInverseOnSurface,
    surfaceVariant = StitchInverseSurface,
    onSurfaceVariant = StitchSecondaryFixedDim,
    surfaceTint = StitchPrimaryContainer,
    inverseSurface = StitchSurface,
    inverseOnSurface = StitchOnSurface,
    error = StitchPrimaryFixedDim,
    onError = StitchOnErrorContainer,
    errorContainer = StitchOnErrorContainer,
    onErrorContainer = StitchErrorContainer,
    outline = TextTertiary,
    outlineVariant = StitchOnSecondaryFixedVariant,
    surfaceBright = StitchInverseSurface,
    surfaceDim = TextPrimary,
    surfaceContainer = SurfaceCharcoal,
    surfaceContainerHigh = StitchInverseSurface,
    surfaceContainerHighest = StitchOnSecondaryFixedVariant,
    surfaceContainerLow = TextPrimary,
    surfaceContainerLowest = TextPrimary,
    primaryFixed = StitchPrimaryFixed,
    primaryFixedDim = StitchPrimaryFixedDim,
    onPrimaryFixed = StitchOnPrimaryFixed,
    onPrimaryFixedVariant = StitchOnPrimaryFixedVariant,
    secondaryFixed = StitchSecondaryFixed,
    secondaryFixedDim = StitchSecondaryFixedDim,
    onSecondaryFixed = StitchOnSecondaryFixed,
    onSecondaryFixedVariant = StitchOnSecondaryFixedVariant,
    tertiaryFixed = StitchTertiaryFixed,
    tertiaryFixedDim = StitchTertiaryFixedDim,
    onTertiaryFixed = StitchOnTertiaryFixed,
    onTertiaryFixedVariant = StitchOnTertiaryFixedVariant,
  )

/**
 * Extended banking semantic colors from the Stitch Autonomous Banking Experience design system.
 */
@Immutable
data class ScottieExtendedColors(
  val scotiaRedDeep: Color,
  val scotiaRedSubtle: Color,
  val surfaceCanvas: Color,
  val surfaceCard: Color,
  val surfaceCharcoal: Color,
  val interacGold: Color,
  val interacGoldSubtle: Color,
  val statusSuccess: Color,
  val statusSuccessSubtle: Color,
  val textPrimary: Color,
  val textSecondary: Color,
  val textTertiary: Color,
  val borderSubtle: Color,
  val glowBrandRed: Color,
)

val LightScottieExtendedColors =
  ScottieExtendedColors(
    scotiaRedDeep = ScotiaRedDeep,
    scotiaRedSubtle = ScotiaRedSubtle,
    surfaceCanvas = SurfaceCanvas,
    surfaceCard = SurfaceCard,
    surfaceCharcoal = SurfaceCharcoal,
    interacGold = InteracGold,
    interacGoldSubtle = InteracGoldSubtle,
    statusSuccess = StatusSuccess,
    statusSuccessSubtle = StatusSuccessSubtle,
    textPrimary = TextPrimary,
    textSecondary = TextSecondary,
    textTertiary = TextTertiary,
    borderSubtle = BorderSubtle,
    glowBrandRed = GlowBrandRed,
  )

val DarkScottieExtendedColors =
  ScottieExtendedColors(
    scotiaRedDeep = ScotiaRedDeep,
    scotiaRedSubtle = StitchOnPrimaryFixed,
    surfaceCanvas = TextPrimary,
    surfaceCard = SurfaceCharcoal,
    surfaceCharcoal = StitchInverseSurface,
    interacGold = InteracGold,
    interacGoldSubtle = StitchInverseSurface,
    statusSuccess = StitchTertiaryFixedDim,
    statusSuccessSubtle = StitchOnTertiaryFixed,
    textPrimary = StitchInverseOnSurface,
    textSecondary = StitchSecondaryFixedDim,
    textTertiary = TextTertiary,
    borderSubtle = StitchInverseSurface,
    glowBrandRed = GlowBrandRed,
  )

val LocalScottieColors = staticCompositionLocalOf { LightScottieExtendedColors }
