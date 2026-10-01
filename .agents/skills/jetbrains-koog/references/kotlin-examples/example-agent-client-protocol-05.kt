// Kotlin reference adapted from the supplied Koog 1.3.0 guide examples.
// See ../kotlin-examples.md for scope, dependencies, and validation status.
package ai.koog.agents.example.exampleAgentClientProtocol05

import ai.koog.agents.core.dsl.builder.strategy
import ai.koog.agents.core.dsl.builder.node
import ai.koog.agents.features.acp.withAcpAgent
import com.agentclientprotocol.common.Event
import com.agentclientprotocol.model.Plan
import com.agentclientprotocol.model.SessionUpdate
import com.agentclientprotocol.protocol.sendRequest

val plan: Plan = TODO()

val strategy = strategy<Unit, Unit>("my-strategy") {
    val node by node<Unit, Unit> {
        withAcpAgent {
            sendEvent(
                Event.SessionUpdateEvent(
                    SessionUpdate.PlanUpdate(plan.entries)
                )
            )
        }
    }
}
