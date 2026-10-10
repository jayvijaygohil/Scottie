# Feature Specification: OpenRouter Model Picker

**Feature Branch**: `009-openrouter-model-picker`

**Created**: 2026-10-10

**Status**: Draft

**Input**: User description: "Instead of putting a model id slug for open router, once the user
saves the url and key (optional), we make an API request to get the model ids available in a list
from which I can select multiple." Example service response: a `data` array of models, each with
`id` (for example `anthropic/claude-haiku-5.5`), `name` (for example `Anthropic: Claude Haiku
5.5`), `architecture.output_modalities`, plus pricing and other fields; and a `links.next` value
that is `null` on the last page. Follow-up: "Move the API section at the top and all the sections
should accordion should be collapsed by default."

## Clarifications

### Session 2026-10-10

- Q: When the user expands a section in Settings, should it stay expanded the next time they open
  Settings? → A: No. Every visit starts with all sections collapsed; expand/collapse choices
  survive rotation and theme changes but not leaving Settings or relaunching.
- Q: When the user types in the Settings search box at the top, should model sections that contain
  matches open automatically even though they start collapsed? → A: Yes. While the search has text,
  sections with matches open; clearing it restores the user's own expand/collapse choices.
- Q: If on-device models can't run on this phone, Settings shows only the OpenRouter section.
  Should that section also start collapsed? → A: No. When OpenRouter is the only section, it is
  shown open, as today.

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Pick remote models from the fetched list (Priority: P1)

In the OpenRouter section of Settings the user enters the Base URL and an optional API Key and taps
Save. The typed Models field from feature 008 is gone. After saving, the app asks the service for
its available models and shows them as a checkable list, with each model's display name and its
identifier. The user checks two models. Those two models then appear in the chat's model selector,
marked as remote, exactly as typed identifiers did in feature 008.

**Why this priority**: This replaces error-prone manual typing of identifiers and is the whole
feature.

**Independent Test**: With a reachable service, save the URL and key, wait for the list, check two
models, return to the chat, and confirm the selector lists exactly those two as remote and a
message to each gets a reply.

**Acceptance Scenarios**:

1. **Given** no configuration is saved, **When** the user opens Settings and expands the OpenRouter
   section, **Then** it shows Base URL (prefilled with the standard endpoint) and API Key, no Models text field,
   and no model list.
2. **Given** a valid Base URL, **When** the user taps Save, **Then** the URL and key are stored and
   the app immediately requests the service's model list, showing a loading indicator.
3. **Given** the service returns models, **Then** each model that can produce text is shown once
   with its display name and identifier, sorted by display name, all unchecked on first fetch.
4. **Given** the list is shown, **When** the user checks or unchecks a model, **Then** the selection
   is stored on the device immediately, and the chat selector reflects it the next time it opens.
5. **Given** at least one model is checked, **When** the user opens the chat selector, **Then** the
   checked models are listed after the on-device models, marked remote, in the order they appear in
   the fetched list.
6. **Given** the service returns more than one page of results, **Then** all pages are loaded and
   shown as one list.

---

### User Story 2 - Find a model in a long list (Priority: P2)

The service offers hundreds of models. Above the list the user types `haiku` into a search field and
the list narrows to models whose name or identifier contains that text, ignoring case. Checked
models stay checked when hidden by the filter.

**Why this priority**: Without filtering, picking from hundreds of entries is slow, but selection
still works by scrolling.

**Independent Test**: With a fetched list, type a fragment of one model's identifier, confirm only
matching entries show, check one, clear the search, and confirm it is still checked.

**Acceptance Scenarios**:

1. **Given** a fetched list, **When** the user types text in the search field, **Then** only models
   whose display name or identifier contains that text (case-insensitive) are shown.
2. **Given** a search with no matches, **Then** a short "no models match" message is shown.
3. **Given** checked models hidden by the filter, **When** the search is cleared, **Then** they are
   still shown as checked.

---

### User Story 3 - Recover when the list cannot be fetched (Priority: P2)

The user saves while offline, or with a wrong URL or rejected key. The configuration is still saved,
and in place of the list a short error with a Retry button appears. Models the user checked earlier
stay available in the chat.

**Why this priority**: Fetch failures are common (offline, typo, bad key); the user needs a way
forward without losing earlier choices.

**Independent Test**: With the network off, tap Save; see the error and Retry; turn the network on,
tap Retry, and see the list.

**Acceptance Scenarios**:

1. **Given** no connection, **When** the user taps Save, **Then** the URL and key are still stored
   and a "couldn't reach the service" error with Retry is shown.
2. **Given** the service rejects the key, **Then** an authentication error pointing to the API Key
   field is shown with Retry.
3. **Given** any fetch error, **When** the user taps Retry, **Then** the list is requested again.
4. **Given** models were checked before and a later fetch fails, **Then** the checked models remain
   stored and remain in the chat selector.
5. **Given** a saved configuration, **When** the user reopens Settings, **Then** the list is fetched
   again so it reflects the service's current models, with stored selections pre-checked.

---

