> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../../version-and-migration.md) before adapting snippets.

# LLM-based planners

[beta](../../snippets/versioning-snippets.md#beta)

LLM-based planners use LLMs to generate and evaluate plans.
They operate on a string-based state and execute steps through LLM requests.
String-based state means that the agent state is a single string.
At every step, the agent accepts an initial state string and returns the final state string as the result.

??? note "Prerequisites"

    [prerequisites](../../snippets/quickstart-snippets.md#prerequisites)

    [dependencies](../../snippets/quickstart-snippets.md#dependencies)

    [api-key](../../snippets/quickstart-snippets.md#api-key)

    Examples on this page assume that you have set the `OPENAI_API_KEY` environment variable.

Koog provides two simple planners:

- [SimpleLLMPlanner](../../../api/planners.md#aikoogagentsplannerllmsimplellmplanner)
  generates a plan only once at the very beginning and then follows the plan until it is completed.
  To include replanning, extend `SimpleLLMPlanner` and override the `assessPlan` method,
  indicating when the agent should replan.
- [SimpleLLMWithCriticPlanner](../../../api/planners.md#aikoogagentsplannerllmsimplellmwithcriticplanner)
  implements the `assessPlan` method that uses an LLM to check the validity of the plan via an LLM request
  and assess whether the agent should replan.

The following example shows how to create a simple planner agent using `SimpleLLMPlanner`:

=== "Kotlin"

    
    ```kotlin
    // Create the planner
    val planner = SimpleLLMPlanner()

    // Wrap it in a planner strategy
    val strategy = AIAgentPlannerStrategy(
        name = "simple-planner",
        planner = planner
    )

    // Configure the agent
    val agentConfig = AIAgentConfig(
        prompt = prompt("planner") {
            system("You are a helpful planning assistant.")
        },
        model = OpenAIModels.Chat.GPT4o,
        maxAgentIterations = 50
    )

    // Create the planner agent
    val agent = PlannerAIAgent(
        promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_API_KEY")),
        strategy = strategy,
        agentConfig = agentConfig
    )

    suspend fun main() {
        // Run the agent with a task
        val result = agent.run("Create a plan to organize a team meeting")
        println(result)
    }
    ```
    

## Next steps

- Learn about [GOAP agents](goap-agents.md)

## Complete Kotlin examples

- [example-llm-based-planners-01.kt](../../../kotlin-examples/example-llm-based-planners-01.kt)
