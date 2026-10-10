# Feature Specification: OpenRouter API Support

**Feature Branch**: `008-openrouter-api-support`

**Created**: 2026-10-10

**Status**: Draft

**Input**: User description: "Add OpenRouter API Support using OpenRouterLLMClient. Currently the
application only supports edge models. Extend capabilities by introducing support for the
OpenRouter API using the pre-existing OpenRouterLLMClient provided by Koog. UI additions on the
Download screen: a Base URL input for the OpenRouter endpoint, an API Key input (may be empty), and a
Models List text input accepting one or more model strings separated by semicolons (for example
`anthropic/claude-3.5-sonnet;openai/gpt-4o`). Actions: Save validates and persists the credentials
and model configuration offline; Delete clears the saved OpenRouter configuration. Integration:
parse the semicolon-separated string into discrete model options for the UI, and pass the stored
credentials and selected model to the OpenRouter client when making OpenRouter requests."

## Clarifications

### Session 2026-10-10

- Q: Which URL schemes should the Base URL field accept? → A: Both `http` and `https`, for any
  host. Plain `http` requests must actually be sent, not blocked by the device's default
  cleartext policy.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Configure OpenRouter from the Download screen (Priority: P1)

The user opens the Model Download & Settings screen and finds an "OpenRouter" section beneath the
on-device model list. It has three fields: Base URL (prefilled with the standard OpenRouter
endpoint), API Key (masked, optional), and Models (one or more model identifiers separated by
semicolons). The user enters their key and `anthropic/claude-3.5-sonnet;openai/gpt-4o`, taps Save,
and sees a confirmation. The configuration survives closing and reopening the app, with no network
needed to save it.

**Why this priority**: Without a saved configuration nothing else in this feature can work; this is
the entry point for every remote-model use.

**Independent Test**: With the network off, open Settings, fill the three fields, tap Save, kill
and relaunch the app, reopen Settings, and confirm the same values are shown (key masked).

**Acceptance Scenarios**:

1. **Given** no OpenRouter configuration exists, **When** the user opens Settings, **Then** the
   OpenRouter section shows the Base URL prefilled with the standard endpoint, an empty masked API
   Key field, an empty Models field, an enabled Save button, and no Delete button.
2. **Given** valid entries in all fields, **When** the user taps Save, **Then** the values are
   stored on the device, a short confirmation is shown, and the Delete button appears.
3. **Given** the API Key field is empty but Base URL and Models are valid, **When** the user taps
   Save, **Then** the configuration is saved without error.
4. **Given** a saved configuration, **When** the app is relaunched and Settings reopened, **Then**
   the saved Base URL and Models are shown and the API Key field shows a masked value.
5. **Given** a saved configuration, **When** the user edits any field and taps Save, **Then** the
   stored configuration is replaced with the new values.
6. **Given** the device has no network connection, **When** the user taps Save, **Then** saving
   still succeeds.

---

### User Story 2 - Chat with an OpenRouter model (Priority: P1)

After saving a configuration listing two models, the user returns to the chat. The model selector
in the top bar now lists the two OpenRouter models after the downloaded on-device models, each
visibly marked as remote. The user picks `openai/gpt-4o`, sends a message, and the reply comes from
that remote model using the saved key and endpoint. Switching back to an on-device model continues
to work as before.

**Why this priority**: This is the value the feature delivers; configuration alone is useless
without being able to chat through it.

**Independent Test**: Save a configuration with a working key and two models, select each in turn
from the chat selector, send a message after each selection, and confirm a reply arrives from the
remote service; then select a downloaded on-device model and confirm it still answers.

**Acceptance Scenarios**:

1. **Given** a saved configuration with N models, **When** the user opens the chat model selector,
   **Then** every downloaded on-device text model is listed first, followed by exactly N OpenRouter
   entries, each marked as remote.
2. **Given** an OpenRouter model is selected, **When** the user sends a message, **Then** the
   request goes to the saved Base URL with the saved API Key and the selected model identifier, and
   the reply is shown in the chat exactly as a local reply would be.
3. **Given** an OpenRouter model is selected and the device is offline, **When** the user sends a
   message, **Then** the model bubble shows a short connection error, the user's message stays, and
   Send re-enables.
4. **Given** an OpenRouter model is selected and the saved key is missing or rejected, **When** the
   user sends a message, **Then** the model bubble shows a short authentication error pointing the
   user to Settings, and Send re-enables.
5. **Given** an OpenRouter model is the active model, **When** the app is relaunched, **Then** it is
   still the active model as long as the configuration still lists it.
6. **Given** no on-device model is downloaded but an OpenRouter configuration with at least one
   model is saved, **When** the app launches, **Then** the chat is usable with the first OpenRouter
   model active instead of showing the "download a model" empty state.

---

### User Story 3 - Remove the OpenRouter configuration (Priority: P2)

The user decides to stop using remote models. In Settings they tap Delete in the OpenRouter section,
confirm, and the fields reset to their defaults. The remote models disappear from the chat selector.
If one of them was active, the chat falls back to a downloaded on-device model, or to the empty
state when none is downloaded.

