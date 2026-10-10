package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jayvijay.scottie.core.ui.xelauikit.XelaBadge

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
    val (background, foreground) = toneColors(properties[Tone] ?: "info")
    Box(modifier = modifier) {
      XelaBadge(text = text, backgroundColor = background, textColor = foreground)
    }
  }

  @Composable
  internal fun toneColors(tone: String) =
    when (tone) {
      "warning",
      "error" ->
        MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer
      else ->
        MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
    }

  private val TONES
    get() = listOf("success", "info", "warning")
}
