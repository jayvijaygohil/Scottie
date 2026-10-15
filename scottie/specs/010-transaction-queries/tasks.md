# Tasks: Conversational Transaction Queries & Financial Insights

**Input**: Design documents from `/specs/010-transaction-queries/`

**Prerequisites**: [plan.md](plan.md), [spec.md](spec.md), [research.md](research.md),
[data-model.md](data-model.md), [contracts/](contracts/), [quickstart.md](quickstart.md)

**Tests**: Included per Constitution Principle IV (Verified Changes: unit tests for domain, data,
agent, surface templates, and presenter using fakes).

**Organization**: Tasks are grouped by user story so each workflow can be implemented and verified
incrementally.

**Paths**:
- `MAIN` = `app/src/main/java/com/jayvijay/scottie/feature/interacbanking`
- `TEST` = `app/src/test/java/com/jayvijay/scottie/feature/interacbanking`
- `RES` = `app/src/main/res/values/strings.xml`

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies on incomplete tasks)
- **[Story]**: `[US1]`, `[US2]`, `[US3]`, `[US4]` from [spec.md](spec.md)

---

## Phase 1: Setup (Shared Infrastructure)

**Purpose**: Confirm project structure; no new modules, Gradle dependencies, or permissions are
required (`java.time` is available natively on `minSdk = 26`).

*(No setup tasks needed — proceed directly to Phase 2.)*

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: Core domain entities, mock transaction seed data + tool contract, agent intent schema
extensions, and the `TransactionList` A2UI component + surface template shared across all four user
stories.

**⚠️ CRITICAL**: Complete this phase before starting User Stories 1–4.

