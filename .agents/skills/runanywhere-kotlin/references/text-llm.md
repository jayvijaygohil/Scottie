Contents (search for the `# ` heading): Chat, generate(), generateStream(), System Prompts,
Structured Output, Tool Calling

# Chat

> Multi-turn conversations with message history

Pass a `List<ChatMessage>` instead of a prompt.

```kotlin theme={null}
val messages = listOf(
    ChatMessage(ChatRole.System, "You are a concise assistant."),
    ChatMessage(ChatRole.User, "What is on-device inference?"),
    ChatMessage(ChatRole.Assistant, "Running the model on your own hardware."),
    ChatMessage(ChatRole.User, "Why does that matter?"),
)

val reply = RunAnywhere.llm.generate(messages)
println(reply.text)
```

## How messages are split

The list is not sent verbatim:

* System turns become `options.systemPrompt`.
* The **trailing user turn** becomes the prompt.
* Everything between travels as history.

A conversation with no user turn throws `SDKException`.

## Streaming a conversation

```kotlin theme={null}
RunAnywhere.llm.generateStream(messages).collect { event ->
    if (event is GenerationEvent.Token) print(event.text)
}
```

## Keeping a transcript

```kotlin theme={null}
class Conversation : ViewModel() {
    private val messages = mutableListOf(
        ChatMessage(ChatRole.System, "You are a helpful assistant.")
    )

    private val _transcript = MutableStateFlow<List<ChatMessage>>(emptyList())
    val transcript = _transcript.asStateFlow()

    fun send(text: String) {
        viewModelScope.launch {
            messages += ChatMessage(ChatRole.User, text)
            _transcript.value = messages.toList()

            val reply = StringBuilder()
            RunAnywhere.llm.generateStream(messages).collect { event ->
                if (event is GenerationEvent.Token) reply.append(event.text)
            }

            messages += ChatMessage(ChatRole.Assistant, reply.toString())
            _transcript.value = messages.toList()
        }
    }
}
```

## ChatMessage

| Field        | Type                                           |
|--------------|------------------------------------------------|
| `role`       | `ChatRole.System`, `User`, `Assistant`, `Tool` |
| `content`    | `String`                                       |
| `toolCallId` | `String?`                                      |

## Context length

Trim old turns before the conversation outgrows the model's context window, keeping the
system message:

```kotlin theme={null}
if (messages.size > 21) {
    val system = messages.first()
    val recent = messages.takeLast(20)
    messages.clear()
    messages += system
    messages += recent
}
```

# generate()

> One-shot text generation with metrics and options

`RunAnywhere.llm.generate` is a suspending function that runs a single completion.

```kotlin theme={null}
import com.runanywhere.sdk.public.RunAnywhere
import com.runanywhere.sdk.public.api.*

val result = RunAnywhere.llm.generate("Name three colours")
println(result.text)
```

With options:

```kotlin theme={null}
val result = RunAnywhere.llm.generate(
    "Explain quantum computing in simple terms",
    LlmOptions(
        model = "qwen3-0.6b",
        maxOutputTokens = 200,
        temperature = 0.7f
    )
)

println(result.text)
println("${result.tokensPerSecond} tok/s")
```

## Signatures

```kotlin theme={null}
suspend fun generate(prompt: String, options: LlmOptions? = null): GenerationResult
suspend fun generate(messages: List<ChatMessage>, options: LlmOptions? = null): GenerationResult
```

The `messages` form is covered in [Chat](/kotlin/llm/chat).

## LlmOptions

| Field             | Type                   | Default                      |
|-------------------|------------------------|------------------------------|
| `model`           | `String?`              | none; uses the loaded model  |
| `maxOutputTokens` | `Int`                  | `DEFAULT_MAX_OUTPUT_TOKENS`  |
| `temperature`     | `Float`                | `DEFAULT_TEMPERATURE`        |
| `topP`            | `Float`                | `DEFAULT_TOP_P`              |
| `systemPrompt`    | `String?`              | none                         |
| `stopSequences`   | `List<String>`         | empty                        |
| `reasoning`       | `ReasoningOptions?`    | none                         |
| `tools`           | `List<ToolDefinition>` | empty                        |
| `toolChoice`      | `ToolChoice`           | `Auto`                       |
| `maxToolCalls`    | `Int`                  | `DEFAULT_MAX_TOOL_CALLS` (5) |

The defaults are public constants read from the proto defaults at class-init, so quote the
constant rather than a literal:

