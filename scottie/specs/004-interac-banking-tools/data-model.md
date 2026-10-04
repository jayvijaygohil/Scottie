# Data Model: Mock Interac Banking Tools

All types live in `domain/entities/InteracBanking.kt` and are `@Serializable`.

## Enums

- **AccountType**: `CHEQUING`, `SAVINGS`, `CREDIT`, `LINE_OF_CREDIT`.
- **DeliveryChannel**: `EMAIL`, `PHONE`.

## Account

| Field | Type | Notes |
|---|---|---|
| accountId | String | `acc_chk_101`, `acc_sav_202` |
| name | String | |
| type | AccountType | |
| accountNumberMask | String | `**** 4821` |
| availableBalance | Double | CAD; reflects debits made in this process |
| currency | String | default `"CAD"` |

## InteracContact

| Field | Type | Notes |
|---|---|---|
| contactId | String | `ct_alice`, `ct_bob`, `ct_charlie` |
| name | String | |
| email | String? | |
| phoneNumber | String? | |
| autodepositEnabled | Boolean | |
| hasMultipleChannels | Boolean | computed getter: `email != null && phoneNumber != null`; not serialized |

## TransferResult

Fields: `referenceId` (`TRF-[A-Z0-9]{8}`), `status` (`SENT` | `PENDING_SECURITY_ANSWER`),
`amount`, `recipient` (contact name), `deliveryChannel`, `destination` (email or phone used),
`fromAccount` (account name), `timestamp` (ISO-8601 UTC). There is no security answer field
(FR-012).

## MoneyRequestResult

Fields: `referenceId` (`REQ-[A-Z0-9]{8}`), `status` (`REQUEST_SENT`), `amount`, `requestee`
(contact name), `deliveryChannel`, `destination`, `depositAccount` (account name), `timestamp`.

## Validation rules

Rules are checked in this order, and the first failure throws `IllegalArgumentException`.

**Send**:
1. `amount > 0`
2. The source account exists.
3. `amount <=` the current balance.
4. The recipient exists.
5. The channel has a destination.
6. If Autodeposit is off, the security question and answer are both non-blank.

**Request**:
1. `amount > 0`
2. The deposit account exists.
3. The contact exists.
4. The channel has a destination.

## State transitions

Only the balance changes:

```text
initial (FR-001) --successful send(amount)--> balance - amount   (SENT or PENDING_SECURITY_ANSWER)
any             --rejected send / request-->  unchanged
any             --process restart-->          initial
```
