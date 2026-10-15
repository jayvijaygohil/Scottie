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
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Transaction
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionCategory
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionDirection
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferStatus
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.ContactMatcher
import java.math.BigDecimal
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.YearMonth
import java.util.Collections
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

/** In-memory mock; balances, transactions, and saved contacts reset when the process restarts. */
@Suppress("TooManyFunctions") // One service contract plus its private guards.
@Singleton
@LLMDescription(
  "Interac e-Transfer tools for the signed-in user's mock CAD accounts, contacts, and transactions."
)
class MockInteracBankingTools(private val clock: Clock = Clock.systemDefaultZone()) :
  InteracBankingTools, ToolSet {

  @Inject constructor() : this(Clock.systemDefaultZone())

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

  private val transactions: MutableList<Transaction> =
    Collections.synchronizedList(seedTransactions().toMutableList())

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
    "Lists the user's posted transactions across all accounts in reverse chronological order."
  )
  override fun getTransactions(): List<Transaction> =
    synchronized(transactions) {
      transactions.sortedWith(
        compareByDescending<Transaction> { it.date }.thenByDescending { it.transactionId }
      )
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
    val referenceId = "TRF-" + randomId()
    transactions.add(
      0,
      Transaction(
        transactionId = referenceId,
        accountId = account.accountId,
        accountName = account.name,
        date = LocalDate.now(clock).toString(),
        descriptor = "INTERAC E-TRF TO ${contact.name.uppercase()}",
        merchant = contact.name,
        category = TransactionCategory.TRANSFER,
        direction = TransactionDirection.DEBIT,
        amount = amount,
      ),
    )
    return TransferResult(
      referenceId = referenceId,
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

  @Suppress("LongMethod", "MagicNumber")
  private fun seedTransactions(): List<Transaction> {
    val today = LocalDate.now(clock)
    val m0 = YearMonth.from(today)
    val m1 = m0.minusMonths(1)
    val m2 = m0.minusMonths(2)

    fun day(ym: YearMonth, d: Int): String {
      val date = ym.atDay(d.coerceAtMost(ym.lengthOfMonth()))
      return (if (ym == m0 && date.isAfter(today)) today else date).toString()
    }

    fun txn(
      id: String,
      accId: String,
      date: String,
      descriptor: String,
      merchant: String,
      category: TransactionCategory,
      direction: TransactionDirection,
      amount: Double,
    ): Transaction {
      val accName = accounts.first { it.accountId == accId }.name
      return Transaction(id, accId, accName, date, descriptor, merchant, category, direction, amount)
    }

    return listOf(
      // Salary inflows (Everyday Chequing)
      txn(
        "txn_101",
        "acc_chk_101",
        day(m2, 1),
        "ADP PAYROLL - ACME CORP",
        "Acme Corp Payroll",
        TransactionCategory.INCOME,
        TransactionDirection.CREDIT,
        3250.00,
      ),
      txn(
        "txn_102",
        "acc_chk_101",
        day(m2, 15),
        "DIRECT DEP ACME CORP",
        "Acme Corp Payroll",
        TransactionCategory.INCOME,
        TransactionDirection.CREDIT,
        3250.00,
      ),
      txn(
        "txn_103",
        "acc_chk_101",
        day(m1, 1),
        "ADP PAYROLL - ACME CORP",
        "Acme Corp Payroll",
        TransactionCategory.INCOME,
        TransactionDirection.CREDIT,
        3265.00,
      ),
      txn(
        "txn_104",
        "acc_chk_101",
        day(m1, 15),
        "CANADA PAYROLL ACME",
        "Acme Corp Payroll",
        TransactionCategory.INCOME,
        TransactionDirection.CREDIT,
        3265.00,
      ),
      txn(
        "txn_105",
        "acc_chk_101",
        day(m0, 1),
        "ADP PAYROLL - ACME CORP",
        "Acme Corp Payroll",
        TransactionCategory.INCOME,
        TransactionDirection.CREDIT,
        3280.00,
      ),
      // Rent outflows (Everyday Chequing)
      txn(
        "txn_201",
        "acc_chk_101",
        day(m2, 1),
        "MAPLE PROPERTY MGMT RENT",
        "Maple Property Mgmt",
        TransactionCategory.HOUSING,
        TransactionDirection.DEBIT,
        2100.00,
      ),
      txn(
        "txn_202",
        "acc_chk_101",
        day(m1, 1),
        "E-TRANSFER RENT LANDLORD",
        "Maple Property Mgmt",
        TransactionCategory.HOUSING,
        TransactionDirection.DEBIT,
        2100.00,
      ),
      txn(
        "txn_203",
        "acc_chk_101",
        day(m0, 1),
        "MAPLE PROPERTY MGMT RENT",
        "Maple Property Mgmt",
        TransactionCategory.HOUSING,
        TransactionDirection.DEBIT,
        2100.00,
      ),
      // Recurring Subscriptions & Utilities
      txn(
        "txn_301",
        "acc_cc_404",
        day(m2, 5),
        "STREAMFLIX.COM",
        "StreamFlix",
        TransactionCategory.SUBSCRIPTIONS,
        TransactionDirection.DEBIT,
        18.99,
      ),
      txn(
        "txn_302",
        "acc_cc_404",
        day(m1, 5),
        "STREAMFLIX.COM",
        "StreamFlix",
        TransactionCategory.SUBSCRIPTIONS,
        TransactionDirection.DEBIT,
        18.99,
      ),
      txn(
        "txn_303",
        "acc_cc_404",
        day(m0, 5),
        "STREAMFLIX.COM",
        "StreamFlix",
        TransactionCategory.SUBSCRIPTIONS,
        TransactionDirection.DEBIT,
        18.99,
      ),
      txn(
        "txn_304",
        "acc_cc_404",
        day(m1, 8),
        "CLOUDMUSIC SUBSCRIPTION",
        "CloudMusic",
        TransactionCategory.SUBSCRIPTIONS,
        TransactionDirection.DEBIT,
        11.99,
      ),
      txn(
        "txn_305",
        "acc_cc_404",
        day(m0, 8),
        "CLOUDMUSIC SUBSCRIPTION",
        "CloudMusic",
        TransactionCategory.SUBSCRIPTIONS,
        TransactionDirection.DEBIT,
        11.99,
      ),
      txn(
        "txn_306",
        "acc_chk_101",
        day(m2, 10),
        "TORONTO HYDRO BILL",
        "Toronto Hydro",
        TransactionCategory.UTILITIES,
        TransactionDirection.DEBIT,
        92.40,
      ),
      txn(
        "txn_307",
        "acc_chk_101",
        day(m1, 10),
        "TORONTO HYDRO BILL",
        "Toronto Hydro",
        TransactionCategory.UTILITIES,
        TransactionDirection.DEBIT,
        95.10,
      ),
      txn(
        "txn_308",
        "acc_chk_101",
        day(m0, 10),
        "TORONTO HYDRO BILL",
        "Toronto Hydro",
        TransactionCategory.UTILITIES,
        TransactionDirection.DEBIT,
        94.20,
      ),
      txn(
        "txn_309",
        "acc_chk_303",
        day(m1, 12),
        "BELL CANADA INTERNET",
        "Bell Internet",
        TransactionCategory.UTILITIES,
        TransactionDirection.DEBIT,
        79.95,
      ),
      txn(
        "txn_310",
        "acc_chk_303",
        day(m0, 12),
        "BELL CANADA INTERNET",
        "Bell Internet",
        TransactionCategory.UTILITIES,
        TransactionDirection.DEBIT,
        79.95,
      ),
      // Groceries, Dining, Transport, Shopping
      txn(
        "txn_401",
        "acc_cc_404",
        day(m1, 14),
        "FRESHCO GROCERIES #104",
        "FreshCo",
        TransactionCategory.GROCERIES,
        TransactionDirection.DEBIT,
        134.20,
      ),
      txn(
        "txn_402",
        "acc_cc_404",
        day(m0, 3),
        "FRESHCO GROCERIES #104",
        "FreshCo",
        TransactionCategory.GROCERIES,
        TransactionDirection.DEBIT,
        118.65,
      ),
      txn(
        "txn_403",
        "acc_cc_404",
        day(m0, 9),
        "METRO MARKET #42",
        "Metro Market",
        TransactionCategory.GROCERIES,
        TransactionDirection.DEBIT,
        86.30,
      ),
      txn(
        "txn_404",
        "acc_cc_404",
        day(m0, 4),
        "TIM HORTONS #0812",
        "Tim Hortons",
        TransactionCategory.DINING,
        TransactionDirection.DEBIT,
        6.45,
      ),
      txn(
        "txn_405",
        "acc_cc_404",
        day(m0, 7),
        "UBER *TRIP TORONTO",
        "Uber",
        TransactionCategory.TRANSPORT,
        TransactionDirection.DEBIT,
        24.80,
      ),
      // Anomalies: Duplicate charge within 48h & Unusually large charge
      txn(
        "txn_501",
        "acc_cc_404",
        day(m0, 6),
        "CITY PARKING LOT 9",
        "City Parking",
        TransactionCategory.TRANSPORT,
        TransactionDirection.DEBIT,
        15.00,
      ),
      txn(
        "txn_502",
        "acc_cc_404",
        day(m0, 7),
        "CITY PARKING LOT 9",
        "City Parking",
        TransactionCategory.TRANSPORT,
        TransactionDirection.DEBIT,
        15.00,
      ),
      txn(
        "txn_503",
        "acc_cc_404",
        day(m0, 11),
        "TECHMART ELECTRONICS",
        "TechMart Electronics",
        TransactionCategory.SHOPPING,
        TransactionDirection.DEBIT,
        899.99,
      ),
      // Refunds & Transfers
      txn(
        "txn_601",
        "acc_cc_404",
        day(m0, 13),
        "TECHMART REFUND",
        "TechMart Electronics",
        TransactionCategory.REFUND,
        TransactionDirection.CREDIT,
        124.50,
      ),
      txn(
        "txn_602",
        "acc_chk_101",
        day(m1, 20),
        "INTERAC E-TRF - ALICE MARTIN",
        "Alice Martin",
        TransactionCategory.TRANSFER,
        TransactionDirection.DEBIT,
        50.00,
      ),
      txn(
        "txn_603",
        "acc_sav_202",
        day(m1, 22),
        "INTERAC E-TRF - BOB VANCE",
        "Bob Vance",
        TransactionCategory.TRANSFER,
        TransactionDirection.CREDIT,
        35.00,
      ),
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

  private fun now(): String = Instant.now(clock).toString()

  private companion object {
    const val TAG = "InteracBanking"
    const val ID_LENGTH = 8
    const val ID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  }
}

