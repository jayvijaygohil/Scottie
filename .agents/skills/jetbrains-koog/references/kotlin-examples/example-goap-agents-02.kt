// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleGoapAgents02

import ai.koog.agents.planner.goap.GoapAgentState
import ai.koog.agents.planner.goap
data class MyState(
    val topic: String,
    val operationDone: Boolean = true,
    val hasOptimization: Boolean = true
): GoapAgentState<String, String>() {
    override val agentInput = topic
    override fun provideOutput(): String = ""
}
val planner = goap("content-planner", ::MyState) {

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
}
