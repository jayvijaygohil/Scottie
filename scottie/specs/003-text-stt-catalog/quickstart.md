# Quickstart: Text and Speech-to-Text Catalog

## Automated

```sh
./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug
```

All of the following run on the JVM:

- **`ModelCompatibilityTest`**: every row of the table in
  [contracts](contracts/model-runtime-contracts.md#checkcompatibility-domain-pure).
- **`DeviceChipTest`**:
  - `normalizeSoc` turns `"Tensor G5"` into `TENSOR_G5`, and blank or `"unknown"` into null.
  - Board `"sun"` maps to `SM8750` and `"pineapple"` to `SM8650`; `"kalama"` maps to null.
- **`ModelCatalogTest`**:
  - Only TEXT and SPEECH_RECOGNITION rows appear (SC-001).
  - Gemma 4 E2B fetches its SM8750 NPU build on `"SM8750"` and its Tensor build on `"TENSOR_G5"`.
    It fetches the general build on `null`, `"SM8550"`, and `"TENSOR_G4"` (SC-002, SC-007).
  - Gemma 3 1B fetches its own NPU build on `"SM8650"` and `"SM8850"`.
  - No NPU key falls outside `NPU_ELIGIBLE`.
  - Gemma 3 1B, Gemma 3 270M, and FunctionGemma have `requiresToken`.
- **`LiteRtModelRuntimeTest`** covers:
  - a fresh download;
  - Range resume;
  - a server that ignores Range;
  - a size mismatch;
  - a write failing with ENOSPC;
  - an HTTP 404;
  - cancelling, which keeps `.part`;
  - deleting.
- **`RoutingModelRuntimeTest`**: each call reaches the right runtime.
- **`ModelDownloadRepositoryImplTest`**:
  - Rejected rows are not listed, and `supported` follows the rule.
  - Download on a token row returns `Ignored`.
  - Download returns `Refused(MEMORY)` or `Refused(STORAGE)` when the fake probes drop after load.
    The status stays unchanged and the runtime is never called (SC-006).
  - The 001/002 scenarios still pass (SC-005).
- **`ModelDownloadPresenterTest`**:
  - Token rows have `canStart = false`.
  - A `Refused` result sets `error = Shortfall`, and `DismissError` clears it.
  - Only the Text and Speech sections appear, and toggling and search work.

## Manual (SC-003, SC-004, SC-006, SC-007)

1. Install on an Android 8.0 (API 26) device or emulator and on a current device.
2. Open the screen. Only the Text and Speech sections appear.
3. For one Text row and one Speech row: download, cancel, resume, finish, and delete. Check that the
   storage is freed.
4. On an SM8650, SM8750, or SM8850 device, or a Pixel 10 (Tensor G5), download Gemma 4 E2B. On
   SM8750 or Tensor G5, run `adb shell ls -l /data/data/com.jayvijay.scottie/files/models/litert/`
   and check that the size matches the NPU build. On an SM8550 device, check that it matches the
   general build.
5. Fill the device's storage (or use an emulator with a small data partition) until free space is
   below a model's size, then press Download. The storage toast names both amounts and nothing
   downloads.
6. Gemma 3 1B is listed with Download disabled.
7. Optional: watch traffic through a proxy. The only requests should be catalog file URLs.
