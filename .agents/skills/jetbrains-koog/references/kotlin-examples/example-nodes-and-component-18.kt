// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleNodesAndComponent18

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.example.exampleStreamingApi05.Book
import ai.koog.agents.example.exampleStreamingApi06.markdownBookDefinition
import ai.koog.agents.example.exampleStreamingApi08.parseMarkdownStreamToBooks

val agentStrategy = strategy<String, List<Book>>("library-assistant") {
    // Describe the node containing the output stream parsing
    val getMdOutput by node<String, List<Book>> { booksDescription ->
        val books = mutableListOf<Book>()
        val mdDefinition = markdownBookDefinition()

        llm.writeSession {
            appendPrompt { user(booksDescription) }
            // Initiate the response stream in the form of the definition `mdDefinition`
            val markdownStream = requestLLMStreaming(mdDefinition)
            // Call the parser with the result of the response stream and perform actions with the result
            parseMarkdownStreamToBooks(markdownStream).collect { book ->
                books.add(book)
                println("Parsed Book: ${book.title} by ${book.author}")
            }
        }

        books
    }
    // Describe the agent's graph making sure the node is accessible
    edge(nodeStart forwardTo getMdOutput)
    edge(getMdOutput forwardTo nodeFinish)
}