```kotlin theme={null}
LlmOptions.DEFAULT_MAX_OUTPUT_TOKENS
LlmOptions.DEFAULT_TEMPERATURE
LlmOptions.DEFAULT_TOP_P
LlmOptions.DEFAULT_MAX_TOOL_CALLS
```

## Structured output

```kotlin theme={null}
val result = RunAnywhere.llm.generateStructured(
    prompt = "Extract the name and age: Dana is 34.",
    schema = schema,
    mode = StructuredOutputMode.VALIDATION_ONLY
)
```

| Mode              | Behaviour                                                       |
|-------------------|-----------------------------------------------------------------|
| `VALIDATION_ONLY` | Generate freely, then validate. The default.                    |
| `REPAIR`          | Validate, then retry once with a repair instruction if invalid. |
| `CONSTRAINED`     | **Throws today.**                                               |

## Reasoning

```kotlin theme={null}
val result = RunAnywhere.llm.generate(
    prompt,
    LlmOptions(reasoning = ReasoningOptions(includeInOutput = true))
)
```

The C++ core owns tag parsing and `/no_think` directives. You toggle the mode and render what
comes back.

## Errors

Throws `SDKException` when no model can be loaded or generation fails. See
[Error handling](/kotlin/error-handling).

# generateStream()

> Stream tokens as they are produced

`generateStream` returns a `Flow<GenerationEvent>`. It is **not** suspending: you get the flow
back immediately and collect it.

```kotlin theme={null}
RunAnywhere.llm.generateStream("Write a haiku about Kotlin").collect { event ->
    if (event is GenerationEvent.Token) print(event.text)
}
```

## Signatures

```kotlin theme={null}
fun generateStream(prompt: String, options: LlmOptions? = null): Flow<GenerationEvent>
fun generateStream(messages: List<ChatMessage>, options: LlmOptions? = null): Flow<GenerationEvent>
```

## Handling every event

```kotlin theme={null}
RunAnywhere.llm.generateStream(prompt).collect { event ->
    when (event) {
        is GenerationEvent.Token -> text += event.text
        is GenerationEvent.Completed -> tokensPerSecond = event.result.tokensPerSecond
        else -> {}
    }
}
```

## In a ViewModel

```kotlin theme={null}
class ChatViewModel : ViewModel() {
    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    fun send(prompt: String) {
        viewModelScope.launch {
            _text.value = ""
            RunAnywhere.llm.generateStream(prompt).collect { event ->
                if (event is GenerationEvent.Token) _text.value += event.text
            }
        }
    }
}
```

Collecting in `viewModelScope` means the flow is cancelled when the ViewModel clears, so a
generation does not outlive the screen.

## Errors

Failures are thrown from the collector, so wrap the collection:

```kotlin theme={null}
try {
    RunAnywhere.llm.generateStream(prompt).collect { event ->
        if (event is GenerationEvent.Token) text += event.text
    }
} catch (e: SDKException) {
    show(e)
}
```

## Cancelling

Cancel the coroutine:

```kotlin theme={null}
val job = viewModelScope.launch {
    RunAnywhere.llm.generateStream(prompt).collect { /* … */ }
}

job.cancel()
```

## Flow operators work normally

```kotlin theme={null}
RunAnywhere.llm.generateStream(prompt)
    .filterIsInstance<GenerationEvent.Token>()
    .map { it.text }
    .collect { text += it }
```

# System Prompts

> Control model behaviour with a system prompt

## Through options

```kotlin theme={null}
val result = RunAnywhere.llm.generate(
    "How do I reverse a string?",
    LlmOptions(systemPrompt = "You are a Kotlin expert. Answer with code, then one sentence.")
)
```

## Through a message

A `ChatRole.System` message becomes `options.systemPrompt` automatically:

```kotlin theme={null}
val messages = listOf(
    ChatMessage(ChatRole.System, "You are a Kotlin expert."),
    ChatMessage(ChatRole.User, "How do I reverse a string?"),
)

val result = RunAnywhere.llm.generate(messages)
```

The two are equivalent. When both are present, the explicit `options.systemPrompt` wins.

## Writing one that works

Small on-device models follow short, concrete instructions far better than long ones.

```kotlin theme={null}
// Works
"You are a terse assistant. Answer in one sentence. No preamble."

// Works less well on a 0.6B model
"You are an extremely helpful, knowledgeable, and friendly AI assistant who always strives
to provide the most comprehensive and detailed responses possible…"
```

Naming the exact output shape usually holds:

```kotlin theme={null}
LlmOptions(
    systemPrompt = "You are a classifier. Reply with exactly one word: positive, negative, or neutral.",
    temperature = 0.1f
)
```

