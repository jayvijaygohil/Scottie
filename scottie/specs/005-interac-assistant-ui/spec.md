# Feature Specification: Conversational Interac e-Transfer Assistant with AI-Generated UI

**Feature Branch**: `005-interac-assistant-ui`

**Created**: 2026-10-06

**Status**: Draft

**Input**: User description: "Conversational Interac e-Transfer assistant with AI-generated UI
(proof of concept). The user types a natural-language request such as 'send $50 to Alice'. An
on-device language model and agent answer with an interactive card or form rendered from a
generated UI description, and the user completes the task in that UI instead of continuing a
back-and-forth chat. Capabilities: check balances, send an Interac e-Transfer, request money.
Mock banking data is extended with two more accounts (Joint Chequing, Rewards Visa credit card)
and three more contacts (Jane Doe, Alicia Moreno, Robert Singh), fuzzy ranked contact search,
manual recipients, saving contacts, memo on requests, and credit-card rejection. All AI runs on
the device; no banking data leaves the phone."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Send an Interac e-Transfer from a single prefilled form (Priority: P1)

The user types a request such as "Send $50 to Alice" or "Send money". The assistant replies with
one transfer form. Whatever the user already said (recipient, amount, source account) is filled
in; everything else is empty. The form adapts to the recipient: it fixes the delivery channel when
the recipient has only one, asks the user to choose Email or SMS when they have both, and shows
security question/answer fields only when the recipient lacks Autodeposit. One tap on Submit
completes the transfer and shows a confirmation; balances change immediately.

**Why this priority**: Sending money is the core demonstration of model + agent + generated UI
working together. Without it the POC shows nothing new.

**Independent Test**: With the model downloaded and the network off, type each of the send
prompts in the examples list, complete the form, and confirm the correct confirmation and
balance change. Delivers a working end-to-end send with no further chat turns.

**Acceptance Scenarios**:

1. **Given** Alice Martin (email only, Autodeposit on), **When** the user types "Send $50 to
   Alice", **Then** the form shows Alice preselected, amount 50.00, Email fixed and read-only, an
   "Autodeposit Active" badge, and no security fields; **When** the user submits, **Then** the
   confirmation shows status Sent, destination alice.m@example.com, and a reference starting
   `TRF-`.
2. **Given** Bob Vance (phone only, Autodeposit off), **When** the user types "Send $20 to Bob",
   **Then** the form shows Bob preselected, SMS fixed and read-only, and required Security
   Question and Security Answer fields with the answer masked; **When** both are filled and the
   user submits, **Then** the confirmation shows status Pending security answer and destination
   +1-416-555-0143.
3. **Given** Charlie Chen (email and phone, Autodeposit off), **When** the user types "Send money
   to Charlie", **Then** the form shows Charlie preselected, an Email/SMS choice with nothing
   preselected, empty amount, and security fields; **And** Submit stays disabled until a channel
   is chosen, a valid amount is entered, and both security fields contain non-whitespace text.
4. **Given** Jane Doe (email and phone, Autodeposit on), **When** the user types "Send $40 to
   Jane", **Then** the form requires an Email/SMS choice and shows no security fields.
5. **Given** Everyday Chequing holds $1,540.25, **When** the user types "Send $2,000 from Everyday
   Chequing", **Then** the assistant shows the insufficient-balance message exactly as the banking
   service states it, the Everyday Chequing balance card, and suggests High-Interest Savings as an
   account that can cover $2,000.
6. **Given** the initial balances, **When** the user types "Send $100 to Alice" without naming an
   account, **Then** the source-account choice offers only Everyday Chequing then High-Interest
   Savings, in that order; Joint Chequing ($85.40) and Rewards Visa are not offered.
7. **Given** a fresh app start, **When** the user sends $1,500 to Alice from Everyday Chequing,
   **Then** a balance check shows Everyday Chequing at $40.25; **When** the user tries a second
   $1,500 send from Everyday Chequing, **Then** it is rejected for insufficient balance; **When**
   the app is restarted, **Then** balances are back to their initial values.
