package com.jayvijay.scottie.feature.interacbanking.domain.agent.tools

import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.entities.MoneyRequestResult
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferResult

/** Interac e-Transfer actions available to agents. Failures throw [IllegalArgumentException]. */
interface InteracBankingTools {
  fun getAccountBalances(): List<Account>

  fun findContacts(query: String? = null): List<InteracContact>

  fun executeSendTransfer(
    fromAccountId: String,
    recipientId: String,
    amount: Double,
    deliveryChannel: DeliveryChannel,
    securityQuestion: String? = null,
    securityAnswer: String? = null,
  ): TransferResult

  fun executeRequestMoney(
    fromContactId: String,
    depositAccountId: String,
    amount: Double,
    deliveryChannel: DeliveryChannel,
    memo: String? = null,
  ): MoneyRequestResult
}
