# Data Model: Conversational Transaction Queries & Financial Insights

**Feature**: `010-transaction-queries` | **Date**: 2026-10-14

Types live in `feature/interacbanking/domain/entities/InteracBanking.kt` and
`feature/interacbanking/domain/usecase/TransactionInsights.kt` unless noted.

## Domain entities (`domain/entities/InteracBanking.kt`)

### TransactionDirection (**new**)

```kotlin
@Serializable
enum class TransactionDirection {
  CREDIT,
  DEBIT,
}
```

### TransactionCategory (**new**)

```kotlin
@Serializable
enum class TransactionCategory {
  INCOME,
  HOUSING,
  UTILITIES,
  SUBSCRIPTIONS,
  GROCERIES,
  DINING,
  TRANSPORT,
  SHOPPING,
  TRANSFER,
  REFUND,
}
```

### Transaction (**new**)

| Field | Type | Constraints / Notes |
|---|---|---|
| `transactionId` | `String` | Non-blank unique identifier (e.g., `txn_101` or `TRF-...` for session sends) |
| `accountId` | `String` | Matches an `Account.accountId` (`acc_chk_101`, `acc_sav_202`, `acc_chk_303`, `acc_cc_404`) |
| `accountName` | `String` | Display name of the account (e.g., `Everyday Chequing`) |
| `date` | `String` | ISO-8601 local calendar date `YYYY-MM-DD` |
| `descriptor` | `String` | Raw statement descriptor (e.g., `ADP PAYROLL - ACME CORP`, `MAPLE PROPERTY MGMT RENT`) |
| `merchant` | `String` | Normalized merchant or counterparty name (e.g., `Acme Corp Payroll`, `Maple Property Mgmt`) |
| `category` | `TransactionCategory` | Primary classification |
| `direction` | `TransactionDirection` | `CREDIT` (inflow) or `DEBIT` (outflow) |
| `amount` | `Double` | Positive CAD amount (`> 0.0`) |
| `currency` | `String` | Default `"CAD"` |

Validation rules:
- `amount > 0.0`
- `date` parses as `java.time.LocalDate`
- Session transfers created via `executeSendTransfer` append a `Transaction` with `direction = DEBIT`,
  `category = TRANSFER`, `date = LocalDate.now(clock).toString()`, and `transactionId = referenceId`.

## Agent intent contract (`domain/agent/workflow/AssistantIntent.kt`)

### AssistantIntent (**extended**)

| Field | Type | Notes |
|---|---|---|
| `intent` | `Intent` (`BALANCE`, `SEND`, `REQUEST`, `TRANSACTIONS` **new**, `OTHER`) | `TRANSACTIONS` for any read-only transaction history or financial insight query |
| `amount` | `Double?` | For `SEND`/`REQUEST`, transfer amount; for `TRANSACTIONS`, optional minimum amount threshold (e.g., `500.0` for "charges over $500") |
| `recipientQuery` | `String?` | Unchanged; also used as fallback counterparty filter in `REFUNDS_TRANSFERS` if `searchQuery` is null |
| `accountHint` | `String?` | Unchanged; filters transactions to matched account(s) |
| `memo` | `String?` | Unchanged |
| `channelHint` | `ChannelHint?` | Unchanged |
| `scenario` | `TransactionScenario?` **new** | `DATE_RANGE`, `SALARY_CHECK`, `RENT_CHECK`, `SUBSCRIPTIONS_BILLS`, `MERCHANT_CATEGORY`, `ANOMALIES`, `REFUNDS_TRANSFERS` |
| `startDate` | `String?` **new** | Optional ISO date `YYYY-MM-DD` or relative date token (`today`, `this_week`, `this_month`, `last_month`, `last_7_days`, `last_30_days`) |
| `endDate` | `String?` **new** | Optional ISO date `YYYY-MM-DD` |
| `searchQuery` | `String?` **new** | Optional merchant, descriptor, or category keyword (e.g., `"Uber"`, `"groceries"`, `"hydro"`, `"refund"`) |
| `reply` | `String?` | Unchanged |

## Insight evaluation models (`domain/usecase/TransactionInsights.kt`)

### VerificationStatus (**new**)

```kotlin
enum class VerificationStatus {
  NONE,          // Non-verification list queries (DATE_RANGE, MERCHANT_CATEGORY, SUBSCRIPTIONS_BILLS, etc.)
  CONFIRMED,     // Matching salary/rent/anomaly/refund found in target period
  NOT_DETECTED,  // No salary/rent found in target period (historical references may still be shown)
}
```

### InsightBadge (**new**)

```kotlin
enum class InsightBadge {
  SALARY,
  RENT,
  RECURRING,
  DUPLICATE,
  LARGE_CHARGE,
  REFUND,
  TRANSFER,
}
```

### FlaggedTransaction (**new**)

| Field | Type | Notes |
|---|---|---|
| `transaction` | `Transaction` | The underlying transaction record |
| `badge` | `InsightBadge?` | Optional insight tag explaining why this row was matched/flagged |
| `isReference` | `Boolean` | `true` when shown as historical comparison (e.g., prior month's salary/rent) |

### TransactionQueryResult (**new**)

| Field | Type | Notes |
|---|---|---|
| `scenario` | `TransactionScenario` | Resolved scenario (defaults to `DATE_RANGE` when unspecified) |
| `status` | `VerificationStatus` | `CONFIRMED`, `NOT_DETECTED`, or `NONE` |
| `items` | `List<FlaggedTransaction>` | Primary matched transactions (plus historical reference rows when `status == NOT_DETECTED` or for salary/rent context), newest first |
| `matchCount` | `Int` | Count of primary (non-reference) matched transactions |
| `totalInflow` | `Double` | Sum of `CREDIT` amounts among primary matches |
| `totalOutflow` | `Double` | Sum of `DEBIT` amounts among primary matches |
| `periodLabel` | `String?` | Resolved ISO range `"YYYY-MM-DD..YYYY-MM-DD"` when a date window applied |
| `queryLabel` | `String?` | Resolved search keyword or account filter label |
| `accountNotFoundHint` | `String?` | Populated when `accountHint` matched no account (triggers `Alert.ACCOUNT_NOT_FOUND`) |
