package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components

import androidx.a2ui.compose.runtime.A2uiComponentProperties
import androidx.a2ui.compose.runtime.A2uiComponentScope
import androidx.a2ui.compose.runtime.A2uiProperty
import androidx.a2ui.compose.ui.A2uiComponent
import androidx.a2ui.model.schema.A2uiArraySchema
import androidx.a2ui.model.schema.A2uiBooleanSchema
import androidx.a2ui.model.schema.A2uiObjectSchema
import androidx.a2ui.model.schema.A2uiStringSchema
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.xelauikit.XelaBadge
import com.jayvijay.scottie.core.ui.xelauikit.XelaButton
import com.jayvijay.scottie.core.ui.xelauikit.XelaChip
import com.jayvijay.scottie.core.ui.xelauikit.XelaRadioButtonGroup
import com.jayvijay.scottie.core.ui.xelauikit.models.button.XelaButtonState
import com.jayvijay.scottie.core.ui.xelauikit.models.radiobutton.XelaRadioButtonItem
import com.jayvijay.scottie.core.ui.xelauikit.models.radiobutton.XelaRadioButtonSize
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution
import kotlinx.coroutines.delay

/**
 * The send/request form. Every value is path-bound so the user can edit it; the component enforces
 * the spec rules (FR-017/018/019) regardless of what the data model says, and writes [Valid].
 */
object InteracForm : A2uiComponent {
  const val MODE_SEND = "send"
  const val MODE_REQUEST = "request"
  const val EVENT_QUERY = "recipientQuery"
  const val EVENT_SELECT = "selectRecipient"
  const val EVENT_SUBMIT = "submit"

  /** One recipient or account choice as carried in the data model. */
  data class Option(val id: String, val label: String, val detail: String, val autodeposit: Boolean)

  private val Mode =
    A2uiProperty.stringEnum("mode", listOf(MODE_SEND, MODE_REQUEST), required = true)
  private val Amount = A2uiProperty.dynamicString("amount", required = true)
  private val RecipientQuery = A2uiProperty.dynamicString("recipientQuery")
  private val RecipientId = A2uiProperty.dynamicString("recipientId")
  private val ManualEmail = A2uiProperty.dynamicString("manualEmail")
  private val ManualPhone = A2uiProperty.dynamicString("manualPhone")
  private val SaveContact = A2uiProperty.dynamicBoolean("saveContact")
  private val AccountId = A2uiProperty.dynamicString("accountId", required = true)
  private val Channel = A2uiProperty.dynamicString("channel", required = true)
  private val ChannelLocked = A2uiProperty.dynamicBoolean("channelLocked")
  private val SecurityRequired = A2uiProperty.dynamicBoolean("securityRequired")
  private val SecurityQuestion = A2uiProperty.dynamicString("securityQuestion")
  private val SecurityAnswer = A2uiProperty.dynamicString("securityAnswer")
  private val Memo = A2uiProperty.dynamicString("memo")
  private val Valid = A2uiProperty.dynamicBoolean("valid", required = true)
  private val Busy = A2uiProperty.dynamicBoolean("busy")
  private val Suggestions = options("suggestions")
  private val Recipients = options("recipients")
  private val Accounts = options("accounts")
  private val OnQuery = A2uiProperty.action("onQuery")
  private val OnSelectRecipient = A2uiProperty.action("onSelectRecipient")
  private val OnSubmit = A2uiProperty.action("onSubmit", required = true)

  override val name = "InteracForm"
  override val description = "Interac e-Transfer send or request form with built-in validation."
  override val properties: List<A2uiProperty<*>> =
    listOf(
      Mode, Amount, RecipientQuery, RecipientId, ManualEmail, ManualPhone, SaveContact, AccountId,
      Channel, ChannelLocked, SecurityRequired, SecurityQuestion, SecurityAnswer, Memo, Valid, Busy,
      Suggestions, Recipients, Accounts, OnQuery, OnSelectRecipient, OnSubmit,
    )

  @Composable
  override fun A2uiComponentScope.isReady(properties: A2uiComponentProperties): Boolean =
    properties[Mode] != null &&
      properties.bind(Amount) != null &&
      properties.bind(Channel) != null &&
      properties.bind(AccountId) != null &&
      properties.bind(Valid) != null

