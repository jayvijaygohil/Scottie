package com.jayvijay.scottie.feature.interacbanking.domain.usecase

import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.TransactionScenario
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Transaction
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionCategory
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionDirection
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters
import kotlin.math.abs

/**
 * Pure deterministic evaluation for transaction queries and financial insight workflows (research
 * R2). No Android or AI-client dependencies.
 */
@Suppress("TooManyFunctions")
object TransactionInsights {
  enum class VerificationStatus {
    NONE,
    CONFIRMED,
    NOT_DETECTED,
  }

  enum class InsightBadge {
    SALARY,
    RENT,
    RECURRING,
    DUPLICATE,
    LARGE_CHARGE,
    REFUND,
    TRANSFER,
  }

  data class FlaggedTransaction(
    val transaction: Transaction,
    val badge: InsightBadge? = null,
    val isReference: Boolean = false,
  )

  data class TransactionQueryResult(
    val scenario: TransactionScenario,
    val status: VerificationStatus,
    val items: List<FlaggedTransaction>,
    val matchCount: Int,
    val totalInflow: Double,
    val totalOutflow: Double,
    val periodLabel: String? = null,
    val queryLabel: String? = null,
    val accountNotFoundHint: String? = null,
  )

  private val PAYROLL_KEYWORDS =
    listOf("payroll", "salary", "direct dep", "paycheque", "paycheck", "employer")
  private val RENT_KEYWORDS =
    listOf("rent", "lease", "property", "landlord", "apartment", "mgmt")
  private val REFUND_TRANSFER_KEYWORDS = listOf("refund", "transfer")
  private val SUBSCRIPTION_BILL_KEYWORDS =
    listOf("subscription", "utility", "utilities", "bill")
  private val ANOMALY_KEYWORDS = listOf("duplicate", "unusual", "anomal")
  private const val MIN_RECURRING_INFLOW = 500.0
  private const val MIN_RECURRING_RENT = 500.0
  private const val MIN_SUBSCRIPTION_DEBIT = 0.01
  private const val SALARY_TOLERANCE = 0.15
  private const val RENT_TOLERANCE = 0.10
  private const val SUBSCRIPTION_TOLERANCE = 0.15
  private const val DUPLICATE_MAX_DAYS = 2L
  private const val LAST_7_DAYS_OFFSET = 6L
  private const val LAST_30_DAYS_OFFSET = 29L
  private const val LARGE_CHARGE_MULTIPLIER = 3.0
  private const val LARGE_CHARGE_FLOOR = 250.0

  fun evaluate(
    intent: AssistantIntent,
    transactions: List<Transaction>,
    accounts: List<Account>,
    today: LocalDate = LocalDate.now(),
  ): TransactionQueryResult {
    val scenario = resolveScenario(intent)
    val hint = intent.accountHint?.trim()?.takeIf { it.isNotEmpty() }
    val matchedAccounts = InteracResolution.matchAccounts(hint, accounts)
    val accountNotFoundHint = if (hint != null && matchedAccounts.isEmpty()) hint else null
    val activeAccountIds =
      if (matchedAccounts.isNotEmpty()) matchedAccounts.map { it.accountId }.toSet()
      else accounts.map { it.accountId }.toSet()

    val accountScoped =
      transactions
        .filter { activeAccountIds.isEmpty() || it.accountId in activeAccountIds }
        .sortedWith(compareByDescending<Transaction> { it.date }.thenByDescending { it.transactionId })

    val explicitRange = parseDateRange(intent.startDate, intent.endDate, today)

    return when (scenario) {
      TransactionScenario.SALARY_CHECK ->
        evaluateSalary(accountScoped, explicitRange, today, accountNotFoundHint)
      TransactionScenario.RENT_CHECK ->
        evaluateRent(accountScoped, explicitRange, today, accountNotFoundHint)
      TransactionScenario.SUBSCRIPTIONS_BILLS ->
        evaluateSubscriptionsAndBills(accountScoped, explicitRange, intent.searchQuery, accountNotFoundHint)
      TransactionScenario.ANOMALIES ->
        evaluateAnomalies(accountScoped, explicitRange, intent.amount, accountNotFoundHint)
      TransactionScenario.REFUNDS_TRANSFERS ->
        evaluateRefundsAndTransfers(
          accountScoped,
          explicitRange,
          intent.searchQuery ?: intent.recipientQuery,
          accountNotFoundHint,
        )
      TransactionScenario.MERCHANT_CATEGORY,
      TransactionScenario.DATE_RANGE ->
        evaluateGeneral(
          scenario,
          accountScoped,
          explicitRange,
          intent.searchQuery,
          intent.amount,
          accountNotFoundHint,
        )
    }
  }