- [X] T001 [P] Add `TransactionDirection` (`CREDIT`, `DEBIT`), `TransactionCategory` (`INCOME`, `HOUSING`, `UTILITIES`, `SUBSCRIPTIONS`, `GROCERIES`, `DINING`, `TRANSPORT`, `SHOPPING`, `TRANSFER`, `REFUND`), and `@Serializable data class Transaction` (`transactionId: String` non-blank unique ID, `accountId: String`, `accountName: String`, `date: String` ISO-8601 `YYYY-MM-DD`, `descriptor: String`, `merchant: String`, `category: TransactionCategory`, `direction: TransactionDirection`, `amount: Double` positive `> 0.0`, `currency: String = "CAD"`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/entities/InteracBanking.kt`
- [X] T002 [P] Extend `AssistantIntent` with `Intent.TRANSACTIONS`, `@Serializable enum class TransactionScenario` (`DATE_RANGE`, `SALARY_CHECK`, `RENT_CHECK`, `SUBSCRIPTIONS_BILLS`, `MERCHANT_CATEGORY`, `ANOMALIES`, `REFUNDS_TRANSFERS`), `val scenario: TransactionScenario? = null`, `val startDate: String? = null`, `val endDate: String? = null`, and `val searchQuery: String? = null` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/agent/workflow/AssistantIntent.kt`
- [X] T003 Add `fun getTransactions(): List<Transaction>` to `InteracBankingTools` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/agent/tools/InteracBankingTools.kt`
- [X] T004 Seed deterministic 3-month transaction history (`currentMonth`, `currentMonth.minusMonths(1)`, `currentMonth.minusMonths(2)` via injectable `Clock = Clock.systemDefaultZone()`), expose `@Tool override fun getTransactions(): List<Transaction>` sorted by `date` descending, and record completed `executeSendTransfer` calls as `DEBIT` `TRANSFER` transactions (`transactionId = referenceId`, `date = LocalDate.now(clock).toString()`, `amount > 0.0`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt`
- [X] T005 [P] Add unit tests verifying seeded transactions across all 4 accounts, reverse-chronological ordering, and session `executeSendTransfer` transaction recording in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt`
- [X] T006 [P] Update `INTERAC_AGENT_INSTRUCTIONS` and `InteracAssistantAgent` to inject the current local date (`YYYY-MM-DD`) and classify date-range, salary, rent, subscription/utility, merchant/category, anomaly, and refund/transfer prompts as `Intent.TRANSACTIONS` with the matching `TransactionScenario` and slots in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/agent/workflow/InteracAgentInstructions.kt` and `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/agent/workflow/InteracAssistantAgent.kt`
- [X] T007 [P] Add localized string resources for transaction scenario titles, verification status banners (`CONFIRMED`, `NOT_DETECTED`), empty-result notices, category labels, and insight badges (`SALARY`, `RENT`, `RECURRING`, `DUPLICATE`, `LARGE_CHARGE`, `REFUND`, `TRANSFER`) in `app/src/main/res/values/strings.xml`
- [X] T008 Create `TransactionList` A2UI component (`components/TransactionList.kt`) bound to `/summary/*` (`scenarioCode`, `statusCode`, `count`, `inflowAmount`, `outflowAmount`, `periodLabel`, `queryLabel`) and `/items` (`id`, `date`, `merchant`, `descriptor`, `categoryCode`, `accountName`, `directionCode`, `amount`, `currency`, `badgeCode`, `isReference`) and register it in `interacCatalog()` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/components/TransactionList.kt` and `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracCatalog.kt`
- [X] T009 Add `InteracSurfaceTemplates.transactionResults(...)` envelope builder (emitting optional `Alert` for `Notice.AccountNotFound` plus `TransactionList`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplates.kt`

**Checkpoint**: Domain entities, seeded `MockInteracBankingTools`, agent prompt, and `TransactionList` A2UI surface template compile cleanly.

---

## Phase 3: User Story 1 - Query transactions by date range, account, merchant, or category (Priority: P1) 🎯 MVP

**Goal**: Users can request transactions between start date X and end date Y (or relative periods
such as "this month", "last month", "last 7 days"), optionally filtered by account, merchant, or
category, and see a structured `TransactionList` card with inflow/outflow totals or an empty-result
notice.

**Independent Test**: Query an explicit date range, an inverted date range, a relative date range,
an account filter, and a merchant/category keyword and confirm the `TransactionList` surface
contains the exact matching transactions in reverse chronological order with accurate totals.

### Implementation & Tests for User Story 1

- [X] T010 [US1] Create `TransactionInsights` with `VerificationStatus` (`NONE`, `CONFIRMED`, `NOT_DETECTED`), `InsightBadge` (`SALARY`, `RENT`, `RECURRING`, `DUPLICATE`, `LARGE_CHARGE`, `REFUND`, `TRANSFER`), `FlaggedTransaction`, `TransactionQueryResult`, date range parsing/normalization (inclusive `[X, Y]`, inverted range swap `[end, start]`, open-ended `startDate..today`, relative tokens `today`/`this_week`/`this_month`/`last_month`/`last_7_days`/`last_30_days`), account resolution via `InteracResolution.matchAccounts` (setting `accountNotFoundHint` and falling back to all accounts when unmatched), and `DATE_RANGE` + `MERCHANT_CATEGORY` evaluation in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsights.kt`
- [X] T011 [US1] Wire `Intent.TRANSACTIONS` in `InteracAssistantPresenter.respond(...)` to fetch `banking { getTransactions() }` and `banking { getAccountBalances() }`, evaluate `TransactionInsights.evaluate(...)`, and emit `InteracSurfaceTemplates.transactionResults(...)` to `A2uiBridge` in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenter.kt`
- [X] T012 [P] [US1] Create `TransactionInsightsTest` covering explicit `[X, Y]` date ranges, inverted date normalization, single/open-ended dates, relative period tokens, account filtering + unknown account fallback, merchant/category partial case-insensitive matching, and zero-match results in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsightsTest.kt`
- [X] T013 [P] [US1] Add surface template and presenter tests for `DATE_RANGE` and `MERCHANT_CATEGORY` queries (including unknown account notice and empty result) in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracSurfaceTemplatesTest.kt` and `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`

**Checkpoint**: User Story 1 (MVP) is complete and independently verifiable via unit tests.

---

## Phase 4: User Story 2 - Verify salary deposits ("Did I get my salary?") (Priority: P1)

**Goal**: Users can ask whether their salary arrived; the assistant filters incoming `CREDIT`
transactions, detects recurring monthly/bi-weekly payroll inflows (within ±15% amount consistency
or payroll descriptors, excluding small ad-hoc transfers/refunds), and displays `CONFIRMED` or
`NOT_DETECTED` status alongside candidate deposits.

**Independent Test**: Run `TransactionInsights.evaluate` and presenter tests for `SALARY_CHECK`
both when a salary deposit exists in the target month (`CONFIRMED`) and when none has arrived yet
in the target month (`NOT_DETECTED` with prior salary deposits marked `isReference = true`).

### Implementation & Tests for User Story 2

- [X] T014 [US2] Implement `SALARY_CHECK` detection in `TransactionInsights` (filtering `CREDIT` inflows for payroll keywords or recurring inflows ≥ $500 within ±15% median consistency, evaluating current/target month status `CONFIRMED` vs `NOT_DETECTED`, attaching `InsightBadge.SALARY`, and including prior-month payroll entries as `isReference = true` when current month is missing) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsights.kt`
- [X] T015 [P] [US2] Add unit tests in `TransactionInsightsTest` and `InteracAssistantPresenterTest` for `SALARY_CHECK` covering varied payroll descriptors (`ADP PAYROLL`, `DIRECT DEP`), current-month `CONFIRMED`, current-month missing (`NOT_DETECTED` with historical reference), and exclusion of small ad-hoc credits/refunds in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsightsTest.kt` and `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`

**Checkpoint**: User Stories 1 and 2 work independently and pass all tests.

---

## Phase 5: User Story 3 - Verify rent payments ("Did I pay my rent this month?") (Priority: P1)

**Goal**: Users can ask whether they paid rent this month; the assistant matches current-month
outgoing `DEBIT` transactions against historical recurring monthly outflows (within ±10% amount
variance) or rent/lease/property descriptors, displaying candidate matches and confirmation status.

**Independent Test**: Run `TransactionInsights.evaluate` and presenter tests for `RENT_CHECK` when
a current-month rent payment is present (`CONFIRMED` with historical pattern context) and when no
current-month rent debit exists yet (`NOT_DETECTED` with previous month's rent shown as reference).

### Implementation & Tests for User Story 3

- [X] T016 [US3] Implement `RENT_CHECK` detection in `TransactionInsights` (filtering `DEBIT` outflows for `HOUSING` / rent keywords or recurring monthly outflows ≥ $500 across ≥ 2 months within ±10% median consistency, prioritizing rent over small subscriptions, setting `CONFIRMED` vs `NOT_DETECTED` for the target month, and attaching `InsightBadge.RENT`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsights.kt`
- [X] T017 [P] [US3] Add unit tests in `TransactionInsightsTest` and `InteracAssistantPresenterTest` for `RENT_CHECK` covering current-month `CONFIRMED`, current-month missing (`NOT_DETECTED` with prior rent reference), and prioritization over small recurring subscriptions in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsightsTest.kt` and `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`

**Checkpoint**: User Stories 1, 2, and 3 work independently and pass all tests.

---

## Phase 6: User Story 4 - Track recurring subscriptions, utility bills, anomalies, and refunds/transfers (Priority: P2)

**Goal**: Users can query recurring subscriptions, utility bills (`SUBSCRIPTIONS_BILLS`), flag
duplicate charges within 48 hours or unusually large charges (`ANOMALIES`), and check specific
refunds or transfers (`REFUNDS_TRANSFERS`, including transfers sent during the current session).

**Independent Test**: Run `TransactionInsights`, agent, and presenter tests for
`SUBSCRIPTIONS_BILLS`, `ANOMALIES` (duplicate within 48h + large charge > threshold or > 3x median),
and `REFUNDS_TRANSFERS` (including a live session `executeSendTransfer` appearing in results).

### Implementation & Tests for User Story 4

- [X] T018 [US4] Implement `SUBSCRIPTIONS_BILLS` (recurring monthly debits within ±15% or `SUBSCRIPTIONS`/`UTILITIES` categories tagged `InsightBadge.RECURRING`), `ANOMALIES` (same-account same-merchant exact-amount debits within 2 calendar days tagged `InsightBadge.DUPLICATE`, plus non-housing debits exceeding user `amount` threshold or 3x median non-housing debit ≥ $250 tagged `InsightBadge.LARGE_CHARGE`), and `REFUNDS_TRANSFERS` (`REFUND` and `TRANSFER` filtering with optional counterparty/keyword filter tagged `InsightBadge.REFUND` / `InsightBadge.TRANSFER`) in `app/src/main/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsights.kt`
- [X] T019 [P] [US4] Add unit tests in `TransactionInsightsTest`, `InteracAssistantAgentTest`, and `InteracAssistantPresenterTest` for `SUBSCRIPTIONS_BILLS`, `ANOMALIES` (duplicate + large charge), `REFUNDS_TRANSFERS`, and live session send-transfer visibility in `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/domain/usecase/TransactionInsightsTest.kt`, `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/domain/agent/workflow/InteracAssistantAgentTest.kt`, and `app/src/test/java/com/jayvijay/scottie/feature/interacbanking/presentation/InteracAssistantPresenterTest.kt`

**Checkpoint**: All four user stories are complete and independently tested.

---

## Phase 7: Polish & Cross-Cutting Concerns

**Purpose**: Instrumented UI test coverage for `TransactionList` and full repository verification
gates.

- [X] T020 [P] Add instrumented A2UI rendering test for `TransactionList` (verifying scenario title, verification badge, transaction rows, and empty/reference state) in `app/src/androidTest/java/com/jayvijay/scottie/feature/interacbanking/presentation/a2ui/InteracFormTest.kt`
- [X] T021 Run `./gradlew :app:assembleDebug :app:testDebugUnitTest :app:detekt :app:lintDebug` and validate against `specs/010-transaction-queries/quickstart.md`

---

## Dependencies & Execution Order

### Phase Dependencies

- **Phase 1 (Setup)**: Empty (no setup needed).
- **Phase 2 (Foundational — T001..T009)**: Blocks all user stories. T001 and T002 can run in parallel; T003 → T004 → T005; T006, T007, T008 → T009.
- **Phase 3 (US1 — T010..T013)**: Depends on Phase 2. Establishes `TransactionInsights` and presenter wiring.
- **Phase 4 (US2 — T014..T015)**: Depends on T010/T011.
- **Phase 5 (US3 — T016..T017)**: Depends on T010/T011 (can run in parallel with US2 if split, or sequentially).
- **Phase 6 (US4 — T018..T019)**: Depends on T010/T011.
- **Phase 7 (Polish — T020..T021)**: Depends on Phases 3–6.

### Parallel Opportunities

- **Foundational**: T001 (`InteracBanking.kt`), T002 (`AssistantIntent.kt`), T006 (`InteracAgentInstructions.kt`), and T007 (`strings.xml`) touch distinct files and can run in parallel.
- **Per-story tests**: Within each user story phase, unit tests in `TransactionInsightsTest.kt`, `InteracSurfaceTemplatesTest.kt`, `InteracAssistantAgentTest.kt`, and `InteracAssistantPresenterTest.kt` (marked `[P]`) can be written in parallel across test files.

---

## Parallel Example: Foundational + User Story 1

```bash
# Parallel foundational models & prompt updates:
Task: "T001 [P] Add TransactionDirection, TransactionCategory, and Transaction in InteracBanking.kt"
Task: "T002 [P] Extend AssistantIntent with TRANSACTIONS and TransactionScenario in AssistantIntent.kt"
Task: "T007 [P] Add localized string resources in strings.xml"

# Parallel User Story 1 verification tests:
Task: "T012 [P] [US1] Create TransactionInsightsTest in TransactionInsightsTest.kt"
Task: "T013 [P] [US1] Add surface template and presenter tests in InteracSurfaceTemplatesTest.kt and InteracAssistantPresenterTest.kt"
```

---

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Complete Phase 2: Foundational (T001–T009)
2. Complete Phase 3: User Story 1 (T010–T013)
3. **STOP and VALIDATE**: Run `./gradlew :app:testDebugUnitTest` to verify date-range, account, and merchant/category queries end-to-end.

### Incremental Delivery

1. Phase 2 (Foundational) → Domain, mock ledger, agent prompt, and A2UI `TransactionList` ready
2. Phase 3 (US1) → Date-range, account, and merchant/category queries (MVP)
3. Phase 4 (US2) → Salary verification ("Did I get my salary?")
4. Phase 5 (US3) → Rent verification ("Did I pay my rent this month?")
5. Phase 6 (US4) → Recurring subscriptions/bills, duplicate/large charge anomalies, refunds & transfers
6. Phase 7 (Polish) → Instrumented A2UI test + full Gradle verification gates
