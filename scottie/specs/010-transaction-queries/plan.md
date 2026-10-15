# Implementation Plan: Conversational Transaction Queries & Financial Insights

**Branch**: `010-transaction-queries` | **Date**: 2026-10-14 | **Spec**: [spec.md](spec.md)

**Input**: Feature specification from `/specs/010-transaction-queries/spec.md`

## Summary

Extend the `feature/interacbanking` assistant so users can query their transaction history and run
personal finance verifications across four workflows:
1. **Date-Range Queries** (`[startDate, endDate]`, relative ranges, and inverted-range normalization).
2. **Salary Verification** ("Did I get my salary?" — recurring monthly/bi-weekly inflows within 15%
   amount variance or payroll descriptors, plus current-month confirmation and historical fallback).
3. **Rent Verification** ("Did I pay my rent this month?" — current-month outgoing debits matched
   against recurring monthly outflows within 10% variance or rent/property descriptors).
4. **Additional Financial Scenarios** (recurring subscriptions & utility bills, merchant/category
   search, duplicate within 48h & unusually large charge detection, and refund/transfer lookup).

Following the existing bounded-agent architecture (research R1–R4), `InteracAssistantAgent` extracts
`Intent.TRANSACTIONS` and lightweight query slots (`scenario`, `startDate`, `endDate`, `searchQuery`,
`accountHint`, `amount`); pure domain logic in `TransactionInsights` evaluates the transactions from
`InteracBankingTools.getTransactions()`; and `InteracAssistantPresenter` emits a `TransactionList`
A2UI surface rendered inside the conversation.

## Technical Context

**Language/Version**: Kotlin 2.4.20, JDK 17, AGP 9.4.1, minSdk 26 / targetSdk 37

**Primary Dependencies**: Jetpack Compose + Material 3, Slack Circuit 0.39.0 (`hilt` codegen),
Hilt 2.60.1, JetBrains Koog `koog-agents` 1.3.0 + `koog-agents-additions` 1.3.0-beta, AndroidX A2UI
1.0.0-alpha01, `kotlinx.serialization`. No new dependencies or version upgrades.

**Storage**: In-memory mock transaction ledger inside `MockInteracBankingTools` (`@Singleton`),
anchored to `YearMonth.from(LocalDate.now(clock))` across the current and two prior months; resets
on process restart; records session `executeSendTransfer` transactions in-memory (FR-010).

**Testing**: JUnit 4 host unit tests (`:app:testDebugUnitTest`), `kotlinx-coroutines-test`, Turbine,
Koog `agents-test`, and AndroidX A2UI `compose-ui-testing` (`:app:connectedDebugAndroidTest`).

**Target Platform**: Android (minSdk 26; `java.time.LocalDate` / `YearMonth` / `Clock` available
natively without desugaring).

**Project Type**: Single-module Android application with feature-slice architecture.

