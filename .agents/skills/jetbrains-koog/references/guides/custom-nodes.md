> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../version-and-migration.md) before adapting snippets.

# Custom node implementation

This page provides detailed instructions on how to implement your own custom nodes in the Koog framework. 
Custom nodes let you extend the functionality of agent workflows by creating reusable components that perform specific
operations.

To learn more about what graph nodes are, their usage, and existing default nodes, see [Graph nodes](nodes-and-components.md).

## Node architecture overview

Before diving into implementation details, it is important to understand the architecture of nodes in the Koog framework. Nodes are the fundamental building blocks of agent workflows, where each node represents a specific operation or transformation in the workflow. You connect nodes using edges, which define the flow of execution between nodes.

Each node has an `execute` method that takes an input and produces an output, which is then passed to the next node in the workflow.

## Implementing a custom node

Custom node implementations range from simple implementations that perform a basic logic on the input data and return
an output, to more complex node implementations that accept parameters and maintain state between runs.

### Basic node implementation

The simplest way to implement a custom node in a graph and define your own custom logic would be to use the following pattern:

=== "Kotlin"

    
    
    ```kotlin
    val myNode by node<Input, Output>("node_name") { input ->
        // Processing
        returnValue
    }
    ```
    

The code above represents a custom node `myNode` with predefined `Input` and `Output` types, with the optional name
pattern.

In an actual example, here is a simple node that takes a string input and returns the input's length:

=== "Kotlin"

    
    
    ```kotlin
    val myNode by node<String, Int>("node_name") { input ->
        // Processing
        input.length
    }
    ```
    

Another way to create a custom node is to extract it into a reusable function. In Kotlin, you define an extension 
a helper method.

=== "Kotlin"

    
    
    ```kotlin
    fun AIAgentSubgraphBuilderBase<*, *>.myCustomNode(
        name: String? = null
    ): AIAgentNodeDelegate<Input, Output> = node(name) { input ->
        // Custom logic
        input // Return the input as output (pass-through)
    }

    val myCustomNode by myCustomNode("node_name")
    ```
    

This creates a pass-through node that performs some custom logic but returns the input as the output without 
modification.

### Nodes with additional arguments

You can create nodes that accept arguments to customize their behavior:

=== "Kotlin"

    
    
    ```kotlin
        fun AIAgentSubgraphBuilderBase<*, *>.myNodeWithArguments(
        name: String? = null,
        arg1: String,
        arg2: Int
    ): AIAgentNodeDelegate<Input, Output> = node(name) { input ->
        // Use arg1 and arg2 in your custom logic
        input // Return the input as the output
    }

    val myCustomNode by myNodeWithArguments("node_name", arg1 = "value1", arg2 = 42)
    ```
    

### Parameterized nodes

You can define nodes with generic input and output type parameters. In Kotlin, you use `inline` functions with `reified` 

=== "Kotlin"

    
    ```kotlin
    inline fun <reified T> AIAgentSubgraphBuilderBase<*, *>.myParameterizedNode(
        name: String? = null,
    ): AIAgentNodeDelegate<T, T> = node(name) { input ->
        // Do some additional actions
        // Return the input as the output
        input
    }

    val strategy = strategy<String, String>("strategy_name") {
        val myCustomNode by myParameterizedNode<String>("node_name")
    }
    ```
    

### Stateful nodes

If your node needs to maintain state between runs, you can use closure variables. In Kotlin, you declare a variable in 
effectively final.

=== "Kotlin"

    
    ```kotlin
    fun AIAgentSubgraphBuilderBase<*, *>.myStatefulNode(
        name: String? = null
    ): AIAgentNodeDelegate<Input, Output> {
        var counter = 0

        return node(name) { input ->
            counter++
            println("Node executed $counter times")
            input
        }
    }
    ```
    

## Node input and output types

parameters:

=== "Kotlin"

    
    
    ```kotlin
    val stringToIntNode by node<String, Int>("node_name") { input: String ->
        // Processing
        input.toInt() // Convert string to integer
    }
    ```
    

!!! note
    The input and output types determine how the node can be connected to other nodes in the workflow. Nodes can only be connected if the output type of the source node is compatible with the input type of the target node.

## Best practices

When implementing custom nodes, follow these best practices:

1. **Keep nodes focused**: each node should perform a single, well-defined operation.
2. **Use descriptive names**: node names should clearly indicate their purpose.
3. **Document parameters**: provide clear documentation for all parameters.
4. **Handle errors gracefully**: implement proper error handling to prevent workflow failures.
5. **Make nodes reusable**: design nodes to be reusable across different workflows.
6. **Use type parameters**: use generic type parameters when appropriate to make nodes more flexible.
7. **Provide default values**: when possible, provide sensible default values for parameters.

## Common patterns

The following sections provide some common patterns for implementing custom nodes.

### Pass-through nodes

Nodes that perform an operation but return the input as the output.

=== "Kotlin"

    
    
    ```kotlin
    val loggingNode by node<String, String>("node_name") { input ->
        println("Processing input: $input")
        input // Return the input as the output
    }
    ```
    

### Transformation nodes

Nodes that transform the input data and produce a modified output.

=== "Kotlin"

    
    
    ```kotlin
    val upperCaseNode by node<String, String>("node_name") { input ->
        println("Processing input: $input")
        input.uppercase() // Transform the input to uppercase
    }
    ```
    

### LLM interaction nodes

use pre-built factory methods like `AIAgentNode.llmRequest()` that handle prompt construction automatically.

=== "Kotlin"

    
    
    ```kotlin
    val summarizeTextNode by node<String, String>("node_name") { input ->
        llm.writeSession {
            appendPrompt {
                user("Please summarize the following text: $input")
            }

            val response = requestLLMWithoutTools()
            response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
        }
    }
    ```
    

!!! note

### Tool run node

typically use subgraphs that delegate tool orchestration to the LLM.

=== "Kotlin"

    
    
    ```kotlin
    val nodeExecuteCustomTool by node<String, String>("node_name") { input ->
        val toolCall = MessagePart.Tool.Call(
            id = UUID.randomUUID().toString(),
            tool = toolName,
            args = Json.encodeToString(ToolArgs(arg1 = input, arg2 = 42)) // Use the input as tool arguments
        )

        val result = environment.executeTool(toolCall)
        result.output
    }
    ```
    

!!! note

## Complete Kotlin examples

- [example-custom-nodes-01.kt](../kotlin-examples/example-custom-nodes-01.kt)
- [example-custom-nodes-02.kt](../kotlin-examples/example-custom-nodes-02.kt)
- [example-custom-nodes-03.kt](../kotlin-examples/example-custom-nodes-03.kt)
- [example-custom-nodes-04.kt](../kotlin-examples/example-custom-nodes-04.kt)
- [example-custom-nodes-05.kt](../kotlin-examples/example-custom-nodes-05.kt)
- [example-custom-nodes-06.kt](../kotlin-examples/example-custom-nodes-06.kt)
- [example-custom-nodes-07.kt](../kotlin-examples/example-custom-nodes-07.kt)
- [example-custom-nodes-08.kt](../kotlin-examples/example-custom-nodes-08.kt)
- [example-custom-nodes-09.kt](../kotlin-examples/example-custom-nodes-09.kt)
- [example-custom-nodes-10.kt](../kotlin-examples/example-custom-nodes-10.kt)
- [example-custom-nodes-11.kt](../kotlin-examples/example-custom-nodes-11.kt)
