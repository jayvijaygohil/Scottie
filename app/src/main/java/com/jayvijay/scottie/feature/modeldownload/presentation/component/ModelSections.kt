package com.jayvijay.scottie.feature.modeldownload.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.components.ScottieAccordionHeader
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelSection
import com.jayvijay.scottie.feature.modeldownload.presentation.OpenRouterSection

/** Flattened so long sections stay lazy and rows keep their identity while toggling. */
@Composable
fun ModelSections(
  sections: List<ModelSection>,
  openRouter: OpenRouterSection,
  onEvent: (ModelDownloadAction) -> Unit,
  onDownload: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val resources = LocalResources.current
  fun countLabel(count: Int) =
    resources.getQuantityString(R.plurals.model_section_count, count, count)

  LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    sections.forEach { section ->
      item(key = "type:${section.type}", contentType = "category") {
        ScottieAccordionHeader(
          title = stringResource(section.type.label()),
          countLabel = countLabel(section.count),
          expanded = section.expanded,
          onToggle = { onEvent(ModelDownloadAction.ToggleCategory(section.type)) },
          modifier = Modifier.animateItem(),
        )
      }
      if (section.expanded) {
        items(section.models, key = { it.id }, contentType = { "model" }) { model ->
          ModelDownloadUiItem(
            name = model.name,
            description = model.description,
            supported = model.supported,
            downloadBytes = model.downloadBytes,
            status = model.status,
            canStart = model.canStart,
            onDownload = { onDownload(model.id) },
            onPause = { onEvent(ModelDownloadAction.Pause(model.id)) },
            onDelete = { onEvent(ModelDownloadAction.Delete(model.id)) },
            modifier = Modifier.animateItem(),
            onUse =
              if (model.type == ModelType.TEXT) {
                { onEvent(ModelDownloadAction.UseModel(model.id)) }
              } else {
                null
              },
          )
        }
      }
    }
    item(key = "openrouter", contentType = "category") {
      ScottieAccordionHeader(
        title = stringResource(R.string.model_download_openrouter_title),
        countLabel = countLabel(openRouter.savedModelCount),
        expanded = openRouter.expanded,
        onToggle = { onEvent(ModelDownloadAction.ToggleOpenRouter) },
        modifier = Modifier.animateItem().testTag(OpenRouterCardTags.HEADER),
      )
    }
    if (openRouter.expanded) {
      item(key = "openrouter-card", contentType = "openrouter") {
        OpenRouterCard(openRouter, onEvent, Modifier.animateItem())
      }
    }
  }
}

private fun ModelType.label(): Int =
  when (this) {
    ModelType.TEXT -> R.string.model_type_text
    ModelType.SPEECH_RECOGNITION -> R.string.model_type_speech
  }
