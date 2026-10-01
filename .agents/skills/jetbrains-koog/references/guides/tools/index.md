> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# Overview

 Agents use tools to perform specific tasks or access external systems.

## Tool workflow

1. Create a custom tool or use one of the built-in tools.
2. Add the tool to a tool registry.
3. Pass the tool registry to an agent.
4. Use the tool with the agent.

### Available tool types

There are three types of tools in the Koog framework:

- Built-in tools that provide functionality for agent-user interaction and conversation management. For details, see [Built-in tools](built-in-tools.md).
- Annotation-based custom tools that let you expose functions as tools to LLMs. For details, see [Annotation-based tools](annotation-based-tools.md).
- Custom tools that let you control tool parameters, metadata, execution logic, and how it is registered and invoked. For details, see [Class-based
  tools](class-based-tools.md).

### Tool registry

Before you can use a tool in an agent, you must add it to a tool registry.
The tool registry manages all tools available to the agent.

The key features of the tool registry:

- Organizes tools.
- Supports merging of multiple tool registries.
- Provides methods to retrieve tools by name or type.

To learn more, see [ToolRegistry](../../api/tools.md#aikoogagentscoretoolstoolregistry).

Here is an example of how to create the tool registry and add the tool to it:

=== "Kotlin"

    
    ```kotlin
    val toolRegistry = ToolRegistry {
        tools(myTool)
    }
    ```
    

To merge multiple tool registries, do the following:

=== "Kotlin"

    
    ```kotlin
    val firstToolRegistry = ToolRegistry {
        tools(firstSampleTool)
    }
    
    val secondToolRegistry = ToolRegistry {
        tools(secondSampleTool)
    }
    
    val newRegistry = firstToolRegistry + secondToolRegistry
    ```
    

### Passing tools to an agent

To enable an agent to use a tool, you need to provide a tool registry that contains this tool as an argument when creating the agent:

=== "Kotlin"

    
    ```kotlin
    // Agent initialization
    val agent = AIAgent(
        promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_API_KEY")),
        systemPrompt = "You are a helpful assistant with strong mathematical skills.",
        llmModel = OpenAIModels.Chat.GPT4o,
        // Pass your tool registry to the agent
        toolRegistry = toolRegistry
    )
    ```
    

### Calling tools

There are several ways to call tools within your agent code. The recommended approach is to use the provided methods
in the agent context rather than calling tools directly, as this ensures proper handling of tool operation within the
agent environment.

!!! tip
    Ensure you have implemented proper [error handling](../features/agent-event-handlers.md) in your tools to prevent agent failure.

The tools are called within a specific session context represented by `AIAgentLLMWriteSession`.
It provides several methods for calling tools so that you can:

- Call a tool with the given arguments.
- Call a tool by its name and the given arguments.
- Call a tool by the provided tool class and arguments.
- Call a tool of the specified type with the given arguments.
- Call a tool that returns a raw string result.

For more details, the API reference for [AIAgentLLMWriteSession](../../api/sessions.md#aikoogagentscoreagentsessionaiagentllmwritesession).

#### Parallel tool calls

You can also call tools in parallel using the `toParallelToolCallsRaw` extension. For example:

=== "Kotlin"

    
    ```kotlin
    @Serializable
    data class Book(
        val title: String,
        val author: String,
        val description: String
    )
    
    class BookTool() : SimpleTool<Book>(
        argsType = typeToken<Book>(),
        name = NAME,
        description = "A tool to parse book information from Markdown"
    ) {
        companion object {
            const val NAME = "book"
        }
    
        override suspend fun execute(args: Book): String {
            println("${args.title} by ${args.author}:\n ${args.description}")
            return "Done"
        }
    }
    
    val strategy = strategy<Unit, Unit>("strategy-name") {
    
        /*...*/
    
        val myNode by node<Unit, Unit> { _ ->
            llm.writeSession {
                flow {
                    emit(Book("Book 1", "Author 1", "Description 1"))
                }.toParallelToolCallsRaw(BookTool::class).collect()
            }
        }
    }
    
    ```
    

#### Calling tools from nodes

When building agent workflows with nodes, you can use special nodes to call tools:

* **nodeExecuteTool**: calls a single tool call and returns its result. For details, see API reference.

* **nodeExecuteSingleTool** that calls a specific tool with the provided arguments. For details, see [API reference](../../api/graph-dsl.md#aikoogagentscoredslextensionnodeexecutesingletool).

* **nodeExecuteMultipleTools** that performs multiple tool calls and returns their results. For details, see API reference.

* **nodeLLMSendToolResult** that sends a tool result to the LLM and gets a response. For details, see API reference.

* **nodeLLMSendMultipleToolResults** that sends multiple tool results to the LLM. For details, see API reference.

## Using agents as tools

The framework provides the capability to convert any AI agent into a tool that can be used by other agents. 
This powerful feature enables you to create hierarchical agent architectures where specialized agents can be called as tools by higher-level orchestrating agents.

### Converting agents to tools

To convert an agent into a tool, use the `AIAgentService` and the `createAgentTool()` extension function:

=== "Kotlin"

    
    ```kotlin
    // Create a specialized agent service, responsible for creating financial analysis agents.
    val analysisAgentService = AIAgentService(
        promptExecutor = simpleOpenAIExecutor(apiKey),
        llmModel = OpenAIModels.Chat.GPT4o,
        systemPrompt = "You are a financial analysis specialist.",
        toolRegistry = analysisToolRegistry
    )
    
    // Create a tool that would run financial analysis agent once called.
    val analysisAgentTool = analysisAgentService.createAgentTool(
        agentName = "analyzeTransactions",
        agentDescription = "Performs financial transaction analysis",
        inputDescription = "Transaction analysis request",
        inputType = typeToken<String>(),
    )
    ```
    

### Using agent tools in other agents

Once converted to a tool, you can add the agent tool to another agent's tool registry:

=== "Kotlin"

    
    ```kotlin
    // Create a coordinator agent that can use specialized agents as tools
    val coordinatorAgent = AIAgent(
        promptExecutor = simpleOpenAIExecutor(apiKey),
        llmModel = OpenAIModels.Chat.GPT4o,
        systemPrompt = "You coordinate different specialized services.",
        toolRegistry = ToolRegistry {
            tool(analysisAgentTool)
            // Add other tools as needed
        }
    )
    ```
    

### Agent tool execution

When an agent tool is called:

1. The arguments are deserialized according to the input descriptor.
2. The wrapped agent is executed with the deserialized input.
3. The agent's output is serialized and returned as the tool result.

### Benefits of agents as tools

- **Modularity**: Break complex workflows into specialized agents.
- **Reusability**: Use the same specialized agent across multiple coordinator agents.
- **Separation of concerns**: Each agent can focus on its specific domain.

## Complete Kotlin examples

- [example-tools-overview-01.kt](../../kotlin-examples/example-tools-overview-01.kt)
- [example-tools-overview-02.kt](../../kotlin-examples/example-tools-overview-02.kt)
- [example-tools-overview-03.kt](../../kotlin-examples/example-tools-overview-03.kt)
- [example-tools-overview-04.kt](../../kotlin-examples/example-tools-overview-04.kt)
- [example-tools-overview-05.kt](../../kotlin-examples/example-tools-overview-05.kt)
- [example-tools-overview-06.kt](../../kotlin-examples/example-tools-overview-06.kt)