  private fun resolveScenario(intent: AssistantIntent): TransactionScenario {
    intent.scenario?.let { return it }
    val q = intent.searchQuery?.lowercase().orEmpty()
    return when {
      PAYROLL_KEYWORDS.any { it in q } -> TransactionScenario.SALARY_CHECK
      RENT_KEYWORDS.any { it in q } -> TransactionScenario.RENT_CHECK
      REFUND_TRANSFER_KEYWORDS.any { it in q } -> TransactionScenario.REFUNDS_TRANSFERS
      SUBSCRIPTION_BILL_KEYWORDS.any { it in q } -> TransactionScenario.SUBSCRIPTIONS_BILLS
      ANOMALY_KEYWORDS.any { it in q } -> TransactionScenario.ANOMALIES
      q.isNotEmpty() -> TransactionScenario.MERCHANT_CATEGORY
      else -> TransactionScenario.DATE_RANGE
    }
  }

  private fun evaluateGeneral(
    scenario: TransactionScenario,
    scoped: List<Transaction>,
    range: Pair<LocalDate, LocalDate>?,
    searchQuery: String?,
    minAmount: Double?,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val inRange = scoped.filterInRange(range)
    val query = searchQuery?.trim()?.takeIf { it.isNotEmpty() }
    val matched =
      inRange
        .filter { txn ->
          (query == null || matchesQuery(txn, query)) &&
            (minAmount == null || txn.amount >= minAmount)
        }
        .map { FlaggedTransaction(it, defaultBadgeFor(it)) }
    return buildResult(
      scenario = scenario,
      status = VerificationStatus.NONE,
      items = matched,
      range = range,
      queryLabel = query,
      accountNotFoundHint = accountNotFoundHint,
    )
  }

  private fun evaluateSalary(
    scoped: List<Transaction>,
    explicitRange: Pair<LocalDate, LocalDate>?,
    today: LocalDate,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val credits = scoped.filter { it.direction == TransactionDirection.CREDIT }
    val recurringIds = recurringCreditIds(credits)
    val candidates =
      credits.filter { txn ->
        txn.category != TransactionCategory.REFUND &&
          (txn.category == TransactionCategory.INCOME ||
            hasKeyword(txn, PAYROLL_KEYWORDS) ||
            txn.transactionId in recurringIds)
      }
    val targetRange = explicitRange ?: currentMonthRange(today)
    val inPeriod = candidates.filterInRange(targetRange)
    return if (inPeriod.isNotEmpty()) {
      val items = inPeriod.map { FlaggedTransaction(it, InsightBadge.SALARY, isReference = false) }
      buildResult(
        scenario = TransactionScenario.SALARY_CHECK,
        status = VerificationStatus.CONFIRMED,
        items = items,
        range = targetRange,
        queryLabel = null,
        accountNotFoundHint = accountNotFoundHint,
      )
    } else {
      val references =
        candidates.take(MAX_REFERENCES).map {
          FlaggedTransaction(it, InsightBadge.SALARY, isReference = true)
        }
      buildResult(
        scenario = TransactionScenario.SALARY_CHECK,
        status = VerificationStatus.NOT_DETECTED,
        items = references,
        range = targetRange,
        queryLabel = null,
        accountNotFoundHint = accountNotFoundHint,
      )
    }
  }

  private fun evaluateRent(
    scoped: List<Transaction>,
    explicitRange: Pair<LocalDate, LocalDate>?,
    today: LocalDate,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val debits = scoped.filter { it.direction == TransactionDirection.DEBIT }
    val recurringRentIds = recurringMonthlyDebitIds(debits, MIN_RECURRING_RENT, RENT_TOLERANCE)
    val candidates =
      debits.filter { txn ->
        txn.category == TransactionCategory.HOUSING ||
          hasKeyword(txn, RENT_KEYWORDS) ||
          txn.transactionId in recurringRentIds
      }
    val targetRange = explicitRange ?: currentMonthRange(today)
    val inPeriod = candidates.filterInRange(targetRange)
    val prior =
      candidates
        .filter { it !in inPeriod }
        .take(MAX_REFERENCES)
        .map { FlaggedTransaction(it, InsightBadge.RENT, isReference = true) }

    return if (inPeriod.isNotEmpty()) {
      val primary = inPeriod.map { FlaggedTransaction(it, InsightBadge.RENT, isReference = false) }
      buildResult(
        scenario = TransactionScenario.RENT_CHECK,
        status = VerificationStatus.CONFIRMED,
        items = primary + prior,
        range = targetRange,
        queryLabel = null,
        accountNotFoundHint = accountNotFoundHint,
      )
    } else {
      buildResult(
        scenario = TransactionScenario.RENT_CHECK,
        status = VerificationStatus.NOT_DETECTED,
        items = prior,
        range = targetRange,
        queryLabel = null,
        accountNotFoundHint = accountNotFoundHint,
      )
    }
  }

