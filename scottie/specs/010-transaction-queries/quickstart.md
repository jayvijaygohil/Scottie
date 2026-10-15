# Quickstart: Validating Conversational Transaction Queries & Financial Insights

**Feature**: `010-transaction-queries` | **Spec**: [spec.md](spec.md) | **Plan**: [plan.md](plan.md)

## 1. Automated Verification Commands

Run from the repository root:

```sh
./gradlew :app:assembleDebug
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.interacbanking.*"
./gradlew :app:detekt :app:lintDebug
./gradlew :app:connectedDebugAndroidTest --tests "com.jayvijay.scottie.feature.interacbanking.*"
```

Expected host unit test suites:
- `MockInteracBankingToolsTest`: Verifies seeded transactions across the 4 accounts, reverse-chronological ordering, and that `executeSendTransfer` appends a `TRANSFER` debit transaction to the in-memory history.
- `TransactionInsightsTest`: Verifies all 4 workflows:
  1. Date-range queries (inclusive `[X, Y]`, inverted range swap, open-ended `startDate`, relative periods, empty range notice).
  2. Salary verification (`CONFIRMED` when current month has recurring payroll credit, `NOT_DETECTED` with historical reference when current month has none, exclusion of small ad-hoc inflows/refunds).
  3. Rent verification (`CONFIRMED` when current month has rent debit, `NOT_DETECTED` with prior month's rent reference when missing).
  4. Additional scenarios: recurring subscriptions & utility bills, merchant/category search, duplicate charge detection (within 48h) & unusually large charges (> threshold or > 3x median), and refunds/transfers lookup.
- `InteracAssistantAgentTest`: Verifies `TRANSACTIONS` intent and scenario extraction across representative prompts.
- `InteracSurfaceTemplatesTest` & `InteracAssistantPresenterTest`: Verify `TransactionList` A2UI surface envelopes, account-not-found alert fallback, and end-to-end presenter turn handling.

## 2. Interactive End-to-End Scenarios (Device / Emulator)

Prerequisites: Select a downloaded on-device text model (e.g., Gemma 4 E2B) or configured OpenRouter model in the chat toolbar.

| Workflow | Prompt to Type | Expected Surface Outcome |
|---|---|---|
| 1. Date-Range Query | `Show my transactions from last month` | `TransactionList` card listing all seeded transactions from the previous calendar month, newest first, with inflow/outflow totals. |
| 2. Salary Verification | `Did I get my salary this month?` | `TransactionList` card with `SALARY_CHECK` header, `Confirmed` badge, and the recurring payroll deposit(s) (`ADP PAYROLL` / `DIRECT DEP ACME CORP`). |
| 3. Rent Verification | `Did I pay my rent this month?` | `TransactionList` card with `RENT_CHECK` header, `Confirmed` badge, and the current + historical monthly $2,100.00 rent payments. |
| 4a. Subscriptions & Bills | `What are my recurring subscriptions and utility bills?` | `TransactionList` card showing recurring monthly charges (`StreamFlix`, `CloudMusic`, `Toronto Hydro`, `Bell Internet`) with `RECURRING` badges. |
| 4b. Merchant / Category | `How much did I spend on groceries?` | `TransactionList` card filtered to `GROCERIES` transactions with total outflow. |
| 4c. Anomalies (Duplicates / Large) | `Are there any duplicate or unusual charges?` | `TransactionList` card flagging the duplicate consecutive-day charge (`DUPLICATE` badge) and the $899.99 electronics purchase (`LARGE_CHARGE` badge). |
| 4d. Refunds & Live Transfer | Send $50 to Alice, then ask `Show my recent transfers and refunds` | Includes the newly sent $50 transfer to Alice alongside seeded transfers and the TechMart refund. |
