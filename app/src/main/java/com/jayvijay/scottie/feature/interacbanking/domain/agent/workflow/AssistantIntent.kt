package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.Serializable

/** The only structure the model returns; everything else is resolved by the presenter. */
@Serializable
data class AssistantIntent(
  @property:LLMDescription("BALANCE, SEND, REQUEST, TRANSACTIONS, or OTHER.") val intent: Intent,
  @property:LLMDescription(
    "Transfer amount in CAD for SEND/REQUEST, or minimum amount threshold for TRANSACTIONS."
  )
  val amount: Double? = null,
  @property:LLMDescription("Raw recipient fragment: a name, email, or phone. Never an id.")
  val recipientQuery: String? = null,
  @property:LLMDescription(
    "Raw account phrase from the user, e.g. 'savings', 'Everyday Chequing', 'ending 4821', 'TFSA'."
  )
  val accountHint: String? = null,
  @property:LLMDescription("Request memo, e.g. 'dinner'.") val memo: String? = null,
  @property:LLMDescription("Only when the user explicitly named the channel: EMAIL or SMS.")
  val channelHint: ChannelHint? = null,
  @property:LLMDescription("One short sentence for the user. Required when intent is OTHER.")
  val reply: String? = null,
  @property:LLMDescription("Transaction query workflow when intent is TRANSACTIONS.")
  val scenario: TransactionScenario? = null,
  @property:LLMDescription(
    "ISO start date YYYY-MM-DD or relative token (today, this_week, this_month, last_month, " +
      "last_7_days, last_30_days)."
  )
  val startDate: String? = null,
  @property:LLMDescription("ISO end date YYYY-MM-DD.") val endDate: String? = null,
  @property:LLMDescription(
    "Merchant, category, or keyword filter (e.g. 'Uber', 'groceries', 'hydro', 'refund')."
  )
  val searchQuery: String? = null,
) {
  @Serializable
  enum class Intent {
    BALANCE,
    SEND,
    REQUEST,
    TRANSACTIONS,
    OTHER,
  }

  @Serializable
  enum class ChannelHint {
    EMAIL,
    SMS,
  }

  @Serializable
  enum class TransactionScenario {
    DATE_RANGE,
    SALARY_CHECK,
    RENT_CHECK,
    SUBSCRIPTIONS_BILLS,
    MERCHANT_CATEGORY,
    ANOMALIES,
    REFUNDS_TRANSFERS,
  }

  companion object {
    val FALLBACK = AssistantIntent(Intent.OTHER)
  }
}

