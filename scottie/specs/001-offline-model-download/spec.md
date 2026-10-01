# Feature Specification: Offline Model Download

**Feature Branch**: `001-offline-model-download`

**Created**: 2026-10-01

**Status**: Draft

**Input**: User description: "Integrate the existing model download screen with the on-device AI
runtime so users can download models for offline use: download, track progress, pause/cancel where
supported, resume, and keep models on the device. Adapt the screen to what the runtime supports,
using the existing design-system components. Keep scope to offline model download only. Cover
download logic, state transitions, and errors with tests that never perform real network downloads."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Download a model for offline use (Priority: P1)

A user opens the model download screen, sees the models Scottie offers with their size, and taps
Download on one. The row shows live progress until the model is stored on the device, then shows it
as downloaded. The model remains available after the app restarts and works without a connection.

**Why this priority**: Without a completed download nothing else in on-device AI works; this is the
minimum viable slice.

**Independent Test**: Open the screen, download one model, restart the app, and confirm the row still
reads as downloaded with no network connection.

**Acceptance Scenarios**:

1. **Given** a model that is not on the device, **When** the user taps Download, **Then** the row
   switches to a downloading state within 1 second and shows progress.
2. **Given** a download in progress, **When** progress advances, **Then** the row shows the
   percentage and amount transferred of the total size; when the total is unknown, an indeterminate
   indicator is shown instead.
3. **Given** a download whose bytes have all arrived, **When** the model is being checked or
   unpacked, **Then** the row says so instead of showing a stalled transfer.
4. **Given** a download that completes, **When** the row updates, **Then** it shows the model as
   downloaded and offers Delete.
5. **Given** a downloaded model, **When** the app is restarted, **Then** the row shows it as
   downloaded without re-downloading.

---

### User Story 2 - Recover from a failed download (Priority: P2)

A download stops because of a network loss, lack of storage, or another fault. The row tells the
user what went wrong in plain language and offers Retry, which continues from the bytes already
received.

**Why this priority**: Multi-gigabyte downloads on mobile networks fail often; a silent or
misreported failure leaves users believing a model is ready when it is not.

**Independent Test**: Simulate a failure mid-download and confirm the row shows a readable reason,
offers Retry, and that retrying continues rather than restarting.

**Acceptance Scenarios**:

1. **Given** a download in progress, **When** it fails, **Then** the row shows a failed state with a
   human-readable reason (or a generic "Download failed" when none is available) and offers Retry.
2. **Given** a failed download with bytes already received, **When** the user taps Retry, **Then**
   the download continues from the retained bytes.
3. **Given** a download that ended without the model being complete, **When** the row updates,
   **Then** the model is never shown as downloaded.
4. **Given** insufficient free storage, **When** the user starts a download, **Then** the failure
   reason names storage as the cause.

---

### User Story 3 - Pause and resume a download (Priority: P2)

A user pauses a long download, for example to switch to Wi-Fi, and later resumes it without losing
progress.

**Why this priority**: Large models take minutes to hours; users need control without paying for the
transfer twice.

**Independent Test**: Pause mid-download, confirm the row reads as paused (not failed) with the
amount kept, then resume and confirm it continues from that amount.

**Acceptance Scenarios**:

1. **Given** a download in progress, **When** the user taps Pause, **Then** the transfer stops and the
   row shows a paused state, styled distinctly from a failure, with the amount already downloaded.
2. **Given** a paused download, **When** the user taps Resume, **Then** the download continues from
   the retained bytes.

---

### User Story 4 - Delete a downloaded model (Priority: P3)

A user removes a downloaded model to reclaim storage.

**Why this priority**: Models are large; reclaiming space matters but is secondary to obtaining them.

**Independent Test**: Delete a downloaded model and confirm the row returns to the available state
and the storage is freed.

**Acceptance Scenarios**:

1. **Given** a downloaded model, **When** the user taps Delete, **Then** the model's files are removed
   and the row returns to the available state offering Download.
2. **Given** a deletion that fails, **When** the row updates, **Then** the user sees an error and the
   row keeps reflecting what is actually on the device.

---

### Edge Cases

- The user leaves the screen or backgrounds the app during a download: the download continues in the
  background with a system notification showing progress and a Cancel action; returning to the screen
  shows the current state. Cancel from the notification is treated as a pause.
- The system refuses to start background work (e.g. app not in the foreground): the row shows a
  failed state offering Retry rather than crashing or hanging.