8. **Given** the user types "Send 40 to Ali", **Then** the recipient choice shows Alice Martin and
   Alicia Moreno, nothing is preselected, and the user picks one.
9. **Given** the user types "Send $10 to sam@example.com" and no contact matches, **Then** the form
   enters manual-recipient mode with the email prefilled, a phone field empty, security fields
   required, and an option to save the recipient as a contact.
10. **Given** a manual recipient with both an email and a phone entered, **Then** the user must
    choose Email or SMS before Submit enables.
11. **Given** a form has been shown for any send, **When** every required field is valid, **Then**
    a single Submit completes the transfer; no further chat message is needed.
12. **Given** "Send 40 to Charly" (typo), **Then** Charlie Chen is offered as the closest match.
13. **Given** "e-Transfer 75 to 416-555-0143", **Then** Bob Vance is matched by phone digits and
    preselected with amount 75.00.
14. **Given** "Send $20 to bob from my savings", **Then** High-Interest Savings is preselected as
    the source account and the user can change it.

---

### User Story 2 - Check account balances (Priority: P2)

The user asks about balances in natural language. The assistant shows balance cards for the
matching accounts: one card when the description is specific, several when it matches several,
all four when the question is general or the named account does not exist (with a not-found
message in that case).

**Why this priority**: Balance cards are the simplest generated UI and are reused inside the send
flow (insufficient funds). Independently valuable but lower stakes than moving money.

**Independent Test**: Type each balance prompt from the examples and check which cards appear and
what each card shows.

**Acceptance Scenarios**:

1. **Given** the mock accounts, **When** the user types "What's my balance?", **Then** four cards
   appear: Everyday Chequing, High-Interest Savings, Joint Chequing, and Rewards Visa, each with
   account name, type, masked number, available balance (available credit for the Visa), and
   currency CAD.
2. **Given** the mock accounts, **When** the user types "How much is in my savings?", **Then** only
   the High-Interest Savings card appears.
3. **Given** the mock accounts, **When** the user types "my chequing", **Then** Everyday Chequing
   and Joint Chequing cards appear.
4. **Given** the mock accounts, **When** the user types "account ending 4821" or "my visa", **Then**
   only the matching card appears.
5. **Given** the mock accounts, **When** the user types "What's in my TFSA?", **Then** the assistant
   says no TFSA account was found and shows all four cards.

---

### User Story 3 - Request money via Interac (Priority: P3)

