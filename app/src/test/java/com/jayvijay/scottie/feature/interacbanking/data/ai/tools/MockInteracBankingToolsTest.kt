package com.jayvijay.scottie.feature.interacbanking.data.ai.tools

import ai.koog.serialization.JSONObject
import ai.koog.serialization.kotlinx.KotlinxSerializer
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel.EMAIL
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel.PHONE
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestStatus
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Recipient
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferStatus
import java.time.Instant
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

private const val CHEQUING = "acc_chk_101"
private const val SAVINGS = "acc_sav_202"
private const val VISA = "acc_cc_404"
private val ALICE = Recipient.Saved("ct_alice")
private val BOB = Recipient.Saved("ct_bob")
private const val SECURITY_REQUIRED =
  "Recipient does not have Autodeposit enabled. A security question and answer are required."
private val SEEDED = listOf(1540.25, 6200.00, 85.40, 2500.00)

class MockInteracBankingToolsTest {
  private val tools = MockInteracBankingTools()

  private fun balance(id: String) =
    tools.getAccountBalances().single { it.accountId == id }.availableBalance

  private fun balances() = tools.getAccountBalances().map { it.availableBalance }

  private fun assertRejected(message: String, block: () -> Unit) {
    val error = assertThrows(IllegalArgumentException::class.java) { block() }
    assertEquals(message, error.message)
  }

  @Test
  fun sendToAutodepositContactIsSent() {
    val result = tools.executeSendTransfer(CHEQUING, ALICE, 50.0, EMAIL)

    assertEquals(TransferStatus.SENT, result.status)
    assertEquals("alice.m@example.com", result.destination)
    assertEquals("Alice Martin", result.recipient)
    assertEquals("Everyday Chequing", result.fromAccount)
    assertTrue(result.referenceId.matches(Regex("TRF-[A-Z0-9]{8}")))
    Instant.parse(result.timestamp)
    assertEquals(1490.25, balance(CHEQUING), 0.0)
  }

  @Test
  fun sendToNonAutodepositContactWithSecurityIsPending() {
    val result = tools.executeSendTransfer(CHEQUING, BOB, 20.0, PHONE, "Pet?", "Rex")

    assertEquals(TransferStatus.PENDING_SECURITY_ANSWER, result.status)
    assertEquals("+1-416-555-0143", result.destination)
    assertEquals(1520.25, balance(CHEQUING), 0.0)
    assertTrue("Rex" !in result.toString())
  }

  @Test
  fun sendToNonAutodepositContactWithoutSecurityIsRejected() {
    for ((question, answer) in listOf(null to null, "Pet?" to null, " " to "Rex", "Pet?" to "")) {
      assertRejected(SECURITY_REQUIRED) {
        tools.executeSendTransfer(CHEQUING, BOB, 20.0, PHONE, question, answer)
      }
    }
    assertEquals(1540.25, balance(CHEQUING), 0.0)
  }

  @Test
  fun securityDetailsForAutodepositContactAreIgnored() {
    val result = tools.executeSendTransfer(CHEQUING, ALICE, 5.0, EMAIL, "Pet?", "Rex")

    assertEquals(TransferStatus.SENT, result.status)
  }

  @Test
  fun sendAboveBalanceIsRejectedWithTheSharedMessage() {
    val message = "Insufficient balance in Everyday Chequing: available 1540.25, requested 2000.0."
    assertRejected(message) { tools.executeSendTransfer(CHEQUING, ALICE, 2000.0, EMAIL) }
    val everyday = tools.getAccountBalances().single { it.accountId == CHEQUING }
    assertEquals(message, tools.insufficientBalanceMessage(everyday, 2000.0))
  }

  @Test
  fun repeatedSendsDebitUntilBalanceRunsOut() {
    tools.executeSendTransfer(CHEQUING, ALICE, 1500.0, EMAIL)
    assertEquals(40.25, balance(CHEQUING), 0.0)

    val message = "Insufficient balance in Everyday Chequing: available 40.25, requested 1500.0."
    assertRejected(message) { tools.executeSendTransfer(CHEQUING, ALICE, 1500.0, EMAIL) }
  }

