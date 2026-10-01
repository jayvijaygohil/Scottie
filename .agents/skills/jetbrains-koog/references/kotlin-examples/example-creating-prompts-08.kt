// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCreatingPrompts08

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.markdown.markdown
import ai.koog.prompt.xml.xml

val prompt = prompt("markdown_xml_example") {
    // A user message in Markdown format
    user {
        markdown {
            h2("Evaluate the article using the following criteria:")
            bulleted {
                item { +"Clarity and readability" }
                item { +"Accuracy of information" }
                item { +"Usefulness to the reader" }
            }
        }
    }
    // An assistant message in XML format
    assistant {
        xml {
            xmlDeclaration()
            tag("review") {
                tag("clarity") { text("positive") }
                tag("accuracy") { text("neutral") }
                tag("usefulness") { text("positive") }
            }
        }
    }
}
