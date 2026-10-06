package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.Serializable

/** The only structure the model returns; everything else is resolved by the presenter. */
@Serializable
data class AssistantIntent(
  @property:LLMDescription("BALANCE, SEND, REQUEST, or OTHER.") val intent: Intent,
  @property:LLMDescription("Amount in CAD exactly as the user typed it; null when not given.")
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
) {
  enum class Intent {
    BALANCE,
    SEND,
    REQUEST,
    OTHER,
  }

  enum class ChannelHint {
    EMAIL,
    SMS,
  }

  companion object {
    val FALLBACK = AssistantIntent(Intent.OTHER)
  }
}
