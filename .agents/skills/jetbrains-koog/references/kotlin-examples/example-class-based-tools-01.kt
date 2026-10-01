// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleClassBasedTools01

import ai.koog.agents.core.tools.Tool
import ai.koog.agents.core.tools.ToolDescriptor
import ai.koog.agents.core.tools.ToolParameterDescriptor
import ai.koog.agents.core.tools.ToolParameterType
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable
import ai.koog.agents.core.tools.annotations.LLMDescription

// Implement a simple calculator tool that adds two digits
object CalculatorTool : Tool<CalculatorTool.Args, Int>(
    argsType = typeToken<Args>(),
    resultType = typeToken<Int>(),
    name = "calculator",
    description = "A simple calculator that can add two digits (0-9)."
) {

    // Arguments for the calculator tool
    @Serializable
    data class Args(
        @property:LLMDescription("The first digit to add (0-9)")
        val digit1: Int,
        @property:LLMDescription("The second digit to add (0-9)")
        val digit2: Int
    ) {
        init {
            require(digit1 in 0..9) { "digit1 must be a single digit (0-9)" }
            require(digit2 in 0..9) { "digit2 must be a single digit (0-9)" }
        }
    }

    // Function to add two digits
    override suspend fun execute(args: Args): Int = args.digit1 + args.digit2
}
