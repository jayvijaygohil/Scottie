package com.jayvijay.scottie.feature.interacbanking.domain.entities

import kotlinx.serialization.Serializable

@Serializable
enum class AccountType {
  CHEQUING,
  SAVINGS,
  CREDIT,
  LINE_OF_CREDIT,
}

@Serializable
enum class DeliveryChannel {
  EMAIL,
  PHONE,
}

@Serializable
data class Account(
  val accountId: String,
  val name: String,
  val type: AccountType,
  val accountNumberMask: String,
  val availableBalance: Double,
  val currency: String = "CAD",
)

@Serializable
data class InteracContact(
  val contactId: String,
  val name: String,
  val email: String?,
  val phoneNumber: String?,
  val autodepositEnabled: Boolean,
) {
  val hasMultipleChannels: Boolean
    get() = email != null && phoneNumber != null
}

@Serializable
enum class TransferStatus {
  SENT,
  PENDING_SECURITY_ANSWER,
}

/** Never carries the security answer (FR-012). */
@Serializable
data class TransferResult(
  val referenceId: String,
  val status: TransferStatus,
  val amount: Double,
  val recipient: String,
  val deliveryChannel: DeliveryChannel,
  val destination: String,
  val fromAccount: String,
  val timestamp: String,
)

@Serializable
enum class MoneyRequestStatus {
  REQUEST_SENT
}

@Serializable
data class MoneyRequestResult(
  val referenceId: String,
  val status: MoneyRequestStatus,
  val amount: Double,
  val requestee: String,
  val deliveryChannel: DeliveryChannel,
  val destination: String,
  val depositAccount: String,
  val timestamp: String,
)
