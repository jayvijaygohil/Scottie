> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# LLM clients

LLM clients are designed for direct interaction with LLM providers.
Each client implements the [`LLMClient`](../../api/executors-and-clients.md#aikoogpromptexecutorclientsllmclient) interface, which provides methods for executing prompts and streaming responses.

You can use an LLM client when you work with a single LLM provider and don't need advanced lifecycle management.
If you need to manage multiple LLM providers, use a [prompt executor](prompt-executors.md).

The table below shows the available LLM clients and their capabilities.

| LLM provider                                        | LLMClient                                                                                                                                                                                                   | Tool<br/>calling | Streaming | Multiple<br/>choices | Embeddings | Moderation | <div style="width:50px">Model<br/>listing</div> | <div style="width:200px">Notes</div>                                                                                        |
|-----------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------|-----------|----------------------|------------|------------|-------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| [OpenAI](https://platform.openai.com/docs/overview) | [OpenAILLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsopenaiopenaillmclient)                | ✓                | ✓         | ✓                    | ✓          | ✓[^1]      | ✓                                               |                                                                                                                             |
| [Anthropic](https://www.anthropic.com/)             | [AnthropicLLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsanthropicanthropicllmclient)      | ✓                | ✓         | -                    | -          | -          | -                                               | -                                                                                                                           |
| [Google](https://ai.google.dev/) β                  | [GoogleLLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsgooglegooglellmclient)                  | ✓                | ✓         | ✓                    | ✓          | -          | ✓                                               | -                                                                                                                           |
| [DeepSeek](https://www.deepseek.com/) β             | [DeepSeekLLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsdeepseekdeepseekllmclient)         | ✓                | ✓         | ✓                    | -          | -          | ✓                                               | OpenAI-compatible chat client.                                                                                              |
| [OpenRouter](https://openrouter.ai/)                | [OpenRouterLLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsopenrouteropenrouterllmclient) | ✓                | ✓         | ✓                    | -          | -          | ✓                                               | OpenAI-compatible router client.                                                                                            |
| [Amazon Bedrock](https://aws.amazon.com/bedrock/)   | [BedrockLLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsbedrockbedrockllmclient)              | ✓                | ✓         | -                    | ✓          | ✓[^2]      | -                                               | JVM-only AWS SDK client that supports multiple model families.                                                              |
| [Mistral](https://mistral.ai/) β                    | [MistralAILLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsmistralaimistralaillmclient)    | ✓                | ✓         | ✓                    | ✓          | ✓[^3]      | ✓                                               | OpenAI-compatible client.                                                                                                   |
| [Alibaba](https://www.alibabacloud.com/en?_p_lc=1) β | [DashScopeLLMClient](../../api/executors-and-clients.md#aikoogpromptexecutorclientsdashscopedashscopellmclient)    | ✓                | ✓         | ✓                    | -          | -          | ✓                                               | OpenAI-compatible client that exposes provider-specific parameters (`enableSearch`, `parallelToolCalls`, `enableThinking`). |
| [Ollama](https://ollama.com/)                       | [OllamaClient](../../api/executors-and-clients.md#aikoogpromptexecutorollamaclientollamaclient)                            | ✓                | ✓         | -                    | ✓          | ✓          | -                                               | Local server client with model management APIs.                                                                             |

## Running a prompt

To run a prompt using an LLM client, perform the following:

1. Create an LLM client that handles the connection between your application and LLM providers.
2. Call the `execute()` method with the prompt and LLM as arguments.

Here is an example that uses `OpenAILLMClient` to run prompts:

=== "Kotlin"

    

    ```kotlin
    fun main() = runBlocking {
        // Create an OpenAI client
        val apiKey = System.getenv("OPENAI_API_KEY")
        val client = OpenAILLMClient(apiKey)

        // Create a prompt
        val prompt = prompt("prompt_name", LLMParams()) {
            // Add a system message to set the context
            system("You are a helpful assistant.")

            // Add a user message
            user("Tell me about Kotlin")

            // You can also add assistant messages for few-shot examples
            assistant("Kotlin is a modern programming language...")

            // Add another user message
            user("What are its key features?")
        }

        // Run the prompt
        val response = client.execute(prompt, OpenAIModels.Chat.GPT4o)
        // Print the response
        println(response)
    }
    ```
    

## Streaming responses

!!! note
    Available for all LLM clients.

When you need to process responses as they are generated, you can use the `executeStreaming()` method in Kotlin or 

The streaming API provides different frame types:

- **Delta frames** (`TextDelta`, `ReasoningDelta`, `ToolCallDelta`) — incremental content that arrives in chunks
- **Complete frames** (`TextComplete`, `ReasoningComplete`, `ToolCallComplete`) — full content after all deltas are received
- **End frame** (`End`) — signals stream completion with finish reason

For models that support reasoning (such as Claude Sonnet 4.5 or GPT-o1), reasoning frames will be emitted during 
streaming.
See the [Streaming API documentation](../streaming-api.md) for more details on working with frames.

=== "Kotlin"

    
    
    ```kotlin
    // Set up the OpenAI client with your API key
    val token = System.getenv("OPENAI_API_KEY")
    val client = OpenAILLMClient(token)

    val response = client.executeStreaming(
        prompt = prompt("stream_demo") { user("Stream this response in short chunks.") },
        model = OpenAIModels.Chat.GPT4_1
    )

    response.collect { frame ->
        when (frame) {
            is StreamFrame.TextDelta -> print(frame.text)
            is StreamFrame.ReasoningDelta -> print("[Reasoning] ${frame.text}")
            is StreamFrame.ToolCallComplete -> println("\nTool call: ${frame.name}")
            is StreamFrame.End -> println("\n[done] Reason: ${frame.finishReason}")
            else -> {} // Handle other frame types if needed
        }
    }
    ```
    

## Multiple choices

!!! note
    Available for all LLM clients except `GoogleLLMClient`, `BedrockLLMClient`, and `OllamaClient`

You can request multiple alternative responses from the model in a single call by using the `executeMultipleChoices()` method.
It requires additionally specifying the [`numberOfChoices`](prompt-creation/index.md#prompt-parameters) LLM parameter in the prompt
being executed.

=== "Kotlin"

    
    ```kotlin
    fun main() = runBlocking {
        val apiKey = System.getenv("OPENAI_API_KEY")
        val client = OpenAILLMClient(apiKey)

        val choices = client.executeMultipleChoices(
            prompt = prompt("n_best", params = LLMParams(numberOfChoices = 3)) {
                system("You are a creative assistant.")
                user("Give me three different opening lines for a story.")
            },
            model = OpenAIModels.Chat.GPT4o
        )

        choices.forEachIndexed { i, choice ->
            val text = choice.parts.filterIsInstance<MessagePart.Text>().joinToString(" ") { it.text }
            println("Line #${i + 1}: $text")
        }
    }
    ```
    

## Listing available models

!!! note
    Available for all LLM clients except `AnthropicLLMClient`, `BedrockLLMClient`, and `OllamaClient`.

To get a list of available model IDs supported by the LLM client, use the `models()` method:    

=== "Kotlin"

    
    ```kotlin
    fun main() = runBlocking {
        val apiKey = System.getenv("OPENAI_API_KEY")
        val client = OpenAILLMClient(apiKey)

        val models: List<LLModel> = client.models()
        models.forEach { println(it.id) }
    }
    ```
    

## Embeddings

!!! note
    Available for `OpenAILLMClient`, `GoogleLLMClient`, `BedrockLLMClient`, `MistralAILLMClient`, and `OllamaClient`.

You convert text into embedding vectors using the `embed()` method.
Choose an embedding model and pass your text to this method:

```kotlin
fun main() = runBlocking {
    val apiKey = System.getenv("OPENAI_API_KEY")
    val client = OpenAILLMClient(apiKey)

    val embedding = client.embed(
        text = "This is a sample text for embedding",
        model = OpenAIModels.Embeddings.TextEmbedding3Large
    )

    println("Embedding size: ${embedding.size}")
}
```

## Moderation

!!! note
    Available for the following LLM clients: `OpenAILLMClient`, `BedrockLLMClient`, `MistralAILLMClient`, `OllamaClient`.

You can use the `moderate()` method with a moderation model to check whether a prompt contains inappropriate content:

=== "Kotlin"

    
    ```kotlin
    fun main() = runBlocking {
        val apiKey = System.getenv("OPENAI_API_KEY")
        val client = OpenAILLMClient(apiKey)

        val result = client.moderate(
            prompt = prompt("moderation") {
                user("This is a test message that may contain offensive content.")
            },
            model = OpenAIModels.Moderation.Omni
        )

        println(result)
    }
    ```
    

## Integration with prompt executors

[Prompt executors](prompt-executors.md) wrap LLM clients and provide additional functionality, such as routing, fallbacks, and unified usage across providers.
They are recommended for production use, as they offer flexibility when working with multiple providers.

[^1]: Supports moderation via the OpenAI Moderation API.
[^2]: Moderation requires Guardrails configuration.
[^3]: Supports moderation via the Mistral `v1/moderations` endpoint.

## Complete Kotlin examples

- [example-llm-clients-01.kt](../../kotlin-examples/example-llm-clients-01.kt)
- [example-llm-clients-02.kt](../../kotlin-examples/example-llm-clients-02.kt)
- [example-llm-clients-03.kt](../../kotlin-examples/example-llm-clients-03.kt)
- [example-llm-clients-04.kt](../../kotlin-examples/example-llm-clients-04.kt)
- [example-llm-clients-05.kt](../../kotlin-examples/example-llm-clients-05.kt)
- [example-llm-clients-06.kt](../../kotlin-examples/example-llm-clients-06.kt)
