// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleClassBasedTools02

import ai.koog.agents.core.tools.SimpleTool
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

// Create a tool that casts a string expression to a double value
object CastToDoubleTool : SimpleTool<CastToDoubleTool.Args>(
    argsType = typeToken<Args>(),
    name = "cast_to_double",
    description = "casts the passed expression to double or returns 0.0 if the expression is not castable"
) {
    // Define tool arguments
    @Serializable
    data class Args(
        @property:LLMDescription("An expression to case to double")
        val expression: String,
        @property:LLMDescription("A comment on how to process the expression")
        val comment: String
    )

    // Function that executes the tool with the provided arguments
    override suspend fun execute(args: Args): String {
        return "Result: ${castToDouble(args.expression)}, " + "the comment was: ${args.comment}"
    }

    // Function to cast a string expression to a double value
    private fun castToDouble(expression: String): Double {
        return expression.toDoubleOrNull() ?: 0.0
    }
}
