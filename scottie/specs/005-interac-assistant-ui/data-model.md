# Data Model: Conversational Interac e-Transfer Assistant

**Feature**: `005-interac-assistant-ui` | **Date**: 2026-10-06

Types live in `feature/interacbanking/domain/entities/InteracBanking.kt` unless noted. Existing
types are kept; changes are marked **new** / **changed**.

## Banking entities (domain)

### Account (unchanged shape)

| Field | Type | Notes |
|---|---|---|
| accountId | String | `acc_chk_101`, `acc_sav_202`, **new** `acc_chk_303`, `acc_cc_404` |
| name | String | Everyday Chequing, High-Interest Savings, Joint Chequing, Rewards Visa |
| type | AccountType | CHEQUING, SAVINGS, CREDIT, LINE_OF_CREDIT |
| accountNumberMask | String | `**** 4821`, `**** 8830`, `**** 1177`, `**** 3092` |
| availableBalance | Double | 1540.25, 6200.00, 85.40, 2500.00 (available credit) |
| currency | String | `CAD` |

Rule: `type == CREDIT` → never a send source, never a request deposit (FR-006).

### InteracContact (unchanged shape, 3 new rows)

| contactId | name | email | phone | autodeposit |
|---|---|---|---|---|
| ct_alice | Alice Martin | alice.m@example.com | — | on |
| ct_bob | Bob Vance | — | +1-416-555-0143 | off |
| ct_charlie | Charlie Chen | charlie.c@example.ca | +1-647-555-0199 | off |
| ct_jane **new** | Jane Doe | jane.doe@example.com | +1-905-555-0122 | on |
| ct_alicia **new** | Alicia Moreno | alicia.moreno@example.com | — | off |
| ct_robert **new** | Robert Singh | — | +1-289-555-0177 | on |

Saved-at-runtime contacts: `contactId = "ct_" + 8 alphanumerics`, `autodepositEnabled = false`,
live in the singleton's memory for the run (FR-004).

### Recipient (**new**, sealed)

```kotlin
sealed interface Recipient {
  data class Saved(val contactId: String) : Recipient
  data class Manual(val email: String?, val phoneNumber: String?) : Recipient // ≥ 1 non-null
}
```

Resolution inside the service: `Saved` → the contact; `Manual` → a transient `InteracContact`
(name = the email or phone, `autodepositEnabled = false`). Validation: `Manual` with both null →
`IllegalArgumentException("Enter an email or a phone number for the recipient.")`.

### TransferResult (unchanged)

### MoneyRequestResult (**changed**: `+ memo: String?`)

### Status enums (unchanged): `TransferStatus { SENT, PENDING_SECURITY_ANSWER }`,
`MoneyRequestStatus { REQUEST_SENT }`, `DeliveryChannel { EMAIL, PHONE }` (UI label for PHONE is
"SMS").

## Agent contract (domain/agent/workflow)

### AssistantIntent (**new**, `@Serializable`, the model's only output)

| Field | Type | Meaning |
|---|---|---|
| intent | enum `BALANCE`, `SEND`, `REQUEST`, `OTHER` | What the user wants |
| amount | Double? | As typed, e.g. 50.0; null when absent |
| recipientQuery | String? | The raw name/email/phone fragment the user gave |
| accountHint | String? | Raw account phrase: "savings", "Everyday Chequing", "ending 4821", "TFSA" |
| memo | String? | Request memo ("dinner") |
| channelHint | enum `EMAIL`, `SMS`, null | Only when the user said it ("by text", "email her"); mapped by the presenter to `DeliveryChannel` (`SMS → PHONE`) |
| reply | String? | One-sentence assistant text; required when `intent == OTHER` |

Invariant: the model never emits ids, balances, or resolved contacts; anything it invents is
ignored because the presenter re-resolves from the service (FR-011).

## Presentation state (feature/interacbanking/presentation)

### InteracAssistantState (`CircuitUiState`)

| Field | Type | Notes |
|---|---|---|
| modelName | String | From screen key via catalog lookup; shown in toolbar subtitle |
| turns | List\<AssistantTurn\> | Oldest first |
| input | String | Composer text |
| busy | Boolean | Inference or submission in flight; disables Send and the form's submit |
| surfaces | List\<A2uiSurfaceModel\> | From the bridge; rendered in turn order by `surfaceId` |
| eventSink | (InteracAssistantAction) -> Unit | |

### AssistantTurn (**new**)

```kotlin
data class AssistantTurn(
  val id: Int,
  val userText: String,
  val reply: TurnReply,        // Text(message) | Surface(surfaceId) | Fallback(message)
  val firstCardMs: Long?,      // debug latency, null until measured
)
```

### FormDraft (presenter-owned mirror of `/form/*`, **new**)

Populated when the user submits; fields mirror the A2UI data model so the presenter validates
before calling the service:

| Path | Type | Rule |
|---|---|---|
| /form/mode | "send" \| "request" | static |
| /form/amount | String | `> 0`, ≤ 2 decimals |
| /form/recipientQuery | String | autocomplete source text |
| /form/recipientId | String? | selected saved contact |
| /form/manualEmail, /form/manualPhone | String? | manual mode; ≥ 1 |
| /form/saveContact | Boolean | manual mode only |
| /form/channel | "" \| "EMAIL" \| "PHONE" | must be non-empty unless `channelLocked` |
| /form/channelLocked | Boolean | true → read-only label |
| /form/accountId | String | chosen source/deposit |
| /form/securityRequired | Boolean | = !autodeposit or manual |
| /form/securityQuestion, /form/securityAnswer | String | required when `securityRequired`; trimmed non-empty |
| /form/memo | String? | request only |
| /form/valid | Boolean | computed by the component on every edit; presenter recomputes on submit |
| /suggestions | List\<{id,label,detail,autodeposit}\> | presenter-written on `recipientQuery` events |
| /options/recipients | same shape | initial candidate list |
| /options/accounts | List\<{id,label,detail}\> | eligible accounts in priority order |

State transitions of a form surface: `shown` → (edits, suggestions) → `submitting` (busy) →
`replaced by Confirmation surface` | `error Alert appended + form re-enabled`.

## A2UI data for non-form surfaces

- `BalanceCard` × n: `/accounts/<i>/{name,type,mask,balance,currency}`; preceded by an `Alert`
  when the account was not found or the amount could not be covered.
- `Confirmation`: `/result/{status,reference,amount,recipient,channel,destination,account,memo,time}`.
- Off-topic / fallback / rejection: a `Text` or `Alert` surface, or plain turn text when no surface
  is useful.

## Navigation key and cross-feature seam

```kotlin
// feature/interacbanking/presentation/InteracAssistantScreen.kt
@Parcelize data class InteracAssistantScreen(val modelId: String) : ParcelableScreen

// feature/modeldownload/presentation/TextModelDestination.kt
fun interface TextModelDestination { fun screen(modelId: String): Screen }
// di/InteracModule: @Provides fun textModelDestination() = TextModelDestination { InteracAssistantScreen(it) }
```

`modelId` is the `.litertlm` file name (the catalog `CatalogModel.id`).

## Notice (presentation)

```kotlin
sealed interface Notice {
  data class AccountNotFound(val hint: String) : Notice
  data class NoAccountCovers(val amount: String) : Notice
}
```

Travels in A2UI data as `noticeKind` + `noticeArg`; the `Alert` component resolves the copy.
