package com.jayvijay.scottie.feature.interacbanking.domain.agent.workflow

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.functionalStrategy
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.prompt.executor.model.PromptExecutor
import ai.koog.prompt.executor.model.StructureFixingParser
import ai.koog.prompt.llm.LLModel
import ai.koog.prompt.message.MessagePart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

/**
 * One Koog agent per request: free-form request with read-only tools, then the reply is parsed as
 * [AssistantIntent]; a structured repair request runs only when the first reply is not JSON.
 * Unparseable output yields [AssistantIntent.FALLBACK]; model load or inference failures propagate.
 * Constructed in `di/`; no DI or Android here.
 */
class InteracAssistantAgent(
  private val executor: PromptExecutor,
  private val toolRegistry: ToolRegistry,
  private val models: ModelResolver,
) : IntentExtractor {

  override suspend fun extract(text: String, modelId: String): AssistantIntent =
    withContext(Dispatchers.Default) {
      val model = models.resolve(modelId)
      val agent =
        AIAgent(
          promptExecutor = executor,
          llmModel = model,
          strategy = strategy(model),
          toolRegistry = toolRegistry,
          systemPrompt = INTERAC_AGENT_INSTRUCTIONS,
          temperature = 0.0,
          maxIterations = MAX_ITERATIONS,
        )
      try {
        agent.run(text)
      } finally {
        agent.close()
      }
    }

  private fun strategy(model: LLModel) =
    functionalStrategy<String, AssistantIntent>("interac-intent") { input ->
      var response = requestLLM(input)
      var rounds = 0
      while (rounds++ < MAX_TOOL_ROUNDS && response.parts.any { it is MessagePart.Tool.Call }) {
        response = sendToolResults(executeTools(response))
      }
      parse(response.textContent())
        ?: requestLLMStructured<AssistantIntent>(
            REPAIR_PROMPT,
            fixingParser = StructureFixingParser(model, retries = 1),
          )
          .getOrNull()
          ?.data
        ?: AssistantIntent.FALLBACK
    }

  private fun parse(text: String): AssistantIntent? {
    val body = text.trim().removePrefix("```json").removePrefix("```").removeSuffix("```").trim()
    val json = body.substring(body.indexOf('{').coerceAtLeast(0))
    return runCatching { JSON.decodeFromString<AssistantIntent>(json) }.getOrNull()
  }

  private companion object {
    const val MAX_ITERATIONS = 6
    const val MAX_TOOL_ROUNDS = 3
    const val REPAIR_PROMPT = "Respond with only the JSON object."
    val JSON = Json {
      ignoreUnknownKeys = true
      isLenient = true
      explicitNulls = false
    }
  }
}
