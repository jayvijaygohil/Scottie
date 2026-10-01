# Quickstart: Validating On-Device Model Downloads

**Rule (spec FR-014):** No step here downloads a real model or contacts the live catalog.
Do not install or launch the app on a device or emulator as part of validation.
`Application.onCreate` initializes the SDK, which starts a background catalog fetch.

## 1. Build

```sh
./gradlew :app:assembleDebug
```

Expected: success. This proves the SDK resolves, Java 17 bytecode inlines, and native libraries
merge (research R2).

## 2. Presenter tests (simulated downloads)

```sh
./gradlew :app:testDebugUnitTest
```

These use a fake `ModelRepository` and must cover:

| Scenario | Spec |
|----------|------|
| Loading → Loaded with mixed available/downloaded models | US1, FR-001 |
| Repository list failure → Error; RetryList → Loaded | Edge case |
| Empty list → Loaded(empty) | FR-015 |
| Download emits progress → Downloading with fraction → Downloaded | US2, FR-004 |
| Pause → Paused keeps fraction; Resume → Downloading from that fraction | US3, SC-006 |
| Repository delete failure → state unchanged, no crash | US4 |
| Delete from Downloading, Paused, Downloaded → Available | US3, US4 |
| Failure reasons → Failed(reason); Download (retry) → Downloading | US5, FR-008 |
| Back → navigator pop | existing |

It must also include a pure test of `ProtoErrorCode` → `DownloadFailure` (research R7).

## 3. Static analysis

```sh
./gradlew :app:detekt :app:lintDebug
```

## 4. Visual check

Open `ModelDownloadUi.kt` and `ModelDownloadCard.kt` previews in Android Studio. Every card state,
including Failed and Paused, plus Loading, Error, and Empty, renders in light, dark, and 2× font.

## Not validated here

- Real catalog contents and real transfers (research R4 risk).
- SC-001 (list within 2 s) and SC-002 (progress at least once per second).
- `RunAnywhereModelRepository` behavior with the real SDK: offline listing (SC-003), restart
  reconciliation (SC-004), and resume from partial bytes (FR-011). These are checked by code
  inspection only.
- Device tests (`connectedDebugAndroidTest`), skipped under constitution IV's v1.1.0 exception.

The person running the app confirms these.
