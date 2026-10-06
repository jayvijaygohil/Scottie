# Implementation Plan: Mock Interac Banking Tools

**Branch**: `004-interac-banking-tools` | **Date**: 2026-10-04 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `scottie/specs/004-interac-banking-tools/spec.md`

## Summary

Provide one Koog reflective `ToolSet` with four `@Tool` methods (balances, contacts, send,
request) over fixed mock data, plus a system-prompt constant holding the A2UI channel and
Autodeposit rules.

- Balances live in one `@Singleton` instance's memory. A send debits the balance inside a
  `@Synchronized` method, so concurrent sends cannot overdraw. A process restart rebuilds the
  instance with the initial balances.
- Validation uses `require` (`IllegalArgumentException`) as the spec asks. Koog turns any thrown
  exception into a failed tool result that carries the message, so the LLM sees the reason
  ([research.md](research.md) R2).
- Nothing consumes the tools yet. The spec puts the agent host and A2UI rendering out of scope, so
  there is no agent, screen, or Hilt binding.

## Technical Context

**Language/Version**: Kotlin 2.4.20, Java 17 target, AGP 9.4.1

**Primary Dependencies**:
- Koog 1.3.0 (`koog-agents`, already installed). It brings `agents-tools`, `serialization-core`,
  and `kotlin-reflect`, which reflective `ToolSet` needs. `koog-agents-additions:1.3.0-beta` is
  installed but unused. APIs verified against the resolved 1.3.0 sources
  ([research.md](research.md) R1, R3, R7).
- kotlinx.serialization (the plugin is already applied).
- Hilt 2.60.1, used only for `@Singleton @Inject`.
- Nothing is added.

**Storage**: Process memory only; nothing is persisted.

**Testing**:
- JUnit 4 on the JVM (`:app:testDebugUnitTest`).
- The tool class is called directly for the business rules.
- One test goes through `asTools()` to prove Koog exposes all four tools and applies default
  arguments. It decodes JSON args with `KotlinxSerializer()` and runs the `suspend` `execute` in
  `runTest` ([research.md](research.md) R7).

**Target Platform**: Android, minSdk 26 (so `java.time.Instant` is available).

**Project Type**: Single-module Android app (`:app`).

**Performance Goals**: N/A. There are two accounts and three contacts.

**Constraints**:
- Deterministic data after a fresh start (SC-001).
- Errors carry explicit reasons (FR-013).
- The security answer never appears in results (FR-012).

**Scale/Scope**: 4 main files and 1 test file.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | Pass | Entities are in `feature/interacbanking/domain/entities/`. The tool contract is in `feature/interacbanking/domain/agent/tools/`, and the mock implementation with its Koog annotations is in `feature/interacbanking/data/ai/tools/`. The domain imports only kotlinx.serialization. |
| II. Circuit-Driven Presentation | N/A | No screen. |
| III. Bounded AI Agents | Pass | The typed tool interface is in `feature/interacbanking/domain/agent/tools/` and its implementation in `feature/interacbanking/data/ai/tools/`. The agent instructions are a plain string in `feature/interacbanking/domain/agent/workflow/` with no Koog import. |
| IV. Verified Changes | Pass | JVM tests cover every acceptance scenario. Checks: assemble, unit tests, detekt, lint. Device tests are skipped because no device behavior changes; the completion report must state this. |
| V. Simplicity | Pass | No new dependencies, no DI module, no repository, no use case, no clock or ID injection. The interface exists only because Principle III requires it; AGENTS.md accepts single-implementation contracts. |

Post-design re-check: unchanged, Pass.

## Project Structure

### Documentation (this feature)

```text
scottie/specs/004-interac-banking-tools/
├── plan.md
├── research.md
├── data-model.md
├── quickstart.md
├── contracts/
│   └── interac-tools.md
└── tasks.md             # /speckit-tasks
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/feature/interacbanking/
├── domain/
│   ├── entities/InteracBanking.kt              # enums, Account, InteracContact, results
│   └── agent/
│       ├── tools/InteracBankingTools.kt        # interface: 4 typed operations
│       └── workflow/InteracAgentInstructions.kt # system prompt const (FR-014, FR-015)
└── data/ai/tools/MockInteracBankingTools.kt    # ToolSet + mock data + in-memory balances

app/src/test/java/com/jayvijay/scottie/feature/interacbanking/data/ai/tools/
└── MockInteracBankingToolsTest.kt
```

**Structure Decision**: These are the layer folders the constitution requires; `feature/interacbanking/domain/agent/` and
`feature/interacbanking/data/ai/tools/` are new. The mock data is private to the implementation because nothing else reads
it.

## Complexity Tracking

None.
