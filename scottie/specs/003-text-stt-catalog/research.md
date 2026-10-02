# Research: Text and Speech-to-Text Catalog

Gating rules mirror the RunAnywhere SDK; see [references/runanywhere-gating.md](references/runanywhere-gating.md).

## R1. Text model format and source

- **Decision**: LiteRT-LM `.litertlm` files from `litert-community` Hugging Face repos, each URL
  pinned to a commit.
- **Token-gated repos**: `Gemma3-1B-IT`, `functiongemma-270m-ft-mobile-actions`, and
  `gemma-3-270m-it` are gated (`auto`). Per FR-012 they are listed with `requiresToken = true` and
  are never requested.
- **Rows** (verify sizes and commit hashes at implementation). Only eligible chips appear as NPU
  keys (R2); published builds for other chips, including SM8550 and MediaTek, are not listed.

  | Row | General build | NPU builds |
  |---|---|---|
  | Gemma 4 E2B | `gemma-4-E2B-it.litertlm` | `SM8750` → `_qualcomm_sm8750`; `TENSOR_G5`/`TENSOR_G6` → `_Google_Tensor_G<n>` |
  | Gemma 4 E4B | `gemma-4-E4B-it.litertlm` | none |
  | Gemma 4 12B | `gemma-4-12B-it.litertlm` | none |
  | Qwen3 0.6B | `Qwen3-0.6B.litertlm` | none |
  | Qwen3.5 2B | `Qwen3.5-2B_int8.litertlm` | none |
  | DeepSeek R1 Distill Qwen 1.5B | `DeepSeek-R1-Distill-Qwen-1.5B_multi-prefill-seq_q8_ekv4096.litertlm` | none |
  | MiniCPM5 2B | `MiniCPM5-2B_int4.litertlm` | none |
  | Gemma 3 1B *(token)* | `gemma3-1b-it-int4.litertlm` | `SM8650`/`SM8750`/`SM8850` → `Gemma3-1B-IT_q4_ekv1280_<sm>.litertlm`; `TENSOR_G5`/`TENSOR_G6` → `Gemma3-1B-IT_q8_ekv1280_Google_Tensor_G<n>.litertlm` |
  | Gemma 3 270M *(token)* | `gemma3-270m-it-q8.litertlm` | `SM8650`/`SM8750`/`SM8850` → `gemma3-270m-it-q8.qualcomm.<sm>.litertlm` |
  | FunctionGemma 270M *(token)* | `mobile_actions_q8_ekv1024.litertlm` (Koog `LiteRTLLModels.FunctionGemma`) | `TENSOR_G5`/`TENSOR_G6` → `functiongemma-270m-ft-mobile-actions_Google_Tensor_G<n>.litertlm` |

- **Memory need**: about 1.3 × the build's file size. ponytail: a heuristic, because LiteRT
  publishes no RAM figures; replace it with measured values when available.
- **Alternatives**: llama.cpp GGUF was rejected because it is not the format the app will run.
  Hiding gated repos was rejected by FR-012.

## R2. Chip identity and NPU eligibility (FR-015, FR-016)

- **Decision**: `socModel()` returns the first non-blank value of:
  1. `normalize(Build.SOC_MODEL)` on API 31+. Normalizing trims, uppercases, and turns spaces and
     hyphens into `_`, so `"Tensor G5"` becomes `TENSOR_G5`.
  2. `BOARD_PLATFORMS[Build.BOARD.uppercase()]`, where `SUN → SM8750` and `PINEAPPLE → SM8650`.
  3. Otherwise null.

  `NPU_ELIGIBLE = {SM8650, SM8750, SM8850, TENSOR_G5, TENSOR_G6}`. A spec resolves to
  `npu[soc]` only when `soc in NPU_ELIGIBLE`; otherwise it uses the general build.
- **Rationale**: This mirrors `qhexrt_device_capability.cpp`, which reads `ro.soc.model` and falls
  back to `ro.board.platform`, and supports only v75, v79, and v81 (SM8650, SM8750, SM8850). Tensor
  G5 and G6 have no upstream equivalent; they are allowed because Google publishes LiteRT builds for
  them. `Build.BOARD` is public API and equals the platform name on Qualcomm reference builds. ponytail:
  `ro.board.platform` itself needs hidden `SystemProperties`; switch to it if a device reports a
  vendor board name. The fallback is rarely reached, because SM8650 and later ship on API 34+.
- **Alternatives**: Exact matching on any published chip (the earlier plan). Rejected because the
  spec excludes SM8550. Reading `SystemProperties` through reflection was rejected because it is a
  hidden API that lint flags.

## R3. Text file download

