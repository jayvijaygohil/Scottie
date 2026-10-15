# Contract: Transaction Queries in `InteracBankingTools` & `TransactionList` A2UI Surface

## 1. `InteracBankingTools` extension

Interface: `feature/interacbanking/domain/agent/tools/InteracBankingTools.kt`
Implementation: `feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt`

| Method | Exposed to model (`@Tool`) | Behavior |
|---|---|---|
| `getTransactions(): List<Transaction>` | Yes | Returns all posted transactions across all accounts in reverse chronological order (`date` descending), including any `executeSendTransfer` transactions recorded during the current process session. |

Session invariant (FR-010):
- Every successful `executeSendTransfer(...)` call records a new `DEBIT` `Transaction` (`category = TRANSFER`, `transactionId = referenceId`, `date = LocalDate.now(clock).toString()`) in `MockInteracBankingTools` before returning `TransferResult`.
- Failed `executeSendTransfer` calls and `executeRequestMoney` calls do not add posted transactions.

## 2. `TransactionList` A2UI component (`components/TransactionList.kt`)

Registered in `interacCatalog()` under `INTERAC_CATALOG_ID` (`com.jayvijay.scottie/a2ui/interac/v1`).

### Properties

| Property | Kind | Path Binding | Values / Meaning |
|---|---|---|---|
| `scenarioCode` | Dynamic String (required) | `/summary/scenarioCode` | `TransactionScenario.name` (`DATE_RANGE`, `SALARY_CHECK`, `RENT_CHECK`, `SUBSCRIPTIONS_BILLS`, `MERCHANT_CATEGORY`, `ANOMALIES`, `REFUNDS_TRANSFERS`) |
| `statusCode` | Dynamic String (required) | `/summary/statusCode` | `VerificationStatus.name` (`NONE`, `CONFIRMED`, `NOT_DETECTED`) |
| `count` | Dynamic Int / String (required) | `/summary/count` | Number of primary matched transactions |
| `inflowAmount` | Dynamic String | `/summary/inflowAmount` | Formatted CAD sum of matched credits (e.g., `"3,250.00"`) |
| `outflowAmount` | Dynamic String | `/summary/outflowAmount` | Formatted CAD sum of matched debits (e.g., `"2,100.00"`) |
| `periodLabel` | Dynamic String | `/summary/periodLabel` | Optional date range string (`"2026-10-01 – 2026-10-14"`) |
| `queryLabel` | Dynamic String | `/summary/queryLabel` | Optional merchant/category/account filter label |
| `items` | Dynamic Object List (required) | `/items` | Array of item objects (see below) |

### Item object shape in `/items`

```json
{
  "id": "txn_101",
  "date": "2026-10-01",
  "merchant": "Maple Property Mgmt",
  "descriptor": "MAPLE PROPERTY MGMT RENT",
  "categoryCode": "HOUSING",
  "accountName": "Everyday Chequing",
  "directionCode": "DEBIT",
  "amount": "2,100.00",
  "currency": "CAD",
  "badgeCode": "RENT",
  "isReference": false
}
```

### Rendering rules

- Header displays localized scenario title and, when `statusCode` is `CONFIRMED` or `NOT_DETECTED`, a status badge (`XelaBadge`) and verification summary string resolved from `strings.xml`.
- When `count == 0` and `/items` is empty, renders the localized empty-result notice with `periodLabel` / `queryLabel`.
- When `statusCode == NOT_DETECTED` and `/items` contains historical reference rows (`isReference = true`), renders the empty current-period notice followed by a "Recent history" section containing those reference rows.
- Each row shows `merchant` (title), `descriptor` + `date` + `accountName` (subtitle), optional `badgeCode` (`XelaBadge` for `SALARY`, `RENT`, `RECURRING`, `DUPLICATE`, `LARGE_CHARGE`, `REFUND`, `TRANSFER`), and signed amount (`+$X.XX CAD` for `CREDIT`, `-$X.XX CAD` for `DEBIT`).
