// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleTesting15

/*

@Test
fun testMultiSubgraphAgentStructure() = runTest {
    val strategy = strategy("test") {
        val firstSubgraph by subgraph(
            "first",
            tools = listOf(DummyTool, CreateTool, SolveTool)
        ) {
            val callLLM by nodeLLMRequest(allowToolCalls = false)
            val executeTool by nodeExecuteTools()
            val sendToolResult by nodeLLMSendToolResults()
            val giveFeedback by node<String, String> { input ->
                llm.writeSession {
                    appendPrompt {
                        user("Call tools! Don't chat!")
                    }
                }
                input
            }

            edge(nodeStart forwardTo callLLM)
            edge(callLLM forwardTo executeTool onToolCalls { true })
            edge(callLLM forwardTo giveFeedback onTextMessage { true })
            edge(giveFeedback forwardTo giveFeedback transformed { it })
            edge(executeTool forwardTo nodeFinish transformed { it.toolResults.first().output })
        }

        val secondSubgraph by subgraph<String, String>("second") {
            edge(nodeStart forwardTo nodeFinish)
        }

        edge(nodeStart forwardTo firstSubgraph)
        edge(firstSubgraph forwardTo secondSubgraph)
        edge(secondSubgraph forwardTo nodeFinish)
    }

    val toolRegistry = ToolRegistry {
        tool(DummyTool)
        tool(CreateTool)
        tool(SolveTool)
    }

    val mockLLMApi = getMockExecutor(toolRegistry) {
        mockLLMAnswer("Hello!") onRequestContains "Hello"
        mockLLMToolCall(CreateTool, CreateTool.Args("solve")) onRequestEquals "Solve task"
    }

    val basePrompt = prompt("test") {}

    AIAgent(
        toolRegistry = toolRegistry,
        strategy = strategy,
        eventHandler = EventHandler {},
        agentConfig = AIAgentConfig(prompt = basePrompt, model = OpenAIModels.Chat.GPT4o, maxAgentIterations = 100),
        promptExecutor = mockLLMApi,
    ) {
        testGraph("test") {
            val firstSubgraph = assertSubgraphByName<String, String>("first")
            val secondSubgraph = assertSubgraphByName<String, String>("second")

            assertEdges {
                startNode() alwaysGoesTo firstSubgraph
                firstSubgraph alwaysGoesTo secondSubgraph
                secondSubgraph alwaysGoesTo finishNode()
            }

            verifySubgraph(firstSubgraph) {
                val start = startNode()
                val finish = finishNode()

                val askLLM = assertNodeByName<String, Message.Assistant>("callLLM")
                val callTool = assertNodeByName<ToolCalls, ReceivedToolResults>("executeTool")
                val giveFeedback = assertNodeByName<Any?, Any?>("giveFeedback")

                assertReachable(start, askLLM)
                assertReachable(askLLM, callTool)

                assertNodes {
                    askLLM withInput "Hello" outputs assistantMessage("Hello!")
                    askLLM withInput "Solve task" outputs assistantMessage(CreateTool, CreateTool.Args("solve"))

                    callTool withInput ToolCalls(listOf(toolCallMessagePart(
                        SolveTool,
                        SolveTool.Args("solve")
                    ))) outputs ReceivedToolResults(listOf(toolResult(SolveTool, SolveTool.Args("solve"), "solved")))

                    callTool withInput ToolCalls(listOf(toolCallMessagePart(
                        CreateTool,
                        CreateTool.Args("solve")
                    ))) outputs ReceivedToolResults(listOf(toolResult(CreateTool, CreateTool.Args("solve"), "created")))
                }

                assertEdges {
                    askLLM withOutput assistantMessage("Hello!") goesTo giveFeedback
                    askLLM withOutput assistantMessage(CreateTool, CreateTool.Args("solve")) goesTo callTool
                }
            }
        }
    }
}
*/
