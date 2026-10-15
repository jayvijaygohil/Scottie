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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
      Kind,
      StatusCode,
      Reference,
      Amount,
      Party,
      ChannelCode,
      Destination,
      Account,
      Time,
      Memo,
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

    ConfirmationReceiptContent(
      request = request,
      status = status,
      reference = properties.bind(Reference).orEmpty(),
      amount = properties.bind(Amount).orEmpty(),
      party = properties.bind(Party).orEmpty(),
      channel = channel,
      destination = properties.bind(Destination).orEmpty(),
      account = properties.bind(Account).orEmpty(),
      time = properties.bind(Time).orEmpty(),
      memo = memo,
      modifier = modifier,
    )
  }

  internal fun statusLabel(code: String) =
    when (code) {
      TransferStatus.SENT.name -> R.string.assistant_status_sent
      TransferStatus.PENDING_SECURITY_ANSWER.name -> R.string.assistant_status_pending
      else -> R.string.assistant_status_request_sent
    }

  internal fun channelLabel(code: String) =
    if (code == DeliveryChannel.PHONE.name) R.string.assistant_channel_sms
    else R.string.assistant_channel_email
}

@Composable
internal fun ConfirmationReceiptContent(
  request: Boolean,
  status: String,
  reference: String,
  amount: String,
  party: String,
  channel: String,
  destination: String,
  account: String,
  time: String,
  memo: String?,
  modifier: Modifier = Modifier,
) {
  val colors = ScottieTheme.colors
  Column(
    modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        Surface(
          modifier = Modifier.size(28.dp),
          shape = CircleShape,
          color = colors.statusSuccessSubtle,
        ) {
          Box(contentAlignment = Alignment.Center) {
            Icon(
              imageVector = Icons.Rounded.CheckCircle,
              contentDescription = null,
              tint = colors.statusSuccess,
              modifier = Modifier.size(18.dp),
            )
          }
        }
        ScottieBadge(
          text = stringResource(Confirmation.statusLabel(status)),
          tone = ScottieBadgeTone.Success,
        )
      }
    }

    Surface(
      color = colors.surfaceCanvas,
      shape = RoundedCornerShape(14.dp),
      border = BorderStroke(1.dp, colors.borderSubtle),
    ) {
      Column(
        modifier = Modifier.fillMaxWidth().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
      ) {
        ReceiptLine(
          label = R.string.assistant_conf_reference,
          value = reference,
          monospace = true,
        )
        ReceiptLine(
          label = R.string.assistant_conf_amount,
          value = amount,
          emphasize = true,
        )
        ReceiptLine(
          label =
            if (request) R.string.assistant_conf_requestee else R.string.assistant_conf_recipient,
          value = party,
        )
        ReceiptLine(
          label = R.string.assistant_conf_channel,
          value = stringResource(Confirmation.channelLabel(channel)),
        )
        ReceiptLine(
          label = Confirmation.channelLabel(channel),
          value = destination,
        )
        ReceiptLine(
          label =
            if (request) R.string.assistant_conf_account_deposit
            else R.string.assistant_conf_account_source,
          value = account,
        )
        if (memo != null) {
          ReceiptLine(label = R.string.assistant_conf_memo, value = memo)
        }
        ReceiptLine(
          label = R.string.assistant_conf_time,
          value = time,
          showDivider = false,
        )
      }
    }
  }
}

@Composable
private fun ReceiptLine(
  label: Int,
  value: String,
  monospace: Boolean = false,
  emphasize: Boolean = false,
  showDivider: Boolean = true,
) {
  val colors = ScottieTheme.colors
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = stringResource(label),
      style = MaterialTheme.typography.bodyMedium,
      color = colors.textSecondary,
    )
    Text(
      text = value,
      style =
        when {
          monospace -> ScottieCodeSmall.copy(fontWeight = FontWeight.SemiBold)
          emphasize -> MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
          else -> MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
        },
      color = colors.textPrimary,
    )
  }
  if (showDivider) {
    HorizontalDivider(color = colors.borderSubtle, modifier = Modifier.padding(top = 8.dp))
  }
}

@Preview(name = "Confirmation Light", showBackground = true, widthDp = 360)
@Preview(
  name = "Confirmation Dark",
  showBackground = true,
  widthDp = 360,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ConfirmationPreview() {
  ScottieTheme {
    Box(modifier = Modifier.background(ScottieTheme.colors.surfaceCard).padding(16.dp)) {
      ConfirmationReceiptContent(
        request = false,
        status = TransferStatus.SENT.name,
        reference = "SCT-948201",
        amount = "$125.00 CAD",
        party = "Maya Lin",
        channel = DeliveryChannel.EMAIL.name,
        destination = "maya.lin@example.ca",
        account = "Preferred Package Chequing (•••• 4829)",
        time = "Oct 14, 2:45 PM",
        memo = "Dinner split",
      )
    }
  }
}
