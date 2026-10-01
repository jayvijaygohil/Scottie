<!--
Sync Impact Report
- Version: template → 1.0.0 (initial ratification)
- Principles added: I. Layered Clean Architecture; II. Circuit-Driven Presentation;
  III. Bounded AI Agents; IV. Verified Changes; V. Simplicity
- Sections added: Technology Constraints; Development Workflow; Governance
- Sections removed: none
- Deferred TODOs: none
-->

# Scottie Constitution

## Core Principles

### I. Layered Clean Architecture

- Source MUST live in `presentation/`, `domain/`, `data/`, and `di/` under the app package.
- Dependencies MUST point inward: presentation and data depend on domain; domain MUST NOT import
  Android framework, Compose, network, database, or AI-provider APIs.
- Repository interfaces in `domain/repository/` MUST contain declarations only; implementations
  live in `data/repository/`.
- Use cases MUST exist only when they hold policy or coordinate multiple repositories.

Rationale: inward dependencies keep business rules testable on the JVM and swappable infrastructure.

### II. Circuit-Driven Presentation

- Every screen MUST use Slack Circuit: a `Screen` key, a class-based `Ui`, and a class-based
  `Presenter` when state is computed or actions are handled.
- Factories MUST be registered with `@CircuitInject` using Hilt codegen; runtime inputs such as
  `Navigator` MUST use assisted injection.
- Navigation and business operations MUST be initiated from presenters, never from UI bodies.
- UI MUST render supplied state, use string resources for user-visible text, use the shared theme,
  and apply the supplied `Modifier` to its root.

Rationale: unidirectional state/action flow makes screens predictable and presenters testable.

### III. Bounded AI Agents

- Agent orchestration, prompts, guardrails, and fallbacks MUST live in `domain/agent/workflow/`
  and MUST NOT import API clients, inference runtimes, or embedding libraries.
- Agent tools MUST have strongly typed inputs and outputs; interfaces in `domain/agent/tools/`,
  implementations in `data/ai/tools/`.
- Inference clients belong in `data/ai/provider/`; vector storage and embedding dependencies MUST
  stay encapsulated in `data/ai/memory/`.

Rationale: isolating model infrastructure lets on-device runtimes change without rewriting
agent behavior.

### IV. Verified Changes

- Presenters MUST be tested for actions, navigation, state transitions, and meaningful failures
  using fakes, not live infrastructure.
- A change is done only after the checks matching its scope pass:
  `:app:assembleDebug`, `:app:testDebugUnitTest`, `:app:detekt`, `:app:lintDebug`, and
  `:app:connectedDebugAndroidTest` when device behavior changes.
- Completion reports MUST state which evidence exists: inspection, compilation, automated tests,
  debugger evidence, or observed device behavior.

Rationale: explicit evidence prevents "should work" from passing as verified.

### V. Simplicity

- Packages, abstractions, and dependencies MUST answer a demonstrated requirement; speculative
  scaffolding, placeholder screens, and configuration for fixed values are prohibited.
- Reuse existing code, the standard library, platform features, and installed dependencies before
  adding new code or libraries.
- Shared UI components move to `ui/components/` only after real reuse.

Rationale: the cheapest code to maintain is code never written.

## Technology Constraints

- Kotlin, Jetpack Compose with Material 3, Slack Circuit, Hilt with KSP, JetBrains Koog, and
  AndroidX A2UI as configured in `app/build.gradle.kts`.
- Dependency coordinates and versions MUST live in `gradle/libs.versions.toml`; build scripts
  reference catalog aliases only.
- Libraries MUST NOT be upgraded or frameworks migrated without an explicit requirement; APIs
  MUST be verified against configured versions.
- Code MUST follow `.editorconfig` (two-space indent, 100-character lines) and
  `config/detekt/detekt.yml`.
- Credentials and local SDK paths MUST NOT be committed; generated sources and build outputs MUST
  NOT be edited.

## Development Workflow

- Read the root and layer `AGENTS.md` before changing a layer.
- Keep changes scoped to the requested outcome; preserve unrelated and staged user changes.
- Commits and branch operations happen only on explicit request, as focused commits with clear
  messages.
- Inspect the final diff for scope before declaring work complete.

## Governance

- This constitution supersedes conflicting practice; `AGENTS.md` files provide runtime guidance
  and MUST stay consistent with it.
- Amendments require a documented change to this file, a version bump, and an updated
  Last Amended date.
- Versioning: MAJOR for principle removal or redefinition, MINOR for added or materially expanded
  principles or sections, PATCH for clarifications.
- Every spec, plan, and review MUST check compliance; any violation MUST be justified in the
  plan's complexity tracking.

**Version**: 1.0.0 | **Ratified**: 2026-10-01 | **Last Amended**: 2026-10-01
