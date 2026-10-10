package com.jayvijay.scottie.feature.modeldownload.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieSearchField
import com.jayvijay.scottie.feature.modeldownload.domain.entities.AvailableModel
import com.jayvijay.scottie.feature.modeldownload.domain.entities.FetchFailure
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction
import com.jayvijay.scottie.feature.modeldownload.presentation.OpenRouterSection
import com.jayvijay.scottie.feature.modeldownload.presentation.RemoteModels

/** Draft OpenRouter settings; Save validates in the presenter, Delete appears once saved. */
@Composable
fun OpenRouterCard(
  section: OpenRouterSection,
  onEvent: (ModelDownloadAction) -> Unit,
  modifier: Modifier = Modifier,
) {
  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    color = MaterialTheme.colorScheme.surface,
  ) {
    Column(
      modifier = Modifier.padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      SettingsField(
        value = section.baseUrl,
        onValueChange = { onEvent(ModelDownloadAction.EditOpenRouterBaseUrl(it)) },
        label = R.string.model_download_openrouter_base_url,
        tag = OpenRouterCardTags.BASE_URL,
        keyboardType = KeyboardType.Uri,
        error =
          R.string.model_download_openrouter_error_base_url.takeIf {
            OpenRouterField.BASE_URL in section.errors
          },
      )
      ApiKeyField(section.apiKey) { onEvent(ModelDownloadAction.EditOpenRouterApiKey(it)) }
      if (section.savedModelCount > 0) {
        Text(
          text =
            pluralStringResource(
              R.plurals.model_download_openrouter_saved,
              section.savedModelCount,
              section.savedModelCount,
            ),
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.testTag(OpenRouterCardTags.SAVED),
        )
      }
      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        ModelDownloadButton(
          text = stringResource(R.string.model_download_openrouter_save),
          onClick = { onEvent(ModelDownloadAction.SaveOpenRouter) },
          filled = true,
          modifier = Modifier.testTag(OpenRouterCardTags.SAVE),
        )
        if (section.list != RemoteModels.Hidden) {
          ModelDownloadButton(
            text = stringResource(R.string.model_download_delete),
            onClick = { onEvent(ModelDownloadAction.DeleteOpenRouter) },
            modifier = Modifier.testTag(OpenRouterCardTags.DELETE),
          )
        }
      }
      RemoteModelList(section.list, section.query, onEvent)
    }
  }
}

/** Rows are plain children of the card's lazy item, so no nested lazy list. */
@Composable
private fun RemoteModelList(
  list: RemoteModels,
  query: String,
  onEvent: (ModelDownloadAction) -> Unit,
) {
  when (list) {
    RemoteModels.Hidden -> Unit
    RemoteModels.Loading ->
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.testTag(OpenRouterCardTags.MODELS_LOADING),
      ) {
        CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
        Note(stringResource(R.string.model_download_openrouter_models_loading))
      }
    is RemoteModels.Failed ->
      Column(modifier = Modifier.testTag(OpenRouterCardTags.MODELS_ERROR)) {
        val message =
          when (list.reason) {
            FetchFailure.NO_CONNECTION -> R.string.model_download_openrouter_models_offline
            FetchFailure.AUTH -> R.string.model_download_openrouter_models_auth
            FetchFailure.OTHER -> R.string.model_download_openrouter_models_failed
          }
        Text(
          text = stringResource(message),
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.error,
        )
        TextButton(
          onClick = { onEvent(ModelDownloadAction.RetryRemoteModels) },
          modifier = Modifier.testTag(OpenRouterCardTags.MODELS_RETRY),
        ) {
          Text(stringResource(R.string.model_download_openrouter_models_retry))
        }
      }
    is RemoteModels.Loaded ->
      if (list.total == 0) {
        Note(stringResource(R.string.model_download_openrouter_models_empty))
      } else {
        ScottieSearchField(
          value = query,
          onValueChange = { onEvent(ModelDownloadAction.SearchRemoteModels(it)) },
          placeholder = stringResource(R.string.model_download_openrouter_models_search),
          clearLabel = stringResource(R.string.model_download_openrouter_models_search_clear),
          modifier = Modifier.testTag(OpenRouterCardTags.MODEL_SEARCH),
        )
        if (list.visible.isEmpty()) {
          Note(stringResource(R.string.model_download_openrouter_models_no_match, query.trim()))
        }
        Column(modifier = Modifier.testTag(OpenRouterCardTags.MODEL_LIST)) {
          list.visible.forEach { model ->
            RemoteModelRow(model, model.id in list.selected) {
              onEvent(ModelDownloadAction.ToggleRemoteModel(model.id))
            }
          }
        }
      }
  }
}

@Composable
private fun RemoteModelRow(model: AvailableModel, checked: Boolean, onToggle: () -> Unit) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier =
      Modifier.fillMaxWidth()
        .toggleable(value = checked, role = Role.Checkbox, onValueChange = { onToggle() })
        .padding(vertical = 4.dp)
        .testTag(OpenRouterCardTags.MODEL_ROW_PREFIX + model.id),
  ) {
    Checkbox(checked = checked, onCheckedChange = null)
    Column(modifier = Modifier.padding(start = 12.dp)) {
      Text(model.name, style = MaterialTheme.typography.bodyLarge)
      if (model.name != model.id) Note(model.id)
    }
  }
}

@Composable
private fun Note(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.bodyMedium,
    color = MaterialTheme.colorScheme.onSurfaceVariant,
  )
}

