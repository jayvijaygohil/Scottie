# Quickstart: OpenRouter API Support

Validation guide for the feature. Design details: [data-model.md](data-model.md),
[contracts/openrouter-settings-ui.md](contracts/openrouter-settings-ui.md),
[research.md](research.md).

## Prerequisites

- Checked-in Gradle wrapper; Android Studio project open for IDE diagnostics.
- A device or emulator with network access for the remote scenarios, plus an OpenRouter API key
  (a `:free` model id such as `microsoft/phi-4-reasoning:free` keeps the cost at zero).
- Optional: one downloaded on-device text model to verify mixed local/remote selection.

## Automated checks

```sh
./gradlew :app:assembleDebug
./gradlew :app:testDebugUnitTest
./gradlew :app:detekt :app:lintDebug
./gradlew :app:connectedDebugAndroidTest   # device/emulator required
```

Unit tests that must exist and pass (host):

| Test | Proves |
|---|---|
| `OpenRouterConfigTest` | FR-005/006/007: `a/b ; c/d;` → two models; duplicates collapsed; blank or separator-only models → `MODELS` error; empty, scheme-less, `ftp://`, or non-URL base URL → `BASE_URL` error; `http://192.168.1.20:8080` and `https://openrouter.ai` both valid; empty key accepted. |
| `OpenRouterTextModelsTest` | R2: `https://openrouter.ai/api/v1/` and `https://openrouter.ai` normalise to the same origin; known id uses the Koog model, unknown id gets the generic definition with `LLMProvider.OpenRouter`. |
| `OpenRouterConfigRepositoryImplTest` | FR-008/010/011: save writes the file and reload yields the same config; clear deletes it and emits null; malformed file → null without throwing. |
| `ModelDownloadRepositoryImplTest` (additions) | FR-015/016/017: no local models + config → active is first remote id; `selectTextModel("openrouter:x")` accepted when configured, ignored otherwise; clearing config while a remote id is active falls back to first local or null. |
| `ModelDownloadPresenterTest` (additions) | US1/US3/US4: edits update the draft; invalid Save sets errors and calls nothing; valid Save calls `save` with parsed models and clears errors; Delete → confirming → Confirm calls `clear` and resets the draft to the default base URL; Cancel leaves it saved. |
| `InferenceFailureClassifierTest` | FR-021: `KoogHttpClientException(statusCode = 401)` nested in `LLMClientException` → UNAUTHORIZED; 404 → MODEL_UNAVAILABLE; `UnknownHostException` → OFFLINE; `IllegalStateException` → UNKNOWN. |
| `InteracAssistantPresenterTest` (additions) | FR-021: `enqueueFailure(InferenceException(OFFLINE, ...))` → `TurnReply.Failed(OFFLINE)`, Send re-enabled, user turn kept; a plain `RuntimeException` → `Failed(UNKNOWN)`. |
| `InteracAssistantAgentTest` (additions) | Agent uses the resolved executor and wraps a throwing executor into `InferenceException` with the classifier's verdict. |

## Device scenarios

1. **Configure offline (US1)**: airplane mode on. Open chat → gear → scroll to "OpenRouter".
   Expect Base URL prefilled `https://openrouter.ai`, empty masked key, no Delete button. Enter a
   key and `anthropic/claude-3.5-sonnet;openai/gpt-4o`, tap Save. Expect "Saved · 2 models" and a
   Delete button. Kill the app, relaunch, reopen Settings: values restored, key masked, eye icon
   reveals it.
2. **Validation (US4)**: clear Base URL → Save → error under Base URL, summary unchanged. Enter
   `openrouter.ai/api/v1` → same error. Restore URL, clear Models → Save → error under Models.
   Enter `a/b; ;a/b;` → Save → "Saved · 1 model". Enter Base URL `http://10.0.2.2:8080` (an
   OpenAI-compatible gateway on the host machine when using an emulator) → Save succeeds, and
   sending a message reaches the gateway rather than failing with "No connection" (FR-006a).
3. **Chat with a remote model (US2)**: airplane mode off. Back to chat, open the selector: local
   models first, then two entries marked "Remote". Pick one, send "What's my balance?" → thinking
   dots, then balance cards. Send "Send $50 to Alice" → the form appears as with a local model.
4. **Failure messages (FR-021)**: airplane mode on, send → "No connection…" and Send re-enables.
   Airplane off, set the key to `bad`, Save, send → "OpenRouter rejected the API key…". Set models
   to `nobody/no-such-model`, Save, send → "That model isn't available…".
5. **Remote-only (FR-015)**: delete every local model in Settings while a remote config exists.
   Chat shows no empty state; the remote model is active; sending works.
6. **Delete (US3)**: Settings → Delete → dialog → Cancel (nothing changes) → Delete → Confirm.
   Fields reset, Delete button gone, selector lists only local models; with none downloaded the
   empty state appears.
7. **Persistence of selection (FR-016)**: with a remote model active, relaunch; it is still
   active. Edit the model list to drop it, Save, return to chat: the first remaining model is active
   and the conversation is intact.
8. **Key secrecy (FR-012/SC-008)**: run scenario 4 with `adb logcat` captured; grep the capture for
   the key value. Expect zero hits.
9. **Light/dark**: toggle theme in Settings and chat; fields, buttons, and dialog use the theme
   palette.

## Evidence to report

State separately: compilation, unit tests, detekt/lint, instrumentation results, and which device
scenarios were observed. If no device was available, say so and list scenarios 1–9 as pending.
