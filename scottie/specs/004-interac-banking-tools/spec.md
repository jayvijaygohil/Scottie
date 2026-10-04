# Feature Specification: Mock Interac Banking Tools

**Feature Branch**: `004-interac-banking-tools`

**Created**: 2026-10-04

**Status**: Draft

**Input**: User description: "Mock Interac Banking ToolSet for Koog. Supply mock banking data
(two accounts, three contacts), enforce Interac business logic (Autodeposit gating and delivery
channel selection), and handle send-money and request-money transactions for an Interac e-Transfer
proof of concept whose forms are rendered with A2UI. Tools: balance lookup, contact lookup, send
transfer, request money. Fail fast with explicit errors on missing fields, insufficient balance, or
mismatched delivery channels. Agent instructions: never guess the delivery channel when a contact
has both email and phone; show security question/answer inputs only when the recipient lacks
Autodeposit, otherwise show an 'Autodeposit Active' badge."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Send money to a contact (Priority: P1)

A user asks the assistant to send money ("send $50 to Alice from my chequing"). The assistant
resolves the source account and recipient, presents a transfer form, and on submission returns a
confirmation with a reference number.

**Why this priority**: Sending money is the core Interac e-Transfer action; the POC has no value
without it.

**Independent Test**: Using only the mock data, send a valid amount to each of the three contacts
and confirm each produces a confirmation with the correct status, channel, and destination.

**Acceptance Scenarios**:

1. **Given** Alice (Autodeposit on, email only), **When** the user sends $50 from Everyday
   Chequing, **Then** the confirmation shows status Sent, channel Email, destination
   alice.m@example.com, and a reference starting with `TRF-`.
2. **Given** Bob (Autodeposit off, phone only), **When** the user sends $20 with a security
   question and answer, **Then** the confirmation shows status Pending Security Answer, channel
   Phone, destination +1-416-555-0143.
3. **Given** Bob, **When** the user submits a transfer without a security question or answer,
   **Then** the transfer is rejected with the message "Recipient does not have Autodeposit
   enabled. A security question and answer are required."
4. **Given** Everyday Chequing holds $1,540.25, **When** the user sends $2,000 from it, **Then**
   the transfer is rejected for insufficient balance.
5. **Given** a fresh app start, **When** the user sends $1,500 from Everyday Chequing to Alice,
   **Then** the balance lookup shows $40.25 for Everyday Chequing; **When** the user then sends
   another $1,500 from it, **Then** that transfer is rejected for insufficient balance.
6. **Given** balances were reduced by earlier sends, **When** the app restarts, **Then** balances
   return to $1,540.25 and $6,200.00.

---

### User Story 2 - Choose delivery channel and security details in the form (Priority: P1)

The transfer form adapts to the recipient: it asks the user to pick Email or Phone only when the
recipient has both, and it asks for a security question and answer only when the recipient lacks
Autodeposit.

**Why this priority**: Without these rules the assistant either guesses a channel (sending money
to the wrong destination) or submits transfers that will be rejected.

**Independent Test**: Start a transfer to each contact and inspect which inputs the assistant's
form presents. Deferred until an agent host exists; this feature checks only the instruction text,
by inspection.

**Acceptance Scenarios**:

1. **Given** Charlie (email and phone, Autodeposit off), **When** a transfer form is presented,
   **Then** it includes an Email/Phone choice with no preselected guess, plus Security Question
   and Security Answer inputs.
2. **Given** Alice (email only, Autodeposit on), **When** a transfer form is presented, **Then**
   Email is selected automatically, no security inputs appear, and an "Autodeposit Active" badge is
   shown.
3. **Given** Bob (phone only, Autodeposit off), **When** a transfer form is presented, **Then**
   Phone is selected automatically and security inputs appear.

---

### User Story 3 - Check balances and find contacts (Priority: P2)

The user asks "what's my balance?" or "who can I send to?" and the assistant answers from the mock
accounts and contacts. The assistant also uses these lookups to resolve phrases like "from my
savings" and "to Charlie".

**Why this priority**: Required to resolve transfers, and useful on its own, but delivers less
value than moving money.

**Independent Test**: Ask for balances and search contacts by partial name, email, and phone.

**Acceptance Scenarios**:

1. **Given** the mock data, **When** the user asks for balances, **Then** both accounts are listed
   with name, type, masked number, available balance, and currency CAD.
2. **Given** the mock data, **When** the user searches "char", "EXAMPLE.CA", or "416-555", **Then**
   Charlie, Charlie, and Bob are returned respectively.
3. **Given** the mock data, **When** the contact search is empty, **Then** all three contacts are
   returned.

---

### User Story 4 - Request money from a contact (Priority: P3)

The user asks a contact to send them money, choosing which account receives it. The assistant
returns a confirmation with a reference number.

**Why this priority**: Completes the Interac POC but is secondary to sending.

**Independent Test**: Request $30 from Alice into High-Interest Savings and check the confirmation.

**Acceptance Scenarios**:

1. **Given** Alice (email only), **When** the user requests $30 into High-Interest Savings via
   Email, **Then** the confirmation shows status Request Sent, destination alice.m@example.com,
   deposit account High-Interest Savings, and a reference starting with `REQ-`.
2. **Given** Alice (no phone), **When** the user requests money via Phone, **Then** the request is
   rejected for a mismatched delivery channel.

---

### Edge Cases

