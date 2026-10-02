# Feature Specification: Text and Speech-to-Text Catalog

**Feature Branch**: `003-text-stt-catalog`

**Created**: 2026-10-02

**Status**: Draft

**Input**: User description: "Update the existing offline model download feature so its catalog only
offers the models Scottie will run on-device: text-generation models and speech-to-text models.
This feature covers browsing, downloading, and managing model files only. It does not load, run, or
test any model. Text-generation models are offered in the on-device format the app will use; when a
model has hardware-specific variants (NPU builds for Qualcomm Snapdragon and Google Tensor, plus a
general CPU/GPU build), the app downloads the variant that best fits the device and users never see
or download a variant their device can't run. Speech-to-text models are offered for Android 8.0
(API 26) and above. Previously downloaded models no longer in the catalog need no handling because
the app is unreleased. Existing download experience (progress, cancel, delete, storage and memory
checks, categorized browsing, search) keeps working. Network is used only to fetch catalog model
files."

## Clarifications

### Session 2026-10-02

- Q: With builds resolved per device, should categories keep nested hardware subsections? → A: No.
  One flat collapsible section for Text and one for Speech; no CPU/NPU subsections.
- Q: Should models whose source requires a Hugging Face account token be offered? → A: Yes. List
  them with Download disabled; supplying a token is out of scope for this feature.
- Q: What makes a model Supported? → A: Match the RunAnywhere SDK checks
  (`references/runanywhere-gating.md`): currently available memory ≥ the fetched build's memory
  need AND free model storage ≥ its download size; unknown values pass; no headroom. Supersedes
  002's total-memory rule.
- Q: When is compatibility checked? → A: At catalog load and again when Download, Resume, or Retry
  is pressed; a failed start-time check blocks the download and names the shortfall and amounts.
  Badges stay reason-free.
- Q: Which chips get NPU builds? → A: Snapdragon SM8650, SM8750, SM8850 (identified from the board
  platform "pineapple"/"sun" when the chip model is unavailable) and Google Tensor G5/G6. All other
  chips, including SM8550, get the general build.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Get the right text-generation model for this device (Priority: P1)

A user browses text-generation models and downloads one. Each model appears once. When the model
has hardware-specific builds, the app picks the build that best fits the device: the device's NPU
build on a supported Snapdragon or Tensor device, the general CPU/GPU build otherwise. The user can
cancel the download or delete the downloaded model.

**Why this priority**: Text generation is Scottie's core on-device capability; a wrong or unusable
build wastes gigabytes of download.

**Independent Test**: With simulated device profiles (supported Snapdragon NPU, supported Tensor NPU,
no supported NPU), open the catalog and download a text model with variants; confirm each profile
fetches the expected variant and that no other variant is listed or fetched.

**Acceptance Scenarios**:

1. **Given** a device with a supported Snapdragon NPU and a text model with a Snapdragon NPU build,
   **When** the user downloads it, **Then** the Snapdragon NPU build is fetched.
2. **Given** a device with a supported Tensor NPU and a text model with a Tensor NPU build, **When**
   the user downloads it, **Then** the Tensor NPU build is fetched.
3. **Given** a device with a supported NPU and a text model without a build for that NPU, **When**
   the user downloads it, **Then** the general build is fetched.
4. **Given** a device without a supported NPU, **When** the catalog is shown, **Then** each text model
   appears once and only its general build can be fetched.
5. **Given** a text model with only NPU builds, none of which the device can run, **When** the catalog
   is shown, **Then** that model is not listed.
6. **Given** a text-model download in progress, **When** the user cancels, **Then** the download stops
   and no partial model remains usable.
7. **Given** a downloaded text model, **When** the user deletes it, **Then** its storage is freed and
   it returns to the not-downloaded state.
8. **Given** a text model whose source requires a Hugging Face account token, **When** the catalog
   is shown, **Then** it is listed with its Download action disabled and no download is attempted.
9. **Given** an SM8550 device and a text model with an SM8550 NPU build, **When** the user downloads
   it, **Then** the general build is fetched.
10. **Given** a device whose chip model is unavailable but whose board platform is "sun", **When** the
    user downloads a model with an SM8750 build, **Then** the SM8750 build is fetched.