- Notification permission is denied: the download still runs; only the notification is absent.
- The user starts a second download while one is running: only one model downloads at a time;
  other Download actions are disabled until the active one finishes, pauses, or fails.
- The runtime reports cancellation in either of its forms (user stop vs. native settle): both are
  treated as a pause, never as a failure.
- A download ends without a completion signal: treated as interrupted (resumable), never as
  downloaded.
- The runtime fails to initialize: the screen shows an error state instead of an empty or broken list.
- The total size is unknown: progress is indeterminate rather than showing 0%.
- The process is killed mid-download: on next launch the row shows the model as not downloaded or
  resumable, never as downloaded.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: System MUST list the models available for offline download with name, model type,
  short description, and download size. The catalog MUST cover the reference app's model set across
  all types: text, multimodal/vision, image generation, embedding, speech recognition, and speech
  synthesis. Models the device cannot run (e.g. hardware-specific bundles for unsupported hardware)
  MUST NOT be offered.
- **FR-002**: System MUST show each model's current status: available, downloading, paused, failed, or
  downloaded.
- **FR-003**: Users MUST be able to start a download for an available model.
- **FR-004**: System MUST show download progress (percentage and amount transferred of total when
  known; indeterminate otherwise) and indicate post-transfer verification/unpacking.
- **FR-005**: Users MUST be able to pause an active download; paused downloads MUST keep the bytes
  already transferred.
- **FR-006**: Users MUST be able to resume a paused download and retry a failed one, continuing from
  retained bytes.
- **FR-007**: System MUST distinguish a user pause from a failure in both wording and styling.
- **FR-008**: System MUST show a human-readable failure reason, falling back to a generic message.
- **FR-009**: System MUST only mark a model downloaded after the runtime confirms completion.
- **FR-010**: Downloaded models MUST persist across app restarts and be usable without a network
  connection.
- **FR-011**: Users MUST be able to delete a downloaded model, freeing its storage.
- **FR-012**: System MUST allow at most one active download at a time.
- **FR-012a**: An active download MUST continue when the user leaves the screen or backgrounds the
  app, and MUST show a system notification with progress and a Cancel action. When it ends, the
  notification MUST report completion, pause, or failure.
- **FR-013**: The screen MUST use the existing design-system components and offer only actions the
  runtime supports; unsupported existing UI elements MUST be removed or adapted.
- **FR-014**: Scope MUST be limited to offline model download; model loading, chat, benchmarking,
  and other capabilities shown in the reference material are excluded.
- **FR-015**: Download logic, state transitions, and error handling MUST be covered by automated tests
  that never perform real network transfers or fetch real model files.

### Key Entities

- **Model**: An offline-capable AI model offered by Scottie; identity, name, type, description,
  download size, and whether it is on the device. A model may consist of one file, several files, or
  an archive; it is downloaded and deleted as one unit.
- **Download progress**: A snapshot of an active transfer; bytes transferred, total bytes (may be
  unknown), fraction, and phase (transferring, verifying, unpacking).
- **Download status**: Per-model state — available, downloading (with progress), paused (with bytes
  kept), failed (with reason and bytes kept), downloaded.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user can start a model download within 2 taps of opening the screen.
- **SC-002**: The row reflects a user action (download, pause, resume, delete) within 1 second.
- **SC-003**: Progress is visibly updated at least once every 2 seconds while bytes are arriving.
- **SC-004**: After pause/resume or failure/retry, no more than 5% of already-received data is
  transferred again.
- **SC-005**: 100% of interrupted downloads are shown as paused or failed, never as downloaded.
- **SC-006**: A downloaded model remains usable after restart with the device in airplane mode.
- **SC-007**: The automated test suite covers every status transition and failure path and completes
  with zero network access.

## Assumptions

- Users have a network connection when starting a download; Wi-Fi-only enforcement is out of scope.
- Model files are stored in app-private storage and removed when the app is uninstalled.
- The existing model download screen is the entry point; it becomes reachable from the app's root.
- Loading or running a downloaded model is out of scope and belongs to a later feature.
- The model catalog is fixed in the app (no remote catalog or user-added models), mirroring the
  reference app's model set at implementation time.
- The `reference/` folder is used only as a pattern source and will be deleted after implementation.
- Device-level (instrumented) download tests are not required; behavior is verified with simulated
  runtime responses.
