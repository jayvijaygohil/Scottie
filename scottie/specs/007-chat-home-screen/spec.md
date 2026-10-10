# Feature Specification: Chat Window as Home Screen

**Feature Branch**: `007-chat-home-screen`

**Created**: 2026-10-10

**Status**: Draft

**Input**: User description: "Change the primary home screen to a Chat Window. Top app bar with a
model selector listing downloaded local models (switch the active model on the fly) and a settings
gear on the top right that opens the Model Download & Settings screen. Chat area: scrollable
message history with clear separation between user bubbles and model response bubbles, real-time
streaming of replies with auto-scroll to the bottom, and a bottom input bar with a styled text
field and send button. Empty state: when no model is downloaded, show a banner with a 'Download a
Model to Get Started' button. Model Download & Settings screen returns to the chat via back button
or back gesture. Apply the Settings screen's colors to the chat for a unified look. Smooth slide
or shared-element transitions between Chat and Settings, haptic feedback when switching models or
sending messages, and a subtle typing/thinking indicator while awaiting the first token."
Clarified: the chat is the existing Interac e-Transfer assistant promoted to the home screen; go
through its existing UI, update its colors, and rethink its layout where needed.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Chat with the assistant from the first screen (Priority: P1)

The user opens the app and lands directly in the Interac assistant chat. The active model's name is
shown in the top bar. The user types a message such as "What's the weather?" or "Send $50 to
Alice" and taps Send. Their message appears as a right-aligned bubble; a
subtle thinking indicator appears on the model's side until the first piece of the reply arrives,
then a text reply is revealed word by word in a left-aligned bubble once ready, or the balance cards or
transfer form appear in a card on the model's side. The list stays pinned to the
newest content while the reply is revealed.

**Why this priority**: Chatting is the app's primary purpose; making it the first screen removes
the detour through the download catalog on every launch.

**Independent Test**: With one text model downloaded and the network off, launch the app, send
"What's the weather?" and "Send $50 to Alice", and observe the bubbles, indicator, word reveal,
cards, and auto-scroll.

**Acceptance Scenarios**:

1. **Given** at least one text model is downloaded, **When** the app launches, **Then** the chat
   screen is the first screen shown and the top bar names the active model.
2. **Given** the chat screen, **When** the user enters non-blank text and taps Send, **Then** the
   text appears as a user bubble, the input clears, and a thinking indicator appears in the model's
   position.
3. **Given** a reply is in progress, **When** the reply is ready, **Then** the indicator is
   replaced by a model bubble whose text is revealed word by word.
9. **Given** a banking request such as "Send $50 to Alice", **When** the reply is ready, **Then**
   the indicator is replaced by the form or cards defined in feature 005, unchanged in behavior,
   presented in the chat's model-side card style.
4. **Given** a reply is being revealed and the user has not scrolled up, **Then** the newest text stays
   visible without manual scrolling.
5. **Given** a reply is being revealed, **When** the user scrolls up to read older messages, **Then**
   the list does not jump back to the bottom until the user returns to the bottom or sends again.
6. **Given** a reply is in progress, **Then** Send is disabled; it re-enables when the reply
   finishes or fails.
7. **Given** the input is empty or whitespace only, **Then** Send is disabled.
8. **Given** the user taps Send with valid input, **Then** the device gives a short haptic tick.

---

### User Story 2 - Get started when no model is downloaded (Priority: P1)

On first launch nothing is downloaded. Instead of an unusable chat, the user sees an empty-state
banner explaining a model is needed and a "Download a Model to Get Started" button that opens the
Model Download & Settings screen. After downloading a model and returning, the chat is ready.

**Why this priority**: Every new user hits this path first; without it the new home screen is a
dead end.

**Independent Test**: On a fresh install, launch, tap the button, download a text model, go back,
and send a message.

**Acceptance Scenarios**:

1. **Given** no text model is downloaded, **When** the app launches, **Then** the chat shows the
   empty-state banner with a "Download a Model to Get Started" button, and the input bar is not
   usable.
2. **Given** the empty state, **When** the user taps the button, **Then** the Model Download &
   Settings screen opens.
3. **Given** the user downloaded a text model and returns to the chat, **Then** the empty state is
   gone, that model is active, and the input bar is usable.
4. **Given** the only downloaded model is deleted while the user is in Settings, **When** the user
   returns, **Then** the empty state is shown again.

---

### User Story 3 - Switch the active model on the fly (Priority: P2)

The user taps the model name in the top bar and sees a menu of every downloaded text model with the
active one marked. Choosing another model makes it active for the next message; the conversation
already on screen stays.

