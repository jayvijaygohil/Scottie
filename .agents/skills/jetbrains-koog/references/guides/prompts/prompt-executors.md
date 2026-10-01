> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# Prompt executors

Prompt executors provide a higher-level abstraction that lets you manage the lifecycle of one or multiple LLM clients.
You can work with multiple LLM providers through a unified interface, abstracting from provider-specific details,
with dynamic switching between them and fallbacks.

## Executor types

Koog provides three main types of prompt executors that implement the [`PromptExecutor`](../../api/executors-and-clients.md#aikoogpromptexecutormodelpromptexecutor) interface:

| Type            | <div style="width:175px">Class</div>                                                                                                                               | Description                                                                                                                                                                                                                                                          |
|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Single-provider | `SingleLLMPromptExecutor` | Wraps a single LLM client for one provider. Use this executor if your agent only requires switching between models within a single LLM provider.                                                                                                                     |
| Multi-provider  | [`MultiLLMPromptExecutor`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsmultillmpromptexecutor)   | Wraps multiple LLM clients and routes calls based on the LLM provider. It can optionally use a configured fallback provider and LLM when the requested client is unavailable. Use this executor if your agent needs to switch between LLMs from different providers. |
| Routing         | [`RoutingLLMPromptExecutor`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsroutingllmpromptexecutor) | Distributes requests to a given LLM model across multiple client instances using routing strategies. Use this executor to avoid rate limits, improve throughput, and implement failover strategies with load balancing.                                               |

## Creating a single-provider executor

To create a prompt executor for a specific LLM provider, perform the following:

1. Configure an LLM client for a specific provider with the corresponding API key.
2. Create a prompt executor using [`MultiLLMPromptExecutor`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsmultillmpromptexecutor).

Here is an example:

=== "Kotlin"

    

    ```kotlin
    val openAIClient = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
    val promptExecutor = MultiLLMPromptExecutor(openAIClient)
    ```
    

## Creating a multi-provider executor

To create a prompt executor that works with multiple LLM providers, do the following:

1. Configure clients for the required LLM providers with the corresponding API keys.
2. Pass the configured clients to the [`MultiLLMPromptExecutor`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsmultillmpromptexecutor) class constructor to create a prompt executor
   with multiple LLM providers.

=== "Kotlin"

    

    ```kotlin
    val openAIClient = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
    val ollamaClient = OllamaClient()

    val multiExecutor = MultiLLMPromptExecutor(
        LLMProvider.OpenAI to openAIClient,
        LLMProvider.Ollama to ollamaClient
    )
    ```
    

## Creating a routing executor

!!! warning "Experimental API"
    Routing capabilities are experimental and may change in future releases.
    To use them, opt in with `@OptIn(ExperimentalRoutingApi::class)`.

To create a prompt executor that distributes requests across multiple LLM client instances using routing strategies, do the following:

1. Configure multiple client instances (they can be for the same or different LLM providers) with the corresponding API keys.
2. Create a router using a routing strategy, such as [`RoundRobinRouter`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsroundrobinrouter).
3. Pass the router to the [`RoutingLLMPromptExecutor`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsroutingllmpromptexecutor) class constructor.

This is useful for avoiding rate limits, improving throughput, and implementing failover strategies.

=== "Kotlin"

    
    ```kotlin
    // Create multiple client instances
    val openAI1 = OpenAILLMClient(apiKey = "openai-key-1")
    val openAI2 = OpenAILLMClient(apiKey = "openai-key-2")
    val anthropic = AnthropicLLMClient(apiKey = "anthropic-key")

    // Create router with round-robin strategy
    val router = RoundRobinRouter(openAI1, openAI2, anthropic)

    // Create routing executor
    val routingExecutor = RoutingLLMPromptExecutor(router)
    ```
    

When you execute prompts with this executor, requests to OpenAI models will alternate between `openAI1` and `openAI2` using the round-robin strategy.
Requests to Anthropic models always go to the single `anthropic` client, as round-robin maintains an independent counter per provider.

You can also implement custom routing strategies by creating a class that implements the [`LLMClientRouter`](../../api/executors-and-clients.md#aikoogpromptexecutorllmsllmclientrouter) interface.

## Pre-defined prompt executors

The following table includes the **pre-defined single-provider executors**
that return `SingleLLMPromptExecutor` configured with a specific LLM client.

| LLM provider   | Prompt executor                                                                                                                                                                             | Description                                                                      |
|----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| OpenAI         | [simpleOpenAIExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimpleopenaiexecutor)                                  | Wraps `OpenAILLMClient` that runs prompts with OpenAI models.                    |
| OpenAI         | [simpleAzureOpenAIExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimpleazureopenaiexecutor)                       | Wraps `OpenAILLMClient` configured for using Azure OpenAI Service.               |
| Anthropic      | [simpleAnthropicExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimpleanthropicexecutor)                              | Wraps `AnthropicLLMClient` that runs prompts with Anthropic models.              |
| Google         | [simpleGoogleAIExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimplegoogleaiexecutor)                              | Wraps `GoogleLLMClient` that runs prompts with Google models.                    |
| OpenRouter     | [simpleOpenRouterExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimpleopenrouterexecutor)                           | Wraps `OpenRouterLLMClient` that runs prompts with OpenRouter.                   |
| Amazon Bedrock | [simpleBedrockExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimplebedrockexecutor)                                  | Wraps `BedrockLLMClient` that runs prompts with AWS Bedrock.                     |
| Amazon Bedrock | [simpleBedrockExecutorWithBearerToken](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimplebedrockexecutorwithbearertoken) | Wraps `BedrockLLMClient` and uses the provided Bedrock API key to send requests. |
| Mistral        | [simpleMistralAIExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimplemistralaiexecutor)                            | Wraps `MistralAILLMClient` that runs prompts with Mistral models.                |
| Ollama         | [simpleOllamaAIExecutor](../../api/executors-and-clients.md#aikoogpromptexecutorllmsallsimpleollamaaiexecutor)                              | Wraps `OllamaClient` that runs prompts with Ollama.                              |

Here is an example of creating a pre-defined executor:

=== "Kotlin"

    

    ```kotlin
    // Create an OpenAI executor
    val promptExecutor = simpleOpenAIExecutor("OPENAI_API_KEY")
    ```
    

## Running a prompt

To run a prompt using a prompt executor, do the following:

1. Create a prompt executor.
2. Run the prompt with the specific LLM using the `execute()` method.

Here is an example:

=== "Kotlin"

    
    

    ```kotlin
    // Create an OpenAI executor
    val promptExecutor = simpleOpenAIExecutor("OPENAI_API_KEY")

    // Execute a prompt
    val response = promptExecutor.execute(
        prompt = prompt("demo") { user("Summarize this.") },
        model = OpenAIModels.Chat.GPT4o
    )
    ```
    

This will run the prompt with the `GPT4o` model and return the response.

!!! note
    The prompt executors provide methods to run prompts using various capabilities, 
    such as streaming, multiple choice generation, and content moderation.
    Since prompt executors wrap LLM clients, each executor supports the capabilities of the corresponding client.
    For details, refer to [LLM clients](llm-clients.md).

## Switching between providers

When you work with multiple LLM providers using `MultiLLMPromptExecutor`, you can switch between them.
The process is as follows:

1. Create an LLM client instance for each provider you want to use.
2. Create a `MultiLLMPromptExecutor` that maps LLM providers to LLM clients.
3. Run a prompt with a model from the corresponding client passed as an argument to the `execute()` method.
   The prompt executor will use the corresponding client based on the model provider to run the prompt.

Here is an example of switching between providers:

=== "Kotlin"

    
    

    ```kotlin
    // Create LLM clients for OpenAI, Anthropic, and Google providers
    val openAIClient = OpenAILLMClient("OPENAI_API_KEY")
    val anthropicClient = AnthropicLLMClient("ANTHROPIC_API_KEY")
    val googleClient = GoogleLLMClient("GOOGLE_API_KEY")

    // Create a MultiLLMPromptExecutor that maps LLM providers to LLM clients
    val executor = MultiLLMPromptExecutor(
        LLMProvider.OpenAI to openAIClient,
        LLMProvider.Anthropic to anthropicClient,
        LLMProvider.Google to googleClient
    )

    // Create a prompt
    val p = prompt("demo") { user("Summarize this.") }

    // Run the prompt with an OpenAI model; the prompt executor automatically switches to the OpenAI client
    val openAIResult = executor.execute(p, OpenAIModels.Chat.GPT4o)

    // Run the prompt with an Anthropic model; the prompt executor automatically switches to the Anthropic client
    val anthropicResult = executor.execute(p, AnthropicModels.Sonnet_4_5)
    ```
    

You can optionally configure a fallback LLM provider and model to use when the requested client is unavailable.
For details, refer to [Configuring fallbacks](#configuring-fallbacks).

## Configuring fallbacks

Multi-provider and routing prompt executors can be configured to use a fallback LLM provider and model when the requested LLM client is unavailable.

To configure the fallback mechanism, pass fallback settings when creating a `MultiLLMPromptExecutor` or `RoutingLLMPromptExecutor`:

=== "Kotlin"

    

    ```kotlin
    val openAIClient = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
    val ollamaClient = OllamaClient()

    val multiExecutor = MultiLLMPromptExecutor(
        LLMProvider.OpenAI to openAIClient,
        LLMProvider.Ollama to ollamaClient,
        fallback = MultiLLMPromptExecutor.FallbackPromptExecutorSettings(
            fallbackProvider = LLMProvider.Ollama,
            fallbackModel = OllamaModels.Meta.LLAMA_3_2
        )
    )
    ```
    

If you pass a model from an LLM provider that is not included in the `MultiLLMPromptExecutor`,
the prompt executor will use the fallback model:

=== "Kotlin"

    
    

    ```kotlin
    // Create a prompt
    val p = prompt("demo") { user("Summarize this") }
    // If you pass a Google model, the prompt executor will use the fallback model, as the Google client is not included
    val response = multiExecutor.execute(p, GoogleModels.Gemini2_5Pro)
    ```
    

!!! note
    Fallbacks are available for the `execute()` and `executeMultipleChoices()` methods only.

## Complete Kotlin examples

- [example-prompt-executors-01.kt](../../kotlin-examples/example-prompt-executors-01.kt)
- [example-prompt-executors-02.kt](../../kotlin-examples/example-prompt-executors-02.kt)
- [example-prompt-executors-03.kt](../../kotlin-examples/example-prompt-executors-03.kt)
- [example-prompt-executors-04.kt](../../kotlin-examples/example-prompt-executors-04.kt)
- [example-prompt-executors-05.kt](../../kotlin-examples/example-prompt-executors-05.kt)
- [example-prompt-executors-06.kt](../../kotlin-examples/example-prompt-executors-06.kt)
- [example-prompt-executors-07.kt](../../kotlin-examples/example-prompt-executors-07.kt)
- [example-prompt-executors-08.kt](../../kotlin-examples/example-prompt-executors-08.kt)