The user asks a contact for money ("Request $30 from Jane for dinner", "Ask Alicia for 25
bucks"). The assistant shows a request form like the send form, except the user picks a deposit
account, there is no balance check and no security fields, and there is an optional memo. One
Submit sends the request and shows a confirmation; balances do not change.

**Why this priority**: Completes the three capabilities but reuses the send form's mechanics.

**Independent Test**: Type each request prompt, submit, and confirm the confirmation content and
that balances are unchanged.

**Acceptance Scenarios**:

1. **Given** Alice Martin, **When** the user types "Request $30 from Alice into savings for
   dinner", **Then** the form shows Alice preselected, amount 30.00, Email fixed, High-Interest
   Savings preselected as deposit account, and memo "dinner"; **When** submitted, **Then** the
   confirmation shows status Request sent, a `REQ-` reference, requestee Alice Martin, Email and
   alice.m@example.com, deposit account High-Interest Savings, memo "dinner", and a time; **And**
   no balance changes.
2. **Given** the user explicitly asks to request from Alice by text message, **Then** the user sees
   exactly "Alice Martin has no phone number for PHONE delivery." together with a request form in
   which Email (Alice's only channel) is selected and locked; no request is created.
3. **Given** "Ask Alicia for 25 bucks", **Then** Alicia Moreno is preselected with amount 25.00,
   Email fixed, no security fields, and an empty memo.
4. **Given** a request form, **Then** the deposit-account choice lists chequing accounts first,
   then savings, and never Rewards Visa.

---

### User Story 4 - Errors, off-topic requests, and fallbacks (Priority: P3)

When the banking service rejects an action, the user sees its message verbatim and the assistant
does not retry with guessed values. When the request is outside the three capabilities, the
assistant politely says what it can help with. When the assistant cannot produce a usable form,
the user sees a clear fallback message rather than a blank or broken area.

**Why this priority**: Protects the demo from dead ends but adds no new capability.

**Independent Test**: Trigger a rejection, an off-topic request, and a malformed UI response, and
observe the screen.

**Acceptance Scenarios**:

1. **Given** any rejected send or request, **Then** the exact rejection message is shown and no
   second attempt is made automatically.
2. **Given** the user types "What's the weather?", **Then** the assistant replies that it can help
   with balances, sending an e-Transfer, and requesting money.
3. **Given** the assistant's UI description is invalid or incomplete, **Then** the user sees a
   fallback message explaining the assistant could not build the form and inviting them to retry;
   no empty or partially rendered card is left on screen.

---

### Edge Cases

- Amount with more than two decimals, zero, negative, or non-numeric → Submit disabled with an
  inline message; never sent to the banking service.
- Amount exactly equal to the source balance → allowed.
- Amount given but no account can cover it → assistant says so and shows all eligible accounts'
  balance cards; no source account is offered.
- No amount given → all eligible accounts offered (chequing first, then savings; never credit).
- Security question or answer containing only whitespace → treated as empty; Submit disabled.
- Recipient changed in the form from an Autodeposit contact to a non-Autodeposit one (or to a
  manual recipient) → security fields appear; the reverse hides them. Channel choice resets when
  the recipient changes.
- Robert Singh vs Bob Vance: "Bob" clearly matches Bob Vance (exact first name) and preselects him;
  "Rob" matches Robert Singh; a query matching both at similar strength shows both.
- Contact search with nothing reasonably close → empty result → manual-recipient mode.
- Manual recipient with neither email nor phone → Submit disabled.
- Saving a manual contact → the new contact has no Autodeposit and appears in later searches for
  the rest of the run; it is gone after restart.
- Credit card chosen as source or deposit account through any path → rejected by the banking
  service with a user-readable message, shown verbatim.
- Rejected send → balances unchanged. Pending-security-answer send → balance debited immediately.
- Model not yet downloaded → the assistant screen tells the user to download a model first and
  does not attempt inference.
- Submission while a previous submission is still in progress → ignored (Submit disabled until the
  result or rejection arrives).

## Requirements *(mandatory)*

### Functional Requirements

#### Mock banking data and behaviour

- **FR-001**: The banking service MUST provide four accounts: Everyday Chequing (chequing,
  ending 4821, $1,540.25), High-Interest Savings (savings, ending 8830, $6,200.00), Joint
  Chequing (chequing, ending 1177, $85.40), and Rewards Visa (credit, ending 3092, $2,500.00
  available credit). All amounts are CAD.
- **FR-002**: The banking service MUST provide six contacts: Alice Martin (alice.m@example.com,
  no phone, Autodeposit on), Bob Vance (no email, +1-416-555-0143, Autodeposit off), Charlie Chen
  (charlie.c@example.ca, +1-647-555-0199, Autodeposit off), Jane Doe (jane.doe@example.com,
  +1-905-555-0122, Autodeposit on), Alicia Moreno (alicia.moreno@example.com, no phone,
  Autodeposit off), and Robert Singh (no email, +1-289-555-0177, Autodeposit on).
- **FR-003**: Contact search MUST return matches ranked by relevance, tolerate small typos
  ("Charly" → Charlie), match first names, partial emails, and phone digits regardless of
  formatting ("4165550143" → Bob), and return an empty result when nothing is reasonably close.
  An empty query returns all contacts.
- **FR-004**: The banking service MUST allow saving a new contact with a name plus an email, a
  phone, or both. Saved contacts have Autodeposit off and persist only for the current run.
- **FR-005**: Sending and requesting MUST accept a manually entered recipient (email, phone, or
  both) that is not a saved contact. A manual recipient is treated as not having Autodeposit.
- **FR-006**: Sending MUST reject a credit account as the source; requesting MUST reject a credit
  account as the deposit account. Each rejection carries a clear, user-readable message.
- **FR-007**: Sending MUST reject a non-positive amount, an amount above the source balance, an
  unknown account or contact, or a channel the recipient lacks, each with a reason message.
  Sending to a recipient without Autodeposit (saved or manual) MUST require a non-blank security
  question and answer and results in status Pending security answer; with Autodeposit the status
  is Sent and any security fields are ignored.
- **FR-008**: A successful send MUST debit the source account immediately (including pending
  sends) and return reference `TRF-` + 8 uppercase alphanumerics, status, amount, recipient,
  channel, destination, source account, and time. Balances live in memory only and reset on
  restart.
- **FR-009**: A money request MUST keep its optional memo and return reference `REQ-` + 8
  uppercase alphanumerics, status Request sent, amount, requestee, channel, destination, deposit
  account, memo, and time. Requests never change balances and perform no balance check.
- **FR-010**: Results MUST never contain the security answer.

#### Assistant behaviour

- **FR-011**: The assistant MUST classify a typed request as balance check, send, request, or
  off-topic, and extract any recipient (name, email, or phone), amount, source/deposit account,
  and memo the user supplied. Extracted values MUST come only from the user's text and the
  banking service; the assistant MUST NOT invent accounts, contacts, or amounts.
- **FR-012**: For a balance check the assistant MUST show one card per matching account; all
  accounts when the question is general; and a not-found message plus all accounts when the
  named account does not exist. Each card shows name, type, masked number, available balance,
  and currency.
- **FR-013**: For a send the assistant MUST show exactly one transfer form with supplied values
  prefilled and missing values empty. The user MUST be able to edit every prefilled value.
- **FR-014**: The recipient field MUST offer autocomplete suggestions that update as the user
  types, sourced from the banking service's ranked search, without waiting on the language model.
- **FR-015**: Recipient resolution: none mentioned → all saved contacts offered; mentioned → the
  closest matches offered, with exactly one clear match preselected but changeable; no match →
  manual-recipient mode with the typed email or phone prefilled and an option to save as a
  contact.
- **FR-016**: Source-account resolution for sends: named by the user → preselected; otherwise only
  accounts whose balance covers the amount are offered, chequing before savings, never credit;
  no amount yet → all non-credit accounts in that order; no account can cover the amount → the
  assistant says so and shows the balance cards. If the user names an account the amount exceeds,
  the assistant shows the rejection message, that account's balance card, and suggests other
  eligible accounts that can cover it.
- **FR-017**: Delivery channel: a recipient with one channel has it selected and shown read-only;
  a recipient with both (saved or manual) requires the user to choose Email or SMS with nothing
  preselected. The assistant MUST never choose the channel in that case.
- **FR-018**: Security fields appear only when the recipient lacks Autodeposit or is manual. The
  answer is masked. An "Autodeposit Active" badge replaces them for Autodeposit recipients.
- **FR-019**: Submit MUST stay disabled until all required fields are valid: amount > 0 with at
  most two decimals, recipient resolved or manual recipient with at least one destination, channel
  chosen, account chosen, and (when shown) both security fields non-blank after trimming.
- **FR-020**: One Submit completes the transfer or request and replaces the form with a
  confirmation containing the fields in FR-008 or FR-009. Balance cards shown afterwards reflect
  the new balances.
- **FR-021**: The request form mirrors the send form with a deposit account (same ordering, never
  credit), no balance check, no security fields, and an optional memo.
- **FR-022**: When the banking service rejects an action, the assistant MUST show its message
  verbatim and MUST NOT retry with guessed values.
- **FR-023**: For a request outside the three capabilities, the assistant MUST reply politely with
  what it can help with and show no form.
- **FR-024**: If the assistant's UI description cannot be rendered, the user MUST see a clear
  fallback message; the screen MUST never show an empty or broken card.
- **FR-025**: The security answer MUST be sent from the form directly to the banking service. It
  MUST never be shown to, stored by, or passed through the language model, and MUST not appear
  in logs or confirmations.
- **FR-026**: All language-model inference MUST run on the device; the feature MUST work with
  the network disabled and MUST send no banking data off the phone.
- **FR-027**: If no on-device model is available, the assistant screen MUST tell the user to
  download one and MUST NOT attempt inference.

### Key Entities

- **Account**: identifier, display name, type (chequing, savings, credit, line of credit), masked
  number, available balance (available credit for credit accounts), currency CAD. Credit
  accounts can be viewed but never fund a send or receive a request.
- **Contact**: identifier, name, optional email, optional phone, Autodeposit flag. Saved contacts
  are seeded or created during the run.
- **Recipient**: either a saved Contact or a manual entry (email and/or phone) with Autodeposit
  treated as off and an optional "save as contact" intent.
- **Delivery channel**: Email or SMS (phone).
- **Transfer form**: recipient, amount, source account, channel, optional security question and
  answer, submit state. Derived from the user's text plus banking data.
- **Request form**: recipient, amount, deposit account, channel, optional memo, submit state.
- **Transfer result**: reference (`TRF-`), status (Sent / Pending security answer), amount,
  recipient, channel, destination, source account, time.
- **Money request result**: reference (`REQ-`), status (Request sent), amount, requestee,
  channel, destination, deposit account, memo, time.
- **Assistant turn**: the user's text plus the assistant's reply, which is a text message, one or
  more balance cards, a form, a confirmation, or a fallback message.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: All 14 acceptance scenarios in the feature request (mirrored in User Stories 1–3
  above) pass on a physical Android device with the model downloaded and the network turned off.
- **SC-002**: For every supported prompt in the examples list, the first interactive card or form
  appears within 8 seconds of sending the message on the reference device, measured from tap to
  first rendered interactive element; the median across the example prompts is at most 5
  seconds. These targets are provisional; the plan may revise them with measured evidence and
  must record the device used.
- **SC-003**: Recipient autocomplete suggestions update within 200 ms of each keystroke and never
  wait on the language model.
- **SC-004**: Once a form is shown, 100% of valid sends and requests complete with exactly one
  Submit and no further typed message.
- **SC-005**: 100% of invalid inputs listed in Edge Cases are blocked before submission or
  rejected with a verbatim reason message; none produce a confirmation.
- **SC-006**: In zero test runs does the security answer appear in any model prompt, model
  output, log, or confirmation.
- **SC-007**: In zero test runs does the assistant select a delivery channel for a recipient with
  both email and phone, or offer a credit account as source or deposit account.
- **SC-008**: Every malformed or empty assistant UI response results in the fallback message; no
  blank or partially rendered card is observed.

## Assumptions

- The existing in-memory mock banking service (feature 004) is extended in place; its current
  rejection messages (e.g. "Insufficient balance in …", "… has no phone number for PHONE
  delivery.") are kept and shown verbatim.
- "Clearly matches" means the top-ranked contact scores markedly above the second (exact first
  name or exact email/phone beats a fuzzy match). Thresholds are chosen during planning and
  verified against the Ali/Alice/Alicia and Bob/Robert cases.
- "SMS" in the UI is the user-facing label for the phone delivery channel; rejection messages
  from the banking service may say "PHONE".
- The assistant lives on a new screen in the app, reachable from the existing navigation. Only
  one assistant conversation exists at a time; it is not persisted across restarts.
- An on-device text model from the existing model-download feature is required and must already
  be downloaded; selecting and downloading models is out of scope here.
- The interactive cards and forms are described by the assistant and rendered by the app from a
  fixed set of card/form components the app controls; the assistant cannot introduce arbitrary UI.
  Form validation, autocomplete, and submission are handled by the app, not by the model.
- Saving a manual recipient as a contact happens when the send or request is submitted with the
  save option selected.
- The reference device for SC-002 is the developer's physical Android phone used for the POC; the
  plan records its make, model, and chosen on-device model.
- Out of scope: real bank or Interac integration, authentication, transfer history, cancelling
  transfers, fulfilling money requests, recurring transfers, multi-currency, transfer limits,
  fees, voice input, and accessibility beyond the platform defaults for standard controls.
