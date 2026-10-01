// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleParallelNodeExecution07

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.parallel
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.message.MessagePart
import ai.koog.prompt.executor.clients.anthropic.AnthropicModels
import ai.koog.prompt.executor.clients.openai.OpenAIModels

typealias Input = String
typealias Output = String

data class JokeRating(
   val bestJokeIndex: Int,
)

val strategy = strategy("best-joke") {
   // Define nodes for different LLM models
   val nodeOpenAI by node<String, String> { topic ->
      llm.writeSession {
         model = OpenAIModels.Chat.GPT4o
         appendPrompt {
            system("You are a comedian. Generate a funny joke about the given topic.")
            user("Tell me a joke about $topic.")
         }
         val response = requestLLMWithoutTools()
         response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
      }
   }

   val nodeAnthropicSonnet by node<String, String> { topic ->
      llm.writeSession {
         model = AnthropicModels.Sonnet_4_5
         appendPrompt {
            system("You are a comedian. Generate a funny joke about the given topic.")
            user("Tell me a joke about $topic.")
         }
         val response = requestLLMWithoutTools()
         response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
      }
   }

   val nodeAnthropicOpus by node<String, String> { topic ->
      llm.writeSession {
         model = AnthropicModels.Opus_4_6
         appendPrompt {
            system("You are a comedian. Generate a funny joke about the given topic.")
            user("Tell me a joke about $topic.")
         }
         val response = requestLLMWithoutTools()
         response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
      }
   }

   // Execute joke generation in parallel and select the best joke
   val nodeGenerateBestJoke by parallel(
      nodeOpenAI, nodeAnthropicSonnet, nodeAnthropicOpus,
   ) {
      selectByIndex { jokes ->
         // Another LLM (e.g., GPT4o) would find the funniest joke:
         llm.writeSession {
            model = OpenAIModels.Chat.GPT4o
            appendPrompt {
               prompt("best-joke-selector") {
                  system("You are a comedy critic. Give a critique for the given joke.")
                  user(
                     """
                            Here are three jokes about the same topic:

                            ${jokes.mapIndexed { index, joke -> "Joke $index:\n$joke" }.joinToString("\n\n")}

                            Select the best joke and explain why it's the best.
                            """.trimIndent()
                  )
               }
            }

            val response = requestLLMStructured<JokeRating>()
            val bestJoke = response.getOrNull()!!.data
            bestJoke.bestJokeIndex
         }
      }
   }

   // Connect the nodes
   nodeStart then nodeGenerateBestJoke then nodeFinish
}
