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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jayvijay.scottie.R
import com.jayvijay.scottie.core.ui.ScottieCodeSmall
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.core.ui.components.ScottieBadge
import com.jayvijay.scottie.core.ui.components.ScottieBadgeTone
import com.jayvijay.scottie.core.ui.components.ScottieButton
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.InteracForm.Valid
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
      Mode,
      Amount,
      RecipientQuery,
      RecipientId,
      ManualEmail,
      ManualPhone,
      SaveContact,
      AccountId,
      Channel,
      ChannelLocked,
      SecurityRequired,
      SecurityQuestion,
      SecurityAnswer,
      Memo,
      Valid,
      Busy,
      Suggestions,
      Recipients,
      Accounts,
      OnQuery,
      OnSelectRecipient,
      OnSubmit,
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
    val colors = ScottieTheme.colors
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
      modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      Box(
        modifier =
          Modifier.fillMaxWidth()
            .height(3.dp)
            .clip(RoundedCornerShape(999.dp))
            .background(if (request) colors.statusSuccess else colors.interacGold)
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        Text(
          text =
            stringResource(
              if (request) R.string.assistant_form_request_title
              else R.string.assistant_form_send_title
            ),
          style = MaterialTheme.typography.titleLarge,
          color = colors.textPrimary,
        )
        ScottieBadge(
          text = "INTERAC",
          tone = if (request) ScottieBadgeTone.Brand else ScottieBadgeTone.Warning,
        )
      }

      Field(
        label = R.string.assistant_field_amount,
        value = amount,
        onChange = { setAmount?.invoke(it) },
        keyboardType = KeyboardType.Decimal,
      )
      Field(
        label = R.string.assistant_field_recipient,
        value = query,
        onChange = {
          typed = true
          setQuery?.invoke(it)
          setRecipientId?.invoke("")
        },
      )
      if (choices.isNotEmpty()) {
        key(recipientId) {
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
          ) {
            choices.forEach { option ->
              val selected = option.id == recipientId
              FilterChip(
                selected = selected,
                onClick = {
                  val next = !selected
                  setRecipientId?.invoke(if (next) option.id else "")
                  if (next && onSelect != null) dispatchAction(onSelect)
                },
                label = {
                  Text(
                    text = option.label,
                    style = MaterialTheme.typography.labelLarge,
                  )
                },
                leadingIcon =
                  if (selected) {
                    {
                      Icon(
                        imageVector = Icons.Rounded.Check,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                      )
                    }
                  } else {
                    null
                  },
                shape = RoundedCornerShape(999.dp),
                colors =
                  FilterChipDefaults.filterChipColors(
                    containerColor = colors.surfaceCanvas,
                    labelColor = colors.textPrimary,
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
                  ),
                border =
                  FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = selected,
                    borderColor = colors.borderSubtle,
                    selectedBorderColor = MaterialTheme.colorScheme.primary,
                  ),
              )
            }
          }
        }
      }
      if (showManual) {
        Field(
          label = R.string.assistant_field_manual_email,
          value = email,
          onChange = { manualChanged(it, phone) },
          keyboardType = KeyboardType.Email,
        )
        Field(
          label = R.string.assistant_field_manual_phone,
          value = phone,
          onChange = { manualChanged(email, it) },
          keyboardType = KeyboardType.Phone,
        )
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier =
            Modifier.clip(RoundedCornerShape(8.dp))
              .clickable { setSaveContact?.invoke(!saveContact) }
              .padding(vertical = 2.dp),
        ) {
          Checkbox(
            checked = saveContact,
            onCheckedChange = { setSaveContact?.invoke(it) },
            colors =
              CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = colors.textTertiary,
              ),
          )
          Text(
            text = stringResource(R.string.assistant_save_contact),
            style = MaterialTheme.typography.bodyMedium,
            color = colors.textPrimary,
          )
        }
      }

      Label(
        if (request) R.string.assistant_field_account_deposit
        else R.string.assistant_field_account_source
      )
      key(accountId) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          accounts.forEach { option ->
            AccountChoiceRow(
              option = option,
              selected = option.id == accountId,
              onSelect = { setAccountId?.invoke(option.id) },
            )
          }
        }
      }

      Label(R.string.assistant_channel)
      when {
        locked ->
          Surface(
            color = colors.surfaceCanvas,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, colors.borderSubtle),
          ) {
            Text(
              text = stringResource(channelLabel(channel)),
              style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
              color = colors.textPrimary,
              modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            )
          }
        !manual || (email.isNotBlank() && phone.isNotBlank()) ->
          key(channel) {
            ChannelSelector(
              selectedChannel = channel,
              onSelect = { setChannel?.invoke(it) },
            )
          }
      }

      if (!request) {
        if (securityRequired) {
          Field(
            label = R.string.assistant_field_security_question,
            value = question,
            onChange = { setQuestion?.invoke(it) },
          )
          Field(
            label = R.string.assistant_field_security_answer,
            value = answer,
            onChange = { setAnswer?.invoke(it) },
            secure = true,
          )
        } else {
          Surface(
            color = colors.statusSuccessSubtle,
            shape = RoundedCornerShape(12.dp),
            border =
              BorderStroke(1.dp, colors.statusSuccess.copy(alpha = AUTODEPOSIT_BORDER_ALPHA)),
          ) {
            Row(
              modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
              Icon(
                imageVector = Icons.Rounded.VerifiedUser,
                contentDescription = null,
                tint = colors.statusSuccess,
                modifier = Modifier.size(18.dp),
              )
              Text(
                text = stringResource(R.string.assistant_badge_autodeposit),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                color = colors.statusSuccess,
              )
            }
          }
        }
      } else {
        Field(
          label = R.string.assistant_field_memo,
          value = memo,
          onChange = { setMemo?.invoke(it) },
        )
      }

      ScottieButton(
        text =
          stringResource(
            if (request) R.string.assistant_submit_request else R.string.assistant_submit_send
          ),
        onClick = { if (onSubmit != null) dispatchAction(onSubmit) },
        modifier = Modifier.fillMaxWidth(),
        enabled = valid,
      )
    }
  }

  @Composable
  internal fun Field(
    label: Int,
    value: String,
    onChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    secure: Boolean = false,
  ) {
    val colors = ScottieTheme.colors
    OutlinedTextField(
      value = value,
      onValueChange = onChange,
      modifier = Modifier.fillMaxWidth(),
      label = { Text(stringResource(label)) },
      singleLine = true,
      shape = RoundedCornerShape(12.dp),
      colors =
        OutlinedTextFieldDefaults.colors(
          focusedBorderColor = MaterialTheme.colorScheme.primary,
          unfocusedBorderColor = colors.borderSubtle,
          focusedContainerColor = colors.surfaceCanvas,
          unfocusedContainerColor = colors.surfaceCanvas,
        ),
      keyboardOptions =
        KeyboardOptions(keyboardType = if (secure) KeyboardType.Password else keyboardType),
      visualTransformation =
        if (secure) PasswordVisualTransformation() else VisualTransformation.None,
    )
  }

  @Composable
  internal fun Label(text: Int) {
    Text(
      text = stringResource(text),
      style = MaterialTheme.typography.labelLarge,
      color = ScottieTheme.colors.textSecondary,
    )
  }

  internal fun channelLabel(code: String) =
    if (code == DeliveryChannel.PHONE.name) R.string.assistant_channel_sms
    else R.string.assistant_channel_email

  private fun String.looksLikeDestination() =
    '@' in this || count { it.isDigit() } >= DESTINATION_MIN_DIGITS

  private fun options(key: String) =
    A2uiProperty.dynamicCustom(
      key = key,
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
                            "label" to A2uiStringSchema(),
                            "detail" to A2uiStringSchema(),
                            "autodeposit" to A2uiBooleanSchema(),
                          ),
                        required = setOf("id", "label"),
                      )
                  ),
                )
              )
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
  private const val AUTODEPOSIT_BORDER_ALPHA = 0.3f
}

