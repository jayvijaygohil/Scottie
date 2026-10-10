# Implementation Plan: OpenRouter API Support

**Branch**: `008-openrouter-api-support` | **Date**: 2026-10-10 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/008-openrouter-api-support/spec.md`

## Summary

Add a persisted OpenRouter configuration (base URL, optional API key, semicolon-separated model
list) owned by the `modeldownload` feature, edited in a new collapsible section at the bottom of the
Model Download & Settings screen. Remote models become selectable text models: the download
repository's active-model resolution and the chat's `TextModelSource` adapter include them after the
downloaded on-device models, marked remote. Inference routes per model: the Interac agent's
`ModelResolver` now returns the Koog executor together with the `LLModel`, so on-device requests
keep the existing LiteRT executor while remote requests use a `SingleLLMPromptExecutor` wrapping
Koog's `OpenRouterLLMClient`, rebuilt when the saved credentials change. Failures are classified
(offline, unauthorized, model unavailable, other) into a typed domain exception and shown as
distinct chat error messages. No new dependencies: the OpenRouter client already ships on the
runtime classpath through `koog-agents-additions` → `prompt-executor-llms-all`.

## Technical Context

**Language/Version**: Kotlin (as configured), Android, single `:app` module

**Primary Dependencies**: Jetpack Compose + Material3, Slack Circuit, Hilt/KSP, Koog 1.3.0
(`koog-agents`) and 1.3.0-beta (`koog-agents-additions`, which transitively provides
`prompt-executor-openrouter-client:1.3.0` and `prompt-executor-litert-client`), kotlinx
serialization (plugin already applied, `Json` already provided in `di/DataModule`)

**Storage**: one JSON file in app-private `filesDir` (`openrouter_config.json`), same pattern as
the existing `active_text_model` file. Plain text; see research R3.

**Testing**: JUnit + Circuit test (`FakeNavigator`, presenter `test {}`), Turbine, coroutines-test
with `TemporaryFolder` for file-backed repositories (existing pattern in
`ModelDownloadRepositoryImplTest`); device checks per quickstart

**Target Platform**: Android phone (existing min/target SDK); `INTERNET` permission already declared

**Project Type**: mobile-app

**Performance Goals**: thinking indicator within 200 ms of Send (unchanged UI path); Save completes
synchronously in state with the file write off the main thread

**Constraints**: no new libraries; features must not import each other; API key never logged;
domain must not import Android, ktor, or provider clients; plain `http` base URLs must work, so
cleartext traffic is permitted app-wide via a network security config (research R2)

**Scale/Scope**: 2 screens touched, 1 new repository, 1 new core/ai seam, ~16 files

## Constitution Check

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | PASS | Config entity, validation, and `OpenRouterConfigRepository` (declarations only) live in `modeldownload/domain`; the file-backed impl in `modeldownload/data/repository`. Interac sees remote models only through its existing `TextModelSource` and `ModelResolver` seams, adapted in `di/`. `ModelResolver` now returns `PromptExecutor` + `LLModel`; the agent already imports both Koog types (existing precedent), and no provider client enters any `domain/`. Failure classification touching ktor/Koog exceptions lives in `di/`. |
| II. Circuit-Driven Presentation | PASS | Save, Delete, validation, and selection are presenter actions; UI renders state and dispatches. All copy in string resources; API key field masked by default. |
| III. Bounded AI Agents | PASS | Agent unchanged except wrapping failures in `InferenceException` via an injected `FailureClassifier`. OpenRouter client construction sits in `core/ai/OpenRouterTextModels` beside `OnDeviceTextModels` (shared seam, feature-type free). |
| IV. Verified Changes | PASS (planned) | Unit tests for parsing/validation, file repository, active-model resolution with remote ids, presenter save/delete/validation, chat failure mapping, classifier; `connectedDebugAndroidTest` plus manual device checks because the Settings screen and chat behaviour change (quickstart). |
| V. Simplicity | PASS | One new repository contract for a distinct persisted concern (config lifecycle differs from the catalog). No encrypted storage dependency, no multiple profiles, no streaming, no new networking stack. Material3 `OutlinedTextField`/`AlertDialog` reused rather than new design-system components. |

Post-design re-check: PASS. Design artifacts add one entity (`OpenRouterConfig` + draft
validation), one repository interface and impl, one `core/ai` object, one domain exception/enum, one
`fun interface` classifier, a `remote` flag on `TextModelOption`, a `ResolvedModel` return type for
`ModelResolver`, and Settings state/actions for the section. No constitution violations.

## Project Structure

### Documentation (this feature)

```text
specs/008-openrouter-api-support/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/openrouter-settings-ui.md
└── tasks.md            # /speckit-tasks
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/
├── core/ai/
│   ├── OnDeviceTextModels.kt                          # unchanged
│   └── OpenRouterTextModels.kt                        # new: llModel(id), executor(baseUrl, apiKey), URL normalise
├── di/
│   ├── AiModule.kt                                    # unchanged: the unqualified PromptExecutor stays the LiteRT one
│   ├── DataModule.kt                                  # + @Named("openRouterConfigFile") File; bind OpenRouterConfigRepository
│   └── InteracModule.kt                               # ModelResolver → ResolvedModel (routes executor); FailureClassifier;
│                                                      #   TextModelSource adds remote options; remote executor cache
├── feature/modeldownload/
│   ├── domain/entities/OpenRouterConfig.kt            # new: config, ID_PREFIX, draft parse/validate, OpenRouterField
│   ├── domain/repository/OpenRouterConfigRepository.kt# new: config StateFlow, save, clear
│   ├── domain/repository/ModelDownloadRepository.kt   # doc update: activeTextModel/selectTextModel include remote ids
│   ├── data/repository/OpenRouterConfigRepositoryImpl.kt # new: JSON file in filesDir
│   ├── data/repository/ModelDownloadRepositoryImpl.kt # + openRouter dependency in resolution and select guard
│   └── presentation/
│       ├── ModelDownloadScreen.kt                     # state: openRouter section; actions: edit/save/delete/confirm/toggle
│       ├── ModelDownloadPresenter.kt                  # draft, validation, save/clear, confirm dialog
│       ├── ModelDownloadUi.kt                         # section also shown when catalog Unavailable; delete dialog
│       └── component/
│           ├── ModelSections.kt                       # trailing "OpenRouter" accordion item
│           └── OpenRouterCard.kt                      # new: three fields, errors, Save/Delete, saved summary
└── feature/interacbanking/
    ├── domain/entities/TextModelOption.kt             # + remote: Boolean
    ├── domain/agent/workflow/IntentExtractor.kt       # ModelResolver returns ResolvedModel(executor, model)
    ├── domain/agent/workflow/InferenceFailure.kt      # new: enum, InferenceException, FailureClassifier
    ├── domain/agent/workflow/InteracAssistantAgent.kt # uses resolved executor; wraps failures
    └── presentation/
        ├── InteracAssistantContract.kt                # TurnReply.Failed(failure)
        ├── InteracAssistantPresenter.kt               # maps InferenceException → Failed(failure)
        ├── InteracAssistantUi.kt                      # per-failure message
        └── component/ChatComponents.kt                # remote marker in ModelSelector
