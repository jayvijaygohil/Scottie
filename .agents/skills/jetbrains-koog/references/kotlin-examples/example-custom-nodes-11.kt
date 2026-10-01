// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
@file:OptIn(kotlin.uuid.ExperimentalUuidApi::class)

package ai.koog.agents.example.exampleCustomNodes11

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.prompt.message.MessagePart
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid
val toolName = "my-custom-tool"
@Serializable
data class ToolArgs(val arg1: String, val arg2: Int)
val strategy = strategy<String, String>("strategy_name") {

val nodeExecuteCustomTool by node<String, String>("node_name") { input ->
    val toolCall = MessagePart.Tool.Call(
        id = Uuid.random().toString(),
        tool = toolName,
        args = Json.encodeToString(ToolArgs(arg1 = input, arg2 = 42)) // Use the input as tool arguments
    )

    val result = environment.executeTool(toolCall)
    result.output
}
}
