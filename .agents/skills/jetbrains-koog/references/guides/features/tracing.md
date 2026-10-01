> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# Tracing

This page includes details about the Tracing feature, which provides comprehensive tracing capabilities for AI agents.

## Feature overview

The Tracing feature is a powerful monitoring and debugging tool that captures detailed information about agent runs,
including:

- Strategy execution
- LLM calls
- LLM streaming (start, frames, completion, errors)
- Tool calls
- Node execution within the agent graph

This feature operates by intercepting key events in the agent pipeline and forwarding them to configurable message
processors. These processors can output the trace information to various destinations such as log files or other types
of files in the filesystem, enabling developers to gain insights into agent behavior and troubleshoot issues effectively.

### Event flow

1. The Tracing feature intercepts events in the agent pipeline.
2. Events are filtered based on the configured message filter.
3. Filtered events are passed to registered message processors.
4. Message processors format and output the events to their respective destinations.

## Configuration and initialization

### Basic setup

To use the Tracing feature, you need to:

1. Have one or more message processors (you can use the existing ones or create your own).
2. Install `Tracing` in your agent.
3. Configure the message filter (optional).
4. Add the message processors to the feature.

=== "Kotlin"

    
    ```kotlin
    // Defining a logger/file that will be used as a destination of trace messages 
    val logger = KotlinLogging.logger { }
    val outputPath = Path("/path/to/trace.log")
    
    // Creating an agent
    val agent = AIAgent(
        promptExecutor = simpleOllamaAIExecutor(),
        llmModel = OllamaModels.Meta.LLAMA_3_2,
    ) {
        install(Tracing) {
            // Configure message processors to handle trace events
            addMessageProcessor(TraceFeatureMessageLogWriter(logger))
            addMessageProcessor(TraceFeatureMessageFileWriter.create(outputPath))
        }
    }
    ```
    

### Message filtering

You can process all existing events or select some of them based on specific criteria.
The message filter lets you control which events are processed. This is useful for focusing on specific aspects of
agent runs:

=== "Kotlin"

    
    
    ```kotlin
    
    val fileWriter = TraceFeatureMessageFileWriter(
        outputPath,
        { path: Path -> SystemFileSystem.sink(path).buffered() }
    )
    
    addMessageProcessor(fileWriter)
    
    // Filter for LLM-related events only
    fileWriter.setMessageFilter { message ->
        message is LLMCallStartingEvent || message is LLMCallCompletedEvent
    }
    
    // Filter for tool-related events only
    fileWriter.setMessageFilter { message -> 
        message is ToolCallStartingEvent ||
            message is ToolCallCompletedEvent ||
            message is ToolValidationFailedEvent ||
            message is ToolCallFailedEvent
    }
    
    // Filter for node execution events only
    fileWriter.setMessageFilter { message -> 
        message is NodeExecutionStartingEvent || message is NodeExecutionCompletedEvent
    }
    ```
    

### Large trace volumes

For agents with complex strategies or long-running executions, the volume of trace events can be substantial. Consider using the following methods to manage the volume of events:

- Use specific message filters to reduce the number of events.
- Implement custom message processors with buffering or sampling.
- Use file rotation for log files to prevent them from growing too large.

### Dependency graph

The Tracing feature has the following dependencies:

```
Tracing
├── AIAgentPipeline (for intercepting events)
├── TraceFeatureConfig
│   └── FeatureConfig
├── Message Processors
│   ├── TraceFeatureMessageLogWriter
│   │   └── FeatureMessageLogWriter
│   ├── TraceFeatureMessageFileWriter
│   │   └── FeatureMessageFileWriter
│   └── TraceFeatureMessageRemoteWriter
│       └── FeatureMessageRemoteWriter
└── Event Types (from ai.koog.agents.core.feature.model)
    ├── AgentStartingEvent
    ├── AgentCompletedEvent
    ├── AgentExecutionFailedEvent
    ├── AgentClosingEvent
    ├── GraphStrategyStartingEvent
    ├── FunctionalStrategyStartingEvent
    ├── StrategyCompletedEvent
    ├── NodeExecutionStartingEvent
    ├── NodeExecutionCompletedEvent
    ├── NodeExecutionFailedEvent
    ├── SubgraphExecutionStartingEvent
    ├── SubgraphExecutionCompletedEvent
    ├── SubgraphExecutionFailedEvent
    ├── LLMCallStartingEvent
    ├── LLMCallCompletedEvent
    ├── LLMCallFailedEvent
    ├── LLMStreamingStartingEvent
    ├── LLMStreamingFrameReceivedEvent
    ├── LLMStreamingFailedEvent
    ├── LLMStreamingCompletedEvent
    ├── ToolCallStartingEvent
    ├── ToolValidationFailedEvent
    ├── ToolCallFailedEvent
    └── ToolCallCompletedEvent
```

## Examples and quickstarts

### Basic tracing to logger

=== "Kotlin"

    
    
    ```kotlin
    // Create a logger
    val logger = KotlinLogging.logger { }

    // Create an agent with tracing
    val agent = AIAgent(
        promptExecutor = simpleOllamaAIExecutor(),
        llmModel = OllamaModels.Meta.LLAMA_3_2,
    ) {
        install(Tracing) {
            addMessageProcessor(TraceFeatureMessageLogWriter(logger))
        }
    }

    // Run the agent
    agent.run("Hello, agent!")
    ```
    

