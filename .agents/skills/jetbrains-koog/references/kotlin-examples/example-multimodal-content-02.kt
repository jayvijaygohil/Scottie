// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleMultimodalContent02

import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.message.AttachmentContent
import ai.koog.prompt.message.AttachmentSource
val prompt = prompt("custom_image") {

user {
    +"Describe this image"
    image(
        AttachmentSource.Image(
            content = AttachmentContent.URL("https://example.com/capture.png"),
            format = "png",
            mimeType = "image/png",
            fileName = "capture.png"
        )
    )
}
}