  private fun evaluateSubscriptionsAndBills(
    scoped: List<Transaction>,
    explicitRange: Pair<LocalDate, LocalDate>?,
    searchQuery: String?,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val debits = scoped.filter { it.direction == TransactionDirection.DEBIT }
    val recurringIds = recurringMonthlyDebitIds(debits, MIN_SUBSCRIPTION_DEBIT, SUBSCRIPTION_TOLERANCE)
    val candidates =
      debits
        .filterInRange(explicitRange)
        .filter { txn ->
          txn.category != TransactionCategory.HOUSING &&
            !hasKeyword(txn, RENT_KEYWORDS) &&
            (txn.category == TransactionCategory.SUBSCRIPTIONS ||
              txn.category == TransactionCategory.UTILITIES ||
              txn.transactionId in recurringIds)
        }
    val query = searchQuery?.trim()?.takeIf { it.isNotEmpty() }
    val filtered =
      if (query == null) candidates else candidates.filter { matchesQuery(it, query) }
    val items = filtered.map { FlaggedTransaction(it, InsightBadge.RECURRING) }
    return buildResult(
      scenario = TransactionScenario.SUBSCRIPTIONS_BILLS,
      status = VerificationStatus.NONE,
      items = items,
      range = explicitRange,
      queryLabel = query,
      accountNotFoundHint = accountNotFoundHint,
    )
  }

  private fun evaluateAnomalies(
    scoped: List<Transaction>,
    explicitRange: Pair<LocalDate, LocalDate>?,
    amountThreshold: Double?,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val debits = scoped.filter { it.direction == TransactionDirection.DEBIT }
    val nonHousingAmounts =
      debits
        .filter { it.category != TransactionCategory.HOUSING && !hasKeyword(it, RENT_KEYWORDS) }
        .map { it.amount }
    val medianDebit = median(nonHousingAmounts)
    val largeCutoff =
      amountThreshold ?: maxOf(LARGE_CHARGE_FLOOR, medianDebit * LARGE_CHARGE_MULTIPLIER)

    val inRangeDebits = debits.filterInRange(explicitRange)
    val duplicateIds = duplicateDebitIds(inRangeDebits)

    val flagged =
      inRangeDebits.mapNotNull { txn ->
        val isDuplicate = txn.transactionId in duplicateIds
        val isLarge =
          txn.category != TransactionCategory.HOUSING &&
            !hasKeyword(txn, RENT_KEYWORDS) &&
            txn.amount >= largeCutoff
        when {
          isDuplicate -> FlaggedTransaction(txn, InsightBadge.DUPLICATE)
          isLarge -> FlaggedTransaction(txn, InsightBadge.LARGE_CHARGE)
          else -> null
        }
      }

    val status =
      if (flagged.isNotEmpty()) VerificationStatus.CONFIRMED else VerificationStatus.NOT_DETECTED
    return buildResult(
      scenario = TransactionScenario.ANOMALIES,
      status = status,
      items = flagged,
      range = explicitRange,
      queryLabel = null,
      accountNotFoundHint = accountNotFoundHint,
    )
  }

  private fun evaluateRefundsAndTransfers(
    scoped: List<Transaction>,
    explicitRange: Pair<LocalDate, LocalDate>?,
    rawQuery: String?,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val inRange = scoped.filterInRange(explicitRange)
    val q = rawQuery?.trim()?.lowercase().orEmpty()
    val onlyRefunds = "refund" in q && "transfer" !in q
    val onlyTransfers = ("transfer" in q || "e-trf" in q) && "refund" !in q
    val partyFilter =
      q.takeIf {
        it.isNotEmpty() &&
          it !in setOf("refund", "refunds", "transfer", "transfers", "e-transfer", "e-transfers")
      }

    val matched =
      inRange
        .filter { txn ->
          val categoryMatch =
            when {
              onlyRefunds -> txn.category == TransactionCategory.REFUND
              onlyTransfers -> txn.category == TransactionCategory.TRANSFER
              else ->
                txn.category == TransactionCategory.REFUND ||
                  txn.category == TransactionCategory.TRANSFER
            }
          categoryMatch && (partyFilter == null || matchesQuery(txn, partyFilter))
        }
        .map { txn ->
          val badge =
            if (txn.category == TransactionCategory.REFUND) InsightBadge.REFUND
            else InsightBadge.TRANSFER
          FlaggedTransaction(txn, badge)
        }

    return buildResult(
      scenario = TransactionScenario.REFUNDS_TRANSFERS,
      status = VerificationStatus.NONE,
      items = matched,
      range = explicitRange,
      queryLabel = partyFilter,
      accountNotFoundHint = accountNotFoundHint,
    )
  }

