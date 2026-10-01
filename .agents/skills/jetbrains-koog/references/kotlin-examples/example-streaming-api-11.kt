// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi11

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.example.exampleStreamingApi06.markdownBookDefinition
import ai.koog.agents.example.exampleStreamingApi08.parseMarkdownStreamToBooks
import ai.koog.agents.example.exampleStreamingApi10.BookTool
import ai.koog.agents.core.agent.session.callToolRaw

val agentStrategy = strategy<String, Unit>("library-assistant") {
   val getMdOutput by node<String, Unit> { input ->
      val mdDefinition = markdownBookDefinition()

      llm.writeSession {
         appendPrompt { user(input) }
         val markdownStream = requestLLMStreaming(mdDefinition)

         parseMarkdownStreamToBooks(markdownStream).collect { book ->
            callToolRaw(BookTool.NAME, book)
            /* Other possible options:
                callTool(BookTool::class, book)
                callTool<BookTool>(book)
                findTool(BookTool::class).execute(book)
            */
         }

         // We can make parallel tool calls
         parseMarkdownStreamToBooks(markdownStream).toParallelToolCallsRaw(toolClass=BookTool::class).collect {
            println("Tool call result: $it")
         }
      }
   }

   edge(nodeStart forwardTo getMdOutput)
   edge(getMdOutput forwardTo nodeFinish)
 }
