// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleCustomSubgraphs08

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.core.dsl.builder.subgraph
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
import ai.koog.agents.core.dsl.extension.onTextMessage
import ai.koog.agents.core.dsl.extension.onToolCalls
import ai.koog.agents.core.tools.SimpleTool
import ai.koog.agents.core.tools.ToolDescriptor
import ai.koog.prompt.dsl.prompt
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable
class WebSearchTool: SimpleTool<WebSearchTool.Args>(
    argsType = typeToken<Args>(),
    name = "web_search",
    description = "Search on the web"
) {
    @Serializable
    class Args(val query: String)
    override suspend fun execute(args: Args): String {
        return "Searching for ${args.query} on the web..."
    }
}
class DoAction: SimpleTool<DoAction.Args>(
    argsType = typeToken<Args>(),
    name = "do_action",
    description = "Do something"
) {
    @Serializable
    class Args(val action: String)
    override suspend fun execute(args: Args): String {
        return "Doing action..."
    }
}
class DoAnotherAction: SimpleTool<DoAnotherAction.Args>(
    argsType = typeToken<Args>(),
    name = "do_another_action",
    description = "Do something other"
) {
    @Serializable
    class Args(val action: String)
    override suspend fun execute(args: Args): String {
        return "Doing another action..."
    }
}

// Define the agent strategy
val strategy = strategy<String, String>("assistant") {

    // A subgraph that includes a tool call
    val researchSubgraph by subgraph<String, String>(
        "research_subgraph",
        tools = listOf(WebSearchTool())
    ) {
        val nodeCallLLM by nodeLLMRequest("call_llm")
        val nodeExecuteTool by nodeExecuteTools()
        val nodeSendToolResult by nodeLLMSendToolResults()

        edge(nodeStart forwardTo nodeCallLLM)
        edge(nodeCallLLM forwardTo nodeExecuteTool onToolCalls { true })
        edge(nodeExecuteTool forwardTo nodeSendToolResult)
        edge(nodeSendToolResult forwardTo nodeExecuteTool onToolCalls { true })
        edge(nodeCallLLM forwardTo nodeFinish onTextMessage { true })
    }

    val planSubgraph by subgraph(
        "plan_subgraph",
        tools = listOf()
    ) {
        val nodeUpdatePrompt by node<String, Unit> { research ->
            llm.writeSession {
                rewritePrompt {
                    prompt("research_prompt") {
                        system(
                            "You are given a problem and some research on how it can be solved." +
                                    "Make step by step a plan on how to solve given task."
                        )
                        user("Research: $research")
                    }
                }
            }
        }
        val nodeCallLLM by nodeLLMRequest("call_llm")

        edge(nodeStart forwardTo nodeUpdatePrompt)
        edge(nodeUpdatePrompt forwardTo nodeCallLLM transformed { "Task: $agentInput" })
        edge(nodeCallLLM forwardTo nodeFinish onTextMessage { true })
    }

    val executeSubgraph by subgraph<String, String>(
        "execute_subgraph",
        tools = listOf(DoAction(), DoAnotherAction()),
    ) {
        val nodeUpdatePrompt by node<String, Unit> { plan ->
            llm.writeSession {
                rewritePrompt {
                    prompt("execute_prompt") {
                        system(
                            "You are given a task and detailed plan how to execute it." +
                                    "Perform execution by calling relevant tools."
                        )
                        user("Execute: $plan")
                        user("Plan: $plan")
                    }
                }
            }
        }
        val nodeCallLLM by nodeLLMRequest("call_llm")
        val nodeExecuteTool by nodeExecuteTools()
        val nodeSendToolResult by nodeLLMSendToolResults()

        edge(nodeStart forwardTo nodeUpdatePrompt)
        edge(nodeUpdatePrompt forwardTo nodeCallLLM transformed { "Task: $agentInput" })
        edge(nodeCallLLM forwardTo nodeExecuteTool onToolCalls { true })
        edge(nodeExecuteTool forwardTo nodeSendToolResult)
        edge(nodeSendToolResult forwardTo nodeExecuteTool onToolCalls { true })
        edge(nodeCallLLM forwardTo nodeFinish onTextMessage { true })
    }

    nodeStart then researchSubgraph then planSubgraph then executeSubgraph then nodeFinish
}
