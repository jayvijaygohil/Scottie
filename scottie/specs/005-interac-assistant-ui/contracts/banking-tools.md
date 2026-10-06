# Contract: InteracBankingTools (domain) and Koog ToolSet exposure

Interface: `feature/interacbanking/domain/agent/tools/InteracBankingTools.kt`.
Implementation: `feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt` (`@Singleton`,
`@Synchronized`, in-memory; balances and saved contacts reset on process restart).
Failures throw `IllegalArgumentException` whose `message` is the user-facing text (shown verbatim,
FR-022).

## Methods

| Method | Exposed to the model (`@Tool`) | Change |
|---|---|---|
| `getAccountBalances(): List<Account>` | yes | 4 accounts |
| `findContacts(query: String?): List<InteracContact>` | yes | ranked fuzzy (research R6); null/blank → all |
| `saveContact(name: String, email: String?, phoneNumber: String?): InteracContact` | **no** | new; requires non-blank name and ≥ 1 destination |
| `insufficientBalanceMessage(account: Account, amount: Double): String` | **no** | new; pure formatter on the interface so presenter (FR-016 pre-check) and service rejection share one string |
| `executeSendTransfer(fromAccountId, recipient: Recipient, amount, deliveryChannel, securityQuestion?, securityAnswer?): TransferResult` | **no** (removed `@Tool`) | `recipient` replaces `recipientId` |
| `executeRequestMoney(recipient: Recipient, depositAccountId, amount, deliveryChannel, memo?): MoneyRequestResult` | **no** (removed `@Tool`) | `recipient` replaces `fromContactId`; result carries `memo` |

Removing `@Tool` from send/request is what guarantees the security answer never enters the model
context (FR-025) and that the model cannot submit (FR-011). The presenter calls them directly.

## Rejection messages (exact strings)

| Condition | Message |
|---|---|
| amount ≤ 0 | `Amount must be greater than 0.` |
| unknown account id | `Account <id> not found.` |
| unknown contact id | `Contact <id> not found.` |
| send from credit | `<name> is a credit card and can't be used to send money.` |
| request into credit | `<name> is a credit card and can't receive a money request.` |
| insufficient | `Insufficient balance in <name>: available <balance>, requested <amount>.` (unchanged) |
| channel missing on recipient | `<name> has no <email|phone number> for <EMAIL|PHONE> delivery.` (unchanged; spec scenario 12 depends on it) |
| no autodeposit, blank Q/A | `Recipient does not have Autodeposit enabled. A security question and answer are required.` (unchanged) |
| manual recipient with no destination | `Enter an email or a phone number for the recipient.` |
| saveContact blank name | `Enter a name for the contact.` |

## Behavioural invariants (tests)

- Send success (SENT or PENDING) debits immediately; rejection leaves balances unchanged.
- Request never changes balances and never checks them.
- Results never contain the security answer.
- Concurrent sends from one account never overdraw (existing test kept).
- `findContacts` ordering and scores per research R6 table; empty result for "zzz".
- Saved contact appears in subsequent `findContacts`; has `autodepositEnabled = false`.
