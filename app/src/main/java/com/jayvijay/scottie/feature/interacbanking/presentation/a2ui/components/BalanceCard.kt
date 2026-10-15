package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import android.content.res.Configuration
import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.Savings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieCodeSmall
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieBadge
import com.jayvijay.scottie.core.ui.components.ScottieBadgeTone
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
    val mask = properties.bind(Mask).orEmpty()
    val currency = properties.bind(Currency).orEmpty()
    val highlight = properties.bind(Highlight) ?: false

    BalanceCardContent(
      name = name,
      typeCode = typeCode,
      mask = mask,
      balance = balance,
      currency = currency,
      highlight = highlight,
      modifier = modifier,
    )
  }

  internal fun typeLabel(code: String) =
    when (code) {
      AccountType.CHEQUING.name -> R.string.assistant_account_type_chequing
      AccountType.SAVINGS.name -> R.string.assistant_account_type_savings
      AccountType.CREDIT.name -> R.string.assistant_account_type_credit
      else -> R.string.assistant_account_type_loc
    }
}

@Composable
internal fun BalanceCardContent(
  name: String,
  typeCode: String,
  mask: String,
  balance: String,
  currency: String,
  highlight: Boolean,
  modifier: Modifier = Modifier,
) {
  val colors = ScottieTheme.colors
  val icon =
    when (typeCode) {
      AccountType.CHEQUING.name -> Icons.Rounded.AccountBalanceWallet
      AccountType.SAVINGS.name -> Icons.Rounded.Savings
      AccountType.CREDIT.name -> Icons.Rounded.CreditCard
      else -> Icons.Rounded.AccountBalance
    }
  val iconTint =
    when {
      highlight -> MaterialTheme.colorScheme.error
      typeCode == AccountType.SAVINGS.name -> colors.statusSuccess
      else -> MaterialTheme.colorScheme.primary
    }
  val iconBackground =
    when {
      highlight -> MaterialTheme.colorScheme.errorContainer
      typeCode == AccountType.SAVINGS.name -> colors.statusSuccessSubtle
      else -> colors.scotiaRedSubtle
    }

  Surface(
    modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
    shape = RoundedCornerShape(14.dp),
    color = colors.surfaceCanvas,
    border =
      BorderStroke(
        width = 1.dp,
        color =
          if (highlight) {
            MaterialTheme.colorScheme.error.copy(alpha = HIGHLIGHT_BORDER_ALPHA)
          } else {
            colors.borderSubtle
          },
      ),
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(14.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
      ) {
        Surface(
          modifier = Modifier.size(34.dp),
          shape = RoundedCornerShape(10.dp),
          color = iconBackground,
        ) {
          Box(contentAlignment = Alignment.Center) {
            Icon(
              imageVector = icon,
              contentDescription = null,
              tint = iconTint,
              modifier = Modifier.size(18.dp),
            )
          }
        }
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            color = colors.textPrimary,
          )
          if (mask.isNotBlank()) {
            Text(
              text = mask,
              style = ScottieCodeSmall,
              color = colors.textSecondary,
            )
          }
        }
        ScottieBadge(
          text = stringResource(BalanceCard.typeLabel(typeCode)),
          tone = if (highlight) ScottieBadgeTone.Error else ScottieBadgeTone.Brand,
        )
      }
      Text(
        text = "$balance $currency",
        style = MaterialTheme.typography.headlineSmall,
        color = colors.textPrimary,
      )
    }
  }
}

private const val HIGHLIGHT_BORDER_ALPHA = 0.45f

@Preview(name = "BalanceCard Light", showBackground = true, widthDp = 360)
@Preview(
  name = "BalanceCard Dark",
  showBackground = true,
  widthDp = 360,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun BalanceCardPreview() {
  ScottieTheme {
    Column(
      modifier = Modifier.background(ScottieTheme.colors.surfaceCard).padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      BalanceCardContent(
        name = "Preferred Package Chequing",
        typeCode = AccountType.CHEQUING.name,
        mask = "•••• 4829",
        balance = "$4,280.50",
        currency = "CAD",
        highlight = false,
      )
      BalanceCardContent(
        name = "Momentum PLUS Savings",
        typeCode = AccountType.SAVINGS.name,
        mask = "•••• 9104",
        balance = "$18,450.00",
        currency = "CAD",
        highlight = false,
      )
    }
  }
}
