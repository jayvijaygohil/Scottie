// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAnnotationBasedTools03

import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool

@Tool
@LLMDescription("Processes input data")
fun processTool(
    @LLMDescription("The input data to process")
    input: String,

    @LLMDescription("Optional configuration parameters")
    config: String = ""
): String {
    // Function implementation
    return "Processed: $input with config: $config"
}