### Edge Cases

- A previously checked model no longer appears in a successful fetch → it is removed from the
  selection and from the chat selector; if it was the active model, the 008 fallback rule applies.
- The service returns zero text-capable models → a short "no models available" message is shown
  and nothing is selectable.
- Entries without an identifier are skipped; an entry without a display name shows its identifier.
- Duplicate identifiers across pages are shown once.
- Existing 008 configurations with typed model identifiers → the typed identifiers become the
  initial selection; any that the next successful fetch does not contain are dropped as above.
- Changing the Base URL or API Key and saving again → the list is re-fetched; selections still
  offered by the new list stay checked, others are dropped.
- Zero models checked → no remote entries in the chat selector; the 008 empty-state and fallback
  rules apply.
- Delete (from 008) also clears the selection and hides the list.
- Rotation or theme change while the list is shown → search text, scroll position, and checks are
  kept.
- The API Key never appears in logs or in fetch error text.
- On-device runtime unavailable → OpenRouter is the only section and is shown open, not collapsed.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The OpenRouter section MUST no longer offer a free-text Models field; Base URL and API
  Key validation and storage from feature 008 are unchanged, except that a Models entry is no
  longer required to save.
- **FR-002**: After a successful Save, and whenever Settings opens with a saved configuration, the
  app MUST request the list of available models from the saved Base URL using the saved API Key
  (none if empty).
- **FR-003**: The app MUST load every page of results until the service reports no next page.
- **FR-004**: The list MUST include only models whose output includes text, each shown once, with
  display name and identifier, sorted by display name.
- **FR-005**: The user MUST be able to check and uncheck any number of models; each change MUST be
  stored on the device immediately and survive relaunch.
- **FR-006**: Checked models MUST be the remote models offered in the chat selector, replacing the
  typed list of feature 008 with identical chat behavior (marking, ordering after on-device models,
  persistence of the active model, fallback, request routing, error display).
- **FR-007**: A search field MUST filter the visible list by case-insensitive substring match on
  display name or identifier without changing the selection.
- **FR-008**: While fetching, a loading indicator MUST be shown; on failure, a short message
  distinguishing no connection, authentication rejected, and other failure MUST be shown with a
  Retry action.
- **FR-009**: Saving the URL and key MUST succeed without a network connection; a failed fetch MUST
  NOT discard the saved configuration or the stored selection.
- **FR-010**: After a successful fetch, stored selections not present in the result MUST be removed.
- **FR-011**: Existing typed model identifiers from feature 008 MUST be kept as the initial
  selection.
- **FR-012**: Delete MUST also remove the stored selection.
- **FR-013**: The API Key MUST NOT appear in logs or user-visible error text.
- **FR-014**: All new user-visible text MUST be localizable; the search field, each checkbox row,
  and Retry MUST have accessibility labels; styling MUST follow the existing Settings screen in
  light and dark mode.
- **FR-015**: The OpenRouter section MUST be the first section in Settings, above the on-device
  model sections.
- **FR-016**: Every Settings section MUST be collapsed each time Settings opens, except when the
  on-device runtime is unavailable and OpenRouter is the only section, which is shown open.
  Expand/collapse choices MUST survive rotation and theme changes during a visit and MUST NOT be
  stored across visits or relaunches. While the Settings search has text, sections containing
  matches MUST be shown expanded; clearing the search MUST restore the user's expand/collapse
  choices.

### Key Entities

- **Available Model**: one entry from the service's list: identifier, display name, and whether it
  produces text. Not stored; re-fetched each time.
- **Model Selection**: the stored ordered set of checked identifiers; replaces feature 008's typed
  model list as part of the OpenRouter Configuration.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user can save the URL and key and check a model in under 30 seconds, without typing
  any model identifier.
- **SC-002**: With a reachable service, the list appears within 3 seconds of tapping Save on a
  typical connection.
- **SC-003**: The number of remote entries in the chat selector equals the number of checked models
  in 100% of tests.
- **SC-004**: Search narrows a list of 300+ models to matching entries as the user types, with no
  visible delay.
- **SC-005**: In 100% of fetch-failure tests, the saved URL, key, and previous selection are intact
  and Retry recovers once the cause is fixed.
- **SC-006**: All feature 008 chat acceptance scenarios still pass using picked rather than typed
  models.

## Assumptions

- The model list lives at the service's standard models listing under the saved Base URL, and its
  response shape matches the example given (`data[].id`, `data[].name`,
  `data[].architecture.output_modalities`, `links.next`).
- Pricing, context length, descriptions, benchmarks, and reasoning options in the response are not
  shown; they are out of scope.
- The fetched list is not cached on the device; it is re-requested each time Settings opens.
  Selections are stored, so chat keeps its remote models across relaunches and when a fetch fails.
- The list is shown inline in the existing OpenRouter section of Settings, not on a new screen.
- Ordering of remote models in the chat selector follows the fetched list order (by display name),
  since the user no longer types an order.
- The multi-select list is the only way to choose remote models; manually typing an identifier the
  service does not list is no longer supported.
