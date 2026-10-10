# UI Contract: Chat (Interac assistant) home screen

## Navigation

| From | Trigger | To |
|---|---|---|
| App launch | — | `InteracAssistantScreen` (back-stack root) |
| Chat | gear tap / empty-state button → `OpenSettings` | `ModelDownloadScreen` (via `ModelSettingsDestination`) |
| Settings | back button / back gesture → `Back` | pop to chat |
| Settings | "Use" on downloaded text model → `UseModel(id)` | select model, pop to chat |
| Chat | system back | app exits (`onRootPop = finish()`) |

## Screen regions

| Region | Content | Test tag |
|---|---|---|
| Top bar | model selector (title slot), gear (action) | `chat_model_selector`, `chat_settings` |
| Selector menu | one item per downloaded text model; active one checked | `chat_model_option` |
| Empty state | message + "Download a Model to Get Started" button; no composer | `chat_empty_state` |
| Welcome | shown when ready and no turns; three example chips | `chat_welcome`, `chat_example` |
| Turns | user bubble (end-aligned, `primary`) then reply card (start-aligned, `surface`) | `assistant_user_bubble`, `assistant_reply` |
| Thinking | three animated dots inside a reply card | `chat_thinking` |
| Composer | styled text field + round send icon button | `assistant_composer`, `chat_send` |

## Enablement

| Control | Enabled when |
|---|---|
| Send | `activeModelId != null && !busy && input.isNotBlank()` |
| Selector | `!busy && models.size >= 1` (menu still opens with a single model) |
| Gear | always |

## Feedback

| Event | Haptic |
|---|---|
| Send accepted | `Confirm` |
| Different model chosen | `SegmentTick` |

## Strings (new, `values/strings.xml`)

`chat_empty_title`, `chat_empty_action` ("Download a Model to Get Started"),
`chat_settings` (gear description), `chat_model_selector` (selector description),
`chat_thinking` (indicator description), `chat_send` (send description),
`chat_welcome_title`, `chat_example_balance`, `chat_example_send`, `chat_example_request`.
`assistant_send`, `assistant_thinking`, `assistant_model_missing` are removed if unused.
