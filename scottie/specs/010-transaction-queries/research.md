# Research: Conversational Transaction Queries & Financial Insights

**Feature**: `010-transaction-queries` | **Date**: 2026-10-14

All decisions below were verified against the existing `feature/interacbanking` architecture,
`.specify/memory/constitution.md`, `jetbrains-koog` skill (`1.3.0` / `1.3.0-beta`), and
`android-a2ui-compose` skill (`1.0.0-alpha01`).

## R1. Intent extraction vs. tool calling for transaction queries

**Decision**: Keep the single-agent structured intent architecture from feature 005 (`AssistantIntent`
returned by `InteracAssistantAgent`) and add `TRANSACTIONS` to `AssistantIntent.Intent` along with
lightweight query slot fields (`scenario`, `startDate`, `endDate`, `searchQuery`). The presenter and
a pure domain use case (`TransactionInsights`) resolve dates, filter transactions, and run pattern
detection deterministically against `InteracBankingTools.getTransactions()`. Also expose a read-only
`@Tool fun getTransactions()` on `MockInteracBankingTools` so tool-capable models may inspect recent
entries if they choose, while the presenter always resolves the authoritative result set.

**Rationale**:
- On-device LiteRT models (Gemma 4 E2B, Qwen3 0.6B) and remote OpenRouter models already reliably
  produce `AssistantIntent` JSON in one turn. Asking a small on-device model to compute 15% payroll
  variance, 10% rent variance, 48-hour duplicate windows, or 3x median outlier math in free-form
  text is brittle and untestable.
- Having the model extract *what the user asked* (`scenario`, raw/ISO date bounds or relative period
  phrase, `searchQuery`, `accountHint`, `amount` threshold) and letting pure Kotlin domain logic
  (`TransactionInsights`) compute the exact matches guarantees 100% deterministic accuracy (SC-001,
  SC-002, SC-003) and keeps the system prompt compact.
- Injecting the current local date (`LocalDate.now(clock)`) into the agent prompt lets the LLM
  resolve relative phrases ("this month", "last month", "last 7 days") directly into `startDate` /
  `endDate` (`YYYY-MM-DD`), with a deterministic fallback parser in `TransactionInsights` if the
  model copies a raw relative phrase or omits dates for a scenario with an implied period (e.g.,
  `RENT_CHECK` defaults to current month).

**Alternatives considered**:
- *Multi-tool agent with separate `@Tool` methods per workflow (`verifySalary`, `verifyRent`,
  `findAnomalies`, `queryByDateRange`) returning prose*: Rejected because the UI renders structured
  A2UI cards (FR-011), not raw model prose, and extra tool round-trips multiply on-device latency.
- *Separate `AIAgent` for transactions*: Rejected under Constitution Principle V (Simplicity); one
  `InteracAssistantAgent` handles all banking chat turns.

## R2. Deterministic financial insight heuristics (`TransactionInsights`)

**Decision**: Implement all four workflows in a pure, stateless domain object `TransactionInsights`
in `feature/interacbanking/domain/usecase/TransactionInsights.kt` (zero Android/framework imports):

1. **Date-Range & General Filtering (`DATE_RANGE`, `MERCHANT_CATEGORY`)**:
   - Parse `startDate` and `endDate` (`LocalDate.parse`); if inverted (`start > end`), swap to
     `[end, start]` (spec edge case). If only `startDate` is given, `endDate = today`.
   - Filter by resolved account(s) when `accountHint` matches via `InteracResolution.matchAccounts`;
     if `accountHint` is non-blank and matches no account, attach `Notice.AccountNotFound(hint)` and
     query across all accounts (spec edge case & FR-012).
   - Match `searchQuery` case-insensitively against `merchant`, `descriptor`, and `category.name`.
   - Sort results by `date` descending, then `id` descending.

2. **Salary Verification (`SALARY_CHECK`)**:
   - Candidate filter: `direction == CREDIT` and (`category == INCOME` or payroll keyword in
     descriptor/merchant: `PAYROLL`, `SALARY`, `DIRECT DEP`, `PAYCHEQUE`, `PAYCHECK`, `EMPLOYER`, or
     recurring monthly/bi-weekly inflow of ≥ $500 whose amounts fall within ±15% of the group
     median). Small ad-hoc transfers/refunds are excluded.
   - Target period: `startDate..endDate` if explicitly provided, otherwise the current calendar
     month (`YearMonth.from(today)`).
   - Verification status: `CONFIRMED` if ≥ 1 candidate falls in the target period; `NOT_DETECTED` if
     0 fall in the target period (with historical candidates returned as `referenceTransactions` so
     the user sees their prior paycheck dates/amounts).

