// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleLlmParameters02

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.ext.tool.SayToUser
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.agents.ext.agent.subgraphWithTask
import ai.koog.prompt.params.LLMParams
val searchTool = SayToUser
val calculatorTool = SayToUser
val weatherTool = SayToUser
val strategy = strategy<String, String>("strategy_name") {

val processQuery by subgraphWithTask<String, String>(
    tools = listOf(searchTool, calculatorTool, weatherTool),
    llmModel = OpenAIModels.Chat.GPT4o,
    llmParams = LLMParams(
        temperature = 0.7,
        maxTokens = 500
    ),
    parallelTools = false,
    assistantResponseRepeatMax = 3,
) { userQuery ->
    """
    You are a helpful assistant that can answer questions about various topics.
    Please help with the following query:
    $userQuery
    """
}
}
