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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.xelauikit.XelaBadge
import com.jayvijay.scottie.core.ui.xelauikit.XelaDivider
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TransferStatus

object Confirmation : A2uiComponent {
  private val Kind = A2uiProperty.stringEnum("kind", listOf("send", "request"), required = true)
  private val StatusCode = A2uiProperty.dynamicString("statusCode", required = true)
  private val Reference = A2uiProperty.dynamicString("reference", required = true)
  private val Amount = A2uiProperty.dynamicString("amount", required = true)
  private val Party = A2uiProperty.dynamicString("party", required = true)
  private val ChannelCode = A2uiProperty.dynamicString("channelCode", required = true)
  private val Destination = A2uiProperty.dynamicString("destination", required = true)
  private val Account = A2uiProperty.dynamicString("account", required = true)
  private val Time = A2uiProperty.dynamicString("time", required = true)
  private val Memo = A2uiProperty.dynamicString("memo")

  override val name = "Confirmation"
  override val description = "Result of a completed send or request."
  override val properties: List<A2uiProperty<*>> =
    listOf(
      Kind, StatusCode, Reference, Amount, Party, ChannelCode, Destination, Account, Time, Memo,
    )

  @Composable
  override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean =
    properties.bind(Reference) != null && properties.bind(StatusCode) != null

  @Composable
  override fun A2uiComponentScope.Content(
    properties: A2uiComponentProperties,
    modifier: Modifier,
  ) {
    val request = properties[Kind] == "request"
    val status = properties.bind(StatusCode) ?: return
    val channel = properties.bind(ChannelCode).orEmpty()
    val memo = properties.bind(Memo)
    val (background, foreground) = Badge.toneColors("success")
    Column(
      modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      XelaBadge(stringResource(statusLabel(status)), background, foreground)
      Line(R.string.assistant_conf_reference, properties.bind(Reference).orEmpty())
      Line(R.string.assistant_conf_amount, properties.bind(Amount).orEmpty())
      Line(
        if (request) R.string.assistant_conf_requestee else R.string.assistant_conf_recipient,
        properties.bind(Party).orEmpty(),
      )
      Line(R.string.assistant_conf_channel, stringResource(channelLabel(channel)))
      Line(channelLabel(channel), properties.bind(Destination).orEmpty())
      Line(
        if (request) R.string.assistant_conf_account_deposit
        else R.string.assistant_conf_account_source,
        properties.bind(Account).orEmpty(),
      )
      if (memo != null) Line(R.string.assistant_conf_memo, memo)
      Line(R.string.assistant_conf_time, properties.bind(Time).orEmpty())
    }
  }

  @Composable
  private fun Line(label: Int, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      Text(
        stringResource(label),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      Text(value, style = MaterialTheme.typography.bodyMedium)
    }
    XelaDivider(color = MaterialTheme.colorScheme.outlineVariant)
  }

  private fun statusLabel(code: String) =
    when (code) {
      TransferStatus.SENT.name -> R.string.assistant_status_sent
      TransferStatus.PENDING_SECURITY_ANSWER.name -> R.string.assistant_status_pending
      else -> R.string.assistant_status_request_sent
    }

  private fun channelLabel(code: String) =
    if (code == DeliveryChannel.PHONE.name) R.string.assistant_channel_sms
    else R.string.assistant_channel_email
}
