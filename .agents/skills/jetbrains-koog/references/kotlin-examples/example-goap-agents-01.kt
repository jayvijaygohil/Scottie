// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGoapAgents01

import ai.koog.agents.core.agent.AIAgent
import ai.koog.agents.core.agent.config.AIAgentConfig
import ai.koog.agents.planner.goap
import ai.koog.agents.planner.goap.GoapAgentState
import ai.koog.prompt.dsl.prompt
import ai.koog.prompt.message.MessagePart
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor

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
