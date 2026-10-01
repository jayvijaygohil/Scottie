// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAnnotationBasedTools02

import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool

@Tool
@LLMDescription("Performs a specific operation and returns the result")
fun myTool(): String {
    // Function implementation
    return "Result"
}