@Composable
internal fun AccountChoiceRow(
  option: InteracForm.Option,
  selected: Boolean,
  onSelect: () -> Unit,
  modifier: Modifier = Modifier,
) {
  val colors = ScottieTheme.colors
  Surface(
    modifier =
      modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .selectable(selected = selected, role = Role.RadioButton, onClick = onSelect),
    shape = RoundedCornerShape(12.dp),
    color = if (selected) colors.scotiaRedSubtle else colors.surfaceCanvas,
    border =
      BorderStroke(
        width = 1.dp,
        color =
          if (selected) {
            MaterialTheme.colorScheme.primary.copy(alpha = SELECTED_ACCOUNT_BORDER_ALPHA)
          } else {
            colors.borderSubtle
          },
      ),
  ) {
    Row(
      modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      RadioButton(
        selected = selected,
        onClick = null,
        colors =
          RadioButtonDefaults.colors(
            selectedColor = MaterialTheme.colorScheme.primary,
            unselectedColor = colors.textTertiary,
          ),
      )
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = option.label,
          style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
          color = colors.textPrimary,
        )
        if (option.detail.isNotBlank()) {
          Text(
            text = option.detail,
            style = ScottieCodeSmall,
            color = colors.textSecondary,
          )
        }
      }
    }
  }
}

private const val SELECTED_ACCOUNT_BORDER_ALPHA = 0.45f

@Composable
internal fun ChannelSelector(
  selectedChannel: String,
  onSelect: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val colors = ScottieTheme.colors
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    DeliveryChannel.entries.forEach { entry ->
      val selected = entry.name == selectedChannel
      Surface(
        modifier =
          Modifier.weight(1f)
            .clip(RoundedCornerShape(12.dp))
            .selectable(
              selected = selected,
              role = Role.RadioButton,
              onClick = { onSelect(entry.name) },
            ),
        shape = RoundedCornerShape(12.dp),
        color = if (selected) MaterialTheme.colorScheme.primary else colors.surfaceCanvas,
        border =
          BorderStroke(
            width = 1.dp,
            color = if (selected) MaterialTheme.colorScheme.primary else colors.borderSubtle,
          ),
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
        ) {
          if (selected) {
            Box(
              modifier =
                Modifier.size(6.dp)
                  .clip(CircleShape)
                  .background(MaterialTheme.colorScheme.onPrimary)
            )
          }
          Text(
            text = stringResource(InteracForm.channelLabel(entry.name)),
            style = MaterialTheme.typography.labelLarge,
            color = if (selected) MaterialTheme.colorScheme.onPrimary else colors.textPrimary,
          )
        }
      }
    }
  }
}

@Preview(name = "InteracForm Controls Light", showBackground = true, widthDp = 360)
@Preview(
  name = "InteracForm Controls Dark",
  showBackground = true,
  widthDp = 360,
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun InteracFormPreview() {
  ScottieTheme {
    Column(
      modifier = Modifier.background(ScottieTheme.colors.surfaceCard).padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      AccountChoiceRow(
        option =
          InteracForm.Option(
            id = "cheq",
            label = "Preferred Package Chequing",
            detail = "$4,280.50 CAD •••• 4829",
            autodeposit = true,
          ),
        selected = true,
        onSelect = {},
      )
      ChannelSelector(
        selectedChannel = DeliveryChannel.EMAIL.name,
        onSelect = {},
      )
      ScottieButton(
        text = "Send transfer",
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
      )
    }
  }
}
