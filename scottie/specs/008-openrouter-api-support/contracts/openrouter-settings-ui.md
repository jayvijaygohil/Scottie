# UI Contract: OpenRouter section and chat changes

## Settings screen — OpenRouter section

Rendered as the last item of the model list (`ModelSections`), and alone under the message when the
catalog is `Unavailable`. Hidden while the catalog is `Loading`.

| Element | Behaviour | Test tag |
|---|---|---|
| Accordion header | Title `model_download_openrouter_title`; count label `model_section_count` plural with saved model count; toggles `ToggleOpenRouter`. | `openrouter_header` |
| Base URL field | Single line, `KeyboardType.Uri`, label `model_download_openrouter_base_url`; prefilled `https://openrouter.ai` when unsaved; error text `model_download_openrouter_error_base_url` when `BASE_URL in errors`. | `openrouter_base_url` |
| API Key field | Single line, masked by default (`PasswordVisualTransformation`), trailing icon toggles visibility with content descriptions `model_download_openrouter_show_key` / `model_download_openrouter_hide_key`; label `model_download_openrouter_api_key`; helper `model_download_openrouter_api_key_hint` (optional). | `openrouter_api_key` |
| Models field | Multi-line (max 4), label `model_download_openrouter_models`; placeholder `model_download_openrouter_models_hint` (shows the `a/b;c/d` example); error `model_download_openrouter_error_models` when `MODELS in errors`. | `openrouter_models` |
| Saved summary | Visible when `savedModelCount > 0`: `model_download_openrouter_saved` plural ("Saved · %d model(s)"). | `openrouter_saved` |
| Save button | `XelaButton` PRIMARY, text `model_download_openrouter_save`; dispatches `SaveOpenRouter`. Always enabled. | `openrouter_save` |
| Delete button | `XelaButton` SECONDARY, text `model_download_delete` (existing); visible only when `savedModelCount > 0`; dispatches `DeleteOpenRouter`. | `openrouter_delete` |
| Delete dialog | `AlertDialog` while `confirmingDelete`: title `model_download_openrouter_delete_title`, text `model_download_openrouter_delete_text`, confirm `model_download_delete`, dismiss `model_download_openrouter_cancel`. Dispatches `ConfirmDeleteOpenRouter` / `CancelDeleteOpenRouter`. | `openrouter_delete_dialog` |

Styling: fields use 12 dp corners, `surface` container, `outlineVariant` border, `primary` focus,
`error` for error state; card surface/radius/padding match `ModelDownloadCard`.

## Chat screen

| Element | Change |
|---|---|
| Model selector items | Remote options append a muted label `chat_model_remote` ("Remote") after the name. Active marking unchanged. |
| Model-side failure card | Text by `TurnReply.Failed.failure`: `OFFLINE` → `chat_reply_offline`; `UNAUTHORIZED` → `chat_reply_unauthorized`; `MODEL_UNAVAILABLE` → `chat_reply_model_unavailable`; `UNKNOWN` → `chat_reply_failed` (existing). |
| Empty state | Unchanged; appears only when `activeModelId == null`, which now requires no local and no remote model. |

## Strings (values/strings.xml)

```xml
<!-- OpenRouter settings -->
<string name="model_download_openrouter_title">OpenRouter</string>
<string name="model_download_openrouter_base_url">Base URL</string>
<string name="model_download_openrouter_api_key">API key</string>
<string name="model_download_openrouter_api_key_hint">Optional. Stored only on this device.</string>
<string name="model_download_openrouter_show_key">Show API key</string>
<string name="model_download_openrouter_hide_key">Hide API key</string>
<string name="model_download_openrouter_models">Models</string>
<string name="model_download_openrouter_models_hint">anthropic/claude-3.5-sonnet;openai/gpt-4o</string>
<string name="model_download_openrouter_error_base_url">Enter a full web address starting with http:// or https://</string>
<string name="model_download_openrouter_error_models">Enter at least one model id, separated by semicolons</string>
<string name="model_download_openrouter_save">Save</string>
<string name="model_download_openrouter_cancel">Cancel</string>
<string name="model_download_openrouter_delete_title">Remove OpenRouter settings?</string>
<string name="model_download_openrouter_delete_text">The API key and model list will be deleted from this device.</string>
<plurals name="model_download_openrouter_saved">
    <item quantity="one">Saved · %1$d model</item>
    <item quantity="other">Saved · %1$d models</item>
</plurals>

<!-- Chat -->
<string name="chat_model_remote">Remote</string>
<string name="chat_reply_offline">No connection. Check your network and try again.</string>
<string name="chat_reply_unauthorized">OpenRouter rejected the API key. Update it in Model settings.</string>
<string name="chat_reply_model_unavailable">That model isn\'t available on OpenRouter. Check the model id in Model settings.</string>
```

## Identifiers

Test tags above live in `OpenRouterCard` as `const val` members of a `OpenRouterCardTags` object.
Log tag for the config repository: `"OpenRouterConfig"`; it never logs field values.
