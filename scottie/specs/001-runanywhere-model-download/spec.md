# Feature Specification: On-Device Model Downloads

**Feature Branch**: `001-runanywhere-model-download`

**Created**: 2026-10-01

**Status**: Draft

**Input**: User description: "I already have download model ui built. I want you to use runanywhere
sdk to bring support for downloading edge models offline and tie it to the ui that I have built. The
idea is to show all the models that are supported and show them using download ui. You can change
the presentation logic of the download ui as you see fit depending on what runanywhere supports and
does not support. there is also runanywhere-kolin skill that you need to use for planning phase."

## Clarifications

### Session 2026-10-01

- Q: May verification download real LLMs? → A: No. No real LLM download is performed in any
  automated test or manual verification; download behavior is verified with simulated downloads.
- Q: Does the no-real-download rule extend to small non-LLM models and to live catalog listing?
  → A: Yes. No real model of any kind is downloaded, and the model list is also simulated during
  verification; nothing contacts the live model catalog.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Browse supported models (Priority: P1)

A person opens the model download screen and sees every on-device model the app can run, each with
its name, a short description, its download size, and whether it is already on the device.

**Why this priority**: Nothing else is possible until people can see which models exist and which
they already have.

**Independent Test**: Open the screen on a fresh install and on a device with one model already
present; the list shows every supported model with correct size and on-device status.

**Acceptance Scenarios**:

1. **Given** no models on the device, **When** the person opens the screen, **Then** every supported
   model is listed as available to download with its size.
2. **Given** a model already on the device, **When** the person opens the screen, **Then** that model
   is shown as downloaded with its size on disk.
3. **Given** the model list is still being prepared, **When** the screen opens, **Then** a loading
   indication is shown instead of an empty list.

---

### User Story 2 - Download a model with live progress (Priority: P1)

A person taps Download on a model and watches progress (percentage, bytes transferred of total)
until the model is ready to use offline.

**Why this priority**: Getting a model onto the device is the core purpose of the feature.

**Independent Test**: With a simulated download, tap Download on one model; progress advances and
the model ends in the downloaded state.

**Acceptance Scenarios**:

1. **Given** an available model, **When** the person taps Download, **Then** the model shows a
   downloading state with progress that advances toward completion.
2. **Given** a download in progress, **When** it completes, **Then** the model is shown as downloaded
   and its controls change to Delete.
3. **Given** a download in progress, **When** the person leaves the screen and returns, **Then** the
   download is still running and its current progress is shown.
4. **Given** total size is not yet known, **When** the download starts, **Then** an indeterminate
   progress indication is shown until the size is known.

---

### User Story 3 - Pause, resume, or abandon a download (Priority: P2)

A person pauses a download and later resumes it from where it stopped, or abandons it entirely.

**Why this priority**: Downloads are large; people need control, but it is secondary to getting a
model.

**Independent Test**: With a simulated download, pause, resume, and delete; progress continues from
the paused point on resume, and delete returns the model to available.

**Acceptance Scenarios**:

1. **Given** a download in progress, **When** the person taps Pause, **Then** the transfer stops and
   the model shows a paused state with its progress so far.
2. **Given** a paused download, **When** the person taps Resume, **Then** the download continues
   from where it stopped rather than from zero.
3. **Given** a downloading or paused model, **When** the person taps Delete, **Then** the download
   stops, partial data is removed, and the model returns to the available state.

---

### User Story 4 - Delete a downloaded model (Priority: P2)

A person removes a downloaded model to free storage.

**Why this priority**: Models are hundreds of megabytes to gigabytes; reclaiming space matters but
follows downloading.

**Independent Test**: Delete a downloaded model; it returns to available and its storage is freed.

**Acceptance Scenarios**:

1. **Given** a downloaded model, **When** the person taps Delete, **Then** the model is removed from
   the device and shown as available to download.
2. **Given** a model currently in use, **When** the person deletes it, **Then** it is released first
   and then removed without crashing the app.

---

### User Story 5 - Understand and recover from failures (Priority: P3)

When a download fails, the person sees why in plain language and can try again.

**Why this priority**: Failures are expected on mobile networks and full storage, but the happy path
comes first.

**Independent Test**: Start a download with no connection, and with insufficient storage; each shows
a specific message and a way to retry.

**Acceptance Scenarios**:

1. **Given** no network connection, **When** the person starts a download, **Then** the model shows a
   failed state explaining a connection is needed, with a Retry action.
