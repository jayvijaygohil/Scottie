# Implementation examples

These Kotlin patterns are adapted from the supplied 1.3.0 guides and checked against the bundled `1.3.0-SNAPSHOT` declaration text. They were not compiled against a released dependency. Choose an executor/model supported by the target project; examples accept them as parameters so they do not impose credentials or a particular provider. Use [version selection](version-and-migration.md) for stable/beta dependency alignment.

For every supplied Kotlin source example, including imports and peer-file dependencies, use the [complete example index](kotlin-examples.md).

## Typed tool, registry, and basic agent

Requires the Koog core/tool modules and Kotlin serialization setup described in [serialization](serialization.md).

```kotlin
import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.tools.Tool
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.core.tools.annotations.LLMDescription
import ai.koog.prompt.executor.model.PromptExecutor
import ai.koog.prompt.llm.LLModel
import ai.koog.serialization.typeToken
import kotlinx.serialization.Serializable

object Add : Tool<Add.Args, Int>(
    argsType = typeToken<Args>(),
    resultType = typeToken<Int>(),
    name = "add",
    description = "Add two integers."
) {
    @Serializable
    data class Args(
        @property:LLMDescription("First integer") val left: Int,
        @property:LLMDescription("Second integer") val right: Int
    )

    override suspend fun execute(args: Args): Int = args.left + args.right
}

suspend fun answer(executor: PromptExecutor, model: LLModel, input: String): String {
    val agent = AIAgent(
        promptExecutor = executor,
        llmModel = model,
        toolRegistry = ToolRegistry { tool(Add) },
        systemPrompt = "Use add for integer addition.",
        maxIterations = 10
    )
    try {
        return agent.run(input)
    } finally {
        agent.close()
    }
}
```

The caller owns the supplied executor. Check its lifecycle contract before sharing or closing it. For JVM annotation tools, implement `ToolSet`, annotate methods with `@Tool`, and register the instance using `ToolRegistry { tools(instance) }`; the typed `Tool` example also works without reflection.

## Explicit graph tool loop

```kotlin
import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.extension.nodeExecuteTools
import ai.koog.agents.core.dsl.extension.nodeLLMRequest
import ai.koog.agents.core.dsl.extension.nodeLLMSendToolResults
import ai.koog.agents.core.dsl.extension.onTextMessage
import ai.koog.agents.core.dsl.extension.onToolCalls

val toolLoop = strategy<String, String>("tool-loop") {
    val request by nodeLLMRequest()
    val execute by nodeExecuteTools()
    val respond by nodeLLMSendToolResults()

    edge(nodeStart forwardTo request)
    edge(request forwardTo nodeFinish onTextMessage { true })
    edge(request forwardTo execute onToolCalls { true })
    edge(execute forwardTo respond)
    edge(respond forwardTo nodeFinish onTextMessage { true })
    edge(respond forwardTo execute onToolCalls { true })
}
```

Pass `strategy = toolLoop` to the compatible `AIAgent` factory together with its executor/model and tool registry. See [graph contracts](api/graph-dsl.md) for other input/output types and structured/streaming nodes.

## Structured functional strategy

```kotlin
import ai.koog.agents.core.agent.functionalStrategy
import ai.koog.agents.core.tools.annotations.LLMDescription
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    @property:LLMDescription("Temperature in Celsius") val temperature: Int,
    @property:LLMDescription("Weather conditions") val conditions: String
)

val forecastStrategy = functionalStrategy<String, Forecast> { input ->
    val response = requestLLMStructured<Forecast>(input)
    response.getOrThrow().data
}
```

This example propagates a parsing/request failure. Replace that behavior with the application's desired recovery when appropriate. The returned wrapper and correction APIs are in [structured output](api/structured-output.md); request methods are in [sessions](api/sessions.md).

## Mock executor without a provider request

```kotlin
import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.testing.tools.getMockExecutor
import ai.koog.prompt.llm.LLModel

suspend fun verifyGreeting(model: LLModel) {
    val executor = getMockExecutor {
        mockLLMAnswer("Hello!") onRequestContains "greet"
    }
    val agent = AIAgent(promptExecutor = executor, llmModel = model)
    try {
        check(agent.run("Please greet me") == "Hello!")
    } finally {
        agent.close()
        executor.close()
    }
}
```