- **Decision**: `LiteRtModelRuntime` streams with `HttpURLConnection` into `<fileName>.part`,
  resumes with `Range: bytes=<partLength>-`, and restarts from 0 when the server replies 200. It
  checks the size, then renames the file to `<filesDir>/models/litert/<fileName>`. Cancellation
  keeps the `.part` file.
- **Rationale**: RunAnywhere cannot write to the Koog path (`modelsPath + "/" + LLModel.id`), and
  `DownloadManager` cannot target `filesDir`. The JDK client is enough, so no new dependency is
  needed.
- **Integrity and errors**:
  - A wrong size gives `CORRUPTED`; an ENOSPC write gives `STORAGE`; other I/O gives `NETWORK`.
  - The pre-start storage check moved to the repository preflight (R5), so the runtime no longer
    probes free space.
  - ponytail: no SHA-256 over multi-GB files; add it if a corrupt file is reported.

## R4. Routing between runtimes

- **Decision**: `RoutingModelRuntime : ModelRuntime` splits `prepare(rows)` by
  `row is LiteRtModel`, unions the accepted and downloaded ids, and routes `download` and `delete`
  by the id sets it recorded.
- **Rationale**: The repository keeps one seam and its existing invariants.

## R5. Compatibility rule and preflight (FR-013, FR-014)

- **Decision**: `checkCompatibility(memoryNeed, downloadBytes, availableMemory, availableStorage)`
  is a pure domain function copied from `model_compatibility.cpp`:
  - `canRun = need ≤ 0 or available ≤ 0 or available ≥ need`
  - `canFit` follows the same pattern, using `downloadBytes` against free storage.
  - Unknown values are `null` or ≤ 0, and they pass.

  The result is `Compatible` or `Shortfall(kind, required, available)`. Memory is reported before
  storage, matching the order of upstream reasons.
- **Where it runs**:
  - **Catalog load**: the repository sets `ModelEntry.supported = verdict is Compatible`.
  - **Download, Resume, or Retry**: `download()` probes again before starting. It returns
    `Refused(shortfall)` without changing the status. Storage is checked against the full download
    size, not the remaining bytes, as upstream does.
- **Probes** (`DeviceResources`, an interface faked in tests):
  - **Memory**: `ActivityManager.MemoryInfo.availMem`, then `/proc/meminfo MemAvailable` × 1024,
    else null. This copies `PhysicalMemoryProbe.availablePhysicalMemoryBytes`.
  - **Storage**: `StatFs(context.filesDir).availableBytes`. LiteRT and RunAnywhere both store
    models on internal storage.
- **Rationale**: The rule is policy, so it lives in the domain as a function without Android
  imports. The probes are infrastructure, so they live in `data/ai/provider`.
  `ModelRuntime.totalMemoryBytes` is removed because total RAM no longer gates anything.
- **Alternatives**:
  - Keeping total RAM (002) was rejected; FR-013 supersedes it.
  - A use case was rejected because only one repository is involved (constitution I).

## R6. Shortfall message (FR-014)

- **Decision**: The presenter maps `Refused(shortfall)` to the existing bottom `XelaToast`. The
  single `deleteFailedModelName` becomes `error: ModelDownloadError?`, which is either
  `DeleteFailed(name)` or `Shortfall(kind, required, available)`.
- **Strings**: two format strings in `strings.xml`, filled with
  `Formatter.formatShortFileSize`, as the card already formats sizes:
  - "Needs at least %1$s of available memory; %2$s is available. Close other apps or choose a
    smaller model."
  - "Needs %1$s of free storage; %2$s is available. Free up storage or choose a smaller model."
- **Rationale**: Reuses the one error surface on the screen; no new component.

## R7. Variant visibility

- `StaticModelCatalog.forDevice(soc)` turns each spec into its resolved build, or drops the spec
  when no build fits.
- The repository lists only rows the runtime accepts.
- `supported` now reflects only the R5 verdict.

## R8. Removed scope

- The `runanywhere-llamacpp` and `runanywhere-qhexrt-android` libraries, along with their rows.
- All other model types, `HardwareTarget`, CPU/NPU groups, and `ToggleGroup`.
- Searching by hardware target.
- `ModelRuntime.totalMemoryBytes`.
- Load-time preflight and unload-and-retry, because nothing loads models in this feature.

## Risks

- NPU builds need the LiteRT-LM NPU runtime and vendor libraries at inference time. The future
  runner must reuse `socModel()` and `NPU_ELIGIBLE`.
- Available memory moves between sessions, so a badge can flip. The spec accepts this.
- Hugging Face file changes. Pinned commits mitigate this.
