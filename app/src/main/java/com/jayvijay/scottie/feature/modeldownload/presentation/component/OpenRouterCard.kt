package com.jayvijay.scottie.feature.modeldownload.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterConfig
import com.jayvijay.scottie.feature.modeldownload.domain.entities.OpenRouterField
import com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadAction
import com.jayvijay.scottie.feature.modeldownload.presentation.OpenRouterSection

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
      SettingsField(
        value = section.modelsText,
        onValueChange = { onEvent(ModelDownloadAction.EditOpenRouterModels(it)) },
        label = R.string.model_download_openrouter_models,
        tag = OpenRouterCardTags.MODELS,
        singleLine = false,
        placeholder = R.string.model_download_openrouter_models_hint,
        error =
          R.string.model_download_openrouter_error_models.takeIf {
            OpenRouterField.MODELS in section.errors
          },
      )
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
        if (section.savedModelCount > 0) {
          ModelDownloadButton(
            text = stringResource(R.string.model_download_delete),
            onClick = { onEvent(ModelDownloadAction.DeleteOpenRouter) },
            modifier = Modifier.testTag(OpenRouterCardTags.DELETE),
          )
        }
      }
    }
  }
}

/** Confirms removing the saved key and model list. */
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
  singleLine: Boolean = true,
  keyboardType: KeyboardType = KeyboardType.Text,
  placeholder: Int? = null,
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
    placeholder = placeholder?.let { { Text(stringResource(it)) } },
    supportingText = supporting?.let { { Text(stringResource(it)) } },
    isError = error != null,
    singleLine = singleLine,
    maxLines = if (singleLine) 1 else MODELS_MAX_LINES,
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

private const val MODELS_MAX_LINES = 4

object OpenRouterCardTags {
  const val HEADER = "openrouter_header"
  const val BASE_URL = "openrouter_base_url"
  const val API_KEY = "openrouter_api_key"
  const val MODELS = "openrouter_models"
  const val SAVED = "openrouter_saved"
  const val SAVE = "openrouter_save"
  const val DELETE = "openrouter_delete"
  const val DELETE_DIALOG = "openrouter_delete_dialog"
}

private fun previewSection(
  savedModelCount: Int = 0,
  errors: Set<OpenRouterField> = emptySet(),
) =
  OpenRouterSection(
    baseUrl = OpenRouterConfig.DEFAULT_BASE_URL,
    apiKey = if (savedModelCount > 0) "sk-or-preview" else "",
    modelsText = if (savedModelCount > 0) "openai/gpt-4o;anthropic/claude-3.5-sonnet" else "",
    errors = errors,
    savedModelCount = savedModelCount,
    confirmingDelete = false,
    expanded = true,
  )

@Preview(name = "OpenRouter", widthDp = 358)
@Preview(name = "OpenRouter dark", widthDp = 358, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "OpenRouter large text", widthDp = 320, fontScale = 2f)
@Composable
private fun OpenRouterCardPreview() {
  ScottieTheme {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      OpenRouterCard(previewSection(), onEvent = {})
      OpenRouterCard(previewSection(savedModelCount = 2), onEvent = {})
    }
  }
}

@Preview(name = "OpenRouter errors", widthDp = 358)
@Composable
private fun OpenRouterCardErrorsPreview() {
  ScottieTheme {
    OpenRouterCard(
      previewSection(errors = setOf(OpenRouterField.BASE_URL, OpenRouterField.MODELS)),
      onEvent = {},
    )
  }
}