  @Test
  fun newInstanceStartsWithSeededBalances() {
    tools.executeSendTransfer(CHEQUING, ALICE, 1500.0, EMAIL)
    assertEquals(SEEDED, MockInteracBankingTools().getAccountBalances().map { it.availableBalance })
  }

  @Test
  fun concurrentSendsNeverOverdraw() {
    val start = CountDownLatch(1)
    val sent = AtomicInteger()
    val workers =
      List(10) {
        thread {
          start.await()
          runCatching { tools.executeSendTransfer(CHEQUING, ALICE, 200.0, EMAIL) }
            .onSuccess { sent.incrementAndGet() }
        }
      }
    start.countDown()
    workers.forEach { it.join() }

    assertEquals(7, sent.get())
    assertEquals(140.25, balance(CHEQUING), 0.0)
  }

  @Test
  fun sendingFullBalanceLeavesZero() {
    tools.executeSendTransfer(CHEQUING, ALICE, 1540.25, EMAIL)

    assertEquals(0.0, balance(CHEQUING), 0.0)
  }

  @Test
  fun missingChannelIsRejectedAndLeavesBalancesUnchanged() {
    val message = "Alice Martin has no phone number for PHONE delivery."
    assertRejected(message) { tools.executeSendTransfer(CHEQUING, ALICE, 5.0, PHONE) }
    assertRejected(message) { tools.executeRequestMoney(ALICE, SAVINGS, 5.0, PHONE) }
    assertRejected("Bob Vance has no email for EMAIL delivery.") {
      tools.executeSendTransfer(CHEQUING, BOB, 5.0, EMAIL, "Pet?", "Rex")
    }
    assertEquals(SEEDED, balances())
  }

  @Test
  fun nonPositiveAmountIsRejected() {
    for (amount in listOf(0.0, -5.0)) {
      assertRejected("Amount must be greater than 0.") {
        tools.executeSendTransfer(CHEQUING, ALICE, amount, EMAIL)
      }
      assertRejected("Amount must be greater than 0.") {
        tools.executeRequestMoney(ALICE, SAVINGS, amount, EMAIL)
      }
    }
  }

  @Test
  fun unknownIdsAreRejected() {
    assertRejected("Account acc_x not found.") {
      tools.executeSendTransfer("acc_x", ALICE, 5.0, EMAIL)
    }
    assertRejected("Contact ct_x not found.") {
      tools.executeSendTransfer(CHEQUING, Recipient.Saved("ct_x"), 5.0, EMAIL)
    }
    assertRejected("Account acc_x not found.") {
      tools.executeRequestMoney(ALICE, "acc_x", 5.0, EMAIL)
    }
    assertRejected("Contact ct_x not found.") {
      tools.executeRequestMoney(Recipient.Saved("ct_x"), SAVINGS, 5.0, EMAIL)
    }
  }

  @Test
  fun creditCardCannotSendOrReceiveRequests() {
    assertRejected("Rewards Visa is a credit card and can't be used to send money.") {
      tools.executeSendTransfer(VISA, ALICE, 50.0, EMAIL)
    }
    assertRejected("Rewards Visa is a credit card and can't receive a money request.") {
      tools.executeRequestMoney(ALICE, VISA, 50.0, EMAIL)
    }
    assertEquals(SEEDED, balances())
  }

