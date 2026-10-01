// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStructuredData09

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.example.exampleStructuredData03.WeatherForecast
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.message.Message
import ai.koog.prompt.executor.model.StructureFixingParser

val agentStrategy = strategy<String, String>("weather-forecast") {
    val setup by nodeLLMRequest()

    val getStructuredForecast by node<Message.Assistant, String> { _ ->
        val structuredResponse = llm.writeSession {
            requestLLMStructured<WeatherForecast>(
                fixingParser = StructureFixingParser(
                    model = OpenAIModels.Chat.GPT4o,
                    retries = 3
                )
            )
        }

        """
        Response structure:
        $structuredResponse
        """.trimIndent()
    }

    edge(nodeStart forwardTo setup)
    edge(setup forwardTo getStructuredForecast)
    edge(getStructuredForecast forwardTo nodeFinish)
}
