package com.jayvijay.scottie.feature.modeldownload.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieAccordionHeader
import com.jayvijay.scottie.core.ui.components.ScottieBadge
import com.jayvijay.scottie.core.ui.components.ScottieBadgeTone
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelDownloadStatus
import com.jayvijay.scottie.feature.modeldownload.domain.entities.ModelType
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadModel
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelSection
import com.jayvijay.scottie.feature.modeldownload.presentation.OpenRouterSection
import com.jayvijay.scottie.feature.modeldownload.presentation.RemoteModels
import com.jayvijay.scottie.feature.modeldownload.presentation.TextModelOption

const val TAG_MODEL_SELECTOR = "chat_model_selector"
const val TAG_MODEL_OPTION = "chat_model_option"
const val TAG_AUDIO_MODEL_SELECTOR = "audio_model_selector"
const val TAG_AUDIO_MODEL_OPTION = "audio_model_option"

/** Active model name with a dropdown of every available model; haptic tick on a change. */
@Composable
fun ModelSelector(
  models: List<TextModelOption>,
  activeId: String?,
  enabled: Boolean,
  onSelect: (String) -> Unit,
  modifier: Modifier = Modifier,
  label: String? = null,
  noneLabel: String? = null,
  onSelectNone: (() -> Unit)? = null,
  selectorTag: String = TAG_MODEL_SELECTOR,
  optionTag: String = TAG_MODEL_OPTION,
  descriptionRes: Int = R.string.chat_model_selector,
) {
  val colors = ScottieTheme.colors
  var expanded by remember { mutableStateOf(false) }
  val haptic = LocalHapticFeedback.current
  val activeModel = models.firstOrNull { it.id == activeId }
  val activeName = activeModel?.name ?: noneLabel ?: stringResource(R.string.chat_empty_title)
  val description = stringResource(descriptionRes, activeName)
  val hasActive = activeModel != null || (noneLabel == null && enabled)
  Box(modifier = modifier) {
    Row(
      modifier =
        Modifier.clip(RoundedCornerShape(999.dp))
          .background(colors.surfaceCanvas)
          .border(1.dp, colors.borderSubtle, RoundedCornerShape(999.dp))
          .clickable(enabled = enabled) { expanded = true }
          .semantics { contentDescription = description }
          .testTag(selectorTag)
          .padding(horizontal = 12.dp, vertical = 6.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
      Box(
        modifier =
          Modifier.size(7.dp)
            .clip(CircleShape)
            .background(if (hasActive) colors.statusSuccess else colors.interacGold)
      )
      if (label != null) {
        Text(
          text = "$label:",
          style = MaterialTheme.typography.labelMedium,
          color = colors.textSecondary,
        )
      }
      Text(
        text = activeName,
        style = MaterialTheme.typography.labelLarge,
        color = colors.textPrimary,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.widthIn(max = 160.dp),
      )
      if (activeModel?.remote == true) {
        ScottieBadge(
          text = stringResource(R.string.chat_model_remote),
          tone = ScottieBadgeTone.Neutral,
        )
      }
      Icon(
        painter = painterResource(R.drawable.ic_chevron_down),
        contentDescription = null,
        tint = colors.textSecondary,
        modifier = Modifier.size(14.dp),
      )
    }
    DropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false },
      containerColor = colors.surfaceCard,
    ) {
      if (noneLabel != null && onSelectNone != null) {
        DropdownMenuItem(
          text = {
            Text(
              text = noneLabel,
              style = MaterialTheme.typography.bodyMedium,
              color = colors.textPrimary,
            )
          },
          onClick = {
            expanded = false
            if (activeId != null) {
              haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelectNone()
            }
          },
          modifier = Modifier.testTag(optionTag),
          trailingIcon = {
            if (activeId == null) {
              Icon(
                Icons.Rounded.Check,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
              )
            }
          },
        )
      }
      models.forEach { model ->
        DropdownMenuItem(
          text = {
            Row(
              horizontalArrangement = Arrangement.spacedBy(8.dp),
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Text(
                text = model.name,
                style = MaterialTheme.typography.bodyMedium,
                color = colors.textPrimary,
              )
              if (model.remote) {
                ScottieBadge(
                  text = stringResource(R.string.chat_model_remote),
                  tone = ScottieBadgeTone.Neutral,
                )
              }
            }
          },
          onClick = {
            expanded = false
            if (model.id != activeId) {
              haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
              onSelect(model.id)
            }
          },
          modifier = Modifier.testTag(optionTag),
          trailingIcon = {
            if (model.id == activeId) {
              Icon(
                Icons.Rounded.Check,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
              )
            }
          },
        )
      }
    }
  }
}

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
    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 24.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp),
  ) {
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
              if (model.type == ModelType.TEXT || model.type == ModelType.SPEECH_RECOGNITION) {
                { onEvent(ModelDownloadAction.UseModel(model.id)) }
              } else {
                null
              },
          )
        }
      }
    }
  }
}

private fun ModelType.label(): Int =
  when (this) {
    ModelType.TEXT -> R.string.model_type_text
    ModelType.SPEECH_RECOGNITION -> R.string.model_type_speech
  }

private const val PREVIEW_BYTES = 1_610_612_736L

@Preview(name = "ModelSections Light", showBackground = true, widthDp = 390)
@Preview(
  name = "ModelSections Dark",
  showBackground = true,
  widthDp = 390,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ModelSectionsPreview() {
  ScottieTheme {
    ModelSections(
      sections =
        listOf(
          ModelSection(
            type = ModelType.TEXT,
            count = 1,
            expanded = true,
            models =
              listOf(
                ModelDownloadModel(
                  id = "qwen3.5",
                  name = "Qwen3.5 2B Instruct",
                  description = "Alibaba general-purpose chat model; strong quality for its size.",
                  type = ModelType.TEXT,
                  downloadBytes = PREVIEW_BYTES,
                  status = ModelDownloadStatus.Downloaded,
                  supported = true,
                  canStart = false,
                )
              ),
          )
        ),
      openRouter =
        OpenRouterSection(
          baseUrl = OpenRouterConfig.DEFAULT_BASE_URL,
          apiKey = "",
          errors = emptySet(),
          savedModelCount = 0,
          confirmingDelete = false,
          expanded = false,
          list = RemoteModels.Hidden,
          query = "",
        ),
      onEvent = {},
      onDownload = {},
    )
  }
}
