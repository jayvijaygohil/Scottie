# Quickstart: CPU-Only Model Catalog

Run all commands from the repository root.

## 1. Removed code has no references left

```sh
grep -rnE 'LiteRtSpec|LiteRtBuild|forDevice|NPU_ELIGIBLE|socModel|chipOf|libedgetpu|model_allow_lists' app/src
```

Expected: no output.

## 2. Build, tests, and static analysis

```sh
./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug
```

Expected: all pass. `ModelCatalogTest` proves:
- ids are unique
- every URL is pinned
- no URL names a chip
- the gated set is unchanged

See [data-model.md](data-model.md) for the expected rows.

## 3. On a device (manual, optional)

1. Clear old model files on a development device that was NPU-eligible (Snapdragon 8 Elite or
   Tensor G5/G6): `adb shell run-as com.jayvijay.scottie rm -rf files/models/litert`.
2. Install the debug build and open the model catalog.
3. Expected: Gemma 4 E2B shows about 2.6 GB, the general build, not the 3.0 GB or more of an NPU
   variant.
4. Download Gemma 3 270M and open the Interac assistant with it. Expected: the model loads and
   answers.
