# Prompt for `/speckit-specify` (updates 003)

Paste everything below the line after `/speckit-specify`.

---

Update the existing 003-text-stt-catalog spec, without creating a new feature, so that its
compatibility gating matches the RunAnywhere SDK's checks. Those checks are recorded in
`specs/003-text-stt-catalog/references/runanywhere-gating.md`.

Compatibility (supersedes the total-RAM rule from 002):
- A model is Supported only when both of these hold:
  1. The device's currently available memory is at least the memory need of the build that would
     be downloaded.
  2. The free space on the device's model storage is at least that build's download size.
- When the device cannot report a value, or the model has none, that check passes and never blocks.
- No headroom is added; the comparison is "available ≥ required".
- Available memory is read from what the system reports as currently available, not total memory.
  Badges may therefore change between sessions; this is accepted.

Download preflight:
- Compatibility is evaluated when the catalog loads and again when the user presses Download,
  Resume, or Retry.
- If the start-time check fails, the download does not start. The user sees a message that names
  the shortfall and the amounts involved, for example "Needs at least 3.2 GB of available memory;
  2.1 GB is available. Close other apps or choose a smaller model." or "Needs 2.6 GB of free
  storage; 1.4 GB is available. Free up storage or choose a smaller model."
- Catalog badges still show only Supported or Unsupported, with no reason text.

NPU build eligibility:
- A Qualcomm device gets a model's NPU build only when its chip is Snapdragon 8 Gen 3 (SM8650),
  8 Elite (SM8750), or 8 Elite Gen 5 (SM8850). These are the Hexagon generations the RunAnywhere
  NPU runtime supports.
- Older Snapdragon chips, including SM8550, get the general build even where an NPU build is
  published.
- A Google Tensor G5 or G6 device gets the NPU build for that chip when the model has one.
- On devices that cannot report the chip model directly, the chip is identified from the board
  platform name: "sun" maps to SM8750 and "pineapple" to SM8650.
- Unknown chips get the general build.

Unchanged:
- Token-requiring models stay listed with Download disabled.
- Every model download URL is pinned to a fixed revision.

Out of scope:
- Load-time compatibility checks, and unloading models to free memory before loading. Nothing loads
  models in this feature.

Success criteria to add:
- 0 downloads start when available memory or free storage is below the build's requirement.
- On SM8550 the general build is fetched.
- On SM8650, SM8750, and SM8850 the chip's NPU build is fetched when one exists.
