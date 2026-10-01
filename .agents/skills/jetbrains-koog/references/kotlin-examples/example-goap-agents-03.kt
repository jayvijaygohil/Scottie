// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGoapAgents03

import ai.koog.agents.planner.goap.GoapAgentState
import ai.koog.agents.planner.goap
data class MyState(
    val topic: String,
    val taskComplete: Boolean = true,
    val attempts: Int = 0
): GoapAgentState<String, String>() {
    override val agentInput = topic
    override fun provideOutput(): String = ""
}
fun performComplexTask(): Boolean = true
val planner = goap("content-planner", ::MyState) {

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
}
