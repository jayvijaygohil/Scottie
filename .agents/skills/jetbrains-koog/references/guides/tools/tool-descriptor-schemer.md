> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../version-and-migration.md) before adapting snippets.

# ToolDescriptorSchemer

Key points:

- Location: `ai.koog.agents.core.tools.serialization.ToolDescriptorSchemer`
- Implementations provided:
  - `OpenAICompatibleToolDescriptorSchemer` — generates schemas compatible with OpenAI‑style function/tool definitions.
  - `OllamaToolDescriptorSchemer` — generates schemas compatible with Ollama tool JSON.

```kotlin
// Interface
interface ToolDescriptorSchemaGenerator {
fun generate(toolDescriptor: ToolDescriptor): JsonObject
}
```

## Why use it

## Implementation example

=== "Kotlin"

    
    ```kotlin
    
    class MinimalSchemer : ToolDescriptorSchemaGenerator {
        override fun generate(toolDescriptor: ToolDescriptor): JsonObject = buildJsonObject {
            put("type", "object")
            putJsonObject("properties") {
                (toolDescriptor.requiredParameters + toolDescriptor.optionalParameters).forEach { p ->
                    put(p.name, buildJsonObject {
                        put("description", p.description)
                        when (val t = p.type) {
                            ToolParameterType.String -> put("type", "string")
                            ToolParameterType.Integer -> put("type", "integer")
                            is ToolParameterType.Enum -> {
                                put("type", "string")
                                putJsonArray("enum") { t.entries.forEach { add(JsonPrimitive(it)) } }
                            }
                            else -> put("type", "string") // fallback for brevity
                        }
                    })
                }
            }
            putJsonArray("required") { toolDescriptor.requiredParameters.forEach { add(JsonPrimitive(it.name)) } }
        }
    }
    ```
    

## Using with a client

Typically, you do not need to call a schemer directly. Koog clients accept a list of `ToolDescriptor` objects and apply the correct schemer internally when serializing requests for the provider.

The example below defines a simple tool and passes it to the OpenAI client. The client will use `OpenAICompatibleToolDescriptorSchemer` under the hood to build the JSON schema.

=== "Kotlin"

    
    ```kotlin
    val client = OpenAILLMClient(apiKey = System.getenv("OPENAI_API_KEY"), toolsConverter = MinimalSchemer())
    
    val getUserTool = ToolDescriptor(
        name = "get_user",
        description = "Returns user profile by id",
        requiredParameters = listOf(
            ToolParameterDescriptor(
                name = "id",
                description = "User id",
                type = ToolParameterType.String
            )
        )
    )
    
    val prompt = Prompt.build(id = "p1") { user("Hello") }
    val responses = runBlocking {
        client.execute(
            prompt = prompt,
            model = OpenAIModels.Chat.GPT4o,
            tools = listOf(getUserTool)
        )
    }
    ```
    

If you need direct access to the produced schema (for debugging or for a custom transport), you can instantiate the provider‑specific schemer and serialize the JSON yourself:

=== "Kotlin"

    
    
    ```kotlin
    val json = Json { prettyPrint = true }
    val schema = OpenAICompatibleToolDescriptorSchemaGenerator().generate(getUserTool())
    ```
    

## Complete Kotlin examples

- [example-tool-descriptor-schemer-01.kt](../../kotlin-examples/example-tool-descriptor-schemer-01.kt)
- [example-tool-descriptor-schemer-02.kt](../../kotlin-examples/example-tool-descriptor-schemer-02.kt)
- [example-tool-descriptor-schemer-03.kt](../../kotlin-examples/example-tool-descriptor-schemer-03.kt)
- [example-tool-descriptor-schemer-04.kt](../../kotlin-examples/example-tool-descriptor-schemer-04.kt)
