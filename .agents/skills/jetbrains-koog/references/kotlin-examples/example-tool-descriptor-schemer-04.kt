// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleToolDescriptorSchemer04

import kotlinx.serialization.json.Json
import ai.koog.prompt.executor.clients.openai.base.OpenAICompatibleToolDescriptorSchemaGenerator
import ai.koog.agents.core.tools.ToolDescriptor
import ai.koog.agents.core.tools.ToolParameterDescriptor
import ai.koog.agents.core.tools.ToolParameterType
fun getUserTool(): ToolDescriptor {
    return ToolDescriptor(
        name = "get_user",
        description = "Returns user profile by id",
        requiredParameters = listOf(
            ToolParameterDescriptor(
                name = "id",
                description = "User id",
                type = ToolParameterType.String
            )
        )
    )
}

val json = Json { prettyPrint = true }
val schema = OpenAICompatibleToolDescriptorSchemaGenerator().generate(getUserTool())
