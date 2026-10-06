package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui

import com.jayvijay.scottie.feature.interacbanking.Fixtures
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.presentation.Notice
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplates.ConfirmationData
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplates.FormSeed
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class InteracSurfaceTemplatesTest {
  private fun parse(lines: List<String>) = lines.map { Json.parseToJsonElement(it).jsonObject }

  private fun parse(line: String) = Json.parseToJsonElement(line).jsonObject

  private fun List<JsonObject>.op(name: String) = single { name in it }[name]!!.jsonObject

  private fun List<JsonObject>.components() =
    op("updateComponents")["components"]!!.jsonArray.map { it.jsonObject }

  private fun List<JsonObject>.component(id: String) =
    components().single { it["id"]!!.jsonPrimitive.content == id }

  private fun List<JsonObject>.data() = op("updateDataModel")["value"]!!.jsonObject

  private fun List<JsonObject>.form() = data()["form"]!!.jsonObject

  private fun List<JsonObject>.children() =
    component("root")["children"]!!.jsonArray.map { it.jsonPrimitive.content }

  private fun JsonObject.str(key: String) = this[key]!!.jsonPrimitive.content

  private fun JsonObject.bool(key: String) = this[key]!!.jsonPrimitive.boolean

  private fun JsonObject.path(key: String) = this[key]!!.jsonObject.str("path")

  private val base =
    FormSeed(
      mode = "send",
      amount = "",
      recipientQuery = "",
      recipientId = null,
      manualEmail = null,
      manualPhone = null,
      recipients = Fixtures.CONTACTS,
      accounts = listOf(Fixtures.EVERYDAY, Fixtures.SAVINGS),
      accountId = null,
      channel = "",
      channelLocked = false,
      securityRequired = true,
      memo = null,
    )
  private val alice =
    base.copy(
      recipientId = "ct_alice",
      channel = "EMAIL",
      channelLocked = true,
      securityRequired = false,
      amount = "50.00",
    )

  private fun form(seed: FormSeed, alert: String? = null) =
    parse(InteracSurfaceTemplates.form("s", seed, alertText = alert))

  @Test
  fun formEmitsThreeEnvelopesWithEveryWritableFieldBound() {
    val lines = form(alice)

    assertEquals(3, lines.size)
    assertTrue(lines.all { it["version"]!!.jsonPrimitive.content == "v0.9" })
    assertEquals("s", lines.op("createSurface").str("surfaceId"))
    assertEquals(INTERAC_CATALOG_ID, lines.op("createSurface").str("catalogId"))
    assertEquals("root", lines.components().first().str("id"))
    val form = lines.component("form")
    assertEquals("send", form.str("mode"))
    val bound = listOf("amount", "recipientId", "channel", "accountId", "securityAnswer", "valid")
    for (field in bound) assertEquals("/form/$field", form.path(field))
    val submit = form["onSubmit"]!!.jsonObject["event"]!!.jsonObject
    assertEquals("submit", submit.str("name"))
    assertEquals("/form/securityAnswer", submit["context"]!!.jsonObject.path("securityAnswer"))
    val query = form["onQuery"]!!.jsonObject["event"]!!.jsonObject["context"]!!.jsonObject
    assertEquals("/form/recipientQuery", query.path("query"))
    assertTrue(lines.none { "Send an Interac" in it.toString() })
  }

  @Test
  fun seedsMirrorScenarios() {
    val aliceForm = form(alice).form()
    assertEquals("EMAIL", aliceForm.str("channel"))
    assertTrue(aliceForm.bool("channelLocked"))
    assertFalse(aliceForm.bool("securityRequired"))
    assertEquals("50.00", aliceForm.str("amount"))

    val bob =
      form(base.copy(recipientId = "ct_bob", channel = "PHONE", channelLocked = true)).form()
    assertEquals("PHONE", bob.str("channel"))
    assertTrue(bob.bool("securityRequired"))

    val charlie = form(base.copy(recipientId = "ct_charlie")).form()
    assertEquals("", charlie.str("channel"))
    assertFalse(charlie.bool("channelLocked"))

    val accounts = form(base).data()["options"]!!.jsonObject["accounts"]!!.jsonArray
    assertEquals(listOf("acc_chk_101", "acc_sav_202"), accounts.map { it.jsonObject.str("id") })

    val manual = form(base.copy(manualEmail = "sam@example.com", recipients = emptyList()))
    assertEquals("sam@example.com", manual.form().str("manualEmail"))
    assertEquals(0, manual.data()["options"]!!.jsonObject["recipients"]!!.jsonArray.size)
    assertTrue(manual.form().bool("securityRequired"))

    val savings =
      form(base.copy(recipientId = "ct_bob", amount = "20.00", accountId = "acc_sav_202"))
    assertEquals("acc_sav_202", savings.form().str("accountId"))
    assertEquals("20.00", savings.form().str("amount"))
  }

  @Test
  fun requestSeedAndAlertAboveForm() {
    val lines = form(alice.copy(mode = "request", memo = "dinner"), alert = "nope")
    val form = lines.form()
    assertEquals("request", form.str("mode"))
    assertEquals("dinner", form.str("memo"))
    assertFalse(form.bool("securityRequired"))
    assertEquals(listOf("alert", "form"), lines.children())
    assertEquals("nope", lines.component("alert").str("text"))

    val later = parse(InteracSurfaceTemplates.alertAboveForm("s", "Rejected."))
    val components =
      later["updateComponents"]!!.jsonObject["components"]!!.jsonArray.map { it.jsonObject }
    assertEquals("Rejected.", components.single { it.str("id") == "alert" }.str("text"))
  }

  @Test
  fun balanceCardsBindEachAccountAndOptionalNotice() {
    fun cards(vararg accounts: Account) = accounts.toList()

    val one = parse(InteracSurfaceTemplates.balanceCards("b", cards(Fixtures.SAVINGS)))
    assertEquals(listOf("root", "card0"), one.components().map { it.str("id") })
    assertEquals("/accounts/0/balance", one.component("card0").path("balance"))
    val first = one.data()["accounts"]!!.jsonArray[0].jsonObject
    assertEquals("6,200.00", first.str("balance"))
    assertEquals("SAVINGS", first.str("typeCode"))

    val pair = cards(Fixtures.EVERYDAY, Fixtures.JOINT)
    val two = parse(InteracSurfaceTemplates.balanceCards("b", pair))
    assertEquals(3, two.components().size)

    val notice = Notice.AccountNotFound("TFSA")
    val missing =
      parse(InteracSurfaceTemplates.balanceCards("b", Fixtures.ACCOUNTS, notice = notice))
    assertEquals(listOf("alert", "card0", "card1", "card2", "card3"), missing.children())
    assertEquals("accountNotFound", missing.component("alert").str("noticeKind"))
    assertEquals("TFSA", missing.component("alert").str("noticeArg"))
    assertNull(missing.component("alert")["text"])

    val highlighted =
      parse(
        InteracSurfaceTemplates.balanceCards(
          "b",
          cards(Fixtures.EVERYDAY, Fixtures.SAVINGS),
          noticeText = "Insufficient",
          highlightId = "acc_chk_101",
        )
      )
    val flags = highlighted.data()["accounts"]!!.jsonArray.map { it.jsonObject.bool("highlight") }
    assertEquals(listOf(true, false), flags)
    assertEquals("Insufficient", highlighted.component("alert").str("text"))
  }

  @Test
  fun confirmationIncludesMemoOnlyWhenPresent() {
    fun confirmation(kind: String, memo: String?) =
      ConfirmationData(
        kind, "SENT", "REF-1", "30.00", "Alice", "EMAIL", "a@b.c", "Acc", "now", memo,
      )
    fun result(memo: String?) =
      parse(InteracSurfaceTemplates.confirmation("c", confirmation("request", memo)))
        .data()["result"]!!
        .jsonObject
    assertEquals("dinner", result("dinner").str("memo"))
    assertNull(result(null)["memo"])
    val send = InteracSurfaceTemplates.confirmation("c", confirmation("send", null))
    val card = parse(send).component("result")
    assertEquals("send", card.str("kind"))
    assertEquals("/result/reference", card.path("reference"))
  }

  @Test
  fun deleteAndUpdateEnvelopes() {
    val delete = parse(InteracSurfaceTemplates.deleteSurface("x"))
    assertEquals("x", delete["deleteSurface"]!!.jsonObject.str("surfaceId"))
    val contacts = InteracSurfaceTemplates.contacts(listOf(Fixtures.ALICE))
    val update =
      parse(InteracSurfaceTemplates.updateData("x", "/suggestions", contacts))["updateDataModel"]!!
        .jsonObject
    assertEquals("/suggestions", update.str("path"))
    val item = update["value"]!!.jsonArray[0].jsonObject
    assertEquals("ct_alice", item.str("id"))
    assertEquals("alice.m@example.com", item.str("detail"))
    assertTrue(item.bool("autodeposit"))
  }
}
