# Research: CPU-Only Model Catalog

There were no NEEDS CLARIFICATION items. Each decision below comes from reading the source.

## 1. Catalog row shape

- **Decision**: Replace `LiteRtSpec(general, npu)` + `resolve(soc)` with direct `LiteRtModel`
  entries. A private `hf(...)` helper builds the URL, size, and memory estimate and returns a
  `LiteRtModel`. The id is the file name.
- **Rationale**: Every spec's `fileName` already equals its general build's file name, and
  every spec has a general build, so `resolve` always reduces to the general build.
  `LiteRtModel` already carries every field the runtime needs.
- **Alternatives considered**: Keep `LiteRtSpec` with only `general`. Rejected because it is a
  wrapper with nothing to resolve.

## 2. Catalog entry point

- **Decision**: `StaticModelCatalog.forDevice(soc)` becomes `val models: List<CatalogModel>`.
  `DataModule.provideModelCatalog()` returns it.
- **Rationale**: With no chip input, the catalog is constant.
- **Alternatives considered**: `forDevice()` with no arguments. Rejected because the name
  implies a dependency on the device.

## 3. Chip detection

- **Decision**: Delete `DeviceChip.kt` (`NPU_ELIGIBLE`, `normalizeSoc`, `boardSoc`, `chipOf`,
  `socModel`) and `DeviceChipTest.kt`.
- **Rationale**: Its only caller is `DataModule` (verified with a reference search).

## 4. Edge TPU native library declaration

- **Decision**: Remove `<uses-native-library android:name="libedgetpu_litert.so">` and its
  comment from `AndroidManifest.xml`.
- **Rationale**: The library exists only for Tensor NPU dispatch, and the runtime is CPU-only.

## 5. `model_allow_lists.json`

- **Decision**: Delete it.
- **Rationale**: Nothing in the source, the build, or the tests references it, and its
  `socToModelFiles` data is chip-specific.

## 6. Leftover CPU-backend comment

- **Decision**: Keep the `ponytail:` comment in `OnDeviceTextModels.kt` that names
  `GPU()/NPU(nativeLibraryDir)` as the levers.
- **Rationale**: It documents an unused runtime option, not catalog behavior. Edit it only if a
  reviewer objects.

## 7. Tests

- **Decision**: In `ModelCatalogTest`:
  - Drop the chip-resolution tests: `gemma4E2bResolvesToTheChipBuild`,
    `gemma3ResolvesPerQualcommChip`, and `npuBuildsOnlyForEligibleChips`.
  - Drop the NPU half of `buildSizesAndMemoryFollowTheResolvedBuild`.
  - Replace `SOCS` loops with the single list.
  - Keep the invariants: ids are unique, ids end in `.litertlm`, URLs are pinned, gated repos
    are exactly the expected set, titles are clean, and descriptions are right.
  - Add one assertion that no URL names a chip (`qualcomm|sm\d{4}|Tensor_G`).
- **Rationale**: FR-008 requires removing the chip checks. The new assertion fails if an NPU
  build is ever re-added.
