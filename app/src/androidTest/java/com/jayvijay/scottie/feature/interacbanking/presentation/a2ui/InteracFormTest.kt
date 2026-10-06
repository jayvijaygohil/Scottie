package com.jayvijay.scottie.feature.interacbanking.presentation.a2ui

import androidx.a2ui.compose.ui.testing.A2uiTestController
import androidx.a2ui.compose.ui.testing.A2uiTestSurface
import androidx.a2ui.model.protocol.A2uiComponentPayload
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.v2.runComposeUiTest
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact
import com.jayvijay.scottie.feature.interacbanking.presentation.a2ui.InteracSurfaceTemplates.FormSeed
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

private const val SEND_TRANSFER = "Send transfer"
private const val SECURITY_ANSWER = "Security answer"
private const val QUERY = "recipientQuery"

@OptIn(ExperimentalTestApi::class)
class InteracFormTest {
  private val alice = InteracContact("ct_alice", "Alice Martin", "alice.m@example.com", null, true)
  private val charlie =
    InteracContact("ct_charlie", "Charlie Chen", "charlie.c@example.ca", "+1-647-555-0199", false)
  private val everyday =
    Account("acc_chk_101", "Everyday Chequing", AccountType.CHEQUING, "**** 4821", 1540.25)

  private fun seed(
    contact: InteracContact,
    security: Boolean,
    channel: String,
    locked: Boolean,
    mode: String = "send",
  ) =
    FormSeed(
      mode = mode,
      amount = "50.00",
      recipientQuery = contact.name,
      recipientId = contact.contactId,
      manualEmail = null,
      manualPhone = null,
      recipients = listOf(alice, charlie),
      accounts = listOf(everyday),
      accountId = everyday.accountId,
      channel = channel,
      channelLocked = locked,
      securityRequired = security,
      memo = null,
    )

  private val charlieSeed = seed(charlie, security = true, channel = "", locked = false)
  private val aliceSeed = seed(alice, security = false, channel = "EMAIL", locked = true)

  /** Feeds the real template output into the test controller. */
  private suspend fun ComposeUiTest.start(seed: FormSeed): A2uiTestController {
    val lines =
      InteracSurfaceTemplates.form("s", seed).map { Json.parseToJsonElement(it).jsonObject }
    val dataUpdate = lines.single { "updateDataModel" in it }["updateDataModel"]!!.jsonObject
    val data = dataUpdate["value"]!!.plain() as Map<*, *>
    val componentUpdate = lines.single { "updateComponents" in it }["updateComponents"]!!.jsonObject
    val components =
      componentUpdate["components"]!!.jsonArray.map {
        val obj = it.jsonObject
        @Suppress("UNCHECKED_CAST")
        A2uiComponentPayload(
          id = obj["id"]!!.jsonPrimitive.content,
          type = obj["component"]!!.jsonPrimitive.content,
          properties = (obj - "id" - "component").mapValues { (_, v) -> v.plain() },
        )
      }
    @Suppress("UNCHECKED_CAST")
    val controller =
      A2uiTestController(
        interacCatalog(),
        initialComponents = components,
        initialData = data as Map<String, Any?>,
      )
    val surface = controller.start()
    setContent { ScottieTheme { A2uiTestSurface(surface = surface) } }
    return controller
  }

  private suspend fun ComposeUiTest.settle(controller: A2uiTestController) {
    controller.waitForIdle()
    waitForIdle()
  }

