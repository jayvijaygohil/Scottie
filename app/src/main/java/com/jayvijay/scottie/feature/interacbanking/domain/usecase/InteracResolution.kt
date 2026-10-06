package com.jayvijay.scottie.feature.interacbanking.domain.usecase

import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import java.math.BigDecimal

/** Deterministic account/recipient/amount rules (research R7); the model never decides these. */
object InteracResolution {
  private const val MASK_DIGITS = 4
  private const val CLEAR_TOP = ContactMatcher.PREFIX
  private const val CLEAR_GAP = 30
  private val MASK = Regex("(?:ending\\s*)?(\\d{$MASK_DIGITS})")

  /** Null or blank hint → every account; nothing matching → empty. Names win over types. */
  fun matchAccounts(hint: String?, accounts: List<Account>): List<Account> {
    val h = hint?.trim()?.lowercase().orEmpty()
    val byName = accounts.filter { it.name.lowercase().contains(h) }
    val type =
      when {
        "savings" in h -> AccountType.SAVINGS
        "chequing" in h || "checking" in h -> AccountType.CHEQUING
        "visa" in h || "credit" in h || "card" in h -> AccountType.CREDIT
        else -> null
      }
    val digits = MASK.find(h)?.groupValues?.get(1)
    return when {
      h.isEmpty() -> accounts
      byName.isNotEmpty() -> byName
      type != null -> accounts.filter { it.type == type }
      digits != null -> accounts.filter { it.accountNumberMask.endsWith(digits) }
      else -> emptyList()
    }
  }

  /** Non-credit accounts that can cover [amount] (all when null), chequing before savings. */
  fun eligibleSources(accounts: List<Account>, amount: Double?): List<Account> =
    eligibleDeposits(accounts).filter { amount == null || it.availableBalance >= amount }

  fun eligibleDeposits(accounts: List<Account>): List<Account> =
    accounts.filter { it.type != AccountType.CREDIT }.sortedBy { it.type.ordinal }

  /** Positive amount with at most two decimals, else null. */
  fun validateAmount(text: String): Double? =
    text.trim().replace(",", "").toBigDecimalOrNull()?.takeIf {
      it > BigDecimal.ZERO && it.scale() <= 2
    }?.toDouble()

  /** A single candidate, or a top score ≥ 80 with a clear gap to the runner-up. */
  fun clearMatch(ranked: List<Pair<InteracContact, Int>>): InteracContact? {
    val top = ranked.firstOrNull()
    val second = ranked.getOrNull(1)
    return when {
      top == null -> null
      second == null -> top.first
      top.second >= CLEAR_TOP && top.second - second.second >= CLEAR_GAP -> top.first
      else -> null
    }
  }
}
