// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleToolsOverview01

import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.annotations.Tool
import ai.koog.agents.core.tools.reflect.ToolSet
class MyToolSet : ToolSet {
    @Tool
    fun myTool(): String {
        // Tool implementation
        return "Result"
    }
}
val myTool = MyToolSet()

val toolRegistry = ToolRegistry {
    tools(myTool)
}