/** Confirms removing the saved key and selected models. */
@Composable
fun DeleteOpenRouterDialog(onEvent: (ModelDownloadAction) -> Unit) {
  AlertDialog(
    onDismissRequest = { onEvent(ModelDownloadAction.CancelDeleteOpenRouter) },
    title = { Text(stringResource(R.string.model_download_openrouter_delete_title)) },
    text = { Text(stringResource(R.string.model_download_openrouter_delete_text)) },
    confirmButton = {
      TextButton(onClick = { onEvent(ModelDownloadAction.ConfirmDeleteOpenRouter) }) {
        Text(stringResource(R.string.model_download_delete))
      }
    },
    dismissButton = {
      TextButton(onClick = { onEvent(ModelDownloadAction.CancelDeleteOpenRouter) }) {
        Text(stringResource(R.string.model_download_openrouter_cancel))
      }
    },
    modifier = Modifier.testTag(OpenRouterCardTags.DELETE_DIALOG),
    containerColor = MaterialTheme.colorScheme.surface,
  )
}

@Composable
private fun ApiKeyField(value: String, onValueChange: (String) -> Unit) {
  var visible by rememberSaveable { mutableStateOf(false) }
  SettingsField(
    value = value,
    onValueChange = onValueChange,
    label = R.string.model_download_openrouter_api_key,
    tag = OpenRouterCardTags.API_KEY,
    keyboardType = KeyboardType.Password,
    hint = R.string.model_download_openrouter_api_key_hint,
    visualTransformation =
      if (visible) VisualTransformation.None else PasswordVisualTransformation(),
    trailingIcon = {
      IconButton(onClick = { visible = !visible }) {
        Icon(
          imageVector = if (visible) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
          contentDescription =
            stringResource(
              if (visible) {
                R.string.model_download_openrouter_hide_key
              } else {
                R.string.model_download_openrouter_show_key
              }
            ),
        )
      }
    },
  )
}

/** [error] replaces [hint] under the field and marks it invalid. */
@Composable
private fun SettingsField(
  value: String,
  onValueChange: (String) -> Unit,
  label: Int,
  tag: String,
  keyboardType: KeyboardType = KeyboardType.Text,
  hint: Int? = null,
  error: Int? = null,
  visualTransformation: VisualTransformation = VisualTransformation.None,
  trailingIcon: (@Composable () -> Unit)? = null,
) {
  val supporting = error ?: hint
  OutlinedTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = Modifier.fillMaxWidth().testTag(tag),
    label = { Text(stringResource(label)) },
    supportingText = supporting?.let { { Text(stringResource(it)) } },
    isError = error != null,
    singleLine = true,
    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    visualTransformation = visualTransformation,
    trailingIcon = trailingIcon,
    shape = RoundedCornerShape(12.dp),
    colors =
      OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
      ),
  )
}

object OpenRouterCardTags {
  const val HEADER = "openrouter_header"
  const val BASE_URL = "openrouter_base_url"
  const val API_KEY = "openrouter_api_key"
  const val MODEL_SEARCH = "openrouter_model_search"
  const val MODEL_LIST = "openrouter_model_list"
  const val MODEL_ROW_PREFIX = "openrouter_model:"
  const val MODELS_LOADING = "openrouter_models_loading"
  const val MODELS_ERROR = "openrouter_models_error"
  const val MODELS_RETRY = "openrouter_models_retry"
  const val SAVED = "openrouter_saved"
  const val SAVE = "openrouter_save"
  const val DELETE = "openrouter_delete"
  const val DELETE_DIALOG = "openrouter_delete_dialog"
}

private val previewModels =
  listOf(
    AvailableModel("anthropic/claude-haiku-5.5", "Anthropic: Claude Haiku 5.5"),
    AvailableModel("openai/gpt-4o", "OpenAI: GPT-4o"),
    AvailableModel("qwen/qwen3-8b", "qwen/qwen3-8b"),
  )

private fun previewSection(
  list: RemoteModels = RemoteModels.Hidden,
  errors: Set<OpenRouterField> = emptySet(),
) =
  OpenRouterSection(
    baseUrl = OpenRouterConfig.DEFAULT_BASE_URL,
    apiKey = if (list != RemoteModels.Hidden) "sk-or-preview" else "",
    errors = errors,
    savedModelCount = (list as? RemoteModels.Loaded)?.selected?.size ?: 0,
    confirmingDelete = false,
    expanded = true,
    list = list,
    query = "",
  )

@Preview(name = "OpenRouter", widthDp = 358)
@Preview(name = "OpenRouter dark", widthDp = 358, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "OpenRouter large text", widthDp = 320, fontScale = 2f)
@Composable
private fun OpenRouterCardPreview() {
  ScottieTheme {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      OpenRouterCard(previewSection(), onEvent = {})
      OpenRouterCard(
        previewSection(
          RemoteModels.Loaded(previewModels, previewModels.size, setOf("openai/gpt-4o"))
        ),
        onEvent = {},
      )
    }
  }
}

@Preview(name = "OpenRouter states", widthDp = 358)
@Composable
private fun OpenRouterCardStatesPreview() {
  ScottieTheme {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      OpenRouterCard(previewSection(errors = setOf(OpenRouterField.BASE_URL)), onEvent = {})
      OpenRouterCard(previewSection(RemoteModels.Loading), onEvent = {})
      OpenRouterCard(previewSection(RemoteModels.Failed(FetchFailure.AUTH)), onEvent = {})
    }
  }
}
