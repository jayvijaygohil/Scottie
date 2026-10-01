package com.jayvijay.scottie.presentation.features.modeldownload.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.domain.entities.HardwareTarget
import com.jayvijay.scottie.domain.entities.ModelType
import com.jayvijay.scottie.presentation.features.modeldownload.ModelDownloadAction
import com.jayvijay.scottie.presentation.features.modeldownload.ModelSection
import com.jayvijay.scottie.presentation.ui.components.ScottieAccordionHeader

/** Flattened so long sections stay lazy and rows keep their identity while toggling. */
@Composable
fun ModelSections(
  sections: List<ModelSection>,
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
      if (!section.expanded) return@forEach
      section.groups.forEach { group ->
        item(key = "group:${section.type}:${group.target}", contentType = "group") {
          ScottieAccordionHeader(
            title = stringResource(group.target.label()),
            countLabel = countLabel(group.models.size),
            expanded = group.expanded,
            onToggle = { onEvent(ModelDownloadAction.ToggleGroup(section.type, group.target)) },
            modifier = Modifier.animateItem(),
            level = 1,
          )
        }
        if (group.expanded) {
          items(group.models, key = { it.id }, contentType = { "model" }) { model ->
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
            )
          }
        }
      }
    }
  }
}

private fun ModelType.label(): Int =
  when (this) {
    ModelType.TEXT -> R.string.model_type_text
    ModelType.MULTIMODAL -> R.string.model_type_multimodal
    ModelType.VISION -> R.string.model_type_vision
    ModelType.IMAGE_GENERATION -> R.string.model_type_image_generation
    ModelType.EMBEDDING -> R.string.model_type_embedding
    ModelType.SPEECH_RECOGNITION -> R.string.model_type_speech_recognition
    ModelType.SPEECH_SYNTHESIS -> R.string.model_type_speech_synthesis
    ModelType.VOICE_ACTIVITY -> R.string.model_type_voice_activity
    ModelType.SEGMENTATION -> R.string.model_type_segmentation
    ModelType.OTHER -> R.string.model_type_other
  }

private fun HardwareTarget.label(): Int =
  when (this) {
    HardwareTarget.CPU -> R.string.model_target_cpu
    HardwareTarget.NPU -> R.string.model_target_npu
  }
