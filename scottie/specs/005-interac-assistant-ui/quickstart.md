# Quickstart: validating the Interac e-Transfer assistant

**Feature**: `005-interac-assistant-ui` | Spec: [spec.md](spec.md) | Plan: [plan.md](plan.md)

## 0. Confirm the LiteRT client is on the classpath (before writing code)

```sh
./gradlew :app:dependencies --configuration debugRuntimeClasspath | grep -E "litert|litertlm"
```

Expected: `ai.koog:prompt-executor-litert-client-android:1.3.0-beta` and
`com.google.ai.edge.litertlm:litertlm-android:0.11.0`. If absent, add
`koog-prompt-executor-litert = { group = "ai.koog", name = "prompt-executor-litert-client", version.ref = "koogAdditions" }`
to the catalog and `implementation(libs.koog.prompt.executor.litert)` — same version family, not an
upgrade.

**Result (2026-10-06, T001)**: both present on `debugRuntimeClasspath` via
`koog-agents-additions` → `prompt-executor-litert-client:1.3.0-beta` → `litertlm-android:0.11.0`.
`litertlm-android` is only a *runtime* transitive, so `com.google.ai.edge.litertlm.Backend` (used by
`LiteRTClientConfig(backend = …)`) did not compile; the same 0.11.0 artifact is now declared as
`implementation(libs.litertlm.android)` (catalog alias `litertlm-android`). No version change.

## 1. Automated checks

```sh
./gradlew :app:assembleDebug
./gradlew :app:testDebugUnitTest --tests "com.jayvijay.scottie.feature.interacbanking.*" --tests "com.jayvijay.scottie.core.ai.*"
./gradlew :app:detekt :app:lintDebug
./gradlew :app:connectedDebugAndroidTest --tests "com.jayvijay.scottie.feature.interacbanking.*"   # device/emulator
```

Unit tests to expect green:
- `MockInteracBankingToolsTest` (existing 16 + new: accounts/contacts, fuzzy ranking table from
  research R6, saveContact, manual recipient, memo, credit rejections).
- `InteracResolutionTest` (account hints incl. "TFSA" → empty, eligibility ordering, amount rules).
- `InteracAssistantAgentTest` (mock executor; one case per example prompt; tool round-trip; malformed
  JSON → `OTHER`).
- `InteracSurfaceTemplatesTest` (JSON assertions per acceptance scenario).
- `InteracAssistantPresenterTest` (fake `IntentExtractor` + fake `A2uiBridge` + real mock service).

Instrumented: `InteracFormTest` (A2uiTestController) — submit gating, whitespace, masked answer,
channel unset, security toggle, writeback, submit context.

## 2. Device run (network off)

1. Install debug build on the reference phone; open **Download models**; download **Gemma 4 E2B**
   (or Qwen3 0.6B on a low-RAM device). Wait for *Downloaded*.
2. Enable airplane mode.
3. Tap **Use with Interac assistant** on the downloaded model card.
4. First turn is cold (engine init). Type `What's my balance?` — expect four balance cards. Note
   the `first_card_ms` debug caption / logcat line (`InteracAssistant`).
5. Run the 14 acceptance scenarios from [spec.md](spec.md) in order. Scenario 7 ends with a
   force-stop + relaunch to confirm balances reset.
6. Tool-calling check (research R1 limitation): in logcat filter `InteracBanking`, confirm at
   least one `tool=findContacts` line for `Send 40 to Ali`. If tool calls never appear or produce
   garbage arguments, change `toolRegistry()` in `di/InteracModule.kt` to return
   `ToolRegistry.EMPTY` and re-run scenario 8 — it must still show Alice and Alicia (presenter
   resolution).

**Status (2026-10-06)**: not run — no device or emulator was attached during implementation.
§1 automated checks: 126 unit tests green (`:app:testDebugUnitTest`), `:app:detekt`,
`:app:lintDebug`, `:app:assembleDebug`, and `:app:compileDebugAndroidTestKotlin` pass;
`connectedDebugAndroidTest` (`InteracFormTest`, `InteracAssistantUiTest`) is compiled but not
executed. §3–§5 tables remain to be filled from a device run.

## 3. Latency table (SC-002)

Fill from logcat `first_card_ms`; warm = second and later turns.

| Prompt | cold ms | warm ms |
|---|---|---|
| What's my balance? | | |
| How much is in my savings? | | |
| What's in my TFSA? | | |
| Send 50 to Alice | | |
| Send $20 to bob from my savings | | |
| Send money to charlie.c@example.ca | | |
| e-Transfer 75 to 416-555-0143 | | |
| Send 40 to Charly | | |
| Send money | | |
| Request $30 from Jane for dinner | | |
| Ask Alicia for 25 bucks | | |

Pass: warm max ≤ 8000, warm median ≤ 5000. Record device model, SoC, and model file. If failing,
apply levers in research R11 in order and re-measure.

## 4. Autocomplete timing (SC-003)

In `InteracFormTest`, assert the `recipientQuery` outbound event is emitted and
`getData("/suggestions")` is non-empty after `updateData`. On device, type `Al` in the recipient
field with the model still generating a previous turn's reply disabled (busy) — suggestions must
still appear immediately.

## 5. Security-answer leak check (SC-006)

Run scenario 2 with logcat at verbose. `grep -i "<the answer you typed>"` over the captured log
must return nothing. In `InteracAssistantAgentTest`, the mock executor's captured prompts never
contain the string `securityAnswer`.
