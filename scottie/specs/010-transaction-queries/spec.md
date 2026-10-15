# Feature Specification: Conversational Transaction Queries & Financial Insights

**Feature Branch**: `010-transaction-queries`

**Created**: 2026-10-14

**Status**: Draft

**Input**: User description: "Extend the agent's capabilities to query and display user transactions across the following workflows:
1. Date-Range Queries: Allow users to request all transactions between a start date (X) and end date (Y).
2. Salary Verification ("Did I get my salary?"): Since payroll descriptors vary, identify probable salary deposits by filtering for incoming credits/deposits and detecting recurring monthly inflows of similar amounts. Display the matching candidate transactions to the user.
3. Rent Verification ("Did I pay my rent this month?"): Identify probable rent payments by filtering for outgoing debits in the current month and matching them against historical, recurring monthly outflows of similar amounts or rent-related keywords. Display the possible matches to confirm.
4. Additional Financial Scenarios: Proactively identify and support other common personal finance queries—such as tracking recurring subscriptions and utility bills, searching by merchant or category, flagging unusually large or duplicate charges, and checking specific refunds or transfers."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Query transactions by date range, account, merchant, or category (Priority: P1)

A user asks the banking assistant to show their transactions over a specific period (such as "show my transactions between September 1 and September 15", "what did I spend last month?", or "show recent transactions on my Rewards Visa") or filtered by merchant/category (such as "how much did I spend on groceries?" or "show my Uber transactions"). The assistant answers inside the conversation with a structured transaction list showing each matching entry's date, description/merchant, category, account, direction (inflow or outflow), and amount, along with a summary count and net or total amount.

**Why this priority**: Viewing and filtering transaction history by date, merchant, category, and account is the foundational capability upon which all specialized financial insights depend.

**Independent Test**: Ask the assistant for transactions across an explicit date range, a relative period ("this month", "last 7 days"), a specific merchant, and a specific spending category, and verify that the displayed transaction list contains only matching entries in reverse chronological order with accurate totals.

**Acceptance Scenarios**:

1. **Given** a multi-month transaction history across the user's accounts, **When** the user asks for transactions between start date X and end date Y (inclusive), **Then** the assistant displays all transactions whose date falls within `[X, Y]` ordered newest first, showing each transaction's date, merchant/description, category, account name, and signed/directional CAD amount.
2. **Given** transactions across multiple accounts, **When** the user includes an account phrase (such as "from my Everyday Chequing" or "on my Visa") with a date or merchant query, **Then** only transactions belonging to the matched account are shown.
3. **Given** transactions with merchant names and categories, **When** the user searches by merchant name (partial or case-insensitive, e.g., "Coffee" or "Hydro") or category (e.g., "utilities", "groceries", "dining", "entertainment"), **Then** all matching transactions are displayed along with the total amount across those matches.
4. **Given** a date range or filter that matches no transactions, **When** the user submits the query, **Then** the assistant displays an explicit empty-result notice stating the filter criteria that produced zero matches rather than a generic error.

---

### User Story 2 - Verify salary deposits ("Did I get my salary?") (Priority: P1)

A user asks whether their salary or paycheck has arrived (e.g., "Did I get my salary?", "Was I paid this month?", "Show my paychecks"). Because employers use varied payroll descriptors (such as `ADP PAYROLL`, `DIRECT DEP ACME CORP`, `CANADA PAYROLL`), the assistant identifies candidate salary deposits by filtering for incoming credits/deposits and matching recurring monthly or bi-weekly inflows of similar amounts (or payroll-related descriptors), then displays the candidate deposits and clearly indicates whether a deposit was received in the current period.

**Why this priority**: Payroll verification is an explicitly requested core workflow that directly answers a high-value everyday banking question without requiring the user to remember obscure payroll descriptors.

**Independent Test**: Ask "Did I get my salary?" and "Show my recent paychecks" against the mock transaction dataset and verify that the assistant highlights the current month's salary deposit (or reports if none has arrived yet this month) alongside historical recurring payroll inflows for comparison.

**Acceptance Scenarios**:

1. **Given** historical incoming deposits that recur on a regular cadence with similar amounts (within a 15% variance tolerance) or payroll descriptors, **When** the user asks "Did I get my salary?", **Then** the assistant identifies the probable salary inflows, highlights whether a matching deposit occurred in the current calendar month, and displays the candidate transactions with date, descriptor, receiving account, and amount.
2. **Given** a recurring salary pattern where no matching inflow has occurred yet in the current month, **When** the user asks "Did I get my salary this month?", **Then** the assistant states that no salary deposit was found for the current month and displays the most recent prior salary deposit(s) as reference.
3. **Given** one-off small incoming transfers or refunds alongside regular payroll credits, **When** the user asks for salary verification, **Then** non-recurring or small ad-hoc inflows (such as a $25 e-Transfer or retail refund) are excluded from the salary candidates.

---

### User Story 3 - Verify rent payments ("Did I pay my rent this month?") (Priority: P1)

