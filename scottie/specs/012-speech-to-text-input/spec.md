# Feature Specification: Speech-to-Text Voice Input for Chat Composer

**Feature Branch**: `012-speech-to-text-input`

**Created**: 2026-10-15

**Status**: Draft

**Input**: User description: "Add speech-to-text (voice input) for the chat composer supporting both on-device (Edge) speech recognition models and OpenRouter (Cloud) audio-capable models, with only one audio model active at a time.

  1. Audio Model Selection in Settings:
  - Add a second model selector dropdown on the Model Settings screen specifically for the active Speech-to-Text (Audio) model, alongside the existing Text model selector.
  - The Audio model dropdown lists:
    (a) A "None" option (the default when no audio model has been chosen or when the previously selected audio model is deleted or unselected),
    (b) All downloaded on-device speech recognition models, and
    (c) All saved OpenRouter models that support audio input (identified from the OpenRouter model list's input modalities).
  - Cloud options in the dropdown display the remote badge just like remote text models.
  - Downloaded on-device speech recognition model cards also expose the "Use" action to set that model as the active audio model and return to chat.
  - Only one audio model (either one Edge speech recognition model OR one Cloud OpenRouter model) can be active at any time. Selecting another replaces the current selection, and selecting "None" clears it.
  - Persist the selected audio model across app restarts. If the stored audio model is later deleted or removed from the saved OpenRouter selection, automatically fall back to "None" (no audio model selected).

  2. Chat Composer Record Button Visibility:
  - When no audio model is selected ("None"), hide the microphone record button on the chat screen composer.
  - When an audio model (Edge or Cloud) is selected, show the microphone record button in the chat composer next to the Send button.

  3. Whole-Clip Recording & Transcription Flow (Batch Mode):
  - Use whole-recording (batch) capture rather than live streaming: the user taps the microphone button once to start recording and taps it again to stop and transcribe the completed audio clip.
  - Microphone Permission: If microphone permission is not yet granted when the user taps the record button, request runtime microphone permission. If the user denies permission, do not start recording and show a dismissible error notice.
  - Recording State: While recording is active, show a clear recording/stop state on the record button and disable Send and Clear Chat. If the screen is exited or cancelled while recording, immediately stop recording, discard the clip, and release the microphone hardware.
  - Transcription State: When the user taps stop, release the microphone immediately, show a transcribing busy state in the composer (disabling Record, Send, and Clear Chat while in flight), and send the recorded audio clip to the single active audio model:
    - If an Edge speech recognition model is active, transcribe the recorded audio locally on the device.
    - If a Cloud OpenRouter model is active, send the recorded audio clip to that OpenRouter model and request a verbatim plain-text transcription.
  - Result Handling:
    - On success with non-blank text, insert the transcribed text into the chat composer input field (appending with a space if the input field already contains text) so the user can review, edit, or tap Send.
    - If the recording is silent or produces a blank transcript, return to the idle composer state without modifying existing draft text.
    - If transcription fails (such as no network connection for a Cloud model, invalid credentials, or an on-device model error), preserve any existing text in the composer, return to the idle state, and show a dismissible user-facing error message."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Select and Persist an Active Speech-to-Text Model in Settings (Priority: P1)

A user wants to choose which speech-to-text (audio) model powers voice input in the chat composer, or turn voice input off entirely. On the Model Settings screen, alongside the existing Text model selector, the user sees a dedicated Speech-to-Text (Audio) model selector dropdown. The dropdown always starts with a "None" option (selected by default), followed by any downloaded on-device speech recognition models, and then any saved OpenRouter models that support audio input (marked with a remote badge). Alternatively, the user can tap the "Use" action directly on a downloaded on-device speech recognition model card to make it the active audio model and immediately return to the Chat screen. Only one audio model (on-device or cloud) can be active at a time, and the selection persists across app restarts, falling back automatically to "None" if the chosen model is later deleted or removed from saved OpenRouter models.

**Why this priority**: Selecting an active audio model is the foundational prerequisite for voice input; it determines whether the microphone control appears in the chat composer and which model handles transcription.

**Independent Test**: Open Model Settings with at least one downloaded on-device speech recognition model and/or one saved audio-capable OpenRouter model. Verify the Audio model selector defaults to "None", switch between "None", a downloaded on-device speech model, and an audio-capable OpenRouter model (or tap "Use" on a downloaded speech model card), restart the app to confirm persistence, and delete/unselect the active audio model to verify automatic fallback to "None".

**Acceptance Scenarios**:

1. **Given** the user has not yet chosen an audio model, **When** the user opens the Model Settings screen, **Then** the Speech-to-Text (Audio) model selector is displayed alongside the Text model selector and shows "None" as the active selection.
2. **Given** the user has downloaded on-device speech recognition models and saved OpenRouter models (some supporting audio input and some text-only), **When** the user opens the Audio model selector dropdown, **Then** it lists "None" first, followed by all downloaded on-device speech recognition models, followed by only those saved OpenRouter models whose input modalities include audio (each displaying the remote badge).
3. **Given** an audio model is currently active, **When** the user selects a different audio model (on-device or OpenRouter) from the Audio model dropdown, **Then** the new selection immediately replaces the previous active audio model and is persisted across app restarts.
4. **Given** an audio model is currently active, **When** the user selects "None" in the Audio model dropdown, **Then** the active audio model selection is cleared and persisted as "None".
5. **Given** an on-device speech recognition model is downloaded on the device, **When** the user views its card on the Model Settings screen and taps the "Use" action, **Then** that model is set as the active audio model and the app navigates back to the Chat screen.
6. **Given** an on-device or OpenRouter audio model is persisted as the active audio model, **When** the user deletes that downloaded on-device model or removes that OpenRouter model from their saved OpenRouter selection, **Then** the active audio model automatically falls back to "None".

---

### User Story 2 - Show or Hide the Chat Composer Microphone Button Based on Audio Model Selection (Priority: P1)

A user on the Chat screen should only see the voice input microphone button when a speech-to-text model is configured. When the active audio model is "None", the chat composer shows only the text input field and the Send button. As soon as an on-device speech recognition model or an audio-capable OpenRouter model is selected as the active audio model, the microphone record button appears next to the Send button in the chat composer.

**Why this priority**: Conditioning the microphone button on an active audio model prevents dead-end interactions when no speech-to-text model is configured and gives immediate visual confirmation when voice input is enabled.

**Independent Test**: With the active audio model set to "None", view the Chat screen and confirm no microphone button is rendered in the composer. Select an audio model in Settings, return to Chat, and confirm the microphone button is visible next to the Send button.

**Acceptance Scenarios**:

1. **Given** the active audio model is set to "None", **When** the user views the Chat screen composer, **Then** the microphone record button is hidden.
2. **Given** an on-device speech recognition model or an audio-capable OpenRouter model is selected as the active audio model, **When** the user views the Chat screen composer, **Then** the microphone record button is displayed next to the Send button.
3. **Given** an audio model is active and the microphone button is visible in the Chat composer, **When** the user navigates to Settings and changes the active audio model to "None" (or deletes the active audio model) and returns to Chat, **Then** the microphone record button is hidden.

---

### User Story 3 - Record a Voice Clip and Transcribe It into the Chat Composer (Priority: P1)

A user with an active audio model wants to dictate a message into the chat composer using batch (whole-clip) recording. The user taps the microphone button once to begin recording; if microphone permission has not yet been granted, the app requests it first. While recording is active, the record button clearly indicates the recording/stop state, and both the Send and Clear Chat buttons are disabled. When the user taps the button a second time to stop, the microphone is released immediately, the composer shows a transcribing busy indicator (with Record, Send, and Clear Chat disabled), and the recorded clip is transcribed by the active audio model (locally on-device or via the selected OpenRouter cloud model). Once transcription succeeds, the resulting text is inserted into the composer input field (appended after a space if draft text already exists) so the user can review, edit, or press Send.

**Why this priority**: Whole-clip recording and transcription into the editable composer input is the core user value of speech-to-text voice input.

**Independent Test**: Select an active audio model (test with both a downloaded on-device speech model and a saved audio-capable OpenRouter model), tap Record in the chat composer, grant microphone permission if prompted, speak a phrase, tap Stop, and verify the composer transitions through recording and transcribing states before inserting the transcribed text into the input field for review and sending.

**Acceptance Scenarios**:

1. **Given** microphone permission is not yet granted and an audio model is active, **When** the user taps the microphone record button in the chat composer, **Then** the system requests runtime microphone permission before starting recording.
2. **Given** the runtime microphone permission prompt is shown, **When** the user denies microphone permission, **Then** recording does not start and a dismissible error notice is shown to the user.
3. **Given** microphone permission is granted and an audio model is active, **When** the user taps the microphone record button, **Then** audio recording starts, the record button displays a clear recording/stop state, and the Send and Clear Chat buttons are disabled.
4. **Given** audio recording is currently active, **When** the user taps the stop/record button, **Then** the microphone hardware is released immediately, the composer displays a transcribing busy state with Record, Send, and Clear Chat disabled, and the recorded audio clip is sent to the active audio model for transcription.
5. **Given** a recorded audio clip is submitted for transcription while an on-device speech recognition model is active, **When** transcription runs, **Then** the audio clip is transcribed locally on the device without sending audio over the network.
6. **Given** a recorded audio clip is submitted for transcription while an OpenRouter audio model is active, **When** transcription runs, **Then** the audio clip is sent to that OpenRouter model with a request for a verbatim plain-text transcription.
7. **Given** the chat composer input field is empty, **When** transcription completes with non-blank text, **Then** the transcribed text is placed into the composer input field and the composer returns to the idle state so the user can review, edit, or tap Send.
8. **Given** the chat composer input field already contains draft text, **When** transcription completes with non-blank text, **Then** the transcribed text is appended to the existing draft text separated by a single space (avoiding duplicate spaces if the draft already ends with whitespace) and the composer returns to the idle state.

---

### User Story 4 - Handle Silent Recordings, Errors, and Screen Cancellation Gracefully (Priority: P2)

During voice input, a user may record silence, leave the screen mid-recording, or encounter a transcription error (such as network loss with a cloud model, invalid credentials, or an on-device model failure). The system must protect existing draft text in the composer, release microphone resources promptly on cancellation or navigation away, ignore blank/silent transcripts without wiping draft text, and surface clear dismissible error messages when transcription fails.

**Why this priority**: Graceful recovery preserves user trust, prevents lost draft messages, and ensures the device microphone is never left open when the user leaves the screen.

**Independent Test**: Type draft text into the composer, test (a) recording silence, (b) navigating away while recording is active, and (c) triggering a transcription failure (e.g., offline cloud model or invalid API key). Verify that draft text is preserved in all cases, microphone hardware is released immediately on exit, and failures show a dismissible error banner.

**Acceptance Scenarios**:

1. **Given** the user has existing draft text in the composer and records a silent clip that produces a blank or whitespace-only transcript, **When** transcription finishes, **Then** the composer returns to the idle state and the existing draft text remains unchanged.
2. **Given** audio recording is currently active, **When** the user exits the Chat screen or cancels the screen lifecycle (e.g., navigates to Settings or backgrounds/closes the screen), **Then** recording stops immediately, the partial audio clip is discarded without transcribing, and the microphone hardware is released.
3. **Given** the user stops recording and transcription fails (due to no network connection for a Cloud model, invalid OpenRouter credentials, or an on-device speech model error), **When** the error occurs, **Then** any existing draft text in the composer is preserved, the composer returns to the idle state, and a dismissible user-facing error message is displayed.

---

### Edge Cases

- **Navigating away or backgrounding while recording**: Recording stops immediately, the captured clip is discarded, and the microphone hardware is released so no background recording continues.
- **Silent or ultra-short recording**: If a recording contains only silence or produces an empty/whitespace-only transcript, the composer returns cleanly to idle without altering any existing draft text or showing a false crash.
- **Appending to existing composer draft text**: When the composer already has text, the newly transcribed text is appended with a single separating space; if the existing text already ends in whitespace, no extra space is doubled.
- **Deleting or unselecting the active audio model**: If the active on-device speech model is deleted or the active OpenRouter audio model is unchecked/removed from saved OpenRouter models, the active audio model resets automatically to "None" and the composer microphone button hides upon returning to Chat.
- **Assistant chat reply in progress**: While a chat message reply is already in flight (`busy`), the microphone record button is disabled along with Send and Clear Chat so recording cannot start concurrently with an active assistant turn.
- **Permission granted on first prompt**: When the user taps the microphone button without prior permission and grants permission in the system dialog, recording either starts immediately or allows the user to record without requiring an app restart.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The Model Settings screen MUST display a dedicated Speech-to-Text (Audio) model selector dropdown alongside the existing Text model selector.
- **FR-002**: The Speech-to-Text (Audio) model selector dropdown MUST list options in the following order:
  1. A `"None"` option (selected by default when no audio model has been chosen),
  2. All downloaded on-device speech recognition models, and
  3. All saved OpenRouter models whose declared input modalities include audio.
- **FR-003**: Saved OpenRouter audio models shown in the Speech-to-Text (Audio) model selector dropdown MUST display the remote badge consistent with remote text models.
- **FR-004**: Downloaded on-device speech recognition model cards on the Model Settings screen MUST expose a `"Use"` action (consistent with downloaded text model cards) that sets that speech model as the active audio model and returns the user to the Chat screen.
- **FR-005**: Only one audio model (either one downloaded on-device speech recognition model OR one saved audio-capable OpenRouter model) MAY be active at any time; selecting a different model MUST replace the previous selection, and selecting `"None"` MUST clear the active audio model.
- **FR-006**: The system MUST persist the active audio model selection across app restarts, and MUST automatically fall back to `"None"` if the stored audio model is subsequently deleted from the device or removed from the saved OpenRouter model selection.
- **FR-007**: When the active audio model is `"None"`, the Chat screen composer MUST hide the microphone record button.
- **FR-008**: When an on-device or OpenRouter audio model is active, the Chat screen composer MUST display the microphone record button next to the Send button.
- **FR-009**: Voice input MUST use whole-clip (batch) capture: tapping the microphone record button in the idle state starts recording, and tapping it again while recording stops capture and begins transcription of the completed audio clip.
- **FR-010**: If runtime microphone permission is not granted when the user taps the microphone record button, the app MUST request microphone permission; if the user denies permission, the app MUST NOT start recording and MUST display a dismissible error notice.
- **FR-011**: While audio recording is active, the record button MUST display a clear recording/stop visual state and accessible label, and the Send and Clear Chat actions MUST be disabled.
- **FR-012**: If the Chat screen is exited or cancelled while audio recording is active, the system MUST immediately stop recording, discard the recorded audio clip without transcribing, and release the microphone hardware.
- **FR-013**: When the user taps stop to finish recording, the system MUST immediately release the microphone hardware, display a transcribing busy state in the chat composer, and disable the Record, Send, and Clear Chat actions while transcription is in flight.
- **FR-014**: When an on-device speech recognition model is active, stopping a recording MUST transcribe the captured audio clip locally on the device using that speech recognition model.
- **FR-015**: When a saved OpenRouter audio model is active, stopping a recording MUST send the captured audio clip to that OpenRouter model and request a verbatim plain-text transcription without extra commentary or formatting.
- **FR-016**: When transcription succeeds with non-blank text, the system MUST insert the transcribed text into the chat composer input field—appending it with a single separating space if the composer already contains non-empty text—and return the composer to the idle state so the user can review, edit, or tap Send.
- **FR-017**: When a recording is silent or transcription returns a blank/whitespace-only result, the system MUST return the composer to the idle state without modifying any existing draft text in the composer.
- **FR-018**: When transcription fails (including missing network connectivity for a Cloud model, invalid or missing OpenRouter credentials, audio capture error, or on-device speech model failure), the system MUST preserve any existing draft text in the composer, return the composer to the idle state, and show a dismissible user-facing error message.

### Key Entities

- **Active Audio Model Selection**: The persisted user preference identifying the currently active speech-to-text model—either `"None"` (no audio model active), a downloaded on-device speech recognition model identifier, or a saved audio-capable OpenRouter model identifier.
- **Audio-Capable OpenRouter Model**: A remote model from the OpenRouter catalog whose metadata indicates support for `"audio"` in its input modalities, making it eligible for selection in the Speech-to-Text (Audio) model dropdown when saved by the user.
- **Voice Recording & Transcription State**: The chat composer's voice input lifecycle state (`Idle`, `Recording`, or `Transcribing`), governing button visuals, action enablement (Record, Send, Clear Chat), and microphone resource ownership.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: Users can select or switch the active Speech-to-Text model (among `"None"`, downloaded on-device speech models, and saved audio-capable OpenRouter models) on the Model Settings screen in under 5 seconds, and the choice persists across 100% of app restarts.
- **SC-002**: 100% of saved OpenRouter models that declare audio input support appear in the Audio model dropdown with a remote badge, while 0 text-only OpenRouter models appear in the Audio model dropdown.
- **SC-003**: The chat composer microphone button is hidden 100% of the time when the active audio model is `"None"` and visible 100% of the time when a valid on-device or cloud audio model is active.
- **SC-004**: Tapping Record and then Stop captures a spoken clip, releases the microphone hardware immediately upon stopping or screen exit in 100% of cases, and inserts non-blank transcribed text into the composer input field without overwriting existing draft text.
- **SC-005**: In 100% of permission denial, silent recording, or transcription failure scenarios, existing draft text in the chat composer is preserved without loss and the composer returns cleanly to the idle state.

## Assumptions

- OpenRouter models supporting audio input are identified from the OpenRouter catalog's `architecture.input_modalities` (or equivalent modality metadata fetched from the OpenRouter models endpoint) containing `"audio"`.
- Saved audio-capable OpenRouter models selected by the user in the OpenRouter model picker are eligible for the Speech-to-Text (Audio) dropdown; if a saved OpenRouter model supports both text and audio inputs, it can appear in the Text model dropdown and the Audio model dropdown independently.
- On-device speech recognition models are the Speech-to-Text category models already defined in the local model catalog (from feature `003-text-stt-catalog`) that have been downloaded to the device.
- When requesting transcription from an OpenRouter audio-capable model, the app sends the recorded audio clip in a standard compatible format (such as WAV/PCM audio) with a prompt instructing the model to return only the verbatim transcription of the spoken audio as plain text, or empty text if no speech is present.
