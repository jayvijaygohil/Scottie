// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleToolsOverview04

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.tools.SimpleTool
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val title: String,
    val author: String,
    val description: String
)

class BookTool() : SimpleTool<Book>(
    argsType = typeToken<Book>(),
    name = NAME,
    description = "A tool to parse book information from Markdown"
) {
    companion object {
        const val NAME = "book"
    }

    override suspend fun execute(args: Book): String {
        println("${args.title} by ${args.author}:\n ${args.description}")
        return "Done"
    }
}

val strategy = strategy<Unit, Unit>("strategy-name") {

    /*...*/

    val myNode by node<Unit, Unit> { _ ->
        llm.writeSession {
            flow {
                emit(Book("Book 1", "Author 1", "Description 1"))
            }.toParallelToolCallsRaw(BookTool::class).collect()
        }
    }
}

