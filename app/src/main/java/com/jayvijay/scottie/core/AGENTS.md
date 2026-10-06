# Core conventions

`core/` holds code shared by two or more features. It never imports `feature/`.

- `ui/`: Application theme (`ScottieTheme`) and shared rendering components in `ui/components/`.
- `ui/xelauikit/`: Design system components and their models.
- `ai/`: AI infrastructure used by two or more features, such as model runtimes and device
  inspection. Create it when a second feature needs that code; until then it stays in the owning
  feature's `data/ai/`. Keep its contracts free of feature domain types. Today it holds the
  on-device text-generation seam (`OnDeviceTextModels`: model directory, Koog `LLModel` for a
  downloaded file, LiteRT backend constant) shared by model download and the Interac assistant.

## Shared UI

- Keep `core/ui/` independent of screen implementations in `feature/`. Screen code may depend on
  shared UI.
- Define application-wide visual styling in `core/ui/`. Consume it through the theme rather than
  repeating styling values across screens.
- Shared components accept display values and callbacks. Do not couple them to screen-specific
  state/action types, presenters, or navigators.
- Shared rendering components do not access repositories or use cases.
- Keep transient visual interaction state local when appropriate; screen and business state remain
  owned by their state holders.
- Components accepting a `Modifier` apply it to their root.
- Keep screen-specific components with their screen. Move components into `core/ui/components/`
  when actual reuse warrants it.
- Preview shared components with representative inputs inside the application theme.

