package com.jayvijay.scottie.feature.interacbanking.data.ai.tools

import ai.koog.serialization.JSONObject
import ai.koog.serialization.JSONPrimitive
import ai.koog.serialization.kotlinx.KotlinxSerializer
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel.EMAIL
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel.PHONE
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestStatus
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferStatus
import java.time.Instant
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

private const val CHEQUING = "acc_chk_101"
private const val SAVINGS = "acc_sav_202"
private const val ALICE = "ct_alice"
private const val BOB = "ct_bob"
private const val SECURITY_REQUIRED =
  "Recipient does not have Autodeposit enabled. A security question and answer are required."

class MockInteracBankingToolsTest {
  private val tools = MockInteracBankingTools()

  private fun balance(id: String) =
    tools.getAccountBalances().single { it.accountId == id }.availableBalance

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
  fun sendAboveBalanceIsRejected() {
    val message = "Insufficient balance in Everyday Chequing: available 1540.25, requested 2000.0."
    assertRejected(message) {
      tools.executeSendTransfer(CHEQUING, ALICE, 2000.0, EMAIL)
    }
  }

  @Test
  fun repeatedSendsDebitUntilBalanceRunsOut() {
    tools.executeSendTransfer(CHEQUING, ALICE, 1500.0, EMAIL)
    assertEquals(40.25, balance(CHEQUING), 0.0)

    val message = "Insufficient balance in Everyday Chequing: available 40.25, requested 1500.0."
    assertRejected(message) {
      tools.executeSendTransfer(CHEQUING, ALICE, 1500.0, EMAIL)
    }
  }

  @Test
  fun newInstanceStartsWithSeededBalances() {
    tools.executeSendTransfer(CHEQUING, ALICE, 1500.0, EMAIL)
    val fresh = MockInteracBankingTools()

    assertEquals(
      listOf(1540.25, 6200.00),
      fresh.getAccountBalances().map { it.availableBalance },
    )
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
  fun missingChannelIsRejected() {
    val message = "Alice Martin has no phone number for PHONE delivery."
    assertRejected(message) { tools.executeSendTransfer(CHEQUING, ALICE, 5.0, PHONE) }
    assertRejected(message) { tools.executeRequestMoney(ALICE, SAVINGS, 5.0, PHONE) }
    assertRejected("Bob Vance has no email for EMAIL delivery.") {
      tools.executeSendTransfer(CHEQUING, BOB, 5.0, EMAIL, "Pet?", "Rex")
    }
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
      tools.executeSendTransfer(CHEQUING, "ct_x", 5.0, EMAIL)
    }
    assertRejected("Account acc_x not found.") {
      tools.executeRequestMoney(ALICE, "acc_x", 5.0, EMAIL)
    }
    assertRejected("Contact ct_x not found.") {
      tools.executeRequestMoney("ct_x", SAVINGS, 5.0, EMAIL)
    }
  }

  @Test
  fun balancesListBothAccounts() {
    val accounts = tools.getAccountBalances()

    assertEquals(listOf(CHEQUING, SAVINGS), accounts.map { it.accountId })
    assertEquals(listOf("Everyday Chequing", "High-Interest Savings"), accounts.map { it.name })
    assertEquals(listOf(AccountType.CHEQUING, AccountType.SAVINGS), accounts.map { it.type })
    assertEquals(listOf("**** 4821", "**** 8830"), accounts.map { it.accountNumberMask })
    assertTrue(accounts.all { it.currency == "CAD" })
  }

  @Test
  fun findContactsMatchesNameEmailOrPhone() {
    fun ids(query: String?) = tools.findContacts(query).map { it.contactId }

    assertEquals(listOf("ct_charlie"), ids("char"))
    assertEquals(listOf("ct_charlie"), ids("EXAMPLE.CA"))
    assertEquals(listOf(BOB), ids("416-555"))
    assertEquals(listOf(ALICE, BOB, "ct_charlie"), ids(null))
    assertEquals(listOf(ALICE, BOB, "ct_charlie"), ids(""))
    assertEquals(emptyList<String>(), ids("zzz"))
  }

  @Test
  fun requestMoneyLeavesBalancesUnchanged() {
    val result = tools.executeRequestMoney(ALICE, SAVINGS, 30.0, EMAIL)

    assertEquals(MoneyRequestStatus.REQUEST_SENT, result.status)
    assertTrue(result.referenceId.matches(Regex("REQ-[A-Z0-9]{8}")))
    assertEquals("alice.m@example.com", result.destination)
    assertEquals("High-Interest Savings", result.depositAccount)
    assertEquals(listOf(1540.25, 6200.00), tools.getAccountBalances().map { it.availableBalance })
  }

  @Test
  fun koogToolSetAppliesDefaultsForOmittedKeys() = runTest {
    assertEquals(
      setOf("getAccountBalances", "findContacts", "executeSendTransfer", "executeRequestMoney"),
      tools.asTools().map { it.name }.toSet(),
    )

    val tool = tools.getTool("executeSendTransfer")
    val args =
      tool.decodeArgs(
        JSONObject(
          mapOf(
            "fromAccountId" to JSONPrimitive(CHEQUING),
            "recipientId" to JSONPrimitive(ALICE),
            "amount" to JSONPrimitive(50.0),
            "deliveryChannel" to JSONPrimitive("EMAIL"),
          )
        ),
        KotlinxSerializer(),
      )
    val result = tool.execute(args) as TransferResult

    assertEquals(TransferStatus.SENT, result.status)
  }
}