**Why this priority**: Users must be able to remove a stored key from the device; it completes the
lifecycle but delivers no value on its own.

**Independent Test**: With a saved configuration and a remote model active, tap Delete, confirm, and
check the fields reset, the selector lists only on-device models, and the chat picks a local model
or shows the empty state.

**Acceptance Scenarios**:

1. **Given** a saved configuration, **When** the user taps Delete, **Then** a confirmation is asked
   before anything is removed.
2. **Given** the user confirms deletion, **Then** the stored Base URL, API Key, and Models are
   removed from the device, the fields return to their defaults, and the Delete button disappears.
3. **Given** the configuration is deleted, **When** the user opens the chat model selector, **Then**
   no OpenRouter entries are listed.
4. **Given** the active model was an OpenRouter model, **When** the configuration is deleted,
   **Then** the first downloaded on-device text model becomes active, or the empty state appears if
   none is downloaded.
5. **Given** the user cancels the confirmation, **Then** nothing changes.

---

### User Story 4 - Validation guides the user to a correct configuration (Priority: P2)

The user mistypes the endpoint or leaves the Models field blank. Tapping Save shows a clear message
next to the offending field and nothing is stored until the problem is fixed. Extra spaces and a
trailing semicolon in the Models field are tolerated.

**Why this priority**: Prevents a broken configuration that would only fail later during a chat,
but a careful user can succeed without it.

**Independent Test**: Try to save with an empty URL, a non-URL string, a blank Models field, and
`a/b; ;c/d;` in turn; observe the errors for the first three and that the fourth saves as two
models.

**Acceptance Scenarios**:

1. **Given** the Base URL is empty or is not a well-formed web address, **When** the user taps Save,
   **Then** an error is shown on the Base URL field and nothing is stored.
2. **Given** the Models field is empty or contains only separators and whitespace, **When** the user
   taps Save, **Then** an error is shown on the Models field and nothing is stored.
3. **Given** the Models field contains `anthropic/claude-3.5-sonnet ; openai/gpt-4o;`, **When** the
   user taps Save, **Then** exactly two models are stored with surrounding whitespace removed and
   the empty trailing entry ignored.
4. **Given** the Models field lists the same identifier twice, **When** the user taps Save, **Then**
   the duplicate is stored once.
5. **Given** a field error is shown, **When** the user corrects the field, **Then** the error clears
   and Save succeeds.

---

### Edge Cases

- Configuration saved with an empty API Key and a remote model selected → request is attempted; the
  service's rejection is shown as the authentication error from User Story 2.
- Models list edited to drop the currently active remote model → on Save, the first remaining
  OpenRouter model becomes active, or a local model if the list is now shorter and the active one
  is gone; the conversation on screen is kept.
- A model identifier the service does not recognize → the reply fails with a short "model not
  available" message in the model bubble; the identifier stays in the list for the user to fix.
- Very long key or model list → fields scroll; nothing is truncated on save.
- Base URL entered without a scheme (for example `openrouter.ai/api/v1`) → treated as invalid; the
  error message suggests including `http://` or `https://`.
- Base URL using plain `http` (for example a local gateway at `http://192.168.1.20:8080`) → accepted
  on save and requests are sent over plain HTTP; no device policy blocks them.
- Base URL with a trailing slash → accepted and saved as typed.
- Rotation or theme change while editing → unsaved field contents are kept.
- Request takes a long time → the existing thinking indicator keeps showing; Send stays disabled
  until the reply arrives or fails.
- The API Key is never written to logs, shown unmasked by default, or included in error messages.
- Banking forms and cards produced by the assistant work identically whether the model is local or
  remote.

## Requirements *(mandatory)*

### Functional Requirements

#### Configuration entry

- **FR-001**: The Model Download & Settings screen MUST show an OpenRouter section with three
  inputs: Base URL, API Key, and Models.
- **FR-002**: The Base URL field MUST be prefilled with the standard OpenRouter endpoint when no
  configuration is saved.
- **FR-003**: The API Key field MUST mask its contents by default and MAY offer a show/hide toggle.
- **FR-004**: The Models field MUST accept one or more model identifiers separated by semicolons.
- **FR-005**: Saving MUST split the Models text on semicolons, trim whitespace from each part, drop
  empty parts, and drop duplicates while keeping first-seen order.
- **FR-006**: Saving MUST accept a well-formed `http` or `https` web address for any host as the
  Base URL, MUST reject an empty Base URL or one with any other or missing scheme, and MUST reject
  a Models field that yields zero identifiers, showing a field-level error in each case and storing
  nothing.
- **FR-006a**: When the saved Base URL uses `http`, remote requests MUST be sent over plain HTTP;
  the app MUST permit cleartext traffic so these requests are not blocked by the platform's default
  policy.
- **FR-007**: An empty API Key MUST be accepted on save.
- **FR-008**: Saving MUST store the Base URL, API Key, and model list on the device only, without any
  network access, and replace any previously saved configuration.