  @Test
  fun balancesListFourSeededAccounts() {
    val accounts = tools.getAccountBalances()

    assertEquals(listOf(CHEQUING, SAVINGS, "acc_chk_303", VISA), accounts.map { it.accountId })
    assertEquals(
      listOf("Everyday Chequing", "High-Interest Savings", "Joint Chequing", "Rewards Visa"),
      accounts.map { it.name },
    )
    assertEquals(
      listOf(AccountType.CHEQUING, AccountType.SAVINGS, AccountType.CHEQUING, AccountType.CREDIT),
      accounts.map { it.type },
    )
    assertEquals(
      listOf("**** 4821", "**** 8830", "**** 1177", "**** 3092"),
      accounts.map { it.accountNumberMask },
    )
    assertEquals(SEEDED, balances())
    assertTrue(accounts.all { it.currency == "CAD" })
  }

  @Test
  fun findContactsRanksNameEmailOrPhone() {
    fun ids(query: String?) = tools.findContacts(query).map { it.contactId }

    val all = listOf("ct_alice", "ct_bob", "ct_charlie", "ct_jane", "ct_alicia", "ct_robert")
    assertEquals(all, ids(null))
    assertEquals(all, ids(""))
    assertEquals(listOf("ct_charlie"), ids("char"))
    assertEquals(listOf("ct_charlie"), ids("EXAMPLE.CA"))
    assertEquals(listOf("ct_bob"), ids("416-555"))
    assertEquals(listOf("ct_alice", "ct_alicia"), ids("Ali"))
    assertEquals(listOf("ct_charlie"), ids("Charly"))
    assertEquals(emptyList<String>(), ids("zzz"))
  }

  @Test
  fun manualRecipientSendsPendingAndNeedsSecurity() {
    val manual = Recipient.Manual("sam@example.com", null)
    assertRejected(SECURITY_REQUIRED) { tools.executeSendTransfer(CHEQUING, manual, 10.0, EMAIL) }
    val result = tools.executeSendTransfer(CHEQUING, manual, 10.0, EMAIL, "Pet?", "Rex")

    assertEquals(TransferStatus.PENDING_SECURITY_ANSWER, result.status)
    assertEquals("sam@example.com", result.destination)
    assertEquals("sam@example.com", result.recipient)
    assertEquals(1530.25, balance(CHEQUING), 0.0)
    assertRejected("Enter an email or a phone number for the recipient.") {
      tools.executeSendTransfer(CHEQUING, Recipient.Manual(null, " "), 10.0, EMAIL, "Q", "A")
    }
  }

  @Test
  fun savedContactAppearsInSearchWithoutAutodeposit() {
    val saved = tools.saveContact("Sam Lee", "sam@example.com", null)

    assertTrue(saved.contactId.matches(Regex("ct_[A-Z0-9]{8}")))
    assertFalse(saved.autodepositEnabled)
    assertEquals(listOf(saved), tools.findContacts("sam"))
    assertRejected("Enter a name for the contact.") { tools.saveContact(" ", "x@y.z", null) }
    assertRejected("Enter an email or a phone number for the recipient.") {
      tools.saveContact("Sam", null, null)
    }
    assertEquals(saved.contactId, tools.findContacts().last().contactId)
  }

  @Test
  fun requestMoneyKeepsMemoAndLeavesBalancesUnchanged() {
    val result = tools.executeRequestMoney(ALICE, SAVINGS, 30.0, EMAIL, "dinner")

    assertEquals(MoneyRequestStatus.REQUEST_SENT, result.status)
    assertTrue(result.referenceId.matches(Regex("REQ-[A-Z0-9]{8}")))
    assertEquals("alice.m@example.com", result.destination)
    assertEquals("High-Interest Savings", result.depositAccount)
    assertEquals("dinner", result.memo)
    assertEquals(SEEDED, balances())
  }

  @Test
  fun onlyReadToolsAreExposedToTheModel() = runTest {
    val names = tools.asTools().map { it.name }.toSet()
    assertEquals(setOf("getAccountBalances", "findContacts"), names)

    val tool = tools.getTool("findContacts")
    val args = tool.decodeArgs(JSONObject(emptyMap()), KotlinxSerializer())
    @Suppress("UNCHECKED_CAST") val result = tool.execute(args) as List<InteracContact>

    assertEquals(6, result.size)
  }
}
