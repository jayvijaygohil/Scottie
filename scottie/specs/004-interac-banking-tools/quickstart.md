# Quickstart: Mock Interac Banking Tools

## Prerequisites

The repository builds with `./gradlew :app:assembleDebug`. No device, network, or API key is
needed.

## Validate

```sh
./gradlew :app:testDebugUnitTest --tests '*MockInteracBankingToolsTest'
./gradlew :app:assembleDebug :app:detekt :app:lintDebug
```

## Scenarios the test must cover

Each scenario uses a fresh `MockInteracBankingTools()`, which stands in for an app restart.

| # | Scenario | Expected |
|---|---|---|
| 1 | Send $50 chequing → Alice, EMAIL, no Q&A | `SENT`, destination `alice.m@example.com`, ref `TRF-[A-Z0-9]{8}`, timestamp parses as `Instant` |
| 2 | Send $20 → Bob, PHONE, with Q&A | `PENDING_SECURITY_ANSWER`, destination `+1-416-555-0143` |
| 3 | Send → Bob without Q&A, or with blank Q&A | exact FR-007 message; balance unchanged |
| 4 | Send $2,000 from chequing | insufficient-balance error |
| 5 | Send $1,500 then another $1,500 from chequing | the balance reads 40.25 after the first; the second is rejected |
| 6 | New instance after scenario 5 | balances are 1540.25 and 6200.00 |
| 7 | Send → Alice via PHONE; request ← Alice via PHONE | channel-mismatch error |
| 8 | Amount 0 or negative (send and request) | amount error |
| 9 | Unknown account or contact IDs | not-found error naming the ID |
| 10 | `findContacts("char")`, `("EXAMPLE.CA")`, `("416-555")`, `(null)`, `("zzz")` | Charlie; Charlie; Bob; all 3; empty |
| 11 | Request $30 ← Alice into savings, EMAIL | `REQUEST_SENT`, ref `REQ-…`, balances unchanged |
| 12 | Send exactly the full balance | succeeds; balance 0.0 |
| 13 | `asTools()` | exposes exactly the 4 tool names; `getTool("executeSendTransfer")` + `decodeArgs(JSONObject(...), KotlinxSerializer())` without the security keys, then `execute` in `runTest`, returns `SENT` for Alice (Kotlin defaults applied) |

## Not covered here

The live LLM and the A2UI form behavior from FR-014 and FR-015 are out of scope until an agent host
exists. Only the presence of the instruction text is checked, by inspection.
