# Quickstart: Validate Model Catalog Enhancements

## Automated (no device, no network)

From the repository root:

```sh
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.modeldownload.data.ai.provider.ModelCatalogTest"
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.modeldownload.data.repository.ModelDownloadRepositoryImplTest"
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadPresenterTest"
./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug
```

Expected coverage:

| Check | Proves |
|---|---|
| Catalog: every title free of quant/precision/runtime tags, non-blank, unique per type + target | FR-004, SC-005 |
| Catalog: every row maps to exactly one type and target | FR-002, SC-006 |
| Repository: non-accepted rows listed with `supported = false` | FR-009 |
| Repository: row over device RAM → unsupported; unknown RAM → not blocked | FR-006, edge cases |
| Repository: `download()` on unsupported id is a no-op; `delete()` still works | FR-008, FR-010, SC-001 |
| Repository: existing 001 download tests still pass | FR-019, SC-007 |
| Presenter: sections in enum order, empty ones hidden, counts correct | FR-001–FR-003 |
| Presenter: default expansion (NPU collapsed when no supported NPU row) | Assumptions |
| Presenter: search by id, description, category, `npu`, `unsupported`; trimmed, case-insensitive | FR-011 |
| Presenter: search forces matched sections open, empty-results state, clear restores toggles | FR-012 |
| Presenter: toggling/searching during a download leaves status untouched | FR-013 |
| Presenter: unsupported → `canStart = false` | FR-008 |

## Manual (device)

1. Install `:app:assembleDebug` on a non-Snapdragon (or non-supported Hexagon) device. Open Download
   models. Expect: categories per model type; NPU Models subsections collapsed; NPU rows show
   Unsupported with Download disabled; rows above device RAM show Unsupported.
2. On a supported Snapdragon device (e.g. Snapdragon 8 Gen 3 / Elite): NPU rows that fit RAM show
   Supported; download one end to end.
3. Type in the toolbar search: `npu`, a model id, `unsupported`, nonsense. Expect live filtering,
   matched sections expanded, empty message for nonsense; clearing restores prior collapse state.
4. Start a download, collapse its section, search, clear: progress continues throughout.
5. Toggle dark mode and 2× font: badges, headers, and search field follow the theme and stay legible.

Device (instrumented) tests are not required by the spec; report the skip.
