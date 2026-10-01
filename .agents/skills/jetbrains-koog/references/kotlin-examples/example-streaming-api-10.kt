// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi10

import ai.koog.agents.core.tools.SimpleTool
import ai.koog.agents.core.tools.ToolDescriptor
import ai.koog.agents.example.exampleStreamingApi05.Book
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

@Serializable
data class Book(
   val title: String,
   val author: String,
   val description: String
)

class BookTool(): SimpleTool<Book>(
    argsType = typeToken<Book>(),
    name = NAME,
    description = "A tool to parse book information from Markdown"
) {

    companion object { const val NAME = "book" }

    override suspend fun execute(args: Book): String {
        println("${args.title} by ${args.author}:\n ${args.description}")
        return "Done"
    }
}
