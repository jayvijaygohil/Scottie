package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.a2ui.model.schema.A2uiAnySchema
import androidx.a2ui.model.schema.A2uiArraySchema
import androidx.a2ui.model.schema.A2uiBooleanSchema
import androidx.a2ui.model.schema.A2uiObjectSchema
import androidx.a2ui.model.schema.A2uiSchemaKeyword
import androidx.a2ui.model.schema.A2uiStringSchema
import androidx.a2ui.model.schema.commontypes.A2uiDataBindingSchema
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.xelauikit.XelaBadge
import com.jayvijay.scottie.core.ui.xelauikit.XelaDivider
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.TransactionScenario
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionCategory
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransactionDirection
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.TransactionInsights.InsightBadge
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.TransactionInsights.VerificationStatus

/**
 * Renders transaction query results and financial insights (salary, rent, subscriptions, anomalies,
 * refunds/transfers). All static labels and banners are resolved from `strings.xml`.
 */
@Suppress("TooManyFunctions")
object TransactionList : A2uiComponent {
  data class Item(
    val id: String,
    val date: String,
    val merchant: String,
    val descriptor: String,
    val categoryCode: String,
    val accountName: String,
    val directionCode: String,
    val amount: String,
    val currency: String,
    val badgeCode: String,
    val isReference: Boolean,
  )

  private val ScenarioCode = A2uiProperty.dynamicString("scenarioCode", required = true)
  private val StatusCode = A2uiProperty.dynamicString("statusCode", required = true)
  private val Count = A2uiProperty.dynamicString("count", required = true)
  private val InflowAmount = A2uiProperty.dynamicString("inflowAmount")
  private val OutflowAmount = A2uiProperty.dynamicString("outflowAmount")
  private val PeriodLabel = A2uiProperty.dynamicString("periodLabel")
  private val QueryLabel = A2uiProperty.dynamicString("queryLabel")
  private val Items = itemsProperty()

  override val name = "TransactionList"
  override val description = "Structured transaction list with financial insight verification."
  override val properties: List<A2uiProperty<*>> =
    listOf(
      ScenarioCode,
      StatusCode,
      Count,
      InflowAmount,
      OutflowAmount,
      PeriodLabel,
      QueryLabel,
      Items,
    )

  @Composable
  override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean =
    properties.bind(ScenarioCode) != null &&
      properties.bind(StatusCode) != null &&
      properties.bind(Count) != null

