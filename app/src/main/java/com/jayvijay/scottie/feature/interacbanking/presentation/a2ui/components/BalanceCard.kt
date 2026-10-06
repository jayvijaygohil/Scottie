package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
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
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType

object BalanceCard : A2uiComponent {
  private val Name = A2uiProperty.dynamicString("name", required = true)
  private val TypeCode = A2uiProperty.dynamicString("typeCode", required = true)
  private val Mask = A2uiProperty.dynamicString("mask", required = true)
  private val Balance = A2uiProperty.dynamicString("balance", required = true)
  private val Currency = A2uiProperty.dynamicString("currency", required = true)
  private val Highlight = A2uiProperty.dynamicBoolean("highlight")

  override val name = "BalanceCard"
  override val description = "One account with its available balance."
  override val properties: List<A2uiProperty<*>> =
    listOf(Name, TypeCode, Mask, Balance, Currency, Highlight)

  @Composable
  override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean =
    properties.bind(Name) != null && properties.bind(Balance) != null

  @Composable
  override fun A2uiComponentScope.Content(
    properties: A2uiComponentProperties,
    modifier: Modifier,
  ) {
    val name = properties.bind(Name) ?: return
    val balance = properties.bind(Balance) ?: return
    val typeCode = properties.bind(TypeCode).orEmpty()
    val highlight = properties.bind(Highlight) ?: false
    val (background, foreground) = Badge.toneColors(if (highlight) "error" else "info")
    Column(
      modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(name, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
        XelaBadge(stringResource(typeLabel(typeCode)), background, foreground)
      }
      Text(
        properties.bind(Mask).orEmpty(),
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      Text(
        "$balance ${properties.bind(Currency).orEmpty()}",
        style = MaterialTheme.typography.headlineSmall,
      )
      XelaDivider(color = MaterialTheme.colorScheme.outlineVariant)
    }
  }

  private fun typeLabel(code: String) =
    when (code) {
      AccountType.CHEQUING.name -> R.string.assistant_account_type_chequing
      AccountType.SAVINGS.name -> R.string.assistant_account_type_savings
      AccountType.CREDIT.name -> R.string.assistant_account_type_credit
      else -> R.string.assistant_account_type_loc
    }
}
