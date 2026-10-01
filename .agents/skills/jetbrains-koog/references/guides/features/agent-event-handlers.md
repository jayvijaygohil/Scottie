> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# Event handlers

You can monitor and respond to specific events during the agent workflow by using event handlers for logging, testing, debugging, and extending agent behavior.

## Feature overview

The EventHandler feature lets you hook into various agent events. It serves as an event delegation mechanism that:

- Manages the lifecycle of AI agent operations.
- Provides hooks for monitoring and responding to different stages of the workflow.
- Enables error handling and recovery.
- Facilitates tool invocation tracking and result processing.

### Installation and configuration

The EventHandler feature integrates with the agent workflow through the `EventHandler` class,
which provides a way to register callbacks for different agent events, and can be installed as a feature in the agent configuration. For details, see [API reference](../../api/events-and-tracing.md#aikoogagentsfeatureseventhandlerfeatureeventhandler).

To install the feature and configure event handlers for the agent, do the following:

=== "Kotlin"

    
    
    ```kotlin
    handleEvents {
        // Handle tool calls
        onToolCallStarting { eventContext ->
            println("Tool called: ${eventContext.toolName} with args ${eventContext.toolArgs}")
        }
        // Handle event triggered when the agent completes its execution
        onAgentCompleted { eventContext ->
            println("Agent finished with result: ${eventContext.result}")
        }

        // Other event handlers
    }
    ```
    

For more details about event handler configuration, see [API reference](../../api/events-and-tracing.md#aikoogagentsfeatureseventhandlerfeatureeventhandlerconfig).

You can also set up event handlers using the `handleEvents` extension function when creating an agent.
This function also installs the event handler feature and configures event handlers for the agent. Here is an example:

=== "Kotlin"

    
    ```kotlin
    val agent = AIAgent(
        promptExecutor = simpleOllamaAIExecutor(),
        llmModel = OllamaModels.Meta.LLAMA_3_2,
    ){
        handleEvents {
            // Handle tool calls
            onToolCallStarting { eventContext ->
                println("Tool called: ${eventContext.toolName} with args ${eventContext.toolArgs}")
            }
            // Handle event triggered when the agent completes its execution
            onAgentCompleted { eventContext ->
                println("Agent finished with result: ${eventContext.result}")
            }

            // Other event handlers
        }
    }
    ```
    

## Complete Kotlin examples

- [example-event-handlers-01.kt](../../kotlin-examples/example-event-handlers-01.kt)
- [example-event-handlers-02.kt](../../kotlin-examples/example-event-handlers-02.kt)
