> Retained Kotlin guide from JetBrains/Koog, version family 1.3.0 / 1.3.0-beta. See [source caveats](../../../version-and-migration.md) before adapting snippets.

# GOAP agents

[beta](../../snippets/versioning-snippets.md#beta)

GOAP is an algorithmic planning approach that uses [A* search] find optimal action sequences
that satisfy the goal conditions while minimizing the total cost.
Unlike [LLM-based planners](llm-based-planners.md) that use an LLM to generate plans,
a GOAP agent algorithmically discovers action sequences based on predefined goals and actions.

GOAP planners work with three main concepts:

- **State**: Represents the current state of the world.
- **Actions**: Define what can be done, including preconditions, effects (beliefs), costs, and execution logic.
- **Goals**: Define target conditions, heuristic costs, and value functions.

??? note "Prerequisites"

    [prerequisites](../../snippets/quickstart-snippets.md#prerequisites)

    [dependencies](../../snippets/quickstart-snippets.md#dependencies)

    [api-key](../../snippets/quickstart-snippets.md#api-key)

    Examples on this page assume that you have set the `OPENAI_API_KEY` environment variable.

In Koog, you define a GOAP agent using a DSL by declaratively specifying the goals and actions.

To create a GOAP agent, you need to:

1. Define the state as a data class with properties representing various aspects specific to your goal.
2. Create a [GOAPPlanner](../../../api/planners.md#aikoogagentsplannergoapgoapplanner) instance using the goap() function.
    1. Define actions with preconditions and beliefs using the [action()](../../../api/planners.md#aikoogagentsplannergoapgoapplannerbuilderaction) function.
    2. Define goals with completion conditions using the [goal()](../../../api/planners.md#aikoogagentsplannergoapgoapplannerbuildergoal) function.
3. Wrap the planner with AIAgentPlannerStrategy and pass it to the PlannerAIAgent constructor.

!!! note

    The planner selects individual actions and their sequence.
    Each action includes a precondition that must hold true for the action to be executed
    and a belief that defines the predicted outcome.
    For more information about beliefs, see [State beliefs compared to actual execution](#state-beliefs-compared-to-actual-execution).

In the following example, GOAP handles high-level planning for creating an article
(outline → draft → review → publish),
while the LLM performs the actual content generation within each action.

=== "Kotlin"

    
    ```kotlin
    // Define a state for content creation
    data class ContentState(
        val topic: String,
        val hasOutline: Boolean = false,
        val outline: String = "",
        val hasDraft: Boolean = false,
        val draft: String = "",
        val hasReview: Boolean = false,
        val isPublished: Boolean = false
    ): GoapAgentState<String, String>() {
        override val agentInput = topic
        override fun provideOutput(): String = draft
    }

    // Create GOAP planner with LLM-powered actions
    val planner = goap("content-planner", ::ContentState) {
        // Define actions with preconditions and beliefs
        action(
            name = "Create outline",
            precondition = { state -> !state.hasOutline },
            belief = { state -> state.copy(hasOutline = true, outline = "Outline") },
            cost = { 1.0 }
        ) { ctx, state ->
            // Use LLM to create the outline
            val response = ctx.llm.writeSession {
                appendPrompt {
                    user("Create a detailed outline for an article about: ${state.topic}")
                }
                requestLLM()
            }
            state.copy(hasOutline = true, outline = response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text })
        }

        action(
            name = "Write draft",
            precondition = { state -> state.hasOutline && !state.hasDraft },
            belief = { state -> state.copy(hasDraft = true, draft = "Draft") },
            cost = { 2.0 }
        ) { ctx, state ->
            // Use LLM to write the draft
            val response = ctx.llm.writeSession {
                appendPrompt {
                    user("Write an article based on this outline:\n${state.outline}")
                }
                requestLLM()
            }
            state.copy(hasDraft = true, draft = response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text })
        }

        action(
            name = "Review content",
            precondition = { state -> state.hasDraft && !state.hasReview },
            belief = { state -> state.copy(hasReview = true) },
            cost = { 1.0 }
        ) { ctx, state ->
            // Use LLM to review the draft
            val response = ctx.llm.writeSession {
                appendPrompt {
                    user("Review this article and suggest improvements:\n${state.draft}")
                }
                requestLLM()
            }
            println("Review feedback: ${response.parts.filterIsInstance<MessagePart.Text>().joinToString("\n") { it.text }}")
            state.copy(hasReview = true)
        }

        action(
            name = "Publish",
            precondition = { state -> state.hasReview && !state.isPublished },
            belief = { state -> state.copy(isPublished = true) },
            cost = { 1.0 }
        ) { ctx, state ->
            println("Publishing article...")
            state.copy(isPublished = true)
        }

        // Define the goal with a completion condition
        goal(
            name = "Published article",
            description = "Complete and publish the article",
            condition = { state -> state.isPublished }
        )
    }

    // Create and run the agent
    val agentConfig = AIAgentConfig(
        prompt = prompt("writer") {
            system("You are a professional content writer.")
        },
        model = OpenAIModels.Chat.GPT4o,
        maxAgentIterations = 20
    )

    val agent = AIAgent(
        promptExecutor = simpleOpenAIExecutor(System.getenv("OPENAI_API_KEY")),
        strategy = planner,
        agentConfig = agentConfig
    )

    suspend fun main() {
        val result = agent.run("The Future of AI in Software Development")
        println("Final state: $result")
    }
    ```
    

## Custom cost functions

As [A* search] uses cost as a factor in finding the optimal sequence of actions,
you can define custom cost functions for actions and goals to guide the planner:

=== "Kotlin"

    
    
    ```kotlin
    action(
        name = "Expensive operation",
        precondition = { true },
        belief = { state -> state.copy(operationDone = true) },
        cost = { state ->
            // Dynamic cost based on state
            if (state.hasOptimization) 1.0 else 10.0
        }
    ) { ctx, state ->
        // Execute action
        state.copy(operationDone = true)
    }
    ```
    

## State beliefs compared to actual execution

GOAP distinguishes between the concepts of beliefs (optimistic predictions) and actual execution:

- **Belief**: What the planner thinks will happen, used for planning.
- **Execution**: What actually happens, used for real state updates.

This allows the planner to make plans based on expected outcomes while handling actual results properly:

=== "Kotlin"

    
    
    ```kotlin
    action(
        name = "Attempt complex task",
        precondition = { state -> !state.taskComplete },
        belief = { state ->
            // Optimistic belief: task will succeed
            state.copy(taskComplete = true)
        },
        cost = { 5.0 }
    ) { ctx, state ->
        // Actual execution might fail or have different results
        val success = performComplexTask()
        state.copy(
            taskComplete = success,
            attempts = state.attempts + 1
        )
    }
    ```
    

[A* search]: #
## Complete Kotlin examples

- [example-goap-agents-01.kt](../../../kotlin-examples/example-goap-agents-01.kt)
- [example-goap-agents-02.kt](../../../kotlin-examples/example-goap-agents-02.kt)
- [example-goap-agents-03.kt](../../../kotlin-examples/example-goap-agents-03.kt)