- **FR-009**: Exactly one OpenRouter configuration exists at a time.
- **FR-010**: Saved values MUST be shown again when the screen is reopened, including after an app
  relaunch, with the key masked.
- **FR-011**: A Delete action MUST be shown only when a configuration is saved, MUST ask for
  confirmation, and on confirmation MUST remove all stored OpenRouter values and reset the fields to
  defaults.
- **FR-012**: The API Key MUST NOT appear in logs, crash reports, or user-visible error text.

#### Model availability

- **FR-013**: Each saved model identifier MUST appear as a selectable model in the chat's model
  selector, listed after the downloaded on-device text models and visibly marked as remote.
- **FR-014**: OpenRouter models MUST NOT appear in the download list and MUST NOT be downloadable;
  they have no size, progress, or storage footprint.
- **FR-015**: When at least one OpenRouter model is configured, the chat MUST be usable even if no
  on-device model is downloaded; the empty state MUST appear only when neither kind is available.
- **FR-016**: Selecting a remote model MUST be remembered across launches while the configuration
  still lists it, following the same rules as the active on-device model.
- **FR-017**: When the active remote model is removed (by Delete or by editing the list), the first
  remaining model in selector order MUST become active, or the empty state MUST appear when none
  remain. The visible conversation is kept.

#### Request routing

- **FR-018**: When a remote model is active, each assistant request MUST be sent to the saved Base
  URL, authenticated with the saved API Key, and addressed to the selected model identifier.
- **FR-019**: When an on-device model is active, behavior MUST be unchanged from before this
  feature and MUST NOT contact any network service.
- **FR-020**: Replies from a remote model MUST render through the same chat bubbles, thinking
  indicator, banking forms, and cards as local replies.
- **FR-021**: Remote request failures MUST be shown as a short message in the model bubble that
  distinguishes at least: no connection, authentication rejected, model not available, and other
  failure. Send MUST re-enable and the user's message MUST stay.

#### Look, feel, and copy

- **FR-022**: The OpenRouter section MUST use the Settings screen's existing field styling, card
  surface, spacing, and palette in light and dark mode.
- **FR-023**: All user-visible text, including field labels, hints, errors, confirmations, and the
  remote marker, MUST be localizable, and all interactive elements MUST have accessibility labels.

### Key Entities

- **OpenRouter Configuration**: the single saved set of Base URL, API Key (possibly empty), and an
  ordered list of unique model identifiers.
- **Remote Model**: one model identifier from the configuration, selectable in the chat alongside
  downloaded on-device models; has no download state.
- **Active Model**: extended from feature 007 to be either a downloaded on-device model or a remote
  model.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user can save a working OpenRouter configuration in under 1 minute from opening
  Settings, with no network connection.
- **SC-002**: 100% of saved configurations are shown unchanged (key masked) after an app relaunch.
- **SC-003**: Every identifier in a saved list appears in the chat selector; the count of remote
  entries equals the count of unique, non-empty identifiers in 100% of test inputs.
- **SC-004**: With a valid key and a reachable service, a message sent to a remote model receives a
  rendered reply, and the thinking indicator appears within 200 ms of tapping Send.
- **SC-005**: Invalid Base URL or empty Models input is rejected with a field-level message in 100%
  of attempts, and nothing is stored.
- **SC-006**: After Delete, zero remote entries remain in the selector and no OpenRouter values
  remain on the device.
- **SC-007**: Every feature 005 and 007 acceptance scenario still passes with an on-device model
  active, and the banking scenarios of feature 005 also pass with a remote model active.
- **SC-008**: The API Key never appears in captured logs during a full test run.

## Assumptions

- "Download screen" is the existing Model Download & Settings screen reached from the chat's gear
  icon; the OpenRouter section is added to it rather than to a new screen.
- "Model options for the UI/download queue" is interpreted as: remote models become selectable
  models in the chat's selector. They are not queued or downloaded, since nothing is fetched to the
  device.
- The standard OpenRouter endpoint is the prefilled default; the field stays editable for proxies or
  compatible gateways, including plain `http` ones such as a gateway on the local network. The user
  accepts that an `http` endpoint sends the API key unencrypted; the app does not warn about it.
- An empty API Key is allowed on save so the user can prepare the model list first; the service is
  expected to reject unauthenticated requests, and that rejection is surfaced as an error.
- Configuration is stored on the device in app-private storage. Encrypting the key at rest is a
  planning decision; the spec only requires it never be exposed in logs or error text.
- Model identifiers are stored as typed (after trimming); the app does not validate them against
  the remote catalog before use.
- One configuration at a time is sufficient; multiple named profiles are out of scope.
- The remote model is used for the existing Interac assistant conversation; no new chat
  capabilities, streaming of partial text, or general-purpose chat are added by this feature.
- Remote requests need network connectivity; the app does not cache or queue messages for later.
- Cost, usage limits, and billing shown by the remote service are out of scope.
- The remote client provided by the already-installed agent framework is reused; no new networking
  library is introduced.
