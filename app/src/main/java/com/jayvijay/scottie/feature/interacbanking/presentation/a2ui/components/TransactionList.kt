package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import android.content.res.Configuration
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
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieCodeSmall
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieBadge
import com.jayvijay.scottie.core.ui.components.ScottieBadgeTone
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

    TransactionListContent(
      scenarioCode = scenarioCode,
      statusCode = statusCode,
      count = count,
      inflow = inflow,
      outflow = outflow,
      periodLabel = periodLabel,
      queryLabel = queryLabel,
      allItems = allItems,
      modifier = modifier,
    )
  }

  internal fun scenarioTitle(code: String) =
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

  internal fun categoryLabel(code: String) =
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

  internal fun badgeLabel(code: String) =
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

@Composable
internal fun TransactionListContent(
  scenarioCode: String,
  statusCode: String,
  count: Int,
  inflow: String,
  outflow: String,
  periodLabel: String,
  queryLabel: String,
  allItems: List<TransactionList.Item>,
  modifier: Modifier = Modifier,
) {
  val colors = ScottieTheme.colors
  val primaryItems = allItems.filter { !it.isReference }
  val referenceItems = allItems.filter { it.isReference }

  Column(
    modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp),
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
        text = emptyText,
        style = MaterialTheme.typography.bodyMedium,
        color = colors.textSecondary,
      )
    } else {
      Surface(
        color = colors.surfaceCanvas,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, colors.borderSubtle),
      ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)) {
          primaryItems.forEachIndexed { index, item ->
            TransactionRow(
              item = item,
              showDivider = index < primaryItems.lastIndex,
            )
          }
        }
      }
    }
    if (referenceItems.isNotEmpty()) {
      Text(
        text = stringResource(R.string.assistant_txn_reference_header),
        style = MaterialTheme.typography.labelLarge,
        color = colors.textSecondary,
        modifier = Modifier.padding(top = 4.dp),
      )
      Surface(
        color = colors.surfaceCanvas,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, colors.borderSubtle),
      ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)) {
          referenceItems.forEachIndexed { index, item ->
            TransactionRow(
              item = item,
              showDivider = index < referenceItems.lastIndex,
            )
          }
        }
      }
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
  val colors = ScottieTheme.colors
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Column(modifier = Modifier.weight(1f)) {
      Text(
        text = stringResource(TransactionList.scenarioTitle(scenarioCode)),
        style = MaterialTheme.typography.titleMedium,
        color = colors.textPrimary,
      )
      val subtitle = listOf(periodLabel, queryLabel).filter { it.isNotBlank() }.joinToString(" · ")
      if (subtitle.isNotEmpty()) {
        Text(
          text = subtitle,
          style = MaterialTheme.typography.bodySmall,
          color = colors.textSecondary,
        )
      }
    }
    when (statusCode) {
      VerificationStatus.CONFIRMED.name -> {
        val tone =
          if (scenarioCode == TransactionScenario.ANOMALIES.name) {
            ScottieBadgeTone.Warning
          } else {
            ScottieBadgeTone.Success
          }
        ScottieBadge(
          text = stringResource(R.string.assistant_txn_status_confirmed),
          tone = tone,
        )
      }
      VerificationStatus.NOT_DETECTED.name -> {
        val tone =
          if (scenarioCode == TransactionScenario.ANOMALIES.name) {
            ScottieBadgeTone.Success
          } else {
            ScottieBadgeTone.Warning
          }
        ScottieBadge(
          text = stringResource(R.string.assistant_txn_status_not_detected),
          tone = tone,
        )
      }
    }
  }
}

@Composable
private fun VerificationBanner(scenarioCode: String, statusCode: String) {
  val colors = ScottieTheme.colors
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
    Surface(
      color = colors.surfaceCanvas,
      shape = RoundedCornerShape(10.dp),
      border = BorderStroke(1.dp, colors.borderSubtle),
    ) {
      Text(
        text = stringResource(bannerRes),
        style = MaterialTheme.typography.bodyMedium,
        color = colors.textSecondary,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
      )
    }
  }
}

