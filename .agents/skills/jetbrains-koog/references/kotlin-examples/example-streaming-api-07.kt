// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleStreamingApi07

import ai.koog.agents.example.exampleStreamingApi05.Book
import ai.koog.prompt.structure.markdown.markdownStreamingParser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
fun parseMarkdownStreamToBooks(markdownStream: Flow<String>): Flow<Book> {
    return flow {

markdownStreamingParser {
    // Handle level 1 headings (level ranges from 1 to 6)
    onHeader(1) { headerText -> }
    // Handle bullet points
    onBullet { bulletText -> }
    // Handle code blocks
    onCodeBlock { codeBlockContent -> }
    // Handle lines matching a regex pattern
    onLineMatching(Regex("pattern")) { line -> }
    // Handle the end of the stream
    onFinishStream { remainingText -> }
}
   }
}
