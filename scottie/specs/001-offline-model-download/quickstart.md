# Quickstart: Validate Offline Model Download

Run from the repository root (`Scottie/`).

## Automated (no network, no device)

```sh
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.modeldownload.data.repository.ModelDownloadRepositoryImplTest"
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.modeldownload.presentation.ModelDownloadPresenterTest"
./gradlew :app:testDebugUnitTest
./gradlew :app:assembleDebug :app:detekt :app:lintDebug
```

Expected: all pass. Tests use `FakeModelRuntime` and `FakeDownloadForegroundHost`; no test touches
the SDK, the network, or model files. Coverage expectations (see [data-model.md](data-model.md)
transitions):

| Scenario | Expected |
|----------|----------|
| Catalog prepare succeeds / throws | `Ready` with downloaded ids applied / `Unavailable` |
| Device-rejected NPU row | Hidden unless already downloaded |
| Download → progress → completed | `Downloading` (progress) → `Downloaded` |
| Verifying / extracting | `Downloading` with phase, fraction 1 |
| Pause | `Paused` with bytes kept; runtime flow cancelled |
| `Cancelled` event / flow ends early | `Paused`, never `Downloaded` |
| `Failed(STORAGE)` etc. | `Failed` with reason; Retry → `Downloading` |
| Foreground start refused | `Failed(BACKGROUND_REFUSED)` |
| Second download while one active | Ignored; other rows `canStart = false` |
| Delete ok / throws | `Available` / stays `Downloaded` + error shown |
| Presenter `Back` | Navigator pop |

## Manual (device, real download — not part of the automated suite)

1. Install `./gradlew :app:installDebug` on a physical arm64 device; launch Scottie.
2. Loading state shows, then the model list with each type and size.
3. Download a small model (e.g. a ~250 MB text model). Allow notifications when asked.
4. Progress updates on the row and in the notification; leave the app — progress continues.
5. Tap Cancel in the notification → row reads Paused with bytes kept; Resume continues from there.
6. Toggle airplane mode mid-download → row reads Failed (network); Retry after reconnecting resumes.
7. On completion the notification reports the model is ready; the row reads Downloaded.
8. Force-stop and relaunch in airplane mode → row still Downloaded.
9. Delete → row returns to Available.