@Composable
private fun TotalsRow(inflow: String, outflow: String) {
  val colors = ScottieTheme.colors
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    if (inflow.isNotBlank() && inflow != "0.00") {
      Surface(
        color = colors.statusSuccessSubtle,
        shape = RoundedCornerShape(8.dp),
      ) {
        Text(
          text = stringResource(R.string.assistant_txn_summary_inflow, inflow),
          style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
          color = colors.statusSuccess,
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
        )
      }
    }
    if (outflow.isNotBlank() && outflow != "0.00") {
      Surface(
        color = colors.surfaceCanvas,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, colors.borderSubtle),
      ) {
        Text(
          text = stringResource(R.string.assistant_txn_summary_outflow, outflow),
          style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
          color = colors.textSecondary,
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
        )
      }
    }
  }
}

@Composable
private fun TransactionRow(item: TransactionList.Item, showDivider: Boolean = true) {
  val colors = ScottieTheme.colors
  val isCredit = item.directionCode == TransactionDirection.CREDIT.name
  val sign = if (isCredit) "+" else "-"
  Column(
    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp),
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Text(
        text = item.merchant,
        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
        color = colors.textPrimary,
        modifier = Modifier.weight(1f),
      )
      if (item.badgeCode.isNotBlank()) {
        val badgeTone =
          if (
            item.badgeCode == InsightBadge.DUPLICATE.name ||
              item.badgeCode == InsightBadge.LARGE_CHARGE.name
          ) {
            ScottieBadgeTone.Warning
          } else {
            ScottieBadgeTone.Brand
          }
        ScottieBadge(
          text = stringResource(TransactionList.badgeLabel(item.badgeCode)),
          tone = badgeTone,
        )
      }
      Text(
        text = "$sign$${item.amount} ${item.currency}",
        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
        color = if (isCredit) colors.statusSuccess else colors.textPrimary,
        modifier = Modifier.padding(start = 8.dp),
      )
    }
    Text(
      text =
        "${item.date} · ${item.accountName} · " +
          stringResource(TransactionList.categoryLabel(item.categoryCode)),
      style = MaterialTheme.typography.bodySmall,
      color = colors.textSecondary,
    )
    if (item.descriptor.isNotBlank()) {
      Text(
        text = item.descriptor,
        style = ScottieCodeSmall,
        color = colors.textTertiary,
      )
    }
    if (showDivider) {
      HorizontalDivider(color = colors.borderSubtle, modifier = Modifier.padding(top = 6.dp))
    }
  }
}

@Preview(name = "TransactionList Light", showBackground = true, widthDp = 360)
@Preview(
  name = "TransactionList Dark",
  showBackground = true,
  widthDp = 360,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun TransactionListPreview() {
  ScottieTheme {
    Column(modifier = Modifier.background(ScottieTheme.colors.surfaceCard).padding(16.dp)) {
      TransactionListContent(
        scenarioCode = TransactionScenario.SALARY_CHECK.name,
        statusCode = VerificationStatus.CONFIRMED.name,
        count = 1,
        inflow = "3,280.00",
        outflow = "0.00",
        periodLabel = "Oct 2026",
        queryLabel = "",
        allItems =
          listOf(
            TransactionList.Item(
              id = "tx-1",
              date = "2026-10-15",
              merchant = "Acme Corp Payroll",
              descriptor = "PAYROLL DEPOSIT ACME",
              categoryCode = TransactionCategory.INCOME.name,
              accountName = "Chequing",
              directionCode = TransactionDirection.CREDIT.name,
              amount = "3,280.00",
              currency = "CAD",
              badgeCode = InsightBadge.SALARY.name,
              isReference = false,
            )
          ),
      )
    }
  }
}
