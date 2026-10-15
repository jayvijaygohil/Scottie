# Research: Relocate Model Selection & Update Chat Header Actions

**Feature**: `011-relocate-model-selector`
**Date**: 2026-10-14

## R1. Relocating Active Model Selection to Settings (`feature/modeldownload`)

- **Decision**: Move the `ModelSelector` UI component and active-model switching flow from the Chat screen (`feature/interacbanking`) to the Settings screen (`feature/modeldownload`). `ModelDownloadPresenter` already injects both `ModelDownloadRepository` and `OpenRouterConfigRepository`; it will combine downloaded `ModelType.TEXT` entries from `repository.catalog`, saved remote model IDs from `openRouter.config`, and `repository.activeTextModel` to expose `models: List<TextModelOption>` and `activeModelId: String?` on `ModelDownloadState`, handling `ModelDownloadAction.SelectModel(id)` via `repository.selectTextModel(id)`.
- **Rationale**:
  - Respects Principle I (Layered Clean Architecture) and Principle V (Simplicity): `feature/modeldownload` already owns both repositories that determine available local and remote models and the persisted active model file. Computing the selectable model list in `ModelDownloadPresenter` requires zero new repositories, use cases, or cross-feature dependencies.
  - Because `ModelSelector` is only rendered on the Settings screen after this change, moving it to `feature/modeldownload` avoids premature promotion to `core/ui/components/` and lets `feature/interacbanking` drop unused model-list state (`models`) and action (`SelectModel`), keeping only `active: Flow<String?>` on `TextModelSource`.
- **Alternatives considered**:
  - *Move `ModelSelector` into `core/ui/components/`*: Rejected because Principle V states that shared UI components move to `core/ui/components/` only after real reuse by two or more features.
  - *Rely solely on per-card "Use in chat" buttons without a selector*: Rejected because OpenRouter remote models use checkboxes to control inclusion in the available pool rather than single-active selection, and a unified selector in Settings lets users see and switch the active model across both local and remote models in one place.

## R2. Long-Press Gesture on the `'Scootie'` Header Logo

- **Decision**: Replace `ModelSelector` in `InteracAssistantUi`'s `ScottieToolbar` `titleContent` slot with a brand logo header composable displaying the `'Scootie'` logo text (`R.string.chat_header_logo`). Configure `Modifier.combinedClickable(onClick = {}, onLongClickLabel = stringResource(R.string.chat_settings), onLongClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress); state.eventSink(InteracAssistantAction.OpenSettings) })` and `Modifier.testTag(TAG_LOGO)`.
- **Rationale**:
  - `combinedClickable` from `androidx.compose.foundation` natively distinguishes single taps (`onClick = {}`, no-op) from long presses (`onLongClick`), automatically registers the accessibility `OnLongClick` semantics action with `onLongClickLabel` for TalkBack, and supports `performTouchInput { longClick() }` in Compose UI tests.
  - Triggering `HapticFeedbackType.LongPress` before dispatching `InteracAssistantAction.OpenSettings` gives immediate tactile confirmation when the gesture threshold is reached.
- **Alternatives considered**:
  - *`pointerInput` with `detectTapGestures(onLongPress = ...)`*: Rejected because `combinedClickable` provides built-in accessibility semantics (`Role` / `onLongClickLabel`), focus/indication handling, and simpler code.

## R3. Clear Chat/Context Header Action & Surface Cleanup

- **Decision**: Replace the Settings `IconButton` in `InteracAssistantUi`'s toolbar `actions` slot with a Clear Chat/Context `IconButton` (`TAG_CLEAR_CHAT = "chat_clear"`, `Icons.Rounded.DeleteSweep`, `R.string.chat_clear`). Enable the button when `!state.busy && (state.turns.isNotEmpty() || state.input.isNotBlank())`. In `InteracAssistantPresenter`, handle `InteracAssistantAction.ClearChat` (when `!busy`) by sending `InteracSurfaceTemplates.deleteSurface(surfaceId)` to `bridge` for all existing surfaces/turns, resetting `turns = emptyList()`, `input = ""`, and clearing `startedAt`.
- **Rationale**:
  - Each assistant request in `InteracAssistantAgent` already runs in a fresh `AIAgent` instance per turn, so in-memory conversation state lives in `InteracAssistantPresenter` (`turns`, `input`, `startedAt`) and `A2uiBridge` (`surfaces`).
  - Explicitly deleting all active A2UI surfaces on `bridge` prevents stale surface models from remaining in `bridge.surfaces` when new turns reuse `turn-1`, `turn-2`, etc.
  - Disabling the button while `busy` prevents orphaning an in-flight coroutine turn that would otherwise append a reply after clear; disabling when `turns.isEmpty() && input.isBlank()` gives clear visual feedback that the chat is already clean.
- **Alternatives considered**:
  - *Recreating `A2uiBridge` on clear*: Sending `deleteSurface` for active surfaces on the existing retained `bridge` is a one-liner that preserves the active event collection loop in `LaunchedEffect(bridge)` without cancelling or re-subscribing flows.
