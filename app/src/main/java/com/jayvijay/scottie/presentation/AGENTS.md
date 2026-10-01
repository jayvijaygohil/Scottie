# Android presentation conventions

## Package layout

- `feature/`: Screen implementations, grouped into cohesive packages. Each package contains its
  screen key, UI, and any required presenter and contract.
- `feature/<name>/components/`: Rendering components specific to that screen or flow, when
  extraction is useful.
- `ui/theme/`: Shared application theme, colors, typography, and shapes.
- `ui/components/`: Shared rendering components with demonstrated reuse.
- Presentation entry points, such as the host Activity, live at the presentation root and host the
  application UI.

Create packages and components only when needed. This layout does not require placeholder screens or
empty directories.

## Screen structure

- Use Slack Circuit with a screen key and a class-based UI. Use a class-based
  presenter and explicit state/actions when the screen needs computed state or
  action handling. Static screens may omit a presenter when supported by the
  installed Circuit version.
- Use a consistent descriptive prefix with the suffixes `Screen`, `Presenter`, `Ui`, `State`, and
  `Action`.
- Keep related state and actions together in a contract file when small.

## Screens and presenters

- Keep screen keys limited to navigation identity and required arguments.
- Use a parcelable data object implementing `ParcelableScreen` for argument-free destinations; use a
  parcelable value type otherwise.
- Implement `Presenter` with the screen's state type. Its `present()` function produces UI state and
  handles actions.
- Keep screen navigation decisions in the presenter and inject its `Navigator`.

## State and actions

- State implements `CircuitUiState`.
- When actions are supported, expose an `eventSink` callback accepting the action type and returning
  `Unit`.
- Define actions as a sealed interface implementing `CircuitUiEvent`. Use data objects for actions
  without payloads and data classes otherwise.

## Dependency injection

- Use the existing Dagger/Hilt wiring and Circuit registration.
- Register the UI factory and any required presenter factory for their screen using
  `@CircuitInject` and the established component.
- Use `@AssistedInject` and `@AssistedFactory` for runtime inputs such as `Navigator`; use ordinary
  constructor injection otherwise.

## Screen rendering

- Implement `Ui` with the screen's state type, matching its presenter when present.
- Render supplied state in `Content` and dispatch actions through its event sink.
- Pass the supplied `Modifier` to the UI's root.
- Use string resources for user-visible copy and the shared application theme for styling.
- Dispatch business actions to the presenter; do not initiate business operations directly from
  rendering bodies.
- Keep previews independent of live services and DI initialization, using representative state and a
  harmless event sink.

## Shared UI

- Keep `ui/` independent of screen implementations in `feature/`. Screen code may depend on shared
  UI.
- Define application-wide visual styling in `ui/theme/`. Consume it through the theme rather than
  repeating styling values across screens.
- Shared components accept display values and callbacks. Do not couple them to screen-specific
  state/action types, presenters, or navigators.
- Shared rendering components do not access repositories or use cases.
- Keep transient visual interaction state local when appropriate; screen and business state remain
  owned by their state holders.
- Components accepting a `Modifier` apply it to their root.
- Keep screen-specific components with their screen. Move components into `ui/components/` when
  actual reuse warrants it.
- Preview shared components with representative inputs inside the application theme.

## Strings and identifiers

- Store static user-facing text, including accessibility descriptions in XML string resources. Use
  stringResource in Compose.
- Use plural resources for quantity-dependent text and resource formatting arguments rather than
  concatenating translated fragments.
- Keep test tags, logging tags, analytics event names, and parameter keys in named Kotlin constants
  or typed definitions owned by the relevant component. Keep these identifiers independent of
  locale.
- User-entered and server-provided content remains runtime data.

## Circuit facility selection

Use these facilities when current requirements justify them. Prefer ordinary composables for
rendering-only components. Consult `slack-circuit-android` for implementation guidance and verify
APIs against the installed version.

| Need                                                                                      | Preferred facility                                                                                                                                         |
|-------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Visual continuity between matching content across screens or overlays                     | [`circuit-sharedelements`](https://slackhq.github.io/circuit/shared-elements/)                                                                             |
| Navigation to Android activities or Intent-based destinations                             | [`circuitx-android`](https://slackhq.github.io/circuit/circuitx/android/)                                                                                  |
| Screen-impression logging or analytics with retention-aware execution                     | [`circuitx-effects`](https://slackhq.github.io/circuit/circuitx/effects/); not a replacement for all logging or interaction analytics                      |
| Gesture-driven navigation transitions, including Android predictive back                  | [`circuitx-gesture-navigation`](https://slackhq.github.io/circuit/circuitx/gesture-navigation/)                                                            |
| Ephemeral dialogs, sheets, or full-screen interactions returning results                  | [`circuitx-overlays`](https://slackhq.github.io/circuit/circuitx/overlays/), using the core overlay infrastructure                                         |
| Nested presenter/UI pairs that delegate navigation and other outer events to their parent | [`circuitx-subcircuit`](https://slackhq.github.io/circuit/circuitx/subcircuit/); verify experimental status and required opt-ins for the installed version |

## Presenter verification

- Test observable actions, navigation, state transitions, and meaningful failure handling with
  dependencies that do not require live infrastructure.
