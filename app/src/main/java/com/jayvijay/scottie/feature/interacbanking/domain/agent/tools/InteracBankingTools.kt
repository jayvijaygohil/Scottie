package com.jayvijay.scottie.feature.interacbanking.domain.agent.tools

import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Recipient
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Transaction
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult

/**
 * Interac e-Transfer banking service. Failures throw [IllegalArgumentException] whose message is
 * the user-facing text. Only [getAccountBalances], [findContacts], and [getTransactions] are model
 * tools; [executeSendTransfer], [executeRequestMoney], and [saveContact] are called by the
 * presenter.
 */
interface InteracBankingTools {
  fun getAccountBalances(): List<Account>

  /** All posted transactions across accounts, newest first. */
  fun getTransactions(): List<Transaction>

  /** Ranked fuzzy search; null or blank returns every contact. */
  fun findContacts(query: String? = null): List<InteracContact>

  /** Saved contacts have Autodeposit off and live until the process restarts. */
  fun saveContact(name: String, email: String?, phoneNumber: String?): InteracContact

  /** The exact text the service uses when [amount] exceeds [account]'s balance. */
  fun insufficientBalanceMessage(account: Account, amount: Double): String

  fun executeSendTransfer(
    fromAccountId: String,
    recipient: Recipient,
    amount: Double,
    deliveryChannel: DeliveryChannel,
    securityQuestion: String? = null,
    securityAnswer: String? = null,
  ): TransferResult

  fun executeRequestMoney(
    recipient: Recipient,
    depositAccountId: String,
    amount: Double,
    deliveryChannel: DeliveryChannel,
    memo: String? = null,
  ): MoneyRequestResult
}
