> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# LLM response caching

For repeated requests that you run with a prompt executor,
In Koog, caching is available for all prompt executors through `CachedPromptExecutor`, 
which is a wrapper around `PromptExecutor` that adds caching functionality.
It lets you store responses from previously executed prompts and retrieve them when the same prompts are run again.

1. Create a prompt executor for which you want to cache responses.
2. Create a `CachedPromptExecutor` instance by providing the desired cache and the prompt executor you created.
3. Run the created `CachedPromptExecutor` with the desired prompt and model.

Here is an example:

=== "Kotlin"

    
    
    ```kotlin
    // Create a prompt executor
    val client = OpenAILLMClient(System.getenv("OPENAI_API_KEY"))
    val promptExecutor = MultiLLMPromptExecutor(client)

    // Create a cached prompt executor
    val cachedExecutor = CachedPromptExecutor(
        cache = FilePromptCache(Path("path/to/your/cache/directory")),
        nested = promptExecutor
    )

    // Run cached prompt executor for the first time
    // This will perform an actual LLM request
    val firstTime = measureTimeMillis {
        val firstResponse = cachedExecutor.execute(prompt, OpenAIModels.Chat.GPT4o)
        val text = firstResponse.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
        println("First response: $text")
    }
    println("First execution took: ${firstTime}ms")

    // Run cached prompt executor for the second time
    // This will return the result immediately from the cache
    val secondTime = measureTimeMillis {
        val secondResponse = cachedExecutor.execute(prompt, OpenAIModels.Chat.GPT4o)
        val text = secondResponse.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }
        println("Second response: $text")
    }
    println("Second execution took: ${secondTime}ms")
    ```
    

The example produces the following output:

```
First response: Hello! It seems like we're starting a new conversation. What can I help you with today?
First execution took: 48ms
Second response: Hello! It seems like we're starting a new conversation. What can I help you with today?
Second execution took: 1ms
```
The second response is retrieved from the cache, which took only 1ms.

!!!note

## Complete Kotlin examples

- [example-llm-response-caching-01.kt](../../kotlin-examples/example-llm-response-caching-01.kt)
