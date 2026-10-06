package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

import ai.koog.agents.core.tools.Tool
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.serialization.typeToken
import ai.koog.agents.testing.tools.getMockExecutor
import ai.koog.prompt.executor.clients.litert.LiteRTLLMProvider
import ai.koog.prompt.executor.model.PromptExecutor
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLModel
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.ChannelHint
import com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow.AssistantIntent.Intent
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.Serializable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

private const val OFF_TOPIC =
  "I can check your balances, send an Interac e-Transfer, or request money."

class InteracAssistantAgentTest {
  private val model =
    LLModel(
      provider = LiteRTLLMProvider,
      id = "m.litertlm",
      capabilities = listOf(LLMCapability.Tools, LLMCapability.Completion),
      contextLength = 4_000,
    )
  private val captured = mutableListOf<String>()

  private fun agent(executor: PromptExecutor, registry: ToolRegistry = ToolRegistry.EMPTY) =
    InteracAssistantAgent(executor, registry) { model }

  private fun answering(json: String) = getMockExecutor {
    mockLLMAnswer(json) onCondition {
      captured += it
      true
    }
  }

  @Test
  fun decodesEveryExamplePrompt() = runTest {
    val examples =
      listOf(
        "What's my balance?" to """{"intent":"BALANCE"}""" to AssistantIntent(Intent.BALANCE),
        "How much is in my savings?" to """{"intent":"BALANCE","accountHint":"savings"}""" to
          AssistantIntent(Intent.BALANCE, accountHint = "savings"),
        "What's in my TFSA?" to """{"intent":"BALANCE","accountHint":"TFSA"}""" to
          AssistantIntent(Intent.BALANCE, accountHint = "TFSA"),
        "Send 50 to Alice" to """{"intent":"SEND","amount":50,"recipientQuery":"Alice"}""" to
          AssistantIntent(Intent.SEND, 50.0, "Alice"),
        "Send $20 to bob from my savings" to
          """{"intent":"SEND","amount":20,"recipientQuery":"bob","accountHint":"savings"}""" to
          AssistantIntent(Intent.SEND, 20.0, "bob", "savings"),
        "Send money to charlie.c@example.ca" to
          """{"intent":"SEND","recipientQuery":"charlie.c@example.ca"}""" to
          AssistantIntent(Intent.SEND, recipientQuery = "charlie.c@example.ca"),
        "e-Transfer 75 to 416-555-0143" to
          """{"intent":"SEND","amount":75,"recipientQuery":"416-555-0143"}""" to
          AssistantIntent(Intent.SEND, 75.0, "416-555-0143"),
        "Send 40 to Charly" to """{"intent":"SEND","amount":40,"recipientQuery":"Charly"}""" to
          AssistantIntent(Intent.SEND, 40.0, "Charly"),
        "Send money" to """{"intent":"SEND"}""" to AssistantIntent(Intent.SEND),
        "Request $30 from Jane for dinner" to
          """{"intent":"REQUEST","amount":30,"recipientQuery":"Jane","memo":"dinner"}""" to
          AssistantIntent(Intent.REQUEST, 30.0, "Jane", memo = "dinner"),
        "Ask Alicia for 25 bucks" to
          """{"intent":"REQUEST","amount":25,"recipientQuery":"Alicia"}""" to
          AssistantIntent(Intent.REQUEST, 25.0, "Alicia"),
        "Request $30 from Alice into savings for dinner" to
          """{"intent":"REQUEST","amount":30,"recipientQuery":"Alice",""" +
            """"accountHint":"savings","memo":"dinner"}""" to
          AssistantIntent(Intent.REQUEST, 30.0, "Alice", "savings", "dinner"),
        "What's the weather?" to """{"intent":"OTHER","reply":"$OFF_TOPIC"}""" to
          AssistantIntent(Intent.OTHER, reply = OFF_TOPIC),
        "Request $30 from Alice by text" to
          """{"intent":"REQUEST","amount":30,"recipientQuery":"Alice","channelHint":"SMS"}""" to
          AssistantIntent(Intent.REQUEST, 30.0, "Alice", channelHint = ChannelHint.SMS),
      )
    for ((pair, expected) in examples) {
      val (input, json) = pair
      assertEquals(input, expected, agent(answering(json)).extract(input, model.id))
    }
    assertTrue(captured.none { "securityAnswer" in it })
    assertTrue(captured.any { "Send 50 to Alice" in it })
  }

  @Test
  fun toolCallsAreExecutedBeforeTheIntentIsParsed() = runTest {
    val executor = getMockExecutor {
      mockLLMToolCall(EchoTool, EchoTool.Args("Ali")) onRequestContains "Send 40 to"
      mockLLMAnswer("""{"intent":"SEND","amount":40,"recipientQuery":"Ali"}""") onCondition { true }
    }
    val registry = ToolRegistry { tool(EchoTool) }

    val intent = agent(executor, registry).extract("Send 40 to Ali", model.id)

    assertEquals(AssistantIntent(Intent.SEND, 40.0, "Ali"), intent)
    assertEquals(listOf("Ali"), EchoTool.calls)
  }

  @Test
  fun garbageAnswerFallsBackToOther() = runTest {
    assertEquals(AssistantIntent.FALLBACK, agent(answering("sure thing")).extract("hi", model.id))
  }

  @Test
  fun fencedJsonIsParsed() = runTest {
    val fenced = "```json\n{\"intent\":\"SEND\",\"amount\":50,\"recipientQuery\":\"Alice\"}\n```"
    val intent = agent(answering(fenced)).extract("x", model.id)
    assertEquals(AssistantIntent(Intent.SEND, 50.0, "Alice"), intent)
  }

  private object EchoTool :
    Tool<EchoTool.Args, String>(
      argsType = typeToken<Args>(),
      resultType = typeToken<String>(),
      name = "findContacts",
      description = "test",
    ) {
    val calls = mutableListOf<String>()

    @Serializable data class Args(@property:LLMDescription("query") val query: String = "")

    override suspend fun execute(args: Args): String {
      calls += args.query
      return "found: Alice Martin, Alicia Moreno"
    }
  }
}