11. **Given** a model that was Supported when the catalog loaded, **When** the user presses Download
    and available memory is now below the build's memory need, **Then** the download does not start
    and the user sees, for example, "Needs at least 3.2 GB of available memory; 2.1 GB is
    available. Close other apps or choose a smaller model."
12. **Given** free model storage below the build's download size, **When** the user presses
    Download, Resume, or Retry, **Then** the download does not start and the user sees, for example,
    "Needs 2.6 GB of free storage; 1.4 GB is available. Free up storage or choose a smaller model."

---

### User Story 2 - Download speech-to-text models on any supported Android version (Priority: P1)

A user browses speech-to-text models, downloads one, and can cancel or delete it, on any device
running Android 8.0 or later.

**Why this priority**: Speech-to-text is the second capability Scottie runs on-device and must reach
every supported device.

**Independent Test**: On an Android 8.0 device and a current Android device, open the catalog,
confirm speech-to-text models are listed, then download, cancel, and delete one.

**Acceptance Scenarios**:

1. **Given** a device running Android 8.0 or later, **When** the catalog is shown, **Then** at least
   one speech-to-text model is listed and downloadable (subject to storage and memory checks).
2. **Given** a speech-to-text download in progress, **When** the user cancels, **Then** the download
   stops and no partial model remains usable.
3. **Given** a downloaded speech-to-text model, **When** the user deletes it, **Then** its storage is
   freed.

---

### User Story 3 - Catalog contains only what Scottie runs (Priority: P2)

A user opening the catalog sees only text-generation and speech-to-text models, grouped into a Text
section and a Speech section, and search covers only those models.

**Why this priority**: Offering models the app will never run misleads users and wastes storage; it
follows naturally once P1 stories define what remains.

**Independent Test**: Open the catalog and search for terms such as "vision", "embedding", and
"tts"; confirm no model of a removed type appears.

**Acceptance Scenarios**:

1. **Given** the catalog has loaded, **When** the user opens the screen, **Then** only a Text section and a
   Speech section are shown, each listing its models directly with no nested subsections.
2. **Given** the catalog, **When** the user searches for any removed model type, **Then** no matching
   model is shown.

---

### Edge Cases

- NPU detection fails or is inconclusive: the device is treated as having no supported NPU and the
  general build is used.
- A model's chosen build needs more memory or storage than is currently available: it is marked
  Unsupported and its download is disabled.
- The device cannot report available memory or free storage, or the model has no stated need: that
  check passes.
- Available memory or free storage changes after the catalog loads: the start-time check decides;
  a refused start leaves the model's status unchanged and shows the shortfall message.
- An active download is never cancelled by a later compatibility change.
- The device has both a supported NPU and too little memory for the NPU build: the model is judged on
  the build that would be fetched; the app does not silently switch builds to pass the memory check.
- A download is active while the catalog reloads: the download is not cancelled.
- A token-requiring model the device also cannot run (memory): shown as Unsupported with Download
  disabled.
- A speech-to-text model whose runtime needs a newer Android version than the device: not offered.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The catalog MUST contain only text-generation and speech-to-text models; vision,
  multimodal, image generation, embedding, reranking, segmentation, voice-activity detection, and
  text-to-speech models MUST be removed.
- **FR-002**: Text-generation models MUST be offered only in the single on-device format the app
  uses for text generation.
- **FR-003**: Each text-generation model MUST appear once in the catalog regardless of how many
  hardware builds it has.
- **FR-004**: For a text-generation model, the app MUST select the build to fetch in this order: the
  device's eligible NPU build (FR-015), then the general CPU/GPU build.
- **FR-005**: Users MUST NOT see, select, or download a build the device cannot run; a model with no
  runnable build MUST NOT be listed.
- **FR-006**: Speech-to-text models MUST be offered on every device running Android 8.0 (API 26) or
  later.
- **FR-007**: Users MUST be able to download, cancel, and delete models of both types.
- **FR-008**: Existing behavior MUST keep working for remaining models: progress, cancel, delete,
  storage and memory compatibility checks, categorized browsing, and search.
- **FR-009**: The app MUST use the network only to fetch catalog model files.
- **FR-010**: Build selection and catalog contents MUST be covered by automated tests using simulated
  device capabilities, without real NPU hardware or network.
