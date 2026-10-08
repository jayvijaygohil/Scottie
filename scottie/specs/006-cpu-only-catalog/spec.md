# Feature Specification: CPU-Only Model Catalog

**Feature Branch**: `006-cpu-only-catalog`

**Created**: 2026-10-08

**Status**: Draft

**Input**: User description: "I want to remove showing NPU supported models and only show CPU
supported models. Also simplify the catalog with CPU supported models. Also remove the logic of
checking if there's an NPU or not as that's not longer relevent."

## Clarifications

### Session 2026-10-08

- Q: Do NPU builds or partial downloads already on devices need migration? → A: No. The app is
  unreleased and in active development, so the restart requirement for partial downloads was
  dropped too.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Every device gets the same CPU builds (Priority: P1)

A user opens the model catalog on any device and sees only models that run on the CPU. Each text
model offers its single general build, whatever chip the phone has. Downloading a model fetches
that general build, and the model can then be used by the app's on-device assistant.

**Why this priority**: The app runs text models on the CPU only. A chip-specific NPU build
downloaded on an eligible phone does not match how the app runs models, so offering one is
misleading at best and broken at worst.

**Independent Test**: Open the catalog on a phone that the app previously treated as
NPU-eligible (for example Snapdragon 8 Elite or Tensor G5) and on one that it did not. Confirm
both list the same text models with the same download sizes. Then download one model on the
eligible phone and confirm the general build arrives and loads.

**Acceptance Scenarios**:

1. **Given** a device the app previously treated as NPU-eligible, **When** the user opens the
   catalog, **Then** each text model shows the general build's download size, not an NPU
   variant's.
2. **Given** any device, **When** the user downloads a text model, **Then** the general build is
   downloaded and the model is usable once complete.
3. **Given** two devices with different chips, **When** each opens the catalog, **Then** both
   show the same text models with the same sizes.

---

### User Story 2 - Catalog lists only CPU-capable models (Priority: P2)

A maintainer reviewing the catalog finds one build per text model and no chip-specific entries.
A model that has only NPU builds is not in the catalog at all.

**Why this priority**: A single build per model makes the catalog shorter, easier to audit, and
impossible to resolve differently per device.

**Independent Test**: Review the catalog contents: every text model has exactly one download
and none of them is chip-specific.

**Acceptance Scenarios**:

1. **Given** the catalog, **When** text models are listed, **Then** each has exactly one
   download, and it is the general (CPU) build.
2. **Given** a model with no general build, **When** the catalog is assembled, **Then** that
   model is absent.

---

### User Story 3 - No chip detection runs (Priority: P3)

The app no longer reads or interprets the device's chip identity to decide what to offer, and it
no longer asks for access to the vendor NPU runtime.

**Why this priority**: Removing detection that no longer influences behavior removes code and a
platform permission request without any change users can see.

**Independent Test**: Confirm the catalog is the same on every device and that the app declares
no optional NPU runtime library.

**Acceptance Scenarios**:

1. **Given** app startup, **When** the catalog is prepared, **Then** no chip or board
   identification is consulted.
2. **Given** the installed app, **When** its declared platform libraries are inspected, **Then**
   no NPU runtime library is requested.

### Edge Cases

- Speech-to-text models are unaffected; they already run on the CPU and stay listed as they are.
- Searching the catalog for "npu" still returns no results.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The catalog MUST offer each text model as exactly one general (CPU) build,
  identical on every device.
- **FR-002**: The catalog MUST NOT contain chip-specific (NPU) builds or any per-chip mapping.
- **FR-003**: Text models with only chip-specific builds MUST be removed from the catalog. Today
  every text model has a general build, so no model is removed.
- **FR-004**: The app MUST NOT identify the device's chip or board to assemble the catalog, and
  all logic that does so MUST be removed.
- **FR-005**: The app MUST NOT declare the optional vendor NPU runtime library.
- **FR-006**: The unused bundled model allow-list data, which carries chip-to-file mappings and
  is referenced by nothing, MUST be removed.
- **FR-007**: The speech-to-text catalog entries, the download behavior, and how the catalog is
  displayed MUST be otherwise unchanged.
- **FR-008**: Existing automated checks that covered chip detection or NPU resolution MUST be
  removed or replaced by a check that every device receives the same CPU catalog.

### Key Entities

- **Text model entry**: A downloadable text model with a display name, its saved file name, one
  download address, a download size, an estimated memory need, and whether access requires a
  token.
- **Speech model entry**: Unchanged by this feature.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: On 100% of devices, the catalog lists the same text models with identical download
  sizes.
- **SC-002**: The catalog contains 0 chip-specific builds, and each text model has exactly 1
  download.
- **SC-003**: Every text model downloaded after the change loads and answers a prompt on a
  previously NPU-eligible device.
- **SC-004**: The amount of catalog and device-detection material maintained in the product
  shrinks: the chip detection, the per-chip build tables, and the unused allow-list are all gone.

## Assumptions

- The app runs text models on the CPU only, so no runtime acceleration choice is affected.
- The app is in active development and has not been released to the public. No migration or
  compatibility handling is needed for NPU builds or partial downloads already on development
  devices. Clear them by hand if needed.
- Download sizes and memory estimates for general builds stay as currently published.
- The catalog's categories, badges, search, and memory-based compatibility check are unchanged.
- Speech-to-text models already use CPU-only runtimes and need no change.