Use the project's test framework for assertions and coroutine execution. Add tool-call mocks or graph assertions for the behavior under test; a fixed greeting only demonstrates the mock/executor wiring.

## On-Device Android Inference with LiteRT

Requires the Android variant of `ai.koog:prompt-executor-litert-client:1.3.0-beta`. Keep this code in an Android source set.

```kotlin
import ai.koog.prompt.executor.clients.litert.LiteRTClientConfig
import ai.koog.prompt.executor.clients.litert.LiteRTLLMClient
import ai.koog.prompt.executor.clients.litert.LiteRTLLModels
import ai.koog.prompt.executor.llms.MultiLLMPromptExecutor
import ai.koog.prompt.executor.model.PromptExecutor
import com.google.ai.edge.litertlm.Backend

fun createOnDeviceExecutor(modelsDir: String): PromptExecutor {
    val config = LiteRTClientConfig(
        defaultModel = LiteRTLLModels.FunctionGemma,
        modelsPath = modelsDir,
        backend = Backend.CPU()
    )
    val client = LiteRTLLMClient(config)
    return MultiLLMPromptExecutor(client)
}
```

## Programmatic Markdown System Prompt

Requires `ai.koog:prompt-markdown:1.3.0` (or its resolved platform variant).

```kotlin
import ai.koog.prompt.markdown.markdown

val systemPrompt = markdown {
    h1("System Persona")
    +"You are an on-device AI assistant."

    h2("Guidelines")
    bulleted {
        item("Be concise and accurate.")
        item("Format code snippets using fenced code blocks.")
        item("Use tools when available.")
    }
}
```

## Discover skills and build a prompt section

The caller supplies a read-only filesystem provider and absolute roots. Verify the `skills` artifact version from the target dependency metadata; the bundled module version table omits it.

```kotlin
import ai.koog.rag.base.files.FileSystemProvider
import ai.koog.skills.discovery.SkillCollisionPrecedence
import ai.koog.skills.discovery.discoverSkills
import ai.koog.skills.prompt.SkillsPromptFormat
import ai.koog.skills.prompt.generateSkillsPrompt

suspend fun <Path> skillsPrompt(
    fs: FileSystemProvider.ReadOnly<Path>,
    roots: List<String>
): String {
    val skills = discoverSkills(
        fs = fs,
        directoriesToSearch = roots,
        maxDepth = 4,
        maxDirectories = 2000,
        precedenceRule = SkillCollisionPrecedence.FIRST_FOUND
    )
    return generateSkillsPrompt(skills, SkillsPromptFormat.XML)
}
```

Include the returned text in the agent's system prompt and register the tools needed to read selected skill files. Execution requires a separately supplied execution tool; discovery alone does not run a script.

## GOAP strategy with a typed state

Requires `ai.koog:agents-planner:1.3.0-beta` or the additions umbrella. This deterministic example demonstrates the state/belief/execution contract without a provider call.

```kotlin
import ai.koog.agents.planner.goap
import ai.koog.agents.planner.goap.GoapAgentState

data class DraftState(
    val topic: String,
    val ready: Boolean = false
) : GoapAgentState<String, String>() {
    override val agentInput: String = topic
    override fun provideOutput(): String = topic
}

val draftStrategy = goap("prepare-draft", ::DraftState) {
    action(
        name = "Prepare",
        precondition = { state -> !state.ready },
        belief = { state -> state.copy(ready = true) }
    ) { _, state ->
        state.copy(ready = true)
    }
    goal(
        name = "Ready",
        description = "Draft preparation is complete",
        condition = { state -> state.ready }
    )
}
```

Pass `draftStrategy` directly as `strategy` to the applicable `AIAgent` factory. It is already an `AIAgentPlannerStrategy`; it does not need another wrapper. For a provider factory example, see [providers and prompts](providers-and-prompts.md).
