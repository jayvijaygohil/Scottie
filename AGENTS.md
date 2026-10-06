# Agent instructions

These instructions apply throughout this repository. Before changing a layer, read
its nested `AGENTS.md`. Apply higher-priority instructions and explicit user
requirements first, then repository conventions for the relevant scope. Adapt skill
examples to those conventions.

Always prefer `android-studio-index` mcp along with `ide-index-mcp` skill (for code navigation,
semantic search, symbol references, hierarchy, refactoring, and diagnostics) and
`android-studio-debugger` mcp with `jetbrains-debugger` skill (for runtime
debugging, stepping, and inspection) over shell/bash commands or CLI tools whenever available.

## Project

Inspect the current build files and source before assuming a feature, integration,
or API is available:

- `settings.gradle.kts`: Modules and dependency repositories.
- `app/build.gradle.kts`: Android configuration, enabled features, and dependencies.
- `gradle/libs.versions.toml`: Dependency coordinates, versions, bundles, and plugins.
- `.editorconfig`: Formatting conventions.
- `config/detekt/detekt.yml`: Static analysis configuration.

Use the checked-in Gradle wrapper. Keep dependency coordinates and versions in the
version catalog and reference its aliases from build scripts.

Preserve the existing Hilt and Circuit registration. KSP uses Circuit's `hilt`
code-generation mode. Verify version-sensitive APIs against the configured
dependencies; do not upgrade libraries or migrate frameworks to match skill examples.

## Source layout

Locate the application's source package under `app/src/main/java/` or
`app/src/main/kotlin/` by inspecting the existing source and build configuration.
Do not assume a fixed package path or application class name.

Within that source package:

- Application class: Hilt entry point annotated with `@HiltAndroidApp` and registered
  in `app/src/main/AndroidManifest.xml`.
- Host Activity: lives beside the application class and hosts the Circuit UI.
- `feature/<name>/`: Feature vertical slices containing internal `domain/`, `data/`, and
  `presentation/` layers. Create only the layers a feature needs.
- `core/`: Code shared by two or more features: theme and shared components (`core/ui/`),
  design system components (`core/ui/xelauikit/`), and shared AI infrastructure (`core/ai/`).
- `di/`: Application-level Hilt modules, bindings, and provider wiring.

Read the relevant `AGENTS.md` before editing that area:

- @app/src/main/java/com/jayvijay/scottie/feature/AGENTS.md
- @app/src/main/java/com/jayvijay/scottie/core/AGENTS.md
- @app/src/main/java/com/jayvijay/scottie/di/AGENTS.md

Android resources belong in `app/src/main/res/`, host tests in `app/src/test/`,
and device tests in `app/src/androidTest/`.

## Working conventions

- Keep changes focused on the requested outcome. Preserve unrelated user changes,
  including staged changes, and report unrelated issues separately.
- Do not create commits or create, delete, or switch branches unless explicitly asked.
  When requested, use focused commits, clear messages, and meaningful branch names.
- Do not edit generated sources or build outputs. Keep credentials and local SDK
  paths out of tracked files.
- Follow `.editorconfig`. Kotlin uses spaces, two-space indentation, and a
  100-character line limit.
- Introduce packages, abstractions, and dependencies for demonstrated requirements.
  A repository contract or Circuit factory does not need multiple implementations to be justified.

## Skill selection

Skill use is required when its task trigger matches implementation, review,
debugging, refactoring, testing, or technical advice.

Before the relevant work:

1. Select every applicable skill from the routing list.
2. Read its `SKILL.md` and required task-specific references. Reuse instructions
   already read in this conversation unless they changed.
3. Briefly state which skills are being applied and why.
4. Reassess the selection when the task gains another concern.

Load explicitly requested skills. For other skills, use the current session catalog
and their task-specific triggers. Tool availability establishes capability; it does
not by itself require loading a complete workflow or using that tool.

Do not load all skills or reference collections for an ordinary task. For instruction
audits, inspect the requested instruction files and follow references needed to
resolve specific questions.

## Repository skill routing

All paths are relative to the repository root. Apply skills together when a task
crosses concerns; each skill owns the concern described below.

- [kotlin-coding-standards](.agents/skills/kotlin-coding-standards/SKILL.md):
  Kotlin code and tests: naming, types, nullability, mutation, errors, collections,
  and API contracts.
- [kotlin-coroutines-flows](.agents/skills/kotlin-coroutines-flows/SKILL.md):
  Coroutine and Flow behavior: ownership, cancellation, supervision, dispatchers,
  concurrency, delivery, lifecycle collection, and async tests.
- [android-clean-architecture](.agents/skills/android-clean-architecture/SKILL.md):
  Layer boundaries, dependency direction, packages/modules, use cases, repositories,
  data-source coordination, and DI composition.
- [compose-expert](.agents/skills/compose-expert/SKILL.md):
  Compose rendering, state, effects, recomposition, layout, modifiers, themes,
  accessibility, motion, and design-to-code. Adapt navigation guidance to Circuit.
- [slack-circuit-android](.agents/skills/slack-circuit-android/SKILL.md):
  Circuit screens, presenters, UIs, state/actions, factories, navigation, persistence,
  overlays, registration, and tests.
- [jetbrains-koog](.agents/skills/jetbrains-koog/SKILL.md):
  Koog agents, strategies, tools, prompt executors, structured output, memory,
  integrations, and tests.
- [android-a2ui-compose](.agents/skills/android-a2ui-compose/SKILL.md):
  AndroidX A2UI integration, protocols, Compose rendering, catalogs, custom components,
  and tests.
- [figma-console-mcp](.agents/skills/figma-console-mcp/SKILL.md):
  Inspecting or modifying Figma artifacts through Figma Console MCP, or translating
  Figma designs into code or documentation.
- [android-cli](.agents/skills/android-cli/SKILL.md):
  Android CLI, SDK/emulator management, deployment, device interaction, journeys,
  and CLI documentation workflows. Ordinary Gradle builds do not require it.
- [ide-index-mcp](.agents/skills/ide-index-mcp/SKILL.md):
  Semantic navigation, references, refactoring, diagnostics, and IDE test operations
  when IDE Index tools are available. Read before using those tools.
- [jetbrains-debugger](.agents/skills/jetbrains-debugger/SKILL.md):
  Runtime debugging, value inspection, execution tracing, and failures that need
  runtime evidence. Read before using debugger tools.

## Validation and completion

Run checks appropriate to the change from the repository root:

```sh
./gradlew :app:assembleDebug
./gradlew :app:testDebugUnitTest
./gradlew :app:detekt :app:lintDebug
./gradlew :app:connectedDebugAndroidTest
```

The device test command requires a connected Android device or emulator.
Documentation-only changes generally need content and link checks rather than
an Android build.

Before finishing, inspect the final diff for scope and accidental edits. Report
what changed, which checks ran, and material limitations. Distinguish source
inspection, compilation, automated tests, debugger evidence, and observed device
behavior.
