# Feature Specification: Relocate Model Selection & Update Chat Header Actions

**Feature Branch**: `011-relocate-model-selector`

**Created**: 2026-10-14

**Status**: Draft

**Input**: User description: "Relocate model selection from the Chat page to the Settings page. In the chat header, replace the model selector with the 'Scootie' logo text, and configure a long-press gesture on the logo to navigate to Settings. Replace the existing Settings icon with a Clear Chat/Context action button."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Select the active chat model from the Settings page (Priority: P1)

A user wants to view or change which AI model answers their chat messages. Instead of picking a model from the Chat screen header, the user opens the Settings page, where the active model selector is prominently displayed. The selector lists all available text models—downloaded on-device text models followed by selected remote OpenRouter models (marked as remote)—and highlights the currently active model. When the user chooses a different model from the selector, it becomes the active model immediately, persists across app restarts, and is used for the next message sent in Chat.

**Why this priority**: Relocating model selection to Settings is the core structural change of this feature; without it, users would have no way to switch between downloaded local models and selected remote OpenRouter models once the selector is removed from the Chat header.

**Independent Test**: With at least one downloaded local text model and/or checked remote OpenRouter model, open Settings, use the relocated model selector to switch the active model, return to Chat, send a message, and verify that the newly selected model handles the request and remains selected after relaunching the app.

**Acceptance Scenarios**:

1. **Given** one or more text models are available (downloaded on-device text models and/or checked OpenRouter remote models), **When** the user opens the Settings page, **Then** the Settings page displays the active model selector showing the currently active model's name (and remote badge if applicable) and no model selector is shown in the Chat header.
2. **Given** multiple available text models in Settings, **When** the user opens the model selector and chooses a different model, **Then** the device gives a short haptic tick, the chosen model is marked active and persisted on the device, and returning to Chat uses that model for subsequent messages.
3. **Given** both downloaded on-device text models and checked OpenRouter remote models exist, **When** the user opens the model selector in Settings, **Then** downloaded on-device text models are listed first, followed by checked OpenRouter models marked as remote.
4. **Given** no on-device text model is downloaded and no OpenRouter model is selected, **When** the user views the Settings page, **Then** the model selector indicates that no model is currently available and cannot be opened until at least one model is downloaded or selected.
5. **Given** the currently active model is deleted or unselected in Settings, **When** the change completes, **Then** the active model automatically falls back to the first remaining local text model, or the first selected remote model if no local model remains, or none if no models remain.

---

### User Story 2 - Navigate to Settings via long-press on the 'Scootie' header logo (Priority: P1)

When the user is on the Chat page, the top header displays the `'Scootie'` brand logo text in place of the former model selector, and the former Settings gear/tune icon button is no longer present. To open Settings, the user performs a long-press gesture on the `'Scootie'` logo in the chat header. A single tap on the logo does nothing, keeping the chat header clean and preventing accidental navigation.

**Why this priority**: Because the dedicated Settings icon button is replaced by the Clear Chat/Context button, the long-press gesture on the `'Scootie'` logo becomes the primary navigation path from an active chat session to the Settings page.

**Independent Test**: Launch the app into the Chat screen, verify the header shows `'Scootie'` logo text without a model dropdown, tap it once to confirm it does not navigate, then long-press `'Scootie'` to confirm it navigates to the Settings page and back navigation returns to Chat.

**Acceptance Scenarios**:

1. **Given** the user is on the Chat page, **When** the header renders, **Then** the `'Scootie'` logo text is displayed in the header title area and the model selector dropdown is not present.
2. **Given** the user is on the Chat page, **When** the user long-presses the `'Scootie'` logo in the header, **Then** the device provides haptic feedback and navigates to the Settings page.
3. **Given** the user is on the Chat page, **When** the user performs a normal single tap on the `'Scootie'` logo, **Then** no navigation or dropdown menu is triggered.
4. **Given** no text model is available and the Chat page shows the empty-state banner, **When** the user either taps the "Download a Model to Get Started" button or long-presses the `'Scootie'` logo in the header, **Then** the app navigates to the Settings page.

---

### User Story 3 - Clear chat history and conversation context from the Chat header (Priority: P1)

While using the Chat page, the user wants to wipe the current conversation and start fresh. In the top-right action area of the Chat header (replacing the former Settings icon), the user taps the Clear Chat/Context action button. All message turns, assistant replies, and rendered interactive cards/surfaces from the current session are removed, conversation state is reset, and the Chat page returns to its initial Welcome state.

**Why this priority**: Replacing the Settings action icon with a one-tap Clear Chat/Context action gives users an immediate way to reset the assistant conversation and screen state without restarting the app.

**Independent Test**: Send one or more messages in Chat (including a text reply and an interactive banking card/form), tap the Clear Chat/Context button in the top-right header, and verify all turns and cards disappear and the Welcome view is restored.

**Acceptance Scenarios**:

