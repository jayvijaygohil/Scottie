package com.jayvijay.scottie.feature.interacbanking.presentation

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.jayvijay.scottie.core.ui.ScottieTheme
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.InferenceFailure
import com.jayvijay.scottie.feature.interacbanking.domain.entities.TextModelOption
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_COMPOSER
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_EMPTY_STATE
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_EXAMPLE
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_MODEL_OPTION
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_MODEL_SELECTOR
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_REPLY
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_SEND
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_THINKING
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_USER_BUBBLE
import com.jayvijay.scottie.feature.interacbanking.presentation.component.TAG_WELCOME
import org.junit.Assert.assertEquals
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
        models = listOf(TextModelOption("a", "Model A"), TextModelOption("b", "Model B")),
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
  }

  @Test
  fun sendIsDisabledWhileBusy() {
    show(listOf(AssistantTurn(1, "hi", TurnReply.Thinking)), input = "x", busy = true)
    rule.onNodeWithTag(TAG_SEND).assertIsNotEnabled()
    rule.onNodeWithTag(TAG_MODEL_SELECTOR).assertIsNotEnabled()
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
  fun selectorListsModelsAndDispatchesSelection() {
    show(emptyList())
    rule.onNodeWithTag(TAG_MODEL_SELECTOR).performClick()
    rule.onAllNodesWithTag(TAG_MODEL_OPTION).assertCountEquals(2)
    rule.onNodeWithText("Model B").performClick()
    assertEquals(listOf(InteracAssistantAction.SelectModel("b")), actions)
  }

  @Test
  fun gearOpensSettings() {
    show(emptyList())
    rule.onNodeWithTag(TAG_SETTINGS).performClick()
    assertEquals(listOf(InteracAssistantAction.OpenSettings), actions)
  }
}
