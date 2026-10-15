package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import android.content.res.Configuration
import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieBadge
import com.jayvijay.scottie.core.ui.components.ScottieBadgeTone

object Badge : A2uiComponent {
  private val Text = A2uiProperty.dynamicString("text", required = true)
  private val Tone = A2uiProperty.stringEnum("tone", TONES, defaultValue = "info")

  override val name = "Badge"
  override val description = "Small status label."
  override val properties: List<A2uiProperty<*>> = listOf(Text, Tone)

  @Composable
  override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean =
    properties.bind(Text) != null

  @Composable
  override fun A2uiComponentScope.Content(
    properties: A2uiComponentProperties,
    modifier: Modifier,
  ) {
    val text = properties.bind(Text) ?: return
    val badgeTone = mapTone(properties[Tone] ?: "info")
    Box(modifier = modifier) {
      ScottieBadge(text = text, tone = badgeTone)
    }
  }

  internal fun mapTone(tone: String): ScottieBadgeTone =
    when (tone) {
      "success" -> ScottieBadgeTone.Success
      "warning" -> ScottieBadgeTone.Warning
      "error" -> ScottieBadgeTone.Error
      else -> ScottieBadgeTone.Brand
    }

  private val TONES
    get() = listOf("success", "info", "warning")
}

@Preview(name = "A2UI Badge Light", showBackground = true)
@Preview(name = "A2UI Badge Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BadgePreview() {
  ScottieTheme {
    Row(
      modifier = Modifier.background(ScottieTheme.colors.surfaceCard).padding(16.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      ScottieBadge(text = "Autodeposit", tone = Badge.mapTone("success"))
      ScottieBadge(text = "Chequing", tone = Badge.mapTone("info"))
      ScottieBadge(text = "Review", tone = Badge.mapTone("warning"))
    }
  }
}