For a guaranteed shape rather than a requested one, use
[structured output](/kotlin/llm/generate#structured-output).

## Reuse

```kotlin theme={null}
object Prompts {
    val summarizer = LlmOptions(
        systemPrompt = "Summarize in three bullet points. No introduction.",
        maxOutputTokens = 150,
        temperature = 0.3f
    )

    val coder = LlmOptions(
        systemPrompt = "You are a Kotlin expert. Answer with code first.",
        temperature = 0.2f
    )
}

val summary = RunAnywhere.llm.generate(article, Prompts.summarizer)
```

# Structured Output

> Get JSON back instead of prose

Asking a model for JSON in a system prompt works most of the time, which is the problem.
`generateStructured` validates the result against a schema and can repair it.

```kotlin theme={null}
val result = RunAnywhere.llm.generateStructured(
    prompt = "Extract the name and age: Dana is 34.",
    schema = schema,
    mode = StructuredOutputMode.VALIDATION_ONLY,
    options = LlmOptions(temperature = 0.1f)
)
```

## Enforcement modes

| Mode              | Behaviour                                            |
|-------------------|------------------------------------------------------|
| `VALIDATION_ONLY` | Generate freely, then validate. The default.         |
| `REPAIR`          | Validate, then retry once with a repair instruction. |
| `CONSTRAINED`     | **Throws `unsupportedCapability` today.**            |

Validation-only is the default and is right when a retry is cheap. Repair costs a second
generation when the first is invalid, which is worth it when the call is user-facing and a
failure means showing an error.

## The schema

```kotlin theme={null}
val schema = JsonSchema(/* your JSON schema */)
```

Keep schemas small. A small model handles four flat fields reliably and a deeply nested
structure badly. When you need something complex, ask for the pieces separately rather than
one large object.

Naming fields the way a person would helps: `totalPrice` gets better results than `tp`.

## Reading the result

```kotlin theme={null}
// result carries the parsed value and the raw text
```

## When to reach for this

| Task                           | Approach                                |
|--------------------------------|-----------------------------------------|
| Extracting fields from text    | Structured output                       |
| Classifying into fixed labels  | Structured output, or a one-word prompt |
| Anything you will `JSON.parse` | Structured output                       |
| Prose for a human to read      | Plain generation                        |

If you are about to write a regex over a model's reply, you want this instead.

## Temperature

Lower it. Structured extraction is not a creative task, and `0.1` to `0.3` produces far more
consistent field values than the default.

# Tool Calling

> Let the model call your functions

Register a tool and the function that runs it. The SDK owns the call-and-execute loop.

```kotlin theme={null}
RunAnywhere.llm.tools.register(weatherTool) { args ->
    val city = args["city"]?.stringValue ?: ""
    mapOf("tempC" to ToolValue.of(fetchTemp(city)))
}

val result = RunAnywhere.llm.generate("What is the weather in Lisbon?")
```

## The tools namespace

```kotlin theme={null}
suspend fun register(
    tool: ToolDefinition,
    executor: suspend (Map<String, ToolValue>) -> Map<String, ToolValue>
)
suspend fun unregister(name: String)
suspend fun list(): List<ToolDefinition>
```

The executor is a suspending function, so it can do IO without blocking.

## Defining a tool

```kotlin theme={null}
val weatherTool = ToolDefinition(
    name = "get_weather",
    description = "Get the current temperature for a city",
    parameters = listOf(
        ToolParameter(
            name = "city",
            type = ParameterType.String,
            description = "City name",
            required = true
        )
    )
)
```

## Controlling the loop

| Field          | Default | Meaning                           |
|----------------|---------|-----------------------------------|
| `tools`        | empty   | Tools for this call only          |
| `toolChoice`   | `Auto`  | Whether the model may call a tool |
| `maxToolCalls` | 5       | Cap on calls in one exchange      |

```kotlin theme={null}
val result = RunAnywhere.llm.generate(
    "Weather in Lisbon and Porto?",
    LlmOptions(toolChoice = ToolChoice.Auto, maxToolCalls = 3)
)
```

Tools registered through `tools.register` are offered to every generation. Tools passed in
`options.tools` apply to that call alone.

## Which models can do this

Tool calling needs a model with enough context to hold the tool definitions. The SDK gates on
context length rather than a model allowlist, so any model with a large enough window can
participate, though instruction-tuned models trained on tool use do it far more reliably.

## Removing

```kotlin theme={null}
RunAnywhere.llm.tools.unregister("get_weather")
```

## Inspecting

```kotlin theme={null}
val registered = RunAnywhere.llm.tools.list()
```