- **FR-011**: The catalog MUST show exactly two collapsible sections, Text and Speech, each listing
  its models directly with no nested hardware subsections; an empty section is hidden.
- **FR-012**: Models whose source requires a Hugging Face account token MUST be listed with
  Download (and Resume/Retry) disabled; the app MUST NOT attempt to fetch them.
- **FR-013**: A model MUST be Supported only when the device's currently available memory is at
  least the fetched build's memory need AND free space on the model storage is at least that build's
  download size. A value the device cannot report, or a need the model does not state, MUST pass.
  No headroom is added.
- **FR-014**: Compatibility MUST be evaluated when the catalog loads and again when the user presses
  Download, Resume, or Retry. A failed start-time check MUST NOT start the download and MUST show a
  message naming the shortfall (memory or storage) with the required and available amounts. Catalog
  badges MUST show only Supported or Unsupported, without reason text.
- **FR-015**: A device MUST be eligible for a model's NPU build only when its chip is Snapdragon
  SM8650, SM8750, or SM8850, or Google Tensor G5 or G6, and the model has a build for that chip. All
  other chips, including SM8550, and unknown chips MUST get the general build.
- **FR-016**: When the device cannot report its chip model directly, the chip MUST be identified
  from its board platform name: "sun" as SM8750 and "pineapple" as SM8650; any other name is unknown.

### Key Entities

- **Catalog model**: A text-generation or speech-to-text model offered to the user, with title,
  description, category, size, memory requirement, whether its source requires an account token,
  and download status.
- **Model build**: A hardware-specific file set for a text-generation model: Snapdragon NPU, Tensor
  NPU, or general CPU/GPU.
- **Device capabilities**: Android version, currently available memory (may be unknown), free space
  on the model storage (may be unknown), and chip identity (chip model, or board platform when the
  model is unavailable).
- **Compatibility verdict**: Supported or Unsupported, plus, at download start, the shortfall kind
  and the required and available amounts.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: 100% of catalog entries are text-generation or speech-to-text models.
- **SC-002**: On a supported Snapdragon or Tensor device, 100% of text-model downloads with a matching
  NPU build fetch that build; all others fetch the general build.
- **SC-003**: 0 builds the device cannot run are listed or downloaded, and 0 downloads start for
  token-requiring models.
- **SC-004**: Download, cancel, and delete succeed for both model types on an Android 8.0 device and
  on a current Android device.
- **SC-005**: All remaining download acceptance scenarios from features 001 and 002 still pass.
- **SC-006**: 0 downloads start when available memory or free storage is below the build's
  requirement; every refused start shows the shortfall with both amounts.
- **SC-007**: On SM8550 devices 100% of text-model downloads fetch the general build; on SM8650,
  SM8750, and SM8850 devices 100% fetch the chip's NPU build when one exists.

## Assumptions

- The app is unreleased, so models downloaded before this change that leave the catalog need no
  migration, listing, or cleanup.
- This supersedes feature 002's per-model NPU listing (NPU models shown as Unsupported) and its CPU
  Models / NPU Models subsections: builds are now resolved per device, so the Text and Speech
  sections list models directly.
- NPU eligibility follows the Hexagon generations the RunAnywhere NPU runtime supports (v75, v79,
  v81), even though NPU builds are also published for older chips; see
  `references/runanywhere-gating.md`. Chip identity is evaluated once per app launch.
- Available memory is what the system reports as currently available, not total memory, so badges
  may change between sessions; this is accepted. This supersedes 002's total-memory assumption.
- Amounts in shortfall messages are shown in GB with one decimal place.
- Load-time compatibility checks and unloading models to free memory are out of scope; nothing
  loads models in this feature.
- Memory and storage checks evaluate the build that would be fetched.
- Speech-to-text models use a runtime that supports Android 8.0 and above; no Android-version-specific
  speech-to-text variants are needed.
- Supplying or storing a Hugging Face account token is out of scope; token-requiring models stay
  non-downloadable until a later feature adds it.
- Loading, running, or testing models; chat, voice input, and speech output screens; text-to-speech;
  and cloud inference are out of scope.