  @Composable
  override fun A2uiComponentScope.Content(
    properties: A2uiComponentProperties,
    modifier: Modifier,
  ) {
    val scenarioCode = properties.bind(ScenarioCode) ?: return
    val statusCode = properties.bind(StatusCode) ?: return
    val count = properties.bind(Count)?.toIntOrNull() ?: 0
    val inflow = properties.bind(InflowAmount).orEmpty()
    val outflow = properties.bind(OutflowAmount).orEmpty()
    val periodLabel = properties.bind(PeriodLabel).orEmpty()
    val queryLabel = properties.bind(QueryLabel).orEmpty()
    val allItems = properties.bind(Items).orEmpty()
    val primaryItems = allItems.filter { !it.isReference }
    val referenceItems = allItems.filter { it.isReference }

    Column(
      modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Header(scenarioCode, statusCode, periodLabel, queryLabel)
      VerificationBanner(scenarioCode, statusCode)
      if (count > 0) {
        TotalsRow(inflow, outflow)
      }
      if (primaryItems.isEmpty()) {
        val contextLabel = queryLabel.ifEmpty { periodLabel }
        val emptyText =
          if (contextLabel.isNotEmpty()) {
            stringResource(R.string.assistant_txn_empty_period, contextLabel)
          } else {
            stringResource(R.string.assistant_txn_empty)
          }
        Text(
          emptyText,
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      } else {
        primaryItems.forEach { item -> TransactionRow(item) }
      }
      if (referenceItems.isNotEmpty()) {
        Text(
          stringResource(R.string.assistant_txn_reference_header),
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.padding(top = 4.dp),
        )
        referenceItems.forEach { item -> TransactionRow(item) }
      }
    }
  }

  @Composable
  private fun Header(
    scenarioCode: String,
    statusCode: String,
    periodLabel: String,
    queryLabel: String,
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Column(modifier = Modifier.weight(1f)) {
        Text(
          stringResource(scenarioTitle(scenarioCode)),
          style = MaterialTheme.typography.titleMedium,
        )
        val subtitle = listOf(periodLabel, queryLabel).filter { it.isNotBlank() }.joinToString(" · ")
        if (subtitle.isNotEmpty()) {
          Text(
            subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
      }
      when (statusCode) {
        VerificationStatus.CONFIRMED.name -> {
          val tone =
            if (scenarioCode == TransactionScenario.ANOMALIES.name) "warning" else "success"
          val (bg, fg) = Badge.toneColors(tone)
          XelaBadge(stringResource(R.string.assistant_txn_status_confirmed), bg, fg)
        }
        VerificationStatus.NOT_DETECTED.name -> {
          val tone =
            if (scenarioCode == TransactionScenario.ANOMALIES.name) "success" else "warning"
          val (bg, fg) = Badge.toneColors(tone)
          XelaBadge(stringResource(R.string.assistant_txn_status_not_detected), bg, fg)
        }
      }
    }
  }

  @Composable
  private fun VerificationBanner(scenarioCode: String, statusCode: String) {
    val bannerRes =
      when (scenarioCode) {
        TransactionScenario.SALARY_CHECK.name ->
          if (statusCode == VerificationStatus.CONFIRMED.name) {
            R.string.assistant_txn_banner_salary_confirmed
          } else {
            R.string.assistant_txn_banner_salary_missing
          }
        TransactionScenario.RENT_CHECK.name ->
          if (statusCode == VerificationStatus.CONFIRMED.name) {
            R.string.assistant_txn_banner_rent_confirmed
          } else {
            R.string.assistant_txn_banner_rent_missing
          }
        TransactionScenario.ANOMALIES.name ->
          if (statusCode == VerificationStatus.CONFIRMED.name) {
            R.string.assistant_txn_banner_anomalies_confirmed
          } else {
            R.string.assistant_txn_banner_anomalies_none
          }
        else -> null
      }
    if (bannerRes != null) {
      Text(
        stringResource(bannerRes),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
  }

  @Composable
  private fun TotalsRow(inflow: String, outflow: String) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      if (inflow.isNotBlank() && inflow != "0.00") {
        Text(
          stringResource(R.string.assistant_txn_summary_inflow, inflow),
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.primary,
        )
      }
      if (outflow.isNotBlank() && outflow != "0.00") {
        Text(
          stringResource(R.string.assistant_txn_summary_outflow, outflow),
          style = MaterialTheme.typography.labelMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
    XelaDivider(color = MaterialTheme.colorScheme.outlineVariant)
  }

  @Composable
  private fun TransactionRow(item: Item) {
    val isCredit = item.directionCode == TransactionDirection.CREDIT.name
    val sign = if (isCredit) "+" else "-"
    Column(
      modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
      verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
          item.merchant,
          style = MaterialTheme.typography.bodyLarge,
          modifier = Modifier.weight(1f),
        )
        if (item.badgeCode.isNotBlank()) {
          val badgeTone =
            if (
              item.badgeCode == InsightBadge.DUPLICATE.name ||
                item.badgeCode == InsightBadge.LARGE_CHARGE.name
            ) {
              "warning"
            } else {
              "info"
            }
          val (bg, fg) = Badge.toneColors(badgeTone)
          XelaBadge(
            stringResource(badgeLabel(item.badgeCode)),
            bg,
            fg,
          )
        }
        Text(
          "$sign$${item.amount} ${item.currency}",
          style = MaterialTheme.typography.bodyLarge,
          modifier = Modifier.padding(start = 8.dp),
        )
      }
      Text(
        "${item.date} · ${item.accountName} · ${stringResource(categoryLabel(item.categoryCode))}",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      Text(
        item.descriptor,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      XelaDivider(color = MaterialTheme.colorScheme.outlineVariant)
    }
  }

  private fun scenarioTitle(code: String) =
    when (code) {
      TransactionScenario.SALARY_CHECK.name -> R.string.assistant_txn_title_salary_check
      TransactionScenario.RENT_CHECK.name -> R.string.assistant_txn_title_rent_check
      TransactionScenario.SUBSCRIPTIONS_BILLS.name ->
        R.string.assistant_txn_title_subscriptions_bills
      TransactionScenario.MERCHANT_CATEGORY.name -> R.string.assistant_txn_title_merchant_category
      TransactionScenario.ANOMALIES.name -> R.string.assistant_txn_title_anomalies
      TransactionScenario.REFUNDS_TRANSFERS.name -> R.string.assistant_txn_title_refunds_transfers
      else -> R.string.assistant_txn_title_date_range
    }

  private fun categoryLabel(code: String) =
    when (code) {
      TransactionCategory.INCOME.name -> R.string.assistant_txn_cat_income
      TransactionCategory.HOUSING.name -> R.string.assistant_txn_cat_housing
      TransactionCategory.UTILITIES.name -> R.string.assistant_txn_cat_utilities
      TransactionCategory.SUBSCRIPTIONS.name -> R.string.assistant_txn_cat_subscriptions
      TransactionCategory.GROCERIES.name -> R.string.assistant_txn_cat_groceries
      TransactionCategory.DINING.name -> R.string.assistant_txn_cat_dining
      TransactionCategory.TRANSPORT.name -> R.string.assistant_txn_cat_transport
      TransactionCategory.SHOPPING.name -> R.string.assistant_txn_cat_shopping
      TransactionCategory.REFUND.name -> R.string.assistant_txn_cat_refund
      else -> R.string.assistant_txn_cat_transfer
    }

  private fun badgeLabel(code: String) =
    when (code) {
      InsightBadge.SALARY.name -> R.string.assistant_txn_badge_salary
      InsightBadge.RENT.name -> R.string.assistant_txn_badge_rent
      InsightBadge.RECURRING.name -> R.string.assistant_txn_badge_recurring
      InsightBadge.DUPLICATE.name -> R.string.assistant_txn_badge_duplicate
      InsightBadge.LARGE_CHARGE.name -> R.string.assistant_txn_badge_large_charge
      InsightBadge.REFUND.name -> R.string.assistant_txn_badge_refund
      else -> R.string.assistant_txn_badge_transfer
    }

  private fun itemsProperty() =
    A2uiProperty.dynamicCustom(
      key = "items",
      required = true,
      schema =
        A2uiAnySchema(
          keywords =
            listOf(
              A2uiSchemaKeyword.OneOf(
                listOf(
                  A2uiDataBindingSchema.DEFAULT_INSTANCE,
                  A2uiArraySchema(
                    items =
                      A2uiObjectSchema(
                        properties =
                          mapOf(
                            "id" to A2uiStringSchema(),
                            "date" to A2uiStringSchema(),
                            "merchant" to A2uiStringSchema(),
                            "descriptor" to A2uiStringSchema(),
                            "categoryCode" to A2uiStringSchema(),
                            "accountName" to A2uiStringSchema(),
                            "directionCode" to A2uiStringSchema(),
                            "amount" to A2uiStringSchema(),
                            "currency" to A2uiStringSchema(),
                            "badgeCode" to A2uiStringSchema(),
                            "isReference" to A2uiBooleanSchema(),
                          ),
                        required =
                          setOf(
                            "id",
                            "date",
                            "merchant",
                            "descriptor",
                            "categoryCode",
                            "accountName",
                            "directionCode",
                            "amount",
                            "currency",
                          ),
                      )
                  ),
                )
              )
            )
        ),
      safeCast = { raw ->
        (raw as? List<*>)?.mapNotNull { entry ->
          val map = entry as? Map<*, *> ?: return@mapNotNull null
          Item(
            id = map["id"] as? String ?: return@mapNotNull null,
            date = map["date"] as? String ?: return@mapNotNull null,
            merchant = map["merchant"] as? String ?: return@mapNotNull null,
            descriptor = map["descriptor"] as? String ?: "",
            categoryCode = map["categoryCode"] as? String ?: "",
            accountName = map["accountName"] as? String ?: "",
            directionCode = map["directionCode"] as? String ?: "",
            amount = map["amount"] as? String ?: return@mapNotNull null,
            currency = map["currency"] as? String ?: "CAD",
            badgeCode = map["badgeCode"] as? String ?: "",
            isReference = map["isReference"] as? Boolean ?: false,
          )
        }
      },
    )
}
