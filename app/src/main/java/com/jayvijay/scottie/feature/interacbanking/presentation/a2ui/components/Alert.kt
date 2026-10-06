package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.xelauikit.XelaAlert

/**
 * Shows either a verbatim service message ([Text]) or an app notice resolved from resources
 * ([NoticeKind] + [NoticeArg]); the data model never carries app copy.
 */
object Alert : A2uiComponent {
  private val Text = A2uiProperty.dynamicString("text")
  private val NoticeKind =
    A2uiProperty.stringEnum("noticeKind", listOf(ACCOUNT_NOT_FOUND, NO_COVER))
  private val NoticeArg = A2uiProperty.dynamicString("noticeArg")
  private val Tone = A2uiProperty.stringEnum("tone", listOf("error", "info"), defaultValue = "info")

  const val ACCOUNT_NOT_FOUND = "accountNotFound"
  const val NO_COVER = "noAccountCovers"

  override val name = "Alert"
  override val description = "Inline notice: verbatim text or a coded notice with one argument."
  override val properties: List<A2uiProperty<*>> = listOf(Text, NoticeKind, NoticeArg, Tone)

  @Composable
  override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean =
    properties.bind(Text) != null || properties.bind(NoticeArg) != null

  @Composable
  override fun A2uiComponentScope.Content(
    properties: A2uiComponentProperties,
    modifier: Modifier,
  ) {
    val arg = properties.bind(NoticeArg)
    val text =
      properties.bind(Text)
        ?: when (properties[NoticeKind]) {
          ACCOUNT_NOT_FOUND -> stringResource(R.string.assistant_account_not_found, arg.orEmpty())
          NO_COVER -> stringResource(R.string.assistant_no_account_covers, arg.orEmpty())
          else -> return
        }
    val error = (properties[Tone] ?: "info") == "error"
    Box(modifier = modifier) {
      XelaAlert(
        title =
          stringResource(
            if (error) R.string.assistant_alert_title_error else R.string.assistant_alert_title_info
          ),
        text = text,
        primaryColor =
          if (error) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
        secondaryColor = MaterialTheme.colorScheme.onSurfaceVariant,
        background = MaterialTheme.colorScheme.surface,
      )
    }
  }
}
