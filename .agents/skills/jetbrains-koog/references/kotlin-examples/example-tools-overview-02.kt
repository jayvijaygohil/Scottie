// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleToolsOverview02

import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.annotations.Tool
import ai.koog.agents.core.tools.reflect.ToolSet
class FirstToolSet : ToolSet {
    @Tool
    fun firstSampleTool(): String {
        // Tool implementation
        return "First result"
    }
}
class SecondToolSet : ToolSet {
    @Tool
    fun secondSampleTool(): String {
        // Tool implementation
        return "Second result"
    }
}
val firstSampleTool = FirstToolSet()
val secondSampleTool = SecondToolSet()

val firstToolRegistry = ToolRegistry {
    tools(firstSampleTool)
}

val secondToolRegistry = ToolRegistry {
    tools(secondSampleTool)
}

val newRegistry = firstToolRegistry + secondToolRegistry
