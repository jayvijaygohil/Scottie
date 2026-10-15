package com.jayvijay.scottie.feature.interacbanking.presentation

import com.jayvijay.scottie.feature.interacbanking.data.ai.tools.MockInteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.ChannelHint
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.Intent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceException
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Recipient
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult
import com.jayvijay.scottie.feature.interacbanking.domain.repository.TextModelSource
import com.slack.circuit.runtime.screen.ParcelableScreen
import com.slack.circuit.test.CircuitReceiveTurbine
import com.slack.circuit.test.FakeNavigator
import com.slack.circuit.test.test
import java.io.IOException
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class InteracAssistantPresenterTest {
  private val navigator = FakeNavigator(InteracAssistantScreen)
  private val extractor = FakeIntentExtractor()
  private val banking = CountingBanking(MockInteracBankingTools())
  private val bridge = FakeA2uiBridge()
  private val source = FakeTextModelSource()
  private val presenter by lazy {
    InteracAssistantPresenter(navigator, extractor, banking, { bridge }, source) { SettingsScreen }
  }

  private fun modelPresent() {
    source.active.value = MODEL
  }

  private fun balance(id: String) =
    banking.getAccountBalances().single { it.accountId == id }.availableBalance

  private suspend fun CircuitReceiveTurbine<InteracAssistantState>.awaitState(
    predicate: (InteracAssistantState) -> Boolean
  ): InteracAssistantState {
    var state = awaitItem()
    while (!predicate(state)) state = awaitItem()
    return state
  }

  /** From [state], sends [text] with [intent] queued; returns the state once the turn replied. */
  private suspend fun CircuitReceiveTurbine<InteracAssistantState>.send(
    state: InteracAssistantState,
    text: String,
    intent: AssistantIntent,
  ): InteracAssistantState {
    extractor.enqueue(intent)
    state.eventSink(InteracAssistantAction.InputChanged(text))
    awaitState { it.input == text }.eventSink(InteracAssistantAction.Send)
    val turnCount = state.turns.size + 1
    return awaitState { s ->
      s.turns.size == turnCount && s.turns.last().reply !is TurnReply.Thinking && !s.busy
    }
  }

  private fun send(
    amount: Double? = null,
    who: String? = null,
    account: String? = null,
    hint: ChannelHint? = null,
  ) = AssistantIntent(Intent.SEND, amount, who, account, channelHint = hint)

  private fun request(
    amount: Double?,
    who: String?,
    account: String? = null,
    memo: String? = null,
    hint: ChannelHint? = null,
  ) = AssistantIntent(Intent.REQUEST, amount, who, account, memo, hint)

  private fun balanceIntent(hint: String?) = AssistantIntent(Intent.BALANCE, accountHint = hint)

  private fun accountIds(): List<String> {
    val accounts = bridge.rootData()["options"]!!.jsonObject["accounts"]!!.jsonArray
    return accounts.map { it.jsonObject.str("id") }
  }

  private fun cardNames() =
    bridge.rootData()["accounts"]!!.jsonArray.map { it.jsonObject.str("name") }

  @Test
  fun missingModelBlocksSendUntilOneIsDownloaded() = runTest {
    presenter.test {
      val state = awaitItem()
      assertNull(state.activeModelId)
      assertTrue(state.turns.isEmpty())
      assertFalse(state.busy)
      assertTrue(state.missingModel)
      state.eventSink(InteracAssistantAction.InputChanged("hi"))
      awaitState { it.input == "hi" }.eventSink(InteracAssistantAction.Send)
      state.eventSink(InteracAssistantAction.OpenSettings)
      assertEquals(SettingsScreen, navigator.awaitNextScreen())
      assertTrue(extractor.calls.isEmpty())

      modelPresent()
      val ready = awaitState { !it.missingModel }
      assertEquals(MODEL, ready.activeModelId)
      assertTrue(ready.turns.isEmpty())
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun sendUsesTheActiveModelAndIsIgnoredWhileBusy() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      extractor.enqueue(AssistantIntent(Intent.OTHER, reply = "ok"))
      val gate = CompletableDeferred<Unit>().also { extractor.gate = it }
      awaitState { !it.missingModel }.eventSink(InteracAssistantAction.InputChanged("hello"))
      awaitState { it.input == "hello" }.eventSink(InteracAssistantAction.Send)
      val thinking = awaitState { it.busy && it.turns.singleOrNull()?.reply == TurnReply.Thinking }
      assertEquals("", thinking.input)
      thinking.eventSink(InteracAssistantAction.InputChanged("again"))
      val withDraft = awaitState { it.input == "again" }
      withDraft.eventSink(InteracAssistantAction.Send)
      withDraft.eventSink(InteracAssistantAction.ClearChat)
      gate.complete(Unit)
      val done = awaitState { !it.busy && it.turns.singleOrNull()?.reply == TurnReply.Text("ok") }
      assertEquals(listOf(MODEL), extractor.modelIds)
      assertEquals(listOf("hello"), extractor.calls)
      assertEquals("again", done.input)

      source.active.value = OTHER
      val switched = awaitState { it.activeModelId == OTHER }
      assertEquals(1, switched.turns.size)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun clearChatResetsTurnsInputAndDeletesSurfacesWhenNotBusy() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s = awaitState { !it.missingModel }
      // Ignored when turns and input are both empty.
      s.eventSink(InteracAssistantAction.ClearChat)

      s = send(s, "savings", balanceIntent("savings"))
      bridge.showSurface("turn-1")
      s = awaitState { it.surfaces.isNotEmpty() }
      s.eventSink(InteracAssistantAction.InputChanged("draft text"))
      s = awaitState { it.input == "draft text" }

      s.eventSink(InteracAssistantAction.ClearChat)
      val cleared = awaitState { it.turns.isEmpty() && it.input.isEmpty() }
      assertEquals(listOf("turn-1"), bridge.surfaceIds("deleteSurface"))

      // Subsequent turn starts fresh at turn-1.
      val next = send(cleared, "hi", AssistantIntent(Intent.OTHER, reply = "fresh"))
      assertEquals(1, next.turns.single().id)
      assertEquals(TurnReply.Text("fresh"), next.turns.single().reply)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun offTopicAndFailures() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s = awaitState { !it.missingModel }
      s = send(s, "What's the weather?", AssistantIntent(Intent.OTHER, reply = "I can help."))
      assertEquals(TurnReply.Text("I can help."), s.turns.last().reply)

      s = send(s, "weather", AssistantIntent.FALLBACK)
      assertEquals(TurnReply.Text(null), s.turns.last().reply)

      extractor.enqueueFailure(IllegalStateException("engine"))
      s.eventSink(InteracAssistantAction.InputChanged("x"))
      awaitState { it.input == "x" }.eventSink(InteracAssistantAction.Send)
      val failed = awaitState {
        it.turns.size == 3 && it.turns.last().reply is TurnReply.Failed && !it.busy
      }
      assertEquals(TurnReply.Failed(InferenceFailure.UNKNOWN), failed.turns.last().reply)
      assertEquals("x", failed.turns.last().userText)
      assertEquals(listOf("What's the weather?", "weather", "x"), extractor.calls)
      assertTrue(bridge.accepted.value.isEmpty())
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun sendResolvesRecipientChannelAndSecurity() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s = send(awaitItem(), "Send $50 to Alice", send(50.0, "Alice"))
      assertEquals(TurnReply.Surface("turn-1"), s.turns.single().reply)
      assertEquals(listOf("turn-1"), bridge.surfaceIds("createSurface"))
      with(bridge.form()) {
        assertEquals("ct_alice", str("recipientId"))
        assertEquals("Alice Martin", str("recipientQuery"))
        assertEquals("50.00", str("amount"))
        assertEquals("EMAIL", str("channel"))
        assertTrue(bool("channelLocked"))
        assertFalse(bool("securityRequired"))
      }
      assertNull(bridge.component("alert"))

      s = send(s, "Send money to Charlie", send(who = "Charlie"))
      with(bridge.form()) {
        assertEquals("", str("channel"))
        assertFalse(bool("channelLocked"))
        assertTrue(bool("securityRequired"))
        assertEquals("", str("amount"))
      }

      s = send(s, "Send 40 to Ali", send(40.0, "Ali"))
      assertEquals("", bridge.form().str("recipientId"))
      val options = bridge.rootData()["options"]!!.jsonObject["recipients"]!!.jsonArray
      assertEquals(listOf("ct_alice", "ct_alicia"), options.map { it.jsonObject.str("id") })

      s = send(s, "Send $10 to sam@example.com", send(10.0, "sam@example.com"))
      with(bridge.form()) {
        assertEquals("sam@example.com", str("manualEmail"))
        assertEquals("", str("recipientId"))
        assertEquals("EMAIL", str("channel"))
        assertTrue(bool("channelLocked"))
        assertTrue(bool("securityRequired"))
      }

      s = send(s, "e-Transfer 75 to 416-555-0143", send(75.0, "416-555-0143"))
      assertEquals("ct_bob", bridge.form().str("recipientId"))
      assertEquals("PHONE", bridge.form().str("channel"))

      s = send(s, "Send 40 to Charly", send(40.0, "Charly"))
      assertEquals("ct_charlie", bridge.form().str("recipientId"))

      send(s, "Send $20 to bob from my savings", send(20.0, "bob", "savings"))
      assertEquals("acc_sav_202", bridge.form().str("accountId"))
      assertEquals(listOf("acc_sav_202", "acc_chk_101", "acc_chk_303"), accountIds())
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun sendAccountRulesAndExplicitChannel() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s =
        send(awaitItem(), "Send $2,000 from Everyday", send(2000.0, account = "Everyday Chequing"))
      assertNull(bridge.component("form"))
      assertEquals(
        "Insufficient balance in Everyday Chequing: available 1540.25, requested 2000.0.",
        bridge.component("alert")!!.str("text"),
      )
      assertEquals(listOf("Everyday Chequing", "High-Interest Savings"), cardNames())
      assertEquals(
        listOf(true, false),
        bridge.rootData()["accounts"]!!.jsonArray.map { it.jsonObject.bool("highlight") },
      )

      s = send(s, "Send $100 to Alice", send(100.0, "Alice"))
      assertEquals(listOf("acc_chk_101", "acc_sav_202"), accountIds())

      s = send(s, "Send $9,000 to Alice", send(9000.0, "Alice"))
      assertNull(bridge.component("form"))
      assertEquals("noAccountCovers", bridge.component("alert")!!.str("noticeKind"))
      assertEquals("9,000.00", bridge.component("alert")!!.str("noticeArg"))
      assertEquals(4, cardNames().size)

      send(s, "Email $5 to Bob", send(5.0, "Bob", hint = ChannelHint.EMAIL))
      assertEquals(
        "Bob Vance has no email for EMAIL delivery.",
        bridge.component("alert")!!.str("text"),
      )
      assertEquals("PHONE", bridge.form().str("channel"))
      assertTrue(bridge.form().bool("channelLocked"))
      assertEquals(1, banking.sends)
      assertEquals(1540.25, balance("acc_chk_101"), 0.0)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun formEventsAutocompleteSelectAndSubmit() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      send(awaitItem(), "Send $20 to Bob", send(20.0, "Bob"))
      val id = "turn-1"

      bridge.emitEvent("recipientQuery", id, mapOf("query" to "Ali"))
      val suggestions = bridge.awaitUpdate("/suggestions")
      assertTrue(suggestions, "ct_alicia" in suggestions && "ct_alice" in suggestions)
      assertEquals(1, extractor.calls.size)

      bridge.emitEvent("selectRecipient", id, mapOf("id" to "ct_charlie"))
      assertEquals("\"\"", bridge.awaitUpdate("/form/channel"))
      assertEquals("false", bridge.awaitUpdate("/form/channelLocked"))
      assertEquals("true", bridge.awaitUpdate("/form/securityRequired"))

      bridge.emitEvent(
        "submit",
        id,
        bridge.submitContext(
          "accountId" to "acc_chk_101",
          "securityQuestion" to "Pet?",
          "securityAnswer" to "Rex",
        ),
      )
      val confirmation = bridge.awaitLine { "PENDING_SECURITY_ANSWER" in it }
      assertTrue("TRF-" in confirmation)
      assertFalse("Rex" in confirmation)
      assertEquals("PHONE", bridge.rootData()["result"]!!.jsonObject.str("channelCode"))
      assertEquals(listOf(id), bridge.surfaceIds("deleteSurface"))
      assertEquals(1520.25, balance("acc_chk_101"), 0.0)
      assertEquals(1, banking.sends)
      assertEquals(1, extractor.calls.size)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun rejectedSubmitShowsVerbatimAlertOnceAndSavesManualContact() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      send(awaitItem(), "Send $10 to sam@example.com", send(10.0, "sam@example.com"))
      bridge.emitEvent(
        "submit",
        "turn-1",
        bridge.submitContext(
          "accountId" to "acc_chk_101",
          "amount" to "5000",
          "securityQuestion" to "Q",
          "securityAnswer" to "A",
          "saveContact" to true,
        ),
      )
      val alert = bridge.awaitLine { "Insufficient balance" in it }
      assertTrue(alert, "available 1540.25, requested 5000.0." in alert)
      assertEquals("false", bridge.awaitUpdate("/form/busy"))
      assertEquals(1, banking.sends)
      assertEquals(1540.25, balance("acc_chk_101"), 0.0)
      assertEquals(emptyList<String>(), bridge.surfaceIds("deleteSurface"))
      assertEquals(0, banking.findContacts("sam").size)

      bridge.emitEvent(
        "submit",
        "turn-1",
        bridge.submitContext(
          "accountId" to "acc_chk_101",
          "securityQuestion" to "Q",
          "securityAnswer" to "A",
          "saveContact" to true,
        ),
      )
      bridge.awaitLine { "TRF-" in it }
      assertEquals(2, banking.sends)
      assertEquals(1530.25, balance("acc_chk_101"), 0.0)
      val saved = banking.findContacts("sam").single()
      assertEquals("sam@example.com", saved.email)
      assertFalse(saved.autodepositEnabled)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun balanceCards() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s = send(awaitItem(), "savings", balanceIntent("savings"))
      assertEquals(listOf("High-Interest Savings"), cardNames())
      s = send(s, "chequing", balanceIntent("my chequing"))
      assertEquals(listOf("Everyday Chequing", "Joint Chequing"), cardNames())
      s = send(s, "4821", balanceIntent("ending 4821"))
      assertEquals(listOf("Everyday Chequing"), cardNames())
      s = send(s, "visa", balanceIntent("my visa"))
      assertEquals(
        "2,500.00",
        bridge.rootData()["accounts"]!!.jsonArray[0].jsonObject.str("balance"),
      )
      s = send(s, "tfsa", balanceIntent("TFSA"))
      assertEquals(4, cardNames().size)
      assertEquals("TFSA", bridge.component("alert")!!.str("noticeArg"))
      s = send(s, "all", balanceIntent(null))
      assertEquals(4, cardNames().size)
      assertNull(bridge.component("alert"))

      banking.executeSendTransfer(
        "acc_chk_101",
        Recipient.Saved("ct_alice"),
        1500.0,
        DeliveryChannel.EMAIL,
      )
      send(s, "everyday", balanceIntent("Everyday"))
      assertEquals("40.25", bridge.rootData()["accounts"]!!.jsonArray[0].jsonObject.str("balance"))
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun requestFlow() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s =
        send(
          awaitItem(),
          "Request $30 from Alice into savings for dinner",
          request(30.0, "Alice", "savings", "dinner"),
        )
      with(bridge.form()) {
        assertEquals("request", str("mode"))
        assertEquals("acc_sav_202", str("accountId"))
        assertEquals("dinner", str("memo"))
        assertFalse(bool("securityRequired"))
        assertEquals("EMAIL", str("channel"))
      }
      bridge.emitEvent("submit", "turn-1", bridge.submitContext())
      val confirmation = bridge.awaitLine { "REQ-" in it }
      assertTrue("\"memo\":\"dinner\"" in confirmation)
      assertEquals("request", bridge.component("result")!!.str("kind"))
      assertEquals(1540.25, balance("acc_chk_101"), 0.0)
      assertEquals(6200.0, balance("acc_sav_202"), 0.0)

      s = send(s, "Request $30 from Alice by text", request(30.0, "Alice", hint = ChannelHint.SMS))
      assertEquals(
        "Alice Martin has no phone number for PHONE delivery.",
        bridge.component("alert")!!.str("text"),
      )
      assertEquals("EMAIL", bridge.form().str("channel"))
      assertTrue(bridge.form().bool("channelLocked"))
      assertEquals(2, banking.requests)
      assertEquals(1, bridge.accepted.value.count { "REQ-" in it })

      send(s, "Ask Alicia for 25 bucks", request(25.0, "Alicia"))
      with(bridge.form()) {
        assertEquals("ct_alicia", str("recipientId"))
        assertEquals("25.00", str("amount"))
        assertTrue(bool("channelLocked"))
        assertEquals("", str("memo"))
      }
      assertEquals(listOf("acc_chk_101", "acc_chk_303", "acc_sav_202"), accountIds())
      bridge.emitEvent("submit", "turn-3", bridge.submitContext("accountId" to "acc_chk_101"))
      bridge.awaitLine { "Alicia Moreno" in it && "REQ-" in it }
      assertEquals(3, banking.requests)
      assertEquals(0, banking.sends)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun clientErrorsAndBridgeFailuresFallBack() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      send(awaitItem(), "Send $50 to Alice", send(50.0, "Alice"))
      bridge.emitError("turn-1")
      val fallen = awaitState { it.turns.single().reply is TurnReply.Fallback && !it.busy }
      assertEquals(listOf("turn-1"), bridge.surfaceIds("deleteSurface"))

      bridge.throwOnAccept = true
      val broken = send(fallen, "Send $5 to Alice", send(5.0, "Alice"))
      assertEquals(TurnReply.Fallback, broken.turns.last().reply)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun firstCardIsTimedWhenTheSurfaceAppears() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      val s = send(awaitItem(), "Send $50 to Alice", send(50.0, "Alice"))
      assertNull(s.turns.single().firstCardMs)
      bridge.showSurface("turn-1")
      val timed = awaitState { it.turns.single().firstCardMs != null }
      assertTrue(timed.turns.single().firstCardMs!! >= 0)
      assertEquals(1, timed.surfaces.size)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun classifiedFailureKeepsTheTurnAndAllowsRetry() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      val s = awaitState { !it.missingModel }
      extractor.enqueueFailure(InferenceException(InferenceFailure.OFFLINE, IOException()))
      s.eventSink(InteracAssistantAction.InputChanged("hi"))
      awaitState { it.input == "hi" }.eventSink(InteracAssistantAction.Send)
      val failed = awaitState { it.turns.size == 1 && !it.busy }
      assertEquals(TurnReply.Failed(InferenceFailure.OFFLINE), failed.turns.single().reply)
      assertEquals("hi", failed.turns.single().userText)

      val retried = send(failed, "hi", AssistantIntent(Intent.OTHER, reply = "ok"))
      assertEquals(TurnReply.Text("ok"), retried.turns.last().reply)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun remoteActiveModelIsPassedToInference() = runTest {
    source.active.value = REMOTE
    presenter.test(timeout = 5.seconds) {
      send(awaitState { !it.missingModel }, "hi", AssistantIntent(Intent.OTHER, reply = "ok"))
      assertEquals(listOf(REMOTE), extractor.modelIds)
      cancelAndIgnoreRemainingEvents()
    }
  }

  @Test
  fun transactionQueriesAndLiveTransferVisibility() = runTest {
    modelPresent()
    presenter.test(timeout = 5.seconds) {
      var s =
        send(
          awaitState { !it.missingModel },
          "Did I get my salary?",
          AssistantIntent(
            Intent.TRANSACTIONS,
            scenario = AssistantIntent.TransactionScenario.SALARY_CHECK,
          ),
        )
      assertEquals(TurnReply.Surface("turn-1"), s.turns.last().reply)
      assertEquals("SALARY_CHECK", bridge.rootData()["summary"]!!.jsonObject.str("scenarioCode"))
      assertEquals("CONFIRMED", bridge.rootData()["summary"]!!.jsonObject.str("statusCode"))

      s =
        send(
          s,
          "Did I pay my rent?",
          AssistantIntent(
            Intent.TRANSACTIONS,
            scenario = AssistantIntent.TransactionScenario.RENT_CHECK,
          ),
        )
      assertEquals("RENT_CHECK", bridge.rootData()["summary"]!!.jsonObject.str("scenarioCode"))
      assertEquals("CONFIRMED", bridge.rootData()["summary"]!!.jsonObject.str("statusCode"))

      s =
        send(
          s,
          "Groceries on TFSA",
          AssistantIntent(
            Intent.TRANSACTIONS,
            accountHint = "TFSA",
            scenario = AssistantIntent.TransactionScenario.MERCHANT_CATEGORY,
            searchQuery = "groceries",
          ),
        )
      assertEquals("TFSA", bridge.component("alert")!!.str("noticeArg"))
      assertEquals("339.15", bridge.rootData()["summary"]!!.jsonObject.str("outflowAmount"))

      s =
        send(
          s,
          "Any duplicate or unusual charges?",
          AssistantIntent(
            Intent.TRANSACTIONS,
            scenario = AssistantIntent.TransactionScenario.ANOMALIES,
          ),
        )
      assertEquals("ANOMALIES", bridge.rootData()["summary"]!!.jsonObject.str("scenarioCode"))
      assertEquals("CONFIRMED", bridge.rootData()["summary"]!!.jsonObject.str("statusCode"))

      val trf =
        banking.executeSendTransfer(
          "acc_chk_101",
          Recipient.Saved("ct_alice"),
          50.0,
          DeliveryChannel.EMAIL,
        )
      send(
        s,
        "Show my recent transfers",
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = AssistantIntent.TransactionScenario.REFUNDS_TRANSFERS,
          searchQuery = "transfer",
        ),
      )
      val itemIds = bridge.rootData()["items"]!!.jsonArray.map { it.jsonObject.str("id") }
      assertTrue(trf.referenceId in itemIds)
      cancelAndIgnoreRemainingEvents()
    }
  }

  private class FakeTextModelSource : TextModelSource {
    override val active = MutableStateFlow<String?>(null)
  }

  /** Counts money-moving calls so tests can assert "exactly once". */
  private class CountingBanking(private val delegate: InteracBankingTools) :
    InteracBankingTools by delegate {
    var sends = 0
    var requests = 0

    override fun executeSendTransfer(
      fromAccountId: String,
      recipient: Recipient,
      amount: Double,
      deliveryChannel: DeliveryChannel,
      securityQuestion: String?,
      securityAnswer: String?,
    ): TransferResult {
      sends++
      return delegate.executeSendTransfer(
        fromAccountId,
        recipient,
        amount,
        deliveryChannel,
        securityQuestion,
        securityAnswer,
      )
    }

    override fun executeRequestMoney(
      recipient: Recipient,
      depositAccountId: String,
      amount: Double,
      deliveryChannel: DeliveryChannel,
      memo: String?,
    ): MoneyRequestResult {
      requests++
      return delegate.executeRequestMoney(
        recipient,
        depositAccountId,
        amount,
        deliveryChannel,
        memo,
      )
    }
  }
}

@Parcelize private data object SettingsScreen : ParcelableScreen

private const val MODEL = "m.litertlm"
private const val OTHER = "o.litertlm"
private const val REMOTE = "openrouter:x/y"