app/src/main/res/values/strings.xml                    # strings per contract
app/src/main/res/xml/network_security_config.xml       # new: cleartext permitted (FR-006a, research R2)
app/src/main/AndroidManifest.xml                       # android:networkSecurityConfig on <application>
app/src/test/java/com/jayvijay/scottie/
├── core/ai/OpenRouterTextModelsTest.kt                # URL normalisation
├── di/InferenceFailureClassifierTest.kt               # cause-chain classification
├── feature/modeldownload/domain/entities/OpenRouterConfigTest.kt
├── feature/modeldownload/data/repository/OpenRouterConfigRepositoryImplTest.kt
├── feature/modeldownload/data/repository/ModelDownloadRepositoryImplTest.kt   # + remote cases
├── feature/modeldownload/presentation/FakeOpenRouterConfigRepository.kt       # new fake
├── feature/modeldownload/presentation/ModelDownloadPresenterTest.kt           # + section cases
└── feature/interacbanking/presentation/InteracAssistantPresenterTest.kt       # + failure mapping
```

**Structure Decision**: existing single-module feature-slice layout. The configuration is a
`modeldownload` concern because the Settings screen owns it and the active-model policy already
lives there. The chat consumes it through the existing cross-feature seams in `di/`. The OpenRouter
Koog seam goes in `core/ai/` beside the on-device seam because both features' wiring needs it and it
carries no feature types.

## Complexity Tracking

None — no constitution violations.
