# RunAnywhere compatibility gating (reference)

Source: `RunanywhereAI/runanywhere-sdks` at commit `a18d1d36a3f2b1935e4de83194d0e83dfe669a2c`. This
file records what the SDK checks and how Scottie 003 replicates it. Scottie stops using RunAnywhere
for text models (LiteRT) and drops QHexRT, so these gates must live in the app.

## 1. Memory and storage (`model_compatibility.cpp`)

```cpp
int64_t required_memory  = model->memory_required;  // ModelInfo.memory_required_bytes
int64_t required_storage = model->download_size;    // ModelInfo.download_size_bytes

can_run = (required_memory  <= 0 || available_ram     <= 0 || available_ram     >= required_memory);
can_fit = (required_storage <= 0 || available_storage <= 0 || available_storage >= required_storage);
is_compatible = can_run && can_fit;
```

- A value of 0 or less means unknown on either side. Unknown passes; it never blocks.
- There is no headroom or multiplier, only a direct `>=` comparison.
- Reason strings come from `model_compatibility_proto.cpp`: `"insufficient RAM: requires %lld bytes,
  %lld available"` and `"insufficient storage: requires %lld bytes, %lld available"`.

## 2. Device probes (`PhysicalMemoryProbe.kt`, `RunAnywhereModelCompatibility.kt`)

- **Available RAM**, used by the check: `ActivityManager.MemoryInfo.availMem`, then `/proc/meminfo
  MemAvailable` (kB × 1024), else `0` (unknown).
- **Total RAM**, used for display only: `totalMem`, then `MemTotal`, then `Runtime.maxMemory()`.
- **Available storage**: the free space on the SDK's model storage volume.
- **Download preflight** checks `can_run` and `can_fit`.
- **Load preflight** checks only `can_run`: "an already-downloaded model should not become
  unloadable merely because disk space later fell". On `INSUFFICIENT_MEMORY` it unloads every model,
  probes RAM again, and retries once. Unregistered models skip the preflight.
- **User-facing messages**:
  - "needs at least X GiB of available memory; Y is available. Unload the current model, close
    other apps, or use a device with more RAM."
  - "needs X GiB of free storage; Y is available. Free storage or choose a smaller model."

## 3. NPU gate (`qhexrt_device_capability.cpp`, `qhexrt_model_catalog.cpp`, `QHexRT.kt`)

- **SoC detection**: read `ro.soc.model` (uppercased). If that fails, read `ro.board.platform`.
- **SoC → Hexagon generation**:

  | SoC | Gen | | Board platform | Gen |
  |---|---|---|---|---|
  | SM8850 | V81 | | SUN | V79 |
  | SM8750 | V79 | | PINEAPPLE | V75 |
  | SM8650 | V75 | | KALAMA | V73 |
  | SM8550, SM7675, SM7635 | V73 | | | |
  | SM8475, SM8450 | V69 | | | |

- **Supported generations**: only **V75, V79, and V81**. Every other generation, and any unknown
  chip, has no NPU.
- **Per-model policy**: each model has a bitmask of allowed generations. If the device's generation
  is not in it, the row is silently not registered (hidden).
- **HF token gate**: when `requires_hf_auth` is set and no token is configured, the row is not
  registered (hidden).
- **URL pinning**: Hugging Face refs are pinned to a commit or to an architecture folder.

## 4. Scottie 003 replication

| Upstream gate | Scottie 003 behavior | Difference |
|---|---|---|
| `can_run` | Available RAM (availMem → MemAvailable → unknown) ≥ the resolved build's memory need | Replaces 002's **total** RAM rule |
| `can_fit` | Free space on the model storage volume ≥ the resolved build's download size | New; 002 had no storage gate before download |
| `is_compatible` | Supported = `can_run && can_fit`; unknown on either side passes | Same |
| Download preflight | Re-checked when Download, Resume, or Retry is pressed; a refused start shows the required and available amounts | Catalog badges still show no reason text (002) |
| Load preflight, unload-and-retry | Not replicated | Model loading is out of scope |
| SoC detection | `Build.SOC_MODEL` on API 31+, otherwise the board platform | Same sources |
| Supported Hexagon generations | NPU build only on SM8650, SM8750, SM8850 (or PINEAPPLE, SUN); SM8550 gets the general build | LiteRT publishes SM8550 builds; upstream policy excludes V73 |
| Google Tensor | NPU build on Tensor G5 and G6 when the model has one | No upstream equivalent |
| Per-model policy | A model offers NPU builds only for the chips it lists | Same idea, keyed by chip |
| HF token gate | Listed with Download disabled (FR-012) | Upstream hides these rows |
| URL pinning | Every model URL pinned to a commit | Same |
