# Contract: Interac Banking Tools

The LLM sees these tools through `MockInteracBankingTools().asTools()`. Tool names are the Kotlin
method names. Types are listed in [data-model.md](../data-model.md).

Koog 1.3.0 lists every reflective parameter as required in the tool schema, and types nullable ones
as `<type> | null`. "Optional" below means nullable with a Kotlin `= null` default: the model is
asked to send the key, with `null` when unused, and an omitted key still falls back to the default.
Each optional parameter's `@LLMDescription` must say when to pass `null`.

The class-level `@LLMDescription` is: "Interac e-Transfer tools for the signed-in user's mock CAD
accounts and saved contacts."

## getAccountBalances

- Args: none.
- Returns: `List<Account>` with current in-memory balances.
- Description: list accounts, balances, and types. Use it to resolve phrases such as "from my
  chequing" and to check that a transfer amount fits the balance.

## findContacts

- Args: `query: String? = null`, a case-insensitive substring of the name, email, or phone. Blank
  or absent returns all contacts.
- Returns: `List<InteracContact>`; empty when nothing matches.

## executeSendTransfer

| Arg | Type | Required |
|---|---|---|
| fromAccountId | String | yes |
| recipientId | String | yes (contactId) |
| amount | Double | yes, > 0, ≤ balance |
| deliveryChannel | DeliveryChannel | yes, must exist on contact |
| securityQuestion | String? | required when the recipient's Autodeposit is off |
| securityAnswer | String? | required when the recipient's Autodeposit is off |

- Returns: `TransferResult`. The status is `SENT` when Autodeposit is on and
  `PENDING_SECURITY_ANSWER` when it is off.
- Side effect: the source balance is reduced by `amount`.
- Errors (`IllegalArgumentException`), in check order:
  - `Amount must be greater than 0.`
  - `Account <id> not found.`
  - `Insufficient balance in <name>: available <bal>, requested <amount>.`
  - `Contact <id> not found.`
  - `<name> has no <email|phone number> for <EMAIL|PHONE> delivery.`
  - `Recipient does not have Autodeposit enabled. A security question and answer are required.`
    (exact wording, FR-007)

## executeRequestMoney

| Arg | Type | Required |
|---|---|---|
| fromContactId | String | yes |
| depositAccountId | String | yes |
| amount | Double | yes, > 0 |
| deliveryChannel | DeliveryChannel | yes, must exist on contact |
| memo | String? | no; not echoed |

- Returns: `MoneyRequestResult` with status `REQUEST_SENT`.
- Side effect: none.
- Errors: the same amount, account, contact, and channel messages as `executeSendTransfer`.

## Agent instructions (`INTERAC_AGENT_INSTRUCTIONS`)

The system prompt must contain these rules (FR-014, FR-015):

1. Resolve accounts with `getAccountBalances` and recipients with `findContacts`. Never invent IDs.
2. If a contact has both email and phone, render an A2UI choice (radio or dropdown) for Email or
   Phone with nothing preselected, and never guess. With one channel, select it automatically.
3. If `autodepositEnabled` is false, the transfer form must include "Security Question" and
   "Security Answer" inputs and must collect both before calling `executeSendTransfer`. If it is
   true, omit those inputs and show an "Autodeposit Active" badge.
4. On a tool failure, relay the stated reason to the user and do not retry with guessed values.