## Error handling and edge cases

### No message processors

If no message processors are added to the Tracing feature, a warning will be logged:

```
Tracing Feature. No feature out stream providers are defined. Trace streaming has no target.
```

The feature will still intercept events, but they will not be processed or output anywhere.

### Resource management

Message processors may hold resources (like file handles) that need to be properly released. Use the `use` extension
function to ensure proper cleanup:

=== "Kotlin"

    
    
    ```kotlin
    val writer = TraceFeatureMessageFileWriter(
        outputPath,
        { path: Path -> SystemFileSystem.sink(path).buffered() }
    )

    // Creating an agent
    val agent = AIAgent(
        promptExecutor = simpleOllamaAIExecutor(),
        llmModel = OllamaModels.Meta.LLAMA_3_2,
    ) {
        install(Tracing) {
            addMessageProcessor(writer)
        }
    }

    // Run the agent
    agent.run(input)

    // Writer will be automatically closed when the block exits
    ```
    

### Tracing specific events to file

=== "Kotlin"

    
    
    ```kotlin
    val fileWriter = TraceFeatureMessageFileWriter(
        outputPath,
        { path: Path -> SystemFileSystem.sink(path).buffered() }
    )

    // Creating an agent
    val agent = AIAgent(
        promptExecutor = simpleOllamaAIExecutor(),
        llmModel = OllamaModels.Meta.LLAMA_3_2,
    ) {
        install(Tracing) {
            addMessageProcessor(fileWriter)

            // Only trace LLM calls
            fileWriter.setMessageFilter { message ->
                message is LLMCallStartingEvent || message is LLMCallCompletedEvent
            }
        }
    }
    ```
    

### Tracing specific events to remote endpoint

You use tracing to remote endpoints when you need to send event data via the network. Once initiated, tracing to a
remote endpoint launches a light server at the specified port number and sends events via Kotlin Server-Sent Events 
(SSE).

=== "Kotlin"

    
    
    ```kotlin
    val connectionConfig = DefaultServerConnectionConfig(host = host, port = port)
    val writer = TraceFeatureMessageRemoteWriter(connectionConfig)

    // Creating an agent
    val agent = AIAgent(
        promptExecutor = simpleOllamaAIExecutor(),
        llmModel = OllamaModels.Meta.LLAMA_3_2,
    ) {
        install(Tracing) {
            addMessageProcessor(writer)
        }
    }

    // Run the agent
    agent.run(input)

    // Writer will be automatically closed when the block exits
    ```
    

On the client side, you can use `FeatureMessageRemoteClient` to receive events and deserialize them.

=== "Kotlin"

    
    
    ```kotlin
    val clientConfig = DefaultClientConnectionConfig(host = host, port = port, protocol = URLProtocol.HTTP)
    val agentEvents = mutableListOf<DefinedFeatureEvent>()
    
    val clientJob = launch {
        FeatureMessageRemoteClient(connectionConfig = clientConfig, scope = this).use { client ->
            val collectEventsJob = launch {
                client.receivedMessages.consumeAsFlow().collect { event ->
                    // Collect events from server
                    agentEvents.add(event as DefinedFeatureEvent)
    
                    // Stop collecting events on agent finished
                    if (event is AgentCompletedEvent) {
                        cancel()
                    }
                }
            }
            client.connect()
            collectEventsJob.join()
            client.healthCheck()
        }
    }
    
    listOf(clientJob).joinAll()
    ```
    

## API documentation

The Tracing feature follows a modular architecture with these key components:

1. [Tracing](../../api/events-and-tracing.md#aikoogagentsfeaturestracingfeaturetracing): the main feature class that intercepts events in the agent pipeline.
2. [TraceFeatureConfig](../../api/events-and-tracing.md#aikoogagentsfeaturestracingfeaturetracefeatureconfig): configuration class for customizing feature behavior.
3. Message Processors: components that process and output trace events:
    - [TraceFeatureMessageLogWriter](../../api/events-and-tracing.md#aikoogagentsfeaturestracingwritertracefeaturemessagelogwriter): writes trace events to a logger.
    - [TraceFeatureMessageFileWriter](../../api/events-and-tracing.md#aikoogagentsfeaturestracingwritertracefeaturemessagefilewriter): writes trace events to a file.
    - [TraceFeatureMessageRemoteWriter](../../api/extended/agents--agents-features--agents-features-trace.md#aikoogagentsfeaturestracingwritertracefeaturemessageremotewriter): sends trace events to a remote server.

## Complete Kotlin examples

- [example-tracing-01.kt](../../kotlin-examples/example-tracing-01.kt)
- [example-tracing-02.kt](../../kotlin-examples/example-tracing-02.kt)
- [example-tracing-03.kt](../../kotlin-examples/example-tracing-03.kt)
- [example-tracing-04.kt](../../kotlin-examples/example-tracing-04.kt)
- [example-tracing-05.kt](../../kotlin-examples/example-tracing-05.kt)
- [example-tracing-06.kt](../../kotlin-examples/example-tracing-06.kt)
- [example-tracing-07.kt](../../kotlin-examples/example-tracing-07.kt)
