package com.jayvijay.scottie.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.presentation.ui.ScottieTheme

/** Single-line search input; the caller owns [value]. */
@Composable
fun ScottieSearchField(
  value: String,
  onValueChange: (String) -> Unit,
  placeholder: String,
  clearLabel: String,
  modifier: Modifier = Modifier,
) {
  val keyboard = LocalSoftwareKeyboardController.current
  val shape = RoundedCornerShape(12.dp)
  val textStyle =
    MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface)

  Surface(
    modifier =
      modifier.fillMaxWidth().border(1.dp, MaterialTheme.colorScheme.outlineVariant, shape),
    shape = shape,
    color = MaterialTheme.colorScheme.surface,
  ) {
    BasicTextField(
      value = value,
      onValueChange = onValueChange,
      singleLine = true,
      textStyle = textStyle,
      cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
      keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
      keyboardActions = KeyboardActions(onSearch = { keyboard?.hide() }),
      decorationBox = { field ->
        Row(
          modifier = Modifier.heightIn(min = 48.dp).padding(start = 12.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
          Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
          )
          Box(modifier = Modifier.weight(1f)) {
            if (value.isEmpty()) {
              Text(
                text = placeholder,
                style = textStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
            field()
          }
          if (value.isNotEmpty()) {
            IconButton(onClick = { onValueChange("") }) {
              Icon(
                painter = painterResource(R.drawable.ic_close),
                contentDescription = clearLabel,
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
          } else {
            Box(modifier = Modifier.size(12.dp))
          }
        }
      },
    )
  }
}

@Preview(name = "Search field")
@Preview(name = "Search field dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScottieSearchFieldPreview() {
  ScottieTheme {
    ScottieSearchField(value = "", onValueChange = {}, placeholder = "Search", clearLabel = "Clear")
  }
}

@Preview(name = "Search field with text")
@Composable
private fun ScottieSearchFieldFilledPreview() {
  ScottieTheme {
    ScottieSearchField(
      value = "qwen",
      onValueChange = {},
      placeholder = "Search",
      clearLabel = "Clear",
    )
  }
}
