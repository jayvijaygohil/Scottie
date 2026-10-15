package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import android.content.res.Configuration
import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieAlertBanner
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Alert.NoticeArg
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Alert.NoticeKind
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Alert.Text

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
    val isError = (properties[Tone] ?: "info") == "error"
    Box(modifier = modifier) {
      ScottieAlertBanner(
        title =
          stringResource(
            if (isError) R.string.assistant_alert_title_error
            else R.string.assistant_alert_title_info
          ),
        message = text,
        isError = isError,
      )
    }
  }
}

@Preview(name = "A2UI Alert Light", showBackground = true, widthDp = 360)
@Preview(
  name = "A2UI Alert Dark",
  showBackground = true,
  widthDp = 360,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun AlertPreview() {
  ScottieTheme {
    Column(
      modifier = Modifier.background(ScottieTheme.colors.surfaceCard).padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      ScottieAlertBanner(
        title = "Notice",
        message = "No account called Crypto; showing all accounts.",
        isError = false,
      )
      ScottieAlertBanner(
        title = "Cannot complete",
        message = "No chequing or savings account covers $5,000.00.",
        isError = true,
      )
    }
  }
}