  /**
   * Parses [startDate] and [endDate] as ISO `YYYY-MM-DD` or relative tokens. Swaps inverted bounds
   * so `start <= end`.
   */
  fun parseDateRange(
    startDate: String?,
    endDate: String?,
    today: LocalDate = LocalDate.now(),
  ): Pair<LocalDate, LocalDate>? {
    val startRaw = startDate?.trim()?.lowercase()?.takeIf { it.isNotEmpty() }
    val endRaw = endDate?.trim()?.lowercase()?.takeIf { it.isNotEmpty() }
    val relative = (startRaw ?: endRaw)?.let { resolveRelativeToken(it, today) }
    val parsedStart = startRaw?.let(::parseIsoDate)
    val parsedEnd = endRaw?.let(::parseIsoDate)
    return when {
      relative != null && parsedEnd != null && startRaw != null && parsedStart == null ->
        normalizeBounds(relative.first, parsedEnd)
      relative != null -> relative
      parsedStart != null && parsedEnd != null -> normalizeBounds(parsedStart, parsedEnd)
      parsedStart != null -> normalizeBounds(parsedStart, today)
      parsedEnd != null -> parsedEnd to parsedEnd
      else -> null
    }
  }

  private fun resolveRelativeToken(token: String, today: LocalDate): Pair<LocalDate, LocalDate>? {
    val normalized = token.replace(' ', '_').replace('-', '_')
    return when (normalized) {
      "today" -> today to today
      "yesterday" -> today.minusDays(1) to today.minusDays(1)
      "this_week" -> {
        val monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        monday to today
      }
      "this_month",
      "current_month" -> currentMonthRange(today)
      "last_month",
      "previous_month" -> {
        val lastMonth = YearMonth.from(today).minusMonths(1)
        lastMonth.atDay(1) to lastMonth.atEndOfMonth()
      }
      "last_7_days",
      "past_7_days" -> today.minusDays(LAST_7_DAYS_OFFSET) to today
      "last_30_days",
      "past_30_days" -> today.minusDays(LAST_30_DAYS_OFFSET) to today
      else -> null
    }
  }

  private fun currentMonthRange(today: LocalDate): Pair<LocalDate, LocalDate> {
    val ym = YearMonth.from(today)
    return ym.atDay(1) to ym.atEndOfMonth()
  }

  private fun normalizeBounds(a: LocalDate, b: LocalDate): Pair<LocalDate, LocalDate> =
    if (a.isAfter(b)) b to a else a to b

  private fun parseIsoDate(value: String): LocalDate? =
    runCatching { LocalDate.parse(value) }.getOrNull()

  private fun List<Transaction>.filterInRange(
    range: Pair<LocalDate, LocalDate>?
  ): List<Transaction> {
    if (range == null) return this
    val (start, end) = range
    return filter { txn ->
      val d = parseIsoDate(txn.date) ?: return@filter false
      !d.isBefore(start) && !d.isAfter(end)
    }
  }

  private fun matchesQuery(txn: Transaction, query: String): Boolean {
    val tokens =
      query
        .lowercase()
        .split(Regex("\\s+"))
        .map { it.trim() }
        .filter { it.isNotEmpty() }
    val haystacks =
      listOf(
        txn.merchant.lowercase(),
        txn.descriptor.lowercase(),
        txn.category.name.lowercase(),
        txn.accountName.lowercase(),
      )
    return tokens.all { token ->
      val stem = categorySynonym(token)
      haystacks.any { token in it || (stem != null && stem in it) }
    }
  }

  private fun categorySynonym(token: String): String? =
    when (token) {
      "grocery",
      "supermarket" -> "groceries"
      "restaurant",
      "restaurants",
      "food",
      "coffee" -> "dining"
      "subscription",
      "streaming" -> "subscriptions"
      "utility",
      "bill",
      "bills",
      "hydro",
      "internet" -> "utilities"
      "transit",
      "ride",
      "rides",
      "parking" -> "transport"
      else -> null
    }

