// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStructuredData10

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeLLMRequestStructured
import ai.koog.agents.example.exampleStructuredData03.WeatherForecast
import ai.koog.agents.example.exampleStructuredData06.exampleForecasts
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.structure.StructuredResponse
import ai.koog.prompt.executor.model.StructureFixingParser

val agentStrategy = strategy<Unit, String>("weather-forecast") {
    val setup by node<Unit, String> { _ ->
        "Please provide a weather forecast for Amsterdam"
    }
    
    // Create a structured output node using delegate syntax
    val getWeatherForecast by nodeLLMRequestStructured<WeatherForecast>(
        name = "forecast-node",
        examples = exampleForecasts,
        fixingParser = StructureFixingParser(
            model = OpenAIModels.Chat.GPT4o,
            retries = 3
        )
    )
    
    val processResult by node<Result<StructuredResponse<WeatherForecast>>, String> { result ->
        when {
            result.isSuccess -> {
                val forecast = result.getOrNull()?.data
                "Weather forecast: $forecast"
            }
            result.isFailure -> {
                "Failed to get structured forecast: ${result.exceptionOrNull()?.message}"
            }
            else -> "Unknown result state"
        }
    }

    edge(nodeStart forwardTo setup)
    edge(setup forwardTo getWeatherForecast)
    edge(getWeatherForecast forwardTo processResult)
    edge(processResult forwardTo nodeFinish)
}
