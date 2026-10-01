// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStructuredData12

import ai.koog.agents.example.exampleStructuredData03.WeatherForecast
import ai.koog.agents.example.exampleStructuredData06.exampleForecasts
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.prompt.executor.model.executeStructured
import ai.koog.prompt.structure.StructuredRequest
import ai.koog.prompt.executor.model.StructureFixingParser
import ai.koog.prompt.structure.json.JsonStructure
import ai.koog.prompt.structure.json.generator.StandardJsonSchemaGenerator
import ai.koog.prompt.executor.clients.openai.base.structure.OpenAIBasicJsonSchemaGenerator
import ai.koog.prompt.executor.clients.anthropic.structure.AnthropicBasicJsonSchemaGenerator
import ai.koog.prompt.llm.LLMProvider
import kotlinx.coroutines.runBlocking
import ai.koog.prompt.structure.StructuredRequestConfig

fun main() {
    runBlocking {

// Create different schema structures with different generators
val genericStructure = JsonStructure.create<WeatherForecast>(
    schemaGenerator = StandardJsonSchemaGenerator,
    examples = exampleForecasts
)

val openAiStructure = JsonStructure.create<WeatherForecast>(
    schemaGenerator = OpenAIBasicJsonSchemaGenerator,
    examples = exampleForecasts
)

val anthropicStructure = JsonStructure.create<WeatherForecast>(
    schemaGenerator = AnthropicBasicJsonSchemaGenerator,
    examples = exampleForecasts
)

val promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_KEY"))

// The advanced API uses StructuredRequestConfig instead of simple parameters
val structuredResponse = promptExecutor.executeStructured(
    prompt = prompt("structured-data") {
        system("You are a weather forecasting assistant.")
        user("What is the weather forecast for Amsterdam?")
    },
    model = OpenAIModels.Chat.GPT4oMini,
    config = StructuredRequestConfig(
        byProvider = mapOf(
            LLMProvider.OpenAI to StructuredRequest.Native(openAiStructure),
            LLMProvider.Anthropic to StructuredRequest.Native(anthropicStructure),
        ),
        default = StructuredRequest.Manual(genericStructure)
    ),
    fixingParser = StructureFixingParser(
        model = AnthropicModels.Haiku_4_5,
        retries = 2
    )
)
    }
}