1. **Given** the Chat page has at least one completed conversation turn and no reply is currently in progress, **When** the user taps the Clear Chat/Context button in the header, **Then** all conversation turns, interactive surfaces, and in-memory conversation context are cleared, and the Welcome state is displayed.
2. **Given** the user has typed unsent text in the message composer along with existing conversation turns, **When** the user taps the Clear Chat/Context button, **Then** the conversation turns and unsent composer text are cleared.
3. **Given** the Chat page has no conversation turns (initial Welcome state or empty-model state) or a reply is currently in progress, **When** the header renders, **Then** the Clear Chat/Context button is disabled so it cannot be triggered while idle with nothing to clear or during an in-flight reply.
4. **Given** the user clears the chat, **When** the user subsequently sends a new message, **Then** the assistant processes the new message as the first turn of a fresh conversation using the currently active model.

---

### Edge Cases

- **Long-press while a reply is in progress**: Long-pressing the `'Scootie'` logo navigates to Settings even if a reply was in progress, or preserves chat state on return without crashing.
- **Clearing chat after interactive form/card state**: Clearing the chat removes all rendered interactive surfaces (balance cards, transfer/request forms, transaction lists, confirmations) so stale surface IDs or form drafts do not leak into subsequent turns.
- **Account and transaction ledger persistence within session**: Clearing the chat/context resets the conversation history, rendered surfaces, and composer input, while keeping completed mock banking state (such as account balances and recorded transfers) intact for the session.
- **Accessibility for long-press navigation**: Screen reader and accessibility services expose a clear action/label on the `'Scootie'` header logo indicating that long-pressing opens Model Settings.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The Chat page header MUST NOT display the model selector dropdown; instead, it MUST display the `'Scootie'` logo text (with its accompanying brand icon/header styling) in the title area.
- **FR-002**: The `'Scootie'` logo in the Chat page header MUST respond to a long-press gesture by providing haptic feedback and navigating to the Settings page, and MUST ignore single taps.
- **FR-003**: The Chat page header's trailing action slot MUST replace the Settings icon button with a Clear Chat/Context action button with an appropriate icon and accessible content description.
- **FR-004**: Tapping the Clear Chat/Context action button MUST clear all conversation turns, discard all rendered interactive surfaces/cards for the conversation, clear any unsent composer input, and return the Chat page to the Welcome state.
- **FR-005**: The Clear Chat/Context action button MUST be enabled only when there is at least one conversation turn (or non-blank composer input) and no assistant reply is currently in progress (`!busy`), and disabled otherwise.
- **FR-006**: The active model selector MUST be displayed on the Settings page, allowing the user to view the currently active text model and switch among all available text models (downloaded on-device text models listed first, followed by checked OpenRouter remote models marked as remote).
- **FR-007**: Selecting a model in the Settings page's model selector MUST immediately update and persist the active model selection across the app, matching the existing persistence and fallback behavior from features 007–009.
- **FR-008**: When a user switches the active model in Settings and returns to the Chat page, existing chat turns (if not cleared) MUST remain visible and subsequent messages MUST be routed to the newly selected model.
- **FR-009**: The `'Scootie'` header logo and Clear Chat/Context button MUST provide localizable string resources and accessibility semantics so assistive technologies can discover both the Clear Chat/Context action and the long-press Settings navigation action.

### Key Entities

- **Active Model Selection**: The persisted identifier of the currently selected text model (either a downloaded on-device text model or a checked OpenRouter remote model), now viewed and changed from the Settings page rather than the Chat header.
- **Conversation Session State**: The in-memory list of user/assistant turns, active interactive UI surfaces, and draft composer text on the Chat page, which is reset to its initial empty state when the Clear Chat/Context action is triggered.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: Users can view and switch the active text model (across both local downloaded models and selected remote OpenRouter models) from the Settings page in under 5 seconds, with 100% of subsequent chat messages routed to the newly chosen model.
- **SC-002**: Long-pressing the `'Scootie'` logo in the Chat header navigates to the Settings page in 100% of attempts, while single-tapping the logo triggers 0 unintended navigations or popups.
- **SC-003**: Tapping the Clear Chat/Context button removes 100% of displayed conversation turns, interactive surfaces, and draft input in a single tap and restores the Welcome state immediately.
- **SC-004**: All existing chat, model download, and OpenRouter model selection behaviors (fallback when a model is removed, persistence across relaunch, and empty-state onboarding when no model is available) continue to pass with 0 regressions.

## Assumptions

- The brand text in the chat header is rendered literally as `'Scootie'` as specified in the user request, styled with the existing toolbar brand icon and typography.
- The relocated model selector on the Settings page reuses the existing model selector pattern (showing active model name, status dot, remote badge when applicable, and dropdown menu of available local and remote text models) placed at the top of the Settings page content so users can switch between local and remote models in one place, while the existing "Use in chat" convenience action on downloaded local text model cards may remain or stay synchronized with the same active model state.
- Clearing chat/context clears the conversation turns, interactive surfaces, and composer input (and any conversation-level memory), while each request continues to use a fresh agent invocation and in-memory banking account balances/transactions remain intact for the session.