2. **Given** insufficient free storage, **When** the download fails, **Then** the model shows a failed
   state explaining storage is full, with a Retry action.
3. **Given** a failed model, **When** the person taps Retry, **Then** the download starts again.

### Edge Cases

- A model requires access approval or credentials the app does not have: the download fails with
  a plain explanation that access is required.
- Several downloads are started at once: each model reports its own progress and outcome
  independently.
- The app is closed or killed mid-download: on next launch the model is shown as available (or
  downloaded if it finished), never stuck in a downloading state; downloading again continues from
  the bytes already on the device.
- A model file is removed outside the app: the list reflects the actual on-device state on next
  open.
- The model list cannot be prepared: the screen shows an error message with a way to retry.
- A model made of several files: progress reflects the whole model, not a single file.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: System MUST list every model the installed on-device runtime supports, in a stable
  order, each with name, description, download size, and current status.
- **FR-002**: System MUST show each model in exactly one status: available, downloading, paused,
  downloaded, or failed.
- **FR-003**: Users MUST be able to start downloading any available or failed model.
- **FR-004**: System MUST show download progress as a percentage, plus bytes transferred of total
  when the model is a single file with a known total, and an indeterminate indication while
  progress is unknown.
- **FR-005**: Downloads MUST continue when the person navigates away from the screen while the app
  is running.
- **FR-006**: Users MUST be able to pause an in-progress download and resume it from where it
  stopped, and to delete a downloading or paused model, returning it to available.
- **FR-007**: Users MUST be able to delete a downloaded model, releasing it from use first if needed,
  returning it to available and freeing its storage.
- **FR-008**: System MUST show a failed state with a plain-language reason and a Retry action,
  distinguishing at least: no connection, insufficient storage, access required, and other
  errors.
- **FR-009**: System MUST reflect the actual on-device state of models each time the screen opens.
- **FR-010**: Downloaded models MUST remain listed as downloaded when there is no network
  connection.
- **FR-011**: Resuming a paused or interrupted download MUST reuse the bytes already on the device.
- **FR-012**: When a download is refused for lack of access, System MUST say access is required.
- **FR-013**: All user-visible text MUST be localizable.
- **FR-014**: Verification of listing, download, progress, pause, resume, delete, and failure
  behavior MUST
  use a simulated model catalog and simulated downloads; no real model of any kind is downloaded
  and the live catalog is not contacted during automated tests or manual verification.
- **FR-015**: When no supported models are available, System MUST show an empty-state message.

### Key Entities

- **Model**: An on-device AI model the app can run. Identity, display name, description, category
  (for example, language or speech), download size, and access requirement.
- **Model download status**: Per-model state (available, downloading with progress, paused with
  progress, downloaded with size on disk, failed with reason), owned by the app for its lifetime
  and reconciled with what is actually on the device.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: The full list of supported models appears within 2 seconds of opening the screen.
  Confirmed only when the person runs the app (FR-014 forbids live verification).
- **SC-002**: Progress updates at least once per second during an active download. Confirmed only
  when the person runs the app (FR-014 forbids live verification).
- **SC-003**: With no network connection, the screen still lists every model and correctly shows
  which are downloaded.
- **SC-004**: After pause, delete, failure, or app restart, no model is ever shown in a status that
  contradicts what is on the device.
- **SC-005**: Every failure shows a specific reason and a Retry action; no failure leaves a model
  without an available action.
- **SC-006**: Resuming a paused download continues from its paused progress, not from zero.

## Assumptions

- "Supported models" means the models the integrated on-device runtime reports for the backends the
  app includes, filtered to those runnable on the device; the existing
  `app/src/main/assets/model_allow_lists.json` catalog is not used by this feature.
- Pause/Resume in the existing UI is kept: planning confirmed the runtime preserves partial bytes
  when a download stops and resumes from them.
- Failed, loading, and empty states are added to the existing UI.
- "Supported models" is limited to language models the bundled runtime backend can run.
- Downloads run for the app's lifetime; surviving process death (background download service) is
  out of scope.
- Gated models that need a personal access token are shown; their download fails with an
  access-required reason, because the catalog does not mark them in advance. Token entry is out of
  scope.
- Loading models into memory and running inference are out of scope; this feature only gets models
  onto and off the device.
- The download screen becomes the app's first screen, since nothing currently navigates to it.
- Because verification is fully simulated, real catalog contents and real download behavior are
  confirmed only when the person runs the app themselves.
- Network: the person has a connection when starting a download; Wi-Fi-only or metered-network
  policies are out of scope.
