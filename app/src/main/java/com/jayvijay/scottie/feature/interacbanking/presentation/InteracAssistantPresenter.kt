package com.jayvijay.scottie.feature.interacbanking.presentation

import android.util.Log
import androidx.a2ui.model.protocol.A2uiClientErrorMessage
import androidx.a2ui.model.protocol.A2uiClientEventMessage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jayvijay.scottie.feature.interacbanking.domain.agent.tools.InteracBankingTools
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.ChannelHint
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.Intent
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceException
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.IntentExtractor
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.SpeechTranscriber
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.DeliveryChannel
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Recipient
import com.jayvijay.scottie.feature.interacbanking.domain.repository.AudioRecorder
import com.jayvijay.scottie.feature.interacbanking.domain.repository.TextModelSource
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.ContactMatcher
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.TransactionInsights
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.A2uiBridge
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.A2uiBridgeFactory
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplates
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplates.ConfirmationData
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplates.FormSeed
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.InteracForm
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.retained.rememberRetained
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.components.SingletonComponent
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.JsonPrimitive

@Suppress("TooManyFunctions") // Intent resolution, templating, and event handling for one screen.
class InteracAssistantPresenter
@AssistedInject
constructor(
  @Assisted private val navigator: Navigator,
  private val extractor: IntentExtractor,
  private val banking: InteracBankingTools,
  private val bridgeFactory: A2uiBridgeFactory,
  private val source: TextModelSource,
  private val recorder: AudioRecorder,
  private val transcriber: SpeechTranscriber,
  private val settings: ModelSettingsDestination,
) : Presenter<InteracAssistantState> {

  @Composable
  override fun present(): InteracAssistantState {
    var turns by rememberRetained { mutableStateOf(emptyList<AssistantTurn>()) }
    var input by rememberRetained { mutableStateOf("") }
    var busy by rememberRetained { mutableStateOf(false) }
    var voiceState by remember { mutableStateOf(VoiceState.Idle) }
    var voiceError by rememberRetained { mutableStateOf<VoiceError?>(null) }
    val bridge = rememberRetained { bridgeFactory.create() }
    val startedAt = rememberRetained { mutableMapOf<String, Long>() }
    val surfaces by bridge.surfaces.collectAsState()
    val active by source.active.collectAsState(initial = null)
    val activeAudio by source.activeAudio.collectAsState(initial = null)
    val scope = rememberCoroutineScope()

    DisposableEffect(Unit) { onDispose { recorder.cancel() } }

    LaunchedEffect(activeAudio) {
      if (activeAudio == null && voiceState == VoiceState.Recording) {
        recorder.cancel()
        voiceState = VoiceState.Idle
      }
    }

    fun update(surfaceId: String, reply: TurnReply) {
      turns = turns.map { if (it.surfaceId == surfaceId) it.copy(reply = reply) else it }
    }

    LaunchedEffect(surfaces) {
      val now = System.currentTimeMillis()
      turns = turns.map { turn ->
        val shown = turn.reply is TurnReply.Surface && surfaces.any { it.id == turn.surfaceId }
        if (!shown || turn.firstCardMs != null) return@map turn
        val ms = now - (startedAt[turn.surfaceId] ?: now)
        Log.i(TAG, "first_card_ms=$ms")
        turn.copy(firstCardMs = ms)
      }
    }

    LaunchedEffect(bridge) {
      bridge.events.collect { event ->
        when (event) {
          is A2uiClientErrorMessage -> {
            Log.w(TAG, "a2ui error ${event.code}: ${event.message}")
            bridge.accept(InteracSurfaceTemplates.deleteSurface(event.surfaceId))
            update(event.surfaceId, TurnReply.Fallback)
            busy = false
          }
          is A2uiClientEventMessage -> {
            if (event.type == InteracForm.EVENT_SUBMIT) busy = true
            runCatching { onEvent(event, bridge) }
              .onFailure {
                bridge.accept(InteracSurfaceTemplates.deleteSurface(event.surfaceId))
                update(event.surfaceId, TurnReply.Fallback)
              }
            busy = false
          }
        }
      }
    }

    return InteracAssistantState(
      activeModelId = active,
      turns = turns,
      input = input,
      busy = busy,
      missingModel = active == null,
      surfaces = surfaces,
      activeAudioModelId = activeAudio,
      voiceState = voiceState,
      voiceError = voiceError,
    ) { action ->
      val idle = !busy && voiceState == VoiceState.Idle
      when (action) {
        is InteracAssistantAction.InputChanged -> input = action.text
        InteracAssistantAction.ClearChat -> {
          if (!idle || (turns.isEmpty() && input.isBlank())) return@InteracAssistantState
          (turns.map { it.surfaceId } + surfaces.map { it.id }).distinct().forEach {
            runCatching { bridge.accept(InteracSurfaceTemplates.deleteSurface(it)) }
          }
          turns = emptyList()
          input = ""
          startedAt.clear()
        }
        InteracAssistantAction.OpenSettings -> {
          if (voiceState == VoiceState.Recording) {
            recorder.cancel()
            voiceState = VoiceState.Idle
          }
          navigator.goTo(settings.screen())
        }
        InteracAssistantAction.CancelRecording -> {
          if (voiceState == VoiceState.Recording) {
            recorder.cancel()
            voiceState = VoiceState.Idle
          }
        }
        InteracAssistantAction.MicrophonePermissionDenied -> {
          voiceError = VoiceError.PermissionDenied
        }
        InteracAssistantAction.DismissVoiceError -> {
          voiceError = null
        }
        InteracAssistantAction.ToggleRecording -> {
          when (voiceState) {
            VoiceState.Idle -> {
              if (busy || activeAudio == null) return@InteracAssistantState
              voiceError = null
              scope.launch {
                runCatching { recorder.start() }
                  .onSuccess { voiceState = VoiceState.Recording }
                  .onFailure {
                    if (it is CancellationException) throw it
                    Log.w(TAG, "record start failed", it)
                    recorder.cancel()
                    voiceState = VoiceState.Idle
                    voiceError = VoiceError.Failed(InferenceFailure.UNKNOWN)
                  }
              }
            }
            VoiceState.Recording -> {
              val audioModelId = activeAudio
              if (audioModelId == null) {
                recorder.cancel()
                voiceState = VoiceState.Idle
                return@InteracAssistantState
              }
              voiceState = VoiceState.Transcribing
              scope.launch {
                val wavBytes = runCatching {
                  recorder.stop()
                }
                  .getOrElse {
                    if (it is CancellationException) throw it
                    Log.w(TAG, "record stop failed", it)
                    recorder.cancel()
                    voiceState = VoiceState.Idle
                    voiceError = VoiceError.Failed(InferenceFailure.UNKNOWN)
                    return@launch
                  }
                runCatching { transcriber.transcribe(wavBytes, audioModelId) }
                  .onSuccess { raw ->
                    val transcript = raw.trim()
                    if (transcript.isNotEmpty()) {
                      input = appendTranscript(input, transcript)
                    }
                    voiceState = VoiceState.Idle
                  }
                  .onFailure {
                    if (it is CancellationException) throw it
                    Log.w(TAG, "transcription failed", it)
                    val failure = (it as? InferenceException)?.failure ?: InferenceFailure.UNKNOWN
                    voiceError = VoiceError.Failed(failure)
                    voiceState = VoiceState.Idle
                  }
              }
            }
            VoiceState.Transcribing -> Unit
          }
        }
        InteracAssistantAction.Send -> {
          val text = input.trim()
          val modelId = active
          if (!idle || text.isEmpty() || modelId == null) return@InteracAssistantState
          val turn = AssistantTurn(turns.size + 1, text, TurnReply.Thinking)
          input = ""
          busy = true
          turns = turns + turn
          startedAt[turn.surfaceId] = System.currentTimeMillis()
          scope.launch {
            val reply = runCatching {
              respond(text, modelId, turn.surfaceId, bridge)
            }
              .getOrElse {
                if (it is CancellationException) throw it
                Log.w(TAG, "turn failed", it)
                TurnReply.Fallback
              }
            update(turn.surfaceId, reply)
            busy = false
          }
        }
      }
    }
  }

  private suspend fun respond(
    text: String,
    modelId: String,
    surfaceId: String,
    bridge: A2uiBridge,
  ): TurnReply {
    // FR-015: inference failures get their own reply; building the surface may still fall back.
    val intent = runCatching {
      extractor.extract(text, modelId)
    }
      .getOrElse {
        if (it is CancellationException) throw it
        Log.w(TAG, "inference failed", it)
        return TurnReply.Failed((it as? InferenceException)?.failure ?: InferenceFailure.UNKNOWN)
      }
    val lines =
      when (intent.intent) {
        Intent.OTHER -> null
        Intent.BALANCE -> balanceLines(intent.accountHint, surfaceId)
        Intent.SEND -> sendLines(intent, surfaceId)
        Intent.REQUEST -> requestLines(intent, surfaceId)
        Intent.TRANSACTIONS -> transactionLines(intent, surfaceId)
      }
    return if (lines == null) {
      TurnReply.Text(intent.reply)
    } else {
      lines.forEach(bridge::accept)
      TurnReply.Surface(surfaceId)
    }
  }

  private suspend fun transactionLines(intent: AssistantIntent, surfaceId: String): List<String> {
    val (accounts, transactions) = banking { getAccountBalances() to getTransactions() }
    val result = TransactionInsights.evaluate(intent, transactions, accounts)
    return InteracSurfaceTemplates.transactionResults(surfaceId, result)
  }

  private suspend fun balanceLines(hint: String?, surfaceId: String): List<String> {
    val all = banking { getAccountBalances() }
    val matches = InteracResolution.matchAccounts(hint, all)
    return if (matches.isNotEmpty()) {
      InteracSurfaceTemplates.balanceCards(surfaceId, matches)
    } else {
      val notice = Notice.AccountNotFound(hint.orEmpty().trim())
      InteracSurfaceTemplates.balanceCards(surfaceId, all, notice = notice)
    }
  }

  private suspend fun sendLines(intent: AssistantIntent, surfaceId: String): List<String> {
    val all = banking { getAccountBalances() }
    val amount = intent.amount
    val named = InteracResolution.matchAccounts(intent.accountHint, all).singleOrNull()
    val eligible = InteracResolution.eligibleSources(all, amount)
    val others = eligible.filter { it.accountId != named?.accountId }
    return when {
      named != null && amount != null && amount > named.availableBalance ->
        InteracSurfaceTemplates.balanceCards(
          surfaceId,
          listOf(named) + others,
          noticeText = banking.insufficientBalanceMessage(named, amount),
          highlightId = named.accountId,
        )
      named == null && amount != null && eligible.isEmpty() ->
        InteracSurfaceTemplates.balanceCards(
          surfaceId,
          all,
          notice = Notice.NoAccountCovers(InteracSurfaceTemplates.money(amount)),
        )
      else -> {
        val accounts = if (named != null) listOf(named) + others else eligible
        formLines(InteracForm.MODE_SEND, intent, surfaceId, accounts, named?.accountId)
      }
    }
  }

  private suspend fun requestLines(intent: AssistantIntent, surfaceId: String): List<String> {
    val all = banking { getAccountBalances() }
    val named = InteracResolution.matchAccounts(intent.accountHint, all).singleOrNull()
    val deposits = InteracResolution.eligibleDeposits(all)
    val others = deposits.filter { it.accountId != named?.accountId }
    val accounts = if (named != null) listOf(named) + others else deposits
    return formLines(InteracForm.MODE_REQUEST, intent, surfaceId, accounts, named?.accountId)
  }

  private suspend fun formLines(
    mode: String,
    intent: AssistantIntent,
    surfaceId: String,
    accounts: List<Account>,
    accountId: String?,
  ): List<String> {
    val who = recipients(intent.recipientQuery)
    val contact = who.preselected
    val hinted =
      intent.channelHint?.let {
        if (it == ChannelHint.SMS) DeliveryChannel.PHONE else DeliveryChannel.EMAIL
      }
    val channels = who.channels()
    val locked = channels.size == 1
    val channel = initialChannel(channels, if (contact != null) hinted else null)
    // FR-017: never guess; an explicit channel the contact lacks surfaces the service's reason.
    val unavailable = contact != null && hinted != null && hinted !in channels
    val alert = if (unavailable) probe(mode, intent, contact, accounts, hinted) else null
    val seed =
      FormSeed(
        mode = mode,
        amount = intent.amount?.let(InteracSurfaceTemplates::money).orEmpty(),
        recipientQuery = contact?.name ?: intent.recipientQuery.orEmpty(),
        recipientId = contact?.contactId,
        manualEmail = who.manualEmail,
        manualPhone = who.manualPhone,
        recipients = who.options,
        accounts = accounts,
        accountId = accountId,
        channel = channel,
        channelLocked = locked,
        securityRequired = mode == InteracForm.MODE_SEND && contact?.autodepositEnabled != true,
        memo = intent.memo,
      )
    return InteracSurfaceTemplates.form(surfaceId, seed, alertText = alert)
  }

  private fun initialChannel(channels: List<DeliveryChannel>, hinted: DeliveryChannel?) =
    when {
      channels.size == 1 -> channels.single().name
      hinted != null && hinted in channels -> hinted.name
      else -> ""
    }

  /** The service rejects at `destinationFor` before any state change; its message is the alert. */
  private suspend fun probe(
    mode: String,
    intent: AssistantIntent,
    contact: InteracContact,
    accounts: List<Account>,
    channel: DeliveryChannel,
  ): String? {
    val accountId = accounts.firstOrNull()?.accountId ?: return null
    val amount = intent.amount ?: PROBE_AMOUNT
    val recipient = Recipient.Saved(contact.contactId)
    return banking {
      runCatching {
        if (mode == InteracForm.MODE_SEND) {
          executeSendTransfer(accountId, recipient, amount, channel)
        } else {
          executeRequestMoney(recipient, accountId, amount, channel, intent.memo)
        }
      }
        .exceptionOrNull()
        ?.message
    }
  }

  private suspend fun recipients(query: String?): RecipientSeed {
    val q = query?.trim().orEmpty()
    val found = banking { findContacts(q.ifEmpty { null }) }
    val email = q.takeIf { '@' in it }
    val phone = q.takeIf { email == null && it.count(Char::isDigit) >= MANUAL_PHONE_DIGITS }
    val ranked = found.map { it to ContactMatcher.contactScore(q, it) }
    return when {
      q.isEmpty() -> RecipientSeed(found)
      found.isEmpty() -> RecipientSeed(found, manualEmail = email, manualPhone = phone)
      else -> RecipientSeed(found, preselected = InteracResolution.clearMatch(ranked))
    }
  }

  private suspend fun onEvent(event: A2uiClientEventMessage, bridge: A2uiBridge) {
    val id = event.surfaceId
    when (event.type) {
      InteracForm.EVENT_QUERY -> {
        val started = System.currentTimeMillis()
        val found = banking { findContacts(event.context["query"] as? String) }
        val value = InteracSurfaceTemplates.contacts(found)
        bridge.accept(InteracSurfaceTemplates.updateData(id, "/suggestions", value))
        Log.i(TAG, "suggest_ms=${System.currentTimeMillis() - started}")
      }
      InteracForm.EVENT_SELECT -> {
        val contactId = event.context["id"] as? String ?: return
        val contact = banking { findContacts() }.find { it.contactId == contactId } ?: return
        val channels = contact.channels()
        val single = channels.singleOrNull()
        bridge.accept(updateForm(id, "channel", JsonPrimitive(single?.name.orEmpty())))
        bridge.accept(updateForm(id, "channelLocked", JsonPrimitive(single != null)))
        val security = JsonPrimitive(!contact.autodepositEnabled)
        bridge.accept(updateForm(id, "securityRequired", security))
      }
      InteracForm.EVENT_SUBMIT -> submit(event, bridge)
    }
  }

  private suspend fun submit(event: A2uiClientEventMessage, bridge: A2uiBridge) {
    val id = event.surfaceId
    val draft = FormDraft.from(event.context)
    if (draft == null) {
      bridge.accept(updateForm(id, "busy", JsonPrimitive(false)))
      return
    }
    bridge.accept(updateForm(id, "busy", JsonPrimitive(true)))
    val result = banking { runCatching { perform(draft) } }
    result
      .onSuccess { confirmation ->
        bridge.accept(InteracSurfaceTemplates.deleteSurface(id))
        InteracSurfaceTemplates.confirmation(id, confirmation).forEach(bridge::accept)
      }
      .onFailure { e ->
        if (e !is IllegalArgumentException) throw e
        bridge.accept(InteracSurfaceTemplates.alertAboveForm(id, e.message.orEmpty()))
        bridge.accept(updateForm(id, "busy", JsonPrimitive(false)))
      }
  }

  /** Runs on the banking dispatcher; never retries (FR-022); saves the contact only on success. */
  private fun perform(draft: FormDraft): ConfirmationData {
    val recipient =
      if (draft.recipientId.isNotBlank()) Recipient.Saved(draft.recipientId)
      else Recipient.Manual(draft.email, draft.phone)
    val confirmation =
      if (draft.mode == InteracForm.MODE_REQUEST) {
        val r =
          banking.executeRequestMoney(
            recipient,
            draft.accountId,
            draft.amount,
            draft.channel,
            draft.memo,
          )
        ConfirmationData(
          kind = InteracForm.MODE_REQUEST,
          statusCode = r.status.name,
          reference = r.referenceId,
          amount = InteracSurfaceTemplates.money(r.amount),
          party = r.requestee,
          channelCode = r.deliveryChannel.name,
          destination = r.destination,
          account = r.depositAccount,
          time = r.timestamp,
          memo = r.memo,
        )
      } else {
        val r =
          banking.executeSendTransfer(
            draft.accountId,
            recipient,
            draft.amount,
            draft.channel,
            draft.securityQuestion,
            draft.securityAnswer,
          )
        ConfirmationData(
          kind = InteracForm.MODE_SEND,
          statusCode = r.status.name,
          reference = r.referenceId,
          amount = InteracSurfaceTemplates.money(r.amount),
          party = r.recipient,
          channelCode = r.deliveryChannel.name,
          destination = r.destination,
          account = r.fromAccount,
          time = r.timestamp,
          memo = null,
        )
      }
    if (draft.saveContact && recipient is Recipient.Manual) {
      banking.saveContact(draft.email ?: draft.phone.orEmpty(), draft.email, draft.phone)
    }
    return confirmation
  }

  private fun updateForm(surfaceId: String, field: String, value: JsonPrimitive) =
    InteracSurfaceTemplates.updateData(surfaceId, "/form/$field", value)

  // ponytail: blocking in-memory calls; make the interface suspend if a real backend arrives
  private suspend fun <T> banking(block: InteracBankingTools.() -> T): T =
    withContext(Dispatchers.Default) { banking.block() }

  private val AssistantTurn.surfaceId: String
    get() = "turn-$id"

  private data class RecipientSeed(
    val options: List<InteracContact>,
    val preselected: InteracContact? = null,
    val manualEmail: String? = null,
    val manualPhone: String? = null,
  ) {
    /** The preselected contact's channels, or the typed destinations in manual mode. */
    fun channels(): List<DeliveryChannel> =
      preselected?.channels()
        ?: listOfNotNull(
          manualEmail?.let { DeliveryChannel.EMAIL },
          manualPhone?.let { DeliveryChannel.PHONE },
        )
  }

  /** Validated mirror of the submitted form values; never logged (FR-025). */
  private data class FormDraft(
    val mode: String,
    val amount: Double,
    val recipientId: String,
    val email: String?,
    val phone: String?,
    val saveContact: Boolean,
    val accountId: String,
    val channel: DeliveryChannel,
    val securityQuestion: String?,
    val securityAnswer: String?,
    val memo: String?,
  ) {
    companion object {
      @Suppress("ReturnCount") // Early exits read as the validation checklist they are.
      fun from(context: Map<String, Any?>): FormDraft? {
        fun text(key: String) = (context[key] as? String).orEmpty().trim()
        val mode = text("mode").ifEmpty { InteracForm.MODE_SEND }
        val amount = InteracResolution.validateAmount(text("amount")) ?: return null
        val channel = DeliveryChannel.entries.find { it.name == text("channel") } ?: return null
        val accountId =
          text("accountId").ifEmpty {
            return null
          }
        val recipientId = text("recipientId")
        val email = text("manualEmail").ifEmpty { null }
        val phone = text("manualPhone").ifEmpty { null }
        if (recipientId.isEmpty() && email == null && phone == null) return null
        val securityRequired =
          (context["securityRequired"] as? Boolean ?: true) || recipientId.isEmpty()
        val question = text("securityQuestion").ifEmpty { null }
        val answer = text("securityAnswer").ifEmpty { null }
        val securityMissing = question == null || answer == null
        if (mode == InteracForm.MODE_SEND && securityRequired && securityMissing) return null
        return FormDraft(
          mode = mode,
          amount = amount,
          recipientId = recipientId,
          email = email,
          phone = phone,
          saveContact = context["saveContact"] as? Boolean ?: false,
          accountId = accountId,
          channel = channel,
          securityQuestion = question,
          securityAnswer = answer,
          memo = text("memo").ifEmpty { null },
        )
      }
    }
  }

  @CircuitInject(InteracAssistantScreen::class, SingletonComponent::class)
  @AssistedFactory
  fun interface Factory {
    fun create(navigator: Navigator): InteracAssistantPresenter
  }

  private companion object {
    const val TAG = "InteracAssistant"
    const val MANUAL_PHONE_DIGITS = 7
    const val PROBE_AMOUNT = 0.01
  }
}

private fun appendTranscript(current: String, transcript: String): String =
  when {
    current.isEmpty() -> transcript
    current.last().isWhitespace() -> current + transcript
    else -> "$current $transcript"
  }

private fun InteracContact.channels() =
  listOfNotNull(email?.let { DeliveryChannel.EMAIL }, phoneNumber?.let { DeliveryChannel.PHONE })
