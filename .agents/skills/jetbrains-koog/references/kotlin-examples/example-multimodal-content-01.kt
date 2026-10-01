// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleMultimodalContent01

import ai.koog.prompt.dsl.prompt
import kotlinx.io.files.Path
val prompt = prompt("image_analysis") {

user {
    +"Describe these images:"

    image("https://example.com/test.png")
    image(Path("/path/to/image.png"))

    +"Focus on the main subjects."
}
}