  @Test
  fun submitStaysDisabledUntilChannelAndSecurityAreValid() = runComposeUiTest {
    val controller = start(charlieSeed)
    onNodeWithText(SEND_TRANSFER).assertIsNotEnabled()
    onNodeWithText("Email").assertIsDisplayed()
    onNodeWithText("SMS").assertIsDisplayed()

    onNodeWithText("Email").performClick()
    settle(controller)
    onNodeWithText(SEND_TRANSFER).assertIsNotEnabled()

    onNodeWithText("Security question").performTextInput("   ")
    onNodeWithText(SECURITY_ANSWER).performTextInput("  ")
    settle(controller)
    onNodeWithText(SEND_TRANSFER).assertIsNotEnabled()

    onNodeWithText("Security question").performTextReplacement("Pet?")
    onNode(hasSetTextAction() and SemanticsMatcher.keyIsDefined(SemanticsProperties.Password))
      .performTextReplacement("Rex")
    settle(controller)
    onNodeWithText(SEND_TRANSFER).assertIsEnabled()
    onAllNodesWithText("Rex").assertCountEquals(0)
    assertEquals(true, controller.getRawData("/form/valid"))
    assertEquals("Rex", controller.getRawData("/form/securityAnswer"))
  }

  @Test
  fun autodepositHidesSecurityUntilServerSaysOtherwise() = runComposeUiTest {
    val controller = start(aliceSeed)
    onNodeWithText("Autodeposit Active").assertIsDisplayed()
    onAllNodesWithText(SECURITY_ANSWER).assertCountEquals(0)
    onNodeWithText(SEND_TRANSFER).assertIsEnabled()

    controller.updateData("/form/securityRequired", true)
    settle(controller)
    onNodeWithText(SECURITY_ANSWER).assertIsDisplayed()
    onNodeWithText(SEND_TRANSFER).assertIsNotEnabled()
  }

  @Test
  fun typingQueriesAndSuggestionsRenderAsChips() = runComposeUiTest {
    val controller = start(aliceSeed)
    onNodeWithText("Alice Martin").performTextReplacement("Ali")
    settle(controller)
    waitUntil(timeoutMillis = 2_000) { controller.outboundEvents.any { it.type == QUERY } }
    assertEquals("Ali", controller.outboundEvents.last { it.type == QUERY }.context["query"])

    controller.updateData(
      "/suggestions",
      listOf(
        mapOf(
          "id" to "ct_alicia",
          "label" to "Alicia Moreno",
          "detail" to "alicia@example.com",
          "autodeposit" to false,
        )
      ),
    )
    settle(controller)
    onNodeWithText("Alicia Moreno").assertIsDisplayed()
    onNodeWithText("Alicia Moreno").performClick()
    settle(controller)
    assertEquals("ct_alicia", controller.getRawData("/form/recipientId"))
    val selected = controller.outboundEvents.filter { it.type == "selectRecipient" }
    assertEquals(listOf("ct_alicia"), selected.map { it.context["id"] })
  }

  @Test
  fun submitCarriesEveryFormValue() = runComposeUiTest {
    val controller = start(aliceSeed)
    onNodeWithText(SEND_TRANSFER).performClick()
    settle(controller)
    val submit = controller.outboundEvents.single { it.type == "submit" }
    val keys = listOf("amount", "recipientId", "channel", "accountId", "securityAnswer", "mode")
    for (key in keys + "saveContact") {
      assertTrue(key, key in submit.context)
    }
    assertEquals("50.00", submit.context["amount"])
    assertEquals("ct_alice", submit.context["recipientId"])
    assertEquals("EMAIL", submit.context["channel"])
    assertEquals(emptyList<Any>(), controller.outboundErrors)
  }

  @Test
  fun requestModeShowsMemoAndNoSecurity() = runComposeUiTest {
    start(seed(alice, security = false, channel = "EMAIL", locked = true, mode = "request"))
    onNodeWithText("Memo (optional)").assertIsDisplayed()
    onAllNodesWithText(SECURITY_ANSWER).assertCountEquals(0)
    onNodeWithText("Send request").assertIsEnabled()
  }

  private fun JsonElement.plain(): Any? =
    when (this) {
      is JsonNull -> null
      is JsonPrimitive -> if (isString) content else booleanOrNull ?: doubleOrNull ?: content
      is JsonArray -> map { it.plain() }
      is JsonObject -> mapValues { (_, v) -> v.plain() }
    }
}
