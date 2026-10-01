// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleFunctionalAgent03

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.functionalStrategy
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.agents.core.tools.annotations.Tool
import ai.koog.agents.core.tools.reflect.ToolSet
import ai.koog.prompt.message.MessagePart
import ai.koog.prompt.executor.llms.all.simpleOllamaAIExecutor
import ai.koog.prompt.executor.ollama.client.OllamaModels
import kotlinx.coroutines.runBlocking

@LLMDescription("Tools for performing math operations")
class MathTools : ToolSet {
    @Tool
    @LLMDescription("Multiplies two numbers and returns the result")
    fun multiply(a: Int, b: Int): Int {
        // This is not necessary, but it helps to see the tool call in the console output
        println("Multiplying $a and $b...")
        return a * b
    }
}

val toolRegistry = ToolRegistry {
    tool(MathTools()::multiply)
}

val strategy = functionalStrategy<String, String> { input ->
    // Send the user input to the LLM
    var response = requestLLM(input)

    // Only loop while the LLM requests tools
    var toolCalls = response.parts.filterIsInstance<MessagePart.Tool.Call>()
    while (toolCalls.isNotEmpty()) {
        // Execute the tools and return the results
        val results = executeTools(toolCalls)
        // Send the tool results back to the LLM. The LLM may call more tools or return a final output
        response = sendToolResults(results)
        toolCalls = response.parts.filterIsInstance<MessagePart.Tool.Call>()
    }

    // When no tool calls remain, extract and return the assistant message content from the response
    response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
}

val mathAgentWithTools = AIAgent(
    promptExecutor = simpleOllamaAIExecutor(),
    llmModel = OllamaModels.Meta.LLAMA_3_2,
    toolRegistry = toolRegistry,
    strategy = strategy
)

fun main() = runBlocking {
    val result = mathAgentWithTools.run("Multiply 3 by 4, then multiply the result by 5.")
    println(result)
}
