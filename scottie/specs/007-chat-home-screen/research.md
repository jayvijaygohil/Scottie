# Research: Chat Window as Home Screen

All decisions verified against the current source and configured versions (Compose 1.13.0-beta01,
Material3 1.5.0-beta01, Circuit + circuitx bundles, Koog 1.3.0).

## R1 — Who owns the list of downloaded text models and the active model

- **Decision**: `ModelDownloadRepository` (feature `modeldownload`) owns both. It gains
  `activeTextModel: StateFlow<String?>` and `selectTextModel(id)`. The implementation persists the
  choice in `SharedPreferences` and resolves it against the catalog: the stored id if that model is
  `Downloaded` and `TEXT`, otherwise the first downloaded text model in catalog order, otherwise
  null. The Interac feature sees this through its own domain contract `TextModelSource`
  (`domain/repository/`), adapted in `di/InteracModule` from `ModelDownloadRepository`, the same
  seam pattern `TextModelDestination` uses today.
- **Rationale**: one owner for "which models exist and which is active", reactive (download
  completion or deletion updates the chat without polling), real catalog names and order, and no
  feature-to-feature import. The download screen's "Use" sets the active model in its own domain.
- **Alternatives rejected**: listing `.litertlm` files in the models dir from the chat presenter
  (not reactive to background completion, no display names, no catalog order); a new `core/ai`
  preference store (splits ownership of model state across two places; presenters would depend on
  infrastructure); DataStore (not installed; one string does not justify a dependency).

## R2 — "Streaming" text replies

- **Decision**: Progressive reveal in the UI. When a `TurnReply.Text` arrives, the bubble reveals
  it word by word (~30 ms per word, `LaunchedEffect` keyed on the turn id, skipped in previews and
  for turns already revealed after rotation). The thinking indicator covers the wait for the
  result. Spec FR-011 amended accordingly.
- **Rationale**: the assistant's model output is a JSON `AssistantIntent`; the only free text is
  its `reply` field (or the off-topic resource). There is no partial text to stream until the JSON
  is complete. Streaming tokens and parsing partial JSON for one short sentence would complicate the
  agent for no user-visible gain.
- **Alternatives rejected**: Koog streaming plus incremental JSON parsing (complex, fragile with
  small on-device models); no animation (fails the requested streaming feel).

## R3 — Chat ↔ Settings transitions

- **Decision**: Keep the existing `GestureNavigationDecorationFactory` in `MainActivity`; it
  already animates push/pop and drives Android predictive back. No shared elements.
- **Rationale**: FR-005 accepts slide transitions; the decoration is already installed and covers
  the back gesture. There is no element common to both screens worth morphing (the gear has no
  counterpart).
- **Alternatives rejected**: `circuit-sharedelements` on the gear/title (installed, but nothing
  meaningful to share).

## R4 — Haptics

- **Decision**: `LocalHapticFeedback.current.performHapticFeedback(...)` in the UI layer:
  `HapticFeedbackType.Confirm` on Send, `HapticFeedbackType.SegmentTick` on selecting a different
  model. These honour the system haptic setting and no-op on devices without a vibrator.
- **Rationale**: platform-native, no permission, no new code paths. Feedback for a tap is
  rendering, not business logic, so it stays in the `Ui` beside the event dispatch.
- **Alternatives rejected**: `Vibrator` service (needs `VIBRATE`, ignores user haptic setting).

## R5 — Auto-scroll

- **Decision**: `LazyListState` in the UI. On a change to the turn count or the last turn's reply
  (including each reveal step), scroll to the last item only if the list was at the bottom before
  the change (`!canScrollForward`) or the change is a new user turn.
- **Rationale**: satisfies FR-013 including "don't yank the user back while reading history".

## R6 — Top bar, selector, and Settings entry

- **Decision**: Extend `core/ui/components/ScottieToolbar`: `onBack` becomes nullable (no back
  arrow when null), add an optional `titleContent` slot and an `actions` slot. The chat passes a
  model selector (name + `ic_chevron_down`, Material3 `DropdownMenu`, active item checked) as
  `titleContent` and a gear `IconButton` (`Icons.Rounded.Settings`, already available via
  `material-icons-extended`) as an action.
- **Rationale**: one bar style for both screens (FR-020, FR-023) without a second toolbar.
- **Navigation to Settings**: a `fun interface ModelSettingsDestination { fun screen(): Screen }`
  in the Interac presentation package, bound in `di/InteracModule` to `ModelDownloadScreen`,
  replacing `TextModelDestination`, which is deleted (its only use, "Use model → open assistant",
  becomes "select model → pop back to chat").

## R7 — Visual refresh of the existing assistant UI

Audit of `InteracAssistantUi` and `a2ui/components/*` against `ModelDownloadUi` /
`ModelDownloadCard`:

| Element | Today | Settings reference | Change |
|---|---|---|---|
| Model-side text | bare text on background | cards: `surface`, 16 dp radius, 16 dp padding | `ReplyCard` wrapper: `surface`, 16 dp radius, 16 dp padding |
| A2UI surfaces (balances, form, confirmation) | flat on background | same cards | wrapped once in the same `ReplyCard` in `Turn()`; components untouched except FR-027 colors |
| User bubble | `primaryContainer` (very pale in light) | accent = `primary` | `primary` / `onPrimary`, 16 dp radius with a 4 dp tail corner |
| Thinking | text "Thinking…" | — | three pulsing dots in a `ReplyCard`, content description from resources |
| Composer | `OutlinedTextField` + text `XelaButton` | `ScottieSearchField`: `surface`, `outlineVariant` 1 dp border, 12 dp radius | same shape/colors, multiline (max 4), round `primary` send icon button (`Icons.AutoMirrored.Rounded.Send`) |
| Toolbar | back + title + subtitle | `ScottieToolbar` | no back; selector title; gear action |
| Badge "Autodeposit" | `tertiaryContainer` (pink) | status badges use `primaryContainer` / `errorContainer` | `primaryContainer` for positive, keep `errorContainer` |
| Empty conversation | blank list | — | welcome card with three example chips filling the input (FR-028) |
| Spacing | 12 dp everywhere | — | 8 dp within a turn, 20 dp between turns (FR-029) |

## R8 — Persistence of the conversation

- **Decision**: unchanged `rememberRetained` state in the presenter. With the chat as the back-stack
  root it is never popped, so turns and input survive Settings visits, rotation, and theme change.

## R9 — Missing model

- **Decision**: replace the presenter's `File(modelsDir, id).exists()` check with
  `activeModel == null` from `TextModelSource`; `missingModel` becomes the empty state with the
  "Download a Model to Get Started" button. The `@Named("liteRtModelsDir")` injection is removed
  from the presenter.
