> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../../version-and-migration.md) before adapting snippets.

# Creating prompts

Koog provides a structured way to create prompts with control over message types, their order, and content:

* For **Kotlin** users, through a type-safe Kotlin DSL.

## Basic structure

of messages:

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("unique_prompt_id") {
        // List of messages
    }
    ```
    

## Message types

role in a conversation:

- **System message**: Provides the context, instructions, and constraints to the LLM, defining its behavior.
- **User message**: Represents the user input.
- **Assistant message**: Represents LLM responses that are used for few-shot learning or to continue the conversation.
- **Tool message**: Represents tool calls and their results.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("unique_prompt_id") {
        // Add a system message to set the context
        system("You are a helpful assistant with access to tools.")
        // Add a user message
        user("What is 5 + 3 ?")
        // Add an assistant message
        assistant("The result is 8.")
    }
    ```
    

### System message

A system message defines the LLM behavior and sets the context for the entire conversation.
It can specify the model's role, tone, provide guidelines and constraints on responses, and provide response examples.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("system_message") {
        system("You are a helpful assistant that explains technical concepts.")
    }
    ```
    

### User messages

A user message represents input from the user.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("user_message") {
        system("You are a helpful assistant.")
        user("What is Koog?")
    }
    ```
    

Most user messages contain plain text, but they can also include multimodal content, such as images, audio, video, and 
documents.
For details and examples, see [Multimodal content](multimodal-content.md).

### Assistant messages

An assistant message represents an LLM response, which can be used for few-shot learning in future similar interactions,
to continue a conversation, or to demonstrate the expected output structure.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("article_review") {
        system("Evaluate the article.")

        // Example 1
        user("The article is clear and easy to understand.")
        assistant("positive")

        // Example 2
        user("The article is hard to read but it's clear and useful.")
        assistant("neutral")

        // Example 3
        user("The article is confusing and misleading.")
        assistant("negative")

        // New input to classify
        user("The article is interesting and helpful.")
    }
    ```
    

### Tool messages

A tool message represents a tool call and its result, which can be used to pre-fill the history of tool calls.

!!! tip
    An LLM generates tool calls during execution.
    Pre-filling them is helpful for few-shot learning or demonstrating how the tools are expected to be used.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("calculator_example") {
        system("You are a helpful assistant with access to tools.")
        user("What is 5 + 3?")
        // Tool call
        toolCall(
            id = "calculator_tool_id",
            tool = "calculator",
            args = """{"operation": "add", "a": 5, "b": 3}"""
        )
        // Tool result
        toolResult(
            id = "calculator_tool_id",
            tool = "calculator",
            output = "8"
        )

        // LLM response based on tool result
        assistant("The result of 5 + 3 is 8.")
        user("What is 4 + 5?")
    }
    ```
    

## Text message builders

!!! warning
    Text message builders are available only in Kotlin.

When building a `system()`, `user()`, or `assistant()` message, you can use helper [text-building functions](../../../api/extended/prompt--prompt-model.md#aikoogprompttexttextcontentbuilder)
for rich text formatting.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("text_example") {
        user {
            +"Review the following code snippet:"
            +"fun greet(name: String) = println(\"Hello, \$name!\")"

            // Paragraph break
            br()
            text("Please include in your explanation:")

            // Indent content
            padding("  ") {
                +"1. What the function does."
                +"2. How string interpolation works."
            }
        }
    }
    ```
    

You can also use the [Markdown](../../../api/prompts-and-messages.md#aikoogpromptmarkdownmarkdown) and [XML](../../../api/prompts-and-messages.md#aikoogpromptxmlxml) builders to add the content in the corresponding format.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt("markdown_xml_example") {
        // A user message in Markdown format
        user {
            markdown {
                h2("Evaluate the article using the following criteria:")
                bulleted {
                    item { +"Clarity and readability" }
                    item { +"Accuracy of information" }
                    item { +"Usefulness to the reader" }
                }
            }
        }
        // An assistant message in XML format
        assistant {
            xml {
                xmlDeclaration()
                tag("review") {
                    tag("clarity") { text("positive") }
                    tag("accuracy") { text("neutral") }
                    tag("usefulness") { text("positive") }
                }
            }
        }
    }
    ```
    

!!! tip
    You can mix the text building functions with the XML and Markdown builders.

## Prompt parameters

Prompts can be customized by configuring parameters that control the LLM's behavior.

=== "Kotlin"

    

    ```kotlin
    val prompt = prompt(
        id = "custom_params",
        params = LLMParams(
            temperature = 0.7,
            numberOfChoices = 1,
            toolChoice = LLMParams.ToolChoice.Auto
        )
    ) {
        system("You are a creative writing assistant.")
        user("Write a song about winter.")
    }
    ```
    

The following parameters are supported:

- `temperature`: Controls randomness in the model's responses.
- `toolChoice`: Controls tool calling behavior of the model.
- `numberOfChoices`: Requests multiple alternative responses.
- `schema`: Defines the structure for the model's response format.
- `maxTokens`: Limits the number of tokens in the response.
- `speculation`: Provides a hint about the expected response format (only supported by specific models).

For more information, see [LLM parameters](../../llm-parameters.md).

## Extending existing prompts

the existing prompt as an argument:

=== "Kotlin"

    

    ```kotlin
    val basePrompt = prompt("base") {
        system("You are a helpful assistant.")
        user("Hello!")
        assistant("Hi! How can I help you?")
    }

    val extendedPrompt = prompt(basePrompt) {
        user("What's the weather like?")
    }
    ```
    

This creates a new prompt that includes all messages from `basePrompt` and the new user message.

## Next steps

- Learn how to work with [multimodal content](multimodal-content.md).
- Run prompts with [LLM clients](../llm-clients.md) if you work with a single LLM provider.
- Run prompts with [prompt executors](../prompt-executors.md) if you work with multiple LLM providers.
- Learn how to use llm cache with [cache control](cache-control.md).

## Complete Kotlin examples

- [example-creating-prompts-01.kt](../../../kotlin-examples/example-creating-prompts-01.kt)
- [example-creating-prompts-02.kt](../../../kotlin-examples/example-creating-prompts-02.kt)
- [example-creating-prompts-03.kt](../../../kotlin-examples/example-creating-prompts-03.kt)
- [example-creating-prompts-04.kt](../../../kotlin-examples/example-creating-prompts-04.kt)
- [example-creating-prompts-05.kt](../../../kotlin-examples/example-creating-prompts-05.kt)
- [example-creating-prompts-06.kt](../../../kotlin-examples/example-creating-prompts-06.kt)
- [example-creating-prompts-07.kt](../../../kotlin-examples/example-creating-prompts-07.kt)
- [example-creating-prompts-08.kt](../../../kotlin-examples/example-creating-prompts-08.kt)
- [example-creating-prompts-09.kt](../../../kotlin-examples/example-creating-prompts-09.kt)
- [example-creating-prompts-10.kt](../../../kotlin-examples/example-creating-prompts-10.kt)
