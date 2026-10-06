# Tasks: Mock Interac Banking Tools

**Input**: Design documents from `scottie/specs/004-interac-banking-tools/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, contracts/interac-tools.md,
quickstart.md

**Tests**: Included. plan.md and quickstart.md require JVM tests for every acceptance scenario in
one file.

**Organization**: Tasks are grouped by user story. Paths are relative to the repository root. `SRC`
means `app/src/main/java/com/jayvijay/scottie` and `TEST` means
`app/src/test/java/com/jayvijay/scottie`.

Koog APIs are the resolved 1.3.0 versions (research.md R1, R3, R7):
- `ai.koog.agents.core.tools.reflect.ToolSet`
- `ai.koog.agents.core.tools.annotations.Tool` and `LLMDescription`
- `ai.koog.serialization.JSONObject`/`JSONPrimitive`
- `ai.koog.serialization.kotlinx.KotlinxSerializer`

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies on incomplete tasks)
- **[Story]**: User story the task belongs to (US1–US4)

---

## Phase 1: Setup

No setup. Koog 1.3.0, kotlinx.serialization, Hilt, JUnit 4, and `kotlinx-coroutines-test` are
already installed (plan.md, "Nothing is added").

---

## Phase 2: Foundational (blocks all stories)

**Purpose**: Entities, the domain contract, and the empty ToolSet shell with mock data that every
story extends.

- [x] T001 [P] Create `SRC/feature/interacbanking/domain/entities/InteracBanking.kt` with every type `@Serializable`:
  - `enum AccountType { CHEQUING, SAVINGS, CREDIT, LINE_OF_CREDIT }` and
    `enum DeliveryChannel { EMAIL, PHONE }`.
  - `Account(accountId: String, name: String, type: AccountType, accountNumberMask: String,
    availableBalance: Double, currency: String = "CAD")`.
  - `InteracContact(contactId: String, name: String, email: String?, phoneNumber: String?,
    autodepositEnabled: Boolean)`, plus a computed getter `hasMultipleChannels`
    ("`email != null && phoneNumber != null`; not serialized").
  - `TransferStatus { SENT, PENDING_SECURITY_ANSWER }` and
    `TransferResult(referenceId, status, amount, recipient, deliveryChannel, destination,
    fromAccount, timestamp)`. It has "no security answer field (FR-012)".
  - `MoneyRequestStatus { REQUEST_SENT }` and `MoneyRequestResult(referenceId, status, amount,
    requestee, deliveryChannel, destination, depositAccount, timestamp)`.
  - No Koog import.
- [x] T002 [P] Create `SRC/feature/interacbanking/domain/agent/tools/InteracBankingTools.kt`. It is an interface with
  four declarations and no default bodies:
  - `getAccountBalances(): List<Account>`
  - `findContacts(query: String? = null): List<InteracContact>`
  - `executeSendTransfer(fromAccountId: String, recipientId: String, amount: Double,
    deliveryChannel: DeliveryChannel, securityQuestion: String? = null,
    securityAnswer: String? = null): TransferResult`
  - `executeRequestMoney(fromContactId: String, depositAccountId: String, amount: Double,
    deliveryChannel: DeliveryChannel, memo: String? = null): MoneyRequestResult`

  No Koog import.
- [x] T003 Create `SRC/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt` (depends on T001, T002):
  - Declare `@Singleton class MockInteracBankingTools @Inject constructor() :
    InteracBankingTools, ToolSet`.
  - Put the class-level `@LLMDescription("Interac e-Transfer tools for the signed-in user's mock
    CAD accounts and saved contacts.")` on it.
  - Add private mock data:
    - Accounts (FR-001): `acc_chk_101` Everyday Chequing, CHEQUING, `**** 4821`, 1540.25; and
      `acc_sav_202` High-Interest Savings, SAVINGS, `**** 8830`, 6200.00.
    - Contacts (FR-002): `ct_alice` Alice Martin, alice.m@example.com, no phone, Autodeposit on;
      `ct_bob` Bob Vance, no email, +1-416-555-0143, Autodeposit off; `ct_charlie` Charlie Chen,
      charlie.c@example.ca, +1-647-555-0199, Autodeposit off.
  - Keep `private val balances: MutableMap<String, Double>` seeded from the accounts.
  - Add private helpers:
    - `requirePositive(amount)` → "Amount must be greater than 0."
    - `requireAccount(id)` → "Account <id> not found."
    - `requireContact(id)` → "Contact <id> not found."
    - `destinationFor(contact, channel)` → "<name> has no <email|phone number> for
      <EMAIL|PHONE> delivery."
    - `newReference(prefix)` → prefix + 8 characters from `A-Z0-9` via `Random.Default`
    - `now()` → `Instant.now().toString()`

  Do not add a Hilt module or binding (plan.md).

**Checkpoint**: The project compiles with `./gradlew :app:assembleDebug`.

---

## Phase 3: User Story 1 – Send money to a contact (P1) 🎯 MVP

**Goal**: `executeSendTransfer` validates, debits in memory, and returns a `TransferResult`.

**Independent test**: quickstart scenarios 1–9 and 12 pass on a fresh `MockInteracBankingTools()`.

- [x] T004 [US1] Create `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt` (JUnit 4, a fresh
  instance per test) covering quickstart scenarios:
  1. Alice, EMAIL, no Q&A → `SENT`, `alice.m@example.com`, `TRF-[A-Z0-9]{8}`, and
     `Instant.parse(timestamp)` succeeds.
  2. Bob, PHONE, with Q&A → `PENDING_SECURITY_ANSWER`, `+1-416-555-0143`.
  3. Bob with missing or blank Q&A → exactly "Recipient does not have Autodeposit enabled. A
     security question and answer are required.", and the balance is unchanged.
  4. $2,000 from chequing → insufficient-balance error.
  5. $1,500 then another $1,500 from chequing → the balance reads 40.25 after the first send, and
     the second send is rejected.
  6. A new instance has balances 1540.25 and 6200.00.
  7. Alice via PHONE (send) → channel-mismatch error.
  8. Amount 0 or negative (send) → amount error.
  9. Unknown account or contact ID (send) → a not-found error that names the ID.
  12. Sending exactly the full balance succeeds and leaves 0.0.

  Also cover the edge case that Q&A sent to Alice is ignored and the status is `SENT`. Use
  `assertThrows(IllegalArgumentException::class.java)` and check the message. The tests must
  fail first.
- [x] T005 [US1] Implement `executeSendTransfer` in `SRC/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt`
  as an `@Tool @Synchronized override fun`.
  - Check order per data-model.md:
    1. `amount > 0`
    2. The account exists.
    3. `amount <=` the current balance → "Insufficient balance in <name>: available <bal>,
       requested <amount>."
    4. The contact exists.
    5. The channel has a destination.
    6. If Autodeposit is off, `securityQuestion` and `securityAnswer` must both be non-blank
       (`isNullOrBlank`) → the exact FR-007 message.
  - Debit with `BigDecimal(balance.toString()) - BigDecimal(amount.toString())`, then
    `.toDouble()` (research.md R4).
  - Status is `SENT` when Autodeposit is on and `PENDING_SECURITY_ANSWER` otherwise.
  - Never place the answer in the result.
- [x] T006 [US1] Add `@LLMDescription` to `executeSendTransfer` and to each of its parameters in
  `SRC/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt` (FR-016):
  - `recipientId` is a contactId from `findContacts`.
  - `deliveryChannel` must exist on the contact.
  - `securityQuestion` and `securityAnswer` say: "Required when the recipient's
    autodepositEnabled is false; pass null when it is true." Koog 1.3.0 marks every reflective
    parameter required (research.md R3, contract).

**Checkpoint**: `./gradlew :app:testDebugUnitTest --tests '*MockInteracBankingToolsTest'` is
green for US1.

---

## Phase 4: User Story 2 – Delivery channel and security details in the form (P1)

**Goal**: The agent instructions encode FR-014 and FR-015. Per the spec, the A2UI host is out of
scope, so this story delivers instruction text only.

**Independent test**: The text contains all four contract rules; this is checked by inspection
(quickstart, "Not covered here").

- [x] T007 [P] [US2] Create `SRC/feature/interacbanking/domain/agent/workflow/InteracAgentInstructions.kt` with
  `const val INTERAC_AGENT_INSTRUCTIONS`. The text holds the four rules from
  contracts/interac-tools.md, "Agent instructions":
  1. Resolve IDs only through `getAccountBalances` and `findContacts`; never invent them.
  2. If a contact has both email and phone, show an Email/Phone choice with nothing preselected
     and never guess. With one channel, select it automatically.
  3. If Autodeposit is off, the form has "Security Question" and "Security Answer" inputs, and
     both are collected before `executeSendTransfer`. If it is on, omit them and show an
     "Autodeposit Active" badge.
  4. On a tool failure, relay the reason and do not retry with guessed values.

  No Koog import.

**Checkpoint**: Instruction text reviewed against FR-014 and FR-015.

---

## Phase 5: User Story 3 – Check balances and find contacts (P2)

**Goal**: The `getAccountBalances` and `findContacts` tools.

**Independent test**: quickstart scenario 10 and the US3 balance listing.

- [x] T008 [US3] Add tests to `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt`:
  - `getAccountBalances()` returns both accounts with name, type, mask, balance, and currency
    `"CAD"`.
  - `findContacts("char")` → Charlie, `("EXAMPLE.CA")` → Charlie, `("416-555")` → Bob,
    `(null)` and `("")` → all 3, `("zzz")` → empty.
- [x] T009 [US3] Implement both tools in `SRC/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt`.
  - `getAccountBalances` is `@Tool @Synchronized override fun`. It maps the mock accounts with
    `availableBalance = balances.getValue(id)`. Its `@LLMDescription` covers resolving phrases
    such as "from my chequing" and checking that an amount fits.
  - `findContacts` is `@Tool override fun`. A blank or null query returns all contacts.
    Otherwise it does a case-insensitive `contains` on name, email, or phone. The parameter's
    `@LLMDescription` says "pass null for all contacts".

**Checkpoint**: The US3 tests are green.

---

## Phase 6: User Story 4 – Request money from a contact (P3)

**Goal**: `executeRequestMoney`.

**Independent test**: quickstart scenario 11 and the request cases of scenarios 7–9.

- [x] T010 [US4] Add tests to `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt`:
  - $30 from Alice into `acc_sav_202` via EMAIL → `REQUEST_SENT`, `REQ-[A-Z0-9]{8}`,
    `alice.m@example.com`, deposit account "High-Interest Savings", balances unchanged.
  - Request from Alice via PHONE → channel-mismatch error.
  - Amount ≤ 0 → amount error.
  - Unknown deposit account or contact → a not-found error that names the ID.
- [x] T011 [US4] Implement `executeRequestMoney` as `@Tool override fun` in
  `SRC/feature/interacbanking/data/ai/tools/MockInteracBankingTools.kt`.
  - Check order: `amount > 0` → the deposit account exists → the contact exists → the channel
    has a destination.
  - No balance check or change. `memo` is accepted but not echoed.
  - Add `@LLMDescription` to the tool and its parameters; `memo` says "optional; pass null if
    none".

**Checkpoint**: All story tests are green.

---

## Phase 7: Polish & Cross-Cutting

- [x] T012 Add quickstart scenario 13 to `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt`:
  - `asTools().map { it.name }.toSet()` equals the 4 method names.
  - Call `getTool("executeSendTransfer")`, then
    `decodeArgs(JSONObject(mapOf("fromAccountId" to JSONPrimitive("acc_chk_101"),
    "recipientId" to JSONPrimitive("ct_alice"), "amount" to JSONPrimitive(50.0),
    "deliveryChannel" to JSONPrimitive("EMAIL"))), KotlinxSerializer())`.
  - Then `execute(args)` inside `runTest`. The result is a `TransferResult` with status `SENT`
    (the defaults applied).
- [x] T013 Run `./gradlew :app:testDebugUnitTest :app:assembleDebug :app:detekt :app:lintDebug`
  and fix findings in the files above. Skip device tests (plan.md, Principle IV) and say so in
  the completion report.
- [x] T014 Inspect `git diff` for scope: only the five files above plus `tasks.md` checkboxes.
  Confirm that the `domain/` files import no `ai.koog`.

---

## Phase 8: Analyze Follow-ups

**Purpose**: Close the coverage gaps found by `/speckit-analyze` (G1, G3).

- [x] T015 Add a concurrency test to `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt` (FR-012a):
  - Start 10 threads that each send $200 from `acc_chk_101` to Alice. Use a `CountDownLatch` so
    they start together, and catch `IllegalArgumentException`.
  - Assert exactly 7 sends succeed and the final balance is 140.25, never below 0.
- [x] T016 In the Bob `PENDING_SECURITY_ANSWER` test in
  `TEST/feature/interacbanking/data/ai/tools/MockInteracBankingToolsTest.kt`, assert the chequing balance reads 1520.25
  (Edge Cases: a pending send debits immediately).
- [x] T017 Run `./gradlew :app:testDebugUnitTest --tests '*MockInteracBankingToolsTest'`.

**Checkpoint**: The test file is green and covers FR-012a and the pending-debit edge case.

---

## Dependencies & Execution Order

- Phase 2: T001 ∥ T002, then T003.
- US1 (T004–T006) depends on Phase 2. It is the MVP.
- US2 (T007) depends only on the contract text and can start any time.
- US3 (T008–T009) and US4 (T010–T011) depend on Phase 2. They are independent of US1 in
  behavior, but they edit the same two files, so they run sequentially after US1.
- Polish (T012–T014) comes after all stories.
- Analyze follow-ups (T015–T017) come after Polish. T015 and T016 edit the same test file, so they
  run sequentially.

## Parallel Opportunities

```text
T001 [P] entities          ∥  T002 [P] interface       ∥  T007 [P] [US2] instructions
```

Every other task edits `MockInteracBankingTools.kt` or `MockInteracBankingToolsTest.kt`, so they
run sequentially.

## Implementation Strategy

1. MVP: Phase 2, then US1 (T001–T006). Sending works and is tested.
2. Add US2 (instructions), then US3 (lookups), then US4 (request).
3. Finish with Polish: the Koog `asTools()` round-trip, full checks, and the diff review.