3. **Rent Verification (`RENT_CHECK`)**:
   - Candidate filter: `direction == DEBIT` and (`category == HOUSING` or rent keyword in
     descriptor/merchant: `RENT`, `LEASE`, `PROPERTY`, `LANDLORD`, `APARTMENT`, `MGMT`, or recurring
     monthly outflow ≥ $500 across ≥ 2 calendar months with amounts within ±10% of the group
     median).
   - Target period: `startDate..endDate` if provided, otherwise current calendar month.
   - Verification status: `CONFIRMED` if ≥ 1 candidate falls in the target month (returning current
     month + prior months' rent payments for confirmation); `NOT_DETECTED` if missing in the target
     month (returning prior rent payments as `referenceTransactions`).

4. **Additional Financial Scenarios**:
   - **`SUBSCRIPTIONS_BILLS`**: `direction == DEBIT` where `category in {SUBSCRIPTIONS, UTILITIES}`
     or the same normalized `merchant` appears in ≥ 2 distinct calendar months with amounts within
     ±15% (excluding rent).
   - **`ANOMALIES`**:
     - *Duplicate charges*: Two or more `DEBIT` transactions on the same account with the same
       normalized `merchant` and exact `amount` whose `date` values are within 2 calendar days
       (`abs(ChronoUnit.DAYS.between(d1, d2)) <= 2`, covering the 48-hour window on calendar dates).
     - *Unusually large charges*: `DEBIT` transactions (excluding `HOUSING`/rent) where `amount`
       exceeds the user's `amount` threshold (if specified, e.g. "over $500") or exceeds `3.0 *`
       the median of non-housing debit amounts (minimum floor $250).
   - **`REFUNDS_TRANSFERS`**:
     - If `searchQuery` or prompt indicates refunds (`category == REFUND`), return `REFUND` credits.
     - If transfers (`category == TRANSFER`), return `TRANSFER` credits and debits (optionally
       filtered by `searchQuery` / `recipientQuery` for party name like "Alice").
     - Otherwise return both `REFUND` and `TRANSFER` transactions.

**Rationale**: Pure functions over an in-memory list of ~30–40 transactions run in < 1 ms on JVM,
are 100% unit-testable without coroutines or mocks, and satisfy every acceptance scenario in US1–US4.

## R3. Anchored mock transaction seed data & session mutation

**Decision**: Seed `MockInteracBankingTools` (injected with `Clock = Clock.systemDefaultZone()` via a
default parameter so unit tests can pass a fixed `Clock.fixed(...)`) with ~28 realistic transactions
anchored relative to `YearMonth.from(LocalDate.now(clock))` (`currentMonth`, `currentMonth.minusMonths(1)`,
`currentMonth.minusMonths(2)`):
- **Salary credits** (`Everyday Chequing`): bi-monthly/monthly payroll deposits with varied
  descriptors (`ADP PAYROLL - ACME CORP`, `DIRECT DEP ACME CORP`, `CANADA PAYROLL ACME`) around
  $3,250–$3,280 in `M-2`, `M-1`, and on the 1st/15th of `M` (clamped to `today` so current-month
  salary is deterministic).
- **Rent debits** (`Everyday Chequing`): monthly outflows on the 1st of `M-2`, `M-1`, and `M`
  (`MAPLE PROPERTY MGMT RENT`, `E-TRANSFER RENT LANDLORD`) for $2,100.00.
- **Subscriptions & Utilities** (`Rewards Visa` & `Everyday Chequing`): `STREAMFLIX`, `CLOUDMUSIC`,
  `TORONTO HYDRO`, `BELL INTERNET` recurring across `M-2`, `M-1`, `M`.
- **Groceries, Dining, Transport, Shopping**: `FRESHCO GROCERIES`, `METRO MARKET`, `TIM HORTONS`,
  `UBER TRIP`, `TECHMART ELECTRONICS` (including an $899.99 unusually large purchase on `Rewards Visa`).
- **Duplicate charge pair**: Two identical `CITY PARKING` or `STREAMFLIX` $18.99 debits on consecutive
  days in the current month on `Rewards Visa`.
- **Refunds & Transfers**: `TECHMART REFUND` ($124.50 credit), `INTERAC E-TRF - ALICE MARTIN` ($50.00
  debit), `INTERAC E-TRF - BOB VANCE` ($35.00 credit).
- **Session integration (FR-010)**: When `executeSendTransfer` succeeds, prepend a new `Transaction`
  (`id = referenceId`, `accountId = fromAccountId`, `date = LocalDate.now(clock).toString()`,
  `descriptor = "INTERAC E-TRF TO ${contact.name.uppercase()}"`, `merchant = contact.name`,
  `category = TransactionCategory.TRANSFER`, `direction = TransactionDirection.DEBIT`,
  `amount = amount`) to the synchronized `transactions` list.

**Rationale**: Anchoring to `YearMonth.from(LocalDate.now(clock))` ensures queries like "Did I pay my
rent this month?", "Did I get my salary?", and "last month's transactions" always match regardless
of the calendar date when tests or device demos run, while a fixed `Clock` in unit tests makes exact
date assertions (`2026-10-01` etc.) completely deterministic.

## R4. A2UI surface representation for transaction results

**Decision**: Add one custom A2UI component `TransactionList` (`components/TransactionList.kt`) to
`interacCatalog()` and one template builder `InteracSurfaceTemplates.transactionResults(...)`.
- The surface root `Column` contains:
  - Optional `Alert` when an `accountHint` was not found (`Notice.AccountNotFound`) or when a
    verification check (`SALARY_CHECK`, `RENT_CHECK`) detected no match in the target period.
  - `TransactionList` component bound to `/summary` (`scenarioCode`, `statusCode`, `count`,
    `totalAmount`, `inflowAmount`, `outflowAmount`, `periodLabel`, `queryLabel`) and `/items`
    (JSON array of `{id, date, merchant, descriptor, categoryCode, accountName, directionCode,
    amount, badgeCode}`).
- Consistent with Constitution Principle II and feature 005, the A2UI JSON payload carries only
  locale-independent codes (`scenarioCode`, `statusCode`, `categoryCode`, `directionCode`,
  `badgeCode`) and formatted data; `TransactionList` resolves all user-visible labels and status
  banners from `res/values/strings.xml` via `stringResource`.

**Rationale**: A single `TransactionList` component (mirroring `Confirmation` and `InteracForm`)
avoids emitting 30×5 individual A2UI component nodes per turn, renders cleanly inside the chat
turn's `A2uiSurface`, and is directly testable with `A2uiTestController` and `InteracSurfaceTemplatesTest`.

**Alternatives considered**:
- *Emitting one `TransactionCard` A2UI component per transaction*: Creates 30+ A2UI components and
  150+ path bindings per surface, bloating JSON envelopes and slowing surface assembly. Rejected.