A user asks whether they have paid their rent (e.g., "Did I pay my rent this month?", "When did I last pay rent?", "Show my rent payments"). The assistant filters outgoing debits in the current month and matches them against historical recurring monthly outflows of similar amounts or rent/landlord/property descriptors, displaying the matching candidate transactions so the user can confirm payment status.

**Why this priority**: Rent verification is an explicitly requested core workflow and a primary recurring obligation where users need immediate confirmation of current-month payment status.

**Independent Test**: Ask "Did I pay my rent this month?" against the transaction dataset and verify that the assistant surfaces the matching current-month and prior-month rent outflows with confirmation status, dates, descriptors, and amounts.

**Acceptance Scenarios**:

1. **Given** recurring monthly outgoing debits of similar amounts (within a 10% variance tolerance) or containing rent/property/landlord keywords, **When** the user asks "Did I pay my rent this month?", **Then** the assistant displays the matching outgoing transaction(s) for the current month along with recent historical rent payments to confirm the pattern.
2. **Given** historical monthly rent outflows but no matching debit in the current month yet, **When** the user asks "Did I pay my rent this month?", **Then** the assistant clearly states that no rent payment was detected for the current month and displays the previous month's rent payment for comparison.
3. **Given** multiple recurring monthly debits, **When** identifying rent candidates, **Then** the assistant prioritizes high-value monthly outflows and rent/lease/landlord descriptors over small recurring subscriptions.

---

### User Story 4 - Track recurring subscriptions, utility bills, anomalies, and refunds/transfers (Priority: P2)

A user asks broader personal finance questions:
- **Subscriptions & Utility Bills**: "What are my recurring subscriptions?", "Did I pay my hydro/internet bill?"
- **Unusually Large or Duplicate Charges**: "Are there any unusual or duplicate charges?", "Show large transactions over $500"
- **Refunds & Transfers**: "Did my refund come through?", "Show my recent e-Transfers"

The assistant detects the appropriate financial scenario, runs the corresponding transaction filter or pattern detector, and displays the matching transactions with a clear status summary.

**Why this priority**: Proactively supporting common personal finance scenarios rounds out the assistant's transaction intelligence using the same underlying transaction dataset and visual transaction list presentation.

**Independent Test**: Ask one prompt for each scenario (recurring bills/subscriptions, duplicate or unusually large charges, and refunds/transfers) and verify that each returns the expected filtered candidate transactions and summary insight.

**Acceptance Scenarios**:

1. **Given** recurring monthly charges for streaming services, memberships, and utilities, **When** the user asks "Show my subscriptions and utility bills", **Then** the assistant lists the detected recurring outflows grouped or labeled with their merchant, typical amount, and most recent charge date.
2. **Given** two identical charges to the same merchant for the same amount within 48 hours or a charge significantly exceeding the user's typical spend (or above a user-specified threshold), **When** the user asks "Are there any duplicate or unusual charges?", **Then** the assistant flags and displays those suspect transactions with the reason they were flagged (duplicate charge or unusually large amount).
3. **Given** incoming merchant credits/refunds and Interac e-Transfers, **When** the user asks "Did I get my refund?" or "Show my recent transfers", **Then** the assistant filters and displays the matching refund credits or transfer transactions.
4. **Given** the user sends a new Interac e-Transfer during the current app session, **When** the user subsequently queries recent transactions or transfers, **Then** the newly sent transfer appears in the transaction results for that session.

---

### Edge Cases

