# Material catalog and standard components

## Factory setup

`materialA2uiBasicCatalogV1` is in `androidx.compose.material3.a2ui.catalog`. It returns `androidx.a2ui.compose.ui.A2uiCatalog`. **Six parameters have no defaults:** image, video, audioPlayer, urlOpener, messageFormatter, localeProvider.

```kotlin
import androidx.a2ui.compose.ui.A2uiCatalog
import androidx.a2ui.model.catalog.functions.A2uiLocaleProvider
import androidx.a2ui.model.catalog.functions.A2uiMessageFormatter
import androidx.a2ui.model.catalog.functions.A2uiUrlOpener
import androidx.compose.material3.a2ui.catalog.A2uiAudioPlayerRenderer
import androidx.compose.material3.a2ui.catalog.A2uiImageRenderer
import androidx.compose.material3.a2ui.catalog.A2uiVideoRenderer
import androidx.compose.material3.a2ui.catalog.MaterialA2uiBasicCatalogV1Defaults
import androidx.compose.material3.a2ui.catalog.materialA2uiBasicCatalogV1

fun buildBasicCatalog(
    images: A2uiImageRenderer,
    videos: A2uiVideoRenderer,
    audio: A2uiAudioPlayerRenderer,
    urls: A2uiUrlOpener,
    formatter: A2uiMessageFormatter,
): A2uiCatalog = materialA2uiBasicCatalogV1(
    image = MaterialA2uiBasicCatalogV1Defaults.image(images),
    video = MaterialA2uiBasicCatalogV1Defaults.video(videos),
    audioPlayer = MaterialA2uiBasicCatalogV1Defaults.audioPlayer(audio),
    urlOpener = urls,
    messageFormatter = formatter,
    localeProvider = A2uiLocaleProvider.Default,
)
```

Supply real adapters using the app's existing media stack. Renderer contracts are composable fun interfaces:

| Interface method | Parameters |
| --- | --- |
| `A2uiImageRenderer.Image` | `url: String`, `contentDescription: String?`, `contentScale: ContentScale`, `modifier: Modifier`, `onError: (Throwable?) -> Unit` |
| `A2uiVideoRenderer.Video` | `url: String`, `modifier: Modifier`, `onError: (Throwable?) -> Unit` |
| `A2uiAudioPlayerRenderer.AudioPlayer` | `url: String`, `contentDescription: String?`, `modifier: Modifier`, `onError: (Throwable?) -> Unit` |

Honor supplied modifiers, accessibility, image scale, and failure callbacks. Dispose media resources with the app's lifecycle. Do not advertise functioning media while providing silent no-op adapters.

`A2uiUrlOpener.openUrl(url: String)` supplies URL handling; route it through the app's URL policy and main-thread navigation when needed. `A2uiMessageFormatter.format(pattern: String, locale: Locale, arguments: Map<String, Any>): String` must support ICU plural patterns; Java `MessageFormat` is not an equivalent plural formatter. On compatible Android SDKs, an adapter can use `android.icu.text.MessageFormat(pattern, locale).format(arguments)`. `A2uiLocaleProvider.Default` reads `Locale.getDefault()`.

The other factory parameters default to Material implementations: `text`, `icon`, `row`, `column`, `list`, `card`, `tabs`, `modal`, `divider`, `button`, `textField`, `checkBox`, `choicePicker`, `slider`, `dateTimeInput`. Override one with the corresponding `A2uiBasicCatalogV1` interface while preserving its contract, or define a custom catalog for changed contracts.

## Common payload choices

`D` means dynamic literal/path/function value. `S` means static. All basic components also declare optional `accessibility` (dynamic object with `label`/`description`) and numeric `weight`; weight is interpreted by supporting parent layouts.

| Component | Required fields | Useful optional fields / behavior |
| --- | --- | --- |
| `Text` | `text` D string | `variant` S: `h1`–`h5`, `caption`, `body` (default) |
| `Image` | `url` D string | `description` D; `fit` S defaults to `fill`; `variant` S defaults to `mediumFeature`; renderer required |
| `Icon` | `name` D | Built-in name or supported SVG-path source; unknown names are not arbitrary Android resources |
| `Video` | `url` D string | Renderer required |
| `AudioPlayer` | `url` D string | `description` D; renderer required |
| `Card` | `child` S component ID | Render the referenced child |
| `Row` | `children` child list | `justify` defaults to `start`; `align` to `start` |
| `Column` | `children` child list | `justify` defaults to `start`; `align` to `stretch` |
| `List` | `children` child list | `direction` defaults to `vertical`; `align` to `stretch` |
| `Tabs` | `tabs` S nonempty list of `{title: D string, child: S ID}` | Not a plain `children` array |
| `Modal` | `trigger`, `content` S IDs | Trigger/content references are distinct |
| `Divider` | None | `axis` S: `horizontal` (default), `vertical` |
| `Button` | `child` S ID, `action` S action object | `variant`: `default`, `primary`, `borderless`; label is a child component |
| `TextField` | `label` D string | `value` D string, `validationRegexp` S, `variant`: `shortText` (default), `longText`, `number`, `obscured` |
| `CheckBox` | `label` D string, `value` D Boolean | Writable path required for editing |
| `Slider` | `max` S number, `value` D number | `min` S defaults to 0; `label` D string |
| `ChoicePicker` | `options` D list of `{label,value}`, `value` D string list | `label`, `variant`, `displayStyle`, `filterable`; even single selection uses a list |
| `DateTimeInput` | `value` D ISO 8601 string (empty string for unset) | `enableDate`/`enableTime` S default false; `min`/`max` D ISO strings; `label` D |

Use exported catalog schemas for less-common enum values or constraints. This table is a component-selection aid, not a substitute for full schema export. Do not add fields from another A2UI protocol revision by analogy.

Basic input `Content` implementations derive their update callbacks from `bindUpdater(ValueProperty)`. Literal values and computed values have no updater: controls such as TextField, Slider, CheckBox, and ChoicePicker become disabled. Initialize path data for controls whose value is required; DateTimeInput uses `""` when unset.

The catalog declares a theme schema, but schema acceptance alone does not establish that every property alters `MaterialTheme`. Retain the app's theme and verify any requested server-theme effect against the renderer's behavior.

The factory assembles basic functions using `createBasicCatalogFunctions` from `androidx.a2ui.model.catalog.basiccatalog`. Functions include validation, boolean logic, formatting, pluralization, and URL opening. Function argument contracts come from the exported schema; do not infer arguments from function names.
