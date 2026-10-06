# Contracts: Model Catalog Enhancements

Internal app contracts only; there is no external API. Signatures are indicative; follow
`.editorconfig` and existing naming.

## Repository (`feature/modeldownload/domain/repository/ModelDownloadRepository`)

Signature unchanged. Behavior additions:

- `catalog` `Ready.entries` now includes every catalog row (accepted or not); each carries
  `supported`.
- `download(modelId)` is a no-op when the entry is not `supported`.
- `delete(modelId)` works regardless of `supported`.

## Runtime seam (`feature/modeldownload/data/ai/provider/ModelRuntime`)

```kotlin
/** Device total RAM in bytes; null when unknown. */
suspend fun totalMemoryBytes(): Long?
```

## Circuit contract (`features/modeldownload/ModelDownloadScreen.kt`)

```kotlin
sealed interface ModelDownloadAction : CircuitUiEvent {
  // existing: Back, Download(id), Pause(id), Delete(id), DismissError
  data class Search(val query: String) : ModelDownloadAction
  data class ToggleCategory(val type: ModelType) : ModelDownloadAction
  data class ToggleGroup(val type: ModelType, val target: HardwareTarget) : ModelDownloadAction
}
```

`ModelDownloadContent.Models(sections, query)` per [data-model.md](../data-model.md).

## Shared UI components (`core/ui/components/`)

```kotlin
@Composable
fun ScottieSearchField(
  value: String,
  onValueChange: (String) -> Unit,
  placeholder: String,
  clearLabel: String,
  modifier: Modifier = Modifier,
)

@Composable
fun ScottieAccordionHeader(
  title: String,
  count: Int,
  expanded: Boolean,
  onToggle: () -> Unit,
  modifier: Modifier = Modifier,
  level: Int = 0, // 0 = category, 1 = subsection (indent + smaller type)
)

// ScottieToolbar gains: search: (@Composable () -> Unit)? = null, rendered under the title row.
```

Rules: theme colors/typography only; `Modifier` on root; header exposes expanded/collapsed state
and count to accessibility (`stateDescription`, plural resource); previews in light and dark.

## Screen component (`features/modeldownload/component/ModelDownloadCard.kt`)

`ModelDownloadUiItem` gains `description: String?`, `supported: Boolean`; renders the
Supported/Unsupported `XelaBadge` and hides description space when null. No reason text.

## New string resources

`model_download_search_placeholder`, `model_download_search_clear`,
`model_download_search_empty`, `model_target_cpu` ("CPU Models"), `model_target_npu`
("NPU Models"), `model_support_supported`, `model_support_unsupported`,
`model_section_expanded`, `model_section_collapsed`, plural `model_section_count`.