**Why this priority**: Comparing local models is a core reason to download several, but chatting
with one model already delivers value.

**Independent Test**: With two text models downloaded, switch between them and send a message
after each switch, confirming the top bar and reply source change.

**Acceptance Scenarios**:

1. **Given** two or more downloaded text models, **When** the user opens the selector, **Then** it
   lists exactly the downloaded text models, with the active one marked.
2. **Given** the selector is open, **When** the user picks a different model, **Then** the top bar
   shows the new model, the device gives a short haptic tick, and the next reply comes from it.
3. **Given** the conversation has messages, **When** the user switches models, **Then** existing
   messages stay visible.
4. **Given** a reply is in progress, **Then** the selector cannot be opened until the reply
   finishes.
5. **Given** a model downloads or is deleted elsewhere, **When** the user next opens the selector,
   **Then** the list reflects it; if the active model was deleted, another downloaded model becomes
   active, or the empty state appears when none remain.
6. **Given** the app is relaunched, **Then** the last chosen model is active again if it is still
   downloaded.

---

### User Story 4 - Move between Chat and Settings smoothly (Priority: P3)

A gear icon on the top right of the chat opens the Model Download & Settings screen with a smooth
transition. The user returns with the back button or the system back gesture, with a matching
reverse transition and the conversation intact.

**Why this priority**: Polish on top of working navigation.

**Independent Test**: Open Settings from the gear, return by back button, then by back gesture, and
check the transition and that messages remain.

**Acceptance Scenarios**:

1. **Given** the chat, **When** the user taps the gear, **Then** the Model Download & Settings
   screen slides in.
2. **Given** the Settings screen, **When** the user taps back or performs the back gesture,
   **Then** the chat slides back with the same conversation and input text it had before.
3. **Given** the chat is the first screen, **When** the user goes back from it, **Then** the app
   exits as with any root screen.
4. **Given** the user taps "use this model" on a downloaded text model in Settings, **Then** the
   app returns to the chat with that model active.

---

### Edge Cases

- Reply generation fails or the model cannot load → the model bubble shows a short error message
  (distinct from the off-topic answer and the form fallback),
  Send re-enables, and the user's message stays.
- Model produces no text → a short "no response" message instead of an empty bubble.
- Very long reply → the bubble wraps and the list keeps scrolling; the input bar is never hidden.
- Keyboard open → the input bar and newest message stay visible above it.
- Rotation or theme change mid-reply → the conversation and in-progress reply are kept.
- Only speech-recognition models downloaded → treated as no model; the empty state shows.
- Device without haptics or with haptic feedback turned off → no vibration, no error.
- Light and dark mode → chat uses the same palette as Settings in both.

## Requirements *(mandatory)*

### Functional Requirements

#### Navigation

- **FR-001**: The chat screen MUST be the first screen shown on launch.
- **FR-002**: The chat top bar MUST show a settings gear at the top right that opens the Model
  Download & Settings screen.
- **FR-003**: The Model Download & Settings screen MUST return to the chat via its back button and
  via the system back gesture, keeping the conversation and unsent input.
- **FR-004**: Choosing "use this model" for a downloaded text model in Settings MUST make it the
  active model and return to the chat.
- **FR-005**: Transitions between Chat and Settings MUST animate (slide or shared element) in both
  directions, including during the back gesture.

#### Model selection

- **FR-006**: The top bar MUST show the active model's name and open a menu listing all downloaded
  text-generation models, marking the active one.
- **FR-007**: Selecting a model MUST make it the active model for subsequent messages without
  clearing the conversation.
- **FR-008**: The active model MUST be remembered across app launches while it remains downloaded;
  otherwise the first downloaded text model in catalog order becomes active.
- **FR-009**: Model selection MUST be unavailable while a reply is in progress.

#### Chat

- **FR-010**: User messages MUST appear as right-aligned bubbles and model replies as left-aligned
  bubbles with distinct colors.
- **FR-011**: Text replies MUST appear progressively (revealed word by word) once available; the
  assistant's model output is a structured intent, so no partial text exists before it completes
  (see plan research R2).
- **FR-012**: A thinking indicator MUST show from Send until the reply is ready.
- **FR-013**: The list MUST keep the newest content visible while a reply is revealed, unless the user
  has scrolled away from the bottom.
- **FR-014**: The input bar MUST contain a text field and a Send button; Send MUST be disabled when
  the input is blank, when a reply is in progress, or when no model is available.