- **Inverted or invalid date range**: When the user specifies a start date after the end date (e.g., "between Oct 10 and Oct 1"), the assistant automatically normalizes the range to `[earliest, latest]` and displays the results for that span.
- **Open-ended or single-date queries**: When the user gives only a start date ("since September 1"), the end date defaults to today; when the user gives a single day ("on October 1") or month ("in September"), the range covers that full day or calendar month.
- **Ambiguous verification results**: When multiple recurring inflows or outflows could plausibly be salary or rent, the assistant displays all probable candidate transactions rather than guessing a single transaction silently, letting the user confirm.
- **No matching account hint**: When a transaction query names an account that does not exist (e.g., "transactions on my mortgage account"), the assistant informs the user that the named account was not found and displays matching transactions across all accounts.
- **Coexistence with e-Transfer actions**: Asking "Did I pay my rent?" or "Show transfers to Alice" MUST be treated as a read-only transaction lookup and MUST NOT open a send-money or request-money form unless the user asks to send or request money.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The system MUST provide a realistic, deterministic in-memory transaction history spanning at least the current calendar month and the two preceding calendar months across the user's existing mock accounts (`Everyday Chequing`, `High-Interest Savings`, `Joint Chequing`, `Rewards Visa`).
- **FR-002**: Each transaction record MUST include an identifier, account identifier and name, booking date (ISO calendar date `YYYY-MM-DD`), merchant or counterparty descriptor, category, direction (`CREDIT` inflow or `DEBIT` outflow), CAD amount, and optional metadata for transaction kind (payroll, rent, subscription, utility, refund, transfer, everyday purchase).
- **FR-003**: The system MUST support date-range transaction queries between a start date (X) and end date (Y) inclusive, handling both explicit calendar dates and relative date expressions ("today", "this week", "this month", "last month", "last 30 days").
- **FR-004**: The system MUST support salary verification queries by identifying incoming `CREDIT` transactions that match a recurring payroll pattern (monthly or bi-weekly inflows within 15% amount consistency and/or payroll-related descriptors) and reporting whether a salary deposit occurred in the queried or current month alongside historical candidates.
- **FR-005**: The system MUST support rent verification queries by identifying outgoing `DEBIT` transactions in the queried or current month that match historical recurring monthly outflows of similar amounts (within 10% amount consistency) or rent/lease/property descriptors, and displaying candidate matches with current-month payment status.
- **FR-006**: The system MUST support recurring subscription and utility bill queries by detecting repeating monthly debits to the same merchant or within subscription and utility categories.
- **FR-007**: The system MUST support merchant and category search queries using case-insensitive partial matching against transaction descriptors, merchant names, and spending categories.
- **FR-008**: The system MUST support anomaly queries that flag duplicate charges (same merchant and exact amount within 48 hours) and unusually large charges (debits exceeding a user-specified amount threshold or exceeding 3x the median everyday purchase amount, excluding known rent transfers).
- **FR-009**: The system MUST support refund and transfer queries by filtering for incoming merchant credits/refunds or Interac e-Transfer inflows/outflows.
- **FR-010**: When a user completes a send-money transfer during the active session, the system MUST record that transfer in the in-memory transaction history so subsequent transaction queries in the same session reflect it; transaction history resets to its initial seed state on app restart.
- **FR-011**: The assistant MUST present transaction query and verification results as a structured visual card/surface inside the conversation showing: a contextual header or verification banner (e.g., confirmed/not-yet-detected status, active filter summary, and total/net amount) and the list of matching transactions with date, descriptor, category/badge, account name, and formatted directional CAD amount.
- **FR-012**: When a query matches zero transactions, the assistant MUST render a clear notice stating what was searched and that no matching transactions were found, while showing relevant historical comparison transactions when applicable (such as prior month's salary or rent when current month is missing).
- **FR-013**: The assistant's intent classification MUST distinguish read-only transaction and insight queries from balance checks, send-money requests, and request-money actions without breaking existing workflows.

### Key Entities

- **Transaction**: A posted account entry with a unique ID, account reference, calendar date (`YYYY-MM-DD`), raw descriptor, normalized merchant/counterparty name, category (`INCOME`, `HOUSING`, `UTILITIES`, `SUBSCRIPTIONS`, `GROCERIES`, `DINING`, `TRANSPORT`, `SHOPPING`, `TRANSFER`, `REFUND`), direction (`CREDIT` or `DEBIT`), positive monetary amount in CAD, and optional insight flag (e.g., `RECURRING_SALARY`, `RECURRING_RENT`, `RECURRING_BILL`, `DUPLICATE_CANDIDATE`, `LARGE_CHARGE`, `REFUND`).
- **TransactionQueryFilter**: Criteria extracted or resolved from the user's prompt, including query scenario (`DATE_RANGE`, `SALARY_CHECK`, `RENT_CHECK`, `SUBSCRIPTIONS_BILLS`, `MERCHANT_CATEGORY`, `ANOMALIES`, `REFUNDS_TRANSFERS`), optional start date and end date, optional account hint, optional merchant/category search term, optional direction, and optional minimum amount threshold.
- **TransactionQueryResult**: The evaluated result set containing the scenario summary/verification status, matched transactions for the target period, optional historical reference transactions (for salary/rent comparison), total inflow/outflow summary, and any notice when an account hint or current-period match was not found.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: Users can query transactions for any valid start and end date range and receive an accurate list of 100% of matching seeded transactions in under 3 seconds after model inference completes.
- **SC-002**: Salary verification ("Did I get my salary?") and rent verification ("Did I pay my rent this month?") queries accurately surface candidate recurring transactions and state current-month status across both positive (present in current month) and negative (missing in current month) test scenarios with 0 false positives from unrelated small purchases or refunds.
- **SC-003**: 100% of supported additional finance scenarios (recurring subscriptions/utilities, merchant/category search, duplicate/large charge detection, and refund/transfer lookup) return deterministic, verifiable results from the mock dataset.
- **SC-004**: Existing balance lookup, send-money, and request-money acceptance tests continue to pass with 0 regressions.

## Assumptions

- Because Scottie is an offline-capable mock banking proof of concept, all transactions are stored in an in-memory mock dataset (consistent with existing mock accounts and contacts) and reset to initial seed data when the application restarts.
- Relative dates ("this month", "last month", "this week") are evaluated against the user's current local calendar date, and seeded mock transactions are anchored relative to the current calendar month so that "this month", "last month", and explicit recent date queries always have meaningful data regardless of when the app is run.
- Results are rendered inside the existing chat conversation as structured interactive cards so transaction lists and verification banners visually match existing balance and transfer confirmation cards.