- Amount is zero or negative → rejected for both sending and requesting.
- Unknown account or contact identifier → rejected, naming which identifier was not found.
- Delivery channel not available for the contact → rejected for mismatched delivery channel.
- Security question or answer supplied as whitespace only → treated as missing.
- Security question and answer supplied for an Autodeposit recipient → ignored; status is Sent.
- Amount exactly equal to the available balance → allowed.
- Contact search with no match → empty result, not an error.
- Requesting money needs no balance check and does not change any balance (the request is not
  fulfilled in the POC).
- A rejected send leaves the balance unchanged.
- A send pending a security answer reduces the balance immediately, as a real Interac send does.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: System MUST provide two fixed accounts: Everyday Chequing (`acc_chk_101`, chequing,
  `**** 4821`, $1,540.25 CAD) and High-Interest Savings (`acc_sav_202`, savings, `**** 8830`,
  $6,200.00 CAD).
- **FR-002**: System MUST provide three fixed contacts: Alice Martin (alice.m@example.com, no
  phone, Autodeposit on), Bob Vance (no email, +1-416-555-0143, Autodeposit off), and Charlie Chen
  (charlie.c@example.ca, +1-647-555-0199, Autodeposit off).
- **FR-003**: Account types MUST be one of chequing, savings, credit, or line of credit, so the
  assistant can resolve phrases like "from my chequing".
- **FR-004**: Balance lookup MUST return every account with its name, type, masked number,
  available balance, and currency.
- **FR-005**: Contact lookup MUST match a case-insensitive substring of name, email, or phone
  number, and MUST return all contacts when the query is empty or absent.
- **FR-006**: Sending MUST reject a non-positive amount, an unknown source account, an amount
  above the source account's available balance, an unknown recipient, or a delivery channel the
  recipient lacks.
- **FR-007**: Sending to a recipient without Autodeposit MUST require a non-blank security
  question and answer, rejecting with exactly "Recipient does not have Autodeposit enabled. A
  security question and answer are required." when either is missing; the result status is
  Pending Security Answer.
- **FR-008**: Sending to a recipient with Autodeposit MUST ignore any security question and answer;
  the result status is Sent.
- **FR-009**: A successful send MUST return a reference `TRF-` followed by 8 uppercase
  alphanumeric characters, the status, amount, recipient name, delivery channel, the actual email
  or phone used, the source account, and a UTC ISO-8601 timestamp.
- **FR-010**: Requesting money MUST reject a non-positive amount, an unknown deposit account, an
  unknown contact, or a delivery channel the contact lacks.
- **FR-011**: A successful request MUST return a reference `REQ-` followed by 8 uppercase
  alphanumeric characters, status Request Sent, amount, contact name, delivery channel, destination,
  deposit account, and a UTC ISO-8601 timestamp.
- **FR-012**: Results MUST NOT contain the security answer.
- **FR-012a**: A successful send (Sent or Pending Security Answer) MUST reduce the source
  account's available balance by the amount, and later balance lookups and balance checks MUST use
  the reduced balance. Balances MUST be held in memory only and reset to the FR-001 values when the
  app restarts. Concurrent sends from the same account MUST NOT overdraw it.
- **FR-013**: Every rejection MUST carry an explicit message stating the reason so the assistant
  can relay it to the user.
- **FR-014**: The assistant's instructions MUST state that when a contact has both email and phone
  it presents an Email/Phone choice and never guesses; with one channel it selects that channel
  automatically.
- **FR-015**: The assistant's instructions MUST state that for a recipient without Autodeposit the
  transfer form presents Security Question and Security Answer inputs before submission; for a
  recipient with Autodeposit it omits them and shows an "Autodeposit Active" badge.
- **FR-016**: Each tool and its inputs MUST carry descriptions the assistant can read to decide
  when and how to call it.

### Key Entities

- **Account**: A user's bank account — identifier, display name, type, masked number, available
  balance, currency (CAD).
- **Interac Contact**: A saved recipient — identifier, name, optional email, optional phone,
  Autodeposit flag. Has multiple channels when both email and phone exist.
- **Delivery Channel**: Email or Phone.
- **Transfer Result**: Confirmation of a send — reference, status (Sent or Pending Security
  Answer), amount, recipient, channel, destination, source account, timestamp.
- **Money Request Result**: Confirmation of a request — reference, status (Request Sent), amount,
  contact, channel, destination, deposit account, timestamp.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: All acceptance scenarios above, except User Story 2's (deferred), pass against the fixed mock data; the same sequence
  of actions after a fresh start produces identical results, except reference numbers and
  timestamps.
- **SC-002**: 100% of invalid sends and requests listed in Edge Cases are rejected with a message
  naming the reason; none produce a confirmation.
- **SC-003**: For Charlie, the assistant never submits a transfer without the user having chosen a
  channel and supplied a security question and answer. Deferred until an agent host exists.
- **SC-004**: A user can complete a send to any of the three contacts in a single form submission
  once the form is presented. Deferred until an agent host exists.

## Assumptions

- Mock data only; no real bank, Interac network, or persistence. Sends reduce balances in memory
  for the current run; every app restart starts from the initial balances.
- Pending Security Answer reflects the real Interac flow: the recipient must answer before funds
  deposit. No follow-up for the recipient's answer is simulated.
- This feature delivers the tools and the assistant's instructions only. Building the screen that
  hosts the assistant and the A2UI rendering surface is out of scope; the A2UI rules are expressed
  as instructions to the assistant.
- Security question/answer content rules beyond "not blank" (length, character limits) are out of
  scope for the POC.
- No transfer limits, fees, memos on sends, or currency conversion; all amounts are CAD.
- The request-money memo is optional and is not echoed in the result.
- The credit and line-of-credit account types exist for natural-language resolution even though no
  mock account uses them.