  @Suppress("LongMethod", "CyclomaticComplexMethod")
  @Composable
  override fun A2uiComponentScope.Content(
    properties: A2uiComponentProperties,
    modifier: Modifier,
  ) {
    val request = properties[Mode] == MODE_REQUEST
    val amount = properties.bind(Amount).orEmpty()
    val query = properties.bind(RecipientQuery).orEmpty()
    val recipientId = properties.bind(RecipientId).orEmpty()
    val email = properties.bind(ManualEmail).orEmpty()
    val phone = properties.bind(ManualPhone).orEmpty()
    val saveContact = properties.bind(SaveContact) ?: false
    val accountId = properties.bind(AccountId).orEmpty()
    val channel = properties.bind(Channel).orEmpty()
    val question = properties.bind(SecurityQuestion).orEmpty()
    val answer = properties.bind(SecurityAnswer).orEmpty()
    val memo = properties.bind(Memo).orEmpty()
    val busy = properties.bind(Busy) ?: false
    val choices =
      properties.bind(Suggestions).orEmpty().ifEmpty { properties.bind(Recipients).orEmpty() }
    val accounts = properties.bind(Accounts).orEmpty()

    val setAmount = properties.bindUpdater(Amount)
    val setQuery = properties.bindUpdater(RecipientQuery)
    val setRecipientId = properties.bindUpdater(RecipientId)
    val setEmail = properties.bindUpdater(ManualEmail)
    val setPhone = properties.bindUpdater(ManualPhone)
    val setSaveContact = properties.bindUpdater(SaveContact)
    val setAccountId = properties.bindUpdater(AccountId)
    val setChannel = properties.bindUpdater(Channel)
    val setQuestion = properties.bindUpdater(SecurityQuestion)
    val setAnswer = properties.bindUpdater(SecurityAnswer)
    val setMemo = properties.bindUpdater(Memo)
    val setValid = properties.bindUpdater(Valid)
    val onQuery = properties[OnQuery]
    val onSelect = properties[OnSelectRecipient]
    val onSubmit = properties[OnSubmit]

    // Rules live here, not in the data model (FR-017/018): no recipient id means manual mode.
    val manual = recipientId.isBlank()
    val oneDestination = email.isNotBlank() != phone.isNotBlank()
    val locked = if (manual) oneDestination else properties.bind(ChannelLocked) ?: false
    val securityRequired = !request && (manual || properties.bind(SecurityRequired) ?: true)
    val showManual = manual && (choices.isEmpty() || query.looksLikeDestination())
    val recipientOk = !manual || email.isNotBlank() || phone.isNotBlank()
    val valid =
      InteracResolution.validateAmount(amount) != null &&
        recipientOk &&
        channel.isNotBlank() &&
        accountId.isNotBlank() &&
        (!securityRequired || (question.isNotBlank() && answer.isNotBlank())) &&
        !busy
    LaunchedEffect(valid) { setValid?.invoke(valid) }

    var typed by remember { mutableStateOf(false) }
    LaunchedEffect(query) {
      if (typed && onQuery != null) {
        delay(QUERY_DEBOUNCE_MS)
        dispatchAction(onQuery)
      }
    }
    fun manualChanged(newEmail: String, newPhone: String) {
      setEmail?.invoke(newEmail)
      setPhone?.invoke(newPhone)
      setChannel?.invoke(
        when {
          newEmail.isNotBlank() && newPhone.isBlank() -> DeliveryChannel.EMAIL.name
          newPhone.isNotBlank() && newEmail.isBlank() -> DeliveryChannel.PHONE.name
          else -> ""
        }
      )
    }

    Column(
      modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Text(
        stringResource(
          if (request) R.string.assistant_form_request_title else R.string.assistant_form_send_title
        ),
        style = MaterialTheme.typography.titleLarge,
      )
      Field(
        R.string.assistant_field_amount,
        amount,
        { setAmount?.invoke(it) },
        KeyboardType.Decimal,
      )
      Field(
        R.string.assistant_field_recipient,
        query,
        {
          typed = true
          setQuery?.invoke(it)
          setRecipientId?.invoke("")
        },
      )
      if (choices.isNotEmpty()) {
        key(recipientId) {
          FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            choices.forEach { option ->
              XelaChip(
                text = option.label,
                selected = option.id == recipientId,
                defaultBorderColor = MaterialTheme.colorScheme.primary,
                selectedBorderColor = MaterialTheme.colorScheme.primary,
                selectedBackgroundColor = MaterialTheme.colorScheme.primary,
                defaultContentColor = MaterialTheme.colorScheme.primary,
                defaultBackgroundColor = MaterialTheme.colorScheme.surface,
                onChangeSelectChipAction = { on ->
                  setRecipientId?.invoke(if (on) option.id else "")
                  if (on && onSelect != null) dispatchAction(onSelect)
                },
              )
            }
          }
        }
      }
      if (showManual) {
        Field(
          R.string.assistant_field_manual_email,
          email,
          { manualChanged(it, phone) },
          KeyboardType.Email,
        )
        Field(
          R.string.assistant_field_manual_phone,
          phone,
          { manualChanged(email, it) },
          KeyboardType.Phone,
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
          Checkbox(checked = saveContact, onCheckedChange = { setSaveContact?.invoke(it) })
          Text(stringResource(R.string.assistant_save_contact))
        }
      }

      Label(
        if (request) R.string.assistant_field_account_deposit
        else R.string.assistant_field_account_source
      )
      key(accountId) {
        XelaRadioButtonGroup(
          items =
            accounts.map { XelaRadioButtonItem(id = it.id, label = it.label, caption = it.detail) },
          onSelectedChange = { setAccountId?.invoke(it.id) },
          size = XelaRadioButtonSize.MEDIUM,
          selectedColor = MaterialTheme.colorScheme.primary,
          labelColor = MaterialTheme.colorScheme.onSurface,
          captionColor = MaterialTheme.colorScheme.onSurfaceVariant,
          selectedItemID = accountId,
        )
      }

      Label(R.string.assistant_channel)
      when {
        locked ->
          Text(stringResource(channelLabel(channel)), style = MaterialTheme.typography.bodyLarge)
        !manual || (email.isNotBlank() && phone.isNotBlank()) ->
          key(channel) {
            XelaRadioButtonGroup(
              items =
                DeliveryChannel.entries.map {
                  XelaRadioButtonItem(id = it.name, label = stringResource(channelLabel(it.name)))
                },
              onSelectedChange = { setChannel?.invoke(it.id) },
              size = XelaRadioButtonSize.MEDIUM,
              selectedColor = MaterialTheme.colorScheme.primary,
              labelColor = MaterialTheme.colorScheme.onSurface,
              selectedItemID = channel,
            )
          }
      }

      if (!request) {
        if (securityRequired) {
          Field(R.string.assistant_field_security_question, question, { setQuestion?.invoke(it) })
          Field(
            R.string.assistant_field_security_answer,
            answer,
            { setAnswer?.invoke(it) },
            secure = true,
          )
        } else {
          val (background, foreground) = Badge.toneColors("success")
          XelaBadge(stringResource(R.string.assistant_badge_autodeposit), background, foreground)
        }
      } else {
        Field(R.string.assistant_field_memo, memo, { setMemo?.invoke(it) })
      }

      XelaButton(
        text =
          stringResource(
            if (request) R.string.assistant_submit_request else R.string.assistant_submit_send
          ),
        onClick = { if (onSubmit != null) dispatchAction(onSubmit) },
        modifier = Modifier.fillMaxWidth(),
        state = if (valid) XelaButtonState.DEFAULT else XelaButtonState.DISABLED,
        background = MaterialTheme.colorScheme.primary,
        foregroundColor = MaterialTheme.colorScheme.onPrimary,
      )
    }
  }

  @Composable
  private fun Field(
    label: Int,
    value: String,
    onChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    secure: Boolean = false,
  ) {
    OutlinedTextField(
      value = value,
      onValueChange = onChange,
      modifier = Modifier.fillMaxWidth(),
      label = { Text(stringResource(label)) },
      singleLine = true,
      keyboardOptions =
        KeyboardOptions(keyboardType = if (secure) KeyboardType.Password else keyboardType),
      visualTransformation =
        if (secure) PasswordVisualTransformation() else VisualTransformation.None,
    )
  }

  @Composable
  private fun Label(text: Int) {
    Text(
      stringResource(text),
      style = MaterialTheme.typography.titleSmall,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
  }

  private fun channelLabel(code: String) =
    if (code == DeliveryChannel.PHONE.name) R.string.assistant_channel_sms
    else R.string.assistant_channel_email

  private fun String.looksLikeDestination() =
    '@' in this || count { it.isDigit() } >= DESTINATION_MIN_DIGITS

  private fun options(key: String) =
    A2uiProperty.dynamicCustom(
      key = key,
      schema =
        A2uiArraySchema(
          items =
            A2uiObjectSchema(
              properties =
                mapOf(
                  "id" to A2uiStringSchema(),
                  "label" to A2uiStringSchema(),
                  "detail" to A2uiStringSchema(),
                  "autodeposit" to A2uiBooleanSchema(),
                ),
              required = setOf("id", "label"),
            )
        ),
      safeCast = { raw ->
        (raw as? List<*>)?.mapNotNull { item ->
          val map = item as? Map<*, *> ?: return@mapNotNull null
          Option(
            id = map["id"] as? String ?: return@mapNotNull null,
            label = map["label"] as? String ?: return@mapNotNull null,
            detail = map["detail"] as? String ?: "",
            autodeposit = map["autodeposit"] as? Boolean ?: false,
          )
        }
      },
    )

  private const val QUERY_DEBOUNCE_MS = 150L
  private const val DESTINATION_MIN_DIGITS = 7
}
