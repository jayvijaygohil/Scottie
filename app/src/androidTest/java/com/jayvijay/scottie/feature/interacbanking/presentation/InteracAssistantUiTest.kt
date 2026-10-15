package com.jayvijay.scottie.feature.interacbanking.presentation

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_COMPOSER
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_EMPTY_STATE
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_EXAMPLE
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_REPLY
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_SEND
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_THINKING
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_USER_BUBBLE
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_WELCOME
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class InteracAssistantUiTest {
  @get:Rule val rule = createComposeRule()

  private val actions = mutableListOf<InteracAssistantAction>()

  private fun show(
    turns: List<AssistantTurn>,
    activeModelId: String? = "a",
    input: String = "",
    busy: Boolean = false,
  ) {
    val state =
      InteracAssistantState(
        activeModelId = activeModelId,
        turns = turns,
        input = input,
        busy = busy,
        missingModel = activeModelId == null,
        surfaces = emptyList(),
        eventSink = { actions += it },
      )
    rule.setContent { ScottieTheme { InteracAssistantUi().Content(state, Modifier) } }
  }

  @Test
  fun missingSurfaceLeavesOnlyTheUserBubble() {
    show(listOf(AssistantTurn(1, "Send $50 to Alice", TurnReply.Surface("missing"))))
    rule.onNodeWithTag(TAG_USER_BUBBLE).assertIsDisplayed()
    rule.onNodeWithText("Send $50 to Alice").assertIsDisplayed()
    rule.onAllNodesWithTag(TAG_REPLY).assertCountEquals(0)
  }

  @Test
  fun textTurnShowsBubbleAndReplyCard() {
    show(listOf(AssistantTurn(1, "hi", TurnReply.Text("Hello there"))))
    rule.onNodeWithTag(TAG_USER_BUBBLE).assertIsDisplayed()
    rule.onNodeWithTag(TAG_REPLY).assertIsDisplayed()
    rule.waitUntil { rule.onAllNodesWithText("Hello there").fetchSemanticsNodes().isNotEmpty() }
    rule.onNodeWithText("Hello there").assertIsDisplayed()
  }

  @Test
  fun fallbackAndFailureShowTheirMessages() {
    show(
      listOf(
        AssistantTurn(1, "Send money", TurnReply.Fallback),
        AssistantTurn(2, "Send more", TurnReply.Failed(InferenceFailure.UNKNOWN)),
      )
    )
    rule.onNodeWithText("I couldn't build that form. Please try again.").assertIsDisplayed()
    rule.onNodeWithText("Something went wrong. Please try again.").assertIsDisplayed()
  }

  @Test
  fun thinkingTurnShowsTheIndicator() {
    rule.mainClock.autoAdvance = false
    show(listOf(AssistantTurn(1, "hi", TurnReply.Thinking)))
    rule.onNodeWithTag(TAG_THINKING).assertIsDisplayed()
  }

  @Test
  fun sendIsDisabledWhenBlankOrBusy() {
    show(emptyList(), input = "  ")
    rule.onNodeWithTag(TAG_SEND).assertIsNotEnabled()
    rule.onNodeWithTag(TAG_CLEAR_CHAT).assertIsNotEnabled()
  }

  @Test
  fun sendAndClearAreDisabledWhileBusy() {
    show(listOf(AssistantTurn(1, "hi", TurnReply.Thinking)), input = "x", busy = true)
    rule.onNodeWithTag(TAG_SEND).assertIsNotEnabled()
    rule.onNodeWithTag(TAG_CLEAR_CHAT).assertIsNotEnabled()
  }

  @Test
  fun sendDispatchesWhenEnabled() {
    show(emptyList(), input = "hello")
    rule.onNodeWithTag(TAG_SEND).assertIsEnabled().performClick()
    assertEquals(listOf(InteracAssistantAction.Send), actions)
  }

  @Test
  fun emptyStateHidesTheComposerAndOpensSettings() {
    show(emptyList(), activeModelId = null)
    rule.onNodeWithTag(TAG_EMPTY_STATE).assertIsDisplayed()
    rule.onAllNodesWithTag(TAG_COMPOSER).assertCountEquals(0)
    rule.onNodeWithText("Download a Model to Get Started").performClick()
    assertEquals(listOf(InteracAssistantAction.OpenSettings), actions)
  }

  @Test
  fun welcomeExampleFillsTheInput() {
    show(emptyList())
    rule.onNodeWithTag(TAG_WELCOME).assertIsDisplayed()
    rule.onAllNodesWithTag(TAG_EXAMPLE).onFirst().performClick()
    assertEquals(listOf(InteracAssistantAction.InputChanged("What's my balance?")), actions)
  }

  @Test
  fun logoShowsScottieWithoutModelSelectorIgnoresSingleTapAndOpensSettingsOnLongPress() {
    show(emptyList())
    rule.onNodeWithTag(TAG_LOGO).assertIsDisplayed()
    rule.onNodeWithText("Scottie").assertIsDisplayed()
    rule.onAllNodesWithTag("chat_model_selector").assertCountEquals(0)

    rule.onNodeWithTag(TAG_LOGO).performClick()
    assertTrue(actions.isEmpty())

    rule.onNodeWithTag(TAG_LOGO).performTouchInput { longClick() }
    assertEquals(listOf(InteracAssistantAction.OpenSettings), actions)
  }

  @Test
  fun clearChatDispatchesWhenTurnsOrInputExist() {
    show(listOf(AssistantTurn(1, "hi", TurnReply.Text("Hello there"))))
    rule.onNodeWithTag(TAG_CLEAR_CHAT).assertIsEnabled().performClick()
    assertEquals(listOf(InteracAssistantAction.ClearChat), actions)
  }

  @Test
  fun sendButtonStaysVerticallyCenteredWhenComposerExpandsMultiline() {
    show(emptyList(), input = "Line 1\nLine 2\nLine 3\nLine 4")
    val composerBounds = rule.onNodeWithTag(TAG_COMPOSER).fetchSemanticsNode().boundsInRoot
    val sendBounds = rule.onNodeWithTag(TAG_SEND).fetchSemanticsNode().boundsInRoot
    assertEquals(composerBounds.center.y, sendBounds.center.y, 1.5f)
  }
}