**Performance Goals**: Deterministic in-memory filtering and pattern detection in < 5 ms (well
within SC-001's 3-second post-inference budget).

**Constraints**: Zero Android/framework imports in `domain/`; A2UI JSON carries codes and formatted
values only (all user-visible copy in `res/values/strings.xml`); 2-space indent, 100-char line limit,
and passing `detekt` / `lintDebug`.

**Scale/Scope**: Single feature slice (`feature/interacbanking`), ~28 seeded transactions across 4
accounts and 3 calendar months, 1 new domain use-case file (`TransactionInsights.kt`), 1 new A2UI
component (`TransactionList.kt`), and unit + instrumented tests.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

| Principle | Status | Notes |
|---|---|---|
| I. Layered Clean Architecture | PASS | All changes stay inside `feature/interacbanking/{domain,data,presentation}`. `Transaction` entities and `TransactionInsights` live in `domain/` with zero Android/Compose/AI-client imports. `MockInteracBankingTools` lives in `data/ai/tools/`. `TransactionList` lives in `presentation/a2ui/components/`. |
| II. Circuit-Driven Presentation | PASS | `InteracAssistantPresenter` handles `Intent.TRANSACTIONS` and emits A2UI messages; `TransactionList` resolves all static copy via `stringResource`; `Modifier` applied to root. |
| III. Bounded AI Agents | PASS | `AssistantIntent` and `INTERAC_AGENT_INSTRUCTIONS` remain in `domain/agent/workflow/`; `getTransactions()` is typed on `InteracBankingTools`. |
| IV. Verified Changes | PASS | Dedicated unit tests for `TransactionInsights`, `MockInteracBankingTools`, `InteracAssistantAgent`, `InteracSurfaceTemplates`, and `InteracAssistantPresenter`, plus `:app:assembleDebug`, `:app:testDebugUnitTest`, `:app:detekt`, and `:app:lintDebug`. |
| V. Simplicity | PASS | Reuses the single `InteracAssistantAgent`, `InteracBankingTools`, and A2UI surface pipeline; no new libraries, screens, or repositories. |

**Post-design re-check**: PASS. No violations or Complexity Tracking justifications needed.

## Project Structure

### Documentation (this feature)

```text
specs/010-transaction-queries/
├── plan.md              # This file (/speckit-plan command output)
├── research.md          # Phase 0 output (/speckit-plan command)
├── data-model.md        # Phase 1 output (/speckit-plan command)
├── quickstart.md        # Phase 1 output (/speckit-plan command)
├── contracts/           # Phase 1 output (/speckit-plan command)
│   ├── assistant-intent.schema.json
│   └── transaction-surface.md
└── tasks.md             # Phase 2 output (/speckit-tasks command)
```

### Source Code (repository root)

```text
app/src/main/java/com/jayvijay/scottie/feature/interacbanking/
├── data/ai/tools/
│   └── MockInteracBankingTools.kt             # Seeded 3-month transactions + getTransactions() + session send recording
├── domain/
│   ├── agent/
│   │   ├── tools/InteracBankingTools.kt       # + getTransactions(): List<Transaction>
│   │   └── workflow/
│   │       ├── AssistantIntent.kt             # + Intent.TRANSACTIONS, TransactionScenario, startDate, endDate, searchQuery
│   │       ├── InteracAgentInstructions.kt    # + transaction classification rules & current date context
│   │       └── InteracAssistantAgent.kt       # Inject current date into system prompt
│   ├── entities/
│   │   └── InteracBanking.kt                  # + Transaction, TransactionDirection, TransactionCategory
│   └── usecase/
│       └── TransactionInsights.kt             # NEW: date range, salary, rent, subscriptions/bills, merchant/category, anomalies, refunds/transfers
└── presentation/
    ├── InteracAssistantPresenter.kt           # + Intent.TRANSACTIONS branch -> TransactionInsights -> A2UI surface
    └── a2ui/
        ├── InteracCatalog.kt                  # Register TransactionList component
        ├── InteracSurfaceTemplates.kt         # + transactionResults(...) builder
        └── components/
            └── TransactionList.kt             # NEW: A2UI component rendering verification banner, totals, and transaction rows

app/src/main/res/values/strings.xml            # Scenario headers, verification banners, category & insight badge strings

app/src/test/java/com/jayvijay/scottie/feature/interacbanking/
├── data/ai/tools/MockInteracBankingToolsTest.kt
├── domain/
│   ├── agent/workflow/InteracAssistantAgentTest.kt
│   └── usecase/TransactionInsightsTest.kt     # NEW: unit tests for all 4 workflows and edge cases
└── presentation/
    ├── InteracAssistantPresenterTest.kt
    └── a2ui/InteracSurfaceTemplatesTest.kt
```

**Structure Decision**: Extend the existing `feature/interacbanking` vertical slice in-place. Adding
a single pure use case (`TransactionInsights.kt`) and a single A2UI component (`TransactionList.kt`)
keeps the diff small and cohesive.

## Complexity Tracking

None.
