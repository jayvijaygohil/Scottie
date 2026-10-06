package com.jayvijay.scottie.feature.interacbanking.data.ai.tools

import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool
import ai.koog.agents.core.tools.reflect.ToolSet
import android.util.Log
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestStatus
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Recipient
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferStatus
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.ContactMatcher
import java.math.BigDecimal
import java.time.Instant
import java.util.Collections
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

/** In-memory mock; balances and saved contacts reset when the process restarts. */
@Suppress("TooManyFunctions") // One service contract plus its private guards.
@Singleton
@LLMDescription(
  "Interac e-Transfer tools for the signed-in user's mock CAD accounts and saved contacts."
)
class MockInteracBankingTools @Inject constructor() : InteracBankingTools, ToolSet {
  private val accounts =
    listOf(
      Account("acc_chk_101", "Everyday Chequing", AccountType.CHEQUING, "**** 4821", 1540.25),
      Account("acc_sav_202", "High-Interest Savings", AccountType.SAVINGS, "**** 8830", 6200.00),
      Account("acc_chk_303", "Joint Chequing", AccountType.CHEQUING, "**** 1177", 85.40),
      Account("acc_cc_404", "Rewards Visa", AccountType.CREDIT, "**** 3092", 2500.00),
    )

  private val contacts: MutableList<InteracContact> =
    Collections.synchronizedList(
      mutableListOf(
        InteracContact("ct_alice", "Alice Martin", "alice.m@example.com", null, true),
        InteracContact("ct_bob", "Bob Vance", null, "+1-416-555-0143", false),
        InteracContact(
          "ct_charlie",
          "Charlie Chen",
          "charlie.c@example.ca",
          "+1-647-555-0199",
          false,
        ),
        InteracContact("ct_jane", "Jane Doe", "jane.doe@example.com", "+1-905-555-0122", true),
        InteracContact("ct_alicia", "Alicia Moreno", "alicia.moreno@example.com", null, false),
        InteracContact("ct_robert", "Robert Singh", null, "+1-289-555-0177", true),
      )
    )

  private val balances: MutableMap<String, Double> =
    accounts.associate { it.accountId to it.availableBalance }.toMutableMap()

  @Tool
  @LLMDescription(
    "Lists the user's accounts with current balances and types. Use it to check whether an " +
      "account phrase such as \"my chequing\" exists."
  )
  @Synchronized
  override fun getAccountBalances(): List<Account> = accounts.map {
    it.copy(availableBalance = balances.getValue(it.accountId))
  }

  @Tool
  @LLMDescription(
    "Finds saved Interac contacts by name, email, or phone, ranked by relevance; includes " +
      "autodepositEnabled."
  )
  override fun findContacts(
    @LLMDescription("Part of a name, email, or phone number; pass null for all contacts.")
    query: String?
  ): List<InteracContact> {
    Log.d(TAG, "tool=findContacts q=$query")
    val snapshot = synchronized(contacts) { contacts.toList() }
    return if (query.isNullOrBlank()) snapshot else ContactMatcher.rankContacts(query, snapshot)
  }

  override fun saveContact(name: String, email: String?, phoneNumber: String?): InteracContact {
    require(name.isNotBlank()) { "Enter a name for the contact." }
    val contact =
      InteracContact(
        contactId = "ct_" + randomId(),
        name = name.trim(),
        email = email?.takeIf { it.isNotBlank() },
        phoneNumber = phoneNumber?.takeIf { it.isNotBlank() },
        autodepositEnabled = false,
      )
    requireDestination(contact)
    contacts += contact
    return contact
  }

  override fun insufficientBalanceMessage(account: Account, amount: Double): String =
    "Insufficient balance in ${account.name}: available ${account.availableBalance}, " +
      "requested $amount."

  @Synchronized
  override fun executeSendTransfer(
    fromAccountId: String,
    recipient: Recipient,
    amount: Double,
    deliveryChannel: DeliveryChannel,
    securityQuestion: String?,
    securityAnswer: String?,
  ): TransferResult {
    requirePositive(amount)
    val account = requireAccount(fromAccountId)
    val balance = balances.getValue(account.accountId)
    require(amount <= balance) {
      insufficientBalanceMessage(account.copy(availableBalance = balance), amount)
    }
    require(account.type != AccountType.CREDIT) {
      "${account.name} is a credit card and can't be used to send money."
    }
    val contact = resolve(recipient)
    val destination = destinationFor(contact, deliveryChannel)
    require(
      contact.autodepositEnabled ||
        (!securityQuestion.isNullOrBlank() && !securityAnswer.isNullOrBlank())
    ) {
      "Recipient does not have Autodeposit enabled. A security question and answer are required."
    }
    balances[account.accountId] =
      (BigDecimal(balance.toString()) - BigDecimal(amount.toString())).toDouble()
    return TransferResult(
      referenceId = "TRF-" + randomId(),
      status =
        if (contact.autodepositEnabled) TransferStatus.SENT
        else TransferStatus.PENDING_SECURITY_ANSWER,
      amount = amount,
      recipient = contact.name,
      deliveryChannel = deliveryChannel,
      destination = destination,
      fromAccount = account.name,
      timestamp = now(),
    )
  }

  override fun executeRequestMoney(
    recipient: Recipient,
    depositAccountId: String,
    amount: Double,
    deliveryChannel: DeliveryChannel,
    memo: String?,
  ): MoneyRequestResult {
    requirePositive(amount)
    val account = requireAccount(depositAccountId)
    val contact = resolve(recipient)
    require(account.type != AccountType.CREDIT) {
      "${account.name} is a credit card and can't receive a money request."
    }
    return MoneyRequestResult(
      referenceId = "REQ-" + randomId(),
      status = MoneyRequestStatus.REQUEST_SENT,
      amount = amount,
      requestee = contact.name,
      deliveryChannel = deliveryChannel,
      destination = destinationFor(contact, deliveryChannel),
      depositAccount = account.name,
      timestamp = now(),
      memo = memo,
    )
  }

  private fun resolve(recipient: Recipient): InteracContact =
    when (recipient) {
      is Recipient.Saved ->
        requireNotNull(findContacts().find { it.contactId == recipient.contactId }) {
          "Contact ${recipient.contactId} not found."
        }
      is Recipient.Manual -> {
        val email = recipient.email?.takeIf { it.isNotBlank() }
        val phone = recipient.phoneNumber?.takeIf { it.isNotBlank() }
        InteracContact("manual", email ?: phone.orEmpty(), email, phone, false)
          .also(::requireDestination)
      }
    }

  private fun requireDestination(contact: InteracContact) =
    require(contact.email != null || contact.phoneNumber != null) {
      "Enter an email or a phone number for the recipient."
    }

  private fun requirePositive(amount: Double) =
    require(amount > 0) { "Amount must be greater than 0." }

  private fun requireAccount(id: String): Account =
    requireNotNull(accounts.find { it.accountId == id }) { "Account $id not found." }

  private fun destinationFor(contact: InteracContact, channel: DeliveryChannel): String {
    val (destination, label) =
      when (channel) {
        DeliveryChannel.EMAIL -> contact.email to "email"
        DeliveryChannel.PHONE -> contact.phoneNumber to "phone number"
      }
    return requireNotNull(destination) { "${contact.name} has no $label for $channel delivery." }
  }

  private fun randomId(): String =
    (1..ID_LENGTH).map { ID_CHARS.random(Random.Default) }.joinToString("")

  private fun now(): String = Instant.now().toString()

  private companion object {
    const val TAG = "InteracBanking"
    const val ID_LENGTH = 8
    const val ID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  }
}
