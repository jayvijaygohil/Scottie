# Data Model: CPU-Only Model Catalog

## LiteRtModel (existing, unchanged shape)

| Field | Type | Rule |
|---|---|---|
| `id` | String | The general build's file name. Unique and ends in `.litertlm`. It is also the on-disk name and the Koog `LLModel.id`. |
| `name` | String | Display name |
| `url` | String | A pinned `litert-community` URL at a 40-hex commit. It must not name a chip. |
| `downloadBytes` | Long | The general build's `lfs.size` |
| `memoryBytes` | Long | `downloadBytes * 13 / 10` (existing heuristic) |
| `requiresToken` | Boolean | True only for the gated Gemma 3 1B, Gemma 3 270M, and FunctionGemma 270M |

## Removed

- `LiteRtSpec` (`name`, `fileName`, `requiresToken`, `general`, `npu`, `resolve(soc)`)
- `LiteRtBuild` (`url`, `sizeBytes`, `memoryBytes`)
- `NPU_ELIGIBLE` and the chip and board name mapping

## Unchanged

`ArchiveModel`, `MultiFileModel`, `ModelFile`, `CatalogModel.toModel()`, and the domain
`Model`.

## Catalog contents (text rows, in order)

| Name | id | Download bytes | Token |
|---|---|---|---|
| Gemma 4 E2B | `gemma-4-E2B-it.litertlm` | 2,588,147,712 | no |
| Gemma 4 E4B | `gemma-4-E4B-it.litertlm` | 3,659,530,240 | no |
| Gemma 4 12B | `gemma-4-12B-it.litertlm` | 6,883,278,368 | no |
| Qwen3 0.6B | `Qwen3-0.6B.litertlm` | 614,236,160 | no |
| Qwen3.5 2B | `Qwen3.5-2B_int8.litertlm` | 2,116,592,816 | no |
| DeepSeek R1 Distill Qwen 1.5B | `DeepSeek-R1-Distill-Qwen-1.5B_multi-prefill-seq_q8_ekv4096.litertlm` | 1,833,451,520 | no |
| MiniCPM5 2B | `MiniCPM5-2B_int4.litertlm` | 1,553,670,064 | no |
| Gemma 3 1B | `gemma3-1b-it-int4.litertlm` | 584,417,280 | yes |
| Gemma 3 270M | `gemma3-270m-it-q8.litertlm` | 304,005,120 | yes |
| FunctionGemma 270M | `mobile_actions_q8_ekv1024.litertlm` | 288,964,608 | yes |

The speech-to-text rows that follow are unchanged.
