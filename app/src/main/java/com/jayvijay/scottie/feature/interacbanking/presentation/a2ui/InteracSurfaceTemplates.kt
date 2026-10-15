package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui

import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.TransactionInsights.TransactionQueryResult
import com.jayvijay.scottie.feature.interacbanking.presentation.Notice
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.components.Alert
import java.util.Locale
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonArray
import kotlinx.serialization.json.putJsonObject

/**
 * Pure builders for every A2UI envelope the presenter emits (one JSON object per line). The JSON
 * carries values and codes only; components resolve user-visible copy.
 */
@Suppress("TooManyFunctions") // One builder per envelope and component; nothing to split.
object InteracSurfaceTemplates {
  const val ROOT = "root"
  const val FORM = "form"
  const val ALERT = "alert"
  const val TRANSACTIONS = "transactions"
  private const val VERSION = "v0.9"

  data class FormSeed(
    val mode: String,
    val amount: String,
    val recipientQuery: String,
    val recipientId: String?,
    val manualEmail: String?,
    val manualPhone: String?,
    val recipients: List<InteracContact>,
    val accounts: List<Account>,
    val accountId: String?,
    val channel: String,
    val channelLocked: Boolean,
    val securityRequired: Boolean,
    val memo: String?,
  )

  data class ConfirmationData(
    val kind: String,
    val statusCode: String,
    val reference: String,
    val amount: String,
    val party: String,
    val channelCode: String,
    val destination: String,
    val account: String,
    val time: String,
    val memo: String?,
  )

  fun money(amount: Double): String = String.format(Locale.US, "%,.2f", amount)

  fun deleteSurface(surfaceId: String): String =
    envelope("deleteSurface") { put("surfaceId", surfaceId) }

  fun updateData(surfaceId: String, path: String, value: JsonElement): String =
    envelope("updateDataModel") {
      put("surfaceId", surfaceId)
      put("path", path)
      put("value", value)
    }

  fun contacts(contacts: List<InteracContact>): JsonElement = buildJsonArray {
    contacts.forEach { c ->
      add(
        buildJsonObject {
          put("id", c.contactId)
          put("label", c.name)
          put("detail", c.email ?: c.phoneNumber.orEmpty())
          put("autodeposit", c.autodepositEnabled)
        }
      )
    }
  }

  /** Alert above the existing form after a service rejection. */
  fun alertAboveForm(surfaceId: String, text: String): String =
    updateComponents(surfaceId, listOf(column(listOf(ALERT, FORM)), alert(text = text)))

  fun balanceCards(
    surfaceId: String,
    accounts: List<Account>,
    notice: Notice? = null,
    noticeText: String? = null,
    highlightId: String? = null,
  ): List<String> {
    val data = buildJsonObject {
      putJsonArray("accounts") {
        accounts.forEach { a ->
          add(
            buildJsonObject {
              put("name", a.name)
              put("typeCode", a.type.name)
              put("mask", a.accountNumberMask)
              put("balance", money(a.availableBalance))
              put("currency", a.currency)
              put("highlight", a.accountId == highlightId)
            }
          )
        }
      }
    }
    val cards =
      accounts.indices.map { i ->
        component("card$i", "BalanceCard") {
          listOf("name", "typeCode", "mask", "balance", "currency", "highlight").forEach {
            bind(it, "/accounts/$i/$it")
          }
        }
      }
    val alert = (noticeText ?: notice)?.let { alert(text = noticeText, notice = notice) }
    val children = listOfNotNull(alert?.let { ALERT }) + cards.indices.map { "card$it" }
    return surface(surfaceId, data, listOfNotNull(column(children), alert) + cards)
  }

  fun form(surfaceId: String, seed: FormSeed, alertText: String? = null): List<String> {
    val data = buildJsonObject {
      putJsonObject("form") {
        put("mode", seed.mode)
        put("amount", seed.amount)
        put("recipientQuery", seed.recipientQuery)
        put("recipientId", seed.recipientId.orEmpty())
        put("manualEmail", seed.manualEmail.orEmpty())
        put("manualPhone", seed.manualPhone.orEmpty())
        put("saveContact", false)
        put("accountId", seed.accountId.orEmpty())
        put("channel", seed.channel)
        put("channelLocked", seed.channelLocked)
        put("securityRequired", seed.securityRequired)
        put("securityQuestion", "")
        put("securityAnswer", "")
        put("memo", seed.memo.orEmpty())
        put("valid", false)
        put("busy", false)
      }
      putJsonObject("options") {
        put("recipients", contacts(seed.recipients))
        putJsonArray("accounts") {
          seed.accounts.forEach { a ->
            add(
              buildJsonObject {
                put("id", a.accountId)
                put("label", a.name)
                val balance = money(a.availableBalance)
                put("detail", "${a.accountNumberMask} · $balance ${a.currency}")
              }
            )
          }
        }
      }
      putJsonArray("suggestions") {}
    }
    val form =
      component(FORM, "InteracForm") {
        put("mode", seed.mode)
        FORM_FIELDS.forEach { bind(it, "/form/$it") }
        bind("suggestions", "/suggestions")
        bind("recipients", "/options/recipients")
        bind("accounts", "/options/accounts")
        put("onQuery", event("recipientQuery", mapOf("query" to "/form/recipientQuery")))
        put("onSelectRecipient", event("selectRecipient", mapOf("id" to "/form/recipientId")))
        put("onSubmit", event("submit", (FORM_FIELDS + "mode").associateWith { "/form/$it" }))
      }
    val alert = alertText?.let { alert(text = it) }
    val children = listOfNotNull(alert?.let { ALERT }) + FORM
    return surface(surfaceId, data, listOfNotNull(column(children), alert, form))
  }