- **FR-015**: A failed reply MUST show a short error in the model bubble and re-enable Send.
- **FR-016**: The chat MUST be the existing Interac e-Transfer assistant (feature 005): balance
  checks, sending, and requesting money keep their current behavior, forms, cards, and rules.
  Plain text replies (for example the off-topic answer) are revealed per FR-011; forms and cards appear
  whole once ready, preceded by the thinking indicator. No general-purpose chat is added.
- **FR-017**: The conversation MUST be kept while the app runs, including across Settings visits,
  rotation, and theme change, and MAY be discarded when the app process ends.

#### Empty state

- **FR-018**: When no text-generation model is downloaded, the chat MUST show an empty-state banner
  with a "Download a Model to Get Started" button that opens the Model Download & Settings screen,
  and MUST NOT accept messages.
- **FR-019**: The chat MUST leave the empty state automatically once a text model is downloaded and
  enter it when the last one is deleted.

#### Look and feel

- **FR-020**: The chat MUST use the same color palette, typography, and top-bar styling as the
  Model Download & Settings screen in light and dark mode.
- **FR-021**: Sending a message and switching models MUST each trigger one short haptic tick,
  respecting the device's haptic setting.
- **FR-022**: All user-visible text MUST be localizable, and the gear, selector, Send, and thinking
  indicator MUST have accessibility labels.

#### Assistant UI refresh

The existing assistant screen is reviewed and restyled, not rebuilt:

- **FR-023**: The top bar MUST drop the back arrow (the chat is the root) and show the model
  selector in the title area and the gear on the right, in the same bar style as Settings.
- **FR-024**: Model-side content (text replies, thinking indicator, fallback and error messages,
  balance cards, forms, confirmations) MUST sit in rounded cards using the same surface color,
  corner radius, and inner spacing as the model cards on the Settings screen; today they render
  directly on the page background.
- **FR-025**: User bubbles MUST use the app's primary accent with readable contrast in light and
  dark mode, and stay visually distinct from model-side cards.
- **FR-026**: The input bar MUST match the Settings search field's shape and colors and use a
  compact send icon button in place of the text "Send" button.
- **FR-027**: Status colors inside forms and cards (alerts, badges, selected options, dividers,
  secondary text) MUST come from the same palette roles the Settings screen uses for the same
  meanings (accent, error, muted text, dividers).
- **FR-028**: Before the first message, the chat MUST show a short welcome with example prompts
  (one each for balance, send, and request) that fill the input when tapped.
- **FR-029**: Spacing between consecutive messages MUST be consistent, with extra separation
  between one exchange and the next.

### Key Entities

- **Chat Message**: author (user or model); for the model, a text reply that may grow while
  being revealed or a banking card/form; state (thinking, revealing, done, failed).
- **Conversation**: ordered chat messages for the current app run.
- **Active Model**: the downloaded text model used for the next reply; persisted choice.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: With a model downloaded, a user can send a first message within 5 seconds of launch
  with no navigation.
- **SC-002**: The thinking indicator appears within 200 ms of tapping Send in 100% of attempts.
- **SC-003**: During the word reveal the newest reply text stays on screen without manual scrolling in
  100% of test runs where the user does not scroll.
- **SC-004**: A first-time user reaches the download screen from launch in one tap.
- **SC-005**: Switching models takes at most two taps and never clears the visible conversation.
- **SC-006**: Returning from Settings preserves 100% of messages and unsent input.
- **SC-007**: Chat and Settings screens use identical background, surface, and top-bar colors in
  both light and dark mode, confirmed by side-by-side screenshot review.
- **SC-008**: Every feature 005 acceptance scenario still passes from the new home screen.
- **SC-009**: A first-time user with a model downloaded starts a banking task in one tap via an
  example prompt.

## Assumptions

- "Model Download & Settings" is the existing model download screen reached via the gear; no new
  settings options are added by this feature.
- Only text-generation models appear in the selector; speech-recognition models are excluded.
- Conversation history lives in memory for the current app run; persistence across launches and
  multiple conversations are out of scope.
- Switching models keeps the visible conversation; whether the new model sees earlier turns as
  context is an implementation choice to settle in planning.
- Haptics use the platform's standard light feedback; no custom vibration patterns.
- All inference stays on the device; no network is needed to chat.
- Message bubbles show plain text; rich formatting (markdown, code blocks) is out of scope.
- The Interac assistant's banking logic, mock data, and form contents are unchanged; only its
  screen chrome, placement as the home screen, and styling change.
- The assistant no longer receives a model from the download screen; it uses the active model.
