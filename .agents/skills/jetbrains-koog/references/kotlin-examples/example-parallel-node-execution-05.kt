// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleParallelNodeExecution05

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.structure.json.JsonStructure

typealias Input = String
typealias Output = String

data class JokeRating(
   val bestJokeIndex: Int,
)

val strategy = strategy<String, String>("strategy_name") {
   val nodeOpenAI by node<Input, Output>() { "openai" }
   val nodeAnthropicSonnet by node<Input, Output>() { "sonnet" }
   val nodeAnthropicOpus by node<Input, Output>() { "opus" }

val nodeBestJoke by parallel<String, String>(
   nodeOpenAI, nodeAnthropicSonnet, nodeAnthropicOpus,
) {
   selectByIndex { jokes ->
      // Use another LLM to determine the best joke
      llm.writeSession {
         model = OpenAIModels.Chat.GPT4o
         appendPrompt {
            system("You are a comedy critic. Select the best joke.")
            user("Here are three jokes: ${jokes.joinToString("\n\n")}")
         }
         val response = requestLLMStructured<JokeRating>()
         response.getOrNull()!!.data.bestJokeIndex
      }
   }
}
}
