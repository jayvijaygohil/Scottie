package com.jayvijay.scottie.feature.interacbanking.domain.usecase

import com.jayvijay.scottie.feature.interacbanking.Fixtures
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.Intent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.TransactionScenario
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Transaction
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionCategory
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionDirection
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.TransactionInsights.InsightBadge
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.TransactionInsights.VerificationStatus
import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class TransactionInsightsTest {
  private val today = LocalDate.of(2026, 10, 14)

  private fun txn(
    id: String,
    accId: String = "acc_chk_101",
    date: String,
    descriptor: String,
    merchant: String,
    category: TransactionCategory,
    direction: TransactionDirection = TransactionDirection.DEBIT,
    amount: Double,
  ) =
    Transaction(
      transactionId = id,
      accountId = accId,
      accountName = Fixtures.ACCOUNTS.first { it.accountId == accId }.name,
      date = date,
      descriptor = descriptor,
      merchant = merchant,
      category = category,
      direction = direction,
      amount = amount,
    )

  private val ledger =
    listOf(
      txn(
        "s1",
        date = "2026-08-15",
        descriptor = "ADP PAYROLL - ACME CORP",
        merchant = "Acme Corp Payroll",
        category = TransactionCategory.INCOME,
        direction = TransactionDirection.CREDIT,
        amount = 3250.0,
      ),
      txn(
        "s2",
        date = "2026-09-15",
        descriptor = "DIRECT DEP ACME CORP",
        merchant = "Acme Corp Payroll",
        category = TransactionCategory.INCOME,
        direction = TransactionDirection.CREDIT,
        amount = 3265.0,
      ),
      txn(
        "s3",
        date = "2026-10-01",
        descriptor = "CANADA PAYROLL ACME",
        merchant = "Acme Corp Payroll",
        category = TransactionCategory.INCOME,
        direction = TransactionDirection.CREDIT,
        amount = 3280.0,
      ),
      txn(
        "r1",
        date = "2026-08-01",
        descriptor = "MAPLE PROPERTY MGMT RENT",
        merchant = "Maple Property Mgmt",
        category = TransactionCategory.HOUSING,
        amount = 2100.0,
      ),
      txn(
        "r2",
        date = "2026-09-01",
        descriptor = "E-TRANSFER RENT LANDLORD",
        merchant = "Maple Property Mgmt",
        category = TransactionCategory.HOUSING,
        amount = 2100.0,
      ),
      txn(
        "r3",
        date = "2026-10-01",
        descriptor = "MAPLE PROPERTY MGMT RENT",
        merchant = "Maple Property Mgmt",
        category = TransactionCategory.HOUSING,
        amount = 2100.0,
      ),
      txn(
        "sub1",
        accId = "acc_cc_404",
        date = "2026-09-05",
        descriptor = "STREAMFLIX.COM",
        merchant = "StreamFlix",
        category = TransactionCategory.SUBSCRIPTIONS,
        amount = 18.99,
      ),
      txn(
        "sub2",
        accId = "acc_cc_404",
        date = "2026-10-05",
        descriptor = "STREAMFLIX.COM",
        merchant = "StreamFlix",
        category = TransactionCategory.SUBSCRIPTIONS,
        amount = 18.99,
      ),
      txn(
        "util1",
        date = "2026-10-10",
        descriptor = "TORONTO HYDRO BILL",
        merchant = "Toronto Hydro",
        category = TransactionCategory.UTILITIES,
        amount = 94.20,
      ),
      txn(
        "groc1",
        accId = "acc_cc_404",
        date = "2026-10-03",
        descriptor = "FRESHCO GROCERIES #104",
        merchant = "FreshCo",
        category = TransactionCategory.GROCERIES,
        amount = 120.00,
      ),
      txn(
        "groc2",
        accId = "acc_cc_404",
        date = "2026-10-09",
        descriptor = "METRO MARKET #42",
        merchant = "Metro Market",
        category = TransactionCategory.GROCERIES,
        amount = 80.00,
      ),
      txn(
        "dup1",
        accId = "acc_cc_404",
        date = "2026-10-06",
        descriptor = "CITY PARKING LOT 9",
        merchant = "City Parking",
        category = TransactionCategory.TRANSPORT,
        amount = 15.00,
      ),
      txn(
        "dup2",
        accId = "acc_cc_404",
        date = "2026-10-07",
        descriptor = "CITY PARKING LOT 9",
        merchant = "City Parking",
        category = TransactionCategory.TRANSPORT,
        amount = 15.00,
      ),
      txn(
        "large1",
        accId = "acc_cc_404",
        date = "2026-10-11",
        descriptor = "TECHMART ELECTRONICS",
        merchant = "TechMart Electronics",
        category = TransactionCategory.SHOPPING,
        amount = 899.99,
      ),
      txn(
        "ref1",
        accId = "acc_cc_404",
        date = "2026-10-13",
        descriptor = "TECHMART REFUND",
        merchant = "TechMart Electronics",
        category = TransactionCategory.REFUND,
        direction = TransactionDirection.CREDIT,
        amount = 124.50,
      ),
      txn(
        "trf1",
        date = "2026-09-20",
        descriptor = "INTERAC E-TRF - ALICE MARTIN",
        merchant = "Alice Martin",
        category = TransactionCategory.TRANSFER,
        amount = 50.00,
      ),
    )

  private fun eval(intent: AssistantIntent, txns: List<Transaction> = ledger) =
    TransactionInsights.evaluate(intent, txns, Fixtures.ACCOUNTS, today)

  @Test
  fun dateRangeInclusiveAndInvertedRangeSwap() {
    val normal =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          startDate = "2026-10-03",
          endDate = "2026-10-09",
        )
      )
    val inverted =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          startDate = "2026-10-09",
          endDate = "2026-10-03",
        )
      )

    assertEquals(listOf("groc2", "dup2", "dup1", "sub2", "groc1"), normal.items.map { it.transaction.transactionId })
    assertEquals(normal.items, inverted.items)
    assertEquals("2026-10-03..2026-10-09", inverted.periodLabel)
    assertEquals(248.99, normal.totalOutflow, 0.001)
    assertEquals(0.0, normal.totalInflow, 0.001)
  }

  @Test
  fun relativeDateTokensAndOpenEndedStartDate() {
    val lastMonth =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          startDate = "last_month",
        )
      )
    assertEquals("2026-09-01..2026-09-30", lastMonth.periodLabel)
    assertEquals(listOf("trf1", "s2", "sub1", "r2"), lastMonth.items.map { it.transaction.transactionId })

    val openEnded =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          startDate = "2026-10-10",
        )
      )
    assertEquals("2026-10-10..2026-10-14", openEnded.periodLabel)
    assertEquals(listOf("ref1", "large1", "util1"), openEnded.items.map { it.transaction.transactionId })
  }

  @Test
  fun accountFilterAndUnknownAccountFallback() {
    val visaOnly =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          accountHint = "Visa",
          startDate = "2026-10-01",
          endDate = "2026-10-05",
        )
      )
    assertNull(visaOnly.accountNotFoundHint)
    assertEquals(listOf("sub2", "groc1"), visaOnly.items.map { it.transaction.transactionId })

    val unknown =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          accountHint = "TFSA",
          startDate = "2026-10-13",
          endDate = "2026-10-14",
        )
      )
    assertEquals("TFSA", unknown.accountNotFoundHint)
    assertEquals(listOf("ref1"), unknown.items.map { it.transaction.transactionId })
  }

  @Test
  fun merchantCategorySearchAndEmptyResult() {
    val groceries =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.MERCHANT_CATEGORY,
          searchQuery = "groceries",
        )
      )
    assertEquals(listOf("groc2", "groc1"), groceries.items.map { it.transaction.transactionId })
    assertEquals(200.0, groceries.totalOutflow, 0.001)

    val empty =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.DATE_RANGE,
          startDate = "2025-01-01",
          endDate = "2025-01-31",
        )
      )
    assertEquals(0, empty.matchCount)
    assertTrue(empty.items.isEmpty())
  }

  @Test
  fun salaryVerificationConfirmedAndNotDetectedWithReference() {
    val confirmed =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.SALARY_CHECK,
        )
      )
    assertEquals(VerificationStatus.CONFIRMED, confirmed.status)
    assertEquals(1, confirmed.matchCount)
    assertEquals("s3", confirmed.items.single().transaction.transactionId)
    assertEquals(InsightBadge.SALARY, confirmed.items.single().badge)
    assertEquals(3280.0, confirmed.totalInflow, 0.001)

    val withoutCurrentSalary = ledger.filterNot { it.transactionId == "s3" }
    val missing =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.SALARY_CHECK,
        ),
        txns = withoutCurrentSalary,
      )
    assertEquals(VerificationStatus.NOT_DETECTED, missing.status)
    assertEquals(0, missing.matchCount)
    assertEquals(listOf("s2", "s1"), missing.items.map { it.transaction.transactionId })
    assertTrue(missing.items.all { it.isReference && it.badge == InsightBadge.SALARY })
  }

  @Test
  fun rentVerificationConfirmedAndNotDetectedPrioritizesRentOverSubscriptions() {
    val confirmed =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.RENT_CHECK,
        )
      )
    assertEquals(VerificationStatus.CONFIRMED, confirmed.status)
    assertEquals(1, confirmed.matchCount)
    assertEquals(2100.0, confirmed.totalOutflow, 0.001)
    val primary = confirmed.items.filter { !it.isReference }
    val refs = confirmed.items.filter { it.isReference }
    assertEquals(listOf("r3"), primary.map { it.transaction.transactionId })
    assertEquals(listOf("r2", "r1"), refs.map { it.transaction.transactionId })

    val withoutCurrentRent = ledger.filterNot { it.transactionId == "r3" }
    val missing =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.RENT_CHECK,
        ),
        txns = withoutCurrentRent,
      )
    assertEquals(VerificationStatus.NOT_DETECTED, missing.status)
    assertEquals(0, missing.matchCount)
    assertEquals(listOf("r2", "r1"), missing.items.map { it.transaction.transactionId })
    assertTrue(missing.items.all { it.isReference && it.badge == InsightBadge.RENT })
  }

  @Test
  fun subscriptionsAndUtilityBillsExcludesRent() {
    val subs =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.SUBSCRIPTIONS_BILLS,
        )
      )
    assertEquals(listOf("util1", "sub2", "sub1"), subs.items.map { it.transaction.transactionId })
    assertTrue(subs.items.all { it.badge == InsightBadge.RECURRING })
  }

  @Test
  fun anomaliesFlagsDuplicatesWithin48hAndLargeCharges() {
    val anomalies =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.ANOMALIES,
        )
      )
    assertEquals(VerificationStatus.CONFIRMED, anomalies.status)
    assertEquals(
      mapOf(
        "large1" to InsightBadge.LARGE_CHARGE,
        "dup2" to InsightBadge.DUPLICATE,
        "dup1" to InsightBadge.DUPLICATE,
      ),
      anomalies.items.associate { it.transaction.transactionId to it.badge },
    )
  }

  @Test
  fun refundsAndTransfersFilterByKeyword() {
    val all =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.REFUNDS_TRANSFERS,
        )
      )
    assertEquals(listOf("ref1", "trf1"), all.items.map { it.transaction.transactionId })

    val refundsOnly =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.REFUNDS_TRANSFERS,
          searchQuery = "refund",
        )
      )
    assertEquals(listOf("ref1"), refundsOnly.items.map { it.transaction.transactionId })
    assertEquals(InsightBadge.REFUND, refundsOnly.items.single().badge)

    val aliceTransfers =
      eval(
        AssistantIntent(
          Intent.TRANSACTIONS,
          scenario = TransactionScenario.REFUNDS_TRANSFERS,
          recipientQuery = "Alice",
        )
      )
    assertEquals(listOf("trf1"), aliceTransfers.items.map { it.transaction.transactionId })
    assertEquals(InsightBadge.TRANSFER, aliceTransfers.items.single().badge)
  }
}
