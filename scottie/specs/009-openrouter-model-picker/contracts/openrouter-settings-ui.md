# Contract: Settings Screen (OpenRouter section)

Supersedes the Models-field parts of `specs/008-openrouter-api-support/contracts/openrouter-settings-ui.md`.

## Layout

1. OpenRouter accordion (first).
2. Catalog accordions: Text, Speech recognition.

Each Settings visit starts with every accordion collapsed. Toggles survive rotation and theme
change and are discarded on leaving. While the top search has text, catalog sections with matches
show expanded; clearing it restores toggles. When the on-device runtime is unavailable, the
OpenRouter card is shown open with no accordion (unchanged).

## OpenRouter card states

| List state | Shown below Base URL / API Key / Save / Delete |
|------------|-----------------------------------------------|
| Hidden | nothing |
| Loading | progress indicator + "Loading models" |
| Loaded, non-empty | search field + checkbox rows (name, id); "No models match" when the search hides all |
| Loaded, empty | "No models available" |
| Failed NO_CONNECTION | "Couldn't reach the service" + Retry |
| Failed AUTH | "The service rejected the API key" + Retry |
| Failed OTHER | "Couldn't load models" + Retry |

## Test tags (`OpenRouterCardTags`)

Remove `MODELS`. Add `MODEL_SEARCH`, `MODEL_LIST`, `MODEL_ROW_PREFIX` (+ id), `MODELS_LOADING`,
`MODELS_ERROR`, `MODELS_RETRY`.

## Accessibility

Each row is one toggleable element whose label is name and id; the search field and Retry have
string-resource labels. All copy is in `res/values/strings.xml`.
