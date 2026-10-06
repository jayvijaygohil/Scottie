package com.jayvijay.scottie.feature.interacbanking.presentation

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.jayvijay.scottie.core.ui.ScottieTheme
import org.junit.Rule
import org.junit.Test

class InteracAssistantUiTest {
  @get:Rule val rule = createComposeRule()

  private fun show(turns: List<AssistantTurn>, missingModel: Boolean = false) {
    val state =
      InteracAssistantState(
        modelName = "m",
        turns = turns,
        input = "",
        busy = false,
        missingModel = missingModel,
        surfaces = emptyList(),
        eventSink = {},
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
  fun fallbackShowsTheRetryMessage() {
    show(listOf(AssistantTurn(1, "Send money", TurnReply.Fallback)))
    rule.onNodeWithText("I couldn't build that form. Please try again.").assertIsDisplayed()
  }

  @Test
  fun missingModelHidesTheComposer() {
    show(emptyList(), missingModel = true)
    rule
      .onNodeWithText("Download a text model first, then open the assistant from its card.")
      .assertIsDisplayed()
    rule.onAllNodesWithTag(TAG_COMPOSER).assertCountEquals(0)
  }
}
