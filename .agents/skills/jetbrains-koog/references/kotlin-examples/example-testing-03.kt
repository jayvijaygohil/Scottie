// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting03

import ai.koog.agents.core.tools.*
import ai.koog.agents.ext.tool.AskUser
import ai.koog.agents.ext.tool.SayToUser
import ai.koog.agents.testing.tools.getMockExecutor
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable
import ai.koog.agents.core.tools.annotations.LLMDescription
public object CreateTool : Tool<CreateTool.Args, String>(
    argsType = typeToken<Args>(),
    resultType = typeToken<String>(),
    name = "message",
    description = "Service tool, used by the agent to talk with user"
) {
    /**
    * Represents the arguments for the [AskUser] tool
    *
    * @property message The message to be used as an argument for the tool's execution.
    */
    @Serializable
    public data class Args(
        @property:LLMDescription("Message from the agent")
        val message: String
    )
    override suspend fun execute(args: Args): String = args.message
}
public object SearchTool : Tool<SearchTool.Args, String>(
    argsType = typeToken<Args>(),
    resultType = typeToken<String>(),
    name = "message",
    description = "Service tool, used by the agent to talk with user"
) {
    /**
    * Represents the arguments for the [AskUser] tool
    *
    * @property message The message to be used as an argument for the tool's execution.
    */
    @Serializable
    public data class Args(
        @property:LLMDescription("Message from the agent")
        val query: String
    )
    override suspend fun execute(args: Args): String = args.query
}
public object AnalyzeTool : Tool<AnalyzeTool.Args, String>(
    argsType = typeToken<Args>(),
    resultType = typeToken<String>(),
    name = "message",
    description = "Service tool, used by the agent to talk with user"
) {
    /**
    * Represents the arguments for the [AskUser] tool
    *
    * @property message The message to be used as an argument for the tool's execution.
    */
    @Serializable
    public data class Args(
        @property:LLMDescription("Message from the agent")
        val query: String
    )
    override suspend fun execute(args: Args): String = args.query
}
typealias PositiveToneTool = SayToUser
typealias NegativeToneTool = SayToUser
val mockLLMApi = getMockExecutor {

// Mock a tool call response
mockLLMToolCall(CreateTool, CreateTool.Args("solve")) onRequestEquals "Solve task"

// Mock tool behavior - simplest form without lambda
mockTool(PositiveToneTool) alwaysReturns "The text has a positive tone."

// Using lambda when you need to perform extra actions
mockTool(NegativeToneTool) alwaysTells {
  // Perform some extra action
  println("Negative tone tool called")

  // Return the result
  "The text has a negative tone."
}

// Mock tool behavior based on specific arguments
mockTool(AnalyzeTool) returns "Detailed analysis" onArguments AnalyzeTool.Args("analyze deeply")

// Mock tool behavior with conditional argument matching
mockTool(SearchTool) returns "Found results" onArgumentsMatching { args ->
  args.query.contains("important")
}
}
