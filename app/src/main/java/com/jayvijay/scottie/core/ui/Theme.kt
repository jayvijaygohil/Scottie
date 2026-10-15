package com.jayvijay.scottie.core.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Standalone Material 3 theme for Scottie, locked strictly to the Stitch Autonomous Banking
 * Experience color palette, typography, and shape system.
 */
@Composable
fun ScottieTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) ScottieDarkColorScheme else ScottieLightColorScheme
  val extendedColors = if (darkTheme) DarkScottieExtendedColors else LightScottieExtendedColors

  CompositionLocalProvider(LocalScottieColors provides extendedColors) {
    MaterialTheme(
      colorScheme = colorScheme,
      motionScheme = MotionScheme.expressive(),
      typography = ScottieTypography,
      shapes = ScottieShapes,
      content = content,
    )
  }
}

object ScottieTheme {
  val colors: ScottieExtendedColors
    @Composable @ReadOnlyComposable get() = LocalScottieColors.current
}

@Preview(name = "Scottie Theme Light", widthDp = 390)
@Preview(
  name = "Scottie Theme Dark",
  widthDp = 390,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ScottieThemePreview() {
  ScottieTheme {
    Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier.fillMaxWidth(),
    ) {
      Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
      ) {
        Text(
          text = "Autonomous Banking Experience",
          style = MaterialTheme.typography.headlineMedium,
          color = ScottieTheme.colors.textPrimary,
        )
        Text(
          text = "$14,820.50 CAD",
          style = MaterialTheme.typography.displayMedium,
          color = MaterialTheme.colorScheme.primary,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          SwatchChip("Primary", MaterialTheme.colorScheme.primary)
          SwatchChip("Container", MaterialTheme.colorScheme.primaryContainer)
          SwatchChip("Success", ScottieTheme.colors.statusSuccess)
          SwatchChip("Interac", ScottieTheme.colors.interacGold)
        }
      }
    }
  }
}

@Composable
private fun SwatchChip(label: String, color: Color) {
  Surface(
    shape = MaterialTheme.shapes.large,
    color = ScottieTheme.colors.surfaceCard,
    modifier = Modifier.border(1.dp, ScottieTheme.colors.borderSubtle, MaterialTheme.shapes.large),
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
      Box(modifier = Modifier.size(10.dp).background(color, CircleShape))
      Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        color = ScottieTheme.colors.textPrimary,
      )
    }
  }
}
