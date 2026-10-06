package com.jayvijay.scottie.feature.interacbanking.data.ai.tools

import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool
import ai.koog.agents.core.tools.reflect.ToolSet
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestStatus
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferStatus
import java.math.BigDecimal
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

private const val PENDING_NULL_HINT =
  "Required when the recipient's autodepositEnabled is false; pass null when it is true."

/** In-memory mock; balances reset when the process restarts. */
@Singleton
@LLMDescription(
  "Interac e-Transfer tools for the signed-in user's mock CAD accounts and saved contacts."
)
class MockInteracBankingTools @Inject constructor() : InteracBankingTools, ToolSet {
  private val accounts =
    listOf(
      Account("acc_chk_101", "Everyday Chequing", AccountType.CHEQUING, "**** 4821", 1540.25),
      Account("acc_sav_202", "High-Interest Savings", AccountType.SAVINGS, "**** 8830", 6200.00),
    )

  private val contacts =
    listOf(
      InteracContact("ct_alice", "Alice Martin", "alice.m@example.com", null, true),
      InteracContact("ct_bob", "Bob Vance", null, "+1-416-555-0143", false),
      InteracContact(
        "ct_charlie",
        "Charlie Chen",
        "charlie.c@example.ca",
        "+1-647-555-0199",
        false,
      ),
    )

  private val balances: MutableMap<String, Double> =
    accounts.associate { it.accountId to it.availableBalance }.toMutableMap()

  @Tool
  @LLMDescription(
    "Lists the user's accounts with current balances and types. Use it to resolve phrases such " +
      "as \"from my chequing\" to an accountId and to check that a transfer amount fits."
  )
  @Synchronized
  override fun getAccountBalances(): List<Account> = accounts.map {
    it.copy(availableBalance = balances.getValue(it.accountId))
  }

  @Tool
  @LLMDescription(
    "Finds saved Interac contacts, including their email, phone number, and autodepositEnabled."
  )
  override fun findContacts(
    @LLMDescription(
      "Case-insensitive part of a name, email, or phone number; pass null for all contacts."
    )
    query: String?
  ): List<InteracContact> =
    if (query.isNullOrBlank()) {
      contacts
    } else {
      contacts.filter { contact ->
        listOfNotNull(contact.name, contact.email, contact.phoneNumber).any {
          it.contains(query, ignoreCase = true)
        }
      }
    }

  @Tool
  @LLMDescription(
    "Sends an Interac e-Transfer and debits the source account. If the recipient's " +
      "autodepositEnabled is false, a security question and answer are required."
  )
  @Synchronized
  override fun executeSendTransfer(
    @LLMDescription("accountId from getAccountBalances to send from.") fromAccountId: String,
    @LLMDescription("contactId from findContacts.") recipientId: String,
    @LLMDescription("Amount in CAD; greater than 0 and at most the available balance.")
    amount: Double,
    @LLMDescription("EMAIL or PHONE; the contact must have that channel.")
    deliveryChannel: DeliveryChannel,
    @LLMDescription("Security question. $PENDING_NULL_HINT") securityQuestion: String?,
    @LLMDescription("Security answer. $PENDING_NULL_HINT") securityAnswer: String?,
  ): TransferResult {
    requirePositive(amount)
    val account = requireAccount(fromAccountId)
    val balance = balances.getValue(account.accountId)
    require(amount <= balance) {
      "Insufficient balance in ${account.name}: available $balance, requested $amount."
    }
    val contact = requireContact(recipientId)
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
      referenceId = newReference("TRF-"),
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

  @Tool
  @LLMDescription(
    "Requests money from a contact into one of the user's accounts. Balances do not change."
  )
  override fun executeRequestMoney(
    @LLMDescription("contactId from findContacts to request from.") fromContactId: String,
    @LLMDescription("accountId from getAccountBalances to deposit into.") depositAccountId: String,
    @LLMDescription("Amount in CAD; greater than 0.") amount: Double,
    @LLMDescription("EMAIL or PHONE; the contact must have that channel.")
    deliveryChannel: DeliveryChannel,
    @LLMDescription("Optional note for the contact; pass null if none.") memo: String?,
  ): MoneyRequestResult {
    requirePositive(amount)
    val account = requireAccount(depositAccountId)
    val contact = requireContact(fromContactId)
    return MoneyRequestResult(
      referenceId = newReference("REQ-"),
      status = MoneyRequestStatus.REQUEST_SENT,
      amount = amount,
      requestee = contact.name,
      deliveryChannel = deliveryChannel,
      destination = destinationFor(contact, deliveryChannel),
      depositAccount = account.name,
      timestamp = now(),
    )
  }

  private fun requirePositive(amount: Double) =
    require(amount > 0) { "Amount must be greater than 0." }

  private fun requireAccount(id: String): Account =
    requireNotNull(accounts.find { it.accountId == id }) { "Account $id not found." }

  private fun requireContact(id: String): InteracContact =
    requireNotNull(contacts.find { it.contactId == id }) { "Contact $id not found." }

  private fun destinationFor(contact: InteracContact, channel: DeliveryChannel): String {
    val (destination, label) =
      when (channel) {
        DeliveryChannel.EMAIL -> contact.email to "email"
        DeliveryChannel.PHONE -> contact.phoneNumber to "phone number"
      }
    return requireNotNull(destination) { "${contact.name} has no $label for $channel delivery." }
  }

  private fun newReference(prefix: String): String =
    prefix + (1..REFERENCE_LENGTH).map { REFERENCE_CHARS.random(Random.Default) }.joinToString("")

  private fun now(): String = Instant.now().toString()

  private companion object {
    const val REFERENCE_LENGTH = 8
    const val REFERENCE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  }
}