  private fun hasKeyword(txn: Transaction, keywords: List<String>): Boolean {
    val text = "${txn.merchant} ${txn.descriptor}".lowercase()
    return keywords.any { it in text }
  }

  private fun recurringCreditIds(credits: List<Transaction>): Set<String> =
    credits
      .filter { it.amount >= MIN_RECURRING_INFLOW && it.category != TransactionCategory.REFUND }
      .groupBy { normalizeMerchantKey(it.merchant) }
      .values
      .filter { group ->
        group.size >= 2 && withinMedianTolerance(group.map { it.amount }, SALARY_TOLERANCE)
      }
      .flatten()
      .map { it.transactionId }
      .toSet()

  private fun recurringMonthlyDebitIds(
    debits: List<Transaction>,
    minAmount: Double,
    tolerance: Double,
  ): Set<String> =
    debits
      .filter { it.amount >= minAmount }
      .groupBy { normalizeMerchantKey(it.merchant) }
      .values
      .filter { group ->
        val months = group.mapNotNull { parseIsoDate(it.date)?.let(YearMonth::from) }.toSet()
        months.size >= 2 && withinMedianTolerance(group.map { it.amount }, tolerance)
      }
      .flatten()
      .map { it.transactionId }
      .toSet()

  private fun duplicateDebitIds(debits: List<Transaction>): Set<String> =
    debits
      .groupBy { Triple(it.accountId, normalizeMerchantKey(it.merchant), "%.2f".format(it.amount)) }
      .values
      .filter { it.size >= 2 }
      .flatMapTo(mutableSetOf(), ::duplicateIdsInGroup)

  private fun duplicateIdsInGroup(group: List<Transaction>): Set<String> {
    val dated = group.mapNotNull { txn -> parseIsoDate(txn.date)?.let { txn.transactionId to it } }
    return dated
      .filter { (id1, d1) ->
        dated.any { (id2, d2) ->
          id1 != id2 && abs(ChronoUnit.DAYS.between(d1, d2)) <= DUPLICATE_MAX_DAYS
        }
      }
      .mapTo(mutableSetOf()) { it.first }
  }

  private fun normalizeMerchantKey(merchant: String): String =
    merchant.lowercase().replace(Regex("[^a-z0-9]+"), " ").trim()

  private fun withinMedianTolerance(amounts: List<Double>, tolerance: Double): Boolean {
    val med = median(amounts)
    if (med <= 0.0) return false
    return amounts.all { abs(it - med) / med <= tolerance }
  }

  private fun median(values: List<Double>): Double {
    if (values.isEmpty()) return 0.0
    val sorted = values.sorted()
    val mid = sorted.size / 2
    return if (sorted.size % 2 == 1) sorted[mid] else (sorted[mid - 1] + sorted[mid]) / 2.0
  }

  private fun defaultBadgeFor(txn: Transaction): InsightBadge? =
    when (txn.category) {
      TransactionCategory.INCOME -> InsightBadge.SALARY
      TransactionCategory.HOUSING -> InsightBadge.RENT
      TransactionCategory.SUBSCRIPTIONS,
      TransactionCategory.UTILITIES -> InsightBadge.RECURRING
      TransactionCategory.REFUND -> InsightBadge.REFUND
      TransactionCategory.TRANSFER -> InsightBadge.TRANSFER
      else -> null
    }

  private fun buildResult(
    scenario: TransactionScenario,
    status: VerificationStatus,
    items: List<FlaggedTransaction>,
    range: Pair<LocalDate, LocalDate>?,
    queryLabel: String?,
    accountNotFoundHint: String?,
  ): TransactionQueryResult {
    val primary = items.filter { !it.isReference }
    val inflow =
      primary
        .filter { it.transaction.direction == TransactionDirection.CREDIT }
        .sumOf { it.transaction.amount }
    val outflow =
      primary
        .filter { it.transaction.direction == TransactionDirection.DEBIT }
        .sumOf { it.transaction.amount }
    val periodLabel = range?.let { (start, end) -> "$start..$end" }
    return TransactionQueryResult(
      scenario = scenario,
      status = status,
      items = items,
      matchCount = primary.size,
      totalInflow = inflow,
      totalOutflow = outflow,
      periodLabel = periodLabel,
      queryLabel = queryLabel,
      accountNotFoundHint = accountNotFoundHint,
    )
  }

  private const val MAX_REFERENCES = 4
}
