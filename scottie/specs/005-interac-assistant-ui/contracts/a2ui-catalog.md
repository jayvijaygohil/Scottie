# Contract: Interac A2UI catalog and surface templates

Catalog id: `com.jayvijay.scottie/a2ui/interac/v1` (inline, app-owned). Built in
`feature/interacbanking/presentation/a2ui/InteracCatalog.kt` from
`materialA2uiBasicCatalogV1(...)` with: media components removed (`Image`, `Video`, `AudioPlayer`),
basic inputs removed (`TextField`, `CheckBox`, `ChoicePicker`, `Slider`, `DateTimeInput`, `Button`,
`Tabs`, `Modal`), and the custom components below added. Verified against A2UI 1.0.0-alpha01
(`androidx.a2ui.compose.ui.A2uiCatalog(catalogId, components, functions, themeSchema, isInline)`).

In design option (b) the **presenter**, not the model, emits these. The model's output is
`AssistantIntent` only.

## Components the presenter may emit

| Component | Source | Properties (D = dynamic/path-bindable, S = static) | Xela mapping |
|---|---|---|---|
| `Text`, `Column`, `Row`, `Card`, `Divider` | Material basic | as in basic catalog | — (Material 3, app theme) |
| `BalanceCard` | custom | `name` D str, `type` D str, `mask` D str, `balance` D str (formatted), `currency` D str, `highlight` D bool | `XelaText`, `XelaDivider`, `XelaBadge` for type |
| `Badge` | custom | `text` D str, `tone` S enum `success\|info\|warning` | `XelaBadge` |
| `Alert` | custom | `title` D str, `text` D str, `tone` S enum `error\|info` | `XelaAlert` |
| `Confirmation` | custom | `status` D, `reference` D, `amount` D, `party` D, `channel` D, `destination` D, `account` D, `memo` D (optional), `time` D | `XelaText`, `XelaBadge`, `XelaDivider` |
| `InteracForm` | custom | see below | `XelaTextField` (amount, question, memo; `secureField = true` for answer), `XelaRadioButtonGroup` (channel, account), `XelaChip` (recipient suggestions), `XelaCheckbox` (save contact), `XelaButton` (submit, `state = DISABLED` until valid) |

### `InteracForm` properties

| Property | Kind | Binding |
|---|---|---|
| `mode` | S enum `send\|request` | literal |
| `amount` | D str, writable | `/form/amount` |
| `recipientQuery` | D str, writable | `/form/recipientQuery` |
| `recipientId` | D str, writable | `/form/recipientId` |
| `manualEmail`, `manualPhone` | D str, writable | `/form/manualEmail`, `/form/manualPhone` |
| `saveContact` | D bool, writable | `/form/saveContact` |
| `suggestions` | D custom list `{id,label,detail,autodeposit}` | `/suggestions` |
| `recipients` | D custom list, same shape | `/options/recipients` |
| `accounts` | D custom list `{id,label,detail}` | `/options/accounts` |
| `accountId` | D str, writable | `/form/accountId` |
| `channel` | D str, writable (`""`, `EMAIL`, `PHONE`) | `/form/channel` |
| `channelLocked` | D bool | `/form/channelLocked` |
| `securityRequired` | D bool | `/form/securityRequired` |
| `securityQuestion`, `securityAnswer` | D str, writable | `/form/securityQuestion`, `/form/securityAnswer` |
| `memo` | D str, writable | `/form/memo` |
| `valid` | D bool, writable | `/form/valid` (component writes; presenter re-checks) |
| `busy` | D bool | `/form/busy` |
| `onQuery` | action | `{"event":{"name":"recipientQuery","context":{"query":{"path":"/form/recipientQuery"}}}}` |
| `onSelectRecipient` | action | `{"event":{"name":"selectRecipient","context":{"id":{"path":"/form/recipientId"}}}}` |
| `onSubmit` | action | `{"event":{"name":"submit","context":{ every `/form/*` path }}}` |

Rules enforced inside the component (Kotlin, tested with `A2uiTestController`):
- Submit enabled iff: amount valid; a recipient resolved (saved id or ≥ 1 manual destination);
  `channel` non-empty or `channelLocked`; `accountId` non-empty; when `securityRequired`, both
  security fields non-blank after `trim()`; not `busy`.
- Security answer rendered with `secureField = true`; never echoed in any label.
- When `channelLocked`, channel shows as a read-only row; otherwise a two-item radio group with no
  default selection. Changing recipient resets `channel` to `""` and recomputes `channelLocked` and
  `securityRequired` from the selected suggestion's data (saved) or from the manual fields.
- Request mode hides security fields and shows the memo field; no balance text.

## Message sequence per surface

```jsonl
{"version":"v0.9","createSurface":{"surfaceId":"turn-3","catalogId":"com.jayvijay.scottie/a2ui/interac/v1"}}
{"version":"v0.9","updateDataModel":{"surfaceId":"turn-3","path":"/","value":{"form":{...},"options":{...},"suggestions":[]}}}
{"version":"v0.9","updateComponents":{"surfaceId":"turn-3","components":[{"id":"root","component":"Column","children":["intro","form"]},{"id":"intro","component":"Text","text":"Send an Interac e-Transfer","variant":"h4"},{"id":"form","component":"InteracForm","mode":"send","amount":{"path":"/form/amount"}, ...}]}}
```

Later, autocomplete: `{"version":"v0.9","updateDataModel":{"surfaceId":"turn-3","path":"/suggestions","value":[{"id":"ct_alice","label":"Alice Martin","detail":"alice.m@example.com","autodeposit":true}]}}`.

After a successful submit the presenter sends `deleteSurface` for the form surface and creates a
`Confirmation` surface for the same turn. On rejection it appends an `Alert` component and sets
`/form/busy` to false.

## Template → spec rule mapping

| Spec rule | Where enforced |
|---|---|
| Never preselect channel when both exist | template writes `channel=""`, `channelLocked=false`; component never defaults |
| Security fields iff no Autodeposit / manual | template sets `securityRequired`; component toggles fields; service rejects anyway |
| Submit disabled until valid | component; presenter re-validates on `submit` event before calling the service |
| Answer masked | component (`secureField`) |
| Presenter calls send/request directly | `submit` event → presenter → `InteracBankingTools`; `AssistantIntent` has no such field and the agent registry has no such tool |
| Autocomplete without model | `recipientQuery` event → presenter → `findContacts` → `updateDataModel("/suggestions")` |
| Credit never offered | `eligibleSources/eligibleDeposits` exclude CREDIT when building `/options/accounts` |