  fun confirmation(surfaceId: String, result: ConfirmationData): List<String> {
    val fields =
      mapOf(
        "statusCode" to result.statusCode,
        "reference" to result.reference,
        "amount" to result.amount,
        "party" to result.party,
        "channelCode" to result.channelCode,
        "destination" to result.destination,
        "account" to result.account,
        "time" to result.time,
      ) + listOfNotNull(result.memo?.let { "memo" to it })
    val data = buildJsonObject {
      putJsonObject("result") { fields.forEach { (k, v) -> put(k, v) } }
    }
    val card =
      component("result", "Confirmation") {
        put("kind", result.kind)
        fields.keys.forEach { bind(it, "/result/$it") }
      }
    return surface(surfaceId, data, listOf(column(listOf("result")), card))
  }

  fun transactionResults(surfaceId: String, result: TransactionQueryResult): List<String> {
    val summaryFields =
      listOf(
        "scenarioCode",
        "statusCode",
        "count",
        "inflowAmount",
        "outflowAmount",
        "periodLabel",
        "queryLabel",
      )
    val data = buildJsonObject {
      putJsonObject("summary") {
        put("scenarioCode", result.scenario.name)
        put("statusCode", result.status.name)
        put("count", result.matchCount.toString())
        put("inflowAmount", money(result.totalInflow))
        put("outflowAmount", money(result.totalOutflow))
        put("periodLabel", result.periodLabel.orEmpty())
        put("queryLabel", result.queryLabel.orEmpty())
      }
      putJsonArray("items") {
        result.items.forEach { flagged ->
          val t = flagged.transaction
          add(
            buildJsonObject {
              put("id", t.transactionId)
              put("date", t.date)
              put("merchant", t.merchant)
              put("descriptor", t.descriptor)
              put("categoryCode", t.category.name)
              put("accountName", t.accountName)
              put("directionCode", t.direction.name)
              put("amount", money(t.amount))
              put("currency", t.currency)
              put("badgeCode", flagged.badge?.name.orEmpty())
              put("isReference", flagged.isReference)
            }
          )
        }
      }
    }
    val listComponent =
      component(TRANSACTIONS, "TransactionList") {
        summaryFields.forEach { bind(it, "/summary/$it") }
        bind("items", "/items")
      }
    val notice = result.accountNotFoundHint?.let { Notice.AccountNotFound(it) }
    val alert = notice?.let { alert(notice = it) }
    val children = listOfNotNull(alert?.let { ALERT }) + TRANSACTIONS
    return surface(surfaceId, data, listOfNotNull(column(children), alert, listComponent))
  }

  private fun surface(id: String, data: JsonObject, components: List<JsonObject>): List<String> =
    listOf(
      envelope("createSurface") {
        put("surfaceId", id)
        put("catalogId", INTERAC_CATALOG_ID)
      },
      updateData(id, "/", data),
      updateComponents(id, components),
    )

  private fun updateComponents(id: String, components: List<JsonObject>): String =
    envelope("updateComponents") {
      put("surfaceId", id)
      putJsonArray("components") { components.forEach { add(it) } }
    }

  private fun envelope(operation: String, body: JsonObjectBuilderScope): String =
    Json.encodeToString(
      JsonObject.serializer(),
      buildJsonObject {
        put("version", VERSION)
        putJsonObject(operation, body)
      },
    )

  private fun component(id: String, type: String, body: JsonObjectBuilderScope) = buildJsonObject {
    put("id", id)
    put("component", type)
    body()
  }

  private fun column(children: List<String>) =
    component(ROOT, "Column") {
      putJsonArray("children") { children.forEach { add(JsonPrimitive(it)) } }
    }

  private fun alert(text: String? = null, notice: Notice? = null) =
    component(ALERT, "Alert") {
      put("tone", if (text != null || notice is Notice.NoAccountCovers) "error" else "info")
      when {
        text != null -> put("text", text)
        notice is Notice.AccountNotFound -> {
          put("noticeKind", Alert.ACCOUNT_NOT_FOUND)
          put("noticeArg", notice.hint)
        }
        notice is Notice.NoAccountCovers -> {
          put("noticeKind", Alert.NO_COVER)
          put("noticeArg", notice.amount)
        }
      }
    }

  private fun event(name: String, context: Map<String, String>) = buildJsonObject {
    putJsonObject("event") {
      put("name", name)
      putJsonObject("context") { context.forEach { (k, path) -> bind(k, path) } }
    }
  }

  private fun kotlinx.serialization.json.JsonObjectBuilder.bind(key: String, path: String) =
    putJsonObject(key) { put("path", path) }

  private val FORM_FIELDS =
    listOf(
      "amount",
      "recipientQuery",
      "recipientId",
      "manualEmail",
      "manualPhone",
      "saveContact",
      "accountId",
      "channel",
      "channelLocked",
      "securityRequired",
      "securityQuestion",
      "securityAnswer",
      "memo",
      "valid",
      "busy",
    )
}

private typealias JsonObjectBuilderScope = kotlinx.serialization.json.JsonObjectBuilder.() -> Unit
