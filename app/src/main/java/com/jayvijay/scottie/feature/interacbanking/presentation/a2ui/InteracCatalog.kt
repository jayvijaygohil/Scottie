package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui

import android.icu.text.MessageFormat
import androidx.a2ui.compose.ui.A2uiCatalog
import androidx.a2ui.model.catalog.functions.A2uiLocaleProvider
import androidx.compose.material3.a2ui.catalog.A2uiAudioPlayerRenderer
import androidx.compose.material3.a2ui.catalog.A2uiImageRenderer
import androidx.compose.material3.a2ui.catalog.A2uiVideoRenderer
import androidx.compose.material3.a2ui.catalog.MaterialA2uiBasicCatalogV1Defaults
import androidx.compose.material3.a2ui.catalog.materialA2uiBasicCatalogV1
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Alert
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Badge
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.BalanceCard
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Confirmation
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.InteracForm
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.TransactionList

const val INTERAC_CATALOG_ID = "com.jayvijay.scottie/a2ui/interac/v1"

/** Media and basic inputs the assistant never emits; the catalog must not advertise them. */
private val REMOVED =
  setOf(
    "Image",
    "Video",
    "AudioPlayer",
    "TextField",
    "CheckBox",
    "ChoicePicker",
    "Slider",
    "DateTimeInput",
    "Button",
    "Tabs",
    "Modal",
  )

/** Material layout/text basics plus the Xela-backed Interac components. */
fun interacCatalog(): A2uiCatalog {
  val base =
    materialA2uiBasicCatalogV1(
      image = MaterialA2uiBasicCatalogV1Defaults.image(NoMedia),
      video = MaterialA2uiBasicCatalogV1Defaults.video(NoMedia),
      audioPlayer = MaterialA2uiBasicCatalogV1Defaults.audioPlayer(NoMedia),
      urlOpener = {},
      messageFormatter = { pattern, locale, arguments ->
        MessageFormat(pattern, locale).format(arguments)
      },
      localeProvider = A2uiLocaleProvider.Default,
    )
  return A2uiCatalog(
    catalogId = INTERAC_CATALOG_ID,
    components =
      base.components.filterNot { it.name in REMOVED } +
        listOf(Badge, Alert, BalanceCard, Confirmation, InteracForm, TransactionList),
    functions = base.functions,
    themeSchema = base.themeSchema,
    isInline = true,
  )
}

/** Unreachable (the media components are removed above); fails loudly if ever rendered. */
private object NoMedia : A2uiImageRenderer, A2uiVideoRenderer, A2uiAudioPlayerRenderer {
  @Composable
  override fun Image(
    url: String,
    contentDescription: String?,
    contentScale: ContentScale,
    modifier: Modifier,
    onError: (Throwable?) -> Unit,
  ) = Unsupported(onError)

  @Composable
  override fun Video(url: String, modifier: Modifier, onError: (Throwable?) -> Unit) =
    Unsupported(onError)

  @Composable
  override fun AudioPlayer(
    url: String,
    contentDescription: String?,
    modifier: Modifier,
    onError: (Throwable?) -> Unit,
  ) = Unsupported(onError)

  @Composable
  private fun Unsupported(onError: (Throwable?) -> Unit) {
    LaunchedEffect(Unit) { onError(UnsupportedOperationException("Media is not supported.")) }
  }
}
